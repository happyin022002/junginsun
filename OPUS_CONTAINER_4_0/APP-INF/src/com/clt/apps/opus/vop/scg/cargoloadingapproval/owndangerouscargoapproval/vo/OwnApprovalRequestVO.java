/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnApprovalRequestVO.java
*@FileTitle : OwnApprovalRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.03.24 김현욱 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.lang.reflect.Field;
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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class OwnApprovalRequestVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OwnApprovalRequestVO> models = new ArrayList<OwnApprovalRequestVO>();

    /* Column Info */
    private String bodyHeader = null;

    /* Column Info */
    private String spclCgoRqstSeq = null;

    /* Column Info */
    private String rgnShpOprCd = null;

    /* Column Info */
    private String subject = null;

    /* Column Info */
    private String fromPsn = null;

    /* Column Info */
    private String scgFlg = null;

    /* Column Info */
    private String sendType = null;

    /* Column Info */
    private String vslSeq = null;

    /* Column Info */
    private String bodyConts = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgRefNo = null;

    /* Column Info */
    private String bkgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ccPsn = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String toPsn = null;

    /* Column Info */
    private String spclCgoAproRqstSeq = null;

    /* Column Info */
    private String vslPrePstCd = null;

    /* Column Info */
    private String attachFile = null;

    /* Column Info */
    private String bodyFooter = null;

    /* Column Info */
    private String prnrCgoRqstSeq = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public OwnApprovalRequestVO() {
    }

    public OwnApprovalRequestVO(String ibflag, String pagerows, String fromPsn, String toPsn, String ccPsn, String subject, String attachFile, String bodyHeader, String bodyFooter, String bodyConts, String crrCd, String slanCd, String bkgRefNo, String spclCgoRqstSeq, String bkgNo, String spclCgoAproRqstSeq, String vslPrePstCd, String vslSeq, String rgnShpOprCd, String scgFlg, String sendType, String userId, String prnrCgoRqstSeq, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd) {
        this.bodyHeader = bodyHeader;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.rgnShpOprCd = rgnShpOprCd;
        this.subject = subject;
        this.fromPsn = fromPsn;
        this.scgFlg = scgFlg;
        this.sendType = sendType;
        this.vslSeq = vslSeq;
        this.bodyConts = bodyConts;
        this.crrCd = crrCd;
        this.slanCd = slanCd;
        this.pagerows = pagerows;
        this.bkgRefNo = bkgRefNo;
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.ccPsn = ccPsn;
        this.userId = userId;
        this.toPsn = toPsn;
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
        this.vslPrePstCd = vslPrePstCd;
        this.attachFile = attachFile;
        this.bodyFooter = bodyFooter;
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.polCd = polCd;
        this.podCd = podCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("body_header", getBodyHeader());
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("subject", getSubject());
        this.hashColumns.put("from_psn", getFromPsn());
        this.hashColumns.put("scg_flg", getScgFlg());
        this.hashColumns.put("send_type", getSendType());
        this.hashColumns.put("vsl_seq", getVslSeq());
        this.hashColumns.put("body_conts", getBodyConts());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cc_psn", getCcPsn());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("to_psn", getToPsn());
        this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("attach_file", getAttachFile());
        this.hashColumns.put("body_footer", getBodyFooter());
        this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("body_header", "bodyHeader");
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("subject", "subject");
        this.hashFields.put("from_psn", "fromPsn");
        this.hashFields.put("scg_flg", "scgFlg");
        this.hashFields.put("send_type", "sendType");
        this.hashFields.put("vsl_seq", "vslSeq");
        this.hashFields.put("body_conts", "bodyConts");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cc_psn", "ccPsn");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("to_psn", "toPsn");
        this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("attach_file", "attachFile");
        this.hashFields.put("body_footer", "bodyFooter");
        this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bodyHeader
	 */
    public String getBodyHeader() {
        return this.bodyHeader;
    }

    /**
	 * Column Info
	 * @return spclCgoRqstSeq
	 */
    public String getSpclCgoRqstSeq() {
        return this.spclCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @return rgnShpOprCd
	 */
    public String getRgnShpOprCd() {
        return this.rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @return subject
	 */
    public String getSubject() {
        return this.subject;
    }

    /**
	 * Column Info
	 * @return fromPsn
	 */
    public String getFromPsn() {
        return this.fromPsn;
    }

    /**
	 * Column Info
	 * @return scgFlg
	 */
    public String getScgFlg() {
        return this.scgFlg;
    }

    /**
	 * Column Info
	 * @return sendType
	 */
    public String getSendType() {
        return this.sendType;
    }

    /**
	 * Column Info
	 * @return vslSeq
	 */
    public String getVslSeq() {
        return this.vslSeq;
    }

    /**
	 * Column Info
	 * @return bodyConts
	 */
    public String getBodyConts() {
        return this.bodyConts;
    }

    /**
	 * Column Info
	 * @return crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
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
	 * @return bkgRefNo
	 */
    public String getBkgRefNo() {
        return this.bkgRefNo;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
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
	 * @return ccPsn
	 */
    public String getCcPsn() {
        return this.ccPsn;
    }

    /**
	 * Column Info
	 * @return userId
	 */
    public String getUserId() {
        return this.userId;
    }

    /**
	 * Column Info
	 * @return toPsn
	 */
    public String getToPsn() {
        return this.toPsn;
    }

    /**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
    public String getSpclCgoAproRqstSeq() {
        return this.spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @return vslPrePstCd
	 */
    public String getVslPrePstCd() {
        return this.vslPrePstCd;
    }

    /**
	 * Column Info
	 * @return attachFile
	 */
    public String getAttachFile() {
        return this.attachFile;
    }

    /**
	 * Column Info
	 * @return bodyFooter
	 */
    public String getBodyFooter() {
        return this.bodyFooter;
    }

    /**
	 * Column Info
	 * @param bodyHeader
	 */
    public void setBodyHeader(String bodyHeader) {
        this.bodyHeader = bodyHeader;
    }

    /**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
    public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @param rgnShpOprCd
	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @param subject
	 */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
	 * Column Info
	 * @param fromPsn
	 */
    public void setFromPsn(String fromPsn) {
        this.fromPsn = fromPsn;
    }

    /**
	 * Column Info
	 * @param scgFlg
	 */
    public void setScgFlg(String scgFlg) {
        this.scgFlg = scgFlg;
    }

    /**
	 * Column Info
	 * @param sendType
	 */
    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    /**
	 * Column Info
	 * @param vslSeq
	 */
    public void setVslSeq(String vslSeq) {
        this.vslSeq = vslSeq;
    }

    /**
	 * Column Info
	 * @param bodyConts
	 */
    public void setBodyConts(String bodyConts) {
        this.bodyConts = bodyConts;
    }

    /**
	 * Column Info
	 * @param crrCd
	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * Column Info
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
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
	 * @param bkgRefNo
	 */
    public void setBkgRefNo(String bkgRefNo) {
        this.bkgRefNo = bkgRefNo;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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
	 * @param ccPsn
	 */
    public void setCcPsn(String ccPsn) {
        this.ccPsn = ccPsn;
    }

    /**
	 * Column Info
	 * @param userId
	 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
	 * Column Info
	 * @param toPsn
	 */
    public void setToPsn(String toPsn) {
        this.toPsn = toPsn;
    }

    /**
	 * Column Info
	 * @param spclCgoAproRqstSeq
	 */
    public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @param vslPrePstCd
	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
    }

    /**
	 * Column Info
	 * @param attachFile
	 */
    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    /**
	 * Column Info
	 * @param bodyFooter
	 */
    public void setBodyFooter(String bodyFooter) {
        this.bodyFooter = bodyFooter;
    }

    public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
    }

    public String getPrnrCgoRqstSeq() {
        return this.prnrCgoRqstSeq;
    }

    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    public String getVslCd() {
        return this.vslCd;
    }

    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPolCd() {
        return this.polCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getPodCd() {
        return this.podCd;
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
        setBodyHeader(JSPUtil.getParameter(request, prefix + "body_header", ""));
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
        setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
        setFromPsn(JSPUtil.getParameter(request, prefix + "from_psn", ""));
        setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
        setSendType(JSPUtil.getParameter(request, prefix + "send_type", ""));
        setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
        setBodyConts(JSPUtil.getParameter(request, prefix + "body_conts", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCcPsn(JSPUtil.getParameter(request, prefix + "cc_psn", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setToPsn(JSPUtil.getParameter(request, prefix + "to_psn", ""));
        setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
        setAttachFile(JSPUtil.getParameter(request, prefix + "attach_file", ""));
        setBodyFooter(JSPUtil.getParameter(request, prefix + "body_footer", ""));
        setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OwnApprovalRequestVO[]
	 */
    public OwnApprovalRequestVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OwnApprovalRequestVO[]
	 */
    public OwnApprovalRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OwnApprovalRequestVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bodyHeader = (JSPUtil.getParameter(request, prefix + "body_header", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] subject = (JSPUtil.getParameter(request, prefix + "subject", length));
            String[] fromPsn = (JSPUtil.getParameter(request, prefix + "from_psn", length));
            String[] scgFlg = (JSPUtil.getParameter(request, prefix + "scg_flg", length));
            String[] sendType = (JSPUtil.getParameter(request, prefix + "send_type", length));
            String[] vslSeq = (JSPUtil.getParameter(request, prefix + "vsl_seq", length));
            String[] bodyConts = (JSPUtil.getParameter(request, prefix + "body_conts", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ccPsn = (JSPUtil.getParameter(request, prefix + "cc_psn", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] toPsn = (JSPUtil.getParameter(request, prefix + "to_psn", length));
            String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] attachFile = (JSPUtil.getParameter(request, prefix + "attach_file", length));
            String[] bodyFooter = (JSPUtil.getParameter(request, prefix + "body_footer", length));
            String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", length));
	    	String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
	    	String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
	    	String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
	    	String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
	    	String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OwnApprovalRequestVO();
                if (bodyHeader[i] != null)
                    model.setBodyHeader(bodyHeader[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (subject[i] != null)
                    model.setSubject(subject[i]);
                if (fromPsn[i] != null)
                    model.setFromPsn(fromPsn[i]);
                if (scgFlg[i] != null)
                    model.setScgFlg(scgFlg[i]);
                if (sendType[i] != null)
                    model.setSendType(sendType[i]);
                if (vslSeq[i] != null)
                    model.setVslSeq(vslSeq[i]);
                if (bodyConts[i] != null)
                    model.setBodyConts(bodyConts[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ccPsn[i] != null)
                    model.setCcPsn(ccPsn[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (toPsn[i] != null)
                    model.setToPsn(toPsn[i]);
                if (spclCgoAproRqstSeq[i] != null)
                    model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (attachFile[i] != null)
                    model.setAttachFile(attachFile[i]);
                if (bodyFooter[i] != null)
                    model.setBodyFooter(bodyFooter[i]);
                if (prnrCgoRqstSeq[i] != null) 
		    		model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
				if (vslCd[i] != null) 
		    		model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null) 
		    		model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null) 
		    		model.setSkdDirCd(skdDirCd[i]);
				if (polCd[i] != null) 
		    		model.setPolCd(polCd[i]);
				if (podCd[i] != null) 
		    		model.setPodCd(podCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOwnApprovalRequestVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OwnApprovalRequestVO[]
	 */
    public OwnApprovalRequestVO[] getOwnApprovalRequestVOs() {
        OwnApprovalRequestVO[] vos = (OwnApprovalRequestVO[]) models.toArray(new OwnApprovalRequestVO[models.size()]);
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
        this.bodyHeader = this.bodyHeader.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subject = this.subject.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromPsn = this.fromPsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgFlg = this.scgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sendType = this.sendType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSeq = this.vslSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bodyConts = this.bodyConts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ccPsn = this.ccPsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toPsn = this.toPsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attachFile = this.attachFile.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bodyFooter = this.bodyFooter.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrCgoRqstSeq = this.prnrCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
