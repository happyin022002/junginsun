/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolMvmtCompareSmryMGTVO.java
*@FileTitle : PoolMvmtCompareSmryMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.05 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolMvmtCompareSmryMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolMvmtCompareSmryMGTVO> models = new ArrayList<PoolMvmtCompareSmryMGTVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String mgmtOnhdt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String poolChssMvmtYdCd = null;
	/* Column Info */
	private String ownOffhdt = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String unmatching = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mgmtUsddys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String ownOnhyd = null;
	/* Column Info */
	private String chssOwnrCoCd = null;
	/* Column Info */
	private String chssUnit = null;
	/* Column Info */
	private String matchingDay = null;
	/* Column Info */
	private String ownOnhdt = null;
	/* Column Info */
	private String cntrOwnrCoCd = null;
	/* Column Info */
	private String onhdt = null;
	/* Column Info */
	private String mgmtOnhyd = null;
	/* Column Info */
	private String poolChssMvmtDt = null;
	/* Column Info */
	private String comDivision = null;
	/* Column Info */
	private String divison = null;
	/* Column Info */
	private String ownChssMvmtDt = null;
	/* Column Info */
	private String ownChssMvmtYdComFlg = null;
	/* Column Info */
	private String ownChssUsdDys = null;
	/* Column Info */
	private String cntrChss = null;
	/* Column Info */
	private String mgmtOffhdt = null;
	/* Column Info */
	private String ownOffhyd = null;
	/* Column Info */
	private String ownUsdy = null;
	/* Column Info */
	private String ownChssMvmtYdCd = null;
	/* Column Info */
	private String matching = null;
	/* Column Info */
	private String mgmtOffhyd = null;
	/* Column Info */
	private String poolChssUsdDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String unmatchingDay = null;
	/* Column Info */
	private String poolUnit = null;
	/* Column Info */
	private String chssNoCnt = null;
	/* Column Info */
	private String poolChssMvmtYdComFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolMvmtCompareSmryMGTVO() {}

	public PoolMvmtCompareSmryMGTVO(String ibflag, String pagerows, String total, String chssPoolCd, String poolChssMvmtYdCd, String chssNo, String unmatching, String rate, String chssOwnrCoCd, String matchingDay, String chssUnit, String cntrOwnrCoCd, String poolChssMvmtDt, String comDivision, String divison, String ownChssMvmtDt, String ownChssMvmtYdComFlg, String ownChssUsdDys, String cntrChss, String ownChssMvmtYdCd, String matching, String poolChssUsdDys, String cntrNo, String unmatchingDay, String poolUnit, String poolChssMvmtYdComFlg, String chssNoCnt, String onhdt, String ownOnhdt, String ownOnhyd, String ownOffhdt, String ownOffhyd, String ownUsdy, String mgmtOnhdt, String mgmtOnhyd, String mgmtOffhdt, String mgmtOffhyd, String mgmtUsddys) {
		this.total = total;
		this.mgmtOnhdt = mgmtOnhdt;
		this.chssPoolCd = chssPoolCd;
		this.poolChssMvmtYdCd = poolChssMvmtYdCd;
		this.ownOffhdt = ownOffhdt;
		this.chssNo = chssNo;
		this.unmatching = unmatching;
		this.pagerows = pagerows;
		this.mgmtUsddys = mgmtUsddys;
		this.ibflag = ibflag;
		this.rate = rate;
		this.ownOnhyd = ownOnhyd;
		this.chssOwnrCoCd = chssOwnrCoCd;
		this.chssUnit = chssUnit;
		this.matchingDay = matchingDay;
		this.ownOnhdt = ownOnhdt;
		this.cntrOwnrCoCd = cntrOwnrCoCd;
		this.onhdt = onhdt;
		this.mgmtOnhyd = mgmtOnhyd;
		this.poolChssMvmtDt = poolChssMvmtDt;
		this.comDivision = comDivision;
		this.divison = divison;
		this.ownChssMvmtDt = ownChssMvmtDt;
		this.ownChssMvmtYdComFlg = ownChssMvmtYdComFlg;
		this.ownChssUsdDys = ownChssUsdDys;
		this.cntrChss = cntrChss;
		this.mgmtOffhdt = mgmtOffhdt;
		this.ownOffhyd = ownOffhyd;
		this.ownUsdy = ownUsdy;
		this.ownChssMvmtYdCd = ownChssMvmtYdCd;
		this.matching = matching;
		this.mgmtOffhyd = mgmtOffhyd;
		this.poolChssUsdDys = poolChssUsdDys;
		this.cntrNo = cntrNo;
		this.unmatchingDay = unmatchingDay;
		this.poolUnit = poolUnit;
		this.chssNoCnt = chssNoCnt;
		this.poolChssMvmtYdComFlg = poolChssMvmtYdComFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("mgmt_onhdt", getMgmtOnhdt());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("pool_chss_mvmt_yd_cd", getPoolChssMvmtYdCd());
		this.hashColumns.put("own_offhdt", getownOffhdt());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("unmatching", getUnmatching());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mgmt_usddys", getMgmtUsddys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("own_onhyd", getownOnhyd());
		this.hashColumns.put("chss_ownr_co_cd", getChssOwnrCoCd());
		this.hashColumns.put("chss_unit", getChssUnit());
		this.hashColumns.put("matching_day", getMatchingDay());
		this.hashColumns.put("own_onhdt", getownOnhdt());
		this.hashColumns.put("cntr_ownr_co_cd", getCntrOwnrCoCd());
		this.hashColumns.put("onhdt", getOnhdt());
		this.hashColumns.put("mgmt_onhyd", getMgmtOnhyd());
		this.hashColumns.put("pool_chss_mvmt_dt", getPoolChssMvmtDt());
		this.hashColumns.put("com_division", getComDivision());
		this.hashColumns.put("divison", getDivison());
		this.hashColumns.put("own_chss_mvmt_dt", getownChssMvmtDt());
		this.hashColumns.put("own_chss_mvmt_yd_com_flg", getownChssMvmtYdComFlg());
		this.hashColumns.put("own_chss_usd_dys", getownChssUsdDys());
		this.hashColumns.put("cntr_chss", getCntrChss());
		this.hashColumns.put("mgmt_offhdt", getMgmtOffhdt());
		this.hashColumns.put("own_offhyd", getownOffhyd());
		this.hashColumns.put("own_usdy", getownUsdy());
		this.hashColumns.put("own_chss_mvmt_yd_cd", getownChssMvmtYdCd());
		this.hashColumns.put("matching", getMatching());
		this.hashColumns.put("mgmt_offhyd", getMgmtOffhyd());
		this.hashColumns.put("pool_chss_usd_dys", getPoolChssUsdDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("unmatching_day", getUnmatchingDay());
		this.hashColumns.put("pool_unit", getPoolUnit());
		this.hashColumns.put("chss_no_cnt", getChssNoCnt());
		this.hashColumns.put("pool_chss_mvmt_yd_com_flg", getPoolChssMvmtYdComFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("mgmt_onhdt", "mgmtOnhdt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("pool_chss_mvmt_yd_cd", "poolChssMvmtYdCd");
		this.hashFields.put("own_offhdt", "ownOffhdt");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("unmatching", "unmatching");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mgmt_usddys", "mgmtUsddys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("own_onhyd", "ownOnhyd");
		this.hashFields.put("chss_ownr_co_cd", "chssOwnrCoCd");
		this.hashFields.put("chss_unit", "chssUnit");
		this.hashFields.put("matching_day", "matchingDay");
		this.hashFields.put("own_onhdt", "ownOnhdt");
		this.hashFields.put("cntr_ownr_co_cd", "cntrOwnrCoCd");
		this.hashFields.put("onhdt", "onhdt");
		this.hashFields.put("mgmt_onhyd", "mgmtOnhyd");
		this.hashFields.put("pool_chss_mvmt_dt", "poolChssMvmtDt");
		this.hashFields.put("com_division", "comDivision");
		this.hashFields.put("divison", "divison");
		this.hashFields.put("own_chss_mvmt_dt", "ownChssMvmtDt");
		this.hashFields.put("own_chss_mvmt_yd_com_flg", "ownChssMvmtYdComFlg");
		this.hashFields.put("own_chss_usd_dys", "ownChssUsdDys");
		this.hashFields.put("cntr_chss", "cntrChss");
		this.hashFields.put("mgmt_offhdt", "mgmtOffhdt");
		this.hashFields.put("own_offhyd", "ownOffhyd");
		this.hashFields.put("own_usdy", "ownUsdy");
		this.hashFields.put("own_chss_mvmt_yd_cd", "ownChssMvmtYdCd");
		this.hashFields.put("matching", "matching");
		this.hashFields.put("mgmt_offhyd", "mgmtOffhyd");
		this.hashFields.put("pool_chss_usd_dys", "poolChssUsdDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("unmatching_day", "unmatchingDay");
		this.hashFields.put("pool_unit", "poolUnit");
		this.hashFields.put("chss_no_cnt", "chssNoCnt");
		this.hashFields.put("pool_chss_mvmt_yd_com_flg", "poolChssMvmtYdComFlg");
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
	 * @return mgmtOnhdt
	 */
	public String getMgmtOnhdt() {
		return this.mgmtOnhdt;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return poolChssMvmtYdCd
	 */
	public String getPoolChssMvmtYdCd() {
		return this.poolChssMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return ownOffhdt
	 */
	public String getownOffhdt() {
		return this.ownOffhdt;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return unmatching
	 */
	public String getUnmatching() {
		return this.unmatching;
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
	 * @return mgmtUsddys
	 */
	public String getMgmtUsddys() {
		return this.mgmtUsddys;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return ownOnhyd
	 */
	public String getownOnhyd() {
		return this.ownOnhyd;
	}
	
	/**
	 * Column Info
	 * @return chssOwnrCoCd
	 */
	public String getChssOwnrCoCd() {
		return this.chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return chssUnit
	 */
	public String getChssUnit() {
		return this.chssUnit;
	}
	
	/**
	 * Column Info
	 * @return matchingDay
	 */
	public String getMatchingDay() {
		return this.matchingDay;
	}
	
	/**
	 * Column Info
	 * @return ownOnhdt
	 */
	public String getownOnhdt() {
		return this.ownOnhdt;
	}
	
	/**
	 * Column Info
	 * @return cntrOwnrCoCd
	 */
	public String getCntrOwnrCoCd() {
		return this.cntrOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return onhdt
	 */
	public String getOnhdt() {
		return this.onhdt;
	}
	
	/**
	 * Column Info
	 * @return mgmtOnhyd
	 */
	public String getMgmtOnhyd() {
		return this.mgmtOnhyd;
	}
	
	/**
	 * Column Info
	 * @return poolChssMvmtDt
	 */
	public String getPoolChssMvmtDt() {
		return this.poolChssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return comDivision
	 */
	public String getComDivision() {
		return this.comDivision;
	}
	
	/**
	 * Column Info
	 * @return divison
	 */
	public String getDivison() {
		return this.divison;
	}
	
	/**
	 * Column Info
	 * @return ownChssMvmtDt
	 */
	public String getownChssMvmtDt() {
		return this.ownChssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return ownChssMvmtYdComFlg
	 */
	public String getownChssMvmtYdComFlg() {
		return this.ownChssMvmtYdComFlg;
	}
	
	/**
	 * Column Info
	 * @return ownChssUsdDys
	 */
	public String getownChssUsdDys() {
		return this.ownChssUsdDys;
	}
	
	/**
	 * Column Info
	 * @return cntrChss
	 */
	public String getCntrChss() {
		return this.cntrChss;
	}
	
	/**
	 * Column Info
	 * @return mgmtOffhdt
	 */
	public String getMgmtOffhdt() {
		return this.mgmtOffhdt;
	}
	
	/**
	 * Column Info
	 * @return ownOffhyd
	 */
	public String getownOffhyd() {
		return this.ownOffhyd;
	}
	
	/**
	 * Column Info
	 * @return ownUsdy
	 */
	public String getownUsdy() {
		return this.ownUsdy;
	}
	
	/**
	 * Column Info
	 * @return ownChssMvmtYdCd
	 */
	public String getownChssMvmtYdCd() {
		return this.ownChssMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return matching
	 */
	public String getMatching() {
		return this.matching;
	}
	
	/**
	 * Column Info
	 * @return mgmtOffhyd
	 */
	public String getMgmtOffhyd() {
		return this.mgmtOffhyd;
	}
	
	/**
	 * Column Info
	 * @return poolChssUsdDys
	 */
	public String getPoolChssUsdDys() {
		return this.poolChssUsdDys;
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
	 * @return unmatchingDay
	 */
	public String getUnmatchingDay() {
		return this.unmatchingDay;
	}
	
	/**
	 * Column Info
	 * @return poolUnit
	 */
	public String getPoolUnit() {
		return this.poolUnit;
	}
	
	/**
	 * Column Info
	 * @return chssNoCnt
	 */
	public String getChssNoCnt() {
		return this.chssNoCnt;
	}
	
	/**
	 * Column Info
	 * @return poolChssMvmtYdComFlg
	 */
	public String getPoolChssMvmtYdComFlg() {
		return this.poolChssMvmtYdComFlg;
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
	 * @param mgmtOnhdt
	 */
	public void setMgmtOnhdt(String mgmtOnhdt) {
		this.mgmtOnhdt = mgmtOnhdt;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param poolChssMvmtYdCd
	 */
	public void setPoolChssMvmtYdCd(String poolChssMvmtYdCd) {
		this.poolChssMvmtYdCd = poolChssMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param ownOffhdt
	 */
	public void setownOffhdt(String ownOffhdt) {
		this.ownOffhdt = ownOffhdt;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param unmatching
	 */
	public void setUnmatching(String unmatching) {
		this.unmatching = unmatching;
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
	 * @param mgmtUsddys
	 */
	public void setMgmtUsddys(String mgmtUsddys) {
		this.mgmtUsddys = mgmtUsddys;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param ownOnhyd
	 */
	public void setownOnhyd(String ownOnhyd) {
		this.ownOnhyd = ownOnhyd;
	}
	
	/**
	 * Column Info
	 * @param chssOwnrCoCd
	 */
	public void setChssOwnrCoCd(String chssOwnrCoCd) {
		this.chssOwnrCoCd = chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param chssUnit
	 */
	public void setChssUnit(String chssUnit) {
		this.chssUnit = chssUnit;
	}
	
	/**
	 * Column Info
	 * @param matchingDay
	 */
	public void setMatchingDay(String matchingDay) {
		this.matchingDay = matchingDay;
	}
	
	/**
	 * Column Info
	 * @param ownOnhdt
	 */
	public void setownOnhdt(String ownOnhdt) {
		this.ownOnhdt = ownOnhdt;
	}
	
	/**
	 * Column Info
	 * @param cntrOwnrCoCd
	 */
	public void setCntrOwnrCoCd(String cntrOwnrCoCd) {
		this.cntrOwnrCoCd = cntrOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param onhdt
	 */
	public void setOnhdt(String onhdt) {
		this.onhdt = onhdt;
	}
	
	/**
	 * Column Info
	 * @param mgmtOnhyd
	 */
	public void setMgmtOnhyd(String mgmtOnhyd) {
		this.mgmtOnhyd = mgmtOnhyd;
	}
	
	/**
	 * Column Info
	 * @param poolChssMvmtDt
	 */
	public void setPoolChssMvmtDt(String poolChssMvmtDt) {
		this.poolChssMvmtDt = poolChssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param comDivision
	 */
	public void setComDivision(String comDivision) {
		this.comDivision = comDivision;
	}
	
	/**
	 * Column Info
	 * @param divison
	 */
	public void setDivison(String divison) {
		this.divison = divison;
	}
	
	/**
	 * Column Info
	 * @param ownChssMvmtDt
	 */
	public void setownChssMvmtDt(String ownChssMvmtDt) {
		this.ownChssMvmtDt = ownChssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param ownChssMvmtYdComFlg
	 */
	public void setownChssMvmtYdComFlg(String ownChssMvmtYdComFlg) {
		this.ownChssMvmtYdComFlg = ownChssMvmtYdComFlg;
	}
	
	/**
	 * Column Info
	 * @param ownChssUsdDys
	 */
	public void setownChssUsdDys(String ownChssUsdDys) {
		this.ownChssUsdDys = ownChssUsdDys;
	}
	
	/**
	 * Column Info
	 * @param cntrChss
	 */
	public void setCntrChss(String cntrChss) {
		this.cntrChss = cntrChss;
	}
	
	/**
	 * Column Info
	 * @param mgmtOffhdt
	 */
	public void setMgmtOffhdt(String mgmtOffhdt) {
		this.mgmtOffhdt = mgmtOffhdt;
	}
	
	/**
	 * Column Info
	 * @param ownOffhyd
	 */
	public void setownOffhyd(String ownOffhyd) {
		this.ownOffhyd = ownOffhyd;
	}
	
	/**
	 * Column Info
	 * @param ownUsdy
	 */
	public void setownUsdy(String ownUsdy) {
		this.ownUsdy = ownUsdy;
	}
	
	/**
	 * Column Info
	 * @param ownChssMvmtYdCd
	 */
	public void setownChssMvmtYdCd(String ownChssMvmtYdCd) {
		this.ownChssMvmtYdCd = ownChssMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param matching
	 */
	public void setMatching(String matching) {
		this.matching = matching;
	}
	
	/**
	 * Column Info
	 * @param mgmtOffhyd
	 */
	public void setMgmtOffhyd(String mgmtOffhyd) {
		this.mgmtOffhyd = mgmtOffhyd;
	}
	
	/**
	 * Column Info
	 * @param poolChssUsdDys
	 */
	public void setPoolChssUsdDys(String poolChssUsdDys) {
		this.poolChssUsdDys = poolChssUsdDys;
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
	 * @param unmatchingDay
	 */
	public void setUnmatchingDay(String unmatchingDay) {
		this.unmatchingDay = unmatchingDay;
	}
	
	/**
	 * Column Info
	 * @param poolUnit
	 */
	public void setPoolUnit(String poolUnit) {
		this.poolUnit = poolUnit;
	}
	
	/**
	 * Column Info
	 * @param chssNoCnt
	 */
	public void setChssNoCnt(String chssNoCnt) {
		this.chssNoCnt = chssNoCnt;
	}
	
	/**
	 * Column Info
	 * @param poolChssMvmtYdComFlg
	 */
	public void setPoolChssMvmtYdComFlg(String poolChssMvmtYdComFlg) {
		this.poolChssMvmtYdComFlg = poolChssMvmtYdComFlg;
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
		setMgmtOnhdt(JSPUtil.getParameter(request, prefix + "mgmt_onhdt", ""));
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setPoolChssMvmtYdCd(JSPUtil.getParameter(request, prefix + "pool_chss_mvmt_yd_cd", ""));
		setownOffhdt(JSPUtil.getParameter(request, prefix + "own_offhdt", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setUnmatching(JSPUtil.getParameter(request, prefix + "unmatching", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMgmtUsddys(JSPUtil.getParameter(request, prefix + "mgmt_usddys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setownOnhyd(JSPUtil.getParameter(request, prefix + "own_onhyd", ""));
		setChssOwnrCoCd(JSPUtil.getParameter(request, prefix + "chss_ownr_co_cd", ""));
		setChssUnit(JSPUtil.getParameter(request, prefix + "chss_unit", ""));
		setMatchingDay(JSPUtil.getParameter(request, prefix + "matching_day", ""));
		setownOnhdt(JSPUtil.getParameter(request, prefix + "own_onhdt", ""));
		setCntrOwnrCoCd(JSPUtil.getParameter(request, prefix + "cntr_ownr_co_cd", ""));
		setOnhdt(JSPUtil.getParameter(request, prefix + "onhdt", ""));
		setMgmtOnhyd(JSPUtil.getParameter(request, prefix + "mgmt_onhyd", ""));
		setPoolChssMvmtDt(JSPUtil.getParameter(request, prefix + "pool_chss_mvmt_dt", ""));
		setComDivision(JSPUtil.getParameter(request, prefix + "com_division", ""));
		setDivison(JSPUtil.getParameter(request, prefix + "divison", ""));
		setownChssMvmtDt(JSPUtil.getParameter(request, prefix + "own_chss_mvmt_dt", ""));
		setownChssMvmtYdComFlg(JSPUtil.getParameter(request, prefix + "own_chss_mvmt_yd_com_flg", ""));
		setownChssUsdDys(JSPUtil.getParameter(request, prefix + "own_chss_usd_dys", ""));
		setCntrChss(JSPUtil.getParameter(request, prefix + "cntr_chss", ""));
		setMgmtOffhdt(JSPUtil.getParameter(request, prefix + "mgmt_offhdt", ""));
		setownOffhyd(JSPUtil.getParameter(request, prefix + "own_offhyd", ""));
		setownUsdy(JSPUtil.getParameter(request, prefix + "own_usdy", ""));
		setownChssMvmtYdCd(JSPUtil.getParameter(request, prefix + "own_chss_mvmt_yd_cd", ""));
		setMatching(JSPUtil.getParameter(request, prefix + "matching", ""));
		setMgmtOffhyd(JSPUtil.getParameter(request, prefix + "mgmt_offhyd", ""));
		setPoolChssUsdDys(JSPUtil.getParameter(request, prefix + "pool_chss_usd_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setUnmatchingDay(JSPUtil.getParameter(request, prefix + "unmatching_day", ""));
		setPoolUnit(JSPUtil.getParameter(request, prefix + "pool_unit", ""));
		setChssNoCnt(JSPUtil.getParameter(request, prefix + "chss_no_cnt", ""));
		setPoolChssMvmtYdComFlg(JSPUtil.getParameter(request, prefix + "pool_chss_mvmt_yd_com_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolMvmtCompareSmryMGTVO[]
	 */
	public PoolMvmtCompareSmryMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolMvmtCompareSmryMGTVO[]
	 */
	public PoolMvmtCompareSmryMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolMvmtCompareSmryMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] mgmtOnhdt = (JSPUtil.getParameter(request, prefix	+ "mgmt_onhdt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] poolChssMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "pool_chss_mvmt_yd_cd", length));
			String[] ownOffhdt = (JSPUtil.getParameter(request, prefix	+ "own_offhdt", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] unmatching = (JSPUtil.getParameter(request, prefix	+ "unmatching", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mgmtUsddys = (JSPUtil.getParameter(request, prefix	+ "mgmt_usddys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] ownOnhyd = (JSPUtil.getParameter(request, prefix	+ "own_onhyd", length));
			String[] chssOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "chss_ownr_co_cd", length));
			String[] chssUnit = (JSPUtil.getParameter(request, prefix	+ "chss_unit", length));
			String[] matchingDay = (JSPUtil.getParameter(request, prefix	+ "matching_day", length));
			String[] ownOnhdt = (JSPUtil.getParameter(request, prefix	+ "own_onhdt", length));
			String[] cntrOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ownr_co_cd", length));
			String[] onhdt = (JSPUtil.getParameter(request, prefix	+ "onhdt", length));
			String[] mgmtOnhyd = (JSPUtil.getParameter(request, prefix	+ "mgmt_onhyd", length));
			String[] poolChssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "pool_chss_mvmt_dt", length));
			String[] comDivision = (JSPUtil.getParameter(request, prefix	+ "com_division", length));
			String[] divison = (JSPUtil.getParameter(request, prefix	+ "divison", length));
			String[] ownChssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "own_chss_mvmt_dt", length));
			String[] ownChssMvmtYdComFlg = (JSPUtil.getParameter(request, prefix	+ "own_chss_mvmt_yd_com_flg", length));
			String[] ownChssUsdDys = (JSPUtil.getParameter(request, prefix	+ "own_chss_usd_dys", length));
			String[] cntrChss = (JSPUtil.getParameter(request, prefix	+ "cntr_chss", length));
			String[] mgmtOffhdt = (JSPUtil.getParameter(request, prefix	+ "mgmt_offhdt", length));
			String[] ownOffhyd = (JSPUtil.getParameter(request, prefix	+ "own_offhyd", length));
			String[] ownUsdy = (JSPUtil.getParameter(request, prefix	+ "own_usdy", length));
			String[] ownChssMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "own_chss_mvmt_yd_cd", length));
			String[] matching = (JSPUtil.getParameter(request, prefix	+ "matching", length));
			String[] mgmtOffhyd = (JSPUtil.getParameter(request, prefix	+ "mgmt_offhyd", length));
			String[] poolChssUsdDys = (JSPUtil.getParameter(request, prefix	+ "pool_chss_usd_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] unmatchingDay = (JSPUtil.getParameter(request, prefix	+ "unmatching_day", length));
			String[] poolUnit = (JSPUtil.getParameter(request, prefix	+ "pool_unit", length));
			String[] chssNoCnt = (JSPUtil.getParameter(request, prefix	+ "chss_no_cnt", length));
			String[] poolChssMvmtYdComFlg = (JSPUtil.getParameter(request, prefix	+ "pool_chss_mvmt_yd_com_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolMvmtCompareSmryMGTVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (mgmtOnhdt[i] != null)
					model.setMgmtOnhdt(mgmtOnhdt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (poolChssMvmtYdCd[i] != null)
					model.setPoolChssMvmtYdCd(poolChssMvmtYdCd[i]);
				if (ownOffhdt[i] != null)
					model.setownOffhdt(ownOffhdt[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (unmatching[i] != null)
					model.setUnmatching(unmatching[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mgmtUsddys[i] != null)
					model.setMgmtUsddys(mgmtUsddys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (ownOnhyd[i] != null)
					model.setownOnhyd(ownOnhyd[i]);
				if (chssOwnrCoCd[i] != null)
					model.setChssOwnrCoCd(chssOwnrCoCd[i]);
				if (chssUnit[i] != null)
					model.setChssUnit(chssUnit[i]);
				if (matchingDay[i] != null)
					model.setMatchingDay(matchingDay[i]);
				if (ownOnhdt[i] != null)
					model.setownOnhdt(ownOnhdt[i]);
				if (cntrOwnrCoCd[i] != null)
					model.setCntrOwnrCoCd(cntrOwnrCoCd[i]);
				if (onhdt[i] != null)
					model.setOnhdt(onhdt[i]);
				if (mgmtOnhyd[i] != null)
					model.setMgmtOnhyd(mgmtOnhyd[i]);
				if (poolChssMvmtDt[i] != null)
					model.setPoolChssMvmtDt(poolChssMvmtDt[i]);
				if (comDivision[i] != null)
					model.setComDivision(comDivision[i]);
				if (divison[i] != null)
					model.setDivison(divison[i]);
				if (ownChssMvmtDt[i] != null)
					model.setownChssMvmtDt(ownChssMvmtDt[i]);
				if (ownChssMvmtYdComFlg[i] != null)
					model.setownChssMvmtYdComFlg(ownChssMvmtYdComFlg[i]);
				if (ownChssUsdDys[i] != null)
					model.setownChssUsdDys(ownChssUsdDys[i]);
				if (cntrChss[i] != null)
					model.setCntrChss(cntrChss[i]);
				if (mgmtOffhdt[i] != null)
					model.setMgmtOffhdt(mgmtOffhdt[i]);
				if (ownOffhyd[i] != null)
					model.setownOffhyd(ownOffhyd[i]);
				if (ownUsdy[i] != null)
					model.setownUsdy(ownUsdy[i]);
				if (ownChssMvmtYdCd[i] != null)
					model.setownChssMvmtYdCd(ownChssMvmtYdCd[i]);
				if (matching[i] != null)
					model.setMatching(matching[i]);
				if (mgmtOffhyd[i] != null)
					model.setMgmtOffhyd(mgmtOffhyd[i]);
				if (poolChssUsdDys[i] != null)
					model.setPoolChssUsdDys(poolChssUsdDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (unmatchingDay[i] != null)
					model.setUnmatchingDay(unmatchingDay[i]);
				if (poolUnit[i] != null)
					model.setPoolUnit(poolUnit[i]);
				if (chssNoCnt[i] != null)
					model.setChssNoCnt(chssNoCnt[i]);
				if (poolChssMvmtYdComFlg[i] != null)
					model.setPoolChssMvmtYdComFlg(poolChssMvmtYdComFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolMvmtCompareSmryMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolMvmtCompareSmryMGTVO[]
	 */
	public PoolMvmtCompareSmryMGTVO[] getPoolMvmtCompareSmryMGTVOs(){
		PoolMvmtCompareSmryMGTVO[] vos = (PoolMvmtCompareSmryMGTVO[])models.toArray(new PoolMvmtCompareSmryMGTVO[models.size()]);
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
		this.mgmtOnhdt = this.mgmtOnhdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssMvmtYdCd = this.poolChssMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownOffhdt = this.ownOffhdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmatching = this.unmatching .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgmtUsddys = this.mgmtUsddys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownOnhyd = this.ownOnhyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOwnrCoCd = this.chssOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssUnit = this.chssUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchingDay = this.matchingDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownOnhdt = this.ownOnhdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOwnrCoCd = this.cntrOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhdt = this.onhdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgmtOnhyd = this.mgmtOnhyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssMvmtDt = this.poolChssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDivision = this.comDivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divison = this.divison .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownChssMvmtDt = this.ownChssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownChssMvmtYdComFlg = this.ownChssMvmtYdComFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownChssUsdDys = this.ownChssUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChss = this.cntrChss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgmtOffhdt = this.mgmtOffhdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownOffhyd = this.ownOffhyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownUsdy = this.ownUsdy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownChssMvmtYdCd = this.ownChssMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matching = this.matching .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgmtOffhyd = this.mgmtOffhyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssUsdDys = this.poolChssUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmatchingDay = this.unmatchingDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolUnit = this.poolUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNoCnt = this.chssNoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssMvmtYdComFlg = this.poolChssMvmtYdComFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}