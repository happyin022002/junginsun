/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConsultationConditionVO.java
*@FileTitle : ConsultationConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ConsultationConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ConsultationConditionVO> models = new ArrayList<ConsultationConditionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String frRevYrmon = null;

    /* Column Info */
    private String toRevYrmon = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String joCrrCds = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String joStlItmCds = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String acctgCrrCd = null;

    /* Column Info */
    private String acctgCrrCds = null;

    /* Column Info */
    private String frInvYrmon = null;

    /* Column Info */
    private String toInvYrmon = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String revVvd = null;

    /* Column Info */
    private String frAcctYrmon = null;

    /* Column Info */
    private String toAcctYrmon = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String acctYrmon = null;

    /* Column Info */
    private String prnrRefNo = null;

    /* Column Info */
    private String stlVvdSeq = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String authOfcCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ConsultationConditionVO() {
    }

    public ConsultationConditionVO(String ibflag, String pagerows, String frRevYrmon, String toRevYrmon, String joCrrCd, String joCrrCds, String invNo, String joStlItmCd, String joStlItmCds, String trdCd, String reDivrCd, String acctgCrrCd, String acctgCrrCds, String frInvYrmon, String toInvYrmon, String rlaneCd, String revVvd, String frAcctYrmon, String toAcctYrmon, String loclCurrCd, String ofcCd, String usrId, String acctYrmon, String prnrRefNo, String stlVvdSeq, String revYrmon, String authOfcCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.frRevYrmon = frRevYrmon;
        this.toRevYrmon = toRevYrmon;
        this.joCrrCd = joCrrCd;
        this.joCrrCds = joCrrCds;
        this.invNo = invNo;
        this.joStlItmCd = joStlItmCd;
        this.joStlItmCds = joStlItmCds;
        this.trdCd = trdCd;
        this.reDivrCd = reDivrCd;
        this.acctgCrrCd = acctgCrrCd;
        this.acctgCrrCds = acctgCrrCds;
        this.frInvYrmon = frInvYrmon;
        this.toInvYrmon = toInvYrmon;
        this.rlaneCd = rlaneCd;
        this.revVvd = revVvd;
        this.frAcctYrmon = frAcctYrmon;
        this.toAcctYrmon = toAcctYrmon;
        this.loclCurrCd = loclCurrCd;
        this.ofcCd = ofcCd;
        this.usrId = usrId;
        this.acctYrmon = acctYrmon;
        this.prnrRefNo = prnrRefNo;
        this.stlVvdSeq = stlVvdSeq;
        this.revYrmon = revYrmon;
        this.authOfcCd = authOfcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("fr_rev_yrmon", getFrRevYrmon());
        this.hashColumns.put("to_rev_yrmon", getToRevYrmon());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("jo_crr_cds", getJoCrrCds());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("jo_stl_itm_cds", getJoStlItmCds());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("acctg_crr_cd", getAcctgCrrCd());
        this.hashColumns.put("acctg_crr_cds", getAcctgCrrCds());
        this.hashColumns.put("fr_inv_yrmon", getFrInvYrmon());
        this.hashColumns.put("to_inv_yrmon", getToInvYrmon());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("rev_vvd", getRevVvd());
        this.hashColumns.put("fr_acct_yrmon", getFrAcctYrmon());
        this.hashColumns.put("to_acct_yrmon", getToAcctYrmon());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("prnr_ref_no", getPrnrRefNo());
        this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("fr_rev_yrmon", "frRevYrmon");
        this.hashFields.put("to_rev_yrmon", "toRevYrmon");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("jo_crr_cds", "joCrrCds");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("jo_stl_itm_cds", "joStlItmCds");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("acctg_crr_cd", "acctgCrrCd");
        this.hashFields.put("acctg_crr_cds", "acctgCrrCds");
        this.hashFields.put("fr_inv_yrmon", "frInvYrmon");
        this.hashFields.put("to_inv_yrmon", "toInvYrmon");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("rev_vvd", "revVvd");
        this.hashFields.put("fr_acct_yrmon", "frAcctYrmon");
        this.hashFields.put("to_acct_yrmon", "toAcctYrmon");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("prnr_ref_no", "prnrRefNo");
        this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String frRevYrmon
	 */
    public void setFrRevYrmon(String frRevYrmon) {
        this.frRevYrmon = frRevYrmon;
    }

    /**
	 * 
	 * @return String frRevYrmon
	 */
    public String getFrRevYrmon() {
        return this.frRevYrmon;
    }

    /**
	 *
	 * @param String toRevYrmon
	 */
    public void setToRevYrmon(String toRevYrmon) {
        this.toRevYrmon = toRevYrmon;
    }

    /**
	 * 
	 * @return String toRevYrmon
	 */
    public String getToRevYrmon() {
        return this.toRevYrmon;
    }

    /**
	 *
	 * @param String joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * 
	 * @return String joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 *
	 * @param String joCrrCds
	 */
    public void setJoCrrCds(String joCrrCds) {
        this.joCrrCds = joCrrCds;
    }

    /**
	 * 
	 * @return String joCrrCds
	 */
    public String getJoCrrCds() {
        return this.joCrrCds;
    }

    /**
	 *
	 * @param String invNo
	 */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    /**
	 * 
	 * @return String invNo
	 */
    public String getInvNo() {
        return this.invNo;
    }

    /**
	 *
	 * @param String joStlItmCd
	 */
    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    /**
	 * 
	 * @return String joStlItmCd
	 */
    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    /**
	 *
	 * @param String joStlItmCds
	 */
    public void setJoStlItmCds(String joStlItmCds) {
        this.joStlItmCds = joStlItmCds;
    }

    /**
	 * 
	 * @return String joStlItmCds
	 */
    public String getJoStlItmCds() {
        return this.joStlItmCds;
    }

    /**
	 *
	 * @param String trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * 
	 * @return String trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 *
	 * @param String reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * 
	 * @return String reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 *
	 * @param String acctgCrrCd
	 */
    public void setAcctgCrrCd(String acctgCrrCd) {
        this.acctgCrrCd = acctgCrrCd;
    }

    /**
	 * 
	 * @return String acctgCrrCd
	 */
    public String getAcctgCrrCd() {
        return this.acctgCrrCd;
    }

    /**
	 *
	 * @param String acctgCrrCds
	 */
    public void setAcctgCrrCds(String acctgCrrCds) {
        this.acctgCrrCds = acctgCrrCds;
    }

    /**
	 * 
	 * @return String acctgCrrCds
	 */
    public String getAcctgCrrCds() {
        return this.acctgCrrCds;
    }

    /**
	 *
	 * @param String frInvYrmon
	 */
    public void setFrInvYrmon(String frInvYrmon) {
        this.frInvYrmon = frInvYrmon;
    }

    /**
	 * 
	 * @return String frInvYrmon
	 */
    public String getFrInvYrmon() {
        return this.frInvYrmon;
    }

    /**
	 *
	 * @param String toInvYrmon
	 */
    public void setToInvYrmon(String toInvYrmon) {
        this.toInvYrmon = toInvYrmon;
    }

    /**
	 * 
	 * @return String toInvYrmon
	 */
    public String getToInvYrmon() {
        return this.toInvYrmon;
    }

    /**
	 *
	 * @param String rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * 
	 * @return String rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 *
	 * @param String revVvd
	 */
    public void setRevVvd(String revVvd) {
        this.revVvd = revVvd;
    }

    /**
	 * 
	 * @return String revVvd
	 */
    public String getRevVvd() {
        return this.revVvd;
    }

    public void setFrAcctYrmon(String frAcctYrmon) {
        this.frAcctYrmon = frAcctYrmon;
    }

    public String getFrAcctYrmon() {
        return this.frAcctYrmon;
    }

    public void setToAcctYrmon(String toAcctYrmon) {
        this.toAcctYrmon = toAcctYrmon;
    }

    public String getToAcctYrmon() {
        return this.toAcctYrmon;
    }

    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setAcctYrmon(String acctYrmon) {
        this.acctYrmon = acctYrmon;
    }

    public String getAcctYrmon() {
        return this.acctYrmon;
    }

    public void setPrnrRefNo(String prnrRefNo) {
        this.prnrRefNo = prnrRefNo;
    }

    public String getPrnrRefNo() {
        return this.prnrRefNo;
    }

    public void setStlVvdSeq(String stlVvdSeq) {
        this.stlVvdSeq = stlVvdSeq;
    }

    public String getStlVvdSeq() {
        return this.stlVvdSeq;
    }

    public void setRevYrmon(String revYrmon) {
        this.revYrmon = revYrmon;
    }

    public String getRevYrmon() {
        return this.revYrmon;
    }

    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    public String getAuthOfcCd() {
        return this.authOfcCd;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFrRevYrmon(JSPUtil.getParameter(request, prefix + "fr_rev_yrmon", ""));
        setToRevYrmon(JSPUtil.getParameter(request, prefix + "to_rev_yrmon", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setJoCrrCds(JSPUtil.getParameter(request, prefix + "jo_crr_cds", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setJoStlItmCds(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cds", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setAcctgCrrCd(JSPUtil.getParameter(request, prefix + "acctg_crr_cd", ""));
        setAcctgCrrCds(JSPUtil.getParameter(request, prefix + "acctg_crr_cds", ""));
        setFrInvYrmon(JSPUtil.getParameter(request, prefix + "fr_inv_yrmon", ""));
        setToInvYrmon(JSPUtil.getParameter(request, prefix + "to_inv_yrmon", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setRevVvd(JSPUtil.getParameter(request, prefix + "rev_vvd", ""));
        setFrAcctYrmon(JSPUtil.getParameter(request, prefix + "fr_acct_yrmon", ""));
        setToAcctYrmon(JSPUtil.getParameter(request, prefix + "to_acct_yrmon", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
        setPrnrRefNo(JSPUtil.getParameter(request, prefix + "prnr_ref_no", ""));
        setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
        setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConsultationConditionVO[]
	 */
    public ConsultationConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConsultationConditionVO[]
	 */
    public ConsultationConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ConsultationConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] frRevYrmon = (JSPUtil.getParameter(request, prefix + "fr_rev_yrmon", length));
            String[] toRevYrmon = (JSPUtil.getParameter(request, prefix + "to_rev_yrmon", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] joCrrCds = (JSPUtil.getParameter(request, prefix + "jo_crr_cds", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] joStlItmCds = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cds", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] acctgCrrCd = (JSPUtil.getParameter(request, prefix + "acctg_crr_cd", length));
            String[] acctgCrrCds = (JSPUtil.getParameter(request, prefix + "acctg_crr_cds", length));
            String[] frInvYrmon = (JSPUtil.getParameter(request, prefix + "fr_inv_yrmon", length));
            String[] toInvYrmon = (JSPUtil.getParameter(request, prefix + "to_inv_yrmon", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] revVvd = (JSPUtil.getParameter(request, prefix + "rev_vvd", length));
            String[] frAcctYrmon = (JSPUtil.getParameter(request, prefix + "fr_acct_yrmon", length));
            String[] toAcctYrmon = (JSPUtil.getParameter(request, prefix + "to_acct_yrmon", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] prnrRefNo = (JSPUtil.getParameter(request, prefix + "prnr_ref_no", length));
            String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix + "stl_vvd_seq", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ConsultationConditionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (frRevYrmon[i] != null)
                    model.setFrRevYrmon(frRevYrmon[i]);
                if (toRevYrmon[i] != null)
                    model.setToRevYrmon(toRevYrmon[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (joCrrCds[i] != null)
                    model.setJoCrrCds(joCrrCds[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (joStlItmCds[i] != null)
                    model.setJoStlItmCds(joStlItmCds[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (acctgCrrCd[i] != null)
                    model.setAcctgCrrCd(acctgCrrCd[i]);
                if (acctgCrrCds[i] != null)
                    model.setAcctgCrrCds(acctgCrrCds[i]);
                if (frInvYrmon[i] != null)
                    model.setFrInvYrmon(frInvYrmon[i]);
                if (toInvYrmon[i] != null)
                    model.setToInvYrmon(toInvYrmon[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (revVvd[i] != null)
                    model.setRevVvd(revVvd[i]);
                if (frAcctYrmon[i] != null)
                    model.setFrAcctYrmon(frAcctYrmon[i]);
                if (toAcctYrmon[i] != null)
                    model.setToAcctYrmon(toAcctYrmon[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (prnrRefNo[i] != null)
                    model.setPrnrRefNo(prnrRefNo[i]);
                if (stlVvdSeq[i] != null)
                    model.setStlVvdSeq(stlVvdSeq[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (authOfcCd[i] != null) 
		    		model.setAuthOfcCd(authOfcCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getConsultationConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ConsultationConditionVO[]
	 */
    public ConsultationConditionVO[] getConsultationConditionVOs() {
        ConsultationConditionVO[] vos = (ConsultationConditionVO[]) models.toArray(new ConsultationConditionVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frRevYrmon = this.frRevYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toRevYrmon = this.toRevYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCds = this.joCrrCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCds = this.joStlItmCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctgCrrCd = this.acctgCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctgCrrCds = this.acctgCrrCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frInvYrmon = this.frInvYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toInvYrmon = this.toInvYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revVvd = this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frAcctYrmon = this.frAcctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toAcctYrmon = this.toAcctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrRefNo = this.prnrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlVvdSeq = this.stlVvdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
