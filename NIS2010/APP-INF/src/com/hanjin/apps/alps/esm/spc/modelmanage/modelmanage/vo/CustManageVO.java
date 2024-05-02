/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustManageVO.java
*@FileTitle : CustManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.31 진마리아 
* 1.0 Creation
* 2013.01.31 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
* 2013.09.04 [Trouble Shooting] 현재 유효한 PRI의 정보와 차이 나는 경우 빨간 글씨로 표시
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
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

public class CustManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustManageVO> models = new ArrayList<CustManageVO>();
	
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String wkMqcQty = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String popYn = null;
	/* Column Info */
	private String newVerSeq = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String allSave = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String acctPicNm = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String subTrd1 = null;
	/* Column Info */
	private String subTrd2 = null;
	/* Column Info */
	private String subTrd3 = null;
	/* Column Info */
	private String subTrd4 = null;
	/* Column Info */
	private String subTrd5 = null;
	/* Column Info */
	private String crntScYn = null;
	/* Column Info */
	private String crntRfaYn = null;
	/* Column Info */
	private String preScNo = null;
	/* Column Info */
	private String preRfaNo = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String scRfaFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustManageVO() {}

	public CustManageVO(String ibflag, String pagerows, String costYrwk, String verSeq, String custCntCd, String custSeq, String dtlSeq, String custGrpId, String scNo, String rfaNo, String custCtrlCd, String wkMqcQty, String deltFlg, String custCd, String custLglEngNm, String custGrpNm, String cfmFlg, String creUsrId, String newVerSeq, String popYn, String trade, String allSave, String seq, String ctrtOfcCd, String acctPicNm, String subTrdCd, String subTrd1, String subTrd2, String subTrd3, String subTrd4, String subTrd5, String crntScYn, String crntRfaYn, String preScNo, String preRfaNo, String trdCd, String scRfaFlg, String updUsrId) {
		this.custGrpId = custGrpId;
		this.wkMqcQty = wkMqcQty;
		this.deltFlg = deltFlg;
		this.custSeq = custSeq;
		this.custCtrlCd = custCtrlCd;
		this.cfmFlg = cfmFlg;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
		this.verSeq = verSeq;
		this.rfaNo = rfaNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.custGrpNm = custGrpNm;
		this.custCd = custCd;
		this.scNo = scNo;
		this.popYn = popYn;
		this.newVerSeq = newVerSeq;
		this.dtlSeq = dtlSeq;
		this.custCntCd = custCntCd;
		this.costYrwk = costYrwk;
		this.trade = trade;
		this.allSave = allSave;
		this.seq = seq;
		this.ctrtOfcCd = ctrtOfcCd;
		this.acctPicNm = acctPicNm;
		this.subTrdCd = subTrdCd;
		this.subTrd1 = subTrd1;
		this.subTrd2 = subTrd2;
		this.subTrd3 = subTrd3;
		this.subTrd4 = subTrd4;
		this.subTrd5 = subTrd5;
		this.crntScYn = crntScYn;
		this.crntRfaYn = crntRfaYn;
		this.preScNo = preScNo;
		this.preRfaNo = preRfaNo;
		this.trdCd = trdCd;
		this.scRfaFlg = scRfaFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("wk_mqc_qty", getWkMqcQty());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("pop_yn", getPopYn());
		this.hashColumns.put("new_ver_seq", getNewVerSeq());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("all_save", getAllSave());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("acct_pic_nm", getAcctPicNm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("sub_trd_1", getSubTrd1());
		this.hashColumns.put("sub_trd_2", getSubTrd2());
		this.hashColumns.put("sub_trd_3", getSubTrd3());
		this.hashColumns.put("sub_trd_4", getSubTrd4());
		this.hashColumns.put("sub_trd_5", getSubTrd5());
		this.hashColumns.put("crnt_sc_yn", getCrntScYn());
		this.hashColumns.put("crnt_rfa_yn", getCrntRfaYn());
		this.hashColumns.put("pre_sc_no", getPreScNo());
		this.hashColumns.put("pre_rfa_no", getPreRfaNo());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sc_rfa_flg", getScRfaFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("wk_mqc_qty", "wkMqcQty");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("pop_yn", "popYn");
		this.hashFields.put("new_ver_seq", "newVerSeq");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("all_save", "allSave");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("acct_pic_nm", "acctPicNm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("sub_trd_1", "subTrd1");
		this.hashFields.put("sub_trd_2", "subTrd2");
		this.hashFields.put("sub_trd_3", "subTrd3");
		this.hashFields.put("sub_trd_4", "subTrd4");
		this.hashFields.put("sub_trd_5", "subTrd5");
		this.hashFields.put("crnt_sc_yn", "crntScYn");
		this.hashFields.put("crnt_rfa_yn", "crntRfaYn");
		this.hashFields.put("pre_sc_no", "preScNo");
		this.hashFields.put("pre_rfa_no", "preRfaNo");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sc_rfa_flg", "scRfaFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return popYn
	 */
	public String getPopYn() {
		return this.popYn;
	}
	
	/**
	 * Column Info
	 * @return newVerSeq
	 */
	public String getNewVerSeq() {
		return this.newVerSeq;
	}
	
	/**
	 * Column Info
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
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
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return allSave
	 */
	public String getAllSave() {
		return this.allSave;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @return acctPicNm
	 */
	public String getAcctPicNm() {
		return this.acctPicNm;
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
	 * @return subTrd1
	 */
	public String getSubTrd1() {
		return this.subTrd1;
	}
	
	/**
	 * Column Info
	 * @return subTrd2
	 */
	public String getSubTrd2() {
		return this.subTrd2;
	}
	
	/**
	 * Column Info
	 * @return subTrd3
	 */
	public String getSubTrd3() {
		return this.subTrd3;
	}
	
	/**
	 * Column Info
	 * @return subTrd4
	 */
	public String getSubTrd4() {
		return this.subTrd4;
	}
	
	/**
	 * Column Info
	 * @return subTrd5
	 */
	public String getSubTrd5() {
		return this.subTrd5;
	}
	
	/**
	 * Column Info
	 * @return crntScYn
	 */
	public String getCrntScYn() {
		return this.crntScYn;
	}
	
	/**
	 * Column Info
	 * @return crntRfaYn
	 */
	public String getCrntRfaYn() {
		return this.crntRfaYn;
	}
	
	/**
	 * Column Info
	 * @return preScNo
	 */
	public String getPreScNo() {
		return this.preScNo;
	}
	
	/**
	 * Column Info
	 * @return preRfaNo
	 */
	public String getPreRfaNo() {
		return this.preRfaNo;
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
	 * @return scRfaFlg
	 */
	public String getScRfaFlg() {
		return this.scRfaFlg;
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
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param popYn
	 */
	public void setPopYn(String popYn) {
		this.popYn = popYn;
	}
	
	/**
	 * Column Info
	 * @param newVerSeq
	 */
	public void setNewVerSeq(String newVerSeq) {
		this.newVerSeq = newVerSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
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
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param allSave
	 */
	public void setAllSave(String allSave) {
		this.allSave = allSave;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @param acctPicNm
	 */
	public void setAcctPicNm(String acctPicNm) {
		this.acctPicNm = acctPicNm;
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
	 * @param subTrd1
	 */
	public void setSubTrd1(String subTrd1) {
		this.subTrd1 = subTrd1;
	}
	
	/**
	 * Column Info
	 * @param subTrd2
	 */
	public void setSubTrd2(String subTrd2) {
		this.subTrd2 = subTrd2;
	}
	
	/**
	 * Column Info
	 * @param subTrd3
	 */
	public void setSubTrd3(String subTrd3) {
		this.subTrd3 = subTrd3;
	}
	
	/**
	 * Column Info
	 * @param subTrd4
	 */
	public void setSubTrd4(String subTrd4) {
		this.subTrd4 = subTrd4;
	}
	
	/**
	 * Column Info
	 * @param subTrd5
	 */
	public void setSubTrd5(String subTrd5) {
		this.subTrd5 = subTrd5;
	}
	
	/**
	 * Column Info
	 * @param crntScYn
	 */
	public void setCrntScYn(String crntScYn) {
		this.crntScYn = crntScYn;
	}
	
	/**
	 * Column Info
	 * @param crntRfaYn
	 */
	public void setCrntRfaYn(String crntRfaYn) {
		this.crntRfaYn = crntRfaYn;
	}
	
	/**
	 * Column Info
	 * @param preScNo
	 */
	public void setPreScNo(String preScNo) {
		this.preScNo = preScNo;
	}
	
	/**
	 * Column Info
	 * @param preRfaNo
	 */
	public void setPreRfaNo(String preRfaNo) {
		this.preRfaNo = preRfaNo;
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
	 * @param scRfaFlg
	 */
	public void setScRfaFlg(String scRfaFlg) {
		this.scRfaFlg = scRfaFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setWkMqcQty(JSPUtil.getParameter(request, prefix + "wk_mqc_qty", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setPopYn(JSPUtil.getParameter(request, prefix + "pop_yn", ""));
		setNewVerSeq(JSPUtil.getParameter(request, prefix + "new_ver_seq", ""));
		setDtlSeq(JSPUtil.getParameter(request, prefix + "dtl_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setAllSave(JSPUtil.getParameter(request, prefix + "all_save", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setAcctPicNm(JSPUtil.getParameter(request, prefix + "acct_pic_nm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setSubTrd1(JSPUtil.getParameter(request, prefix + "sub_trd_1", ""));
		setSubTrd2(JSPUtil.getParameter(request, prefix + "sub_trd_2", ""));
		setSubTrd3(JSPUtil.getParameter(request, prefix + "sub_trd_3", ""));
		setSubTrd4(JSPUtil.getParameter(request, prefix + "sub_trd_4", ""));
		setSubTrd5(JSPUtil.getParameter(request, prefix + "sub_trd_5", ""));
		setCrntScYn(JSPUtil.getParameter(request, prefix + "crnt_sc_yn", ""));
		setCrntRfaYn(JSPUtil.getParameter(request, prefix + "crnt_rfa_yn", ""));
		setPreScNo(JSPUtil.getParameter(request, prefix + "pre_sc_no", ""));
		setPreRfaNo(JSPUtil.getParameter(request, prefix + "pre_rfa_no", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setScRfaFlg(JSPUtil.getParameter(request, prefix + "sc_rfa_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustManageVO[]
	 */
	public CustManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustManageVO[]
	 */
	public CustManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] wkMqcQty = (JSPUtil.getParameter(request, prefix	+ "wk_mqc_qty", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] popYn = (JSPUtil.getParameter(request, prefix	+ "pop_yn", length));
			String[] newVerSeq = (JSPUtil.getParameter(request, prefix	+ "new_ver_seq", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] allSave = (JSPUtil.getParameter(request, prefix	+ "all_save", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] acctPicNm = (JSPUtil.getParameter(request, prefix	+ "acct_pic_nm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] subTrd1 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_1", length));
			String[] subTrd2 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_2", length));
			String[] subTrd3 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_3", length));
			String[] subTrd4 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_4", length));
			String[] subTrd5 = (JSPUtil.getParameter(request, prefix	+ "sub_trd_5", length));
			String[] crntScYn = (JSPUtil.getParameter(request, prefix	+ "crnt_sc_yn", length));
			String[] crntRfaYn = (JSPUtil.getParameter(request, prefix	+ "crnt_rfa_yn", length));
			String[] preScNo = (JSPUtil.getParameter(request, prefix	+ "pre_sc_no", length));
			String[] preRfaNo = (JSPUtil.getParameter(request, prefix	+ "pre_rfa_no", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] scRfaFlg = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustManageVO();
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (wkMqcQty[i] != null)
					model.setWkMqcQty(wkMqcQty[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (popYn[i] != null)
					model.setPopYn(popYn[i]);
				if (newVerSeq[i] != null)
					model.setNewVerSeq(newVerSeq[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (allSave[i] != null)
					model.setAllSave(allSave[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (acctPicNm[i] != null)
					model.setAcctPicNm(acctPicNm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (subTrd1[i] != null)
					model.setSubTrd1(subTrd1[i]);
				if (subTrd2[i] != null)
					model.setSubTrd2(subTrd2[i]);
				if (subTrd3[i] != null)
					model.setSubTrd3(subTrd3[i]);
				if (subTrd4[i] != null)
					model.setSubTrd4(subTrd4[i]);
				if (subTrd5[i] != null)
					model.setSubTrd5(subTrd5[i]);
				if (crntScYn[i] != null)
					model.setCrntScYn(crntScYn[i]);
				if (crntRfaYn[i] != null)
					model.setCrntRfaYn(crntRfaYn[i]);
				if (preScNo[i] != null)
					model.setPreScNo(preScNo[i]);
				if (preRfaNo[i] != null)
					model.setPreRfaNo(preRfaNo[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (scRfaFlg[i] != null)
					model.setScRfaFlg(scRfaFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustManageVO[]
	 */
	public CustManageVO[] getCustManageVOs(){
		CustManageVO[] vos = (CustManageVO[])models.toArray(new CustManageVO[models.size()]);
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
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkMqcQty = this.wkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popYn = this.popYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVerSeq = this.newVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allSave = this.allSave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctPicNm = this.acctPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrd1 = this.subTrd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrd2 = this.subTrd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrd3 = this.subTrd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrd4 = this.subTrd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrd5 = this.subTrd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntScYn = this.crntScYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRfaYn = this.crntRfaYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preScNo = this.preScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRfaNo = this.preRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaFlg = this.scRfaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
