/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRgArbVO.java
*@FileTitle : RsltPriRgArbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.16 김재연 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo;

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
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RsltPriRgArbVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<RsltPriRgArbVO> models = new ArrayList<RsltPriRgArbVO>();

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String prcCgoTpCd = null;

    /* Column Info */
    private String locDes = null;

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String orgDestTpCd = null;

    /* Column Info */
    private String routPntLocDefCd = null;

    /* Column Info */
    private String glineSeq = null;

    /* Column Info */
    private String ratUtCd = null;

    /* Column Info */
    private String bsePortDefCd = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String arbSeq = null;

    /* Column Info */
    private String minCgoWgt = null;

    /* Column Info */
    private String bsePortTpCd = null;

    /* Column Info */
    private String frtRtAmt = null;

    /* Column Info */
    private String termOrd = null;

    /* Column Info */
    private String prcTrspModCd = null;

    /* Column Info */
    private String rcvDeTermCd = null;

    /* Column Info */
    private String transOrd = null;

    /* Column Info */
    private String maxCgoWgt = null;

    /* Column Info */
    private String routPntLocTpCd = null;

    /* Column Info */
    private String ficGlineRtAmt = null;

    /* Column Info */
    private String ficGlineUpdDt = null;

    /* Column Info */
    private String optmTrspModFlg = null;

    /* Column Info */
    private String ficRoutCmbTpCd = null;

    /* Column Info */
    private String ficRtUseStsCd = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String basePortList = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public RsltPriRgArbVO() {
    }

    public RsltPriRgArbVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String orgDestTpCd, String arbSeq, String locDes, String routPntLocTpCd, String routPntLocDefCd, String bsePortTpCd, String bsePortDefCd, String ratUtCd, String prcCgoTpCd, String prcTrspModCd, String rcvDeTermCd, String minCgoWgt, String maxCgoWgt, String currCd, String frtRtAmt, String termOrd, String transOrd, String ficGlineRtAmt, String ficGlineUpdDt, String optmTrspModFlg, String ficRoutCmbTpCd, String ficRtUseStsCd, String effDt, String basePortList) {
        this.currCd = currCd;
        this.prcCgoTpCd = prcCgoTpCd;
        this.locDes = locDes;
        this.svcScpCd = svcScpCd;
        this.orgDestTpCd = orgDestTpCd;
        this.routPntLocDefCd = routPntLocDefCd;
        this.glineSeq = glineSeq;
        this.ratUtCd = ratUtCd;
        this.bsePortDefCd = bsePortDefCd;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.arbSeq = arbSeq;
        this.minCgoWgt = minCgoWgt;
        this.bsePortTpCd = bsePortTpCd;
        this.frtRtAmt = frtRtAmt;
        this.termOrd = termOrd;
        this.prcTrspModCd = prcTrspModCd;
        this.rcvDeTermCd = rcvDeTermCd;
        this.transOrd = transOrd;
        this.maxCgoWgt = maxCgoWgt;
        this.routPntLocTpCd = routPntLocTpCd;
        this.ficGlineRtAmt = ficGlineRtAmt;
        this.ficGlineUpdDt = ficGlineUpdDt;
        this.optmTrspModFlg = optmTrspModFlg;
        this.ficRoutCmbTpCd = ficRoutCmbTpCd;
        this.ficRtUseStsCd = ficRtUseStsCd;
        this.effDt = effDt;
        this.basePortList = basePortList;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
        this.hashColumns.put("loc_des", getLocDes());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
        this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
        this.hashColumns.put("gline_seq", getGlineSeq());
        this.hashColumns.put("rat_ut_cd", getRatUtCd());
        this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("arb_seq", getArbSeq());
        this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
        this.hashColumns.put("bse_port_tp_cd", getBsePortTpCd());
        this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
        this.hashColumns.put("term_ord", getTermOrd());
        this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
        this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
        this.hashColumns.put("trans_ord", getTransOrd());
        this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
        this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
        this.hashColumns.put("fic_gline_rt_amt", getFicGlineRtAmt());
        this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
        this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
        this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
        this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("base_port_list", getBasePortList());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
        this.hashFields.put("loc_des", "locDes");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
        this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
        this.hashFields.put("gline_seq", "glineSeq");
        this.hashFields.put("rat_ut_cd", "ratUtCd");
        this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("arb_seq", "arbSeq");
        this.hashFields.put("min_cgo_wgt", "minCgoWgt");
        this.hashFields.put("bse_port_tp_cd", "bsePortTpCd");
        this.hashFields.put("frt_rt_amt", "frtRtAmt");
        this.hashFields.put("term_ord", "termOrd");
        this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
        this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
        this.hashFields.put("trans_ord", "transOrd");
        this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
        this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
        this.hashFields.put("fic_gline_rt_amt", "ficGlineRtAmt");
        this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
        this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
        this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
        this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("base_port_list", "basePortList");
        return this.hashFields;
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
	 * @return locDes
	 */
    public String getLocDes() {
        return this.locDes;
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
	 * @return orgDestTpCd
	 */
    public String getOrgDestTpCd() {
        return this.orgDestTpCd;
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
	 * @return glineSeq
	 */
    public String getGlineSeq() {
        return this.glineSeq;
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
	 * @return bsePortDefCd
	 */
    public String getBsePortDefCd() {
        return this.bsePortDefCd;
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
	 * @return arbSeq
	 */
    public String getArbSeq() {
        return this.arbSeq;
    }

    /**
	 * Column Info
	 * @return minCgoWgt
	 */
    public String getMinCgoWgt() {
        return this.minCgoWgt;
    }

    /**
	 * Column Info
	 * @return bsePortTpCd
	 */
    public String getBsePortTpCd() {
        return this.bsePortTpCd;
    }

    /**
	 * Column Info
	 * @return frtRtAmt
	 */
    public String getFrtRtAmt() {
        return this.frtRtAmt;
    }

    /**
	 * Column Info
	 * @return termOrd
	 */
    public String getTermOrd() {
        return this.termOrd;
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
	 * @return rcvDeTermCd
	 */
    public String getRcvDeTermCd() {
        return this.rcvDeTermCd;
    }

    /**
	 * Column Info
	 * @return transOrd
	 */
    public String getTransOrd() {
        return this.transOrd;
    }

    /**
	 * Column Info
	 * @return maxCgoWgt
	 */
    public String getMaxCgoWgt() {
        return this.maxCgoWgt;
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
	 * @param locDes
	 */
    public void setLocDes(String locDes) {
        this.locDes = locDes;
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
	 * @param orgDestTpCd
	 */
    public void setOrgDestTpCd(String orgDestTpCd) {
        this.orgDestTpCd = orgDestTpCd;
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
	 * @param glineSeq
	 */
    public void setGlineSeq(String glineSeq) {
        this.glineSeq = glineSeq;
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
	 * @param bsePortDefCd
	 */
    public void setBsePortDefCd(String bsePortDefCd) {
        this.bsePortDefCd = bsePortDefCd;
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
	 * @param arbSeq
	 */
    public void setArbSeq(String arbSeq) {
        this.arbSeq = arbSeq;
    }

    /**
	 * Column Info
	 * @param minCgoWgt
	 */
    public void setMinCgoWgt(String minCgoWgt) {
        this.minCgoWgt = minCgoWgt;
    }

    /**
	 * Column Info
	 * @param bsePortTpCd
	 */
    public void setBsePortTpCd(String bsePortTpCd) {
        this.bsePortTpCd = bsePortTpCd;
    }

    /**
	 * Column Info
	 * @param frtRtAmt
	 */
    public void setFrtRtAmt(String frtRtAmt) {
        this.frtRtAmt = frtRtAmt;
    }

    /**
	 * Column Info
	 * @param termOrd
	 */
    public void setTermOrd(String termOrd) {
        this.termOrd = termOrd;
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
	 * @param rcvDeTermCd
	 */
    public void setRcvDeTermCd(String rcvDeTermCd) {
        this.rcvDeTermCd = rcvDeTermCd;
    }

    /**
	 * Column Info
	 * @param transOrd
	 */
    public void setTransOrd(String transOrd) {
        this.transOrd = transOrd;
    }

    /**
	 * Column Info
	 * @param maxCgoWgt
	 */
    public void setMaxCgoWgt(String maxCgoWgt) {
        this.maxCgoWgt = maxCgoWgt;
    }

    /**
	 * Column Info
	 * @param routPntLocTpCd
	 */
    public void setRoutPntLocTpCd(String routPntLocTpCd) {
        this.routPntLocTpCd = routPntLocTpCd;
    }

    public void setFicGlineRtAmt(String ficGlineRtAmt) {
        this.ficGlineRtAmt = ficGlineRtAmt;
    }

    public String getFicGlineRtAmt() {
        return this.ficGlineRtAmt;
    }

    public void setFicGlineUpdDt(String ficGlineUpdDt) {
        this.ficGlineUpdDt = ficGlineUpdDt;
    }

    public String getFicGlineUpdDt() {
        return this.ficGlineUpdDt;
    }

    public void setOptmTrspModFlg(String optmTrspModFlg) {
        this.optmTrspModFlg = optmTrspModFlg;
    }

    public String getOptmTrspModFlg() {
        return this.optmTrspModFlg;
    }

    public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
        this.ficRoutCmbTpCd = ficRoutCmbTpCd;
    }

    public String getFicRoutCmbTpCd() {
        return this.ficRoutCmbTpCd;
    }

    public void setFicRtUseStsCd(String ficRtUseStsCd) {
        this.ficRtUseStsCd = ficRtUseStsCd;
    }

    public String getFicRtUseStsCd() {
        return this.ficRtUseStsCd;
    }

    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    public String getEffDt() {
        return this.effDt;
    }

    public void setBasePortList(String basePortList) {
        this.basePortList = basePortList;
    }

    public String getBasePortList() {
        return this.basePortList;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
        setLocDes(JSPUtil.getParameter(request, "loc_des", ""));
        setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
        setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
        setRoutPntLocDefCd(JSPUtil.getParameter(request, "rout_pnt_loc_def_cd", ""));
        setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
        setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
        setBsePortDefCd(JSPUtil.getParameter(request, "bse_port_def_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setArbSeq(JSPUtil.getParameter(request, "arb_seq", ""));
        setMinCgoWgt(JSPUtil.getParameter(request, "min_cgo_wgt", ""));
        setBsePortTpCd(JSPUtil.getParameter(request, "bse_port_tp_cd", ""));
        setFrtRtAmt(JSPUtil.getParameter(request, "frt_rt_amt", ""));
        setTermOrd(JSPUtil.getParameter(request, "term_ord", ""));
        setPrcTrspModCd(JSPUtil.getParameter(request, "prc_trsp_mod_cd", ""));
        setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
        setTransOrd(JSPUtil.getParameter(request, "trans_ord", ""));
        setMaxCgoWgt(JSPUtil.getParameter(request, "max_cgo_wgt", ""));
        setRoutPntLocTpCd(JSPUtil.getParameter(request, "rout_pnt_loc_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRgArbVO[]
	 */
    public RsltPriRgArbVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRgArbVO[]
	 */
    public RsltPriRgArbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        RsltPriRgArbVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", length));
            String[] locDes = (JSPUtil.getParameter(request, prefix + "loc_des", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", length));
            String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", length));
            String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq", length));
            String[] ratUtCd = (JSPUtil.getParameter(request, prefix + "rat_ut_cd", length));
            String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix + "bse_port_def_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] arbSeq = (JSPUtil.getParameter(request, prefix + "arb_seq", length));
            String[] minCgoWgt = (JSPUtil.getParameter(request, prefix + "min_cgo_wgt", length));
            String[] bsePortTpCd = (JSPUtil.getParameter(request, prefix + "bse_port_tp_cd", length));
            String[] frtRtAmt = (JSPUtil.getParameter(request, prefix + "frt_rt_amt", length));
            String[] termOrd = (JSPUtil.getParameter(request, prefix + "term_ord", length));
            String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", length));
            String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", length));
            String[] transOrd = (JSPUtil.getParameter(request, prefix + "trans_ord", length));
            String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix + "max_cgo_wgt", length));
            String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix + "rout_pnt_loc_tp_cd", length));
            String[] ficGlineRtAmt = (JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", length));
	    	String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", length));
	    	String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", length));
	    	String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", length));
	    	String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", length));
	    	String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
	    	String[] basePortList = (JSPUtil.getParameter(request, prefix + "base_port_list", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new RsltPriRgArbVO();
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (prcCgoTpCd[i] != null)
                    model.setPrcCgoTpCd(prcCgoTpCd[i]);
                if (locDes[i] != null)
                    model.setLocDes(locDes[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (orgDestTpCd[i] != null)
                    model.setOrgDestTpCd(orgDestTpCd[i]);
                if (routPntLocDefCd[i] != null)
                    model.setRoutPntLocDefCd(routPntLocDefCd[i]);
                if (glineSeq[i] != null)
                    model.setGlineSeq(glineSeq[i]);
                if (ratUtCd[i] != null)
                    model.setRatUtCd(ratUtCd[i]);
                if (bsePortDefCd[i] != null)
                    model.setBsePortDefCd(bsePortDefCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (arbSeq[i] != null)
                    model.setArbSeq(arbSeq[i]);
                if (minCgoWgt[i] != null)
                    model.setMinCgoWgt(minCgoWgt[i]);
                if (bsePortTpCd[i] != null)
                    model.setBsePortTpCd(bsePortTpCd[i]);
                if (frtRtAmt[i] != null)
                    model.setFrtRtAmt(frtRtAmt[i]);
                if (termOrd[i] != null)
                    model.setTermOrd(termOrd[i]);
                if (prcTrspModCd[i] != null)
                    model.setPrcTrspModCd(prcTrspModCd[i]);
                if (rcvDeTermCd[i] != null)
                    model.setRcvDeTermCd(rcvDeTermCd[i]);
                if (transOrd[i] != null)
                    model.setTransOrd(transOrd[i]);
                if (maxCgoWgt[i] != null)
                    model.setMaxCgoWgt(maxCgoWgt[i]);
                if (routPntLocTpCd[i] != null)
                    model.setRoutPntLocTpCd(routPntLocTpCd[i]);
                if (ficGlineRtAmt[i] != null) 
		    		model.setFicGlineRtAmt(ficGlineRtAmt[i]);
				if (ficGlineUpdDt[i] != null) 
		    		model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (optmTrspModFlg[i] != null) 
		    		model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (ficRoutCmbTpCd[i] != null) 
		    		model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (ficRtUseStsCd[i] != null) 
		    		model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (effDt[i] != null) 
		    		model.setEffDt(effDt[i]);
				if (basePortList[i] != null) 
		    		model.setBasePortList(basePortList[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getRsltPriRgArbVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return RsltPriRgArbVO[]
	 */
    public RsltPriRgArbVO[] getRsltPriRgArbVOs() {
        RsltPriRgArbVO[] vos = (RsltPriRgArbVO[]) models.toArray(new RsltPriRgArbVO[models.size()]);
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
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcCgoTpCd = this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locDes = this.locDes.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestTpCd = this.orgDestTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.routPntLocDefCd = this.routPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratUtCd = this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsePortDefCd = this.bsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arbSeq = this.arbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.minCgoWgt = this.minCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsePortTpCd = this.bsePortTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtRtAmt = this.frtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.termOrd = this.termOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcTrspModCd = this.prcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvDeTermCd = this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.transOrd = this.transOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxCgoWgt = this.maxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.routPntLocTpCd = this.routPntLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ficGlineRtAmt = this.ficGlineRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ficGlineUpdDt = this.ficGlineUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.optmTrspModFlg = this.optmTrspModFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ficRoutCmbTpCd = this.ficRoutCmbTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ficRtUseStsCd = this.ficRtUseStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.basePortList = this.basePortList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
