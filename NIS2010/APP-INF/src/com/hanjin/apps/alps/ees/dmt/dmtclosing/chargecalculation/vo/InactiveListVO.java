/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InactiveListVO.java
*@FileTitle : InactiveListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.21  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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
public class InactiveListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InactiveListVO> models = new ArrayList<InactiveListVO>();

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String bbgDt = null;

    /* Column Info */
    private String chgDeltUsrYn = null;

    /* Column Info */
    private String hdoNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String stsCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rhqNm = null;

    /* Column Info */
    private String inactRqstNo = null;

    /* Column Info */
    private String rhqDt = null;

    /* Column Info */
    private String rqstNm = null;

    /* Column Info */
    private String hdoDt = null;

    /* Column Info */
    private String inactivInfo = null;

    /* Column Info */
    private String inactAproNo = null;

    /* Column Info */
    private String bbgNm = null;

    /* Column Info */
    private String dmdtDeltRqstStsCd = null;

    /* Column Info */
    private String inactRsn = null;

    /* Column Info */
    private String specRsn = null;

    /* Column Info */
    private String rqstOfc = null;

    /* Column Info */
    private String bbgOfc = null;

    /* Column Info */
    private String rhqOfc = null;

    /* Column Info */
    private String hdoOfc = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String ovrDys = null;

    /* Column Info */
    private String rqstOfcFlg = null;

    /* Column Info */
    private String oomDt = null;

    /* Column Info */
    private String oomOfc = null;

    /* Column Info */
    private String oomNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public InactiveListVO() {
    }

    public InactiveListVO(String ibflag, String pagerows, String inactRqstNo, String inactAproNo, String dmdtDeltRqstStsCd, String stsCd, String rqstDt, String rqstNm, String bbgDt, String bbgNm, String rhqDt, String rhqNm, String hdoDt, String hdoNm, String inactivInfo, String chgDeltUsrYn, String inactRsn, String specRsn, String rqstOfc, String bbgOfc, String rhqOfc, String hdoOfc, String bkgNo, String cntrNo, String ovrDys, String rqstOfcFlg, String oomDt, String oomOfc, String oomNm) {
        this.rqstDt = rqstDt;
        this.bbgDt = bbgDt;
        this.chgDeltUsrYn = chgDeltUsrYn;
        this.hdoNm = hdoNm;
        this.pagerows = pagerows;
        this.stsCd = stsCd;
        this.ibflag = ibflag;
        this.rhqNm = rhqNm;
        this.inactRqstNo = inactRqstNo;
        this.rhqDt = rhqDt;
        this.rqstNm = rqstNm;
        this.hdoDt = hdoDt;
        this.inactivInfo = inactivInfo;
        this.inactAproNo = inactAproNo;
        this.bbgNm = bbgNm;
        this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
        this.inactRsn = inactRsn;
        this.specRsn = specRsn;
        this.rqstOfc = rqstOfc;
        this.bbgOfc = bbgOfc;
        this.rhqOfc = rhqOfc;
        this.hdoOfc = hdoOfc;
        this.bkgNo = bkgNo;
        this.cntrNo = cntrNo;
        this.ovrDys = ovrDys;
        this.rqstOfcFlg = rqstOfcFlg;
        this.oomDt = oomDt;
        this.oomOfc = oomOfc;
        this.oomNm = oomNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("bbg_dt", getBbgDt());
        this.hashColumns.put("chg_delt_usr_yn", getChgDeltUsrYn());
        this.hashColumns.put("hdo_nm", getHdoNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("sts_cd", getStsCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rhq_nm", getRhqNm());
        this.hashColumns.put("inact_rqst_no", getInactRqstNo());
        this.hashColumns.put("rhq_dt", getRhqDt());
        this.hashColumns.put("rqst_nm", getRqstNm());
        this.hashColumns.put("hdo_dt", getHdoDt());
        this.hashColumns.put("inactiv_info", getInactivInfo());
        this.hashColumns.put("inact_apro_no", getInactAproNo());
        this.hashColumns.put("bbg_nm", getBbgNm());
        this.hashColumns.put("dmdt_delt_rqst_sts_cd", getDmdtDeltRqstStsCd());
        this.hashColumns.put("inact_rsn", getInactRsn());
        this.hashColumns.put("spec_rsn", getSpecRsn());
        this.hashColumns.put("rqst_ofc", getRqstOfc());
        this.hashColumns.put("bbg_ofc", getBbgOfc());
        this.hashColumns.put("rhq_ofc", getRhqOfc());
        this.hashColumns.put("hdo_ofc", getHdoOfc());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("ovr_dys", getOvrDys());
        this.hashColumns.put("rqst_ofc_flg", getRqstOfcFlg());
        this.hashColumns.put("oom_dt", getOomDt());
        this.hashColumns.put("oom_ofc", getOomOfc());
        this.hashColumns.put("oom_nm", getOomNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("bbg_dt", "bbgDt");
        this.hashFields.put("chg_delt_usr_yn", "chgDeltUsrYn");
        this.hashFields.put("hdo_nm", "hdoNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("sts_cd", "stsCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rhq_nm", "rhqNm");
        this.hashFields.put("inact_rqst_no", "inactRqstNo");
        this.hashFields.put("rhq_dt", "rhqDt");
        this.hashFields.put("rqst_nm", "rqstNm");
        this.hashFields.put("hdo_dt", "hdoDt");
        this.hashFields.put("inactiv_info", "inactivInfo");
        this.hashFields.put("inact_apro_no", "inactAproNo");
        this.hashFields.put("bbg_nm", "bbgNm");
        this.hashFields.put("dmdt_delt_rqst_sts_cd", "dmdtDeltRqstStsCd");
        this.hashFields.put("inact_rsn", "inactRsn");
        this.hashFields.put("spec_rsn", "specRsn");
        this.hashFields.put("rqst_ofc", "rqstOfc");
        this.hashFields.put("bbg_ofc", "bbgOfc");
        this.hashFields.put("rhq_ofc", "rhqOfc");
        this.hashFields.put("hdo_ofc", "hdoOfc");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("ovr_dys", "ovrDys");
        this.hashFields.put("rqst_ofc_flg", "rqstOfcFlg");
        this.hashFields.put("oom_dt", "oomDt");
        this.hashFields.put("oom_ofc", "oomOfc");
        this.hashFields.put("oom_nm", "oomNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 * Column Info
	 * @return bbgDt
	 */
    public String getBbgDt() {
        return this.bbgDt;
    }

    /**
	 * Column Info
	 * @return chgDeltUsrYn
	 */
    public String getChgDeltUsrYn() {
        return this.chgDeltUsrYn;
    }

    /**
	 * Column Info
	 * @return hdoNm
	 */
    public String getHdoNm() {
        return this.hdoNm;
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
	 * @return stsCd
	 */
    public String getStsCd() {
        return this.stsCd;
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
	 * @return rhqNm
	 */
    public String getRhqNm() {
        return this.rhqNm;
    }

    /**
	 * Column Info
	 * @return inactRqstNo
	 */
    public String getInactRqstNo() {
        return this.inactRqstNo;
    }

    /**
	 * Column Info
	 * @return rhqDt
	 */
    public String getRhqDt() {
        return this.rhqDt;
    }

    /**
	 * Column Info
	 * @return rqstNm
	 */
    public String getRqstNm() {
        return this.rqstNm;
    }

    /**
	 * Column Info
	 * @return hdoDt
	 */
    public String getHdoDt() {
        return this.hdoDt;
    }

    /**
	 * Column Info
	 * @return inactivInfo
	 */
    public String getInactivInfo() {
        return this.inactivInfo;
    }

    /**
	 * Column Info
	 * @return inactAproNo
	 */
    public String getInactAproNo() {
        return this.inactAproNo;
    }

    /**
	 * Column Info
	 * @return bbgNm
	 */
    public String getBbgNm() {
        return this.bbgNm;
    }

    /**
	 * Column Info
	 * @return dmdtDeltRqstStsCd
	 */
    public String getDmdtDeltRqstStsCd() {
        return this.dmdtDeltRqstStsCd;
    }

    /**
	 * Column Info
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param bbgDt
	 */
    public void setBbgDt(String bbgDt) {
        this.bbgDt = bbgDt;
    }

    /**
	 * Column Info
	 * @param chgDeltUsrYn
	 */
    public void setChgDeltUsrYn(String chgDeltUsrYn) {
        this.chgDeltUsrYn = chgDeltUsrYn;
    }

    /**
	 * Column Info
	 * @param hdoNm
	 */
    public void setHdoNm(String hdoNm) {
        this.hdoNm = hdoNm;
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
	 * @param stsCd
	 */
    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
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
	 * @param rhqNm
	 */
    public void setRhqNm(String rhqNm) {
        this.rhqNm = rhqNm;
    }

    /**
	 * Column Info
	 * @param inactRqstNo
	 */
    public void setInactRqstNo(String inactRqstNo) {
        this.inactRqstNo = inactRqstNo;
    }

    /**
	 * Column Info
	 * @param rhqDt
	 */
    public void setRhqDt(String rhqDt) {
        this.rhqDt = rhqDt;
    }

    /**
	 * Column Info
	 * @param rqstNm
	 */
    public void setRqstNm(String rqstNm) {
        this.rqstNm = rqstNm;
    }

    /**
	 * Column Info
	 * @param hdoDt
	 */
    public void setHdoDt(String hdoDt) {
        this.hdoDt = hdoDt;
    }

    /**
	 * Column Info
	 * @param inactivInfo
	 */
    public void setInactivInfo(String inactivInfo) {
        this.inactivInfo = inactivInfo;
    }

    /**
	 * Column Info
	 * @param inactAproNo
	 */
    public void setInactAproNo(String inactAproNo) {
        this.inactAproNo = inactAproNo;
    }

    /**
	 * Column Info
	 * @param bbgNm
	 */
    public void setBbgNm(String bbgNm) {
        this.bbgNm = bbgNm;
    }

    /**
	 * Column Info
	 * @param dmdtDeltRqstStsCd
	 */
    public void setDmdtDeltRqstStsCd(String dmdtDeltRqstStsCd) {
        this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
    }

    public String getInactRsn() {
        return inactRsn;
    }

    public void setInactRsn(String inactRsn) {
        this.inactRsn = inactRsn;
    }

    public String getSpecRsn() {
        return specRsn;
    }

    public void setSpecRsn(String specRsn) {
        this.specRsn = specRsn;
    }

    public String getRqstOfc() {
        return rqstOfc;
    }

    public void setRqstOfc(String rqstOfc) {
        this.rqstOfc = rqstOfc;
    }

    public String getBbgOfc() {
        return bbgOfc;
    }

    public void setBbgOfc(String bbgOfc) {
        this.bbgOfc = bbgOfc;
    }

    public String getRhqOfc() {
        return rhqOfc;
    }

    public void setRhqOfc(String rhqOfc) {
        this.rhqOfc = rhqOfc;
    }

    public String getHdoOfc() {
        return hdoOfc;
    }

    public void setHdoOfc(String hdoOfc) {
        this.hdoOfc = hdoOfc;
    }

    public String getBkgNo() {
        return bkgNo;
    }

    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    public String getCntrNo() {
        return cntrNo;
    }

    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    public String getOvrDys() {
        return ovrDys;
    }

    public void setOvrDys(String ovrDys) {
        this.ovrDys = ovrDys;
    }

    public String getRqstOfcFlg() {
        return rqstOfcFlg;
    }

    public void setRqstOfcFlg(String rqstOfcFlg) {
        this.rqstOfcFlg = rqstOfcFlg;
    }

    public void setOomDt(String oomDt) {
        this.oomDt = oomDt;
    }

    public String getOomDt() {
        return this.oomDt;
    }

    public void setOomOfc(String oomOfc) {
        this.oomOfc = oomOfc;
    }

    public String getOomOfc() {
        return this.oomOfc;
    }

    public void setOomNm(String oomNm) {
        this.oomNm = oomNm;
    }

    public String getOomNm() {
        return this.oomNm;
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
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setBbgDt(JSPUtil.getParameter(request, prefix + "bbg_dt", ""));
        setChgDeltUsrYn(JSPUtil.getParameter(request, prefix + "chg_delt_usr_yn", ""));
        setHdoNm(JSPUtil.getParameter(request, prefix + "hdo_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRhqNm(JSPUtil.getParameter(request, prefix + "rhq_nm", ""));
        setInactRqstNo(JSPUtil.getParameter(request, prefix + "inact_rqst_no", ""));
        setRhqDt(JSPUtil.getParameter(request, prefix + "rhq_dt", ""));
        setRqstNm(JSPUtil.getParameter(request, prefix + "rqst_nm", ""));
        setHdoDt(JSPUtil.getParameter(request, prefix + "hdo_dt", ""));
        setInactivInfo(JSPUtil.getParameter(request, prefix + "inactiv_info", ""));
        setInactAproNo(JSPUtil.getParameter(request, prefix + "inact_apro_no", ""));
        setBbgNm(JSPUtil.getParameter(request, prefix + "bbg_nm", ""));
        setDmdtDeltRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_delt_rqst_sts_cd", ""));
        setInactRsn(JSPUtil.getParameter(request, prefix + "inact_rsn", ""));
        setSpecRsn(JSPUtil.getParameter(request, prefix + "spec_rsn", ""));
        setRqstOfc(JSPUtil.getParameter(request, prefix + "rqst_ofc", ""));
        setBbgOfc(JSPUtil.getParameter(request, prefix + "bbg_ofc", ""));
        setRhqOfc(JSPUtil.getParameter(request, prefix + "rhq_ofc", ""));
        setHdoOfc(JSPUtil.getParameter(request, prefix + "hdo_ofc", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setOvrDys(JSPUtil.getParameter(request, prefix + "ovr_dys", ""));
        setRqstOfcFlg(JSPUtil.getParameter(request, prefix + "rqst_ofc_flg", ""));
        setOomDt(JSPUtil.getParameter(request, prefix + "oom_dt", ""));
        setOomOfc(JSPUtil.getParameter(request, prefix + "oom_ofc", ""));
        setOomNm(JSPUtil.getParameter(request, prefix + "oom_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InactiveListVO[]
	 */
    public InactiveListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InactiveListVO[]
	 */
    public InactiveListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InactiveListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] bbgDt = (JSPUtil.getParameter(request, prefix + "bbg_dt", length));
            String[] chgDeltUsrYn = (JSPUtil.getParameter(request, prefix + "chg_delt_usr_yn", length));
            String[] hdoNm = (JSPUtil.getParameter(request, prefix + "hdo_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] stsCd = (JSPUtil.getParameter(request, prefix + "sts_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rhqNm = (JSPUtil.getParameter(request, prefix + "rhq_nm", length));
            String[] inactRqstNo = (JSPUtil.getParameter(request, prefix + "inact_rqst_no", length));
            String[] rhqDt = (JSPUtil.getParameter(request, prefix + "rhq_dt", length));
            String[] rqstNm = (JSPUtil.getParameter(request, prefix + "rqst_nm", length));
            String[] hdoDt = (JSPUtil.getParameter(request, prefix + "hdo_dt", length));
            String[] inactivInfo = (JSPUtil.getParameter(request, prefix + "inactiv_info", length));
            String[] inactAproNo = (JSPUtil.getParameter(request, prefix + "inact_apro_no", length));
            String[] bbgNm = (JSPUtil.getParameter(request, prefix + "bbg_nm", length));
            String[] dmdtDeltRqstStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_delt_rqst_sts_cd", length));
            String[] inactRsn = (JSPUtil.getParameter(request, prefix + "inact_rsn", length));
            String[] specRsn = (JSPUtil.getParameter(request, prefix + "spec_rsn", length));
            String[] rqstOfc = (JSPUtil.getParameter(request, prefix + "rqst_ofc", length));
            String[] bbgOfc = (JSPUtil.getParameter(request, prefix + "bbg_ofc", length));
            String[] rhqOfc = (JSPUtil.getParameter(request, prefix + "rhq_ofc", length));
            String[] hdoOfc = (JSPUtil.getParameter(request, prefix + "hdo_ofc", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] ovrDys = (JSPUtil.getParameter(request, prefix + "ovr_dys", length));
            String[] rqstOfcFlg = (JSPUtil.getParameter(request, prefix + "rqst_ofc_flg", length));
            String[] oomDt = (JSPUtil.getParameter(request, prefix + "oom_dt", length));
	    	String[] oomOfc = (JSPUtil.getParameter(request, prefix + "oom_ofc", length));
	    	String[] oomNm = (JSPUtil.getParameter(request, prefix + "oom_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InactiveListVO();
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (bbgDt[i] != null)
                    model.setBbgDt(bbgDt[i]);
                if (chgDeltUsrYn[i] != null)
                    model.setChgDeltUsrYn(chgDeltUsrYn[i]);
                if (hdoNm[i] != null)
                    model.setHdoNm(hdoNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (stsCd[i] != null)
                    model.setStsCd(stsCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rhqNm[i] != null)
                    model.setRhqNm(rhqNm[i]);
                if (inactRqstNo[i] != null)
                    model.setInactRqstNo(inactRqstNo[i]);
                if (rhqDt[i] != null)
                    model.setRhqDt(rhqDt[i]);
                if (rqstNm[i] != null)
                    model.setRqstNm(rqstNm[i]);
                if (hdoDt[i] != null)
                    model.setHdoDt(hdoDt[i]);
                if (inactivInfo[i] != null)
                    model.setInactivInfo(inactivInfo[i]);
                if (inactAproNo[i] != null)
                    model.setInactAproNo(inactAproNo[i]);
                if (bbgNm[i] != null)
                    model.setBbgNm(bbgNm[i]);
                if (dmdtDeltRqstStsCd[i] != null)
                    model.setDmdtDeltRqstStsCd(dmdtDeltRqstStsCd[i]);
                if (inactRsn[i] != null)
                    model.setInactRsn(inactRsn[i]);
                if (specRsn[i] != null)
                    model.setSpecRsn(specRsn[i]);
                if (rqstOfc[i] != null)
                    model.setRqstOfc(rqstOfc[i]);
                if (bbgOfc[i] != null)
                    model.setBbgOfc(bbgOfc[i]);
                if (rhqOfc[i] != null)
                    model.setRhqOfc(rhqOfc[i]);
                if (hdoOfc[i] != null)
                    model.setHdoOfc(hdoOfc[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (ovrDys[i] != null)
                    model.setOvrDys(ovrDys[i]);
                if (rqstOfcFlg[i] != null)
                    model.setRqstOfcFlg(rqstOfcFlg[i]);
                if (oomDt[i] != null) 
		    		model.setOomDt(oomDt[i]);
				if (oomOfc[i] != null) 
		    		model.setOomOfc(oomOfc[i]);
				if (oomNm[i] != null) 
		    		model.setOomNm(oomNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInactiveListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InactiveListVO[]
	 */
    public InactiveListVO[] getInactiveListVOs() {
        InactiveListVO[] vos = (InactiveListVO[]) models.toArray(new InactiveListVO[models.size()]);
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
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbgDt = this.bbgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgDeltUsrYn = this.chgDeltUsrYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hdoNm = this.hdoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stsCd = this.stsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqNm = this.rhqNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inactRqstNo = this.inactRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqDt = this.rhqDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNm = this.rqstNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hdoDt = this.hdoDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inactivInfo = this.inactivInfo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inactAproNo = this.inactAproNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbgNm = this.bbgNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtDeltRqstStsCd = this.dmdtDeltRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inactRsn = this.inactRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.specRsn = this.specRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfc = this.rqstOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbgOfc = this.bbgOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfc = this.rhqOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hdoOfc = this.hdoOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrDys = this.ovrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfcFlg = this.rqstOfcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oomDt = this.oomDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oomOfc = this.oomOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oomNm = this.oomNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
