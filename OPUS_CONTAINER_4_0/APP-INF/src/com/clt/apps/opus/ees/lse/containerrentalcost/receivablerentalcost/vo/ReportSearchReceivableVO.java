/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportSearchReceivableVO.java
*@FileTitle : ReportSearchReceivableVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.11.27 진준성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo;

import java.lang.reflect.Field;
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

public class ReportSearchReceivableVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportSearchReceivableVO> models = new ArrayList<ReportSearchReceivableVO>();
	
	/* Column Info */
	private String lesee = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String gto = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String pdm = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String periodStdt = null;
	/* Column Info */
	private String d7 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tysz = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String d3 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String jan = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String dpp = null;
	/* Column Info */
	private String lon = null;
	/* Column Info */
	private String q2 = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String q4 = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String receivable = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String pcr = null;
	/* Column Info */
	private String lof = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String puc = null;
	/* Column Info */
	private String oct = null;
	/* Column Info */
	private String periodYear = null;
	/* Column Info */
	private String feb = null;
	/* Column Info */
	private String nov = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String gti = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String abbrNm = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String gTtl = null;
	/* Column Info */
	private String crd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dec = null;
	/* Column Info */
	private String chargeTypeCd = null;
	/* Column Info */
	private String ttl4 = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String ttl3 = null;
	/* Column Info */
	private String ttl2 = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String ttl1 = null;
	/* Column Info */
	private String mar = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String may = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String apr = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String jul = null;
	/* Column Info */
	private String jun = null;
	/* Column Info */
	private String dcr = null;
	/* Column Info */
	private String doc = null;
	/* Column Info */
	private String sep = null;
	/* Column Info */
	private String r7 = null;
	/* Column Info */
	private String aug = null;
	/* Column Info */
	private String chargeType = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String periodEddt = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String searchTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReportSearchReceivableVO() {}

	public ReportSearchReceivableVO(String ibflag, String pagerows, String reportType, String company, String status, String receivable, String agmtCtyCd, String agmtSeq, String agmtNo, String lstmCd, String vndrSeq, String abbrNm, String cntrTpszCd, String locTp, String locCd, String chargeTypeCd, String periodStdt, String periodEddt, String periodYear, String div, String q4, String q2, String d2, String o2, String s2, String r2, String a2, String t2, String f2, String p2, String d5, String d4, String o4, String s4, String a4, String f5, String t4, String f4, String r5, String p4, String r4, String d7, String r7, String d9, String d8, String dx, String dw, String d3, String gTtl, String jan, String feb, String mar, String ttl1, String apr, String may, String jun, String ttl2, String jul, String aug, String sep, String ttl3, String oct, String nov, String dec, String ttl4, String lesee, String qty, String pdm, String puc, String pcr, String lon, String lof, String gti, String gto, String dpp, String doc, String dcr, String chargeType, String costYrmon, String tysz, String crd, String searchTp) {
		this.lesee = lesee;
		this.reportType = reportType;
		this.p4 = p4;
		this.p2 = p2;
		this.d9 = d9;
		this.d8 = d8;
		this.gto = gto;
		this.d5 = d5;
		this.pdm = pdm;
		this.d4 = d4;
		this.periodStdt = periodStdt;
		this.d7 = d7;
		this.pagerows = pagerows;
		this.tysz = tysz;
		this.d2 = d2;
		this.locCd = locCd;
		this.costYrmon = costYrmon;
		this.d3 = d3;
		this.cntrTpszCd = cntrTpszCd;
		this.jan = jan;
		this.lstmCd = lstmCd;
		this.dpp = dpp;
		this.lon = lon;
		this.q2 = q2;
		this.status = status;
		this.q4 = q4;
		this.agmtSeq = agmtSeq;
		this.receivable = receivable;
		this.agmtNo = agmtNo;
		this.pcr = pcr;
		this.lof = lof;
		this.qty = qty;
		this.puc = puc;
		this.oct = oct;
		this.periodYear = periodYear;
		this.feb = feb;
		this.nov = nov;
		this.vndrSeq = vndrSeq;
		this.gti = gti;
		this.company = company;
		this.t4 = t4;
		this.t2 = t2;
		this.dw = dw;
		this.dx = dx;
		this.abbrNm = abbrNm;
		this.div = div;
		this.gTtl = gTtl;
		this.crd = crd;
		this.ibflag = ibflag;
		this.dec = dec;
		this.chargeTypeCd = chargeTypeCd;
		this.ttl4 = ttl4;
		this.agmtCtyCd = agmtCtyCd;
		this.ttl3 = ttl3;
		this.ttl2 = ttl2;
		this.a2 = a2;
		this.ttl1 = ttl1;
		this.mar = mar;
		this.a4 = a4;
		this.f2 = f2;
		this.f5 = f5;
		this.s4 = s4;
		this.f4 = f4;
		this.may = may;
		this.s2 = s2;
		this.o2 = o2;
		this.locTp = locTp;
		this.apr = apr;
		this.o4 = o4;
		this.jul = jul;
		this.jun = jun;
		this.dcr = dcr;
		this.doc = doc;
		this.sep = sep;
		this.r7 = r7;
		this.aug = aug;
		this.chargeType = chargeType;
		this.r2 = r2;
		this.r4 = r4;
		this.periodEddt = periodEddt;
		this.r5 = r5;
		this.searchTp = searchTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lesee", getLesee());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("gto", getGto());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("pdm", getPdm());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tysz", getTysz());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("d3", getD3());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("jan", getJan());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("dpp", getDpp());
		this.hashColumns.put("lon", getLon());
		this.hashColumns.put("q2", getQ2());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("q4", getQ4());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("receivable", getReceivable());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("pcr", getPcr());
		this.hashColumns.put("lof", getLof());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("puc", getPuc());
		this.hashColumns.put("oct", getOct());
		this.hashColumns.put("period_year", getPeriodYear());
		this.hashColumns.put("feb", getFeb());
		this.hashColumns.put("nov", getNov());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("gti", getGti());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("abbr_nm", getAbbrNm());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("g_ttl", getGTtl());
		this.hashColumns.put("crd", getCrd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dec", getDec());
		this.hashColumns.put("charge_type_cd", getChargeTypeCd());
		this.hashColumns.put("ttl_4", getTtl4());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("ttl_3", getTtl3());
		this.hashColumns.put("ttl_2", getTtl2());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("ttl_1", getTtl1());
		this.hashColumns.put("mar", getMar());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("may", getMay());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("apr", getApr());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("jul", getJul());
		this.hashColumns.put("jun", getJun());
		this.hashColumns.put("dcr", getDcr());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("sep", getSep());
		this.hashColumns.put("r7", getR7());
		this.hashColumns.put("aug", getAug());
		this.hashColumns.put("charge_type", getChargeType());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("search_tp", getSearchTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lesee", "lesee");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("gto", "gto");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("pdm", "pdm");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tysz", "tysz");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("d3", "d3");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("jan", "jan");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("dpp", "dpp");
		this.hashFields.put("lon", "lon");
		this.hashFields.put("q2", "q2");
		this.hashFields.put("status", "status");
		this.hashFields.put("q4", "q4");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("receivable", "receivable");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("pcr", "pcr");
		this.hashFields.put("lof", "lof");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("puc", "puc");
		this.hashFields.put("oct", "oct");
		this.hashFields.put("period_year", "periodYear");
		this.hashFields.put("feb", "feb");
		this.hashFields.put("nov", "nov");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("gti", "gti");
		this.hashFields.put("company", "company");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("abbr_nm", "abbrNm");
		this.hashFields.put("div", "div");
		this.hashFields.put("g_ttl", "gTtl");
		this.hashFields.put("crd", "crd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dec", "dec");
		this.hashFields.put("charge_type_cd", "chargeTypeCd");
		this.hashFields.put("ttl_4", "ttl4");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("ttl_3", "ttl3");
		this.hashFields.put("ttl_2", "ttl2");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("ttl_1", "ttl1");
		this.hashFields.put("mar", "mar");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("may", "may");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("apr", "apr");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("jul", "jul");
		this.hashFields.put("jun", "jun");
		this.hashFields.put("dcr", "dcr");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("sep", "sep");
		this.hashFields.put("r7", "r7");
		this.hashFields.put("aug", "aug");
		this.hashFields.put("charge_type", "chargeType");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("search_tp", "searchTp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lesee
	 */
	public String getLesee() {
		return this.lesee;
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
	 * @return gto
	 */
	public String getGto() {
		return this.gto;
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
	 * @return pdm
	 */
	public String getPdm() {
		return this.pdm;
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
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
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
	 * @return tysz
	 */
	public String getTysz() {
		return this.tysz;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return receivable
	 */
	public String getReceivable() {
		return this.receivable;
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
	 * @return pcr
	 */
	public String getPcr() {
		return this.pcr;
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
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
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
	 * @return oct
	 */
	public String getOct() {
		return this.oct;
	}
	
	/**
	 * Column Info
	 * @return periodYear
	 */
	public String getPeriodYear() {
		return this.periodYear;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return gti
	 */
	public String getGti() {
		return this.gti;
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
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
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
	 * @return abbrNm
	 */
	public String getAbbrNm() {
		return this.abbrNm;
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
	 * Column Info
	 * @return crd
	 */
	public String getCrd() {
		return this.crd;
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
	 * @return dec
	 */
	public String getDec() {
		return this.dec;
	}
	
	/**
	 * Column Info
	 * @return chargeTypeCd
	 */
	public String getChargeTypeCd() {
		return this.chargeTypeCd;
	}
	
	/**
	 * Column Info
	 * @return ttl4
	 */
	public String getTtl4() {
		return this.ttl4;
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
	 * @return ttl3
	 */
	public String getTtl3() {
		return this.ttl3;
	}
	
	/**
	 * Column Info
	 * @return ttl2
	 */
	public String getTtl2() {
		return this.ttl2;
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
	 * @return ttl1
	 */
	public String getTtl1() {
		return this.ttl1;
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
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
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
	 * @return may
	 */
	public String getMay() {
		return this.may;
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
	 * @return jul
	 */
	public String getJul() {
		return this.jul;
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
	 * @return dcr
	 */
	public String getDcr() {
		return this.dcr;
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
	 * @return aug
	 */
	public String getAug() {
		return this.aug;
	}
	
	/**
	 * Column Info
	 * @return chargeType
	 */
	public String getChargeType() {
		return this.chargeType;
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
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
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
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	

	/**
	 * Column Info
	 * @param lesee
	 */
	public void setLesee(String lesee) {
		this.lesee = lesee;
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
	 * @param gto
	 */
	public void setGto(String gto) {
		this.gto = gto;
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
	 * @param pdm
	 */
	public void setPdm(String pdm) {
		this.pdm = pdm;
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
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
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
	 * @param tysz
	 */
	public void setTysz(String tysz) {
		this.tysz = tysz;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param receivable
	 */
	public void setReceivable(String receivable) {
		this.receivable = receivable;
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
	 * @param pcr
	 */
	public void setPcr(String pcr) {
		this.pcr = pcr;
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
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
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
	 * @param oct
	 */
	public void setOct(String oct) {
		this.oct = oct;
	}
	
	/**
	 * Column Info
	 * @param periodYear
	 */
	public void setPeriodYear(String periodYear) {
		this.periodYear = periodYear;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param gti
	 */
	public void setGti(String gti) {
		this.gti = gti;
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
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
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
	 * @param abbrNm
	 */
	public void setAbbrNm(String abbrNm) {
		this.abbrNm = abbrNm;
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
	 * Column Info
	 * @param crd
	 */
	public void setCrd(String crd) {
		this.crd = crd;
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
	 * @param dec
	 */
	public void setDec(String dec) {
		this.dec = dec;
	}
	
	/**
	 * Column Info
	 * @param chargeTypeCd
	 */
	public void setChargeTypeCd(String chargeTypeCd) {
		this.chargeTypeCd = chargeTypeCd;
	}
	
	/**
	 * Column Info
	 * @param ttl4
	 */
	public void setTtl4(String ttl4) {
		this.ttl4 = ttl4;
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
	 * @param ttl3
	 */
	public void setTtl3(String ttl3) {
		this.ttl3 = ttl3;
	}
	
	/**
	 * Column Info
	 * @param ttl2
	 */
	public void setTtl2(String ttl2) {
		this.ttl2 = ttl2;
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
	 * @param ttl1
	 */
	public void setTtl1(String ttl1) {
		this.ttl1 = ttl1;
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
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
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
	 * @param may
	 */
	public void setMay(String may) {
		this.may = may;
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
	 * @param jul
	 */
	public void setJul(String jul) {
		this.jul = jul;
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
	 * @param dcr
	 */
	public void setDcr(String dcr) {
		this.dcr = dcr;
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
	 * @param aug
	 */
	public void setAug(String aug) {
		this.aug = aug;
	}
	
	/**
	 * Column Info
	 * @param chargeType
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
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
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
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
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @return searchTp
	 */
	public String getSearchTp() {
		return this.searchTp;
	}
	
	
	/**
	 * Column Info
	 * @param searchTp
	 */
	public void setSearchTp(String searchTp) {
		this.searchTp = searchTp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLesee(JSPUtil.getParameter(request, "lesee", ""));
		setReportType(JSPUtil.getParameter(request, "report_type", ""));
		setP4(JSPUtil.getParameter(request, "p4", ""));
		setP2(JSPUtil.getParameter(request, "p2", ""));
		setD9(JSPUtil.getParameter(request, "d9", ""));
		setD8(JSPUtil.getParameter(request, "d8", ""));
		setGto(JSPUtil.getParameter(request, "gto", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setPdm(JSPUtil.getParameter(request, "pdm", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setPeriodStdt(JSPUtil.getParameter(request, "period_stdt", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTysz(JSPUtil.getParameter(request, "tysz", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setD3(JSPUtil.getParameter(request, "d3", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setJan(JSPUtil.getParameter(request, "jan", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setDpp(JSPUtil.getParameter(request, "dpp", ""));
		setLon(JSPUtil.getParameter(request, "lon", ""));
		setQ2(JSPUtil.getParameter(request, "q2", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setQ4(JSPUtil.getParameter(request, "q4", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setReceivable(JSPUtil.getParameter(request, "receivable", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setPcr(JSPUtil.getParameter(request, "pcr", ""));
		setLof(JSPUtil.getParameter(request, "lof", ""));
		setQty(JSPUtil.getParameter(request, "qty", ""));
		setPuc(JSPUtil.getParameter(request, "puc", ""));
		setOct(JSPUtil.getParameter(request, "oct", ""));
		setPeriodYear(JSPUtil.getParameter(request, "period_year", ""));
		setFeb(JSPUtil.getParameter(request, "feb", ""));
		setNov(JSPUtil.getParameter(request, "nov", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setGti(JSPUtil.getParameter(request, "gti", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setT4(JSPUtil.getParameter(request, "t4", ""));
		setT2(JSPUtil.getParameter(request, "t2", ""));
		setDw(JSPUtil.getParameter(request, "dw", ""));
		setDx(JSPUtil.getParameter(request, "dx", ""));
		setAbbrNm(JSPUtil.getParameter(request, "abbr_nm", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setGTtl(JSPUtil.getParameter(request, "g_ttl", ""));
		setCrd(JSPUtil.getParameter(request, "crd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDec(JSPUtil.getParameter(request, "dec", ""));
		setChargeTypeCd(JSPUtil.getParameter(request, "charge_type_cd", ""));
		setTtl4(JSPUtil.getParameter(request, "ttl_4", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setTtl3(JSPUtil.getParameter(request, "ttl_3", ""));
		setTtl2(JSPUtil.getParameter(request, "ttl_2", ""));
		setA2(JSPUtil.getParameter(request, "a2", ""));
		setTtl1(JSPUtil.getParameter(request, "ttl_1", ""));
		setMar(JSPUtil.getParameter(request, "mar", ""));
		setA4(JSPUtil.getParameter(request, "a4", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setF5(JSPUtil.getParameter(request, "f5", ""));
		setS4(JSPUtil.getParameter(request, "s4", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setMay(JSPUtil.getParameter(request, "may", ""));
		setS2(JSPUtil.getParameter(request, "s2", ""));
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setApr(JSPUtil.getParameter(request, "apr", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setJul(JSPUtil.getParameter(request, "jul", ""));
		setJun(JSPUtil.getParameter(request, "jun", ""));
		setDcr(JSPUtil.getParameter(request, "dcr", ""));
		setDoc(JSPUtil.getParameter(request, "doc", ""));
		setSep(JSPUtil.getParameter(request, "sep", ""));
		setR7(JSPUtil.getParameter(request, "r7", ""));
		setAug(JSPUtil.getParameter(request, "aug", ""));
		setChargeType(JSPUtil.getParameter(request, "charge_type", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setR4(JSPUtil.getParameter(request, "r4", ""));
		setPeriodEddt(JSPUtil.getParameter(request, "period_eddt", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
		setSearchTp(JSPUtil.getParameter(request, "search_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportSearchReceivableVO[]
	 */
	public ReportSearchReceivableVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportSearchReceivableVO[]
	 */
	public ReportSearchReceivableVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportSearchReceivableVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lesee = (JSPUtil.getParameter(request, prefix	+ "lesee", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] gto = (JSPUtil.getParameter(request, prefix	+ "gto", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] pdm = (JSPUtil.getParameter(request, prefix	+ "pdm", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tysz = (JSPUtil.getParameter(request, prefix	+ "tysz", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] d3 = (JSPUtil.getParameter(request, prefix	+ "d3", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] jan = (JSPUtil.getParameter(request, prefix	+ "jan", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] dpp = (JSPUtil.getParameter(request, prefix	+ "dpp", length));
			String[] lon = (JSPUtil.getParameter(request, prefix	+ "lon", length));
			String[] q2 = (JSPUtil.getParameter(request, prefix	+ "q2", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] q4 = (JSPUtil.getParameter(request, prefix	+ "q4", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] receivable = (JSPUtil.getParameter(request, prefix	+ "receivable", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] pcr = (JSPUtil.getParameter(request, prefix	+ "pcr", length));
			String[] lof = (JSPUtil.getParameter(request, prefix	+ "lof", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] puc = (JSPUtil.getParameter(request, prefix	+ "puc", length));
			String[] oct = (JSPUtil.getParameter(request, prefix	+ "oct", length));
			String[] periodYear = (JSPUtil.getParameter(request, prefix	+ "period_year", length));
			String[] feb = (JSPUtil.getParameter(request, prefix	+ "feb", length));
			String[] nov = (JSPUtil.getParameter(request, prefix	+ "nov", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] gti = (JSPUtil.getParameter(request, prefix	+ "gti", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] abbrNm = (JSPUtil.getParameter(request, prefix	+ "abbr_nm", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] gTtl = (JSPUtil.getParameter(request, prefix	+ "g_ttl", length));
			String[] crd = (JSPUtil.getParameter(request, prefix	+ "crd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dec = (JSPUtil.getParameter(request, prefix	+ "dec", length));
			String[] chargeTypeCd = (JSPUtil.getParameter(request, prefix	+ "charge_type_cd", length));
			String[] ttl4 = (JSPUtil.getParameter(request, prefix	+ "ttl_4", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] ttl3 = (JSPUtil.getParameter(request, prefix	+ "ttl_3", length));
			String[] ttl2 = (JSPUtil.getParameter(request, prefix	+ "ttl_2", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] ttl1 = (JSPUtil.getParameter(request, prefix	+ "ttl_1", length));
			String[] mar = (JSPUtil.getParameter(request, prefix	+ "mar", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] may = (JSPUtil.getParameter(request, prefix	+ "may", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] apr = (JSPUtil.getParameter(request, prefix	+ "apr", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] jul = (JSPUtil.getParameter(request, prefix	+ "jul", length));
			String[] jun = (JSPUtil.getParameter(request, prefix	+ "jun", length));
			String[] dcr = (JSPUtil.getParameter(request, prefix	+ "dcr", length));
			String[] doc = (JSPUtil.getParameter(request, prefix	+ "doc", length));
			String[] sep = (JSPUtil.getParameter(request, prefix	+ "sep", length));
			String[] r7 = (JSPUtil.getParameter(request, prefix	+ "r7", length));
			String[] aug = (JSPUtil.getParameter(request, prefix	+ "aug", length));
			String[] chargeType = (JSPUtil.getParameter(request, prefix	+ "charge_type", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] searchTp = (JSPUtil.getParameter(request, prefix	+ "search_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportSearchReceivableVO();
				if (lesee[i] != null)
					model.setLesee(lesee[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (gto[i] != null)
					model.setGto(gto[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (pdm[i] != null)
					model.setPdm(pdm[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tysz[i] != null)
					model.setTysz(tysz[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (d3[i] != null)
					model.setD3(d3[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (jan[i] != null)
					model.setJan(jan[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (dpp[i] != null)
					model.setDpp(dpp[i]);
				if (lon[i] != null)
					model.setLon(lon[i]);
				if (q2[i] != null)
					model.setQ2(q2[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (q4[i] != null)
					model.setQ4(q4[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (receivable[i] != null)
					model.setReceivable(receivable[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (pcr[i] != null)
					model.setPcr(pcr[i]);
				if (lof[i] != null)
					model.setLof(lof[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (puc[i] != null)
					model.setPuc(puc[i]);
				if (oct[i] != null)
					model.setOct(oct[i]);
				if (periodYear[i] != null)
					model.setPeriodYear(periodYear[i]);
				if (feb[i] != null)
					model.setFeb(feb[i]);
				if (nov[i] != null)
					model.setNov(nov[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (gti[i] != null)
					model.setGti(gti[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (abbrNm[i] != null)
					model.setAbbrNm(abbrNm[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (gTtl[i] != null)
					model.setGTtl(gTtl[i]);
				if (crd[i] != null)
					model.setCrd(crd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dec[i] != null)
					model.setDec(dec[i]);
				if (chargeTypeCd[i] != null)
					model.setChargeTypeCd(chargeTypeCd[i]);
				if (ttl4[i] != null)
					model.setTtl4(ttl4[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (ttl3[i] != null)
					model.setTtl3(ttl3[i]);
				if (ttl2[i] != null)
					model.setTtl2(ttl2[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (ttl1[i] != null)
					model.setTtl1(ttl1[i]);
				if (mar[i] != null)
					model.setMar(mar[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (may[i] != null)
					model.setMay(may[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (apr[i] != null)
					model.setApr(apr[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (jul[i] != null)
					model.setJul(jul[i]);
				if (jun[i] != null)
					model.setJun(jun[i]);
				if (dcr[i] != null)
					model.setDcr(dcr[i]);
				if (doc[i] != null)
					model.setDoc(doc[i]);
				if (sep[i] != null)
					model.setSep(sep[i]);
				if (r7[i] != null)
					model.setR7(r7[i]);
				if (aug[i] != null)
					model.setAug(aug[i]);
				if (chargeType[i] != null)
					model.setChargeType(chargeType[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (searchTp[i] != null)
					model.setSearchTp(searchTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportSearchReceivableVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportSearchReceivableVO[]
	 */
	public ReportSearchReceivableVO[] getReportSearchReceivableVOs(){
		ReportSearchReceivableVO[] vos = (ReportSearchReceivableVO[])models.toArray(new ReportSearchReceivableVO[models.size()]);
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
		this.lesee = this.lesee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gto = this.gto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdm = this.pdm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz = this.tysz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d3 = this.d3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jan = this.jan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpp = this.dpp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lon = this.lon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q2 = this.q2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q4 = this.q4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receivable = this.receivable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcr = this.pcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lof = this.lof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.puc = this.puc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oct = this.oct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodYear = this.periodYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feb = this.feb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nov = this.nov .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gti = this.gti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm = this.abbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTtl = this.gTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crd = this.crd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dec = this.dec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeTypeCd = this.chargeTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl4 = this.ttl4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl3 = this.ttl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl2 = this.ttl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl1 = this.ttl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mar = this.mar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.may = this.may .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apr = this.apr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jul = this.jul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jun = this.jun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcr = this.dcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc = this.doc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sep = this.sep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7 = this.r7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aug = this.aug .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeType = this.chargeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTp = this.searchTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
