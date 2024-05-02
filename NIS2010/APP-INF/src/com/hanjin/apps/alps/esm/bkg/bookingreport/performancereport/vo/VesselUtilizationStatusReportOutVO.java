/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselUtilizationStatusReportOutVO.java
*@FileTitle : VesselUtilizationStatusReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.08.25 김경섭 
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.09.01 김경섭 [000 ] [ESM-BKG] Vessel Utilization Status vs BSA by Lane 집계 쿼리 수정 및 RAW DATA SHEET 추가
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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VesselUtilizationStatusReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselUtilizationStatusReportOutVO> models = new ArrayList<VesselUtilizationStatusReportOutVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lodTtl = null;
	/* Column Info */
	private String totLodTsW = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String disTps = null;
	/* Column Info */
	private String totLiftWPct = null;
	/* Column Info */
	private String loadOcn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String disOcn = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String totLodTpsE = null;
	/* Column Info */
	private String lodTps = null;
	/* Column Info */
	private String lodLocal = null;
	/* Column Info */
	private String maxSz = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String totLodW = null;
	/* Column Info */
	private String subTotLodTpsE = null;
	/* Column Info */
	private String disTs = null;
	/* Column Info */
	private String subTotLodTsW = null;
	/* Column Info */
	private String subTotLodTpsW = null;
	/* Column Info */
	private String lodTs = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String totLodOcnE = null;
	/* Column Info */
	private String subTotLodEurE = null;
	/* Column Info */
	private String totLodTsE = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String nowbsa = null;
	/* Column Info */
	private String totLodIpcW = null;
	/* Column Info */
	private String lodMty = null;
	/* Column Info */
	private String totLodE = null;
	/* Column Info */
	private String subTotLodLocalW = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String lastPortLoading = null;
	/* Column Info */
	private String subTotLodEurW = null;
	/* Column Info */
	private String disMty = null;
	/* Column Info */
	private String subTotLodMtyW = null;
	/* Column Info */
	private String disLocal = null;
	/* Column Info */
	private String subTotLodLocalE = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String lodEur = null;
	/* Column Info */
	private String lodIpc = null;
	/* Column Info */
	private String totLodIpcE = null;
	/* Column Info */
	private String totBsaW = null;
	/* Column Info */
	private String subTotLodIpcW = null;
	/* Column Info */
	private String totLodLocalW = null;
	/* Column Info */
	private String utilE = null;
	/* Column Info */
	private String disEur = null;
	/* Column Info */
	private String vvdDisTot = null;
	/* Column Info */
	private String ttlE = null;
	/* Column Info */
	private String totLodEurW = null;
	/* Column Info */
	private String robTot = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String subTotLodOcnW = null;
	/* Column Info */
	private String vvdLodTot = null;
	/* Column Info */
	private String subTotLodMtyE = null;
	/* Column Info */
	private String totLodMtyE = null;
	/* Column Info */
	private String utilIndi = null;
	/* Column Info */
	private String robIpc = null;
	/* Column Info */
	private String totLodEurE = null;
	/* Column Info */
	private String loadMty = null;
	/* Column Info */
	private String subTotLodTsE = null;
	/* Column Info */
	private String loadIpc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String utilW = null;
	/* Column Info */
	private String totLodOcnW = null;
	/* Column Info */
	private String totLodLocalE = null;
	/* Column Info */
	private String utilEPct = null;
	/* Column Info */
	private String robLocal = null;
	/* Column Info */
	private String robEur = null;
	/* Column Info */
	private String portLodPct = null;
	/* Column Info */
	private String utilWPct = null;
	/* Column Info */
	private String utilWColor = null;
	/* Column Info */
	private String robMty = null;
	/* Column Info */
	private String lodOcn = null;
	/* Column Info */
	private String utilEColor = null;
	/* Column Info */
	private String robTs = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String robTps = null;
	/* Column Info */
	private String totBsaE = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String totLodTpsW = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String subTotLodIpcE = null;
	/* Column Info */
	private String maxPortSeq = null;
	/* Column Info */
	private String ttlW = null;
	/* Column Info */
	private String befTtl = null;
	/* Column Info */
	private String disIpc = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String totLiftEPct = null;
	/* Column Info */
	private String subTotLodOcnE = null;
	/* Column Info */
	private String disTtl = null;
	/* Column Info */
	private String totLodMtyW = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VesselUtilizationStatusReportOutVO() {}

	public VesselUtilizationStatusReportOutVO(String ibflag, String pagerows, String befTtl, String bsa, String disEur, String disIpc, String disLocal, String disMty, String disOcn, String disTps, String disTs, String disTtl, String etaDt, String etdDt, String fCmd, String loadIpc, String loadMty, String loadOcn, String lodEur, String lodIpc, String lodLocal, String lodMty, String lodOcn, String lodTps, String lodTs, String lodTtl, String lastPortLoading, String maxPortSeq, String maxSz, String nowbsa, String polYdCd, String portLodPct, String portSeq, String robEur, String robIpc, String robLocal, String robMty, String robTot, String robTps, String robTs, String skdDirCd, String skdVoyNo, String slanCd, String subTotLodEurE, String subTotLodEurW, String subTotLodIpcE, String subTotLodIpcW, String subTotLodLocalE, String subTotLodLocalW, String subTotLodMtyE, String subTotLodMtyW, String subTotLodOcnE, String subTotLodOcnW, String subTotLodTpsE, String subTotLodTpsW, String subTotLodTsE, String subTotLodTsW, String totBsaE, String totBsaW, String utilIndi, String totLiftEPct, String totLiftWPct, String totLodE, String totLodEurE, String totLodEurW, String totLodIpcE, String totLodIpcW, String totLodLocalE, String totLodLocalW, String totLodMtyE, String totLodMtyW, String totLodOcnE, String totLodOcnW, String totLodTpsE, String totLodTpsW, String totLodTsE, String totLodTsW, String totLodW, String ttlE, String ttlW, String utilE, String utilEColor, String utilEPct, String utilW, String utilWColor, String utilWPct, String vpsEtaDt, String vpsEtdDt, String vpsPortCd, String vslCd, String vvd, String vvdDisTot, String vvdLodTot, String vvdSeq) {
		this.vslCd = vslCd;
		this.lodTtl = lodTtl;
		this.totLodTsW = totLodTsW;
		this.etaDt = etaDt;
		this.fCmd = fCmd;
		this.disTps = disTps;
		this.totLiftWPct = totLiftWPct;
		this.loadOcn = loadOcn;
		this.pagerows = pagerows;
		this.disOcn = disOcn;
		this.vpsPortCd = vpsPortCd;
		this.totLodTpsE = totLodTpsE;
		this.lodTps = lodTps;
		this.lodLocal = lodLocal;
		this.maxSz = maxSz;
		this.vvdSeq = vvdSeq;
		this.totLodW = totLodW;
		this.subTotLodTpsE = subTotLodTpsE;
		this.disTs = disTs;
		this.subTotLodTsW = subTotLodTsW;
		this.subTotLodTpsW = subTotLodTpsW;
		this.lodTs = lodTs;
		this.vpsEtdDt = vpsEtdDt;
		this.totLodOcnE = totLodOcnE;
		this.subTotLodEurE = subTotLodEurE;
		this.totLodTsE = totLodTsE;
		this.skdVoyNo = skdVoyNo;
		this.nowbsa = nowbsa;
		this.totLodIpcW = totLodIpcW;
		this.lodMty = lodMty;
		this.totLodE = totLodE;
		this.subTotLodLocalW = subTotLodLocalW;
		this.vvd = vvd;
		this.lastPortLoading = lastPortLoading;
		this.subTotLodEurW = subTotLodEurW;
		this.disMty = disMty;
		this.subTotLodMtyW = subTotLodMtyW;
		this.disLocal = disLocal;
		this.subTotLodLocalE = subTotLodLocalE;
		this.bsa = bsa;
		this.lodEur = lodEur;
		this.lodIpc = lodIpc;
		this.totLodIpcE = totLodIpcE;
		this.totBsaW = totBsaW;
		this.subTotLodIpcW = subTotLodIpcW;
		this.totLodLocalW = totLodLocalW;
		this.utilE = utilE;
		this.disEur = disEur;
		this.vvdDisTot = vvdDisTot;
		this.ttlE = ttlE;
		this.totLodEurW = totLodEurW;
		this.robTot = robTot;
		this.vpsEtaDt = vpsEtaDt;
		this.subTotLodOcnW = subTotLodOcnW;
		this.vvdLodTot = vvdLodTot;
		this.subTotLodMtyE = subTotLodMtyE;
		this.totLodMtyE = totLodMtyE;
		this.utilIndi = utilIndi;
		this.robIpc = robIpc;
		this.totLodEurE = totLodEurE;
		this.loadMty = loadMty;
		this.subTotLodTsE = subTotLodTsE;
		this.loadIpc = loadIpc;
		this.ibflag = ibflag;
		this.utilW = utilW;
		this.totLodOcnW = totLodOcnW;
		this.totLodLocalE = totLodLocalE;
		this.utilEPct = utilEPct;
		this.robLocal = robLocal;
		this.robEur = robEur;
		this.portLodPct = portLodPct;
		this.utilWPct = utilWPct;
		this.utilWColor = utilWColor;
		this.robMty = robMty;
		this.lodOcn = lodOcn;
		this.utilEColor = utilEColor;
		this.robTs = robTs;
		this.etdDt = etdDt;
		this.robTps = robTps;
		this.totBsaE = totBsaE;
		this.skdDirCd = skdDirCd;
		this.totLodTpsW = totLodTpsW;
		this.portSeq = portSeq;
		this.slanCd = slanCd;
		this.subTotLodIpcE = subTotLodIpcE;
		this.maxPortSeq = maxPortSeq;
		this.ttlW = ttlW;
		this.befTtl = befTtl;
		this.disIpc = disIpc;
		this.polYdCd = polYdCd;
		this.totLiftEPct = totLiftEPct;
		this.subTotLodOcnE = subTotLodOcnE;
		this.disTtl = disTtl;
		this.totLodMtyW = totLodMtyW;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lod_ttl", getLodTtl());
		this.hashColumns.put("tot_lod_ts_w", getTotLodTsW());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("dis_tps", getDisTps());
		this.hashColumns.put("tot_lift_w_pct", getTotLiftWPct());
		this.hashColumns.put("load_ocn", getLoadOcn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dis_ocn", getDisOcn());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("tot_lod_tps_e", getTotLodTpsE());
		this.hashColumns.put("lod_tps", getLodTps());
		this.hashColumns.put("lod_local", getLodLocal());
		this.hashColumns.put("max_sz", getMaxSz());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("tot_lod_w", getTotLodW());
		this.hashColumns.put("sub_tot_lod_tps_e", getSubTotLodTpsE());
		this.hashColumns.put("dis_ts", getDisTs());
		this.hashColumns.put("sub_tot_lod_ts_w", getSubTotLodTsW());
		this.hashColumns.put("sub_tot_lod_tps_w", getSubTotLodTpsW());
		this.hashColumns.put("lod_ts", getLodTs());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("tot_lod_ocn_e", getTotLodOcnE());
		this.hashColumns.put("sub_tot_lod_eur_e", getSubTotLodEurE());
		this.hashColumns.put("tot_lod_ts_e", getTotLodTsE());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("nowbsa", getNowbsa());
		this.hashColumns.put("tot_lod_ipc_w", getTotLodIpcW());
		this.hashColumns.put("lod_mty", getLodMty());
		this.hashColumns.put("tot_lod_e", getTotLodE());
		this.hashColumns.put("sub_tot_lod_local_w", getSubTotLodLocalW());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("last_port_loading", getLastPortLoading());
		this.hashColumns.put("sub_tot_lod_eur_w", getSubTotLodEurW());
		this.hashColumns.put("dis_mty", getDisMty());
		this.hashColumns.put("sub_tot_lod_mty_w", getSubTotLodMtyW());
		this.hashColumns.put("dis_local", getDisLocal());
		this.hashColumns.put("sub_tot_lod_local_e", getSubTotLodLocalE());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("lod_eur", getLodEur());
		this.hashColumns.put("lod_ipc", getLodIpc());
		this.hashColumns.put("tot_lod_ipc_e", getTotLodIpcE());
		this.hashColumns.put("tot_bsa_w", getTotBsaW());
		this.hashColumns.put("sub_tot_lod_ipc_w", getSubTotLodIpcW());
		this.hashColumns.put("tot_lod_local_w", getTotLodLocalW());
		this.hashColumns.put("util_e", getUtilE());
		this.hashColumns.put("dis_eur", getDisEur());
		this.hashColumns.put("vvd_dis_tot", getVvdDisTot());
		this.hashColumns.put("ttl_e", getTtlE());
		this.hashColumns.put("tot_lod_eur_w", getTotLodEurW());
		this.hashColumns.put("rob_tot", getRobTot());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("sub_tot_lod_ocn_w", getSubTotLodOcnW());
		this.hashColumns.put("vvd_lod_tot", getVvdLodTot());
		this.hashColumns.put("sub_tot_lod_mty_e", getSubTotLodMtyE());
		this.hashColumns.put("tot_lod_mty_e", getTotLodMtyE());
		this.hashColumns.put("util_indi", getUtilIndi());
		this.hashColumns.put("rob_ipc", getRobIpc());
		this.hashColumns.put("tot_lod_eur_e", getTotLodEurE());
		this.hashColumns.put("load_mty", getLoadMty());
		this.hashColumns.put("sub_tot_lod_ts_e", getSubTotLodTsE());
		this.hashColumns.put("load_ipc", getLoadIpc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("util_w", getUtilW());
		this.hashColumns.put("tot_lod_ocn_w", getTotLodOcnW());
		this.hashColumns.put("tot_lod_local_e", getTotLodLocalE());
		this.hashColumns.put("util_e_pct", getUtilEPct());
		this.hashColumns.put("rob_local", getRobLocal());
		this.hashColumns.put("rob_eur", getRobEur());
		this.hashColumns.put("port_lod_pct", getPortLodPct());
		this.hashColumns.put("util_w_pct", getUtilWPct());
		this.hashColumns.put("util_w_color", getUtilWColor());
		this.hashColumns.put("rob_mty", getRobMty());
		this.hashColumns.put("lod_ocn", getLodOcn());
		this.hashColumns.put("util_e_color", getUtilEColor());
		this.hashColumns.put("rob_ts", getRobTs());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("rob_tps", getRobTps());
		this.hashColumns.put("tot_bsa_e", getTotBsaE());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("tot_lod_tps_w", getTotLodTpsW());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("sub_tot_lod_ipc_e", getSubTotLodIpcE());
		this.hashColumns.put("max_port_seq", getMaxPortSeq());
		this.hashColumns.put("ttl_w", getTtlW());
		this.hashColumns.put("bef_ttl", getBefTtl());
		this.hashColumns.put("dis_ipc", getDisIpc());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("tot_lift_e_pct", getTotLiftEPct());
		this.hashColumns.put("sub_tot_lod_ocn_e", getSubTotLodOcnE());
		this.hashColumns.put("dis_ttl", getDisTtl());
		this.hashColumns.put("tot_lod_mty_w", getTotLodMtyW());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lod_ttl", "lodTtl");
		this.hashFields.put("tot_lod_ts_w", "totLodTsW");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("dis_tps", "disTps");
		this.hashFields.put("tot_lift_w_pct", "totLiftWPct");
		this.hashFields.put("load_ocn", "loadOcn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dis_ocn", "disOcn");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("tot_lod_tps_e", "totLodTpsE");
		this.hashFields.put("lod_tps", "lodTps");
		this.hashFields.put("lod_local", "lodLocal");
		this.hashFields.put("max_sz", "maxSz");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("tot_lod_w", "totLodW");
		this.hashFields.put("sub_tot_lod_tps_e", "subTotLodTpsE");
		this.hashFields.put("dis_ts", "disTs");
		this.hashFields.put("sub_tot_lod_ts_w", "subTotLodTsW");
		this.hashFields.put("sub_tot_lod_tps_w", "subTotLodTpsW");
		this.hashFields.put("lod_ts", "lodTs");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("tot_lod_ocn_e", "totLodOcnE");
		this.hashFields.put("sub_tot_lod_eur_e", "subTotLodEurE");
		this.hashFields.put("tot_lod_ts_e", "totLodTsE");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("nowbsa", "nowbsa");
		this.hashFields.put("tot_lod_ipc_w", "totLodIpcW");
		this.hashFields.put("lod_mty", "lodMty");
		this.hashFields.put("tot_lod_e", "totLodE");
		this.hashFields.put("sub_tot_lod_local_w", "subTotLodLocalW");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("last_port_loading", "lastPortLoading");
		this.hashFields.put("sub_tot_lod_eur_w", "subTotLodEurW");
		this.hashFields.put("dis_mty", "disMty");
		this.hashFields.put("sub_tot_lod_mty_w", "subTotLodMtyW");
		this.hashFields.put("dis_local", "disLocal");
		this.hashFields.put("sub_tot_lod_local_e", "subTotLodLocalE");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("lod_eur", "lodEur");
		this.hashFields.put("lod_ipc", "lodIpc");
		this.hashFields.put("tot_lod_ipc_e", "totLodIpcE");
		this.hashFields.put("tot_bsa_w", "totBsaW");
		this.hashFields.put("sub_tot_lod_ipc_w", "subTotLodIpcW");
		this.hashFields.put("tot_lod_local_w", "totLodLocalW");
		this.hashFields.put("util_e", "utilE");
		this.hashFields.put("dis_eur", "disEur");
		this.hashFields.put("vvd_dis_tot", "vvdDisTot");
		this.hashFields.put("ttl_e", "ttlE");
		this.hashFields.put("tot_lod_eur_w", "totLodEurW");
		this.hashFields.put("rob_tot", "robTot");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("sub_tot_lod_ocn_w", "subTotLodOcnW");
		this.hashFields.put("vvd_lod_tot", "vvdLodTot");
		this.hashFields.put("sub_tot_lod_mty_e", "subTotLodMtyE");
		this.hashFields.put("tot_lod_mty_e", "totLodMtyE");
		this.hashFields.put("util_indi", "utilIndi");
		this.hashFields.put("rob_ipc", "robIpc");
		this.hashFields.put("tot_lod_eur_e", "totLodEurE");
		this.hashFields.put("load_mty", "loadMty");
		this.hashFields.put("sub_tot_lod_ts_e", "subTotLodTsE");
		this.hashFields.put("load_ipc", "loadIpc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("util_w", "utilW");
		this.hashFields.put("tot_lod_ocn_w", "totLodOcnW");
		this.hashFields.put("tot_lod_local_e", "totLodLocalE");
		this.hashFields.put("util_e_pct", "utilEPct");
		this.hashFields.put("rob_local", "robLocal");
		this.hashFields.put("rob_eur", "robEur");
		this.hashFields.put("port_lod_pct", "portLodPct");
		this.hashFields.put("util_w_pct", "utilWPct");
		this.hashFields.put("util_w_color", "utilWColor");
		this.hashFields.put("rob_mty", "robMty");
		this.hashFields.put("lod_ocn", "lodOcn");
		this.hashFields.put("util_e_color", "utilEColor");
		this.hashFields.put("rob_ts", "robTs");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("rob_tps", "robTps");
		this.hashFields.put("tot_bsa_e", "totBsaE");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("tot_lod_tps_w", "totLodTpsW");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sub_tot_lod_ipc_e", "subTotLodIpcE");
		this.hashFields.put("max_port_seq", "maxPortSeq");
		this.hashFields.put("ttl_w", "ttlW");
		this.hashFields.put("bef_ttl", "befTtl");
		this.hashFields.put("dis_ipc", "disIpc");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("tot_lift_e_pct", "totLiftEPct");
		this.hashFields.put("sub_tot_lod_ocn_e", "subTotLodOcnE");
		this.hashFields.put("dis_ttl", "disTtl");
		this.hashFields.put("tot_lod_mty_w", "totLodMtyW");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return lodTtl
	 */
	public String getLodTtl() {
		return this.lodTtl;
	}
	
	/**
	 * Column Info
	 * @return totLodTsW
	 */
	public String getTotLodTsW() {
		return this.totLodTsW;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return disTps
	 */
	public String getDisTps() {
		return this.disTps;
	}
	
	/**
	 * Column Info
	 * @return totLiftWPct
	 */
	public String getTotLiftWPct() {
		return this.totLiftWPct;
	}
	
	/**
	 * Column Info
	 * @return loadOcn
	 */
	public String getLoadOcn() {
		return this.loadOcn;
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
	 * @return disOcn
	 */
	public String getDisOcn() {
		return this.disOcn;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return totLodTpsE
	 */
	public String getTotLodTpsE() {
		return this.totLodTpsE;
	}
	
	/**
	 * Column Info
	 * @return lodTps
	 */
	public String getLodTps() {
		return this.lodTps;
	}
	
	/**
	 * Column Info
	 * @return lodLocal
	 */
	public String getLodLocal() {
		return this.lodLocal;
	}
	
	/**
	 * Column Info
	 * @return maxSz
	 */
	public String getMaxSz() {
		return this.maxSz;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return totLodW
	 */
	public String getTotLodW() {
		return this.totLodW;
	}
	
	/**
	 * Column Info
	 * @return subTotLodTpsE
	 */
	public String getSubTotLodTpsE() {
		return this.subTotLodTpsE;
	}
	
	/**
	 * Column Info
	 * @return disTs
	 */
	public String getDisTs() {
		return this.disTs;
	}
	
	/**
	 * Column Info
	 * @return subTotLodTsW
	 */
	public String getSubTotLodTsW() {
		return this.subTotLodTsW;
	}
	
	/**
	 * Column Info
	 * @return subTotLodTpsW
	 */
	public String getSubTotLodTpsW() {
		return this.subTotLodTpsW;
	}
	
	/**
	 * Column Info
	 * @return lodTs
	 */
	public String getLodTs() {
		return this.lodTs;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return totLodOcnE
	 */
	public String getTotLodOcnE() {
		return this.totLodOcnE;
	}
	
	/**
	 * Column Info
	 * @return subTotLodEurE
	 */
	public String getSubTotLodEurE() {
		return this.subTotLodEurE;
	}
	
	/**
	 * Column Info
	 * @return totLodTsE
	 */
	public String getTotLodTsE() {
		return this.totLodTsE;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return nowbsa
	 */
	public String getNowbsa() {
		return this.nowbsa;
	}
	
	/**
	 * Column Info
	 * @return totLodIpcW
	 */
	public String getTotLodIpcW() {
		return this.totLodIpcW;
	}
	
	/**
	 * Column Info
	 * @return lodMty
	 */
	public String getLodMty() {
		return this.lodMty;
	}
	
	/**
	 * Column Info
	 * @return totLodE
	 */
	public String getTotLodE() {
		return this.totLodE;
	}
	
	/**
	 * Column Info
	 * @return subTotLodLocalW
	 */
	public String getSubTotLodLocalW() {
		return this.subTotLodLocalW;
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
	 * @return lastPortLoading
	 */
	public String getLastPortLoading() {
		return this.lastPortLoading;
	}
	
	/**
	 * Column Info
	 * @return subTotLodEurW
	 */
	public String getSubTotLodEurW() {
		return this.subTotLodEurW;
	}
	
	/**
	 * Column Info
	 * @return disMty
	 */
	public String getDisMty() {
		return this.disMty;
	}
	
	/**
	 * Column Info
	 * @return subTotLodMtyW
	 */
	public String getSubTotLodMtyW() {
		return this.subTotLodMtyW;
	}
	
	/**
	 * Column Info
	 * @return disLocal
	 */
	public String getDisLocal() {
		return this.disLocal;
	}
	
	/**
	 * Column Info
	 * @return subTotLodLocalE
	 */
	public String getSubTotLodLocalE() {
		return this.subTotLodLocalE;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return lodEur
	 */
	public String getLodEur() {
		return this.lodEur;
	}
	
	/**
	 * Column Info
	 * @return lodIpc
	 */
	public String getLodIpc() {
		return this.lodIpc;
	}
	
	/**
	 * Column Info
	 * @return totLodIpcE
	 */
	public String getTotLodIpcE() {
		return this.totLodIpcE;
	}
	
	/**
	 * Column Info
	 * @return totBsaW
	 */
	public String getTotBsaW() {
		return this.totBsaW;
	}
	
	/**
	 * Column Info
	 * @return subTotLodIpcW
	 */
	public String getSubTotLodIpcW() {
		return this.subTotLodIpcW;
	}
	
	/**
	 * Column Info
	 * @return totLodLocalW
	 */
	public String getTotLodLocalW() {
		return this.totLodLocalW;
	}
	
	/**
	 * Column Info
	 * @return utilE
	 */
	public String getUtilE() {
		return this.utilE;
	}
	
	/**
	 * Column Info
	 * @return disEur
	 */
	public String getDisEur() {
		return this.disEur;
	}
	
	/**
	 * Column Info
	 * @return vvdDisTot
	 */
	public String getVvdDisTot() {
		return this.vvdDisTot;
	}
	
	/**
	 * Column Info
	 * @return ttlE
	 */
	public String getTtlE() {
		return this.ttlE;
	}
	
	/**
	 * Column Info
	 * @return totLodEurW
	 */
	public String getTotLodEurW() {
		return this.totLodEurW;
	}
	
	/**
	 * Column Info
	 * @return robTot
	 */
	public String getRobTot() {
		return this.robTot;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return subTotLodOcnW
	 */
	public String getSubTotLodOcnW() {
		return this.subTotLodOcnW;
	}
	
	/**
	 * Column Info
	 * @return vvdLodTot
	 */
	public String getVvdLodTot() {
		return this.vvdLodTot;
	}
	
	/**
	 * Column Info
	 * @return subTotLodMtyE
	 */
	public String getSubTotLodMtyE() {
		return this.subTotLodMtyE;
	}
	
	/**
	 * Column Info
	 * @return totLodMtyE
	 */
	public String getTotLodMtyE() {
		return this.totLodMtyE;
	}
	
	/**
	 * Column Info
	 * @return utilIndi
	 */
	public String getUtilIndi() {
		return this.utilIndi;
	}
	
	/**
	 * Column Info
	 * @return robIpc
	 */
	public String getRobIpc() {
		return this.robIpc;
	}
	
	/**
	 * Column Info
	 * @return totLodEurE
	 */
	public String getTotLodEurE() {
		return this.totLodEurE;
	}
	
	/**
	 * Column Info
	 * @return loadMty
	 */
	public String getLoadMty() {
		return this.loadMty;
	}
	
	/**
	 * Column Info
	 * @return subTotLodTsE
	 */
	public String getSubTotLodTsE() {
		return this.subTotLodTsE;
	}
	
	/**
	 * Column Info
	 * @return loadIpc
	 */
	public String getLoadIpc() {
		return this.loadIpc;
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
	 * @return utilW
	 */
	public String getUtilW() {
		return this.utilW;
	}
	
	/**
	 * Column Info
	 * @return totLodOcnW
	 */
	public String getTotLodOcnW() {
		return this.totLodOcnW;
	}
	
	/**
	 * Column Info
	 * @return totLodLocalE
	 */
	public String getTotLodLocalE() {
		return this.totLodLocalE;
	}
	
	/**
	 * Column Info
	 * @return utilEPct
	 */
	public String getUtilEPct() {
		return this.utilEPct;
	}
	
	/**
	 * Column Info
	 * @return robLocal
	 */
	public String getRobLocal() {
		return this.robLocal;
	}
	
	/**
	 * Column Info
	 * @return robEur
	 */
	public String getRobEur() {
		return this.robEur;
	}
	
	/**
	 * Column Info
	 * @return portLodPct
	 */
	public String getPortLodPct() {
		return this.portLodPct;
	}
	
	/**
	 * Column Info
	 * @return utilWPct
	 */
	public String getUtilWPct() {
		return this.utilWPct;
	}
	
	/**
	 * Column Info
	 * @return utilWColor
	 */
	public String getUtilWColor() {
		return this.utilWColor;
	}
	
	/**
	 * Column Info
	 * @return robMty
	 */
	public String getRobMty() {
		return this.robMty;
	}
	
	/**
	 * Column Info
	 * @return lodOcn
	 */
	public String getLodOcn() {
		return this.lodOcn;
	}
	
	/**
	 * Column Info
	 * @return utilEColor
	 */
	public String getUtilEColor() {
		return this.utilEColor;
	}
	
	/**
	 * Column Info
	 * @return robTs
	 */
	public String getRobTs() {
		return this.robTs;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return robTps
	 */
	public String getRobTps() {
		return this.robTps;
	}
	
	/**
	 * Column Info
	 * @return totBsaE
	 */
	public String getTotBsaE() {
		return this.totBsaE;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return totLodTpsW
	 */
	public String getTotLodTpsW() {
		return this.totLodTpsW;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return subTotLodIpcE
	 */
	public String getSubTotLodIpcE() {
		return this.subTotLodIpcE;
	}
	
	/**
	 * Column Info
	 * @return maxPortSeq
	 */
	public String getMaxPortSeq() {
		return this.maxPortSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlW
	 */
	public String getTtlW() {
		return this.ttlW;
	}
	
	/**
	 * Column Info
	 * @return befTtl
	 */
	public String getBefTtl() {
		return this.befTtl;
	}
	
	/**
	 * Column Info
	 * @return disIpc
	 */
	public String getDisIpc() {
		return this.disIpc;
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
	 * @return totLiftEPct
	 */
	public String getTotLiftEPct() {
		return this.totLiftEPct;
	}
	
	/**
	 * Column Info
	 * @return subTotLodOcnE
	 */
	public String getSubTotLodOcnE() {
		return this.subTotLodOcnE;
	}
	
	/**
	 * Column Info
	 * @return disTtl
	 */
	public String getDisTtl() {
		return this.disTtl;
	}
	
	/**
	 * Column Info
	 * @return totLodMtyW
	 */
	public String getTotLodMtyW() {
		return this.totLodMtyW;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param lodTtl
	 */
	public void setLodTtl(String lodTtl) {
		this.lodTtl = lodTtl;
	}
	
	/**
	 * Column Info
	 * @param totLodTsW
	 */
	public void setTotLodTsW(String totLodTsW) {
		this.totLodTsW = totLodTsW;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param disTps
	 */
	public void setDisTps(String disTps) {
		this.disTps = disTps;
	}
	
	/**
	 * Column Info
	 * @param totLiftWPct
	 */
	public void setTotLiftWPct(String totLiftWPct) {
		this.totLiftWPct = totLiftWPct;
	}
	
	/**
	 * Column Info
	 * @param loadOcn
	 */
	public void setLoadOcn(String loadOcn) {
		this.loadOcn = loadOcn;
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
	 * @param disOcn
	 */
	public void setDisOcn(String disOcn) {
		this.disOcn = disOcn;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param totLodTpsE
	 */
	public void setTotLodTpsE(String totLodTpsE) {
		this.totLodTpsE = totLodTpsE;
	}
	
	/**
	 * Column Info
	 * @param lodTps
	 */
	public void setLodTps(String lodTps) {
		this.lodTps = lodTps;
	}
	
	/**
	 * Column Info
	 * @param lodLocal
	 */
	public void setLodLocal(String lodLocal) {
		this.lodLocal = lodLocal;
	}
	
	/**
	 * Column Info
	 * @param maxSz
	 */
	public void setMaxSz(String maxSz) {
		this.maxSz = maxSz;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param totLodW
	 */
	public void setTotLodW(String totLodW) {
		this.totLodW = totLodW;
	}
	
	/**
	 * Column Info
	 * @param subTotLodTpsE
	 */
	public void setSubTotLodTpsE(String subTotLodTpsE) {
		this.subTotLodTpsE = subTotLodTpsE;
	}
	
	/**
	 * Column Info
	 * @param disTs
	 */
	public void setDisTs(String disTs) {
		this.disTs = disTs;
	}
	
	/**
	 * Column Info
	 * @param subTotLodTsW
	 */
	public void setSubTotLodTsW(String subTotLodTsW) {
		this.subTotLodTsW = subTotLodTsW;
	}
	
	/**
	 * Column Info
	 * @param subTotLodTpsW
	 */
	public void setSubTotLodTpsW(String subTotLodTpsW) {
		this.subTotLodTpsW = subTotLodTpsW;
	}
	
	/**
	 * Column Info
	 * @param lodTs
	 */
	public void setLodTs(String lodTs) {
		this.lodTs = lodTs;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param totLodOcnE
	 */
	public void setTotLodOcnE(String totLodOcnE) {
		this.totLodOcnE = totLodOcnE;
	}
	
	/**
	 * Column Info
	 * @param subTotLodEurE
	 */
	public void setSubTotLodEurE(String subTotLodEurE) {
		this.subTotLodEurE = subTotLodEurE;
	}
	
	/**
	 * Column Info
	 * @param totLodTsE
	 */
	public void setTotLodTsE(String totLodTsE) {
		this.totLodTsE = totLodTsE;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param nowbsa
	 */
	public void setNowbsa(String nowbsa) {
		this.nowbsa = nowbsa;
	}
	
	/**
	 * Column Info
	 * @param totLodIpcW
	 */
	public void setTotLodIpcW(String totLodIpcW) {
		this.totLodIpcW = totLodIpcW;
	}
	
	/**
	 * Column Info
	 * @param lodMty
	 */
	public void setLodMty(String lodMty) {
		this.lodMty = lodMty;
	}
	
	/**
	 * Column Info
	 * @param totLodE
	 */
	public void setTotLodE(String totLodE) {
		this.totLodE = totLodE;
	}
	
	/**
	 * Column Info
	 * @param subTotLodLocalW
	 */
	public void setSubTotLodLocalW(String subTotLodLocalW) {
		this.subTotLodLocalW = subTotLodLocalW;
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
	 * @param lastPortLoading
	 */
	public void setLastPortLoading(String lastPortLoading) {
		this.lastPortLoading = lastPortLoading;
	}
	
	/**
	 * Column Info
	 * @param subTotLodEurW
	 */
	public void setSubTotLodEurW(String subTotLodEurW) {
		this.subTotLodEurW = subTotLodEurW;
	}
	
	/**
	 * Column Info
	 * @param disMty
	 */
	public void setDisMty(String disMty) {
		this.disMty = disMty;
	}
	
	/**
	 * Column Info
	 * @param subTotLodMtyW
	 */
	public void setSubTotLodMtyW(String subTotLodMtyW) {
		this.subTotLodMtyW = subTotLodMtyW;
	}
	
	/**
	 * Column Info
	 * @param disLocal
	 */
	public void setDisLocal(String disLocal) {
		this.disLocal = disLocal;
	}
	
	/**
	 * Column Info
	 * @param subTotLodLocalE
	 */
	public void setSubTotLodLocalE(String subTotLodLocalE) {
		this.subTotLodLocalE = subTotLodLocalE;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param lodEur
	 */
	public void setLodEur(String lodEur) {
		this.lodEur = lodEur;
	}
	
	/**
	 * Column Info
	 * @param lodIpc
	 */
	public void setLodIpc(String lodIpc) {
		this.lodIpc = lodIpc;
	}
	
	/**
	 * Column Info
	 * @param totLodIpcE
	 */
	public void setTotLodIpcE(String totLodIpcE) {
		this.totLodIpcE = totLodIpcE;
	}
	
	/**
	 * Column Info
	 * @param totBsaW
	 */
	public void setTotBsaW(String totBsaW) {
		this.totBsaW = totBsaW;
	}
	
	/**
	 * Column Info
	 * @param subTotLodIpcW
	 */
	public void setSubTotLodIpcW(String subTotLodIpcW) {
		this.subTotLodIpcW = subTotLodIpcW;
	}
	
	/**
	 * Column Info
	 * @param totLodLocalW
	 */
	public void setTotLodLocalW(String totLodLocalW) {
		this.totLodLocalW = totLodLocalW;
	}
	
	/**
	 * Column Info
	 * @param utilE
	 */
	public void setUtilE(String utilE) {
		this.utilE = utilE;
	}
	
	/**
	 * Column Info
	 * @param disEur
	 */
	public void setDisEur(String disEur) {
		this.disEur = disEur;
	}
	
	/**
	 * Column Info
	 * @param vvdDisTot
	 */
	public void setVvdDisTot(String vvdDisTot) {
		this.vvdDisTot = vvdDisTot;
	}
	
	/**
	 * Column Info
	 * @param ttlE
	 */
	public void setTtlE(String ttlE) {
		this.ttlE = ttlE;
	}
	
	/**
	 * Column Info
	 * @param totLodEurW
	 */
	public void setTotLodEurW(String totLodEurW) {
		this.totLodEurW = totLodEurW;
	}
	
	/**
	 * Column Info
	 * @param robTot
	 */
	public void setRobTot(String robTot) {
		this.robTot = robTot;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param subTotLodOcnW
	 */
	public void setSubTotLodOcnW(String subTotLodOcnW) {
		this.subTotLodOcnW = subTotLodOcnW;
	}
	
	/**
	 * Column Info
	 * @param vvdLodTot
	 */
	public void setVvdLodTot(String vvdLodTot) {
		this.vvdLodTot = vvdLodTot;
	}
	
	/**
	 * Column Info
	 * @param subTotLodMtyE
	 */
	public void setSubTotLodMtyE(String subTotLodMtyE) {
		this.subTotLodMtyE = subTotLodMtyE;
	}
	
	/**
	 * Column Info
	 * @param totLodMtyE
	 */
	public void setTotLodMtyE(String totLodMtyE) {
		this.totLodMtyE = totLodMtyE;
	}
	
	/**
	 * Column Info
	 * @param utilIndi
	 */
	public void setUtilIndi(String utilIndi) {
		this.utilIndi = utilIndi;
	}
	
	/**
	 * Column Info
	 * @param robIpc
	 */
	public void setRobIpc(String robIpc) {
		this.robIpc = robIpc;
	}
	
	/**
	 * Column Info
	 * @param totLodEurE
	 */
	public void setTotLodEurE(String totLodEurE) {
		this.totLodEurE = totLodEurE;
	}
	
	/**
	 * Column Info
	 * @param loadMty
	 */
	public void setLoadMty(String loadMty) {
		this.loadMty = loadMty;
	}
	
	/**
	 * Column Info
	 * @param subTotLodTsE
	 */
	public void setSubTotLodTsE(String subTotLodTsE) {
		this.subTotLodTsE = subTotLodTsE;
	}
	
	/**
	 * Column Info
	 * @param loadIpc
	 */
	public void setLoadIpc(String loadIpc) {
		this.loadIpc = loadIpc;
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
	 * @param utilW
	 */
	public void setUtilW(String utilW) {
		this.utilW = utilW;
	}
	
	/**
	 * Column Info
	 * @param totLodOcnW
	 */
	public void setTotLodOcnW(String totLodOcnW) {
		this.totLodOcnW = totLodOcnW;
	}
	
	/**
	 * Column Info
	 * @param totLodLocalE
	 */
	public void setTotLodLocalE(String totLodLocalE) {
		this.totLodLocalE = totLodLocalE;
	}
	
	/**
	 * Column Info
	 * @param utilEPct
	 */
	public void setUtilEPct(String utilEPct) {
		this.utilEPct = utilEPct;
	}
	
	/**
	 * Column Info
	 * @param robLocal
	 */
	public void setRobLocal(String robLocal) {
		this.robLocal = robLocal;
	}
	
	/**
	 * Column Info
	 * @param robEur
	 */
	public void setRobEur(String robEur) {
		this.robEur = robEur;
	}
	
	/**
	 * Column Info
	 * @param portLodPct
	 */
	public void setPortLodPct(String portLodPct) {
		this.portLodPct = portLodPct;
	}
	
	/**
	 * Column Info
	 * @param utilWPct
	 */
	public void setUtilWPct(String utilWPct) {
		this.utilWPct = utilWPct;
	}
	
	/**
	 * Column Info
	 * @param utilWColor
	 */
	public void setUtilWColor(String utilWColor) {
		this.utilWColor = utilWColor;
	}
	
	/**
	 * Column Info
	 * @param robMty
	 */
	public void setRobMty(String robMty) {
		this.robMty = robMty;
	}
	
	/**
	 * Column Info
	 * @param lodOcn
	 */
	public void setLodOcn(String lodOcn) {
		this.lodOcn = lodOcn;
	}
	
	/**
	 * Column Info
	 * @param utilEColor
	 */
	public void setUtilEColor(String utilEColor) {
		this.utilEColor = utilEColor;
	}
	
	/**
	 * Column Info
	 * @param robTs
	 */
	public void setRobTs(String robTs) {
		this.robTs = robTs;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param robTps
	 */
	public void setRobTps(String robTps) {
		this.robTps = robTps;
	}
	
	/**
	 * Column Info
	 * @param totBsaE
	 */
	public void setTotBsaE(String totBsaE) {
		this.totBsaE = totBsaE;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param totLodTpsW
	 */
	public void setTotLodTpsW(String totLodTpsW) {
		this.totLodTpsW = totLodTpsW;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param subTotLodIpcE
	 */
	public void setSubTotLodIpcE(String subTotLodIpcE) {
		this.subTotLodIpcE = subTotLodIpcE;
	}
	
	/**
	 * Column Info
	 * @param maxPortSeq
	 */
	public void setMaxPortSeq(String maxPortSeq) {
		this.maxPortSeq = maxPortSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlW
	 */
	public void setTtlW(String ttlW) {
		this.ttlW = ttlW;
	}
	
	/**
	 * Column Info
	 * @param befTtl
	 */
	public void setBefTtl(String befTtl) {
		this.befTtl = befTtl;
	}
	
	/**
	 * Column Info
	 * @param disIpc
	 */
	public void setDisIpc(String disIpc) {
		this.disIpc = disIpc;
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
	 * @param totLiftEPct
	 */
	public void setTotLiftEPct(String totLiftEPct) {
		this.totLiftEPct = totLiftEPct;
	}
	
	/**
	 * Column Info
	 * @param subTotLodOcnE
	 */
	public void setSubTotLodOcnE(String subTotLodOcnE) {
		this.subTotLodOcnE = subTotLodOcnE;
	}
	
	/**
	 * Column Info
	 * @param disTtl
	 */
	public void setDisTtl(String disTtl) {
		this.disTtl = disTtl;
	}
	
	/**
	 * Column Info
	 * @param totLodMtyW
	 */
	public void setTotLodMtyW(String totLodMtyW) {
		this.totLodMtyW = totLodMtyW;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLodTtl(JSPUtil.getParameter(request, prefix + "lod_ttl", ""));
		setTotLodTsW(JSPUtil.getParameter(request, prefix + "tot_lod_ts_w", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setDisTps(JSPUtil.getParameter(request, prefix + "dis_tps", ""));
		setTotLiftWPct(JSPUtil.getParameter(request, prefix + "tot_lift_w_pct", ""));
		setLoadOcn(JSPUtil.getParameter(request, prefix + "load_ocn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDisOcn(JSPUtil.getParameter(request, prefix + "dis_ocn", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setTotLodTpsE(JSPUtil.getParameter(request, prefix + "tot_lod_tps_e", ""));
		setLodTps(JSPUtil.getParameter(request, prefix + "lod_tps", ""));
		setLodLocal(JSPUtil.getParameter(request, prefix + "lod_local", ""));
		setMaxSz(JSPUtil.getParameter(request, prefix + "max_sz", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
		setTotLodW(JSPUtil.getParameter(request, prefix + "tot_lod_w", ""));
		setSubTotLodTpsE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_tps_e", ""));
		setDisTs(JSPUtil.getParameter(request, prefix + "dis_ts", ""));
		setSubTotLodTsW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_ts_w", ""));
		setSubTotLodTpsW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_tps_w", ""));
		setLodTs(JSPUtil.getParameter(request, prefix + "lod_ts", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setTotLodOcnE(JSPUtil.getParameter(request, prefix + "tot_lod_ocn_e", ""));
		setSubTotLodEurE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_eur_e", ""));
		setTotLodTsE(JSPUtil.getParameter(request, prefix + "tot_lod_ts_e", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setNowbsa(JSPUtil.getParameter(request, prefix + "nowbsa", ""));
		setTotLodIpcW(JSPUtil.getParameter(request, prefix + "tot_lod_ipc_w", ""));
		setLodMty(JSPUtil.getParameter(request, prefix + "lod_mty", ""));
		setTotLodE(JSPUtil.getParameter(request, prefix + "tot_lod_e", ""));
		setSubTotLodLocalW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_local_w", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLastPortLoading(JSPUtil.getParameter(request, prefix + "last_port_loading", ""));
		setSubTotLodEurW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_eur_w", ""));
		setDisMty(JSPUtil.getParameter(request, prefix + "dis_mty", ""));
		setSubTotLodMtyW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_mty_w", ""));
		setDisLocal(JSPUtil.getParameter(request, prefix + "dis_local", ""));
		setSubTotLodLocalE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_local_e", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setLodEur(JSPUtil.getParameter(request, prefix + "lod_eur", ""));
		setLodIpc(JSPUtil.getParameter(request, prefix + "lod_ipc", ""));
		setTotLodIpcE(JSPUtil.getParameter(request, prefix + "tot_lod_ipc_e", ""));
		setTotBsaW(JSPUtil.getParameter(request, prefix + "tot_bsa_w", ""));
		setSubTotLodIpcW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_ipc_w", ""));
		setTotLodLocalW(JSPUtil.getParameter(request, prefix + "tot_lod_local_w", ""));
		setUtilE(JSPUtil.getParameter(request, prefix + "util_e", ""));
		setDisEur(JSPUtil.getParameter(request, prefix + "dis_eur", ""));
		setVvdDisTot(JSPUtil.getParameter(request, prefix + "vvd_dis_tot", ""));
		setTtlE(JSPUtil.getParameter(request, prefix + "ttl_e", ""));
		setTotLodEurW(JSPUtil.getParameter(request, prefix + "tot_lod_eur_w", ""));
		setRobTot(JSPUtil.getParameter(request, prefix + "rob_tot", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setSubTotLodOcnW(JSPUtil.getParameter(request, prefix + "sub_tot_lod_ocn_w", ""));
		setVvdLodTot(JSPUtil.getParameter(request, prefix + "vvd_lod_tot", ""));
		setSubTotLodMtyE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_mty_e", ""));
		setTotLodMtyE(JSPUtil.getParameter(request, prefix + "tot_lod_mty_e", ""));
		setUtilIndi(JSPUtil.getParameter(request, prefix + "util_indi", ""));
		setRobIpc(JSPUtil.getParameter(request, prefix + "rob_ipc", ""));
		setTotLodEurE(JSPUtil.getParameter(request, prefix + "tot_lod_eur_e", ""));
		setLoadMty(JSPUtil.getParameter(request, prefix + "load_mty", ""));
		setSubTotLodTsE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_ts_e", ""));
		setLoadIpc(JSPUtil.getParameter(request, prefix + "load_ipc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUtilW(JSPUtil.getParameter(request, prefix + "util_w", ""));
		setTotLodOcnW(JSPUtil.getParameter(request, prefix + "tot_lod_ocn_w", ""));
		setTotLodLocalE(JSPUtil.getParameter(request, prefix + "tot_lod_local_e", ""));
		setUtilEPct(JSPUtil.getParameter(request, prefix + "util_e_pct", ""));
		setRobLocal(JSPUtil.getParameter(request, prefix + "rob_local", ""));
		setRobEur(JSPUtil.getParameter(request, prefix + "rob_eur", ""));
		setPortLodPct(JSPUtil.getParameter(request, prefix + "port_lod_pct", ""));
		setUtilWPct(JSPUtil.getParameter(request, prefix + "util_w_pct", ""));
		setUtilWColor(JSPUtil.getParameter(request, prefix + "util_w_color", ""));
		setRobMty(JSPUtil.getParameter(request, prefix + "rob_mty", ""));
		setLodOcn(JSPUtil.getParameter(request, prefix + "lod_ocn", ""));
		setUtilEColor(JSPUtil.getParameter(request, prefix + "util_e_color", ""));
		setRobTs(JSPUtil.getParameter(request, prefix + "rob_ts", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setRobTps(JSPUtil.getParameter(request, prefix + "rob_tps", ""));
		setTotBsaE(JSPUtil.getParameter(request, prefix + "tot_bsa_e", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setTotLodTpsW(JSPUtil.getParameter(request, prefix + "tot_lod_tps_w", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSubTotLodIpcE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_ipc_e", ""));
		setMaxPortSeq(JSPUtil.getParameter(request, prefix + "max_port_seq", ""));
		setTtlW(JSPUtil.getParameter(request, prefix + "ttl_w", ""));
		setBefTtl(JSPUtil.getParameter(request, prefix + "bef_ttl", ""));
		setDisIpc(JSPUtil.getParameter(request, prefix + "dis_ipc", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setTotLiftEPct(JSPUtil.getParameter(request, prefix + "tot_lift_e_pct", ""));
		setSubTotLodOcnE(JSPUtil.getParameter(request, prefix + "sub_tot_lod_ocn_e", ""));
		setDisTtl(JSPUtil.getParameter(request, prefix + "dis_ttl", ""));
		setTotLodMtyW(JSPUtil.getParameter(request, prefix + "tot_lod_mty_w", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselUtilizationStatusReportOutVO[]
	 */
	public VesselUtilizationStatusReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselUtilizationStatusReportOutVO[]
	 */
	public VesselUtilizationStatusReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselUtilizationStatusReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lodTtl = (JSPUtil.getParameter(request, prefix	+ "lod_ttl", length));
			String[] totLodTsW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_ts_w", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] disTps = (JSPUtil.getParameter(request, prefix	+ "dis_tps", length));
			String[] totLiftWPct = (JSPUtil.getParameter(request, prefix	+ "tot_lift_w_pct", length));
			String[] loadOcn = (JSPUtil.getParameter(request, prefix	+ "load_ocn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] disOcn = (JSPUtil.getParameter(request, prefix	+ "dis_ocn", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] totLodTpsE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_tps_e", length));
			String[] lodTps = (JSPUtil.getParameter(request, prefix	+ "lod_tps", length));
			String[] lodLocal = (JSPUtil.getParameter(request, prefix	+ "lod_local", length));
			String[] maxSz = (JSPUtil.getParameter(request, prefix	+ "max_sz", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] totLodW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_w", length));
			String[] subTotLodTpsE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_tps_e", length));
			String[] disTs = (JSPUtil.getParameter(request, prefix	+ "dis_ts", length));
			String[] subTotLodTsW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_ts_w", length));
			String[] subTotLodTpsW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_tps_w", length));
			String[] lodTs = (JSPUtil.getParameter(request, prefix	+ "lod_ts", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] totLodOcnE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_ocn_e", length));
			String[] subTotLodEurE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_eur_e", length));
			String[] totLodTsE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_ts_e", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] nowbsa = (JSPUtil.getParameter(request, prefix	+ "nowbsa", length));
			String[] totLodIpcW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_ipc_w", length));
			String[] lodMty = (JSPUtil.getParameter(request, prefix	+ "lod_mty", length));
			String[] totLodE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_e", length));
			String[] subTotLodLocalW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_local_w", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] lastPortLoading = (JSPUtil.getParameter(request, prefix	+ "last_port_loading", length));
			String[] subTotLodEurW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_eur_w", length));
			String[] disMty = (JSPUtil.getParameter(request, prefix	+ "dis_mty", length));
			String[] subTotLodMtyW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_mty_w", length));
			String[] disLocal = (JSPUtil.getParameter(request, prefix	+ "dis_local", length));
			String[] subTotLodLocalE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_local_e", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] lodEur = (JSPUtil.getParameter(request, prefix	+ "lod_eur", length));
			String[] lodIpc = (JSPUtil.getParameter(request, prefix	+ "lod_ipc", length));
			String[] totLodIpcE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_ipc_e", length));
			String[] totBsaW = (JSPUtil.getParameter(request, prefix	+ "tot_bsa_w", length));
			String[] subTotLodIpcW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_ipc_w", length));
			String[] totLodLocalW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_local_w", length));
			String[] utilE = (JSPUtil.getParameter(request, prefix	+ "util_e", length));
			String[] disEur = (JSPUtil.getParameter(request, prefix	+ "dis_eur", length));
			String[] vvdDisTot = (JSPUtil.getParameter(request, prefix	+ "vvd_dis_tot", length));
			String[] ttlE = (JSPUtil.getParameter(request, prefix	+ "ttl_e", length));
			String[] totLodEurW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_eur_w", length));
			String[] robTot = (JSPUtil.getParameter(request, prefix	+ "rob_tot", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] subTotLodOcnW = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_ocn_w", length));
			String[] vvdLodTot = (JSPUtil.getParameter(request, prefix	+ "vvd_lod_tot", length));
			String[] subTotLodMtyE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_mty_e", length));
			String[] totLodMtyE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_mty_e", length));
			String[] utilIndi = (JSPUtil.getParameter(request, prefix	+ "util_indi", length));
			String[] robIpc = (JSPUtil.getParameter(request, prefix	+ "rob_ipc", length));
			String[] totLodEurE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_eur_e", length));
			String[] loadMty = (JSPUtil.getParameter(request, prefix	+ "load_mty", length));
			String[] subTotLodTsE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_ts_e", length));
			String[] loadIpc = (JSPUtil.getParameter(request, prefix	+ "load_ipc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] utilW = (JSPUtil.getParameter(request, prefix	+ "util_w", length));
			String[] totLodOcnW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_ocn_w", length));
			String[] totLodLocalE = (JSPUtil.getParameter(request, prefix	+ "tot_lod_local_e", length));
			String[] utilEPct = (JSPUtil.getParameter(request, prefix	+ "util_e_pct", length));
			String[] robLocal = (JSPUtil.getParameter(request, prefix	+ "rob_local", length));
			String[] robEur = (JSPUtil.getParameter(request, prefix	+ "rob_eur", length));
			String[] portLodPct = (JSPUtil.getParameter(request, prefix	+ "port_lod_pct", length));
			String[] utilWPct = (JSPUtil.getParameter(request, prefix	+ "util_w_pct", length));
			String[] utilWColor = (JSPUtil.getParameter(request, prefix	+ "util_w_color", length));
			String[] robMty = (JSPUtil.getParameter(request, prefix	+ "rob_mty", length));
			String[] lodOcn = (JSPUtil.getParameter(request, prefix	+ "lod_ocn", length));
			String[] utilEColor = (JSPUtil.getParameter(request, prefix	+ "util_e_color", length));
			String[] robTs = (JSPUtil.getParameter(request, prefix	+ "rob_ts", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] robTps = (JSPUtil.getParameter(request, prefix	+ "rob_tps", length));
			String[] totBsaE = (JSPUtil.getParameter(request, prefix	+ "tot_bsa_e", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] totLodTpsW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_tps_w", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] subTotLodIpcE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_ipc_e", length));
			String[] maxPortSeq = (JSPUtil.getParameter(request, prefix	+ "max_port_seq", length));
			String[] ttlW = (JSPUtil.getParameter(request, prefix	+ "ttl_w", length));
			String[] befTtl = (JSPUtil.getParameter(request, prefix	+ "bef_ttl", length));
			String[] disIpc = (JSPUtil.getParameter(request, prefix	+ "dis_ipc", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] totLiftEPct = (JSPUtil.getParameter(request, prefix	+ "tot_lift_e_pct", length));
			String[] subTotLodOcnE = (JSPUtil.getParameter(request, prefix	+ "sub_tot_lod_ocn_e", length));
			String[] disTtl = (JSPUtil.getParameter(request, prefix	+ "dis_ttl", length));
			String[] totLodMtyW = (JSPUtil.getParameter(request, prefix	+ "tot_lod_mty_w", length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselUtilizationStatusReportOutVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lodTtl[i] != null)
					model.setLodTtl(lodTtl[i]);
				if (totLodTsW[i] != null)
					model.setTotLodTsW(totLodTsW[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (disTps[i] != null)
					model.setDisTps(disTps[i]);
				if (totLiftWPct[i] != null)
					model.setTotLiftWPct(totLiftWPct[i]);
				if (loadOcn[i] != null)
					model.setLoadOcn(loadOcn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (disOcn[i] != null)
					model.setDisOcn(disOcn[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (totLodTpsE[i] != null)
					model.setTotLodTpsE(totLodTpsE[i]);
				if (lodTps[i] != null)
					model.setLodTps(lodTps[i]);
				if (lodLocal[i] != null)
					model.setLodLocal(lodLocal[i]);
				if (maxSz[i] != null)
					model.setMaxSz(maxSz[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (totLodW[i] != null)
					model.setTotLodW(totLodW[i]);
				if (subTotLodTpsE[i] != null)
					model.setSubTotLodTpsE(subTotLodTpsE[i]);
				if (disTs[i] != null)
					model.setDisTs(disTs[i]);
				if (subTotLodTsW[i] != null)
					model.setSubTotLodTsW(subTotLodTsW[i]);
				if (subTotLodTpsW[i] != null)
					model.setSubTotLodTpsW(subTotLodTpsW[i]);
				if (lodTs[i] != null)
					model.setLodTs(lodTs[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (totLodOcnE[i] != null)
					model.setTotLodOcnE(totLodOcnE[i]);
				if (subTotLodEurE[i] != null)
					model.setSubTotLodEurE(subTotLodEurE[i]);
				if (totLodTsE[i] != null)
					model.setTotLodTsE(totLodTsE[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (nowbsa[i] != null)
					model.setNowbsa(nowbsa[i]);
				if (totLodIpcW[i] != null)
					model.setTotLodIpcW(totLodIpcW[i]);
				if (lodMty[i] != null)
					model.setLodMty(lodMty[i]);
				if (totLodE[i] != null)
					model.setTotLodE(totLodE[i]);
				if (subTotLodLocalW[i] != null)
					model.setSubTotLodLocalW(subTotLodLocalW[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (lastPortLoading[i] != null)
					model.setLastPortLoading(lastPortLoading[i]);
				if (subTotLodEurW[i] != null)
					model.setSubTotLodEurW(subTotLodEurW[i]);
				if (disMty[i] != null)
					model.setDisMty(disMty[i]);
				if (subTotLodMtyW[i] != null)
					model.setSubTotLodMtyW(subTotLodMtyW[i]);
				if (disLocal[i] != null)
					model.setDisLocal(disLocal[i]);
				if (subTotLodLocalE[i] != null)
					model.setSubTotLodLocalE(subTotLodLocalE[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (lodEur[i] != null)
					model.setLodEur(lodEur[i]);
				if (lodIpc[i] != null)
					model.setLodIpc(lodIpc[i]);
				if (totLodIpcE[i] != null)
					model.setTotLodIpcE(totLodIpcE[i]);
				if (totBsaW[i] != null)
					model.setTotBsaW(totBsaW[i]);
				if (subTotLodIpcW[i] != null)
					model.setSubTotLodIpcW(subTotLodIpcW[i]);
				if (totLodLocalW[i] != null)
					model.setTotLodLocalW(totLodLocalW[i]);
				if (utilE[i] != null)
					model.setUtilE(utilE[i]);
				if (disEur[i] != null)
					model.setDisEur(disEur[i]);
				if (vvdDisTot[i] != null)
					model.setVvdDisTot(vvdDisTot[i]);
				if (ttlE[i] != null)
					model.setTtlE(ttlE[i]);
				if (totLodEurW[i] != null)
					model.setTotLodEurW(totLodEurW[i]);
				if (robTot[i] != null)
					model.setRobTot(robTot[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (subTotLodOcnW[i] != null)
					model.setSubTotLodOcnW(subTotLodOcnW[i]);
				if (vvdLodTot[i] != null)
					model.setVvdLodTot(vvdLodTot[i]);
				if (subTotLodMtyE[i] != null)
					model.setSubTotLodMtyE(subTotLodMtyE[i]);
				if (totLodMtyE[i] != null)
					model.setTotLodMtyE(totLodMtyE[i]);
				if (utilIndi[i] != null)
					model.setUtilIndi(utilIndi[i]);
				if (robIpc[i] != null)
					model.setRobIpc(robIpc[i]);
				if (totLodEurE[i] != null)
					model.setTotLodEurE(totLodEurE[i]);
				if (loadMty[i] != null)
					model.setLoadMty(loadMty[i]);
				if (subTotLodTsE[i] != null)
					model.setSubTotLodTsE(subTotLodTsE[i]);
				if (loadIpc[i] != null)
					model.setLoadIpc(loadIpc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (utilW[i] != null)
					model.setUtilW(utilW[i]);
				if (totLodOcnW[i] != null)
					model.setTotLodOcnW(totLodOcnW[i]);
				if (totLodLocalE[i] != null)
					model.setTotLodLocalE(totLodLocalE[i]);
				if (utilEPct[i] != null)
					model.setUtilEPct(utilEPct[i]);
				if (robLocal[i] != null)
					model.setRobLocal(robLocal[i]);
				if (robEur[i] != null)
					model.setRobEur(robEur[i]);
				if (portLodPct[i] != null)
					model.setPortLodPct(portLodPct[i]);
				if (utilWPct[i] != null)
					model.setUtilWPct(utilWPct[i]);
				if (utilWColor[i] != null)
					model.setUtilWColor(utilWColor[i]);
				if (robMty[i] != null)
					model.setRobMty(robMty[i]);
				if (lodOcn[i] != null)
					model.setLodOcn(lodOcn[i]);
				if (utilEColor[i] != null)
					model.setUtilEColor(utilEColor[i]);
				if (robTs[i] != null)
					model.setRobTs(robTs[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (robTps[i] != null)
					model.setRobTps(robTps[i]);
				if (totBsaE[i] != null)
					model.setTotBsaE(totBsaE[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (totLodTpsW[i] != null)
					model.setTotLodTpsW(totLodTpsW[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (subTotLodIpcE[i] != null)
					model.setSubTotLodIpcE(subTotLodIpcE[i]);
				if (maxPortSeq[i] != null)
					model.setMaxPortSeq(maxPortSeq[i]);
				if (ttlW[i] != null)
					model.setTtlW(ttlW[i]);
				if (befTtl[i] != null)
					model.setBefTtl(befTtl[i]);
				if (disIpc[i] != null)
					model.setDisIpc(disIpc[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (totLiftEPct[i] != null)
					model.setTotLiftEPct(totLiftEPct[i]);
				if (subTotLodOcnE[i] != null)
					model.setSubTotLodOcnE(subTotLodOcnE[i]);
				if (disTtl[i] != null)
					model.setDisTtl(disTtl[i]);
				if (totLodMtyW[i] != null)
					model.setTotLodMtyW(totLodMtyW[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselUtilizationStatusReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VesselUtilizationStatusReportOutVO[]
	 */
	public VesselUtilizationStatusReportOutVO[] getVesselUtilizationStatusReportOutVOs(){
		VesselUtilizationStatusReportOutVO[] vos = (VesselUtilizationStatusReportOutVO[])models.toArray(new VesselUtilizationStatusReportOutVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodTtl = this.lodTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodTsW = this.totLodTsW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTps = this.disTps .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLiftWPct = this.totLiftWPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadOcn = this.loadOcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disOcn = this.disOcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodTpsE = this.totLodTpsE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodTps = this.lodTps .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodLocal = this.lodLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSz = this.maxSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodW = this.totLodW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodTpsE = this.subTotLodTpsE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTs = this.disTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodTsW = this.subTotLodTsW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodTpsW = this.subTotLodTpsW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodTs = this.lodTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodOcnE = this.totLodOcnE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodEurE = this.subTotLodEurE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodTsE = this.totLodTsE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nowbsa = this.nowbsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodIpcW = this.totLodIpcW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodMty = this.lodMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodE = this.totLodE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodLocalW = this.subTotLodLocalW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPortLoading = this.lastPortLoading .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodEurW = this.subTotLodEurW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disMty = this.disMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodMtyW = this.subTotLodMtyW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disLocal = this.disLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodLocalE = this.subTotLodLocalE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodEur = this.lodEur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodIpc = this.lodIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodIpcE = this.totLodIpcE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBsaW = this.totBsaW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodIpcW = this.subTotLodIpcW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodLocalW = this.totLodLocalW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilE = this.utilE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disEur = this.disEur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDisTot = this.vvdDisTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlE = this.ttlE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodEurW = this.totLodEurW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robTot = this.robTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodOcnW = this.subTotLodOcnW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLodTot = this.vvdLodTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodMtyE = this.subTotLodMtyE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodMtyE = this.totLodMtyE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilIndi = this.utilIndi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robIpc = this.robIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodEurE = this.totLodEurE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadMty = this.loadMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodTsE = this.subTotLodTsE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadIpc = this.loadIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilW = this.utilW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodOcnW = this.totLodOcnW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodLocalE = this.totLodLocalE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilEPct = this.utilEPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robLocal = this.robLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robEur = this.robEur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLodPct = this.portLodPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilWPct = this.utilWPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilWColor = this.utilWColor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robMty = this.robMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodOcn = this.lodOcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilEColor = this.utilEColor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robTs = this.robTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robTps = this.robTps .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBsaE = this.totBsaE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodTpsW = this.totLodTpsW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodIpcE = this.subTotLodIpcE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPortSeq = this.maxPortSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlW = this.ttlW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befTtl = this.befTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disIpc = this.disIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLiftEPct = this.totLiftEPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotLodOcnE = this.subTotLodOcnE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTtl = this.disTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLodMtyW = this.totLodMtyW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
