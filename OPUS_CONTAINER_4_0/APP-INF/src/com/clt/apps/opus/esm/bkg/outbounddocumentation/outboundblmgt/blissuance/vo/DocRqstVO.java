/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DocRqstVO.java
*@FileTitle : DocRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.02.25 이진서 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DocRqstVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<DocRqstVO> models = new ArrayList<DocRqstVO>();

    /* Column Info */
    private String oblRtInclKnt = null;

    /* Column Info */
    private String nonNegoRtInclKnt = null;

    /* Column Info */
    private String nonNegoRtXcldKnt = null;

    /* Column Info */
    private String rqstIssPlcNm = null;

    /* Column Info */
    private String oblRtXcldKnt = null;

    /* Column Info */
    private String cpyTtlKnt = null;

    /* Column Info */
    private String blDocRqstRmk = null;

    /* Column Info */
    private String rqstIssDt = null;

    /* Column Info */
    private String locNm = null;

    /* Column Info */
    private String blDeToCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rqstBlTpCd = null;

    /* Column Info */
    private String caflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String blDeMzdCd = null;

    /* Column Info */
    private String oblTtlKnt = null;

    /* Column Info */
    private String oblPpdKnt = null;

    /* Column Info */
    private String oblCltKnt = null;

    /* Column Info */
    private String nonNegoPpdKnt = null;

    /* Column Info */
    private String nonNegoCltKnt = null;

    /* Column Info */
    private String blIssTpCd = null;
    private String ffrefno = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public DocRqstVO() {
    }

    public DocRqstVO(String ibflag, String pagerows, String oblRtInclKnt, String nonNegoRtInclKnt, String nonNegoRtXcldKnt, String rqstIssPlcNm, String oblRtXcldKnt, String cpyTtlKnt, String blDocRqstRmk, String rqstIssDt, String locNm, String blDeToCd, String rqstBlTpCd, String bkgNo, String blDeMzdCd, String oblTtlKnt, String caflag, String userId, String oblPpdKnt, String oblCltKnt, String nonNegoPpdKnt, String nonNegoCltKnt, String blIssTpCd, String ffrefno) {
        this.oblRtInclKnt = oblRtInclKnt;
        this.nonNegoRtInclKnt = nonNegoRtInclKnt;
        this.nonNegoRtXcldKnt = nonNegoRtXcldKnt;
        this.rqstIssPlcNm = rqstIssPlcNm;
        this.oblRtXcldKnt = oblRtXcldKnt;
        this.cpyTtlKnt = cpyTtlKnt;
        this.blDocRqstRmk = blDocRqstRmk;
        this.rqstIssDt = rqstIssDt;
        this.locNm = locNm;
        this.blDeToCd = blDeToCd;
        this.pagerows = pagerows;
        this.rqstBlTpCd = rqstBlTpCd;
        this.caflag = caflag;
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.userId = userId;
        this.blDeMzdCd = blDeMzdCd;
        this.oblTtlKnt = oblTtlKnt;
        this.oblPpdKnt = oblPpdKnt;
        this.oblCltKnt = oblCltKnt;
        this.nonNegoPpdKnt = nonNegoPpdKnt;
        this.nonNegoCltKnt = nonNegoCltKnt;
        this.blIssTpCd = blIssTpCd;
        this.ffrefno = ffrefno;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("obl_rt_incl_knt", getOblRtInclKnt());
        this.hashColumns.put("non_nego_rt_incl_knt", getNonNegoRtInclKnt());
        this.hashColumns.put("non_nego_rt_xcld_knt", getNonNegoRtXcldKnt());
        this.hashColumns.put("rqst_iss_plc_nm", getRqstIssPlcNm());
        this.hashColumns.put("obl_rt_xcld_knt", getOblRtXcldKnt());
        this.hashColumns.put("cpy_ttl_knt", getCpyTtlKnt());
        this.hashColumns.put("bl_doc_rqst_rmk", getBlDocRqstRmk());
        this.hashColumns.put("rqst_iss_dt", getRqstIssDt());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("bl_de_to_cd", getBlDeToCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rqst_bl_tp_cd", getRqstBlTpCd());
        this.hashColumns.put("caflag", getCaflag());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("bl_de_mzd_cd", getBlDeMzdCd());
        this.hashColumns.put("obl_ttl_knt", getOblTtlKnt());
        this.hashColumns.put("obl_ppd_knt", getOblPpdKnt());
        this.hashColumns.put("obl_clt_knt", getOblCltKnt());
        this.hashColumns.put("non_nego_ppd_knt", getNonNegoPpdKnt());
        this.hashColumns.put("non_nego_clt_knt", getNonNegoCltKnt());
        this.hashColumns.put("bl_iss_tp_cd", getBlIssTpCd());
        this.hashColumns.put("ffrefno", getFfrefno());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("obl_rt_incl_knt", "oblRtInclKnt");
        this.hashFields.put("non_nego_rt_incl_knt", "nonNegoRtInclKnt");
        this.hashFields.put("non_nego_rt_xcld_knt", "nonNegoRtXcldKnt");
        this.hashFields.put("rqst_iss_plc_nm", "rqstIssPlcNm");
        this.hashFields.put("obl_rt_xcld_knt", "oblRtXcldKnt");
        this.hashFields.put("cpy_ttl_knt", "cpyTtlKnt");
        this.hashFields.put("bl_doc_rqst_rmk", "blDocRqstRmk");
        this.hashFields.put("rqst_iss_dt", "rqstIssDt");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("bl_de_to_cd", "blDeToCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rqst_bl_tp_cd", "rqstBlTpCd");
        this.hashFields.put("caflag", "caflag");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("bl_de_mzd_cd", "blDeMzdCd");
        this.hashFields.put("obl_ttl_knt", "oblTtlKnt");
        this.hashFields.put("obl_ppd_knt", "oblPpdKnt");
        this.hashFields.put("obl_clt_knt", "oblCltKnt");
        this.hashFields.put("non_nego_ppd_knt", "nonNegoPpdKnt");
        this.hashFields.put("non_nego_clt_knt", "nonNegoCltKnt");
        this.hashFields.put("bl_iss_tp_cd", "blIssTpCd");
        this.hashFields.put("ffrefno", "ffrefno");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return oblRtInclKnt
	 */
    public String getOblRtInclKnt() {
        return this.oblRtInclKnt;
    }

    /**
	 * Column Info
	 * @return nonNegoRtInclKnt
	 */
    public String getNonNegoRtInclKnt() {
        return this.nonNegoRtInclKnt;
    }

    /**
	 * Column Info
	 * @return nonNegoRtXcldKnt
	 */
    public String getNonNegoRtXcldKnt() {
        return this.nonNegoRtXcldKnt;
    }

    /**
	 * Column Info
	 * @return rqstIssPlcNm
	 */
    public String getRqstIssPlcNm() {
        return this.rqstIssPlcNm;
    }

    /**
	 * Column Info
	 * @return oblRtXcldKnt
	 */
    public String getOblRtXcldKnt() {
        return this.oblRtXcldKnt;
    }

    /**
	 * Column Info
	 * @return cpyTtlKnt
	 */
    public String getCpyTtlKnt() {
        return this.cpyTtlKnt;
    }

    /**
	 * Column Info
	 * @return blDocRqstRmk
	 */
    public String getBlDocRqstRmk() {
        return this.blDocRqstRmk;
    }

    /**
	 * Column Info
	 * @return rqstIssDt
	 */
    public String getRqstIssDt() {
        return this.rqstIssDt;
    }

    /**
	 * Column Info
	 * @return locNm
	 */
    public String getLocNm() {
        return this.locNm;
    }

    /**
	 * Column Info
	 * @return blDeToCd
	 */
    public String getBlDeToCd() {
        return this.blDeToCd;
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
	 * @return rqstBlTpCd
	 */
    public String getRqstBlTpCd() {
        return this.rqstBlTpCd;
    }

    /**
	 * Column Info
	 * @return caflag
	 */
    public String getCaflag() {
        return this.caflag;
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
	 * @return userId
	 */
    public String getUserId() {
        return this.userId;
    }

    /**
	 * Column Info
	 * @return blDeMzdCd
	 */
    public String getBlDeMzdCd() {
        return this.blDeMzdCd;
    }

    /**
	 * Column Info
	 * @return oblTtlKnt
	 */
    public String getOblTtlKnt() {
        return this.oblTtlKnt;
    }

    /**
	 * Column Info
	 * @return oblPpdKnt
	 */
    public String getOblPpdKnt() {
        return this.oblPpdKnt;
    }

    /**
	 * Column Info
	 * @return oblCltKnt
	 */
    public String getOblCltKnt() {
        return this.oblCltKnt;
    }

    /**
	 * Column Info
	 * @return nonNegoPpdKnt
	 */
    public String getNonNegoPpdKnt() {
        return this.nonNegoPpdKnt;
    }

    /**
	 * Column Info
	 * @return nonNegoCltKnt
	 */
    public String getNonNegoCltKnt() {
        return this.nonNegoCltKnt;
    }

    /**
	 * Column Info
	 * @param oblRtInclKnt
	 */
    public void setOblRtInclKnt(String oblRtInclKnt) {
        this.oblRtInclKnt = oblRtInclKnt;
    }

    /**
	 * Column Info
	 * @param nonNegoRtInclKnt
	 */
    public void setNonNegoRtInclKnt(String nonNegoRtInclKnt) {
        this.nonNegoRtInclKnt = nonNegoRtInclKnt;
    }

    /**
	 * Column Info
	 * @param nonNegoRtXcldKnt
	 */
    public void setNonNegoRtXcldKnt(String nonNegoRtXcldKnt) {
        this.nonNegoRtXcldKnt = nonNegoRtXcldKnt;
    }

    /**
	 * Column Info
	 * @param rqstIssPlcNm
	 */
    public void setRqstIssPlcNm(String rqstIssPlcNm) {
        this.rqstIssPlcNm = rqstIssPlcNm;
    }

    /**
	 * Column Info
	 * @param oblRtXcldKnt
	 */
    public void setOblRtXcldKnt(String oblRtXcldKnt) {
        this.oblRtXcldKnt = oblRtXcldKnt;
    }

    /**
	 * Column Info
	 * @param cpyTtlKnt
	 */
    public void setCpyTtlKnt(String cpyTtlKnt) {
        this.cpyTtlKnt = cpyTtlKnt;
    }

    /**
	 * Column Info
	 * @param blDocRqstRmk
	 */
    public void setBlDocRqstRmk(String blDocRqstRmk) {
        this.blDocRqstRmk = blDocRqstRmk;
    }

    /**
	 * Column Info
	 * @param rqstIssDt
	 */
    public void setRqstIssDt(String rqstIssDt) {
        this.rqstIssDt = rqstIssDt;
    }

    /**
	 * Column Info
	 * @param locNm
	 */
    public void setLocNm(String locNm) {
        this.locNm = locNm;
    }

    /**
	 * Column Info
	 * @param blDeToCd
	 */
    public void setBlDeToCd(String blDeToCd) {
        this.blDeToCd = blDeToCd;
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
	 * @param rqstBlTpCd
	 */
    public void setRqstBlTpCd(String rqstBlTpCd) {
        this.rqstBlTpCd = rqstBlTpCd;
    }

    /**
	 * Column Info
	 * @param caflag
	 */
    public void setCaflag(String caflag) {
        this.caflag = caflag;
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
	 * @param userId
	 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
	 * Column Info
	 * @param blDeMzdCd
	 */
    public void setBlDeMzdCd(String blDeMzdCd) {
        this.blDeMzdCd = blDeMzdCd;
    }

    /**
	 * Column Info
	 * @param oblTtlKnt
	 */
    public void setOblTtlKnt(String oblTtlKnt) {
        this.oblTtlKnt = oblTtlKnt;
    }

    /**
	 * Column Info
	 * @param oblPpdKnt
	 */
    public void setOblPpdKnt(String oblPpdKnt) {
        this.oblPpdKnt = oblPpdKnt;
    }

    /**
	 * Column Info
	 * @param oblCltKnt
	 */
    public void setOblCltKnt(String oblCltKnt) {
        this.oblCltKnt = oblCltKnt;
    }

    /**
	 * Column Info
	 * @param nonNegoPpdKnt
	 */
    public void setNonNegoPpdKnt(String nonNegoPpdKnt) {
        this.nonNegoPpdKnt = nonNegoPpdKnt;
    }

    /**
	 * Column Info
	 * @param nonNegoCltKnt
	 */
    public void setNonNegoCltKnt(String nonNegoCltKnt) {
        this.nonNegoCltKnt = nonNegoCltKnt;
    }

    public void setBlIssTpCd(String blIssTpCd) {
        this.blIssTpCd = blIssTpCd;
    }

    public String getBlIssTpCd() {
        return this.blIssTpCd;
    }
    
    /**
	 * @return the ffrefno
	 */
	public String getFfrefno() {
		return ffrefno;
	}

	/**
	 * @param ffrefno the ffrefno to set
	 */
	public void setFfrefno(String ffrefno) {
		this.ffrefno = ffrefno;
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
        setOblRtInclKnt(JSPUtil.getParameter(request, prefix + "obl_rt_incl_knt", ""));
        setNonNegoRtInclKnt(JSPUtil.getParameter(request, prefix + "non_nego_rt_incl_knt", ""));
        setNonNegoRtXcldKnt(JSPUtil.getParameter(request, prefix + "non_nego_rt_xcld_knt", ""));
        setRqstIssPlcNm(JSPUtil.getParameter(request, prefix + "rqst_iss_plc_nm", ""));
        setOblRtXcldKnt(JSPUtil.getParameter(request, prefix + "obl_rt_xcld_knt", ""));
        setCpyTtlKnt(JSPUtil.getParameter(request, prefix + "cpy_ttl_knt", ""));
        setBlDocRqstRmk(JSPUtil.getParameter(request, prefix + "bl_doc_rqst_rmk", ""));
        setRqstIssDt(JSPUtil.getParameter(request, prefix + "rqst_iss_dt", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setBlDeToCd(JSPUtil.getParameter(request, prefix + "bl_de_to_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setRqstBlTpCd(JSPUtil.getParameter(request, prefix + "rqst_bl_tp_cd", ""));
        setCaflag(JSPUtil.getParameter(request, prefix + "caflag", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setBlDeMzdCd(JSPUtil.getParameter(request, prefix + "bl_de_mzd_cd", ""));
        setOblTtlKnt(JSPUtil.getParameter(request, prefix + "obl_ttl_knt", ""));
        setOblPpdKnt(JSPUtil.getParameter(request, prefix + "obl_ppd_knt", ""));
        setOblCltKnt(JSPUtil.getParameter(request, prefix + "obl_clt_knt", ""));
        setNonNegoPpdKnt(JSPUtil.getParameter(request, prefix + "non_nego_ppd_knt", ""));
        setNonNegoCltKnt(JSPUtil.getParameter(request, prefix + "non_nego_clt_knt", ""));
        setBlIssTpCd(JSPUtil.getParameter(request, prefix + "bl_iss_tp_cd", ""));
        setFfrefno(JSPUtil.getParameter(request, prefix + "ffrefno", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocRqstVO[]
	 */
    public DocRqstVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocRqstVO[]
	 */
    public DocRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DocRqstVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] oblRtInclKnt = (JSPUtil.getParameter(request, prefix + "obl_rt_incl_knt", length));
            String[] nonNegoRtInclKnt = (JSPUtil.getParameter(request, prefix + "non_nego_rt_incl_knt", length));
            String[] nonNegoRtXcldKnt = (JSPUtil.getParameter(request, prefix + "non_nego_rt_xcld_knt", length));
            String[] rqstIssPlcNm = (JSPUtil.getParameter(request, prefix + "rqst_iss_plc_nm", length));
            String[] oblRtXcldKnt = (JSPUtil.getParameter(request, prefix + "obl_rt_xcld_knt", length));
            String[] cpyTtlKnt = (JSPUtil.getParameter(request, prefix + "cpy_ttl_knt", length));
            String[] blDocRqstRmk = (JSPUtil.getParameter(request, prefix + "bl_doc_rqst_rmk", length));
            String[] rqstIssDt = (JSPUtil.getParameter(request, prefix + "rqst_iss_dt", length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm", length));
            String[] blDeToCd = (JSPUtil.getParameter(request, prefix + "bl_de_to_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rqstBlTpCd = (JSPUtil.getParameter(request, prefix + "rqst_bl_tp_cd", length));
            String[] caflag = (JSPUtil.getParameter(request, prefix + "caflag", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] blDeMzdCd = (JSPUtil.getParameter(request, prefix + "bl_de_mzd_cd", length));
            String[] oblTtlKnt = (JSPUtil.getParameter(request, prefix + "obl_ttl_knt", length));
            String[] oblPpdKnt = (JSPUtil.getParameter(request, prefix + "obl_ppd_knt", length));
            String[] oblCltKnt = (JSPUtil.getParameter(request, prefix + "obl_clt_knt", length));
            String[] nonNegoPpdKnt = (JSPUtil.getParameter(request, prefix + "non_nego_ppd_knt", length));
            String[] nonNegoCltKnt = (JSPUtil.getParameter(request, prefix + "non_nego_clt_knt", length));
            String[] blIssTpCd = (JSPUtil.getParameter(request, prefix + "bl_iss_tp_cd", length));
            String[] ffrefno = (JSPUtil.getParameter(request, prefix + "ffrefno", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new DocRqstVO();
                if (oblRtInclKnt[i] != null)
                    model.setOblRtInclKnt(oblRtInclKnt[i]);
                if (nonNegoRtInclKnt[i] != null)
                    model.setNonNegoRtInclKnt(nonNegoRtInclKnt[i]);
                if (nonNegoRtXcldKnt[i] != null)
                    model.setNonNegoRtXcldKnt(nonNegoRtXcldKnt[i]);
                if (rqstIssPlcNm[i] != null)
                    model.setRqstIssPlcNm(rqstIssPlcNm[i]);
                if (oblRtXcldKnt[i] != null)
                    model.setOblRtXcldKnt(oblRtXcldKnt[i]);
                if (cpyTtlKnt[i] != null)
                    model.setCpyTtlKnt(cpyTtlKnt[i]);
                if (blDocRqstRmk[i] != null)
                    model.setBlDocRqstRmk(blDocRqstRmk[i]);
                if (rqstIssDt[i] != null)
                    model.setRqstIssDt(rqstIssDt[i]);
                if (locNm[i] != null)
                    model.setLocNm(locNm[i]);
                if (blDeToCd[i] != null)
                    model.setBlDeToCd(blDeToCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rqstBlTpCd[i] != null)
                    model.setRqstBlTpCd(rqstBlTpCd[i]);
                if (caflag[i] != null)
                    model.setCaflag(caflag[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (blDeMzdCd[i] != null)
                    model.setBlDeMzdCd(blDeMzdCd[i]);
                if (oblTtlKnt[i] != null)
                    model.setOblTtlKnt(oblTtlKnt[i]);
                if (oblPpdKnt[i] != null)
                    model.setOblPpdKnt(oblPpdKnt[i]);
                if (oblCltKnt[i] != null)
                    model.setOblCltKnt(oblCltKnt[i]);
                if (nonNegoPpdKnt != null)
                    model.setNonNegoPpdKnt(nonNegoPpdKnt[i]);
                if (nonNegoCltKnt != null)
                    model.setNonNegoCltKnt(nonNegoCltKnt[i]);
                if (blIssTpCd[i] != null) 
		    		model.setBlIssTpCd(blIssTpCd[i]);
                if (ffrefno[i] != null) 
		    		model.setFfrefno(ffrefno[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getDocRqstVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return DocRqstVO[]
	 */
    public DocRqstVO[] getDocRqstVOs() {
        DocRqstVO[] vos = (DocRqstVO[]) models.toArray(new DocRqstVO[models.size()]);
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
        this.oblRtInclKnt = this.oblRtInclKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoRtInclKnt = this.nonNegoRtInclKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoRtXcldKnt = this.nonNegoRtXcldKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstIssPlcNm = this.rqstIssPlcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblRtXcldKnt = this.oblRtXcldKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cpyTtlKnt = this.cpyTtlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blDocRqstRmk = this.blDocRqstRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstIssDt = this.rqstIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blDeToCd = this.blDeToCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstBlTpCd = this.rqstBlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caflag = this.caflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blDeMzdCd = this.blDeMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblTtlKnt = this.oblTtlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblPpdKnt = this.oblPpdKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblCltKnt = this.oblCltKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoPpdKnt = this.nonNegoPpdKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoCltKnt = this.nonNegoCltKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blIssTpCd = this.blIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffrefno = this.ffrefno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
