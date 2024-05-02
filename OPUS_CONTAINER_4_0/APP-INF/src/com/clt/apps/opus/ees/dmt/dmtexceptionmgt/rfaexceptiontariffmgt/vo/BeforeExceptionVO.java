/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BeforeExceptionVO.java
*@FileTitle : BeforeExceptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.14  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
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
public class BeforeExceptionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BeforeExceptionVO> models = new ArrayList<BeforeExceptionVO>();

    /* Column Info */
    private String xcldSatFlg = null;

    /* Column Info */
    private String xcldSunFlg = null;

    /* Column Info */
    private String cvrgCmbSeq = null;

    /* Column Info */
    private String cvrgRgnAllNm = null;

    /* Column Info */
    private String rtChkFlg = null;

    /* Column Info */
    private String dmdtCntrCgoTpTxt = null;

    /* Column Info */
    private String n1stCmncVerSeq = null;

    /* Column Info */
    private String exptTrfRmk = null;

    /* Column Info */
    private String ftUseFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String cvrgSteCd = null;

    /* Column Info */
    private String rfaExptDarNo = null;

    /* Column Info */
    private String orgDestRgnCd = null;

    /* Column Info */
    private String cvrgCntCd = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updOfcCd = null;

    /* Column Info */
    private String orgDestMulti = null;

    /* Column Info */
    private String dmdtCntrCgoTpCd = null;

    /* Column Info */
    private String orgDestCntAllNm = null;

    /* Column Info */
    private String orgDestLocCd = null;

    /* Column Info */
    private String orgDestSteCd = null;

    /* Column Info */
    private String cvrgCntAllCd = null;

    /* Column Info */
    private String ttlDys = null;

    /* Column Info */
    private String orgDestRgnAllCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String cvrgContiCd = null;

    /* Column Info */
    private String orgDestCntCd = null;

    /* Column Info */
    private String xcldHolFlg = null;

    /* Column Info */
    private String currOrgDestMulti = null;

    /* Column Info */
    private String fnlDestRgnAllCd = null;

    /* Column Info */
    private String cvrgLocCd = null;

    /* Column Info */
    private String rtUseFlg = null;

    /* Column Info */
    private String fnlDestFlg = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String fnlDestRgnAllNm = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String fnlDestRgnCd = null;

    /* Column Info */
    private String orgDestRgnAllNm = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cvrgRgnCd = null;

    /* Column Info */
    private String rtChk = null;

    /* Column Info */
    private String orgDestContiCd = null;

    /* Column Info */
    private String dmdtExptRqstStsCd = null;

    /* Column Info */
    private String rfaExptMapgSeq = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String viewCvrgCmbSeq = null;

    /* Column Info */
    private String rfaRqstDtlSeq = null;

    /* Column Info */
    private String rfaExptVerSeq = null;

    /* Column Info */
    private String expDt = null;

    /* Column Info */
    private String fnlDestContiCd = null;

    /* Column Info */
    private String dmdtCgoTpCd = null;

    /* Column Info */
    private String fnlDestCntAllNm = null;

    /* Column Info */
    private String orgDestCntAllCd = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String cvrgCntAllNm = null;

    /* Column Info */
    private String fullExptTrfRmk = null;

    /* Column Info */
    private String cvrgRgnAllCd = null;

    /* Column Info */
    private String dmdtCntrTpCd = null;

    /* Column Info */
    private String fnlDestCntCd = null;

    /* Column Info */
    private String addDys = null;

    /* Column Info */
    private String viewVerSeq = null;

    /* Column Info */
    private String fnlDestLocCd = null;

    /* Column Info */
    private String rqstOfcCd = null;

    /* Column Info */
    private String fnlDestSteCd = null;

    /* Column Info */
    private String repCmdtCd = null;

    /* Column Info */
    private String fnlDestCntAllCd = null;

    /* Column Info */
    private String ftTir = null;

    /* Column Info */
    private String cmdtFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BeforeExceptionVO() {
    }

    public BeforeExceptionVO(String ibflag, String pagerows, String fnlDestSteCd, String fnlDestLocCd, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String rqstOfcCd, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String viewVerSeq, String dmdtExptRqstStsCd, String rfaRqstDtlSeq, String dmdtTrfCd, String n1stCmncVerSeq, String effDt, String expDt, String dmdtCntrTpCd, String dmdtCgoTpCd, String dmdtCntrCgoTpCd, String dmdtCntrCgoTpTxt, String repCmdtCd, String ftUseFlg, String addDys, String ttlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String rtUseFlg, String currCd, String exptTrfRmk, String fullExptTrfRmk, String custCd, String custNm, String cvrgCmbSeq, String viewCvrgCmbSeq, String cvrgContiCd, String cvrgCntCd, String cvrgCntAllCd, String cvrgCntAllNm, String cvrgRgnCd, String cvrgRgnAllCd, String cvrgRgnAllNm, String cvrgSteCd, String cvrgLocCd, String orgDestMulti, String currOrgDestMulti, String orgDestContiCd, String orgDestCntCd, String orgDestCntAllCd, String orgDestCntAllNm, String orgDestRgnCd, String orgDestRgnAllCd, String orgDestRgnAllNm, String orgDestSteCd, String orgDestLocCd, String fnlDestFlg, String fnlDestContiCd, String fnlDestCntCd, String fnlDestCntAllCd, String fnlDestCntAllNm, String fnlDestRgnCd, String fnlDestRgnAllCd, String fnlDestRgnAllNm, String rtChkFlg, String rtChk, String ftTir, String cmdtFlg) {
        this.xcldSatFlg = xcldSatFlg;
        this.xcldSunFlg = xcldSunFlg;
        this.cvrgCmbSeq = cvrgCmbSeq;
        this.cvrgRgnAllNm = cvrgRgnAllNm;
        this.rtChkFlg = rtChkFlg;
        this.dmdtCntrCgoTpTxt = dmdtCntrCgoTpTxt;
        this.n1stCmncVerSeq = n1stCmncVerSeq;
        this.exptTrfRmk = exptTrfRmk;
        this.ftUseFlg = ftUseFlg;
        this.pagerows = pagerows;
        this.effDt = effDt;
        this.cvrgSteCd = cvrgSteCd;
        this.rfaExptDarNo = rfaExptDarNo;
        this.orgDestRgnCd = orgDestRgnCd;
        this.cvrgCntCd = cvrgCntCd;
        this.dmdtTrfCd = dmdtTrfCd;
        this.updUsrId = updUsrId;
        this.updOfcCd = updOfcCd;
        this.orgDestMulti = orgDestMulti;
        this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
        this.orgDestCntAllNm = orgDestCntAllNm;
        this.orgDestLocCd = orgDestLocCd;
        this.orgDestSteCd = orgDestSteCd;
        this.cvrgCntAllCd = cvrgCntAllCd;
        this.ttlDys = ttlDys;
        this.orgDestRgnAllCd = orgDestRgnAllCd;
        this.creUsrId = creUsrId;
        this.custCd = custCd;
        this.cvrgContiCd = cvrgContiCd;
        this.orgDestCntCd = orgDestCntCd;
        this.xcldHolFlg = xcldHolFlg;
        this.currOrgDestMulti = currOrgDestMulti;
        this.fnlDestRgnAllCd = fnlDestRgnAllCd;
        this.cvrgLocCd = cvrgLocCd;
        this.rtUseFlg = rtUseFlg;
        this.fnlDestFlg = fnlDestFlg;
        this.currCd = currCd;
        this.custNm = custNm;
        this.fnlDestRgnAllNm = fnlDestRgnAllNm;
        this.creDt = creDt;
        this.fnlDestRgnCd = fnlDestRgnCd;
        this.orgDestRgnAllNm = orgDestRgnAllNm;
        this.ibflag = ibflag;
        this.cvrgRgnCd = cvrgRgnCd;
        this.rtChk = rtChk;
        this.orgDestContiCd = orgDestContiCd;
        this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
        this.rfaExptMapgSeq = rfaExptMapgSeq;
        this.creOfcCd = creOfcCd;
        this.viewCvrgCmbSeq = viewCvrgCmbSeq;
        this.rfaRqstDtlSeq = rfaRqstDtlSeq;
        this.rfaExptVerSeq = rfaExptVerSeq;
        this.expDt = expDt;
        this.fnlDestContiCd = fnlDestContiCd;
        this.dmdtCgoTpCd = dmdtCgoTpCd;
        this.fnlDestCntAllNm = fnlDestCntAllNm;
        this.orgDestCntAllCd = orgDestCntAllCd;
        this.updDt = updDt;
        this.cvrgCntAllNm = cvrgCntAllNm;
        this.fullExptTrfRmk = fullExptTrfRmk;
        this.cvrgRgnAllCd = cvrgRgnAllCd;
        this.dmdtCntrTpCd = dmdtCntrTpCd;
        this.fnlDestCntCd = fnlDestCntCd;
        this.addDys = addDys;
        this.viewVerSeq = viewVerSeq;
        this.fnlDestLocCd = fnlDestLocCd;
        this.rqstOfcCd = rqstOfcCd;
        this.fnlDestSteCd = fnlDestSteCd;
        this.repCmdtCd = repCmdtCd;
        this.fnlDestCntAllCd = fnlDestCntAllCd;
        this.ftTir = ftTir;
        this.cmdtFlg = cmdtFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
        this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
        this.hashColumns.put("cvrg_cmb_seq", getCvrgCmbSeq());
        this.hashColumns.put("cvrg_rgn_all_nm", getCvrgRgnAllNm());
        this.hashColumns.put("rt_chk_flg", getRtChkFlg());
        this.hashColumns.put("dmdt_cntr_cgo_tp_txt", getDmdtCntrCgoTpTxt());
        this.hashColumns.put("n1st_cmnc_ver_seq", getN1stCmncVerSeq());
        this.hashColumns.put("expt_trf_rmk", getExptTrfRmk());
        this.hashColumns.put("ft_use_flg", getFtUseFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
        this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
        this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
        this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
        this.hashColumns.put("org_dest_multi", getOrgDestMulti());
        this.hashColumns.put("dmdt_cntr_cgo_tp_cd", getDmdtCntrCgoTpCd());
        this.hashColumns.put("org_dest_cnt_all_nm", getOrgDestCntAllNm());
        this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
        this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
        this.hashColumns.put("cvrg_cnt_all_cd", getCvrgCntAllCd());
        this.hashColumns.put("ttl_dys", getTtlDys());
        this.hashColumns.put("org_dest_rgn_all_cd", getOrgDestRgnAllCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("cvrg_conti_cd", getCvrgContiCd());
        this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
        this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
        this.hashColumns.put("curr_org_dest_multi", getCurrOrgDestMulti());
        this.hashColumns.put("fnl_dest_rgn_all_cd", getFnlDestRgnAllCd());
        this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
        this.hashColumns.put("rt_use_flg", getRtUseFlg());
        this.hashColumns.put("fnl_dest_flg", getFnlDestFlg());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("fnl_dest_rgn_all_nm", getFnlDestRgnAllNm());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("fnl_dest_rgn_cd", getFnlDestRgnCd());
        this.hashColumns.put("org_dest_rgn_all_nm", getOrgDestRgnAllNm());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
        this.hashColumns.put("rt_chk", getRtChk());
        this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
        this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
        this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("view_cvrg_cmb_seq", getViewCvrgCmbSeq());
        this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
        this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
        this.hashColumns.put("exp_dt", getExpDt());
        this.hashColumns.put("fnl_dest_conti_cd", getFnlDestContiCd());
        this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
        this.hashColumns.put("fnl_dest_cnt_all_nm", getFnlDestCntAllNm());
        this.hashColumns.put("org_dest_cnt_all_cd", getOrgDestCntAllCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cvrg_cnt_all_nm", getCvrgCntAllNm());
        this.hashColumns.put("full_expt_trf_rmk", getFullExptTrfRmk());
        this.hashColumns.put("cvrg_rgn_all_cd", getCvrgRgnAllCd());
        this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
        this.hashColumns.put("fnl_dest_cnt_cd", getFnlDestCntCd());
        this.hashColumns.put("add_dys", getAddDys());
        this.hashColumns.put("view_ver_seq", getViewVerSeq());
        this.hashColumns.put("fnl_dest_loc_cd", getFnlDestLocCd());
        this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
        this.hashColumns.put("fnl_dest_ste_cd", getFnlDestSteCd());
        this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
        this.hashColumns.put("fnl_dest_cnt_all_cd", getFnlDestCntAllCd());
        this.hashColumns.put("ft_tir", getFtTir());
        this.hashColumns.put("cmdt_flg", getCmdtFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
        this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
        this.hashFields.put("cvrg_cmb_seq", "cvrgCmbSeq");
        this.hashFields.put("cvrg_rgn_all_nm", "cvrgRgnAllNm");
        this.hashFields.put("rt_chk_flg", "rtChkFlg");
        this.hashFields.put("dmdt_cntr_cgo_tp_txt", "dmdtCntrCgoTpTxt");
        this.hashFields.put("n1st_cmnc_ver_seq", "n1stCmncVerSeq");
        this.hashFields.put("expt_trf_rmk", "exptTrfRmk");
        this.hashFields.put("ft_use_flg", "ftUseFlg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
        this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
        this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
        this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_ofc_cd", "updOfcCd");
        this.hashFields.put("org_dest_multi", "orgDestMulti");
        this.hashFields.put("dmdt_cntr_cgo_tp_cd", "dmdtCntrCgoTpCd");
        this.hashFields.put("org_dest_cnt_all_nm", "orgDestCntAllNm");
        this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
        this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
        this.hashFields.put("cvrg_cnt_all_cd", "cvrgCntAllCd");
        this.hashFields.put("ttl_dys", "ttlDys");
        this.hashFields.put("org_dest_rgn_all_cd", "orgDestRgnAllCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("cvrg_conti_cd", "cvrgContiCd");
        this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
        this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
        this.hashFields.put("curr_org_dest_multi", "currOrgDestMulti");
        this.hashFields.put("fnl_dest_rgn_all_cd", "fnlDestRgnAllCd");
        this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
        this.hashFields.put("rt_use_flg", "rtUseFlg");
        this.hashFields.put("fnl_dest_flg", "fnlDestFlg");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("fnl_dest_rgn_all_nm", "fnlDestRgnAllNm");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("fnl_dest_rgn_cd", "fnlDestRgnCd");
        this.hashFields.put("org_dest_rgn_all_nm", "orgDestRgnAllNm");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
        this.hashFields.put("rt_chk", "rtChk");
        this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
        this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
        this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("view_cvrg_cmb_seq", "viewCvrgCmbSeq");
        this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
        this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
        this.hashFields.put("exp_dt", "expDt");
        this.hashFields.put("fnl_dest_conti_cd", "fnlDestContiCd");
        this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
        this.hashFields.put("fnl_dest_cnt_all_nm", "fnlDestCntAllNm");
        this.hashFields.put("org_dest_cnt_all_cd", "orgDestCntAllCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cvrg_cnt_all_nm", "cvrgCntAllNm");
        this.hashFields.put("full_expt_trf_rmk", "fullExptTrfRmk");
        this.hashFields.put("cvrg_rgn_all_cd", "cvrgRgnAllCd");
        this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
        this.hashFields.put("fnl_dest_cnt_cd", "fnlDestCntCd");
        this.hashFields.put("add_dys", "addDys");
        this.hashFields.put("view_ver_seq", "viewVerSeq");
        this.hashFields.put("fnl_dest_loc_cd", "fnlDestLocCd");
        this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
        this.hashFields.put("fnl_dest_ste_cd", "fnlDestSteCd");
        this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
        this.hashFields.put("fnl_dest_cnt_all_cd", "fnlDestCntAllCd");
        this.hashFields.put("ft_tir", "ftTir");
        this.hashFields.put("cmdt_flg", "cmdtFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return xcldSatFlg
	 */
    public String getXcldSatFlg() {
        return this.xcldSatFlg;
    }

    /**
	 * Column Info
	 * @return xcldSunFlg
	 */
    public String getXcldSunFlg() {
        return this.xcldSunFlg;
    }

    /**
	 * Column Info
	 * @return cvrgCmbSeq
	 */
    public String getCvrgCmbSeq() {
        return this.cvrgCmbSeq;
    }

    /**
	 * Column Info
	 * @return cvrgRgnAllNm
	 */
    public String getCvrgRgnAllNm() {
        return this.cvrgRgnAllNm;
    }

    /**
	 * Column Info
	 * @return rtChkFlg
	 */
    public String getRtChkFlg() {
        return this.rtChkFlg;
    }

    /**
	 * Column Info
	 * @return dmdtCntrCgoTpTxt
	 */
    public String getDmdtCntrCgoTpTxt() {
        return this.dmdtCntrCgoTpTxt;
    }

    /**
	 * Column Info
	 * @return n1stCmncVerSeq
	 */
    public String getN1stCmncVerSeq() {
        return this.n1stCmncVerSeq;
    }

    /**
	 * Column Info
	 * @return exptTrfRmk
	 */
    public String getExptTrfRmk() {
        return this.exptTrfRmk;
    }

    /**
	 * Column Info
	 * @return ftUseFlg
	 */
    public String getFtUseFlg() {
        return this.ftUseFlg;
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
	 * @return effDt
	 */
    public String getEffDt() {
        return this.effDt;
    }

    /**
	 * Column Info
	 * @return cvrgSteCd
	 */
    public String getCvrgSteCd() {
        return this.cvrgSteCd;
    }

    /**
	 * Column Info
	 * @return rfaExptDarNo
	 */
    public String getRfaExptDarNo() {
        return this.rfaExptDarNo;
    }

    /**
	 * Column Info
	 * @return orgDestRgnCd
	 */
    public String getOrgDestRgnCd() {
        return this.orgDestRgnCd;
    }

    /**
	 * Column Info
	 * @return cvrgCntCd
	 */
    public String getCvrgCntCd() {
        return this.cvrgCntCd;
    }

    /**
	 * Column Info
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return updOfcCd
	 */
    public String getUpdOfcCd() {
        return this.updOfcCd;
    }

    /**
	 * Column Info
	 * @return orgDestMulti
	 */
    public String getOrgDestMulti() {
        return this.orgDestMulti;
    }

    /**
	 * Column Info
	 * @return dmdtCntrCgoTpCd
	 */
    public String getDmdtCntrCgoTpCd() {
        return this.dmdtCntrCgoTpCd;
    }

    /**
	 * Column Info
	 * @return orgDestCntAllNm
	 */
    public String getOrgDestCntAllNm() {
        return this.orgDestCntAllNm;
    }

    /**
	 * Column Info
	 * @return orgDestLocCd
	 */
    public String getOrgDestLocCd() {
        return this.orgDestLocCd;
    }

    /**
	 * Column Info
	 * @return orgDestSteCd
	 */
    public String getOrgDestSteCd() {
        return this.orgDestSteCd;
    }

    /**
	 * Column Info
	 * @return cvrgCntAllCd
	 */
    public String getCvrgCntAllCd() {
        return this.cvrgCntAllCd;
    }

    /**
	 * Column Info
	 * @return ttlDys
	 */
    public String getTtlDys() {
        return this.ttlDys;
    }

    /**
	 * Column Info
	 * @return orgDestRgnAllCd
	 */
    public String getOrgDestRgnAllCd() {
        return this.orgDestRgnAllCd;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return custCd
	 */
    public String getCustCd() {
        return this.custCd;
    }

    /**
	 * Column Info
	 * @return cvrgContiCd
	 */
    public String getCvrgContiCd() {
        return this.cvrgContiCd;
    }

    /**
	 * Column Info
	 * @return orgDestCntCd
	 */
    public String getOrgDestCntCd() {
        return this.orgDestCntCd;
    }

    /**
	 * Column Info
	 * @return xcldHolFlg
	 */
    public String getXcldHolFlg() {
        return this.xcldHolFlg;
    }

    /**
	 * Column Info
	 * @return currOrgDestMulti
	 */
    public String getCurrOrgDestMulti() {
        return this.currOrgDestMulti;
    }

    /**
	 * Column Info
	 * @return fnlDestRgnAllCd
	 */
    public String getFnlDestRgnAllCd() {
        return this.fnlDestRgnAllCd;
    }

    /**
	 * Column Info
	 * @return cvrgLocCd
	 */
    public String getCvrgLocCd() {
        return this.cvrgLocCd;
    }

    /**
	 * Column Info
	 * @return rtUseFlg
	 */
    public String getRtUseFlg() {
        return this.rtUseFlg;
    }

    /**
	 * Column Info
	 * @return fnlDestFlg
	 */
    public String getFnlDestFlg() {
        return this.fnlDestFlg;
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
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 * Column Info
	 * @return fnlDestRgnAllNm
	 */
    public String getFnlDestRgnAllNm() {
        return this.fnlDestRgnAllNm;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return fnlDestRgnCd
	 */
    public String getFnlDestRgnCd() {
        return this.fnlDestRgnCd;
    }

    /**
	 * Column Info
	 * @return orgDestRgnAllNm
	 */
    public String getOrgDestRgnAllNm() {
        return this.orgDestRgnAllNm;
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
	 * @return cvrgRgnCd
	 */
    public String getCvrgRgnCd() {
        return this.cvrgRgnCd;
    }

    /**
	 * Column Info
	 * @return rtChk
	 */
    public String getRtChk() {
        return this.rtChk;
    }

    /**
	 * Column Info
	 * @return orgDestContiCd
	 */
    public String getOrgDestContiCd() {
        return this.orgDestContiCd;
    }

    /**
	 * Column Info
	 * @return dmdtExptRqstStsCd
	 */
    public String getDmdtExptRqstStsCd() {
        return this.dmdtExptRqstStsCd;
    }

    /**
	 * Column Info
	 * @return rfaExptMapgSeq
	 */
    public String getRfaExptMapgSeq() {
        return this.rfaExptMapgSeq;
    }

    /**
	 * Column Info
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    /**
	 * Column Info
	 * @return viewCvrgCmbSeq
	 */
    public String getViewCvrgCmbSeq() {
        return this.viewCvrgCmbSeq;
    }

    /**
	 * Column Info
	 * @return rfaRqstDtlSeq
	 */
    public String getRfaRqstDtlSeq() {
        return this.rfaRqstDtlSeq;
    }

    /**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
    public String getRfaExptVerSeq() {
        return this.rfaExptVerSeq;
    }

    /**
	 * Column Info
	 * @return expDt
	 */
    public String getExpDt() {
        return this.expDt;
    }

    /**
	 * Column Info
	 * @return fnlDestContiCd
	 */
    public String getFnlDestContiCd() {
        return this.fnlDestContiCd;
    }

    /**
	 * Column Info
	 * @return dmdtCgoTpCd
	 */
    public String getDmdtCgoTpCd() {
        return this.dmdtCgoTpCd;
    }

    /**
	 * Column Info
	 * @return fnlDestCntAllNm
	 */
    public String getFnlDestCntAllNm() {
        return this.fnlDestCntAllNm;
    }

    /**
	 * Column Info
	 * @return orgDestCntAllCd
	 */
    public String getOrgDestCntAllCd() {
        return this.orgDestCntAllCd;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return cvrgCntAllNm
	 */
    public String getCvrgCntAllNm() {
        return this.cvrgCntAllNm;
    }

    /**
	 * Column Info
	 * @return fullExptTrfRmk
	 */
    public String getFullExptTrfRmk() {
        return this.fullExptTrfRmk;
    }

    /**
	 * Column Info
	 * @return cvrgRgnAllCd
	 */
    public String getCvrgRgnAllCd() {
        return this.cvrgRgnAllCd;
    }

    /**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
    public String getDmdtCntrTpCd() {
        return this.dmdtCntrTpCd;
    }

    /**
	 * Column Info
	 * @return fnlDestCntCd
	 */
    public String getFnlDestCntCd() {
        return this.fnlDestCntCd;
    }

    /**
	 * Column Info
	 * @return addDys
	 */
    public String getAddDys() {
        return this.addDys;
    }

    /**
	 * Column Info
	 * @return viewVerSeq
	 */
    public String getViewVerSeq() {
        return this.viewVerSeq;
    }

    /**
	 * Column Info
	 * @return fnlDestLocCd
	 */
    public String getFnlDestLocCd() {
        return this.fnlDestLocCd;
    }

    /**
	 * Column Info
	 * @return rqstOfcCd
	 */
    public String getRqstOfcCd() {
        return this.rqstOfcCd;
    }

    /**
	 * Column Info
	 * @return fnlDestSteCd
	 */
    public String getFnlDestSteCd() {
        return this.fnlDestSteCd;
    }

    /**
	 * Column Info
	 * @return repCmdtCd
	 */
    public String getRepCmdtCd() {
        return this.repCmdtCd;
    }

    /**
	 * Column Info
	 * @return fnlDestCntAllCd
	 */
    public String getFnlDestCntAllCd() {
        return this.fnlDestCntAllCd;
    }

    /**
	 * Column Info
	 * @param xcldSatFlg
	 */
    public void setXcldSatFlg(String xcldSatFlg) {
        this.xcldSatFlg = xcldSatFlg;
    }

    /**
	 * Column Info
	 * @param xcldSunFlg
	 */
    public void setXcldSunFlg(String xcldSunFlg) {
        this.xcldSunFlg = xcldSunFlg;
    }

    /**
	 * Column Info
	 * @param cvrgCmbSeq
	 */
    public void setCvrgCmbSeq(String cvrgCmbSeq) {
        this.cvrgCmbSeq = cvrgCmbSeq;
    }

    /**
	 * Column Info
	 * @param cvrgRgnAllNm
	 */
    public void setCvrgRgnAllNm(String cvrgRgnAllNm) {
        this.cvrgRgnAllNm = cvrgRgnAllNm;
    }

    /**
	 * Column Info
	 * @param rtChkFlg
	 */
    public void setRtChkFlg(String rtChkFlg) {
        this.rtChkFlg = rtChkFlg;
    }

    /**
	 * Column Info
	 * @param dmdtCntrCgoTpTxt
	 */
    public void setDmdtCntrCgoTpTxt(String dmdtCntrCgoTpTxt) {
        this.dmdtCntrCgoTpTxt = dmdtCntrCgoTpTxt;
    }

    /**
	 * Column Info
	 * @param n1stCmncVerSeq
	 */
    public void setN1stCmncVerSeq(String n1stCmncVerSeq) {
        this.n1stCmncVerSeq = n1stCmncVerSeq;
    }

    /**
	 * Column Info
	 * @param exptTrfRmk
	 */
    public void setExptTrfRmk(String exptTrfRmk) {
        this.exptTrfRmk = exptTrfRmk;
    }

    /**
	 * Column Info
	 * @param ftUseFlg
	 */
    public void setFtUseFlg(String ftUseFlg) {
        this.ftUseFlg = ftUseFlg;
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
	 * @param effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    /**
	 * Column Info
	 * @param cvrgSteCd
	 */
    public void setCvrgSteCd(String cvrgSteCd) {
        this.cvrgSteCd = cvrgSteCd;
    }

    /**
	 * Column Info
	 * @param rfaExptDarNo
	 */
    public void setRfaExptDarNo(String rfaExptDarNo) {
        this.rfaExptDarNo = rfaExptDarNo;
    }

    /**
	 * Column Info
	 * @param orgDestRgnCd
	 */
    public void setOrgDestRgnCd(String orgDestRgnCd) {
        this.orgDestRgnCd = orgDestRgnCd;
    }

    /**
	 * Column Info
	 * @param cvrgCntCd
	 */
    public void setCvrgCntCd(String cvrgCntCd) {
        this.cvrgCntCd = cvrgCntCd;
    }

    /**
	 * Column Info
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param updOfcCd
	 */
    public void setUpdOfcCd(String updOfcCd) {
        this.updOfcCd = updOfcCd;
    }

    /**
	 * Column Info
	 * @param orgDestMulti
	 */
    public void setOrgDestMulti(String orgDestMulti) {
        this.orgDestMulti = orgDestMulti;
    }

    /**
	 * Column Info
	 * @param dmdtCntrCgoTpCd
	 */
    public void setDmdtCntrCgoTpCd(String dmdtCntrCgoTpCd) {
        this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
    }

    /**
	 * Column Info
	 * @param orgDestCntAllNm
	 */
    public void setOrgDestCntAllNm(String orgDestCntAllNm) {
        this.orgDestCntAllNm = orgDestCntAllNm;
    }

    /**
	 * Column Info
	 * @param orgDestLocCd
	 */
    public void setOrgDestLocCd(String orgDestLocCd) {
        this.orgDestLocCd = orgDestLocCd;
    }

    /**
	 * Column Info
	 * @param orgDestSteCd
	 */
    public void setOrgDestSteCd(String orgDestSteCd) {
        this.orgDestSteCd = orgDestSteCd;
    }

    /**
	 * Column Info
	 * @param cvrgCntAllCd
	 */
    public void setCvrgCntAllCd(String cvrgCntAllCd) {
        this.cvrgCntAllCd = cvrgCntAllCd;
    }

    /**
	 * Column Info
	 * @param ttlDys
	 */
    public void setTtlDys(String ttlDys) {
        this.ttlDys = ttlDys;
    }

    /**
	 * Column Info
	 * @param orgDestRgnAllCd
	 */
    public void setOrgDestRgnAllCd(String orgDestRgnAllCd) {
        this.orgDestRgnAllCd = orgDestRgnAllCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /**
	 * Column Info
	 * @param cvrgContiCd
	 */
    public void setCvrgContiCd(String cvrgContiCd) {
        this.cvrgContiCd = cvrgContiCd;
    }

    /**
	 * Column Info
	 * @param orgDestCntCd
	 */
    public void setOrgDestCntCd(String orgDestCntCd) {
        this.orgDestCntCd = orgDestCntCd;
    }

    /**
	 * Column Info
	 * @param xcldHolFlg
	 */
    public void setXcldHolFlg(String xcldHolFlg) {
        this.xcldHolFlg = xcldHolFlg;
    }

    /**
	 * Column Info
	 * @param currOrgDestMulti
	 */
    public void setCurrOrgDestMulti(String currOrgDestMulti) {
        this.currOrgDestMulti = currOrgDestMulti;
    }

    /**
	 * Column Info
	 * @param fnlDestRgnAllCd
	 */
    public void setFnlDestRgnAllCd(String fnlDestRgnAllCd) {
        this.fnlDestRgnAllCd = fnlDestRgnAllCd;
    }

    /**
	 * Column Info
	 * @param cvrgLocCd
	 */
    public void setCvrgLocCd(String cvrgLocCd) {
        this.cvrgLocCd = cvrgLocCd;
    }

    /**
	 * Column Info
	 * @param rtUseFlg
	 */
    public void setRtUseFlg(String rtUseFlg) {
        this.rtUseFlg = rtUseFlg;
    }

    /**
	 * Column Info
	 * @param fnlDestFlg
	 */
    public void setFnlDestFlg(String fnlDestFlg) {
        this.fnlDestFlg = fnlDestFlg;
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
	 * @param custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * Column Info
	 * @param fnlDestRgnAllNm
	 */
    public void setFnlDestRgnAllNm(String fnlDestRgnAllNm) {
        this.fnlDestRgnAllNm = fnlDestRgnAllNm;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param fnlDestRgnCd
	 */
    public void setFnlDestRgnCd(String fnlDestRgnCd) {
        this.fnlDestRgnCd = fnlDestRgnCd;
    }

    /**
	 * Column Info
	 * @param orgDestRgnAllNm
	 */
    public void setOrgDestRgnAllNm(String orgDestRgnAllNm) {
        this.orgDestRgnAllNm = orgDestRgnAllNm;
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
	 * @param cvrgRgnCd
	 */
    public void setCvrgRgnCd(String cvrgRgnCd) {
        this.cvrgRgnCd = cvrgRgnCd;
    }

    /**
	 * Column Info
	 * @param rtChk
	 */
    public void setRtChk(String rtChk) {
        this.rtChk = rtChk;
    }

    /**
	 * Column Info
	 * @param orgDestContiCd
	 */
    public void setOrgDestContiCd(String orgDestContiCd) {
        this.orgDestContiCd = orgDestContiCd;
    }

    /**
	 * Column Info
	 * @param dmdtExptRqstStsCd
	 */
    public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
        this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
    }

    /**
	 * Column Info
	 * @param rfaExptMapgSeq
	 */
    public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
        this.rfaExptMapgSeq = rfaExptMapgSeq;
    }

    /**
	 * Column Info
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    /**
	 * Column Info
	 * @param viewCvrgCmbSeq
	 */
    public void setViewCvrgCmbSeq(String viewCvrgCmbSeq) {
        this.viewCvrgCmbSeq = viewCvrgCmbSeq;
    }

    /**
	 * Column Info
	 * @param rfaRqstDtlSeq
	 */
    public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
        this.rfaRqstDtlSeq = rfaRqstDtlSeq;
    }

    /**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
    public void setRfaExptVerSeq(String rfaExptVerSeq) {
        this.rfaExptVerSeq = rfaExptVerSeq;
    }

    /**
	 * Column Info
	 * @param expDt
	 */
    public void setExpDt(String expDt) {
        this.expDt = expDt;
    }

    /**
	 * Column Info
	 * @param fnlDestContiCd
	 */
    public void setFnlDestContiCd(String fnlDestContiCd) {
        this.fnlDestContiCd = fnlDestContiCd;
    }

    /**
	 * Column Info
	 * @param dmdtCgoTpCd
	 */
    public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
        this.dmdtCgoTpCd = dmdtCgoTpCd;
    }

    /**
	 * Column Info
	 * @param fnlDestCntAllNm
	 */
    public void setFnlDestCntAllNm(String fnlDestCntAllNm) {
        this.fnlDestCntAllNm = fnlDestCntAllNm;
    }

    /**
	 * Column Info
	 * @param orgDestCntAllCd
	 */
    public void setOrgDestCntAllCd(String orgDestCntAllCd) {
        this.orgDestCntAllCd = orgDestCntAllCd;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param cvrgCntAllNm
	 */
    public void setCvrgCntAllNm(String cvrgCntAllNm) {
        this.cvrgCntAllNm = cvrgCntAllNm;
    }

    /**
	 * Column Info
	 * @param fullExptTrfRmk
	 */
    public void setFullExptTrfRmk(String fullExptTrfRmk) {
        this.fullExptTrfRmk = fullExptTrfRmk;
    }

    /**
	 * Column Info
	 * @param cvrgRgnAllCd
	 */
    public void setCvrgRgnAllCd(String cvrgRgnAllCd) {
        this.cvrgRgnAllCd = cvrgRgnAllCd;
    }

    /**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
    public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
        this.dmdtCntrTpCd = dmdtCntrTpCd;
    }

    /**
	 * Column Info
	 * @param fnlDestCntCd
	 */
    public void setFnlDestCntCd(String fnlDestCntCd) {
        this.fnlDestCntCd = fnlDestCntCd;
    }

    /**
	 * Column Info
	 * @param addDys
	 */
    public void setAddDys(String addDys) {
        this.addDys = addDys;
    }

    /**
	 * Column Info
	 * @param viewVerSeq
	 */
    public void setViewVerSeq(String viewVerSeq) {
        this.viewVerSeq = viewVerSeq;
    }

    /**
	 * Column Info
	 * @param fnlDestLocCd
	 */
    public void setFnlDestLocCd(String fnlDestLocCd) {
        this.fnlDestLocCd = fnlDestLocCd;
    }

    /**
	 * Column Info
	 * @param rqstOfcCd
	 */
    public void setRqstOfcCd(String rqstOfcCd) {
        this.rqstOfcCd = rqstOfcCd;
    }

    /**
	 * Column Info
	 * @param fnlDestSteCd
	 */
    public void setFnlDestSteCd(String fnlDestSteCd) {
        this.fnlDestSteCd = fnlDestSteCd;
    }

    /**
	 * Column Info
	 * @param repCmdtCd
	 */
    public void setRepCmdtCd(String repCmdtCd) {
        this.repCmdtCd = repCmdtCd;
    }

    /**
	 * Column Info
	 * @param fnlDestCntAllCd
	 */
    public void setFnlDestCntAllCd(String fnlDestCntAllCd) {
        this.fnlDestCntAllCd = fnlDestCntAllCd;
    }

    public void setFtTir(String ftTir) {
        this.ftTir = ftTir;
    }

    public String getFtTir() {
        return this.ftTir;
    }

    public void setCmdtFlg(String cmdtFlg) {
        this.cmdtFlg = cmdtFlg;
    }

    public String getCmdtFlg() {
        return this.cmdtFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
        setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
        setCvrgCmbSeq(JSPUtil.getParameter(request, "cvrg_cmb_seq", ""));
        setCvrgRgnAllNm(JSPUtil.getParameter(request, "cvrg_rgn_all_nm", ""));
        setRtChkFlg(JSPUtil.getParameter(request, "rt_chk_flg", ""));
        setDmdtCntrCgoTpTxt(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_txt", ""));
        setN1stCmncVerSeq(JSPUtil.getParameter(request, "n1st_cmnc_ver_seq", ""));
        setExptTrfRmk(JSPUtil.getParameter(request, "expt_trf_rmk", ""));
        setFtUseFlg(JSPUtil.getParameter(request, "ft_use_flg", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
        setCvrgSteCd(JSPUtil.getParameter(request, "cvrg_ste_cd", ""));
        setRfaExptDarNo(JSPUtil.getParameter(request, "rfa_expt_dar_no", ""));
        setOrgDestRgnCd(JSPUtil.getParameter(request, "org_dest_rgn_cd", ""));
        setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
        setOrgDestMulti(JSPUtil.getParameter(request, "org_dest_multi", ""));
        setDmdtCntrCgoTpCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_cd", ""));
        setOrgDestCntAllNm(JSPUtil.getParameter(request, "org_dest_cnt_all_nm", ""));
        setOrgDestLocCd(JSPUtil.getParameter(request, "org_dest_loc_cd", ""));
        setOrgDestSteCd(JSPUtil.getParameter(request, "org_dest_ste_cd", ""));
        setCvrgCntAllCd(JSPUtil.getParameter(request, "cvrg_cnt_all_cd", ""));
        setTtlDys(JSPUtil.getParameter(request, "ttl_dys", ""));
        setOrgDestRgnAllCd(JSPUtil.getParameter(request, "org_dest_rgn_all_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
        setCvrgContiCd(JSPUtil.getParameter(request, "cvrg_conti_cd", ""));
        setOrgDestCntCd(JSPUtil.getParameter(request, "org_dest_cnt_cd", ""));
        setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
        setCurrOrgDestMulti(JSPUtil.getParameter(request, "curr_org_dest_multi", ""));
        setFnlDestRgnAllCd(JSPUtil.getParameter(request, "fnl_dest_rgn_all_cd", ""));
        setCvrgLocCd(JSPUtil.getParameter(request, "cvrg_loc_cd", ""));
        setRtUseFlg(JSPUtil.getParameter(request, "rt_use_flg", ""));
        setFnlDestFlg(JSPUtil.getParameter(request, "fnl_dest_flg", ""));
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
        setFnlDestRgnAllNm(JSPUtil.getParameter(request, "fnl_dest_rgn_all_nm", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
        setFnlDestRgnCd(JSPUtil.getParameter(request, "fnl_dest_rgn_cd", ""));
        setOrgDestRgnAllNm(JSPUtil.getParameter(request, "org_dest_rgn_all_nm", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCvrgRgnCd(JSPUtil.getParameter(request, "cvrg_rgn_cd", ""));
        setRtChk(JSPUtil.getParameter(request, "rt_chk", ""));
        setOrgDestContiCd(JSPUtil.getParameter(request, "org_dest_conti_cd", ""));
        setDmdtExptRqstStsCd(JSPUtil.getParameter(request, "dmdt_expt_rqst_sts_cd", ""));
        setRfaExptMapgSeq(JSPUtil.getParameter(request, "rfa_expt_mapg_seq", ""));
        setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
        setViewCvrgCmbSeq(JSPUtil.getParameter(request, "view_cvrg_cmb_seq", ""));
        setRfaRqstDtlSeq(JSPUtil.getParameter(request, "rfa_rqst_dtl_seq", ""));
        setRfaExptVerSeq(JSPUtil.getParameter(request, "rfa_expt_ver_seq", ""));
        setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
        setFnlDestContiCd(JSPUtil.getParameter(request, "fnl_dest_conti_cd", ""));
        setDmdtCgoTpCd(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd", ""));
        setFnlDestCntAllNm(JSPUtil.getParameter(request, "fnl_dest_cnt_all_nm", ""));
        setOrgDestCntAllCd(JSPUtil.getParameter(request, "org_dest_cnt_all_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setCvrgCntAllNm(JSPUtil.getParameter(request, "cvrg_cnt_all_nm", ""));
        setFullExptTrfRmk(JSPUtil.getParameter(request, "full_expt_trf_rmk", ""));
        setCvrgRgnAllCd(JSPUtil.getParameter(request, "cvrg_rgn_all_cd", ""));
        setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
        setFnlDestCntCd(JSPUtil.getParameter(request, "fnl_dest_cnt_cd", ""));
        setAddDys(JSPUtil.getParameter(request, "add_dys", ""));
        setViewVerSeq(JSPUtil.getParameter(request, "view_ver_seq", ""));
        setFnlDestLocCd(JSPUtil.getParameter(request, "fnl_dest_loc_cd", ""));
        setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
        setFnlDestSteCd(JSPUtil.getParameter(request, "fnl_dest_ste_cd", ""));
        setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
        setFnlDestCntAllCd(JSPUtil.getParameter(request, "fnl_dest_cnt_all_cd", ""));
        setFtTir(JSPUtil.getParameter(request, "ft_tir", ""));
        setCmdtFlg(JSPUtil.getParameter(request, "cmdt_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BeforeExceptionVO[]
	 */
    public BeforeExceptionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BeforeExceptionVO[]
	 */
    public BeforeExceptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BeforeExceptionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix + "xcld_sat_flg", length));
            String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix + "xcld_sun_flg", length));
            String[] cvrgCmbSeq = (JSPUtil.getParameter(request, prefix + "cvrg_cmb_seq", length));
            String[] cvrgRgnAllNm = (JSPUtil.getParameter(request, prefix + "cvrg_rgn_all_nm", length));
            String[] rtChkFlg = (JSPUtil.getParameter(request, prefix + "rt_chk_flg", length));
            String[] dmdtCntrCgoTpTxt = (JSPUtil.getParameter(request, prefix + "dmdt_cntr_cgo_tp_txt", length));
            String[] n1stCmncVerSeq = (JSPUtil.getParameter(request, prefix + "n1st_cmnc_ver_seq", length));
            String[] exptTrfRmk = (JSPUtil.getParameter(request, prefix + "expt_trf_rmk", length));
            String[] ftUseFlg = (JSPUtil.getParameter(request, prefix + "ft_use_flg", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix + "cvrg_ste_cd", length));
            String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", length));
            String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix + "org_dest_rgn_cd", length));
            String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix + "cvrg_cnt_cd", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
            String[] orgDestMulti = (JSPUtil.getParameter(request, prefix + "org_dest_multi", length));
            String[] dmdtCntrCgoTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_cntr_cgo_tp_cd", length));
            String[] orgDestCntAllNm = (JSPUtil.getParameter(request, prefix + "org_dest_cnt_all_nm", length));
            String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix + "org_dest_loc_cd", length));
            String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix + "org_dest_ste_cd", length));
            String[] cvrgCntAllCd = (JSPUtil.getParameter(request, prefix + "cvrg_cnt_all_cd", length));
            String[] ttlDys = (JSPUtil.getParameter(request, prefix + "ttl_dys", length));
            String[] orgDestRgnAllCd = (JSPUtil.getParameter(request, prefix + "org_dest_rgn_all_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] cvrgContiCd = (JSPUtil.getParameter(request, prefix + "cvrg_conti_cd", length));
            String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix + "org_dest_cnt_cd", length));
            String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix + "xcld_hol_flg", length));
            String[] currOrgDestMulti = (JSPUtil.getParameter(request, prefix + "curr_org_dest_multi", length));
            String[] fnlDestRgnAllCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_rgn_all_cd", length));
            String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix + "cvrg_loc_cd", length));
            String[] rtUseFlg = (JSPUtil.getParameter(request, prefix + "rt_use_flg", length));
            String[] fnlDestFlg = (JSPUtil.getParameter(request, prefix + "fnl_dest_flg", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] fnlDestRgnAllNm = (JSPUtil.getParameter(request, prefix + "fnl_dest_rgn_all_nm", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] fnlDestRgnCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_rgn_cd", length));
            String[] orgDestRgnAllNm = (JSPUtil.getParameter(request, prefix + "org_dest_rgn_all_nm", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix + "cvrg_rgn_cd", length));
            String[] rtChk = (JSPUtil.getParameter(request, prefix + "rt_chk", length));
            String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix + "org_dest_conti_cd", length));
            String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", length));
            String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] viewCvrgCmbSeq = (JSPUtil.getParameter(request, prefix + "view_cvrg_cmb_seq", length));
            String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", length));
            String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", length));
            String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
            String[] fnlDestContiCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_conti_cd", length));
            String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_cd", length));
            String[] fnlDestCntAllNm = (JSPUtil.getParameter(request, prefix + "fnl_dest_cnt_all_nm", length));
            String[] orgDestCntAllCd = (JSPUtil.getParameter(request, prefix + "org_dest_cnt_all_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] cvrgCntAllNm = (JSPUtil.getParameter(request, prefix + "cvrg_cnt_all_nm", length));
            String[] fullExptTrfRmk = (JSPUtil.getParameter(request, prefix + "full_expt_trf_rmk", length));
            String[] cvrgRgnAllCd = (JSPUtil.getParameter(request, prefix + "cvrg_rgn_all_cd", length));
            String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", length));
            String[] fnlDestCntCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_cnt_cd", length));
            String[] addDys = (JSPUtil.getParameter(request, prefix + "add_dys", length));
            String[] viewVerSeq = (JSPUtil.getParameter(request, prefix + "view_ver_seq", length));
            String[] fnlDestLocCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_loc_cd", length));
            String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", length));
            String[] fnlDestSteCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_ste_cd", length));
            String[] repCmdtCd = (JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", length));
            String[] fnlDestCntAllCd = (JSPUtil.getParameter(request, prefix + "fnl_dest_cnt_all_cd", length));
            String[] ftTir = (JSPUtil.getParameter(request, prefix + "ft_tir", length));
	    	String[] cmdtFlg = (JSPUtil.getParameter(request, prefix + "cmdt_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BeforeExceptionVO();
                if (xcldSatFlg[i] != null)
                    model.setXcldSatFlg(xcldSatFlg[i]);
                if (xcldSunFlg[i] != null)
                    model.setXcldSunFlg(xcldSunFlg[i]);
                if (cvrgCmbSeq[i] != null)
                    model.setCvrgCmbSeq(cvrgCmbSeq[i]);
                if (cvrgRgnAllNm[i] != null)
                    model.setCvrgRgnAllNm(cvrgRgnAllNm[i]);
                if (rtChkFlg[i] != null)
                    model.setRtChkFlg(rtChkFlg[i]);
                if (dmdtCntrCgoTpTxt[i] != null)
                    model.setDmdtCntrCgoTpTxt(dmdtCntrCgoTpTxt[i]);
                if (n1stCmncVerSeq[i] != null)
                    model.setN1stCmncVerSeq(n1stCmncVerSeq[i]);
                if (exptTrfRmk[i] != null)
                    model.setExptTrfRmk(exptTrfRmk[i]);
                if (ftUseFlg[i] != null)
                    model.setFtUseFlg(ftUseFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (cvrgSteCd[i] != null)
                    model.setCvrgSteCd(cvrgSteCd[i]);
                if (rfaExptDarNo[i] != null)
                    model.setRfaExptDarNo(rfaExptDarNo[i]);
                if (orgDestRgnCd[i] != null)
                    model.setOrgDestRgnCd(orgDestRgnCd[i]);
                if (cvrgCntCd[i] != null)
                    model.setCvrgCntCd(cvrgCntCd[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updOfcCd[i] != null)
                    model.setUpdOfcCd(updOfcCd[i]);
                if (orgDestMulti[i] != null)
                    model.setOrgDestMulti(orgDestMulti[i]);
                if (dmdtCntrCgoTpCd[i] != null)
                    model.setDmdtCntrCgoTpCd(dmdtCntrCgoTpCd[i]);
                if (orgDestCntAllNm[i] != null)
                    model.setOrgDestCntAllNm(orgDestCntAllNm[i]);
                if (orgDestLocCd[i] != null)
                    model.setOrgDestLocCd(orgDestLocCd[i]);
                if (orgDestSteCd[i] != null)
                    model.setOrgDestSteCd(orgDestSteCd[i]);
                if (cvrgCntAllCd[i] != null)
                    model.setCvrgCntAllCd(cvrgCntAllCd[i]);
                if (ttlDys[i] != null)
                    model.setTtlDys(ttlDys[i]);
                if (orgDestRgnAllCd[i] != null)
                    model.setOrgDestRgnAllCd(orgDestRgnAllCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (cvrgContiCd[i] != null)
                    model.setCvrgContiCd(cvrgContiCd[i]);
                if (orgDestCntCd[i] != null)
                    model.setOrgDestCntCd(orgDestCntCd[i]);
                if (xcldHolFlg[i] != null)
                    model.setXcldHolFlg(xcldHolFlg[i]);
                if (currOrgDestMulti[i] != null)
                    model.setCurrOrgDestMulti(currOrgDestMulti[i]);
                if (fnlDestRgnAllCd[i] != null)
                    model.setFnlDestRgnAllCd(fnlDestRgnAllCd[i]);
                if (cvrgLocCd[i] != null)
                    model.setCvrgLocCd(cvrgLocCd[i]);
                if (rtUseFlg[i] != null)
                    model.setRtUseFlg(rtUseFlg[i]);
                if (fnlDestFlg[i] != null)
                    model.setFnlDestFlg(fnlDestFlg[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (fnlDestRgnAllNm[i] != null)
                    model.setFnlDestRgnAllNm(fnlDestRgnAllNm[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (fnlDestRgnCd[i] != null)
                    model.setFnlDestRgnCd(fnlDestRgnCd[i]);
                if (orgDestRgnAllNm[i] != null)
                    model.setOrgDestRgnAllNm(orgDestRgnAllNm[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cvrgRgnCd[i] != null)
                    model.setCvrgRgnCd(cvrgRgnCd[i]);
                if (rtChk[i] != null)
                    model.setRtChk(rtChk[i]);
                if (orgDestContiCd[i] != null)
                    model.setOrgDestContiCd(orgDestContiCd[i]);
                if (dmdtExptRqstStsCd[i] != null)
                    model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
                if (rfaExptMapgSeq[i] != null)
                    model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (viewCvrgCmbSeq[i] != null)
                    model.setViewCvrgCmbSeq(viewCvrgCmbSeq[i]);
                if (rfaRqstDtlSeq[i] != null)
                    model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
                if (rfaExptVerSeq[i] != null)
                    model.setRfaExptVerSeq(rfaExptVerSeq[i]);
                if (expDt[i] != null)
                    model.setExpDt(expDt[i]);
                if (fnlDestContiCd[i] != null)
                    model.setFnlDestContiCd(fnlDestContiCd[i]);
                if (dmdtCgoTpCd[i] != null)
                    model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
                if (fnlDestCntAllNm[i] != null)
                    model.setFnlDestCntAllNm(fnlDestCntAllNm[i]);
                if (orgDestCntAllCd[i] != null)
                    model.setOrgDestCntAllCd(orgDestCntAllCd[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (cvrgCntAllNm[i] != null)
                    model.setCvrgCntAllNm(cvrgCntAllNm[i]);
                if (fullExptTrfRmk[i] != null)
                    model.setFullExptTrfRmk(fullExptTrfRmk[i]);
                if (cvrgRgnAllCd[i] != null)
                    model.setCvrgRgnAllCd(cvrgRgnAllCd[i]);
                if (dmdtCntrTpCd[i] != null)
                    model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
                if (fnlDestCntCd[i] != null)
                    model.setFnlDestCntCd(fnlDestCntCd[i]);
                if (addDys[i] != null)
                    model.setAddDys(addDys[i]);
                if (viewVerSeq[i] != null)
                    model.setViewVerSeq(viewVerSeq[i]);
                if (fnlDestLocCd[i] != null)
                    model.setFnlDestLocCd(fnlDestLocCd[i]);
                if (rqstOfcCd[i] != null)
                    model.setRqstOfcCd(rqstOfcCd[i]);
                if (fnlDestSteCd[i] != null)
                    model.setFnlDestSteCd(fnlDestSteCd[i]);
                if (repCmdtCd[i] != null)
                    model.setRepCmdtCd(repCmdtCd[i]);
                if (fnlDestCntAllCd[i] != null)
                    model.setFnlDestCntAllCd(fnlDestCntAllCd[i]);
                if (ftTir[i] != null) 
		    		model.setFtTir(ftTir[i]);
				if (cmdtFlg[i] != null) 
		    		model.setCmdtFlg(cmdtFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBeforeExceptionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BeforeExceptionVO[]
	 */
    public BeforeExceptionVO[] getBeforeExceptionVOs() {
        BeforeExceptionVO[] vos = (BeforeExceptionVO[]) models.toArray(new BeforeExceptionVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.xcldSatFlg = this.xcldSatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xcldSunFlg = this.xcldSunFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgCmbSeq = this.cvrgCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgRgnAllNm = this.cvrgRgnAllNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtChkFlg = this.rtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCntrCgoTpTxt = this.dmdtCntrCgoTpTxt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stCmncVerSeq = this.n1stCmncVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exptTrfRmk = this.exptTrfRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftUseFlg = this.ftUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgSteCd = this.cvrgSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaExptDarNo = this.rfaExptDarNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestRgnCd = this.orgDestRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgCntCd = this.cvrgCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestMulti = this.orgDestMulti.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCntrCgoTpCd = this.dmdtCntrCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestCntAllNm = this.orgDestCntAllNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestLocCd = this.orgDestLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestSteCd = this.orgDestSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgCntAllCd = this.cvrgCntAllCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDys = this.ttlDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestRgnAllCd = this.orgDestRgnAllCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgContiCd = this.cvrgContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestCntCd = this.orgDestCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xcldHolFlg = this.xcldHolFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currOrgDestMulti = this.currOrgDestMulti.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestRgnAllCd = this.fnlDestRgnAllCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgLocCd = this.cvrgLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtUseFlg = this.rtUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestFlg = this.fnlDestFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestRgnAllNm = this.fnlDestRgnAllNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestRgnCd = this.fnlDestRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestRgnAllNm = this.orgDestRgnAllNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgRgnCd = this.cvrgRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtChk = this.rtChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestContiCd = this.orgDestContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaExptMapgSeq = this.rfaExptMapgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.viewCvrgCmbSeq = this.viewCvrgCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaRqstDtlSeq = this.rfaRqstDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaExptVerSeq = this.rfaExptVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestContiCd = this.fnlDestContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCgoTpCd = this.dmdtCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestCntAllNm = this.fnlDestCntAllNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDestCntAllCd = this.orgDestCntAllCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgCntAllNm = this.cvrgCntAllNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullExptTrfRmk = this.fullExptTrfRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvrgRgnAllCd = this.cvrgRgnAllCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCntrTpCd = this.dmdtCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestCntCd = this.fnlDestCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addDys = this.addDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.viewVerSeq = this.viewVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestLocCd = this.fnlDestLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestSteCd = this.fnlDestSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCmdtCd = this.repCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestCntAllCd = this.fnlDestCntAllCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftTir = this.ftTir.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtFlg = this.cmdtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
