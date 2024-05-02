/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteVO.java
*@FileTitle : InlandRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.07.31 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InlandRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InlandRouteVO> models = new ArrayList<InlandRouteVO>();
	
	/* Column Info */
	private String n1stAgmtNo = null;
	/* Column Info */
	private String cnstRmk = null;
	/* Column Info */
	private String n4thVndrSeq = null;
	/* Column Info */
	private String n5thNodCd = null;
	/* Column Info */
	private String n6thTrspModCd = null;
	/* Column Info */
	private String sumDwTt = null;
	/* Column Info */
	private String n2ndTrspModCd = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String n1stAgmtRefNo = null;
	/* Column Info */
	private String n5thAgmtNo = null;
	/* Column Info */
	private String inlndRoutTmpFlg = null;
	/* Column Info */
	private String n1stTrspModCd = null;
	/* Column Info */
	private String n3rdAgmtCreOfcCd = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String n3rdTrspModCd = null;
	/* Column Info */
	private String n6thAgmtRefNo = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String frontGb = null;
	/* Column Info */
	private String cnstFlg = null;
	/* Column Info */
	private String n4thVndrNm = null;
	/* Column Info */
	private String n6thNodCd = null;
	/* Column Info */
	private String iDestCd = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String groupGubun = null;
	/* Column Info */
	private String sumTtTime = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String n4thAgmtCreOfcCd = null;
	/* Column Info */
	private String n5thVndrSeq = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String n6thAgmtCreOfcCd = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String rInbound = null;
	/* Column Info */
	private String n4thAgmtRefNo = null;
	/* Column Info */
	private String orgLocType = null;
	/* Column Info */
	private String undefineNod = null;
	/* Column Info */
	private String inlndRoutBkgFlg = null;
	/* Column Info */
	private String n3rdAgmtNo = null;
	/* Column Info */
	private String n1stAgmtCreOfcCd = null;
	/* Column Info */
	private String n3rdNodCd = null;
	/* Column Info */
	private String n3rdAgmtRefNo = null;
	/* Column Info */
	private String n4thTrspModCd = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String iOrgCd = null;
	/* Column Info */
	private String hubSearchGb = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n5thTrspModCd = null;
	/* Column Info */
	private String n5thAgmtCreOfcCd = null;
	/* Column Info */
	private String n7thNodCd = null;
	/* Column Info */
	private String n6thVndrSeq = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String inlndRoutInclSttlFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String totTt = null;
	/* Column Info */
	private String n6thVndrNm = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String n5thVndrNm = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Column Info */
	private String n3rdVndrSeq = null;
	/* Column Info */
	private String n2ndAgmtRefNo = null;
	/* Column Info */
	private String n5thAgmtRefNo = null;
	/* Column Info */
	private String n3rdVndrNm = null;
	/* Column Info */
	private String destLocType = null;
	/* Column Info */
	private String n6thAgmtNo = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String n2ndAgmtNo = null;
	/* Column Info */
	private String n4thAgmtNo = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String route = null;
	/* Column Info */
	private String n2ndAgmtCreOfcCd = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	
	private String inlndRoutOptmFlg = null;
	private String altnOptmFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InlandRouteVO() {}

	public InlandRouteVO(String ibflag, String pagerows, String routOrgNodCd, String routDestNodCd, String rn, String inlndRoutBkgFlg, String inlndRoutTmpFlg, String inlndRoutInclSttlFlg, String orgLoc, String orgLocType, String destLoc, String destLocType, String routSeq, String prioSeq, String route, String sumTtTime, String sumDwTt, String totTt, String pctlIoBndCd, String n1stNodCd, String n1stTrspModCd, String n1stVndrSeq, String n1stVndrNm, String n1stAgmtNo, String n1stAgmtCreOfcCd, String n1stAgmtRefNo, String n2ndNodCd, String n2ndTrspModCd, String n2ndVndrSeq, String n2ndVndrNm, String n2ndAgmtNo, String n2ndAgmtCreOfcCd, String n2ndAgmtRefNo, String n3rdNodCd, String n3rdTrspModCd, String n3rdVndrSeq, String n3rdVndrNm, String n3rdAgmtNo, String n3rdAgmtCreOfcCd, String n3rdAgmtRefNo, String n4thNodCd, String n4thTrspModCd, String n4thVndrSeq, String n4thVndrNm, String n4thAgmtNo, String n4thAgmtCreOfcCd, String n4thAgmtRefNo, String n5thNodCd, String n5thTrspModCd, String n5thVndrSeq, String n5thVndrNm, String n5thAgmtNo, String n5thAgmtCreOfcCd, String n5thAgmtRefNo, String n6thNodCd, String n6thTrspModCd, String n6thVndrSeq, String n6thVndrNm, String n6thAgmtNo, String n6thAgmtCreOfcCd, String n6thAgmtRefNo, String n7thNodCd, String creOfcCd, String creDt, String inlndRoutRmk, String cnstRmk, String cnstFlg, String hubSearchGb, String frontGb, String undefineNod, String groupGubun, String rInbound, String iOrgCd, String iDestCd, String inlndRoutOptmFlg, String altnOptmFlg) {
		this.n1stAgmtNo = n1stAgmtNo;
		this.cnstRmk = cnstRmk;
		this.n4thVndrSeq = n4thVndrSeq;
		this.n5thNodCd = n5thNodCd;
		this.n6thTrspModCd = n6thTrspModCd;
		this.sumDwTt = sumDwTt;
		this.n2ndTrspModCd = n2ndTrspModCd;
		this.routOrgNodCd = routOrgNodCd;
		this.pagerows = pagerows;
		this.n1stAgmtRefNo = n1stAgmtRefNo;
		this.n5thAgmtNo = n5thAgmtNo;
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
		this.n1stTrspModCd = n1stTrspModCd;
		this.n3rdAgmtCreOfcCd = n3rdAgmtCreOfcCd;
		this.orgLoc = orgLoc;
		this.n3rdTrspModCd = n3rdTrspModCd;
		this.n6thAgmtRefNo = n6thAgmtRefNo;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.frontGb = frontGb;
		this.cnstFlg = cnstFlg;
		this.n4thVndrNm = n4thVndrNm;
		this.n6thNodCd = n6thNodCd;
		this.iDestCd = iDestCd;
		this.n2ndNodCd = n2ndNodCd;
		this.groupGubun = groupGubun;
		this.sumTtTime = sumTtTime;
		this.routSeq = routSeq;
		this.n4thAgmtCreOfcCd = n4thAgmtCreOfcCd;
		this.n5thVndrSeq = n5thVndrSeq;
		this.n4thNodCd = n4thNodCd;
		this.n6thAgmtCreOfcCd = n6thAgmtCreOfcCd;
		this.n1stNodCd = n1stNodCd;
		this.rInbound = rInbound;
		this.n4thAgmtRefNo = n4thAgmtRefNo;
		this.orgLocType = orgLocType;
		this.undefineNod = undefineNod;
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
		this.n3rdAgmtNo = n3rdAgmtNo;
		this.n1stAgmtCreOfcCd = n1stAgmtCreOfcCd;
		this.n3rdNodCd = n3rdNodCd;
		this.n3rdAgmtRefNo = n3rdAgmtRefNo;
		this.n4thTrspModCd = n4thTrspModCd;
		this.rn = rn;
		this.iOrgCd = iOrgCd;
		this.hubSearchGb = hubSearchGb;
		this.creDt = creDt;
		this.n5thTrspModCd = n5thTrspModCd;
		this.n5thAgmtCreOfcCd = n5thAgmtCreOfcCd;
		this.n7thNodCd = n7thNodCd;
		this.n6thVndrSeq = n6thVndrSeq;
		this.ibflag = ibflag;
		this.inlndRoutInclSttlFlg = inlndRoutInclSttlFlg;
		this.creOfcCd = creOfcCd;
		this.n1stVndrSeq = n1stVndrSeq;
		this.totTt = totTt;
		this.n6thVndrNm = n6thVndrNm;
		this.n1stVndrNm = n1stVndrNm;
		this.routDestNodCd = routDestNodCd;
		this.n5thVndrNm = n5thVndrNm;
		this.pctlIoBndCd = pctlIoBndCd;
		this.n3rdVndrSeq = n3rdVndrSeq;
		this.n2ndAgmtRefNo = n2ndAgmtRefNo;
		this.n5thAgmtRefNo = n5thAgmtRefNo;
		this.n3rdVndrNm = n3rdVndrNm;
		this.destLocType = destLocType;
		this.n6thAgmtNo = n6thAgmtNo;
		this.destLoc = destLoc;
		this.n2ndAgmtNo = n2ndAgmtNo;
		this.n4thAgmtNo = n4thAgmtNo;
		this.inlndRoutRmk = inlndRoutRmk;
		this.route = route;
		this.n2ndAgmtCreOfcCd = n2ndAgmtCreOfcCd;
		this.prioSeq = prioSeq;
		this.n2ndVndrNm = n2ndVndrNm;
		this.inlndRoutOptmFlg = inlndRoutOptmFlg;
		this.altnOptmFlg = altnOptmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_agmt_no", getN1stAgmtNo());
		this.hashColumns.put("cnst_rmk", getCnstRmk());
		this.hashColumns.put("n4th_vndr_seq", getN4thVndrSeq());
		this.hashColumns.put("n5th_nod_cd", getN5thNodCd());
		this.hashColumns.put("n6th_trsp_mod_cd", getN6thTrspModCd());
		this.hashColumns.put("sum_dw_tt", getSumDwTt());
		this.hashColumns.put("n2nd_trsp_mod_cd", getN2ndTrspModCd());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n1st_agmt_ref_no", getN1stAgmtRefNo());
		this.hashColumns.put("n5th_agmt_no", getN5thAgmtNo());
		this.hashColumns.put("inlnd_rout_tmp_flg", getInlndRoutTmpFlg());
		this.hashColumns.put("n1st_trsp_mod_cd", getN1stTrspModCd());
		this.hashColumns.put("n3rd_agmt_cre_ofc_cd", getN3rdAgmtCreOfcCd());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("n3rd_trsp_mod_cd", getN3rdTrspModCd());
		this.hashColumns.put("n6th_agmt_ref_no", getN6thAgmtRefNo());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("front_gb", getFrontGb());
		this.hashColumns.put("cnst_flg", getCnstFlg());
		this.hashColumns.put("n4th_vndr_nm", getN4thVndrNm());
		this.hashColumns.put("n6th_nod_cd", getN6thNodCd());
		this.hashColumns.put("i_dest_cd", getIDestCd());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("group_gubun", getGroupGubun());
		this.hashColumns.put("sum_tt_time", getSumTtTime());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("n4th_agmt_cre_ofc_cd", getN4thAgmtCreOfcCd());
		this.hashColumns.put("n5th_vndr_seq", getN5thVndrSeq());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("n6th_agmt_cre_ofc_cd", getN6thAgmtCreOfcCd());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("r_inbound", getRInbound());
		this.hashColumns.put("n4th_agmt_ref_no", getN4thAgmtRefNo());
		this.hashColumns.put("org_loc_type", getOrgLocType());
		this.hashColumns.put("undefine_nod", getUndefineNod());
		this.hashColumns.put("inlnd_rout_bkg_flg", getInlndRoutBkgFlg());
		this.hashColumns.put("n3rd_agmt_no", getN3rdAgmtNo());
		this.hashColumns.put("n1st_agmt_cre_ofc_cd", getN1stAgmtCreOfcCd());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		this.hashColumns.put("n3rd_agmt_ref_no", getN3rdAgmtRefNo());
		this.hashColumns.put("n4th_trsp_mod_cd", getN4thTrspModCd());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("i_org_cd", getIOrgCd());
		this.hashColumns.put("hub_search_gb", getHubSearchGb());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n5th_trsp_mod_cd", getN5thTrspModCd());
		this.hashColumns.put("n5th_agmt_cre_ofc_cd", getN5thAgmtCreOfcCd());
		this.hashColumns.put("n7th_nod_cd", getN7thNodCd());
		this.hashColumns.put("n6th_vndr_seq", getN6thVndrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inlnd_rout_incl_sttl_flg", getInlndRoutInclSttlFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("tot_tt", getTotTt());
		this.hashColumns.put("n6th_vndr_nm", getN6thVndrNm());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("n5th_vndr_nm", getN5thVndrNm());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("n3rd_vndr_seq", getN3rdVndrSeq());
		this.hashColumns.put("n2nd_agmt_ref_no", getN2ndAgmtRefNo());
		this.hashColumns.put("n5th_agmt_ref_no", getN5thAgmtRefNo());
		this.hashColumns.put("n3rd_vndr_nm", getN3rdVndrNm());
		this.hashColumns.put("dest_loc_type", getDestLocType());
		this.hashColumns.put("n6th_agmt_no", getN6thAgmtNo());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("n2nd_agmt_no", getN2ndAgmtNo());
		this.hashColumns.put("n4th_agmt_no", getN4thAgmtNo());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("n2nd_agmt_cre_ofc_cd", getN2ndAgmtCreOfcCd());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("inlnd_rout_optm_flg", getInlndRoutOptmFlg());
		this.hashColumns.put("altn_optm_flg", getAltnOptmFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_agmt_no", "n1stAgmtNo");
		this.hashFields.put("cnst_rmk", "cnstRmk");
		this.hashFields.put("n4th_vndr_seq", "n4thVndrSeq");
		this.hashFields.put("n5th_nod_cd", "n5thNodCd");
		this.hashFields.put("n6th_trsp_mod_cd", "n6thTrspModCd");
		this.hashFields.put("sum_dw_tt", "sumDwTt");
		this.hashFields.put("n2nd_trsp_mod_cd", "n2ndTrspModCd");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n1st_agmt_ref_no", "n1stAgmtRefNo");
		this.hashFields.put("n5th_agmt_no", "n5thAgmtNo");
		this.hashFields.put("inlnd_rout_tmp_flg", "inlndRoutTmpFlg");
		this.hashFields.put("n1st_trsp_mod_cd", "n1stTrspModCd");
		this.hashFields.put("n3rd_agmt_cre_ofc_cd", "n3rdAgmtCreOfcCd");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("n3rd_trsp_mod_cd", "n3rdTrspModCd");
		this.hashFields.put("n6th_agmt_ref_no", "n6thAgmtRefNo");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("front_gb", "frontGb");
		this.hashFields.put("cnst_flg", "cnstFlg");
		this.hashFields.put("n4th_vndr_nm", "n4thVndrNm");
		this.hashFields.put("n6th_nod_cd", "n6thNodCd");
		this.hashFields.put("i_dest_cd", "iDestCd");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("group_gubun", "groupGubun");
		this.hashFields.put("sum_tt_time", "sumTtTime");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("n4th_agmt_cre_ofc_cd", "n4thAgmtCreOfcCd");
		this.hashFields.put("n5th_vndr_seq", "n5thVndrSeq");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("n6th_agmt_cre_ofc_cd", "n6thAgmtCreOfcCd");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("r_inbound", "rInbound");
		this.hashFields.put("n4th_agmt_ref_no", "n4thAgmtRefNo");
		this.hashFields.put("org_loc_type", "orgLocType");
		this.hashFields.put("undefine_nod", "undefineNod");
		this.hashFields.put("inlnd_rout_bkg_flg", "inlndRoutBkgFlg");
		this.hashFields.put("n3rd_agmt_no", "n3rdAgmtNo");
		this.hashFields.put("n1st_agmt_cre_ofc_cd", "n1stAgmtCreOfcCd");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
		this.hashFields.put("n3rd_agmt_ref_no", "n3rdAgmtRefNo");
		this.hashFields.put("n4th_trsp_mod_cd", "n4thTrspModCd");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("i_org_cd", "iOrgCd");
		this.hashFields.put("hub_search_gb", "hubSearchGb");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n5th_trsp_mod_cd", "n5thTrspModCd");
		this.hashFields.put("n5th_agmt_cre_ofc_cd", "n5thAgmtCreOfcCd");
		this.hashFields.put("n7th_nod_cd", "n7thNodCd");
		this.hashFields.put("n6th_vndr_seq", "n6thVndrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inlnd_rout_incl_sttl_flg", "inlndRoutInclSttlFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("tot_tt", "totTt");
		this.hashFields.put("n6th_vndr_nm", "n6thVndrNm");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("n5th_vndr_nm", "n5thVndrNm");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("n3rd_vndr_seq", "n3rdVndrSeq");
		this.hashFields.put("n2nd_agmt_ref_no", "n2ndAgmtRefNo");
		this.hashFields.put("n5th_agmt_ref_no", "n5thAgmtRefNo");
		this.hashFields.put("n3rd_vndr_nm", "n3rdVndrNm");
		this.hashFields.put("dest_loc_type", "destLocType");
		this.hashFields.put("n6th_agmt_no", "n6thAgmtNo");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("n2nd_agmt_no", "n2ndAgmtNo");
		this.hashFields.put("n4th_agmt_no", "n4thAgmtNo");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("route", "route");
		this.hashFields.put("n2nd_agmt_cre_ofc_cd", "n2ndAgmtCreOfcCd");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("inlnd_rout_optm_flg", "inlndRoutOptmFlg");
		this.hashFields.put("altn_optm_flg", "altnOptmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stAgmtNo
	 */
	public String getN1stAgmtNo() {
		return this.n1stAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return cnstRmk
	 */
	public String getCnstRmk() {
		return this.cnstRmk;
	}
	
	/**
	 * Column Info
	 * @return n4thVndrSeq
	 */
	public String getN4thVndrSeq() {
		return this.n4thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return n5thNodCd
	 */
	public String getN5thNodCd() {
		return this.n5thNodCd;
	}
	
	/**
	 * Column Info
	 * @return n6thTrspModCd
	 */
	public String getN6thTrspModCd() {
		return this.n6thTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return sumDwTt
	 */
	public String getSumDwTt() {
		return this.sumDwTt;
	}
	
	/**
	 * Column Info
	 * @return n2ndTrspModCd
	 */
	public String getN2ndTrspModCd() {
		return this.n2ndTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return n1stAgmtRefNo
	 */
	public String getN1stAgmtRefNo() {
		return this.n1stAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return n5thAgmtNo
	 */
	public String getN5thAgmtNo() {
		return this.n5thAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutTmpFlg
	 */
	public String getInlndRoutTmpFlg() {
		return this.inlndRoutTmpFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stTrspModCd
	 */
	public String getN1stTrspModCd() {
		return this.n1stTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdAgmtCreOfcCd
	 */
	public String getN3rdAgmtCreOfcCd() {
		return this.n3rdAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgLoc
	 */
	public String getOrgLoc() {
		return this.orgLoc;
	}
	
	/**
	 * Column Info
	 * @return n3rdTrspModCd
	 */
	public String getN3rdTrspModCd() {
		return this.n3rdTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return n6thAgmtRefNo
	 */
	public String getN6thAgmtRefNo() {
		return this.n6thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndVndrSeq
	 */
	public String getN2ndVndrSeq() {
		return this.n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return frontGb
	 */
	public String getFrontGb() {
		return this.frontGb;
	}
	
	/**
	 * Column Info
	 * @return cnstFlg
	 */
	public String getCnstFlg() {
		return this.cnstFlg;
	}
	
	/**
	 * Column Info
	 * @return n4thVndrNm
	 */
	public String getN4thVndrNm() {
		return this.n4thVndrNm;
	}
	
	/**
	 * Column Info
	 * @return n6thNodCd
	 */
	public String getN6thNodCd() {
		return this.n6thNodCd;
	}
	
	/**
	 * Column Info
	 * @return iDestCd
	 */
	public String getIDestCd() {
		return this.iDestCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return groupGubun
	 */
	public String getGroupGubun() {
		return this.groupGubun;
	}
	
	/**
	 * Column Info
	 * @return sumTtTime
	 */
	public String getSumTtTime() {
		return this.sumTtTime;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return n4thAgmtCreOfcCd
	 */
	public String getN4thAgmtCreOfcCd() {
		return this.n4thAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n5thVndrSeq
	 */
	public String getN5thVndrSeq() {
		return this.n5thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return n4thNodCd
	 */
	public String getN4thNodCd() {
		return this.n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @return n6thAgmtCreOfcCd
	 */
	public String getN6thAgmtCreOfcCd() {
		return this.n6thAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @return rInbound
	 */
	public String getRInbound() {
		return this.rInbound;
	}
	
	/**
	 * Column Info
	 * @return n4thAgmtRefNo
	 */
	public String getN4thAgmtRefNo() {
		return this.n4thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return orgLocType
	 */
	public String getOrgLocType() {
		return this.orgLocType;
	}
	
	/**
	 * Column Info
	 * @return undefineNod
	 */
	public String getUndefineNod() {
		return this.undefineNod;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutBkgFlg
	 */
	public String getInlndRoutBkgFlg() {
		return this.inlndRoutBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return n3rdAgmtNo
	 */
	public String getN3rdAgmtNo() {
		return this.n3rdAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return n1stAgmtCreOfcCd
	 */
	public String getN1stAgmtCreOfcCd() {
		return this.n1stAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdNodCd
	 */
	public String getN3rdNodCd() {
		return this.n3rdNodCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdAgmtRefNo
	 */
	public String getN3rdAgmtRefNo() {
		return this.n3rdAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return n4thTrspModCd
	 */
	public String getN4thTrspModCd() {
		return this.n4thTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return iOrgCd
	 */
	public String getIOrgCd() {
		return this.iOrgCd;
	}
	
	/**
	 * Column Info
	 * @return hubSearchGb
	 */
	public String getHubSearchGb() {
		return this.hubSearchGb;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n5thTrspModCd
	 */
	public String getN5thTrspModCd() {
		return this.n5thTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return n5thAgmtCreOfcCd
	 */
	public String getN5thAgmtCreOfcCd() {
		return this.n5thAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n7thNodCd
	 */
	public String getN7thNodCd() {
		return this.n7thNodCd;
	}
	
	/**
	 * Column Info
	 * @return n6thVndrSeq
	 */
	public String getN6thVndrSeq() {
		return this.n6thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutInclSttlFlg
	 */
	public String getInlndRoutInclSttlFlg() {
		return this.inlndRoutInclSttlFlg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVndrSeq
	 */
	public String getN1stVndrSeq() {
		return this.n1stVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return totTt
	 */
	public String getTotTt() {
		return this.totTt;
	}
	
	/**
	 * Column Info
	 * @return n6thVndrNm
	 */
	public String getN6thVndrNm() {
		return this.n6thVndrNm;
	}
	
	/**
	 * Column Info
	 * @return n1stVndrNm
	 */
	public String getN1stVndrNm() {
		return this.n1stVndrNm;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return n5thVndrNm
	 */
	public String getN5thVndrNm() {
		return this.n5thVndrNm;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdVndrSeq
	 */
	public String getN3rdVndrSeq() {
		return this.n3rdVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndAgmtRefNo
	 */
	public String getN2ndAgmtRefNo() {
		return this.n2ndAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return n5thAgmtRefNo
	 */
	public String getN5thAgmtRefNo() {
		return this.n5thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdVndrNm
	 */
	public String getN3rdVndrNm() {
		return this.n3rdVndrNm;
	}
	
	/**
	 * Column Info
	 * @return destLocType
	 */
	public String getDestLocType() {
		return this.destLocType;
	}
	
	/**
	 * Column Info
	 * @return n6thAgmtNo
	 */
	public String getN6thAgmtNo() {
		return this.n6thAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}
	
	/**
	 * Column Info
	 * @return n2ndAgmtNo
	 */
	public String getN2ndAgmtNo() {
		return this.n2ndAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return n4thAgmtNo
	 */
	public String getN4thAgmtNo() {
		return this.n4thAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return route
	 */
	public String getRoute() {
		return this.route;
	}
	
	/**
	 * Column Info
	 * @return n2ndAgmtCreOfcCd
	 */
	public String getN2ndAgmtCreOfcCd() {
		return this.n2ndAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutOptmFlg
	 */
	public String getInlndRoutOptmFlg() {
		return this.inlndRoutOptmFlg;
	}
	
	/**
	 * Column Info
	 * @return n2ndVndrNm
	 */
	public String getN2ndVndrNm() {
		return this.n2ndVndrNm;
	}

	public String getAltnOptmFlg() {
		return altnOptmFlg;
	}

	public void setAltnOptmFlg(String altnOptmFlg) {
		this.altnOptmFlg = altnOptmFlg;
	}

	/**
	 * Column Info
	 * @param n1stAgmtNo
	 */
	public void setN1stAgmtNo(String n1stAgmtNo) {
		this.n1stAgmtNo = n1stAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param cnstRmk
	 */
	public void setCnstRmk(String cnstRmk) {
		this.cnstRmk = cnstRmk;
	}
	
	/**
	 * Column Info
	 * @param n4thVndrSeq
	 */
	public void setN4thVndrSeq(String n4thVndrSeq) {
		this.n4thVndrSeq = n4thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param n5thNodCd
	 */
	public void setN5thNodCd(String n5thNodCd) {
		this.n5thNodCd = n5thNodCd;
	}
	
	/**
	 * Column Info
	 * @param n6thTrspModCd
	 */
	public void setN6thTrspModCd(String n6thTrspModCd) {
		this.n6thTrspModCd = n6thTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param sumDwTt
	 */
	public void setSumDwTt(String sumDwTt) {
		this.sumDwTt = sumDwTt;
	}
	
	/**
	 * Column Info
	 * @param n2ndTrspModCd
	 */
	public void setN2ndTrspModCd(String n2ndTrspModCd) {
		this.n2ndTrspModCd = n2ndTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param n1stAgmtRefNo
	 */
	public void setN1stAgmtRefNo(String n1stAgmtRefNo) {
		this.n1stAgmtRefNo = n1stAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param n5thAgmtNo
	 */
	public void setN5thAgmtNo(String n5thAgmtNo) {
		this.n5thAgmtNo = n5thAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutTmpFlg
	 */
	public void setInlndRoutTmpFlg(String inlndRoutTmpFlg) {
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stTrspModCd
	 */
	public void setN1stTrspModCd(String n1stTrspModCd) {
		this.n1stTrspModCd = n1stTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdAgmtCreOfcCd
	 */
	public void setN3rdAgmtCreOfcCd(String n3rdAgmtCreOfcCd) {
		this.n3rdAgmtCreOfcCd = n3rdAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgLoc
	 */
	public void setOrgLoc(String orgLoc) {
		this.orgLoc = orgLoc;
	}
	
	/**
	 * Column Info
	 * @param n3rdTrspModCd
	 */
	public void setN3rdTrspModCd(String n3rdTrspModCd) {
		this.n3rdTrspModCd = n3rdTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param n6thAgmtRefNo
	 */
	public void setN6thAgmtRefNo(String n6thAgmtRefNo) {
		this.n6thAgmtRefNo = n6thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndVndrSeq
	 */
	public void setN2ndVndrSeq(String n2ndVndrSeq) {
		this.n2ndVndrSeq = n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param frontGb
	 */
	public void setFrontGb(String frontGb) {
		this.frontGb = frontGb;
	}
	
	/**
	 * Column Info
	 * @param cnstFlg
	 */
	public void setCnstFlg(String cnstFlg) {
		this.cnstFlg = cnstFlg;
	}
	
	/**
	 * Column Info
	 * @param n4thVndrNm
	 */
	public void setN4thVndrNm(String n4thVndrNm) {
		this.n4thVndrNm = n4thVndrNm;
	}
	
	/**
	 * Column Info
	 * @param n6thNodCd
	 */
	public void setN6thNodCd(String n6thNodCd) {
		this.n6thNodCd = n6thNodCd;
	}
	
	/**
	 * Column Info
	 * @param iDestCd
	 */
	public void setIDestCd(String iDestCd) {
		this.iDestCd = iDestCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param groupGubun
	 */
	public void setGroupGubun(String groupGubun) {
		this.groupGubun = groupGubun;
	}
	
	/**
	 * Column Info
	 * @param sumTtTime
	 */
	public void setSumTtTime(String sumTtTime) {
		this.sumTtTime = sumTtTime;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param n4thAgmtCreOfcCd
	 */
	public void setN4thAgmtCreOfcCd(String n4thAgmtCreOfcCd) {
		this.n4thAgmtCreOfcCd = n4thAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n5thVndrSeq
	 */
	public void setN5thVndrSeq(String n5thVndrSeq) {
		this.n5thVndrSeq = n5thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param n4thNodCd
	 */
	public void setN4thNodCd(String n4thNodCd) {
		this.n4thNodCd = n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @param n6thAgmtCreOfcCd
	 */
	public void setN6thAgmtCreOfcCd(String n6thAgmtCreOfcCd) {
		this.n6thAgmtCreOfcCd = n6thAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @param rInbound
	 */
	public void setRInbound(String rInbound) {
		this.rInbound = rInbound;
	}
	
	/**
	 * Column Info
	 * @param n4thAgmtRefNo
	 */
	public void setN4thAgmtRefNo(String n4thAgmtRefNo) {
		this.n4thAgmtRefNo = n4thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param orgLocType
	 */
	public void setOrgLocType(String orgLocType) {
		this.orgLocType = orgLocType;
	}
	
	/**
	 * Column Info
	 * @param undefineNod
	 */
	public void setUndefineNod(String undefineNod) {
		this.undefineNod = undefineNod;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutBkgFlg
	 */
	public void setInlndRoutBkgFlg(String inlndRoutBkgFlg) {
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param n3rdAgmtNo
	 */
	public void setN3rdAgmtNo(String n3rdAgmtNo) {
		this.n3rdAgmtNo = n3rdAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param n1stAgmtCreOfcCd
	 */
	public void setN1stAgmtCreOfcCd(String n1stAgmtCreOfcCd) {
		this.n1stAgmtCreOfcCd = n1stAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdNodCd
	 */
	public void setN3rdNodCd(String n3rdNodCd) {
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdAgmtRefNo
	 */
	public void setN3rdAgmtRefNo(String n3rdAgmtRefNo) {
		this.n3rdAgmtRefNo = n3rdAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param n4thTrspModCd
	 */
	public void setN4thTrspModCd(String n4thTrspModCd) {
		this.n4thTrspModCd = n4thTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param iOrgCd
	 */
	public void setIOrgCd(String iOrgCd) {
		this.iOrgCd = iOrgCd;
	}
	
	/**
	 * Column Info
	 * @param hubSearchGb
	 */
	public void setHubSearchGb(String hubSearchGb) {
		this.hubSearchGb = hubSearchGb;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param n5thTrspModCd
	 */
	public void setN5thTrspModCd(String n5thTrspModCd) {
		this.n5thTrspModCd = n5thTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param n5thAgmtCreOfcCd
	 */
	public void setN5thAgmtCreOfcCd(String n5thAgmtCreOfcCd) {
		this.n5thAgmtCreOfcCd = n5thAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n7thNodCd
	 */
	public void setN7thNodCd(String n7thNodCd) {
		this.n7thNodCd = n7thNodCd;
	}
	
	/**
	 * Column Info
	 * @param n6thVndrSeq
	 */
	public void setN6thVndrSeq(String n6thVndrSeq) {
		this.n6thVndrSeq = n6thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutInclSttlFlg
	 */
	public void setInlndRoutInclSttlFlg(String inlndRoutInclSttlFlg) {
		this.inlndRoutInclSttlFlg = inlndRoutInclSttlFlg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVndrSeq
	 */
	public void setN1stVndrSeq(String n1stVndrSeq) {
		this.n1stVndrSeq = n1stVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param totTt
	 */
	public void setTotTt(String totTt) {
		this.totTt = totTt;
	}
	
	/**
	 * Column Info
	 * @param n6thVndrNm
	 */
	public void setN6thVndrNm(String n6thVndrNm) {
		this.n6thVndrNm = n6thVndrNm;
	}
	
	/**
	 * Column Info
	 * @param n1stVndrNm
	 */
	public void setN1stVndrNm(String n1stVndrNm) {
		this.n1stVndrNm = n1stVndrNm;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param n5thVndrNm
	 */
	public void setN5thVndrNm(String n5thVndrNm) {
		this.n5thVndrNm = n5thVndrNm;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdVndrSeq
	 */
	public void setN3rdVndrSeq(String n3rdVndrSeq) {
		this.n3rdVndrSeq = n3rdVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndAgmtRefNo
	 */
	public void setN2ndAgmtRefNo(String n2ndAgmtRefNo) {
		this.n2ndAgmtRefNo = n2ndAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param n5thAgmtRefNo
	 */
	public void setN5thAgmtRefNo(String n5thAgmtRefNo) {
		this.n5thAgmtRefNo = n5thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdVndrNm
	 */
	public void setN3rdVndrNm(String n3rdVndrNm) {
		this.n3rdVndrNm = n3rdVndrNm;
	}
	
	/**
	 * Column Info
	 * @param destLocType
	 */
	public void setDestLocType(String destLocType) {
		this.destLocType = destLocType;
	}
	
	/**
	 * Column Info
	 * @param n6thAgmtNo
	 */
	public void setN6thAgmtNo(String n6thAgmtNo) {
		this.n6thAgmtNo = n6thAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	
	/**
	 * Column Info
	 * @param n2ndAgmtNo
	 */
	public void setN2ndAgmtNo(String n2ndAgmtNo) {
		this.n2ndAgmtNo = n2ndAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param n4thAgmtNo
	 */
	public void setN4thAgmtNo(String n4thAgmtNo) {
		this.n4thAgmtNo = n4thAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param route
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	
	/**
	 * Column Info
	 * @param n2ndAgmtCreOfcCd
	 */
	public void setN2ndAgmtCreOfcCd(String n2ndAgmtCreOfcCd) {
		this.n2ndAgmtCreOfcCd = n2ndAgmtCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndVndrNm
	 */
	public void setN2ndVndrNm(String n2ndVndrNm) {
		this.n2ndVndrNm = n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutOptmFlg
	 */
	public void setInlndRoutOptmFlg(String inlndRoutOptmFlg) {
		this.n2ndVndrNm = inlndRoutOptmFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN1stAgmtNo(JSPUtil.getParameter(request, "n1st_agmt_no", ""));
		setCnstRmk(JSPUtil.getParameter(request, "cnst_rmk", ""));
		setN4thVndrSeq(JSPUtil.getParameter(request, "n4th_vndr_seq", ""));
		setN5thNodCd(JSPUtil.getParameter(request, "n5th_nod_cd", ""));
		setN6thTrspModCd(JSPUtil.getParameter(request, "n6th_trsp_mod_cd", ""));
		setSumDwTt(JSPUtil.getParameter(request, "sum_dw_tt", ""));
		setN2ndTrspModCd(JSPUtil.getParameter(request, "n2nd_trsp_mod_cd", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN1stAgmtRefNo(JSPUtil.getParameter(request, "n1st_agmt_ref_no", ""));
		setN5thAgmtNo(JSPUtil.getParameter(request, "n5th_agmt_no", ""));
		setInlndRoutTmpFlg(JSPUtil.getParameter(request, "inlnd_rout_tmp_flg", ""));
		setN1stTrspModCd(JSPUtil.getParameter(request, "n1st_trsp_mod_cd", ""));
		setN3rdAgmtCreOfcCd(JSPUtil.getParameter(request, "n3rd_agmt_cre_ofc_cd", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setN3rdTrspModCd(JSPUtil.getParameter(request, "n3rd_trsp_mod_cd", ""));
		setN6thAgmtRefNo(JSPUtil.getParameter(request, "n6th_agmt_ref_no", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, "n2nd_vndr_seq", ""));
		setFrontGb(JSPUtil.getParameter(request, "front_gb", ""));
		setCnstFlg(JSPUtil.getParameter(request, "cnst_flg", ""));
		setN4thVndrNm(JSPUtil.getParameter(request, "n4th_vndr_nm", ""));
		setN6thNodCd(JSPUtil.getParameter(request, "n6th_nod_cd", ""));
		setIDestCd(JSPUtil.getParameter(request, "i_dest_cd", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setGroupGubun(JSPUtil.getParameter(request, "group_gubun", ""));
		setSumTtTime(JSPUtil.getParameter(request, "sum_tt_time", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setN4thAgmtCreOfcCd(JSPUtil.getParameter(request, "n4th_agmt_cre_ofc_cd", ""));
		setN5thVndrSeq(JSPUtil.getParameter(request, "n5th_vndr_seq", ""));
		setN4thNodCd(JSPUtil.getParameter(request, "n4th_nod_cd", ""));
		setN6thAgmtCreOfcCd(JSPUtil.getParameter(request, "n6th_agmt_cre_ofc_cd", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setRInbound(JSPUtil.getParameter(request, "r_inbound", ""));
		setN4thAgmtRefNo(JSPUtil.getParameter(request, "n4th_agmt_ref_no", ""));
		setOrgLocType(JSPUtil.getParameter(request, "org_loc_type", ""));
		setUndefineNod(JSPUtil.getParameter(request, "undefine_nod", ""));
		setInlndRoutBkgFlg(JSPUtil.getParameter(request, "inlnd_rout_bkg_flg", ""));
		setN3rdAgmtNo(JSPUtil.getParameter(request, "n3rd_agmt_no", ""));
		setN1stAgmtCreOfcCd(JSPUtil.getParameter(request, "n1st_agmt_cre_ofc_cd", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, "n3rd_nod_cd", ""));
		setN3rdAgmtRefNo(JSPUtil.getParameter(request, "n3rd_agmt_ref_no", ""));
		setN4thTrspModCd(JSPUtil.getParameter(request, "n4th_trsp_mod_cd", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setIOrgCd(JSPUtil.getParameter(request, "i_org_cd", ""));
		setHubSearchGb(JSPUtil.getParameter(request, "hub_search_gb", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN5thTrspModCd(JSPUtil.getParameter(request, "n5th_trsp_mod_cd", ""));
		setN5thAgmtCreOfcCd(JSPUtil.getParameter(request, "n5th_agmt_cre_ofc_cd", ""));
		setN7thNodCd(JSPUtil.getParameter(request, "n7th_nod_cd", ""));
		setN6thVndrSeq(JSPUtil.getParameter(request, "n6th_vndr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInlndRoutInclSttlFlg(JSPUtil.getParameter(request, "inlnd_rout_incl_sttl_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, "n1st_vndr_seq", ""));
		setTotTt(JSPUtil.getParameter(request, "tot_tt", ""));
		setN6thVndrNm(JSPUtil.getParameter(request, "n6th_vndr_nm", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, "n1st_vndr_nm", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setN5thVndrNm(JSPUtil.getParameter(request, "n5th_vndr_nm", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, "pctl_io_bnd_cd", ""));
		setN3rdVndrSeq(JSPUtil.getParameter(request, "n3rd_vndr_seq", ""));
		setN2ndAgmtRefNo(JSPUtil.getParameter(request, "n2nd_agmt_ref_no", ""));
		setN5thAgmtRefNo(JSPUtil.getParameter(request, "n5th_agmt_ref_no", ""));
		setN3rdVndrNm(JSPUtil.getParameter(request, "n3rd_vndr_nm", ""));
		setDestLocType(JSPUtil.getParameter(request, "dest_loc_type", ""));
		setN6thAgmtNo(JSPUtil.getParameter(request, "n6th_agmt_no", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setN2ndAgmtNo(JSPUtil.getParameter(request, "n2nd_agmt_no", ""));
		setN4thAgmtNo(JSPUtil.getParameter(request, "n4th_agmt_no", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setN2ndAgmtCreOfcCd(JSPUtil.getParameter(request, "n2nd_agmt_cre_ofc_cd", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, "n2nd_vndr_nm", ""));
		setInlndRoutOptmFlg(JSPUtil.getParameter(request, "inlnd_rout_optm_flg", ""));
		setAltnOptmFlg(JSPUtil.getParameter(request, "altn_optm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandRouteVO[]
	 */
	public InlandRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InlandRouteVO[]
	 */
	public InlandRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stAgmtNo = (JSPUtil.getParameter(request, prefix	+ "n1st_agmt_no", length));
			String[] cnstRmk = (JSPUtil.getParameter(request, prefix	+ "cnst_rmk", length));
			String[] n4thVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_vndr_seq", length));
			String[] n5thNodCd = (JSPUtil.getParameter(request, prefix	+ "n5th_nod_cd", length));
			String[] n6thTrspModCd = (JSPUtil.getParameter(request, prefix	+ "n6th_trsp_mod_cd", length));
			String[] sumDwTt = (JSPUtil.getParameter(request, prefix	+ "sum_dw_tt", length));
			String[] n2ndTrspModCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_trsp_mod_cd", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n1stAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n1st_agmt_ref_no", length));
			String[] n5thAgmtNo = (JSPUtil.getParameter(request, prefix	+ "n5th_agmt_no", length));
			String[] inlndRoutTmpFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_tmp_flg", length));
			String[] n1stTrspModCd = (JSPUtil.getParameter(request, prefix	+ "n1st_trsp_mod_cd", length));
			String[] n3rdAgmtCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_agmt_cre_ofc_cd", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix	+ "org_loc", length));
			String[] n3rdTrspModCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_trsp_mod_cd", length));
			String[] n6thAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n6th_agmt_ref_no", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] frontGb = (JSPUtil.getParameter(request, prefix	+ "front_gb", length));
			String[] cnstFlg = (JSPUtil.getParameter(request, prefix	+ "cnst_flg", length));
			String[] n4thVndrNm = (JSPUtil.getParameter(request, prefix	+ "n4th_vndr_nm", length));
			String[] n6thNodCd = (JSPUtil.getParameter(request, prefix	+ "n6th_nod_cd", length));
			String[] iDestCd = (JSPUtil.getParameter(request, prefix	+ "i_dest_cd", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] groupGubun = (JSPUtil.getParameter(request, prefix	+ "group_gubun", length));
			String[] sumTtTime = (JSPUtil.getParameter(request, prefix	+ "sum_tt_time", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] n4thAgmtCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "n4th_agmt_cre_ofc_cd", length));
			String[] n5thVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_vndr_seq", length));
			String[] n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] n6thAgmtCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "n6th_agmt_cre_ofc_cd", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] rInbound = (JSPUtil.getParameter(request, prefix	+ "r_inbound", length));
			String[] n4thAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n4th_agmt_ref_no", length));
			String[] orgLocType = (JSPUtil.getParameter(request, prefix	+ "org_loc_type", length));
			String[] undefineNod = (JSPUtil.getParameter(request, prefix	+ "undefine_nod", length));
			String[] inlndRoutBkgFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_bkg_flg", length));
			String[] n3rdAgmtNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_agmt_no", length));
			String[] n1stAgmtCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "n1st_agmt_cre_ofc_cd", length));
			String[] n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			String[] n3rdAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_agmt_ref_no", length));
			String[] n4thTrspModCd = (JSPUtil.getParameter(request, prefix	+ "n4th_trsp_mod_cd", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] iOrgCd = (JSPUtil.getParameter(request, prefix	+ "i_org_cd", length));
			String[] hubSearchGb = (JSPUtil.getParameter(request, prefix	+ "hub_search_gb", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n5thTrspModCd = (JSPUtil.getParameter(request, prefix	+ "n5th_trsp_mod_cd", length));
			String[] n5thAgmtCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "n5th_agmt_cre_ofc_cd", length));
			String[] n7thNodCd = (JSPUtil.getParameter(request, prefix	+ "n7th_nod_cd", length));
			String[] n6thVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n6th_vndr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inlndRoutInclSttlFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_incl_sttl_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] totTt = (JSPUtil.getParameter(request, prefix	+ "tot_tt", length));
			String[] n6thVndrNm = (JSPUtil.getParameter(request, prefix	+ "n6th_vndr_nm", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] n5thVndrNm = (JSPUtil.getParameter(request, prefix	+ "n5th_vndr_nm", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] n3rdVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_vndr_seq", length));
			String[] n2ndAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_agmt_ref_no", length));
			String[] n5thAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n5th_agmt_ref_no", length));
			String[] n3rdVndrNm = (JSPUtil.getParameter(request, prefix	+ "n3rd_vndr_nm", length));
			String[] destLocType = (JSPUtil.getParameter(request, prefix	+ "dest_loc_type", length));
			String[] n6thAgmtNo = (JSPUtil.getParameter(request, prefix	+ "n6th_agmt_no", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] n2ndAgmtNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_agmt_no", length));
			String[] n4thAgmtNo = (JSPUtil.getParameter(request, prefix	+ "n4th_agmt_no", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] n2ndAgmtCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_agmt_cre_ofc_cd", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] inlndRoutOptmFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_optm_flg", length));
			String[] altnOptmFlg = (JSPUtil.getParameter(request, prefix	+ "altn_optm_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InlandRouteVO();
				if (n1stAgmtNo[i] != null)
					model.setN1stAgmtNo(n1stAgmtNo[i]);
				if (cnstRmk[i] != null)
					model.setCnstRmk(cnstRmk[i]);
				if (n4thVndrSeq[i] != null)
					model.setN4thVndrSeq(n4thVndrSeq[i]);
				if (n5thNodCd[i] != null)
					model.setN5thNodCd(n5thNodCd[i]);
				if (n6thTrspModCd[i] != null)
					model.setN6thTrspModCd(n6thTrspModCd[i]);
				if (sumDwTt[i] != null)
					model.setSumDwTt(sumDwTt[i]);
				if (n2ndTrspModCd[i] != null)
					model.setN2ndTrspModCd(n2ndTrspModCd[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n1stAgmtRefNo[i] != null)
					model.setN1stAgmtRefNo(n1stAgmtRefNo[i]);
				if (n5thAgmtNo[i] != null)
					model.setN5thAgmtNo(n5thAgmtNo[i]);
				if (inlndRoutTmpFlg[i] != null)
					model.setInlndRoutTmpFlg(inlndRoutTmpFlg[i]);
				if (n1stTrspModCd[i] != null)
					model.setN1stTrspModCd(n1stTrspModCd[i]);
				if (n3rdAgmtCreOfcCd[i] != null)
					model.setN3rdAgmtCreOfcCd(n3rdAgmtCreOfcCd[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (n3rdTrspModCd[i] != null)
					model.setN3rdTrspModCd(n3rdTrspModCd[i]);
				if (n6thAgmtRefNo[i] != null)
					model.setN6thAgmtRefNo(n6thAgmtRefNo[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (frontGb[i] != null)
					model.setFrontGb(frontGb[i]);
				if (cnstFlg[i] != null)
					model.setCnstFlg(cnstFlg[i]);
				if (n4thVndrNm[i] != null)
					model.setN4thVndrNm(n4thVndrNm[i]);
				if (n6thNodCd[i] != null)
					model.setN6thNodCd(n6thNodCd[i]);
				if (iDestCd[i] != null)
					model.setIDestCd(iDestCd[i]);
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (groupGubun[i] != null)
					model.setGroupGubun(groupGubun[i]);
				if (sumTtTime[i] != null)
					model.setSumTtTime(sumTtTime[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (n4thAgmtCreOfcCd[i] != null)
					model.setN4thAgmtCreOfcCd(n4thAgmtCreOfcCd[i]);
				if (n5thVndrSeq[i] != null)
					model.setN5thVndrSeq(n5thVndrSeq[i]);
				if (n4thNodCd[i] != null)
					model.setN4thNodCd(n4thNodCd[i]);
				if (n6thAgmtCreOfcCd[i] != null)
					model.setN6thAgmtCreOfcCd(n6thAgmtCreOfcCd[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (rInbound[i] != null)
					model.setRInbound(rInbound[i]);
				if (n4thAgmtRefNo[i] != null)
					model.setN4thAgmtRefNo(n4thAgmtRefNo[i]);
				if (orgLocType[i] != null)
					model.setOrgLocType(orgLocType[i]);
				if (undefineNod[i] != null)
					model.setUndefineNod(undefineNod[i]);
				if (inlndRoutBkgFlg[i] != null)
					model.setInlndRoutBkgFlg(inlndRoutBkgFlg[i]);
				if (n3rdAgmtNo[i] != null)
					model.setN3rdAgmtNo(n3rdAgmtNo[i]);
				if (n1stAgmtCreOfcCd[i] != null)
					model.setN1stAgmtCreOfcCd(n1stAgmtCreOfcCd[i]);
				if (n3rdNodCd[i] != null)
					model.setN3rdNodCd(n3rdNodCd[i]);
				if (n3rdAgmtRefNo[i] != null)
					model.setN3rdAgmtRefNo(n3rdAgmtRefNo[i]);
				if (n4thTrspModCd[i] != null)
					model.setN4thTrspModCd(n4thTrspModCd[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (iOrgCd[i] != null)
					model.setIOrgCd(iOrgCd[i]);
				if (hubSearchGb[i] != null)
					model.setHubSearchGb(hubSearchGb[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n5thTrspModCd[i] != null)
					model.setN5thTrspModCd(n5thTrspModCd[i]);
				if (n5thAgmtCreOfcCd[i] != null)
					model.setN5thAgmtCreOfcCd(n5thAgmtCreOfcCd[i]);
				if (n7thNodCd[i] != null)
					model.setN7thNodCd(n7thNodCd[i]);
				if (n6thVndrSeq[i] != null)
					model.setN6thVndrSeq(n6thVndrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inlndRoutInclSttlFlg[i] != null)
					model.setInlndRoutInclSttlFlg(inlndRoutInclSttlFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (totTt[i] != null)
					model.setTotTt(totTt[i]);
				if (n6thVndrNm[i] != null)
					model.setN6thVndrNm(n6thVndrNm[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (n5thVndrNm[i] != null)
					model.setN5thVndrNm(n5thVndrNm[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (n3rdVndrSeq[i] != null)
					model.setN3rdVndrSeq(n3rdVndrSeq[i]);
				if (n2ndAgmtRefNo[i] != null)
					model.setN2ndAgmtRefNo(n2ndAgmtRefNo[i]);
				if (n5thAgmtRefNo[i] != null)
					model.setN5thAgmtRefNo(n5thAgmtRefNo[i]);
				if (n3rdVndrNm[i] != null)
					model.setN3rdVndrNm(n3rdVndrNm[i]);
				if (destLocType[i] != null)
					model.setDestLocType(destLocType[i]);
				if (n6thAgmtNo[i] != null)
					model.setN6thAgmtNo(n6thAgmtNo[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (n2ndAgmtNo[i] != null)
					model.setN2ndAgmtNo(n2ndAgmtNo[i]);
				if (n4thAgmtNo[i] != null)
					model.setN4thAgmtNo(n4thAgmtNo[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (n2ndAgmtCreOfcCd[i] != null)
					model.setN2ndAgmtCreOfcCd(n2ndAgmtCreOfcCd[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (inlndRoutOptmFlg[i] != null)
					model.setInlndRoutOptmFlg(inlndRoutOptmFlg[i]);
				if (altnOptmFlg[i] != null)
					model.setAltnOptmFlg(altnOptmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandRouteVO[]
	 */
	public InlandRouteVO[] getInlandRouteVOs(){
		InlandRouteVO[] vos = (InlandRouteVO[])models.toArray(new InlandRouteVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.n1stAgmtNo = this.n1stAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstRmk = this.cnstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVndrSeq = this.n4thVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thNodCd = this.n5thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thTrspModCd = this.n6thTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumDwTt = this.sumDwTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTrspModCd = this.n2ndTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAgmtRefNo = this.n1stAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thAgmtNo = this.n5thAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutTmpFlg = this.inlndRoutTmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTrspModCd = this.n1stTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAgmtCreOfcCd = this.n3rdAgmtCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTrspModCd = this.n3rdTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thAgmtRefNo = this.n6thAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frontGb = this.frontGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstFlg = this.cnstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVndrNm = this.n4thVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thNodCd = this.n6thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDestCd = this.iDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupGubun = this.groupGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtTime = this.sumTtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thAgmtCreOfcCd = this.n4thAgmtCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thVndrSeq = this.n5thVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thAgmtCreOfcCd = this.n6thAgmtCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rInbound = this.rInbound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thAgmtRefNo = this.n4thAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocType = this.orgLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undefineNod = this.undefineNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutBkgFlg = this.inlndRoutBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAgmtNo = this.n3rdAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAgmtCreOfcCd = this.n1stAgmtCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAgmtRefNo = this.n3rdAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thTrspModCd = this.n4thTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOrgCd = this.iOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubSearchGb = this.hubSearchGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thTrspModCd = this.n5thTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thAgmtCreOfcCd = this.n5thAgmtCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n7thNodCd = this.n7thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thVndrSeq = this.n6thVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInclSttlFlg = this.inlndRoutInclSttlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTt = this.totTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thVndrNm = this.n6thVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thVndrNm = this.n5thVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVndrSeq = this.n3rdVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAgmtRefNo = this.n2ndAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thAgmtRefNo = this.n5thAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVndrNm = this.n3rdVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocType = this.destLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thAgmtNo = this.n6thAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAgmtNo = this.n2ndAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thAgmtNo = this.n4thAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAgmtCreOfcCd = this.n2ndAgmtCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutOptmFlg = this.inlndRoutOptmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.altnOptmFlg = this.altnOptmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
