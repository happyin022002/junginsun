/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentVO.java
*@FileTitle : AdjustmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.04.13 함대성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdjustmentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjustmentVO> models = new ArrayList<AdjustmentVO>();
	
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dctAdjDy = null;
	/* Column Info */
	private String polConti = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCnt = null;
	/* Column Info */
	private String isDctAdjEtb = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String isDctAdjEtd = null;
	/* Column Info */
	private String podCnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cctAdjTpNm = null;
	/* Column Info */
	private String cctAdjHrmnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dctAdjEtbDys = null;
	/* Column Info */
	private String podConti = null;
	/* Column Info */
	private String blockLane = null;
	/* Column Info */
	private String cctAdjEtdDys = null;
	/* Column Info */
	private String etdAdjHrmnt = null;
	/* Column Info */
	private String etdAdjDy = null;
	/* Column Info */
	private String dctAdjEtdDys = null;
	/* Column Info */
	private String isDctAdjDy = null;
	/* Column Info */
	private String cctAdjDy = null;
	/* Column Info */
	private String adjSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String isCctAdjEtb = null;
	/* Column Info */
	private String isCctAdjDy = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String dctAdjTpNm = null;
	/* Column Info */
	private String cctAdjEtbDys = null;
	/* Column Info */
	private String dctAdjHrmnt = null;
	/* Column Info */
	private String isCctAdjEtd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AdjustmentVO() {}

	public AdjustmentVO(String ibflag, String pagerows, String polCd, String podCd, String blockLane, String slanCd, String adjSeq, String etdAdjDy, String etdAdjHrmnt, String dctAdjTpNm, String isDctAdjDy, String isDctAdjEtb, String isDctAdjEtd, String dctAdjDy, String dctAdjEtbDys, String dctAdjEtdDys, String dctAdjHrmnt, String cctAdjTpNm, String isCctAdjDy, String isCctAdjEtb, String isCctAdjEtd, String cctAdjDy, String cctAdjEtbDys, String cctAdjEtdDys, String cctAdjHrmnt, String custTrdPrnrId, String polCnt, String podCnt, String polConti, String podConti, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.creDt = creDt;
		this.dctAdjDy = dctAdjDy;
		this.polConti = polConti;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.polCnt = polCnt;
		this.isDctAdjEtb = isDctAdjEtb;
		this.custTrdPrnrId = custTrdPrnrId;
		this.isDctAdjEtd = isDctAdjEtd;
		this.podCnt = podCnt;
		this.updUsrId = updUsrId;
		this.cctAdjTpNm = cctAdjTpNm;
		this.cctAdjHrmnt = cctAdjHrmnt;
		this.updDt = updDt;
		this.dctAdjEtbDys = dctAdjEtbDys;
		this.podConti = podConti;
		this.blockLane = blockLane;
		this.cctAdjEtdDys = cctAdjEtdDys;
		this.etdAdjHrmnt = etdAdjHrmnt;
		this.etdAdjDy = etdAdjDy;
		this.dctAdjEtdDys = dctAdjEtdDys;
		this.isDctAdjDy = isDctAdjDy;
		this.cctAdjDy = cctAdjDy;
		this.adjSeq = adjSeq;
		this.podCd = podCd;
		this.isCctAdjEtb = isCctAdjEtb;
		this.isCctAdjDy = isCctAdjDy;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.dctAdjTpNm = dctAdjTpNm;
		this.cctAdjEtbDys = cctAdjEtbDys;
		this.dctAdjHrmnt = dctAdjHrmnt;
		this.isCctAdjEtd = isCctAdjEtd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dct_adj_dy", getDctAdjDy());
		this.hashColumns.put("pol_conti", getPolConti());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cnt", getPolCnt());
		this.hashColumns.put("is_dct_adj_etb", getIsDctAdjEtb());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("is_dct_adj_etd", getIsDctAdjEtd());
		this.hashColumns.put("pod_cnt", getPodCnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cct_adj_tp_nm", getCctAdjTpNm());
		this.hashColumns.put("cct_adj_hrmnt", getCctAdjHrmnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dct_adj_etb_dys", getDctAdjEtbDys());
		this.hashColumns.put("pod_conti", getPodConti());
		this.hashColumns.put("block_lane", getBlockLane());
		this.hashColumns.put("cct_adj_etd_dys", getCctAdjEtdDys());
		this.hashColumns.put("etd_adj_hrmnt", getEtdAdjHrmnt());
		this.hashColumns.put("etd_adj_dy", getEtdAdjDy());
		this.hashColumns.put("dct_adj_etd_dys", getDctAdjEtdDys());
		this.hashColumns.put("is_dct_adj_dy", getIsDctAdjDy());
		this.hashColumns.put("cct_adj_dy", getCctAdjDy());
		this.hashColumns.put("adj_seq", getAdjSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("is_cct_adj_etb", getIsCctAdjEtb());
		this.hashColumns.put("is_cct_adj_dy", getIsCctAdjDy());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("dct_adj_tp_nm", getDctAdjTpNm());
		this.hashColumns.put("cct_adj_etb_dys", getCctAdjEtbDys());
		this.hashColumns.put("dct_adj_hrmnt", getDctAdjHrmnt());
		this.hashColumns.put("is_cct_adj_etd", getIsCctAdjEtd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dct_adj_dy", "dctAdjDy");
		this.hashFields.put("pol_conti", "polConti");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cnt", "polCnt");
		this.hashFields.put("is_dct_adj_etb", "isDctAdjEtb");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("is_dct_adj_etd", "isDctAdjEtd");
		this.hashFields.put("pod_cnt", "podCnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cct_adj_tp_nm", "cctAdjTpNm");
		this.hashFields.put("cct_adj_hrmnt", "cctAdjHrmnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dct_adj_etb_dys", "dctAdjEtbDys");
		this.hashFields.put("pod_conti", "podConti");
		this.hashFields.put("block_lane", "blockLane");
		this.hashFields.put("cct_adj_etd_dys", "cctAdjEtdDys");
		this.hashFields.put("etd_adj_hrmnt", "etdAdjHrmnt");
		this.hashFields.put("etd_adj_dy", "etdAdjDy");
		this.hashFields.put("dct_adj_etd_dys", "dctAdjEtdDys");
		this.hashFields.put("is_dct_adj_dy", "isDctAdjDy");
		this.hashFields.put("cct_adj_dy", "cctAdjDy");
		this.hashFields.put("adj_seq", "adjSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("is_cct_adj_etb", "isCctAdjEtb");
		this.hashFields.put("is_cct_adj_dy", "isCctAdjDy");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("dct_adj_tp_nm", "dctAdjTpNm");
		this.hashFields.put("cct_adj_etb_dys", "cctAdjEtbDys");
		this.hashFields.put("dct_adj_hrmnt", "dctAdjHrmnt");
		this.hashFields.put("is_cct_adj_etd", "isCctAdjEtd");
		return this.hashFields;
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
	 * @return dctAdjDy
	 */
	public String getDctAdjDy() {
		return this.dctAdjDy;
	}
	
	/**
	 * Column Info
	 * @return polConti
	 */
	public String getPolConti() {
		return this.polConti;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return polCnt
	 */
	public String getPolCnt() {
		return this.polCnt;
	}
	
	/**
	 * Column Info
	 * @return isDctAdjEtb
	 */
	public String getIsDctAdjEtb() {
		return this.isDctAdjEtb;
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
	 * @return isDctAdjEtd
	 */
	public String getIsDctAdjEtd() {
		return this.isDctAdjEtd;
	}
	
	/**
	 * Column Info
	 * @return podCnt
	 */
	public String getPodCnt() {
		return this.podCnt;
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
	 * @return cctAdjTpNm
	 */
	public String getCctAdjTpNm() {
		return this.cctAdjTpNm;
	}
	
	/**
	 * Column Info
	 * @return cctAdjHrmnt
	 */
	public String getCctAdjHrmnt() {
		return this.cctAdjHrmnt;
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
	 * @return dctAdjEtbDys
	 */
	public String getDctAdjEtbDys() {
		return this.dctAdjEtbDys;
	}
	
	/**
	 * Column Info
	 * @return podConti
	 */
	public String getPodConti() {
		return this.podConti;
	}
	
	/**
	 * Column Info
	 * @return blockLane
	 */
	public String getBlockLane() {
		return this.blockLane;
	}
	
	/**
	 * Column Info
	 * @return cctAdjEtdDys
	 */
	public String getCctAdjEtdDys() {
		return this.cctAdjEtdDys;
	}
	
	/**
	 * Column Info
	 * @return etdAdjHrmnt
	 */
	public String getEtdAdjHrmnt() {
		return this.etdAdjHrmnt;
	}
	
	/**
	 * Column Info
	 * @return etdAdjDy
	 */
	public String getEtdAdjDy() {
		return this.etdAdjDy;
	}
	
	/**
	 * Column Info
	 * @return dctAdjEtdDys
	 */
	public String getDctAdjEtdDys() {
		return this.dctAdjEtdDys;
	}
	
	/**
	 * Column Info
	 * @return isDctAdjDy
	 */
	public String getIsDctAdjDy() {
		return this.isDctAdjDy;
	}
	
	/**
	 * Column Info
	 * @return cctAdjDy
	 */
	public String getCctAdjDy() {
		return this.cctAdjDy;
	}
	
	/**
	 * Column Info
	 * @return adjSeq
	 */
	public String getAdjSeq() {
		return this.adjSeq;
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
	 * @return isCctAdjEtb
	 */
	public String getIsCctAdjEtb() {
		return this.isCctAdjEtb;
	}
	
	/**
	 * Column Info
	 * @return isCctAdjDy
	 */
	public String getIsCctAdjDy() {
		return this.isCctAdjDy;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return dctAdjTpNm
	 */
	public String getDctAdjTpNm() {
		return this.dctAdjTpNm;
	}
	
	/**
	 * Column Info
	 * @return cctAdjEtbDys
	 */
	public String getCctAdjEtbDys() {
		return this.cctAdjEtbDys;
	}
	
	/**
	 * Column Info
	 * @return dctAdjHrmnt
	 */
	public String getDctAdjHrmnt() {
		return this.dctAdjHrmnt;
	}
	
	/**
	 * Column Info
	 * @return isCctAdjEtd
	 */
	public String getIsCctAdjEtd() {
		return this.isCctAdjEtd;
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
	 * @param dctAdjDy
	 */
	public void setDctAdjDy(String dctAdjDy) {
		this.dctAdjDy = dctAdjDy;
	}
	
	/**
	 * Column Info
	 * @param polConti
	 */
	public void setPolConti(String polConti) {
		this.polConti = polConti;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param polCnt
	 */
	public void setPolCnt(String polCnt) {
		this.polCnt = polCnt;
	}
	
	/**
	 * Column Info
	 * @param isDctAdjEtb
	 */
	public void setIsDctAdjEtb(String isDctAdjEtb) {
		this.isDctAdjEtb = isDctAdjEtb;
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
	 * @param isDctAdjEtd
	 */
	public void setIsDctAdjEtd(String isDctAdjEtd) {
		this.isDctAdjEtd = isDctAdjEtd;
	}
	
	/**
	 * Column Info
	 * @param podCnt
	 */
	public void setPodCnt(String podCnt) {
		this.podCnt = podCnt;
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
	 * @param cctAdjTpNm
	 */
	public void setCctAdjTpNm(String cctAdjTpNm) {
		this.cctAdjTpNm = cctAdjTpNm;
	}
	
	/**
	 * Column Info
	 * @param cctAdjHrmnt
	 */
	public void setCctAdjHrmnt(String cctAdjHrmnt) {
		this.cctAdjHrmnt = cctAdjHrmnt;
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
	 * @param dctAdjEtbDys
	 */
	public void setDctAdjEtbDys(String dctAdjEtbDys) {
		this.dctAdjEtbDys = dctAdjEtbDys;
	}
	
	/**
	 * Column Info
	 * @param podConti
	 */
	public void setPodConti(String podConti) {
		this.podConti = podConti;
	}
	
	/**
	 * Column Info
	 * @param blockLane
	 */
	public void setBlockLane(String blockLane) {
		this.blockLane = blockLane;
	}
	
	/**
	 * Column Info
	 * @param cctAdjEtdDys
	 */
	public void setCctAdjEtdDys(String cctAdjEtdDys) {
		this.cctAdjEtdDys = cctAdjEtdDys;
	}
	
	/**
	 * Column Info
	 * @param etdAdjHrmnt
	 */
	public void setEtdAdjHrmnt(String etdAdjHrmnt) {
		this.etdAdjHrmnt = etdAdjHrmnt;
	}
	
	/**
	 * Column Info
	 * @param etdAdjDy
	 */
	public void setEtdAdjDy(String etdAdjDy) {
		this.etdAdjDy = etdAdjDy;
	}
	
	/**
	 * Column Info
	 * @param dctAdjEtdDys
	 */
	public void setDctAdjEtdDys(String dctAdjEtdDys) {
		this.dctAdjEtdDys = dctAdjEtdDys;
	}
	
	/**
	 * Column Info
	 * @param isDctAdjDy
	 */
	public void setIsDctAdjDy(String isDctAdjDy) {
		this.isDctAdjDy = isDctAdjDy;
	}
	
	/**
	 * Column Info
	 * @param cctAdjDy
	 */
	public void setCctAdjDy(String cctAdjDy) {
		this.cctAdjDy = cctAdjDy;
	}
	
	/**
	 * Column Info
	 * @param adjSeq
	 */
	public void setAdjSeq(String adjSeq) {
		this.adjSeq = adjSeq;
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
	 * @param isCctAdjEtb
	 */
	public void setIsCctAdjEtb(String isCctAdjEtb) {
		this.isCctAdjEtb = isCctAdjEtb;
	}
	
	/**
	 * Column Info
	 * @param isCctAdjDy
	 */
	public void setIsCctAdjDy(String isCctAdjDy) {
		this.isCctAdjDy = isCctAdjDy;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param dctAdjTpNm
	 */
	public void setDctAdjTpNm(String dctAdjTpNm) {
		this.dctAdjTpNm = dctAdjTpNm;
	}
	
	/**
	 * Column Info
	 * @param cctAdjEtbDys
	 */
	public void setCctAdjEtbDys(String cctAdjEtbDys) {
		this.cctAdjEtbDys = cctAdjEtbDys;
	}
	
	/**
	 * Column Info
	 * @param dctAdjHrmnt
	 */
	public void setDctAdjHrmnt(String dctAdjHrmnt) {
		this.dctAdjHrmnt = dctAdjHrmnt;
	}
	
	/**
	 * Column Info
	 * @param isCctAdjEtd
	 */
	public void setIsCctAdjEtd(String isCctAdjEtd) {
		this.isCctAdjEtd = isCctAdjEtd;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDctAdjDy(JSPUtil.getParameter(request, prefix + "dct_adj_dy", ""));
		setPolConti(JSPUtil.getParameter(request, prefix + "pol_conti", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCnt(JSPUtil.getParameter(request, prefix + "pol_cnt", ""));
		setIsDctAdjEtb(JSPUtil.getParameter(request, prefix + "is_dct_adj_etb", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setIsDctAdjEtd(JSPUtil.getParameter(request, prefix + "is_dct_adj_etd", ""));
		setPodCnt(JSPUtil.getParameter(request, prefix + "pod_cnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCctAdjTpNm(JSPUtil.getParameter(request, prefix + "cct_adj_tp_nm", ""));
		setCctAdjHrmnt(JSPUtil.getParameter(request, prefix + "cct_adj_hrmnt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDctAdjEtbDys(JSPUtil.getParameter(request, prefix + "dct_adj_etb_dys", ""));
		setPodConti(JSPUtil.getParameter(request, prefix + "pod_conti", ""));
		setBlockLane(JSPUtil.getParameter(request, prefix + "block_lane", ""));
		setCctAdjEtdDys(JSPUtil.getParameter(request, prefix + "cct_adj_etd_dys", ""));
		setEtdAdjHrmnt(JSPUtil.getParameter(request, prefix + "etd_adj_hrmnt", ""));
		setEtdAdjDy(JSPUtil.getParameter(request, prefix + "etd_adj_dy", ""));
		setDctAdjEtdDys(JSPUtil.getParameter(request, prefix + "dct_adj_etd_dys", ""));
		setIsDctAdjDy(JSPUtil.getParameter(request, prefix + "is_dct_adj_dy", ""));
		setCctAdjDy(JSPUtil.getParameter(request, prefix + "cct_adj_dy", ""));
		setAdjSeq(JSPUtil.getParameter(request, prefix + "adj_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIsCctAdjEtb(JSPUtil.getParameter(request, prefix + "is_cct_adj_etb", ""));
		setIsCctAdjDy(JSPUtil.getParameter(request, prefix + "is_cct_adj_dy", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setDctAdjTpNm(JSPUtil.getParameter(request, prefix + "dct_adj_tp_nm", ""));
		setCctAdjEtbDys(JSPUtil.getParameter(request, prefix + "cct_adj_etb_dys", ""));
		setDctAdjHrmnt(JSPUtil.getParameter(request, prefix + "dct_adj_hrmnt", ""));
		setIsCctAdjEtd(JSPUtil.getParameter(request, prefix + "is_cct_adj_etd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustmentVO[]
	 */
	public AdjustmentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustmentVO[]
	 */
	public AdjustmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjustmentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dctAdjDy = (JSPUtil.getParameter(request, prefix	+ "dct_adj_dy", length));
			String[] polConti = (JSPUtil.getParameter(request, prefix	+ "pol_conti", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCnt = (JSPUtil.getParameter(request, prefix	+ "pol_cnt", length));
			String[] isDctAdjEtb = (JSPUtil.getParameter(request, prefix	+ "is_dct_adj_etb", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] isDctAdjEtd = (JSPUtil.getParameter(request, prefix	+ "is_dct_adj_etd", length));
			String[] podCnt = (JSPUtil.getParameter(request, prefix	+ "pod_cnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cctAdjTpNm = (JSPUtil.getParameter(request, prefix	+ "cct_adj_tp_nm", length));
			String[] cctAdjHrmnt = (JSPUtil.getParameter(request, prefix	+ "cct_adj_hrmnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dctAdjEtbDys = (JSPUtil.getParameter(request, prefix	+ "dct_adj_etb_dys", length));
			String[] podConti = (JSPUtil.getParameter(request, prefix	+ "pod_conti", length));
			String[] blockLane = (JSPUtil.getParameter(request, prefix	+ "block_lane", length));
			String[] cctAdjEtdDys = (JSPUtil.getParameter(request, prefix	+ "cct_adj_etd_dys", length));
			String[] etdAdjHrmnt = (JSPUtil.getParameter(request, prefix	+ "etd_adj_hrmnt", length));
			String[] etdAdjDy = (JSPUtil.getParameter(request, prefix	+ "etd_adj_dy", length));
			String[] dctAdjEtdDys = (JSPUtil.getParameter(request, prefix	+ "dct_adj_etd_dys", length));
			String[] isDctAdjDy = (JSPUtil.getParameter(request, prefix	+ "is_dct_adj_dy", length));
			String[] cctAdjDy = (JSPUtil.getParameter(request, prefix	+ "cct_adj_dy", length));
			String[] adjSeq = (JSPUtil.getParameter(request, prefix	+ "adj_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] isCctAdjEtb = (JSPUtil.getParameter(request, prefix	+ "is_cct_adj_etb", length));
			String[] isCctAdjDy = (JSPUtil.getParameter(request, prefix	+ "is_cct_adj_dy", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] dctAdjTpNm = (JSPUtil.getParameter(request, prefix	+ "dct_adj_tp_nm", length));
			String[] cctAdjEtbDys = (JSPUtil.getParameter(request, prefix	+ "cct_adj_etb_dys", length));
			String[] dctAdjHrmnt = (JSPUtil.getParameter(request, prefix	+ "dct_adj_hrmnt", length));
			String[] isCctAdjEtd = (JSPUtil.getParameter(request, prefix	+ "is_cct_adj_etd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjustmentVO();
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dctAdjDy[i] != null)
					model.setDctAdjDy(dctAdjDy[i]);
				if (polConti[i] != null)
					model.setPolConti(polConti[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCnt[i] != null)
					model.setPolCnt(polCnt[i]);
				if (isDctAdjEtb[i] != null)
					model.setIsDctAdjEtb(isDctAdjEtb[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (isDctAdjEtd[i] != null)
					model.setIsDctAdjEtd(isDctAdjEtd[i]);
				if (podCnt[i] != null)
					model.setPodCnt(podCnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cctAdjTpNm[i] != null)
					model.setCctAdjTpNm(cctAdjTpNm[i]);
				if (cctAdjHrmnt[i] != null)
					model.setCctAdjHrmnt(cctAdjHrmnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dctAdjEtbDys[i] != null)
					model.setDctAdjEtbDys(dctAdjEtbDys[i]);
				if (podConti[i] != null)
					model.setPodConti(podConti[i]);
				if (blockLane[i] != null)
					model.setBlockLane(blockLane[i]);
				if (cctAdjEtdDys[i] != null)
					model.setCctAdjEtdDys(cctAdjEtdDys[i]);
				if (etdAdjHrmnt[i] != null)
					model.setEtdAdjHrmnt(etdAdjHrmnt[i]);
				if (etdAdjDy[i] != null)
					model.setEtdAdjDy(etdAdjDy[i]);
				if (dctAdjEtdDys[i] != null)
					model.setDctAdjEtdDys(dctAdjEtdDys[i]);
				if (isDctAdjDy[i] != null)
					model.setIsDctAdjDy(isDctAdjDy[i]);
				if (cctAdjDy[i] != null)
					model.setCctAdjDy(cctAdjDy[i]);
				if (adjSeq[i] != null)
					model.setAdjSeq(adjSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (isCctAdjEtb[i] != null)
					model.setIsCctAdjEtb(isCctAdjEtb[i]);
				if (isCctAdjDy[i] != null)
					model.setIsCctAdjDy(isCctAdjDy[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (dctAdjTpNm[i] != null)
					model.setDctAdjTpNm(dctAdjTpNm[i]);
				if (cctAdjEtbDys[i] != null)
					model.setCctAdjEtbDys(cctAdjEtbDys[i]);
				if (dctAdjHrmnt[i] != null)
					model.setDctAdjHrmnt(dctAdjHrmnt[i]);
				if (isCctAdjEtd[i] != null)
					model.setIsCctAdjEtd(isCctAdjEtd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjustmentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustmentVO[]
	 */
	public AdjustmentVO[] getAdjustmentVOs(){
		AdjustmentVO[] vos = (AdjustmentVO[])models.toArray(new AdjustmentVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctAdjDy = this.dctAdjDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polConti = this.polConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCnt = this.polCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isDctAdjEtb = this.isDctAdjEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isDctAdjEtd = this.isDctAdjEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCnt = this.podCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctAdjTpNm = this.cctAdjTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctAdjHrmnt = this.cctAdjHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctAdjEtbDys = this.dctAdjEtbDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podConti = this.podConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blockLane = this.blockLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctAdjEtdDys = this.cctAdjEtdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdAdjHrmnt = this.etdAdjHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdAdjDy = this.etdAdjDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctAdjEtdDys = this.dctAdjEtdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isDctAdjDy = this.isDctAdjDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctAdjDy = this.cctAdjDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjSeq = this.adjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isCctAdjEtb = this.isCctAdjEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isCctAdjDy = this.isCctAdjDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctAdjTpNm = this.dctAdjTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctAdjEtbDys = this.cctAdjEtbDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctAdjHrmnt = this.dctAdjHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isCctAdjEtd = this.isCctAdjEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
