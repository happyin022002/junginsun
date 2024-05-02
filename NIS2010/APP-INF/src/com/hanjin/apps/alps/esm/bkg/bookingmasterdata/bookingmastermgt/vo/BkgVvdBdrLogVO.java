/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgVvdBdrLogVO.java
*@FileTitle : BkgVvdBdrLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.17 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgVvdBdrLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgVvdBdrLogVO> models = new ArrayList<BkgVvdBdrLogVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String fdrBdrFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trnkMnlBdrFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String trnkBdrCreUsrId = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String fdrAutoBdrDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String fdrBdrCreUsrId = null;
	/* Column Info */
	private String fdrEstmBdrDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fdrAutoBdrFlg = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trnkBdrFlg = null;
	/* Column Info */
	private String fdrMnlBdrFlg = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chkFlg = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String slanTpCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String fdrBdrUpdDt = null;
	/* Column Info */
	private String trnkAutoBdrFlg = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String bdrVslChkFlg = null;
	/* Column Info */
	private String fdrMnlBdrDt = null;
	/* Column Info */
	private String trnkEstmBdrDt = null;
	/* Column Info */
	private String trnkAutoBdrDt = null;
	/* Column Info */
	private String trnkMnlBdrDt = null;

	/* Column Info */
	private String portSkdStsCd = null;
	/* Column Info */
	private String oResult = null;
	/* Column Info */
	private String oErrMsg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgVvdBdrLogVO() {}

	public BkgVvdBdrLogVO(String ibflag, String pagerows, String trnkAutoBdrFlg, String trnkAutoBdrDt, String trnkMnlBdrFlg, String trnkMnlBdrDt, String trnkBdrCreUsrId, String fdrBdrFlg, String fdrEstmBdrDt, String fdrAutoBdrFlg, String fdrAutoBdrDt, String fdrMnlBdrFlg, String fdrMnlBdrDt, String fdrBdrCreUsrId, String fdrBdrUpdDt, String bdrVslChkFlg, String creUsrId, String creDt, String updUsrId, String updDt, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String polClptIndSeq, String podClptIndSeq, String slanCd, String slanTpCd, String trnkBdrFlg, String trnkEstmBdrDt, String vslSlanCd, String skdStsCd, String clptIndSeq, String skdCngStsCd, String turnPortIndCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String vpsPortCd, String chkFlg, String portSkdStsCd, String oResult, String oErrMsg) {
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.fdrBdrFlg = fdrBdrFlg;
		this.creDt = creDt;
		this.trnkMnlBdrFlg = trnkMnlBdrFlg;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.skdStsCd = skdStsCd;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.trnkBdrCreUsrId = trnkBdrCreUsrId;
		this.vpsPortCd = vpsPortCd;
		this.fdrAutoBdrDt = fdrAutoBdrDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.polClptIndSeq = polClptIndSeq;
		this.fdrBdrCreUsrId = fdrBdrCreUsrId;
		this.fdrEstmBdrDt = fdrEstmBdrDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.fdrAutoBdrFlg = fdrAutoBdrFlg;
		this.vpsEtdDt = vpsEtdDt;
		this.trnkBdrFlg = trnkBdrFlg;
		this.fdrMnlBdrFlg = fdrMnlBdrFlg;
		this.podClptIndSeq = podClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.chkFlg = chkFlg;
		this.skdCngStsCd = skdCngStsCd;
		this.slanTpCd = slanTpCd;
		this.slanCd = slanCd;
		this.fdrBdrUpdDt = fdrBdrUpdDt;
		this.trnkAutoBdrFlg = trnkAutoBdrFlg;
		this.clptIndSeq = clptIndSeq;
		this.bdrVslChkFlg = bdrVslChkFlg;
		this.fdrMnlBdrDt = fdrMnlBdrDt;
		this.trnkEstmBdrDt = trnkEstmBdrDt;
		this.trnkAutoBdrDt = trnkAutoBdrDt;
		this.trnkMnlBdrDt = trnkMnlBdrDt;
		this.portSkdStsCd = portSkdStsCd;
		this.oResult = oResult;
		this.oErrMsg = oErrMsg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("fdr_bdr_flg", getFdrBdrFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trnk_mnl_bdr_flg", getTrnkMnlBdrFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_sts_cd", getSkdStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("trnk_bdr_cre_usr_id", getTrnkBdrCreUsrId());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("fdr_auto_bdr_dt", getFdrAutoBdrDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("fdr_bdr_cre_usr_id", getFdrBdrCreUsrId());
		this.hashColumns.put("fdr_estm_bdr_dt", getFdrEstmBdrDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fdr_auto_bdr_flg", getFdrAutoBdrFlg());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trnk_bdr_flg", getTrnkBdrFlg());
		this.hashColumns.put("fdr_mnl_bdr_flg", getFdrMnlBdrFlg());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chk_flg", getChkFlg());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("slan_tp_cd", getSlanTpCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("fdr_bdr_upd_dt", getFdrBdrUpdDt());
		this.hashColumns.put("trnk_auto_bdr_flg", getTrnkAutoBdrFlg());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("bdr_vsl_chk_flg", getBdrVslChkFlg());
		this.hashColumns.put("fdr_mnl_bdr_dt", getFdrMnlBdrDt());
		this.hashColumns.put("trnk_estm_bdr_dt", getTrnkEstmBdrDt());
		this.hashColumns.put("trnk_auto_bdr_dt", getTrnkAutoBdrDt());
		this.hashColumns.put("trnk_mnl_bdr_dt", getTrnkMnlBdrDt());
		
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("o_result", getOResult());
		this.hashColumns.put("o_err_msg", getOErrMsg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("fdr_bdr_flg", "fdrBdrFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trnk_mnl_bdr_flg", "trnkMnlBdrFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_sts_cd", "skdStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("trnk_bdr_cre_usr_id", "trnkBdrCreUsrId");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("fdr_auto_bdr_dt", "fdrAutoBdrDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("fdr_bdr_cre_usr_id", "fdrBdrCreUsrId");
		this.hashFields.put("fdr_estm_bdr_dt", "fdrEstmBdrDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fdr_auto_bdr_flg", "fdrAutoBdrFlg");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trnk_bdr_flg", "trnkBdrFlg");
		this.hashFields.put("fdr_mnl_bdr_flg", "fdrMnlBdrFlg");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("slan_tp_cd", "slanTpCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("fdr_bdr_upd_dt", "fdrBdrUpdDt");
		this.hashFields.put("trnk_auto_bdr_flg", "trnkAutoBdrFlg");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("bdr_vsl_chk_flg", "bdrVslChkFlg");
		this.hashFields.put("fdr_mnl_bdr_dt", "fdrMnlBdrDt");
		this.hashFields.put("trnk_estm_bdr_dt", "trnkEstmBdrDt");
		this.hashFields.put("trnk_auto_bdr_dt", "trnkAutoBdrDt");
		this.hashFields.put("trnk_mnl_bdr_dt", "trnkMnlBdrDt");
		
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("o_err_msg", "oErrMsg");
		this.hashFields.put("o_result", "oResult");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	public String getPortSkdStsCd() {
		return portSkdStsCd;
	}

	public void setPortSkdStsCd(String portSkdStsCd) {
		this.portSkdStsCd = portSkdStsCd;
	}

	public String getOResult() {
		return oResult;
	}

	public void setOResult(String result) {
		oResult = result;
	}

	public String getOErrMsg() {
		return oErrMsg;
	}

	public void setOErrMsg(String errMsg) {
		oErrMsg = errMsg;
	}

	/**
	 * Column Info
	 * @return fdrBdrFlg
	 */
	public String getFdrBdrFlg() {
		return this.fdrBdrFlg;
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
	 * @return trnkMnlBdrFlg
	 */
	public String getTrnkMnlBdrFlg() {
		return this.trnkMnlBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdStsCd
	 */
	public String getSkdStsCd() {
		return this.skdStsCd;
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
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @return trnkBdrCreUsrId
	 */
	public String getTrnkBdrCreUsrId() {
		return this.trnkBdrCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return fdrAutoBdrDt
	 */
	public String getFdrAutoBdrDt() {
		return this.fdrAutoBdrDt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return fdrBdrCreUsrId
	 */
	public String getFdrBdrCreUsrId() {
		return this.fdrBdrCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return fdrEstmBdrDt
	 */
	public String getFdrEstmBdrDt() {
		return this.fdrEstmBdrDt;
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
	 * @return fdrAutoBdrFlg
	 */
	public String getFdrAutoBdrFlg() {
		return this.fdrAutoBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return trnkBdrFlg
	 */
	public String getTrnkBdrFlg() {
		return this.trnkBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return fdrMnlBdrFlg
	 */
	public String getFdrMnlBdrFlg() {
		return this.fdrMnlBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return chkFlg
	 */
	public String getChkFlg() {
		return this.chkFlg;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @return slanTpCd
	 */
	public String getSlanTpCd() {
		return this.slanTpCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return fdrBdrUpdDt
	 */
	public String getFdrBdrUpdDt() {
		return this.fdrBdrUpdDt;
	}
	
	/**
	 * Column Info
	 * @return trnkAutoBdrFlg
	 */
	public String getTrnkAutoBdrFlg() {
		return this.trnkAutoBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return bdrVslChkFlg
	 */
	public String getBdrVslChkFlg() {
		return this.bdrVslChkFlg;
	}
	
	/**
	 * Column Info
	 * @return fdrMnlBdrDt
	 */
	public String getFdrMnlBdrDt() {
		return this.fdrMnlBdrDt;
	}
	
	/**
	 * Column Info
	 * @return trnkEstmBdrDt
	 */
	public String getTrnkEstmBdrDt() {
		return this.trnkEstmBdrDt;
	}
	
	/**
	 * Column Info
	 * @return trnkAutoBdrDt
	 */
	public String getTrnkAutoBdrDt() {
		return this.trnkAutoBdrDt;
	}
	
	/**
	 * Column Info
	 * @return trnkMnlBdrDt
	 */
	public String getTrnkMnlBdrDt() {
		return this.trnkMnlBdrDt;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param fdrBdrFlg
	 */
	public void setFdrBdrFlg(String fdrBdrFlg) {
		this.fdrBdrFlg = fdrBdrFlg;
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
	 * @param trnkMnlBdrFlg
	 */
	public void setTrnkMnlBdrFlg(String trnkMnlBdrFlg) {
		this.trnkMnlBdrFlg = trnkMnlBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdStsCd
	 */
	public void setSkdStsCd(String skdStsCd) {
		this.skdStsCd = skdStsCd;
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
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @param trnkBdrCreUsrId
	 */
	public void setTrnkBdrCreUsrId(String trnkBdrCreUsrId) {
		this.trnkBdrCreUsrId = trnkBdrCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param fdrAutoBdrDt
	 */
	public void setFdrAutoBdrDt(String fdrAutoBdrDt) {
		this.fdrAutoBdrDt = fdrAutoBdrDt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param fdrBdrCreUsrId
	 */
	public void setFdrBdrCreUsrId(String fdrBdrCreUsrId) {
		this.fdrBdrCreUsrId = fdrBdrCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param fdrEstmBdrDt
	 */
	public void setFdrEstmBdrDt(String fdrEstmBdrDt) {
		this.fdrEstmBdrDt = fdrEstmBdrDt;
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
	 * @param fdrAutoBdrFlg
	 */
	public void setFdrAutoBdrFlg(String fdrAutoBdrFlg) {
		this.fdrAutoBdrFlg = fdrAutoBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param trnkBdrFlg
	 */
	public void setTrnkBdrFlg(String trnkBdrFlg) {
		this.trnkBdrFlg = trnkBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param fdrMnlBdrFlg
	 */
	public void setFdrMnlBdrFlg(String fdrMnlBdrFlg) {
		this.fdrMnlBdrFlg = fdrMnlBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param chkFlg
	 */
	public void setChkFlg(String chkFlg) {
		this.chkFlg = chkFlg;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @param slanTpCd
	 */
	public void setSlanTpCd(String slanTpCd) {
		this.slanTpCd = slanTpCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param fdrBdrUpdDt
	 */
	public void setFdrBdrUpdDt(String fdrBdrUpdDt) {
		this.fdrBdrUpdDt = fdrBdrUpdDt;
	}
	
	/**
	 * Column Info
	 * @param trnkAutoBdrFlg
	 */
	public void setTrnkAutoBdrFlg(String trnkAutoBdrFlg) {
		this.trnkAutoBdrFlg = trnkAutoBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param bdrVslChkFlg
	 */
	public void setBdrVslChkFlg(String bdrVslChkFlg) {
		this.bdrVslChkFlg = bdrVslChkFlg;
	}
	
	/**
	 * Column Info
	 * @param fdrMnlBdrDt
	 */
	public void setFdrMnlBdrDt(String fdrMnlBdrDt) {
		this.fdrMnlBdrDt = fdrMnlBdrDt;
	}
	
	/**
	 * Column Info
	 * @param trnkEstmBdrDt
	 */
	public void setTrnkEstmBdrDt(String trnkEstmBdrDt) {
		this.trnkEstmBdrDt = trnkEstmBdrDt;
	}
	
	/**
	 * Column Info
	 * @param trnkAutoBdrDt
	 */
	public void setTrnkAutoBdrDt(String trnkAutoBdrDt) {
		this.trnkAutoBdrDt = trnkAutoBdrDt;
	}
	
	/**
	 * Column Info
	 * @param trnkMnlBdrDt
	 */
	public void setTrnkMnlBdrDt(String trnkMnlBdrDt) {
		this.trnkMnlBdrDt = trnkMnlBdrDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setFdrBdrFlg(JSPUtil.getParameter(request, "fdr_bdr_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrnkMnlBdrFlg(JSPUtil.getParameter(request, "trnk_mnl_bdr_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setSkdStsCd(JSPUtil.getParameter(request, "skd_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setTrnkBdrCreUsrId(JSPUtil.getParameter(request, "trnk_bdr_cre_usr_id", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setFdrAutoBdrDt(JSPUtil.getParameter(request, "fdr_auto_bdr_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, "pol_clpt_ind_seq", ""));
		setFdrBdrCreUsrId(JSPUtil.getParameter(request, "fdr_bdr_cre_usr_id", ""));
		setFdrEstmBdrDt(JSPUtil.getParameter(request, "fdr_estm_bdr_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFdrAutoBdrFlg(JSPUtil.getParameter(request, "fdr_auto_bdr_flg", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setTrnkBdrFlg(JSPUtil.getParameter(request, "trnk_bdr_flg", ""));
		setFdrMnlBdrFlg(JSPUtil.getParameter(request, "fdr_mnl_bdr_flg", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setChkFlg(JSPUtil.getParameter(request, "chk_flg", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, "skd_cng_sts_cd", ""));
		setSlanTpCd(JSPUtil.getParameter(request, "slan_tp_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setFdrBdrUpdDt(JSPUtil.getParameter(request, "fdr_bdr_upd_dt", ""));
		setTrnkAutoBdrFlg(JSPUtil.getParameter(request, "trnk_auto_bdr_flg", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setBdrVslChkFlg(JSPUtil.getParameter(request, "bdr_vsl_chk_flg", ""));
		setFdrMnlBdrDt(JSPUtil.getParameter(request, "fdr_mnl_bdr_dt", ""));
		setTrnkEstmBdrDt(JSPUtil.getParameter(request, "trnk_estm_bdr_dt", ""));
		setTrnkAutoBdrDt(JSPUtil.getParameter(request, "trnk_auto_bdr_dt", ""));
		setTrnkMnlBdrDt(JSPUtil.getParameter(request, "trnk_mnl_bdr_dt", ""));
		
		setPortSkdStsCd(JSPUtil.getParameter(request, "port_skd_sts_cd", ""));
		setOResult(JSPUtil.getParameter(request, "o_result", ""));
		setOErrMsg(JSPUtil.getParameter(request, "o_err_msg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgVvdBdrLogVO[]
	 */
	public BkgVvdBdrLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgVvdBdrLogVO[]
	 */
	public BkgVvdBdrLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgVvdBdrLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] fdrBdrFlg = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trnkMnlBdrFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_mnl_bdr_flg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] trnkBdrCreUsrId = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_cre_usr_id", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] fdrAutoBdrDt = (JSPUtil.getParameter(request, prefix	+ "fdr_auto_bdr_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] fdrBdrCreUsrId = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_cre_usr_id", length));
			String[] fdrEstmBdrDt = (JSPUtil.getParameter(request, prefix	+ "fdr_estm_bdr_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fdrAutoBdrFlg = (JSPUtil.getParameter(request, prefix	+ "fdr_auto_bdr_flg", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] trnkBdrFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_flg", length));
			String[] fdrMnlBdrFlg = (JSPUtil.getParameter(request, prefix	+ "fdr_mnl_bdr_flg", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chkFlg = (JSPUtil.getParameter(request, prefix	+ "chk_flg", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] slanTpCd = (JSPUtil.getParameter(request, prefix	+ "slan_tp_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] fdrBdrUpdDt = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_upd_dt", length));
			String[] trnkAutoBdrFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_auto_bdr_flg", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] bdrVslChkFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_vsl_chk_flg", length));
			String[] fdrMnlBdrDt = (JSPUtil.getParameter(request, prefix	+ "fdr_mnl_bdr_dt", length));
			String[] trnkEstmBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_estm_bdr_dt", length));
			String[] trnkAutoBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_auto_bdr_dt", length));
			String[] trnkMnlBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_mnl_bdr_dt", length));
			
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] oResult = (JSPUtil.getParameter(request, prefix	+ "o_result", length));
			String[] oErrMsg = (JSPUtil.getParameter(request, prefix	+ "o_err_msg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgVvdBdrLogVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (fdrBdrFlg[i] != null)
					model.setFdrBdrFlg(fdrBdrFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trnkMnlBdrFlg[i] != null)
					model.setTrnkMnlBdrFlg(trnkMnlBdrFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdStsCd[i] != null)
					model.setSkdStsCd(skdStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (trnkBdrCreUsrId[i] != null)
					model.setTrnkBdrCreUsrId(trnkBdrCreUsrId[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (fdrAutoBdrDt[i] != null)
					model.setFdrAutoBdrDt(fdrAutoBdrDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (fdrBdrCreUsrId[i] != null)
					model.setFdrBdrCreUsrId(fdrBdrCreUsrId[i]);
				if (fdrEstmBdrDt[i] != null)
					model.setFdrEstmBdrDt(fdrEstmBdrDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fdrAutoBdrFlg[i] != null)
					model.setFdrAutoBdrFlg(fdrAutoBdrFlg[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trnkBdrFlg[i] != null)
					model.setTrnkBdrFlg(trnkBdrFlg[i]);
				if (fdrMnlBdrFlg[i] != null)
					model.setFdrMnlBdrFlg(fdrMnlBdrFlg[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chkFlg[i] != null)
					model.setChkFlg(chkFlg[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (slanTpCd[i] != null)
					model.setSlanTpCd(slanTpCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (fdrBdrUpdDt[i] != null)
					model.setFdrBdrUpdDt(fdrBdrUpdDt[i]);
				if (trnkAutoBdrFlg[i] != null)
					model.setTrnkAutoBdrFlg(trnkAutoBdrFlg[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (bdrVslChkFlg[i] != null)
					model.setBdrVslChkFlg(bdrVslChkFlg[i]);
				if (fdrMnlBdrDt[i] != null)
					model.setFdrMnlBdrDt(fdrMnlBdrDt[i]);
				if (trnkEstmBdrDt[i] != null)
					model.setTrnkEstmBdrDt(trnkEstmBdrDt[i]);
				if (trnkAutoBdrDt[i] != null)
					model.setTrnkAutoBdrDt(trnkAutoBdrDt[i]);
				if (trnkMnlBdrDt[i] != null)
					model.setTrnkMnlBdrDt(trnkMnlBdrDt[i]);
				
				if (portSkdStsCd[i] != null)
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (oResult[i] != null)
					model.setOResult(oResult[i]);
				if (oErrMsg[i] != null)
					model.setOErrMsg(oErrMsg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgVvdBdrLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgVvdBdrLogVO[]
	 */
	public BkgVvdBdrLogVO[] getBkgVvdBdrLogVOs(){
		BkgVvdBdrLogVO[] vos = (BkgVvdBdrLogVO[])models.toArray(new BkgVvdBdrLogVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrFlg = this.fdrBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkMnlBdrFlg = this.trnkMnlBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsCd = this.skdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrCreUsrId = this.trnkBdrCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrAutoBdrDt = this.fdrAutoBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrCreUsrId = this.fdrBdrCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrEstmBdrDt = this.fdrEstmBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrAutoBdrFlg = this.fdrAutoBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrFlg = this.trnkBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrMnlBdrFlg = this.fdrMnlBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg = this.chkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanTpCd = this.slanTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrUpdDt = this.fdrBdrUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAutoBdrFlg = this.trnkAutoBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrVslChkFlg = this.bdrVslChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrMnlBdrDt = this.fdrMnlBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkEstmBdrDt = this.trnkEstmBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAutoBdrDt = this.trnkAutoBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkMnlBdrDt = this.trnkMnlBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oResult = this.oResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oErrMsg = this.oErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
