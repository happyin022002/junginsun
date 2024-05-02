/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SlipPerformanceVO.java
*@FileTitle : SlipPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
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

public class SlipPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlipPerformanceVO> models = new ArrayList<SlipPerformanceVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String abbrNm = null;
	/* Column Info */
	private String slpSplrNm = null;
	/* Column Info */
	private String slpAmt1 = null;
	/* Column Info */
	private String slpCurrCd = null;
	/* Column Info */
	private String crdShopNm = null;
	/* Column Info */
	private String slpDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crCrdUsrNm = null;
	/* Column Info */
	private String slpSeqNo1 = null;
	/* Column Info */
	private String chaRatio1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slpVndrCd = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpTjNo1 = null;
	/* Column Info */
	private String slpTjNo = null;
	/* Column Info */
	private String ratio1 = null;
	/* Column Info */
	private String slpAmt = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String genExpnFnlLoclAmt = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String ticCd1 = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpPerfAmt = null;
	/* Column Info */
	private String glEffDt1 = null;
	/* Column Info */
	private String subGenExpnCd = null;
	/* Column Info */
	private String slpSplrCd = null;
	/* Column Info */
	private String chaRatio = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String subAbbrNm = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String slpDesc1 = null;
	/* Column Info */
	private String slpCurrCd1 = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlipPerformanceVO() {}

	public SlipPerformanceVO(String ibflag, String pagerows, String abbrNm, String slpCurrCd, String slpAmt1, String slpDesc, String slpSeqNo1, String slpTjNo1, String slpTjNo, String ratio1, String slpAmt, String glEffDt, String genExpnFnlLoclAmt, String subOfcCd, String ticCd1, String genExpnCd, String slpSeqNo, String slpPerfAmt, String glEffDt1, String subGenExpnCd, String ofcCd, String subAbbrNm, String ratio, String slpDesc1, String slpCurrCd1, String ticCd, String chaRatio, String chaRatio1, String rowNum, String total, String acctCd, String slpVndrCd, String slpSplrCd, String slpSplrNm, String crCrdUsrNm, String crdShopNm, String ofcCoDivCd) {
		this.total = total;
		this.abbrNm = abbrNm;
		this.slpSplrNm = slpSplrNm;
		this.slpAmt1 = slpAmt1;
		this.slpCurrCd = slpCurrCd;
		this.crdShopNm = crdShopNm;
		this.slpDesc = slpDesc;
		this.pagerows = pagerows;
		this.crCrdUsrNm = crCrdUsrNm;
		this.slpSeqNo1 = slpSeqNo1;
		this.chaRatio1 = chaRatio1;
		this.ibflag = ibflag;
		this.slpVndrCd = slpVndrCd;
		this.ofcCoDivCd = ofcCoDivCd;
		this.acctCd = acctCd;
		this.slpTjNo1 = slpTjNo1;
		this.slpTjNo = slpTjNo;
		this.ratio1 = ratio1;
		this.slpAmt = slpAmt;
		this.glEffDt = glEffDt;
		this.genExpnFnlLoclAmt = genExpnFnlLoclAmt;
		this.subOfcCd = subOfcCd;
		this.ticCd1 = ticCd1;
		this.genExpnCd = genExpnCd;
		this.slpSeqNo = slpSeqNo;
		this.slpPerfAmt = slpPerfAmt;
		this.glEffDt1 = glEffDt1;
		this.subGenExpnCd = subGenExpnCd;
		this.slpSplrCd = slpSplrCd;
		this.chaRatio = chaRatio;
		this.ofcCd = ofcCd;
		this.subAbbrNm = subAbbrNm;
		this.ratio = ratio;
		this.slpDesc1 = slpDesc1;
		this.slpCurrCd1 = slpCurrCd1;
		this.rowNum = rowNum;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("abbr_nm", getAbbrNm());
		this.hashColumns.put("slp_splr_nm", getSlpSplrNm());
		this.hashColumns.put("slp_amt1", getSlpAmt1());
		this.hashColumns.put("slp_curr_cd", getSlpCurrCd());
		this.hashColumns.put("crd_shop_nm", getCrdShopNm());
		this.hashColumns.put("slp_desc", getSlpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cr_crd_usr_nm", getCrCrdUsrNm());
		this.hashColumns.put("slp_seq_no1", getSlpSeqNo1());
		this.hashColumns.put("cha_ratio1", getChaRatio1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slp_vndr_cd", getSlpVndrCd());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_tj_no1", getSlpTjNo1());
		this.hashColumns.put("slp_tj_no", getSlpTjNo());
		this.hashColumns.put("ratio1", getRatio1());
		this.hashColumns.put("slp_amt", getSlpAmt());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("gen_expn_fnl_locl_amt", getGenExpnFnlLoclAmt());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("tic_cd1", getTicCd1());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_perf_amt", getSlpPerfAmt());
		this.hashColumns.put("gl_eff_dt1", getGlEffDt1());
		this.hashColumns.put("sub_gen_expn_cd", getSubGenExpnCd());
		this.hashColumns.put("slp_splr_cd", getSlpSplrCd());
		this.hashColumns.put("cha_ratio", getChaRatio());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sub_abbr_nm", getSubAbbrNm());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("slp_desc1", getSlpDesc1());
		this.hashColumns.put("slp_curr_cd1", getSlpCurrCd1());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("tic_cd", getTicCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("abbr_nm", "abbrNm");
		this.hashFields.put("slp_splr_nm", "slpSplrNm");
		this.hashFields.put("slp_amt1", "slpAmt1");
		this.hashFields.put("slp_curr_cd", "slpCurrCd");
		this.hashFields.put("crd_shop_nm", "crdShopNm");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cr_crd_usr_nm", "crCrdUsrNm");
		this.hashFields.put("slp_seq_no1", "slpSeqNo1");
		this.hashFields.put("cha_ratio1", "chaRatio1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slp_vndr_cd", "slpVndrCd");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_tj_no1", "slpTjNo1");
		this.hashFields.put("slp_tj_no", "slpTjNo");
		this.hashFields.put("ratio1", "ratio1");
		this.hashFields.put("slp_amt", "slpAmt");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("gen_expn_fnl_locl_amt", "genExpnFnlLoclAmt");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("tic_cd1", "ticCd1");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_perf_amt", "slpPerfAmt");
		this.hashFields.put("gl_eff_dt1", "glEffDt1");
		this.hashFields.put("sub_gen_expn_cd", "subGenExpnCd");
		this.hashFields.put("slp_splr_cd", "slpSplrCd");
		this.hashFields.put("cha_ratio", "chaRatio");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sub_abbr_nm", "subAbbrNm");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("slp_desc1", "slpDesc1");
		this.hashFields.put("slp_curr_cd1", "slpCurrCd1");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("tic_cd", "ticCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return abbrNm
	 */
	public String getAbbrNm() {
		return this.abbrNm;
	}
	
	/**
	 * Column Info
	 * @return slpSplrNm
	 */
	public String getSlpSplrNm() {
		return this.slpSplrNm;
	}
	
	/**
	 * Column Info
	 * @return slpAmt1
	 */
	public String getSlpAmt1() {
		return this.slpAmt1;
	}
	
	/**
	 * Column Info
	 * @return slpCurrCd
	 */
	public String getSlpCurrCd() {
		return this.slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @return crdShopNm
	 */
	public String getCrdShopNm() {
		return this.crdShopNm;
	}
	
	/**
	 * Column Info
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return this.slpDesc;
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
	 * @return crCrdUsrNm
	 */
	public String getCrCrdUsrNm() {
		return this.crCrdUsrNm;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo1
	 */
	public String getSlpSeqNo1() {
		return this.slpSeqNo1;
	}
	
	/**
	 * Column Info
	 * @return chaRatio1
	 */
	public String getChaRatio1() {
		return this.chaRatio1;
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
	 * @return slpVndrCd
	 */
	public String getSlpVndrCd() {
		return this.slpVndrCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
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
	 * @return slpTjNo1
	 */
	public String getSlpTjNo1() {
		return this.slpTjNo1;
	}
	
	/**
	 * Column Info
	 * @return slpTjNo
	 */
	public String getSlpTjNo() {
		return this.slpTjNo;
	}
	
	/**
	 * Column Info
	 * @return ratio1
	 */
	public String getRatio1() {
		return this.ratio1;
	}
	
	/**
	 * Column Info
	 * @return slpAmt
	 */
	public String getSlpAmt() {
		return this.slpAmt;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return genExpnFnlLoclAmt
	 */
	public String getGenExpnFnlLoclAmt() {
		return this.genExpnFnlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ticCd1
	 */
	public String getTicCd1() {
		return this.ticCd1;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt
	 */
	public String getSlpPerfAmt() {
		return this.slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @return glEffDt1
	 */
	public String getGlEffDt1() {
		return this.glEffDt1;
	}
	
	/**
	 * Column Info
	 * @return subGenExpnCd
	 */
	public String getSubGenExpnCd() {
		return this.subGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return slpSplrCd
	 */
	public String getSlpSplrCd() {
		return this.slpSplrCd;
	}
	
	/**
	 * Column Info
	 * @return chaRatio
	 */
	public String getChaRatio() {
		return this.chaRatio;
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
	 * @return subAbbrNm
	 */
	public String getSubAbbrNm() {
		return this.subAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return slpDesc1
	 */
	public String getSlpDesc1() {
		return this.slpDesc1;
	}
	
	/**
	 * Column Info
	 * @return slpCurrCd1
	 */
	public String getSlpCurrCd1() {
		return this.slpCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return ticCd
	 */
	public String getTicCd() {
		return this.ticCd;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param abbrNm
	 */
	public void setAbbrNm(String abbrNm) {
		this.abbrNm = abbrNm;
	}
	
	/**
	 * Column Info
	 * @param slpSplrNm
	 */
	public void setSlpSplrNm(String slpSplrNm) {
		this.slpSplrNm = slpSplrNm;
	}
	
	/**
	 * Column Info
	 * @param slpAmt1
	 */
	public void setSlpAmt1(String slpAmt1) {
		this.slpAmt1 = slpAmt1;
	}
	
	/**
	 * Column Info
	 * @param slpCurrCd
	 */
	public void setSlpCurrCd(String slpCurrCd) {
		this.slpCurrCd = slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @param crdShopNm
	 */
	public void setCrdShopNm(String crdShopNm) {
		this.crdShopNm = crdShopNm;
	}
	
	/**
	 * Column Info
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
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
	 * @param crCrdUsrNm
	 */
	public void setCrCrdUsrNm(String crCrdUsrNm) {
		this.crCrdUsrNm = crCrdUsrNm;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo1
	 */
	public void setSlpSeqNo1(String slpSeqNo1) {
		this.slpSeqNo1 = slpSeqNo1;
	}
	
	/**
	 * Column Info
	 * @param chaRatio1
	 */
	public void setChaRatio1(String chaRatio1) {
		this.chaRatio1 = chaRatio1;
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
	 * @param slpVndrCd
	 */
	public void setSlpVndrCd(String slpVndrCd) {
		this.slpVndrCd = slpVndrCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
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
	 * @param slpTjNo1
	 */
	public void setSlpTjNo1(String slpTjNo1) {
		this.slpTjNo1 = slpTjNo1;
	}
	
	/**
	 * Column Info
	 * @param slpTjNo
	 */
	public void setSlpTjNo(String slpTjNo) {
		this.slpTjNo = slpTjNo;
	}
	
	/**
	 * Column Info
	 * @param ratio1
	 */
	public void setRatio1(String ratio1) {
		this.ratio1 = ratio1;
	}
	
	/**
	 * Column Info
	 * @param slpAmt
	 */
	public void setSlpAmt(String slpAmt) {
		this.slpAmt = slpAmt;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param genExpnFnlLoclAmt
	 */
	public void setGenExpnFnlLoclAmt(String genExpnFnlLoclAmt) {
		this.genExpnFnlLoclAmt = genExpnFnlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ticCd1
	 */
	public void setTicCd1(String ticCd1) {
		this.ticCd1 = ticCd1;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt
	 */
	public void setSlpPerfAmt(String slpPerfAmt) {
		this.slpPerfAmt = slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @param glEffDt1
	 */
	public void setGlEffDt1(String glEffDt1) {
		this.glEffDt1 = glEffDt1;
	}
	
	/**
	 * Column Info
	 * @param subGenExpnCd
	 */
	public void setSubGenExpnCd(String subGenExpnCd) {
		this.subGenExpnCd = subGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param slpSplrCd
	 */
	public void setSlpSplrCd(String slpSplrCd) {
		this.slpSplrCd = slpSplrCd;
	}
	
	/**
	 * Column Info
	 * @param chaRatio
	 */
	public void setChaRatio(String chaRatio) {
		this.chaRatio = chaRatio;
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
	 * @param subAbbrNm
	 */
	public void setSubAbbrNm(String subAbbrNm) {
		this.subAbbrNm = subAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param slpDesc1
	 */
	public void setSlpDesc1(String slpDesc1) {
		this.slpDesc1 = slpDesc1;
	}
	
	/**
	 * Column Info
	 * @param slpCurrCd1
	 */
	public void setSlpCurrCd1(String slpCurrCd1) {
		this.slpCurrCd1 = slpCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param ticCd
	 */
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setAbbrNm(JSPUtil.getParameter(request, prefix + "abbr_nm", ""));
		setSlpSplrNm(JSPUtil.getParameter(request, prefix + "slp_splr_nm", ""));
		setSlpAmt1(JSPUtil.getParameter(request, prefix + "slp_amt1", ""));
		setSlpCurrCd(JSPUtil.getParameter(request, prefix + "slp_curr_cd", ""));
		setCrdShopNm(JSPUtil.getParameter(request, prefix + "crd_shop_nm", ""));
		setSlpDesc(JSPUtil.getParameter(request, prefix + "slp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCrCrdUsrNm(JSPUtil.getParameter(request, prefix + "cr_crd_usr_nm", ""));
		setSlpSeqNo1(JSPUtil.getParameter(request, prefix + "slp_seq_no1", ""));
		setChaRatio1(JSPUtil.getParameter(request, prefix + "cha_ratio1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlpVndrCd(JSPUtil.getParameter(request, prefix + "slp_vndr_cd", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, prefix + "ofc_co_div_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setSlpTjNo1(JSPUtil.getParameter(request, prefix + "slp_tj_no1", ""));
		setSlpTjNo(JSPUtil.getParameter(request, prefix + "slp_tj_no", ""));
		setRatio1(JSPUtil.getParameter(request, prefix + "ratio1", ""));
		setSlpAmt(JSPUtil.getParameter(request, prefix + "slp_amt", ""));
		setGlEffDt(JSPUtil.getParameter(request, prefix + "gl_eff_dt", ""));
		setGenExpnFnlLoclAmt(JSPUtil.getParameter(request, prefix + "gen_expn_fnl_locl_amt", ""));
		setSubOfcCd(JSPUtil.getParameter(request, prefix + "sub_ofc_cd", ""));
		setTicCd1(JSPUtil.getParameter(request, prefix + "tic_cd1", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setSlpPerfAmt(JSPUtil.getParameter(request, prefix + "slp_perf_amt", ""));
		setGlEffDt1(JSPUtil.getParameter(request, prefix + "gl_eff_dt1", ""));
		setSubGenExpnCd(JSPUtil.getParameter(request, prefix + "sub_gen_expn_cd", ""));
		setSlpSplrCd(JSPUtil.getParameter(request, prefix + "slp_splr_cd", ""));
		setChaRatio(JSPUtil.getParameter(request, prefix + "cha_ratio", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSubAbbrNm(JSPUtil.getParameter(request, prefix + "sub_abbr_nm", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setSlpDesc1(JSPUtil.getParameter(request, prefix + "slp_desc1", ""));
		setSlpCurrCd1(JSPUtil.getParameter(request, prefix + "slp_curr_cd1", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setTicCd(JSPUtil.getParameter(request, prefix + "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlipPerformanceVO[]
	 */
	public SlipPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlipPerformanceVO[]
	 */
	public SlipPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlipPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] abbrNm = (JSPUtil.getParameter(request, prefix	+ "abbr_nm", length));
			String[] slpSplrNm = (JSPUtil.getParameter(request, prefix	+ "slp_splr_nm", length));
			String[] slpAmt1 = (JSPUtil.getParameter(request, prefix	+ "slp_amt1", length));
			String[] slpCurrCd = (JSPUtil.getParameter(request, prefix	+ "slp_curr_cd", length));
			String[] crdShopNm = (JSPUtil.getParameter(request, prefix	+ "crd_shop_nm", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crCrdUsrNm = (JSPUtil.getParameter(request, prefix	+ "cr_crd_usr_nm", length));
			String[] slpSeqNo1 = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no1", length));
			String[] chaRatio1 = (JSPUtil.getParameter(request, prefix	+ "cha_ratio1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slpVndrCd = (JSPUtil.getParameter(request, prefix	+ "slp_vndr_cd", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpTjNo1 = (JSPUtil.getParameter(request, prefix	+ "slp_tj_no1", length));
			String[] slpTjNo = (JSPUtil.getParameter(request, prefix	+ "slp_tj_no", length));
			String[] ratio1 = (JSPUtil.getParameter(request, prefix	+ "ratio1", length));
			String[] slpAmt = (JSPUtil.getParameter(request, prefix	+ "slp_amt", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] genExpnFnlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_fnl_locl_amt", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] ticCd1 = (JSPUtil.getParameter(request, prefix	+ "tic_cd1", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] slpPerfAmt = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt", length));
			String[] glEffDt1 = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt1", length));
			String[] subGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "sub_gen_expn_cd", length));
			String[] slpSplrCd = (JSPUtil.getParameter(request, prefix	+ "slp_splr_cd", length));
			String[] chaRatio = (JSPUtil.getParameter(request, prefix	+ "cha_ratio", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] subAbbrNm = (JSPUtil.getParameter(request, prefix	+ "sub_abbr_nm", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] slpDesc1 = (JSPUtil.getParameter(request, prefix	+ "slp_desc1", length));
			String[] slpCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "slp_curr_cd1", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SlipPerformanceVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (abbrNm[i] != null)
					model.setAbbrNm(abbrNm[i]);
				if (slpSplrNm[i] != null)
					model.setSlpSplrNm(slpSplrNm[i]);
				if (slpAmt1[i] != null)
					model.setSlpAmt1(slpAmt1[i]);
				if (slpCurrCd[i] != null)
					model.setSlpCurrCd(slpCurrCd[i]);
				if (crdShopNm[i] != null)
					model.setCrdShopNm(crdShopNm[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crCrdUsrNm[i] != null)
					model.setCrCrdUsrNm(crCrdUsrNm[i]);
				if (slpSeqNo1[i] != null)
					model.setSlpSeqNo1(slpSeqNo1[i]);
				if (chaRatio1[i] != null)
					model.setChaRatio1(chaRatio1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slpVndrCd[i] != null)
					model.setSlpVndrCd(slpVndrCd[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpTjNo1[i] != null)
					model.setSlpTjNo1(slpTjNo1[i]);
				if (slpTjNo[i] != null)
					model.setSlpTjNo(slpTjNo[i]);
				if (ratio1[i] != null)
					model.setRatio1(ratio1[i]);
				if (slpAmt[i] != null)
					model.setSlpAmt(slpAmt[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (genExpnFnlLoclAmt[i] != null)
					model.setGenExpnFnlLoclAmt(genExpnFnlLoclAmt[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (ticCd1[i] != null)
					model.setTicCd1(ticCd1[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpPerfAmt[i] != null)
					model.setSlpPerfAmt(slpPerfAmt[i]);
				if (glEffDt1[i] != null)
					model.setGlEffDt1(glEffDt1[i]);
				if (subGenExpnCd[i] != null)
					model.setSubGenExpnCd(subGenExpnCd[i]);
				if (slpSplrCd[i] != null)
					model.setSlpSplrCd(slpSplrCd[i]);
				if (chaRatio[i] != null)
					model.setChaRatio(chaRatio[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (subAbbrNm[i] != null)
					model.setSubAbbrNm(subAbbrNm[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (slpDesc1[i] != null)
					model.setSlpDesc1(slpDesc1[i]);
				if (slpCurrCd1[i] != null)
					model.setSlpCurrCd1(slpCurrCd1[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlipPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlipPerformanceVO[]
	 */
	public SlipPerformanceVO[] getSlipPerformanceVOs(){
		SlipPerformanceVO[] vos = (SlipPerformanceVO[])models.toArray(new SlipPerformanceVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm = this.abbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSplrNm = this.slpSplrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt1 = this.slpAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCurrCd = this.slpCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdShopNm = this.crdShopNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCrdUsrNm = this.crCrdUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo1 = this.slpSeqNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chaRatio1 = this.chaRatio1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpVndrCd = this.slpVndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTjNo1 = this.slpTjNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTjNo = this.slpTjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio1 = this.ratio1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt = this.slpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnFnlLoclAmt = this.genExpnFnlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd1 = this.ticCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt = this.slpPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt1 = this.glEffDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subGenExpnCd = this.subGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSplrCd = this.slpSplrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chaRatio = this.chaRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAbbrNm = this.subAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc1 = this.slpDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCurrCd1 = this.slpCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
