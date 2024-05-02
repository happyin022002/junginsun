/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : PreAuditListVO.java
*@FileTitle : PreAuditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PreAuditListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PreAuditListVO> models = new ArrayList<PreAuditListVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String diff = null;

    /* Column Info */
    private String apPayDt = null;

    /* Column Info */
    private String tariffCost = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String amount = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String payDueDt = null;

    /* Column Info */
    private String adjcost = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String rhq = null;

    /* Column Info */
    private String countryOfNp = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String selectFlgTemp = null;

    /* Column Info */
    private String berthingHour = null;

    /* Column Info */
    private String issued = null;

    /* Column Info */
    private String lastPort = null;

    /* Column Info */
    private String autoAuditFlg = null;

    /* Column Info */
    private String selectFlg = null;

    /* Column Info */
    private String payTermDys = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String scgCarTier = null;

    /* Column Info */
    private String nightFlg = null;

    /* Column Info */
    private String soDtlSeq = null;

    /* Column Info */
    private String spNm = null;

    /* Column Info */
    private String spNo = null;

    /* Column Info */
    private String sdrRt = null;

    /* Column Info */
    private String port = null;

    /* Column Info */
    private String acctNm = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String yard = null;

    /* Column Info */
    private String costNm = null;

    /* Column Info */
    private String soSeq = null;

    /* Column Info */
    private String depNoOfTug = null;

    /* Column Info */
    private String issCtyCd = null;

    /* Column Info */
    private String nrt = null;

    /* Column Info */
    private String foml1 = null;

    /* Column Info */
    private String foml2 = null;

    /* Column Info */
    private String issDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String arrNoOfTug = null;

    /* Column Info */
    private String grt = null;

    /* Column Info */
    private String rmk = null;

    /* Column Info */
    private String office = null;

    /* Column Info */
    private String suzGtWgt = null;

    /* Column Info */
    private String vpsAtbDt = null;

    /* Column Info */
    private String madnVoySuzNetTongWgt = null;

    /* Column Info */
    private String vslNm = null;

    /* Column Info */
    private String auditResult = null;

    /* Column Info */
    private String cntrVslClssCapa = null;

    /* Column Info */
    private String eacNo = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String sel = null;

    /* Column Info */
    private String bound = null;

    /* Column Info */
    private String auditUsrId = null;

    /* Column Info */
    private String auditDt = null;

    /* Column Info */
    private String portChgAudRsltRmk = null;

    /* Column Info */
    private String portChgAudRsltUsrId = null;

    /* Column Info */
    private String portChgAudRsltUsrNm = null;

    /* Column Info */
    private String sSaveTpCd = null;

    /* Column Info */
    private String atchFileLnkId = null;

    /* Column Info */
    private String expnAudRsltCd = null;

    /* Column Info */
    private String invAudCurrCd = null;

    /* Column Info */
    private String invAudDiffAmt = null;

    /* Column Info */
    private String invAudUsdDiffAmt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PreAuditListVO() {
    }

    public PreAuditListVO(String ibflag, String pagerows, String selectFlg, String autoAuditFlg, String rhq, String office, String port, String yard, String vvd, String bound, String acctCd, String acctNm, String costCd, String costNm, String spNo, String invNo, String issDt, String currCd, String tariffCost, String adjcost, String amount, String diff, String foml1, String foml2, String rmk, String berthingHour, String lastPort, String countryOfNp, String grt, String nrt, String issCtyCd, String soSeq, String soDtlSeq, String sel, String csrNo, String vpsAtbDt, String arrNoOfTug, String depNoOfTug, String updUsrId, String payTermDys, String apPayDt, String suzGtWgt, String madnVoySuzNetTongWgt, String sdrRt, String scgCarTier, String nightFlg, String cntrVslClssCapa, String vslCd, String vslNm, String spNm, String issued, String selectFlgTemp, String eacNo, String payDueDt, String auditResult, String auditUsrId, String auditDt, String portChgAudRsltRmk, String portChgAudRsltUsrId, String portChgAudRsltUsrNm, String sSaveTpCd, String atchFileLnkId, String expnAudRsltCd, String invAudCurrCd, String invAudDiffAmt, String invAudUsdDiffAmt) {
        this.vslCd = vslCd;
        this.diff = diff;
        this.apPayDt = apPayDt;
        this.tariffCost = tariffCost;
        this.pagerows = pagerows;
        this.amount = amount;
        this.costCd = costCd;
        this.payDueDt = payDueDt;
        this.adjcost = adjcost;
        this.updUsrId = updUsrId;
        this.rhq = rhq;
        this.countryOfNp = countryOfNp;
        this.csrNo = csrNo;
        this.selectFlgTemp = selectFlgTemp;
        this.berthingHour = berthingHour;
        this.issued = issued;
        this.lastPort = lastPort;
        this.autoAuditFlg = autoAuditFlg;
        this.selectFlg = selectFlg;
        this.payTermDys = payTermDys;
        this.vvd = vvd;
        this.scgCarTier = scgCarTier;
        this.nightFlg = nightFlg;
        this.soDtlSeq = soDtlSeq;
        this.spNm = spNm;
        this.spNo = spNo;
        this.sdrRt = sdrRt;
        this.port = port;
        this.acctNm = acctNm;
        this.currCd = currCd;
        this.yard = yard;
        this.costNm = costNm;
        this.soSeq = soSeq;
        this.depNoOfTug = depNoOfTug;
        this.issCtyCd = issCtyCd;
        this.nrt = nrt;
        this.foml1 = foml1;
        this.foml2 = foml2;
        this.issDt = issDt;
        this.ibflag = ibflag;
        this.acctCd = acctCd;
        this.arrNoOfTug = arrNoOfTug;
        this.grt = grt;
        this.rmk = rmk;
        this.office = office;
        this.suzGtWgt = suzGtWgt;
        this.vpsAtbDt = vpsAtbDt;
        this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
        this.vslNm = vslNm;
        this.auditResult = auditResult;
        this.cntrVslClssCapa = cntrVslClssCapa;
        this.eacNo = eacNo;
        this.invNo = invNo;
        this.sel = sel;
        this.bound = bound;
        this.auditUsrId = auditUsrId;
        this.auditDt = auditDt;
        this.portChgAudRsltRmk = portChgAudRsltRmk;
        this.portChgAudRsltUsrId = portChgAudRsltUsrId;
        this.portChgAudRsltUsrNm = portChgAudRsltUsrNm;
        this.sSaveTpCd = sSaveTpCd;
        this.atchFileLnkId = atchFileLnkId;
        this.expnAudRsltCd = expnAudRsltCd;
        this.invAudCurrCd = invAudCurrCd;
        this.invAudDiffAmt = invAudDiffAmt;
        this.invAudUsdDiffAmt = invAudUsdDiffAmt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("diff", getDiff());
        this.hashColumns.put("ap_pay_dt", getApPayDt());
        this.hashColumns.put("tariff_cost", getTariffCost());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("amount", getAmount());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("pay_due_dt", getPayDueDt());
        this.hashColumns.put("adjcost", getAdjcost());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("rhq", getRhq());
        this.hashColumns.put("country_of_np", getCountryOfNp());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("select_flg_temp", getSelectFlgTemp());
        this.hashColumns.put("berthing_hour", getBerthingHour());
        this.hashColumns.put("issued", getIssued());
        this.hashColumns.put("last_port", getLastPort());
        this.hashColumns.put("auto_audit_flg", getAutoAuditFlg());
        this.hashColumns.put("select_flg", getSelectFlg());
        this.hashColumns.put("pay_term_dys", getPayTermDys());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("scg_car_tier", getScgCarTier());
        this.hashColumns.put("night_flg", getNightFlg());
        this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
        this.hashColumns.put("sp_nm", getSpNm());
        this.hashColumns.put("sp_no", getSpNo());
        this.hashColumns.put("sdr_rt", getSdrRt());
        this.hashColumns.put("port", getPort());
        this.hashColumns.put("acct_nm", getAcctNm());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("yard", getYard());
        this.hashColumns.put("cost_nm", getCostNm());
        this.hashColumns.put("so_seq", getSoSeq());
        this.hashColumns.put("dep_no_of_tug", getDepNoOfTug());
        this.hashColumns.put("iss_cty_cd", getIssCtyCd());
        this.hashColumns.put("nrt", getNrt());
        this.hashColumns.put("foml1", getFoml1());
        this.hashColumns.put("foml2", getFoml2());
        this.hashColumns.put("iss_dt", getIssDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("arr_no_of_tug", getArrNoOfTug());
        this.hashColumns.put("grt", getGrt());
        this.hashColumns.put("rmk", getRmk());
        this.hashColumns.put("office", getOffice());
        this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
        this.hashColumns.put("vps_atb_dt", getVpsAtbDt());
        this.hashColumns.put("madn_voy_suz_net_tong_wgt", getMadnVoySuzNetTongWgt());
        this.hashColumns.put("vsl_nm", getVslNm());
        this.hashColumns.put("audit_result", getAuditResult());
        this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
        this.hashColumns.put("eac_no", getEacNo());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("sel", getSel());
        this.hashColumns.put("bound", getBound());
        this.hashColumns.put("audit_usr_id", getAuditUsrId());
        this.hashColumns.put("audit_dt", getAuditDt());
        this.hashColumns.put("port_chg_aud_rslt_rmk", getPortChgAudRsltRmk());
        this.hashColumns.put("port_chg_aud_rslt_usr_id", getPortChgAudRsltUsrId());
        this.hashColumns.put("port_chg_aud_rslt_usr_nm", getPortChgAudRsltUsrNm());
        this.hashColumns.put("s_save_tp_cd", getsSaveTpCd());
        this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
        this.hashColumns.put("expn_aud_rslt_cd", getExpnAudRsltCd());
        this.hashColumns.put("inv_aud_curr_cd", getInvAudCurrCd());
        this.hashColumns.put("inv_aud_diff_amt", getInvAudDiffAmt());
        this.hashColumns.put("inv_aud_usd_diff_amt", getInvAudUsdDiffAmt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("diff", "diff");
        this.hashFields.put("ap_pay_dt", "apPayDt");
        this.hashFields.put("tariff_cost", "tariffCost");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("amount", "amount");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("pay_due_dt", "payDueDt");
        this.hashFields.put("adjcost", "adjcost");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("rhq", "rhq");
        this.hashFields.put("country_of_np", "countryOfNp");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("select_flg_temp", "selectFlgTemp");
        this.hashFields.put("berthing_hour", "berthingHour");
        this.hashFields.put("issued", "issued");
        this.hashFields.put("last_port", "lastPort");
        this.hashFields.put("auto_audit_flg", "autoAuditFlg");
        this.hashFields.put("select_flg", "selectFlg");
        this.hashFields.put("pay_term_dys", "payTermDys");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("scg_car_tier", "scgCarTier");
        this.hashFields.put("night_flg", "nightFlg");
        this.hashFields.put("so_dtl_seq", "soDtlSeq");
        this.hashFields.put("sp_nm", "spNm");
        this.hashFields.put("sp_no", "spNo");
        this.hashFields.put("sdr_rt", "sdrRt");
        this.hashFields.put("port", "port");
        this.hashFields.put("acct_nm", "acctNm");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("yard", "yard");
        this.hashFields.put("cost_nm", "costNm");
        this.hashFields.put("so_seq", "soSeq");
        this.hashFields.put("dep_no_of_tug", "depNoOfTug");
        this.hashFields.put("iss_cty_cd", "issCtyCd");
        this.hashFields.put("nrt", "nrt");
        this.hashFields.put("foml1", "foml1");
        this.hashFields.put("foml2", "foml2");
        this.hashFields.put("iss_dt", "issDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("arr_no_of_tug", "arrNoOfTug");
        this.hashFields.put("grt", "grt");
        this.hashFields.put("rmk", "rmk");
        this.hashFields.put("office", "office");
        this.hashFields.put("suz_gt_wgt", "suzGtWgt");
        this.hashFields.put("vps_atb_dt", "vpsAtbDt");
        this.hashFields.put("madn_voy_suz_net_tong_wgt", "madnVoySuzNetTongWgt");
        this.hashFields.put("vsl_nm", "vslNm");
        this.hashFields.put("audit_result", "auditResult");
        this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
        this.hashFields.put("eac_no", "eacNo");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("sel", "sel");
        this.hashFields.put("bound", "bound");
        this.hashFields.put("audit_usr_id", "auditUsrId");
        this.hashFields.put("audit_dt", "auditDt");
        this.hashFields.put("port_chg_aud_rslt_rmk", "portChgAudRsltRmk");
        this.hashFields.put("port_chg_aud_rslt_usr_id", "portChgAudRsltUsrId");
        this.hashFields.put("port_chg_aud_rslt_usr_nm", "portChgAudRsltUsrNm");
        this.hashFields.put("s_save_tp_cd", "sSaveTpCd");
        this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
        this.hashFields.put("expn_aud_rslt_cd", "expnAudRsltCd");
        this.hashFields.put("inv_aud_curr_cd", "invAudCurrCd");
        this.hashFields.put("inv_aud_diff_amt", "invAudDiffAmt");
        this.hashFields.put("inv_aud_usd_diff_amt", "invAudUsdDiffAmt");
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
	 * @return diff
	 */
    public String getDiff() {
        return this.diff;
    }

    /**
	 * Column Info
	 * @return apPayDt
	 */
    public String getApPayDt() {
        return this.apPayDt;
    }

    /**
	 * Column Info
	 * @return tariffCost
	 */
    public String getTariffCost() {
        return this.tariffCost;
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
	 * @return amount
	 */
    public String getAmount() {
        return this.amount;
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
	 * @return payDueDt
	 */
    public String getPayDueDt() {
        return this.payDueDt;
    }

    /**
	 * Column Info
	 * @return adjcost
	 */
    public String getAdjcost() {
        return this.adjcost;
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
	 * @return rhq
	 */
    public String getRhq() {
        return this.rhq;
    }

    /**
	 * Column Info
	 * @return countryOfNp
	 */
    public String getCountryOfNp() {
        return this.countryOfNp;
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
	 * @return selectFlgTemp
	 */
    public String getSelectFlgTemp() {
        return this.selectFlgTemp;
    }

    /**
	 * Column Info
	 * @return berthingHour
	 */
    public String getBerthingHour() {
        return this.berthingHour;
    }

    /**
	 * Column Info
	 * @return issued
	 */
    public String getIssued() {
        return this.issued;
    }

    /**
	 * Column Info
	 * @return lastPort
	 */
    public String getLastPort() {
        return this.lastPort;
    }

    /**
	 * Column Info
	 * @return autoAuditFlg
	 */
    public String getAutoAuditFlg() {
        return this.autoAuditFlg;
    }

    /**
	 * Column Info
	 * @return selectFlg
	 */
    public String getSelectFlg() {
        return this.selectFlg;
    }

    /**
	 * Column Info
	 * @return payTermDys
	 */
    public String getPayTermDys() {
        return this.payTermDys;
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
	 * @return scgCarTier
	 */
    public String getScgCarTier() {
        return this.scgCarTier;
    }

    /**
	 * Column Info
	 * @return nightFlg
	 */
    public String getNightFlg() {
        return this.nightFlg;
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
	 * @return spNm
	 */
    public String getSpNm() {
        return this.spNm;
    }

    /**
	 * Column Info
	 * @return spNo
	 */
    public String getSpNo() {
        return this.spNo;
    }

    /**
	 * Column Info
	 * @return sdrRt
	 */
    public String getSdrRt() {
        return this.sdrRt;
    }

    /**
	 * Column Info
	 * @return port
	 */
    public String getPort() {
        return this.port;
    }

    /**
	 * Column Info
	 * @return acctNm
	 */
    public String getAcctNm() {
        return this.acctNm;
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
	 * @return yard
	 */
    public String getYard() {
        return this.yard;
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
	 * @return soSeq
	 */
    public String getSoSeq() {
        return this.soSeq;
    }

    /**
	 * Column Info
	 * @return depNoOfTug
	 */
    public String getDepNoOfTug() {
        return this.depNoOfTug;
    }

    /**
	 * Column Info
	 * @return issCtyCd
	 */
    public String getIssCtyCd() {
        return this.issCtyCd;
    }

    /**
	 * Column Info
	 * @return nrt
	 */
    public String getNrt() {
        return this.nrt;
    }

    /**
	 * Column Info
	 * @return foml1
	 */
    public String getFoml1() {
        return this.foml1;
    }

    /**
	 * Column Info
	 * @return issDt
	 */
    public String getIssDt() {
        return this.issDt;
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
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return arrNoOfTug
	 */
    public String getArrNoOfTug() {
        return this.arrNoOfTug;
    }

    /**
	 * Column Info
	 * @return grt
	 */
    public String getGrt() {
        return this.grt;
    }

    /**
	 * Column Info
	 * @return rmk
	 */
    public String getRmk() {
        return this.rmk;
    }

    /**
	 * Column Info
	 * @return office
	 */
    public String getOffice() {
        return this.office;
    }

    /**
	 * Column Info
	 * @return suzGtWgt
	 */
    public String getSuzGtWgt() {
        return this.suzGtWgt;
    }

    /**
	 * Column Info
	 * @return vpsAtbDt
	 */
    public String getVpsAtbDt() {
        return this.vpsAtbDt;
    }

    /**
	 * Column Info
	 * @return madnVoySuzNetTongWgt
	 */
    public String getMadnVoySuzNetTongWgt() {
        return this.madnVoySuzNetTongWgt;
    }

    /**
	 * Column Info
	 * @return vslNm
	 */
    public String getVslNm() {
        return this.vslNm;
    }

    /**
	 * Column Info
	 * @return auditResult
	 */
    public String getAuditResult() {
        return this.auditResult;
    }

    /**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
    public String getCntrVslClssCapa() {
        return this.cntrVslClssCapa;
    }

    /**
	 * Column Info
	 * @return eacNo
	 */
    public String getEacNo() {
        return this.eacNo;
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
	 * @return sel
	 */
    public String getSel() {
        return this.sel;
    }

    /**
	 * Column Info
	 * @return bound
	 */
    public String getBound() {
        return this.bound;
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
	 * @param diff
	 */
    public void setDiff(String diff) {
        this.diff = diff;
    }

    /**
	 * Column Info
	 * @param apPayDt
	 */
    public void setApPayDt(String apPayDt) {
        this.apPayDt = apPayDt;
    }

    /**
	 * Column Info
	 * @param tariffCost
	 */
    public void setTariffCost(String tariffCost) {
        this.tariffCost = tariffCost;
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
	 * @param amount
	 */
    public void setAmount(String amount) {
        this.amount = amount;
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
	 * @param payDueDt
	 */
    public void setPayDueDt(String payDueDt) {
        this.payDueDt = payDueDt;
    }

    /**
	 * Column Info
	 * @param adjcost
	 */
    public void setAdjcost(String adjcost) {
        this.adjcost = adjcost;
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
	 * @param rhq
	 */
    public void setRhq(String rhq) {
        this.rhq = rhq;
    }

    /**
	 * Column Info
	 * @param countryOfNp
	 */
    public void setCountryOfNp(String countryOfNp) {
        this.countryOfNp = countryOfNp;
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
	 * @param selectFlgTemp
	 */
    public void setSelectFlgTemp(String selectFlgTemp) {
        this.selectFlgTemp = selectFlgTemp;
    }

    /**
	 * Column Info
	 * @param berthingHour
	 */
    public void setBerthingHour(String berthingHour) {
        this.berthingHour = berthingHour;
    }

    /**
	 * Column Info
	 * @param issued
	 */
    public void setIssued(String issued) {
        this.issued = issued;
    }

    /**
	 * Column Info
	 * @param lastPort
	 */
    public void setLastPort(String lastPort) {
        this.lastPort = lastPort;
    }

    /**
	 * Column Info
	 * @param autoAuditFlg
	 */
    public void setAutoAuditFlg(String autoAuditFlg) {
        this.autoAuditFlg = autoAuditFlg;
    }

    /**
	 * Column Info
	 * @param selectFlg
	 */
    public void setSelectFlg(String selectFlg) {
        this.selectFlg = selectFlg;
    }

    /**
	 * Column Info
	 * @param payTermDys
	 */
    public void setPayTermDys(String payTermDys) {
        this.payTermDys = payTermDys;
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
	 * @param scgCarTier
	 */
    public void setScgCarTier(String scgCarTier) {
        this.scgCarTier = scgCarTier;
    }

    /**
	 * Column Info
	 * @param nightFlg
	 */
    public void setNightFlg(String nightFlg) {
        this.nightFlg = nightFlg;
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
	 * @param spNm
	 */
    public void setSpNm(String spNm) {
        this.spNm = spNm;
    }

    /**
	 * Column Info
	 * @param spNo
	 */
    public void setSpNo(String spNo) {
        this.spNo = spNo;
    }

    /**
	 * Column Info
	 * @param sdrRt
	 */
    public void setSdrRt(String sdrRt) {
        this.sdrRt = sdrRt;
    }

    /**
	 * Column Info
	 * @param port
	 */
    public void setPort(String port) {
        this.port = port;
    }

    /**
	 * Column Info
	 * @param acctNm
	 */
    public void setAcctNm(String acctNm) {
        this.acctNm = acctNm;
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
	 * @param yard
	 */
    public void setYard(String yard) {
        this.yard = yard;
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
	 * @param soSeq
	 */
    public void setSoSeq(String soSeq) {
        this.soSeq = soSeq;
    }

    /**
	 * Column Info
	 * @param depNoOfTug
	 */
    public void setDepNoOfTug(String depNoOfTug) {
        this.depNoOfTug = depNoOfTug;
    }

    /**
	 * Column Info
	 * @param issCtyCd
	 */
    public void setIssCtyCd(String issCtyCd) {
        this.issCtyCd = issCtyCd;
    }

    /**
	 * Column Info
	 * @param nrt
	 */
    public void setNrt(String nrt) {
        this.nrt = nrt;
    }

    /**
	 * Column Info
	 * @param foml1
	 */
    public void setFoml1(String foml1) {
        this.foml1 = foml1;
    }

    /**
	 * Column Info
	 * @param issDt
	 */
    public void setIssDt(String issDt) {
        this.issDt = issDt;
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
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param arrNoOfTug
	 */
    public void setArrNoOfTug(String arrNoOfTug) {
        this.arrNoOfTug = arrNoOfTug;
    }

    /**
	 * Column Info
	 * @param grt
	 */
    public void setGrt(String grt) {
        this.grt = grt;
    }

    /**
	 * Column Info
	 * @param rmk
	 */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
	 * Column Info
	 * @param office
	 */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
	 * Column Info
	 * @param suzGtWgt
	 */
    public void setSuzGtWgt(String suzGtWgt) {
        this.suzGtWgt = suzGtWgt;
    }

    /**
	 * Column Info
	 * @param vpsAtbDt
	 */
    public void setVpsAtbDt(String vpsAtbDt) {
        this.vpsAtbDt = vpsAtbDt;
    }

    /**
	 * Column Info
	 * @param madnVoySuzNetTongWgt
	 */
    public void setMadnVoySuzNetTongWgt(String madnVoySuzNetTongWgt) {
        this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
    }

    /**
	 * Column Info
	 * @param vslNm
	 */
    public void setVslNm(String vslNm) {
        this.vslNm = vslNm;
    }

    /**
	 * Column Info
	 * @param auditResult
	 */
    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    /**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
    public void setCntrVslClssCapa(String cntrVslClssCapa) {
        this.cntrVslClssCapa = cntrVslClssCapa;
    }

    /**
	 * Column Info
	 * @param eacNo
	 */
    public void setEacNo(String eacNo) {
        this.eacNo = eacNo;
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
	 * @param sel
	 */
    public void setSel(String sel) {
        this.sel = sel;
    }

    /**
	 * Column Info
	 * @return foml2
	 */
    public String getFoml2() {
        return foml2;
    }

    /**
	 * Column Info
	 * @param foml2
	 */
    public void setFoml2(String foml2) {
        this.foml2 = foml2;
    }

    /**
	 * Column Info
	 * @param bound
	 */
    public void setBound(String bound) {
        this.bound = bound;
    }

    /**
	 * Column Info
	 * @param auditUsrId
	 */
    public String getAuditUsrId() {
        return auditUsrId;
    }

    /**
	 * Column Info
	 * @param auditUsrId
	 */
    public void setAuditUsrId(String auditUsrId) {
        this.auditUsrId = auditUsrId;
    }

    /**
	 * Column Info
	 * @param auditDt
	 */
    public String getAuditDt() {
        return auditDt;
    }

    /**
	 * Column Info
	 * @param auditDt
	 */
    public void setAuditDt(String auditDt) {
        this.auditDt = auditDt;
    }

    /**
	 * Column Info
	 * @param portChgAudRsltRmk
	 */
    public String getPortChgAudRsltRmk() {
        return portChgAudRsltRmk;
    }

    /**
	 * Column Info
	 * @param portChgAudRsltRmk
	 */
    public void setPortChgAudRsltRmk(String portChgAudRsltRmk) {
        this.portChgAudRsltRmk = portChgAudRsltRmk;
    }

    /**
	 * Column Info
	 * @param portChgAudRsltUsrId
	 */
    public String getPortChgAudRsltUsrId() {
        return portChgAudRsltUsrId;
    }

    /**
	 * Column Info
	 * @param portChgAudRsltUsrNm
	 */
    public String getPortChgAudRsltUsrNm() {
        return portChgAudRsltUsrNm;
    }

    /**
	 * Column Info
	 * @param sSaveTpCd
	 */
    public String getsSaveTpCd() {
        return sSaveTpCd;
    }

    /**
	 * Column Info
	 * @param sSaveTpCd
	 */
    public void setsSaveTpCd(String sSaveTpCd) {
        this.sSaveTpCd = sSaveTpCd;
    }

    /**
	 * Column Info
	 * @param portChgAudRsltUsrNm
	 */
    public void setPortChgAudRsltUsrNm(String portChgAudRsltUsrNm) {
        this.portChgAudRsltUsrNm = portChgAudRsltUsrNm;
    }

    /**
	 * Column Info
	 * @param portChgAudRsltUsrId
	 */
    public void setPortChgAudRsltUsrId(String portChgAudRsltUsrId) {
        this.portChgAudRsltUsrId = portChgAudRsltUsrId;
    }

    /**
	 * Column Info
	 * @param atchFileLnkId
	 */
    public String getAtchFileLnkId() {
        return atchFileLnkId;
    }

    /**
	 * Column Info
	 * @param atchFileLnkId
	 */
    public void setAtchFileLnkId(String atchFileLnkId) {
        this.atchFileLnkId = atchFileLnkId;
    }

    /**
	 * Column Info
	 * @param expnAudRsltCd
	 */
    public String getExpnAudRsltCd() {
        return expnAudRsltCd;
    }

    /**
	 * Column Info
	 * @param expnAudRsltCd
	 */
    public void setExpnAudRsltCd(String expnAudRsltCd) {
        this.expnAudRsltCd = expnAudRsltCd;
    }

    public void setInvAudCurrCd(String invAudCurrCd) {
        this.invAudCurrCd = invAudCurrCd;
    }

    public String getInvAudCurrCd() {
        return this.invAudCurrCd;
    }

    public void setInvAudDiffAmt(String invAudDiffAmt) {
        this.invAudDiffAmt = invAudDiffAmt;
    }

    public String getInvAudDiffAmt() {
        return this.invAudDiffAmt;
    }

    public void setInvAudUsdDiffAmt(String invAudUsdDiffAmt) {
        this.invAudUsdDiffAmt = invAudUsdDiffAmt;
    }

    public String getInvAudUsdDiffAmt() {
        return this.invAudUsdDiffAmt;
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
        setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
        setApPayDt(JSPUtil.getParameter(request, prefix + "ap_pay_dt", ""));
        setTariffCost(JSPUtil.getParameter(request, prefix + "tariff_cost", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
        setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
        setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
        setAdjcost(JSPUtil.getParameter(request, prefix + "adjcost", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
        setCountryOfNp(JSPUtil.getParameter(request, prefix + "country_of_np", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setSelectFlgTemp(JSPUtil.getParameter(request, prefix + "select_flg_temp", ""));
        setBerthingHour(JSPUtil.getParameter(request, prefix + "berthing_hour", ""));
        setIssued(JSPUtil.getParameter(request, prefix + "issued", ""));
        setLastPort(JSPUtil.getParameter(request, prefix + "last_port", ""));
        setAutoAuditFlg(JSPUtil.getParameter(request, prefix + "auto_audit_flg", ""));
        setSelectFlg(JSPUtil.getParameter(request, prefix + "select_flg", ""));
        setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setScgCarTier(JSPUtil.getParameter(request, prefix + "scg_car_tier", ""));
        setNightFlg(JSPUtil.getParameter(request, prefix + "night_flg", ""));
        setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
        setSpNm(JSPUtil.getParameter(request, prefix + "sp_nm", ""));
        setSpNo(JSPUtil.getParameter(request, prefix + "sp_no", ""));
        setSdrRt(JSPUtil.getParameter(request, prefix + "sdr_rt", ""));
        setPort(JSPUtil.getParameter(request, prefix + "port", ""));
        setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
        setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
        setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
        setDepNoOfTug(JSPUtil.getParameter(request, prefix + "dep_no_of_tug", ""));
        setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
        setNrt(JSPUtil.getParameter(request, prefix + "nrt", ""));
        setFoml1(JSPUtil.getParameter(request, prefix + "foml1", ""));
        setFoml2(JSPUtil.getParameter(request, prefix + "foml2", ""));
        setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setArrNoOfTug(JSPUtil.getParameter(request, prefix + "arr_no_of_tug", ""));
        setGrt(JSPUtil.getParameter(request, prefix + "grt", ""));
        setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
        setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
        setSuzGtWgt(JSPUtil.getParameter(request, prefix + "suz_gt_wgt", ""));
        setVpsAtbDt(JSPUtil.getParameter(request, prefix + "vps_atb_dt", ""));
        setMadnVoySuzNetTongWgt(JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", ""));
        setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
        setAuditResult(JSPUtil.getParameter(request, prefix + "audit_result", ""));
        setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
        setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
        setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
        setAuditUsrId(JSPUtil.getParameter(request, prefix + "audit_usr_id", ""));
        setAuditDt(JSPUtil.getParameter(request, prefix + "audit_dt", ""));
        setPortChgAudRsltRmk(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_rmk", ""));
        setPortChgAudRsltUsrId(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_usr_id", ""));
        setPortChgAudRsltUsrNm(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_usr_nm", ""));
        setsSaveTpCd(JSPUtil.getParameter(request, prefix + "s_save_tp_cd", ""));
        setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
        setExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", ""));
        setInvAudCurrCd(JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", ""));
        setInvAudDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", ""));
        setInvAudUsdDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreAuditListVO[]
	 */
    public PreAuditListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreAuditListVO[]
	 */
    public PreAuditListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PreAuditListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] diff = (JSPUtil.getParameter(request, prefix + "diff", length));
            String[] apPayDt = (JSPUtil.getParameter(request, prefix + "ap_pay_dt", length));
            String[] tariffCost = (JSPUtil.getParameter(request, prefix + "tariff_cost", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] amount = (JSPUtil.getParameter(request, prefix + "amount", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] payDueDt = (JSPUtil.getParameter(request, prefix + "pay_due_dt", length));
            String[] adjcost = (JSPUtil.getParameter(request, prefix + "adjcost", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] rhq = (JSPUtil.getParameter(request, prefix + "rhq", length));
            String[] countryOfNp = (JSPUtil.getParameter(request, prefix + "country_of_np", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] selectFlgTemp = (JSPUtil.getParameter(request, prefix + "select_flg_temp", length));
            String[] berthingHour = (JSPUtil.getParameter(request, prefix + "berthing_hour", length));
            String[] issued = (JSPUtil.getParameter(request, prefix + "issued", length));
            String[] lastPort = (JSPUtil.getParameter(request, prefix + "last_port", length));
            String[] autoAuditFlg = (JSPUtil.getParameter(request, prefix + "auto_audit_flg", length));
            String[] selectFlg = (JSPUtil.getParameter(request, prefix + "select_flg", length));
            String[] payTermDys = (JSPUtil.getParameter(request, prefix + "pay_term_dys", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] scgCarTier = (JSPUtil.getParameter(request, prefix + "scg_car_tier", length));
            String[] nightFlg = (JSPUtil.getParameter(request, prefix + "night_flg", length));
            String[] soDtlSeq = (JSPUtil.getParameter(request, prefix + "so_dtl_seq", length));
            String[] spNm = (JSPUtil.getParameter(request, prefix + "sp_nm", length));
            String[] spNo = (JSPUtil.getParameter(request, prefix + "sp_no", length));
            String[] sdrRt = (JSPUtil.getParameter(request, prefix + "sdr_rt", length));
            String[] port = (JSPUtil.getParameter(request, prefix + "port", length));
            String[] acctNm = (JSPUtil.getParameter(request, prefix + "acct_nm", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] yard = (JSPUtil.getParameter(request, prefix + "yard", length));
            String[] costNm = (JSPUtil.getParameter(request, prefix + "cost_nm", length));
            String[] soSeq = (JSPUtil.getParameter(request, prefix + "so_seq", length));
            String[] depNoOfTug = (JSPUtil.getParameter(request, prefix + "dep_no_of_tug", length));
            String[] issCtyCd = (JSPUtil.getParameter(request, prefix + "iss_cty_cd", length));
            String[] nrt = (JSPUtil.getParameter(request, prefix + "nrt", length));
            String[] foml1 = (JSPUtil.getParameter(request, prefix + "foml1", length));
            String[] foml2 = (JSPUtil.getParameter(request, prefix + "foml2", length));
            String[] issDt = (JSPUtil.getParameter(request, prefix + "iss_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] arrNoOfTug = (JSPUtil.getParameter(request, prefix + "arr_no_of_tug", length));
            String[] grt = (JSPUtil.getParameter(request, prefix + "grt", length));
            String[] rmk = (JSPUtil.getParameter(request, prefix + "rmk", length));
            String[] office = (JSPUtil.getParameter(request, prefix + "office", length));
            String[] suzGtWgt = (JSPUtil.getParameter(request, prefix + "suz_gt_wgt", length));
            String[] vpsAtbDt = (JSPUtil.getParameter(request, prefix + "vps_atb_dt", length));
            String[] madnVoySuzNetTongWgt = (JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", length));
            String[] vslNm = (JSPUtil.getParameter(request, prefix + "vsl_nm", length));
            String[] auditResult = (JSPUtil.getParameter(request, prefix + "audit_result", length));
            String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", length));
            String[] eacNo = (JSPUtil.getParameter(request, prefix + "eac_no", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] sel = (JSPUtil.getParameter(request, prefix + "sel", length));
            String[] bound = (JSPUtil.getParameter(request, prefix + "bound", length));
            String[] auditUsrId = (JSPUtil.getParameter(request, prefix + "audit_usr_id", length));
            String[] auditDt = (JSPUtil.getParameter(request, prefix + "audit_dt", length));
            String[] portChgAudRsltRmk = (JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_rmk", length));
            String[] portChgAudRsltUsrId = (JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_usr_id", length));
            String[] portChgAudRsltUsrNm = (JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_usr_nm", length));
            String[] sSaveTpCd = (JSPUtil.getParameter(request, prefix + "s_save_tp_cd", length));
            String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", length));
            String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", length));
            String[] invAudCurrCd = (JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", length));
	    	String[] invAudDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", length));
	    	String[] invAudUsdDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PreAuditListVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (diff[i] != null)
                    model.setDiff(diff[i]);
                if (apPayDt[i] != null)
                    model.setApPayDt(apPayDt[i]);
                if (tariffCost[i] != null)
                    model.setTariffCost(tariffCost[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (amount[i] != null)
                    model.setAmount(amount[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (payDueDt[i] != null)
                    model.setPayDueDt(payDueDt[i]);
                if (adjcost[i] != null)
                    model.setAdjcost(adjcost[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (rhq[i] != null)
                    model.setRhq(rhq[i]);
                if (countryOfNp[i] != null)
                    model.setCountryOfNp(countryOfNp[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (selectFlgTemp[i] != null)
                    model.setSelectFlgTemp(selectFlgTemp[i]);
                if (berthingHour[i] != null)
                    model.setBerthingHour(berthingHour[i]);
                if (issued[i] != null)
                    model.setIssued(issued[i]);
                if (lastPort[i] != null)
                    model.setLastPort(lastPort[i]);
                if (autoAuditFlg[i] != null)
                    model.setAutoAuditFlg(autoAuditFlg[i]);
                if (selectFlg[i] != null)
                    model.setSelectFlg(selectFlg[i]);
                if (payTermDys[i] != null)
                    model.setPayTermDys(payTermDys[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (scgCarTier[i] != null)
                    model.setScgCarTier(scgCarTier[i]);
                if (nightFlg[i] != null)
                    model.setNightFlg(nightFlg[i]);
                if (soDtlSeq[i] != null)
                    model.setSoDtlSeq(soDtlSeq[i]);
                if (spNm[i] != null)
                    model.setSpNm(spNm[i]);
                if (spNo[i] != null)
                    model.setSpNo(spNo[i]);
                if (sdrRt[i] != null)
                    model.setSdrRt(sdrRt[i]);
                if (port[i] != null)
                    model.setPort(port[i]);
                if (acctNm[i] != null)
                    model.setAcctNm(acctNm[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (yard[i] != null)
                    model.setYard(yard[i]);
                if (costNm[i] != null)
                    model.setCostNm(costNm[i]);
                if (soSeq[i] != null)
                    model.setSoSeq(soSeq[i]);
                if (depNoOfTug[i] != null)
                    model.setDepNoOfTug(depNoOfTug[i]);
                if (issCtyCd[i] != null)
                    model.setIssCtyCd(issCtyCd[i]);
                if (nrt[i] != null)
                    model.setNrt(nrt[i]);
                if (foml1[i] != null)
                    model.setFoml1(foml1[i]);
                if (foml2[i] != null)
                    model.setFoml2(foml2[i]);
                if (issDt[i] != null)
                    model.setIssDt(issDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (arrNoOfTug[i] != null)
                    model.setArrNoOfTug(arrNoOfTug[i]);
                if (grt[i] != null)
                    model.setGrt(grt[i]);
                if (rmk[i] != null)
                    model.setRmk(rmk[i]);
                if (office[i] != null)
                    model.setOffice(office[i]);
                if (suzGtWgt[i] != null)
                    model.setSuzGtWgt(suzGtWgt[i]);
                if (vpsAtbDt[i] != null)
                    model.setVpsAtbDt(vpsAtbDt[i]);
                if (madnVoySuzNetTongWgt[i] != null)
                    model.setMadnVoySuzNetTongWgt(madnVoySuzNetTongWgt[i]);
                if (vslNm[i] != null)
                    model.setVslNm(vslNm[i]);
                if (auditResult[i] != null)
                    model.setAuditResult(auditResult[i]);
                if (cntrVslClssCapa[i] != null)
                    model.setCntrVslClssCapa(cntrVslClssCapa[i]);
                if (eacNo[i] != null)
                    model.setEacNo(eacNo[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (sel[i] != null)
                    model.setSel(sel[i]);
                if (bound[i] != null)
                    model.setBound(bound[i]);
                if (auditUsrId[i] != null)
                    model.setAuditUsrId(auditUsrId[i]);
                if (auditDt[i] != null)
                    model.setAuditDt(auditDt[i]);
                if (portChgAudRsltRmk[i] != null)
                    model.setPortChgAudRsltRmk(portChgAudRsltRmk[i]);
                if (portChgAudRsltUsrId[i] != null)
                    model.setPortChgAudRsltUsrId(portChgAudRsltUsrId[i]);
                if (portChgAudRsltUsrNm[i] != null)
                    model.setPortChgAudRsltUsrNm(portChgAudRsltUsrNm[i]);
                if (sSaveTpCd[i] != null)
                    model.setsSaveTpCd(sSaveTpCd[i]);
                if (atchFileLnkId[i] != null)
                    model.setAtchFileLnkId(atchFileLnkId[i]);
                if (expnAudRsltCd[i] != null)
                    model.setExpnAudRsltCd(expnAudRsltCd[i]);
                if (invAudCurrCd[i] != null) 
		    		model.setInvAudCurrCd(invAudCurrCd[i]);
				if (invAudDiffAmt[i] != null) 
		    		model.setInvAudDiffAmt(invAudDiffAmt[i]);
				if (invAudUsdDiffAmt[i] != null) 
		    		model.setInvAudUsdDiffAmt(invAudUsdDiffAmt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPreAuditListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PreAuditListVO[]
	 */
    public PreAuditListVO[] getPreAuditListVOs() {
        PreAuditListVO[] vos = (PreAuditListVO[]) models.toArray(new PreAuditListVO[models.size()]);
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
        this.diff = this.diff.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apPayDt = this.apPayDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tariffCost = this.tariffCost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amount = this.amount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDueDt = this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.adjcost = this.adjcost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhq = this.rhq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.countryOfNp = this.countryOfNp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selectFlgTemp = this.selectFlgTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.berthingHour = this.berthingHour.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issued = this.issued.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastPort = this.lastPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAuditFlg = this.autoAuditFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selectFlg = this.selectFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payTermDys = this.payTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgCarTier = this.scgCarTier.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nightFlg = this.nightFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soDtlSeq = this.soDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spNm = this.spNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spNo = this.spNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sdrRt = this.sdrRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.port = this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctNm = this.acctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yard = this.yard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costNm = this.costNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soSeq = this.soSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.depNoOfTug = this.depNoOfTug.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issCtyCd = this.issCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nrt = this.nrt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foml1 = this.foml1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foml2 = this.foml2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issDt = this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arrNoOfTug = this.arrNoOfTug.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grt = this.grt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rmk = this.rmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.office = this.office.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.suzGtWgt = this.suzGtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsAtbDt = this.vpsAtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.madnVoySuzNetTongWgt = this.madnVoySuzNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslNm = this.vslNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditResult = this.auditResult.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVslClssCapa = this.cntrVslClssCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacNo = this.eacNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sel = this.sel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bound = this.bound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditUsrId = this.auditUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditDt = this.auditDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portChgAudRsltRmk = this.portChgAudRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portChgAudRsltUsrId = this.portChgAudRsltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portChgAudRsltUsrNm = this.portChgAudRsltUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSaveTpCd = this.sSaveTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atchFileLnkId = this.atchFileLnkId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltCd = this.expnAudRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudCurrCd = this.invAudCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudDiffAmt = this.invAudDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudUsdDiffAmt = this.invAudUsdDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
