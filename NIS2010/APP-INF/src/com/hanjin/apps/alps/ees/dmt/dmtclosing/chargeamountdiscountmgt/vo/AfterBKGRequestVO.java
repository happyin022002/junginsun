/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AfterBKGRequestVO.java
*@FileTitle : AfterBKGRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.30  
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

public class AfterBKGRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBKGRequestVO> models = new ArrayList<AfterBKGRequestVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ftAdjFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String eachCntrFlg = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dcFlg = null;
	/* Column Info */
	private String dcRto = null;
	/* Column Info */
	private String ftTtlDys = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AfterBKGRequestVO() {}

	public AfterBKGRequestVO(String ibflag, String pagerows, String aftExptDarNo, String aftExptAdjSeq, String dmdtTrfCd, String bkgNo, String blNo, String dmdtChgLocDivCd, String locCd, String ftAdjFlg, String ftAddDys, String ftTtlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String dcFlg, String currCd, String dcAmt, String dcRto, String eachCntrFlg, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String aftBkgCmAmt, String xchRtLvl, String xchRt) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.currCd = currCd;
		this.ftAdjFlg = ftAdjFlg;
		this.creDt = creDt;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.dcAmt = dcAmt;
		this.aftExptDarNo = aftExptDarNo;
		this.creOfcCd = creOfcCd;
		this.eachCntrFlg = eachCntrFlg;
		this.updOfcCd = updOfcCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updUsrId = updUsrId;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.updDt = updDt;
		this.dcFlg = dcFlg;
		this.dcRto = dcRto;
		this.ftTtlDys = ftTtlDys;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.xcldHolFlg = xcldHolFlg;
		this.ftAddDys = ftAddDys;
		this.aftBkgCmAmt = aftBkgCmAmt;
		this.xchRtLvl = xchRtLvl;
		this.xchRt = xchRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ft_adj_flg", getFtAdjFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("each_cntr_flg", getEachCntrFlg());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dc_flg", getDcFlg());
		this.hashColumns.put("dc_rto", getDcRto());
		this.hashColumns.put("ft_ttl_dys", getFtTtlDys());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("aft_bkg_cm_amt", getAftBkgCmAmt());
		this.hashColumns.put("xch_rt_lvl", getXchRtLvl());
		this.hashColumns.put("xch_rt", getXchRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ft_adj_flg", "ftAdjFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("each_cntr_flg", "eachCntrFlg");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dc_flg", "dcFlg");
		this.hashFields.put("dc_rto", "dcRto");
		this.hashFields.put("ft_ttl_dys", "ftTtlDys");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("aft_bkg_cm_amt", "aftBkgCmAmt");
		this.hashFields.put("xch_rt_lvl", "xchRtLvl");
		this.hashFields.put("xch_rt", "xchRt");
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return dcFlg
	 */
	public String getDcFlg() {
		return this.dcFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param dcFlg
	 */
	public void setDcFlg(String dcFlg) {
		this.dcFlg = dcFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setFtAdjFlg(JSPUtil.getParameter(request, "ft_adj_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, "aft_expt_adj_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, "aft_expt_dar_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setEachCntrFlg(JSPUtil.getParameter(request, "each_cntr_flg", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDcFlg(JSPUtil.getParameter(request, "dc_flg", ""));
		setDcRto(JSPUtil.getParameter(request, "dc_rto", ""));
		setFtTtlDys(JSPUtil.getParameter(request, "ft_ttl_dys", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setFtAddDys(JSPUtil.getParameter(request, "ft_add_dys", ""));
		setAftBkgCmAmt(JSPUtil.getParameter(request, "aft_bkg_cm_amt", ""));
		setXchRtLvl(JSPUtil.getParameter(request, "xch_rt_lvl", ""));
		setXchRt(JSPUtil.getParameter(request, "xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBKGRequestVO[]
	 */
	public AfterBKGRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBKGRequestVO[]
	 */
	public AfterBKGRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBKGRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ftAdjFlg = (JSPUtil.getParameter(request, prefix	+ "ft_adj_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] eachCntrFlg = (JSPUtil.getParameter(request, prefix	+ "each_cntr_flg", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dcFlg = (JSPUtil.getParameter(request, prefix	+ "dc_flg", length));
			String[] dcRto = (JSPUtil.getParameter(request, prefix	+ "dc_rto", length));
			String[] ftTtlDys = (JSPUtil.getParameter(request, prefix	+ "ft_ttl_dys", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] aftBkgCmAmt = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_cm_amt", length));
			String[] xchRtLvl = (JSPUtil.getParameter(request, prefix	+ "xch_rt_lvl", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBKGRequestVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ftAdjFlg[i] != null)
					model.setFtAdjFlg(ftAdjFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (eachCntrFlg[i] != null)
					model.setEachCntrFlg(eachCntrFlg[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dcFlg[i] != null)
					model.setDcFlg(dcFlg[i]);
				if (dcRto[i] != null)
					model.setDcRto(dcRto[i]);
				if (ftTtlDys[i] != null)
					model.setFtTtlDys(ftTtlDys[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBKGRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBKGRequestVO[]
	 */
	public AfterBKGRequestVO[] getAfterBKGRequestVOs(){
		AfterBKGRequestVO[] vos = (AfterBKGRequestVO[])models.toArray(new AfterBKGRequestVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAdjFlg = this.ftAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eachCntrFlg = this.eachCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcFlg = this.dcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRto = this.dcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTtlDys = this.ftTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgCmAmt = this.aftBkgCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtLvl = this.xchRtLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
