/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgBlNoVO.java
*@FileTitle : BkgBlNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.04.01 이진서 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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
public class BkgBlNoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgBlNoVO> models = new ArrayList<BkgBlNoVO>();

    /* Column Info */
    private String ncbNo = null;

    /* Column Info */
    private String caExistFlg = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String mapSeq = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String blTpCd = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String pageType = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String blNoChk = null;

    /* Column Info */
    private String applicationDate = null;

    /* Column Info */
    private String caNo = null;

    /* Column Info */
    private String caFlg = null;

    /* Column Info */
    private String caUsrId = null;

    /* Column Info */
    private String xterBkgRqstCd = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String xterRmk = null;

    /* Column Info */
    private String bkgCntcPsonEml = null;

    /* Column Info */
    private String xterBkgRqstRefNo = null;

    private String blEsigFlg = null;

    private String blCpyEsigFlg = null;

    private String blKntFlg = null;

    /* Column Info */
    private String ediType = null;

    /* Column Info */
    private String bkgWtChkFlg = null;

    /* Column Info */
    private String ediHldFlg = null;

    /* Column Info */
    private String fCmd = null;

    /* Column Info */
    private String bkgPolCd = null;

    /* Column Info */
    private String qtyModifyFlag = null;

    /* Column Info */
    private String hisUiNm = null;

    /* Column Info */
    private String bkgTyFlg = null;

    /* Column Info */
    private String usrToyotaCheck = null;

    private String updateMtPkup = null;

    private String updateFullRtnYdCd = null;

    /* Column Info */
    private String message = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String sndId = null;

    /* Column Info */
    private String ntcKndCd = null;

    /* Column Info */
    private String eml = null;

    /* Column Info */
    private String remark = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgBlNoVO() {
    }

    public BkgBlNoVO(String ibflag, String pagerows, String ncbNo, String caExistFlg, String bdrFlg, String bkgStsCd, String mapSeq, String blNo, String blTpCd, String pctlNo, String polCd, String bkgNo, String blNoChk, String caNo, String caFlg, String caUsrId, String applicationDate, String pageType, String xterBkgRqstCd, String bkgOfcCd, String xterRmk, String bkgCntcPsonEml, String xterBkgRqstRefNo, String blEsigFlg, String blCpyEsigFlg, String blKntFlg, String ediType, String bkgWtChkFlg, String ediHldFlg, String fCmd, String bkgPolCd, String qtyModifyFlag, String hisUiNm, String bkgTyFlg, String usrToyotaCheck, String updateMtPkup, String updateFullRtnYdCd, String message, String cntrNo, String sndId, String ntcKndCd, String eml, String remark) {
        this.ncbNo = ncbNo;
        this.caExistFlg = caExistFlg;
        this.bdrFlg = bdrFlg;
        this.bkgStsCd = bkgStsCd;
        this.mapSeq = mapSeq;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.blTpCd = blTpCd;
        this.pctlNo = pctlNo;
        this.pageType = pageType;
        this.ibflag = ibflag;
        this.polCd = polCd;
        this.bkgNo = bkgNo;
        this.blNoChk = blNoChk;
        this.applicationDate = applicationDate;
        this.caNo = caNo;
        this.caFlg = caFlg;
        this.caUsrId = caUsrId;
        this.xterBkgRqstCd = xterBkgRqstCd;
        this.bkgOfcCd = bkgOfcCd;
        this.xterRmk = xterRmk;
        this.bkgCntcPsonEml = bkgCntcPsonEml;
        this.xterBkgRqstRefNo = xterBkgRqstRefNo;
        this.blEsigFlg = blEsigFlg;
        this.blCpyEsigFlg = blCpyEsigFlg;
        this.blKntFlg = blKntFlg;
        this.ediType = ediType;
        this.bkgWtChkFlg = bkgWtChkFlg;
        this.ediHldFlg = ediHldFlg;
        this.fCmd = fCmd;
        this.bkgPolCd = bkgPolCd;
        this.qtyModifyFlag = qtyModifyFlag;
        this.hisUiNm = hisUiNm;
        this.bkgTyFlg = bkgTyFlg;
        this.usrToyotaCheck = usrToyotaCheck;
        this.updateMtPkup = updateMtPkup;
        this.updateFullRtnYdCd = updateFullRtnYdCd;
        this.message = message;
        this.cntrNo = cntrNo;
        this.sndId = sndId;
        this.ntcKndCd = ntcKndCd;
        this.eml = eml;
        this.remark = remark;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ncb_no", getNcbNo());
        this.hashColumns.put("ca_exist_flg", getCaExistFlg());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("map_seq", getMapSeq());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bl_tp_cd", getBlTpCd());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("page_type", getPageType());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bl_no_chk", getBlNoChk());
        this.hashColumns.put("application_date", getApplicationDate());
        this.hashColumns.put("ca_no", getCaNo());
        this.hashColumns.put("ca_flg", getCaFlg());
        this.hashColumns.put("ca_usr_id", getCaUsrId());
        this.hashColumns.put("xter_bkg_rqst_cd", getXterBkgRqstCd());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("xter_rmk", getXterRmk());
        this.hashColumns.put("bkg_cntc_pson_eml", getBkgCntcPsonEml());
        this.hashColumns.put("xter_bkg_rqst_ref_no", getXterBkgRqstRefNo());
        this.hashColumns.put("bl_esig_flg", getBlEsigFlg());
        this.hashColumns.put("bl_cpy_esig_flg", getBlCpyEsigFlg());
        this.hashColumns.put("bl_knt_flg", getBlKntFlg());
        this.hashColumns.put("edi_type", getEdiType());
        this.hashColumns.put("bkg_wt_chk_flg", getBkgWtChkFlg());
        this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
        this.hashColumns.put("f_cmd", getFCmd());
        this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
        this.hashColumns.put("qty_modify_flag", getQtyModifyFlag());
        this.hashColumns.put("his_ui_nm", getHisUiNm());
        this.hashColumns.put("bkg_ty_flg", getBkgTyFlg());
        this.hashColumns.put("usr_toyota_check", getUsrToyotaCheck());
        this.hashColumns.put("update_mt_pkup", getUpdateMtPkup());
        this.hashColumns.put("update_full_rtn_yd_cd", getUpdateFullRtnYdCd());
        this.hashColumns.put("message", getMessage());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("snd_id", getSndId());
        this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
        this.hashColumns.put("eml", getEml());
        this.hashColumns.put("remark", getRemark());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ncb_no", "ncbNo");
        this.hashFields.put("ca_exist_flg", "caExistFlg");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("map_seq", "mapSeq");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bl_tp_cd", "blTpCd");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("page_type", "pageType");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bl_no_chk", "blNoChk");
        this.hashFields.put("application_date", "applicationDate");
        this.hashFields.put("ca_no", "caNo");
        this.hashFields.put("ca_flg", "caFlg");
        this.hashFields.put("ca_usr_id", "caUsrId");
        this.hashFields.put("xter_bkg_rqst_cd", "xterBkgRqstCd");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("xter_rmk", "xterRmk");
        this.hashFields.put("bkg_cntc_pson_eml", "bkgCntcPsonEml");
        this.hashFields.put("xter_bkg_rqst_ref_no", "xterBkgRqstRefNo");
        this.hashFields.put("bl_esig_flg", "blEsigFlg");
        this.hashFields.put("bl_cpy_esig_flg", "blCpyEsigFlg");
        this.hashFields.put("bl_knt_flg", "blKntFlg");
        this.hashFields.put("edi_type", "ediType");
        this.hashFields.put("bkg_wt_chk_flg", "bkgWtChkFlg");
        this.hashFields.put("edi_hld_flg", "ediHldFlg");
        this.hashFields.put("f_cmd", "fCmd");
        this.hashFields.put("bkg_pol_cd", "bkgPolCd");
        this.hashFields.put("qty_modify_flag", "qtyModifyFlag");
        this.hashFields.put("his_ui_nm", "hisUiNm");
        this.hashFields.put("bkg_ty_flg", "bkgTyFlg");
        this.hashFields.put("usr_toyota_check", "usrToyotaCheck");
        this.hashFields.put("update_mt_pkup", "updateMtPkup");
        this.hashFields.put("update_full_rtn_yd_cd", "updateFullRtnYdCd");
        this.hashFields.put("message", "message");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("snd_id", "sndId");
        this.hashFields.put("ntc_knd_cd", "ntcKndCd");
        this.hashFields.put("eml", "eml");
        this.hashFields.put("remark", "remark");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ncbNo
	 */
    public String getNcbNo() {
        return this.ncbNo;
    }

    /**
	 * Column Info
	 * @return caExistFlg
	 */
    public String getCaExistFlg() {
        return this.caExistFlg;
    }

    /**
	 * Column Info
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * @return mapSeq
	 */
    public String getMapSeq() {
        return this.mapSeq;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return blTpCd
	 */
    public String getBlTpCd() {
        return this.blTpCd;
    }

    /**
	 * Column Info
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
    }

    /**
	 * Column Info
	 * @return pageType
	 */
    public String getPageType() {
        return this.pageType;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return blNoChk
	 */
    public String getBlNoChk() {
        return this.blNoChk;
    }

    /**
	 * Column Info
	 * @return applicationDate
	 */
    public String getApplicationDate() {
        return this.applicationDate;
    }

    /**
	 * Column Info
	 * @return caNo
	 */
    public String getCaNo() {
        return this.caNo;
    }

    /**
	 * Column Info
	 * @return caFlg
	 */
    public String getCaFlg() {
        return this.caFlg;
    }

    /**
	 * Column Info
	 * @return caUsrId
	 */
    public String getCaUsrId() {
        return this.caUsrId;
    }

    /**
	 * Column Info
	 * @param ncbNo
	 */
    public void setNcbNo(String ncbNo) {
        this.ncbNo = ncbNo;
    }

    /**
	 * Column Info
	 * @param caExistFlg
	 */
    public void setCaExistFlg(String caExistFlg) {
        this.caExistFlg = caExistFlg;
    }

    /**
	 * Column Info
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param mapSeq
	 */
    public void setMapSeq(String mapSeq) {
        this.mapSeq = mapSeq;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param blTpCd
	 */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }

    /**
	 * Column Info
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    /**
	 * Column Info
	 * @param pageType
	 */
    public void setPageType(String pageType) {
        this.pageType = pageType;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param blNoChk
	 */
    public void setBlNoChk(String blNoChk) {
        this.blNoChk = blNoChk;
    }

    /**
	 * Column Info
	 * @param applicationDate
	 */
    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
	 * Column Info
	 * @param caNo
	 */
    public void setCaNo(String caNo) {
        this.caNo = caNo;
    }

    /**
	 * Column Info
	 * @param caFlg
	 */
    public void setCaFlg(String caFlg) {
        this.caFlg = caFlg;
    }

    /**
	 * Column Info
	 * @param caUsrId
	 */
    public void setCaUsrId(String caUsrId) {
        this.caUsrId = caUsrId;
    }

    public void setXterBkgRqstCd(String xterBkgRqstCd) {
        this.xterBkgRqstCd = xterBkgRqstCd;
    }

    public String getXterBkgRqstCd() {
        return this.xterBkgRqstCd;
    }

    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
    }

    public String getBkgOfcCd() {
        return this.bkgOfcCd;
    }

    public void setXterRmk(String xterRmk) {
        this.xterRmk = xterRmk;
    }

    public String getXterRmk() {
        return this.xterRmk;
    }

    public void setBkgCntcPsonEml(String bkgCntcPsonEml) {
        this.bkgCntcPsonEml = bkgCntcPsonEml;
    }

    public String getBkgCntcPsonEml() {
        return this.bkgCntcPsonEml;
    }

    public void setXterBkgRqstRefNo(String xterBkgRqstRefNo) {
        this.xterBkgRqstRefNo = xterBkgRqstRefNo;
    }

    public String getXterBkgRqstRefNo() {
        return this.xterBkgRqstRefNo;
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

    /**
	 * @return the blKntFlg
	 */
	public String getBlKntFlg() {
		return blKntFlg;
	}

	/**
	 * @param blKntFlg the blKntFlg to set
	 */
	public void setBlKntFlg(String blKntFlg) {
		this.blKntFlg = blKntFlg;
	}

	public void setEdiType(String ediType) {
        this.ediType = ediType;
    }

    public String getEdiType() {
        return this.ediType;
    }

    public void setBkgWtChkFlg(String bkgWtChkFlg) {
        this.bkgWtChkFlg = bkgWtChkFlg;
    }

    public String getBkgWtChkFlg() {
        return this.bkgWtChkFlg;
    }

    public void setEdiHldFlg(String ediHldFlg) {
        this.ediHldFlg = ediHldFlg;
    }

    public String getEdiHldFlg() {
        return this.ediHldFlg;
    }

    public void setFCmd(String fCmd) {
        this.fCmd = fCmd;
    }

    public String getFCmd() {
        return this.fCmd;
    }

    public void setBkgPolCd(String bkgPolCd) {
        this.bkgPolCd = bkgPolCd;
    }

    public String getBkgPolCd() {
        return this.bkgPolCd;
    }

    public void setQtyModifyFlag(String qtyModifyFlag) {
        this.qtyModifyFlag = qtyModifyFlag;
    }

    public String getQtyModifyFlag() {
        return this.qtyModifyFlag;
    }

    public void setHisUiNm(String hisUiNm) {
        this.hisUiNm = hisUiNm;
    }

    public String getHisUiNm() {
        return this.hisUiNm;
    }

    public void setBkgTyFlg(String bkgTyFlg) {
        this.bkgTyFlg = bkgTyFlg;
    }

    public String getBkgTyFlg() {
        return this.bkgTyFlg;
    }

    public void setUsrToyotaCheck(String usrToyotaCheck) {
        this.usrToyotaCheck = usrToyotaCheck;
    }

    public String getUsrToyotaCheck() {
        return this.usrToyotaCheck;
    }

    public void setUpdateMtPkup(String updateMtPkup) {
        this.updateMtPkup = updateMtPkup;
    }

    public String getUpdateMtPkup() {
        return this.updateMtPkup;
    }

    public void setUpdateFullRtnYdCd(String updateFullRtnYdCd) {
        this.updateFullRtnYdCd = updateFullRtnYdCd;
    }

    public String getUpdateFullRtnYdCd() {
        return this.updateFullRtnYdCd;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    public String getCntrNo() {
        return this.cntrNo;
    }

    public void setSndId(String sndId) {
        this.sndId = sndId;
    }

    public String getSndId() {
        return this.sndId;
    }

    public void setNtcKndCd(String ntcKndCd) {
        this.ntcKndCd = ntcKndCd;
    }

    public String getNtcKndCd() {
        return this.ntcKndCd;
    }

    public void setEml(String eml) {
        this.eml = eml;
    }

    public String getEml() {
        return this.eml;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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
        setNcbNo(JSPUtil.getParameter(request, prefix + "ncb_no", ""));
        setCaExistFlg(JSPUtil.getParameter(request, prefix + "ca_exist_flg", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setMapSeq(JSPUtil.getParameter(request, prefix + "map_seq", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setPageType(JSPUtil.getParameter(request, prefix + "page_type", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
        setApplicationDate(JSPUtil.getParameter(request, prefix + "application_date", ""));
        setCaNo(JSPUtil.getParameter(request, prefix + "ca_no", ""));
        setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
        setCaUsrId(JSPUtil.getParameter(request, prefix + "ca_usr_id", ""));
        setXterBkgRqstCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
        setBkgCntcPsonEml(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", ""));
        setXterBkgRqstRefNo(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", ""));
        setBlEsigFlg(JSPUtil.getParameter(request, prefix + "bl_esig_flg", ""));
        setBlCpyEsigFlg(JSPUtil.getParameter(request, prefix + "bl_cpy_esig_flg", ""));
        setBlKntFlg(JSPUtil.getParameter(request, prefix + "bl_knt_flg", ""));
        setEdiType(JSPUtil.getParameter(request, prefix + "edi_type", ""));
        setBkgWtChkFlg(JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", ""));
        setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
        setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
        setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
        setQtyModifyFlag(JSPUtil.getParameter(request, prefix + "qty_modify_flag", ""));
        setHisUiNm(JSPUtil.getParameter(request, prefix + "his_ui_nm", ""));
        setBkgTyFlg(JSPUtil.getParameter(request, prefix + "bkg_ty_flg", ""));
        setUsrToyotaCheck(JSPUtil.getParameter(request, prefix + "usr_toyota_check", ""));
        setUpdateMtPkup(JSPUtil.getParameter(request, prefix + "update_mt_pkup", ""));
        setUpdateFullRtnYdCd(JSPUtil.getParameter(request, prefix + "update_full_rtn_yd_cd", ""));
        setMessage(JSPUtil.getParameter(request, prefix + "message", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setSndId(JSPUtil.getParameter(request, prefix + "snd_id", ""));
        setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
        setEml(JSPUtil.getParameter(request, prefix + "eml", ""));
        setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBlNoVO[]
	 */
    public BkgBlNoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBlNoVO[]
	 */
    public BkgBlNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgBlNoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ncbNo = (JSPUtil.getParameter(request, prefix + "ncb_no", length));
            String[] caExistFlg = (JSPUtil.getParameter(request, prefix + "ca_exist_flg", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] mapSeq = (JSPUtil.getParameter(request, prefix + "map_seq", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] blTpCd = (JSPUtil.getParameter(request, prefix + "bl_tp_cd", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] pageType = (JSPUtil.getParameter(request, prefix + "page_type", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] blNoChk = (JSPUtil.getParameter(request, prefix + "bl_no_chk", length));
            String[] applicationDate = (JSPUtil.getParameter(request, prefix + "application_date", length));
            String[] caNo = (JSPUtil.getParameter(request, prefix + "ca_no", length));
            String[] caFlg = (JSPUtil.getParameter(request, prefix + "ca_flg", length));
            String[] caUsrId = (JSPUtil.getParameter(request, prefix + "ca_usr_id", length));
            String[] xterBkgRqstCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] xterRmk = (JSPUtil.getParameter(request, prefix + "xter_rmk", length));
            String[] bkgCntcPsonEml = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", length));
            String[] xterBkgRqstRefNo = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", length));
            String[] blEsigFlg = (JSPUtil.getParameter(request, prefix + "bl_esig_flg", length));
            String[] blCpyEsigFlg = (JSPUtil.getParameter(request, prefix + "bl_cpy_esig_flg", length));
            String[] blKntFlg = (JSPUtil.getParameter(request, prefix + "bl_knt_flg", length));
            String[] ediType = (JSPUtil.getParameter(request, prefix + "edi_type", length));
            String[] bkgWtChkFlg = (JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", length));
            String[] ediHldFlg = (JSPUtil.getParameter(request, prefix + "edi_hld_flg", length));
            String[] fCmd = (JSPUtil.getParameter(request, prefix + "f_cmd", length));
            String[] bkgPolCd = (JSPUtil.getParameter(request, prefix + "bkg_pol_cd", length));
            String[] qtyModifyFlag = (JSPUtil.getParameter(request, prefix + "qty_modify_flag", length));
            String[] hisUiNm = (JSPUtil.getParameter(request, prefix + "his_ui_nm", length));
            String[] bkgTyFlg = (JSPUtil.getParameter(request, prefix + "bkg_ty_flg", length));
            String[] usrToyotaCheck = (JSPUtil.getParameter(request, prefix + "usr_toyota_check", length));
            String[] updateMtPkup = (JSPUtil.getParameter(request, prefix + "update_mt_pkup", length));
            String[] updateFullRtnYdCd = (JSPUtil.getParameter(request, prefix + "update_full_rtn_yd_cd", length));
            String[] message = (JSPUtil.getParameter(request, prefix + "message", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] sndId = (JSPUtil.getParameter(request, prefix + "snd_id", length));
            String[] ntcKndCd = (JSPUtil.getParameter(request, prefix + "ntc_knd_cd", length));
            String[] eml = (JSPUtil.getParameter(request, prefix + "eml", length));
            String[] remark = (JSPUtil.getParameter(request, prefix + "remark", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgBlNoVO();
                if (ncbNo[i] != null)
                    model.setNcbNo(ncbNo[i]);
                if (caExistFlg[i] != null)
                    model.setCaExistFlg(caExistFlg[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (mapSeq[i] != null)
                    model.setMapSeq(mapSeq[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (blTpCd[i] != null)
                    model.setBlTpCd(blTpCd[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (pageType[i] != null)
                    model.setPageType(pageType[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (blNoChk[i] != null)
                    model.setBlNoChk(blNoChk[i]);
                if (applicationDate[i] != null)
                    model.setApplicationDate(applicationDate[i]);
                if (caNo[i] != null)
                    model.setCaNo(caNo[i]);
                if (caFlg[i] != null)
                    model.setCaFlg(caFlg[i]);
                if (caUsrId[i] != null)
                    model.setCaUsrId(caUsrId[i]);
                if (xterBkgRqstCd[i] != null)
                    model.setXterBkgRqstCd(xterBkgRqstCd[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (xterRmk[i] != null)
                    model.setXterRmk(xterRmk[i]);
                if (bkgCntcPsonEml[i] != null)
                    model.setBkgCntcPsonEml(bkgCntcPsonEml[i]);
                if (xterBkgRqstRefNo[i] != null)
                    model.setXterBkgRqstRefNo(xterBkgRqstRefNo[i]);
                if (blEsigFlg[i] != null)
                    model.setBlEsigFlg(blEsigFlg[i]);
                if (blCpyEsigFlg[i] != null)
                    model.setBlCpyEsigFlg(blCpyEsigFlg[i]);
                if (blKntFlg[i] != null)
                	model.setBlKntFlg(blKntFlg[i]);
                if (ediType[i] != null)
                    model.setEdiType(ediType[i]);
                if (bkgWtChkFlg[i] != null)
                    model.setBkgWtChkFlg(bkgWtChkFlg[i]);
                if (ediHldFlg[i] != null)
                    model.setEdiHldFlg(ediHldFlg[i]);
                if (fCmd[i] != null)
                    model.setFCmd(fCmd[i]);
                if (bkgPolCd[i] != null)
                    model.setBkgPolCd(bkgPolCd[i]);
                if (qtyModifyFlag[i] != null)
                    model.setQtyModifyFlag(qtyModifyFlag[i]);
                if (hisUiNm[i] != null)
                    model.setHisUiNm(hisUiNm[i]);
                if (bkgTyFlg[i] != null)
                    model.setBkgTyFlg(bkgTyFlg[i]);
                if (usrToyotaCheck[i] != null)
                    model.setUsrToyotaCheck(usrToyotaCheck[i]);
                if (updateMtPkup[i] != null)
                    model.setUpdateMtPkup(updateMtPkup[i]);
                if (updateFullRtnYdCd[i] != null)
                    model.setUpdateFullRtnYdCd(updateFullRtnYdCd[i]);
                if (message[i] != null)
                    model.setMessage(message[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (sndId[i] != null)
                    model.setSndId(sndId[i]);
                if (ntcKndCd[i] != null)
                    model.setNtcKndCd(ntcKndCd[i]);
                if (eml[i] != null)
                    model.setEml(eml[i]);
                if (remark[i] != null) 
		    		model.setRemark(remark[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgBlNoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgBlNoVO[]
	 */
    public BkgBlNoVO[] getBkgBlNoVOs() {
        BkgBlNoVO[] vos = (BkgBlNoVO[]) models.toArray(new BkgBlNoVO[models.size()]);
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
        this.ncbNo = this.ncbNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caExistFlg = this.caExistFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapSeq = this.mapSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blTpCd = this.blTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pageType = this.pageType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoChk = this.blNoChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.applicationDate = this.applicationDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caNo = this.caNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caFlg = this.caFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caUsrId = this.caUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstCd = this.xterBkgRqstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRmk = this.xterRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonEml = this.bkgCntcPsonEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstRefNo = this.xterBkgRqstRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blEsigFlg = this.blEsigFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCpyEsigFlg = this.blCpyEsigFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blKntFlg = this.blKntFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediType = this.ediType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgWtChkFlg = this.bkgWtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediHldFlg = this.ediHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCmd = this.fCmd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPolCd = this.bkgPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.qtyModifyFlag = this.qtyModifyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hisUiNm = this.hisUiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTyFlg = this.bkgTyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrToyotaCheck = this.usrToyotaCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updateMtPkup = this.updateMtPkup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updateFullRtnYdCd = this.updateFullRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.message = this.message.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndId = this.sndId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntcKndCd = this.ntcKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eml = this.eml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remark = this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
