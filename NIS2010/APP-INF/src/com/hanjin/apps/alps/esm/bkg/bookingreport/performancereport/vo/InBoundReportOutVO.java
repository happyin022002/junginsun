/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InBoundReportOutVO.java
*@FileTitle : InBoundReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.27 김태경 
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

public class InBoundReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InBoundReportOutVO> models = new ArrayList<InBoundReportOutVO>();
	
	/* Column Info */
	private String totalSumTsBl = null;
	/* Column Info */
	private String sumO4 = null;
	/* Column Info */
	private String totalSumJik20 = null;
	/* Column Info */
	private String sumTs20 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String duraCd = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String sumR45 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCd2 = null;
	/* Column Info */
	private String vvdCd1 = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String totalSumF4 = null;
	/* Column Info */
	private String sumO2 = null;
	/* Column Info */
	private String ts40 = null;
	/* Column Info */
	private String totalSumF2 = null;
	/* Column Info */
	private String podYardCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String tsBl = null;
	/* Column Info */
	private String ttl20 = null;
	/* Column Info */
	private String totalSumT2 = null;
	/* Column Info */
	private String r45 = null;
	/* Column Info */
	private String totalSumT4 = null;
	/* Column Info */
	private String jik40 = null;
	/* Column Info */
	private String ataCd2 = null;
	/* Column Info */
	private String ataCd1 = null;
	/* Column Info */
	private String totalSumTs40 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String sumTsBl = null;
	/* Column Info */
	private String sumTtl20 = null;
	/* Column Info */
	private String sumT4 = null;
	/* Column Info */
	private String ibBl = null;
	/* Column Info */
	private String sumT2 = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String sumD2 = null;
	/* Column Info */
	private String totalSumTtl40 = null;
	/* Column Info */
	private String yyyy = null;
	/* Column Info */
	private String sumD4 = null;
	/* Column Info */
	private String sumJik40 = null;
	/* Column Info */
	private String sumD5 = null;
	/* Column Info */
	private String sumD7 = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String ts20 = null;
	/* Column Info */
	private String totalSumR45 = null;
	/* Column Info */
	private String staffNm = null;
	/* Column Info */
	private String totalSumJik40 = null;
	/* Column Info */
	private String totalSumD5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalSumO2 = null;
	/* Column Info */
	private String totalSumD7 = null;
	/* Column Info */
	private String totalSumO4 = null;
	/* Column Info */
	private String totalSumIbBl = null;
	/* Column Info */
	private String sumIbBl = null;
	/* Column Info */
	private String totalSumD2 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String totalSumD4 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String jik20 = null;
	/* Column Info */
	private String staffId = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String weeks = null;
	/* Column Info */
	private String ttl40 = null;
	/* Column Info */
	private String totalSumTs20 = null;
	/* Column Info */
	private String sumR2 = null;
	/* Column Info */
	private String totalSumR2 = null;
	/* Column Info */
	private String sumTtl40 = null;
	/* Column Info */
	private String sumF2 = null;
	/* Column Info */
	private String sumF4 = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String sumTs40 = null;
	/* Column Info */
	private String sumJik20 = null;
	/* Column Info */
	private String totalSumTtl20 = null;
	/* Column Info */
	private String o5 = null;
	/* Column Info */
	private String sumO5 = null;
	/* Column Info */
	private String totalSumO5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InBoundReportOutVO() {}

	public InBoundReportOutVO(String ibflag, String pagerows, String totalSumIbBl, String totalSumD2, String totalSumD4, String totalSumD5, String totalSumD7, String totalSumR2, String totalSumR45, String totalSumO2, String totalSumO4, String totalSumO5, String totalSumF2, String totalSumF4, String totalSumT2, String totalSumT4, String totalSumTtl40, String totalSumTtl20, String totalSumTsBl, String totalSumTs40, String totalSumTs20, String totalSumJik40, String totalSumJik20, String sumIbBl, String sumD2, String sumD4, String sumD5, String sumD7, String sumR2, String sumR45, String sumO2, String sumO4, String sumO5, String sumF2, String sumF4, String sumT2, String sumT4, String sumTtl40, String sumTtl20, String sumTsBl, String sumTs40, String sumTs20, String sumJik40, String sumJik20, String yyyy, String weeks, String laneCd, String podCd, String podYardCd, String delCd, String staffId, String staffNm, String vvdCd1, String vvdCd2, String ataCd1, String ataCd2, String ibBl, String d2, String d4, String d5, String d7, String r2, String r45, String o2, String o4, String o5,String f2, String f4, String t2, String t4, String ttl40, String ttl20, String tsBl, String ts40, String ts20, String jik40, String jik20, String duraCd) {
		this.totalSumTsBl = totalSumTsBl;
		this.sumO4 = sumO4;
		this.totalSumJik20 = totalSumJik20;
		this.sumTs20 = sumTs20;
		this.d5 = d5;
		this.duraCd = duraCd;
		this.d4 = d4;
		this.d7 = d7;
		this.sumR45 = sumR45;
		this.pagerows = pagerows;
		this.vvdCd2 = vvdCd2;
		this.vvdCd1 = vvdCd1;
		this.d2 = d2;
		this.totalSumF4 = totalSumF4;
		this.sumO2 = sumO2;
		this.ts40 = ts40;
		this.totalSumF2 = totalSumF2;
		this.podYardCd = podYardCd;
		this.delCd = delCd;
		this.tsBl = tsBl;
		this.ttl20 = ttl20;
		this.totalSumT2 = totalSumT2;
		this.r45 = r45;
		this.totalSumT4 = totalSumT4;
		this.jik40 = jik40;
		this.ataCd2 = ataCd2;
		this.ataCd1 = ataCd1;
		this.totalSumTs40 = totalSumTs40;
		this.podCd = podCd;
		this.sumTsBl = sumTsBl;
		this.sumTtl20 = sumTtl20;
		this.sumT4 = sumT4;
		this.ibBl = ibBl;
		this.sumT2 = sumT2;
		this.t4 = t4;
		this.sumD2 = sumD2;
		this.totalSumTtl40 = totalSumTtl40;
		this.yyyy = yyyy;
		this.sumD4 = sumD4;
		this.sumJik40 = sumJik40;
		this.sumD5 = sumD5;
		this.sumD7 = sumD7;
		this.t2 = t2;
		this.laneCd = laneCd;
		this.ts20 = ts20;
		this.totalSumR45 = totalSumR45;
		this.staffNm = staffNm;
		this.totalSumJik40 = totalSumJik40;
		this.totalSumD5 = totalSumD5;
		this.ibflag = ibflag;
		this.totalSumO2 = totalSumO2;
		this.totalSumD7 = totalSumD7;
		this.totalSumO4 = totalSumO4;
		this.totalSumIbBl = totalSumIbBl;
		this.sumIbBl = sumIbBl;
		this.totalSumD2 = totalSumD2;
		this.f2 = f2;
		this.totalSumD4 = totalSumD4;
		this.f4 = f4;
		this.o2 = o2;
		this.jik20 = jik20;
		this.staffId = staffId;
		this.o4 = o4;
		this.weeks = weeks;
		this.ttl40 = ttl40;
		this.totalSumTs20 = totalSumTs20;
		this.sumR2 = sumR2;
		this.totalSumR2 = totalSumR2;
		this.sumTtl40 = sumTtl40;
		this.sumF2 = sumF2;
		this.sumF4 = sumF4;
		this.r2 = r2;
		this.sumTs40 = sumTs40;
		this.sumJik20 = sumJik20;
		this.totalSumTtl20 = totalSumTtl20;
		this.o5 = o5;
		this.sumO5 = sumO5;
		this.totalSumO5 = totalSumO5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_sum_ts_bl", getTotalSumTsBl());
		this.hashColumns.put("sum_o4", getSumO4());
		this.hashColumns.put("total_sum_jik20", getTotalSumJik20());
		this.hashColumns.put("sum_ts20", getSumTs20());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("dura_cd", getDuraCd());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("sum_r45", getSumR45());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd2", getVvdCd2());
		this.hashColumns.put("vvd_cd1", getVvdCd1());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("total_sum_f4", getTotalSumF4());
		this.hashColumns.put("sum_o2", getSumO2());
		this.hashColumns.put("ts40", getTs40());
		this.hashColumns.put("total_sum_f2", getTotalSumF2());
		this.hashColumns.put("pod_yard_cd", getPodYardCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ts_bl", getTsBl());
		this.hashColumns.put("ttl20", getTtl20());
		this.hashColumns.put("total_sum_t2", getTotalSumT2());
		this.hashColumns.put("r45", getR45());
		this.hashColumns.put("total_sum_t4", getTotalSumT4());
		this.hashColumns.put("jik40", getJik40());
		this.hashColumns.put("ata_cd2", getAtaCd2());
		this.hashColumns.put("ata_cd1", getAtaCd1());
		this.hashColumns.put("total_sum_ts40", getTotalSumTs40());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sum_ts_bl", getSumTsBl());
		this.hashColumns.put("sum_ttl20", getSumTtl20());
		this.hashColumns.put("sum_t4", getSumT4());
		this.hashColumns.put("ib_bl", getIbBl());
		this.hashColumns.put("sum_t2", getSumT2());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("sum_d2", getSumD2());
		this.hashColumns.put("total_sum_ttl40", getTotalSumTtl40());
		this.hashColumns.put("yyyy", getYyyy());
		this.hashColumns.put("sum_d4", getSumD4());
		this.hashColumns.put("sum_jik40", getSumJik40());
		this.hashColumns.put("sum_d5", getSumD5());
		this.hashColumns.put("sum_d7", getSumD7());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("ts20", getTs20());
		this.hashColumns.put("total_sum_r45", getTotalSumR45());
		this.hashColumns.put("staff_nm", getStaffNm());
		this.hashColumns.put("total_sum_jik40", getTotalSumJik40());
		this.hashColumns.put("total_sum_d5", getTotalSumD5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_sum_o2", getTotalSumO2());
		this.hashColumns.put("total_sum_d7", getTotalSumD7());
		this.hashColumns.put("total_sum_o4", getTotalSumO4());
		this.hashColumns.put("total_sum_ib_bl", getTotalSumIbBl());
		this.hashColumns.put("sum_ib_bl", getSumIbBl());
		this.hashColumns.put("total_sum_d2", getTotalSumD2());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("total_sum_d4", getTotalSumD4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("jik20", getJik20());
		this.hashColumns.put("staff_id", getStaffId());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("weeks", getWeeks());
		this.hashColumns.put("ttl40", getTtl40());
		this.hashColumns.put("total_sum_ts20", getTotalSumTs20());
		this.hashColumns.put("sum_r2", getSumR2());
		this.hashColumns.put("total_sum_r2", getTotalSumR2());
		this.hashColumns.put("sum_ttl40", getSumTtl40());
		this.hashColumns.put("sum_f2", getSumF2());
		this.hashColumns.put("sum_f4", getSumF4());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("sum_ts40", getSumTs40());
		this.hashColumns.put("sum_jik20", getSumJik20());
		this.hashColumns.put("total_sum_ttl20", getTotalSumTtl20());
		this.hashColumns.put("o5", getO5());
		this.hashColumns.put("sum_o5", getSumO5());
		this.hashColumns.put("total_sum_o5", getTotalSumO5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_sum_ts_bl", "totalSumTsBl");
		this.hashFields.put("sum_o4", "sumO4");
		this.hashFields.put("total_sum_jik20", "totalSumJik20");
		this.hashFields.put("sum_ts20", "sumTs20");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("dura_cd", "duraCd");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("sum_r45", "sumR45");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd2", "vvdCd2");
		this.hashFields.put("vvd_cd1", "vvdCd1");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("total_sum_f4", "totalSumF4");
		this.hashFields.put("sum_o2", "sumO2");
		this.hashFields.put("ts40", "ts40");
		this.hashFields.put("total_sum_f2", "totalSumF2");
		this.hashFields.put("pod_yard_cd", "podYardCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ts_bl", "tsBl");
		this.hashFields.put("ttl20", "ttl20");
		this.hashFields.put("total_sum_t2", "totalSumT2");
		this.hashFields.put("r45", "r45");
		this.hashFields.put("total_sum_t4", "totalSumT4");
		this.hashFields.put("jik40", "jik40");
		this.hashFields.put("ata_cd2", "ataCd2");
		this.hashFields.put("ata_cd1", "ataCd1");
		this.hashFields.put("total_sum_ts40", "totalSumTs40");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sum_ts_bl", "sumTsBl");
		this.hashFields.put("sum_ttl20", "sumTtl20");
		this.hashFields.put("sum_t4", "sumT4");
		this.hashFields.put("ib_bl", "ibBl");
		this.hashFields.put("sum_t2", "sumT2");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("sum_d2", "sumD2");
		this.hashFields.put("total_sum_ttl40", "totalSumTtl40");
		this.hashFields.put("yyyy", "yyyy");
		this.hashFields.put("sum_d4", "sumD4");
		this.hashFields.put("sum_jik40", "sumJik40");
		this.hashFields.put("sum_d5", "sumD5");
		this.hashFields.put("sum_d7", "sumD7");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("ts20", "ts20");
		this.hashFields.put("total_sum_r45", "totalSumR45");
		this.hashFields.put("staff_nm", "staffNm");
		this.hashFields.put("total_sum_jik40", "totalSumJik40");
		this.hashFields.put("total_sum_d5", "totalSumD5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_sum_o2", "totalSumO2");
		this.hashFields.put("total_sum_d7", "totalSumD7");
		this.hashFields.put("total_sum_o4", "totalSumO4");
		this.hashFields.put("total_sum_ib_bl", "totalSumIbBl");
		this.hashFields.put("sum_ib_bl", "sumIbBl");
		this.hashFields.put("total_sum_d2", "totalSumD2");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("total_sum_d4", "totalSumD4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("jik20", "jik20");
		this.hashFields.put("staff_id", "staffId");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("weeks", "weeks");
		this.hashFields.put("ttl40", "ttl40");
		this.hashFields.put("total_sum_ts20", "totalSumTs20");
		this.hashFields.put("sum_r2", "sumR2");
		this.hashFields.put("total_sum_r2", "totalSumR2");
		this.hashFields.put("sum_ttl40", "sumTtl40");
		this.hashFields.put("sum_f2", "sumF2");
		this.hashFields.put("sum_f4", "sumF4");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("sum_ts40", "sumTs40");
		this.hashFields.put("sum_jik20", "sumJik20");
		this.hashFields.put("total_sum_ttl20", "totalSumTtl20");
		this.hashFields.put("o5", "o5");
		this.hashFields.put("sum_o5", "sumO5");
		this.hashFields.put("total_sum_o5", "totalSumO5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totalSumTsBl
	 */
	public String getTotalSumTsBl() {
		return this.totalSumTsBl;
	}
	
	/**
	 * Column Info
	 * @return sumO4
	 */
	public String getSumO4() {
		return this.sumO4;
	}
	
	/**
	 * Column Info
	 * @return totalSumJik20
	 */
	public String getTotalSumJik20() {
		return this.totalSumJik20;
	}
	
	/**
	 * Column Info
	 * @return sumTs20
	 */
	public String getSumTs20() {
		return this.sumTs20;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return duraCd
	 */
	public String getDuraCd() {
		return this.duraCd;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
	}
	
	/**
	 * Column Info
	 * @return sumR45
	 */
	public String getSumR45() {
		return this.sumR45;
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
	 * @return vvdCd2
	 */
	public String getVvdCd2() {
		return this.vvdCd2;
	}
	
	/**
	 * Column Info
	 * @return vvdCd1
	 */
	public String getVvdCd1() {
		return this.vvdCd1;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
	}
	
	/**
	 * Column Info
	 * @return totalSumF4
	 */
	public String getTotalSumF4() {
		return this.totalSumF4;
	}
	
	/**
	 * Column Info
	 * @return sumO2
	 */
	public String getSumO2() {
		return this.sumO2;
	}
	
	/**
	 * Column Info
	 * @return ts40
	 */
	public String getTs40() {
		return this.ts40;
	}
	
	/**
	 * Column Info
	 * @return totalSumF2
	 */
	public String getTotalSumF2() {
		return this.totalSumF2;
	}
	
	/**
	 * Column Info
	 * @return podYardCd
	 */
	public String getPodYardCd() {
		return this.podYardCd;
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
	 * @return tsBl
	 */
	public String getTsBl() {
		return this.tsBl;
	}
	
	/**
	 * Column Info
	 * @return ttl20
	 */
	public String getTtl20() {
		return this.ttl20;
	}
	
	/**
	 * Column Info
	 * @return totalSumT2
	 */
	public String getTotalSumT2() {
		return this.totalSumT2;
	}
	
	/**
	 * Column Info
	 * @return r45
	 */
	public String getR45() {
		return this.r45;
	}
	
	/**
	 * Column Info
	 * @return totalSumT4
	 */
	public String getTotalSumT4() {
		return this.totalSumT4;
	}
	
	/**
	 * Column Info
	 * @return jik40
	 */
	public String getJik40() {
		return this.jik40;
	}
	
	/**
	 * Column Info
	 * @return ataCd2
	 */
	public String getAtaCd2() {
		return this.ataCd2;
	}
	
	/**
	 * Column Info
	 * @return ataCd1
	 */
	public String getAtaCd1() {
		return this.ataCd1;
	}
	
	/**
	 * Column Info
	 * @return totalSumTs40
	 */
	public String getTotalSumTs40() {
		return this.totalSumTs40;
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
	 * @return sumTsBl
	 */
	public String getSumTsBl() {
		return this.sumTsBl;
	}
	
	/**
	 * Column Info
	 * @return sumTtl20
	 */
	public String getSumTtl20() {
		return this.sumTtl20;
	}
	
	/**
	 * Column Info
	 * @return sumT4
	 */
	public String getSumT4() {
		return this.sumT4;
	}
	
	/**
	 * Column Info
	 * @return ibBl
	 */
	public String getIbBl() {
		return this.ibBl;
	}
	
	/**
	 * Column Info
	 * @return sumT2
	 */
	public String getSumT2() {
		return this.sumT2;
	}
	
	/**
	 * Column Info
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return sumD2
	 */
	public String getSumD2() {
		return this.sumD2;
	}
	
	/**
	 * Column Info
	 * @return totalSumTtl40
	 */
	public String getTotalSumTtl40() {
		return this.totalSumTtl40;
	}
	
	/**
	 * Column Info
	 * @return yyyy
	 */
	public String getYyyy() {
		return this.yyyy;
	}
	
	/**
	 * Column Info
	 * @return sumD4
	 */
	public String getSumD4() {
		return this.sumD4;
	}
	
	/**
	 * Column Info
	 * @return sumJik40
	 */
	public String getSumJik40() {
		return this.sumJik40;
	}
	
	/**
	 * Column Info
	 * @return sumD5
	 */
	public String getSumD5() {
		return this.sumD5;
	}
	
	/**
	 * Column Info
	 * @return sumD7
	 */
	public String getSumD7() {
		return this.sumD7;
	}
	
	/**
	 * Column Info
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return ts20
	 */
	public String getTs20() {
		return this.ts20;
	}
	
	/**
	 * Column Info
	 * @return totalSumR45
	 */
	public String getTotalSumR45() {
		return this.totalSumR45;
	}
	
	/**
	 * Column Info
	 * @return staffNm
	 */
	public String getStaffNm() {
		return this.staffNm;
	}
	
	/**
	 * Column Info
	 * @return totalSumJik40
	 */
	public String getTotalSumJik40() {
		return this.totalSumJik40;
	}
	
	/**
	 * Column Info
	 * @return totalSumD5
	 */
	public String getTotalSumD5() {
		return this.totalSumD5;
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
	 * @return totalSumO2
	 */
	public String getTotalSumO2() {
		return this.totalSumO2;
	}
	
	/**
	 * Column Info
	 * @return totalSumD7
	 */
	public String getTotalSumD7() {
		return this.totalSumD7;
	}
	
	/**
	 * Column Info
	 * @return totalSumO4
	 */
	public String getTotalSumO4() {
		return this.totalSumO4;
	}
	
	/**
	 * Column Info
	 * @return totalSumIbBl
	 */
	public String getTotalSumIbBl() {
		return this.totalSumIbBl;
	}
	
	/**
	 * Column Info
	 * @return sumIbBl
	 */
	public String getSumIbBl() {
		return this.sumIbBl;
	}
	
	/**
	 * Column Info
	 * @return totalSumD2
	 */
	public String getTotalSumD2() {
		return this.totalSumD2;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return totalSumD4
	 */
	public String getTotalSumD4() {
		return this.totalSumD4;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return jik20
	 */
	public String getJik20() {
		return this.jik20;
	}
	
	/**
	 * Column Info
	 * @return staffId
	 */
	public String getStaffId() {
		return this.staffId;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return weeks
	 */
	public String getWeeks() {
		return this.weeks;
	}
	
	/**
	 * Column Info
	 * @return ttl40
	 */
	public String getTtl40() {
		return this.ttl40;
	}
	
	/**
	 * Column Info
	 * @return totalSumTs20
	 */
	public String getTotalSumTs20() {
		return this.totalSumTs20;
	}
	
	/**
	 * Column Info
	 * @return sumR2
	 */
	public String getSumR2() {
		return this.sumR2;
	}
	
	/**
	 * Column Info
	 * @return totalSumR2
	 */
	public String getTotalSumR2() {
		return this.totalSumR2;
	}
	
	/**
	 * Column Info
	 * @return sumTtl40
	 */
	public String getSumTtl40() {
		return this.sumTtl40;
	}
	
	/**
	 * Column Info
	 * @return sumF2
	 */
	public String getSumF2() {
		return this.sumF2;
	}
	
	/**
	 * Column Info
	 * @return sumF4
	 */
	public String getSumF4() {
		return this.sumF4;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return sumTs40
	 */
	public String getSumTs40() {
		return this.sumTs40;
	}
	
	/**
	 * Column Info
	 * @return sumJik20
	 */
	public String getSumJik20() {
		return this.sumJik20;
	}
	
	/**
	 * Column Info
	 * @return totalSumTtl20
	 */
	public String getTotalSumTtl20() {
		return this.totalSumTtl20;
	}
	
	/**
	 * Column Info
	 * @return o5
	 */
	public String getO5() {
		return this.o5;
	}
	
	/**
	 * Column Info
	 * @return sumO5
	 */
	public String getSumO5() {
		return this.sumO5;
	}
	
	/**
	 * Column Info
	 * @return totalSumO5
	 */
	public String getTotalSumO5() {
		return this.totalSumO5;
	}
	

	/**
	 * Column Info
	 * @param totalSumTsBl
	 */
	public void setTotalSumTsBl(String totalSumTsBl) {
		this.totalSumTsBl = totalSumTsBl;
	}
	
	/**
	 * Column Info
	 * @param sumO4
	 */
	public void setSumO4(String sumO4) {
		this.sumO4 = sumO4;
	}
	
	/**
	 * Column Info
	 * @param totalSumJik20
	 */
	public void setTotalSumJik20(String totalSumJik20) {
		this.totalSumJik20 = totalSumJik20;
	}
	
	/**
	 * Column Info
	 * @param sumTs20
	 */
	public void setSumTs20(String sumTs20) {
		this.sumTs20 = sumTs20;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param duraCd
	 */
	public void setDuraCd(String duraCd) {
		this.duraCd = duraCd;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
	}
	
	/**
	 * Column Info
	 * @param sumR45
	 */
	public void setSumR45(String sumR45) {
		this.sumR45 = sumR45;
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
	 * @param vvdCd2
	 */
	public void setVvdCd2(String vvdCd2) {
		this.vvdCd2 = vvdCd2;
	}
	
	/**
	 * Column Info
	 * @param vvdCd1
	 */
	public void setVvdCd1(String vvdCd1) {
		this.vvdCd1 = vvdCd1;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}
	
	/**
	 * Column Info
	 * @param totalSumF4
	 */
	public void setTotalSumF4(String totalSumF4) {
		this.totalSumF4 = totalSumF4;
	}
	
	/**
	 * Column Info
	 * @param sumO2
	 */
	public void setSumO2(String sumO2) {
		this.sumO2 = sumO2;
	}
	
	/**
	 * Column Info
	 * @param ts40
	 */
	public void setTs40(String ts40) {
		this.ts40 = ts40;
	}
	
	/**
	 * Column Info
	 * @param totalSumF2
	 */
	public void setTotalSumF2(String totalSumF2) {
		this.totalSumF2 = totalSumF2;
	}
	
	/**
	 * Column Info
	 * @param podYardCd
	 */
	public void setPodYardCd(String podYardCd) {
		this.podYardCd = podYardCd;
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
	 * @param tsBl
	 */
	public void setTsBl(String tsBl) {
		this.tsBl = tsBl;
	}
	
	/**
	 * Column Info
	 * @param ttl20
	 */
	public void setTtl20(String ttl20) {
		this.ttl20 = ttl20;
	}
	
	/**
	 * Column Info
	 * @param totalSumT2
	 */
	public void setTotalSumT2(String totalSumT2) {
		this.totalSumT2 = totalSumT2;
	}
	
	/**
	 * Column Info
	 * @param r45
	 */
	public void setR45(String r45) {
		this.r45 = r45;
	}
	
	/**
	 * Column Info
	 * @param totalSumT4
	 */
	public void setTotalSumT4(String totalSumT4) {
		this.totalSumT4 = totalSumT4;
	}
	
	/**
	 * Column Info
	 * @param jik40
	 */
	public void setJik40(String jik40) {
		this.jik40 = jik40;
	}
	
	/**
	 * Column Info
	 * @param ataCd2
	 */
	public void setAtaCd2(String ataCd2) {
		this.ataCd2 = ataCd2;
	}
	
	/**
	 * Column Info
	 * @param ataCd1
	 */
	public void setAtaCd1(String ataCd1) {
		this.ataCd1 = ataCd1;
	}
	
	/**
	 * Column Info
	 * @param totalSumTs40
	 */
	public void setTotalSumTs40(String totalSumTs40) {
		this.totalSumTs40 = totalSumTs40;
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
	 * @param sumTsBl
	 */
	public void setSumTsBl(String sumTsBl) {
		this.sumTsBl = sumTsBl;
	}
	
	/**
	 * Column Info
	 * @param sumTtl20
	 */
	public void setSumTtl20(String sumTtl20) {
		this.sumTtl20 = sumTtl20;
	}
	
	/**
	 * Column Info
	 * @param sumT4
	 */
	public void setSumT4(String sumT4) {
		this.sumT4 = sumT4;
	}
	
	/**
	 * Column Info
	 * @param ibBl
	 */
	public void setIbBl(String ibBl) {
		this.ibBl = ibBl;
	}
	
	/**
	 * Column Info
	 * @param sumT2
	 */
	public void setSumT2(String sumT2) {
		this.sumT2 = sumT2;
	}
	
	/**
	 * Column Info
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param sumD2
	 */
	public void setSumD2(String sumD2) {
		this.sumD2 = sumD2;
	}
	
	/**
	 * Column Info
	 * @param totalSumTtl40
	 */
	public void setTotalSumTtl40(String totalSumTtl40) {
		this.totalSumTtl40 = totalSumTtl40;
	}
	
	/**
	 * Column Info
	 * @param yyyy
	 */
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	
	/**
	 * Column Info
	 * @param sumD4
	 */
	public void setSumD4(String sumD4) {
		this.sumD4 = sumD4;
	}
	
	/**
	 * Column Info
	 * @param sumJik40
	 */
	public void setSumJik40(String sumJik40) {
		this.sumJik40 = sumJik40;
	}
	
	/**
	 * Column Info
	 * @param sumD5
	 */
	public void setSumD5(String sumD5) {
		this.sumD5 = sumD5;
	}
	
	/**
	 * Column Info
	 * @param sumD7
	 */
	public void setSumD7(String sumD7) {
		this.sumD7 = sumD7;
	}
	
	/**
	 * Column Info
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param ts20
	 */
	public void setTs20(String ts20) {
		this.ts20 = ts20;
	}
	
	/**
	 * Column Info
	 * @param totalSumR45
	 */
	public void setTotalSumR45(String totalSumR45) {
		this.totalSumR45 = totalSumR45;
	}
	
	/**
	 * Column Info
	 * @param staffNm
	 */
	public void setStaffNm(String staffNm) {
		this.staffNm = staffNm;
	}
	
	/**
	 * Column Info
	 * @param totalSumJik40
	 */
	public void setTotalSumJik40(String totalSumJik40) {
		this.totalSumJik40 = totalSumJik40;
	}
	
	/**
	 * Column Info
	 * @param totalSumD5
	 */
	public void setTotalSumD5(String totalSumD5) {
		this.totalSumD5 = totalSumD5;
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
	 * @param totalSumO2
	 */
	public void setTotalSumO2(String totalSumO2) {
		this.totalSumO2 = totalSumO2;
	}
	
	/**
	 * Column Info
	 * @param totalSumD7
	 */
	public void setTotalSumD7(String totalSumD7) {
		this.totalSumD7 = totalSumD7;
	}
	
	/**
	 * Column Info
	 * @param totalSumO4
	 */
	public void setTotalSumO4(String totalSumO4) {
		this.totalSumO4 = totalSumO4;
	}
	
	/**
	 * Column Info
	 * @param totalSumIbBl
	 */
	public void setTotalSumIbBl(String totalSumIbBl) {
		this.totalSumIbBl = totalSumIbBl;
	}
	
	/**
	 * Column Info
	 * @param sumIbBl
	 */
	public void setSumIbBl(String sumIbBl) {
		this.sumIbBl = sumIbBl;
	}
	
	/**
	 * Column Info
	 * @param totalSumD2
	 */
	public void setTotalSumD2(String totalSumD2) {
		this.totalSumD2 = totalSumD2;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param totalSumD4
	 */
	public void setTotalSumD4(String totalSumD4) {
		this.totalSumD4 = totalSumD4;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param jik20
	 */
	public void setJik20(String jik20) {
		this.jik20 = jik20;
	}
	
	/**
	 * Column Info
	 * @param staffId
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param weeks
	 */
	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}
	
	/**
	 * Column Info
	 * @param ttl40
	 */
	public void setTtl40(String ttl40) {
		this.ttl40 = ttl40;
	}
	
	/**
	 * Column Info
	 * @param totalSumTs20
	 */
	public void setTotalSumTs20(String totalSumTs20) {
		this.totalSumTs20 = totalSumTs20;
	}
	
	/**
	 * Column Info
	 * @param sumR2
	 */
	public void setSumR2(String sumR2) {
		this.sumR2 = sumR2;
	}
	
	/**
	 * Column Info
	 * @param totalSumR2
	 */
	public void setTotalSumR2(String totalSumR2) {
		this.totalSumR2 = totalSumR2;
	}
	
	/**
	 * Column Info
	 * @param sumTtl40
	 */
	public void setSumTtl40(String sumTtl40) {
		this.sumTtl40 = sumTtl40;
	}
	
	/**
	 * Column Info
	 * @param sumF2
	 */
	public void setSumF2(String sumF2) {
		this.sumF2 = sumF2;
	}
	
	/**
	 * Column Info
	 * @param sumF4
	 */
	public void setSumF4(String sumF4) {
		this.sumF4 = sumF4;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param sumTs40
	 */
	public void setSumTs40(String sumTs40) {
		this.sumTs40 = sumTs40;
	}
	
	/**
	 * Column Info
	 * @param sumJik20
	 */
	public void setSumJik20(String sumJik20) {
		this.sumJik20 = sumJik20;
	}
	
	/**
	 * Column Info
	 * @param totalSumTtl20
	 */
	public void setTotalSumTtl20(String totalSumTtl20) {
		this.totalSumTtl20 = totalSumTtl20;
	}
	
	/**
	 * Column Info
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
	/**
	 * Column Info
	 * @param sumO5
	 */
	public void setSumO5(String sumO5) {
		this.sumO5 = sumO5;
	}
	
	/**
	 * Column Info
	 * @param totalSumO5
	 */
	public void setTotalSumO5(String totalSumO5) {
		this.totalSumO5 = totalSumO5;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotalSumTsBl(JSPUtil.getParameter(request, "total_sum_ts_bl", ""));
		setSumO4(JSPUtil.getParameter(request, "sum_o4", ""));
		setTotalSumJik20(JSPUtil.getParameter(request, "total_sum_jik20", ""));
		setSumTs20(JSPUtil.getParameter(request, "sum_ts20", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setDuraCd(JSPUtil.getParameter(request, "dura_cd", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setSumR45(JSPUtil.getParameter(request, "sum_r45", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdCd2(JSPUtil.getParameter(request, "vvd_cd2", ""));
		setVvdCd1(JSPUtil.getParameter(request, "vvd_cd1", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setTotalSumF4(JSPUtil.getParameter(request, "total_sum_f4", ""));
		setSumO2(JSPUtil.getParameter(request, "sum_o2", ""));
		setTs40(JSPUtil.getParameter(request, "ts40", ""));
		setTotalSumF2(JSPUtil.getParameter(request, "total_sum_f2", ""));
		setPodYardCd(JSPUtil.getParameter(request, "pod_yard_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setTsBl(JSPUtil.getParameter(request, "ts_bl", ""));
		setTtl20(JSPUtil.getParameter(request, "ttl20", ""));
		setTotalSumT2(JSPUtil.getParameter(request, "total_sum_t2", ""));
		setR45(JSPUtil.getParameter(request, "r45", ""));
		setTotalSumT4(JSPUtil.getParameter(request, "total_sum_t4", ""));
		setJik40(JSPUtil.getParameter(request, "jik40", ""));
		setAtaCd2(JSPUtil.getParameter(request, "ata_cd2", ""));
		setAtaCd1(JSPUtil.getParameter(request, "ata_cd1", ""));
		setTotalSumTs40(JSPUtil.getParameter(request, "total_sum_ts40", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSumTsBl(JSPUtil.getParameter(request, "sum_ts_bl", ""));
		setSumTtl20(JSPUtil.getParameter(request, "sum_ttl20", ""));
		setSumT4(JSPUtil.getParameter(request, "sum_t4", ""));
		setIbBl(JSPUtil.getParameter(request, "ib_bl", ""));
		setSumT2(JSPUtil.getParameter(request, "sum_t2", ""));
		setT4(JSPUtil.getParameter(request, "t4", ""));
		setSumD2(JSPUtil.getParameter(request, "sum_d2", ""));
		setTotalSumTtl40(JSPUtil.getParameter(request, "total_sum_ttl40", ""));
		setYyyy(JSPUtil.getParameter(request, "yyyy", ""));
		setSumD4(JSPUtil.getParameter(request, "sum_d4", ""));
		setSumJik40(JSPUtil.getParameter(request, "sum_jik40", ""));
		setSumD5(JSPUtil.getParameter(request, "sum_d5", ""));
		setSumD7(JSPUtil.getParameter(request, "sum_d7", ""));
		setT2(JSPUtil.getParameter(request, "t2", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setTs20(JSPUtil.getParameter(request, "ts20", ""));
		setTotalSumR45(JSPUtil.getParameter(request, "total_sum_r45", ""));
		setStaffNm(JSPUtil.getParameter(request, "staff_nm", ""));
		setTotalSumJik40(JSPUtil.getParameter(request, "total_sum_jik40", ""));
		setTotalSumD5(JSPUtil.getParameter(request, "total_sum_d5", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTotalSumO2(JSPUtil.getParameter(request, "total_sum_o2", ""));
		setTotalSumD7(JSPUtil.getParameter(request, "total_sum_d7", ""));
		setTotalSumO4(JSPUtil.getParameter(request, "total_sum_o4", ""));
		setTotalSumIbBl(JSPUtil.getParameter(request, "total_sum_ib_bl", ""));
		setSumIbBl(JSPUtil.getParameter(request, "sum_ib_bl", ""));
		setTotalSumD2(JSPUtil.getParameter(request, "total_sum_d2", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setTotalSumD4(JSPUtil.getParameter(request, "total_sum_d4", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setJik20(JSPUtil.getParameter(request, "jik20", ""));
		setStaffId(JSPUtil.getParameter(request, "staff_id", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setWeeks(JSPUtil.getParameter(request, "weeks", ""));
		setTtl40(JSPUtil.getParameter(request, "ttl40", ""));
		setTotalSumTs20(JSPUtil.getParameter(request, "total_sum_ts20", ""));
		setSumR2(JSPUtil.getParameter(request, "sum_r2", ""));
		setTotalSumR2(JSPUtil.getParameter(request, "total_sum_r2", ""));
		setSumTtl40(JSPUtil.getParameter(request, "sum_ttl40", ""));
		setSumF2(JSPUtil.getParameter(request, "sum_f2", ""));
		setSumF4(JSPUtil.getParameter(request, "sum_f4", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setSumTs40(JSPUtil.getParameter(request, "sum_ts40", ""));
		setSumJik20(JSPUtil.getParameter(request, "sum_jik20", ""));
		setTotalSumTtl20(JSPUtil.getParameter(request, "total_sum_ttl20", ""));
		setO5(JSPUtil.getParameter(request, "o5", ""));
		setSumO5(JSPUtil.getParameter(request, "sum_o5", ""));
		setTotalSumO5(JSPUtil.getParameter(request, "total_sum_o5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InBoundReportOutVO[]
	 */
	public InBoundReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InBoundReportOutVO[]
	 */
	public InBoundReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InBoundReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totalSumTsBl = (JSPUtil.getParameter(request, prefix	+ "total_sum_ts_bl", length));
			String[] sumO4 = (JSPUtil.getParameter(request, prefix	+ "sum_o4", length));
			String[] totalSumJik20 = (JSPUtil.getParameter(request, prefix	+ "total_sum_jik20", length));
			String[] sumTs20 = (JSPUtil.getParameter(request, prefix	+ "sum_ts20", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] duraCd = (JSPUtil.getParameter(request, prefix	+ "dura_cd", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] sumR45 = (JSPUtil.getParameter(request, prefix	+ "sum_r45", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCd2 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd2", length));
			String[] vvdCd1 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd1", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] totalSumF4 = (JSPUtil.getParameter(request, prefix	+ "total_sum_f4", length));
			String[] sumO2 = (JSPUtil.getParameter(request, prefix	+ "sum_o2", length));
			String[] ts40 = (JSPUtil.getParameter(request, prefix	+ "ts40", length));
			String[] totalSumF2 = (JSPUtil.getParameter(request, prefix	+ "total_sum_f2", length));
			String[] podYardCd = (JSPUtil.getParameter(request, prefix	+ "pod_yard_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] tsBl = (JSPUtil.getParameter(request, prefix	+ "ts_bl", length));
			String[] ttl20 = (JSPUtil.getParameter(request, prefix	+ "ttl20", length));
			String[] totalSumT2 = (JSPUtil.getParameter(request, prefix	+ "total_sum_t2", length));
			String[] r45 = (JSPUtil.getParameter(request, prefix	+ "r45", length));
			String[] totalSumT4 = (JSPUtil.getParameter(request, prefix	+ "total_sum_t4", length));
			String[] jik40 = (JSPUtil.getParameter(request, prefix	+ "jik40", length));
			String[] ataCd2 = (JSPUtil.getParameter(request, prefix	+ "ata_cd2", length));
			String[] ataCd1 = (JSPUtil.getParameter(request, prefix	+ "ata_cd1", length));
			String[] totalSumTs40 = (JSPUtil.getParameter(request, prefix	+ "total_sum_ts40", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] sumTsBl = (JSPUtil.getParameter(request, prefix	+ "sum_ts_bl", length));
			String[] sumTtl20 = (JSPUtil.getParameter(request, prefix	+ "sum_ttl20", length));
			String[] sumT4 = (JSPUtil.getParameter(request, prefix	+ "sum_t4", length));
			String[] ibBl = (JSPUtil.getParameter(request, prefix	+ "ib_bl", length));
			String[] sumT2 = (JSPUtil.getParameter(request, prefix	+ "sum_t2", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] sumD2 = (JSPUtil.getParameter(request, prefix	+ "sum_d2", length));
			String[] totalSumTtl40 = (JSPUtil.getParameter(request, prefix	+ "total_sum_ttl40", length));
			String[] yyyy = (JSPUtil.getParameter(request, prefix	+ "yyyy", length));
			String[] sumD4 = (JSPUtil.getParameter(request, prefix	+ "sum_d4", length));
			String[] sumJik40 = (JSPUtil.getParameter(request, prefix	+ "sum_jik40", length));
			String[] sumD5 = (JSPUtil.getParameter(request, prefix	+ "sum_d5", length));
			String[] sumD7 = (JSPUtil.getParameter(request, prefix	+ "sum_d7", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] ts20 = (JSPUtil.getParameter(request, prefix	+ "ts20", length));
			String[] totalSumR45 = (JSPUtil.getParameter(request, prefix	+ "total_sum_r45", length));
			String[] staffNm = (JSPUtil.getParameter(request, prefix	+ "staff_nm", length));
			String[] totalSumJik40 = (JSPUtil.getParameter(request, prefix	+ "total_sum_jik40", length));
			String[] totalSumD5 = (JSPUtil.getParameter(request, prefix	+ "total_sum_d5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalSumO2 = (JSPUtil.getParameter(request, prefix	+ "total_sum_o2", length));
			String[] totalSumD7 = (JSPUtil.getParameter(request, prefix	+ "total_sum_d7", length));
			String[] totalSumO4 = (JSPUtil.getParameter(request, prefix	+ "total_sum_o4", length));
			String[] totalSumIbBl = (JSPUtil.getParameter(request, prefix	+ "total_sum_ib_bl", length));
			String[] sumIbBl = (JSPUtil.getParameter(request, prefix	+ "sum_ib_bl", length));
			String[] totalSumD2 = (JSPUtil.getParameter(request, prefix	+ "total_sum_d2", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] totalSumD4 = (JSPUtil.getParameter(request, prefix	+ "total_sum_d4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] jik20 = (JSPUtil.getParameter(request, prefix	+ "jik20", length));
			String[] staffId = (JSPUtil.getParameter(request, prefix	+ "staff_id", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] weeks = (JSPUtil.getParameter(request, prefix	+ "weeks", length));
			String[] ttl40 = (JSPUtil.getParameter(request, prefix	+ "ttl40", length));
			String[] totalSumTs20 = (JSPUtil.getParameter(request, prefix	+ "total_sum_ts20", length));
			String[] sumR2 = (JSPUtil.getParameter(request, prefix	+ "sum_r2", length));
			String[] totalSumR2 = (JSPUtil.getParameter(request, prefix	+ "total_sum_r2", length));
			String[] sumTtl40 = (JSPUtil.getParameter(request, prefix	+ "sum_ttl40", length));
			String[] sumF2 = (JSPUtil.getParameter(request, prefix	+ "sum_f2", length));
			String[] sumF4 = (JSPUtil.getParameter(request, prefix	+ "sum_f4", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] sumTs40 = (JSPUtil.getParameter(request, prefix	+ "sum_ts40", length));
			String[] sumJik20 = (JSPUtil.getParameter(request, prefix	+ "sum_jik20", length));
			String[] totalSumTtl20 = (JSPUtil.getParameter(request, prefix	+ "total_sum_ttl20", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			String[] sumO5 = (JSPUtil.getParameter(request, prefix	+ "sum_o5", length));
			String[] totalSumO5 = (JSPUtil.getParameter(request, prefix	+ "total_sum_o5", length));
			
			for (int i = 0; i < length; i++) {
				model = new InBoundReportOutVO();
				if (totalSumTsBl[i] != null)
					model.setTotalSumTsBl(totalSumTsBl[i]);
				if (sumO4[i] != null)
					model.setSumO4(sumO4[i]);
				if (totalSumJik20[i] != null)
					model.setTotalSumJik20(totalSumJik20[i]);
				if (sumTs20[i] != null)
					model.setSumTs20(sumTs20[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (duraCd[i] != null)
					model.setDuraCd(duraCd[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (sumR45[i] != null)
					model.setSumR45(sumR45[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCd2[i] != null)
					model.setVvdCd2(vvdCd2[i]);
				if (vvdCd1[i] != null)
					model.setVvdCd1(vvdCd1[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (totalSumF4[i] != null)
					model.setTotalSumF4(totalSumF4[i]);
				if (sumO2[i] != null)
					model.setSumO2(sumO2[i]);
				if (ts40[i] != null)
					model.setTs40(ts40[i]);
				if (totalSumF2[i] != null)
					model.setTotalSumF2(totalSumF2[i]);
				if (podYardCd[i] != null)
					model.setPodYardCd(podYardCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (tsBl[i] != null)
					model.setTsBl(tsBl[i]);
				if (ttl20[i] != null)
					model.setTtl20(ttl20[i]);
				if (totalSumT2[i] != null)
					model.setTotalSumT2(totalSumT2[i]);
				if (r45[i] != null)
					model.setR45(r45[i]);
				if (totalSumT4[i] != null)
					model.setTotalSumT4(totalSumT4[i]);
				if (jik40[i] != null)
					model.setJik40(jik40[i]);
				if (ataCd2[i] != null)
					model.setAtaCd2(ataCd2[i]);
				if (ataCd1[i] != null)
					model.setAtaCd1(ataCd1[i]);
				if (totalSumTs40[i] != null)
					model.setTotalSumTs40(totalSumTs40[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (sumTsBl[i] != null)
					model.setSumTsBl(sumTsBl[i]);
				if (sumTtl20[i] != null)
					model.setSumTtl20(sumTtl20[i]);
				if (sumT4[i] != null)
					model.setSumT4(sumT4[i]);
				if (ibBl[i] != null)
					model.setIbBl(ibBl[i]);
				if (sumT2[i] != null)
					model.setSumT2(sumT2[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (sumD2[i] != null)
					model.setSumD2(sumD2[i]);
				if (totalSumTtl40[i] != null)
					model.setTotalSumTtl40(totalSumTtl40[i]);
				if (yyyy[i] != null)
					model.setYyyy(yyyy[i]);
				if (sumD4[i] != null)
					model.setSumD4(sumD4[i]);
				if (sumJik40[i] != null)
					model.setSumJik40(sumJik40[i]);
				if (sumD5[i] != null)
					model.setSumD5(sumD5[i]);
				if (sumD7[i] != null)
					model.setSumD7(sumD7[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (ts20[i] != null)
					model.setTs20(ts20[i]);
				if (totalSumR45[i] != null)
					model.setTotalSumR45(totalSumR45[i]);
				if (staffNm[i] != null)
					model.setStaffNm(staffNm[i]);
				if (totalSumJik40[i] != null)
					model.setTotalSumJik40(totalSumJik40[i]);
				if (totalSumD5[i] != null)
					model.setTotalSumD5(totalSumD5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalSumO2[i] != null)
					model.setTotalSumO2(totalSumO2[i]);
				if (totalSumD7[i] != null)
					model.setTotalSumD7(totalSumD7[i]);
				if (totalSumO4[i] != null)
					model.setTotalSumO4(totalSumO4[i]);
				if (totalSumIbBl[i] != null)
					model.setTotalSumIbBl(totalSumIbBl[i]);
				if (sumIbBl[i] != null)
					model.setSumIbBl(sumIbBl[i]);
				if (totalSumD2[i] != null)
					model.setTotalSumD2(totalSumD2[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (totalSumD4[i] != null)
					model.setTotalSumD4(totalSumD4[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (jik20[i] != null)
					model.setJik20(jik20[i]);
				if (staffId[i] != null)
					model.setStaffId(staffId[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (weeks[i] != null)
					model.setWeeks(weeks[i]);
				if (ttl40[i] != null)
					model.setTtl40(ttl40[i]);
				if (totalSumTs20[i] != null)
					model.setTotalSumTs20(totalSumTs20[i]);
				if (sumR2[i] != null)
					model.setSumR2(sumR2[i]);
				if (totalSumR2[i] != null)
					model.setTotalSumR2(totalSumR2[i]);
				if (sumTtl40[i] != null)
					model.setSumTtl40(sumTtl40[i]);
				if (sumF2[i] != null)
					model.setSumF2(sumF2[i]);
				if (sumF4[i] != null)
					model.setSumF4(sumF4[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (sumTs40[i] != null)
					model.setSumTs40(sumTs40[i]);
				if (sumJik20[i] != null)
					model.setSumJik20(sumJik20[i]);
				if (totalSumTtl20[i] != null)
					model.setTotalSumTtl20(totalSumTtl20[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				if (sumO5[i] != null)
					model.setSumO5(sumO5[i]);
				if (totalSumO5[i] != null)
					model.setTotalSumO5(totalSumO5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInBoundReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InBoundReportOutVO[]
	 */
	public InBoundReportOutVO[] getInBoundReportOutVOs(){
		InBoundReportOutVO[] vos = (InBoundReportOutVO[])models.toArray(new InBoundReportOutVO[models.size()]);
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
		this.totalSumTsBl = this.totalSumTsBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumO4 = this.sumO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumJik20 = this.totalSumJik20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTs20 = this.sumTs20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraCd = this.duraCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumR45 = this.sumR45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd2 = this.vvdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd1 = this.vvdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumF4 = this.totalSumF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumO2 = this.sumO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40 = this.ts40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumF2 = this.totalSumF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYardCd = this.podYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsBl = this.tsBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl20 = this.ttl20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumT2 = this.totalSumT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r45 = this.r45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumT4 = this.totalSumT4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jik40 = this.jik40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataCd2 = this.ataCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataCd1 = this.ataCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumTs40 = this.totalSumTs40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTsBl = this.sumTsBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtl20 = this.sumTtl20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumT4 = this.sumT4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBl = this.ibBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumT2 = this.sumT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD2 = this.sumD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumTtl40 = this.totalSumTtl40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyy = this.yyyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD4 = this.sumD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumJik40 = this.sumJik40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD5 = this.sumD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumD7 = this.sumD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20 = this.ts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumR45 = this.totalSumR45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.staffNm = this.staffNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumJik40 = this.totalSumJik40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumD5 = this.totalSumD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumO2 = this.totalSumO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumD7 = this.totalSumD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumO4 = this.totalSumO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumIbBl = this.totalSumIbBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumIbBl = this.sumIbBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumD2 = this.totalSumD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumD4 = this.totalSumD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jik20 = this.jik20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.staffId = this.staffId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weeks = this.weeks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl40 = this.ttl40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumTs20 = this.totalSumTs20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumR2 = this.sumR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumR2 = this.totalSumR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtl40 = this.sumTtl40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumF2 = this.sumF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumF4 = this.sumF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTs40 = this.sumTs40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumJik20 = this.sumJik20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumTtl20 = this.totalSumTtl20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumO5 = this.sumO5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumO5 = this.totalSumO5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
