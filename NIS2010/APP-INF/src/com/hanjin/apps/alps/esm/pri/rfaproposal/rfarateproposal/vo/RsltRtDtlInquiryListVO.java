/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltRtDtlInquiryListVO.java
*@FileTitle : RsltRtDtlInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.07 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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

public class RsltRtDtlInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtDtlInquiryListVO> models = new ArrayList<RsltRtDtlInquiryListVO>();
	
	/* Column Info */
	private String ficDestGlineRtAmt = null;
	/* Column Info */
	private String ficOrgCoffrRtAmt = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String griApplAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String ficDestRtUseStsCd = null;
	/* Column Info */
	private String coffrFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ficCoffrRtAmt = null;
	/* Column Info */
	private String prsPfitCmpbAmt = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ficGlineUpdDt = null;
	/* Column Info */
	private String prsPfitCmUcAmt = null;
	/* Column Info */
	private String ficOrgGlineRtAmt = null;
	/* Column Info */
	private String ficDestCoffrRtAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ficGlineRtAmt = null;
	/* Column Info */
	private String specCnt = null;
	/* Column Info */
	private String griApplTpCd = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String ficDestPropRtAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String prsScgAmt = null;
	/* Column Info */
	private String prsRespbCmUcAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String prcProgStsNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String destOptmTrspModFlg = null;
	/* Column Info */
	private String prsUpdDt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prsRespbOpfitUcAmt = null;
	/* Column Info */
	private String ficDestGlineUpdDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgOptmTrspModFlg = null;
	/* Column Info */
	private String ficOrgPropRtAmt = null;
	/* Column Info */
	private String ficFnlRtAmt = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String acptUsrId = null;
	/* Column Info */
	private String ficOrgRtUseStsCd = null;
	/* Column Info */
	private String ficOrgFnlRtAmt = null;
	/* Column Info */
	private String srcInfoNm = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String prsRespbCmpbAmt = null;
	/* Column Info */
	private String prsGidCmpbAmt = null;
	/* Column Info */
	private String ficPropRtAmt = null;
	/* Column Info */
	private String prsRespbOpbAmt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String ficDestFnlRtAmt = null;
	/* Column Info */
	private String ficOrgGlineUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtDtlInquiryListVO() {}

	public RsltRtDtlInquiryListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String coffrFrtRtAmt, String fnlFrtRtAmt, String prsScgAmt, String prsRespbCmUcAmt, String prsRespbOpfitUcAmt, String prsRespbCmpbAmt, String prsGidCmpbAmt, String prsRespbOpbAmt, String diff, String prsPfitCmUcAmt, String prsPfitCmpbAmt, String prsUpdDt, String griApplTpCd, String griApplAmt, String prcProgStsCd, String prcProgStsNm, String srcInfoCd, String srcInfoNm, String n1stCmncAmdtSeq, String effDt, String expDt, String acptUsrId, String acptOfcCd, String acptUsrNm, String acptDt, String creUsrId, String creDt, String updUsrId, String updDt, String specCnt, String ficPropRtAmt, String ficCoffrRtAmt, String ficFnlRtAmt, String ficGlineRtAmt, String ficGlineUpdDt, String optmTrspModFlg, String ficRtUseStsCd, String ficOrgPropRtAmt, String ficOrgCoffrRtAmt, String ficOrgFnlRtAmt, String ficOrgGlineRtAmt, String ficOrgGlineUpdDt, String orgOptmTrspModFlg, String ficOrgRtUseStsCd, String ficDestPropRtAmt, String ficDestCoffrRtAmt, String ficDestFnlRtAmt, String ficDestGlineRtAmt, String ficDestGlineUpdDt, String destOptmTrspModFlg, String ficDestRtUseStsCd) {
		this.ficDestGlineRtAmt = ficDestGlineRtAmt;
		this.ficOrgCoffrRtAmt = ficOrgCoffrRtAmt;
		this.diff = diff;
		this.amdtSeq = amdtSeq;
		this.griApplAmt = griApplAmt;
		this.svcScpCd = svcScpCd;
		this.ficDestRtUseStsCd = ficDestRtUseStsCd;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.pagerows = pagerows;
		this.ficCoffrRtAmt = ficCoffrRtAmt;
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
		this.prcProgStsCd = prcProgStsCd;
		this.effDt = effDt;
		this.ficGlineUpdDt = ficGlineUpdDt;
		this.prsPfitCmUcAmt = prsPfitCmUcAmt;
		this.ficOrgGlineRtAmt = ficOrgGlineRtAmt;
		this.ficDestCoffrRtAmt = ficDestCoffrRtAmt;
		this.updUsrId = updUsrId;
		this.ficGlineRtAmt = ficGlineRtAmt;
		this.specCnt = specCnt;
		this.griApplTpCd = griApplTpCd;
		this.acptUsrNm = acptUsrNm;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.ficDestPropRtAmt = ficDestPropRtAmt;
		this.creUsrId = creUsrId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.prsScgAmt = prsScgAmt;
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.prcProgStsNm = prcProgStsNm;
		this.creDt = creDt;
		this.destOptmTrspModFlg = destOptmTrspModFlg;
		this.prsUpdDt = prsUpdDt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.ibflag = ibflag;
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
		this.ficDestGlineUpdDt = ficDestGlineUpdDt;
		this.expDt = expDt;
		this.updDt = updDt;
		this.orgOptmTrspModFlg = orgOptmTrspModFlg;
		this.ficOrgPropRtAmt = ficOrgPropRtAmt;
		this.ficFnlRtAmt = ficFnlRtAmt;
		this.acptOfcCd = acptOfcCd;
		this.acptDt = acptDt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.srcInfoCd = srcInfoCd;
		this.acptUsrId = acptUsrId;
		this.ficOrgRtUseStsCd = ficOrgRtUseStsCd;
		this.ficOrgFnlRtAmt = ficOrgFnlRtAmt;
		this.srcInfoNm = srcInfoNm;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
		this.prsGidCmpbAmt = prsGidCmpbAmt;
		this.ficPropRtAmt = ficPropRtAmt;
		this.prsRespbOpbAmt = prsRespbOpbAmt;
		this.propNo = propNo;
		this.ficDestFnlRtAmt = ficDestFnlRtAmt;
		this.ficOrgGlineUpdDt = ficOrgGlineUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fic_dest_gline_rt_amt", getFicDestGlineRtAmt());
		this.hashColumns.put("fic_org_coffr_rt_amt", getFicOrgCoffrRtAmt());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("gri_appl_amt", getGriApplAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("fic_dest_rt_use_sts_cd", getFicDestRtUseStsCd());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fic_coffr_rt_amt", getFicCoffrRtAmt());
		this.hashColumns.put("prs_pfit_cmpb_amt", getPrsPfitCmpbAmt());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
		this.hashColumns.put("prs_pfit_cm_uc_amt", getPrsPfitCmUcAmt());
		this.hashColumns.put("fic_org_gline_rt_amt", getFicOrgGlineRtAmt());
		this.hashColumns.put("fic_dest_coffr_rt_amt", getFicDestCoffrRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fic_gline_rt_amt", getFicGlineRtAmt());
		this.hashColumns.put("spec_cnt", getSpecCnt());
		this.hashColumns.put("gri_appl_tp_cd", getGriApplTpCd());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("fic_dest_prop_rt_amt", getFicDestPropRtAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prs_scg_amt", getPrsScgAmt());
		this.hashColumns.put("prs_respb_cm_uc_amt", getPrsRespbCmUcAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("prc_prog_sts_nm", getPrcProgStsNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dest_optm_trsp_mod_flg", getDestOptmTrspModFlg());
		this.hashColumns.put("prs_upd_dt", getPrsUpdDt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prs_respb_opfit_uc_amt", getPrsRespbOpfitUcAmt());
		this.hashColumns.put("fic_dest_gline_upd_dt", getFicDestGlineUpdDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_optm_trsp_mod_flg", getOrgOptmTrspModFlg());
		this.hashColumns.put("fic_org_prop_rt_amt", getFicOrgPropRtAmt());
		this.hashColumns.put("fic_fnl_rt_amt", getFicFnlRtAmt());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("fic_org_rt_use_sts_cd", getFicOrgRtUseStsCd());
		this.hashColumns.put("fic_org_fnl_rt_amt", getFicOrgFnlRtAmt());
		this.hashColumns.put("src_info_nm", getSrcInfoNm());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("prs_respb_cmpb_amt", getPrsRespbCmpbAmt());
		this.hashColumns.put("prs_gid_cmpb_amt", getPrsGidCmpbAmt());
		this.hashColumns.put("fic_prop_rt_amt", getFicPropRtAmt());
		this.hashColumns.put("prs_respb_opb_amt", getPrsRespbOpbAmt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("fic_dest_fnl_rt_amt", getFicDestFnlRtAmt());
		this.hashColumns.put("fic_org_gline_upd_dt", getFicOrgGlineUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fic_dest_gline_rt_amt", "ficDestGlineRtAmt");
		this.hashFields.put("fic_org_coffr_rt_amt", "ficOrgCoffrRtAmt");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("gri_appl_amt", "griApplAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("fic_dest_rt_use_sts_cd", "ficDestRtUseStsCd");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fic_coffr_rt_amt", "ficCoffrRtAmt");
		this.hashFields.put("prs_pfit_cmpb_amt", "prsPfitCmpbAmt");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
		this.hashFields.put("prs_pfit_cm_uc_amt", "prsPfitCmUcAmt");
		this.hashFields.put("fic_org_gline_rt_amt", "ficOrgGlineRtAmt");
		this.hashFields.put("fic_dest_coffr_rt_amt", "ficDestCoffrRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fic_gline_rt_amt", "ficGlineRtAmt");
		this.hashFields.put("spec_cnt", "specCnt");
		this.hashFields.put("gri_appl_tp_cd", "griApplTpCd");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("fic_dest_prop_rt_amt", "ficDestPropRtAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prs_scg_amt", "prsScgAmt");
		this.hashFields.put("prs_respb_cm_uc_amt", "prsRespbCmUcAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("prc_prog_sts_nm", "prcProgStsNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dest_optm_trsp_mod_flg", "destOptmTrspModFlg");
		this.hashFields.put("prs_upd_dt", "prsUpdDt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prs_respb_opfit_uc_amt", "prsRespbOpfitUcAmt");
		this.hashFields.put("fic_dest_gline_upd_dt", "ficDestGlineUpdDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_optm_trsp_mod_flg", "orgOptmTrspModFlg");
		this.hashFields.put("fic_org_prop_rt_amt", "ficOrgPropRtAmt");
		this.hashFields.put("fic_fnl_rt_amt", "ficFnlRtAmt");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("fic_org_rt_use_sts_cd", "ficOrgRtUseStsCd");
		this.hashFields.put("fic_org_fnl_rt_amt", "ficOrgFnlRtAmt");
		this.hashFields.put("src_info_nm", "srcInfoNm");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("prs_respb_cmpb_amt", "prsRespbCmpbAmt");
		this.hashFields.put("prs_gid_cmpb_amt", "prsGidCmpbAmt");
		this.hashFields.put("fic_prop_rt_amt", "ficPropRtAmt");
		this.hashFields.put("prs_respb_opb_amt", "prsRespbOpbAmt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("fic_dest_fnl_rt_amt", "ficDestFnlRtAmt");
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
	 * @return ficOrgCoffrRtAmt
	 */
	public String getFicOrgCoffrRtAmt() {
		return this.ficOrgCoffrRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return griApplAmt
	 */
	public String getGriApplAmt() {
		return this.griApplAmt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return coffrFrtRtAmt
	 */
	public String getCoffrFrtRtAmt() {
		return this.coffrFrtRtAmt;
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
	 * @return ficCoffrRtAmt
	 */
	public String getFicCoffrRtAmt() {
		return this.ficCoffrRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prsPfitCmpbAmt
	 */
	public String getPrsPfitCmpbAmt() {
		return this.prsPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ficDestCoffrRtAmt
	 */
	public String getFicDestCoffrRtAmt() {
		return this.ficDestCoffrRtAmt;
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
	 * @return specCnt
	 */
	public String getSpecCnt() {
		return this.specCnt;
	}
	
	/**
	 * Column Info
	 * @return griApplTpCd
	 */
	public String getGriApplTpCd() {
		return this.griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
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
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
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
	 * @return ficDestPropRtAmt
	 */
	public String getFicDestPropRtAmt() {
		return this.ficDestPropRtAmt;
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
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
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
	 * @return prcProgStsNm
	 */
	public String getPrcProgStsNm() {
		return this.prcProgStsNm;
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
	 * @return destOptmTrspModFlg
	 */
	public String getDestOptmTrspModFlg() {
		return this.destOptmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @return prsUpdDt
	 */
	public String getPrsUpdDt() {
		return this.prsUpdDt;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
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
	 * @return prsRespbOpfitUcAmt
	 */
	public String getPrsRespbOpfitUcAmt() {
		return this.prsRespbOpfitUcAmt;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return ficOrgPropRtAmt
	 */
	public String getFicOrgPropRtAmt() {
		return this.ficOrgPropRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ficFnlRtAmt
	 */
	public String getFicFnlRtAmt() {
		return this.ficFnlRtAmt;
	}
	
	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
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
	 * @return acptUsrId
	 */
	public String getAcptUsrId() {
		return this.acptUsrId;
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
	 * @return ficOrgFnlRtAmt
	 */
	public String getFicOrgFnlRtAmt() {
		return this.ficOrgFnlRtAmt;
	}
	
	/**
	 * Column Info
	 * @return srcInfoNm
	 */
	public String getSrcInfoNm() {
		return this.srcInfoNm;
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
	 * @return prsRespbCmpbAmt
	 */
	public String getPrsRespbCmpbAmt() {
		return this.prsRespbCmpbAmt;
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
	 * @return ficPropRtAmt
	 */
	public String getFicPropRtAmt() {
		return this.ficPropRtAmt;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return ficDestFnlRtAmt
	 */
	public String getFicDestFnlRtAmt() {
		return this.ficDestFnlRtAmt;
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
	 * @param ficOrgCoffrRtAmt
	 */
	public void setFicOrgCoffrRtAmt(String ficOrgCoffrRtAmt) {
		this.ficOrgCoffrRtAmt = ficOrgCoffrRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param griApplAmt
	 */
	public void setGriApplAmt(String griApplAmt) {
		this.griApplAmt = griApplAmt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param coffrFrtRtAmt
	 */
	public void setCoffrFrtRtAmt(String coffrFrtRtAmt) {
		this.coffrFrtRtAmt = coffrFrtRtAmt;
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
	 * @param ficCoffrRtAmt
	 */
	public void setFicCoffrRtAmt(String ficCoffrRtAmt) {
		this.ficCoffrRtAmt = ficCoffrRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prsPfitCmpbAmt
	 */
	public void setPrsPfitCmpbAmt(String prsPfitCmpbAmt) {
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ficDestCoffrRtAmt
	 */
	public void setFicDestCoffrRtAmt(String ficDestCoffrRtAmt) {
		this.ficDestCoffrRtAmt = ficDestCoffrRtAmt;
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
	 * @param specCnt
	 */
	public void setSpecCnt(String specCnt) {
		this.specCnt = specCnt;
	}
	
	/**
	 * Column Info
	 * @param griApplTpCd
	 */
	public void setGriApplTpCd(String griApplTpCd) {
		this.griApplTpCd = griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
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
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
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
	 * @param ficDestPropRtAmt
	 */
	public void setFicDestPropRtAmt(String ficDestPropRtAmt) {
		this.ficDestPropRtAmt = ficDestPropRtAmt;
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
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
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
	 * @param prcProgStsNm
	 */
	public void setPrcProgStsNm(String prcProgStsNm) {
		this.prcProgStsNm = prcProgStsNm;
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
	 * @param destOptmTrspModFlg
	 */
	public void setDestOptmTrspModFlg(String destOptmTrspModFlg) {
		this.destOptmTrspModFlg = destOptmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @param prsUpdDt
	 */
	public void setPrsUpdDt(String prsUpdDt) {
		this.prsUpdDt = prsUpdDt;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
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
	 * @param prsRespbOpfitUcAmt
	 */
	public void setPrsRespbOpfitUcAmt(String prsRespbOpfitUcAmt) {
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param ficOrgPropRtAmt
	 */
	public void setFicOrgPropRtAmt(String ficOrgPropRtAmt) {
		this.ficOrgPropRtAmt = ficOrgPropRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ficFnlRtAmt
	 */
	public void setFicFnlRtAmt(String ficFnlRtAmt) {
		this.ficFnlRtAmt = ficFnlRtAmt;
	}
	
	/**
	 * Column Info
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
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
	 * @param acptUsrId
	 */
	public void setAcptUsrId(String acptUsrId) {
		this.acptUsrId = acptUsrId;
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
	 * @param ficOrgFnlRtAmt
	 */
	public void setFicOrgFnlRtAmt(String ficOrgFnlRtAmt) {
		this.ficOrgFnlRtAmt = ficOrgFnlRtAmt;
	}
	
	/**
	 * Column Info
	 * @param srcInfoNm
	 */
	public void setSrcInfoNm(String srcInfoNm) {
		this.srcInfoNm = srcInfoNm;
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
	 * @param prsRespbCmpbAmt
	 */
	public void setPrsRespbCmpbAmt(String prsRespbCmpbAmt) {
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
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
	 * @param ficPropRtAmt
	 */
	public void setFicPropRtAmt(String ficPropRtAmt) {
		this.ficPropRtAmt = ficPropRtAmt;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param ficDestFnlRtAmt
	 */
	public void setFicDestFnlRtAmt(String ficDestFnlRtAmt) {
		this.ficDestFnlRtAmt = ficDestFnlRtAmt;
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
		setFicOrgCoffrRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_coffr_rt_amt", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setGriApplAmt(JSPUtil.getParameter(request, prefix + "gri_appl_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFicDestRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_dest_rt_use_sts_cd", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request, prefix + "coffr_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFicCoffrRtAmt(JSPUtil.getParameter(request, prefix + "fic_coffr_rt_amt", ""));
		setPrsPfitCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cmpb_amt", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, prefix + "prc_prog_sts_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setFicGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", ""));
		setPrsPfitCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cm_uc_amt", ""));
		setFicOrgGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_gline_rt_amt", ""));
		setFicDestCoffrRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_coffr_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFicGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", ""));
		setSpecCnt(JSPUtil.getParameter(request, prefix + "spec_cnt", ""));
		setGriApplTpCd(JSPUtil.getParameter(request, prefix + "gri_appl_tp_cd", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, prefix + "acpt_usr_nm", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setFicDestPropRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_prop_rt_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPrsScgAmt(JSPUtil.getParameter(request, prefix + "prs_scg_amt", ""));
		setPrsRespbCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cm_uc_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setPrcProgStsNm(JSPUtil.getParameter(request, prefix + "prc_prog_sts_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDestOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "dest_optm_trsp_mod_flg", ""));
		setPrsUpdDt(JSPUtil.getParameter(request, prefix + "prs_upd_dt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrsRespbOpfitUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opfit_uc_amt", ""));
		setFicDestGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_dest_gline_upd_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOrgOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "org_optm_trsp_mod_flg", ""));
		setFicOrgPropRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_prop_rt_amt", ""));
		setFicFnlRtAmt(JSPUtil.getParameter(request, prefix + "fic_fnl_rt_amt", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, prefix + "acpt_ofc_cd", ""));
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setAcptUsrId(JSPUtil.getParameter(request, prefix + "acpt_usr_id", ""));
		setFicOrgRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_org_rt_use_sts_cd", ""));
		setFicOrgFnlRtAmt(JSPUtil.getParameter(request, prefix + "fic_org_fnl_rt_amt", ""));
		setSrcInfoNm(JSPUtil.getParameter(request, prefix + "src_info_nm", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setPrsRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cmpb_amt", ""));
		setPrsGidCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_gid_cmpb_amt", ""));
		setFicPropRtAmt(JSPUtil.getParameter(request, prefix + "fic_prop_rt_amt", ""));
		setPrsRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opb_amt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setFicDestFnlRtAmt(JSPUtil.getParameter(request, prefix + "fic_dest_fnl_rt_amt", ""));
		setFicOrgGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_org_gline_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtDtlInquiryListVO[]
	 */
	public RsltRtDtlInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtDtlInquiryListVO[]
	 */
	public RsltRtDtlInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtDtlInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ficDestGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_rt_amt", length));
			String[] ficOrgCoffrRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_coffr_rt_amt", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] griApplAmt = (JSPUtil.getParameter(request, prefix	+ "gri_appl_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] ficDestRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_dest_rt_use_sts_cd", length));
			String[] coffrFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "coffr_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ficCoffrRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_coffr_rt_amt", length));
			String[] prsPfitCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cmpb_amt", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_upd_dt", length));
			String[] prsPfitCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cm_uc_amt", length));
			String[] ficOrgGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_rt_amt", length));
			String[] ficDestCoffrRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_coffr_rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ficGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt", length));
			String[] specCnt = (JSPUtil.getParameter(request, prefix	+ "spec_cnt", length));
			String[] griApplTpCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_tp_cd", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ficDestPropRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_prop_rt_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] prsScgAmt = (JSPUtil.getParameter(request, prefix	+ "prs_scg_amt", length));
			String[] prsRespbCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cm_uc_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] prcProgStsNm = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] destOptmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "dest_optm_trsp_mod_flg", length));
			String[] prsUpdDt = (JSPUtil.getParameter(request, prefix	+ "prs_upd_dt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prsRespbOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opfit_uc_amt", length));
			String[] ficDestGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_gline_upd_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgOptmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "org_optm_trsp_mod_flg", length));
			String[] ficOrgPropRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_prop_rt_amt", length));
			String[] ficFnlRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_fnl_rt_amt", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] acptUsrId = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_id", length));
			String[] ficOrgRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_org_rt_use_sts_cd", length));
			String[] ficOrgFnlRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_org_fnl_rt_amt", length));
			String[] srcInfoNm = (JSPUtil.getParameter(request, prefix	+ "src_info_nm", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] prsRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cmpb_amt", length));
			String[] prsGidCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_gid_cmpb_amt", length));
			String[] ficPropRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_prop_rt_amt", length));
			String[] prsRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opb_amt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] ficDestFnlRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_dest_fnl_rt_amt", length));
			String[] ficOrgGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_org_gline_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtDtlInquiryListVO();
				if (ficDestGlineRtAmt[i] != null)
					model.setFicDestGlineRtAmt(ficDestGlineRtAmt[i]);
				if (ficOrgCoffrRtAmt[i] != null)
					model.setFicOrgCoffrRtAmt(ficOrgCoffrRtAmt[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (griApplAmt[i] != null)
					model.setGriApplAmt(griApplAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (ficDestRtUseStsCd[i] != null)
					model.setFicDestRtUseStsCd(ficDestRtUseStsCd[i]);
				if (coffrFrtRtAmt[i] != null)
					model.setCoffrFrtRtAmt(coffrFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ficCoffrRtAmt[i] != null)
					model.setFicCoffrRtAmt(ficCoffrRtAmt[i]);
				if (prsPfitCmpbAmt[i] != null)
					model.setPrsPfitCmpbAmt(prsPfitCmpbAmt[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ficGlineUpdDt[i] != null)
					model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (prsPfitCmUcAmt[i] != null)
					model.setPrsPfitCmUcAmt(prsPfitCmUcAmt[i]);
				if (ficOrgGlineRtAmt[i] != null)
					model.setFicOrgGlineRtAmt(ficOrgGlineRtAmt[i]);
				if (ficDestCoffrRtAmt[i] != null)
					model.setFicDestCoffrRtAmt(ficDestCoffrRtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ficGlineRtAmt[i] != null)
					model.setFicGlineRtAmt(ficGlineRtAmt[i]);
				if (specCnt[i] != null)
					model.setSpecCnt(specCnt[i]);
				if (griApplTpCd[i] != null)
					model.setGriApplTpCd(griApplTpCd[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ficDestPropRtAmt[i] != null)
					model.setFicDestPropRtAmt(ficDestPropRtAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (prsScgAmt[i] != null)
					model.setPrsScgAmt(prsScgAmt[i]);
				if (prsRespbCmUcAmt[i] != null)
					model.setPrsRespbCmUcAmt(prsRespbCmUcAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (prcProgStsNm[i] != null)
					model.setPrcProgStsNm(prcProgStsNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (destOptmTrspModFlg[i] != null)
					model.setDestOptmTrspModFlg(destOptmTrspModFlg[i]);
				if (prsUpdDt[i] != null)
					model.setPrsUpdDt(prsUpdDt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prsRespbOpfitUcAmt[i] != null)
					model.setPrsRespbOpfitUcAmt(prsRespbOpfitUcAmt[i]);
				if (ficDestGlineUpdDt[i] != null)
					model.setFicDestGlineUpdDt(ficDestGlineUpdDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgOptmTrspModFlg[i] != null)
					model.setOrgOptmTrspModFlg(orgOptmTrspModFlg[i]);
				if (ficOrgPropRtAmt[i] != null)
					model.setFicOrgPropRtAmt(ficOrgPropRtAmt[i]);
				if (ficFnlRtAmt[i] != null)
					model.setFicFnlRtAmt(ficFnlRtAmt[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (acptUsrId[i] != null)
					model.setAcptUsrId(acptUsrId[i]);
				if (ficOrgRtUseStsCd[i] != null)
					model.setFicOrgRtUseStsCd(ficOrgRtUseStsCd[i]);
				if (ficOrgFnlRtAmt[i] != null)
					model.setFicOrgFnlRtAmt(ficOrgFnlRtAmt[i]);
				if (srcInfoNm[i] != null)
					model.setSrcInfoNm(srcInfoNm[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (prsRespbCmpbAmt[i] != null)
					model.setPrsRespbCmpbAmt(prsRespbCmpbAmt[i]);
				if (prsGidCmpbAmt[i] != null)
					model.setPrsGidCmpbAmt(prsGidCmpbAmt[i]);
				if (ficPropRtAmt[i] != null)
					model.setFicPropRtAmt(ficPropRtAmt[i]);
				if (prsRespbOpbAmt[i] != null)
					model.setPrsRespbOpbAmt(prsRespbOpbAmt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (ficDestFnlRtAmt[i] != null)
					model.setFicDestFnlRtAmt(ficDestFnlRtAmt[i]);
				if (ficOrgGlineUpdDt[i] != null)
					model.setFicOrgGlineUpdDt(ficOrgGlineUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtDtlInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtDtlInquiryListVO[]
	 */
	public RsltRtDtlInquiryListVO[] getRsltRtDtlInquiryListVOs(){
		RsltRtDtlInquiryListVO[] vos = (RsltRtDtlInquiryListVO[])models.toArray(new RsltRtDtlInquiryListVO[models.size()]);
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
		this.ficOrgCoffrRtAmt = this.ficOrgCoffrRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplAmt = this.griApplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestRtUseStsCd = this.ficDestRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt = this.coffrFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficCoffrRtAmt = this.ficCoffrRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPfitCmpbAmt = this.prsPfitCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineUpdDt = this.ficGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPfitCmUcAmt = this.prsPfitCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineRtAmt = this.ficOrgGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestCoffrRtAmt = this.ficDestCoffrRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmt = this.ficGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specCnt = this.specCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplTpCd = this.griApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestPropRtAmt = this.ficDestPropRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsScgAmt = this.prsScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmUcAmt = this.prsRespbCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsNm = this.prcProgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOptmTrspModFlg = this.destOptmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsUpdDt = this.prsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpfitUcAmt = this.prsRespbOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestGlineUpdDt = this.ficDestGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOptmTrspModFlg = this.orgOptmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgPropRtAmt = this.ficOrgPropRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficFnlRtAmt = this.ficFnlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId = this.acptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgRtUseStsCd = this.ficOrgRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgFnlRtAmt = this.ficOrgFnlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoNm = this.srcInfoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmpbAmt = this.prsRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsGidCmpbAmt = this.prsGidCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropRtAmt = this.ficPropRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpbAmt = this.prsRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficDestFnlRtAmt = this.ficDestFnlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficOrgGlineUpdDt = this.ficOrgGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
