/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExceptionalRouteVO.java
*@FileTitle : ExceptionalRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.04.05 함대성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExceptionalRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExceptionalRouteVO> models = new ArrayList<ExceptionalRouteVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delPortCd = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String polPortCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String n1stPolCd = null;
	/* Column Info */
	private String partnerId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String n1stLaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lnkKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podPortCd = null;
	/* Column Info */
	private String n3rdPolCd = null;
	/* Column Info */
	private String n3rdSkdDirCd = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String n2ndSkdDirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String partnerName = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String usrRmk = null;
	/* Column Info */
	private String n2ndLaneCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String porPortCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n2ndPolCd = null;
	/* Column Info */
	private String n3rdLaneCd = null;
	/* Column Info */
	private String n1stSkdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExceptionalRouteVO() {}

	public ExceptionalRouteVO(String ibflag, String pagerows, String routSeq, String custTrdPrnrId, String lnkKnt, String porCd, String orgLocCd, String n1stPolCd, String n1stLaneCd, String n1stPodCd, String n1stSkdDirCd, String n2ndPolCd, String n2ndLaneCd, String n3rdLaneCd, String n2ndPodCd, String n3rdPolCd, String n2ndSkdDirCd, String n3rdSkdDirCd, String destLocCd, String delCd, String usrRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String partnerName, String delPortCd, String polPortCd, String partnerId, String porPortCd, String podPortCd) {
		this.porCd = porCd;
		this.delPortCd = delPortCd;
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.polPortCd = polPortCd;
		this.deltFlg = deltFlg;
		this.n1stPolCd = n1stPolCd;
		this.partnerId = partnerId;
		this.creDt = creDt;
		this.n2ndPodCd = n2ndPodCd;
		this.n1stLaneCd = n1stLaneCd;
		this.pagerows = pagerows;
		this.lnkKnt = lnkKnt;
		this.ibflag = ibflag;
		this.podPortCd = podPortCd;
		this.n3rdPolCd = n3rdPolCd;
		this.n3rdSkdDirCd = n3rdSkdDirCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.n2ndSkdDirCd = n2ndSkdDirCd;
		this.updUsrId = updUsrId;
		this.partnerName = partnerName;
		this.updDt = updDt;
		this.n1stPodCd = n1stPodCd;
		this.usrRmk = usrRmk;
		this.n2ndLaneCd = n2ndLaneCd;
		this.delCd = delCd;
		this.porPortCd = porPortCd;
		this.routSeq = routSeq;
		this.creUsrId = creUsrId;
		this.n2ndPolCd = n2ndPolCd;
		this.n3rdLaneCd = n3rdLaneCd;
		this.n1stSkdDirCd = n1stSkdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_port_cd", getDelPortCd());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("pol_port_cd", getPolPortCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("n1st_pol_cd", getN1stPolCd());
		this.hashColumns.put("partner_id", getPartnerId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("n1st_lane_cd", getN1stLaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lnk_knt", getLnkKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_port_cd", getPodPortCd());
		this.hashColumns.put("n3rd_pol_cd", getN3rdPolCd());
		this.hashColumns.put("n3rd_skd_dir_cd", getN3rdSkdDirCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("n2nd_skd_dir_cd", getN2ndSkdDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("partner_name", getPartnerName());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("usr_rmk", getUsrRmk());
		this.hashColumns.put("n2nd_lane_cd", getN2ndLaneCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("por_port_cd", getPorPortCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n2nd_pol_cd", getN2ndPolCd());
		this.hashColumns.put("n3rd_lane_cd", getN3rdLaneCd());
		this.hashColumns.put("n1st_skd_dir_cd", getN1stSkdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_port_cd", "delPortCd");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("pol_port_cd", "polPortCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("n1st_pol_cd", "n1stPolCd");
		this.hashFields.put("partner_id", "partnerId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("n1st_lane_cd", "n1stLaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lnk_knt", "lnkKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_port_cd", "podPortCd");
		this.hashFields.put("n3rd_pol_cd", "n3rdPolCd");
		this.hashFields.put("n3rd_skd_dir_cd", "n3rdSkdDirCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("n2nd_skd_dir_cd", "n2ndSkdDirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("partner_name", "partnerName");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("usr_rmk", "usrRmk");
		this.hashFields.put("n2nd_lane_cd", "n2ndLaneCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("por_port_cd", "porPortCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n2nd_pol_cd", "n2ndPolCd");
		this.hashFields.put("n3rd_lane_cd", "n3rdLaneCd");
		this.hashFields.put("n1st_skd_dir_cd", "n1stSkdDirCd");
		return this.hashFields;
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
	 * @return delPortCd
	 */
	public String getDelPortCd() {
		return this.delPortCd;
	}
	
	/**
	 * Column Info
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return polPortCd
	 */
	public String getPolPortCd() {
		return this.polPortCd;
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
	 * @return n1stPolCd
	 */
	public String getN1stPolCd() {
		return this.n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @return partnerId
	 */
	public String getPartnerId() {
		return this.partnerId;
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
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @return n1stLaneCd
	 */
	public String getN1stLaneCd() {
		return this.n1stLaneCd;
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
	 * @return lnkKnt
	 */
	public String getLnkKnt() {
		return this.lnkKnt;
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
	 * @return podPortCd
	 */
	public String getPodPortCd() {
		return this.podPortCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolCd
	 */
	public String getN3rdPolCd() {
		return this.n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdSkdDirCd
	 */
	public String getN3rdSkdDirCd() {
		return this.n3rdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return n2ndSkdDirCd
	 */
	public String getN2ndSkdDirCd() {
		return this.n2ndSkdDirCd;
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
	 * @return partnerName
	 */
	public String getPartnerName() {
		return this.partnerName;
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
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @return usrRmk
	 */
	public String getUsrRmk() {
		return this.usrRmk;
	}
	
	/**
	 * Column Info
	 * @return n2ndLaneCd
	 */
	public String getN2ndLaneCd() {
		return this.n2ndLaneCd;
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
	 * @return porPortCd
	 */
	public String getPorPortCd() {
		return this.porPortCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolCd
	 */
	public String getN2ndPolCd() {
		return this.n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdLaneCd
	 */
	public String getN3rdLaneCd() {
		return this.n3rdLaneCd;
	}
	
	/**
	 * Column Info
	 * @return n1stSkdDirCd
	 */
	public String getN1stSkdDirCd() {
		return this.n1stSkdDirCd;
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
	 * @param delPortCd
	 */
	public void setDelPortCd(String delPortCd) {
		this.delPortCd = delPortCd;
	}
	
	/**
	 * Column Info
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param polPortCd
	 */
	public void setPolPortCd(String polPortCd) {
		this.polPortCd = polPortCd;
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
	 * @param n1stPolCd
	 */
	public void setN1stPolCd(String n1stPolCd) {
		this.n1stPolCd = n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @param partnerId
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
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
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @param n1stLaneCd
	 */
	public void setN1stLaneCd(String n1stLaneCd) {
		this.n1stLaneCd = n1stLaneCd;
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
	 * @param lnkKnt
	 */
	public void setLnkKnt(String lnkKnt) {
		this.lnkKnt = lnkKnt;
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
	 * @param podPortCd
	 */
	public void setPodPortCd(String podPortCd) {
		this.podPortCd = podPortCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolCd
	 */
	public void setN3rdPolCd(String n3rdPolCd) {
		this.n3rdPolCd = n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdSkdDirCd
	 */
	public void setN3rdSkdDirCd(String n3rdSkdDirCd) {
		this.n3rdSkdDirCd = n3rdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param n2ndSkdDirCd
	 */
	public void setN2ndSkdDirCd(String n2ndSkdDirCd) {
		this.n2ndSkdDirCd = n2ndSkdDirCd;
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
	 * @param partnerName
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
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
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @param usrRmk
	 */
	public void setUsrRmk(String usrRmk) {
		this.usrRmk = usrRmk;
	}
	
	/**
	 * Column Info
	 * @param n2ndLaneCd
	 */
	public void setN2ndLaneCd(String n2ndLaneCd) {
		this.n2ndLaneCd = n2ndLaneCd;
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
	 * @param porPortCd
	 */
	public void setPorPortCd(String porPortCd) {
		this.porPortCd = porPortCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolCd
	 */
	public void setN2ndPolCd(String n2ndPolCd) {
		this.n2ndPolCd = n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdLaneCd
	 */
	public void setN3rdLaneCd(String n3rdLaneCd) {
		this.n3rdLaneCd = n3rdLaneCd;
	}
	
	/**
	 * Column Info
	 * @param n1stSkdDirCd
	 */
	public void setN1stSkdDirCd(String n1stSkdDirCd) {
		this.n1stSkdDirCd = n1stSkdDirCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDelPortCd(JSPUtil.getParameter(request, prefix + "del_port_cd", ""));
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setPolPortCd(JSPUtil.getParameter(request, prefix + "pol_port_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setN1stPolCd(JSPUtil.getParameter(request, prefix + "n1st_pol_cd", ""));
		setPartnerId(JSPUtil.getParameter(request, prefix + "partner_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, prefix + "n2nd_pod_cd", ""));
		setN1stLaneCd(JSPUtil.getParameter(request, prefix + "n1st_lane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLnkKnt(JSPUtil.getParameter(request, prefix + "lnk_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodPortCd(JSPUtil.getParameter(request, prefix + "pod_port_cd", ""));
		setN3rdPolCd(JSPUtil.getParameter(request, prefix + "n3rd_pol_cd", ""));
		setN3rdSkdDirCd(JSPUtil.getParameter(request, prefix + "n3rd_skd_dir_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setN2ndSkdDirCd(JSPUtil.getParameter(request, prefix + "n2nd_skd_dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPartnerName(JSPUtil.getParameter(request, prefix + "partner_name", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN1stPodCd(JSPUtil.getParameter(request, prefix + "n1st_pod_cd", ""));
		setUsrRmk(JSPUtil.getParameter(request, prefix + "usr_rmk", ""));
		setN2ndLaneCd(JSPUtil.getParameter(request, prefix + "n2nd_lane_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPorPortCd(JSPUtil.getParameter(request, prefix + "por_port_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN2ndPolCd(JSPUtil.getParameter(request, prefix + "n2nd_pol_cd", ""));
		setN3rdLaneCd(JSPUtil.getParameter(request, prefix + "n3rd_lane_cd", ""));
		setN1stSkdDirCd(JSPUtil.getParameter(request, prefix + "n1st_skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExceptionalRouteVO[]
	 */
	public ExceptionalRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExceptionalRouteVO[]
	 */
	public ExceptionalRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExceptionalRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delPortCd = (JSPUtil.getParameter(request, prefix	+ "del_port_cd", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] polPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_port_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] n1stPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_cd", length));
			String[] partnerId = (JSPUtil.getParameter(request, prefix	+ "partner_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] n1stLaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_lane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lnkKnt = (JSPUtil.getParameter(request, prefix	+ "lnk_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_port_cd", length));
			String[] n3rdPolCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_cd", length));
			String[] n3rdSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_skd_dir_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] n2ndSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_skd_dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] partnerName = (JSPUtil.getParameter(request, prefix	+ "partner_name", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] usrRmk = (JSPUtil.getParameter(request, prefix	+ "usr_rmk", length));
			String[] n2ndLaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_lane_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] porPortCd = (JSPUtil.getParameter(request, prefix	+ "por_port_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n2ndPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_cd", length));
			String[] n3rdLaneCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_lane_cd", length));
			String[] n1stSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_skd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExceptionalRouteVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delPortCd[i] != null)
					model.setDelPortCd(delPortCd[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (polPortCd[i] != null)
					model.setPolPortCd(polPortCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (n1stPolCd[i] != null)
					model.setN1stPolCd(n1stPolCd[i]);
				if (partnerId[i] != null)
					model.setPartnerId(partnerId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (n1stLaneCd[i] != null)
					model.setN1stLaneCd(n1stLaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lnkKnt[i] != null)
					model.setLnkKnt(lnkKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podPortCd[i] != null)
					model.setPodPortCd(podPortCd[i]);
				if (n3rdPolCd[i] != null)
					model.setN3rdPolCd(n3rdPolCd[i]);
				if (n3rdSkdDirCd[i] != null)
					model.setN3rdSkdDirCd(n3rdSkdDirCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (n2ndSkdDirCd[i] != null)
					model.setN2ndSkdDirCd(n2ndSkdDirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (partnerName[i] != null)
					model.setPartnerName(partnerName[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (usrRmk[i] != null)
					model.setUsrRmk(usrRmk[i]);
				if (n2ndLaneCd[i] != null)
					model.setN2ndLaneCd(n2ndLaneCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (porPortCd[i] != null)
					model.setPorPortCd(porPortCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n2ndPolCd[i] != null)
					model.setN2ndPolCd(n2ndPolCd[i]);
				if (n3rdLaneCd[i] != null)
					model.setN3rdLaneCd(n3rdLaneCd[i]);
				if (n1stSkdDirCd[i] != null)
					model.setN1stSkdDirCd(n1stSkdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExceptionalRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExceptionalRouteVO[]
	 */
	public ExceptionalRouteVO[] getExceptionalRouteVOs(){
		ExceptionalRouteVO[] vos = (ExceptionalRouteVO[])models.toArray(new ExceptionalRouteVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delPortCd = this.delPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPortCd = this.polPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolCd = this.n1stPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partnerId = this.partnerId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLaneCd = this.n1stLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkKnt = this.lnkKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPortCd = this.podPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolCd = this.n3rdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdSkdDirCd = this.n3rdSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndSkdDirCd = this.n2ndSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partnerName = this.partnerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRmk = this.usrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndLaneCd = this.n2ndLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porPortCd = this.porPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolCd = this.n2ndPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLaneCd = this.n3rdLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSkdDirCd = this.n1stSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
