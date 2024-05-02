/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OfficeIfVO.java
*@FileTitle : OfficeIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
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
public class OfficeIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OfficeIfVO> models = new ArrayList<OfficeIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcIfSeq = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String ofcEngNm = null;

    /* Column Info */
    private String ofcLoclNm = null;

    /* Column Info */
    private String ofcAddr = null;

    /* Column Info */
    private String ofcZipCd = null;

    /* Column Info */
    private String ofcKndCd = null;

    /* Column Info */
    private String agnKndCd = null;

    /* Column Info */
    private String vndrCntCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String ofcPhnNo = null;

    /* Column Info */
    private String intlFaxNo = null;

    /* Column Info */
    private String ofcFaxNo = null;

    /* Column Info */
    private String ofcRmk = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String bilCurrCd = null;

    /* Column Info */
    private String arCurrCd = null;

    /* Column Info */
    private String arCtrCd = null;

    /* Column Info */
    private String prntOfcCd = null;

    /* Column Info */
    private String opnDt = null;

    /* Column Info */
    private String clzDt = null;

    /* Column Info */
    private String fincRgnCd = null;

    /* Column Info */
    private String arOfcCd = null;

    /* Column Info */
    private String arHdQtrOfcCd = null;

    /* Column Info */
    private String ibCrTermDys = null;

    /* Column Info */
    private String obCrTermDys = null;

    /* Column Info */
    private String repCustCntCd = null;

    /* Column Info */
    private String repCustSeq = null;

    /* Column Info */
    private String invPfxCd = null;

    /* Column Info */
    private String apOfcCd = null;

    /* Column Info */
    private String apCtrlOfcCd = null;

    /* Column Info */
    private String apCtrCd = null;

    /* Column Info */
    private String fxCurrRt = null;

    /* Column Info */
    private String asaCrTermDys = null;

    /* Column Info */
    private String soIfCd = null;

    /* Column Info */
    private String slsOfcDivCd = null;

    /* Column Info */
    private String faxIp = null;

    /* Column Info */
    private String modiOfcCd = null;

    /* Column Info */
    private String ofcCmmcCd = null;

    /* Column Info */
    private String ofcTpCd = null;

    /* Column Info */
    private String ofcUrl = null;

    /* Column Info */
    private String ofcRepEml = null;

    /* Column Info */
    private String ofcSlsDeltFlg = null;

    /* Column Info */
    private String subsCoFlg = null;

    /* Column Info */
    private String glCtrCd = null;

    /* Column Info */
    private String ofcLoclLangAddr = null;

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
    private String ppdPtyTpCd = null;

    /* Column Info */
    private String modiCltOfcCd = null;

    /* Column Info */
    private String modiCtrlOfcCd = null;

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
	
	/* Column Info */
	private String opediInsfId = null;
	
	/* Column Info */
	private String opediInsfDvCd = null;
	
    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public OfficeIfVO() {
    }

    public OfficeIfVO(String ibflag, String pagerows, String ofcIfSeq, String ofcCd, String ofcEngNm, String ofcLoclNm, String ofcAddr, String ofcZipCd, String ofcKndCd, String agnKndCd, String vndrCntCd, String vndrSeq, String intlPhnNo, String ofcPhnNo, String intlFaxNo, String ofcFaxNo, String ofcRmk, String locCd, String bilCurrCd, String arCurrCd, String arCtrCd, String prntOfcCd, String opnDt, String clzDt, String fincRgnCd, String arOfcCd, String arHdQtrOfcCd, String ibCrTermDys, String obCrTermDys, String repCustCntCd, String repCustSeq, String invPfxCd, String apOfcCd, String apCtrlOfcCd, String apCtrCd, String fxCurrRt, String asaCrTermDys, String soIfCd, String slsOfcDivCd, String faxIp, String modiOfcCd, String ofcCmmcCd, String ofcTpCd, String ofcUrl, String ofcRepEml, String ofcSlsDeltFlg, String subsCoFlg, String glCtrCd, String ofcLoclLangAddr, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String ppdPtyTpCd, String modiCltOfcCd, String modiCtrlOfcCd, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String opediInsfId, String opediInsfDvCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ofcIfSeq = ofcIfSeq;
        this.ofcCd = ofcCd;
        this.ofcEngNm = ofcEngNm;
        this.ofcLoclNm = ofcLoclNm;
        this.ofcAddr = ofcAddr;
        this.ofcZipCd = ofcZipCd;
        this.ofcKndCd = ofcKndCd;
        this.agnKndCd = agnKndCd;
        this.vndrCntCd = vndrCntCd;
        this.vndrSeq = vndrSeq;
        this.intlPhnNo = intlPhnNo;
        this.ofcPhnNo = ofcPhnNo;
        this.intlFaxNo = intlFaxNo;
        this.ofcFaxNo = ofcFaxNo;
        this.ofcRmk = ofcRmk;
        this.locCd = locCd;
        this.bilCurrCd = bilCurrCd;
        this.arCurrCd = arCurrCd;
        this.arCtrCd = arCtrCd;
        this.prntOfcCd = prntOfcCd;
        this.opnDt = opnDt;
        this.clzDt = clzDt;
        this.fincRgnCd = fincRgnCd;
        this.arOfcCd = arOfcCd;
        this.arHdQtrOfcCd = arHdQtrOfcCd;
        this.ibCrTermDys = ibCrTermDys;
        this.obCrTermDys = obCrTermDys;
        this.repCustCntCd = repCustCntCd;
        this.repCustSeq = repCustSeq;
        this.invPfxCd = invPfxCd;
        this.apOfcCd = apOfcCd;
        this.apCtrlOfcCd = apCtrlOfcCd;
        this.apCtrCd = apCtrCd;
        this.fxCurrRt = fxCurrRt;
        this.asaCrTermDys = asaCrTermDys;
        this.soIfCd = soIfCd;
        this.slsOfcDivCd = slsOfcDivCd;
        this.faxIp = faxIp;
        this.modiOfcCd = modiOfcCd;
        this.ofcCmmcCd = ofcCmmcCd;
        this.ofcTpCd = ofcTpCd;
        this.ofcUrl = ofcUrl;
        this.ofcRepEml = ofcRepEml;
        this.ofcSlsDeltFlg = ofcSlsDeltFlg;
        this.subsCoFlg = subsCoFlg;
        this.glCtrCd = glCtrCd;
        this.ofcLoclLangAddr = ofcLoclLangAddr;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.ppdPtyTpCd = ppdPtyTpCd;
        this.modiCltOfcCd = modiCltOfcCd;
        this.modiCtrlOfcCd = modiCtrlOfcCd;
        this.ecomInsfId = ecomInsfId;
        this.ecomInsfPrsId = ecomInsfPrsId;
        this.ecomInsfDttm = ecomInsfDttm;
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
        this.ecomInsfDvCd = ecomInsfDvCd;
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
        
        this.opediInsfId = opediInsfId;
        this.opediInsfDvCd = opediInsfDvCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_if_seq", getOfcIfSeq());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
        this.hashColumns.put("ofc_locl_nm", getOfcLoclNm());
        this.hashColumns.put("ofc_addr", getOfcAddr());
        this.hashColumns.put("ofc_zip_cd", getOfcZipCd());
        this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
        this.hashColumns.put("agn_knd_cd", getAgnKndCd());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
        this.hashColumns.put("intl_fax_no", getIntlFaxNo());
        this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
        this.hashColumns.put("ofc_rmk", getOfcRmk());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("bil_curr_cd", getBilCurrCd());
        this.hashColumns.put("ar_curr_cd", getArCurrCd());
        this.hashColumns.put("ar_ctr_cd", getArCtrCd());
        this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
        this.hashColumns.put("opn_dt", getOpnDt());
        this.hashColumns.put("clz_dt", getClzDt());
        this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
        this.hashColumns.put("ar_ofc_cd", getArOfcCd());
        this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
        this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
        this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
        this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
        this.hashColumns.put("rep_cust_seq", getRepCustSeq());
        this.hashColumns.put("inv_pfx_cd", getInvPfxCd());
        this.hashColumns.put("ap_ofc_cd", getApOfcCd());
        this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
        this.hashColumns.put("ap_ctr_cd", getApCtrCd());
        this.hashColumns.put("fx_curr_rt", getFxCurrRt());
        this.hashColumns.put("asa_cr_term_dys", getAsaCrTermDys());
        this.hashColumns.put("so_if_cd", getSoIfCd());
        this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
        this.hashColumns.put("fax_ip", getFaxIp());
        this.hashColumns.put("modi_ofc_cd", getModiOfcCd());
        this.hashColumns.put("ofc_cmmc_cd", getOfcCmmcCd());
        this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
        this.hashColumns.put("ofc_url", getOfcUrl());
        this.hashColumns.put("ofc_rep_eml", getOfcRepEml());
        this.hashColumns.put("ofc_sls_delt_flg", getOfcSlsDeltFlg());
        this.hashColumns.put("subs_co_flg", getSubsCoFlg());
        this.hashColumns.put("gl_ctr_cd", getGlCtrCd());
        this.hashColumns.put("ofc_locl_lang_addr", getOfcLoclLangAddr());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("ppd_pty_tp_cd", getPpdPtyTpCd());
        this.hashColumns.put("modi_clt_ofc_cd", getModiCltOfcCd());
        this.hashColumns.put("modi_ctrl_ofc_cd", getModiCtrlOfcCd());
        this.hashColumns.put("ecom_insf_id", getEcomInsfId());
        this.hashColumns.put("ecom_insf_prs_id", getEcomInsfPrsId());
        this.hashColumns.put("ecom_insf_dttm", getEcomInsfDttm());
        this.hashColumns.put("ecom_insf_cnqe_val", getEcomInsfCnqeVal());
        this.hashColumns.put("ecom_insf_dv_cd", getEcomInsfDvCd());
        this.hashColumns.put("ecom_insf_cnqe_cont", getEcomInsfCnqeCont());

		this.hashColumns.put("opedi_insf_id", getOpediInsfId());
		this.hashColumns.put("opedi_insf_dv_cd", getOpediInsfDvCd());
		
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_if_seq", "ofcIfSeq");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ofc_eng_nm", "ofcEngNm");
        this.hashFields.put("ofc_locl_nm", "ofcLoclNm");
        this.hashFields.put("ofc_addr", "ofcAddr");
        this.hashFields.put("ofc_zip_cd", "ofcZipCd");
        this.hashFields.put("ofc_knd_cd", "ofcKndCd");
        this.hashFields.put("agn_knd_cd", "agnKndCd");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("ofc_phn_no", "ofcPhnNo");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("ofc_fax_no", "ofcFaxNo");
        this.hashFields.put("ofc_rmk", "ofcRmk");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("bil_curr_cd", "bilCurrCd");
        this.hashFields.put("ar_curr_cd", "arCurrCd");
        this.hashFields.put("ar_ctr_cd", "arCtrCd");
        this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
        this.hashFields.put("opn_dt", "opnDt");
        this.hashFields.put("clz_dt", "clzDt");
        this.hashFields.put("finc_rgn_cd", "fincRgnCd");
        this.hashFields.put("ar_ofc_cd", "arOfcCd");
        this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
        this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
        this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
        this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
        this.hashFields.put("rep_cust_seq", "repCustSeq");
        this.hashFields.put("inv_pfx_cd", "invPfxCd");
        this.hashFields.put("ap_ofc_cd", "apOfcCd");
        this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
        this.hashFields.put("ap_ctr_cd", "apCtrCd");
        this.hashFields.put("fx_curr_rt", "fxCurrRt");
        this.hashFields.put("asa_cr_term_dys", "asaCrTermDys");
        this.hashFields.put("so_if_cd", "soIfCd");
        this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
        this.hashFields.put("fax_ip", "faxIp");
        this.hashFields.put("modi_ofc_cd", "modiOfcCd");
        this.hashFields.put("ofc_cmmc_cd", "ofcCmmcCd");
        this.hashFields.put("ofc_tp_cd", "ofcTpCd");
        this.hashFields.put("ofc_url", "ofcUrl");
        this.hashFields.put("ofc_rep_eml", "ofcRepEml");
        this.hashFields.put("ofc_sls_delt_flg", "ofcSlsDeltFlg");
        this.hashFields.put("subs_co_flg", "subsCoFlg");
        this.hashFields.put("gl_ctr_cd", "glCtrCd");
        this.hashFields.put("ofc_locl_lang_addr", "ofcLoclLangAddr");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("ppd_pty_tp_cd", "ppdPtyTpCd");
        this.hashFields.put("modi_clt_ofc_cd", "modiCltOfcCd");
        this.hashFields.put("modi_ctrl_ofc_cd", "modiCtrlOfcCd");
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

		this.hashFields.put("opedi_insf_id", "opediInsfId");
		this.hashFields.put("opedi_insf_dv_cd", "opediInsfDvCd");
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
	 * @param String ofcIfSeq
	 */
    public void setOfcIfSeq(String ofcIfSeq) {
        this.ofcIfSeq = ofcIfSeq;
    }

    /**
	 * 
	 * @return String ofcIfSeq
	 */
    public String getOfcIfSeq() {
        return this.ofcIfSeq;
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
	 * @param String ofcLoclNm
	 */
    public void setOfcLoclNm(String ofcLoclNm) {
        this.ofcLoclNm = ofcLoclNm;
    }

    /**
	 * 
	 * @return String ofcLoclNm
	 */
    public String getOfcLoclNm() {
        return this.ofcLoclNm;
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
	 * @param String subsCoFlg
	 */
    public void setSubsCoFlg(String subsCoFlg) {
        this.subsCoFlg = subsCoFlg;
    }

    /**
	 * 
	 * @return String subsCoFlg
	 */
    public String getSubsCoFlg() {
        return this.subsCoFlg;
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

    /**
	 *
	 * @param String ppdPtyTpCd
	 */
    public void setPpdPtyTpCd(String ppdPtyTpCd) {
        this.ppdPtyTpCd = ppdPtyTpCd;
    }

    /**
	 * 
	 * @return String ppdPtyTpCd
	 */
    public String getPpdPtyTpCd() {
        return this.ppdPtyTpCd;
    }

    /**
	 *
	 * @param String modiCltOfcCd
	 */
    public void setModiCltOfcCd(String modiCltOfcCd) {
        this.modiCltOfcCd = modiCltOfcCd;
    }

    /**
	 * 
	 * @return String modiCltOfcCd
	 */
    public String getModiCltOfcCd() {
        return this.modiCltOfcCd;
    }

    /**
	 *
	 * @param String modiCtrlOfcCd
	 */
    public void setModiCtrlOfcCd(String modiCtrlOfcCd) {
        this.modiCtrlOfcCd = modiCtrlOfcCd;
    }

    /**
	 * 
	 * @return String modiCtrlOfcCd
	 */
    public String getModiCtrlOfcCd() {
        return this.modiCtrlOfcCd;
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

	public String getOpediInsfId() {
		return opediInsfId;
	}

	public void setOpediInsfId(String opediInsfId) {
		this.opediInsfId = opediInsfId;
	}

	public String getOpediInsfDvCd() {
		return opediInsfDvCd;
	}

	public void setOpediInsfDvCd(String opediInsfDvCd) {
		this.opediInsfDvCd = opediInsfDvCd;
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
        setOfcIfSeq(JSPUtil.getParameter(request, prefix + "ofc_if_seq", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
        setOfcLoclNm(JSPUtil.getParameter(request, prefix + "ofc_locl_nm", ""));
        setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
        setOfcZipCd(JSPUtil.getParameter(request, prefix + "ofc_zip_cd", ""));
        setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
        setAgnKndCd(JSPUtil.getParameter(request, prefix + "agn_knd_cd", ""));
        setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
        setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
        setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
        setOfcRmk(JSPUtil.getParameter(request, prefix + "ofc_rmk", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
        setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
        setArCtrCd(JSPUtil.getParameter(request, prefix + "ar_ctr_cd", ""));
        setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
        setOpnDt(JSPUtil.getParameter(request, prefix + "opn_dt", ""));
        setClzDt(JSPUtil.getParameter(request, prefix + "clz_dt", ""));
        setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
        setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
        setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
        setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
        setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
        setRepCustCntCd(JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", ""));
        setRepCustSeq(JSPUtil.getParameter(request, prefix + "rep_cust_seq", ""));
        setInvPfxCd(JSPUtil.getParameter(request, prefix + "inv_pfx_cd", ""));
        setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
        setApCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", ""));
        setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
        setFxCurrRt(JSPUtil.getParameter(request, prefix + "fx_curr_rt", ""));
        setAsaCrTermDys(JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", ""));
        setSoIfCd(JSPUtil.getParameter(request, prefix + "so_if_cd", ""));
        setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
        setFaxIp(JSPUtil.getParameter(request, prefix + "fax_ip", ""));
        setModiOfcCd(JSPUtil.getParameter(request, prefix + "modi_ofc_cd", ""));
        setOfcCmmcCd(JSPUtil.getParameter(request, prefix + "ofc_cmmc_cd", ""));
        setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
        setOfcUrl(JSPUtil.getParameter(request, prefix + "ofc_url", ""));
        setOfcRepEml(JSPUtil.getParameter(request, prefix + "ofc_rep_eml", ""));
        setOfcSlsDeltFlg(JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", ""));
        setSubsCoFlg(JSPUtil.getParameter(request, prefix + "subs_co_flg", ""));
        setGlCtrCd(JSPUtil.getParameter(request, prefix + "gl_ctr_cd", ""));
        setOfcLoclLangAddr(JSPUtil.getParameter(request, prefix + "ofc_locl_lang_addr", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setPpdPtyTpCd(JSPUtil.getParameter(request, prefix + "ppd_pty_tp_cd", ""));
        setModiCltOfcCd(JSPUtil.getParameter(request, prefix + "modi_clt_ofc_cd", ""));
        setModiCtrlOfcCd(JSPUtil.getParameter(request, prefix + "modi_ctrl_ofc_cd", ""));
        setEcomInsfId(JSPUtil.getParameter(request, prefix + "ecom_insf_id", ""));
        setEcomInsfPrsId(JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", ""));
        setEcomInsfDttm(JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", ""));
        setEcomInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", ""));
        setEcomInsfDvCd(JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", ""));
        setEcomInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", ""));

		setOpediInsfId(JSPUtil.getParameter(request, prefix + "opedi_insf_id", ""));
		setOpediInsfDvCd(JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeIfVO[]
	 */
    public OfficeIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeIfVO[]
	 */
    public OfficeIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OfficeIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcIfSeq = (JSPUtil.getParameter(request, prefix + "ofc_if_seq", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ofcEngNm = (JSPUtil.getParameter(request, prefix + "ofc_eng_nm", length));
            String[] ofcLoclNm = (JSPUtil.getParameter(request, prefix + "ofc_locl_nm", length));
            String[] ofcAddr = (JSPUtil.getParameter(request, prefix + "ofc_addr", length));
            String[] ofcZipCd = (JSPUtil.getParameter(request, prefix + "ofc_zip_cd", length));
            String[] ofcKndCd = (JSPUtil.getParameter(request, prefix + "ofc_knd_cd", length));
            String[] agnKndCd = (JSPUtil.getParameter(request, prefix + "agn_knd_cd", length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix + "ofc_phn_no", length));
            String[] intlFaxNo = (JSPUtil.getParameter(request, prefix + "intl_fax_no", length));
            String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix + "ofc_fax_no", length));
            String[] ofcRmk = (JSPUtil.getParameter(request, prefix + "ofc_rmk", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] bilCurrCd = (JSPUtil.getParameter(request, prefix + "bil_curr_cd", length));
            String[] arCurrCd = (JSPUtil.getParameter(request, prefix + "ar_curr_cd", length));
            String[] arCtrCd = (JSPUtil.getParameter(request, prefix + "ar_ctr_cd", length));
            String[] prntOfcCd = (JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", length));
            String[] opnDt = (JSPUtil.getParameter(request, prefix + "opn_dt", length));
            String[] clzDt = (JSPUtil.getParameter(request, prefix + "clz_dt", length));
            String[] fincRgnCd = (JSPUtil.getParameter(request, prefix + "finc_rgn_cd", length));
            String[] arOfcCd = (JSPUtil.getParameter(request, prefix + "ar_ofc_cd", length));
            String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", length));
            String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", length));
            String[] obCrTermDys = (JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", length));
            String[] repCustCntCd = (JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", length));
            String[] repCustSeq = (JSPUtil.getParameter(request, prefix + "rep_cust_seq", length));
            String[] invPfxCd = (JSPUtil.getParameter(request, prefix + "inv_pfx_cd", length));
            String[] apOfcCd = (JSPUtil.getParameter(request, prefix + "ap_ofc_cd", length));
            String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", length));
            String[] apCtrCd = (JSPUtil.getParameter(request, prefix + "ap_ctr_cd", length));
            String[] fxCurrRt = (JSPUtil.getParameter(request, prefix + "fx_curr_rt", length));
            String[] asaCrTermDys = (JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", length));
            String[] soIfCd = (JSPUtil.getParameter(request, prefix + "so_if_cd", length));
            String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", length));
            String[] faxIp = (JSPUtil.getParameter(request, prefix + "fax_ip", length));
            String[] modiOfcCd = (JSPUtil.getParameter(request, prefix + "modi_ofc_cd", length));
            String[] ofcCmmcCd = (JSPUtil.getParameter(request, prefix + "ofc_cmmc_cd", length));
            String[] ofcTpCd = (JSPUtil.getParameter(request, prefix + "ofc_tp_cd", length));
            String[] ofcUrl = (JSPUtil.getParameter(request, prefix + "ofc_url", length));
            String[] ofcRepEml = (JSPUtil.getParameter(request, prefix + "ofc_rep_eml", length));
            String[] ofcSlsDeltFlg = (JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", length));
            String[] subsCoFlg = (JSPUtil.getParameter(request, prefix + "subs_co_flg", length));
            String[] glCtrCd = (JSPUtil.getParameter(request, prefix + "gl_ctr_cd", length));
            String[] ofcLoclLangAddr = (JSPUtil.getParameter(request, prefix + "ofc_locl_lang_addr", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] ppdPtyTpCd = (JSPUtil.getParameter(request, prefix + "ppd_pty_tp_cd", length));
            String[] modiCltOfcCd = (JSPUtil.getParameter(request, prefix + "modi_clt_ofc_cd", length));
            String[] modiCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "modi_ctrl_ofc_cd", length));
            String[] ecomInsfId = (JSPUtil.getParameter(request, prefix + "ecom_insf_id", length));
	    	String[] ecomInsfPrsId = (JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", length));
	    	String[] ecomInsfDttm = (JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", length));
	    	String[] ecomInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", length));
	    	String[] ecomInsfDvCd = (JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", length));
	    	String[] ecomInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", length));

			String[] opediInsfId = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_id", length));
			String[] opediInsfDvCd = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_dv_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OfficeIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcIfSeq[i] != null)
                    model.setOfcIfSeq(ofcIfSeq[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ofcEngNm[i] != null)
                    model.setOfcEngNm(ofcEngNm[i]);
                if (ofcLoclNm[i] != null)
                    model.setOfcLoclNm(ofcLoclNm[i]);
                if (ofcAddr[i] != null)
                    model.setOfcAddr(ofcAddr[i]);
                if (ofcZipCd[i] != null)
                    model.setOfcZipCd(ofcZipCd[i]);
                if (ofcKndCd[i] != null)
                    model.setOfcKndCd(ofcKndCd[i]);
                if (agnKndCd[i] != null)
                    model.setAgnKndCd(agnKndCd[i]);
                if (vndrCntCd[i] != null)
                    model.setVndrCntCd(vndrCntCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (ofcPhnNo[i] != null)
                    model.setOfcPhnNo(ofcPhnNo[i]);
                if (intlFaxNo[i] != null)
                    model.setIntlFaxNo(intlFaxNo[i]);
                if (ofcFaxNo[i] != null)
                    model.setOfcFaxNo(ofcFaxNo[i]);
                if (ofcRmk[i] != null)
                    model.setOfcRmk(ofcRmk[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (bilCurrCd[i] != null)
                    model.setBilCurrCd(bilCurrCd[i]);
                if (arCurrCd[i] != null)
                    model.setArCurrCd(arCurrCd[i]);
                if (arCtrCd[i] != null)
                    model.setArCtrCd(arCtrCd[i]);
                if (prntOfcCd[i] != null)
                    model.setPrntOfcCd(prntOfcCd[i]);
                if (opnDt[i] != null)
                    model.setOpnDt(opnDt[i]);
                if (clzDt[i] != null)
                    model.setClzDt(clzDt[i]);
                if (fincRgnCd[i] != null)
                    model.setFincRgnCd(fincRgnCd[i]);
                if (arOfcCd[i] != null)
                    model.setArOfcCd(arOfcCd[i]);
                if (arHdQtrOfcCd[i] != null)
                    model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
                if (ibCrTermDys[i] != null)
                    model.setIbCrTermDys(ibCrTermDys[i]);
                if (obCrTermDys[i] != null)
                    model.setObCrTermDys(obCrTermDys[i]);
                if (repCustCntCd[i] != null)
                    model.setRepCustCntCd(repCustCntCd[i]);
                if (repCustSeq[i] != null)
                    model.setRepCustSeq(repCustSeq[i]);
                if (invPfxCd[i] != null)
                    model.setInvPfxCd(invPfxCd[i]);
                if (apOfcCd[i] != null)
                    model.setApOfcCd(apOfcCd[i]);
                if (apCtrlOfcCd[i] != null)
                    model.setApCtrlOfcCd(apCtrlOfcCd[i]);
                if (apCtrCd[i] != null)
                    model.setApCtrCd(apCtrCd[i]);
                if (fxCurrRt[i] != null)
                    model.setFxCurrRt(fxCurrRt[i]);
                if (asaCrTermDys[i] != null)
                    model.setAsaCrTermDys(asaCrTermDys[i]);
                if (soIfCd[i] != null)
                    model.setSoIfCd(soIfCd[i]);
                if (slsOfcDivCd[i] != null)
                    model.setSlsOfcDivCd(slsOfcDivCd[i]);
                if (faxIp[i] != null)
                    model.setFaxIp(faxIp[i]);
                if (modiOfcCd[i] != null)
                    model.setModiOfcCd(modiOfcCd[i]);
                if (ofcCmmcCd[i] != null)
                    model.setOfcCmmcCd(ofcCmmcCd[i]);
                if (ofcTpCd[i] != null)
                    model.setOfcTpCd(ofcTpCd[i]);
                if (ofcUrl[i] != null)
                    model.setOfcUrl(ofcUrl[i]);
                if (ofcRepEml[i] != null)
                    model.setOfcRepEml(ofcRepEml[i]);
                if (ofcSlsDeltFlg[i] != null)
                    model.setOfcSlsDeltFlg(ofcSlsDeltFlg[i]);
                if (subsCoFlg[i] != null)
                    model.setSubsCoFlg(subsCoFlg[i]);
                if (glCtrCd[i] != null)
                    model.setGlCtrCd(glCtrCd[i]);
                if (ofcLoclLangAddr[i] != null)
                    model.setOfcLoclLangAddr(ofcLoclLangAddr[i]);
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
                if (ppdPtyTpCd[i] != null)
                    model.setPpdPtyTpCd(ppdPtyTpCd[i]);
                if (modiCltOfcCd[i] != null)
                    model.setModiCltOfcCd(modiCltOfcCd[i]);
                if (modiCtrlOfcCd[i] != null)
                    model.setModiCtrlOfcCd(modiCtrlOfcCd[i]);
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
				
				if (opediInsfId[i] != null)
					model.setOpediInsfId(opediInsfId[i]);
				if (opediInsfDvCd[i] != null)
					model.setOpediInsfDvCd(opediInsfDvCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOfficeIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OfficeIfVO[]
	 */
    public OfficeIfVO[] getOfficeIfVOs() {
        OfficeIfVO[] vos = (OfficeIfVO[]) models.toArray(new OfficeIfVO[models.size()]);
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
        this.ofcIfSeq = this.ofcIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcEngNm = this.ofcEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcLoclNm = this.ofcLoclNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcAddr = this.ofcAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcZipCd = this.ofcZipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcKndCd = this.ofcKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agnKndCd = this.agnKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcPhnNo = this.ofcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlFaxNo = this.intlFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcFaxNo = this.ofcFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcRmk = this.ofcRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilCurrCd = this.bilCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arCurrCd = this.arCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arCtrCd = this.arCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntOfcCd = this.prntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opnDt = this.opnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clzDt = this.clzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincRgnCd = this.fincRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arOfcCd = this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arHdQtrOfcCd = this.arHdQtrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCrTermDys = this.ibCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCrTermDys = this.obCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCustCntCd = this.repCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCustSeq = this.repCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPfxCd = this.invPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apOfcCd = this.apOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apCtrlOfcCd = this.apCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apCtrCd = this.apCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fxCurrRt = this.fxCurrRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.asaCrTermDys = this.asaCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soIfCd = this.soIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcDivCd = this.slsOfcDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxIp = this.faxIp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiOfcCd = this.modiOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCmmcCd = this.ofcCmmcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcTpCd = this.ofcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcUrl = this.ofcUrl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcRepEml = this.ofcRepEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcSlsDeltFlg = this.ofcSlsDeltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subsCoFlg = this.subsCoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.glCtrCd = this.glCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcLoclLangAddr = this.ofcLoclLangAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ppdPtyTpCd = this.ppdPtyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCltOfcCd = this.modiCltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCtrlOfcCd = this.modiCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfId = this.ecomInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfPrsId = this.ecomInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDttm = this.ecomInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeVal = this.ecomInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDvCd = this.ecomInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeCont = this.ecomInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.opediInsfId = this.opediInsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opediInsfDvCd = this.opediInsfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
