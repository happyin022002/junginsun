/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchContractForecastManageListVO.java
*@FileTitle : SearchContractForecastManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.28  
* 1.0 Creation
* 2013.01.28 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo;

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

public class SearchContractForecastManageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractForecastManageListVO> models = new ArrayList<SearchContractForecastManageListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String lfcastTtlQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String lfcast20ftQty = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String guideQty = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fcast20ftQty = null;
	/* Column Info */
	private String fcastRmk = null;
	/* Column Info */
	private String lfcast45ftHcQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lfcast40ftQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String laneNum = null;
	/* Column Info */
	private String lfcastRfQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String lfcast40ftHcQty = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String fcast40ftQty = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String lfcast53ftQty = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String lfcastTtlWgt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String fcastSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fcastCnt = null;
	/* Column Info */
	private String viewType = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String scFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContractForecastManageListVO() {}

	public SearchContractForecastManageListVO(String ibflag         , String pagerows      , String trdCd        , String iocTsCd      , String laneNum        ,
			                                  String srepCd         , String ctrtOfcCd     , String custTp       , String custCtrlCd   , String guideQty       ,
			                                  String custCntCd      , String custSeq       , String custNm       , String subTrdCd     , String rlaneCd        ,
			                                  String slsRgnOfcCd    , String costWk        , String vslCd        , String skdVoyNo     , String dirCd          ,
			                                  String rnum           , String lvl           , String fcastTtlQty  , String fcast20ftQty , String fcast40ftQty   ,
			                                  String fcast40ftHcQty , String fcast45ftHcQty, String fcast53ftQty , String fcastRfQty   , String fcastTtlWgt    ,
			                                  String fcastRmk       , String lfcastTtlQty  , String lfcast20ftQty, String lfcast40ftQty, String lfcast40ftHcQty,
			                                  String lfcast45ftHcQty, String lfcast53ftQty , String lfcastRfQty  , String lfcastTtlWgt , String totCnt         ,
			                                  String srepNm         , String fcastSeq      , String scNo         , String fcastCnt     , String viewType       ,
			                                  String slsRhqCd       , String rfaNo		   , String scFlg) {
		this.vslCd = vslCd;
		this.custNm = custNm;
		this.lfcastTtlQty = lfcastTtlQty;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.lfcast20ftQty = lfcast20ftQty;
		this.custCtrlCd = custCtrlCd;
		this.guideQty = guideQty;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.fcast20ftQty = fcast20ftQty;
		this.fcastRmk = fcastRmk;
		this.lfcast45ftHcQty = lfcast45ftHcQty;
		this.ibflag = ibflag;
		this.fcastTtlQty = fcastTtlQty;
		this.rnum = rnum;
		this.ctrtOfcCd = ctrtOfcCd;
		this.fcast53ftQty = fcast53ftQty;
		this.dirCd = dirCd;
		this.lfcast40ftQty = lfcast40ftQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.custCntCd = custCntCd;
		this.iocTsCd = iocTsCd;
		this.laneNum = laneNum;
		this.lfcastRfQty = lfcastRfQty;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.lfcast40ftHcQty = lfcast40ftHcQty;
		this.fcastRfQty = fcastRfQty;
		this.custTp = custTp;
		this.fcast40ftQty = fcast40ftQty;
		this.lvl = lvl;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.costWk = costWk;
		this.lfcast53ftQty = lfcast53ftQty;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.lfcastTtlWgt = lfcastTtlWgt;
		this.subTrdCd = subTrdCd;
		this.totCnt = totCnt;
		this.srepNm = srepNm;
		this.fcastSeq = fcastSeq;
		this.scNo = scNo;
		this.fcastCnt = fcastCnt;
		this.viewType = viewType;
		this.slsRhqCd = slsRhqCd;
		this.rfaNo = rfaNo;
		this.scFlg = scFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("lfcast_ttl_qty", getLfcastTtlQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("lfcast_20ft_qty", getLfcast20ftQty());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("guide_qty", getGuideQty());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fcast_20ft_qty", getFcast20ftQty());
		this.hashColumns.put("fcast_rmk", getFcastRmk());
		this.hashColumns.put("lfcast_45ft_hc_qty", getLfcast45ftHcQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lfcast_40ft_qty", getLfcast40ftQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("lane_num", getLaneNum());
		this.hashColumns.put("lfcast_rf_qty", getLfcastRfQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("lfcast_40ft_hc_qty", getLfcast40ftHcQty());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("fcast_40ft_qty", getFcast40ftQty());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("lfcast_53ft_qty", getLfcast53ftQty());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("lfcast_ttl_wgt", getLfcastTtlWgt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("fcast_seq", getFcastSeq());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fcast_cnt", getFcastCnt());
		this.hashColumns.put("view_type", getViewType());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("sc_flg", getScFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("lfcast_ttl_qty", "lfcastTtlQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("lfcast_20ft_qty", "lfcast20ftQty");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("guide_qty", "guideQty");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fcast_20ft_qty", "fcast20ftQty");
		this.hashFields.put("fcast_rmk", "fcastRmk");
		this.hashFields.put("lfcast_45ft_hc_qty", "lfcast45ftHcQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lfcast_40ft_qty", "lfcast40ftQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("lane_num", "laneNum");
		this.hashFields.put("lfcast_rf_qty", "lfcastRfQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("lfcast_40ft_hc_qty", "lfcast40ftHcQty");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("fcast_40ft_qty", "fcast40ftQty");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("lfcast_53ft_qty", "lfcast53ftQty");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("lfcast_ttl_wgt", "lfcastTtlWgt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("fcast_seq", "fcastSeq");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fcast_cnt", "fcastCnt");
		this.hashFields.put("view_type", "viewType");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("sc_flg", "scFlg");
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return lfcastTtlQty
	 */
	public String getLfcastTtlQty() {
		return this.lfcastTtlQty;
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
	 * Column Info
	 * @return lfcast20ftQty
	 */
	public String getLfcast20ftQty() {
		return this.lfcast20ftQty;
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
	 * @return guideQty
	 */
	public String getGuideQty() {
		return this.guideQty;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * Column Info
	 * @return lfcast45ftHcQty
	 */
	public String getLfcast45ftHcQty() {
		return this.lfcast45ftHcQty;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return fcast53ftQty
	 */
	public String getFcast53ftQty() {
		return this.fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return lfcast40ftQty
	 */
	public String getLfcast40ftQty() {
		return this.lfcast40ftQty;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return laneNum
	 */
	public String getLaneNum() {
		return this.laneNum;
	}
	
	/**
	 * Column Info
	 * @return lfcastRfQty
	 */
	public String getLfcastRfQty() {
		return this.lfcastRfQty;
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
	 * @return lfcast40ftHcQty
	 */
	public String getLfcast40ftHcQty() {
		return this.lfcast40ftHcQty;
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
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
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
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return lfcast53ftQty
	 */
	public String getLfcast53ftQty() {
		return this.lfcast53ftQty;
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
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return lfcastTtlWgt
	 */
	public String getLfcastTtlWgt() {
		return this.lfcastTtlWgt;
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
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return fcastCnt
	 */
	public String getFcastCnt() {
		return this.fcastCnt;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param lfcastTtlQty
	 */
	public void setLfcastTtlQty(String lfcastTtlQty) {
		this.lfcastTtlQty = lfcastTtlQty;
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
	 * Column Info
	 * @param lfcast20ftQty
	 */
	public void setLfcast20ftQty(String lfcast20ftQty) {
		this.lfcast20ftQty = lfcast20ftQty;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param guideQty
	 */
	public void setGuideQty(String guideQty) {
		this.guideQty = guideQty;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * Column Info
	 * @param lfcast45ftHcQty
	 */
	public void setLfcast45ftHcQty(String lfcast45ftHcQty) {
		this.lfcast45ftHcQty = lfcast45ftHcQty;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param fcast53ftQty
	 */
	public void setFcast53ftQty(String fcast53ftQty) {
		this.fcast53ftQty = fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param lfcast40ftQty
	 */
	public void setLfcast40ftQty(String lfcast40ftQty) {
		this.lfcast40ftQty = lfcast40ftQty;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param laneNum
	 */
	public void setLaneNum(String laneNum) {
		this.laneNum = laneNum;
	}
	
	/**
	 * Column Info
	 * @param lfcastRfQty
	 */
	public void setLfcastRfQty(String lfcastRfQty) {
		this.lfcastRfQty = lfcastRfQty;
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
	 * @param lfcast40ftHcQty
	 */
	public void setLfcast40ftHcQty(String lfcast40ftHcQty) {
		this.lfcast40ftHcQty = lfcast40ftHcQty;
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
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
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
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param lfcast53ftQty
	 */
	public void setLfcast53ftQty(String lfcast53ftQty) {
		this.lfcast53ftQty = lfcast53ftQty;
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
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param lfcastTtlWgt
	 */
	public void setLfcastTtlWgt(String lfcastTtlWgt) {
		this.lfcastTtlWgt = lfcastTtlWgt;
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
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param fcastCnt
	 */
	public void setFcastCnt(String fcastCnt) {
		this.fcastCnt = fcastCnt;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setLfcastTtlQty(JSPUtil.getParameter(request, prefix + "lfcast_ttl_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setLfcast20ftQty(JSPUtil.getParameter(request, prefix + "lfcast_20ft_qty", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setGuideQty(JSPUtil.getParameter(request, prefix + "guide_qty", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFcast20ftQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_qty", ""));
		setFcastRmk(JSPUtil.getParameter(request, prefix + "fcast_rmk", ""));
		setLfcast45ftHcQty(JSPUtil.getParameter(request, prefix + "lfcast_45ft_hc_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setLfcast40ftQty(JSPUtil.getParameter(request, prefix + "lfcast_40ft_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
		setLaneNum(JSPUtil.getParameter(request, prefix + "lane_num", ""));
		setLfcastRfQty(JSPUtil.getParameter(request, prefix + "lfcast_rf_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setLfcast40ftHcQty(JSPUtil.getParameter(request, prefix + "lfcast_40ft_hc_qty", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setCustTp(JSPUtil.getParameter(request, prefix + "cust_tp", ""));
		setFcast40ftQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_qty", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setLfcast53ftQty(JSPUtil.getParameter(request, prefix + "lfcast_53ft_qty", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setLfcastTtlWgt(JSPUtil.getParameter(request, prefix + "lfcast_ttl_wgt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setFcastSeq(JSPUtil.getParameter(request, prefix + "fcast_seq", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setFcastCnt(JSPUtil.getParameter(request, prefix + "fcast_cnt", ""));
		setViewType(JSPUtil.getParameter(request, prefix + "view_type", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setScFlg(JSPUtil.getParameter(request, prefix + "sc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContractForecastManageListVO[]
	 */
	public SearchContractForecastManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContractForecastManageListVO[]
	 */
	public SearchContractForecastManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractForecastManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] lfcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_ttl_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] lfcast20ftQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_20ft_qty", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] guideQty = (JSPUtil.getParameter(request, prefix	+ "guide_qty", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fcast20ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_qty", length));
			String[] fcastRmk = (JSPUtil.getParameter(request, prefix	+ "fcast_rmk", length));
			String[] lfcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_45ft_hc_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lfcast40ftQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_40ft_qty", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] laneNum = (JSPUtil.getParameter(request, prefix	+ "lane_num", length));
			String[] lfcastRfQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_rf_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] lfcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_40ft_hc_qty", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] fcast40ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_qty", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] lfcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "lfcast_53ft_qty", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] lfcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "lfcast_ttl_wgt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] fcastSeq = (JSPUtil.getParameter(request, prefix	+ "fcast_seq", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] fcastCnt = (JSPUtil.getParameter(request, prefix	+ "fcast_cnt", length));
			String[] viewType = (JSPUtil.getParameter(request, prefix	+ "view_type", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] scFlg = (JSPUtil.getParameter(request, prefix	+ "sc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractForecastManageListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (lfcastTtlQty[i] != null)
					model.setLfcastTtlQty(lfcastTtlQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (lfcast20ftQty[i] != null)
					model.setLfcast20ftQty(lfcast20ftQty[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (guideQty[i] != null)
					model.setGuideQty(guideQty[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fcast20ftQty[i] != null)
					model.setFcast20ftQty(fcast20ftQty[i]);
				if (fcastRmk[i] != null)
					model.setFcastRmk(fcastRmk[i]);
				if (lfcast45ftHcQty[i] != null)
					model.setLfcast45ftHcQty(lfcast45ftHcQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lfcast40ftQty[i] != null)
					model.setLfcast40ftQty(lfcast40ftQty[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (laneNum[i] != null)
					model.setLaneNum(laneNum[i]);
				if (lfcastRfQty[i] != null)
					model.setLfcastRfQty(lfcastRfQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (lfcast40ftHcQty[i] != null)
					model.setLfcast40ftHcQty(lfcast40ftHcQty[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (fcast40ftQty[i] != null)
					model.setFcast40ftQty(fcast40ftQty[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (lfcast53ftQty[i] != null)
					model.setLfcast53ftQty(lfcast53ftQty[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (lfcastTtlWgt[i] != null)
					model.setLfcastTtlWgt(lfcastTtlWgt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (fcastSeq[i] != null)
					model.setFcastSeq(fcastSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fcastCnt[i] != null)
					model.setFcastCnt(fcastCnt[i]);
				if (viewType[i] != null)
					model.setViewType(viewType[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (scFlg[i] != null)
					model.setScFlg(scFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContractForecastManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContractForecastManageListVO[]
	 */
	public SearchContractForecastManageListVO[] getSearchContractForecastManageListVOs(){
		SearchContractForecastManageListVO[] vos = (SearchContractForecastManageListVO[])models.toArray(new SearchContractForecastManageListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcastTtlQty = this.lfcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcast20ftQty = this.lfcast20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.guideQty = this.guideQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20ftQty = this.fcast20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRmk = this.fcastRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcast45ftHcQty = this.lfcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcast40ftQty = this.lfcast40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneNum = this.laneNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcastRfQty = this.lfcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcast40ftHcQty = this.lfcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftQty = this.fcast40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcast53ftQty = this.lfcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfcastTtlWgt = this.lfcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastSeq = this.fcastSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCnt = this.fcastCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewType = this.viewType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scFlg= this.scFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
