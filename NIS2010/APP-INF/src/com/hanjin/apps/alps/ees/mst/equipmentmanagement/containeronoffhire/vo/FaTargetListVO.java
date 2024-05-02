/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaTargetListVO.java
*@FileTitle : FaTargetListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.20 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FaTargetListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FaTargetListVO> models = new ArrayList<FaTargetListVO>();
	
	/* Column Info */
	private String cntrAqzAmt = null;
	/* Column Info */
	private String cntrSpecNo = null;
	/* Column Info */
	private String ieflg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lotPlnYr = null;
	/* Column Info */
	private String lotSeq = null;
	/* Column Info */
	private String ceflg = null;
	/* Column Info */
	private String lotLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ueflg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aeflg = null;
	/* Column Info */
	private String hidType = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String deflg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String acctQtyMzdCd = null;
	/* Column Info */
	private String lotNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String faIfGrpSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String serRange = null;
	/* Column Info */
	private String faIfTpCd = null;
	/* Column Info */
	private String deYrmon = null;
	/* Column Info */
	private String cntrCurrCd = null;
	/* Column Info */
	private String cntrInvstNo = null;
	/* Column Info */
	private String faIfGrpStsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String termCngSeq = null;
	/* Column Info */
	private String faIfDt = null;
	/* Column Info */
	private String beflg = null;
	/* Column Info */
	private String vndrAbbrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FaTargetListVO() {}

	public FaTargetListVO(String ibflag, String pagerows, String cntrAqzAmt, String cntrSpecNo, String creDt, String ieflg, String lotPlnYr, String lotSeq, String lotLocCd, String ceflg, String ueflg, String hidType, String aeflg, String agmtCtyCd, String cntrTpszCd, String cntrQty, String deflg, String updUsrId, String acctQtyMzdCd, String lotNo, String agmtSeq, String agmtNo, String serRange, String faIfTpCd, String deYrmon, String faIfGrpStsCd, String cntrInvstNo, String cntrCurrCd, String creUsrId, String termCngSeq, String faIfDt, String vndrAbbrNm, String beflg, String faIfGrpSeq) {
		this.cntrAqzAmt = cntrAqzAmt;
		this.cntrSpecNo = cntrSpecNo;
		this.ieflg = ieflg;
		this.creDt = creDt;
		this.lotPlnYr = lotPlnYr;
		this.lotSeq = lotSeq;
		this.ceflg = ceflg;
		this.lotLocCd = lotLocCd;
		this.pagerows = pagerows;
		this.ueflg = ueflg;
		this.ibflag = ibflag;
		this.aeflg = aeflg;
		this.hidType = hidType;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrQty = cntrQty;
		this.deflg = deflg;
		this.updUsrId = updUsrId;
		this.acctQtyMzdCd = acctQtyMzdCd;
		this.lotNo = lotNo;
		this.agmtSeq = agmtSeq;
		this.faIfGrpSeq = faIfGrpSeq;
		this.agmtNo = agmtNo;
		this.serRange = serRange;
		this.faIfTpCd = faIfTpCd;
		this.deYrmon = deYrmon;
		this.cntrCurrCd = cntrCurrCd;
		this.cntrInvstNo = cntrInvstNo;
		this.faIfGrpStsCd = faIfGrpStsCd;
		this.creUsrId = creUsrId;
		this.termCngSeq = termCngSeq;
		this.faIfDt = faIfDt;
		this.beflg = beflg;
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_aqz_amt", getCntrAqzAmt());
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		this.hashColumns.put("ieflg", getIeflg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());
		this.hashColumns.put("lot_seq", getLotSeq());
		this.hashColumns.put("ceflg", getCeflg());
		this.hashColumns.put("lot_loc_cd", getLotLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ueflg", getUeflg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aeflg", getAeflg());
		this.hashColumns.put("hid_type", getHidType());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("deflg", getDeflg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("acct_qty_mzd_cd", getAcctQtyMzdCd());
		this.hashColumns.put("lot_no", getLotNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("fa_if_grp_seq", getFaIfGrpSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ser_range", getSerRange());
		this.hashColumns.put("fa_if_tp_cd", getFaIfTpCd());
		this.hashColumns.put("de_yrmon", getDeYrmon());
		this.hashColumns.put("cntr_curr_cd", getCntrCurrCd());
		this.hashColumns.put("cntr_invst_no", getCntrInvstNo());
		this.hashColumns.put("fa_if_grp_sts_cd", getFaIfGrpStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("term_cng_seq", getTermCngSeq());
		this.hashColumns.put("fa_if_dt", getFaIfDt());
		this.hashColumns.put("beflg", getBeflg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_aqz_amt", "cntrAqzAmt");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("ieflg", "ieflg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ueflg", "ueflg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("hid_type", "hidType");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("acct_qty_mzd_cd", "acctQtyMzdCd");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("fa_if_grp_seq", "faIfGrpSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ser_range", "serRange");
		this.hashFields.put("fa_if_tp_cd", "faIfTpCd");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("cntr_curr_cd", "cntrCurrCd");
		this.hashFields.put("cntr_invst_no", "cntrInvstNo");
		this.hashFields.put("fa_if_grp_sts_cd", "faIfGrpStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("fa_if_dt", "faIfDt");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrAqzAmt
	 */
	public String getCntrAqzAmt() {
		return this.cntrAqzAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return this.cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @return ieflg
	 */
	public String getIeflg() {
		return this.ieflg;
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
	 * @return lotPlnYr
	 */
	public String getLotPlnYr() {
		return this.lotPlnYr;
	}
	
	/**
	 * Column Info
	 * @return lotSeq
	 */
	public String getLotSeq() {
		return this.lotSeq;
	}
	
	/**
	 * Column Info
	 * @return ceflg
	 */
	public String getCeflg() {
		return this.ceflg;
	}
	
	/**
	 * Column Info
	 * @return lotLocCd
	 */
	public String getLotLocCd() {
		return this.lotLocCd;
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
	 * @return ueflg
	 */
	public String getUeflg() {
		return this.ueflg;
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
	 * @return aeflg
	 */
	public String getAeflg() {
		return this.aeflg;
	}
	
	/**
	 * Column Info
	 * @return hidType
	 */
	public String getHidType() {
		return this.hidType;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return deflg
	 */
	public String getDeflg() {
		return this.deflg;
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
	 * @return acctQtyMzdCd
	 */
	public String getAcctQtyMzdCd() {
		return this.acctQtyMzdCd;
	}
	
	/**
	 * Column Info
	 * @return lotNo
	 */
	public String getLotNo() {
		return this.lotNo;
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
	 * @return faIfGrpSeq
	 */
	public String getFaIfGrpSeq() {
		return this.faIfGrpSeq;
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
	 * @return serRange
	 */
	public String getSerRange() {
		return this.serRange;
	}
	
	/**
	 * Column Info
	 * @return faIfTpCd
	 */
	public String getFaIfTpCd() {
		return this.faIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return deYrmon
	 */
	public String getDeYrmon() {
		return this.deYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntrCurrCd
	 */
	public String getCntrCurrCd() {
		return this.cntrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cntrInvstNo
	 */
	public String getCntrInvstNo() {
		return this.cntrInvstNo;
	}
	
	/**
	 * Column Info
	 * @return faIfGrpStsCd
	 */
	public String getFaIfGrpStsCd() {
		return this.faIfGrpStsCd;
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
	 * @return termCngSeq
	 */
	public String getTermCngSeq() {
		return this.termCngSeq;
	}
	
	/**
	 * Column Info
	 * @return faIfDt
	 */
	public String getFaIfDt() {
		return this.faIfDt;
	}
	
	/**
	 * Column Info
	 * @return beflg
	 */
	public String getBeflg() {
		return this.beflg;
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
	 * @param cntrAqzAmt
	 */
	public void setCntrAqzAmt(String cntrAqzAmt) {
		this.cntrAqzAmt = cntrAqzAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @param ieflg
	 */
	public void setIeflg(String ieflg) {
		this.ieflg = ieflg;
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
	 * @param lotPlnYr
	 */
	public void setLotPlnYr(String lotPlnYr) {
		this.lotPlnYr = lotPlnYr;
	}
	
	/**
	 * Column Info
	 * @param lotSeq
	 */
	public void setLotSeq(String lotSeq) {
		this.lotSeq = lotSeq;
	}
	
	/**
	 * Column Info
	 * @param ceflg
	 */
	public void setCeflg(String ceflg) {
		this.ceflg = ceflg;
	}
	
	/**
	 * Column Info
	 * @param lotLocCd
	 */
	public void setLotLocCd(String lotLocCd) {
		this.lotLocCd = lotLocCd;
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
	 * @param ueflg
	 */
	public void setUeflg(String ueflg) {
		this.ueflg = ueflg;
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
	 * @param aeflg
	 */
	public void setAeflg(String aeflg) {
		this.aeflg = aeflg;
	}
	
	/**
	 * Column Info
	 * @param hidType
	 */
	public void setHidType(String hidType) {
		this.hidType = hidType;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param deflg
	 */
	public void setDeflg(String deflg) {
		this.deflg = deflg;
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
	 * @param acctQtyMzdCd
	 */
	public void setAcctQtyMzdCd(String acctQtyMzdCd) {
		this.acctQtyMzdCd = acctQtyMzdCd;
	}
	
	/**
	 * Column Info
	 * @param lotNo
	 */
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
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
	 * @param faIfGrpSeq
	 */
	public void setFaIfGrpSeq(String faIfGrpSeq) {
		this.faIfGrpSeq = faIfGrpSeq;
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
	 * @param serRange
	 */
	public void setSerRange(String serRange) {
		this.serRange = serRange;
	}
	
	/**
	 * Column Info
	 * @param faIfTpCd
	 */
	public void setFaIfTpCd(String faIfTpCd) {
		this.faIfTpCd = faIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param deYrmon
	 */
	public void setDeYrmon(String deYrmon) {
		this.deYrmon = deYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntrCurrCd
	 */
	public void setCntrCurrCd(String cntrCurrCd) {
		this.cntrCurrCd = cntrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cntrInvstNo
	 */
	public void setCntrInvstNo(String cntrInvstNo) {
		this.cntrInvstNo = cntrInvstNo;
	}
	
	/**
	 * Column Info
	 * @param faIfGrpStsCd
	 */
	public void setFaIfGrpStsCd(String faIfGrpStsCd) {
		this.faIfGrpStsCd = faIfGrpStsCd;
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
	 * @param termCngSeq
	 */
	public void setTermCngSeq(String termCngSeq) {
		this.termCngSeq = termCngSeq;
	}
	
	/**
	 * Column Info
	 * @param faIfDt
	 */
	public void setFaIfDt(String faIfDt) {
		this.faIfDt = faIfDt;
	}
	
	/**
	 * Column Info
	 * @param beflg
	 */
	public void setBeflg(String beflg) {
		this.beflg = beflg;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrAqzAmt(JSPUtil.getParameter(request, "cntr_aqz_amt", ""));
		setCntrSpecNo(JSPUtil.getParameter(request, "cntr_spec_no", ""));
		setIeflg(JSPUtil.getParameter(request, "ieflg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setLotPlnYr(JSPUtil.getParameter(request, "lot_pln_yr", ""));
		setLotSeq(JSPUtil.getParameter(request, "lot_seq", ""));
		setCeflg(JSPUtil.getParameter(request, "ceflg", ""));
		setLotLocCd(JSPUtil.getParameter(request, "lot_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUeflg(JSPUtil.getParameter(request, "ueflg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAeflg(JSPUtil.getParameter(request, "aeflg", ""));
		setHidType(JSPUtil.getParameter(request, "hid_type", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setDeflg(JSPUtil.getParameter(request, "deflg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAcctQtyMzdCd(JSPUtil.getParameter(request, "acct_qty_mzd_cd", ""));
		setLotNo(JSPUtil.getParameter(request, "lot_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setFaIfGrpSeq(JSPUtil.getParameter(request, "fa_if_grp_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setSerRange(JSPUtil.getParameter(request, "ser_range", ""));
		setFaIfTpCd(JSPUtil.getParameter(request, "fa_if_tp_cd", ""));
		setDeYrmon(JSPUtil.getParameter(request, "de_yrmon", ""));
		setCntrCurrCd(JSPUtil.getParameter(request, "cntr_curr_cd", ""));
		setCntrInvstNo(JSPUtil.getParameter(request, "cntr_invst_no", ""));
		setFaIfGrpStsCd(JSPUtil.getParameter(request, "fa_if_grp_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTermCngSeq(JSPUtil.getParameter(request, "term_cng_seq", ""));
		setFaIfDt(JSPUtil.getParameter(request, "fa_if_dt", ""));
		setBeflg(JSPUtil.getParameter(request, "beflg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FaTargetListVO[]
	 */
	public FaTargetListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FaTargetListVO[]
	 */
	public FaTargetListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FaTargetListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrAqzAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_aqz_amt", length));
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no", length));
			String[] ieflg = (JSPUtil.getParameter(request, prefix	+ "ieflg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lotPlnYr = (JSPUtil.getParameter(request, prefix	+ "lot_pln_yr", length));
			String[] lotSeq = (JSPUtil.getParameter(request, prefix	+ "lot_seq", length));
			String[] ceflg = (JSPUtil.getParameter(request, prefix	+ "ceflg", length));
			String[] lotLocCd = (JSPUtil.getParameter(request, prefix	+ "lot_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ueflg = (JSPUtil.getParameter(request, prefix	+ "ueflg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aeflg = (JSPUtil.getParameter(request, prefix	+ "aeflg", length));
			String[] hidType = (JSPUtil.getParameter(request, prefix	+ "hid_type", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] deflg = (JSPUtil.getParameter(request, prefix	+ "deflg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] acctQtyMzdCd = (JSPUtil.getParameter(request, prefix	+ "acct_qty_mzd_cd", length));
			String[] lotNo = (JSPUtil.getParameter(request, prefix	+ "lot_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] faIfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "fa_if_grp_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] serRange = (JSPUtil.getParameter(request, prefix	+ "ser_range", length));
			String[] faIfTpCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_tp_cd", length));
			String[] deYrmon = (JSPUtil.getParameter(request, prefix	+ "de_yrmon", length));
			String[] cntrCurrCd = (JSPUtil.getParameter(request, prefix	+ "cntr_curr_cd", length));
			String[] cntrInvstNo = (JSPUtil.getParameter(request, prefix	+ "cntr_invst_no", length));
			String[] faIfGrpStsCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_grp_sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] termCngSeq = (JSPUtil.getParameter(request, prefix	+ "term_cng_seq", length));
			String[] faIfDt = (JSPUtil.getParameter(request, prefix	+ "fa_if_dt", length));
			String[] beflg = (JSPUtil.getParameter(request, prefix	+ "beflg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new FaTargetListVO();
				if (cntrAqzAmt[i] != null)
					model.setCntrAqzAmt(cntrAqzAmt[i]);
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if (ieflg[i] != null)
					model.setIeflg(ieflg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lotPlnYr[i] != null)
					model.setLotPlnYr(lotPlnYr[i]);
				if (lotSeq[i] != null)
					model.setLotSeq(lotSeq[i]);
				if (ceflg[i] != null)
					model.setCeflg(ceflg[i]);
				if (lotLocCd[i] != null)
					model.setLotLocCd(lotLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ueflg[i] != null)
					model.setUeflg(ueflg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aeflg[i] != null)
					model.setAeflg(aeflg[i]);
				if (hidType[i] != null)
					model.setHidType(hidType[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (deflg[i] != null)
					model.setDeflg(deflg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (acctQtyMzdCd[i] != null)
					model.setAcctQtyMzdCd(acctQtyMzdCd[i]);
				if (lotNo[i] != null)
					model.setLotNo(lotNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (faIfGrpSeq[i] != null)
					model.setFaIfGrpSeq(faIfGrpSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (serRange[i] != null)
					model.setSerRange(serRange[i]);
				if (faIfTpCd[i] != null)
					model.setFaIfTpCd(faIfTpCd[i]);
				if (deYrmon[i] != null)
					model.setDeYrmon(deYrmon[i]);
				if (cntrCurrCd[i] != null)
					model.setCntrCurrCd(cntrCurrCd[i]);
				if (cntrInvstNo[i] != null)
					model.setCntrInvstNo(cntrInvstNo[i]);
				if (faIfGrpStsCd[i] != null)
					model.setFaIfGrpStsCd(faIfGrpStsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (termCngSeq[i] != null)
					model.setTermCngSeq(termCngSeq[i]);
				if (faIfDt[i] != null)
					model.setFaIfDt(faIfDt[i]);
				if (beflg[i] != null)
					model.setBeflg(beflg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFaTargetListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FaTargetListVO[]
	 */
	public FaTargetListVO[] getFaTargetListVOs(){
		FaTargetListVO[] vos = (FaTargetListVO[])models.toArray(new FaTargetListVO[models.size()]);
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
		this.cntrAqzAmt = this.cntrAqzAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieflg = this.ieflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr = this.lotPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq = this.lotSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg = this.ceflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd = this.lotLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ueflg = this.ueflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg = this.aeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidType = this.hidType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deflg = this.deflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctQtyMzdCd = this.acctQtyMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo = this.lotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpSeq = this.faIfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serRange = this.serRange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfTpCd = this.faIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon = this.deYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCurrCd = this.cntrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInvstNo = this.cntrInvstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpStsCd = this.faIfGrpStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq = this.termCngSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfDt = this.faIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg = this.beflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
