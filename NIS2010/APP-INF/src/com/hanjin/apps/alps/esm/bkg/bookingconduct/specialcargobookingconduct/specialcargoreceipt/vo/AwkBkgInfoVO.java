/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AwkBkgInfoVO.java
*@FileTitle : AwkBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.11.13 이병규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AwkBkgInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AwkBkgInfoVO> models = new ArrayList<AwkBkgInfoVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String vslPrePstCd = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String corrNo = null;

    /* Column Info */
    private String polNodCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String corrN1stDt = null;

    /* Column Info */
    private String actWgt = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String podNodCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String imgFlg = null;

    /* Column Info */
    private String vesselNm = null;

    /* Column Info */
    private String polNm = null;

    /* Column Info */
    private String podNm = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String xterSiRefNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public AwkBkgInfoVO() {
    }

    public AwkBkgInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgStsCd, String vslCd, String rcvTermCd, String deTermCd, String polCd, String polNodCd, String podCd, String podNodCd, String porCd, String delCd, String cmdtCd, String cmdtNm, String corrN1stDt, String corrNo, String bdrFlg, String pckQty, String pckTpCd, String grsWgt, String wgtUtCd, String vslPrePstCd, String actWgt, String imgFlg, String vesselNm, String podNm, String polNm, String stwgCd, String xterSiRefNo) {
        this.porCd = porCd;
        this.vslCd = vslCd;
        this.bkgStsCd = bkgStsCd;
        this.bdrFlg = bdrFlg;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.cmdtCd = cmdtCd;
        this.wgtUtCd = wgtUtCd;
        this.pckQty = pckQty;
        this.rcvTermCd = rcvTermCd;
        this.vslPrePstCd = vslPrePstCd;
        this.pckTpCd = pckTpCd;
        this.delCd = delCd;
        this.corrNo = corrNo;
        this.polNodCd = polNodCd;
        this.cmdtNm = cmdtNm;
        this.corrN1stDt = corrN1stDt;
        this.actWgt = actWgt;
        this.podCd = podCd;
        this.deTermCd = deTermCd;
        this.podNodCd = podNodCd;
        this.bkgNo = bkgNo;
        this.grsWgt = grsWgt;
        this.imgFlg = imgFlg;
        this.vesselNm = vesselNm;
        this.polNm = polNm;
        this.podNm = podNm;
        this.stwgCd = stwgCd;
        this.xterSiRefNo = xterSiRefNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("corr_no", getCorrNo());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("corr_n1st_dt", getCorrN1stDt());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("img_flg", getImgFlg());
        this.hashColumns.put("vessel_nm", getVesselNm());
        this.hashColumns.put("pol_nm", getPolNm());
        this.hashColumns.put("pod_nm", getPodNm());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("xter_si_ref_no", getXterSiRefNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("corr_no", "corrNo");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("corr_n1st_dt", "corrN1stDt");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("img_flg", "imgFlg");
        this.hashFields.put("vessel_nm", "vesselNm");
        this.hashFields.put("pol_nm", "polNm");
        this.hashFields.put("pod_nm", "podNm");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("xter_si_ref_no", "xterSiRefNo");
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 * Column Info
	 * @return pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 * Column Info
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	 * Column Info
	 * @return vslPrePstCd
	 */
    public String getVslPrePstCd() {
        return this.vslPrePstCd;
    }

    /**
	 * Column Info
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
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
	 * @return corrNo
	 */
    public String getCorrNo() {
        return this.corrNo;
    }

    /**
	 * Column Info
	 * @return polNodCd
	 */
    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 * Column Info
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 * Column Info
	 * @return corrN1stDt
	 */
    public String getCorrN1stDt() {
        return this.corrN1stDt;
    }

    /**
	 * Column Info
	 * @return actWgt
	 */
    public String getActWgt() {
        return this.actWgt;
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
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
    }

    /**
	 * Column Info
	 * @return podNodCd
	 */
    public String getPodNodCd() {
        return this.podNodCd;
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
	 * @return grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
    }

    /**
	 * Column Info
	 * @return imgFlg
	 */
    public String getImgFlg() {
        return this.imgFlg;
    }

    /**
	 * Column Info
	 * @return vesselNm
	 */
    public String getVesselNm() {
        return this.vesselNm;
    }

    /**
	 * Column Info
	 * @return polNm
	 */
    public String getPolNm() {
        return this.polNm;
    }

    /**
	 * Column Info
	 * @return podNm
	 */
    public String getPodNm() {
        return this.podNm;
    }

    /**
	 * Column Info
	 * @return stwgCd
	 */
    public String getStwgCd() {
        return stwgCd;
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
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @param vslPrePstCd
	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
    }

    /**
	 * Column Info
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
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
	 * @param corrNo
	 */
    public void setCorrNo(String corrNo) {
        this.corrNo = corrNo;
    }

    /**
	 * Column Info
	 * @param polNodCd
	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * Column Info
	 * @param cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * Column Info
	 * @param corrN1stDt
	 */
    public void setCorrN1stDt(String corrN1stDt) {
        this.corrN1stDt = corrN1stDt;
    }

    /**
	 * Column Info
	 * @param actWgt
	 */
    public void setActWgt(String actWgt) {
        this.actWgt = actWgt;
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
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
    }

    /**
	 * Column Info
	 * @param podNodCd
	 */
    public void setPodNodCd(String podNodCd) {
        this.podNodCd = podNodCd;
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
	 * @param grsWgt
	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * Column Info
	 * @param imgFlg
	 */
    public void setImgFlg(String imgFlg) {
        this.imgFlg = imgFlg;
    }

    /**
	 * Column Info
	 * @param vesselNm
	 */
    public void setVesselNm(String vesselNm) {
        this.vesselNm = vesselNm;
    }

    /**
	 * Column Info
	 * @param polNm
	 */
    public void setPolNm(String polNm) {
        this.polNm = polNm;
    }

    /**
	 * Column Info
	 * @param podNm
	 */
    public void setPodNm(String podNm) {
        this.podNm = podNm;
    }

    /**
	 * Column Info
	 * @param stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    public void setXterSiRefNo(String xterSiRefNo) {
        this.xterSiRefNo = xterSiRefNo;
    }

    public String getXterSiRefNo() {
        return this.xterSiRefNo;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
        setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
        setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
        setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
        setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
        setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
        setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
        setCorrN1stDt(JSPUtil.getParameter(request, "corr_n1st_dt", ""));
        setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
        setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
        setImgFlg(JSPUtil.getParameter(request, "img_flg", ""));
        setVesselNm(JSPUtil.getParameter(request, "vessel_nm", ""));
        setPolNm(JSPUtil.getParameter(request, "pol_nm", ""));
        setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
        setStwgCd(JSPUtil.getParameter(request, "stwg_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AwkBkgInfoVO[]
	 */
    public AwkBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AwkBkgInfoVO[]
	 */
    public AwkBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AwkBkgInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] corrNo = (JSPUtil.getParameter(request, prefix + "corr_no", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] corrN1stDt = (JSPUtil.getParameter(request, prefix + "corr_n1st_dt", length));
            String[] actWgt = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] imgFlg = (JSPUtil.getParameter(request, prefix + "img_flg", length));
            String[] vesselNm = (JSPUtil.getParameter(request, prefix + "vessel_nm", length));
            String[] polNm = (JSPUtil.getParameter(request, prefix + "pol_nm", length));
            String[] podNm = (JSPUtil.getParameter(request, prefix + "pod_nm", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] xterSiRefNo = (JSPUtil.getParameter(request, prefix + "xter_si_ref_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AwkBkgInfoVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (corrNo[i] != null)
                    model.setCorrNo(corrNo[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (corrN1stDt[i] != null)
                    model.setCorrN1stDt(corrN1stDt[i]);
                if (actWgt[i] != null)
                    model.setActWgt(actWgt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (podNodCd[i] != null)
                    model.setPodNodCd(podNodCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (imgFlg[i] != null)
                    model.setImgFlg(imgFlg[i]);
                if (vesselNm[i] != null)
                    model.setVesselNm(vesselNm[i]);
                if (polNm[i] != null)
                    model.setPolNm(polNm[i]);
                if (podNm[i] != null)
                    model.setPodNm(podNm[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (xterSiRefNo[i] != null) 
		    		model.setXterSiRefNo(xterSiRefNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAwkBkgInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AwkBkgInfoVO[]
	 */
    public AwkBkgInfoVO[] getAwkBkgInfoVOs() {
        AwkBkgInfoVO[] vos = (AwkBkgInfoVO[]) models.toArray(new AwkBkgInfoVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corrNo = this.corrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corrN1stDt = this.corrN1stDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imgFlg = this.imgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vesselNm = this.vesselNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNm = this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNm = this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSiRefNo = this.xterSiRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
