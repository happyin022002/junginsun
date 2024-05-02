/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ProductCatalogInternalMst_1VO.java
 *@FileTitle : ProductCatalogInternalMst_1VO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.02  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
public class ProductCatalogInternalMst_1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ProductCatalogInternalMst_1VO> models = new ArrayList<ProductCatalogInternalMst_1VO>();

	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String totalCost = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String cmlTtlTztmHrs = null;
	/* Column Info */
	private String cmlOcnTztmHrs = null;
	/* Column Info */
	private String cmlInlndTztmHrs = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* Column Info */
	private String remarkImg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String trnkAvalSpc = null;
	/* Column Info */
	private String routFlag = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String trnkLane = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String tsRoute = null;
	/* Column Info */
	private String routCnstSeq = null;
	/* Column Info */
	private String ttlTztmHrs = null;
	/* Column Info */
	private String trnkVvd = null;
	/* Column Info */
	private String ocnRoutPrioCd = null;
	/* Column Info */
	private String portCct = null;
	/* Column Info */
	private String fulRtnCct = null;
	/* Column Info */
	private String lastAvailDt = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String podNodCd = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public ProductCatalogInternalMst_1VO() {
	}

	public ProductCatalogInternalMst_1VO(String ibflag, String pagerows, String porCd, String obItchgCtnt, String polCd, String tsRoute, String podCd, String ibItchgCtnt, String delCd, String ttlTztmHrs, String remarkImg, String remark, String totalCost, String trnkAvalSpc, String pctlNo,
			String trnkVvd, String trnkLane, String mtyPkupYdCd, String porNodCd, String delNodCd, String routCnstSeq, String routFlag, String ord, String cmlOcnTztmHrs, String cmlTtlTztmHrs, String cmlInlndTztmHrs, String ocnRoutPrioCd, String portCct, String fulRtnCct, String lastAvailDt,
			String polNodCd, String podNodCd) {
		this.porCd = porCd;
		this.totalCost = totalCost;
		this.remark = remark;
		this.cmlTtlTztmHrs = cmlTtlTztmHrs;
		this.cmlOcnTztmHrs = cmlOcnTztmHrs;
		this.cmlInlndTztmHrs = cmlInlndTztmHrs;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.ord = ord;
		this.ibItchgCtnt = ibItchgCtnt;
		this.remarkImg = remarkImg;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.obItchgCtnt = obItchgCtnt;
		this.trnkAvalSpc = trnkAvalSpc;
		this.routFlag = routFlag;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.delNodCd = delNodCd;
		this.porNodCd = porNodCd;
		this.delCd = delCd;
		this.trnkLane = trnkLane;
		this.podCd = podCd;
		this.tsRoute = tsRoute;
		this.routCnstSeq = routCnstSeq;
		this.ttlTztmHrs = ttlTztmHrs;
		this.trnkVvd = trnkVvd;
		this.ocnRoutPrioCd = ocnRoutPrioCd;
		this.portCct = portCct;
		this.fulRtnCct = fulRtnCct;
		this.lastAvailDt = lastAvailDt;
		this.polNodCd = polNodCd;
		this.podNodCd = podNodCd;

	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("total_cost", getTotalCost());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("cml_ttl_tztm_hrs", getCmlTtlTztmHrs());
		this.hashColumns.put("cml_ocn_tztm_hrs", getCmlOcnTztmHrs());
		this.hashColumns.put("cml_inlnd_tztm_hrs", getCmlInlndTztmHrs());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("remark_img", getRemarkImg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("trnk_aval_spc", getTrnkAvalSpc());
		this.hashColumns.put("rout_flag", getRoutFlag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("trnk_lane", getTrnkLane());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ts_route", getTsRoute());
		this.hashColumns.put("rout_cnst_seq", getRoutCnstSeq());
		this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		this.hashColumns.put("ocn_rout_prio_cd", getOcnRoutPrioCd());
		this.hashColumns.put("port_cct", getPortCct());
		this.hashColumns.put("ful_rtn_cct", getFulRtnCct());
		this.hashColumns.put("last_avail_dt", getLastAvailDt());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("total_cost", "totalCost");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("cml_ttl_tztm_hrs", "cmlTtlTztmHrs");
		this.hashFields.put("cml_ocn_tztm_hrs", "cmlOcnTztmHrs");
		this.hashFields.put("cml_inlnd_tztm_hrs", "cmlInlndTztmHrs");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("remark_img", "remarkImg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("trnk_aval_spc", "trnkAvalSpc");
		this.hashFields.put("rout_flag", "routFlag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("trnk_lane", "trnkLane");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ts_route", "tsRoute");
		this.hashFields.put("rout_cnst_seq", "routCnstSeq");
		this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		this.hashFields.put("ocn_rout_prio_cd", "ocnRoutPrioCd");
		this.hashFields.put("port_cct", "portCct");
		this.hashFields.put("ful_rtn_cct", "fulRtnCct");
		this.hashFields.put("last_avail_dt", "lastAvailDt");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * 
	 * @return totalCost
	 */
	public String getTotalCost() {
		return this.totalCost;
	}

	/**
	 * Column Info
	 * 
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * Column Info
	 * 
	 * @return cmlTtlTztmHrs
	 */
	public String getCmlTtlTztmHrs() {
		return this.cmlTtlTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @return cmlOcnTztmHrs
	 */
	public String getCmlOcnTztmHrs() {
		return this.cmlOcnTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}

	/**
	 * Column Info
	 * 
	 * @return ibItchgCtnt
	 */
	public String getIbItchgCtnt() {
		return this.ibItchgCtnt;
	}

	/**
	 * Column Info
	 * 
	 * @return remarkImg
	 */
	public String getRemarkImg() {
		return this.remarkImg;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}

	/**
	 * Column Info
	 * 
	 * @return obItchgCtnt
	 */
	public String getObItchgCtnt() {
		return this.obItchgCtnt;
	}

	/**
	 * Column Info
	 * 
	 * @return trnkAvalSpc
	 */
	public String getTrnkAvalSpc() {
		return this.trnkAvalSpc;
	}

	/**
	 * Column Info
	 * 
	 * @return routFlag
	 */
	public String getRoutFlag() {
		return this.routFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trnkLane
	 */
	public String getTrnkLane() {
		return this.trnkLane;
	}

	/**
	 * Column Info
	 * 
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * 
	 * @return tsRoute
	 */
	public String getTsRoute() {
		return this.tsRoute;
	}

	/**
	 * Column Info
	 * 
	 * @return routCnstSeq
	 */
	public String getRoutCnstSeq() {
		return this.routCnstSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return ttlTztmHrs
	 */
	public String getTtlTztmHrs() {
		return this.ttlTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
	}

	/**
	 * Column Info
	 * 
	 * @return ocnRoutPrioCd
	 */
	public String getOcnRoutPrioCd() {
		return this.ocnRoutPrioCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ttlTztmHrs
	 */
	public String getPortCct() {
		return this.portCct;
	}

	/**
	 * Column Info
	 * 
	 * @return trnkVvd
	 */
	public String getFulRtnCct() {
		return this.fulRtnCct;
	}

	/**
	 * Column Info
	 * 
	 * @return ocnRoutPrioCd
	 */
	public String getLastAvailDt() {
		return this.lastAvailDt;
	}

	/**
	 * Column Info
	 * 
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * 
	 * @param totalCost
	 */
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Column Info
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Column Info
	 * 
	 * @param cmlTtlTztmHrs
	 */
	public void setCmlTtlTztmHrs(String cmlTtlTztmHrs) {
		this.cmlTtlTztmHrs = cmlTtlTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @param cmlOcnTztmHrs
	 */
	public void setCmlOcnTztmHrs(String cmlOcnTztmHrs) {
		this.cmlOcnTztmHrs = cmlOcnTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}

	/**
	 * Column Info
	 * 
	 * @param ibItchgCtnt
	 */
	public void setIbItchgCtnt(String ibItchgCtnt) {
		this.ibItchgCtnt = ibItchgCtnt;
	}

	/**
	 * Column Info
	 * 
	 * @param remarkImg
	 */
	public void setRemarkImg(String remarkImg) {
		this.remarkImg = remarkImg;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}

	/**
	 * Column Info
	 * 
	 * @param obItchgCtnt
	 */
	public void setObItchgCtnt(String obItchgCtnt) {
		this.obItchgCtnt = obItchgCtnt;
	}

	/**
	 * Column Info
	 * 
	 * @param trnkAvalSpc
	 */
	public void setTrnkAvalSpc(String trnkAvalSpc) {
		this.trnkAvalSpc = trnkAvalSpc;
	}

	/**
	 * Column Info
	 * 
	 * @param routFlag
	 */
	public void setRoutFlag(String routFlag) {
		this.routFlag = routFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trnkLane
	 */
	public void setTrnkLane(String trnkLane) {
		this.trnkLane = trnkLane;
	}

	/**
	 * Column Info
	 * 
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * 
	 * @param tsRoute
	 */
	public void setTsRoute(String tsRoute) {
		this.tsRoute = tsRoute;
	}

	/**
	 * Column Info
	 * 
	 * @param routCnstSeq
	 */
	public void setRoutCnstSeq(String routCnstSeq) {
		this.routCnstSeq = routCnstSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param ttlTztmHrs
	 */
	public void setTtlTztmHrs(String ttlTztmHrs) {
		this.ttlTztmHrs = ttlTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}

	/**
	 * Column Info
	 * 
	 * @return ttlTztmHrs
	 */
	public void setPortCct(String portCct) {
		this.portCct = portCct;
	}

	/**
	 * Column Info
	 * 
	 * @return trnkVvd
	 */
	public void setFulRtnCct(String fulRtnCct) {
		this.fulRtnCct = fulRtnCct;
	}

	/**
	 * Column Info
	 * 
	 * @return ocnRoutPrioCd
	 */
	public void setLastAvailDt(String lastAvailDt) {
		this.lastAvailDt = lastAvailDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ocnRoutPrioCd
	 */
	public void setOcnRoutPrioCd(String ocnRoutPrioCd) {
		this.ocnRoutPrioCd = ocnRoutPrioCd;
	}

	public String getCmlInlndTztmHrs() {
		return cmlInlndTztmHrs;
	}

	/**
	 * Column Info
	 * 
	 * @param cmlInlndTztmHrs
	 */
	public void setCmlInlndTztmHrs(String cmlInlndTztmHrs) {
		this.cmlInlndTztmHrs = cmlInlndTztmHrs;
	}

	public String getPolNodCd() {
		return polNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}

	public String getPodNodCd() {
		return podNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param podNodCd
	 */

	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTotalCost(JSPUtil.getParameter(request, prefix + "total_cost", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setCmlTtlTztmHrs(JSPUtil.getParameter(request, prefix + "cml_ttl_tztm_hrs", ""));
		setCmlOcnTztmHrs(JSPUtil.getParameter(request, prefix + "cml_ocn_tztm_hrs", ""));
		setCmlInlndTztmHrs(JSPUtil.getParameter(request, prefix + "cml_inlnd_tztm_hrs", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, prefix + "ib_itchg_ctnt", ""));
		setRemarkImg(JSPUtil.getParameter(request, prefix + "remark_img", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, prefix + "ob_itchg_ctnt", ""));
		setTrnkAvalSpc(JSPUtil.getParameter(request, prefix + "trnk_aval_spc", ""));
		setRoutFlag(JSPUtil.getParameter(request, prefix + "rout_flag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTrnkLane(JSPUtil.getParameter(request, prefix + "trnk_lane", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTsRoute(JSPUtil.getParameter(request, prefix + "ts_route", ""));
		setRoutCnstSeq(JSPUtil.getParameter(request, prefix + "rout_cnst_seq", ""));
		setTtlTztmHrs(JSPUtil.getParameter(request, prefix + "ttl_tztm_hrs", ""));
		setTrnkVvd(JSPUtil.getParameter(request, prefix + "trnk_vvd", ""));
		setOcnRoutPrioCd(JSPUtil.getParameter(request, prefix + "ocn_rout_prio_cd", ""));
		setPortCct(JSPUtil.getParameter(request, prefix + "port_cct", ""));
		setFulRtnCct(JSPUtil.getParameter(request, prefix + "ful_rtn_cct", ""));
		setLastAvailDt(JSPUtil.getParameter(request, prefix + "last_avail_dt", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return ProductCatalogInternalMst_1VO[]
	 */
	public ProductCatalogInternalMst_1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return ProductCatalogInternalMst_1VO[]
	 */
	public ProductCatalogInternalMst_1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProductCatalogInternalMst_1VO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
			String[] totalCost = (JSPUtil.getParameter(request, prefix + "total_cost", length));
			String[] remark = (JSPUtil.getParameter(request, prefix + "remark", length));
			String[] cmlTtlTztmHrs = (JSPUtil.getParameter(request, prefix + "cml_ttl_tztm_hrs", length));
			String[] cmlOcnTztmHrs = (JSPUtil.getParameter(request, prefix + "cml_ocn_tztm_hrs", length));
			String[] cmlInlndTztmHrs = (JSPUtil.getParameter(request, prefix + "cml_inlnd_tztm_hrs", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
			String[] ord = (JSPUtil.getParameter(request, prefix + "ord", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix + "ib_itchg_ctnt", length));
			String[] remarkImg = (JSPUtil.getParameter(request, prefix + "remark_img", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix + "ob_itchg_ctnt", length));
			String[] trnkAvalSpc = (JSPUtil.getParameter(request, prefix + "trnk_aval_spc", length));
			String[] routFlag = (JSPUtil.getParameter(request, prefix + "rout_flag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
			String[] trnkLane = (JSPUtil.getParameter(request, prefix + "trnk_lane", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
			String[] tsRoute = (JSPUtil.getParameter(request, prefix + "ts_route", length));
			String[] routCnstSeq = (JSPUtil.getParameter(request, prefix + "rout_cnst_seq", length));
			String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix + "ttl_tztm_hrs", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix + "trnk_vvd", length));
			String[] ocnRoutPrioCd = (JSPUtil.getParameter(request, prefix + "ocn_rout_prio_cd", length));
			String[] portCct = (JSPUtil.getParameter(request, prefix + "port_cct", length));
			String[] fulRtnCct = (JSPUtil.getParameter(request, prefix + "ful_rtn_cct", length));
			String[] lastAvailDt = (JSPUtil.getParameter(request, prefix + "last_avail_dt", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));

			for (int i = 0; i < length; i++) {
				model = new ProductCatalogInternalMst_1VO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (totalCost[i] != null)
					model.setTotalCost(totalCost[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (cmlTtlTztmHrs[i] != null)
					model.setCmlTtlTztmHrs(cmlTtlTztmHrs[i]);
				if (cmlOcnTztmHrs[i] != null)
					model.setCmlOcnTztmHrs(cmlOcnTztmHrs[i]);
				if (cmlInlndTztmHrs[i] != null)
					model.setCmlInlndTztmHrs(cmlInlndTztmHrs[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (remarkImg[i] != null)
					model.setRemarkImg(remarkImg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (trnkAvalSpc[i] != null)
					model.setTrnkAvalSpc(trnkAvalSpc[i]);
				if (routFlag[i] != null)
					model.setRoutFlag(routFlag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (trnkLane[i] != null)
					model.setTrnkLane(trnkLane[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (tsRoute[i] != null)
					model.setTsRoute(tsRoute[i]);
				if (routCnstSeq[i] != null)
					model.setRoutCnstSeq(routCnstSeq[i]);
				if (ttlTztmHrs[i] != null)
					model.setTtlTztmHrs(ttlTztmHrs[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				if (ocnRoutPrioCd[i] != null)
					model.setOcnRoutPrioCd(ocnRoutPrioCd[i]);

				if (portCct[i] != null)
					model.setPortCct(portCct[i]);
				if (fulRtnCct[i] != null)
					model.setFulRtnCct(fulRtnCct[i]);
				if (lastAvailDt[i] != null)
					model.setLastAvailDt(lastAvailDt[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProductCatalogInternalMst_1VOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return ProductCatalogInternalMst_1VO[]
	 */
	public ProductCatalogInternalMst_1VO[] getProductCatalogInternalMst_1VOs() {
		ProductCatalogInternalMst_1VO[] vos = (ProductCatalogInternalMst_1VO[]) models.toArray(new ProductCatalogInternalMst_1VO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCost = this.totalCost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmlTtlTztmHrs = this.cmlTtlTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmlOcnTztmHrs = this.cmlOcnTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmlInlndTztmHrs = this.cmlInlndTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkImg = this.remarkImg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAvalSpc = this.trnkAvalSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routFlag = this.routFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkLane = this.trnkLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRoute = this.tsRoute.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstSeq = this.routCnstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTztmHrs = this.ttlTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnRoutPrioCd = this.ocnRoutPrioCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCct = this.portCct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fulRtnCct = this.fulRtnCct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastAvailDt = this.lastAvailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
