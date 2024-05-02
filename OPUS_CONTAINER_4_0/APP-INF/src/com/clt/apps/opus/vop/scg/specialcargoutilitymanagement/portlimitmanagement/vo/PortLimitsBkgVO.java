/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitsBkgVO.java
*@FileTitle : PortLimitsBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.30  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo;

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
public class PortLimitsBkgVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PortLimitsBkgVO> models = new ArrayList<PortLimitsBkgVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String dcgoRefNo = null;

    /* Column Info */
    private String authDt = null;

    /* Column Info */
    private String netWgt = null;

    /* Column Info */
    private String imdgUnNoSeq = null;
 
    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String cntrCgoSeq = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String imdgCompGrpCd = null;

    /* Column Info */
    private String bkgNos = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cgoOprCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String imdgUnNo = null;

    /* Column Info */
    private String imdgClssCd = null;

    /* Column Info */
    private String dgCntrSeq = null;

    /* Column Info */
    private String netExploWgt = null;

    /* Column Info */
    private String cntrQty = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String podClptIndSeq = null;

    /* Column Info */
    private String portLmtSeq = null;

    /* Column Info */
    private String authFlg = null;

    /* Column Info */
    private String plmtPortCd = null;

    /* Column Info */
    private String lmtWgtTpCd = null;

    /* Column Info */
    private String fromEtaDt = null;

    /* Column Info */
    private String toEtaDt = null;

    /* Column Info */
    private String plmtClptIndSeq = null;

    /* Column Info */
    private String plmtVvd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PortLimitsBkgVO() {
    }

    public PortLimitsBkgVO(String ibflag, String pagerows, String cgoOprCd, String bkgNo, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String bkgNos, String imdgClssCd, String dgCntrSeq, String cntrCgoSeq, String imdgUnNo, String imdgUnNoSeq, String cntrTpszCd, String grsWgt, String netWgt, String dcgoRefNo, String authDt, String imdgCompGrpCd, String netExploWgt, String cntrQty, String portCd, String polYdCd, String polClptIndSeq, String podYdCd, String podClptIndSeq, String portLmtSeq, String authFlg, String plmtPortCd, String lmtWgtTpCd, String fromEtaDt, String toEtaDt, String plmtClptIndSeq, String plmtVvd) {
        this.vslCd = vslCd;
        this.dcgoRefNo = dcgoRefNo;
        this.authDt = authDt;
        this.netWgt = netWgt;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.cntrCgoSeq = cntrCgoSeq;
        this.pagerows = pagerows;
        this.podCd = podCd;
        this.imdgCompGrpCd = imdgCompGrpCd;
        this.bkgNos = bkgNos;
        this.ibflag = ibflag;
        this.cgoOprCd = cgoOprCd;
        this.bkgNo = bkgNo;
        this.polCd = polCd;
        this.cntrTpszCd = cntrTpszCd;
        this.grsWgt = grsWgt;
        this.imdgUnNo = imdgUnNo;
        this.imdgClssCd = imdgClssCd;
        this.dgCntrSeq = dgCntrSeq;
        this.netExploWgt = netExploWgt;
        this.cntrQty = cntrQty;
        this.portCd = portCd;
        this.polYdCd = polYdCd;
        this.polClptIndSeq = polClptIndSeq;
        this.podYdCd = podYdCd;
        this.podClptIndSeq = podClptIndSeq;
        this.portLmtSeq = portLmtSeq;
        this.authFlg = authFlg;
        this.plmtPortCd = plmtPortCd;
        this.lmtWgtTpCd = lmtWgtTpCd;
        this.fromEtaDt = fromEtaDt;
        this.toEtaDt = toEtaDt;
        this.plmtClptIndSeq = plmtClptIndSeq;
        this.plmtVvd = plmtVvd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("auth_dt", getAuthDt());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
        this.hashColumns.put("bkg_nos", getBkgNos());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
        this.hashColumns.put("net_explo_wgt", getNetExploWgt());
        this.hashColumns.put("cntr_qty", getCntrQty());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("port_lmt_seq", getPortLmtSeq());
        this.hashColumns.put("auth_flg", getAuthFlg());
        this.hashColumns.put("plmt_port_cd", getPlmtPortCd());
        this.hashColumns.put("lmt_wgt_tp_cd", getLmtWgtTpCd());
        this.hashColumns.put("from_eta_dt", getFromEtaDt());
        this.hashColumns.put("to_eta_dt", getToEtaDt());
        this.hashColumns.put("plmt_clpt_ind_seq", getPlmtClptIndSeq());
        this.hashColumns.put("plmt_vvd", getPlmtVvd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("auth_dt", "authDt");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
        this.hashFields.put("bkg_nos", "bkgNos");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
        this.hashFields.put("net_explo_wgt", "netExploWgt");
        this.hashFields.put("cntr_qty", "cntrQty");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("port_lmt_seq", "portLmtSeq");
        this.hashFields.put("auth_flg", "authFlg");
        this.hashFields.put("plmt_port_cd", "plmtPortCd");
        this.hashFields.put("lmt_wgt_tp_cd", "lmtWgtTpCd");
        this.hashFields.put("from_eta_dt", "fromEtaDt");
        this.hashFields.put("to_eta_dt", "toEtaDt");
        this.hashFields.put("plmt_clpt_ind_seq", "plmtClptIndSeq");
        this.hashFields.put("plmt_vvd", "plmtVvd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return dcgoRefNo
	 */
    public String getDcgoRefNo() {
        return this.dcgoRefNo;
    }

    /**
	 * Column Info
	 * @return authDt
	 */
    public String getAuthDt() {
        return this.authDt;
    }

    /**
	 * Column Info
	 * @return netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
    public String getImdgUnNoSeq() {
        return this.imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return cntrCgoSeq
	 */
    public String getCntrCgoSeq() {
        return this.cntrCgoSeq;
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
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return imdgCompGrpCd
	 */
    public String getImdgCompGrpCd() {
        return this.imdgCompGrpCd;
    }

    /**
	 * Column Info
	 * @return bkgNos
	 */
    public String getBkgNos() {
        return this.bkgNos;
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
	 * @return cgoOprCd
	 */
    public String getCgoOprCd() {
        return this.cgoOprCd;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
    }

    /**
	 * Column Info
	 * @return imdgUnNo
	 */
    public String getImdgUnNo() {
        return this.imdgUnNo;
    }

    /**
	 * Column Info
	 * @return imdgClssCd
	 */
    public String getImdgClssCd() {
        return this.imdgClssCd;
    }

    /**
	 * Column Info
	 * @return dgCntrSeq
	 */
    public String getDgCntrSeq() {
        return this.dgCntrSeq;
    }

    /**
	 * Column Info
	 * @return netExploWgt
	 */
    public String getNetExploWgt() {
        return this.netExploWgt;
    }

    /**
	 * Column Info
	 * @return portCd
	 */
    public String getPortCd() {
        return this.portCd;
    }

    /**
	 * Column Info
	 * @return cntrQty
	 */
    public String getCntrQty() {
        return this.cntrQty;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param dcgoRefNo
	 */
    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
    }

    /**
	 * Column Info
	 * @param authDt
	 */
    public void setAuthDt(String authDt) {
        this.authDt = authDt;
    }

    /**
	 * Column Info
	 * @param netWgt
	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
    public void setImdgUnNoSeq(String imdgUnNoSeq) {
        this.imdgUnNoSeq = imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param cntrCgoSeq
	 */
    public void setCntrCgoSeq(String cntrCgoSeq) {
        this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param imdgCompGrpCd
	 */
    public void setImdgCompGrpCd(String imdgCompGrpCd) {
        this.imdgCompGrpCd = imdgCompGrpCd;
    }

    /**
	 * Column Info
	 * @param bkgNos
	 */
    public void setBkgNos(String bkgNos) {
        this.bkgNos = bkgNos;
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
	 * @param cgoOprCd
	 */
    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param grsWgt
	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * Column Info
	 * @param imdgUnNo
	 */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
    }

    /**
	 * Column Info
	 * @param imdgClssCd
	 */
    public void setImdgClssCd(String imdgClssCd) {
        this.imdgClssCd = imdgClssCd;
    }

    /**
	 * Column Info
	 * @param dgCntrSeq
	 */
    public void setDgCntrSeq(String dgCntrSeq) {
        this.dgCntrSeq = dgCntrSeq;
    }

    /**
	 * Column Info
	 * @param netExploWgt
	 */
    public void setNetExploWgt(String netExploWgt) {
        this.netExploWgt = netExploWgt;
    }

    /**
	 * Column Info
	 * @param portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    /**
	 * Column Info
	 * @param cntrQty
	 */
    public void setCntrQty(String cntrQty) {
        this.cntrQty = cntrQty;
    }

    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    public String getPolYdCd() {
        return this.polYdCd;
    }

    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
    }

    public String getPodYdCd() {
        return this.podYdCd;
    }

    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
    }

    public void setPortLmtSeq(String portLmtSeq) {
        this.portLmtSeq = portLmtSeq;
    }

    public String getPortLmtSeq() {
        return this.portLmtSeq;
    }

    public void setAuthFlg(String authFlg) {
        this.authFlg = authFlg;
    }

    public String getAuthFlg() {
        return this.authFlg;
    }

    public void setPlmtPortCd(String plmtPortCd) {
        this.plmtPortCd = plmtPortCd;
    }

    public String getPlmtPortCd() {
        return this.plmtPortCd;
    }

    public void setLmtWgtTpCd(String lmtWgtTpCd) {
        this.lmtWgtTpCd = lmtWgtTpCd;
    }

    public String getLmtWgtTpCd() {
        return this.lmtWgtTpCd;
    }

    public void setFromEtaDt(String fromEtaDt) {
        this.fromEtaDt = fromEtaDt;
    }

    public String getFromEtaDt() {
        return this.fromEtaDt;
    }

    public void setToEtaDt(String toEtaDt) {
        this.toEtaDt = toEtaDt;
    }

    public String getToEtaDt() {
        return this.toEtaDt;
    }

    public void setPlmtClptIndSeq(String plmtClptIndSeq) {
        this.plmtClptIndSeq = plmtClptIndSeq;
    }

    public String getPlmtClptIndSeq() {
        return this.plmtClptIndSeq;
    }

    public void setPlmtVvd(String plmtVvd) {
        this.plmtVvd = plmtVvd;
    }

    public String getPlmtVvd() {
        return this.plmtVvd;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
        setAuthDt(JSPUtil.getParameter(request, prefix + "auth_dt", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
        setBkgNos(JSPUtil.getParameter(request, prefix + "bkg_nos", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
        setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
        setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
        setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
        setPortLmtSeq(JSPUtil.getParameter(request, prefix + "port_lmt_seq", ""));
        setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
        setPlmtPortCd(JSPUtil.getParameter(request, prefix + "plmt_port_cd", ""));
        setLmtWgtTpCd(JSPUtil.getParameter(request, prefix + "lmt_wgt_tp_cd", ""));
        setFromEtaDt(JSPUtil.getParameter(request, prefix + "from_eta_dt", ""));
        setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
        setPlmtClptIndSeq(JSPUtil.getParameter(request, prefix + "plmt_clpt_ind_seq", ""));
        setPlmtVvd(JSPUtil.getParameter(request, prefix + "plmt_vvd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortLimitsBkgVO[]
	 */
    public PortLimitsBkgVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortLimitsBkgVO[]
	 */
    public PortLimitsBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PortLimitsBkgVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix + "dcgo_ref_no", length));
            String[] authDt = (JSPUtil.getParameter(request, prefix + "auth_dt", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", length));
            String[] bkgNos = (JSPUtil.getParameter(request, prefix + "bkg_nos", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix + "dg_cntr_seq", length));
            String[] netExploWgt = (JSPUtil.getParameter(request, prefix + "net_explo_wgt", length));
            String[] cntrQty = (JSPUtil.getParameter(request, prefix + "cntr_qty", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
            String[] portLmtSeq = (JSPUtil.getParameter(request, prefix + "port_lmt_seq", length));
            String[] authFlg = (JSPUtil.getParameter(request, prefix + "auth_flg", length));
            String[] plmtPortCd = (JSPUtil.getParameter(request, prefix + "plmt_port_cd", length));
            String[] lmtWgtTpCd = (JSPUtil.getParameter(request, prefix + "lmt_wgt_tp_cd", length));
            String[] fromEtaDt = (JSPUtil.getParameter(request, prefix + "from_eta_dt", length));
            String[] toEtaDt = (JSPUtil.getParameter(request, prefix + "to_eta_dt", length));
            String[] plmtClptIndSeq = (JSPUtil.getParameter(request, prefix + "plmt_clpt_ind_seq", length));
            String[] plmtVvd = (JSPUtil.getParameter(request, prefix + "plmt_vvd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PortLimitsBkgVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (dcgoRefNo[i] != null)
                    model.setDcgoRefNo(dcgoRefNo[i]);
                if (authDt[i] != null)
                    model.setAuthDt(authDt[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (cntrCgoSeq[i] != null)
                    model.setCntrCgoSeq(cntrCgoSeq[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (imdgCompGrpCd[i] != null)
                    model.setImdgCompGrpCd(imdgCompGrpCd[i]);
                if (bkgNos[i] != null)
                    model.setBkgNos(bkgNos[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (dgCntrSeq[i] != null)
                    model.setDgCntrSeq(dgCntrSeq[i]);
                if (netExploWgt[i] != null)
                    model.setNetExploWgt(netExploWgt[i]);
                if (cntrQty[i] != null)
                    model.setCntrQty(cntrQty[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (portLmtSeq[i] != null)
                    model.setPortLmtSeq(portLmtSeq[i]);
                if (authFlg[i] != null)
                    model.setAuthFlg(authFlg[i]);
                if (plmtPortCd[i] != null)
                    model.setPlmtPortCd(plmtPortCd[i]);
                if (lmtWgtTpCd[i] != null)
                    model.setLmtWgtTpCd(lmtWgtTpCd[i]);
                if (fromEtaDt[i] != null)
                    model.setFromEtaDt(fromEtaDt[i]);
                if (toEtaDt[i] != null)
                    model.setToEtaDt(toEtaDt[i]);
                if (plmtClptIndSeq[i] != null)
                    model.setPlmtClptIndSeq(plmtClptIndSeq[i]);
                if (plmtVvd[i] != null) 
		    		model.setPlmtVvd(plmtVvd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPortLimitsBkgVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PortLimitsBkgVO[]
	 */
    public PortLimitsBkgVO[] getPortLimitsBkgVOs() {
        PortLimitsBkgVO[] vos = (PortLimitsBkgVO[]) models.toArray(new PortLimitsBkgVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRefNo = this.dcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authDt = this.authDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoSeq = this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCompGrpCd = this.imdgCompGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNos = this.bkgNos.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCntrSeq = this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExploWgt = this.netExploWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrQty = this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portLmtSeq = this.portLmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authFlg = this.authFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plmtPortCd = this.plmtPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lmtWgtTpCd = this.lmtWgtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromEtaDt = this.fromEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toEtaDt = this.toEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plmtClptIndSeq = this.plmtClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plmtVvd = this.plmtVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
 