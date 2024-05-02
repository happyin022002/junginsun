/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerPerformanceIfVO.java
*@FileTitle : CustomerPerformanceIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;
 
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
public class CustomerPerformanceIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomerPerformanceIfVO> models = new ArrayList<CustomerPerformanceIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custPerfGrpIfSeq = null;

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String custGrpNm = null;

    /* Column Info */
    private String custGrpAbbrNm = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String vbsClssCd = null;

    /* Column Info */
    private String nbsClssCd1 = null;

    /* Column Info */
    private String nbsClssCd2 = null;

    /* Column Info */
    private String nbsClssCd3 = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String ecomInsfId = null;

    /* Column Info */
    private String ecomInsfPrsId = null;

    /* Column Info */
    private String ecomInsfDttm = null;

    /* Column Info */
    private String ecomInsfCnqeVal = null;

    /* Column Info */
    private String ecomInsfDvCd = null;

    /* Column Info */
    private String ecomInsfCnqeCont = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CustomerPerformanceIfVO() {
    }

    public CustomerPerformanceIfVO(String ibflag, String pagerows, String custPerfGrpIfSeq, String custGrpId, String custGrpNm, String custGrpAbbrNm, String ofcCd, String srepCd, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.custPerfGrpIfSeq = custPerfGrpIfSeq;
        this.custGrpId = custGrpId;
        this.custGrpNm = custGrpNm;
        this.custGrpAbbrNm = custGrpAbbrNm;
        this.ofcCd = ofcCd;
        this.srepCd = srepCd;
        this.vbsClssCd = vbsClssCd;
        this.nbsClssCd1 = nbsClssCd1;
        this.nbsClssCd2 = nbsClssCd2;
        this.nbsClssCd3 = nbsClssCd3;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.ecomInsfId = ecomInsfId;
        this.ecomInsfPrsId = ecomInsfPrsId;
        this.ecomInsfDttm = ecomInsfDttm;
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
        this.ecomInsfDvCd = ecomInsfDvCd;
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_perf_grp_if_seq", getCustPerfGrpIfSeq());
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("cust_grp_nm", getCustGrpNm());
        this.hashColumns.put("cust_grp_abbr_nm", getCustGrpAbbrNm());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
        this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
        this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
        this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("ecom_insf_id", getEcomInsfId());
        this.hashColumns.put("ecom_insf_prs_id", getEcomInsfPrsId());
        this.hashColumns.put("ecom_insf_dttm", getEcomInsfDttm());
        this.hashColumns.put("ecom_insf_cnqe_val", getEcomInsfCnqeVal());
        this.hashColumns.put("ecom_insf_dv_cd", getEcomInsfDvCd());
        this.hashColumns.put("ecom_insf_cnqe_cont", getEcomInsfCnqeCont());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_perf_grp_if_seq", "custPerfGrpIfSeq");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("cust_grp_nm", "custGrpNm");
        this.hashFields.put("cust_grp_abbr_nm", "custGrpAbbrNm");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("vbs_clss_cd", "vbsClssCd");
        this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
        this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
        this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("ecom_insf_id", "ecomInsfId");
        this.hashFields.put("ecom_insf_prs_id", "ecomInsfPrsId");
        this.hashFields.put("ecom_insf_dttm", "ecomInsfDttm");
        this.hashFields.put("ecom_insf_cnqe_val", "ecomInsfCnqeVal");
        this.hashFields.put("ecom_insf_dv_cd", "ecomInsfDvCd");
        this.hashFields.put("ecom_insf_cnqe_cont", "ecomInsfCnqeCont");
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
	 * @param String custPerfGrpIfSeq
	 */
    public void setCustPerfGrpIfSeq(String custPerfGrpIfSeq) {
        this.custPerfGrpIfSeq = custPerfGrpIfSeq;
    }

    /**
	 * 
	 * @return String custPerfGrpIfSeq
	 */
    public String getCustPerfGrpIfSeq() {
        return this.custPerfGrpIfSeq;
    }

    /**
	 *
	 * @param String custGrpId
	 */
    public void setCustGrpId(String custGrpId) {
        this.custGrpId = custGrpId;
    }

    /**
	 * 
	 * @return String custGrpId
	 */
    public String getCustGrpId() {
        return this.custGrpId;
    }

    /**
	 *
	 * @param String custGrpNm
	 */
    public void setCustGrpNm(String custGrpNm) {
        this.custGrpNm = custGrpNm;
    }

    /**
	 * 
	 * @return String custGrpNm
	 */
    public String getCustGrpNm() {
        return this.custGrpNm;
    }

    /**
	 *
	 * @param String custGrpAbbrNm
	 */
    public void setCustGrpAbbrNm(String custGrpAbbrNm) {
        this.custGrpAbbrNm = custGrpAbbrNm;
    }

    /**
	 * 
	 * @return String custGrpAbbrNm
	 */
    public String getCustGrpAbbrNm() {
        return this.custGrpAbbrNm;
    }

    /**
	 *
	 * @param String ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * 
	 * @return String ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 *
	 * @param String srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * 
	 * @return String srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 *
	 * @param String vbsClssCd
	 */
    public void setVbsClssCd(String vbsClssCd) {
        this.vbsClssCd = vbsClssCd;
    }

    /**
	 * 
	 * @return String vbsClssCd
	 */
    public String getVbsClssCd() {
        return this.vbsClssCd;
    }

    /**
	 *
	 * @param String nbsClssCd1
	 */
    public void setNbsClssCd1(String nbsClssCd1) {
        this.nbsClssCd1 = nbsClssCd1;
    }

    /**
	 * 
	 * @return String nbsClssCd1
	 */
    public String getNbsClssCd1() {
        return this.nbsClssCd1;
    }

    /**
	 *
	 * @param String nbsClssCd2
	 */
    public void setNbsClssCd2(String nbsClssCd2) {
        this.nbsClssCd2 = nbsClssCd2;
    }

    /**
	 * 
	 * @return String nbsClssCd2
	 */
    public String getNbsClssCd2() {
        return this.nbsClssCd2;
    }

    /**
	 *
	 * @param String nbsClssCd3
	 */
    public void setNbsClssCd3(String nbsClssCd3) {
        this.nbsClssCd3 = nbsClssCd3;
    }

    /**
	 * 
	 * @return String nbsClssCd3
	 */
    public String getNbsClssCd3() {
        return this.nbsClssCd3;
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
	 * @param String deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * 
	 * @return String deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    public void setEcomInsfId(String ecomInsfId) {
        this.ecomInsfId = ecomInsfId;
    }

    public String getEcomInsfId() {
        return this.ecomInsfId;
    }

    public void setEcomInsfPrsId(String ecomInsfPrsId) {
        this.ecomInsfPrsId = ecomInsfPrsId;
    }

    public String getEcomInsfPrsId() {
        return this.ecomInsfPrsId;
    }

    public void setEcomInsfDttm(String ecomInsfDttm) {
        this.ecomInsfDttm = ecomInsfDttm;
    }

    public String getEcomInsfDttm() {
        return this.ecomInsfDttm;
    }

    public void setEcomInsfCnqeVal(String ecomInsfCnqeVal) {
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
    }

    public String getEcomInsfCnqeVal() {
        return this.ecomInsfCnqeVal;
    }

    public void setEcomInsfDvCd(String ecomInsfDvCd) {
        this.ecomInsfDvCd = ecomInsfDvCd;
    }

    public String getEcomInsfDvCd() {
        return this.ecomInsfDvCd;
    }

    public void setEcomInsfCnqeCont(String ecomInsfCnqeCont) {
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
    }

    public String getEcomInsfCnqeCont() {
        return this.ecomInsfCnqeCont;
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
        setCustPerfGrpIfSeq(JSPUtil.getParameter(request, prefix + "cust_perf_grp_if_seq", ""));
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
        setCustGrpAbbrNm(JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
        setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
        setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
        setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setEcomInsfId(JSPUtil.getParameter(request, prefix + "ecom_insf_id", ""));
        setEcomInsfPrsId(JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", ""));
        setEcomInsfDttm(JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", ""));
        setEcomInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", ""));
        setEcomInsfDvCd(JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", ""));
        setEcomInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerPerformanceIfVO[]
	 */
    public CustomerPerformanceIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerPerformanceIfVO[]
	 */
    public CustomerPerformanceIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomerPerformanceIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custPerfGrpIfSeq = (JSPUtil.getParameter(request, prefix + "cust_perf_grp_if_seq", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] custGrpNm = (JSPUtil.getParameter(request, prefix + "cust_grp_nm", length));
            String[] custGrpAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] vbsClssCd = (JSPUtil.getParameter(request, prefix + "vbs_clss_cd", length));
            String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", length));
            String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", length));
            String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] ecomInsfId = (JSPUtil.getParameter(request, prefix + "ecom_insf_id", length));
	    	String[] ecomInsfPrsId = (JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", length));
	    	String[] ecomInsfDttm = (JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", length));
	    	String[] ecomInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", length));
	    	String[] ecomInsfDvCd = (JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", length));
	    	String[] ecomInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomerPerformanceIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custPerfGrpIfSeq[i] != null)
                    model.setCustPerfGrpIfSeq(custPerfGrpIfSeq[i]);
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (custGrpNm[i] != null)
                    model.setCustGrpNm(custGrpNm[i]);
                if (custGrpAbbrNm[i] != null)
                    model.setCustGrpAbbrNm(custGrpAbbrNm[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (vbsClssCd[i] != null)
                    model.setVbsClssCd(vbsClssCd[i]);
                if (nbsClssCd1[i] != null)
                    model.setNbsClssCd1(nbsClssCd1[i]);
                if (nbsClssCd2[i] != null)
                    model.setNbsClssCd2(nbsClssCd2[i]);
                if (nbsClssCd3[i] != null)
                    model.setNbsClssCd3(nbsClssCd3[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (ecomInsfId[i] != null) 
		    		model.setEcomInsfId(ecomInsfId[i]);
				if (ecomInsfPrsId[i] != null) 
		    		model.setEcomInsfPrsId(ecomInsfPrsId[i]);
				if (ecomInsfDttm[i] != null) 
		    		model.setEcomInsfDttm(ecomInsfDttm[i]);
				if (ecomInsfCnqeVal[i] != null) 
		    		model.setEcomInsfCnqeVal(ecomInsfCnqeVal[i]);
				if (ecomInsfDvCd[i] != null) 
		    		model.setEcomInsfDvCd(ecomInsfDvCd[i]);
				if (ecomInsfCnqeCont[i] != null) 
		    		model.setEcomInsfCnqeCont(ecomInsfCnqeCont[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustomerPerformanceIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustomerPerformanceIfVO[]
	 */
    public CustomerPerformanceIfVO[] getCustomerPerformanceIfVOs() {
        CustomerPerformanceIfVO[] vos = (CustomerPerformanceIfVO[]) models.toArray(new CustomerPerformanceIfVO[models.size()]);
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
        this.custPerfGrpIfSeq = this.custPerfGrpIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpNm = this.custGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpAbbrNm = this.custGrpAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vbsClssCd = this.vbsClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd1 = this.nbsClssCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd2 = this.nbsClssCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd3 = this.nbsClssCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfId = this.ecomInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfPrsId = this.ecomInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDttm = this.ecomInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeVal = this.ecomInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDvCd = this.ecomInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeCont = this.ecomInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
