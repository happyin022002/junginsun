/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceCommonVO.java
*@FileTitle : OndockRailChargeInvoiceCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.16 박재흥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo;

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
 * @author 박재흥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OndockRailChargeInvoiceCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OndockRailChargeInvoiceCommonVO> models = new ArrayList<OndockRailChargeInvoiceCommonVO>();
	
	/* Column Info */
	private String vrfyRsltIndCd = null;
	/* Column Info */
	private String rvisCalcCostGrpCd = null;
	/* Column Info */
	private String rvisCntrTpszCd = null;
	/* Column Info */
	private String rvisCreUsrId = null;
	/* Column Info */
	private String orgCurrCd = null;
	/* Column Info */
	private String rvisIndFlg = null;
	/* Column Info */
	private String rvisRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rvisLoclUpdDt = null;
	/* Column Info */
	private String rvisUpdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCalcMode = null;
	/* Column Info */
	private String rvisTmlInvTpCd = null;
	/* Column Info */
	private String rvisTmlSoRvisListSeq = null;
	/* Column Info */
	private String flgYn = null;
	/* Column Info */
	private String rvisBkgNo = null;
	/* Column Info */
	private String rvisVslCd = null;
	/* Column Info */
	private String rvisCntrStyCd = null;
	/* Column Info */
	private String maxWrkDt = null;
	/* Column Info */
	private String rvisLgsCostCd = null;
	/* Column Info */
	private String rvisInvGateOutDt = null;
	/* Column Info */
	private String rvisRhndRsnCd = null;
	/* Column Info */
	private String rvisSkdVoyNo = null;
	/* Column Info */
	private String delIfSeq = null;
	/* Column Info */
	private String rvisGateOutFlg = null;
	/* Column Info */
	private String rvisTmlRvisTpCd = null;
	/* Column Info */
	private String rvisCuzCntrNo = null;
	/* Column Info */
	private String rvisTmlSoDtlSeq = null;
	/* Column Info */
	private String rvisTmlSoSeq = null;
	/* Column Info */
	private String rvisTmlSoOfcCtyCd = null;
	/* Column Info */
	private String rvisUpdUsrId = null;
	/* Column Info */
	private String minWrkDt = null;
	/* Column Info */
	private String rvisTmlSoCntrListSeq = null;
	/* Column Info */
	private String rvisInvGateInDt = null;
	/* Column Info */
	private String rvisLoclCreDt = null;
	/* Column Info */
	private String rvisCntrNo = null;
	/* Column Info */
	private String rvisCreDt = null;
	/* Column Info */
	private String rvisGateInFlg = null;
	/* Column Info */
	private String rvisSkdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OndockRailChargeInvoiceCommonVO() {}

	public OndockRailChargeInvoiceCommonVO(String ibflag, String pagerows, String vrfyRsltIndCd, String costCalcMode, String minWrkDt, String maxWrkDt, String orgCurrCd, String flgYn, String delIfSeq, String rvisTmlSoOfcCtyCd, String rvisTmlSoSeq, String rvisTmlSoDtlSeq, String rvisTmlSoRvisListSeq, String rvisTmlInvTpCd, String rvisCalcCostGrpCd, String rvisTmlRvisTpCd, String rvisLgsCostCd, String rvisIndFlg, String rvisGateInFlg, String rvisGateOutFlg, String rvisInvGateInDt, String rvisInvGateOutDt, String rvisCntrNo, String rvisCntrTpszCd, String rvisCntrStyCd, String rvisBkgNo, String rvisVslCd, String rvisSkdVoyNo, String rvisSkdDirCd, String rvisCuzCntrNo, String rvisRhndRsnCd, String rvisRmk, String rvisCreUsrId, String rvisCreDt, String rvisUpdUsrId, String rvisUpdDt, String rvisLoclCreDt, String rvisLoclUpdDt, String rvisTmlSoCntrListSeq) {
		this.vrfyRsltIndCd = vrfyRsltIndCd;
		this.rvisCalcCostGrpCd = rvisCalcCostGrpCd;
		this.rvisCntrTpszCd = rvisCntrTpszCd;
		this.rvisCreUsrId = rvisCreUsrId;
		this.orgCurrCd = orgCurrCd;
		this.rvisIndFlg = rvisIndFlg;
		this.rvisRmk = rvisRmk;
		this.pagerows = pagerows;
		this.rvisLoclUpdDt = rvisLoclUpdDt;
		this.rvisUpdDt = rvisUpdDt;
		this.ibflag = ibflag;
		this.costCalcMode = costCalcMode;
		this.rvisTmlInvTpCd = rvisTmlInvTpCd;
		this.rvisTmlSoRvisListSeq = rvisTmlSoRvisListSeq;
		this.flgYn = flgYn;
		this.rvisBkgNo = rvisBkgNo;
		this.rvisVslCd = rvisVslCd;
		this.rvisCntrStyCd = rvisCntrStyCd;
		this.maxWrkDt = maxWrkDt;
		this.rvisLgsCostCd = rvisLgsCostCd;
		this.rvisInvGateOutDt = rvisInvGateOutDt;
		this.rvisRhndRsnCd = rvisRhndRsnCd;
		this.rvisSkdVoyNo = rvisSkdVoyNo;
		this.delIfSeq = delIfSeq;
		this.rvisGateOutFlg = rvisGateOutFlg;
		this.rvisTmlRvisTpCd = rvisTmlRvisTpCd;
		this.rvisCuzCntrNo = rvisCuzCntrNo;
		this.rvisTmlSoDtlSeq = rvisTmlSoDtlSeq;
		this.rvisTmlSoSeq = rvisTmlSoSeq;
		this.rvisTmlSoOfcCtyCd = rvisTmlSoOfcCtyCd;
		this.rvisUpdUsrId = rvisUpdUsrId;
		this.minWrkDt = minWrkDt;
		this.rvisTmlSoCntrListSeq = rvisTmlSoCntrListSeq;
		this.rvisInvGateInDt = rvisInvGateInDt;
		this.rvisLoclCreDt = rvisLoclCreDt;
		this.rvisCntrNo = rvisCntrNo;
		this.rvisCreDt = rvisCreDt;
		this.rvisGateInFlg = rvisGateInFlg;
		this.rvisSkdDirCd = rvisSkdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vrfy_rslt_ind_cd", getVrfyRsltIndCd());
		this.hashColumns.put("rvis_calc_cost_grp_cd", getRvisCalcCostGrpCd());
		this.hashColumns.put("rvis_cntr_tpsz_cd", getRvisCntrTpszCd());
		this.hashColumns.put("rvis_cre_usr_id", getRvisCreUsrId());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("rvis_ind_flg", getRvisIndFlg());
		this.hashColumns.put("rvis_rmk", getRvisRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rvis_locl_upd_dt", getRvisLoclUpdDt());
		this.hashColumns.put("rvis_upd_dt", getRvisUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_calc_mode", getCostCalcMode());
		this.hashColumns.put("rvis_tml_inv_tp_cd", getRvisTmlInvTpCd());
		this.hashColumns.put("rvis_tml_so_rvis_list_seq", getRvisTmlSoRvisListSeq());
		this.hashColumns.put("flg_yn", getFlgYn());
		this.hashColumns.put("rvis_bkg_no", getRvisBkgNo());
		this.hashColumns.put("rvis_vsl_cd", getRvisVslCd());
		this.hashColumns.put("rvis_cntr_sty_cd", getRvisCntrStyCd());
		this.hashColumns.put("max_wrk_dt", getMaxWrkDt());
		this.hashColumns.put("rvis_lgs_cost_cd", getRvisLgsCostCd());
		this.hashColumns.put("rvis_inv_gate_out_dt", getRvisInvGateOutDt());
		this.hashColumns.put("rvis_rhnd_rsn_cd", getRvisRhndRsnCd());
		this.hashColumns.put("rvis_skd_voy_no", getRvisSkdVoyNo());
		this.hashColumns.put("del_if_seq", getDelIfSeq());
		this.hashColumns.put("rvis_gate_out_flg", getRvisGateOutFlg());
		this.hashColumns.put("rvis_tml_rvis_tp_cd", getRvisTmlRvisTpCd());
		this.hashColumns.put("rvis_cuz_cntr_no", getRvisCuzCntrNo());
		this.hashColumns.put("rvis_tml_so_dtl_seq", getRvisTmlSoDtlSeq());
		this.hashColumns.put("rvis_tml_so_seq", getRvisTmlSoSeq());
		this.hashColumns.put("rvis_tml_so_ofc_cty_cd", getRvisTmlSoOfcCtyCd());
		this.hashColumns.put("rvis_upd_usr_id", getRvisUpdUsrId());
		this.hashColumns.put("min_wrk_dt", getMinWrkDt());
		this.hashColumns.put("rvis_tml_so_cntr_list_seq", getRvisTmlSoCntrListSeq());
		this.hashColumns.put("rvis_inv_gate_in_dt", getRvisInvGateInDt());
		this.hashColumns.put("rvis_locl_cre_dt", getRvisLoclCreDt());
		this.hashColumns.put("rvis_cntr_no", getRvisCntrNo());
		this.hashColumns.put("rvis_cre_dt", getRvisCreDt());
		this.hashColumns.put("rvis_gate_in_flg", getRvisGateInFlg());
		this.hashColumns.put("rvis_skd_dir_cd", getRvisSkdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vrfy_rslt_ind_cd", "vrfyRsltIndCd");
		this.hashFields.put("rvis_calc_cost_grp_cd", "rvisCalcCostGrpCd");
		this.hashFields.put("rvis_cntr_tpsz_cd", "rvisCntrTpszCd");
		this.hashFields.put("rvis_cre_usr_id", "rvisCreUsrId");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("rvis_ind_flg", "rvisIndFlg");
		this.hashFields.put("rvis_rmk", "rvisRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rvis_locl_upd_dt", "rvisLoclUpdDt");
		this.hashFields.put("rvis_upd_dt", "rvisUpdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_calc_mode", "costCalcMode");
		this.hashFields.put("rvis_tml_inv_tp_cd", "rvisTmlInvTpCd");
		this.hashFields.put("rvis_tml_so_rvis_list_seq", "rvisTmlSoRvisListSeq");
		this.hashFields.put("flg_yn", "flgYn");
		this.hashFields.put("rvis_bkg_no", "rvisBkgNo");
		this.hashFields.put("rvis_vsl_cd", "rvisVslCd");
		this.hashFields.put("rvis_cntr_sty_cd", "rvisCntrStyCd");
		this.hashFields.put("max_wrk_dt", "maxWrkDt");
		this.hashFields.put("rvis_lgs_cost_cd", "rvisLgsCostCd");
		this.hashFields.put("rvis_inv_gate_out_dt", "rvisInvGateOutDt");
		this.hashFields.put("rvis_rhnd_rsn_cd", "rvisRhndRsnCd");
		this.hashFields.put("rvis_skd_voy_no", "rvisSkdVoyNo");
		this.hashFields.put("del_if_seq", "delIfSeq");
		this.hashFields.put("rvis_gate_out_flg", "rvisGateOutFlg");
		this.hashFields.put("rvis_tml_rvis_tp_cd", "rvisTmlRvisTpCd");
		this.hashFields.put("rvis_cuz_cntr_no", "rvisCuzCntrNo");
		this.hashFields.put("rvis_tml_so_dtl_seq", "rvisTmlSoDtlSeq");
		this.hashFields.put("rvis_tml_so_seq", "rvisTmlSoSeq");
		this.hashFields.put("rvis_tml_so_ofc_cty_cd", "rvisTmlSoOfcCtyCd");
		this.hashFields.put("rvis_upd_usr_id", "rvisUpdUsrId");
		this.hashFields.put("min_wrk_dt", "minWrkDt");
		this.hashFields.put("rvis_tml_so_cntr_list_seq", "rvisTmlSoCntrListSeq");
		this.hashFields.put("rvis_inv_gate_in_dt", "rvisInvGateInDt");
		this.hashFields.put("rvis_locl_cre_dt", "rvisLoclCreDt");
		this.hashFields.put("rvis_cntr_no", "rvisCntrNo");
		this.hashFields.put("rvis_cre_dt", "rvisCreDt");
		this.hashFields.put("rvis_gate_in_flg", "rvisGateInFlg");
		this.hashFields.put("rvis_skd_dir_cd", "rvisSkdDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vrfyRsltIndCd
	 */
	public String getVrfyRsltIndCd() {
		return this.vrfyRsltIndCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCalcCostGrpCd
	 */
	public String getRvisCalcCostGrpCd() {
		return this.rvisCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrTpszCd
	 */
	public String getRvisCntrTpszCd() {
		return this.rvisCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCreUsrId
	 */
	public String getRvisCreUsrId() {
		return this.rvisCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return orgCurrCd
	 */
	public String getOrgCurrCd() {
		return this.orgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rvisIndFlg
	 */
	public String getRvisIndFlg() {
		return this.rvisIndFlg;
	}
	
	/**
	 * Column Info
	 * @return rvisRmk
	 */
	public String getRvisRmk() {
		return this.rvisRmk;
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
	 * @return rvisLoclUpdDt
	 */
	public String getRvisLoclUpdDt() {
		return this.rvisLoclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rvisUpdDt
	 */
	public String getRvisUpdDt() {
		return this.rvisUpdDt;
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
	 * @return costCalcMode
	 */
	public String getCostCalcMode() {
		return this.costCalcMode;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlInvTpCd
	 */
	public String getRvisTmlInvTpCd() {
		return this.rvisTmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoRvisListSeq
	 */
	public String getRvisTmlSoRvisListSeq() {
		return this.rvisTmlSoRvisListSeq;
	}
	
	/**
	 * Column Info
	 * @return flgYn
	 */
	public String getFlgYn() {
		return this.flgYn;
	}
	
	/**
	 * Column Info
	 * @return rvisBkgNo
	 */
	public String getRvisBkgNo() {
		return this.rvisBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rvisVslCd
	 */
	public String getRvisVslCd() {
		return this.rvisVslCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrStyCd
	 */
	public String getRvisCntrStyCd() {
		return this.rvisCntrStyCd;
	}
	
	/**
	 * Column Info
	 * @return maxWrkDt
	 */
	public String getMaxWrkDt() {
		return this.maxWrkDt;
	}
	
	/**
	 * Column Info
	 * @return rvisLgsCostCd
	 */
	public String getRvisLgsCostCd() {
		return this.rvisLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return rvisInvGateOutDt
	 */
	public String getRvisInvGateOutDt() {
		return this.rvisInvGateOutDt;
	}
	
	/**
	 * Column Info
	 * @return rvisRhndRsnCd
	 */
	public String getRvisRhndRsnCd() {
		return this.rvisRhndRsnCd;
	}
	
	/**
	 * Column Info
	 * @return rvisSkdVoyNo
	 */
	public String getRvisSkdVoyNo() {
		return this.rvisSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return delIfSeq
	 */
	public String getDelIfSeq() {
		return this.delIfSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisGateOutFlg
	 */
	public String getRvisGateOutFlg() {
		return this.rvisGateOutFlg;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlRvisTpCd
	 */
	public String getRvisTmlRvisTpCd() {
		return this.rvisTmlRvisTpCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCuzCntrNo
	 */
	public String getRvisCuzCntrNo() {
		return this.rvisCuzCntrNo;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoDtlSeq
	 */
	public String getRvisTmlSoDtlSeq() {
		return this.rvisTmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoSeq
	 */
	public String getRvisTmlSoSeq() {
		return this.rvisTmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoOfcCtyCd
	 */
	public String getRvisTmlSoOfcCtyCd() {
		return this.rvisTmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return rvisUpdUsrId
	 */
	public String getRvisUpdUsrId() {
		return this.rvisUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return minWrkDt
	 */
	public String getMinWrkDt() {
		return this.minWrkDt;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoCntrListSeq
	 */
	public String getRvisTmlSoCntrListSeq() {
		return this.rvisTmlSoCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisInvGateInDt
	 */
	public String getRvisInvGateInDt() {
		return this.rvisInvGateInDt;
	}
	
	/**
	 * Column Info
	 * @return rvisLoclCreDt
	 */
	public String getRvisLoclCreDt() {
		return this.rvisLoclCreDt;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrNo
	 */
	public String getRvisCntrNo() {
		return this.rvisCntrNo;
	}
	
	/**
	 * Column Info
	 * @return rvisCreDt
	 */
	public String getRvisCreDt() {
		return this.rvisCreDt;
	}
	
	/**
	 * Column Info
	 * @return rvisGateInFlg
	 */
	public String getRvisGateInFlg() {
		return this.rvisGateInFlg;
	}
	
	/**
	 * Column Info
	 * @return rvisSkdDirCd
	 */
	public String getRvisSkdDirCd() {
		return this.rvisSkdDirCd;
	}
	

	/**
	 * Column Info
	 * @param vrfyRsltIndCd
	 */
	public void setVrfyRsltIndCd(String vrfyRsltIndCd) {
		this.vrfyRsltIndCd = vrfyRsltIndCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCalcCostGrpCd
	 */
	public void setRvisCalcCostGrpCd(String rvisCalcCostGrpCd) {
		this.rvisCalcCostGrpCd = rvisCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrTpszCd
	 */
	public void setRvisCntrTpszCd(String rvisCntrTpszCd) {
		this.rvisCntrTpszCd = rvisCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCreUsrId
	 */
	public void setRvisCreUsrId(String rvisCreUsrId) {
		this.rvisCreUsrId = rvisCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param orgCurrCd
	 */
	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rvisIndFlg
	 */
	public void setRvisIndFlg(String rvisIndFlg) {
		this.rvisIndFlg = rvisIndFlg;
	}
	
	/**
	 * Column Info
	 * @param rvisRmk
	 */
	public void setRvisRmk(String rvisRmk) {
		this.rvisRmk = rvisRmk;
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
	 * @param rvisLoclUpdDt
	 */
	public void setRvisLoclUpdDt(String rvisLoclUpdDt) {
		this.rvisLoclUpdDt = rvisLoclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rvisUpdDt
	 */
	public void setRvisUpdDt(String rvisUpdDt) {
		this.rvisUpdDt = rvisUpdDt;
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
	 * @param costCalcMode
	 */
	public void setCostCalcMode(String costCalcMode) {
		this.costCalcMode = costCalcMode;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlInvTpCd
	 */
	public void setRvisTmlInvTpCd(String rvisTmlInvTpCd) {
		this.rvisTmlInvTpCd = rvisTmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoRvisListSeq
	 */
	public void setRvisTmlSoRvisListSeq(String rvisTmlSoRvisListSeq) {
		this.rvisTmlSoRvisListSeq = rvisTmlSoRvisListSeq;
	}
	
	/**
	 * Column Info
	 * @param flgYn
	 */
	public void setFlgYn(String flgYn) {
		this.flgYn = flgYn;
	}
	
	/**
	 * Column Info
	 * @param rvisBkgNo
	 */
	public void setRvisBkgNo(String rvisBkgNo) {
		this.rvisBkgNo = rvisBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rvisVslCd
	 */
	public void setRvisVslCd(String rvisVslCd) {
		this.rvisVslCd = rvisVslCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrStyCd
	 */
	public void setRvisCntrStyCd(String rvisCntrStyCd) {
		this.rvisCntrStyCd = rvisCntrStyCd;
	}
	
	/**
	 * Column Info
	 * @param maxWrkDt
	 */
	public void setMaxWrkDt(String maxWrkDt) {
		this.maxWrkDt = maxWrkDt;
	}
	
	/**
	 * Column Info
	 * @param rvisLgsCostCd
	 */
	public void setRvisLgsCostCd(String rvisLgsCostCd) {
		this.rvisLgsCostCd = rvisLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param rvisInvGateOutDt
	 */
	public void setRvisInvGateOutDt(String rvisInvGateOutDt) {
		this.rvisInvGateOutDt = rvisInvGateOutDt;
	}
	
	/**
	 * Column Info
	 * @param rvisRhndRsnCd
	 */
	public void setRvisRhndRsnCd(String rvisRhndRsnCd) {
		this.rvisRhndRsnCd = rvisRhndRsnCd;
	}
	
	/**
	 * Column Info
	 * @param rvisSkdVoyNo
	 */
	public void setRvisSkdVoyNo(String rvisSkdVoyNo) {
		this.rvisSkdVoyNo = rvisSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param delIfSeq
	 */
	public void setDelIfSeq(String delIfSeq) {
		this.delIfSeq = delIfSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisGateOutFlg
	 */
	public void setRvisGateOutFlg(String rvisGateOutFlg) {
		this.rvisGateOutFlg = rvisGateOutFlg;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlRvisTpCd
	 */
	public void setRvisTmlRvisTpCd(String rvisTmlRvisTpCd) {
		this.rvisTmlRvisTpCd = rvisTmlRvisTpCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCuzCntrNo
	 */
	public void setRvisCuzCntrNo(String rvisCuzCntrNo) {
		this.rvisCuzCntrNo = rvisCuzCntrNo;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoDtlSeq
	 */
	public void setRvisTmlSoDtlSeq(String rvisTmlSoDtlSeq) {
		this.rvisTmlSoDtlSeq = rvisTmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoSeq
	 */
	public void setRvisTmlSoSeq(String rvisTmlSoSeq) {
		this.rvisTmlSoSeq = rvisTmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoOfcCtyCd
	 */
	public void setRvisTmlSoOfcCtyCd(String rvisTmlSoOfcCtyCd) {
		this.rvisTmlSoOfcCtyCd = rvisTmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param rvisUpdUsrId
	 */
	public void setRvisUpdUsrId(String rvisUpdUsrId) {
		this.rvisUpdUsrId = rvisUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param minWrkDt
	 */
	public void setMinWrkDt(String minWrkDt) {
		this.minWrkDt = minWrkDt;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoCntrListSeq
	 */
	public void setRvisTmlSoCntrListSeq(String rvisTmlSoCntrListSeq) {
		this.rvisTmlSoCntrListSeq = rvisTmlSoCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisInvGateInDt
	 */
	public void setRvisInvGateInDt(String rvisInvGateInDt) {
		this.rvisInvGateInDt = rvisInvGateInDt;
	}
	
	/**
	 * Column Info
	 * @param rvisLoclCreDt
	 */
	public void setRvisLoclCreDt(String rvisLoclCreDt) {
		this.rvisLoclCreDt = rvisLoclCreDt;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrNo
	 */
	public void setRvisCntrNo(String rvisCntrNo) {
		this.rvisCntrNo = rvisCntrNo;
	}
	
	/**
	 * Column Info
	 * @param rvisCreDt
	 */
	public void setRvisCreDt(String rvisCreDt) {
		this.rvisCreDt = rvisCreDt;
	}
	
	/**
	 * Column Info
	 * @param rvisGateInFlg
	 */
	public void setRvisGateInFlg(String rvisGateInFlg) {
		this.rvisGateInFlg = rvisGateInFlg;
	}
	
	/**
	 * Column Info
	 * @param rvisSkdDirCd
	 */
	public void setRvisSkdDirCd(String rvisSkdDirCd) {
		this.rvisSkdDirCd = rvisSkdDirCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVrfyRsltIndCd(JSPUtil.getParameter(request, "vrfy_rslt_ind_cd", ""));
		setRvisCalcCostGrpCd(JSPUtil.getParameter(request, "rvis_calc_cost_grp_cd", ""));
		setRvisCntrTpszCd(JSPUtil.getParameter(request, "rvis_cntr_tpsz_cd", ""));
		setRvisCreUsrId(JSPUtil.getParameter(request, "rvis_cre_usr_id", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, "org_curr_cd", ""));
		setRvisIndFlg(JSPUtil.getParameter(request, "rvis_ind_flg", ""));
		setRvisRmk(JSPUtil.getParameter(request, "rvis_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRvisLoclUpdDt(JSPUtil.getParameter(request, "rvis_locl_upd_dt", ""));
		setRvisUpdDt(JSPUtil.getParameter(request, "rvis_upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostCalcMode(JSPUtil.getParameter(request, "cost_calc_mode", ""));
		setRvisTmlInvTpCd(JSPUtil.getParameter(request, "rvis_tml_inv_tp_cd", ""));
		setRvisTmlSoRvisListSeq(JSPUtil.getParameter(request, "rvis_tml_so_rvis_list_seq", ""));
		setFlgYn(JSPUtil.getParameter(request, "flg_yn", ""));
		setRvisBkgNo(JSPUtil.getParameter(request, "rvis_bkg_no", ""));
		setRvisVslCd(JSPUtil.getParameter(request, "rvis_vsl_cd", ""));
		setRvisCntrStyCd(JSPUtil.getParameter(request, "rvis_cntr_sty_cd", ""));
		setMaxWrkDt(JSPUtil.getParameter(request, "max_wrk_dt", ""));
		setRvisLgsCostCd(JSPUtil.getParameter(request, "rvis_lgs_cost_cd", ""));
		setRvisInvGateOutDt(JSPUtil.getParameter(request, "rvis_inv_gate_out_dt", ""));
		setRvisRhndRsnCd(JSPUtil.getParameter(request, "rvis_rhnd_rsn_cd", ""));
		setRvisSkdVoyNo(JSPUtil.getParameter(request, "rvis_skd_voy_no", ""));
		setDelIfSeq(JSPUtil.getParameter(request, "del_if_seq", ""));
		setRvisGateOutFlg(JSPUtil.getParameter(request, "rvis_gate_out_flg", ""));
		setRvisTmlRvisTpCd(JSPUtil.getParameter(request, "rvis_tml_rvis_tp_cd", ""));
		setRvisCuzCntrNo(JSPUtil.getParameter(request, "rvis_cuz_cntr_no", ""));
		setRvisTmlSoDtlSeq(JSPUtil.getParameter(request, "rvis_tml_so_dtl_seq", ""));
		setRvisTmlSoSeq(JSPUtil.getParameter(request, "rvis_tml_so_seq", ""));
		setRvisTmlSoOfcCtyCd(JSPUtil.getParameter(request, "rvis_tml_so_ofc_cty_cd", ""));
		setRvisUpdUsrId(JSPUtil.getParameter(request, "rvis_upd_usr_id", ""));
		setMinWrkDt(JSPUtil.getParameter(request, "min_wrk_dt", ""));
		setRvisTmlSoCntrListSeq(JSPUtil.getParameter(request, "rvis_tml_so_cntr_list_seq", ""));
		setRvisInvGateInDt(JSPUtil.getParameter(request, "rvis_inv_gate_in_dt", ""));
		setRvisLoclCreDt(JSPUtil.getParameter(request, "rvis_locl_cre_dt", ""));
		setRvisCntrNo(JSPUtil.getParameter(request, "rvis_cntr_no", ""));
		setRvisCreDt(JSPUtil.getParameter(request, "rvis_cre_dt", ""));
		setRvisGateInFlg(JSPUtil.getParameter(request, "rvis_gate_in_flg", ""));
		setRvisSkdDirCd(JSPUtil.getParameter(request, "rvis_skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OndockRailChargeInvoiceCommonVO[]
	 */
	public OndockRailChargeInvoiceCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OndockRailChargeInvoiceCommonVO[]
	 */
	public OndockRailChargeInvoiceCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OndockRailChargeInvoiceCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vrfyRsltIndCd = (JSPUtil.getParameter(request, prefix	+ "vrfy_rslt_ind_cd", length));
			String[] rvisCalcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_calc_cost_grp_cd", length));
			String[] rvisCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_tpsz_cd", length));
			String[] rvisCreUsrId = (JSPUtil.getParameter(request, prefix	+ "rvis_cre_usr_id", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] rvisIndFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_ind_flg", length));
			String[] rvisRmk = (JSPUtil.getParameter(request, prefix	+ "rvis_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rvisLoclUpdDt = (JSPUtil.getParameter(request, prefix	+ "rvis_locl_upd_dt", length));
			String[] rvisUpdDt = (JSPUtil.getParameter(request, prefix	+ "rvis_upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCalcMode = (JSPUtil.getParameter(request, prefix	+ "cost_calc_mode", length));
			String[] rvisTmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_inv_tp_cd", length));
			String[] rvisTmlSoRvisListSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_rvis_list_seq", length));
			String[] flgYn = (JSPUtil.getParameter(request, prefix	+ "flg_yn", length));
			String[] rvisBkgNo = (JSPUtil.getParameter(request, prefix	+ "rvis_bkg_no", length));
			String[] rvisVslCd = (JSPUtil.getParameter(request, prefix	+ "rvis_vsl_cd", length));
			String[] rvisCntrStyCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_sty_cd", length));
			String[] maxWrkDt = (JSPUtil.getParameter(request, prefix	+ "max_wrk_dt", length));
			String[] rvisLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "rvis_lgs_cost_cd", length));
			String[] rvisInvGateOutDt = (JSPUtil.getParameter(request, prefix	+ "rvis_inv_gate_out_dt", length));
			String[] rvisRhndRsnCd = (JSPUtil.getParameter(request, prefix	+ "rvis_rhnd_rsn_cd", length));
			String[] rvisSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "rvis_skd_voy_no", length));
			String[] delIfSeq = (JSPUtil.getParameter(request, prefix	+ "del_if_seq", length));
			String[] rvisGateOutFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_gate_out_flg", length));
			String[] rvisTmlRvisTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_rvis_tp_cd", length));
			String[] rvisCuzCntrNo = (JSPUtil.getParameter(request, prefix	+ "rvis_cuz_cntr_no", length));
			String[] rvisTmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_dtl_seq", length));
			String[] rvisTmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_seq", length));
			String[] rvisTmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_ofc_cty_cd", length));
			String[] rvisUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "rvis_upd_usr_id", length));
			String[] minWrkDt = (JSPUtil.getParameter(request, prefix	+ "min_wrk_dt", length));
			String[] rvisTmlSoCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_cntr_list_seq", length));
			String[] rvisInvGateInDt = (JSPUtil.getParameter(request, prefix	+ "rvis_inv_gate_in_dt", length));
			String[] rvisLoclCreDt = (JSPUtil.getParameter(request, prefix	+ "rvis_locl_cre_dt", length));
			String[] rvisCntrNo = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_no", length));
			String[] rvisCreDt = (JSPUtil.getParameter(request, prefix	+ "rvis_cre_dt", length));
			String[] rvisGateInFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_gate_in_flg", length));
			String[] rvisSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "rvis_skd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OndockRailChargeInvoiceCommonVO();
				if (vrfyRsltIndCd[i] != null)
					model.setVrfyRsltIndCd(vrfyRsltIndCd[i]);
				if (rvisCalcCostGrpCd[i] != null)
					model.setRvisCalcCostGrpCd(rvisCalcCostGrpCd[i]);
				if (rvisCntrTpszCd[i] != null)
					model.setRvisCntrTpszCd(rvisCntrTpszCd[i]);
				if (rvisCreUsrId[i] != null)
					model.setRvisCreUsrId(rvisCreUsrId[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (rvisIndFlg[i] != null)
					model.setRvisIndFlg(rvisIndFlg[i]);
				if (rvisRmk[i] != null)
					model.setRvisRmk(rvisRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rvisLoclUpdDt[i] != null)
					model.setRvisLoclUpdDt(rvisLoclUpdDt[i]);
				if (rvisUpdDt[i] != null)
					model.setRvisUpdDt(rvisUpdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCalcMode[i] != null)
					model.setCostCalcMode(costCalcMode[i]);
				if (rvisTmlInvTpCd[i] != null)
					model.setRvisTmlInvTpCd(rvisTmlInvTpCd[i]);
				if (rvisTmlSoRvisListSeq[i] != null)
					model.setRvisTmlSoRvisListSeq(rvisTmlSoRvisListSeq[i]);
				if (flgYn[i] != null)
					model.setFlgYn(flgYn[i]);
				if (rvisBkgNo[i] != null)
					model.setRvisBkgNo(rvisBkgNo[i]);
				if (rvisVslCd[i] != null)
					model.setRvisVslCd(rvisVslCd[i]);
				if (rvisCntrStyCd[i] != null)
					model.setRvisCntrStyCd(rvisCntrStyCd[i]);
				if (maxWrkDt[i] != null)
					model.setMaxWrkDt(maxWrkDt[i]);
				if (rvisLgsCostCd[i] != null)
					model.setRvisLgsCostCd(rvisLgsCostCd[i]);
				if (rvisInvGateOutDt[i] != null)
					model.setRvisInvGateOutDt(rvisInvGateOutDt[i]);
				if (rvisRhndRsnCd[i] != null)
					model.setRvisRhndRsnCd(rvisRhndRsnCd[i]);
				if (rvisSkdVoyNo[i] != null)
					model.setRvisSkdVoyNo(rvisSkdVoyNo[i]);
				if (delIfSeq[i] != null)
					model.setDelIfSeq(delIfSeq[i]);
				if (rvisGateOutFlg[i] != null)
					model.setRvisGateOutFlg(rvisGateOutFlg[i]);
				if (rvisTmlRvisTpCd[i] != null)
					model.setRvisTmlRvisTpCd(rvisTmlRvisTpCd[i]);
				if (rvisCuzCntrNo[i] != null)
					model.setRvisCuzCntrNo(rvisCuzCntrNo[i]);
				if (rvisTmlSoDtlSeq[i] != null)
					model.setRvisTmlSoDtlSeq(rvisTmlSoDtlSeq[i]);
				if (rvisTmlSoSeq[i] != null)
					model.setRvisTmlSoSeq(rvisTmlSoSeq[i]);
				if (rvisTmlSoOfcCtyCd[i] != null)
					model.setRvisTmlSoOfcCtyCd(rvisTmlSoOfcCtyCd[i]);
				if (rvisUpdUsrId[i] != null)
					model.setRvisUpdUsrId(rvisUpdUsrId[i]);
				if (minWrkDt[i] != null)
					model.setMinWrkDt(minWrkDt[i]);
				if (rvisTmlSoCntrListSeq[i] != null)
					model.setRvisTmlSoCntrListSeq(rvisTmlSoCntrListSeq[i]);
				if (rvisInvGateInDt[i] != null)
					model.setRvisInvGateInDt(rvisInvGateInDt[i]);
				if (rvisLoclCreDt[i] != null)
					model.setRvisLoclCreDt(rvisLoclCreDt[i]);
				if (rvisCntrNo[i] != null)
					model.setRvisCntrNo(rvisCntrNo[i]);
				if (rvisCreDt[i] != null)
					model.setRvisCreDt(rvisCreDt[i]);
				if (rvisGateInFlg[i] != null)
					model.setRvisGateInFlg(rvisGateInFlg[i]);
				if (rvisSkdDirCd[i] != null)
					model.setRvisSkdDirCd(rvisSkdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOndockRailChargeInvoiceCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OndockRailChargeInvoiceCommonVO[]
	 */
	public OndockRailChargeInvoiceCommonVO[] getOndockRailChargeInvoiceCommonVOs(){
		OndockRailChargeInvoiceCommonVO[] vos = (OndockRailChargeInvoiceCommonVO[])models.toArray(new OndockRailChargeInvoiceCommonVO[models.size()]);
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
		this.vrfyRsltIndCd = this.vrfyRsltIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCalcCostGrpCd = this.rvisCalcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrTpszCd = this.rvisCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCreUsrId = this.rvisCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisIndFlg = this.rvisIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisRmk = this.rvisRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisLoclUpdDt = this.rvisLoclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisUpdDt = this.rvisUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCalcMode = this.costCalcMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlInvTpCd = this.rvisTmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoRvisListSeq = this.rvisTmlSoRvisListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgYn = this.flgYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisBkgNo = this.rvisBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVslCd = this.rvisVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrStyCd = this.rvisCntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWrkDt = this.maxWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisLgsCostCd = this.rvisLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisInvGateOutDt = this.rvisInvGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisRhndRsnCd = this.rvisRhndRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSkdVoyNo = this.rvisSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delIfSeq = this.delIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisGateOutFlg = this.rvisGateOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlRvisTpCd = this.rvisTmlRvisTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCuzCntrNo = this.rvisCuzCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoDtlSeq = this.rvisTmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoSeq = this.rvisTmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoOfcCtyCd = this.rvisTmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisUpdUsrId = this.rvisUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minWrkDt = this.minWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoCntrListSeq = this.rvisTmlSoCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisInvGateInDt = this.rvisInvGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisLoclCreDt = this.rvisLoclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrNo = this.rvisCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCreDt = this.rvisCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisGateInFlg = this.rvisGateInFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSkdDirCd = this.rvisSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
