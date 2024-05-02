/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchArSlipDetailListVO.java
*@FileTitle : SearchArSlipDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.16 윤세영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchArSlipDetailListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchArSlipDetailListVO> models = new ArrayList<SearchArSlipDetailListVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String slpFuncCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String toIfNo = null;

    /* Column Info */
    private String fletIssTpCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String revDirCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String invDesc = null;

    /* Column Info */
    private String slpTpCd = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String dueDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String slpIssDt = null;

    /* Column Info */
    private String slpOfcCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String invDescEnc = null;

    /* Column Info */
    private String slpSerNo = null;

    /* Column Info */
    private String slpLocCd = null;

    /* Column Info */
    private String invSeq = null;

    /* Column Info */
    private String invDtlSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchArSlipDetailListVO() {
    }

    public SearchArSlipDetailListVO(String ibflag, String pagerows, String fletCtrtNo, String fletIssTpCd, String blNo, String toIfNo, String invNo, String custCntCd, String custSeq, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpLocCd, String effDt, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String dueDt, String invAmt, String invDesc, String invDescEnc, String currCd, String updUsrId, String invSeq, String invDtlSeq) {
        this.vslCd = vslCd;
        this.slpFuncCd = slpFuncCd;
        this.currCd = currCd;
        this.toIfNo = toIfNo;
        this.fletIssTpCd = fletIssTpCd;
        this.blNo = blNo;
        this.fletCtrtNo = fletCtrtNo;
        this.pagerows = pagerows;
        this.revDirCd = revDirCd;
        this.ibflag = ibflag;
        this.effDt = effDt;
        this.invDesc = invDesc;
        this.slpTpCd = slpTpCd;
        this.invAmt = invAmt;
        this.dueDt = dueDt;
        this.updUsrId = updUsrId;
        this.custCntCd = custCntCd;
        this.skdVoyNo = skdVoyNo;
        this.custSeq = custSeq;
        this.slpIssDt = slpIssDt;
        this.slpOfcCd = slpOfcCd;
        this.skdDirCd = skdDirCd;
        this.invNo = invNo;
        this.invDescEnc = invDescEnc;
        this.slpSerNo = slpSerNo;
        this.slpLocCd = slpLocCd;
        this.invSeq = invSeq;
        this.invDtlSeq = invDtlSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("slp_func_cd", getSlpFuncCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("to_if_no", getToIfNo());
        this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("inv_desc", getInvDesc());
        this.hashColumns.put("slp_tp_cd", getSlpTpCd());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("due_dt", getDueDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("slp_iss_dt", getSlpIssDt());
        this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("inv_desc_enc", getInvDescEnc());
        this.hashColumns.put("slp_ser_no", getSlpSerNo());
        this.hashColumns.put("slp_loc_cd", getSlpLocCd());
        this.hashColumns.put("inv_seq", getInvSeq());
        this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("slp_func_cd", "slpFuncCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("to_if_no", "toIfNo");
        this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("inv_desc", "invDesc");
        this.hashFields.put("slp_tp_cd", "slpTpCd");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("due_dt", "dueDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("slp_iss_dt", "slpIssDt");
        this.hashFields.put("slp_ofc_cd", "slpOfcCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("inv_desc_enc", "invDescEnc");
        this.hashFields.put("slp_ser_no", "slpSerNo");
        this.hashFields.put("slp_loc_cd", "slpLocCd");
        this.hashFields.put("inv_seq", "invSeq");
        this.hashFields.put("inv_dtl_seq", "invDtlSeq");
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
	 * @return slpFuncCd
	 */
    public String getSlpFuncCd() {
        return this.slpFuncCd;
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
	 * @return toIfNo
	 */
    public String getToIfNo() {
        return this.toIfNo;
    }

    /**
	 * Column Info
	 * @return fletIssTpCd
	 */
    public String getFletIssTpCd() {
        return this.fletIssTpCd;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return fletCtrtNo
	 */
    public String getFletCtrtNo() {
        return this.fletCtrtNo;
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
	 * @return revDirCd
	 */
    public String getRevDirCd() {
        return this.revDirCd;
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
	 * @return invDesc
	 */
    public String getInvDesc() {
        return this.invDesc;
    }

    /**
	 * Column Info
	 * @return slpTpCd
	 */
    public String getSlpTpCd() {
        return this.slpTpCd;
    }

    /**
	 * Column Info
	 * @return invAmt
	 */
    public String getInvAmt() {
        return this.invAmt;
    }

    /**
	 * Column Info
	 * @return dueDt
	 */
    public String getDueDt() {
        return this.dueDt;
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
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
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
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return slpIssDt
	 */
    public String getSlpIssDt() {
        return this.slpIssDt;
    }

    /**
	 * Column Info
	 * @return slpOfcCd
	 */
    public String getSlpOfcCd() {
        return this.slpOfcCd;
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
	 * @return invDescEnc
	 */
    public String getInvDescEnc() {
        return this.invDescEnc;
    }

    /**
	 * Column Info
	 * @return slpSerNo
	 */
    public String getSlpSerNo() {
        return this.slpSerNo;
    }

    /**
	 * Column Info
	 * @return slpLocCd
	 */
    public String getSlpLocCd() {
        return this.slpLocCd;
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
	 * @param slpFuncCd
	 */
    public void setSlpFuncCd(String slpFuncCd) {
        this.slpFuncCd = slpFuncCd;
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
	 * @param toIfNo
	 */
    public void setToIfNo(String toIfNo) {
        this.toIfNo = toIfNo;
    }

    /**
	 * Column Info
	 * @param fletIssTpCd
	 */
    public void setFletIssTpCd(String fletIssTpCd) {
        this.fletIssTpCd = fletIssTpCd;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param fletCtrtNo
	 */
    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
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
	 * @param revDirCd
	 */
    public void setRevDirCd(String revDirCd) {
        this.revDirCd = revDirCd;
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
	 * @param invDesc
	 */
    public void setInvDesc(String invDesc) {
        this.invDesc = invDesc;
    }

    /**
	 * Column Info
	 * @param slpTpCd
	 */
    public void setSlpTpCd(String slpTpCd) {
        this.slpTpCd = slpTpCd;
    }

    /**
	 * Column Info
	 * @param invAmt
	 */
    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    /**
	 * Column Info
	 * @param dueDt
	 */
    public void setDueDt(String dueDt) {
        this.dueDt = dueDt;
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
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
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
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param slpIssDt
	 */
    public void setSlpIssDt(String slpIssDt) {
        this.slpIssDt = slpIssDt;
    }

    /**
	 * Column Info
	 * @param slpOfcCd
	 */
    public void setSlpOfcCd(String slpOfcCd) {
        this.slpOfcCd = slpOfcCd;
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
	 * @param invDescEnc
	 */
    public void setInvDescEnc(String invDescEnc) {
        this.invDescEnc = invDescEnc;
    }

    /**
	 * Column Info
	 * @param slpSerNo
	 */
    public void setSlpSerNo(String slpSerNo) {
        this.slpSerNo = slpSerNo;
    }

    /**
	 * Column Info
	 * @param slpLocCd
	 */
    public void setSlpLocCd(String slpLocCd) {
        this.slpLocCd = slpLocCd;
    }

    public void setInvSeq(String invSeq) {
        this.invSeq = invSeq;
    }

    public String getInvSeq() {
        return this.invSeq;
    }

    public void setInvDtlSeq(String invDtlSeq) {
        this.invDtlSeq = invDtlSeq;
    }

    public String getInvDtlSeq() {
        return this.invDtlSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setToIfNo(JSPUtil.getParameter(request, "to_if_no", ""));
        setFletIssTpCd(JSPUtil.getParameter(request, "flet_iss_tp_cd", ""));
        setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
        setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
        setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
        setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
        setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
        setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
        setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
        setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
        setInvDescEnc(JSPUtil.getParameter(request, "inv_desc_enc", ""));
        setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
        setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
        setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
        setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchArSlipDetailListVO[]
	 */
    public SearchArSlipDetailListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchArSlipDetailListVO[]
	 */
    public SearchArSlipDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchArSlipDetailListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] slpFuncCd = (JSPUtil.getParameter(request, prefix + "slp_func_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] toIfNo = (JSPUtil.getParameter(request, prefix + "to_if_no", length));
            String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix + "flet_iss_tp_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] invDesc = (JSPUtil.getParameter(request, prefix + "inv_desc", length));
            String[] slpTpCd = (JSPUtil.getParameter(request, prefix + "slp_tp_cd", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] dueDt = (JSPUtil.getParameter(request, prefix + "due_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] slpIssDt = (JSPUtil.getParameter(request, prefix + "slp_iss_dt", length));
            String[] slpOfcCd = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] invDescEnc = (JSPUtil.getParameter(request, prefix + "inv_desc_enc", length));
            String[] slpSerNo = (JSPUtil.getParameter(request, prefix + "slp_ser_no", length));
            String[] slpLocCd = (JSPUtil.getParameter(request, prefix + "slp_loc_cd", length));
            String[] invSeq = (JSPUtil.getParameter(request, prefix + "inv_seq", length));
	    	String[] invDtlSeq = (JSPUtil.getParameter(request, prefix + "inv_dtl_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchArSlipDetailListVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (slpFuncCd[i] != null)
                    model.setSlpFuncCd(slpFuncCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (toIfNo[i] != null)
                    model.setToIfNo(toIfNo[i]);
                if (fletIssTpCd[i] != null)
                    model.setFletIssTpCd(fletIssTpCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (invDesc[i] != null)
                    model.setInvDesc(invDesc[i]);
                if (slpTpCd[i] != null)
                    model.setSlpTpCd(slpTpCd[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (dueDt[i] != null)
                    model.setDueDt(dueDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (slpIssDt[i] != null)
                    model.setSlpIssDt(slpIssDt[i]);
                if (slpOfcCd[i] != null)
                    model.setSlpOfcCd(slpOfcCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (invDescEnc[i] != null)
                    model.setInvDescEnc(invDescEnc[i]);
                if (slpSerNo[i] != null)
                    model.setSlpSerNo(slpSerNo[i]);
                if (slpLocCd[i] != null)
                    model.setSlpLocCd(slpLocCd[i]);
                if (invSeq[i] != null) 
		    		model.setInvSeq(invSeq[i]);
				if (invDtlSeq[i] != null) 
		    		model.setInvDtlSeq(invDtlSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchArSlipDetailListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchArSlipDetailListVO[]
	 */
    public SearchArSlipDetailListVO[] getSearchArSlipDetailListVOs() {
        SearchArSlipDetailListVO[] vos = (SearchArSlipDetailListVO[]) models.toArray(new SearchArSlipDetailListVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
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
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpFuncCd = this.slpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toIfNo = this.toIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletIssTpCd = this.fletIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDesc = this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpTpCd = this.slpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dueDt = this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpIssDt = this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd = this.slpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDescEnc = this.invDescEnc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpSerNo = this.slpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpLocCd = this.slpLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invSeq = this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDtlSeq = this.invDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
