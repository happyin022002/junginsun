/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchCostCodeDetailListVO.java
*@FileTitle : SearchCostCodeDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo;

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
public class SearchCostCodeDetailListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchCostCodeDetailListVO> models = new ArrayList<SearchCostCodeDetailListVO>();

    /* Column Info */
    private String tmlAgmtVolUtCd = null;

    /* Column Info */
    private String laneCd = null;

    /* Column Info */
    private String subTrdCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String tmlTrnsModCd = null;

    /* Column Info */
    private String agmtDtlRmk = null;

    /* Column Info */
    private String costCode = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String tier = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String calcTpCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String volTrUtCd = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String ctrtOfcCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String effFmDt = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String invXchRt = null;

    /* Column Info */
    private String calcVolQty = null;

    /* Column Info */
    private String portion = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String iocCd = null;

    /* Column Info */
    private String rvisVolQty = null;

    /* Column Info */
    private String ctrtRt = null;

    /* Column Info */
    private String agmtSeq = null;

    /* Column Info */
    private String dcgoIndCd = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String agmtOfcCtyCd = null;

    /* Column Info */
    private String lgsCostCd = null;

    /* Column Info */
    private String stayDays = null;

    /* Column Info */
    private String tmlWrkDyCd = null;

    /* Column Info */
    private String agmtVerNo = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String effToDt = null;

    /* Column Info */
    private String chkYdFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchCostCodeDetailListVO() {
    }

    public SearchCostCodeDetailListVO(String ibflag, String pagerows, String laneCd, String subTrdCd, String tmlTrnsModCd, String currCd, String costCode, String creDt, String tier, String calcTpCd, String ctrtOfcCd, String creOfcCd, String volTrUtCd, String cntrTpszCd, String effFmDt, String invAmt, String invXchRt, String calcVolQty, String portion, String updDt, String iocCd, String rvisVolQty, String ctrtRt, String agmtSeq, String dcgoIndCd, String ioBndCd, String ydCd, String agmtOfcCtyCd, String vndrSeq, String lgsCostCd, String tmlWrkDyCd, String stayDays, String rcFlg, String agmtVerNo, String effToDt, String agmtDtlRmk, String tmlAgmtVolUtCd, String chkYdFlg) {
        this.tmlAgmtVolUtCd = tmlAgmtVolUtCd;
        this.laneCd = laneCd;
        this.subTrdCd = subTrdCd;
        this.currCd = currCd;
        this.tmlTrnsModCd = tmlTrnsModCd;
        this.agmtDtlRmk = agmtDtlRmk;
        this.costCode = costCode;
        this.creDt = creDt;
        this.tier = tier;
        this.pagerows = pagerows;
        this.calcTpCd = calcTpCd;
        this.ibflag = ibflag;
        this.volTrUtCd = volTrUtCd;
        this.creOfcCd = creOfcCd;
        this.ctrtOfcCd = ctrtOfcCd;
        this.cntrTpszCd = cntrTpszCd;
        this.effFmDt = effFmDt;
        this.invAmt = invAmt;
        this.invXchRt = invXchRt;
        this.calcVolQty = calcVolQty;
        this.portion = portion;
        this.updDt = updDt;
        this.iocCd = iocCd;
        this.rvisVolQty = rvisVolQty;
        this.ctrtRt = ctrtRt;
        this.agmtSeq = agmtSeq;
        this.dcgoIndCd = dcgoIndCd;
        this.ioBndCd = ioBndCd;
        this.ydCd = ydCd;
        this.vndrSeq = vndrSeq;
        this.agmtOfcCtyCd = agmtOfcCtyCd;
        this.lgsCostCd = lgsCostCd;
        this.stayDays = stayDays;
        this.tmlWrkDyCd = tmlWrkDyCd;
        this.agmtVerNo = agmtVerNo;
        this.rcFlg = rcFlg;
        this.effToDt = effToDt;
        this.chkYdFlg = chkYdFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("tml_agmt_vol_ut_cd", getTmlAgmtVolUtCd());
        this.hashColumns.put("lane_cd", getLaneCd());
        this.hashColumns.put("sub_trd_cd", getSubTrdCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("tml_trns_mod_cd", getTmlTrnsModCd());
        this.hashColumns.put("agmt_dtl_rmk", getAgmtDtlRmk());
        this.hashColumns.put("cost_code", getCostCode());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("tier", getTier());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("calc_tp_cd", getCalcTpCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("eff_fm_dt", getEffFmDt());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("inv_xch_rt", getInvXchRt());
        this.hashColumns.put("calc_vol_qty", getCalcVolQty());
        this.hashColumns.put("portion", getPortion());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("ioc_cd", getIocCd());
        this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
        this.hashColumns.put("ctrt_rt", getCtrtRt());
        this.hashColumns.put("agmt_seq", getAgmtSeq());
        this.hashColumns.put("dcgo_ind_cd", getDcgoIndCd());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
        this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
        this.hashColumns.put("stay_days", getStayDays());
        this.hashColumns.put("tml_wrk_dy_cd", getTmlWrkDyCd());
        this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("eff_to_dt", getEffToDt());
        this.hashColumns.put("chk_yd_flg", getChkYdFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("tml_agmt_vol_ut_cd", "tmlAgmtVolUtCd");
        this.hashFields.put("lane_cd", "laneCd");
        this.hashFields.put("sub_trd_cd", "subTrdCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("tml_trns_mod_cd", "tmlTrnsModCd");
        this.hashFields.put("agmt_dtl_rmk", "agmtDtlRmk");
        this.hashFields.put("cost_code", "costCode");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("tier", "tier");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("calc_tp_cd", "calcTpCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("eff_fm_dt", "effFmDt");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("inv_xch_rt", "invXchRt");
        this.hashFields.put("calc_vol_qty", "calcVolQty");
        this.hashFields.put("portion", "portion");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("ioc_cd", "iocCd");
        this.hashFields.put("rvis_vol_qty", "rvisVolQty");
        this.hashFields.put("ctrt_rt", "ctrtRt");
        this.hashFields.put("agmt_seq", "agmtSeq");
        this.hashFields.put("dcgo_ind_cd", "dcgoIndCd");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
        this.hashFields.put("lgs_cost_cd", "lgsCostCd");
        this.hashFields.put("stay_days", "stayDays");
        this.hashFields.put("tml_wrk_dy_cd", "tmlWrkDyCd");
        this.hashFields.put("agmt_ver_no", "agmtVerNo");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("eff_to_dt", "effToDt");
        this.hashFields.put("chk_yd_flg", "chkYdFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return tmlAgmtVolUtCd
	 */
    public String getTmlAgmtVolUtCd() {
        return this.tmlAgmtVolUtCd;
    }

    /**
	 * Column Info
	 * @return laneCd
	 */
    public String getLaneCd() {
        return this.laneCd;
    }

    /**
	 * Column Info
	 * @return subTrdCd
	 */
    public String getSubTrdCd() {
        return this.subTrdCd;
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
	 * @return tmlTrnsModCd
	 */
    public String getTmlTrnsModCd() {
        return this.tmlTrnsModCd;
    }

    /**
	 * Column Info
	 * @return agmtDtlRmk
	 */
    public String getAgmtDtlRmk() {
        return this.agmtDtlRmk;
    }

    /**
	 * Column Info
	 * @return costCode
	 */
    public String getCostCode() {
        return this.costCode;
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
	 * @return tier
	 */
    public String getTier() {
        return this.tier;
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
	 * @return calcTpCd
	 */
    public String getCalcTpCd() {
        return this.calcTpCd;
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
	 * @return volTrUtCd
	 */
    public String getVolTrUtCd() {
        return this.volTrUtCd;
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
	 * @return ctrtOfcCd
	 */
    public String getCtrtOfcCd() {
        return this.ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return effFmDt
	 */
    public String getEffFmDt() {
        return this.effFmDt;
    }

    /**
	 * Column Info
	 * @return invAmt
	 */
    public String getInvAmt() {
        return this.invAmt;
    }

    /**
	 * Column Info
	 * @return invXchRt
	 */
    public String getInvXchRt() {
        return this.invXchRt;
    }

    /**
	 * Column Info
	 * @return calcVolQty
	 */
    public String getCalcVolQty() {
        return this.calcVolQty;
    }

    /**
	 * Column Info
	 * @return portion
	 */
    public String getPortion() {
        return this.portion;
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
	 * @return iocCd
	 */
    public String getIocCd() {
        return this.iocCd;
    }

    /**
	 * Column Info
	 * @return rvisVolQty
	 */
    public String getRvisVolQty() {
        return this.rvisVolQty;
    }

    /**
	 * Column Info
	 * @return ctrtRt
	 */
    public String getCtrtRt() {
        return this.ctrtRt;
    }

    /**
	 * Column Info
	 * @return agmtSeq
	 */
    public String getAgmtSeq() {
        return this.agmtSeq;
    }

    /**
	 * Column Info
	 * @return dcgoIndCd
	 */
    public String getDcgoIndCd() {
        return this.dcgoIndCd;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
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
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
    public String getAgmtOfcCtyCd() {
        return this.agmtOfcCtyCd;
    }

    /**
	 * Column Info
	 * @return lgsCostCd
	 */
    public String getLgsCostCd() {
        return this.lgsCostCd;
    }

    /**
	 * Column Info
	 * @return stayDays
	 */
    public String getStayDays() {
        return this.stayDays;
    }

    /**
	 * Column Info
	 * @return tmlWrkDyCd
	 */
    public String getTmlWrkDyCd() {
        return this.tmlWrkDyCd;
    }

    /**
	 * Column Info
	 * @return agmtVerNo
	 */
    public String getAgmtVerNo() {
        return this.agmtVerNo;
    }

    /**
	 * Column Info
	 * @return rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 * Column Info
	 * @return effToDt
	 */
    public String getEffToDt() {
        return this.effToDt;
    }

    /**
	 * Column Info
	 * @param tmlAgmtVolUtCd
	 */
    public void setTmlAgmtVolUtCd(String tmlAgmtVolUtCd) {
        this.tmlAgmtVolUtCd = tmlAgmtVolUtCd;
    }

    /**
	 * Column Info
	 * @param laneCd
	 */
    public void setLaneCd(String laneCd) {
        this.laneCd = laneCd;
    }

    /**
	 * Column Info
	 * @param subTrdCd
	 */
    public void setSubTrdCd(String subTrdCd) {
        this.subTrdCd = subTrdCd;
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
	 * @param tmlTrnsModCd
	 */
    public void setTmlTrnsModCd(String tmlTrnsModCd) {
        this.tmlTrnsModCd = tmlTrnsModCd;
    }

    /**
	 * Column Info
	 * @param agmtDtlRmk
	 */
    public void setAgmtDtlRmk(String agmtDtlRmk) {
        this.agmtDtlRmk = agmtDtlRmk;
    }

    /**
	 * Column Info
	 * @param costCode
	 */
    public void setCostCode(String costCode) {
        this.costCode = costCode;
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
	 * @param tier
	 */
    public void setTier(String tier) {
        this.tier = tier;
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
	 * @param calcTpCd
	 */
    public void setCalcTpCd(String calcTpCd) {
        this.calcTpCd = calcTpCd;
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
	 * @param volTrUtCd
	 */
    public void setVolTrUtCd(String volTrUtCd) {
        this.volTrUtCd = volTrUtCd;
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
	 * @param ctrtOfcCd
	 */
    public void setCtrtOfcCd(String ctrtOfcCd) {
        this.ctrtOfcCd = ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param effFmDt
	 */
    public void setEffFmDt(String effFmDt) {
        this.effFmDt = effFmDt;
    }

    /**
	 * Column Info
	 * @param invAmt
	 */
    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    /**
	 * Column Info
	 * @param invXchRt
	 */
    public void setInvXchRt(String invXchRt) {
        this.invXchRt = invXchRt;
    }

    /**
	 * Column Info
	 * @param calcVolQty
	 */
    public void setCalcVolQty(String calcVolQty) {
        this.calcVolQty = calcVolQty;
    }

    /**
	 * Column Info
	 * @param portion
	 */
    public void setPortion(String portion) {
        this.portion = portion;
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
	 * @param iocCd
	 */
    public void setIocCd(String iocCd) {
        this.iocCd = iocCd;
    }

    /**
	 * Column Info
	 * @param rvisVolQty
	 */
    public void setRvisVolQty(String rvisVolQty) {
        this.rvisVolQty = rvisVolQty;
    }

    /**
	 * Column Info
	 * @param ctrtRt
	 */
    public void setCtrtRt(String ctrtRt) {
        this.ctrtRt = ctrtRt;
    }

    /**
	 * Column Info
	 * @param agmtSeq
	 */
    public void setAgmtSeq(String agmtSeq) {
        this.agmtSeq = agmtSeq;
    }

    /**
	 * Column Info
	 * @param dcgoIndCd
	 */
    public void setDcgoIndCd(String dcgoIndCd) {
        this.dcgoIndCd = dcgoIndCd;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
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
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
    public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
        this.agmtOfcCtyCd = agmtOfcCtyCd;
    }

    /**
	 * Column Info
	 * @param lgsCostCd
	 */
    public void setLgsCostCd(String lgsCostCd) {
        this.lgsCostCd = lgsCostCd;
    }

    /**
	 * Column Info
	 * @param stayDays
	 */
    public void setStayDays(String stayDays) {
        this.stayDays = stayDays;
    }

    /**
	 * Column Info
	 * @param tmlWrkDyCd
	 */
    public void setTmlWrkDyCd(String tmlWrkDyCd) {
        this.tmlWrkDyCd = tmlWrkDyCd;
    }

    /**
	 * Column Info
	 * @param agmtVerNo
	 */
    public void setAgmtVerNo(String agmtVerNo) {
        this.agmtVerNo = agmtVerNo;
    }

    /**
	 * Column Info
	 * @param rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param effToDt
	 */
    public void setEffToDt(String effToDt) {
        this.effToDt = effToDt;
    }

    public void setChkYdFlg(String chkYdFlg) {
        this.chkYdFlg = chkYdFlg;
    }

    public String getChkYdFlg() {
        return this.chkYdFlg;
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
        setTmlAgmtVolUtCd(JSPUtil.getParameter(request, prefix + "tml_agmt_vol_ut_cd", ""));
        setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
        setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setTmlTrnsModCd(JSPUtil.getParameter(request, prefix + "tml_trns_mod_cd", ""));
        setAgmtDtlRmk(JSPUtil.getParameter(request, prefix + "agmt_dtl_rmk", ""));
        setCostCode(JSPUtil.getParameter(request, prefix + "cost_code", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setTier(JSPUtil.getParameter(request, prefix + "tier", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
        setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
        setPortion(JSPUtil.getParameter(request, prefix + "portion", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
        setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
        setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
        setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
        setDcgoIndCd(JSPUtil.getParameter(request, prefix + "dcgo_ind_cd", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
        setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
        setStayDays(JSPUtil.getParameter(request, prefix + "stay_days", ""));
        setTmlWrkDyCd(JSPUtil.getParameter(request, prefix + "tml_wrk_dy_cd", ""));
        setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
        setChkYdFlg(JSPUtil.getParameter(request, prefix + "chk_yd_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostCodeDetailListVO[]
	 */
    public SearchCostCodeDetailListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostCodeDetailListVO[]
	 */
    public SearchCostCodeDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchCostCodeDetailListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] tmlAgmtVolUtCd = (JSPUtil.getParameter(request, prefix + "tml_agmt_vol_ut_cd", length));
            String[] laneCd = (JSPUtil.getParameter(request, prefix + "lane_cd", length));
            String[] subTrdCd = (JSPUtil.getParameter(request, prefix + "sub_trd_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] tmlTrnsModCd = (JSPUtil.getParameter(request, prefix + "tml_trns_mod_cd", length));
            String[] agmtDtlRmk = (JSPUtil.getParameter(request, prefix + "agmt_dtl_rmk", length));
            String[] costCode = (JSPUtil.getParameter(request, prefix + "cost_code", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] tier = (JSPUtil.getParameter(request, prefix + "tier", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] calcTpCd = (JSPUtil.getParameter(request, prefix + "calc_tp_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] volTrUtCd = (JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] effFmDt = (JSPUtil.getParameter(request, prefix + "eff_fm_dt", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] invXchRt = (JSPUtil.getParameter(request, prefix + "inv_xch_rt", length));
            String[] calcVolQty = (JSPUtil.getParameter(request, prefix + "calc_vol_qty", length));
            String[] portion = (JSPUtil.getParameter(request, prefix + "portion", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] iocCd = (JSPUtil.getParameter(request, prefix + "ioc_cd", length));
            String[] rvisVolQty = (JSPUtil.getParameter(request, prefix + "rvis_vol_qty", length));
            String[] ctrtRt = (JSPUtil.getParameter(request, prefix + "ctrt_rt", length));
            String[] agmtSeq = (JSPUtil.getParameter(request, prefix + "agmt_seq", length));
            String[] dcgoIndCd = (JSPUtil.getParameter(request, prefix + "dcgo_ind_cd", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", length));
            String[] lgsCostCd = (JSPUtil.getParameter(request, prefix + "lgs_cost_cd", length));
            String[] stayDays = (JSPUtil.getParameter(request, prefix + "stay_days", length));
            String[] tmlWrkDyCd = (JSPUtil.getParameter(request, prefix + "tml_wrk_dy_cd", length));
            String[] agmtVerNo = (JSPUtil.getParameter(request, prefix + "agmt_ver_no", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] effToDt = (JSPUtil.getParameter(request, prefix + "eff_to_dt", length));
            String[] chkYdFlg = (JSPUtil.getParameter(request, prefix + "chk_yd_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchCostCodeDetailListVO();
                if (tmlAgmtVolUtCd[i] != null)
                    model.setTmlAgmtVolUtCd(tmlAgmtVolUtCd[i]);
                if (laneCd[i] != null)
                    model.setLaneCd(laneCd[i]);
                if (subTrdCd[i] != null)
                    model.setSubTrdCd(subTrdCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (tmlTrnsModCd[i] != null)
                    model.setTmlTrnsModCd(tmlTrnsModCd[i]);
                if (agmtDtlRmk[i] != null)
                    model.setAgmtDtlRmk(agmtDtlRmk[i]);
                if (costCode[i] != null)
                    model.setCostCode(costCode[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (tier[i] != null)
                    model.setTier(tier[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (calcTpCd[i] != null)
                    model.setCalcTpCd(calcTpCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (volTrUtCd[i] != null)
                    model.setVolTrUtCd(volTrUtCd[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (ctrtOfcCd[i] != null)
                    model.setCtrtOfcCd(ctrtOfcCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (effFmDt[i] != null)
                    model.setEffFmDt(effFmDt[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (invXchRt[i] != null)
                    model.setInvXchRt(invXchRt[i]);
                if (calcVolQty[i] != null)
                    model.setCalcVolQty(calcVolQty[i]);
                if (portion[i] != null)
                    model.setPortion(portion[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (iocCd[i] != null)
                    model.setIocCd(iocCd[i]);
                if (rvisVolQty[i] != null)
                    model.setRvisVolQty(rvisVolQty[i]);
                if (ctrtRt[i] != null)
                    model.setCtrtRt(ctrtRt[i]);
                if (agmtSeq[i] != null)
                    model.setAgmtSeq(agmtSeq[i]);
                if (dcgoIndCd[i] != null)
                    model.setDcgoIndCd(dcgoIndCd[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (agmtOfcCtyCd[i] != null)
                    model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
                if (lgsCostCd[i] != null)
                    model.setLgsCostCd(lgsCostCd[i]);
                if (stayDays[i] != null)
                    model.setStayDays(stayDays[i]);
                if (tmlWrkDyCd[i] != null)
                    model.setTmlWrkDyCd(tmlWrkDyCd[i]);
                if (agmtVerNo[i] != null)
                    model.setAgmtVerNo(agmtVerNo[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (effToDt[i] != null)
                    model.setEffToDt(effToDt[i]);
                if (chkYdFlg[i] != null) 
		    		model.setChkYdFlg(chkYdFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchCostCodeDetailListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchCostCodeDetailListVO[]
	 */
    public SearchCostCodeDetailListVO[] getSearchCostCodeDetailListVOs() {
        SearchCostCodeDetailListVO[] vos = (SearchCostCodeDetailListVO[]) models.toArray(new SearchCostCodeDetailListVO[models.size()]);
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
        this.tmlAgmtVolUtCd = this.tmlAgmtVolUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.laneCd = this.laneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subTrdCd = this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlTrnsModCd = this.tmlTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtDtlRmk = this.agmtDtlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCode = this.costCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tier = this.tier.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcTpCd = this.calcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.volTrUtCd = this.volTrUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtOfcCd = this.ctrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effFmDt = this.effFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invXchRt = this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcVolQty = this.calcVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portion = this.portion.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iocCd = this.iocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvisVolQty = this.rvisVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtRt = this.ctrtRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtSeq = this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoIndCd = this.dcgoIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtOfcCtyCd = this.agmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostCd = this.lgsCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stayDays = this.stayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlWrkDyCd = this.tmlWrkDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtVerNo = this.agmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effToDt = this.effToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkYdFlg = this.chkYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
