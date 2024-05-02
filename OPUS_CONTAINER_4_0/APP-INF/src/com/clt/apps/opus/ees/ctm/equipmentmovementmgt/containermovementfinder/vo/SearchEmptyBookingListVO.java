/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEmptyBookingListVO.java
*@FileTitle : SearchEmptyBookingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.06 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEmptyBookingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEmptyBookingListVO> models = new ArrayList<SearchEmptyBookingListVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String cntrSvrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyRepoVlRmk = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String lstFlg = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String cntrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String inpYdCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String kindFlg = null;
	/* Column Info */
	private String kindNm = null;
	/* Column Info */
	private String rccCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEmptyBookingListVO() {}

	public SearchEmptyBookingListVO(String ibflag, String pagerows, String bkgCgoTpCd, String bkgPodCd, String callSgnNo, String chssNo, String cnmvCoCd, String cnmvEvntDt, String cnmvIdNo, String cnmvSeq, String cnmvSplitNo, String cnmvYr, String cntrId, String cntrNo, String cntrSvrId, String cntrTpszCd, String cntrXchCd, String destYdCd, String inpYdCd, String lccCd, String lloydNo, String lstFlg, String mgstNo, String mtyRepoVlRmk, String mvmtCreTpCd, String mvmtEdiMsgTpId, String mvmtStsCd, String orgYdCd, String pDate1, String pDate2, String pYard1, String pYard2, String pkupNo, String vvdCd, String wblNo, String kindFlg, String kindNm, String rccCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.cnmvSeq = cnmvSeq;
		this.chssNo = chssNo;
		this.destYdCd = destYdCd;
		this.cntrSvrId = cntrSvrId;
		this.pagerows = pagerows;
		this.mtyRepoVlRmk = mtyRepoVlRmk;
		this.cnmvSplitNo = cnmvSplitNo;
		this.pDate1 = pDate1;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cntrXchCd = cntrXchCd;
		this.lstFlg = lstFlg;
		this.pDate2 = pDate2;
		this.cntrId = cntrId;
		this.cntrTpszCd = cntrTpszCd;
		this.inpYdCd = inpYdCd;
		this.callSgnNo = callSgnNo;
		this.wblNo = wblNo;
		this.cnmvEvntDt = cnmvEvntDt;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.cnmvIdNo = cnmvIdNo;
		this.lccCd = lccCd;
		this.mvmtStsCd = mvmtStsCd;
		this.lloydNo = lloydNo;
		this.pYard2 = pYard2;
		this.cntrNo = cntrNo;
		this.pYard1 = pYard1;
		this.cnmvYr = cnmvYr;
		this.cnmvCoCd = cnmvCoCd;
		this.pkupNo = pkupNo;
		this.kindFlg = kindFlg;
		this.kindNm = kindNm;
		this.rccCd = rccCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_repo_vl_rmk", getMtyRepoVlRmk());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("lst_flg", getLstFlg());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cntr_id", getCntrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("inp_yd_cd", getInpYdCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("kind_flg", getKindFlg());
		this.hashColumns.put("kind_nm", getKindNm());
		this.hashColumns.put("rcc_cd", getRccCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_repo_vl_rmk", "mtyRepoVlRmk");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("lst_flg", "lstFlg");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("inp_yd_cd", "inpYdCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("kind_flg", "kindFlg");
		this.hashFields.put("kind_nm", "kindNm");
		this.hashFields.put("rcc_cd", "rccCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSvrId
	 */
	public String getCntrSvrId() {
		return this.cntrSvrId;
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
	 * @return mtyRepoVlRmk
	 */
	public String getMtyRepoVlRmk() {
		return this.mtyRepoVlRmk;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @return lstFlg
	 */
	public String getLstFlg() {
		return this.lstFlg;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return cntrId
	 */
	public String getCntrId() {
		return this.cntrId;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return inpYdCd
	 */
	public String getInpYdCd() {
		return this.inpYdCd;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSvrId
	 */
	public void setCntrSvrId(String cntrSvrId) {
		this.cntrSvrId = cntrSvrId;
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
	 * @param mtyRepoVlRmk
	 */
	public void setMtyRepoVlRmk(String mtyRepoVlRmk) {
		this.mtyRepoVlRmk = mtyRepoVlRmk;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @param lstFlg
	 */
	public void setLstFlg(String lstFlg) {
		this.lstFlg = lstFlg;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param cntrId
	 */
	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param inpYdCd
	 */
	public void setInpYdCd(String inpYdCd) {
		this.inpYdCd = inpYdCd;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @return kindFlg
	 */
	public String getKindFlg() {
		return this.kindFlg;
	}
	

	/**
	 * Column Info
	 * @param kindFlg
	 */
	public void setKindFlg(String kindFlg) {
		this.kindFlg = kindFlg;
	}
	
	/**
	 * Column Info
	 * @return kindNm
	 */
	public String getKindNm() {
		return this.kindNm;
	}
		
	/**
	 * Column Info
	 * @param kindNm
	 */
	public void setKindNm(String kindNm) {
		this.kindNm = kindNm;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setCntrSvrId(JSPUtil.getParameter(request, prefix + "cntr_svr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMtyRepoVlRmk(JSPUtil.getParameter(request, prefix + "mty_repo_vl_rmk", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request, prefix + "cntr_xch_cd", ""));
		setLstFlg(JSPUtil.getParameter(request, prefix + "lst_flg", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setCntrId(JSPUtil.getParameter(request, prefix + "cntr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setInpYdCd(JSPUtil.getParameter(request, prefix + "inp_yd_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setKindFlg(JSPUtil.getParameter(request, prefix + "kind_flg", ""));
		setKindNm(JSPUtil.getParameter(request, prefix + "kind_nm", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEmptyBookingListVO[]
	 */
	public SearchEmptyBookingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEmptyBookingListVO[]
	 */
	public SearchEmptyBookingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEmptyBookingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] cntrSvrId = (JSPUtil.getParameter(request, prefix	+ "cntr_svr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyRepoVlRmk = (JSPUtil.getParameter(request, prefix	+ "mty_repo_vl_rmk", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] lstFlg = (JSPUtil.getParameter(request, prefix	+ "lst_flg", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] cntrId = (JSPUtil.getParameter(request, prefix	+ "cntr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] inpYdCd = (JSPUtil.getParameter(request, prefix	+ "inp_yd_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] kindFlg = (JSPUtil.getParameter(request, prefix	+ "kind_flg", length));
			String[] kindNm = (JSPUtil.getParameter(request, prefix	+ "kind_nm", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEmptyBookingListVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (cntrSvrId[i] != null)
					model.setCntrSvrId(cntrSvrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyRepoVlRmk[i] != null)
					model.setMtyRepoVlRmk(mtyRepoVlRmk[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (lstFlg[i] != null)
					model.setLstFlg(lstFlg[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (cntrId[i] != null)
					model.setCntrId(cntrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (inpYdCd[i] != null)
					model.setInpYdCd(inpYdCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (kindFlg[i] != null)
					model.setKindFlg(kindFlg[i]);
				if (kindNm[i] != null)
					model.setKindNm(kindNm[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEmptyBookingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEmptyBookingListVO[]
	 */
	public SearchEmptyBookingListVO[] getSearchEmptyBookingListVOs(){
		SearchEmptyBookingListVO[] vos = (SearchEmptyBookingListVO[])models.toArray(new SearchEmptyBookingListVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId = this.cntrSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoVlRmk = this.mtyRepoVlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFlg = this.lstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId = this.cntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYdCd = this.inpYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindFlg = this.kindFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindNm = this.kindNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
