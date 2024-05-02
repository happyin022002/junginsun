/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailRepoListVO.java
*@FileTitle : AvailRepoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.01 김종준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvailRepoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvailRepoListVO> models = new ArrayList<AvailRepoListVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String fcastQty7 = null;
	/* Column Info */
	private String headCntrTpszCd = null;
	/* Column Info */
	private String fcastQty8 = null;
	/* Column Info */
	private String fcastQty18 = null;
	/* Column Info */
	private String fcastQty5 = null;
	/* Column Info */
	private String fcastQty19 = null;
	/* Column Info */
	private String fcastQty6 = null;
	/* Column Info */
	private String fcastQty3 = null;
	/* Column Info */
	private String fcastQty4 = null;
	/* Column Info */
	private String fcastQty1 = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String fcastQty2 = null;
	/* Column Info */
	private String fcastQty12 = null;
	/* Column Info */
	private String fcastQty13 = null;
	/* Column Info */
	private String fcastQty10 = null;
	/* Column Info */
	private String fcastQty11 = null;
	/* Column Info */
	private String fcastQty16 = null;
	/* Column Info */
	private String fcastQty17 = null;
	/* Column Info */
	private String fcastQty14 = null;
	/* Column Info */
	private String fcastQty9 = null;
	/* Column Info */
	private String fcastQty15 = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqTrspModCd = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String fcastQty20 = null;
	/* Column Info */
	private String lvl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AvailRepoListVO() {}

	public AvailRepoListVO(String ibflag, String pagerows, String lvl, String ioBndCd, String eqTrspModCd, String vvd, String fmYdCd, String etdDt, String toYdCd, String etbDt, String headCntrTpszCd, String total, String fcastQty1, String fcastQty2, String fcastQty3, String fcastQty4, String fcastQty5, String fcastQty6, String fcastQty7, String fcastQty8, String fcastQty9, String fcastQty10, String fcastQty11, String fcastQty12, String fcastQty13, String fcastQty14, String fcastQty15, String fcastQty16, String fcastQty17, String fcastQty18, String fcastQty19, String fcastQty20) {
		this.total = total;
		this.fcastQty7 = fcastQty7;
		this.headCntrTpszCd = headCntrTpszCd;
		this.fcastQty8 = fcastQty8;
		this.fcastQty18 = fcastQty18;
		this.fcastQty5 = fcastQty5;
		this.fcastQty19 = fcastQty19;
		this.fcastQty6 = fcastQty6;
		this.fcastQty3 = fcastQty3;
		this.fcastQty4 = fcastQty4;
		this.fcastQty1 = fcastQty1;
		this.fmYdCd = fmYdCd;
		this.fcastQty2 = fcastQty2;
		this.fcastQty12 = fcastQty12;
		this.fcastQty13 = fcastQty13;
		this.fcastQty10 = fcastQty10;
		this.fcastQty11 = fcastQty11;
		this.fcastQty16 = fcastQty16;
		this.fcastQty17 = fcastQty17;
		this.fcastQty14 = fcastQty14;
		this.fcastQty9 = fcastQty9;
		this.fcastQty15 = fcastQty15;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqTrspModCd = eqTrspModCd;
		this.etbDt = etbDt;
		this.etdDt = etdDt;
		this.ioBndCd = ioBndCd;
		this.vvd = vvd;
		this.fcastQty20 = fcastQty20;
		this.lvl = lvl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("fcast_qty7", getFcastQty7());
		this.hashColumns.put("head_cntr_tpsz_cd", getHeadCntrTpszCd());
		this.hashColumns.put("fcast_qty8", getFcastQty8());
		this.hashColumns.put("fcast_qty18", getFcastQty18());
		this.hashColumns.put("fcast_qty5", getFcastQty5());
		this.hashColumns.put("fcast_qty19", getFcastQty19());
		this.hashColumns.put("fcast_qty6", getFcastQty6());
		this.hashColumns.put("fcast_qty3", getFcastQty3());
		this.hashColumns.put("fcast_qty4", getFcastQty4());
		this.hashColumns.put("fcast_qty1", getFcastQty1());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("fcast_qty2", getFcastQty2());
		this.hashColumns.put("fcast_qty12", getFcastQty12());
		this.hashColumns.put("fcast_qty13", getFcastQty13());
		this.hashColumns.put("fcast_qty10", getFcastQty10());
		this.hashColumns.put("fcast_qty11", getFcastQty11());
		this.hashColumns.put("fcast_qty16", getFcastQty16());
		this.hashColumns.put("fcast_qty17", getFcastQty17());
		this.hashColumns.put("fcast_qty14", getFcastQty14());
		this.hashColumns.put("fcast_qty9", getFcastQty9());
		this.hashColumns.put("fcast_qty15", getFcastQty15());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_trsp_mod_cd", getEqTrspModCd());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("fcast_qty20", getFcastQty20());
		this.hashColumns.put("lvl", getLvl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("fcast_qty7", "fcastQty7");
		this.hashFields.put("head_cntr_tpsz_cd", "headCntrTpszCd");
		this.hashFields.put("fcast_qty8", "fcastQty8");
		this.hashFields.put("fcast_qty18", "fcastQty18");
		this.hashFields.put("fcast_qty5", "fcastQty5");
		this.hashFields.put("fcast_qty19", "fcastQty19");
		this.hashFields.put("fcast_qty6", "fcastQty6");
		this.hashFields.put("fcast_qty3", "fcastQty3");
		this.hashFields.put("fcast_qty4", "fcastQty4");
		this.hashFields.put("fcast_qty1", "fcastQty1");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("fcast_qty2", "fcastQty2");
		this.hashFields.put("fcast_qty12", "fcastQty12");
		this.hashFields.put("fcast_qty13", "fcastQty13");
		this.hashFields.put("fcast_qty10", "fcastQty10");
		this.hashFields.put("fcast_qty11", "fcastQty11");
		this.hashFields.put("fcast_qty16", "fcastQty16");
		this.hashFields.put("fcast_qty17", "fcastQty17");
		this.hashFields.put("fcast_qty14", "fcastQty14");
		this.hashFields.put("fcast_qty9", "fcastQty9");
		this.hashFields.put("fcast_qty15", "fcastQty15");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_trsp_mod_cd", "eqTrspModCd");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("fcast_qty20", "fcastQty20");
		this.hashFields.put("lvl", "lvl");
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
	 * @return fcastQty7
	 */
	public String getFcastQty7() {
		return this.fcastQty7;
	}
	
	/**
	 * Column Info
	 * @return headCntrTpszCd
	 */
	public String getHeadCntrTpszCd() {
		return this.headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fcastQty8
	 */
	public String getFcastQty8() {
		return this.fcastQty8;
	}
	
	/**
	 * Column Info
	 * @return fcastQty18
	 */
	public String getFcastQty18() {
		return this.fcastQty18;
	}
	
	/**
	 * Column Info
	 * @return fcastQty5
	 */
	public String getFcastQty5() {
		return this.fcastQty5;
	}
	
	/**
	 * Column Info
	 * @return fcastQty19
	 */
	public String getFcastQty19() {
		return this.fcastQty19;
	}
	
	/**
	 * Column Info
	 * @return fcastQty6
	 */
	public String getFcastQty6() {
		return this.fcastQty6;
	}
	
	/**
	 * Column Info
	 * @return fcastQty3
	 */
	public String getFcastQty3() {
		return this.fcastQty3;
	}
	
	/**
	 * Column Info
	 * @return fcastQty4
	 */
	public String getFcastQty4() {
		return this.fcastQty4;
	}
	
	/**
	 * Column Info
	 * @return fcastQty1
	 */
	public String getFcastQty1() {
		return this.fcastQty1;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return fcastQty2
	 */
	public String getFcastQty2() {
		return this.fcastQty2;
	}
	
	/**
	 * Column Info
	 * @return fcastQty12
	 */
	public String getFcastQty12() {
		return this.fcastQty12;
	}
	
	/**
	 * Column Info
	 * @return fcastQty13
	 */
	public String getFcastQty13() {
		return this.fcastQty13;
	}
	
	/**
	 * Column Info
	 * @return fcastQty10
	 */
	public String getFcastQty10() {
		return this.fcastQty10;
	}
	
	/**
	 * Column Info
	 * @return fcastQty11
	 */
	public String getFcastQty11() {
		return this.fcastQty11;
	}
	
	/**
	 * Column Info
	 * @return fcastQty16
	 */
	public String getFcastQty16() {
		return this.fcastQty16;
	}
	
	/**
	 * Column Info
	 * @return fcastQty17
	 */
	public String getFcastQty17() {
		return this.fcastQty17;
	}
	
	/**
	 * Column Info
	 * @return fcastQty14
	 */
	public String getFcastQty14() {
		return this.fcastQty14;
	}
	
	/**
	 * Column Info
	 * @return fcastQty9
	 */
	public String getFcastQty9() {
		return this.fcastQty9;
	}
	
	/**
	 * Column Info
	 * @return fcastQty15
	 */
	public String getFcastQty15() {
		return this.fcastQty15;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return eqTrspModCd
	 */
	public String getEqTrspModCd() {
		return this.eqTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return fcastQty20
	 */
	public String getFcastQty20() {
		return this.fcastQty20;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
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
	 * @param fcastQty7
	 */
	public void setFcastQty7(String fcastQty7) {
		this.fcastQty7 = fcastQty7;
	}
	
	/**
	 * Column Info
	 * @param headCntrTpszCd
	 */
	public void setHeadCntrTpszCd(String headCntrTpszCd) {
		this.headCntrTpszCd = headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fcastQty8
	 */
	public void setFcastQty8(String fcastQty8) {
		this.fcastQty8 = fcastQty8;
	}
	
	/**
	 * Column Info
	 * @param fcastQty18
	 */
	public void setFcastQty18(String fcastQty18) {
		this.fcastQty18 = fcastQty18;
	}
	
	/**
	 * Column Info
	 * @param fcastQty5
	 */
	public void setFcastQty5(String fcastQty5) {
		this.fcastQty5 = fcastQty5;
	}
	
	/**
	 * Column Info
	 * @param fcastQty19
	 */
	public void setFcastQty19(String fcastQty19) {
		this.fcastQty19 = fcastQty19;
	}
	
	/**
	 * Column Info
	 * @param fcastQty6
	 */
	public void setFcastQty6(String fcastQty6) {
		this.fcastQty6 = fcastQty6;
	}
	
	/**
	 * Column Info
	 * @param fcastQty3
	 */
	public void setFcastQty3(String fcastQty3) {
		this.fcastQty3 = fcastQty3;
	}
	
	/**
	 * Column Info
	 * @param fcastQty4
	 */
	public void setFcastQty4(String fcastQty4) {
		this.fcastQty4 = fcastQty4;
	}
	
	/**
	 * Column Info
	 * @param fcastQty1
	 */
	public void setFcastQty1(String fcastQty1) {
		this.fcastQty1 = fcastQty1;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param fcastQty2
	 */
	public void setFcastQty2(String fcastQty2) {
		this.fcastQty2 = fcastQty2;
	}
	
	/**
	 * Column Info
	 * @param fcastQty12
	 */
	public void setFcastQty12(String fcastQty12) {
		this.fcastQty12 = fcastQty12;
	}
	
	/**
	 * Column Info
	 * @param fcastQty13
	 */
	public void setFcastQty13(String fcastQty13) {
		this.fcastQty13 = fcastQty13;
	}
	
	/**
	 * Column Info
	 * @param fcastQty10
	 */
	public void setFcastQty10(String fcastQty10) {
		this.fcastQty10 = fcastQty10;
	}
	
	/**
	 * Column Info
	 * @param fcastQty11
	 */
	public void setFcastQty11(String fcastQty11) {
		this.fcastQty11 = fcastQty11;
	}
	
	/**
	 * Column Info
	 * @param fcastQty16
	 */
	public void setFcastQty16(String fcastQty16) {
		this.fcastQty16 = fcastQty16;
	}
	
	/**
	 * Column Info
	 * @param fcastQty17
	 */
	public void setFcastQty17(String fcastQty17) {
		this.fcastQty17 = fcastQty17;
	}
	
	/**
	 * Column Info
	 * @param fcastQty14
	 */
	public void setFcastQty14(String fcastQty14) {
		this.fcastQty14 = fcastQty14;
	}
	
	/**
	 * Column Info
	 * @param fcastQty9
	 */
	public void setFcastQty9(String fcastQty9) {
		this.fcastQty9 = fcastQty9;
	}
	
	/**
	 * Column Info
	 * @param fcastQty15
	 */
	public void setFcastQty15(String fcastQty15) {
		this.fcastQty15 = fcastQty15;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param eqTrspModCd
	 */
	public void setEqTrspModCd(String eqTrspModCd) {
		this.eqTrspModCd = eqTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param fcastQty20
	 */
	public void setFcastQty20(String fcastQty20) {
		this.fcastQty20 = fcastQty20;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setFcastQty7(JSPUtil.getParameter(request, "fcast_qty7", ""));
		setHeadCntrTpszCd(JSPUtil.getParameter(request, "head_cntr_tpsz_cd", ""));
		setFcastQty8(JSPUtil.getParameter(request, "fcast_qty8", ""));
		setFcastQty18(JSPUtil.getParameter(request, "fcast_qty18", ""));
		setFcastQty5(JSPUtil.getParameter(request, "fcast_qty5", ""));
		setFcastQty19(JSPUtil.getParameter(request, "fcast_qty19", ""));
		setFcastQty6(JSPUtil.getParameter(request, "fcast_qty6", ""));
		setFcastQty3(JSPUtil.getParameter(request, "fcast_qty3", ""));
		setFcastQty4(JSPUtil.getParameter(request, "fcast_qty4", ""));
		setFcastQty1(JSPUtil.getParameter(request, "fcast_qty1", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setFcastQty2(JSPUtil.getParameter(request, "fcast_qty2", ""));
		setFcastQty12(JSPUtil.getParameter(request, "fcast_qty12", ""));
		setFcastQty13(JSPUtil.getParameter(request, "fcast_qty13", ""));
		setFcastQty10(JSPUtil.getParameter(request, "fcast_qty10", ""));
		setFcastQty11(JSPUtil.getParameter(request, "fcast_qty11", ""));
		setFcastQty16(JSPUtil.getParameter(request, "fcast_qty16", ""));
		setFcastQty17(JSPUtil.getParameter(request, "fcast_qty17", ""));
		setFcastQty14(JSPUtil.getParameter(request, "fcast_qty14", ""));
		setFcastQty9(JSPUtil.getParameter(request, "fcast_qty9", ""));
		setFcastQty15(JSPUtil.getParameter(request, "fcast_qty15", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqTrspModCd(JSPUtil.getParameter(request, "eq_trsp_mod_cd", ""));
		setEtbDt(JSPUtil.getParameter(request, "etb_dt", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setFcastQty20(JSPUtil.getParameter(request, "fcast_qty20", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailRepoListVO[]
	 */
	public AvailRepoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvailRepoListVO[]
	 */
	public AvailRepoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailRepoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] fcastQty7 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty7", length));
			String[] headCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "head_cntr_tpsz_cd", length));
			String[] fcastQty8 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty8", length));
			String[] fcastQty18 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty18", length));
			String[] fcastQty5 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty5", length));
			String[] fcastQty19 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty19", length));
			String[] fcastQty6 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty6", length));
			String[] fcastQty3 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty3", length));
			String[] fcastQty4 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty4", length));
			String[] fcastQty1 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty1", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] fcastQty2 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty2", length));
			String[] fcastQty12 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty12", length));
			String[] fcastQty13 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty13", length));
			String[] fcastQty10 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty10", length));
			String[] fcastQty11 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty11", length));
			String[] fcastQty16 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty16", length));
			String[] fcastQty17 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty17", length));
			String[] fcastQty14 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty14", length));
			String[] fcastQty9 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty9", length));
			String[] fcastQty15 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty15", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqTrspModCd = (JSPUtil.getParameter(request, prefix	+ "eq_trsp_mod_cd", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] fcastQty20 = (JSPUtil.getParameter(request, prefix	+ "fcast_qty20", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			
			for (int i = 0; i < length; i++) {
				model = new AvailRepoListVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (fcastQty7[i] != null)
					model.setFcastQty7(fcastQty7[i]);
				if (headCntrTpszCd[i] != null)
					model.setHeadCntrTpszCd(headCntrTpszCd[i]);
				if (fcastQty8[i] != null)
					model.setFcastQty8(fcastQty8[i]);
				if (fcastQty18[i] != null)
					model.setFcastQty18(fcastQty18[i]);
				if (fcastQty5[i] != null)
					model.setFcastQty5(fcastQty5[i]);
				if (fcastQty19[i] != null)
					model.setFcastQty19(fcastQty19[i]);
				if (fcastQty6[i] != null)
					model.setFcastQty6(fcastQty6[i]);
				if (fcastQty3[i] != null)
					model.setFcastQty3(fcastQty3[i]);
				if (fcastQty4[i] != null)
					model.setFcastQty4(fcastQty4[i]);
				if (fcastQty1[i] != null)
					model.setFcastQty1(fcastQty1[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (fcastQty2[i] != null)
					model.setFcastQty2(fcastQty2[i]);
				if (fcastQty12[i] != null)
					model.setFcastQty12(fcastQty12[i]);
				if (fcastQty13[i] != null)
					model.setFcastQty13(fcastQty13[i]);
				if (fcastQty10[i] != null)
					model.setFcastQty10(fcastQty10[i]);
				if (fcastQty11[i] != null)
					model.setFcastQty11(fcastQty11[i]);
				if (fcastQty16[i] != null)
					model.setFcastQty16(fcastQty16[i]);
				if (fcastQty17[i] != null)
					model.setFcastQty17(fcastQty17[i]);
				if (fcastQty14[i] != null)
					model.setFcastQty14(fcastQty14[i]);
				if (fcastQty9[i] != null)
					model.setFcastQty9(fcastQty9[i]);
				if (fcastQty15[i] != null)
					model.setFcastQty15(fcastQty15[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqTrspModCd[i] != null)
					model.setEqTrspModCd(eqTrspModCd[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (fcastQty20[i] != null)
					model.setFcastQty20(fcastQty20[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailRepoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvailRepoListVO[]
	 */
	public AvailRepoListVO[] getAvailRepoListVOs(){
		AvailRepoListVO[] vos = (AvailRepoListVO[])models.toArray(new AvailRepoListVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty7 = this.fcastQty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCntrTpszCd = this.headCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty8 = this.fcastQty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty18 = this.fcastQty18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty5 = this.fcastQty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty19 = this.fcastQty19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty6 = this.fcastQty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty3 = this.fcastQty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty4 = this.fcastQty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty1 = this.fcastQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty2 = this.fcastQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty12 = this.fcastQty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty13 = this.fcastQty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty10 = this.fcastQty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty11 = this.fcastQty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty16 = this.fcastQty16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty17 = this.fcastQty17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty14 = this.fcastQty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty9 = this.fcastQty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty15 = this.fcastQty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTrspModCd = this.eqTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty20 = this.fcastQty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
