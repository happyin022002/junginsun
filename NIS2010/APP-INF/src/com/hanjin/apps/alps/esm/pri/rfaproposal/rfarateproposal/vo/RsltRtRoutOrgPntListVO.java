/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltRtRoutOrgPntListVO.java
*@FileTitle : RsltRtRoutOrgPntListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.29 이은섭 
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

public class RsltRtRoutOrgPntListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtRoutOrgPntListVO> models = new ArrayList<RsltRtRoutOrgPntListVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String prcProgStsNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String dg40ftAmt = null;
	/* Column Info */
	private String orgCyDorRtTpCd = null;
	/* Column Info */
	private String rf20ftAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String groupNo = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String dg20ftAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String routPntSeq = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String routPntLocTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rf40ftAmt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String basePortList = null;
	/* Column Info */
	private String routPntLocDefNm = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String acptUsrId = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String srcInfoNm = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String nextN1stCmncAmdtSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String n1stOrdRef = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String n2ndOrdRef = null;
	/* Column Info */
	private String dr40ftAmt = null;
	/* Column Info */
	private String dr20ftAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtRoutOrgPntListVO() {}

	public RsltRtRoutOrgPntListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String orgDestTpCd, String routPntSeq, String routPntLocTpCd, String routPntLocDefCd, String routPntLocDefNm, String prcTrspModCd, String rcvDeTermCd, String prcProgStsCd, String prcProgStsNm, String srcInfoCd, String srcInfoNm, String n1stCmncAmdtSeq, String nextN1stCmncAmdtSeq, String effDt, String expDt, String acptUsrId, String acptUsrNm, String acptDt, String creUsrId, String creDt, String updUsrId, String updDt, String n1stOrdRef, String n2ndOrdRef, String orgCyDorRtTpCd, String bsePortLocCd, String bsePortDefCd, String basePortList, String ficRtUseStsCd, String ficRoutCmbTpCd, String optmTrspModFlg, String groupNo, String dr20ftAmt, String rf20ftAmt, String dg20ftAmt, String dr40ftAmt, String rf40ftAmt, String dg40ftAmt) {
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.prcProgStsNm = prcProgStsNm;
		this.creDt = creDt;
		this.routPntLocDefCd = routPntLocDefCd;
		this.dg40ftAmt = dg40ftAmt;
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
		this.rf20ftAmt = rf20ftAmt;
		this.pagerows = pagerows;
		this.groupNo = groupNo;
		this.prcProgStsCd = prcProgStsCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.dg20ftAmt = dg20ftAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.routPntSeq = routPntSeq;
		this.bsePortLocCd = bsePortLocCd;
		this.routPntLocTpCd = routPntLocTpCd;
		this.updDt = updDt;
		this.rf40ftAmt = rf40ftAmt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.acptDt = acptDt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.basePortList = basePortList;
		this.routPntLocDefNm = routPntLocDefNm;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
		this.acptUsrNm = acptUsrNm;
		this.srcInfoCd = srcInfoCd;
		this.acptUsrId = acptUsrId;
		this.orgDestTpCd = orgDestTpCd;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.srcInfoNm = srcInfoNm;
		this.bsePortDefCd = bsePortDefCd;
		this.routSeq = routSeq;
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
		this.creUsrId = creUsrId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.n1stOrdRef = n1stOrdRef;
		this.prcTrspModCd = prcTrspModCd;
		this.n2ndOrdRef = n2ndOrdRef;
		this.dr40ftAmt = dr40ftAmt;
		this.dr20ftAmt = dr20ftAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prc_prog_sts_nm", getPrcProgStsNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("dg_40ft_amt", getDg40ftAmt());
		this.hashColumns.put("org_cy_dor_rt_tp_cd", getOrgCyDorRtTpCd());
		this.hashColumns.put("rf_20ft_amt", getRf20ftAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("group_no", getGroupNo());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("dg_20ft_amt", getDg20ftAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rout_pnt_seq", getRoutPntSeq());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rf_40ft_amt", getRf40ftAmt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("base_port_list", getBasePortList());
		this.hashColumns.put("rout_pnt_loc_def_nm", getRoutPntLocDefNm());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("src_info_nm", getSrcInfoNm());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("next_n1st_cmnc_amdt_seq", getNextN1stCmncAmdtSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("n1st_ord_ref", getN1stOrdRef());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("n2nd_ord_ref", getN2ndOrdRef());
		this.hashColumns.put("dr_40ft_amt", getDr40ftAmt());
		this.hashColumns.put("dr_20ft_amt", getDr20ftAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prc_prog_sts_nm", "prcProgStsNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("dg_40ft_amt", "dg40ftAmt");
		this.hashFields.put("org_cy_dor_rt_tp_cd", "orgCyDorRtTpCd");
		this.hashFields.put("rf_20ft_amt", "rf20ftAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("group_no", "groupNo");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("dg_20ft_amt", "dg20ftAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rout_pnt_seq", "routPntSeq");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rf_40ft_amt", "rf40ftAmt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("base_port_list", "basePortList");
		this.hashFields.put("rout_pnt_loc_def_nm", "routPntLocDefNm");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("src_info_nm", "srcInfoNm");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("next_n1st_cmnc_amdt_seq", "nextN1stCmncAmdtSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("n1st_ord_ref", "n1stOrdRef");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("n2nd_ord_ref", "n2ndOrdRef");
		this.hashFields.put("dr_40ft_amt", "dr40ftAmt");
		this.hashFields.put("dr_20ft_amt", "dr20ftAmt");
		return this.hashFields;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return dg40ftAmt
	 */
	public String getDg40ftAmt() {
		return this.dg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCyDorRtTpCd
	 */
	public String getOrgCyDorRtTpCd() {
		return this.orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rf20ftAmt
	 */
	public String getRf20ftAmt() {
		return this.rf20ftAmt;
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
	 * @return groupNo
	 */
	public String getGroupNo() {
		return this.groupNo;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return dg20ftAmt
	 */
	public String getDg20ftAmt() {
		return this.dg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return routPntSeq
	 */
	public String getRoutPntSeq() {
		return this.routPntSeq;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return routPntLocTpCd
	 */
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
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
	 * @return rf40ftAmt
	 */
	public String getRf40ftAmt() {
		return this.rf40ftAmt;
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
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
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
	 * @return basePortList
	 */
	public String getBasePortList() {
		return this.basePortList;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefNm
	 */
	public String getRoutPntLocDefNm() {
		return this.routPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return ficRoutCmbTpCd
	 */
	public String getFicRoutCmbTpCd() {
		return this.ficRoutCmbTpCd;
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
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
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
	 * @return srcInfoNm
	 */
	public String getSrcInfoNm() {
		return this.srcInfoNm;
	}
	
	/**
	 * Column Info
	 * @return bsePortDefCd
	 */
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
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
	 * @return nextN1stCmncAmdtSeq
	 */
	public String getNextN1stCmncAmdtSeq() {
		return this.nextN1stCmncAmdtSeq;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return n1stOrdRef
	 */
	public String getN1stOrdRef() {
		return this.n1stOrdRef;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndOrdRef
	 */
	public String getN2ndOrdRef() {
		return this.n2ndOrdRef;
	}
	
	/**
	 * Column Info
	 * @return dr40ftAmt
	 */
	public String getDr40ftAmt() {
		return this.dr40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dr20ftAmt
	 */
	public String getDr20ftAmt() {
		return this.dr20ftAmt;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param dg40ftAmt
	 */
	public void setDg40ftAmt(String dg40ftAmt) {
		this.dg40ftAmt = dg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCyDorRtTpCd
	 */
	public void setOrgCyDorRtTpCd(String orgCyDorRtTpCd) {
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rf20ftAmt
	 */
	public void setRf20ftAmt(String rf20ftAmt) {
		this.rf20ftAmt = rf20ftAmt;
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
	 * @param groupNo
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param dg20ftAmt
	 */
	public void setDg20ftAmt(String dg20ftAmt) {
		this.dg20ftAmt = dg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param routPntSeq
	 */
	public void setRoutPntSeq(String routPntSeq) {
		this.routPntSeq = routPntSeq;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param routPntLocTpCd
	 */
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
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
	 * @param rf40ftAmt
	 */
	public void setRf40ftAmt(String rf40ftAmt) {
		this.rf40ftAmt = rf40ftAmt;
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
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
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
	 * @param basePortList
	 */
	public void setBasePortList(String basePortList) {
		this.basePortList = basePortList;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefNm
	 */
	public void setRoutPntLocDefNm(String routPntLocDefNm) {
		this.routPntLocDefNm = routPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param ficRoutCmbTpCd
	 */
	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
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
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
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
	 * @param srcInfoNm
	 */
	public void setSrcInfoNm(String srcInfoNm) {
		this.srcInfoNm = srcInfoNm;
	}
	
	/**
	 * Column Info
	 * @param bsePortDefCd
	 */
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
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
	 * @param nextN1stCmncAmdtSeq
	 */
	public void setNextN1stCmncAmdtSeq(String nextN1stCmncAmdtSeq) {
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param n1stOrdRef
	 */
	public void setN1stOrdRef(String n1stOrdRef) {
		this.n1stOrdRef = n1stOrdRef;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndOrdRef
	 */
	public void setN2ndOrdRef(String n2ndOrdRef) {
		this.n2ndOrdRef = n2ndOrdRef;
	}
	
	/**
	 * Column Info
	 * @param dr40ftAmt
	 */
	public void setDr40ftAmt(String dr40ftAmt) {
		this.dr40ftAmt = dr40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dr20ftAmt
	 */
	public void setDr20ftAmt(String dr20ftAmt) {
		this.dr20ftAmt = dr20ftAmt;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPrcProgStsNm(JSPUtil.getParameter(request, prefix + "prc_prog_sts_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", ""));
		setDg40ftAmt(JSPUtil.getParameter(request, prefix + "dg_40ft_amt", ""));
		setOrgCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "org_cy_dor_rt_tp_cd", ""));
		setRf20ftAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGroupNo(JSPUtil.getParameter(request, prefix + "group_no", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, prefix + "prc_prog_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setDg20ftAmt(JSPUtil.getParameter(request, prefix + "dg_20ft_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRoutPntSeq(JSPUtil.getParameter(request, prefix + "rout_pnt_seq", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRf40ftAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_amt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setBasePortList(JSPUtil.getParameter(request, prefix + "base_port_list", ""));
		setRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_nm", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, prefix + "acpt_usr_nm", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setAcptUsrId(JSPUtil.getParameter(request, prefix + "acpt_usr_id", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setSrcInfoNm(JSPUtil.getParameter(request, prefix + "src_info_nm", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, prefix + "bse_port_def_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setNextN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "next_n1st_cmnc_amdt_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setN1stOrdRef(JSPUtil.getParameter(request, prefix + "n1st_ord_ref", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setN2ndOrdRef(JSPUtil.getParameter(request, prefix + "n2nd_ord_ref", ""));
		setDr40ftAmt(JSPUtil.getParameter(request, prefix + "dr_40ft_amt", ""));
		setDr20ftAmt(JSPUtil.getParameter(request, prefix + "dr_20ft_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtRoutOrgPntListVO[]
	 */
	public RsltRtRoutOrgPntListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtRoutOrgPntListVO[]
	 */
	public RsltRtRoutOrgPntListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtRoutOrgPntListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] prcProgStsNm = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] dg40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_40ft_amt", length));
			String[] orgCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "org_cy_dor_rt_tp_cd", length));
			String[] rf20ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] groupNo = (JSPUtil.getParameter(request, prefix	+ "group_no", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] dg20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_20ft_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] routPntSeq = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_seq", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rf40ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_amt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] basePortList = (JSPUtil.getParameter(request, prefix	+ "base_port_list", length));
			String[] routPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_nm", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_rout_cmb_tp_cd", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] acptUsrId = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_id", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] srcInfoNm = (JSPUtil.getParameter(request, prefix	+ "src_info_nm", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] nextN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "next_n1st_cmnc_amdt_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] n1stOrdRef = (JSPUtil.getParameter(request, prefix	+ "n1st_ord_ref", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] n2ndOrdRef = (JSPUtil.getParameter(request, prefix	+ "n2nd_ord_ref", length));
			String[] dr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_40ft_amt", length));
			String[] dr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_20ft_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtRoutOrgPntListVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (prcProgStsNm[i] != null)
					model.setPrcProgStsNm(prcProgStsNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (dg40ftAmt[i] != null)
					model.setDg40ftAmt(dg40ftAmt[i]);
				if (orgCyDorRtTpCd[i] != null)
					model.setOrgCyDorRtTpCd(orgCyDorRtTpCd[i]);
				if (rf20ftAmt[i] != null)
					model.setRf20ftAmt(rf20ftAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (groupNo[i] != null)
					model.setGroupNo(groupNo[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (dg20ftAmt[i] != null)
					model.setDg20ftAmt(dg20ftAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (routPntSeq[i] != null)
					model.setRoutPntSeq(routPntSeq[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rf40ftAmt[i] != null)
					model.setRf40ftAmt(rf40ftAmt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (basePortList[i] != null)
					model.setBasePortList(basePortList[i]);
				if (routPntLocDefNm[i] != null)
					model.setRoutPntLocDefNm(routPntLocDefNm[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (acptUsrId[i] != null)
					model.setAcptUsrId(acptUsrId[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (srcInfoNm[i] != null)
					model.setSrcInfoNm(srcInfoNm[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (nextN1stCmncAmdtSeq[i] != null)
					model.setNextN1stCmncAmdtSeq(nextN1stCmncAmdtSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (n1stOrdRef[i] != null)
					model.setN1stOrdRef(n1stOrdRef[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (n2ndOrdRef[i] != null)
					model.setN2ndOrdRef(n2ndOrdRef[i]);
				if (dr40ftAmt[i] != null)
					model.setDr40ftAmt(dr40ftAmt[i]);
				if (dr20ftAmt[i] != null)
					model.setDr20ftAmt(dr20ftAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtRoutOrgPntListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtRoutOrgPntListVO[]
	 */
	public RsltRtRoutOrgPntListVO[] getRsltRtRoutOrgPntListVOs(){
		RsltRtRoutOrgPntListVO[] vos = (RsltRtRoutOrgPntListVO[])models.toArray(new RsltRtRoutOrgPntListVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsNm = this.prcProgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40ftAmt = this.dg40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCyDorRtTpCd = this.orgCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftAmt = this.rf20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupNo = this.groupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20ftAmt = this.dg20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntSeq = this.routPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd = this.routPntLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftAmt = this.rf40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basePortList = this.basePortList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefNm = this.routPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId = this.acptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoNm = this.srcInfoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextN1stCmncAmdtSeq = this.nextN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stOrdRef = this.n1stOrdRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndOrdRef = this.n2ndOrdRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dr40ftAmt = this.dr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dr20ftAmt = this.dr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
