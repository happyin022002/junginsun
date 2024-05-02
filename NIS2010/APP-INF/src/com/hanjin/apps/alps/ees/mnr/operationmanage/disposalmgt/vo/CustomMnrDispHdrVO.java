/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrDispHdrVO.java
*@FileTitle : CustomMnrDispHdrVO
*Open Issues :
*Change history : 2015.06.16, 신용찬, CURR_CD, APRO_OFC_CD 중복 방지용 소스작업
*@LastModifyDate : 2011.05.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.05.12 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispHdrVO> models = new ArrayList<CustomMnrDispHdrVO>();
	
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String currCd = null;
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String dispPkupEndDt = null;
	/* Column Info */
	private String dispBultnDt = null;
	/* Column Info */
	private String totalQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String etcqty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totBidPrice = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String pendingQty = null;
	/* Column Info */
	private String totBidCnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dispUtTpNm = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String buyerCnt = null;
	/* Column Info */
	private String dispPkupStDt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mnrDispRmk = null;
	/* Column Info */
	private String soldQty = null;
	/* Column Info */
	private String dispStsCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dispEmlFlg = null;
	/* Column Info */
	private String dispTpNm = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String buyerName = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dispStDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String buyerCode = null;
	/* Column Info */
	private String dispStPrc = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String mnrPrnrEml = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String dispEndDt = null;
	/* Column Info */
	private String reDispTpCd = null;	
	/* Column Info */
	private String reDispTpNm = null;	

	/* Column Info */
	private String reCurrCd = null;	
	/* Column Info */
	private String reAproOfcCd = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrDispHdrVO() {}

	public CustomMnrDispHdrVO(String ibflag, String pagerows, String rqstUsrId, String currCd, String creDt, String mnrPrnrCntCd, String dispQty, String dispBultnDt, String dispPkupEndDt, String aproOfcCd, String totalQty, String mnrPrnrSeq, String etcqty, String totBidPrice, String updUsrId, String pendingQty, String totBidCnt, String updDt, String dispUtTpNm, String dispTpCd, String rqstDt, String buyerCnt, String dispPkupStDt, String dispNo, String mnrDispRmk, String soldQty, String dispStsCd, String eqKndCd, String dispTpNm, String dispEmlFlg, String aproDt, String buyerName, String invNo, String buyerCode, String creUsrId, String dispStDt, String dispStPrc, String aproUsrId, String mnrPrnrEml, String dispUtTpCd, String rqstOfcCd, String fileSeq, String faxNo, String dispEndDt, String deltFlg, String reDispTpCd, String reDispTpNm, String reCurrCd, String reAproOfcCd) {
		this.rqstUsrId = rqstUsrId;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.creDt = creDt;
		this.dispQty = dispQty;
		this.aproOfcCd = aproOfcCd;
		this.dispPkupEndDt = dispPkupEndDt;
		this.dispBultnDt = dispBultnDt;
		this.totalQty = totalQty;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.etcqty = etcqty;
		this.ibflag = ibflag;
		this.totBidPrice = totBidPrice;
		this.updUsrId = updUsrId;
		this.pendingQty = pendingQty;
		this.totBidCnt = totBidCnt;
		this.updDt = updDt;
		this.dispUtTpNm = dispUtTpNm;
		this.dispTpCd = dispTpCd;
		this.rqstDt = rqstDt;
		this.buyerCnt = buyerCnt;
		this.dispPkupStDt = dispPkupStDt;
		this.dispNo = dispNo;
		this.mnrDispRmk = mnrDispRmk;
		this.soldQty = soldQty;
		this.dispStsCd = dispStsCd;
		this.eqKndCd = eqKndCd;
		this.dispEmlFlg = dispEmlFlg;
		this.dispTpNm = dispTpNm;
		this.aproDt = aproDt;
		this.buyerName = buyerName;
		this.invNo = invNo;
		this.dispStDt = dispStDt;
		this.creUsrId = creUsrId;
		this.buyerCode = buyerCode;
		this.dispStPrc = dispStPrc;
		this.aproUsrId = aproUsrId;
		this.dispUtTpCd = dispUtTpCd;
		this.mnrPrnrEml = mnrPrnrEml;
		this.rqstOfcCd = rqstOfcCd;
		this.faxNo = faxNo;
		this.fileSeq = fileSeq;
		this.dispEndDt = dispEndDt;
		this.reDispTpCd = reDispTpCd;
		this.reDispTpNm = reDispTpNm;
//		this.setReDispTpCd(reDispTpCd);
//		this.setReDispTpNm(reDispTpNm);
		
		this.reCurrCd    = reCurrCd;
		this.reAproOfcCd = reAproOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("disp_pkup_end_dt", getDispPkupEndDt());
		this.hashColumns.put("disp_bultn_dt", getDispBultnDt());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("etcqty", getEtcqty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_bid_price", getTotBidPrice());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pending_qty", getPendingQty());
		this.hashColumns.put("tot_bid_cnt", getTotBidCnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("disp_ut_tp_nm", getDispUtTpNm());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("buyer_cnt", getBuyerCnt());
		this.hashColumns.put("disp_pkup_st_dt", getDispPkupStDt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mnr_disp_rmk", getMnrDispRmk());
		this.hashColumns.put("sold_qty", getSoldQty());
		this.hashColumns.put("disp_sts_cd", getDispStsCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_eml_flg", getDispEmlFlg());
		this.hashColumns.put("disp_tp_nm", getDispTpNm());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("buyer_name", getBuyerName());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("disp_st_dt", getDispStDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("buyer_code", getBuyerCode());
		this.hashColumns.put("disp_st_prc", getDispStPrc());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("mnr_prnr_eml", getMnrPrnrEml());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("disp_end_dt", getDispEndDt());
		this.hashColumns.put("re_disp_tp_cd", getReDispTpCd());
		this.hashColumns.put("re_disp_tp_nm", getReDispTpNm());		
		
		this.hashColumns.put("re_curr_cd", getReCurrCd());
		this.hashColumns.put("re_apro_ofc_cd", getReAproOfcCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("disp_pkup_end_dt", "dispPkupEndDt");
		this.hashFields.put("disp_bultn_dt", "dispBultnDt");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("etcqty", "etcqty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_bid_price", "totBidPrice");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pending_qty", "pendingQty");
		this.hashFields.put("tot_bid_cnt", "totBidCnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("disp_ut_tp_nm", "dispUtTpNm");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("buyer_cnt", "buyerCnt");
		this.hashFields.put("disp_pkup_st_dt", "dispPkupStDt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_disp_rmk", "mnrDispRmk");
		this.hashFields.put("sold_qty", "soldQty");
		this.hashFields.put("disp_sts_cd", "dispStsCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_eml_flg", "dispEmlFlg");
		this.hashFields.put("disp_tp_nm", "dispTpNm");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("buyer_name", "buyerName");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("disp_st_dt", "dispStDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("buyer_code", "buyerCode");
		this.hashFields.put("disp_st_prc", "dispStPrc");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("mnr_prnr_eml", "mnrPrnrEml");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("disp_end_dt", "dispEndDt");
		
		this.hashFields.put("re_disp_tp_cd", "reDispTpCd");
		this.hashFields.put("re_disp_tp_nm", "reDispTpNm");
		
		this.hashFields.put("re_curr_cd",     "reCurrCd");
		this.hashFields.put("re_apro_ofc_cd", "reAproOfcCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dispPkupEndDt
	 */
	public String getDispPkupEndDt() {
		return this.dispPkupEndDt;
	}
	
	/**
	 * Column Info
	 * @return dispBultnDt
	 */
	public String getDispBultnDt() {
		return this.dispBultnDt;
	}
	
	/**
	 * Column Info
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @return etcqty
	 */
	public String getEtcqty() {
		return this.etcqty;
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
	 * @return totBidPrice
	 */
	public String getTotBidPrice() {
		return this.totBidPrice;
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
	 * @return pendingQty
	 */
	public String getPendingQty() {
		return this.pendingQty;
	}
	
	/**
	 * Column Info
	 * @return totBidCnt
	 */
	public String getTotBidCnt() {
		return this.totBidCnt;
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
	 * @return dispUtTpNm
	 */
	public String getDispUtTpNm() {
		return this.dispUtTpNm;
	}
	
	/**
	 * Column Info
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return buyerCnt
	 */
	public String getBuyerCnt() {
		return this.buyerCnt;
	}
	
	/**
	 * Column Info
	 * @return dispPkupStDt
	 */
	public String getDispPkupStDt() {
		return this.dispPkupStDt;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mnrDispRmk
	 */
	public String getMnrDispRmk() {
		return this.mnrDispRmk;
	}
	
	/**
	 * Column Info
	 * @return soldQty
	 */
	public String getSoldQty() {
		return this.soldQty;
	}
	
	/**
	 * Column Info
	 * @return dispStsCd
	 */
	public String getDispStsCd() {
		return this.dispStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return dispEmlFlg
	 */
	public String getDispEmlFlg() {
		return this.dispEmlFlg;
	}
	
	/**
	 * Column Info
	 * @return dispTpNm
	 */
	public String getDispTpNm() {
		return this.dispTpNm;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return buyerName
	 */
	public String getBuyerName() {
		return this.buyerName;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return dispStDt
	 */
	public String getDispStDt() {
		return this.dispStDt;
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
	 * @return buyerCode
	 */
	public String getBuyerCode() {
		return this.buyerCode;
	}
	
	/**
	 * Column Info
	 * @return dispStPrc
	 */
	public String getDispStPrc() {
		return this.dispStPrc;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return dispUtTpCd
	 */
	public String getDispUtTpCd() {
		return this.dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrEml
	 */
	public String getMnrPrnrEml() {
		return this.mnrPrnrEml;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return dispEndDt
	 */
	public String getDispEndDt() {
		return this.dispEndDt;
	}
	

	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dispPkupEndDt
	 */
	public void setDispPkupEndDt(String dispPkupEndDt) {
		this.dispPkupEndDt = dispPkupEndDt;
	}
	
	/**
	 * Column Info
	 * @param dispBultnDt
	 */
	public void setDispBultnDt(String dispBultnDt) {
		this.dispBultnDt = dispBultnDt;
	}
	
	/**
	 * Column Info
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @param etcqty
	 */
	public void setEtcqty(String etcqty) {
		this.etcqty = etcqty;
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
	 * @param totBidPrice
	 */
	public void setTotBidPrice(String totBidPrice) {
		this.totBidPrice = totBidPrice;
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
	 * @param pendingQty
	 */
	public void setPendingQty(String pendingQty) {
		this.pendingQty = pendingQty;
	}
	
	/**
	 * Column Info
	 * @param totBidCnt
	 */
	public void setTotBidCnt(String totBidCnt) {
		this.totBidCnt = totBidCnt;
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
	 * @param dispUtTpNm
	 */
	public void setDispUtTpNm(String dispUtTpNm) {
		this.dispUtTpNm = dispUtTpNm;
	}
	
	/**
	 * Column Info
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param buyerCnt
	 */
	public void setBuyerCnt(String buyerCnt) {
		this.buyerCnt = buyerCnt;
	}
	
	/**
	 * Column Info
	 * @param dispPkupStDt
	 */
	public void setDispPkupStDt(String dispPkupStDt) {
		this.dispPkupStDt = dispPkupStDt;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mnrDispRmk
	 */
	public void setMnrDispRmk(String mnrDispRmk) {
		this.mnrDispRmk = mnrDispRmk;
	}
	
	/**
	 * Column Info
	 * @param soldQty
	 */
	public void setSoldQty(String soldQty) {
		this.soldQty = soldQty;
	}
	
	/**
	 * Column Info
	 * @param dispStsCd
	 */
	public void setDispStsCd(String dispStsCd) {
		this.dispStsCd = dispStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param dispEmlFlg
	 */
	public void setDispEmlFlg(String dispEmlFlg) {
		this.dispEmlFlg = dispEmlFlg;
	}
	
	/**
	 * Column Info
	 * @param dispTpNm
	 */
	public void setDispTpNm(String dispTpNm) {
		this.dispTpNm = dispTpNm;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param buyerName
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param dispStDt
	 */
	public void setDispStDt(String dispStDt) {
		this.dispStDt = dispStDt;
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
	 * @param buyerCode
	 */
	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}
	
	/**
	 * Column Info
	 * @param dispStPrc
	 */
	public void setDispStPrc(String dispStPrc) {
		this.dispStPrc = dispStPrc;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param dispUtTpCd
	 */
	public void setDispUtTpCd(String dispUtTpCd) {
		this.dispUtTpCd = dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrEml
	 */
	public void setMnrPrnrEml(String mnrPrnrEml) {
		this.mnrPrnrEml = mnrPrnrEml;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param dispEndDt
	 */
	public void setDispEndDt(String dispEndDt) {
		this.dispEndDt = dispEndDt;
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
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setDispPkupEndDt(JSPUtil.getParameter(request, prefix + "disp_pkup_end_dt", ""));
		setDispBultnDt(JSPUtil.getParameter(request, prefix + "disp_bultn_dt", ""));
		setTotalQty(JSPUtil.getParameter(request, prefix + "total_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setEtcqty(JSPUtil.getParameter(request, prefix + "etcqty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotBidPrice(JSPUtil.getParameter(request, prefix + "tot_bid_price", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPendingQty(JSPUtil.getParameter(request, prefix + "pending_qty", ""));
		setTotBidCnt(JSPUtil.getParameter(request, prefix + "tot_bid_cnt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDispUtTpNm(JSPUtil.getParameter(request, prefix + "disp_ut_tp_nm", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setBuyerCnt(JSPUtil.getParameter(request, prefix + "buyer_cnt", ""));
		setDispPkupStDt(JSPUtil.getParameter(request, prefix + "disp_pkup_st_dt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setMnrDispRmk(JSPUtil.getParameter(request, prefix + "mnr_disp_rmk", ""));
		setSoldQty(JSPUtil.getParameter(request, prefix + "sold_qty", ""));
		setDispStsCd(JSPUtil.getParameter(request, prefix + "disp_sts_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setDispEmlFlg(JSPUtil.getParameter(request, prefix + "disp_eml_flg", ""));
		setDispTpNm(JSPUtil.getParameter(request, prefix + "disp_tp_nm", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setBuyerName(JSPUtil.getParameter(request, prefix + "buyer_name", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDispStDt(JSPUtil.getParameter(request, prefix + "disp_st_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBuyerCode(JSPUtil.getParameter(request, prefix + "buyer_code", ""));
		setDispStPrc(JSPUtil.getParameter(request, prefix + "disp_st_prc", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, prefix + "disp_ut_tp_cd", ""));
		setMnrPrnrEml(JSPUtil.getParameter(request, prefix + "mnr_prnr_eml", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setDispEndDt(JSPUtil.getParameter(request, prefix + "disp_end_dt", ""));
		setReDispTpCd(JSPUtil.getParameter(request, prefix + "re_disp_tp_cd", ""));
		setReDispTpNm(JSPUtil.getParameter(request, prefix + "re_disp_tp_nm", ""));
		
		setReCurrCd(JSPUtil.getParameter(request, prefix + "re_curr_cd", ""));
		setReAproOfcCd(JSPUtil.getParameter(request, prefix + "re_apro_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispHdrVO[]
	 */
	public CustomMnrDispHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispHdrVO[]
	 */
	public CustomMnrDispHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] dispPkupEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_end_dt", length));
			String[] dispBultnDt = (JSPUtil.getParameter(request, prefix	+ "disp_bultn_dt", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] etcqty = (JSPUtil.getParameter(request, prefix	+ "etcqty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totBidPrice = (JSPUtil.getParameter(request, prefix	+ "tot_bid_price", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pendingQty = (JSPUtil.getParameter(request, prefix	+ "pending_qty", length));
			String[] totBidCnt = (JSPUtil.getParameter(request, prefix	+ "tot_bid_cnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dispUtTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_nm", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] buyerCnt = (JSPUtil.getParameter(request, prefix	+ "buyer_cnt", length));
			String[] dispPkupStDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_st_dt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mnrDispRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_rmk", length));
			String[] soldQty = (JSPUtil.getParameter(request, prefix	+ "sold_qty", length));
			String[] dispStsCd = (JSPUtil.getParameter(request, prefix	+ "disp_sts_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispEmlFlg = (JSPUtil.getParameter(request, prefix	+ "disp_eml_flg", length));
			String[] dispTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_tp_nm", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] buyerName = (JSPUtil.getParameter(request, prefix	+ "buyer_name", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dispStDt = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] buyerCode = (JSPUtil.getParameter(request, prefix	+ "buyer_code", length));
			String[] dispStPrc = (JSPUtil.getParameter(request, prefix	+ "disp_st_prc", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] mnrPrnrEml = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_eml", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] dispEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_end_dt", length));
			
			String[] reDispTpCd = (JSPUtil.getParameter(request, prefix	+ "re_disp_tp_cd", length));
			String[] reDispTpNm = (JSPUtil.getParameter(request, prefix	+ "re_disp_tp_nm", length));
			
			String[] reCurrCd    = (JSPUtil.getParameter(request, prefix	+ "re_curr_cd", length));
			String[] reAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "re_apro_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispHdrVO();
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (dispPkupEndDt[i] != null)
					model.setDispPkupEndDt(dispPkupEndDt[i]);
				if (dispBultnDt[i] != null)
					model.setDispBultnDt(dispBultnDt[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (etcqty[i] != null)
					model.setEtcqty(etcqty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totBidPrice[i] != null)
					model.setTotBidPrice(totBidPrice[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pendingQty[i] != null)
					model.setPendingQty(pendingQty[i]);
				if (totBidCnt[i] != null)
					model.setTotBidCnt(totBidCnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dispUtTpNm[i] != null)
					model.setDispUtTpNm(dispUtTpNm[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (buyerCnt[i] != null)
					model.setBuyerCnt(buyerCnt[i]);
				if (dispPkupStDt[i] != null)
					model.setDispPkupStDt(dispPkupStDt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mnrDispRmk[i] != null)
					model.setMnrDispRmk(mnrDispRmk[i]);
				if (soldQty[i] != null)
					model.setSoldQty(soldQty[i]);
				if (dispStsCd[i] != null)
					model.setDispStsCd(dispStsCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dispEmlFlg[i] != null)
					model.setDispEmlFlg(dispEmlFlg[i]);
				if (dispTpNm[i] != null)
					model.setDispTpNm(dispTpNm[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (buyerName[i] != null)
					model.setBuyerName(buyerName[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dispStDt[i] != null)
					model.setDispStDt(dispStDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (buyerCode[i] != null)
					model.setBuyerCode(buyerCode[i]);
				if (dispStPrc[i] != null)
					model.setDispStPrc(dispStPrc[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (mnrPrnrEml[i] != null)
					model.setMnrPrnrEml(mnrPrnrEml[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (dispEndDt[i] != null)
					model.setDispEndDt(dispEndDt[i]);
				if (reDispTpCd[i] != null)
					model.setReDispTpCd(reDispTpCd[i]);
				if (reDispTpNm[i] != null)
					model.setReDispTpNm(reDispTpNm[i]);
				if (reCurrCd[i] != null)
					model.setReCurrCd(reCurrCd[i]);
				if (reAproOfcCd[i] != null)
					model.setReAproOfcCd(reAproOfcCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispHdrVO[]
	 */
	public CustomMnrDispHdrVO[] getCustomMnrDispHdrVOs(){
		CustomMnrDispHdrVO[] vos = (CustomMnrDispHdrVO[])models.toArray(new CustomMnrDispHdrVO[models.size()]);
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
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupEndDt = this.dispPkupEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispBultnDt = this.dispBultnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcqty = this.etcqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBidPrice = this.totBidPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingQty = this.pendingQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBidCnt = this.totBidCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpNm = this.dispUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCnt = this.buyerCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupStDt = this.dispPkupStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispRmk = this.mnrDispRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soldQty = this.soldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsCd = this.dispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEmlFlg = this.dispEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpNm = this.dispTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerName = this.buyerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDt = this.dispStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCode = this.buyerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStPrc = this.dispStPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrEml = this.mnrPrnrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEndDt = this.dispEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.reDispTpCd = this.reDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDispTpNm = this.reDispTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.reCurrCd    = this.reCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reAproOfcCd = this.reAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
 
	public String getReDispTpCd() {
		return reDispTpCd;
	}

	public void setReDispTpCd(String reDispTpCd) {
		this.reDispTpCd = reDispTpCd;
	}

	public String getReDispTpNm() {
		return reDispTpNm;
	}

	public void setReDispTpNm(String reDispTpNm) {
		this.reDispTpNm = reDispTpNm;
	}

	public String getReCurrCd() {
		return reCurrCd;
	}

	public void setReCurrCd(String reCurrCd) {
		this.reCurrCd = reCurrCd;
	}

	public String getReAproOfcCd() {
		return reAproOfcCd;
	}

	public void setReAproOfcCd(String reAproOfcCd) {
		this.reAproOfcCd = reAproOfcCd;
	}
}
