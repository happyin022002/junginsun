/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : OfficeMainVO.java
*@FileTitle : OfficeMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo;
 
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
public class OfficeMainIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OfficeMainIfVO> models = new ArrayList<OfficeMainIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String agnKndCd = null;

    /* Column Info */
    private String apCtrCd = null;

    /* Column Info */
    private String apCtrlOfcCd = null;

    /* Column Info */
    private String apEuroCurrUseFlg = null;

    /* Column Info */
    private String apHoAcctCd = null;

    /* Column Info */
    private String apOfcCd = null;

    /* Column Info */
    private String arAgnStlCd = null;

    /* Column Info */
    private String arCtrCd = null;

    /* Column Info */
    private String arCtrlOfcCd = null;

    /* Column Info */
    private String arCurrCd = null;

    /* Column Info */
    private String arHdQtrOfcCd = null;

    /* Column Info */
    private String arOfcCd = null;

    /* Column Info */
    private String asaCrTermDys = null;

    /* Column Info */
    private String bfrOfcCd = null;

    /* Column Info */
    private String bilCurrCd = null;

    /* Column Info */
    private String bkgSvrSrchRoutCd = null;

    /* Column Info */
    private String clzDt = null;

    /* Column Info */
    private String commIfIndCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String docRcvrHideFlg = null;

    /* Column Info */
    private String faxIp = null;

    /* Column Info */
    private String fincHideFlg = null;

    /* Column Info */
    private String fincPsdoOfcFlg = null;

    /* Column Info */
    private String fincRgnCd = null;

    /* Column Info */
    private String fxCurrRt = null;

    /* Column Info */
    private String glCtrCd = null;

    /* Column Info */
    private String ibCrTermDys = null;

    /* Column Info */
    private String intlFaxNo = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String invPfxCd = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String modiOfcCd = null;

    /* Column Info */
    private String obCrTermDys = null;

    /* Column Info */
    private String ofcAddr = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String ofcCmmcCd = null;

    /* Column Info */
    private String ofcEngNm = null;

    /* Column Info */
    private String ofcFaxNo = null;

    /* Column Info */
    private String ofcKndCd = null;

    /* Column Info */
    private String ofcKrnNm = null;

    /* Column Info */
    private String ofcLoclLangAddr = null;

    /* Column Info */
    private String ofcPhnNo = null;

    /* Column Info */
    private String ofcPsonKnt = null;

    /* Column Info */
    private String ofcRepEml = null;

    /* Column Info */
    private String ofcRfaScUseFlg = null;

    /* Column Info */
    private String ofcRmk = null;

    /* Column Info */
    private String ofcSlsDeltFlg = null;

    /* Column Info */
    private String ofcTaxId = null;

    /* Column Info */
    private String ofcTpCd = null;

    /* Column Info */
    private String ofcUrl = null;

    /* Column Info */
    private String ofcZipCd = null;

    /* Column Info */
    private String opnDt = null;

    /* Column Info */
    private String prcOfcCd = null;

    /* Column Info */
    private String prntOfcCd = null;

    /* Column Info */
    private String repCustCntCd = null;

    /* Column Info */
    private String repCustSeq = null;

    /* Column Info */
    private String slsOfcDivCd = null;

    /* Column Info */
    private String slsOfcUseFlg = null;

    /* Column Info */
    private String soIfCd = null;

    /* Column Info */
    private String subAgnFlg = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String usaBrkBrncRqstCtrlOfcCd = null;

    /* Column Info */
    private String vndrCntCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public OfficeMainIfVO() {
    }

    public OfficeMainIfVO(String ibflag, String pagerows, String agnKndCd, String apCtrCd, String apCtrlOfcCd, String apEuroCurrUseFlg, String apHoAcctCd, String apOfcCd, String arAgnStlCd, String arCtrCd, String arCtrlOfcCd, String arCurrCd, String arHdQtrOfcCd, String arOfcCd, String asaCrTermDys, String bfrOfcCd, String bilCurrCd, String bkgSvrSrchRoutCd, String clzDt, String commIfIndCd, String creDt, String creUsrId, String deltFlg, String docRcvrHideFlg, String faxIp, String fincHideFlg, String fincPsdoOfcFlg, String fincRgnCd, String fxCurrRt, String glCtrCd, String ibCrTermDys, String intlFaxNo, String intlPhnNo, String invPfxCd, String locCd, String modiOfcCd, String obCrTermDys, String ofcAddr, String ofcCd, String ofcCmmcCd, String ofcEngNm, String ofcFaxNo, String ofcKndCd, String ofcKrnNm, String ofcLoclLangAddr, String ofcPhnNo, String ofcPsonKnt, String ofcRepEml, String ofcRfaScUseFlg, String ofcRmk, String ofcSlsDeltFlg, String ofcTaxId, String ofcTpCd, String ofcUrl, String ofcZipCd, String opnDt, String prcOfcCd, String prntOfcCd, String repCustCntCd, String repCustSeq, String slsOfcDivCd, String slsOfcUseFlg, String soIfCd, String subAgnFlg, String updDt, String updUsrId, String usaBrkBrncRqstCtrlOfcCd, String vndrCntCd, String vndrSeq, String cudFlg, String eaiEvntDt, String eaiIfId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.agnKndCd = agnKndCd;
        this.apCtrCd = apCtrCd;
        this.apCtrlOfcCd = apCtrlOfcCd;
        this.apEuroCurrUseFlg = apEuroCurrUseFlg;
        this.apHoAcctCd = apHoAcctCd;
        this.apOfcCd = apOfcCd;
        this.arAgnStlCd = arAgnStlCd;
        this.arCtrCd = arCtrCd;
        this.arCtrlOfcCd = arCtrlOfcCd;
        this.arCurrCd = arCurrCd;
        this.arHdQtrOfcCd = arHdQtrOfcCd;
        this.arOfcCd = arOfcCd;
        this.asaCrTermDys = asaCrTermDys;
        this.bfrOfcCd = bfrOfcCd;
        this.bilCurrCd = bilCurrCd;
        this.bkgSvrSrchRoutCd = bkgSvrSrchRoutCd;
        this.clzDt = clzDt;
        this.commIfIndCd = commIfIndCd;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.deltFlg = deltFlg;
        this.docRcvrHideFlg = docRcvrHideFlg;
        this.faxIp = faxIp;
        this.fincHideFlg = fincHideFlg;
        this.fincPsdoOfcFlg = fincPsdoOfcFlg;
        this.fincRgnCd = fincRgnCd;
        this.fxCurrRt = fxCurrRt;
        this.glCtrCd = glCtrCd;
        this.ibCrTermDys = ibCrTermDys;
        this.intlFaxNo = intlFaxNo;
        this.intlPhnNo = intlPhnNo;
        this.invPfxCd = invPfxCd;
        this.locCd = locCd;
        this.modiOfcCd = modiOfcCd;
        this.obCrTermDys = obCrTermDys;
        this.ofcAddr = ofcAddr;
        this.ofcCd = ofcCd;
        this.ofcCmmcCd = ofcCmmcCd;
        this.ofcEngNm = ofcEngNm;
        this.ofcFaxNo = ofcFaxNo;
        this.ofcKndCd = ofcKndCd;
        this.ofcKrnNm = ofcKrnNm;
        this.ofcLoclLangAddr = ofcLoclLangAddr;
        this.ofcPhnNo = ofcPhnNo;
        this.ofcPsonKnt = ofcPsonKnt;
        this.ofcRepEml = ofcRepEml;
        this.ofcRfaScUseFlg = ofcRfaScUseFlg;
        this.ofcRmk = ofcRmk;
        this.ofcSlsDeltFlg = ofcSlsDeltFlg;
        this.ofcTaxId = ofcTaxId;
        this.ofcTpCd = ofcTpCd;
        this.ofcUrl = ofcUrl;
        this.ofcZipCd = ofcZipCd;
        this.opnDt = opnDt;
        this.prcOfcCd = prcOfcCd;
        this.prntOfcCd = prntOfcCd;
        this.repCustCntCd = repCustCntCd;
        this.repCustSeq = repCustSeq;
        this.slsOfcDivCd = slsOfcDivCd;
        this.slsOfcUseFlg = slsOfcUseFlg;
        this.soIfCd = soIfCd;
        this.subAgnFlg = subAgnFlg;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.usaBrkBrncRqstCtrlOfcCd = usaBrkBrncRqstCtrlOfcCd;
        this.vndrCntCd = vndrCntCd;
        this.vndrSeq = vndrSeq;
        this.cudFlg = cudFlg;
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
        this.hashColumns.put("agn_knd_cd", getAgnKndCd());
        this.hashColumns.put("ap_ctr_cd", getApCtrCd());
        this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
        this.hashColumns.put("ap_euro_curr_use_flg", getApEuroCurrUseFlg());
        this.hashColumns.put("ap_ho_acct_cd", getApHoAcctCd());
        this.hashColumns.put("ap_ofc_cd", getApOfcCd());
        this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
        this.hashColumns.put("ar_ctr_cd", getArCtrCd());
        this.hashColumns.put("ar_ctrl_ofc_cd", getArCtrlOfcCd());
        this.hashColumns.put("ar_curr_cd", getArCurrCd());
        this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
        this.hashColumns.put("ar_ofc_cd", getArOfcCd());
        this.hashColumns.put("asa_cr_term_dys", getAsaCrTermDys());
        this.hashColumns.put("bfr_ofc_cd", getBfrOfcCd());
        this.hashColumns.put("bil_curr_cd", getBilCurrCd());
        this.hashColumns.put("bkg_svr_srch_rout_cd", getBkgSvrSrchRoutCd());
        this.hashColumns.put("clz_dt", getClzDt());
        this.hashColumns.put("comm_if_ind_cd", getCommIfIndCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("doc_rcvr_hide_flg", getDocRcvrHideFlg());
        this.hashColumns.put("fax_ip", getFaxIp());
        this.hashColumns.put("finc_hide_flg", getFincHideFlg());
        this.hashColumns.put("finc_psdo_ofc_flg", getFincPsdoOfcFlg());
        this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
        this.hashColumns.put("fx_curr_rt", getFxCurrRt());
        this.hashColumns.put("gl_ctr_cd", getGlCtrCd());
        this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
        this.hashColumns.put("intl_fax_no", getIntlFaxNo());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("inv_pfx_cd", getInvPfxCd());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("modi_ofc_cd", getModiOfcCd());
        this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
        this.hashColumns.put("ofc_addr", getOfcAddr());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ofc_cmmc_cd", getOfcCmmcCd());
        this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
        this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
        this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
        this.hashColumns.put("ofc_krn_nm", getOfcKrnNm());
        this.hashColumns.put("ofc_locl_lang_addr", getOfcLoclLangAddr());
        this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
        this.hashColumns.put("ofc_pson_knt", getOfcPsonKnt());
        this.hashColumns.put("ofc_rep_eml", getOfcRepEml());
        this.hashColumns.put("ofc_rfa_sc_use_flg", getOfcRfaScUseFlg());
        this.hashColumns.put("ofc_rmk", getOfcRmk());
        this.hashColumns.put("ofc_sls_delt_flg", getOfcSlsDeltFlg());
        this.hashColumns.put("ofc_tax_id", getOfcTaxId());
        this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
        this.hashColumns.put("ofc_url", getOfcUrl());
        this.hashColumns.put("ofc_zip_cd", getOfcZipCd());
        this.hashColumns.put("opn_dt", getOpnDt());
        this.hashColumns.put("prc_ofc_cd", getPrcOfcCd());
        this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
        this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
        this.hashColumns.put("rep_cust_seq", getRepCustSeq());
        this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
        this.hashColumns.put("sls_ofc_use_flg", getSlsOfcUseFlg());
        this.hashColumns.put("so_if_cd", getSoIfCd());
        this.hashColumns.put("sub_agn_flg", getSubAgnFlg());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("usa_brk_brnc_rqst_ctrl_ofc_cd", getUsaBrkBrncRqstCtrlOfcCd());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("cud_flg", getCudFlg());
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
        this.hashFields.put("agn_knd_cd", "agnKndCd");
        this.hashFields.put("ap_ctr_cd", "apCtrCd");
        this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
        this.hashFields.put("ap_euro_curr_use_flg", "apEuroCurrUseFlg");
        this.hashFields.put("ap_ho_acct_cd", "apHoAcctCd");
        this.hashFields.put("ap_ofc_cd", "apOfcCd");
        this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
        this.hashFields.put("ar_ctr_cd", "arCtrCd");
        this.hashFields.put("ar_ctrl_ofc_cd", "arCtrlOfcCd");
        this.hashFields.put("ar_curr_cd", "arCurrCd");
        this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
        this.hashFields.put("ar_ofc_cd", "arOfcCd");
        this.hashFields.put("asa_cr_term_dys", "asaCrTermDys");
        this.hashFields.put("bfr_ofc_cd", "bfrOfcCd");
        this.hashFields.put("bil_curr_cd", "bilCurrCd");
        this.hashFields.put("bkg_svr_srch_rout_cd", "bkgSvrSrchRoutCd");
        this.hashFields.put("clz_dt", "clzDt");
        this.hashFields.put("comm_if_ind_cd", "commIfIndCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("doc_rcvr_hide_flg", "docRcvrHideFlg");
        this.hashFields.put("fax_ip", "faxIp");
        this.hashFields.put("finc_hide_flg", "fincHideFlg");
        this.hashFields.put("finc_psdo_ofc_flg", "fincPsdoOfcFlg");
        this.hashFields.put("finc_rgn_cd", "fincRgnCd");
        this.hashFields.put("fx_curr_rt", "fxCurrRt");
        this.hashFields.put("gl_ctr_cd", "glCtrCd");
        this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("inv_pfx_cd", "invPfxCd");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("modi_ofc_cd", "modiOfcCd");
        this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
        this.hashFields.put("ofc_addr", "ofcAddr");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ofc_cmmc_cd", "ofcCmmcCd");
        this.hashFields.put("ofc_eng_nm", "ofcEngNm");
        this.hashFields.put("ofc_fax_no", "ofcFaxNo");
        this.hashFields.put("ofc_knd_cd", "ofcKndCd");
        this.hashFields.put("ofc_krn_nm", "ofcKrnNm");
        this.hashFields.put("ofc_locl_lang_addr", "ofcLoclLangAddr");
        this.hashFields.put("ofc_phn_no", "ofcPhnNo");
        this.hashFields.put("ofc_pson_knt", "ofcPsonKnt");
        this.hashFields.put("ofc_rep_eml", "ofcRepEml");
        this.hashFields.put("ofc_rfa_sc_use_flg", "ofcRfaScUseFlg");
        this.hashFields.put("ofc_rmk", "ofcRmk");
        this.hashFields.put("ofc_sls_delt_flg", "ofcSlsDeltFlg");
        this.hashFields.put("ofc_tax_id", "ofcTaxId");
        this.hashFields.put("ofc_tp_cd", "ofcTpCd");
        this.hashFields.put("ofc_url", "ofcUrl");
        this.hashFields.put("ofc_zip_cd", "ofcZipCd");
        this.hashFields.put("opn_dt", "opnDt");
        this.hashFields.put("prc_ofc_cd", "prcOfcCd");
        this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
        this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
        this.hashFields.put("rep_cust_seq", "repCustSeq");
        this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
        this.hashFields.put("sls_ofc_use_flg", "slsOfcUseFlg");
        this.hashFields.put("so_if_cd", "soIfCd");
        this.hashFields.put("sub_agn_flg", "subAgnFlg");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("usa_brk_brnc_rqst_ctrl_ofc_cd", "usaBrkBrncRqstCtrlOfcCd");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("cud_flg", "cudFlg");
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

    /**
	 *
	 * @param String agnKndCd
	 */
    public void setAgnKndCd(String agnKndCd) {
        this.agnKndCd = agnKndCd;
    }

    /**
	 * 
	 * @return String agnKndCd
	 */
    public String getAgnKndCd() {
        return this.agnKndCd;
    }

    /**
	 *
	 * @param String apCtrCd
	 */
    public void setApCtrCd(String apCtrCd) {
        this.apCtrCd = apCtrCd;
    }

    /**
	 * 
	 * @return String apCtrCd
	 */
    public String getApCtrCd() {
        return this.apCtrCd;
    }

    /**
	 *
	 * @param String apCtrlOfcCd
	 */
    public void setApCtrlOfcCd(String apCtrlOfcCd) {
        this.apCtrlOfcCd = apCtrlOfcCd;
    }

    /**
	 * 
	 * @return String apCtrlOfcCd
	 */
    public String getApCtrlOfcCd() {
        return this.apCtrlOfcCd;
    }

    /**
	 *
	 * @param String apEuroCurrUseFlg
	 */
    public void setApEuroCurrUseFlg(String apEuroCurrUseFlg) {
        this.apEuroCurrUseFlg = apEuroCurrUseFlg;
    }

    /**
	 * 
	 * @return String apEuroCurrUseFlg
	 */
    public String getApEuroCurrUseFlg() {
        return this.apEuroCurrUseFlg;
    }

    /**
	 *
	 * @param String apHoAcctCd
	 */
    public void setApHoAcctCd(String apHoAcctCd) {
        this.apHoAcctCd = apHoAcctCd;
    }

    /**
	 * 
	 * @return String apHoAcctCd
	 */
    public String getApHoAcctCd() {
        return this.apHoAcctCd;
    }

    /**
	 *
	 * @param String apOfcCd
	 */
    public void setApOfcCd(String apOfcCd) {
        this.apOfcCd = apOfcCd;
    }

    /**
	 * 
	 * @return String apOfcCd
	 */
    public String getApOfcCd() {
        return this.apOfcCd;
    }

    /**
	 *
	 * @param String arAgnStlCd
	 */
    public void setArAgnStlCd(String arAgnStlCd) {
        this.arAgnStlCd = arAgnStlCd;
    }

    /**
	 * 
	 * @return String arAgnStlCd
	 */
    public String getArAgnStlCd() {
        return this.arAgnStlCd;
    }

    /**
	 *
	 * @param String arCtrCd
	 */
    public void setArCtrCd(String arCtrCd) {
        this.arCtrCd = arCtrCd;
    }

    /**
	 * 
	 * @return String arCtrCd
	 */
    public String getArCtrCd() {
        return this.arCtrCd;
    }

    /**
	 *
	 * @param String arCtrlOfcCd
	 */
    public void setArCtrlOfcCd(String arCtrlOfcCd) {
        this.arCtrlOfcCd = arCtrlOfcCd;
    }

    /**
	 * 
	 * @return String arCtrlOfcCd
	 */
    public String getArCtrlOfcCd() {
        return this.arCtrlOfcCd;
    }

    /**
	 *
	 * @param String arCurrCd
	 */
    public void setArCurrCd(String arCurrCd) {
        this.arCurrCd = arCurrCd;
    }

    /**
	 * 
	 * @return String arCurrCd
	 */
    public String getArCurrCd() {
        return this.arCurrCd;
    }

    /**
	 *
	 * @param String arHdQtrOfcCd
	 */
    public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
        this.arHdQtrOfcCd = arHdQtrOfcCd;
    }

    /**
	 * 
	 * @return String arHdQtrOfcCd
	 */
    public String getArHdQtrOfcCd() {
        return this.arHdQtrOfcCd;
    }

    /**
	 *
	 * @param String arOfcCd
	 */
    public void setArOfcCd(String arOfcCd) {
        this.arOfcCd = arOfcCd;
    }

    /**
	 * 
	 * @return String arOfcCd
	 */
    public String getArOfcCd() {
        return this.arOfcCd;
    }

    /**
	 *
	 * @param String asaCrTermDys
	 */
    public void setAsaCrTermDys(String asaCrTermDys) {
        this.asaCrTermDys = asaCrTermDys;
    }

    /**
	 * 
	 * @return String asaCrTermDys
	 */
    public String getAsaCrTermDys() {
        return this.asaCrTermDys;
    }

    /**
	 *
	 * @param String bfrOfcCd
	 */
    public void setBfrOfcCd(String bfrOfcCd) {
        this.bfrOfcCd = bfrOfcCd;
    }

    /**
	 * 
	 * @return String bfrOfcCd
	 */
    public String getBfrOfcCd() {
        return this.bfrOfcCd;
    }

    /**
	 *
	 * @param String bilCurrCd
	 */
    public void setBilCurrCd(String bilCurrCd) {
        this.bilCurrCd = bilCurrCd;
    }

    /**
	 * 
	 * @return String bilCurrCd
	 */
    public String getBilCurrCd() {
        return this.bilCurrCd;
    }

    /**
	 *
	 * @param String bkgSvrSrchRoutCd
	 */
    public void setBkgSvrSrchRoutCd(String bkgSvrSrchRoutCd) {
        this.bkgSvrSrchRoutCd = bkgSvrSrchRoutCd;
    }

    /**
	 * 
	 * @return String bkgSvrSrchRoutCd
	 */
    public String getBkgSvrSrchRoutCd() {
        return this.bkgSvrSrchRoutCd;
    }

    /**
	 *
	 * @param String clzDt
	 */
    public void setClzDt(String clzDt) {
        this.clzDt = clzDt;
    }

    /**
	 * 
	 * @return String clzDt
	 */
    public String getClzDt() {
        return this.clzDt;
    }

    /**
	 *
	 * @param String commIfIndCd
	 */
    public void setCommIfIndCd(String commIfIndCd) {
        this.commIfIndCd = commIfIndCd;
    }

    /**
	 * 
	 * @return String commIfIndCd
	 */
    public String getCommIfIndCd() {
        return this.commIfIndCd;
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

    /**
	 *
	 * @param String docRcvrHideFlg
	 */
    public void setDocRcvrHideFlg(String docRcvrHideFlg) {
        this.docRcvrHideFlg = docRcvrHideFlg;
    }

    /**
	 * 
	 * @return String docRcvrHideFlg
	 */
    public String getDocRcvrHideFlg() {
        return this.docRcvrHideFlg;
    }

    /**
	 *
	 * @param String faxIp
	 */
    public void setFaxIp(String faxIp) {
        this.faxIp = faxIp;
    }

    /**
	 * 
	 * @return String faxIp
	 */
    public String getFaxIp() {
        return this.faxIp;
    }

    /**
	 *
	 * @param String fincHideFlg
	 */
    public void setFincHideFlg(String fincHideFlg) {
        this.fincHideFlg = fincHideFlg;
    }

    /**
	 * 
	 * @return String fincHideFlg
	 */
    public String getFincHideFlg() {
        return this.fincHideFlg;
    }

    /**
	 *
	 * @param String fincPsdoOfcFlg
	 */
    public void setFincPsdoOfcFlg(String fincPsdoOfcFlg) {
        this.fincPsdoOfcFlg = fincPsdoOfcFlg;
    }

    /**
	 * 
	 * @return String fincPsdoOfcFlg
	 */
    public String getFincPsdoOfcFlg() {
        return this.fincPsdoOfcFlg;
    }

    /**
	 *
	 * @param String fincRgnCd
	 */
    public void setFincRgnCd(String fincRgnCd) {
        this.fincRgnCd = fincRgnCd;
    }

    /**
	 * 
	 * @return String fincRgnCd
	 */
    public String getFincRgnCd() {
        return this.fincRgnCd;
    }

    /**
	 *
	 * @param String fxCurrRt
	 */
    public void setFxCurrRt(String fxCurrRt) {
        this.fxCurrRt = fxCurrRt;
    }

    /**
	 * 
	 * @return String fxCurrRt
	 */
    public String getFxCurrRt() {
        return this.fxCurrRt;
    }

    /**
	 *
	 * @param String glCtrCd
	 */
    public void setGlCtrCd(String glCtrCd) {
        this.glCtrCd = glCtrCd;
    }

    /**
	 * 
	 * @return String glCtrCd
	 */
    public String getGlCtrCd() {
        return this.glCtrCd;
    }

    /**
	 *
	 * @param String ibCrTermDys
	 */
    public void setIbCrTermDys(String ibCrTermDys) {
        this.ibCrTermDys = ibCrTermDys;
    }

    /**
	 * 
	 * @return String ibCrTermDys
	 */
    public String getIbCrTermDys() {
        return this.ibCrTermDys;
    }

    /**
	 *
	 * @param String intlFaxNo
	 */
    public void setIntlFaxNo(String intlFaxNo) {
        this.intlFaxNo = intlFaxNo;
    }

    /**
	 * 
	 * @return String intlFaxNo
	 */
    public String getIntlFaxNo() {
        return this.intlFaxNo;
    }

    /**
	 *
	 * @param String intlPhnNo
	 */
    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    /**
	 * 
	 * @return String intlPhnNo
	 */
    public String getIntlPhnNo() {
        return this.intlPhnNo;
    }

    /**
	 *
	 * @param String invPfxCd
	 */
    public void setInvPfxCd(String invPfxCd) {
        this.invPfxCd = invPfxCd;
    }

    /**
	 * 
	 * @return String invPfxCd
	 */
    public String getInvPfxCd() {
        return this.invPfxCd;
    }

    /**
	 *
	 * @param String locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * 
	 * @return String locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 *
	 * @param String modiOfcCd
	 */
    public void setModiOfcCd(String modiOfcCd) {
        this.modiOfcCd = modiOfcCd;
    }

    /**
	 * 
	 * @return String modiOfcCd
	 */
    public String getModiOfcCd() {
        return this.modiOfcCd;
    }

    /**
	 *
	 * @param String obCrTermDys
	 */
    public void setObCrTermDys(String obCrTermDys) {
        this.obCrTermDys = obCrTermDys;
    }

    /**
	 * 
	 * @return String obCrTermDys
	 */
    public String getObCrTermDys() {
        return this.obCrTermDys;
    }

    /**
	 *
	 * @param String ofcAddr
	 */
    public void setOfcAddr(String ofcAddr) {
        this.ofcAddr = ofcAddr;
    }

    /**
	 * 
	 * @return String ofcAddr
	 */
    public String getOfcAddr() {
        return this.ofcAddr;
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
	 * @param String ofcCmmcCd
	 */
    public void setOfcCmmcCd(String ofcCmmcCd) {
        this.ofcCmmcCd = ofcCmmcCd;
    }

    /**
	 * 
	 * @return String ofcCmmcCd
	 */
    public String getOfcCmmcCd() {
        return this.ofcCmmcCd;
    }

    /**
	 *
	 * @param String ofcEngNm
	 */
    public void setOfcEngNm(String ofcEngNm) {
        this.ofcEngNm = ofcEngNm;
    }

    /**
	 * 
	 * @return String ofcEngNm
	 */
    public String getOfcEngNm() {
        return this.ofcEngNm;
    }

    /**
	 *
	 * @param String ofcFaxNo
	 */
    public void setOfcFaxNo(String ofcFaxNo) {
        this.ofcFaxNo = ofcFaxNo;
    }

    /**
	 * 
	 * @return String ofcFaxNo
	 */
    public String getOfcFaxNo() {
        return this.ofcFaxNo;
    }

    /**
	 *
	 * @param String ofcKndCd
	 */
    public void setOfcKndCd(String ofcKndCd) {
        this.ofcKndCd = ofcKndCd;
    }

    /**
	 * 
	 * @return String ofcKndCd
	 */
    public String getOfcKndCd() {
        return this.ofcKndCd;
    }

    /**
	 *
	 * @param String ofcKrnNm
	 */
    public void setOfcKrnNm(String ofcKrnNm) {
        this.ofcKrnNm = ofcKrnNm;
    }

    /**
	 * 
	 * @return String ofcKrnNm
	 */
    public String getOfcKrnNm() {
        return this.ofcKrnNm;
    }

    /**
	 *
	 * @param String ofcLoclLangAddr
	 */
    public void setOfcLoclLangAddr(String ofcLoclLangAddr) {
        this.ofcLoclLangAddr = ofcLoclLangAddr;
    }

    /**
	 * 
	 * @return String ofcLoclLangAddr
	 */
    public String getOfcLoclLangAddr() {
        return this.ofcLoclLangAddr;
    }

    /**
	 *
	 * @param String ofcPhnNo
	 */
    public void setOfcPhnNo(String ofcPhnNo) {
        this.ofcPhnNo = ofcPhnNo;
    }

    /**
	 * 
	 * @return String ofcPhnNo
	 */
    public String getOfcPhnNo() {
        return this.ofcPhnNo;
    }

    /**
	 *
	 * @param String ofcPsonKnt
	 */
    public void setOfcPsonKnt(String ofcPsonKnt) {
        this.ofcPsonKnt = ofcPsonKnt;
    }

    /**
	 * 
	 * @return String ofcPsonKnt
	 */
    public String getOfcPsonKnt() {
        return this.ofcPsonKnt;
    }

    /**
	 *
	 * @param String ofcRepEml
	 */
    public void setOfcRepEml(String ofcRepEml) {
        this.ofcRepEml = ofcRepEml;
    }

    /**
	 * 
	 * @return String ofcRepEml
	 */
    public String getOfcRepEml() {
        return this.ofcRepEml;
    }

    /**
	 *
	 * @param String ofcRfaScUseFlg
	 */
    public void setOfcRfaScUseFlg(String ofcRfaScUseFlg) {
        this.ofcRfaScUseFlg = ofcRfaScUseFlg;
    }

    /**
	 * 
	 * @return String ofcRfaScUseFlg
	 */
    public String getOfcRfaScUseFlg() {
        return this.ofcRfaScUseFlg;
    }

    /**
	 *
	 * @param String ofcRmk
	 */
    public void setOfcRmk(String ofcRmk) {
        this.ofcRmk = ofcRmk;
    }

    /**
	 * 
	 * @return String ofcRmk
	 */
    public String getOfcRmk() {
        return this.ofcRmk;
    }

    /**
	 *
	 * @param String ofcSlsDeltFlg
	 */
    public void setOfcSlsDeltFlg(String ofcSlsDeltFlg) {
        this.ofcSlsDeltFlg = ofcSlsDeltFlg;
    }

    /**
	 * 
	 * @return String ofcSlsDeltFlg
	 */
    public String getOfcSlsDeltFlg() {
        return this.ofcSlsDeltFlg;
    }

    /**
	 *
	 * @param String ofcTaxId
	 */
    public void setOfcTaxId(String ofcTaxId) {
        this.ofcTaxId = ofcTaxId;
    }

    /**
	 * 
	 * @return String ofcTaxId
	 */
    public String getOfcTaxId() {
        return this.ofcTaxId;
    }

    /**
	 *
	 * @param String ofcTpCd
	 */
    public void setOfcTpCd(String ofcTpCd) {
        this.ofcTpCd = ofcTpCd;
    }

    /**
	 * 
	 * @return String ofcTpCd
	 */
    public String getOfcTpCd() {
        return this.ofcTpCd;
    }

    /**
	 *
	 * @param String ofcUrl
	 */
    public void setOfcUrl(String ofcUrl) {
        this.ofcUrl = ofcUrl;
    }

    /**
	 * 
	 * @return String ofcUrl
	 */
    public String getOfcUrl() {
        return this.ofcUrl;
    }

    /**
	 *
	 * @param String ofcZipCd
	 */
    public void setOfcZipCd(String ofcZipCd) {
        this.ofcZipCd = ofcZipCd;
    }

    /**
	 * 
	 * @return String ofcZipCd
	 */
    public String getOfcZipCd() {
        return this.ofcZipCd;
    }

    /**
	 *
	 * @param String opnDt
	 */
    public void setOpnDt(String opnDt) {
        this.opnDt = opnDt;
    }

    /**
	 * 
	 * @return String opnDt
	 */
    public String getOpnDt() {
        return this.opnDt;
    }

    /**
	 *
	 * @param String prcOfcCd
	 */
    public void setPrcOfcCd(String prcOfcCd) {
        this.prcOfcCd = prcOfcCd;
    }

    /**
	 * 
	 * @return String prcOfcCd
	 */
    public String getPrcOfcCd() {
        return this.prcOfcCd;
    }

    /**
	 *
	 * @param String prntOfcCd
	 */
    public void setPrntOfcCd(String prntOfcCd) {
        this.prntOfcCd = prntOfcCd;
    }

    /**
	 * 
	 * @return String prntOfcCd
	 */
    public String getPrntOfcCd() {
        return this.prntOfcCd;
    }

    /**
	 *
	 * @param String repCustCntCd
	 */
    public void setRepCustCntCd(String repCustCntCd) {
        this.repCustCntCd = repCustCntCd;
    }

    /**
	 * 
	 * @return String repCustCntCd
	 */
    public String getRepCustCntCd() {
        return this.repCustCntCd;
    }

    /**
	 *
	 * @param String repCustSeq
	 */
    public void setRepCustSeq(String repCustSeq) {
        this.repCustSeq = repCustSeq;
    }

    /**
	 * 
	 * @return String repCustSeq
	 */
    public String getRepCustSeq() {
        return this.repCustSeq;
    }

    /**
	 *
	 * @param String slsOfcDivCd
	 */
    public void setSlsOfcDivCd(String slsOfcDivCd) {
        this.slsOfcDivCd = slsOfcDivCd;
    }

    /**
	 * 
	 * @return String slsOfcDivCd
	 */
    public String getSlsOfcDivCd() {
        return this.slsOfcDivCd;
    }

    /**
	 *
	 * @param String slsOfcUseFlg
	 */
    public void setSlsOfcUseFlg(String slsOfcUseFlg) {
        this.slsOfcUseFlg = slsOfcUseFlg;
    }

    /**
	 * 
	 * @return String slsOfcUseFlg
	 */
    public String getSlsOfcUseFlg() {
        return this.slsOfcUseFlg;
    }

    /**
	 *
	 * @param String soIfCd
	 */
    public void setSoIfCd(String soIfCd) {
        this.soIfCd = soIfCd;
    }

    /**
	 * 
	 * @return String soIfCd
	 */
    public String getSoIfCd() {
        return this.soIfCd;
    }

    /**
	 *
	 * @param String subAgnFlg
	 */
    public void setSubAgnFlg(String subAgnFlg) {
        this.subAgnFlg = subAgnFlg;
    }

    /**
	 * 
	 * @return String subAgnFlg
	 */
    public String getSubAgnFlg() {
        return this.subAgnFlg;
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
	 * @param String usaBrkBrncRqstCtrlOfcCd
	 */
    public void setUsaBrkBrncRqstCtrlOfcCd(String usaBrkBrncRqstCtrlOfcCd) {
        this.usaBrkBrncRqstCtrlOfcCd = usaBrkBrncRqstCtrlOfcCd;
    }

    /**
	 * 
	 * @return String usaBrkBrncRqstCtrlOfcCd
	 */
    public String getUsaBrkBrncRqstCtrlOfcCd() {
        return this.usaBrkBrncRqstCtrlOfcCd;
    }

    /**
	 *
	 * @param String vndrCntCd
	 */
    public void setVndrCntCd(String vndrCntCd) {
        this.vndrCntCd = vndrCntCd;
    }

    /**
	 * 
	 * @return String vndrCntCd
	 */
    public String getVndrCntCd() {
        return this.vndrCntCd;
    }

    /**
	 *
	 * @param String vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * 
	 * @return String vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 *
	 * @param String cudFlg
	 */
    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    /**
	 * 
	 * @return String cudFlg
	 */
    public String getCudFlg() {
        return this.cudFlg;
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
        setAgnKndCd(JSPUtil.getParameter(request, prefix + "agn_knd_cd", ""));
        setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
        setApCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", ""));
        setApEuroCurrUseFlg(JSPUtil.getParameter(request, prefix + "ap_euro_curr_use_flg", ""));
        setApHoAcctCd(JSPUtil.getParameter(request, prefix + "ap_ho_acct_cd", ""));
        setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
        setArAgnStlCd(JSPUtil.getParameter(request, prefix + "ar_agn_stl_cd", ""));
        setArCtrCd(JSPUtil.getParameter(request, prefix + "ar_ctr_cd", ""));
        setArCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ar_ctrl_ofc_cd", ""));
        setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
        setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
        setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
        setAsaCrTermDys(JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", ""));
        setBfrOfcCd(JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", ""));
        setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
        setBkgSvrSrchRoutCd(JSPUtil.getParameter(request, prefix + "bkg_svr_srch_rout_cd", ""));
        setClzDt(JSPUtil.getParameter(request, prefix + "clz_dt", ""));
        setCommIfIndCd(JSPUtil.getParameter(request, prefix + "comm_if_ind_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setDocRcvrHideFlg(JSPUtil.getParameter(request, prefix + "doc_rcvr_hide_flg", ""));
        setFaxIp(JSPUtil.getParameter(request, prefix + "fax_ip", ""));
        setFincHideFlg(JSPUtil.getParameter(request, prefix + "finc_hide_flg", ""));
        setFincPsdoOfcFlg(JSPUtil.getParameter(request, prefix + "finc_psdo_ofc_flg", ""));
        setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
        setFxCurrRt(JSPUtil.getParameter(request, prefix + "fx_curr_rt", ""));
        setGlCtrCd(JSPUtil.getParameter(request, prefix + "gl_ctr_cd", ""));
        setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
        setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setInvPfxCd(JSPUtil.getParameter(request, prefix + "inv_pfx_cd", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setModiOfcCd(JSPUtil.getParameter(request, prefix + "modi_ofc_cd", ""));
        setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
        setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setOfcCmmcCd(JSPUtil.getParameter(request, prefix + "ofc_cmmc_cd", ""));
        setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
        setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
        setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
        setOfcKrnNm(JSPUtil.getParameter(request, prefix + "ofc_krn_nm", ""));
        setOfcLoclLangAddr(JSPUtil.getParameter(request, prefix + "ofc_locl_lang_addr", ""));
        setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
        setOfcPsonKnt(JSPUtil.getParameter(request, prefix + "ofc_pson_knt", ""));
        setOfcRepEml(JSPUtil.getParameter(request, prefix + "ofc_rep_eml", ""));
        setOfcRfaScUseFlg(JSPUtil.getParameter(request, prefix + "ofc_rfa_sc_use_flg", ""));
        setOfcRmk(JSPUtil.getParameter(request, prefix + "ofc_rmk", ""));
        setOfcSlsDeltFlg(JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", ""));
        setOfcTaxId(JSPUtil.getParameter(request, prefix + "ofc_tax_id", ""));
        setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
        setOfcUrl(JSPUtil.getParameter(request, prefix + "ofc_url", ""));
        setOfcZipCd(JSPUtil.getParameter(request, prefix + "ofc_zip_cd", ""));
        setOpnDt(JSPUtil.getParameter(request, prefix + "opn_dt", ""));
        setPrcOfcCd(JSPUtil.getParameter(request, prefix + "prc_ofc_cd", ""));
        setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
        setRepCustCntCd(JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", ""));
        setRepCustSeq(JSPUtil.getParameter(request, prefix + "rep_cust_seq", ""));
        setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
        setSlsOfcUseFlg(JSPUtil.getParameter(request, prefix + "sls_ofc_use_flg", ""));
        setSoIfCd(JSPUtil.getParameter(request, prefix + "so_if_cd", ""));
        setSubAgnFlg(JSPUtil.getParameter(request, prefix + "sub_agn_flg", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUsaBrkBrncRqstCtrlOfcCd(JSPUtil.getParameter(request, prefix + "usa_brk_brnc_rqst_ctrl_ofc_cd", ""));
        setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeMainIfVO[]
	 */
    public OfficeMainIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeMainVO[]
	 */
    public OfficeMainIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OfficeMainIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] agnKndCd = (JSPUtil.getParameter(request, prefix + "agn_knd_cd", length));
            String[] apCtrCd = (JSPUtil.getParameter(request, prefix + "ap_ctr_cd", length));
            String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", length));
            String[] apEuroCurrUseFlg = (JSPUtil.getParameter(request, prefix + "ap_euro_curr_use_flg", length));
            String[] apHoAcctCd = (JSPUtil.getParameter(request, prefix + "ap_ho_acct_cd", length));
            String[] apOfcCd = (JSPUtil.getParameter(request, prefix + "ap_ofc_cd", length));
            String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix + "ar_agn_stl_cd", length));
            String[] arCtrCd = (JSPUtil.getParameter(request, prefix + "ar_ctr_cd", length));
            String[] arCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "ar_ctrl_ofc_cd", length));
            String[] arCurrCd = (JSPUtil.getParameter(request, prefix + "ar_curr_cd", length));
            String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", length));
            String[] arOfcCd = (JSPUtil.getParameter(request, prefix + "ar_ofc_cd", length));
            String[] asaCrTermDys = (JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", length));
            String[] bfrOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", length));
            String[] bilCurrCd = (JSPUtil.getParameter(request, prefix + "bil_curr_cd", length));
            String[] bkgSvrSrchRoutCd = (JSPUtil.getParameter(request, prefix + "bkg_svr_srch_rout_cd", length));
            String[] clzDt = (JSPUtil.getParameter(request, prefix + "clz_dt", length));
            String[] commIfIndCd = (JSPUtil.getParameter(request, prefix + "comm_if_ind_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] docRcvrHideFlg = (JSPUtil.getParameter(request, prefix + "doc_rcvr_hide_flg", length));
            String[] faxIp = (JSPUtil.getParameter(request, prefix + "fax_ip", length));
            String[] fincHideFlg = (JSPUtil.getParameter(request, prefix + "finc_hide_flg", length));
            String[] fincPsdoOfcFlg = (JSPUtil.getParameter(request, prefix + "finc_psdo_ofc_flg", length));
            String[] fincRgnCd = (JSPUtil.getParameter(request, prefix + "finc_rgn_cd", length));
            String[] fxCurrRt = (JSPUtil.getParameter(request, prefix + "fx_curr_rt", length));
            String[] glCtrCd = (JSPUtil.getParameter(request, prefix + "gl_ctr_cd", length));
            String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", length));
            String[] intlFaxNo = (JSPUtil.getParameter(request, prefix + "intl_fax_no", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] invPfxCd = (JSPUtil.getParameter(request, prefix + "inv_pfx_cd", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] modiOfcCd = (JSPUtil.getParameter(request, prefix + "modi_ofc_cd", length));
            String[] obCrTermDys = (JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", length));
            String[] ofcAddr = (JSPUtil.getParameter(request, prefix + "ofc_addr", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ofcCmmcCd = (JSPUtil.getParameter(request, prefix + "ofc_cmmc_cd", length));
            String[] ofcEngNm = (JSPUtil.getParameter(request, prefix + "ofc_eng_nm", length));
            String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix + "ofc_fax_no", length));
            String[] ofcKndCd = (JSPUtil.getParameter(request, prefix + "ofc_knd_cd", length));
            String[] ofcKrnNm = (JSPUtil.getParameter(request, prefix + "ofc_krn_nm", length));
            String[] ofcLoclLangAddr = (JSPUtil.getParameter(request, prefix + "ofc_locl_lang_addr", length));
            String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix + "ofc_phn_no", length));
            String[] ofcPsonKnt = (JSPUtil.getParameter(request, prefix + "ofc_pson_knt", length));
            String[] ofcRepEml = (JSPUtil.getParameter(request, prefix + "ofc_rep_eml", length));
            String[] ofcRfaScUseFlg = (JSPUtil.getParameter(request, prefix + "ofc_rfa_sc_use_flg", length));
            String[] ofcRmk = (JSPUtil.getParameter(request, prefix + "ofc_rmk", length));
            String[] ofcSlsDeltFlg = (JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", length));
            String[] ofcTaxId = (JSPUtil.getParameter(request, prefix + "ofc_tax_id", length));
            String[] ofcTpCd = (JSPUtil.getParameter(request, prefix + "ofc_tp_cd", length));
            String[] ofcUrl = (JSPUtil.getParameter(request, prefix + "ofc_url", length));
            String[] ofcZipCd = (JSPUtil.getParameter(request, prefix + "ofc_zip_cd", length));
            String[] opnDt = (JSPUtil.getParameter(request, prefix + "opn_dt", length));
            String[] prcOfcCd = (JSPUtil.getParameter(request, prefix + "prc_ofc_cd", length));
            String[] prntOfcCd = (JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", length));
            String[] repCustCntCd = (JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", length));
            String[] repCustSeq = (JSPUtil.getParameter(request, prefix + "rep_cust_seq", length));
            String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", length));
            String[] slsOfcUseFlg = (JSPUtil.getParameter(request, prefix + "sls_ofc_use_flg", length));
            String[] soIfCd = (JSPUtil.getParameter(request, prefix + "so_if_cd", length));
            String[] subAgnFlg = (JSPUtil.getParameter(request, prefix + "sub_agn_flg", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] usaBrkBrncRqstCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "usa_brk_brnc_rqst_ctrl_ofc_cd", length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
	    	String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OfficeMainIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (agnKndCd[i] != null)
                    model.setAgnKndCd(agnKndCd[i]);
                if (apCtrCd[i] != null)
                    model.setApCtrCd(apCtrCd[i]);
                if (apCtrlOfcCd[i] != null)
                    model.setApCtrlOfcCd(apCtrlOfcCd[i]);
                if (apEuroCurrUseFlg[i] != null)
                    model.setApEuroCurrUseFlg(apEuroCurrUseFlg[i]);
                if (apHoAcctCd[i] != null)
                    model.setApHoAcctCd(apHoAcctCd[i]);
                if (apOfcCd[i] != null)
                    model.setApOfcCd(apOfcCd[i]);
                if (arAgnStlCd[i] != null)
                    model.setArAgnStlCd(arAgnStlCd[i]);
                if (arCtrCd[i] != null)
                    model.setArCtrCd(arCtrCd[i]);
                if (arCtrlOfcCd[i] != null)
                    model.setArCtrlOfcCd(arCtrlOfcCd[i]);
                if (arCurrCd[i] != null)
                    model.setArCurrCd(arCurrCd[i]);
                if (arHdQtrOfcCd[i] != null)
                    model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
                if (arOfcCd[i] != null)
                    model.setArOfcCd(arOfcCd[i]);
                if (asaCrTermDys[i] != null)
                    model.setAsaCrTermDys(asaCrTermDys[i]);
                if (bfrOfcCd[i] != null)
                    model.setBfrOfcCd(bfrOfcCd[i]);
                if (bilCurrCd[i] != null)
                    model.setBilCurrCd(bilCurrCd[i]);
                if (bkgSvrSrchRoutCd[i] != null)
                    model.setBkgSvrSrchRoutCd(bkgSvrSrchRoutCd[i]);
                if (clzDt[i] != null)
                    model.setClzDt(clzDt[i]);
                if (commIfIndCd[i] != null)
                    model.setCommIfIndCd(commIfIndCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (docRcvrHideFlg[i] != null)
                    model.setDocRcvrHideFlg(docRcvrHideFlg[i]);
                if (faxIp[i] != null)
                    model.setFaxIp(faxIp[i]);
                if (fincHideFlg[i] != null)
                    model.setFincHideFlg(fincHideFlg[i]);
                if (fincPsdoOfcFlg[i] != null)
                    model.setFincPsdoOfcFlg(fincPsdoOfcFlg[i]);
                if (fincRgnCd[i] != null)
                    model.setFincRgnCd(fincRgnCd[i]);
                if (fxCurrRt[i] != null)
                    model.setFxCurrRt(fxCurrRt[i]);
                if (glCtrCd[i] != null)
                    model.setGlCtrCd(glCtrCd[i]);
                if (ibCrTermDys[i] != null)
                    model.setIbCrTermDys(ibCrTermDys[i]);
                if (intlFaxNo[i] != null)
                    model.setIntlFaxNo(intlFaxNo[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (invPfxCd[i] != null)
                    model.setInvPfxCd(invPfxCd[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (modiOfcCd[i] != null)
                    model.setModiOfcCd(modiOfcCd[i]);
                if (obCrTermDys[i] != null)
                    model.setObCrTermDys(obCrTermDys[i]);
                if (ofcAddr[i] != null)
                    model.setOfcAddr(ofcAddr[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ofcCmmcCd[i] != null)
                    model.setOfcCmmcCd(ofcCmmcCd[i]);
                if (ofcEngNm[i] != null)
                    model.setOfcEngNm(ofcEngNm[i]);
                if (ofcFaxNo[i] != null)
                    model.setOfcFaxNo(ofcFaxNo[i]);
                if (ofcKndCd[i] != null)
                    model.setOfcKndCd(ofcKndCd[i]);
                if (ofcKrnNm[i] != null)
                    model.setOfcKrnNm(ofcKrnNm[i]);
                if (ofcLoclLangAddr[i] != null)
                    model.setOfcLoclLangAddr(ofcLoclLangAddr[i]);
                if (ofcPhnNo[i] != null)
                    model.setOfcPhnNo(ofcPhnNo[i]);
                if (ofcPsonKnt[i] != null)
                    model.setOfcPsonKnt(ofcPsonKnt[i]);
                if (ofcRepEml[i] != null)
                    model.setOfcRepEml(ofcRepEml[i]);
                if (ofcRfaScUseFlg[i] != null)
                    model.setOfcRfaScUseFlg(ofcRfaScUseFlg[i]);
                if (ofcRmk[i] != null)
                    model.setOfcRmk(ofcRmk[i]);
                if (ofcSlsDeltFlg[i] != null)
                    model.setOfcSlsDeltFlg(ofcSlsDeltFlg[i]);
                if (ofcTaxId[i] != null)
                    model.setOfcTaxId(ofcTaxId[i]);
                if (ofcTpCd[i] != null)
                    model.setOfcTpCd(ofcTpCd[i]);
                if (ofcUrl[i] != null)
                    model.setOfcUrl(ofcUrl[i]);
                if (ofcZipCd[i] != null)
                    model.setOfcZipCd(ofcZipCd[i]);
                if (opnDt[i] != null)
                    model.setOpnDt(opnDt[i]);
                if (prcOfcCd[i] != null)
                    model.setPrcOfcCd(prcOfcCd[i]);
                if (prntOfcCd[i] != null)
                    model.setPrntOfcCd(prntOfcCd[i]);
                if (repCustCntCd[i] != null)
                    model.setRepCustCntCd(repCustCntCd[i]);
                if (repCustSeq[i] != null)
                    model.setRepCustSeq(repCustSeq[i]);
                if (slsOfcDivCd[i] != null)
                    model.setSlsOfcDivCd(slsOfcDivCd[i]);
                if (slsOfcUseFlg[i] != null)
                    model.setSlsOfcUseFlg(slsOfcUseFlg[i]);
                if (soIfCd[i] != null)
                    model.setSoIfCd(soIfCd[i]);
                if (subAgnFlg[i] != null)
                    model.setSubAgnFlg(subAgnFlg[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (usaBrkBrncRqstCtrlOfcCd[i] != null)
                    model.setUsaBrkBrncRqstCtrlOfcCd(usaBrkBrncRqstCtrlOfcCd[i]);
                if (vndrCntCd[i] != null)
                    model.setVndrCntCd(vndrCntCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
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
        return getOfficeMainIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OfficeMainVO[]
	 */
    public OfficeMainIfVO[] getOfficeMainIfVOs() {
        OfficeMainIfVO[] vos = (OfficeMainIfVO[]) models.toArray(new OfficeMainIfVO[models.size()]);
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
        this.agnKndCd = this.agnKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apCtrCd = this.apCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apCtrlOfcCd = this.apCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apEuroCurrUseFlg = this.apEuroCurrUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apHoAcctCd = this.apHoAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apOfcCd = this.apOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arAgnStlCd = this.arAgnStlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arCtrCd = this.arCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arCtrlOfcCd = this.arCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arCurrCd = this.arCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arHdQtrOfcCd = this.arHdQtrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arOfcCd = this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.asaCrTermDys = this.asaCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCd = this.bfrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilCurrCd = this.bilCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgSvrSrchRoutCd = this.bkgSvrSrchRoutCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clzDt = this.clzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commIfIndCd = this.commIfIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docRcvrHideFlg = this.docRcvrHideFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxIp = this.faxIp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincHideFlg = this.fincHideFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincPsdoOfcFlg = this.fincPsdoOfcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincRgnCd = this.fincRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fxCurrRt = this.fxCurrRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.glCtrCd = this.glCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCrTermDys = this.ibCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlFaxNo = this.intlFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPfxCd = this.invPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiOfcCd = this.modiOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCrTermDys = this.obCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcAddr = this.ofcAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCmmcCd = this.ofcCmmcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcEngNm = this.ofcEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcFaxNo = this.ofcFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcKndCd = this.ofcKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcKrnNm = this.ofcKrnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcLoclLangAddr = this.ofcLoclLangAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcPhnNo = this.ofcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcPsonKnt = this.ofcPsonKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcRepEml = this.ofcRepEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcRfaScUseFlg = this.ofcRfaScUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcRmk = this.ofcRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcSlsDeltFlg = this.ofcSlsDeltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcTaxId = this.ofcTaxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcTpCd = this.ofcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcUrl = this.ofcUrl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcZipCd = this.ofcZipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opnDt = this.opnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcOfcCd = this.prcOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntOfcCd = this.prntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCustCntCd = this.repCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCustSeq = this.repCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcDivCd = this.slsOfcDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcUseFlg = this.slsOfcUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soIfCd = this.soIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subAgnFlg = this.subAgnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usaBrkBrncRqstCtrlOfcCd = this.usaBrkBrncRqstCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
