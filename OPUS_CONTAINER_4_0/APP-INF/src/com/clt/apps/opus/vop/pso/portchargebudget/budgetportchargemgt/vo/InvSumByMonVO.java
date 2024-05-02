/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvSumByMonVO.java
*@FileTitle : InvSumByMonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.09 정명훈 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class InvSumByMonVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InvSumByMonVO> models = new ArrayList<InvSumByMonVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String combo1 = null;

    /* Column Info */
    private String fomlDesc = null;

    /* Column Info */
    private String soSeq = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String acctEngNm = null;

    /* Column Info */
    private String issCtyCd = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vopPortRhqCd = null;

    /* Column Info */
    private String slsOfcCd = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String status = null;

    /* Column Info */
    private String loclAmt = null;

    /* Column Info */
    private String adjAmt = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String psoChgStsNm = null;

    /* Column Info */
    private String toDate = null;

    /* Column Info */
    private String calcAmt = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String differ = null;

    /* Column Info */
    private String usdAmt = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String fromDate = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String soDtlSeq = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String xprDesc = null;

    /* Column Info */
    private String termCode = null;

    /* Column Info */
    private String dateType = null;

    /* Column Info */
    private String cntrVslCassCapa = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String costNm = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String vskdPortRhqCd = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String vslClss = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String io = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String revVvd = null;

    /* Column Info */
    private String actDt = null;

    /* Column Info */
    private String payDueDt = null;

    /* Column Info */
    private String payDt = null;

    /* Column Info */
    private String chkData = null;

    /* Column Info */
    private String clptIndSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public InvSumByMonVO() {
    }

    public InvSumByMonVO(String ibflag, String pagerows, String issCtyCd, String soSeq, String soDtlSeq, String vslCd, String currCd, String combo1, String fomlDesc, String vndrLglEngNm, String acctEngNm, String acctCd, String portCd, String csrNo, String loclAmt, String adjAmt, String skdVoyNo, String psoChgStsNm, String toDate, String calcAmt, String skdDirCd, String invNo, String usdAmt, String diffRmk, String fromDate, String ydCd, String vndrSeq, String xprDesc, String termCode, String dateType, String cntrVslCassCapa, String costCd, String costNm, String vvd, String vskdPortRhqCd, String differ, String status, String vopPortRhqCd, String slsOfcCd, String vslSlanCd, String vslClss, String creUsrId, String creDt, String updUsrId, String updDt, String io, String rlaneCd, String revVvd, String actDt, String payDueDt, String payDt, String chkData, String clptIndSeq) {
        this.vslCd = vslCd;
        this.currCd = currCd;
        this.combo1 = combo1;
        this.fomlDesc = fomlDesc;
        this.soSeq = soSeq;
        this.vndrLglEngNm = vndrLglEngNm;
        this.acctEngNm = acctEngNm;
        this.issCtyCd = issCtyCd;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.vopPortRhqCd = vopPortRhqCd;
        this.slsOfcCd = slsOfcCd;
        this.acctCd = acctCd;
        this.portCd = portCd;
        this.csrNo = csrNo;
        this.status = status;
        this.loclAmt = loclAmt;
        this.adjAmt = adjAmt;
        this.skdVoyNo = skdVoyNo;
        this.psoChgStsNm = psoChgStsNm;
        this.toDate = toDate;
        this.calcAmt = calcAmt;
        this.skdDirCd = skdDirCd;
        this.invNo = invNo;
        this.differ = differ;
        this.usdAmt = usdAmt;
        this.diffRmk = diffRmk;
        this.fromDate = fromDate;
        this.ydCd = ydCd;
        this.soDtlSeq = soDtlSeq;
        this.vndrSeq = vndrSeq;
        this.xprDesc = xprDesc;
        this.termCode = termCode;
        this.dateType = dateType;
        this.cntrVslCassCapa = cntrVslCassCapa;
        this.costCd = costCd;
        this.costNm = costNm;
        this.vvd = vvd;
        this.vskdPortRhqCd = vskdPortRhqCd;
        this.vslSlanCd = vslSlanCd;
        this.vslClss = vslClss;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.io = io;
        this.rlaneCd = rlaneCd;
        this.revVvd = revVvd;
        this.actDt = actDt;
        this.payDueDt = payDueDt;
        this.payDt = payDt;
        this.chkData = chkData;
        this.clptIndSeq = clptIndSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("combo1", getCombo1());
        this.hashColumns.put("foml_desc", getFomlDesc());
        this.hashColumns.put("so_seq", getSoSeq());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("acct_eng_nm", getAcctEngNm());
        this.hashColumns.put("iss_cty_cd", getIssCtyCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vop_port_rhq_cd", getVopPortRhqCd());
        this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("status", getStatus());
        this.hashColumns.put("locl_amt", getLoclAmt());
        this.hashColumns.put("adj_amt", getAdjAmt());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("pso_chg_sts_nm", getPsoChgStsNm());
        this.hashColumns.put("to_date", getToDate());
        this.hashColumns.put("calc_amt", getCalcAmt());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("differ", getDiffer());
        this.hashColumns.put("usd_amt", getUsdAmt());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("from_date", getFromDate());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("xpr_desc", getXprDesc());
        this.hashColumns.put("term_code", getTermCode());
        this.hashColumns.put("date_type", getDateType());
        this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("cost_nm", getCostNm());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("vskd_port_rhq_cd", getVskdPortRhqCd());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("vsl_clss", getVslClss());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("io", getIo());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("rev_vvd", getRevVvd());
        this.hashColumns.put("act_dt", getActDt());
        this.hashColumns.put("pay_due_dt", getPayDueDt());
        this.hashColumns.put("pay_dt", getPayDt());
        this.hashColumns.put("chk_data", getChkData());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("combo1", "combo1");
        this.hashFields.put("foml_desc", "fomlDesc");
        this.hashFields.put("so_seq", "soSeq");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("acct_eng_nm", "acctEngNm");
        this.hashFields.put("iss_cty_cd", "issCtyCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vop_port_rhq_cd", "vopPortRhqCd");
        this.hashFields.put("sls_ofc_cd", "slsOfcCd");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("status", "status");
        this.hashFields.put("locl_amt", "loclAmt");
        this.hashFields.put("adj_amt", "adjAmt");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("pso_chg_sts_nm", "psoChgStsNm");
        this.hashFields.put("to_date", "toDate");
        this.hashFields.put("calc_amt", "calcAmt");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("differ", "differ");
        this.hashFields.put("usd_amt", "usdAmt");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("from_date", "fromDate");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("so_dtl_seq", "soDtlSeq");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("xpr_desc", "xprDesc");
        this.hashFields.put("term_code", "termCode");
        this.hashFields.put("date_type", "dateType");
        this.hashFields.put("cntr_vsl_clss_capa", "cntrVslCassCapa");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("cost_nm", "costNm");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("vskd_port_rhq_cd", "vskdPortRhqCd");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("vsl_clss", "vslClss");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("io", "io");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("rev_vvd", "revVvd");
        this.hashFields.put("act_dt", "actDt");
        this.hashFields.put("pay_due_dt", "payDueDt");
        this.hashFields.put("pay_dt", "payDt");
        this.hashFields.put("chk_data", "chkData");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
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
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return combo1
	 */
    public String getCombo1() {
        return this.combo1;
    }

    /**
	 * Column Info
	 * @return fomlDesc
	 */
    public String getFomlDesc() {
        return this.fomlDesc;
    }

    /**
	 * Column Info
	 * @return soSeq
	 */
    public String getSoSeq() {
        return this.soSeq;
    }

    /**
	 * Column Info
	 * @return vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    /**
	 * Column Info
	 * @return acctEngNm
	 */
    public String getAcctEngNm() {
        return this.acctEngNm;
    }

    /**
	 * Column Info
	 * @return issCtyCd
	 */
    public String getIssCtyCd() {
        return this.issCtyCd;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return vopPortRhqCd
	 */
    public String getVopPortRhqCd() {
        return this.vopPortRhqCd;
    }

    /**
	 * Column Info
	 * @return slsOfcCd
	 */
    public String getSlsOfcCd() {
        return this.slsOfcCd;
    }

    /**
	 * Column Info
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return portCd
	 */
    public String getPortCd() {
        return this.portCd;
    }

    /**
	 * Column Info
	 * @return csrNo
	 */
    public String getCsrNo() {
        return this.csrNo;
    }

    /**
	 * Column Info
	 * @return status
	 */
    public String getStatus() {
        return this.status;
    }

    /**
	 * Column Info
	 * @return loclAmt
	 */
    public String getLoclAmt() {
        return this.loclAmt;
    }

    /**
	 * Column Info
	 * @return adjAmt
	 */
    public String getAdjAmt() {
        return this.adjAmt;
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
	 * @return psoChgStsNm
	 */
    public String getPsoChgStsNm() {
        return this.psoChgStsNm;
    }

    /**
	 * Column Info
	 * @return toDate
	 */
    public String getToDate() {
        return this.toDate;
    }

    /**
	 * Column Info
	 * @return calcAmt
	 */
    public String getCalcAmt() {
        return this.calcAmt;
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
	 * @return invNo
	 */
    public String getInvNo() {
        return this.invNo;
    }

    /**
	 * Column Info
	 * @return differ
	 */
    public String getDiffer() {
        return this.differ;
    }

    /**
	 * Column Info
	 * @return usdAmt
	 */
    public String getUsdAmt() {
        return this.usdAmt;
    }

    /**
	 * Column Info
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return fromDate
	 */
    public String getFromDate() {
        return this.fromDate;
    }

    /**
	 * Column Info
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 * Column Info
	 * @return soDtlSeq
	 */
    public String getSoDtlSeq() {
        return this.soDtlSeq;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return xprDesc
	 */
    public String getXprDesc() {
        return this.xprDesc;
    }

    /**
	 * Column Info
	 * @return termCode
	 */
    public String getTermCode() {
        return this.termCode;
    }

    /**
	 * Column Info
	 * @return dateType
	 */
    public String getDateType() {
        return this.dateType;
    }

    /**
	 * Column Info
	 * @return cntrVslCassCapa
	 */
    public String getCntrVslClssCapa() {
        return this.cntrVslCassCapa;
    }

    /**
	 * Column Info
	 * @return costCd
	 */
    public String getCostCd() {
        return this.costCd;
    }

    /**
	 * Column Info
	 * @return costNm
	 */
    public String getCostNm() {
        return this.costNm;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return vskdPortRhqCd
	 */
    public String getVskdPortRhqCd() {
        return this.vskdPortRhqCd;
    }

    /**
	 * Column Info
	 * @return vslSlanCd;
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 * Column Info
	 * @return vslClss;
	 */
    public String getVslClss() {
        return this.vslClss;
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
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param combo1
	 */
    public void setCombo1(String combo1) {
        this.combo1 = combo1;
    }

    /**
	 * Column Info
	 * @param fomlDesc
	 */
    public void setFomlDesc(String fomlDesc) {
        this.fomlDesc = fomlDesc;
    }

    /**
	 * Column Info
	 * @param soSeq
	 */
    public void setSoSeq(String soSeq) {
        this.soSeq = soSeq;
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
	 * @param vslClss
	 */
    public void setVslClss(String vslClss) {
        this.vslClss = vslClss;
    }

    /**
	 * Column Info
	 * @param vndrLglEngNm
	 */
    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    /**
	 * Column Info
	 * @param acctEngNm
	 */
    public void setAcctEngNm(String acctEngNm) {
        this.acctEngNm = acctEngNm;
    }

    /**
	 * Column Info
	 * @param issCtyCd
	 */
    public void setIssCtyCd(String issCtyCd) {
        this.issCtyCd = issCtyCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param vopPortRhqCd
	 */
    public void setVopPortRhqCd(String vopPortRhqCd) {
        this.vopPortRhqCd = vopPortRhqCd;
    }

    /**
	 * Column Info
	 * @param slsOfcCd
	 */
    public void setSlsOfcCd(String slsOfcCd) {
        this.slsOfcCd = slsOfcCd;
    }

    /**
	 * Column Info
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    /**
	 * Column Info
	 * @param csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    /**
	 * Column Info
	 * @param status
	 */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
	 * Column Info
	 * @param loclAmt
	 */
    public void setLoclAmt(String loclAmt) {
        this.loclAmt = loclAmt;
    }

    /**
	 * Column Info
	 * @param adjAmt
	 */
    public void setAdjAmt(String adjAmt) {
        this.adjAmt = adjAmt;
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
	 * @param psoChgStsNm
	 */
    public void setPsoChgStsNm(String psoChgStsNm) {
        this.psoChgStsNm = psoChgStsNm;
    }

    /**
	 * Column Info
	 * @param toDate
	 */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
	 * Column Info
	 * @param calcAmt
	 */
    public void setCalcAmt(String calcAmt) {
        this.calcAmt = calcAmt;
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
	 * @param invNo
	 */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    /**
	 * Column Info
	 * @param differ
	 */
    public void setDiffer(String differ) {
        this.differ = differ;
    }

    /**
	 * Column Info
	 * @param usdAmt
	 */
    public void setUsdAmt(String usdAmt) {
        this.usdAmt = usdAmt;
    }

    /**
	 * Column Info
	 * @param diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param fromDate
	 */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
	 * Column Info
	 * @param ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * @param soDtlSeq
	 */
    public void setSoDtlSeq(String soDtlSeq) {
        this.soDtlSeq = soDtlSeq;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param xprDesc
	 */
    public void setXprDesc(String xprDesc) {
        this.xprDesc = xprDesc;
    }

    /**
	 * Column Info
	 * @param termCode
	 */
    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    /**
	 * Column Info
	 * @param soDtlSeq
	 */
    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    /**
	 * Column Info
	 * @param cntrVslCassCapa
	 */
    public void setCntrVslClssCapa(String cntrVslCassCapa) {
        this.cntrVslCassCapa = cntrVslCassCapa;
    }

    /**
	 * Column Info
	 * @param costCd
	 */
    public void setCostCd(String costCd) {
        this.costCd = costCd;
    }

    /**
	 * Column Info
	 * @param costNm
	 */
    public void setCostNm(String costNm) {
        this.costNm = costNm;
    }

    /**
	 * Column Info
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param vopPortRhqCd
	 */
    public void setVskdPortRhqCd(String vskdPortRhqCd) {
        this.vskdPortRhqCd = vskdPortRhqCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setIo(String io) {
        this.io = io;
    }

    public String getIo() {
        return this.io;
    }

    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    public String getRlaneCd() {
        return this.rlaneCd;
    }

    public void setRevVvd(String revVvd) {
        this.revVvd = revVvd;
    }

    public String getRevVvd() {
        return this.revVvd;
    }

    public void setActDt(String actDt) {
        this.actDt = actDt;
    }

    public String getActDt() {
        return this.actDt;
    }

    public void setPayDueDt(String payDueDt) {
        this.payDueDt = payDueDt;
    }

    public String getPayDueDt() {
        return this.payDueDt;
    }

    public void setPayDt(String payDt) {
        this.payDt = payDt;
    }

    public String getPayDt() {
        return this.payDt;
    }

    public void setChkData(String chkData) {
        this.chkData = chkData;
    }

    public String getChkData() {
        return this.chkData;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setCombo1(JSPUtil.getParameter(request, prefix + "combo1", ""));
        setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
        setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
        setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVopPortRhqCd(JSPUtil.getParameter(request, prefix + "vop_port_rhq_cd", ""));
        setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
        setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
        setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setPsoChgStsNm(JSPUtil.getParameter(request, prefix + "pso_chg_sts_nm", ""));
        setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
        setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setDiffer(JSPUtil.getParameter(request, prefix + "differ", ""));
        setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
        setTermCode(JSPUtil.getParameter(request, prefix + "term_code", ""));
        setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
        setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
        setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
        setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setVskdPortRhqCd(JSPUtil.getParameter(request, prefix + "vskd_port_rhq_cd", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setVslClss(JSPUtil.getParameter(request, prefix + "vsl_clss", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setIo(JSPUtil.getParameter(request, prefix + "io", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setRevVvd(JSPUtil.getParameter(request, prefix + "rev_vvd", ""));
        setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
        setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
        setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
        setChkData(JSPUtil.getParameter(request, prefix + "chk_data", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvSumByMonVO[]
	 */
    public InvSumByMonVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvSumByMonVO[]
	 */
    public InvSumByMonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InvSumByMonVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] combo1 = (JSPUtil.getParameter(request, prefix + "combo1", length));
            String[] fomlDesc = (JSPUtil.getParameter(request, prefix + "foml_desc", length));
            String[] soSeq = (JSPUtil.getParameter(request, prefix + "so_seq", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] acctEngNm = (JSPUtil.getParameter(request, prefix + "acct_eng_nm", length));
            String[] issCtyCd = (JSPUtil.getParameter(request, prefix + "iss_cty_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vopPortRhqCd = (JSPUtil.getParameter(request, prefix + "vop_port_rhq_cd", length));
            String[] slsOfcCd = (JSPUtil.getParameter(request, prefix + "sls_ofc_cd", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] status = (JSPUtil.getParameter(request, prefix + "status", length));
            String[] loclAmt = (JSPUtil.getParameter(request, prefix + "locl_amt", length));
            String[] adjAmt = (JSPUtil.getParameter(request, prefix + "adj_amt", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] psoChgStsNm = (JSPUtil.getParameter(request, prefix + "pso_chg_sts_nm", length));
            String[] toDate = (JSPUtil.getParameter(request, prefix + "to_date", length));
            String[] calcAmt = (JSPUtil.getParameter(request, prefix + "calc_amt", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] differ = (JSPUtil.getParameter(request, prefix + "differ", length));
            String[] usdAmt = (JSPUtil.getParameter(request, prefix + "usd_amt", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] fromDate = (JSPUtil.getParameter(request, prefix + "from_date", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] soDtlSeq = (JSPUtil.getParameter(request, prefix + "so_dtl_seq", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] xprDesc = (JSPUtil.getParameter(request, prefix + "xpr_desc", length));
            String[] termCode = (JSPUtil.getParameter(request, prefix + "term_code", length));
            String[] dateType = (JSPUtil.getParameter(request, prefix + "date_type", length));
            String[] cntrVslCassCapa = (JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] costNm = (JSPUtil.getParameter(request, prefix + "cost_nm", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] vskdPortRhqCd = (JSPUtil.getParameter(request, prefix + "vskd_port_rhq_cd", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] vslClss = (JSPUtil.getParameter(request, prefix + "vsl_clss", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] io = (JSPUtil.getParameter(request, prefix + "io", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] revVvd = (JSPUtil.getParameter(request, prefix + "rev_vvd", length));
            String[] actDt = (JSPUtil.getParameter(request, prefix + "act_dt", length));
            String[] payDueDt = (JSPUtil.getParameter(request, prefix + "pay_due_dt", length));
            String[] payDt = (JSPUtil.getParameter(request, prefix + "pay_dt", length));
            String[] chkData = (JSPUtil.getParameter(request, prefix + "chk_data", length));
	    	String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InvSumByMonVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (combo1[i] != null)
                    model.setCombo1(combo1[i]);
                if (fomlDesc[i] != null)
                    model.setFomlDesc(fomlDesc[i]);
                if (soSeq[i] != null)
                    model.setSoSeq(soSeq[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (acctEngNm[i] != null)
                    model.setAcctEngNm(acctEngNm[i]);
                if (issCtyCd[i] != null)
                    model.setIssCtyCd(issCtyCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vopPortRhqCd[i] != null)
                    model.setVopPortRhqCd(vopPortRhqCd[i]);
                if (slsOfcCd[i] != null)
                    model.setSlsOfcCd(slsOfcCd[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (status[i] != null)
                    model.setStatus(status[i]);
                if (loclAmt[i] != null)
                    model.setLoclAmt(loclAmt[i]);
                if (adjAmt[i] != null)
                    model.setAdjAmt(adjAmt[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (psoChgStsNm[i] != null)
                    model.setPsoChgStsNm(psoChgStsNm[i]);
                if (toDate[i] != null)
                    model.setToDate(toDate[i]);
                if (calcAmt[i] != null)
                    model.setCalcAmt(calcAmt[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (differ[i] != null)
                    model.setDiffer(differ[i]);
                if (usdAmt[i] != null)
                    model.setUsdAmt(usdAmt[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (fromDate[i] != null)
                    model.setFromDate(fromDate[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (soDtlSeq[i] != null)
                    model.setSoDtlSeq(soDtlSeq[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (xprDesc[i] != null)
                    model.setXprDesc(xprDesc[i]);
                if (termCode[i] != null)
                    model.setTermCode(termCode[i]);
                if (dateType[i] != null)
                    model.setDateType(dateType[i]);
                if (cntrVslCassCapa[i] != null)
                    model.setCntrVslClssCapa(cntrVslCassCapa[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (costNm[i] != null)
                    model.setCostNm(costNm[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (vskdPortRhqCd[i] != null)
                    model.setVskdPortRhqCd(vskdPortRhqCd[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (vslClss[i] != null)
                    model.setVslClss(vslClss[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (io[i] != null)
                    model.setIo(io[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (revVvd[i] != null)
                    model.setRevVvd(revVvd[i]);
                if (actDt[i] != null)
                    model.setActDt(actDt[i]);
                if (payDueDt[i] != null)
                    model.setPayDueDt(payDueDt[i]);
                if (payDt[i] != null)
                    model.setPayDt(payDt[i]);
                if (chkData[i] != null) 
		    		model.setChkData(chkData[i]);
				if (clptIndSeq[i] != null) 
		    		model.setClptIndSeq(clptIndSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInvSumByMonVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InvSumByMonVO[]
	 */
    public InvSumByMonVO[] getInvSumByMonVOs() {
        InvSumByMonVO[] vos = (InvSumByMonVO[]) models.toArray(new InvSumByMonVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.combo1 = this.combo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fomlDesc = this.fomlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soSeq = this.soSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctEngNm = this.acctEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issCtyCd = this.issCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vopPortRhqCd = this.vopPortRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcCd = this.slsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.status = this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclAmt = this.loclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.adjAmt = this.adjAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoChgStsNm = this.psoChgStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDate = this.toDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcAmt = this.calcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.differ = this.differ.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdAmt = this.usdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromDate = this.fromDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soDtlSeq = this.soDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xprDesc = this.xprDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.termCode = this.termCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dateType = this.dateType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVslCassCapa = this.cntrVslCassCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costNm = this.costNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vskdPortRhqCd = this.vskdPortRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClss = this.vslClss.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.io = this.io.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revVvd = this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDt = this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDueDt = this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDt = this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkData = this.chkData.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
