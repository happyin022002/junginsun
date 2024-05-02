/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaManifestListDetailVO.java
*@FileTitle : RussiaManifestListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RussiaManifestListDetailVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaManifestListDetailVO> models = new ArrayList<RussiaManifestListDetailVO>();
	
	/* Column Info */
	private String hdEtaEtd = null;
	/* Column Info */
	private String totalLbs = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
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
	private String groupTitle = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String groupTotal = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String hdModeType = null;
	/* Column Info */
	private String cargoPck = null;
	/* Column Info */
	private String hdPolPod = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String hdPolPodCd = null;
	/* Column Info */
	private String cntrWgt = null;
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
	private String cargoWgt = null;
	/* Column Info */
	private String orderByTitle = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String hdEtaEtdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalPkg = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String totalKgs = null;
	/* Column Info */
	private String cargoDesc = null;
	/* Column Info */
	private String totalWgt = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String kgs = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String hdVvdCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String nfCustAddr = null;
	/* Column Info */
	private String rdCd2 = null;
	/* Column Info */
	private String rdCd1 = null;
	/* Column Info */
	private String nfCustCnt = null;
	/* Column Info */
	private String groupPolPod = null;
	/* Column Info */
	private String blCmdtNm = null;
	/* Column Info */
	private String pkg1 = null;
	/* Column Info */
	private String pkg2 = null;
	/* Column Info */
	private String cntrPck = null;
	/* Column Info */
	private String cbf = null;
	/* Column Info */
	private String blCmdtCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cbm = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String lbs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaManifestListDetailVO() {}

	public RussiaManifestListDetailVO(String ibflag, String pagerows, String orderByTitle, String porCd, String hdEtaEtd, String totalLbs, String bkgCgoTpCd, String orderBy, String wgt2, String seqNo, String hdEtaEtdCd, String wgt1, String delYdCd, String blNo, String groupTitle, String groupTotal, String polCd, String totalPkg, String hdModeType, String measQty, String hdPolPod, String totalKgs, String totalWgt, String tareWgt, String shNm, String kgs, String podYdCd, String measUtCd, String hdVvdCd, String hdPolPodCd, String sealNo, String rdCd2, String rdCd1, String delCd, String groupPolPod, String pkg1, String pkg2, String header, String podCd, String cbf, String groupEtdEta, String cneeNm, String bkgNo, String polYdCd, String cntrNo, String cbm, String cntrSealNo, String lbs, String nfCustCnt, String nfCustNm, String nfCustAddr, String cntrPck, String cntrWgt, String cntrMfSeq, String cargoPck, String cargoWgt, String cargoDesc, String blCmdtCd, String blCmdtNm) {
		this.hdEtaEtd = hdEtaEtd;
		this.totalLbs = totalLbs;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.orderBy = orderBy;
		this.wgt2 = wgt2;
		this.seqNo = seqNo;
		this.wgt1 = wgt1;
		this.delYdCd = delYdCd;
		this.groupTitle = groupTitle;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.groupTotal = groupTotal;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.hdModeType = hdModeType;
		this.cargoPck = cargoPck;
		this.hdPolPod = hdPolPod;
		this.tareWgt = tareWgt;
		this.hdPolPodCd = hdPolPodCd;
		this.cntrWgt = cntrWgt;
		this.delCd = delCd;
		this.header = header;
		this.podCd = podCd;
		this.groupEtdEta = groupEtdEta;
		this.bkgNo = bkgNo;
		this.cargoWgt = cargoWgt;
		this.orderByTitle = orderByTitle;
		this.porCd = porCd;
		this.hdEtaEtdCd = hdEtaEtdCd;
		this.ibflag = ibflag;
		this.totalPkg = totalPkg;
		this.measQty = measQty;
		this.totalKgs = totalKgs;
		this.cargoDesc = cargoDesc;
		this.totalWgt = totalWgt;
		this.shNm = shNm;
		this.kgs = kgs;
		this.podYdCd = podYdCd;
		this.measUtCd = measUtCd;
		this.hdVvdCd = hdVvdCd;
		this.nfCustNm = nfCustNm;
		this.sealNo = sealNo;
		this.nfCustAddr = nfCustAddr;
		this.rdCd2 = rdCd2;
		this.rdCd1 = rdCd1;
		this.nfCustCnt = nfCustCnt;
		this.groupPolPod = groupPolPod;
		this.blCmdtNm = blCmdtNm;
		this.pkg1 = pkg1;
		this.pkg2 = pkg2;
		this.cntrPck = cntrPck;
		this.cbf = cbf;
		this.blCmdtCd = blCmdtCd;
		this.cneeNm = cneeNm;
		this.polYdCd = polYdCd;
		this.cntrNo = cntrNo;
		this.cbm = cbm;
		this.cntrSealNo = cntrSealNo;
		this.lbs = lbs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hd_eta_etd", getHdEtaEtd());
		this.hashColumns.put("total_lbs", getTotalLbs());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("order_by", getOrderBy());
		this.hashColumns.put("wgt2", getWgt2());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("wgt1", getWgt1());
		this.hashColumns.put("del_yd_cd", getDelYdCd());
		this.hashColumns.put("group_title", getGroupTitle());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("group_total", getGroupTotal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("hd_mode_type", getHdModeType());
		this.hashColumns.put("cargo_pck", getCargoPck());
		this.hashColumns.put("hd_pol_pod", getHdPolPod());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("hd_pol_pod_cd", getHdPolPodCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("group_etd_eta", getGroupEtdEta());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cargo_wgt", getCargoWgt());
		this.hashColumns.put("order_by_title", getOrderByTitle());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("hd_eta_etd_cd", getHdEtaEtdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_pkg", getTotalPkg());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("total_kgs", getTotalKgs());
		this.hashColumns.put("cargo_desc", getCargoDesc());
		this.hashColumns.put("total_wgt", getTotalWgt());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("kgs", getKgs());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("hd_vvd_cd", getHdVvdCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("rd_cd2", getRdCd2());
		this.hashColumns.put("rd_cd1", getRdCd1());
		this.hashColumns.put("nf_cust_cnt", getNfCustCnt());
		this.hashColumns.put("group_pol_pod", getGroupPolPod());
		this.hashColumns.put("bl_cmdt_nm", getBlCmdtNm());
		this.hashColumns.put("pkg1", getPkg1());
		this.hashColumns.put("pkg2", getPkg2());
		this.hashColumns.put("cntr_pck", getCntrPck());
		this.hashColumns.put("cbf", getCbf());
		this.hashColumns.put("bl_cmdt_cd", getBlCmdtCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cbm", getCbm());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("lbs", getLbs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hd_eta_etd", "hdEtaEtd");
		this.hashFields.put("total_lbs", "totalLbs");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("order_by", "orderBy");
		this.hashFields.put("wgt2", "wgt2");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("wgt1", "wgt1");
		this.hashFields.put("del_yd_cd", "delYdCd");
		this.hashFields.put("group_title", "groupTitle");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("group_total", "groupTotal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("hd_mode_type", "hdModeType");
		this.hashFields.put("cargo_pck", "cargoPck");
		this.hashFields.put("hd_pol_pod", "hdPolPod");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("hd_pol_pod_cd", "hdPolPodCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("header", "header");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("group_etd_eta", "groupEtdEta");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cargo_wgt", "cargoWgt");
		this.hashFields.put("order_by_title", "orderByTitle");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("hd_eta_etd_cd", "hdEtaEtdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_pkg", "totalPkg");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("total_kgs", "totalKgs");
		this.hashFields.put("cargo_desc", "cargoDesc");
		this.hashFields.put("total_wgt", "totalWgt");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("kgs", "kgs");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("hd_vvd_cd", "hdVvdCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("rd_cd2", "rdCd2");
		this.hashFields.put("rd_cd1", "rdCd1");
		this.hashFields.put("nf_cust_cnt", "nfCustCnt");
		this.hashFields.put("group_pol_pod", "groupPolPod");
		this.hashFields.put("bl_cmdt_nm", "blCmdtNm");
		this.hashFields.put("pkg1", "pkg1");
		this.hashFields.put("pkg2", "pkg2");
		this.hashFields.put("cntr_pck", "cntrPck");
		this.hashFields.put("cbf", "cbf");
		this.hashFields.put("bl_cmdt_cd", "blCmdtCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cbm", "cbm");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("lbs", "lbs");
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
	 * @return totalLbs
	 */
	public String getTotalLbs() {
		return this.totalLbs;
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
	 * @return groupTitle
	 */
	public String getGroupTitle() {
		return this.groupTitle;
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
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
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
	 * @return cargoPck
	 */
	public String getCargoPck() {
		return this.cargoPck;
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
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
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
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
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
	 * @return cargoWgt
	 */
	public String getCargoWgt() {
		return this.cargoWgt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return cargoDesc
	 */
	public String getCargoDesc() {
		return this.cargoDesc;
	}
	
	/**
	 * Column Info
	 * @return totalWgt
	 */
	public String getTotalWgt() {
		return this.totalWgt;
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
	 * @return kgs
	 */
	public String getKgs() {
		return this.kgs;
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
	 * @return hdVvdCd
	 */
	public String getHdVvdCd() {
		return this.hdVvdCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return nfCustAddr
	 */
	public String getNfCustAddr() {
		return this.nfCustAddr;
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
	 * @return nfCustCnt
	 */
	public String getNfCustCnt() {
		return this.nfCustCnt;
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
	 * @return blCmdtNm
	 */
	public String getBlCmdtNm() {
		return this.blCmdtNm;
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
	 * @return pkg2
	 */
	public String getPkg2() {
		return this.pkg2;
	}
	
	/**
	 * Column Info
	 * @return cntrPck
	 */
	public String getCntrPck() {
		return this.cntrPck;
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
	 * @return blCmdtCd
	 */
	public String getBlCmdtCd() {
		return this.blCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
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
	 * @param hdEtaEtd
	 */
	public void setHdEtaEtd(String hdEtaEtd) {
		this.hdEtaEtd = hdEtaEtd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param groupTitle
	 */
	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
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
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
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
	 * @param cargoPck
	 */
	public void setCargoPck(String cargoPck) {
		this.cargoPck = cargoPck;
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
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
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
	 * @param cargoWgt
	 */
	public void setCargoWgt(String cargoWgt) {
		this.cargoWgt = cargoWgt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param cargoDesc
	 */
	public void setCargoDesc(String cargoDesc) {
		this.cargoDesc = cargoDesc;
	}
	
	/**
	 * Column Info
	 * @param totalWgt
	 */
	public void setTotalWgt(String totalWgt) {
		this.totalWgt = totalWgt;
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
	 * @param kgs
	 */
	public void setKgs(String kgs) {
		this.kgs = kgs;
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
	 * @param hdVvdCd
	 */
	public void setHdVvdCd(String hdVvdCd) {
		this.hdVvdCd = hdVvdCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param nfCustAddr
	 */
	public void setNfCustAddr(String nfCustAddr) {
		this.nfCustAddr = nfCustAddr;
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
	 * @param nfCustCnt
	 */
	public void setNfCustCnt(String nfCustCnt) {
		this.nfCustCnt = nfCustCnt;
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
	 * @param blCmdtNm
	 */
	public void setBlCmdtNm(String blCmdtNm) {
		this.blCmdtNm = blCmdtNm;
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
	 * @param pkg2
	 */
	public void setPkg2(String pkg2) {
		this.pkg2 = pkg2;
	}
	
	/**
	 * Column Info
	 * @param cntrPck
	 */
	public void setCntrPck(String cntrPck) {
		this.cntrPck = cntrPck;
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
	 * @param blCmdtCd
	 */
	public void setBlCmdtCd(String blCmdtCd) {
		this.blCmdtCd = blCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param lbs
	 */
	public void setLbs(String lbs) {
		this.lbs = lbs;
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
		setTotalLbs(JSPUtil.getParameter(request, prefix + "total_lbs", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setOrderBy(JSPUtil.getParameter(request, prefix + "order_by", ""));
		setWgt2(JSPUtil.getParameter(request, prefix + "wgt2", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));
		setWgt1(JSPUtil.getParameter(request, prefix + "wgt1", ""));
		setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
		setGroupTitle(JSPUtil.getParameter(request, prefix + "group_title", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setGroupTotal(JSPUtil.getParameter(request, prefix + "group_total", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setHdModeType(JSPUtil.getParameter(request, prefix + "hd_mode_type", ""));
		setCargoPck(JSPUtil.getParameter(request, prefix + "cargo_pck", ""));
		setHdPolPod(JSPUtil.getParameter(request, prefix + "hd_pol_pod", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setHdPolPodCd(JSPUtil.getParameter(request, prefix + "hd_pol_pod_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setHeader(JSPUtil.getParameter(request, prefix + "header", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setGroupEtdEta(JSPUtil.getParameter(request, prefix + "group_etd_eta", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCargoWgt(JSPUtil.getParameter(request, prefix + "cargo_wgt", ""));
		setOrderByTitle(JSPUtil.getParameter(request, prefix + "order_by_title", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setHdEtaEtdCd(JSPUtil.getParameter(request, prefix + "hd_eta_etd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalPkg(JSPUtil.getParameter(request, prefix + "total_pkg", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setTotalKgs(JSPUtil.getParameter(request, prefix + "total_kgs", ""));
		setCargoDesc(JSPUtil.getParameter(request, prefix + "cargo_desc", ""));
		setTotalWgt(JSPUtil.getParameter(request, prefix + "total_wgt", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setKgs(JSPUtil.getParameter(request, prefix + "kgs", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setHdVvdCd(JSPUtil.getParameter(request, prefix + "hd_vvd_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setNfCustAddr(JSPUtil.getParameter(request, prefix + "nf_cust_addr", ""));
		setRdCd2(JSPUtil.getParameter(request, prefix + "rd_cd2", ""));
		setRdCd1(JSPUtil.getParameter(request, prefix + "rd_cd1", ""));
		setNfCustCnt(JSPUtil.getParameter(request, prefix + "nf_cust_cnt", ""));
		setGroupPolPod(JSPUtil.getParameter(request, prefix + "group_pol_pod", ""));
		setBlCmdtNm(JSPUtil.getParameter(request, prefix + "bl_cmdt_nm", ""));
		setPkg1(JSPUtil.getParameter(request, prefix + "pkg1", ""));
		setPkg2(JSPUtil.getParameter(request, prefix + "pkg2", ""));
		setCntrPck(JSPUtil.getParameter(request, prefix + "cntr_pck", ""));
		setCbf(JSPUtil.getParameter(request, prefix + "cbf", ""));
		setBlCmdtCd(JSPUtil.getParameter(request, prefix + "bl_cmdt_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCbm(JSPUtil.getParameter(request, prefix + "cbm", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setLbs(JSPUtil.getParameter(request, prefix + "lbs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaManifestListDetailVO[]
	 */
	public RussiaManifestListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaManifestListDetailVO[]
	 */
	public RussiaManifestListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaManifestListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdEtaEtd = (JSPUtil.getParameter(request, prefix	+ "hd_eta_etd", length));
			String[] totalLbs = (JSPUtil.getParameter(request, prefix	+ "total_lbs", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] orderBy = (JSPUtil.getParameter(request, prefix	+ "order_by", length));
			String[] wgt2 = (JSPUtil.getParameter(request, prefix	+ "wgt2", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] wgt1 = (JSPUtil.getParameter(request, prefix	+ "wgt1", length));
			String[] delYdCd = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd", length));
			String[] groupTitle = (JSPUtil.getParameter(request, prefix	+ "group_title", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] groupTotal = (JSPUtil.getParameter(request, prefix	+ "group_total", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] hdModeType = (JSPUtil.getParameter(request, prefix	+ "hd_mode_type", length));
			String[] cargoPck = (JSPUtil.getParameter(request, prefix	+ "cargo_pck", length));
			String[] hdPolPod = (JSPUtil.getParameter(request, prefix	+ "hd_pol_pod", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] hdPolPodCd = (JSPUtil.getParameter(request, prefix	+ "hd_pol_pod_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] groupEtdEta = (JSPUtil.getParameter(request, prefix	+ "group_etd_eta", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cargoWgt = (JSPUtil.getParameter(request, prefix	+ "cargo_wgt", length));
			String[] orderByTitle = (JSPUtil.getParameter(request, prefix	+ "order_by_title", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] hdEtaEtdCd = (JSPUtil.getParameter(request, prefix	+ "hd_eta_etd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalPkg = (JSPUtil.getParameter(request, prefix	+ "total_pkg", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] totalKgs = (JSPUtil.getParameter(request, prefix	+ "total_kgs", length));
			String[] cargoDesc = (JSPUtil.getParameter(request, prefix	+ "cargo_desc", length));
			String[] totalWgt = (JSPUtil.getParameter(request, prefix	+ "total_wgt", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] kgs = (JSPUtil.getParameter(request, prefix	+ "kgs", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] hdVvdCd = (JSPUtil.getParameter(request, prefix	+ "hd_vvd_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] rdCd2 = (JSPUtil.getParameter(request, prefix	+ "rd_cd2", length));
			String[] rdCd1 = (JSPUtil.getParameter(request, prefix	+ "rd_cd1", length));
			String[] nfCustCnt = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt", length));
			String[] groupPolPod = (JSPUtil.getParameter(request, prefix	+ "group_pol_pod", length));
			String[] blCmdtNm = (JSPUtil.getParameter(request, prefix	+ "bl_cmdt_nm", length));
			String[] pkg1 = (JSPUtil.getParameter(request, prefix	+ "pkg1", length));
			String[] pkg2 = (JSPUtil.getParameter(request, prefix	+ "pkg2", length));
			String[] cntrPck = (JSPUtil.getParameter(request, prefix	+ "cntr_pck", length));
			String[] cbf = (JSPUtil.getParameter(request, prefix	+ "cbf", length));
			String[] blCmdtCd = (JSPUtil.getParameter(request, prefix	+ "bl_cmdt_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cbm = (JSPUtil.getParameter(request, prefix	+ "cbm", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] lbs = (JSPUtil.getParameter(request, prefix	+ "lbs", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaManifestListDetailVO();
				if (hdEtaEtd[i] != null)
					model.setHdEtaEtd(hdEtaEtd[i]);
				if (totalLbs[i] != null)
					model.setTotalLbs(totalLbs[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
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
				if (groupTitle[i] != null)
					model.setGroupTitle(groupTitle[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (groupTotal[i] != null)
					model.setGroupTotal(groupTotal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (hdModeType[i] != null)
					model.setHdModeType(hdModeType[i]);
				if (cargoPck[i] != null)
					model.setCargoPck(cargoPck[i]);
				if (hdPolPod[i] != null)
					model.setHdPolPod(hdPolPod[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (hdPolPodCd[i] != null)
					model.setHdPolPodCd(hdPolPodCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
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
				if (cargoWgt[i] != null)
					model.setCargoWgt(cargoWgt[i]);
				if (orderByTitle[i] != null)
					model.setOrderByTitle(orderByTitle[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (hdEtaEtdCd[i] != null)
					model.setHdEtaEtdCd(hdEtaEtdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalPkg[i] != null)
					model.setTotalPkg(totalPkg[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (totalKgs[i] != null)
					model.setTotalKgs(totalKgs[i]);
				if (cargoDesc[i] != null)
					model.setCargoDesc(cargoDesc[i]);
				if (totalWgt[i] != null)
					model.setTotalWgt(totalWgt[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (kgs[i] != null)
					model.setKgs(kgs[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (hdVvdCd[i] != null)
					model.setHdVvdCd(hdVvdCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (nfCustAddr[i] != null)
					model.setNfCustAddr(nfCustAddr[i]);
				if (rdCd2[i] != null)
					model.setRdCd2(rdCd2[i]);
				if (rdCd1[i] != null)
					model.setRdCd1(rdCd1[i]);
				if (nfCustCnt[i] != null)
					model.setNfCustCnt(nfCustCnt[i]);
				if (groupPolPod[i] != null)
					model.setGroupPolPod(groupPolPod[i]);
				if (blCmdtNm[i] != null)
					model.setBlCmdtNm(blCmdtNm[i]);
				if (pkg1[i] != null)
					model.setPkg1(pkg1[i]);
				if (pkg2[i] != null)
					model.setPkg2(pkg2[i]);
				if (cntrPck[i] != null)
					model.setCntrPck(cntrPck[i]);
				if (cbf[i] != null)
					model.setCbf(cbf[i]);
				if (blCmdtCd[i] != null)
					model.setBlCmdtCd(blCmdtCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cbm[i] != null)
					model.setCbm(cbm[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (lbs[i] != null)
					model.setLbs(lbs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaManifestListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaManifestListDetailVO[]
	 */
	public RussiaManifestListDetailVO[] getRussiaManifestListDetailVOs(){
		RussiaManifestListDetailVO[] vos = (RussiaManifestListDetailVO[])models.toArray(new RussiaManifestListDetailVO[models.size()]);
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
		this.totalLbs = this.totalLbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderBy = this.orderBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt2 = this.wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt1 = this.wgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupTitle = this.groupTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupTotal = this.groupTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdModeType = this.hdModeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPck = this.cargoPck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdPolPod = this.hdPolPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdPolPodCd = this.hdPolPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupEtdEta = this.groupEtdEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoWgt = this.cargoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderByTitle = this.orderByTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdEtaEtdCd = this.hdEtaEtdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPkg = this.totalPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalKgs = this.totalKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoDesc = this.cargoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalWgt = this.totalWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kgs = this.kgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdVvdCd = this.hdVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCd2 = this.rdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCd1 = this.rdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCnt = this.nfCustCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupPolPod = this.groupPolPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCmdtNm = this.blCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg1 = this.pkg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg2 = this.pkg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPck = this.cntrPck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbf = this.cbf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCmdtCd = this.blCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbm = this.cbm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbs = this.lbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
