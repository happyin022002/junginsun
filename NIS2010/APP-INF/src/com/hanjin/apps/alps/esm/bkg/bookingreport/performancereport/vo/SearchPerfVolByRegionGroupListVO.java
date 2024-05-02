/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchPerfVolByRegionGroupListVO.java
*@FileTitle : SearchPerfVolByRegionGroupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.14  
* 1.0 Creation
* 2012.02.13 정선용 [CHM-201216202] DPCS B/L Perf. by Volume-I (by Region-User Group) 기능 보완 요청
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPerfVolByRegionGroupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerfVolByRegionGroupListVO> models = new ArrayList<SearchPerfVolByRegionGroupListVO>();
	
	/* Column Info */
	private String totAvgElapsedSs = null;
	/* Column Info */
	private String totOriMailCnt = null;
	/* Column Info */
	private String totAmdRdCnt = null;
	/* Column Info */
	private String totAmdAdCnt = null;
	/* Column Info */
	private String totTimeHh = null;
	/* Column Info */
	private String avgPointRa = null;
	/* Column Info */
	private String totElapsed = null;
	/* Column Info */
	private String totAvgElapsedHh = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totAvgElapsed = null;
	/* Column Info */
	private String totHblInRdCnt = null;
	/* Column Info */
	private String totTimeMm = null;
	/* Column Info */
	private String avgTimeQa = null;
	/* Column Info */
	private String totInputElapsed = null;
	/* Column Info */
	private String avgTimeMm = null;
	/* Column Info */
	private String totHblInAdCnt = null;
	/* Column Info */
	private String sumOriMSi = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String totAddiCntIdCnt = null;
	/* Column Info */
	private String avgPointQa = null;
	/* Column Info */
	private String totElapsedSs = null;
	/* Column Info */
	private String totalRPoint = null;
	/* Column Info */
	private String totHblInIdCnt = null;
	/* Column Info */
	private String avgTimeHh = null;
	/* Column Info */
	private String totAddiCntRdCnt = null;
	/* Column Info */
	private String totRateElapsed = null;
	/* Column Info */
	private String totOriFaxCnt = null;
	/* Column Info */
	private String avgTimeSs = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String totAesRdCnt = null;
	/* Column Info */
	private String totAesAdCnt = null;
	/* Column Info */
	private String totBlCfmCntAdCnt = null;
	/* Column Info */
	private String sumOriESi = null;
	/* Column Info */
	private String totOriEdiCnt = null;
	/* Column Info */
	private String totalAPoint = null;
	/* Column Info */
	private String avgPointId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totElapsedHh = null;
	/* Column Info */
	private String totQaElapsed = null;
	/* Column Info */
	private String totBkgCnt = null;
	/* Column Info */
	private String totBlCfmCntRdCnt = null;
	/* Column Info */
	private String sumOriFSi = null;
	/* Column Info */
	private String totTimeSs = null;
	/* Column Info */
	private String totHblCnt = null;
	/* Column Info */
	private String totAmdIdCnt = null;
	/* Column Info */
	private String totHisCnt = null;
	/* Column Info */
	private String regionD = null;
	/* Column Info */
	private String totBlCfmCntIdCnt = null;
	/* Column Info */
	private String sumSi = null;
	/* Column Info */
	private String groupD = null;
	/* Column Info */
	private String totAesIdCnt = null;
	/* Column Info */
	private String totOriSenCnt = null;
	/* Column Info */
	private String sumBkg = null;
	/* Column Info */
	private String avgTimeIn = null;
	/* Column Info */
	private String totStaff = null;
	/* Column Info */
	private String avgTimeRa = null;
	/* Column Info */
	private String totalIPoint = null;
	/* Column Info */
	private String sumStaff = null;
	/* Column Info */
	private String totAvgElapsedMm = null;
	/* Column Info */
	private String totSiCnt = null;
	/* Column Info */
	private String totElapsedMm = null;
	/* Column Info */
	private String totAddiCntAdCnt = null;
	/* Column Info */
	private String totAvgPoint = null;
	/* Column Info */
	private String totElapsedDd = null;
	/* Column Info */
	private String totavgElapsedDd = null;
	/* Column Info */
	private String totTimeDd = null;
	/* Column Info */
	private String avgTimeDd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPerfVolByRegionGroupListVO() {}

	public SearchPerfVolByRegionGroupListVO(String ibflag, String pagerows, String region, String totAesRdCnt, String totOriMailCnt, String totAesAdCnt, String totBlCfmCntAdCnt, String sumOriESi, String avgPointRa, String totOriEdiCnt, String totAmdAdCnt, String totalAPoint, String totHblInRdCnt, String avgPointId, String avgTimeQa, String totQaElapsed, String totBkgCnt, String totBlCfmCntRdCnt, String sumOriFSi, String totInputElapsed, String totAmdRdCnt, String totHblCnt, String sumOriMSi, String regionD, String totHblInAdCnt, String srStsCd, String totBlCfmCntIdCnt, String sumSi, String groupD, String totAesIdCnt, String sumBkg, String avgTimeIn, String avgPointQa, String totStaff, String totalRPoint, String totHblInIdCnt, String avgTimeRa, String totAmdIdCnt, String totalIPoint, String sumStaff, String totSiCnt, String totRateElapsed, String totOriFaxCnt, String totOriSenCnt, String totHisCnt, String totAddiCntRdCnt, String totAddiCntAdCnt, String totAddiCntIdCnt, String totElapsed, String totElapsedHh, String totElapsedMm, String totElapsedSs, String totTimeHh, String totTimeMm, String totTimeSs, String avgTimeHh, String avgTimeMm, String avgTimeSs, String totAvgElapsed, String totAvgElapsedHh, String totAvgElapsedMm, String totAvgElapsedSs, String totAvgPoint, String totElapsedDd, String totavgElapsedDd, String totTimeDd, String AvgTimeDd) {
		this.totAvgElapsedSs = totAvgElapsedSs;
		this.totOriMailCnt = totOriMailCnt;
		this.totAmdRdCnt = totAmdRdCnt;
		this.totAmdAdCnt = totAmdAdCnt;
		this.totTimeHh = totTimeHh;
		this.avgPointRa = avgPointRa;
		this.totElapsed = totElapsed;
		this.totAvgElapsedHh = totAvgElapsedHh;
		this.pagerows = pagerows;
		this.totAvgElapsed = totAvgElapsed;
		this.totHblInRdCnt = totHblInRdCnt;
		this.totTimeMm = totTimeMm;
		this.avgTimeQa = avgTimeQa;
		this.totInputElapsed = totInputElapsed;
		this.avgTimeMm = avgTimeMm;
		this.totHblInAdCnt = totHblInAdCnt;
		this.sumOriMSi = sumOriMSi;
		this.srStsCd = srStsCd;
		this.totAddiCntIdCnt = totAddiCntIdCnt;
		this.avgPointQa = avgPointQa;
		this.totElapsedSs = totElapsedSs;
		this.totalRPoint = totalRPoint;
		this.totHblInIdCnt = totHblInIdCnt;
		this.avgTimeHh = avgTimeHh;
		this.totAddiCntRdCnt = totAddiCntRdCnt;
		this.totRateElapsed = totRateElapsed;
		this.totOriFaxCnt = totOriFaxCnt;
		this.avgTimeSs = avgTimeSs;
		this.region = region;
		this.totAesRdCnt = totAesRdCnt;
		this.totAesAdCnt = totAesAdCnt;
		this.totBlCfmCntAdCnt = totBlCfmCntAdCnt;
		this.sumOriESi = sumOriESi;
		this.totOriEdiCnt = totOriEdiCnt;
		this.totalAPoint = totalAPoint;
		this.avgPointId = avgPointId;
		this.ibflag = ibflag;
		this.totElapsedHh = totElapsedHh;
		this.totQaElapsed = totQaElapsed;
		this.totBkgCnt = totBkgCnt;
		this.totBlCfmCntRdCnt = totBlCfmCntRdCnt;
		this.sumOriFSi = sumOriFSi;
		this.totTimeSs = totTimeSs;
		this.totHblCnt = totHblCnt;
		this.totAmdIdCnt = totAmdIdCnt;
		this.totHisCnt = totHisCnt;
		this.regionD = regionD;
		this.totBlCfmCntIdCnt = totBlCfmCntIdCnt;
		this.sumSi = sumSi;
		this.groupD = groupD;
		this.totAesIdCnt = totAesIdCnt;
		this.totOriSenCnt = totOriSenCnt;
		this.sumBkg = sumBkg;
		this.avgTimeIn = avgTimeIn;
		this.totStaff = totStaff;
		this.avgTimeRa = avgTimeRa;
		this.totalIPoint = totalIPoint;
		this.sumStaff = sumStaff;
		this.totAvgElapsedMm = totAvgElapsedMm;
		this.totSiCnt = totSiCnt;
		this.totElapsedMm = totElapsedMm;
		this.totAddiCntAdCnt = totAddiCntAdCnt;
		this.totAvgPoint = totAvgPoint;
		this.totavgElapsedDd = totElapsedDd;
		this.totavgElapsedDd = totavgElapsedDd;
		this.totTimeDd = totTimeDd;
		this.avgTimeDd = avgTimeDd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_avg_elapsed_ss", getTotAvgElapsedSs());
		this.hashColumns.put("tot_ori_mail_cnt", getTotOriMailCnt());
		this.hashColumns.put("tot_amd_rd_cnt", getTotAmdRdCnt());
		this.hashColumns.put("tot_amd_ad_cnt", getTotAmdAdCnt());
		this.hashColumns.put("tot_time_hh", getTotTimeHh());
		this.hashColumns.put("avg_point_ra", getAvgPointRa());
		this.hashColumns.put("tot_elapsed", getTotElapsed());
		this.hashColumns.put("tot_avg_elapsed_hh", getTotAvgElapsedHh());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot_avg_elapsed", getTotAvgElapsed());
		this.hashColumns.put("tot_hbl_in_rd_cnt", getTotHblInRdCnt());
		this.hashColumns.put("tot_time_mm", getTotTimeMm());
		this.hashColumns.put("avg_time_qa", getAvgTimeQa());
		this.hashColumns.put("tot_input_elapsed", getTotInputElapsed());
		this.hashColumns.put("avg_time_mm", getAvgTimeMm());
		this.hashColumns.put("tot_hbl_in_ad_cnt", getTotHblInAdCnt());
		this.hashColumns.put("sum_ori_m_si", getSumOriMSi());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("tot_addi_cnt_id_cnt", getTotAddiCntIdCnt());
		this.hashColumns.put("avg_point_qa", getAvgPointQa());
		this.hashColumns.put("tot_elapsed_ss", getTotElapsedSs());
		this.hashColumns.put("total_r_point", getTotalRPoint());
		this.hashColumns.put("tot_hbl_in_id_cnt", getTotHblInIdCnt());
		this.hashColumns.put("avg_time_hh", getAvgTimeHh());
		this.hashColumns.put("tot_addi_cnt_rd_cnt", getTotAddiCntRdCnt());
		this.hashColumns.put("tot_rate_elapsed", getTotRateElapsed());
		this.hashColumns.put("tot_ori_fax_cnt", getTotOriFaxCnt());
		this.hashColumns.put("avg_time_ss", getAvgTimeSs());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("tot_aes_rd_cnt", getTotAesRdCnt());
		this.hashColumns.put("tot_aes_ad_cnt", getTotAesAdCnt());
		this.hashColumns.put("tot_bl_cfm_cnt_ad_cnt", getTotBlCfmCntAdCnt());
		this.hashColumns.put("sum_ori_e_si", getSumOriESi());
		this.hashColumns.put("tot_ori_edi_cnt", getTotOriEdiCnt());
		this.hashColumns.put("total_a_point", getTotalAPoint());
		this.hashColumns.put("avg_point_id", getAvgPointId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_elapsed_hh", getTotElapsedHh());
		this.hashColumns.put("tot_qa_elapsed", getTotQaElapsed());
		this.hashColumns.put("tot_bkg_cnt", getTotBkgCnt());
		this.hashColumns.put("tot_bl_cfm_cnt_rd_cnt", getTotBlCfmCntRdCnt());
		this.hashColumns.put("sum_ori_f_si", getSumOriFSi());
		this.hashColumns.put("tot_time_ss", getTotTimeSs());
		this.hashColumns.put("tot_hbl_cnt", getTotHblCnt());
		this.hashColumns.put("tot_amd_id_cnt", getTotAmdIdCnt());
		this.hashColumns.put("tot_his_cnt", getTotHisCnt());
		this.hashColumns.put("region_d", getRegionD());
		this.hashColumns.put("tot_bl_cfm_cnt_id_cnt", getTotBlCfmCntIdCnt());
		this.hashColumns.put("sum_si", getSumSi());
		this.hashColumns.put("group_d", getGroupD());
		this.hashColumns.put("tot_aes_id_cnt", getTotAesIdCnt());
		this.hashColumns.put("tot_ori_sen_cnt", getTotOriSenCnt());
		this.hashColumns.put("sum_bkg", getSumBkg());
		this.hashColumns.put("avg_time_in", getAvgTimeIn());
		this.hashColumns.put("tot_staff", getTotStaff());
		this.hashColumns.put("avg_time_ra", getAvgTimeRa());
		this.hashColumns.put("total_i_point", getTotalIPoint());
		this.hashColumns.put("sum_staff", getSumStaff());
		this.hashColumns.put("tot_avg_elapsed_mm", getTotAvgElapsedMm());
		this.hashColumns.put("tot_si_cnt", getTotSiCnt());
		this.hashColumns.put("tot_elapsed_mm", getTotElapsedMm());
		this.hashColumns.put("tot_addi_cnt_ad_cnt", getTotAddiCntAdCnt());
		this.hashColumns.put("tot_avg_point", getTotAvgPoint());
		this.hashColumns.put("tot_elapsed_dd", getTotElapsedDd());
		this.hashColumns.put("tot_avg_elapsed_dd", getTotavgElapsedDd());
		this.hashColumns.put("tot_time_dd", getTotTimeDd());
		this.hashColumns.put("avg_time_dd", getAvgTimeDd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_avg_elapsed_ss", "totAvgElapsedSs");
		this.hashFields.put("tot_ori_mail_cnt", "totOriMailCnt");
		this.hashFields.put("tot_amd_rd_cnt", "totAmdRdCnt");
		this.hashFields.put("tot_amd_ad_cnt", "totAmdAdCnt");
		this.hashFields.put("tot_time_hh", "totTimeHh");
		this.hashFields.put("avg_point_ra", "avgPointRa");
		this.hashFields.put("tot_elapsed", "totElapsed");
		this.hashFields.put("tot_avg_elapsed_hh", "totAvgElapsedHh");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot_avg_elapsed", "totAvgElapsed");
		this.hashFields.put("tot_hbl_in_rd_cnt", "totHblInRdCnt");
		this.hashFields.put("tot_time_mm", "totTimeMm");
		this.hashFields.put("avg_time_qa", "avgTimeQa");
		this.hashFields.put("tot_input_elapsed", "totInputElapsed");
		this.hashFields.put("avg_time_mm", "avgTimeMm");
		this.hashFields.put("tot_hbl_in_ad_cnt", "totHblInAdCnt");
		this.hashFields.put("sum_ori_m_si", "sumOriMSi");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("tot_addi_cnt_id_cnt", "totAddiCntIdCnt");
		this.hashFields.put("avg_point_qa", "avgPointQa");
		this.hashFields.put("tot_elapsed_ss", "totElapsedSs");
		this.hashFields.put("total_r_point", "totalRPoint");
		this.hashFields.put("tot_hbl_in_id_cnt", "totHblInIdCnt");
		this.hashFields.put("avg_time_hh", "avgTimeHh");
		this.hashFields.put("tot_addi_cnt_rd_cnt", "totAddiCntRdCnt");
		this.hashFields.put("tot_rate_elapsed", "totRateElapsed");
		this.hashFields.put("tot_ori_fax_cnt", "totOriFaxCnt");
		this.hashFields.put("avg_time_ss", "avgTimeSs");
		this.hashFields.put("region", "region");
		this.hashFields.put("tot_aes_rd_cnt", "totAesRdCnt");
		this.hashFields.put("tot_aes_ad_cnt", "totAesAdCnt");
		this.hashFields.put("tot_bl_cfm_cnt_ad_cnt", "totBlCfmCntAdCnt");
		this.hashFields.put("sum_ori_e_si", "sumOriESi");
		this.hashFields.put("tot_ori_edi_cnt", "totOriEdiCnt");
		this.hashFields.put("total_a_point", "totalAPoint");
		this.hashFields.put("avg_point_id", "avgPointId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_elapsed_hh", "totElapsedHh");
		this.hashFields.put("tot_qa_elapsed", "totQaElapsed");
		this.hashFields.put("tot_bkg_cnt", "totBkgCnt");
		this.hashFields.put("tot_bl_cfm_cnt_rd_cnt", "totBlCfmCntRdCnt");
		this.hashFields.put("sum_ori_f_si", "sumOriFSi");
		this.hashFields.put("tot_time_ss", "totTimeSs");
		this.hashFields.put("tot_hbl_cnt", "totHblCnt");
		this.hashFields.put("tot_amd_id_cnt", "totAmdIdCnt");
		this.hashFields.put("tot_his_cnt", "totHisCnt");
		this.hashFields.put("region_d", "regionD");
		this.hashFields.put("tot_bl_cfm_cnt_id_cnt", "totBlCfmCntIdCnt");
		this.hashFields.put("sum_si", "sumSi");
		this.hashFields.put("group_d", "groupD");
		this.hashFields.put("tot_aes_id_cnt", "totAesIdCnt");
		this.hashFields.put("tot_ori_sen_cnt", "totOriSenCnt");
		this.hashFields.put("sum_bkg", "sumBkg");
		this.hashFields.put("avg_time_in", "avgTimeIn");
		this.hashFields.put("tot_staff", "totStaff");
		this.hashFields.put("avg_time_ra", "avgTimeRa");
		this.hashFields.put("total_i_point", "totalIPoint");
		this.hashFields.put("sum_staff", "sumStaff");
		this.hashFields.put("tot_avg_elapsed_mm", "totAvgElapsedMm");
		this.hashFields.put("tot_si_cnt", "totSiCnt");
		this.hashFields.put("tot_elapsed_mm", "totElapsedMm");
		this.hashFields.put("tot_addi_cnt_ad_cnt", "totAddiCntAdCnt");
		this.hashFields.put("tot_avg_point", "totAvgPoint");
		this.hashFields.put("tot_elapsed_dd", "totElapsedDd");
		this.hashFields.put("tot_avg_elapsed_dd", "totavgElapsedDd");
		this.hashFields.put("tot_time_dd", "totTimeDd");
		this.hashFields.put("avg_time_dd", "avgTimeDd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totAvgElapsedSs
	 */
	public String getTotAvgElapsedSs() {
		return this.totAvgElapsedSs;
	}
	
	/**
	 * Column Info
	 * @return totOriMailCnt
	 */
	public String getTotOriMailCnt() {
		return this.totOriMailCnt;
	}
	
	/**
	 * Column Info
	 * @return totAmdRdCnt
	 */
	public String getTotAmdRdCnt() {
		return this.totAmdRdCnt;
	}
	
	/**
	 * Column Info
	 * @return totAmdAdCnt
	 */
	public String getTotAmdAdCnt() {
		return this.totAmdAdCnt;
	}
	
	/**
	 * Column Info
	 * @return totTimeHh
	 */
	public String getTotTimeHh() {
		return this.totTimeHh;
	}
	
	/**
	 * Column Info
	 * @return avgPointRa
	 */
	public String getAvgPointRa() {
		return this.avgPointRa;
	}
	
	/**
	 * Column Info
	 * @return totElapsed
	 */
	public String getTotElapsed() {
		return this.totElapsed;
	}
	
	/**
	 * Column Info
	 * @return totAvgElapsedHh
	 */
	public String getTotAvgElapsedHh() {
		return this.totAvgElapsedHh;
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
	 * @return totAvgElapsed
	 */
	public String getTotAvgElapsed() {
		return this.totAvgElapsed;
	}
	
	/**
	 * Column Info
	 * @return totHblInRdCnt
	 */
	public String getTotHblInRdCnt() {
		return this.totHblInRdCnt;
	}
	
	/**
	 * Column Info
	 * @return totTimeMm
	 */
	public String getTotTimeMm() {
		return this.totTimeMm;
	}
	
	/**
	 * Column Info
	 * @return avgTimeQa
	 */
	public String getAvgTimeQa() {
		return this.avgTimeQa;
	}
	
	/**
	 * Column Info
	 * @return totInputElapsed
	 */
	public String getTotInputElapsed() {
		return this.totInputElapsed;
	}
	
	/**
	 * Column Info
	 * @return avgTimeMm
	 */
	public String getAvgTimeMm() {
		return this.avgTimeMm;
	}
	
	/**
	 * Column Info
	 * @return totHblInAdCnt
	 */
	public String getTotHblInAdCnt() {
		return this.totHblInAdCnt;
	}
	
	/**
	 * Column Info
	 * @return sumOriMSi
	 */
	public String getSumOriMSi() {
		return this.sumOriMSi;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return totAddiCntIdCnt
	 */
	public String getTotAddiCntIdCnt() {
		return this.totAddiCntIdCnt;
	}
	
	/**
	 * Column Info
	 * @return avgPointQa
	 */
	public String getAvgPointQa() {
		return this.avgPointQa;
	}
	
	/**
	 * Column Info
	 * @return totElapsedSs
	 */
	public String getTotElapsedSs() {
		return this.totElapsedSs;
	}
	
	/**
	 * Column Info
	 * @return totalRPoint
	 */
	public String getTotalRPoint() {
		return this.totalRPoint;
	}
	
	/**
	 * Column Info
	 * @return totHblInIdCnt
	 */
	public String getTotHblInIdCnt() {
		return this.totHblInIdCnt;
	}
	
	/**
	 * Column Info
	 * @return avgTimeHh
	 */
	public String getAvgTimeHh() {
		return this.avgTimeHh;
	}
	
	/**
	 * Column Info
	 * @return totAddiCntRdCnt
	 */
	public String getTotAddiCntRdCnt() {
		return this.totAddiCntRdCnt;
	}
	
	/**
	 * Column Info
	 * @return totRateElapsed
	 */
	public String getTotRateElapsed() {
		return this.totRateElapsed;
	}
	
	/**
	 * Column Info
	 * @return totOriFaxCnt
	 */
	public String getTotOriFaxCnt() {
		return this.totOriFaxCnt;
	}
	
	/**
	 * Column Info
	 * @return avgTimeSs
	 */
	public String getAvgTimeSs() {
		return this.avgTimeSs;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return totAesRdCnt
	 */
	public String getTotAesRdCnt() {
		return this.totAesRdCnt;
	}
	
	/**
	 * Column Info
	 * @return totAesAdCnt
	 */
	public String getTotAesAdCnt() {
		return this.totAesAdCnt;
	}
	
	/**
	 * Column Info
	 * @return totBlCfmCntAdCnt
	 */
	public String getTotBlCfmCntAdCnt() {
		return this.totBlCfmCntAdCnt;
	}
	
	/**
	 * Column Info
	 * @return sumOriESi
	 */
	public String getSumOriESi() {
		return this.sumOriESi;
	}
	
	/**
	 * Column Info
	 * @return totOriEdiCnt
	 */
	public String getTotOriEdiCnt() {
		return this.totOriEdiCnt;
	}
	
	/**
	 * Column Info
	 * @return totalAPoint
	 */
	public String getTotalAPoint() {
		return this.totalAPoint;
	}
	
	/**
	 * Column Info
	 * @return avgPointId
	 */
	public String getAvgPointId() {
		return this.avgPointId;
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
	 * @return totElapsedHh
	 */
	public String getTotElapsedHh() {
		return this.totElapsedHh;
	}
	
	/**
	 * Column Info
	 * @return totQaElapsed
	 */
	public String getTotQaElapsed() {
		return this.totQaElapsed;
	}
	
	/**
	 * Column Info
	 * @return totBkgCnt
	 */
	public String getTotBkgCnt() {
		return this.totBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return totBlCfmCntRdCnt
	 */
	public String getTotBlCfmCntRdCnt() {
		return this.totBlCfmCntRdCnt;
	}
	
	/**
	 * Column Info
	 * @return sumOriFSi
	 */
	public String getSumOriFSi() {
		return this.sumOriFSi;
	}
	
	/**
	 * Column Info
	 * @return totTimeSs
	 */
	public String getTotTimeSs() {
		return this.totTimeSs;
	}
	
	/**
	 * Column Info
	 * @return totHblCnt
	 */
	public String getTotHblCnt() {
		return this.totHblCnt;
	}
	
	/**
	 * Column Info
	 * @return totAmdIdCnt
	 */
	public String getTotAmdIdCnt() {
		return this.totAmdIdCnt;
	}
	
	/**
	 * Column Info
	 * @return totHisCnt
	 */
	public String getTotHisCnt() {
		return this.totHisCnt;
	}
	
	/**
	 * Column Info
	 * @return regionD
	 */
	public String getRegionD() {
		return this.regionD;
	}
	
	/**
	 * Column Info
	 * @return totBlCfmCntIdCnt
	 */
	public String getTotBlCfmCntIdCnt() {
		return this.totBlCfmCntIdCnt;
	}
	
	/**
	 * Column Info
	 * @return sumSi
	 */
	public String getSumSi() {
		return this.sumSi;
	}
	
	/**
	 * Column Info
	 * @return groupD
	 */
	public String getGroupD() {
		return this.groupD;
	}
	
	/**
	 * Column Info
	 * @return totAesIdCnt
	 */
	public String getTotAesIdCnt() {
		return this.totAesIdCnt;
	}
	
	/**
	 * Column Info
	 * @return totOriSenCnt
	 */
	public String getTotOriSenCnt() {
		return this.totOriSenCnt;
	}
	
	/**
	 * Column Info
	 * @return sumBkg
	 */
	public String getSumBkg() {
		return this.sumBkg;
	}
	
	/**
	 * Column Info
	 * @return avgTimeIn
	 */
	public String getAvgTimeIn() {
		return this.avgTimeIn;
	}
	
	/**
	 * Column Info
	 * @return totStaff
	 */
	public String getTotStaff() {
		return this.totStaff;
	}
	
	/**
	 * Column Info
	 * @return avgTimeRa
	 */
	public String getAvgTimeRa() {
		return this.avgTimeRa;
	}
	
	/**
	 * Column Info
	 * @return totalIPoint
	 */
	public String getTotalIPoint() {
		return this.totalIPoint;
	}
	
	/**
	 * Column Info
	 * @return sumStaff
	 */
	public String getSumStaff() {
		return this.sumStaff;
	}
	
	/**
	 * Column Info
	 * @return totAvgElapsedMm
	 */
	public String getTotAvgElapsedMm() {
		return this.totAvgElapsedMm;
	}
	
	/**
	 * Column Info
	 * @return totSiCnt
	 */
	public String getTotSiCnt() {
		return this.totSiCnt;
	}
	
	/**
	 * Column Info
	 * @return totElapsedMm
	 */
	public String getTotElapsedMm() {
		return this.totElapsedMm;
	}
	
	/**
	 * Column Info
	 * @return totAddiCntAdCnt
	 */
	public String getTotAddiCntAdCnt() {
		return this.totAddiCntAdCnt;
	}
	
	/**
	 * Column Info
	 * @return totAvgPoint
	 */
	public String getTotAvgPoint() {
		return this.totAvgPoint;
	}
	
	/**
	 * Column Info
	 * @return totElapsedDd
	 */
	public String getTotElapsedDd() {
		return this.totElapsedDd;
	}
	
	/**
	 * Column Info
	 * @return totavgElapsedDd
	 */
	public String getTotavgElapsedDd() {
		return this.totavgElapsedDd;
	}
	
	/**
	 * Column Info
	 * @return totTimeDd
	 */
	public String getTotTimeDd() {
		return this.totTimeDd;
	}
	
	/**
	 * Column Info
	 * @return avgTimeDd
	 */
	public String getAvgTimeDd() {
		return this.avgTimeDd;
	}
	

	/**
	 * Column Info
	 * @param totAvgElapsedSs
	 */
	public void setTotAvgElapsedSs(String totAvgElapsedSs) {
		this.totAvgElapsedSs = totAvgElapsedSs;
	}
	
	/**
	 * Column Info
	 * @param totOriMailCnt
	 */
	public void setTotOriMailCnt(String totOriMailCnt) {
		this.totOriMailCnt = totOriMailCnt;
	}
	
	/**
	 * Column Info
	 * @param totAmdRdCnt
	 */
	public void setTotAmdRdCnt(String totAmdRdCnt) {
		this.totAmdRdCnt = totAmdRdCnt;
	}
	
	/**
	 * Column Info
	 * @param totAmdAdCnt
	 */
	public void setTotAmdAdCnt(String totAmdAdCnt) {
		this.totAmdAdCnt = totAmdAdCnt;
	}
	
	/**
	 * Column Info
	 * @param totTimeHh
	 */
	public void setTotTimeHh(String totTimeHh) {
		this.totTimeHh = totTimeHh;
	}
	
	/**
	 * Column Info
	 * @param avgPointRa
	 */
	public void setAvgPointRa(String avgPointRa) {
		this.avgPointRa = avgPointRa;
	}
	
	/**
	 * Column Info
	 * @param totElapsed
	 */
	public void setTotElapsed(String totElapsed) {
		this.totElapsed = totElapsed;
	}
	
	/**
	 * Column Info
	 * @param totAvgElapsedHh
	 */
	public void setTotAvgElapsedHh(String totAvgElapsedHh) {
		this.totAvgElapsedHh = totAvgElapsedHh;
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
	 * @param totAvgElapsed
	 */
	public void setTotAvgElapsed(String totAvgElapsed) {
		this.totAvgElapsed = totAvgElapsed;
	}
	
	/**
	 * Column Info
	 * @param totHblInRdCnt
	 */
	public void setTotHblInRdCnt(String totHblInRdCnt) {
		this.totHblInRdCnt = totHblInRdCnt;
	}
	
	/**
	 * Column Info
	 * @param totTimeMm
	 */
	public void setTotTimeMm(String totTimeMm) {
		this.totTimeMm = totTimeMm;
	}
	
	/**
	 * Column Info
	 * @param avgTimeQa
	 */
	public void setAvgTimeQa(String avgTimeQa) {
		this.avgTimeQa = avgTimeQa;
	}
	
	/**
	 * Column Info
	 * @param totInputElapsed
	 */
	public void setTotInputElapsed(String totInputElapsed) {
		this.totInputElapsed = totInputElapsed;
	}
	
	/**
	 * Column Info
	 * @param avgTimeMm
	 */
	public void setAvgTimeMm(String avgTimeMm) {
		this.avgTimeMm = avgTimeMm;
	}
	
	/**
	 * Column Info
	 * @param totHblInAdCnt
	 */
	public void setTotHblInAdCnt(String totHblInAdCnt) {
		this.totHblInAdCnt = totHblInAdCnt;
	}
	
	/**
	 * Column Info
	 * @param sumOriMSi
	 */
	public void setSumOriMSi(String sumOriMSi) {
		this.sumOriMSi = sumOriMSi;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param totAddiCntIdCnt
	 */
	public void setTotAddiCntIdCnt(String totAddiCntIdCnt) {
		this.totAddiCntIdCnt = totAddiCntIdCnt;
	}
	
	/**
	 * Column Info
	 * @param avgPointQa
	 */
	public void setAvgPointQa(String avgPointQa) {
		this.avgPointQa = avgPointQa;
	}
	
	/**
	 * Column Info
	 * @param totElapsedSs
	 */
	public void setTotElapsedSs(String totElapsedSs) {
		this.totElapsedSs = totElapsedSs;
	}
	
	/**
	 * Column Info
	 * @param totalRPoint
	 */
	public void setTotalRPoint(String totalRPoint) {
		this.totalRPoint = totalRPoint;
	}
	
	/**
	 * Column Info
	 * @param totHblInIdCnt
	 */
	public void setTotHblInIdCnt(String totHblInIdCnt) {
		this.totHblInIdCnt = totHblInIdCnt;
	}
	
	/**
	 * Column Info
	 * @param avgTimeHh
	 */
	public void setAvgTimeHh(String avgTimeHh) {
		this.avgTimeHh = avgTimeHh;
	}
	
	/**
	 * Column Info
	 * @param totAddiCntRdCnt
	 */
	public void setTotAddiCntRdCnt(String totAddiCntRdCnt) {
		this.totAddiCntRdCnt = totAddiCntRdCnt;
	}
	
	/**
	 * Column Info
	 * @param totRateElapsed
	 */
	public void setTotRateElapsed(String totRateElapsed) {
		this.totRateElapsed = totRateElapsed;
	}
	
	/**
	 * Column Info
	 * @param totOriFaxCnt
	 */
	public void setTotOriFaxCnt(String totOriFaxCnt) {
		this.totOriFaxCnt = totOriFaxCnt;
	}
	
	/**
	 * Column Info
	 * @param avgTimeSs
	 */
	public void setAvgTimeSs(String avgTimeSs) {
		this.avgTimeSs = avgTimeSs;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param totAesRdCnt
	 */
	public void setTotAesRdCnt(String totAesRdCnt) {
		this.totAesRdCnt = totAesRdCnt;
	}
	
	/**
	 * Column Info
	 * @param totAesAdCnt
	 */
	public void setTotAesAdCnt(String totAesAdCnt) {
		this.totAesAdCnt = totAesAdCnt;
	}
	
	/**
	 * Column Info
	 * @param totBlCfmCntAdCnt
	 */
	public void setTotBlCfmCntAdCnt(String totBlCfmCntAdCnt) {
		this.totBlCfmCntAdCnt = totBlCfmCntAdCnt;
	}
	
	/**
	 * Column Info
	 * @param sumOriESi
	 */
	public void setSumOriESi(String sumOriESi) {
		this.sumOriESi = sumOriESi;
	}
	
	/**
	 * Column Info
	 * @param totOriEdiCnt
	 */
	public void setTotOriEdiCnt(String totOriEdiCnt) {
		this.totOriEdiCnt = totOriEdiCnt;
	}
	
	/**
	 * Column Info
	 * @param totalAPoint
	 */
	public void setTotalAPoint(String totalAPoint) {
		this.totalAPoint = totalAPoint;
	}
	
	/**
	 * Column Info
	 * @param avgPointId
	 */
	public void setAvgPointId(String avgPointId) {
		this.avgPointId = avgPointId;
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
	 * @param totElapsedHh
	 */
	public void setTotElapsedHh(String totElapsedHh) {
		this.totElapsedHh = totElapsedHh;
	}
	
	/**
	 * Column Info
	 * @param totQaElapsed
	 */
	public void setTotQaElapsed(String totQaElapsed) {
		this.totQaElapsed = totQaElapsed;
	}
	
	/**
	 * Column Info
	 * @param totBkgCnt
	 */
	public void setTotBkgCnt(String totBkgCnt) {
		this.totBkgCnt = totBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param totBlCfmCntRdCnt
	 */
	public void setTotBlCfmCntRdCnt(String totBlCfmCntRdCnt) {
		this.totBlCfmCntRdCnt = totBlCfmCntRdCnt;
	}
	
	/**
	 * Column Info
	 * @param sumOriFSi
	 */
	public void setSumOriFSi(String sumOriFSi) {
		this.sumOriFSi = sumOriFSi;
	}
	
	/**
	 * Column Info
	 * @param totTimeSs
	 */
	public void setTotTimeSs(String totTimeSs) {
		this.totTimeSs = totTimeSs;
	}
	
	/**
	 * Column Info
	 * @param totHblCnt
	 */
	public void setTotHblCnt(String totHblCnt) {
		this.totHblCnt = totHblCnt;
	}
	
	/**
	 * Column Info
	 * @param totAmdIdCnt
	 */
	public void setTotAmdIdCnt(String totAmdIdCnt) {
		this.totAmdIdCnt = totAmdIdCnt;
	}
	
	/**
	 * Column Info
	 * @param totHisCnt
	 */
	public void setTotHisCnt(String totHisCnt) {
		this.totHisCnt = totHisCnt;
	}
	
	/**
	 * Column Info
	 * @param regionD
	 */
	public void setRegionD(String regionD) {
		this.regionD = regionD;
	}
	
	/**
	 * Column Info
	 * @param totBlCfmCntIdCnt
	 */
	public void setTotBlCfmCntIdCnt(String totBlCfmCntIdCnt) {
		this.totBlCfmCntIdCnt = totBlCfmCntIdCnt;
	}
	
	/**
	 * Column Info
	 * @param sumSi
	 */
	public void setSumSi(String sumSi) {
		this.sumSi = sumSi;
	}
	
	/**
	 * Column Info
	 * @param groupD
	 */
	public void setGroupD(String groupD) {
		this.groupD = groupD;
	}
	
	/**
	 * Column Info
	 * @param totAesIdCnt
	 */
	public void setTotAesIdCnt(String totAesIdCnt) {
		this.totAesIdCnt = totAesIdCnt;
	}
	
	/**
	 * Column Info
	 * @param totOriSenCnt
	 */
	public void setTotOriSenCnt(String totOriSenCnt) {
		this.totOriSenCnt = totOriSenCnt;
	}
	
	/**
	 * Column Info
	 * @param sumBkg
	 */
	public void setSumBkg(String sumBkg) {
		this.sumBkg = sumBkg;
	}
	
	/**
	 * Column Info
	 * @param avgTimeIn
	 */
	public void setAvgTimeIn(String avgTimeIn) {
		this.avgTimeIn = avgTimeIn;
	}
	
	/**
	 * Column Info
	 * @param totStaff
	 */
	public void setTotStaff(String totStaff) {
		this.totStaff = totStaff;
	}
	
	/**
	 * Column Info
	 * @param avgTimeRa
	 */
	public void setAvgTimeRa(String avgTimeRa) {
		this.avgTimeRa = avgTimeRa;
	}
	
	/**
	 * Column Info
	 * @param totalIPoint
	 */
	public void setTotalIPoint(String totalIPoint) {
		this.totalIPoint = totalIPoint;
	}
	
	/**
	 * Column Info
	 * @param sumStaff
	 */
	public void setSumStaff(String sumStaff) {
		this.sumStaff = sumStaff;
	}
	
	/**
	 * Column Info
	 * @param totAvgElapsedMm
	 */
	public void setTotAvgElapsedMm(String totAvgElapsedMm) {
		this.totAvgElapsedMm = totAvgElapsedMm;
	}
	
	/**
	 * Column Info
	 * @param totSiCnt
	 */
	public void setTotSiCnt(String totSiCnt) {
		this.totSiCnt = totSiCnt;
	}
	
	/**
	 * Column Info
	 * @param totElapsedMm
	 */
	public void setTotElapsedMm(String totElapsedMm) {
		this.totElapsedMm = totElapsedMm;
	}
	
	/**
	 * Column Info
	 * @param totAddiCntAdCnt
	 */
	public void setTotAddiCntAdCnt(String totAddiCntAdCnt) {
		this.totAddiCntAdCnt = totAddiCntAdCnt;
	}
	
	/**
	 * Column Info
	 * @param totAvgPoint
	 */
	public void setTotAvgPoint(String totAvgPoint) {
		this.totAvgPoint = totAvgPoint;
	}
	
	/**
	 * Column Info
	 * @param totElapsedDd
	 */
	public void setTotElapsedDd(String totElapsedDd) {
		this.totElapsedDd = totElapsedDd;
	}
	
	/**
	 * Column Info
	 * @param totavgElapsedDd
	 */
	public void setTotavgElapsedDd(String totavgElapsedDd) {
		this.totavgElapsedDd = totavgElapsedDd;
	}
	
	/**
	 * Column Info
	 * @param totTimeDd
	 */
	public void setTotTimeDd(String totTimeDd) {
		this.totTimeDd = totTimeDd;
	}
	
	/**
	 * Column Info
	 * @param avgTimeDd
	 */
	public void setAvgTimeDd(String avgTimeDd) {
		this.avgTimeDd = avgTimeDd;
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
		setTotAvgElapsedSs(JSPUtil.getParameter(request, prefix + "tot_avg_elapsed_ss", ""));
		setTotOriMailCnt(JSPUtil.getParameter(request, prefix + "tot_ori_mail_cnt", ""));
		setTotAmdRdCnt(JSPUtil.getParameter(request, prefix + "tot_amd_rd_cnt", ""));
		setTotAmdAdCnt(JSPUtil.getParameter(request, prefix + "tot_amd_ad_cnt", ""));
		setTotTimeHh(JSPUtil.getParameter(request, prefix + "tot_time_hh", ""));
		setAvgPointRa(JSPUtil.getParameter(request, prefix + "avg_point_ra", ""));
		setTotElapsed(JSPUtil.getParameter(request, prefix + "tot_elapsed", ""));
		setTotAvgElapsedHh(JSPUtil.getParameter(request, prefix + "tot_avg_elapsed_hh", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTotAvgElapsed(JSPUtil.getParameter(request, prefix + "tot_avg_elapsed", ""));
		setTotHblInRdCnt(JSPUtil.getParameter(request, prefix + "tot_hbl_in_rd_cnt", ""));
		setTotTimeMm(JSPUtil.getParameter(request, prefix + "tot_time_mm", ""));
		setAvgTimeQa(JSPUtil.getParameter(request, prefix + "avg_time_qa", ""));
		setTotInputElapsed(JSPUtil.getParameter(request, prefix + "tot_input_elapsed", ""));
		setAvgTimeMm(JSPUtil.getParameter(request, prefix + "avg_time_mm", ""));
		setTotHblInAdCnt(JSPUtil.getParameter(request, prefix + "tot_hbl_in_ad_cnt", ""));
		setSumOriMSi(JSPUtil.getParameter(request, prefix + "sum_ori_m_si", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setTotAddiCntIdCnt(JSPUtil.getParameter(request, prefix + "tot_addi_cnt_id_cnt", ""));
		setAvgPointQa(JSPUtil.getParameter(request, prefix + "avg_point_qa", ""));
		setTotElapsedSs(JSPUtil.getParameter(request, prefix + "tot_elapsed_ss", ""));
		setTotalRPoint(JSPUtil.getParameter(request, prefix + "total_r_point", ""));
		setTotHblInIdCnt(JSPUtil.getParameter(request, prefix + "tot_hbl_in_id_cnt", ""));
		setAvgTimeHh(JSPUtil.getParameter(request, prefix + "avg_time_hh", ""));
		setTotAddiCntRdCnt(JSPUtil.getParameter(request, prefix + "tot_addi_cnt_rd_cnt", ""));
		setTotRateElapsed(JSPUtil.getParameter(request, prefix + "tot_rate_elapsed", ""));
		setTotOriFaxCnt(JSPUtil.getParameter(request, prefix + "tot_ori_fax_cnt", ""));
		setAvgTimeSs(JSPUtil.getParameter(request, prefix + "avg_time_ss", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setTotAesRdCnt(JSPUtil.getParameter(request, prefix + "tot_aes_rd_cnt", ""));
		setTotAesAdCnt(JSPUtil.getParameter(request, prefix + "tot_aes_ad_cnt", ""));
		setTotBlCfmCntAdCnt(JSPUtil.getParameter(request, prefix + "tot_bl_cfm_cnt_ad_cnt", ""));
		setSumOriESi(JSPUtil.getParameter(request, prefix + "sum_ori_e_si", ""));
		setTotOriEdiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_edi_cnt", ""));
		setTotalAPoint(JSPUtil.getParameter(request, prefix + "total_a_point", ""));
		setAvgPointId(JSPUtil.getParameter(request, prefix + "avg_point_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotElapsedHh(JSPUtil.getParameter(request, prefix + "tot_elapsed_hh", ""));
		setTotQaElapsed(JSPUtil.getParameter(request, prefix + "tot_qa_elapsed", ""));
		setTotBkgCnt(JSPUtil.getParameter(request, prefix + "tot_bkg_cnt", ""));
		setTotBlCfmCntRdCnt(JSPUtil.getParameter(request, prefix + "tot_bl_cfm_cnt_rd_cnt", ""));
		setSumOriFSi(JSPUtil.getParameter(request, prefix + "sum_ori_f_si", ""));
		setTotTimeSs(JSPUtil.getParameter(request, prefix + "tot_time_ss", ""));
		setTotHblCnt(JSPUtil.getParameter(request, prefix + "tot_hbl_cnt", ""));
		setTotAmdIdCnt(JSPUtil.getParameter(request, prefix + "tot_amd_id_cnt", ""));
		setTotHisCnt(JSPUtil.getParameter(request, prefix + "tot_his_cnt", ""));
		setRegionD(JSPUtil.getParameter(request, prefix + "region_d", ""));
		setTotBlCfmCntIdCnt(JSPUtil.getParameter(request, prefix + "tot_bl_cfm_cnt_id_cnt", ""));
		setSumSi(JSPUtil.getParameter(request, prefix + "sum_si", ""));
		setGroupD(JSPUtil.getParameter(request, prefix + "group_d", ""));
		setTotAesIdCnt(JSPUtil.getParameter(request, prefix + "tot_aes_id_cnt", ""));
		setTotOriSenCnt(JSPUtil.getParameter(request, prefix + "tot_ori_sen_cnt", ""));
		setSumBkg(JSPUtil.getParameter(request, prefix + "sum_bkg", ""));
		setAvgTimeIn(JSPUtil.getParameter(request, prefix + "avg_time_in", ""));
		setTotStaff(JSPUtil.getParameter(request, prefix + "tot_staff", ""));
		setAvgTimeRa(JSPUtil.getParameter(request, prefix + "avg_time_ra", ""));
		setTotalIPoint(JSPUtil.getParameter(request, prefix + "total_i_point", ""));
		setSumStaff(JSPUtil.getParameter(request, prefix + "sum_staff", ""));
		setTotAvgElapsedMm(JSPUtil.getParameter(request, prefix + "tot_avg_elapsed_mm", ""));
		setTotSiCnt(JSPUtil.getParameter(request, prefix + "tot_si_cnt", ""));
		setTotElapsedMm(JSPUtil.getParameter(request, prefix + "tot_elapsed_mm", ""));
		setTotAddiCntAdCnt(JSPUtil.getParameter(request, prefix + "tot_addi_cnt_ad_cnt", ""));
		setTotAvgPoint(JSPUtil.getParameter(request, prefix + "tot_avg_point", ""));
		setTotElapsedDd(JSPUtil.getParameter(request, prefix + "tot_elapsed_dd", ""));
		setTotavgElapsedDd(JSPUtil.getParameter(request, prefix + "tot_avg_elapsed_dd", ""));
		setTotavgElapsedDd(JSPUtil.getParameter(request, prefix + "tot_time_dd", ""));
		setTotavgElapsedDd(JSPUtil.getParameter(request, prefix + "avg_time_dd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerfVolByRegionGroupListVO[]
	 */
	public SearchPerfVolByRegionGroupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerfVolByRegionGroupListVO[]
	 */
	public SearchPerfVolByRegionGroupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerfVolByRegionGroupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totAvgElapsedSs = (JSPUtil.getParameter(request, prefix	+ "tot_avg_elapsed_ss", length));
			String[] totOriMailCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_mail_cnt", length));
			String[] totAmdRdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_amd_rd_cnt", length));
			String[] totAmdAdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_amd_ad_cnt", length));
			String[] totTimeHh = (JSPUtil.getParameter(request, prefix	+ "tot_time_hh", length));
			String[] avgPointRa = (JSPUtil.getParameter(request, prefix	+ "avg_point_ra", length));
			String[] totElapsed = (JSPUtil.getParameter(request, prefix	+ "tot_elapsed", length));
			String[] totAvgElapsedHh = (JSPUtil.getParameter(request, prefix	+ "tot_avg_elapsed_hh", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totAvgElapsed = (JSPUtil.getParameter(request, prefix	+ "tot_avg_elapsed", length));
			String[] totHblInRdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_hbl_in_rd_cnt", length));
			String[] totTimeMm = (JSPUtil.getParameter(request, prefix	+ "tot_time_mm", length));
			String[] avgTimeQa = (JSPUtil.getParameter(request, prefix	+ "avg_time_qa", length));
			String[] totInputElapsed = (JSPUtil.getParameter(request, prefix	+ "tot_input_elapsed", length));
			String[] avgTimeMm = (JSPUtil.getParameter(request, prefix	+ "avg_time_mm", length));
			String[] totHblInAdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_hbl_in_ad_cnt", length));
			String[] sumOriMSi = (JSPUtil.getParameter(request, prefix	+ "sum_ori_m_si", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] totAddiCntIdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_addi_cnt_id_cnt", length));
			String[] avgPointQa = (JSPUtil.getParameter(request, prefix	+ "avg_point_qa", length));
			String[] totElapsedSs = (JSPUtil.getParameter(request, prefix	+ "tot_elapsed_ss", length));
			String[] totalRPoint = (JSPUtil.getParameter(request, prefix	+ "total_r_point", length));
			String[] totHblInIdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_hbl_in_id_cnt", length));
			String[] avgTimeHh = (JSPUtil.getParameter(request, prefix	+ "avg_time_hh", length));
			String[] totAddiCntRdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_addi_cnt_rd_cnt", length));
			String[] totRateElapsed = (JSPUtil.getParameter(request, prefix	+ "tot_rate_elapsed", length));
			String[] totOriFaxCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_fax_cnt", length));
			String[] avgTimeSs = (JSPUtil.getParameter(request, prefix	+ "avg_time_ss", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] totAesRdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_aes_rd_cnt", length));
			String[] totAesAdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_aes_ad_cnt", length));
			String[] totBlCfmCntAdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_bl_cfm_cnt_ad_cnt", length));
			String[] sumOriESi = (JSPUtil.getParameter(request, prefix	+ "sum_ori_e_si", length));
			String[] totOriEdiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_edi_cnt", length));
			String[] totalAPoint = (JSPUtil.getParameter(request, prefix	+ "total_a_point", length));
			String[] avgPointId = (JSPUtil.getParameter(request, prefix	+ "avg_point_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totElapsedHh = (JSPUtil.getParameter(request, prefix	+ "tot_elapsed_hh", length));
			String[] totQaElapsed = (JSPUtil.getParameter(request, prefix	+ "tot_qa_elapsed", length));
			String[] totBkgCnt = (JSPUtil.getParameter(request, prefix	+ "tot_bkg_cnt", length));
			String[] totBlCfmCntRdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_bl_cfm_cnt_rd_cnt", length));
			String[] sumOriFSi = (JSPUtil.getParameter(request, prefix	+ "sum_ori_f_si", length));
			String[] totTimeSs = (JSPUtil.getParameter(request, prefix	+ "tot_time_ss", length));
			String[] totHblCnt = (JSPUtil.getParameter(request, prefix	+ "tot_hbl_cnt", length));
			String[] totAmdIdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_amd_id_cnt", length));
			String[] totHisCnt = (JSPUtil.getParameter(request, prefix	+ "tot_his_cnt", length));
			String[] regionD = (JSPUtil.getParameter(request, prefix	+ "region_d", length));
			String[] totBlCfmCntIdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_bl_cfm_cnt_id_cnt", length));
			String[] sumSi = (JSPUtil.getParameter(request, prefix	+ "sum_si", length));
			String[] groupD = (JSPUtil.getParameter(request, prefix	+ "group_d", length));
			String[] totAesIdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_aes_id_cnt", length));
			String[] totOriSenCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_sen_cnt", length));
			String[] sumBkg = (JSPUtil.getParameter(request, prefix	+ "sum_bkg", length));
			String[] avgTimeIn = (JSPUtil.getParameter(request, prefix	+ "avg_time_in", length));
			String[] totStaff = (JSPUtil.getParameter(request, prefix	+ "tot_staff", length));
			String[] avgTimeRa = (JSPUtil.getParameter(request, prefix	+ "avg_time_ra", length));
			String[] totalIPoint = (JSPUtil.getParameter(request, prefix	+ "total_i_point", length));
			String[] sumStaff = (JSPUtil.getParameter(request, prefix	+ "sum_staff", length));
			String[] totAvgElapsedMm = (JSPUtil.getParameter(request, prefix	+ "tot_avg_elapsed_mm", length));
			String[] totSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_si_cnt", length));
			String[] totElapsedMm = (JSPUtil.getParameter(request, prefix	+ "tot_elapsed_mm", length));
			String[] totAddiCntAdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_addi_cnt_ad_cnt", length));
			String[] totAvgPoint = (JSPUtil.getParameter(request, prefix	+ "tot_avg_point", length));
			String[] totElapsedDd = (JSPUtil.getParameter(request, prefix	+ "tot_elapsed_dd", length));
			String[] totavgElapsedDd = (JSPUtil.getParameter(request, prefix	+ "tot_avg_elapsed_dd", length));
			String[] totTimeDd = (JSPUtil.getParameter(request, prefix	+ "tot_time_dd", length));
			String[] avgTimeDd = (JSPUtil.getParameter(request, prefix	+ "avg_time_dd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerfVolByRegionGroupListVO();
				if (totAvgElapsedSs[i] != null)
					model.setTotAvgElapsedSs(totAvgElapsedSs[i]);
				if (totOriMailCnt[i] != null)
					model.setTotOriMailCnt(totOriMailCnt[i]);
				if (totAmdRdCnt[i] != null)
					model.setTotAmdRdCnt(totAmdRdCnt[i]);
				if (totAmdAdCnt[i] != null)
					model.setTotAmdAdCnt(totAmdAdCnt[i]);
				if (totTimeHh[i] != null)
					model.setTotTimeHh(totTimeHh[i]);
				if (avgPointRa[i] != null)
					model.setAvgPointRa(avgPointRa[i]);
				if (totElapsed[i] != null)
					model.setTotElapsed(totElapsed[i]);
				if (totAvgElapsedHh[i] != null)
					model.setTotAvgElapsedHh(totAvgElapsedHh[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totAvgElapsed[i] != null)
					model.setTotAvgElapsed(totAvgElapsed[i]);
				if (totHblInRdCnt[i] != null)
					model.setTotHblInRdCnt(totHblInRdCnt[i]);
				if (totTimeMm[i] != null)
					model.setTotTimeMm(totTimeMm[i]);
				if (avgTimeQa[i] != null)
					model.setAvgTimeQa(avgTimeQa[i]);
				if (totInputElapsed[i] != null)
					model.setTotInputElapsed(totInputElapsed[i]);
				if (avgTimeMm[i] != null)
					model.setAvgTimeMm(avgTimeMm[i]);
				if (totHblInAdCnt[i] != null)
					model.setTotHblInAdCnt(totHblInAdCnt[i]);
				if (sumOriMSi[i] != null)
					model.setSumOriMSi(sumOriMSi[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (totAddiCntIdCnt[i] != null)
					model.setTotAddiCntIdCnt(totAddiCntIdCnt[i]);
				if (avgPointQa[i] != null)
					model.setAvgPointQa(avgPointQa[i]);
				if (totElapsedSs[i] != null)
					model.setTotElapsedSs(totElapsedSs[i]);
				if (totalRPoint[i] != null)
					model.setTotalRPoint(totalRPoint[i]);
				if (totHblInIdCnt[i] != null)
					model.setTotHblInIdCnt(totHblInIdCnt[i]);
				if (avgTimeHh[i] != null)
					model.setAvgTimeHh(avgTimeHh[i]);
				if (totAddiCntRdCnt[i] != null)
					model.setTotAddiCntRdCnt(totAddiCntRdCnt[i]);
				if (totRateElapsed[i] != null)
					model.setTotRateElapsed(totRateElapsed[i]);
				if (totOriFaxCnt[i] != null)
					model.setTotOriFaxCnt(totOriFaxCnt[i]);
				if (avgTimeSs[i] != null)
					model.setAvgTimeSs(avgTimeSs[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (totAesRdCnt[i] != null)
					model.setTotAesRdCnt(totAesRdCnt[i]);
				if (totAesAdCnt[i] != null)
					model.setTotAesAdCnt(totAesAdCnt[i]);
				if (totBlCfmCntAdCnt[i] != null)
					model.setTotBlCfmCntAdCnt(totBlCfmCntAdCnt[i]);
				if (sumOriESi[i] != null)
					model.setSumOriESi(sumOriESi[i]);
				if (totOriEdiCnt[i] != null)
					model.setTotOriEdiCnt(totOriEdiCnt[i]);
				if (totalAPoint[i] != null)
					model.setTotalAPoint(totalAPoint[i]);
				if (avgPointId[i] != null)
					model.setAvgPointId(avgPointId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totElapsedHh[i] != null)
					model.setTotElapsedHh(totElapsedHh[i]);
				if (totQaElapsed[i] != null)
					model.setTotQaElapsed(totQaElapsed[i]);
				if (totBkgCnt[i] != null)
					model.setTotBkgCnt(totBkgCnt[i]);
				if (totBlCfmCntRdCnt[i] != null)
					model.setTotBlCfmCntRdCnt(totBlCfmCntRdCnt[i]);
				if (sumOriFSi[i] != null)
					model.setSumOriFSi(sumOriFSi[i]);
				if (totTimeSs[i] != null)
					model.setTotTimeSs(totTimeSs[i]);
				if (totHblCnt[i] != null)
					model.setTotHblCnt(totHblCnt[i]);
				if (totAmdIdCnt[i] != null)
					model.setTotAmdIdCnt(totAmdIdCnt[i]);
				if (totHisCnt[i] != null)
					model.setTotHisCnt(totHisCnt[i]);
				if (regionD[i] != null)
					model.setRegionD(regionD[i]);
				if (totBlCfmCntIdCnt[i] != null)
					model.setTotBlCfmCntIdCnt(totBlCfmCntIdCnt[i]);
				if (sumSi[i] != null)
					model.setSumSi(sumSi[i]);
				if (groupD[i] != null)
					model.setGroupD(groupD[i]);
				if (totAesIdCnt[i] != null)
					model.setTotAesIdCnt(totAesIdCnt[i]);
				if (totOriSenCnt[i] != null)
					model.setTotOriSenCnt(totOriSenCnt[i]);
				if (sumBkg[i] != null)
					model.setSumBkg(sumBkg[i]);
				if (avgTimeIn[i] != null)
					model.setAvgTimeIn(avgTimeIn[i]);
				if (totStaff[i] != null)
					model.setTotStaff(totStaff[i]);
				if (avgTimeRa[i] != null)
					model.setAvgTimeRa(avgTimeRa[i]);
				if (totalIPoint[i] != null)
					model.setTotalIPoint(totalIPoint[i]);
				if (sumStaff[i] != null)
					model.setSumStaff(sumStaff[i]);
				if (totAvgElapsedMm[i] != null)
					model.setTotAvgElapsedMm(totAvgElapsedMm[i]);
				if (totSiCnt[i] != null)
					model.setTotSiCnt(totSiCnt[i]);
				if (totElapsedMm[i] != null)
					model.setTotElapsedMm(totElapsedMm[i]);
				if (totAddiCntAdCnt[i] != null)
					model.setTotAddiCntAdCnt(totAddiCntAdCnt[i]);
				if (totAvgPoint[i] != null)
					model.setTotAvgPoint(totAvgPoint[i]);
				if (totElapsedDd[i] != null)
					model.setTotElapsedDd(totElapsedDd[i]);
				if (totavgElapsedDd[i] != null)
					model.setTotavgElapsedDd(totavgElapsedDd[i]);
				if (totTimeDd[i] != null)
					model.setTotTimeDd(totTimeDd[i]);
				if (avgTimeDd[i] != null)
					model.setAvgTimeDd(avgTimeDd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerfVolByRegionGroupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerfVolByRegionGroupListVO[]
	 */
	public SearchPerfVolByRegionGroupListVO[] getSearchPerfVolByRegionGroupListVOs(){
		SearchPerfVolByRegionGroupListVO[] vos = (SearchPerfVolByRegionGroupListVO[])models.toArray(new SearchPerfVolByRegionGroupListVO[models.size()]);
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
		this.totAvgElapsedSs = this.totAvgElapsedSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriMailCnt = this.totOriMailCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmdRdCnt = this.totAmdRdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmdAdCnt = this.totAmdAdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTimeHh = this.totTimeHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPointRa = this.avgPointRa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totElapsed = this.totElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAvgElapsedHh = this.totAvgElapsedHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAvgElapsed = this.totAvgElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHblInRdCnt = this.totHblInRdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTimeMm = this.totTimeMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeQa = this.avgTimeQa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totInputElapsed = this.totInputElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeMm = this.avgTimeMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHblInAdCnt = this.totHblInAdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOriMSi = this.sumOriMSi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAddiCntIdCnt = this.totAddiCntIdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPointQa = this.avgPointQa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totElapsedSs = this.totElapsedSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRPoint = this.totalRPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHblInIdCnt = this.totHblInIdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeHh = this.avgTimeHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAddiCntRdCnt = this.totAddiCntRdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRateElapsed = this.totRateElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriFaxCnt = this.totOriFaxCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeSs = this.avgTimeSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAesRdCnt = this.totAesRdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAesAdCnt = this.totAesAdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBlCfmCntAdCnt = this.totBlCfmCntAdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOriESi = this.sumOriESi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriEdiCnt = this.totOriEdiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAPoint = this.totalAPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPointId = this.avgPointId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totElapsedHh = this.totElapsedHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQaElapsed = this.totQaElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBkgCnt = this.totBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBlCfmCntRdCnt = this.totBlCfmCntRdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOriFSi = this.sumOriFSi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTimeSs = this.totTimeSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHblCnt = this.totHblCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmdIdCnt = this.totAmdIdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHisCnt = this.totHisCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionD = this.regionD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBlCfmCntIdCnt = this.totBlCfmCntIdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumSi = this.sumSi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupD = this.groupD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAesIdCnt = this.totAesIdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriSenCnt = this.totOriSenCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumBkg = this.sumBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeIn = this.avgTimeIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaff = this.totStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeRa = this.avgTimeRa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalIPoint = this.totalIPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumStaff = this.sumStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAvgElapsedMm = this.totAvgElapsedMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSiCnt = this.totSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totElapsedMm = this.totElapsedMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAddiCntAdCnt = this.totAddiCntAdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAvgPoint = this.totAvgPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totElapsedDd = this.totElapsedDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totavgElapsedDd = this.totavgElapsedDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTimeDd = this.totTimeDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTimeDd = this.avgTimeDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
