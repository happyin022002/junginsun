/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionFreeTimeVO.java
*@FileTitle : RFAExceptionFreeTimeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

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
public class RFAExceptionFreeTimeVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<RFAExceptionFreeTimeVO> models = new ArrayList<RFAExceptionFreeTimeVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rfaExptDarNo = null;

    /* Column Info */
    private String rfaExptMapgSeq = null;

    /* Column Info */
    private String rfaExptVerSeq = null;

    /* Column Info */
    private String rfaRqstDtlSeq = null;

    /* Column Info */
    private String cvrgCmbSeq = null;

    /* Column Info */
    private String ftSeq = null;

    /* Column Info */
    private String cntrFmQty = null;

    /* Column Info */
    private String cntrToQty = null;

    /* Column Info */
    private String ftDys = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String updOfcCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public RFAExceptionFreeTimeVO() {
    }

    public RFAExceptionFreeTimeVO(String ibflag, String pagerows, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String cvrgCmbSeq, String ftSeq, String cntrFmQty, String cntrToQty, String ftDys, String creUsrId, String updUsrId, String creOfcCd, String updOfcCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.rfaExptDarNo = rfaExptDarNo;
        this.rfaExptMapgSeq = rfaExptMapgSeq;
        this.rfaExptVerSeq = rfaExptVerSeq;
        this.rfaRqstDtlSeq = rfaRqstDtlSeq;
        this.cvrgCmbSeq = cvrgCmbSeq;
        this.ftSeq = ftSeq;
        this.cntrFmQty = cntrFmQty;
        this.cntrToQty = cntrToQty;
        this.ftDys = ftDys;
        this.creUsrId = creUsrId;
        this.updUsrId = updUsrId;
        this.creOfcCd = creOfcCd;
        this.updOfcCd = updOfcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
        this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
        this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
        this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
        this.hashColumns.put("cvrg_cmb_seq", getCvrgCmbSeq());
        this.hashColumns.put("ft_seq", getFtSeq());
        this.hashColumns.put("cntr_fm_qty", getCntrFmQty());
        this.hashColumns.put("cntr_to_qty", getCntrToQty());
        this.hashColumns.put("ft_dys", getFtDys());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
        this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
        this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
        this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
        this.hashFields.put("cvrg_cmb_seq", "cvrgCmbSeq");
        this.hashFields.put("ft_seq", "ftSeq");
        this.hashFields.put("cntr_fm_qty", "cntrFmQty");
        this.hashFields.put("cntr_to_qty", "cntrToQty");
        this.hashFields.put("ft_dys", "ftDys");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("upd_ofc_cd", "updOfcCd");
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
	 * @param String rfaExptDarNo
	 */
    public void setRfaExptDarNo(String rfaExptDarNo) {
        this.rfaExptDarNo = rfaExptDarNo;
    }

    /**
	 * 
	 * @return String rfaExptDarNo
	 */
    public String getRfaExptDarNo() {
        return this.rfaExptDarNo;
    }

    /**
	 *
	 * @param String rfaExptMapgSeq
	 */
    public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
        this.rfaExptMapgSeq = rfaExptMapgSeq;
    }

    /**
	 * 
	 * @return String rfaExptMapgSeq
	 */
    public String getRfaExptMapgSeq() {
        return this.rfaExptMapgSeq;
    }

    /**
	 *
	 * @param String rfaExptVerSeq
	 */
    public void setRfaExptVerSeq(String rfaExptVerSeq) {
        this.rfaExptVerSeq = rfaExptVerSeq;
    }

    /**
	 * 
	 * @return String rfaExptVerSeq
	 */
    public String getRfaExptVerSeq() {
        return this.rfaExptVerSeq;
    }

    /**
	 *
	 * @param String rfaRqstDtlSeq
	 */
    public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
        this.rfaRqstDtlSeq = rfaRqstDtlSeq;
    }

    /**
	 * 
	 * @return String rfaRqstDtlSeq
	 */
    public String getRfaRqstDtlSeq() {
        return this.rfaRqstDtlSeq;
    }

    /**
	 *
	 * @param String cvrgCmbSeq
	 */
    public void setCvrgCmbSeq(String cvrgCmbSeq) {
        this.cvrgCmbSeq = cvrgCmbSeq;
    }

    /**
	 * 
	 * @return String cvrgCmbSeq
	 */
    public String getCvrgCmbSeq() {
        return this.cvrgCmbSeq;
    }

    /**
	 *
	 * @param String ftSeq
	 */
    public void setFtSeq(String ftSeq) {
        this.ftSeq = ftSeq;
    }

    /**
	 * 
	 * @return String ftSeq
	 */
    public String getFtSeq() {
        return this.ftSeq;
    }

    /**
	 *
	 * @param String cntrFmQty
	 */
    public void setCntrFmQty(String cntrFmQty) {
        this.cntrFmQty = cntrFmQty;
    }

    /**
	 * 
	 * @return String cntrFmQty
	 */
    public String getCntrFmQty() {
        return this.cntrFmQty;
    }

    /**
	 *
	 * @param String cntrToQty
	 */
    public void setCntrToQty(String cntrToQty) {
        this.cntrToQty = cntrToQty;
    }

    /**
	 * 
	 * @return String cntrToQty
	 */
    public String getCntrToQty() {
        return this.cntrToQty;
    }

    /**
	 *
	 * @param String ftDys
	 */
    public void setFtDys(String ftDys) {
        this.ftDys = ftDys;
    }

    /**
	 * 
	 * @return String ftDys
	 */
    public String getFtDys() {
        return this.ftDys;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    public void setUpdOfcCd(String updOfcCd) {
        this.updOfcCd = updOfcCd;
    }

    public String getUpdOfcCd() {
        return this.updOfcCd;
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
        setRfaExptDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", ""));
        setRfaExptMapgSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", ""));
        setRfaExptVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", ""));
        setRfaRqstDtlSeq(JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", ""));
        setCvrgCmbSeq(JSPUtil.getParameter(request, prefix + "cvrg_cmb_seq", ""));
        setFtSeq(JSPUtil.getParameter(request, prefix + "ft_seq", ""));
        setCntrFmQty(JSPUtil.getParameter(request, prefix + "cntr_fm_qty", ""));
        setCntrToQty(JSPUtil.getParameter(request, prefix + "cntr_to_qty", ""));
        setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFAExceptionFreeTimeVO[]
	 */
    public RFAExceptionFreeTimeVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFAExceptionFreeTimeVO[]
	 */
    public RFAExceptionFreeTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        RFAExceptionFreeTimeVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", length));
            String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", length));
            String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", length));
            String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", length));
            String[] cvrgCmbSeq = (JSPUtil.getParameter(request, prefix + "cvrg_cmb_seq", length));
            String[] ftSeq = (JSPUtil.getParameter(request, prefix + "ft_seq", length));
            String[] cntrFmQty = (JSPUtil.getParameter(request, prefix + "cntr_fm_qty", length));
            String[] cntrToQty = (JSPUtil.getParameter(request, prefix + "cntr_to_qty", length));
            String[] ftDys = (JSPUtil.getParameter(request, prefix + "ft_dys", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
	    	String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new RFAExceptionFreeTimeVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rfaExptDarNo[i] != null)
                    model.setRfaExptDarNo(rfaExptDarNo[i]);
                if (rfaExptMapgSeq[i] != null)
                    model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
                if (rfaExptVerSeq[i] != null)
                    model.setRfaExptVerSeq(rfaExptVerSeq[i]);
                if (rfaRqstDtlSeq[i] != null)
                    model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
                if (cvrgCmbSeq[i] != null)
                    model.setCvrgCmbSeq(cvrgCmbSeq[i]);
                if (ftSeq[i] != null)
                    model.setFtSeq(ftSeq[i]);
                if (cntrFmQty[i] != null)
                    model.setCntrFmQty(cntrFmQty[i]);
                if (cntrToQty[i] != null)
                    model.setCntrToQty(cntrToQty[i]);
                if (ftDys[i] != null)
                    model.setFtDys(ftDys[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (creOfcCd[i] != null) 
		    		model.setCreOfcCd(creOfcCd[i]);
				if (updOfcCd[i] != null) 
		    		model.setUpdOfcCd(updOfcCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getRFAExceptionFreeTimeVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return RFAExceptionFreeTimeVO[]
	 */
    public RFAExceptionFreeTimeVO[] getRFAExceptionFreeTimeVOs() {
        RFAExceptionFreeTimeVO[] vos = (RFAExceptionFreeTimeVO[]) models.toArray(new RFAExceptionFreeTimeVO[models.size()]);
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
        this.rfaExptDarNo = this.rfaExptDarNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaExptMapgSeq = this.rfaExptMapgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaExptVerSeq = this.rfaExptVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaRqstDtlSeq = this.rfaRqstDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgCmbSeq = this.cvrgCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftSeq = this.ftSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrFmQty = this.cntrFmQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrToQty = this.cntrToQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDys = this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
