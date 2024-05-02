/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AwkCgoExtraCostByRouteVO.java
*@FileTitle : AwkCgoExtraCostByRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.29
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.29 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AwkCgoExtraCostByRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AwkCgoExtraCostByRouteVO> models = new ArrayList<AwkCgoExtraCostByRouteVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String tCost = null;
	/* Column Info */
	private String scqVerNoTmp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String wCost = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String wCostZeroExist = null;
	/* Column Info */
	private String tmpYn = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String nCost = null;
	/* Column Info */
	private String routTpSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String aCost = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ydCostSeq = null;
	/* Column Info */
	private String routTpCd = null;
	/* Column Info */
	private String gCostZeroExist = null;
	/* Column Info */
	private String routCostSeq = null;
	/* Column Info */
	private String aCostZeroExist = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String scqVerNo = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String obYdCd = null;
	/* Column Info */
	private String ibYdCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String sCostZeroExist = null;
	/* Column Info */
	private String tCostZeroExist = null;
	/* Column Info */
	private String nCostZeroExist = null;
	/* Column Info */
	private String gCost = null;
	/* Column Info */
	private String sCost = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AwkCgoExtraCostByRouteVO() {}

	public AwkCgoExtraCostByRouteVO(String ibflag, String pagerows, String costAmt, String costTpCd, String creDt, String creUsrId, String ibYdCd, String ioBndCd, String laneCd, String obYdCd, String routCostSeq, String routSeq, String routTpCd, String routTpSeq, String scqRqstNo, String scqVerNo, String updDt, String updUsrId, String ydCd, String ydCostSeq, String scqVerNoTmp, String nCost, String sCost, String aCost, String gCost, String tCost, String wCost, String tmpYn, String nCostZeroExist, String wCostZeroExist, String gCostZeroExist, String tCostZeroExist, String sCostZeroExist, String aCostZeroExist) {
		this.laneCd = laneCd;
		this.tCost = tCost;
		this.scqVerNoTmp = scqVerNoTmp;
		this.creDt = creDt;
		this.wCost = wCost;
		this.pagerows = pagerows;
		this.costTpCd = costTpCd;
		this.ibflag = ibflag;
		this.costAmt = costAmt;
		this.wCostZeroExist = wCostZeroExist;
		this.tmpYn = tmpYn;
		this.scqRqstNo = scqRqstNo;
		this.nCost = nCost;
		this.routTpSeq = routTpSeq;
		this.updUsrId = updUsrId;
		this.aCost = aCost;
		this.updDt = updDt;
		this.ydCostSeq = ydCostSeq;
		this.routTpCd = routTpCd;
		this.gCostZeroExist = gCostZeroExist;
		this.routCostSeq = routCostSeq;
		this.aCostZeroExist = aCostZeroExist;
		this.ioBndCd = ioBndCd;
		this.scqVerNo = scqVerNo;
		this.routSeq = routSeq;
		this.obYdCd = obYdCd;
		this.ibYdCd = ibYdCd;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.sCostZeroExist = sCostZeroExist;
		this.tCostZeroExist = tCostZeroExist;
		this.nCostZeroExist = nCostZeroExist;
		this.gCost = gCost;
		this.sCost = sCost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("t_cost", getTCost());
		this.hashColumns.put("scq_ver_no_tmp", getScqVerNoTmp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("w_cost", getWCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_tp_cd", getCostTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("w_cost_zero_exist", getWCostZeroExist());
		this.hashColumns.put("tmp_yn", getTmpYn());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("n_cost", getNCost());
		this.hashColumns.put("rout_tp_seq", getRoutTpSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("a_cost", getACost());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("yd_cost_seq", getYdCostSeq());
		this.hashColumns.put("rout_tp_cd", getRoutTpCd());
		this.hashColumns.put("g_cost_zero_exist", getGCostZeroExist());
		this.hashColumns.put("rout_cost_seq", getRoutCostSeq());
		this.hashColumns.put("a_cost_zero_exist", getACostZeroExist());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("scq_ver_no", getScqVerNo());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ob_yd_cd", getObYdCd());
		this.hashColumns.put("ib_yd_cd", getIbYdCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("s_cost_zero_exist", getSCostZeroExist());
		this.hashColumns.put("t_cost_zero_exist", getTCostZeroExist());
		this.hashColumns.put("n_cost_zero_exist", getNCostZeroExist());
		this.hashColumns.put("g_cost", getGCost());
		this.hashColumns.put("s_cost", getSCost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("t_cost", "tCost");
		this.hashFields.put("scq_ver_no_tmp", "scqVerNoTmp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("w_cost", "wCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_tp_cd", "costTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("w_cost_zero_exist", "wCostZeroExist");
		this.hashFields.put("tmp_yn", "tmpYn");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
		this.hashFields.put("n_cost", "nCost");
		this.hashFields.put("rout_tp_seq", "routTpSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("a_cost", "aCost");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("yd_cost_seq", "ydCostSeq");
		this.hashFields.put("rout_tp_cd", "routTpCd");
		this.hashFields.put("g_cost_zero_exist", "gCostZeroExist");
		this.hashFields.put("rout_cost_seq", "routCostSeq");
		this.hashFields.put("a_cost_zero_exist", "aCostZeroExist");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("scq_ver_no", "scqVerNo");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ob_yd_cd", "obYdCd");
		this.hashFields.put("ib_yd_cd", "ibYdCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("s_cost_zero_exist", "sCostZeroExist");
		this.hashFields.put("t_cost_zero_exist", "tCostZeroExist");
		this.hashFields.put("n_cost_zero_exist", "nCostZeroExist");
		this.hashFields.put("g_cost", "gCost");
		this.hashFields.put("s_cost", "sCost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return tCost
	 */
	public String getTCost() {
		return this.tCost;
	}
	
	/**
	 * Column Info
	 * @return scqVerNoTmp
	 */
	public String getScqVerNoTmp() {
		return this.scqVerNoTmp;
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
	 * @return wCost
	 */
	public String getWCost() {
		return this.wCost;
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
	 * @return costTpCd
	 */
	public String getCostTpCd() {
		return this.costTpCd;
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
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return wCostZeroExist
	 */
	public String getWCostZeroExist() {
		return this.wCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @return tmpYn
	 */
	public String getTmpYn() {
		return this.tmpYn;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo
	 */
	public String getScqRqstNo() {
		return this.scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @return nCost
	 */
	public String getNCost() {
		return this.nCost;
	}
	
	/**
	 * Column Info
	 * @return routTpSeq
	 */
	public String getRoutTpSeq() {
		return this.routTpSeq;
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
	 * @return aCost
	 */
	public String getACost() {
		return this.aCost;
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
	 * @return ydCostSeq
	 */
	public String getYdCostSeq() {
		return this.ydCostSeq;
	}
	
	/**
	 * Column Info
	 * @return routTpCd
	 */
	public String getRoutTpCd() {
		return this.routTpCd;
	}
	
	/**
	 * Column Info
	 * @return gCostZeroExist
	 */
	public String getGCostZeroExist() {
		return this.gCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @return routCostSeq
	 */
	public String getRoutCostSeq() {
		return this.routCostSeq;
	}
	
	/**
	 * Column Info
	 * @return aCostZeroExist
	 */
	public String getACostZeroExist() {
		return this.aCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return scqVerNo
	 */
	public String getScqVerNo() {
		return this.scqVerNo;
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
	 * @return obYdCd
	 */
	public String getObYdCd() {
		return this.obYdCd;
	}
	
	/**
	 * Column Info
	 * @return ibYdCd
	 */
	public String getIbYdCd() {
		return this.ibYdCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return sCostZeroExist
	 */
	public String getSCostZeroExist() {
		return this.sCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @return tCostZeroExist
	 */
	public String getTCostZeroExist() {
		return this.tCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @return nCostZeroExist
	 */
	public String getNCostZeroExist() {
		return this.nCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @return gCost
	 */
	public String getGCost() {
		return this.gCost;
	}
	
	/**
	 * Column Info
	 * @return sCost
	 */
	public String getSCost() {
		return this.sCost;
	}
	

	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param tCost
	 */
	public void setTCost(String tCost) {
		this.tCost = tCost;
	}
	
	/**
	 * Column Info
	 * @param scqVerNoTmp
	 */
	public void setScqVerNoTmp(String scqVerNoTmp) {
		this.scqVerNoTmp = scqVerNoTmp;
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
	 * @param wCost
	 */
	public void setWCost(String wCost) {
		this.wCost = wCost;
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
	 * @param costTpCd
	 */
	public void setCostTpCd(String costTpCd) {
		this.costTpCd = costTpCd;
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
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param wCostZeroExist
	 */
	public void setWCostZeroExist(String wCostZeroExist) {
		this.wCostZeroExist = wCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @param tmpYn
	 */
	public void setTmpYn(String tmpYn) {
		this.tmpYn = tmpYn;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo
	 */
	public void setScqRqstNo(String scqRqstNo) {
		this.scqRqstNo = scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @param nCost
	 */
	public void setNCost(String nCost) {
		this.nCost = nCost;
	}
	
	/**
	 * Column Info
	 * @param routTpSeq
	 */
	public void setRoutTpSeq(String routTpSeq) {
		this.routTpSeq = routTpSeq;
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
	 * @param aCost
	 */
	public void setACost(String aCost) {
		this.aCost = aCost;
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
	 * @param ydCostSeq
	 */
	public void setYdCostSeq(String ydCostSeq) {
		this.ydCostSeq = ydCostSeq;
	}
	
	/**
	 * Column Info
	 * @param routTpCd
	 */
	public void setRoutTpCd(String routTpCd) {
		this.routTpCd = routTpCd;
	}
	
	/**
	 * Column Info
	 * @param gCostZeroExist
	 */
	public void setGCostZeroExist(String gCostZeroExist) {
		this.gCostZeroExist = gCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @param routCostSeq
	 */
	public void setRoutCostSeq(String routCostSeq) {
		this.routCostSeq = routCostSeq;
	}
	
	/**
	 * Column Info
	 * @param aCostZeroExist
	 */
	public void setACostZeroExist(String aCostZeroExist) {
		this.aCostZeroExist = aCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param scqVerNo
	 */
	public void setScqVerNo(String scqVerNo) {
		this.scqVerNo = scqVerNo;
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
	 * @param obYdCd
	 */
	public void setObYdCd(String obYdCd) {
		this.obYdCd = obYdCd;
	}
	
	/**
	 * Column Info
	 * @param ibYdCd
	 */
	public void setIbYdCd(String ibYdCd) {
		this.ibYdCd = ibYdCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param sCostZeroExist
	 */
	public void setSCostZeroExist(String sCostZeroExist) {
		this.sCostZeroExist = sCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @param tCostZeroExist
	 */
	public void setTCostZeroExist(String tCostZeroExist) {
		this.tCostZeroExist = tCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @param nCostZeroExist
	 */
	public void setNCostZeroExist(String nCostZeroExist) {
		this.nCostZeroExist = nCostZeroExist;
	}
	
	/**
	 * Column Info
	 * @param gCost
	 */
	public void setGCost(String gCost) {
		this.gCost = gCost;
	}
	
	/**
	 * Column Info
	 * @param sCost
	 */
	public void setSCost(String sCost) {
		this.sCost = sCost;
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
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setTCost(JSPUtil.getParameter(request, prefix + "t_cost", ""));
		setScqVerNoTmp(JSPUtil.getParameter(request, prefix + "scq_ver_no_tmp", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setWCost(JSPUtil.getParameter(request, prefix + "w_cost", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostTpCd(JSPUtil.getParameter(request, prefix + "cost_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setWCostZeroExist(JSPUtil.getParameter(request, prefix + "w_cost_zero_exist", ""));
		setTmpYn(JSPUtil.getParameter(request, prefix + "tmp_yn", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setNCost(JSPUtil.getParameter(request, prefix + "n_cost", ""));
		setRoutTpSeq(JSPUtil.getParameter(request, prefix + "rout_tp_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setACost(JSPUtil.getParameter(request, prefix + "a_cost", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setYdCostSeq(JSPUtil.getParameter(request, prefix + "yd_cost_seq", ""));
		setRoutTpCd(JSPUtil.getParameter(request, prefix + "rout_tp_cd", ""));
		setGCostZeroExist(JSPUtil.getParameter(request, prefix + "g_cost_zero_exist", ""));
		setRoutCostSeq(JSPUtil.getParameter(request, prefix + "rout_cost_seq", ""));
		setACostZeroExist(JSPUtil.getParameter(request, prefix + "a_cost_zero_exist", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setScqVerNo(JSPUtil.getParameter(request, prefix + "scq_ver_no", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setObYdCd(JSPUtil.getParameter(request, prefix + "ob_yd_cd", ""));
		setIbYdCd(JSPUtil.getParameter(request, prefix + "ib_yd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setSCostZeroExist(JSPUtil.getParameter(request, prefix + "s_cost_zero_exist", ""));
		setTCostZeroExist(JSPUtil.getParameter(request, prefix + "t_cost_zero_exist", ""));
		setNCostZeroExist(JSPUtil.getParameter(request, prefix + "n_cost_zero_exist", ""));
		setGCost(JSPUtil.getParameter(request, prefix + "g_cost", ""));
		setSCost(JSPUtil.getParameter(request, prefix + "s_cost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AwkCgoExtraCostByRouteVO[]
	 */
	public AwkCgoExtraCostByRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AwkCgoExtraCostByRouteVO[]
	 */
	public AwkCgoExtraCostByRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AwkCgoExtraCostByRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] tCost = (JSPUtil.getParameter(request, prefix	+ "t_cost", length));
			String[] scqVerNoTmp = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no_tmp", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] wCost = (JSPUtil.getParameter(request, prefix	+ "w_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] wCostZeroExist = (JSPUtil.getParameter(request, prefix	+ "w_cost_zero_exist", length));
			String[] tmpYn = (JSPUtil.getParameter(request, prefix	+ "tmp_yn", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] nCost = (JSPUtil.getParameter(request, prefix	+ "n_cost", length));
			String[] routTpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_tp_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] aCost = (JSPUtil.getParameter(request, prefix	+ "a_cost", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ydCostSeq = (JSPUtil.getParameter(request, prefix	+ "yd_cost_seq", length));
			String[] routTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_tp_cd", length));
			String[] gCostZeroExist = (JSPUtil.getParameter(request, prefix	+ "g_cost_zero_exist", length));
			String[] routCostSeq = (JSPUtil.getParameter(request, prefix	+ "rout_cost_seq", length));
			String[] aCostZeroExist = (JSPUtil.getParameter(request, prefix	+ "a_cost_zero_exist", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] scqVerNo = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] obYdCd = (JSPUtil.getParameter(request, prefix	+ "ob_yd_cd", length));
			String[] ibYdCd = (JSPUtil.getParameter(request, prefix	+ "ib_yd_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] sCostZeroExist = (JSPUtil.getParameter(request, prefix	+ "s_cost_zero_exist", length));
			String[] tCostZeroExist = (JSPUtil.getParameter(request, prefix	+ "t_cost_zero_exist", length));
			String[] nCostZeroExist = (JSPUtil.getParameter(request, prefix	+ "n_cost_zero_exist", length));
			String[] gCost = (JSPUtil.getParameter(request, prefix	+ "g_cost", length));
			String[] sCost = (JSPUtil.getParameter(request, prefix	+ "s_cost", length));
			
			for (int i = 0; i < length; i++) {
				model = new AwkCgoExtraCostByRouteVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (tCost[i] != null)
					model.setTCost(tCost[i]);
				if (scqVerNoTmp[i] != null)
					model.setScqVerNoTmp(scqVerNoTmp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (wCost[i] != null)
					model.setWCost(wCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costTpCd[i] != null)
					model.setCostTpCd(costTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (wCostZeroExist[i] != null)
					model.setWCostZeroExist(wCostZeroExist[i]);
				if (tmpYn[i] != null)
					model.setTmpYn(tmpYn[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (nCost[i] != null)
					model.setNCost(nCost[i]);
				if (routTpSeq[i] != null)
					model.setRoutTpSeq(routTpSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (aCost[i] != null)
					model.setACost(aCost[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ydCostSeq[i] != null)
					model.setYdCostSeq(ydCostSeq[i]);
				if (routTpCd[i] != null)
					model.setRoutTpCd(routTpCd[i]);
				if (gCostZeroExist[i] != null)
					model.setGCostZeroExist(gCostZeroExist[i]);
				if (routCostSeq[i] != null)
					model.setRoutCostSeq(routCostSeq[i]);
				if (aCostZeroExist[i] != null)
					model.setACostZeroExist(aCostZeroExist[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (scqVerNo[i] != null)
					model.setScqVerNo(scqVerNo[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (obYdCd[i] != null)
					model.setObYdCd(obYdCd[i]);
				if (ibYdCd[i] != null)
					model.setIbYdCd(ibYdCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (sCostZeroExist[i] != null)
					model.setSCostZeroExist(sCostZeroExist[i]);
				if (tCostZeroExist[i] != null)
					model.setTCostZeroExist(tCostZeroExist[i]);
				if (nCostZeroExist[i] != null)
					model.setNCostZeroExist(nCostZeroExist[i]);
				if (gCost[i] != null)
					model.setGCost(gCost[i]);
				if (sCost[i] != null)
					model.setSCost(sCost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAwkCgoExtraCostByRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AwkCgoExtraCostByRouteVO[]
	 */
	public AwkCgoExtraCostByRouteVO[] getAwkCgoExtraCostByRouteVOs(){
		AwkCgoExtraCostByRouteVO[] vos = (AwkCgoExtraCostByRouteVO[])models.toArray(new AwkCgoExtraCostByRouteVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCost = this.tCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNoTmp = this.scqVerNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wCost = this.wCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpCd = this.costTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wCostZeroExist = this.wCostZeroExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpYn = this.tmpYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCost = this.nCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routTpSeq = this.routTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCost = this.aCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCostSeq = this.ydCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routTpCd = this.routTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCostZeroExist = this.gCostZeroExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCostSeq = this.routCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCostZeroExist = this.aCostZeroExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNo = this.scqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obYdCd = this.obYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibYdCd = this.ibYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostZeroExist = this.sCostZeroExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCostZeroExist = this.tCostZeroExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCostZeroExist = this.nCostZeroExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCost = this.gCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCost = this.sCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
