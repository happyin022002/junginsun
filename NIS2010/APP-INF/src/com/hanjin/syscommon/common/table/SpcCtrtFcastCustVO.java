/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpcCtrtFcastCustVO.java
*@FileTitle : SpcCtrtFcastCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.08
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.02.08 최윤성 
* 1.0 Creation
* 2013.02.08 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가 
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.util.ArrayList;
import java.util.Calendar;
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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcCtrtFcastCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcCtrtFcastCustVO> models = new ArrayList<SpcCtrtFcastCustVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String polIndSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fcast20ftQty = null;
	/* Column Info */
	private String fcastRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String ctrlLvlCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String modiGdt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String srepUsrId = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fcast40ftQty = null;
	/* Column Info */
	private String fcastSeq = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String podYdIndSeq = null;
	/* Column Info */
	private String polYdIndSeq = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String podIndSeq = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String viewType = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String scFlg = null;
	/* Column Info */
	private String custCtrlCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcCtrtFcastCustVO() {}

	public SpcCtrtFcastCustVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String iocTsCd, String srepUsrId, String ctrtOfcCd, String vslCd, String skdVoyNo, String skdDirCd, String custCntCd, String custSeq, String fcastSeq, String slsRgnOfcCd, String polYdCd, String podYdCd, String subTrdCd, String scNo, String fcastTtlQty, String fcast20ftQty, String fcast40ftQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, String fcastTtlWgt, String ctrlLvlCd, String modiGdt, String polIndSeq, String podIndSeq, String polYdIndSeq, String podYdIndSeq, String fcastRmk, String creUsrId, String creDt, String updUsrId, String updDt, String viewType, String rfaNo, String scFlg, String custCtrlCd) {
		this.vslCd = vslCd;
		this.polIndSeq = polIndSeq;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.fcast20ftQty = fcast20ftQty;
		this.fcastRmk = fcastRmk;
		this.ibflag = ibflag;
		this.fcastTtlQty = fcastTtlQty;
		this.ctrtOfcCd = ctrtOfcCd;
		this.scNo = scNo;
		this.fcast53ftQty = fcast53ftQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.ctrlLvlCd = ctrlLvlCd;
		this.podYdCd = podYdCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.iocTsCd = iocTsCd;
		this.modiGdt = modiGdt;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.srepUsrId = srepUsrId;
		this.fcastRfQty = fcastRfQty;
		this.creUsrId = creUsrId;
		this.fcast40ftQty = fcast40ftQty;
		this.fcastSeq = fcastSeq;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.polYdCd = polYdCd;
		this.podYdIndSeq = podYdIndSeq;
		this.polYdIndSeq = polYdIndSeq;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.podIndSeq = podIndSeq;
		this.subTrdCd = subTrdCd;
		this.viewType = viewType;
		this.rfaNo = rfaNo;
		this.scFlg = scFlg;
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pol_ind_seq", getPolIndSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fcast_20ft_qty", getFcast20ftQty());
		this.hashColumns.put("fcast_rmk", getFcastRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("ctrl_lvl_cd", getCtrlLvlCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("modi_gdt", getModiGdt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("srep_usr_id", getSrepUsrId());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fcast_40ft_qty", getFcast40ftQty());
		this.hashColumns.put("fcast_seq", getFcastSeq());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pod_yd_ind_seq", getPodYdIndSeq());
		this.hashColumns.put("pol_yd_ind_seq", getPolYdIndSeq());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("pod_ind_seq", getPodIndSeq());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("view_type", getViewType());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("sc_flg", getScFlg());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pol_ind_seq", "polIndSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fcast_20ft_qty", "fcast20ftQty");
		this.hashFields.put("fcast_rmk", "fcastRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("ctrl_lvl_cd", "ctrlLvlCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("modi_gdt", "modiGdt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("srep_usr_id", "srepUsrId");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fcast_40ft_qty", "fcast40ftQty");
		this.hashFields.put("fcast_seq", "fcastSeq");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pod_yd_ind_seq", "podYdIndSeq");
		this.hashFields.put("pol_yd_ind_seq", "polYdIndSeq");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("pod_ind_seq", "podIndSeq");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("view_type", "viewType");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("sc_flg", "scFlg");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return polIndSeq
	 */
	public String getPolIndSeq() {
		return this.polIndSeq;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return fcast20ftQty
	 */
	public String getFcast20ftQty() {
		return this.fcast20ftQty;
	}
	
	/**
	 * Column Info
	 * @return fcastRmk
	 */
	public String getFcastRmk() {
		return this.fcastRmk;
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
	 * @return fcastTtlQty
	 */
	public String getFcastTtlQty() {
		return this.fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return fcast53ftQty
	 */
	public String getFcast53ftQty() {
		return this.fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlWgt
	 */
	public String getFcastTtlWgt() {
		return this.fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return ctrlLvlCd
	 */
	public String getCtrlLvlCd() {
		return this.ctrlLvlCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
	}
	
	/**
	 * Column Info
	 * @return modiGdt
	 */
	public String getModiGdt() {
		return this.modiGdt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return srepUsrId
	 */
	public String getSrepUsrId() {
		return this.srepUsrId;
	}
	
	/**
	 * Column Info
	 * @return fcastRfQty
	 */
	public String getFcastRfQty() {
		return this.fcastRfQty;
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
	 * @return fcast40ftQty
	 */
	public String getFcast40ftQty() {
		return this.fcast40ftQty;
	}
	
	/**
	 * Column Info
	 * @return fcastSeq
	 */
	public String getFcastSeq() {
		return this.fcastSeq;
	}
	
	/**
	 * Column Info
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return podYdIndSeq
	 */
	public String getPodYdIndSeq() {
		return this.podYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @return polYdIndSeq
	 */
	public String getPolYdIndSeq() {
		return this.polYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftHcQty
	 */
	public String getFcast40ftHcQty() {
		return this.fcast40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return podIndSeq
	 */
	public String getPodIndSeq() {
		return this.podIndSeq;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return viewType
	 */
	public String getViewType() {
		return this.viewType;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return scFlg
	 */
	public String getScFlg() {
		return this.scFlg;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param polIndSeq
	 */
	public void setPolIndSeq(String polIndSeq) {
		this.polIndSeq = polIndSeq;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param fcast20ftQty
	 */
	public void setFcast20ftQty(String fcast20ftQty) {
		this.fcast20ftQty = fcast20ftQty;
	}
	
	/**
	 * Column Info
	 * @param fcastRmk
	 */
	public void setFcastRmk(String fcastRmk) {
		this.fcastRmk = fcastRmk;
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
	 * @param fcastTtlQty
	 */
	public void setFcastTtlQty(String fcastTtlQty) {
		this.fcastTtlQty = fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param fcast53ftQty
	 */
	public void setFcast53ftQty(String fcast53ftQty) {
		this.fcast53ftQty = fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlWgt
	 */
	public void setFcastTtlWgt(String fcastTtlWgt) {
		this.fcastTtlWgt = fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param ctrlLvlCd
	 */
	public void setCtrlLvlCd(String ctrlLvlCd) {
		this.ctrlLvlCd = ctrlLvlCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
	}
	
	/**
	 * Column Info
	 * @param modiGdt
	 */
	public void setModiGdt(String modiGdt) {
		this.modiGdt = modiGdt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param srepUsrId
	 */
	public void setSrepUsrId(String srepUsrId) {
		this.srepUsrId = srepUsrId;
	}
	
	/**
	 * Column Info
	 * @param fcastRfQty
	 */
	public void setFcastRfQty(String fcastRfQty) {
		this.fcastRfQty = fcastRfQty;
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
	 * @param fcast40ftQty
	 */
	public void setFcast40ftQty(String fcast40ftQty) {
		this.fcast40ftQty = fcast40ftQty;
	}
	
	/**
	 * Column Info
	 * @param fcastSeq
	 */
	public void setFcastSeq(String fcastSeq) {
		this.fcastSeq = fcastSeq;
	}
	
	/**
	 * Column Info
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param podYdIndSeq
	 */
	public void setPodYdIndSeq(String podYdIndSeq) {
		this.podYdIndSeq = podYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @param polYdIndSeq
	 */
	public void setPolYdIndSeq(String polYdIndSeq) {
		this.polYdIndSeq = polYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftHcQty
	 */
	public void setFcast40ftHcQty(String fcast40ftHcQty) {
		this.fcast40ftHcQty = fcast40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param podIndSeq
	 */
	public void setPodIndSeq(String podIndSeq) {
		this.podIndSeq = podIndSeq;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param viewType
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param scFlg
	 */
	public void setScFlg(String scFlg) {
		this.scFlg = scFlg;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPolIndSeq(JSPUtil.getParameter(request, prefix + "pol_ind_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFcast20ftQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_qty", ""));
		setFcastRmk(JSPUtil.getParameter(request, prefix + "fcast_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setCtrlLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_lvl_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
		setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSrepUsrId(JSPUtil.getParameter(request, prefix + "srep_usr_id", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFcast40ftQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_qty", ""));
		setFcastSeq(JSPUtil.getParameter(request, prefix + "fcast_seq", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setPodYdIndSeq(JSPUtil.getParameter(request, prefix + "pod_yd_ind_seq", ""));
		setPolYdIndSeq(JSPUtil.getParameter(request, prefix + "pol_yd_ind_seq", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setPodIndSeq(JSPUtil.getParameter(request, prefix + "pod_ind_seq", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setViewType(JSPUtil.getParameter(request, prefix + "view_type", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setScFlg(JSPUtil.getParameter(request, prefix + "sc_flg", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcCtrtFcastCustVO[]
	 */
	public SpcCtrtFcastCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcCtrtFcastCustVO[]
	 */
	public SpcCtrtFcastCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcCtrtFcastCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;
  		
  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		Calendar calendar = Calendar.getInstance();
		String date = ""+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DATE) + " "+calendar.get(Calendar.HOUR_OF_DAY) + ":"+calendar.get(Calendar.MINUTE) + ":"+calendar.get(Calendar.SECOND);
  
		try {
			String[] vslCd			= (JSPUtil.getParameter(request, prefix	+ "vsl_cd"			, length));
			String[] polIndSeq		= (JSPUtil.getParameter(request, prefix	+ "pol_ind_seq"		, length));
			String[] creDt			= (JSPUtil.getParameter(request, prefix	+ "cre_dt"			, length));
			String[] trdCd			= (JSPUtil.getParameter(request, prefix	+ "trd_cd"			, length));
			String[] rlaneCd		= (JSPUtil.getParameter(request, prefix	+ "rlane_cd"		, length));
			String[] pagerows		= (JSPUtil.getParameter(request, prefix	+ "pagerows"		, length));
			String[] ibflag			= (JSPUtil.getParameter(request, prefix	+ "ibflag"			, length));
			String[] ctrtOfcCd		= (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd"		, length));
			String[] scNo			= (JSPUtil.getParameter(request, prefix	+ "sc_no"			, length));
			String[] ctrlLvlCd		= (JSPUtil.getParameter(request, prefix	+ "ctrl_lvl_cd"		, length));
			String[] podYdCd		= (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd"		, length));
			String[] updUsrId		= (JSPUtil.getParameter(request, prefix	+ "upd_usr_id"		, length));
			String[] custCntCd		= (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd"		, length));
			String[] updDt			= (JSPUtil.getParameter(request, prefix	+ "upd_dt"			, length));
			String[] iocTsCd		= (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd"		, length));
			String[] skdVoyNo		= (JSPUtil.getParameter(request, prefix	+ "skd_voy_no"		, length));
			String[] custSeq		= (JSPUtil.getParameter(request, prefix	+ "cust_seq"		, length));
			String[] skdDirCd		= (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd"		, length));
			String[] srepUsrId		= (JSPUtil.getParameter(request, prefix	+ "srep_usr_id"		, length));
			String[] creUsrId		= (JSPUtil.getParameter(request, prefix	+ "cre_usr_id"		, length));
			String[] fcastSeq		= (JSPUtil.getParameter(request, prefix	+ "fcast_seq"		, length));
			String[] polYdCd		= (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd"		, length));
			String[] podYdIndSeq	= (JSPUtil.getParameter(request, prefix	+ "pod_yd_ind_seq"	, length));
			String[] polYdIndSeq	= (JSPUtil.getParameter(request, prefix	+ "pol_yd_ind_seq"	, length));
			String[] slsRgnOfcCd	= (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd"	, length));
			String[] podIndSeq		= (JSPUtil.getParameter(request, prefix	+ "pod_ind_seq"		, length));
			String[] subTrdCd		= (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd"		, length));
			String   modiGdt		= date;
			String   viewType		= request.getParameterValues(prefix + "view_type")[0];
			String[] rfaNo			= (JSPUtil.getParameter(request, prefix	+ "rfa_no"			, length));
			String[] scFlg			= (JSPUtil.getParameter(request, prefix	+ "sc_flg"			, length));
			String[] custCtrlCd		= (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd"	, length));
			 
			String[] weekCount = request.getParameterValues(prefix + "week_count");
			int wk = Integer.parseInt(weekCount[0]);
			
			String[][] fcastTtlQty		= new String[wk][];
			String[][] fcast20ftQty		= new String[wk][];
			String[][] fcast40ftQty		= new String[wk][];
			String[][] fcast40ftHcQty	= new String[wk][];
			String[][] fcast45ftHcQty	= new String[wk][];
			String[][] fcast53ftQty		= new String[wk][];
			String[][] fcastRfQty		= new String[wk][];
			String[][] fcastTtlWgt		= new String[wk][];
			String[][] fcastRmk			= new String[wk][];
			
			for(int j = 1; j < wk + 1; j++) {
				fcastTtlQty[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_ttl_qty_"		+ j, length));
				fcast20ftQty[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_20ft_qty_"		+ j, length));
				fcast40ftQty[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_40ft_qty_"		+ j, length));
				fcast40ftHcQty[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty_"	+ j, length));
				fcast45ftHcQty[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty_"	+ j, length));
				fcast53ftQty[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_53ft_qty_"		+ j, length));
				fcastRfQty[j-1]		= (JSPUtil.getParameter(request, prefix + "fcast_rf_qty_"		+ j, length));
				fcastTtlWgt[j-1]	= (JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt_"		+ j, length));
				fcastRmk[j-1]		= (JSPUtil.getParameter(request, prefix	+ "fcast_rmk_"			+ j, length));
			}
			
			for (int i = 0; i < length; i++) {
				model = new SpcCtrtFcastCustVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (polIndSeq[i] != null)
					model.setPolIndSeq(polIndSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fcast20ftQty[i%wk][i/wk] != null)
					model.setFcast20ftQty(fcast20ftQty[i%wk][i/wk]);
				if (fcastRmk[i%wk][i/wk] != null)
					model.setFcastRmk(fcastRmk[i%wk][i/wk]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastTtlQty[i%wk][i/wk] != null)
					model.setFcastTtlQty(fcastTtlQty[i%wk][i/wk]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fcast53ftQty[i%wk][i/wk] != null)
					model.setFcast53ftQty(fcast53ftQty[i%wk][i/wk]);
				if (fcastTtlWgt[i%wk][i/wk] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i%wk][i/wk]);
				if (ctrlLvlCd[i] != null)
					model.setCtrlLvlCd(ctrlLvlCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (modiGdt != null)
					model.setModiGdt(modiGdt);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (srepUsrId[i] != null)
					model.setSrepUsrId(srepUsrId[i]);
				if (fcastRfQty[i%wk][i/wk] != null)
					model.setFcastRfQty(fcastRfQty[i%wk][i/wk]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fcast40ftQty[i%wk][i/wk] != null)
					model.setFcast40ftQty(fcast40ftQty[i%wk][i/wk]);
				if (fcastSeq[i] != null)
					model.setFcastSeq(fcastSeq[i]);
				if (fcast45ftHcQty[i%wk][i/wk] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i%wk][i/wk]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (podYdIndSeq[i] != null)
					model.setPodYdIndSeq(podYdIndSeq[i]);
				if (polYdIndSeq[i] != null)
					model.setPolYdIndSeq(polYdIndSeq[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (fcast40ftHcQty[i%wk][i/wk] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i%wk][i/wk]);
				if (podIndSeq[i] != null)
					model.setPodIndSeq(podIndSeq[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (viewType != null)
					model.setViewType(viewType);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (scFlg[i] != null)
					model.setScFlg(scFlg[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcCtrtFcastCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcCtrtFcastCustVO[]
	 */
	public SpcCtrtFcastCustVO[] getSpcCtrtFcastCustVOs(){
		SpcCtrtFcastCustVO[] vos = (SpcCtrtFcastCustVO[])models.toArray(new SpcCtrtFcastCustVO[models.size()]);
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
		this.vslCd			= this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polIndSeq		= this.polIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt			= this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd			= this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd		= this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows		= this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20ftQty	= this.fcast20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRmk		= this.fcastRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag			= this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty	= this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd		= this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo			= this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty	= this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt	= this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLvlCd		= this.ctrlLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd		= this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId		= this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd		= this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt			= this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd		= this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiGdt		= this.modiGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo		= this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq		= this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd		= this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepUsrId		= this.srepUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty		= this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId		= this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftQty	= this.fcast40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastSeq		= this.fcastSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd		= this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdIndSeq	= this.podYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdIndSeq	= this.polYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd	= this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podIndSeq		= this.podIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd		= this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewType		= this.viewType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo			= this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scFlg			= this.scFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd		= this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
