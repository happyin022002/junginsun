/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PrdCreateParamVO.java
*@FileTitle : PrdCreateParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class PrdCreateParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdCreateParamVO> models = new ArrayList<PrdCreateParamVO>();
	
	/* Column Info */
	private String ibTrspMode = null;
	/* Column Info */
	private String internalSkdType = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String rcvT = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String n3rdPolDcSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n2ndPodDcSeq = null;
	/* Column Info */
	private String cQty = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String rfaOfc = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String n1stPolDcSeq = null;
	/* Column Info */
	private String trMode = null;
	/* Column Info */
	private String termNode = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String replaneBndCd = null;
	/* Column Info */
	private String troSubSeq = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String bbF = null;
	/* Column Info */
	private String scOfc = null;
	/* Column Info */
	private String bkgDelT = null;
	/* Column Info */
	private String hgF = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String akF = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String socF = null;
	/* Column Info */
	private String polPodSep = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String troPkupCy = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String haulage = null;
	/* Column Info */
	private String mPu = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String n1stPodDcSeq = null;
	/* Column Info */
	private String cTpsz = null;
	/* Column Info */
	private String pod4N = null;
	/* Column Info */
	private String delN = null;
	/* Column Info */
	private String mtPkupDt = null;
	/* Column Info */
	private String mapSeq = null;
	/* Column Info */
	private String rfa = null;
	/* Column Info */
	private String imdg = null;
	/* Column Info */
	private String delT = null;
	/* Column Info */
	private String copyCnt = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod3N = null;
	/* Column Info */
	private String pol2N = null;
	/* Column Info */
	private String pcMode = null;
	/* Column Info */
	private String areaContiCd = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String ocnSeq = null;
	/* Column Info */
	private String bkgPctlNo = null;
	/* Column Info */
	private String hitchment = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String sumBkgQty = null;
	/* Column Info */
	private String lane3 = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String dgF = null;
	/* Column Info */
	private String rfF = null;
	/* Column Info */
	private String noCost = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cgoTp = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String pol1N = null;
	/* Column Info */
	private String com = null;
	/* Column Info */
	private String ldDt = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String n3rdPodDcSeq = null;
	/* Column Info */
	private String cntrTpszQtyStr = null;
	/* Column Info */
	private String polN = null;
	/* Column Info */
	private String troRtnCy = null;
	/* Column Info */
	private String pmF = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String pod1N = null;
	/* Column Info */
	private String porN = null;
	/* Column Info */
	private String podN = null;
	/* Column Info */
	private String n4thPodDcSeq = null;
	/* Column Info */
	private String sumCTpSz = null;
	/* Column Info */
	private String pol4N = null;
	/* Column Info */
	private String orgSalOfc = null;
	/* Column Info */
	private String wgtUn = null;
	/* Column Info */
	private String dorZone = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String drDt = null;
	/* Column Info */
	private String repCom = null;
	/* Column Info */
	private String n4thPolDcSeq = null;
	/* Column Info */
	private String cngn = null;
	/* Column Info */
	private String pol3N = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String pod2N = null;
	/* Column Info */
	private String rdF = null;
	/* Column Info */
	private String n2ndPolDcSeq = null;
	/* Column Info */
	private String dgClssCd = null;
	/* Column Info */
	private String pseudoVvd = null;
	/* Column Info */
	private String obTrspMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String mainPatternPctlNo = null;
	/* Column Info */
	private String fRt = null;
	/* Column Info */
	private String idaHlgTpCd = null;
	/* Column Info */
	private String comBkgNo = null;
	/* Column Info */
	private String subF = null;
	/* Column Info */
	private String copMapgSeq = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String bkgRcvT = null;
	/* Column Info */
	private String mRt = null;
	/* Column Info */
	private String cneeSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PrdCreateParamVO() {}

	public PrdCreateParamVO(String ibflag, String pagerows, String com, String ldDt, String fCmd, String por, String rcvT, String polN, String pmF, String tVvd, String wgt, String rfaOfc, String pod1N, String porN, String podN, String pol, String pol4N, String orgSalOfc, String pod, String wgtUn, String pol4, String bbF, String sc, String pol3, String scOfc, String pol2, String hgF, String pol1, String repCom, String vvd2, String drDt, String cngn, String vvd3, String akF, String socF, String vvd1, String pod2, String pol3N, String pod1, String bkgNo, String pod4, String pod3, String vvd4, String pod2N, String mPu, String rdF, String delN, String pod4N, String rfa, String imdg, String delT, String copyCnt, String bkgOfc, String fRt, String del, String pod3N, String pol2N, String pcMode, String comBkgNo, String subF, String lane4, String hitchment, String lane2, String lane3, String lane1, String dgF, String rfF, String noCost, String cgoTp, String shpr, String pol1N, String obTrspMode, String ibTrspMode, String bkgPctlNo, String internalSkdType, String mapSeq, String mainPatternPctlNo, String troSeq, String troSubSeq, String cTpsz, String cQty, String troPkupCy, String dorZone, String troRtnCy, String cntrNo, String haulage, String trMode, String mRt, String replaneBndCd, String termNode, String copNo, String polPodSep, String sumBkgQty, String dgClssCd, String sumCTpSz, String areaContiCd, String mtPkupDt, String bkgRcvT, String bkgDelT, String n1stPolDcSeq, String n1stPodDcSeq, String n2ndPolDcSeq, String n2ndPodDcSeq, String n3rdPolDcSeq, String n3rdPodDcSeq, String n4thPolDcSeq, String n4thPodDcSeq, String copMapgSeq, String pseudoVvd, String shprCntCd, String shprSeq, String cneeCntCd, String cneeSeq, String ocnSeq, String flexHgtFlg, String cntrTpszQtyStr, String idaHlgTpCd) {
		this.ibTrspMode = ibTrspMode;
		this.internalSkdType = internalSkdType;
		this.por = por;
		this.rcvT = rcvT;
		this.cneeCntCd = cneeCntCd;
		this.n3rdPolDcSeq = n3rdPolDcSeq;
		this.pagerows = pagerows;
		this.n2ndPodDcSeq = n2ndPodDcSeq;
		this.cQty = cQty;
		this.tVvd = tVvd;
		this.rfaOfc = rfaOfc;
		this.pol = pol;
		this.n1stPolDcSeq = n1stPolDcSeq;
		this.trMode = trMode;
		this.termNode = termNode;
		this.pod = pod;
		this.replaneBndCd = replaneBndCd;
		this.troSubSeq = troSubSeq;
		this.shprCntCd = shprCntCd;
		this.bbF = bbF;
		this.scOfc = scOfc;
		this.bkgDelT = bkgDelT;
		this.hgF = hgF;
		this.vvd2 = vvd2;
		this.akF = akF;
		this.vvd3 = vvd3;
		this.socF = socF;
		this.polPodSep = polPodSep;
		this.vvd1 = vvd1;
		this.troPkupCy = troPkupCy;
		this.bkgNo = bkgNo;
		this.vvd4 = vvd4;
		this.haulage = haulage;
		this.mPu = mPu;
		this.shprSeq = shprSeq;
		this.n1stPodDcSeq = n1stPodDcSeq;
		this.cTpsz = cTpsz;
		this.pod4N = pod4N;
		this.delN = delN;
		this.mtPkupDt = mtPkupDt;
		this.mapSeq = mapSeq;
		this.rfa = rfa;
		this.imdg = imdg;
		this.delT = delT;
		this.copyCnt = copyCnt;
		this.del = del;
		this.pod3N = pod3N;
		this.pol2N = pol2N;
		this.pcMode = pcMode;
		this.areaContiCd = areaContiCd;
		this.lane4 = lane4;
		this.ocnSeq = ocnSeq;
		this.bkgPctlNo = bkgPctlNo;
		this.hitchment = hitchment;
		this.lane2 = lane2;
		this.sumBkgQty = sumBkgQty;
		this.lane3 = lane3;
		this.lane1 = lane1;
		this.dgF = dgF;
		this.rfF = rfF;
		this.noCost = noCost;
		this.cntrNo = cntrNo;
		this.cgoTp = cgoTp;
		this.flexHgtFlg = flexHgtFlg;
		this.shpr = shpr;
		this.pol1N = pol1N;
		this.com = com;
		this.ldDt = ldDt;
		this.fCmd = fCmd;
		this.copNo = copNo;
		this.n3rdPodDcSeq = n3rdPodDcSeq;
		this.cntrTpszQtyStr = cntrTpszQtyStr;
		this.polN = polN;
		this.troRtnCy = troRtnCy;
		this.pmF = pmF;
		this.wgt = wgt;
		this.pod1N = pod1N;
		this.porN = porN;
		this.podN = podN;
		this.n4thPodDcSeq = n4thPodDcSeq;
		this.sumCTpSz = sumCTpSz;
		this.pol4N = pol4N;
		this.orgSalOfc = orgSalOfc;
		this.wgtUn = wgtUn;
		this.dorZone = dorZone;
		this.pol4 = pol4;
		this.sc = sc;
		this.pol3 = pol3;
		this.pol2 = pol2;
		this.pol1 = pol1;
		this.drDt = drDt;
		this.repCom = repCom;
		this.n4thPolDcSeq = n4thPolDcSeq;
		this.cngn = cngn;
		this.pol3N = pol3N;
		this.pod2 = pod2;
		this.pod1 = pod1;
		this.pod4 = pod4;
		this.pod3 = pod3;
		this.pod2N = pod2N;
		this.rdF = rdF;
		this.n2ndPolDcSeq = n2ndPolDcSeq;
		this.dgClssCd = dgClssCd;
		this.pseudoVvd = pseudoVvd;
		this.obTrspMode = obTrspMode;
		this.ibflag = ibflag;
		this.bkgOfc = bkgOfc;
		this.mainPatternPctlNo = mainPatternPctlNo;
		this.fRt = fRt;
		this.idaHlgTpCd = idaHlgTpCd;
		this.comBkgNo = comBkgNo;
		this.subF = subF;
		this.copMapgSeq = copMapgSeq;
		this.troSeq = troSeq;
		this.bkgRcvT = bkgRcvT;
		this.mRt = mRt;
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_trsp_mode", getIbTrspMode());
		this.hashColumns.put("internal_skd_type", getInternalSkdType());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("rcv_t", getRcvT());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("n3rd_pol_dc_seq", getN3rdPolDcSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n2nd_pod_dc_seq", getN2ndPodDcSeq());
		this.hashColumns.put("c_qty", getCQty());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("rfa_ofc", getRfaOfc());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("n1st_pol_dc_seq", getN1stPolDcSeq());
		this.hashColumns.put("tr_mode", getTrMode());
		this.hashColumns.put("term_node", getTermNode());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("replane_bnd_cd", getReplaneBndCd());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("bb_f", getBbF());
		this.hashColumns.put("sc_ofc", getScOfc());
		this.hashColumns.put("bkg_del_t", getBkgDelT());
		this.hashColumns.put("hg_f", getHgF());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("ak_f", getAkF());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("soc_f", getSocF());
		this.hashColumns.put("pol_pod_sep", getPolPodSep());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("tro_pkup_cy", getTroPkupCy());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("haulage", getHaulage());
		this.hashColumns.put("m_pu", getMPu());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("n1st_pod_dc_seq", getN1stPodDcSeq());
		this.hashColumns.put("c_tpsz", getCTpsz());
		this.hashColumns.put("pod4_n", getPod4N());
		this.hashColumns.put("del_n", getDelN());
		this.hashColumns.put("mt_pkup_dt", getMtPkupDt());
		this.hashColumns.put("map_seq", getMapSeq());
		this.hashColumns.put("rfa", getRfa());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("del_t", getDelT());
		this.hashColumns.put("copy_cnt", getCopyCnt());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod3_n", getPod3N());
		this.hashColumns.put("pol2_n", getPol2N());
		this.hashColumns.put("pc_mode", getPcMode());
		this.hashColumns.put("area_conti_cd", getAreaContiCd());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("ocn_seq", getOcnSeq());
		this.hashColumns.put("bkg_pctl_no", getBkgPctlNo());
		this.hashColumns.put("hitchment", getHitchment());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("sum_bkg_qty", getSumBkgQty());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("dg_f", getDgF());
		this.hashColumns.put("rf_f", getRfF());
		this.hashColumns.put("no_cost", getNoCost());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cgo_tp", getCgoTp());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("pol1_n", getPol1N());
		this.hashColumns.put("com", getCom());
		this.hashColumns.put("ld_dt", getLdDt());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("n3rd_pod_dc_seq", getN3rdPodDcSeq());
		this.hashColumns.put("cntr_tpsz_qty_str", getCntrTpszQtyStr());
		this.hashColumns.put("pol_n", getPolN());
		this.hashColumns.put("tro_rtn_cy", getTroRtnCy());
		this.hashColumns.put("pm_f", getPmF());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("pod1_n", getPod1N());
		this.hashColumns.put("por_n", getPorN());
		this.hashColumns.put("pod_n", getPodN());
		this.hashColumns.put("n4th_pod_dc_seq", getN4thPodDcSeq());
		this.hashColumns.put("sum_c_tp_sz", getSumCTpSz());
		this.hashColumns.put("pol4_n", getPol4N());
		this.hashColumns.put("org_sal_ofc", getOrgSalOfc());
		this.hashColumns.put("wgt_un", getWgtUn());
		this.hashColumns.put("dor_zone", getDorZone());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("dr_dt", getDrDt());
		this.hashColumns.put("rep_com", getRepCom());
		this.hashColumns.put("n4th_pol_dc_seq", getN4thPolDcSeq());
		this.hashColumns.put("cngn", getCngn());
		this.hashColumns.put("pol3_n", getPol3N());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("pod2_n", getPod2N());
		this.hashColumns.put("rd_f", getRdF());
		this.hashColumns.put("n2nd_pol_dc_seq", getN2ndPolDcSeq());
		this.hashColumns.put("dg_clss_cd", getDgClssCd());
		this.hashColumns.put("pseudo_vvd", getPseudoVvd());
		this.hashColumns.put("ob_trsp_mode", getObTrspMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("main_pattern_pctl_no", getMainPatternPctlNo());
		this.hashColumns.put("f_rt", getFRt());
		this.hashColumns.put("ida_hlg_tp_cd", getIdaHlgTpCd());
		this.hashColumns.put("com_bkg_no", getComBkgNo());
		this.hashColumns.put("sub_f", getSubF());
		this.hashColumns.put("cop_mapg_seq", getCopMapgSeq());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("bkg_rcv_t", getBkgRcvT());
		this.hashColumns.put("m_rt", getMRt());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_trsp_mode", "ibTrspMode");
		this.hashFields.put("internal_skd_type", "internalSkdType");
		this.hashFields.put("por", "por");
		this.hashFields.put("rcv_t", "rcvT");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("n3rd_pol_dc_seq", "n3rdPolDcSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n2nd_pod_dc_seq", "n2ndPodDcSeq");
		this.hashFields.put("c_qty", "cQty");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("rfa_ofc", "rfaOfc");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("n1st_pol_dc_seq", "n1stPolDcSeq");
		this.hashFields.put("tr_mode", "trMode");
		this.hashFields.put("term_node", "termNode");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("replane_bnd_cd", "replaneBndCd");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("bb_f", "bbF");
		this.hashFields.put("sc_ofc", "scOfc");
		this.hashFields.put("bkg_del_t", "bkgDelT");
		this.hashFields.put("hg_f", "hgF");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("ak_f", "akF");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("soc_f", "socF");
		this.hashFields.put("pol_pod_sep", "polPodSep");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("tro_pkup_cy", "troPkupCy");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("haulage", "haulage");
		this.hashFields.put("m_pu", "mPu");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("n1st_pod_dc_seq", "n1stPodDcSeq");
		this.hashFields.put("c_tpsz", "cTpsz");
		this.hashFields.put("pod4_n", "pod4N");
		this.hashFields.put("del_n", "delN");
		this.hashFields.put("mt_pkup_dt", "mtPkupDt");
		this.hashFields.put("map_seq", "mapSeq");
		this.hashFields.put("rfa", "rfa");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("del_t", "delT");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod3_n", "pod3N");
		this.hashFields.put("pol2_n", "pol2N");
		this.hashFields.put("pc_mode", "pcMode");
		this.hashFields.put("area_conti_cd", "areaContiCd");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("ocn_seq", "ocnSeq");
		this.hashFields.put("bkg_pctl_no", "bkgPctlNo");
		this.hashFields.put("hitchment", "hitchment");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("sum_bkg_qty", "sumBkgQty");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("dg_f", "dgF");
		this.hashFields.put("rf_f", "rfF");
		this.hashFields.put("no_cost", "noCost");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cgo_tp", "cgoTp");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("pol1_n", "pol1N");
		this.hashFields.put("com", "com");
		this.hashFields.put("ld_dt", "ldDt");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("n3rd_pod_dc_seq", "n3rdPodDcSeq");
		this.hashFields.put("cntr_tpsz_qty_str", "cntrTpszQtyStr");
		this.hashFields.put("pol_n", "polN");
		this.hashFields.put("tro_rtn_cy", "troRtnCy");
		this.hashFields.put("pm_f", "pmF");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("pod1_n", "pod1N");
		this.hashFields.put("por_n", "porN");
		this.hashFields.put("pod_n", "podN");
		this.hashFields.put("n4th_pod_dc_seq", "n4thPodDcSeq");
		this.hashFields.put("sum_c_tp_sz", "sumCTpSz");
		this.hashFields.put("pol4_n", "pol4N");
		this.hashFields.put("org_sal_ofc", "orgSalOfc");
		this.hashFields.put("wgt_un", "wgtUn");
		this.hashFields.put("dor_zone", "dorZone");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("dr_dt", "drDt");
		this.hashFields.put("rep_com", "repCom");
		this.hashFields.put("n4th_pol_dc_seq", "n4thPolDcSeq");
		this.hashFields.put("cngn", "cngn");
		this.hashFields.put("pol3_n", "pol3N");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("pod2_n", "pod2N");
		this.hashFields.put("rd_f", "rdF");
		this.hashFields.put("n2nd_pol_dc_seq", "n2ndPolDcSeq");
		this.hashFields.put("dg_clss_cd", "dgClssCd");
		this.hashFields.put("pseudo_vvd", "pseudoVvd");
		this.hashFields.put("ob_trsp_mode", "obTrspMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("main_pattern_pctl_no", "mainPatternPctlNo");
		this.hashFields.put("f_rt", "fRt");
		this.hashFields.put("ida_hlg_tp_cd", "idaHlgTpCd");
		this.hashFields.put("com_bkg_no", "comBkgNo");
		this.hashFields.put("sub_f", "subF");
		this.hashFields.put("cop_mapg_seq", "copMapgSeq");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("bkg_rcv_t", "bkgRcvT");
		this.hashFields.put("m_rt", "mRt");
		this.hashFields.put("cnee_seq", "cneeSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibTrspMode
	 */
	public String getIbTrspMode() {
		return this.ibTrspMode;
	}
	
	/**
	 * Column Info
	 * @return internalSkdType
	 */
	public String getInternalSkdType() {
		return this.internalSkdType;
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
	 * @return rcvT
	 */
	public String getRcvT() {
		return this.rcvT;
	}
	
	/**
	 * Column Info
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolDcSeq
	 */
	public String getN3rdPolDcSeq() {
		return this.n3rdPolDcSeq;
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
	 * @return n2ndPodDcSeq
	 */
	public String getN2ndPodDcSeq() {
		return this.n2ndPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @return cQty
	 */
	public String getCQty() {
		return this.cQty;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return rfaOfc
	 */
	public String getRfaOfc() {
		return this.rfaOfc;
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
	 * @return n1stPolDcSeq
	 */
	public String getN1stPolDcSeq() {
		return this.n1stPolDcSeq;
	}
	
	/**
	 * Column Info
	 * @return trMode
	 */
	public String getTrMode() {
		return this.trMode;
	}
	
	/**
	 * Column Info
	 * @return termNode
	 */
	public String getTermNode() {
		return this.termNode;
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
	 * @return replaneBndCd
	 */
	public String getReplaneBndCd() {
		return this.replaneBndCd;
	}
	
	/**
	 * Column Info
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return bbF
	 */
	public String getBbF() {
		return this.bbF;
	}
	
	/**
	 * Column Info
	 * @return scOfc
	 */
	public String getScOfc() {
		return this.scOfc;
	}
	
	/**
	 * Column Info
	 * @return bkgDelT
	 */
	public String getBkgDelT() {
		return this.bkgDelT;
	}
	
	/**
	 * Column Info
	 * @return hgF
	 */
	public String getHgF() {
		return this.hgF;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return akF
	 */
	public String getAkF() {
		return this.akF;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return socF
	 */
	public String getSocF() {
		return this.socF;
	}
	
	/**
	 * Column Info
	 * @return polPodSep
	 */
	public String getPolPodSep() {
		return this.polPodSep;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return troPkupCy
	 */
	public String getTroPkupCy() {
		return this.troPkupCy;
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
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return haulage
	 */
	public String getHaulage() {
		return this.haulage;
	}
	
	/**
	 * Column Info
	 * @return mPu
	 */
	public String getMPu() {
		return this.mPu;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stPodDcSeq
	 */
	public String getN1stPodDcSeq() {
		return this.n1stPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @return cTpsz
	 */
	public String getCTpsz() {
		return this.cTpsz;
	}
	
	/**
	 * Column Info
	 * @return pod4N
	 */
	public String getPod4N() {
		return this.pod4N;
	}
	
	/**
	 * Column Info
	 * @return delN
	 */
	public String getDelN() {
		return this.delN;
	}
	
	/**
	 * Column Info
	 * @return mtPkupDt
	 */
	public String getMtPkupDt() {
		return this.mtPkupDt;
	}
	
	/**
	 * Column Info
	 * @return mapSeq
	 */
	public String getMapSeq() {
		return this.mapSeq;
	}
	
	/**
	 * Column Info
	 * @return rfa
	 */
	public String getRfa() {
		return this.rfa;
	}
	
	/**
	 * Column Info
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
	}
	
	/**
	 * Column Info
	 * @return delT
	 */
	public String getDelT() {
		return this.delT;
	}
	
	/**
	 * Column Info
	 * @return copyCnt
	 */
	public String getCopyCnt() {
		return this.copyCnt;
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
	 * @return pod3N
	 */
	public String getPod3N() {
		return this.pod3N;
	}
	
	/**
	 * Column Info
	 * @return pol2N
	 */
	public String getPol2N() {
		return this.pol2N;
	}
	
	/**
	 * Column Info
	 * @return pcMode
	 */
	public String getPcMode() {
		return this.pcMode;
	}
	
	/**
	 * Column Info
	 * @return areaContiCd
	 */
	public String getAreaContiCd() {
		return this.areaContiCd;
	}
	
	/**
	 * Column Info
	 * @return lane4
	 */
	public String getLane4() {
		return this.lane4;
	}
	
	/**
	 * Column Info
	 * @return ocnSeq
	 */
	public String getOcnSeq() {
		return this.ocnSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgPctlNo
	 */
	public String getBkgPctlNo() {
		return this.bkgPctlNo;
	}
	
	/**
	 * Column Info
	 * @return hitchment
	 */
	public String getHitchment() {
		return this.hitchment;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}
	
	/**
	 * Column Info
	 * @return sumBkgQty
	 */
	public String getSumBkgQty() {
		return this.sumBkgQty;
	}
	
	/**
	 * Column Info
	 * @return lane3
	 */
	public String getLane3() {
		return this.lane3;
	}
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}
	
	/**
	 * Column Info
	 * @return dgF
	 */
	public String getDgF() {
		return this.dgF;
	}
	
	/**
	 * Column Info
	 * @return rfF
	 */
	public String getRfF() {
		return this.rfF;
	}
	
	/**
	 * Column Info
	 * @return noCost
	 */
	public String getNoCost() {
		return this.noCost;
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
	 * @return cgoTp
	 */
	public String getCgoTp() {
		return this.cgoTp;
	}
	
	/**
	 * Column Info
	 * @return flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return pol1N
	 */
	public String getPol1N() {
		return this.pol1N;
	}
	
	/**
	 * Column Info
	 * @return com
	 */
	public String getCom() {
		return this.com;
	}
	
	/**
	 * Column Info
	 * @return ldDt
	 */
	public String getLdDt() {
		return this.ldDt;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdPodDcSeq
	 */
	public String getN3rdPodDcSeq() {
		return this.n3rdPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszQtyStr
	 */
	public String getCntrTpszQtyStr() {
		return this.cntrTpszQtyStr;
	}
	
	/**
	 * Column Info
	 * @return polN
	 */
	public String getPolN() {
		return this.polN;
	}
	
	/**
	 * Column Info
	 * @return troRtnCy
	 */
	public String getTroRtnCy() {
		return this.troRtnCy;
	}
	
	/**
	 * Column Info
	 * @return pmF
	 */
	public String getPmF() {
		return this.pmF;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return pod1N
	 */
	public String getPod1N() {
		return this.pod1N;
	}
	
	/**
	 * Column Info
	 * @return porN
	 */
	public String getPorN() {
		return this.porN;
	}
	
	/**
	 * Column Info
	 * @return podN
	 */
	public String getPodN() {
		return this.podN;
	}
	
	/**
	 * Column Info
	 * @return n4thPodDcSeq
	 */
	public String getN4thPodDcSeq() {
		return this.n4thPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @return sumCTpSz
	 */
	public String getSumCTpSz() {
		return this.sumCTpSz;
	}
	
	/**
	 * Column Info
	 * @return pol4N
	 */
	public String getPol4N() {
		return this.pol4N;
	}
	
	/**
	 * Column Info
	 * @return orgSalOfc
	 */
	public String getOrgSalOfc() {
		return this.orgSalOfc;
	}
	
	/**
	 * Column Info
	 * @return wgtUn
	 */
	public String getWgtUn() {
		return this.wgtUn;
	}
	
	/**
	 * Column Info
	 * @return dorZone
	 */
	public String getDorZone() {
		return this.dorZone;
	}
	
	/**
	 * Column Info
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
	}
	
	/**
	 * Column Info
	 * @return sc
	 */
	public String getSc() {
		return this.sc;
	}
	
	/**
	 * Column Info
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
	}
	
	/**
	 * Column Info
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}
	
	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
	}
	
	/**
	 * Column Info
	 * @return drDt
	 */
	public String getDrDt() {
		return this.drDt;
	}
	
	/**
	 * Column Info
	 * @return repCom
	 */
	public String getRepCom() {
		return this.repCom;
	}
	
	/**
	 * Column Info
	 * @return n4thPolDcSeq
	 */
	public String getN4thPolDcSeq() {
		return this.n4thPolDcSeq;
	}
	
	/**
	 * Column Info
	 * @return cngn
	 */
	public String getCngn() {
		return this.cngn;
	}
	
	/**
	 * Column Info
	 * @return pol3N
	 */
	public String getPol3N() {
		return this.pol3N;
	}
	
	/**
	 * Column Info
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}
	
	/**
	 * Column Info
	 * @return pod1
	 */
	public String getPod1() {
		return this.pod1;
	}
	
	/**
	 * Column Info
	 * @return pod4
	 */
	public String getPod4() {
		return this.pod4;
	}
	
	/**
	 * Column Info
	 * @return pod3
	 */
	public String getPod3() {
		return this.pod3;
	}
	
	/**
	 * Column Info
	 * @return pod2N
	 */
	public String getPod2N() {
		return this.pod2N;
	}
	
	/**
	 * Column Info
	 * @return rdF
	 */
	public String getRdF() {
		return this.rdF;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolDcSeq
	 */
	public String getN2ndPolDcSeq() {
		return this.n2ndPolDcSeq;
	}
	
	/**
	 * Column Info
	 * @return dgClssCd
	 */
	public String getDgClssCd() {
		return this.dgClssCd;
	}
	
	/**
	 * Column Info
	 * @return pseudoVvd
	 */
	public String getPseudoVvd() {
		return this.pseudoVvd;
	}
	
	/**
	 * Column Info
	 * @return obTrspMode
	 */
	public String getObTrspMode() {
		return this.obTrspMode;
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
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return mainPatternPctlNo
	 */
	public String getMainPatternPctlNo() {
		return this.mainPatternPctlNo;
	}
	
	/**
	 * Column Info
	 * @return fRt
	 */
	public String getFRt() {
		return this.fRt;
	}
	
	/**
	 * Column Info
	 * @return idaHlgTpCd
	 */
	public String getIdaHlgTpCd() {
		return this.idaHlgTpCd;
	}
	
	/**
	 * Column Info
	 * @return comBkgNo
	 */
	public String getComBkgNo() {
		return this.comBkgNo;
	}
	
	/**
	 * Column Info
	 * @return subF
	 */
	public String getSubF() {
		return this.subF;
	}
	
	/**
	 * Column Info
	 * @return copMapgSeq
	 */
	public String getCopMapgSeq() {
		return this.copMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvT
	 */
	public String getBkgRcvT() {
		return this.bkgRcvT;
	}
	
	/**
	 * Column Info
	 * @return mRt
	 */
	public String getMRt() {
		return this.mRt;
	}
	
	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	

	/**
	 * Column Info
	 * @param ibTrspMode
	 */
	public void setIbTrspMode(String ibTrspMode) {
		this.ibTrspMode = ibTrspMode;
	}
	
	/**
	 * Column Info
	 * @param internalSkdType
	 */
	public void setInternalSkdType(String internalSkdType) {
		this.internalSkdType = internalSkdType;
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
	 * @param rcvT
	 */
	public void setRcvT(String rcvT) {
		this.rcvT = rcvT;
	}
	
	/**
	 * Column Info
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolDcSeq
	 */
	public void setN3rdPolDcSeq(String n3rdPolDcSeq) {
		this.n3rdPolDcSeq = n3rdPolDcSeq;
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
	 * @param n2ndPodDcSeq
	 */
	public void setN2ndPodDcSeq(String n2ndPodDcSeq) {
		this.n2ndPodDcSeq = n2ndPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @param cQty
	 */
	public void setCQty(String cQty) {
		this.cQty = cQty;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param rfaOfc
	 */
	public void setRfaOfc(String rfaOfc) {
		this.rfaOfc = rfaOfc;
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
	 * @param n1stPolDcSeq
	 */
	public void setN1stPolDcSeq(String n1stPolDcSeq) {
		this.n1stPolDcSeq = n1stPolDcSeq;
	}
	
	/**
	 * Column Info
	 * @param trMode
	 */
	public void setTrMode(String trMode) {
		this.trMode = trMode;
	}
	
	/**
	 * Column Info
	 * @param termNode
	 */
	public void setTermNode(String termNode) {
		this.termNode = termNode;
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
	 * @param replaneBndCd
	 */
	public void setReplaneBndCd(String replaneBndCd) {
		this.replaneBndCd = replaneBndCd;
	}
	
	/**
	 * Column Info
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param bbF
	 */
	public void setBbF(String bbF) {
		this.bbF = bbF;
	}
	
	/**
	 * Column Info
	 * @param scOfc
	 */
	public void setScOfc(String scOfc) {
		this.scOfc = scOfc;
	}
	
	/**
	 * Column Info
	 * @param bkgDelT
	 */
	public void setBkgDelT(String bkgDelT) {
		this.bkgDelT = bkgDelT;
	}
	
	/**
	 * Column Info
	 * @param hgF
	 */
	public void setHgF(String hgF) {
		this.hgF = hgF;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param akF
	 */
	public void setAkF(String akF) {
		this.akF = akF;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param socF
	 */
	public void setSocF(String socF) {
		this.socF = socF;
	}
	
	/**
	 * Column Info
	 * @param polPodSep
	 */
	public void setPolPodSep(String polPodSep) {
		this.polPodSep = polPodSep;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param troPkupCy
	 */
	public void setTroPkupCy(String troPkupCy) {
		this.troPkupCy = troPkupCy;
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
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param haulage
	 */
	public void setHaulage(String haulage) {
		this.haulage = haulage;
	}
	
	/**
	 * Column Info
	 * @param mPu
	 */
	public void setMPu(String mPu) {
		this.mPu = mPu;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stPodDcSeq
	 */
	public void setN1stPodDcSeq(String n1stPodDcSeq) {
		this.n1stPodDcSeq = n1stPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @param cTpsz
	 */
	public void setCTpsz(String cTpsz) {
		this.cTpsz = cTpsz;
	}
	
	/**
	 * Column Info
	 * @param pod4N
	 */
	public void setPod4N(String pod4N) {
		this.pod4N = pod4N;
	}
	
	/**
	 * Column Info
	 * @param delN
	 */
	public void setDelN(String delN) {
		this.delN = delN;
	}
	
	/**
	 * Column Info
	 * @param mtPkupDt
	 */
	public void setMtPkupDt(String mtPkupDt) {
		this.mtPkupDt = mtPkupDt;
	}
	
	/**
	 * Column Info
	 * @param mapSeq
	 */
	public void setMapSeq(String mapSeq) {
		this.mapSeq = mapSeq;
	}
	
	/**
	 * Column Info
	 * @param rfa
	 */
	public void setRfa(String rfa) {
		this.rfa = rfa;
	}
	
	/**
	 * Column Info
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
	}
	
	/**
	 * Column Info
	 * @param delT
	 */
	public void setDelT(String delT) {
		this.delT = delT;
	}
	
	/**
	 * Column Info
	 * @param copyCnt
	 */
	public void setCopyCnt(String copyCnt) {
		this.copyCnt = copyCnt;
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
	 * @param pod3N
	 */
	public void setPod3N(String pod3N) {
		this.pod3N = pod3N;
	}
	
	/**
	 * Column Info
	 * @param pol2N
	 */
	public void setPol2N(String pol2N) {
		this.pol2N = pol2N;
	}
	
	/**
	 * Column Info
	 * @param pcMode
	 */
	public void setPcMode(String pcMode) {
		this.pcMode = pcMode;
	}
	
	/**
	 * Column Info
	 * @param areaContiCd
	 */
	public void setAreaContiCd(String areaContiCd) {
		this.areaContiCd = areaContiCd;
	}
	
	/**
	 * Column Info
	 * @param lane4
	 */
	public void setLane4(String lane4) {
		this.lane4 = lane4;
	}
	
	/**
	 * Column Info
	 * @param ocnSeq
	 */
	public void setOcnSeq(String ocnSeq) {
		this.ocnSeq = ocnSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgPctlNo
	 */
	public void setBkgPctlNo(String bkgPctlNo) {
		this.bkgPctlNo = bkgPctlNo;
	}
	
	/**
	 * Column Info
	 * @param hitchment
	 */
	public void setHitchment(String hitchment) {
		this.hitchment = hitchment;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param sumBkgQty
	 */
	public void setSumBkgQty(String sumBkgQty) {
		this.sumBkgQty = sumBkgQty;
	}
	
	/**
	 * Column Info
	 * @param lane3
	 */
	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	
	/**
	 * Column Info
	 * @param dgF
	 */
	public void setDgF(String dgF) {
		this.dgF = dgF;
	}
	
	/**
	 * Column Info
	 * @param rfF
	 */
	public void setRfF(String rfF) {
		this.rfF = rfF;
	}
	
	/**
	 * Column Info
	 * @param noCost
	 */
	public void setNoCost(String noCost) {
		this.noCost = noCost;
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
	 * @param cgoTp
	 */
	public void setCgoTp(String cgoTp) {
		this.cgoTp = cgoTp;
	}
	
	/**
	 * Column Info
	 * @param flexHgtFlg
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param pol1N
	 */
	public void setPol1N(String pol1N) {
		this.pol1N = pol1N;
	}
	
	/**
	 * Column Info
	 * @param com
	 */
	public void setCom(String com) {
		this.com = com;
	}
	
	/**
	 * Column Info
	 * @param ldDt
	 */
	public void setLdDt(String ldDt) {
		this.ldDt = ldDt;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdPodDcSeq
	 */
	public void setN3rdPodDcSeq(String n3rdPodDcSeq) {
		this.n3rdPodDcSeq = n3rdPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszQtyStr
	 */
	public void setCntrTpszQtyStr(String cntrTpszQtyStr) {
		this.cntrTpszQtyStr = cntrTpszQtyStr;
	}
	
	/**
	 * Column Info
	 * @param polN
	 */
	public void setPolN(String polN) {
		this.polN = polN;
	}
	
	/**
	 * Column Info
	 * @param troRtnCy
	 */
	public void setTroRtnCy(String troRtnCy) {
		this.troRtnCy = troRtnCy;
	}
	
	/**
	 * Column Info
	 * @param pmF
	 */
	public void setPmF(String pmF) {
		this.pmF = pmF;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param pod1N
	 */
	public void setPod1N(String pod1N) {
		this.pod1N = pod1N;
	}
	
	/**
	 * Column Info
	 * @param porN
	 */
	public void setPorN(String porN) {
		this.porN = porN;
	}
	
	/**
	 * Column Info
	 * @param podN
	 */
	public void setPodN(String podN) {
		this.podN = podN;
	}
	
	/**
	 * Column Info
	 * @param n4thPodDcSeq
	 */
	public void setN4thPodDcSeq(String n4thPodDcSeq) {
		this.n4thPodDcSeq = n4thPodDcSeq;
	}
	
	/**
	 * Column Info
	 * @param sumCTpSz
	 */
	public void setSumCTpSz(String sumCTpSz) {
		this.sumCTpSz = sumCTpSz;
	}
	
	/**
	 * Column Info
	 * @param pol4N
	 */
	public void setPol4N(String pol4N) {
		this.pol4N = pol4N;
	}
	
	/**
	 * Column Info
	 * @param orgSalOfc
	 */
	public void setOrgSalOfc(String orgSalOfc) {
		this.orgSalOfc = orgSalOfc;
	}
	
	/**
	 * Column Info
	 * @param wgtUn
	 */
	public void setWgtUn(String wgtUn) {
		this.wgtUn = wgtUn;
	}
	
	/**
	 * Column Info
	 * @param dorZone
	 */
	public void setDorZone(String dorZone) {
		this.dorZone = dorZone;
	}
	
	/**
	 * Column Info
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
	}
	
	/**
	 * Column Info
	 * @param sc
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}
	
	/**
	 * Column Info
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
	}
	
	/**
	 * Column Info
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}
	
	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
	}
	
	/**
	 * Column Info
	 * @param drDt
	 */
	public void setDrDt(String drDt) {
		this.drDt = drDt;
	}
	
	/**
	 * Column Info
	 * @param repCom
	 */
	public void setRepCom(String repCom) {
		this.repCom = repCom;
	}
	
	/**
	 * Column Info
	 * @param n4thPolDcSeq
	 */
	public void setN4thPolDcSeq(String n4thPolDcSeq) {
		this.n4thPolDcSeq = n4thPolDcSeq;
	}
	
	/**
	 * Column Info
	 * @param cngn
	 */
	public void setCngn(String cngn) {
		this.cngn = cngn;
	}
	
	/**
	 * Column Info
	 * @param pol3N
	 */
	public void setPol3N(String pol3N) {
		this.pol3N = pol3N;
	}
	
	/**
	 * Column Info
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}
	
	/**
	 * Column Info
	 * @param pod1
	 */
	public void setPod1(String pod1) {
		this.pod1 = pod1;
	}
	
	/**
	 * Column Info
	 * @param pod4
	 */
	public void setPod4(String pod4) {
		this.pod4 = pod4;
	}
	
	/**
	 * Column Info
	 * @param pod3
	 */
	public void setPod3(String pod3) {
		this.pod3 = pod3;
	}
	
	/**
	 * Column Info
	 * @param pod2N
	 */
	public void setPod2N(String pod2N) {
		this.pod2N = pod2N;
	}
	
	/**
	 * Column Info
	 * @param rdF
	 */
	public void setRdF(String rdF) {
		this.rdF = rdF;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolDcSeq
	 */
	public void setN2ndPolDcSeq(String n2ndPolDcSeq) {
		this.n2ndPolDcSeq = n2ndPolDcSeq;
	}
	
	/**
	 * Column Info
	 * @param dgClssCd
	 */
	public void setDgClssCd(String dgClssCd) {
		this.dgClssCd = dgClssCd;
	}
	
	/**
	 * Column Info
	 * @param pseudoVvd
	 */
	public void setPseudoVvd(String pseudoVvd) {
		this.pseudoVvd = pseudoVvd;
	}
	
	/**
	 * Column Info
	 * @param obTrspMode
	 */
	public void setObTrspMode(String obTrspMode) {
		this.obTrspMode = obTrspMode;
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
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param mainPatternPctlNo
	 */
	public void setMainPatternPctlNo(String mainPatternPctlNo) {
		this.mainPatternPctlNo = mainPatternPctlNo;
	}
	
	/**
	 * Column Info
	 * @param fRt
	 */
	public void setFRt(String fRt) {
		this.fRt = fRt;
	}
	
	/**
	 * Column Info
	 * @param idaHlgTpCd
	 */
	public void setIdaHlgTpCd(String idaHlgTpCd) {
		this.idaHlgTpCd = idaHlgTpCd;
	}
	
	/**
	 * Column Info
	 * @param comBkgNo
	 */
	public void setComBkgNo(String comBkgNo) {
		this.comBkgNo = comBkgNo;
	}
	
	/**
	 * Column Info
	 * @param subF
	 */
	public void setSubF(String subF) {
		this.subF = subF;
	}
	
	/**
	 * Column Info
	 * @param copMapgSeq
	 */
	public void setCopMapgSeq(String copMapgSeq) {
		this.copMapgSeq = copMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvT
	 */
	public void setBkgRcvT(String bkgRcvT) {
		this.bkgRcvT = bkgRcvT;
	}
	
	/**
	 * Column Info
	 * @param mRt
	 */
	public void setMRt(String mRt) {
		this.mRt = mRt;
	}
	
	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
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
		setIbTrspMode(JSPUtil.getParameter(request, prefix + "ib_trsp_mode", ""));
		setInternalSkdType(JSPUtil.getParameter(request, prefix + "internal_skd_type", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setRcvT(JSPUtil.getParameter(request, prefix + "rcv_t", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setN3rdPolDcSeq(JSPUtil.getParameter(request, prefix + "n3rd_pol_dc_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN2ndPodDcSeq(JSPUtil.getParameter(request, prefix + "n2nd_pod_dc_seq", ""));
		setCQty(JSPUtil.getParameter(request, prefix + "c_qty", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setRfaOfc(JSPUtil.getParameter(request, prefix + "rfa_ofc", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setN1stPolDcSeq(JSPUtil.getParameter(request, prefix + "n1st_pol_dc_seq", ""));
		setTrMode(JSPUtil.getParameter(request, prefix + "tr_mode", ""));
		setTermNode(JSPUtil.getParameter(request, prefix + "term_node", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setReplaneBndCd(JSPUtil.getParameter(request, prefix + "replane_bnd_cd", ""));
		setTroSubSeq(JSPUtil.getParameter(request, prefix + "tro_sub_seq", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setBbF(JSPUtil.getParameter(request, prefix + "bb_f", ""));
		setScOfc(JSPUtil.getParameter(request, prefix + "sc_ofc", ""));
		setBkgDelT(JSPUtil.getParameter(request, prefix + "bkg_del_t", ""));
		setHgF(JSPUtil.getParameter(request, prefix + "hg_f", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setAkF(JSPUtil.getParameter(request, prefix + "ak_f", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setSocF(JSPUtil.getParameter(request, prefix + "soc_f", ""));
		setPolPodSep(JSPUtil.getParameter(request, prefix + "pol_pod_sep", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setTroPkupCy(JSPUtil.getParameter(request, prefix + "tro_pkup_cy", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setHaulage(JSPUtil.getParameter(request, prefix + "haulage", ""));
		setMPu(JSPUtil.getParameter(request, prefix + "m_pu", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setN1stPodDcSeq(JSPUtil.getParameter(request, prefix + "n1st_pod_dc_seq", ""));
		setCTpsz(JSPUtil.getParameter(request, prefix + "c_tpsz", ""));
		setPod4N(JSPUtil.getParameter(request, prefix + "pod4_n", ""));
		setDelN(JSPUtil.getParameter(request, prefix + "del_n", ""));
		setMtPkupDt(JSPUtil.getParameter(request, prefix + "mt_pkup_dt", ""));
		setMapSeq(JSPUtil.getParameter(request, prefix + "map_seq", ""));
		setRfa(JSPUtil.getParameter(request, prefix + "rfa", ""));
		setImdg(JSPUtil.getParameter(request, prefix + "imdg", ""));
		setDelT(JSPUtil.getParameter(request, prefix + "del_t", ""));
		setCopyCnt(JSPUtil.getParameter(request, prefix + "copy_cnt", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setPod3N(JSPUtil.getParameter(request, prefix + "pod3_n", ""));
		setPol2N(JSPUtil.getParameter(request, prefix + "pol2_n", ""));
		setPcMode(JSPUtil.getParameter(request, prefix + "pc_mode", ""));
		setAreaContiCd(JSPUtil.getParameter(request, prefix + "area_conti_cd", ""));
		setLane4(JSPUtil.getParameter(request, prefix + "lane4", ""));
		setOcnSeq(JSPUtil.getParameter(request, prefix + "ocn_seq", ""));
		setBkgPctlNo(JSPUtil.getParameter(request, prefix + "bkg_pctl_no", ""));
		setHitchment(JSPUtil.getParameter(request, prefix + "hitchment", ""));
		setLane2(JSPUtil.getParameter(request, prefix + "lane2", ""));
		setSumBkgQty(JSPUtil.getParameter(request, prefix + "sum_bkg_qty", ""));
		setLane3(JSPUtil.getParameter(request, prefix + "lane3", ""));
		setLane1(JSPUtil.getParameter(request, prefix + "lane1", ""));
		setDgF(JSPUtil.getParameter(request, prefix + "dg_f", ""));
		setRfF(JSPUtil.getParameter(request, prefix + "rf_f", ""));
		setNoCost(JSPUtil.getParameter(request, prefix + "no_cost", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCgoTp(JSPUtil.getParameter(request, prefix + "cgo_tp", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setPol1N(JSPUtil.getParameter(request, prefix + "pol1_n", ""));
		setCom(JSPUtil.getParameter(request, prefix + "com", ""));
		setLdDt(JSPUtil.getParameter(request, prefix + "ld_dt", ""));
		setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setN3rdPodDcSeq(JSPUtil.getParameter(request, prefix + "n3rd_pod_dc_seq", ""));
		setCntrTpszQtyStr(JSPUtil.getParameter(request, prefix + "cntr_tpsz_qty_str", ""));
		setPolN(JSPUtil.getParameter(request, prefix + "pol_n", ""));
		setTroRtnCy(JSPUtil.getParameter(request, prefix + "tro_rtn_cy", ""));
		setPmF(JSPUtil.getParameter(request, prefix + "pm_f", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setPod1N(JSPUtil.getParameter(request, prefix + "pod1_n", ""));
		setPorN(JSPUtil.getParameter(request, prefix + "por_n", ""));
		setPodN(JSPUtil.getParameter(request, prefix + "pod_n", ""));
		setN4thPodDcSeq(JSPUtil.getParameter(request, prefix + "n4th_pod_dc_seq", ""));
		setSumCTpSz(JSPUtil.getParameter(request, prefix + "sum_c_tp_sz", ""));
		setPol4N(JSPUtil.getParameter(request, prefix + "pol4_n", ""));
		setOrgSalOfc(JSPUtil.getParameter(request, prefix + "org_sal_ofc", ""));
		setWgtUn(JSPUtil.getParameter(request, prefix + "wgt_un", ""));
		setDorZone(JSPUtil.getParameter(request, prefix + "dor_zone", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setSc(JSPUtil.getParameter(request, prefix + "sc", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setDrDt(JSPUtil.getParameter(request, prefix + "dr_dt", ""));
		setRepCom(JSPUtil.getParameter(request, prefix + "rep_com", ""));
		setN4thPolDcSeq(JSPUtil.getParameter(request, prefix + "n4th_pol_dc_seq", ""));
		setCngn(JSPUtil.getParameter(request, prefix + "cngn", ""));
		setPol3N(JSPUtil.getParameter(request, prefix + "pol3_n", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setPod1(JSPUtil.getParameter(request, prefix + "pod1", ""));
		setPod4(JSPUtil.getParameter(request, prefix + "pod4", ""));
		setPod3(JSPUtil.getParameter(request, prefix + "pod3", ""));
		setPod2N(JSPUtil.getParameter(request, prefix + "pod2_n", ""));
		setRdF(JSPUtil.getParameter(request, prefix + "rd_f", ""));
		setN2ndPolDcSeq(JSPUtil.getParameter(request, prefix + "n2nd_pol_dc_seq", ""));
		setDgClssCd(JSPUtil.getParameter(request, prefix + "dg_clss_cd", ""));
		setPseudoVvd(JSPUtil.getParameter(request, prefix + "pseudo_vvd", ""));
		setObTrspMode(JSPUtil.getParameter(request, prefix + "ob_trsp_mode", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgOfc(JSPUtil.getParameter(request, prefix + "bkg_ofc", ""));
		setMainPatternPctlNo(JSPUtil.getParameter(request, prefix + "main_pattern_pctl_no", ""));
		setFRt(JSPUtil.getParameter(request, prefix + "f_rt", ""));
		setIdaHlgTpCd(JSPUtil.getParameter(request, prefix + "ida_hlg_tp_cd", ""));
		setComBkgNo(JSPUtil.getParameter(request, prefix + "com_bkg_no", ""));
		setSubF(JSPUtil.getParameter(request, prefix + "sub_f", ""));
		setCopMapgSeq(JSPUtil.getParameter(request, prefix + "cop_mapg_seq", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setBkgRcvT(JSPUtil.getParameter(request, prefix + "bkg_rcv_t", ""));
		setMRt(JSPUtil.getParameter(request, prefix + "m_rt", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdCreateParamVO[]
	 */
	public PrdCreateParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdCreateParamVO[]
	 */
	public PrdCreateParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdCreateParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibTrspMode = (JSPUtil.getParameter(request, prefix	+ "ib_trsp_mode", length));
			String[] internalSkdType = (JSPUtil.getParameter(request, prefix	+ "internal_skd_type", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] rcvT = (JSPUtil.getParameter(request, prefix	+ "rcv_t", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] n3rdPolDcSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_dc_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n2ndPodDcSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_dc_seq", length));
			String[] cQty = (JSPUtil.getParameter(request, prefix	+ "c_qty", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] rfaOfc = (JSPUtil.getParameter(request, prefix	+ "rfa_ofc", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] n1stPolDcSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_dc_seq", length));
			String[] trMode = (JSPUtil.getParameter(request, prefix	+ "tr_mode", length));
			String[] termNode = (JSPUtil.getParameter(request, prefix	+ "term_node", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] replaneBndCd = (JSPUtil.getParameter(request, prefix	+ "replane_bnd_cd", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] bbF = (JSPUtil.getParameter(request, prefix	+ "bb_f", length));
			String[] scOfc = (JSPUtil.getParameter(request, prefix	+ "sc_ofc", length));
			String[] bkgDelT = (JSPUtil.getParameter(request, prefix	+ "bkg_del_t", length));
			String[] hgF = (JSPUtil.getParameter(request, prefix	+ "hg_f", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] akF = (JSPUtil.getParameter(request, prefix	+ "ak_f", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] socF = (JSPUtil.getParameter(request, prefix	+ "soc_f", length));
			String[] polPodSep = (JSPUtil.getParameter(request, prefix	+ "pol_pod_sep", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] troPkupCy = (JSPUtil.getParameter(request, prefix	+ "tro_pkup_cy", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] haulage = (JSPUtil.getParameter(request, prefix	+ "haulage", length));
			String[] mPu = (JSPUtil.getParameter(request, prefix	+ "m_pu", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] n1stPodDcSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_dc_seq", length));
			String[] cTpsz = (JSPUtil.getParameter(request, prefix	+ "c_tpsz", length));
			String[] pod4N = (JSPUtil.getParameter(request, prefix	+ "pod4_n", length));
			String[] delN = (JSPUtil.getParameter(request, prefix	+ "del_n", length));
			String[] mtPkupDt = (JSPUtil.getParameter(request, prefix	+ "mt_pkup_dt", length));
			String[] mapSeq = (JSPUtil.getParameter(request, prefix	+ "map_seq", length));
			String[] rfa = (JSPUtil.getParameter(request, prefix	+ "rfa", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix	+ "imdg", length));
			String[] delT = (JSPUtil.getParameter(request, prefix	+ "del_t", length));
			String[] copyCnt = (JSPUtil.getParameter(request, prefix	+ "copy_cnt", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod3N = (JSPUtil.getParameter(request, prefix	+ "pod3_n", length));
			String[] pol2N = (JSPUtil.getParameter(request, prefix	+ "pol2_n", length));
			String[] pcMode = (JSPUtil.getParameter(request, prefix	+ "pc_mode", length));
			String[] areaContiCd = (JSPUtil.getParameter(request, prefix	+ "area_conti_cd", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix	+ "lane4", length));
			String[] ocnSeq = (JSPUtil.getParameter(request, prefix	+ "ocn_seq", length));
			String[] bkgPctlNo = (JSPUtil.getParameter(request, prefix	+ "bkg_pctl_no", length));
			String[] hitchment = (JSPUtil.getParameter(request, prefix	+ "hitchment", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] sumBkgQty = (JSPUtil.getParameter(request, prefix	+ "sum_bkg_qty", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix	+ "lane3", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] dgF = (JSPUtil.getParameter(request, prefix	+ "dg_f", length));
			String[] rfF = (JSPUtil.getParameter(request, prefix	+ "rf_f", length));
			String[] noCost = (JSPUtil.getParameter(request, prefix	+ "no_cost", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cgoTp = (JSPUtil.getParameter(request, prefix	+ "cgo_tp", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] pol1N = (JSPUtil.getParameter(request, prefix	+ "pol1_n", length));
			String[] com = (JSPUtil.getParameter(request, prefix	+ "com", length));
			String[] ldDt = (JSPUtil.getParameter(request, prefix	+ "ld_dt", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] n3rdPodDcSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_dc_seq", length));
			String[] cntrTpszQtyStr = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_qty_str", length));
			String[] polN = (JSPUtil.getParameter(request, prefix	+ "pol_n", length));
			String[] troRtnCy = (JSPUtil.getParameter(request, prefix	+ "tro_rtn_cy", length));
			String[] pmF = (JSPUtil.getParameter(request, prefix	+ "pm_f", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] pod1N = (JSPUtil.getParameter(request, prefix	+ "pod1_n", length));
			String[] porN = (JSPUtil.getParameter(request, prefix	+ "por_n", length));
			String[] podN = (JSPUtil.getParameter(request, prefix	+ "pod_n", length));
			String[] n4thPodDcSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_dc_seq", length));
			String[] sumCTpSz = (JSPUtil.getParameter(request, prefix	+ "sum_c_tp_sz", length));
			String[] pol4N = (JSPUtil.getParameter(request, prefix	+ "pol4_n", length));
			String[] orgSalOfc = (JSPUtil.getParameter(request, prefix	+ "org_sal_ofc", length));
			String[] wgtUn = (JSPUtil.getParameter(request, prefix	+ "wgt_un", length));
			String[] dorZone = (JSPUtil.getParameter(request, prefix	+ "dor_zone", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] drDt = (JSPUtil.getParameter(request, prefix	+ "dr_dt", length));
			String[] repCom = (JSPUtil.getParameter(request, prefix	+ "rep_com", length));
			String[] n4thPolDcSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_dc_seq", length));
			String[] cngn = (JSPUtil.getParameter(request, prefix	+ "cngn", length));
			String[] pol3N = (JSPUtil.getParameter(request, prefix	+ "pol3_n", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix	+ "pod1", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix	+ "pod4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix	+ "pod3", length));
			String[] pod2N = (JSPUtil.getParameter(request, prefix	+ "pod2_n", length));
			String[] rdF = (JSPUtil.getParameter(request, prefix	+ "rd_f", length));
			String[] n2ndPolDcSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_dc_seq", length));
			String[] dgClssCd = (JSPUtil.getParameter(request, prefix	+ "dg_clss_cd", length));
			String[] pseudoVvd = (JSPUtil.getParameter(request, prefix	+ "pseudo_vvd", length));
			String[] obTrspMode = (JSPUtil.getParameter(request, prefix	+ "ob_trsp_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] mainPatternPctlNo = (JSPUtil.getParameter(request, prefix	+ "main_pattern_pctl_no", length));
			String[] fRt = (JSPUtil.getParameter(request, prefix	+ "f_rt", length));
			String[] idaHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_hlg_tp_cd", length));
			String[] comBkgNo = (JSPUtil.getParameter(request, prefix	+ "com_bkg_no", length));
			String[] subF = (JSPUtil.getParameter(request, prefix	+ "sub_f", length));
			String[] copMapgSeq = (JSPUtil.getParameter(request, prefix	+ "cop_mapg_seq", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] bkgRcvT = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_t", length));
			String[] mRt = (JSPUtil.getParameter(request, prefix	+ "m_rt", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdCreateParamVO();
				if (ibTrspMode[i] != null)
					model.setIbTrspMode(ibTrspMode[i]);
				if (internalSkdType[i] != null)
					model.setInternalSkdType(internalSkdType[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (rcvT[i] != null)
					model.setRcvT(rcvT[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (n3rdPolDcSeq[i] != null)
					model.setN3rdPolDcSeq(n3rdPolDcSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n2ndPodDcSeq[i] != null)
					model.setN2ndPodDcSeq(n2ndPodDcSeq[i]);
				if (cQty[i] != null)
					model.setCQty(cQty[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (rfaOfc[i] != null)
					model.setRfaOfc(rfaOfc[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (n1stPolDcSeq[i] != null)
					model.setN1stPolDcSeq(n1stPolDcSeq[i]);
				if (trMode[i] != null)
					model.setTrMode(trMode[i]);
				if (termNode[i] != null)
					model.setTermNode(termNode[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (replaneBndCd[i] != null)
					model.setReplaneBndCd(replaneBndCd[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (bbF[i] != null)
					model.setBbF(bbF[i]);
				if (scOfc[i] != null)
					model.setScOfc(scOfc[i]);
				if (bkgDelT[i] != null)
					model.setBkgDelT(bkgDelT[i]);
				if (hgF[i] != null)
					model.setHgF(hgF[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (akF[i] != null)
					model.setAkF(akF[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (socF[i] != null)
					model.setSocF(socF[i]);
				if (polPodSep[i] != null)
					model.setPolPodSep(polPodSep[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (troPkupCy[i] != null)
					model.setTroPkupCy(troPkupCy[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (haulage[i] != null)
					model.setHaulage(haulage[i]);
				if (mPu[i] != null)
					model.setMPu(mPu[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (n1stPodDcSeq[i] != null)
					model.setN1stPodDcSeq(n1stPodDcSeq[i]);
				if (cTpsz[i] != null)
					model.setCTpsz(cTpsz[i]);
				if (pod4N[i] != null)
					model.setPod4N(pod4N[i]);
				if (delN[i] != null)
					model.setDelN(delN[i]);
				if (mtPkupDt[i] != null)
					model.setMtPkupDt(mtPkupDt[i]);
				if (mapSeq[i] != null)
					model.setMapSeq(mapSeq[i]);
				if (rfa[i] != null)
					model.setRfa(rfa[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (delT[i] != null)
					model.setDelT(delT[i]);
				if (copyCnt[i] != null)
					model.setCopyCnt(copyCnt[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod3N[i] != null)
					model.setPod3N(pod3N[i]);
				if (pol2N[i] != null)
					model.setPol2N(pol2N[i]);
				if (pcMode[i] != null)
					model.setPcMode(pcMode[i]);
				if (areaContiCd[i] != null)
					model.setAreaContiCd(areaContiCd[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (ocnSeq[i] != null)
					model.setOcnSeq(ocnSeq[i]);
				if (bkgPctlNo[i] != null)
					model.setBkgPctlNo(bkgPctlNo[i]);
				if (hitchment[i] != null)
					model.setHitchment(hitchment[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (sumBkgQty[i] != null)
					model.setSumBkgQty(sumBkgQty[i]);
				if (lane3[i] != null)
					model.setLane3(lane3[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (dgF[i] != null)
					model.setDgF(dgF[i]);
				if (rfF[i] != null)
					model.setRfF(rfF[i]);
				if (noCost[i] != null)
					model.setNoCost(noCost[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cgoTp[i] != null)
					model.setCgoTp(cgoTp[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (pol1N[i] != null)
					model.setPol1N(pol1N[i]);
				if (com[i] != null)
					model.setCom(com[i]);
				if (ldDt[i] != null)
					model.setLdDt(ldDt[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (n3rdPodDcSeq[i] != null)
					model.setN3rdPodDcSeq(n3rdPodDcSeq[i]);
				if (cntrTpszQtyStr[i] != null)
					model.setCntrTpszQtyStr(cntrTpszQtyStr[i]);
				if (polN[i] != null)
					model.setPolN(polN[i]);
				if (troRtnCy[i] != null)
					model.setTroRtnCy(troRtnCy[i]);
				if (pmF[i] != null)
					model.setPmF(pmF[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (pod1N[i] != null)
					model.setPod1N(pod1N[i]);
				if (porN[i] != null)
					model.setPorN(porN[i]);
				if (podN[i] != null)
					model.setPodN(podN[i]);
				if (n4thPodDcSeq[i] != null)
					model.setN4thPodDcSeq(n4thPodDcSeq[i]);
				if (sumCTpSz[i] != null)
					model.setSumCTpSz(sumCTpSz[i]);
				if (pol4N[i] != null)
					model.setPol4N(pol4N[i]);
				if (orgSalOfc[i] != null)
					model.setOrgSalOfc(orgSalOfc[i]);
				if (wgtUn[i] != null)
					model.setWgtUn(wgtUn[i]);
				if (dorZone[i] != null)
					model.setDorZone(dorZone[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (drDt[i] != null)
					model.setDrDt(drDt[i]);
				if (repCom[i] != null)
					model.setRepCom(repCom[i]);
				if (n4thPolDcSeq[i] != null)
					model.setN4thPolDcSeq(n4thPolDcSeq[i]);
				if (cngn[i] != null)
					model.setCngn(cngn[i]);
				if (pol3N[i] != null)
					model.setPol3N(pol3N[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (pod2N[i] != null)
					model.setPod2N(pod2N[i]);
				if (rdF[i] != null)
					model.setRdF(rdF[i]);
				if (n2ndPolDcSeq[i] != null)
					model.setN2ndPolDcSeq(n2ndPolDcSeq[i]);
				if (dgClssCd[i] != null)
					model.setDgClssCd(dgClssCd[i]);
				if (pseudoVvd[i] != null)
					model.setPseudoVvd(pseudoVvd[i]);
				if (obTrspMode[i] != null)
					model.setObTrspMode(obTrspMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (mainPatternPctlNo[i] != null)
					model.setMainPatternPctlNo(mainPatternPctlNo[i]);
				if (fRt[i] != null)
					model.setFRt(fRt[i]);
				if (idaHlgTpCd[i] != null)
					model.setIdaHlgTpCd(idaHlgTpCd[i]);
				if (comBkgNo[i] != null)
					model.setComBkgNo(comBkgNo[i]);
				if (subF[i] != null)
					model.setSubF(subF[i]);
				if (copMapgSeq[i] != null)
					model.setCopMapgSeq(copMapgSeq[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (bkgRcvT[i] != null)
					model.setBkgRcvT(bkgRcvT[i]);
				if (mRt[i] != null)
					model.setMRt(mRt[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdCreateParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdCreateParamVO[]
	 */
	public PrdCreateParamVO[] getPrdCreateParamVOs(){
		PrdCreateParamVO[] vos = (PrdCreateParamVO[])models.toArray(new PrdCreateParamVO[models.size()]);
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
		this.ibTrspMode = this.ibTrspMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internalSkdType = this.internalSkdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvT = this.rcvT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolDcSeq = this.n3rdPolDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodDcSeq = this.n2ndPodDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cQty = this.cQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaOfc = this.rfaOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolDcSeq = this.n1stPolDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trMode = this.trMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termNode = this.termNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.replaneBndCd = this.replaneBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbF = this.bbF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scOfc = this.scOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelT = this.bkgDelT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgF = this.hgF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akF = this.akF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socF = this.socF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodSep = this.polPodSep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troPkupCy = this.troPkupCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulage = this.haulage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mPu = this.mPu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodDcSeq = this.n1stPodDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTpsz = this.cTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4N = this.pod4N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delN = this.delN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtPkupDt = this.mtPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapSeq = this.mapSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfa = this.rfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delT = this.delT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt = this.copyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3N = this.pod3N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2N = this.pol2N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcMode = this.pcMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaContiCd = this.areaContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnSeq = this.ocnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPctlNo = this.bkgPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hitchment = this.hitchment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumBkgQty = this.sumBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgF = this.dgF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfF = this.rfF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noCost = this.noCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTp = this.cgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1N = this.pol1N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.com = this.com .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldDt = this.ldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodDcSeq = this.n3rdPodDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszQtyStr = this.cntrTpszQtyStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polN = this.polN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troRtnCy = this.troRtnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmF = this.pmF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1N = this.pod1N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porN = this.porN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podN = this.podN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodDcSeq = this.n4thPodDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCTpSz = this.sumCTpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4N = this.pol4N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSalOfc = this.orgSalOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUn = this.wgtUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorZone = this.dorZone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drDt = this.drDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCom = this.repCom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolDcSeq = this.n4thPolDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngn = this.cngn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3N = this.pol3N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2N = this.pod2N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdF = this.rdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolDcSeq = this.n2ndPolDcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgClssCd = this.dgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pseudoVvd = this.pseudoVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTrspMode = this.obTrspMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainPatternPctlNo = this.mainPatternPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRt = this.fRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHlgTpCd = this.idaHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comBkgNo = this.comBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subF = this.subF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copMapgSeq = this.copMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvT = this.bkgRcvT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRt = this.mRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
