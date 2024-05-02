/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SendBkgFaxEmailVO.java
*@FileTitle : SendBkgFaxEmailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.20  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SendBkgFaxEmailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SendBkgFaxEmailVO> models = new ArrayList<SendBkgFaxEmailVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String eml = null;

    /* Column Info */
    private String displayHidden = null;

    /* Column Info */
    private String remark = null;

    /* Column Info */
    private String enable = null;

    /* Column Info */
    private String ord = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String emlSendDt = null;

    /* Column Info */
    private String frtPpdFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String frtCltFlg = null;

    /* Column Info */
    private String faxFailReason = null;

    /* Column Info */
    private String emlSender = null;

    /* Column Info */
    private String ntcKndNm = null;

    /* Column Info */
    private String emlSenderNm = null;

    /* Column Info */
    private String emlSendResult = null;

    /* Column Info */
    private String ntcKndCd = null;

    /* Column Info */
    private String frtAllFlg = null;

    /* Column Info */
    private String frtHdnFlg = null;

    /* Column Info */
    private String frtChgFlg = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String faxSendResult = null;

    /* Column Info */
    private String faxSender = null;

    /* Column Info */
    private String emlFailReason = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String frtArrFlg = null;

    /* Column Info */
    private String faxSendDt = null;

    /* Column Info */
    private String faxSenderNm = null;

    private String blEsigFlg = null;

    private String blCpyEsigFlg = null;

    /* Column Info */
    private String ydEml = null;
    
    private String frtTerm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SendBkgFaxEmailVO() {
    }

    public SendBkgFaxEmailVO(String ibflag, String pagerows, String ord, String ntcKndNm, String ntcKndCd, String faxNo, String faxSender, String faxSenderNm, String faxSendDt, String faxSendResult, String faxFailReason, String eml, String emlSender, String emlSenderNm, String emlSendDt, String emlSendResult, String emlFailReason, String frtAllFlg, String frtCltFlg, String frtPpdFlg, String frtChgFlg, String frtArrFlg, String frtHdnFlg, String displayHidden, String remark, String enable, String bkgNo, String porCd, String blEsigFlg, String blCpyEsigFlg, String ydEml, String frtTerm) {
        this.porCd = porCd;
        this.eml = eml;
        this.displayHidden = displayHidden;
        this.remark = remark;
        this.enable = enable;
        this.ord = ord;
        this.pagerows = pagerows;
        this.emlSendDt = emlSendDt;
        this.frtPpdFlg = frtPpdFlg;
        this.ibflag = ibflag;
        this.frtCltFlg = frtCltFlg;
        this.faxFailReason = faxFailReason;
        this.emlSender = emlSender;
        this.ntcKndNm = ntcKndNm;
        this.emlSenderNm = emlSenderNm;
        this.emlSendResult = emlSendResult;
        this.ntcKndCd = ntcKndCd;
        this.frtAllFlg = frtAllFlg;
        this.frtHdnFlg = frtHdnFlg;
        this.frtChgFlg = frtChgFlg;
        this.bkgNo = bkgNo;
        this.faxSendResult = faxSendResult;
        this.faxSender = faxSender;
        this.emlFailReason = emlFailReason;
        this.faxNo = faxNo;
        this.frtArrFlg = frtArrFlg;
        this.faxSendDt = faxSendDt;
        this.faxSenderNm = faxSenderNm;
        this.blEsigFlg = blEsigFlg;
        this.blCpyEsigFlg = blCpyEsigFlg;
        this.ydEml = ydEml;
        this.frtTerm = frtTerm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("eml", getEml());
        this.hashColumns.put("display_hidden", getDisplayHidden());
        this.hashColumns.put("remark", getRemark());
        this.hashColumns.put("enable", getEnable());
        this.hashColumns.put("ord", getOrd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("eml_send_dt", getEmlSendDt());
        this.hashColumns.put("frt_ppd_flg", getFrtPpdFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
        this.hashColumns.put("fax_fail_reason", getFaxFailReason());
        this.hashColumns.put("eml_sender", getEmlSender());
        this.hashColumns.put("ntc_knd_nm", getNtcKndNm());
        this.hashColumns.put("eml_sender_nm", getEmlSenderNm());
        this.hashColumns.put("eml_send_result", getEmlSendResult());
        this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
        this.hashColumns.put("frt_all_flg", getFrtAllFlg());
        this.hashColumns.put("frt_hdn_flg", getFrtHdnFlg());
        this.hashColumns.put("frt_chg_flg", getFrtChgFlg());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("fax_send_result", getFaxSendResult());
        this.hashColumns.put("fax_sender", getFaxSender());
        this.hashColumns.put("eml_fail_reason", getEmlFailReason());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("frt_arr_flg", getFrtArrFlg());
        this.hashColumns.put("fax_send_dt", getFaxSendDt());
        this.hashColumns.put("fax_sender_nm", getFaxSenderNm());
        this.hashColumns.put("bl_esig_flg", getBlEsigFlg());
        this.hashColumns.put("bl_cpy_esig_flg", getBlCpyEsigFlg());
        this.hashColumns.put("yd_eml", getYdEml());
        this.hashColumns.put("frt_term", getFrtTerm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("eml", "eml");
        this.hashFields.put("display_hidden", "displayHidden");
        this.hashFields.put("remark", "remark");
        this.hashFields.put("enable", "enable");
        this.hashFields.put("ord", "ord");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("eml_send_dt", "emlSendDt");
        this.hashFields.put("frt_ppd_flg", "frtPpdFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("frt_clt_flg", "frtCltFlg");
        this.hashFields.put("fax_fail_reason", "faxFailReason");
        this.hashFields.put("eml_sender", "emlSender");
        this.hashFields.put("ntc_knd_nm", "ntcKndNm");
        this.hashFields.put("eml_sender_nm", "emlSenderNm");
        this.hashFields.put("eml_send_result", "emlSendResult");
        this.hashFields.put("ntc_knd_cd", "ntcKndCd");
        this.hashFields.put("frt_all_flg", "frtAllFlg");
        this.hashFields.put("frt_hdn_flg", "frtHdnFlg");
        this.hashFields.put("frt_chg_flg", "frtChgFlg");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("fax_send_result", "faxSendResult");
        this.hashFields.put("fax_sender", "faxSender");
        this.hashFields.put("eml_fail_reason", "emlFailReason");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("frt_arr_flg", "frtArrFlg");
        this.hashFields.put("fax_send_dt", "faxSendDt");
        this.hashFields.put("fax_sender_nm", "faxSenderNm");
        this.hashFields.put("bl_esig_flg", "blEsigFlg");
        this.hashFields.put("bl_cpy_esig_flg", "blCpyEsigFlg");
        this.hashFields.put("yd_eml", "ydEml");
        this.hashFields.put("frt_term", "frtTerm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return eml
	 */
    public String getEml() {
        return this.eml;
    }

    /**
	 * Column Info
	 * @return displayHidden
	 */
    public String getDisplayHidden() {
        return this.displayHidden;
    }

    /**
	 * Column Info
	 * @return remark
	 */
    public String getRemark() {
        return this.remark;
    }

    /**
	 * Column Info
	 * @return enable
	 */
    public String getEnable() {
        return this.enable;
    }

    /**
	 * Column Info
	 * @return ord
	 */
    public String getOrd() {
        return this.ord;
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
	 * @return emlSendDt
	 */
    public String getEmlSendDt() {
        return this.emlSendDt;
    }

    /**
	 * Column Info
	 * @return frtPpdFlg
	 */
    public String getFrtPpdFlg() {
        return this.frtPpdFlg;
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
	 * @return frtCltFlg
	 */
    public String getFrtCltFlg() {
        return this.frtCltFlg;
    }

    /**
	 * Column Info
	 * @return faxFailReason
	 */
    public String getFaxFailReason() {
        return this.faxFailReason;
    }

    /**
	 * Column Info
	 * @return emlSender
	 */
    public String getEmlSender() {
        return this.emlSender;
    }

    /**
	 * Column Info
	 * @return ntcKndNm
	 */
    public String getNtcKndNm() {
        return this.ntcKndNm;
    }

    /**
	 * Column Info
	 * @return emlSenderNm
	 */
    public String getEmlSenderNm() {
        return this.emlSenderNm;
    }

    /**
	 * Column Info
	 * @return emlSendResult
	 */
    public String getEmlSendResult() {
        return this.emlSendResult;
    }

    /**
	 * Column Info
	 * @return ntcKndCd
	 */
    public String getNtcKndCd() {
        return this.ntcKndCd;
    }

    /**
	 * Column Info
	 * @return frtAllFlg
	 */
    public String getFrtAllFlg() {
        return this.frtAllFlg;
    }

    /**
	 * Column Info
	 * @return frtHdnFlg
	 */
    public String getFrtHdnFlg() {
        return this.frtHdnFlg;
    }

    /**
	 * Column Info
	 * @return frtChgFlg
	 */
    public String getFrtChgFlg() {
        return this.frtChgFlg;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return faxSendResult
	 */
    public String getFaxSendResult() {
        return this.faxSendResult;
    }

    /**
	 * Column Info
	 * @return faxSender
	 */
    public String getFaxSender() {
        return this.faxSender;
    }

    /**
	 * Column Info
	 * @return emlFailReason
	 */
    public String getEmlFailReason() {
        return this.emlFailReason;
    }

    /**
	 * Column Info
	 * @return faxNo
	 */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
	 * Column Info
	 * @return frtArrFlg
	 */
    public String getFrtArrFlg() {
        return this.frtArrFlg;
    }

    /**
	 * Column Info
	 * @return faxSendDt
	 */
    public String getFaxSendDt() {
        return this.faxSendDt;
    }

    /**
	 * Column Info
	 * @return faxSenderNm
	 */
    public String getFaxSenderNm() {
        return this.faxSenderNm;
    }

    /**
	 * Column Info
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param eml
	 */
    public void setEml(String eml) {
        this.eml = eml;
    }

    /**
	 * Column Info
	 * @param displayHidden
	 */
    public void setDisplayHidden(String displayHidden) {
        this.displayHidden = displayHidden;
    }

    /**
	 * Column Info
	 * @param remark
	 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
	 * Column Info
	 * @param enable
	 */
    public void setEnable(String enable) {
        this.enable = enable;
    }

    /**
	 * Column Info
	 * @param ord
	 */
    public void setOrd(String ord) {
        this.ord = ord;
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
	 * @param emlSendDt
	 */
    public void setEmlSendDt(String emlSendDt) {
        this.emlSendDt = emlSendDt;
    }

    /**
	 * Column Info
	 * @param frtPpdFlg
	 */
    public void setFrtPpdFlg(String frtPpdFlg) {
        this.frtPpdFlg = frtPpdFlg;
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
	 * @param frtCltFlg
	 */
    public void setFrtCltFlg(String frtCltFlg) {
        this.frtCltFlg = frtCltFlg;
    }

    /**
	 * Column Info
	 * @param faxFailReason
	 */
    public void setFaxFailReason(String faxFailReason) {
        this.faxFailReason = faxFailReason;
    }

    /**
	 * Column Info
	 * @param emlSender
	 */
    public void setEmlSender(String emlSender) {
        this.emlSender = emlSender;
    }

    /**
	 * Column Info
	 * @param ntcKndNm
	 */
    public void setNtcKndNm(String ntcKndNm) {
        this.ntcKndNm = ntcKndNm;
    }

    /**
	 * Column Info
	 * @param emlSenderNm
	 */
    public void setEmlSenderNm(String emlSenderNm) {
        this.emlSenderNm = emlSenderNm;
    }

    /**
	 * Column Info
	 * @param emlSendResult
	 */
    public void setEmlSendResult(String emlSendResult) {
        this.emlSendResult = emlSendResult;
    }

    /**
	 * Column Info
	 * @param ntcKndCd
	 */
    public void setNtcKndCd(String ntcKndCd) {
        this.ntcKndCd = ntcKndCd;
    }

    /**
	 * Column Info
	 * @param frtAllFlg
	 */
    public void setFrtAllFlg(String frtAllFlg) {
        this.frtAllFlg = frtAllFlg;
    }

    /**
	 * Column Info
	 * @param frtHdnFlg
	 */
    public void setFrtHdnFlg(String frtHdnFlg) {
        this.frtHdnFlg = frtHdnFlg;
    }

    /**
	 * Column Info
	 * @param frtChgFlg
	 */
    public void setFrtChgFlg(String frtChgFlg) {
        this.frtChgFlg = frtChgFlg;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param faxSendResult
	 */
    public void setFaxSendResult(String faxSendResult) {
        this.faxSendResult = faxSendResult;
    }

    /**
	 * Column Info
	 * @param faxSender
	 */
    public void setFaxSender(String faxSender) {
        this.faxSender = faxSender;
    }

    /**
	 * Column Info
	 * @param emlFailReason
	 */
    public void setEmlFailReason(String emlFailReason) {
        this.emlFailReason = emlFailReason;
    }

    /**
	 * Column Info
	 * @param faxNo
	 */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
	 * Column Info
	 * @param frtArrFlg
	 */
    public void setFrtArrFlg(String frtArrFlg) {
        this.frtArrFlg = frtArrFlg;
    }

    /**
	 * Column Info
	 * @param faxSendDt
	 */
    public void setFaxSendDt(String faxSendDt) {
        this.faxSendDt = faxSendDt;
    }

    /**
	 * Column Info
	 * @param faxSenderNm
	 */
    public void setFaxSenderNm(String faxSenderNm) {
        this.faxSenderNm = faxSenderNm;
    }

    /**
	 * @return the blEsigFlg
	 */
    public String getBlEsigFlg() {
        return this.blEsigFlg;
    }

    /**
	 * @return the blCpyEsigFlg
	 */
    public String getBlCpyEsigFlg() {
        return this.blCpyEsigFlg;
    }

    /**
	 * @param blEsigFlg the blEsigFlg to set
	 */
    public void setBlEsigFlg(String blEsigFlg) {
        this.blEsigFlg = blEsigFlg;
    }

    /**
	 * @param blCpyEsigFlg the blCpyEsigFlg to set
	 */
    public void setBlCpyEsigFlg(String blCpyEsigFlg) {
        this.blCpyEsigFlg = blCpyEsigFlg;
    }

    public void setYdEml(String ydEml) {
        this.ydEml = ydEml;
    }

    public String getYdEml() {
        return this.ydEml;
    }

    public String getFrtTerm() {
		return frtTerm;
	}

	public void setFrtTerm(String frtTerm) {
		this.frtTerm = frtTerm;
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
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setEml(JSPUtil.getParameter(request, prefix + "eml", ""));
        setDisplayHidden(JSPUtil.getParameter(request, prefix + "display_hidden", ""));
        setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
        setEnable(JSPUtil.getParameter(request, prefix + "enable", ""));
        setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setEmlSendDt(JSPUtil.getParameter(request, prefix + "eml_send_dt", ""));
        setFrtPpdFlg(JSPUtil.getParameter(request, prefix + "frt_ppd_flg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
        setFaxFailReason(JSPUtil.getParameter(request, prefix + "fax_fail_reason", ""));
        setEmlSender(JSPUtil.getParameter(request, prefix + "eml_sender", ""));
        setNtcKndNm(JSPUtil.getParameter(request, prefix + "ntc_knd_nm", ""));
        setEmlSenderNm(JSPUtil.getParameter(request, prefix + "eml_sender_nm", ""));
        setEmlSendResult(JSPUtil.getParameter(request, prefix + "eml_send_result", ""));
        setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
        setFrtAllFlg(JSPUtil.getParameter(request, prefix + "frt_all_flg", ""));
        setFrtHdnFlg(JSPUtil.getParameter(request, prefix + "frt_hdn_flg", ""));
        setFrtChgFlg(JSPUtil.getParameter(request, prefix + "frt_chg_flg", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setFaxSendResult(JSPUtil.getParameter(request, prefix + "fax_send_result", ""));
        setFaxSender(JSPUtil.getParameter(request, prefix + "fax_sender", ""));
        setEmlFailReason(JSPUtil.getParameter(request, prefix + "eml_fail_reason", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setFrtArrFlg(JSPUtil.getParameter(request, prefix + "frt_arr_flg", ""));
        setFaxSendDt(JSPUtil.getParameter(request, prefix + "fax_send_dt", ""));
        setFaxSenderNm(JSPUtil.getParameter(request, prefix + "fax_sender_nm", ""));
        setBlEsigFlg(JSPUtil.getParameter(request, prefix + "bl_esig_flg", ""));
        setBlCpyEsigFlg(JSPUtil.getParameter(request, prefix + "bl_cpy_esig_flg", ""));
        setYdEml(JSPUtil.getParameter(request, prefix + "yd_eml", ""));
        setFrtTerm(JSPUtil.getParameter(request, prefix + "frt_term", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendBkgFaxEmailVO[]
	 */
    public SendBkgFaxEmailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendBkgFaxEmailVO[]
	 */
    public SendBkgFaxEmailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SendBkgFaxEmailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] eml = (JSPUtil.getParameter(request, prefix + "eml", length));
            String[] displayHidden = (JSPUtil.getParameter(request, prefix + "display_hidden", length));
            String[] remark = (JSPUtil.getParameter(request, prefix + "remark", length));
            String[] enable = (JSPUtil.getParameter(request, prefix + "enable", length));
            String[] ord = (JSPUtil.getParameter(request, prefix + "ord", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] emlSendDt = (JSPUtil.getParameter(request, prefix + "eml_send_dt", length));
            String[] frtPpdFlg = (JSPUtil.getParameter(request, prefix + "frt_ppd_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] frtCltFlg = (JSPUtil.getParameter(request, prefix + "frt_clt_flg", length));
            String[] faxFailReason = (JSPUtil.getParameter(request, prefix + "fax_fail_reason", length));
            String[] emlSender = (JSPUtil.getParameter(request, prefix + "eml_sender", length));
            String[] ntcKndNm = (JSPUtil.getParameter(request, prefix + "ntc_knd_nm", length));
            String[] emlSenderNm = (JSPUtil.getParameter(request, prefix + "eml_sender_nm", length));
            String[] emlSendResult = (JSPUtil.getParameter(request, prefix + "eml_send_result", length));
            String[] ntcKndCd = (JSPUtil.getParameter(request, prefix + "ntc_knd_cd", length));
            String[] frtAllFlg = (JSPUtil.getParameter(request, prefix + "frt_all_flg", length));
            String[] frtHdnFlg = (JSPUtil.getParameter(request, prefix + "frt_hdn_flg", length));
            String[] frtChgFlg = (JSPUtil.getParameter(request, prefix + "frt_chg_flg", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] faxSendResult = (JSPUtil.getParameter(request, prefix + "fax_send_result", length));
            String[] faxSender = (JSPUtil.getParameter(request, prefix + "fax_sender", length));
            String[] emlFailReason = (JSPUtil.getParameter(request, prefix + "eml_fail_reason", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] frtArrFlg = (JSPUtil.getParameter(request, prefix + "frt_arr_flg", length));
            String[] faxSendDt = (JSPUtil.getParameter(request, prefix + "fax_send_dt", length));
            String[] faxSenderNm = (JSPUtil.getParameter(request, prefix + "fax_sender_nm", length));
            String[] blEsigFlg = (JSPUtil.getParameter(request, prefix + "bl_esig_flg", length));
            String[] blCpyEsigFlg = (JSPUtil.getParameter(request, prefix + "bl_cpy_esig_flg", length));
            String[] ydEml = (JSPUtil.getParameter(request, prefix + "yd_eml", length));
            String[] frtTerm = (JSPUtil.getParameter(request, prefix + "frt_term", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SendBkgFaxEmailVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (eml[i] != null)
                    model.setEml(eml[i]);
                if (displayHidden[i] != null)
                    model.setDisplayHidden(displayHidden[i]);
                if (remark[i] != null)
                    model.setRemark(remark[i]);
                if (enable[i] != null)
                    model.setEnable(enable[i]);
                if (ord[i] != null)
                    model.setOrd(ord[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (emlSendDt[i] != null)
                    model.setEmlSendDt(emlSendDt[i]);
                if (frtPpdFlg[i] != null)
                    model.setFrtPpdFlg(frtPpdFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (frtCltFlg[i] != null)
                    model.setFrtCltFlg(frtCltFlg[i]);
                if (faxFailReason[i] != null)
                    model.setFaxFailReason(faxFailReason[i]);
                if (emlSender[i] != null)
                    model.setEmlSender(emlSender[i]);
                if (ntcKndNm[i] != null)
                    model.setNtcKndNm(ntcKndNm[i]);
                if (emlSenderNm[i] != null)
                    model.setEmlSenderNm(emlSenderNm[i]);
                if (emlSendResult[i] != null)
                    model.setEmlSendResult(emlSendResult[i]);
                if (ntcKndCd[i] != null)
                    model.setNtcKndCd(ntcKndCd[i]);
                if (frtAllFlg[i] != null)
                    model.setFrtAllFlg(frtAllFlg[i]);
                if (frtHdnFlg[i] != null)
                    model.setFrtHdnFlg(frtHdnFlg[i]);
                if (frtChgFlg[i] != null)
                    model.setFrtChgFlg(frtChgFlg[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (faxSendResult[i] != null)
                    model.setFaxSendResult(faxSendResult[i]);
                if (faxSender[i] != null)
                    model.setFaxSender(faxSender[i]);
                if (emlFailReason[i] != null)
                    model.setEmlFailReason(emlFailReason[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (frtArrFlg[i] != null)
                    model.setFrtArrFlg(frtArrFlg[i]);
                if (faxSendDt[i] != null)
                    model.setFaxSendDt(faxSendDt[i]);
                if (faxSenderNm[i] != null)
                    model.setFaxSenderNm(faxSenderNm[i]);
                if (blEsigFlg[i] != null)
                    model.setBlEsigFlg(blEsigFlg[i]);
                if (blCpyEsigFlg[i] != null)
                    model.setBlCpyEsigFlg(blCpyEsigFlg[i]);
                if (ydEml[i] != null) 
		    		model.setYdEml(ydEml[i]);
                if (frtTerm[i] != null) 
		    		model.setFrtTerm(frtTerm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSendBkgFaxEmailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SendBkgFaxEmailVO[]
	 */
    public SendBkgFaxEmailVO[] getSendBkgFaxEmailVOs() {
        SendBkgFaxEmailVO[] vos = (SendBkgFaxEmailVO[]) models.toArray(new SendBkgFaxEmailVO[models.size()]);
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
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eml = this.eml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.displayHidden = this.displayHidden.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remark = this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.enable = this.enable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ord = this.ord.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSendDt = this.emlSendDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtPpdFlg = this.frtPpdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtCltFlg = this.frtCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxFailReason = this.faxFailReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSender = this.emlSender.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntcKndNm = this.ntcKndNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSenderNm = this.emlSenderNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSendResult = this.emlSendResult.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntcKndCd = this.ntcKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtAllFlg = this.frtAllFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtHdnFlg = this.frtHdnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtChgFlg = this.frtChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxSendResult = this.faxSendResult.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxSender = this.faxSender.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlFailReason = this.emlFailReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtArrFlg = this.frtArrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxSendDt = this.faxSendDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxSenderNm = this.faxSenderNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blEsigFlg = this.blEsigFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCpyEsigFlg = this.blCpyEsigFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydEml = this.ydEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtTerm = this.frtTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
