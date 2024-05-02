/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GrpBlPrtVO.java
*@FileTitle : GrpBlPrtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpBlPrtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlPrtVO> models = new ArrayList<GrpBlPrtVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String ca = null;
	/* Column Info */
	private String aSc = null;
	/* Column Info */
	private String oblPrnFlg = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String blBkgNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porEq = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String porEqOfc = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String bSc = null;
	/* Column Info */
	private String blMeasQty = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String orgSvc = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String st = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String aes = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgOrgRoute = null;
	/* Column Info */
	private String dstSvc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trunkPod = null;
	/* Column Info */
	private String rlyPolCd = null;
	/* Column Info */
	private String trunkPol = null;
	/* Column Info */
	private String polPod = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String sortPrePol = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String consignee = null;
	/* Column Info */
	private String blActWgt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String manifest = null;
	/* Column Info */
	private String sortPostVvd = null;
	/* Column Info */
	private String delEq = null;
	/* Column Info */
	private String sortPrePod = null;
	/* Column Info */
	private String aS = null;
	/* Column Info */
	private String rlyPodCd = null;
	/* Column Info */
	private String delEqOfc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dSc = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String caed = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String orderbyTitle = null;
	/* Column Info */
	private String ffdr = null;
	/* Column Info */
	private String chinaAgentCd = null;
	/* Column Info */
	private String bkgLane = null;
	/* Column Info */
	private String sortPostPol = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String sortPreVvd = null;
	/* Column Info */
	private String orderCol = null;
	/* Column Info */
	private String sortPostPod = null;
	/* Column Info */
	private String bkgDstRoute = null;
	/* Column Info */
	private String twnSoNo = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String rSc = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String commodity = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String rep = null;
	/* Column Info */
	private String rTerm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlPrtVO() {}

	public GrpBlPrtVO(String ibflag, String pagerows, String orderbyTitle, String bkgNo, String polPod, String blNo, String por, String pol, String pod, String del, String rTerm, String dTerm, String rlyPolCd, String rlyPodCd, String rep, String commodity, String dSc, String rSc, String aSc, String bSc, String aS, String st, String bdr, String ca, String twnSoNo, String porEq, String delEq, String scRfaNo, String aes, String caed, String manifest, String rate, String shipper, String consignee, String orderCol, String blBkgNo, String blActWgt, String blMeasQty, String oblIssFlg, String oblPrnFlg, String oblRlseFlg, String bkgCreDt, String bkgOfcCd, String obSlsOfcCd, String docUsrId, String obSrepCd, String bkgStsCd, String ffdr, String ntfy, String rcvTermCd, String deTermCd, String orgSvc, String dstSvc, String bkgOrgRoute, String bkgDstRoute, String porCd, String polCd, String podCd, String delCd, String sortPrePol, String sortPrePod, String sortPostPol, String sortPostPod, String trunkVvd, String sortPreVvd, String sortPostVvd, String trunkPol, String trunkPod, String bkgLane, String oblIssUsrId, String oblIssOfcCd, String bkgCgoTp, String chinaAgentCd, String porEqOfc, String delEqOfc, String scNo, String shprName, String cneeName) {
		this.ntfy = ntfy;
		this.ca = ca;
		this.aSc = aSc;
		this.oblPrnFlg = oblPrnFlg;
		this.por = por;
		this.blBkgNo = blBkgNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.porEq = porEq;
		this.obSrepCd = obSrepCd;
		this.polCd = polCd;
		this.porEqOfc = porEqOfc;
		this.oblIssUsrId = oblIssUsrId;
		this.bSc = bSc;
		this.blMeasQty = blMeasQty;
		this.scNo = scNo;
		this.orgSvc = orgSvc;
		this.pol = pol;
		this.bkgCreDt = bkgCreDt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.st = st;
		this.dTerm = dTerm;
		this.oblIssOfcCd = oblIssOfcCd;
		this.pod = pod;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgCgoTp = bkgCgoTp;
		this.aes = aes;
		this.delCd = delCd;
		this.bkgOrgRoute = bkgOrgRoute;
		this.dstSvc = dstSvc;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.trunkPod = trunkPod;
		this.rlyPolCd = rlyPolCd;
		this.trunkPol = trunkPol;
		this.polPod = polPod;
		this.porCd = porCd;
		this.shprName = shprName;
		this.sortPrePol = sortPrePol;
		this.docUsrId = docUsrId;
		this.consignee = consignee;
		this.blActWgt = blActWgt;
		this.bkgStsCd = bkgStsCd;
		this.trunkVvd = trunkVvd;
		this.manifest = manifest;
		this.sortPostVvd = sortPostVvd;
		this.delEq = delEq;
		this.sortPrePod = sortPrePod;
		this.aS = aS;
		this.rlyPodCd = rlyPodCd;
		this.delEqOfc = delEqOfc;
		this.ibflag = ibflag;
		this.dSc = dSc;
		this.rate = rate;
		this.caed = caed;
		this.bdr = bdr;
		this.del = del;
		this.rcvTermCd = rcvTermCd;
		this.orderbyTitle = orderbyTitle;
		this.ffdr = ffdr;
		this.chinaAgentCd = chinaAgentCd;
		this.bkgLane = bkgLane;
		this.sortPostPol = sortPostPol;
		this.oblIssFlg = oblIssFlg;
		this.shipper = shipper;
		this.sortPreVvd = sortPreVvd;
		this.orderCol = orderCol;
		this.sortPostPod = sortPostPod;
		this.bkgDstRoute = bkgDstRoute;
		this.twnSoNo = twnSoNo;
		this.oblRlseFlg = oblRlseFlg;
		this.deTermCd = deTermCd;
		this.rSc = rSc;
		this.cneeName = cneeName;
		this.commodity = commodity;
		this.scRfaNo = scRfaNo;
		this.rep = rep;
		this.rTerm = rTerm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("ca", getCa());
		this.hashColumns.put("a_sc", getASc());
		this.hashColumns.put("obl_prn_flg", getOblPrnFlg());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("bl_bkg_no", getBlBkgNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_eq", getPorEq());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("por_eq_ofc", getPorEqOfc());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("b_sc", getBSc());
		this.hashColumns.put("bl_meas_qty", getBlMeasQty());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("org_svc", getOrgSvc());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("st", getSt());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("aes", getAes());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_org_route", getBkgOrgRoute());
		this.hashColumns.put("dst_svc", getDstSvc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trunk_pod", getTrunkPod());
		this.hashColumns.put("rly_pol_cd", getRlyPolCd());
		this.hashColumns.put("trunk_pol", getTrunkPol());
		this.hashColumns.put("pol_pod", getPolPod());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("sort_pre_pol", getSortPrePol());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("bl_act_wgt", getBlActWgt());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("manifest", getManifest());
		this.hashColumns.put("sort_post_vvd", getSortPostVvd());
		this.hashColumns.put("del_eq", getDelEq());
		this.hashColumns.put("sort_pre_pod", getSortPrePod());
		this.hashColumns.put("a_s", getAS());
		this.hashColumns.put("rly_pod_cd", getRlyPodCd());
		this.hashColumns.put("del_eq_ofc", getDelEqOfc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_sc", getDSc());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("caed", getCaed());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("orderby_title", getOrderbyTitle());
		this.hashColumns.put("ffdr", getFfdr());
		this.hashColumns.put("china_agent_cd", getChinaAgentCd());
		this.hashColumns.put("bkg_lane", getBkgLane());
		this.hashColumns.put("sort_post_pol", getSortPostPol());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("sort_pre_vvd", getSortPreVvd());
		this.hashColumns.put("order_col", getOrderCol());
		this.hashColumns.put("sort_post_pod", getSortPostPod());
		this.hashColumns.put("bkg_dst_route", getBkgDstRoute());
		this.hashColumns.put("twn_so_no", getTwnSoNo());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("r_sc", getRSc());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("rep", getRep());
		this.hashColumns.put("r_term", getRTerm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("ca", "ca");
		this.hashFields.put("a_sc", "aSc");
		this.hashFields.put("obl_prn_flg", "oblPrnFlg");
		this.hashFields.put("por", "por");
		this.hashFields.put("bl_bkg_no", "blBkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_eq", "porEq");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("por_eq_ofc", "porEqOfc");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("b_sc", "bSc");
		this.hashFields.put("bl_meas_qty", "blMeasQty");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("org_svc", "orgSvc");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("st", "st");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("aes", "aes");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_org_route", "bkgOrgRoute");
		this.hashFields.put("dst_svc", "dstSvc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trunk_pod", "trunkPod");
		this.hashFields.put("rly_pol_cd", "rlyPolCd");
		this.hashFields.put("trunk_pol", "trunkPol");
		this.hashFields.put("pol_pod", "polPod");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("sort_pre_pol", "sortPrePol");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("bl_act_wgt", "blActWgt");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("manifest", "manifest");
		this.hashFields.put("sort_post_vvd", "sortPostVvd");
		this.hashFields.put("del_eq", "delEq");
		this.hashFields.put("sort_pre_pod", "sortPrePod");
		this.hashFields.put("a_s", "aS");
		this.hashFields.put("rly_pod_cd", "rlyPodCd");
		this.hashFields.put("del_eq_ofc", "delEqOfc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_sc", "dSc");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("caed", "caed");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("del", "del");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("orderby_title", "orderbyTitle");
		this.hashFields.put("ffdr", "ffdr");
		this.hashFields.put("china_agent_cd", "chinaAgentCd");
		this.hashFields.put("bkg_lane", "bkgLane");
		this.hashFields.put("sort_post_pol", "sortPostPol");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("sort_pre_vvd", "sortPreVvd");
		this.hashFields.put("order_col", "orderCol");
		this.hashFields.put("sort_post_pod", "sortPostPod");
		this.hashFields.put("bkg_dst_route", "bkgDstRoute");
		this.hashFields.put("twn_so_no", "twnSoNo");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("r_sc", "rSc");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("rep", "rep");
		this.hashFields.put("r_term", "rTerm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
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
	 * @return aSc
	 */
	public String getASc() {
		return this.aSc;
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
	 * @return por
	 */
	public String getPor() {
		return this.por;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return porEqOfc
	 */
	public String getPorEqOfc() {
		return this.porEqOfc;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
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
	 * @return blMeasQty
	 */
	public String getBlMeasQty() {
		return this.blMeasQty;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return orgSvc
	 */
	public String getOrgSvc() {
		return this.orgSvc;
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
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOrgRoute
	 */
	public String getBkgOrgRoute() {
		return this.bkgOrgRoute;
	}
	
	/**
	 * Column Info
	 * @return dstSvc
	 */
	public String getDstSvc() {
		return this.dstSvc;
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
	 * @return trunkPod
	 */
	public String getTrunkPod() {
		return this.trunkPod;
	}
	
	/**
	 * Column Info
	 * @return rlyPolCd
	 */
	public String getRlyPolCd() {
		return this.rlyPolCd;
	}
	
	/**
	 * Column Info
	 * @return trunkPol
	 */
	public String getTrunkPol() {
		return this.trunkPol;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}
	
	/**
	 * Column Info
	 * @return sortPrePol
	 */
	public String getSortPrePol() {
		return this.sortPrePol;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
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
	 * @return blActWgt
	 */
	public String getBlActWgt() {
		return this.blActWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
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
	 * @return sortPostVvd
	 */
	public String getSortPostVvd() {
		return this.sortPostVvd;
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
	 * @return sortPrePod
	 */
	public String getSortPrePod() {
		return this.sortPrePod;
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
	 * @return rlyPodCd
	 */
	public String getRlyPodCd() {
		return this.rlyPodCd;
	}
	
	/**
	 * Column Info
	 * @return delEqOfc
	 */
	public String getDelEqOfc() {
		return this.delEqOfc;
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
	 * @return dSc
	 */
	public String getDSc() {
		return this.dSc;
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
	 * @return caed
	 */
	public String getCaed() {
		return this.caed;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return orderbyTitle
	 */
	public String getOrderbyTitle() {
		return this.orderbyTitle;
	}
	
	/**
	 * Column Info
	 * @return ffdr
	 */
	public String getFfdr() {
		return this.ffdr;
	}
	
	/**
	 * Column Info
	 * @return chinaAgentCd
	 */
	public String getChinaAgentCd() {
		return this.chinaAgentCd;
	}
	
	/**
	 * Column Info
	 * @return bkgLane
	 */
	public String getBkgLane() {
		return this.bkgLane;
	}
	
	/**
	 * Column Info
	 * @return sortPostPol
	 */
	public String getSortPostPol() {
		return this.sortPostPol;
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
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
	}
	
	/**
	 * Column Info
	 * @return sortPreVvd
	 */
	public String getSortPreVvd() {
		return this.sortPreVvd;
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
	 * @return sortPostPod
	 */
	public String getSortPostPod() {
		return this.sortPostPod;
	}
	
	/**
	 * Column Info
	 * @return bkgDstRoute
	 */
	public String getBkgDstRoute() {
		return this.bkgDstRoute;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
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
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
	}
	

	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
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
	 * @param aSc
	 */
	public void setASc(String aSc) {
		this.aSc = aSc;
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
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param porEqOfc
	 */
	public void setPorEqOfc(String porEqOfc) {
		this.porEqOfc = porEqOfc;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
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
	 * @param blMeasQty
	 */
	public void setBlMeasQty(String blMeasQty) {
		this.blMeasQty = blMeasQty;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param orgSvc
	 */
	public void setOrgSvc(String orgSvc) {
		this.orgSvc = orgSvc;
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
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOrgRoute
	 */
	public void setBkgOrgRoute(String bkgOrgRoute) {
		this.bkgOrgRoute = bkgOrgRoute;
	}
	
	/**
	 * Column Info
	 * @param dstSvc
	 */
	public void setDstSvc(String dstSvc) {
		this.dstSvc = dstSvc;
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
	 * @param trunkPod
	 */
	public void setTrunkPod(String trunkPod) {
		this.trunkPod = trunkPod;
	}
	
	/**
	 * Column Info
	 * @param rlyPolCd
	 */
	public void setRlyPolCd(String rlyPolCd) {
		this.rlyPolCd = rlyPolCd;
	}
	
	/**
	 * Column Info
	 * @param trunkPol
	 */
	public void setTrunkPol(String trunkPol) {
		this.trunkPol = trunkPol;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param sortPrePol
	 */
	public void setSortPrePol(String sortPrePol) {
		this.sortPrePol = sortPrePol;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
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
	 * @param blActWgt
	 */
	public void setBlActWgt(String blActWgt) {
		this.blActWgt = blActWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
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
	 * @param sortPostVvd
	 */
	public void setSortPostVvd(String sortPostVvd) {
		this.sortPostVvd = sortPostVvd;
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
	 * @param sortPrePod
	 */
	public void setSortPrePod(String sortPrePod) {
		this.sortPrePod = sortPrePod;
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
	 * @param rlyPodCd
	 */
	public void setRlyPodCd(String rlyPodCd) {
		this.rlyPodCd = rlyPodCd;
	}
	
	/**
	 * Column Info
	 * @param delEqOfc
	 */
	public void setDelEqOfc(String delEqOfc) {
		this.delEqOfc = delEqOfc;
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
	 * @param dSc
	 */
	public void setDSc(String dSc) {
		this.dSc = dSc;
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
	 * @param caed
	 */
	public void setCaed(String caed) {
		this.caed = caed;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param orderbyTitle
	 */
	public void setOrderbyTitle(String orderbyTitle) {
		this.orderbyTitle = orderbyTitle;
	}
	
	/**
	 * Column Info
	 * @param ffdr
	 */
	public void setFfdr(String ffdr) {
		this.ffdr = ffdr;
	}
	
	/**
	 * Column Info
	 * @param chinaAgentCd
	 */
	public void setChinaAgentCd(String chinaAgentCd) {
		this.chinaAgentCd = chinaAgentCd;
	}
	
	/**
	 * Column Info
	 * @param bkgLane
	 */
	public void setBkgLane(String bkgLane) {
		this.bkgLane = bkgLane;
	}
	
	/**
	 * Column Info
	 * @param sortPostPol
	 */
	public void setSortPostPol(String sortPostPol) {
		this.sortPostPol = sortPostPol;
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
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	
	/**
	 * Column Info
	 * @param sortPreVvd
	 */
	public void setSortPreVvd(String sortPreVvd) {
		this.sortPreVvd = sortPreVvd;
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
	 * @param sortPostPod
	 */
	public void setSortPostPod(String sortPostPod) {
		this.sortPostPod = sortPostPod;
	}
	
	/**
	 * Column Info
	 * @param bkgDstRoute
	 */
	public void setBkgDstRoute(String bkgDstRoute) {
		this.bkgDstRoute = bkgDstRoute;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
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
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
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
		setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
		setCa(JSPUtil.getParameter(request, prefix + "ca", ""));
		setASc(JSPUtil.getParameter(request, prefix + "a_sc", ""));
		setOblPrnFlg(JSPUtil.getParameter(request, prefix + "obl_prn_flg", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setBlBkgNo(JSPUtil.getParameter(request, prefix + "bl_bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPorEq(JSPUtil.getParameter(request, prefix + "por_eq", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPorEqOfc(JSPUtil.getParameter(request, prefix + "por_eq_ofc", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, prefix + "obl_iss_usr_id", ""));
		setBSc(JSPUtil.getParameter(request, prefix + "b_sc", ""));
		setBlMeasQty(JSPUtil.getParameter(request, prefix + "bl_meas_qty", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOrgSvc(JSPUtil.getParameter(request, prefix + "org_svc", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setSt(JSPUtil.getParameter(request, prefix + "st", ""));
		setDTerm(JSPUtil.getParameter(request, prefix + "d_term", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp", ""));
		setAes(JSPUtil.getParameter(request, prefix + "aes", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgOrgRoute(JSPUtil.getParameter(request, prefix + "bkg_org_route", ""));
		setDstSvc(JSPUtil.getParameter(request, prefix + "dst_svc", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTrunkPod(JSPUtil.getParameter(request, prefix + "trunk_pod", ""));
		setRlyPolCd(JSPUtil.getParameter(request, prefix + "rly_pol_cd", ""));
		setTrunkPol(JSPUtil.getParameter(request, prefix + "trunk_pol", ""));
		setPolPod(JSPUtil.getParameter(request, prefix + "pol_pod", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setSortPrePol(JSPUtil.getParameter(request, prefix + "sort_pre_pol", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setBlActWgt(JSPUtil.getParameter(request, prefix + "bl_act_wgt", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setManifest(JSPUtil.getParameter(request, prefix + "manifest", ""));
		setSortPostVvd(JSPUtil.getParameter(request, prefix + "sort_post_vvd", ""));
		setDelEq(JSPUtil.getParameter(request, prefix + "del_eq", ""));
		setSortPrePod(JSPUtil.getParameter(request, prefix + "sort_pre_pod", ""));
		setAS(JSPUtil.getParameter(request, prefix + "a_s", ""));
		setRlyPodCd(JSPUtil.getParameter(request, prefix + "rly_pod_cd", ""));
		setDelEqOfc(JSPUtil.getParameter(request, prefix + "del_eq_ofc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDSc(JSPUtil.getParameter(request, prefix + "d_sc", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setCaed(JSPUtil.getParameter(request, prefix + "caed", ""));
		setBdr(JSPUtil.getParameter(request, prefix + "bdr", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setOrderbyTitle(JSPUtil.getParameter(request, prefix + "orderby_title", ""));
		setFfdr(JSPUtil.getParameter(request, prefix + "ffdr", ""));
		setChinaAgentCd(JSPUtil.getParameter(request, prefix + "china_agent_cd", ""));
		setBkgLane(JSPUtil.getParameter(request, prefix + "bkg_lane", ""));
		setSortPostPol(JSPUtil.getParameter(request, prefix + "sort_post_pol", ""));
		setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setSortPreVvd(JSPUtil.getParameter(request, prefix + "sort_pre_vvd", ""));
		setOrderCol(JSPUtil.getParameter(request, prefix + "order_col", ""));
		setSortPostPod(JSPUtil.getParameter(request, prefix + "sort_post_pod", ""));
		setBkgDstRoute(JSPUtil.getParameter(request, prefix + "bkg_dst_route", ""));
		setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, prefix + "obl_rlse_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setRSc(JSPUtil.getParameter(request, prefix + "r_sc", ""));
		setCneeName(JSPUtil.getParameter(request, prefix + "cnee_name", ""));
		setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setRep(JSPUtil.getParameter(request, prefix + "rep", ""));
		setRTerm(JSPUtil.getParameter(request, prefix + "r_term", ""));
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
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] ca = (JSPUtil.getParameter(request, prefix	+ "ca", length));
			String[] aSc = (JSPUtil.getParameter(request, prefix	+ "a_sc", length));
			String[] oblPrnFlg = (JSPUtil.getParameter(request, prefix	+ "obl_prn_flg", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] blBkgNo = (JSPUtil.getParameter(request, prefix	+ "bl_bkg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porEq = (JSPUtil.getParameter(request, prefix	+ "por_eq", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] porEqOfc = (JSPUtil.getParameter(request, prefix	+ "por_eq_ofc", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] bSc = (JSPUtil.getParameter(request, prefix	+ "b_sc", length));
			String[] blMeasQty = (JSPUtil.getParameter(request, prefix	+ "bl_meas_qty", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] orgSvc = (JSPUtil.getParameter(request, prefix	+ "org_svc", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] st = (JSPUtil.getParameter(request, prefix	+ "st", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] aes = (JSPUtil.getParameter(request, prefix	+ "aes", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgOrgRoute = (JSPUtil.getParameter(request, prefix	+ "bkg_org_route", length));
			String[] dstSvc = (JSPUtil.getParameter(request, prefix	+ "dst_svc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trunkPod = (JSPUtil.getParameter(request, prefix	+ "trunk_pod", length));
			String[] rlyPolCd = (JSPUtil.getParameter(request, prefix	+ "rly_pol_cd", length));
			String[] trunkPol = (JSPUtil.getParameter(request, prefix	+ "trunk_pol", length));
			String[] polPod = (JSPUtil.getParameter(request, prefix	+ "pol_pod", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] sortPrePol = (JSPUtil.getParameter(request, prefix	+ "sort_pre_pol", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] blActWgt = (JSPUtil.getParameter(request, prefix	+ "bl_act_wgt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] manifest = (JSPUtil.getParameter(request, prefix	+ "manifest", length));
			String[] sortPostVvd = (JSPUtil.getParameter(request, prefix	+ "sort_post_vvd", length));
			String[] delEq = (JSPUtil.getParameter(request, prefix	+ "del_eq", length));
			String[] sortPrePod = (JSPUtil.getParameter(request, prefix	+ "sort_pre_pod", length));
			String[] aS = (JSPUtil.getParameter(request, prefix	+ "a_s", length));
			String[] rlyPodCd = (JSPUtil.getParameter(request, prefix	+ "rly_pod_cd", length));
			String[] delEqOfc = (JSPUtil.getParameter(request, prefix	+ "del_eq_ofc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dSc = (JSPUtil.getParameter(request, prefix	+ "d_sc", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] caed = (JSPUtil.getParameter(request, prefix	+ "caed", length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] orderbyTitle = (JSPUtil.getParameter(request, prefix	+ "orderby_title", length));
			String[] ffdr = (JSPUtil.getParameter(request, prefix	+ "ffdr", length));
			String[] chinaAgentCd = (JSPUtil.getParameter(request, prefix	+ "china_agent_cd", length));
			String[] bkgLane = (JSPUtil.getParameter(request, prefix	+ "bkg_lane", length));
			String[] sortPostPol = (JSPUtil.getParameter(request, prefix	+ "sort_post_pol", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] sortPreVvd = (JSPUtil.getParameter(request, prefix	+ "sort_pre_vvd", length));
			String[] orderCol = (JSPUtil.getParameter(request, prefix	+ "order_col", length));
			String[] sortPostPod = (JSPUtil.getParameter(request, prefix	+ "sort_post_pod", length));
			String[] bkgDstRoute = (JSPUtil.getParameter(request, prefix	+ "bkg_dst_route", length));
			String[] twnSoNo = (JSPUtil.getParameter(request, prefix	+ "twn_so_no", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] rSc = (JSPUtil.getParameter(request, prefix	+ "r_sc", length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] rep = (JSPUtil.getParameter(request, prefix	+ "rep", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlPrtVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (ca[i] != null)
					model.setCa(ca[i]);
				if (aSc[i] != null)
					model.setASc(aSc[i]);
				if (oblPrnFlg[i] != null)
					model.setOblPrnFlg(oblPrnFlg[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (blBkgNo[i] != null)
					model.setBlBkgNo(blBkgNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porEq[i] != null)
					model.setPorEq(porEq[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (porEqOfc[i] != null)
					model.setPorEqOfc(porEqOfc[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (bSc[i] != null)
					model.setBSc(bSc[i]);
				if (blMeasQty[i] != null)
					model.setBlMeasQty(blMeasQty[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (orgSvc[i] != null)
					model.setOrgSvc(orgSvc[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (st[i] != null)
					model.setSt(st[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (aes[i] != null)
					model.setAes(aes[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgOrgRoute[i] != null)
					model.setBkgOrgRoute(bkgOrgRoute[i]);
				if (dstSvc[i] != null)
					model.setDstSvc(dstSvc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trunkPod[i] != null)
					model.setTrunkPod(trunkPod[i]);
				if (rlyPolCd[i] != null)
					model.setRlyPolCd(rlyPolCd[i]);
				if (trunkPol[i] != null)
					model.setTrunkPol(trunkPol[i]);
				if (polPod[i] != null)
					model.setPolPod(polPod[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (sortPrePol[i] != null)
					model.setSortPrePol(sortPrePol[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (blActWgt[i] != null)
					model.setBlActWgt(blActWgt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (manifest[i] != null)
					model.setManifest(manifest[i]);
				if (sortPostVvd[i] != null)
					model.setSortPostVvd(sortPostVvd[i]);
				if (delEq[i] != null)
					model.setDelEq(delEq[i]);
				if (sortPrePod[i] != null)
					model.setSortPrePod(sortPrePod[i]);
				if (aS[i] != null)
					model.setAS(aS[i]);
				if (rlyPodCd[i] != null)
					model.setRlyPodCd(rlyPodCd[i]);
				if (delEqOfc[i] != null)
					model.setDelEqOfc(delEqOfc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dSc[i] != null)
					model.setDSc(dSc[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (caed[i] != null)
					model.setCaed(caed[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (orderbyTitle[i] != null)
					model.setOrderbyTitle(orderbyTitle[i]);
				if (ffdr[i] != null)
					model.setFfdr(ffdr[i]);
				if (chinaAgentCd[i] != null)
					model.setChinaAgentCd(chinaAgentCd[i]);
				if (bkgLane[i] != null)
					model.setBkgLane(bkgLane[i]);
				if (sortPostPol[i] != null)
					model.setSortPostPol(sortPostPol[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (sortPreVvd[i] != null)
					model.setSortPreVvd(sortPreVvd[i]);
				if (orderCol[i] != null)
					model.setOrderCol(orderCol[i]);
				if (sortPostPod[i] != null)
					model.setSortPostPod(sortPostPod[i]);
				if (bkgDstRoute[i] != null)
					model.setBkgDstRoute(bkgDstRoute[i]);
				if (twnSoNo[i] != null)
					model.setTwnSoNo(twnSoNo[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (rSc[i] != null)
					model.setRSc(rSc[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (commodity[i] != null)
					model.setCommodity(commodity[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (rep[i] != null)
					model.setRep(rep[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ca = this.ca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSc = this.aSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblPrnFlg = this.oblPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blBkgNo = this.blBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEq = this.porEq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEqOfc = this.porEqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bSc = this.bSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeasQty = this.blMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSvc = this.orgSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st = this.st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aes = this.aes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOrgRoute = this.bkgOrgRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstSvc = this.dstSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPod = this.trunkPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPolCd = this.rlyPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPol = this.trunkPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortPrePol = this.sortPrePol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blActWgt = this.blActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manifest = this.manifest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortPostVvd = this.sortPostVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEq = this.delEq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortPrePod = this.sortPrePod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aS = this.aS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPodCd = this.rlyPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEqOfc = this.delEqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dSc = this.dSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caed = this.caed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbyTitle = this.orderbyTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffdr = this.ffdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chinaAgentCd = this.chinaAgentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLane = this.bkgLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortPostPol = this.sortPostPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortPreVvd = this.sortPreVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderCol = this.orderCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortPostPod = this.sortPostPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDstRoute = this.bkgDstRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnSoNo = this.twnSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSc = this.rSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rep = this.rep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
