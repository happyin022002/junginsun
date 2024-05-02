/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AfterBKGListVO.java
*@FileTitle : AfterBKGListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 
*@LastVersion : 1.0 
* 2009.09.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AfterBKGListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBKGListVO> models = new ArrayList<AfterBKGListVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String dcRto2 = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ftAdjFlg = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String rd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String eachCntrFlg = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String dcFlg = null;
	/* Column Info */
	private String allCurrCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dcRto = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ftTtlDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String allCurrNm = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String aftBkgCmAmt = null;
	/* Column Info */
	private String xchRtLvl = null;
	/* Column Info */
	private String xchRt = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String bilTtl = null;
	/* Column Info */
	private String dcTtl = null;
	/* Column Info */
	private String aftDcTtl = null;
	/* Column Info */
	private String ofcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AfterBKGListVO() {}

	public AfterBKGListVO(String ibflag, String pagerows, String aftExptDarNo, String aftExptAdjSeq, String dmdtTrfCd, String bkgNo, String blNo, String dmdtChgLocDivCd, String locCd, String cntrTp, String ftAdjFlg, String ftAddDys, String ftTtlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String dcFlg, String currCd, String allCurrCd, String allCurrNm, String dcAmt, String dcRto, String dcRto2, String tvvd, String porCd, String polCd, String podCd, String delCd, String rd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String socFlg, String cmdtCd, String cmdtNm, String eachCntrFlg, String rqstOfcCd, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String aftBkgCmAmt, String xchRtLvl, String xchRt, String cntrQty, String bilTtl, String dcTtl, String aftDcTtl, String ofcCd) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.porCd = porCd;
		this.dcRto2 = dcRto2;
		this.currCd = currCd;
		this.ftAdjFlg = ftAdjFlg;
		this.rdCgoFlg = rdCgoFlg;
		this.creDt = creDt;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.rd = rd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.dcAmt = dcAmt;
		this.aftExptDarNo = aftExptDarNo;
		this.cmdtCd = cmdtCd;
		this.creOfcCd = creOfcCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.eachCntrFlg = eachCntrFlg;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updDt = updDt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.dcFlg = dcFlg;
		this.allCurrCd = allCurrCd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.dcRto = dcRto;
		this.tvvd = tvvd;
		this.cmdtNm = cmdtNm;
		this.socFlg = socFlg;
		this.podCd = podCd;
		this.ftTtlDys = ftTtlDys;
		this.creUsrId = creUsrId;
		this.cntrTp = cntrTp;
		this.bkgNo = bkgNo;
		this.allCurrNm = allCurrNm;
		this.rqstOfcCd = rqstOfcCd;
		this.rcFlg = rcFlg;
		this.xcldHolFlg = xcldHolFlg;
		this.ftAddDys = ftAddDys;
		this.aftBkgCmAmt = aftBkgCmAmt;
		this.xchRtLvl = xchRtLvl;
		this.xchRt = xchRt;
		this.cntrQty = cntrQty;
		this.bilTtl = bilTtl;
		this.dcTtl = dcTtl;
		this.aftDcTtl = aftDcTtl;
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("dc_rto2", getDcRto2());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ft_adj_flg", getFtAdjFlg());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("rd", getRd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("each_cntr_flg", getEachCntrFlg());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("dc_flg", getDcFlg());
		this.hashColumns.put("all_curr_cd", getAllCurrCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dc_rto", getDcRto());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ft_ttl_dys", getFtTtlDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("all_curr_nm", getAllCurrNm());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("aft_bkg_cm_amt", getAftBkgCmAmt());
		this.hashColumns.put("xch_rt_lvl", getXchRtLvl());
		this.hashColumns.put("xch_rt", getXchRt());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("bil_ttl", getBilTtl());
		this.hashColumns.put("dc_ttl", getDcTtl());
		this.hashColumns.put("aft_dc_ttl", getAftDcTtl());
		this.hashColumns.put("ofc_cd", getOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("dc_rto2", "dcRto2");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ft_adj_flg", "ftAdjFlg");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("rd", "rd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("each_cntr_flg", "eachCntrFlg");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("dc_flg", "dcFlg");
		this.hashFields.put("all_curr_cd", "allCurrCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dc_rto", "dcRto");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ft_ttl_dys", "ftTtlDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("all_curr_nm", "allCurrNm");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("aft_bkg_cm_amt", "aftBkgCmAmt");
		this.hashFields.put("xch_rt_lvl", "xchRtLvl");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("bil_ttl", "bilTtl");
		this.hashFields.put("dc_ttl", "dcTtl");
		this.hashFields.put("aft_dc_ttl", "aftDcTtl");
		this.hashFields.put("ofc_cd", "ofcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
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
	 * @return dcRto2
	 */
	public String getDcRto2() {
		return this.dcRto2;
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
	 * @return ftAdjFlg
	 */
	public String getFtAdjFlg() {
		return this.ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
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
	 * @return aftExptAdjSeq
	 */
	public String getAftExptAdjSeq() {
		return this.aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return rd
	 */
	public String getRd() {
		return this.rd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return eachCntrFlg
	 */
	public String getEachCntrFlg() {
		return this.eachCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return dcFlg
	 */
	public String getDcFlg() {
		return this.dcFlg;
	}
	
	/**
	 * Column Info
	 * @return allCurrCd
	 */
	public String getAllCurrCd() {
		return this.allCurrCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return dcRto
	 */
	public String getDcRto() {
		return this.dcRto;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
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
	 * @return allCurrNm
	 */
	public String getAllCurrNm() {
		return this.allCurrNm;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
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
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
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
	 * @param dcRto2
	 */
	public void setDcRto2(String dcRto2) {
		this.dcRto2 = dcRto2;
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
	 * @param ftAdjFlg
	 */
	public void setFtAdjFlg(String ftAdjFlg) {
		this.ftAdjFlg = ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
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
	 * @param aftExptAdjSeq
	 */
	public void setAftExptAdjSeq(String aftExptAdjSeq) {
		this.aftExptAdjSeq = aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param rd
	 */
	public void setRd(String rd) {
		this.rd = rd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param eachCntrFlg
	 */
	public void setEachCntrFlg(String eachCntrFlg) {
		this.eachCntrFlg = eachCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param dcFlg
	 */
	public void setDcFlg(String dcFlg) {
		this.dcFlg = dcFlg;
	}
	
	/**
	 * Column Info
	 * @param allCurrCd
	 */
	public void setAllCurrCd(String allCurrCd) {
		this.allCurrCd = allCurrCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param dcRto
	 */
	public void setDcRto(String dcRto) {
		this.dcRto = dcRto;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
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
	 * @param allCurrNm
	 */
	public void setAllCurrNm(String allCurrNm) {
		this.allCurrNm = allCurrNm;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param ftAddDys
	 */
	public void setFtAddDys(String ftAddDys) {
		this.ftAddDys = ftAddDys;
	}
	
	public String getAftBkgCmAmt() {
		return aftBkgCmAmt;
	}

	public void setAftBkgCmAmt(String aftBkgCmAmt) {
		this.aftBkgCmAmt = aftBkgCmAmt;
	}

	public String getXchRtLvl() {
		return xchRtLvl;
	}

	public void setXchRtLvl(String xchRtLvl) {
		this.xchRtLvl = xchRtLvl;
	}

	public String getXchRt() {
		return xchRt;
	}

	public void setXchRt(String xchRt) {
		this.xchRt = xchRt;
	}

	public String getCntrQty() {
		return cntrQty;
	}

	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	public String getBilTtl() {
		return bilTtl;
	}

	public void setBilTtl(String bilTtl) {
		this.bilTtl = bilTtl;
	}

	public String getDcTtl() {
		return dcTtl;
	}

	public void setDcTtl(String dcTtl) {
		this.dcTtl = dcTtl;
	}

	public String getAftDcTtl() {
		return aftDcTtl;
	}

	public void setAftDcTtl(String aftDcTtl) {
		this.aftDcTtl = aftDcTtl;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDcRto2(JSPUtil.getParameter(request, "dc_rto2", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setFtAdjFlg(JSPUtil.getParameter(request, "ft_adj_flg", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, "aft_expt_adj_seq", ""));
		setRd(JSPUtil.getParameter(request, "rd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, "aft_expt_dar_no", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setEachCntrFlg(JSPUtil.getParameter(request, "each_cntr_flg", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setDcFlg(JSPUtil.getParameter(request, "dc_flg", ""));
		setAllCurrCd(JSPUtil.getParameter(request, "all_curr_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setDcRto(JSPUtil.getParameter(request, "dc_rto", ""));
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setFtTtlDys(JSPUtil.getParameter(request, "ft_ttl_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrTp(JSPUtil.getParameter(request, "cntr_tp", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setAllCurrNm(JSPUtil.getParameter(request, "all_curr_nm", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setFtAddDys(JSPUtil.getParameter(request, "ft_add_dys", ""));
		setAftBkgCmAmt(JSPUtil.getParameter(request, "aft_bkg_cm_amt", ""));
		setXchRtLvl(JSPUtil.getParameter(request, "xch_rt_lvl", ""));
		setXchRt(JSPUtil.getParameter(request, "xch_rt", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setBilTtl(JSPUtil.getParameter(request, "bil_ttl", ""));
		setDcTtl(JSPUtil.getParameter(request, "dc_ttl", ""));
		setAftDcTtl(JSPUtil.getParameter(request, "aft_dc_ttl", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBKGListVO[]
	 */
	public AfterBKGListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBKGListVO[]
	 */
	public AfterBKGListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBKGListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] dcRto2 = (JSPUtil.getParameter(request, prefix	+ "dc_rto2", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ftAdjFlg = (JSPUtil.getParameter(request, prefix	+ "ft_adj_flg", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] rd = (JSPUtil.getParameter(request, prefix	+ "rd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] eachCntrFlg = (JSPUtil.getParameter(request, prefix	+ "each_cntr_flg", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] dcFlg = (JSPUtil.getParameter(request, prefix	+ "dc_flg", length));
			String[] allCurrCd = (JSPUtil.getParameter(request, prefix	+ "all_curr_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dcRto = (JSPUtil.getParameter(request, prefix	+ "dc_rto", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ftTtlDys = (JSPUtil.getParameter(request, prefix	+ "ft_ttl_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] allCurrNm = (JSPUtil.getParameter(request, prefix	+ "all_curr_nm", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] aftBkgCmAmt = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_cm_amt", length));
			String[] xchRtLvl = (JSPUtil.getParameter(request, prefix	+ "xch_rt_lvl", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] bilTtl = (JSPUtil.getParameter(request, prefix	+ "bil_ttl", length));
			String[] dcTtl = (JSPUtil.getParameter(request, prefix	+ "dc_ttl", length));
			String[] aftDcTtl = (JSPUtil.getParameter(request, prefix	+ "aft_dc_ttl", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBKGListVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (dcRto2[i] != null)
					model.setDcRto2(dcRto2[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ftAdjFlg[i] != null)
					model.setFtAdjFlg(ftAdjFlg[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (rd[i] != null)
					model.setRd(rd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (eachCntrFlg[i] != null)
					model.setEachCntrFlg(eachCntrFlg[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (dcFlg[i] != null)
					model.setDcFlg(dcFlg[i]);
				if (allCurrCd[i] != null)
					model.setAllCurrCd(allCurrCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dcRto[i] != null)
					model.setDcRto(dcRto[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ftTtlDys[i] != null)
					model.setFtTtlDys(ftTtlDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (allCurrNm[i] != null)
					model.setAllCurrNm(allCurrNm[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (aftBkgCmAmt[i] != null)
					model.setAftBkgCmAmt(aftBkgCmAmt[i]);
				if (xchRtLvl[i] != null)
					model.setXchRtLvl(xchRtLvl[i]);
				if (xchRt[i] != null)
					model.setXchRt(xchRt[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (bilTtl[i] != null)
					model.setBilTtl(bilTtl[i]);
				if (dcTtl[i] != null)
					model.setDcTtl(dcTtl[i]);
				if (aftDcTtl[i] != null)
					model.setAftDcTtl(aftDcTtl[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBKGListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBKGListVO[]
	 */
	public AfterBKGListVO[] getAfterBKGListVOs(){
		AfterBKGListVO[] vos = (AfterBKGListVO[])models.toArray(new AfterBKGListVO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRto2 = this.dcRto2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAdjFlg = this.ftAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rd = this.rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eachCntrFlg = this.eachCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcFlg = this.dcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allCurrCd = this.allCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRto = this.dcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTtlDys = this.ftTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allCurrNm = this.allCurrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgCmAmt = this.aftBkgCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtLvl = this.xchRtLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilTtl = this.bilTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcTtl = this.dcTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftDcTtl = this.aftDcTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
