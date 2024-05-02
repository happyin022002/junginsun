/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByEQListVO.java
*@FileTitle : DisposalPFMCByEQListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.02.18 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByEQListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPFMCByEQListVO> models = new ArrayList<DisposalPFMCByEQListVO>();
	
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String soldYd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String buyerCd = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String lcc = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String dispPkupEndDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String dispBultnDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dispSts = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String soldDt = null;
	/* Column Info */
	private String rnk = null;
	/* Column Info */
	private String buyerNm = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String dispPkupStDt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String dspVrfyTpCd = null;
	/* Column Info */
	private String dispStsCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dispEmlFlg = null;
	/* Column Info */
	private String mnfrDt = null;
	/* Column Info */
	private String scc = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String dispStDt = null;
	/* Column Info */
	private String dispStPrc = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String dispEndDt = null;
	/* Column Info */
	private String rcc = null;
	/* Column Info */
	private String eqTy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalPFMCByEQListVO() {}

	public DisposalPFMCByEQListVO(String ibflag, String pagerows, String dispTpCd, String soldYd, String currCd, String dispNo, String ts, String buyerCd, String dspVrfyTpCd, String lcc, String aproOfcCd, String mnfrDt, String scc, String amt, String eqNo, String dispSts, String rqstOfcCd, String dispRsnCd, String soldDt, String rnk, String rcc, String eqTy, String buyerNm, String dispBultnDt, String dispEmlFlg, String dispEndDt, String dispPkupEndDt, String dispPkupStDt, String dispQty, String dispStDt, String dispStPrc, String eqKndCd, String fileSeq, String rqstDt, String rqstUsrId, String dispStsCd) {
		this.rqstUsrId = rqstUsrId;
		this.soldYd = soldYd;
		this.currCd = currCd;
		this.buyerCd = buyerCd;
		this.ts = ts;
		this.lcc = lcc;
		this.dispQty = dispQty;
		this.dispPkupEndDt = dispPkupEndDt;
		this.aproOfcCd = aproOfcCd;
		this.dispBultnDt = dispBultnDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.dispSts = dispSts;
		this.dispRsnCd = dispRsnCd;
		this.soldDt = soldDt;
		this.rnk = rnk;
		this.buyerNm = buyerNm;
		this.rqstDt = rqstDt;
		this.dispTpCd = dispTpCd;
		this.dispPkupStDt = dispPkupStDt;
		this.dispNo = dispNo;
		this.dspVrfyTpCd = dspVrfyTpCd;
		this.dispStsCd = dispStsCd;
		this.eqKndCd = eqKndCd;
		this.dispEmlFlg = dispEmlFlg;
		this.mnfrDt = mnfrDt;
		this.scc = scc;
		this.amt = amt;
		this.dispStDt = dispStDt;
		this.dispStPrc = dispStPrc;
		this.rqstOfcCd = rqstOfcCd;
		this.fileSeq = fileSeq;
		this.dispEndDt = dispEndDt;
		this.rcc = rcc;
		this.eqTy = eqTy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("sold_yd", getSoldYd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("buyer_cd", getBuyerCd());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("lcc", getLcc());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("disp_pkup_end_dt", getDispPkupEndDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("disp_bultn_dt", getDispBultnDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("disp_sts", getDispSts());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("sold_dt", getSoldDt());
		this.hashColumns.put("rnk", getRnk());
		this.hashColumns.put("buyer_nm", getBuyerNm());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("disp_pkup_st_dt", getDispPkupStDt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("dsp_vrfy_tp_cd", getDspVrfyTpCd());
		this.hashColumns.put("disp_sts_cd", getDispStsCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_eml_flg", getDispEmlFlg());
		this.hashColumns.put("mnfr_dt", getMnfrDt());
		this.hashColumns.put("scc", getScc());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("disp_st_dt", getDispStDt());
		this.hashColumns.put("disp_st_prc", getDispStPrc());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("disp_end_dt", getDispEndDt());
		this.hashColumns.put("rcc", getRcc());
		this.hashColumns.put("eq_ty", getEqTy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("sold_yd", "soldYd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("buyer_cd", "buyerCd");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("lcc", "lcc");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("disp_pkup_end_dt", "dispPkupEndDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("disp_bultn_dt", "dispBultnDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("disp_sts", "dispSts");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("sold_dt", "soldDt");
		this.hashFields.put("rnk", "rnk");
		this.hashFields.put("buyer_nm", "buyerNm");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("disp_pkup_st_dt", "dispPkupStDt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("dsp_vrfy_tp_cd", "dspVrfyTpCd");
		this.hashFields.put("disp_sts_cd", "dispStsCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_eml_flg", "dispEmlFlg");
		this.hashFields.put("mnfr_dt", "mnfrDt");
		this.hashFields.put("scc", "scc");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("disp_st_dt", "dispStDt");
		this.hashFields.put("disp_st_prc", "dispStPrc");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("disp_end_dt", "dispEndDt");
		this.hashFields.put("rcc", "rcc");
		this.hashFields.put("eq_ty", "eqTy");
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
	 * @return soldYd
	 */
	public String getSoldYd() {
		return this.soldYd;
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
	 * @return buyerCd
	 */
	public String getBuyerCd() {
		return this.buyerCd;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return lcc
	 */
	public String getLcc() {
		return this.lcc;
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
	 * @return dispPkupEndDt
	 */
	public String getDispPkupEndDt() {
		return this.dispPkupEndDt;
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
	 * @return dispBultnDt
	 */
	public String getDispBultnDt() {
		return this.dispBultnDt;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return dispSts
	 */
	public String getDispSts() {
		return this.dispSts;
	}
	
	/**
	 * Column Info
	 * @return dispRsnCd
	 */
	public String getDispRsnCd() {
		return this.dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @return soldDt
	 */
	public String getSoldDt() {
		return this.soldDt;
	}
	
	/**
	 * Column Info
	 * @return rnk
	 */
	public String getRnk() {
		return this.rnk;
	}
	
	/**
	 * Column Info
	 * @return buyerNm
	 */
	public String getBuyerNm() {
		return this.buyerNm;
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
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
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
	 * @return dspVrfyTpCd
	 */
	public String getDspVrfyTpCd() {
		return this.dspVrfyTpCd;
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
	 * @return mnfrDt
	 */
	public String getMnfrDt() {
		return this.mnfrDt;
	}
	
	/**
	 * Column Info
	 * @return scc
	 */
	public String getScc() {
		return this.scc;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * @return dispStPrc
	 */
	public String getDispStPrc() {
		return this.dispStPrc;
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
	 * @return rcc
	 */
	public String getRcc() {
		return this.rcc;
	}
	
	/**
	 * Column Info
	 * @return eqTy
	 */
	public String getEqTy() {
		return this.eqTy;
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
	 * @param soldYd
	 */
	public void setSoldYd(String soldYd) {
		this.soldYd = soldYd;
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
	 * @param buyerCd
	 */
	public void setBuyerCd(String buyerCd) {
		this.buyerCd = buyerCd;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param lcc
	 */
	public void setLcc(String lcc) {
		this.lcc = lcc;
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
	 * @param dispPkupEndDt
	 */
	public void setDispPkupEndDt(String dispPkupEndDt) {
		this.dispPkupEndDt = dispPkupEndDt;
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
	 * @param dispBultnDt
	 */
	public void setDispBultnDt(String dispBultnDt) {
		this.dispBultnDt = dispBultnDt;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param dispSts
	 */
	public void setDispSts(String dispSts) {
		this.dispSts = dispSts;
	}
	
	/**
	 * Column Info
	 * @param dispRsnCd
	 */
	public void setDispRsnCd(String dispRsnCd) {
		this.dispRsnCd = dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @param soldDt
	 */
	public void setSoldDt(String soldDt) {
		this.soldDt = soldDt;
	}
	
	/**
	 * Column Info
	 * @param rnk
	 */
	public void setRnk(String rnk) {
		this.rnk = rnk;
	}
	
	/**
	 * Column Info
	 * @param buyerNm
	 */
	public void setBuyerNm(String buyerNm) {
		this.buyerNm = buyerNm;
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
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
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
	 * @param dspVrfyTpCd
	 */
	public void setDspVrfyTpCd(String dspVrfyTpCd) {
		this.dspVrfyTpCd = dspVrfyTpCd;
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
	 * @param mnfrDt
	 */
	public void setMnfrDt(String mnfrDt) {
		this.mnfrDt = mnfrDt;
	}
	
	/**
	 * Column Info
	 * @param scc
	 */
	public void setScc(String scc) {
		this.scc = scc;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * @param dispStPrc
	 */
	public void setDispStPrc(String dispStPrc) {
		this.dispStPrc = dispStPrc;
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
	 * Column Info
	 * @param rcc
	 */
	public void setRcc(String rcc) {
		this.rcc = rcc;
	}
	
	/**
	 * Column Info
	 * @param eqTy
	 */
	public void setEqTy(String eqTy) {
		this.eqTy = eqTy;
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
		setSoldYd(JSPUtil.getParameter(request, prefix + "sold_yd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBuyerCd(JSPUtil.getParameter(request, prefix + "buyer_cd", ""));
		setTs(JSPUtil.getParameter(request, prefix + "ts", ""));
		setLcc(JSPUtil.getParameter(request, prefix + "lcc", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setDispPkupEndDt(JSPUtil.getParameter(request, prefix + "disp_pkup_end_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setDispBultnDt(JSPUtil.getParameter(request, prefix + "disp_bultn_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDispSts(JSPUtil.getParameter(request, prefix + "disp_sts", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setSoldDt(JSPUtil.getParameter(request, prefix + "sold_dt", ""));
		setRnk(JSPUtil.getParameter(request, prefix + "rnk", ""));
		setBuyerNm(JSPUtil.getParameter(request, prefix + "buyer_nm", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setDispPkupStDt(JSPUtil.getParameter(request, prefix + "disp_pkup_st_dt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setDspVrfyTpCd(JSPUtil.getParameter(request, prefix + "dsp_vrfy_tp_cd", ""));
		setDispStsCd(JSPUtil.getParameter(request, prefix + "disp_sts_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setDispEmlFlg(JSPUtil.getParameter(request, prefix + "disp_eml_flg", ""));
		setMnfrDt(JSPUtil.getParameter(request, prefix + "mnfr_dt", ""));
		setScc(JSPUtil.getParameter(request, prefix + "scc", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setDispStDt(JSPUtil.getParameter(request, prefix + "disp_st_dt", ""));
		setDispStPrc(JSPUtil.getParameter(request, prefix + "disp_st_prc", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setDispEndDt(JSPUtil.getParameter(request, prefix + "disp_end_dt", ""));
		setRcc(JSPUtil.getParameter(request, prefix + "rcc", ""));
		setEqTy(JSPUtil.getParameter(request, prefix + "eq_ty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByEQListVO[]
	 */
	public DisposalPFMCByEQListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByEQListVO[]
	 */
	public DisposalPFMCByEQListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByEQListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] soldYd = (JSPUtil.getParameter(request, prefix	+ "sold_yd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] buyerCd = (JSPUtil.getParameter(request, prefix	+ "buyer_cd", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] lcc = (JSPUtil.getParameter(request, prefix	+ "lcc", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] dispPkupEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_end_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] dispBultnDt = (JSPUtil.getParameter(request, prefix	+ "disp_bultn_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dispSts = (JSPUtil.getParameter(request, prefix	+ "disp_sts", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] soldDt = (JSPUtil.getParameter(request, prefix	+ "sold_dt", length));
			String[] rnk = (JSPUtil.getParameter(request, prefix	+ "rnk", length));
			String[] buyerNm = (JSPUtil.getParameter(request, prefix	+ "buyer_nm", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] dispPkupStDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_st_dt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] dspVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "dsp_vrfy_tp_cd", length));
			String[] dispStsCd = (JSPUtil.getParameter(request, prefix	+ "disp_sts_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispEmlFlg = (JSPUtil.getParameter(request, prefix	+ "disp_eml_flg", length));
			String[] mnfrDt = (JSPUtil.getParameter(request, prefix	+ "mnfr_dt", length));
			String[] scc = (JSPUtil.getParameter(request, prefix	+ "scc", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] dispStDt = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt", length));
			String[] dispStPrc = (JSPUtil.getParameter(request, prefix	+ "disp_st_prc", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] dispEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_end_dt", length));
			String[] rcc = (JSPUtil.getParameter(request, prefix	+ "rcc", length));
			String[] eqTy = (JSPUtil.getParameter(request, prefix	+ "eq_ty", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByEQListVO();
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (soldYd[i] != null)
					model.setSoldYd(soldYd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (buyerCd[i] != null)
					model.setBuyerCd(buyerCd[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (lcc[i] != null)
					model.setLcc(lcc[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (dispPkupEndDt[i] != null)
					model.setDispPkupEndDt(dispPkupEndDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (dispBultnDt[i] != null)
					model.setDispBultnDt(dispBultnDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dispSts[i] != null)
					model.setDispSts(dispSts[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (soldDt[i] != null)
					model.setSoldDt(soldDt[i]);
				if (rnk[i] != null)
					model.setRnk(rnk[i]);
				if (buyerNm[i] != null)
					model.setBuyerNm(buyerNm[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (dispPkupStDt[i] != null)
					model.setDispPkupStDt(dispPkupStDt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (dspVrfyTpCd[i] != null)
					model.setDspVrfyTpCd(dspVrfyTpCd[i]);
				if (dispStsCd[i] != null)
					model.setDispStsCd(dispStsCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dispEmlFlg[i] != null)
					model.setDispEmlFlg(dispEmlFlg[i]);
				if (mnfrDt[i] != null)
					model.setMnfrDt(mnfrDt[i]);
				if (scc[i] != null)
					model.setScc(scc[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (dispStDt[i] != null)
					model.setDispStDt(dispStDt[i]);
				if (dispStPrc[i] != null)
					model.setDispStPrc(dispStPrc[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (dispEndDt[i] != null)
					model.setDispEndDt(dispEndDt[i]);
				if (rcc[i] != null)
					model.setRcc(rcc[i]);
				if (eqTy[i] != null)
					model.setEqTy(eqTy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByEQListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByEQListVO[]
	 */
	public DisposalPFMCByEQListVO[] getDisposalPFMCByEQListVOs(){
		DisposalPFMCByEQListVO[] vos = (DisposalPFMCByEQListVO[])models.toArray(new DisposalPFMCByEQListVO[models.size()]);
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
		this.soldYd = this.soldYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCd = this.buyerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcc = this.lcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupEndDt = this.dispPkupEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispBultnDt = this.dispBultnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSts = this.dispSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soldDt = this.soldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk = this.rnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerNm = this.buyerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupStDt = this.dispPkupStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspVrfyTpCd = this.dspVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsCd = this.dispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEmlFlg = this.dispEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnfrDt = this.mnfrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc = this.scc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDt = this.dispStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStPrc = this.dispStPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEndDt = this.dispEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc = this.rcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTy = this.eqTy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
