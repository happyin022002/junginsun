/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlRoutVO.java
*@FileTitle : SitProBlLdfBlRoutVO
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
public class SitProBlLdfBlRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlRoutVO> models = new ArrayList<SitProBlLdfBlRoutVO>();
	
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
	private String portname = null;

	/* Column Info */
	private String eta = null;

	/* Column Info */
	private String etd = null;

	/* Column Info */
	private String ata = null;

	/* Column Info */
	private String atd = null;

	/* Column Info */
	private String nextport = null;

	/* Column Info */
	private String nextportEta = null;

	/* Column Info */
	private String prevport = null;

	/* Column Info */
	private String prevportEtd = null;

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
	private String vvdtype = null;

	/* Column Info */
	private String laneCd = null;

	/* Column Info */
	private String bvvd1 = null;

	/* Column Info */
	private String vslCallsign1 = null;

	/* Column Info */
	private String vslLloydcode1 = null;

	/* Column Info */
	private String vslFullname1 = null;

	/* Column Info */
	private String vslFlag1 = null;

	/* Column Info */
	private String blpol1 = null;

	/* Column Info */
	private String polYd = null;

	/* Column Info */
	private String polFullname1 = null;

	/* Column Info */
	private String blpod1 = null;

	/* Column Info */
	private String podYd = null;

	/* Column Info */
	private String podFullname1 = null;

	/* Column Info */
	private String poleta1 = null;

	/* Column Info */
	private String poletd1 = null;

	/* Column Info */
	private String podeta1 = null;

	/* Column Info */
	private String podetd1 = null;

	/* Column Info */
	private String opCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlRoutVO() {}

	public SitProBlLdfBlRoutVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String port, String portname, String eta, String etd, String ata, String atd, String nextport, String nextportEta, String prevport, String prevportEtd, String blnbr, String blpol, String blpod, String blpor, String bldel, String vvdtype, String laneCd, String bvvd1, String vslCallsign1, String vslLloydcode1, String vslFullname1, String vslFlag1, String blpol1, String polYd, String polFullname1, String blpod1, String podYd, String podFullname1, String poleta1, String poletd1, String podeta1, String podetd1, String opCode) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.port = port;
		this.portname = portname;
		this.eta = eta;
		this.etd = etd;
		this.ata = ata;
		this.atd = atd;
		this.nextport = nextport;
		this.nextportEta = nextportEta;
		this.prevport = prevport;
		this.prevportEtd = prevportEtd;
		this.blnbr = blnbr;
		this.blpol = blpol;
		this.blpod = blpod;
		this.blpor = blpor;
		this.bldel = bldel;
		this.vvdtype = vvdtype;
		this.laneCd = laneCd;
		this.bvvd1 = bvvd1;
		this.vslCallsign1 = vslCallsign1;
		this.vslLloydcode1 = vslLloydcode1;
		this.vslFullname1 = vslFullname1;
		this.vslFlag1 = vslFlag1;
		this.blpol1 = blpol1;
		this.polYd = polYd;
		this.polFullname1 = polFullname1;
		this.blpod1 = blpod1;
		this.podYd = podYd;
		this.podFullname1 = podFullname1;
		this.poleta1 = poleta1;
		this.poletd1 = poletd1;
		this.podeta1 = podeta1;
		this.podetd1 = podetd1;
		this.opCode = opCode;
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
		this.hashColumns.put("portname", getPortname());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("ata", getAta());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("nextport", getNextport());
		this.hashColumns.put("nextport_eta", getNextportEta());
		this.hashColumns.put("prevport", getPrevport());
		this.hashColumns.put("prevport_etd", getPrevportEtd());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("vvdtype", getVvdtype());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("bvvd1", getBvvd1());
		this.hashColumns.put("vsl_callsign1", getVslCallsign1());
		this.hashColumns.put("vsl_lloydcode1", getVslLloydcode1());
		this.hashColumns.put("vsl_fullname1", getVslFullname1());
		this.hashColumns.put("vsl_flag1", getVslFlag1());
		this.hashColumns.put("blpol1", getBlpol1());
		this.hashColumns.put("pol_yd", getPolYd());
		this.hashColumns.put("pol_fullname1", getPolFullname1());
		this.hashColumns.put("blpod1", getBlpod1());
		this.hashColumns.put("pod_yd", getPodYd());
		this.hashColumns.put("pod_fullname1", getPodFullname1());
		this.hashColumns.put("poleta1", getPoleta1());
		this.hashColumns.put("poletd1", getPoletd1());
		this.hashColumns.put("podeta1", getPodeta1());
		this.hashColumns.put("podetd1", getPodetd1());
		this.hashColumns.put("op_code", getOpCode());
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
		this.hashFields.put("portname", "portname");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("ata", "ata");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("nextport", "nextport");
		this.hashFields.put("nextport_eta", "nextportEta");
		this.hashFields.put("prevport", "prevport");
		this.hashFields.put("prevport_etd", "prevportEtd");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("vvdtype", "vvdtype");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("bvvd1", "bvvd1");
		this.hashFields.put("vsl_callsign1", "vslCallsign1");
		this.hashFields.put("vsl_lloydcode1", "vslLloydcode1");
		this.hashFields.put("vsl_fullname1", "vslFullname1");
		this.hashFields.put("vsl_flag1", "vslFlag1");
		this.hashFields.put("blpol1", "blpol1");
		this.hashFields.put("pol_yd", "polYd");
		this.hashFields.put("pol_fullname1", "polFullname1");
		this.hashFields.put("blpod1", "blpod1");
		this.hashFields.put("pod_yd", "podYd");
		this.hashFields.put("pod_fullname1", "podFullname1");
		this.hashFields.put("poleta1", "poleta1");
		this.hashFields.put("poletd1", "poletd1");
		this.hashFields.put("podeta1", "podeta1");
		this.hashFields.put("podetd1", "podetd1");
		this.hashFields.put("op_code", "opCode");
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
	 * @param String portname
	 */
	public void setPortname(String portname) {
		this.portname = portname;
	}
	
	/**
	 * 
	 * @return String portname
	 */
	public String getPortname() {
		return this.portname;
	}
	
	/**
	 *
	 * @param String eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * 
	 * @return String eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 *
	 * @param String etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * 
	 * @return String etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 *
	 * @param String ata
	 */
	public void setAta(String ata) {
		this.ata = ata;
	}
	
	/**
	 * 
	 * @return String ata
	 */
	public String getAta() {
		return this.ata;
	}
	
	/**
	 *
	 * @param String atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * 
	 * @return String atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 *
	 * @param String nextport
	 */
	public void setNextport(String nextport) {
		this.nextport = nextport;
	}
	
	/**
	 * 
	 * @return String nextport
	 */
	public String getNextport() {
		return this.nextport;
	}
	
	/**
	 *
	 * @param String nextportEta
	 */
	public void setNextportEta(String nextportEta) {
		this.nextportEta = nextportEta;
	}
	
	/**
	 * 
	 * @return String nextportEta
	 */
	public String getNextportEta() {
		return this.nextportEta;
	}
	
	/**
	 *
	 * @param String prevport
	 */
	public void setPrevport(String prevport) {
		this.prevport = prevport;
	}
	
	/**
	 * 
	 * @return String prevport
	 */
	public String getPrevport() {
		return this.prevport;
	}
	
	/**
	 *
	 * @param String prevportEtd
	 */
	public void setPrevportEtd(String prevportEtd) {
		this.prevportEtd = prevportEtd;
	}
	
	/**
	 * 
	 * @return String prevportEtd
	 */
	public String getPrevportEtd() {
		return this.prevportEtd;
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
	 * @param String vvdtype
	 */
	public void setVvdtype(String vvdtype) {
		this.vvdtype = vvdtype;
	}
	
	/**
	 * 
	 * @return String vvdtype
	 */
	public String getVvdtype() {
		return this.vvdtype;
	}
	
	/**
	 *
	 * @param String laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * 
	 * @return String laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 *
	 * @param String bvvd1
	 */
	public void setBvvd1(String bvvd1) {
		this.bvvd1 = bvvd1;
	}
	
	/**
	 * 
	 * @return String bvvd1
	 */
	public String getBvvd1() {
		return this.bvvd1;
	}
	
	/**
	 *
	 * @param String vslCallsign1
	 */
	public void setVslCallsign1(String vslCallsign1) {
		this.vslCallsign1 = vslCallsign1;
	}
	
	/**
	 * 
	 * @return String vslCallsign1
	 */
	public String getVslCallsign1() {
		return this.vslCallsign1;
	}
	
	/**
	 *
	 * @param String vslLloydcode1
	 */
	public void setVslLloydcode1(String vslLloydcode1) {
		this.vslLloydcode1 = vslLloydcode1;
	}
	
	/**
	 * 
	 * @return String vslLloydcode1
	 */
	public String getVslLloydcode1() {
		return this.vslLloydcode1;
	}
	
	/**
	 *
	 * @param String vslFullname1
	 */
	public void setVslFullname1(String vslFullname1) {
		this.vslFullname1 = vslFullname1;
	}
	
	/**
	 * 
	 * @return String vslFullname1
	 */
	public String getVslFullname1() {
		return this.vslFullname1;
	}
	
	/**
	 *
	 * @param String vslFlag1
	 */
	public void setVslFlag1(String vslFlag1) {
		this.vslFlag1 = vslFlag1;
	}
	
	/**
	 * 
	 * @return String vslFlag1
	 */
	public String getVslFlag1() {
		return this.vslFlag1;
	}
	
	/**
	 *
	 * @param String blpol1
	 */
	public void setBlpol1(String blpol1) {
		this.blpol1 = blpol1;
	}
	
	/**
	 * 
	 * @return String blpol1
	 */
	public String getBlpol1() {
		return this.blpol1;
	}
	
	/**
	 *
	 * @param String polYd
	 */
	public void setPolYd(String polYd) {
		this.polYd = polYd;
	}
	
	/**
	 * 
	 * @return String polYd
	 */
	public String getPolYd() {
		return this.polYd;
	}
	
	/**
	 *
	 * @param String polFullname1
	 */
	public void setPolFullname1(String polFullname1) {
		this.polFullname1 = polFullname1;
	}
	
	/**
	 * 
	 * @return String polFullname1
	 */
	public String getPolFullname1() {
		return this.polFullname1;
	}
	
	/**
	 *
	 * @param String blpod1
	 */
	public void setBlpod1(String blpod1) {
		this.blpod1 = blpod1;
	}
	
	/**
	 * 
	 * @return String blpod1
	 */
	public String getBlpod1() {
		return this.blpod1;
	}
	
	/**
	 *
	 * @param String podYd
	 */
	public void setPodYd(String podYd) {
		this.podYd = podYd;
	}
	
	/**
	 * 
	 * @return String podYd
	 */
	public String getPodYd() {
		return this.podYd;
	}
	
	/**
	 *
	 * @param String podFullname1
	 */
	public void setPodFullname1(String podFullname1) {
		this.podFullname1 = podFullname1;
	}
	
	/**
	 * 
	 * @return String podFullname1
	 */
	public String getPodFullname1() {
		return this.podFullname1;
	}
	
	/**
	 *
	 * @param String poleta1
	 */
	public void setPoleta1(String poleta1) {
		this.poleta1 = poleta1;
	}
	
	/**
	 * 
	 * @return String poleta1
	 */
	public String getPoleta1() {
		return this.poleta1;
	}
	
	/**
	 *
	 * @param String poletd1
	 */
	public void setPoletd1(String poletd1) {
		this.poletd1 = poletd1;
	}
	
	/**
	 * 
	 * @return String poletd1
	 */
	public String getPoletd1() {
		return this.poletd1;
	}
	
	/**
	 *
	 * @param String podeta1
	 */
	public void setPodeta1(String podeta1) {
		this.podeta1 = podeta1;
	}
	
	/**
	 * 
	 * @return String podeta1
	 */
	public String getPodeta1() {
		return this.podeta1;
	}
	
	/**
	 *
	 * @param String podetd1
	 */
	public void setPodetd1(String podetd1) {
		this.podetd1 = podetd1;
	}
	
	/**
	 * 
	 * @return String podetd1
	 */
	public String getPodetd1() {
		return this.podetd1;
	}
	
	/**
	 *
	 * @param String opCode
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	
	/**
	 * 
	 * @return String opCode
	 */
	public String getOpCode() {
		return this.opCode;
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
		setPortname(JSPUtil.getParameter(request, prefix + "portname", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setAta(JSPUtil.getParameter(request, prefix + "ata", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setNextport(JSPUtil.getParameter(request, prefix + "nextport", ""));
		setNextportEta(JSPUtil.getParameter(request, prefix + "nextport_eta", ""));
		setPrevport(JSPUtil.getParameter(request, prefix + "prevport", ""));
		setPrevportEtd(JSPUtil.getParameter(request, prefix + "prevport_etd", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setVvdtype(JSPUtil.getParameter(request, prefix + "vvdtype", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setBvvd1(JSPUtil.getParameter(request, prefix + "bvvd1", ""));
		setVslCallsign1(JSPUtil.getParameter(request, prefix + "vsl_callsign1", ""));
		setVslLloydcode1(JSPUtil.getParameter(request, prefix + "vsl_lloydcode1", ""));
		setVslFullname1(JSPUtil.getParameter(request, prefix + "vsl_fullname1", ""));
		setVslFlag1(JSPUtil.getParameter(request, prefix + "vsl_flag1", ""));
		setBlpol1(JSPUtil.getParameter(request, prefix + "blpol1", ""));
		setPolYd(JSPUtil.getParameter(request, prefix + "pol_yd", ""));
		setPolFullname1(JSPUtil.getParameter(request, prefix + "pol_fullname1", ""));
		setBlpod1(JSPUtil.getParameter(request, prefix + "blpod1", ""));
		setPodYd(JSPUtil.getParameter(request, prefix + "pod_yd", ""));
		setPodFullname1(JSPUtil.getParameter(request, prefix + "pod_fullname1", ""));
		setPoleta1(JSPUtil.getParameter(request, prefix + "poleta1", ""));
		setPoletd1(JSPUtil.getParameter(request, prefix + "poletd1", ""));
		setPodeta1(JSPUtil.getParameter(request, prefix + "podeta1", ""));
		setPodetd1(JSPUtil.getParameter(request, prefix + "podetd1", ""));
		setOpCode(JSPUtil.getParameter(request, prefix + "op_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlRoutVO[]
	 */
	public SitProBlLdfBlRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlRoutVO[]
	 */
	public SitProBlLdfBlRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlRoutVO model = null;
		
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
			String[] portname = (JSPUtil.getParameter(request, prefix	+ "portname", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] ata = (JSPUtil.getParameter(request, prefix	+ "ata", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] nextport = (JSPUtil.getParameter(request, prefix	+ "nextport", length));
			String[] nextportEta = (JSPUtil.getParameter(request, prefix	+ "nextport_eta", length));
			String[] prevport = (JSPUtil.getParameter(request, prefix	+ "prevport", length));
			String[] prevportEtd = (JSPUtil.getParameter(request, prefix	+ "prevport_etd", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] vvdtype = (JSPUtil.getParameter(request, prefix	+ "vvdtype", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] bvvd1 = (JSPUtil.getParameter(request, prefix	+ "bvvd1", length));
			String[] vslCallsign1 = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign1", length));
			String[] vslLloydcode1 = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode1", length));
			String[] vslFullname1 = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname1", length));
			String[] vslFlag1 = (JSPUtil.getParameter(request, prefix	+ "vsl_flag1", length));
			String[] blpol1 = (JSPUtil.getParameter(request, prefix	+ "blpol1", length));
			String[] polYd = (JSPUtil.getParameter(request, prefix	+ "pol_yd", length));
			String[] polFullname1 = (JSPUtil.getParameter(request, prefix	+ "pol_fullname1", length));
			String[] blpod1 = (JSPUtil.getParameter(request, prefix	+ "blpod1", length));
			String[] podYd = (JSPUtil.getParameter(request, prefix	+ "pod_yd", length));
			String[] podFullname1 = (JSPUtil.getParameter(request, prefix	+ "pod_fullname1", length));
			String[] poleta1 = (JSPUtil.getParameter(request, prefix	+ "poleta1", length));
			String[] poletd1 = (JSPUtil.getParameter(request, prefix	+ "poletd1", length));
			String[] podeta1 = (JSPUtil.getParameter(request, prefix	+ "podeta1", length));
			String[] podetd1 = (JSPUtil.getParameter(request, prefix	+ "podetd1", length));
			String[] opCode = (JSPUtil.getParameter(request, prefix	+ "op_code", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlRoutVO();
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
				if (portname[i] != null) 
					model.setPortname(portname[i]);
				if (eta[i] != null) 
					model.setEta(eta[i]);
				if (etd[i] != null) 
					model.setEtd(etd[i]);
				if (ata[i] != null) 
					model.setAta(ata[i]);
				if (atd[i] != null) 
					model.setAtd(atd[i]);
				if (nextport[i] != null) 
					model.setNextport(nextport[i]);
				if (nextportEta[i] != null) 
					model.setNextportEta(nextportEta[i]);
				if (prevport[i] != null) 
					model.setPrevport(prevport[i]);
				if (prevportEtd[i] != null) 
					model.setPrevportEtd(prevportEtd[i]);
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
				if (vvdtype[i] != null) 
					model.setVvdtype(vvdtype[i]);
				if (laneCd[i] != null) 
					model.setLaneCd(laneCd[i]);
				if (bvvd1[i] != null) 
					model.setBvvd1(bvvd1[i]);
				if (vslCallsign1[i] != null) 
					model.setVslCallsign1(vslCallsign1[i]);
				if (vslLloydcode1[i] != null) 
					model.setVslLloydcode1(vslLloydcode1[i]);
				if (vslFullname1[i] != null) 
					model.setVslFullname1(vslFullname1[i]);
				if (vslFlag1[i] != null) 
					model.setVslFlag1(vslFlag1[i]);
				if (blpol1[i] != null) 
					model.setBlpol1(blpol1[i]);
				if (polYd[i] != null) 
					model.setPolYd(polYd[i]);
				if (polFullname1[i] != null) 
					model.setPolFullname1(polFullname1[i]);
				if (blpod1[i] != null) 
					model.setBlpod1(blpod1[i]);
				if (podYd[i] != null) 
					model.setPodYd(podYd[i]);
				if (podFullname1[i] != null) 
					model.setPodFullname1(podFullname1[i]);
				if (poleta1[i] != null) 
					model.setPoleta1(poleta1[i]);
				if (poletd1[i] != null) 
					model.setPoletd1(poletd1[i]);
				if (podeta1[i] != null) 
					model.setPodeta1(podeta1[i]);
				if (podetd1[i] != null) 
					model.setPodetd1(podetd1[i]);
				if (opCode[i] != null) 
					model.setOpCode(opCode[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlRoutVO[]
	 */
	public SitProBlLdfBlRoutVO[] getSitProBlLdfBlRoutVOs(){
		SitProBlLdfBlRoutVO[] vos = (SitProBlLdfBlRoutVO[])models.toArray(new SitProBlLdfBlRoutVO[models.size()]);
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
		this.portname = this.portname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ata = this.ata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextport = this.nextport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextportEta = this.nextportEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevport = this.prevport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevportEtd = this.prevportEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdtype = this.vvdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvvd1 = this.bvvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign1 = this.vslCallsign1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode1 = this.vslLloydcode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname1 = this.vslFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag1 = this.vslFlag1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol1 = this.blpol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYd = this.polYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname1 = this.polFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod1 = this.blpod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYd = this.podYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname1 = this.podFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poleta1 = this.poleta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletd1 = this.poletd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podeta1 = this.podeta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetd1 = this.podetd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCode = this.opCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}