/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdInlndEachLnkVO.java
*@FileTitle : PrdInlndEachLnkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.17 김귀진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdInlndEachLnkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdInlndEachLnkVO> models = new ArrayList<PrdInlndEachLnkVO>();
	
	/* Column Info */
	private String iResult = null;
	/* Column Info */
	private String orgType = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String validUpdateRoute = null;
	/* Column Info */
	private String vndrName = null;
	/* Column Info */
	private String railCrrTpCd = null;
	/* Column Info */
	private String iOrgCd = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lnkOrgNodCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String unmatch = null;
	/* Column Info */
	private String distUtCd = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String destType = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String lnkDestNodCd = null;
	/* Column Info */
	private String validAgmtNoRoute = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String fmtTztmHrs = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String iDestCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String iAgmtNo = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String iAgmtSeq = null;
	/* Column Info */
	private String spCd = null;
	/* Column Info */
	private String fc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ctyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdInlndEachLnkVO() {}

	public PrdInlndEachLnkVO(String ibflag, String pagerows, String orgLoc, String orgType, String destLoc, String destType, String trspModCd, String vndrSeq, String vndrCntCd, String spCd, String vndrName, String fmtTztmHrs, String lnkDist, String distUtCd, String railCrrTpCd, String lnkOrgNodCd, String lnkDestNodCd, String tztmHrs, String fc, String trspAgmtOfcCtyCd, String trspAgmtSeq, String agmtNo, String agmtRefNo, String unmatch, String iOrgCd, String creOfcCd, String updUsrId, String agmtSeq, String iDestCd, String iAgmtNo, String iAgmtSeq, String creUsrId, String ctyCd, String iResult, String result, String validAgmtNoRoute, String validUpdateRoute) {
		this.iResult = iResult;
		this.orgType = orgType;
		this.result = result;
		this.vndrCntCd = vndrCntCd;
		this.validUpdateRoute = validUpdateRoute;
		this.vndrName = vndrName;
		this.railCrrTpCd = railCrrTpCd;
		this.iOrgCd = iOrgCd;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.tztmHrs = tztmHrs;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lnkOrgNodCd = lnkOrgNodCd;
		this.creOfcCd = creOfcCd;
		this.unmatch = unmatch;
		this.distUtCd = distUtCd;
		this.orgLoc = orgLoc;
		this.updUsrId = updUsrId;
		this.destType = destType;
		this.agmtRefNo = agmtRefNo;
		this.lnkDestNodCd = lnkDestNodCd;
		this.validAgmtNoRoute = validAgmtNoRoute;
		this.lnkDist = lnkDist;
		this.fmtTztmHrs = fmtTztmHrs;
		this.agmtSeq = agmtSeq;
		this.iDestCd = iDestCd;
		this.agmtNo = agmtNo;
		this.iAgmtNo = iAgmtNo;
		this.destLoc = destLoc;
		this.iAgmtSeq = iAgmtSeq;
		this.spCd = spCd;
		this.fc = fc;
		this.creUsrId = creUsrId;
		this.trspAgmtSeq = trspAgmtSeq;
		this.vndrSeq = vndrSeq;
		this.ctyCd = ctyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("i_result", getIResult());
		this.hashColumns.put("org_type", getOrgType());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("valid_update_route", getValidUpdateRoute());
		this.hashColumns.put("vndr_name", getVndrName());
		this.hashColumns.put("rail_crr_tp_cd", getRailCrrTpCd());
		this.hashColumns.put("i_org_cd", getIOrgCd());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lnk_org_nod_cd", getLnkOrgNodCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("unmatch", getUnmatch());
		this.hashColumns.put("dist_ut_cd", getDistUtCd());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dest_type", getDestType());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("lnk_dest_nod_cd", getLnkDestNodCd());
		this.hashColumns.put("valid_agmt_no_route", getValidAgmtNoRoute());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("fmt_tztm_hrs", getFmtTztmHrs());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("i_dest_cd", getIDestCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("i_agmt_no", getIAgmtNo());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("i_agmt_seq", getIAgmtSeq());
		this.hashColumns.put("sp_cd", getSpCd());
		this.hashColumns.put("fc", getFc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cty_cd", getCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("i_result", "iResult");
		this.hashFields.put("org_type", "orgType");
		this.hashFields.put("result", "result");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("valid_update_route", "validUpdateRoute");
		this.hashFields.put("vndr_name", "vndrName");
		this.hashFields.put("rail_crr_tp_cd", "railCrrTpCd");
		this.hashFields.put("i_org_cd", "iOrgCd");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lnk_org_nod_cd", "lnkOrgNodCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("unmatch", "unmatch");
		this.hashFields.put("dist_ut_cd", "distUtCd");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dest_type", "destType");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("lnk_dest_nod_cd", "lnkDestNodCd");
		this.hashFields.put("valid_agmt_no_route", "validAgmtNoRoute");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("fmt_tztm_hrs", "fmtTztmHrs");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("i_dest_cd", "iDestCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("i_agmt_no", "iAgmtNo");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("i_agmt_seq", "iAgmtSeq");
		this.hashFields.put("sp_cd", "spCd");
		this.hashFields.put("fc", "fc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cty_cd", "ctyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iResult
	 */
	public String getIResult() {
		return this.iResult;
	}
	
	/**
	 * Column Info
	 * @return orgType
	 */
	public String getOrgType() {
		return this.orgType;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return validUpdateRoute
	 */
	public String getValidUpdateRoute() {
		return this.validUpdateRoute;
	}
	
	/**
	 * Column Info
	 * @return vndrName
	 */
	public String getVndrName() {
		return this.vndrName;
	}
	
	/**
	 * Column Info
	 * @return railCrrTpCd
	 */
	public String getRailCrrTpCd() {
		return this.railCrrTpCd;
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
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return lnkOrgNodCd
	 */
	public String getLnkOrgNodCd() {
		return this.lnkOrgNodCd;
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
	 * @return unmatch
	 */
	public String getUnmatch() {
		return this.unmatch;
	}
	
	/**
	 * Column Info
	 * @return distUtCd
	 */
	public String getDistUtCd() {
		return this.distUtCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return destType
	 */
	public String getDestType() {
		return this.destType;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return lnkDestNodCd
	 */
	public String getLnkDestNodCd() {
		return this.lnkDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return validAgmtNoRoute
	 */
	public String getValidAgmtNoRoute() {
		return this.validAgmtNoRoute;
	}
	
	/**
	 * Column Info
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs
	 */
	public String getFmtTztmHrs() {
		return this.fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return iAgmtNo
	 */
	public String getIAgmtNo() {
		return this.iAgmtNo;
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
	 * @return iAgmtSeq
	 */
	public String getIAgmtSeq() {
		return this.iAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return spCd
	 */
	public String getSpCd() {
		return this.spCd;
	}
	
	/**
	 * Column Info
	 * @return fc
	 */
	public String getFc() {
		return this.fc;
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
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ctyCd
	 */
	public String getCtyCd() {
		return this.ctyCd;
	}
	

	/**
	 * Column Info
	 * @param iResult
	 */
	public void setIResult(String iResult) {
		this.iResult = iResult;
	}
	
	/**
	 * Column Info
	 * @param orgType
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param validUpdateRoute
	 */
	public void setValidUpdateRoute(String validUpdateRoute) {
		this.validUpdateRoute = validUpdateRoute;
	}
	
	/**
	 * Column Info
	 * @param vndrName
	 */
	public void setVndrName(String vndrName) {
		this.vndrName = vndrName;
	}
	
	/**
	 * Column Info
	 * @param railCrrTpCd
	 */
	public void setRailCrrTpCd(String railCrrTpCd) {
		this.railCrrTpCd = railCrrTpCd;
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
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param lnkOrgNodCd
	 */
	public void setLnkOrgNodCd(String lnkOrgNodCd) {
		this.lnkOrgNodCd = lnkOrgNodCd;
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
	 * @param unmatch
	 */
	public void setUnmatch(String unmatch) {
		this.unmatch = unmatch;
	}
	
	/**
	 * Column Info
	 * @param distUtCd
	 */
	public void setDistUtCd(String distUtCd) {
		this.distUtCd = distUtCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param destType
	 */
	public void setDestType(String destType) {
		this.destType = destType;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param lnkDestNodCd
	 */
	public void setLnkDestNodCd(String lnkDestNodCd) {
		this.lnkDestNodCd = lnkDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param validAgmtNoRoute
	 */
	public void setValidAgmtNoRoute(String validAgmtNoRoute) {
		this.validAgmtNoRoute = validAgmtNoRoute;
	}
	
	/**
	 * Column Info
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs
	 */
	public void setFmtTztmHrs(String fmtTztmHrs) {
		this.fmtTztmHrs = fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param iAgmtNo
	 */
	public void setIAgmtNo(String iAgmtNo) {
		this.iAgmtNo = iAgmtNo;
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
	 * @param iAgmtSeq
	 */
	public void setIAgmtSeq(String iAgmtSeq) {
		this.iAgmtSeq = iAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param spCd
	 */
	public void setSpCd(String spCd) {
		this.spCd = spCd;
	}
	
	/**
	 * Column Info
	 * @param fc
	 */
	public void setFc(String fc) {
		this.fc = fc;
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
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ctyCd
	 */
	public void setCtyCd(String ctyCd) {
		this.ctyCd = ctyCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIResult(JSPUtil.getParameter(request, "i_result", ""));
		setOrgType(JSPUtil.getParameter(request, "org_type", ""));
		setResult(JSPUtil.getParameter(request, "result", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setValidUpdateRoute(JSPUtil.getParameter(request, "valid_update_route", ""));
		setVndrName(JSPUtil.getParameter(request, "vndr_name", ""));
		setRailCrrTpCd(JSPUtil.getParameter(request, "rail_crr_tp_cd", ""));
		setIOrgCd(JSPUtil.getParameter(request, "i_org_cd", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, "trsp_agmt_ofc_cty_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLnkOrgNodCd(JSPUtil.getParameter(request, "lnk_org_nod_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUnmatch(JSPUtil.getParameter(request, "unmatch", ""));
		setDistUtCd(JSPUtil.getParameter(request, "dist_ut_cd", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDestType(JSPUtil.getParameter(request, "dest_type", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setLnkDestNodCd(JSPUtil.getParameter(request, "lnk_dest_nod_cd", ""));
		setValidAgmtNoRoute(JSPUtil.getParameter(request, "valid_agmt_no_route", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setFmtTztmHrs(JSPUtil.getParameter(request, "fmt_tztm_hrs", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setIDestCd(JSPUtil.getParameter(request, "i_dest_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setIAgmtNo(JSPUtil.getParameter(request, "i_agmt_no", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setIAgmtSeq(JSPUtil.getParameter(request, "i_agmt_seq", ""));
		setSpCd(JSPUtil.getParameter(request, "sp_cd", ""));
		setFc(JSPUtil.getParameter(request, "fc", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, "trsp_agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCtyCd(JSPUtil.getParameter(request, "cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdInlndEachLnkVO[]
	 */
	public PrdInlndEachLnkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdInlndEachLnkVO[]
	 */
	public PrdInlndEachLnkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdInlndEachLnkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iResult = (JSPUtil.getParameter(request, prefix	+ "i_result", length));
			String[] orgType = (JSPUtil.getParameter(request, prefix	+ "org_type", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] validUpdateRoute = (JSPUtil.getParameter(request, prefix	+ "valid_update_route", length));
			String[] vndrName = (JSPUtil.getParameter(request, prefix	+ "vndr_name", length));
			String[] railCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_crr_tp_cd", length));
			String[] iOrgCd = (JSPUtil.getParameter(request, prefix	+ "i_org_cd", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lnkOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "lnk_org_nod_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] unmatch = (JSPUtil.getParameter(request, prefix	+ "unmatch", length));
			String[] distUtCd = (JSPUtil.getParameter(request, prefix	+ "dist_ut_cd", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix	+ "org_loc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] destType = (JSPUtil.getParameter(request, prefix	+ "dest_type", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] lnkDestNodCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dest_nod_cd", length));
			String[] validAgmtNoRoute = (JSPUtil.getParameter(request, prefix	+ "valid_agmt_no_route", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] fmtTztmHrs = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] iDestCd = (JSPUtil.getParameter(request, prefix	+ "i_dest_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] iAgmtNo = (JSPUtil.getParameter(request, prefix	+ "i_agmt_no", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] iAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "i_agmt_seq", length));
			String[] spCd = (JSPUtil.getParameter(request, prefix	+ "sp_cd", length));
			String[] fc = (JSPUtil.getParameter(request, prefix	+ "fc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ctyCd = (JSPUtil.getParameter(request, prefix	+ "cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdInlndEachLnkVO();
				if (iResult[i] != null)
					model.setIResult(iResult[i]);
				if (orgType[i] != null)
					model.setOrgType(orgType[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (validUpdateRoute[i] != null)
					model.setValidUpdateRoute(validUpdateRoute[i]);
				if (vndrName[i] != null)
					model.setVndrName(vndrName[i]);
				if (railCrrTpCd[i] != null)
					model.setRailCrrTpCd(railCrrTpCd[i]);
				if (iOrgCd[i] != null)
					model.setIOrgCd(iOrgCd[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lnkOrgNodCd[i] != null)
					model.setLnkOrgNodCd(lnkOrgNodCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (unmatch[i] != null)
					model.setUnmatch(unmatch[i]);
				if (distUtCd[i] != null)
					model.setDistUtCd(distUtCd[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (destType[i] != null)
					model.setDestType(destType[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (lnkDestNodCd[i] != null)
					model.setLnkDestNodCd(lnkDestNodCd[i]);
				if (validAgmtNoRoute[i] != null)
					model.setValidAgmtNoRoute(validAgmtNoRoute[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (fmtTztmHrs[i] != null)
					model.setFmtTztmHrs(fmtTztmHrs[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (iDestCd[i] != null)
					model.setIDestCd(iDestCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (iAgmtNo[i] != null)
					model.setIAgmtNo(iAgmtNo[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (iAgmtSeq[i] != null)
					model.setIAgmtSeq(iAgmtSeq[i]);
				if (spCd[i] != null)
					model.setSpCd(spCd[i]);
				if (fc[i] != null)
					model.setFc(fc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ctyCd[i] != null)
					model.setCtyCd(ctyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdInlndEachLnkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdInlndEachLnkVO[]
	 */
	public PrdInlndEachLnkVO[] getPrdInlndEachLnkVOs(){
		PrdInlndEachLnkVO[] vos = (PrdInlndEachLnkVO[])models.toArray(new PrdInlndEachLnkVO[models.size()]);
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
		this.iResult = this.iResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgType = this.orgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validUpdateRoute = this.validUpdateRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrName = this.vndrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrTpCd = this.railCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOrgCd = this.iOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgNodCd = this.lnkOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmatch = this.unmatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distUtCd = this.distUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destType = this.destType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestNodCd = this.lnkDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validAgmtNoRoute = this.validAgmtNoRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs = this.fmtTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDestCd = this.iDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iAgmtNo = this.iAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iAgmtSeq = this.iAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCd = this.spCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc = this.fc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyCd = this.ctyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
