/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeCreationVO.java
*@FileTitle : TermChangeCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.25 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TermChangeCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TermChangeCreationVO> models = new ArrayList<TermChangeCreationVO>();

	/* Column Info */
	private String cntrFullFlg = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String diFlag = null;
	/* Column Info */
	private String aftAgmtCtyCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String cntrMinOnhDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aftLstmCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String cntrPkupChgAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrPkupPsvAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrPkupNgvAmt = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String aftVndrSeq = null;
	/* Column Info */
	private String aftAgmtSeq = null;
	/* Column Info */
	private String curAgmtSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String curAgmtCtyCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diiFee = null;
	/* Column Info */
	private String lstStsYdCd = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String termCngSeq = null;
	/* Column Info */
	private String seqSet = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dirItchgVndrSeq = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String cntrStsSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String locCd  = null;
	/* Column Info */
	private String sccCd  = null;
	/* Column Info */
	private String eccCd  = null;
	/* Column Info */
	private String lccCd  = null;
	/* Column Info */
	private String rccCd  = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TermChangeCreationVO() {}

	public TermChangeCreationVO(String ibflag, String pagerows, String cntrStsSeq, String ydCd, String locCd, String sccCd, String eccCd, String lccCd, String rccCd, String delChk, String cnmvDt, String cntrNo, String cntrTpszCd, String lstStsYdCd, String cntrPkupChgAmt, String cntrPkupPsvAmt, String cntrPkupNgvAmt, String cntrMinOnhDys, String rntlChgFreeDys, String diiFee, String cntrStsCd, String onhDt, String cnmvStsCd, String cntrFullFlg, String rowSeq, String termCngSeq, String seqSet, String curAgmtCtyCd, String curAgmtSeq, String aftAgmtCtyCd, String aftAgmtSeq, String actDt, String diFlag, String aftLstmCd, String aftVndrSeq, String ofcCd, String dirItchgVndrSeq, String creUsrId, String updUsrId) {
		this.cntrFullFlg = cntrFullFlg;
		this.cntrStsCd = cntrStsCd;
		this.cnmvDt = cnmvDt;
		this.diFlag = diFlag;
		this.aftAgmtCtyCd = aftAgmtCtyCd;
		this.onhDt = onhDt;
		this.cntrMinOnhDys = cntrMinOnhDys;
		this.pagerows = pagerows;
		this.aftLstmCd = aftLstmCd;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.cntrPkupChgAmt = cntrPkupChgAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrPkupPsvAmt = cntrPkupPsvAmt;
		this.updUsrId = updUsrId;
		this.cntrPkupNgvAmt = cntrPkupNgvAmt;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.aftVndrSeq = aftVndrSeq;
		this.aftAgmtSeq = aftAgmtSeq;
		this.curAgmtSeq = curAgmtSeq;
		this.ofcCd = ofcCd;
		this.curAgmtCtyCd = curAgmtCtyCd;
		this.creUsrId = creUsrId;
		this.diiFee = diiFee;
		this.lstStsYdCd = lstStsYdCd;
		this.rowSeq = rowSeq;
		this.termCngSeq = termCngSeq;
		this.seqSet = seqSet;
		this.actDt = actDt;
		this.cntrNo = cntrNo;
		this.dirItchgVndrSeq = dirItchgVndrSeq;
		this.delChk = delChk;
		this.cntrStsSeq = cntrStsSeq;
		this.ydCd = ydCd;
		this.locCd = locCd;
		this.sccCd = sccCd;
		this.eccCd = eccCd;
		this.lccCd = lccCd;
		this.rccCd = rccCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("di_flag", getDiFlag());
		this.hashColumns.put("aft_agmt_cty_cd", getAftAgmtCtyCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("cntr_min_onh_dys", getCntrMinOnhDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aft_lstm_cd", getAftLstmCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("cntr_pkup_chg_amt", getCntrPkupChgAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_pkup_psv_amt", getCntrPkupPsvAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_pkup_ngv_amt", getCntrPkupNgvAmt());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("aft_vndr_seq", getAftVndrSeq());
		this.hashColumns.put("aft_agmt_seq", getAftAgmtSeq());
		this.hashColumns.put("cur_agmt_seq", getCurAgmtSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cur_agmt_cty_cd", getCurAgmtCtyCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dii_fee", getDiiFee());
		this.hashColumns.put("lst_sts_yd_cd", getLstStsYdCd());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("term_cng_seq", getTermCngSeq());
		this.hashColumns.put("seq_set", getSeqSet());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dir_itchg_vndr_seq", getDirItchgVndrSeq());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("rcc_cd", getRccCd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("di_flag", "diFlag");
		this.hashFields.put("aft_agmt_cty_cd", "aftAgmtCtyCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("cntr_min_onh_dys", "cntrMinOnhDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aft_lstm_cd", "aftLstmCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cntr_pkup_chg_amt", "cntrPkupChgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_pkup_psv_amt", "cntrPkupPsvAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_pkup_ngv_amt", "cntrPkupNgvAmt");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("aft_vndr_seq", "aftVndrSeq");
		this.hashFields.put("aft_agmt_seq", "aftAgmtSeq");
		this.hashFields.put("cur_agmt_seq", "curAgmtSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cur_agmt_cty_cd", "curAgmtCtyCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dii_fee", "diiFee");
		this.hashFields.put("lst_sts_yd_cd", "lstStsYdCd");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("seq_set", "seqSet");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dir_itchg_vndr_seq", "dirItchgVndrSeq");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("rcc_cd", "rccCd");

		return this.hashFields;
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
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}

	/**
	 * Column Info
	 * @return diFlag
	 */
	public String getDiFlag() {
		return this.diFlag;
	}

	/**
	 * Column Info
	 * @return aftAgmtCtyCd
	 */
	public String getAftAgmtCtyCd() {
		return this.aftAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return aftLstmCd
	 */
	public String getAftLstmCd() {
		return this.aftLstmCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return cntrPkupPsvAmt
	 */
	public String getCntrPkupPsvAmt() {
		return this.cntrPkupPsvAmt;
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
	 * @return cntrPkupNgvAmt
	 */
	public String getCntrPkupNgvAmt() {
		return this.cntrPkupNgvAmt;
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
	 * @return aftVndrSeq
	 */
	public String getAftVndrSeq() {
		return this.aftVndrSeq;
	}

	/**
	 * Column Info
	 * @return aftAgmtSeq
	 */
	public String getAftAgmtSeq() {
		return this.aftAgmtSeq;
	}

	/**
	 * Column Info
	 * @return curAgmtSeq
	 */
	public String getCurAgmtSeq() {
		return this.curAgmtSeq;
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
	 * @return curAgmtCtyCd
	 */
	public String getCurAgmtCtyCd() {
		return this.curAgmtCtyCd;
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
	 * @return diiFee
	 */
	public String getDiiFee() {
		return this.diiFee;
	}

	/**
	 * Column Info
	 * @return lstStsYdCd
	 */
	public String getLstStsYdCd() {
		return this.lstStsYdCd;
	}

	/**
	 * Column Info
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
	}

	/**
	 * Column Info
	 * @return termCngSeq
	 */
	public String getTermCngSeq() {
		return this.termCngSeq;
	}

	/**
	 * Column Info
	 * @return seqSet
	 */
	public String getSeqSet() {
		return this.seqSet;
	}

	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
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
	 * @param cntrFullFlg
	 */
	public void setCntrFullFlg(String cntrFullFlg) {
		this.cntrFullFlg = cntrFullFlg;
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
	 * @param diFlag
	 */
	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}

	/**
	 * Column Info
	 * @param aftAgmtCtyCd
	 */
	public void setAftAgmtCtyCd(String aftAgmtCtyCd) {
		this.aftAgmtCtyCd = aftAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param aftLstmCd
	 */
	public void setAftLstmCd(String aftLstmCd) {
		this.aftLstmCd = aftLstmCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param cntrPkupPsvAmt
	 */
	public void setCntrPkupPsvAmt(String cntrPkupPsvAmt) {
		this.cntrPkupPsvAmt = cntrPkupPsvAmt;
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
	 * @param cntrPkupNgvAmt
	 */
	public void setCntrPkupNgvAmt(String cntrPkupNgvAmt) {
		this.cntrPkupNgvAmt = cntrPkupNgvAmt;
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
	 * @param aftVndrSeq
	 */
	public void setAftVndrSeq(String aftVndrSeq) {
		this.aftVndrSeq = aftVndrSeq;
	}

	/**
	 * Column Info
	 * @param aftAgmtSeq
	 */
	public void setAftAgmtSeq(String aftAgmtSeq) {
		this.aftAgmtSeq = aftAgmtSeq;
	}

	/**
	 * Column Info
	 * @param curAgmtSeq
	 */
	public void setCurAgmtSeq(String curAgmtSeq) {
		this.curAgmtSeq = curAgmtSeq;
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
	 * @param curAgmtCtyCd
	 */
	public void setCurAgmtCtyCd(String curAgmtCtyCd) {
		this.curAgmtCtyCd = curAgmtCtyCd;
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
	 * @param diiFee
	 */
	public void setDiiFee(String diiFee) {
		this.diiFee = diiFee;
	}

	/**
	 * Column Info
	 * @param lstStsYdCd
	 */
	public void setLstStsYdCd(String lstStsYdCd) {
		this.lstStsYdCd = lstStsYdCd;
	}

	/**
	 * Column Info
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
	}

	/**
	 * Column Info
	 * @param termCngSeq
	 */
	public void setTermCngSeq(String termCngSeq) {
		this.termCngSeq = termCngSeq;
	}

	/**
	 * Column Info
	 * @param seqSet
	 */
	public void setSeqSet(String seqSet) {
		this.seqSet = seqSet;
	}

	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return the dirItchgVndrSeq
	 */
	public String getDirItchgVndrSeq() {
		return dirItchgVndrSeq;
	}

	/**
	 * @param dirItchgVndrSeq the dirItchgVndrSeq to set
	 */
	public void setDirItchgVndrSeq(String dirItchgVndrSeq) {
		this.dirItchgVndrSeq = dirItchgVndrSeq;
	}

	/**
	 * @return the cnmvDt
	 */
	public String getCnmvDt() {
		return cnmvDt;
	}

	/**
	 * @param cnmvDt the cnmvDt to set
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}

	/**
	 * @return the delChk
	 */
	public String getDelChk() {
		return delChk;
	}

	/**
	 * @param delChk the delChk to set
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}

	/**
	 * @return the cntrStsSeq
	 */
	public String getCntrStsSeq() {
		return cntrStsSeq;
	}

	/**
	 * @param cntrStsSeq the cntrStsSeq to set
	 */
	public void setCntrStsSeq(String cntrStsSeq) {
		this.cntrStsSeq = cntrStsSeq;
	}

	/**
	 * @return the ydCd
	 */
	public String getYdCd() {
		return ydCd;
	}

	/**
	 * @param ydCd the ydCd to set
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}

	/**
	 * @param locCd the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * @return the sccCd
	 */
	public String getSccCd() {
		return sccCd;
	}

	/**
	 * @param sccCd the sccCd to set
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * @return the eccCd
	 */
	public String getEccCd() {
		return eccCd;
	}

	/**
	 * @param eccCd the eccCd to set
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}

	/**
	 * @return the lccCd
	 */
	public String getLccCd() {
		return lccCd;
	}

	/**
	 * @param lccCd the lccCd to set
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}

	/**
	 * @return the rccCd
	 */
	public String getRccCd() {
		return rccCd;
	}

	/**
	 * @param rccCd the rccCd to set
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrFullFlg(JSPUtil.getParameter(request, "cntr_full_flg", ""));
		setCntrStsCd(JSPUtil.getParameter(request, "cntr_sts_cd", ""));
		setDiFlag(JSPUtil.getParameter(request, "di_flag", ""));
		setAftAgmtCtyCd(JSPUtil.getParameter(request, "aft_agmt_cty_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setCntrMinOnhDys(JSPUtil.getParameter(request, "cntr_min_onh_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAftLstmCd(JSPUtil.getParameter(request, "aft_lstm_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setCntrPkupChgAmt(JSPUtil.getParameter(request, "cntr_pkup_chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrPkupPsvAmt(JSPUtil.getParameter(request, "cntr_pkup_psv_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntrPkupNgvAmt(JSPUtil.getParameter(request, "cntr_pkup_ngv_amt", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request, "rntl_chg_free_dys", ""));
		setAftVndrSeq(JSPUtil.getParameter(request, "aft_vndr_seq", ""));
		setAftAgmtSeq(JSPUtil.getParameter(request, "aft_agmt_seq", ""));
		setCurAgmtSeq(JSPUtil.getParameter(request, "cur_agmt_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCurAgmtCtyCd(JSPUtil.getParameter(request, "cur_agmt_cty_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiiFee(JSPUtil.getParameter(request, "dii_fee", ""));
		setLstStsYdCd(JSPUtil.getParameter(request, "lst_sts_yd_cd", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setTermCngSeq(JSPUtil.getParameter(request, "term_cng_seq", ""));
		setSeqSet(JSPUtil.getParameter(request, "seq_set", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDirItchgVndrSeq(JSPUtil.getParameter(request, "dir_itchg_vndr_seq", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setCntrStsSeq(JSPUtil.getParameter(request, "cntr_sts_seq", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TermChangeCreationVO[]
	 */
	public TermChangeCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TermChangeCreationVO[]
	 */
	public TermChangeCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TermChangeCreationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrFullFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_full_flg", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] diFlag = (JSPUtil.getParameter(request, prefix	+ "di_flag", length));
			String[] aftAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "aft_agmt_cty_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] cntrMinOnhDys = (JSPUtil.getParameter(request, prefix	+ "cntr_min_onh_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aftLstmCd = (JSPUtil.getParameter(request, prefix	+ "aft_lstm_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] cntrPkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_chg_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrPkupPsvAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_psv_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrPkupNgvAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_ngv_amt", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] aftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "aft_vndr_seq", length));
			String[] aftAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "aft_agmt_seq", length));
			String[] curAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "cur_agmt_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] curAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "cur_agmt_cty_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diiFee = (JSPUtil.getParameter(request, prefix	+ "dii_fee", length));
			String[] lstStsYdCd = (JSPUtil.getParameter(request, prefix	+ "lst_sts_yd_cd", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] termCngSeq = (JSPUtil.getParameter(request, prefix	+ "term_cng_seq", length));
			String[] seqSet = (JSPUtil.getParameter(request, prefix	+ "seq_set", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dirItchgVndrSeq = (JSPUtil.getParameter(request, prefix	+ "dir_itchg_vndr_seq", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] cntrStsSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));

			for (int i = 0; i < length; i++) {
				model = new TermChangeCreationVO();
				if (cntrFullFlg[i] != null)
					model.setCntrFullFlg(cntrFullFlg[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (diFlag[i] != null)
					model.setDiFlag(diFlag[i]);
				if (aftAgmtCtyCd[i] != null)
					model.setAftAgmtCtyCd(aftAgmtCtyCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (cntrMinOnhDys[i] != null)
					model.setCntrMinOnhDys(cntrMinOnhDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aftLstmCd[i] != null)
					model.setAftLstmCd(aftLstmCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (cntrPkupChgAmt[i] != null)
					model.setCntrPkupChgAmt(cntrPkupChgAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrPkupPsvAmt[i] != null)
					model.setCntrPkupPsvAmt(cntrPkupPsvAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrPkupNgvAmt[i] != null)
					model.setCntrPkupNgvAmt(cntrPkupNgvAmt[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (aftVndrSeq[i] != null)
					model.setAftVndrSeq(aftVndrSeq[i]);
				if (aftAgmtSeq[i] != null)
					model.setAftAgmtSeq(aftAgmtSeq[i]);
				if (curAgmtSeq[i] != null)
					model.setCurAgmtSeq(curAgmtSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (curAgmtCtyCd[i] != null)
					model.setCurAgmtCtyCd(curAgmtCtyCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diiFee[i] != null)
					model.setDiiFee(diiFee[i]);
				if (lstStsYdCd[i] != null)
					model.setLstStsYdCd(lstStsYdCd[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (termCngSeq[i] != null)
					model.setTermCngSeq(termCngSeq[i]);
				if (seqSet[i] != null)
					model.setSeqSet(seqSet[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dirItchgVndrSeq[i] != null)
					model.setDirItchgVndrSeq(dirItchgVndrSeq[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (cntrStsSeq[i] != null)
					model.setCntrStsSeq(cntrStsSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTermChangeCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TermChangeCreationVO[]
	 */
	public TermChangeCreationVO[] getTermChangeCreationVOs(){
		TermChangeCreationVO[] vos = (TermChangeCreationVO[])models.toArray(new TermChangeCreationVO[models.size()]);
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
		this.cntrFullFlg = this.cntrFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFlag = this.diFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtCtyCd = this.aftAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMinOnhDys = this.cntrMinOnhDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftLstmCd = this.aftLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupChgAmt = this.cntrPkupChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupPsvAmt = this.cntrPkupPsvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupNgvAmt = this.cntrPkupNgvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVndrSeq = this.aftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtSeq = this.aftAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAgmtSeq = this.curAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAgmtCtyCd = this.curAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diiFee = this.diiFee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsYdCd = this.lstStsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq = this.termCngSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqSet = this.seqSet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirItchgVndrSeq = this.dirItchgVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq = this.cntrStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
