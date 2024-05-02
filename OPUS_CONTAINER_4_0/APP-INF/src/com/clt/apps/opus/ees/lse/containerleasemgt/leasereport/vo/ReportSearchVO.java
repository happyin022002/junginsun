/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportSearchVO.java
*@FileTitle : ReportSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.12.14 진준성
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo;

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
 * @author 진준성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private final Collection<ReportSearchVO> models = new ArrayList<ReportSearchVO>();

	/* Column Info */
	private String cntrno1 = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String cntrno2 = null;
	/* Column Info */
	private String periodStdt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String tysz = null;
	/* Column Info */
	private String keyVndrSeq = null;
	/* Column Info */
	private String fdays = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String detailCntrTpSz = null;
	/* Column Info */
	private String supplier = null;
	/* Column Info */
	private String dpp = null;
	/* Column Info */
	private String lon = null;
	/* Column Info */
	private String q2 = null;
	/* Column Info */
	private String yard1 = null;
	/* Column Info */
	private String q4 = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String lof = null;
	/* Column Info */
	private String yard2 = null;
	/* Column Info */
	private String ofhdate = null;
	/* Column Info */
	private String ofhloc = null;
	/* Column Info */
	private String termChange = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String detailAgmtCtyCd = null;
	/* Column Info */
	private String feb = null;
	/* Column Info */
	private String nov = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String tysz1 = null;
	/* Column Info */
	private String tysz2 = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String rciveDt1 = null;
	/* Column Info */
	private String rciveDt2 = null;
	/* Column Info */
	private String detailRcc = null;
	/* Column Info */
	private String mtDrayageCost = null;
	/* Column Info */
	private String dec = null;
	/* Column Info */
	private String snNumRange2 = null;
	/* Column Info */
	private String rciveDt = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String mRCost = null;
	/* Column Info */
	private String mar = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String detailSccCd = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String may = null;
	/* Column Info */
	private String apr = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String detailLstmCd = null;
	/* Column Info */
	private String snEngRange1 = null;
	/* Column Info */
	private String jul = null;
	/* Column Info */
	private String ohloc = null;
	/* Column Info */
	private String snEngRange2 = null;
	/* Column Info */
	private String jun = null;
	/* Column Info */
	private String snNumRange1 = null;
	/* Column Info */
	private String offHireDrayage = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String doc = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String detailVndrSeq = null;
	/* Column Info */
	private String onHireDrayage = null;
	/* Column Info */
	private String periodEddt = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String d3 = null;
	/* Column Info */
	private String jan = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String lstmCdStr = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String minohdays = null;
	/* Column Info */
	private String pcr = null;
	/* Column Info */
	private String puc = null;
	/* Column Info */
	private String rentalCharge = null;
	/* Column Info */
	private String oct = null;
	/* Column Info */
	private String ohdate = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String seq1 = null;
	/* Column Info */
	private String seq2 = null;
	/* Column Info */
	private String rcc = null;
	/* Column Info */
	private String immediately = null;
	/* Column Info */
	private String detailAgmtSeq = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String gTtl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String dii = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String levelNo = null;
	/* Column Info */
	private String level   = null;
	/* Column Info */
	private String useddays = null;
	/* Column Info */
	private String dcr = null;
	/* Column Info */
	private String yearMonth = null;
	/* Column Info */
	private String divTotal = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String sep = null;
	/* Column Info */
	private String r7 = null;
	/* Column Info */
	private String detailCntrTpszCd = null;
	/* Column Info */
	private String aug = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String cntrTpszCdStr = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private int iPage = 1;
	
	/* Column Info */
	private String o5 = null;
	/* Column Info */
	private String q5 = null;
	/* Column Info */
	private String r8 = null;
	/* Column Info */
	private String zz = null;
	/* Column Info */
	private String cntrAuthNo = null;
	/* Column Info */
	private String oldAgmtNo = null;	
	/* Column Info */
	private String lseCtrtNo = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private final HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private final HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReportSearchVO() {}

	public ReportSearchVO(String ibflag, String cnmvStsCd, String pagerows, String cntrno1, String reportType, String location, String cntrno2, String q4, String q2, String d2, String o2, String s2, String r2, String a2, String t2, String f2, String p2, String d5, String d4, String o4, String s4, String a4, String f5, String t4, String f4, String r5, String p4, String r4, String d7, String r7, String d9, String d8, String dx, String dw, String d3, String periodStdt, String tysz, String locCd, String keyVndrSeq, String fdays, String cntrTpszCd, String lstmCd, String detailCntrTpSz, String lstmCdStr, String yard1, String agmtSeq, String agmtNo, String minohdays, String yard2, String ofhdate, String ofhloc, String termChange, String ratio, String detailAgmtCtyCd, String ohdate, String vndrSeq, String company, String month, String tysz1, String seq1, String tysz2, String seq2, String rcc, String immediately, String detailAgmtSeq, String rciveDt1, String yard, String rciveDt2, String div, String detailRcc, String mtDrayageCost, String snNumRange2, String agmtCtyCd, String rciveDt, String dii, String locTp, String detailLstmCd, String snEngRange1, String ohloc, String cntrno, String snEngRange2, String useddays, String snNumRange1, String yearMonth, String divTotal, String term, String refNo, String detailCntrTpszCd, String detailVndrSeq, String cntrTpszCdStr, String periodEddt, String levelNo, String jan, String feb, String mar, String apr, String may, String jun, String jul, String aug, String sep, String oct, String nov, String dec, String result, String supplier, String rentalCharge, String lon, String puc, String pcr, String lof, String doc, String dcr, String onHireDrayage, String offHireDrayage, String mRCost, String dpp, String gTtl, String detailSccCd, String sccCd
			, String o5, String q5, String r8, String zz, String cntrAuthNo, String oldAgmtNo, String lseCtrtNo) {
		this.cntrno1 = cntrno1;
		this.p4 = p4;
		this.p2 = p2;
		this.cntrno2 = cntrno2;
		this.periodStdt = periodStdt;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.tysz = tysz;
		this.keyVndrSeq = keyVndrSeq;
		this.fdays = fdays;
		this.cntrTpszCd = cntrTpszCd;
		this.detailCntrTpSz = detailCntrTpSz;
		this.supplier = supplier;
		this.dpp = dpp;
		this.lon = lon;
		this.q2 = q2;
		this.yard1 = yard1;
		this.q4 = q4;
		this.agmtNo = agmtNo;
		this.lof = lof;
		this.yard2 = yard2;
		this.ofhdate = ofhdate;
		this.ofhloc = ofhloc;
		this.termChange = termChange;
		this.ratio = ratio;
		this.detailAgmtCtyCd = detailAgmtCtyCd;
		this.feb = feb;
		this.nov = nov;
		this.month = month;
		this.tysz1 = tysz1;
		this.tysz2 = tysz2;
		this.dw = dw;
		this.dx = dx;
		this.rciveDt1 = rciveDt1;
		this.rciveDt2 = rciveDt2;
		this.detailRcc = detailRcc;
		this.mtDrayageCost = mtDrayageCost;
		this.dec = dec;
		this.snNumRange2 = snNumRange2;
		this.rciveDt = rciveDt;
		this.a2 = a2;
		this.mRCost = mRCost;
		this.mar = mar;
		this.a4 = a4;
		this.detailSccCd = detailSccCd;
		this.f2 = f2;
		this.f5 = f5;
		this.f4 = f4;
		this.o2 = o2;
		this.locTp = locTp;
		this.may = may;
		this.apr = apr;
		this.o4 = o4;
		this.detailLstmCd = detailLstmCd;
		this.snEngRange1 = snEngRange1;
		this.jul = jul;
		this.ohloc = ohloc;
		this.snEngRange2 = snEngRange2;
		this.jun = jun;
		this.snNumRange1 = snNumRange1;
		this.offHireDrayage = offHireDrayage;
		this.sccCd = sccCd;
		this.doc = doc;
		this.refNo = refNo;
		this.detailVndrSeq = detailVndrSeq;
		this.onHireDrayage = onHireDrayage;
		this.periodEddt = periodEddt;
		this.reportType = reportType;
		this.location = location;
		this.d9 = d9;
		this.d8 = d8;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.d2 = d2;
		this.d3 = d3;
		this.jan = jan;
		this.lstmCd = lstmCd;
		this.lstmCdStr = lstmCdStr;
		this.agmtSeq = agmtSeq;
		this.minohdays = minohdays;
		this.pcr = pcr;
		this.puc = puc;
		this.rentalCharge = rentalCharge;
		this.oct = oct;
		this.ohdate = ohdate;
		this.vndrSeq = vndrSeq;
		this.company = company;
		this.t4 = t4;
		this.seq1 = seq1;
		this.seq2 = seq2;
		this.rcc = rcc;
		this.immediately = immediately;
		this.detailAgmtSeq = detailAgmtSeq;
		this.result = result;
		this.t2 = t2;
		this.yard = yard;
		this.div = div;
		this.gTtl = gTtl;
		this.ibflag = ibflag;
		this.agmtCtyCd = agmtCtyCd;
		this.dii = dii;
		this.s4 = s4;
		this.s2 = s2;
		this.cntrno = cntrno;
		this.levelNo = levelNo;
		this.level   = levelNo;
		this.useddays = useddays;
		this.dcr = dcr;
		this.yearMonth = yearMonth;
		this.divTotal = divTotal;
		this.term = term;
		this.sep = sep;
		this.r7 = r7;
		this.detailCntrTpszCd = detailCntrTpszCd;
		this.aug = aug;
		this.r2 = r2;
		this.cntrTpszCdStr = cntrTpszCdStr;
		this.r4 = r4;
		this.r5 = r5;
		this.cnmvStsCd = cnmvStsCd;
		
		this.o5 = o5;
		this.q5 = q5;
		this.r8 = r8;
		this.zz = zz;
		this.cntrAuthNo = cntrAuthNo;
		this.oldAgmtNo  = oldAgmtNo;
		this.lseCtrtNo  = lseCtrtNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	@Override
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrno1", getCntrno1());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("cntrno2", getCntrno2());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("tysz", getTysz());
		this.hashColumns.put("key_vndr_seq", getKeyVndrSeq());
		this.hashColumns.put("fdays", getFdays());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("detail_cntr_tp_sz", getDetailCntrTpSz());
		this.hashColumns.put("supplier", getSupplier());
		this.hashColumns.put("dpp", getDpp());
		this.hashColumns.put("lon", getLon());
		this.hashColumns.put("q2", getQ2());
		this.hashColumns.put("yard1", getYard1());
		this.hashColumns.put("q4", getQ4());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("lof", getLof());
		this.hashColumns.put("yard2", getYard2());
		this.hashColumns.put("ofhdate", getOfhdate());
		this.hashColumns.put("ofhloc", getOfhloc());
		this.hashColumns.put("term_change", getTermChange());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("detail_agmt_cty_cd", getDetailAgmtCtyCd());
		this.hashColumns.put("feb", getFeb());
		this.hashColumns.put("nov", getNov());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("tysz1", getTysz1());
		this.hashColumns.put("tysz2", getTysz2());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("rcive_dt1", getRciveDt1());
		this.hashColumns.put("rcive_dt2", getRciveDt2());
		this.hashColumns.put("detail_rcc", getDetailRcc());
		this.hashColumns.put("mt_drayage_cost", getMtDrayageCost());
		this.hashColumns.put("dec", getDec());
		this.hashColumns.put("sn_num_range2", getSnNumRange2());
		this.hashColumns.put("rcive_dt", getRciveDt());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("m_r_cost", getMRCost());
		this.hashColumns.put("mar", getMar());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("detail_scc_cd", getDetailSccCd());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("may", getMay());
		this.hashColumns.put("apr", getApr());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("detail_lstm_cd", getDetailLstmCd());
		this.hashColumns.put("sn_eng_range1", getSnEngRange1());
		this.hashColumns.put("jul", getJul());
		this.hashColumns.put("ohloc", getOhloc());
		this.hashColumns.put("sn_eng_range2", getSnEngRange2());
		this.hashColumns.put("jun", getJun());
		this.hashColumns.put("sn_num_range1", getSnNumRange1());
		this.hashColumns.put("off_hire_drayage", getOffHireDrayage());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("detail_vndr_seq", getDetailVndrSeq());
		this.hashColumns.put("on_hire_drayage", getOnHireDrayage());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("d3", getD3());
		this.hashColumns.put("jan", getJan());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("lstm_cd_str", getLstmCdStr());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("minohdays", getMinohdays());
		this.hashColumns.put("pcr", getPcr());
		this.hashColumns.put("puc", getPuc());
		this.hashColumns.put("rental_charge", getRentalCharge());
		this.hashColumns.put("oct", getOct());
		this.hashColumns.put("ohdate", getOhdate());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("seq1", getSeq1());
		this.hashColumns.put("seq2", getSeq2());
		this.hashColumns.put("rcc", getRcc());
		this.hashColumns.put("immediately", getImmediately());
		this.hashColumns.put("detail_agmt_seq", getDetailAgmtSeq());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("g_ttl", getGTtl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("dii", getDii());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("level_no", getLevelNo());
		this.hashColumns.put("level", getLevelNo());
		this.hashColumns.put("useddays", getUseddays());
		this.hashColumns.put("dcr", getDcr());
		this.hashColumns.put("year_month", getYearMonth());
		this.hashColumns.put("div_total", getDivTotal());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("sep", getSep());
		this.hashColumns.put("r7", getR7());
		this.hashColumns.put("detail_cntr_tpsz_cd", getDetailCntrTpszCd());
		this.hashColumns.put("aug", getAug());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("cntr_tpsz_cd_str", getCntrTpszCdStr());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("o5", getO5());
		this.hashColumns.put("q5", getQ5());
		this.hashColumns.put("r8", getR8());
		this.hashColumns.put("zz", getZz());
		this.hashColumns.put("cntr_auth_no", getCntrAuthNo());
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());
		
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	@Override
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrno1", "cntrno1");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("cntrno2", "cntrno2");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("tysz", "tysz");
		this.hashFields.put("key_vndr_seq", "keyVndrSeq");
		this.hashFields.put("fdays", "fdays");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("detail_cntr_tp_sz", "detailCntrTpSz");
		this.hashFields.put("supplier", "supplier");
		this.hashFields.put("dpp", "dpp");
		this.hashFields.put("lon", "lon");
		this.hashFields.put("q2", "q2");
		this.hashFields.put("yard1", "yard1");
		this.hashFields.put("q4", "q4");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("lof", "lof");
		this.hashFields.put("yard2", "yard2");
		this.hashFields.put("ofhdate", "ofhdate");
		this.hashFields.put("ofhloc", "ofhloc");
		this.hashFields.put("term_change", "termChange");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("detail_agmt_cty_cd", "detailAgmtCtyCd");
		this.hashFields.put("feb", "feb");
		this.hashFields.put("nov", "nov");
		this.hashFields.put("month", "month");
		this.hashFields.put("tysz1", "tysz1");
		this.hashFields.put("tysz2", "tysz2");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("rcive_dt1", "rciveDt1");
		this.hashFields.put("rcive_dt2", "rciveDt2");
		this.hashFields.put("detail_rcc", "detailRcc");
		this.hashFields.put("mt_drayage_cost", "mtDrayageCost");
		this.hashFields.put("dec", "dec");
		this.hashFields.put("sn_num_range2", "snNumRange2");
		this.hashFields.put("rcive_dt", "rciveDt");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("m_r_cost", "mRCost");
		this.hashFields.put("mar", "mar");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("detail_scc_cd", "detailSccCd");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("may", "may");
		this.hashFields.put("apr", "apr");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("detail_lstm_cd", "detailLstmCd");
		this.hashFields.put("sn_eng_range1", "snEngRange1");
		this.hashFields.put("jul", "jul");
		this.hashFields.put("ohloc", "ohloc");
		this.hashFields.put("sn_eng_range2", "snEngRange2");
		this.hashFields.put("jun", "jun");
		this.hashFields.put("sn_num_range1", "snNumRange1");
		this.hashFields.put("off_hire_drayage", "offHireDrayage");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("detail_vndr_seq", "detailVndrSeq");
		this.hashFields.put("on_hire_drayage", "onHireDrayage");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("location", "location");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("d3", "d3");
		this.hashFields.put("jan", "jan");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("lstm_cd_str", "lstmCdStr");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("minohdays", "minohdays");
		this.hashFields.put("pcr", "pcr");
		this.hashFields.put("puc", "puc");
		this.hashFields.put("rental_charge", "rentalCharge");
		this.hashFields.put("oct", "oct");
		this.hashFields.put("ohdate", "ohdate");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("company", "company");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("seq1", "seq1");
		this.hashFields.put("seq2", "seq2");
		this.hashFields.put("rcc", "rcc");
		this.hashFields.put("immediately", "immediately");
		this.hashFields.put("detail_agmt_seq", "detailAgmtSeq");
		this.hashFields.put("result", "result");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("div", "div");
		this.hashFields.put("g_ttl", "gTtl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("dii", "dii");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("level_no", "levelNo");
		this.hashFields.put("level", "levelNo");
		this.hashFields.put("useddays", "useddays");
		this.hashFields.put("dcr", "dcr");
		this.hashFields.put("year_month", "yearMonth");
		this.hashFields.put("div_total", "divTotal");
		this.hashFields.put("term", "term");
		this.hashFields.put("sep", "sep");
		this.hashFields.put("r7", "r7");
		this.hashFields.put("detail_cntr_tpsz_cd", "detailCntrTpszCd");
		this.hashFields.put("aug", "aug");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("cntr_tpsz_cd_str", "cntrTpszCdStr");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("o5", "o5");
		this.hashFields.put("q5", "q5");
		this.hashFields.put("r8", "r8");
		this.hashFields.put("zz", "zz");
		this.hashFields.put("cntr_auth_no", "cntrAuthNo");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrno1
	 */
	public String getCntrno1() {
		return this.cntrno1;
	}

	/**
	 * Column Info
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}

	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}

	/**
	 * Column Info
	 * @return cntrno2
	 */
	public String getCntrno2() {
		return this.cntrno2;
	}

	/**
	 * Column Info
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
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
	 * Column Info
	 * @return tysz
	 */
	public String getTysz() {
		return this.tysz;
	}

	/**
	 * Column Info
	 * @return keyVndrSeq
	 */
	public String getKeyVndrSeq() {
		return this.keyVndrSeq;
	}

	/**
	 * Column Info
	 * @return fdays
	 */
	public String getFdays() {
		return this.fdays;
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
	 * @return detailCntrTpSz
	 */
	public String getDetailCntrTpSz() {
		return this.detailCntrTpSz;
	}

	/**
	 * Column Info
	 * @return supplier
	 */
	public String getSupplier() {
		return this.supplier;
	}

	/**
	 * Column Info
	 * @return dpp
	 */
	public String getDpp() {
		return this.dpp;
	}

	/**
	 * Column Info
	 * @return lon
	 */
	public String getLon() {
		return this.lon;
	}

	/**
	 * Column Info
	 * @return q2
	 */
	public String getQ2() {
		return this.q2;
	}

	/**
	 * Column Info
	 * @return yard1
	 */
	public String getYard1() {
		return this.yard1;
	}

	/**
	 * Column Info
	 * @return q4
	 */
	public String getQ4() {
		return this.q4;
	}

	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return lof
	 */
	public String getLof() {
		return this.lof;
	}

	/**
	 * Column Info
	 * @return yard2
	 */
	public String getYard2() {
		return this.yard2;
	}

	/**
	 * Column Info
	 * @return ofhdate
	 */
	public String getOfhdate() {
		return this.ofhdate;
	}

	/**
	 * Column Info
	 * @return ofhloc
	 */
	public String getOfhloc() {
		return this.ofhloc;
	}

	/**
	 * Column Info
	 * @return termChange
	 */
	public String getTermChange() {
		return this.termChange;
	}

	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}

	/**
	 * Column Info
	 * @return detailAgmtCtyCd
	 */
	public String getDetailAgmtCtyCd() {
		return this.detailAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @return feb
	 */
	public String getFeb() {
		return this.feb;
	}

	/**
	 * Column Info
	 * @return nov
	 */
	public String getNov() {
		return this.nov;
	}

	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}

	/**
	 * Column Info
	 * @return tysz1
	 */
	public String getTysz1() {
		return this.tysz1;
	}

	/**
	 * Column Info
	 * @return tysz2
	 */
	public String getTysz2() {
		return this.tysz2;
	}

	/**
	 * Column Info
	 * @return dw
	 */
	public String getDw() {
		return this.dw;
	}

	/**
	 * Column Info
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
	}

	/**
	 * Column Info
	 * @return rciveDt1
	 */
	public String getRciveDt1() {
		return this.rciveDt1;
	}

	/**
	 * Column Info
	 * @return rciveDt2
	 */
	public String getRciveDt2() {
		return this.rciveDt2;
	}

	/**
	 * Column Info
	 * @return detailRcc
	 */
	public String getDetailRcc() {
		return this.detailRcc;
	}

	/**
	 * Column Info
	 * @return mtDrayageCost
	 */
	public String getMtDrayageCost() {
		return this.mtDrayageCost;
	}

	/**
	 * Column Info
	 * @return dec
	 */
	public String getDec() {
		return this.dec;
	}

	/**
	 * Column Info
	 * @return snNumRange2
	 */
	public String getSnNumRange2() {
		return this.snNumRange2;
	}

	/**
	 * Column Info
	 * @return rciveDt
	 */
	public String getRciveDt() {
		return this.rciveDt;
	}

	/**
	 * Column Info
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}

	/**
	 * Column Info
	 * @return mRCost
	 */
	public String getMRCost() {
		return this.mRCost;
	}

	/**
	 * Column Info
	 * @return mar
	 */
	public String getMar() {
		return this.mar;
	}

	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}

	/**
	 * Column Info
	 * @return detailSccCd
	 */
	public String getDetailSccCd() {
		return this.detailSccCd;
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
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
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
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
	}

	/**
	 * Column Info
	 * @return may
	 */
	public String getMay() {
		return this.may;
	}

	/**
	 * Column Info
	 * @return apr
	 */
	public String getApr() {
		return this.apr;
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
	 * @return detailLstmCd
	 */
	public String getDetailLstmCd() {
		return this.detailLstmCd;
	}

	/**
	 * Column Info
	 * @return snEngRange1
	 */
	public String getSnEngRange1() {
		return this.snEngRange1;
	}

	/**
	 * Column Info
	 * @return jul
	 */
	public String getJul() {
		return this.jul;
	}

	/**
	 * Column Info
	 * @return ohloc
	 */
	public String getOhloc() {
		return this.ohloc;
	}

	/**
	 * Column Info
	 * @return snEngRange2
	 */
	public String getSnEngRange2() {
		return this.snEngRange2;
	}

	/**
	 * Column Info
	 * @return jun
	 */
	public String getJun() {
		return this.jun;
	}

	/**
	 * Column Info
	 * @return snNumRange1
	 */
	public String getSnNumRange1() {
		return this.snNumRange1;
	}

	/**
	 * Column Info
	 * @return offHireDrayage
	 */
	public String getOffHireDrayage() {
		return this.offHireDrayage;
	}

	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}

	/**
	 * Column Info
	 * @return doc
	 */
	public String getDoc() {
		return this.doc;
	}

	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}

	/**
	 * Column Info
	 * @return detailVndrSeq
	 */
	public String getDetailVndrSeq() {
		return this.detailVndrSeq;
	}

	/**
	 * Column Info
	 * @return onHireDrayage
	 */
	public String getOnHireDrayage() {
		return this.onHireDrayage;
	}

	/**
	 * Column Info
	 * @return periodEddt
	 */
	public String getPeriodEddt() {
		return this.periodEddt;
	}

	/**
	 * Column Info
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
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
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}

	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
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
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
	}

	/**
	 * Column Info
	 * @return d3
	 */
	public String getD3() {
		return this.d3;
	}

	/**
	 * Column Info
	 * @return jan
	 */
	public String getJan() {
		return this.jan;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return lstmCdStr
	 */
	public String getLstmCdStr() {
		return this.lstmCdStr;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return minohdays
	 */
	public String getMinohdays() {
		return this.minohdays;
	}

	/**
	 * Column Info
	 * @return pcr
	 */
	public String getPcr() {
		return this.pcr;
	}

	/**
	 * Column Info
	 * @return puc
	 */
	public String getPuc() {
		return this.puc;
	}

	/**
	 * Column Info
	 * @return rentalCharge
	 */
	public String getRentalCharge() {
		return this.rentalCharge;
	}

	/**
	 * Column Info
	 * @return oct
	 */
	public String getOct() {
		return this.oct;
	}

	/**
	 * Column Info
	 * @return ohdate
	 */
	public String getOhdate() {
		return this.ohdate;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
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
	 * @return seq1
	 */
	public String getSeq1() {
		return this.seq1;
	}

	/**
	 * Column Info
	 * @return seq2
	 */
	public String getSeq2() {
		return this.seq2;
	}

	/**
	 * Column Info
	 * @return rcc
	 */
	public String getRcc() {
		return this.rcc;
	}

	/**
	 * Column Info
	 * @return immediately
	 */
	public String getImmediately() {
		return this.immediately;
	}

	/**
	 * Column Info
	 * @return detailAgmtSeq
	 */
	public String getDetailAgmtSeq() {
		return this.detailAgmtSeq;
	}

	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
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
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}

	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}

	/**
	 * Column Info
	 * @return gTtl
	 */
	public String getGTtl() {
		return this.gTtl;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return dii
	 */
	public String getDii() {
		return this.dii;
	}

	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}

	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}

	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}

	/**
	 * Column Info
	 * @return levelNo
	 */
	public String getLevelNo() {
		return this.levelNo;
	}
	/**
	 * Column Info
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}
	/**
	 * Column Info
	 * @return useddays
	 */
	public String getUseddays() {
		return this.useddays;
	}

	/**
	 * Column Info
	 * @return dcr
	 */
	public String getDcr() {
		return this.dcr;
	}

	/**
	 * Column Info
	 * @return yearMonth
	 */
	public String getYearMonth() {
		return this.yearMonth;
	}

	/**
	 * Column Info
	 * @return divTotal
	 */
	public String getDivTotal() {
		return this.divTotal;
	}

	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}

	/**
	 * Column Info
	 * @return sep
	 */
	public String getSep() {
		return this.sep;
	}

	/**
	 * Column Info
	 * @return r7
	 */
	public String getR7() {
		return this.r7;
	}

	/**
	 * Column Info
	 * @return detailCntrTpszCd
	 */
	public String getDetailCntrTpszCd() {
		return this.detailCntrTpszCd;
	}

	/**
	 * Column Info
	 * @return aug
	 */
	public String getAug() {
		return this.aug;
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
	 * @return cntrTpszCdStr
	 */
	public String getCntrTpszCdStr() {
		return this.cntrTpszCdStr;
	}

	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}

	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}


	/**
	 * Column Info
	 * @param cntrno1
	 */
	public void setCntrno1(String cntrno1) {
		this.cntrno1 = cntrno1;
	}

	/**
	 * Column Info
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}

	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}

	/**
	 * Column Info
	 * @param cntrno2
	 */
	public void setCntrno2(String cntrno2) {
		this.cntrno2 = cntrno2;
	}

	/**
	 * Column Info
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
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
	 * Column Info
	 * @param tysz
	 */
	public void setTysz(String tysz) {
		this.tysz = tysz;
	}

	/**
	 * Column Info
	 * @param keyVndrSeq
	 */
	public void setKeyVndrSeq(String keyVndrSeq) {
		this.keyVndrSeq = keyVndrSeq;
	}

	/**
	 * Column Info
	 * @param fdays
	 */
	public void setFdays(String fdays) {
		this.fdays = fdays;
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
	 * @param detailCntrTpSz
	 */
	public void setDetailCntrTpSz(String detailCntrTpSz) {
		this.detailCntrTpSz = detailCntrTpSz;
	}

	/**
	 * Column Info
	 * @param supplier
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * Column Info
	 * @param dpp
	 */
	public void setDpp(String dpp) {
		this.dpp = dpp;
	}

	/**
	 * Column Info
	 * @param lon
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 * Column Info
	 * @param q2
	 */
	public void setQ2(String q2) {
		this.q2 = q2;
	}

	/**
	 * Column Info
	 * @param yard1
	 */
	public void setYard1(String yard1) {
		this.yard1 = yard1;
	}

	/**
	 * Column Info
	 * @param q4
	 */
	public void setQ4(String q4) {
		this.q4 = q4;
	}

	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param lof
	 */
	public void setLof(String lof) {
		this.lof = lof;
	}

	/**
	 * Column Info
	 * @param yard2
	 */
	public void setYard2(String yard2) {
		this.yard2 = yard2;
	}

	/**
	 * Column Info
	 * @param ofhdate
	 */
	public void setOfhdate(String ofhdate) {
		this.ofhdate = ofhdate;
	}

	/**
	 * Column Info
	 * @param ofhloc
	 */
	public void setOfhloc(String ofhloc) {
		this.ofhloc = ofhloc;
	}

	/**
	 * Column Info
	 * @param termChange
	 */
	public void setTermChange(String termChange) {
		this.termChange = termChange;
	}

	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	/**
	 * Column Info
	 * @param detailAgmtCtyCd
	 */
	public void setDetailAgmtCtyCd(String detailAgmtCtyCd) {
		this.detailAgmtCtyCd = detailAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @param feb
	 */
	public void setFeb(String feb) {
		this.feb = feb;
	}

	/**
	 * Column Info
	 * @param nov
	 */
	public void setNov(String nov) {
		this.nov = nov;
	}

	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * Column Info
	 * @param tysz1
	 */
	public void setTysz1(String tysz1) {
		this.tysz1 = tysz1;
	}

	/**
	 * Column Info
	 * @param tysz2
	 */
	public void setTysz2(String tysz2) {
		this.tysz2 = tysz2;
	}

	/**
	 * Column Info
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}

	/**
	 * Column Info
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
	}

	/**
	 * Column Info
	 * @param rciveDt1
	 */
	public void setRciveDt1(String rciveDt1) {
		this.rciveDt1 = rciveDt1;
	}

	/**
	 * Column Info
	 * @param rciveDt2
	 */
	public void setRciveDt2(String rciveDt2) {
		this.rciveDt2 = rciveDt2;
	}

	/**
	 * Column Info
	 * @param detailRcc
	 */
	public void setDetailRcc(String detailRcc) {
		this.detailRcc = detailRcc;
	}

	/**
	 * Column Info
	 * @param mtDrayageCost
	 */
	public void setMtDrayageCost(String mtDrayageCost) {
		this.mtDrayageCost = mtDrayageCost;
	}

	/**
	 * Column Info
	 * @param dec
	 */
	public void setDec(String dec) {
		this.dec = dec;
	}

	/**
	 * Column Info
	 * @param snNumRange2
	 */
	public void setSnNumRange2(String snNumRange2) {
		this.snNumRange2 = snNumRange2;
	}

	/**
	 * Column Info
	 * @param rciveDt
	 */
	public void setRciveDt(String rciveDt) {
		this.rciveDt = rciveDt;
	}

	/**
	 * Column Info
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}

	/**
	 * Column Info
	 * @param mRCost
	 */
	public void setMRCost(String mRCost) {
		this.mRCost = mRCost;
	}

	/**
	 * Column Info
	 * @param mar
	 */
	public void setMar(String mar) {
		this.mar = mar;
	}

	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}

	/**
	 * Column Info
	 * @param detailSccCd
	 */
	public void setDetailSccCd(String detailSccCd) {
		this.detailSccCd = detailSccCd;
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
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
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
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}

	/**
	 * Column Info
	 * @param may
	 */
	public void setMay(String may) {
		this.may = may;
	}

	/**
	 * Column Info
	 * @param apr
	 */
	public void setApr(String apr) {
		this.apr = apr;
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
	 * @param detailLstmCd
	 */
	public void setDetailLstmCd(String detailLstmCd) {
		this.detailLstmCd = detailLstmCd;
	}

	/**
	 * Column Info
	 * @param snEngRange1
	 */
	public void setSnEngRange1(String snEngRange1) {
		this.snEngRange1 = snEngRange1;
	}

	/**
	 * Column Info
	 * @param jul
	 */
	public void setJul(String jul) {
		this.jul = jul;
	}

	/**
	 * Column Info
	 * @param ohloc
	 */
	public void setOhloc(String ohloc) {
		this.ohloc = ohloc;
	}

	/**
	 * Column Info
	 * @param snEngRange2
	 */
	public void setSnEngRange2(String snEngRange2) {
		this.snEngRange2 = snEngRange2;
	}

	/**
	 * Column Info
	 * @param jun
	 */
	public void setJun(String jun) {
		this.jun = jun;
	}

	/**
	 * Column Info
	 * @param snNumRange1
	 */
	public void setSnNumRange1(String snNumRange1) {
		this.snNumRange1 = snNumRange1;
	}

	/**
	 * Column Info
	 * @param offHireDrayage
	 */
	public void setOffHireDrayage(String offHireDrayage) {
		this.offHireDrayage = offHireDrayage;
	}

	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * Column Info
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}

	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Column Info
	 * @param detailVndrSeq
	 */
	public void setDetailVndrSeq(String detailVndrSeq) {
		this.detailVndrSeq = detailVndrSeq;
	}

	/**
	 * Column Info
	 * @param onHireDrayage
	 */
	public void setOnHireDrayage(String onHireDrayage) {
		this.onHireDrayage = onHireDrayage;
	}

	/**
	 * Column Info
	 * @param periodEddt
	 */
	public void setPeriodEddt(String periodEddt) {
		this.periodEddt = periodEddt;
	}

	/**
	 * Column Info
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
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
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}

	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
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
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}

	/**
	 * Column Info
	 * @param d3
	 */
	public void setD3(String d3) {
		this.d3 = d3;
	}

	/**
	 * Column Info
	 * @param jan
	 */
	public void setJan(String jan) {
		this.jan = jan;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param lstmCdStr
	 */
	public void setLstmCdStr(String lstmCdStr) {
		this.lstmCdStr = lstmCdStr;
	}

	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param minohdays
	 */
	public void setMinohdays(String minohdays) {
		this.minohdays = minohdays;
	}

	/**
	 * Column Info
	 * @param pcr
	 */
	public void setPcr(String pcr) {
		this.pcr = pcr;
	}

	/**
	 * Column Info
	 * @param puc
	 */
	public void setPuc(String puc) {
		this.puc = puc;
	}

	/**
	 * Column Info
	 * @param rentalCharge
	 */
	public void setRentalCharge(String rentalCharge) {
		this.rentalCharge = rentalCharge;
	}

	/**
	 * Column Info
	 * @param oct
	 */
	public void setOct(String oct) {
		this.oct = oct;
	}

	/**
	 * Column Info
	 * @param ohdate
	 */
	public void setOhdate(String ohdate) {
		this.ohdate = ohdate;
	}

	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
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
	 * @param seq1
	 */
	public void setSeq1(String seq1) {
		this.seq1 = seq1;
	}

	/**
	 * Column Info
	 * @param seq2
	 */
	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}

	/**
	 * Column Info
	 * @param rcc
	 */
	public void setRcc(String rcc) {
		this.rcc = rcc;
	}

	/**
	 * Column Info
	 * @param immediately
	 */
	public void setImmediately(String immediately) {
		this.immediately = immediately;
	}

	/**
	 * Column Info
	 * @param detailAgmtSeq
	 */
	public void setDetailAgmtSeq(String detailAgmtSeq) {
		this.detailAgmtSeq = detailAgmtSeq;
	}

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
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
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}

	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}

	/**
	 * Column Info
	 * @param gTtl
	 */
	public void setGTtl(String gTtl) {
		this.gTtl = gTtl;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param dii
	 */
	public void setDii(String dii) {
		this.dii = dii;
	}

	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}

	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}

	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}

	/**
	 * Column Info
	 * @param levelNo
	 */
	public void setLevelNo(String levelNo) {
		this.levelNo = levelNo;
	}
	/**
	 * Column Info
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Column Info
	 * @param useddays
	 */
	public void setUseddays(String useddays) {
		this.useddays = useddays;
	}

	/**
	 * Column Info
	 * @param dcr
	 */
	public void setDcr(String dcr) {
		this.dcr = dcr;
	}

	/**
	 * Column Info
	 * @param yearMonth
	 */
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	/**
	 * Column Info
	 * @param divTotal
	 */
	public void setDivTotal(String divTotal) {
		this.divTotal = divTotal;
	}

	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * Column Info
	 * @param sep
	 */
	public void setSep(String sep) {
		this.sep = sep;
	}

	/**
	 * Column Info
	 * @param r7
	 */
	public void setR7(String r7) {
		this.r7 = r7;
	}

	/**
	 * Column Info
	 * @param detailCntrTpszCd
	 */
	public void setDetailCntrTpszCd(String detailCntrTpszCd) {
		this.detailCntrTpszCd = detailCntrTpszCd;
	}

	/**
	 * Column Info
	 * @param aug
	 */
	public void setAug(String aug) {
		this.aug = aug;
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
	 * @param cntrTpszCdStr
	 */
	public void setCntrTpszCdStr(String cntrTpszCdStr) {
		this.cntrTpszCdStr = cntrTpszCdStr;
	}

	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}

	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}

	/**
	 * Page No
	 * @param iPage
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 * Page No
	 * @param iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @return the cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return cnmvStsCd;
	}

	/**
	 * @param cnmvStsCd the cnmvStsCd to set
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
	/**
	 * Column Info
	 * @return q5
	 */
	public String getQ5() {
		return this.q5;
	}
	
	/**
	 * Column Info
	 * @param q5
	 */
	public void setQ5(String q5) {
		this.q5 = q5;
	}
	
	/**
	 * Column Info
	 * @return r8
	 */
	public String getR8() {
		return this.r8;
	}
	
	/**
	 * Column Info
	 * @param r8
	 */
	public void setR8(String r8) {
		this.r8 = r8;
	}
	
	/**
	 * Column Info
	 * @return zz
	 */
	public String getZz() {
		return this.zz;
	}

	/**
	 * Column Info
	 * @return cntrAuthNo
	 */
	public String getCntrAuthNo() {
		return this.cntrAuthNo;
	}

	/**
	 * Column Info
	 * @return oldAgmtNo
	 */
	public String getOldAgmtNo() {
		return this.oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param zz
	 */
	public void setZz(String zz) {
		this.zz = zz;
	}

	/**
	 * Column Info
	 * @param zz
	 */
	public void setCntrAuthNo(String cntrAuthNo) {
		this.cntrAuthNo = cntrAuthNo;
	}

	/**
	 * Column Info
	 * @param zz
	 */
	public void setOldAgmtNo(String oldAgmtNo) {
		this.oldAgmtNo = oldAgmtNo;
	}
	/**
	 * Column Info
	 * @param lseCtrtNo
	 */
	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
	}
	/**
	 * Column Info
	 * @return lseCtrtNo
	 */
	public String getLseCtrtNo() {
		return this.lseCtrtNo;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrno1(JSPUtil.getParameter(request, "cntrno1", ""));
		setP4(JSPUtil.getParameter(request, "p4", ""));
		setP2(JSPUtil.getParameter(request, "p2", ""));
		setCntrno2(JSPUtil.getParameter(request, "cntrno2", ""));
		setPeriodStdt(JSPUtil.getParameter(request, "period_stdt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setTysz(JSPUtil.getParameter(request, "tysz", ""));
		setKeyVndrSeq(JSPUtil.getParameter(request, "key_vndr_seq", ""));
		setFdays(JSPUtil.getParameter(request, "fdays", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDetailCntrTpSz(JSPUtil.getParameter(request, "detail_cntr_tp_sz", ""));
		setSupplier(JSPUtil.getParameter(request, "supplier", ""));
		setDpp(JSPUtil.getParameter(request, "dpp", ""));
		setLon(JSPUtil.getParameter(request, "lon", ""));
		setQ2(JSPUtil.getParameter(request, "q2", ""));
		setYard1(JSPUtil.getParameter(request, "yard1", ""));
		setQ4(JSPUtil.getParameter(request, "q4", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setLof(JSPUtil.getParameter(request, "lof", ""));
		setYard2(JSPUtil.getParameter(request, "yard2", ""));
		setOfhdate(JSPUtil.getParameter(request, "ofhdate", ""));
		setOfhloc(JSPUtil.getParameter(request, "ofhloc", ""));
		setTermChange(JSPUtil.getParameter(request, "term_change", ""));
		setRatio(JSPUtil.getParameter(request, "ratio", ""));
		setDetailAgmtCtyCd(JSPUtil.getParameter(request, "detail_agmt_cty_cd", ""));
		setFeb(JSPUtil.getParameter(request, "feb", ""));
		setNov(JSPUtil.getParameter(request, "nov", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setTysz1(JSPUtil.getParameter(request, "tysz1", ""));
		setTysz2(JSPUtil.getParameter(request, "tysz2", ""));
		setDw(JSPUtil.getParameter(request, "dw", ""));
		setDx(JSPUtil.getParameter(request, "dx", ""));
		setRciveDt1(JSPUtil.getParameter(request, "rcive_dt1", ""));
		setRciveDt2(JSPUtil.getParameter(request, "rcive_dt2", ""));
		setDetailRcc(JSPUtil.getParameter(request, "detail_rcc", ""));
		setMtDrayageCost(JSPUtil.getParameter(request, "mt_drayage_cost", ""));
		setDec(JSPUtil.getParameter(request, "dec", ""));
		setSnNumRange2(JSPUtil.getParameter(request, "sn_num_range2", ""));
		setRciveDt(JSPUtil.getParameter(request, "rcive_dt", ""));
		setA2(JSPUtil.getParameter(request, "a2", ""));
		setMRCost(JSPUtil.getParameter(request, "m_r_cost", ""));
		setMar(JSPUtil.getParameter(request, "mar", ""));
		setA4(JSPUtil.getParameter(request, "a4", ""));
		setDetailSccCd(JSPUtil.getParameter(request, "detail_scc_cd", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setF5(JSPUtil.getParameter(request, "f5", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setMay(JSPUtil.getParameter(request, "may", ""));
		setApr(JSPUtil.getParameter(request, "apr", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setDetailLstmCd(JSPUtil.getParameter(request, "detail_lstm_cd", ""));
		setSnEngRange1(JSPUtil.getParameter(request, "sn_eng_range1", ""));
		setJul(JSPUtil.getParameter(request, "jul", ""));
		setOhloc(JSPUtil.getParameter(request, "ohloc", ""));
		setSnEngRange2(JSPUtil.getParameter(request, "sn_eng_range2", ""));
		setJun(JSPUtil.getParameter(request, "jun", ""));
		setSnNumRange1(JSPUtil.getParameter(request, "sn_num_range1", ""));
		setOffHireDrayage(JSPUtil.getParameter(request, "off_hire_drayage", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setDoc(JSPUtil.getParameter(request, "doc", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setDetailVndrSeq(JSPUtil.getParameter(request, "detail_vndr_seq", ""));
		setOnHireDrayage(JSPUtil.getParameter(request, "on_hire_drayage", ""));
		setPeriodEddt(JSPUtil.getParameter(request, "period_eddt", ""));
		setReportType(JSPUtil.getParameter(request, "report_type", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setD9(JSPUtil.getParameter(request, "d9", ""));
		setD8(JSPUtil.getParameter(request, "d8", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setD3(JSPUtil.getParameter(request, "d3", ""));
		setJan(JSPUtil.getParameter(request, "jan", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setLstmCdStr(JSPUtil.getParameter(request, "lstm_cd_str", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setMinohdays(JSPUtil.getParameter(request, "minohdays", ""));
		setPcr(JSPUtil.getParameter(request, "pcr", ""));
		setPuc(JSPUtil.getParameter(request, "puc", ""));
		setRentalCharge(JSPUtil.getParameter(request, "rental_charge", ""));
		setOct(JSPUtil.getParameter(request, "oct", ""));
		setOhdate(JSPUtil.getParameter(request, "ohdate", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setT4(JSPUtil.getParameter(request, "t4", ""));
		setSeq1(JSPUtil.getParameter(request, "seq1", ""));
		setSeq2(JSPUtil.getParameter(request, "seq2", ""));
		setRcc(JSPUtil.getParameter(request, "rcc", ""));
		setImmediately(JSPUtil.getParameter(request, "immediately", ""));
		setDetailAgmtSeq(JSPUtil.getParameter(request, "detail_agmt_seq", ""));
		setResult(JSPUtil.getParameter(request, "result", ""));
		setT2(JSPUtil.getParameter(request, "t2", ""));
		setYard(JSPUtil.getParameter(request, "yard", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setGTtl(JSPUtil.getParameter(request, "g_ttl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setDii(JSPUtil.getParameter(request, "dii", ""));
		setS4(JSPUtil.getParameter(request, "s4", ""));
		setS2(JSPUtil.getParameter(request, "s2", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setLevelNo(JSPUtil.getParameter(request, "level_no", ""));
		setLevel(JSPUtil.getParameter(request, "level_no", ""));
		setUseddays(JSPUtil.getParameter(request, "useddays", ""));
		setDcr(JSPUtil.getParameter(request, "dcr", ""));
		setYearMonth(JSPUtil.getParameter(request, "year_month", ""));
		setDivTotal(JSPUtil.getParameter(request, "div_total", ""));
		setTerm(JSPUtil.getParameter(request, "term", ""));
		setSep(JSPUtil.getParameter(request, "sep", ""));
		setR7(JSPUtil.getParameter(request, "r7", ""));
		setDetailCntrTpszCd(JSPUtil.getParameter(request, "detail_cntr_tpsz_cd", ""));
		setAug(JSPUtil.getParameter(request, "aug", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setCntrTpszCdStr(JSPUtil.getParameter(request, "cntr_tpsz_cd_str", ""));
		setR4(JSPUtil.getParameter(request, "r4", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		
		setO5(JSPUtil.getParameter(request, "o5", ""));
		setQ5(JSPUtil.getParameter(request, "q5", ""));
		setR8(JSPUtil.getParameter(request, "r8", ""));
		setZz(JSPUtil.getParameter(request, "zz", ""));
		setCntrAuthNo(JSPUtil.getParameter(request, "cntr_auth_no", ""));
		setOldAgmtNo(JSPUtil.getParameter(request, "old_agmt_no", ""));
		setLseCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportSearchVO[]
	 */
	public ReportSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReportSearchVO[]
	 */
	public ReportSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportSearchVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrno1 = (JSPUtil.getParameter(request, prefix	+ "cntrno1", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] cntrno2 = (JSPUtil.getParameter(request, prefix	+ "cntrno2", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] tysz = (JSPUtil.getParameter(request, prefix	+ "tysz", length));
			String[] keyVndrSeq = (JSPUtil.getParameter(request, prefix	+ "key_vndr_seq", length));
			String[] fdays = (JSPUtil.getParameter(request, prefix	+ "fdays", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] detailCntrTpSz = (JSPUtil.getParameter(request, prefix	+ "detail_cntr_tp_sz", length));
			String[] supplier = (JSPUtil.getParameter(request, prefix	+ "supplier", length));
			String[] dpp = (JSPUtil.getParameter(request, prefix	+ "dpp", length));
			String[] lon = (JSPUtil.getParameter(request, prefix	+ "lon", length));
			String[] q2 = (JSPUtil.getParameter(request, prefix	+ "q2", length));
			String[] yard1 = (JSPUtil.getParameter(request, prefix	+ "yard1", length));
			String[] q4 = (JSPUtil.getParameter(request, prefix	+ "q4", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] lof = (JSPUtil.getParameter(request, prefix	+ "lof", length));
			String[] yard2 = (JSPUtil.getParameter(request, prefix	+ "yard2", length));
			String[] ofhdate = (JSPUtil.getParameter(request, prefix	+ "ofhdate", length));
			String[] ofhloc = (JSPUtil.getParameter(request, prefix	+ "ofhloc", length));
			String[] termChange = (JSPUtil.getParameter(request, prefix	+ "term_change", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] detailAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "detail_agmt_cty_cd", length));
			String[] feb = (JSPUtil.getParameter(request, prefix	+ "feb", length));
			String[] nov = (JSPUtil.getParameter(request, prefix	+ "nov", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] tysz1 = (JSPUtil.getParameter(request, prefix	+ "tysz1", length));
			String[] tysz2 = (JSPUtil.getParameter(request, prefix	+ "tysz2", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] rciveDt1 = (JSPUtil.getParameter(request, prefix	+ "rcive_dt1", length));
			String[] rciveDt2 = (JSPUtil.getParameter(request, prefix	+ "rcive_dt2", length));
			String[] detailRcc = (JSPUtil.getParameter(request, prefix	+ "detail_rcc", length));
			String[] mtDrayageCost = (JSPUtil.getParameter(request, prefix	+ "mt_drayage_cost", length));
			String[] dec = (JSPUtil.getParameter(request, prefix	+ "dec", length));
			String[] snNumRange2 = (JSPUtil.getParameter(request, prefix	+ "sn_num_range2", length));
			String[] rciveDt = (JSPUtil.getParameter(request, prefix	+ "rcive_dt", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] mRCost = (JSPUtil.getParameter(request, prefix	+ "m_r_cost", length));
			String[] mar = (JSPUtil.getParameter(request, prefix	+ "mar", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] detailSccCd = (JSPUtil.getParameter(request, prefix	+ "detail_scc_cd", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] may = (JSPUtil.getParameter(request, prefix	+ "may", length));
			String[] apr = (JSPUtil.getParameter(request, prefix	+ "apr", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] detailLstmCd = (JSPUtil.getParameter(request, prefix	+ "detail_lstm_cd", length));
			String[] snEngRange1 = (JSPUtil.getParameter(request, prefix	+ "sn_eng_range1", length));
			String[] jul = (JSPUtil.getParameter(request, prefix	+ "jul", length));
			String[] ohloc = (JSPUtil.getParameter(request, prefix	+ "ohloc", length));
			String[] snEngRange2 = (JSPUtil.getParameter(request, prefix	+ "sn_eng_range2", length));
			String[] jun = (JSPUtil.getParameter(request, prefix	+ "jun", length));
			String[] snNumRange1 = (JSPUtil.getParameter(request, prefix	+ "sn_num_range1", length));
			String[] offHireDrayage = (JSPUtil.getParameter(request, prefix	+ "off_hire_drayage", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] doc = (JSPUtil.getParameter(request, prefix	+ "doc", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] detailVndrSeq = (JSPUtil.getParameter(request, prefix	+ "detail_vndr_seq", length));
			String[] onHireDrayage = (JSPUtil.getParameter(request, prefix	+ "on_hire_drayage", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] d3 = (JSPUtil.getParameter(request, prefix	+ "d3", length));
			String[] jan = (JSPUtil.getParameter(request, prefix	+ "jan", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] lstmCdStr = (JSPUtil.getParameter(request, prefix	+ "lstm_cd_str", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] minohdays = (JSPUtil.getParameter(request, prefix	+ "minohdays", length));
			String[] pcr = (JSPUtil.getParameter(request, prefix	+ "pcr", length));
			String[] puc = (JSPUtil.getParameter(request, prefix	+ "puc", length));
			String[] rentalCharge = (JSPUtil.getParameter(request, prefix	+ "rental_charge", length));
			String[] oct = (JSPUtil.getParameter(request, prefix	+ "oct", length));
			String[] ohdate = (JSPUtil.getParameter(request, prefix	+ "ohdate", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] seq1 = (JSPUtil.getParameter(request, prefix	+ "seq1", length));
			String[] seq2 = (JSPUtil.getParameter(request, prefix	+ "seq2", length));
			String[] rcc = (JSPUtil.getParameter(request, prefix	+ "rcc", length));
			String[] immediately = (JSPUtil.getParameter(request, prefix	+ "immediately", length));
			String[] detailAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "detail_agmt_seq", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] gTtl = (JSPUtil.getParameter(request, prefix	+ "g_ttl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] dii = (JSPUtil.getParameter(request, prefix	+ "dii", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] levelNo = (JSPUtil.getParameter(request, prefix	+ "level_no", length));
			String[] level   = (JSPUtil.getParameter(request, prefix	+ "level_no", length));
			String[] useddays = (JSPUtil.getParameter(request, prefix	+ "useddays", length));
			String[] dcr = (JSPUtil.getParameter(request, prefix	+ "dcr", length));
			String[] yearMonth = (JSPUtil.getParameter(request, prefix	+ "year_month", length));
			String[] divTotal = (JSPUtil.getParameter(request, prefix	+ "div_total", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] sep = (JSPUtil.getParameter(request, prefix	+ "sep", length));
			String[] r7 = (JSPUtil.getParameter(request, prefix	+ "r7", length));
			String[] detailCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "detail_cntr_tpsz_cd", length));
			String[] aug = (JSPUtil.getParameter(request, prefix	+ "aug", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] cntrTpszCdStr = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_str", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			String[] q5 = (JSPUtil.getParameter(request, prefix	+ "q5", length));
			String[] r8 = (JSPUtil.getParameter(request, prefix	+ "r8", length));
			String[] zz = (JSPUtil.getParameter(request, prefix	+ "zz", length));
			String[] cntrAuthNo = (JSPUtil.getParameter(request, prefix	+ "cntr_auth_no", length));
			String[] oldAgmtNo = (JSPUtil.getParameter(request, prefix	+ "old_amgt_no", length));
			String[] lseCtrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no", length));
		
			for (int i = 0; i < length; i++) {
				model = new ReportSearchVO();
				if (cntrno1[i] != null)
					model.setCntrno1(cntrno1[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (cntrno2[i] != null)
					model.setCntrno2(cntrno2[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (tysz[i] != null)
					model.setTysz(tysz[i]);
				if (keyVndrSeq[i] != null)
					model.setKeyVndrSeq(keyVndrSeq[i]);
				if (fdays[i] != null)
					model.setFdays(fdays[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (detailCntrTpSz[i] != null)
					model.setDetailCntrTpSz(detailCntrTpSz[i]);
				if (supplier[i] != null)
					model.setSupplier(supplier[i]);
				if (dpp[i] != null)
					model.setDpp(dpp[i]);
				if (lon[i] != null)
					model.setLon(lon[i]);
				if (q2[i] != null)
					model.setQ2(q2[i]);
				if (yard1[i] != null)
					model.setYard1(yard1[i]);
				if (q4[i] != null)
					model.setQ4(q4[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (lof[i] != null)
					model.setLof(lof[i]);
				if (yard2[i] != null)
					model.setYard2(yard2[i]);
				if (ofhdate[i] != null)
					model.setOfhdate(ofhdate[i]);
				if (ofhloc[i] != null)
					model.setOfhloc(ofhloc[i]);
				if (termChange[i] != null)
					model.setTermChange(termChange[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (detailAgmtCtyCd[i] != null)
					model.setDetailAgmtCtyCd(detailAgmtCtyCd[i]);
				if (feb[i] != null)
					model.setFeb(feb[i]);
				if (nov[i] != null)
					model.setNov(nov[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (tysz1[i] != null)
					model.setTysz1(tysz1[i]);
				if (tysz2[i] != null)
					model.setTysz2(tysz2[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (rciveDt1[i] != null)
					model.setRciveDt1(rciveDt1[i]);
				if (rciveDt2[i] != null)
					model.setRciveDt2(rciveDt2[i]);
				if (detailRcc[i] != null)
					model.setDetailRcc(detailRcc[i]);
				if (mtDrayageCost[i] != null)
					model.setMtDrayageCost(mtDrayageCost[i]);
				if (dec[i] != null)
					model.setDec(dec[i]);
				if (snNumRange2[i] != null)
					model.setSnNumRange2(snNumRange2[i]);
				if (rciveDt[i] != null)
					model.setRciveDt(rciveDt[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (mRCost[i] != null)
					model.setMRCost(mRCost[i]);
				if (mar[i] != null)
					model.setMar(mar[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (detailSccCd[i] != null)
					model.setDetailSccCd(detailSccCd[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (may[i] != null)
					model.setMay(may[i]);
				if (apr[i] != null)
					model.setApr(apr[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (detailLstmCd[i] != null)
					model.setDetailLstmCd(detailLstmCd[i]);
				if (snEngRange1[i] != null)
					model.setSnEngRange1(snEngRange1[i]);
				if (jul[i] != null)
					model.setJul(jul[i]);
				if (ohloc[i] != null)
					model.setOhloc(ohloc[i]);
				if (snEngRange2[i] != null)
					model.setSnEngRange2(snEngRange2[i]);
				if (jun[i] != null)
					model.setJun(jun[i]);
				if (snNumRange1[i] != null)
					model.setSnNumRange1(snNumRange1[i]);
				if (offHireDrayage[i] != null)
					model.setOffHireDrayage(offHireDrayage[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (doc[i] != null)
					model.setDoc(doc[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (detailVndrSeq[i] != null)
					model.setDetailVndrSeq(detailVndrSeq[i]);
				if (onHireDrayage[i] != null)
					model.setOnHireDrayage(onHireDrayage[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (d3[i] != null)
					model.setD3(d3[i]);
				if (jan[i] != null)
					model.setJan(jan[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (lstmCdStr[i] != null)
					model.setLstmCdStr(lstmCdStr[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (minohdays[i] != null)
					model.setMinohdays(minohdays[i]);
				if (pcr[i] != null)
					model.setPcr(pcr[i]);
				if (puc[i] != null)
					model.setPuc(puc[i]);
				if (rentalCharge[i] != null)
					model.setRentalCharge(rentalCharge[i]);
				if (oct[i] != null)
					model.setOct(oct[i]);
				if (ohdate[i] != null)
					model.setOhdate(ohdate[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (seq1[i] != null)
					model.setSeq1(seq1[i]);
				if (seq2[i] != null)
					model.setSeq2(seq2[i]);
				if (rcc[i] != null)
					model.setRcc(rcc[i]);
				if (immediately[i] != null)
					model.setImmediately(immediately[i]);
				if (detailAgmtSeq[i] != null)
					model.setDetailAgmtSeq(detailAgmtSeq[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (gTtl[i] != null)
					model.setGTtl(gTtl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (dii[i] != null)
					model.setDii(dii[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (levelNo[i] != null)
					model.setLevelNo(levelNo[i]);
				if (levelNo[i] != null)
					model.setLevel(levelNo[i]);
				if (useddays[i] != null)
					model.setUseddays(useddays[i]);
				if (dcr[i] != null)
					model.setDcr(dcr[i]);
				if (yearMonth[i] != null)
					model.setYearMonth(yearMonth[i]);
				if (divTotal[i] != null)
					model.setDivTotal(divTotal[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (sep[i] != null)
					model.setSep(sep[i]);
				if (r7[i] != null)
					model.setR7(r7[i]);
				if (detailCntrTpszCd[i] != null)
					model.setDetailCntrTpszCd(detailCntrTpszCd[i]);
				if (aug[i] != null)
					model.setAug(aug[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (cntrTpszCdStr[i] != null)
					model.setCntrTpszCdStr(cntrTpszCdStr[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);				
				if (o5[i] != null)
					model.setO5(o5[i]);
				if (q5[i] != null)
					model.setQ5(q5[i]);
				if (r8[i] != null)
					model.setR8(r8[i]);
				if (zz[i] != null)
					model.setZz(zz[i]);
				if (cntrAuthNo[i] != null)
					model.setCntrAuthNo(cntrAuthNo[i]);		
				if (oldAgmtNo[i] != null)
					model.setOldAgmtNo(oldAgmtNo[i]);
				if (lseCtrtNo[i] != null)
					model.setLseCtrtNo(lseCtrtNo[i]);		
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportSearchVO[]
	 */
	public ReportSearchVO[] getReportSearchVOs(){
		ReportSearchVO[] vos = models.toArray(new ReportSearchVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	@Override
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cntrno1 = this.cntrno1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno2 = this.cntrno2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz = this.tysz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyVndrSeq = this.keyVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdays = this.fdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailCntrTpSz = this.detailCntrTpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplier = this.supplier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpp = this.dpp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lon = this.lon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q2 = this.q2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard1 = this.yard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q4 = this.q4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lof = this.lof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard2 = this.yard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofhdate = this.ofhdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofhloc = this.ofhloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termChange = this.termChange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailAgmtCtyCd = this.detailAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feb = this.feb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nov = this.nov .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz1 = this.tysz1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz2 = this.tysz2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rciveDt1 = this.rciveDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rciveDt2 = this.rciveDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailRcc = this.detailRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDrayageCost = this.mtDrayageCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dec = this.dec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snNumRange2 = this.snNumRange2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rciveDt = this.rciveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRCost = this.mRCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mar = this.mar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailSccCd = this.detailSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.may = this.may .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apr = this.apr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailLstmCd = this.detailLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snEngRange1 = this.snEngRange1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jul = this.jul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohloc = this.ohloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snEngRange2 = this.snEngRange2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jun = this.jun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snNumRange1 = this.snNumRange1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireDrayage = this.offHireDrayage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc = this.doc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailVndrSeq = this.detailVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onHireDrayage = this.onHireDrayage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d3 = this.d3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jan = this.jan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCdStr = this.lstmCdStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minohdays = this.minohdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcr = this.pcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.puc = this.puc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rentalCharge = this.rentalCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oct = this.oct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohdate = this.ohdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq1 = this.seq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq2 = this.seq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc = this.rcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.immediately = this.immediately .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailAgmtSeq = this.detailAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTtl = this.gTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dii = this.dii .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelNo = this.levelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useddays = this.useddays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcr = this.dcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearMonth = this.yearMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divTotal = this.divTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sep = this.sep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7 = this.r7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailCntrTpszCd = this.detailCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aug = this.aug .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdStr = this.cntrTpszCdStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q5 = this.q5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r8 = this.r8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zz = this.zz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAuthNo = this.cntrAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo = this.oldAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo = this.lseCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
