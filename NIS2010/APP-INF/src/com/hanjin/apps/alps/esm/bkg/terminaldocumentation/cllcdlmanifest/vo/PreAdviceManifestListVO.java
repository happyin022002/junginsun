/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PreAdviceManifestListVO.java
*@FileTitle : PreAdviceManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.04
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.09.04 조원주 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PreAdviceManifestListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PreAdviceManifestListVO> models = new ArrayList<PreAdviceManifestListVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String cntrSz = null;

    /* Column Info */
    private String groupTitle = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String height = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String blckStwgCd = null;

    /* Column Info */
    private String imdgUnNo = null;

    /* Column Info */
    private String cntrWgt = null;

    /* Column Info */
    private String orgPpdRcvCd = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String tempUnit = null;

    /* Column Info */
    private String ventRto = null;

    /* Column Info */
    private String cntrTp = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String ventRtoUnit = null;

    /* Column Info */
    private String cdoTemp = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String dischPort1 = null;

    /* Column Info */
    private String cntrSealNo = null;

    /* Column Info */
    private String dischPort2 = null;

    /* Column Info */
    private String imdgClssCd = null;

    /* Column Info */
    private String lineCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public PreAdviceManifestListVO() {
    }

    public PreAdviceManifestListVO(String ibflag, String pagerows, String lineCd, String custNm, String cntrNo, String cntrTpszCd, String cntrSz, String cntrTp, String height, String porCd, String polCd, String vslEngNm, String skdVoyNo, String bkgNo, String cntrWgt, String wgtUtCd, String bkgCgoTpCd, String dischPort1, String dischPort2, String delCd, String cdoTemp, String tempUnit, String ventRto, String ventRtoUnit, String imdgClssCd, String imdgUnNo, String cntrSealNo, String orgPpdRcvCd, String cmdtCd, String stwgCd, String blckStwgCd, String awkCgoFlg, String groupTitle, String cmdtNm) {
        this.porCd = porCd;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.custNm = custNm;
        this.cntrSz = cntrSz;
        this.groupTitle = groupTitle;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.height = height;
        this.vslEngNm = vslEngNm;
        this.cmdtCd = cmdtCd;
        this.cntrTpszCd = cntrTpszCd;
        this.wgtUtCd = wgtUtCd;
        this.stwgCd = stwgCd;
        this.blckStwgCd = blckStwgCd;
        this.imdgUnNo = imdgUnNo;
        this.cntrWgt = cntrWgt;
        this.orgPpdRcvCd = orgPpdRcvCd;
        this.awkCgoFlg = awkCgoFlg;
        this.delCd = delCd;
        this.skdVoyNo = skdVoyNo;
        this.tempUnit = tempUnit;
        this.ventRto = ventRto;
        this.cntrTp = cntrTp;
        this.bkgNo = bkgNo;
        this.ventRtoUnit = ventRtoUnit;
        this.cdoTemp = cdoTemp;
        this.cntrNo = cntrNo;
        this.dischPort1 = dischPort1;
        this.cntrSealNo = cntrSealNo;
        this.dischPort2 = dischPort2;
        this.imdgClssCd = imdgClssCd;
        this.lineCd = lineCd;
        this.cmdtNm = cmdtNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cntr_sz", getCntrSz());
        this.hashColumns.put("group_title", getGroupTitle());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("height", getHeight());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        this.hashColumns.put("org_ppd_rcv_cd", getOrgPpdRcvCd());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("temp_unit", getTempUnit());
        this.hashColumns.put("vent_rto", getVentRto());
        this.hashColumns.put("cntr_tp", getCntrTp());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("vent_rto_unit", getVentRtoUnit());
        this.hashColumns.put("cdo_temp", getCdoTemp());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("disch_port1", getDischPort1());
        this.hashColumns.put("cntr_seal_no", getCntrSealNo());
        this.hashColumns.put("disch_port2", getDischPort2());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("line_cd", getLineCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cntr_sz", "cntrSz");
        this.hashFields.put("group_title", "groupTitle");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("height", "height");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("blck_stwg_cd", "blckStwgCd");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        this.hashFields.put("org_ppd_rcv_cd", "orgPpdRcvCd");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("temp_unit", "tempUnit");
        this.hashFields.put("vent_rto", "ventRto");
        this.hashFields.put("cntr_tp", "cntrTp");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("vent_rto_unit", "ventRtoUnit");
        this.hashFields.put("cdo_temp", "cdoTemp");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("disch_port1", "dischPort1");
        this.hashFields.put("cntr_seal_no", "cntrSealNo");
        this.hashFields.put("disch_port2", "dischPort2");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("line_cd", "lineCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
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
	 * @return bkgCgoTpCd
	 */
    public String getBkgCgoTpCd() {
        return this.bkgCgoTpCd;
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
	 * @return cntrSz
	 */
    public String getCntrSz() {
        return this.cntrSz;
    }

    /**
	 * Column Info
	 * @return groupTitle
	 */
    public String getGroupTitle() {
        return this.groupTitle;
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
	 * @return height
	 */
    public String getHeight() {
        return this.height;
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
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
	 * @return wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 * Column Info
	 * @return stwgCd
	 */
    public String getStwgCd() {
        return this.stwgCd;
    }

    /**
	 * Column Info
	 * @return blckStwgCd
	 */
    public String getBlckStwgCd() {
        return this.blckStwgCd;
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
	 * @return cntrWgt
	 */
    public String getCntrWgt() {
        return this.cntrWgt;
    }

    /**
	 * Column Info
	 * @return orgPpdRcvCd
	 */
    public String getOrgPpdRcvCd() {
        return this.orgPpdRcvCd;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return tempUnit
	 */
    public String getTempUnit() {
        return this.tempUnit;
    }

    /**
	 * Column Info
	 * @return ventRto
	 */
    public String getVentRto() {
        return this.ventRto;
    }

    /**
	 * Column Info
	 * @return cntrTp
	 */
    public String getCntrTp() {
        return this.cntrTp;
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
	 * @return ventRtoUnit
	 */
    public String getVentRtoUnit() {
        return this.ventRtoUnit;
    }

    /**
	 * Column Info
	 * @return cdoTemp
	 */
    public String getCdoTemp() {
        return this.cdoTemp;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return dischPort1
	 */
    public String getDischPort1() {
        return this.dischPort1;
    }

    /**
	 * Column Info
	 * @return cntrSealNo
	 */
    public String getCntrSealNo() {
        return this.cntrSealNo;
    }

    /**
	 * Column Info
	 * @return dischPort2
	 */
    public String getDischPort2() {
        return this.dischPort2;
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
	 * @return lineCd
	 */
    public String getLineCd() {
        return this.lineCd;
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
	 * @param bkgCgoTpCd
	 */
    public void setBkgCgoTpCd(String bkgCgoTpCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param cntrSz
	 */
    public void setCntrSz(String cntrSz) {
        this.cntrSz = cntrSz;
    }

    /**
	 * Column Info
	 * @param groupTitle
	 */
    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
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
	 * @param height
	 */
    public void setHeight(String height) {
        this.height = height;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
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
	 * @param wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    /**
	 * Column Info
	 * @param blckStwgCd
	 */
    public void setBlckStwgCd(String blckStwgCd) {
        this.blckStwgCd = blckStwgCd;
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
	 * @param cntrWgt
	 */
    public void setCntrWgt(String cntrWgt) {
        this.cntrWgt = cntrWgt;
    }

    /**
	 * Column Info
	 * @param orgPpdRcvCd
	 */
    public void setOrgPpdRcvCd(String orgPpdRcvCd) {
        this.orgPpdRcvCd = orgPpdRcvCd;
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
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param tempUnit
	 */
    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }

    /**
	 * Column Info
	 * @param ventRto
	 */
    public void setVentRto(String ventRto) {
        this.ventRto = ventRto;
    }

    /**
	 * Column Info
	 * @param cntrTp
	 */
    public void setCntrTp(String cntrTp) {
        this.cntrTp = cntrTp;
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
	 * @param ventRtoUnit
	 */
    public void setVentRtoUnit(String ventRtoUnit) {
        this.ventRtoUnit = ventRtoUnit;
    }

    /**
	 * Column Info
	 * @param cdoTemp
	 */
    public void setCdoTemp(String cdoTemp) {
        this.cdoTemp = cdoTemp;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param dischPort1
	 */
    public void setDischPort1(String dischPort1) {
        this.dischPort1 = dischPort1;
    }

    /**
	 * Column Info
	 * @param cntrSealNo
	 */
    public void setCntrSealNo(String cntrSealNo) {
        this.cntrSealNo = cntrSealNo;
    }

    /**
	 * Column Info
	 * @param dischPort2
	 */
    public void setDischPort2(String dischPort2) {
        this.dischPort2 = dischPort2;
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
	 * @param lineCd
	 */
    public void setLineCd(String lineCd) {
        this.lineCd = lineCd;
    }

    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    public String getCmdtNm() {
        return this.cmdtNm;
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
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
        setGroupTitle(JSPUtil.getParameter(request, prefix + "group_title", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setHeight(JSPUtil.getParameter(request, prefix + "height", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
        setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
        setOrgPpdRcvCd(JSPUtil.getParameter(request, prefix + "org_ppd_rcv_cd", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setTempUnit(JSPUtil.getParameter(request, prefix + "temp_unit", ""));
        setVentRto(JSPUtil.getParameter(request, prefix + "vent_rto", ""));
        setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setVentRtoUnit(JSPUtil.getParameter(request, prefix + "vent_rto_unit", ""));
        setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setDischPort1(JSPUtil.getParameter(request, prefix + "disch_port1", ""));
        setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
        setDischPort2(JSPUtil.getParameter(request, prefix + "disch_port2", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setLineCd(JSPUtil.getParameter(request, prefix + "line_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreAdviceManifestListVO[]
	 */
    public PreAdviceManifestListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreAdviceManifestListVO[]
	 */
    public PreAdviceManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PreAdviceManifestListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] cntrSz = (JSPUtil.getParameter(request, prefix + "cntr_sz", length));
            String[] groupTitle = (JSPUtil.getParameter(request, prefix + "group_title", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] height = (JSPUtil.getParameter(request, prefix + "height", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] blckStwgCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_cd", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
            String[] orgPpdRcvCd = (JSPUtil.getParameter(request, prefix + "org_ppd_rcv_cd", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] tempUnit = (JSPUtil.getParameter(request, prefix + "temp_unit", length));
            String[] ventRto = (JSPUtil.getParameter(request, prefix + "vent_rto", length));
            String[] cntrTp = (JSPUtil.getParameter(request, prefix + "cntr_tp", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ventRtoUnit = (JSPUtil.getParameter(request, prefix + "vent_rto_unit", length));
            String[] cdoTemp = (JSPUtil.getParameter(request, prefix + "cdo_temp", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] dischPort1 = (JSPUtil.getParameter(request, prefix + "disch_port1", length));
            String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
            String[] dischPort2 = (JSPUtil.getParameter(request, prefix + "disch_port2", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] lineCd = (JSPUtil.getParameter(request, prefix + "line_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PreAdviceManifestListVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (cntrSz[i] != null)
                    model.setCntrSz(cntrSz[i]);
                if (groupTitle[i] != null)
                    model.setGroupTitle(groupTitle[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (height[i] != null)
                    model.setHeight(height[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (blckStwgCd[i] != null)
                    model.setBlckStwgCd(blckStwgCd[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (cntrWgt[i] != null)
                    model.setCntrWgt(cntrWgt[i]);
                if (orgPpdRcvCd[i] != null)
                    model.setOrgPpdRcvCd(orgPpdRcvCd[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (tempUnit[i] != null)
                    model.setTempUnit(tempUnit[i]);
                if (ventRto[i] != null)
                    model.setVentRto(ventRto[i]);
                if (cntrTp[i] != null)
                    model.setCntrTp(cntrTp[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ventRtoUnit[i] != null)
                    model.setVentRtoUnit(ventRtoUnit[i]);
                if (cdoTemp[i] != null)
                    model.setCdoTemp(cdoTemp[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (dischPort1[i] != null)
                    model.setDischPort1(dischPort1[i]);
                if (cntrSealNo[i] != null)
                    model.setCntrSealNo(cntrSealNo[i]);
                if (dischPort2[i] != null)
                    model.setDischPort2(dischPort2[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (lineCd[i] != null)
                    model.setLineCd(lineCd[i]);
                if (cmdtNm[i] != null) 
		    		model.setCmdtNm(cmdtNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPreAdviceManifestListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PreAdviceManifestListVO[]
	 */
    public PreAdviceManifestListVO[] getPreAdviceManifestListVOs() {
        PreAdviceManifestListVO[] vos = (PreAdviceManifestListVO[]) models.toArray(new PreAdviceManifestListVO[models.size()]);
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
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSz = this.cntrSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.groupTitle = this.groupTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.height = this.height.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgPpdRcvCd = this.orgPpdRcvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tempUnit = this.tempUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ventRto = this.ventRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTp = this.cntrTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ventRtoUnit = this.ventRtoUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdoTemp = this.cdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dischPort1 = this.dischPort1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dischPort2 = this.dischPort2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lineCd = this.lineCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
