/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchMovementHistoryVO.java
*@FileTitle : searchMovementHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.17 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchMovementHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchMovementHistoryVO> models = new ArrayList<searchMovementHistoryVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrHngrRckFlg = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String cntrStwgPsnCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchMovementHistoryVO() {}

	public searchMovementHistoryVO(String ibflag, String pagerows, String cnmvCycNo, String cnmvCoCd, String mvmtStsCd, String mvmtCreTpCd, String orgYdCd, String destYdCd, String cnmvEvntDt, String fcntrFlg, String obCntrFlg, String mvmtEdiMsgTpId, String bkgCgoTpCd, String cntrDmgFlg, String cntrHngrRckFlg, String cntrHngrBarAtchKnt, String cntrDispFlg, String imdtExtFlg, String cntrXchCd, String spclCgoFlg, String vndrSeq, String mvmtTrspModCd, String chssNo, String mgstNo, String cntrSealNo, String wblNo, String pkupNo, String updLoclDt, String creLoclDt, String ofcCd, String usrNm, String cnmvRmk, String cntrRfubFlg, String usaEdiCd, String cntrStwgPsnCtnt) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCycNo = cnmvCycNo;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.chssNo = chssNo;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.destYdCd = destYdCd;
		this.fcntrFlg = fcntrFlg;
		this.pagerows = pagerows;
		this.cntrDmgFlg = cntrDmgFlg;
		this.ibflag = ibflag;
		this.cntrXchCd = cntrXchCd;
		this.usrNm = usrNm;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.updLoclDt = updLoclDt;
		this.wblNo = wblNo;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.cntrHngrRckFlg = cntrHngrRckFlg;
		this.obCntrFlg = obCntrFlg;
		this.ofcCd = ofcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.cnmvRmk = cnmvRmk;
		this.creLoclDt = creLoclDt;
		this.vndrSeq = vndrSeq;
		this.cntrDispFlg = cntrDispFlg;
		this.imdtExtFlg = imdtExtFlg;
		this.cntrSealNo = cntrSealNo;
		this.cnmvCoCd = cnmvCoCd;
		this.pkupNo = pkupNo;
		this.cntrRfubFlg = cntrRfubFlg;
		this.usaEdiCd = usaEdiCd;
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;	
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("cntr_stwg_psn_ctnt", getCntrStwgPsnCtnt());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("cntr_stwg_psn_ctnt", "cntrStwgPsnCtnt");
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
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
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
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
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
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
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
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
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
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
	 * @return cntrHngrRckFlg
	 */
	public String getCntrHngrRckFlg() {
		return this.cntrHngrRckFlg;
	}
	
	/**
	 * Column Info
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrDispFlg
	 */
	public String getCntrDispFlg() {
		return this.cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
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
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
	}

	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}

	/**
	 * Column Info
	 * @return cntrStwgPsnCtnt
	 */
	public String getCntrStwgPsnCtnt() {
		return this.cntrStwgPsnCtnt;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
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
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
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
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
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
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
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
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
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
	 * @param cntrHngrRckFlg
	 */
	public void setCntrHngrRckFlg(String cntrHngrRckFlg) {
		this.cntrHngrRckFlg = cntrHngrRckFlg;
	}
	
	/**
	 * Column Info
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrDispFlg
	 */
	public void setCntrDispFlg(String cntrDispFlg) {
		this.cntrDispFlg = cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
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
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
	}	
	
	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgPsnCtnt
	 */
	public void setCntrStwgPsnCtnt(String cntrStwgPsnCtnt) {
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, "mvmt_edi_msg_tp_id", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, "mvmt_trsp_mod_cd", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setFcntrFlg(JSPUtil.getParameter(request, "fcntr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrXchCd(JSPUtil.getParameter(request, "cntr_xch_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, "upd_locl_dt", ""));
		setWblNo(JSPUtil.getParameter(request, "wbl_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, "mvmt_cre_tp_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request, "cntr_hngr_rck_flg", ""));
		setObCntrFlg(JSPUtil.getParameter(request, "ob_cntr_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setCnmvRmk(JSPUtil.getParameter(request, "cnmv_rmk", ""));
		setCreLoclDt(JSPUtil.getParameter(request, "cre_locl_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, "cntr_disp_flg", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, "cnmv_co_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, "cntr_rfub_flg", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, "usa_edi_cd", ""));
		setCntrStwgPsnCtnt(JSPUtil.getParameter(request, "cntr_stwg_psn_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchMovementHistoryVO[]
	 */
	public searchMovementHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchMovementHistoryVO[]
	 */
	public searchMovementHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchMovementHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cntrHngrRckFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_flg", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] cntrStwgPsnCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_psn_ctnt", length));	
			
			for (int i = 0; i < length; i++) {
				model = new searchMovementHistoryVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cntrHngrRckFlg[i] != null)
					model.setCntrHngrRckFlg(cntrHngrRckFlg[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);	
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (cntrStwgPsnCtnt[i] != null)
					model.setCntrStwgPsnCtnt(cntrStwgPsnCtnt[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchMovementHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchMovementHistoryVO[]
	 */
	public searchMovementHistoryVO[] getsearchMovementHistoryVOs(){
		searchMovementHistoryVO[] vos = (searchMovementHistoryVO[])models.toArray(new searchMovementHistoryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg = this.cntrHngrRckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgPsnCtnt = this.cntrStwgPsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
