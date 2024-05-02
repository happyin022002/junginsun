/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchRouteConstraintVO.java
 *@FileTitle : SearchRouteConstraintVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.19 김귀진 
 * 1.0 Creation
 * histroy
 * 2010.10.11  채창호 [CHM-201006247-01] Constraint Managment 보완.
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo;

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

public class SearchRouteConstraintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchRouteConstraintVO> models = new ArrayList<SearchRouteConstraintVO>();

	/* Column Info */
	private String sTrunkLane = null;
	/* Column Info */
	private String sDirCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String sLane = null;
	/* Column Info */
	private String effToDate = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndTsPortCd = null;
	/* Column Info */
	private String n1stLaneCd = null;
	/* Column Info */
	private String n1stTsPortCd = null;
	/* Column Info */
	private String effFmDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sPodNode = null;
	/* Column Info */
	private String routCnstRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String sPolNode = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String sTs2Lane = null;
	/* Column Info */
	private String sDelChk = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sRemark = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sTs2Port = null;
	/* Column Info */
	private String n2ndLaneCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sSvcFlg = null;
	/* Column Info */
	private String routCnstSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String sDel = null;
	/* Column Info */
	private String sTs1Port = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String sRoutSeq = null;
	/* Column Info */
	private String sPod = null;
	/* Column Info */
	private String podNod = null;
	/* Column Info */
	private String polNod = null;
	/* Column Info */
	private String svcUseFlg = null;
	/* Column Info */
	private String trnkLaneCd = null;
	/* Column Info */
	private String n3rdLaneCd = null;
	/* Column Info */
	private String sTs1Lane = null;
	/* Column Info */
	private String sPol = null;
	/* Column Info */
	private String delNod = null;
	/* Column Info */
	private String sDelNode = null;
	/* Column Info */
	private String sPor = null;
	/* Column Info */
	private String sPorNode = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String porNode = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cntrSzCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchRouteConstraintVO() {
	}

	public SearchRouteConstraintVO(String ibflag, String pagerows, String deltFlg, String trnkLaneCd, String dirCd, String polCd, String polNod, String routCnstSeq, String n1stLaneCd, String n1stTsPortCd, String n2ndLaneCd, String n2ndTsPortCd, String n3rdLaneCd, String podCd, String podNod,
			String delCd, String svcUseFlg, String routCnstRmk, String creDt, String creOfcCd, String creUsrId, String updDt, String updOfcCd, String updUsrId, String sTrunkLane, String sDirCd, String sPol, String sPolNode, String sLane, String sTs1Port, String sTs1Lane, String sTs2Port,
			String sTs2Lane, String sPod, String sPodNode, String sDel, String sDelNode, String sSvcFlg, String sRemark, String sRoutSeq, String sDelChk, String maxSeq, String effFmDate, String effToDate, String delNod, String sPor, String sPorNode, String porCd, String porNode,
			String spclCgoCntrTpCd, String cntrTpCd, String cntrSzCd) {
		this.sTrunkLane = sTrunkLane;
		this.sDirCd = sDirCd;
		this.deltFlg = deltFlg;
		this.sLane = sLane;
		this.effToDate = effToDate;
		this.creDt = creDt;
		this.n2ndTsPortCd = n2ndTsPortCd;
		this.n1stLaneCd = n1stLaneCd;
		this.n1stTsPortCd = n1stTsPortCd;
		this.effFmDate = effFmDate;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.sPodNode = sPodNode;
		this.routCnstRmk = routCnstRmk;
		this.creOfcCd = creOfcCd;
		this.sPolNode = sPolNode;
		this.dirCd = dirCd;
		this.sTs2Lane = sTs2Lane;
		this.sDelChk = sDelChk;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.sRemark = sRemark;
		this.updDt = updDt;
		this.sTs2Port = sTs2Port;
		this.n2ndLaneCd = n2ndLaneCd;
		this.delCd = delCd;
		this.sSvcFlg = sSvcFlg;
		this.routCnstSeq = routCnstSeq;
		this.podCd = podCd;
		this.sDel = sDel;
		this.sTs1Port = sTs1Port;
		this.creUsrId = creUsrId;
		this.maxSeq = maxSeq;
		this.sRoutSeq = sRoutSeq;
		this.sPod = sPod;
		this.podNod = podNod;
		this.polNod = polNod;
		this.svcUseFlg = svcUseFlg;
		this.trnkLaneCd = trnkLaneCd;
		this.n3rdLaneCd = n3rdLaneCd;
		this.sTs1Lane = sTs1Lane;
		this.sPol = sPol;
		this.sDelNode = sDelNode;
		this.delNod = delNod;
		this.sPor = sPor;
		this.sPorNode = sPorNode;
		this.porCd = porCd;
		this.porNode = porNode;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.cntrTpCd = cntrTpCd;
		this.cntrSzCd = cntrSzCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("s_trunk_lane", getSTrunkLane());
		this.hashColumns.put("s_dir_cd", getSDirCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("s_lane", getSLane());
		this.hashColumns.put("eff_to_date", getEffToDate());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n2nd_ts_port_cd", getN2ndTsPortCd());
		this.hashColumns.put("n1st_lane_cd", getN1stLaneCd());
		this.hashColumns.put("n1st_ts_port_cd", getN1stTsPortCd());
		this.hashColumns.put("eff_fm_date", getEffFmDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_pod_node", getSPodNode());
		this.hashColumns.put("rout_cnst_rmk", getRoutCnstRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("s_pol_node", getSPolNode());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("s_ts2_lane", getSTs2Lane());
		this.hashColumns.put("s_del_chk", getSDelChk());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_remark", getSRemark());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("s_ts2_port", getSTs2Port());
		this.hashColumns.put("n2nd_lane_cd", getN2ndLaneCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("s_svc_flg", getSSvcFlg());
		this.hashColumns.put("rout_cnst_seq", getRoutCnstSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("s_del", getSDel());
		this.hashColumns.put("s_ts1_port", getSTs1Port());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("s_rout_seq", getSRoutSeq());
		this.hashColumns.put("s_pod", getSPod());
		this.hashColumns.put("pod_nod", getPodNod());
		this.hashColumns.put("pol_nod", getPolNod());
		this.hashColumns.put("svc_use_flg", getSvcUseFlg());
		this.hashColumns.put("trnk_lane_cd", getTrnkLaneCd());
		this.hashColumns.put("n3rd_lane_cd", getN3rdLaneCd());
		this.hashColumns.put("s_ts1_lane", getSTs1Lane());
		this.hashColumns.put("s_pol", getSPol());
		this.hashColumns.put("s_del_node", getSDelNode());
		this.hashColumns.put("del_node", getDelNod());
		this.hashColumns.put("s_por", getSPor());
		this.hashColumns.put("s_por_node", getSPorNode());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("por_node", getPorNode());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("s_trunk_lane", "sTrunkLane");
		this.hashFields.put("s_dir_cd", "sDirCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("s_lane", "sLane");
		this.hashFields.put("eff_to_date", "effToDate");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_ts_port_cd", "n2ndTsPortCd");
		this.hashFields.put("n1st_lane_cd", "n1stLaneCd");
		this.hashFields.put("n1st_ts_port_cd", "n1stTsPortCd");
		this.hashFields.put("eff_fm_date", "effFmDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_pod_node", "sPodNode");
		this.hashFields.put("rout_cnst_rmk", "routCnstRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("s_pol_node", "sPolNode");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("s_ts2_lane", "sTs2Lane");
		this.hashFields.put("s_del_chk", "sDelChk");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_remark", "sRemark");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("s_ts2_port", "sTs2Port");
		this.hashFields.put("n2nd_lane_cd", "n2ndLaneCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("s_svc_flg", "sSvcFlg");
		this.hashFields.put("rout_cnst_seq", "routCnstSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("s_del", "sDel");
		this.hashFields.put("s_ts1_port", "sTs1Port");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("s_rout_seq", "sRoutSeq");
		this.hashFields.put("s_pod", "sPod");
		this.hashFields.put("pod_nod", "podNod");
		this.hashFields.put("pol_nod", "polNod");
		this.hashFields.put("svc_use_flg", "svcUseFlg");
		this.hashFields.put("trnk_lane_cd", "trnkLaneCd");
		this.hashFields.put("n3rd_lane_cd", "n3rdLaneCd");
		this.hashFields.put("s_ts1_lane", "sTs1Lane");
		this.hashFields.put("s_pol", "sPol");
		this.hashFields.put("s_del_node", "sDelNode");
		this.hashFields.put("del_node", "delNod");
		this.hashFields.put("s_por", "sPor");
		this.hashFields.put("s_por_node", "sPorNode");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("por_node", "porNode");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return sTrunkLane
	 */
	public String getSTrunkLane() {
		return this.sTrunkLane;
	}

	/**
	 * Column Info
	 * 
	 * @return sDirCd
	 */
	public String getSDirCd() {
		return this.sDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return sLane
	 */
	public String getSLane() {
		return this.sLane;
	}

	/**
	 * Column Info
	 * 
	 * @return effToDate
	 */
	public String getEffToDate() {
		return this.effToDate;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return n2ndTsPortCd
	 */
	public String getN2ndTsPortCd() {
		return this.n2ndTsPortCd;
	}

	/**
	 * Column Info
	 * 
	 * @return n1stLaneCd
	 */
	public String getN1stLaneCd() {
		return this.n1stLaneCd;
	}

	/**
	 * Column Info
	 * 
	 * @return n1stTsPortCd
	 */
	public String getN1stTsPortCd() {
		return this.n1stTsPortCd;
	}

	/**
	 * Column Info
	 * 
	 * @return effFmDate
	 */
	public String getEffFmDate() {
		return this.effFmDate;
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
	 * @return sPodNode
	 */
	public String getSPodNode() {
		return this.sPodNode;
	}

	/**
	 * Column Info
	 * 
	 * @return routCnstRmk
	 */
	public String getRoutCnstRmk() {
		return this.routCnstRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return sPolNode
	 */
	public String getSPolNode() {
		return this.sPolNode;
	}

	/**
	 * Column Info
	 * 
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return sTs2Lane
	 */
	public String getSTs2Lane() {
		return this.sTs2Lane;
	}

	/**
	 * Column Info
	 * 
	 * @return sDelChk
	 */
	public String getSDelChk() {
		return this.sDelChk;
	}

	/**
	 * Column Info
	 * 
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return sRemark
	 */
	public String getSRemark() {
		return this.sRemark;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return sTs2Port
	 */
	public String getSTs2Port() {
		return this.sTs2Port;
	}

	/**
	 * Column Info
	 * 
	 * @return n2ndLaneCd
	 */
	public String getN2ndLaneCd() {
		return this.n2ndLaneCd;
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
	 * @return sSvcFlg
	 */
	public String getSSvcFlg() {
		return this.sSvcFlg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * 
	 * @return sDel
	 */
	public String getSDel() {
		return this.sDel;
	}

	/**
	 * Column Info
	 * 
	 * @return sTs1Port
	 */
	public String getSTs1Port() {
		return this.sTs1Port;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return sRoutSeq
	 */
	public String getSRoutSeq() {
		return this.sRoutSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return sPod
	 */
	public String getSPod() {
		return this.sPod;
	}

	/**
	 * Column Info
	 * 
	 * @return podNod
	 */
	public String getPodNod() {
		return this.podNod;
	}

	/**
	 * Column Info
	 * 
	 * @return polNod
	 */
	public String getPolNod() {
		return this.polNod;
	}

	/**
	 * Column Info
	 * 
	 * @return svcUseFlg
	 */
	public String getSvcUseFlg() {
		return this.svcUseFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return trnkLaneCd
	 */
	public String getTrnkLaneCd() {
		return this.trnkLaneCd;
	}

	/**
	 * Column Info
	 * 
	 * @return n3rdLaneCd
	 */
	public String getN3rdLaneCd() {
		return this.n3rdLaneCd;
	}

	/**
	 * Column Info
	 * 
	 * @return sTs1Lane
	 */
	public String getSTs1Lane() {
		return this.sTs1Lane;
	}

	/**
	 * Column Info
	 * 
	 * @return sPol
	 */
	public String getSPol() {
		return this.sPol;
	}

	/**
	 * Column Info
	 * 
	 * @param sTrunkLane
	 */
	public void setSTrunkLane(String sTrunkLane) {
		this.sTrunkLane = sTrunkLane;
	}

	/**
	 * Column Info
	 * 
	 * @param sDirCd
	 */
	public void setSDirCd(String sDirCd) {
		this.sDirCd = sDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param sLane
	 */
	public void setSLane(String sLane) {
		this.sLane = sLane;
	}

	/**
	 * Column Info
	 * 
	 * @param effToDate
	 */
	public void setEffToDate(String effToDate) {
		this.effToDate = effToDate;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param n2ndTsPortCd
	 */
	public void setN2ndTsPortCd(String n2ndTsPortCd) {
		this.n2ndTsPortCd = n2ndTsPortCd;
	}

	/**
	 * Column Info
	 * 
	 * @param n1stLaneCd
	 */
	public void setN1stLaneCd(String n1stLaneCd) {
		this.n1stLaneCd = n1stLaneCd;
	}

	/**
	 * Column Info
	 * 
	 * @param n1stTsPortCd
	 */
	public void setN1stTsPortCd(String n1stTsPortCd) {
		this.n1stTsPortCd = n1stTsPortCd;
	}

	/**
	 * Column Info
	 * 
	 * @param effFmDate
	 */
	public void setEffFmDate(String effFmDate) {
		this.effFmDate = effFmDate;
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
	 * @param sPodNode
	 */
	public void setSPodNode(String sPodNode) {
		this.sPodNode = sPodNode;
	}

	/**
	 * Column Info
	 * 
	 * @param routCnstRmk
	 */
	public void setRoutCnstRmk(String routCnstRmk) {
		this.routCnstRmk = routCnstRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param sPolNode
	 */
	public void setSPolNode(String sPolNode) {
		this.sPolNode = sPolNode;
	}

	/**
	 * Column Info
	 * 
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param sTs2Lane
	 */
	public void setSTs2Lane(String sTs2Lane) {
		this.sTs2Lane = sTs2Lane;
	}

	/**
	 * Column Info
	 * 
	 * @param sDelChk
	 */
	public void setSDelChk(String sDelChk) {
		this.sDelChk = sDelChk;
	}

	/**
	 * Column Info
	 * 
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param sRemark
	 */
	public void setSRemark(String sRemark) {
		this.sRemark = sRemark;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param sTs2Port
	 */
	public void setSTs2Port(String sTs2Port) {
		this.sTs2Port = sTs2Port;
	}

	/**
	 * Column Info
	 * 
	 * @param n2ndLaneCd
	 */
	public void setN2ndLaneCd(String n2ndLaneCd) {
		this.n2ndLaneCd = n2ndLaneCd;
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
	 * @param sSvcFlg
	 */
	public void setSSvcFlg(String sSvcFlg) {
		this.sSvcFlg = sSvcFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * 
	 * @param sDel
	 */
	public void setSDel(String sDel) {
		this.sDel = sDel;
	}

	/**
	 * Column Info
	 * 
	 * @param sTs1Port
	 */
	public void setSTs1Port(String sTs1Port) {
		this.sTs1Port = sTs1Port;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param sRoutSeq
	 */
	public void setSRoutSeq(String sRoutSeq) {
		this.sRoutSeq = sRoutSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param sPod
	 */
	public void setSPod(String sPod) {
		this.sPod = sPod;
	}

	/**
	 * Column Info
	 * 
	 * @param podNod
	 */
	public void setPodNod(String podNod) {
		this.podNod = podNod;
	}

	/**
	 * Column Info
	 * 
	 * @param polNod
	 */
	public void setPolNod(String polNod) {
		this.polNod = polNod;
	}

	/**
	 * Column Info
	 * 
	 * @param svcUseFlg
	 */
	public void setSvcUseFlg(String svcUseFlg) {
		this.svcUseFlg = svcUseFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param trnkLaneCd
	 */
	public void setTrnkLaneCd(String trnkLaneCd) {
		this.trnkLaneCd = trnkLaneCd;
	}

	/**
	 * Column Info
	 * 
	 * @param n3rdLaneCd
	 */
	public void setN3rdLaneCd(String n3rdLaneCd) {
		this.n3rdLaneCd = n3rdLaneCd;
	}

	/**
	 * Column Info
	 * 
	 * @param sTs1Lane
	 */
	public void setSTs1Lane(String sTs1Lane) {
		this.sTs1Lane = sTs1Lane;
	}

	/**
	 * Column Info
	 * 
	 * @param sPol
	 */
	public void setSPol(String sPol) {
		this.sPol = sPol;
	}

	/**
	 * @return the delNod
	 */
	public String getDelNod() {
		return delNod;
	}

	/**
	 * @param delNod the delNod to set
	 */
	public void setDelNod(String delNod) {
		this.delNod = delNod;
	}

	/**
	 * @return the sDelNode
	 */
	public String getSDelNode() {
		return sDelNode;
	}

	/**
	 * @param sdelNode the sDelNode to set
	 */
	public void setSDelNode(String sDelNode) {
		this.sDelNode = sDelNode;
	}

	/**
	 * 
	 * @return sPor
	 */
	public String getSPor() {
		return sPor;
	}

	/**
	 * @param sPor the sPor to set
	 */
	public void setSPor(String sPor) {
		this.sPor = sPor;
	}

	/**
	 * 
	 * @return sPorNode
	 */
	public String getSPorNode() {
		return sPorNode;
	}

	/**
	 * @param sPorNode the sPorNode to set
	 */
	public void setSPorNode(String sPorNode) {
		this.sPorNode = sPorNode;
	}

	public String getPorCd() {
		return porCd;
	}

	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	public String getPorNode() {
		return porNode;
	}

	public void setPorNode(String porNode) {
		this.porNode = porNode;
	}

	public String getSpclCgoCntrTpCd() {
		return spclCgoCntrTpCd;
	}

	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	public String getCntrTpCd() {
		return cntrTpCd;
	}

	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}

	public String getCntrSzCd() {
		return cntrSzCd;
	}

	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSTrunkLane(JSPUtil.getParameter(request, "s_trunk_lane", ""));
		setSDirCd(JSPUtil.getParameter(request, "s_dir_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSLane(JSPUtil.getParameter(request, "s_lane", ""));
		setEffToDate(JSPUtil.getParameter(request, "eff_to_date", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN2ndTsPortCd(JSPUtil.getParameter(request, "n2nd_ts_port_cd", ""));
		setN1stLaneCd(JSPUtil.getParameter(request, "n1st_lane_cd", ""));
		setN1stTsPortCd(JSPUtil.getParameter(request, "n1st_ts_port_cd", ""));
		setEffFmDate(JSPUtil.getParameter(request, "eff_fm_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSPodNode(JSPUtil.getParameter(request, "s_pod_node", ""));
		setRoutCnstRmk(JSPUtil.getParameter(request, "rout_cnst_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setSPolNode(JSPUtil.getParameter(request, "s_pol_node", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setSTs2Lane(JSPUtil.getParameter(request, "s_ts2_lane", ""));
		setSDelChk(JSPUtil.getParameter(request, "s_del_chk", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSRemark(JSPUtil.getParameter(request, "s_remark", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSTs2Port(JSPUtil.getParameter(request, "s_ts2_port", ""));
		setN2ndLaneCd(JSPUtil.getParameter(request, "n2nd_lane_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSSvcFlg(JSPUtil.getParameter(request, "s_svc_flg", ""));
		setRoutCnstSeq(JSPUtil.getParameter(request, "rout_cnst_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSDel(JSPUtil.getParameter(request, "s_del", ""));
		setSTs1Port(JSPUtil.getParameter(request, "s_ts1_port", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMaxSeq(JSPUtil.getParameter(request, "max_seq", ""));
		setSRoutSeq(JSPUtil.getParameter(request, "s_rout_seq", ""));
		setSPod(JSPUtil.getParameter(request, "s_pod", ""));
		setPodNod(JSPUtil.getParameter(request, "pod_nod", ""));
		setPolNod(JSPUtil.getParameter(request, "pol_nod", ""));
		setSvcUseFlg(JSPUtil.getParameter(request, "svc_use_flg", ""));
		setTrnkLaneCd(JSPUtil.getParameter(request, "trnk_lane_cd", ""));
		setN3rdLaneCd(JSPUtil.getParameter(request, "n3rd_lane_cd", ""));
		setSTs1Lane(JSPUtil.getParameter(request, "s_ts1_lane", ""));
		setSPol(JSPUtil.getParameter(request, "s_pol", ""));
		setSDelNode(JSPUtil.getParameter(request, "s_del_node", ""));
		setSDelNode(JSPUtil.getParameter(request, "s_por", ""));
		setSDelNode(JSPUtil.getParameter(request, "s_por_node", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPorNode(JSPUtil.getParameter(request, "por_node", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, "spcl_cgo_cntr_tp_cd", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SearchRouteConstraintVO[]
	 */
	public SearchRouteConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SearchRouteConstraintVO[]
	 */
	public SearchRouteConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRouteConstraintVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sTrunkLane = (JSPUtil.getParameter(request, prefix + "s_trunk_lane", length));
			String[] sDirCd = (JSPUtil.getParameter(request, prefix + "s_dir_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
			String[] sLane = (JSPUtil.getParameter(request, prefix + "s_lane", length));
			String[] effToDate = (JSPUtil.getParameter(request, prefix + "eff_to_date", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] n2ndTsPortCd = (JSPUtil.getParameter(request, prefix + "n2nd_ts_port_cd", length));
			String[] n1stLaneCd = (JSPUtil.getParameter(request, prefix + "n1st_lane_cd", length));
			String[] n1stTsPortCd = (JSPUtil.getParameter(request, prefix + "n1st_ts_port_cd", length));
			String[] effFmDate = (JSPUtil.getParameter(request, prefix + "eff_fm_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] sPodNode = (JSPUtil.getParameter(request, prefix + "s_pod_node", length));
			String[] routCnstRmk = (JSPUtil.getParameter(request, prefix + "rout_cnst_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] sPolNode = (JSPUtil.getParameter(request, prefix + "s_pol_node", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
			String[] sTs2Lane = (JSPUtil.getParameter(request, prefix + "s_ts2_lane", length));
			String[] sDelChk = (JSPUtil.getParameter(request, prefix + "s_del_chk", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] sRemark = (JSPUtil.getParameter(request, prefix + "s_remark", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] sTs2Port = (JSPUtil.getParameter(request, prefix + "s_ts2_port", length));
			String[] n2ndLaneCd = (JSPUtil.getParameter(request, prefix + "n2nd_lane_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
			String[] sSvcFlg = (JSPUtil.getParameter(request, prefix + "s_svc_flg", length));
			String[] routCnstSeq = (JSPUtil.getParameter(request, prefix + "rout_cnst_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
			String[] sDel = (JSPUtil.getParameter(request, prefix + "s_del", length));
			String[] sTs1Port = (JSPUtil.getParameter(request, prefix + "s_ts1_port", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix + "max_seq", length));
			String[] sRoutSeq = (JSPUtil.getParameter(request, prefix + "s_rout_seq", length));
			String[] sPod = (JSPUtil.getParameter(request, prefix + "s_pod", length));
			String[] podNod = (JSPUtil.getParameter(request, prefix + "pod_nod", length));
			String[] polNod = (JSPUtil.getParameter(request, prefix + "pol_nod", length));
			String[] svcUseFlg = (JSPUtil.getParameter(request, prefix + "svc_use_flg", length));
			String[] trnkLaneCd = (JSPUtil.getParameter(request, prefix + "trnk_lane_cd", length));
			String[] n3rdLaneCd = (JSPUtil.getParameter(request, prefix + "n3rd_lane_cd", length));
			String[] sTs1Lane = (JSPUtil.getParameter(request, prefix + "s_ts1_lane", length));
			String[] sPol = (JSPUtil.getParameter(request, prefix + "s_pol", length));
			String[] sDelNode = (JSPUtil.getParameter(request, prefix + "s_del_node", length));
			String[] sPor = (JSPUtil.getParameter(request, prefix + "s_por", length));
			String[] sPorNode = (JSPUtil.getParameter(request, prefix + "s_por_node", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
			String[] porNode = (JSPUtil.getParameter(request, prefix + "por_node", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix + "cntr_tp_cd", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix + "cntr_sz_cd", length));
			for (int i = 0; i < length; i++) {
				model = new SearchRouteConstraintVO();
				if (sTrunkLane[i] != null)
					model.setSTrunkLane(sTrunkLane[i]);
				if (sDirCd[i] != null)
					model.setSDirCd(sDirCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (sLane[i] != null)
					model.setSLane(sLane[i]);
				if (effToDate[i] != null)
					model.setEffToDate(effToDate[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndTsPortCd[i] != null)
					model.setN2ndTsPortCd(n2ndTsPortCd[i]);
				if (n1stLaneCd[i] != null)
					model.setN1stLaneCd(n1stLaneCd[i]);
				if (n1stTsPortCd[i] != null)
					model.setN1stTsPortCd(n1stTsPortCd[i]);
				if (effFmDate[i] != null)
					model.setEffFmDate(effFmDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sPodNode[i] != null)
					model.setSPodNode(sPodNode[i]);
				if (routCnstRmk[i] != null)
					model.setRoutCnstRmk(routCnstRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (sPolNode[i] != null)
					model.setSPolNode(sPolNode[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (sTs2Lane[i] != null)
					model.setSTs2Lane(sTs2Lane[i]);
				if (sDelChk[i] != null)
					model.setSDelChk(sDelChk[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sRemark[i] != null)
					model.setSRemark(sRemark[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sTs2Port[i] != null)
					model.setSTs2Port(sTs2Port[i]);
				if (n2ndLaneCd[i] != null)
					model.setN2ndLaneCd(n2ndLaneCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sSvcFlg[i] != null)
					model.setSSvcFlg(sSvcFlg[i]);
				if (routCnstSeq[i] != null)
					model.setRoutCnstSeq(routCnstSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (sDel[i] != null)
					model.setSDel(sDel[i]);
				if (sTs1Port[i] != null)
					model.setSTs1Port(sTs1Port[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (sRoutSeq[i] != null)
					model.setSRoutSeq(sRoutSeq[i]);
				if (sPod[i] != null)
					model.setSPod(sPod[i]);
				if (podNod[i] != null)
					model.setPodNod(podNod[i]);
				if (polNod[i] != null)
					model.setPolNod(polNod[i]);
				if (svcUseFlg[i] != null)
					model.setSvcUseFlg(svcUseFlg[i]);
				if (trnkLaneCd[i] != null)
					model.setTrnkLaneCd(trnkLaneCd[i]);
				if (n3rdLaneCd[i] != null)
					model.setN3rdLaneCd(n3rdLaneCd[i]);
				if (sTs1Lane[i] != null)
					model.setSTs1Lane(sTs1Lane[i]);
				if (sPol[i] != null)
					model.setSPol(sPol[i]);
				if (sDelNode[i] != null)
					model.setSDelNode(sDelNode[i]);
				if (sPor[i] != null)
					model.setSPor(sPor[i]);
				if (sPorNode[i] != null)
					model.setSPorNode(sPorNode[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (porNode[i] != null)
					model.setPorNode(porNode[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				models.add(model);

			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRouteConstraintVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return SearchRouteConstraintVO[]
	 */
	public SearchRouteConstraintVO[] getSearchRouteConstraintVOs() {
		SearchRouteConstraintVO[] vos = (SearchRouteConstraintVO[]) models.toArray(new SearchRouteConstraintVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.sTrunkLane = this.sTrunkLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDirCd = this.sDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLane = this.sLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDate = this.effToDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPortCd = this.n2ndTsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLaneCd = this.n1stLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPortCd = this.n1stTsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDate = this.effFmDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPodNode = this.sPodNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstRmk = this.routCnstRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolNode = this.sPolNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Lane = this.sTs2Lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDelChk = this.sDelChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRemark = this.sRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Port = this.sTs2Port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndLaneCd = this.n2ndLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSvcFlg = this.sSvcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstSeq = this.routCnstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDel = this.sDel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Port = this.sTs1Port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRoutSeq = this.sRoutSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod = this.sPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNod = this.podNod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNod = this.polNod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcUseFlg = this.svcUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkLaneCd = this.trnkLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLaneCd = this.n3rdLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Lane = this.sTs1Lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol = this.sPol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDelNode = this.sDelNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPor = this.sPor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPorNode = this.sPorNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNode = this.porNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
