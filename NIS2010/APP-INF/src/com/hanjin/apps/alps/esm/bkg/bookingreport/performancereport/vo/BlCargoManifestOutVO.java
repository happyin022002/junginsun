/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BlCargoManifestOutVO.java
*@FileTitle : BlCargoManifestOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.18
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.18 김보배 
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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCargoManifestOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCargoManifestOutVO> models = new ArrayList<BlCargoManifestOutVO>();
	
	/* Column Info */
	private String hdEtaEtd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String totalLbs = null;
	/* Column Info */
	private String prePostVvd = null;
	/* Column Info */
	private String ca = null;
	/* Column Info */
	private String orderBy = null;
	/* Column Info */
	private String wgt2 = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String wgt1 = null;
	/* Column Info */
	private String delYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String groupTitle = null;
	/* Column Info */
	private String groupTotal = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prePostPolCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String hdModeType = null;
	/* Column Info */
	private String hdPolPod = null;
	/* Column Info */
	private String bb = null;
	/* Column Info */
	private String hdPolPodCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String groupEtdEta = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String prePostPodYdCd = null;
	/* Column Info */
	private String prePostPodCd = null;
	/* Column Info */
	private String orderByTitle = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String hdEtaEtdCd = null;
	/* Column Info */
	private String lt = null;
	/* Column Info */
	private String rf = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dg = null;
	/* Column Info */
	private String totalPkg = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String totalKgs = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String kgs = null;
	/* Column Info */
	private String hdVvdCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String prePostPolYdCd = null;
	/* Column Info */
	private String rdCd2 = null;
	/* Column Info */
	private String rdCd1 = null;
	/* Column Info */
	private String asCd = null;
	/* Column Info */
	private String groupPolPod = null;
	/* Column Info */
	private String pkg1 = null;
	/* Column Info */
	private String aw = null;
	/* Column Info */
	private String pkg2 = null;
	/* Column Info */
	private String cbf = null;
	/* Column Info */
	private String ef = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String cbm = null;
	/* Column Info */
	private String prePost = null;
	/* Column Info */
	private String lbs = null;
	/* Column Info */
	private String rep = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCargoManifestOutVO() {}

	public BlCargoManifestOutVO(String ibflag, String pagerows, String seqNo, String groupTitle, String groupTotal, String totalPkg, String totalKgs, String totalLbs, String hdVvdCd, String hdPolPod, String hdPolPodCd, String hdEtaEtd, String hdEtaEtdCd, String hdModeType, String prePostVvd, String prePostPolCd, String prePostPolYdCd, String prePostPodCd, String prePostPodYdCd, String bkgNo, String bkgCgoTpCd, String blNo, String porCd, String polCd, String polYdCd, String podCd, String podYdCd, String delCd, String delYdCd, String rdCd1, String rdCd2, String lt, String ef, String pkg1, String pkg2, String wgt1, String wgt2, String soNo, String rep, String asCd, String dg, String rf, String aw, String bb, String bdr, String ca, String measQty, String measUtCd, String lbs, String kgs, String cbf, String cbm, String prePost, String header, String groupEtdEta, String groupPolPod, String orderByTitle, String orderBy, String slanCd) {
		this.hdEtaEtd = hdEtaEtd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.totalLbs = totalLbs;
		this.prePostVvd = prePostVvd;
		this.ca = ca;
		this.orderBy = orderBy;
		this.wgt2 = wgt2;
		this.seqNo = seqNo;
		this.wgt1 = wgt1;
		this.delYdCd = delYdCd;
		this.blNo = blNo;
		this.groupTitle = groupTitle;
		this.groupTotal = groupTotal;
		this.pagerows = pagerows;
		this.prePostPolCd = prePostPolCd;
		this.polCd = polCd;
		this.hdModeType = hdModeType;
		this.hdPolPod = hdPolPod;
		this.bb = bb;
		this.hdPolPodCd = hdPolPodCd;
		this.soNo = soNo;
		this.delCd = delCd;
		this.header = header;
		this.podCd = podCd;
		this.groupEtdEta = groupEtdEta;
		this.bkgNo = bkgNo;
		this.prePostPodYdCd = prePostPodYdCd;
		this.prePostPodCd = prePostPodCd;
		this.orderByTitle = orderByTitle;
		this.porCd = porCd;
		this.hdEtaEtdCd = hdEtaEtdCd;
		this.lt = lt;
		this.rf = rf;
		this.ibflag = ibflag;
		this.dg = dg;
		this.totalPkg = totalPkg;
		this.measQty = measQty;
		this.totalKgs = totalKgs;
		this.bdr = bdr;
		this.kgs = kgs;
		this.hdVvdCd = hdVvdCd;
		this.podYdCd = podYdCd;
		this.measUtCd = measUtCd;
		this.prePostPolYdCd = prePostPolYdCd;
		this.rdCd2 = rdCd2;
		this.rdCd1 = rdCd1;
		this.asCd = asCd;
		this.groupPolPod = groupPolPod;
		this.pkg1 = pkg1;
		this.aw = aw;
		this.pkg2 = pkg2;
		this.cbf = cbf;
		this.ef = ef;
		this.slanCd = slanCd;
		this.polYdCd = polYdCd;
		this.cbm = cbm;
		this.prePost = prePost;
		this.lbs = lbs;
		this.rep = rep;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hd_eta_etd", getHdEtaEtd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("total_lbs", getTotalLbs());
		this.hashColumns.put("pre_post_vvd", getPrePostVvd());
		this.hashColumns.put("ca", getCa());
		this.hashColumns.put("order_by", getOrderBy());
		this.hashColumns.put("wgt2", getWgt2());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("wgt1", getWgt1());
		this.hashColumns.put("del_yd_cd", getDelYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("group_title", getGroupTitle());
		this.hashColumns.put("group_total", getGroupTotal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_post_pol_cd", getPrePostPolCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("hd_mode_type", getHdModeType());
		this.hashColumns.put("hd_pol_pod", getHdPolPod());
		this.hashColumns.put("bb", getBb());
		this.hashColumns.put("hd_pol_pod_cd", getHdPolPodCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("group_etd_eta", getGroupEtdEta());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pre_post_pod_yd_cd", getPrePostPodYdCd());
		this.hashColumns.put("pre_post_pod_cd", getPrePostPodCd());
		this.hashColumns.put("order_by_title", getOrderByTitle());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("hd_eta_etd_cd", getHdEtaEtdCd());
		this.hashColumns.put("lt", getLt());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("total_pkg", getTotalPkg());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("total_kgs", getTotalKgs());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("kgs", getKgs());
		this.hashColumns.put("hd_vvd_cd", getHdVvdCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pre_post_pol_yd_cd", getPrePostPolYdCd());
		this.hashColumns.put("rd_cd2", getRdCd2());
		this.hashColumns.put("rd_cd1", getRdCd1());
		this.hashColumns.put("as_cd", getAsCd());
		this.hashColumns.put("group_pol_pod", getGroupPolPod());
		this.hashColumns.put("pkg1", getPkg1());
		this.hashColumns.put("aw", getAw());
		this.hashColumns.put("pkg2", getPkg2());
		this.hashColumns.put("cbf", getCbf());
		this.hashColumns.put("ef", getEf());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cbm", getCbm());
		this.hashColumns.put("pre_post", getPrePost());
		this.hashColumns.put("lbs", getLbs());
		this.hashColumns.put("rep", getRep());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hd_eta_etd", "hdEtaEtd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("total_lbs", "totalLbs");
		this.hashFields.put("pre_post_vvd", "prePostVvd");
		this.hashFields.put("ca", "ca");
		this.hashFields.put("order_by", "orderBy");
		this.hashFields.put("wgt2", "wgt2");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("wgt1", "wgt1");
		this.hashFields.put("del_yd_cd", "delYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("group_title", "groupTitle");
		this.hashFields.put("group_total", "groupTotal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_post_pol_cd", "prePostPolCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("hd_mode_type", "hdModeType");
		this.hashFields.put("hd_pol_pod", "hdPolPod");
		this.hashFields.put("bb", "bb");
		this.hashFields.put("hd_pol_pod_cd", "hdPolPodCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("header", "header");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("group_etd_eta", "groupEtdEta");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pre_post_pod_yd_cd", "prePostPodYdCd");
		this.hashFields.put("pre_post_pod_cd", "prePostPodCd");
		this.hashFields.put("order_by_title", "orderByTitle");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("hd_eta_etd_cd", "hdEtaEtdCd");
		this.hashFields.put("lt", "lt");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("total_pkg", "totalPkg");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("total_kgs", "totalKgs");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("kgs", "kgs");
		this.hashFields.put("hd_vvd_cd", "hdVvdCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pre_post_pol_yd_cd", "prePostPolYdCd");
		this.hashFields.put("rd_cd2", "rdCd2");
		this.hashFields.put("rd_cd1", "rdCd1");
		this.hashFields.put("as_cd", "asCd");
		this.hashFields.put("group_pol_pod", "groupPolPod");
		this.hashFields.put("pkg1", "pkg1");
		this.hashFields.put("aw", "aw");
		this.hashFields.put("pkg2", "pkg2");
		this.hashFields.put("cbf", "cbf");
		this.hashFields.put("ef", "ef");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cbm", "cbm");
		this.hashFields.put("pre_post", "prePost");
		this.hashFields.put("lbs", "lbs");
		this.hashFields.put("rep", "rep");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hdEtaEtd
	 */
	public String getHdEtaEtd() {
		return this.hdEtaEtd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return totalLbs
	 */
	public String getTotalLbs() {
		return this.totalLbs;
	}
	
	/**
	 * Column Info
	 * @return prePostVvd
	 */
	public String getPrePostVvd() {
		return this.prePostVvd;
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
	 * @return orderBy
	 */
	public String getOrderBy() {
		return this.orderBy;
	}
	
	/**
	 * Column Info
	 * @return wgt2
	 */
	public String getWgt2() {
		return this.wgt2;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return wgt1
	 */
	public String getWgt1() {
		return this.wgt1;
	}
	
	/**
	 * Column Info
	 * @return delYdCd
	 */
	public String getDelYdCd() {
		return this.delYdCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return groupTitle
	 */
	public String getGroupTitle() {
		return this.groupTitle;
	}
	
	/**
	 * Column Info
	 * @return groupTotal
	 */
	public String getGroupTotal() {
		return this.groupTotal;
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
	 * @return prePostPolCd
	 */
	public String getPrePostPolCd() {
		return this.prePostPolCd;
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
	 * @return hdModeType
	 */
	public String getHdModeType() {
		return this.hdModeType;
	}
	
	/**
	 * Column Info
	 * @return hdPolPod
	 */
	public String getHdPolPod() {
		return this.hdPolPod;
	}
	
	/**
	 * Column Info
	 * @return bb
	 */
	public String getBb() {
		return this.bb;
	}
	
	/**
	 * Column Info
	 * @return hdPolPodCd
	 */
	public String getHdPolPodCd() {
		return this.hdPolPodCd;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
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
	 * @return header
	 */
	public String getHeader() {
		return this.header;
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
	 * @return groupEtdEta
	 */
	public String getGroupEtdEta() {
		return this.groupEtdEta;
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
	 * @return prePostPodYdCd
	 */
	public String getPrePostPodYdCd() {
		return this.prePostPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return prePostPodCd
	 */
	public String getPrePostPodCd() {
		return this.prePostPodCd;
	}
	
	/**
	 * Column Info
	 * @return orderByTitle
	 */
	public String getOrderByTitle() {
		return this.orderByTitle;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return hdEtaEtdCd
	 */
	public String getHdEtaEtdCd() {
		return this.hdEtaEtdCd;
	}
	
	/**
	 * Column Info
	 * @return lt
	 */
	public String getLt() {
		return this.lt;
	}
	
	/**
	 * Column Info
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
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
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
	}
	
	/**
	 * Column Info
	 * @return totalPkg
	 */
	public String getTotalPkg() {
		return this.totalPkg;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return totalKgs
	 */
	public String getTotalKgs() {
		return this.totalKgs;
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
	 * @return kgs
	 */
	public String getKgs() {
		return this.kgs;
	}
	
	/**
	 * Column Info
	 * @return hdVvdCd
	 */
	public String getHdVvdCd() {
		return this.hdVvdCd;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return prePostPolYdCd
	 */
	public String getPrePostPolYdCd() {
		return this.prePostPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return rdCd2
	 */
	public String getRdCd2() {
		return this.rdCd2;
	}
	
	/**
	 * Column Info
	 * @return rdCd1
	 */
	public String getRdCd1() {
		return this.rdCd1;
	}
	
	/**
	 * Column Info
	 * @return asCd
	 */
	public String getAsCd() {
		return this.asCd;
	}
	
	/**
	 * Column Info
	 * @return groupPolPod
	 */
	public String getGroupPolPod() {
		return this.groupPolPod;
	}
	
	/**
	 * Column Info
	 * @return pkg1
	 */
	public String getPkg1() {
		return this.pkg1;
	}
	
	/**
	 * Column Info
	 * @return aw
	 */
	public String getAw() {
		return this.aw;
	}
	
	/**
	 * Column Info
	 * @return pkg2
	 */
	public String getPkg2() {
		return this.pkg2;
	}
	
	/**
	 * Column Info
	 * @return cbf
	 */
	public String getCbf() {
		return this.cbf;
	}
	
	/**
	 * Column Info
	 * @return ef
	 */
	public String getEf() {
		return this.ef;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return cbm
	 */
	public String getCbm() {
		return this.cbm;
	}
	
	/**
	 * Column Info
	 * @return prePost
	 */
	public String getPrePost() {
		return this.prePost;
	}
	
	/**
	 * Column Info
	 * @return lbs
	 */
	public String getLbs() {
		return this.lbs;
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
	 * @param hdEtaEtd
	 */
	public void setHdEtaEtd(String hdEtaEtd) {
		this.hdEtaEtd = hdEtaEtd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param totalLbs
	 */
	public void setTotalLbs(String totalLbs) {
		this.totalLbs = totalLbs;
	}
	
	/**
	 * Column Info
	 * @param prePostVvd
	 */
	public void setPrePostVvd(String prePostVvd) {
		this.prePostVvd = prePostVvd;
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
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * Column Info
	 * @param wgt2
	 */
	public void setWgt2(String wgt2) {
		this.wgt2 = wgt2;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param wgt1
	 */
	public void setWgt1(String wgt1) {
		this.wgt1 = wgt1;
	}
	
	/**
	 * Column Info
	 * @param delYdCd
	 */
	public void setDelYdCd(String delYdCd) {
		this.delYdCd = delYdCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param groupTitle
	 */
	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
	
	/**
	 * Column Info
	 * @param groupTotal
	 */
	public void setGroupTotal(String groupTotal) {
		this.groupTotal = groupTotal;
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
	 * @param prePostPolCd
	 */
	public void setPrePostPolCd(String prePostPolCd) {
		this.prePostPolCd = prePostPolCd;
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
	 * @param hdModeType
	 */
	public void setHdModeType(String hdModeType) {
		this.hdModeType = hdModeType;
	}
	
	/**
	 * Column Info
	 * @param hdPolPod
	 */
	public void setHdPolPod(String hdPolPod) {
		this.hdPolPod = hdPolPod;
	}
	
	/**
	 * Column Info
	 * @param bb
	 */
	public void setBb(String bb) {
		this.bb = bb;
	}
	
	/**
	 * Column Info
	 * @param hdPolPodCd
	 */
	public void setHdPolPodCd(String hdPolPodCd) {
		this.hdPolPodCd = hdPolPodCd;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
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
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
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
	 * @param groupEtdEta
	 */
	public void setGroupEtdEta(String groupEtdEta) {
		this.groupEtdEta = groupEtdEta;
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
	 * @param prePostPodYdCd
	 */
	public void setPrePostPodYdCd(String prePostPodYdCd) {
		this.prePostPodYdCd = prePostPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param prePostPodCd
	 */
	public void setPrePostPodCd(String prePostPodCd) {
		this.prePostPodCd = prePostPodCd;
	}
	
	/**
	 * Column Info
	 * @param orderByTitle
	 */
	public void setOrderByTitle(String orderByTitle) {
		this.orderByTitle = orderByTitle;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param hdEtaEtdCd
	 */
	public void setHdEtaEtdCd(String hdEtaEtdCd) {
		this.hdEtaEtdCd = hdEtaEtdCd;
	}
	
	/**
	 * Column Info
	 * @param lt
	 */
	public void setLt(String lt) {
		this.lt = lt;
	}
	
	/**
	 * Column Info
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
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
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
	}
	
	/**
	 * Column Info
	 * @param totalPkg
	 */
	public void setTotalPkg(String totalPkg) {
		this.totalPkg = totalPkg;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param totalKgs
	 */
	public void setTotalKgs(String totalKgs) {
		this.totalKgs = totalKgs;
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
	 * @param kgs
	 */
	public void setKgs(String kgs) {
		this.kgs = kgs;
	}
	
	/**
	 * Column Info
	 * @param hdVvdCd
	 */
	public void setHdVvdCd(String hdVvdCd) {
		this.hdVvdCd = hdVvdCd;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param prePostPolYdCd
	 */
	public void setPrePostPolYdCd(String prePostPolYdCd) {
		this.prePostPolYdCd = prePostPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param rdCd2
	 */
	public void setRdCd2(String rdCd2) {
		this.rdCd2 = rdCd2;
	}
	
	/**
	 * Column Info
	 * @param rdCd1
	 */
	public void setRdCd1(String rdCd1) {
		this.rdCd1 = rdCd1;
	}
	
	/**
	 * Column Info
	 * @param asCd
	 */
	public void setAsCd(String asCd) {
		this.asCd = asCd;
	}
	
	/**
	 * Column Info
	 * @param groupPolPod
	 */
	public void setGroupPolPod(String groupPolPod) {
		this.groupPolPod = groupPolPod;
	}
	
	/**
	 * Column Info
	 * @param pkg1
	 */
	public void setPkg1(String pkg1) {
		this.pkg1 = pkg1;
	}
	
	/**
	 * Column Info
	 * @param aw
	 */
	public void setAw(String aw) {
		this.aw = aw;
	}
	
	/**
	 * Column Info
	 * @param pkg2
	 */
	public void setPkg2(String pkg2) {
		this.pkg2 = pkg2;
	}
	
	/**
	 * Column Info
	 * @param cbf
	 */
	public void setCbf(String cbf) {
		this.cbf = cbf;
	}
	
	/**
	 * Column Info
	 * @param ef
	 */
	public void setEf(String ef) {
		this.ef = ef;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param cbm
	 */
	public void setCbm(String cbm) {
		this.cbm = cbm;
	}
	
	/**
	 * Column Info
	 * @param prePost
	 */
	public void setPrePost(String prePost) {
		this.prePost = prePost;
	}
	
	/**
	 * Column Info
	 * @param lbs
	 */
	public void setLbs(String lbs) {
		this.lbs = lbs;
	}
	
	/**
	 * Column Info
	 * @param rep
	 */
	public void setRep(String rep) {
		this.rep = rep;
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
		setHdEtaEtd(JSPUtil.getParameter(request, prefix + "hd_eta_etd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setTotalLbs(JSPUtil.getParameter(request, prefix + "total_lbs", ""));
		setPrePostVvd(JSPUtil.getParameter(request, prefix + "pre_post_vvd", ""));
		setCa(JSPUtil.getParameter(request, prefix + "ca", ""));
		setOrderBy(JSPUtil.getParameter(request, prefix + "order_by", ""));
		setWgt2(JSPUtil.getParameter(request, prefix + "wgt2", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));
		setWgt1(JSPUtil.getParameter(request, prefix + "wgt1", ""));
		setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setGroupTitle(JSPUtil.getParameter(request, prefix + "group_title", ""));
		setGroupTotal(JSPUtil.getParameter(request, prefix + "group_total", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrePostPolCd(JSPUtil.getParameter(request, prefix + "pre_post_pol_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setHdModeType(JSPUtil.getParameter(request, prefix + "hd_mode_type", ""));
		setHdPolPod(JSPUtil.getParameter(request, prefix + "hd_pol_pod", ""));
		setBb(JSPUtil.getParameter(request, prefix + "bb", ""));
		setHdPolPodCd(JSPUtil.getParameter(request, prefix + "hd_pol_pod_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setHeader(JSPUtil.getParameter(request, prefix + "header", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setGroupEtdEta(JSPUtil.getParameter(request, prefix + "group_etd_eta", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPrePostPodYdCd(JSPUtil.getParameter(request, prefix + "pre_post_pod_yd_cd", ""));
		setPrePostPodCd(JSPUtil.getParameter(request, prefix + "pre_post_pod_cd", ""));
		setOrderByTitle(JSPUtil.getParameter(request, prefix + "order_by_title", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setHdEtaEtdCd(JSPUtil.getParameter(request, prefix + "hd_eta_etd_cd", ""));
		setLt(JSPUtil.getParameter(request, prefix + "lt", ""));
		setRf(JSPUtil.getParameter(request, prefix + "rf", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDg(JSPUtil.getParameter(request, prefix + "dg", ""));
		setTotalPkg(JSPUtil.getParameter(request, prefix + "total_pkg", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setTotalKgs(JSPUtil.getParameter(request, prefix + "total_kgs", ""));
		setBdr(JSPUtil.getParameter(request, prefix + "bdr", ""));
		setKgs(JSPUtil.getParameter(request, prefix + "kgs", ""));
		setHdVvdCd(JSPUtil.getParameter(request, prefix + "hd_vvd_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPrePostPolYdCd(JSPUtil.getParameter(request, prefix + "pre_post_pol_yd_cd", ""));
		setRdCd2(JSPUtil.getParameter(request, prefix + "rd_cd2", ""));
		setRdCd1(JSPUtil.getParameter(request, prefix + "rd_cd1", ""));
		setAsCd(JSPUtil.getParameter(request, prefix + "as_cd", ""));
		setGroupPolPod(JSPUtil.getParameter(request, prefix + "group_pol_pod", ""));
		setPkg1(JSPUtil.getParameter(request, prefix + "pkg1", ""));
		setAw(JSPUtil.getParameter(request, prefix + "aw", ""));
		setPkg2(JSPUtil.getParameter(request, prefix + "pkg2", ""));
		setCbf(JSPUtil.getParameter(request, prefix + "cbf", ""));
		setEf(JSPUtil.getParameter(request, prefix + "ef", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setCbm(JSPUtil.getParameter(request, prefix + "cbm", ""));
		setPrePost(JSPUtil.getParameter(request, prefix + "pre_post", ""));
		setLbs(JSPUtil.getParameter(request, prefix + "lbs", ""));
		setRep(JSPUtil.getParameter(request, prefix + "rep", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCargoManifestOutVO[]
	 */
	public BlCargoManifestOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCargoManifestOutVO[]
	 */
	public BlCargoManifestOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCargoManifestOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdEtaEtd = (JSPUtil.getParameter(request, prefix	+ "hd_eta_etd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] totalLbs = (JSPUtil.getParameter(request, prefix	+ "total_lbs", length));
			String[] prePostVvd = (JSPUtil.getParameter(request, prefix	+ "pre_post_vvd", length));
			String[] ca = (JSPUtil.getParameter(request, prefix	+ "ca", length));
			String[] orderBy = (JSPUtil.getParameter(request, prefix	+ "order_by", length));
			String[] wgt2 = (JSPUtil.getParameter(request, prefix	+ "wgt2", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] wgt1 = (JSPUtil.getParameter(request, prefix	+ "wgt1", length));
			String[] delYdCd = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] groupTitle = (JSPUtil.getParameter(request, prefix	+ "group_title", length));
			String[] groupTotal = (JSPUtil.getParameter(request, prefix	+ "group_total", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prePostPolCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pol_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] hdModeType = (JSPUtil.getParameter(request, prefix	+ "hd_mode_type", length));
			String[] hdPolPod = (JSPUtil.getParameter(request, prefix	+ "hd_pol_pod", length));
			String[] bb = (JSPUtil.getParameter(request, prefix	+ "bb", length));
			String[] hdPolPodCd = (JSPUtil.getParameter(request, prefix	+ "hd_pol_pod_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] groupEtdEta = (JSPUtil.getParameter(request, prefix	+ "group_etd_eta", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] prePostPodYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pod_yd_cd", length));
			String[] prePostPodCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pod_cd", length));
			String[] orderByTitle = (JSPUtil.getParameter(request, prefix	+ "order_by_title", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] hdEtaEtdCd = (JSPUtil.getParameter(request, prefix	+ "hd_eta_etd_cd", length));
			String[] lt = (JSPUtil.getParameter(request, prefix	+ "lt", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] totalPkg = (JSPUtil.getParameter(request, prefix	+ "total_pkg", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] totalKgs = (JSPUtil.getParameter(request, prefix	+ "total_kgs", length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr", length));
			String[] kgs = (JSPUtil.getParameter(request, prefix	+ "kgs", length));
			String[] hdVvdCd = (JSPUtil.getParameter(request, prefix	+ "hd_vvd_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] prePostPolYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pol_yd_cd", length));
			String[] rdCd2 = (JSPUtil.getParameter(request, prefix	+ "rd_cd2", length));
			String[] rdCd1 = (JSPUtil.getParameter(request, prefix	+ "rd_cd1", length));
			String[] asCd = (JSPUtil.getParameter(request, prefix	+ "as_cd", length));
			String[] groupPolPod = (JSPUtil.getParameter(request, prefix	+ "group_pol_pod", length));
			String[] pkg1 = (JSPUtil.getParameter(request, prefix	+ "pkg1", length));
			String[] aw = (JSPUtil.getParameter(request, prefix	+ "aw", length));
			String[] pkg2 = (JSPUtil.getParameter(request, prefix	+ "pkg2", length));
			String[] cbf = (JSPUtil.getParameter(request, prefix	+ "cbf", length));
			String[] ef = (JSPUtil.getParameter(request, prefix	+ "ef", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] cbm = (JSPUtil.getParameter(request, prefix	+ "cbm", length));
			String[] prePost = (JSPUtil.getParameter(request, prefix	+ "pre_post", length));
			String[] lbs = (JSPUtil.getParameter(request, prefix	+ "lbs", length));
			String[] rep = (JSPUtil.getParameter(request, prefix	+ "rep", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCargoManifestOutVO();
				if (hdEtaEtd[i] != null)
					model.setHdEtaEtd(hdEtaEtd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (totalLbs[i] != null)
					model.setTotalLbs(totalLbs[i]);
				if (prePostVvd[i] != null)
					model.setPrePostVvd(prePostVvd[i]);
				if (ca[i] != null)
					model.setCa(ca[i]);
				if (orderBy[i] != null)
					model.setOrderBy(orderBy[i]);
				if (wgt2[i] != null)
					model.setWgt2(wgt2[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (wgt1[i] != null)
					model.setWgt1(wgt1[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (groupTitle[i] != null)
					model.setGroupTitle(groupTitle[i]);
				if (groupTotal[i] != null)
					model.setGroupTotal(groupTotal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prePostPolCd[i] != null)
					model.setPrePostPolCd(prePostPolCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (hdModeType[i] != null)
					model.setHdModeType(hdModeType[i]);
				if (hdPolPod[i] != null)
					model.setHdPolPod(hdPolPod[i]);
				if (bb[i] != null)
					model.setBb(bb[i]);
				if (hdPolPodCd[i] != null)
					model.setHdPolPodCd(hdPolPodCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (groupEtdEta[i] != null)
					model.setGroupEtdEta(groupEtdEta[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (prePostPodYdCd[i] != null)
					model.setPrePostPodYdCd(prePostPodYdCd[i]);
				if (prePostPodCd[i] != null)
					model.setPrePostPodCd(prePostPodCd[i]);
				if (orderByTitle[i] != null)
					model.setOrderByTitle(orderByTitle[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (hdEtaEtdCd[i] != null)
					model.setHdEtaEtdCd(hdEtaEtdCd[i]);
				if (lt[i] != null)
					model.setLt(lt[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (totalPkg[i] != null)
					model.setTotalPkg(totalPkg[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (totalKgs[i] != null)
					model.setTotalKgs(totalKgs[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (kgs[i] != null)
					model.setKgs(kgs[i]);
				if (hdVvdCd[i] != null)
					model.setHdVvdCd(hdVvdCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (prePostPolYdCd[i] != null)
					model.setPrePostPolYdCd(prePostPolYdCd[i]);
				if (rdCd2[i] != null)
					model.setRdCd2(rdCd2[i]);
				if (rdCd1[i] != null)
					model.setRdCd1(rdCd1[i]);
				if (asCd[i] != null)
					model.setAsCd(asCd[i]);
				if (groupPolPod[i] != null)
					model.setGroupPolPod(groupPolPod[i]);
				if (pkg1[i] != null)
					model.setPkg1(pkg1[i]);
				if (aw[i] != null)
					model.setAw(aw[i]);
				if (pkg2[i] != null)
					model.setPkg2(pkg2[i]);
				if (cbf[i] != null)
					model.setCbf(cbf[i]);
				if (ef[i] != null)
					model.setEf(ef[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (cbm[i] != null)
					model.setCbm(cbm[i]);
				if (prePost[i] != null)
					model.setPrePost(prePost[i]);
				if (lbs[i] != null)
					model.setLbs(lbs[i]);
				if (rep[i] != null)
					model.setRep(rep[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCargoManifestOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCargoManifestOutVO[]
	 */
	public BlCargoManifestOutVO[] getBlCargoManifestOutVOs(){
		BlCargoManifestOutVO[] vos = (BlCargoManifestOutVO[])models.toArray(new BlCargoManifestOutVO[models.size()]);
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
		this.hdEtaEtd = this.hdEtaEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLbs = this.totalLbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostVvd = this.prePostVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ca = this.ca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderBy = this.orderBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt2 = this.wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt1 = this.wgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupTitle = this.groupTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupTotal = this.groupTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPolCd = this.prePostPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdModeType = this.hdModeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdPolPod = this.hdPolPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb = this.bb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdPolPodCd = this.hdPolPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupEtdEta = this.groupEtdEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPodYdCd = this.prePostPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPodCd = this.prePostPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderByTitle = this.orderByTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdEtaEtdCd = this.hdEtaEtdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lt = this.lt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPkg = this.totalPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalKgs = this.totalKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kgs = this.kgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdVvdCd = this.hdVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPolYdCd = this.prePostPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCd2 = this.rdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCd1 = this.rdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asCd = this.asCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupPolPod = this.groupPolPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg1 = this.pkg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aw = this.aw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg2 = this.pkg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbf = this.cbf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ef = this.ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbm = this.cbm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePost = this.prePost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbs = this.lbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rep = this.rep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
