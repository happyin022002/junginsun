/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMyBiddingDtlVO.java
*@FileTitle : CustomMyBiddingDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.09
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2010.12.10 박명신 
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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMyBiddingDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMyBiddingDtlVO> models = new ArrayList<CustomMyBiddingDtlVO>();
	
	/* Column Info */
	private String rprCostAmt = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String mnrDispDtlRmk = null;
	/* Column Info */
	private String mtrlNm = null;
	/* Column Info */
	private String mkrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String tmpPartUtAmt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String dispUtPrc = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String rcvInvSeq = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String vndrBidKnt = null;
	/* Column Info */
	private String rnk = null;
	/* Column Info */
	private String invStsNm = null;
	/* Column Info */
	private String dispRlseNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrDispCfmStsNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mdlNm = null;
	/* Column Info */
	private String partUtAmt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String dispTrkrNm = null;
	/* Column Info */
	private String dispYdNm = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String eqTpszNm = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String partDispQty = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dispYdCd = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String manuYear = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMyBiddingDtlVO() {}

	public CustomMyBiddingDtlVO(String ibflag, String pagerows, String dispSoldDt, String mtrlNm, String mnrDispDtlRmk, String mkrNm, String mnrPrnrCntCd, String creDt, String dispQty, String mnrPrnrSeq, String tmpPartUtAmt, String eqNo, String partAmt, String dispUtPrc, String invAmt, String rcvInvSeq, String dispRsnCd, String vndrBidKnt, String rnk, String invStsNm, String dispRlseNo, String updUsrId, String mnrDispCfmStsNm, String updDt, String partUtAmt, String mdlNm, String dispNo, String dispTrkrNm, String dispYdNm, String dispDtlSeq, String eqTpszNm, String partDispQty, String eqTpszCd, String invNo, String creUsrId, String dispYdCd, String dispUtTpCd, String fileSeq, String manuYear, String rprCostAmt) {
		this.rprCostAmt = rprCostAmt;
		this.dispSoldDt = dispSoldDt;
		this.mnrDispDtlRmk = mnrDispDtlRmk;
		this.mtrlNm = mtrlNm;
		this.mkrNm = mkrNm;
		this.creDt = creDt;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.dispQty = dispQty;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.tmpPartUtAmt = tmpPartUtAmt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.partAmt = partAmt;
		this.dispUtPrc = dispUtPrc;
		this.invAmt = invAmt;
		this.rcvInvSeq = rcvInvSeq;
		this.dispRsnCd = dispRsnCd;
		this.vndrBidKnt = vndrBidKnt;
		this.rnk = rnk;
		this.invStsNm = invStsNm;
		this.dispRlseNo = dispRlseNo;
		this.updUsrId = updUsrId;
		this.mnrDispCfmStsNm = mnrDispCfmStsNm;
		this.updDt = updDt;
		this.mdlNm = mdlNm;
		this.partUtAmt = partUtAmt;
		this.dispNo = dispNo;
		this.dispTrkrNm = dispTrkrNm;
		this.dispYdNm = dispYdNm;
		this.dispDtlSeq = dispDtlSeq;
		this.eqTpszNm = eqTpszNm;
		this.eqTpszCd = eqTpszCd;
		this.partDispQty = partDispQty;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.dispYdCd = dispYdCd;
		this.dispUtTpCd = dispUtTpCd;
		this.fileSeq = fileSeq;
		this.manuYear = manuYear;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("mnr_disp_dtl_rmk", getMnrDispDtlRmk());
		this.hashColumns.put("mtrl_nm", getMtrlNm());
		this.hashColumns.put("mkr_nm", getMkrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("tmp_part_ut_amt", getTmpPartUtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("vndr_bid_knt", getVndrBidKnt());
		this.hashColumns.put("rnk", getRnk());
		this.hashColumns.put("inv_sts_nm", getInvStsNm());
		this.hashColumns.put("disp_rlse_no", getDispRlseNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_disp_cfm_sts_nm", getMnrDispCfmStsNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mdl_nm", getMdlNm());
		this.hashColumns.put("part_ut_amt", getPartUtAmt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("disp_trkr_nm", getDispTrkrNm());
		this.hashColumns.put("disp_yd_nm", getDispYdNm());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("eq_tpsz_nm", getEqTpszNm());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("part_disp_qty", getPartDispQty());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("manu_year", getManuYear());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("mnr_disp_dtl_rmk", "mnrDispDtlRmk");
		this.hashFields.put("mtrl_nm", "mtrlNm");
		this.hashFields.put("mkr_nm", "mkrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("tmp_part_ut_amt", "tmpPartUtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("vndr_bid_knt", "vndrBidKnt");
		this.hashFields.put("rnk", "rnk");
		this.hashFields.put("inv_sts_nm", "invStsNm");
		this.hashFields.put("disp_rlse_no", "dispRlseNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_disp_cfm_sts_nm", "mnrDispCfmStsNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mdl_nm", "mdlNm");
		this.hashFields.put("part_ut_amt", "partUtAmt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("disp_trkr_nm", "dispTrkrNm");
		this.hashFields.put("disp_yd_nm", "dispYdNm");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("eq_tpsz_nm", "eqTpszNm");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("part_disp_qty", "partDispQty");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("manu_year", "manuYear");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rprCostAmt
	 */
	public String getRprCostAmt() {
		return this.rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @return dispSoldDt
	 */
	public String getDispSoldDt() {
		return this.dispSoldDt;
	}
	
	/**
	 * Column Info
	 * @return mnrDispDtlRmk
	 */
	public String getMnrDispDtlRmk() {
		return this.mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return mtrlNm
	 */
	public String getMtrlNm() {
		return this.mtrlNm;
	}
	
	/**
	 * Column Info
	 * @return mkrNm
	 */
	public String getMkrNm() {
		return this.mkrNm;
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
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return tmpPartUtAmt
	 */
	public String getTmpPartUtAmt() {
		return this.tmpPartUtAmt;
	}
	
	/**
	 * Column Info
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
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
	}
	
	/**
	 * Column Info
	 * @return dispUtPrc
	 */
	public String getDispUtPrc() {
		return this.dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvInvSeq
	 */
	public String getRcvInvSeq() {
		return this.rcvInvSeq;
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
	 * @return vndrBidKnt
	 */
	public String getVndrBidKnt() {
		return this.vndrBidKnt;
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
	 * @return invStsNm
	 */
	public String getInvStsNm() {
		return this.invStsNm;
	}
	
	/**
	 * Column Info
	 * @return dispRlseNo
	 */
	public String getDispRlseNo() {
		return this.dispRlseNo;
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
	 * @return mnrDispCfmStsNm
	 */
	public String getMnrDispCfmStsNm() {
		return this.mnrDispCfmStsNm;
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
	 * @return mdlNm
	 */
	public String getMdlNm() {
		return this.mdlNm;
	}
	
	/**
	 * Column Info
	 * @return partUtAmt
	 */
	public String getPartUtAmt() {
		return this.partUtAmt;
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
	 * @return dispTrkrNm
	 */
	public String getDispTrkrNm() {
		return this.dispTrkrNm;
	}
	
	/**
	 * Column Info
	 * @return dispYdNm
	 */
	public String getDispYdNm() {
		return this.dispYdNm;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszNm
	 */
	public String getEqTpszNm() {
		return this.eqTpszNm;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return partDispQty
	 */
	public String getPartDispQty() {
		return this.partDispQty;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return dispYdCd
	 */
	public String getDispYdCd() {
		return this.dispYdCd;
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
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return manuYear
	 */
	public String getManuYear() {
		return this.manuYear;
	}
	

	/**
	 * Column Info
	 * @param rprCostAmt
	 */
	public void setRprCostAmt(String rprCostAmt) {
		this.rprCostAmt = rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @param dispSoldDt
	 */
	public void setDispSoldDt(String dispSoldDt) {
		this.dispSoldDt = dispSoldDt;
	}
	
	/**
	 * Column Info
	 * @param mnrDispDtlRmk
	 */
	public void setMnrDispDtlRmk(String mnrDispDtlRmk) {
		this.mnrDispDtlRmk = mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param mtrlNm
	 */
	public void setMtrlNm(String mtrlNm) {
		this.mtrlNm = mtrlNm;
	}
	
	/**
	 * Column Info
	 * @param mkrNm
	 */
	public void setMkrNm(String mkrNm) {
		this.mkrNm = mkrNm;
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
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param tmpPartUtAmt
	 */
	public void setTmpPartUtAmt(String tmpPartUtAmt) {
		this.tmpPartUtAmt = tmpPartUtAmt;
	}
	
	/**
	 * Column Info
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
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
	}
	
	/**
	 * Column Info
	 * @param dispUtPrc
	 */
	public void setDispUtPrc(String dispUtPrc) {
		this.dispUtPrc = dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvInvSeq
	 */
	public void setRcvInvSeq(String rcvInvSeq) {
		this.rcvInvSeq = rcvInvSeq;
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
	 * @param vndrBidKnt
	 */
	public void setVndrBidKnt(String vndrBidKnt) {
		this.vndrBidKnt = vndrBidKnt;
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
	 * @param invStsNm
	 */
	public void setInvStsNm(String invStsNm) {
		this.invStsNm = invStsNm;
	}
	
	/**
	 * Column Info
	 * @param dispRlseNo
	 */
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
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
	 * @param mnrDispCfmStsNm
	 */
	public void setMnrDispCfmStsNm(String mnrDispCfmStsNm) {
		this.mnrDispCfmStsNm = mnrDispCfmStsNm;
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
	 * @param mdlNm
	 */
	public void setMdlNm(String mdlNm) {
		this.mdlNm = mdlNm;
	}
	
	/**
	 * Column Info
	 * @param partUtAmt
	 */
	public void setPartUtAmt(String partUtAmt) {
		this.partUtAmt = partUtAmt;
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
	 * @param dispTrkrNm
	 */
	public void setDispTrkrNm(String dispTrkrNm) {
		this.dispTrkrNm = dispTrkrNm;
	}
	
	/**
	 * Column Info
	 * @param dispYdNm
	 */
	public void setDispYdNm(String dispYdNm) {
		this.dispYdNm = dispYdNm;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszNm
	 */
	public void setEqTpszNm(String eqTpszNm) {
		this.eqTpszNm = eqTpszNm;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param partDispQty
	 */
	public void setPartDispQty(String partDispQty) {
		this.partDispQty = partDispQty;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param dispYdCd
	 */
	public void setDispYdCd(String dispYdCd) {
		this.dispYdCd = dispYdCd;
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
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param manuYear
	 */
	public void setManuYear(String manuYear) {
		this.manuYear = manuYear;
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
		setRprCostAmt(JSPUtil.getParameter(request, prefix + "rpr_cost_amt", ""));
		setDispSoldDt(JSPUtil.getParameter(request, prefix + "disp_sold_dt", ""));
		setMnrDispDtlRmk(JSPUtil.getParameter(request, prefix + "mnr_disp_dtl_rmk", ""));
		setMtrlNm(JSPUtil.getParameter(request, prefix + "mtrl_nm", ""));
		setMkrNm(JSPUtil.getParameter(request, prefix + "mkr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setTmpPartUtAmt(JSPUtil.getParameter(request, prefix + "tmp_part_ut_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPartAmt(JSPUtil.getParameter(request, prefix + "part_amt", ""));
		setDispUtPrc(JSPUtil.getParameter(request, prefix + "disp_ut_prc", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setRcvInvSeq(JSPUtil.getParameter(request, prefix + "rcv_inv_seq", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setVndrBidKnt(JSPUtil.getParameter(request, prefix + "vndr_bid_knt", ""));
		setRnk(JSPUtil.getParameter(request, prefix + "rnk", ""));
		setInvStsNm(JSPUtil.getParameter(request, prefix + "inv_sts_nm", ""));
		setDispRlseNo(JSPUtil.getParameter(request, prefix + "disp_rlse_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMnrDispCfmStsNm(JSPUtil.getParameter(request, prefix + "mnr_disp_cfm_sts_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMdlNm(JSPUtil.getParameter(request, prefix + "mdl_nm", ""));
		setPartUtAmt(JSPUtil.getParameter(request, prefix + "part_ut_amt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setDispTrkrNm(JSPUtil.getParameter(request, prefix + "disp_trkr_nm", ""));
		setDispYdNm(JSPUtil.getParameter(request, prefix + "disp_yd_nm", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
		setEqTpszNm(JSPUtil.getParameter(request, prefix + "eq_tpsz_nm", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPartDispQty(JSPUtil.getParameter(request, prefix + "part_disp_qty", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDispYdCd(JSPUtil.getParameter(request, prefix + "disp_yd_cd", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, prefix + "disp_ut_tp_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setManuYear(JSPUtil.getParameter(request, prefix + "manu_year", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMyBiddingDtlVO[]
	 */
	public CustomMyBiddingDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMyBiddingDtlVO[]
	 */
	public CustomMyBiddingDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMyBiddingDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rprCostAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_amt", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] mnrDispDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_dtl_rmk", length));
			String[] mtrlNm = (JSPUtil.getParameter(request, prefix	+ "mtrl_nm", length));
			String[] mkrNm = (JSPUtil.getParameter(request, prefix	+ "mkr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] tmpPartUtAmt = (JSPUtil.getParameter(request, prefix	+ "tmp_part_ut_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] dispUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_ut_prc", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] rcvInvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_inv_seq", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] vndrBidKnt = (JSPUtil.getParameter(request, prefix	+ "vndr_bid_knt", length));
			String[] rnk = (JSPUtil.getParameter(request, prefix	+ "rnk", length));
			String[] invStsNm = (JSPUtil.getParameter(request, prefix	+ "inv_sts_nm", length));
			String[] dispRlseNo = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrDispCfmStsNm = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_cfm_sts_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mdlNm = (JSPUtil.getParameter(request, prefix	+ "mdl_nm", length));
			String[] partUtAmt = (JSPUtil.getParameter(request, prefix	+ "part_ut_amt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] dispTrkrNm = (JSPUtil.getParameter(request, prefix	+ "disp_trkr_nm", length));
			String[] dispYdNm = (JSPUtil.getParameter(request, prefix	+ "disp_yd_nm", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] eqTpszNm = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_nm", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] partDispQty = (JSPUtil.getParameter(request, prefix	+ "part_disp_qty", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] manuYear = (JSPUtil.getParameter(request, prefix	+ "manu_year", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMyBiddingDtlVO();
				if (rprCostAmt[i] != null)
					model.setRprCostAmt(rprCostAmt[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (mnrDispDtlRmk[i] != null)
					model.setMnrDispDtlRmk(mnrDispDtlRmk[i]);
				if (mtrlNm[i] != null)
					model.setMtrlNm(mtrlNm[i]);
				if (mkrNm[i] != null)
					model.setMkrNm(mkrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (tmpPartUtAmt[i] != null)
					model.setTmpPartUtAmt(tmpPartUtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (dispUtPrc[i] != null)
					model.setDispUtPrc(dispUtPrc[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (rcvInvSeq[i] != null)
					model.setRcvInvSeq(rcvInvSeq[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (vndrBidKnt[i] != null)
					model.setVndrBidKnt(vndrBidKnt[i]);
				if (rnk[i] != null)
					model.setRnk(rnk[i]);
				if (invStsNm[i] != null)
					model.setInvStsNm(invStsNm[i]);
				if (dispRlseNo[i] != null)
					model.setDispRlseNo(dispRlseNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrDispCfmStsNm[i] != null)
					model.setMnrDispCfmStsNm(mnrDispCfmStsNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mdlNm[i] != null)
					model.setMdlNm(mdlNm[i]);
				if (partUtAmt[i] != null)
					model.setPartUtAmt(partUtAmt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (dispTrkrNm[i] != null)
					model.setDispTrkrNm(dispTrkrNm[i]);
				if (dispYdNm[i] != null)
					model.setDispYdNm(dispYdNm[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (eqTpszNm[i] != null)
					model.setEqTpszNm(eqTpszNm[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (partDispQty[i] != null)
					model.setPartDispQty(partDispQty[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (manuYear[i] != null)
					model.setManuYear(manuYear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMyBiddingDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMyBiddingDtlVO[]
	 */
	public CustomMyBiddingDtlVO[] getCustomMyBiddingDtlVOs(){
		CustomMyBiddingDtlVO[] vos = (CustomMyBiddingDtlVO[])models.toArray(new CustomMyBiddingDtlVO[models.size()]);
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
		this.rprCostAmt = this.rprCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispDtlRmk = this.mnrDispDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlNm = this.mtrlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrNm = this.mkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpPartUtAmt = this.tmpPartUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc = this.dispUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq = this.rcvInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrBidKnt = this.vndrBidKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk = this.rnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsNm = this.invStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNo = this.dispRlseNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispCfmStsNm = this.mnrDispCfmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlNm = this.mdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partUtAmt = this.partUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrkrNm = this.dispTrkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdNm = this.dispYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszNm = this.eqTpszNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partDispQty = this.partDispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuYear = this.manuYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
