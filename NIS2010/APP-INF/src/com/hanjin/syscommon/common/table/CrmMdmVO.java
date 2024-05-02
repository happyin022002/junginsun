/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CrmMdmVO.java
*@FileTitle : CrmMdmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.table;

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
public class CrmMdmVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CrmMdmVO> models = new ArrayList<CrmMdmVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String rvisCntrCustTpCd = null;

    /* Column Info */
    private String nvoccLicNo = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String rfAcctFlg = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String nvoccBdEndEffDt = null;

    /* Column Info */
    private String msgEtt = null;

    /* Column Info */
    private String srcSysCd = null;

    /* Column Info */
    private String msgCreDt = null;

    /* Column Info */
    private String prfSvcDtlDesc = null;

    /* Column Info */
    private String nvoccHjsScacCd = null;

    /* Column Info */
    private String mltTrdAcctFlg = null;

    /* Column Info */
    private String otiOrzNo = null;

    /* Column Info */
    private String ptyAddr = null;

    /* Column Info */
    private String parObjRowId = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String bkgAlertEnd = null;

    /* Column Info */
    private String custRgstNo = null;

    /* Column Info */
    private String custUrl = null;

    /* Column Info */
    private String ctsNo = null;

    /* Column Info */
    private String ctyNm = null;

    /* Column Info */
    private String intlMnPhnNo = null;

    /* Column Info */
    private String crntVolKnt = null;

    /* Column Info */
    private String prfGrpCmdtCd = null;

    /* Column Info */
    private String custStsCd = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String custGrpCd = null;

    /* Column Info */
    private String addrRowId = null;

    /* Column Info */
    private String grpIndivDiv = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String bkgAlertDate = null;

    /* Column Info */
    private String opCd = null;

    /* Column Info */
    private String custEml = null;

    /* Column Info */
    private String userKey = null;

    /* Column Info */
    private String custRowId = null;

    /* Column Info */
    private String frtFwrdFmcNo = null;

    /* Column Info */
    private String nvoccBdStrtEffDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String rgnAcctFlg = null;

    /* Column Info */
    private String bkgAlert = null;

    /* Column Info */
    private String objRowId = null;

    /* Column Info */
    private String fullMnFaxNo = null;

    /* Column Info */
    private String gloAcctFlg = null;

    /* Column Info */
    private String custRmk = null;

    /* Column Info */
    private String prfSvcDesc = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String intlMnFaxNo = null;

    /* Column Info */
    private String cpetiDesc = null;

    /* Column Info */
    private String nvoccBdAmt = null;

    /* Column Info */
    private String keyAcctMgrGloUsrId = null;

    /* Column Info */
    private String nvoccBdNo = null;

    /* Column Info */
    private String bkgAlertCreated = null;

    /* Column Info */
    private String mstOfcId = null;

    /* Column Info */
    private String prfRepreCmdtCd = null;

    /* Column Info */
    private String bkgAlertStart = null;

    /* Column Info */
    private String newKeyAcctFlg = null;

    /* Column Info */
    private String addrTpCd = null;

    /* Column Info */
    private String fullMnPhnNo = null;

    /* Column Info */
    private String keyAcctMgrGloUsrNm = null;

    /* Column Info */
    private String spclReqDesc = null;

    /* Column Info */
    private String addrRelRowId = null;

    /* Column Info */
    private String keyAcctFlg = null;

    /* Column Info */
    private String prfCntrTpszCd = null;

    /* Column Info */
    private String keyAcctStrtEffDt = null;

    /* Column Info */
    private String bkgAlertMess = null;

    /* Column Info */
    private String stsCd = null;

    /* Column Info */
    private String msgId = null;

    /* Column Info */
    private String custTeam = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String custRHQ = null;

    /* Column Info */
    private String namedBIZ = null;

    /* Column Info */
    private String msgTypeName = null;

    /* Column Info */
    private String msgTypeCode = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CrmMdmVO() {
    }

    public CrmMdmVO(String ibflag, String pagerows, String custLglEngNm, String rvisCntrCustTpCd, String nvoccLicNo, String steCd, String rfAcctFlg, String custCd, String nvoccBdEndEffDt, String msgEtt, String srcSysCd, String msgCreDt, String prfSvcDtlDesc, String nvoccHjsScacCd, String mltTrdAcctFlg, String otiOrzNo, String ptyAddr, String parObjRowId, String updUsrId, String bkgAlertEnd, String custRgstNo, String custUrl, String ctsNo, String ctyNm, String intlMnPhnNo, String crntVolKnt, String prfGrpCmdtCd, String custStsCd, String cntCd, String custGrpCd, String addrRowId, String grpIndivDiv, String locCd, String bkgAlertDate, String opCd, String custEml, String userKey, String custRowId, String frtFwrdFmcNo, String nvoccBdStrtEffDt, String creUsrId, String rgnAcctFlg, String bkgAlert, String objRowId, String fullMnFaxNo, String gloAcctFlg, String custRmk, String prfSvcDesc, String srepCd, String intlMnFaxNo, String cpetiDesc, String nvoccBdAmt, String keyAcctMgrGloUsrId, String nvoccBdNo, String bkgAlertCreated, String mstOfcId, String prfRepreCmdtCd, String bkgAlertStart, String newKeyAcctFlg, String addrTpCd, String fullMnPhnNo, String keyAcctMgrGloUsrNm, String spclReqDesc, String addrRelRowId, String keyAcctFlg, String prfCntrTpszCd, String keyAcctStrtEffDt, String bkgAlertMess, String stsCd, String msgId, String custTeam, String zipCd, String custRHQ, String namedBIZ, String msgTypeName, String msgTypeCode, String prmryChkFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.custLglEngNm = custLglEngNm;
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
        this.nvoccLicNo = nvoccLicNo;
        this.steCd = steCd;
        this.rfAcctFlg = rfAcctFlg;
        this.custCd = custCd;
        this.nvoccBdEndEffDt = nvoccBdEndEffDt;
        this.msgEtt = msgEtt;
        this.srcSysCd = srcSysCd;
        this.msgCreDt = msgCreDt;
        this.prfSvcDtlDesc = prfSvcDtlDesc;
        this.nvoccHjsScacCd = nvoccHjsScacCd;
        this.mltTrdAcctFlg = mltTrdAcctFlg;
        this.otiOrzNo = otiOrzNo;
        this.ptyAddr = ptyAddr;
        this.parObjRowId = parObjRowId;
        this.updUsrId = updUsrId;
        this.bkgAlertEnd = bkgAlertEnd;
        this.custRgstNo = custRgstNo;
        this.custUrl = custUrl;
        this.ctsNo = ctsNo;
        this.ctyNm = ctyNm;
        this.intlMnPhnNo = intlMnPhnNo;
        this.crntVolKnt = crntVolKnt;
        this.prfGrpCmdtCd = prfGrpCmdtCd;
        this.custStsCd = custStsCd;
        this.cntCd = cntCd;
        this.custGrpCd = custGrpCd;
        this.addrRowId = addrRowId;
        this.grpIndivDiv = grpIndivDiv;
        this.locCd = locCd;
        this.bkgAlertDate = bkgAlertDate;
        this.opCd = opCd;
        this.custEml = custEml;
        this.userKey = userKey;
        this.custRowId = custRowId;
        this.frtFwrdFmcNo = frtFwrdFmcNo;
        this.nvoccBdStrtEffDt = nvoccBdStrtEffDt;
        this.creUsrId = creUsrId;
        this.rgnAcctFlg = rgnAcctFlg;
        this.bkgAlert = bkgAlert;
        this.objRowId = objRowId;
        this.fullMnFaxNo = fullMnFaxNo;
        this.gloAcctFlg = gloAcctFlg;
        this.custRmk = custRmk;
        this.prfSvcDesc = prfSvcDesc;
        this.srepCd = srepCd;
        this.intlMnFaxNo = intlMnFaxNo;
        this.cpetiDesc = cpetiDesc;
        this.nvoccBdAmt = nvoccBdAmt;
        this.keyAcctMgrGloUsrId = keyAcctMgrGloUsrId;
        this.nvoccBdNo = nvoccBdNo;
        this.bkgAlertCreated = bkgAlertCreated;
        this.mstOfcId = mstOfcId;
        this.prfRepreCmdtCd = prfRepreCmdtCd;
        this.bkgAlertStart = bkgAlertStart;
        this.newKeyAcctFlg = newKeyAcctFlg;
        this.addrTpCd = addrTpCd;
        this.fullMnPhnNo = fullMnPhnNo;
        this.keyAcctMgrGloUsrNm = keyAcctMgrGloUsrNm;
        this.spclReqDesc = spclReqDesc;
        this.addrRelRowId = addrRelRowId;
        this.keyAcctFlg = keyAcctFlg;
        this.prfCntrTpszCd = prfCntrTpszCd;
        this.keyAcctStrtEffDt = keyAcctStrtEffDt;
        this.bkgAlertMess = bkgAlertMess;
        this.stsCd = stsCd;
        this.msgId = msgId;
        this.custTeam = custTeam;
        this.zipCd = zipCd;
        this.custRHQ = custRHQ;
        this.namedBIZ = namedBIZ;
        this.msgTypeName = msgTypeName;
        this.msgTypeCode = msgTypeCode;
        this.prmryChkFlg = prmryChkFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
        this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("rf_acct_flg", getRfAcctFlg());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("nvocc_bd_end_eff_dt", getNvoccBdEndEffDt());
        this.hashColumns.put("msg_ett", getMsgEtt());
        this.hashColumns.put("src_sys_cd", getSrcSysCd());
        this.hashColumns.put("msg_cre_dt", getMsgCreDt());
        this.hashColumns.put("prf_svc_dtl_desc", getPrfSvcDtlDesc());
        this.hashColumns.put("nvocc_hjs_scac_cd", getNvoccHjsScacCd());
        this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
        this.hashColumns.put("oti_orz_no", getOtiOrzNo());
        this.hashColumns.put("pty_addr", getPtyAddr());
        this.hashColumns.put("par_obj_row_id", getParObjRowId());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("bkg_alert_end", getBkgAlertEnd());
        this.hashColumns.put("cust_rgst_no", getCustRgstNo());
        this.hashColumns.put("cust_url", getCustUrl());
        this.hashColumns.put("cts_no", getCtsNo());
        this.hashColumns.put("cty_nm", getCtyNm());
        this.hashColumns.put("intl_mn_phn_no", getIntlMnPhnNo());
        this.hashColumns.put("crnt_vol_knt", getCrntVolKnt());
        this.hashColumns.put("prf_grp_cmdt_cd", getPrfGrpCmdtCd());
        this.hashColumns.put("cust_sts_cd", getCustStsCd());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("cust_grp_cd", getCustGrpCd());
        this.hashColumns.put("addr_row_id", getAddrRowId());
        this.hashColumns.put("grp_indiv_div", getGrpIndivDiv());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("bkg_alert_date", getBkgAlertDate());
        this.hashColumns.put("op_cd", getOpCd());
        this.hashColumns.put("cust_eml", getCustEml());
        this.hashColumns.put("user_key", getUserKey());
        this.hashColumns.put("cust_row_id", getCustRowId());
        this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
        this.hashColumns.put("nvocc_bd_strt_eff_dt", getNvoccBdStrtEffDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
        this.hashColumns.put("bkg_alert", getBkgAlert());
        this.hashColumns.put("obj_row_id", getObjRowId());
        this.hashColumns.put("full_mn_fax_no", getFullMnFaxNo());
        this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
        this.hashColumns.put("cust_rmk", getCustRmk());
        this.hashColumns.put("prf_svc_desc", getPrfSvcDesc());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("intl_mn_fax_no", getIntlMnFaxNo());
        this.hashColumns.put("cpeti_desc", getCpetiDesc());
        this.hashColumns.put("nvocc_bd_amt", getNvoccBdAmt());
        this.hashColumns.put("key_acct_mgr_glo_usr_id", getKeyAcctMgrGloUsrId());
        this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
        this.hashColumns.put("bkg_alert_created", getBkgAlertCreated());
        this.hashColumns.put("mst_ofc_id", getMstOfcId());
        this.hashColumns.put("prf_repre_cmdt_cd", getPrfRepreCmdtCd());
        this.hashColumns.put("bkg_alert_start", getBkgAlertStart());
        this.hashColumns.put("new_key_acct_flg", getNewKeyAcctFlg());
        this.hashColumns.put("addr_tp_cd", getAddrTpCd());
        this.hashColumns.put("full_mn_phn_no", getFullMnPhnNo());
        this.hashColumns.put("key_acct_mgr_glo_usr_nm", getKeyAcctMgrGloUsrNm());
        this.hashColumns.put("spcl_req_desc", getSpclReqDesc());
        this.hashColumns.put("addr_rel_row_id", getAddrRelRowId());
        this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
        this.hashColumns.put("prf_cntr_tpsz_cd", getPrfCntrTpszCd());
        this.hashColumns.put("key_acct_strt_eff_dt", getKeyAcctStrtEffDt());
        this.hashColumns.put("bkg_alert_mess", getBkgAlertMess());
        this.hashColumns.put("sts_cd", getStsCd());
        this.hashColumns.put("msg_id", getMsgId());
        this.hashColumns.put("cust_team", getCustTeam());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("cust_rhq", getCustRHQ());
        this.hashColumns.put("named_BIZ", getNamedBIZ());
        this.hashColumns.put("msg_type_name", getMsgTypeName());
        this.hashColumns.put("msg_type_code", getMsgTypeCode());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
        this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("rf_acct_flg", "rfAcctFlg");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("nvocc_bd_end_eff_dt", "nvoccBdEndEffDt");
        this.hashFields.put("msg_ett", "msgEtt");
        this.hashFields.put("src_sys_cd", "srcSysCd");
        this.hashFields.put("msg_cre_dt", "msgCreDt");
        this.hashFields.put("prf_svc_dtl_desc", "prfSvcDtlDesc");
        this.hashFields.put("nvocc_hjs_scac_cd", "nvoccHjsScacCd");
        this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
        this.hashFields.put("oti_orz_no", "otiOrzNo");
        this.hashFields.put("pty_addr", "ptyAddr");
        this.hashFields.put("par_obj_row_id", "parObjRowId");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("bkg_alert_end", "bkgAlertEnd");
        this.hashFields.put("cust_rgst_no", "custRgstNo");
        this.hashFields.put("cust_url", "custUrl");
        this.hashFields.put("cts_no", "ctsNo");
        this.hashFields.put("cty_nm", "ctyNm");
        this.hashFields.put("intl_mn_phn_no", "intlMnPhnNo");
        this.hashFields.put("crnt_vol_knt", "crntVolKnt");
        this.hashFields.put("prf_grp_cmdt_cd", "prfGrpCmdtCd");
        this.hashFields.put("cust_sts_cd", "custStsCd");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("cust_grp_cd", "custGrpCd");
        this.hashFields.put("addr_row_id", "addrRowId");
        this.hashFields.put("grp_indiv_div", "grpIndivDiv");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("bkg_alert_date", "bkgAlertDate");
        this.hashFields.put("op_cd", "opCd");
        this.hashFields.put("cust_eml", "custEml");
        this.hashFields.put("user_key", "userKey");
        this.hashFields.put("cust_row_id", "custRowId");
        this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
        this.hashFields.put("nvocc_bd_strt_eff_dt", "nvoccBdStrtEffDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
        this.hashFields.put("bkg_alert", "bkgAlert");
        this.hashFields.put("obj_row_id", "objRowId");
        this.hashFields.put("full_mn_fax_no", "fullMnFaxNo");
        this.hashFields.put("glo_acct_flg", "gloAcctFlg");
        this.hashFields.put("cust_rmk", "custRmk");
        this.hashFields.put("prf_svc_desc", "prfSvcDesc");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("intl_mn_fax_no", "intlMnFaxNo");
        this.hashFields.put("cpeti_desc", "cpetiDesc");
        this.hashFields.put("nvocc_bd_amt", "nvoccBdAmt");
        this.hashFields.put("key_acct_mgr_glo_usr_id", "keyAcctMgrGloUsrId");
        this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
        this.hashFields.put("bkg_alert_created", "bkgAlertCreated");
        this.hashFields.put("mst_ofc_id", "mstOfcId");
        this.hashFields.put("prf_repre_cmdt_cd", "prfRepreCmdtCd");
        this.hashFields.put("bkg_alert_start", "bkgAlertStart");
        this.hashFields.put("new_key_acct_flg", "newKeyAcctFlg");
        this.hashFields.put("addr_tp_cd", "addrTpCd");
        this.hashFields.put("full_mn_phn_no", "fullMnPhnNo");
        this.hashFields.put("key_acct_mgr_glo_usr_nm", "keyAcctMgrGloUsrNm");
        this.hashFields.put("spcl_req_desc", "spclReqDesc");
        this.hashFields.put("addr_rel_row_id", "addrRelRowId");
        this.hashFields.put("key_acct_flg", "keyAcctFlg");
        this.hashFields.put("prf_cntr_tpsz_cd", "prfCntrTpszCd");
        this.hashFields.put("key_acct_strt_eff_dt", "keyAcctStrtEffDt");
        this.hashFields.put("bkg_alert_mess", "bkgAlertMess");
        this.hashFields.put("sts_cd", "stsCd");
        this.hashFields.put("msg_id", "msgId");
        this.hashFields.put("cust_team", "custTeam");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cust_rhq", "custRHQ");
        this.hashFields.put("named_BIZ", "namedBIZ");
        this.hashFields.put("msg_type_name", "msgTypeName");
        this.hashFields.put("msg_type_code", "msgTypeCode");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
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
	 * @param String custLglEngNm
	 */
    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    /**
	 * 
	 * @return String custLglEngNm
	 */
    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    /**
	 *
	 * @param String rvisCntrCustTpCd
	 */
    public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
    }

    /**
	 * 
	 * @return String rvisCntrCustTpCd
	 */
    public String getRvisCntrCustTpCd() {
        return this.rvisCntrCustTpCd;
    }

    /**
	 *
	 * @param String nvoccLicNo
	 */
    public void setNvoccLicNo(String nvoccLicNo) {
        this.nvoccLicNo = nvoccLicNo;
    }

    /**
	 * 
	 * @return String nvoccLicNo
	 */
    public String getNvoccLicNo() {
        return this.nvoccLicNo;
    }

    /**
	 *
	 * @param String steCd
	 */
    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    /**
	 * 
	 * @return String steCd
	 */
    public String getSteCd() {
        return this.steCd;
    }

    /**
	 *
	 * @param String rfAcctFlg
	 */
    public void setRfAcctFlg(String rfAcctFlg) {
        this.rfAcctFlg = rfAcctFlg;
    }

    /**
	 * 
	 * @return String rfAcctFlg
	 */
    public String getRfAcctFlg() {
        return this.rfAcctFlg;
    }

    /**
	 *
	 * @param String custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /**
	 * 
	 * @return String custCd
	 */
    public String getCustCd() {
        return this.custCd;
    }

    /**
	 *
	 * @param String nvoccBdEndEffDt
	 */
    public void setNvoccBdEndEffDt(String nvoccBdEndEffDt) {
        this.nvoccBdEndEffDt = nvoccBdEndEffDt;
    }

    /**
	 * 
	 * @return String nvoccBdEndEffDt
	 */
    public String getNvoccBdEndEffDt() {
        return this.nvoccBdEndEffDt;
    }

    /**
	 *
	 * @param String msgEtt
	 */
    public void setMsgEtt(String msgEtt) {
        this.msgEtt = msgEtt;
    }

    /**
	 * 
	 * @return String msgEtt
	 */
    public String getMsgEtt() {
        return this.msgEtt;
    }

    /**
	 *
	 * @param String srcSysCd
	 */
    public void setSrcSysCd(String srcSysCd) {
        this.srcSysCd = srcSysCd;
    }

    /**
	 * 
	 * @return String srcSysCd
	 */
    public String getSrcSysCd() {
        return this.srcSysCd;
    }

    /**
	 *
	 * @param String msgCreDt
	 */
    public void setMsgCreDt(String msgCreDt) {
        this.msgCreDt = msgCreDt;
    }

    /**
	 * 
	 * @return String msgCreDt
	 */
    public String getMsgCreDt() {
        return this.msgCreDt;
    }

    /**
	 *
	 * @param String prfSvcDtlDesc
	 */
    public void setPrfSvcDtlDesc(String prfSvcDtlDesc) {
        this.prfSvcDtlDesc = prfSvcDtlDesc;
    }

    /**
	 * 
	 * @return String prfSvcDtlDesc
	 */
    public String getPrfSvcDtlDesc() {
        return this.prfSvcDtlDesc;
    }

    /**
	 *
	 * @param String nvoccHjsScacCd
	 */
    public void setNvoccHjsScacCd(String nvoccHjsScacCd) {
        this.nvoccHjsScacCd = nvoccHjsScacCd;
    }

    /**
	 * 
	 * @return String nvoccHjsScacCd
	 */
    public String getNvoccHjsScacCd() {
        return this.nvoccHjsScacCd;
    }

    /**
	 *
	 * @param String mltTrdAcctFlg
	 */
    public void setMltTrdAcctFlg(String mltTrdAcctFlg) {
        this.mltTrdAcctFlg = mltTrdAcctFlg;
    }

    /**
	 * 
	 * @return String mltTrdAcctFlg
	 */
    public String getMltTrdAcctFlg() {
        return this.mltTrdAcctFlg;
    }

    /**
	 *
	 * @param String otiOrzNo
	 */
    public void setOtiOrzNo(String otiOrzNo) {
        this.otiOrzNo = otiOrzNo;
    }

    /**
	 * 
	 * @return String otiOrzNo
	 */
    public String getOtiOrzNo() {
        return this.otiOrzNo;
    }

    /**
	 *
	 * @param String ptyAddr
	 */
    public void setPtyAddr(String ptyAddr) {
        this.ptyAddr = ptyAddr;
    }

    /**
	 * 
	 * @return String ptyAddr
	 */
    public String getPtyAddr() {
        return this.ptyAddr;
    }

    /**
	 *
	 * @param String parObjRowId
	 */
    public void setParObjRowId(String parObjRowId) {
        this.parObjRowId = parObjRowId;
    }

    /**
	 * 
	 * @return String parObjRowId
	 */
    public String getParObjRowId() {
        return this.parObjRowId;
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
	 * @param String bkgAlertEnd
	 */
    public void setBkgAlertEnd(String bkgAlertEnd) {
        this.bkgAlertEnd = bkgAlertEnd;
    }

    /**
	 * 
	 * @return String bkgAlertEnd
	 */
    public String getBkgAlertEnd() {
        return this.bkgAlertEnd;
    }

    /**
	 *
	 * @param String custRgstNo
	 */
    public void setCustRgstNo(String custRgstNo) {
        this.custRgstNo = custRgstNo;
    }

    /**
	 * 
	 * @return String custRgstNo
	 */
    public String getCustRgstNo() {
        return this.custRgstNo;
    }

    /**
	 *
	 * @param String custUrl
	 */
    public void setCustUrl(String custUrl) {
        this.custUrl = custUrl;
    }

    /**
	 * 
	 * @return String custUrl
	 */
    public String getCustUrl() {
        return this.custUrl;
    }

    /**
	 *
	 * @param String ctsNo
	 */
    public void setCtsNo(String ctsNo) {
        this.ctsNo = ctsNo;
    }

    /**
	 * 
	 * @return String ctsNo
	 */
    public String getCtsNo() {
        return this.ctsNo;
    }

    /**
	 *
	 * @param String ctyNm
	 */
    public void setCtyNm(String ctyNm) {
        this.ctyNm = ctyNm;
    }

    /**
	 * 
	 * @return String ctyNm
	 */
    public String getCtyNm() {
        return this.ctyNm;
    }

    /**
	 *
	 * @param String intlMnPhnNo
	 */
    public void setIntlMnPhnNo(String intlMnPhnNo) {
        this.intlMnPhnNo = intlMnPhnNo;
    }

    /**
	 * 
	 * @return String intlMnPhnNo
	 */
    public String getIntlMnPhnNo() {
        return this.intlMnPhnNo;
    }

    /**
	 *
	 * @param String crntVolKnt
	 */
    public void setCrntVolKnt(String crntVolKnt) {
        this.crntVolKnt = crntVolKnt;
    }

    /**
	 * 
	 * @return String crntVolKnt
	 */
    public String getCrntVolKnt() {
        return this.crntVolKnt;
    }

    /**
	 *
	 * @param String prfGrpCmdtCd
	 */
    public void setPrfGrpCmdtCd(String prfGrpCmdtCd) {
        this.prfGrpCmdtCd = prfGrpCmdtCd;
    }

    /**
	 * 
	 * @return String prfGrpCmdtCd
	 */
    public String getPrfGrpCmdtCd() {
        return this.prfGrpCmdtCd;
    }

    /**
	 *
	 * @param String custStsCd
	 */
    public void setCustStsCd(String custStsCd) {
        this.custStsCd = custStsCd;
    }

    /**
	 * 
	 * @return String custStsCd
	 */
    public String getCustStsCd() {
        return this.custStsCd;
    }

    /**
	 *
	 * @param String cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * 
	 * @return String cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 *
	 * @param String custGrpCd
	 */
    public void setCustGrpCd(String custGrpCd) {
        this.custGrpCd = custGrpCd;
    }

    /**
	 * 
	 * @return String custGrpCd
	 */
    public String getCustGrpCd() {
        return this.custGrpCd;
    }

    /**
	 *
	 * @param String addrRowId
	 */
    public void setAddrRowId(String addrRowId) {
        this.addrRowId = addrRowId;
    }

    /**
	 * 
	 * @return String addrRowId
	 */
    public String getAddrRowId() {
        return this.addrRowId;
    }

    /**
	 *
	 * @param String grpIndivDiv
	 */
    public void setGrpIndivDiv(String grpIndivDiv) {
        this.grpIndivDiv = grpIndivDiv;
    }

    /**
	 * 
	 * @return String grpIndivDiv
	 */
    public String getGrpIndivDiv() {
        return this.grpIndivDiv;
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
	 * @param String bkgAlertDate
	 */
    public void setBkgAlertDate(String bkgAlertDate) {
        this.bkgAlertDate = bkgAlertDate;
    }

    /**
	 * 
	 * @return String bkgAlertDate
	 */
    public String getBkgAlertDate() {
        return this.bkgAlertDate;
    }

    /**
	 *
	 * @param String opCd
	 */
    public void setOpCd(String opCd) {
        this.opCd = opCd;
    }

    /**
	 * 
	 * @return String opCd
	 */
    public String getOpCd() {
        return this.opCd;
    }

    /**
	 *
	 * @param String custEml
	 */
    public void setCustEml(String custEml) {
        this.custEml = custEml;
    }

    /**
	 * 
	 * @return String custEml
	 */
    public String getCustEml() {
        return this.custEml;
    }

    /**
	 *
	 * @param String userKey
	 */
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    /**
	 * 
	 * @return String userKey
	 */
    public String getUserKey() {
        return this.userKey;
    }

    /**
	 *
	 * @param String custRowId
	 */
    public void setCustRowId(String custRowId) {
        this.custRowId = custRowId;
    }

    /**
	 * 
	 * @return String custRowId
	 */
    public String getCustRowId() {
        return this.custRowId;
    }

    /**
	 *
	 * @param String frtFwrdFmcNo
	 */
    public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
        this.frtFwrdFmcNo = frtFwrdFmcNo;
    }

    /**
	 * 
	 * @return String frtFwrdFmcNo
	 */
    public String getFrtFwrdFmcNo() {
        return this.frtFwrdFmcNo;
    }

    /**
	 *
	 * @param String nvoccBdStrtEffDt
	 */
    public void setNvoccBdStrtEffDt(String nvoccBdStrtEffDt) {
        this.nvoccBdStrtEffDt = nvoccBdStrtEffDt;
    }

    /**
	 * 
	 * @return String nvoccBdStrtEffDt
	 */
    public String getNvoccBdStrtEffDt() {
        return this.nvoccBdStrtEffDt;
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
	 * @param String rgnAcctFlg
	 */
    public void setRgnAcctFlg(String rgnAcctFlg) {
        this.rgnAcctFlg = rgnAcctFlg;
    }

    /**
	 * 
	 * @return String rgnAcctFlg
	 */
    public String getRgnAcctFlg() {
        return this.rgnAcctFlg;
    }

    /**
	 *
	 * @param String bkgAlert
	 */
    public void setBkgAlert(String bkgAlert) {
        this.bkgAlert = bkgAlert;
    }

    /**
	 * 
	 * @return String bkgAlert
	 */
    public String getBkgAlert() {
        return this.bkgAlert;
    }

    /**
	 *
	 * @param String objRowId
	 */
    public void setObjRowId(String objRowId) {
        this.objRowId = objRowId;
    }

    /**
	 * 
	 * @return String objRowId
	 */
    public String getObjRowId() {
        return this.objRowId;
    }

    /**
	 *
	 * @param String fullMnFaxNo
	 */
    public void setFullMnFaxNo(String fullMnFaxNo) {
        this.fullMnFaxNo = fullMnFaxNo;
    }

    /**
	 * 
	 * @return String fullMnFaxNo
	 */
    public String getFullMnFaxNo() {
        return this.fullMnFaxNo;
    }

    /**
	 *
	 * @param String gloAcctFlg
	 */
    public void setGloAcctFlg(String gloAcctFlg) {
        this.gloAcctFlg = gloAcctFlg;
    }

    /**
	 * 
	 * @return String gloAcctFlg
	 */
    public String getGloAcctFlg() {
        return this.gloAcctFlg;
    }

    /**
	 *
	 * @param String custRmk
	 */
    public void setCustRmk(String custRmk) {
        this.custRmk = custRmk;
    }

    /**
	 * 
	 * @return String custRmk
	 */
    public String getCustRmk() {
        return this.custRmk;
    }

    /**
	 *
	 * @param String prfSvcDesc
	 */
    public void setPrfSvcDesc(String prfSvcDesc) {
        this.prfSvcDesc = prfSvcDesc;
    }

    /**
	 * 
	 * @return String prfSvcDesc
	 */
    public String getPrfSvcDesc() {
        return this.prfSvcDesc;
    }

    /**
	 *
	 * @param String srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * 
	 * @return String srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 *
	 * @param String intlMnFaxNo
	 */
    public void setIntlMnFaxNo(String intlMnFaxNo) {
        this.intlMnFaxNo = intlMnFaxNo;
    }

    /**
	 * 
	 * @return String intlMnFaxNo
	 */
    public String getIntlMnFaxNo() {
        return this.intlMnFaxNo;
    }

    /**
	 *
	 * @param String cpetiDesc
	 */
    public void setCpetiDesc(String cpetiDesc) {
        this.cpetiDesc = cpetiDesc;
    }

    /**
	 * 
	 * @return String cpetiDesc
	 */
    public String getCpetiDesc() {
        return this.cpetiDesc;
    }

    /**
	 *
	 * @param String nvoccBdAmt
	 */
    public void setNvoccBdAmt(String nvoccBdAmt) {
        this.nvoccBdAmt = nvoccBdAmt;
    }

    /**
	 * 
	 * @return String nvoccBdAmt
	 */
    public String getNvoccBdAmt() {
        return this.nvoccBdAmt;
    }

    /**
	 *
	 * @param String keyAcctMgrGloUsrId
	 */
    public void setKeyAcctMgrGloUsrId(String keyAcctMgrGloUsrId) {
        this.keyAcctMgrGloUsrId = keyAcctMgrGloUsrId;
    }

    /**
	 * 
	 * @return String keyAcctMgrGloUsrId
	 */
    public String getKeyAcctMgrGloUsrId() {
        return this.keyAcctMgrGloUsrId;
    }

    /**
	 *
	 * @param String nvoccBdNo
	 */
    public void setNvoccBdNo(String nvoccBdNo) {
        this.nvoccBdNo = nvoccBdNo;
    }

    /**
	 * 
	 * @return String nvoccBdNo
	 */
    public String getNvoccBdNo() {
        return this.nvoccBdNo;
    }

    /**
	 *
	 * @param String bkgAlertCreated
	 */
    public void setBkgAlertCreated(String bkgAlertCreated) {
        this.bkgAlertCreated = bkgAlertCreated;
    }

    /**
	 * 
	 * @return String bkgAlertCreated
	 */
    public String getBkgAlertCreated() {
        return this.bkgAlertCreated;
    }

    /**
	 *
	 * @param String mstOfcId
	 */
    public void setMstOfcId(String mstOfcId) {
        this.mstOfcId = mstOfcId;
    }

    /**
	 * 
	 * @return String mstOfcId
	 */
    public String getMstOfcId() {
        return this.mstOfcId;
    }

    /**
	 *
	 * @param String prfRepreCmdtCd
	 */
    public void setPrfRepreCmdtCd(String prfRepreCmdtCd) {
        this.prfRepreCmdtCd = prfRepreCmdtCd;
    }

    /**
	 * 
	 * @return String prfRepreCmdtCd
	 */
    public String getPrfRepreCmdtCd() {
        return this.prfRepreCmdtCd;
    }

    /**
	 *
	 * @param String bkgAlertStart
	 */
    public void setBkgAlertStart(String bkgAlertStart) {
        this.bkgAlertStart = bkgAlertStart;
    }

    /**
	 * 
	 * @return String bkgAlertStart
	 */
    public String getBkgAlertStart() {
        return this.bkgAlertStart;
    }

    /**
	 *
	 * @param String newKeyAcctFlg
	 */
    public void setNewKeyAcctFlg(String newKeyAcctFlg) {
        this.newKeyAcctFlg = newKeyAcctFlg;
    }

    /**
	 * 
	 * @return String newKeyAcctFlg
	 */
    public String getNewKeyAcctFlg() {
        return this.newKeyAcctFlg;
    }

    /**
	 *
	 * @param String addrTpCd
	 */
    public void setAddrTpCd(String addrTpCd) {
        this.addrTpCd = addrTpCd;
    }

    /**
	 * 
	 * @return String addrTpCd
	 */
    public String getAddrTpCd() {
        return this.addrTpCd;
    }

    /**
	 *
	 * @param String fullMnPhnNo
	 */
    public void setFullMnPhnNo(String fullMnPhnNo) {
        this.fullMnPhnNo = fullMnPhnNo;
    }

    /**
	 * 
	 * @return String fullMnPhnNo
	 */
    public String getFullMnPhnNo() {
        return this.fullMnPhnNo;
    }

    /**
	 *
	 * @param String keyAcctMgrGloUsrNm
	 */
    public void setKeyAcctMgrGloUsrNm(String keyAcctMgrGloUsrNm) {
        this.keyAcctMgrGloUsrNm = keyAcctMgrGloUsrNm;
    }

    /**
	 * 
	 * @return String keyAcctMgrGloUsrNm
	 */
    public String getKeyAcctMgrGloUsrNm() {
        return this.keyAcctMgrGloUsrNm;
    }

    /**
	 *
	 * @param String spclReqDesc
	 */
    public void setSpclReqDesc(String spclReqDesc) {
        this.spclReqDesc = spclReqDesc;
    }

    /**
	 * 
	 * @return String spclReqDesc
	 */
    public String getSpclReqDesc() {
        return this.spclReqDesc;
    }

    /**
	 *
	 * @param String addrRelRowId
	 */
    public void setAddrRelRowId(String addrRelRowId) {
        this.addrRelRowId = addrRelRowId;
    }

    /**
	 * 
	 * @return String addrRelRowId
	 */
    public String getAddrRelRowId() {
        return this.addrRelRowId;
    }

    /**
	 *
	 * @param String keyAcctFlg
	 */
    public void setKeyAcctFlg(String keyAcctFlg) {
        this.keyAcctFlg = keyAcctFlg;
    }

    /**
	 * 
	 * @return String keyAcctFlg
	 */
    public String getKeyAcctFlg() {
        return this.keyAcctFlg;
    }

    /**
	 *
	 * @param String prfCntrTpszCd
	 */
    public void setPrfCntrTpszCd(String prfCntrTpszCd) {
        this.prfCntrTpszCd = prfCntrTpszCd;
    }

    /**
	 * 
	 * @return String prfCntrTpszCd
	 */
    public String getPrfCntrTpszCd() {
        return this.prfCntrTpszCd;
    }

    /**
	 *
	 * @param String keyAcctStrtEffDt
	 */
    public void setKeyAcctStrtEffDt(String keyAcctStrtEffDt) {
        this.keyAcctStrtEffDt = keyAcctStrtEffDt;
    }

    /**
	 * 
	 * @return String keyAcctStrtEffDt
	 */
    public String getKeyAcctStrtEffDt() {
        return this.keyAcctStrtEffDt;
    }

    /**
	 *
	 * @param String bkgAlertMess
	 */
    public void setBkgAlertMess(String bkgAlertMess) {
        this.bkgAlertMess = bkgAlertMess;
    }

    /**
	 * 
	 * @return String bkgAlertMess
	 */
    public String getBkgAlertMess() {
        return this.bkgAlertMess;
    }

    /**
	 *
	 * @param String stsCd
	 */
    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    /**
	 * 
	 * @return String stsCd
	 */
    public String getStsCd() {
        return this.stsCd;
    }

    /**
	 *
	 * @param String msgId
	 */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
	 * 
	 * @return String msgId
	 */
    public String getMsgId() {
        return this.msgId;
    }

    /**
	 *
	 * @param String custTeam
	 */
    public void setCustTeam(String custTeam) {
        this.custTeam = custTeam;
    }

    /**
	 * 
	 * @return String custTeam
	 */
    public String getCustTeam() {
        return this.custTeam;
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

    public void setCustRHQ(String custRHQ) {
        this.custRHQ = custRHQ;
    }

    public String getCustRHQ() {
        return this.custRHQ;
    }

    public void setNamedBIZ(String namedBIZ) {
        this.namedBIZ = namedBIZ;
    }

    public String getNamedBIZ() {
        return this.namedBIZ;
    }

    public void setMsgTypeName(String msgTypeName) {
        this.msgTypeName = msgTypeName;
    }

    public String getMsgTypeName() {
        return this.msgTypeName;
    }

    public void setMsgTypeCode(String msgTypeCode) {
        this.msgTypeCode = msgTypeCode;
    }

    public String getMsgTypeCode() {
        return this.msgTypeCode;
    }

    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
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
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
        setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setRfAcctFlg(JSPUtil.getParameter(request, prefix + "rf_acct_flg", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setNvoccBdEndEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", ""));
        setMsgEtt(JSPUtil.getParameter(request, prefix + "msg_ett", ""));
        setSrcSysCd(JSPUtil.getParameter(request, prefix + "src_sys_cd", ""));
        setMsgCreDt(JSPUtil.getParameter(request, prefix + "msg_cre_dt", ""));
        setPrfSvcDtlDesc(JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", ""));
        setNvoccHjsScacCd(JSPUtil.getParameter(request, prefix + "nvocc_hjs_scac_cd", ""));
        setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
        setOtiOrzNo(JSPUtil.getParameter(request, prefix + "oti_orz_no", ""));
        setPtyAddr(JSPUtil.getParameter(request, prefix + "pty_addr", ""));
        setParObjRowId(JSPUtil.getParameter(request, prefix + "par_obj_row_id", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setBkgAlertEnd(JSPUtil.getParameter(request, prefix + "bkg_alert_end", ""));
        setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
        setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
        setCtsNo(JSPUtil.getParameter(request, prefix + "cts_no", ""));
        setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
        setIntlMnPhnNo(JSPUtil.getParameter(request, prefix + "intl_mn_phn_no", ""));
        setCrntVolKnt(JSPUtil.getParameter(request, prefix + "crnt_vol_knt", ""));
        setPrfGrpCmdtCd(JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", ""));
        setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setCustGrpCd(JSPUtil.getParameter(request, prefix + "cust_grp_cd", ""));
        setAddrRowId(JSPUtil.getParameter(request, prefix + "addr_row_id", ""));
        setGrpIndivDiv(JSPUtil.getParameter(request, prefix + "grp_indiv_div", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setBkgAlertDate(JSPUtil.getParameter(request, prefix + "bkg_alert_date", ""));
        setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
        setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
        setUserKey(JSPUtil.getParameter(request, prefix + "user_key", ""));
        setCustRowId(JSPUtil.getParameter(request, prefix + "cust_row_id", ""));
        setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
        setNvoccBdStrtEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_strt_eff_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
        setBkgAlert(JSPUtil.getParameter(request, prefix + "bkg_alert", ""));
        setObjRowId(JSPUtil.getParameter(request, prefix + "obj_row_id", ""));
        setFullMnFaxNo(JSPUtil.getParameter(request, prefix + "full_mn_fax_no", ""));
        setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
        setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
        setPrfSvcDesc(JSPUtil.getParameter(request, prefix + "prf_svc_desc", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setIntlMnFaxNo(JSPUtil.getParameter(request, prefix + "intl_mn_fax_no", ""));
        setCpetiDesc(JSPUtil.getParameter(request, prefix + "cpeti_desc", ""));
        setNvoccBdAmt(JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", ""));
        setKeyAcctMgrGloUsrId(JSPUtil.getParameter(request, prefix + "key_acct_mgr_glo_usr_id", ""));
        setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
        setBkgAlertCreated(JSPUtil.getParameter(request, prefix + "bkg_alert_created", ""));
        setMstOfcId(JSPUtil.getParameter(request, prefix + "mst_ofc_id", ""));
        setPrfRepreCmdtCd(JSPUtil.getParameter(request, prefix + "prf_repre_cmdt_cd", ""));
        setBkgAlertStart(JSPUtil.getParameter(request, prefix + "bkg_alert_start", ""));
        setNewKeyAcctFlg(JSPUtil.getParameter(request, prefix + "new_key_acct_flg", ""));
        setAddrTpCd(JSPUtil.getParameter(request, prefix + "addr_tp_cd", ""));
        setFullMnPhnNo(JSPUtil.getParameter(request, prefix + "full_mn_phn_no", ""));
        setKeyAcctMgrGloUsrNm(JSPUtil.getParameter(request, prefix + "key_acct_mgr_glo_usr_nm", ""));
        setSpclReqDesc(JSPUtil.getParameter(request, prefix + "spcl_req_desc", ""));
        setAddrRelRowId(JSPUtil.getParameter(request, prefix + "addr_rel_row_id", ""));
        setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
        setPrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", ""));
        setKeyAcctStrtEffDt(JSPUtil.getParameter(request, prefix + "key_acct_strt_eff_dt", ""));
        setBkgAlertMess(JSPUtil.getParameter(request, prefix + "bkg_alert_mess", ""));
        setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
        setMsgId(JSPUtil.getParameter(request, prefix + "msg_id", ""));
        setCustTeam(JSPUtil.getParameter(request, prefix + "cust_team", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setCustRHQ(JSPUtil.getParameter(request, prefix + "cust_rhq", ""));
        setNamedBIZ(JSPUtil.getParameter(request, prefix + "named_BIZ", ""));
        setMsgTypeName(JSPUtil.getParameter(request, prefix + "msg_type_name", ""));
        setMsgTypeCode(JSPUtil.getParameter(request, prefix + "msg_type_code", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CrmMdmVO[]
	 */
    public CrmMdmVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CrmMdmVO[]
	 */
    public CrmMdmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CrmMdmVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", length));
            String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix + "nvocc_lic_no", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] rfAcctFlg = (JSPUtil.getParameter(request, prefix + "rf_acct_flg", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] nvoccBdEndEffDt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", length));
            String[] msgEtt = (JSPUtil.getParameter(request, prefix + "msg_ett", length));
            String[] srcSysCd = (JSPUtil.getParameter(request, prefix + "src_sys_cd", length));
            String[] msgCreDt = (JSPUtil.getParameter(request, prefix + "msg_cre_dt", length));
            String[] prfSvcDtlDesc = (JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", length));
            String[] nvoccHjsScacCd = (JSPUtil.getParameter(request, prefix + "nvocc_hjs_scac_cd", length));
            String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", length));
            String[] otiOrzNo = (JSPUtil.getParameter(request, prefix + "oti_orz_no", length));
            String[] ptyAddr = (JSPUtil.getParameter(request, prefix + "pty_addr", length));
            String[] parObjRowId = (JSPUtil.getParameter(request, prefix + "par_obj_row_id", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] bkgAlertEnd = (JSPUtil.getParameter(request, prefix + "bkg_alert_end", length));
            String[] custRgstNo = (JSPUtil.getParameter(request, prefix + "cust_rgst_no", length));
            String[] custUrl = (JSPUtil.getParameter(request, prefix + "cust_url", length));
            String[] ctsNo = (JSPUtil.getParameter(request, prefix + "cts_no", length));
            String[] ctyNm = (JSPUtil.getParameter(request, prefix + "cty_nm", length));
            String[] intlMnPhnNo = (JSPUtil.getParameter(request, prefix + "intl_mn_phn_no", length));
            String[] crntVolKnt = (JSPUtil.getParameter(request, prefix + "crnt_vol_knt", length));
            String[] prfGrpCmdtCd = (JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", length));
            String[] custStsCd = (JSPUtil.getParameter(request, prefix + "cust_sts_cd", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] custGrpCd = (JSPUtil.getParameter(request, prefix + "cust_grp_cd", length));
            String[] addrRowId = (JSPUtil.getParameter(request, prefix + "addr_row_id", length));
            String[] grpIndivDiv = (JSPUtil.getParameter(request, prefix + "grp_indiv_div", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] bkgAlertDate = (JSPUtil.getParameter(request, prefix + "bkg_alert_date", length));
            String[] opCd = (JSPUtil.getParameter(request, prefix + "op_cd", length));
            String[] custEml = (JSPUtil.getParameter(request, prefix + "cust_eml", length));
            String[] userKey = (JSPUtil.getParameter(request, prefix + "user_key", length));
            String[] custRowId = (JSPUtil.getParameter(request, prefix + "cust_row_id", length));
            String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", length));
            String[] nvoccBdStrtEffDt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_strt_eff_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix + "rgn_acct_flg", length));
            String[] bkgAlert = (JSPUtil.getParameter(request, prefix + "bkg_alert", length));
            String[] objRowId = (JSPUtil.getParameter(request, prefix + "obj_row_id", length));
            String[] fullMnFaxNo = (JSPUtil.getParameter(request, prefix + "full_mn_fax_no", length));
            String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix + "glo_acct_flg", length));
            String[] custRmk = (JSPUtil.getParameter(request, prefix + "cust_rmk", length));
            String[] prfSvcDesc = (JSPUtil.getParameter(request, prefix + "prf_svc_desc", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] intlMnFaxNo = (JSPUtil.getParameter(request, prefix + "intl_mn_fax_no", length));
            String[] cpetiDesc = (JSPUtil.getParameter(request, prefix + "cpeti_desc", length));
            String[] nvoccBdAmt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", length));
            String[] keyAcctMgrGloUsrId = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_glo_usr_id", length));
            String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix + "nvocc_bd_no", length));
            String[] bkgAlertCreated = (JSPUtil.getParameter(request, prefix + "bkg_alert_created", length));
            String[] mstOfcId = (JSPUtil.getParameter(request, prefix + "mst_ofc_id", length));
            String[] prfRepreCmdtCd = (JSPUtil.getParameter(request, prefix + "prf_repre_cmdt_cd", length));
            String[] bkgAlertStart = (JSPUtil.getParameter(request, prefix + "bkg_alert_start", length));
            String[] newKeyAcctFlg = (JSPUtil.getParameter(request, prefix + "new_key_acct_flg", length));
            String[] addrTpCd = (JSPUtil.getParameter(request, prefix + "addr_tp_cd", length));
            String[] fullMnPhnNo = (JSPUtil.getParameter(request, prefix + "full_mn_phn_no", length));
            String[] keyAcctMgrGloUsrNm = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_glo_usr_nm", length));
            String[] spclReqDesc = (JSPUtil.getParameter(request, prefix + "spcl_req_desc", length));
            String[] addrRelRowId = (JSPUtil.getParameter(request, prefix + "addr_rel_row_id", length));
            String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix + "key_acct_flg", length));
            String[] prfCntrTpszCd = (JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", length));
            String[] keyAcctStrtEffDt = (JSPUtil.getParameter(request, prefix + "key_acct_strt_eff_dt", length));
            String[] bkgAlertMess = (JSPUtil.getParameter(request, prefix + "bkg_alert_mess", length));
            String[] stsCd = (JSPUtil.getParameter(request, prefix + "sts_cd", length));
            String[] msgId = (JSPUtil.getParameter(request, prefix + "msg_id", length));
            String[] custTeam = (JSPUtil.getParameter(request, prefix + "cust_team", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] custRHQ = (JSPUtil.getParameter(request, prefix + "cust_rhq", length));
            String[] namedBIZ = (JSPUtil.getParameter(request, prefix + "named_BIZ", length));
            String[] msgTypeName = (JSPUtil.getParameter(request, prefix + "msg_type_name", length));
            String[] msgTypeCode = (JSPUtil.getParameter(request, prefix + "msg_type_code", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CrmMdmVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (rvisCntrCustTpCd[i] != null)
                    model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
                if (nvoccLicNo[i] != null)
                    model.setNvoccLicNo(nvoccLicNo[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (rfAcctFlg[i] != null)
                    model.setRfAcctFlg(rfAcctFlg[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (nvoccBdEndEffDt[i] != null)
                    model.setNvoccBdEndEffDt(nvoccBdEndEffDt[i]);
                if (msgEtt[i] != null)
                    model.setMsgEtt(msgEtt[i]);
                if (srcSysCd[i] != null)
                    model.setSrcSysCd(srcSysCd[i]);
                if (msgCreDt[i] != null)
                    model.setMsgCreDt(msgCreDt[i]);
                if (prfSvcDtlDesc[i] != null)
                    model.setPrfSvcDtlDesc(prfSvcDtlDesc[i]);
                if (nvoccHjsScacCd[i] != null)
                    model.setNvoccHjsScacCd(nvoccHjsScacCd[i]);
                if (mltTrdAcctFlg[i] != null)
                    model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
                if (otiOrzNo[i] != null)
                    model.setOtiOrzNo(otiOrzNo[i]);
                if (ptyAddr[i] != null)
                    model.setPtyAddr(ptyAddr[i]);
                if (parObjRowId[i] != null)
                    model.setParObjRowId(parObjRowId[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (bkgAlertEnd[i] != null)
                    model.setBkgAlertEnd(bkgAlertEnd[i]);
                if (custRgstNo[i] != null)
                    model.setCustRgstNo(custRgstNo[i]);
                if (custUrl[i] != null)
                    model.setCustUrl(custUrl[i]);
                if (ctsNo[i] != null)
                    model.setCtsNo(ctsNo[i]);
                if (ctyNm[i] != null)
                    model.setCtyNm(ctyNm[i]);
                if (intlMnPhnNo[i] != null)
                    model.setIntlMnPhnNo(intlMnPhnNo[i]);
                if (crntVolKnt[i] != null)
                    model.setCrntVolKnt(crntVolKnt[i]);
                if (prfGrpCmdtCd[i] != null)
                    model.setPrfGrpCmdtCd(prfGrpCmdtCd[i]);
                if (custStsCd[i] != null)
                    model.setCustStsCd(custStsCd[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (custGrpCd[i] != null)
                    model.setCustGrpCd(custGrpCd[i]);
                if (addrRowId[i] != null)
                    model.setAddrRowId(addrRowId[i]);
                if (grpIndivDiv[i] != null)
                    model.setGrpIndivDiv(grpIndivDiv[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (bkgAlertDate[i] != null)
                    model.setBkgAlertDate(bkgAlertDate[i]);
                if (opCd[i] != null)
                    model.setOpCd(opCd[i]);
                if (custEml[i] != null)
                    model.setCustEml(custEml[i]);
                if (userKey[i] != null)
                    model.setUserKey(userKey[i]);
                if (custRowId[i] != null)
                    model.setCustRowId(custRowId[i]);
                if (frtFwrdFmcNo[i] != null)
                    model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
                if (nvoccBdStrtEffDt[i] != null)
                    model.setNvoccBdStrtEffDt(nvoccBdStrtEffDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (rgnAcctFlg[i] != null)
                    model.setRgnAcctFlg(rgnAcctFlg[i]);
                if (bkgAlert[i] != null)
                    model.setBkgAlert(bkgAlert[i]);
                if (objRowId[i] != null)
                    model.setObjRowId(objRowId[i]);
                if (fullMnFaxNo[i] != null)
                    model.setFullMnFaxNo(fullMnFaxNo[i]);
                if (gloAcctFlg[i] != null)
                    model.setGloAcctFlg(gloAcctFlg[i]);
                if (custRmk[i] != null)
                    model.setCustRmk(custRmk[i]);
                if (prfSvcDesc[i] != null)
                    model.setPrfSvcDesc(prfSvcDesc[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (intlMnFaxNo[i] != null)
                    model.setIntlMnFaxNo(intlMnFaxNo[i]);
                if (cpetiDesc[i] != null)
                    model.setCpetiDesc(cpetiDesc[i]);
                if (nvoccBdAmt[i] != null)
                    model.setNvoccBdAmt(nvoccBdAmt[i]);
                if (keyAcctMgrGloUsrId[i] != null)
                    model.setKeyAcctMgrGloUsrId(keyAcctMgrGloUsrId[i]);
                if (nvoccBdNo[i] != null)
                    model.setNvoccBdNo(nvoccBdNo[i]);
                if (bkgAlertCreated[i] != null)
                    model.setBkgAlertCreated(bkgAlertCreated[i]);
                if (mstOfcId[i] != null)
                    model.setMstOfcId(mstOfcId[i]);
                if (prfRepreCmdtCd[i] != null)
                    model.setPrfRepreCmdtCd(prfRepreCmdtCd[i]);
                if (bkgAlertStart[i] != null)
                    model.setBkgAlertStart(bkgAlertStart[i]);
                if (newKeyAcctFlg[i] != null)
                    model.setNewKeyAcctFlg(newKeyAcctFlg[i]);
                if (addrTpCd[i] != null)
                    model.setAddrTpCd(addrTpCd[i]);
                if (fullMnPhnNo[i] != null)
                    model.setFullMnPhnNo(fullMnPhnNo[i]);
                if (keyAcctMgrGloUsrNm[i] != null)
                    model.setKeyAcctMgrGloUsrNm(keyAcctMgrGloUsrNm[i]);
                if (spclReqDesc[i] != null)
                    model.setSpclReqDesc(spclReqDesc[i]);
                if (addrRelRowId[i] != null)
                    model.setAddrRelRowId(addrRelRowId[i]);
                if (keyAcctFlg[i] != null)
                    model.setKeyAcctFlg(keyAcctFlg[i]);
                if (prfCntrTpszCd[i] != null)
                    model.setPrfCntrTpszCd(prfCntrTpszCd[i]);
                if (keyAcctStrtEffDt[i] != null)
                    model.setKeyAcctStrtEffDt(keyAcctStrtEffDt[i]);
                if (bkgAlertMess[i] != null)
                    model.setBkgAlertMess(bkgAlertMess[i]);
                if (stsCd[i] != null)
                    model.setStsCd(stsCd[i]);
                if (msgId[i] != null)
                    model.setMsgId(msgId[i]);
                if (custTeam[i] != null)
                    model.setCustTeam(custTeam[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (custRHQ[i] != null)
                    model.setCustRHQ(custRHQ[i]);
                if (namedBIZ[i] != null)
                    model.setNamedBIZ(namedBIZ[i]);
                if (msgTypeName[i] != null)
                    model.setMsgTypeName(msgTypeName[i]);
                if (msgTypeCode[i] != null)
                    model.setMsgTypeCode(msgTypeCode[i]);
                if (prmryChkFlg[i] != null) 
		    		model.setPrmryChkFlg(prmryChkFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCrmMdmVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CrmMdmVO[]
	 */
    public CrmMdmVO[] getCrmMdmVOs() {
        CrmMdmVO[] vos = (CrmMdmVO[]) models.toArray(new CrmMdmVO[models.size()]);
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
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvisCntrCustTpCd = this.rvisCntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccLicNo = this.nvoccLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfAcctFlg = this.rfAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdEndEffDt = this.nvoccBdEndEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgEtt = this.msgEtt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srcSysCd = this.srcSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgCreDt = this.msgCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfSvcDtlDesc = this.prfSvcDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccHjsScacCd = this.nvoccHjsScacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mltTrdAcctFlg = this.mltTrdAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otiOrzNo = this.otiOrzNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ptyAddr = this.ptyAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.parObjRowId = this.parObjRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAlertEnd = this.bkgAlertEnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRgstNo = this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custUrl = this.custUrl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctsNo = this.ctsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctyNm = this.ctyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlMnPhnNo = this.intlMnPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crntVolKnt = this.crntVolKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfGrpCmdtCd = this.prfGrpCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custStsCd = this.custStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpCd = this.custGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrRowId = this.addrRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpIndivDiv = this.grpIndivDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAlertDate = this.bkgAlertDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opCd = this.opCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custEml = this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userKey = this.userKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRowId = this.custRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtFwrdFmcNo = this.frtFwrdFmcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdStrtEffDt = this.nvoccBdStrtEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnAcctFlg = this.rgnAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAlert = this.bkgAlert.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objRowId = this.objRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullMnFaxNo = this.fullMnFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gloAcctFlg = this.gloAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRmk = this.custRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfSvcDesc = this.prfSvcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlMnFaxNo = this.intlMnFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cpetiDesc = this.cpetiDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdAmt = this.nvoccBdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrGloUsrId = this.keyAcctMgrGloUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdNo = this.nvoccBdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAlertCreated = this.bkgAlertCreated.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mstOfcId = this.mstOfcId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfRepreCmdtCd = this.prfRepreCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAlertStart = this.bkgAlertStart.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newKeyAcctFlg = this.newKeyAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrTpCd = this.addrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullMnPhnNo = this.fullMnPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrGloUsrNm = this.keyAcctMgrGloUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclReqDesc = this.spclReqDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrRelRowId = this.addrRelRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctFlg = this.keyAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfCntrTpszCd = this.prfCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctStrtEffDt = this.keyAcctStrtEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAlertMess = this.bkgAlertMess.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stsCd = this.stsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgId = this.msgId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custTeam = this.custTeam.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRHQ = this.custRHQ.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.namedBIZ = this.namedBIZ.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgTypeName = this.msgTypeName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgTypeCode = this.msgTypeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
