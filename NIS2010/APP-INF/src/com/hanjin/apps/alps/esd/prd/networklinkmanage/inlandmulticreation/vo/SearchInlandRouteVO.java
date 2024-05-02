/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchInlandRouteVO.java
*@FileTitle : SearchInlandRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInlandRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInlandRouteVO> models = new ArrayList<SearchInlandRouteVO>();
	
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n1stAgmtRefNo = null;
	/* Column Info */
	private String juncNm1 = null;
	/* Column Info */
	private String n3rdTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String juncNm2 = null;
	/* Column Info */
	private String juncNm3 = null;
	/* Column Info */
	private String juncNm4 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String juncNm5 = null;
	/* Column Info */
	private String juncNm6 = null;
	/* Column Info */
	private String agmtNo5 = null;
	/* Column Info */
	private String agmtNo4 = null;
	/* Column Info */
	private String agmtNo3 = null;
	/* Column Info */
	private String agmtNo2 = null;
	/* Column Info */
	private String agmtNo1 = null;
	/* Column Info */
	private String comFlg6 = null;
	/* Column Info */
	private String comFlg5 = null;
	/* Column Info */
	private String comFlg4 = null;
	/* Column Info */
	private String comFlg3 = null;
	/* Column Info */
	private String comFlg2 = null;
	/* Column Info */
	private String comFlg1 = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String agmtNo6 = null;
	/* Column Info */
	private String fmtTztmHrs1 = null;
	/* Column Info */
	private String ioType = null;
	/* Column Info */
	private String fmtTztmHrs2 = null;
	/* Column Info */
	private String fmtTztmHrs3 = null;
	/* Column Info */
	private String fmtTztmHrs4 = null;
	/* Column Info */
	private String fmtTztmHrs5 = null;
	/* Column Info */
	private String inlndRoutBkgFlg = null;
	/* Column Info */
	private String n3rdAgmtRefNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String orgNode = null;
	/* Column Info */
	private String n1stNode = null;
	/* Column Info */
	private String tm2 = null;
	/* Column Info */
	private String tm1 = null;
	/* Column Info */
	private String tm4 = null;
	/* Column Info */
	private String tm3 = null;
	/* Column Info */
	private String tm6 = null;
	/* Column Info */
	private String tm5 = null;
	/* Column Info */
	private String inlndRoutInclSttlFlg = null;
	/* Column Info */
	private String n5thTrspAgmtSeq = null;
	/* Column Info */
	private String nodeType = null;
	/* Column Info */
	private String n3rdNode = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Column Info */
	private String n5thAgmtRefNo = null;
	/* Column Info */
	private String n3rdTrspAgmtSeq = null;
	/* Column Info */
	private String wrsFullCmdt = null;
	/* Column Info */
	private String inlndRoutInvBilPattCd = null;
	/* Column Info */
	private String rdCrrTp3 = null;
	/* Column Info */
	private String rdCrrTp4 = null;
	/* Column Info */
	private String rdCrrTp1 = null;
	/* Column Info */
	private String rdCrrTp2 = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String rdCrrTp5 = null;
	/* Column Info */
	private String rdCrrTp6 = null;
	/* Column Info */
	private String n1stTrspAgmtSeq = null;
	/* Column Info */
	private String vndr1 = null;
	/* Column Info */
	private String vndr3 = null;
	/* Column Info */
	private String vndr2 = null;
	/* Column Info */
	private String vndr5 = null;
	/* Column Info */
	private String vndr4 = null;
	/* Column Info */
	private String vndr6 = null;
	/* Column Info */
	private String inlndRoutTmpFlg = null;
	/* Column Info */
	private String n4thTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String n2ndNode = null;
	/* Column Info */
	private String n5thTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String sumTtTime = null;
	/* Column Info */
	private String inlndRoutRmk6 = null;
	/* Column Info */
	private String inlndRoutRmk5 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String inlndRoutRmk4 = null;
	/* Column Info */
	private String inlndRoutRmk3 = null;
	/* Column Info */
	private String inlndRoutRmk2 = null;
	/* Column Info */
	private String inlndRoutRmk1 = null;
	/* Column Info */
	private String n4thAgmtRefNo = null;
	/* Column Info */
	private String n5thNode = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String wrsMtyCmdtCd = null;
	/* Column Info */
	private String n4thNode = null;
	/* Column Info */
	private String n4thTrspAgmtSeq = null;
	/* Column Info */
	private String agmtRefNo1 = null;
	/* Column Info */
	private String agmtRefNo2 = null;
	/* Column Info */
	private String spName1 = null;
	/* Column Info */
	private String spName2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spName3 = null;
	/* Column Info */
	private String spName4 = null;
	/* Column Info */
	private String agmtRefNo5 = null;
	/* Column Info */
	private String agmtRefNo6 = null;
	/* Column Info */
	private String spName5 = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String agmtRefNo3 = null;
	/* Column Info */
	private String spName6 = null;
	/* Column Info */
	private String agmtRefNo4 = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String n2ndTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String n6thNode = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n2ndAgmtRefNo = null;
	/* Column Info */
	private String destNode = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String n2ndTrspAgmtSeq = null;
	/* Column Info */
	private String n1stTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInlandRouteVO() {}

	public SearchInlandRouteVO(String ibflag, String pagerows, String deltFlg, String routOrgNodCd, String routDestNodCd, String prioSeq, String inlndRoutBkgFlg, String wrsFullCmdt, String inlndRoutTmpFlg, String inlndRoutInclSttlFlg, String inlndRoutInvBilPattCd, String routPlnCd, String wrsMtyCmdtCd, String pctlIoBndCd, String hubLocCd, String creUsrId, String routSeq, String sumTtTime, String creOfcCd, String creDt, String updUsrId, String updDt, String n1stNode, String tm1, String vndr1, String spName1, String fmtTztmHrs1, String agmtNo1, String agmtRefNo1, String comFlg1, String juncNm1, String inlndRoutRmk1, String rdCrrTp1, String n1stTrspAgmtOfcCtyCd, String n1stTrspAgmtSeq, String n1stAgmtRefNo, String n2ndNode, String tm2, String vndr2, String spName2, String fmtTztmHrs2, String agmtNo2, String agmtRefNo2, String comFlg2, String juncNm2, String inlndRoutRmk2, String rdCrrTp2, String n2ndTrspAgmtOfcCtyCd, String n2ndTrspAgmtSeq, String n2ndAgmtRefNo, String n3rdNode, String tm3, String vndr3, String spName3, String fmtTztmHrs3, String agmtNo3, String agmtRefNo3, String comFlg3, String juncNm3, String inlndRoutRmk3, String rdCrrTp3, String n3rdTrspAgmtOfcCtyCd, String n3rdTrspAgmtSeq, String n3rdAgmtRefNo, String n4thNode, String tm4, String vndr4, String spName4, String fmtTztmHrs4, String agmtNo4, String agmtRefNo4, String comFlg4, String juncNm4, String inlndRoutRmk4, String rdCrrTp4, String n4thTrspAgmtOfcCtyCd, String n4thTrspAgmtSeq, String n4thAgmtRefNo, String n5thNode, String tm5, String vndr5, String spName5, String fmtTztmHrs5, String agmtNo5, String agmtRefNo5, String comFlg5, String juncNm5, String inlndRoutRmk5, String rdCrrTp5, String n5thTrspAgmtOfcCtyCd, String n5thTrspAgmtSeq, String n5thAgmtRefNo, String n6thNode, String tm6, String vndr6, String spName6, String agmtNo6, String agmtRefNo6, String comFlg6, String juncNm6, String inlndRoutRmk6, String rdCrrTp6, String orgNode, String destNode, String ioType, String nodeType, String seqNo) {
		this.seqNo = seqNo;
		this.routOrgNodCd = routOrgNodCd;
		this.pagerows = pagerows;
		this.n1stAgmtRefNo = n1stAgmtRefNo;
		this.juncNm1 = juncNm1;
		this.n3rdTrspAgmtOfcCtyCd = n3rdTrspAgmtOfcCtyCd;
		this.juncNm2 = juncNm2;
		this.juncNm3 = juncNm3;
		this.juncNm4 = juncNm4;
		this.updUsrId = updUsrId;
		this.juncNm5 = juncNm5;
		this.juncNm6 = juncNm6;
		this.agmtNo5 = agmtNo5;
		this.agmtNo4 = agmtNo4;
		this.agmtNo3 = agmtNo3;
		this.agmtNo2 = agmtNo2;
		this.agmtNo1 = agmtNo1;
		this.comFlg6 = comFlg6;
		this.comFlg5 = comFlg5;
		this.comFlg4 = comFlg4;
		this.comFlg3 = comFlg3;
		this.comFlg2 = comFlg2;
		this.comFlg1 = comFlg1;
		this.routSeq = routSeq;
		this.agmtNo6 = agmtNo6;
		this.fmtTztmHrs1 = fmtTztmHrs1;
		this.ioType = ioType;
		this.fmtTztmHrs2 = fmtTztmHrs2;
		this.fmtTztmHrs3 = fmtTztmHrs3;
		this.fmtTztmHrs4 = fmtTztmHrs4;
		this.fmtTztmHrs5 = fmtTztmHrs5;
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
		this.n3rdAgmtRefNo = n3rdAgmtRefNo;
		this.deltFlg = deltFlg;
		this.orgNode = orgNode;
		this.n1stNode = n1stNode;
		this.tm2 = tm2;
		this.tm1 = tm1;
		this.tm4 = tm4;
		this.tm3 = tm3;
		this.tm6 = tm6;
		this.tm5 = tm5;
		this.inlndRoutInclSttlFlg = inlndRoutInclSttlFlg;
		this.n5thTrspAgmtSeq = n5thTrspAgmtSeq;
		this.nodeType = nodeType;
		this.n3rdNode = n3rdNode;
		this.pctlIoBndCd = pctlIoBndCd;
		this.n5thAgmtRefNo = n5thAgmtRefNo;
		this.n3rdTrspAgmtSeq = n3rdTrspAgmtSeq;
		this.wrsFullCmdt = wrsFullCmdt;
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
		this.rdCrrTp3 = rdCrrTp3;
		this.rdCrrTp4 = rdCrrTp4;
		this.rdCrrTp1 = rdCrrTp1;
		this.rdCrrTp2 = rdCrrTp2;
		this.prioSeq = prioSeq;
		this.rdCrrTp5 = rdCrrTp5;
		this.rdCrrTp6 = rdCrrTp6;
		this.n1stTrspAgmtSeq = n1stTrspAgmtSeq;
		this.vndr1 = vndr1;
		this.vndr3 = vndr3;
		this.vndr2 = vndr2;
		this.vndr5 = vndr5;
		this.vndr4 = vndr4;
		this.vndr6 = vndr6;
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
		this.n4thTrspAgmtOfcCtyCd = n4thTrspAgmtOfcCtyCd;
		this.n2ndNode = n2ndNode;
		this.n5thTrspAgmtOfcCtyCd = n5thTrspAgmtOfcCtyCd;
		this.sumTtTime = sumTtTime;
		this.inlndRoutRmk6 = inlndRoutRmk6;
		this.inlndRoutRmk5 = inlndRoutRmk5;
		this.creUsrId = creUsrId;
		this.inlndRoutRmk4 = inlndRoutRmk4;
		this.inlndRoutRmk3 = inlndRoutRmk3;
		this.inlndRoutRmk2 = inlndRoutRmk2;
		this.inlndRoutRmk1 = inlndRoutRmk1;
		this.n4thAgmtRefNo = n4thAgmtRefNo;
		this.n5thNode = n5thNode;
		this.creDt = creDt;
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
		this.n4thNode = n4thNode;
		this.n4thTrspAgmtSeq = n4thTrspAgmtSeq;
		this.agmtRefNo1 = agmtRefNo1;
		this.agmtRefNo2 = agmtRefNo2;
		this.spName1 = spName1;
		this.spName2 = spName2;
		this.ibflag = ibflag;
		this.spName3 = spName3;
		this.spName4 = spName4;
		this.agmtRefNo5 = agmtRefNo5;
		this.agmtRefNo6 = agmtRefNo6;
		this.spName5 = spName5;
		this.creOfcCd = creOfcCd;
		this.agmtRefNo3 = agmtRefNo3;
		this.spName6 = spName6;
		this.agmtRefNo4 = agmtRefNo4;
		this.routDestNodCd = routDestNodCd;
		this.n2ndTrspAgmtOfcCtyCd = n2ndTrspAgmtOfcCtyCd;
		this.n6thNode = n6thNode;
		this.updDt = updDt;
		this.n2ndAgmtRefNo = n2ndAgmtRefNo;
		this.destNode = destNode;
		this.routPlnCd = routPlnCd;
		this.n2ndTrspAgmtSeq = n2ndTrspAgmtSeq;
		this.n1stTrspAgmtOfcCtyCd = n1stTrspAgmtOfcCtyCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n1st_agmt_ref_no", getN1stAgmtRefNo());
		this.hashColumns.put("junc_nm1", getJuncNm1());
		this.hashColumns.put("n3rd_trsp_agmt_ofc_cty_cd", getN3rdTrspAgmtOfcCtyCd());
		this.hashColumns.put("junc_nm2", getJuncNm2());
		this.hashColumns.put("junc_nm3", getJuncNm3());
		this.hashColumns.put("junc_nm4", getJuncNm4());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("junc_nm5", getJuncNm5());
		this.hashColumns.put("junc_nm6", getJuncNm6());
		this.hashColumns.put("agmt_no5", getAgmtNo5());
		this.hashColumns.put("agmt_no4", getAgmtNo4());
		this.hashColumns.put("agmt_no3", getAgmtNo3());
		this.hashColumns.put("agmt_no2", getAgmtNo2());
		this.hashColumns.put("agmt_no1", getAgmtNo1());
		this.hashColumns.put("com_flg6", getComFlg6());
		this.hashColumns.put("com_flg5", getComFlg5());
		this.hashColumns.put("com_flg4", getComFlg4());
		this.hashColumns.put("com_flg3", getComFlg3());
		this.hashColumns.put("com_flg2", getComFlg2());
		this.hashColumns.put("com_flg1", getComFlg1());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("agmt_no6", getAgmtNo6());
		this.hashColumns.put("fmt_tztm_hrs1", getFmtTztmHrs1());
		this.hashColumns.put("io_type", getIoType());
		this.hashColumns.put("fmt_tztm_hrs2", getFmtTztmHrs2());
		this.hashColumns.put("fmt_tztm_hrs3", getFmtTztmHrs3());
		this.hashColumns.put("fmt_tztm_hrs4", getFmtTztmHrs4());
		this.hashColumns.put("fmt_tztm_hrs5", getFmtTztmHrs5());
		this.hashColumns.put("inlnd_rout_bkg_flg", getInlndRoutBkgFlg());
		this.hashColumns.put("n3rd_agmt_ref_no", getN3rdAgmtRefNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("org_node", getOrgNode());
		this.hashColumns.put("n1st_node", getN1stNode());
		this.hashColumns.put("tm2", getTm2());
		this.hashColumns.put("tm1", getTm1());
		this.hashColumns.put("tm4", getTm4());
		this.hashColumns.put("tm3", getTm3());
		this.hashColumns.put("tm6", getTm6());
		this.hashColumns.put("tm5", getTm5());
		this.hashColumns.put("inlnd_rout_incl_sttl_flg", getInlndRoutInclSttlFlg());
		this.hashColumns.put("n5th_trsp_agmt_seq", getN5thTrspAgmtSeq());
		this.hashColumns.put("node_type", getNodeType());
		this.hashColumns.put("n3rd_node", getN3rdNode());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("n5th_agmt_ref_no", getN5thAgmtRefNo());
		this.hashColumns.put("n3rd_trsp_agmt_seq", getN3rdTrspAgmtSeq());
		this.hashColumns.put("wrs_full_cmdt", getWrsFullCmdt());
		this.hashColumns.put("inlnd_rout_inv_bil_patt_cd", getInlndRoutInvBilPattCd());
		this.hashColumns.put("rd_crr_tp3", getRdCrrTp3());
		this.hashColumns.put("rd_crr_tp4", getRdCrrTp4());
		this.hashColumns.put("rd_crr_tp1", getRdCrrTp1());
		this.hashColumns.put("rd_crr_tp2", getRdCrrTp2());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("rd_crr_tp5", getRdCrrTp5());
		this.hashColumns.put("rd_crr_tp6", getRdCrrTp6());
		this.hashColumns.put("n1st_trsp_agmt_seq", getN1stTrspAgmtSeq());
		this.hashColumns.put("vndr1", getVndr1());
		this.hashColumns.put("vndr3", getVndr3());
		this.hashColumns.put("vndr2", getVndr2());
		this.hashColumns.put("vndr5", getVndr5());
		this.hashColumns.put("vndr4", getVndr4());
		this.hashColumns.put("vndr6", getVndr6());
		this.hashColumns.put("inlnd_rout_tmp_flg", getInlndRoutTmpFlg());
		this.hashColumns.put("n4th_trsp_agmt_ofc_cty_cd", getN4thTrspAgmtOfcCtyCd());
		this.hashColumns.put("n2nd_node", getN2ndNode());
		this.hashColumns.put("n5th_trsp_agmt_ofc_cty_cd", getN5thTrspAgmtOfcCtyCd());
		this.hashColumns.put("sum_tt_time", getSumTtTime());
		this.hashColumns.put("inlnd_rout_rmk6", getInlndRoutRmk6());
		this.hashColumns.put("inlnd_rout_rmk5", getInlndRoutRmk5());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inlnd_rout_rmk4", getInlndRoutRmk4());
		this.hashColumns.put("inlnd_rout_rmk3", getInlndRoutRmk3());
		this.hashColumns.put("inlnd_rout_rmk2", getInlndRoutRmk2());
		this.hashColumns.put("inlnd_rout_rmk1", getInlndRoutRmk1());
		this.hashColumns.put("n4th_agmt_ref_no", getN4thAgmtRefNo());
		this.hashColumns.put("n5th_node", getN5thNode());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("wrs_mty_cmdt_cd", getWrsMtyCmdtCd());
		this.hashColumns.put("n4th_node", getN4thNode());
		this.hashColumns.put("n4th_trsp_agmt_seq", getN4thTrspAgmtSeq());
		this.hashColumns.put("agmt_ref_no1", getAgmtRefNo1());
		this.hashColumns.put("agmt_ref_no2", getAgmtRefNo2());
		this.hashColumns.put("sp_name1", getSpName1());
		this.hashColumns.put("sp_name2", getSpName2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sp_name3", getSpName3());
		this.hashColumns.put("sp_name4", getSpName4());
		this.hashColumns.put("agmt_ref_no5", getAgmtRefNo5());
		this.hashColumns.put("agmt_ref_no6", getAgmtRefNo6());
		this.hashColumns.put("sp_name5", getSpName5());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("agmt_ref_no3", getAgmtRefNo3());
		this.hashColumns.put("sp_name6", getSpName6());
		this.hashColumns.put("agmt_ref_no4", getAgmtRefNo4());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("n2nd_trsp_agmt_ofc_cty_cd", getN2ndTrspAgmtOfcCtyCd());
		this.hashColumns.put("n6th_node", getN6thNode());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n2nd_agmt_ref_no", getN2ndAgmtRefNo());
		this.hashColumns.put("dest_node", getDestNode());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("n2nd_trsp_agmt_seq", getN2ndTrspAgmtSeq());
		this.hashColumns.put("n1st_trsp_agmt_ofc_cty_cd", getN1stTrspAgmtOfcCtyCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n1st_agmt_ref_no", "n1stAgmtRefNo");
		this.hashFields.put("junc_nm1", "juncNm1");
		this.hashFields.put("n3rd_trsp_agmt_ofc_cty_cd", "n3rdTrspAgmtOfcCtyCd");
		this.hashFields.put("junc_nm2", "juncNm2");
		this.hashFields.put("junc_nm3", "juncNm3");
		this.hashFields.put("junc_nm4", "juncNm4");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("junc_nm5", "juncNm5");
		this.hashFields.put("junc_nm6", "juncNm6");
		this.hashFields.put("agmt_no5", "agmtNo5");
		this.hashFields.put("agmt_no4", "agmtNo4");
		this.hashFields.put("agmt_no3", "agmtNo3");
		this.hashFields.put("agmt_no2", "agmtNo2");
		this.hashFields.put("agmt_no1", "agmtNo1");
		this.hashFields.put("com_flg6", "comFlg6");
		this.hashFields.put("com_flg5", "comFlg5");
		this.hashFields.put("com_flg4", "comFlg4");
		this.hashFields.put("com_flg3", "comFlg3");
		this.hashFields.put("com_flg2", "comFlg2");
		this.hashFields.put("com_flg1", "comFlg1");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("agmt_no6", "agmtNo6");
		this.hashFields.put("fmt_tztm_hrs1", "fmtTztmHrs1");
		this.hashFields.put("io_type", "ioType");
		this.hashFields.put("fmt_tztm_hrs2", "fmtTztmHrs2");
		this.hashFields.put("fmt_tztm_hrs3", "fmtTztmHrs3");
		this.hashFields.put("fmt_tztm_hrs4", "fmtTztmHrs4");
		this.hashFields.put("fmt_tztm_hrs5", "fmtTztmHrs5");
		this.hashFields.put("inlnd_rout_bkg_flg", "inlndRoutBkgFlg");
		this.hashFields.put("n3rd_agmt_ref_no", "n3rdAgmtRefNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("org_node", "orgNode");
		this.hashFields.put("n1st_node", "n1stNode");
		this.hashFields.put("tm2", "tm2");
		this.hashFields.put("tm1", "tm1");
		this.hashFields.put("tm4", "tm4");
		this.hashFields.put("tm3", "tm3");
		this.hashFields.put("tm6", "tm6");
		this.hashFields.put("tm5", "tm5");
		this.hashFields.put("inlnd_rout_incl_sttl_flg", "inlndRoutInclSttlFlg");
		this.hashFields.put("n5th_trsp_agmt_seq", "n5thTrspAgmtSeq");
		this.hashFields.put("node_type", "nodeType");
		this.hashFields.put("n3rd_node", "n3rdNode");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("n5th_agmt_ref_no", "n5thAgmtRefNo");
		this.hashFields.put("n3rd_trsp_agmt_seq", "n3rdTrspAgmtSeq");
		this.hashFields.put("wrs_full_cmdt", "wrsFullCmdt");
		this.hashFields.put("inlnd_rout_inv_bil_patt_cd", "inlndRoutInvBilPattCd");
		this.hashFields.put("rd_crr_tp3", "rdCrrTp3");
		this.hashFields.put("rd_crr_tp4", "rdCrrTp4");
		this.hashFields.put("rd_crr_tp1", "rdCrrTp1");
		this.hashFields.put("rd_crr_tp2", "rdCrrTp2");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("rd_crr_tp5", "rdCrrTp5");
		this.hashFields.put("rd_crr_tp6", "rdCrrTp6");
		this.hashFields.put("n1st_trsp_agmt_seq", "n1stTrspAgmtSeq");
		this.hashFields.put("vndr1", "vndr1");
		this.hashFields.put("vndr3", "vndr3");
		this.hashFields.put("vndr2", "vndr2");
		this.hashFields.put("vndr5", "vndr5");
		this.hashFields.put("vndr4", "vndr4");
		this.hashFields.put("vndr6", "vndr6");
		this.hashFields.put("inlnd_rout_tmp_flg", "inlndRoutTmpFlg");
		this.hashFields.put("n4th_trsp_agmt_ofc_cty_cd", "n4thTrspAgmtOfcCtyCd");
		this.hashFields.put("n2nd_node", "n2ndNode");
		this.hashFields.put("n5th_trsp_agmt_ofc_cty_cd", "n5thTrspAgmtOfcCtyCd");
		this.hashFields.put("sum_tt_time", "sumTtTime");
		this.hashFields.put("inlnd_rout_rmk6", "inlndRoutRmk6");
		this.hashFields.put("inlnd_rout_rmk5", "inlndRoutRmk5");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inlnd_rout_rmk4", "inlndRoutRmk4");
		this.hashFields.put("inlnd_rout_rmk3", "inlndRoutRmk3");
		this.hashFields.put("inlnd_rout_rmk2", "inlndRoutRmk2");
		this.hashFields.put("inlnd_rout_rmk1", "inlndRoutRmk1");
		this.hashFields.put("n4th_agmt_ref_no", "n4thAgmtRefNo");
		this.hashFields.put("n5th_node", "n5thNode");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("wrs_mty_cmdt_cd", "wrsMtyCmdtCd");
		this.hashFields.put("n4th_node", "n4thNode");
		this.hashFields.put("n4th_trsp_agmt_seq", "n4thTrspAgmtSeq");
		this.hashFields.put("agmt_ref_no1", "agmtRefNo1");
		this.hashFields.put("agmt_ref_no2", "agmtRefNo2");
		this.hashFields.put("sp_name1", "spName1");
		this.hashFields.put("sp_name2", "spName2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_name3", "spName3");
		this.hashFields.put("sp_name4", "spName4");
		this.hashFields.put("agmt_ref_no5", "agmtRefNo5");
		this.hashFields.put("agmt_ref_no6", "agmtRefNo6");
		this.hashFields.put("sp_name5", "spName5");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("agmt_ref_no3", "agmtRefNo3");
		this.hashFields.put("sp_name6", "spName6");
		this.hashFields.put("agmt_ref_no4", "agmtRefNo4");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("n2nd_trsp_agmt_ofc_cty_cd", "n2ndTrspAgmtOfcCtyCd");
		this.hashFields.put("n6th_node", "n6thNode");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n2nd_agmt_ref_no", "n2ndAgmtRefNo");
		this.hashFields.put("dest_node", "destNode");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("n2nd_trsp_agmt_seq", "n2ndTrspAgmtSeq");
		this.hashFields.put("n1st_trsp_agmt_ofc_cty_cd", "n1stTrspAgmtOfcCtyCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
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
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
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
	 * @return n1stAgmtRefNo
	 */
	public String getN1stAgmtRefNo() {
		return this.n1stAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return juncNm1
	 */
	public String getJuncNm1() {
		return this.juncNm1;
	}
	
	/**
	 * Column Info
	 * @return n3rdTrspAgmtOfcCtyCd
	 */
	public String getN3rdTrspAgmtOfcCtyCd() {
		return this.n3rdTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return juncNm2
	 */
	public String getJuncNm2() {
		return this.juncNm2;
	}
	
	/**
	 * Column Info
	 * @return juncNm3
	 */
	public String getJuncNm3() {
		return this.juncNm3;
	}
	
	/**
	 * Column Info
	 * @return juncNm4
	 */
	public String getJuncNm4() {
		return this.juncNm4;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return juncNm5
	 */
	public String getJuncNm5() {
		return this.juncNm5;
	}
	
	/**
	 * Column Info
	 * @return juncNm6
	 */
	public String getJuncNm6() {
		return this.juncNm6;
	}
	
	/**
	 * Column Info
	 * @return agmtNo5
	 */
	public String getAgmtNo5() {
		return this.agmtNo5;
	}
	
	/**
	 * Column Info
	 * @return agmtNo4
	 */
	public String getAgmtNo4() {
		return this.agmtNo4;
	}
	
	/**
	 * Column Info
	 * @return agmtNo3
	 */
	public String getAgmtNo3() {
		return this.agmtNo3;
	}
	
	/**
	 * Column Info
	 * @return agmtNo2
	 */
	public String getAgmtNo2() {
		return this.agmtNo2;
	}
	
	/**
	 * Column Info
	 * @return agmtNo1
	 */
	public String getAgmtNo1() {
		return this.agmtNo1;
	}
	
	/**
	 * Column Info
	 * @return comFlg6
	 */
	public String getComFlg6() {
		return this.comFlg6;
	}
	
	/**
	 * Column Info
	 * @return comFlg5
	 */
	public String getComFlg5() {
		return this.comFlg5;
	}
	
	/**
	 * Column Info
	 * @return comFlg4
	 */
	public String getComFlg4() {
		return this.comFlg4;
	}
	
	/**
	 * Column Info
	 * @return comFlg3
	 */
	public String getComFlg3() {
		return this.comFlg3;
	}
	
	/**
	 * Column Info
	 * @return comFlg2
	 */
	public String getComFlg2() {
		return this.comFlg2;
	}
	
	/**
	 * Column Info
	 * @return comFlg1
	 */
	public String getComFlg1() {
		return this.comFlg1;
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
	 * @return agmtNo6
	 */
	public String getAgmtNo6() {
		return this.agmtNo6;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs1
	 */
	public String getFmtTztmHrs1() {
		return this.fmtTztmHrs1;
	}
	
	/**
	 * Column Info
	 * @return ioType
	 */
	public String getIoType() {
		return this.ioType;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs2
	 */
	public String getFmtTztmHrs2() {
		return this.fmtTztmHrs2;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs3
	 */
	public String getFmtTztmHrs3() {
		return this.fmtTztmHrs3;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs4
	 */
	public String getFmtTztmHrs4() {
		return this.fmtTztmHrs4;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs5
	 */
	public String getFmtTztmHrs5() {
		return this.fmtTztmHrs5;
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
	 * @return n3rdAgmtRefNo
	 */
	public String getN3rdAgmtRefNo() {
		return this.n3rdAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return orgNode
	 */
	public String getOrgNode() {
		return this.orgNode;
	}
	
	/**
	 * Column Info
	 * @return n1stNode
	 */
	public String getN1stNode() {
		return this.n1stNode;
	}
	
	/**
	 * Column Info
	 * @return tm2
	 */
	public String getTm2() {
		return this.tm2;
	}
	
	/**
	 * Column Info
	 * @return tm1
	 */
	public String getTm1() {
		return this.tm1;
	}
	
	/**
	 * Column Info
	 * @return tm4
	 */
	public String getTm4() {
		return this.tm4;
	}
	
	/**
	 * Column Info
	 * @return tm3
	 */
	public String getTm3() {
		return this.tm3;
	}
	
	/**
	 * Column Info
	 * @return tm6
	 */
	public String getTm6() {
		return this.tm6;
	}
	
	/**
	 * Column Info
	 * @return tm5
	 */
	public String getTm5() {
		return this.tm5;
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
	 * @return n5thTrspAgmtSeq
	 */
	public String getN5thTrspAgmtSeq() {
		return this.n5thTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return nodeType
	 */
	public String getNodeType() {
		return this.nodeType;
	}
	
	/**
	 * Column Info
	 * @return n3rdNode
	 */
	public String getN3rdNode() {
		return this.n3rdNode;
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
	 * @return n5thAgmtRefNo
	 */
	public String getN5thAgmtRefNo() {
		return this.n5thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdTrspAgmtSeq
	 */
	public String getN3rdTrspAgmtSeq() {
		return this.n3rdTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return wrsFullCmdt
	 */
	public String getWrsFullCmdt() {
		return this.wrsFullCmdt;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutInvBilPattCd
	 */
	public String getInlndRoutInvBilPattCd() {
		return this.inlndRoutInvBilPattCd;
	}
	
	/**
	 * Column Info
	 * @return rdCrrTp3
	 */
	public String getRdCrrTp3() {
		return this.rdCrrTp3;
	}
	
	/**
	 * Column Info
	 * @return rdCrrTp4
	 */
	public String getRdCrrTp4() {
		return this.rdCrrTp4;
	}
	
	/**
	 * Column Info
	 * @return rdCrrTp1
	 */
	public String getRdCrrTp1() {
		return this.rdCrrTp1;
	}
	
	/**
	 * Column Info
	 * @return rdCrrTp2
	 */
	public String getRdCrrTp2() {
		return this.rdCrrTp2;
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
	 * @return rdCrrTp5
	 */
	public String getRdCrrTp5() {
		return this.rdCrrTp5;
	}
	
	/**
	 * Column Info
	 * @return rdCrrTp6
	 */
	public String getRdCrrTp6() {
		return this.rdCrrTp6;
	}
	
	/**
	 * Column Info
	 * @return n1stTrspAgmtSeq
	 */
	public String getN1stTrspAgmtSeq() {
		return this.n1stTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return vndr1
	 */
	public String getVndr1() {
		return this.vndr1;
	}
	
	/**
	 * Column Info
	 * @return vndr3
	 */
	public String getVndr3() {
		return this.vndr3;
	}
	
	/**
	 * Column Info
	 * @return vndr2
	 */
	public String getVndr2() {
		return this.vndr2;
	}
	
	/**
	 * Column Info
	 * @return vndr5
	 */
	public String getVndr5() {
		return this.vndr5;
	}
	
	/**
	 * Column Info
	 * @return vndr4
	 */
	public String getVndr4() {
		return this.vndr4;
	}
	
	/**
	 * Column Info
	 * @return vndr6
	 */
	public String getVndr6() {
		return this.vndr6;
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
	 * @return n4thTrspAgmtOfcCtyCd
	 */
	public String getN4thTrspAgmtOfcCtyCd() {
		return this.n4thTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndNode
	 */
	public String getN2ndNode() {
		return this.n2ndNode;
	}
	
	/**
	 * Column Info
	 * @return n5thTrspAgmtOfcCtyCd
	 */
	public String getN5thTrspAgmtOfcCtyCd() {
		return this.n5thTrspAgmtOfcCtyCd;
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
	 * @return inlndRoutRmk6
	 */
	public String getInlndRoutRmk6() {
		return this.inlndRoutRmk6;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk5
	 */
	public String getInlndRoutRmk5() {
		return this.inlndRoutRmk5;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk4
	 */
	public String getInlndRoutRmk4() {
		return this.inlndRoutRmk4;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk3
	 */
	public String getInlndRoutRmk3() {
		return this.inlndRoutRmk3;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk2
	 */
	public String getInlndRoutRmk2() {
		return this.inlndRoutRmk2;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk1
	 */
	public String getInlndRoutRmk1() {
		return this.inlndRoutRmk1;
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
	 * @return n5thNode
	 */
	public String getN5thNode() {
		return this.n5thNode;
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
	 * @return wrsMtyCmdtCd
	 */
	public String getWrsMtyCmdtCd() {
		return this.wrsMtyCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return n4thNode
	 */
	public String getN4thNode() {
		return this.n4thNode;
	}
	
	/**
	 * Column Info
	 * @return n4thTrspAgmtSeq
	 */
	public String getN4thTrspAgmtSeq() {
		return this.n4thTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo1
	 */
	public String getAgmtRefNo1() {
		return this.agmtRefNo1;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo2
	 */
	public String getAgmtRefNo2() {
		return this.agmtRefNo2;
	}
	
	/**
	 * Column Info
	 * @return spName1
	 */
	public String getSpName1() {
		return this.spName1;
	}
	
	/**
	 * Column Info
	 * @return spName2
	 */
	public String getSpName2() {
		return this.spName2;
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
	 * @return spName3
	 */
	public String getSpName3() {
		return this.spName3;
	}
	
	/**
	 * Column Info
	 * @return spName4
	 */
	public String getSpName4() {
		return this.spName4;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo5
	 */
	public String getAgmtRefNo5() {
		return this.agmtRefNo5;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo6
	 */
	public String getAgmtRefNo6() {
		return this.agmtRefNo6;
	}
	
	/**
	 * Column Info
	 * @return spName5
	 */
	public String getSpName5() {
		return this.spName5;
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
	 * @return agmtRefNo3
	 */
	public String getAgmtRefNo3() {
		return this.agmtRefNo3;
	}
	
	/**
	 * Column Info
	 * @return spName6
	 */
	public String getSpName6() {
		return this.spName6;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo4
	 */
	public String getAgmtRefNo4() {
		return this.agmtRefNo4;
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
	 * @return n2ndTrspAgmtOfcCtyCd
	 */
	public String getN2ndTrspAgmtOfcCtyCd() {
		return this.n2ndTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return n6thNode
	 */
	public String getN6thNode() {
		return this.n6thNode;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return destNode
	 */
	public String getDestNode() {
		return this.destNode;
	}
	
	/**
	 * Column Info
	 * @return routPlnCd
	 */
	public String getRoutPlnCd() {
		return this.routPlnCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndTrspAgmtSeq
	 */
	public String getN2ndTrspAgmtSeq() {
		return this.n2ndTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stTrspAgmtOfcCtyCd
	 */
	public String getN1stTrspAgmtOfcCtyCd() {
		return this.n1stTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
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
	 * @param n1stAgmtRefNo
	 */
	public void setN1stAgmtRefNo(String n1stAgmtRefNo) {
		this.n1stAgmtRefNo = n1stAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param juncNm1
	 */
	public void setJuncNm1(String juncNm1) {
		this.juncNm1 = juncNm1;
	}
	
	/**
	 * Column Info
	 * @param n3rdTrspAgmtOfcCtyCd
	 */
	public void setN3rdTrspAgmtOfcCtyCd(String n3rdTrspAgmtOfcCtyCd) {
		this.n3rdTrspAgmtOfcCtyCd = n3rdTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param juncNm2
	 */
	public void setJuncNm2(String juncNm2) {
		this.juncNm2 = juncNm2;
	}
	
	/**
	 * Column Info
	 * @param juncNm3
	 */
	public void setJuncNm3(String juncNm3) {
		this.juncNm3 = juncNm3;
	}
	
	/**
	 * Column Info
	 * @param juncNm4
	 */
	public void setJuncNm4(String juncNm4) {
		this.juncNm4 = juncNm4;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param juncNm5
	 */
	public void setJuncNm5(String juncNm5) {
		this.juncNm5 = juncNm5;
	}
	
	/**
	 * Column Info
	 * @param juncNm6
	 */
	public void setJuncNm6(String juncNm6) {
		this.juncNm6 = juncNm6;
	}
	
	/**
	 * Column Info
	 * @param agmtNo5
	 */
	public void setAgmtNo5(String agmtNo5) {
		this.agmtNo5 = agmtNo5;
	}
	
	/**
	 * Column Info
	 * @param agmtNo4
	 */
	public void setAgmtNo4(String agmtNo4) {
		this.agmtNo4 = agmtNo4;
	}
	
	/**
	 * Column Info
	 * @param agmtNo3
	 */
	public void setAgmtNo3(String agmtNo3) {
		this.agmtNo3 = agmtNo3;
	}
	
	/**
	 * Column Info
	 * @param agmtNo2
	 */
	public void setAgmtNo2(String agmtNo2) {
		this.agmtNo2 = agmtNo2;
	}
	
	/**
	 * Column Info
	 * @param agmtNo1
	 */
	public void setAgmtNo1(String agmtNo1) {
		this.agmtNo1 = agmtNo1;
	}
	
	/**
	 * Column Info
	 * @param comFlg6
	 */
	public void setComFlg6(String comFlg6) {
		this.comFlg6 = comFlg6;
	}
	
	/**
	 * Column Info
	 * @param comFlg5
	 */
	public void setComFlg5(String comFlg5) {
		this.comFlg5 = comFlg5;
	}
	
	/**
	 * Column Info
	 * @param comFlg4
	 */
	public void setComFlg4(String comFlg4) {
		this.comFlg4 = comFlg4;
	}
	
	/**
	 * Column Info
	 * @param comFlg3
	 */
	public void setComFlg3(String comFlg3) {
		this.comFlg3 = comFlg3;
	}
	
	/**
	 * Column Info
	 * @param comFlg2
	 */
	public void setComFlg2(String comFlg2) {
		this.comFlg2 = comFlg2;
	}
	
	/**
	 * Column Info
	 * @param comFlg1
	 */
	public void setComFlg1(String comFlg1) {
		this.comFlg1 = comFlg1;
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
	 * @param agmtNo6
	 */
	public void setAgmtNo6(String agmtNo6) {
		this.agmtNo6 = agmtNo6;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs1
	 */
	public void setFmtTztmHrs1(String fmtTztmHrs1) {
		this.fmtTztmHrs1 = fmtTztmHrs1;
	}
	
	/**
	 * Column Info
	 * @param ioType
	 */
	public void setIoType(String ioType) {
		this.ioType = ioType;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs2
	 */
	public void setFmtTztmHrs2(String fmtTztmHrs2) {
		this.fmtTztmHrs2 = fmtTztmHrs2;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs3
	 */
	public void setFmtTztmHrs3(String fmtTztmHrs3) {
		this.fmtTztmHrs3 = fmtTztmHrs3;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs4
	 */
	public void setFmtTztmHrs4(String fmtTztmHrs4) {
		this.fmtTztmHrs4 = fmtTztmHrs4;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs5
	 */
	public void setFmtTztmHrs5(String fmtTztmHrs5) {
		this.fmtTztmHrs5 = fmtTztmHrs5;
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
	 * @param n3rdAgmtRefNo
	 */
	public void setN3rdAgmtRefNo(String n3rdAgmtRefNo) {
		this.n3rdAgmtRefNo = n3rdAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param orgNode
	 */
	public void setOrgNode(String orgNode) {
		this.orgNode = orgNode;
	}
	
	/**
	 * Column Info
	 * @param n1stNode
	 */
	public void setN1stNode(String n1stNode) {
		this.n1stNode = n1stNode;
	}
	
	/**
	 * Column Info
	 * @param tm2
	 */
	public void setTm2(String tm2) {
		this.tm2 = tm2;
	}
	
	/**
	 * Column Info
	 * @param tm1
	 */
	public void setTm1(String tm1) {
		this.tm1 = tm1;
	}
	
	/**
	 * Column Info
	 * @param tm4
	 */
	public void setTm4(String tm4) {
		this.tm4 = tm4;
	}
	
	/**
	 * Column Info
	 * @param tm3
	 */
	public void setTm3(String tm3) {
		this.tm3 = tm3;
	}
	
	/**
	 * Column Info
	 * @param tm6
	 */
	public void setTm6(String tm6) {
		this.tm6 = tm6;
	}
	
	/**
	 * Column Info
	 * @param tm5
	 */
	public void setTm5(String tm5) {
		this.tm5 = tm5;
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
	 * @param n5thTrspAgmtSeq
	 */
	public void setN5thTrspAgmtSeq(String n5thTrspAgmtSeq) {
		this.n5thTrspAgmtSeq = n5thTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param nodeType
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	
	/**
	 * Column Info
	 * @param n3rdNode
	 */
	public void setN3rdNode(String n3rdNode) {
		this.n3rdNode = n3rdNode;
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
	 * @param n5thAgmtRefNo
	 */
	public void setN5thAgmtRefNo(String n5thAgmtRefNo) {
		this.n5thAgmtRefNo = n5thAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdTrspAgmtSeq
	 */
	public void setN3rdTrspAgmtSeq(String n3rdTrspAgmtSeq) {
		this.n3rdTrspAgmtSeq = n3rdTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param wrsFullCmdt
	 */
	public void setWrsFullCmdt(String wrsFullCmdt) {
		this.wrsFullCmdt = wrsFullCmdt;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutInvBilPattCd
	 */
	public void setInlndRoutInvBilPattCd(String inlndRoutInvBilPattCd) {
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
	}
	
	/**
	 * Column Info
	 * @param rdCrrTp3
	 */
	public void setRdCrrTp3(String rdCrrTp3) {
		this.rdCrrTp3 = rdCrrTp3;
	}
	
	/**
	 * Column Info
	 * @param rdCrrTp4
	 */
	public void setRdCrrTp4(String rdCrrTp4) {
		this.rdCrrTp4 = rdCrrTp4;
	}
	
	/**
	 * Column Info
	 * @param rdCrrTp1
	 */
	public void setRdCrrTp1(String rdCrrTp1) {
		this.rdCrrTp1 = rdCrrTp1;
	}
	
	/**
	 * Column Info
	 * @param rdCrrTp2
	 */
	public void setRdCrrTp2(String rdCrrTp2) {
		this.rdCrrTp2 = rdCrrTp2;
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
	 * @param rdCrrTp5
	 */
	public void setRdCrrTp5(String rdCrrTp5) {
		this.rdCrrTp5 = rdCrrTp5;
	}
	
	/**
	 * Column Info
	 * @param rdCrrTp6
	 */
	public void setRdCrrTp6(String rdCrrTp6) {
		this.rdCrrTp6 = rdCrrTp6;
	}
	
	/**
	 * Column Info
	 * @param n1stTrspAgmtSeq
	 */
	public void setN1stTrspAgmtSeq(String n1stTrspAgmtSeq) {
		this.n1stTrspAgmtSeq = n1stTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param vndr1
	 */
	public void setVndr1(String vndr1) {
		this.vndr1 = vndr1;
	}
	
	/**
	 * Column Info
	 * @param vndr3
	 */
	public void setVndr3(String vndr3) {
		this.vndr3 = vndr3;
	}
	
	/**
	 * Column Info
	 * @param vndr2
	 */
	public void setVndr2(String vndr2) {
		this.vndr2 = vndr2;
	}
	
	/**
	 * Column Info
	 * @param vndr5
	 */
	public void setVndr5(String vndr5) {
		this.vndr5 = vndr5;
	}
	
	/**
	 * Column Info
	 * @param vndr4
	 */
	public void setVndr4(String vndr4) {
		this.vndr4 = vndr4;
	}
	
	/**
	 * Column Info
	 * @param vndr6
	 */
	public void setVndr6(String vndr6) {
		this.vndr6 = vndr6;
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
	 * @param n4thTrspAgmtOfcCtyCd
	 */
	public void setN4thTrspAgmtOfcCtyCd(String n4thTrspAgmtOfcCtyCd) {
		this.n4thTrspAgmtOfcCtyCd = n4thTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndNode
	 */
	public void setN2ndNode(String n2ndNode) {
		this.n2ndNode = n2ndNode;
	}
	
	/**
	 * Column Info
	 * @param n5thTrspAgmtOfcCtyCd
	 */
	public void setN5thTrspAgmtOfcCtyCd(String n5thTrspAgmtOfcCtyCd) {
		this.n5thTrspAgmtOfcCtyCd = n5thTrspAgmtOfcCtyCd;
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
	 * @param inlndRoutRmk6
	 */
	public void setInlndRoutRmk6(String inlndRoutRmk6) {
		this.inlndRoutRmk6 = inlndRoutRmk6;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk5
	 */
	public void setInlndRoutRmk5(String inlndRoutRmk5) {
		this.inlndRoutRmk5 = inlndRoutRmk5;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk4
	 */
	public void setInlndRoutRmk4(String inlndRoutRmk4) {
		this.inlndRoutRmk4 = inlndRoutRmk4;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk3
	 */
	public void setInlndRoutRmk3(String inlndRoutRmk3) {
		this.inlndRoutRmk3 = inlndRoutRmk3;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk2
	 */
	public void setInlndRoutRmk2(String inlndRoutRmk2) {
		this.inlndRoutRmk2 = inlndRoutRmk2;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk1
	 */
	public void setInlndRoutRmk1(String inlndRoutRmk1) {
		this.inlndRoutRmk1 = inlndRoutRmk1;
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
	 * @param n5thNode
	 */
	public void setN5thNode(String n5thNode) {
		this.n5thNode = n5thNode;
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
	 * @param wrsMtyCmdtCd
	 */
	public void setWrsMtyCmdtCd(String wrsMtyCmdtCd) {
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param n4thNode
	 */
	public void setN4thNode(String n4thNode) {
		this.n4thNode = n4thNode;
	}
	
	/**
	 * Column Info
	 * @param n4thTrspAgmtSeq
	 */
	public void setN4thTrspAgmtSeq(String n4thTrspAgmtSeq) {
		this.n4thTrspAgmtSeq = n4thTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo1
	 */
	public void setAgmtRefNo1(String agmtRefNo1) {
		this.agmtRefNo1 = agmtRefNo1;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo2
	 */
	public void setAgmtRefNo2(String agmtRefNo2) {
		this.agmtRefNo2 = agmtRefNo2;
	}
	
	/**
	 * Column Info
	 * @param spName1
	 */
	public void setSpName1(String spName1) {
		this.spName1 = spName1;
	}
	
	/**
	 * Column Info
	 * @param spName2
	 */
	public void setSpName2(String spName2) {
		this.spName2 = spName2;
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
	 * @param spName3
	 */
	public void setSpName3(String spName3) {
		this.spName3 = spName3;
	}
	
	/**
	 * Column Info
	 * @param spName4
	 */
	public void setSpName4(String spName4) {
		this.spName4 = spName4;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo5
	 */
	public void setAgmtRefNo5(String agmtRefNo5) {
		this.agmtRefNo5 = agmtRefNo5;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo6
	 */
	public void setAgmtRefNo6(String agmtRefNo6) {
		this.agmtRefNo6 = agmtRefNo6;
	}
	
	/**
	 * Column Info
	 * @param spName5
	 */
	public void setSpName5(String spName5) {
		this.spName5 = spName5;
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
	 * @param agmtRefNo3
	 */
	public void setAgmtRefNo3(String agmtRefNo3) {
		this.agmtRefNo3 = agmtRefNo3;
	}
	
	/**
	 * Column Info
	 * @param spName6
	 */
	public void setSpName6(String spName6) {
		this.spName6 = spName6;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo4
	 */
	public void setAgmtRefNo4(String agmtRefNo4) {
		this.agmtRefNo4 = agmtRefNo4;
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
	 * @param n2ndTrspAgmtOfcCtyCd
	 */
	public void setN2ndTrspAgmtOfcCtyCd(String n2ndTrspAgmtOfcCtyCd) {
		this.n2ndTrspAgmtOfcCtyCd = n2ndTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param n6thNode
	 */
	public void setN6thNode(String n6thNode) {
		this.n6thNode = n6thNode;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param destNode
	 */
	public void setDestNode(String destNode) {
		this.destNode = destNode;
	}
	
	/**
	 * Column Info
	 * @param routPlnCd
	 */
	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndTrspAgmtSeq
	 */
	public void setN2ndTrspAgmtSeq(String n2ndTrspAgmtSeq) {
		this.n2ndTrspAgmtSeq = n2ndTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stTrspAgmtOfcCtyCd
	 */
	public void setN1stTrspAgmtOfcCtyCd(String n1stTrspAgmtOfcCtyCd) {
		this.n1stTrspAgmtOfcCtyCd = n1stTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN1stAgmtRefNo(JSPUtil.getParameter(request, prefix + "n1st_agmt_ref_no", ""));
		setJuncNm1(JSPUtil.getParameter(request, prefix + "junc_nm1", ""));
		setN3rdTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "n3rd_trsp_agmt_ofc_cty_cd", ""));
		setJuncNm2(JSPUtil.getParameter(request, prefix + "junc_nm2", ""));
		setJuncNm3(JSPUtil.getParameter(request, prefix + "junc_nm3", ""));
		setJuncNm4(JSPUtil.getParameter(request, prefix + "junc_nm4", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setJuncNm5(JSPUtil.getParameter(request, prefix + "junc_nm5", ""));
		setJuncNm6(JSPUtil.getParameter(request, prefix + "junc_nm6", ""));
		setAgmtNo5(JSPUtil.getParameter(request, prefix + "agmt_no5", ""));
		setAgmtNo4(JSPUtil.getParameter(request, prefix + "agmt_no4", ""));
		setAgmtNo3(JSPUtil.getParameter(request, prefix + "agmt_no3", ""));
		setAgmtNo2(JSPUtil.getParameter(request, prefix + "agmt_no2", ""));
		setAgmtNo1(JSPUtil.getParameter(request, prefix + "agmt_no1", ""));
		setComFlg6(JSPUtil.getParameter(request, prefix + "com_flg6", ""));
		setComFlg5(JSPUtil.getParameter(request, prefix + "com_flg5", ""));
		setComFlg4(JSPUtil.getParameter(request, prefix + "com_flg4", ""));
		setComFlg3(JSPUtil.getParameter(request, prefix + "com_flg3", ""));
		setComFlg2(JSPUtil.getParameter(request, prefix + "com_flg2", ""));
		setComFlg1(JSPUtil.getParameter(request, prefix + "com_flg1", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setAgmtNo6(JSPUtil.getParameter(request, prefix + "agmt_no6", ""));
		setFmtTztmHrs1(JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs1", ""));
		setIoType(JSPUtil.getParameter(request, prefix + "io_type", ""));
		setFmtTztmHrs2(JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs2", ""));
		setFmtTztmHrs3(JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs3", ""));
		setFmtTztmHrs4(JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs4", ""));
		setFmtTztmHrs5(JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs5", ""));
		setInlndRoutBkgFlg(JSPUtil.getParameter(request, prefix + "inlnd_rout_bkg_flg", ""));
		setN3rdAgmtRefNo(JSPUtil.getParameter(request, prefix + "n3rd_agmt_ref_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOrgNode(JSPUtil.getParameter(request, prefix + "org_node", ""));
		setN1stNode(JSPUtil.getParameter(request, prefix + "n1st_node", ""));
		setTm2(JSPUtil.getParameter(request, prefix + "tm2", ""));
		setTm1(JSPUtil.getParameter(request, prefix + "tm1", ""));
		setTm4(JSPUtil.getParameter(request, prefix + "tm4", ""));
		setTm3(JSPUtil.getParameter(request, prefix + "tm3", ""));
		setTm6(JSPUtil.getParameter(request, prefix + "tm6", ""));
		setTm5(JSPUtil.getParameter(request, prefix + "tm5", ""));
		setInlndRoutInclSttlFlg(JSPUtil.getParameter(request, prefix + "inlnd_rout_incl_sttl_flg", ""));
		setN5thTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "n5th_trsp_agmt_seq", ""));
		setNodeType(JSPUtil.getParameter(request, prefix + "node_type", ""));
		setN3rdNode(JSPUtil.getParameter(request, prefix + "n3rd_node", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_cd", ""));
		setN5thAgmtRefNo(JSPUtil.getParameter(request, prefix + "n5th_agmt_ref_no", ""));
		setN3rdTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "n3rd_trsp_agmt_seq", ""));
		setWrsFullCmdt(JSPUtil.getParameter(request, prefix + "wrs_full_cmdt", ""));
		setInlndRoutInvBilPattCd(JSPUtil.getParameter(request, prefix + "inlnd_rout_inv_bil_patt_cd", ""));
		setRdCrrTp3(JSPUtil.getParameter(request, prefix + "rd_crr_tp3", ""));
		setRdCrrTp4(JSPUtil.getParameter(request, prefix + "rd_crr_tp4", ""));
		setRdCrrTp1(JSPUtil.getParameter(request, prefix + "rd_crr_tp1", ""));
		setRdCrrTp2(JSPUtil.getParameter(request, prefix + "rd_crr_tp2", ""));
		setPrioSeq(JSPUtil.getParameter(request, prefix + "prio_seq", ""));
		setRdCrrTp5(JSPUtil.getParameter(request, prefix + "rd_crr_tp5", ""));
		setRdCrrTp6(JSPUtil.getParameter(request, prefix + "rd_crr_tp6", ""));
		setN1stTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "n1st_trsp_agmt_seq", ""));
		setVndr1(JSPUtil.getParameter(request, prefix + "vndr1", ""));
		setVndr3(JSPUtil.getParameter(request, prefix + "vndr3", ""));
		setVndr2(JSPUtil.getParameter(request, prefix + "vndr2", ""));
		setVndr5(JSPUtil.getParameter(request, prefix + "vndr5", ""));
		setVndr4(JSPUtil.getParameter(request, prefix + "vndr4", ""));
		setVndr6(JSPUtil.getParameter(request, prefix + "vndr6", ""));
		setInlndRoutTmpFlg(JSPUtil.getParameter(request, prefix + "inlnd_rout_tmp_flg", ""));
		setN4thTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "n4th_trsp_agmt_ofc_cty_cd", ""));
		setN2ndNode(JSPUtil.getParameter(request, prefix + "n2nd_node", ""));
		setN5thTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "n5th_trsp_agmt_ofc_cty_cd", ""));
		setSumTtTime(JSPUtil.getParameter(request, prefix + "sum_tt_time", ""));
		setInlndRoutRmk6(JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk6", ""));
		setInlndRoutRmk5(JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk5", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInlndRoutRmk4(JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk4", ""));
		setInlndRoutRmk3(JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk3", ""));
		setInlndRoutRmk2(JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk2", ""));
		setInlndRoutRmk1(JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk1", ""));
		setN4thAgmtRefNo(JSPUtil.getParameter(request, prefix + "n4th_agmt_ref_no", ""));
		setN5thNode(JSPUtil.getParameter(request, prefix + "n5th_node", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setWrsMtyCmdtCd(JSPUtil.getParameter(request, prefix + "wrs_mty_cmdt_cd", ""));
		setN4thNode(JSPUtil.getParameter(request, prefix + "n4th_node", ""));
		setN4thTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "n4th_trsp_agmt_seq", ""));
		setAgmtRefNo1(JSPUtil.getParameter(request, prefix + "agmt_ref_no1", ""));
		setAgmtRefNo2(JSPUtil.getParameter(request, prefix + "agmt_ref_no2", ""));
		setSpName1(JSPUtil.getParameter(request, prefix + "sp_name1", ""));
		setSpName2(JSPUtil.getParameter(request, prefix + "sp_name2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpName3(JSPUtil.getParameter(request, prefix + "sp_name3", ""));
		setSpName4(JSPUtil.getParameter(request, prefix + "sp_name4", ""));
		setAgmtRefNo5(JSPUtil.getParameter(request, prefix + "agmt_ref_no5", ""));
		setAgmtRefNo6(JSPUtil.getParameter(request, prefix + "agmt_ref_no6", ""));
		setSpName5(JSPUtil.getParameter(request, prefix + "sp_name5", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setAgmtRefNo3(JSPUtil.getParameter(request, prefix + "agmt_ref_no3", ""));
		setSpName6(JSPUtil.getParameter(request, prefix + "sp_name6", ""));
		setAgmtRefNo4(JSPUtil.getParameter(request, prefix + "agmt_ref_no4", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", ""));
		setN2ndTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "n2nd_trsp_agmt_ofc_cty_cd", ""));
		setN6thNode(JSPUtil.getParameter(request, prefix + "n6th_node", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN2ndAgmtRefNo(JSPUtil.getParameter(request, prefix + "n2nd_agmt_ref_no", ""));
		setDestNode(JSPUtil.getParameter(request, prefix + "dest_node", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, prefix + "rout_pln_cd", ""));
		setN2ndTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "n2nd_trsp_agmt_seq", ""));
		setN1stTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "n1st_trsp_agmt_ofc_cty_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInlandRouteVO[]
	 */
	public SearchInlandRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInlandRouteVO[]
	 */
	public SearchInlandRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInlandRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n1stAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n1st_agmt_ref_no", length));
			String[] juncNm1 = (JSPUtil.getParameter(request, prefix	+ "junc_nm1", length));
			String[] n3rdTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_trsp_agmt_ofc_cty_cd", length));
			String[] juncNm2 = (JSPUtil.getParameter(request, prefix	+ "junc_nm2", length));
			String[] juncNm3 = (JSPUtil.getParameter(request, prefix	+ "junc_nm3", length));
			String[] juncNm4 = (JSPUtil.getParameter(request, prefix	+ "junc_nm4", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] juncNm5 = (JSPUtil.getParameter(request, prefix	+ "junc_nm5", length));
			String[] juncNm6 = (JSPUtil.getParameter(request, prefix	+ "junc_nm6", length));
			String[] agmtNo5 = (JSPUtil.getParameter(request, prefix	+ "agmt_no5", length));
			String[] agmtNo4 = (JSPUtil.getParameter(request, prefix	+ "agmt_no4", length));
			String[] agmtNo3 = (JSPUtil.getParameter(request, prefix	+ "agmt_no3", length));
			String[] agmtNo2 = (JSPUtil.getParameter(request, prefix	+ "agmt_no2", length));
			String[] agmtNo1 = (JSPUtil.getParameter(request, prefix	+ "agmt_no1", length));
			String[] comFlg6 = (JSPUtil.getParameter(request, prefix	+ "com_flg6", length));
			String[] comFlg5 = (JSPUtil.getParameter(request, prefix	+ "com_flg5", length));
			String[] comFlg4 = (JSPUtil.getParameter(request, prefix	+ "com_flg4", length));
			String[] comFlg3 = (JSPUtil.getParameter(request, prefix	+ "com_flg3", length));
			String[] comFlg2 = (JSPUtil.getParameter(request, prefix	+ "com_flg2", length));
			String[] comFlg1 = (JSPUtil.getParameter(request, prefix	+ "com_flg1", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] agmtNo6 = (JSPUtil.getParameter(request, prefix	+ "agmt_no6", length));
			String[] fmtTztmHrs1 = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs1", length));
			String[] ioType = (JSPUtil.getParameter(request, prefix	+ "io_type", length));
			String[] fmtTztmHrs2 = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs2", length));
			String[] fmtTztmHrs3 = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs3", length));
			String[] fmtTztmHrs4 = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs4", length));
			String[] fmtTztmHrs5 = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs5", length));
			String[] inlndRoutBkgFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_bkg_flg", length));
			String[] n3rdAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_agmt_ref_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] orgNode = (JSPUtil.getParameter(request, prefix	+ "org_node", length));
			String[] n1stNode = (JSPUtil.getParameter(request, prefix	+ "n1st_node", length));
			String[] tm2 = (JSPUtil.getParameter(request, prefix	+ "tm2", length));
			String[] tm1 = (JSPUtil.getParameter(request, prefix	+ "tm1", length));
			String[] tm4 = (JSPUtil.getParameter(request, prefix	+ "tm4", length));
			String[] tm3 = (JSPUtil.getParameter(request, prefix	+ "tm3", length));
			String[] tm6 = (JSPUtil.getParameter(request, prefix	+ "tm6", length));
			String[] tm5 = (JSPUtil.getParameter(request, prefix	+ "tm5", length));
			String[] inlndRoutInclSttlFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_incl_sttl_flg", length));
			String[] n5thTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_trsp_agmt_seq", length));
			String[] nodeType = (JSPUtil.getParameter(request, prefix	+ "node_type", length));
			String[] n3rdNode = (JSPUtil.getParameter(request, prefix	+ "n3rd_node", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] n5thAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n5th_agmt_ref_no", length));
			String[] n3rdTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_trsp_agmt_seq", length));
			String[] wrsFullCmdt = (JSPUtil.getParameter(request, prefix	+ "wrs_full_cmdt", length));
			String[] inlndRoutInvBilPattCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_inv_bil_patt_cd", length));
			String[] rdCrrTp3 = (JSPUtil.getParameter(request, prefix	+ "rd_crr_tp3", length));
			String[] rdCrrTp4 = (JSPUtil.getParameter(request, prefix	+ "rd_crr_tp4", length));
			String[] rdCrrTp1 = (JSPUtil.getParameter(request, prefix	+ "rd_crr_tp1", length));
			String[] rdCrrTp2 = (JSPUtil.getParameter(request, prefix	+ "rd_crr_tp2", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] rdCrrTp5 = (JSPUtil.getParameter(request, prefix	+ "rd_crr_tp5", length));
			String[] rdCrrTp6 = (JSPUtil.getParameter(request, prefix	+ "rd_crr_tp6", length));
			String[] n1stTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_trsp_agmt_seq", length));
			String[] vndr1 = (JSPUtil.getParameter(request, prefix	+ "vndr1", length));
			String[] vndr3 = (JSPUtil.getParameter(request, prefix	+ "vndr3", length));
			String[] vndr2 = (JSPUtil.getParameter(request, prefix	+ "vndr2", length));
			String[] vndr5 = (JSPUtil.getParameter(request, prefix	+ "vndr5", length));
			String[] vndr4 = (JSPUtil.getParameter(request, prefix	+ "vndr4", length));
			String[] vndr6 = (JSPUtil.getParameter(request, prefix	+ "vndr6", length));
			String[] inlndRoutTmpFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_tmp_flg", length));
			String[] n4thTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "n4th_trsp_agmt_ofc_cty_cd", length));
			String[] n2ndNode = (JSPUtil.getParameter(request, prefix	+ "n2nd_node", length));
			String[] n5thTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "n5th_trsp_agmt_ofc_cty_cd", length));
			String[] sumTtTime = (JSPUtil.getParameter(request, prefix	+ "sum_tt_time", length));
			String[] inlndRoutRmk6 = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk6", length));
			String[] inlndRoutRmk5 = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk5", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] inlndRoutRmk4 = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk4", length));
			String[] inlndRoutRmk3 = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk3", length));
			String[] inlndRoutRmk2 = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk2", length));
			String[] inlndRoutRmk1 = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk1", length));
			String[] n4thAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n4th_agmt_ref_no", length));
			String[] n5thNode = (JSPUtil.getParameter(request, prefix	+ "n5th_node", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] wrsMtyCmdtCd = (JSPUtil.getParameter(request, prefix	+ "wrs_mty_cmdt_cd", length));
			String[] n4thNode = (JSPUtil.getParameter(request, prefix	+ "n4th_node", length));
			String[] n4thTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_trsp_agmt_seq", length));
			String[] agmtRefNo1 = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no1", length));
			String[] agmtRefNo2 = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no2", length));
			String[] spName1 = (JSPUtil.getParameter(request, prefix	+ "sp_name1", length));
			String[] spName2 = (JSPUtil.getParameter(request, prefix	+ "sp_name2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spName3 = (JSPUtil.getParameter(request, prefix	+ "sp_name3", length));
			String[] spName4 = (JSPUtil.getParameter(request, prefix	+ "sp_name4", length));
			String[] agmtRefNo5 = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no5", length));
			String[] agmtRefNo6 = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no6", length));
			String[] spName5 = (JSPUtil.getParameter(request, prefix	+ "sp_name5", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] agmtRefNo3 = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no3", length));
			String[] spName6 = (JSPUtil.getParameter(request, prefix	+ "sp_name6", length));
			String[] agmtRefNo4 = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no4", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] n2ndTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_trsp_agmt_ofc_cty_cd", length));
			String[] n6thNode = (JSPUtil.getParameter(request, prefix	+ "n6th_node", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n2ndAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_agmt_ref_no", length));
			String[] destNode = (JSPUtil.getParameter(request, prefix	+ "dest_node", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix	+ "rout_pln_cd", length));
			String[] n2ndTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_trsp_agmt_seq", length));
			String[] n1stTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "n1st_trsp_agmt_ofc_cty_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInlandRouteVO();
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n1stAgmtRefNo[i] != null)
					model.setN1stAgmtRefNo(n1stAgmtRefNo[i]);
				if (juncNm1[i] != null)
					model.setJuncNm1(juncNm1[i]);
				if (n3rdTrspAgmtOfcCtyCd[i] != null)
					model.setN3rdTrspAgmtOfcCtyCd(n3rdTrspAgmtOfcCtyCd[i]);
				if (juncNm2[i] != null)
					model.setJuncNm2(juncNm2[i]);
				if (juncNm3[i] != null)
					model.setJuncNm3(juncNm3[i]);
				if (juncNm4[i] != null)
					model.setJuncNm4(juncNm4[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (juncNm5[i] != null)
					model.setJuncNm5(juncNm5[i]);
				if (juncNm6[i] != null)
					model.setJuncNm6(juncNm6[i]);
				if (agmtNo5[i] != null)
					model.setAgmtNo5(agmtNo5[i]);
				if (agmtNo4[i] != null)
					model.setAgmtNo4(agmtNo4[i]);
				if (agmtNo3[i] != null)
					model.setAgmtNo3(agmtNo3[i]);
				if (agmtNo2[i] != null)
					model.setAgmtNo2(agmtNo2[i]);
				if (agmtNo1[i] != null)
					model.setAgmtNo1(agmtNo1[i]);
				if (comFlg6[i] != null)
					model.setComFlg6(comFlg6[i]);
				if (comFlg5[i] != null)
					model.setComFlg5(comFlg5[i]);
				if (comFlg4[i] != null)
					model.setComFlg4(comFlg4[i]);
				if (comFlg3[i] != null)
					model.setComFlg3(comFlg3[i]);
				if (comFlg2[i] != null)
					model.setComFlg2(comFlg2[i]);
				if (comFlg1[i] != null)
					model.setComFlg1(comFlg1[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (agmtNo6[i] != null)
					model.setAgmtNo6(agmtNo6[i]);
				if (fmtTztmHrs1[i] != null)
					model.setFmtTztmHrs1(fmtTztmHrs1[i]);
				if (ioType[i] != null)
					model.setIoType(ioType[i]);
				if (fmtTztmHrs2[i] != null)
					model.setFmtTztmHrs2(fmtTztmHrs2[i]);
				if (fmtTztmHrs3[i] != null)
					model.setFmtTztmHrs3(fmtTztmHrs3[i]);
				if (fmtTztmHrs4[i] != null)
					model.setFmtTztmHrs4(fmtTztmHrs4[i]);
				if (fmtTztmHrs5[i] != null)
					model.setFmtTztmHrs5(fmtTztmHrs5[i]);
				if (inlndRoutBkgFlg[i] != null)
					model.setInlndRoutBkgFlg(inlndRoutBkgFlg[i]);
				if (n3rdAgmtRefNo[i] != null)
					model.setN3rdAgmtRefNo(n3rdAgmtRefNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (orgNode[i] != null)
					model.setOrgNode(orgNode[i]);
				if (n1stNode[i] != null)
					model.setN1stNode(n1stNode[i]);
				if (tm2[i] != null)
					model.setTm2(tm2[i]);
				if (tm1[i] != null)
					model.setTm1(tm1[i]);
				if (tm4[i] != null)
					model.setTm4(tm4[i]);
				if (tm3[i] != null)
					model.setTm3(tm3[i]);
				if (tm6[i] != null)
					model.setTm6(tm6[i]);
				if (tm5[i] != null)
					model.setTm5(tm5[i]);
				if (inlndRoutInclSttlFlg[i] != null)
					model.setInlndRoutInclSttlFlg(inlndRoutInclSttlFlg[i]);
				if (n5thTrspAgmtSeq[i] != null)
					model.setN5thTrspAgmtSeq(n5thTrspAgmtSeq[i]);
				if (nodeType[i] != null)
					model.setNodeType(nodeType[i]);
				if (n3rdNode[i] != null)
					model.setN3rdNode(n3rdNode[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (n5thAgmtRefNo[i] != null)
					model.setN5thAgmtRefNo(n5thAgmtRefNo[i]);
				if (n3rdTrspAgmtSeq[i] != null)
					model.setN3rdTrspAgmtSeq(n3rdTrspAgmtSeq[i]);
				if (wrsFullCmdt[i] != null)
					model.setWrsFullCmdt(wrsFullCmdt[i]);
				if (inlndRoutInvBilPattCd[i] != null)
					model.setInlndRoutInvBilPattCd(inlndRoutInvBilPattCd[i]);
				if (rdCrrTp3[i] != null)
					model.setRdCrrTp3(rdCrrTp3[i]);
				if (rdCrrTp4[i] != null)
					model.setRdCrrTp4(rdCrrTp4[i]);
				if (rdCrrTp1[i] != null)
					model.setRdCrrTp1(rdCrrTp1[i]);
				if (rdCrrTp2[i] != null)
					model.setRdCrrTp2(rdCrrTp2[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (rdCrrTp5[i] != null)
					model.setRdCrrTp5(rdCrrTp5[i]);
				if (rdCrrTp6[i] != null)
					model.setRdCrrTp6(rdCrrTp6[i]);
				if (n1stTrspAgmtSeq[i] != null)
					model.setN1stTrspAgmtSeq(n1stTrspAgmtSeq[i]);
				if (vndr1[i] != null)
					model.setVndr1(vndr1[i]);
				if (vndr3[i] != null)
					model.setVndr3(vndr3[i]);
				if (vndr2[i] != null)
					model.setVndr2(vndr2[i]);
				if (vndr5[i] != null)
					model.setVndr5(vndr5[i]);
				if (vndr4[i] != null)
					model.setVndr4(vndr4[i]);
				if (vndr6[i] != null)
					model.setVndr6(vndr6[i]);
				if (inlndRoutTmpFlg[i] != null)
					model.setInlndRoutTmpFlg(inlndRoutTmpFlg[i]);
				if (n4thTrspAgmtOfcCtyCd[i] != null)
					model.setN4thTrspAgmtOfcCtyCd(n4thTrspAgmtOfcCtyCd[i]);
				if (n2ndNode[i] != null)
					model.setN2ndNode(n2ndNode[i]);
				if (n5thTrspAgmtOfcCtyCd[i] != null)
					model.setN5thTrspAgmtOfcCtyCd(n5thTrspAgmtOfcCtyCd[i]);
				if (sumTtTime[i] != null)
					model.setSumTtTime(sumTtTime[i]);
				if (inlndRoutRmk6[i] != null)
					model.setInlndRoutRmk6(inlndRoutRmk6[i]);
				if (inlndRoutRmk5[i] != null)
					model.setInlndRoutRmk5(inlndRoutRmk5[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (inlndRoutRmk4[i] != null)
					model.setInlndRoutRmk4(inlndRoutRmk4[i]);
				if (inlndRoutRmk3[i] != null)
					model.setInlndRoutRmk3(inlndRoutRmk3[i]);
				if (inlndRoutRmk2[i] != null)
					model.setInlndRoutRmk2(inlndRoutRmk2[i]);
				if (inlndRoutRmk1[i] != null)
					model.setInlndRoutRmk1(inlndRoutRmk1[i]);
				if (n4thAgmtRefNo[i] != null)
					model.setN4thAgmtRefNo(n4thAgmtRefNo[i]);
				if (n5thNode[i] != null)
					model.setN5thNode(n5thNode[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (wrsMtyCmdtCd[i] != null)
					model.setWrsMtyCmdtCd(wrsMtyCmdtCd[i]);
				if (n4thNode[i] != null)
					model.setN4thNode(n4thNode[i]);
				if (n4thTrspAgmtSeq[i] != null)
					model.setN4thTrspAgmtSeq(n4thTrspAgmtSeq[i]);
				if (agmtRefNo1[i] != null)
					model.setAgmtRefNo1(agmtRefNo1[i]);
				if (agmtRefNo2[i] != null)
					model.setAgmtRefNo2(agmtRefNo2[i]);
				if (spName1[i] != null)
					model.setSpName1(spName1[i]);
				if (spName2[i] != null)
					model.setSpName2(spName2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spName3[i] != null)
					model.setSpName3(spName3[i]);
				if (spName4[i] != null)
					model.setSpName4(spName4[i]);
				if (agmtRefNo5[i] != null)
					model.setAgmtRefNo5(agmtRefNo5[i]);
				if (agmtRefNo6[i] != null)
					model.setAgmtRefNo6(agmtRefNo6[i]);
				if (spName5[i] != null)
					model.setSpName5(spName5[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (agmtRefNo3[i] != null)
					model.setAgmtRefNo3(agmtRefNo3[i]);
				if (spName6[i] != null)
					model.setSpName6(spName6[i]);
				if (agmtRefNo4[i] != null)
					model.setAgmtRefNo4(agmtRefNo4[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (n2ndTrspAgmtOfcCtyCd[i] != null)
					model.setN2ndTrspAgmtOfcCtyCd(n2ndTrspAgmtOfcCtyCd[i]);
				if (n6thNode[i] != null)
					model.setN6thNode(n6thNode[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n2ndAgmtRefNo[i] != null)
					model.setN2ndAgmtRefNo(n2ndAgmtRefNo[i]);
				if (destNode[i] != null)
					model.setDestNode(destNode[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (n2ndTrspAgmtSeq[i] != null)
					model.setN2ndTrspAgmtSeq(n2ndTrspAgmtSeq[i]);
				if (n1stTrspAgmtOfcCtyCd[i] != null)
					model.setN1stTrspAgmtOfcCtyCd(n1stTrspAgmtOfcCtyCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInlandRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInlandRouteVO[]
	 */
	public SearchInlandRouteVO[] getSearchInlandRouteVOs(){
		SearchInlandRouteVO[] vos = (SearchInlandRouteVO[])models.toArray(new SearchInlandRouteVO[models.size()]);
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
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAgmtRefNo = this.n1stAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.juncNm1 = this.juncNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTrspAgmtOfcCtyCd = this.n3rdTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.juncNm2 = this.juncNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.juncNm3 = this.juncNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.juncNm4 = this.juncNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.juncNm5 = this.juncNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.juncNm6 = this.juncNm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo5 = this.agmtNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo4 = this.agmtNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo3 = this.agmtNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo2 = this.agmtNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo1 = this.agmtNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg6 = this.comFlg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg5 = this.comFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg4 = this.comFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg3 = this.comFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg2 = this.comFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg1 = this.comFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo6 = this.agmtNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs1 = this.fmtTztmHrs1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioType = this.ioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs2 = this.fmtTztmHrs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs3 = this.fmtTztmHrs3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs4 = this.fmtTztmHrs4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs5 = this.fmtTztmHrs5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutBkgFlg = this.inlndRoutBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAgmtRefNo = this.n3rdAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNode = this.orgNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNode = this.n1stNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm2 = this.tm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm1 = this.tm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm4 = this.tm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm3 = this.tm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm6 = this.tm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm5 = this.tm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInclSttlFlg = this.inlndRoutInclSttlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thTrspAgmtSeq = this.n5thTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeType = this.nodeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNode = this.n3rdNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thAgmtRefNo = this.n5thAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTrspAgmtSeq = this.n3rdTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsFullCmdt = this.wrsFullCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInvBilPattCd = this.inlndRoutInvBilPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCrrTp3 = this.rdCrrTp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCrrTp4 = this.rdCrrTp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCrrTp1 = this.rdCrrTp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCrrTp2 = this.rdCrrTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCrrTp5 = this.rdCrrTp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCrrTp6 = this.rdCrrTp6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTrspAgmtSeq = this.n1stTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr1 = this.vndr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr3 = this.vndr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr2 = this.vndr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr5 = this.vndr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr4 = this.vndr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr6 = this.vndr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutTmpFlg = this.inlndRoutTmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thTrspAgmtOfcCtyCd = this.n4thTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNode = this.n2ndNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thTrspAgmtOfcCtyCd = this.n5thTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtTime = this.sumTtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk6 = this.inlndRoutRmk6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk5 = this.inlndRoutRmk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk4 = this.inlndRoutRmk4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk3 = this.inlndRoutRmk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk2 = this.inlndRoutRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk1 = this.inlndRoutRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thAgmtRefNo = this.n4thAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thNode = this.n5thNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsMtyCmdtCd = this.wrsMtyCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNode = this.n4thNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thTrspAgmtSeq = this.n4thTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo1 = this.agmtRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo2 = this.agmtRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName1 = this.spName1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName2 = this.spName2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName3 = this.spName3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName4 = this.spName4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo5 = this.agmtRefNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo6 = this.agmtRefNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName5 = this.spName5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo3 = this.agmtRefNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName6 = this.spName6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo4 = this.agmtRefNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTrspAgmtOfcCtyCd = this.n2ndTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thNode = this.n6thNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAgmtRefNo = this.n2ndAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNode = this.destNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTrspAgmtSeq = this.n2ndTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTrspAgmtOfcCtyCd = this.n1stTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
