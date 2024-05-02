/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrTtlLssRqstHdrVO.java
*@FileTitle : CustomMnrTtlLssRqstHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.15 박명신
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrTtlLssRqstHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CustomMnrTtlLssRqstHdrVO> models = new ArrayList<CustomMnrTtlLssRqstHdrVO>();

	/* Column Info */
	private String dvExp = null;
	/* Column Info */
	private String dsEqQty = null;
	/* Column Info */
	private String irDvVal = null;
	/* Column Info */
	private String dvEqQty = null;
	/* Column Info */
	private String ttlLssNo = null;
	/* Column Info */
	private String dsExp = null;
	/* Column Info */
	private String mnrStsRefNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String tpDvVal = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlLssCfmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dsDvVal = null;
	/* Column Info */
	private String tpEqQty = null;
	/* Column Info */
	private String ttlLssIssDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlLssCfmId = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String scExp = null;
	/* Column Info */
	private String scDvVal = null;
	/* Column Info */
	private String tpExp = null;
	/* Column Info */
	private String ttlLssDtlRsnNm = null;
	/* Column Info */
	private String dsVal = null;
	/* Column Info */
	private String irEqQty = null;
	/* Column Info */
	private String tpBal = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dvBal = null;
	/* Column Info */
	private String irVal = null;
	/* Column Info */
	private String scEqQty = null;
	/* Column Info */
	private String scVal = null;
	/* Column Info */
	private String irExp = null;
	/* Column Info */
	private String ttlLssDt = null;
	/* Column Info */
	private String ttlLssRmk = null;
	/* Column Info */
	private String ttlLssDtlRsnCd = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String ttlLssRsnCd = null;
	/* Column Info */
	private String ttlLssStsCd = null;
	/* Column Info */
	private String respbOfcNm = null;
	/* Column Info */
	private String dvDvVal = null;
	/* Column Info */
	private String searchTtlLssNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public CustomMnrTtlLssRqstHdrVO() {}

	public CustomMnrTtlLssRqstHdrVO(String ibflag, String pagerows, String dvExp, String dsEqQty, String irDvVal, String dsExp, String ttlLssNo, String dvEqQty, String mnrStsRefNo, String creDt, String aproOfcCd, String tpDvVal, String ttlLssCfmDt, String dsDvVal, String tpEqQty, String ttlLssIssDt, String updUsrId, String updDt, String ttlLssCfmId, String rqstDt, String scExp, String scDvVal, String tpExp, String ttlLssDtlRsnNm, String dsVal, String irEqQty, String tpBal, String creUsrId, String irVal, String dvBal, String irExp, String scVal, String scEqQty, String ttlLssDt, String rqstOfcCd, String ttlLssDtlRsnCd, String ttlLssRmk, String fileSeq, String ttlLssRsnCd, String respbOfcCd, String respbOfcNm, String ttlLssStsCd, String searchTtlLssNo, String dvDvVal) {
		this.dvExp = dvExp;
		this.dsEqQty = dsEqQty;
		this.irDvVal = irDvVal;
		this.dvEqQty = dvEqQty;
		this.ttlLssNo = ttlLssNo;
		this.dsExp = dsExp;
		this.mnrStsRefNo = mnrStsRefNo;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.tpDvVal = tpDvVal;
		this.pagerows = pagerows;
		this.ttlLssCfmDt = ttlLssCfmDt;
		this.ibflag = ibflag;
		this.dsDvVal = dsDvVal;
		this.tpEqQty = tpEqQty;
		this.ttlLssIssDt = ttlLssIssDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ttlLssCfmId = ttlLssCfmId;
		this.rqstDt = rqstDt;
		this.scExp = scExp;
		this.scDvVal = scDvVal;
		this.tpExp = tpExp;
		this.ttlLssDtlRsnNm = ttlLssDtlRsnNm;
		this.dsVal = dsVal;
		this.irEqQty = irEqQty;
		this.tpBal = tpBal;
		this.creUsrId = creUsrId;
		this.dvBal = dvBal;
		this.irVal = irVal;
		this.scEqQty = scEqQty;
		this.scVal = scVal;
		this.irExp = irExp;
		this.ttlLssDt = ttlLssDt;
		this.ttlLssRmk = ttlLssRmk;
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
		this.rqstOfcCd = rqstOfcCd;
		this.fileSeq = fileSeq;
		this.respbOfcCd = respbOfcCd;
		this.ttlLssRsnCd = ttlLssRsnCd;
		this.ttlLssStsCd = ttlLssStsCd;
		this.respbOfcNm = respbOfcNm;
		this.dvDvVal = dvDvVal;
		this.searchTtlLssNo = searchTtlLssNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dv_exp", getDvExp());
		this.hashColumns.put("ds_eq_qty", getDsEqQty());
		this.hashColumns.put("ir_dv_val", getIrDvVal());
		this.hashColumns.put("dv_eq_qty", getDvEqQty());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("ds_exp", getDsExp());
		this.hashColumns.put("mnr_sts_ref_no", getMnrStsRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("tp_dv_val", getTpDvVal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_lss_cfm_dt", getTtlLssCfmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ds_dv_val", getDsDvVal());
		this.hashColumns.put("tp_eq_qty", getTpEqQty());
		this.hashColumns.put("ttl_lss_iss_dt", getTtlLssIssDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_lss_cfm_id", getTtlLssCfmId());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("sc_exp", getScExp());
		this.hashColumns.put("sc_dv_val", getScDvVal());
		this.hashColumns.put("tp_exp", getTpExp());
		this.hashColumns.put("ttl_lss_dtl_rsn_nm", getTtlLssDtlRsnNm());
		this.hashColumns.put("ds_val", getDsVal());
		this.hashColumns.put("ir_eq_qty", getIrEqQty());
		this.hashColumns.put("tp_bal", getTpBal());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dv_bal", getDvBal());
		this.hashColumns.put("ir_val", getIrVal());
		this.hashColumns.put("sc_eq_qty", getScEqQty());
		this.hashColumns.put("sc_val", getScVal());
		this.hashColumns.put("ir_exp", getIrExp());
		this.hashColumns.put("ttl_lss_dt", getTtlLssDt());
		this.hashColumns.put("ttl_lss_rmk", getTtlLssRmk());
		this.hashColumns.put("ttl_lss_dtl_rsn_cd", getTtlLssDtlRsnCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("ttl_lss_rsn_cd", getTtlLssRsnCd());
		this.hashColumns.put("ttl_lss_sts_cd", getTtlLssStsCd());
		this.hashColumns.put("respb_ofc_nm", getRespbOfcNm());
		this.hashColumns.put("dv_dv_val", getDvDvVal());
		this.hashColumns.put("search_ttl_lss_no", getSearchTtlLssNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dv_exp", "dvExp");
		this.hashFields.put("ds_eq_qty", "dsEqQty");
		this.hashFields.put("ir_dv_val", "irDvVal");
		this.hashFields.put("dv_eq_qty", "dvEqQty");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("ds_exp", "dsExp");
		this.hashFields.put("mnr_sts_ref_no", "mnrStsRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("tp_dv_val", "tpDvVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_lss_cfm_dt", "ttlLssCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ds_dv_val", "dsDvVal");
		this.hashFields.put("tp_eq_qty", "tpEqQty");
		this.hashFields.put("ttl_lss_iss_dt", "ttlLssIssDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_lss_cfm_id", "ttlLssCfmId");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("sc_exp", "scExp");
		this.hashFields.put("sc_dv_val", "scDvVal");
		this.hashFields.put("tp_exp", "tpExp");
		this.hashFields.put("ttl_lss_dtl_rsn_nm", "ttlLssDtlRsnNm");
		this.hashFields.put("ds_val", "dsVal");
		this.hashFields.put("ir_eq_qty", "irEqQty");
		this.hashFields.put("tp_bal", "tpBal");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dv_bal", "dvBal");
		this.hashFields.put("ir_val", "irVal");
		this.hashFields.put("sc_eq_qty", "scEqQty");
		this.hashFields.put("sc_val", "scVal");
		this.hashFields.put("ir_exp", "irExp");
		this.hashFields.put("ttl_lss_dt", "ttlLssDt");
		this.hashFields.put("ttl_lss_rmk", "ttlLssRmk");
		this.hashFields.put("ttl_lss_dtl_rsn_cd", "ttlLssDtlRsnCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("ttl_lss_rsn_cd", "ttlLssRsnCd");
		this.hashFields.put("ttl_lss_sts_cd", "ttlLssStsCd");
		this.hashFields.put("respb_ofc_nm", "respbOfcNm");
		this.hashFields.put("dv_dv_val", "dvDvVal");
		this.hashFields.put("search_ttl_lss_no", "searchTtlLssNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return dvExp
	 */
	public String getDvExp() {
		return this.dvExp;
	}

	/**
	 * Column Info
	 * @return dsEqQty
	 */
	public String getDsEqQty() {
		return this.dsEqQty;
	}

	/**
	 * Column Info
	 * @return irDvVal
	 */
	public String getIrDvVal() {
		return this.irDvVal;
	}

	/**
	 * Column Info
	 * @return dvEqQty
	 */
	public String getDvEqQty() {
		return this.dvEqQty;
	}

	/**
	 * Column Info
	 * @return ttlLssNo
	 */
	public String getTtlLssNo() {
		return this.ttlLssNo;
	}

	/**
	 * Column Info
	 * @return dsExp
	 */
	public String getDsExp() {
		return this.dsExp;
	}

	/**
	 * Column Info
	 * @return mnrStsRefNo
	 */
	public String getMnrStsRefNo() {
		return this.mnrStsRefNo;
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
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}

	/**
	 * Column Info
	 * @return tpDvVal
	 */
	public String getTpDvVal() {
		return this.tpDvVal;
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
	 * @return ttlLssCfmDt
	 */
	public String getTtlLssCfmDt() {
		return this.ttlLssCfmDt;
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
	 * @return dsDvVal
	 */
	public String getDsDvVal() {
		return this.dsDvVal;
	}

	/**
	 * Column Info
	 * @return tpEqQty
	 */
	public String getTpEqQty() {
		return this.tpEqQty;
	}

	/**
	 * Column Info
	 * @return ttlLssIssDt
	 */
	public String getTtlLssIssDt() {
		return this.ttlLssIssDt;
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
	 * @return ttlLssCfmId
	 */
	public String getTtlLssCfmId() {
		return this.ttlLssCfmId;
	}

	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}

	/**
	 * Column Info
	 * @return scExp
	 */
	public String getScExp() {
		return this.scExp;
	}

	/**
	 * Column Info
	 * @return scDvVal
	 */
	public String getScDvVal() {
		return this.scDvVal;
	}

	/**
	 * Column Info
	 * @return tpExp
	 */
	public String getTpExp() {
		return this.tpExp;
	}

	/**
	 * Column Info
	 * @return ttlLssDtlRsnNm
	 */
	public String getTtlLssDtlRsnNm() {
		return this.ttlLssDtlRsnNm;
	}

	/**
	 * Column Info
	 * @return dsVal
	 */
	public String getDsVal() {
		return this.dsVal;
	}

	/**
	 * Column Info
	 * @return irEqQty
	 */
	public String getIrEqQty() {
		return this.irEqQty;
	}

	/**
	 * Column Info
	 * @return tpBal
	 */
	public String getTpBal() {
		return this.tpBal;
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
	 * @return dvBal
	 */
	public String getDvBal() {
		return this.dvBal;
	}

	/**
	 * Column Info
	 * @return irVal
	 */
	public String getIrVal() {
		return this.irVal;
	}

	/**
	 * Column Info
	 * @return scEqQty
	 */
	public String getScEqQty() {
		return this.scEqQty;
	}

	/**
	 * Column Info
	 * @return scVal
	 */
	public String getScVal() {
		return this.scVal;
	}

	/**
	 * Column Info
	 * @return irExp
	 */
	public String getIrExp() {
		return this.irExp;
	}

	/**
	 * Column Info
	 * @return ttlLssDt
	 */
	public String getTtlLssDt() {
		return this.ttlLssDt;
	}

	/**
	 * Column Info
	 * @return ttlLssRmk
	 */
	public String getTtlLssRmk() {
		return this.ttlLssRmk;
	}

	/**
	 * Column Info
	 * @return ttlLssDtlRsnCd
	 */
	public String getTtlLssDtlRsnCd() {
		return this.ttlLssDtlRsnCd;
	}

	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
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
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}

	/**
	 * Column Info
	 * @return ttlLssRsnCd
	 */
	public String getTtlLssRsnCd() {
		return this.ttlLssRsnCd;
	}

	/**
	 * Column Info
	 * @return ttlLssStsCd
	 */
	public String getTtlLssStsCd() {
		return this.ttlLssStsCd;
	}

	/**
	 * Column Info
	 * @return respbOfcNm
	 */
	public String getRespbOfcNm() {
		return this.respbOfcNm;
	}

	/**
	 * Column Info
	 * @return dvDvVal
	 */
	public String getDvDvVal() {
		return this.dvDvVal;
	}

	/**
	 * Column Info
	 * @return searchTtlLssNo
	 */
	public String getSearchTtlLssNo() {
		return this.searchTtlLssNo;
	}


	/**
	 * Column Info
	 * @param dvExp
	 */
	public void setDvExp(String dvExp) {
		this.dvExp = dvExp;
	}

	/**
	 * Column Info
	 * @param dsEqQty
	 */
	public void setDsEqQty(String dsEqQty) {
		this.dsEqQty = dsEqQty;
	}

	/**
	 * Column Info
	 * @param irDvVal
	 */
	public void setIrDvVal(String irDvVal) {
		this.irDvVal = irDvVal;
	}

	/**
	 * Column Info
	 * @param dvEqQty
	 */
	public void setDvEqQty(String dvEqQty) {
		this.dvEqQty = dvEqQty;
	}

	/**
	 * Column Info
	 * @param ttlLssNo
	 */
	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}

	/**
	 * Column Info
	 * @param dsExp
	 */
	public void setDsExp(String dsExp) {
		this.dsExp = dsExp;
	}

	/**
	 * Column Info
	 * @param mnrStsRefNo
	 */
	public void setMnrStsRefNo(String mnrStsRefNo) {
		this.mnrStsRefNo = mnrStsRefNo;
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
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}

	/**
	 * Column Info
	 * @param tpDvVal
	 */
	public void setTpDvVal(String tpDvVal) {
		this.tpDvVal = tpDvVal;
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
	 * @param ttlLssCfmDt
	 */
	public void setTtlLssCfmDt(String ttlLssCfmDt) {
		this.ttlLssCfmDt = ttlLssCfmDt;
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
	 * @param dsDvVal
	 */
	public void setDsDvVal(String dsDvVal) {
		this.dsDvVal = dsDvVal;
	}

	/**
	 * Column Info
	 * @param tpEqQty
	 */
	public void setTpEqQty(String tpEqQty) {
		this.tpEqQty = tpEqQty;
	}

	/**
	 * Column Info
	 * @param ttlLssIssDt
	 */
	public void setTtlLssIssDt(String ttlLssIssDt) {
		this.ttlLssIssDt = ttlLssIssDt;
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
	 * @param ttlLssCfmId
	 */
	public void setTtlLssCfmId(String ttlLssCfmId) {
		this.ttlLssCfmId = ttlLssCfmId;
	}

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	/**
	 * Column Info
	 * @param scExp
	 */
	public void setScExp(String scExp) {
		this.scExp = scExp;
	}

	/**
	 * Column Info
	 * @param scDvVal
	 */
	public void setScDvVal(String scDvVal) {
		this.scDvVal = scDvVal;
	}

	/**
	 * Column Info
	 * @param tpExp
	 */
	public void setTpExp(String tpExp) {
		this.tpExp = tpExp;
	}

	/**
	 * Column Info
	 * @param ttlLssDtlRsnNm
	 */
	public void setTtlLssDtlRsnNm(String ttlLssDtlRsnNm) {
		this.ttlLssDtlRsnNm = ttlLssDtlRsnNm;
	}

	/**
	 * Column Info
	 * @param dsVal
	 */
	public void setDsVal(String dsVal) {
		this.dsVal = dsVal;
	}

	/**
	 * Column Info
	 * @param irEqQty
	 */
	public void setIrEqQty(String irEqQty) {
		this.irEqQty = irEqQty;
	}

	/**
	 * Column Info
	 * @param tpBal
	 */
	public void setTpBal(String tpBal) {
		this.tpBal = tpBal;
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
	 * @param dvBal
	 */
	public void setDvBal(String dvBal) {
		this.dvBal = dvBal;
	}

	/**
	 * Column Info
	 * @param irVal
	 */
	public void setIrVal(String irVal) {
		this.irVal = irVal;
	}

	/**
	 * Column Info
	 * @param scEqQty
	 */
	public void setScEqQty(String scEqQty) {
		this.scEqQty = scEqQty;
	}

	/**
	 * Column Info
	 * @param scVal
	 */
	public void setScVal(String scVal) {
		this.scVal = scVal;
	}

	/**
	 * Column Info
	 * @param irExp
	 */
	public void setIrExp(String irExp) {
		this.irExp = irExp;
	}

	/**
	 * Column Info
	 * @param ttlLssDt
	 */
	public void setTtlLssDt(String ttlLssDt) {
		this.ttlLssDt = ttlLssDt;
	}

	/**
	 * Column Info
	 * @param ttlLssRmk
	 */
	public void setTtlLssRmk(String ttlLssRmk) {
		this.ttlLssRmk = ttlLssRmk;
	}

	/**
	 * Column Info
	 * @param ttlLssDtlRsnCd
	 */
	public void setTtlLssDtlRsnCd(String ttlLssDtlRsnCd) {
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
	}

	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
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
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}

	/**
	 * Column Info
	 * @param ttlLssRsnCd
	 */
	public void setTtlLssRsnCd(String ttlLssRsnCd) {
		this.ttlLssRsnCd = ttlLssRsnCd;
	}

	/**
	 * Column Info
	 * @param ttlLssStsCd
	 */
	public void setTtlLssStsCd(String ttlLssStsCd) {
		this.ttlLssStsCd = ttlLssStsCd;
	}

	/**
	 * Column Info
	 * @param respbOfcNm
	 */
	public void setRespbOfcNm(String respbOfcNm) {
		this.respbOfcNm = respbOfcNm;
	}

	/**
	 * Column Info
	 * @param dvDvVal
	 */
	public void setDvDvVal(String dvDvVal) {
		this.dvDvVal = dvDvVal;
	}

	/**
	 * Column Info
	 * @param searchTtlLssNo
	 */
	public void setSearchTtlLssNo(String searchTtlLssNo) {
		this.searchTtlLssNo = searchTtlLssNo;
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
		setDvExp(JSPUtil.getParameter(request, prefix + "dv_exp", ""));
		setDsEqQty(JSPUtil.getParameter(request, prefix + "ds_eq_qty", ""));
		setIrDvVal(JSPUtil.getParameter(request, prefix + "ir_dv_val", ""));
		setDvEqQty(JSPUtil.getParameter(request, prefix + "dv_eq_qty", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setDsExp(JSPUtil.getParameter(request, prefix + "ds_exp", ""));
		setMnrStsRefNo(JSPUtil.getParameter(request, prefix + "mnr_sts_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setTpDvVal(JSPUtil.getParameter(request, prefix + "tp_dv_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlLssCfmDt(JSPUtil.getParameter(request, prefix + "ttl_lss_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDsDvVal(JSPUtil.getParameter(request, prefix + "ds_dv_val", ""));
		setTpEqQty(JSPUtil.getParameter(request, prefix + "tp_eq_qty", ""));
		setTtlLssIssDt(JSPUtil.getParameter(request, prefix + "ttl_lss_iss_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlLssCfmId(JSPUtil.getParameter(request, prefix + "ttl_lss_cfm_id", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setScExp(JSPUtil.getParameter(request, prefix + "sc_exp", ""));
		setScDvVal(JSPUtil.getParameter(request, prefix + "sc_dv_val", ""));
		setTpExp(JSPUtil.getParameter(request, prefix + "tp_exp", ""));
		setTtlLssDtlRsnNm(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_nm", ""));
		setDsVal(JSPUtil.getParameter(request, prefix + "ds_val", ""));
		setIrEqQty(JSPUtil.getParameter(request, prefix + "ir_eq_qty", ""));
		setTpBal(JSPUtil.getParameter(request, prefix + "tp_bal", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDvBal(JSPUtil.getParameter(request, prefix + "dv_bal", ""));
		setIrVal(JSPUtil.getParameter(request, prefix + "ir_val", ""));
		setScEqQty(JSPUtil.getParameter(request, prefix + "sc_eq_qty", ""));
		setScVal(JSPUtil.getParameter(request, prefix + "sc_val", ""));
		setIrExp(JSPUtil.getParameter(request, prefix + "ir_exp", ""));
		setTtlLssDt(JSPUtil.getParameter(request, prefix + "ttl_lss_dt", ""));
		setTtlLssRmk(JSPUtil.getParameter(request, prefix + "ttl_lss_rmk", ""));
		setTtlLssDtlRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setTtlLssRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_rsn_cd", ""));
		setTtlLssStsCd(JSPUtil.getParameter(request, prefix + "ttl_lss_sts_cd", ""));
		setRespbOfcNm(JSPUtil.getParameter(request, prefix + "respb_ofc_nm", ""));
		setDvDvVal(JSPUtil.getParameter(request, prefix + "dv_dv_val", ""));
		setSearchTtlLssNo(JSPUtil.getParameter(request, prefix + "search_ttl_lss_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrTtlLssRqstHdrVO[]
	 */
	public CustomMnrTtlLssRqstHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrTtlLssRqstHdrVO[]
	 */
	public CustomMnrTtlLssRqstHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrTtlLssRqstHdrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dvExp = (JSPUtil.getParameter(request, prefix	+ "dv_exp", length));
			String[] dsEqQty = (JSPUtil.getParameter(request, prefix	+ "ds_eq_qty", length));
			String[] irDvVal = (JSPUtil.getParameter(request, prefix	+ "ir_dv_val", length));
			String[] dvEqQty = (JSPUtil.getParameter(request, prefix	+ "dv_eq_qty", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] dsExp = (JSPUtil.getParameter(request, prefix	+ "ds_exp", length));
			String[] mnrStsRefNo = (JSPUtil.getParameter(request, prefix	+ "mnr_sts_ref_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] tpDvVal = (JSPUtil.getParameter(request, prefix	+ "tp_dv_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlLssCfmDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dsDvVal = (JSPUtil.getParameter(request, prefix	+ "ds_dv_val", length));
			String[] tpEqQty = (JSPUtil.getParameter(request, prefix	+ "tp_eq_qty", length));
			String[] ttlLssIssDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_iss_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlLssCfmId = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_id", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] scExp = (JSPUtil.getParameter(request, prefix	+ "sc_exp", length));
			String[] scDvVal = (JSPUtil.getParameter(request, prefix	+ "sc_dv_val", length));
			String[] tpExp = (JSPUtil.getParameter(request, prefix	+ "tp_exp", length));
			String[] ttlLssDtlRsnNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_nm", length));
			String[] dsVal = (JSPUtil.getParameter(request, prefix	+ "ds_val", length));
			String[] irEqQty = (JSPUtil.getParameter(request, prefix	+ "ir_eq_qty", length));
			String[] tpBal = (JSPUtil.getParameter(request, prefix	+ "tp_bal", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dvBal = (JSPUtil.getParameter(request, prefix	+ "dv_bal", length));
			String[] irVal = (JSPUtil.getParameter(request, prefix	+ "ir_val", length));
			String[] scEqQty = (JSPUtil.getParameter(request, prefix	+ "sc_eq_qty", length));
			String[] scVal = (JSPUtil.getParameter(request, prefix	+ "sc_val", length));
			String[] irExp = (JSPUtil.getParameter(request, prefix	+ "ir_exp", length));
			String[] ttlLssDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dt", length));
			String[] ttlLssRmk = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rmk", length));
			String[] ttlLssDtlRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_cd", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] ttlLssRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rsn_cd", length));
			String[] ttlLssStsCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_sts_cd", length));
			String[] respbOfcNm = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_nm", length));
			String[] dvDvVal = (JSPUtil.getParameter(request, prefix	+ "dv_dv_val", length));
			String[] searchTtlLssNo = (JSPUtil.getParameter(request, prefix	+ "search_ttl_lss_no", length));

			for (int i = 0; i < length; i++) {
				model = new CustomMnrTtlLssRqstHdrVO();
				if (dvExp[i] != null)
					model.setDvExp(dvExp[i]);
				if (dsEqQty[i] != null)
					model.setDsEqQty(dsEqQty[i]);
				if (irDvVal[i] != null)
					model.setIrDvVal(irDvVal[i]);
				if (dvEqQty[i] != null)
					model.setDvEqQty(dvEqQty[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (dsExp[i] != null)
					model.setDsExp(dsExp[i]);
				if (mnrStsRefNo[i] != null)
					model.setMnrStsRefNo(mnrStsRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (tpDvVal[i] != null)
					model.setTpDvVal(tpDvVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlLssCfmDt[i] != null)
					model.setTtlLssCfmDt(ttlLssCfmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dsDvVal[i] != null)
					model.setDsDvVal(dsDvVal[i]);
				if (tpEqQty[i] != null)
					model.setTpEqQty(tpEqQty[i]);
				if (ttlLssIssDt[i] != null)
					model.setTtlLssIssDt(ttlLssIssDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlLssCfmId[i] != null)
					model.setTtlLssCfmId(ttlLssCfmId[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (scExp[i] != null)
					model.setScExp(scExp[i]);
				if (scDvVal[i] != null)
					model.setScDvVal(scDvVal[i]);
				if (tpExp[i] != null)
					model.setTpExp(tpExp[i]);
				if (ttlLssDtlRsnNm[i] != null)
					model.setTtlLssDtlRsnNm(ttlLssDtlRsnNm[i]);
				if (dsVal[i] != null)
					model.setDsVal(dsVal[i]);
				if (irEqQty[i] != null)
					model.setIrEqQty(irEqQty[i]);
				if (tpBal[i] != null)
					model.setTpBal(tpBal[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dvBal[i] != null)
					model.setDvBal(dvBal[i]);
				if (irVal[i] != null)
					model.setIrVal(irVal[i]);
				if (scEqQty[i] != null)
					model.setScEqQty(scEqQty[i]);
				if (scVal[i] != null)
					model.setScVal(scVal[i]);
				if (irExp[i] != null)
					model.setIrExp(irExp[i]);
				if (ttlLssDt[i] != null)
					model.setTtlLssDt(ttlLssDt[i]);
				if (ttlLssRmk[i] != null)
					model.setTtlLssRmk(ttlLssRmk[i]);
				if (ttlLssDtlRsnCd[i] != null)
					model.setTtlLssDtlRsnCd(ttlLssDtlRsnCd[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (ttlLssRsnCd[i] != null)
					model.setTtlLssRsnCd(ttlLssRsnCd[i]);
				if (ttlLssStsCd[i] != null)
					model.setTtlLssStsCd(ttlLssStsCd[i]);
				if (respbOfcNm[i] != null)
					model.setRespbOfcNm(respbOfcNm[i]);
				if (dvDvVal[i] != null)
					model.setDvDvVal(dvDvVal[i]);
				if (searchTtlLssNo[i] != null)
					model.setSearchTtlLssNo(searchTtlLssNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrTtlLssRqstHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrTtlLssRqstHdrVO[]
	 */
	public CustomMnrTtlLssRqstHdrVO[] getCustomMnrTtlLssRqstHdrVOs(){
		CustomMnrTtlLssRqstHdrVO[] vos = (CustomMnrTtlLssRqstHdrVO[])models.toArray(new CustomMnrTtlLssRqstHdrVO[models.size()]);
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
		this.dvExp = this.dvExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEqQty = this.dsEqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDvVal = this.irDvVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvEqQty = this.dvEqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsExp = this.dsExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsRefNo = this.mnrStsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpDvVal = this.tpDvVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmDt = this.ttlLssCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsDvVal = this.dsDvVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpEqQty = this.tpEqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssIssDt = this.ttlLssIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmId = this.ttlLssCfmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExp = this.scExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scDvVal = this.scDvVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpExp = this.tpExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnNm = this.ttlLssDtlRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsVal = this.dsVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irEqQty = this.irEqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpBal = this.tpBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvBal = this.dvBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irVal = this.irVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scEqQty = this.scEqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scVal = this.scVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irExp = this.irExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDt = this.ttlLssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRmk = this.ttlLssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnCd = this.ttlLssDtlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnCd = this.ttlLssRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsCd = this.ttlLssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcNm = this.respbOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvDvVal = this.dvDvVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTtlLssNo = this.searchTtlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
