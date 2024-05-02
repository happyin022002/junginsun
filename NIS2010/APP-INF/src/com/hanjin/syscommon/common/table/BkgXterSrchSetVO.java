/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgXterSrchSetVO.java
*@FileTitle : BkgXterSrchSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.04  
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.table;

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
public class BkgXterSrchSetVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgXterSrchSetVO> models = new ArrayList<BkgXterSrchSetVO>();

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String hndlOfcCd = null;

    /* Column Info */
    private String xterBkgRqstStsCd = null;

    /* Column Info */
    private String bkgUpldStsCd = null;

    /* Column Info */
    private String docTpCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String lane = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String chnAgnCd = null;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String xterRqstViaCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String setSubSeq = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String ediId = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String orgCntCd = null;

    /* Column Info */
    private String delContiCd = null;

    /* Column Info */
    private String setSlctFlg = null;

    /* Column Info */
    private String nonRtStsCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgXterSrchSetVO() {
    }

    public BkgXterSrchSetVO(String ibflag, String pagerows, String updDt, String setSubSeq, String custNm, String creDt, String custSeq, String srepCd, String docTpCd, String bkgUpldStsCd, String xterBkgRqstStsCd, String hndlOfcCd, String creUsrId, String orgCntCd, String usrId, String delContiCd, String setSlctFlg, String bkgCustTpCd, String updUsrId, String xterRqstViaCd, String custCntCd, String chnAgnCd, String lane, String ediId, String polCd, String nonRtStsCd) {
        this.custNm = custNm;
        this.creDt = creDt;
        this.srepCd = srepCd;
        this.hndlOfcCd = hndlOfcCd;
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
        this.bkgUpldStsCd = bkgUpldStsCd;
        this.docTpCd = docTpCd;
        this.pagerows = pagerows;
        this.lane = lane;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.usrId = usrId;
        this.chnAgnCd = chnAgnCd;
        this.bkgCustTpCd = bkgCustTpCd;
        this.updUsrId = updUsrId;
        this.xterRqstViaCd = xterRqstViaCd;
        this.custCntCd = custCntCd;
        this.setSubSeq = setSubSeq;
        this.updDt = updDt;
        this.custSeq = custSeq;
        this.ediId = ediId;
        this.creUsrId = creUsrId;
        this.orgCntCd = orgCntCd;
        this.delContiCd = delContiCd;
        this.setSlctFlg = setSlctFlg;
        this.nonRtStsCd = nonRtStsCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
        this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("lane", getLane());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("chn_agn_cd", getChnAgnCd());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("set_sub_seq", getSetSubSeq());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("edi_id", getEdiId());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("org_cnt_cd", getOrgCntCd());
        this.hashColumns.put("del_conti_cd", getDelContiCd());
        this.hashColumns.put("set_slct_flg", getSetSlctFlg());
        this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
        this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("lane", "lane");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("chn_agn_cd", "chnAgnCd");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("set_sub_seq", "setSubSeq");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("edi_id", "ediId");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("org_cnt_cd", "orgCntCd");
        this.hashFields.put("del_conti_cd", "delContiCd");
        this.hashFields.put("set_slct_flg", "setSlctFlg");
        this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
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
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 * Column Info
	 * @return hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
    }

    /**
	 * Column Info
	 * @return xterBkgRqstStsCd
	 */
    public String getXterBkgRqstStsCd() {
        return this.xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @return bkgUpldStsCd
	 */
    public String getBkgUpldStsCd() {
        return this.bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @return docTpCd
	 */
    public String getDocTpCd() {
        return this.docTpCd;
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
	 * @return lane
	 */
    public String getLane() {
        return this.lane;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return chnAgnCd
	 */
    public String getChnAgnCd() {
        return this.chnAgnCd;
    }

    /**
	 * Column Info
	 * @return bkgCustTpCd
	 */
    public String getBkgCustTpCd() {
        return this.bkgCustTpCd;
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
	 * @return xterRqstViaCd
	 */
    public String getXterRqstViaCd() {
        return this.xterRqstViaCd;
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
	 * @return setSubSeq
	 */
    public String getSetSubSeq() {
        return this.setSubSeq;
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
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return ediId
	 */
    public String getEdiId() {
        return this.ediId;
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
	 * @return orgCntCd
	 */
    public String getOrgCntCd() {
        return this.orgCntCd;
    }

    /**
	 * Column Info
	 * @return delContiCd
	 */
    public String getDelContiCd() {
        return this.delContiCd;
    }

    /**
	 * Column Info
	 * @return setSlctFlg
	 */
    public String getSetSlctFlg() {
        return this.setSlctFlg;
    }

    /**
	 * Column Info
	 * @param custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
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
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * Column Info
	 * @param hndlOfcCd
	 */
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
    }

    /**
	 * Column Info
	 * @param xterBkgRqstStsCd
	 */
    public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @param bkgUpldStsCd
	 */
    public void setBkgUpldStsCd(String bkgUpldStsCd) {
        this.bkgUpldStsCd = bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @param docTpCd
	 */
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
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
	 * @param lane
	 */
    public void setLane(String lane) {
        this.lane = lane;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param chnAgnCd
	 */
    public void setChnAgnCd(String chnAgnCd) {
        this.chnAgnCd = chnAgnCd;
    }

    /**
	 * Column Info
	 * @param bkgCustTpCd
	 */
    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
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
	 * @param xterRqstViaCd
	 */
    public void setXterRqstViaCd(String xterRqstViaCd) {
        this.xterRqstViaCd = xterRqstViaCd;
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
	 * @param setSubSeq
	 */
    public void setSetSubSeq(String setSubSeq) {
        this.setSubSeq = setSubSeq;
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
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param ediId
	 */
    public void setEdiId(String ediId) {
        this.ediId = ediId;
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
	 * @param orgCntCd
	 */
    public void setOrgCntCd(String orgCntCd) {
        this.orgCntCd = orgCntCd;
    }

    /**
	 * Column Info
	 * @param delContiCd
	 */
    public void setDelContiCd(String delContiCd) {
        this.delContiCd = delContiCd;
    }

    /**
	 * Column Info
	 * @param setSlctFlg
	 */
    public void setSetSlctFlg(String setSlctFlg) {
        this.setSlctFlg = setSlctFlg;
    }

    public void setNonRtStsCd(String nonRtStsCd) {
        this.nonRtStsCd = nonRtStsCd;
    }

    public String getNonRtStsCd() {
        return this.nonRtStsCd;
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
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
        setXterBkgRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", ""));
        setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setSetSubSeq(JSPUtil.getParameter(request, prefix + "set_sub_seq", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setOrgCntCd(JSPUtil.getParameter(request, prefix + "org_cnt_cd", ""));
        setDelContiCd(JSPUtil.getParameter(request, prefix + "del_conti_cd", ""));
        setSetSlctFlg(JSPUtil.getParameter(request, prefix + "set_slct_flg", ""));
        setNonRtStsCd(JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterSrchSetVO[]
	 */
    public BkgXterSrchSetVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterSrchSetVO[]
	 */
    public BkgXterSrchSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgXterSrchSetVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", length));
            String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", length));
            String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] chnAgnCd = (JSPUtil.getParameter(request, prefix + "chn_agn_cd", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] setSubSeq = (JSPUtil.getParameter(request, prefix + "set_sub_seq", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] ediId = (JSPUtil.getParameter(request, prefix + "edi_id", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] orgCntCd = (JSPUtil.getParameter(request, prefix + "org_cnt_cd", length));
            String[] delContiCd = (JSPUtil.getParameter(request, prefix + "del_conti_cd", length));
            String[] setSlctFlg = (JSPUtil.getParameter(request, prefix + "set_slct_flg", length));
            String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgXterSrchSetVO();
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (xterBkgRqstStsCd[i] != null)
                    model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
                if (bkgUpldStsCd[i] != null)
                    model.setBkgUpldStsCd(bkgUpldStsCd[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (lane[i] != null)
                    model.setLane(lane[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (chnAgnCd[i] != null)
                    model.setChnAgnCd(chnAgnCd[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (xterRqstViaCd[i] != null)
                    model.setXterRqstViaCd(xterRqstViaCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (setSubSeq[i] != null)
                    model.setSetSubSeq(setSubSeq[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (ediId[i] != null)
                    model.setEdiId(ediId[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (orgCntCd[i] != null)
                    model.setOrgCntCd(orgCntCd[i]);
                if (delContiCd[i] != null)
                    model.setDelContiCd(delContiCd[i]);
                if (setSlctFlg[i] != null)
                    model.setSetSlctFlg(setSlctFlg[i]);
                if (nonRtStsCd[i] != null) 
		    		model.setNonRtStsCd(nonRtStsCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgXterSrchSetVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgXterSrchSetVO[]
	 */
    public BkgXterSrchSetVO[] getBkgXterSrchSetVOs() {
        BkgXterSrchSetVO[] vos = (BkgXterSrchSetVO[]) models.toArray(new BkgXterSrchSetVO[models.size()]);
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
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstStsCd = this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsCd = this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chnAgnCd = this.chnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaCd = this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.setSubSeq = this.setSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediId = this.ediId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgCntCd = this.orgCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delContiCd = this.delContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.setSlctFlg = this.setSlctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonRtStsCd = this.nonRtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
