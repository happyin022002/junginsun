/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrStatusListVO.java
*@FileTitle : CntrStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.04.16 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrStatusListVO> models = new ArrayList<CntrStatusListVO>();
	
	/* Column Info */
	private String cntrStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fullCntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mnrHngrBarTpCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrDrffAmt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String rgstCntrNo = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chkDgt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ucFlg = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cntrPkupChgCrAmt = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String locCd1 = null;
	/* Column Info */
	private String locCd2 = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntrFullFlg = null;
	/* Column Info */
	private String cntrUseCoCd = null;
	/* Column Info */
	private String cntrDirItchgFeeAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrDrffCrAmt = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String cntrPkupChgAmt = null;
	/* Column Info */
	private String evntDt2 = null;
	/* Column Info */
	private String cntrLftChgAmt = null;
	/* Column Info */
	private String evntDt1 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String cntrStsRmk = null;
	/* Column Info */
	private String cntrLstmCngFlg = null;
	/* Column Info */
	private String cntrStsEvntDt = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String cnmvDate = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String lsFlg = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String imdtExtFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrStatusListVO() {}

	public CntrStatusListVO(String ibflag, String pagerows, String currCd, String cntrFullFlg, String cntrUseCoCd, String cntrStsCd, String cntrDirItchgFeeAmt, String creDt, String vndrLglEngNm, String crntYdCd, String cntrDrffCrAmt, String cnmvStsCd, String cntrLftChgAmt, String evntDt2, String cntrPkupChgAmt, String evntDt1, String fullCntrNo, String cntrTpszCd, String lstmCd, String updUsrId, String updDt, String rntlChgFreeDys, String cntrStsRmk, String cntrLstmCngFlg, String cntrDrffAmt, String cntrStsEvntDt, String agmtNo, String rgstCntrNo, String creUsrId, String cnmvDate, String chkDgt, String ydCd, String vndrSeq, String cntrNo, String refNo, String vndrAbbrNm, String cntrPkupChgCrAmt, String stayDays, String locCd1, String locCd2, String fullFlg, String dmgFlg, String cntrHngrRckCd, String mnrHngrBarTpCd, String cntrHngrBarAtchKnt, String dispFlg, String imdtExtFlg, String lsFlg, String ucFlg, String plstFlrFlg) {
		this.cntrStsCd = cntrStsCd;
		this.pagerows = pagerows;
		this.fullCntrNo = fullCntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.cntrDrffAmt = cntrDrffAmt;
		this.agmtNo = agmtNo;
		this.rgstCntrNo = rgstCntrNo;
		this.dispFlg = dispFlg;
		this.creUsrId = creUsrId;
		this.chkDgt = chkDgt;
		this.vndrSeq = vndrSeq;
		this.ucFlg = ucFlg;
		this.fullFlg = fullFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cntrPkupChgCrAmt = cntrPkupChgCrAmt;
		this.stayDays = stayDays;
		this.locCd1 = locCd1;
		this.locCd2 = locCd2;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.currCd = currCd;
		this.cntrFullFlg = cntrFullFlg;
		this.cntrUseCoCd = cntrUseCoCd;
		this.cntrDirItchgFeeAmt = cntrDirItchgFeeAmt;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crntYdCd = crntYdCd;
		this.dmgFlg = dmgFlg;
		this.ibflag = ibflag;
		this.cntrDrffCrAmt = cntrDrffCrAmt;
		this.cnmvStsCd = cnmvStsCd;
		this.cntrPkupChgAmt = cntrPkupChgAmt;
		this.evntDt2 = evntDt2;
		this.cntrLftChgAmt = cntrLftChgAmt;
		this.evntDt1 = evntDt1;
		this.updDt = updDt;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.cntrStsRmk = cntrStsRmk;
		this.cntrLstmCngFlg = cntrLstmCngFlg;
		this.cntrStsEvntDt = cntrStsEvntDt;
		this.plstFlrFlg = plstFlrFlg;
		this.cnmvDate = cnmvDate;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.lsFlg = lsFlg;
		this.refNo = refNo;
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("full_cntr_no", getFullCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_drff_amt", getCntrDrffAmt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("rgst_cntr_no", getRgstCntrNo());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chk_dgt", getChkDgt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("uc_flg", getUcFlg());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cntr_pkup_chg_cr_amt", getCntrPkupChgCrAmt());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("loc_cd1", getLocCd1());
		this.hashColumns.put("loc_cd2", getLocCd2());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());
		this.hashColumns.put("cntr_dir_itchg_fee_amt", getCntrDirItchgFeeAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_drff_cr_amt", getCntrDrffCrAmt());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("cntr_pkup_chg_amt", getCntrPkupChgAmt());
		this.hashColumns.put("evnt_dt2", getEvntDt2());
		this.hashColumns.put("cntr_lft_chg_amt", getCntrLftChgAmt());
		this.hashColumns.put("evnt_dt1", getEvntDt1());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("cntr_sts_rmk", getCntrStsRmk());
		this.hashColumns.put("cntr_lstm_cng_flg", getCntrLstmCngFlg());
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("cnmv_date", getCnmvDate());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ls_flg", getLsFlg());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("full_cntr_no", "fullCntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_drff_amt", "cntrDrffAmt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("rgst_cntr_no", "rgstCntrNo");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_dgt", "chkDgt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("uc_flg", "ucFlg");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr_pkup_chg_cr_amt", "cntrPkupChgCrAmt");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("loc_cd1", "locCd1");
		this.hashFields.put("loc_cd2", "locCd2");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("cntr_dir_itchg_fee_amt", "cntrDirItchgFeeAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_drff_cr_amt", "cntrDrffCrAmt");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cntr_pkup_chg_amt", "cntrPkupChgAmt");
		this.hashFields.put("evnt_dt2", "evntDt2");
		this.hashFields.put("cntr_lft_chg_amt", "cntrLftChgAmt");
		this.hashFields.put("evnt_dt1", "evntDt1");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("cntr_sts_rmk", "cntrStsRmk");
		this.hashFields.put("cntr_lstm_cng_flg", "cntrLstmCngFlg");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cnmv_date", "cnmvDate");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ls_flg", "lsFlg");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
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
	 * @return fullCntrNo
	 */
	public String getFullCntrNo() {
		return this.fullCntrNo;
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
	 * @return mnrHngrBarTpCd
	 */
	public String getMnrHngrBarTpCd() {
		return this.mnrHngrBarTpCd;
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
	 * @return cntrDrffAmt
	 */
	public String getCntrDrffAmt() {
		return this.cntrDrffAmt;
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
	 * @return rgstCntrNo
	 */
	public String getRgstCntrNo() {
		return this.rgstCntrNo;
	}
	
	/**
	 * Column Info
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return chkDgt
	 */
	public String getChkDgt() {
		return this.chkDgt;
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
	 * @return ucFlg
	 */
	public String getUcFlg() {
		return this.ucFlg;
	}
	
	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupChgCrAmt
	 */
	public String getCntrPkupChgCrAmt() {
		return this.cntrPkupChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return stayDays
	 */
	public String getStayDays() {
		return this.stayDays;
	}
	
	/**
	 * Column Info
	 * @return locCd1
	 */
	public String getLocCd1() {
		return this.locCd1;
	}
	
	/**
	 * Column Info
	 * @return locCd2
	 */
	public String getLocCd2() {
		return this.locCd2;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
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
	 * @return cntrFullFlg
	 */
	public String getCntrFullFlg() {
		return this.cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrUseCoCd
	 */
	public String getCntrUseCoCd() {
		return this.cntrUseCoCd;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
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
	 * @return cntrDrffCrAmt
	 */
	public String getCntrDrffCrAmt() {
		return this.cntrDrffCrAmt;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return evntDt2
	 */
	public String getEvntDt2() {
		return this.evntDt2;
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
	 * @return evntDt1
	 */
	public String getEvntDt1() {
		return this.evntDt1;
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
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvDate
	 */
	public String getCnmvDate() {
		return this.cnmvDate;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return lsFlg
	 */
	public String getLsFlg() {
		return this.lsFlg;
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
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	

	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
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
	 * @param fullCntrNo
	 */
	public void setFullCntrNo(String fullCntrNo) {
		this.fullCntrNo = fullCntrNo;
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
	 * @param mnrHngrBarTpCd
	 */
	public void setMnrHngrBarTpCd(String mnrHngrBarTpCd) {
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
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
	 * @param cntrDrffAmt
	 */
	public void setCntrDrffAmt(String cntrDrffAmt) {
		this.cntrDrffAmt = cntrDrffAmt;
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
	 * @param rgstCntrNo
	 */
	public void setRgstCntrNo(String rgstCntrNo) {
		this.rgstCntrNo = rgstCntrNo;
	}
	
	/**
	 * Column Info
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param chkDgt
	 */
	public void setChkDgt(String chkDgt) {
		this.chkDgt = chkDgt;
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
	 * @param ucFlg
	 */
	public void setUcFlg(String ucFlg) {
		this.ucFlg = ucFlg;
	}
	
	/**
	 * Column Info
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupChgCrAmt
	 */
	public void setCntrPkupChgCrAmt(String cntrPkupChgCrAmt) {
		this.cntrPkupChgCrAmt = cntrPkupChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param stayDays
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	
	/**
	 * Column Info
	 * @param locCd1
	 */
	public void setLocCd1(String locCd1) {
		this.locCd1 = locCd1;
	}
	
	/**
	 * Column Info
	 * @param locCd2
	 */
	public void setLocCd2(String locCd2) {
		this.locCd2 = locCd2;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
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
	 * @param cntrFullFlg
	 */
	public void setCntrFullFlg(String cntrFullFlg) {
		this.cntrFullFlg = cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrUseCoCd
	 */
	public void setCntrUseCoCd(String cntrUseCoCd) {
		this.cntrUseCoCd = cntrUseCoCd;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
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
	 * @param cntrDrffCrAmt
	 */
	public void setCntrDrffCrAmt(String cntrDrffCrAmt) {
		this.cntrDrffCrAmt = cntrDrffCrAmt;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param evntDt2
	 */
	public void setEvntDt2(String evntDt2) {
		this.evntDt2 = evntDt2;
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
	 * @param evntDt1
	 */
	public void setEvntDt1(String evntDt1) {
		this.evntDt1 = evntDt1;
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
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvDate
	 */
	public void setCnmvDate(String cnmvDate) {
		this.cnmvDate = cnmvDate;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param lsFlg
	 */
	public void setLsFlg(String lsFlg) {
		this.lsFlg = lsFlg;
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
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
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
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFullCntrNo(JSPUtil.getParameter(request, prefix + "full_cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_bar_tp_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "cntr_hngr_bar_atch_knt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrDrffAmt(JSPUtil.getParameter(request, prefix + "cntr_drff_amt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setRgstCntrNo(JSPUtil.getParameter(request, prefix + "rgst_cntr_no", ""));
		setDispFlg(JSPUtil.getParameter(request, prefix + "disp_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChkDgt(JSPUtil.getParameter(request, prefix + "chk_dgt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setUcFlg(JSPUtil.getParameter(request, prefix + "uc_flg", ""));
		setFullFlg(JSPUtil.getParameter(request, prefix + "full_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setCntrPkupChgCrAmt(JSPUtil.getParameter(request, prefix + "cntr_pkup_chg_cr_amt", ""));
		setStayDays(JSPUtil.getParameter(request, prefix + "stay_days", ""));
		setLocCd1(JSPUtil.getParameter(request, prefix + "loc_cd1", ""));
		setLocCd2(JSPUtil.getParameter(request, prefix + "loc_cd2", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCntrFullFlg(JSPUtil.getParameter(request, prefix + "cntr_full_flg", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request, prefix + "cntr_use_co_cd", ""));
		setCntrDirItchgFeeAmt(JSPUtil.getParameter(request, prefix + "cntr_dir_itchg_fee_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, prefix + "dmg_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrDrffCrAmt(JSPUtil.getParameter(request, prefix + "cntr_drff_cr_amt", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setCntrPkupChgAmt(JSPUtil.getParameter(request, prefix + "cntr_pkup_chg_amt", ""));
		setEvntDt2(JSPUtil.getParameter(request, prefix + "evnt_dt2", ""));
		setCntrLftChgAmt(JSPUtil.getParameter(request, prefix + "cntr_lft_chg_amt", ""));
		setEvntDt1(JSPUtil.getParameter(request, prefix + "evnt_dt1", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request, prefix + "rntl_chg_free_dys", ""));
		setCntrStsRmk(JSPUtil.getParameter(request, prefix + "cntr_sts_rmk", ""));
		setCntrLstmCngFlg(JSPUtil.getParameter(request, prefix + "cntr_lstm_cng_flg", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request, prefix + "cntr_sts_evnt_dt", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, prefix + "plst_flr_flg", ""));
		setCnmvDate(JSPUtil.getParameter(request, prefix + "cnmv_date", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setLsFlg(JSPUtil.getParameter(request, prefix + "ls_flg", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrStatusListVO[]
	 */
	public CntrStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrStatusListVO[]
	 */
	public CntrStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fullCntrNo = (JSPUtil.getParameter(request, prefix	+ "full_cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrDrffAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_drff_amt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] rgstCntrNo = (JSPUtil.getParameter(request, prefix	+ "rgst_cntr_no", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chkDgt = (JSPUtil.getParameter(request, prefix	+ "chk_dgt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ucFlg = (JSPUtil.getParameter(request, prefix	+ "uc_flg", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] cntrPkupChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_chg_cr_amt", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] locCd1 = (JSPUtil.getParameter(request, prefix	+ "loc_cd1", length));
			String[] locCd2 = (JSPUtil.getParameter(request, prefix	+ "loc_cd2", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntrFullFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_full_flg", length));
			String[] cntrUseCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_use_co_cd", length));
			String[] cntrDirItchgFeeAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_dir_itchg_fee_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrDrffCrAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_drff_cr_amt", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] cntrPkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_chg_amt", length));
			String[] evntDt2 = (JSPUtil.getParameter(request, prefix	+ "evnt_dt2", length));
			String[] cntrLftChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_lft_chg_amt", length));
			String[] evntDt1 = (JSPUtil.getParameter(request, prefix	+ "evnt_dt1", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] cntrStsRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_rmk", length));
			String[] cntrLstmCngFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_lstm_cng_flg", length));
			String[] cntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_evnt_dt", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] cnmvDate = (JSPUtil.getParameter(request, prefix	+ "cnmv_date", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] lsFlg = (JSPUtil.getParameter(request, prefix	+ "ls_flg", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrStatusListVO();
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fullCntrNo[i] != null)
					model.setFullCntrNo(fullCntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mnrHngrBarTpCd[i] != null)
					model.setMnrHngrBarTpCd(mnrHngrBarTpCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrDrffAmt[i] != null)
					model.setCntrDrffAmt(cntrDrffAmt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (rgstCntrNo[i] != null)
					model.setRgstCntrNo(rgstCntrNo[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chkDgt[i] != null)
					model.setChkDgt(chkDgt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ucFlg[i] != null)
					model.setUcFlg(ucFlg[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cntrPkupChgCrAmt[i] != null)
					model.setCntrPkupChgCrAmt(cntrPkupChgCrAmt[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (locCd1[i] != null)
					model.setLocCd1(locCd1[i]);
				if (locCd2[i] != null)
					model.setLocCd2(locCd2[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntrFullFlg[i] != null)
					model.setCntrFullFlg(cntrFullFlg[i]);
				if (cntrUseCoCd[i] != null)
					model.setCntrUseCoCd(cntrUseCoCd[i]);
				if (cntrDirItchgFeeAmt[i] != null)
					model.setCntrDirItchgFeeAmt(cntrDirItchgFeeAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrDrffCrAmt[i] != null)
					model.setCntrDrffCrAmt(cntrDrffCrAmt[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (cntrPkupChgAmt[i] != null)
					model.setCntrPkupChgAmt(cntrPkupChgAmt[i]);
				if (evntDt2[i] != null)
					model.setEvntDt2(evntDt2[i]);
				if (cntrLftChgAmt[i] != null)
					model.setCntrLftChgAmt(cntrLftChgAmt[i]);
				if (evntDt1[i] != null)
					model.setEvntDt1(evntDt1[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (cntrStsRmk[i] != null)
					model.setCntrStsRmk(cntrStsRmk[i]);
				if (cntrLstmCngFlg[i] != null)
					model.setCntrLstmCngFlg(cntrLstmCngFlg[i]);
				if (cntrStsEvntDt[i] != null)
					model.setCntrStsEvntDt(cntrStsEvntDt[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (cnmvDate[i] != null)
					model.setCnmvDate(cnmvDate[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (lsFlg[i] != null)
					model.setLsFlg(lsFlg[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrStatusListVO[]
	 */
	public CntrStatusListVO[] getCntrStatusListVOs(){
		CntrStatusListVO[] vos = (CntrStatusListVO[])models.toArray(new CntrStatusListVO[models.size()]);
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
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullCntrNo = this.fullCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd = this.mnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrffAmt = this.cntrDrffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstCntrNo = this.rgstCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDgt = this.chkDgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucFlg = this.ucFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupChgCrAmt = this.cntrPkupChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd1 = this.locCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd2 = this.locCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullFlg = this.cntrFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd = this.cntrUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDirItchgFeeAmt = this.cntrDirItchgFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrffCrAmt = this.cntrDrffCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupChgAmt = this.cntrPkupChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt2 = this.evntDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLftChgAmt = this.cntrLftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt1 = this.evntDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsRmk = this.cntrStsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLstmCngFlg = this.cntrLstmCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt = this.cntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDate = this.cnmvDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsFlg = this.lsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
