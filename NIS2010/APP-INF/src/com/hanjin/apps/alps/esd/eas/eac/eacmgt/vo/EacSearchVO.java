/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacSearchVO.java
*@FileTitle : EacSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.12.01 최종혁 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

import java.lang.reflect.Field;
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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class EacSearchVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<EacSearchVO> models = new ArrayList<EacSearchVO>();

    /* Column Info */
    private String n3ptyExpnTpCd = null;

    /* Column Info */
    private String isflag = null;

    /* Column Info */
    private String vndrCntcPntNm = null;

    /* Column Info */
    private String sTrdPartyVal = null;

    /* Column Info */
    private String sEacYrmon = null;

    /* Column Info */
    private String ofcTpCd = null;

    /* Column Info */
    private String gVndrSeq = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String bilCurrCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrNm = null;

    /* Column Info */
    private String usrOfcCd = null;

    /* Column Info */
    private String vndrCntcPntSeq = null;

    /* Column Info */
    private String sortkey = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String contactPointExists = null;

    /* Column Info */
    private String usrEml = null;

    /* Column Info */
    private String sEacInpFmDt = null;

    /* Column Info */
    private String sKeyword = null;

    /* Column Info */
    private String n3ptySrcDt = null;

    /* Column Info */
    private String sEacBilTpCd = null;

    /* Column Info */
    private String n3ptyIfOfcFlg = null;

    /* Column Info */
    private String usrExistFlag = null;

    /* Column Info */
    private String sEacExpnTpCd = null;

    /* Column Info */
    private String sOfcCd = null;

    /* Column Info */
    private String sVndrCustDivCd = null;

    /* Column Info */
    private String disEacStsNm = null;

    /* Column Info */
    private String sInvAudUsdAmt = null;

    /* Column Info */
    private String rhqOfcCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String eacStsCd = null;

    /* Column Info */
    private String sTpbDup = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String codeCd = null;

    /* Column Info */
    private String val = null;

    /* Column Info */
    private String sRhqOfcCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String offceLvl = null;

    /* Column Info */
    private String aproUsrNm = null;

    /* Column Info */
    private String ofcExistFlag = null;

    /* Column Info */
    private String sEacDup = null;

    /* Column Info */
    private String rwAuthCd = null;

    /* Column Info */
    private String emlCtnt = null;

    /* Column Info */
    private String eacAproRsn = null;

    /* Column Info */
    private String ntcCcRcvEml = null;

    /* Column Info */
    private String hqOfcUseFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String eacType1 = null;

    /* Column Info */
    private String ofclevel = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String n3ptyNo = null;

    /* Column Info */
    private String sCntCd = null;

    /* Column Info */
    private String usdLoclXchRt = null;

    /* Column Info */
    private String codeNm = null;

    /* Column Info */
    private String codeKey = null;

    /* Column Info */
    private String kpiOfcCd = null;

    /* Column Info */
    private String sEacStsCd = null;

    /* Column Info */
    private String cnt = null;

    /* Column Info */
    private String sEacYrmonTo = null;

    /* Column Info */
    private String sEacYrmonFm = null;

    /* Column Info */
    private String disEacStsCd = null;

    /* Column Info */
    private String eacSysIfCd = null;

    /* Column Info */
    private String sVndrSeq = null;

    /* Column Info */
    private String eacExpnTpCd = null;

    /* Column Info */
    private String sEacTpCd = null;

    /* Column Info */
    private String eacNo = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String sEacRegUsrId = null;

    /* Column Info */
    private String bilCurrCd1 = null;

    /* Column Info */
    private String respbOfcCd = null;

    /* Column Info */
    private String emlSubjCtnt = null;

    /* Column Info */
    private String sEacInpToDt = null;

    /* Column Info */
    private String n3ptySrcNo = null;

    /* Column Info */
    private String expnAudRsltInvAudDiffAmt = null;

    /* Column Info */
    private String invCfmDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public EacSearchVO() {
    }

    public EacSearchVO(String ibflag, String pagerows, String codeCd, String codeNm, String codeKey, String eacExpnTpCd, String n3ptyExpnTpCd, String sEacExpnTpCd, String eacType1, String offceLvl, String ofcCd, String ofcTpCd, String vndrSeq, String vndrNm, String respbOfcCd, String isflag, String ydCd, String cntCd, String rhqOfcCd, String bilCurrCd, String bilCurrCd1, String n3ptySrcDt, String currCd, String usdLoclXchRt, String sRhqOfcCd, String sOfcCd, String sCntCd, String sVndrSeq, String gVndrSeq, String vndrCntcPntSeq, String vndrCntcPntNm, String cnt, String n3ptySrcNo, String eacNo, String bkgNo, String blNo, String n3ptyNo, String rwAuthCd, String contactPointExists, String eacStsCd, String usrId, String eacAproRsn, String sTrdPartyVal, String sVndrCustDivCd, String val, String emlSubjCtnt, String emlCtnt, String sEacRegUsrId, String sEacTpCd, String sEacBilTpCd, String sEacInpFmDt, String sEacInpToDt, String sKeyword, String sEacStsCd, String sEacYrmon, String sInvAudUsdAmt, String sEacDup, String sTpbDup, String ofclevel, String sortkey, String usrExistFlag, String usrEml, String ofcExistFlag, String ntcCcRcvEml, String sEacYrmonFm, String sEacYrmonTo, String eacSysIfCd, String usrOfcCd, String n3ptyIfOfcFlg, String kpiOfcCd, String hqOfcUseFlg, String disEacStsCd, String disEacStsNm, String aproUsrNm, String expnAudRsltInvAudDiffAmt, String invCfmDt) {
        this.n3ptyExpnTpCd = n3ptyExpnTpCd;
        this.isflag = isflag;
        this.vndrCntcPntNm = vndrCntcPntNm;
        this.sTrdPartyVal = sTrdPartyVal;
        this.sEacYrmon = sEacYrmon;
        this.ofcTpCd = ofcTpCd;
        this.gVndrSeq = gVndrSeq;
        this.blNo = blNo;
        this.bilCurrCd = bilCurrCd;
        this.pagerows = pagerows;
        this.vndrNm = vndrNm;
        this.usrOfcCd = usrOfcCd;
        this.vndrCntcPntSeq = vndrCntcPntSeq;
        this.sortkey = sortkey;
        this.cntCd = cntCd;
        this.contactPointExists = contactPointExists;
        this.usrEml = usrEml;
        this.sEacInpFmDt = sEacInpFmDt;
        this.sKeyword = sKeyword;
        this.n3ptySrcDt = n3ptySrcDt;
        this.sEacBilTpCd = sEacBilTpCd;
        this.n3ptyIfOfcFlg = n3ptyIfOfcFlg;
        this.usrExistFlag = usrExistFlag;
        this.sEacExpnTpCd = sEacExpnTpCd;
        this.sOfcCd = sOfcCd;
        this.sVndrCustDivCd = sVndrCustDivCd;
        this.disEacStsNm = disEacStsNm;
        this.sInvAudUsdAmt = sInvAudUsdAmt;
        this.rhqOfcCd = rhqOfcCd;
        this.bkgNo = bkgNo;
        this.eacStsCd = eacStsCd;
        this.sTpbDup = sTpbDup;
        this.vndrSeq = vndrSeq;
        this.codeCd = codeCd;
        this.val = val;
        this.sRhqOfcCd = sRhqOfcCd;
        this.currCd = currCd;
        this.offceLvl = offceLvl;
        this.aproUsrNm = aproUsrNm;
        this.ofcExistFlag = ofcExistFlag;
        this.sEacDup = sEacDup;
        this.rwAuthCd = rwAuthCd;
        this.emlCtnt = emlCtnt;
        this.eacAproRsn = eacAproRsn;
        this.ntcCcRcvEml = ntcCcRcvEml;
        this.hqOfcUseFlg = hqOfcUseFlg;
        this.ibflag = ibflag;
        this.eacType1 = eacType1;
        this.ofclevel = ofclevel;
        this.usrId = usrId;
        this.n3ptyNo = n3ptyNo;
        this.sCntCd = sCntCd;
        this.usdLoclXchRt = usdLoclXchRt;
        this.codeNm = codeNm;
        this.codeKey = codeKey;
        this.kpiOfcCd = kpiOfcCd;
        this.sEacStsCd = sEacStsCd;
        this.cnt = cnt;
        this.sEacYrmonTo = sEacYrmonTo;
        this.sEacYrmonFm = sEacYrmonFm;
        this.disEacStsCd = disEacStsCd;
        this.eacSysIfCd = eacSysIfCd;
        this.sVndrSeq = sVndrSeq;
        this.eacExpnTpCd = eacExpnTpCd;
        this.sEacTpCd = sEacTpCd;
        this.eacNo = eacNo;
        this.ofcCd = ofcCd;
        this.ydCd = ydCd;
        this.sEacRegUsrId = sEacRegUsrId;
        this.bilCurrCd1 = bilCurrCd1;
        this.respbOfcCd = respbOfcCd;
        this.emlSubjCtnt = emlSubjCtnt;
        this.sEacInpToDt = sEacInpToDt;
        this.n3ptySrcNo = n3ptySrcNo;
        this.expnAudRsltInvAudDiffAmt = expnAudRsltInvAudDiffAmt;
        this.invCfmDt = invCfmDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
        this.hashColumns.put("isflag", getIsflag());
        this.hashColumns.put("vndr_cntc_pnt_nm", getVndrCntcPntNm());
        this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
        this.hashColumns.put("s_eac_yrmon", getSEacYrmon());
        this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
        this.hashColumns.put("g_vndr_seq", getGVndrSeq());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("bil_curr_cd", getBilCurrCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
        this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
        this.hashColumns.put("sortkey", getSortkey());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("contact_point_exists", getContactPointExists());
        this.hashColumns.put("usr_eml", getUsrEml());
        this.hashColumns.put("s_eac_inp_fm_dt", getSEacInpFmDt());
        this.hashColumns.put("s_keyword", getSKeyword());
        this.hashColumns.put("n3pty_src_dt", getN3ptySrcDt());
        this.hashColumns.put("s_eac_bil_tp_cd", getSEacBilTpCd());
        this.hashColumns.put("n3pty_if_ofc_flg", getN3ptyIfOfcFlg());
        this.hashColumns.put("usr_exist_flag", getUsrExistFlag());
        this.hashColumns.put("s_eac_expn_tp_cd", getSEacExpnTpCd());
        this.hashColumns.put("s_ofc_cd", getSOfcCd());
        this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
        this.hashColumns.put("dis_eac_sts_nm", getDisEacStsNm());
        this.hashColumns.put("s_inv_aud_usd_amt", getSInvAudUsdAmt());
        this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("eac_sts_cd", getEacStsCd());
        this.hashColumns.put("s_tpb_dup", getSTpbDup());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("code_cd", getCodeCd());
        this.hashColumns.put("val", getVal());
        this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("offce_lvl", getOffceLvl());
        this.hashColumns.put("apro_usr_nm", getAproUsrNm());
        this.hashColumns.put("ofc_exist_flag", getOfcExistFlag());
        this.hashColumns.put("s_eac_dup", getSEacDup());
        this.hashColumns.put("rw_auth_cd", getRwAuthCd());
        this.hashColumns.put("eml_ctnt", getEmlCtnt());
        this.hashColumns.put("eac_apro_rsn", getEacAproRsn());
        this.hashColumns.put("ntc_cc_rcv_eml", getNtcCcRcvEml());
        this.hashColumns.put("hq_ofc_use_flg", getHqOfcUseFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("eac_type1", getEacType1());
        this.hashColumns.put("ofclevel", getOfclevel());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("n3pty_no", getN3ptyNo());
        this.hashColumns.put("s_cnt_cd", getSCntCd());
        this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
        this.hashColumns.put("code_nm", getCodeNm());
        this.hashColumns.put("code_key", getCodeKey());
        this.hashColumns.put("kpi_ofc_cd", getKpiOfcCd());
        this.hashColumns.put("s_eac_sts_cd", getSEacStsCd());
        this.hashColumns.put("cnt", getCnt());
        this.hashColumns.put("s_eac_yrmon_to", getSEacYrmonTo());
        this.hashColumns.put("s_eac_yrmon_fm", getSEacYrmonFm());
        this.hashColumns.put("dis_eac_sts_cd", getDisEacStsCd());
        this.hashColumns.put("eac_sys_if_cd", getEacSysIfCd());
        this.hashColumns.put("s_vndr_seq", getSVndrSeq());
        this.hashColumns.put("eac_expn_tp_cd", getEacExpnTpCd());
        this.hashColumns.put("s_eac_tp_cd", getSEacTpCd());
        this.hashColumns.put("eac_no", getEacNo());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("s_eac_reg_usr_id", getSEacRegUsrId());
        this.hashColumns.put("bil_curr_cd1", getBilCurrCd1());
        this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
        this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
        this.hashColumns.put("s_eac_inp_to_dt", getSEacInpToDt());
        this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
        this.hashColumns.put("expn_aud_rslt_inv_aud_diff_amt", getExpnAudRsltInvAudDiffAmt());
        this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
        this.hashFields.put("isflag", "isflag");
        this.hashFields.put("vndr_cntc_pnt_nm", "vndrCntcPntNm");
        this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
        this.hashFields.put("s_eac_yrmon", "sEacYrmon");
        this.hashFields.put("ofc_tp_cd", "ofcTpCd");
        this.hashFields.put("g_vndr_seq", "gVndrSeq");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("bil_curr_cd", "bilCurrCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("usr_ofc_cd", "usrOfcCd");
        this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
        this.hashFields.put("sortkey", "sortkey");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("contact_point_exists", "contactPointExists");
        this.hashFields.put("usr_eml", "usrEml");
        this.hashFields.put("s_eac_inp_fm_dt", "sEacInpFmDt");
        this.hashFields.put("s_keyword", "sKeyword");
        this.hashFields.put("n3pty_src_dt", "n3ptySrcDt");
        this.hashFields.put("s_eac_bil_tp_cd", "sEacBilTpCd");
        this.hashFields.put("n3pty_if_ofc_flg", "n3ptyIfOfcFlg");
        this.hashFields.put("usr_exist_flag", "usrExistFlag");
        this.hashFields.put("s_eac_expn_tp_cd", "sEacExpnTpCd");
        this.hashFields.put("s_ofc_cd", "sOfcCd");
        this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
        this.hashFields.put("dis_eac_sts_nm", "disEacStsNm");
        this.hashFields.put("s_inv_aud_usd_amt", "sInvAudUsdAmt");
        this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("eac_sts_cd", "eacStsCd");
        this.hashFields.put("s_tpb_dup", "sTpbDup");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("code_cd", "codeCd");
        this.hashFields.put("val", "val");
        this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("offce_lvl", "offceLvl");
        this.hashFields.put("apro_usr_nm", "aproUsrNm");
        this.hashFields.put("ofc_exist_flag", "ofcExistFlag");
        this.hashFields.put("s_eac_dup", "sEacDup");
        this.hashFields.put("rw_auth_cd", "rwAuthCd");
        this.hashFields.put("eml_ctnt", "emlCtnt");
        this.hashFields.put("eac_apro_rsn", "eacAproRsn");
        this.hashFields.put("ntc_cc_rcv_eml", "ntcCcRcvEml");
        this.hashFields.put("hq_ofc_use_flg", "hqOfcUseFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("eac_type1", "eacType1");
        this.hashFields.put("ofclevel", "ofclevel");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("n3pty_no", "n3ptyNo");
        this.hashFields.put("s_cnt_cd", "sCntCd");
        this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
        this.hashFields.put("code_nm", "codeNm");
        this.hashFields.put("code_key", "codeKey");
        this.hashFields.put("kpi_ofc_cd", "kpiOfcCd");
        this.hashFields.put("s_eac_sts_cd", "sEacStsCd");
        this.hashFields.put("cnt", "cnt");
        this.hashFields.put("s_eac_yrmon_to", "sEacYrmonTo");
        this.hashFields.put("s_eac_yrmon_fm", "sEacYrmonFm");
        this.hashFields.put("dis_eac_sts_cd", "disEacStsCd");
        this.hashFields.put("eac_sys_if_cd", "eacSysIfCd");
        this.hashFields.put("s_vndr_seq", "sVndrSeq");
        this.hashFields.put("eac_expn_tp_cd", "eacExpnTpCd");
        this.hashFields.put("s_eac_tp_cd", "sEacTpCd");
        this.hashFields.put("eac_no", "eacNo");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("s_eac_reg_usr_id", "sEacRegUsrId");
        this.hashFields.put("bil_curr_cd1", "bilCurrCd1");
        this.hashFields.put("respb_ofc_cd", "respbOfcCd");
        this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
        this.hashFields.put("s_eac_inp_to_dt", "sEacInpToDt");
        this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
        this.hashFields.put("expn_aud_rslt_inv_aud_diff_amt", "expnAudRsltInvAudDiffAmt");
        this.hashFields.put("inv_cfm_dt", "invCfmDt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
    public String getN3ptyExpnTpCd() {
        return this.n3ptyExpnTpCd;
    }

    /**
	 * Column Info
	 * @return isflag
	 */
    public String getIsflag() {
        return this.isflag;
    }

    /**
	 * Column Info
	 * @return vndrCntcPntNm
	 */
    public String getVndrCntcPntNm() {
        return this.vndrCntcPntNm;
    }

    /**
	 * Column Info
	 * @return sTrdPartyVal
	 */
    public String getSTrdPartyVal() {
        return this.sTrdPartyVal;
    }

    /**
	 * Column Info
	 * @return sEacYrmon
	 */
    public String getSEacYrmon() {
        return this.sEacYrmon;
    }

    /**
	 * Column Info
	 * @return ofcTpCd
	 */
    public String getOfcTpCd() {
        return this.ofcTpCd;
    }

    /**
	 * Column Info
	 * @return gVndrSeq
	 */
    public String getGVndrSeq() {
        return this.gVndrSeq;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return bilCurrCd
	 */
    public String getBilCurrCd() {
        return this.bilCurrCd;
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
	 * @return vndrNm
	 */
    public String getVndrNm() {
        return this.vndrNm;
    }

    /**
	 * Column Info
	 * @return usrOfcCd
	 */
    public String getUsrOfcCd() {
        return this.usrOfcCd;
    }

    /**
	 * Column Info
	 * @return vndrCntcPntSeq
	 */
    public String getVndrCntcPntSeq() {
        return this.vndrCntcPntSeq;
    }

    /**
	 * Column Info
	 * @return sortkey
	 */
    public String getSortkey() {
        return this.sortkey;
    }

    /**
	 * Column Info
	 * @return cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 * Column Info
	 * @return contactPointExists
	 */
    public String getContactPointExists() {
        return this.contactPointExists;
    }

    /**
	 * Column Info
	 * @return usrEml
	 */
    public String getUsrEml() {
        return this.usrEml;
    }

    /**
	 * Column Info
	 * @return sEacInpFmDt
	 */
    public String getSEacInpFmDt() {
        return this.sEacInpFmDt;
    }

    /**
	 * Column Info
	 * @return sKeyword
	 */
    public String getSKeyword() {
        return this.sKeyword;
    }

    /**
	 * Column Info
	 * @return n3ptySrcDt
	 */
    public String getN3ptySrcDt() {
        return this.n3ptySrcDt;
    }

    /**
	 * Column Info
	 * @return sEacBilTpCd
	 */
    public String getSEacBilTpCd() {
        return this.sEacBilTpCd;
    }

    /**
	 * Column Info
	 * @return n3ptyIfOfcFlg
	 */
    public String getN3ptyIfOfcFlg() {
        return this.n3ptyIfOfcFlg;
    }

    /**
	 * Column Info
	 * @return usrExistFlag
	 */
    public String getUsrExistFlag() {
        return this.usrExistFlag;
    }

    /**
	 * Column Info
	 * @return sEacExpnTpCd
	 */
    public String getSEacExpnTpCd() {
        return this.sEacExpnTpCd;
    }

    /**
	 * Column Info
	 * @return sOfcCd
	 */
    public String getSOfcCd() {
        return this.sOfcCd;
    }

    /**
	 * Column Info
	 * @return sVndrCustDivCd
	 */
    public String getSVndrCustDivCd() {
        return this.sVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @return disEacStsNm
	 */
    public String getDisEacStsNm() {
        return this.disEacStsNm;
    }

    /**
	 * Column Info
	 * @return sInvAudUsdAmt
	 */
    public String getSInvAudUsdAmt() {
        return this.sInvAudUsdAmt;
    }

    /**
	 * Column Info
	 * @return rhqOfcCd
	 */
    public String getRhqOfcCd() {
        return this.rhqOfcCd;
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
	 * @return eacStsCd
	 */
    public String getEacStsCd() {
        return this.eacStsCd;
    }

    /**
	 * Column Info
	 * @return sTpbDup
	 */
    public String getSTpbDup() {
        return this.sTpbDup;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return codeCd
	 */
    public String getCodeCd() {
        return this.codeCd;
    }

    /**
	 * Column Info
	 * @return val
	 */
    public String getVal() {
        return this.val;
    }

    /**
	 * Column Info
	 * @return sRhqOfcCd
	 */
    public String getSRhqOfcCd() {
        return this.sRhqOfcCd;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return offceLvl
	 */
    public String getOffceLvl() {
        return this.offceLvl;
    }

    /**
	 * Column Info
	 * @return aproUsrNm
	 */
    public String getAproUsrNm() {
        return this.aproUsrNm;
    }

    /**
	 * Column Info
	 * @return ofcExistFlag
	 */
    public String getOfcExistFlag() {
        return this.ofcExistFlag;
    }

    /**
	 * Column Info
	 * @return sEacDup
	 */
    public String getSEacDup() {
        return this.sEacDup;
    }

    /**
	 * Column Info
	 * @return rwAuthCd
	 */
    public String getRwAuthCd() {
        return this.rwAuthCd;
    }

    /**
	 * Column Info
	 * @return emlCtnt
	 */
    public String getEmlCtnt() {
        return this.emlCtnt;
    }

    /**
	 * Column Info
	 * @return eacAproRsn
	 */
    public String getEacAproRsn() {
        return this.eacAproRsn;
    }

    /**
	 * Column Info
	 * @return ntcCcRcvEml
	 */
    public String getNtcCcRcvEml() {
        return this.ntcCcRcvEml;
    }

    /**
	 * Column Info
	 * @return hqOfcUseFlg
	 */
    public String getHqOfcUseFlg() {
        return this.hqOfcUseFlg;
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
	 * @return eacType1
	 */
    public String getEacType1() {
        return this.eacType1;
    }

    /**
	 * Column Info
	 * @return ofclevel
	 */
    public String getOfclevel() {
        return this.ofclevel;
    }

    /**
	 * Column Info
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return n3ptyNo
	 */
    public String getN3ptyNo() {
        return this.n3ptyNo;
    }

    /**
	 * Column Info
	 * @return sCntCd
	 */
    public String getSCntCd() {
        return this.sCntCd;
    }

    /**
	 * Column Info
	 * @return usdLoclXchRt
	 */
    public String getUsdLoclXchRt() {
        return this.usdLoclXchRt;
    }

    /**
	 * Column Info
	 * @return codeNm
	 */
    public String getCodeNm() {
        return this.codeNm;
    }

    /**
	 * Column Info
	 * @return codeKey
	 */
    public String getCodeKey() {
        return this.codeKey;
    }

    /**
	 * Column Info
	 * @return kpiOfcCd
	 */
    public String getKpiOfcCd() {
        return this.kpiOfcCd;
    }

    /**
	 * Column Info
	 * @return sEacStsCd
	 */
    public String getSEacStsCd() {
        return this.sEacStsCd;
    }

    /**
	 * Column Info
	 * @return cnt
	 */
    public String getCnt() {
        return this.cnt;
    }

    /**
	 * Column Info
	 * @return sEacYrmonTo
	 */
    public String getSEacYrmonTo() {
        return this.sEacYrmonTo;
    }

    /**
	 * Column Info
	 * @return sEacYrmonFm
	 */
    public String getSEacYrmonFm() {
        return this.sEacYrmonFm;
    }

    /**
	 * Column Info
	 * @return disEacStsCd
	 */
    public String getDisEacStsCd() {
        return this.disEacStsCd;
    }

    /**
	 * Column Info
	 * @return eacSysIfCd
	 */
    public String getEacSysIfCd() {
        return this.eacSysIfCd;
    }

    /**
	 * Column Info
	 * @return sVndrSeq
	 */
    public String getSVndrSeq() {
        return this.sVndrSeq;
    }

    /**
	 * Column Info
	 * @return eacExpnTpCd
	 */
    public String getEacExpnTpCd() {
        return this.eacExpnTpCd;
    }

    /**
	 * Column Info
	 * @return sEacTpCd
	 */
    public String getSEacTpCd() {
        return this.sEacTpCd;
    }

    /**
	 * Column Info
	 * @return eacNo
	 */
    public String getEacNo() {
        return this.eacNo;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 * Column Info
	 * @return sEacRegUsrId
	 */
    public String getSEacRegUsrId() {
        return this.sEacRegUsrId;
    }

    /**
	 * Column Info
	 * @return bilCurrCd1
	 */
    public String getBilCurrCd1() {
        return this.bilCurrCd1;
    }

    /**
	 * Column Info
	 * @return respbOfcCd
	 */
    public String getRespbOfcCd() {
        return this.respbOfcCd;
    }

    /**
	 * Column Info
	 * @return emlSubjCtnt
	 */
    public String getEmlSubjCtnt() {
        return this.emlSubjCtnt;
    }

    /**
	 * Column Info
	 * @return sEacInpToDt
	 */
    public String getSEacInpToDt() {
        return this.sEacInpToDt;
    }

    /**
	 * Column Info
	 * @return n3ptySrcNo
	 */
    public String getN3ptySrcNo() {
        return this.n3ptySrcNo;
    }

    /**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
    public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
        this.n3ptyExpnTpCd = n3ptyExpnTpCd;
    }

    /**
	 * Column Info
	 * @param isflag
	 */
    public void setIsflag(String isflag) {
        this.isflag = isflag;
    }

    /**
	 * Column Info
	 * @param vndrCntcPntNm
	 */
    public void setVndrCntcPntNm(String vndrCntcPntNm) {
        this.vndrCntcPntNm = vndrCntcPntNm;
    }

    /**
	 * Column Info
	 * @param sTrdPartyVal
	 */
    public void setSTrdPartyVal(String sTrdPartyVal) {
        this.sTrdPartyVal = sTrdPartyVal;
    }

    /**
	 * Column Info
	 * @param sEacYrmon
	 */
    public void setSEacYrmon(String sEacYrmon) {
        this.sEacYrmon = sEacYrmon;
    }

    /**
	 * Column Info
	 * @param ofcTpCd
	 */
    public void setOfcTpCd(String ofcTpCd) {
        this.ofcTpCd = ofcTpCd;
    }

    /**
	 * Column Info
	 * @param gVndrSeq
	 */
    public void setGVndrSeq(String gVndrSeq) {
        this.gVndrSeq = gVndrSeq;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param bilCurrCd
	 */
    public void setBilCurrCd(String bilCurrCd) {
        this.bilCurrCd = bilCurrCd;
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
	 * @param vndrNm
	 */
    public void setVndrNm(String vndrNm) {
        this.vndrNm = vndrNm;
    }

    /**
	 * Column Info
	 * @param usrOfcCd
	 */
    public void setUsrOfcCd(String usrOfcCd) {
        this.usrOfcCd = usrOfcCd;
    }

    /**
	 * Column Info
	 * @param vndrCntcPntSeq
	 */
    public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
        this.vndrCntcPntSeq = vndrCntcPntSeq;
    }

    /**
	 * Column Info
	 * @param sortkey
	 */
    public void setSortkey(String sortkey) {
        this.sortkey = sortkey;
    }

    /**
	 * Column Info
	 * @param cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * Column Info
	 * @param contactPointExists
	 */
    public void setContactPointExists(String contactPointExists) {
        this.contactPointExists = contactPointExists;
    }

    /**
	 * Column Info
	 * @param usrEml
	 */
    public void setUsrEml(String usrEml) {
        this.usrEml = usrEml;
    }

    /**
	 * Column Info
	 * @param sEacInpFmDt
	 */
    public void setSEacInpFmDt(String sEacInpFmDt) {
        this.sEacInpFmDt = sEacInpFmDt;
    }

    /**
	 * Column Info
	 * @param sKeyword
	 */
    public void setSKeyword(String sKeyword) {
        this.sKeyword = sKeyword;
    }

    /**
	 * Column Info
	 * @param n3ptySrcDt
	 */
    public void setN3ptySrcDt(String n3ptySrcDt) {
        this.n3ptySrcDt = n3ptySrcDt;
    }

    /**
	 * Column Info
	 * @param sEacBilTpCd
	 */
    public void setSEacBilTpCd(String sEacBilTpCd) {
        this.sEacBilTpCd = sEacBilTpCd;
    }

    /**
	 * Column Info
	 * @param n3ptyIfOfcFlg
	 */
    public void setN3ptyIfOfcFlg(String n3ptyIfOfcFlg) {
        this.n3ptyIfOfcFlg = n3ptyIfOfcFlg;
    }

    /**
	 * Column Info
	 * @param usrExistFlag
	 */
    public void setUsrExistFlag(String usrExistFlag) {
        this.usrExistFlag = usrExistFlag;
    }

    /**
	 * Column Info
	 * @param sEacExpnTpCd
	 */
    public void setSEacExpnTpCd(String sEacExpnTpCd) {
        this.sEacExpnTpCd = sEacExpnTpCd;
    }

    /**
	 * Column Info
	 * @param sOfcCd
	 */
    public void setSOfcCd(String sOfcCd) {
        this.sOfcCd = sOfcCd;
    }

    /**
	 * Column Info
	 * @param sVndrCustDivCd
	 */
    public void setSVndrCustDivCd(String sVndrCustDivCd) {
        this.sVndrCustDivCd = sVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @param disEacStsNm
	 */
    public void setDisEacStsNm(String disEacStsNm) {
        this.disEacStsNm = disEacStsNm;
    }

    /**
	 * Column Info
	 * @param sInvAudUsdAmt
	 */
    public void setSInvAudUsdAmt(String sInvAudUsdAmt) {
        this.sInvAudUsdAmt = sInvAudUsdAmt;
    }

    /**
	 * Column Info
	 * @param rhqOfcCd
	 */
    public void setRhqOfcCd(String rhqOfcCd) {
        this.rhqOfcCd = rhqOfcCd;
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
	 * @param eacStsCd
	 */
    public void setEacStsCd(String eacStsCd) {
        this.eacStsCd = eacStsCd;
    }

    /**
	 * Column Info
	 * @param sTpbDup
	 */
    public void setSTpbDup(String sTpbDup) {
        this.sTpbDup = sTpbDup;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param codeCd
	 */
    public void setCodeCd(String codeCd) {
        this.codeCd = codeCd;
    }

    /**
	 * Column Info
	 * @param val
	 */
    public void setVal(String val) {
        this.val = val;
    }

    /**
	 * Column Info
	 * @param sRhqOfcCd
	 */
    public void setSRhqOfcCd(String sRhqOfcCd) {
        this.sRhqOfcCd = sRhqOfcCd;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param offceLvl
	 */
    public void setOffceLvl(String offceLvl) {
        this.offceLvl = offceLvl;
    }

    /**
	 * Column Info
	 * @param aproUsrNm
	 */
    public void setAproUsrNm(String aproUsrNm) {
        this.aproUsrNm = aproUsrNm;
    }

    /**
	 * Column Info
	 * @param ofcExistFlag
	 */
    public void setOfcExistFlag(String ofcExistFlag) {
        this.ofcExistFlag = ofcExistFlag;
    }

    /**
	 * Column Info
	 * @param sEacDup
	 */
    public void setSEacDup(String sEacDup) {
        this.sEacDup = sEacDup;
    }

    /**
	 * Column Info
	 * @param rwAuthCd
	 */
    public void setRwAuthCd(String rwAuthCd) {
        this.rwAuthCd = rwAuthCd;
    }

    /**
	 * Column Info
	 * @param emlCtnt
	 */
    public void setEmlCtnt(String emlCtnt) {
        this.emlCtnt = emlCtnt;
    }

    /**
	 * Column Info
	 * @param eacAproRsn
	 */
    public void setEacAproRsn(String eacAproRsn) {
        this.eacAproRsn = eacAproRsn;
    }

    /**
	 * Column Info
	 * @param ntcCcRcvEml
	 */
    public void setNtcCcRcvEml(String ntcCcRcvEml) {
        this.ntcCcRcvEml = ntcCcRcvEml;
    }

    /**
	 * Column Info
	 * @param hqOfcUseFlg
	 */
    public void setHqOfcUseFlg(String hqOfcUseFlg) {
        this.hqOfcUseFlg = hqOfcUseFlg;
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
	 * @param eacType1
	 */
    public void setEacType1(String eacType1) {
        this.eacType1 = eacType1;
    }

    /**
	 * Column Info
	 * @param ofclevel
	 */
    public void setOfclevel(String ofclevel) {
        this.ofclevel = ofclevel;
    }

    /**
	 * Column Info
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param n3ptyNo
	 */
    public void setN3ptyNo(String n3ptyNo) {
        this.n3ptyNo = n3ptyNo;
    }

    /**
	 * Column Info
	 * @param sCntCd
	 */
    public void setSCntCd(String sCntCd) {
        this.sCntCd = sCntCd;
    }

    /**
	 * Column Info
	 * @param usdLoclXchRt
	 */
    public void setUsdLoclXchRt(String usdLoclXchRt) {
        this.usdLoclXchRt = usdLoclXchRt;
    }

    /**
	 * Column Info
	 * @param codeNm
	 */
    public void setCodeNm(String codeNm) {
        this.codeNm = codeNm;
    }

    /**
	 * Column Info
	 * @param codeKey
	 */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    /**
	 * Column Info
	 * @param kpiOfcCd
	 */
    public void setKpiOfcCd(String kpiOfcCd) {
        this.kpiOfcCd = kpiOfcCd;
    }

    /**
	 * Column Info
	 * @param sEacStsCd
	 */
    public void setSEacStsCd(String sEacStsCd) {
        this.sEacStsCd = sEacStsCd;
    }

    /**
	 * Column Info
	 * @param cnt
	 */
    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    /**
	 * Column Info
	 * @param sEacYrmonTo
	 */
    public void setSEacYrmonTo(String sEacYrmonTo) {
        this.sEacYrmonTo = sEacYrmonTo;
    }

    /**
	 * Column Info
	 * @param sEacYrmonFm
	 */
    public void setSEacYrmonFm(String sEacYrmonFm) {
        this.sEacYrmonFm = sEacYrmonFm;
    }

    /**
	 * Column Info
	 * @param disEacStsCd
	 */
    public void setDisEacStsCd(String disEacStsCd) {
        this.disEacStsCd = disEacStsCd;
    }

    /**
	 * Column Info
	 * @param eacSysIfCd
	 */
    public void setEacSysIfCd(String eacSysIfCd) {
        this.eacSysIfCd = eacSysIfCd;
    }

    /**
	 * Column Info
	 * @param sVndrSeq
	 */
    public void setSVndrSeq(String sVndrSeq) {
        this.sVndrSeq = sVndrSeq;
    }

    /**
	 * Column Info
	 * @param eacExpnTpCd
	 */
    public void setEacExpnTpCd(String eacExpnTpCd) {
        this.eacExpnTpCd = eacExpnTpCd;
    }

    /**
	 * Column Info
	 * @param sEacTpCd
	 */
    public void setSEacTpCd(String sEacTpCd) {
        this.sEacTpCd = sEacTpCd;
    }

    /**
	 * Column Info
	 * @param eacNo
	 */
    public void setEacNo(String eacNo) {
        this.eacNo = eacNo;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * @param sEacRegUsrId
	 */
    public void setSEacRegUsrId(String sEacRegUsrId) {
        this.sEacRegUsrId = sEacRegUsrId;
    }

    /**
	 * Column Info
	 * @param bilCurrCd1
	 */
    public void setBilCurrCd1(String bilCurrCd1) {
        this.bilCurrCd1 = bilCurrCd1;
    }

    /**
	 * Column Info
	 * @param respbOfcCd
	 */
    public void setRespbOfcCd(String respbOfcCd) {
        this.respbOfcCd = respbOfcCd;
    }

    /**
	 * Column Info
	 * @param emlSubjCtnt
	 */
    public void setEmlSubjCtnt(String emlSubjCtnt) {
        this.emlSubjCtnt = emlSubjCtnt;
    }

    /**
	 * Column Info
	 * @param sEacInpToDt
	 */
    public void setSEacInpToDt(String sEacInpToDt) {
        this.sEacInpToDt = sEacInpToDt;
    }

    /**
	 * Column Info
	 * @param n3ptySrcNo
	 */
    public void setN3ptySrcNo(String n3ptySrcNo) {
        this.n3ptySrcNo = n3ptySrcNo;
    }

    public void setExpnAudRsltInvAudDiffAmt(String expnAudRsltInvAudDiffAmt) {
        this.expnAudRsltInvAudDiffAmt = expnAudRsltInvAudDiffAmt;
    }

    public String getExpnAudRsltInvAudDiffAmt() {
        return this.expnAudRsltInvAudDiffAmt;
    }

    public void setInvCfmDt(String invCfmDt) {
        this.invCfmDt = invCfmDt;
    }

    public String getInvCfmDt() {
        return this.invCfmDt;
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
        setN3ptyExpnTpCd(JSPUtil.getParameter(request, prefix + "n3pty_expn_tp_cd", ""));
        setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
        setVndrCntcPntNm(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_nm", ""));
        setSTrdPartyVal(JSPUtil.getParameter(request, prefix + "s_trd_party_val", ""));
        setSEacYrmon(JSPUtil.getParameter(request, prefix + "s_eac_yrmon", ""));
        setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
        setGVndrSeq(JSPUtil.getParameter(request, prefix + "g_vndr_seq", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
        setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
        setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
        setSortkey(JSPUtil.getParameter(request, prefix + "sortkey", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setContactPointExists(JSPUtil.getParameter(request, prefix + "contact_point_exists", ""));
        setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
        setSEacInpFmDt(JSPUtil.getParameter(request, prefix + "s_eac_inp_fm_dt", ""));
        setSKeyword(JSPUtil.getParameter(request, prefix + "s_keyword", ""));
        setN3ptySrcDt(JSPUtil.getParameter(request, prefix + "n3pty_src_dt", ""));
        setSEacBilTpCd(JSPUtil.getParameter(request, prefix + "s_eac_bil_tp_cd", ""));
        setN3ptyIfOfcFlg(JSPUtil.getParameter(request, prefix + "n3pty_if_ofc_flg", ""));
        setUsrExistFlag(JSPUtil.getParameter(request, prefix + "usr_exist_flag", ""));
        setSEacExpnTpCd(JSPUtil.getParameter(request, prefix + "s_eac_expn_tp_cd", ""));
        setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
        setSVndrCustDivCd(JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", ""));
        setDisEacStsNm(JSPUtil.getParameter(request, prefix + "dis_eac_sts_nm", ""));
        setSInvAudUsdAmt(JSPUtil.getParameter(request, prefix + "s_inv_aud_usd_amt", ""));
        setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setEacStsCd(JSPUtil.getParameter(request, prefix + "eac_sts_cd", ""));
        setSTpbDup(JSPUtil.getParameter(request, prefix + "s_tpb_dup", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setCodeCd(JSPUtil.getParameter(request, prefix + "code_cd", ""));
        setVal(JSPUtil.getParameter(request, prefix + "val", ""));
        setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setOffceLvl(JSPUtil.getParameter(request, prefix + "offce_lvl", ""));
        setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
        setOfcExistFlag(JSPUtil.getParameter(request, prefix + "ofc_exist_flag", ""));
        setSEacDup(JSPUtil.getParameter(request, prefix + "s_eac_dup", ""));
        setRwAuthCd(JSPUtil.getParameter(request, prefix + "rw_auth_cd", ""));
        setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
        setEacAproRsn(JSPUtil.getParameter(request, prefix + "eac_apro_rsn", ""));
        setNtcCcRcvEml(JSPUtil.getParameter(request, prefix + "ntc_cc_rcv_eml", ""));
        setHqOfcUseFlg(JSPUtil.getParameter(request, prefix + "hq_ofc_use_flg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setEacType1(JSPUtil.getParameter(request, prefix + "eac_type1", ""));
        setOfclevel(JSPUtil.getParameter(request, prefix + "ofclevel", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
        setSCntCd(JSPUtil.getParameter(request, prefix + "s_cnt_cd", ""));
        setUsdLoclXchRt(JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", ""));
        setCodeNm(JSPUtil.getParameter(request, prefix + "code_nm", ""));
        setCodeKey(JSPUtil.getParameter(request, prefix + "code_key", ""));
        setKpiOfcCd(JSPUtil.getParameter(request, prefix + "kpi_ofc_cd", ""));
        setSEacStsCd(JSPUtil.getParameter(request, prefix + "s_eac_sts_cd", ""));
        setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
        setSEacYrmonTo(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_to", ""));
        setSEacYrmonFm(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_fm", ""));
        setDisEacStsCd(JSPUtil.getParameter(request, prefix + "dis_eac_sts_cd", ""));
        setEacSysIfCd(JSPUtil.getParameter(request, prefix + "eac_sys_if_cd", ""));
        setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
        setEacExpnTpCd(JSPUtil.getParameter(request, prefix + "eac_expn_tp_cd", ""));
        setSEacTpCd(JSPUtil.getParameter(request, prefix + "s_eac_tp_cd", ""));
        setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setSEacRegUsrId(JSPUtil.getParameter(request, prefix + "s_eac_reg_usr_id", ""));
        setBilCurrCd1(JSPUtil.getParameter(request, prefix + "bil_curr_cd1", ""));
        setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
        setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
        setSEacInpToDt(JSPUtil.getParameter(request, prefix + "s_eac_inp_to_dt", ""));
        setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
        setExpnAudRsltInvAudDiffAmt(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_inv_aud_diff_amt", ""));
        setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EacSearchVO[]
	 */
    public EacSearchVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EacSearchVO[]
	 */
    public EacSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EacSearchVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix + "n3pty_expn_tp_cd", length));
            String[] isflag = (JSPUtil.getParameter(request, prefix + "isflag", length));
            String[] vndrCntcPntNm = (JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_nm", length));
            String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix + "s_trd_party_val", length));
            String[] sEacYrmon = (JSPUtil.getParameter(request, prefix + "s_eac_yrmon", length));
            String[] ofcTpCd = (JSPUtil.getParameter(request, prefix + "ofc_tp_cd", length));
            String[] gVndrSeq = (JSPUtil.getParameter(request, prefix + "g_vndr_seq", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] bilCurrCd = (JSPUtil.getParameter(request, prefix + "bil_curr_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
            String[] usrOfcCd = (JSPUtil.getParameter(request, prefix + "usr_ofc_cd", length));
            String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", length));
            String[] sortkey = (JSPUtil.getParameter(request, prefix + "sortkey", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] contactPointExists = (JSPUtil.getParameter(request, prefix + "contact_point_exists", length));
            String[] usrEml = (JSPUtil.getParameter(request, prefix + "usr_eml", length));
            String[] sEacInpFmDt = (JSPUtil.getParameter(request, prefix + "s_eac_inp_fm_dt", length));
            String[] sKeyword = (JSPUtil.getParameter(request, prefix + "s_keyword", length));
            String[] n3ptySrcDt = (JSPUtil.getParameter(request, prefix + "n3pty_src_dt", length));
            String[] sEacBilTpCd = (JSPUtil.getParameter(request, prefix + "s_eac_bil_tp_cd", length));
            String[] n3ptyIfOfcFlg = (JSPUtil.getParameter(request, prefix + "n3pty_if_ofc_flg", length));
            String[] usrExistFlag = (JSPUtil.getParameter(request, prefix + "usr_exist_flag", length));
            String[] sEacExpnTpCd = (JSPUtil.getParameter(request, prefix + "s_eac_expn_tp_cd", length));
            String[] sOfcCd = (JSPUtil.getParameter(request, prefix + "s_ofc_cd", length));
            String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", length));
            String[] disEacStsNm = (JSPUtil.getParameter(request, prefix + "dis_eac_sts_nm", length));
            String[] sInvAudUsdAmt = (JSPUtil.getParameter(request, prefix + "s_inv_aud_usd_amt", length));
            String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] eacStsCd = (JSPUtil.getParameter(request, prefix + "eac_sts_cd", length));
            String[] sTpbDup = (JSPUtil.getParameter(request, prefix + "s_tpb_dup", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] codeCd = (JSPUtil.getParameter(request, prefix + "code_cd", length));
            String[] val = (JSPUtil.getParameter(request, prefix + "val", length));
            String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] offceLvl = (JSPUtil.getParameter(request, prefix + "offce_lvl", length));
            String[] aproUsrNm = (JSPUtil.getParameter(request, prefix + "apro_usr_nm", length));
            String[] ofcExistFlag = (JSPUtil.getParameter(request, prefix + "ofc_exist_flag", length));
            String[] sEacDup = (JSPUtil.getParameter(request, prefix + "s_eac_dup", length));
            String[] rwAuthCd = (JSPUtil.getParameter(request, prefix + "rw_auth_cd", length));
            String[] emlCtnt = (JSPUtil.getParameter(request, prefix + "eml_ctnt", length));
            String[] eacAproRsn = (JSPUtil.getParameter(request, prefix + "eac_apro_rsn", length));
            String[] ntcCcRcvEml = (JSPUtil.getParameter(request, prefix + "ntc_cc_rcv_eml", length));
            String[] hqOfcUseFlg = (JSPUtil.getParameter(request, prefix + "hq_ofc_use_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] eacType1 = (JSPUtil.getParameter(request, prefix + "eac_type1", length));
            String[] ofclevel = (JSPUtil.getParameter(request, prefix + "ofclevel", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] n3ptyNo = (JSPUtil.getParameter(request, prefix + "n3pty_no", length));
            String[] sCntCd = (JSPUtil.getParameter(request, prefix + "s_cnt_cd", length));
            String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", length));
            String[] codeNm = (JSPUtil.getParameter(request, prefix + "code_nm", length));
            String[] codeKey = (JSPUtil.getParameter(request, prefix + "code_key", length));
            String[] kpiOfcCd = (JSPUtil.getParameter(request, prefix + "kpi_ofc_cd", length));
            String[] sEacStsCd = (JSPUtil.getParameter(request, prefix + "s_eac_sts_cd", length));
            String[] cnt = (JSPUtil.getParameter(request, prefix + "cnt", length));
            String[] sEacYrmonTo = (JSPUtil.getParameter(request, prefix + "s_eac_yrmon_to", length));
            String[] sEacYrmonFm = (JSPUtil.getParameter(request, prefix + "s_eac_yrmon_fm", length));
            String[] disEacStsCd = (JSPUtil.getParameter(request, prefix + "dis_eac_sts_cd", length));
            String[] eacSysIfCd = (JSPUtil.getParameter(request, prefix + "eac_sys_if_cd", length));
            String[] sVndrSeq = (JSPUtil.getParameter(request, prefix + "s_vndr_seq", length));
            String[] eacExpnTpCd = (JSPUtil.getParameter(request, prefix + "eac_expn_tp_cd", length));
            String[] sEacTpCd = (JSPUtil.getParameter(request, prefix + "s_eac_tp_cd", length));
            String[] eacNo = (JSPUtil.getParameter(request, prefix + "eac_no", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] sEacRegUsrId = (JSPUtil.getParameter(request, prefix + "s_eac_reg_usr_id", length));
            String[] bilCurrCd1 = (JSPUtil.getParameter(request, prefix + "bil_curr_cd1", length));
            String[] respbOfcCd = (JSPUtil.getParameter(request, prefix + "respb_ofc_cd", length));
            String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", length));
            String[] sEacInpToDt = (JSPUtil.getParameter(request, prefix + "s_eac_inp_to_dt", length));
            String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix + "n3pty_src_no", length));
            String[] expnAudRsltInvAudDiffAmt = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_inv_aud_diff_amt", length));
            String[] invCfmDt = (JSPUtil.getParameter(request, prefix + "inv_cfm_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new EacSearchVO();
                if (n3ptyExpnTpCd[i] != null)
                    model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
                if (isflag[i] != null)
                    model.setIsflag(isflag[i]);
                if (vndrCntcPntNm[i] != null)
                    model.setVndrCntcPntNm(vndrCntcPntNm[i]);
                if (sTrdPartyVal[i] != null)
                    model.setSTrdPartyVal(sTrdPartyVal[i]);
                if (sEacYrmon[i] != null)
                    model.setSEacYrmon(sEacYrmon[i]);
                if (ofcTpCd[i] != null)
                    model.setOfcTpCd(ofcTpCd[i]);
                if (gVndrSeq[i] != null)
                    model.setGVndrSeq(gVndrSeq[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (bilCurrCd[i] != null)
                    model.setBilCurrCd(bilCurrCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (usrOfcCd[i] != null)
                    model.setUsrOfcCd(usrOfcCd[i]);
                if (vndrCntcPntSeq[i] != null)
                    model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
                if (sortkey[i] != null)
                    model.setSortkey(sortkey[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (contactPointExists[i] != null)
                    model.setContactPointExists(contactPointExists[i]);
                if (usrEml[i] != null)
                    model.setUsrEml(usrEml[i]);
                if (sEacInpFmDt[i] != null)
                    model.setSEacInpFmDt(sEacInpFmDt[i]);
                if (sKeyword[i] != null)
                    model.setSKeyword(sKeyword[i]);
                if (n3ptySrcDt[i] != null)
                    model.setN3ptySrcDt(n3ptySrcDt[i]);
                if (sEacBilTpCd[i] != null)
                    model.setSEacBilTpCd(sEacBilTpCd[i]);
                if (n3ptyIfOfcFlg[i] != null)
                    model.setN3ptyIfOfcFlg(n3ptyIfOfcFlg[i]);
                if (usrExistFlag[i] != null)
                    model.setUsrExistFlag(usrExistFlag[i]);
                if (sEacExpnTpCd[i] != null)
                    model.setSEacExpnTpCd(sEacExpnTpCd[i]);
                if (sOfcCd[i] != null)
                    model.setSOfcCd(sOfcCd[i]);
                if (sVndrCustDivCd[i] != null)
                    model.setSVndrCustDivCd(sVndrCustDivCd[i]);
                if (disEacStsNm[i] != null)
                    model.setDisEacStsNm(disEacStsNm[i]);
                if (sInvAudUsdAmt[i] != null)
                    model.setSInvAudUsdAmt(sInvAudUsdAmt[i]);
                if (rhqOfcCd[i] != null)
                    model.setRhqOfcCd(rhqOfcCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (eacStsCd[i] != null)
                    model.setEacStsCd(eacStsCd[i]);
                if (sTpbDup[i] != null)
                    model.setSTpbDup(sTpbDup[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (codeCd[i] != null)
                    model.setCodeCd(codeCd[i]);
                if (val[i] != null)
                    model.setVal(val[i]);
                if (sRhqOfcCd[i] != null)
                    model.setSRhqOfcCd(sRhqOfcCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (offceLvl[i] != null)
                    model.setOffceLvl(offceLvl[i]);
                if (aproUsrNm[i] != null)
                    model.setAproUsrNm(aproUsrNm[i]);
                if (ofcExistFlag[i] != null)
                    model.setOfcExistFlag(ofcExistFlag[i]);
                if (sEacDup[i] != null)
                    model.setSEacDup(sEacDup[i]);
                if (rwAuthCd[i] != null)
                    model.setRwAuthCd(rwAuthCd[i]);
                if (emlCtnt[i] != null)
                    model.setEmlCtnt(emlCtnt[i]);
                if (eacAproRsn[i] != null)
                    model.setEacAproRsn(eacAproRsn[i]);
                if (ntcCcRcvEml[i] != null)
                    model.setNtcCcRcvEml(ntcCcRcvEml[i]);
                if (hqOfcUseFlg[i] != null)
                    model.setHqOfcUseFlg(hqOfcUseFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (eacType1[i] != null)
                    model.setEacType1(eacType1[i]);
                if (ofclevel[i] != null)
                    model.setOfclevel(ofclevel[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (n3ptyNo[i] != null)
                    model.setN3ptyNo(n3ptyNo[i]);
                if (sCntCd[i] != null)
                    model.setSCntCd(sCntCd[i]);
                if (usdLoclXchRt[i] != null)
                    model.setUsdLoclXchRt(usdLoclXchRt[i]);
                if (codeNm[i] != null)
                    model.setCodeNm(codeNm[i]);
                if (codeKey[i] != null)
                    model.setCodeKey(codeKey[i]);
                if (kpiOfcCd[i] != null)
                    model.setKpiOfcCd(kpiOfcCd[i]);
                if (sEacStsCd[i] != null)
                    model.setSEacStsCd(sEacStsCd[i]);
                if (cnt[i] != null)
                    model.setCnt(cnt[i]);
                if (sEacYrmonTo[i] != null)
                    model.setSEacYrmonTo(sEacYrmonTo[i]);
                if (sEacYrmonFm[i] != null)
                    model.setSEacYrmonFm(sEacYrmonFm[i]);
                if (disEacStsCd[i] != null)
                    model.setDisEacStsCd(disEacStsCd[i]);
                if (eacSysIfCd[i] != null)
                    model.setEacSysIfCd(eacSysIfCd[i]);
                if (sVndrSeq[i] != null)
                    model.setSVndrSeq(sVndrSeq[i]);
                if (eacExpnTpCd[i] != null)
                    model.setEacExpnTpCd(eacExpnTpCd[i]);
                if (sEacTpCd[i] != null)
                    model.setSEacTpCd(sEacTpCd[i]);
                if (eacNo[i] != null)
                    model.setEacNo(eacNo[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (sEacRegUsrId[i] != null)
                    model.setSEacRegUsrId(sEacRegUsrId[i]);
                if (bilCurrCd1[i] != null)
                    model.setBilCurrCd1(bilCurrCd1[i]);
                if (respbOfcCd[i] != null)
                    model.setRespbOfcCd(respbOfcCd[i]);
                if (emlSubjCtnt[i] != null)
                    model.setEmlSubjCtnt(emlSubjCtnt[i]);
                if (sEacInpToDt[i] != null)
                    model.setSEacInpToDt(sEacInpToDt[i]);
                if (n3ptySrcNo[i] != null)
                    model.setN3ptySrcNo(n3ptySrcNo[i]);
                if (n3ptySrcNo[i] != null)
                    model.setExpnAudRsltInvAudDiffAmt(expnAudRsltInvAudDiffAmt[i]);
                if (invCfmDt[i] != null) 
		    		model.setInvCfmDt(invCfmDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEacSearchVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return EacSearchVO[]
	 */
    public EacSearchVO[] getEacSearchVOs() {
        EacSearchVO[] vos = (EacSearchVO[]) models.toArray(new EacSearchVO[models.size()]);
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
        this.n3ptyExpnTpCd = this.n3ptyExpnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isflag = this.isflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntcPntNm = this.vndrCntcPntNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrdPartyVal = this.sTrdPartyVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacYrmon = this.sEacYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcTpCd = this.ofcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gVndrSeq = this.gVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilCurrCd = this.bilCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrOfcCd = this.usrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntcPntSeq = this.vndrCntcPntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sortkey = this.sortkey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contactPointExists = this.contactPointExists.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrEml = this.usrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacInpFmDt = this.sEacInpFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sKeyword = this.sKeyword.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptySrcDt = this.n3ptySrcDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacBilTpCd = this.sEacBilTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyIfOfcFlg = this.n3ptyIfOfcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrExistFlag = this.usrExistFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacExpnTpCd = this.sEacExpnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOfcCd = this.sOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrCustDivCd = this.sVndrCustDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.disEacStsNm = this.disEacStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sInvAudUsdAmt = this.sInvAudUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfcCd = this.rhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacStsCd = this.eacStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTpbDup = this.sTpbDup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codeCd = this.codeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.val = this.val.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sRhqOfcCd = this.sRhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.offceLvl = this.offceLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproUsrNm = this.aproUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcExistFlag = this.ofcExistFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacDup = this.sEacDup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rwAuthCd = this.rwAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlCtnt = this.emlCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacAproRsn = this.eacAproRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntcCcRcvEml = this.ntcCcRcvEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hqOfcUseFlg = this.hqOfcUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacType1 = this.eacType1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofclevel = this.ofclevel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyNo = this.n3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCntCd = this.sCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdLoclXchRt = this.usdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codeNm = this.codeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codeKey = this.codeKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kpiOfcCd = this.kpiOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacStsCd = this.sEacStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnt = this.cnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacYrmonTo = this.sEacYrmonTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacYrmonFm = this.sEacYrmonFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.disEacStsCd = this.disEacStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacSysIfCd = this.eacSysIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrSeq = this.sVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacExpnTpCd = this.eacExpnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacTpCd = this.sEacTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacNo = this.eacNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacRegUsrId = this.sEacRegUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilCurrCd1 = this.bilCurrCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.respbOfcCd = this.respbOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSubjCtnt = this.emlSubjCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEacInpToDt = this.sEacInpToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptySrcNo = this.n3ptySrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltInvAudDiffAmt = this.expnAudRsltInvAudDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCfmDt = this.invCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
