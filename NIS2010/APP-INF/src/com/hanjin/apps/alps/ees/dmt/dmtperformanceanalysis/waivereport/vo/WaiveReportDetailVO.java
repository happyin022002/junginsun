/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WaiveReportDetailVO.java
*@FileTitle : WaiveReportDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.02.23 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WaiveReportDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WaiveReportDetailVO> models = new ArrayList<WaiveReportDetailVO>();
	
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String office1 = null;
	/* Column Info */
	private String incurred = null;
	/* Column Info */
	private String dcamt = null;
	/* Column Info */
	private String ofcrhqcd = null;
	/* Column Info */
	private String office2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String billable = null;
	/* Column Info */
	private String gb = null;
	/* Column Info */
	private String ftend = null;
	/* Column Info */
	private String fm = null;
	/* Column Info */
	private String exceptionn = null;
	/* Column Info */
	private String over = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String date2 = null;
	/* Column Info */
	private String ft = null;
	/* Column Info */
	private String date1 = null;
	/* Column Info */
	private String darapprno = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String ftcmnc = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String ctrtofc = null;
	/* Column Info */
	private String divcd = null;
	/* Column Info */
	private String invoiced = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String grpid = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String issdt = null;
	/* Column Info */
	private String dmtofc = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String fromyard = null;
	/* Column Info */
	private String lane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String invno = null;
	/* Column Info */
	private String fromdate = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String too = null;
	/* Column Info */
	private String custname = null;
	/* Column Info */
	private String d = null;
	/* Column Info */
	private String cur2 = null;
	/* Column Info */
	private String blno = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String ar = null;
	/* Column Info */
	private String toyard = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String chgseq = null;
	/* Column Info */
	private String r = null;
	/* Column Info */
	private String custcode = null;
	/* Column Info */
	private String cycno = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String name1 = null;
	/* Column Info */
	private String name2 = null;
	/* Column Info */
	private String rfano = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WaiveReportDetailVO() {}

	public WaiveReportDetailVO(String ibflag, String pagerows, String ts, String por, String office1, String incurred, String dcamt, String office2, String billable, String gb, String ftend, String exceptionn, String over, String fm, String pol, String date2, String ft, String darapprno, String date1, String ftcmnc, String pod, String ctrtofc, String bkgno, String divcd, String invoiced, String vvd, String grpid, String sts, String issdt, String dmtofc, String todate, String fromyard, String lane, String tariff, String invno, String fromdate, String del, String too, String custname, String d, String cur2, String blno, String cntrno, String ar, String toyard, String scno, String chgseq, String r, String cycno, String custcode, String cur, String name1, String name2, String rfano, String ofcrhqcd) {
		this.ts = ts;
		this.por = por;
		this.office1 = office1;
		this.incurred = incurred;
		this.dcamt = dcamt;
		this.ofcrhqcd = ofcrhqcd;
		this.office2 = office2;
		this.pagerows = pagerows;
		this.billable = billable;
		this.gb = gb;
		this.ftend = ftend;
		this.fm = fm;
		this.exceptionn = exceptionn;
		this.over = over;
		this.pol = pol;
		this.date2 = date2;
		this.ft = ft;
		this.date1 = date1;
		this.darapprno = darapprno;
		this.pod = pod;
		this.ftcmnc = ftcmnc;
		this.bkgno = bkgno;
		this.ctrtofc = ctrtofc;
		this.divcd = divcd;
		this.invoiced = invoiced;
		this.vvd = vvd;
		this.grpid = grpid;
		this.sts = sts;
		this.issdt = issdt;
		this.dmtofc = dmtofc;
		this.todate = todate;
		this.fromyard = fromyard;
		this.lane = lane;
		this.ibflag = ibflag;
		this.tariff = tariff;
		this.invno = invno;
		this.fromdate = fromdate;
		this.del = del;
		this.too = too;
		this.custname = custname;
		this.d = d;
		this.cur2 = cur2;
		this.blno = blno;
		this.cntrno = cntrno;
		this.ar = ar;
		this.toyard = toyard;
		this.scno = scno;
		this.chgseq = chgseq;
		this.r = r;
		this.custcode = custcode;
		this.cycno = cycno;
		this.cur = cur;
		this.name1 = name1;
		this.name2 = name2;
		this.rfano = rfano;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("office1", getOffice1());
		this.hashColumns.put("incurred", getIncurred());
		this.hashColumns.put("dcamt", getDcamt());
		this.hashColumns.put("ofcrhqcd", getOfcrhqcd());
		this.hashColumns.put("office2", getOffice2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("billable", getBillable());
		this.hashColumns.put("gb", getGb());
		this.hashColumns.put("ftend", getFtend());
		this.hashColumns.put("fm", getFm());
		this.hashColumns.put("exceptionn", getExceptionn());
		this.hashColumns.put("over", getOver());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("date2", getDate2());
		this.hashColumns.put("ft", getFt());
		this.hashColumns.put("date1", getDate1());
		this.hashColumns.put("darapprno", getDarapprno());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("ftcmnc", getFtcmnc());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("ctrtofc", getCtrtofc());
		this.hashColumns.put("divcd", getDivcd());
		this.hashColumns.put("invoiced", getInvoiced());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("grpid", getGrpid());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("issdt", getIssdt());
		this.hashColumns.put("dmtofc", getDmtofc());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("fromyard", getFromyard());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("invno", getInvno());
		this.hashColumns.put("fromdate", getFromdate());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("too", getToo());
		this.hashColumns.put("custname", getCustname());
		this.hashColumns.put("d", getD());
		this.hashColumns.put("cur2", getCur2());
		this.hashColumns.put("blno", getBlno());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("ar", getAr());
		this.hashColumns.put("toyard", getToyard());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("chgseq", getChgseq());
		this.hashColumns.put("r", getR());
		this.hashColumns.put("custcode", getCustcode());
		this.hashColumns.put("cycno", getCycno());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("name1", getName1());
		this.hashColumns.put("name2", getName2());
		this.hashColumns.put("rfano", getRfano());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts", "ts");
		this.hashFields.put("por", "por");
		this.hashFields.put("office1", "office1");
		this.hashFields.put("incurred", "incurred");
		this.hashFields.put("dcamt", "dcamt");
		this.hashFields.put("ofcrhqcd", "ofcrhqcd");
		this.hashFields.put("office2", "office2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("billable", "billable");
		this.hashFields.put("gb", "gb");
		this.hashFields.put("ftend", "ftend");
		this.hashFields.put("fm", "fm");
		this.hashFields.put("exceptionn", "exceptionn");
		this.hashFields.put("over", "over");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("date2", "date2");
		this.hashFields.put("ft", "ft");
		this.hashFields.put("date1", "date1");
		this.hashFields.put("darapprno", "darapprno");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("ftcmnc", "ftcmnc");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("ctrtofc", "ctrtofc");
		this.hashFields.put("divcd", "divcd");
		this.hashFields.put("invoiced", "invoiced");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("grpid", "grpid");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("issdt", "issdt");
		this.hashFields.put("dmtofc", "dmtofc");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("fromyard", "fromyard");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("invno", "invno");
		this.hashFields.put("fromdate", "fromdate");
		this.hashFields.put("del", "del");
		this.hashFields.put("too", "too");
		this.hashFields.put("custname", "custname");
		this.hashFields.put("d", "d");
		this.hashFields.put("cur2", "cur2");
		this.hashFields.put("blno", "blno");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("ar", "ar");
		this.hashFields.put("toyard", "toyard");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("chgseq", "chgseq");
		this.hashFields.put("r", "r");
		this.hashFields.put("custcode", "custcode");
		this.hashFields.put("cycno", "cycno");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("name1", "name1");
		this.hashFields.put("name2", "name2");
		this.hashFields.put("rfano", "rfano");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return office1
	 */
	public String getOffice1() {
		return this.office1;
	}
	
	/**
	 * Column Info
	 * @return incurred
	 */
	public String getIncurred() {
		return this.incurred;
	}
	
	/**
	 * Column Info
	 * @return dcamt
	 */
	public String getDcamt() {
		return this.dcamt;
	}
	
	/**
	 * Column Info
	 * @return ofcrhqcd
	 */
	public String getOfcrhqcd() {
		return this.ofcrhqcd;
	}
	
	/**
	 * Column Info
	 * @return office2
	 */
	public String getOffice2() {
		return this.office2;
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
	 * @return billable
	 */
	public String getBillable() {
		return this.billable;
	}
	
	/**
	 * Column Info
	 * @return gb
	 */
	public String getGb() {
		return this.gb;
	}
	
	/**
	 * Column Info
	 * @return ftend
	 */
	public String getFtend() {
		return this.ftend;
	}
	
	/**
	 * Column Info
	 * @return fm
	 */
	public String getFm() {
		return this.fm;
	}
	
	/**
	 * Column Info
	 * @return exceptionn
	 */
	public String getExceptionn() {
		return this.exceptionn;
	}
	
	/**
	 * Column Info
	 * @return over
	 */
	public String getOver() {
		return this.over;
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
	 * @return date2
	 */
	public String getDate2() {
		return this.date2;
	}
	
	/**
	 * Column Info
	 * @return ft
	 */
	public String getFt() {
		return this.ft;
	}
	
	/**
	 * Column Info
	 * @return date1
	 */
	public String getDate1() {
		return this.date1;
	}
	
	/**
	 * Column Info
	 * @return darapprno
	 */
	public String getDarapprno() {
		return this.darapprno;
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
	 * @return ftcmnc
	 */
	public String getFtcmnc() {
		return this.ftcmnc;
	}
	
	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return ctrtofc
	 */
	public String getCtrtofc() {
		return this.ctrtofc;
	}
	
	/**
	 * Column Info
	 * @return divcd
	 */
	public String getDivcd() {
		return this.divcd;
	}
	
	/**
	 * Column Info
	 * @return invoiced
	 */
	public String getInvoiced() {
		return this.invoiced;
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
	 * @return grpid
	 */
	public String getGrpid() {
		return this.grpid;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return issdt
	 */
	public String getIssdt() {
		return this.issdt;
	}
	
	/**
	 * Column Info
	 * @return dmtofc
	 */
	public String getDmtofc() {
		return this.dmtofc;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return fromyard
	 */
	public String getFromyard() {
		return this.fromyard;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 * Column Info
	 * @return invno
	 */
	public String getInvno() {
		return this.invno;
	}
	
	/**
	 * Column Info
	 * @return fromdate
	 */
	public String getFromdate() {
		return this.fromdate;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return too
	 */
	public String getToo() {
		return this.too;
	}
	
	/**
	 * Column Info
	 * @return custname
	 */
	public String getCustname() {
		return this.custname;
	}
	
	/**
	 * Column Info
	 * @return d
	 */
	public String getD() {
		return this.d;
	}
	
	/**
	 * Column Info
	 * @return cur2
	 */
	public String getCur2() {
		return this.cur2;
	}
	
	/**
	 * Column Info
	 * @return blno
	 */
	public String getBlno() {
		return this.blno;
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
	 * @return ar
	 */
	public String getAr() {
		return this.ar;
	}
	
	/**
	 * Column Info
	 * @return toyard
	 */
	public String getToyard() {
		return this.toyard;
	}
	
	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 * Column Info
	 * @return chgseq
	 */
	public String getChgseq() {
		return this.chgseq;
	}
	
	/**
	 * Column Info
	 * @return r
	 */
	public String getR() {
		return this.r;
	}
	
	/**
	 * Column Info
	 * @return custcode
	 */
	public String getCustcode() {
		return this.custcode;
	}
	
	/**
	 * Column Info
	 * @return cycno
	 */
	public String getCycno() {
		return this.cycno;
	}
	
	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return name1
	 */
	public String getName1() {
		return this.name1;
	}
	
	/**
	 * Column Info
	 * @return name2
	 */
	public String getName2() {
		return this.name2;
	}
	
	/**
	 * Column Info
	 * @return rfano
	 */
	public String getRfano() {
		return this.rfano;
	}
	

	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param office1
	 */
	public void setOffice1(String office1) {
		this.office1 = office1;
	}
	
	/**
	 * Column Info
	 * @param incurred
	 */
	public void setIncurred(String incurred) {
		this.incurred = incurred;
	}
	
	/**
	 * Column Info
	 * @param dcamt
	 */
	public void setDcamt(String dcamt) {
		this.dcamt = dcamt;
	}
	
	/**
	 * Column Info
	 * @param ofcrhqcd
	 */
	public void setOfcrhqcd(String ofcrhqcd) {
		this.ofcrhqcd = ofcrhqcd;
	}
	
	/**
	 * Column Info
	 * @param office2
	 */
	public void setOffice2(String office2) {
		this.office2 = office2;
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
	 * @param billable
	 */
	public void setBillable(String billable) {
		this.billable = billable;
	}
	
	/**
	 * Column Info
	 * @param gb
	 */
	public void setGb(String gb) {
		this.gb = gb;
	}
	
	/**
	 * Column Info
	 * @param ftend
	 */
	public void setFtend(String ftend) {
		this.ftend = ftend;
	}
	
	/**
	 * Column Info
	 * @param fm
	 */
	public void setFm(String fm) {
		this.fm = fm;
	}
	
	/**
	 * Column Info
	 * @param exceptionn
	 */
	public void setExceptionn(String exceptionn) {
		this.exceptionn = exceptionn;
	}
	
	/**
	 * Column Info
	 * @param over
	 */
	public void setOver(String over) {
		this.over = over;
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
	 * @param date2
	 */
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	/**
	 * Column Info
	 * @param ft
	 */
	public void setFt(String ft) {
		this.ft = ft;
	}
	
	/**
	 * Column Info
	 * @param date1
	 */
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	/**
	 * Column Info
	 * @param darapprno
	 */
	public void setDarapprno(String darapprno) {
		this.darapprno = darapprno;
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
	 * @param ftcmnc
	 */
	public void setFtcmnc(String ftcmnc) {
		this.ftcmnc = ftcmnc;
	}
	
	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param ctrtofc
	 */
	public void setCtrtofc(String ctrtofc) {
		this.ctrtofc = ctrtofc;
	}
	
	/**
	 * Column Info
	 * @param divcd
	 */
	public void setDivcd(String divcd) {
		this.divcd = divcd;
	}
	
	/**
	 * Column Info
	 * @param invoiced
	 */
	public void setInvoiced(String invoiced) {
		this.invoiced = invoiced;
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
	 * @param grpid
	 */
	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param issdt
	 */
	public void setIssdt(String issdt) {
		this.issdt = issdt;
	}
	
	/**
	 * Column Info
	 * @param dmtofc
	 */
	public void setDmtofc(String dmtofc) {
		this.dmtofc = dmtofc;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param fromyard
	 */
	public void setFromyard(String fromyard) {
		this.fromyard = fromyard;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Column Info
	 * @param invno
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	
	/**
	 * Column Info
	 * @param fromdate
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param too
	 */
	public void setToo(String too) {
		this.too = too;
	}
	
	/**
	 * Column Info
	 * @param custname
	 */
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	/**
	 * Column Info
	 * @param d
	 */
	public void setD(String d) {
		this.d = d;
	}
	
	/**
	 * Column Info
	 * @param cur2
	 */
	public void setCur2(String cur2) {
		this.cur2 = cur2;
	}
	
	/**
	 * Column Info
	 * @param blno
	 */
	public void setBlno(String blno) {
		this.blno = blno;
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
	 * @param ar
	 */
	public void setAr(String ar) {
		this.ar = ar;
	}
	
	/**
	 * Column Info
	 * @param toyard
	 */
	public void setToyard(String toyard) {
		this.toyard = toyard;
	}
	
	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * Column Info
	 * @param chgseq
	 */
	public void setChgseq(String chgseq) {
		this.chgseq = chgseq;
	}
	
	/**
	 * Column Info
	 * @param r
	 */
	public void setR(String r) {
		this.r = r;
	}
	
	/**
	 * Column Info
	 * @param custcode
	 */
	public void setCustcode(String custcode) {
		this.custcode = custcode;
	}
	
	/**
	 * Column Info
	 * @param cycno
	 */
	public void setCycno(String cycno) {
		this.cycno = cycno;
	}
	
	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param name1
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}
	
	/**
	 * Column Info
	 * @param name2
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	/**
	 * Column Info
	 * @param rfano
	 */
	public void setRfano(String rfano) {
		this.rfano = rfano;
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
		setTs(JSPUtil.getParameter(request, prefix + "ts", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setOffice1(JSPUtil.getParameter(request, prefix + "office1", ""));
		setIncurred(JSPUtil.getParameter(request, prefix + "incurred", ""));
		setDcamt(JSPUtil.getParameter(request, prefix + "dcamt", ""));
		setOfcrhqcd(JSPUtil.getParameter(request, prefix + "ofcrhqcd", ""));
		setOffice2(JSPUtil.getParameter(request, prefix + "office2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBillable(JSPUtil.getParameter(request, prefix + "billable", ""));
		setGb(JSPUtil.getParameter(request, prefix + "gb", ""));
		setFtend(JSPUtil.getParameter(request, prefix + "ftend", ""));
		setFm(JSPUtil.getParameter(request, prefix + "fm", ""));
		setExceptionn(JSPUtil.getParameter(request, prefix + "exceptionn", ""));
		setOver(JSPUtil.getParameter(request, prefix + "over", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setDate2(JSPUtil.getParameter(request, prefix + "date2", ""));
		setFt(JSPUtil.getParameter(request, prefix + "ft", ""));
		setDate1(JSPUtil.getParameter(request, prefix + "date1", ""));
		setDarapprno(JSPUtil.getParameter(request, prefix + "darapprno", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setFtcmnc(JSPUtil.getParameter(request, prefix + "ftcmnc", ""));
		setBkgno(JSPUtil.getParameter(request, prefix + "bkgno", ""));
		setCtrtofc(JSPUtil.getParameter(request, prefix + "ctrtofc", ""));
		setDivcd(JSPUtil.getParameter(request, prefix + "divcd", ""));
		setInvoiced(JSPUtil.getParameter(request, prefix + "invoiced", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setGrpid(JSPUtil.getParameter(request, prefix + "grpid", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setIssdt(JSPUtil.getParameter(request, prefix + "issdt", ""));
		setDmtofc(JSPUtil.getParameter(request, prefix + "dmtofc", ""));
		setTodate(JSPUtil.getParameter(request, prefix + "todate", ""));
		setFromyard(JSPUtil.getParameter(request, prefix + "fromyard", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTariff(JSPUtil.getParameter(request, prefix + "tariff", ""));
		setInvno(JSPUtil.getParameter(request, prefix + "invno", ""));
		setFromdate(JSPUtil.getParameter(request, prefix + "fromdate", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setToo(JSPUtil.getParameter(request, prefix + "too", ""));
		setCustname(JSPUtil.getParameter(request, prefix + "custname", ""));
		setD(JSPUtil.getParameter(request, prefix + "d", ""));
		setCur2(JSPUtil.getParameter(request, prefix + "cur2", ""));
		setBlno(JSPUtil.getParameter(request, prefix + "blno", ""));
		setCntrno(JSPUtil.getParameter(request, prefix + "cntrno", ""));
		setAr(JSPUtil.getParameter(request, prefix + "ar", ""));
		setToyard(JSPUtil.getParameter(request, prefix + "toyard", ""));
		setScno(JSPUtil.getParameter(request, prefix + "scno", ""));
		setChgseq(JSPUtil.getParameter(request, prefix + "chgseq", ""));
		setR(JSPUtil.getParameter(request, prefix + "r", ""));
		setCustcode(JSPUtil.getParameter(request, prefix + "custcode", ""));
		setCycno(JSPUtil.getParameter(request, prefix + "cycno", ""));
		setCur(JSPUtil.getParameter(request, prefix + "cur", ""));
		setName1(JSPUtil.getParameter(request, prefix + "name1", ""));
		setName2(JSPUtil.getParameter(request, prefix + "name2", ""));
		setRfano(JSPUtil.getParameter(request, prefix + "rfano", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WaiveReportDetailVO[]
	 */
	public WaiveReportDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WaiveReportDetailVO[]
	 */
	public WaiveReportDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WaiveReportDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] office1 = (JSPUtil.getParameter(request, prefix	+ "office1", length));
			String[] incurred = (JSPUtil.getParameter(request, prefix	+ "incurred", length));
			String[] dcamt = (JSPUtil.getParameter(request, prefix	+ "dcamt", length));
			String[] ofcrhqcd = (JSPUtil.getParameter(request, prefix	+ "ofcrhqcd", length));
			String[] office2 = (JSPUtil.getParameter(request, prefix	+ "office2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] billable = (JSPUtil.getParameter(request, prefix	+ "billable", length));
			String[] gb = (JSPUtil.getParameter(request, prefix	+ "gb", length));
			String[] ftend = (JSPUtil.getParameter(request, prefix	+ "ftend", length));
			String[] fm = (JSPUtil.getParameter(request, prefix	+ "fm", length));
			String[] exceptionn = (JSPUtil.getParameter(request, prefix	+ "exceptionn", length));
			String[] over = (JSPUtil.getParameter(request, prefix	+ "over", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] date2 = (JSPUtil.getParameter(request, prefix	+ "date2", length));
			String[] ft = (JSPUtil.getParameter(request, prefix	+ "ft", length));
			String[] date1 = (JSPUtil.getParameter(request, prefix	+ "date1", length));
			String[] darapprno = (JSPUtil.getParameter(request, prefix	+ "darapprno", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] ftcmnc = (JSPUtil.getParameter(request, prefix	+ "ftcmnc", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] ctrtofc = (JSPUtil.getParameter(request, prefix	+ "ctrtofc", length));
			String[] divcd = (JSPUtil.getParameter(request, prefix	+ "divcd", length));
			String[] invoiced = (JSPUtil.getParameter(request, prefix	+ "invoiced", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] grpid = (JSPUtil.getParameter(request, prefix	+ "grpid", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] issdt = (JSPUtil.getParameter(request, prefix	+ "issdt", length));
			String[] dmtofc = (JSPUtil.getParameter(request, prefix	+ "dmtofc", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] fromyard = (JSPUtil.getParameter(request, prefix	+ "fromyard", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] invno = (JSPUtil.getParameter(request, prefix	+ "invno", length));
			String[] fromdate = (JSPUtil.getParameter(request, prefix	+ "fromdate", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] too = (JSPUtil.getParameter(request, prefix	+ "too", length));
			String[] custname = (JSPUtil.getParameter(request, prefix	+ "custname", length));
			String[] d = (JSPUtil.getParameter(request, prefix	+ "d", length));
			String[] cur2 = (JSPUtil.getParameter(request, prefix	+ "cur2", length));
			String[] blno = (JSPUtil.getParameter(request, prefix	+ "blno", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] ar = (JSPUtil.getParameter(request, prefix	+ "ar", length));
			String[] toyard = (JSPUtil.getParameter(request, prefix	+ "toyard", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] chgseq = (JSPUtil.getParameter(request, prefix	+ "chgseq", length));
			String[] r = (JSPUtil.getParameter(request, prefix	+ "r", length));
			String[] custcode = (JSPUtil.getParameter(request, prefix	+ "custcode", length));
			String[] cycno = (JSPUtil.getParameter(request, prefix	+ "cycno", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] name1 = (JSPUtil.getParameter(request, prefix	+ "name1", length));
			String[] name2 = (JSPUtil.getParameter(request, prefix	+ "name2", length));
			String[] rfano = (JSPUtil.getParameter(request, prefix	+ "rfano", length));
			
			for (int i = 0; i < length; i++) {
				model = new WaiveReportDetailVO();
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (office1[i] != null)
					model.setOffice1(office1[i]);
				if (incurred[i] != null)
					model.setIncurred(incurred[i]);
				if (dcamt[i] != null)
					model.setDcamt(dcamt[i]);
				if (ofcrhqcd[i] != null)
					model.setOfcrhqcd(ofcrhqcd[i]);
				if (office2[i] != null)
					model.setOffice2(office2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (billable[i] != null)
					model.setBillable(billable[i]);
				if (gb[i] != null)
					model.setGb(gb[i]);
				if (ftend[i] != null)
					model.setFtend(ftend[i]);
				if (fm[i] != null)
					model.setFm(fm[i]);
				if (exceptionn[i] != null)
					model.setExceptionn(exceptionn[i]);
				if (over[i] != null)
					model.setOver(over[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (date2[i] != null)
					model.setDate2(date2[i]);
				if (ft[i] != null)
					model.setFt(ft[i]);
				if (date1[i] != null)
					model.setDate1(date1[i]);
				if (darapprno[i] != null)
					model.setDarapprno(darapprno[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (ftcmnc[i] != null)
					model.setFtcmnc(ftcmnc[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (ctrtofc[i] != null)
					model.setCtrtofc(ctrtofc[i]);
				if (divcd[i] != null)
					model.setDivcd(divcd[i]);
				if (invoiced[i] != null)
					model.setInvoiced(invoiced[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (grpid[i] != null)
					model.setGrpid(grpid[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (issdt[i] != null)
					model.setIssdt(issdt[i]);
				if (dmtofc[i] != null)
					model.setDmtofc(dmtofc[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (fromyard[i] != null)
					model.setFromyard(fromyard[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (invno[i] != null)
					model.setInvno(invno[i]);
				if (fromdate[i] != null)
					model.setFromdate(fromdate[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (too[i] != null)
					model.setToo(too[i]);
				if (custname[i] != null)
					model.setCustname(custname[i]);
				if (d[i] != null)
					model.setD(d[i]);
				if (cur2[i] != null)
					model.setCur2(cur2[i]);
				if (blno[i] != null)
					model.setBlno(blno[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (ar[i] != null)
					model.setAr(ar[i]);
				if (toyard[i] != null)
					model.setToyard(toyard[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (chgseq[i] != null)
					model.setChgseq(chgseq[i]);
				if (r[i] != null)
					model.setR(r[i]);
				if (custcode[i] != null)
					model.setCustcode(custcode[i]);
				if (cycno[i] != null)
					model.setCycno(cycno[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (name1[i] != null)
					model.setName1(name1[i]);
				if (name2[i] != null)
					model.setName2(name2[i]);
				if (rfano[i] != null)
					model.setRfano(rfano[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWaiveReportDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WaiveReportDetailVO[]
	 */
	public WaiveReportDetailVO[] getWaiveReportDetailVOs(){
		WaiveReportDetailVO[] vos = (WaiveReportDetailVO[])models.toArray(new WaiveReportDetailVO[models.size()]);
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
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office1 = this.office1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurred = this.incurred .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcamt = this.dcamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcrhqcd = this.ofcrhqcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office2 = this.office2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billable = this.billable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gb = this.gb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftend = this.ftend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm = this.fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceptionn = this.exceptionn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.over = this.over .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.date2 = this.date2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft = this.ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.date1 = this.date1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darapprno = this.darapprno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftcmnc = this.ftcmnc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtofc = this.ctrtofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divcd = this.divcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiced = this.invoiced .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpid = this.grpid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issdt = this.issdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtofc = this.dmtofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromyard = this.fromyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invno = this.invno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromdate = this.fromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.too = this.too .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custname = this.custname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d = this.d .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur2 = this.cur2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blno = this.blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ar = this.ar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toyard = this.toyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgseq = this.chgseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r = this.r .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custcode = this.custcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cycno = this.cycno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name1 = this.name1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name2 = this.name2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
