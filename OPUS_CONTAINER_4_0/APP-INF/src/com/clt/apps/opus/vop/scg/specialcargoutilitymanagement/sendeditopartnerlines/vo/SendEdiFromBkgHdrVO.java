/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendEdiFromBkgHdrVO.java
 *@FileTitle : SendEdiFromBkgHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.17
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.17 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.vo;

import java.lang.reflect.Field;
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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class SendEdiFromBkgHdrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SendEdiFromBkgHdrVO> models = new ArrayList<SendEdiFromBkgHdrVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String bkgDt = null;

    /*	Column Info	*/
    private String blNo = null;

    /*	Column Info	*/
    private String bkgStsCd = null;

    /*	Column Info	*/
    private String vvd = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String vesselNm = null;

    /*	Column Info	*/
    private String rcvTermCd = null;

    /*	Column Info	*/
    private String deTermCd = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String polNm = null;

    /*	Column Info	*/
    private String polNodCd = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String podNm = null;

    /*	Column Info	*/
    private String podNodCd = null;

    /*	Column Info	*/
    private String porCd = null;

    /*	Column Info	*/
    private String porNm = null;

    /*	Column Info	*/
    private String delCd = null;

    /*	Column Info	*/
    private String delNm = null;

    /*	Column Info	*/
    private String cmdtCd = null;

    /*	Column Info	*/
    private String cmdtNm = null;

    /*	Column Info	*/
    private String flexHgtFlg = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String callSgnNo = null;

    /*	Column Info	*/
    private String lloydNo = null;

    /*	Column Info	*/
    private String vslEngNm = null;

    /*	Column Info	*/
    private String obCssmVoyNo = null;

    /*	Column Info	*/
    private String ediMsgStsCd = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String podClptIndSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public SendEdiFromBkgHdrVO() {
    }

    public SendEdiFromBkgHdrVO(String ibflag, String pagerows, String bkgNo, String bkgDt, String blNo, String bkgStsCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String vesselNm, String rcvTermCd, String deTermCd, String polCd, String polNm, String polNodCd, String podCd, String podNm, String podNodCd, String porCd, String porNm, String delCd, String delNm, String cmdtCd, String cmdtNm, String flexHgtFlg, String slanCd, String callSgnNo, String lloydNo, String vslEngNm, String obCssmVoyNo, String ediMsgStsCd, String polClptIndSeq, String podClptIndSeq) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.bkgDt = bkgDt;
        this.blNo = blNo;
        this.bkgStsCd = bkgStsCd;
        this.vvd = vvd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.vesselNm = vesselNm;
        this.rcvTermCd = rcvTermCd;
        this.deTermCd = deTermCd;
        this.polCd = polCd;
        this.polNm = polNm;
        this.polNodCd = polNodCd;
        this.podCd = podCd;
        this.podNm = podNm;
        this.podNodCd = podNodCd;
        this.porCd = porCd;
        this.porNm = porNm;
        this.delCd = delCd;
        this.delNm = delNm;
        this.cmdtCd = cmdtCd;
        this.cmdtNm = cmdtNm;
        this.flexHgtFlg = flexHgtFlg;
        this.slanCd = slanCd;
        this.callSgnNo = callSgnNo;
        this.lloydNo = lloydNo;
        this.vslEngNm = vslEngNm;
        this.obCssmVoyNo = obCssmVoyNo;
        this.ediMsgStsCd = ediMsgStsCd;
        this.polClptIndSeq = polClptIndSeq;
        this.podClptIndSeq = podClptIndSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bkg_dt", getBkgDt());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("vessel_nm", getVesselNm());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pol_nm", getPolNm());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pod_nm", getPodNm());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("por_nm", getPorNm());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("del_nm", getDelNm());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("edi_msg_sts_cd", getEdiMsgStsCd());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bkg_dt", "bkgDt");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("vessel_nm", "vesselNm");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pol_nm", "polNm");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pod_nm", "podNm");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("por_nm", "porNm");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("del_nm", "delNm");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("edi_msg_sts_cd", "ediMsgStsCd");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return bkgDt
	 */
    public String getBkgDt() {
        return this.bkgDt;
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
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
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
	 * @return vesselNm
	 */
    public String getVesselNm() {
        return this.vesselNm;
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
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
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
	 * @return polNm
	 */
    public String getPolNm() {
        return this.polNm;
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
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
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
	 * @return podNodCd
	 */
    public String getPodNodCd() {
        return this.podNodCd;
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
	 * @return porNm
	 */
    public String getPorNm() {
        return this.porNm;
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
	 * @return delNm
	 */
    public String getDelNm() {
        return this.delNm;
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
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 * Column Info
	 * @return flexHgtFlg
	 */
    public String getFlexHgtFlg() {
        return this.flexHgtFlg;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 * Column Info
	 * @return callSgnNo
	 */
    public String getCallSgnNo() {
        return this.callSgnNo;
    }

    /**
	 * Column Info
	 * @return lloydNo
	 */
    public String getLloydNo() {
        return this.lloydNo;
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
	 * @return obCssmVoyNo
	 */
    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return ediMsgStsCd
	 */
    public String getEdiMsgStsCd() {
        return this.ediMsgStsCd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  bkgNo
 	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param  bkgDt
 	 */
    public void setBkgDt(String bkgDt) {
        this.bkgDt = bkgDt;
    }

    /**
	 * Column Info
	 * @param  blNo
 	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param  bkgStsCd
 	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param  vvd
 	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param  skdVoyNo
 	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  vesselNm
 	 */
    public void setVesselNm(String vesselNm) {
        this.vesselNm = vesselNm;
    }

    /**
	 * Column Info
	 * @param  rcvTermCd
 	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @param  deTermCd
 	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
    }

    /**
	 * Column Info
	 * @param  polCd
 	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param  polNm
 	 */
    public void setPolNm(String polNm) {
        this.polNm = polNm;
    }

    /**
	 * Column Info
	 * @param  polNodCd
 	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * Column Info
	 * @param  podCd
 	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param  podNm
 	 */
    public void setPodNm(String podNm) {
        this.podNm = podNm;
    }

    /**
	 * Column Info
	 * @param  podNodCd
 	 */
    public void setPodNodCd(String podNodCd) {
        this.podNodCd = podNodCd;
    }

    /**
	 * Column Info
	 * @param  porCd
 	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param  porNm
 	 */
    public void setPorNm(String porNm) {
        this.porNm = porNm;
    }

    /**
	 * Column Info
	 * @param  delCd
 	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param  delNm
 	 */
    public void setDelNm(String delNm) {
        this.delNm = delNm;
    }

    /**
	 * Column Info
	 * @param  cmdtCd
 	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param  cmdtNm
 	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * Column Info
	 * @param  flexHgtFlg
 	 */
    public void setFlexHgtFlg(String flexHgtFlg) {
        this.flexHgtFlg = flexHgtFlg;
    }

    /**
	 * Column Info
	 * @param  slanCd
 	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param  callSgnNo
 	 */
    public void setCallSgnNo(String callSgnNo) {
        this.callSgnNo = callSgnNo;
    }

    /**
	 * Column Info
	 * @param  lloydNo
 	 */
    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
    }

    /**
	 * Column Info
	 * @param  vslEngNm
 	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param  obCssmVoyNo
 	 */
    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param  ediMsgStsCd
 	 */
    public void setEdiMsgStsCd(String ediMsgStsCd) {
        this.ediMsgStsCd = ediMsgStsCd;
    }

    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBkgDt(JSPUtil.getParameter(request, prefix + "bkg_dt", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setVesselNm(JSPUtil.getParameter(request, prefix + "vessel_nm", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
        setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setEdiMsgStsCd(JSPUtil.getParameter(request, prefix + "edi_msg_sts_cd", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendEdiFromBkgHdrVO[]
	 */
    public SendEdiFromBkgHdrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendEdiFromBkgHdrVO[]
	 */
    public SendEdiFromBkgHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SendEdiFromBkgHdrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] bkgDt = (JSPUtil.getParameter(request, prefix + "bkg_dt", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] vesselNm = (JSPUtil.getParameter(request, prefix + "vessel_nm", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] polNm = (JSPUtil.getParameter(request, prefix + "pol_nm", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] podNm = (JSPUtil.getParameter(request, prefix + "pod_nm", length));
            String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] porNm = (JSPUtil.getParameter(request, prefix + "por_nm", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] delNm = (JSPUtil.getParameter(request, prefix + "del_nm", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix + "flex_hgt_flg", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] ediMsgStsCd = (JSPUtil.getParameter(request, prefix + "edi_msg_sts_cd", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
	    	String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SendEdiFromBkgHdrVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (bkgDt[i] != null)
                    model.setBkgDt(bkgDt[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (vesselNm[i] != null)
                    model.setVesselNm(vesselNm[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (polNm[i] != null)
                    model.setPolNm(polNm[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (podNm[i] != null)
                    model.setPodNm(podNm[i]);
                if (podNodCd[i] != null)
                    model.setPodNodCd(podNodCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (porNm[i] != null)
                    model.setPorNm(porNm[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (delNm[i] != null)
                    model.setDelNm(delNm[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (flexHgtFlg[i] != null)
                    model.setFlexHgtFlg(flexHgtFlg[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (ediMsgStsCd[i] != null)
                    model.setEdiMsgStsCd(ediMsgStsCd[i]);
                if (polClptIndSeq[i] != null) 
		    		model.setPolClptIndSeq(polClptIndSeq[i]);
				if (podClptIndSeq[i] != null) 
		    		model.setPodClptIndSeq(podClptIndSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSendEdiFromBkgHdrVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return SendEdiFromBkgHdrVO[]
	 */
    public SendEdiFromBkgHdrVO[] getSendEdiFromBkgHdrVOs() {
        SendEdiFromBkgHdrVO[] vos = (SendEdiFromBkgHdrVO[]) models.toArray(new SendEdiFromBkgHdrVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgDt = this.bkgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vesselNm = this.vesselNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNm = this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNm = this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNm = this.porNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNm = this.delNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flexHgtFlg = this.flexHgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediMsgStsCd = this.ediMsgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
