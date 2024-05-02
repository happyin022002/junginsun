/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByESTVO.java
*@FileTitle : RepairPFMCByESTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.01 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByESTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByESTVO> models = new ArrayList<RepairPFMCByESTVO>();
	
	/* Column Info */
	private String hoCnt = null;
	/* Column Info */
	private String umCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofAmt = null;
	/* Column Info */
	private String ssCnt = null;
	/* Column Info */
	private String urAmt = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String uhCnt = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String deCnt = null;
	/* Column Info */
	private String vtCnt = null;
	/* Column Info */
	private String slAmt = null;
	/* Column Info */
	private String hoAmt = null;
	/* Column Info */
	private String dtlAmt = null;
	/* Column Info */
	private String spCd = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String spNm = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String ntAmt = null;
	/* Column Info */
	private String ssAmt = null;
	/* Column Info */
	private String naCnt = null;
	/* Column Info */
	private String nsAmt = null;
	/* Column Info */
	private String dtlCnt = null;
	/* Column Info */
	private String ceCnt = null;
	/* Column Info */
	private String alCnt = null;
	/* Column Info */
	private String ceAmt = null;
	/* Column Info */
	private String reCnt = null;
	/* Column Info */
	private String estQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String uhAmt = null;
	/* Column Info */
	private String leCnt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String urCnt = null;
	/* Column Info */
	private String umAmt = null;
	/* Column Info */
	private String slCnt = null;
	/* Column Info */
	private String naAmt = null;
	/* Column Info */
	private String vtAmt = null;
	/* Column Info */
	private String hjAmt = null;
	/* Column Info */
	private String tAmt = null;
	/* Column Info */
	private String ntCnt = null;
	/* Column Info */
	private String leAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mnrInpTpCdNm = null;
	/* Column Info */
	private String deAmt = null;
	/* Column Info */
	private String reAmt = null;
	/* Column Info */
	private String aAmt = null;
	/* Column Info */
	private String tAvg = null;
	/* Column Info */
	private String ofCnt = null;
	/* Column Info */
	private String hjCnt = null;
	/* Column Info */
	private String nsCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByESTVO() {}

	public RepairPFMCByESTVO(String ibflag, String pagerows, String hoCnt, String naCnt, String nsAmt, String umCnt, String dtlCnt, String ceCnt, String alCnt, String ceAmt, String reCnt, String ofAmt, String ssCnt, String estQty, String urAmt, String uhAmt, String leCnt, String curr, String uhCnt, String rhq, String vtCnt, String deCnt, String urCnt, String umAmt, String slAmt, String slCnt, String hoAmt, String naAmt, String vtAmt, String dtlAmt, String hjAmt, String tAmt, String spCd, String ntCnt, String leAmt, String ofcCd, String tpsz, String deAmt, String reAmt, String aAmt, String tAvg, String spNm, String ntAmt, String ssAmt, String ofCnt, String hjCnt, String nsCnt, String mnrInpTpCdNm, String acctCd, String month) {
		this.hoCnt = hoCnt;
		this.umCnt = umCnt;
		this.pagerows = pagerows;
		this.ofAmt = ofAmt;
		this.ssCnt = ssCnt;
		this.urAmt = urAmt;
		this.curr = curr;
		this.uhCnt = uhCnt;
		this.rhq = rhq;
		this.deCnt = deCnt;
		this.vtCnt = vtCnt;
		this.slAmt = slAmt;
		this.hoAmt = hoAmt;
		this.dtlAmt = dtlAmt;
		this.spCd = spCd;
		this.tpsz = tpsz;
		this.spNm = spNm;
		this.month = month;
		this.ntAmt = ntAmt;
		this.ssAmt = ssAmt;
		this.naCnt = naCnt;
		this.nsAmt = nsAmt;
		this.dtlCnt = dtlCnt;
		this.ceCnt = ceCnt;
		this.alCnt = alCnt;
		this.ceAmt = ceAmt;
		this.reCnt = reCnt;
		this.estQty = estQty;
		this.ibflag = ibflag;
		this.uhAmt = uhAmt;
		this.leCnt = leCnt;
		this.acctCd = acctCd;
		this.urCnt = urCnt;
		this.umAmt = umAmt;
		this.slCnt = slCnt;
		this.naAmt = naAmt;
		this.vtAmt = vtAmt;
		this.hjAmt = hjAmt;
		this.tAmt = tAmt;
		this.ntCnt = ntCnt;
		this.leAmt = leAmt;
		this.ofcCd = ofcCd;
		this.mnrInpTpCdNm = mnrInpTpCdNm;
		this.deAmt = deAmt;
		this.reAmt = reAmt;
		this.aAmt = aAmt;
		this.tAvg = tAvg;
		this.ofCnt = ofCnt;
		this.hjCnt = hjCnt;
		this.nsCnt = nsCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ho_cnt", getHoCnt());
		this.hashColumns.put("um_cnt", getUmCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("of_amt", getOfAmt());
		this.hashColumns.put("ss_cnt", getSsCnt());
		this.hashColumns.put("ur_amt", getUrAmt());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("uh_cnt", getUhCnt());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("de_cnt", getDeCnt());
		this.hashColumns.put("vt_cnt", getVtCnt());
		this.hashColumns.put("sl_amt", getSlAmt());
		this.hashColumns.put("ho_amt", getHoAmt());
		this.hashColumns.put("dtl_amt", getDtlAmt());
		this.hashColumns.put("sp_cd", getSpCd());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("sp_nm", getSpNm());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("nt_amt", getNtAmt());
		this.hashColumns.put("ss_amt", getSsAmt());
		this.hashColumns.put("na_cnt", getNaCnt());
		this.hashColumns.put("ns_amt", getNsAmt());
		this.hashColumns.put("dtl_cnt", getDtlCnt());
		this.hashColumns.put("ce_cnt", getCeCnt());
		this.hashColumns.put("al_cnt", getAlCnt());
		this.hashColumns.put("ce_amt", getCeAmt());
		this.hashColumns.put("re_cnt", getReCnt());
		this.hashColumns.put("est_qty", getEstQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uh_amt", getUhAmt());
		this.hashColumns.put("le_cnt", getLeCnt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ur_cnt", getUrCnt());
		this.hashColumns.put("um_amt", getUmAmt());
		this.hashColumns.put("sl_cnt", getSlCnt());
		this.hashColumns.put("na_amt", getNaAmt());
		this.hashColumns.put("vt_amt", getVtAmt());
		this.hashColumns.put("hj_amt", getHjAmt());
		this.hashColumns.put("t_amt", getTAmt());
		this.hashColumns.put("nt_cnt", getNtCnt());
		this.hashColumns.put("le_amt", getLeAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mnr_inp_tp_cd_nm", getMnrInpTpCdNm());
		this.hashColumns.put("de_amt", getDeAmt());
		this.hashColumns.put("re_amt", getReAmt());
		this.hashColumns.put("a_amt", getAAmt());
		this.hashColumns.put("t_avg", getTAvg());
		this.hashColumns.put("of_cnt", getOfCnt());
		this.hashColumns.put("hj_cnt", getHjCnt());
		this.hashColumns.put("ns_cnt", getNsCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ho_cnt", "hoCnt");
		this.hashFields.put("um_cnt", "umCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("of_amt", "ofAmt");
		this.hashFields.put("ss_cnt", "ssCnt");
		this.hashFields.put("ur_amt", "urAmt");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("uh_cnt", "uhCnt");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("de_cnt", "deCnt");
		this.hashFields.put("vt_cnt", "vtCnt");
		this.hashFields.put("sl_amt", "slAmt");
		this.hashFields.put("ho_amt", "hoAmt");
		this.hashFields.put("dtl_amt", "dtlAmt");
		this.hashFields.put("sp_cd", "spCd");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("sp_nm", "spNm");
		this.hashFields.put("month", "month");
		this.hashFields.put("nt_amt", "ntAmt");
		this.hashFields.put("ss_amt", "ssAmt");
		this.hashFields.put("na_cnt", "naCnt");
		this.hashFields.put("ns_amt", "nsAmt");
		this.hashFields.put("dtl_cnt", "dtlCnt");
		this.hashFields.put("ce_cnt", "ceCnt");
		this.hashFields.put("al_cnt", "alCnt");
		this.hashFields.put("ce_amt", "ceAmt");
		this.hashFields.put("re_cnt", "reCnt");
		this.hashFields.put("est_qty", "estQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uh_amt", "uhAmt");
		this.hashFields.put("le_cnt", "leCnt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ur_cnt", "urCnt");
		this.hashFields.put("um_amt", "umAmt");
		this.hashFields.put("sl_cnt", "slCnt");
		this.hashFields.put("na_amt", "naAmt");
		this.hashFields.put("vt_amt", "vtAmt");
		this.hashFields.put("hj_amt", "hjAmt");
		this.hashFields.put("t_amt", "tAmt");
		this.hashFields.put("nt_cnt", "ntCnt");
		this.hashFields.put("le_amt", "leAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mnr_inp_tp_cd_nm", "mnrInpTpCdNm");
		this.hashFields.put("de_amt", "deAmt");
		this.hashFields.put("re_amt", "reAmt");
		this.hashFields.put("a_amt", "aAmt");
		this.hashFields.put("t_avg", "tAvg");
		this.hashFields.put("of_cnt", "ofCnt");
		this.hashFields.put("hj_cnt", "hjCnt");
		this.hashFields.put("ns_cnt", "nsCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hoCnt
	 */
	public String getHoCnt() {
		return this.hoCnt;
	}
	
	/**
	 * Column Info
	 * @return umCnt
	 */
	public String getUmCnt() {
		return this.umCnt;
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
	 * @return ofAmt
	 */
	public String getOfAmt() {
		return this.ofAmt;
	}
	
	/**
	 * Column Info
	 * @return ssCnt
	 */
	public String getSsCnt() {
		return this.ssCnt;
	}
	
	/**
	 * Column Info
	 * @return urAmt
	 */
	public String getUrAmt() {
		return this.urAmt;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return uhCnt
	 */
	public String getUhCnt() {
		return this.uhCnt;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return deCnt
	 */
	public String getDeCnt() {
		return this.deCnt;
	}
	
	/**
	 * Column Info
	 * @return vtCnt
	 */
	public String getVtCnt() {
		return this.vtCnt;
	}
	
	/**
	 * Column Info
	 * @return slAmt
	 */
	public String getSlAmt() {
		return this.slAmt;
	}
	
	/**
	 * Column Info
	 * @return hoAmt
	 */
	public String getHoAmt() {
		return this.hoAmt;
	}
	
	/**
	 * Column Info
	 * @return dtlAmt
	 */
	public String getDtlAmt() {
		return this.dtlAmt;
	}
	
	/**
	 * Column Info
	 * @return spCd
	 */
	public String getSpCd() {
		return this.spCd;
	}
	
	/**
	 * Column Info
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return spNm
	 */
	public String getSpNm() {
		return this.spNm;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return ntAmt
	 */
	public String getNtAmt() {
		return this.ntAmt;
	}
	
	/**
	 * Column Info
	 * @return ssAmt
	 */
	public String getSsAmt() {
		return this.ssAmt;
	}
	
	/**
	 * Column Info
	 * @return naCnt
	 */
	public String getNaCnt() {
		return this.naCnt;
	}
	
	/**
	 * Column Info
	 * @return nsAmt
	 */
	public String getNsAmt() {
		return this.nsAmt;
	}
	
	/**
	 * Column Info
	 * @return dtlCnt
	 */
	public String getDtlCnt() {
		return this.dtlCnt;
	}
	
	/**
	 * Column Info
	 * @return ceCnt
	 */
	public String getCeCnt() {
		return this.ceCnt;
	}
	
	/**
	 * Column Info
	 * @return alCnt
	 */
	public String getAlCnt() {
		return this.alCnt;
	}
	
	/**
	 * Column Info
	 * @return ceAmt
	 */
	public String getCeAmt() {
		return this.ceAmt;
	}
	
	/**
	 * Column Info
	 * @return reCnt
	 */
	public String getReCnt() {
		return this.reCnt;
	}
	
	/**
	 * Column Info
	 * @return estQty
	 */
	public String getEstQty() {
		return this.estQty;
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
	 * @return uhAmt
	 */
	public String getUhAmt() {
		return this.uhAmt;
	}
	
	/**
	 * Column Info
	 * @return leCnt
	 */
	public String getLeCnt() {
		return this.leCnt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return urCnt
	 */
	public String getUrCnt() {
		return this.urCnt;
	}
	
	/**
	 * Column Info
	 * @return umAmt
	 */
	public String getUmAmt() {
		return this.umAmt;
	}
	
	/**
	 * Column Info
	 * @return slCnt
	 */
	public String getSlCnt() {
		return this.slCnt;
	}
	
	/**
	 * Column Info
	 * @return naAmt
	 */
	public String getNaAmt() {
		return this.naAmt;
	}
	
	/**
	 * Column Info
	 * @return vtAmt
	 */
	public String getVtAmt() {
		return this.vtAmt;
	}
	
	/**
	 * Column Info
	 * @return hjAmt
	 */
	public String getHjAmt() {
		return this.hjAmt;
	}
	
	/**
	 * Column Info
	 * @return tAmt
	 */
	public String getTAmt() {
		return this.tAmt;
	}
	
	/**
	 * Column Info
	 * @return ntCnt
	 */
	public String getNtCnt() {
		return this.ntCnt;
	}
	
	/**
	 * Column Info
	 * @return leAmt
	 */
	public String getLeAmt() {
		return this.leAmt;
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
	 * @return mnrInpTpCdNm
	 */
	public String getMnrInpTpCdNm() {
		return this.mnrInpTpCdNm;
	}
	
	/**
	 * Column Info
	 * @return deAmt
	 */
	public String getDeAmt() {
		return this.deAmt;
	}
	
	/**
	 * Column Info
	 * @return reAmt
	 */
	public String getReAmt() {
		return this.reAmt;
	}
	
	/**
	 * Column Info
	 * @return aAmt
	 */
	public String getAAmt() {
		return this.aAmt;
	}
	
	/**
	 * Column Info
	 * @return tAvg
	 */
	public String getTAvg() {
		return this.tAvg;
	}
	
	/**
	 * Column Info
	 * @return ofCnt
	 */
	public String getOfCnt() {
		return this.ofCnt;
	}
	
	/**
	 * Column Info
	 * @return hjCnt
	 */
	public String getHjCnt() {
		return this.hjCnt;
	}
	
	/**
	 * Column Info
	 * @return nsCnt
	 */
	public String getNsCnt() {
		return this.nsCnt;
	}
	

	/**
	 * Column Info
	 * @param hoCnt
	 */
	public void setHoCnt(String hoCnt) {
		this.hoCnt = hoCnt;
	}
	
	/**
	 * Column Info
	 * @param umCnt
	 */
	public void setUmCnt(String umCnt) {
		this.umCnt = umCnt;
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
	 * @param ofAmt
	 */
	public void setOfAmt(String ofAmt) {
		this.ofAmt = ofAmt;
	}
	
	/**
	 * Column Info
	 * @param ssCnt
	 */
	public void setSsCnt(String ssCnt) {
		this.ssCnt = ssCnt;
	}
	
	/**
	 * Column Info
	 * @param urAmt
	 */
	public void setUrAmt(String urAmt) {
		this.urAmt = urAmt;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param uhCnt
	 */
	public void setUhCnt(String uhCnt) {
		this.uhCnt = uhCnt;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param deCnt
	 */
	public void setDeCnt(String deCnt) {
		this.deCnt = deCnt;
	}
	
	/**
	 * Column Info
	 * @param vtCnt
	 */
	public void setVtCnt(String vtCnt) {
		this.vtCnt = vtCnt;
	}
	
	/**
	 * Column Info
	 * @param slAmt
	 */
	public void setSlAmt(String slAmt) {
		this.slAmt = slAmt;
	}
	
	/**
	 * Column Info
	 * @param hoAmt
	 */
	public void setHoAmt(String hoAmt) {
		this.hoAmt = hoAmt;
	}
	
	/**
	 * Column Info
	 * @param dtlAmt
	 */
	public void setDtlAmt(String dtlAmt) {
		this.dtlAmt = dtlAmt;
	}
	
	/**
	 * Column Info
	 * @param spCd
	 */
	public void setSpCd(String spCd) {
		this.spCd = spCd;
	}
	
	/**
	 * Column Info
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param spNm
	 */
	public void setSpNm(String spNm) {
		this.spNm = spNm;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param ntAmt
	 */
	public void setNtAmt(String ntAmt) {
		this.ntAmt = ntAmt;
	}
	
	/**
	 * Column Info
	 * @param ssAmt
	 */
	public void setSsAmt(String ssAmt) {
		this.ssAmt = ssAmt;
	}
	
	/**
	 * Column Info
	 * @param naCnt
	 */
	public void setNaCnt(String naCnt) {
		this.naCnt = naCnt;
	}
	
	/**
	 * Column Info
	 * @param nsAmt
	 */
	public void setNsAmt(String nsAmt) {
		this.nsAmt = nsAmt;
	}
	
	/**
	 * Column Info
	 * @param dtlCnt
	 */
	public void setDtlCnt(String dtlCnt) {
		this.dtlCnt = dtlCnt;
	}
	
	/**
	 * Column Info
	 * @param ceCnt
	 */
	public void setCeCnt(String ceCnt) {
		this.ceCnt = ceCnt;
	}
	
	/**
	 * Column Info
	 * @param alCnt
	 */
	public void setAlCnt(String alCnt) {
		this.alCnt = alCnt;
	}
	
	/**
	 * Column Info
	 * @param ceAmt
	 */
	public void setCeAmt(String ceAmt) {
		this.ceAmt = ceAmt;
	}
	
	/**
	 * Column Info
	 * @param reCnt
	 */
	public void setReCnt(String reCnt) {
		this.reCnt = reCnt;
	}
	
	/**
	 * Column Info
	 * @param estQty
	 */
	public void setEstQty(String estQty) {
		this.estQty = estQty;
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
	 * @param uhAmt
	 */
	public void setUhAmt(String uhAmt) {
		this.uhAmt = uhAmt;
	}
	
	/**
	 * Column Info
	 * @param leCnt
	 */
	public void setLeCnt(String leCnt) {
		this.leCnt = leCnt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param urCnt
	 */
	public void setUrCnt(String urCnt) {
		this.urCnt = urCnt;
	}
	
	/**
	 * Column Info
	 * @param umAmt
	 */
	public void setUmAmt(String umAmt) {
		this.umAmt = umAmt;
	}
	
	/**
	 * Column Info
	 * @param slCnt
	 */
	public void setSlCnt(String slCnt) {
		this.slCnt = slCnt;
	}
	
	/**
	 * Column Info
	 * @param naAmt
	 */
	public void setNaAmt(String naAmt) {
		this.naAmt = naAmt;
	}
	
	/**
	 * Column Info
	 * @param vtAmt
	 */
	public void setVtAmt(String vtAmt) {
		this.vtAmt = vtAmt;
	}
	
	/**
	 * Column Info
	 * @param hjAmt
	 */
	public void setHjAmt(String hjAmt) {
		this.hjAmt = hjAmt;
	}
	
	/**
	 * Column Info
	 * @param tAmt
	 */
	public void setTAmt(String tAmt) {
		this.tAmt = tAmt;
	}
	
	/**
	 * Column Info
	 * @param ntCnt
	 */
	public void setNtCnt(String ntCnt) {
		this.ntCnt = ntCnt;
	}
	
	/**
	 * Column Info
	 * @param leAmt
	 */
	public void setLeAmt(String leAmt) {
		this.leAmt = leAmt;
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
	 * @param mnrInpTpCdNm
	 */
	public void setMnrInpTpCdNm(String mnrInpTpCdNm) {
		this.mnrInpTpCdNm = mnrInpTpCdNm;
	}
	
	/**
	 * Column Info
	 * @param deAmt
	 */
	public void setDeAmt(String deAmt) {
		this.deAmt = deAmt;
	}
	
	/**
	 * Column Info
	 * @param reAmt
	 */
	public void setReAmt(String reAmt) {
		this.reAmt = reAmt;
	}
	
	/**
	 * Column Info
	 * @param aAmt
	 */
	public void setAAmt(String aAmt) {
		this.aAmt = aAmt;
	}
	
	/**
	 * Column Info
	 * @param tAvg
	 */
	public void setTAvg(String tAvg) {
		this.tAvg = tAvg;
	}
	
	/**
	 * Column Info
	 * @param ofCnt
	 */
	public void setOfCnt(String ofCnt) {
		this.ofCnt = ofCnt;
	}
	
	/**
	 * Column Info
	 * @param hjCnt
	 */
	public void setHjCnt(String hjCnt) {
		this.hjCnt = hjCnt;
	}
	
	/**
	 * Column Info
	 * @param nsCnt
	 */
	public void setNsCnt(String nsCnt) {
		this.nsCnt = nsCnt;
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
		setHoCnt(JSPUtil.getParameter(request, prefix + "ho_cnt", ""));
		setUmCnt(JSPUtil.getParameter(request, prefix + "um_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfAmt(JSPUtil.getParameter(request, prefix + "of_amt", ""));
		setSsCnt(JSPUtil.getParameter(request, prefix + "ss_cnt", ""));
		setUrAmt(JSPUtil.getParameter(request, prefix + "ur_amt", ""));
		setCurr(JSPUtil.getParameter(request, prefix + "curr", ""));
		setUhCnt(JSPUtil.getParameter(request, prefix + "uh_cnt", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setDeCnt(JSPUtil.getParameter(request, prefix + "de_cnt", ""));
		setVtCnt(JSPUtil.getParameter(request, prefix + "vt_cnt", ""));
		setSlAmt(JSPUtil.getParameter(request, prefix + "sl_amt", ""));
		setHoAmt(JSPUtil.getParameter(request, prefix + "ho_amt", ""));
		setDtlAmt(JSPUtil.getParameter(request, prefix + "dtl_amt", ""));
		setSpCd(JSPUtil.getParameter(request, prefix + "sp_cd", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setSpNm(JSPUtil.getParameter(request, prefix + "sp_nm", ""));
		setMonth(JSPUtil.getParameter(request, prefix + "month", ""));
		setNtAmt(JSPUtil.getParameter(request, prefix + "nt_amt", ""));
		setSsAmt(JSPUtil.getParameter(request, prefix + "ss_amt", ""));
		setNaCnt(JSPUtil.getParameter(request, prefix + "na_cnt", ""));
		setNsAmt(JSPUtil.getParameter(request, prefix + "ns_amt", ""));
		setDtlCnt(JSPUtil.getParameter(request, prefix + "dtl_cnt", ""));
		setCeCnt(JSPUtil.getParameter(request, prefix + "ce_cnt", ""));
		setAlCnt(JSPUtil.getParameter(request, prefix + "al_cnt", ""));
		setCeAmt(JSPUtil.getParameter(request, prefix + "ce_amt", ""));
		setReCnt(JSPUtil.getParameter(request, prefix + "re_cnt", ""));
		setEstQty(JSPUtil.getParameter(request, prefix + "est_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUhAmt(JSPUtil.getParameter(request, prefix + "uh_amt", ""));
		setLeCnt(JSPUtil.getParameter(request, prefix + "le_cnt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setUrCnt(JSPUtil.getParameter(request, prefix + "ur_cnt", ""));
		setUmAmt(JSPUtil.getParameter(request, prefix + "um_amt", ""));
		setSlCnt(JSPUtil.getParameter(request, prefix + "sl_cnt", ""));
		setNaAmt(JSPUtil.getParameter(request, prefix + "na_amt", ""));
		setVtAmt(JSPUtil.getParameter(request, prefix + "vt_amt", ""));
		setHjAmt(JSPUtil.getParameter(request, prefix + "hj_amt", ""));
		setTAmt(JSPUtil.getParameter(request, prefix + "t_amt", ""));
		setNtCnt(JSPUtil.getParameter(request, prefix + "nt_cnt", ""));
		setLeAmt(JSPUtil.getParameter(request, prefix + "le_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMnrInpTpCdNm(JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd_nm", ""));
		setDeAmt(JSPUtil.getParameter(request, prefix + "de_amt", ""));
		setReAmt(JSPUtil.getParameter(request, prefix + "re_amt", ""));
		setAAmt(JSPUtil.getParameter(request, prefix + "a_amt", ""));
		setTAvg(JSPUtil.getParameter(request, prefix + "t_avg", ""));
		setOfCnt(JSPUtil.getParameter(request, prefix + "of_cnt", ""));
		setHjCnt(JSPUtil.getParameter(request, prefix + "hj_cnt", ""));
		setNsCnt(JSPUtil.getParameter(request, prefix + "ns_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByESTVO[]
	 */
	public RepairPFMCByESTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByESTVO[]
	 */
	public RepairPFMCByESTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByESTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hoCnt = (JSPUtil.getParameter(request, prefix	+ "ho_cnt", length));
			String[] umCnt = (JSPUtil.getParameter(request, prefix	+ "um_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofAmt = (JSPUtil.getParameter(request, prefix	+ "of_amt", length));
			String[] ssCnt = (JSPUtil.getParameter(request, prefix	+ "ss_cnt", length));
			String[] urAmt = (JSPUtil.getParameter(request, prefix	+ "ur_amt", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] uhCnt = (JSPUtil.getParameter(request, prefix	+ "uh_cnt", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] deCnt = (JSPUtil.getParameter(request, prefix	+ "de_cnt", length));
			String[] vtCnt = (JSPUtil.getParameter(request, prefix	+ "vt_cnt", length));
			String[] slAmt = (JSPUtil.getParameter(request, prefix	+ "sl_amt", length));
			String[] hoAmt = (JSPUtil.getParameter(request, prefix	+ "ho_amt", length));
			String[] dtlAmt = (JSPUtil.getParameter(request, prefix	+ "dtl_amt", length));
			String[] spCd = (JSPUtil.getParameter(request, prefix	+ "sp_cd", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] spNm = (JSPUtil.getParameter(request, prefix	+ "sp_nm", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] ntAmt = (JSPUtil.getParameter(request, prefix	+ "nt_amt", length));
			String[] ssAmt = (JSPUtil.getParameter(request, prefix	+ "ss_amt", length));
			String[] naCnt = (JSPUtil.getParameter(request, prefix	+ "na_cnt", length));
			String[] nsAmt = (JSPUtil.getParameter(request, prefix	+ "ns_amt", length));
			String[] dtlCnt = (JSPUtil.getParameter(request, prefix	+ "dtl_cnt", length));
			String[] ceCnt = (JSPUtil.getParameter(request, prefix	+ "ce_cnt", length));
			String[] alCnt = (JSPUtil.getParameter(request, prefix	+ "al_cnt", length));
			String[] ceAmt = (JSPUtil.getParameter(request, prefix	+ "ce_amt", length));
			String[] reCnt = (JSPUtil.getParameter(request, prefix	+ "re_cnt", length));
			String[] estQty = (JSPUtil.getParameter(request, prefix	+ "est_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] uhAmt = (JSPUtil.getParameter(request, prefix	+ "uh_amt", length));
			String[] leCnt = (JSPUtil.getParameter(request, prefix	+ "le_cnt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] urCnt = (JSPUtil.getParameter(request, prefix	+ "ur_cnt", length));
			String[] umAmt = (JSPUtil.getParameter(request, prefix	+ "um_amt", length));
			String[] slCnt = (JSPUtil.getParameter(request, prefix	+ "sl_cnt", length));
			String[] naAmt = (JSPUtil.getParameter(request, prefix	+ "na_amt", length));
			String[] vtAmt = (JSPUtil.getParameter(request, prefix	+ "vt_amt", length));
			String[] hjAmt = (JSPUtil.getParameter(request, prefix	+ "hj_amt", length));
			String[] tAmt = (JSPUtil.getParameter(request, prefix	+ "t_amt", length));
			String[] ntCnt = (JSPUtil.getParameter(request, prefix	+ "nt_cnt", length));
			String[] leAmt = (JSPUtil.getParameter(request, prefix	+ "le_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mnrInpTpCdNm = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd_nm", length));
			String[] deAmt = (JSPUtil.getParameter(request, prefix	+ "de_amt", length));
			String[] reAmt = (JSPUtil.getParameter(request, prefix	+ "re_amt", length));
			String[] aAmt = (JSPUtil.getParameter(request, prefix	+ "a_amt", length));
			String[] tAvg = (JSPUtil.getParameter(request, prefix	+ "t_avg", length));
			String[] ofCnt = (JSPUtil.getParameter(request, prefix	+ "of_cnt", length));
			String[] hjCnt = (JSPUtil.getParameter(request, prefix	+ "hj_cnt", length));
			String[] nsCnt = (JSPUtil.getParameter(request, prefix	+ "ns_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByESTVO();
				if (hoCnt[i] != null)
					model.setHoCnt(hoCnt[i]);
				if (umCnt[i] != null)
					model.setUmCnt(umCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofAmt[i] != null)
					model.setOfAmt(ofAmt[i]);
				if (ssCnt[i] != null)
					model.setSsCnt(ssCnt[i]);
				if (urAmt[i] != null)
					model.setUrAmt(urAmt[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (uhCnt[i] != null)
					model.setUhCnt(uhCnt[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (deCnt[i] != null)
					model.setDeCnt(deCnt[i]);
				if (vtCnt[i] != null)
					model.setVtCnt(vtCnt[i]);
				if (slAmt[i] != null)
					model.setSlAmt(slAmt[i]);
				if (hoAmt[i] != null)
					model.setHoAmt(hoAmt[i]);
				if (dtlAmt[i] != null)
					model.setDtlAmt(dtlAmt[i]);
				if (spCd[i] != null)
					model.setSpCd(spCd[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (spNm[i] != null)
					model.setSpNm(spNm[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (ntAmt[i] != null)
					model.setNtAmt(ntAmt[i]);
				if (ssAmt[i] != null)
					model.setSsAmt(ssAmt[i]);
				if (naCnt[i] != null)
					model.setNaCnt(naCnt[i]);
				if (nsAmt[i] != null)
					model.setNsAmt(nsAmt[i]);
				if (dtlCnt[i] != null)
					model.setDtlCnt(dtlCnt[i]);
				if (ceCnt[i] != null)
					model.setCeCnt(ceCnt[i]);
				if (alCnt[i] != null)
					model.setAlCnt(alCnt[i]);
				if (ceAmt[i] != null)
					model.setCeAmt(ceAmt[i]);
				if (reCnt[i] != null)
					model.setReCnt(reCnt[i]);
				if (estQty[i] != null)
					model.setEstQty(estQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (uhAmt[i] != null)
					model.setUhAmt(uhAmt[i]);
				if (leCnt[i] != null)
					model.setLeCnt(leCnt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (urCnt[i] != null)
					model.setUrCnt(urCnt[i]);
				if (umAmt[i] != null)
					model.setUmAmt(umAmt[i]);
				if (slCnt[i] != null)
					model.setSlCnt(slCnt[i]);
				if (naAmt[i] != null)
					model.setNaAmt(naAmt[i]);
				if (vtAmt[i] != null)
					model.setVtAmt(vtAmt[i]);
				if (hjAmt[i] != null)
					model.setHjAmt(hjAmt[i]);
				if (tAmt[i] != null)
					model.setTAmt(tAmt[i]);
				if (ntCnt[i] != null)
					model.setNtCnt(ntCnt[i]);
				if (leAmt[i] != null)
					model.setLeAmt(leAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mnrInpTpCdNm[i] != null)
					model.setMnrInpTpCdNm(mnrInpTpCdNm[i]);
				if (deAmt[i] != null)
					model.setDeAmt(deAmt[i]);
				if (reAmt[i] != null)
					model.setReAmt(reAmt[i]);
				if (aAmt[i] != null)
					model.setAAmt(aAmt[i]);
				if (tAvg[i] != null)
					model.setTAvg(tAvg[i]);
				if (ofCnt[i] != null)
					model.setOfCnt(ofCnt[i]);
				if (hjCnt[i] != null)
					model.setHjCnt(hjCnt[i]);
				if (nsCnt[i] != null)
					model.setNsCnt(nsCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByESTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByESTVO[]
	 */
	public RepairPFMCByESTVO[] getRepairPFMCByESTVOs(){
		RepairPFMCByESTVO[] vos = (RepairPFMCByESTVO[])models.toArray(new RepairPFMCByESTVO[models.size()]);
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
		this.hoCnt = this.hoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umCnt = this.umCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofAmt = this.ofAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssCnt = this.ssCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urAmt = this.urAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uhCnt = this.uhCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deCnt = this.deCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vtCnt = this.vtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slAmt = this.slAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hoAmt = this.hoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlAmt = this.dtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCd = this.spCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spNm = this.spNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntAmt = this.ntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssAmt = this.ssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naCnt = this.naCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nsAmt = this.nsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlCnt = this.dtlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceCnt = this.ceCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alCnt = this.alCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceAmt = this.ceAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reCnt = this.reCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estQty = this.estQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uhAmt = this.uhAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leCnt = this.leCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urCnt = this.urCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umAmt = this.umAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slCnt = this.slCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naAmt = this.naAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vtAmt = this.vtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjAmt = this.hjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAmt = this.tAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntCnt = this.ntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leAmt = this.leAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCdNm = this.mnrInpTpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deAmt = this.deAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reAmt = this.reAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aAmt = this.aAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAvg = this.tAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofCnt = this.ofCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjCnt = this.hjCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nsCnt = this.nsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
