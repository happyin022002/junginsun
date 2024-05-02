/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgForCopyVO.java
*@FileTitle : BkgForCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.24 류대영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgForCopyVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgForCopyVO> models = new ArrayList<BkgForCopyVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String scNoOld = null;

    /* Column Info */
    private String fdGrdFlg = null;

    /* Column Info */
    private String bulkRailFlg = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String bkgTrunkVvd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String hotDeFlg = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String prctFlg = null;

    /* Column Info */
    private String taaNoOld = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String rfaNoOld = null;

    /* Column Info */
    private String stopOffFlg = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String stowageFlg = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String spclHideFlg = null;

    /* Column Info */
    private String hngrFlg = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String remarkFlg = null;

    /* Column Info */
    private String bkgCtrlPtyCustCntCd = null;

    /* Column Info */
    private String bkgCtrlPtyCustSeq = null;

    /* Column Info */
    private String ediHldFlg = null;

    /* Column Info */
    private String bkgWtChkFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgForCopyVO() {
    }

    public BkgForCopyVO(String ibflag, String pagerows, String bkgNo, String bkgTrunkVvd, String porCd, String polCd, String podCd, String delCd, String rfaNo, String rfaNoOld, String scNo, String scNoOld, String taaNo, String taaNoOld, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String stowageFlg, String hngrFlg, String stopOffFlg, String bulkRailFlg, String hotDeFlg, String spclHideFlg, String fdGrdFlg, String prctFlg, String remarkFlg, String pctlNo, String bkgCtrlPtyCustCntCd, String bkgCtrlPtyCustSeq, String ediHldFlg, String bkgWtChkFlg) {
        this.porCd = porCd;
        this.scNoOld = scNoOld;
        this.fdGrdFlg = fdGrdFlg;
        this.bulkRailFlg = bulkRailFlg;
        this.pctlNo = pctlNo;
        this.bkgTrunkVvd = bkgTrunkVvd;
        this.pagerows = pagerows;
        this.hotDeFlg = hotDeFlg;
        this.rfaNo = rfaNo;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.scNo = scNo;
        this.bbCgoFlg = bbCgoFlg;
        this.prctFlg = prctFlg;
        this.taaNoOld = taaNoOld;
        this.dcgoFlg = dcgoFlg;
        this.rfaNoOld = rfaNoOld;
        this.stopOffFlg = stopOffFlg;
        this.awkCgoFlg = awkCgoFlg;
        this.delCd = delCd;
        this.stowageFlg = stowageFlg;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.taaNo = taaNo;
        this.spclHideFlg = spclHideFlg;
        this.hngrFlg = hngrFlg;
        this.rcFlg = rcFlg;
        this.remarkFlg = remarkFlg;
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
        this.ediHldFlg = ediHldFlg;
        this.bkgWtChkFlg = bkgWtChkFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("sc_no_old", getScNoOld());
        this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
        this.hashColumns.put("bulk_rail_flg", getBulkRailFlg());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("bkg_trunk_vvd", getBkgTrunkVvd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("hot_de_flg", getHotDeFlg());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("prct_flg", getPrctFlg());
        this.hashColumns.put("taa_no_old", getTaaNoOld());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("rfa_no_old", getRfaNoOld());
        this.hashColumns.put("stop_off_flg", getStopOffFlg());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("stowage_flg", getStowageFlg());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("remark_flg", getRemarkFlg());
        this.hashColumns.put("bkg_ctrl_pty_cust_cnt_cd", getBkgCtrlPtyCustCntCd());
        this.hashColumns.put("bkg_ctrl_pty_cust_seq", getBkgCtrlPtyCustSeq());
        this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
        this.hashColumns.put("bkg_wt_chk_flg", getBkgWtChkFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("sc_no_old", "scNoOld");
        this.hashFields.put("fd_grd_flg", "fdGrdFlg");
        this.hashFields.put("bulk_rail_flg", "bulkRailFlg");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("bkg_trunk_vvd", "bkgTrunkVvd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("hot_de_flg", "hotDeFlg");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("prct_flg", "prctFlg");
        this.hashFields.put("taa_no_old", "taaNoOld");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("rfa_no_old", "rfaNoOld");
        this.hashFields.put("stop_off_flg", "stopOffFlg");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("stowage_flg", "stowageFlg");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("spcl_hide_flg", "spclHideFlg");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("remark_flg", "remarkFlg");
        this.hashFields.put("bkg_ctrl_pty_cust_cnt_cd", "bkgCtrlPtyCustCntCd");
        this.hashFields.put("bkg_ctrl_pty_cust_seq", "bkgCtrlPtyCustSeq");
        this.hashFields.put("edi_hld_flg", "ediHldFlg");
        this.hashFields.put("bkg_wt_chk_flg", "bkgWtChkFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return scNoOld
	 */
    public String getScNoOld() {
        return this.scNoOld;
    }

    /**
	 * Column Info
	 * @return fdGrdFlg
	 */
    public String getFdGrdFlg() {
        return this.fdGrdFlg;
    }

    /**
	 * Column Info
	 * @return bulkRailFlg
	 */
    public String getBulkRailFlg() {
        return this.bulkRailFlg;
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
	 * @return bkgTrunkVvd
	 */
    public String getBkgTrunkVvd() {
        return this.bkgTrunkVvd;
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
	 * @return hotDeFlg
	 */
    public String getHotDeFlg() {
        return this.hotDeFlg;
    }

    /**
	 * Column Info
	 * @return rfaNo
	 */
    public String getRfaNo() {
        return this.rfaNo;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return scNo
	 */
    public String getScNo() {
        return this.scNo;
    }

    /**
	 * Column Info
	 * @return bbCgoFlg
	 */
    public String getBbCgoFlg() {
        return this.bbCgoFlg;
    }

    /**
	 * Column Info
	 * @return prctFlg
	 */
    public String getPrctFlg() {
        return this.prctFlg;
    }

    /**
	 * Column Info
	 * @return taaNoOld
	 */
    public String getTaaNoOld() {
        return this.taaNoOld;
    }

    /**
	 * Column Info
	 * @return dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
    }

    /**
	 * Column Info
	 * @return rfaNoOld
	 */
    public String getRfaNoOld() {
        return this.rfaNoOld;
    }

    /**
	 * Column Info
	 * @return stopOffFlg
	 */
    public String getStopOffFlg() {
        return this.stopOffFlg;
    }

    /**
	 * Column Info
	 * @return awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
    }

    /**
	 * Column Info
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	 * Column Info
	 * @return stowageFlg
	 */
    public String getStowageFlg() {
        return this.stowageFlg;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
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
	 * @return taaNo
	 */
    public String getTaaNo() {
        return this.taaNo;
    }

    /**
	 * Column Info
	 * @return spclHideFlg
	 */
    public String getSpclHideFlg() {
        return this.spclHideFlg;
    }

    /**
	 * Column Info
	 * @return hngrFlg
	 */
    public String getHngrFlg() {
        return this.hngrFlg;
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
	 * @return remarkFlg
	 */
    public String getRemarkFlg() {
        return this.remarkFlg;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustCntCd
	 */
    public String getBkgCtrlPtyCustCntCd() {
        return this.bkgCtrlPtyCustCntCd;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustSeq
	 */
    public String getBkgCtrlPtyCustSeq() {
        return this.bkgCtrlPtyCustSeq;
    }

    /**
	 * Column Info
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param scNoOld
	 */
    public void setScNoOld(String scNoOld) {
        this.scNoOld = scNoOld;
    }

    /**
	 * Column Info
	 * @param fdGrdFlg
	 */
    public void setFdGrdFlg(String fdGrdFlg) {
        this.fdGrdFlg = fdGrdFlg;
    }

    /**
	 * Column Info
	 * @param bulkRailFlg
	 */
    public void setBulkRailFlg(String bulkRailFlg) {
        this.bulkRailFlg = bulkRailFlg;
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
	 * @param bkgTrunkVvd
	 */
    public void setBkgTrunkVvd(String bkgTrunkVvd) {
        this.bkgTrunkVvd = bkgTrunkVvd;
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
	 * @param hotDeFlg
	 */
    public void setHotDeFlg(String hotDeFlg) {
        this.hotDeFlg = hotDeFlg;
    }

    /**
	 * Column Info
	 * @param rfaNo
	 */
    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    /**
	 * Column Info
	 * @param bbCgoFlg
	 */
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
    }

    /**
	 * Column Info
	 * @param prctFlg
	 */
    public void setPrctFlg(String prctFlg) {
        this.prctFlg = prctFlg;
    }

    /**
	 * Column Info
	 * @param taaNoOld
	 */
    public void setTaaNoOld(String taaNoOld) {
        this.taaNoOld = taaNoOld;
    }

    /**
	 * Column Info
	 * @param dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
    }

    /**
	 * Column Info
	 * @param rfaNoOld
	 */
    public void setRfaNoOld(String rfaNoOld) {
        this.rfaNoOld = rfaNoOld;
    }

    /**
	 * Column Info
	 * @param stopOffFlg
	 */
    public void setStopOffFlg(String stopOffFlg) {
        this.stopOffFlg = stopOffFlg;
    }

    /**
	 * Column Info
	 * @param awkCgoFlg
	 */
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
    }

    /**
	 * Column Info
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param stowageFlg
	 */
    public void setStowageFlg(String stowageFlg) {
        this.stowageFlg = stowageFlg;
    }

    /**
	 * Column Info
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
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
	 * @param taaNo
	 */
    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
    }

    /**
	 * Column Info
	 * @param spclHideFlg
	 */
    public void setSpclHideFlg(String spclHideFlg) {
        this.spclHideFlg = spclHideFlg;
    }

    /**
	 * Column Info
	 * @param hngrFlg
	 */
    public void setHngrFlg(String hngrFlg) {
        this.hngrFlg = hngrFlg;
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
	 * @param remarkFlg
	 */
    public void setRemarkFlg(String remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustCntCd
	 */
    public void setBkgCtrlPtyCustCntCd(String bkgCtrlPtyCustCntCd) {
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustSeq
	 */
    public void setBkgCtrlPtyCustSeq(String bkgCtrlPtyCustSeq) {
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
    }

    public void setEdiHldFlg(String ediHldFlg) {
        this.ediHldFlg = ediHldFlg;
    }

    public String getEdiHldFlg() {
        return this.ediHldFlg;
    }

    public void setBkgWtChkFlg(String bkgWtChkFlg) {
        this.bkgWtChkFlg = bkgWtChkFlg;
    }

    public String getBkgWtChkFlg() {
        return this.bkgWtChkFlg;
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
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setScNoOld(JSPUtil.getParameter(request, prefix + "sc_no_old", ""));
        setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
        setBulkRailFlg(JSPUtil.getParameter(request, prefix + "bulk_rail_flg", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setBkgTrunkVvd(JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
        setTaaNoOld(JSPUtil.getParameter(request, prefix + "taa_no_old", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setRfaNoOld(JSPUtil.getParameter(request, prefix + "rfa_no_old", ""));
        setStopOffFlg(JSPUtil.getParameter(request, prefix + "stop_off_flg", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setStowageFlg(JSPUtil.getParameter(request, prefix + "stowage_flg", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setRemarkFlg(JSPUtil.getParameter(request, prefix + "remark_flg", ""));
        setBkgCtrlPtyCustCntCd(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_cnt_cd", ""));
        setBkgCtrlPtyCustSeq(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_seq", ""));
        setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
        setBkgWtChkFlg(JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgForCopyVO[]
	 */
    public BkgForCopyVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgForCopyVO[]
	 */
    public BkgForCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgForCopyVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] scNoOld = (JSPUtil.getParameter(request, prefix + "sc_no_old", length));
            String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix + "fd_grd_flg", length));
            String[] bulkRailFlg = (JSPUtil.getParameter(request, prefix + "bulk_rail_flg", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] bkgTrunkVvd = (JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] hotDeFlg = (JSPUtil.getParameter(request, prefix + "hot_de_flg", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] prctFlg = (JSPUtil.getParameter(request, prefix + "prct_flg", length));
            String[] taaNoOld = (JSPUtil.getParameter(request, prefix + "taa_no_old", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] rfaNoOld = (JSPUtil.getParameter(request, prefix + "rfa_no_old", length));
            String[] stopOffFlg = (JSPUtil.getParameter(request, prefix + "stop_off_flg", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] stowageFlg = (JSPUtil.getParameter(request, prefix + "stowage_flg", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] spclHideFlg = (JSPUtil.getParameter(request, prefix + "spcl_hide_flg", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] remarkFlg = (JSPUtil.getParameter(request, prefix + "remark_flg", length));
            String[] bkgCtrlPtyCustCntCd = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_cnt_cd", length));
            String[] bkgCtrlPtyCustSeq = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_seq", length));
            String[] ediHldFlg = (JSPUtil.getParameter(request, prefix + "edi_hld_flg", length));
	    	String[] bkgWtChkFlg = (JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgForCopyVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (scNoOld[i] != null)
                    model.setScNoOld(scNoOld[i]);
                if (fdGrdFlg[i] != null)
                    model.setFdGrdFlg(fdGrdFlg[i]);
                if (bulkRailFlg[i] != null)
                    model.setBulkRailFlg(bulkRailFlg[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (bkgTrunkVvd[i] != null)
                    model.setBkgTrunkVvd(bkgTrunkVvd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (hotDeFlg[i] != null)
                    model.setHotDeFlg(hotDeFlg[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (prctFlg[i] != null)
                    model.setPrctFlg(prctFlg[i]);
                if (taaNoOld[i] != null)
                    model.setTaaNoOld(taaNoOld[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (rfaNoOld[i] != null)
                    model.setRfaNoOld(rfaNoOld[i]);
                if (stopOffFlg[i] != null)
                    model.setStopOffFlg(stopOffFlg[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (stowageFlg[i] != null)
                    model.setStowageFlg(stowageFlg[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (spclHideFlg[i] != null)
                    model.setSpclHideFlg(spclHideFlg[i]);
                if (hngrFlg[i] != null)
                    model.setHngrFlg(hngrFlg[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (remarkFlg[i] != null)
                    model.setRemarkFlg(remarkFlg[i]);
                if (bkgCtrlPtyCustCntCd[i] != null)
                    model.setBkgCtrlPtyCustCntCd(bkgCtrlPtyCustCntCd[i]);
                if (bkgCtrlPtyCustSeq[i] != null)
                    model.setBkgCtrlPtyCustSeq(bkgCtrlPtyCustSeq[i]);
                if (ediHldFlg[i] != null) 
		    		model.setEdiHldFlg(ediHldFlg[i]);
				if (bkgWtChkFlg[i] != null) 
		    		model.setBkgWtChkFlg(bkgWtChkFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgForCopyVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgForCopyVO[]
	 */
    public BkgForCopyVO[] getBkgForCopyVOs() {
        BkgForCopyVO[] vos = (BkgForCopyVO[]) models.toArray(new BkgForCopyVO[models.size()]);
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
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNoOld = this.scNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdGrdFlg = this.fdGrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bulkRailFlg = this.bulkRailFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTrunkVvd = this.bkgTrunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hotDeFlg = this.hotDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prctFlg = this.prctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNoOld = this.taaNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNoOld = this.rfaNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stopOffFlg = this.stopOffFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stowageFlg = this.stowageFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclHideFlg = this.spclHideFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.remarkFlg = this.remarkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustCntCd = this.bkgCtrlPtyCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustSeq = this.bkgCtrlPtyCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediHldFlg = this.ediHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgWtChkFlg = this.bkgWtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
