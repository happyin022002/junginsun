/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocPerformanceSummaryVO.java
*@FileTitle : DocPerformanceSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.08.11 김기종 
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocPerformanceSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocPerformanceSummaryVO> models = new ArrayList<DocPerformanceSummaryVO>();
	
	/* Column Info */
	private String qaTtlAverHh = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String totalTtlHourHh = null;
	/* Column Info */
	private String totalTtlAverHh = null;
	/* Column Info */
	private String qaTtlHourSs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rateTtlAverDd = null;
	/* Column Info */
	private String inputTtlHourHh = null;
	/* Column Info */
	private String qaTtlAverDd = null;
	/* Column Info */
	private String rateTtlAverSs = null;
	/* Column Info */
	private String rateTtlHourHh = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rateTtlHourDd = null;
	/* Column Info */
	private String inputTtlHourDd = null;
	/* Column Info */
	private String rateTtlHourMi = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String inputTtlHourSs = null;
	/* Column Info */
	private String qaTtlAverMi = null;
	/* Column Info */
	private String totalTtlEvent = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String qaTtlPic = null;
	/* Column Info */
	private String rateTtlPic = null;
	/* Column Info */
	private String inputTtlPic = null;
	/* Column Info */
	private String qaTtlEvent = null;
	/* Column Info */
	private String totalTtlPic = null;
	/* Column Info */
	private String inputTtlAverMi = null;
	/* Column Info */
	private String ttlBkg = null;
	/* Column Info */
	private String totalTtlAverDd = null;
	/* Column Info */
	private String totalTtlHourSs = null;
	/* Column Info */
	private String totalTtlAverSs = null;
	/* Column Info */
	private String rgn = null;
	/* Column Info */
	private String inputTtlAverHh = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String rateTtlEvent = null;
	/* Column Info */
	private String inputTtlAverDd = null;
	/* Column Info */
	private String inputTtlAverSs = null;
	/* Column Info */
	private String rateTtlAverMi = null;
	/* Column Info */
	private String qaTtlAverSs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qaTtlHourDd = null;
	/* Column Info */
	private String qaTtlHourMi = null;
	/* Column Info */
	private String qaTtlHourHh = null;
	/* Column Info */
	private String inputTtlEvent = null;
	/* Column Info */
	private String rateTtlAverHh = null;
	/* Column Info */
	private String inputTtlHourMi = null;
	/* Column Info */
	private String rateTtlHourSs = null;
	/* Column Info */
	private String divide = null;
	/* Column Info */
	private String totalTtlHourMi = null;
	/* Column Info */
	private String totalTtlHourDd = null;
	/* Column Info */
	private String totalTtlAverMi = null;
	/* Column Info */
	private String dpcsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocPerformanceSummaryVO() {}

	public DocPerformanceSummaryVO(String ibflag, String pagerows, String rgn, String rgnCd, String bkgOfcCd, String ttlBkg, String inputTtlEvent, String inputTtlPic, String inputTtlHourDd, String inputTtlHourHh, String inputTtlHourMi, String inputTtlHourSs, String inputTtlAverDd, String inputTtlAverHh, String inputTtlAverMi, String inputTtlAverSs, String rateTtlEvent, String rateTtlPic, String rateTtlHourDd, String rateTtlHourHh, String rateTtlHourMi, String rateTtlHourSs, String rateTtlAverDd, String rateTtlAverHh, String rateTtlAverMi, String rateTtlAverSs, String qaTtlEvent, String qaTtlPic, String qaTtlHourDd, String qaTtlHourHh, String qaTtlHourMi, String qaTtlHourSs, String qaTtlAverDd, String qaTtlAverHh, String qaTtlAverMi, String qaTtlAverSs, String totalTtlEvent, String totalTtlPic, String totalTtlHourDd, String totalTtlHourHh, String totalTtlHourMi, String totalTtlHourSs, String totalTtlAverDd, String totalTtlAverHh, String totalTtlAverMi, String dpcsOfcCd, String totalTtlAverSs, String fromDt, String polCd, String vvdCd, String divide, String period, String podCd, String toDt, String bkgNo) {
		this.qaTtlAverHh = qaTtlAverHh;
		this.rgnCd = rgnCd;
		this.totalTtlHourHh = totalTtlHourHh;
		this.totalTtlAverHh = totalTtlAverHh;
		this.qaTtlHourSs = qaTtlHourSs;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.rateTtlAverDd = rateTtlAverDd;
		this.inputTtlHourHh = inputTtlHourHh;
		this.qaTtlAverDd = qaTtlAverDd;
		this.rateTtlAverSs = rateTtlAverSs;
		this.rateTtlHourHh = rateTtlHourHh;
		this.bkgOfcCd = bkgOfcCd;
		this.rateTtlHourDd = rateTtlHourDd;
		this.inputTtlHourDd = inputTtlHourDd;
		this.rateTtlHourMi = rateTtlHourMi;
		this.period = period;
		this.inputTtlHourSs = inputTtlHourSs;
		this.qaTtlAverMi = qaTtlAverMi;
		this.totalTtlEvent = totalTtlEvent;
		this.toDt = toDt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.qaTtlPic = qaTtlPic;
		this.rateTtlPic = rateTtlPic;
		this.inputTtlPic = inputTtlPic;
		this.qaTtlEvent = qaTtlEvent;
		this.totalTtlPic = totalTtlPic;
		this.inputTtlAverMi = inputTtlAverMi;
		this.ttlBkg = ttlBkg;
		this.totalTtlAverDd = totalTtlAverDd;
		this.totalTtlHourSs = totalTtlHourSs;
		this.totalTtlAverSs = totalTtlAverSs;
		this.rgn = rgn;
		this.inputTtlAverHh = inputTtlAverHh;
		this.fromDt = fromDt;
		this.rateTtlEvent = rateTtlEvent;
		this.inputTtlAverDd = inputTtlAverDd;
		this.inputTtlAverSs = inputTtlAverSs;
		this.rateTtlAverMi = rateTtlAverMi;
		this.qaTtlAverSs = qaTtlAverSs;
		this.ibflag = ibflag;
		this.qaTtlHourDd = qaTtlHourDd;
		this.qaTtlHourMi = qaTtlHourMi;
		this.qaTtlHourHh = qaTtlHourHh;
		this.inputTtlEvent = inputTtlEvent;
		this.rateTtlAverHh = rateTtlAverHh;
		this.inputTtlHourMi = inputTtlHourMi;
		this.rateTtlHourSs = rateTtlHourSs;
		this.divide = divide;
		this.totalTtlHourMi = totalTtlHourMi;
		this.totalTtlHourDd = totalTtlHourDd;
		this.totalTtlAverMi = totalTtlAverMi;
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qa_ttl_aver_hh", getQaTtlAverHh());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("total_ttl_hour_hh", getTotalTtlHourHh());
		this.hashColumns.put("total_ttl_aver_hh", getTotalTtlAverHh());
		this.hashColumns.put("qa_ttl_hour_ss", getQaTtlHourSs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rate_ttl_aver_dd", getRateTtlAverDd());
		this.hashColumns.put("input_ttl_hour_hh", getInputTtlHourHh());
		this.hashColumns.put("qa_ttl_aver_dd", getQaTtlAverDd());
		this.hashColumns.put("rate_ttl_aver_ss", getRateTtlAverSs());
		this.hashColumns.put("rate_ttl_hour_hh", getRateTtlHourHh());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rate_ttl_hour_dd", getRateTtlHourDd());
		this.hashColumns.put("input_ttl_hour_dd", getInputTtlHourDd());
		this.hashColumns.put("rate_ttl_hour_mi", getRateTtlHourMi());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("input_ttl_hour_ss", getInputTtlHourSs());
		this.hashColumns.put("qa_ttl_aver_mi", getQaTtlAverMi());
		this.hashColumns.put("total_ttl_event", getTotalTtlEvent());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("qa_ttl_pic", getQaTtlPic());
		this.hashColumns.put("rate_ttl_pic", getRateTtlPic());
		this.hashColumns.put("input_ttl_pic", getInputTtlPic());
		this.hashColumns.put("qa_ttl_event", getQaTtlEvent());
		this.hashColumns.put("total_ttl_pic", getTotalTtlPic());
		this.hashColumns.put("input_ttl_aver_mi", getInputTtlAverMi());
		this.hashColumns.put("ttl_bkg", getTtlBkg());
		this.hashColumns.put("total_ttl_aver_dd", getTotalTtlAverDd());
		this.hashColumns.put("total_ttl_hour_ss", getTotalTtlHourSs());
		this.hashColumns.put("total_ttl_aver_ss", getTotalTtlAverSs());
		this.hashColumns.put("rgn", getRgn());
		this.hashColumns.put("input_ttl_aver_hh", getInputTtlAverHh());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("rate_ttl_event", getRateTtlEvent());
		this.hashColumns.put("input_ttl_aver_dd", getInputTtlAverDd());
		this.hashColumns.put("input_ttl_aver_ss", getInputTtlAverSs());
		this.hashColumns.put("rate_ttl_aver_mi", getRateTtlAverMi());
		this.hashColumns.put("qa_ttl_aver_ss", getQaTtlAverSs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qa_ttl_hour_dd", getQaTtlHourDd());
		this.hashColumns.put("qa_ttl_hour_mi", getQaTtlHourMi());
		this.hashColumns.put("qa_ttl_hour_hh", getQaTtlHourHh());
		this.hashColumns.put("input_ttl_event", getInputTtlEvent());
		this.hashColumns.put("rate_ttl_aver_hh", getRateTtlAverHh());
		this.hashColumns.put("input_ttl_hour_mi", getInputTtlHourMi());
		this.hashColumns.put("rate_ttl_hour_ss", getRateTtlHourSs());
		this.hashColumns.put("divide", getDivide());
		this.hashColumns.put("total_ttl_hour_mi", getTotalTtlHourMi());
		this.hashColumns.put("total_ttl_hour_dd", getTotalTtlHourDd());
		this.hashColumns.put("total_ttl_aver_mi", getTotalTtlAverMi());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qa_ttl_aver_hh", "qaTtlAverHh");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("total_ttl_hour_hh", "totalTtlHourHh");
		this.hashFields.put("total_ttl_aver_hh", "totalTtlAverHh");
		this.hashFields.put("qa_ttl_hour_ss", "qaTtlHourSs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rate_ttl_aver_dd", "rateTtlAverDd");
		this.hashFields.put("input_ttl_hour_hh", "inputTtlHourHh");
		this.hashFields.put("qa_ttl_aver_dd", "qaTtlAverDd");
		this.hashFields.put("rate_ttl_aver_ss", "rateTtlAverSs");
		this.hashFields.put("rate_ttl_hour_hh", "rateTtlHourHh");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rate_ttl_hour_dd", "rateTtlHourDd");
		this.hashFields.put("input_ttl_hour_dd", "inputTtlHourDd");
		this.hashFields.put("rate_ttl_hour_mi", "rateTtlHourMi");
		this.hashFields.put("period", "period");
		this.hashFields.put("input_ttl_hour_ss", "inputTtlHourSs");
		this.hashFields.put("qa_ttl_aver_mi", "qaTtlAverMi");
		this.hashFields.put("total_ttl_event", "totalTtlEvent");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("qa_ttl_pic", "qaTtlPic");
		this.hashFields.put("rate_ttl_pic", "rateTtlPic");
		this.hashFields.put("input_ttl_pic", "inputTtlPic");
		this.hashFields.put("qa_ttl_event", "qaTtlEvent");
		this.hashFields.put("total_ttl_pic", "totalTtlPic");
		this.hashFields.put("input_ttl_aver_mi", "inputTtlAverMi");
		this.hashFields.put("ttl_bkg", "ttlBkg");
		this.hashFields.put("total_ttl_aver_dd", "totalTtlAverDd");
		this.hashFields.put("total_ttl_hour_ss", "totalTtlHourSs");
		this.hashFields.put("total_ttl_aver_ss", "totalTtlAverSs");
		this.hashFields.put("rgn", "rgn");
		this.hashFields.put("input_ttl_aver_hh", "inputTtlAverHh");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("rate_ttl_event", "rateTtlEvent");
		this.hashFields.put("input_ttl_aver_dd", "inputTtlAverDd");
		this.hashFields.put("input_ttl_aver_ss", "inputTtlAverSs");
		this.hashFields.put("rate_ttl_aver_mi", "rateTtlAverMi");
		this.hashFields.put("qa_ttl_aver_ss", "qaTtlAverSs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qa_ttl_hour_dd", "qaTtlHourDd");
		this.hashFields.put("qa_ttl_hour_mi", "qaTtlHourMi");
		this.hashFields.put("qa_ttl_hour_hh", "qaTtlHourHh");
		this.hashFields.put("input_ttl_event", "inputTtlEvent");
		this.hashFields.put("rate_ttl_aver_hh", "rateTtlAverHh");
		this.hashFields.put("input_ttl_hour_mi", "inputTtlHourMi");
		this.hashFields.put("rate_ttl_hour_ss", "rateTtlHourSs");
		this.hashFields.put("divide", "divide");
		this.hashFields.put("total_ttl_hour_mi", "totalTtlHourMi");
		this.hashFields.put("total_ttl_hour_dd", "totalTtlHourDd");
		this.hashFields.put("total_ttl_aver_mi", "totalTtlAverMi");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qaTtlAverHh
	 */
	public String getQaTtlAverHh() {
		return this.qaTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return totalTtlHourHh
	 */
	public String getTotalTtlHourHh() {
		return this.totalTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @return totalTtlAverHh
	 */
	public String getTotalTtlAverHh() {
		return this.totalTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @return qaTtlHourSs
	 */
	public String getQaTtlHourSs() {
		return this.qaTtlHourSs;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return rateTtlAverDd
	 */
	public String getRateTtlAverDd() {
		return this.rateTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @return inputTtlHourHh
	 */
	public String getInputTtlHourHh() {
		return this.inputTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @return qaTtlAverDd
	 */
	public String getQaTtlAverDd() {
		return this.qaTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @return rateTtlAverSs
	 */
	public String getRateTtlAverSs() {
		return this.rateTtlAverSs;
	}
	
	/**
	 * Column Info
	 * @return rateTtlHourHh
	 */
	public String getRateTtlHourHh() {
		return this.rateTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rateTtlHourDd
	 */
	public String getRateTtlHourDd() {
		return this.rateTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @return inputTtlHourDd
	 */
	public String getInputTtlHourDd() {
		return this.inputTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @return rateTtlHourMi
	 */
	public String getRateTtlHourMi() {
		return this.rateTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return inputTtlHourSs
	 */
	public String getInputTtlHourSs() {
		return this.inputTtlHourSs;
	}
	
	/**
	 * Column Info
	 * @return qaTtlAverMi
	 */
	public String getQaTtlAverMi() {
		return this.qaTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @return totalTtlEvent
	 */
	public String getTotalTtlEvent() {
		return this.totalTtlEvent;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return qaTtlPic
	 */
	public String getQaTtlPic() {
		return this.qaTtlPic;
	}
	
	/**
	 * Column Info
	 * @return rateTtlPic
	 */
	public String getRateTtlPic() {
		return this.rateTtlPic;
	}
	
	/**
	 * Column Info
	 * @return inputTtlPic
	 */
	public String getInputTtlPic() {
		return this.inputTtlPic;
	}
	
	/**
	 * Column Info
	 * @return qaTtlEvent
	 */
	public String getQaTtlEvent() {
		return this.qaTtlEvent;
	}
	
	/**
	 * Column Info
	 * @return totalTtlPic
	 */
	public String getTotalTtlPic() {
		return this.totalTtlPic;
	}
	
	/**
	 * Column Info
	 * @return inputTtlAverMi
	 */
	public String getInputTtlAverMi() {
		return this.inputTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @return ttlBkg
	 */
	public String getTtlBkg() {
		return this.ttlBkg;
	}
	
	/**
	 * Column Info
	 * @return totalTtlAverDd
	 */
	public String getTotalTtlAverDd() {
		return this.totalTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @return totalTtlHourSs
	 */
	public String getTotalTtlHourSs() {
		return this.totalTtlHourSs;
	}
	
	/**
	 * Column Info
	 * @return totalTtlAverSs
	 */
	public String getTotalTtlAverSs() {
		return this.totalTtlAverSs;
	}
	
	/**
	 * Column Info
	 * @return rgn
	 */
	public String getRgn() {
		return this.rgn;
	}
	
	/**
	 * Column Info
	 * @return inputTtlAverHh
	 */
	public String getInputTtlAverHh() {
		return this.inputTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return rateTtlEvent
	 */
	public String getRateTtlEvent() {
		return this.rateTtlEvent;
	}
	
	/**
	 * Column Info
	 * @return inputTtlAverDd
	 */
	public String getInputTtlAverDd() {
		return this.inputTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @return inputTtlAverSs
	 */
	public String getInputTtlAverSs() {
		return this.inputTtlAverSs;
	}
	
	/**
	 * Column Info
	 * @return rateTtlAverMi
	 */
	public String getRateTtlAverMi() {
		return this.rateTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @return qaTtlAverSs
	 */
	public String getQaTtlAverSs() {
		return this.qaTtlAverSs;
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
	 * @return qaTtlHourDd
	 */
	public String getQaTtlHourDd() {
		return this.qaTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @return qaTtlHourMi
	 */
	public String getQaTtlHourMi() {
		return this.qaTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @return qaTtlHourHh
	 */
	public String getQaTtlHourHh() {
		return this.qaTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @return inputTtlEvent
	 */
	public String getInputTtlEvent() {
		return this.inputTtlEvent;
	}
	
	/**
	 * Column Info
	 * @return rateTtlAverHh
	 */
	public String getRateTtlAverHh() {
		return this.rateTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @return inputTtlHourMi
	 */
	public String getInputTtlHourMi() {
		return this.inputTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @return rateTtlHourSs
	 */
	public String getRateTtlHourSs() {
		return this.rateTtlHourSs;
	}
	
	/**
	 * Column Info
	 * @return divide
	 */
	public String getDivide() {
		return this.divide;
	}
	
	/**
	 * Column Info
	 * @return totalTtlHourMi
	 */
	public String getTotalTtlHourMi() {
		return this.totalTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @return totalTtlHourDd
	 */
	public String getTotalTtlHourDd() {
		return this.totalTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @return totalTtlAverMi
	 */
	public String getTotalTtlAverMi() {
		return this.totalTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
	}
	

	/**
	 * Column Info
	 * @param qaTtlAverHh
	 */
	public void setQaTtlAverHh(String qaTtlAverHh) {
		this.qaTtlAverHh = qaTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param totalTtlHourHh
	 */
	public void setTotalTtlHourHh(String totalTtlHourHh) {
		this.totalTtlHourHh = totalTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @param totalTtlAverHh
	 */
	public void setTotalTtlAverHh(String totalTtlAverHh) {
		this.totalTtlAverHh = totalTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @param qaTtlHourSs
	 */
	public void setQaTtlHourSs(String qaTtlHourSs) {
		this.qaTtlHourSs = qaTtlHourSs;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param rateTtlAverDd
	 */
	public void setRateTtlAverDd(String rateTtlAverDd) {
		this.rateTtlAverDd = rateTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @param inputTtlHourHh
	 */
	public void setInputTtlHourHh(String inputTtlHourHh) {
		this.inputTtlHourHh = inputTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @param qaTtlAverDd
	 */
	public void setQaTtlAverDd(String qaTtlAverDd) {
		this.qaTtlAverDd = qaTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @param rateTtlAverSs
	 */
	public void setRateTtlAverSs(String rateTtlAverSs) {
		this.rateTtlAverSs = rateTtlAverSs;
	}
	
	/**
	 * Column Info
	 * @param rateTtlHourHh
	 */
	public void setRateTtlHourHh(String rateTtlHourHh) {
		this.rateTtlHourHh = rateTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rateTtlHourDd
	 */
	public void setRateTtlHourDd(String rateTtlHourDd) {
		this.rateTtlHourDd = rateTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @param inputTtlHourDd
	 */
	public void setInputTtlHourDd(String inputTtlHourDd) {
		this.inputTtlHourDd = inputTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @param rateTtlHourMi
	 */
	public void setRateTtlHourMi(String rateTtlHourMi) {
		this.rateTtlHourMi = rateTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param inputTtlHourSs
	 */
	public void setInputTtlHourSs(String inputTtlHourSs) {
		this.inputTtlHourSs = inputTtlHourSs;
	}
	
	/**
	 * Column Info
	 * @param qaTtlAverMi
	 */
	public void setQaTtlAverMi(String qaTtlAverMi) {
		this.qaTtlAverMi = qaTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @param totalTtlEvent
	 */
	public void setTotalTtlEvent(String totalTtlEvent) {
		this.totalTtlEvent = totalTtlEvent;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param qaTtlPic
	 */
	public void setQaTtlPic(String qaTtlPic) {
		this.qaTtlPic = qaTtlPic;
	}
	
	/**
	 * Column Info
	 * @param rateTtlPic
	 */
	public void setRateTtlPic(String rateTtlPic) {
		this.rateTtlPic = rateTtlPic;
	}
	
	/**
	 * Column Info
	 * @param inputTtlPic
	 */
	public void setInputTtlPic(String inputTtlPic) {
		this.inputTtlPic = inputTtlPic;
	}
	
	/**
	 * Column Info
	 * @param qaTtlEvent
	 */
	public void setQaTtlEvent(String qaTtlEvent) {
		this.qaTtlEvent = qaTtlEvent;
	}
	
	/**
	 * Column Info
	 * @param totalTtlPic
	 */
	public void setTotalTtlPic(String totalTtlPic) {
		this.totalTtlPic = totalTtlPic;
	}
	
	/**
	 * Column Info
	 * @param inputTtlAverMi
	 */
	public void setInputTtlAverMi(String inputTtlAverMi) {
		this.inputTtlAverMi = inputTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @param ttlBkg
	 */
	public void setTtlBkg(String ttlBkg) {
		this.ttlBkg = ttlBkg;
	}
	
	/**
	 * Column Info
	 * @param totalTtlAverDd
	 */
	public void setTotalTtlAverDd(String totalTtlAverDd) {
		this.totalTtlAverDd = totalTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @param totalTtlHourSs
	 */
	public void setTotalTtlHourSs(String totalTtlHourSs) {
		this.totalTtlHourSs = totalTtlHourSs;
	}
	
	/**
	 * Column Info
	 * @param totalTtlAverSs
	 */
	public void setTotalTtlAverSs(String totalTtlAverSs) {
		this.totalTtlAverSs = totalTtlAverSs;
	}
	
	/**
	 * Column Info
	 * @param rgn
	 */
	public void setRgn(String rgn) {
		this.rgn = rgn;
	}
	
	/**
	 * Column Info
	 * @param inputTtlAverHh
	 */
	public void setInputTtlAverHh(String inputTtlAverHh) {
		this.inputTtlAverHh = inputTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param rateTtlEvent
	 */
	public void setRateTtlEvent(String rateTtlEvent) {
		this.rateTtlEvent = rateTtlEvent;
	}
	
	/**
	 * Column Info
	 * @param inputTtlAverDd
	 */
	public void setInputTtlAverDd(String inputTtlAverDd) {
		this.inputTtlAverDd = inputTtlAverDd;
	}
	
	/**
	 * Column Info
	 * @param inputTtlAverSs
	 */
	public void setInputTtlAverSs(String inputTtlAverSs) {
		this.inputTtlAverSs = inputTtlAverSs;
	}
	
	/**
	 * Column Info
	 * @param rateTtlAverMi
	 */
	public void setRateTtlAverMi(String rateTtlAverMi) {
		this.rateTtlAverMi = rateTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @param qaTtlAverSs
	 */
	public void setQaTtlAverSs(String qaTtlAverSs) {
		this.qaTtlAverSs = qaTtlAverSs;
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
	 * @param qaTtlHourDd
	 */
	public void setQaTtlHourDd(String qaTtlHourDd) {
		this.qaTtlHourDd = qaTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @param qaTtlHourMi
	 */
	public void setQaTtlHourMi(String qaTtlHourMi) {
		this.qaTtlHourMi = qaTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @param qaTtlHourHh
	 */
	public void setQaTtlHourHh(String qaTtlHourHh) {
		this.qaTtlHourHh = qaTtlHourHh;
	}
	
	/**
	 * Column Info
	 * @param inputTtlEvent
	 */
	public void setInputTtlEvent(String inputTtlEvent) {
		this.inputTtlEvent = inputTtlEvent;
	}
	
	/**
	 * Column Info
	 * @param rateTtlAverHh
	 */
	public void setRateTtlAverHh(String rateTtlAverHh) {
		this.rateTtlAverHh = rateTtlAverHh;
	}
	
	/**
	 * Column Info
	 * @param inputTtlHourMi
	 */
	public void setInputTtlHourMi(String inputTtlHourMi) {
		this.inputTtlHourMi = inputTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @param rateTtlHourSs
	 */
	public void setRateTtlHourSs(String rateTtlHourSs) {
		this.rateTtlHourSs = rateTtlHourSs;
	}
	
	/**
	 * Column Info
	 * @param divide
	 */
	public void setDivide(String divide) {
		this.divide = divide;
	}
	
	/**
	 * Column Info
	 * @param totalTtlHourMi
	 */
	public void setTotalTtlHourMi(String totalTtlHourMi) {
		this.totalTtlHourMi = totalTtlHourMi;
	}
	
	/**
	 * Column Info
	 * @param totalTtlHourDd
	 */
	public void setTotalTtlHourDd(String totalTtlHourDd) {
		this.totalTtlHourDd = totalTtlHourDd;
	}
	
	/**
	 * Column Info
	 * @param totalTtlAverMi
	 */
	public void setTotalTtlAverMi(String totalTtlAverMi) {
		this.totalTtlAverMi = totalTtlAverMi;
	}
	
	/**
	 * Column Info
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
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
		setQaTtlAverHh(JSPUtil.getParameter(request, prefix + "qa_ttl_aver_hh", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setTotalTtlHourHh(JSPUtil.getParameter(request, prefix + "total_ttl_hour_hh", ""));
		setTotalTtlAverHh(JSPUtil.getParameter(request, prefix + "total_ttl_aver_hh", ""));
		setQaTtlHourSs(JSPUtil.getParameter(request, prefix + "qa_ttl_hour_ss", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setRateTtlAverDd(JSPUtil.getParameter(request, prefix + "rate_ttl_aver_dd", ""));
		setInputTtlHourHh(JSPUtil.getParameter(request, prefix + "input_ttl_hour_hh", ""));
		setQaTtlAverDd(JSPUtil.getParameter(request, prefix + "qa_ttl_aver_dd", ""));
		setRateTtlAverSs(JSPUtil.getParameter(request, prefix + "rate_ttl_aver_ss", ""));
		setRateTtlHourHh(JSPUtil.getParameter(request, prefix + "rate_ttl_hour_hh", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRateTtlHourDd(JSPUtil.getParameter(request, prefix + "rate_ttl_hour_dd", ""));
		setInputTtlHourDd(JSPUtil.getParameter(request, prefix + "input_ttl_hour_dd", ""));
		setRateTtlHourMi(JSPUtil.getParameter(request, prefix + "rate_ttl_hour_mi", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setInputTtlHourSs(JSPUtil.getParameter(request, prefix + "input_ttl_hour_ss", ""));
		setQaTtlAverMi(JSPUtil.getParameter(request, prefix + "qa_ttl_aver_mi", ""));
		setTotalTtlEvent(JSPUtil.getParameter(request, prefix + "total_ttl_event", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setQaTtlPic(JSPUtil.getParameter(request, prefix + "qa_ttl_pic", ""));
		setRateTtlPic(JSPUtil.getParameter(request, prefix + "rate_ttl_pic", ""));
		setInputTtlPic(JSPUtil.getParameter(request, prefix + "input_ttl_pic", ""));
		setQaTtlEvent(JSPUtil.getParameter(request, prefix + "qa_ttl_event", ""));
		setTotalTtlPic(JSPUtil.getParameter(request, prefix + "total_ttl_pic", ""));
		setInputTtlAverMi(JSPUtil.getParameter(request, prefix + "input_ttl_aver_mi", ""));
		setTtlBkg(JSPUtil.getParameter(request, prefix + "ttl_bkg", ""));
		setTotalTtlAverDd(JSPUtil.getParameter(request, prefix + "total_ttl_aver_dd", ""));
		setTotalTtlHourSs(JSPUtil.getParameter(request, prefix + "total_ttl_hour_ss", ""));
		setTotalTtlAverSs(JSPUtil.getParameter(request, prefix + "total_ttl_aver_ss", ""));
		setRgn(JSPUtil.getParameter(request, prefix + "rgn", ""));
		setInputTtlAverHh(JSPUtil.getParameter(request, prefix + "input_ttl_aver_hh", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setRateTtlEvent(JSPUtil.getParameter(request, prefix + "rate_ttl_event", ""));
		setInputTtlAverDd(JSPUtil.getParameter(request, prefix + "input_ttl_aver_dd", ""));
		setInputTtlAverSs(JSPUtil.getParameter(request, prefix + "input_ttl_aver_ss", ""));
		setRateTtlAverMi(JSPUtil.getParameter(request, prefix + "rate_ttl_aver_mi", ""));
		setQaTtlAverSs(JSPUtil.getParameter(request, prefix + "qa_ttl_aver_ss", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setQaTtlHourDd(JSPUtil.getParameter(request, prefix + "qa_ttl_hour_dd", ""));
		setQaTtlHourMi(JSPUtil.getParameter(request, prefix + "qa_ttl_hour_mi", ""));
		setQaTtlHourHh(JSPUtil.getParameter(request, prefix + "qa_ttl_hour_hh", ""));
		setInputTtlEvent(JSPUtil.getParameter(request, prefix + "input_ttl_event", ""));
		setRateTtlAverHh(JSPUtil.getParameter(request, prefix + "rate_ttl_aver_hh", ""));
		setInputTtlHourMi(JSPUtil.getParameter(request, prefix + "input_ttl_hour_mi", ""));
		setRateTtlHourSs(JSPUtil.getParameter(request, prefix + "rate_ttl_hour_ss", ""));
		setDivide(JSPUtil.getParameter(request, prefix + "divide", ""));
		setTotalTtlHourMi(JSPUtil.getParameter(request, prefix + "total_ttl_hour_mi", ""));
		setTotalTtlHourDd(JSPUtil.getParameter(request, prefix + "total_ttl_hour_dd", ""));
		setTotalTtlAverMi(JSPUtil.getParameter(request, prefix + "total_ttl_aver_mi", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, prefix + "dpcs_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocPerformanceSummaryVO[]
	 */
	public DocPerformanceSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocPerformanceSummaryVO[]
	 */
	public DocPerformanceSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocPerformanceSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qaTtlAverHh = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_aver_hh", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] totalTtlHourHh = (JSPUtil.getParameter(request, prefix	+ "total_ttl_hour_hh", length));
			String[] totalTtlAverHh = (JSPUtil.getParameter(request, prefix	+ "total_ttl_aver_hh", length));
			String[] qaTtlHourSs = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_hour_ss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rateTtlAverDd = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_aver_dd", length));
			String[] inputTtlHourHh = (JSPUtil.getParameter(request, prefix	+ "input_ttl_hour_hh", length));
			String[] qaTtlAverDd = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_aver_dd", length));
			String[] rateTtlAverSs = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_aver_ss", length));
			String[] rateTtlHourHh = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_hour_hh", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rateTtlHourDd = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_hour_dd", length));
			String[] inputTtlHourDd = (JSPUtil.getParameter(request, prefix	+ "input_ttl_hour_dd", length));
			String[] rateTtlHourMi = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_hour_mi", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] inputTtlHourSs = (JSPUtil.getParameter(request, prefix	+ "input_ttl_hour_ss", length));
			String[] qaTtlAverMi = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_aver_mi", length));
			String[] totalTtlEvent = (JSPUtil.getParameter(request, prefix	+ "total_ttl_event", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] qaTtlPic = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_pic", length));
			String[] rateTtlPic = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_pic", length));
			String[] inputTtlPic = (JSPUtil.getParameter(request, prefix	+ "input_ttl_pic", length));
			String[] qaTtlEvent = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_event", length));
			String[] totalTtlPic = (JSPUtil.getParameter(request, prefix	+ "total_ttl_pic", length));
			String[] inputTtlAverMi = (JSPUtil.getParameter(request, prefix	+ "input_ttl_aver_mi", length));
			String[] ttlBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg", length));
			String[] totalTtlAverDd = (JSPUtil.getParameter(request, prefix	+ "total_ttl_aver_dd", length));
			String[] totalTtlHourSs = (JSPUtil.getParameter(request, prefix	+ "total_ttl_hour_ss", length));
			String[] totalTtlAverSs = (JSPUtil.getParameter(request, prefix	+ "total_ttl_aver_ss", length));
			String[] rgn = (JSPUtil.getParameter(request, prefix	+ "rgn", length));
			String[] inputTtlAverHh = (JSPUtil.getParameter(request, prefix	+ "input_ttl_aver_hh", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] rateTtlEvent = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_event", length));
			String[] inputTtlAverDd = (JSPUtil.getParameter(request, prefix	+ "input_ttl_aver_dd", length));
			String[] inputTtlAverSs = (JSPUtil.getParameter(request, prefix	+ "input_ttl_aver_ss", length));
			String[] rateTtlAverMi = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_aver_mi", length));
			String[] qaTtlAverSs = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_aver_ss", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qaTtlHourDd = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_hour_dd", length));
			String[] qaTtlHourMi = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_hour_mi", length));
			String[] qaTtlHourHh = (JSPUtil.getParameter(request, prefix	+ "qa_ttl_hour_hh", length));
			String[] inputTtlEvent = (JSPUtil.getParameter(request, prefix	+ "input_ttl_event", length));
			String[] rateTtlAverHh = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_aver_hh", length));
			String[] inputTtlHourMi = (JSPUtil.getParameter(request, prefix	+ "input_ttl_hour_mi", length));
			String[] rateTtlHourSs = (JSPUtil.getParameter(request, prefix	+ "rate_ttl_hour_ss", length));
			String[] divide = (JSPUtil.getParameter(request, prefix	+ "divide", length));
			String[] totalTtlHourMi = (JSPUtil.getParameter(request, prefix	+ "total_ttl_hour_mi", length));
			String[] totalTtlHourDd = (JSPUtil.getParameter(request, prefix	+ "total_ttl_hour_dd", length));
			String[] totalTtlAverMi = (JSPUtil.getParameter(request, prefix	+ "total_ttl_aver_mi", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocPerformanceSummaryVO();
				if (qaTtlAverHh[i] != null)
					model.setQaTtlAverHh(qaTtlAverHh[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (totalTtlHourHh[i] != null)
					model.setTotalTtlHourHh(totalTtlHourHh[i]);
				if (totalTtlAverHh[i] != null)
					model.setTotalTtlAverHh(totalTtlAverHh[i]);
				if (qaTtlHourSs[i] != null)
					model.setQaTtlHourSs(qaTtlHourSs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rateTtlAverDd[i] != null)
					model.setRateTtlAverDd(rateTtlAverDd[i]);
				if (inputTtlHourHh[i] != null)
					model.setInputTtlHourHh(inputTtlHourHh[i]);
				if (qaTtlAverDd[i] != null)
					model.setQaTtlAverDd(qaTtlAverDd[i]);
				if (rateTtlAverSs[i] != null)
					model.setRateTtlAverSs(rateTtlAverSs[i]);
				if (rateTtlHourHh[i] != null)
					model.setRateTtlHourHh(rateTtlHourHh[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rateTtlHourDd[i] != null)
					model.setRateTtlHourDd(rateTtlHourDd[i]);
				if (inputTtlHourDd[i] != null)
					model.setInputTtlHourDd(inputTtlHourDd[i]);
				if (rateTtlHourMi[i] != null)
					model.setRateTtlHourMi(rateTtlHourMi[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (inputTtlHourSs[i] != null)
					model.setInputTtlHourSs(inputTtlHourSs[i]);
				if (qaTtlAverMi[i] != null)
					model.setQaTtlAverMi(qaTtlAverMi[i]);
				if (totalTtlEvent[i] != null)
					model.setTotalTtlEvent(totalTtlEvent[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (qaTtlPic[i] != null)
					model.setQaTtlPic(qaTtlPic[i]);
				if (rateTtlPic[i] != null)
					model.setRateTtlPic(rateTtlPic[i]);
				if (inputTtlPic[i] != null)
					model.setInputTtlPic(inputTtlPic[i]);
				if (qaTtlEvent[i] != null)
					model.setQaTtlEvent(qaTtlEvent[i]);
				if (totalTtlPic[i] != null)
					model.setTotalTtlPic(totalTtlPic[i]);
				if (inputTtlAverMi[i] != null)
					model.setInputTtlAverMi(inputTtlAverMi[i]);
				if (ttlBkg[i] != null)
					model.setTtlBkg(ttlBkg[i]);
				if (totalTtlAverDd[i] != null)
					model.setTotalTtlAverDd(totalTtlAverDd[i]);
				if (totalTtlHourSs[i] != null)
					model.setTotalTtlHourSs(totalTtlHourSs[i]);
				if (totalTtlAverSs[i] != null)
					model.setTotalTtlAverSs(totalTtlAverSs[i]);
				if (rgn[i] != null)
					model.setRgn(rgn[i]);
				if (inputTtlAverHh[i] != null)
					model.setInputTtlAverHh(inputTtlAverHh[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (rateTtlEvent[i] != null)
					model.setRateTtlEvent(rateTtlEvent[i]);
				if (inputTtlAverDd[i] != null)
					model.setInputTtlAverDd(inputTtlAverDd[i]);
				if (inputTtlAverSs[i] != null)
					model.setInputTtlAverSs(inputTtlAverSs[i]);
				if (rateTtlAverMi[i] != null)
					model.setRateTtlAverMi(rateTtlAverMi[i]);
				if (qaTtlAverSs[i] != null)
					model.setQaTtlAverSs(qaTtlAverSs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qaTtlHourDd[i] != null)
					model.setQaTtlHourDd(qaTtlHourDd[i]);
				if (qaTtlHourMi[i] != null)
					model.setQaTtlHourMi(qaTtlHourMi[i]);
				if (qaTtlHourHh[i] != null)
					model.setQaTtlHourHh(qaTtlHourHh[i]);
				if (inputTtlEvent[i] != null)
					model.setInputTtlEvent(inputTtlEvent[i]);
				if (rateTtlAverHh[i] != null)
					model.setRateTtlAverHh(rateTtlAverHh[i]);
				if (inputTtlHourMi[i] != null)
					model.setInputTtlHourMi(inputTtlHourMi[i]);
				if (rateTtlHourSs[i] != null)
					model.setRateTtlHourSs(rateTtlHourSs[i]);
				if (divide[i] != null)
					model.setDivide(divide[i]);
				if (totalTtlHourMi[i] != null)
					model.setTotalTtlHourMi(totalTtlHourMi[i]);
				if (totalTtlHourDd[i] != null)
					model.setTotalTtlHourDd(totalTtlHourDd[i]);
				if (totalTtlAverMi[i] != null)
					model.setTotalTtlAverMi(totalTtlAverMi[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocPerformanceSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocPerformanceSummaryVO[]
	 */
	public DocPerformanceSummaryVO[] getDocPerformanceSummaryVOs(){
		DocPerformanceSummaryVO[] vos = (DocPerformanceSummaryVO[])models.toArray(new DocPerformanceSummaryVO[models.size()]);
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
		this.qaTtlAverHh = this.qaTtlAverHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlHourHh = this.totalTtlHourHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlAverHh = this.totalTtlAverHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlHourSs = this.qaTtlHourSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlAverDd = this.rateTtlAverDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlHourHh = this.inputTtlHourHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlAverDd = this.qaTtlAverDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlAverSs = this.rateTtlAverSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlHourHh = this.rateTtlHourHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlHourDd = this.rateTtlHourDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlHourDd = this.inputTtlHourDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlHourMi = this.rateTtlHourMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlHourSs = this.inputTtlHourSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlAverMi = this.qaTtlAverMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlEvent = this.totalTtlEvent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlPic = this.qaTtlPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlPic = this.rateTtlPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlPic = this.inputTtlPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlEvent = this.qaTtlEvent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlPic = this.totalTtlPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlAverMi = this.inputTtlAverMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkg = this.ttlBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlAverDd = this.totalTtlAverDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlHourSs = this.totalTtlHourSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlAverSs = this.totalTtlAverSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgn = this.rgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlAverHh = this.inputTtlAverHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlEvent = this.rateTtlEvent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlAverDd = this.inputTtlAverDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlAverSs = this.inputTtlAverSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlAverMi = this.rateTtlAverMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlAverSs = this.qaTtlAverSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlHourDd = this.qaTtlHourDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlHourMi = this.qaTtlHourMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaTtlHourHh = this.qaTtlHourHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlEvent = this.inputTtlEvent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlAverHh = this.rateTtlAverHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTtlHourMi = this.inputTtlHourMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateTtlHourSs = this.rateTtlHourSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divide = this.divide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlHourMi = this.totalTtlHourMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlHourDd = this.totalTtlHourDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTtlAverMi = this.totalTtlAverMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
