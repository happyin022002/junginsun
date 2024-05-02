/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReportSearchPayableVO.java
 *@FileTitle : ReportSearchPayableVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.02.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ReportSearchPayableVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReportSearchPayableVO>  models =	new	ArrayList<ReportSearchPayableVO>();


	/*	Column Info	*/
	private  String	 sttl3   =  null;
	/*	Column Info	*/
	private  String	 sttl4   =  null;
	/*	Column Info	*/
	private  String	 lesee   =  null;
	/*	Column Info	*/
	private  String	 sttl1   =  null;
	/*	Column Info	*/
	private  String	 sttl2   =  null;
	/*	Column Info	*/
	private  String	 p4   =  null;
	/*	Column Info	*/
	private  String	 reportType   =  null;
	/*	Column Info	*/
	private  String	 p2   =  null;
	/*	Column Info	*/
	private  String	 sttl5   =  null;
	/*	Column Info	*/
	private  String	 d9   =  null;
	/*	Column Info	*/
	private  String	 d8   =  null;
	/*	Column Info	*/
	private  String	 gto   =  null;
	/*	Column Info	*/
	private  String	 d5   =  null;
	/*	Column Info	*/
	private  String	 d4   =  null;
	/*	Column Info	*/
	private  String	 pdm   =  null;
	/*	Column Info	*/
	private  String	 d7   =  null;
	/*	Column Info	*/
	private  String	 periodStdt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 tysz   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 d2   =  null;
	/*	Column Info	*/
	private  String	 costYrmon   =  null;
	/*	Column Info	*/
	private  String	 d3   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 jan   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 dpp   =  null;
	/*	Column Info	*/
	private  String	 lon   =  null;
	/*	Column Info	*/
	private  String	 q2   =  null;
	/*	Column Info	*/
	private  String	 status   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 q4   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 receivable   =  null;
	/*	Column Info	*/
	private  String	 pcr   =  null;
	/*	Column Info	*/
	private  String	 qty   =  null;
	/*	Column Info	*/
	private  String	 lof   =  null;
	/*	Column Info	*/
	private  String	 puc   =  null;
	/*	Column Info	*/
	private  String	 periodYear   =  null;
	/*	Column Info	*/
	private  String	 oct   =  null;
	/*	Column Info	*/
	private  String	 feb   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 nov   =  null;
	/*	Column Info	*/
	private  String	 gti   =  null;
	/*	Column Info	*/
	private  String	 company   =  null;
	/*	Column Info	*/
	private  String	 t4   =  null;
	/*	Column Info	*/
	private  String	 t2   =  null;
	/*	Column Info	*/
	private  String	 payable   =  null;
	/*	Column Info	*/
	private  String	 dw   =  null;
	/*	Column Info	*/
	private  String	 dx   =  null;
	/*	Column Info	*/
	private  String	 abbrNm   =  null;
	/*	Column Info	*/
	private  String	 div   =  null;
	/*	Column Info	*/
	private  String	 gTtl   =  null;
	/*	Column Info	*/
	private  String	 crd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 dio   =  null;
	/*	Column Info	*/
	private  String	 dec   =  null;
	/*	Column Info	*/
	private  String	 chargeTypeCd   =  null;
	/*	Column Info	*/
	private  String	 ttl5   =  null;
	/*	Column Info	*/
	private  String	 ttl4   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 ttl3   =  null;
	/*	Column Info	*/
	private  String	 a2   =  null;
	/*	Column Info	*/
	private  String	 ttl2   =  null;
	/*	Column Info	*/
	private  String	 mar   =  null;
	/*	Column Info	*/
	private  String	 ttl1   =  null;
	/*	Column Info	*/
	private  String	 a4   =  null;
	/*	Column Info	*/
	private  String	 dii   =  null;
	/*	Column Info	*/
	private  String	 f2   =  null;
	/*	Column Info	*/
	private  String	 f5   =  null;
	/*	Column Info	*/
	private  String	 f4   =  null;
	/*	Column Info	*/
	private  String	 s4   =  null;
	/*	Column Info	*/
	private  String	 locTp   =  null;
	/*	Column Info	*/
	private  String	 may   =  null;
	/*	Column Info	*/
	private  String	 o2   =  null;
	/*	Column Info	*/
	private  String	 s2   =  null;
	/*	Column Info	*/
	private  String	 apr   =  null;
	/*	Column Info	*/
	private  String	 o4   =  null;
	/*	Column Info	*/
	private  String	 jul   =  null;
	/*	Column Info	*/
	private  String	 jun   =  null;
	/*	Column Info	*/
	private  String	 dcr   =  null;
	/*	Column Info	*/
	private  String	 doc   =  null;
	/*	Column Info	*/
	private  String	 sep   =  null;
	/*	Column Info	*/
	private  String	 r7   =  null;
	/*	Column Info	*/
	private  String	 aug   =  null;
	/*	Column Info	*/
	private  String	 wdp   =  null;
	/*	Column Info	*/
	private  String	 chargeType   =  null;
	/*	Column Info	*/
	private  String	 r2   =  null;
	/*	Column Info	*/
	private  String	 r4   =  null;
	/*	Column Info	*/
	private  String	 periodEddt   =  null;
	/*	Column Info	*/
	private  String	 r5   =  null;
	/*	Column Info	*/
	private  String	 oth   =  null;
	/*	Column Info	*/
	private  String	 xx   =  null;
	/*	Column Info	*/
	private  String	 opl   =  null;
	/*	Column Info	*/
	private  String	 lsePayTpCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 divOrder   =  null;
	/*	Column Info	*/
	private  String	 searchTp   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReportSearchPayableVO(){}

	public ReportSearchPayableVO(String sttl3,String sttl4,String lesee,String sttl1,String sttl2,String p4,String reportType,String p2,String sttl5,String d9,String d8,String gto,String d5,String d4,String pdm,String d7,String periodStdt,String pagerows,String tysz,String locCd,String d2,String costYrmon,String d3,String cntrTpszCd,String jan,String lstmCd,String dpp,String lon,String q2,String status,String agmtSeq,String q4,String agmtNo,String receivable,String pcr,String qty,String lof,String puc,String periodYear,String oct,String feb,String vndrSeq,String nov,String gti,String company,String t4,String t2,String payable,String dw,String dx,String abbrNm,String div,String gTtl,String crd,String ibflag,String dio,String dec,String chargeTypeCd,String ttl5,String ttl4,String agmtCtyCd,String ttl3,String a2,String ttl2,String mar,String ttl1,String a4,String dii,String f2,String f5,String f4,String s4,String locTp,String may,String o2,String s2,String apr,String o4,String jul,String jun,String dcr,String doc,String sep,String r7,String aug,String wdp,String chargeType,String r2,String r4,String periodEddt,String r5,String oth,String xx,String opl,String lsePayTpCd,String currCd,String divOrder,String searchTp)	{
		this.sttl3  = sttl3 ;
		this.sttl4  = sttl4 ;
		this.lesee  = lesee ;
		this.sttl1  = sttl1 ;
		this.sttl2  = sttl2 ;
		this.p4  = p4 ;
		this.reportType  = reportType ;
		this.p2  = p2 ;
		this.sttl5  = sttl5 ;
		this.d9  = d9 ;
		this.d8  = d8 ;
		this.gto  = gto ;
		this.d5  = d5 ;
		this.d4  = d4 ;
		this.pdm  = pdm ;
		this.d7  = d7 ;
		this.periodStdt  = periodStdt ;
		this.pagerows  = pagerows ;
		this.tysz  = tysz ;
		this.locCd  = locCd ;
		this.d2  = d2 ;
		this.costYrmon  = costYrmon ;
		this.d3  = d3 ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.jan  = jan ;
		this.lstmCd  = lstmCd ;
		this.dpp  = dpp ;
		this.lon  = lon ;
		this.q2  = q2 ;
		this.status  = status ;
		this.agmtSeq  = agmtSeq ;
		this.q4  = q4 ;
		this.agmtNo  = agmtNo ;
		this.receivable  = receivable ;
		this.pcr  = pcr ;
		this.qty  = qty ;
		this.lof  = lof ;
		this.puc  = puc ;
		this.periodYear  = periodYear ;
		this.oct  = oct ;
		this.feb  = feb ;
		this.vndrSeq  = vndrSeq ;
		this.nov  = nov ;
		this.gti  = gti ;
		this.company  = company ;
		this.t4  = t4 ;
		this.t2  = t2 ;
		this.payable  = payable ;
		this.dw  = dw ;
		this.dx  = dx ;
		this.abbrNm  = abbrNm ;
		this.div  = div ;
		this.gTtl  = gTtl ;
		this.crd  = crd ;
		this.ibflag  = ibflag ;
		this.dio  = dio ;
		this.dec  = dec ;
		this.chargeTypeCd  = chargeTypeCd ;
		this.ttl5  = ttl5 ;
		this.ttl4  = ttl4 ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.ttl3  = ttl3 ;
		this.a2  = a2 ;
		this.ttl2  = ttl2 ;
		this.mar  = mar ;
		this.ttl1  = ttl1 ;
		this.a4  = a4 ;
		this.dii  = dii ;
		this.f2  = f2 ;
		this.f5  = f5 ;
		this.f4  = f4 ;
		this.s4  = s4 ;
		this.locTp  = locTp ;
		this.may  = may ;
		this.o2  = o2 ;
		this.s2  = s2 ;
		this.apr  = apr ;
		this.o4  = o4 ;
		this.jul  = jul ;
		this.jun  = jun ;
		this.dcr  = dcr ;
		this.doc  = doc ;
		this.sep  = sep ;
		this.r7  = r7 ;
		this.aug  = aug ;
		this.wdp  = wdp ;
		this.chargeType  = chargeType ;
		this.r2  = r2 ;
		this.r4  = r4 ;
		this.periodEddt  = periodEddt ;
		this.r5  = r5 ;
		this.oth  = oth ;
		this.xx  = xx ;
		this.opl  = opl ;
		this.lsePayTpCd  = lsePayTpCd ;
		this.currCd  = currCd ;
		this.divOrder  = divOrder ;
		this.searchTp  = searchTp ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sttl_3", getSttl3());		
		this.hashColumns.put("sttl_4", getSttl4());		
		this.hashColumns.put("lesee", getLesee());		
		this.hashColumns.put("sttl_1", getSttl1());		
		this.hashColumns.put("sttl_2", getSttl2());		
		this.hashColumns.put("p4", getP4());		
		this.hashColumns.put("report_type", getReportType());		
		this.hashColumns.put("p2", getP2());		
		this.hashColumns.put("sttl_5", getSttl5());		
		this.hashColumns.put("d9", getD9());		
		this.hashColumns.put("d8", getD8());		
		this.hashColumns.put("gto", getGto());		
		this.hashColumns.put("d5", getD5());		
		this.hashColumns.put("d4", getD4());		
		this.hashColumns.put("pdm", getPdm());		
		this.hashColumns.put("d7", getD7());		
		this.hashColumns.put("period_stdt", getPeriodStdt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("tysz", getTysz());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("d2", getD2());		
		this.hashColumns.put("cost_yrmon", getCostYrmon());		
		this.hashColumns.put("d3", getD3());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("jan", getJan());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("dpp", getDpp());		
		this.hashColumns.put("lon", getLon());		
		this.hashColumns.put("q2", getQ2());		
		this.hashColumns.put("status", getStatus());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("q4", getQ4());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("receivable", getReceivable());		
		this.hashColumns.put("pcr", getPcr());		
		this.hashColumns.put("qty", getQty());		
		this.hashColumns.put("lof", getLof());		
		this.hashColumns.put("puc", getPuc());		
		this.hashColumns.put("period_year", getPeriodYear());		
		this.hashColumns.put("oct", getOct());		
		this.hashColumns.put("feb", getFeb());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("nov", getNov());		
		this.hashColumns.put("gti", getGti());		
		this.hashColumns.put("company", getCompany());		
		this.hashColumns.put("t4", getT4());		
		this.hashColumns.put("t2", getT2());		
		this.hashColumns.put("payable", getPayable());		
		this.hashColumns.put("dw", getDw());		
		this.hashColumns.put("dx", getDx());		
		this.hashColumns.put("abbr_nm", getAbbrNm());		
		this.hashColumns.put("div", getDiv());		
		this.hashColumns.put("g_ttl", getGTtl());		
		this.hashColumns.put("crd", getCrd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("dio", getDio());		
		this.hashColumns.put("dec", getDec());		
		this.hashColumns.put("charge_type_cd", getChargeTypeCd());		
		this.hashColumns.put("ttl_5", getTtl5());		
		this.hashColumns.put("ttl_4", getTtl4());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("ttl_3", getTtl3());		
		this.hashColumns.put("a2", getA2());		
		this.hashColumns.put("ttl_2", getTtl2());		
		this.hashColumns.put("mar", getMar());		
		this.hashColumns.put("ttl_1", getTtl1());		
		this.hashColumns.put("a4", getA4());		
		this.hashColumns.put("dii", getDii());		
		this.hashColumns.put("f2", getF2());		
		this.hashColumns.put("f5", getF5());		
		this.hashColumns.put("f4", getF4());		
		this.hashColumns.put("s4", getS4());		
		this.hashColumns.put("loc_tp", getLocTp());		
		this.hashColumns.put("may", getMay());		
		this.hashColumns.put("o2", getO2());		
		this.hashColumns.put("s2", getS2());		
		this.hashColumns.put("apr", getApr());		
		this.hashColumns.put("o4", getO4());		
		this.hashColumns.put("jul", getJul());		
		this.hashColumns.put("jun", getJun());		
		this.hashColumns.put("dcr", getDcr());		
		this.hashColumns.put("doc", getDoc());		
		this.hashColumns.put("sep", getSep());		
		this.hashColumns.put("r7", getR7());		
		this.hashColumns.put("aug", getAug());		
		this.hashColumns.put("wdp", getWdp());		
		this.hashColumns.put("charge_type", getChargeType());		
		this.hashColumns.put("r2", getR2());		
		this.hashColumns.put("r4", getR4());		
		this.hashColumns.put("period_eddt", getPeriodEddt());		
		this.hashColumns.put("r5", getR5());		
		this.hashColumns.put("oth", getOth());		
		this.hashColumns.put("xx", getXx());		
		this.hashColumns.put("opl", getOpl());		
		this.hashColumns.put("lse_pay_tp_cd", getLsePayTpCd());		
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("div_order", getDivOrder());
		this.hashColumns.put("search_tp", getSearchTp());	
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("sttl_3", "sttl3");
		this.hashFields.put("sttl_4", "sttl4");
		this.hashFields.put("lesee", "lesee");
		this.hashFields.put("sttl_1", "sttl1");
		this.hashFields.put("sttl_2", "sttl2");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("sttl_5", "sttl5");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("gto", "gto");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("pdm", "pdm");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tysz", "tysz");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("d3", "d3");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("jan", "jan");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("dpp", "dpp");
		this.hashFields.put("lon", "lon");
		this.hashFields.put("q2", "q2");
		this.hashFields.put("status", "status");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("q4", "q4");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("receivable", "receivable");
		this.hashFields.put("pcr", "pcr");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("lof", "lof");
		this.hashFields.put("puc", "puc");
		this.hashFields.put("period_year", "periodYear");
		this.hashFields.put("oct", "oct");
		this.hashFields.put("feb", "feb");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("nov", "nov");
		this.hashFields.put("gti", "gti");
		this.hashFields.put("company", "company");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("payable", "payable");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("abbr_nm", "abbrNm");
		this.hashFields.put("div", "div");
		this.hashFields.put("g_ttl", "gTtl");
		this.hashFields.put("crd", "crd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dio", "dio");
		this.hashFields.put("dec", "dec");
		this.hashFields.put("charge_type_cd", "chargeTypeCd");
		this.hashFields.put("ttl_5", "ttl5");
		this.hashFields.put("ttl_4", "ttl4");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("ttl_3", "ttl3");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("ttl_2", "ttl2");
		this.hashFields.put("mar", "mar");
		this.hashFields.put("ttl_1", "ttl1");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("dii", "dii");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("may", "may");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("apr", "apr");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("jul", "jul");
		this.hashFields.put("jun", "jun");
		this.hashFields.put("dcr", "dcr");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("sep", "sep");
		this.hashFields.put("r7", "r7");
		this.hashFields.put("aug", "aug");
		this.hashFields.put("wdp", "wdp");
		this.hashFields.put("charge_type", "chargeType");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("xx", "xx");
		this.hashFields.put("opl", "opl");
		this.hashFields.put("lse_pay_tp_cd", "lsePayTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("div_order", "divOrder");
		this.hashFields.put("search_tp", "searchTp");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  sttl3
	*/
	public void	setSttl3( String	sttl3 ) {
		this.sttl3 =	sttl3;
	}
 
	/**
	 * Column Info
	 * @return	sttl3
	 */
	 public	 String	getSttl3() {
		 return	this.sttl3;
	 } 
 	/**
	* Column Info
	* @param  sttl4
	*/
	public void	setSttl4( String	sttl4 ) {
		this.sttl4 =	sttl4;
	}
 
	/**
	 * Column Info
	 * @return	sttl4
	 */
	 public	 String	getSttl4() {
		 return	this.sttl4;
	 } 
 	/**
	* Column Info
	* @param  lesee
	*/
	public void	setLesee( String	lesee ) {
		this.lesee =	lesee;
	}
 
	/**
	 * Column Info
	 * @return	lesee
	 */
	 public	 String	getLesee() {
		 return	this.lesee;
	 } 
 	/**
	* Column Info
	* @param  sttl1
	*/
	public void	setSttl1( String	sttl1 ) {
		this.sttl1 =	sttl1;
	}
 
	/**
	 * Column Info
	 * @return	sttl1
	 */
	 public	 String	getSttl1() {
		 return	this.sttl1;
	 } 
 	/**
	* Column Info
	* @param  sttl2
	*/
	public void	setSttl2( String	sttl2 ) {
		this.sttl2 =	sttl2;
	}
 
	/**
	 * Column Info
	 * @return	sttl2
	 */
	 public	 String	getSttl2() {
		 return	this.sttl2;
	 } 
 	/**
	* Column Info
	* @param  p4
	*/
	public void	setP4( String	p4 ) {
		this.p4 =	p4;
	}
 
	/**
	 * Column Info
	 * @return	p4
	 */
	 public	 String	getP4() {
		 return	this.p4;
	 } 
 	/**
	* Column Info
	* @param  reportType
	*/
	public void	setReportType( String	reportType ) {
		this.reportType =	reportType;
	}
 
	/**
	 * Column Info
	 * @return	reportType
	 */
	 public	 String	getReportType() {
		 return	this.reportType;
	 } 
 	/**
	* Column Info
	* @param  p2
	*/
	public void	setP2( String	p2 ) {
		this.p2 =	p2;
	}
 
	/**
	 * Column Info
	 * @return	p2
	 */
	 public	 String	getP2() {
		 return	this.p2;
	 } 
 	/**
	* Column Info
	* @param  sttl5
	*/
	public void	setSttl5( String	sttl5 ) {
		this.sttl5 =	sttl5;
	}
 
	/**
	 * Column Info
	 * @return	sttl5
	 */
	 public	 String	getSttl5() {
		 return	this.sttl5;
	 } 
 	/**
	* Column Info
	* @param  d9
	*/
	public void	setD9( String	d9 ) {
		this.d9 =	d9;
	}
 
	/**
	 * Column Info
	 * @return	d9
	 */
	 public	 String	getD9() {
		 return	this.d9;
	 } 
 	/**
	* Column Info
	* @param  d8
	*/
	public void	setD8( String	d8 ) {
		this.d8 =	d8;
	}
 
	/**
	 * Column Info
	 * @return	d8
	 */
	 public	 String	getD8() {
		 return	this.d8;
	 } 
 	/**
	* Column Info
	* @param  gto
	*/
	public void	setGto( String	gto ) {
		this.gto =	gto;
	}
 
	/**
	 * Column Info
	 * @return	gto
	 */
	 public	 String	getGto() {
		 return	this.gto;
	 } 
 	/**
	* Column Info
	* @param  d5
	*/
	public void	setD5( String	d5 ) {
		this.d5 =	d5;
	}
 
	/**
	 * Column Info
	 * @return	d5
	 */
	 public	 String	getD5() {
		 return	this.d5;
	 } 
 	/**
	* Column Info
	* @param  d4
	*/
	public void	setD4( String	d4 ) {
		this.d4 =	d4;
	}
 
	/**
	 * Column Info
	 * @return	d4
	 */
	 public	 String	getD4() {
		 return	this.d4;
	 } 
 	/**
	* Column Info
	* @param  pdm
	*/
	public void	setPdm( String	pdm ) {
		this.pdm =	pdm;
	}
 
	/**
	 * Column Info
	 * @return	pdm
	 */
	 public	 String	getPdm() {
		 return	this.pdm;
	 } 
 	/**
	* Column Info
	* @param  d7
	*/
	public void	setD7( String	d7 ) {
		this.d7 =	d7;
	}
 
	/**
	 * Column Info
	 * @return	d7
	 */
	 public	 String	getD7() {
		 return	this.d7;
	 } 
 	/**
	* Column Info
	* @param  periodStdt
	*/
	public void	setPeriodStdt( String	periodStdt ) {
		this.periodStdt =	periodStdt;
	}
 
	/**
	 * Column Info
	 * @return	periodStdt
	 */
	 public	 String	getPeriodStdt() {
		 return	this.periodStdt;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  tysz
	*/
	public void	setTysz( String	tysz ) {
		this.tysz =	tysz;
	}
 
	/**
	 * Column Info
	 * @return	tysz
	 */
	 public	 String	getTysz() {
		 return	this.tysz;
	 } 
 	/**
	* Column Info
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
	 } 
 	/**
	* Column Info
	* @param  d2
	*/
	public void	setD2( String	d2 ) {
		this.d2 =	d2;
	}
 
	/**
	 * Column Info
	 * @return	d2
	 */
	 public	 String	getD2() {
		 return	this.d2;
	 } 
 	/**
	* Column Info
	* @param  costYrmon
	*/
	public void	setCostYrmon( String	costYrmon ) {
		this.costYrmon =	costYrmon;
	}
 
	/**
	 * Column Info
	 * @return	costYrmon
	 */
	 public	 String	getCostYrmon() {
		 return	this.costYrmon;
	 } 
 	/**
	* Column Info
	* @param  d3
	*/
	public void	setD3( String	d3 ) {
		this.d3 =	d3;
	}
 
	/**
	 * Column Info
	 * @return	d3
	 */
	 public	 String	getD3() {
		 return	this.d3;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  jan
	*/
	public void	setJan( String	jan ) {
		this.jan =	jan;
	}
 
	/**
	 * Column Info
	 * @return	jan
	 */
	 public	 String	getJan() {
		 return	this.jan;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
	 } 
 	/**
	* Column Info
	* @param  dpp
	*/
	public void	setDpp( String	dpp ) {
		this.dpp =	dpp;
	}
 
	/**
	 * Column Info
	 * @return	dpp
	 */
	 public	 String	getDpp() {
		 return	this.dpp;
	 } 
 	/**
	* Column Info
	* @param  lon
	*/
	public void	setLon( String	lon ) {
		this.lon =	lon;
	}
 
	/**
	 * Column Info
	 * @return	lon
	 */
	 public	 String	getLon() {
		 return	this.lon;
	 } 
 	/**
	* Column Info
	* @param  q2
	*/
	public void	setQ2( String	q2 ) {
		this.q2 =	q2;
	}
 
	/**
	 * Column Info
	 * @return	q2
	 */
	 public	 String	getQ2() {
		 return	this.q2;
	 } 
 	/**
	* Column Info
	* @param  status
	*/
	public void	setStatus( String	status ) {
		this.status =	status;
	}
 
	/**
	 * Column Info
	 * @return	status
	 */
	 public	 String	getStatus() {
		 return	this.status;
	 } 
 	/**
	* Column Info
	* @param  agmtSeq
	*/
	public void	setAgmtSeq( String	agmtSeq ) {
		this.agmtSeq =	agmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtSeq
	 */
	 public	 String	getAgmtSeq() {
		 return	this.agmtSeq;
	 } 
 	/**
	* Column Info
	* @param  q4
	*/
	public void	setQ4( String	q4 ) {
		this.q4 =	q4;
	}
 
	/**
	 * Column Info
	 * @return	q4
	 */
	 public	 String	getQ4() {
		 return	this.q4;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
	 } 
 	/**
	* Column Info
	* @param  receivable
	*/
	public void	setReceivable( String	receivable ) {
		this.receivable =	receivable;
	}
 
	/**
	 * Column Info
	 * @return	receivable
	 */
	 public	 String	getReceivable() {
		 return	this.receivable;
	 } 
 	/**
	* Column Info
	* @param  pcr
	*/
	public void	setPcr( String	pcr ) {
		this.pcr =	pcr;
	}
 
	/**
	 * Column Info
	 * @return	pcr
	 */
	 public	 String	getPcr() {
		 return	this.pcr;
	 } 
 	/**
	* Column Info
	* @param  qty
	*/
	public void	setQty( String	qty ) {
		this.qty =	qty;
	}
 
	/**
	 * Column Info
	 * @return	qty
	 */
	 public	 String	getQty() {
		 return	this.qty;
	 } 
 	/**
	* Column Info
	* @param  lof
	*/
	public void	setLof( String	lof ) {
		this.lof =	lof;
	}
 
	/**
	 * Column Info
	 * @return	lof
	 */
	 public	 String	getLof() {
		 return	this.lof;
	 } 
 	/**
	* Column Info
	* @param  puc
	*/
	public void	setPuc( String	puc ) {
		this.puc =	puc;
	}
 
	/**
	 * Column Info
	 * @return	puc
	 */
	 public	 String	getPuc() {
		 return	this.puc;
	 } 
 	/**
	* Column Info
	* @param  periodYear
	*/
	public void	setPeriodYear( String	periodYear ) {
		this.periodYear =	periodYear;
	}
 
	/**
	 * Column Info
	 * @return	periodYear
	 */
	 public	 String	getPeriodYear() {
		 return	this.periodYear;
	 } 
 	/**
	* Column Info
	* @param  oct
	*/
	public void	setOct( String	oct ) {
		this.oct =	oct;
	}
 
	/**
	 * Column Info
	 * @return	oct
	 */
	 public	 String	getOct() {
		 return	this.oct;
	 } 
 	/**
	* Column Info
	* @param  feb
	*/
	public void	setFeb( String	feb ) {
		this.feb =	feb;
	}
 
	/**
	 * Column Info
	 * @return	feb
	 */
	 public	 String	getFeb() {
		 return	this.feb;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  nov
	*/
	public void	setNov( String	nov ) {
		this.nov =	nov;
	}
 
	/**
	 * Column Info
	 * @return	nov
	 */
	 public	 String	getNov() {
		 return	this.nov;
	 } 
 	/**
	* Column Info
	* @param  gti
	*/
	public void	setGti( String	gti ) {
		this.gti =	gti;
	}
 
	/**
	 * Column Info
	 * @return	gti
	 */
	 public	 String	getGti() {
		 return	this.gti;
	 } 
 	/**
	* Column Info
	* @param  company
	*/
	public void	setCompany( String	company ) {
		this.company =	company;
	}
 
	/**
	 * Column Info
	 * @return	company
	 */
	 public	 String	getCompany() {
		 return	this.company;
	 } 
 	/**
	* Column Info
	* @param  t4
	*/
	public void	setT4( String	t4 ) {
		this.t4 =	t4;
	}
 
	/**
	 * Column Info
	 * @return	t4
	 */
	 public	 String	getT4() {
		 return	this.t4;
	 } 
 	/**
	* Column Info
	* @param  t2
	*/
	public void	setT2( String	t2 ) {
		this.t2 =	t2;
	}
 
	/**
	 * Column Info
	 * @return	t2
	 */
	 public	 String	getT2() {
		 return	this.t2;
	 } 
 	/**
	* Column Info
	* @param  payable
	*/
	public void	setPayable( String	payable ) {
		this.payable =	payable;
	}
 
	/**
	 * Column Info
	 * @return	payable
	 */
	 public	 String	getPayable() {
		 return	this.payable;
	 } 
 	/**
	* Column Info
	* @param  dw
	*/
	public void	setDw( String	dw ) {
		this.dw =	dw;
	}
 
	/**
	 * Column Info
	 * @return	dw
	 */
	 public	 String	getDw() {
		 return	this.dw;
	 } 
 	/**
	* Column Info
	* @param  dx
	*/
	public void	setDx( String	dx ) {
		this.dx =	dx;
	}
 
	/**
	 * Column Info
	 * @return	dx
	 */
	 public	 String	getDx() {
		 return	this.dx;
	 } 
 	/**
	* Column Info
	* @param  abbrNm
	*/
	public void	setAbbrNm( String	abbrNm ) {
		this.abbrNm =	abbrNm;
	}
 
	/**
	 * Column Info
	 * @return	abbrNm
	 */
	 public	 String	getAbbrNm() {
		 return	this.abbrNm;
	 } 
 	/**
	* Column Info
	* @param  div
	*/
	public void	setDiv( String	div ) {
		this.div =	div;
	}
 
	/**
	 * Column Info
	 * @return	div
	 */
	 public	 String	getDiv() {
		 return	this.div;
	 } 
 	/**
	* Column Info
	* @param  gTtl
	*/
	public void	setGTtl( String	gTtl ) {
		this.gTtl =	gTtl;
	}
 
	/**
	 * Column Info
	 * @return	gTtl
	 */
	 public	 String	getGTtl() {
		 return	this.gTtl;
	 } 
 	/**
	* Column Info
	* @param  crd
	*/
	public void	setCrd( String	crd ) {
		this.crd =	crd;
	}
 
	/**
	 * Column Info
	 * @return	crd
	 */
	 public	 String	getCrd() {
		 return	this.crd;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  dio
	*/
	public void	setDio( String	dio ) {
		this.dio =	dio;
	}
 
	/**
	 * Column Info
	 * @return	dio
	 */
	 public	 String	getDio() {
		 return	this.dio;
	 } 
 	/**
	* Column Info
	* @param  dec
	*/
	public void	setDec( String	dec ) {
		this.dec =	dec;
	}
 
	/**
	 * Column Info
	 * @return	dec
	 */
	 public	 String	getDec() {
		 return	this.dec;
	 } 
 	/**
	* Column Info
	* @param  chargeTypeCd
	*/
	public void	setChargeTypeCd( String	chargeTypeCd ) {
		this.chargeTypeCd =	chargeTypeCd;
	}
 
	/**
	 * Column Info
	 * @return	chargeTypeCd
	 */
	 public	 String	getChargeTypeCd() {
		 return	this.chargeTypeCd;
	 } 
 	/**
	* Column Info
	* @param  ttl5
	*/
	public void	setTtl5( String	ttl5 ) {
		this.ttl5 =	ttl5;
	}
 
	/**
	 * Column Info
	 * @return	ttl5
	 */
	 public	 String	getTtl5() {
		 return	this.ttl5;
	 } 
 	/**
	* Column Info
	* @param  ttl4
	*/
	public void	setTtl4( String	ttl4 ) {
		this.ttl4 =	ttl4;
	}
 
	/**
	 * Column Info
	 * @return	ttl4
	 */
	 public	 String	getTtl4() {
		 return	this.ttl4;
	 } 
 	/**
	* Column Info
	* @param  agmtCtyCd
	*/
	public void	setAgmtCtyCd( String	agmtCtyCd ) {
		this.agmtCtyCd =	agmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtCtyCd
	 */
	 public	 String	getAgmtCtyCd() {
		 return	this.agmtCtyCd;
	 } 
 	/**
	* Column Info
	* @param  ttl3
	*/
	public void	setTtl3( String	ttl3 ) {
		this.ttl3 =	ttl3;
	}
 
	/**
	 * Column Info
	 * @return	ttl3
	 */
	 public	 String	getTtl3() {
		 return	this.ttl3;
	 } 
 	/**
	* Column Info
	* @param  a2
	*/
	public void	setA2( String	a2 ) {
		this.a2 =	a2;
	}
 
	/**
	 * Column Info
	 * @return	a2
	 */
	 public	 String	getA2() {
		 return	this.a2;
	 } 
 	/**
	* Column Info
	* @param  ttl2
	*/
	public void	setTtl2( String	ttl2 ) {
		this.ttl2 =	ttl2;
	}
 
	/**
	 * Column Info
	 * @return	ttl2
	 */
	 public	 String	getTtl2() {
		 return	this.ttl2;
	 } 
 	/**
	* Column Info
	* @param  mar
	*/
	public void	setMar( String	mar ) {
		this.mar =	mar;
	}
 
	/**
	 * Column Info
	 * @return	mar
	 */
	 public	 String	getMar() {
		 return	this.mar;
	 } 
 	/**
	* Column Info
	* @param  ttl1
	*/
	public void	setTtl1( String	ttl1 ) {
		this.ttl1 =	ttl1;
	}
 
	/**
	 * Column Info
	 * @return	ttl1
	 */
	 public	 String	getTtl1() {
		 return	this.ttl1;
	 } 
 	/**
	* Column Info
	* @param  a4
	*/
	public void	setA4( String	a4 ) {
		this.a4 =	a4;
	}
 
	/**
	 * Column Info
	 * @return	a4
	 */
	 public	 String	getA4() {
		 return	this.a4;
	 } 
 	/**
	* Column Info
	* @param  dii
	*/
	public void	setDii( String	dii ) {
		this.dii =	dii;
	}
 
	/**
	 * Column Info
	 * @return	dii
	 */
	 public	 String	getDii() {
		 return	this.dii;
	 } 
 	/**
	* Column Info
	* @param  f2
	*/
	public void	setF2( String	f2 ) {
		this.f2 =	f2;
	}
 
	/**
	 * Column Info
	 * @return	f2
	 */
	 public	 String	getF2() {
		 return	this.f2;
	 } 
 	/**
	* Column Info
	* @param  f5
	*/
	public void	setF5( String	f5 ) {
		this.f5 =	f5;
	}
 
	/**
	 * Column Info
	 * @return	f5
	 */
	 public	 String	getF5() {
		 return	this.f5;
	 } 
 	/**
	* Column Info
	* @param  f4
	*/
	public void	setF4( String	f4 ) {
		this.f4 =	f4;
	}
 
	/**
	 * Column Info
	 * @return	f4
	 */
	 public	 String	getF4() {
		 return	this.f4;
	 } 
 	/**
	* Column Info
	* @param  s4
	*/
	public void	setS4( String	s4 ) {
		this.s4 =	s4;
	}
 
	/**
	 * Column Info
	 * @return	s4
	 */
	 public	 String	getS4() {
		 return	this.s4;
	 } 
 	/**
	* Column Info
	* @param  locTp
	*/
	public void	setLocTp( String	locTp ) {
		this.locTp =	locTp;
	}
 
	/**
	 * Column Info
	 * @return	locTp
	 */
	 public	 String	getLocTp() {
		 return	this.locTp;
	 } 
 	/**
	* Column Info
	* @param  may
	*/
	public void	setMay( String	may ) {
		this.may =	may;
	}
 
	/**
	 * Column Info
	 * @return	may
	 */
	 public	 String	getMay() {
		 return	this.may;
	 } 
 	/**
	* Column Info
	* @param  o2
	*/
	public void	setO2( String	o2 ) {
		this.o2 =	o2;
	}
 
	/**
	 * Column Info
	 * @return	o2
	 */
	 public	 String	getO2() {
		 return	this.o2;
	 } 
 	/**
	* Column Info
	* @param  s2
	*/
	public void	setS2( String	s2 ) {
		this.s2 =	s2;
	}
 
	/**
	 * Column Info
	 * @return	s2
	 */
	 public	 String	getS2() {
		 return	this.s2;
	 } 
 	/**
	* Column Info
	* @param  apr
	*/
	public void	setApr( String	apr ) {
		this.apr =	apr;
	}
 
	/**
	 * Column Info
	 * @return	apr
	 */
	 public	 String	getApr() {
		 return	this.apr;
	 } 
 	/**
	* Column Info
	* @param  o4
	*/
	public void	setO4( String	o4 ) {
		this.o4 =	o4;
	}
 
	/**
	 * Column Info
	 * @return	o4
	 */
	 public	 String	getO4() {
		 return	this.o4;
	 } 
 	/**
	* Column Info
	* @param  jul
	*/
	public void	setJul( String	jul ) {
		this.jul =	jul;
	}
 
	/**
	 * Column Info
	 * @return	jul
	 */
	 public	 String	getJul() {
		 return	this.jul;
	 } 
 	/**
	* Column Info
	* @param  jun
	*/
	public void	setJun( String	jun ) {
		this.jun =	jun;
	}
 
	/**
	 * Column Info
	 * @return	jun
	 */
	 public	 String	getJun() {
		 return	this.jun;
	 } 
 	/**
	* Column Info
	* @param  dcr
	*/
	public void	setDcr( String	dcr ) {
		this.dcr =	dcr;
	}
 
	/**
	 * Column Info
	 * @return	dcr
	 */
	 public	 String	getDcr() {
		 return	this.dcr;
	 } 
 	/**
	* Column Info
	* @param  doc
	*/
	public void	setDoc( String	doc ) {
		this.doc =	doc;
	}
 
	/**
	 * Column Info
	 * @return	doc
	 */
	 public	 String	getDoc() {
		 return	this.doc;
	 } 
 	/**
	* Column Info
	* @param  sep
	*/
	public void	setSep( String	sep ) {
		this.sep =	sep;
	}
 
	/**
	 * Column Info
	 * @return	sep
	 */
	 public	 String	getSep() {
		 return	this.sep;
	 } 
 	/**
	* Column Info
	* @param  r7
	*/
	public void	setR7( String	r7 ) {
		this.r7 =	r7;
	}
 
	/**
	 * Column Info
	 * @return	r7
	 */
	 public	 String	getR7() {
		 return	this.r7;
	 } 
 	/**
	* Column Info
	* @param  aug
	*/
	public void	setAug( String	aug ) {
		this.aug =	aug;
	}
 
	/**
	 * Column Info
	 * @return	aug
	 */
	 public	 String	getAug() {
		 return	this.aug;
	 } 
 	/**
	* Column Info
	* @param  wdp
	*/
	public void	setWdp( String	wdp ) {
		this.wdp =	wdp;
	}
 
	/**
	 * Column Info
	 * @return	wdp
	 */
	 public	 String	getWdp() {
		 return	this.wdp;
	 } 
 	/**
	* Column Info
	* @param  chargeType
	*/
	public void	setChargeType( String	chargeType ) {
		this.chargeType =	chargeType;
	}
 
	/**
	 * Column Info
	 * @return	chargeType
	 */
	 public	 String	getChargeType() {
		 return	this.chargeType;
	 } 
 	/**
	* Column Info
	* @param  r2
	*/
	public void	setR2( String	r2 ) {
		this.r2 =	r2;
	}
 
	/**
	 * Column Info
	 * @return	r2
	 */
	 public	 String	getR2() {
		 return	this.r2;
	 } 
 	/**
	* Column Info
	* @param  r4
	*/
	public void	setR4( String	r4 ) {
		this.r4 =	r4;
	}
 
	/**
	 * Column Info
	 * @return	r4
	 */
	 public	 String	getR4() {
		 return	this.r4;
	 } 
 	/**
	* Column Info
	* @param  periodEddt
	*/
	public void	setPeriodEddt( String	periodEddt ) {
		this.periodEddt =	periodEddt;
	}
 
	/**
	 * Column Info
	 * @return	periodEddt
	 */
	 public	 String	getPeriodEddt() {
		 return	this.periodEddt;
	 } 
 	/**
	* Column Info
	* @param  r5
	*/
	public void	setR5( String	r5 ) {
		this.r5 =	r5;
	}
 
	/**
	 * Column Info
	 * @return	r5
	 */
	 public	 String	getR5() {
		 return	this.r5;
	 } 
 	/**
	* Column Info
	* @param  oth
	*/
	public void	setOth( String	oth ) {
		this.oth =	oth;
	}
 
	/**
	 * Column Info
	 * @return	oth
	 */
	 public	 String	getOth() {
		 return	this.oth;
	 } 
 	/**
	* Column Info
	* @param  xx
	*/
	public void	setXx( String	xx ) {
		this.xx =	xx;
	}
 
	/**
	 * Column Info
	 * @return	xx
	 */
	 public	 String	getXx() {
		 return	this.xx;
	 } 
 	/**
	* Column Info
	* @param  opl
	*/
	public void	setOpl( String	opl ) {
		this.opl =	opl;
	}
 
	/**
	 * Column Info
	 * @return	opl
	 */
	 public	 String	getOpl() {
		 return	this.opl;
	 } 
 	/**
	* Column Info
	* @param  lsePayTpCd
	*/
	public void	setLsePayTpCd( String	lsePayTpCd ) {
		this.lsePayTpCd =	lsePayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	lsePayTpCd
	 */
	 public	 String	getLsePayTpCd() {
		 return	this.lsePayTpCd;
	 } 
 	/**
	* Column Info
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
	 } 
	 
	 /**
	* Column Info
	* @param  divOrder
	*/
	public void	setDivOrder( String	divOrder ) {
		this.divOrder =	divOrder;
	}
 
	/**
	 * Column Info
	 * @return	divOrder
	 */
	 public	 String	getDivOrder() {
		 return	this.divOrder;
	 } 
	 
	 /**
	* Column Info
	* @param  searchTp
	*/
	public void	setSearchTp( String	searchTp ) {
		this.searchTp =	searchTp;
	}
 
	/**
	 * Column Info
	 * @return	searchTp
	 */
	 public	 String	getSearchTp() {
		 return	this.searchTp;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setSttl3(JSPUtil.getParameter(request,	prefix + "sttl_3", ""));
		setSttl4(JSPUtil.getParameter(request,	prefix + "sttl_4", ""));
		setLesee(JSPUtil.getParameter(request,	prefix + "lesee", ""));
		setSttl1(JSPUtil.getParameter(request,	prefix + "sttl_1", ""));
		setSttl2(JSPUtil.getParameter(request,	prefix + "sttl_2", ""));
		setP4(JSPUtil.getParameter(request,	prefix + "p4", ""));
		setReportType(JSPUtil.getParameter(request,	prefix + "report_type", ""));
		setP2(JSPUtil.getParameter(request,	prefix + "p2", ""));
		setSttl5(JSPUtil.getParameter(request,	prefix + "sttl_5", ""));
		setD9(JSPUtil.getParameter(request,	prefix + "d9", ""));
		setD8(JSPUtil.getParameter(request,	prefix + "d8", ""));
		setGto(JSPUtil.getParameter(request,	prefix + "gto", ""));
		setD5(JSPUtil.getParameter(request,	prefix + "d5", ""));
		setD4(JSPUtil.getParameter(request,	prefix + "d4", ""));
		setPdm(JSPUtil.getParameter(request,	prefix + "pdm", ""));
		setD7(JSPUtil.getParameter(request,	prefix + "d7", ""));
		setPeriodStdt(JSPUtil.getParameter(request,	prefix + "period_stdt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setTysz(JSPUtil.getParameter(request,	prefix + "tysz", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setD2(JSPUtil.getParameter(request,	prefix + "d2", ""));
		setCostYrmon(JSPUtil.getParameter(request,	prefix + "cost_yrmon", ""));
		setD3(JSPUtil.getParameter(request,	prefix + "d3", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setJan(JSPUtil.getParameter(request,	prefix + "jan", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setDpp(JSPUtil.getParameter(request,	prefix + "dpp", ""));
		setLon(JSPUtil.getParameter(request,	prefix + "lon", ""));
		setQ2(JSPUtil.getParameter(request,	prefix + "q2", ""));
		setStatus(JSPUtil.getParameter(request,	prefix + "status", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setQ4(JSPUtil.getParameter(request,	prefix + "q4", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setReceivable(JSPUtil.getParameter(request,	prefix + "receivable", ""));
		setPcr(JSPUtil.getParameter(request,	prefix + "pcr", ""));
		setQty(JSPUtil.getParameter(request,	prefix + "qty", ""));
		setLof(JSPUtil.getParameter(request,	prefix + "lof", ""));
		setPuc(JSPUtil.getParameter(request,	prefix + "puc", ""));
		setPeriodYear(JSPUtil.getParameter(request,	prefix + "period_year", ""));
		setOct(JSPUtil.getParameter(request,	prefix + "oct", ""));
		setFeb(JSPUtil.getParameter(request,	prefix + "feb", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setNov(JSPUtil.getParameter(request,	prefix + "nov", ""));
		setGti(JSPUtil.getParameter(request,	prefix + "gti", ""));
		setCompany(JSPUtil.getParameter(request,	prefix + "company", ""));
		setT4(JSPUtil.getParameter(request,	prefix + "t4", ""));
		setT2(JSPUtil.getParameter(request,	prefix + "t2", ""));
		setPayable(JSPUtil.getParameter(request,	prefix + "payable", ""));
		setDw(JSPUtil.getParameter(request,	prefix + "dw", ""));
		setDx(JSPUtil.getParameter(request,	prefix + "dx", ""));
		setAbbrNm(JSPUtil.getParameter(request,	prefix + "abbr_nm", ""));
		setDiv(JSPUtil.getParameter(request,	prefix + "div", ""));
		setGTtl(JSPUtil.getParameter(request,	prefix + "g_ttl", ""));
		setCrd(JSPUtil.getParameter(request,	prefix + "crd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDio(JSPUtil.getParameter(request,	prefix + "dio", ""));
		setDec(JSPUtil.getParameter(request,	prefix + "dec", ""));
		setChargeTypeCd(JSPUtil.getParameter(request,	prefix + "charge_type_cd", ""));
		setTtl5(JSPUtil.getParameter(request,	prefix + "ttl_5", ""));
		setTtl4(JSPUtil.getParameter(request,	prefix + "ttl_4", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setTtl3(JSPUtil.getParameter(request,	prefix + "ttl_3", ""));
		setA2(JSPUtil.getParameter(request,	prefix + "a2", ""));
		setTtl2(JSPUtil.getParameter(request,	prefix + "ttl_2", ""));
		setMar(JSPUtil.getParameter(request,	prefix + "mar", ""));
		setTtl1(JSPUtil.getParameter(request,	prefix + "ttl_1", ""));
		setA4(JSPUtil.getParameter(request,	prefix + "a4", ""));
		setDii(JSPUtil.getParameter(request,	prefix + "dii", ""));
		setF2(JSPUtil.getParameter(request,	prefix + "f2", ""));
		setF5(JSPUtil.getParameter(request,	prefix + "f5", ""));
		setF4(JSPUtil.getParameter(request,	prefix + "f4", ""));
		setS4(JSPUtil.getParameter(request,	prefix + "s4", ""));
		setLocTp(JSPUtil.getParameter(request,	prefix + "loc_tp", ""));
		setMay(JSPUtil.getParameter(request,	prefix + "may", ""));
		setO2(JSPUtil.getParameter(request,	prefix + "o2", ""));
		setS2(JSPUtil.getParameter(request,	prefix + "s2", ""));
		setApr(JSPUtil.getParameter(request,	prefix + "apr", ""));
		setO4(JSPUtil.getParameter(request,	prefix + "o4", ""));
		setJul(JSPUtil.getParameter(request,	prefix + "jul", ""));
		setJun(JSPUtil.getParameter(request,	prefix + "jun", ""));
		setDcr(JSPUtil.getParameter(request,	prefix + "dcr", ""));
		setDoc(JSPUtil.getParameter(request,	prefix + "doc", ""));
		setSep(JSPUtil.getParameter(request,	prefix + "sep", ""));
		setR7(JSPUtil.getParameter(request,	prefix + "r7", ""));
		setAug(JSPUtil.getParameter(request,	prefix + "aug", ""));
		setWdp(JSPUtil.getParameter(request,	prefix + "wdp", ""));
		setChargeType(JSPUtil.getParameter(request,	prefix + "charge_type", ""));
		setR2(JSPUtil.getParameter(request,	prefix + "r2", ""));
		setR4(JSPUtil.getParameter(request,	prefix + "r4", ""));
		setPeriodEddt(JSPUtil.getParameter(request,	prefix + "period_eddt", ""));
		setR5(JSPUtil.getParameter(request,	prefix + "r5", ""));
		setOth(JSPUtil.getParameter(request,	prefix + "oth", ""));
		setXx(JSPUtil.getParameter(request,	prefix + "xx", ""));
		setOpl(JSPUtil.getParameter(request,	prefix + "opl", ""));
		setLsePayTpCd(JSPUtil.getParameter(request,	prefix + "lse_pay_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setDivOrder(JSPUtil.getParameter(request,	prefix + "div_order", ""));
		setSearchTp(JSPUtil.getParameter(request,	prefix + "search_tp", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ReportSearchPayableVO[]
	 */
	public ReportSearchPayableVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ReportSearchPayableVO[]
	 */
	public ReportSearchPayableVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReportSearchPayableVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] sttl3 =	(JSPUtil.getParameter(request, prefix +	"sttl_3".trim(),	length));
				String[] sttl4 =	(JSPUtil.getParameter(request, prefix +	"sttl_4".trim(),	length));
				String[] lesee =	(JSPUtil.getParameter(request, prefix +	"lesee".trim(),	length));
				String[] sttl1 =	(JSPUtil.getParameter(request, prefix +	"sttl_1".trim(),	length));
				String[] sttl2 =	(JSPUtil.getParameter(request, prefix +	"sttl_2".trim(),	length));
				String[] p4 =	(JSPUtil.getParameter(request, prefix +	"p4".trim(),	length));
				String[] reportType =	(JSPUtil.getParameter(request, prefix +	"report_type".trim(),	length));
				String[] p2 =	(JSPUtil.getParameter(request, prefix +	"p2".trim(),	length));
				String[] sttl5 =	(JSPUtil.getParameter(request, prefix +	"sttl_5".trim(),	length));
				String[] d9 =	(JSPUtil.getParameter(request, prefix +	"d9".trim(),	length));
				String[] d8 =	(JSPUtil.getParameter(request, prefix +	"d8".trim(),	length));
				String[] gto =	(JSPUtil.getParameter(request, prefix +	"gto".trim(),	length));
				String[] d5 =	(JSPUtil.getParameter(request, prefix +	"d5".trim(),	length));
				String[] d4 =	(JSPUtil.getParameter(request, prefix +	"d4".trim(),	length));
				String[] pdm =	(JSPUtil.getParameter(request, prefix +	"pdm".trim(),	length));
				String[] d7 =	(JSPUtil.getParameter(request, prefix +	"d7".trim(),	length));
				String[] periodStdt =	(JSPUtil.getParameter(request, prefix +	"period_stdt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] tysz =	(JSPUtil.getParameter(request, prefix +	"tysz".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] d2 =	(JSPUtil.getParameter(request, prefix +	"d2".trim(),	length));
				String[] costYrmon =	(JSPUtil.getParameter(request, prefix +	"cost_yrmon".trim(),	length));
				String[] d3 =	(JSPUtil.getParameter(request, prefix +	"d3".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] jan =	(JSPUtil.getParameter(request, prefix +	"jan".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] dpp =	(JSPUtil.getParameter(request, prefix +	"dpp".trim(),	length));
				String[] lon =	(JSPUtil.getParameter(request, prefix +	"lon".trim(),	length));
				String[] q2 =	(JSPUtil.getParameter(request, prefix +	"q2".trim(),	length));
				String[] status =	(JSPUtil.getParameter(request, prefix +	"status".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] q4 =	(JSPUtil.getParameter(request, prefix +	"q4".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] receivable =	(JSPUtil.getParameter(request, prefix +	"receivable".trim(),	length));
				String[] pcr =	(JSPUtil.getParameter(request, prefix +	"pcr".trim(),	length));
				String[] qty =	(JSPUtil.getParameter(request, prefix +	"qty".trim(),	length));
				String[] lof =	(JSPUtil.getParameter(request, prefix +	"lof".trim(),	length));
				String[] puc =	(JSPUtil.getParameter(request, prefix +	"puc".trim(),	length));
				String[] periodYear =	(JSPUtil.getParameter(request, prefix +	"period_year".trim(),	length));
				String[] oct =	(JSPUtil.getParameter(request, prefix +	"oct".trim(),	length));
				String[] feb =	(JSPUtil.getParameter(request, prefix +	"feb".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] nov =	(JSPUtil.getParameter(request, prefix +	"nov".trim(),	length));
				String[] gti =	(JSPUtil.getParameter(request, prefix +	"gti".trim(),	length));
				String[] company =	(JSPUtil.getParameter(request, prefix +	"company".trim(),	length));
				String[] t4 =	(JSPUtil.getParameter(request, prefix +	"t4".trim(),	length));
				String[] t2 =	(JSPUtil.getParameter(request, prefix +	"t2".trim(),	length));
				String[] payable =	(JSPUtil.getParameter(request, prefix +	"payable".trim(),	length));
				String[] dw =	(JSPUtil.getParameter(request, prefix +	"dw".trim(),	length));
				String[] dx =	(JSPUtil.getParameter(request, prefix +	"dx".trim(),	length));
				String[] abbrNm =	(JSPUtil.getParameter(request, prefix +	"abbr_nm".trim(),	length));
				String[] div =	(JSPUtil.getParameter(request, prefix +	"div".trim(),	length));
				String[] gTtl =	(JSPUtil.getParameter(request, prefix +	"g_ttl".trim(),	length));
				String[] crd =	(JSPUtil.getParameter(request, prefix +	"crd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] dio =	(JSPUtil.getParameter(request, prefix +	"dio".trim(),	length));
				String[] dec =	(JSPUtil.getParameter(request, prefix +	"dec".trim(),	length));
				String[] chargeTypeCd =	(JSPUtil.getParameter(request, prefix +	"charge_type_cd".trim(),	length));
				String[] ttl5 =	(JSPUtil.getParameter(request, prefix +	"ttl_5".trim(),	length));
				String[] ttl4 =	(JSPUtil.getParameter(request, prefix +	"ttl_4".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] ttl3 =	(JSPUtil.getParameter(request, prefix +	"ttl_3".trim(),	length));
				String[] a2 =	(JSPUtil.getParameter(request, prefix +	"a2".trim(),	length));
				String[] ttl2 =	(JSPUtil.getParameter(request, prefix +	"ttl_2".trim(),	length));
				String[] mar =	(JSPUtil.getParameter(request, prefix +	"mar".trim(),	length));
				String[] ttl1 =	(JSPUtil.getParameter(request, prefix +	"ttl_1".trim(),	length));
				String[] a4 =	(JSPUtil.getParameter(request, prefix +	"a4".trim(),	length));
				String[] dii =	(JSPUtil.getParameter(request, prefix +	"dii".trim(),	length));
				String[] f2 =	(JSPUtil.getParameter(request, prefix +	"f2".trim(),	length));
				String[] f5 =	(JSPUtil.getParameter(request, prefix +	"f5".trim(),	length));
				String[] f4 =	(JSPUtil.getParameter(request, prefix +	"f4".trim(),	length));
				String[] s4 =	(JSPUtil.getParameter(request, prefix +	"s4".trim(),	length));
				String[] locTp =	(JSPUtil.getParameter(request, prefix +	"loc_tp".trim(),	length));
				String[] may =	(JSPUtil.getParameter(request, prefix +	"may".trim(),	length));
				String[] o2 =	(JSPUtil.getParameter(request, prefix +	"o2".trim(),	length));
				String[] s2 =	(JSPUtil.getParameter(request, prefix +	"s2".trim(),	length));
				String[] apr =	(JSPUtil.getParameter(request, prefix +	"apr".trim(),	length));
				String[] o4 =	(JSPUtil.getParameter(request, prefix +	"o4".trim(),	length));
				String[] jul =	(JSPUtil.getParameter(request, prefix +	"jul".trim(),	length));
				String[] jun =	(JSPUtil.getParameter(request, prefix +	"jun".trim(),	length));
				String[] dcr =	(JSPUtil.getParameter(request, prefix +	"dcr".trim(),	length));
				String[] doc =	(JSPUtil.getParameter(request, prefix +	"doc".trim(),	length));
				String[] sep =	(JSPUtil.getParameter(request, prefix +	"sep".trim(),	length));
				String[] r7 =	(JSPUtil.getParameter(request, prefix +	"r7".trim(),	length));
				String[] aug =	(JSPUtil.getParameter(request, prefix +	"aug".trim(),	length));
				String[] wdp =	(JSPUtil.getParameter(request, prefix +	"wdp".trim(),	length));
				String[] chargeType =	(JSPUtil.getParameter(request, prefix +	"charge_type".trim(),	length));
				String[] r2 =	(JSPUtil.getParameter(request, prefix +	"r2".trim(),	length));
				String[] r4 =	(JSPUtil.getParameter(request, prefix +	"r4".trim(),	length));
				String[] periodEddt =	(JSPUtil.getParameter(request, prefix +	"period_eddt".trim(),	length));
				String[] r5 =	(JSPUtil.getParameter(request, prefix +	"r5".trim(),	length));
				String[] oth =	(JSPUtil.getParameter(request, prefix +	"oth".trim(),	length));
				String[] xx =	(JSPUtil.getParameter(request, prefix +	"xx".trim(),	length));
				String[] opl =	(JSPUtil.getParameter(request, prefix +	"opl".trim(),	length));
				String[] lsePayTpCd =	(JSPUtil.getParameter(request, prefix +	"lse_pay_tp_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] divOrder =	(JSPUtil.getParameter(request, prefix +	"div_order".trim(),	length));
				String[] searchTp =	(JSPUtil.getParameter(request, prefix +	"search_tp".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReportSearchPayableVO();
						if ( sttl3[i] !=	null)
						model.setSttl3( sttl3[i]);
						if ( sttl4[i] !=	null)
						model.setSttl4( sttl4[i]);
						if ( lesee[i] !=	null)
						model.setLesee( lesee[i]);
						if ( sttl1[i] !=	null)
						model.setSttl1( sttl1[i]);
						if ( sttl2[i] !=	null)
						model.setSttl2( sttl2[i]);
						if ( p4[i] !=	null)
						model.setP4( p4[i]);
						if ( reportType[i] !=	null)
						model.setReportType( reportType[i]);
						if ( p2[i] !=	null)
						model.setP2( p2[i]);
						if ( sttl5[i] !=	null)
						model.setSttl5( sttl5[i]);
						if ( d9[i] !=	null)
						model.setD9( d9[i]);
						if ( d8[i] !=	null)
						model.setD8( d8[i]);
						if ( gto[i] !=	null)
						model.setGto( gto[i]);
						if ( d5[i] !=	null)
						model.setD5( d5[i]);
						if ( d4[i] !=	null)
						model.setD4( d4[i]);
						if ( pdm[i] !=	null)
						model.setPdm( pdm[i]);
						if ( d7[i] !=	null)
						model.setD7( d7[i]);
						if ( periodStdt[i] !=	null)
						model.setPeriodStdt( periodStdt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( tysz[i] !=	null)
						model.setTysz( tysz[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( d2[i] !=	null)
						model.setD2( d2[i]);
						if ( costYrmon[i] !=	null)
						model.setCostYrmon( costYrmon[i]);
						if ( d3[i] !=	null)
						model.setD3( d3[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( jan[i] !=	null)
						model.setJan( jan[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( dpp[i] !=	null)
						model.setDpp( dpp[i]);
						if ( lon[i] !=	null)
						model.setLon( lon[i]);
						if ( q2[i] !=	null)
						model.setQ2( q2[i]);
						if ( status[i] !=	null)
						model.setStatus( status[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( q4[i] !=	null)
						model.setQ4( q4[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( receivable[i] !=	null)
						model.setReceivable( receivable[i]);
						if ( pcr[i] !=	null)
						model.setPcr( pcr[i]);
						if ( qty[i] !=	null)
						model.setQty( qty[i]);
						if ( lof[i] !=	null)
						model.setLof( lof[i]);
						if ( puc[i] !=	null)
						model.setPuc( puc[i]);
						if ( periodYear[i] !=	null)
						model.setPeriodYear( periodYear[i]);
						if ( oct[i] !=	null)
						model.setOct( oct[i]);
						if ( feb[i] !=	null)
						model.setFeb( feb[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( nov[i] !=	null)
						model.setNov( nov[i]);
						if ( gti[i] !=	null)
						model.setGti( gti[i]);
						if ( company[i] !=	null)
						model.setCompany( company[i]);
						if ( t4[i] !=	null)
						model.setT4( t4[i]);
						if ( t2[i] !=	null)
						model.setT2( t2[i]);
						if ( payable[i] !=	null)
						model.setPayable( payable[i]);
						if ( dw[i] !=	null)
						model.setDw( dw[i]);
						if ( dx[i] !=	null)
						model.setDx( dx[i]);
						if ( abbrNm[i] !=	null)
						model.setAbbrNm( abbrNm[i]);
						if ( div[i] !=	null)
						model.setDiv( div[i]);
						if ( gTtl[i] !=	null)
						model.setGTtl( gTtl[i]);
						if ( crd[i] !=	null)
						model.setCrd( crd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( dio[i] !=	null)
						model.setDio( dio[i]);
						if ( dec[i] !=	null)
						model.setDec( dec[i]);
						if ( chargeTypeCd[i] !=	null)
						model.setChargeTypeCd( chargeTypeCd[i]);
						if ( ttl5[i] !=	null)
						model.setTtl5( ttl5[i]);
						if ( ttl4[i] !=	null)
						model.setTtl4( ttl4[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( ttl3[i] !=	null)
						model.setTtl3( ttl3[i]);
						if ( a2[i] !=	null)
						model.setA2( a2[i]);
						if ( ttl2[i] !=	null)
						model.setTtl2( ttl2[i]);
						if ( mar[i] !=	null)
						model.setMar( mar[i]);
						if ( ttl1[i] !=	null)
						model.setTtl1( ttl1[i]);
						if ( a4[i] !=	null)
						model.setA4( a4[i]);
						if ( dii[i] !=	null)
						model.setDii( dii[i]);
						if ( f2[i] !=	null)
						model.setF2( f2[i]);
						if ( f5[i] !=	null)
						model.setF5( f5[i]);
						if ( f4[i] !=	null)
						model.setF4( f4[i]);
						if ( s4[i] !=	null)
						model.setS4( s4[i]);
						if ( locTp[i] !=	null)
						model.setLocTp( locTp[i]);
						if ( may[i] !=	null)
						model.setMay( may[i]);
						if ( o2[i] !=	null)
						model.setO2( o2[i]);
						if ( s2[i] !=	null)
						model.setS2( s2[i]);
						if ( apr[i] !=	null)
						model.setApr( apr[i]);
						if ( o4[i] !=	null)
						model.setO4( o4[i]);
						if ( jul[i] !=	null)
						model.setJul( jul[i]);
						if ( jun[i] !=	null)
						model.setJun( jun[i]);
						if ( dcr[i] !=	null)
						model.setDcr( dcr[i]);
						if ( doc[i] !=	null)
						model.setDoc( doc[i]);
						if ( sep[i] !=	null)
						model.setSep( sep[i]);
						if ( r7[i] !=	null)
						model.setR7( r7[i]);
						if ( aug[i] !=	null)
						model.setAug( aug[i]);
						if ( wdp[i] !=	null)
						model.setWdp( wdp[i]);
						if ( chargeType[i] !=	null)
						model.setChargeType( chargeType[i]);
						if ( r2[i] !=	null)
						model.setR2( r2[i]);
						if ( r4[i] !=	null)
						model.setR4( r4[i]);
						if ( periodEddt[i] !=	null)
						model.setPeriodEddt( periodEddt[i]);
						if ( r5[i] !=	null)
						model.setR5( r5[i]);
						if ( oth[i] !=	null)
						model.setOth( oth[i]);
						if ( xx[i] !=	null)
						model.setXx( xx[i]);
						if ( opl[i] !=	null)
						model.setOpl( opl[i]);
						if ( lsePayTpCd[i] !=	null)
						model.setLsePayTpCd( lsePayTpCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( divOrder[i] !=	null)
						model.setDivOrder( divOrder[i]);
						if ( searchTp[i] !=	null)
						model.setSearchTp( searchTp[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReportSearchPayableVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ReportSearchPayableVO[]
	 */
	public ReportSearchPayableVO[]	 getReportSearchPayableVOs(){
		ReportSearchPayableVO[] vos = (ReportSearchPayableVO[])models.toArray(new	ReportSearchPayableVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.sttl3 =	this.sttl3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl4 =	this.sttl4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lesee =	this.lesee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl1 =	this.sttl1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl2 =	this.sttl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 =	this.p4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType =	this.reportType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 =	this.p2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttl5 =	this.sttl5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 =	this.d9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 =	this.d8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gto =	this.gto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 =	this.d5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 =	this.d4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdm =	this.pdm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 =	this.d7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt =	this.periodStdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz =	this.tysz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 =	this.d2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon =	this.costYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d3 =	this.d3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jan =	this.jan.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpp =	this.dpp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lon =	this.lon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q2 =	this.q2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status =	this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q4 =	this.q4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receivable =	this.receivable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcr =	this.pcr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty =	this.qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lof =	this.lof.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.puc =	this.puc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodYear =	this.periodYear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oct =	this.oct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feb =	this.feb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nov =	this.nov.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gti =	this.gti.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company =	this.company.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 =	this.t4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 =	this.t2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payable =	this.payable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw =	this.dw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx =	this.dx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm =	this.abbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div =	this.div.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTtl =	this.gTtl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crd =	this.crd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dio =	this.dio.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dec =	this.dec.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeTypeCd =	this.chargeTypeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl5 =	this.ttl5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl4 =	this.ttl4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl3 =	this.ttl3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 =	this.a2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl2 =	this.ttl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mar =	this.mar.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl1 =	this.ttl1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 =	this.a4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dii =	this.dii.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 =	this.f2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 =	this.f5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 =	this.f4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 =	this.s4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp =	this.locTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.may =	this.may.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 =	this.o2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 =	this.s2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apr =	this.apr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 =	this.o4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jul =	this.jul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jun =	this.jun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcr =	this.dcr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc =	this.doc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sep =	this.sep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7 =	this.r7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aug =	this.aug.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdp =	this.wdp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeType =	this.chargeType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 =	this.r2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 =	this.r4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt =	this.periodEddt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 =	this.r5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth =	this.oth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xx =	this.xx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opl =	this.opl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTpCd =	this.lsePayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divOrder =	this.divOrder.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTp =	this.searchTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}