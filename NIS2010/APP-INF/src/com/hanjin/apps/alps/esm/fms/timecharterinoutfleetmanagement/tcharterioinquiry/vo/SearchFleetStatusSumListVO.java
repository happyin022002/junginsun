/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFleetStatusSumListVO.java
*@FileTitle : SearchFleetStatusSumListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.02 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFleetStatusSumListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFleetStatusSumListVO> models = new ArrayList<SearchFleetStatusSumListVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hirCurrN1stCd = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String shpSpdQty = null;
	/* Column Info */
	private String rdeRngCtnt = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String vslBldDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nrtWgt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String ddwtCgoCapaQty = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String hirRtN2ndAmt = null;
	/* Column Info */
	private String rdeNtcCtnt = null;
	/* Column Info */
	private String hirRtN1stAmt = null;
	/* Column Info */
	private String bse14tonVslCapa = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String hirCurrN2ndCd = null;
	/* Column Info */
	private String grFlg = null;
	/* Column Info */
	private String chtrPrdOptCtnt = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String rfCntrPlgQty = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFleetStatusSumListVO() {}

	public SearchFleetStatusSumListVO(String ibflag, String pagerows, String fletCtrtNo, String fletCtrtTpCd, String vslCd, String vslEngNm, String ownrNm, String vslCntCd, String vslBldDt, String vslDzndCapa, String bse14tonVslCapa, String effDt, String expDt, String hirCurrN1stCd, String hirRtN1stAmt, String hirCurrN2ndCd, String hirRtN2ndAmt, String slanCd, String grFlg, String rfCntrPlgQty, String shpSpdQty, String ddwtCgoCapaQty, String grsWgt, String nrtWgt, String chtrPrdOptCtnt, String rdeRngCtnt, String rdeNtcCtnt) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslCd = vslCd;
		this.hirCurrN1stCd = hirCurrN1stCd;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.shpSpdQty = shpSpdQty;
		this.rdeRngCtnt = rdeRngCtnt;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.vslBldDt = vslBldDt;
		this.ibflag = ibflag;
		this.nrtWgt = nrtWgt;
		this.vslEngNm = vslEngNm;
		this.ddwtCgoCapaQty = ddwtCgoCapaQty;
		this.expDt = expDt;
		this.vslCntCd = vslCntCd;
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		this.rdeNtcCtnt = rdeNtcCtnt;
		this.hirRtN1stAmt = hirRtN1stAmt;
		this.bse14tonVslCapa = bse14tonVslCapa;
		this.slanCd = slanCd;
		this.hirCurrN2ndCd = hirCurrN2ndCd;
		this.grFlg = grFlg;
		this.chtrPrdOptCtnt = chtrPrdOptCtnt;
		this.ownrNm = ownrNm;
		this.rfCntrPlgQty = rfCntrPlgQty;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hir_curr_n1st_cd", getHirCurrN1stCd());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("shp_spd_qty", getShpSpdQty());
		this.hashColumns.put("rde_rng_ctnt", getRdeRngCtnt());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("vsl_bld_dt", getVslBldDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nrt_wgt", getNrtWgt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("ddwt_cgo_capa_qty", getDdwtCgoCapaQty());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("hir_rt_n2nd_amt", getHirRtN2ndAmt());
		this.hashColumns.put("rde_ntc_ctnt", getRdeNtcCtnt());
		this.hashColumns.put("hir_rt_n1st_amt", getHirRtN1stAmt());
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("hir_curr_n2nd_cd", getHirCurrN2ndCd());
		this.hashColumns.put("gr_flg", getGrFlg());
		this.hashColumns.put("chtr_prd_opt_ctnt", getChtrPrdOptCtnt());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("rf_cntr_plg_qty", getRfCntrPlgQty());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hir_curr_n1st_cd", "hirCurrN1stCd");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("shp_spd_qty", "shpSpdQty");
		this.hashFields.put("rde_rng_ctnt", "rdeRngCtnt");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("vsl_bld_dt", "vslBldDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nrt_wgt", "nrtWgt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("ddwt_cgo_capa_qty", "ddwtCgoCapaQty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("hir_rt_n2nd_amt", "hirRtN2ndAmt");
		this.hashFields.put("rde_ntc_ctnt", "rdeNtcCtnt");
		this.hashFields.put("hir_rt_n1st_amt", "hirRtN1stAmt");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("hir_curr_n2nd_cd", "hirCurrN2ndCd");
		this.hashFields.put("gr_flg", "grFlg");
		this.hashFields.put("chtr_prd_opt_ctnt", "chtrPrdOptCtnt");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("rf_cntr_plg_qty", "rfCntrPlgQty");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
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
	 * @return hirCurrN1stCd
	 */
	public String getHirCurrN1stCd() {
		return this.hirCurrN1stCd;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return shpSpdQty
	 */
	public String getShpSpdQty() {
		return this.shpSpdQty;
	}
	
	/**
	 * Column Info
	 * @return rdeRngCtnt
	 */
	public String getRdeRngCtnt() {
		return this.rdeRngCtnt;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return vslBldDt
	 */
	public String getVslBldDt() {
		return this.vslBldDt;
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
	 * @return nrtWgt
	 */
	public String getNrtWgt() {
		return this.nrtWgt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return ddwtCgoCapaQty
	 */
	public String getDdwtCgoCapaQty() {
		return this.ddwtCgoCapaQty;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return hirRtN2ndAmt
	 */
	public String getHirRtN2ndAmt() {
		return this.hirRtN2ndAmt;
	}
	
	/**
	 * Column Info
	 * @return rdeNtcCtnt
	 */
	public String getRdeNtcCtnt() {
		return this.rdeNtcCtnt;
	}
	
	/**
	 * Column Info
	 * @return hirRtN1stAmt
	 */
	public String getHirRtN1stAmt() {
		return this.hirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @return bse14tonVslCapa
	 */
	public String getBse14tonVslCapa() {
		return this.bse14tonVslCapa;
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
	 * @return hirCurrN2ndCd
	 */
	public String getHirCurrN2ndCd() {
		return this.hirCurrN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return grFlg
	 */
	public String getGrFlg() {
		return this.grFlg;
	}
	
	/**
	 * Column Info
	 * @return chtrPrdOptCtnt
	 */
	public String getChtrPrdOptCtnt() {
		return this.chtrPrdOptCtnt;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return rfCntrPlgQty
	 */
	public String getRfCntrPlgQty() {
		return this.rfCntrPlgQty;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	

	/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
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
	 * @param hirCurrN1stCd
	 */
	public void setHirCurrN1stCd(String hirCurrN1stCd) {
		this.hirCurrN1stCd = hirCurrN1stCd;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param shpSpdQty
	 */
	public void setShpSpdQty(String shpSpdQty) {
		this.shpSpdQty = shpSpdQty;
	}
	
	/**
	 * Column Info
	 * @param rdeRngCtnt
	 */
	public void setRdeRngCtnt(String rdeRngCtnt) {
		this.rdeRngCtnt = rdeRngCtnt;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param vslBldDt
	 */
	public void setVslBldDt(String vslBldDt) {
		this.vslBldDt = vslBldDt;
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
	 * @param nrtWgt
	 */
	public void setNrtWgt(String nrtWgt) {
		this.nrtWgt = nrtWgt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param ddwtCgoCapaQty
	 */
	public void setDdwtCgoCapaQty(String ddwtCgoCapaQty) {
		this.ddwtCgoCapaQty = ddwtCgoCapaQty;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param hirRtN2ndAmt
	 */
	public void setHirRtN2ndAmt(String hirRtN2ndAmt) {
		this.hirRtN2ndAmt = hirRtN2ndAmt;
	}
	
	/**
	 * Column Info
	 * @param rdeNtcCtnt
	 */
	public void setRdeNtcCtnt(String rdeNtcCtnt) {
		this.rdeNtcCtnt = rdeNtcCtnt;
	}
	
	/**
	 * Column Info
	 * @param hirRtN1stAmt
	 */
	public void setHirRtN1stAmt(String hirRtN1stAmt) {
		this.hirRtN1stAmt = hirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @param bse14tonVslCapa
	 */
	public void setBse14tonVslCapa(String bse14tonVslCapa) {
		this.bse14tonVslCapa = bse14tonVslCapa;
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
	 * @param hirCurrN2ndCd
	 */
	public void setHirCurrN2ndCd(String hirCurrN2ndCd) {
		this.hirCurrN2ndCd = hirCurrN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param grFlg
	 */
	public void setGrFlg(String grFlg) {
		this.grFlg = grFlg;
	}
	
	/**
	 * Column Info
	 * @param chtrPrdOptCtnt
	 */
	public void setChtrPrdOptCtnt(String chtrPrdOptCtnt) {
		this.chtrPrdOptCtnt = chtrPrdOptCtnt;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param rfCntrPlgQty
	 */
	public void setRfCntrPlgQty(String rfCntrPlgQty) {
		this.rfCntrPlgQty = rfCntrPlgQty;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setHirCurrN1stCd(JSPUtil.getParameter(request, "hir_curr_n1st_cd", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setShpSpdQty(JSPUtil.getParameter(request, "shp_spd_qty", ""));
		setRdeRngCtnt(JSPUtil.getParameter(request, "rde_rng_ctnt", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setVslBldDt(JSPUtil.getParameter(request, "vsl_bld_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNrtWgt(JSPUtil.getParameter(request, "nrt_wgt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setDdwtCgoCapaQty(JSPUtil.getParameter(request, "ddwt_cgo_capa_qty", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setHirRtN2ndAmt(JSPUtil.getParameter(request, "hir_rt_n2nd_amt", ""));
		setRdeNtcCtnt(JSPUtil.getParameter(request, "rde_ntc_ctnt", ""));
		setHirRtN1stAmt(JSPUtil.getParameter(request, "hir_rt_n1st_amt", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request, "bse_14ton_vsl_capa", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setHirCurrN2ndCd(JSPUtil.getParameter(request, "hir_curr_n2nd_cd", ""));
		setGrFlg(JSPUtil.getParameter(request, "gr_flg", ""));
		setChtrPrdOptCtnt(JSPUtil.getParameter(request, "chtr_prd_opt_ctnt", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setRfCntrPlgQty(JSPUtil.getParameter(request, "rf_cntr_plg_qty", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFleetStatusListVO[]
	 */
	public SearchFleetStatusSumListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFleetStatusListVO[]
	 */
	public SearchFleetStatusSumListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFleetStatusSumListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] hirCurrN1stCd = (JSPUtil.getParameter(request, prefix	+ "hir_curr_n1st_cd".trim(), length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd".trim(), length));
			String[] shpSpdQty = (JSPUtil.getParameter(request, prefix	+ "shp_spd_qty".trim(), length));
			String[] rdeRngCtnt = (JSPUtil.getParameter(request, prefix	+ "rde_rng_ctnt".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] vslBldDt = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] nrtWgt = (JSPUtil.getParameter(request, prefix	+ "nrt_wgt".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] ddwtCgoCapaQty = (JSPUtil.getParameter(request, prefix	+ "ddwt_cgo_capa_qty".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd".trim(), length));
			String[] hirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n2nd_amt".trim(), length));
			String[] rdeNtcCtnt = (JSPUtil.getParameter(request, prefix	+ "rde_ntc_ctnt".trim(), length));
			String[] hirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n1st_amt".trim(), length));
			String[] bse14tonVslCapa = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_capa".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] hirCurrN2ndCd = (JSPUtil.getParameter(request, prefix	+ "hir_curr_n2nd_cd".trim(), length));
			String[] grFlg = (JSPUtil.getParameter(request, prefix	+ "gr_flg".trim(), length));
			String[] chtrPrdOptCtnt = (JSPUtil.getParameter(request, prefix	+ "chtr_prd_opt_ctnt".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] rfCntrPlgQty = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_plg_qty".trim(), length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFleetStatusSumListVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hirCurrN1stCd[i] != null)
					model.setHirCurrN1stCd(hirCurrN1stCd[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (shpSpdQty[i] != null)
					model.setShpSpdQty(shpSpdQty[i]);
				if (rdeRngCtnt[i] != null)
					model.setRdeRngCtnt(rdeRngCtnt[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (vslBldDt[i] != null)
					model.setVslBldDt(vslBldDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nrtWgt[i] != null)
					model.setNrtWgt(nrtWgt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (ddwtCgoCapaQty[i] != null)
					model.setDdwtCgoCapaQty(ddwtCgoCapaQty[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (hirRtN2ndAmt[i] != null)
					model.setHirRtN2ndAmt(hirRtN2ndAmt[i]);
				if (rdeNtcCtnt[i] != null)
					model.setRdeNtcCtnt(rdeNtcCtnt[i]);
				if (hirRtN1stAmt[i] != null)
					model.setHirRtN1stAmt(hirRtN1stAmt[i]);
				if (bse14tonVslCapa[i] != null)
					model.setBse14tonVslCapa(bse14tonVslCapa[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (hirCurrN2ndCd[i] != null)
					model.setHirCurrN2ndCd(hirCurrN2ndCd[i]);
				if (grFlg[i] != null)
					model.setGrFlg(grFlg[i]);
				if (chtrPrdOptCtnt[i] != null)
					model.setChtrPrdOptCtnt(chtrPrdOptCtnt[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (rfCntrPlgQty[i] != null)
					model.setRfCntrPlgQty(rfCntrPlgQty[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFleetStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFleetStatusListVO[]
	 */
	public SearchFleetStatusSumListVO[] getSearchFleetStatusListVOs(){
		SearchFleetStatusSumListVO[] vos = (SearchFleetStatusSumListVO[])models.toArray(new SearchFleetStatusSumListVO[models.size()]);
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
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirCurrN1stCd = this.hirCurrN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpSpdQty = this.shpSpdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdeRngCtnt = this.rdeRngCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldDt = this.vslBldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtWgt = this.nrtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddwtCgoCapaQty = this.ddwtCgoCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN2ndAmt = this.hirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdeNtcCtnt = this.rdeNtcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN1stAmt = this.hirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa = this.bse14tonVslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirCurrN2ndCd = this.hirCurrN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grFlg = this.grFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrPrdOptCtnt = this.chtrPrdOptCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrPlgQty = this.rfCntrPlgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
