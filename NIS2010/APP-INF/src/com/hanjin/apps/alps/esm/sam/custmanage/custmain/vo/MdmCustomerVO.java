/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MdmCustomerVO.java
*@FileTitle : MdmCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.16
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.05.16 박찬민 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박찬민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MdmCustomerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MdmCustomerVO> models = new ArrayList<MdmCustomerVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String kmanOfcPhnNo = null;

    /* Column Info */
    private String kmanMarrFlg = null;

    /* Column Info */
    private String customerCode = null;

    /* Column Info */
    private String jbTitRmk = null;

    /* Column Info */
    private String kmanN1stNm = null;

    /* Column Info */
    private String kmanEml = null;

    /* Column Info */
    private String kmanOfcFaxNo = null;

    /* Column Info */
    private String custKmanSeq = null;

    /* Column Info */
    private String kmanLstNm = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String bookingAlertToDate = null;

    /* Column Info */
    private String ffFmcNo = null;

    /* Column Info */
    private String noUse = null;

    /* Column Info */
    private String mrgCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String custStsCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String bzetAddr = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String custEml = null;

    /* Column Info */
    private String pagerows = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String locationCode = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String ctyNm = null;

    /* Column Info */
    private String custDivFlag = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String nmdCustFlg = null;

    /* Column Info */
    private String deltFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public MdmCustomerVO() {
    }

    public MdmCustomerVO(String ibflag, String pagerows, String custKmanSeq, String kmanN1stNm, String kmanLstNm, String kmanMarrFlg, String jbTitRmk, String intlPhnNo, String kmanOfcPhnNo, String kmanOfcFaxNo, String kmanEml, String customerCode, String phnNo, String bookingAlertToDate, String ffFmcNo, String noUse, String mrgCd, String creDt, String custStsCd, String custSeq, String bzetAddr, String srepCd, String custEml, String custLglEngNm, String locationCode, String ofcCd, String zipCd, String custCd, String faxNo, String ctyNm, String custDivFlag, String steCd, String custCntCd, String creUsrId, String updUsrId, String nmdCustFlg, String deltFlg) {
        this.ibflag = ibflag;
        this.kmanOfcPhnNo = kmanOfcPhnNo;
        this.kmanMarrFlg = kmanMarrFlg;
        this.customerCode = customerCode;
        this.jbTitRmk = jbTitRmk;
        this.kmanN1stNm = kmanN1stNm;
        this.kmanEml = kmanEml;
        this.kmanOfcFaxNo = kmanOfcFaxNo;
        this.custKmanSeq = custKmanSeq;
        this.kmanLstNm = kmanLstNm;
        this.intlPhnNo = intlPhnNo;
        this.pagerows = pagerows;
        this.phnNo = phnNo;
        this.bookingAlertToDate = bookingAlertToDate;
        this.ffFmcNo = ffFmcNo;
        this.noUse = noUse;
        this.mrgCd = mrgCd;
        this.creDt = creDt;
        this.custStsCd = custStsCd;
        this.custSeq = custSeq;
        this.bzetAddr = bzetAddr;
        this.srepCd = srepCd;
        this.custEml = custEml;
        this.custLglEngNm = custLglEngNm;
        this.locationCode = locationCode;
        this.ofcCd = ofcCd;
        this.zipCd = zipCd;
        this.custCd = custCd;
        this.faxNo = faxNo;
        this.ctyNm = ctyNm;
        this.custDivFlag = custDivFlag;
        this.steCd = steCd;
        this.custCntCd = custCntCd;
        this.creUsrId = creUsrId;
        this.updUsrId = updUsrId;
        this.nmdCustFlg = nmdCustFlg;
        this.deltFlg = deltFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("kman_ofc_phn_no", getKmanOfcPhnNo());
        this.hashColumns.put("kman_marr_flg", getKmanMarrFlg());
        this.hashColumns.put("customer_code", getCustomerCode());
        this.hashColumns.put("jb_tit_rmk", getJbTitRmk());
        this.hashColumns.put("kman_n1st_nm", getKmanN1stNm());
        this.hashColumns.put("kman_eml", getKmanEml());
        this.hashColumns.put("kman_ofc_fax_no", getKmanOfcFaxNo());
        this.hashColumns.put("cust_kman_seq", getCustKmanSeq());
        this.hashColumns.put("kman_lst_nm", getKmanLstNm());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("booking_alert_to_date", getBookingAlertToDate());
        this.hashColumns.put("ff_fmc_no", getFfFmcNo());
        this.hashColumns.put("no_use", getNoUse());
        this.hashColumns.put("mrg_cd", getMrgCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cust_sts_cd", getCustStsCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bzet_addr", getBzetAddr());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("cust_eml", getCustEml());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("location_code", getLocationCode());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("cty_nm", getCtyNm());
        this.hashColumns.put("cust_div_flag", getCustDivFlag());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
        this.hashColumns.put("delt_flg", getDeltFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("kman_ofc_phn_no", "kmanOfcPhnNo");
        this.hashFields.put("kman_marr_flg", "kmanMarrFlg");
        this.hashFields.put("customer_code", "customerCode");
        this.hashFields.put("jb_tit_rmk", "jbTitRmk");
        this.hashFields.put("kman_n1st_nm", "kmanN1stNm");
        this.hashFields.put("kman_eml", "kmanEml");
        this.hashFields.put("kman_ofc_fax_no", "kmanOfcFaxNo");
        this.hashFields.put("cust_kman_seq", "custKmanSeq");
        this.hashFields.put("kman_lst_nm", "kmanLstNm");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("booking_alert_to_date", "bookingAlertToDate");
        this.hashFields.put("ff_fmc_no", "ffFmcNo");
        this.hashFields.put("no_use", "noUse");
        this.hashFields.put("mrg_cd", "mrgCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cust_sts_cd", "custStsCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bzet_addr", "bzetAddr");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("cust_eml", "custEml");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("location_code", "locationCode");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("cty_nm", "ctyNm");
        this.hashFields.put("cust_div_flag", "custDivFlag");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
        this.hashFields.put("delt_flg", "deltFlg");
        return this.hashFields;
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
	 * @return kmanOfcPhnNo
	 */
    public String getKmanOfcPhnNo() {
        return this.kmanOfcPhnNo;
    }

    /**
	 * Column Info
	 * @return kmanMarrFlg
	 */
    public String getKmanMarrFlg() {
        return this.kmanMarrFlg;
    }

    /**
	 * Column Info
	 * @return customerCode
	 */
    public String getCustomerCode() {
        return this.customerCode;
    }

    /**
	 * Column Info
	 * @return jbTitRmk
	 */
    public String getJbTitRmk() {
        return this.jbTitRmk;
    }

    /**
	 * Column Info
	 * @return kmanN1stNm
	 */
    public String getKmanN1stNm() {
        return this.kmanN1stNm;
    }

    /**
	 * Column Info
	 * @return kmanEml
	 */
    public String getKmanEml() {
        return this.kmanEml;
    }

    /**
	 * Column Info
	 * @return kmanOfcFaxNo
	 */
    public String getKmanOfcFaxNo() {
        return this.kmanOfcFaxNo;
    }

    /**
	 * Column Info
	 * @return custKmanSeq
	 */
    public String getCustKmanSeq() {
        return this.custKmanSeq;
    }

    /**
	 * Column Info
	 * @return kmanLstNm
	 */
    public String getKmanLstNm() {
        return this.kmanLstNm;
    }

    /**
	 * Column Info
	 * @return intlPhnNo
	 */
    public String getIntlPhnNo() {
        return this.intlPhnNo;
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
	 * @param kmanOfcPhnNo
	 */
    public void setKmanOfcPhnNo(String kmanOfcPhnNo) {
        this.kmanOfcPhnNo = kmanOfcPhnNo;
    }

    /**
	 * Column Info
	 * @param kmanMarrFlg
	 */
    public void setKmanMarrFlg(String kmanMarrFlg) {
        this.kmanMarrFlg = kmanMarrFlg;
    }

    /**
	 * Column Info
	 * @param customerCode
	 */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
	 * Column Info
	 * @param jbTitRmk
	 */
    public void setJbTitRmk(String jbTitRmk) {
        this.jbTitRmk = jbTitRmk;
    }

    /**
	 * Column Info
	 * @param kmanN1stNm
	 */
    public void setKmanN1stNm(String kmanN1stNm) {
        this.kmanN1stNm = kmanN1stNm;
    }

    /**
	 * Column Info
	 * @param kmanEml
	 */
    public void setKmanEml(String kmanEml) {
        this.kmanEml = kmanEml;
    }

    /**
	 * Column Info
	 * @param kmanOfcFaxNo
	 */
    public void setKmanOfcFaxNo(String kmanOfcFaxNo) {
        this.kmanOfcFaxNo = kmanOfcFaxNo;
    }

    /**
	 * Column Info
	 * @param custKmanSeq
	 */
    public void setCustKmanSeq(String custKmanSeq) {
        this.custKmanSeq = custKmanSeq;
    }

    /**
	 * Column Info
	 * @param kmanLstNm
	 */
    public void setKmanLstNm(String kmanLstNm) {
        this.kmanLstNm = kmanLstNm;
    }

    /**
	 * Column Info
	 * @param intlPhnNo
	 */
    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getPhnNo() {
        return this.phnNo;
    }

    public void setBookingAlertToDate(String bookingAlertToDate) {
        this.bookingAlertToDate = bookingAlertToDate;
    }

    public String getBookingAlertToDate() {
        return this.bookingAlertToDate;
    }

    public void setFfFmcNo(String ffFmcNo) {
        this.ffFmcNo = ffFmcNo;
    }

    public String getFfFmcNo() {
        return this.ffFmcNo;
    }

    public void setNoUse(String noUse) {
        this.noUse = noUse;
    }

    public String getNoUse() {
        return this.noUse;
    }

    public void setMrgCd(String mrgCd) {
        this.mrgCd = mrgCd;
    }

    public String getMrgCd() {
        return this.mrgCd;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setCustStsCd(String custStsCd) {
        this.custStsCd = custStsCd;
    }

    public String getCustStsCd() {
        return this.custStsCd;
    }

    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    public String getCustSeq() {
        return this.custSeq;
    }

    public void setBzetAddr(String bzetAddr) {
        this.bzetAddr = bzetAddr;
    }

    public String getBzetAddr() {
        return this.bzetAddr;
    }

    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    public String getSrepCd() {
        return this.srepCd;
    }

    public void setCustEml(String custEml) {
        this.custEml = custEml;
    }

    public String getCustEml() {
        return this.custEml;
    }

    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public String getPagerows() {
        return this.pagerows;
    }

    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getZipCd() {
        return this.zipCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getFaxNo() {
        return this.faxNo;
    }

    public void setCtyNm(String ctyNm) {
        this.ctyNm = ctyNm;
    }

    public String getCtyNm() {
        return this.ctyNm;
    }

    public void setCustDivFlag(String custDivFlag) {
        this.custDivFlag = custDivFlag;
    }

    public String getCustDivFlag() {
        return this.custDivFlag;
    }

    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    public String getSteCd() {
        return this.steCd;
    }

    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public String getCustCntCd() {
        return this.custCntCd;
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

    public void setNmdCustFlg(String nmdCustFlg) {
        this.nmdCustFlg = nmdCustFlg;
    }

    public String getNmdCustFlg() {
        return this.nmdCustFlg;
    }

    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    public String getDeltFlg() {
        return this.deltFlg;
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
        setKmanOfcPhnNo(JSPUtil.getParameter(request, prefix + "kman_ofc_phn_no", ""));
        setKmanMarrFlg(JSPUtil.getParameter(request, prefix + "kman_marr_flg", ""));
        setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
        setJbTitRmk(JSPUtil.getParameter(request, prefix + "jb_tit_rmk", ""));
        setKmanN1stNm(JSPUtil.getParameter(request, prefix + "kman_n1st_nm", ""));
        setKmanEml(JSPUtil.getParameter(request, prefix + "kman_eml", ""));
        setKmanOfcFaxNo(JSPUtil.getParameter(request, prefix + "kman_ofc_fax_no", ""));
        setCustKmanSeq(JSPUtil.getParameter(request, prefix + "cust_kman_seq", ""));
        setKmanLstNm(JSPUtil.getParameter(request, prefix + "kman_lst_nm", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setBookingAlertToDate(JSPUtil.getParameter(request, prefix + "booking_alert_to_date", ""));
        setFfFmcNo(JSPUtil.getParameter(request, prefix + "ff_fmc_no", ""));
        setNoUse(JSPUtil.getParameter(request, prefix + "no_use", ""));
        setMrgCd(JSPUtil.getParameter(request, prefix + "mrg_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setLocationCode(JSPUtil.getParameter(request, prefix + "location_code", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
        setCustDivFlag(JSPUtil.getParameter(request, prefix + "cust_div_flag", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmCustomerVO[]
	 */
    public MdmCustomerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmCustomerVO[]
	 */
    public MdmCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MdmCustomerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] kmanOfcPhnNo = (JSPUtil.getParameter(request, prefix + "kman_ofc_phn_no", length));
            String[] kmanMarrFlg = (JSPUtil.getParameter(request, prefix + "kman_marr_flg", length));
            String[] customerCode = (JSPUtil.getParameter(request, prefix + "customer_code", length));
            String[] jbTitRmk = (JSPUtil.getParameter(request, prefix + "jb_tit_rmk", length));
            String[] kmanN1stNm = (JSPUtil.getParameter(request, prefix + "kman_n1st_nm", length));
            String[] kmanEml = (JSPUtil.getParameter(request, prefix + "kman_eml", length));
            String[] kmanOfcFaxNo = (JSPUtil.getParameter(request, prefix + "kman_ofc_fax_no", length));
            String[] custKmanSeq = (JSPUtil.getParameter(request, prefix + "cust_kman_seq", length));
            String[] kmanLstNm = (JSPUtil.getParameter(request, prefix + "kman_lst_nm", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] bookingAlertToDate = (JSPUtil.getParameter(request, prefix + "booking_alert_to_date", length));
            String[] ffFmcNo = (JSPUtil.getParameter(request, prefix + "ff_fmc_no", length));
            String[] noUse = (JSPUtil.getParameter(request, prefix + "no_use", length));
            String[] mrgCd = (JSPUtil.getParameter(request, prefix + "mrg_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] custStsCd = (JSPUtil.getParameter(request, prefix + "cust_sts_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] bzetAddr = (JSPUtil.getParameter(request, prefix + "bzet_addr", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] custEml = (JSPUtil.getParameter(request, prefix + "cust_eml", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] locationCode = (JSPUtil.getParameter(request, prefix + "location_code", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] ctyNm = (JSPUtil.getParameter(request, prefix + "cty_nm", length));
            String[] custDivFlag = (JSPUtil.getParameter(request, prefix + "cust_div_flag", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix + "nmd_cust_flg", length));
            /* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MdmCustomerVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (kmanOfcPhnNo[i] != null)
                    model.setKmanOfcPhnNo(kmanOfcPhnNo[i]);
                if (kmanMarrFlg[i] != null)
                    model.setKmanMarrFlg(kmanMarrFlg[i]);
                if (customerCode[i] != null)
                    model.setCustomerCode(customerCode[i]);
                if (jbTitRmk[i] != null)
                    model.setJbTitRmk(jbTitRmk[i]);
                if (kmanN1stNm[i] != null)
                    model.setKmanN1stNm(kmanN1stNm[i]);
                if (kmanEml[i] != null)
                    model.setKmanEml(kmanEml[i]);
                if (kmanOfcFaxNo[i] != null)
                    model.setKmanOfcFaxNo(kmanOfcFaxNo[i]);
                if (custKmanSeq[i] != null)
                    model.setCustKmanSeq(custKmanSeq[i]);
                if (kmanLstNm[i] != null)
                    model.setKmanLstNm(kmanLstNm[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (bookingAlertToDate[i] != null)
                    model.setBookingAlertToDate(bookingAlertToDate[i]);
                if (ffFmcNo[i] != null)
                    model.setFfFmcNo(ffFmcNo[i]);
                if (noUse[i] != null)
                    model.setNoUse(noUse[i]);
                if (mrgCd[i] != null)
                    model.setMrgCd(mrgCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (custStsCd[i] != null)
                    model.setCustStsCd(custStsCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (bzetAddr[i] != null)
                    model.setBzetAddr(bzetAddr[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (custEml[i] != null)
                    model.setCustEml(custEml[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (locationCode[i] != null)
                    model.setLocationCode(locationCode[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (ctyNm[i] != null)
                    model.setCtyNm(ctyNm[i]);
                if (custDivFlag[i] != null)
                    model.setCustDivFlag(custDivFlag[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (nmdCustFlg[i] != null)
                    model.setNmdCustFlg(nmdCustFlg[i]);
                /* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMdmCustomerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MdmCustomerVO[]
	 */
    public MdmCustomerVO[] getMdmCustomerVOs() {
        MdmCustomerVO[] vos = (MdmCustomerVO[]) models.toArray(new MdmCustomerVO[models.size()]);
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
        this.kmanOfcPhnNo = this.kmanOfcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kmanMarrFlg = this.kmanMarrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.customerCode = this.customerCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.jbTitRmk = this.jbTitRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kmanN1stNm = this.kmanN1stNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kmanEml = this.kmanEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kmanOfcFaxNo = this.kmanOfcFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custKmanSeq = this.custKmanSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kmanLstNm = this.kmanLstNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bookingAlertToDate = this.bookingAlertToDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffFmcNo = this.ffFmcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noUse = this.noUse.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrgCd = this.mrgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custStsCd = this.custStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetAddr = this.bzetAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custEml = this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locationCode = this.locationCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctyNm = this.ctyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custDivFlag = this.custDivFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nmdCustFlg = this.nmdCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
