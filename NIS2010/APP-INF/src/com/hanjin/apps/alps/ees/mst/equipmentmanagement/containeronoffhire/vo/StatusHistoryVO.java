/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusHistoryVO.java
*@FileTitle : StatusHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.06 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StatusHistoryVO> models = new ArrayList<StatusHistoryVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String cntrDirItchgFeeAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String cntrMinOnhDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrDrffCrAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrPkupChgAmt = null;
	/* Column Info */
	private String cntrLftChgAmt = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String delFlg = null;
	/* Column Info */
	private String cntrPkupCrChgAmt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String cntrStsRmk = null;
	/* Column Info */
	private String cntrStsSeq = null;
	/* Column Info */
	private String cntrDrffAmt = null;
	/* Column Info */
	private String cntrLstmCngFlg = null;
	/* Column Info */
	private String cntrStsEvntDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mstDelFlg = null;
	/* Column Info */
	private String chkDgt = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dirItchgVndrSeq = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String cntrOldVanFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String timeLocal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StatusHistoryVO() {}

	public StatusHistoryVO(String ibflag, String pagerows, String gubun, String currCd, String cntrStsCd, String cntrDirItchgFeeAmt, String vndrLglEngNm, String creDt, String cntrMinOnhDys, String cntrDrffCrAmt, String cntrLftChgAmt, String cntrPkupChgAmt, String agmtCtyCd, String delFlg, String cntrPkupCrChgAmt, String lstmCd, String updUsrId, String updDt, String rntlChgFreeDys, String cntrStsRmk, String cntrStsSeq, String cntrDrffAmt, String cntrLstmCngFlg, String cntrStsEvntDt, String agmtSeq, String agmtNo, String cnmvIdNo, String ofcCd, String mvmtStsCd, String chkDgt, String ydCd, String dirItchgVndrSeq, String cntrNo, String vndrSeq, String cntrOldVanFlg, String refNo, String cnmvYr, String timeLocal, String mstDelFlg) {
		this.currCd = currCd;
		this.gubun = gubun;
		this.cntrStsCd = cntrStsCd;
		this.cntrDirItchgFeeAmt = cntrDirItchgFeeAmt;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.cntrMinOnhDys = cntrMinOnhDys;
		this.pagerows = pagerows;
		this.cntrDrffCrAmt = cntrDrffCrAmt;
		this.ibflag = ibflag;
		this.cntrPkupChgAmt = cntrPkupChgAmt;
		this.cntrLftChgAmt = cntrLftChgAmt;
		this.agmtCtyCd = agmtCtyCd;
		this.delFlg = delFlg;
		this.cntrPkupCrChgAmt = cntrPkupCrChgAmt;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.cntrStsRmk = cntrStsRmk;
		this.cntrStsSeq = cntrStsSeq;
		this.cntrDrffAmt = cntrDrffAmt;
		this.cntrLstmCngFlg = cntrLstmCngFlg;
		this.cntrStsEvntDt = cntrStsEvntDt;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.cnmvIdNo = cnmvIdNo;
		this.ofcCd = ofcCd;
		this.mstDelFlg = mstDelFlg;
		this.chkDgt = chkDgt;
		this.mvmtStsCd = mvmtStsCd;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.dirItchgVndrSeq = dirItchgVndrSeq;
		this.refNo = refNo;
		this.cntrOldVanFlg = cntrOldVanFlg;
		this.cnmvYr = cnmvYr;
		this.timeLocal = timeLocal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("cntr_dir_itchg_fee_amt", getCntrDirItchgFeeAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cntr_min_onh_dys", getCntrMinOnhDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_drff_cr_amt", getCntrDrffCrAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_pkup_chg_amt", getCntrPkupChgAmt());
		this.hashColumns.put("cntr_lft_chg_amt", getCntrLftChgAmt());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("del_flg", getDelFlg());
		this.hashColumns.put("cntr_pkup_cr_chg_amt", getCntrPkupCrChgAmt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("cntr_sts_rmk", getCntrStsRmk());
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());
		this.hashColumns.put("cntr_drff_amt", getCntrDrffAmt());
		this.hashColumns.put("cntr_lstm_cng_flg", getCntrLstmCngFlg());
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mst_del_flg", getMstDelFlg());
		this.hashColumns.put("chk_dgt", getChkDgt());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dir_itchg_vndr_seq", getDirItchgVndrSeq());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cntr_old_van_flg", getCntrOldVanFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("time_local", getTimeLocal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cntr_dir_itchg_fee_amt", "cntrDirItchgFeeAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cntr_min_onh_dys", "cntrMinOnhDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_drff_cr_amt", "cntrDrffCrAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_pkup_chg_amt", "cntrPkupChgAmt");
		this.hashFields.put("cntr_lft_chg_amt", "cntrLftChgAmt");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("del_flg", "delFlg");
		this.hashFields.put("cntr_pkup_cr_chg_amt", "cntrPkupCrChgAmt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("cntr_sts_rmk", "cntrStsRmk");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("cntr_drff_amt", "cntrDrffAmt");
		this.hashFields.put("cntr_lstm_cng_flg", "cntrLstmCngFlg");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mst_del_flg", "mstDelFlg");
		this.hashFields.put("chk_dgt", "chkDgt");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dir_itchg_vndr_seq", "dirItchgVndrSeq");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cntr_old_van_flg", "cntrOldVanFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("time_local", "timeLocal");
		return this.hashFields;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrDirItchgFeeAmt
	 */
	public String getCntrDirItchgFeeAmt() {
		return this.cntrDirItchgFeeAmt;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return cntrMinOnhDys
	 */
	public String getCntrMinOnhDys() {
		return this.cntrMinOnhDys;
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
	 * @return cntrDrffCrAmt
	 */
	public String getCntrDrffCrAmt() {
		return this.cntrDrffCrAmt;
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
	 * @return cntrPkupChgAmt
	 */
	public String getCntrPkupChgAmt() {
		return this.cntrPkupChgAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrLftChgAmt
	 */
	public String getCntrLftChgAmt() {
		return this.cntrLftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return delFlg
	 */
	public String getDelFlg() {
		return this.delFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupCrChgAmt
	 */
	public String getCntrPkupCrChgAmt() {
		return this.cntrPkupCrChgAmt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rntlChgFreeDys
	 */
	public String getRntlChgFreeDys() {
		return this.rntlChgFreeDys;
	}
	
	/**
	 * Column Info
	 * @return cntrStsRmk
	 */
	public String getCntrStsRmk() {
		return this.cntrStsRmk;
	}
	
	/**
	 * Column Info
	 * @return cntrStsSeq
	 */
	public String getCntrStsSeq() {
		return this.cntrStsSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrDrffAmt
	 */
	public String getCntrDrffAmt() {
		return this.cntrDrffAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrLstmCngFlg
	 */
	public String getCntrLstmCngFlg() {
		return this.cntrLstmCngFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrStsEvntDt
	 */
	public String getCntrStsEvntDt() {
		return this.cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return mstDelFlg
	 */
	public String getMstDelFlg() {
		return this.mstDelFlg;
	}
	
	/**
	 * Column Info
	 * @return chkDgt
	 */
	public String getChkDgt() {
		return this.chkDgt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return dirItchgVndrSeq
	 */
	public String getDirItchgVndrSeq() {
		return this.dirItchgVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return cntrOldVanFlg
	 */
	public String getCntrOldVanFlg() {
		return this.cntrOldVanFlg;
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
	 * @return timeLocal
	 */
	public String getTimeLocal() {
		return this.timeLocal;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrDirItchgFeeAmt
	 */
	public void setCntrDirItchgFeeAmt(String cntrDirItchgFeeAmt) {
		this.cntrDirItchgFeeAmt = cntrDirItchgFeeAmt;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param cntrMinOnhDys
	 */
	public void setCntrMinOnhDys(String cntrMinOnhDys) {
		this.cntrMinOnhDys = cntrMinOnhDys;
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
	 * @param cntrDrffCrAmt
	 */
	public void setCntrDrffCrAmt(String cntrDrffCrAmt) {
		this.cntrDrffCrAmt = cntrDrffCrAmt;
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
	 * @param cntrPkupChgAmt
	 */
	public void setCntrPkupChgAmt(String cntrPkupChgAmt) {
		this.cntrPkupChgAmt = cntrPkupChgAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrLftChgAmt
	 */
	public void setCntrLftChgAmt(String cntrLftChgAmt) {
		this.cntrLftChgAmt = cntrLftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupCrChgAmt
	 */
	public void setCntrPkupCrChgAmt(String cntrPkupCrChgAmt) {
		this.cntrPkupCrChgAmt = cntrPkupCrChgAmt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rntlChgFreeDys
	 */
	public void setRntlChgFreeDys(String rntlChgFreeDys) {
		this.rntlChgFreeDys = rntlChgFreeDys;
	}
	
	/**
	 * Column Info
	 * @param cntrStsRmk
	 */
	public void setCntrStsRmk(String cntrStsRmk) {
		this.cntrStsRmk = cntrStsRmk;
	}
	
	/**
	 * Column Info
	 * @param cntrStsSeq
	 */
	public void setCntrStsSeq(String cntrStsSeq) {
		this.cntrStsSeq = cntrStsSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrDrffAmt
	 */
	public void setCntrDrffAmt(String cntrDrffAmt) {
		this.cntrDrffAmt = cntrDrffAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrLstmCngFlg
	 */
	public void setCntrLstmCngFlg(String cntrLstmCngFlg) {
		this.cntrLstmCngFlg = cntrLstmCngFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrStsEvntDt
	 */
	public void setCntrStsEvntDt(String cntrStsEvntDt) {
		this.cntrStsEvntDt = cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param mstDelFlg
	 */
	public void setMstDelFlg(String mstDelFlg) {
		this.mstDelFlg = mstDelFlg;
	}
	
	/**
	 * Column Info
	 * @param chkDgt
	 */
	public void setChkDgt(String chkDgt) {
		this.chkDgt = chkDgt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param dirItchgVndrSeq
	 */
	public void setDirItchgVndrSeq(String dirItchgVndrSeq) {
		this.dirItchgVndrSeq = dirItchgVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param cntrOldVanFlg
	 */
	public void setCntrOldVanFlg(String cntrOldVanFlg) {
		this.cntrOldVanFlg = cntrOldVanFlg;
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
	 * @param timeLocal
	 */
	public void setTimeLocal(String timeLocal) {
		this.timeLocal = timeLocal;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setCntrDirItchgFeeAmt(JSPUtil.getParameter(request, prefix + "cntr_dir_itchg_fee_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCntrMinOnhDys(JSPUtil.getParameter(request, prefix + "cntr_min_onh_dys", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrDrffCrAmt(JSPUtil.getParameter(request, prefix + "cntr_drff_cr_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrPkupChgAmt(JSPUtil.getParameter(request, prefix + "cntr_pkup_chg_amt", ""));
		setCntrLftChgAmt(JSPUtil.getParameter(request, prefix + "cntr_lft_chg_amt", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setDelFlg(JSPUtil.getParameter(request, prefix + "del_flg", ""));
		setCntrPkupCrChgAmt(JSPUtil.getParameter(request, prefix + "cntr_pkup_cr_chg_amt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request, prefix + "rntl_chg_free_dys", ""));
		setCntrStsRmk(JSPUtil.getParameter(request, prefix + "cntr_sts_rmk", ""));
		setCntrStsSeq(JSPUtil.getParameter(request, prefix + "cntr_sts_seq", ""));
		setCntrDrffAmt(JSPUtil.getParameter(request, prefix + "cntr_drff_amt", ""));
		setCntrLstmCngFlg(JSPUtil.getParameter(request, prefix + "cntr_lstm_cng_flg", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request, prefix + "cntr_sts_evnt_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMstDelFlg(JSPUtil.getParameter(request, prefix + "mst_del_flg", ""));
		setChkDgt(JSPUtil.getParameter(request, prefix + "chk_dgt", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDirItchgVndrSeq(JSPUtil.getParameter(request, prefix + "dir_itchg_vndr_seq", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setCntrOldVanFlg(JSPUtil.getParameter(request, prefix + "cntr_old_van_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setTimeLocal(JSPUtil.getParameter(request, prefix + "time_local", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusHistoryVO[]
	 */
	public StatusHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusHistoryVO[]
	 */
	public StatusHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StatusHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] cntrDirItchgFeeAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_dir_itchg_fee_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] cntrMinOnhDys = (JSPUtil.getParameter(request, prefix	+ "cntr_min_onh_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrDrffCrAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_drff_cr_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrPkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_chg_amt", length));
			String[] cntrLftChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_lft_chg_amt", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] delFlg = (JSPUtil.getParameter(request, prefix	+ "del_flg", length));
			String[] cntrPkupCrChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_cr_chg_amt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] cntrStsRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_rmk", length));
			String[] cntrStsSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_seq", length));
			String[] cntrDrffAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_drff_amt", length));
			String[] cntrLstmCngFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_lstm_cng_flg", length));
			String[] cntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_evnt_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mstDelFlg = (JSPUtil.getParameter(request, prefix	+ "mst_del_flg", length));
			String[] chkDgt = (JSPUtil.getParameter(request, prefix	+ "chk_dgt", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dirItchgVndrSeq = (JSPUtil.getParameter(request, prefix	+ "dir_itchg_vndr_seq", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] cntrOldVanFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_old_van_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] timeLocal = (JSPUtil.getParameter(request, prefix	+ "time_local", length));
			
			for (int i = 0; i < length; i++) {
				model = new StatusHistoryVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (cntrDirItchgFeeAmt[i] != null)
					model.setCntrDirItchgFeeAmt(cntrDirItchgFeeAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (cntrMinOnhDys[i] != null)
					model.setCntrMinOnhDys(cntrMinOnhDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrDrffCrAmt[i] != null)
					model.setCntrDrffCrAmt(cntrDrffCrAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrPkupChgAmt[i] != null)
					model.setCntrPkupChgAmt(cntrPkupChgAmt[i]);
				if (cntrLftChgAmt[i] != null)
					model.setCntrLftChgAmt(cntrLftChgAmt[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (delFlg[i] != null)
					model.setDelFlg(delFlg[i]);
				if (cntrPkupCrChgAmt[i] != null)
					model.setCntrPkupCrChgAmt(cntrPkupCrChgAmt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (cntrStsRmk[i] != null)
					model.setCntrStsRmk(cntrStsRmk[i]);
				if (cntrStsSeq[i] != null)
					model.setCntrStsSeq(cntrStsSeq[i]);
				if (cntrDrffAmt[i] != null)
					model.setCntrDrffAmt(cntrDrffAmt[i]);
				if (cntrLstmCngFlg[i] != null)
					model.setCntrLstmCngFlg(cntrLstmCngFlg[i]);
				if (cntrStsEvntDt[i] != null)
					model.setCntrStsEvntDt(cntrStsEvntDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mstDelFlg[i] != null)
					model.setMstDelFlg(mstDelFlg[i]);
				if (chkDgt[i] != null)
					model.setChkDgt(chkDgt[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dirItchgVndrSeq[i] != null)
					model.setDirItchgVndrSeq(dirItchgVndrSeq[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (cntrOldVanFlg[i] != null)
					model.setCntrOldVanFlg(cntrOldVanFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (timeLocal[i] != null)
					model.setTimeLocal(timeLocal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStatusHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StatusHistoryVO[]
	 */
	public StatusHistoryVO[] getStatusHistoryVOs(){
		StatusHistoryVO[] vos = (StatusHistoryVO[])models.toArray(new StatusHistoryVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDirItchgFeeAmt = this.cntrDirItchgFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMinOnhDys = this.cntrMinOnhDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrffCrAmt = this.cntrDrffCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupChgAmt = this.cntrPkupChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLftChgAmt = this.cntrLftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlg = this.delFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupCrChgAmt = this.cntrPkupCrChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsRmk = this.cntrStsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq = this.cntrStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrffAmt = this.cntrDrffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLstmCngFlg = this.cntrLstmCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt = this.cntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstDelFlg = this.mstDelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDgt = this.chkDgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirItchgVndrSeq = this.dirItchgVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOldVanFlg = this.cntrOldVanFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeLocal = this.timeLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
