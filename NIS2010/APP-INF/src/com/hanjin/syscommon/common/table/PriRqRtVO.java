/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PriRqRtVO.java
*@FileTitle : PriRqRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.30
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.30 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriRqRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRqRtVO> models = new ArrayList<PriRqRtVO>();
	
	/* Column Info */
	private String ficDestGlineRtAmt = null;
	/* Column Info */
	private String prsScgAmt = null;
	/* Column Info */
	private String prsRespbCmUcAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String ficQttnRtAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String qttnInitRtAmt = null;
	/* Column Info */
	private String ficDestRtUseStsCd = null;
	/* Column Info */
	private String destOptmTrspModFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String prsUpdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prsPfitCmpbAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ficGlineUpdDt = null;
	/* Column Info */
	private String prsRespbOpfitUcAmt = null;
	/* Column Info */
	private String ficOrgQttnRtAmt = null;
	/* Column Info */
	private String ficDestGlineUpdDt = null;
	/* Column Info */
	private String prsPfitCmUcAmt = null;
	/* Column Info */
	private String ficOrgGlineRtAmt = null;
	/* Column Info */
	private String qttnRtAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ficGlineRtAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgOptmTrspModFlg = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String ficOrgRtUseStsCd = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String prsRespbCmpbAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String prsGidCmpbAmt = null;
	/* Column Info */
	private String prsRespbOpbAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String ficDestQttnRtAmt = null;
	/* Column Info */
	private String qttnRtAdjTpCd = null;
	/* Column Info */
	private String ficOrgGlineUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriRqRtVO() {}

	public PriRqRtVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String cmdtHdrSeq, String routSeq, String rtSeq, String ratUtCd, String prcCgoTpCd, String currCd, String prsScgAmt, String prsRespbCmUcAmt, String prsPfitCmUcAmt, String prsRespbOpfitUcAmt, String prsRespbCmpbAmt, String prsPfitCmpbAmt, String prsRespbOpbAmt, String prsGidCmpbAmt, String prsUpdDt, String vslSlanCd, String qttnInitRtAmt, String qttnRtAmt, String qttnRtAdjTpCd, String srcInfoCd, String creUsrId, String creDt, String updUsrId, String updDt, String ficGlineRtAmt, String ficQttnRtAmt, String ficRtUseStsCd, String ficGlineUpdDt, String optmTrspModFlg, String ficOrgGlineRtAmt, String ficOrgQttnRtAmt, String ficOrgRtUseStsCd, String ficOrgGlineUpdDt, String orgOptmTrspModFlg, String ficDestGlineRtAmt, String ficDestQttnRtAmt, String ficDestRtUseStsCd, String ficDestGlineUpdDt, String destOptmTrspModFlg) {
		this.ficDestGlineRtAmt = ficDestGlineRtAmt;
		this.prsScgAmt = prsScgAmt;
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.ficQttnRtAmt = ficQttnRtAmt;
		this.creDt = creDt;
		this.qttnInitRtAmt = qttnInitRtAmt;
		this.ficDestRtUseStsCd = ficDestRtUseStsCd;
		this.destOptmTrspModFlg = destOptmTrspModFlg;
		this.vslSlanCd = vslSlanCd;
		this.prsUpdDt = prsUpdDt;
		this.pagerows = pagerows;
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
		this.ibflag = ibflag;
		this.ficGlineUpdDt = ficGlineUpdDt;
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
		this.ficOrgQttnRtAmt = ficOrgQttnRtAmt;
		this.ficDestGlineUpdDt = ficDestGlineUpdDt;
		this.prsPfitCmUcAmt = prsPfitCmUcAmt;
		this.ficOrgGlineRtAmt = ficOrgGlineRtAmt;
		this.qttnRtAmt = qttnRtAmt;
		this.updUsrId = updUsrId;
		this.ficGlineRtAmt = ficGlineRtAmt;
		this.updDt = updDt;
		this.orgOptmTrspModFlg = orgOptmTrspModFlg;
		this.optmTrspModFlg = optmTrspModFlg;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.srcInfoCd = srcInfoCd;
		this.ficOrgRtUseStsCd = ficOrgRtUseStsCd;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.ratUtCd = ratUtCd;
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.prsGidCmpbAmt = prsGidCmpbAmt;
		this.prsRespbOpbAmt = prsRespbOpbAmt;
		this.creUsrId = creUsrId;
		this.qttnVerNo = qttnVerNo;
		this.qttnNo = qttnNo;
		this.ficDestQttnRtAmt = ficDestQttnRtAmt;
		this.qttnRtAdjTpCd = qttnRtAdjTpCd;
		this.ficOrgGlineUpdDt = ficOrgGlineUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fic_dest_gline_rt_amt", getFicDestGlineRtAmt());
		this.hashColumns.put("prs_scg_amt", getPrsScgAmt());
		this.hashColumns.put("prs_respb_cm_uc_amt", getPrsRespbCmUcAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("fic_qttn_rt_amt", getFicQttnRtAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("qttn_init_rt_amt", getQttnInitRtAmt());
		this.hashColumns.put("fic_dest_rt_use_sts_cd", getFicDestRtUseStsCd());
		this.hashColumns.put("dest_optm_trsp_mod_flg", getDestOptmTrspModFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("prs_upd_dt", getPrsUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prs_pfit_cmpb_amt", getPrsPfitCmpbAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
		this.hashColumns.put("prs_respb_opfit_uc_amt", getPrsRespbOpfitUcAmt());
		this.hashColumns.put("fic_org_qttn_rt_amt", getFicOrgQttnRtAmt());
		this.hashColumns.put("fic_dest_gline_upd_dt", getFicDestGlineUpdDt());
		this.hashColumns.put("prs_pfit_cm_uc_amt", getPrsPfitCmUcAmt());
		this.hashColumns.put("fic_org_gline_rt_amt", getFicOrgGlineRtAmt());
		this.hashColumns.put("qttn_rt_amt", getQttnRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fic_gline_rt_amt", getFicGlineRtAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_optm_trsp_mod_flg", getOrgOptmTrspModFlg());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("fic_org_rt_use_sts_cd", getFicOrgRtUseStsCd());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prs_respb_cmpb_amt", getPrsRespbCmpbAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("prs_gid_cmpb_amt", getPrsGidCmpbAmt());
		this.hashColumns.put("prs_respb_opb_amt", getPrsRespbOpbAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("fic_dest_qttn_rt_amt", getFicDestQttnRtAmt());
		this.hashColumns.put("qttn_rt_adj_tp_cd", getQttnRtAdjTpCd());
		this.hashColumns.put("fic_org_gline_upd_dt", getFicOrgGlineUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fic_dest_gline_rt_amt", "ficDestGlineRtAmt");
		this.hashFields.put("prs_scg_amt", "prsScgAmt");
		this.hashFields.put("prs_respb_cm_uc_amt", "prsRespbCmUcAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("fic_qttn_rt_amt", "ficQttnRtAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("qttn_init_rt_amt", "qttnInitRtAmt");
		this.hashFields.put("fic_dest_rt_use_sts_cd", "ficDestRtUseStsCd");
		this.hashFields.put("dest_optm_trsp_mod_flg", "destOptmTrspModFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("prs_upd_dt", "prsUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prs_pfit_cmpb_amt", "prsPfitCmpbAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
		this.hashFields.put("prs_respb_opfit_uc_amt", "prsRespbOpfitUcAmt");
		this.hashFields.put("fic_org_qttn_rt_amt", "ficOrgQttnRtAmt");
		this.hashFields.put("fic_dest_gline_upd_dt", "ficDestGlineUpdDt");
		this.hashFields.put("prs_pfit_cm_uc_amt", "prsPfitCmUcAmt");
		this.hashFields.put("fic_org_gline_rt_amt", "ficOrgGlineRtAmt");
		this.hashFields.put("qttn_rt_amt", "qttnRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fic_gline_rt_amt", "ficGlineRtAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_optm_trsp_mod_flg", "orgOptmTrspModFlg");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("fic_org_rt_use_sts_cd", "ficOrgRtUseStsCd");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prs_respb_cmpb_amt", "prsRespbCmpbAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("prs_gid_cmpb_amt", "prsGidCmpbAmt");
		this.hashFields.put("prs_respb_opb_amt", "prsRespbOpbAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("fic_dest_qttn_rt_amt", "ficDestQttnRtAmt");
		this.hashFields.put("qttn_rt_adj_tp_cd", "qttnRtAdjTpCd");
		this.hashFields.put("fic_org_gline_upd_dt", "ficOrgGlineUpdDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineRtAmt
	 */
	public String getFicDestGlineRtAmt() {
		return this.ficDestGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prsScgAmt
	 */
	public String getPrsScgAmt() {
		return this.prsScgAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbCmUcAmt
	 */
	public String getPrsRespbCmUcAmt() {
		return this.prsRespbCmUcAmt;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ficQttnRtAmt
	 */
	public String getFicQttnRtAmt() {
		return this.ficQttnRtAmt;
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
	 * @return qttnInitRtAmt
	 */
	public String getQttnInitRtAmt() {
		return this.qttnInitRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ficDestRtUseStsCd
	 */
	public String getFicDestRtUseStsCd() {
		return this.ficDestRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return destOptmTrspModFlg
	 */
	public String getDestOptmTrspModFlg() {
		return this.destOptmTrspModFlg;
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
	 * @return prsUpdDt
	 */
	public String getPrsUpdDt() {
		return this.prsUpdDt;
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
	 * @return prsPfitCmpbAmt
	 */
	public String getPrsPfitCmpbAmt() {
		return this.prsPfitCmpbAmt;
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
	 * @return ficGlineUpdDt
	 */
	public String getFicGlineUpdDt() {
		return this.ficGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbOpfitUcAmt
	 */
	public String getPrsRespbOpfitUcAmt() {
		return this.prsRespbOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @return ficOrgQttnRtAmt
	 */
	public String getFicOrgQttnRtAmt() {
		return this.ficOrgQttnRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ficDestGlineUpdDt
	 */
	public String getFicDestGlineUpdDt() {
		return this.ficDestGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @return prsPfitCmUcAmt
	 */
	public String getPrsPfitCmUcAmt() {
		return this.prsPfitCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineRtAmt
	 */
	public String getFicOrgGlineRtAmt() {
		return this.ficOrgGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @return qttnRtAmt
	 */
	public String getQttnRtAmt() {
		return this.qttnRtAmt;
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
	 * @return ficGlineRtAmt
	 */
	public String getFicGlineRtAmt() {
		return this.ficGlineRtAmt;
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
	 * @return orgOptmTrspModFlg
	 */
	public String getOrgOptmTrspModFlg() {
		return this.orgOptmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return ficOrgRtUseStsCd
	 */
	public String getFicOrgRtUseStsCd() {
		return this.ficOrgRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return prsRespbCmpbAmt
	 */
	public String getPrsRespbCmpbAmt() {
		return this.prsRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return prsGidCmpbAmt
	 */
	public String getPrsGidCmpbAmt() {
		return this.prsGidCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbOpbAmt
	 */
	public String getPrsRespbOpbAmt() {
		return this.prsRespbOpbAmt;
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
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return ficDestQttnRtAmt
	 */
	public String getFicDestQttnRtAmt() {
		return this.ficDestQttnRtAmt;
	}
	
	/**
	 * Column Info
	 * @return qttnRtAdjTpCd
	 */
	public String getQttnRtAdjTpCd() {
		return this.qttnRtAdjTpCd;
	}
	
	/**
	 * Column Info
	 * @return ficOrgGlineUpdDt
	 */
	public String getFicOrgGlineUpdDt() {
		return this.ficOrgGlineUpdDt;
	}
	

	/**
	 * Column Info
	 * @param ficDestGlineRtAmt
	 */
	public void setFicDestGlineRtAmt(String ficDestGlineRtAmt) {
		this.ficDestGlineRtAmt = ficDestGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prsScgAmt
	 */
	public void setPrsScgAmt(String prsScgAmt) {
		this.prsScgAmt = prsScgAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbCmUcAmt
	 */
	public void setPrsRespbCmUcAmt(String prsRespbCmUcAmt) {
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ficQttnRtAmt
	 */
	public void setFicQttnRtAmt(String ficQttnRtAmt) {
		this.ficQttnRtAmt = ficQttnRtAmt;
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
	 * @param qttnInitRtAmt
	 */
	public void setQttnInitRtAmt(String qttnInitRtAmt) {
		this.qttnInitRtAmt = qttnInitRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ficDestRtUseStsCd
	 */
	public void setFicDestRtUseStsCd(String ficDestRtUseStsCd) {
		this.ficDestRtUseStsCd = ficDestRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param destOptmTrspModFlg
	 */
	public void setDestOptmTrspModFlg(String destOptmTrspModFlg) {
		this.destOptmTrspModFlg = destOptmTrspModFlg;
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
	 * @param prsUpdDt
	 */
	public void setPrsUpdDt(String prsUpdDt) {
		this.prsUpdDt = prsUpdDt;
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
	 * @param prsPfitCmpbAmt
	 */
	public void setPrsPfitCmpbAmt(String prsPfitCmpbAmt) {
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
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
	 * @param ficGlineUpdDt
	 */
	public void setFicGlineUpdDt(String ficGlineUpdDt) {
		this.ficGlineUpdDt = ficGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbOpfitUcAmt
	 */
	public void setPrsRespbOpfitUcAmt(String prsRespbOpfitUcAmt) {
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @param ficOrgQttnRtAmt
	 */
	public void setFicOrgQttnRtAmt(String ficOrgQttnRtAmt) {
		this.ficOrgQttnRtAmt = ficOrgQttnRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ficDestGlineUpdDt
	 */
	public void setFicDestGlineUpdDt(String ficDestGlineUpdDt) {
		this.ficDestGlineUpdDt = ficDestGlineUpdDt;
	}
	
	/**
	 * Column Info
	 * @param prsPfitCmUcAmt
	 */
	public void setPrsPfitCmUcAmt(String prsPfitCmUcAmt) {
		this.prsPfitCmUcAmt = prsPfitCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineRtAmt
	 */
	public void setFicOrgGlineRtAmt(String ficOrgGlineRtAmt) {
		this.ficOrgGlineRtAmt = ficOrgGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @param qttnRtAmt
	 */
	public void setQttnRtAmt(String qttnRtAmt) {
		this.qttnRtAmt = qttnRtAmt;
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
	 * @param ficGlineRtAmt
	 */
	public void setFicGlineRtAmt(String ficGlineRtAmt) {
		this.ficGlineRtAmt = ficGlineRtAmt;
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
	 * @param orgOptmTrspModFlg
	 */
	public void setOrgOptmTrspModFlg(String orgOptmTrspModFlg) {
		this.orgOptmTrspModFlg = orgOptmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param ficOrgRtUseStsCd
	 */
	public void setFicOrgRtUseStsCd(String ficOrgRtUseStsCd) {
		this.ficOrgRtUseStsCd = ficOrgRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param prsRespbCmpbAmt
	 */
	public void setPrsRespbCmpbAmt(String prsRespbCmpbAmt) {
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param prsGidCmpbAmt
	 */
	public void setPrsGidCmpbAmt(String prsGidCmpbAmt) {
		this.prsGidCmpbAmt = prsGidCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbOpbAmt
	 */
	public void setPrsRespbOpbAmt(String prsRespbOpbAmt) {
		this.prsRespbOpbAmt = prsRespbOpbAmt;
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
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param ficDestQttnRtAmt
	 */
	public void setFicDestQttnRtAmt(String ficDestQttnRtAmt) {
		this.ficDestQttnRtAmt = ficDestQttnRtAmt;
	}
	
	/**
	 * Column Info
	 * @param qttnRtAdjTpCd
	 */
	public void setQttnRtAdjTpCd(String qttnRtAdjTpCd) {
		this.qttnRtAdjTpCd = qttnRtAdjTpCd;
	}
	
	/**
	 * Column Info
	 * @param ficOrgGlineUpdDt
	 */
	public void setFicOrgGlineUpdDt(String ficOrgGlineUpdDt) {
		this.ficOrgGlineUpdDt = ficOrgGlineUpdDt;
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
		setFicDestGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_gline_rt_amt", ""));
		setPrsScgAmt(JSPUtil.getParameter(request, prefix + "prs_scg_amt", ""));
		setPrsRespbCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cm_uc_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setFicQttnRtAmt(JSPUtil.getParameter(request, prefix + "fic_qttn_rt_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setQttnInitRtAmt(JSPUtil.getParameter(request, prefix + "qttn_init_rt_amt", ""));
		setFicDestRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd", ""));
		setDestOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPrsUpdDt(JSPUtil.getParameter(request, prefix + "prs_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrsPfitCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cmpb_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFicGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", ""));
		setPrsRespbOpfitUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opfit_uc_amt", ""));
		setFicOrgQttnRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_qttn_rt_amt", ""));
		setFicDestGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_dest_gline_upd_dt", ""));
		setPrsPfitCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cm_uc_amt", ""));
		setFicOrgGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt", ""));
		setQttnRtAmt(JSPUtil.getParameter(request, prefix + "qttn_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFicGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOrgOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setFicOrgRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPrsRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cmpb_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPrsGidCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_gid_cmpb_amt", ""));
		setPrsRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opb_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setQttnVerNo(JSPUtil.getParameter(request, prefix + "qttn_ver_no", ""));
		setQttnNo(JSPUtil.getParameter(request, prefix + "qttn_no", ""));
		setFicDestQttnRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_qttn_rt_amt", ""));
		setQttnRtAdjTpCd(JSPUtil.getParameter(request, prefix + "qttn_rt_adj_tp_cd", ""));
		setFicOrgGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_org_gline_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRqRtVO[]
	 */
	public PriRqRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriRqRtVO[]
	 */
	public PriRqRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRqRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ficDestGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt", length));
			String[] prsScgAmt = (JSPUtil.getParameter(request, prefix	+ "prs_scg_amt", length));
			String[] prsRespbCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cm_uc_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] ficQttnRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_qttn_rt_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] qttnInitRtAmt = (JSPUtil.getParameter(request, prefix	+ "qttn_init_rt_amt", length));
			String[] ficDestRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd", length));
			String[] destOptmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] prsUpdDt = (JSPUtil.getParameter(request, prefix	+ "prs_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prsPfitCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cmpb_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_upd_dt", length));
			String[] prsRespbOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opfit_uc_amt", length));
			String[] ficOrgQttnRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_qttn_rt_amt", length));
			String[] ficDestGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_upd_dt", length));
			String[] prsPfitCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cm_uc_amt", length));
			String[] ficOrgGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt", length));
			String[] qttnRtAmt = (JSPUtil.getParameter(request, prefix	+ "qttn_rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ficGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgOptmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] ficOrgRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] prsRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cmpb_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] prsGidCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_gid_cmpb_amt", length));
			String[] prsRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opb_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] ficDestQttnRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_qttn_rt_amt", length));
			String[] qttnRtAdjTpCd = (JSPUtil.getParameter(request, prefix	+ "qttn_rt_adj_tp_cd", length));
			String[] ficOrgGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRqRtVO();
				if (ficDestGlineRtAmt[i] != null)
					model.setFicDestGlineRtAmt(ficDestGlineRtAmt[i]);
				if (prsScgAmt[i] != null)
					model.setPrsScgAmt(prsScgAmt[i]);
				if (prsRespbCmUcAmt[i] != null)
					model.setPrsRespbCmUcAmt(prsRespbCmUcAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (ficQttnRtAmt[i] != null)
					model.setFicQttnRtAmt(ficQttnRtAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (qttnInitRtAmt[i] != null)
					model.setQttnInitRtAmt(qttnInitRtAmt[i]);
				if (ficDestRtUseStsCd[i] != null)
					model.setFicDestRtUseStsCd(ficDestRtUseStsCd[i]);
				if (destOptmTrspModFlg[i] != null)
					model.setDestOptmTrspModFlg(destOptmTrspModFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (prsUpdDt[i] != null)
					model.setPrsUpdDt(prsUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prsPfitCmpbAmt[i] != null)
					model.setPrsPfitCmpbAmt(prsPfitCmpbAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ficGlineUpdDt[i] != null)
					model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (prsRespbOpfitUcAmt[i] != null)
					model.setPrsRespbOpfitUcAmt(prsRespbOpfitUcAmt[i]);
				if (ficOrgQttnRtAmt[i] != null)
					model.setFicOrgQttnRtAmt(ficOrgQttnRtAmt[i]);
				if (ficDestGlineUpdDt[i] != null)
					model.setFicDestGlineUpdDt(ficDestGlineUpdDt[i]);
				if (prsPfitCmUcAmt[i] != null)
					model.setPrsPfitCmUcAmt(prsPfitCmUcAmt[i]);
				if (ficOrgGlineRtAmt[i] != null)
					model.setFicOrgGlineRtAmt(ficOrgGlineRtAmt[i]);
				if (qttnRtAmt[i] != null)
					model.setQttnRtAmt(qttnRtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ficGlineRtAmt[i] != null)
					model.setFicGlineRtAmt(ficGlineRtAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgOptmTrspModFlg[i] != null)
					model.setOrgOptmTrspModFlg(orgOptmTrspModFlg[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (ficOrgRtUseStsCd[i] != null)
					model.setFicOrgRtUseStsCd(ficOrgRtUseStsCd[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (prsRespbCmpbAmt[i] != null)
					model.setPrsRespbCmpbAmt(prsRespbCmpbAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (prsGidCmpbAmt[i] != null)
					model.setPrsGidCmpbAmt(prsGidCmpbAmt[i]);
				if (prsRespbOpbAmt[i] != null)
					model.setPrsRespbOpbAmt(prsRespbOpbAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (ficDestQttnRtAmt[i] != null)
					model.setFicDestQttnRtAmt(ficDestQttnRtAmt[i]);
				if (qttnRtAdjTpCd[i] != null)
					model.setQttnRtAdjTpCd(qttnRtAdjTpCd[i]);
				if (ficOrgGlineUpdDt[i] != null)
					model.setFicOrgGlineUpdDt(ficOrgGlineUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriRqRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriRqRtVO[]
	 */
	public PriRqRtVO[] getPriRqRtVOs(){
		PriRqRtVO[] vos = (PriRqRtVO[])models.toArray(new PriRqRtVO[models.size()]);
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
		this.ficDestGlineRtAmt = this.ficDestGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsScgAmt = this.prsScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmUcAmt = this.prsRespbCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficQttnRtAmt = this.ficQttnRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnInitRtAmt = this.qttnInitRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCd = this.ficDestRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlg = this.destOptmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsUpdDt = this.prsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPfitCmpbAmt = this.prsPfitCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineUpdDt = this.ficGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpfitUcAmt = this.prsRespbOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgQttnRtAmt = this.ficOrgQttnRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineUpdDt = this.ficDestGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPfitCmUcAmt = this.prsPfitCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmt = this.ficOrgGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnRtAmt = this.qttnRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmt = this.ficGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlg = this.orgOptmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCd = this.ficOrgRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmpbAmt = this.prsRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsGidCmpbAmt = this.prsGidCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpbAmt = this.prsRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestQttnRtAmt = this.ficDestQttnRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnRtAdjTpCd = this.qttnRtAdjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineUpdDt = this.ficOrgGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
