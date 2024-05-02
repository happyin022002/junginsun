/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MtyRlseOrdExcelCntrVO.java
*@FileTitle : MtyRlseOrdExcelCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
public class MtyRlseOrdExcelCntrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MtyRlseOrdExcelCntrVO> models = new ArrayList<MtyRlseOrdExcelCntrVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String sealNo = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String cntrWgt = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String cmdtDesc = null;

    /* Column Info */
    private String netWgt = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String wgtUtCd1 = null;

    /* Column Info */
    private String tempUf = null;

    /* Column Info */
    private String fdoTemp = null;

    /* Column Info */
    private String tempUc = null;

    /* Column Info */
    private String cdoTemp = null;

    /* Column Info */
    private String vltgNo = null;

    /* Column Info */
    private String cntrVentTpCd = null;

    /* Column Info */
    private String ventRto = null;

    /* Column Info */
    private String ventCmh = null;

    /* Column Info */
    private String humidNo = null;

    /* Column Info */
    private String pwrSplCblFlg = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String rfDry = null;

    /* Column Info */
    private String rfDrain = null;

    /* Column Info */
    private String ovrFwrdLen = null;

    /* Column Info */
    private String ovrBkwdLen = null;

    /* Column Info */
    private String ovrHgt = null;

    /* Column Info */
    private String ovrLfLen = null;

    /* Column Info */
    private String ovrRtLen = null;

    /* Column Info */
    private String moveSts = null;

    /* Column Info */
    private String eventYard = null;

    /* Column Info */
    private String eventTime = null;

    /* Column Info */
    private String vgmWgt = null;

    /* Column Info */
    private String vgmWgtUtCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MtyRlseOrdExcelCntrVO() {
    }

    public MtyRlseOrdExcelCntrVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrTpszCd, String sealNo, String rcFlg, String dcgoFlg, String awkCgoFlg, String bbCgoFlg, String socFlg, String cntrWgt, String wgtUtCd, String cmdtCd, String cmdtDesc, String netWgt, String grsWgt, String wgtUtCd1, String tempUf, String fdoTemp, String tempUc, String cdoTemp, String vltgNo, String cntrVentTpCd, String ventRto, String ventCmh, String humidNo, String pwrSplCblFlg, String diffRmk, String rfDry, String rfDrain, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String ovrLfLen, String ovrRtLen, String moveSts, String eventYard, String eventTime, String vgmWgt, String vgmWgtUtCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.cntrNo = cntrNo;
        this.cntrTpszCd = cntrTpszCd;
        this.sealNo = sealNo;
        this.rcFlg = rcFlg;
        this.dcgoFlg = dcgoFlg;
        this.awkCgoFlg = awkCgoFlg;
        this.bbCgoFlg = bbCgoFlg;
        this.socFlg = socFlg;
        this.cntrWgt = cntrWgt;
        this.wgtUtCd = wgtUtCd;
        this.cmdtCd = cmdtCd;
        this.cmdtDesc = cmdtDesc;
        this.netWgt = netWgt;
        this.grsWgt = grsWgt;
        this.wgtUtCd1 = wgtUtCd1;
        this.tempUf = tempUf;
        this.fdoTemp = fdoTemp;
        this.tempUc = tempUc;
        this.cdoTemp = cdoTemp;
        this.vltgNo = vltgNo;
        this.cntrVentTpCd = cntrVentTpCd;
        this.ventRto = ventRto;
        this.ventCmh = ventCmh;
        this.humidNo = humidNo;
        this.pwrSplCblFlg = pwrSplCblFlg;
        this.diffRmk = diffRmk;
        this.rfDry = rfDry;
        this.rfDrain = rfDrain;
        this.ovrFwrdLen = ovrFwrdLen;
        this.ovrBkwdLen = ovrBkwdLen;
        this.ovrHgt = ovrHgt;
        this.ovrLfLen = ovrLfLen;
        this.ovrRtLen = ovrRtLen;
        this.moveSts = moveSts;
        this.eventYard = eventYard;
        this.eventTime = eventTime;
        this.vgmWgt = vgmWgt;
        this.vgmWgtUtCd = vgmWgtUtCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("seal_no", getSealNo());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("wgt_ut_cd1", getWgtUtCd1());
        this.hashColumns.put("temp_uf", getTempUf());
        this.hashColumns.put("fdo_temp", getFdoTemp());
        this.hashColumns.put("temp_uc", getTempUc());
        this.hashColumns.put("cdo_temp", getCdoTemp());
        this.hashColumns.put("vltg_no", getVltgNo());
        this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
        this.hashColumns.put("vent_rto", getVentRto());
        this.hashColumns.put("vent_cmh", getVentCmh());
        this.hashColumns.put("humid_no", getHumidNo());
        this.hashColumns.put("pwr_spl_cbl_flg", getPwrSplCblFlg());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("rf_dry", getRfDry());
        this.hashColumns.put("rf_drain", getRfDrain());
        this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
        this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
        this.hashColumns.put("ovr_hgt", getOvrHgt());
        this.hashColumns.put("ovr_lf_len", getOvrLfLen());
        this.hashColumns.put("ovr_rt_len", getOvrRtLen());
        this.hashColumns.put("move_sts", getMoveSts());
        this.hashColumns.put("event_yard", getEventYard());
        this.hashColumns.put("event_time", getEventTime());
        this.hashColumns.put("vgm_wgt", getVgmWgt());
        this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("seal_no", "sealNo");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("wgt_ut_cd1", "wgtUtCd1");
        this.hashFields.put("temp_uf", "tempUf");
        this.hashFields.put("fdo_temp", "fdoTemp");
        this.hashFields.put("temp_uc", "tempUc");
        this.hashFields.put("cdo_temp", "cdoTemp");
        this.hashFields.put("vltg_no", "vltgNo");
        this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
        this.hashFields.put("vent_rto", "ventRto");
        this.hashFields.put("vent_cmh", "ventCmh");
        this.hashFields.put("humid_no", "humidNo");
        this.hashFields.put("pwr_spl_cbl_flg", "pwrSplCblFlg");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("rf_dry", "rfDry");
        this.hashFields.put("rf_drain", "rfDrain");
        this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
        this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
        this.hashFields.put("ovr_hgt", "ovrHgt");
        this.hashFields.put("ovr_lf_len", "ovrLfLen");
        this.hashFields.put("ovr_rt_len", "ovrRtLen");
        this.hashFields.put("move_sts", "moveSts");
        this.hashFields.put("event_yard", "eventYard");
        this.hashFields.put("event_time", "eventTime");
        this.hashFields.put("vgm_wgt", "vgmWgt");
        this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
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
	 * @param String bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * 
	 * @return String bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 *
	 * @param String cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * 
	 * @return String cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 *
	 * @param String cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * 
	 * @return String cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 *
	 * @param String sealNo
	 */
    public void setSealNo(String sealNo) {
        this.sealNo = sealNo;
    }

    /**
	 * 
	 * @return String sealNo
	 */
    public String getSealNo() {
        return this.sealNo;
    }

    /**
	 *
	 * @param String rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * 
	 * @return String rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 *
	 * @param String dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
    }

    /**
	 * 
	 * @return String dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
    }

    /**
	 *
	 * @param String awkCgoFlg
	 */
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
    }

    /**
	 * 
	 * @return String awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
    }

    /**
	 *
	 * @param String bbCgoFlg
	 */
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
    }

    /**
	 * 
	 * @return String bbCgoFlg
	 */
    public String getBbCgoFlg() {
        return this.bbCgoFlg;
    }

    /**
	 *
	 * @param String socFlg
	 */
    public void setSocFlg(String socFlg) {
        this.socFlg = socFlg;
    }

    /**
	 * 
	 * @return String socFlg
	 */
    public String getSocFlg() {
        return this.socFlg;
    }

    /**
	 *
	 * @param String cntrWgt
	 */
    public void setCntrWgt(String cntrWgt) {
        this.cntrWgt = cntrWgt;
    }

    /**
	 * 
	 * @return String cntrWgt
	 */
    public String getCntrWgt() {
        return this.cntrWgt;
    }

    /**
	 *
	 * @param String wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * 
	 * @return String wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 *
	 * @param String cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * 
	 * @return String cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 *
	 * @param String cmdtDesc
	 */
    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    /**
	 * 
	 * @return String cmdtDesc
	 */
    public String getCmdtDesc() {
        return this.cmdtDesc;
    }

    /**
	 *
	 * @param String netWgt
	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * 
	 * @return String netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 *
	 * @param String grsWgt
	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * 
	 * @return String grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
    }

    /**
	 *
	 * @param String wgtUtCd1
	 */
    public void setWgtUtCd1(String wgtUtCd1) {
        this.wgtUtCd1 = wgtUtCd1;
    }

    /**
	 * 
	 * @return String wgtUtCd1
	 */
    public String getWgtUtCd1() {
        return this.wgtUtCd1;
    }

    /**
	 *
	 * @param String tempUf
	 */
    public void setTempUf(String tempUf) {
        this.tempUf = tempUf;
    }

    /**
	 * 
	 * @return String tempUf
	 */
    public String getTempUf() {
        return this.tempUf;
    }

    /**
	 *
	 * @param String fdoTemp
	 */
    public void setFdoTemp(String fdoTemp) {
        this.fdoTemp = fdoTemp;
    }

    /**
	 * 
	 * @return String fdoTemp
	 */
    public String getFdoTemp() {
        return this.fdoTemp;
    }

    /**
	 *
	 * @param String tempUc
	 */
    public void setTempUc(String tempUc) {
        this.tempUc = tempUc;
    }

    /**
	 * 
	 * @return String tempUc
	 */
    public String getTempUc() {
        return this.tempUc;
    }

    /**
	 *
	 * @param String cdoTemp
	 */
    public void setCdoTemp(String cdoTemp) {
        this.cdoTemp = cdoTemp;
    }

    /**
	 * 
	 * @return String cdoTemp
	 */
    public String getCdoTemp() {
        return this.cdoTemp;
    }

    /**
	 *
	 * @param String vltgNo
	 */
    public void setVltgNo(String vltgNo) {
        this.vltgNo = vltgNo;
    }

    /**
	 * 
	 * @return String vltgNo
	 */
    public String getVltgNo() {
        return this.vltgNo;
    }

    /**
	 *
	 * @param String cntrVentTpCd
	 */
    public void setCntrVentTpCd(String cntrVentTpCd) {
        this.cntrVentTpCd = cntrVentTpCd;
    }

    /**
	 * 
	 * @return String cntrVentTpCd
	 */
    public String getCntrVentTpCd() {
        return this.cntrVentTpCd;
    }

    /**
	 *
	 * @param String ventRto
	 */
    public void setVentRto(String ventRto) {
        this.ventRto = ventRto;
    }

    /**
	 * 
	 * @return String ventRto
	 */
    public String getVentRto() {
        return this.ventRto;
    }

    /**
	 *
	 * @param String ventCmh
	 */
    public void setVentCmh(String ventCmh) {
        this.ventCmh = ventCmh;
    }

    /**
	 * 
	 * @return String ventCmh
	 */
    public String getVentCmh() {
        return this.ventCmh;
    }

    /**
	 *
	 * @param String humidNo
	 */
    public void setHumidNo(String humidNo) {
        this.humidNo = humidNo;
    }

    /**
	 * 
	 * @return String humidNo
	 */
    public String getHumidNo() {
        return this.humidNo;
    }

    /**
	 *
	 * @param String pwrSplCblFlg
	 */
    public void setPwrSplCblFlg(String pwrSplCblFlg) {
        this.pwrSplCblFlg = pwrSplCblFlg;
    }

    /**
	 * 
	 * @return String pwrSplCblFlg
	 */
    public String getPwrSplCblFlg() {
        return this.pwrSplCblFlg;
    }

    /**
	 *
	 * @param String diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * 
	 * @return String diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 *
	 * @param String rfDry
	 */
    public void setRfDry(String rfDry) {
        this.rfDry = rfDry;
    }

    /**
	 * 
	 * @return String rfDry
	 */
    public String getRfDry() {
        return this.rfDry;
    }

    /**
	 *
	 * @param String rfDrain
	 */
    public void setRfDrain(String rfDrain) {
        this.rfDrain = rfDrain;
    }

    /**
	 * 
	 * @return String rfDrain
	 */
    public String getRfDrain() {
        return this.rfDrain;
    }

    /**
	 *
	 * @param String ovrFwrdLen
	 */
    public void setOvrFwrdLen(String ovrFwrdLen) {
        this.ovrFwrdLen = ovrFwrdLen;
    }

    /**
	 * 
	 * @return String ovrFwrdLen
	 */
    public String getOvrFwrdLen() {
        return this.ovrFwrdLen;
    }

    /**
	 *
	 * @param String ovrBkwdLen
	 */
    public void setOvrBkwdLen(String ovrBkwdLen) {
        this.ovrBkwdLen = ovrBkwdLen;
    }

    /**
	 * 
	 * @return String ovrBkwdLen
	 */
    public String getOvrBkwdLen() {
        return this.ovrBkwdLen;
    }

    /**
	 *
	 * @param String ovrHgt
	 */
    public void setOvrHgt(String ovrHgt) {
        this.ovrHgt = ovrHgt;
    }

    /**
	 * 
	 * @return String ovrHgt
	 */
    public String getOvrHgt() {
        return this.ovrHgt;
    }

    /**
	 *
	 * @param String ovrLfLen
	 */
    public void setOvrLfLen(String ovrLfLen) {
        this.ovrLfLen = ovrLfLen;
    }

    /**
	 * 
	 * @return String ovrLfLen
	 */
    public String getOvrLfLen() {
        return this.ovrLfLen;
    }

    /**
	 *
	 * @param String ovrRtLen
	 */
    public void setOvrRtLen(String ovrRtLen) {
        this.ovrRtLen = ovrRtLen;
    }

    /**
	 * 
	 * @return String ovrRtLen
	 */
    public String getOvrRtLen() {
        return this.ovrRtLen;
    }

    public void setMoveSts(String moveSts) {
        this.moveSts = moveSts;
    }

    public String getMoveSts() {
        return this.moveSts;
    }

    public void setEventYard(String eventYard) {
        this.eventYard = eventYard;
    }

    public String getEventYard() {
        return this.eventYard;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public void setVgmWgt(String vgmWgt) {
        this.vgmWgt = vgmWgt;
    }

    public String getVgmWgt() {
        return this.vgmWgt;
    }

    public void setVgmWgtUtCd(String vgmWgtUtCd) {
        this.vgmWgtUtCd = vgmWgtUtCd;
    }

    public String getVgmWgtUtCd() {
        return this.vgmWgtUtCd;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setWgtUtCd1(JSPUtil.getParameter(request, prefix + "wgt_ut_cd1", ""));
        setTempUf(JSPUtil.getParameter(request, prefix + "temp_uf", ""));
        setFdoTemp(JSPUtil.getParameter(request, prefix + "fdo_temp", ""));
        setTempUc(JSPUtil.getParameter(request, prefix + "temp_uc", ""));
        setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
        setVltgNo(JSPUtil.getParameter(request, prefix + "vltg_no", ""));
        setCntrVentTpCd(JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", ""));
        setVentRto(JSPUtil.getParameter(request, prefix + "vent_rto", ""));
        setVentCmh(JSPUtil.getParameter(request, prefix + "vent_cmh", ""));
        setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));
        setPwrSplCblFlg(JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setRfDry(JSPUtil.getParameter(request, prefix + "rf_dry", ""));
        setRfDrain(JSPUtil.getParameter(request, prefix + "rf_drain", ""));
        setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
        setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
        setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
        setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
        setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
        setMoveSts(JSPUtil.getParameter(request, prefix + "move_sts", ""));
        setEventYard(JSPUtil.getParameter(request, prefix + "event_yard", ""));
        setEventTime(JSPUtil.getParameter(request, prefix + "event_time", ""));
        setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
        setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelCntrVO[]
	 */
    public MtyRlseOrdExcelCntrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelCntrVO[]
	 */
    public MtyRlseOrdExcelCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MtyRlseOrdExcelCntrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] sealNo = (JSPUtil.getParameter(request, prefix + "seal_no", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] wgtUtCd1 = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd1", length));
            String[] tempUf = (JSPUtil.getParameter(request, prefix + "temp_uf", length));
            String[] fdoTemp = (JSPUtil.getParameter(request, prefix + "fdo_temp", length));
            String[] tempUc = (JSPUtil.getParameter(request, prefix + "temp_uc", length));
            String[] cdoTemp = (JSPUtil.getParameter(request, prefix + "cdo_temp", length));
            String[] vltgNo = (JSPUtil.getParameter(request, prefix + "vltg_no", length));
            String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", length));
            String[] ventRto = (JSPUtil.getParameter(request, prefix + "vent_rto", length));
            String[] ventCmh = (JSPUtil.getParameter(request, prefix + "vent_cmh", length));
            String[] humidNo = (JSPUtil.getParameter(request, prefix + "humid_no", length));
            String[] pwrSplCblFlg = (JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] rfDry = (JSPUtil.getParameter(request, prefix + "rf_dry", length));
            String[] rfDrain = (JSPUtil.getParameter(request, prefix + "rf_drain", length));
            String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", length));
            String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", length));
            String[] ovrHgt = (JSPUtil.getParameter(request, prefix + "ovr_hgt", length));
            String[] ovrLfLen = (JSPUtil.getParameter(request, prefix + "ovr_lf_len", length));
            String[] ovrRtLen = (JSPUtil.getParameter(request, prefix + "ovr_rt_len", length));
            String[] moveSts = (JSPUtil.getParameter(request, prefix + "move_sts", length));
            String[] eventYard = (JSPUtil.getParameter(request, prefix + "event_yard", length));
            String[] eventTime = (JSPUtil.getParameter(request, prefix + "event_time", length));
            String[] vgmWgt = (JSPUtil.getParameter(request, prefix + "vgm_wgt", length));
	    	String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MtyRlseOrdExcelCntrVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (sealNo[i] != null)
                    model.setSealNo(sealNo[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (cntrWgt[i] != null)
                    model.setCntrWgt(cntrWgt[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (wgtUtCd1[i] != null)
                    model.setWgtUtCd1(wgtUtCd1[i]);
                if (tempUf[i] != null)
                    model.setTempUf(tempUf[i]);
                if (fdoTemp[i] != null)
                    model.setFdoTemp(fdoTemp[i]);
                if (tempUc[i] != null)
                    model.setTempUc(tempUc[i]);
                if (cdoTemp[i] != null)
                    model.setCdoTemp(cdoTemp[i]);
                if (vltgNo[i] != null)
                    model.setVltgNo(vltgNo[i]);
                if (cntrVentTpCd[i] != null)
                    model.setCntrVentTpCd(cntrVentTpCd[i]);
                if (ventRto[i] != null)
                    model.setVentRto(ventRto[i]);
                if (ventCmh[i] != null)
                    model.setVentCmh(ventCmh[i]);
                if (humidNo[i] != null)
                    model.setHumidNo(humidNo[i]);
                if (pwrSplCblFlg[i] != null)
                    model.setPwrSplCblFlg(pwrSplCblFlg[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (rfDry[i] != null)
                    model.setRfDry(rfDry[i]);
                if (rfDrain[i] != null)
                    model.setRfDrain(rfDrain[i]);
                if (ovrFwrdLen[i] != null)
                    model.setOvrFwrdLen(ovrFwrdLen[i]);
                if (ovrBkwdLen[i] != null)
                    model.setOvrBkwdLen(ovrBkwdLen[i]);
                if (ovrHgt[i] != null)
                    model.setOvrHgt(ovrHgt[i]);
                if (ovrLfLen[i] != null)
                    model.setOvrLfLen(ovrLfLen[i]);
                if (ovrRtLen[i] != null)
                    model.setOvrRtLen(ovrRtLen[i]);
                if (moveSts[i] != null)
                    model.setMoveSts(moveSts[i]);
                if (eventYard[i] != null)
                    model.setEventYard(eventYard[i]);
                if (eventTime[i] != null)
                    model.setEventTime(eventTime[i]);
                if (vgmWgt[i] != null) 
		    		model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null) 
		    		model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMtyRlseOrdExcelCntrVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelCntrVO[]
	 */
    public MtyRlseOrdExcelCntrVO[] getMtyRlseOrdExcelCntrVOs() {
        MtyRlseOrdExcelCntrVO[] vos = (MtyRlseOrdExcelCntrVO[]) models.toArray(new MtyRlseOrdExcelCntrVO[models.size()]);
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
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealNo = this.sealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd1 = this.wgtUtCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tempUf = this.tempUf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdoTemp = this.fdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tempUc = this.tempUc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdoTemp = this.cdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vltgNo = this.vltgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVentTpCd = this.cntrVentTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ventRto = this.ventRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ventCmh = this.ventCmh.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.humidNo = this.humidNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pwrSplCblFlg = this.pwrSplCblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfDry = this.rfDry.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfDrain = this.rfDrain.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrFwrdLen = this.ovrFwrdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrBkwdLen = this.ovrBkwdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrHgt = this.ovrHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrLfLen = this.ovrLfLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrRtLen = this.ovrRtLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.moveSts = this.moveSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eventYard = this.eventYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eventTime = this.eventTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgt = this.vgmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgtUtCd = this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
