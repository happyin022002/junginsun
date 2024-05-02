/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpBlPrtVO.java
*@FileTitle : GrpBlPrtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.12.10 이일민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpBlPrtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlPrtVO> models = new ArrayList<GrpBlPrtVO>();
	
	/* Column Info */
	private String aSc = null;
	/* Column Info */
	private String ca = null;
	/* Column Info */
	private String oblPrnFlg = null;
	/* Column Info */
	private String blActWgt = null;
	/* Column Info */
	private String consignee = null;
	/* Column Info */
	private String blBkgNo = null;
	/* Column Info */
	private String manifest = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String delEq = null;
	/* Column Info */
	private String aS = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porEq = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String dSc = null;
	/* Column Info */
	private String blMeasQty = null;
	/* Column Info */
	private String bSc = null;
	/* Column Info */
	private String caed = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String st = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String aes = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String orderCol = null;
	/* Column Info */
	private String twnSoNo = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rSc = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String commodity = null;
	/* Column Info */
	private String polPod = null;
	/* Column Info */
	private String rTerm = null;
	/* Column Info */
	private String rep = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String feu = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlPrtVO() {}

	public GrpBlPrtVO(String ibflag, String pagerows, String bkgNo, String polPod, String blNo, String por, String pol, String pod, String del, String rTerm, String dTerm, String polCd, String podCd, String rep, String commodity, String dSc, String rSc, String aSc, String bSc, String aS, String st, String bdr, String ca, String twnSoNo, String porEq, String delEq, String scRfaNo, String aes, String caed, String manifest, String rate, String shipper, String consignee, String orderCol, String blBkgNo, String blActWgt, String blMeasQty, String oblIssFlg, String oblPrnFlg, String oblRlseFlg, String teu, String feu) {
		this.aSc = aSc;
		this.ca = ca;
		this.oblPrnFlg = oblPrnFlg;
		this.blActWgt = blActWgt;
		this.consignee = consignee;
		this.blBkgNo = blBkgNo;
		this.manifest = manifest;
		this.por = por;
		this.delEq = delEq;
		this.aS = aS;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.porEq = porEq;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.rate = rate;
		this.dSc = dSc;
		this.blMeasQty = blMeasQty;
		this.bSc = bSc;
		this.caed = caed;
		this.pol = pol;
		this.bdr = bdr;
		this.del = del;
		this.st = st;
		this.dTerm = dTerm;
		this.pod = pod;
		this.oblIssFlg = oblIssFlg;
		this.aes = aes;
		this.shipper = shipper;
		this.orderCol = orderCol;
		this.twnSoNo = twnSoNo;
		this.oblRlseFlg = oblRlseFlg;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.rSc = rSc;
		this.scRfaNo = scRfaNo;
		this.commodity = commodity;
		this.polPod = polPod;
		this.rTerm = rTerm;
		this.rep = rep;
		this.teu = teu;
		this.feu = feu;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a_sc", getASc());
		this.hashColumns.put("ca", getCa());
		this.hashColumns.put("obl_prn_flg", getOblPrnFlg());
		this.hashColumns.put("bl_act_wgt", getBlActWgt());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("bl_bkg_no", getBlBkgNo());
		this.hashColumns.put("manifest", getManifest());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("del_eq", getDelEq());
		this.hashColumns.put("a_s", getAS());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_eq", getPorEq());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("d_sc", getDSc());
		this.hashColumns.put("bl_meas_qty", getBlMeasQty());
		this.hashColumns.put("b_sc", getBSc());
		this.hashColumns.put("caed", getCaed());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("st", getSt());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("aes", getAes());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("order_col", getOrderCol());
		this.hashColumns.put("twn_so_no", getTwnSoNo());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("r_sc", getRSc());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("pol_pod", getPolPod());
		this.hashColumns.put("r_term", getRTerm());
		this.hashColumns.put("rep", getRep());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("feu", getFeu());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a_sc", "aSc");
		this.hashFields.put("ca", "ca");
		this.hashFields.put("obl_prn_flg", "oblPrnFlg");
		this.hashFields.put("bl_act_wgt", "blActWgt");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("bl_bkg_no", "blBkgNo");
		this.hashFields.put("manifest", "manifest");
		this.hashFields.put("por", "por");
		this.hashFields.put("del_eq", "delEq");
		this.hashFields.put("a_s", "aS");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_eq", "porEq");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("d_sc", "dSc");
		this.hashFields.put("bl_meas_qty", "blMeasQty");
		this.hashFields.put("b_sc", "bSc");
		this.hashFields.put("caed", "caed");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("del", "del");
		this.hashFields.put("st", "st");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("aes", "aes");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("order_col", "orderCol");
		this.hashFields.put("twn_so_no", "twnSoNo");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("r_sc", "rSc");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("pol_pod", "polPod");
		this.hashFields.put("r_term", "rTerm");
		this.hashFields.put("rep", "rep");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("feu", "feu");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aSc
	 */
	public String getASc() {
		return this.aSc;
	}
	
	/**
	 * Column Info
	 * @return ca
	 */
	public String getCa() {
		return this.ca;
	}
	
	/**
	 * Column Info
	 * @return oblPrnFlg
	 */
	public String getOblPrnFlg() {
		return this.oblPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return blActWgt
	 */
	public String getBlActWgt() {
		return this.blActWgt;
	}
	
	/**
	 * Column Info
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
	}
	
	/**
	 * Column Info
	 * @return blBkgNo
	 */
	public String getBlBkgNo() {
		return this.blBkgNo;
	}
	
	/**
	 * Column Info
	 * @return manifest
	 */
	public String getManifest() {
		return this.manifest;
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
	 * @return delEq
	 */
	public String getDelEq() {
		return this.delEq;
	}
	
	/**
	 * Column Info
	 * @return aS
	 */
	public String getAS() {
		return this.aS;
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
	 * @return porEq
	 */
	public String getPorEq() {
		return this.porEq;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return dSc
	 */
	public String getDSc() {
		return this.dSc;
	}
	
	/**
	 * Column Info
	 * @return blMeasQty
	 */
	public String getBlMeasQty() {
		return this.blMeasQty;
	}
	
	/**
	 * Column Info
	 * @return bSc
	 */
	public String getBSc() {
		return this.bSc;
	}
	
	/**
	 * Column Info
	 * @return caed
	 */
	public String getCaed() {
		return this.caed;
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
	 * @return bdr
	 */
	public String getBdr() {
		return this.bdr;
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
	 * @return st
	 */
	public String getSt() {
		return this.st;
	}
	
	/**
	 * Column Info
	 * @return dTerm
	 */
	public String getDTerm() {
		return this.dTerm;
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
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return aes
	 */
	public String getAes() {
		return this.aes;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
	}
	
	/**
	 * Column Info
	 * @return orderCol
	 */
	public String getOrderCol() {
		return this.orderCol;
	}
	
	/**
	 * Column Info
	 * @return twnSoNo
	 */
	public String getTwnSoNo() {
		return this.twnSoNo;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
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
	 * @return rSc
	 */
	public String getRSc() {
		return this.rSc;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return commodity
	 */
	public String getCommodity() {
		return this.commodity;
	}
	
	/**
	 * Column Info
	 * @return polPod
	 */
	public String getPolPod() {
		return this.polPod;
	}
	
	/**
	 * Column Info
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
	}
	
	/**
	 * Column Info
	 * @return rep
	 */
	public String getRep() {
		return this.rep;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	

	/**
	 * Column Info
	 * @param aSc
	 */
	public void setASc(String aSc) {
		this.aSc = aSc;
	}
	
	/**
	 * Column Info
	 * @param ca
	 */
	public void setCa(String ca) {
		this.ca = ca;
	}
	
	/**
	 * Column Info
	 * @param oblPrnFlg
	 */
	public void setOblPrnFlg(String oblPrnFlg) {
		this.oblPrnFlg = oblPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param blActWgt
	 */
	public void setBlActWgt(String blActWgt) {
		this.blActWgt = blActWgt;
	}
	
	/**
	 * Column Info
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * Column Info
	 * @param blBkgNo
	 */
	public void setBlBkgNo(String blBkgNo) {
		this.blBkgNo = blBkgNo;
	}
	
	/**
	 * Column Info
	 * @param manifest
	 */
	public void setManifest(String manifest) {
		this.manifest = manifest;
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
	 * @param delEq
	 */
	public void setDelEq(String delEq) {
		this.delEq = delEq;
	}
	
	/**
	 * Column Info
	 * @param aS
	 */
	public void setAS(String aS) {
		this.aS = aS;
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
	 * @param porEq
	 */
	public void setPorEq(String porEq) {
		this.porEq = porEq;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param dSc
	 */
	public void setDSc(String dSc) {
		this.dSc = dSc;
	}
	
	/**
	 * Column Info
	 * @param blMeasQty
	 */
	public void setBlMeasQty(String blMeasQty) {
		this.blMeasQty = blMeasQty;
	}
	
	/**
	 * Column Info
	 * @param bSc
	 */
	public void setBSc(String bSc) {
		this.bSc = bSc;
	}
	
	/**
	 * Column Info
	 * @param caed
	 */
	public void setCaed(String caed) {
		this.caed = caed;
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
	 * @param bdr
	 */
	public void setBdr(String bdr) {
		this.bdr = bdr;
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
	 * @param st
	 */
	public void setSt(String st) {
		this.st = st;
	}
	
	/**
	 * Column Info
	 * @param dTerm
	 */
	public void setDTerm(String dTerm) {
		this.dTerm = dTerm;
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
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param aes
	 */
	public void setAes(String aes) {
		this.aes = aes;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	
	/**
	 * Column Info
	 * @param orderCol
	 */
	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}
	
	/**
	 * Column Info
	 * @param twnSoNo
	 */
	public void setTwnSoNo(String twnSoNo) {
		this.twnSoNo = twnSoNo;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param rSc
	 */
	public void setRSc(String rSc) {
		this.rSc = rSc;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param commodity
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	
	/**
	 * Column Info
	 * @param polPod
	 */
	public void setPolPod(String polPod) {
		this.polPod = polPod;
	}
	
	/**
	 * Column Info
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
	}
	
	/**
	 * Column Info
	 * @param rep
	 */
	public void setRep(String rep) {
		this.rep = rep;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setASc(JSPUtil.getParameter(request, "a_sc", ""));
		setCa(JSPUtil.getParameter(request, "ca", ""));
		setOblPrnFlg(JSPUtil.getParameter(request, "obl_prn_flg", ""));
		setBlActWgt(JSPUtil.getParameter(request, "bl_act_wgt", ""));
		setConsignee(JSPUtil.getParameter(request, "consignee", ""));
		setBlBkgNo(JSPUtil.getParameter(request, "bl_bkg_no", ""));
		setManifest(JSPUtil.getParameter(request, "manifest", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setDelEq(JSPUtil.getParameter(request, "del_eq", ""));
		setAS(JSPUtil.getParameter(request, "a_s", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPorEq(JSPUtil.getParameter(request, "por_eq", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setDSc(JSPUtil.getParameter(request, "d_sc", ""));
		setBlMeasQty(JSPUtil.getParameter(request, "bl_meas_qty", ""));
		setBSc(JSPUtil.getParameter(request, "b_sc", ""));
		setCaed(JSPUtil.getParameter(request, "caed", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setBdr(JSPUtil.getParameter(request, "bdr", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setSt(JSPUtil.getParameter(request, "st", ""));
		setDTerm(JSPUtil.getParameter(request, "d_term", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setOblIssFlg(JSPUtil.getParameter(request, "obl_iss_flg", ""));
		setAes(JSPUtil.getParameter(request, "aes", ""));
		setShipper(JSPUtil.getParameter(request, "shipper", ""));
		setOrderCol(JSPUtil.getParameter(request, "order_col", ""));
		setTwnSoNo(JSPUtil.getParameter(request, "twn_so_no", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, "obl_rlse_flg", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRSc(JSPUtil.getParameter(request, "r_sc", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setCommodity(JSPUtil.getParameter(request, "commodity", ""));
		setPolPod(JSPUtil.getParameter(request, "pol_pod", ""));
		setRTerm(JSPUtil.getParameter(request, "r_term", ""));
		setRep(JSPUtil.getParameter(request, "rep", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
		setFeu(JSPUtil.getParameter(request, "feu", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrpBlPrtVO[]
	 */
	public GrpBlPrtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GrpBlPrtVO[]
	 */
	public GrpBlPrtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrpBlPrtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aSc = (JSPUtil.getParameter(request, prefix	+ "a_sc", length));
			String[] ca = (JSPUtil.getParameter(request, prefix	+ "ca", length));
			String[] oblPrnFlg = (JSPUtil.getParameter(request, prefix	+ "obl_prn_flg", length));
			String[] blActWgt = (JSPUtil.getParameter(request, prefix	+ "bl_act_wgt", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] blBkgNo = (JSPUtil.getParameter(request, prefix	+ "bl_bkg_no", length));
			String[] manifest = (JSPUtil.getParameter(request, prefix	+ "manifest", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] delEq = (JSPUtil.getParameter(request, prefix	+ "del_eq", length));
			String[] aS = (JSPUtil.getParameter(request, prefix	+ "a_s", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porEq = (JSPUtil.getParameter(request, prefix	+ "por_eq", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] dSc = (JSPUtil.getParameter(request, prefix	+ "d_sc", length));
			String[] blMeasQty = (JSPUtil.getParameter(request, prefix	+ "bl_meas_qty", length));
			String[] bSc = (JSPUtil.getParameter(request, prefix	+ "b_sc", length));
			String[] caed = (JSPUtil.getParameter(request, prefix	+ "caed", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] st = (JSPUtil.getParameter(request, prefix	+ "st", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] aes = (JSPUtil.getParameter(request, prefix	+ "aes", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] orderCol = (JSPUtil.getParameter(request, prefix	+ "order_col", length));
			String[] twnSoNo = (JSPUtil.getParameter(request, prefix	+ "twn_so_no", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rSc = (JSPUtil.getParameter(request, prefix	+ "r_sc", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] polPod = (JSPUtil.getParameter(request, prefix	+ "pol_pod", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			String[] rep = (JSPUtil.getParameter(request, prefix	+ "rep", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlPrtVO();
				if (aSc[i] != null)
					model.setASc(aSc[i]);
				if (ca[i] != null)
					model.setCa(ca[i]);
				if (oblPrnFlg[i] != null)
					model.setOblPrnFlg(oblPrnFlg[i]);
				if (blActWgt[i] != null)
					model.setBlActWgt(blActWgt[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (blBkgNo[i] != null)
					model.setBlBkgNo(blBkgNo[i]);
				if (manifest[i] != null)
					model.setManifest(manifest[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (delEq[i] != null)
					model.setDelEq(delEq[i]);
				if (aS[i] != null)
					model.setAS(aS[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porEq[i] != null)
					model.setPorEq(porEq[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (dSc[i] != null)
					model.setDSc(dSc[i]);
				if (blMeasQty[i] != null)
					model.setBlMeasQty(blMeasQty[i]);
				if (bSc[i] != null)
					model.setBSc(bSc[i]);
				if (caed[i] != null)
					model.setCaed(caed[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (st[i] != null)
					model.setSt(st[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (aes[i] != null)
					model.setAes(aes[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (orderCol[i] != null)
					model.setOrderCol(orderCol[i]);
				if (twnSoNo[i] != null)
					model.setTwnSoNo(twnSoNo[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rSc[i] != null)
					model.setRSc(rSc[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (commodity[i] != null)
					model.setCommodity(commodity[i]);
				if (polPod[i] != null)
					model.setPolPod(polPod[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				if (rep[i] != null)
					model.setRep(rep[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrpBlPrtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrpBlPrtVO[]
	 */
	public GrpBlPrtVO[] getGrpBlPrtVOs(){
		GrpBlPrtVO[] vos = (GrpBlPrtVO[])models.toArray(new GrpBlPrtVO[models.size()]);
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
		this.aSc = this.aSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ca = this.ca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblPrnFlg = this.oblPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blActWgt = this.blActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blBkgNo = this.blBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manifest = this.manifest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEq = this.delEq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aS = this.aS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEq = this.porEq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dSc = this.dSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeasQty = this.blMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bSc = this.bSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caed = this.caed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st = this.st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aes = this.aes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderCol = this.orderCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnSoNo = this.twnSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSc = this.rSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rep = this.rep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
