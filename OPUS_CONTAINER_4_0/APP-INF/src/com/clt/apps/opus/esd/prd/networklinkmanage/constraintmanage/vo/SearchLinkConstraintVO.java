/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchLinkConstraintVO.java
 *@FileTitle : SearchLinkConstraintVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.19 김귀진 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLinkConstraintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchLinkConstraintVO> models = new ArrayList<SearchLinkConstraintVO>();

	/* Column Info */
	private String effToDate = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String effFmDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lnkOrgNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String sEffFm = null;
	/* Column Info */
	private String lnkCnstRmk = null;
	/* Column Info */
	private String pctlCnstItmNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String sNodeFm = null;
	/* Column Info */
	private String sCntrType = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sRemark = null;
	/* Column Info */
	private String sOrgItemCode = null;
	/* Column Info */
	private String lnkDestNodCd = null;
	/* Column Info */
	private String sEffTo = null;
	/* Column Info */
	private String sSvcFlg = null;
	/* Column Info */
	private String lnkCnstItmCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String sTsMode = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sLnkCnstSeq = null;
	/* Column Info */
	private String sItemCode = null;
	/* Column Info */
	private String svcUseFlg = null;
	/* Column Info */
	private String sItemName = null;
	/* Column Info */
	private String sCommodityCode = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String sNodeTo = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Column Info */
	private String cntrSzCd = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchLinkConstraintVO() {
	}

	public SearchLinkConstraintVO(String ibflag, String pagerows, String lnkOrgNodCd, String lnkDestNodCd, String trspModCd, String lnkCnstItmCd, String pctlCnstItmNm, String lnkCnstRmk, String svcUseFlg, String cntrTpCd, String effFmDt, String effToDt, String creDt, String creOfcCd,
			String creUsrId, String sLnkCnstSeq, String cmdtCd, String cmdtNm, String sNodeFm, String sNodeTo, String sTsMode, String sItemCode, String sItemName, String sSvcFlg, String sRemark, String sOrgItemCode, String sCntrType, String sEffFm, String sEffTo, String sCommodityCode,
			String updUsrId, String effFmDate, String effToDate, String spclCgoCntrTpCd, String cntrSzCd) {
		this.effToDate = effToDate;
		this.creDt = creDt;
		this.trspModCd = trspModCd;
		this.effFmDate = effFmDate;
		this.pagerows = pagerows;
		this.lnkOrgNodCd = lnkOrgNodCd;
		this.ibflag = ibflag;
		this.cntrTpCd = cntrTpCd;
		this.sEffFm = sEffFm;
		this.lnkCnstRmk = lnkCnstRmk;
		this.pctlCnstItmNm = pctlCnstItmNm;
		this.cmdtCd = cmdtCd;
		this.creOfcCd = creOfcCd;
		this.effFmDt = effFmDt;
		this.sNodeFm = sNodeFm;
		this.sCntrType = sCntrType;
		this.updUsrId = updUsrId;
		this.sRemark = sRemark;
		this.sOrgItemCode = sOrgItemCode;
		this.lnkDestNodCd = lnkDestNodCd;
		this.sEffTo = sEffTo;
		this.sSvcFlg = sSvcFlg;
		this.lnkCnstItmCd = lnkCnstItmCd;
		this.cmdtNm = cmdtNm;
		this.sTsMode = sTsMode;
		this.creUsrId = creUsrId;
		this.sLnkCnstSeq = sLnkCnstSeq;
		this.sItemCode = sItemCode;
		this.svcUseFlg = svcUseFlg;
		this.sItemName = sItemName;
		this.sCommodityCode = sCommodityCode;
		this.effToDt = effToDt;
		this.sNodeTo = sNodeTo;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.cntrSzCd = cntrSzCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("eff_to_date", getEffToDate());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("eff_fm_date", getEffFmDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lnk_org_nod_cd", getLnkOrgNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("s_eff_fm", getSEffFm());
		this.hashColumns.put("lnk_cnst_rmk", getLnkCnstRmk());
		this.hashColumns.put("pctl_cnst_itm_nm", getPctlCnstItmNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("s_node_fm", getSNodeFm());
		this.hashColumns.put("s_cntr_type", getSCntrType());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_remark", getSRemark());
		this.hashColumns.put("s_org_item_code", getSOrgItemCode());
		this.hashColumns.put("lnk_dest_nod_cd", getLnkDestNodCd());
		this.hashColumns.put("s_eff_to", getSEffTo());
		this.hashColumns.put("s_svc_flg", getSSvcFlg());
		this.hashColumns.put("lnk_cnst_itm_cd", getLnkCnstItmCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("s_ts_mode", getSTsMode());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_lnk_cnst_seq", getSLnkCnstSeq());
		this.hashColumns.put("s_item_code", getSItemCode());
		this.hashColumns.put("svc_use_flg", getSvcUseFlg());
		this.hashColumns.put("s_item_name", getSItemName());
		this.hashColumns.put("s_commodity_code", getSCommodityCode());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("s_node_to", getSNodeTo());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("eff_to_date", "effToDate");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("eff_fm_date", "effFmDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lnk_org_nod_cd", "lnkOrgNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("s_eff_fm", "sEffFm");
		this.hashFields.put("lnk_cnst_rmk", "lnkCnstRmk");
		this.hashFields.put("pctl_cnst_itm_nm", "pctlCnstItmNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("s_node_fm", "sNodeFm");
		this.hashFields.put("s_cntr_type", "sCntrType");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_remark", "sRemark");
		this.hashFields.put("s_org_item_code", "sOrgItemCode");
		this.hashFields.put("lnk_dest_nod_cd", "lnkDestNodCd");
		this.hashFields.put("s_eff_to", "sEffTo");
		this.hashFields.put("s_svc_flg", "sSvcFlg");
		this.hashFields.put("lnk_cnst_itm_cd", "lnkCnstItmCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("s_ts_mode", "sTsMode");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_lnk_cnst_seq", "sLnkCnstSeq");
		this.hashFields.put("s_item_code", "sItemCode");
		this.hashFields.put("svc_use_flg", "svcUseFlg");
		this.hashFields.put("s_item_name", "sItemName");
		this.hashFields.put("s_commodity_code", "sCommodityCode");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("s_node_to", "sNodeTo");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return effToDate
	 */
	public String getEffToDate() {
		return this.effToDate;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}

	/**
	 * Column Info
	 * 
	 * @return effFmDate
	 */
	public String getEffFmDate() {
		return this.effFmDate;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return lnkOrgNodCd
	 */
	public String getLnkOrgNodCd() {
		return this.lnkOrgNodCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return sEffFm
	 */
	public String getSEffFm() {
		return this.sEffFm;
	}

	/**
	 * Column Info
	 * 
	 * @return lnkCnstRmk
	 */
	public String getLnkCnstRmk() {
		return this.lnkCnstRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return pctlCnstItmNm
	 */
	public String getPctlCnstItmNm() {
		return this.pctlCnstItmNm;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}

	/**
	 * Column Info
	 * 
	 * @return sNodeFm
	 */
	public String getSNodeFm() {
		return this.sNodeFm;
	}

	/**
	 * Column Info
	 * 
	 * @return sCntrType
	 */
	public String getSCntrType() {
		return this.sCntrType;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return sRemark
	 */
	public String getSRemark() {
		return this.sRemark;
	}

	/**
	 * Column Info
	 * 
	 * @return sOrgItemCode
	 */
	public String getSOrgItemCode() {
		return this.sOrgItemCode;
	}

	/**
	 * Column Info
	 * 
	 * @return lnkDestNodCd
	 */
	public String getLnkDestNodCd() {
		return this.lnkDestNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return sEffTo
	 */
	public String getSEffTo() {
		return this.sEffTo;
	}

	/**
	 * Column Info
	 * 
	 * @return sSvcFlg
	 */
	public String getSSvcFlg() {
		return this.sSvcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return lnkCnstItmCd
	 */
	public String getLnkCnstItmCd() {
		return this.lnkCnstItmCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}

	/**
	 * Column Info
	 * 
	 * @return sTsMode
	 */
	public String getSTsMode() {
		return this.sTsMode;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return sLnkCnstSeq
	 */
	public String getSLnkCnstSeq() {
		return this.sLnkCnstSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return sItemCode
	 */
	public String getSItemCode() {
		return this.sItemCode;
	}

	/**
	 * Column Info
	 * 
	 * @return svcUseFlg
	 */
	public String getSvcUseFlg() {
		return this.svcUseFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return sItemName
	 */
	public String getSItemName() {
		return this.sItemName;
	}

	/**
	 * Column Info
	 * 
	 * @return sCommodityCode
	 */
	public String getSCommodityCode() {
		return this.sCommodityCode;
	}

	/**
	 * Column Info
	 * 
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}

	/**
	 * Column Info
	 * 
	 * @return sNodeTo
	 */
	public String getSNodeTo() {
		return this.sNodeTo;
	}

	/**
	 * Column Info
	 * 
	 * @param effToDate
	 */
	public void setEffToDate(String effToDate) {
		this.effToDate = effToDate;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}

	/**
	 * Column Info
	 * 
	 * @param effFmDate
	 */
	public void setEffFmDate(String effFmDate) {
		this.effFmDate = effFmDate;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param lnkOrgNodCd
	 */
	public void setLnkOrgNodCd(String lnkOrgNodCd) {
		this.lnkOrgNodCd = lnkOrgNodCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param sEffFm
	 */
	public void setSEffFm(String sEffFm) {
		this.sEffFm = sEffFm;
	}

	/**
	 * Column Info
	 * 
	 * @param lnkCnstRmk
	 */
	public void setLnkCnstRmk(String lnkCnstRmk) {
		this.lnkCnstRmk = lnkCnstRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param pctlCnstItmNm
	 */
	public void setPctlCnstItmNm(String pctlCnstItmNm) {
		this.pctlCnstItmNm = pctlCnstItmNm;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}

	/**
	 * Column Info
	 * 
	 * @param sNodeFm
	 */
	public void setSNodeFm(String sNodeFm) {
		this.sNodeFm = sNodeFm;
	}

	/**
	 * Column Info
	 * 
	 * @param sCntrType
	 */
	public void setSCntrType(String sCntrType) {
		this.sCntrType = sCntrType;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param sRemark
	 */
	public void setSRemark(String sRemark) {
		this.sRemark = sRemark;
	}

	/**
	 * Column Info
	 * 
	 * @param sOrgItemCode
	 */
	public void setSOrgItemCode(String sOrgItemCode) {
		this.sOrgItemCode = sOrgItemCode;
	}

	/**
	 * Column Info
	 * 
	 * @param lnkDestNodCd
	 */
	public void setLnkDestNodCd(String lnkDestNodCd) {
		this.lnkDestNodCd = lnkDestNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param sEffTo
	 */
	public void setSEffTo(String sEffTo) {
		this.sEffTo = sEffTo;
	}

	/**
	 * Column Info
	 * 
	 * @param sSvcFlg
	 */
	public void setSSvcFlg(String sSvcFlg) {
		this.sSvcFlg = sSvcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param lnkCnstItmCd
	 */
	public void setLnkCnstItmCd(String lnkCnstItmCd) {
		this.lnkCnstItmCd = lnkCnstItmCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}

	/**
	 * Column Info
	 * 
	 * @param sTsMode
	 */
	public void setSTsMode(String sTsMode) {
		this.sTsMode = sTsMode;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param sLnkCnstSeq
	 */
	public void setSLnkCnstSeq(String sLnkCnstSeq) {
		this.sLnkCnstSeq = sLnkCnstSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param sItemCode
	 */
	public void setSItemCode(String sItemCode) {
		this.sItemCode = sItemCode;
	}

	/**
	 * Column Info
	 * 
	 * @param svcUseFlg
	 */
	public void setSvcUseFlg(String svcUseFlg) {
		this.svcUseFlg = svcUseFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param sItemName
	 */
	public void setSItemName(String sItemName) {
		this.sItemName = sItemName;
	}

	/**
	 * Column Info
	 * 
	 * @param sCommodityCode
	 */
	public void setSCommodityCode(String sCommodityCode) {
		this.sCommodityCode = sCommodityCode;
	}

	/**
	 * Column Info
	 * 
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}

	/**
	 * Column Info
	 * 
	 * @param sNodeTo
	 */
	public void setSNodeTo(String sNodeTo) {
		this.sNodeTo = sNodeTo;
	}

	public String getSpclCgoCntrTpCd() {
		return spclCgoCntrTpCd;
	}

	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	public String getCntrSzCd() {
		return cntrSzCd;
	}

	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEffToDate(JSPUtil.getParameter(request, "eff_to_date", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setEffFmDate(JSPUtil.getParameter(request, "eff_fm_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLnkOrgNodCd(JSPUtil.getParameter(request, "lnk_org_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setSEffFm(JSPUtil.getParameter(request, "s_eff_fm", ""));
		setLnkCnstRmk(JSPUtil.getParameter(request, "lnk_cnst_rmk", ""));
		setPctlCnstItmNm(JSPUtil.getParameter(request, "pctl_cnst_itm_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, "eff_fm_dt", ""));
		setSNodeFm(JSPUtil.getParameter(request, "s_node_fm", ""));
		setSCntrType(JSPUtil.getParameter(request, "s_cntr_type", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSRemark(JSPUtil.getParameter(request, "s_remark", ""));
		setSOrgItemCode(JSPUtil.getParameter(request, "s_org_item_code", ""));
		setLnkDestNodCd(JSPUtil.getParameter(request, "lnk_dest_nod_cd", ""));
		setSEffTo(JSPUtil.getParameter(request, "s_eff_to", ""));
		setSSvcFlg(JSPUtil.getParameter(request, "s_svc_flg", ""));
		setLnkCnstItmCd(JSPUtil.getParameter(request, "lnk_cnst_itm_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setSTsMode(JSPUtil.getParameter(request, "s_ts_mode", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSLnkCnstSeq(JSPUtil.getParameter(request, "s_lnk_cnst_seq", ""));
		setSItemCode(JSPUtil.getParameter(request, "s_item_code", ""));
		setSvcUseFlg(JSPUtil.getParameter(request, "svc_use_flg", ""));
		setSItemName(JSPUtil.getParameter(request, "s_item_name", ""));
		setSCommodityCode(JSPUtil.getParameter(request, "s_commodity_code", ""));
		setEffToDt(JSPUtil.getParameter(request, "eff_to_dt", ""));
		setSNodeTo(JSPUtil.getParameter(request, "s_node_to", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, "spcl_cgo_cntr_tp_cd", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SearchLinkConstraintVO[]
	 */
	public SearchLinkConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SearchLinkConstraintVO[]
	 */
	public SearchLinkConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLinkConstraintVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] effToDate = (JSPUtil.getParameter(request, prefix + "eff_to_date", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix + "trsp_mod_cd", length));
			String[] effFmDate = (JSPUtil.getParameter(request, prefix + "eff_fm_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] lnkOrgNodCd = (JSPUtil.getParameter(request, prefix + "lnk_org_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix + "cntr_tp_cd", length));
			String[] sEffFm = (JSPUtil.getParameter(request, prefix + "s_eff_fm", length));
			String[] lnkCnstRmk = (JSPUtil.getParameter(request, prefix + "lnk_cnst_rmk", length));
			String[] pctlCnstItmNm = (JSPUtil.getParameter(request, prefix + "pctl_cnst_itm_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix + "eff_fm_dt", length));
			String[] sNodeFm = (JSPUtil.getParameter(request, prefix + "s_node_fm", length));
			String[] sCntrType = (JSPUtil.getParameter(request, prefix + "s_cntr_type", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] sRemark = (JSPUtil.getParameter(request, prefix + "s_remark", length));
			String[] sOrgItemCode = (JSPUtil.getParameter(request, prefix + "s_org_item_code", length));
			String[] lnkDestNodCd = (JSPUtil.getParameter(request, prefix + "lnk_dest_nod_cd", length));
			String[] sEffTo = (JSPUtil.getParameter(request, prefix + "s_eff_to", length));
			String[] sSvcFlg = (JSPUtil.getParameter(request, prefix + "s_svc_flg", length));
			String[] lnkCnstItmCd = (JSPUtil.getParameter(request, prefix + "lnk_cnst_itm_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
			String[] sTsMode = (JSPUtil.getParameter(request, prefix + "s_ts_mode", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] sLnkCnstSeq = (JSPUtil.getParameter(request, prefix + "s_lnk_cnst_seq", length));
			String[] sItemCode = (JSPUtil.getParameter(request, prefix + "s_item_code", length));
			String[] svcUseFlg = (JSPUtil.getParameter(request, prefix + "svc_use_flg", length));
			String[] sItemName = (JSPUtil.getParameter(request, prefix + "s_item_name", length));
			String[] sCommodityCode = (JSPUtil.getParameter(request, prefix + "s_commodity_code", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix + "eff_to_dt", length));
			String[] sNodeTo = (JSPUtil.getParameter(request, prefix + "s_node_to", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix + "cntr_sz_cd", length));
			for (int i = 0; i < length; i++) {
				model = new SearchLinkConstraintVO();
				if (effToDate[i] != null)
					model.setEffToDate(effToDate[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (effFmDate[i] != null)
					model.setEffFmDate(effFmDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lnkOrgNodCd[i] != null)
					model.setLnkOrgNodCd(lnkOrgNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (sEffFm[i] != null)
					model.setSEffFm(sEffFm[i]);
				if (lnkCnstRmk[i] != null)
					model.setLnkCnstRmk(lnkCnstRmk[i]);
				if (pctlCnstItmNm[i] != null)
					model.setPctlCnstItmNm(pctlCnstItmNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (sNodeFm[i] != null)
					model.setSNodeFm(sNodeFm[i]);
				if (sCntrType[i] != null)
					model.setSCntrType(sCntrType[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sRemark[i] != null)
					model.setSRemark(sRemark[i]);
				if (sOrgItemCode[i] != null)
					model.setSOrgItemCode(sOrgItemCode[i]);
				if (lnkDestNodCd[i] != null)
					model.setLnkDestNodCd(lnkDestNodCd[i]);
				if (sEffTo[i] != null)
					model.setSEffTo(sEffTo[i]);
				if (sSvcFlg[i] != null)
					model.setSSvcFlg(sSvcFlg[i]);
				if (lnkCnstItmCd[i] != null)
					model.setLnkCnstItmCd(lnkCnstItmCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (sTsMode[i] != null)
					model.setSTsMode(sTsMode[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sLnkCnstSeq[i] != null)
					model.setSLnkCnstSeq(sLnkCnstSeq[i]);
				if (sItemCode[i] != null)
					model.setSItemCode(sItemCode[i]);
				if (svcUseFlg[i] != null)
					model.setSvcUseFlg(svcUseFlg[i]);
				if (sItemName[i] != null)
					model.setSItemName(sItemName[i]);
				if (sCommodityCode[i] != null)
					model.setSCommodityCode(sCommodityCode[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (sNodeTo[i] != null)
					model.setSNodeTo(sNodeTo[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLinkConstraintVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return SearchLinkConstraintVO[]
	 */
	public SearchLinkConstraintVO[] getSearchLinkConstraintVOs() {
		SearchLinkConstraintVO[] vos = (SearchLinkConstraintVO[]) models.toArray(new SearchLinkConstraintVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.effToDate = this.effToDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDate = this.effFmDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgNodCd = this.lnkOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffFm = this.sEffFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkCnstRmk = this.lnkCnstRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlCnstItmNm = this.pctlCnstItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNodeFm = this.sNodeFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrType = this.sCntrType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRemark = this.sRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOrgItemCode = this.sOrgItemCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestNodCd = this.lnkDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffTo = this.sEffTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSvcFlg = this.sSvcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkCnstItmCd = this.lnkCnstItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTsMode = this.sTsMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLnkCnstSeq = this.sLnkCnstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sItemCode = this.sItemCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcUseFlg = this.svcUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sItemName = this.sItemName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCommodityCode = this.sCommodityCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNodeTo = this.sNodeTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
