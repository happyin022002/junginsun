/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AfterBKGCNTRRequestVO.java
*@FileTitle : AfterBKGCNTRRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14  
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

public class AfterBKGCNTRRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBKGCNTRRequestVO> models = new ArrayList<AfterBKGCNTRRequestVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String ftAdjFlg = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String chgSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntrChgDcRto = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Column Info */
	private String cntrChgDcAmt = null;
	/* Column Info */
	private String ftTtlDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String aftExptCntrSeq = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String rqstCurrCd = null;
	/* Column Info */
	private String rqstBilAmt = null;
	/* Column Info */
	private String rqstDcAmt = null;
	/* Column Info */
	private String rqstBilAftDcAmt = null;
	/* Column Info */
	private String aproCurrCd = null;
	/* Column Info */
	private String aproBilAmt = null;
	/* Column Info */
	private String aproDcAmt = null;
	/* Column Info */
	private String aproBilAftDcAmt = null;
	
	/* Column Info */
	private String bilAftDcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AfterBKGCNTRRequestVO() {}

	public AfterBKGCNTRRequestVO(String ibflag, String pagerows, String aftExptDarNo, String aftExptAdjSeq, String aftExptCntrSeq, String sysAreaGrpId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String cntrChgDcAmt, String cntrChgDcRto, String ftAdjFlg, String ftAddDys, String ftTtlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String bilAftDcAmt, String rqstCurrCd, String rqstBilAmt, String rqstDcAmt, String rqstBilAftDcAmt, String aproCurrCd, String aproBilAmt, String aproDcAmt, String aproBilAftDcAmt) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.ftAdjFlg = ftAdjFlg;
		this.cntrCycNo = cntrCycNo;
		this.creDt = creDt;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.chgSeq = chgSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.creOfcCd = creOfcCd;
		this.cntrChgDcRto = cntrChgDcRto;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.updDt = updDt;
		this.sysAreaGrpId = sysAreaGrpId;
		this.cntrChgDcAmt = cntrChgDcAmt;
		this.ftTtlDys = ftTtlDys;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.xcldHolFlg = xcldHolFlg;
		this.aftExptCntrSeq = aftExptCntrSeq;
		this.ftAddDys = ftAddDys;
		this.bilAftDcAmt = bilAftDcAmt;
		
		this.rqstCurrCd = rqstCurrCd;
		this.rqstBilAmt = rqstBilAmt;
		this.rqstDcAmt = rqstDcAmt;
		this.rqstBilAftDcAmt = rqstBilAftDcAmt;
		this.aproCurrCd = aproCurrCd;
		this.aproBilAmt = aproBilAmt;
		this.aproDcAmt = aproDcAmt;
		this.aproBilAftDcAmt = aproBilAftDcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("ft_adj_flg", getFtAdjFlg());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_chg_dc_rto", getCntrChgDcRto());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("cntr_chg_dc_amt", getCntrChgDcAmt());
		this.hashColumns.put("ft_ttl_dys", getFtTtlDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("aft_expt_cntr_seq", getAftExptCntrSeq());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("bil_aft_dc_amt", getBilAftDcAmt());

		this.hashColumns.put("rqst_curr_cd", getRqstCurrCd());
		this.hashColumns.put("rqst_bil_amt", getRqstBilAmt());
		this.hashColumns.put("rqst_dc_amt", getRqstDcAmt());
		this.hashColumns.put("rqst_bil_aft_dc_amt", getRqstBilAftDcAmt());
		this.hashColumns.put("apro_curr_cd", getAproCurrCd());
		this.hashColumns.put("apro_bil_amt", getAproBilAmt());
		this.hashColumns.put("apro_dc_amt", getAproDcAmt());
		this.hashColumns.put("apro_bil_aft_dc_amt", getAproBilAftDcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("ft_adj_flg", "ftAdjFlg");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_chg_dc_rto", "cntrChgDcRto");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("cntr_chg_dc_amt", "cntrChgDcAmt");
		this.hashFields.put("ft_ttl_dys", "ftTtlDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("aft_expt_cntr_seq", "aftExptCntrSeq");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("bil_aft_dc_amt", "bilAftDcAmt");

		this.hashFields.put("rqst_curr_cd", "rqstCurrCd");
		this.hashFields.put("rqst_bil_amt", "rqstBilAmt");
		this.hashFields.put("rqst_dc_amt", "rqstDcAmt");
		this.hashFields.put("rqst_bil_aft_dc_amt", "rqstBilAftDcAmt");
		this.hashFields.put("apro_curr_cd", "aproCurrCd");
		this.hashFields.put("apro_bil_amt", "aproBilAmt");
		this.hashFields.put("apro_dc_amt", "aproDcAmt");
		this.hashFields.put("apro_bil_aft_dc_amt", "aproBilAftDcAmt");
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
	 * @return ftAdjFlg
	 */
	public String getFtAdjFlg() {
		return this.ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
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
	 * @return cntrChgDcRto
	 */
	public String getCntrChgDcRto() {
		return this.cntrChgDcRto;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
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
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @return cntrChgDcAmt
	 */
	public String getCntrChgDcAmt() {
		return this.cntrChgDcAmt;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return aftExptCntrSeq
	 */
	public String getAftExptCntrSeq() {
		return this.aftExptCntrSeq;
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
	 * @return bilAftDcAmt
	 */
	public String getBilAftDcAmt() {
		return bilAftDcAmt;
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
	 * @param ftAdjFlg
	 */
	public void setFtAdjFlg(String ftAdjFlg) {
		this.ftAdjFlg = ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
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
	 * @param cntrChgDcRto
	 */
	public void setCntrChgDcRto(String cntrChgDcRto) {
		this.cntrChgDcRto = cntrChgDcRto;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
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
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @param cntrChgDcAmt
	 */
	public void setCntrChgDcAmt(String cntrChgDcAmt) {
		this.cntrChgDcAmt = cntrChgDcAmt;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param aftExptCntrSeq
	 */
	public void setAftExptCntrSeq(String aftExptCntrSeq) {
		this.aftExptCntrSeq = aftExptCntrSeq;
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
	 * @return bilAftDcAmt
	 */
	public void setBilAftDcAmt(String bilAftDcAmt) {
		this.bilAftDcAmt = bilAftDcAmt;
	}
	
	public String getRqstCurrCd() {
		return rqstCurrCd;
	}

	public void setRqstCurrCd(String rqstCurrCd) {
		this.rqstCurrCd = rqstCurrCd;
	}

	public String getRqstBilAmt() {
		return rqstBilAmt;
	}

	public void setRqstBilAmt(String rqstBilAmt) {
		this.rqstBilAmt = rqstBilAmt;
	}

	public String getRqstDcAmt() {
		return rqstDcAmt;
	}

	public void setRqstDcAmt(String rqstDcAmt) {
		this.rqstDcAmt = rqstDcAmt;
	}

	public String getRqstBilAftDcAmt() {
		return rqstBilAftDcAmt;
	}

	public void setRqstBilAftDcAmt(String rqstBilAftDcAmt) {
		this.rqstBilAftDcAmt = rqstBilAftDcAmt;
	}

	public String getAproCurrCd() {
		return aproCurrCd;
	}

	public void setAproCurrCd(String aproCurrCd) {
		this.aproCurrCd = aproCurrCd;
	}

	public String getAproBilAmt() {
		return aproBilAmt;
	}

	public void setAproBilAmt(String aproBilAmt) {
		this.aproBilAmt = aproBilAmt;
	}

	public String getAproDcAmt() {
		return aproDcAmt;
	}

	public void setAproDcAmt(String aproDcAmt) {
		this.aproDcAmt = aproDcAmt;
	}

	public String getAproBilAftDcAmt() {
		return aproBilAftDcAmt;
	}

	public void setAproBilAftDcAmt(String aproBilAftDcAmt) {
		this.aproBilAftDcAmt = aproBilAftDcAmt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setFtAdjFlg(JSPUtil.getParameter(request, "ft_adj_flg", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, "aft_expt_adj_seq", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, "aft_expt_dar_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntrChgDcRto(JSPUtil.getParameter(request, "cntr_chg_dc_rto", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, "sys_area_grp_id", ""));
		setCntrChgDcAmt(JSPUtil.getParameter(request, "cntr_chg_dc_amt", ""));
		setFtTtlDys(JSPUtil.getParameter(request, "ft_ttl_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setAftExptCntrSeq(JSPUtil.getParameter(request, "aft_expt_cntr_seq", ""));
		setFtAddDys(JSPUtil.getParameter(request, "ft_add_dys", ""));
		setBilAftDcAmt(JSPUtil.getParameter(request, "bil_aft_dc_amt", ""));

		setRqstCurrCd(JSPUtil.getParameter(request, "rqst_curr_cd", ""));
		setRqstBilAmt(JSPUtil.getParameter(request, "rqst_bil_amt", ""));
		setRqstDcAmt(JSPUtil.getParameter(request, "rqst_dc_amt", ""));
		setRqstBilAftDcAmt(JSPUtil.getParameter(request, "rqst_bil_aft_dc_amt", ""));
		setAproCurrCd(JSPUtil.getParameter(request, "apro_curr_cd", ""));
		setAproBilAmt(JSPUtil.getParameter(request, "apro_bil_amt", ""));
		setAproDcAmt(JSPUtil.getParameter(request, "apro_dc_amt", ""));
		setAproBilAftDcAmt(JSPUtil.getParameter(request, "apro_bil_aft_dc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBKGCNTRRequestVO[]
	 */
	public AfterBKGCNTRRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBKGCNTRRequestVO[]
	 */
	public AfterBKGCNTRRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBKGCNTRRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] ftAdjFlg = (JSPUtil.getParameter(request, prefix	+ "ft_adj_flg", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntrChgDcRto = (JSPUtil.getParameter(request, prefix	+ "cntr_chg_dc_rto", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] cntrChgDcAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_chg_dc_amt", length));
			String[] ftTtlDys = (JSPUtil.getParameter(request, prefix	+ "ft_ttl_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] aftExptCntrSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_cntr_seq", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] bilAftDcAmt = (JSPUtil.getParameter(request, prefix	+ "bil_aft_dc_amt", length));

			String[] rqstCurrCd = (JSPUtil.getParameter(request, prefix	+ "rqst_curr_cd", length));
			String[] rqstBilAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_bil_amt", length));
			String[] rqstDcAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_dc_amt", length));
			String[] rqstBilAftDcAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_bil_aft_dc_amt", length));
			String[] aproCurrCd = (JSPUtil.getParameter(request, prefix	+ "apro_curr_cd", length));
			String[] aproBilAmt = (JSPUtil.getParameter(request, prefix	+ "apro_bil_amt", length));
			String[] aproDcAmt = (JSPUtil.getParameter(request, prefix	+ "apro_dc_amt", length));
			String[] aproBilAftDcAmt = (JSPUtil.getParameter(request, prefix	+ "apro_bil_aft_dc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBKGCNTRRequestVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (ftAdjFlg[i] != null)
					model.setFtAdjFlg(ftAdjFlg[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntrChgDcRto[i] != null)
					model.setCntrChgDcRto(cntrChgDcRto[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (cntrChgDcAmt[i] != null)
					model.setCntrChgDcAmt(cntrChgDcAmt[i]);
				if (ftTtlDys[i] != null)
					model.setFtTtlDys(ftTtlDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (aftExptCntrSeq[i] != null)
					model.setAftExptCntrSeq(aftExptCntrSeq[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (bilAftDcAmt[i] != null)
					model.setBilAftDcAmt(bilAftDcAmt[i]);

				if (rqstCurrCd[i] != null)
					model.setRqstCurrCd(rqstCurrCd[i]);
				if (rqstBilAmt[i] != null)
					model.setRqstBilAmt(rqstBilAmt[i]);
				if (rqstDcAmt[i] != null)
					model.setRqstDcAmt(rqstDcAmt[i]);
				if (rqstBilAftDcAmt[i] != null)
					model.setRqstBilAftDcAmt(rqstBilAftDcAmt[i]);
				
				if (aproCurrCd[i] != null)
					model.setAproCurrCd(aproCurrCd[i]);
				if (aproBilAmt[i] != null)
					model.setAproBilAmt(aproBilAmt[i]);
				if (aproDcAmt[i] != null)
					model.setAproDcAmt(aproDcAmt[i]);
				if (aproBilAftDcAmt[i] != null)
					model.setAproBilAftDcAmt(aproBilAftDcAmt[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBKGCNTRRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBKGCNTRRequestVO[]
	 */
	public AfterBKGCNTRRequestVO[] getAfterBKGCNTRRequestVOs(){
		AfterBKGCNTRRequestVO[] vos = (AfterBKGCNTRRequestVO[])models.toArray(new AfterBKGCNTRRequestVO[models.size()]);
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
		this.ftAdjFlg = this.ftAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChgDcRto = this.cntrChgDcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChgDcAmt = this.cntrChgDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTtlDys = this.ftTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptCntrSeq = this.aftExptCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAftDcAmt = this.bilAftDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.rqstCurrCd = this.rqstCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBilAmt = this.rqstBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDcAmt = this.rqstDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBilAftDcAmt = this.rqstBilAftDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.aproCurrCd = this.aproCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproBilAmt = this.aproBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDcAmt = this.aproDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproBilAftDcAmt = this.aproBilAftDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
