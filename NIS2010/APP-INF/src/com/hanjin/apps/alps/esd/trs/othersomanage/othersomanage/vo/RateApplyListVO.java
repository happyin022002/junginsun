/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RateApplyListVO.java
*@FileTitle : RateApplyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.18  
* 1.0 Creation
* 2011.04.27 손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.10.20 이수진 [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RateApplyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RateApplyListVO> models = new ArrayList<RateApplyListVO>();
	
	/* Column Info */
	private String poRtnMsg = null;
	/* Column Info */
	private String poLocalCurrTotAmt = null;
	/* Column Info */
	private String poTrspAgmtSeq = null;
	/* Column Info */
	private String poVatScgRt = null;
	/* Column Info */
	private String poScg1Rt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String poScg2Rt = null;
	/* Column Info */
	private String poCustCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String poTrspAgmtRtTpCd = null;
	/* Column Info */
	private String poFuelScgRt = null;
	/* Column Info */
	private String poTrspAgmtOfcCtyCd = null;
	/* Column Info */
	private String poTrspAgmtRtTpNm = null;
	/* Column Info */
	private String poUsdCurrTotAmt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String poCustNomiTrkrFlg = null;
	/* Column Info */
	private String poWayType = null;
	/* Column Info */
	private String poCustSeq = null;
	/* Column Info */
	private String poBasicRt = null;
	/* Column Info */
	private String poOverWgtScgRt = null;
	/* Column Info */
	private String poSpType = null;
	/* Column Info */
	private String poRtnCd = null;
	/* Column Info */
	private String poScg3Rt = null;
	/* Column Info */
	private String poLocalCurrCd = null;
	/* Column Info */
	private String poCustCndCdSeq = null;
	/* Column Info */
	private String poWtrRcvTermCd = null;
	/* Column Info */
	private String poWtrDeTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RateApplyListVO() {}

	public RateApplyListVO(String ibflag, String pagerows, String invXchRt, String poTrspAgmtOfcCtyCd, String poTrspAgmtSeq, String poTrspAgmtRtTpCd, String poWayType, String poTrspAgmtRtTpNm, String poSpType, String poCustNomiTrkrFlg, String poCustCntCd, String poCustSeq, String poCustCndCdSeq, String poLocalCurrCd, String poBasicRt, String poFuelScgRt, String poOverWgtScgRt, String poVatScgRt, String poScg1Rt, String poScg2Rt, String poScg3Rt, String poLocalCurrTotAmt, String poUsdCurrTotAmt, String poRtnCd, String poRtnMsg, String poWtrRcvTermCd, String poWtrDeTermCd) {
		this.poRtnMsg = poRtnMsg;
		this.poLocalCurrTotAmt = poLocalCurrTotAmt;
		this.poTrspAgmtSeq = poTrspAgmtSeq;
		this.poVatScgRt = poVatScgRt;
		this.poScg1Rt = poScg1Rt;
		this.pagerows = pagerows;
		this.poScg2Rt = poScg2Rt;
		this.poCustCntCd = poCustCntCd;
		this.ibflag = ibflag;
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
		this.poFuelScgRt = poFuelScgRt;
		this.poTrspAgmtOfcCtyCd = poTrspAgmtOfcCtyCd;
		this.poTrspAgmtRtTpNm = poTrspAgmtRtTpNm;
		this.poUsdCurrTotAmt = poUsdCurrTotAmt;
		this.invXchRt = invXchRt;
		this.poCustNomiTrkrFlg = poCustNomiTrkrFlg;
		this.poWayType = poWayType;
		this.poCustSeq = poCustSeq;
		this.poBasicRt = poBasicRt;
		this.poOverWgtScgRt = poOverWgtScgRt;
		this.poSpType = poSpType;
		this.poRtnCd = poRtnCd;
		this.poScg3Rt = poScg3Rt;
		this.poLocalCurrCd = poLocalCurrCd;
		this.poCustCndCdSeq = poCustCndCdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("po_rtn_msg", getPoRtnMsg());
		this.hashColumns.put("po_local_curr_tot_amt", getPoLocalCurrTotAmt());
		this.hashColumns.put("po_trsp_agmt_seq", getPoTrspAgmtSeq());
		this.hashColumns.put("po_vat_scg_rt", getPoVatScgRt());
		this.hashColumns.put("po_scg1_rt", getPoScg1Rt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("po_scg2_rt", getPoScg2Rt());
		this.hashColumns.put("po_cust_cnt_cd", getPoCustCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("po_trsp_agmt_rt_tp_cd", getPoTrspAgmtRtTpCd());
		this.hashColumns.put("po_fuel_scg_rt", getPoFuelScgRt());
		this.hashColumns.put("po_trsp_agmt_ofc_cty_cd", getPoTrspAgmtOfcCtyCd());
		this.hashColumns.put("po_trsp_agmt_rt_tp_nm", getPoTrspAgmtRtTpNm());
		this.hashColumns.put("po_usd_curr_tot_amt", getPoUsdCurrTotAmt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("po_cust_nomi_trkr_flg", getPoCustNomiTrkrFlg());
		this.hashColumns.put("po_way_type", getPoWayType());
		this.hashColumns.put("po_cust_seq", getPoCustSeq());
		this.hashColumns.put("po_basic_rt", getPoBasicRt());
		this.hashColumns.put("po_over_wgt_scg_rt", getPoOverWgtScgRt());
		this.hashColumns.put("po_sp_type", getPoSpType());
		this.hashColumns.put("po_rtn_cd", getPoRtnCd());
		this.hashColumns.put("po_scg3_rt", getPoScg3Rt());
		this.hashColumns.put("po_local_curr_cd", getPoLocalCurrCd());
		this.hashColumns.put("po_cust_cnd_cd_seq", getPoCustCndCdSeq());
		this.hashColumns.put("po_wtr_rcv_term_cd", getPoWtrRcvTermCd());
		this.hashColumns.put("po_wtr_de_term_cd", getPoWtrDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("po_rtn_msg", "poRtnMsg");
		this.hashFields.put("po_local_curr_tot_amt", "poLocalCurrTotAmt");
		this.hashFields.put("po_trsp_agmt_seq", "poTrspAgmtSeq");
		this.hashFields.put("po_vat_scg_rt", "poVatScgRt");
		this.hashFields.put("po_scg1_rt", "poScg1Rt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("po_scg2_rt", "poScg2Rt");
		this.hashFields.put("po_cust_cnt_cd", "poCustCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("po_trsp_agmt_rt_tp_cd", "poTrspAgmtRtTpCd");
		this.hashFields.put("po_fuel_scg_rt", "poFuelScgRt");
		this.hashFields.put("po_trsp_agmt_ofc_cty_cd", "poTrspAgmtOfcCtyCd");
		this.hashFields.put("po_trsp_agmt_rt_tp_nm", "poTrspAgmtRtTpNm");
		this.hashFields.put("po_usd_curr_tot_amt", "poUsdCurrTotAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("po_cust_nomi_trkr_flg", "poCustNomiTrkrFlg");
		this.hashFields.put("po_way_type", "poWayType");
		this.hashFields.put("po_cust_seq", "poCustSeq");
		this.hashFields.put("po_basic_rt", "poBasicRt");
		this.hashFields.put("po_over_wgt_scg_rt", "poOverWgtScgRt");
		this.hashFields.put("po_sp_type", "poSpType");
		this.hashFields.put("po_rtn_cd", "poRtnCd");
		this.hashFields.put("po_scg3_rt", "poScg3Rt");
		this.hashFields.put("po_local_curr_cd", "poLocalCurrCd");
		this.hashFields.put("po_cust_cnd_cd_seq", "poCustCndCdSeq");
		this.hashFields.put("po_wtr_rcv_term_cd", "poWtrRcvTermCd");
		this.hashFields.put("po_wtr_de_term_cd", "poWtrDeTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return poRtnMsg
	 */
	public String getPoRtnMsg() {
		return this.poRtnMsg;
	}
	
	/**
	 * Column Info
	 * @return poLocalCurrTotAmt
	 */
	public String getPoLocalCurrTotAmt() {
		return this.poLocalCurrTotAmt;
	}
	
	/**
	 * Column Info
	 * @return poTrspAgmtSeq
	 */
	public String getPoTrspAgmtSeq() {
		return this.poTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return poVatScgRt
	 */
	public String getPoVatScgRt() {
		return this.poVatScgRt;
	}
	
	/**
	 * Column Info
	 * @return poScg1Rt
	 */
	public String getPoScg1Rt() {
		return this.poScg1Rt;
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
	 * @return poScg2Rt
	 */
	public String getPoScg2Rt() {
		return this.poScg2Rt;
	}
	
	/**
	 * Column Info
	 * @return poCustCntCd
	 */
	public String getPoCustCntCd() {
		return this.poCustCntCd;
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
	 * @return poTrspAgmtRtTpCd
	 */
	public String getPoTrspAgmtRtTpCd() {
		return this.poTrspAgmtRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return poFuelScgRt
	 */
	public String getPoFuelScgRt() {
		return this.poFuelScgRt;
	}
	
	/**
	 * Column Info
	 * @return poTrspAgmtOfcCtyCd
	 */
	public String getPoTrspAgmtOfcCtyCd() {
		return this.poTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return poTrspAgmtRtTpNm
	 */
	public String getPoTrspAgmtRtTpNm() {
		return this.poTrspAgmtRtTpNm;
	}
	
	/**
	 * Column Info
	 * @return poUsdCurrTotAmt
	 */
	public String getPoUsdCurrTotAmt() {
		return this.poUsdCurrTotAmt;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return poCustNomiTrkrFlg
	 */
	public String getPoCustNomiTrkrFlg() {
		return this.poCustNomiTrkrFlg;
	}
	
	/**
	 * Column Info
	 * @return poWayType
	 */
	public String getPoWayType() {
		return this.poWayType;
	}
	
	/**
	 * Column Info
	 * @return poCustSeq
	 */
	public String getPoCustSeq() {
		return this.poCustSeq;
	}
	
	/**
	 * Column Info
	 * @return poBasicRt
	 */
	public String getPoBasicRt() {
		return this.poBasicRt;
	}
	
	/**
	 * Column Info
	 * @return poOverWgtScgRt
	 */
	public String getPoOverWgtScgRt() {
		return this.poOverWgtScgRt;
	}
	
	/**
	 * Column Info
	 * @return poSpType
	 */
	public String getPoSpType() {
		return this.poSpType;
	}
	
	/**
	 * Column Info
	 * @return poRtnCd
	 */
	public String getPoRtnCd() {
		return this.poRtnCd;
	}
	
	/**
	 * Column Info
	 * @return poScg3Rt
	 */
	public String getPoScg3Rt() {
		return this.poScg3Rt;
	}
	
	/**
	 * Column Info
	 * @return poLocalCurrCd
	 */
	public String getPoLocalCurrCd() {
		return this.poLocalCurrCd;
	}
	
	/**
	 * Column Info
	 * @return poCustCndCdSeq
	 */
	public String getPoCustCndCdSeq() {
		return this.poCustCndCdSeq;
	}
	
	/**
	 * Column Info
	 * @return poWtrDeTermCd
	 */
	public String getPoWtrDeTermCd() {
		return this.poWtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return poWtrRcvTermCd
	 */
	public String getPoWtrRcvTermCd() {
		return this.poWtrRcvTermCd;
	}
	

	/**
	 * Column Info
	 * @param poRtnMsg
	 */
	public void setPoRtnMsg(String poRtnMsg) {
		this.poRtnMsg = poRtnMsg;
	}
	
	/**
	 * Column Info
	 * @param poLocalCurrTotAmt
	 */
	public void setPoLocalCurrTotAmt(String poLocalCurrTotAmt) {
		this.poLocalCurrTotAmt = poLocalCurrTotAmt;
	}
	
	/**
	 * Column Info
	 * @param poTrspAgmtSeq
	 */
	public void setPoTrspAgmtSeq(String poTrspAgmtSeq) {
		this.poTrspAgmtSeq = poTrspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param poVatScgRt
	 */
	public void setPoVatScgRt(String poVatScgRt) {
		this.poVatScgRt = poVatScgRt;
	}
	
	/**
	 * Column Info
	 * @param poScg1Rt
	 */
	public void setPoScg1Rt(String poScg1Rt) {
		this.poScg1Rt = poScg1Rt;
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
	 * @param poScg2Rt
	 */
	public void setPoScg2Rt(String poScg2Rt) {
		this.poScg2Rt = poScg2Rt;
	}
	
	/**
	 * Column Info
	 * @param poCustCntCd
	 */
	public void setPoCustCntCd(String poCustCntCd) {
		this.poCustCntCd = poCustCntCd;
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
	 * @param poTrspAgmtRtTpCd
	 */
	public void setPoTrspAgmtRtTpCd(String poTrspAgmtRtTpCd) {
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param poFuelScgRt
	 */
	public void setPoFuelScgRt(String poFuelScgRt) {
		this.poFuelScgRt = poFuelScgRt;
	}
	
	/**
	 * Column Info
	 * @param poTrspAgmtOfcCtyCd
	 */
	public void setPoTrspAgmtOfcCtyCd(String poTrspAgmtOfcCtyCd) {
		this.poTrspAgmtOfcCtyCd = poTrspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param poTrspAgmtRtTpNm
	 */
	public void setPoTrspAgmtRtTpNm(String poTrspAgmtRtTpNm) {
		this.poTrspAgmtRtTpNm = poTrspAgmtRtTpNm;
	}
	
	/**
	 * Column Info
	 * @param poUsdCurrTotAmt
	 */
	public void setPoUsdCurrTotAmt(String poUsdCurrTotAmt) {
		this.poUsdCurrTotAmt = poUsdCurrTotAmt;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param poCustNomiTrkrFlg
	 */
	public void setPoCustNomiTrkrFlg(String poCustNomiTrkrFlg) {
		this.poCustNomiTrkrFlg = poCustNomiTrkrFlg;
	}
	
	/**
	 * Column Info
	 * @param poWayType
	 */
	public void setPoWayType(String poWayType) {
		this.poWayType = poWayType;
	}
	
	/**
	 * Column Info
	 * @param poCustSeq
	 */
	public void setPoCustSeq(String poCustSeq) {
		this.poCustSeq = poCustSeq;
	}
	
	/**
	 * Column Info
	 * @param poBasicRt
	 */
	public void setPoBasicRt(String poBasicRt) {
		this.poBasicRt = poBasicRt;
	}
	
	/**
	 * Column Info
	 * @param poOverWgtScgRt
	 */
	public void setPoOverWgtScgRt(String poOverWgtScgRt) {
		this.poOverWgtScgRt = poOverWgtScgRt;
	}
	
	/**
	 * Column Info
	 * @param poSpType
	 */
	public void setPoSpType(String poSpType) {
		this.poSpType = poSpType;
	}
	
	/**
	 * Column Info
	 * @param poRtnCd
	 */
	public void setPoRtnCd(String poRtnCd) {
		this.poRtnCd = poRtnCd;
	}
	
	/**
	 * Column Info
	 * @param poScg3Rt
	 */
	public void setPoScg3Rt(String poScg3Rt) {
		this.poScg3Rt = poScg3Rt;
	}
	
	/**
	 * Column Info
	 * @param poLocalCurrCd
	 */
	public void setPoLocalCurrCd(String poLocalCurrCd) {
		this.poLocalCurrCd = poLocalCurrCd;
	}
	
	/**
	 * Column Info
	 * @param poCustCndCdSeq
	 */
	public void setPoCustCndCdSeq(String poCustCndCdSeq) {
		this.poCustCndCdSeq = poCustCndCdSeq;
	}
	
	/**
	 * Column Info
	 * @param poWtrRcvTermCd
	 */
	public void setPoWtrRcvTermCd(String poWtrRcvTermCd) {
		this.poWtrRcvTermCd = poWtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param poWtrDeTermCd
	 */
	public void setPoWtrDeTermCd(String poWtrDeTermCd) {
		this.poWtrDeTermCd = poWtrDeTermCd;
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
		setPoRtnMsg(JSPUtil.getParameter(request, prefix + "po_rtn_msg", ""));
		setPoLocalCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_local_curr_tot_amt", ""));
		setPoTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_seq", ""));
		setPoVatScgRt(JSPUtil.getParameter(request, prefix + "po_vat_scg_rt", ""));
		setPoScg1Rt(JSPUtil.getParameter(request, prefix + "po_scg1_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPoScg2Rt(JSPUtil.getParameter(request, prefix + "po_scg2_rt", ""));
		setPoCustCntCd(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPoTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_cd", ""));
		setPoFuelScgRt(JSPUtil.getParameter(request, prefix + "po_fuel_scg_rt", ""));
		setPoTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_ofc_cty_cd", ""));
		setPoTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_nm", ""));
		setPoUsdCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_usd_curr_tot_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setPoCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "po_cust_nomi_trkr_flg", ""));
		setPoWayType(JSPUtil.getParameter(request, prefix + "po_way_type", ""));
		setPoCustSeq(JSPUtil.getParameter(request, prefix + "po_cust_seq", ""));
		setPoBasicRt(JSPUtil.getParameter(request, prefix + "po_basic_rt", ""));
		setPoOverWgtScgRt(JSPUtil.getParameter(request, prefix + "po_over_wgt_scg_rt", ""));
		setPoSpType(JSPUtil.getParameter(request, prefix + "po_sp_type", ""));
		setPoRtnCd(JSPUtil.getParameter(request, prefix + "po_rtn_cd", ""));
		setPoScg3Rt(JSPUtil.getParameter(request, prefix + "po_scg3_rt", ""));
		setPoLocalCurrCd(JSPUtil.getParameter(request, prefix + "po_local_curr_cd", ""));
		setPoCustCndCdSeq(JSPUtil.getParameter(request, prefix + "po_cust_cnd_cd_seq", ""));
		setPoWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "po_wtr_rcv_term_cd", ""));
		setPoWtrDeTermCd(JSPUtil.getParameter(request, prefix + "po_wtr_de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RateApplyListVO[]
	 */
	public RateApplyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RateApplyListVO[]
	 */
	public RateApplyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RateApplyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] poRtnMsg = (JSPUtil.getParameter(request, prefix	+ "po_rtn_msg", length));
			String[] poLocalCurrTotAmt = (JSPUtil.getParameter(request, prefix	+ "po_local_curr_tot_amt", length));
			String[] poTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_seq", length));
			String[] poVatScgRt = (JSPUtil.getParameter(request, prefix	+ "po_vat_scg_rt", length));
			String[] poScg1Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg1_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] poScg2Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg2_rt", length));
			String[] poCustCntCd = (JSPUtil.getParameter(request, prefix	+ "po_cust_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] poTrspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_rt_tp_cd", length));
			String[] poFuelScgRt = (JSPUtil.getParameter(request, prefix	+ "po_fuel_scg_rt", length));
			String[] poTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_ofc_cty_cd", length));
			String[] poTrspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_rt_tp_nm", length));
			String[] poUsdCurrTotAmt = (JSPUtil.getParameter(request, prefix	+ "po_usd_curr_tot_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] poCustNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "po_cust_nomi_trkr_flg", length));
			String[] poWayType = (JSPUtil.getParameter(request, prefix	+ "po_way_type", length));
			String[] poCustSeq = (JSPUtil.getParameter(request, prefix	+ "po_cust_seq", length));
			String[] poBasicRt = (JSPUtil.getParameter(request, prefix	+ "po_basic_rt", length));
			String[] poOverWgtScgRt = (JSPUtil.getParameter(request, prefix	+ "po_over_wgt_scg_rt", length));
			String[] poSpType = (JSPUtil.getParameter(request, prefix	+ "po_sp_type", length));
			String[] poRtnCd = (JSPUtil.getParameter(request, prefix	+ "po_rtn_cd", length));
			String[] poScg3Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg3_rt", length));
			String[] poLocalCurrCd = (JSPUtil.getParameter(request, prefix	+ "po_local_curr_cd", length));
			String[] poCustCndCdSeq = (JSPUtil.getParameter(request, prefix	+ "po_cust_cnd_cd_seq", length));
			String[] poWtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "po_wtr_rcv_term_cd", length));
			String[] poWtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "po_wtr_de_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RateApplyListVO();
				if (poRtnMsg[i] != null)
					model.setPoRtnMsg(poRtnMsg[i]);
				if (poLocalCurrTotAmt[i] != null)
					model.setPoLocalCurrTotAmt(poLocalCurrTotAmt[i]);
				if (poTrspAgmtSeq[i] != null)
					model.setPoTrspAgmtSeq(poTrspAgmtSeq[i]);
				if (poVatScgRt[i] != null)
					model.setPoVatScgRt(poVatScgRt[i]);
				if (poScg1Rt[i] != null)
					model.setPoScg1Rt(poScg1Rt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (poScg2Rt[i] != null)
					model.setPoScg2Rt(poScg2Rt[i]);
				if (poCustCntCd[i] != null)
					model.setPoCustCntCd(poCustCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (poTrspAgmtRtTpCd[i] != null)
					model.setPoTrspAgmtRtTpCd(poTrspAgmtRtTpCd[i]);
				if (poFuelScgRt[i] != null)
					model.setPoFuelScgRt(poFuelScgRt[i]);
				if (poTrspAgmtOfcCtyCd[i] != null)
					model.setPoTrspAgmtOfcCtyCd(poTrspAgmtOfcCtyCd[i]);
				if (poTrspAgmtRtTpNm[i] != null)
					model.setPoTrspAgmtRtTpNm(poTrspAgmtRtTpNm[i]);
				if (poUsdCurrTotAmt[i] != null)
					model.setPoUsdCurrTotAmt(poUsdCurrTotAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (poCustNomiTrkrFlg[i] != null)
					model.setPoCustNomiTrkrFlg(poCustNomiTrkrFlg[i]);
				if (poWayType[i] != null)
					model.setPoWayType(poWayType[i]);
				if (poCustSeq[i] != null)
					model.setPoCustSeq(poCustSeq[i]);
				if (poBasicRt[i] != null)
					model.setPoBasicRt(poBasicRt[i]);
				if (poOverWgtScgRt[i] != null)
					model.setPoOverWgtScgRt(poOverWgtScgRt[i]);
				if (poSpType[i] != null)
					model.setPoSpType(poSpType[i]);
				if (poRtnCd[i] != null)
					model.setPoRtnCd(poRtnCd[i]);
				if (poScg3Rt[i] != null)
					model.setPoScg3Rt(poScg3Rt[i]);
				if (poLocalCurrCd[i] != null)
					model.setPoLocalCurrCd(poLocalCurrCd[i]);
				if (poCustCndCdSeq[i] != null)
					model.setPoCustCndCdSeq(poCustCndCdSeq[i]);
				if (poWtrRcvTermCd[i] != null)
					model.setPoWtrRcvTermCd(poWtrRcvTermCd[i]);
				if (poWtrDeTermCd[i] != null)
					model.setPoWtrDeTermCd(poWtrDeTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRateApplyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RateApplyListVO[]
	 */
	public RateApplyListVO[] getRateApplyListVOs(){
		RateApplyListVO[] vos = (RateApplyListVO[])models.toArray(new RateApplyListVO[models.size()]);
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
		this.poRtnMsg = this.poRtnMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrTotAmt = this.poLocalCurrTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtSeq = this.poTrspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poVatScgRt = this.poVatScgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg1Rt = this.poScg1Rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg2Rt = this.poScg2Rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCd = this.poCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpCd = this.poTrspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poFuelScgRt = this.poFuelScgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtOfcCtyCd = this.poTrspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpNm = this.poTrspAgmtRtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poUsdCurrTotAmt = this.poUsdCurrTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustNomiTrkrFlg = this.poCustNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWayType = this.poWayType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustSeq = this.poCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poBasicRt = this.poBasicRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poOverWgtScgRt = this.poOverWgtScgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poSpType = this.poSpType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnCd = this.poRtnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg3Rt = this.poScg3Rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrCd = this.poLocalCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCndCdSeq = this.poCustCndCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWtrRcvTermCd = this.poWtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWtrDeTermCd = this.poWtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
