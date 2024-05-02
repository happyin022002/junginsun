/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SmpRptVO.java
*@FileTitle : SmpRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.03.07 진마리아 
* 1.0 Creation
* 2013.03.07 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SmpRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SmpRptVO> models = new ArrayList<SmpRptVO>();
	
	/* Column Info */
	private String cLoadQtaRatio = null;
	/* Column Info */
	private String cLoadQta4 = null;
	/* Column Info */
	private String cLoadQtaRatio1 = null;
	/* Column Info */
	private String cLoadQta3 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String cLoadQta2 = null;
	/* Column Info */
	private String cLoadQta1 = null;
	/* Column Info */
	private String subTrdCnt = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String cLoadQtaRatio4 = null;
	/* Column Info */
	private String cLoadQtaRatio3 = null;
	/* Column Info */
	private String cLoadQtaRatio2 = null;
	/* Column Info */
	private String acctClss = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlaneAdjQty = null;
	/* Column Info */
	private String subTrdAdjRatio2 = null;
	/* Column Info */
	private String subTrdAdjRatio3 = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String subTrdAdjRatio4 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String subTrdAdjRatio1 = null;
	/* Column Info */
	private String wkMqcQty = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String subTrdCd1 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String subTrdCd2 = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String subTrdCd3 = null;
	/* Column Info */
	private String subTrdCd4 = null;
	/* Column Info */
	private String subTrdAdjQty1 = null;
	/* Column Info */
	private String rlaneAdjRatio = null;
	/* Column Info */
	private String subTrdAdjQty2 = null;
	/* Column Info */
	private String subTrdAdjQty3 = null;
	/* Column Info */
	private String cLoadQta = null;
	/* Column Info */
	private String subTrdAdjQty4 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SmpRptVO() {}

	public SmpRptVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String ofcCd, String custCtrlCd, String acctClss, String custLglEngNm, String scNo, String wkMqcQty, String lvl, String rlaneAdjQty, String rlaneAdjRatio, String cLoadQta, String cLoadQtaRatio, String subTrdCd1, String subTrdAdjQty1, String subTrdAdjRatio1, String cLoadQta1, String cLoadQtaRatio1, String subTrdCd2, String subTrdAdjQty2, String subTrdAdjRatio2, String cLoadQta2, String cLoadQtaRatio2, String subTrdCd3, String subTrdAdjQty3, String subTrdAdjRatio3, String cLoadQta3, String cLoadQtaRatio3, String subTrdCd4, String subTrdAdjQty4, String subTrdAdjRatio4, String cLoadQta4, String cLoadQtaRatio4, String slsRhqCd, String subTrdCnt, String ctrtOfcCd, String rfaNo) {
		this.cLoadQtaRatio = cLoadQtaRatio;
		this.cLoadQta4 = cLoadQta4;
		this.cLoadQtaRatio1 = cLoadQtaRatio1;
		this.cLoadQta3 = cLoadQta3;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.cLoadQta2 = cLoadQta2;
		this.cLoadQta1 = cLoadQta1;
		this.subTrdCnt = subTrdCnt;
		this.custCtrlCd = custCtrlCd;
		this.cLoadQtaRatio4 = cLoadQtaRatio4;
		this.cLoadQtaRatio3 = cLoadQtaRatio3;
		this.cLoadQtaRatio2 = cLoadQtaRatio2;
		this.acctClss = acctClss;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rlaneAdjQty = rlaneAdjQty;
		this.subTrdAdjRatio2 = subTrdAdjRatio2;
		this.subTrdAdjRatio3 = subTrdAdjRatio3;
		this.ctrtOfcCd = ctrtOfcCd;
		this.subTrdAdjRatio4 = subTrdAdjRatio4;
		this.scNo = scNo;
		this.subTrdAdjRatio1 = subTrdAdjRatio1;
		this.wkMqcQty = wkMqcQty;
		this.slsRhqCd = slsRhqCd;
		this.custLglEngNm = custLglEngNm;
		this.subTrdCd1 = subTrdCd1;
		this.ofcCd = ofcCd;
		this.subTrdCd2 = subTrdCd2;
		this.lvl = lvl;
		this.subTrdCd3 = subTrdCd3;
		this.subTrdCd4 = subTrdCd4;
		this.subTrdAdjQty1 = subTrdAdjQty1;
		this.rlaneAdjRatio = rlaneAdjRatio;
		this.subTrdAdjQty2 = subTrdAdjQty2;
		this.subTrdAdjQty3 = subTrdAdjQty3;
		this.cLoadQta = cLoadQta;
		this.subTrdAdjQty4 = subTrdAdjQty4;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("c_load_qta_ratio", getCLoadQtaRatio());
		this.hashColumns.put("c_load_qta_4", getCLoadQta4());
		this.hashColumns.put("c_load_qta_ratio_1", getCLoadQtaRatio1());
		this.hashColumns.put("c_load_qta_3", getCLoadQta3());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("c_load_qta_2", getCLoadQta2());
		this.hashColumns.put("c_load_qta_1", getCLoadQta1());
		this.hashColumns.put("sub_trd_cnt", getSubTrdCnt());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("c_load_qta_ratio_4", getCLoadQtaRatio4());
		this.hashColumns.put("c_load_qta_ratio_3", getCLoadQtaRatio3());
		this.hashColumns.put("c_load_qta_ratio_2", getCLoadQtaRatio2());
		this.hashColumns.put("acct_clss", getAcctClss());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlane_adj_qty", getRlaneAdjQty());
		this.hashColumns.put("sub_trd_adj_ratio_2", getSubTrdAdjRatio2());
		this.hashColumns.put("sub_trd_adj_ratio_3", getSubTrdAdjRatio3());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sub_trd_adj_ratio_4", getSubTrdAdjRatio4());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sub_trd_adj_ratio_1", getSubTrdAdjRatio1());
		this.hashColumns.put("wk_mqc_qty", getWkMqcQty());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("sub_trd_cd_1", getSubTrdCd1());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sub_trd_cd_2", getSubTrdCd2());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("sub_trd_cd_3", getSubTrdCd3());
		this.hashColumns.put("sub_trd_cd_4", getSubTrdCd4());
		this.hashColumns.put("sub_trd_adj_qty_1", getSubTrdAdjQty1());
		this.hashColumns.put("rlane_adj_ratio", getRlaneAdjRatio());
		this.hashColumns.put("sub_trd_adj_qty_2", getSubTrdAdjQty2());
		this.hashColumns.put("sub_trd_adj_qty_3", getSubTrdAdjQty3());
		this.hashColumns.put("c_load_qta", getCLoadQta());
		this.hashColumns.put("sub_trd_adj_qty_4", getSubTrdAdjQty4());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("c_load_qta_ratio", "cLoadQtaRatio");
		this.hashFields.put("c_load_qta_4", "cLoadQta4");
		this.hashFields.put("c_load_qta_ratio_1", "cLoadQtaRatio1");
		this.hashFields.put("c_load_qta_3", "cLoadQta3");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("c_load_qta_2", "cLoadQta2");
		this.hashFields.put("c_load_qta_1", "cLoadQta1");
		this.hashFields.put("sub_trd_cnt", "subTrdCnt");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("c_load_qta_ratio_4", "cLoadQtaRatio4");
		this.hashFields.put("c_load_qta_ratio_3", "cLoadQtaRatio3");
		this.hashFields.put("c_load_qta_ratio_2", "cLoadQtaRatio2");
		this.hashFields.put("acct_clss", "acctClss");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlane_adj_qty", "rlaneAdjQty");
		this.hashFields.put("sub_trd_adj_ratio_2", "subTrdAdjRatio2");
		this.hashFields.put("sub_trd_adj_ratio_3", "subTrdAdjRatio3");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sub_trd_adj_ratio_4", "subTrdAdjRatio4");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sub_trd_adj_ratio_1", "subTrdAdjRatio1");
		this.hashFields.put("wk_mqc_qty", "wkMqcQty");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("sub_trd_cd_1", "subTrdCd1");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sub_trd_cd_2", "subTrdCd2");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("sub_trd_cd_3", "subTrdCd3");
		this.hashFields.put("sub_trd_cd_4", "subTrdCd4");
		this.hashFields.put("sub_trd_adj_qty_1", "subTrdAdjQty1");
		this.hashFields.put("rlane_adj_ratio", "rlaneAdjRatio");
		this.hashFields.put("sub_trd_adj_qty_2", "subTrdAdjQty2");
		this.hashFields.put("sub_trd_adj_qty_3", "subTrdAdjQty3");
		this.hashFields.put("c_load_qta", "cLoadQta");
		this.hashFields.put("sub_trd_adj_qty_4", "subTrdAdjQty4");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cLoadQtaRatio
	 */
	public String getCLoadQtaRatio() {
		return this.cLoadQtaRatio;
	}
	
	/**
	 * Column Info
	 * @return cLoadQta4
	 */
	public String getCLoadQta4() {
		return this.cLoadQta4;
	}
	
	/**
	 * Column Info
	 * @return cLoadQtaRatio1
	 */
	public String getCLoadQtaRatio1() {
		return this.cLoadQtaRatio1;
	}
	
	/**
	 * Column Info
	 * @return cLoadQta3
	 */
	public String getCLoadQta3() {
		return this.cLoadQta3;
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
	 * @return cLoadQta2
	 */
	public String getCLoadQta2() {
		return this.cLoadQta2;
	}
	
	/**
	 * Column Info
	 * @return cLoadQta1
	 */
	public String getCLoadQta1() {
		return this.cLoadQta1;
	}
	
	/**
	 * Column Info
	 * @return subTrdCnt
	 */
	public String getSubTrdCnt() {
		return this.subTrdCnt;
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
	 * @return cLoadQtaRatio4
	 */
	public String getCLoadQtaRatio4() {
		return this.cLoadQtaRatio4;
	}
	
	/**
	 * Column Info
	 * @return cLoadQtaRatio3
	 */
	public String getCLoadQtaRatio3() {
		return this.cLoadQtaRatio3;
	}
	
	/**
	 * Column Info
	 * @return cLoadQtaRatio2
	 */
	public String getCLoadQtaRatio2() {
		return this.cLoadQtaRatio2;
	}
	
	/**
	 * Column Info
	 * @return acctClss
	 */
	public String getAcctClss() {
		return this.acctClss;
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
	 * @return rlaneAdjQty
	 */
	public String getRlaneAdjQty() {
		return this.rlaneAdjQty;
	}
	
	/**
	 * Column Info
	 * @return subTrdAdjRatio2
	 */
	public String getSubTrdAdjRatio2() {
		return this.subTrdAdjRatio2;
	}
	
	/**
	 * Column Info
	 * @return subTrdAdjRatio3
	 */
	public String getSubTrdAdjRatio3() {
		return this.subTrdAdjRatio3;
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
	 * @return subTrdAdjRatio4
	 */
	public String getSubTrdAdjRatio4() {
		return this.subTrdAdjRatio4;
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
	 * @return subTrdAdjRatio1
	 */
	public String getSubTrdAdjRatio1() {
		return this.subTrdAdjRatio1;
	}
	
	/**
	 * Column Info
	 * @return wkMqcQty
	 */
	public String getWkMqcQty() {
		return this.wkMqcQty;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd1
	 */
	public String getSubTrdCd1() {
		return this.subTrdCd1;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd2
	 */
	public String getSubTrdCd2() {
		return this.subTrdCd2;
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
	 * @return subTrdCd3
	 */
	public String getSubTrdCd3() {
		return this.subTrdCd3;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd4
	 */
	public String getSubTrdCd4() {
		return this.subTrdCd4;
	}
	
	/**
	 * Column Info
	 * @return subTrdAdjQty1
	 */
	public String getSubTrdAdjQty1() {
		return this.subTrdAdjQty1;
	}
	
	/**
	 * Column Info
	 * @return rlaneAdjRatio
	 */
	public String getRlaneAdjRatio() {
		return this.rlaneAdjRatio;
	}
	
	/**
	 * Column Info
	 * @return subTrdAdjQty2
	 */
	public String getSubTrdAdjQty2() {
		return this.subTrdAdjQty2;
	}
	
	/**
	 * Column Info
	 * @return subTrdAdjQty3
	 */
	public String getSubTrdAdjQty3() {
		return this.subTrdAdjQty3;
	}
	
	/**
	 * Column Info
	 * @return cLoadQta
	 */
	public String getCLoadQta() {
		return this.cLoadQta;
	}
	
	/**
	 * Column Info
	 * @return subTrdAdjQty4
	 */
	public String getSubTrdAdjQty4() {
		return this.subTrdAdjQty4;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	

	/**
	 * Column Info
	 * @param cLoadQtaRatio
	 */
	public void setCLoadQtaRatio(String cLoadQtaRatio) {
		this.cLoadQtaRatio = cLoadQtaRatio;
	}
	
	/**
	 * Column Info
	 * @param cLoadQta4
	 */
	public void setCLoadQta4(String cLoadQta4) {
		this.cLoadQta4 = cLoadQta4;
	}
	
	/**
	 * Column Info
	 * @param cLoadQtaRatio1
	 */
	public void setCLoadQtaRatio1(String cLoadQtaRatio1) {
		this.cLoadQtaRatio1 = cLoadQtaRatio1;
	}
	
	/**
	 * Column Info
	 * @param cLoadQta3
	 */
	public void setCLoadQta3(String cLoadQta3) {
		this.cLoadQta3 = cLoadQta3;
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
	 * @param cLoadQta2
	 */
	public void setCLoadQta2(String cLoadQta2) {
		this.cLoadQta2 = cLoadQta2;
	}
	
	/**
	 * Column Info
	 * @param cLoadQta1
	 */
	public void setCLoadQta1(String cLoadQta1) {
		this.cLoadQta1 = cLoadQta1;
	}
	
	/**
	 * Column Info
	 * @param subTrdCnt
	 */
	public void setSubTrdCnt(String subTrdCnt) {
		this.subTrdCnt = subTrdCnt;
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
	 * @param cLoadQtaRatio4
	 */
	public void setCLoadQtaRatio4(String cLoadQtaRatio4) {
		this.cLoadQtaRatio4 = cLoadQtaRatio4;
	}
	
	/**
	 * Column Info
	 * @param cLoadQtaRatio3
	 */
	public void setCLoadQtaRatio3(String cLoadQtaRatio3) {
		this.cLoadQtaRatio3 = cLoadQtaRatio3;
	}
	
	/**
	 * Column Info
	 * @param cLoadQtaRatio2
	 */
	public void setCLoadQtaRatio2(String cLoadQtaRatio2) {
		this.cLoadQtaRatio2 = cLoadQtaRatio2;
	}
	
	/**
	 * Column Info
	 * @param acctClss
	 */
	public void setAcctClss(String acctClss) {
		this.acctClss = acctClss;
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
	 * @param rlaneAdjQty
	 */
	public void setRlaneAdjQty(String rlaneAdjQty) {
		this.rlaneAdjQty = rlaneAdjQty;
	}
	
	/**
	 * Column Info
	 * @param subTrdAdjRatio2
	 */
	public void setSubTrdAdjRatio2(String subTrdAdjRatio2) {
		this.subTrdAdjRatio2 = subTrdAdjRatio2;
	}
	
	/**
	 * Column Info
	 * @param subTrdAdjRatio3
	 */
	public void setSubTrdAdjRatio3(String subTrdAdjRatio3) {
		this.subTrdAdjRatio3 = subTrdAdjRatio3;
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
	 * @param subTrdAdjRatio4
	 */
	public void setSubTrdAdjRatio4(String subTrdAdjRatio4) {
		this.subTrdAdjRatio4 = subTrdAdjRatio4;
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
	 * @param subTrdAdjRatio1
	 */
	public void setSubTrdAdjRatio1(String subTrdAdjRatio1) {
		this.subTrdAdjRatio1 = subTrdAdjRatio1;
	}
	
	/**
	 * Column Info
	 * @param wkMqcQty
	 */
	public void setWkMqcQty(String wkMqcQty) {
		this.wkMqcQty = wkMqcQty;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd1
	 */
	public void setSubTrdCd1(String subTrdCd1) {
		this.subTrdCd1 = subTrdCd1;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd2
	 */
	public void setSubTrdCd2(String subTrdCd2) {
		this.subTrdCd2 = subTrdCd2;
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
	 * @param subTrdCd3
	 */
	public void setSubTrdCd3(String subTrdCd3) {
		this.subTrdCd3 = subTrdCd3;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd4
	 */
	public void setSubTrdCd4(String subTrdCd4) {
		this.subTrdCd4 = subTrdCd4;
	}
	
	/**
	 * Column Info
	 * @param subTrdAdjQty1
	 */
	public void setSubTrdAdjQty1(String subTrdAdjQty1) {
		this.subTrdAdjQty1 = subTrdAdjQty1;
	}
	
	/**
	 * Column Info
	 * @param rlaneAdjRatio
	 */
	public void setRlaneAdjRatio(String rlaneAdjRatio) {
		this.rlaneAdjRatio = rlaneAdjRatio;
	}
	
	/**
	 * Column Info
	 * @param subTrdAdjQty2
	 */
	public void setSubTrdAdjQty2(String subTrdAdjQty2) {
		this.subTrdAdjQty2 = subTrdAdjQty2;
	}
	
	/**
	 * Column Info
	 * @param subTrdAdjQty3
	 */
	public void setSubTrdAdjQty3(String subTrdAdjQty3) {
		this.subTrdAdjQty3 = subTrdAdjQty3;
	}
	
	/**
	 * Column Info
	 * @param cLoadQta
	 */
	public void setCLoadQta(String cLoadQta) {
		this.cLoadQta = cLoadQta;
	}
	
	/**
	 * Column Info
	 * @param subTrdAdjQty4
	 */
	public void setSubTrdAdjQty4(String subTrdAdjQty4) {
		this.subTrdAdjQty4 = subTrdAdjQty4;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
		setCLoadQtaRatio(JSPUtil.getParameter(request, prefix + "c_load_qta_ratio", ""));
		setCLoadQta4(JSPUtil.getParameter(request, prefix + "c_load_qta_4", ""));
		setCLoadQtaRatio1(JSPUtil.getParameter(request, prefix + "c_load_qta_ratio_1", ""));
		setCLoadQta3(JSPUtil.getParameter(request, prefix + "c_load_qta_3", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCLoadQta2(JSPUtil.getParameter(request, prefix + "c_load_qta_2", ""));
		setCLoadQta1(JSPUtil.getParameter(request, prefix + "c_load_qta_1", ""));
		setSubTrdCnt(JSPUtil.getParameter(request, prefix + "sub_trd_cnt", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setCLoadQtaRatio4(JSPUtil.getParameter(request, prefix + "c_load_qta_ratio_4", ""));
		setCLoadQtaRatio3(JSPUtil.getParameter(request, prefix + "c_load_qta_ratio_3", ""));
		setCLoadQtaRatio2(JSPUtil.getParameter(request, prefix + "c_load_qta_ratio_2", ""));
		setAcctClss(JSPUtil.getParameter(request, prefix + "acct_clss", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRlaneAdjQty(JSPUtil.getParameter(request, prefix + "rlane_adj_qty", ""));
		setSubTrdAdjRatio2(JSPUtil.getParameter(request, prefix + "sub_trd_adj_ratio_2", ""));
		setSubTrdAdjRatio3(JSPUtil.getParameter(request, prefix + "sub_trd_adj_ratio_3", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setSubTrdAdjRatio4(JSPUtil.getParameter(request, prefix + "sub_trd_adj_ratio_4", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setSubTrdAdjRatio1(JSPUtil.getParameter(request, prefix + "sub_trd_adj_ratio_1", ""));
		setWkMqcQty(JSPUtil.getParameter(request, prefix + "wk_mqc_qty", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setSubTrdCd1(JSPUtil.getParameter(request, prefix + "sub_trd_cd_1", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSubTrdCd2(JSPUtil.getParameter(request, prefix + "sub_trd_cd_2", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setSubTrdCd3(JSPUtil.getParameter(request, prefix + "sub_trd_cd_3", ""));
		setSubTrdCd4(JSPUtil.getParameter(request, prefix + "sub_trd_cd_4", ""));
		setSubTrdAdjQty1(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty_1", ""));
		setRlaneAdjRatio(JSPUtil.getParameter(request, prefix + "rlane_adj_ratio", ""));
		setSubTrdAdjQty2(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty_2", ""));
		setSubTrdAdjQty3(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty_3", ""));
		setCLoadQta(JSPUtil.getParameter(request, prefix + "c_load_qta", ""));
		setSubTrdAdjQty4(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty_4", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SmpRptVO[]
	 */
	public SmpRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SmpRptVO[]
	 */
	public SmpRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SmpRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cLoadQtaRatio = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_ratio", length));
			String[] cLoadQta4 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_4", length));
			String[] cLoadQtaRatio1 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_ratio_1", length));
			String[] cLoadQta3 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_3", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] cLoadQta2 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_2", length));
			String[] cLoadQta1 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_1", length));
			String[] subTrdCnt = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cnt", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] cLoadQtaRatio4 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_ratio_4", length));
			String[] cLoadQtaRatio3 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_ratio_3", length));
			String[] cLoadQtaRatio2 = (JSPUtil.getParameter(request, prefix	+ "c_load_qta_ratio_2", length));
			String[] acctClss = (JSPUtil.getParameter(request, prefix	+ "acct_clss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlaneAdjQty = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_qty", length));
			String[] subTrdAdjRatio2 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_ratio_2", length));
			String[] subTrdAdjRatio3 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_ratio_3", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] subTrdAdjRatio4 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_ratio_4", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] subTrdAdjRatio1 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_ratio_1", length));
			String[] wkMqcQty = (JSPUtil.getParameter(request, prefix	+ "wk_mqc_qty", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] subTrdCd1 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd_1", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] subTrdCd2 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd_2", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] subTrdCd3 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd_3", length));
			String[] subTrdCd4 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd_4", length));
			String[] subTrdAdjQty1 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty_1", length));
			String[] rlaneAdjRatio = (JSPUtil.getParameter(request, prefix	+ "rlane_adj_ratio", length));
			String[] subTrdAdjQty2 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty_2", length));
			String[] subTrdAdjQty3 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty_3", length));
			String[] cLoadQta = (JSPUtil.getParameter(request, prefix	+ "c_load_qta", length));
			String[] subTrdAdjQty4 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty_4", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SmpRptVO();
				if (cLoadQtaRatio[i] != null)
					model.setCLoadQtaRatio(cLoadQtaRatio[i]);
				if (cLoadQta4[i] != null)
					model.setCLoadQta4(cLoadQta4[i]);
				if (cLoadQtaRatio1[i] != null)
					model.setCLoadQtaRatio1(cLoadQtaRatio1[i]);
				if (cLoadQta3[i] != null)
					model.setCLoadQta3(cLoadQta3[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (cLoadQta2[i] != null)
					model.setCLoadQta2(cLoadQta2[i]);
				if (cLoadQta1[i] != null)
					model.setCLoadQta1(cLoadQta1[i]);
				if (subTrdCnt[i] != null)
					model.setSubTrdCnt(subTrdCnt[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (cLoadQtaRatio4[i] != null)
					model.setCLoadQtaRatio4(cLoadQtaRatio4[i]);
				if (cLoadQtaRatio3[i] != null)
					model.setCLoadQtaRatio3(cLoadQtaRatio3[i]);
				if (cLoadQtaRatio2[i] != null)
					model.setCLoadQtaRatio2(cLoadQtaRatio2[i]);
				if (acctClss[i] != null)
					model.setAcctClss(acctClss[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlaneAdjQty[i] != null)
					model.setRlaneAdjQty(rlaneAdjQty[i]);
				if (subTrdAdjRatio2[i] != null)
					model.setSubTrdAdjRatio2(subTrdAdjRatio2[i]);
				if (subTrdAdjRatio3[i] != null)
					model.setSubTrdAdjRatio3(subTrdAdjRatio3[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (subTrdAdjRatio4[i] != null)
					model.setSubTrdAdjRatio4(subTrdAdjRatio4[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (subTrdAdjRatio1[i] != null)
					model.setSubTrdAdjRatio1(subTrdAdjRatio1[i]);
				if (wkMqcQty[i] != null)
					model.setWkMqcQty(wkMqcQty[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (subTrdCd1[i] != null)
					model.setSubTrdCd1(subTrdCd1[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (subTrdCd2[i] != null)
					model.setSubTrdCd2(subTrdCd2[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (subTrdCd3[i] != null)
					model.setSubTrdCd3(subTrdCd3[i]);
				if (subTrdCd4[i] != null)
					model.setSubTrdCd4(subTrdCd4[i]);
				if (subTrdAdjQty1[i] != null)
					model.setSubTrdAdjQty1(subTrdAdjQty1[i]);
				if (rlaneAdjRatio[i] != null)
					model.setRlaneAdjRatio(rlaneAdjRatio[i]);
				if (subTrdAdjQty2[i] != null)
					model.setSubTrdAdjQty2(subTrdAdjQty2[i]);
				if (subTrdAdjQty3[i] != null)
					model.setSubTrdAdjQty3(subTrdAdjQty3[i]);
				if (cLoadQta[i] != null)
					model.setCLoadQta(cLoadQta[i]);
				if (subTrdAdjQty4[i] != null)
					model.setSubTrdAdjQty4(subTrdAdjQty4[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSmpRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SmpRptVO[]
	 */
	public SmpRptVO[] getSmpRptVOs(){
		SmpRptVO[] vos = (SmpRptVO[])models.toArray(new SmpRptVO[models.size()]);
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
		this.cLoadQtaRatio = this.cLoadQtaRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQta4 = this.cLoadQta4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQtaRatio1 = this.cLoadQtaRatio1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQta3 = this.cLoadQta3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQta2 = this.cLoadQta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQta1 = this.cLoadQta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCnt = this.subTrdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQtaRatio4 = this.cLoadQtaRatio4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQtaRatio3 = this.cLoadQtaRatio3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQtaRatio2 = this.cLoadQtaRatio2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClss = this.acctClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjQty = this.rlaneAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjRatio2 = this.subTrdAdjRatio2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjRatio3 = this.subTrdAdjRatio3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjRatio4 = this.subTrdAdjRatio4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjRatio1 = this.subTrdAdjRatio1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkMqcQty = this.wkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd1 = this.subTrdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd2 = this.subTrdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd3 = this.subTrdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd4 = this.subTrdCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty1 = this.subTrdAdjQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneAdjRatio = this.rlaneAdjRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty2 = this.subTrdAdjQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty3 = this.subTrdAdjQty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLoadQta = this.cLoadQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty4 = this.subTrdAdjQty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
