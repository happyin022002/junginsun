/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFCLListVO.java
*@FileTitle : SearchFCLListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.30 김태경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFCLListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFCLListVO> models = new ArrayList<SearchFCLListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String ratedAs = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String wOption = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cmdt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String splFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String prePort = null;
	/* Column Info */
	private String custDesc = null;
	/* Column Info */
	private String tariffNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String payOfc = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String vvdChk = null;
	/* Column Info */
	private String dtChk = null;	
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String toDt = null;	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String repCmdt = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String slsOfc = null;
	/* Column Info */
	private String per = null;
	/* Column Info */
	private String tVvdCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String chgTp = null;
	/* Column Info */
	private String pc = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String repCmdtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFCLListVO() {}

	public SearchFCLListVO(String ibflag, String pagerows, String vvdCd, String vvdChk, String dtChk, String frDt, String toDt, String porCd, String polCd, String podCd, String delCd, String slsOfc, String bkgOfc, String trdCd, String wOption, String seq, String chgTp, String ratedAs, String rate, String per, String cur, String amount, String pc, String payOfc, String scNo, String rfaNo, String tariffNo, String shprNm, String cneeNm, String custDesc, String cmdt, String cmdtDesc, String repCmdt, String bkgNo, String blNo, String prePort, String tVvdCd, String revDirCd, String rcvTermCd, String deTermCd, String ratUtCd, String repCmdtCd, String splFlg, String rtAplyDt) {
		this.porCd = porCd;
		this.rtAplyDt = rtAplyDt;
		this.ratedAs = ratedAs;
		this.trdCd = trdCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.amount = amount;
		this.revDirCd = revDirCd;
		this.wOption = wOption;
		this.rfaNo = rfaNo;
		this.cmdt = cmdt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgOfc = bkgOfc;
		this.rate = rate;
		this.vvdCd = vvdCd;
		this.splFlg = splFlg;
		this.scNo = scNo;
		this.rcvTermCd = rcvTermCd;
		this.shprNm = shprNm;
		this.prePort = prePort;
		this.custDesc = custDesc;
		this.tariffNo = tariffNo;
		this.delCd = delCd;
		this.payOfc = payOfc;
		this.ratUtCd = ratUtCd;
		this.vvdChk = vvdChk;
		this.dtChk = dtChk;
		this.frDt = frDt;
		this.toDt = toDt;		
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.repCmdt = repCmdt;
		this.cneeNm = cneeNm;
		this.slsOfc = slsOfc;
		this.per = per;
		this.tVvdCd = tVvdCd;
		this.cmdtDesc = cmdtDesc;
		this.chgTp = chgTp;
		this.pc = pc;
		this.seq = seq;
		this.cur = cur;
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rated_as", getRatedAs());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("w_option", getWOption());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cmdt", getCmdt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("spl_flg", getSplFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pre_port", getPrePort());
		this.hashColumns.put("cust_desc", getCustDesc());
		this.hashColumns.put("tariff_no", getTariffNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pay_ofc", getPayOfc());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("vvd_chk", getVvdChk());
		this.hashColumns.put("dt_chk", getDtChk());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rep_cmdt", getRepCmdt());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("sls_ofc", getSlsOfc());
		this.hashColumns.put("per", getPer());
		this.hashColumns.put("t_vvd_cd", getTVvdCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("chg_tp", getChgTp());
		this.hashColumns.put("pc", getPc());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rated_as", "ratedAs");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("w_option", "wOption");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cmdt", "cmdt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("spl_flg", "splFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pre_port", "prePort");
		this.hashFields.put("cust_desc", "custDesc");
		this.hashFields.put("tariff_no", "tariffNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pay_ofc", "payOfc");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("vvd_chk", "vvdChk");
		this.hashFields.put("dt_chk", "dtChk");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rep_cmdt", "repCmdt");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("sls_ofc", "slsOfc");
		this.hashFields.put("per", "per");
		this.hashFields.put("t_vvd_cd", "tVvdCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("chg_tp", "chgTp");
		this.hashFields.put("pc", "pc");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
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
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return ratedAs
	 */
	public String getRatedAs() {
		return this.ratedAs;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return wOption
	 */
	public String getWOption() {
		return this.wOption;
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
	 * @return cmdt
	 */
	public String getCmdt() {
		return this.cmdt;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
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
	 * @return splFlg
	 */
	public String getSplFlg() {
		return this.splFlg;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return prePort
	 */
	public String getPrePort() {
		return this.prePort;
	}
	
	/**
	 * Column Info
	 * @return custDesc
	 */
	public String getCustDesc() {
		return this.custDesc;
	}
	
	/**
	 * Column Info
	 * @return tariffNo
	 */
	public String getTariffNo() {
		return this.tariffNo;
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
	 * @return payOfc
	 */
	public String getPayOfc() {
		return this.payOfc;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return vvdChk
	 */
	public String getVvdChk() {
		return this.vvdChk;
	}
	
	/**
	 * Column Info
	 * @return dtChk
	 */
	public String getDtChk() {
		return this.dtChk;
	}	
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return repCmdt
	 */
	public String getRepCmdt() {
		return this.repCmdt;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return slsOfc
	 */
	public String getSlsOfc() {
		return this.slsOfc;
	}
	
	/**
	 * Column Info
	 * @return per
	 */
	public String getPer() {
		return this.per;
	}
	
	/**
	 * Column Info
	 * @return tVvdCd
	 */
	public String getTVvdCd() {
		return this.tVvdCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return chgTp
	 */
	public String getChgTp() {
		return this.chgTp;
	}
	
	/**
	 * Column Info
	 * @return pc
	 */
	public String getPc() {
		return this.pc;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
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
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param ratedAs
	 */
	public void setRatedAs(String ratedAs) {
		this.ratedAs = ratedAs;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param wOption
	 */
	public void setWOption(String wOption) {
		this.wOption = wOption;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param cmdt
	 */
	public void setCmdt(String cmdt) {
		this.cmdt = cmdt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
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
	 * @param splFlg
	 */
	public void setSplFlg(String splFlg) {
		this.splFlg = splFlg;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param prePort
	 */
	public void setPrePort(String prePort) {
		this.prePort = prePort;
	}
	
	/**
	 * Column Info
	 * @param custDesc
	 */
	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}
	
	/**
	 * Column Info
	 * @param tariffNo
	 */
	public void setTariffNo(String tariffNo) {
		this.tariffNo = tariffNo;
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
	 * @param payOfc
	 */
	public void setPayOfc(String payOfc) {
		this.payOfc = payOfc;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param vvdChk
	 */
	public void setVvdChk(String vvdChk) {
		this.vvdChk = vvdChk;
	}
	
	/**
	 * Column Info
	 * @param dtChk
	 */
	public void setDtChk(String dtChk) {
		this.dtChk = dtChk;
	}	
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param repCmdt
	 */
	public void setRepCmdt(String repCmdt) {
		this.repCmdt = repCmdt;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param slsOfc
	 */
	public void setSlsOfc(String slsOfc) {
		this.slsOfc = slsOfc;
	}
	
	/**
	 * Column Info
	 * @param per
	 */
	public void setPer(String per) {
		this.per = per;
	}
	
	/**
	 * Column Info
	 * @param tVvdCd
	 */
	public void setTVvdCd(String tVvdCd) {
		this.tVvdCd = tVvdCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param chgTp
	 */
	public void setChgTp(String chgTp) {
		this.chgTp = chgTp;
	}
	
	/**
	 * Column Info
	 * @param pc
	 */
	public void setPc(String pc) {
		this.pc = pc;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, "rt_aply_dt", ""));
		setRatedAs(JSPUtil.getParameter(request, "rated_as", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setWOption(JSPUtil.getParameter(request, "w_option", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setCmdt(JSPUtil.getParameter(request, "cmdt", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setSplFlg(JSPUtil.getParameter(request, "spl_flg", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setPrePort(JSPUtil.getParameter(request, "pre_port", ""));
		setCustDesc(JSPUtil.getParameter(request, "cust_desc", ""));
		setTariffNo(JSPUtil.getParameter(request, "tariff_no", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPayOfc(JSPUtil.getParameter(request, "pay_ofc", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setVvdChk(JSPUtil.getParameter(request, "vvd_chk", ""));
		setDtChk(JSPUtil.getParameter(request, "dt_chk", ""));
		setFrDt(JSPUtil.getParameter(request, "fr_dt", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRepCmdt(JSPUtil.getParameter(request, "rep_cmdt", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setSlsOfc(JSPUtil.getParameter(request, "sls_ofc", ""));
		setPer(JSPUtil.getParameter(request, "per", ""));
		setTVvdCd(JSPUtil.getParameter(request, "t_vvd_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setChgTp(JSPUtil.getParameter(request, "chg_tp", ""));
		setPc(JSPUtil.getParameter(request, "pc", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setCur(JSPUtil.getParameter(request, "cur", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFCLListVO[]
	 */
	public SearchFCLListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFCLListVO[]
	 */
	public SearchFCLListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFCLListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] ratedAs = (JSPUtil.getParameter(request, prefix	+ "rated_as", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] wOption = (JSPUtil.getParameter(request, prefix	+ "w_option", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cmdt = (JSPUtil.getParameter(request, prefix	+ "cmdt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] splFlg = (JSPUtil.getParameter(request, prefix	+ "spl_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] prePort = (JSPUtil.getParameter(request, prefix	+ "pre_port", length));
			String[] custDesc = (JSPUtil.getParameter(request, prefix	+ "cust_desc", length));
			String[] tariffNo = (JSPUtil.getParameter(request, prefix	+ "tariff_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] payOfc = (JSPUtil.getParameter(request, prefix	+ "pay_ofc", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] vvdChk = (JSPUtil.getParameter(request, prefix	+ "vvd_chk", length));
			String[] dtChk = (JSPUtil.getParameter(request, prefix	+ "dt_chk", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] repCmdt = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] slsOfc = (JSPUtil.getParameter(request, prefix	+ "sls_ofc", length));
			String[] per = (JSPUtil.getParameter(request, prefix	+ "per", length));
			String[] tVvdCd = (JSPUtil.getParameter(request, prefix	+ "t_vvd_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] chgTp = (JSPUtil.getParameter(request, prefix	+ "chg_tp", length));
			String[] pc = (JSPUtil.getParameter(request, prefix	+ "pc", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFCLListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (ratedAs[i] != null)
					model.setRatedAs(ratedAs[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (wOption[i] != null)
					model.setWOption(wOption[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cmdt[i] != null)
					model.setCmdt(cmdt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (splFlg[i] != null)
					model.setSplFlg(splFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (prePort[i] != null)
					model.setPrePort(prePort[i]);
				if (custDesc[i] != null)
					model.setCustDesc(custDesc[i]);
				if (tariffNo[i] != null)
					model.setTariffNo(tariffNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (payOfc[i] != null)
					model.setPayOfc(payOfc[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (vvdChk[i] != null)
					model.setVvdChk(vvdChk[i]);
				if (dtChk[i] != null)
					model.setDtChk(dtChk[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);				
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (repCmdt[i] != null)
					model.setRepCmdt(repCmdt[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (slsOfc[i] != null)
					model.setSlsOfc(slsOfc[i]);
				if (per[i] != null)
					model.setPer(per[i]);
				if (tVvdCd[i] != null)
					model.setTVvdCd(tVvdCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (chgTp[i] != null)
					model.setChgTp(chgTp[i]);
				if (pc[i] != null)
					model.setPc(pc[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFCLListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFCLListVO[]
	 */
	public SearchFCLListVO[] getSearchFCLListVOs(){
		SearchFCLListVO[] vos = (SearchFCLListVO[])models.toArray(new SearchFCLListVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratedAs = this.ratedAs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wOption = this.wOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdt = this.cmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFlg = this.splFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePort = this.prePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDesc = this.custDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffNo = this.tariffNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payOfc = this.payOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdChk = this.vvdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtChk = this.dtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdt = this.repCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfc = this.slsOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per = this.per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvdCd = this.tVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTp = this.chgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc = this.pc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
