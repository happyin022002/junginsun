/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VendorIfVO.java
*@FileTitle : VendorIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.vo;

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
public class VendorIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VendorIfVO> models = new ArrayList<VendorIfVO>();
    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;
    /* Page Number */
    private String pagerows = null;
    private String vndrIfSeq = null;
    private String vndrSeq = null;
    private String vndrCntCd = null;
    private String vndrLglEngNm = null;
    private String vndrLoclLangNm = null;
    private String vndrAbbrNm = null;
    private String lgsFlg = "N";
    private String procuFlg = "N";
    private String teamFlg = "N";
    private String fincFlg = "N";
    private String blkFlg = null;
    private String interCoFlg = "N";
    private String railVndrFlg = null;
    private String locCd = null;
    private String ofcCd = null;
    private String ceoNm = null;
    private String rgstNo = null;
    private String taxId = null;
    private String prntCntCd = null;
    private String prntVndrSeq = null;
    private String dcgoHndlFlg = null;
    private String svcScpCdNm = null;
    private String svcPrdTpNm = null;
    private String svcPrdRmk = null;
    private String bzctNm = null;
    private String bztpNm = null;
    private String genPayTermCd = null;
    private String engAddr = null;
    private String loclLangAddr = null;
    private String zipCd = null;
    private String cntcPsonNm = null;
    private String invCurrCd = null;
    private String payCurrCd = null;
    private String payMzdCd = null;
    private String usaEdiCd = null;
    private String woAtchFileFlg = null;
    private String woEdiUseFlg = null;
    private String invEdiUseFlg = null;
    private String mtyRroEdiUseFlg = null;
    private String blkVndrSvcCd = null;
    private String subsCoCd = null;
    private String otrFlg = "N";
    private String vndrOfcCd = null;
    private String rfndPsdoCustCd = null;
    private String payTermTpCd = null;
    private String modiVndrCd = null;
    private String creUsrId = null;
    private String creDt = null;
    private String updUsrId = null;
    private String updDt = null;
    private String deltFlg = null;
    private String r3InsfId = null;
    private String r3InsfPrsId = null;
    private String r3InsfDttm = null;
    private String r3InsfCnqeVal = null;
    private String r3InsfDvCd = null;
    private String r3InsfCnqeCont = null;
    private String ocediInsfId = null;
    private String ocediInsfPrsId = null;
    private String ocediInsfDttm = null;
    private String ocediInsfCnqeVal = null;
    private String ocediInsfDvCd = null;
    private String ocediInsfCnqeCont = null;
	private String phnNo = null;
	private String chkDeCntCd = null;
	private String cntcPntDeltFlg = null;
	private String vndrEml = null;
	private String chkDeZipCd = null;
	private String cntcDivCd = null;
	private String prmryChkFlg = null;
	private String chkDeSteCd = null;
	private String faxNo = null;
	private String intlFaxNo = null;
	private String intlPhnNo = null;
	private String opediInsfId = null;
    private String opediInsfDvCd = null;
	private String chkDeAddr2 = null;
	private String chkDeAddr3 = null;
	private String chkDeAddr1 = null;
	private String chkDeCtyNm = null;
	private String sapId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VendorIfVO() {
    }

    public VendorIfVO(String ibflag, String pagerows, String vndrIfSeq, String vndrSeq, String vndrCntCd, String vndrLglEngNm, String vndrLoclLangNm, String vndrAbbrNm, String lgsFlg, String procuFlg, String teamFlg, String fincFlg, String blkFlg, String interCoFlg, String railVndrFlg, String locCd, String ofcCd, String ceoNm, String rgstNo, String taxId, String prntCntCd, String prntVndrSeq, String dcgoHndlFlg, String svcScpCdNm, String svcPrdTpNm, String svcPrdRmk, String bzctNm, String bztpNm, String genPayTermCd, String engAddr, String loclLangAddr, String zipCd, String cntcPsonNm, String invCurrCd, String payCurrCd, String payMzdCd, String usaEdiCd, String woAtchFileFlg, String woEdiUseFlg, String invEdiUseFlg, String mtyRroEdiUseFlg, String blkVndrSvcCd, String subsCoCd, String otrFlg, String vndrOfcCd, String rfndPsdoCustCd, String payTermTpCd, String modiVndrCd, String vndrCntcPntSeq, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String vndrEml, String prmryChkFlg, String cntcPntDeltFlg, String cntcDivCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String r3InsfId, String r3InsfPrsId, String r3InsfDttm, String r3InsfCnqeVal, String r3InsfDvCd, String r3InsfCnqeCont, String ocediInsfId, String ocediInsfPrsId, String ocediInsfDttm, String ocediInsfCnqeVal, String ocediInsfDvCd, String ocediInsfCnqeCont, String chkDeSteCd, String chkDeZipCd, String chkDeCntCd, String opediInsfId, String opediInsfDvCd, String chkDeAddr1, String chkDeAddr2, String chkDeAddr3, String chkDeCtyNm, String sapId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vndrIfSeq = vndrIfSeq;
        this.vndrSeq = vndrSeq;
        this.vndrCntCd = vndrCntCd;
        this.vndrLglEngNm = vndrLglEngNm;
        this.vndrLoclLangNm = vndrLoclLangNm;
        this.vndrAbbrNm = vndrAbbrNm;
        this.lgsFlg = lgsFlg;
        this.procuFlg = procuFlg;
        this.teamFlg = teamFlg;
        this.fincFlg = fincFlg;
        this.blkFlg = blkFlg;
        this.interCoFlg = interCoFlg;
        this.railVndrFlg = railVndrFlg;
        this.locCd = locCd;
        this.ofcCd = ofcCd;
        this.ceoNm = ceoNm;
        this.rgstNo = rgstNo;
        this.taxId = taxId;
        this.prntCntCd = prntCntCd;
        this.prntVndrSeq = prntVndrSeq;
        this.dcgoHndlFlg = dcgoHndlFlg;
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
        this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
        this.blkVndrSvcCd = blkVndrSvcCd;
        this.subsCoCd = subsCoCd;
        this.otrFlg = otrFlg;
        this.vndrOfcCd = vndrOfcCd;
        this.rfndPsdoCustCd = rfndPsdoCustCd;
        this.payTermTpCd = payTermTpCd;
        this.modiVndrCd = modiVndrCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.r3InsfId = r3InsfId;
        this.r3InsfPrsId = r3InsfPrsId;
        this.r3InsfDttm = r3InsfDttm;
        this.r3InsfCnqeVal = r3InsfCnqeVal;
        this.r3InsfDvCd = r3InsfDvCd;
        this.r3InsfCnqeCont = r3InsfCnqeCont;
        this.ocediInsfId = ocediInsfId;
        this.ocediInsfPrsId = ocediInsfPrsId;
        this.ocediInsfDttm = ocediInsfDttm;
        this.ocediInsfCnqeVal = ocediInsfCnqeVal;
        this.ocediInsfDvCd = ocediInsfDvCd;
        this.ocediInsfCnqeCont = ocediInsfCnqeCont;
        this.phnNo = phnNo;
		this.chkDeCntCd = chkDeCntCd;
		this.cntcPntDeltFlg = cntcPntDeltFlg;
		this.vndrEml = vndrEml;
		this.chkDeZipCd = chkDeZipCd;
		this.cntcDivCd = cntcDivCd;
		this.prmryChkFlg = prmryChkFlg;
		this.chkDeSteCd = chkDeSteCd;
		this.faxNo = faxNo;
		this.intlFaxNo = intlFaxNo;
		this.intlPhnNo = intlPhnNo;
        
        this.opediInsfId = opediInsfId;
        this.opediInsfDvCd = opediInsfDvCd;
        this.chkDeAddr1 = chkDeAddr1;
        this.chkDeAddr2 = chkDeAddr2;
        this.chkDeAddr3 = chkDeAddr3;
        this.chkDeCtyNm= chkDeCtyNm; 
        this.sapId = sapId;
    }

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_if_seq", getVndrIfSeq());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("vndr_locl_lang_nm", getVndrLoclLangNm());
        this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
        this.hashColumns.put("lgs_flg", getLgsFlg());
        this.hashColumns.put("procu_flg", getProcuFlg());
        this.hashColumns.put("team_flg", getTeamFlg());
        this.hashColumns.put("finc_flg", getFincFlg());
        this.hashColumns.put("blk_flg", getBlkFlg());
        this.hashColumns.put("inter_co_flg", getInterCoFlg());
        this.hashColumns.put("rail_vndr_flg", getRailVndrFlg());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ceo_nm", getCeoNm());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("tax_id", getTaxId());
        this.hashColumns.put("prnt_cnt_cd", getPrntCntCd());
        this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
        this.hashColumns.put("dcgo_hndl_flg", getDcgoHndlFlg());
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
        this.hashColumns.put("mty_rro_edi_use_flg", getMtyRroEdiUseFlg());
        this.hashColumns.put("blk_vndr_svc_cd", getBlkVndrSvcCd());
        this.hashColumns.put("subs_co_cd", getSubsCoCd());
        this.hashColumns.put("otr_flg", getOtrFlg());
        this.hashColumns.put("vndr_ofc_cd", getVndrOfcCd());
        this.hashColumns.put("rfnd_psdo_cust_cd", getRfndPsdoCustCd());
        this.hashColumns.put("pay_term_tp_cd", getPayTermTpCd());
        this.hashColumns.put("modi_vndr_cd", getModiVndrCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("r3_insf_id", getR3InsfId());
        this.hashColumns.put("r3_insf_prs_id", getR3InsfPrsId());
        this.hashColumns.put("r3_insf_dttm", getR3InsfDttm());
        this.hashColumns.put("r3_insf_cnqe_val", getR3InsfCnqeVal());
        this.hashColumns.put("r3_insf_dv_cd", getR3InsfDvCd());
        this.hashColumns.put("r3_insf_cnqe_cont", getR3InsfCnqeCont());
        this.hashColumns.put("ocedi_insf_id", getOcediInsfId());
        this.hashColumns.put("ocedi_insf_prs_id", getOcediInsfPrsId());
        this.hashColumns.put("ocedi_insf_dttm", getOcediInsfDttm());
        this.hashColumns.put("ocedi_insf_cnqe_val", getOcediInsfCnqeVal());
        this.hashColumns.put("ocedi_insf_dv_cd", getOcediInsfDvCd());
        this.hashColumns.put("ocedi_insf_cnqe_cont", getOcediInsfCnqeCont());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("chk_de_cnt_cd", getChkDeCntCd());
		this.hashColumns.put("cntc_pnt_delt_flg", getCntcPntDeltFlg());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("chk_de_zip_cd", getChkDeZipCd());
		this.hashColumns.put("cntc_div_cd", getCntcDivCd());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("chk_de_ste_cd", getChkDeSteCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());

		this.hashColumns.put("opedi_insf_id", getOpediInsfId());
        this.hashColumns.put("opedi_insf_dv_cd", getOpediInsfDvCd());
		this.hashColumns.put("chk_de_addr2", getChkDeAddr2());
		this.hashColumns.put("chk_de_addr3", getChkDeAddr3());
		this.hashColumns.put("chk_de_addr1", getChkDeAddr1());
		this.hashColumns.put("chk_de_cty_nm", getChkDeCtyNm());
		this.hashColumns.put("sap_id", getSapId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_if_seq", "vndrIfSeq");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("vndr_locl_lang_nm", "vndrLoclLangNm");
        this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
        this.hashFields.put("lgs_flg", "lgsFlg");
        this.hashFields.put("procu_flg", "procuFlg");
        this.hashFields.put("team_flg", "teamFlg");
        this.hashFields.put("finc_flg", "fincFlg");
        this.hashFields.put("blk_flg", "blkFlg");
        this.hashFields.put("inter_co_flg", "interCoFlg");
        this.hashFields.put("rail_vndr_flg", "railVndrFlg");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ceo_nm", "ceoNm");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("tax_id", "taxId");
        this.hashFields.put("prnt_cnt_cd", "prntCntCd");
        this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
        this.hashFields.put("dcgo_hndl_flg", "dcgoHndlFlg");
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
        this.hashFields.put("mty_rro_edi_use_flg", "mtyRroEdiUseFlg");
        this.hashFields.put("blk_vndr_svc_cd", "blkVndrSvcCd");
        this.hashFields.put("subs_co_cd", "subsCoCd");
        this.hashFields.put("otr_flg", "otrFlg");
        this.hashFields.put("vndr_ofc_cd", "vndrOfcCd");
        this.hashFields.put("rfnd_psdo_cust_cd", "rfndPsdoCustCd");
        this.hashFields.put("pay_term_tp_cd", "payTermTpCd");
        this.hashFields.put("modi_vndr_cd", "modiVndrCd");
        this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("vndr_eml", "vndrEml");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("cntc_pnt_delt_flg", "cntcPntDeltFlg");
        this.hashFields.put("cntc_div_cd", "cntcDivCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("r3_insf_id", "r3InsfId");
        this.hashFields.put("r3_insf_prs_id", "r3InsfPrsId");
        this.hashFields.put("r3_insf_dttm", "r3InsfDttm");
        this.hashFields.put("r3_insf_cnqe_val", "r3InsfCnqeVal");
        this.hashFields.put("r3_insf_dv_cd", "r3InsfDvCd");
        this.hashFields.put("r3_insf_cnqe_cont", "r3InsfCnqeCont");
        this.hashFields.put("ocedi_insf_id", "ocediInsfId");
        this.hashFields.put("ocedi_insf_prs_id", "ocediInsfPrsId");
        this.hashFields.put("ocedi_insf_dttm", "ocediInsfDttm");
        this.hashFields.put("ocedi_insf_cnqe_val", "ocediInsfCnqeVal");
        this.hashFields.put("ocedi_insf_dv_cd", "ocediInsfDvCd");
        this.hashFields.put("ocedi_insf_cnqe_cont", "ocediInsfCnqeCont");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("chk_de_cnt_cd", "chkDeCntCd");
		this.hashFields.put("cntc_pnt_delt_flg", "cntcPntDeltFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("chk_de_zip_cd", "chkDeZipCd");
		this.hashFields.put("cntc_div_cd", "cntcDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("chk_de_ste_cd", "chkDeSteCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("intl_phn_no", "intlPhnNo");

		this.hashFields.put("opedi_insf_id", "opediInsfId");
        this.hashFields.put("opedi_insf_dv_cd", "opediInsfDvCd");
		this.hashFields.put("chk_de_addr2", "chkDeAddr2");
		this.hashFields.put("chk_de_addr3", "chkDeAddr3");
		this.hashFields.put("chk_de_addr1", "chkDeAddr1");
		this.hashFields.put("chk_de_cty_nm", "chkDeCtyNm");
		this.hashFields.put("sap_id", "sapId");
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
	 * @param String vndrIfSeq
	 */
    public void setVndrIfSeq(String vndrIfSeq) {
        this.vndrIfSeq = vndrIfSeq;
    }

    /**
	 * 
	 * @return String vndrIfSeq
	 */
    public String getVndrIfSeq() {
        return this.vndrIfSeq;
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
	 * @param String vndrLglEngNm
	 */
    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    /**
	 * 
	 * @return String vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    /**
	 *
	 * @param String vndrLoclLangNm
	 */
    public void setVndrLoclLangNm(String vndrLoclLangNm) {
        this.vndrLoclLangNm = vndrLoclLangNm;
    }

    /**
	 * 
	 * @return String vndrLoclLangNm
	 */
    public String getVndrLoclLangNm() {
        return this.vndrLoclLangNm;
    }

    /**
	 *
	 * @param String vndrAbbrNm
	 */
    public void setVndrAbbrNm(String vndrAbbrNm) {
        this.vndrAbbrNm = vndrAbbrNm;
    }

    /**
	 * 
	 * @return String vndrAbbrNm
	 */
    public String getVndrAbbrNm() {
        return this.vndrAbbrNm;
    }

    /**
	 *
	 * @param String lgsFlg
	 */
    public void setLgsFlg(String lgsFlg) {
        this.lgsFlg = lgsFlg;
    }

    /**
	 * 
	 * @return String lgsFlg
	 */
    public String getLgsFlg() {
        return this.lgsFlg;
    }

    /**
	 *
	 * @param String procuFlg
	 */
    public void setProcuFlg(String procuFlg) {
        this.procuFlg = procuFlg;
    }

    /**
	 * 
	 * @return String procuFlg
	 */
    public String getProcuFlg() {
        return this.procuFlg;
    }

    /**
	 *
	 * @param String teamFlg
	 */
    public void setTeamFlg(String teamFlg) {
        this.teamFlg = teamFlg;
    }

    /**
	 * 
	 * @return String teamFlg
	 */
    public String getTeamFlg() {
        return this.teamFlg;
    }

    /**
	 *
	 * @param String fincFlg
	 */
    public void setFincFlg(String fincFlg) {
        this.fincFlg = fincFlg;
    }

    /**
	 * 
	 * @return String fincFlg
	 */
    public String getFincFlg() {
        return this.fincFlg;
    }

    /**
	 *
	 * @param String blkFlg
	 */
    public void setBlkFlg(String blkFlg) {
        this.blkFlg = blkFlg;
    }

    /**
	 * 
	 * @return String blkFlg
	 */
    public String getBlkFlg() {
        return this.blkFlg;
    }

    /**
	 *
	 * @param String interCoFlg
	 */
    public void setInterCoFlg(String interCoFlg) {
        this.interCoFlg = interCoFlg;
    }

    /**
	 * 
	 * @return String interCoFlg
	 */
    public String getInterCoFlg() {
        return this.interCoFlg;
    }

    /**
	 *
	 * @param String railVndrFlg
	 */
    public void setRailVndrFlg(String railVndrFlg) {
        this.railVndrFlg = railVndrFlg;
    }

    /**
	 * 
	 * @return String railVndrFlg
	 */
    public String getRailVndrFlg() {
        return this.railVndrFlg;
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
	 * @param String ceoNm
	 */
    public void setCeoNm(String ceoNm) {
        this.ceoNm = ceoNm;
    }

    /**
	 * 
	 * @return String ceoNm
	 */
    public String getCeoNm() {
        return this.ceoNm;
    }

    /**
	 *
	 * @param String rgstNo
	 */
    public void setRgstNo(String rgstNo) {
        this.rgstNo = rgstNo;
    }

    /**
	 * 
	 * @return String rgstNo
	 */
    public String getRgstNo() {
        return this.rgstNo;
    }

    /**
	 *
	 * @param String taxId
	 */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
	 * 
	 * @return String taxId
	 */
    public String getTaxId() {
        return this.taxId;
    }

    /**
	 *
	 * @param String prntCntCd
	 */
    public void setPrntCntCd(String prntCntCd) {
        this.prntCntCd = prntCntCd;
    }

    /**
	 * 
	 * @return String prntCntCd
	 */
    public String getPrntCntCd() {
        return this.prntCntCd;
    }

    /**
	 *
	 * @param String prntVndrSeq
	 */
    public void setPrntVndrSeq(String prntVndrSeq) {
        this.prntVndrSeq = prntVndrSeq;
    }

    /**
	 * 
	 * @return String prntVndrSeq
	 */
    public String getPrntVndrSeq() {
        return this.prntVndrSeq;
    }

    /**
	 *
	 * @param String dcgoHndlFlg
	 */
    public void setDcgoHndlFlg(String dcgoHndlFlg) {
        this.dcgoHndlFlg = dcgoHndlFlg;
    }

    /**
	 * 
	 * @return String dcgoHndlFlg
	 */
    public String getDcgoHndlFlg() {
        return this.dcgoHndlFlg;
    }

    /**
	 *
	 * @param String svcScpCdNm
	 */
    public void setSvcScpCdNm(String svcScpCdNm) {
        this.svcScpCdNm = svcScpCdNm;
    }

    /**
	 * 
	 * @return String svcScpCdNm
	 */
    public String getSvcScpCdNm() {
        return this.svcScpCdNm;
    }

    /**
	 *
	 * @param String svcPrdTpNm
	 */
    public void setSvcPrdTpNm(String svcPrdTpNm) {
        this.svcPrdTpNm = svcPrdTpNm;
    }

    /**
	 * 
	 * @return String svcPrdTpNm
	 */
    public String getSvcPrdTpNm() {
        return this.svcPrdTpNm;
    }

    /**
	 *
	 * @param String svcPrdRmk
	 */
    public void setSvcPrdRmk(String svcPrdRmk) {
        this.svcPrdRmk = svcPrdRmk;
    }

    /**
	 * 
	 * @return String svcPrdRmk
	 */
    public String getSvcPrdRmk() {
        return this.svcPrdRmk;
    }

    /**
	 *
	 * @param String bzctNm
	 */
    public void setBzctNm(String bzctNm) {
        this.bzctNm = bzctNm;
    }

    /**
	 * 
	 * @return String bzctNm
	 */
    public String getBzctNm() {
        return this.bzctNm;
    }

    /**
	 *
	 * @param String bztpNm
	 */
    public void setBztpNm(String bztpNm) {
        this.bztpNm = bztpNm;
    }

    /**
	 * 
	 * @return String bztpNm
	 */
    public String getBztpNm() {
        return this.bztpNm;
    }

    /**
	 *
	 * @param String genPayTermCd
	 */
    public void setGenPayTermCd(String genPayTermCd) {
        this.genPayTermCd = genPayTermCd;
    }

    /**
	 * 
	 * @return String genPayTermCd
	 */
    public String getGenPayTermCd() {
        return this.genPayTermCd;
    }

    /**
	 *
	 * @param String engAddr
	 */
    public void setEngAddr(String engAddr) {
        this.engAddr = engAddr;
    }

    /**
	 * 
	 * @return String engAddr
	 */
    public String getEngAddr() {
        return this.engAddr;
    }

    /**
	 *
	 * @param String loclLangAddr
	 */
    public void setLoclLangAddr(String loclLangAddr) {
        this.loclLangAddr = loclLangAddr;
    }

    /**
	 * 
	 * @return String loclLangAddr
	 */
    public String getLoclLangAddr() {
        return this.loclLangAddr;
    }

    /**
	 *
	 * @param String zipCd
	 */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
	 * 
	 * @return String zipCd
	 */
    public String getZipCd() {
        return this.zipCd;
    }

    /**
	 *
	 * @param String cntcPsonNm
	 */
    public void setCntcPsonNm(String cntcPsonNm) {
        this.cntcPsonNm = cntcPsonNm;
    }

    /**
	 * 
	 * @return String cntcPsonNm
	 */
    public String getCntcPsonNm() {
        return this.cntcPsonNm;
    }

    /**
	 *
	 * @param String invCurrCd
	 */
    public void setInvCurrCd(String invCurrCd) {
        this.invCurrCd = invCurrCd;
    }

    /**
	 * 
	 * @return String invCurrCd
	 */
    public String getInvCurrCd() {
        return this.invCurrCd;
    }

    /**
	 *
	 * @param String payCurrCd
	 */
    public void setPayCurrCd(String payCurrCd) {
        this.payCurrCd = payCurrCd;
    }

    /**
	 * 
	 * @return String payCurrCd
	 */
    public String getPayCurrCd() {
        return this.payCurrCd;
    }

    /**
	 *
	 * @param String payMzdCd
	 */
    public void setPayMzdCd(String payMzdCd) {
        this.payMzdCd = payMzdCd;
    }

    /**
	 * 
	 * @return String payMzdCd
	 */
    public String getPayMzdCd() {
        return this.payMzdCd;
    }

    /**
	 *
	 * @param String usaEdiCd
	 */
    public void setUsaEdiCd(String usaEdiCd) {
        this.usaEdiCd = usaEdiCd;
    }

    /**
	 * 
	 * @return String usaEdiCd
	 */
    public String getUsaEdiCd() {
        return this.usaEdiCd;
    }

    /**
	 *
	 * @param String woAtchFileFlg
	 */
    public void setWoAtchFileFlg(String woAtchFileFlg) {
        this.woAtchFileFlg = woAtchFileFlg;
    }

    /**
	 * 
	 * @return String woAtchFileFlg
	 */
    public String getWoAtchFileFlg() {
        return this.woAtchFileFlg;
    }

    /**
	 *
	 * @param String woEdiUseFlg
	 */
    public void setWoEdiUseFlg(String woEdiUseFlg) {
        this.woEdiUseFlg = woEdiUseFlg;
    }

    /**
	 * 
	 * @return String woEdiUseFlg
	 */
    public String getWoEdiUseFlg() {
        return this.woEdiUseFlg;
    }

    /**
	 *
	 * @param String invEdiUseFlg
	 */
    public void setInvEdiUseFlg(String invEdiUseFlg) {
        this.invEdiUseFlg = invEdiUseFlg;
    }

    /**
	 * 
	 * @return String invEdiUseFlg
	 */
    public String getInvEdiUseFlg() {
        return this.invEdiUseFlg;
    }

    /**
	 *
	 * @param String mtyRroEdiUseFlg
	 */
    public void setMtyRroEdiUseFlg(String mtyRroEdiUseFlg) {
        this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
    }

    /**
	 * 
	 * @return String mtyRroEdiUseFlg
	 */
    public String getMtyRroEdiUseFlg() {
        return this.mtyRroEdiUseFlg;
    }

    /**
	 *
	 * @param String blkVndrSvcCd
	 */
    public void setBlkVndrSvcCd(String blkVndrSvcCd) {
        this.blkVndrSvcCd = blkVndrSvcCd;
    }

    /**
	 * 
	 * @return String blkVndrSvcCd
	 */
    public String getBlkVndrSvcCd() {
        return this.blkVndrSvcCd;
    }

    /**
	 *
	 * @param String subsCoCd
	 */
    public void setSubsCoCd(String subsCoCd) {
        this.subsCoCd = subsCoCd;
    }

    /**
	 * 
	 * @return String subsCoCd
	 */
    public String getSubsCoCd() {
        return this.subsCoCd;
    }

    /**
	 *
	 * @param String otrFlg
	 */
    public void setOtrFlg(String otrFlg) {
        this.otrFlg = otrFlg;
    }

    /**
	 * 
	 * @return String otrFlg
	 */
    public String getOtrFlg() {
        return this.otrFlg;
    }

    /**
	 *
	 * @param String vndrOfcCd
	 */
    public void setVndrOfcCd(String vndrOfcCd) {
        this.vndrOfcCd = vndrOfcCd;
    }

    /**
	 * 
	 * @return String vndrOfcCd
	 */
    public String getVndrOfcCd() {
        return this.vndrOfcCd;
    }

    /**
	 *
	 * @param String rfndPsdoCustCd
	 */
    public void setRfndPsdoCustCd(String rfndPsdoCustCd) {
        this.rfndPsdoCustCd = rfndPsdoCustCd;
    }

    /**
	 * 
	 * @return String rfndPsdoCustCd
	 */
    public String getRfndPsdoCustCd() {
        return this.rfndPsdoCustCd;
    }

    /**
	 *
	 * @param String payTermTpCd
	 */
    public void setPayTermTpCd(String payTermTpCd) {
        this.payTermTpCd = payTermTpCd;
    }

    /**
	 * 
	 * @return String payTermTpCd
	 */
    public String getPayTermTpCd() {
        return this.payTermTpCd;
    }

    /**
	 *
	 * @param String modiVndrCd
	 */
    public void setModiVndrCd(String modiVndrCd) {
        this.modiVndrCd = modiVndrCd;
    }

    /**
	 * 
	 * @return String modiVndrCd
	 */
    public String getModiVndrCd() {
        return this.modiVndrCd;
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

    public void setR3InsfId(String r3InsfId) {
        this.r3InsfId = r3InsfId;
    }

    public String getR3InsfId() {
        return this.r3InsfId;
    }

    public void setR3InsfPrsId(String r3InsfPrsId) {
        this.r3InsfPrsId = r3InsfPrsId;
    }

    public String getR3InsfPrsId() {
        return this.r3InsfPrsId;
    }

    public void setR3InsfDttm(String r3InsfDttm) {
        this.r3InsfDttm = r3InsfDttm;
    }

    public String getR3InsfDttm() {
        return this.r3InsfDttm;
    }

    public void setR3InsfCnqeVal(String r3InsfCnqeVal) {
        this.r3InsfCnqeVal = r3InsfCnqeVal;
    }

    public String getR3InsfCnqeVal() {
        return this.r3InsfCnqeVal;
    }

    public void setR3InsfDvCd(String r3InsfDvCd) {
        this.r3InsfDvCd = r3InsfDvCd;
    }

    public String getR3InsfDvCd() {
        return this.r3InsfDvCd;
    }

    public void setR3InsfCnqeCont(String r3InsfCnqeCont) {
        this.r3InsfCnqeCont = r3InsfCnqeCont;
    }

    public String getR3InsfCnqeCont() {
        return this.r3InsfCnqeCont;
    }

    public void setOcediInsfId(String ocediInsfId) {
        this.ocediInsfId = ocediInsfId;
    }

    public String getOcediInsfId() {
        return this.ocediInsfId;
    }

    public void setOcediInsfPrsId(String ocediInsfPrsId) {
        this.ocediInsfPrsId = ocediInsfPrsId;
    }

    public String getOcediInsfPrsId() {
        return this.ocediInsfPrsId;
    }

    public void setOcediInsfDttm(String ocediInsfDttm) {
        this.ocediInsfDttm = ocediInsfDttm;
    }

    public String getOcediInsfDttm() {
        return this.ocediInsfDttm;
    }

    public void setOcediInsfCnqeVal(String ocediInsfCnqeVal) {
        this.ocediInsfCnqeVal = ocediInsfCnqeVal;
    }

    public String getOcediInsfCnqeVal() {
        return this.ocediInsfCnqeVal;
    }

    public void setOcediInsfDvCd(String ocediInsfDvCd) {
        this.ocediInsfDvCd = ocediInsfDvCd;
    }

    public String getOcediInsfDvCd() {
        return this.ocediInsfDvCd;
    }

    public void setOcediInsfCnqeCont(String ocediInsfCnqeCont) {
        this.ocediInsfCnqeCont = ocediInsfCnqeCont;
    }

    public String getOcediInsfCnqeCont() {
        return this.ocediInsfCnqeCont;
    }
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return chkDeCntCd
	 */
	public String getChkDeCntCd() {
		return this.chkDeCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPntDeltFlg
	 */
	public String getCntcPntDeltFlg() {
		return this.cntcPntDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}
	
	/**
	 * Column Info
	 * @return chkDeZipCd
	 */
	public String getChkDeZipCd() {
		return this.chkDeZipCd;
	}
	
	/**
	 * Column Info
	 * @return cntcDivCd
	 */
	public String getCntcDivCd() {
		return this.cntcDivCd;
	}
	
	/**
	 * Column Info
	 * @return prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return this.prmryChkFlg;
	}
	
	/**
	 * Column Info
	 * @return chkDeSteCd
	 */
	public String getChkDeSteCd() {
		return this.chkDeSteCd;
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
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	

	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param chkDeCntCd
	 */
	public void setChkDeCntCd(String chkDeCntCd) {
		this.chkDeCntCd = chkDeCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPntDeltFlg
	 */
	public void setCntcPntDeltFlg(String cntcPntDeltFlg) {
		this.cntcPntDeltFlg = cntcPntDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
	}
	
	/**
	 * Column Info
	 * @param chkDeZipCd
	 */
	public void setChkDeZipCd(String chkDeZipCd) {
		this.chkDeZipCd = chkDeZipCd;
	}
	
	/**
	 * Column Info
	 * @param cntcDivCd
	 */
	public void setCntcDivCd(String cntcDivCd) {
		this.cntcDivCd = cntcDivCd;
	}
	
	/**
	 * Column Info
	 * @param prmryChkFlg
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}
	
	/**
	 * Column Info
	 * @param chkDeSteCd
	 */
	public void setChkDeSteCd(String chkDeSteCd) {
		this.chkDeSteCd = chkDeSteCd;
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
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}

	public String getOpediInsfId() {
		return opediInsfId;
	}

	public void setOpediInsfId(String opediInsfId) {
		this.opediInsfId = opediInsfId;
	}

    public void setOpediInsfDvCd(String opediInsfDvCd) {
        this.opediInsfDvCd = opediInsfDvCd;
    }

    public String getOpediInsfDvCd() {
        return this.opediInsfDvCd;
    }

    public String getChkDeAddr2() {
		return chkDeAddr2;
	}

	public void setChkDeAddr2(String chkDeAddr2) {
		this.chkDeAddr2 = chkDeAddr2;
	}

	public String getChkDeAddr3() {
		return chkDeAddr3;
	}

	public void setChkDeAddr3(String chkDeAddr3) {
		this.chkDeAddr3 = chkDeAddr3;
	}

	public String getChkDeAddr1() {
		return chkDeAddr1;
	}

	public void setChkDeAddr1(String chkDeAddr1) {
		this.chkDeAddr1 = chkDeAddr1;
	}

	public String getChkDeCtyNm() {
		return chkDeCtyNm;
	}

	public void setChkDeCtyNm(String chkDeCtyNm) {
		this.chkDeCtyNm = chkDeCtyNm;
	}

    public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
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
        setVndrIfSeq(JSPUtil.getParameter(request, prefix + "vndr_if_seq", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setVndrLoclLangNm(JSPUtil.getParameter(request, prefix + "vndr_locl_lang_nm", ""));
        setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
        setLgsFlg(JSPUtil.getParameter(request, prefix + "lgs_flg", ""));
        setProcuFlg(JSPUtil.getParameter(request, prefix + "procu_flg", ""));
        setTeamFlg(JSPUtil.getParameter(request, prefix + "team_flg", ""));
        setFincFlg(JSPUtil.getParameter(request, prefix + "finc_flg", ""));
        setBlkFlg(JSPUtil.getParameter(request, prefix + "blk_flg", ""));
        setInterCoFlg(JSPUtil.getParameter(request, prefix + "inter_co_flg", ""));
        setRailVndrFlg(JSPUtil.getParameter(request, prefix + "rail_vndr_flg", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCeoNm(JSPUtil.getParameter(request, prefix + "ceo_nm", ""));
        setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
        setTaxId(JSPUtil.getParameter(request, prefix + "tax_id", ""));
        setPrntCntCd(JSPUtil.getParameter(request, prefix + "prnt_cnt_cd", ""));
        setPrntVndrSeq(JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", ""));
        setDcgoHndlFlg(JSPUtil.getParameter(request, prefix + "dcgo_hndl_flg", ""));
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
        setMtyRroEdiUseFlg(JSPUtil.getParameter(request, prefix + "mty_rro_edi_use_flg", ""));
        setBlkVndrSvcCd(JSPUtil.getParameter(request, prefix + "blk_vndr_svc_cd", ""));
        setSubsCoCd(JSPUtil.getParameter(request, prefix + "subs_co_cd", ""));
        setOtrFlg(JSPUtil.getParameter(request, prefix + "otr_flg", ""));
        setVndrOfcCd(JSPUtil.getParameter(request, prefix + "vndr_ofc_cd", ""));
        setRfndPsdoCustCd(JSPUtil.getParameter(request, prefix + "rfnd_psdo_cust_cd", ""));
        setPayTermTpCd(JSPUtil.getParameter(request, prefix + "pay_term_tp_cd", ""));
        setModiVndrCd(JSPUtil.getParameter(request, prefix + "modi_vndr_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setR3InsfId(JSPUtil.getParameter(request, prefix + "r3_insf_id", ""));
        setR3InsfPrsId(JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", ""));
        setR3InsfDttm(JSPUtil.getParameter(request, prefix + "r3_insf_dttm", ""));
        setR3InsfCnqeVal(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", ""));
        setR3InsfDvCd(JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", ""));
        setR3InsfCnqeCont(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", ""));
        setOcediInsfId(JSPUtil.getParameter(request, prefix + "ocedi_insf_id", ""));
        setOcediInsfPrsId(JSPUtil.getParameter(request, prefix + "ocedi_insf_prs_id", ""));
        setOcediInsfDttm(JSPUtil.getParameter(request, prefix + "ocedi_insf_dttm", ""));
        setOcediInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_val", ""));
        setOcediInsfDvCd(JSPUtil.getParameter(request, prefix + "ocedi_insf_dv_cd", ""));
        setOcediInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_cont", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setChkDeCntCd(JSPUtil.getParameter(request, prefix + "chk_de_cnt_cd", ""));
		setCntcPntDeltFlg(JSPUtil.getParameter(request, prefix + "cntc_pnt_delt_flg", ""));
		setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
		setChkDeZipCd(JSPUtil.getParameter(request, prefix + "chk_de_zip_cd", ""));
		setCntcDivCd(JSPUtil.getParameter(request, prefix + "cntc_div_cd", ""));
		setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
		setChkDeSteCd(JSPUtil.getParameter(request, prefix + "chk_de_ste_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));

		setOpediInsfId(JSPUtil.getParameter(request, prefix + "opedi_insf_id", ""));
        setOpediInsfDvCd(JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", ""));
		setChkDeAddr2(JSPUtil.getParameter(request, prefix + "chk_de_addr2", ""));
		setChkDeAddr3(JSPUtil.getParameter(request, prefix + "chk_de_addr3", ""));
		setChkDeAddr1(JSPUtil.getParameter(request, prefix + "chk_de_addr1", ""));
		setChkDeCtyNm(JSPUtil.getParameter(request, prefix + "chk_de_cty_nm", ""));
		setSapId(JSPUtil.getParameter(request, prefix + "sap_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VendorIfVO[]
	 */
    public VendorIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VendorIfVO[]
	 */
    public VendorIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VendorIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrIfSeq = (JSPUtil.getParameter(request, prefix + "vndr_if_seq", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] vndrLoclLangNm = (JSPUtil.getParameter(request, prefix + "vndr_locl_lang_nm", length));
            String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", length));
            String[] lgsFlg = (JSPUtil.getParameter(request, prefix + "lgs_flg", length));
            String[] procuFlg = (JSPUtil.getParameter(request, prefix + "procu_flg", length));
            String[] teamFlg = (JSPUtil.getParameter(request, prefix + "team_flg", length));
            String[] fincFlg = (JSPUtil.getParameter(request, prefix + "finc_flg", length));
            String[] blkFlg = (JSPUtil.getParameter(request, prefix + "blk_flg", length));
            String[] interCoFlg = (JSPUtil.getParameter(request, prefix + "inter_co_flg", length));
            String[] railVndrFlg = (JSPUtil.getParameter(request, prefix + "rail_vndr_flg", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ceoNm = (JSPUtil.getParameter(request, prefix + "ceo_nm", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] taxId = (JSPUtil.getParameter(request, prefix + "tax_id", length));
            String[] prntCntCd = (JSPUtil.getParameter(request, prefix + "prnt_cnt_cd", length));
            String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", length));
            String[] dcgoHndlFlg = (JSPUtil.getParameter(request, prefix + "dcgo_hndl_flg", length));
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
            String[] mtyRroEdiUseFlg = (JSPUtil.getParameter(request, prefix + "mty_rro_edi_use_flg", length));
            String[] blkVndrSvcCd = (JSPUtil.getParameter(request, prefix + "blk_vndr_svc_cd", length));
            String[] subsCoCd = (JSPUtil.getParameter(request, prefix + "subs_co_cd", length));
            String[] otrFlg = (JSPUtil.getParameter(request, prefix + "otr_flg", length));
            String[] vndrOfcCd = (JSPUtil.getParameter(request, prefix + "vndr_ofc_cd", length));
            String[] rfndPsdoCustCd = (JSPUtil.getParameter(request, prefix + "rfnd_psdo_cust_cd", length));
            String[] payTermTpCd = (JSPUtil.getParameter(request, prefix + "pay_term_tp_cd", length));
            String[] modiVndrCd = (JSPUtil.getParameter(request, prefix + "modi_vndr_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] r3InsfId = (JSPUtil.getParameter(request, prefix + "r3_insf_id", length));
	    	String[] r3InsfPrsId = (JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", length));
	    	String[] r3InsfDttm = (JSPUtil.getParameter(request, prefix + "r3_insf_dttm", length));
	    	String[] r3InsfCnqeVal = (JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", length));
	    	String[] r3InsfDvCd = (JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", length));
	    	String[] r3InsfCnqeCont = (JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", length));
	    	String[] ocediInsfId = (JSPUtil.getParameter(request, prefix + "ocedi_insf_id", length));
	    	String[] ocediInsfPrsId = (JSPUtil.getParameter(request, prefix + "ocedi_insf_prs_id", length));
	    	String[] ocediInsfDttm = (JSPUtil.getParameter(request, prefix + "ocedi_insf_dttm", length));
	    	String[] ocediInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_val", length));
	    	String[] ocediInsfDvCd = (JSPUtil.getParameter(request, prefix + "ocedi_insf_dv_cd", length));
	    	String[] ocediInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_cont", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] chkDeCntCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_cnt_cd", length));
			String[] cntcPntDeltFlg = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_delt_flg", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] chkDeZipCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_zip_cd", length));
			String[] cntcDivCd = (JSPUtil.getParameter(request, prefix	+ "cntc_div_cd", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] chkDeSteCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_ste_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));

			String[] opediInsfId = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_id", length));
	    	String[] opediInsfDvCd = (JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", length));
			String[] chkDeAddr2 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr2", length));
			String[] chkDeAddr3 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr3", length));
			String[] chkDeAddr1 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr1", length));
			String[] chkDeCtyNm = (JSPUtil.getParameter(request, prefix	+ "chk_de_cty_nm", length));
			String[] sapId = (JSPUtil.getParameter(request, prefix	+ "sap_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VendorIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrIfSeq[i] != null)
                    model.setVndrIfSeq(vndrIfSeq[i]);
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
                if (lgsFlg[i] != null)
                    model.setLgsFlg(lgsFlg[i]);
                if (procuFlg[i] != null)
                    model.setProcuFlg(procuFlg[i]);
                if (teamFlg[i] != null)
                    model.setTeamFlg(teamFlg[i]);
                if (fincFlg[i] != null)
                    model.setFincFlg(fincFlg[i]);
                if (blkFlg[i] != null)
                    model.setBlkFlg(blkFlg[i]);
                if (interCoFlg[i] != null)
                    model.setInterCoFlg(interCoFlg[i]);
                if (railVndrFlg[i] != null)
                    model.setRailVndrFlg(railVndrFlg[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ceoNm[i] != null)
                    model.setCeoNm(ceoNm[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (taxId[i] != null)
                    model.setTaxId(taxId[i]);
                if (prntCntCd[i] != null)
                    model.setPrntCntCd(prntCntCd[i]);
                if (prntVndrSeq[i] != null)
                    model.setPrntVndrSeq(prntVndrSeq[i]);
                if (dcgoHndlFlg[i] != null)
                    model.setDcgoHndlFlg(dcgoHndlFlg[i]);
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
                if (mtyRroEdiUseFlg[i] != null)
                    model.setMtyRroEdiUseFlg(mtyRroEdiUseFlg[i]);
                if (blkVndrSvcCd[i] != null)
                    model.setBlkVndrSvcCd(blkVndrSvcCd[i]);
                if (subsCoCd[i] != null)
                    model.setSubsCoCd(subsCoCd[i]);
                if (otrFlg[i] != null)
                    model.setOtrFlg(otrFlg[i]);
                if (vndrOfcCd[i] != null)
                    model.setVndrOfcCd(vndrOfcCd[i]);
                if (rfndPsdoCustCd[i] != null)
                    model.setRfndPsdoCustCd(rfndPsdoCustCd[i]);
                if (payTermTpCd[i] != null)
                    model.setPayTermTpCd(payTermTpCd[i]);
                if (modiVndrCd[i] != null)
                    model.setModiVndrCd(modiVndrCd[i]);
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
                if (r3InsfId[i] != null) 
		    		model.setR3InsfId(r3InsfId[i]);
				if (r3InsfPrsId[i] != null) 
		    		model.setR3InsfPrsId(r3InsfPrsId[i]);
				if (r3InsfDttm[i] != null) 
		    		model.setR3InsfDttm(r3InsfDttm[i]);
				if (r3InsfCnqeVal[i] != null) 
		    		model.setR3InsfCnqeVal(r3InsfCnqeVal[i]);
				if (r3InsfDvCd[i] != null) 
		    		model.setR3InsfDvCd(r3InsfDvCd[i]);
				if (r3InsfCnqeCont[i] != null) 
		    		model.setR3InsfCnqeCont(r3InsfCnqeCont[i]);
				if (ocediInsfId[i] != null) 
		    		model.setOcediInsfId(ocediInsfId[i]);
				if (ocediInsfPrsId[i] != null) 
		    		model.setOcediInsfPrsId(ocediInsfPrsId[i]);
				if (ocediInsfDttm[i] != null) 
		    		model.setOcediInsfDttm(ocediInsfDttm[i]);
				if (ocediInsfCnqeVal[i] != null) 
		    		model.setOcediInsfCnqeVal(ocediInsfCnqeVal[i]);
				if (ocediInsfDvCd[i] != null) 
		    		model.setOcediInsfDvCd(ocediInsfDvCd[i]);
				if (ocediInsfCnqeCont[i] != null) 
		    		model.setOcediInsfCnqeCont(ocediInsfCnqeCont[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (chkDeCntCd[i] != null)
					model.setChkDeCntCd(chkDeCntCd[i]);
				if (cntcPntDeltFlg[i] != null)
					model.setCntcPntDeltFlg(cntcPntDeltFlg[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (chkDeZipCd[i] != null)
					model.setChkDeZipCd(chkDeZipCd[i]);
				if (cntcDivCd[i] != null)
					model.setCntcDivCd(cntcDivCd[i]);
				if (prmryChkFlg[i] != null)
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (chkDeSteCd[i] != null)
					model.setChkDeSteCd(chkDeSteCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				
				if (opediInsfId[i] != null)
					model.setOpediInsfId(opediInsfId[i]);
				if (opediInsfDvCd[i] != null) 
		    		model.setOpediInsfDvCd(opediInsfDvCd[i]);
				if (chkDeAddr2[i] != null)
					model.setChkDeAddr2(chkDeAddr2[i]);
				if (chkDeAddr3[i] != null)
					model.setChkDeAddr3(chkDeAddr3[i]);
				if (chkDeAddr1[i] != null)
					model.setChkDeAddr1(chkDeAddr1[i]);
				if (chkDeCtyNm[i] != null)
					model.setChkDeCtyNm(chkDeCtyNm[i]);
				if (sapId[i] != null)
					model.setSapId(sapId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVendorIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VendorIfVO[]
	 */
    public VendorIfVO[] getVendorIfVOs() {
        VendorIfVO[] vos = (VendorIfVO[]) models.toArray(new VendorIfVO[models.size()]);
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
        this.vndrIfSeq = this.vndrIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLoclLangNm = this.vndrLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsFlg = this.lgsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.procuFlg = this.procuFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teamFlg = this.teamFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincFlg = this.fincFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkFlg = this.blkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.interCoFlg = this.interCoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railVndrFlg = this.railVndrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ceoNm = this.ceoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxId = this.taxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntCntCd = this.prntCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntVndrSeq = this.prntVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoHndlFlg = this.dcgoHndlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.mtyRroEdiUseFlg = this.mtyRroEdiUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkVndrSvcCd = this.blkVndrSvcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subsCoCd = this.subsCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otrFlg = this.otrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrOfcCd = this.vndrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfndPsdoCustCd = this.rfndPsdoCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payTermTpCd = this.payTermTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVndrCd = this.modiVndrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfId = this.r3InsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfPrsId = this.r3InsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfDttm = this.r3InsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfCnqeVal = this.r3InsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfDvCd = this.r3InsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfCnqeCont = this.r3InsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfId = this.ocediInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfPrsId = this.ocediInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfDttm = this.ocediInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfCnqeVal = this.ocediInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfDvCd = this.ocediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfCnqeCont = this.ocediInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeCntCd = this.chkDeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntDeltFlg = this.cntcPntDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeZipCd = this.chkDeZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcDivCd = this.cntcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeSteCd = this.chkDeSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.opediInsfId = this.opediInsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opediInsfDvCd = this.opediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr2 = this.chkDeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr3 = this.chkDeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr1 = this.chkDeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeCtyNm = this.chkDeCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sapId = this.sapId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
