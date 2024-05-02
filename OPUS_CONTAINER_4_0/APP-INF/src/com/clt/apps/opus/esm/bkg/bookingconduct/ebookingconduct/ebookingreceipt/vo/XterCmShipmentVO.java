/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : XterCmShipmentVO.java
*@FileTitle : XterCmShipmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
public class XterCmShipmentVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<XterCmShipmentVO> models = new ArrayList<XterCmShipmentVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String xterRqstNo = null;

    /* Column Info */
    private String xterRqstSeq = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String mkDescSeq = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String cntrMfWgt = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String cntrMfMkDesc = null;

    /* Column Info */
    private String cntrMfDesc = null;

    /* Column Info */
    private String cntrMfDtlDesc = null;

    /* Column Info */
    private String hamoTrfCtnt = null;

    /* Column Info */
    private String ncmNo = null;

    /* Column Info */
    private String cmdtHsCd = null;

    /* Column Info */
    private String dcgoSeq = null;

    /* Column Info */
    private String cntrSeq = null;

    /* Column Info */
    private String poNo = null;

    /* Column Info */
    private String xterCntrSealNo = null;

    /* Column Info */
    private String cntrMfSeq = null;

    /* Column Info */
    private String cntrSealNo1 = null;

    /* Column Info */
    private String cntrSealNo2 = null;

    /* Column Info */
    private String cmdtDesc = null;

    /* Column Info */
    private String mkDesc = null;

    /* Column Info */
    private String hamoTrfCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public XterCmShipmentVO() {
    }

    public XterCmShipmentVO(String ibflag, String pagerows, String xterRqstNo, String xterRqstSeq, String cntrNo, String mkDescSeq, String pckQty, String pckTpCd, String cntrMfWgt, String wgtUtCd, String measQty, String measUtCd, String cntrMfMkDesc, String cntrMfDesc, String cntrMfDtlDesc, String hamoTrfCtnt, String ncmNo, String cmdtHsCd, String dcgoSeq, String cntrSeq, String poNo, String xterCntrSealNo, String cntrMfSeq, String cntrSealNo1, String cntrSealNo2, String cmdtDesc, String mkDesc, String hamoTrfCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.xterRqstNo = xterRqstNo;
        this.xterRqstSeq = xterRqstSeq;
        this.cntrNo = cntrNo;
        this.mkDescSeq = mkDescSeq;
        this.pckQty = pckQty;
        this.pckTpCd = pckTpCd;
        this.cntrMfWgt = cntrMfWgt;
        this.wgtUtCd = wgtUtCd;
        this.measQty = measQty;
        this.measUtCd = measUtCd;
        this.cntrMfMkDesc = cntrMfMkDesc;
        this.cntrMfDesc = cntrMfDesc;
        this.cntrMfDtlDesc = cntrMfDtlDesc;
        this.hamoTrfCtnt = hamoTrfCtnt;
        this.ncmNo = ncmNo;
        this.cmdtHsCd = cmdtHsCd;
        this.dcgoSeq = dcgoSeq;
        this.cntrSeq = cntrSeq;
        this.poNo = poNo;
        this.xterCntrSealNo = xterCntrSealNo;
        this.cntrMfSeq = cntrMfSeq;
        this.cntrSealNo1 = cntrSealNo1;
        this.cntrSealNo2 = cntrSealNo2;
        this.cmdtDesc = cmdtDesc;
        this.mkDesc = mkDesc;
        this.hamoTrfCd = hamoTrfCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("mk_desc_seq", getMkDescSeq());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
        this.hashColumns.put("cntr_mf_desc", getCntrMfDesc());
        this.hashColumns.put("cntr_mf_dtl_desc", getCntrMfDtlDesc());
        this.hashColumns.put("hamo_trf_ctnt", getHamoTrfCtnt());
        this.hashColumns.put("ncm_no", getNcmNo());
        this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
        this.hashColumns.put("dcgo_seq", getDcgoSeq());
        this.hashColumns.put("cntr_seq", getCntrSeq());
        this.hashColumns.put("po_no", getpoNo());
        this.hashColumns.put("xter_cntr_seal_no", getXterCntrSealNo());
        this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
        this.hashColumns.put("cntr_seal_no1", getCntrSealNo1());
        this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("mk_desc", getMkDesc());
        this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("mk_desc_seq", "mkDescSeq");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
        this.hashFields.put("cntr_mf_desc", "cntrMfDesc");
        this.hashFields.put("cntr_mf_dtl_desc", "cntrMfDtlDesc");
        this.hashFields.put("hamo_trf_ctnt", "hamoTrfCtnt");
        this.hashFields.put("ncm_no", "ncmNo");
        this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
        this.hashFields.put("dcgo_seq", "dcgoSeq");
        this.hashFields.put("cntr_seq", "cntrSeq");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("xter_cntr_seal_no", "xterCntrSealNo");
        this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
        this.hashFields.put("cntr_seal_no1", "cntrSealNo1");
        this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("mk_desc", "mkDesc");
        this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
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
	 * @param String xterRqstNo
	 */
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * 
	 * @return String xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    /**
	 *
	 * @param String xterRqstSeq
	 */
    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    /**
	 * 
	 * @return String xterRqstSeq
	 */
    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    /**
	 *
	 * @param String cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * 
	 * @return String cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 *
	 * @param String mkDescSeq
	 */
    public void setMkDescSeq(String mkDescSeq) {
        this.mkDescSeq = mkDescSeq;
    }

    /**
	 * 
	 * @return String mkDescSeq
	 */
    public String getMkDescSeq() {
        return this.mkDescSeq;
    }

    /**
	 *
	 * @param String pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * 
	 * @return String pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 *
	 * @param String pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * 
	 * @return String pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
    }

    /**
	 *
	 * @param String cntrMfWgt
	 */
    public void setCntrMfWgt(String cntrMfWgt) {
        this.cntrMfWgt = cntrMfWgt;
    }

    /**
	 * 
	 * @return String cntrMfWgt
	 */
    public String getCntrMfWgt() {
        return this.cntrMfWgt;
    }

    /**
	 *
	 * @param String wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * 
	 * @return String wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 *
	 * @param String measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * 
	 * @return String measQty
	 */
    public String getMeasQty() {
        return this.measQty;
    }

    /**
	 *
	 * @param String measUtCd
	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
    }

    /**
	 * 
	 * @return String measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
    }

    /**
	 *
	 * @param String cntrMfMkDesc
	 */
    public void setCntrMfMkDesc(String cntrMfMkDesc) {
        this.cntrMfMkDesc = cntrMfMkDesc;
    }

    /**
	 * 
	 * @return String cntrMfMkDesc
	 */
    public String getCntrMfMkDesc() {
        return this.cntrMfMkDesc;
    }

    /**
	 *
	 * @param String cntrMfDesc
	 */
    public void setCntrMfDesc(String cntrMfDesc) {
        this.cntrMfDesc = cntrMfDesc;
    }

    /**
	 * 
	 * @return String cntrMfDesc
	 */
    public String getCntrMfDesc() {
        return this.cntrMfDesc;
    }

    /**
	 *
	 * @param String cntrMfDtlDesc
	 */
    public void setCntrMfDtlDesc(String cntrMfDtlDesc) {
        this.cntrMfDtlDesc = cntrMfDtlDesc;
    }

    /**
	 * 
	 * @return String cntrMfDtlDesc
	 */
    public String getCntrMfDtlDesc() {
        return this.cntrMfDtlDesc;
    }

    /**
	 *
	 * @param String hamoTrfCtnt
	 */
    public void setHamoTrfCtnt(String hamoTrfCtnt) {
        this.hamoTrfCtnt = hamoTrfCtnt;
    }

    /**
	 * 
	 * @return String hamoTrfCtnt
	 */
    public String getHamoTrfCtnt() {
        return this.hamoTrfCtnt;
    }

    /**
	 *
	 * @param String ncmNo
	 */
    public void setNcmNo(String ncmNo) {
        this.ncmNo = ncmNo;
    }

    /**
	 * 
	 * @return String ncmNo
	 */
    public String getNcmNo() {
        return this.ncmNo;
    }

    /**
	 *
	 * @param String cmdtHsCd
	 */
    public void setCmdtHsCd(String cmdtHsCd) {
        this.cmdtHsCd = cmdtHsCd;
    }

    /**
	 * 
	 * @return String cmdtHsCd
	 */
    public String getCmdtHsCd() {
        return this.cmdtHsCd;
    }

    /**
	 *
	 * @param String dcgoSeq
	 */
    public void setDcgoSeq(String dcgoSeq) {
        this.dcgoSeq = dcgoSeq;
    }

    /**
	 * 
	 * @return String dcgoSeq
	 */
    public String getDcgoSeq() {
        return this.dcgoSeq;
    }

    /**
	 *
	 * @param String cntrSeq
	 */
    public void setCntrSeq(String cntrSeq) {
        this.cntrSeq = cntrSeq;
    }

    /**
	 * 
	 * @return String cntrSeq
	 */
    public String getCntrSeq() {
        return this.cntrSeq;
    }

    /**
	 *
	 * @param String poNo
	 */
    public void setpoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
	 * 
	 * @return String poNo
	 */
    public String getpoNo() {
        return this.poNo;
    }

    /**
	 *
	 * @param String xterCntrSealNo
	 */
    public void setXterCntrSealNo(String xterCntrSealNo) {
        this.xterCntrSealNo = xterCntrSealNo;
    }

    /**
	 * 
	 * @return String xterCntrSealNo
	 */
    public String getXterCntrSealNo() {
        return this.xterCntrSealNo;
    }

    public void setCntrMfSeq(String cntrMfSeq) {
        this.cntrMfSeq = cntrMfSeq;
    }

    public String getCntrMfSeq() {
        return this.cntrMfSeq;
    }

    public String getCntrSealNo1() {
        return cntrSealNo1;
    }

    public void setCntrSealNo1(String cntrSealNo1) {
        this.cntrSealNo1 = cntrSealNo1;
    }

    public String getCntrSealNo2() {
        return cntrSealNo2;
    }

    public void setCntrSealNo2(String cntrSealNo2) {
        this.cntrSealNo2 = cntrSealNo2;
    }

    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    public String getCmdtDesc() {
        return this.cmdtDesc;
    }

    public void setMkDesc(String mkDesc) {
        this.mkDesc = mkDesc;
    }

    public String getMkDesc() {
        return this.mkDesc;
    }

    public void setHamoTrfCd(String hamoTrfCd) {
        this.hamoTrfCd = hamoTrfCd;
    }

    public String getHamoTrfCd() {
        return this.hamoTrfCd;
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
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setMkDescSeq(JSPUtil.getParameter(request, prefix + "mk_desc_seq", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
        setCntrMfDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_desc", ""));
        setCntrMfDtlDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_dtl_desc", ""));
        setHamoTrfCtnt(JSPUtil.getParameter(request, prefix + "hamo_trf_ctnt", ""));
        setNcmNo(JSPUtil.getParameter(request, prefix + "ncm_no", ""));
        setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
        setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
        setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
        setpoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
        setXterCntrSealNo(JSPUtil.getParameter(request, prefix + "xter_cntr_seal_no", ""));
        setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
        setCntrSealNo1(JSPUtil.getParameter(request, prefix + "cntr_seal_no1", ""));
        setCntrSealNo2(JSPUtil.getParameter(request, prefix + "cntr_seal_no2", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
        setHamoTrfCd(JSPUtil.getParameter(request, prefix + "hamo_trf_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterCmShipmentVO[]
	 */
    public XterCmShipmentVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterCmShipmentVO[]
	 */
    public XterCmShipmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        XterCmShipmentVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no", length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] mkDescSeq = (JSPUtil.getParameter(request, prefix + "mk_desc_seq", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", length));
            String[] cntrMfDesc = (JSPUtil.getParameter(request, prefix + "cntr_mf_desc", length));
            String[] cntrMfDtlDesc = (JSPUtil.getParameter(request, prefix + "cntr_mf_dtl_desc", length));
            String[] hamoTrfCtnt = (JSPUtil.getParameter(request, prefix + "hamo_trf_ctnt", length));
            String[] ncmNo = (JSPUtil.getParameter(request, prefix + "ncm_no", length));
            String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", length));
            String[] dcgoSeq = (JSPUtil.getParameter(request, prefix + "dcgo_seq", length));
            String[] cntrSeq = (JSPUtil.getParameter(request, prefix + "cntr_seq", length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no", length));
            String[] xterCntrSealNo = (JSPUtil.getParameter(request, prefix + "xter_cntr_seal_no", length));
            String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix + "cntr_mf_seq", length));
            String[] cntrSealNo1 = (JSPUtil.getParameter(request, prefix + "cntr_seal_no1", length));
            String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix + "cntr_seal_no2", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] mkDesc = (JSPUtil.getParameter(request, prefix + "mk_desc", length));
            String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix + "hamo_trf_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new XterCmShipmentVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (mkDescSeq[i] != null)
                    model.setMkDescSeq(mkDescSeq[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (cntrMfWgt[i] != null)
                    model.setCntrMfWgt(cntrMfWgt[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (cntrMfMkDesc[i] != null)
                    model.setCntrMfMkDesc(cntrMfMkDesc[i]);
                if (cntrMfDesc[i] != null)
                    model.setCntrMfDesc(cntrMfDesc[i]);
                if (cntrMfDtlDesc[i] != null)
                    model.setCntrMfDtlDesc(cntrMfDtlDesc[i]);
                if (hamoTrfCtnt[i] != null)
                    model.setHamoTrfCtnt(hamoTrfCtnt[i]);
                if (ncmNo[i] != null)
                    model.setNcmNo(ncmNo[i]);
                if (cmdtHsCd[i] != null)
                    model.setCmdtHsCd(cmdtHsCd[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (cntrSeq[i] != null)
                    model.setCntrSeq(cntrSeq[i]);
                if (poNo[i] != null)
                    model.setpoNo(poNo[i]);
                if (xterCntrSealNo[i] != null)
                    model.setXterCntrSealNo(xterCntrSealNo[i]);
                if (cntrMfSeq[i] != null)
                    model.setCntrMfSeq(cntrMfSeq[i]);
                if (cntrSealNo1[i] != null)
                    model.setCntrSealNo1(cntrSealNo1[i]);
                if (cntrSealNo2[i] != null)
                    model.setCntrSealNo2(cntrSealNo2[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (mkDesc[i] != null)
                    model.setMkDesc(mkDesc[i]);
                if (hamoTrfCd[i] != null) 
		    		model.setHamoTrfCd(hamoTrfCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getXterCmShipmentVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return XterCmShipmentVO[]
	 */
    public XterCmShipmentVO[] getXterCmShipmentVOs() {
        XterCmShipmentVO[] vos = (XterCmShipmentVO[]) models.toArray(new XterCmShipmentVO[models.size()]);
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
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mkDescSeq = this.mkDescSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfWgt = this.cntrMfWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfMkDesc = this.cntrMfMkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfDesc = this.cntrMfDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfDtlDesc = this.cntrMfDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hamoTrfCtnt = this.hamoTrfCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ncmNo = this.ncmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtHsCd = this.cmdtHsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoSeq = this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSeq = this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterCntrSealNo = this.xterCntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfSeq = this.cntrMfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo1 = this.cntrSealNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo2 = this.cntrSealNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mkDesc = this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hamoTrfCd = this.hamoTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
