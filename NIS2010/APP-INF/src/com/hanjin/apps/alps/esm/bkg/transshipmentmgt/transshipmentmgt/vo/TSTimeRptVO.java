/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TSTimeRptVO.java
*@FileTitle : TSTimeRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.27
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.01.27 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSTimeRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSTimeRptVO> models = new ArrayList<TSTimeRptVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String eventDate = null;
	/* Column Info */
	private String dtSeq = null;
	/* Column Info */
	private String count20 = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String pLane = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String count22 = null;
	/* Column Info */
	private String count21 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String count23 = null;
	/* Column Info */
	private String count24 = null;
	/* Column Info */
	private String count25 = null;
	/* Column Info */
	private String count26 = null;
	/* Column Info */
	private String inquiryLevel = null;
	/* Column Info */
	private String count27 = null;
	/* Column Info */
	private String count28 = null;
	/* Column Info */
	private String count29 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String count33 = null;
	/* Column Info */
	private String count32 = null;
	/* Column Info */
	private String count31 = null;
	/* Column Info */
	private String count30 = null;
	/* Column Info */
	private String pCompany = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String sDays = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String pPol = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String pSoc = null;
	/* Column Info */
	private String frmrLane = null;
	/* Column Info */
	private String count36 = null;
	/* Column Info */
	private String count37 = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String count34 = null;
	/* Column Info */
	private String count35 = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String count38 = null;
	/* Column Info */
	private String count39 = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String stayDay = null;
	/* Column Info */
	private String typeSize = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String count40 = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String count06 = null;
	/* Column Info */
	private String count05 = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String count08 = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String count07 = null;
	/* Column Info */
	private String count02 = null;
	/* Column Info */
	private String etdDate = null;
	/* Column Info */
	private String count01 = null;
	/* Column Info */
	private String pTypeSize = null;
	/* Column Info */
	private String count04 = null;
	/* Column Info */
	private String count03 = null;
	/* Column Info */
	private String subTrade = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String count09 = null;
	/* Column Info */
	private String frmrVvd = null;
	/* Column Info */
	private String tscntr = null;
	/* Column Info */
	private String formerVvd = null;
	/* Column Info */
	private String mv = null;
	/* Column Info */
	private String count10 = null;
	/* Column Info */
	private String count11 = null;
	/* Column Info */
	private String count19 = null;
	/* Column Info */
	private String count18 = null;
	/* Column Info */
	private String count17 = null;
	/* Column Info */
	private String count16 = null;
	/* Column Info */
	private String count15 = null;
	/* Column Info */
	private String nextLane = null;
	/* Column Info */
	private String count14 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String count13 = null;
	/* Column Info */
	private String count12 = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String cnNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSTimeRptVO() {}

	public TSTimeRptVO(String ibflag, String pagerows, String trade, String subTrade, String lane, String vvd, String division, String total, String dtSeq, String yardCd, String cntrNo, String sDays, String typeSize, String mv, String eventDate, String blNo, String pol, String nextPort, String pod, String formerVvd, String nextVvd, String etdDate, String count01, String count02, String count03, String count04, String count05, String count06, String count07, String count08, String count09, String count10, String count11, String count12, String count13, String count14, String count15, String count16, String count17, String count18, String count19, String count20, String count21, String count22, String count23, String count24, String count25, String count26, String count27, String count28, String count29, String count30, String count31, String count32, String count33, String count34, String count35, String count36, String count37, String count38, String count39, String count40, String podYdCd, String bkgNo, String stayDay, String cntrTpszCd, String cnmvStsCd, String eventDt, String polCd, String podCd, String frmrLane, String frmrVvd, String nextLane, String etd, String special, String shNm, String cnNm, String fromDt, String toDt, String pPol, String pLane, String pVvd, String pCompany, String pTypeSize, String pSoc, String location, String period, String tpsz, String rdtype, String tscntr, String soc, String inquiryLevel) {
		this.total = total;
		this.eventDate = eventDate;
		this.dtSeq = dtSeq;
		this.count20 = count20;
		this.location = location;
		this.pLane = pLane;
		this.etd = etd;
		this.count22 = count22;
		this.count21 = count21;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.eventDt = eventDt;
		this.polCd = polCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pol = pol;
		this.count23 = count23;
		this.count24 = count24;
		this.count25 = count25;
		this.count26 = count26;
		this.inquiryLevel = inquiryLevel;
		this.count27 = count27;
		this.count28 = count28;
		this.count29 = count29;
		this.pod = pod;
		this.nextPort = nextPort;
		this.pVvd = pVvd;
		this.count33 = count33;
		this.count32 = count32;
		this.count31 = count31;
		this.count30 = count30;
		this.pCompany = pCompany;
		this.period = period;
		this.sDays = sDays;
		this.toDt = toDt;
		this.podCd = podCd;
		this.vvd = vvd;
		this.pPol = pPol;
		this.bkgNo = bkgNo;
		this.tpsz = tpsz;
		this.yardCd = yardCd;
		this.pSoc = pSoc;
		this.frmrLane = frmrLane;
		this.count36 = count36;
		this.count37 = count37;
		this.nextVvd = nextVvd;
		this.count34 = count34;
		this.count35 = count35;
		this.soc = soc;
		this.count38 = count38;
		this.count39 = count39;
		this.fromDt = fromDt;
		this.stayDay = stayDay;
		this.typeSize = typeSize;
		this.trade = trade;
		this.count40 = count40;
		this.lane = lane;
		this.count06 = count06;
		this.count05 = count05;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.count08 = count08;
		this.division = division;
		this.count07 = count07;
		this.count02 = count02;
		this.etdDate = etdDate;
		this.count01 = count01;
		this.pTypeSize = pTypeSize;
		this.count04 = count04;
		this.count03 = count03;
		this.subTrade = subTrade;
		this.shNm = shNm;
		this.rdtype = rdtype;
		this.podYdCd = podYdCd;
		this.count09 = count09;
		this.frmrVvd = frmrVvd;
		this.tscntr = tscntr;
		this.formerVvd = formerVvd;
		this.mv = mv;
		this.count10 = count10;
		this.count11 = count11;
		this.count19 = count19;
		this.count18 = count18;
		this.count17 = count17;
		this.count16 = count16;
		this.count15 = count15;
		this.nextLane = nextLane;
		this.count14 = count14;
		this.cntrNo = cntrNo;
		this.count13 = count13;
		this.count12 = count12;
		this.special = special;
		this.cnNm = cnNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("event_date", getEventDate());
		this.hashColumns.put("dt_seq", getDtSeq());
		this.hashColumns.put("count20", getCount20());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("p_lane", getPLane());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("count22", getCount22());
		this.hashColumns.put("count21", getCount21());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("count23", getCount23());
		this.hashColumns.put("count24", getCount24());
		this.hashColumns.put("count25", getCount25());
		this.hashColumns.put("count26", getCount26());
		this.hashColumns.put("inquiry_level", getInquiryLevel());
		this.hashColumns.put("count27", getCount27());
		this.hashColumns.put("count28", getCount28());
		this.hashColumns.put("count29", getCount29());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("count33", getCount33());
		this.hashColumns.put("count32", getCount32());
		this.hashColumns.put("count31", getCount31());
		this.hashColumns.put("count30", getCount30());
		this.hashColumns.put("p_company", getPCompany());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("s_days", getSDays());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("p_pol", getPPol());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("p_soc", getPSoc());
		this.hashColumns.put("frmr_lane", getFrmrLane());
		this.hashColumns.put("count36", getCount36());
		this.hashColumns.put("count37", getCount37());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("count34", getCount34());
		this.hashColumns.put("count35", getCount35());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("count38", getCount38());
		this.hashColumns.put("count39", getCount39());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("stay_day", getStayDay());
		this.hashColumns.put("type_size", getTypeSize());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("count40", getCount40());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("count06", getCount06());
		this.hashColumns.put("count05", getCount05());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("count08", getCount08());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("count07", getCount07());
		this.hashColumns.put("count02", getCount02());
		this.hashColumns.put("etd_date", getEtdDate());
		this.hashColumns.put("count01", getCount01());
		this.hashColumns.put("p_type_size", getPTypeSize());
		this.hashColumns.put("count04", getCount04());
		this.hashColumns.put("count03", getCount03());
		this.hashColumns.put("sub_trade", getSubTrade());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("count09", getCount09());
		this.hashColumns.put("frmr_vvd", getFrmrVvd());
		this.hashColumns.put("tscntr", getTscntr());
		this.hashColumns.put("former_vvd", getFormerVvd());
		this.hashColumns.put("mv", getMv());
		this.hashColumns.put("count10", getCount10());
		this.hashColumns.put("count11", getCount11());
		this.hashColumns.put("count19", getCount19());
		this.hashColumns.put("count18", getCount18());
		this.hashColumns.put("count17", getCount17());
		this.hashColumns.put("count16", getCount16());
		this.hashColumns.put("count15", getCount15());
		this.hashColumns.put("next_lane", getNextLane());
		this.hashColumns.put("count14", getCount14());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("count13", getCount13());
		this.hashColumns.put("count12", getCount12());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("cn_nm", getCnNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("event_date", "eventDate");
		this.hashFields.put("dt_seq", "dtSeq");
		this.hashFields.put("count20", "count20");
		this.hashFields.put("location", "location");
		this.hashFields.put("p_lane", "pLane");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("count22", "count22");
		this.hashFields.put("count21", "count21");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("count23", "count23");
		this.hashFields.put("count24", "count24");
		this.hashFields.put("count25", "count25");
		this.hashFields.put("count26", "count26");
		this.hashFields.put("inquiry_level", "inquiryLevel");
		this.hashFields.put("count27", "count27");
		this.hashFields.put("count28", "count28");
		this.hashFields.put("count29", "count29");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("count33", "count33");
		this.hashFields.put("count32", "count32");
		this.hashFields.put("count31", "count31");
		this.hashFields.put("count30", "count30");
		this.hashFields.put("p_company", "pCompany");
		this.hashFields.put("period", "period");
		this.hashFields.put("s_days", "sDays");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("p_pol", "pPol");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("p_soc", "pSoc");
		this.hashFields.put("frmr_lane", "frmrLane");
		this.hashFields.put("count36", "count36");
		this.hashFields.put("count37", "count37");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("count34", "count34");
		this.hashFields.put("count35", "count35");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("count38", "count38");
		this.hashFields.put("count39", "count39");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("stay_day", "stayDay");
		this.hashFields.put("type_size", "typeSize");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("count40", "count40");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("count06", "count06");
		this.hashFields.put("count05", "count05");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("count08", "count08");
		this.hashFields.put("division", "division");
		this.hashFields.put("count07", "count07");
		this.hashFields.put("count02", "count02");
		this.hashFields.put("etd_date", "etdDate");
		this.hashFields.put("count01", "count01");
		this.hashFields.put("p_type_size", "pTypeSize");
		this.hashFields.put("count04", "count04");
		this.hashFields.put("count03", "count03");
		this.hashFields.put("sub_trade", "subTrade");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("count09", "count09");
		this.hashFields.put("frmr_vvd", "frmrVvd");
		this.hashFields.put("tscntr", "tscntr");
		this.hashFields.put("former_vvd", "formerVvd");
		this.hashFields.put("mv", "mv");
		this.hashFields.put("count10", "count10");
		this.hashFields.put("count11", "count11");
		this.hashFields.put("count19", "count19");
		this.hashFields.put("count18", "count18");
		this.hashFields.put("count17", "count17");
		this.hashFields.put("count16", "count16");
		this.hashFields.put("count15", "count15");
		this.hashFields.put("next_lane", "nextLane");
		this.hashFields.put("count14", "count14");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("count13", "count13");
		this.hashFields.put("count12", "count12");
		this.hashFields.put("special", "special");
		this.hashFields.put("cn_nm", "cnNm");
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
	 * @return eventDate
	 */
	public String getEventDate() {
		return this.eventDate;
	}
	
	/**
	 * Column Info
	 * @return dtSeq
	 */
	public String getDtSeq() {
		return this.dtSeq;
	}
	
	/**
	 * Column Info
	 * @return count20
	 */
	public String getCount20() {
		return this.count20;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return pLane
	 */
	public String getPLane() {
		return this.pLane;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return count22
	 */
	public String getCount22() {
		return this.count22;
	}
	
	/**
	 * Column Info
	 * @return count21
	 */
	public String getCount21() {
		return this.count21;
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
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return count23
	 */
	public String getCount23() {
		return this.count23;
	}
	
	/**
	 * Column Info
	 * @return count24
	 */
	public String getCount24() {
		return this.count24;
	}
	
	/**
	 * Column Info
	 * @return count25
	 */
	public String getCount25() {
		return this.count25;
	}
	
	/**
	 * Column Info
	 * @return count26
	 */
	public String getCount26() {
		return this.count26;
	}
	
	/**
	 * Column Info
	 * @return inquiryLevel
	 */
	public String getInquiryLevel() {
		return this.inquiryLevel;
	}
	
	/**
	 * Column Info
	 * @return count27
	 */
	public String getCount27() {
		return this.count27;
	}
	
	/**
	 * Column Info
	 * @return count28
	 */
	public String getCount28() {
		return this.count28;
	}
	
	/**
	 * Column Info
	 * @return count29
	 */
	public String getCount29() {
		return this.count29;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return count33
	 */
	public String getCount33() {
		return this.count33;
	}
	
	/**
	 * Column Info
	 * @return count32
	 */
	public String getCount32() {
		return this.count32;
	}
	
	/**
	 * Column Info
	 * @return count31
	 */
	public String getCount31() {
		return this.count31;
	}
	
	/**
	 * Column Info
	 * @return count30
	 */
	public String getCount30() {
		return this.count30;
	}
	
	/**
	 * Column Info
	 * @return pCompany
	 */
	public String getPCompany() {
		return this.pCompany;
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
	 * @return sDays
	 */
	public String getSDays() {
		return this.sDays;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return pPol
	 */
	public String getPPol() {
		return this.pPol;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
	}
	
	/**
	 * Column Info
	 * @return pSoc
	 */
	public String getPSoc() {
		return this.pSoc;
	}
	
	/**
	 * Column Info
	 * @return frmrLane
	 */
	public String getFrmrLane() {
		return this.frmrLane;
	}
	
	/**
	 * Column Info
	 * @return count36
	 */
	public String getCount36() {
		return this.count36;
	}
	
	/**
	 * Column Info
	 * @return count37
	 */
	public String getCount37() {
		return this.count37;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return count34
	 */
	public String getCount34() {
		return this.count34;
	}
	
	/**
	 * Column Info
	 * @return count35
	 */
	public String getCount35() {
		return this.count35;
	}
	
	/**
	 * Column Info
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}
	
	/**
	 * Column Info
	 * @return count38
	 */
	public String getCount38() {
		return this.count38;
	}
	
	/**
	 * Column Info
	 * @return count39
	 */
	public String getCount39() {
		return this.count39;
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
	 * @return stayDay
	 */
	public String getStayDay() {
		return this.stayDay;
	}
	
	/**
	 * Column Info
	 * @return typeSize
	 */
	public String getTypeSize() {
		return this.typeSize;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return count40
	 */
	public String getCount40() {
		return this.count40;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return count06
	 */
	public String getCount06() {
		return this.count06;
	}
	
	/**
	 * Column Info
	 * @return count05
	 */
	public String getCount05() {
		return this.count05;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return count08
	 */
	public String getCount08() {
		return this.count08;
	}
	
	/**
	 * Column Info
	 * @return division
	 */
	public String getDivision() {
		return this.division;
	}
	
	/**
	 * Column Info
	 * @return count07
	 */
	public String getCount07() {
		return this.count07;
	}
	
	/**
	 * Column Info
	 * @return count02
	 */
	public String getCount02() {
		return this.count02;
	}
	
	/**
	 * Column Info
	 * @return etdDate
	 */
	public String getEtdDate() {
		return this.etdDate;
	}
	
	/**
	 * Column Info
	 * @return count01
	 */
	public String getCount01() {
		return this.count01;
	}
	
	/**
	 * Column Info
	 * @return pTypeSize
	 */
	public String getPTypeSize() {
		return this.pTypeSize;
	}
	
	/**
	 * Column Info
	 * @return count04
	 */
	public String getCount04() {
		return this.count04;
	}
	
	/**
	 * Column Info
	 * @return count03
	 */
	public String getCount03() {
		return this.count03;
	}
	
	/**
	 * Column Info
	 * @return subTrade
	 */
	public String getSubTrade() {
		return this.subTrade;
	}
	
	/**
	 * Column Info
	 * @return shNm
	 */
	public String getShNm() {
		return this.shNm;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return count09
	 */
	public String getCount09() {
		return this.count09;
	}
	
	/**
	 * Column Info
	 * @return frmrVvd
	 */
	public String getFrmrVvd() {
		return this.frmrVvd;
	}
	
	/**
	 * Column Info
	 * @return tscntr
	 */
	public String getTscntr() {
		return this.tscntr;
	}
	
	/**
	 * Column Info
	 * @return formerVvd
	 */
	public String getFormerVvd() {
		return this.formerVvd;
	}
	
	/**
	 * Column Info
	 * @return mv
	 */
	public String getMv() {
		return this.mv;
	}
	
	/**
	 * Column Info
	 * @return count10
	 */
	public String getCount10() {
		return this.count10;
	}
	
	/**
	 * Column Info
	 * @return count11
	 */
	public String getCount11() {
		return this.count11;
	}
	
	/**
	 * Column Info
	 * @return count19
	 */
	public String getCount19() {
		return this.count19;
	}
	
	/**
	 * Column Info
	 * @return count18
	 */
	public String getCount18() {
		return this.count18;
	}
	
	/**
	 * Column Info
	 * @return count17
	 */
	public String getCount17() {
		return this.count17;
	}
	
	/**
	 * Column Info
	 * @return count16
	 */
	public String getCount16() {
		return this.count16;
	}
	
	/**
	 * Column Info
	 * @return count15
	 */
	public String getCount15() {
		return this.count15;
	}
	
	/**
	 * Column Info
	 * @return nextLane
	 */
	public String getNextLane() {
		return this.nextLane;
	}
	
	/**
	 * Column Info
	 * @return count14
	 */
	public String getCount14() {
		return this.count14;
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
	 * @return count13
	 */
	public String getCount13() {
		return this.count13;
	}
	
	/**
	 * Column Info
	 * @return count12
	 */
	public String getCount12() {
		return this.count12;
	}
	
	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}
	
	/**
	 * Column Info
	 * @return cnNm
	 */
	public String getCnNm() {
		return this.cnNm;
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
	 * @param eventDate
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	/**
	 * Column Info
	 * @param dtSeq
	 */
	public void setDtSeq(String dtSeq) {
		this.dtSeq = dtSeq;
	}
	
	/**
	 * Column Info
	 * @param count20
	 */
	public void setCount20(String count20) {
		this.count20 = count20;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param pLane
	 */
	public void setPLane(String pLane) {
		this.pLane = pLane;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param count22
	 */
	public void setCount22(String count22) {
		this.count22 = count22;
	}
	
	/**
	 * Column Info
	 * @param count21
	 */
	public void setCount21(String count21) {
		this.count21 = count21;
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
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param count23
	 */
	public void setCount23(String count23) {
		this.count23 = count23;
	}
	
	/**
	 * Column Info
	 * @param count24
	 */
	public void setCount24(String count24) {
		this.count24 = count24;
	}
	
	/**
	 * Column Info
	 * @param count25
	 */
	public void setCount25(String count25) {
		this.count25 = count25;
	}
	
	/**
	 * Column Info
	 * @param count26
	 */
	public void setCount26(String count26) {
		this.count26 = count26;
	}
	
	/**
	 * Column Info
	 * @param inquiryLevel
	 */
	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}
	
	/**
	 * Column Info
	 * @param count27
	 */
	public void setCount27(String count27) {
		this.count27 = count27;
	}
	
	/**
	 * Column Info
	 * @param count28
	 */
	public void setCount28(String count28) {
		this.count28 = count28;
	}
	
	/**
	 * Column Info
	 * @param count29
	 */
	public void setCount29(String count29) {
		this.count29 = count29;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param count33
	 */
	public void setCount33(String count33) {
		this.count33 = count33;
	}
	
	/**
	 * Column Info
	 * @param count32
	 */
	public void setCount32(String count32) {
		this.count32 = count32;
	}
	
	/**
	 * Column Info
	 * @param count31
	 */
	public void setCount31(String count31) {
		this.count31 = count31;
	}
	
	/**
	 * Column Info
	 * @param count30
	 */
	public void setCount30(String count30) {
		this.count30 = count30;
	}
	
	/**
	 * Column Info
	 * @param pCompany
	 */
	public void setPCompany(String pCompany) {
		this.pCompany = pCompany;
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
	 * @param sDays
	 */
	public void setSDays(String sDays) {
		this.sDays = sDays;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param pPol
	 */
	public void setPPol(String pPol) {
		this.pPol = pPol;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	
	/**
	 * Column Info
	 * @param pSoc
	 */
	public void setPSoc(String pSoc) {
		this.pSoc = pSoc;
	}
	
	/**
	 * Column Info
	 * @param frmrLane
	 */
	public void setFrmrLane(String frmrLane) {
		this.frmrLane = frmrLane;
	}
	
	/**
	 * Column Info
	 * @param count36
	 */
	public void setCount36(String count36) {
		this.count36 = count36;
	}
	
	/**
	 * Column Info
	 * @param count37
	 */
	public void setCount37(String count37) {
		this.count37 = count37;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param count34
	 */
	public void setCount34(String count34) {
		this.count34 = count34;
	}
	
	/**
	 * Column Info
	 * @param count35
	 */
	public void setCount35(String count35) {
		this.count35 = count35;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * Column Info
	 * @param count38
	 */
	public void setCount38(String count38) {
		this.count38 = count38;
	}
	
	/**
	 * Column Info
	 * @param count39
	 */
	public void setCount39(String count39) {
		this.count39 = count39;
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
	 * @param stayDay
	 */
	public void setStayDay(String stayDay) {
		this.stayDay = stayDay;
	}
	
	/**
	 * Column Info
	 * @param typeSize
	 */
	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param count40
	 */
	public void setCount40(String count40) {
		this.count40 = count40;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param count06
	 */
	public void setCount06(String count06) {
		this.count06 = count06;
	}
	
	/**
	 * Column Info
	 * @param count05
	 */
	public void setCount05(String count05) {
		this.count05 = count05;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param count08
	 */
	public void setCount08(String count08) {
		this.count08 = count08;
	}
	
	/**
	 * Column Info
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Column Info
	 * @param count07
	 */
	public void setCount07(String count07) {
		this.count07 = count07;
	}
	
	/**
	 * Column Info
	 * @param count02
	 */
	public void setCount02(String count02) {
		this.count02 = count02;
	}
	
	/**
	 * Column Info
	 * @param etdDate
	 */
	public void setEtdDate(String etdDate) {
		this.etdDate = etdDate;
	}
	
	/**
	 * Column Info
	 * @param count01
	 */
	public void setCount01(String count01) {
		this.count01 = count01;
	}
	
	/**
	 * Column Info
	 * @param pTypeSize
	 */
	public void setPTypeSize(String pTypeSize) {
		this.pTypeSize = pTypeSize;
	}
	
	/**
	 * Column Info
	 * @param count04
	 */
	public void setCount04(String count04) {
		this.count04 = count04;
	}
	
	/**
	 * Column Info
	 * @param count03
	 */
	public void setCount03(String count03) {
		this.count03 = count03;
	}
	
	/**
	 * Column Info
	 * @param subTrade
	 */
	public void setSubTrade(String subTrade) {
		this.subTrade = subTrade;
	}
	
	/**
	 * Column Info
	 * @param shNm
	 */
	public void setShNm(String shNm) {
		this.shNm = shNm;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param count09
	 */
	public void setCount09(String count09) {
		this.count09 = count09;
	}
	
	/**
	 * Column Info
	 * @param frmrVvd
	 */
	public void setFrmrVvd(String frmrVvd) {
		this.frmrVvd = frmrVvd;
	}
	
	/**
	 * Column Info
	 * @param tscntr
	 */
	public void setTscntr(String tscntr) {
		this.tscntr = tscntr;
	}
	
	/**
	 * Column Info
	 * @param formerVvd
	 */
	public void setFormerVvd(String formerVvd) {
		this.formerVvd = formerVvd;
	}
	
	/**
	 * Column Info
	 * @param mv
	 */
	public void setMv(String mv) {
		this.mv = mv;
	}
	
	/**
	 * Column Info
	 * @param count10
	 */
	public void setCount10(String count10) {
		this.count10 = count10;
	}
	
	/**
	 * Column Info
	 * @param count11
	 */
	public void setCount11(String count11) {
		this.count11 = count11;
	}
	
	/**
	 * Column Info
	 * @param count19
	 */
	public void setCount19(String count19) {
		this.count19 = count19;
	}
	
	/**
	 * Column Info
	 * @param count18
	 */
	public void setCount18(String count18) {
		this.count18 = count18;
	}
	
	/**
	 * Column Info
	 * @param count17
	 */
	public void setCount17(String count17) {
		this.count17 = count17;
	}
	
	/**
	 * Column Info
	 * @param count16
	 */
	public void setCount16(String count16) {
		this.count16 = count16;
	}
	
	/**
	 * Column Info
	 * @param count15
	 */
	public void setCount15(String count15) {
		this.count15 = count15;
	}
	
	/**
	 * Column Info
	 * @param nextLane
	 */
	public void setNextLane(String nextLane) {
		this.nextLane = nextLane;
	}
	
	/**
	 * Column Info
	 * @param count14
	 */
	public void setCount14(String count14) {
		this.count14 = count14;
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
	 * @param count13
	 */
	public void setCount13(String count13) {
		this.count13 = count13;
	}
	
	/**
	 * Column Info
	 * @param count12
	 */
	public void setCount12(String count12) {
		this.count12 = count12;
	}
	
	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	/**
	 * Column Info
	 * @param cnNm
	 */
	public void setCnNm(String cnNm) {
		this.cnNm = cnNm;
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
		setEventDate(JSPUtil.getParameter(request, prefix + "event_date", ""));
		setDtSeq(JSPUtil.getParameter(request, prefix + "dt_seq", ""));
		setCount20(JSPUtil.getParameter(request, prefix + "count20", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setPLane(JSPUtil.getParameter(request, prefix + "p_lane", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setCount22(JSPUtil.getParameter(request, prefix + "count22", ""));
		setCount21(JSPUtil.getParameter(request, prefix + "count21", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setCount23(JSPUtil.getParameter(request, prefix + "count23", ""));
		setCount24(JSPUtil.getParameter(request, prefix + "count24", ""));
		setCount25(JSPUtil.getParameter(request, prefix + "count25", ""));
		setCount26(JSPUtil.getParameter(request, prefix + "count26", ""));
		setInquiryLevel(JSPUtil.getParameter(request, prefix + "inquiry_level", ""));
		setCount27(JSPUtil.getParameter(request, prefix + "count27", ""));
		setCount28(JSPUtil.getParameter(request, prefix + "count28", ""));
		setCount29(JSPUtil.getParameter(request, prefix + "count29", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setNextPort(JSPUtil.getParameter(request, prefix + "next_port", ""));
		setPVvd(JSPUtil.getParameter(request, prefix + "p_vvd", ""));
		setCount33(JSPUtil.getParameter(request, prefix + "count33", ""));
		setCount32(JSPUtil.getParameter(request, prefix + "count32", ""));
		setCount31(JSPUtil.getParameter(request, prefix + "count31", ""));
		setCount30(JSPUtil.getParameter(request, prefix + "count30", ""));
		setPCompany(JSPUtil.getParameter(request, prefix + "p_company", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setSDays(JSPUtil.getParameter(request, prefix + "s_days", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPPol(JSPUtil.getParameter(request, prefix + "p_pol", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setPSoc(JSPUtil.getParameter(request, prefix + "p_soc", ""));
		setFrmrLane(JSPUtil.getParameter(request, prefix + "frmr_lane", ""));
		setCount36(JSPUtil.getParameter(request, prefix + "count36", ""));
		setCount37(JSPUtil.getParameter(request, prefix + "count37", ""));
		setNextVvd(JSPUtil.getParameter(request, prefix + "next_vvd", ""));
		setCount34(JSPUtil.getParameter(request, prefix + "count34", ""));
		setCount35(JSPUtil.getParameter(request, prefix + "count35", ""));
		setSoc(JSPUtil.getParameter(request, prefix + "soc", ""));
		setCount38(JSPUtil.getParameter(request, prefix + "count38", ""));
		setCount39(JSPUtil.getParameter(request, prefix + "count39", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setStayDay(JSPUtil.getParameter(request, prefix + "stay_day", ""));
		setTypeSize(JSPUtil.getParameter(request, prefix + "type_size", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setCount40(JSPUtil.getParameter(request, prefix + "count40", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setCount06(JSPUtil.getParameter(request, prefix + "count06", ""));
		setCount05(JSPUtil.getParameter(request, prefix + "count05", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCount08(JSPUtil.getParameter(request, prefix + "count08", ""));
		setDivision(JSPUtil.getParameter(request, prefix + "division", ""));
		setCount07(JSPUtil.getParameter(request, prefix + "count07", ""));
		setCount02(JSPUtil.getParameter(request, prefix + "count02", ""));
		setEtdDate(JSPUtil.getParameter(request, prefix + "etd_date", ""));
		setCount01(JSPUtil.getParameter(request, prefix + "count01", ""));
		setPTypeSize(JSPUtil.getParameter(request, prefix + "p_type_size", ""));
		setCount04(JSPUtil.getParameter(request, prefix + "count04", ""));
		setCount03(JSPUtil.getParameter(request, prefix + "count03", ""));
		setSubTrade(JSPUtil.getParameter(request, prefix + "sub_trade", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setRdtype(JSPUtil.getParameter(request, prefix + "rdtype", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setCount09(JSPUtil.getParameter(request, prefix + "count09", ""));
		setFrmrVvd(JSPUtil.getParameter(request, prefix + "frmr_vvd", ""));
		setTscntr(JSPUtil.getParameter(request, prefix + "tscntr", ""));
		setFormerVvd(JSPUtil.getParameter(request, prefix + "former_vvd", ""));
		setMv(JSPUtil.getParameter(request, prefix + "mv", ""));
		setCount10(JSPUtil.getParameter(request, prefix + "count10", ""));
		setCount11(JSPUtil.getParameter(request, prefix + "count11", ""));
		setCount19(JSPUtil.getParameter(request, prefix + "count19", ""));
		setCount18(JSPUtil.getParameter(request, prefix + "count18", ""));
		setCount17(JSPUtil.getParameter(request, prefix + "count17", ""));
		setCount16(JSPUtil.getParameter(request, prefix + "count16", ""));
		setCount15(JSPUtil.getParameter(request, prefix + "count15", ""));
		setNextLane(JSPUtil.getParameter(request, prefix + "next_lane", ""));
		setCount14(JSPUtil.getParameter(request, prefix + "count14", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCount13(JSPUtil.getParameter(request, prefix + "count13", ""));
		setCount12(JSPUtil.getParameter(request, prefix + "count12", ""));
		setSpecial(JSPUtil.getParameter(request, prefix + "special", ""));
		setCnNm(JSPUtil.getParameter(request, prefix + "cn_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSTimeRptVO[]
	 */
	public TSTimeRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSTimeRptVO[]
	 */
	public TSTimeRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSTimeRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] eventDate = (JSPUtil.getParameter(request, prefix	+ "event_date", length));
			String[] dtSeq = (JSPUtil.getParameter(request, prefix	+ "dt_seq", length));
			String[] count20 = (JSPUtil.getParameter(request, prefix	+ "count20", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] pLane = (JSPUtil.getParameter(request, prefix	+ "p_lane", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] count22 = (JSPUtil.getParameter(request, prefix	+ "count22", length));
			String[] count21 = (JSPUtil.getParameter(request, prefix	+ "count21", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] count23 = (JSPUtil.getParameter(request, prefix	+ "count23", length));
			String[] count24 = (JSPUtil.getParameter(request, prefix	+ "count24", length));
			String[] count25 = (JSPUtil.getParameter(request, prefix	+ "count25", length));
			String[] count26 = (JSPUtil.getParameter(request, prefix	+ "count26", length));
			String[] inquiryLevel = (JSPUtil.getParameter(request, prefix	+ "inquiry_level", length));
			String[] count27 = (JSPUtil.getParameter(request, prefix	+ "count27", length));
			String[] count28 = (JSPUtil.getParameter(request, prefix	+ "count28", length));
			String[] count29 = (JSPUtil.getParameter(request, prefix	+ "count29", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] count33 = (JSPUtil.getParameter(request, prefix	+ "count33", length));
			String[] count32 = (JSPUtil.getParameter(request, prefix	+ "count32", length));
			String[] count31 = (JSPUtil.getParameter(request, prefix	+ "count31", length));
			String[] count30 = (JSPUtil.getParameter(request, prefix	+ "count30", length));
			String[] pCompany = (JSPUtil.getParameter(request, prefix	+ "p_company", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] sDays = (JSPUtil.getParameter(request, prefix	+ "s_days", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] pPol = (JSPUtil.getParameter(request, prefix	+ "p_pol", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] pSoc = (JSPUtil.getParameter(request, prefix	+ "p_soc", length));
			String[] frmrLane = (JSPUtil.getParameter(request, prefix	+ "frmr_lane", length));
			String[] count36 = (JSPUtil.getParameter(request, prefix	+ "count36", length));
			String[] count37 = (JSPUtil.getParameter(request, prefix	+ "count37", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] count34 = (JSPUtil.getParameter(request, prefix	+ "count34", length));
			String[] count35 = (JSPUtil.getParameter(request, prefix	+ "count35", length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc", length));
			String[] count38 = (JSPUtil.getParameter(request, prefix	+ "count38", length));
			String[] count39 = (JSPUtil.getParameter(request, prefix	+ "count39", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] stayDay = (JSPUtil.getParameter(request, prefix	+ "stay_day", length));
			String[] typeSize = (JSPUtil.getParameter(request, prefix	+ "type_size", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] count40 = (JSPUtil.getParameter(request, prefix	+ "count40", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] count06 = (JSPUtil.getParameter(request, prefix	+ "count06", length));
			String[] count05 = (JSPUtil.getParameter(request, prefix	+ "count05", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] count08 = (JSPUtil.getParameter(request, prefix	+ "count08", length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division", length));
			String[] count07 = (JSPUtil.getParameter(request, prefix	+ "count07", length));
			String[] count02 = (JSPUtil.getParameter(request, prefix	+ "count02", length));
			String[] etdDate = (JSPUtil.getParameter(request, prefix	+ "etd_date", length));
			String[] count01 = (JSPUtil.getParameter(request, prefix	+ "count01", length));
			String[] pTypeSize = (JSPUtil.getParameter(request, prefix	+ "p_type_size", length));
			String[] count04 = (JSPUtil.getParameter(request, prefix	+ "count04", length));
			String[] count03 = (JSPUtil.getParameter(request, prefix	+ "count03", length));
			String[] subTrade = (JSPUtil.getParameter(request, prefix	+ "sub_trade", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] count09 = (JSPUtil.getParameter(request, prefix	+ "count09", length));
			String[] frmrVvd = (JSPUtil.getParameter(request, prefix	+ "frmr_vvd", length));
			String[] tscntr = (JSPUtil.getParameter(request, prefix	+ "tscntr", length));
			String[] formerVvd = (JSPUtil.getParameter(request, prefix	+ "former_vvd", length));
			String[] mv = (JSPUtil.getParameter(request, prefix	+ "mv", length));
			String[] count10 = (JSPUtil.getParameter(request, prefix	+ "count10", length));
			String[] count11 = (JSPUtil.getParameter(request, prefix	+ "count11", length));
			String[] count19 = (JSPUtil.getParameter(request, prefix	+ "count19", length));
			String[] count18 = (JSPUtil.getParameter(request, prefix	+ "count18", length));
			String[] count17 = (JSPUtil.getParameter(request, prefix	+ "count17", length));
			String[] count16 = (JSPUtil.getParameter(request, prefix	+ "count16", length));
			String[] count15 = (JSPUtil.getParameter(request, prefix	+ "count15", length));
			String[] nextLane = (JSPUtil.getParameter(request, prefix	+ "next_lane", length));
			String[] count14 = (JSPUtil.getParameter(request, prefix	+ "count14", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] count13 = (JSPUtil.getParameter(request, prefix	+ "count13", length));
			String[] count12 = (JSPUtil.getParameter(request, prefix	+ "count12", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] cnNm = (JSPUtil.getParameter(request, prefix	+ "cn_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new TSTimeRptVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (eventDate[i] != null)
					model.setEventDate(eventDate[i]);
				if (dtSeq[i] != null)
					model.setDtSeq(dtSeq[i]);
				if (count20[i] != null)
					model.setCount20(count20[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (pLane[i] != null)
					model.setPLane(pLane[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (count22[i] != null)
					model.setCount22(count22[i]);
				if (count21[i] != null)
					model.setCount21(count21[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (count23[i] != null)
					model.setCount23(count23[i]);
				if (count24[i] != null)
					model.setCount24(count24[i]);
				if (count25[i] != null)
					model.setCount25(count25[i]);
				if (count26[i] != null)
					model.setCount26(count26[i]);
				if (inquiryLevel[i] != null)
					model.setInquiryLevel(inquiryLevel[i]);
				if (count27[i] != null)
					model.setCount27(count27[i]);
				if (count28[i] != null)
					model.setCount28(count28[i]);
				if (count29[i] != null)
					model.setCount29(count29[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (count33[i] != null)
					model.setCount33(count33[i]);
				if (count32[i] != null)
					model.setCount32(count32[i]);
				if (count31[i] != null)
					model.setCount31(count31[i]);
				if (count30[i] != null)
					model.setCount30(count30[i]);
				if (pCompany[i] != null)
					model.setPCompany(pCompany[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (sDays[i] != null)
					model.setSDays(sDays[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pPol[i] != null)
					model.setPPol(pPol[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (pSoc[i] != null)
					model.setPSoc(pSoc[i]);
				if (frmrLane[i] != null)
					model.setFrmrLane(frmrLane[i]);
				if (count36[i] != null)
					model.setCount36(count36[i]);
				if (count37[i] != null)
					model.setCount37(count37[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (count34[i] != null)
					model.setCount34(count34[i]);
				if (count35[i] != null)
					model.setCount35(count35[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (count38[i] != null)
					model.setCount38(count38[i]);
				if (count39[i] != null)
					model.setCount39(count39[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (stayDay[i] != null)
					model.setStayDay(stayDay[i]);
				if (typeSize[i] != null)
					model.setTypeSize(typeSize[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (count40[i] != null)
					model.setCount40(count40[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (count06[i] != null)
					model.setCount06(count06[i]);
				if (count05[i] != null)
					model.setCount05(count05[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (count08[i] != null)
					model.setCount08(count08[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (count07[i] != null)
					model.setCount07(count07[i]);
				if (count02[i] != null)
					model.setCount02(count02[i]);
				if (etdDate[i] != null)
					model.setEtdDate(etdDate[i]);
				if (count01[i] != null)
					model.setCount01(count01[i]);
				if (pTypeSize[i] != null)
					model.setPTypeSize(pTypeSize[i]);
				if (count04[i] != null)
					model.setCount04(count04[i]);
				if (count03[i] != null)
					model.setCount03(count03[i]);
				if (subTrade[i] != null)
					model.setSubTrade(subTrade[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (count09[i] != null)
					model.setCount09(count09[i]);
				if (frmrVvd[i] != null)
					model.setFrmrVvd(frmrVvd[i]);
				if (tscntr[i] != null)
					model.setTscntr(tscntr[i]);
				if (formerVvd[i] != null)
					model.setFormerVvd(formerVvd[i]);
				if (mv[i] != null)
					model.setMv(mv[i]);
				if (count10[i] != null)
					model.setCount10(count10[i]);
				if (count11[i] != null)
					model.setCount11(count11[i]);
				if (count19[i] != null)
					model.setCount19(count19[i]);
				if (count18[i] != null)
					model.setCount18(count18[i]);
				if (count17[i] != null)
					model.setCount17(count17[i]);
				if (count16[i] != null)
					model.setCount16(count16[i]);
				if (count15[i] != null)
					model.setCount15(count15[i]);
				if (nextLane[i] != null)
					model.setNextLane(nextLane[i]);
				if (count14[i] != null)
					model.setCount14(count14[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (count13[i] != null)
					model.setCount13(count13[i]);
				if (count12[i] != null)
					model.setCount12(count12[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (cnNm[i] != null)
					model.setCnNm(cnNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSTimeRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSTimeRptVO[]
	 */
	public TSTimeRptVO[] getTSTimeRptVOs(){
		TSTimeRptVO[] vos = (TSTimeRptVO[])models.toArray(new TSTimeRptVO[models.size()]);
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
		this.eventDate = this.eventDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtSeq = this.dtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count20 = this.count20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLane = this.pLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count22 = this.count22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count21 = this.count21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count23 = this.count23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count24 = this.count24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count25 = this.count25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count26 = this.count26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryLevel = this.inquiryLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count27 = this.count27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count28 = this.count28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count29 = this.count29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count33 = this.count33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count32 = this.count32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count31 = this.count31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count30 = this.count30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCompany = this.pCompany .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDays = this.sDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPol = this.pPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSoc = this.pSoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmrLane = this.frmrLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count36 = this.count36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count37 = this.count37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count34 = this.count34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count35 = this.count35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count38 = this.count38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count39 = this.count39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDay = this.stayDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeSize = this.typeSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count40 = this.count40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count06 = this.count06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count05 = this.count05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count08 = this.count08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count07 = this.count07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count02 = this.count02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDate = this.etdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count01 = this.count01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTypeSize = this.pTypeSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count04 = this.count04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count03 = this.count03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrade = this.subTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count09 = this.count09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmrVvd = this.frmrVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tscntr = this.tscntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerVvd = this.formerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mv = this.mv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count10 = this.count10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count11 = this.count11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count19 = this.count19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count18 = this.count18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count17 = this.count17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count16 = this.count16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count15 = this.count15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextLane = this.nextLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count14 = this.count14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count13 = this.count13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count12 = this.count12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnNm = this.cnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
