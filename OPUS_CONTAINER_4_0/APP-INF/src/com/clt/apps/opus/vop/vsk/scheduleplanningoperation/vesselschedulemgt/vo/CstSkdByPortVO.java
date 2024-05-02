/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CstSkdByPortVO.java
*@FileTitle : CstSkdByPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.02 정진우 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CstSkdByPortVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CstSkdByPortVO> models = new ArrayList<CstSkdByPortVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String pfEtd = null;

    /* Column Info */
    private String pfEtb = null;

    /* Column Info */
    private String polYard = null;

    /* Column Info */
    private String delyEtdTm = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polEtd = null;

    /* Column Info */
    private String nextEta = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String polEta = null;

    /* Column Info */
    private String delyEtbTm = null;

    /* Column Info */
    private String polEtb = null;

    /* Column Info */
    private String nextPort = null;

    /* Column Info */
    private String fmDt = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String polTmlCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String carrierCd = null;

    /* Column Info */
    private String toDt = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String nextYard = null;

    /* Column Info */
    private String typeCd = null;

    /* Column Info */
    private String polPort = null;

    /* Column Info */
    private String polYardNm = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String cgoClzDt = null;

    /* Column Info */
    private String dcgoClzDt = null;

    /* Column Info */
    private String rcClzDt = null;

    /* Column Info */
    private String vgmClzDt = null;

    /* Column Info */
    private String awkCgoClzDt = null;

    /* Column Info */
    private String bbCgoClzDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CstSkdByPortVO() {
    }

    public CstSkdByPortVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String vslEngNm, String vslSlanCd, String polPort, String polYard, String polTmlCd, String polEta, String polEtb, String polEtd, String nextPort, String nextYard, String nextEta, String pfEtb, String pfEtd, String delyEtbTm, String delyEtdTm, String carrierCd, String vpsPortCd, String typeCd, String fmDt, String toDt, String polYardNm, String ibCssmVoyNo, String obCssmVoyNo, String cgoClzDt, String dcgoClzDt, String rcClzDt, String vgmClzDt, String awkCgoClzDt, String bbCgoClzDt) {
        this.vslCd = vslCd;
        this.pfEtd = pfEtd;
        this.pfEtb = pfEtb;
        this.polYard = polYard;
        this.delyEtdTm = delyEtdTm;
        this.vslSlanCd = vslSlanCd;
        this.pagerows = pagerows;
        this.polEtd = polEtd;
        this.nextEta = nextEta;
        this.vpsPortCd = vpsPortCd;
        this.ibflag = ibflag;
        this.vslEngNm = vslEngNm;
        this.polEta = polEta;
        this.delyEtbTm = delyEtbTm;
        this.polEtb = polEtb;
        this.nextPort = nextPort;
        this.fmDt = fmDt;
        this.skdVoyNo = skdVoyNo;
        this.polTmlCd = polTmlCd;
        this.skdDirCd = skdDirCd;
        this.carrierCd = carrierCd;
        this.toDt = toDt;
        this.vvd = vvd;
        this.nextYard = nextYard;
        this.typeCd = typeCd;
        this.polPort = polPort;
        this.polYardNm = polYardNm;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.cgoClzDt = cgoClzDt;
        this.dcgoClzDt = dcgoClzDt;
        this.rcClzDt = rcClzDt;
        this.vgmClzDt = vgmClzDt;
        this.awkCgoClzDt = awkCgoClzDt;
        this.bbCgoClzDt = bbCgoClzDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("pf_etd", getPfEtd());
        this.hashColumns.put("pf_etb", getPfEtb());
        this.hashColumns.put("pol_yard", getPolYard());
        this.hashColumns.put("dely_etd_tm", getDelyEtdTm());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_etd", getPolEtd());
        this.hashColumns.put("next_eta", getNextEta());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("pol_eta", getPolEta());
        this.hashColumns.put("dely_etb_tm", getDelyEtbTm());
        this.hashColumns.put("pol_etb", getPolEtb());
        this.hashColumns.put("next_port", getNextPort());
        this.hashColumns.put("fm_dt", getFmDt());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("pol_tml_cd", getPolTmlCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("carrier_cd", getCarrierCd());
        this.hashColumns.put("to_dt", getToDt());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("next_yard", getNextYard());
        this.hashColumns.put("type_cd", getTypeCd());
        this.hashColumns.put("pol_port", getPolPort());
        this.hashColumns.put("pol_yard_nm", getPolYardNm());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("cgo_clz_dt", getCgoClzDt());
        this.hashColumns.put("dcgo_clz_dt", getDcgoClzDt());
        this.hashColumns.put("rc_clz_dt", getRcClzDt());
        this.hashColumns.put("vgm_clz_dt", getVgmClzDt());
        this.hashColumns.put("awk_cgo_clz_dt", getAwkCgoClzDt());
        this.hashColumns.put("bb_cgo_clz_dt", getBbCgoClzDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("pf_etd", "pfEtd");
        this.hashFields.put("pf_etb", "pfEtb");
        this.hashFields.put("pol_yard", "polYard");
        this.hashFields.put("dely_etd_tm", "delyEtdTm");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_etd", "polEtd");
        this.hashFields.put("next_eta", "nextEta");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("pol_eta", "polEta");
        this.hashFields.put("dely_etb_tm", "delyEtbTm");
        this.hashFields.put("pol_etb", "polEtb");
        this.hashFields.put("next_port", "nextPort");
        this.hashFields.put("fm_dt", "fmDt");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("pol_tml_cd", "polTmlCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("carrier_cd", "carrierCd");
        this.hashFields.put("to_dt", "toDt");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("next_yard", "nextYard");
        this.hashFields.put("type_cd", "typeCd");
        this.hashFields.put("pol_port", "polPort");
        this.hashFields.put("pol_yard_nm", "polYardNm");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("cgo_clz_dt", "cgoClzDt");
        this.hashFields.put("dcgo_clz_dt", "dcgoClzDt");
        this.hashFields.put("rc_clz_dt", "rcClzDt");
        this.hashFields.put("vgm_clz_dt", "vgmClzDt");
        this.hashFields.put("awk_cgo_clz_dt", "awkCgoClzDt");
        this.hashFields.put("bb_cgo_clz_dt", "bbCgoClzDt");
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
	 * @return pfEtd
	 */
    public String getPfEtd() {
        return this.pfEtd;
    }

    /**
	 * Column Info
	 * @return pfEtb
	 */
    public String getPfEtb() {
        return this.pfEtb;
    }

    /**
	 * Column Info
	 * @return polYard
	 */
    public String getPolYard() {
        return this.polYard;
    }

    /**
	 * Column Info
	 * @return delyEtdTm
	 */
    public String getDelyEtdTm() {
        return this.delyEtdTm;
    }

    /**
	 * Column Info
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
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
	 * @return polEtd
	 */
    public String getPolEtd() {
        return this.polEtd;
    }

    /**
	 * Column Info
	 * @return nextEta
	 */
    public String getNextEta() {
        return this.nextEta;
    }

    /**
	 * Column Info
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
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
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @return polEta
	 */
    public String getPolEta() {
        return this.polEta;
    }

    /**
	 * Column Info
	 * @return delyEtbTm
	 */
    public String getDelyEtbTm() {
        return this.delyEtbTm;
    }

    /**
	 * Column Info
	 * @return polEtb
	 */
    public String getPolEtb() {
        return this.polEtb;
    }

    /**
	 * Column Info
	 * @return nextPort
	 */
    public String getNextPort() {
        return this.nextPort;
    }

    /**
	 * Column Info
	 * @return fmDt
	 */
    public String getFmDt() {
        return this.fmDt;
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
	 * @return polTmlCd
	 */
    public String getPolTmlCd() {
        return this.polTmlCd;
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
	 * @return carrierCd
	 */
    public String getCarrierCd() {
        return this.carrierCd;
    }

    /**
	 * Column Info
	 * @return toDt
	 */
    public String getToDt() {
        return this.toDt;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return nextYard
	 */
    public String getNextYard() {
        return this.nextYard;
    }

    /**
	 * Column Info
	 * @return typeCd
	 */
    public String getTypeCd() {
        return this.typeCd;
    }

    /**
	 * Column Info
	 * @return polPort
	 */
    public String getPolPort() {
        return this.polPort;
    }

    /**
	 * Column Info
	 * @return polYardNm
	 */
    public String getPolYardNm() {
        return this.polYardNm;
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
	 * @param pfEtd
	 */
    public void setPfEtd(String pfEtd) {
        this.pfEtd = pfEtd;
    }

    /**
	 * Column Info
	 * @param pfEtb
	 */
    public void setPfEtb(String pfEtb) {
        this.pfEtb = pfEtb;
    }

    /**
	 * Column Info
	 * @param polYard
	 */
    public void setPolYard(String polYard) {
        this.polYard = polYard;
    }

    /**
	 * Column Info
	 * @param delyEtdTm
	 */
    public void setDelyEtdTm(String delyEtdTm) {
        this.delyEtdTm = delyEtdTm;
    }

    /**
	 * Column Info
	 * @param vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
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
	 * @param polEtd
	 */
    public void setPolEtd(String polEtd) {
        this.polEtd = polEtd;
    }

    /**
	 * Column Info
	 * @param nextEta
	 */
    public void setNextEta(String nextEta) {
        this.nextEta = nextEta;
    }

    /**
	 * Column Info
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
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
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param polEta
	 */
    public void setPolEta(String polEta) {
        this.polEta = polEta;
    }

    /**
	 * Column Info
	 * @param delyEtbTm
	 */
    public void setDelyEtbTm(String delyEtbTm) {
        this.delyEtbTm = delyEtbTm;
    }

    /**
	 * Column Info
	 * @param polEtb
	 */
    public void setPolEtb(String polEtb) {
        this.polEtb = polEtb;
    }

    /**
	 * Column Info
	 * @param nextPort
	 */
    public void setNextPort(String nextPort) {
        this.nextPort = nextPort;
    }

    /**
	 * Column Info
	 * @param fmDt
	 */
    public void setFmDt(String fmDt) {
        this.fmDt = fmDt;
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
	 * @param polTmlCd
	 */
    public void setPolTmlCd(String polTmlCd) {
        this.polTmlCd = polTmlCd;
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
	 * @param carrierCd
	 */
    public void setCarrierCd(String carrierCd) {
        this.carrierCd = carrierCd;
    }

    /**
	 * Column Info
	 * @param toDt
	 */
    public void setToDt(String toDt) {
        this.toDt = toDt;
    }

    /**
	 * Column Info
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param nextYard
	 */
    public void setNextYard(String nextYard) {
        this.nextYard = nextYard;
    }

    /**
	 * Column Info
	 * @param typeCd
	 */
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    /**
	 * Column Info
	 * @param polPort
	 */
    public void setPolPort(String polPort) {
        this.polPort = polPort;
    }

    /**
	 * Column Info
	 * @param polYardNm
	 */
    public void setPolYardNm(String polYardNm) {
        this.polYardNm = polYardNm;
    }

    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    public void setCgoClzDt(String cgoClzDt) {
        this.cgoClzDt = cgoClzDt;
    }

    public String getCgoClzDt() {
        return this.cgoClzDt;
    }

    public void setDcgoClzDt(String dcgoClzDt) {
        this.dcgoClzDt = dcgoClzDt;
    }

    public String getDcgoClzDt() {
        return this.dcgoClzDt;
    }

    public void setRcClzDt(String rcClzDt) {
        this.rcClzDt = rcClzDt;
    }

    public String getRcClzDt() {
        return this.rcClzDt;
    }

    public void setVgmClzDt(String vgmClzDt) {
        this.vgmClzDt = vgmClzDt;
    }

    public String getVgmClzDt() {
        return this.vgmClzDt;
    }

    public void setAwkCgoClzDt(String awkCgoClzDt) {
        this.awkCgoClzDt = awkCgoClzDt;
    }

    public String getAwkCgoClzDt() {
        return this.awkCgoClzDt;
    }

    public void setBbCgoClzDt(String bbCgoClzDt) {
        this.bbCgoClzDt = bbCgoClzDt;
    }

    public String getBbCgoClzDt() {
        return this.bbCgoClzDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setPfEtd(JSPUtil.getParameter(request, "pf_etd", ""));
        setPfEtb(JSPUtil.getParameter(request, "pf_etb", ""));
        setPolYard(JSPUtil.getParameter(request, "pol_yard", ""));
        setDelyEtdTm(JSPUtil.getParameter(request, "dely_etd_tm", ""));
        setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPolEtd(JSPUtil.getParameter(request, "pol_etd", ""));
        setNextEta(JSPUtil.getParameter(request, "next_eta", ""));
        setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
        setPolEta(JSPUtil.getParameter(request, "pol_eta", ""));
        setDelyEtbTm(JSPUtil.getParameter(request, "dely_etb_tm", ""));
        setPolEtb(JSPUtil.getParameter(request, "pol_etb", ""));
        setNextPort(JSPUtil.getParameter(request, "next_port", ""));
        setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setPolTmlCd(JSPUtil.getParameter(request, "pol_tml_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setCarrierCd(JSPUtil.getParameter(request, "carrier_cd", ""));
        setToDt(JSPUtil.getParameter(request, "to_dt", ""));
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setNextYard(JSPUtil.getParameter(request, "next_yard", ""));
        setTypeCd(JSPUtil.getParameter(request, "type_cd", ""));
        setPolPort(JSPUtil.getParameter(request, "pol_port", ""));
        setPolYardNm(JSPUtil.getParameter(request, "pol_yard_nm", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, "ob_cssm_voy_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstSkdByPortVO[]
	 */
    public CstSkdByPortVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstSkdByPortVO[]
	 */
    public CstSkdByPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CstSkdByPortVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] pfEtd = (JSPUtil.getParameter(request, prefix + "pf_etd", length));
            String[] pfEtb = (JSPUtil.getParameter(request, prefix + "pf_etb", length));
            String[] polYard = (JSPUtil.getParameter(request, prefix + "pol_yard", length));
            String[] delyEtdTm = (JSPUtil.getParameter(request, prefix + "dely_etd_tm", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polEtd = (JSPUtil.getParameter(request, prefix + "pol_etd", length));
            String[] nextEta = (JSPUtil.getParameter(request, prefix + "next_eta", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] polEta = (JSPUtil.getParameter(request, prefix + "pol_eta", length));
            String[] delyEtbTm = (JSPUtil.getParameter(request, prefix + "dely_etb_tm", length));
            String[] polEtb = (JSPUtil.getParameter(request, prefix + "pol_etb", length));
            String[] nextPort = (JSPUtil.getParameter(request, prefix + "next_port", length));
            String[] fmDt = (JSPUtil.getParameter(request, prefix + "fm_dt", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] polTmlCd = (JSPUtil.getParameter(request, prefix + "pol_tml_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] carrierCd = (JSPUtil.getParameter(request, prefix + "carrier_cd", length));
            String[] toDt = (JSPUtil.getParameter(request, prefix + "to_dt", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] nextYard = (JSPUtil.getParameter(request, prefix + "next_yard", length));
            String[] typeCd = (JSPUtil.getParameter(request, prefix + "type_cd", length));
            String[] polPort = (JSPUtil.getParameter(request, prefix + "pol_port", length));
            String[] polYardNm = (JSPUtil.getParameter(request, prefix + "pol_yard_nm", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] cgoClzDt = (JSPUtil.getParameter(request, prefix + "cgo_clz_dt", length));
            String[] dcgoClzDt = (JSPUtil.getParameter(request, prefix + "dcgo_clz_dt", length));
            String[] rcClzDt = (JSPUtil.getParameter(request, prefix + "rc_clz_dt", length));
            String[] vgmClzDt = (JSPUtil.getParameter(request, prefix + "vgm_clz_dt", length));
            String[] awkCgoClzDt = (JSPUtil.getParameter(request, prefix + "awk_cgo_clz_dt", length));
	    	String[] bbCgoClzDt = (JSPUtil.getParameter(request, prefix + "bb_cgo_clz_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CstSkdByPortVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (pfEtd[i] != null)
                    model.setPfEtd(pfEtd[i]);
                if (pfEtb[i] != null)
                    model.setPfEtb(pfEtb[i]);
                if (polYard[i] != null)
                    model.setPolYard(polYard[i]);
                if (delyEtdTm[i] != null)
                    model.setDelyEtdTm(delyEtdTm[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polEtd[i] != null)
                    model.setPolEtd(polEtd[i]);
                if (nextEta[i] != null)
                    model.setNextEta(nextEta[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (polEta[i] != null)
                    model.setPolEta(polEta[i]);
                if (delyEtbTm[i] != null)
                    model.setDelyEtbTm(delyEtbTm[i]);
                if (polEtb[i] != null)
                    model.setPolEtb(polEtb[i]);
                if (nextPort[i] != null)
                    model.setNextPort(nextPort[i]);
                if (fmDt[i] != null)
                    model.setFmDt(fmDt[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (polTmlCd[i] != null)
                    model.setPolTmlCd(polTmlCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (carrierCd[i] != null)
                    model.setCarrierCd(carrierCd[i]);
                if (toDt[i] != null)
                    model.setToDt(toDt[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (nextYard[i] != null)
                    model.setNextYard(nextYard[i]);
                if (typeCd[i] != null)
                    model.setTypeCd(typeCd[i]);
                if (polPort[i] != null)
                    model.setPolPort(polPort[i]);
                if (polYardNm[i] != null)
                    model.setPolYardNm(polYardNm[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (cgoClzDt[i] != null)
                    model.setCgoClzDt(cgoClzDt[i]);
                if (dcgoClzDt[i] != null)
                    model.setDcgoClzDt(dcgoClzDt[i]);
                if (rcClzDt[i] != null)
                    model.setRcClzDt(rcClzDt[i]);
                if (vgmClzDt[i] != null)
                    model.setVgmClzDt(vgmClzDt[i]);
                if (awkCgoClzDt[i] != null) 
		    		model.setAwkCgoClzDt(awkCgoClzDt[i]);
				if (bbCgoClzDt[i] != null) 
		    		model.setBbCgoClzDt(bbCgoClzDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCstSkdByPortVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CstSkdByPortVO[]
	 */
    public CstSkdByPortVO[] getCstSkdByPortVOs() {
        CstSkdByPortVO[] vos = (CstSkdByPortVO[]) models.toArray(new CstSkdByPortVO[models.size()]);
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
        this.pfEtd = this.pfEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtb = this.pfEtb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYard = this.polYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delyEtdTm = this.delyEtdTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEtd = this.polEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextEta = this.nextEta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEta = this.polEta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delyEtbTm = this.delyEtbTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEtb = this.polEtb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextPort = this.nextPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmDt = this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polTmlCd = this.polTmlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.carrierCd = this.carrierCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDt = this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextYard = this.nextYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.typeCd = this.typeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polPort = this.polPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYardNm = this.polYardNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoClzDt = this.cgoClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoClzDt = this.dcgoClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcClzDt = this.rcClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmClzDt = this.vgmClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoClzDt = this.awkCgoClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoClzDt = this.bbCgoClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
