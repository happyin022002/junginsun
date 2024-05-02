/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetCostDayBatRstVO.java
*@FileTitle : DemDetCostDayBatRstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.02.25 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemDetCostDayBatRstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemDetCostDayBatRstVO> models = new ArrayList<DemDetCostDayBatRstVO>();
	
	/* Column Info */
	private String bkgBnd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String stoToDt = null;
	/* Column Info */
	private String fSelinputtype = null;
	/* Column Info */
	private String cntrFmMvmt = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String comStsNo = null;
	/* Column Info */
	private String cntrSts = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String batDt = null;
	/* Column Info */
	private String chssFmDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fFmNod = null;
	/* Column Info */
	private String fFmyearmonth = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssToMvmt = null;
	/* Column Info */
	private String cntrToNod = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String stoSts = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stoToNod = null;
	/* Column Info */
	private String cntrToDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrFmDt = null;
	/* Column Info */
	private String chssSts = null;
	/* Column Info */
	private String chssFmMvmt = null;
	/* Column Info */
	private String stoFmMvmt = null;
	/* Column Info */
	private String cntrToMvmt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String stoFmDt = null;
	/* Column Info */
	private String chssToNod = null;
	/* Column Info */
	private String chssToDt = null;
	/* Column Info */
	private String cntrFmNod = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fToyearmonth = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fCntrno = null;
	/* Column Info */
	private String fBkgno = null;
	/* Column Info */
	private String stoToMvmt = null;
	/* Column Info */
	private String stoFmNod = null;
	/* Column Info */
	private String fStoCntrChss = null;
	/* Column Info */
	private String chssFmNod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DemDetCostDayBatRstVO() {}

	public DemDetCostDayBatRstVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String bkgNo, String bkgBnd, String mvmtStsCd, String orgYdCd, String cnmvEvntDt, String cnmvCycNo, String cnmvSeq, String stoFmMvmt, String stoToMvmt, String stoFmNod, String stoToNod, String stoFmDt, String stoToDt, String stoSts, String cntrFmMvmt, String cntrToMvmt, String cntrFmNod, String cntrToNod, String cntrFmDt, String cntrToDt, String cntrSts, String chssFmMvmt, String chssToMvmt, String chssFmNod, String chssToNod, String chssFmDt, String chssToDt, String chssSts, String comStsNo, String batDt, String creUsrId, String creDt, String updUsrId, String updDt, String fFmyearmonth, String fToyearmonth, String fStoCntrChss, String fFmNod, String fBkgno, String fCntrno, String fSelinputtype) {
		this.bkgBnd = bkgBnd;
		this.cnmvCycNo = cnmvCycNo;
		this.stoToDt = stoToDt;
		this.fSelinputtype = fSelinputtype;
		this.cntrFmMvmt = cntrFmMvmt;
		this.cnmvSeq = cnmvSeq;
		this.comStsNo = comStsNo;
		this.cntrSts = cntrSts;
		this.creDt = creDt;
		this.batDt = batDt;
		this.chssFmDt = chssFmDt;
		this.pagerows = pagerows;
		this.fFmNod = fFmNod;
		this.fFmyearmonth = fFmyearmonth;
		this.ibflag = ibflag;
		this.chssToMvmt = chssToMvmt;
		this.cntrToNod = cntrToNod;
		this.cntrTpszCd = cntrTpszCd;
		this.stoSts = stoSts;
		this.updUsrId = updUsrId;
		this.stoToNod = stoToNod;
		this.cntrToDt = cntrToDt;
		this.updDt = updDt;
		this.cntrFmDt = cntrFmDt;
		this.chssSts = chssSts;
		this.chssFmMvmt = chssFmMvmt;
		this.stoFmMvmt = stoFmMvmt;
		this.cntrToMvmt = cntrToMvmt;
		this.cnmvEvntDt = cnmvEvntDt;
		this.orgYdCd = orgYdCd;
		this.stoFmDt = stoFmDt;
		this.chssToNod = chssToNod;
		this.chssToDt = chssToDt;
		this.cntrFmNod = cntrFmNod;
		this.creUsrId = creUsrId;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.fToyearmonth = fToyearmonth;
		this.cntrNo = cntrNo;
		this.fCntrno = fCntrno;
		this.fBkgno = fBkgno;
		this.stoToMvmt = stoToMvmt;
		this.stoFmNod = stoFmNod;
		this.fStoCntrChss = fStoCntrChss;
		this.chssFmNod = chssFmNod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_bnd", getBkgBnd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("sto_to_dt", getStoToDt());
		this.hashColumns.put("f_selinputtype", getFSelinputtype());
		this.hashColumns.put("cntr_fm_mvmt", getCntrFmMvmt());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("com_sts_no", getComStsNo());
		this.hashColumns.put("cntr_sts", getCntrSts());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bat_dt", getBatDt());
		this.hashColumns.put("chss_fm_dt", getChssFmDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_fm_nod", getFFmNod());
		this.hashColumns.put("f_fmyearmonth", getFFmyearmonth());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_to_mvmt", getChssToMvmt());
		this.hashColumns.put("cntr_to_nod", getCntrToNod());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("sto_sts", getStoSts());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sto_to_nod", getStoToNod());
		this.hashColumns.put("cntr_to_dt", getCntrToDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_fm_dt", getCntrFmDt());
		this.hashColumns.put("chss_sts", getChssSts());
		this.hashColumns.put("chss_fm_mvmt", getChssFmMvmt());
		this.hashColumns.put("sto_fm_mvmt", getStoFmMvmt());
		this.hashColumns.put("cntr_to_mvmt", getCntrToMvmt());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("sto_fm_dt", getStoFmDt());
		this.hashColumns.put("chss_to_nod", getChssToNod());
		this.hashColumns.put("chss_to_dt", getChssToDt());
		this.hashColumns.put("cntr_fm_nod", getCntrFmNod());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("f_toyearmonth", getFToyearmonth());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("f_cntrno", getFCntrno());
		this.hashColumns.put("f_bkgno", getFBkgno());
		this.hashColumns.put("sto_to_mvmt", getStoToMvmt());
		this.hashColumns.put("sto_fm_nod", getStoFmNod());
		this.hashColumns.put("f_sto_cntr_chss", getFStoCntrChss());
		this.hashColumns.put("chss_fm_nod", getChssFmNod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_bnd", "bkgBnd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("sto_to_dt", "stoToDt");
		this.hashFields.put("f_selinputtype", "fSelinputtype");
		this.hashFields.put("cntr_fm_mvmt", "cntrFmMvmt");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("com_sts_no", "comStsNo");
		this.hashFields.put("cntr_sts", "cntrSts");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bat_dt", "batDt");
		this.hashFields.put("chss_fm_dt", "chssFmDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_fm_nod", "fFmNod");
		this.hashFields.put("f_fmyearmonth", "fFmyearmonth");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_to_mvmt", "chssToMvmt");
		this.hashFields.put("cntr_to_nod", "cntrToNod");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("sto_sts", "stoSts");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sto_to_nod", "stoToNod");
		this.hashFields.put("cntr_to_dt", "cntrToDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_fm_dt", "cntrFmDt");
		this.hashFields.put("chss_sts", "chssSts");
		this.hashFields.put("chss_fm_mvmt", "chssFmMvmt");
		this.hashFields.put("sto_fm_mvmt", "stoFmMvmt");
		this.hashFields.put("cntr_to_mvmt", "cntrToMvmt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("sto_fm_dt", "stoFmDt");
		this.hashFields.put("chss_to_nod", "chssToNod");
		this.hashFields.put("chss_to_dt", "chssToDt");
		this.hashFields.put("cntr_fm_nod", "cntrFmNod");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("f_toyearmonth", "fToyearmonth");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("f_cntrno", "fCntrno");
		this.hashFields.put("f_bkgno", "fBkgno");
		this.hashFields.put("sto_to_mvmt", "stoToMvmt");
		this.hashFields.put("sto_fm_nod", "stoFmNod");
		this.hashFields.put("f_sto_cntr_chss", "fStoCntrChss");
		this.hashFields.put("chss_fm_nod", "chssFmNod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgBnd
	 */
	public String getBkgBnd() {
		return this.bkgBnd;
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
	 * @return stoToDt
	 */
	public String getStoToDt() {
		return this.stoToDt;
	}
	
	/**
	 * Column Info
	 * @return fSelinputtype
	 */
	public String getFSelinputtype() {
		return this.fSelinputtype;
	}
	
	/**
	 * Column Info
	 * @return cntrFmMvmt
	 */
	public String getCntrFmMvmt() {
		return this.cntrFmMvmt;
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
	 * @return comStsNo
	 */
	public String getComStsNo() {
		return this.comStsNo;
	}
	
	/**
	 * Column Info
	 * @return cntrSts
	 */
	public String getCntrSts() {
		return this.cntrSts;
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
	 * @return batDt
	 */
	public String getBatDt() {
		return this.batDt;
	}
	
	/**
	 * Column Info
	 * @return chssFmDt
	 */
	public String getChssFmDt() {
		return this.chssFmDt;
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
	 * @return fFmNod
	 */
	public String getFFmNod() {
		return this.fFmNod;
	}
	
	/**
	 * Column Info
	 * @return fFmyearmonth
	 */
	public String getFFmyearmonth() {
		return this.fFmyearmonth;
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
	 * @return chssToMvmt
	 */
	public String getChssToMvmt() {
		return this.chssToMvmt;
	}
	
	/**
	 * Column Info
	 * @return cntrToNod
	 */
	public String getCntrToNod() {
		return this.cntrToNod;
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
	 * @return stoSts
	 */
	public String getStoSts() {
		return this.stoSts;
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
	 * @return stoToNod
	 */
	public String getStoToNod() {
		return this.stoToNod;
	}
	
	/**
	 * Column Info
	 * @return cntrToDt
	 */
	public String getCntrToDt() {
		return this.cntrToDt;
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
	 * @return cntrFmDt
	 */
	public String getCntrFmDt() {
		return this.cntrFmDt;
	}
	
	/**
	 * Column Info
	 * @return chssSts
	 */
	public String getChssSts() {
		return this.chssSts;
	}
	
	/**
	 * Column Info
	 * @return chssFmMvmt
	 */
	public String getChssFmMvmt() {
		return this.chssFmMvmt;
	}
	
	/**
	 * Column Info
	 * @return stoFmMvmt
	 */
	public String getStoFmMvmt() {
		return this.stoFmMvmt;
	}
	
	/**
	 * Column Info
	 * @return cntrToMvmt
	 */
	public String getCntrToMvmt() {
		return this.cntrToMvmt;
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
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return stoFmDt
	 */
	public String getStoFmDt() {
		return this.stoFmDt;
	}
	
	/**
	 * Column Info
	 * @return chssToNod
	 */
	public String getChssToNod() {
		return this.chssToNod;
	}
	
	/**
	 * Column Info
	 * @return chssToDt
	 */
	public String getChssToDt() {
		return this.chssToDt;
	}
	
	/**
	 * Column Info
	 * @return cntrFmNod
	 */
	public String getCntrFmNod() {
		return this.cntrFmNod;
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
	 * @return fToyearmonth
	 */
	public String getFToyearmonth() {
		return this.fToyearmonth;
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
	 * @return fCntrno
	 */
	public String getFCntrno() {
		return this.fCntrno;
	}
	
	/**
	 * Column Info
	 * @return fBkgno
	 */
	public String getFBkgno() {
		return this.fBkgno;
	}
	
	/**
	 * Column Info
	 * @return stoToMvmt
	 */
	public String getStoToMvmt() {
		return this.stoToMvmt;
	}
	
	/**
	 * Column Info
	 * @return stoFmNod
	 */
	public String getStoFmNod() {
		return this.stoFmNod;
	}
	
	/**
	 * Column Info
	 * @return fStoCntrChss
	 */
	public String getFStoCntrChss() {
		return this.fStoCntrChss;
	}
	
	/**
	 * Column Info
	 * @return chssFmNod
	 */
	public String getChssFmNod() {
		return this.chssFmNod;
	}
	

	/**
	 * Column Info
	 * @param bkgBnd
	 */
	public void setBkgBnd(String bkgBnd) {
		this.bkgBnd = bkgBnd;
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
	 * @param stoToDt
	 */
	public void setStoToDt(String stoToDt) {
		this.stoToDt = stoToDt;
	}
	
	/**
	 * Column Info
	 * @param fSelinputtype
	 */
	public void setFSelinputtype(String fSelinputtype) {
		this.fSelinputtype = fSelinputtype;
	}
	
	/**
	 * Column Info
	 * @param cntrFmMvmt
	 */
	public void setCntrFmMvmt(String cntrFmMvmt) {
		this.cntrFmMvmt = cntrFmMvmt;
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
	 * @param comStsNo
	 */
	public void setComStsNo(String comStsNo) {
		this.comStsNo = comStsNo;
	}
	
	/**
	 * Column Info
	 * @param cntrSts
	 */
	public void setCntrSts(String cntrSts) {
		this.cntrSts = cntrSts;
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
	 * @param batDt
	 */
	public void setBatDt(String batDt) {
		this.batDt = batDt;
	}
	
	/**
	 * Column Info
	 * @param chssFmDt
	 */
	public void setChssFmDt(String chssFmDt) {
		this.chssFmDt = chssFmDt;
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
	 * @param fFmNod
	 */
	public void setFFmNod(String fFmNod) {
		this.fFmNod = fFmNod;
	}
	
	/**
	 * Column Info
	 * @param fFmyearmonth
	 */
	public void setFFmyearmonth(String fFmyearmonth) {
		this.fFmyearmonth = fFmyearmonth;
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
	 * @param chssToMvmt
	 */
	public void setChssToMvmt(String chssToMvmt) {
		this.chssToMvmt = chssToMvmt;
	}
	
	/**
	 * Column Info
	 * @param cntrToNod
	 */
	public void setCntrToNod(String cntrToNod) {
		this.cntrToNod = cntrToNod;
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
	 * @param stoSts
	 */
	public void setStoSts(String stoSts) {
		this.stoSts = stoSts;
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
	 * @param stoToNod
	 */
	public void setStoToNod(String stoToNod) {
		this.stoToNod = stoToNod;
	}
	
	/**
	 * Column Info
	 * @param cntrToDt
	 */
	public void setCntrToDt(String cntrToDt) {
		this.cntrToDt = cntrToDt;
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
	 * @param cntrFmDt
	 */
	public void setCntrFmDt(String cntrFmDt) {
		this.cntrFmDt = cntrFmDt;
	}
	
	/**
	 * Column Info
	 * @param chssSts
	 */
	public void setChssSts(String chssSts) {
		this.chssSts = chssSts;
	}
	
	/**
	 * Column Info
	 * @param chssFmMvmt
	 */
	public void setChssFmMvmt(String chssFmMvmt) {
		this.chssFmMvmt = chssFmMvmt;
	}
	
	/**
	 * Column Info
	 * @param stoFmMvmt
	 */
	public void setStoFmMvmt(String stoFmMvmt) {
		this.stoFmMvmt = stoFmMvmt;
	}
	
	/**
	 * Column Info
	 * @param cntrToMvmt
	 */
	public void setCntrToMvmt(String cntrToMvmt) {
		this.cntrToMvmt = cntrToMvmt;
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
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param stoFmDt
	 */
	public void setStoFmDt(String stoFmDt) {
		this.stoFmDt = stoFmDt;
	}
	
	/**
	 * Column Info
	 * @param chssToNod
	 */
	public void setChssToNod(String chssToNod) {
		this.chssToNod = chssToNod;
	}
	
	/**
	 * Column Info
	 * @param chssToDt
	 */
	public void setChssToDt(String chssToDt) {
		this.chssToDt = chssToDt;
	}
	
	/**
	 * Column Info
	 * @param cntrFmNod
	 */
	public void setCntrFmNod(String cntrFmNod) {
		this.cntrFmNod = cntrFmNod;
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
	 * @param fToyearmonth
	 */
	public void setFToyearmonth(String fToyearmonth) {
		this.fToyearmonth = fToyearmonth;
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
	 * @param fCntrno
	 */
	public void setFCntrno(String fCntrno) {
		this.fCntrno = fCntrno;
	}
	
	/**
	 * Column Info
	 * @param fBkgno
	 */
	public void setFBkgno(String fBkgno) {
		this.fBkgno = fBkgno;
	}
	
	/**
	 * Column Info
	 * @param stoToMvmt
	 */
	public void setStoToMvmt(String stoToMvmt) {
		this.stoToMvmt = stoToMvmt;
	}
	
	/**
	 * Column Info
	 * @param stoFmNod
	 */
	public void setStoFmNod(String stoFmNod) {
		this.stoFmNod = stoFmNod;
	}
	
	/**
	 * Column Info
	 * @param fStoCntrChss
	 */
	public void setFStoCntrChss(String fStoCntrChss) {
		this.fStoCntrChss = fStoCntrChss;
	}
	
	/**
	 * Column Info
	 * @param chssFmNod
	 */
	public void setChssFmNod(String chssFmNod) {
		this.chssFmNod = chssFmNod;
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
		setBkgBnd(JSPUtil.getParameter(request, prefix + "bkg_bnd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setStoToDt(JSPUtil.getParameter(request, prefix + "sto_to_dt", ""));
		setFSelinputtype(JSPUtil.getParameter(request, prefix + "f_selinputtype", ""));
		setCntrFmMvmt(JSPUtil.getParameter(request, prefix + "cntr_fm_mvmt", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setComStsNo(JSPUtil.getParameter(request, prefix + "com_sts_no", ""));
		setCntrSts(JSPUtil.getParameter(request, prefix + "cntr_sts", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBatDt(JSPUtil.getParameter(request, prefix + "bat_dt", ""));
		setChssFmDt(JSPUtil.getParameter(request, prefix + "chss_fm_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFFmNod(JSPUtil.getParameter(request, prefix + "f_fm_nod", ""));
		setFFmyearmonth(JSPUtil.getParameter(request, prefix + "f_fmyearmonth", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChssToMvmt(JSPUtil.getParameter(request, prefix + "chss_to_mvmt", ""));
		setCntrToNod(JSPUtil.getParameter(request, prefix + "cntr_to_nod", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setStoSts(JSPUtil.getParameter(request, prefix + "sto_sts", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStoToNod(JSPUtil.getParameter(request, prefix + "sto_to_nod", ""));
		setCntrToDt(JSPUtil.getParameter(request, prefix + "cntr_to_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCntrFmDt(JSPUtil.getParameter(request, prefix + "cntr_fm_dt", ""));
		setChssSts(JSPUtil.getParameter(request, prefix + "chss_sts", ""));
		setChssFmMvmt(JSPUtil.getParameter(request, prefix + "chss_fm_mvmt", ""));
		setStoFmMvmt(JSPUtil.getParameter(request, prefix + "sto_fm_mvmt", ""));
		setCntrToMvmt(JSPUtil.getParameter(request, prefix + "cntr_to_mvmt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setStoFmDt(JSPUtil.getParameter(request, prefix + "sto_fm_dt", ""));
		setChssToNod(JSPUtil.getParameter(request, prefix + "chss_to_nod", ""));
		setChssToDt(JSPUtil.getParameter(request, prefix + "chss_to_dt", ""));
		setCntrFmNod(JSPUtil.getParameter(request, prefix + "cntr_fm_nod", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFToyearmonth(JSPUtil.getParameter(request, prefix + "f_toyearmonth", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFCntrno(JSPUtil.getParameter(request, prefix + "f_cntrno", ""));
		setFBkgno(JSPUtil.getParameter(request, prefix + "f_bkgno", ""));
		setStoToMvmt(JSPUtil.getParameter(request, prefix + "sto_to_mvmt", ""));
		setStoFmNod(JSPUtil.getParameter(request, prefix + "sto_fm_nod", ""));
		setFStoCntrChss(JSPUtil.getParameter(request, prefix + "f_sto_cntr_chss", ""));
		setChssFmNod(JSPUtil.getParameter(request, prefix + "chss_fm_nod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemDetCostDayBatRstVO[]
	 */
	public DemDetCostDayBatRstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemDetCostDayBatRstVO[]
	 */
	public DemDetCostDayBatRstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemDetCostDayBatRstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgBnd = (JSPUtil.getParameter(request, prefix	+ "bkg_bnd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] stoToDt = (JSPUtil.getParameter(request, prefix	+ "sto_to_dt", length));
			String[] fSelinputtype = (JSPUtil.getParameter(request, prefix	+ "f_selinputtype", length));
			String[] cntrFmMvmt = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_mvmt", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] comStsNo = (JSPUtil.getParameter(request, prefix	+ "com_sts_no", length));
			String[] cntrSts = (JSPUtil.getParameter(request, prefix	+ "cntr_sts", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] batDt = (JSPUtil.getParameter(request, prefix	+ "bat_dt", length));
			String[] chssFmDt = (JSPUtil.getParameter(request, prefix	+ "chss_fm_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fFmNod = (JSPUtil.getParameter(request, prefix	+ "f_fm_nod", length));
			String[] fFmyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_fmyearmonth", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssToMvmt = (JSPUtil.getParameter(request, prefix	+ "chss_to_mvmt", length));
			String[] cntrToNod = (JSPUtil.getParameter(request, prefix	+ "cntr_to_nod", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] stoSts = (JSPUtil.getParameter(request, prefix	+ "sto_sts", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stoToNod = (JSPUtil.getParameter(request, prefix	+ "sto_to_nod", length));
			String[] cntrToDt = (JSPUtil.getParameter(request, prefix	+ "cntr_to_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrFmDt = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_dt", length));
			String[] chssSts = (JSPUtil.getParameter(request, prefix	+ "chss_sts", length));
			String[] chssFmMvmt = (JSPUtil.getParameter(request, prefix	+ "chss_fm_mvmt", length));
			String[] stoFmMvmt = (JSPUtil.getParameter(request, prefix	+ "sto_fm_mvmt", length));
			String[] cntrToMvmt = (JSPUtil.getParameter(request, prefix	+ "cntr_to_mvmt", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] stoFmDt = (JSPUtil.getParameter(request, prefix	+ "sto_fm_dt", length));
			String[] chssToNod = (JSPUtil.getParameter(request, prefix	+ "chss_to_nod", length));
			String[] chssToDt = (JSPUtil.getParameter(request, prefix	+ "chss_to_dt", length));
			String[] cntrFmNod = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_nod", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fToyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_toyearmonth", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fCntrno = (JSPUtil.getParameter(request, prefix	+ "f_cntrno", length));
			String[] fBkgno = (JSPUtil.getParameter(request, prefix	+ "f_bkgno", length));
			String[] stoToMvmt = (JSPUtil.getParameter(request, prefix	+ "sto_to_mvmt", length));
			String[] stoFmNod = (JSPUtil.getParameter(request, prefix	+ "sto_fm_nod", length));
			String[] fStoCntrChss = (JSPUtil.getParameter(request, prefix	+ "f_sto_cntr_chss", length));
			String[] chssFmNod = (JSPUtil.getParameter(request, prefix	+ "chss_fm_nod", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemDetCostDayBatRstVO();
				if (bkgBnd[i] != null)
					model.setBkgBnd(bkgBnd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (stoToDt[i] != null)
					model.setStoToDt(stoToDt[i]);
				if (fSelinputtype[i] != null)
					model.setFSelinputtype(fSelinputtype[i]);
				if (cntrFmMvmt[i] != null)
					model.setCntrFmMvmt(cntrFmMvmt[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (comStsNo[i] != null)
					model.setComStsNo(comStsNo[i]);
				if (cntrSts[i] != null)
					model.setCntrSts(cntrSts[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (batDt[i] != null)
					model.setBatDt(batDt[i]);
				if (chssFmDt[i] != null)
					model.setChssFmDt(chssFmDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fFmNod[i] != null)
					model.setFFmNod(fFmNod[i]);
				if (fFmyearmonth[i] != null)
					model.setFFmyearmonth(fFmyearmonth[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssToMvmt[i] != null)
					model.setChssToMvmt(chssToMvmt[i]);
				if (cntrToNod[i] != null)
					model.setCntrToNod(cntrToNod[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (stoSts[i] != null)
					model.setStoSts(stoSts[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stoToNod[i] != null)
					model.setStoToNod(stoToNod[i]);
				if (cntrToDt[i] != null)
					model.setCntrToDt(cntrToDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrFmDt[i] != null)
					model.setCntrFmDt(cntrFmDt[i]);
				if (chssSts[i] != null)
					model.setChssSts(chssSts[i]);
				if (chssFmMvmt[i] != null)
					model.setChssFmMvmt(chssFmMvmt[i]);
				if (stoFmMvmt[i] != null)
					model.setStoFmMvmt(stoFmMvmt[i]);
				if (cntrToMvmt[i] != null)
					model.setCntrToMvmt(cntrToMvmt[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (stoFmDt[i] != null)
					model.setStoFmDt(stoFmDt[i]);
				if (chssToNod[i] != null)
					model.setChssToNod(chssToNod[i]);
				if (chssToDt[i] != null)
					model.setChssToDt(chssToDt[i]);
				if (cntrFmNod[i] != null)
					model.setCntrFmNod(cntrFmNod[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fToyearmonth[i] != null)
					model.setFToyearmonth(fToyearmonth[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fCntrno[i] != null)
					model.setFCntrno(fCntrno[i]);
				if (fBkgno[i] != null)
					model.setFBkgno(fBkgno[i]);
				if (stoToMvmt[i] != null)
					model.setStoToMvmt(stoToMvmt[i]);
				if (stoFmNod[i] != null)
					model.setStoFmNod(stoFmNod[i]);
				if (fStoCntrChss[i] != null)
					model.setFStoCntrChss(fStoCntrChss[i]);
				if (chssFmNod[i] != null)
					model.setChssFmNod(chssFmNod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemDetCostDayBatRstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemDetCostDayBatRstVO[]
	 */
	public DemDetCostDayBatRstVO[] getDemDetCostDayBatRstVOs(){
		DemDetCostDayBatRstVO[] vos = (DemDetCostDayBatRstVO[])models.toArray(new DemDetCostDayBatRstVO[models.size()]);
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
		this.bkgBnd = this.bkgBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoToDt = this.stoToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelinputtype = this.fSelinputtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmMvmt = this.cntrFmMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comStsNo = this.comStsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSts = this.cntrSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batDt = this.batDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssFmDt = this.chssFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmNod = this.fFmNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmyearmonth = this.fFmyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssToMvmt = this.chssToMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToNod = this.cntrToNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoSts = this.stoSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoToNod = this.stoToNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToDt = this.cntrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmDt = this.cntrFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssSts = this.chssSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssFmMvmt = this.chssFmMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFmMvmt = this.stoFmMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToMvmt = this.cntrToMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFmDt = this.stoFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssToNod = this.chssToNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssToDt = this.chssToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmNod = this.cntrFmNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToyearmonth = this.fToyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrno = this.fCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgno = this.fBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoToMvmt = this.stoToMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFmNod = this.stoFmNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStoCntrChss = this.fStoCntrChss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssFmNod = this.chssFmNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
