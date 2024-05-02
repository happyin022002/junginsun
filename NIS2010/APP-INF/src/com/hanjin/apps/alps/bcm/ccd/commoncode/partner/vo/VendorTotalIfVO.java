/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VendorTotalIfVO.java
*@FileTitle : VendorTotalIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.08 
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
public class VendorTotalIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VendorTotalIfVO> models = new ArrayList<VendorTotalIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String vndrCntCd = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String vndrLoclLangNm = null;

    /* Column Info */
    private String vndrAbbrNm = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String ceoNm = null;

    /* Column Info */
    private String rgstNo = null;

    /* Column Info */
    private String prntCntCd = null;

    /* Column Info */
    private String prntVndrSeq = null;

    /* Column Info */
    private String svcScpCdNm = null;

    /* Column Info */
    private String svcPrdTpNm = null;

    /* Column Info */
    private String svcPrdRmk = null;

    /* Column Info */
    private String bzctNm = null;

    /* Column Info */
    private String bztpNm = null;

    /* Column Info */
    private String genPayTermCd = null;

    /* Column Info */
    private String engAddr = null;

    /* Column Info */
    private String loclLangAddr = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String cntcPsonNm = null;

    /* Column Info */
    private String invCurrCd = null;

    /* Column Info */
    private String payCurrCd = null;

    /* Column Info */
    private String payMzdCd = null;

    /* Column Info */
    private String usaEdiCd = null;

    /* Column Info */
    private String woAtchFileFlg = null;

    /* Column Info */
    private String woEdiUseFlg = null;

    /* Column Info */
    private String invEdiUseFlg = null;

    /* Column Info */
    private String modiVndrSeq = null;

    /* Column Info */
    private String blkFlg = null;

    /* Column Info */
    private String fincFlg = null;

    /* Column Info */
    private String teamFlg = null;

    /* Column Info */
    private String interCoFlg = null;

    /* Column Info */
    private String lgsFlg = null;

    /* Column Info */
    private String otrFlg = null;

    /* Column Info */
    private String blkVndrSvcCd = null;

    /* Column Info */
    private String vndrOfcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String intlFaxNo = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String vndrEml = null;

    /* Column Info */
    private String rfndPsdoCustCd = null;

    /* Column Info */
    private String payTermTpCd = null;

    /* Column Info */
    private String chkDeAddr1 = null;

    /* Column Info */
    private String chkDeAddr2 = null;

    /* Column Info */
    private String chkDeAddr3 = null;

    /* Column Info */
    private String chkDeCtyNm = null;

    /* Column Info */
    private String chkDeSteCd = null;

    /* Column Info */
    private String chkDeZipCd = null;

    /* Column Info */
    private String chkDeCntCd = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String dcgoHndlFlg = null;

    /* Column Info */
    private String mtyRroEdiUseFlg = null;

    /* Column Info */
    private String procuFlg = null;

    /* Column Info */
    private String taxId = null;

    /* Column Info */
    private String subsCoCd = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VendorTotalIfVO() {
    }

    public VendorTotalIfVO(String ibflag, String pagerows, String vndrSeq, String vndrCntCd, String vndrLglEngNm, String vndrLoclLangNm, String vndrAbbrNm, String locCd, String ofcCd, String ceoNm, String rgstNo, String prntCntCd, String prntVndrSeq, String svcScpCdNm, String svcPrdTpNm, String svcPrdRmk, String bzctNm, String bztpNm, String genPayTermCd, String engAddr, String loclLangAddr, String zipCd, String cntcPsonNm, String invCurrCd, String payCurrCd, String payMzdCd, String usaEdiCd, String woAtchFileFlg, String woEdiUseFlg, String invEdiUseFlg, String modiVndrSeq, String blkFlg, String fincFlg, String teamFlg, String interCoFlg, String lgsFlg, String otrFlg, String blkVndrSvcCd, String vndrOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String prmryChkFlg, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String vndrEml, String rfndPsdoCustCd, String payTermTpCd, String chkDeAddr1, String chkDeAddr2, String chkDeAddr3, String chkDeCtyNm, String chkDeSteCd, String chkDeZipCd, String chkDeCntCd, String usrId, String cudFlg, String deltFlg, String dcgoHndlFlg, String mtyRroEdiUseFlg, String procuFlg, String taxId, String subsCoCd, String eaiEvntDt, String eaiIfId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vndrSeq = vndrSeq;
        this.vndrCntCd = vndrCntCd;
        this.vndrLglEngNm = vndrLglEngNm;
        this.vndrLoclLangNm = vndrLoclLangNm;
        this.vndrAbbrNm = vndrAbbrNm;
        this.locCd = locCd;
        this.ofcCd = ofcCd;
        this.ceoNm = ceoNm;
        this.rgstNo = rgstNo;
        this.prntCntCd = prntCntCd;
        this.prntVndrSeq = prntVndrSeq;
        this.svcScpCdNm = svcScpCdNm;
        this.svcPrdTpNm = svcPrdTpNm;
        this.svcPrdRmk = svcPrdRmk;
        this.bzctNm = bzctNm;
        this.bztpNm = bztpNm;
        this.genPayTermCd = genPayTermCd;
        this.engAddr = engAddr;
        this.loclLangAddr = loclLangAddr;
        this.zipCd = zipCd;
        this.cntcPsonNm = cntcPsonNm;
        this.invCurrCd = invCurrCd;
        this.payCurrCd = payCurrCd;
        this.payMzdCd = payMzdCd;
        this.usaEdiCd = usaEdiCd;
        this.woAtchFileFlg = woAtchFileFlg;
        this.woEdiUseFlg = woEdiUseFlg;
        this.invEdiUseFlg = invEdiUseFlg;
        this.modiVndrSeq = modiVndrSeq;
        this.blkFlg = blkFlg;
        this.fincFlg = fincFlg;
        this.teamFlg = teamFlg;
        this.interCoFlg = interCoFlg;
        this.lgsFlg = lgsFlg;
        this.otrFlg = otrFlg;
        this.blkVndrSvcCd = blkVndrSvcCd;
        this.vndrOfcCd = vndrOfcCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.prmryChkFlg = prmryChkFlg;
        this.intlPhnNo = intlPhnNo;
        this.phnNo = phnNo;
        this.intlFaxNo = intlFaxNo;
        this.faxNo = faxNo;
        this.vndrEml = vndrEml;
        this.rfndPsdoCustCd = rfndPsdoCustCd;
        this.payTermTpCd = payTermTpCd;
        this.chkDeAddr1 = chkDeAddr1;
        this.chkDeAddr2 = chkDeAddr2;
        this.chkDeAddr3 = chkDeAddr3;
        this.chkDeCtyNm = chkDeCtyNm;
        this.chkDeSteCd = chkDeSteCd;
        this.chkDeZipCd = chkDeZipCd;
        this.chkDeCntCd = chkDeCntCd;
        this.usrId = usrId;
        this.cudFlg = cudFlg;
        this.deltFlg = deltFlg;
        this.dcgoHndlFlg = dcgoHndlFlg;
        this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
        this.procuFlg = procuFlg;
        this.taxId = taxId;
        this.subsCoCd = subsCoCd;
        this.eaiEvntDt = eaiEvntDt;
        this.eaiIfId = eaiIfId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("vndr_locl_lang_nm", getVndrLoclLangNm());
        this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ceo_nm", getCeoNm());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("prnt_cnt_cd", getPrntCntCd());
        this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
        this.hashColumns.put("svc_scp_cd_nm", getSvcScpCdNm());
        this.hashColumns.put("svc_prd_tp_nm", getSvcPrdTpNm());
        this.hashColumns.put("svc_prd_rmk", getSvcPrdRmk());
        this.hashColumns.put("bzct_nm", getBzctNm());
        this.hashColumns.put("bztp_nm", getBztpNm());
        this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
        this.hashColumns.put("eng_addr", getEngAddr());
        this.hashColumns.put("locl_lang_addr", getLoclLangAddr());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("pay_curr_cd", getPayCurrCd());
        this.hashColumns.put("pay_mzd_cd", getPayMzdCd());
        this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
        this.hashColumns.put("wo_atch_file_flg", getWoAtchFileFlg());
        this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
        this.hashColumns.put("inv_edi_use_flg", getInvEdiUseFlg());
        this.hashColumns.put("modi_vndr_seq", getModiVndrSeq());
        this.hashColumns.put("blk_flg", getBlkFlg());
        this.hashColumns.put("finc_flg", getFincFlg());
        this.hashColumns.put("team_flg", getTeamFlg());
        this.hashColumns.put("inter_co_flg", getInterCoFlg());
        this.hashColumns.put("lgs_flg", getLgsFlg());
        this.hashColumns.put("otr_flg", getOtrFlg());
        this.hashColumns.put("blk_vndr_svc_cd", getBlkVndrSvcCd());
        this.hashColumns.put("vndr_ofc_cd", getVndrOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("intl_fax_no", getIntlFaxNo());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("vndr_eml", getVndrEml());
        this.hashColumns.put("rfnd_psdo_cust_cd", getRfndPsdoCustCd());
        this.hashColumns.put("pay_term_tp_cd", getPayTermTpCd());
        this.hashColumns.put("chk_de_addr1", getChkDeAddr1());
        this.hashColumns.put("chk_de_addr2", getChkDeAddr2());
        this.hashColumns.put("chk_de_addr3", getChkDeAddr3());
        this.hashColumns.put("chk_de_cty_nm", getChkDeCtyNm());
        this.hashColumns.put("chk_de_ste_cd", getChkDeSteCd());
        this.hashColumns.put("chk_de_zip_cd", getChkDeZipCd());
        this.hashColumns.put("chk_de_cnt_cd", getChkDeCntCd());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("dcgo_hndl_flg", getDcgoHndlFlg());
        this.hashColumns.put("mty_rro_edi_use_flg", getMtyRroEdiUseFlg());
        this.hashColumns.put("procu_flg", getProcuFlg());
        this.hashColumns.put("tax_id", getTaxId());
        this.hashColumns.put("subs_co_cd", getSubsCoCd());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("vndr_locl_lang_nm", "vndrLoclLangNm");
        this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ceo_nm", "ceoNm");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("prnt_cnt_cd", "prntCntCd");
        this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
        this.hashFields.put("svc_scp_cd_nm", "svcScpCdNm");
        this.hashFields.put("svc_prd_tp_nm", "svcPrdTpNm");
        this.hashFields.put("svc_prd_rmk", "svcPrdRmk");
        this.hashFields.put("bzct_nm", "bzctNm");
        this.hashFields.put("bztp_nm", "bztpNm");
        this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
        this.hashFields.put("eng_addr", "engAddr");
        this.hashFields.put("locl_lang_addr", "loclLangAddr");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("pay_curr_cd", "payCurrCd");
        this.hashFields.put("pay_mzd_cd", "payMzdCd");
        this.hashFields.put("usa_edi_cd", "usaEdiCd");
        this.hashFields.put("wo_atch_file_flg", "woAtchFileFlg");
        this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
        this.hashFields.put("inv_edi_use_flg", "invEdiUseFlg");
        this.hashFields.put("modi_vndr_seq", "modiVndrSeq");
        this.hashFields.put("blk_flg", "blkFlg");
        this.hashFields.put("finc_flg", "fincFlg");
        this.hashFields.put("team_flg", "teamFlg");
        this.hashFields.put("inter_co_flg", "interCoFlg");
        this.hashFields.put("lgs_flg", "lgsFlg");
        this.hashFields.put("otr_flg", "otrFlg");
        this.hashFields.put("blk_vndr_svc_cd", "blkVndrSvcCd");
        this.hashFields.put("vndr_ofc_cd", "vndrOfcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("vndr_eml", "vndrEml");
        this.hashFields.put("rfnd_psdo_cust_cd", "rfndPsdoCustCd");
        this.hashFields.put("pay_term_tp_cd", "payTermTpCd");
        this.hashFields.put("chk_de_addr1", "chkDeAddr1");
        this.hashFields.put("chk_de_addr2", "chkDeAddr2");
        this.hashFields.put("chk_de_addr3", "chkDeAddr3");
        this.hashFields.put("chk_de_cty_nm", "chkDeCtyNm");
        this.hashFields.put("chk_de_ste_cd", "chkDeSteCd");
        this.hashFields.put("chk_de_zip_cd", "chkDeZipCd");
        this.hashFields.put("chk_de_cnt_cd", "chkDeCntCd");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("dcgo_hndl_flg", "dcgoHndlFlg");
        this.hashFields.put("mty_rro_edi_use_flg", "mtyRroEdiUseFlg");
        this.hashFields.put("procu_flg", "procuFlg");
        this.hashFields.put("tax_id", "taxId");
        this.hashFields.put("subs_co_cd", "subsCoCd");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("eai_if_id", "eaiIfId");
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

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
    }

    public void setVndrCntCd(String vndrCntCd) {
        this.vndrCntCd = vndrCntCd;
    }

    public String getVndrCntCd() {
        return this.vndrCntCd;
    }

    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    public void setVndrLoclLangNm(String vndrLoclLangNm) {
        this.vndrLoclLangNm = vndrLoclLangNm;
    }

    public String getVndrLoclLangNm() {
        return this.vndrLoclLangNm;
    }

    public void setVndrAbbrNm(String vndrAbbrNm) {
        this.vndrAbbrNm = vndrAbbrNm;
    }

    public String getVndrAbbrNm() {
        return this.vndrAbbrNm;
    }

    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    public String getLocCd() {
        return this.locCd;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public void setCeoNm(String ceoNm) {
        this.ceoNm = ceoNm;
    }

    public String getCeoNm() {
        return this.ceoNm;
    }

    public void setRgstNo(String rgstNo) {
        this.rgstNo = rgstNo;
    }

    public String getRgstNo() {
        return this.rgstNo;
    }

    public void setPrntCntCd(String prntCntCd) {
        this.prntCntCd = prntCntCd;
    }

    public String getPrntCntCd() {
        return this.prntCntCd;
    }

    public void setPrntVndrSeq(String prntVndrSeq) {
        this.prntVndrSeq = prntVndrSeq;
    }

    public String getPrntVndrSeq() {
        return this.prntVndrSeq;
    }

    public void setSvcScpCdNm(String svcScpCdNm) {
        this.svcScpCdNm = svcScpCdNm;
    }

    public String getSvcScpCdNm() {
        return this.svcScpCdNm;
    }

    public void setSvcPrdTpNm(String svcPrdTpNm) {
        this.svcPrdTpNm = svcPrdTpNm;
    }

    public String getSvcPrdTpNm() {
        return this.svcPrdTpNm;
    }

    public void setSvcPrdRmk(String svcPrdRmk) {
        this.svcPrdRmk = svcPrdRmk;
    }

    public String getSvcPrdRmk() {
        return this.svcPrdRmk;
    }

    public void setBzctNm(String bzctNm) {
        this.bzctNm = bzctNm;
    }

    public String getBzctNm() {
        return this.bzctNm;
    }

    public void setBztpNm(String bztpNm) {
        this.bztpNm = bztpNm;
    }

    public String getBztpNm() {
        return this.bztpNm;
    }

    public void setGenPayTermCd(String genPayTermCd) {
        this.genPayTermCd = genPayTermCd;
    }

    public String getGenPayTermCd() {
        return this.genPayTermCd;
    }

    public void setEngAddr(String engAddr) {
        this.engAddr = engAddr;
    }

    public String getEngAddr() {
        return this.engAddr;
    }

    public void setLoclLangAddr(String loclLangAddr) {
        this.loclLangAddr = loclLangAddr;
    }

    public String getLoclLangAddr() {
        return this.loclLangAddr;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getZipCd() {
        return this.zipCd;
    }

    public void setCntcPsonNm(String cntcPsonNm) {
        this.cntcPsonNm = cntcPsonNm;
    }

    public String getCntcPsonNm() {
        return this.cntcPsonNm;
    }

    public void setInvCurrCd(String invCurrCd) {
        this.invCurrCd = invCurrCd;
    }

    public String getInvCurrCd() {
        return this.invCurrCd;
    }

    public void setPayCurrCd(String payCurrCd) {
        this.payCurrCd = payCurrCd;
    }

    public String getPayCurrCd() {
        return this.payCurrCd;
    }

    public void setPayMzdCd(String payMzdCd) {
        this.payMzdCd = payMzdCd;
    }

    public String getPayMzdCd() {
        return this.payMzdCd;
    }

    public void setUsaEdiCd(String usaEdiCd) {
        this.usaEdiCd = usaEdiCd;
    }

    public String getUsaEdiCd() {
        return this.usaEdiCd;
    }

    public void setWoAtchFileFlg(String woAtchFileFlg) {
        this.woAtchFileFlg = woAtchFileFlg;
    }

    public String getWoAtchFileFlg() {
        return this.woAtchFileFlg;
    }

    public void setWoEdiUseFlg(String woEdiUseFlg) {
        this.woEdiUseFlg = woEdiUseFlg;
    }

    public String getWoEdiUseFlg() {
        return this.woEdiUseFlg;
    }

    public void setInvEdiUseFlg(String invEdiUseFlg) {
        this.invEdiUseFlg = invEdiUseFlg;
    }

    public String getInvEdiUseFlg() {
        return this.invEdiUseFlg;
    }

    public void setModiVndrSeq(String modiVndrSeq) {
        this.modiVndrSeq = modiVndrSeq;
    }

    public String getModiVndrSeq() {
        return this.modiVndrSeq;
    }

    public void setBlkFlg(String blkFlg) {
        this.blkFlg = blkFlg;
    }

    public String getBlkFlg() {
        return this.blkFlg;
    }

    public void setFincFlg(String fincFlg) {
        this.fincFlg = fincFlg;
    }

    public String getFincFlg() {
        return this.fincFlg;
    }

    public void setTeamFlg(String teamFlg) {
        this.teamFlg = teamFlg;
    }

    public String getTeamFlg() {
        return this.teamFlg;
    }

    public void setInterCoFlg(String interCoFlg) {
        this.interCoFlg = interCoFlg;
    }

    public String getInterCoFlg() {
        return this.interCoFlg;
    }

    public void setLgsFlg(String lgsFlg) {
        this.lgsFlg = lgsFlg;
    }

    public String getLgsFlg() {
        return this.lgsFlg;
    }

    public void setOtrFlg(String otrFlg) {
        this.otrFlg = otrFlg;
    }

    public String getOtrFlg() {
        return this.otrFlg;
    }

    public void setBlkVndrSvcCd(String blkVndrSvcCd) {
        this.blkVndrSvcCd = blkVndrSvcCd;
    }

    public String getBlkVndrSvcCd() {
        return this.blkVndrSvcCd;
    }

    public void setVndrOfcCd(String vndrOfcCd) {
        this.vndrOfcCd = vndrOfcCd;
    }

    public String getVndrOfcCd() {
        return this.vndrOfcCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
    }

    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    public String getIntlPhnNo() {
        return this.intlPhnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getPhnNo() {
        return this.phnNo;
    }

    public void setIntlFaxNo(String intlFaxNo) {
        this.intlFaxNo = intlFaxNo;
    }

    public String getIntlFaxNo() {
        return this.intlFaxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getFaxNo() {
        return this.faxNo;
    }

    public void setVndrEml(String vndrEml) {
        this.vndrEml = vndrEml;
    }

    public String getVndrEml() {
        return this.vndrEml;
    }

    public void setRfndPsdoCustCd(String rfndPsdoCustCd) {
        this.rfndPsdoCustCd = rfndPsdoCustCd;
    }

    public String getRfndPsdoCustCd() {
        return this.rfndPsdoCustCd;
    }

    public void setPayTermTpCd(String payTermTpCd) {
        this.payTermTpCd = payTermTpCd;
    }

    public String getPayTermTpCd() {
        return this.payTermTpCd;
    }

    public void setChkDeAddr1(String chkDeAddr1) {
        this.chkDeAddr1 = chkDeAddr1;
    }

    public String getChkDeAddr1() {
        return this.chkDeAddr1;
    }

    public void setChkDeAddr2(String chkDeAddr2) {
        this.chkDeAddr2 = chkDeAddr2;
    }

    public String getChkDeAddr2() {
        return this.chkDeAddr2;
    }

    public void setChkDeAddr3(String chkDeAddr3) {
        this.chkDeAddr3 = chkDeAddr3;
    }

    public String getChkDeAddr3() {
        return this.chkDeAddr3;
    }

    public void setChkDeCtyNm(String chkDeCtyNm) {
        this.chkDeCtyNm = chkDeCtyNm;
    }

    public String getChkDeCtyNm() {
        return this.chkDeCtyNm;
    }

    public void setChkDeSteCd(String chkDeSteCd) {
        this.chkDeSteCd = chkDeSteCd;
    }

    public String getChkDeSteCd() {
        return this.chkDeSteCd;
    }

    public void setChkDeZipCd(String chkDeZipCd) {
        this.chkDeZipCd = chkDeZipCd;
    }

    public String getChkDeZipCd() {
        return this.chkDeZipCd;
    }

    public void setChkDeCntCd(String chkDeCntCd) {
        this.chkDeCntCd = chkDeCntCd;
    }

    public String getChkDeCntCd() {
        return this.chkDeCntCd;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    public String getDeltFlg() {
        return this.deltFlg;
    }

    public void setDcgoHndlFlg(String dcgoHndlFlg) {
        this.dcgoHndlFlg = dcgoHndlFlg;
    }

    public String getDcgoHndlFlg() {
        return this.dcgoHndlFlg;
    }

    public void setMtyRroEdiUseFlg(String mtyRroEdiUseFlg) {
        this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
    }

    public String getMtyRroEdiUseFlg() {
        return this.mtyRroEdiUseFlg;
    }

    public void setProcuFlg(String procuFlg) {
        this.procuFlg = procuFlg;
    }

    public String getProcuFlg() {
        return this.procuFlg;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxId() {
        return this.taxId;
    }

    public void setSubsCoCd(String subsCoCd) {
        this.subsCoCd = subsCoCd;
    }

    public String getSubsCoCd() {
        return this.subsCoCd;
    }

    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    public void setEaiIfId(String eaiIfId) {
        this.eaiIfId = eaiIfId;
    }

    public String getEaiIfId() {
        return this.eaiIfId;
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
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setVndrLoclLangNm(JSPUtil.getParameter(request, prefix + "vndr_locl_lang_nm", ""));
        setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCeoNm(JSPUtil.getParameter(request, prefix + "ceo_nm", ""));
        setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
        setPrntCntCd(JSPUtil.getParameter(request, prefix + "prnt_cnt_cd", ""));
        setPrntVndrSeq(JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", ""));
        setSvcScpCdNm(JSPUtil.getParameter(request, prefix + "svc_scp_cd_nm", ""));
        setSvcPrdTpNm(JSPUtil.getParameter(request, prefix + "svc_prd_tp_nm", ""));
        setSvcPrdRmk(JSPUtil.getParameter(request, prefix + "svc_prd_rmk", ""));
        setBzctNm(JSPUtil.getParameter(request, prefix + "bzct_nm", ""));
        setBztpNm(JSPUtil.getParameter(request, prefix + "bztp_nm", ""));
        setGenPayTermCd(JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", ""));
        setEngAddr(JSPUtil.getParameter(request, prefix + "eng_addr", ""));
        setLoclLangAddr(JSPUtil.getParameter(request, prefix + "locl_lang_addr", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setPayCurrCd(JSPUtil.getParameter(request, prefix + "pay_curr_cd", ""));
        setPayMzdCd(JSPUtil.getParameter(request, prefix + "pay_mzd_cd", ""));
        setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
        setWoAtchFileFlg(JSPUtil.getParameter(request, prefix + "wo_atch_file_flg", ""));
        setWoEdiUseFlg(JSPUtil.getParameter(request, prefix + "wo_edi_use_flg", ""));
        setInvEdiUseFlg(JSPUtil.getParameter(request, prefix + "inv_edi_use_flg", ""));
        setModiVndrSeq(JSPUtil.getParameter(request, prefix + "modi_vndr_seq", ""));
        setBlkFlg(JSPUtil.getParameter(request, prefix + "blk_flg", ""));
        setFincFlg(JSPUtil.getParameter(request, prefix + "finc_flg", ""));
        setTeamFlg(JSPUtil.getParameter(request, prefix + "team_flg", ""));
        setInterCoFlg(JSPUtil.getParameter(request, prefix + "inter_co_flg", ""));
        setLgsFlg(JSPUtil.getParameter(request, prefix + "lgs_flg", ""));
        setOtrFlg(JSPUtil.getParameter(request, prefix + "otr_flg", ""));
        setBlkVndrSvcCd(JSPUtil.getParameter(request, prefix + "blk_vndr_svc_cd", ""));
        setVndrOfcCd(JSPUtil.getParameter(request, prefix + "vndr_ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
        setRfndPsdoCustCd(JSPUtil.getParameter(request, prefix + "rfnd_psdo_cust_cd", ""));
        setPayTermTpCd(JSPUtil.getParameter(request, prefix + "pay_term_tp_cd", ""));
        setChkDeAddr1(JSPUtil.getParameter(request, prefix + "chk_de_addr1", ""));
        setChkDeAddr2(JSPUtil.getParameter(request, prefix + "chk_de_addr2", ""));
        setChkDeAddr3(JSPUtil.getParameter(request, prefix + "chk_de_addr3", ""));
        setChkDeCtyNm(JSPUtil.getParameter(request, prefix + "chk_de_cty_nm", ""));
        setChkDeSteCd(JSPUtil.getParameter(request, prefix + "chk_de_ste_cd", ""));
        setChkDeZipCd(JSPUtil.getParameter(request, prefix + "chk_de_zip_cd", ""));
        setChkDeCntCd(JSPUtil.getParameter(request, prefix + "chk_de_cnt_cd", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setDcgoHndlFlg(JSPUtil.getParameter(request, prefix + "dcgo_hndl_flg", ""));
        setMtyRroEdiUseFlg(JSPUtil.getParameter(request, prefix + "mty_rro_edi_use_flg", ""));
        setProcuFlg(JSPUtil.getParameter(request, prefix + "procu_flg", ""));
        setTaxId(JSPUtil.getParameter(request, prefix + "tax_id", ""));
        setSubsCoCd(JSPUtil.getParameter(request, prefix + "subs_co_cd", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VendorIfVO[]
	 */
    public VendorTotalIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VendorIfVO[]
	 */
    public VendorTotalIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VendorTotalIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] vndrLoclLangNm = (JSPUtil.getParameter(request, prefix + "vndr_locl_lang_nm", length));
            String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ceoNm = (JSPUtil.getParameter(request, prefix + "ceo_nm", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] prntCntCd = (JSPUtil.getParameter(request, prefix + "prnt_cnt_cd", length));
            String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", length));
            String[] svcScpCdNm = (JSPUtil.getParameter(request, prefix + "svc_scp_cd_nm", length));
            String[] svcPrdTpNm = (JSPUtil.getParameter(request, prefix + "svc_prd_tp_nm", length));
            String[] svcPrdRmk = (JSPUtil.getParameter(request, prefix + "svc_prd_rmk", length));
            String[] bzctNm = (JSPUtil.getParameter(request, prefix + "bzct_nm", length));
            String[] bztpNm = (JSPUtil.getParameter(request, prefix + "bztp_nm", length));
            String[] genPayTermCd = (JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", length));
            String[] engAddr = (JSPUtil.getParameter(request, prefix + "eng_addr", length));
            String[] loclLangAddr = (JSPUtil.getParameter(request, prefix + "locl_lang_addr", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix + "cntc_pson_nm", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] payCurrCd = (JSPUtil.getParameter(request, prefix + "pay_curr_cd", length));
            String[] payMzdCd = (JSPUtil.getParameter(request, prefix + "pay_mzd_cd", length));
            String[] usaEdiCd = (JSPUtil.getParameter(request, prefix + "usa_edi_cd", length));
            String[] woAtchFileFlg = (JSPUtil.getParameter(request, prefix + "wo_atch_file_flg", length));
            String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix + "wo_edi_use_flg", length));
            String[] invEdiUseFlg = (JSPUtil.getParameter(request, prefix + "inv_edi_use_flg", length));
            String[] modiVndrSeq = (JSPUtil.getParameter(request, prefix + "modi_vndr_seq", length));
            String[] blkFlg = (JSPUtil.getParameter(request, prefix + "blk_flg", length));
            String[] fincFlg = (JSPUtil.getParameter(request, prefix + "finc_flg", length));
            String[] teamFlg = (JSPUtil.getParameter(request, prefix + "team_flg", length));
            String[] interCoFlg = (JSPUtil.getParameter(request, prefix + "inter_co_flg", length));
            String[] lgsFlg = (JSPUtil.getParameter(request, prefix + "lgs_flg", length));
            String[] otrFlg = (JSPUtil.getParameter(request, prefix + "otr_flg", length));
            String[] blkVndrSvcCd = (JSPUtil.getParameter(request, prefix + "blk_vndr_svc_cd", length));
            String[] vndrOfcCd = (JSPUtil.getParameter(request, prefix + "vndr_ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] intlFaxNo = (JSPUtil.getParameter(request, prefix + "intl_fax_no", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] vndrEml = (JSPUtil.getParameter(request, prefix + "vndr_eml", length));
            String[] rfndPsdoCustCd = (JSPUtil.getParameter(request, prefix + "rfnd_psdo_cust_cd", length));
            String[] payTermTpCd = (JSPUtil.getParameter(request, prefix + "pay_term_tp_cd", length));
            String[] chkDeAddr1 = (JSPUtil.getParameter(request, prefix + "chk_de_addr1", length));
            String[] chkDeAddr2 = (JSPUtil.getParameter(request, prefix + "chk_de_addr2", length));
            String[] chkDeAddr3 = (JSPUtil.getParameter(request, prefix + "chk_de_addr3", length));
            String[] chkDeCtyNm = (JSPUtil.getParameter(request, prefix + "chk_de_cty_nm", length));
            String[] chkDeSteCd = (JSPUtil.getParameter(request, prefix + "chk_de_ste_cd", length));
            String[] chkDeZipCd = (JSPUtil.getParameter(request, prefix + "chk_de_zip_cd", length));
            String[] chkDeCntCd = (JSPUtil.getParameter(request, prefix + "chk_de_cnt_cd", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] dcgoHndlFlg = (JSPUtil.getParameter(request, prefix + "dcgo_hndl_flg", length));
            String[] mtyRroEdiUseFlg = (JSPUtil.getParameter(request, prefix + "mty_rro_edi_use_flg", length));
            String[] procuFlg = (JSPUtil.getParameter(request, prefix + "procu_flg", length));
	    	String[] taxId = (JSPUtil.getParameter(request, prefix + "tax_id", length));
	    	String[] subsCoCd = (JSPUtil.getParameter(request, prefix + "subs_co_cd", length));
	    	String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
	    	String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VendorTotalIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (vndrCntCd[i] != null)
                    model.setVndrCntCd(vndrCntCd[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (vndrLoclLangNm[i] != null)
                    model.setVndrLoclLangNm(vndrLoclLangNm[i]);
                if (vndrAbbrNm[i] != null)
                    model.setVndrAbbrNm(vndrAbbrNm[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ceoNm[i] != null)
                    model.setCeoNm(ceoNm[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (prntCntCd[i] != null)
                    model.setPrntCntCd(prntCntCd[i]);
                if (prntVndrSeq[i] != null)
                    model.setPrntVndrSeq(prntVndrSeq[i]);
                if (svcScpCdNm[i] != null)
                    model.setSvcScpCdNm(svcScpCdNm[i]);
                if (svcPrdTpNm[i] != null)
                    model.setSvcPrdTpNm(svcPrdTpNm[i]);
                if (svcPrdRmk[i] != null)
                    model.setSvcPrdRmk(svcPrdRmk[i]);
                if (bzctNm[i] != null)
                    model.setBzctNm(bzctNm[i]);
                if (bztpNm[i] != null)
                    model.setBztpNm(bztpNm[i]);
                if (genPayTermCd[i] != null)
                    model.setGenPayTermCd(genPayTermCd[i]);
                if (engAddr[i] != null)
                    model.setEngAddr(engAddr[i]);
                if (loclLangAddr[i] != null)
                    model.setLoclLangAddr(loclLangAddr[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (cntcPsonNm[i] != null)
                    model.setCntcPsonNm(cntcPsonNm[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (payCurrCd[i] != null)
                    model.setPayCurrCd(payCurrCd[i]);
                if (payMzdCd[i] != null)
                    model.setPayMzdCd(payMzdCd[i]);
                if (usaEdiCd[i] != null)
                    model.setUsaEdiCd(usaEdiCd[i]);
                if (woAtchFileFlg[i] != null)
                    model.setWoAtchFileFlg(woAtchFileFlg[i]);
                if (woEdiUseFlg[i] != null)
                    model.setWoEdiUseFlg(woEdiUseFlg[i]);
                if (invEdiUseFlg[i] != null)
                    model.setInvEdiUseFlg(invEdiUseFlg[i]);
                if (modiVndrSeq[i] != null)
                    model.setModiVndrSeq(modiVndrSeq[i]);
                if (blkFlg[i] != null)
                    model.setBlkFlg(blkFlg[i]);
                if (fincFlg[i] != null)
                    model.setFincFlg(fincFlg[i]);
                if (teamFlg[i] != null)
                    model.setTeamFlg(teamFlg[i]);
                if (interCoFlg[i] != null)
                    model.setInterCoFlg(interCoFlg[i]);
                if (lgsFlg[i] != null)
                    model.setLgsFlg(lgsFlg[i]);
                if (otrFlg[i] != null)
                    model.setOtrFlg(otrFlg[i]);
                if (blkVndrSvcCd[i] != null)
                    model.setBlkVndrSvcCd(blkVndrSvcCd[i]);
                if (vndrOfcCd[i] != null)
                    model.setVndrOfcCd(vndrOfcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (prmryChkFlg[i] != null)
                    model.setPrmryChkFlg(prmryChkFlg[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (intlFaxNo[i] != null)
                    model.setIntlFaxNo(intlFaxNo[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (vndrEml[i] != null)
                    model.setVndrEml(vndrEml[i]);
                if (rfndPsdoCustCd[i] != null)
                    model.setRfndPsdoCustCd(rfndPsdoCustCd[i]);
                if (payTermTpCd[i] != null)
                    model.setPayTermTpCd(payTermTpCd[i]);
                if (chkDeAddr1[i] != null)
                    model.setChkDeAddr1(chkDeAddr1[i]);
                if (chkDeAddr2[i] != null)
                    model.setChkDeAddr2(chkDeAddr2[i]);
                if (chkDeAddr3[i] != null)
                    model.setChkDeAddr3(chkDeAddr3[i]);
                if (chkDeCtyNm[i] != null)
                    model.setChkDeCtyNm(chkDeCtyNm[i]);
                if (chkDeSteCd[i] != null)
                    model.setChkDeSteCd(chkDeSteCd[i]);
                if (chkDeZipCd[i] != null)
                    model.setChkDeZipCd(chkDeZipCd[i]);
                if (chkDeCntCd[i] != null)
                    model.setChkDeCntCd(chkDeCntCd[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (dcgoHndlFlg[i] != null)
                    model.setDcgoHndlFlg(dcgoHndlFlg[i]);
                if (mtyRroEdiUseFlg[i] != null)
                    model.setMtyRroEdiUseFlg(mtyRroEdiUseFlg[i]);
                if (procuFlg[i] != null) 
		    		model.setProcuFlg(procuFlg[i]);
				if (taxId[i] != null) 
		    		model.setTaxId(taxId[i]);
				if (subsCoCd[i] != null) 
		    		model.setSubsCoCd(subsCoCd[i]);
				if (eaiEvntDt[i] != null) 
		    		model.setEaiEvntDt(eaiEvntDt[i]);
				if (eaiIfId[i] != null) 
		    		model.setEaiIfId(eaiIfId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVendorTotalIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VendorIfVO[]
	 */
    public VendorTotalIfVO[] getVendorTotalIfVOs() {
        VendorTotalIfVO[] vos = (VendorTotalIfVO[]) models.toArray(new VendorTotalIfVO[models.size()]);
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
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLoclLangNm = this.vndrLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ceoNm = this.ceoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntCntCd = this.prntCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntVndrSeq = this.prntVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCdNm = this.svcScpCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcPrdTpNm = this.svcPrdTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcPrdRmk = this.svcPrdRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzctNm = this.bzctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bztpNm = this.bztpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.genPayTermCd = this.genPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.engAddr = this.engAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclLangAddr = this.loclLangAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payCurrCd = this.payCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payMzdCd = this.payMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usaEdiCd = this.usaEdiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woAtchFileFlg = this.woAtchFileFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woEdiUseFlg = this.woEdiUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invEdiUseFlg = this.invEdiUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVndrSeq = this.modiVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkFlg = this.blkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincFlg = this.fincFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teamFlg = this.teamFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.interCoFlg = this.interCoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsFlg = this.lgsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otrFlg = this.otrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkVndrSvcCd = this.blkVndrSvcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrOfcCd = this.vndrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlFaxNo = this.intlFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrEml = this.vndrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfndPsdoCustCd = this.rfndPsdoCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payTermTpCd = this.payTermTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeAddr1 = this.chkDeAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeAddr2 = this.chkDeAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeAddr3 = this.chkDeAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeCtyNm = this.chkDeCtyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeSteCd = this.chkDeSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeZipCd = this.chkDeZipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeCntCd = this.chkDeCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoHndlFlg = this.dcgoHndlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyRroEdiUseFlg = this.mtyRroEdiUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.procuFlg = this.procuFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxId = this.taxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subsCoCd = this.subsCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
