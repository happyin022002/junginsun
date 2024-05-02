/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlNtfyVO.java
*@FileTitle : SitProBlLdfBlNtfyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SitProBlLdfBlNtfyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlNtfyVO> models = new ArrayList<SitProBlLdfBlNtfyVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vvd = null;

	/* Column Info */
	private String ibConVvd = null;

	/* Column Info */
	private String obConVvd = null;

	/* Column Info */
	private String port = null;

	/* Column Info */
	private String blnbr = null;

	/* Column Info */
	private String blpol = null;

	/* Column Info */
	private String blpod = null;

	/* Column Info */
	private String blpor = null;

	/* Column Info */
	private String bldel = null;

	/* Column Info */
	private String shprcn = null;

	/* Column Info */
	private String shprcd = null;

	/* Column Info */
	private String shpr1 = null;

	/* Column Info */
	private String shpr2 = null;

	/* Column Info */
	private String shpr3 = null;

	/* Column Info */
	private String shpr4 = null;

	/* Column Info */
	private String shpr5 = null;

	/* Column Info */
	private String shprtxid = null;

	/* Column Info */
	private String cneecn = null;

	/* Column Info */
	private String cneecd = null;

	/* Column Info */
	private String cnee1 = null;

	/* Column Info */
	private String cnee2 = null;

	/* Column Info */
	private String cnee3 = null;

	/* Column Info */
	private String cnee4 = null;

	/* Column Info */
	private String cnee5 = null;

	/* Column Info */
	private String cneetxid = null;

	/* Column Info */
	private String ntfycn = null;

	/* Column Info */
	private String ntfycd = null;

	/* Column Info */
	private String ntfy1 = null;

	/* Column Info */
	private String ntfy2 = null;

	/* Column Info */
	private String ntfy3 = null;

	/* Column Info */
	private String ntfy4 = null;

	/* Column Info */
	private String ntfy5 = null;

	/* Column Info */
	private String ntfytxid = null;

	/* Column Info */
	private String ntfy2cn = null;

	/* Column Info */
	private String ntfy2cd = null;

	/* Column Info */
	private String ntfy21 = null;

	/* Column Info */
	private String ntfy22 = null;

	/* Column Info */
	private String ntfy23 = null;

	/* Column Info */
	private String ntfy24 = null;

	/* Column Info */
	private String ntfy25 = null;

	/* Column Info */
	private String ntfy2txid = null;

	/* Column Info */
	private String ffwdcn = null;

	/* Column Info */
	private String ffwdcd = null;

	/* Column Info */
	private String ffwd1 = null;

	/* Column Info */
	private String ffwd2 = null;

	/* Column Info */
	private String ffwd3 = null;

	/* Column Info */
	private String ffwd4 = null;

	/* Column Info */
	private String ffwd5 = null;

	/* Column Info */
	private String ffwdtxid = null;

	/* Column Info */
	private String expocn = null;

	/* Column Info */
	private String expocd = null;

	/* Column Info */
	private String expo1 = null;

	/* Column Info */
	private String expo2 = null;

	/* Column Info */
	private String expo3 = null;

	/* Column Info */
	private String expo4 = null;

	/* Column Info */
	private String expo5 = null;

	/* Column Info */
	private String expotxid = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlNtfyVO() {}

	public SitProBlLdfBlNtfyVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String port, String blnbr, String blpol, String blpod, String blpor, String bldel, String shprcn, String shprcd, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String shprtxid, String cneecn, String cneecd, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String cneetxid, String ntfycn, String ntfycd, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String ntfytxid, String ntfy2cn, String ntfy2cd, String ntfy21, String ntfy22, String ntfy23, String ntfy24, String ntfy25, String ntfy2txid, String ffwdcn, String ffwdcd, String ffwd1, String ffwd2, String ffwd3, String ffwd4, String ffwd5, String ffwdtxid, String expocn, String expocd, String expo1, String expo2, String expo3, String expo4, String expo5, String expotxid) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.port = port;
		this.blnbr = blnbr;
		this.blpol = blpol;
		this.blpod = blpod;
		this.blpor = blpor;
		this.bldel = bldel;
		this.shprcn = shprcn;
		this.shprcd = shprcd;
		this.shpr1 = shpr1;
		this.shpr2 = shpr2;
		this.shpr3 = shpr3;
		this.shpr4 = shpr4;
		this.shpr5 = shpr5;
		this.shprtxid = shprtxid;
		this.cneecn = cneecn;
		this.cneecd = cneecd;
		this.cnee1 = cnee1;
		this.cnee2 = cnee2;
		this.cnee3 = cnee3;
		this.cnee4 = cnee4;
		this.cnee5 = cnee5;
		this.cneetxid = cneetxid;
		this.ntfycn = ntfycn;
		this.ntfycd = ntfycd;
		this.ntfy1 = ntfy1;
		this.ntfy2 = ntfy2;
		this.ntfy3 = ntfy3;
		this.ntfy4 = ntfy4;
		this.ntfy5 = ntfy5;
		this.ntfytxid = ntfytxid;
		this.ntfy2cn = ntfy2cn;
		this.ntfy2cd = ntfy2cd;
		this.ntfy21 = ntfy21;
		this.ntfy22 = ntfy22;
		this.ntfy23 = ntfy23;
		this.ntfy24 = ntfy24;
		this.ntfy25 = ntfy25;
		this.ntfy2txid = ntfy2txid;
		this.ffwdcn = ffwdcn;
		this.ffwdcd = ffwdcd;
		this.ffwd1 = ffwd1;
		this.ffwd2 = ffwd2;
		this.ffwd3 = ffwd3;
		this.ffwd4 = ffwd4;
		this.ffwd5 = ffwd5;
		this.ffwdtxid = ffwdtxid;
		this.expocn = expocn;
		this.expocd = expocd;
		this.expo1 = expo1;
		this.expo2 = expo2;
		this.expo3 = expo3;
		this.expo4 = expo4;
		this.expo5 = expo5;
		this.expotxid = expotxid;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ib_con_vvd", getIbConVvd());
		this.hashColumns.put("ob_con_vvd", getObConVvd());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("shprcn", getShprcn());
		this.hashColumns.put("shprcd", getShprcd());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("shprtxid", getShprtxid());
		this.hashColumns.put("cneecn", getCneecn());
		this.hashColumns.put("cneecd", getCneecd());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("cneetxid", getCneetxid());
		this.hashColumns.put("ntfycn", getNtfycn());
		this.hashColumns.put("ntfycd", getNtfycd());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("ntfytxid", getNtfytxid());
		this.hashColumns.put("ntfy2cn", getNtfy2cn());
		this.hashColumns.put("ntfy2cd", getNtfy2cd());
		this.hashColumns.put("ntfy21", getNtfy21());
		this.hashColumns.put("ntfy22", getNtfy22());
		this.hashColumns.put("ntfy23", getNtfy23());
		this.hashColumns.put("ntfy24", getNtfy24());
		this.hashColumns.put("ntfy25", getNtfy25());
		this.hashColumns.put("ntfy2txid", getNtfy2txid());
		this.hashColumns.put("ffwdcn", getFfwdcn());
		this.hashColumns.put("ffwdcd", getFfwdcd());
		this.hashColumns.put("ffwd1", getFfwd1());
		this.hashColumns.put("ffwd2", getFfwd2());
		this.hashColumns.put("ffwd3", getFfwd3());
		this.hashColumns.put("ffwd4", getFfwd4());
		this.hashColumns.put("ffwd5", getFfwd5());
		this.hashColumns.put("ffwdtxid", getFfwdtxid());
		this.hashColumns.put("expocn", getExpocn());
		this.hashColumns.put("expocd", getExpocd());
		this.hashColumns.put("expo1", getExpo1());
		this.hashColumns.put("expo2", getExpo2());
		this.hashColumns.put("expo3", getExpo3());
		this.hashColumns.put("expo4", getExpo4());
		this.hashColumns.put("expo5", getExpo5());
		this.hashColumns.put("expotxid", getExpotxid());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ib_con_vvd", "ibConVvd");
		this.hashFields.put("ob_con_vvd", "obConVvd");
		this.hashFields.put("port", "port");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("shprcn", "shprcn");
		this.hashFields.put("shprcd", "shprcd");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("shprtxid", "shprtxid");
		this.hashFields.put("cneecn", "cneecn");
		this.hashFields.put("cneecd", "cneecd");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("cneetxid", "cneetxid");
		this.hashFields.put("ntfycn", "ntfycn");
		this.hashFields.put("ntfycd", "ntfycd");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("ntfytxid", "ntfytxid");
		this.hashFields.put("ntfy2cn", "ntfy2cn");
		this.hashFields.put("ntfy2cd", "ntfy2cd");
		this.hashFields.put("ntfy21", "ntfy21");
		this.hashFields.put("ntfy22", "ntfy22");
		this.hashFields.put("ntfy23", "ntfy23");
		this.hashFields.put("ntfy24", "ntfy24");
		this.hashFields.put("ntfy25", "ntfy25");
		this.hashFields.put("ntfy2txid", "ntfy2txid");
		this.hashFields.put("ffwdcn", "ffwdcn");
		this.hashFields.put("ffwdcd", "ffwdcd");
		this.hashFields.put("ffwd1", "ffwd1");
		this.hashFields.put("ffwd2", "ffwd2");
		this.hashFields.put("ffwd3", "ffwd3");
		this.hashFields.put("ffwd4", "ffwd4");
		this.hashFields.put("ffwd5", "ffwd5");
		this.hashFields.put("ffwdtxid", "ffwdtxid");
		this.hashFields.put("expocn", "expocn");
		this.hashFields.put("expocd", "expocd");
		this.hashFields.put("expo1", "expo1");
		this.hashFields.put("expo2", "expo2");
		this.hashFields.put("expo3", "expo3");
		this.hashFields.put("expo4", "expo4");
		this.hashFields.put("expo5", "expo5");
		this.hashFields.put("expotxid", "expotxid");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * 
	 * @return String vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 *
	 * @param String ibConVvd
	 */
	public void setIbConVvd(String ibConVvd) {
		this.ibConVvd = ibConVvd;
	}
	
	/**
	 * 
	 * @return String ibConVvd
	 */
	public String getIbConVvd() {
		return this.ibConVvd;
	}
	
	/**
	 *
	 * @param String obConVvd
	 */
	public void setObConVvd(String obConVvd) {
		this.obConVvd = obConVvd;
	}
	
	/**
	 * 
	 * @return String obConVvd
	 */
	public String getObConVvd() {
		return this.obConVvd;
	}
	
	/**
	 *
	 * @param String port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * 
	 * @return String port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 *
	 * @param String blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * 
	 * @return String blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 *
	 * @param String blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * 
	 * @return String blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 *
	 * @param String blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * 
	 * @return String blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 *
	 * @param String blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}
	
	/**
	 * 
	 * @return String blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}
	
	/**
	 *
	 * @param String bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * 
	 * @return String bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 *
	 * @param String shprcn
	 */
	public void setShprcn(String shprcn) {
		this.shprcn = shprcn;
	}
	
	/**
	 * 
	 * @return String shprcn
	 */
	public String getShprcn() {
		return this.shprcn;
	}
	
	/**
	 *
	 * @param String shprcd
	 */
	public void setShprcd(String shprcd) {
		this.shprcd = shprcd;
	}
	
	/**
	 * 
	 * @return String shprcd
	 */
	public String getShprcd() {
		return this.shprcd;
	}
	
	/**
	 *
	 * @param String shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}
	
	/**
	 * 
	 * @return String shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}
	
	/**
	 *
	 * @param String shpr2
	 */
	public void setShpr2(String shpr2) {
		this.shpr2 = shpr2;
	}
	
	/**
	 * 
	 * @return String shpr2
	 */
	public String getShpr2() {
		return this.shpr2;
	}
	
	/**
	 *
	 * @param String shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}
	
	/**
	 * 
	 * @return String shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}
	
	/**
	 *
	 * @param String shpr4
	 */
	public void setShpr4(String shpr4) {
		this.shpr4 = shpr4;
	}
	
	/**
	 * 
	 * @return String shpr4
	 */
	public String getShpr4() {
		return this.shpr4;
	}
	
	/**
	 *
	 * @param String shpr5
	 */
	public void setShpr5(String shpr5) {
		this.shpr5 = shpr5;
	}
	
	/**
	 * 
	 * @return String shpr5
	 */
	public String getShpr5() {
		return this.shpr5;
	}
	
	/**
	 *
	 * @param String shprtxid
	 */
	public void setShprtxid(String shprtxid) {
		this.shprtxid = shprtxid;
	}
	
	/**
	 * 
	 * @return String shprtxid
	 */
	public String getShprtxid() {
		return this.shprtxid;
	}
	
	/**
	 *
	 * @param String cneecn
	 */
	public void setCneecn(String cneecn) {
		this.cneecn = cneecn;
	}
	
	/**
	 * 
	 * @return String cneecn
	 */
	public String getCneecn() {
		return this.cneecn;
	}
	
	/**
	 *
	 * @param String cneecd
	 */
	public void setCneecd(String cneecd) {
		this.cneecd = cneecd;
	}
	
	/**
	 * 
	 * @return String cneecd
	 */
	public String getCneecd() {
		return this.cneecd;
	}
	
	/**
	 *
	 * @param String cnee1
	 */
	public void setCnee1(String cnee1) {
		this.cnee1 = cnee1;
	}
	
	/**
	 * 
	 * @return String cnee1
	 */
	public String getCnee1() {
		return this.cnee1;
	}
	
	/**
	 *
	 * @param String cnee2
	 */
	public void setCnee2(String cnee2) {
		this.cnee2 = cnee2;
	}
	
	/**
	 * 
	 * @return String cnee2
	 */
	public String getCnee2() {
		return this.cnee2;
	}
	
	/**
	 *
	 * @param String cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}
	
	/**
	 * 
	 * @return String cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}
	
	/**
	 *
	 * @param String cnee4
	 */
	public void setCnee4(String cnee4) {
		this.cnee4 = cnee4;
	}
	
	/**
	 * 
	 * @return String cnee4
	 */
	public String getCnee4() {
		return this.cnee4;
	}
	
	/**
	 *
	 * @param String cnee5
	 */
	public void setCnee5(String cnee5) {
		this.cnee5 = cnee5;
	}
	
	/**
	 * 
	 * @return String cnee5
	 */
	public String getCnee5() {
		return this.cnee5;
	}
	
	/**
	 *
	 * @param String cneetxid
	 */
	public void setCneetxid(String cneetxid) {
		this.cneetxid = cneetxid;
	}
	
	/**
	 * 
	 * @return String cneetxid
	 */
	public String getCneetxid() {
		return this.cneetxid;
	}
	
	/**
	 *
	 * @param String ntfycn
	 */
	public void setNtfycn(String ntfycn) {
		this.ntfycn = ntfycn;
	}
	
	/**
	 * 
	 * @return String ntfycn
	 */
	public String getNtfycn() {
		return this.ntfycn;
	}
	
	/**
	 *
	 * @param String ntfycd
	 */
	public void setNtfycd(String ntfycd) {
		this.ntfycd = ntfycd;
	}
	
	/**
	 * 
	 * @return String ntfycd
	 */
	public String getNtfycd() {
		return this.ntfycd;
	}
	
	/**
	 *
	 * @param String ntfy1
	 */
	public void setNtfy1(String ntfy1) {
		this.ntfy1 = ntfy1;
	}
	
	/**
	 * 
	 * @return String ntfy1
	 */
	public String getNtfy1() {
		return this.ntfy1;
	}
	
	/**
	 *
	 * @param String ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
	}
	
	/**
	 * 
	 * @return String ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
	}
	
	/**
	 *
	 * @param String ntfy3
	 */
	public void setNtfy3(String ntfy3) {
		this.ntfy3 = ntfy3;
	}
	
	/**
	 * 
	 * @return String ntfy3
	 */
	public String getNtfy3() {
		return this.ntfy3;
	}
	
	/**
	 *
	 * @param String ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * 
	 * @return String ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 *
	 * @param String ntfy5
	 */
	public void setNtfy5(String ntfy5) {
		this.ntfy5 = ntfy5;
	}
	
	/**
	 * 
	 * @return String ntfy5
	 */
	public String getNtfy5() {
		return this.ntfy5;
	}
	
	/**
	 *
	 * @param String ntfytxid
	 */
	public void setNtfytxid(String ntfytxid) {
		this.ntfytxid = ntfytxid;
	}
	
	/**
	 * 
	 * @return String ntfytxid
	 */
	public String getNtfytxid() {
		return this.ntfytxid;
	}
	
	/**
	 *
	 * @param String ntfy2cn
	 */
	public void setNtfy2cn(String ntfy2cn) {
		this.ntfy2cn = ntfy2cn;
	}
	
	/**
	 * 
	 * @return String ntfy2cn
	 */
	public String getNtfy2cn() {
		return this.ntfy2cn;
	}
	
	/**
	 *
	 * @param String ntfy2cd
	 */
	public void setNtfy2cd(String ntfy2cd) {
		this.ntfy2cd = ntfy2cd;
	}
	
	/**
	 * 
	 * @return String ntfy2cd
	 */
	public String getNtfy2cd() {
		return this.ntfy2cd;
	}
	
	/**
	 *
	 * @param String ntfy21
	 */
	public void setNtfy21(String ntfy21) {
		this.ntfy21 = ntfy21;
	}
	
	/**
	 * 
	 * @return String ntfy21
	 */
	public String getNtfy21() {
		return this.ntfy21;
	}
	
	/**
	 *
	 * @param String ntfy22
	 */
	public void setNtfy22(String ntfy22) {
		this.ntfy22 = ntfy22;
	}
	
	/**
	 * 
	 * @return String ntfy22
	 */
	public String getNtfy22() {
		return this.ntfy22;
	}
	
	/**
	 *
	 * @param String ntfy23
	 */
	public void setNtfy23(String ntfy23) {
		this.ntfy23 = ntfy23;
	}
	
	/**
	 * 
	 * @return String ntfy23
	 */
	public String getNtfy23() {
		return this.ntfy23;
	}
	
	/**
	 *
	 * @param String ntfy24
	 */
	public void setNtfy24(String ntfy24) {
		this.ntfy24 = ntfy24;
	}
	
	/**
	 * 
	 * @return String ntfy24
	 */
	public String getNtfy24() {
		return this.ntfy24;
	}
	
	/**
	 *
	 * @param String ntfy25
	 */
	public void setNtfy25(String ntfy25) {
		this.ntfy25 = ntfy25;
	}
	
	/**
	 * 
	 * @return String ntfy25
	 */
	public String getNtfy25() {
		return this.ntfy25;
	}
	
	/**
	 *
	 * @param String ntfy2txid
	 */
	public void setNtfy2txid(String ntfy2txid) {
		this.ntfy2txid = ntfy2txid;
	}
	
	/**
	 * 
	 * @return String ntfy2txid
	 */
	public String getNtfy2txid() {
		return this.ntfy2txid;
	}
	
	/**
	 *
	 * @param String ffwdcn
	 */
	public void setFfwdcn(String ffwdcn) {
		this.ffwdcn = ffwdcn;
	}
	
	/**
	 * 
	 * @return String ffwdcn
	 */
	public String getFfwdcn() {
		return this.ffwdcn;
	}
	
	/**
	 *
	 * @param String ffwdcd
	 */
	public void setFfwdcd(String ffwdcd) {
		this.ffwdcd = ffwdcd;
	}
	
	/**
	 * 
	 * @return String ffwdcd
	 */
	public String getFfwdcd() {
		return this.ffwdcd;
	}
	
	/**
	 *
	 * @param String ffwd1
	 */
	public void setFfwd1(String ffwd1) {
		this.ffwd1 = ffwd1;
	}
	
	/**
	 * 
	 * @return String ffwd1
	 */
	public String getFfwd1() {
		return this.ffwd1;
	}
	
	/**
	 *
	 * @param String ffwd2
	 */
	public void setFfwd2(String ffwd2) {
		this.ffwd2 = ffwd2;
	}
	
	/**
	 * 
	 * @return String ffwd2
	 */
	public String getFfwd2() {
		return this.ffwd2;
	}
	
	/**
	 *
	 * @param String ffwd3
	 */
	public void setFfwd3(String ffwd3) {
		this.ffwd3 = ffwd3;
	}
	
	/**
	 * 
	 * @return String ffwd3
	 */
	public String getFfwd3() {
		return this.ffwd3;
	}
	
	/**
	 *
	 * @param String ffwd4
	 */
	public void setFfwd4(String ffwd4) {
		this.ffwd4 = ffwd4;
	}
	
	/**
	 * 
	 * @return String ffwd4
	 */
	public String getFfwd4() {
		return this.ffwd4;
	}
	
	/**
	 *
	 * @param String ffwd5
	 */
	public void setFfwd5(String ffwd5) {
		this.ffwd5 = ffwd5;
	}
	
	/**
	 * 
	 * @return String ffwd5
	 */
	public String getFfwd5() {
		return this.ffwd5;
	}
	
	/**
	 *
	 * @param String ffwdtxid
	 */
	public void setFfwdtxid(String ffwdtxid) {
		this.ffwdtxid = ffwdtxid;
	}
	
	/**
	 * 
	 * @return String ffwdtxid
	 */
	public String getFfwdtxid() {
		return this.ffwdtxid;
	}
	
	/**
	 *
	 * @param String expocn
	 */
	public void setExpocn(String expocn) {
		this.expocn = expocn;
	}
	
	/**
	 * 
	 * @return String expocn
	 */
	public String getExpocn() {
		return this.expocn;
	}
	
	/**
	 *
	 * @param String expocd
	 */
	public void setExpocd(String expocd) {
		this.expocd = expocd;
	}
	
	/**
	 * 
	 * @return String expocd
	 */
	public String getExpocd() {
		return this.expocd;
	}
	
	/**
	 *
	 * @param String expo1
	 */
	public void setExpo1(String expo1) {
		this.expo1 = expo1;
	}
	
	/**
	 * 
	 * @return String expo1
	 */
	public String getExpo1() {
		return this.expo1;
	}
	
	/**
	 *
	 * @param String expo2
	 */
	public void setExpo2(String expo2) {
		this.expo2 = expo2;
	}
	
	/**
	 * 
	 * @return String expo2
	 */
	public String getExpo2() {
		return this.expo2;
	}
	
	/**
	 *
	 * @param String expo3
	 */
	public void setExpo3(String expo3) {
		this.expo3 = expo3;
	}
	
	/**
	 * 
	 * @return String expo3
	 */
	public String getExpo3() {
		return this.expo3;
	}
	
	/**
	 *
	 * @param String expo4
	 */
	public void setExpo4(String expo4) {
		this.expo4 = expo4;
	}
	
	/**
	 * 
	 * @return String expo4
	 */
	public String getExpo4() {
		return this.expo4;
	}
	
	/**
	 *
	 * @param String expo5
	 */
	public void setExpo5(String expo5) {
		this.expo5 = expo5;
	}
	
	/**
	 * 
	 * @return String expo5
	 */
	public String getExpo5() {
		return this.expo5;
	}
	
	/**
	 *
	 * @param String expotxid
	 */
	public void setExpotxid(String expotxid) {
		this.expotxid = expotxid;
	}
	
	/**
	 * 
	 * @return String expotxid
	 */
	public String getExpotxid() {
		return this.expotxid;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbConVvd(JSPUtil.getParameter(request, prefix + "ib_con_vvd", ""));
		setObConVvd(JSPUtil.getParameter(request, prefix + "ob_con_vvd", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setShprcn(JSPUtil.getParameter(request, prefix + "shprcn", ""));
		setShprcd(JSPUtil.getParameter(request, prefix + "shprcd", ""));
		setShpr1(JSPUtil.getParameter(request, prefix + "shpr1", ""));
		setShpr2(JSPUtil.getParameter(request, prefix + "shpr2", ""));
		setShpr3(JSPUtil.getParameter(request, prefix + "shpr3", ""));
		setShpr4(JSPUtil.getParameter(request, prefix + "shpr4", ""));
		setShpr5(JSPUtil.getParameter(request, prefix + "shpr5", ""));
		setShprtxid(JSPUtil.getParameter(request, prefix + "shprtxid", ""));
		setCneecn(JSPUtil.getParameter(request, prefix + "cneecn", ""));
		setCneecd(JSPUtil.getParameter(request, prefix + "cneecd", ""));
		setCnee1(JSPUtil.getParameter(request, prefix + "cnee1", ""));
		setCnee2(JSPUtil.getParameter(request, prefix + "cnee2", ""));
		setCnee3(JSPUtil.getParameter(request, prefix + "cnee3", ""));
		setCnee4(JSPUtil.getParameter(request, prefix + "cnee4", ""));
		setCnee5(JSPUtil.getParameter(request, prefix + "cnee5", ""));
		setCneetxid(JSPUtil.getParameter(request, prefix + "cneetxid", ""));
		setNtfycn(JSPUtil.getParameter(request, prefix + "ntfycn", ""));
		setNtfycd(JSPUtil.getParameter(request, prefix + "ntfycd", ""));
		setNtfy1(JSPUtil.getParameter(request, prefix + "ntfy1", ""));
		setNtfy2(JSPUtil.getParameter(request, prefix + "ntfy2", ""));
		setNtfy3(JSPUtil.getParameter(request, prefix + "ntfy3", ""));
		setNtfy4(JSPUtil.getParameter(request, prefix + "ntfy4", ""));
		setNtfy5(JSPUtil.getParameter(request, prefix + "ntfy5", ""));
		setNtfytxid(JSPUtil.getParameter(request, prefix + "ntfytxid", ""));
		setNtfy2cn(JSPUtil.getParameter(request, prefix + "ntfy2cn", ""));
		setNtfy2cd(JSPUtil.getParameter(request, prefix + "ntfy2cd", ""));
		setNtfy21(JSPUtil.getParameter(request, prefix + "ntfy21", ""));
		setNtfy22(JSPUtil.getParameter(request, prefix + "ntfy22", ""));
		setNtfy23(JSPUtil.getParameter(request, prefix + "ntfy23", ""));
		setNtfy24(JSPUtil.getParameter(request, prefix + "ntfy24", ""));
		setNtfy25(JSPUtil.getParameter(request, prefix + "ntfy25", ""));
		setNtfy2txid(JSPUtil.getParameter(request, prefix + "ntfy2txid", ""));
		setFfwdcn(JSPUtil.getParameter(request, prefix + "ffwdcn", ""));
		setFfwdcd(JSPUtil.getParameter(request, prefix + "ffwdcd", ""));
		setFfwd1(JSPUtil.getParameter(request, prefix + "ffwd1", ""));
		setFfwd2(JSPUtil.getParameter(request, prefix + "ffwd2", ""));
		setFfwd3(JSPUtil.getParameter(request, prefix + "ffwd3", ""));
		setFfwd4(JSPUtil.getParameter(request, prefix + "ffwd4", ""));
		setFfwd5(JSPUtil.getParameter(request, prefix + "ffwd5", ""));
		setFfwdtxid(JSPUtil.getParameter(request, prefix + "ffwdtxid", ""));
		setExpocn(JSPUtil.getParameter(request, prefix + "expocn", ""));
		setExpocd(JSPUtil.getParameter(request, prefix + "expocd", ""));
		setExpo1(JSPUtil.getParameter(request, prefix + "expo1", ""));
		setExpo2(JSPUtil.getParameter(request, prefix + "expo2", ""));
		setExpo3(JSPUtil.getParameter(request, prefix + "expo3", ""));
		setExpo4(JSPUtil.getParameter(request, prefix + "expo4", ""));
		setExpo5(JSPUtil.getParameter(request, prefix + "expo5", ""));
		setExpotxid(JSPUtil.getParameter(request, prefix + "expotxid", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlNtfyVO[]
	 */
	public SitProBlLdfBlNtfyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlNtfyVO[]
	 */
	public SitProBlLdfBlNtfyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlNtfyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibConVvd = (JSPUtil.getParameter(request, prefix	+ "ib_con_vvd", length));
			String[] obConVvd = (JSPUtil.getParameter(request, prefix	+ "ob_con_vvd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] shprcn = (JSPUtil.getParameter(request, prefix	+ "shprcn", length));
			String[] shprcd = (JSPUtil.getParameter(request, prefix	+ "shprcd", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] shprtxid = (JSPUtil.getParameter(request, prefix	+ "shprtxid", length));
			String[] cneecn = (JSPUtil.getParameter(request, prefix	+ "cneecn", length));
			String[] cneecd = (JSPUtil.getParameter(request, prefix	+ "cneecd", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] cneetxid = (JSPUtil.getParameter(request, prefix	+ "cneetxid", length));
			String[] ntfycn = (JSPUtil.getParameter(request, prefix	+ "ntfycn", length));
			String[] ntfycd = (JSPUtil.getParameter(request, prefix	+ "ntfycd", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] ntfytxid = (JSPUtil.getParameter(request, prefix	+ "ntfytxid", length));
			String[] ntfy2cn = (JSPUtil.getParameter(request, prefix	+ "ntfy2cn", length));
			String[] ntfy2cd = (JSPUtil.getParameter(request, prefix	+ "ntfy2cd", length));
			String[] ntfy21 = (JSPUtil.getParameter(request, prefix	+ "ntfy21", length));
			String[] ntfy22 = (JSPUtil.getParameter(request, prefix	+ "ntfy22", length));
			String[] ntfy23 = (JSPUtil.getParameter(request, prefix	+ "ntfy23", length));
			String[] ntfy24 = (JSPUtil.getParameter(request, prefix	+ "ntfy24", length));
			String[] ntfy25 = (JSPUtil.getParameter(request, prefix	+ "ntfy25", length));
			String[] ntfy2txid = (JSPUtil.getParameter(request, prefix	+ "ntfy2txid", length));
			String[] ffwdcn = (JSPUtil.getParameter(request, prefix	+ "ffwdcn", length));
			String[] ffwdcd = (JSPUtil.getParameter(request, prefix	+ "ffwdcd", length));
			String[] ffwd1 = (JSPUtil.getParameter(request, prefix	+ "ffwd1", length));
			String[] ffwd2 = (JSPUtil.getParameter(request, prefix	+ "ffwd2", length));
			String[] ffwd3 = (JSPUtil.getParameter(request, prefix	+ "ffwd3", length));
			String[] ffwd4 = (JSPUtil.getParameter(request, prefix	+ "ffwd4", length));
			String[] ffwd5 = (JSPUtil.getParameter(request, prefix	+ "ffwd5", length));
			String[] ffwdtxid = (JSPUtil.getParameter(request, prefix	+ "ffwdtxid", length));
			String[] expocn = (JSPUtil.getParameter(request, prefix	+ "expocn", length));
			String[] expocd = (JSPUtil.getParameter(request, prefix	+ "expocd", length));
			String[] expo1 = (JSPUtil.getParameter(request, prefix	+ "expo1", length));
			String[] expo2 = (JSPUtil.getParameter(request, prefix	+ "expo2", length));
			String[] expo3 = (JSPUtil.getParameter(request, prefix	+ "expo3", length));
			String[] expo4 = (JSPUtil.getParameter(request, prefix	+ "expo4", length));
			String[] expo5 = (JSPUtil.getParameter(request, prefix	+ "expo5", length));
			String[] expotxid = (JSPUtil.getParameter(request, prefix	+ "expotxid", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlNtfyVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (ibConVvd[i] != null) 
					model.setIbConVvd(ibConVvd[i]);
				if (obConVvd[i] != null) 
					model.setObConVvd(obConVvd[i]);
				if (port[i] != null) 
					model.setPort(port[i]);
				if (blnbr[i] != null) 
					model.setBlnbr(blnbr[i]);
				if (blpol[i] != null) 
					model.setBlpol(blpol[i]);
				if (blpod[i] != null) 
					model.setBlpod(blpod[i]);
				if (blpor[i] != null) 
					model.setBlpor(blpor[i]);
				if (bldel[i] != null) 
					model.setBldel(bldel[i]);
				if (shprcn[i] != null) 
					model.setShprcn(shprcn[i]);
				if (shprcd[i] != null) 
					model.setShprcd(shprcd[i]);
				if (shpr1[i] != null) 
					model.setShpr1(shpr1[i]);
				if (shpr2[i] != null) 
					model.setShpr2(shpr2[i]);
				if (shpr3[i] != null) 
					model.setShpr3(shpr3[i]);
				if (shpr4[i] != null) 
					model.setShpr4(shpr4[i]);
				if (shpr5[i] != null) 
					model.setShpr5(shpr5[i]);
				if (shprtxid[i] != null) 
					model.setShprtxid(shprtxid[i]);
				if (cneecn[i] != null) 
					model.setCneecn(cneecn[i]);
				if (cneecd[i] != null) 
					model.setCneecd(cneecd[i]);
				if (cnee1[i] != null) 
					model.setCnee1(cnee1[i]);
				if (cnee2[i] != null) 
					model.setCnee2(cnee2[i]);
				if (cnee3[i] != null) 
					model.setCnee3(cnee3[i]);
				if (cnee4[i] != null) 
					model.setCnee4(cnee4[i]);
				if (cnee5[i] != null) 
					model.setCnee5(cnee5[i]);
				if (cneetxid[i] != null) 
					model.setCneetxid(cneetxid[i]);
				if (ntfycn[i] != null) 
					model.setNtfycn(ntfycn[i]);
				if (ntfycd[i] != null) 
					model.setNtfycd(ntfycd[i]);
				if (ntfy1[i] != null) 
					model.setNtfy1(ntfy1[i]);
				if (ntfy2[i] != null) 
					model.setNtfy2(ntfy2[i]);
				if (ntfy3[i] != null) 
					model.setNtfy3(ntfy3[i]);
				if (ntfy4[i] != null) 
					model.setNtfy4(ntfy4[i]);
				if (ntfy5[i] != null) 
					model.setNtfy5(ntfy5[i]);
				if (ntfytxid[i] != null) 
					model.setNtfytxid(ntfytxid[i]);
				if (ntfy2cn[i] != null) 
					model.setNtfy2cn(ntfy2cn[i]);
				if (ntfy2cd[i] != null) 
					model.setNtfy2cd(ntfy2cd[i]);
				if (ntfy21[i] != null) 
					model.setNtfy21(ntfy21[i]);
				if (ntfy22[i] != null) 
					model.setNtfy22(ntfy22[i]);
				if (ntfy23[i] != null) 
					model.setNtfy23(ntfy23[i]);
				if (ntfy24[i] != null) 
					model.setNtfy24(ntfy24[i]);
				if (ntfy25[i] != null) 
					model.setNtfy25(ntfy25[i]);
				if (ntfy2txid[i] != null) 
					model.setNtfy2txid(ntfy2txid[i]);
				if (ffwdcn[i] != null) 
					model.setFfwdcn(ffwdcn[i]);
				if (ffwdcd[i] != null) 
					model.setFfwdcd(ffwdcd[i]);
				if (ffwd1[i] != null) 
					model.setFfwd1(ffwd1[i]);
				if (ffwd2[i] != null) 
					model.setFfwd2(ffwd2[i]);
				if (ffwd3[i] != null) 
					model.setFfwd3(ffwd3[i]);
				if (ffwd4[i] != null) 
					model.setFfwd4(ffwd4[i]);
				if (ffwd5[i] != null) 
					model.setFfwd5(ffwd5[i]);
				if (ffwdtxid[i] != null) 
					model.setFfwdtxid(ffwdtxid[i]);
				if (expocn[i] != null) 
					model.setExpocn(expocn[i]);
				if (expocd[i] != null) 
					model.setExpocd(expocd[i]);
				if (expo1[i] != null) 
					model.setExpo1(expo1[i]);
				if (expo2[i] != null) 
					model.setExpo2(expo2[i]);
				if (expo3[i] != null) 
					model.setExpo3(expo3[i]);
				if (expo4[i] != null) 
					model.setExpo4(expo4[i]);
				if (expo5[i] != null) 
					model.setExpo5(expo5[i]);
				if (expotxid[i] != null) 
					model.setExpotxid(expotxid[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlNtfyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlNtfyVO[]
	 */
	public SitProBlLdfBlNtfyVO[] getSitProBlLdfBlNtfyVOs(){
		SitProBlLdfBlNtfyVO[] vos = (SitProBlLdfBlNtfyVO[])models.toArray(new SitProBlLdfBlNtfyVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibConVvd = this.ibConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obConVvd = this.obConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcn = this.shprcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcd = this.shprcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprtxid = this.shprtxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecn = this.cneecn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecd = this.cneecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneetxid = this.cneetxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycn = this.ntfycn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycd = this.ntfycd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfytxid = this.ntfytxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2cn = this.ntfy2cn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2cd = this.ntfy2cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy21 = this.ntfy21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy22 = this.ntfy22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy23 = this.ntfy23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy24 = this.ntfy24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy25 = this.ntfy25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2txid = this.ntfy2txid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwdcn = this.ffwdcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwdcd = this.ffwdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd1 = this.ffwd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd2 = this.ffwd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd3 = this.ffwd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd4 = this.ffwd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd5 = this.ffwd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwdtxid = this.ffwdtxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expocn = this.expocn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expocd = this.expocd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo1 = this.expo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo2 = this.expo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo3 = this.expo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo4 = this.expo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo5 = this.expo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expotxid = this.expotxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}