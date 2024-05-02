/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FinancialAffairsMtxVO.java
*@FileTitle : FinancialAffairsMtxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo;

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
public class FinancialAffairsMtxVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<FinancialAffairsMtxVO> models = new ArrayList<FinancialAffairsMtxVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String joStlItmNm = null;

    /* Column Info */
    private String drCtrCd = null;

    /* Column Info */
    private String drLocCd = null;

    /* Column Info */
    private String crCtrCd = null;

    /* Column Info */
    private String crLocCd = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String drAcctCd = null;

    /* Column Info */
    private String crAcctCd = null;

    /* Column Info */
    private String drAcctNm = null;

    /* Column Info */
    private String crAcctNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public FinancialAffairsMtxVO() {
    }

    public FinancialAffairsMtxVO(String ibflag, String pagerows, String joCrrCd, String rlaneCd, String reDivrCd, String joStlItmCd, String joStlItmNm, String drCtrCd, String drLocCd, String crCtrCd, String crLocCd, String loclCurrCd, String creDt, String creUsrId, String updDt, String updUsrId, String vndrSeq, String vndrLglEngNm, String custCd, String custCntCd, String custSeq, String custLglEngNm, String drAcctCd, String crAcctCd, String drAcctNm, String crAcctNm) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.joCrrCd = joCrrCd;
        this.rlaneCd = rlaneCd;
        this.reDivrCd = reDivrCd;
        this.joStlItmCd = joStlItmCd;
        this.joStlItmNm = joStlItmNm;
        this.drCtrCd = drCtrCd;
        this.drLocCd = drLocCd;
        this.crCtrCd = crCtrCd;
        this.crLocCd = crLocCd;
        this.loclCurrCd = loclCurrCd;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.vndrSeq = vndrSeq;
        this.vndrLglEngNm = vndrLglEngNm;
        this.custCd = custCd;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.custLglEngNm = custLglEngNm;
        this.drAcctCd = drAcctCd;
        this.crAcctCd = crAcctCd;
        this.drAcctNm = drAcctNm;
        this.crAcctNm = crAcctNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
        this.hashColumns.put("dr_ctr_cd", getDrCtrCd());
        this.hashColumns.put("dr_loc_cd", getDrLocCd());
        this.hashColumns.put("cr_ctr_cd", getCrCtrCd());
        this.hashColumns.put("cr_loc_cd", getCrLocCd());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("dr_acct_cd", getDrAcctCd());
        this.hashColumns.put("cr_acct_cd", getCrAcctCd());
        this.hashColumns.put("dr_acct_nm", getDrAcctNm());
        this.hashColumns.put("cr_acct_nm", getCrAcctNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("jo_stl_itm_nm", "joStlItmNm");
        this.hashFields.put("dr_ctr_cd", "drCtrCd");
        this.hashFields.put("dr_loc_cd", "drLocCd");
        this.hashFields.put("cr_ctr_cd", "crCtrCd");
        this.hashFields.put("cr_loc_cd", "crLocCd");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("dr_acct_cd", "drAcctCd");
        this.hashFields.put("cr_acct_cd", "crAcctCd");
        this.hashFields.put("dr_acct_nm", "drAcctNm");
        this.hashFields.put("cr_acct_nm", "crAcctNm");
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
	 * @param String joStlItmNm
	 */
    public void setJoStlItmNm(String joStlItmNm) {
        this.joStlItmNm = joStlItmNm;
    }

    /**
	 * 
	 * @return String joStlItmNm
	 */
    public String getJoStlItmNm() {
        return this.joStlItmNm;
    }

    /**
	 *
	 * @param String drCtrCd
	 */
    public void setDrCtrCd(String drCtrCd) {
        this.drCtrCd = drCtrCd;
    }

    /**
	 * 
	 * @return String drCtrCd
	 */
    public String getDrCtrCd() {
        return this.drCtrCd;
    }

    /**
	 *
	 * @param String drLocCd
	 */
    public void setDrLocCd(String drLocCd) {
        this.drLocCd = drLocCd;
    }

    /**
	 * 
	 * @return String drLocCd
	 */
    public String getDrLocCd() {
        return this.drLocCd;
    }

    /**
	 *
	 * @param String crCtrCd
	 */
    public void setCrCtrCd(String crCtrCd) {
        this.crCtrCd = crCtrCd;
    }

    /**
	 * 
	 * @return String crCtrCd
	 */
    public String getCrCtrCd() {
        return this.crCtrCd;
    }

    /**
	 *
	 * @param String crLocCd
	 */
    public void setCrLocCd(String crLocCd) {
        this.crLocCd = crLocCd;
    }

    /**
	 * 
	 * @return String crLocCd
	 */
    public String getCrLocCd() {
        return this.crLocCd;
    }

    /**
	 *
	 * @param String loclCurrCd
	 */
    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 
	 * @return String loclCurrCd
	 */
    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 *
	 * @param String vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * 
	 * @return String vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 *
	 * @param String vndrLglEngNm
	 */
    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    /**
	 * 
	 * @return String vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    /**
	 *
	 * @param String custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /**
	 * 
	 * @return String custCd
	 */
    public String getCustCd() {
        return this.custCd;
    }

    /**
	 *
	 * @param String custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * 
	 * @return String custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 *
	 * @param String custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * 
	 * @return String custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 *
	 * @param String custLglEngNm
	 */
    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    /**
	 * 
	 * @return String custLglEngNm
	 */
    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    /**
	 *
	 * @param String drAcctCd
	 */
    public void setDrAcctCd(String drAcctCd) {
        this.drAcctCd = drAcctCd;
    }

    /**
	 * 
	 * @return String drAcctCd
	 */
    public String getDrAcctCd() {
        return this.drAcctCd;
    }

    /**
	 *
	 * @param String crAcctCd
	 */
    public void setCrAcctCd(String crAcctCd) {
        this.crAcctCd = crAcctCd;
    }

    /**
	 * 
	 * @return String crAcctCd
	 */
    public String getCrAcctCd() {
        return this.crAcctCd;
    }

    public void setDrAcctNm(String drAcctNm) {
        this.drAcctNm = drAcctNm;
    }

    public String getDrAcctNm() {
        return this.drAcctNm;
    }

    public void setCrAcctNm(String crAcctNm) {
        this.crAcctNm = crAcctNm;
    }

    public String getCrAcctNm() {
        return this.crAcctNm;
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
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setJoStlItmNm(JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", ""));
        setDrCtrCd(JSPUtil.getParameter(request, prefix + "dr_ctr_cd", ""));
        setDrLocCd(JSPUtil.getParameter(request, prefix + "dr_loc_cd", ""));
        setCrCtrCd(JSPUtil.getParameter(request, prefix + "cr_ctr_cd", ""));
        setCrLocCd(JSPUtil.getParameter(request, prefix + "cr_loc_cd", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setDrAcctCd(JSPUtil.getParameter(request, prefix + "dr_acct_cd", ""));
        setCrAcctCd(JSPUtil.getParameter(request, prefix + "cr_acct_cd", ""));
        setDrAcctNm(JSPUtil.getParameter(request, prefix + "dr_acct_nm", ""));
        setCrAcctNm(JSPUtil.getParameter(request, prefix + "cr_acct_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FinancialAffairsMtxVO[]
	 */
    public FinancialAffairsMtxVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FinancialAffairsMtxVO[]
	 */
    public FinancialAffairsMtxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        FinancialAffairsMtxVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] joStlItmNm = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", length));
            String[] drCtrCd = (JSPUtil.getParameter(request, prefix + "dr_ctr_cd", length));
            String[] drLocCd = (JSPUtil.getParameter(request, prefix + "dr_loc_cd", length));
            String[] crCtrCd = (JSPUtil.getParameter(request, prefix + "cr_ctr_cd", length));
            String[] crLocCd = (JSPUtil.getParameter(request, prefix + "cr_loc_cd", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] drAcctCd = (JSPUtil.getParameter(request, prefix + "dr_acct_cd", length));
            String[] crAcctCd = (JSPUtil.getParameter(request, prefix + "cr_acct_cd", length));
            String[] drAcctNm = (JSPUtil.getParameter(request, prefix + "dr_acct_nm", length));
	    	String[] crAcctNm = (JSPUtil.getParameter(request, prefix + "cr_acct_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new FinancialAffairsMtxVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (joStlItmNm[i] != null)
                    model.setJoStlItmNm(joStlItmNm[i]);
                if (drCtrCd[i] != null)
                    model.setDrCtrCd(drCtrCd[i]);
                if (drLocCd[i] != null)
                    model.setDrLocCd(drLocCd[i]);
                if (crCtrCd[i] != null)
                    model.setCrCtrCd(crCtrCd[i]);
                if (crLocCd[i] != null)
                    model.setCrLocCd(crLocCd[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (drAcctCd[i] != null)
                    model.setDrAcctCd(drAcctCd[i]);
                if (crAcctCd[i] != null)
                    model.setCrAcctCd(crAcctCd[i]);
                if (drAcctNm[i] != null) 
		    		model.setDrAcctNm(drAcctNm[i]);
				if (crAcctNm[i] != null) 
		    		model.setCrAcctNm(crAcctNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getFinancialAffairsMtxVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return FinancialAffairsMtxVO[]
	 */
    public FinancialAffairsMtxVO[] getFinancialAffairsMtxVOs() {
        FinancialAffairsMtxVO[] vos = (FinancialAffairsMtxVO[]) models.toArray(new FinancialAffairsMtxVO[models.size()]);
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
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmNm = this.joStlItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.drCtrCd = this.drCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.drLocCd = this.drLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crCtrCd = this.crCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crLocCd = this.crLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.drAcctCd = this.drAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crAcctCd = this.crAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.drAcctNm = this.drAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crAcctNm = this.crAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
