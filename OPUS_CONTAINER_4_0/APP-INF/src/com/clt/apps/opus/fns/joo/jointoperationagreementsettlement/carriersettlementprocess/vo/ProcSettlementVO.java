/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProcSettlementVO.java
*@FileTitle : ProcSettlementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
public class ProcSettlementVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ProcSettlementVO> models = new ArrayList<ProcSettlementVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String stlAdjFlg = null;

    /* Column Info */
    private String etaDt = null;

    /* Column Info */
    private String slipNo = null;

    /* Column Info */
    private String fmPortCd = null;

    /* Column Info */
    private String preAcctYrmon = null;

    /* Column Info */
    private String dupFlg = null;

    /* Column Info */
    private String stlUsdAmt = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String cxlVvdFlg = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String usdSltWgt = null;

    /* Column Info */
    private String usdSltBsaQty = null;

    /* Column Info */
    private String stlBzcPortCd = null;

    /* Column Info */
    private String rvsCmbFlg = null;

    /* Column Info */
    private String stlLstFlg = null;

    /* Column Info */
    private String ucBssPortEtdDt = null;

    /* Column Info */
    private String rfScgStlTpCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String preStlVvdSeq = null;

    /* Column Info */
    private String adjBsaSltPrcLoclAmt = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String fnlOwnBsaQty = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String acctYrmon = null;

    /* Column Info */
    private String bsaSltPrc = null;

    /* Column Info */
    private String rfScgPrc = null;

    /* Column Info */
    private String toPortCd = null;

    /* Column Info */
    private String joStlJbCd = null;

    /* Column Info */
    private String stlCmbSeq = null;

    /* Column Info */
    private String bsaQty = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String stlTjNo = null;

    /* Column Info */
    private String revDirCd = null;

    /* Column Info */
    private String stlDupFlg = null;

    /* Column Info */
    private String ucBssPortCd = null;

    /* Column Info */
    private String stlLoclAmt = null;

    /* Column Info */
    private String joMnuNm = null;

    /* Column Info */
    private String cmbCfmFlg = null;

    /* Column Info */
    private String stlVvdSeq = null;

    /* Column Info */
    private String bsaPerWgt = null;

    /* Column Info */
    private String stlRmk = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String stlSeq = null;

    /* Column Info */
    private String iocCd = null;

    /* Column Info */
    private String preStlSeq = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String fnlBsaWgt = null;

    /* Column Info */
    private String adjBsaQtyLoclAmt = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String scontiCd = null;

    /* Column Info */
    private String stDt = null;

    /* Column Info */
    private String endDt = null;

    /* Column Info */
    private String sailDys = null;

    /* Column Info */
    private String g6gaYn = null;

    /* Column Info */
    private String schTpCd = null;

    /* Column Info */
    private String tmpSchTpCd = null;

    /* Column Info */
    private String tmpFmPortCd = null;

    /* Column Info */
    private String tmpToPortCd = null;

    /* Column Info */
    private String tmpStDt = null;

    /* Column Info */
    private String tmpEndDt = null;

    /* Column Info */
    private String tmpSailDys = null;

    /* Column Info */
    private String addJoStlItmCd = null;

    /* Column Info */
    private String addJoMnuNm = null;

    /* Column Info */
    private String depPortCd = null;

    /* Column Info */
    private String teuWgt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ProcSettlementVO() {
    }

    public ProcSettlementVO(String ibflag, String pagerows, String vslCd, String stlAdjFlg, String etaDt, String slipNo, String fmPortCd, String preAcctYrmon, String dupFlg, String stlUsdAmt, String trdCd, String rlaneCd, String cxlVvdFlg, String joStlItmCd, String usdSltWgt, String usdSltBsaQty, String stlBzcPortCd, String rvsCmbFlg, String stlLstFlg, String ucBssPortEtdDt, String rfScgStlTpCd, String updUsrId, String preStlVvdSeq, String adjBsaSltPrcLoclAmt, String loclCurrCd, String fnlOwnBsaQty, String skdVoyNo, String creUsrId, String acctYrmon, String bsaSltPrc, String rfScgPrc, String toPortCd, String joStlJbCd, String stlCmbSeq, String bsaQty, String creDt, String stlTjNo, String revDirCd, String stlDupFlg, String ucBssPortCd, String stlLoclAmt, String joMnuNm, String cmbCfmFlg, String stlVvdSeq, String bsaPerWgt, String stlRmk, String updDt, String stlSeq, String iocCd, String preStlSeq, String joCrrCd, String skdDirCd, String fnlBsaWgt, String adjBsaQtyLoclAmt, String reDivrCd, String scontiCd, String stDt, String endDt, String sailDys, String g6gaYn, String schTpCd, String tmpSchTpCd, String tmpFmPortCd, String tmpToPortCd, String tmpStDt, String tmpEndDt, String tmpSailDys, String addJoStlItmCd, String addJoMnuNm, String depPortCd, String teuWgt) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslCd = vslCd;
        this.stlAdjFlg = stlAdjFlg;
        this.etaDt = etaDt;
        this.slipNo = slipNo;
        this.fmPortCd = fmPortCd;
        this.preAcctYrmon = preAcctYrmon;
        this.dupFlg = dupFlg;
        this.stlUsdAmt = stlUsdAmt;
        this.trdCd = trdCd;
        this.rlaneCd = rlaneCd;
        this.cxlVvdFlg = cxlVvdFlg;
        this.joStlItmCd = joStlItmCd;
        this.usdSltWgt = usdSltWgt;
        this.usdSltBsaQty = usdSltBsaQty;
        this.stlBzcPortCd = stlBzcPortCd;
        this.rvsCmbFlg = rvsCmbFlg;
        this.stlLstFlg = stlLstFlg;
        this.ucBssPortEtdDt = ucBssPortEtdDt;
        this.rfScgStlTpCd = rfScgStlTpCd;
        this.updUsrId = updUsrId;
        this.preStlVvdSeq = preStlVvdSeq;
        this.adjBsaSltPrcLoclAmt = adjBsaSltPrcLoclAmt;
        this.loclCurrCd = loclCurrCd;
        this.fnlOwnBsaQty = fnlOwnBsaQty;
        this.skdVoyNo = skdVoyNo;
        this.creUsrId = creUsrId;
        this.acctYrmon = acctYrmon;
        this.bsaSltPrc = bsaSltPrc;
        this.rfScgPrc = rfScgPrc;
        this.toPortCd = toPortCd;
        this.joStlJbCd = joStlJbCd;
        this.stlCmbSeq = stlCmbSeq;
        this.bsaQty = bsaQty;
        this.creDt = creDt;
        this.stlTjNo = stlTjNo;
        this.revDirCd = revDirCd;
        this.stlDupFlg = stlDupFlg;
        this.ucBssPortCd = ucBssPortCd;
        this.stlLoclAmt = stlLoclAmt;
        this.joMnuNm = joMnuNm;
        this.cmbCfmFlg = cmbCfmFlg;
        this.stlVvdSeq = stlVvdSeq;
        this.bsaPerWgt = bsaPerWgt;
        this.stlRmk = stlRmk;
        this.updDt = updDt;
        this.stlSeq = stlSeq;
        this.iocCd = iocCd;
        this.preStlSeq = preStlSeq;
        this.joCrrCd = joCrrCd;
        this.skdDirCd = skdDirCd;
        this.fnlBsaWgt = fnlBsaWgt;
        this.adjBsaQtyLoclAmt = adjBsaQtyLoclAmt;
        this.reDivrCd = reDivrCd;
        this.scontiCd = scontiCd;
        this.stDt = stDt;
        this.endDt = endDt;
        this.sailDys = sailDys;
        this.g6gaYn = g6gaYn;
        this.schTpCd = schTpCd;
        this.tmpSchTpCd = tmpSchTpCd;
        this.tmpFmPortCd = tmpFmPortCd;
        this.tmpToPortCd = tmpToPortCd;
        this.tmpStDt = tmpStDt;
        this.tmpEndDt = tmpEndDt;
        this.tmpSailDys = tmpSailDys;
        this.addJoStlItmCd = addJoStlItmCd;
        this.addJoMnuNm = addJoMnuNm;
        this.depPortCd = depPortCd;
        this.teuWgt = teuWgt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("stl_adj_flg", getStlAdjFlg());
        this.hashColumns.put("eta_dt", getEtaDt());
        this.hashColumns.put("slip_no", getSlipNo());
        this.hashColumns.put("fm_port_cd", getFmPortCd());
        this.hashColumns.put("pre_acct_yrmon", getPreAcctYrmon());
        this.hashColumns.put("dup_flg", getDupFlg());
        this.hashColumns.put("stl_usd_amt", getStlUsdAmt());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("cxl_vvd_flg", getCxlVvdFlg());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("usd_slt_wgt", getUsdSltWgt());
        this.hashColumns.put("usd_slt_bsa_qty", getUsdSltBsaQty());
        this.hashColumns.put("stl_bzc_port_cd", getStlBzcPortCd());
        this.hashColumns.put("rvs_cmb_flg", getRvsCmbFlg());
        this.hashColumns.put("stl_lst_flg", getStlLstFlg());
        this.hashColumns.put("uc_bss_port_etd_dt", getUcBssPortEtdDt());
        this.hashColumns.put("rf_scg_stl_tp_cd", getRfScgStlTpCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("pre_stl_vvd_seq", getPreStlVvdSeq());
        this.hashColumns.put("adj_bsa_slt_prc_locl_amt", getAdjBsaSltPrcLoclAmt());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("fnl_own_bsa_qty", getFnlOwnBsaQty());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
        this.hashColumns.put("rf_scg_prc", getRfScgPrc());
        this.hashColumns.put("to_port_cd", getToPortCd());
        this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
        this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
        this.hashColumns.put("bsa_qty", getBsaQty());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("stl_tj_no", getStlTjNo());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("stl_dup_flg", getStlDupFlg());
        this.hashColumns.put("uc_bss_port_cd", getUcBssPortCd());
        this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
        this.hashColumns.put("jo_mnu_nm", getJoMnuNm());
        this.hashColumns.put("cmb_cfm_flg", getCmbCfmFlg());
        this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
        this.hashColumns.put("bsa_per_wgt", getBsaPerWgt());
        this.hashColumns.put("stl_rmk", getStlRmk());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("stl_seq", getStlSeq());
        this.hashColumns.put("ioc_cd", getIocCd());
        this.hashColumns.put("pre_stl_seq", getPreStlSeq());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("fnl_bsa_wgt", getFnlBsaWgt());
        this.hashColumns.put("adj_bsa_qty_locl_amt", getAdjBsaQtyLoclAmt());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("sconti_cd", getScontiCd());
        this.hashColumns.put("st_dt", getStDt());
        this.hashColumns.put("end_dt", getEndDt());
        this.hashColumns.put("sail_dys", getSailDys());
        this.hashColumns.put("g6ga_yn", getG6gaYn());
        this.hashColumns.put("sch_tp_cd", getSchTpCd());
        this.hashColumns.put("tmp_sch_tp_cd", getTmpSchTpCd());
        this.hashColumns.put("tmp_fm_port_cd", getTmpFmPortCd());
        this.hashColumns.put("tmp_to_port_cd", getTmpToPortCd());
        this.hashColumns.put("tmp_st_dt", getTmpStDt());
        this.hashColumns.put("tmp_end_dt", getTmpEndDt());
        this.hashColumns.put("tmp_sail_dys", getTmpSailDys());
        this.hashColumns.put("add_jo_stl_itm_cd", getAddJoStlItmCd());
        this.hashColumns.put("add_jo_mnu_nm", getAddJoMnuNm());
        this.hashColumns.put("dep_port_cd", getDepPortCd());
        this.hashColumns.put("teu_wgt", getTeuWgt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("stl_adj_flg", "stlAdjFlg");
        this.hashFields.put("eta_dt", "etaDt");
        this.hashFields.put("slip_no", "slipNo");
        this.hashFields.put("fm_port_cd", "fmPortCd");
        this.hashFields.put("pre_acct_yrmon", "preAcctYrmon");
        this.hashFields.put("dup_flg", "dupFlg");
        this.hashFields.put("stl_usd_amt", "stlUsdAmt");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("cxl_vvd_flg", "cxlVvdFlg");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("usd_slt_wgt", "usdSltWgt");
        this.hashFields.put("usd_slt_bsa_qty", "usdSltBsaQty");
        this.hashFields.put("stl_bzc_port_cd", "stlBzcPortCd");
        this.hashFields.put("rvs_cmb_flg", "rvsCmbFlg");
        this.hashFields.put("stl_lst_flg", "stlLstFlg");
        this.hashFields.put("uc_bss_port_etd_dt", "ucBssPortEtdDt");
        this.hashFields.put("rf_scg_stl_tp_cd", "rfScgStlTpCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("pre_stl_vvd_seq", "preStlVvdSeq");
        this.hashFields.put("adj_bsa_slt_prc_locl_amt", "adjBsaSltPrcLoclAmt");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("fnl_own_bsa_qty", "fnlOwnBsaQty");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
        this.hashFields.put("rf_scg_prc", "rfScgPrc");
        this.hashFields.put("to_port_cd", "toPortCd");
        this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
        this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
        this.hashFields.put("bsa_qty", "bsaQty");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("stl_tj_no", "stlTjNo");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("stl_dup_flg", "stlDupFlg");
        this.hashFields.put("uc_bss_port_cd", "ucBssPortCd");
        this.hashFields.put("stl_locl_amt", "stlLoclAmt");
        this.hashFields.put("jo_mnu_nm", "joMnuNm");
        this.hashFields.put("cmb_cfm_flg", "cmbCfmFlg");
        this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
        this.hashFields.put("bsa_per_wgt", "bsaPerWgt");
        this.hashFields.put("stl_rmk", "stlRmk");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("stl_seq", "stlSeq");
        this.hashFields.put("ioc_cd", "iocCd");
        this.hashFields.put("pre_stl_seq", "preStlSeq");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("fnl_bsa_wgt", "fnlBsaWgt");
        this.hashFields.put("adj_bsa_qty_locl_amt", "adjBsaQtyLoclAmt");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("sconti_cd", "scontiCd");
        this.hashFields.put("st_dt", "stDt");
        this.hashFields.put("end_dt", "endDt");
        this.hashFields.put("sail_dys", "sailDys");
        this.hashFields.put("g6ga_yn", "g6gaYn");
        this.hashFields.put("sch_tp_cd", "schTpCd");
        this.hashFields.put("tmp_sch_tp_cd", "tmpSchTpCd");
        this.hashFields.put("tmp_fm_port_cd", "tmpFmPortCd");
        this.hashFields.put("tmp_to_port_cd", "tmpToPortCd");
        this.hashFields.put("tmp_st_dt", "tmpStDt");
        this.hashFields.put("tmp_end_dt", "tmpEndDt");
        this.hashFields.put("tmp_sail_dys", "tmpSailDys");
        this.hashFields.put("add_jo_stl_itm_cd", "addJoStlItmCd");
        this.hashFields.put("add_jo_mnu_nm", "addJoMnuNm");
        this.hashFields.put("dep_port_cd", "depPortCd");
        this.hashFields.put("teu_wgt", "teuWgt");
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
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String stlAdjFlg
	 */
    public void setStlAdjFlg(String stlAdjFlg) {
        this.stlAdjFlg = stlAdjFlg;
    }

    /**
	 * 
	 * @return String stlAdjFlg
	 */
    public String getStlAdjFlg() {
        return this.stlAdjFlg;
    }

    /**
	 *
	 * @param String etaDt
	 */
    public void setEtaDt(String etaDt) {
        this.etaDt = etaDt;
    }

    /**
	 * 
	 * @return String etaDt
	 */
    public String getEtaDt() {
        return this.etaDt;
    }

    /**
	 *
	 * @param String slipNo
	 */
    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    /**
	 * 
	 * @return String slipNo
	 */
    public String getSlipNo() {
        return this.slipNo;
    }

    /**
	 *
	 * @param String fmPortCd
	 */
    public void setFmPortCd(String fmPortCd) {
        this.fmPortCd = fmPortCd;
    }

    /**
	 * 
	 * @return String fmPortCd
	 */
    public String getFmPortCd() {
        return this.fmPortCd;
    }

    /**
	 *
	 * @param String preAcctYrmon
	 */
    public void setPreAcctYrmon(String preAcctYrmon) {
        this.preAcctYrmon = preAcctYrmon;
    }

    /**
	 * 
	 * @return String preAcctYrmon
	 */
    public String getPreAcctYrmon() {
        return this.preAcctYrmon;
    }

    /**
	 *
	 * @param String dupFlg
	 */
    public void setDupFlg(String dupFlg) {
        this.dupFlg = dupFlg;
    }

    /**
	 * 
	 * @return String dupFlg
	 */
    public String getDupFlg() {
        return this.dupFlg;
    }

    /**
	 *
	 * @param String stlUsdAmt
	 */
    public void setStlUsdAmt(String stlUsdAmt) {
        this.stlUsdAmt = stlUsdAmt;
    }

    /**
	 * 
	 * @return String stlUsdAmt
	 */
    public String getStlUsdAmt() {
        return this.stlUsdAmt;
    }

    /**
	 *
	 * @param String trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * 
	 * @return String trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 *
	 * @param String rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * 
	 * @return String rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 *
	 * @param String cxlVvdFlg
	 */
    public void setCxlVvdFlg(String cxlVvdFlg) {
        this.cxlVvdFlg = cxlVvdFlg;
    }

    /**
	 * 
	 * @return String cxlVvdFlg
	 */
    public String getCxlVvdFlg() {
        return this.cxlVvdFlg;
    }

    /**
	 *
	 * @param String joStlItmCd
	 */
    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    /**
	 * 
	 * @return String joStlItmCd
	 */
    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    /**
	 *
	 * @param String usdSltWgt
	 */
    public void setUsdSltWgt(String usdSltWgt) {
        this.usdSltWgt = usdSltWgt;
    }

    /**
	 * 
	 * @return String usdSltWgt
	 */
    public String getUsdSltWgt() {
        return this.usdSltWgt;
    }

    /**
	 *
	 * @param String usdSltBsaQty
	 */
    public void setUsdSltBsaQty(String usdSltBsaQty) {
        this.usdSltBsaQty = usdSltBsaQty;
    }

    /**
	 * 
	 * @return String usdSltBsaQty
	 */
    public String getUsdSltBsaQty() {
        return this.usdSltBsaQty;
    }

    /**
	 *
	 * @param String stlBzcPortCd
	 */
    public void setStlBzcPortCd(String stlBzcPortCd) {
        this.stlBzcPortCd = stlBzcPortCd;
    }

    /**
	 * 
	 * @return String stlBzcPortCd
	 */
    public String getStlBzcPortCd() {
        return this.stlBzcPortCd;
    }

    /**
	 *
	 * @param String rvsCmbFlg
	 */
    public void setRvsCmbFlg(String rvsCmbFlg) {
        this.rvsCmbFlg = rvsCmbFlg;
    }

    /**
	 * 
	 * @return String rvsCmbFlg
	 */
    public String getRvsCmbFlg() {
        return this.rvsCmbFlg;
    }

    /**
	 *
	 * @param String stlLstFlg
	 */
    public void setStlLstFlg(String stlLstFlg) {
        this.stlLstFlg = stlLstFlg;
    }

    /**
	 * 
	 * @return String stlLstFlg
	 */
    public String getStlLstFlg() {
        return this.stlLstFlg;
    }

    /**
	 *
	 * @param String ucBssPortEtdDt
	 */
    public void setUcBssPortEtdDt(String ucBssPortEtdDt) {
        this.ucBssPortEtdDt = ucBssPortEtdDt;
    }

    /**
	 * 
	 * @return String ucBssPortEtdDt
	 */
    public String getUcBssPortEtdDt() {
        return this.ucBssPortEtdDt;
    }

    /**
	 *
	 * @param String rfScgStlTpCd
	 */
    public void setRfScgStlTpCd(String rfScgStlTpCd) {
        this.rfScgStlTpCd = rfScgStlTpCd;
    }

    /**
	 * 
	 * @return String rfScgStlTpCd
	 */
    public String getRfScgStlTpCd() {
        return this.rfScgStlTpCd;
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
	 * @param String preStlVvdSeq
	 */
    public void setPreStlVvdSeq(String preStlVvdSeq) {
        this.preStlVvdSeq = preStlVvdSeq;
    }

    /**
	 * 
	 * @return String preStlVvdSeq
	 */
    public String getPreStlVvdSeq() {
        return this.preStlVvdSeq;
    }

    /**
	 *
	 * @param String adjBsaSltPrcLoclAmt
	 */
    public void setAdjBsaSltPrcLoclAmt(String adjBsaSltPrcLoclAmt) {
        this.adjBsaSltPrcLoclAmt = adjBsaSltPrcLoclAmt;
    }

    /**
	 * 
	 * @return String adjBsaSltPrcLoclAmt
	 */
    public String getAdjBsaSltPrcLoclAmt() {
        return this.adjBsaSltPrcLoclAmt;
    }

    /**
	 *
	 * @param String loclCurrCd
	 */
    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 
	 * @return String loclCurrCd
	 */
    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    /**
	 *
	 * @param String fnlOwnBsaQty
	 */
    public void setFnlOwnBsaQty(String fnlOwnBsaQty) {
        this.fnlOwnBsaQty = fnlOwnBsaQty;
    }

    /**
	 * 
	 * @return String fnlOwnBsaQty
	 */
    public String getFnlOwnBsaQty() {
        return this.fnlOwnBsaQty;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
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
	 * @param String acctYrmon
	 */
    public void setAcctYrmon(String acctYrmon) {
        this.acctYrmon = acctYrmon;
    }

    /**
	 * 
	 * @return String acctYrmon
	 */
    public String getAcctYrmon() {
        return this.acctYrmon;
    }

    /**
	 *
	 * @param String bsaSltPrc
	 */
    public void setBsaSltPrc(String bsaSltPrc) {
        this.bsaSltPrc = bsaSltPrc;
    }

    /**
	 * 
	 * @return String bsaSltPrc
	 */
    public String getBsaSltPrc() {
        return this.bsaSltPrc;
    }

    /**
	 *
	 * @param String rfScgPrc
	 */
    public void setRfScgPrc(String rfScgPrc) {
        this.rfScgPrc = rfScgPrc;
    }

    /**
	 * 
	 * @return String rfScgPrc
	 */
    public String getRfScgPrc() {
        return this.rfScgPrc;
    }

    /**
	 *
	 * @param String toPortCd
	 */
    public void setToPortCd(String toPortCd) {
        this.toPortCd = toPortCd;
    }

    /**
	 * 
	 * @return String toPortCd
	 */
    public String getToPortCd() {
        return this.toPortCd;
    }

    /**
	 *
	 * @param String joStlJbCd
	 */
    public void setJoStlJbCd(String joStlJbCd) {
        this.joStlJbCd = joStlJbCd;
    }

    /**
	 * 
	 * @return String joStlJbCd
	 */
    public String getJoStlJbCd() {
        return this.joStlJbCd;
    }

    /**
	 *
	 * @param String stlCmbSeq
	 */
    public void setStlCmbSeq(String stlCmbSeq) {
        this.stlCmbSeq = stlCmbSeq;
    }

    /**
	 * 
	 * @return String stlCmbSeq
	 */
    public String getStlCmbSeq() {
        return this.stlCmbSeq;
    }

    /**
	 *
	 * @param String bsaQty
	 */
    public void setBsaQty(String bsaQty) {
        this.bsaQty = bsaQty;
    }

    /**
	 * 
	 * @return String bsaQty
	 */
    public String getBsaQty() {
        return this.bsaQty;
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
	 * @param String stlTjNo
	 */
    public void setStlTjNo(String stlTjNo) {
        this.stlTjNo = stlTjNo;
    }

    /**
	 * 
	 * @return String stlTjNo
	 */
    public String getStlTjNo() {
        return this.stlTjNo;
    }

    /**
	 *
	 * @param String revDirCd
	 */
    public void setRevDirCd(String revDirCd) {
        this.revDirCd = revDirCd;
    }

    /**
	 * 
	 * @return String revDirCd
	 */
    public String getRevDirCd() {
        return this.revDirCd;
    }

    /**
	 *
	 * @param String stlDupFlg
	 */
    public void setStlDupFlg(String stlDupFlg) {
        this.stlDupFlg = stlDupFlg;
    }

    /**
	 * 
	 * @return String stlDupFlg
	 */
    public String getStlDupFlg() {
        return this.stlDupFlg;
    }

    /**
	 *
	 * @param String ucBssPortCd
	 */
    public void setUcBssPortCd(String ucBssPortCd) {
        this.ucBssPortCd = ucBssPortCd;
    }

    /**
	 * 
	 * @return String ucBssPortCd
	 */
    public String getUcBssPortCd() {
        return this.ucBssPortCd;
    }

    /**
	 *
	 * @param String stlLoclAmt
	 */
    public void setStlLoclAmt(String stlLoclAmt) {
        this.stlLoclAmt = stlLoclAmt;
    }

    /**
	 * 
	 * @return String stlLoclAmt
	 */
    public String getStlLoclAmt() {
        return this.stlLoclAmt;
    }

    /**
	 *
	 * @param String joMnuNm
	 */
    public void setJoMnuNm(String joMnuNm) {
        this.joMnuNm = joMnuNm;
    }

    /**
	 * 
	 * @return String joMnuNm
	 */
    public String getJoMnuNm() {
        return this.joMnuNm;
    }

    /**
	 *
	 * @param String cmbCfmFlg
	 */
    public void setCmbCfmFlg(String cmbCfmFlg) {
        this.cmbCfmFlg = cmbCfmFlg;
    }

    /**
	 * 
	 * @return String cmbCfmFlg
	 */
    public String getCmbCfmFlg() {
        return this.cmbCfmFlg;
    }

    /**
	 *
	 * @param String stlVvdSeq
	 */
    public void setStlVvdSeq(String stlVvdSeq) {
        this.stlVvdSeq = stlVvdSeq;
    }

    /**
	 * 
	 * @return String stlVvdSeq
	 */
    public String getStlVvdSeq() {
        return this.stlVvdSeq;
    }

    /**
	 *
	 * @param String bsaPerWgt
	 */
    public void setBsaPerWgt(String bsaPerWgt) {
        this.bsaPerWgt = bsaPerWgt;
    }

    /**
	 * 
	 * @return String bsaPerWgt
	 */
    public String getBsaPerWgt() {
        return this.bsaPerWgt;
    }

    /**
	 *
	 * @param String stlRmk
	 */
    public void setStlRmk(String stlRmk) {
        this.stlRmk = stlRmk;
    }

    /**
	 * 
	 * @return String stlRmk
	 */
    public String getStlRmk() {
        return this.stlRmk;
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
	 * @param String stlSeq
	 */
    public void setStlSeq(String stlSeq) {
        this.stlSeq = stlSeq;
    }

    /**
	 * 
	 * @return String stlSeq
	 */
    public String getStlSeq() {
        return this.stlSeq;
    }

    /**
	 *
	 * @param String iocCd
	 */
    public void setIocCd(String iocCd) {
        this.iocCd = iocCd;
    }

    /**
	 * 
	 * @return String iocCd
	 */
    public String getIocCd() {
        return this.iocCd;
    }

    /**
	 *
	 * @param String preStlSeq
	 */
    public void setPreStlSeq(String preStlSeq) {
        this.preStlSeq = preStlSeq;
    }

    /**
	 * 
	 * @return String preStlSeq
	 */
    public String getPreStlSeq() {
        return this.preStlSeq;
    }

    /**
	 *
	 * @param String joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * 
	 * @return String joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String fnlBsaWgt
	 */
    public void setFnlBsaWgt(String fnlBsaWgt) {
        this.fnlBsaWgt = fnlBsaWgt;
    }

    /**
	 * 
	 * @return String fnlBsaWgt
	 */
    public String getFnlBsaWgt() {
        return this.fnlBsaWgt;
    }

    /**
	 *
	 * @param String adjBsaQtyLoclAmt
	 */
    public void setAdjBsaQtyLoclAmt(String adjBsaQtyLoclAmt) {
        this.adjBsaQtyLoclAmt = adjBsaQtyLoclAmt;
    }

    /**
	 * 
	 * @return String adjBsaQtyLoclAmt
	 */
    public String getAdjBsaQtyLoclAmt() {
        return this.adjBsaQtyLoclAmt;
    }

    /**
	 *
	 * @param String reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * 
	 * @return String reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 *
	 * @param String scontiCd
	 */
    public void setScontiCd(String scontiCd) {
        this.scontiCd = scontiCd;
    }

    /**
	 * 
	 * @return String scontiCd
	 */
    public String getScontiCd() {
        return this.scontiCd;
    }

    /**
	 *
	 * @param String stDt
	 */
    public void setStDt(String stDt) {
        this.stDt = stDt;
    }

    /**
	 * 
	 * @return String stDt
	 */
    public String getStDt() {
        return this.stDt;
    }

    /**
	 *
	 * @param String endDt
	 */
    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    /**
	 * 
	 * @return String endDt
	 */
    public String getEndDt() {
        return this.endDt;
    }

    /**
	 *
	 * @param String sailDys
	 */
    public void setSailDys(String sailDys) {
        this.sailDys = sailDys;
    }

    /**
	 * 
	 * @return String sailDys
	 */
    public String getSailDys() {
        return this.sailDys;
    }

    /**
	 *
	 * @param String g6gaYn
	 */
    public void setG6gaYn(String g6gaYn) {
        this.g6gaYn = g6gaYn;
    }

    /**
	 * 
	 * @return String g6gaYn
	 */
    public String getG6gaYn() {
        return this.g6gaYn;
    }

    /**
	 *
	 * @param String schTpCd
	 */
    public void setSchTpCd(String schTpCd) {
        this.schTpCd = schTpCd;
    }

    /**
	 * 
	 * @return String schTpCd
	 */
    public String getSchTpCd() {
        return this.schTpCd;
    }

    /**
	 *
	 * @param String tmpSchTpCd
	 */
    public void setTmpSchTpCd(String tmpSchTpCd) {
        this.tmpSchTpCd = tmpSchTpCd;
    }

    /**
	 * 
	 * @return String tmpSchTpCd
	 */
    public String getTmpSchTpCd() {
        return this.tmpSchTpCd;
    }

    /**
	 *
	 * @param String tmpFrPortCd
	 */
    public void setTmpFmPortCd(String tmpFmPortCd) {
        this.tmpFmPortCd = tmpFmPortCd;
    }

    /**
	 * 
	 * @return String tmpFrPortCd
	 */
    public String getTmpFmPortCd() {
        return this.tmpFmPortCd;
    }

    /**
	 *
	 * @param String tmp-toPortCd
	 */
    public void setTmpToPortCd(String tmpToPortCd) {
        this.tmpToPortCd = tmpToPortCd;
    }

    /**
	 * 
	 * @return String tmp-toPortCd
	 */
    public String getTmpToPortCd() {
        return this.tmpToPortCd;
    }

    /**
	 *
	 * @param String tmpStDt
	 */
    public void setTmpStDt(String tmpStDt) {
        this.tmpStDt = tmpStDt;
    }

    /**
	 * 
	 * @return String tmpStDt
	 */
    public String getTmpStDt() {
        return this.tmpStDt;
    }

    /**
	 *
	 * @param String tmpEndDt
	 */
    public void setTmpEndDt(String tmpEndDt) {
        this.tmpEndDt = tmpEndDt;
    }

    /**
	 * 
	 * @return String tmpEndDt
	 */
    public String getTmpEndDt() {
        return this.tmpEndDt;
    }

    /**
	 *
	 * @param String tmpSailDys
	 */
    public void setTmpSailDys(String tmpSailDys) {
        this.tmpSailDys = tmpSailDys;
    }

    /**
	 * 
	 * @return String tmpSailDys
	 */
    public String getTmpSailDys() {
        return this.tmpSailDys;
    }

    public void setAddJoStlItmCd(String addJoStlItmCd) {
        this.addJoStlItmCd = addJoStlItmCd;
    }

    public String getAddJoStlItmCd() {
        return this.addJoStlItmCd;
    }

    public void setAddJoMnuNm(String addJoMnuNm) {
        this.addJoMnuNm = addJoMnuNm;
    }

    public String getAddJoMnuNm() {
        return this.addJoMnuNm;
    }

    public void setDepPortCd(String depPortCd) {
        this.depPortCd = depPortCd;
    }

    public String getDepPortCd() {
        return this.depPortCd;
    }

    public void setTeuWgt(String teuWgt) {
        this.teuWgt = teuWgt;
    }

    public String getTeuWgt() {
        return this.teuWgt;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setStlAdjFlg(JSPUtil.getParameter(request, prefix + "stl_adj_flg", ""));
        setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
        setSlipNo(JSPUtil.getParameter(request, prefix + "slip_no", ""));
        setFmPortCd(JSPUtil.getParameter(request, prefix + "fm_port_cd", ""));
        setPreAcctYrmon(JSPUtil.getParameter(request, prefix + "pre_acct_yrmon", ""));
        setDupFlg(JSPUtil.getParameter(request, prefix + "dup_flg", ""));
        setStlUsdAmt(JSPUtil.getParameter(request, prefix + "stl_usd_amt", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setCxlVvdFlg(JSPUtil.getParameter(request, prefix + "cxl_vvd_flg", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setUsdSltWgt(JSPUtil.getParameter(request, prefix + "usd_slt_wgt", ""));
        setUsdSltBsaQty(JSPUtil.getParameter(request, prefix + "usd_slt_bsa_qty", ""));
        setStlBzcPortCd(JSPUtil.getParameter(request, prefix + "stl_bzc_port_cd", ""));
        setRvsCmbFlg(JSPUtil.getParameter(request, prefix + "rvs_cmb_flg", ""));
        setStlLstFlg(JSPUtil.getParameter(request, prefix + "stl_lst_flg", ""));
        setUcBssPortEtdDt(JSPUtil.getParameter(request, prefix + "uc_bss_port_etd_dt", ""));
        setRfScgStlTpCd(JSPUtil.getParameter(request, prefix + "rf_scg_stl_tp_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setPreStlVvdSeq(JSPUtil.getParameter(request, prefix + "pre_stl_vvd_seq", ""));
        setAdjBsaSltPrcLoclAmt(JSPUtil.getParameter(request, prefix + "adj_bsa_slt_prc_locl_amt", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setFnlOwnBsaQty(JSPUtil.getParameter(request, prefix + "fnl_own_bsa_qty", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
        setBsaSltPrc(JSPUtil.getParameter(request, prefix + "bsa_slt_prc", ""));
        setRfScgPrc(JSPUtil.getParameter(request, prefix + "rf_scg_prc", ""));
        setToPortCd(JSPUtil.getParameter(request, prefix + "to_port_cd", ""));
        setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
        setStlCmbSeq(JSPUtil.getParameter(request, prefix + "stl_cmb_seq", ""));
        setBsaQty(JSPUtil.getParameter(request, prefix + "bsa_qty", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setStlTjNo(JSPUtil.getParameter(request, prefix + "stl_tj_no", ""));
        setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
        setStlDupFlg(JSPUtil.getParameter(request, prefix + "stl_dup_flg", ""));
        setUcBssPortCd(JSPUtil.getParameter(request, prefix + "uc_bss_port_cd", ""));
        setStlLoclAmt(JSPUtil.getParameter(request, prefix + "stl_locl_amt", ""));
        setJoMnuNm(JSPUtil.getParameter(request, prefix + "jo_mnu_nm", ""));
        setCmbCfmFlg(JSPUtil.getParameter(request, prefix + "cmb_cfm_flg", ""));
        setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
        setBsaPerWgt(JSPUtil.getParameter(request, prefix + "bsa_per_wgt", ""));
        setStlRmk(JSPUtil.getParameter(request, prefix + "stl_rmk", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setStlSeq(JSPUtil.getParameter(request, prefix + "stl_seq", ""));
        setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
        setPreStlSeq(JSPUtil.getParameter(request, prefix + "pre_stl_seq", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setFnlBsaWgt(JSPUtil.getParameter(request, prefix + "fnl_bsa_wgt", ""));
        setAdjBsaQtyLoclAmt(JSPUtil.getParameter(request, prefix + "adj_bsa_qty_locl_amt", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
        setStDt(JSPUtil.getParameter(request, prefix + "st_dt", ""));
        setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
        setSailDys(JSPUtil.getParameter(request, prefix + "sail_dys", ""));
        setG6gaYn(JSPUtil.getParameter(request, prefix + "g6ga_yn", ""));
        setSchTpCd(JSPUtil.getParameter(request, prefix + "sch_tp_cd", ""));
        setTmpSchTpCd(JSPUtil.getParameter(request, prefix + "tmp_sch_tp_cd", ""));
        setTmpFmPortCd(JSPUtil.getParameter(request, prefix + "tmp_fm_port_cd", ""));
        setTmpToPortCd(JSPUtil.getParameter(request, prefix + "tmp_to_port_cd", ""));
        setTmpStDt(JSPUtil.getParameter(request, prefix + "tmp_st_dt", ""));
        setTmpEndDt(JSPUtil.getParameter(request, prefix + "tmp_end_dt", ""));
        setTmpSailDys(JSPUtil.getParameter(request, prefix + "tmp_sail_dys", ""));
        setAddJoStlItmCd(JSPUtil.getParameter(request, prefix + "add_jo_stl_itm_cd", ""));
        setAddJoMnuNm(JSPUtil.getParameter(request, prefix + "add_jo_mnu_nm", ""));
        setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
        setTeuWgt(JSPUtil.getParameter(request, prefix + "teu_wgt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcSettlementVO[]
	 */
    public ProcSettlementVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcSettlementVO[]
	 */
    public ProcSettlementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ProcSettlementVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] stlAdjFlg = (JSPUtil.getParameter(request, prefix + "stl_adj_flg", length));
            String[] etaDt = (JSPUtil.getParameter(request, prefix + "eta_dt", length));
            String[] slipNo = (JSPUtil.getParameter(request, prefix + "slip_no", length));
            String[] fmPortCd = (JSPUtil.getParameter(request, prefix + "fm_port_cd", length));
            String[] preAcctYrmon = (JSPUtil.getParameter(request, prefix + "pre_acct_yrmon", length));
            String[] dupFlg = (JSPUtil.getParameter(request, prefix + "dup_flg", length));
            String[] stlUsdAmt = (JSPUtil.getParameter(request, prefix + "stl_usd_amt", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] cxlVvdFlg = (JSPUtil.getParameter(request, prefix + "cxl_vvd_flg", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] usdSltWgt = (JSPUtil.getParameter(request, prefix + "usd_slt_wgt", length));
            String[] usdSltBsaQty = (JSPUtil.getParameter(request, prefix + "usd_slt_bsa_qty", length));
            String[] stlBzcPortCd = (JSPUtil.getParameter(request, prefix + "stl_bzc_port_cd", length));
            String[] rvsCmbFlg = (JSPUtil.getParameter(request, prefix + "rvs_cmb_flg", length));
            String[] stlLstFlg = (JSPUtil.getParameter(request, prefix + "stl_lst_flg", length));
            String[] ucBssPortEtdDt = (JSPUtil.getParameter(request, prefix + "uc_bss_port_etd_dt", length));
            String[] rfScgStlTpCd = (JSPUtil.getParameter(request, prefix + "rf_scg_stl_tp_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] preStlVvdSeq = (JSPUtil.getParameter(request, prefix + "pre_stl_vvd_seq", length));
            String[] adjBsaSltPrcLoclAmt = (JSPUtil.getParameter(request, prefix + "adj_bsa_slt_prc_locl_amt", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] fnlOwnBsaQty = (JSPUtil.getParameter(request, prefix + "fnl_own_bsa_qty", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix + "bsa_slt_prc", length));
            String[] rfScgPrc = (JSPUtil.getParameter(request, prefix + "rf_scg_prc", length));
            String[] toPortCd = (JSPUtil.getParameter(request, prefix + "to_port_cd", length));
            String[] joStlJbCd = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", length));
            String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix + "stl_cmb_seq", length));
            String[] bsaQty = (JSPUtil.getParameter(request, prefix + "bsa_qty", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] stlTjNo = (JSPUtil.getParameter(request, prefix + "stl_tj_no", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] stlDupFlg = (JSPUtil.getParameter(request, prefix + "stl_dup_flg", length));
            String[] ucBssPortCd = (JSPUtil.getParameter(request, prefix + "uc_bss_port_cd", length));
            String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix + "stl_locl_amt", length));
            String[] joMnuNm = (JSPUtil.getParameter(request, prefix + "jo_mnu_nm", length));
            String[] cmbCfmFlg = (JSPUtil.getParameter(request, prefix + "cmb_cfm_flg", length));
            String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix + "stl_vvd_seq", length));
            String[] bsaPerWgt = (JSPUtil.getParameter(request, prefix + "bsa_per_wgt", length));
            String[] stlRmk = (JSPUtil.getParameter(request, prefix + "stl_rmk", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] stlSeq = (JSPUtil.getParameter(request, prefix + "stl_seq", length));
            String[] iocCd = (JSPUtil.getParameter(request, prefix + "ioc_cd", length));
            String[] preStlSeq = (JSPUtil.getParameter(request, prefix + "pre_stl_seq", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] fnlBsaWgt = (JSPUtil.getParameter(request, prefix + "fnl_bsa_wgt", length));
            String[] adjBsaQtyLoclAmt = (JSPUtil.getParameter(request, prefix + "adj_bsa_qty_locl_amt", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd", length));
            String[] stDt = (JSPUtil.getParameter(request, prefix + "st_dt", length));
            String[] endDt = (JSPUtil.getParameter(request, prefix + "end_dt", length));
            String[] sailDys = (JSPUtil.getParameter(request, prefix + "sail_dys", length));
            String[] g6gaYn = (JSPUtil.getParameter(request, prefix + "g6ga_yn", length));
            String[] schTpCd = (JSPUtil.getParameter(request, prefix + "sch_tp_cd", length));
            String[] tmpSchTpCd = (JSPUtil.getParameter(request, prefix + "tmp_sch_tp_cd", length));
            String[] tmpFmPortCd = (JSPUtil.getParameter(request, prefix + "tmp_fm_port_cd", length));
            String[] tmpToPortCd = (JSPUtil.getParameter(request, prefix + "tmp_to_port_cd", length));
            String[] tmpStDt = (JSPUtil.getParameter(request, prefix + "tmp_st_dt", length));
            String[] tmpEndDt = (JSPUtil.getParameter(request, prefix + "tmp_end_dt", length));
            String[] tmpSailDys = (JSPUtil.getParameter(request, prefix + "tmp_sail_dys", length));
            String[] addJoStlItmCd = (JSPUtil.getParameter(request, prefix + "add_jo_stl_itm_cd", length));
            String[] addJoMnuNm = (JSPUtil.getParameter(request, prefix + "add_jo_mnu_nm", length));
            String[] depPortCd = (JSPUtil.getParameter(request, prefix + "dep_port_cd", length));
            String[] teuWgt = (JSPUtil.getParameter(request, prefix + "teu_wgt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ProcSettlementVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (stlAdjFlg[i] != null)
                    model.setStlAdjFlg(stlAdjFlg[i]);
                if (etaDt[i] != null)
                    model.setEtaDt(etaDt[i]);
                if (slipNo[i] != null)
                    model.setSlipNo(slipNo[i]);
                if (fmPortCd[i] != null)
                    model.setFmPortCd(fmPortCd[i]);
                if (preAcctYrmon[i] != null)
                    model.setPreAcctYrmon(preAcctYrmon[i]);
                if (dupFlg[i] != null)
                    model.setDupFlg(dupFlg[i]);
                if (stlUsdAmt[i] != null)
                    model.setStlUsdAmt(stlUsdAmt[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (cxlVvdFlg[i] != null)
                    model.setCxlVvdFlg(cxlVvdFlg[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (usdSltWgt[i] != null)
                    model.setUsdSltWgt(usdSltWgt[i]);
                if (usdSltBsaQty[i] != null)
                    model.setUsdSltBsaQty(usdSltBsaQty[i]);
                if (stlBzcPortCd[i] != null)
                    model.setStlBzcPortCd(stlBzcPortCd[i]);
                if (rvsCmbFlg[i] != null)
                    model.setRvsCmbFlg(rvsCmbFlg[i]);
                if (stlLstFlg[i] != null)
                    model.setStlLstFlg(stlLstFlg[i]);
                if (ucBssPortEtdDt[i] != null)
                    model.setUcBssPortEtdDt(ucBssPortEtdDt[i]);
                if (rfScgStlTpCd[i] != null)
                    model.setRfScgStlTpCd(rfScgStlTpCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (preStlVvdSeq[i] != null)
                    model.setPreStlVvdSeq(preStlVvdSeq[i]);
                if (adjBsaSltPrcLoclAmt[i] != null)
                    model.setAdjBsaSltPrcLoclAmt(adjBsaSltPrcLoclAmt[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (fnlOwnBsaQty[i] != null)
                    model.setFnlOwnBsaQty(fnlOwnBsaQty[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (bsaSltPrc[i] != null)
                    model.setBsaSltPrc(bsaSltPrc[i]);
                if (rfScgPrc[i] != null)
                    model.setRfScgPrc(rfScgPrc[i]);
                if (toPortCd[i] != null)
                    model.setToPortCd(toPortCd[i]);
                if (joStlJbCd[i] != null)
                    model.setJoStlJbCd(joStlJbCd[i]);
                if (stlCmbSeq[i] != null)
                    model.setStlCmbSeq(stlCmbSeq[i]);
                if (bsaQty[i] != null)
                    model.setBsaQty(bsaQty[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (stlTjNo[i] != null)
                    model.setStlTjNo(stlTjNo[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (stlDupFlg[i] != null)
                    model.setStlDupFlg(stlDupFlg[i]);
                if (ucBssPortCd[i] != null)
                    model.setUcBssPortCd(ucBssPortCd[i]);
                if (stlLoclAmt[i] != null)
                    model.setStlLoclAmt(stlLoclAmt[i]);
                if (joMnuNm[i] != null)
                    model.setJoMnuNm(joMnuNm[i]);
                if (cmbCfmFlg[i] != null)
                    model.setCmbCfmFlg(cmbCfmFlg[i]);
                if (stlVvdSeq[i] != null)
                    model.setStlVvdSeq(stlVvdSeq[i]);
                if (bsaPerWgt[i] != null)
                    model.setBsaPerWgt(bsaPerWgt[i]);
                if (stlRmk[i] != null)
                    model.setStlRmk(stlRmk[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (stlSeq[i] != null)
                    model.setStlSeq(stlSeq[i]);
                if (iocCd[i] != null)
                    model.setIocCd(iocCd[i]);
                if (preStlSeq[i] != null)
                    model.setPreStlSeq(preStlSeq[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (fnlBsaWgt[i] != null)
                    model.setFnlBsaWgt(fnlBsaWgt[i]);
                if (adjBsaQtyLoclAmt[i] != null)
                    model.setAdjBsaQtyLoclAmt(adjBsaQtyLoclAmt[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (scontiCd[i] != null)
                    model.setScontiCd(scontiCd[i]);
                if (stDt[i] != null)
                    model.setStDt(stDt[i]);
                if (endDt[i] != null)
                    model.setEndDt(endDt[i]);
                if (sailDys[i] != null)
                    model.setSailDys(sailDys[i]);
                if (g6gaYn[i] != null)
                    model.setG6gaYn(g6gaYn[i]);
                if (schTpCd[i] != null)
                    model.setSchTpCd(schTpCd[i]);
                if (tmpSchTpCd[i] != null)
                    model.setTmpSchTpCd(tmpSchTpCd[i]);
                if (tmpFmPortCd[i] != null)
                    model.setTmpFmPortCd(tmpFmPortCd[i]);
                if (tmpToPortCd[i] != null)
                    model.setTmpToPortCd(tmpToPortCd[i]);
                if (tmpStDt[i] != null)
                    model.setTmpStDt(tmpStDt[i]);
                if (tmpEndDt[i] != null)
                    model.setTmpEndDt(tmpEndDt[i]);
                if (tmpSailDys[i] != null)
                    model.setTmpSailDys(tmpSailDys[i]);
                if (addJoStlItmCd[i] != null)
                    model.setAddJoStlItmCd(addJoStlItmCd[i]);
                if (addJoMnuNm[i] != null)
                    model.setAddJoMnuNm(addJoMnuNm[i]);
                if (depPortCd[i] != null)
                    model.setDepPortCd(depPortCd[i]);
                if (teuWgt[i] != null) 
		    		model.setTeuWgt(teuWgt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getProcSettlementVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ProcSettlementVO[]
	 */
    public ProcSettlementVO[] getProcSettlementVOs() {
        ProcSettlementVO[] vos = (ProcSettlementVO[]) models.toArray(new ProcSettlementVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlAdjFlg = this.stlAdjFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etaDt = this.etaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slipNo = this.slipNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmPortCd = this.fmPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preAcctYrmon = this.preAcctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dupFlg = this.dupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlUsdAmt = this.stlUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlVvdFlg = this.cxlVvdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdSltWgt = this.usdSltWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdSltBsaQty = this.usdSltBsaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlBzcPortCd = this.stlBzcPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvsCmbFlg = this.rvsCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlLstFlg = this.stlLstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ucBssPortEtdDt = this.ucBssPortEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfScgStlTpCd = this.rfScgStlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preStlVvdSeq = this.preStlVvdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.adjBsaSltPrcLoclAmt = this.adjBsaSltPrcLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlOwnBsaQty = this.fnlOwnBsaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaSltPrc = this.bsaSltPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfScgPrc = this.rfScgPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toPortCd = this.toPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbCd = this.joStlJbCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlCmbSeq = this.stlCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaQty = this.bsaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlTjNo = this.stlTjNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlDupFlg = this.stlDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ucBssPortCd = this.ucBssPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlLoclAmt = this.stlLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joMnuNm = this.joMnuNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmbCfmFlg = this.cmbCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlVvdSeq = this.stlVvdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaPerWgt = this.bsaPerWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlRmk = this.stlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlSeq = this.stlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iocCd = this.iocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preStlSeq = this.preStlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlBsaWgt = this.fnlBsaWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.adjBsaQtyLoclAmt = this.adjBsaQtyLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stDt = this.stDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDt = this.endDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sailDys = this.sailDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.g6gaYn = this.g6gaYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.schTpCd = this.schTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpSchTpCd = this.tmpSchTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpFmPortCd = this.tmpFmPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpToPortCd = this.tmpToPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpStDt = this.tmpStDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpEndDt = this.tmpEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpSailDys = this.tmpSailDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addJoStlItmCd = this.addJoStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addJoMnuNm = this.addJoMnuNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.depPortCd = this.depPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teuWgt = this.teuWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
