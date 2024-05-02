/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchAutoAuditStatisticsVO.java
*@FileTitle : SearchAutoAuditStatisticsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.12  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo;

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
public class SearchAutoAuditStatisticsVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchAutoAuditStatisticsVO> models = new ArrayList<SearchAutoAuditStatisticsVO>();

    /* Column Info */
    private String sInvCfmToDt = null;

    /* Column Info */
    private String auditAmt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sRhqOfcCd = null;

    /* Column Info */
    private String sAutoExpnAudStsCd = null;

    /* Column Info */
    private String tpCd = null;

    /* Column Info */
    private String rhqCd = null;

    /* Column Info */
    private String noAuditAmt = null;

    /* Column Info */
    private String autoExpnAudStsCd = null;

    /* Column Info */
    private String rhqOrd = null;

    /* Column Info */
    private String invOfcCd = null;

    /* Column Info */
    private String totCnt = null;

    /* Column Info */
    private String auditCntPer = null;

    /* Column Info */
    private String noAuditCntPer = null;

    /* Column Info */
    private String mdlCd = null;

    /* Column Info */
    private String sToday = null;

    /* Column Info */
    private String sEacIfFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String auditCnt = null;

    /* Column Info */
    private String sMdlCd = null;

    /* Column Info */
    private String invOfcOrd = null;

    /* Column Info */
    private String totAmt = null;

    /* Column Info */
    private String autoExpnAudStsNm = null;

    /* Column Info */
    private String noAuditCnt = null;

    /* Column Info */
    private String noAuditAmtPer = null;

    /* Column Info */
    private String sInvCfmFmDt = null;

    /* Column Info */
    private String mdlCdOrd = null;

    /* Column Info */
    private String auditAmtPer = null;

    /* Column Info */
    private String totAmtPer = null;

    /* Column Info */
    private String sOfcCd = null;

    /* Column Info */
    private String totCntPer = null;

    /* Column Info */
    private String audUsdDiffAmt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchAutoAuditStatisticsVO() {
    }

    public SearchAutoAuditStatisticsVO(String ibflag, String pagerows, String sRhqOfcCd, String totAmt, String autoExpnAudStsNm, String sInvCfmFmDt, String noAuditCntPer, String mdlCdOrd, String autoExpnAudStsCd, String sInvCfmToDt, String auditAmt, String auditCntPer, String totCntPer, String auditAmtPer, String tpCd, String noAuditCnt, String invOfcCd, String sMdlCd, String totCnt, String rhqCd, String sAutoExpnAudStsCd, String noAuditAmt, String sEacIfFlg, String auditCnt, String sOfcCd, String invOfcOrd, String mdlCd, String rhqOrd, String totAmtPer, String noAuditAmtPer, String sToday, String audUsdDiffAmt) {
        this.sInvCfmToDt = sInvCfmToDt;
        this.auditAmt = auditAmt;
        this.ibflag = ibflag;
        this.sRhqOfcCd = sRhqOfcCd;
        this.sAutoExpnAudStsCd = sAutoExpnAudStsCd;
        this.tpCd = tpCd;
        this.rhqCd = rhqCd;
        this.noAuditAmt = noAuditAmt;
        this.autoExpnAudStsCd = autoExpnAudStsCd;
        this.rhqOrd = rhqOrd;
        this.invOfcCd = invOfcCd;
        this.totCnt = totCnt;
        this.auditCntPer = auditCntPer;
        this.noAuditCntPer = noAuditCntPer;
        this.mdlCd = mdlCd;
        this.sToday = sToday;
        this.sEacIfFlg = sEacIfFlg;
        this.pagerows = pagerows;
        this.auditCnt = auditCnt;
        this.sMdlCd = sMdlCd;
        this.invOfcOrd = invOfcOrd;
        this.totAmt = totAmt;
        this.autoExpnAudStsNm = autoExpnAudStsNm;
        this.noAuditCnt = noAuditCnt;
        this.noAuditAmtPer = noAuditAmtPer;
        this.sInvCfmFmDt = sInvCfmFmDt;
        this.mdlCdOrd = mdlCdOrd;
        this.auditAmtPer = auditAmtPer;
        this.totAmtPer = totAmtPer;
        this.sOfcCd = sOfcCd;
        this.totCntPer = totCntPer;
        this.audUsdDiffAmt = audUsdDiffAmt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("s_inv_cfm_to_dt", getSInvCfmToDt());
        this.hashColumns.put("audit_amt", getAuditAmt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
        this.hashColumns.put("s_auto_expn_aud_sts_cd", getSAutoExpnAudStsCd());
        this.hashColumns.put("tp_cd", getTpCd());
        this.hashColumns.put("rhq_cd", getRhqCd());
        this.hashColumns.put("no_audit_amt", getNoAuditAmt());
        this.hashColumns.put("auto_expn_aud_sts_cd", getAutoExpnAudStsCd());
        this.hashColumns.put("rhq_ord", getRhqOrd());
        this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
        this.hashColumns.put("tot_cnt", getTotCnt());
        this.hashColumns.put("audit_cnt_per", getAuditCntPer());
        this.hashColumns.put("no_audit_cnt_per", getNoAuditCntPer());
        this.hashColumns.put("mdl_cd", getMdlCd());
        this.hashColumns.put("s_today", getSToday());
        this.hashColumns.put("s_eac_if_flg", getSEacIfFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("audit_cnt", getAuditCnt());
        this.hashColumns.put("s_mdl_cd", getSMdlCd());
        this.hashColumns.put("inv_ofc_ord", getInvOfcOrd());
        this.hashColumns.put("tot_amt", getTotAmt());
        this.hashColumns.put("auto_expn_aud_sts_nm", getAutoExpnAudStsNm());
        this.hashColumns.put("no_audit_cnt", getNoAuditCnt());
        this.hashColumns.put("no_audit_amt_per", getNoAuditAmtPer());
        this.hashColumns.put("s_inv_cfm_fm_dt", getSInvCfmFmDt());
        this.hashColumns.put("mdl_cd_ord", getMdlCdOrd());
        this.hashColumns.put("audit_amt_per", getAuditAmtPer());
        this.hashColumns.put("tot_amt_per", getTotAmtPer());
        this.hashColumns.put("s_ofc_cd", getSOfcCd());
        this.hashColumns.put("tot_cnt_per", getTotCntPer());
        this.hashColumns.put("aud_usd_diff_amt", getAudUsdDiffAmt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("s_inv_cfm_to_dt", "sInvCfmToDt");
        this.hashFields.put("audit_amt", "auditAmt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
        this.hashFields.put("s_auto_expn_aud_sts_cd", "sAutoExpnAudStsCd");
        this.hashFields.put("tp_cd", "tpCd");
        this.hashFields.put("rhq_cd", "rhqCd");
        this.hashFields.put("no_audit_amt", "noAuditAmt");
        this.hashFields.put("auto_expn_aud_sts_cd", "autoExpnAudStsCd");
        this.hashFields.put("rhq_ord", "rhqOrd");
        this.hashFields.put("inv_ofc_cd", "invOfcCd");
        this.hashFields.put("tot_cnt", "totCnt");
        this.hashFields.put("audit_cnt_per", "auditCntPer");
        this.hashFields.put("no_audit_cnt_per", "noAuditCntPer");
        this.hashFields.put("mdl_cd", "mdlCd");
        this.hashFields.put("s_today", "sToday");
        this.hashFields.put("s_eac_if_flg", "sEacIfFlg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("audit_cnt", "auditCnt");
        this.hashFields.put("s_mdl_cd", "sMdlCd");
        this.hashFields.put("inv_ofc_ord", "invOfcOrd");
        this.hashFields.put("tot_amt", "totAmt");
        this.hashFields.put("auto_expn_aud_sts_nm", "autoExpnAudStsNm");
        this.hashFields.put("no_audit_cnt", "noAuditCnt");
        this.hashFields.put("no_audit_amt_per", "noAuditAmtPer");
        this.hashFields.put("s_inv_cfm_fm_dt", "sInvCfmFmDt");
        this.hashFields.put("mdl_cd_ord", "mdlCdOrd");
        this.hashFields.put("audit_amt_per", "auditAmtPer");
        this.hashFields.put("tot_amt_per", "totAmtPer");
        this.hashFields.put("s_ofc_cd", "sOfcCd");
        this.hashFields.put("tot_cnt_per", "totCntPer");
        this.hashFields.put("aud_usd_diff_amt", "audUsdDiffAmt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return sInvCfmToDt
	 */
    public String getSInvCfmToDt() {
        return this.sInvCfmToDt;
    }

    /**
	 * Column Info
	 * @return auditAmt
	 */
    public String getAuditAmt() {
        return this.auditAmt;
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
	 * @return sRhqOfcCd
	 */
    public String getSRhqOfcCd() {
        return this.sRhqOfcCd;
    }

    /**
	 * Column Info
	 * @return sAutoExpnAudStsCd
	 */
    public String getSAutoExpnAudStsCd() {
        return this.sAutoExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @return tpCd
	 */
    public String getTpCd() {
        return this.tpCd;
    }

    /**
	 * Column Info
	 * @return rhqCd
	 */
    public String getRhqCd() {
        return this.rhqCd;
    }

    /**
	 * Column Info
	 * @return noAuditAmt
	 */
    public String getNoAuditAmt() {
        return this.noAuditAmt;
    }

    /**
	 * Column Info
	 * @return autoExpnAudStsCd
	 */
    public String getAutoExpnAudStsCd() {
        return this.autoExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @return rhqOrd
	 */
    public String getRhqOrd() {
        return this.rhqOrd;
    }

    /**
	 * Column Info
	 * @return invOfcCd
	 */
    public String getInvOfcCd() {
        return this.invOfcCd;
    }

    /**
	 * Column Info
	 * @return totCnt
	 */
    public String getTotCnt() {
        return this.totCnt;
    }

    /**
	 * Column Info
	 * @return auditCntPer
	 */
    public String getAuditCntPer() {
        return this.auditCntPer;
    }

    /**
	 * Column Info
	 * @return noAuditCntPer
	 */
    public String getNoAuditCntPer() {
        return this.noAuditCntPer;
    }

    /**
	 * Column Info
	 * @return mdlCd
	 */
    public String getMdlCd() {
        return this.mdlCd;
    }

    /**
	 * Column Info
	 * @return sToday
	 */
    public String getSToday() {
        return this.sToday;
    }

    /**
	 * Column Info
	 * @return sEacIfFlg
	 */
    public String getSEacIfFlg() {
        return this.sEacIfFlg;
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
	 * @return auditCnt
	 */
    public String getAuditCnt() {
        return this.auditCnt;
    }

    /**
	 * Column Info
	 * @return sMdlCd
	 */
    public String getSMdlCd() {
        return this.sMdlCd;
    }

    /**
	 * Column Info
	 * @return invOfcOrd
	 */
    public String getInvOfcOrd() {
        return this.invOfcOrd;
    }

    /**
	 * Column Info
	 * @return totAmt
	 */
    public String getTotAmt() {
        return this.totAmt;
    }

    /**
	 * Column Info
	 * @return autoExpnAudStsNm
	 */
    public String getAutoExpnAudStsNm() {
        return this.autoExpnAudStsNm;
    }

    /**
	 * Column Info
	 * @return noAuditCnt
	 */
    public String getNoAuditCnt() {
        return this.noAuditCnt;
    }

    /**
	 * Column Info
	 * @return noAuditAmtPer
	 */
    public String getNoAuditAmtPer() {
        return this.noAuditAmtPer;
    }

    /**
	 * Column Info
	 * @return sInvCfmFmDt
	 */
    public String getSInvCfmFmDt() {
        return this.sInvCfmFmDt;
    }

    /**
	 * Column Info
	 * @return mdlCdOrd
	 */
    public String getMdlCdOrd() {
        return this.mdlCdOrd;
    }

    /**
	 * Column Info
	 * @return auditAmtPer
	 */
    public String getAuditAmtPer() {
        return this.auditAmtPer;
    }

    /**
	 * Column Info
	 * @return totAmtPer
	 */
    public String getTotAmtPer() {
        return this.totAmtPer;
    }

    /**
	 * Column Info
	 * @return sOfcCd
	 */
    public String getSOfcCd() {
        return this.sOfcCd;
    }

    /**
	 * Column Info
	 * @return totCntPer
	 */
    public String getTotCntPer() {
        return this.totCntPer;
    }

    /**
	 * Column Info
	 * @param sInvCfmToDt
	 */
    public void setSInvCfmToDt(String sInvCfmToDt) {
        this.sInvCfmToDt = sInvCfmToDt;
    }

    /**
	 * Column Info
	 * @param auditAmt
	 */
    public void setAuditAmt(String auditAmt) {
        this.auditAmt = auditAmt;
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
	 * @param sRhqOfcCd
	 */
    public void setSRhqOfcCd(String sRhqOfcCd) {
        this.sRhqOfcCd = sRhqOfcCd;
    }

    /**
	 * Column Info
	 * @param sAutoExpnAudStsCd
	 */
    public void setSAutoExpnAudStsCd(String sAutoExpnAudStsCd) {
        this.sAutoExpnAudStsCd = sAutoExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @param tpCd
	 */
    public void setTpCd(String tpCd) {
        this.tpCd = tpCd;
    }

    /**
	 * Column Info
	 * @param rhqCd
	 */
    public void setRhqCd(String rhqCd) {
        this.rhqCd = rhqCd;
    }

    /**
	 * Column Info
	 * @param noAuditAmt
	 */
    public void setNoAuditAmt(String noAuditAmt) {
        this.noAuditAmt = noAuditAmt;
    }

    /**
	 * Column Info
	 * @param autoExpnAudStsCd
	 */
    public void setAutoExpnAudStsCd(String autoExpnAudStsCd) {
        this.autoExpnAudStsCd = autoExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @param rhqOrd
	 */
    public void setRhqOrd(String rhqOrd) {
        this.rhqOrd = rhqOrd;
    }

    /**
	 * Column Info
	 * @param invOfcCd
	 */
    public void setInvOfcCd(String invOfcCd) {
        this.invOfcCd = invOfcCd;
    }

    /**
	 * Column Info
	 * @param totCnt
	 */
    public void setTotCnt(String totCnt) {
        this.totCnt = totCnt;
    }

    /**
	 * Column Info
	 * @param auditCntPer
	 */
    public void setAuditCntPer(String auditCntPer) {
        this.auditCntPer = auditCntPer;
    }

    /**
	 * Column Info
	 * @param noAuditCntPer
	 */
    public void setNoAuditCntPer(String noAuditCntPer) {
        this.noAuditCntPer = noAuditCntPer;
    }

    /**
	 * Column Info
	 * @param mdlCd
	 */
    public void setMdlCd(String mdlCd) {
        this.mdlCd = mdlCd;
    }

    /**
	 * Column Info
	 * @param sToday
	 */
    public void setSToday(String sToday) {
        this.sToday = sToday;
    }

    /**
	 * Column Info
	 * @param sEacIfFlg
	 */
    public void setSEacIfFlg(String sEacIfFlg) {
        this.sEacIfFlg = sEacIfFlg;
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
	 * @param auditCnt
	 */
    public void setAuditCnt(String auditCnt) {
        this.auditCnt = auditCnt;
    }

    /**
	 * Column Info
	 * @param sMdlCd
	 */
    public void setSMdlCd(String sMdlCd) {
        this.sMdlCd = sMdlCd;
    }

    /**
	 * Column Info
	 * @param invOfcOrd
	 */
    public void setInvOfcOrd(String invOfcOrd) {
        this.invOfcOrd = invOfcOrd;
    }

    /**
	 * Column Info
	 * @param totAmt
	 */
    public void setTotAmt(String totAmt) {
        this.totAmt = totAmt;
    }

    /**
	 * Column Info
	 * @param autoExpnAudStsNm
	 */
    public void setAutoExpnAudStsNm(String autoExpnAudStsNm) {
        this.autoExpnAudStsNm = autoExpnAudStsNm;
    }

    /**
	 * Column Info
	 * @param noAuditCnt
	 */
    public void setNoAuditCnt(String noAuditCnt) {
        this.noAuditCnt = noAuditCnt;
    }

    /**
	 * Column Info
	 * @param noAuditAmtPer
	 */
    public void setNoAuditAmtPer(String noAuditAmtPer) {
        this.noAuditAmtPer = noAuditAmtPer;
    }

    /**
	 * Column Info
	 * @param sInvCfmFmDt
	 */
    public void setSInvCfmFmDt(String sInvCfmFmDt) {
        this.sInvCfmFmDt = sInvCfmFmDt;
    }

    /**
	 * Column Info
	 * @param mdlCdOrd
	 */
    public void setMdlCdOrd(String mdlCdOrd) {
        this.mdlCdOrd = mdlCdOrd;
    }

    /**
	 * Column Info
	 * @param auditAmtPer
	 */
    public void setAuditAmtPer(String auditAmtPer) {
        this.auditAmtPer = auditAmtPer;
    }

    /**
	 * Column Info
	 * @param totAmtPer
	 */
    public void setTotAmtPer(String totAmtPer) {
        this.totAmtPer = totAmtPer;
    }

    /**
	 * Column Info
	 * @param sOfcCd
	 */
    public void setSOfcCd(String sOfcCd) {
        this.sOfcCd = sOfcCd;
    }

    /**
	 * Column Info
	 * @param totCntPer
	 */
    public void setTotCntPer(String totCntPer) {
        this.totCntPer = totCntPer;
    }

    public void setAudUsdDiffAmt(String audUsdDiffAmt) {
        this.audUsdDiffAmt = audUsdDiffAmt;
    }

    public String getAudUsdDiffAmt() {
        return this.audUsdDiffAmt;
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
        setSInvCfmToDt(JSPUtil.getParameter(request, prefix + "s_inv_cfm_to_dt", ""));
        setAuditAmt(JSPUtil.getParameter(request, prefix + "audit_amt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
        setSAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "s_auto_expn_aud_sts_cd", ""));
        setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
        setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
        setNoAuditAmt(JSPUtil.getParameter(request, prefix + "no_audit_amt", ""));
        setAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", ""));
        setRhqOrd(JSPUtil.getParameter(request, prefix + "rhq_ord", ""));
        setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
        setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
        setAuditCntPer(JSPUtil.getParameter(request, prefix + "audit_cnt_per", ""));
        setNoAuditCntPer(JSPUtil.getParameter(request, prefix + "no_audit_cnt_per", ""));
        setMdlCd(JSPUtil.getParameter(request, prefix + "mdl_cd", ""));
        setSToday(JSPUtil.getParameter(request, prefix + "s_today", ""));
        setSEacIfFlg(JSPUtil.getParameter(request, prefix + "s_eac_if_flg", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAuditCnt(JSPUtil.getParameter(request, prefix + "audit_cnt", ""));
        setSMdlCd(JSPUtil.getParameter(request, prefix + "s_mdl_cd", ""));
        setInvOfcOrd(JSPUtil.getParameter(request, prefix + "inv_ofc_ord", ""));
        setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
        setAutoExpnAudStsNm(JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_nm", ""));
        setNoAuditCnt(JSPUtil.getParameter(request, prefix + "no_audit_cnt", ""));
        setNoAuditAmtPer(JSPUtil.getParameter(request, prefix + "no_audit_amt_per", ""));
        setSInvCfmFmDt(JSPUtil.getParameter(request, prefix + "s_inv_cfm_fm_dt", ""));
        setMdlCdOrd(JSPUtil.getParameter(request, prefix + "mdl_cd_ord", ""));
        setAuditAmtPer(JSPUtil.getParameter(request, prefix + "audit_amt_per", ""));
        setTotAmtPer(JSPUtil.getParameter(request, prefix + "tot_amt_per", ""));
        setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
        setTotCntPer(JSPUtil.getParameter(request, prefix + "tot_cnt_per", ""));
        setAudUsdDiffAmt(JSPUtil.getParameter(request, prefix + "aud_usd_diff_amt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAutoAuditStatisticsVO[]
	 */
    public SearchAutoAuditStatisticsVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAutoAuditStatisticsVO[]
	 */
    public SearchAutoAuditStatisticsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchAutoAuditStatisticsVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] sInvCfmToDt = (JSPUtil.getParameter(request, prefix + "s_inv_cfm_to_dt", length));
            String[] auditAmt = (JSPUtil.getParameter(request, prefix + "audit_amt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", length));
            String[] sAutoExpnAudStsCd = (JSPUtil.getParameter(request, prefix + "s_auto_expn_aud_sts_cd", length));
            String[] tpCd = (JSPUtil.getParameter(request, prefix + "tp_cd", length));
            String[] rhqCd = (JSPUtil.getParameter(request, prefix + "rhq_cd", length));
            String[] noAuditAmt = (JSPUtil.getParameter(request, prefix + "no_audit_amt", length));
            String[] autoExpnAudStsCd = (JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", length));
            String[] rhqOrd = (JSPUtil.getParameter(request, prefix + "rhq_ord", length));
            String[] invOfcCd = (JSPUtil.getParameter(request, prefix + "inv_ofc_cd", length));
            String[] totCnt = (JSPUtil.getParameter(request, prefix + "tot_cnt", length));
            String[] auditCntPer = (JSPUtil.getParameter(request, prefix + "audit_cnt_per", length));
            String[] noAuditCntPer = (JSPUtil.getParameter(request, prefix + "no_audit_cnt_per", length));
            String[] mdlCd = (JSPUtil.getParameter(request, prefix + "mdl_cd", length));
            String[] sToday = (JSPUtil.getParameter(request, prefix + "s_today", length));
            String[] sEacIfFlg = (JSPUtil.getParameter(request, prefix + "s_eac_if_flg", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] auditCnt = (JSPUtil.getParameter(request, prefix + "audit_cnt", length));
            String[] sMdlCd = (JSPUtil.getParameter(request, prefix + "s_mdl_cd", length));
            String[] invOfcOrd = (JSPUtil.getParameter(request, prefix + "inv_ofc_ord", length));
            String[] totAmt = (JSPUtil.getParameter(request, prefix + "tot_amt", length));
            String[] autoExpnAudStsNm = (JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_nm", length));
            String[] noAuditCnt = (JSPUtil.getParameter(request, prefix + "no_audit_cnt", length));
            String[] noAuditAmtPer = (JSPUtil.getParameter(request, prefix + "no_audit_amt_per", length));
            String[] sInvCfmFmDt = (JSPUtil.getParameter(request, prefix + "s_inv_cfm_fm_dt", length));
            String[] mdlCdOrd = (JSPUtil.getParameter(request, prefix + "mdl_cd_ord", length));
            String[] auditAmtPer = (JSPUtil.getParameter(request, prefix + "audit_amt_per", length));
            String[] totAmtPer = (JSPUtil.getParameter(request, prefix + "tot_amt_per", length));
            String[] sOfcCd = (JSPUtil.getParameter(request, prefix + "s_ofc_cd", length));
            String[] totCntPer = (JSPUtil.getParameter(request, prefix + "tot_cnt_per", length));
            String[] audUsdDiffAmt = (JSPUtil.getParameter(request, prefix + "aud_usd_diff_amt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchAutoAuditStatisticsVO();
                if (sInvCfmToDt[i] != null)
                    model.setSInvCfmToDt(sInvCfmToDt[i]);
                if (auditAmt[i] != null)
                    model.setAuditAmt(auditAmt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sRhqOfcCd[i] != null)
                    model.setSRhqOfcCd(sRhqOfcCd[i]);
                if (sAutoExpnAudStsCd[i] != null)
                    model.setSAutoExpnAudStsCd(sAutoExpnAudStsCd[i]);
                if (tpCd[i] != null)
                    model.setTpCd(tpCd[i]);
                if (rhqCd[i] != null)
                    model.setRhqCd(rhqCd[i]);
                if (noAuditAmt[i] != null)
                    model.setNoAuditAmt(noAuditAmt[i]);
                if (autoExpnAudStsCd[i] != null)
                    model.setAutoExpnAudStsCd(autoExpnAudStsCd[i]);
                if (rhqOrd[i] != null)
                    model.setRhqOrd(rhqOrd[i]);
                if (invOfcCd[i] != null)
                    model.setInvOfcCd(invOfcCd[i]);
                if (totCnt[i] != null)
                    model.setTotCnt(totCnt[i]);
                if (auditCntPer[i] != null)
                    model.setAuditCntPer(auditCntPer[i]);
                if (noAuditCntPer[i] != null)
                    model.setNoAuditCntPer(noAuditCntPer[i]);
                if (mdlCd[i] != null)
                    model.setMdlCd(mdlCd[i]);
                if (sToday[i] != null)
                    model.setSToday(sToday[i]);
                if (sEacIfFlg[i] != null)
                    model.setSEacIfFlg(sEacIfFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (auditCnt[i] != null)
                    model.setAuditCnt(auditCnt[i]);
                if (sMdlCd[i] != null)
                    model.setSMdlCd(sMdlCd[i]);
                if (invOfcOrd[i] != null)
                    model.setInvOfcOrd(invOfcOrd[i]);
                if (totAmt[i] != null)
                    model.setTotAmt(totAmt[i]);
                if (autoExpnAudStsNm[i] != null)
                    model.setAutoExpnAudStsNm(autoExpnAudStsNm[i]);
                if (noAuditCnt[i] != null)
                    model.setNoAuditCnt(noAuditCnt[i]);
                if (noAuditAmtPer[i] != null)
                    model.setNoAuditAmtPer(noAuditAmtPer[i]);
                if (sInvCfmFmDt[i] != null)
                    model.setSInvCfmFmDt(sInvCfmFmDt[i]);
                if (mdlCdOrd[i] != null)
                    model.setMdlCdOrd(mdlCdOrd[i]);
                if (auditAmtPer[i] != null)
                    model.setAuditAmtPer(auditAmtPer[i]);
                if (totAmtPer[i] != null)
                    model.setTotAmtPer(totAmtPer[i]);
                if (sOfcCd[i] != null)
                    model.setSOfcCd(sOfcCd[i]);
                if (totCntPer[i] != null)
                    model.setTotCntPer(totCntPer[i]);
                if (audUsdDiffAmt[i] != null) 
		    		model.setAudUsdDiffAmt(audUsdDiffAmt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchAutoAuditStatisticsVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchAutoAuditStatisticsVO[]
	 */
    public SearchAutoAuditStatisticsVO[] getSearchAutoAuditStatisticsVOs() {
        SearchAutoAuditStatisticsVO[] vos = (SearchAutoAuditStatisticsVO[]) models.toArray(new SearchAutoAuditStatisticsVO[models.size()]);
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
        this.sInvCfmToDt = this.sInvCfmToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditAmt = this.auditAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sRhqOfcCd = this.sRhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sAutoExpnAudStsCd = this.sAutoExpnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tpCd = this.tpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqCd = this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noAuditAmt = this.noAuditAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoExpnAudStsCd = this.autoExpnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOrd = this.rhqOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invOfcCd = this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totCnt = this.totCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditCntPer = this.auditCntPer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noAuditCntPer = this.noAuditCntPer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mdlCd = this.mdlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sToday = this.sToday.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacIfFlg = this.sEacIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditCnt = this.auditCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sMdlCd = this.sMdlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invOfcOrd = this.invOfcOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totAmt = this.totAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoExpnAudStsNm = this.autoExpnAudStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noAuditCnt = this.noAuditCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noAuditAmtPer = this.noAuditAmtPer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sInvCfmFmDt = this.sInvCfmFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mdlCdOrd = this.mdlCdOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditAmtPer = this.auditAmtPer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totAmtPer = this.totAmtPer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOfcCd = this.sOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totCntPer = this.totCntPer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audUsdDiffAmt = this.audUsdDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
