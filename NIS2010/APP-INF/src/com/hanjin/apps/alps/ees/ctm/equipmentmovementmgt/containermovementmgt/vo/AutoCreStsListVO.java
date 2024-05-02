/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AutoCreStsListVO.java
*@FileTitle : AutoCreStsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.12.17 나상보 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoCreStsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoCreStsListVO> models = new ArrayList<AutoCreStsListVO>();
	
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String tarDate = null;
	/* Column Info */
	private String creTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String cnmvId = null;
	/* Column Info */
	private String locType = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String preEvntDt = null;
	/* Column Info */
	private String preYdCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String preSts = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String cnmvCorrRsn = null;
	/* Column Info */
	private String atchFileSavId = null;
	/* Column Info */
	private String inpDivFlg = null;
	/* Column Info */
	private String cnmvHisSeq = null;
	/* Column Info */
	private String modiTp = null;
	/* Column Info */
	private String datDivFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AutoCreStsListVO() {}

	public AutoCreStsListVO(String ibflag, String pagerows, String tpSz, String cnmvId, String locType, String creDt, String mvmtCreTpCd, String preEvntDt, String stsCd, String preYdCd, String mvmtStsCd, String pDate1, String locCd, String pDate2, String ydCd, String cntrNo, String tarDate, String preSts, String cnmvYr, String creTpCd, String updUsrId, String ofcCd, String usrNm, String eventDt, String bkgNo, String cnmvRmk, String cnmvSeq, String cnmvSplitNo, String fcntrFlg, String bkgCgoTpCd, String vndrSeq, String cnmvCycNo, String imdtExtFlg, String crntVslCd, String crntSkdDirCd, String crntSkdVoyNo, String mvmtEdiMsgTpId, String cnmvCorrRsn, String atchFileSavId, String inpDivFlg, String cnmvHisSeq, String modiTp, String datDivFlg) {
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCycNo = cnmvCycNo;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.cnmvSeq = cnmvSeq;
		this.creDt = creDt;
		this.fcntrFlg = fcntrFlg;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.cnmvSplitNo = cnmvSplitNo;
		this.eventDt = eventDt;
		this.locCd = locCd;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.pDate2 = pDate2;
		this.usrNm = usrNm;
		this.tarDate = tarDate;
		this.creTpCd = creTpCd;
		this.updUsrId = updUsrId;
		this.tpSz = tpSz;
		this.cnmvId = cnmvId;
		this.locType = locType;
		this.crntSkdDirCd = crntSkdDirCd;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.preEvntDt = preEvntDt;
		this.preYdCd = preYdCd;
		this.ofcCd = ofcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.cnmvRmk = cnmvRmk;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.imdtExtFlg = imdtExtFlg;
		this.preSts = preSts;
		this.cnmvYr = cnmvYr;
		this.crntVslCd = crntVslCd;
		this.cnmvCorrRsn = cnmvCorrRsn;
		this.atchFileSavId = atchFileSavId;
		this.inpDivFlg = inpDivFlg;
		this.cnmvHisSeq = cnmvHisSeq;
		this.modiTp = modiTp;
		this.datDivFlg = datDivFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("tar_date", getTarDate());
		this.hashColumns.put("cre_tp_cd", getCreTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("cnmv_id", getCnmvId());
		this.hashColumns.put("loc_type", getLocType());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("pre_evnt_dt", getPreEvntDt());
		this.hashColumns.put("pre_yd_cd", getPreYdCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("pre_sts", getPreSts());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("cnmv_corr_rsn", getCnmvCorrRsn());
		this.hashColumns.put("atch_file_sav_id", getAtchFileSavId());
		this.hashColumns.put("inp_div_flg", getInpDivFlg());
		this.hashColumns.put("cnmv_his_seq", getCnmvHisSeq());
		this.hashColumns.put("modi_tp", getModiTp());
		this.hashColumns.put("dat_div_flg", getDatDivFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("tar_date", "tarDate");
		this.hashFields.put("cre_tp_cd", "creTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("cnmv_id", "cnmvId");
		this.hashFields.put("loc_type", "locType");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("pre_evnt_dt", "preEvntDt");
		this.hashFields.put("pre_yd_cd", "preYdCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("pre_sts", "preSts");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("cnmv_corr_rsn", "cnmvCorrRsn");
		this.hashFields.put("atch_file_sav_id", "atchFileSavId");
		this.hashFields.put("inp_div_flg", "inpDivFlg");
		this.hashFields.put("cnmv_his_seq", "cnmvHisSeq");
		this.hashFields.put("modi_tp", "modiTp");
		this.hashFields.put("dat_div_flg", "datDivFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
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
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
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
	 * @return tarDate
	 */
	public String getTarDate() {
		return this.tarDate;
	}
	
	/**
	 * Column Info
	 * @return creTpCd
	 */
	public String getCreTpCd() {
		return this.creTpCd;
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
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return cnmvId
	 */
	public String getCnmvId() {
		return this.cnmvId;
	}
	
	/**
	 * Column Info
	 * @return locType
	 */
	public String getLocType() {
		return this.locType;
	}
	
	/**
	 * Column Info
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
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
	 * @return preEvntDt
	 */
	public String getPreEvntDt() {
		return this.preEvntDt;
	}
	
	/**
	 * Column Info
	 * @return preYdCd
	 */
	public String getPreYdCd() {
		return this.preYdCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return preSts
	 */
	public String getPreSts() {
		return this.preSts;
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
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}

	/**
	 * Column Info
	 * @return cnmvCorrRsn
	 */
	public String getCnmvCorrRsn() {
		return this.cnmvCorrRsn;
	}

	/**
	 * Column Info
	 * @return atchFileSavId
	 */
	public String getAtchFileSavId() {
		return this.atchFileSavId;
	}

	/**
	 * Column Info
	 * @return inpDivFlg
	 */
	public String getInpDivFlg() {
		return this.inpDivFlg;
	}

	/**
	 * Column Info
	 * @return cnmvHisSeq
	 */
	public String getCnmvHisSeq() {
		return this.cnmvHisSeq;
	}

	/**
	 * Column Info
	 * @return modiTp
	 */
	public String getModiTp() {
		return this.modiTp;
	}

	/**
	 * Column Info
	 * @return datDivFlg
	 */
	public String getDatDivFlg() {
		return this.datDivFlg;
	}

	/**
	 * Column Info
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
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
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
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
	 * @param tarDate
	 */
	public void setTarDate(String tarDate) {
		this.tarDate = tarDate;
	}
	
	/**
	 * Column Info
	 * @param creTpCd
	 */
	public void setCreTpCd(String creTpCd) {
		this.creTpCd = creTpCd;
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
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param cnmvId
	 */
	public void setCnmvId(String cnmvId) {
		this.cnmvId = cnmvId;
	}
	
	/**
	 * Column Info
	 * @param locType
	 */
	public void setLocType(String locType) {
		this.locType = locType;
	}
	
	/**
	 * Column Info
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
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
	 * @param preEvntDt
	 */
	public void setPreEvntDt(String preEvntDt) {
		this.preEvntDt = preEvntDt;
	}
	
	/**
	 * Column Info
	 * @param preYdCd
	 */
	public void setPreYdCd(String preYdCd) {
		this.preYdCd = preYdCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param preSts
	 */
	public void setPreSts(String preSts) {
		this.preSts = preSts;
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
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}

	/**
	 * Column Info
	 * @param cnmvCorrRsn
	 */
	public void setCnmvCorrRsn(String cnmvCorrRsn) {
		this.cnmvCorrRsn = cnmvCorrRsn;
	}

	/**
	 * Column Info
	 * @param atchFileSavId
	 */
	public void setAtchFileSavId(String atchFileSavId) {
		this.atchFileSavId = atchFileSavId;
	}

	/**
	 * Column Info
	 * @param inpDivFlg
	 */
	public void setInpDivFlg(String inpDivFlg) {
		this.inpDivFlg = inpDivFlg;
	}

	/**
	 * Column Info
	 * @param cnmvHisSeq
	 */
	public void setCnmvHisSeq(String cnmvHisSeq) {
		this.cnmvHisSeq = cnmvHisSeq;
	}

	/**
	 * Column Info
	 * @param modiTp
	 */
	public void setModiTp(String modiTp) {
		this.modiTp = modiTp;
	}

	/**
	 * Column Info
	 * @param datDivFlg
	 */
	public void setDatDivFlg(String datDivFlg) {
		this.datDivFlg = datDivFlg;
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
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setTarDate(JSPUtil.getParameter(request, prefix + "tar_date", ""));
		setCreTpCd(JSPUtil.getParameter(request, prefix + "cre_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTpSz(JSPUtil.getParameter(request, prefix + "tp_sz", ""));
		setCnmvId(JSPUtil.getParameter(request, prefix + "cnmv_id", ""));
		setLocType(JSPUtil.getParameter(request, prefix + "loc_type", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setPreEvntDt(JSPUtil.getParameter(request, prefix + "pre_evnt_dt", ""));
		setPreYdCd(JSPUtil.getParameter(request, prefix + "pre_yd_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setPreSts(JSPUtil.getParameter(request, prefix + "pre_sts", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setCnmvCorrRsn(JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn", ""));
		setAtchFileSavId(JSPUtil.getParameter(request, prefix + "atch_file_sav_id", ""));
		setInpDivFlg(JSPUtil.getParameter(request, prefix + "inp_div_flg", ""));
		setCnmvHisSeq(JSPUtil.getParameter(request, prefix + "cnmv_his_seq", ""));
		setModiTp(JSPUtil.getParameter(request, prefix + "modi_tp", ""));
		setDatDivFlg(JSPUtil.getParameter(request, prefix + "dat_div_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoCreStsListVO[]
	 */
	public AutoCreStsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutoCreStsListVO[]
	 */
	public AutoCreStsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoCreStsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] tarDate = (JSPUtil.getParameter(request, prefix	+ "tar_date", length));
			String[] creTpCd = (JSPUtil.getParameter(request, prefix	+ "cre_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] cnmvId = (JSPUtil.getParameter(request, prefix	+ "cnmv_id", length));
			String[] locType = (JSPUtil.getParameter(request, prefix	+ "loc_type", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] preEvntDt = (JSPUtil.getParameter(request, prefix	+ "pre_evnt_dt", length));
			String[] preYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_yd_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] preSts = (JSPUtil.getParameter(request, prefix	+ "pre_sts", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] cnmvCorrRsn = (JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn", length));
			String[] atchFileSavId = (JSPUtil.getParameter(request, prefix + "atch_file_sav_id", length));
			String[] inpDivFlg = (JSPUtil.getParameter(request, prefix + "inp_div_flg", length));
			String[] cnmvHisSeq = (JSPUtil.getParameter(request, prefix + "cnmv_his_seq", length));
			String[] modiTp = (JSPUtil.getParameter(request, prefix + "modi_tp", length));
			String[] datDivFlg = (JSPUtil.getParameter(request, prefix + "dat_div_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoCreStsListVO();
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (tarDate[i] != null)
					model.setTarDate(tarDate[i]);
				if (creTpCd[i] != null)
					model.setCreTpCd(creTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (cnmvId[i] != null)
					model.setCnmvId(cnmvId[i]);
				if (locType[i] != null)
					model.setLocType(locType[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (preEvntDt[i] != null)
					model.setPreEvntDt(preEvntDt[i]);
				if (preYdCd[i] != null)
					model.setPreYdCd(preYdCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (preSts[i] != null)
					model.setPreSts(preSts[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (cnmvCorrRsn[i] != null)
					model.setCnmvCorrRsn(cnmvCorrRsn[i]);
				if (atchFileSavId[i] != null)
					model.setAtchFileSavId(atchFileSavId[i]);
				if (inpDivFlg[i] != null)
					model.setInpDivFlg(inpDivFlg[i]);
				if (cnmvHisSeq[i] != null)
					model.setCnmvHisSeq(cnmvHisSeq[i]);
				if (modiTp[i] != null)
					model.setModiTp(modiTp[i]);
				if (datDivFlg[i] != null)
					model.setDatDivFlg(datDivFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoCreStsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoCreStsListVO[]
	 */
	public AutoCreStsListVO[] getAutoCreStsListVOs(){
		AutoCreStsListVO[] vos = (AutoCreStsListVO[])models.toArray(new AutoCreStsListVO[models.size()]);
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
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tarDate = this.tarDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTpCd = this.creTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvId = this.cnmvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locType = this.locType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEvntDt = this.preEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preYdCd = this.preYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSts = this.preSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCorrRsn = this.cnmvCorrRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileSavId = this.atchFileSavId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDivFlg = this.inpDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisSeq = this.cnmvHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiTp = this.modiTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datDivFlg = this.datDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
