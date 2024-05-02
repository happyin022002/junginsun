/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerVO.java
*@FileTitle : ContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.31  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ContainerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ContainerVO> models = new ArrayList<ContainerVO>();

    /* Column Info */
    private String mfCfmFlg = null;

    /* Column Info */
    private String oneWyFreeFlg = null;

    /* Column Info */
    private String cntrDpSeq = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String cgoRcvDt = null;

    /* Column Info */
    private String advShtgCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cntrNoOld = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cnmvStsCd = null;

    /* Column Info */
    private String cmFlg = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String eqSubstTpszCd = null;

    /* Column Info */
    private String cntrPrtFlg = null;

    /* Column Info */
    private String cntrWgt = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String cnmvEvntDt = null;

    /* Column Info */
    private String cntrCfmFlg = null;

    /* Column Info */
    private String orgYdCd = null;

    /* Column Info */
    private String cgoRcvDtFlg = null;

    /* Column Info */
    private String doNo = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String poNo = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String dcgoCnt = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String hngrFlg = null;

    /* Column Info */
    private String cntrSealNo = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String cntrVolQty = null;

    /* Column Info */
    private String vgmWgt = null;

    /* Column Info */
    private String vgmWgtUtCd = null;

    /* Column Info */
    private String vgmVrfyDt = null;

    /* Column Info */
    private String vgmDtmnDt = null;

    /* Column Info */
    private String vgmVrfySigCtnt = null;

    /* Column Info */
    private String vgmMzdTpCd = null;

    /* Column Info */
    private String lbpFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ContainerVO() {
    }

    public ContainerVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrNoOld, String cntrTpszCd, String cntrSealNo, String cntrDpSeq, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String measQty, String measUtCd, String rcvTermCd, String deTermCd, String cntrPrtFlg, String cntrVolQty, String eqSubstTpszCd, String advShtgCd, String cnmvStsCd, String hngrFlg, String dcgoFlg, String bbCgoFlg, String awkCgoFlg, String rcFlg, String rdCgoFlg, String socFlg, String orgYdCd, String cnmvEvntDt, String cgoRcvDtFlg, String cgoRcvDt, String poNo, String diffRmk, String cntrCfmFlg, String doNo, String cmFlg, String dcgoCnt, String creUsrId, String updUsrId, String polCd, String oneWyFreeFlg, String mfCfmFlg, String vgmWgt, String vgmWgtUtCd, String vgmVrfyDt, String vgmDtmnDt, String vgmVrfySigCtnt, String vgmMzdTpCd, String lbpFlg) {
        this.cntrDpSeq = cntrDpSeq;
        this.rdCgoFlg = rdCgoFlg;
        this.cgoRcvDt = cgoRcvDt;
        this.advShtgCd = advShtgCd;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.cntrNoOld = cntrNoOld;
        this.ibflag = ibflag;
        this.cnmvStsCd = cnmvStsCd;
        this.cmFlg = cmFlg;
        this.bbCgoFlg = bbCgoFlg;
        this.measQty = measQty;
        this.wgtUtCd = wgtUtCd;
        this.cntrTpszCd = cntrTpszCd;
        this.dcgoFlg = dcgoFlg;
        this.pckQty = pckQty;
        this.rcvTermCd = rcvTermCd;
        this.pckTpCd = pckTpCd;
        this.measUtCd = measUtCd;
        this.updUsrId = updUsrId;
        this.eqSubstTpszCd = eqSubstTpszCd;
        this.cntrPrtFlg = cntrPrtFlg;
        this.cntrWgt = cntrWgt;
        this.awkCgoFlg = awkCgoFlg;
        this.cnmvEvntDt = cnmvEvntDt;
        this.cntrCfmFlg = cntrCfmFlg;
        this.orgYdCd = orgYdCd;
        this.cgoRcvDtFlg = cgoRcvDtFlg;
        this.doNo = doNo;
        this.socFlg = socFlg;
        this.deTermCd = deTermCd;
        this.creUsrId = creUsrId;
        this.poNo = poNo;
        this.bkgNo = bkgNo;
        this.diffRmk = diffRmk;
        this.dcgoCnt = dcgoCnt;
        this.cntrNo = cntrNo;
        this.hngrFlg = hngrFlg;
        this.cntrSealNo = cntrSealNo;
        this.rcFlg = rcFlg;
        this.cntrVolQty = cntrVolQty;
        this.oneWyFreeFlg = oneWyFreeFlg;
        this.mfCfmFlg = mfCfmFlg;
        this.vgmWgt = vgmWgt;
        this.vgmWgtUtCd = vgmWgtUtCd;
        this.vgmVrfyDt = vgmVrfyDt;
        this.vgmDtmnDt = vgmDtmnDt;
        this.vgmVrfySigCtnt = vgmVrfySigCtnt;
        this.vgmMzdTpCd = vgmMzdTpCd;
        this.lbpFlg = lbpFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cntr_dp_seq", getCntrDpSeq());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
        this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cntr_no_old", getCntrNoOld());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
        this.hashColumns.put("cm_flg", getCmFlg());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("eq_subst_tpsz_cd", getEqSubstTpszCd());
        this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
        this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());
        this.hashColumns.put("org_yd_cd", getOrgYdCd());
        this.hashColumns.put("cgo_rcv_dt_flg", getCgoRcvDtFlg());
        this.hashColumns.put("do_no", getDoNo());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("po_no", getPoNo());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("dcgo_cnt", getDcgoCnt());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("cntr_seal_no", getCntrSealNo());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
        this.hashColumns.put("one_wy_free_flg", getOneWyFreeFlg());
        this.hashColumns.put("mf_cfm_flg", getMfCfmFlg());
        this.hashColumns.put("vgm_wgt", getVgmWgt());
        this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
        this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
        this.hashColumns.put("vgm_dtmn_dt", getVgmDtmnDt());
        this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
        this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
        this.hashColumns.put("lbp_flg", getLbpFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cntr_dp_seq", "cntrDpSeq");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
        this.hashFields.put("adv_shtg_cd", "advShtgCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cntr_no_old", "cntrNoOld");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
        this.hashFields.put("cm_flg", "cmFlg");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("eq_subst_tpsz_cd", "eqSubstTpszCd");
        this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
        this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
        this.hashFields.put("org_yd_cd", "orgYdCd");
        this.hashFields.put("cgo_rcv_dt_flg", "cgoRcvDtFlg");
        this.hashFields.put("do_no", "doNo");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("dcgo_cnt", "dcgoCnt");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("cntr_seal_no", "cntrSealNo");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("cntr_vol_qty", "cntrVolQty");
        this.hashFields.put("one_wy_free_flg", "oneWyFreeFlg");
        this.hashFields.put("mf_cfm_flg", "mfCfmFlg");
        this.hashFields.put("vgm_wgt", "vgmWgt");
        this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
        this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
        this.hashFields.put("vgm_dtmn_dt", "vgmDtmnDt");
        this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
        this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
        this.hashFields.put("lbp_flg", "lbpFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vgmVrfyDt
	 */
    public String getVgmVrfyDt() {
        return this.vgmVrfyDt;
    }

    /**
	 * Column Info
	 * @return vgmDtmnDt
	 */
    public String getVgmDtmnDt() {
        return this.vgmDtmnDt;
    }

    /**
	 * Column Info
	 * @return vgmVrfySigCtnt
	 */
    public String getVgmVrfySigCtnt() {
        return this.vgmVrfySigCtnt;
    }

    /**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
    public String getVgmMzdTpCd() {
        return this.vgmMzdTpCd;
    }

    /**
	 * Column Info
	 * @return vgmWgt
	 */
    public String getVgmWgt() {
        return this.vgmWgt;
    }

    /**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
    public String getVgmWgtUtCd() {
        return this.vgmWgtUtCd;
    }

    /**
	 * Column Info
	 * @return mfCfmFlg
	 */
    public String getMfCfmFlg() {
        return this.mfCfmFlg;
    }

    /**
	 * Column Info
	 * @return oneWyFreeFlg
	 */
    public String getOneWyFreeFlg() {
        return this.oneWyFreeFlg;
    }

    /**
	 * Column Info
	 * @return cntrDpSeq
	 */
    public String getCntrDpSeq() {
        return this.cntrDpSeq;
    }

    /**
	 * Column Info
	 * @return rdCgoFlg
	 */
    public String getRdCgoFlg() {
        return this.rdCgoFlg;
    }

    /**
	 * Column Info
	 * @return cgoRcvDt
	 */
    public String getCgoRcvDt() {
        return this.cgoRcvDt;
    }

    /**
	 * Column Info
	 * @return advShtgCd
	 */
    public String getAdvShtgCd() {
        return this.advShtgCd;
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
	 * Column Info
	 * @return cntrNoOld
	 */
    public String getCntrNoOld() {
        return this.cntrNoOld;
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
	 * @return cnmvStsCd
	 */
    public String getCnmvStsCd() {
        return this.cnmvStsCd;
    }

    /**
	 * Column Info
	 * @return cmFlg
	 */
    public String getCmFlg() {
        return this.cmFlg;
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
	 * @return measQty
	 */
    public String getMeasQty() {
        return this.measQty;
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
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
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
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
    }

    /**
	 * Column Info
	 * @return measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
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
	 * @return eqSubstTpszCd
	 */
    public String getEqSubstTpszCd() {
        return this.eqSubstTpszCd;
    }

    /**
	 * Column Info
	 * @return cntrPrtFlg
	 */
    public String getCntrPrtFlg() {
        return this.cntrPrtFlg;
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
	 * @return awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
    }

    /**
	 * Column Info
	 * @return cnmvEvntDt
	 */
    public String getCnmvEvntDt() {
        return this.cnmvEvntDt;
    }

    /**
	 * Column Info
	 * @return cntrCfmFlg
	 */
    public String getCntrCfmFlg() {
        return this.cntrCfmFlg;
    }

    /**
	 * Column Info
	 * @return orgYdCd
	 */
    public String getOrgYdCd() {
        return this.orgYdCd;
    }

    /**
	 * Column Info
	 * @return cgoRcvDtFlg
	 */
    public String getCgoRcvDtFlg() {
        return this.cgoRcvDtFlg;
    }

    /**
	 * Column Info
	 * @return doNo
	 */
    public String getDoNo() {
        return this.doNo;
    }

    /**
	 * Column Info
	 * @return socFlg
	 */
    public String getSocFlg() {
        return this.socFlg;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return poNo
	 */
    public String getPoNo() {
        return this.poNo;
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
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return dcgoCnt
	 */
    public String getDcgoCnt() {
        return this.dcgoCnt;
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
	 * @return hngrFlg
	 */
    public String getHngrFlg() {
        return this.hngrFlg;
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
	 * @return rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 * Column Info
	 * @return cntrVolQty
	 */
    public String getCntrVolQty() {
        return this.cntrVolQty;
    }

    /**
	 * Column Info
	 * @param vgmVrfyDt
	 */
    public void setVgmVrfyDt(String vgmVrfyDt) {
        this.vgmVrfyDt = vgmVrfyDt;
    }

    /**
	 * Column Info
	 * @param vgmDtmnDt
	 */
    public void setVgmDtmnDt(String vgmDtmnDt) {
        this.vgmDtmnDt = vgmDtmnDt;
    }

    /**
	 * Column Info
	 * @param vgmVrfySigCtnt
	 */
    public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
        this.vgmVrfySigCtnt = vgmVrfySigCtnt;
    }

    /**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
    public void setVgmMzdTpCd(String vgmMzdTpCd) {
        this.vgmMzdTpCd = vgmMzdTpCd;
    }

    /**
	 * Column Info
	 * @param vgmWgt
	 */
    public void setVgmWgt(String vgmWgt) {
        this.vgmWgt = vgmWgt;
    }

    /**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
    public void setVgmWgtUtCd(String vgmWgtUtCd) {
        this.vgmWgtUtCd = vgmWgtUtCd;
    }

    /**
	 * Column Info
	 * @param mfCfmFlg
	 */
    public void setMfCfmFlg(String mfCfmFlg) {
        this.oneWyFreeFlg = mfCfmFlg;
    }

    /**
	 * Column Info
	 * @param oneWyFreeFlg
	 */
    public void setOneWyFreeFlg(String oneWyFreeFlg) {
        this.oneWyFreeFlg = oneWyFreeFlg;
    }

    /**
	 * Column Info
	 * @param cntrDpSeq
	 */
    public void setCntrDpSeq(String cntrDpSeq) {
        this.cntrDpSeq = cntrDpSeq;
    }

    /**
	 * Column Info
	 * @param rdCgoFlg
	 */
    public void setRdCgoFlg(String rdCgoFlg) {
        this.rdCgoFlg = rdCgoFlg;
    }

    /**
	 * Column Info
	 * @param cgoRcvDt
	 */
    public void setCgoRcvDt(String cgoRcvDt) {
        this.cgoRcvDt = cgoRcvDt;
    }

    /**
	 * Column Info
	 * @param advShtgCd
	 */
    public void setAdvShtgCd(String advShtgCd) {
        this.advShtgCd = advShtgCd;
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
	 * Column Info
	 * @param cntrNoOld
	 */
    public void setCntrNoOld(String cntrNoOld) {
        this.cntrNoOld = cntrNoOld;
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
	 * @param cnmvStsCd
	 */
    public void setCnmvStsCd(String cnmvStsCd) {
        this.cnmvStsCd = cnmvStsCd;
    }

    /**
	 * Column Info
	 * @param cmFlg
	 */
    public void setCmFlg(String cmFlg) {
        this.cmFlg = cmFlg;
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
	 * @param measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
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
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
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
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * Column Info
	 * @param measUtCd
	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
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
	 * @param eqSubstTpszCd
	 */
    public void setEqSubstTpszCd(String eqSubstTpszCd) {
        this.eqSubstTpszCd = eqSubstTpszCd;
    }

    /**
	 * Column Info
	 * @param cntrPrtFlg
	 */
    public void setCntrPrtFlg(String cntrPrtFlg) {
        this.cntrPrtFlg = cntrPrtFlg;
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
	 * @param awkCgoFlg
	 */
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
    }

    /**
	 * Column Info
	 * @param cnmvEvntDt
	 */
    public void setCnmvEvntDt(String cnmvEvntDt) {
        this.cnmvEvntDt = cnmvEvntDt;
    }

    /**
	 * Column Info
	 * @param cntrCfmFlg
	 */
    public void setCntrCfmFlg(String cntrCfmFlg) {
        this.cntrCfmFlg = cntrCfmFlg;
    }

    /**
	 * Column Info
	 * @param orgYdCd
	 */
    public void setOrgYdCd(String orgYdCd) {
        this.orgYdCd = orgYdCd;
    }

    /**
	 * Column Info
	 * @param cgoRcvDtFlg
	 */
    public void setCgoRcvDtFlg(String cgoRcvDtFlg) {
        this.cgoRcvDtFlg = cgoRcvDtFlg;
    }

    /**
	 * Column Info
	 * @param doNo
	 */
    public void setDoNo(String doNo) {
        this.doNo = doNo;
    }

    /**
	 * Column Info
	 * @param socFlg
	 */
    public void setSocFlg(String socFlg) {
        this.socFlg = socFlg;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param poNo
	 */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
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
	 * @param diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param dcgoCnt
	 */
    public void setDcgoCnt(String dcgoCnt) {
        this.dcgoCnt = dcgoCnt;
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
	 * @param hngrFlg
	 */
    public void setHngrFlg(String hngrFlg) {
        this.hngrFlg = hngrFlg;
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
	 * @param rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param cntrVolQty
	 */
    public void setCntrVolQty(String cntrVolQty) {
        this.cntrVolQty = cntrVolQty;
    }

    public void setLbpFlg(String lbpFlg) {
        this.lbpFlg = lbpFlg;
    }

    public String getLbpFlg() {
        return this.lbpFlg;
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
        setCntrDpSeq(JSPUtil.getParameter(request, prefix + "cntr_dp_seq", ""));
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setCgoRcvDt(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", ""));
        setAdvShtgCd(JSPUtil.getParameter(request, prefix + "adv_shtg_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCntrNoOld(JSPUtil.getParameter(request, prefix + "cntr_no_old", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
        setCmFlg(JSPUtil.getParameter(request, prefix + "cm_flg", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setEqSubstTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_tpsz_cd", ""));
        setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
        setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
        setCntrCfmFlg(JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", ""));
        setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
        setCgoRcvDtFlg(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt_flg", ""));
        setDoNo(JSPUtil.getParameter(request, prefix + "do_no", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setDcgoCnt(JSPUtil.getParameter(request, prefix + "dcgo_cnt", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
        setOneWyFreeFlg(JSPUtil.getParameter(request, prefix + "one_wy_free_flg", ""));
        setMfCfmFlg(JSPUtil.getParameter(request, prefix + "mf_cfm_flg", ""));
        setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
        setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
        setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
        setVgmDtmnDt(JSPUtil.getParameter(request, prefix + "vgm_dtmn_dt", ""));
        setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
        setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
        setLbpFlg(JSPUtil.getParameter(request, prefix + "lbp_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerVO[]
	 */
    public ContainerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerVO[]
	 */
    public ContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ContainerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cntrDpSeq = (JSPUtil.getParameter(request, prefix + "cntr_dp_seq", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", length));
            String[] advShtgCd = (JSPUtil.getParameter(request, prefix + "adv_shtg_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cntrNoOld = (JSPUtil.getParameter(request, prefix + "cntr_no_old", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", length));
            String[] cmFlg = (JSPUtil.getParameter(request, prefix + "cm_flg", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] eqSubstTpszCd = (JSPUtil.getParameter(request, prefix + "eq_subst_tpsz_cd", length));
            String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix + "cntr_prt_flg", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", length));
            String[] cntrCfmFlg = (JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", length));
            String[] orgYdCd = (JSPUtil.getParameter(request, prefix + "org_yd_cd", length));
            String[] cgoRcvDtFlg = (JSPUtil.getParameter(request, prefix + "cgo_rcv_dt_flg", length));
            String[] doNo = (JSPUtil.getParameter(request, prefix + "do_no", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] dcgoCnt = (JSPUtil.getParameter(request, prefix + "dcgo_cnt", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] cntrVolQty = (JSPUtil.getParameter(request, prefix + "cntr_vol_qty", length));
            String[] oneWyFreeFlg = (JSPUtil.getParameter(request, prefix + "one_wy_free_flg", length));
            String[] mfCfmFlg = (JSPUtil.getParameter(request, prefix + "mf_cfm_flg", length));
            String[] vgmWgt = (JSPUtil.getParameter(request, prefix + "vgm_wgt", length));
            String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));
            String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", length));
            String[] vgmDtmnDt = (JSPUtil.getParameter(request, prefix + "vgm_dtmn_dt", length));
            String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", length));
            String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", length));
            String[] lbpFlg = (JSPUtil.getParameter(request, prefix + "lbp_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ContainerVO();
                if (cntrDpSeq[i] != null)
                    model.setCntrDpSeq(cntrDpSeq[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (cgoRcvDt[i] != null)
                    model.setCgoRcvDt(cgoRcvDt[i]);
                if (advShtgCd[i] != null)
                    model.setAdvShtgCd(advShtgCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cntrNoOld[i] != null)
                    model.setCntrNoOld(cntrNoOld[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cnmvStsCd[i] != null)
                    model.setCnmvStsCd(cnmvStsCd[i]);
                if (cmFlg[i] != null)
                    model.setCmFlg(cmFlg[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (eqSubstTpszCd[i] != null)
                    model.setEqSubstTpszCd(eqSubstTpszCd[i]);
                if (cntrPrtFlg[i] != null)
                    model.setCntrPrtFlg(cntrPrtFlg[i]);
                if (cntrWgt[i] != null)
                    model.setCntrWgt(cntrWgt[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (cnmvEvntDt[i] != null)
                    model.setCnmvEvntDt(cnmvEvntDt[i]);
                if (cntrCfmFlg[i] != null)
                    model.setCntrCfmFlg(cntrCfmFlg[i]);
                if (orgYdCd[i] != null)
                    model.setOrgYdCd(orgYdCd[i]);
                if (cgoRcvDtFlg[i] != null)
                    model.setCgoRcvDtFlg(cgoRcvDtFlg[i]);
                if (doNo[i] != null)
                    model.setDoNo(doNo[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (poNo[i] != null)
                    model.setPoNo(poNo[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (dcgoCnt[i] != null)
                    model.setDcgoCnt(dcgoCnt[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (hngrFlg[i] != null)
                    model.setHngrFlg(hngrFlg[i]);
                if (cntrSealNo[i] != null)
                    model.setCntrSealNo(cntrSealNo[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (cntrVolQty[i] != null)
                    model.setCntrVolQty(cntrVolQty[i]);
                if (oneWyFreeFlg[i] != null)
                    model.setOneWyFreeFlg(oneWyFreeFlg[i]);
                if (mfCfmFlg[i] != null)
                    model.setMfCfmFlg(mfCfmFlg[i]);
                if (vgmWgt[i] != null)
                    model.setVgmWgt(vgmWgt[i]);
                if (vgmWgtUtCd[i] != null)
                    model.setVgmWgtUtCd(vgmWgtUtCd[i]);
                if (vgmVrfyDt[i] != null)
                    model.setVgmVrfyDt(vgmVrfyDt[i]);
                if (vgmDtmnDt[i] != null)
                    model.setVgmDtmnDt(vgmDtmnDt[i]);
                if (vgmVrfySigCtnt[i] != null)
                    model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
                if (vgmMzdTpCd[i] != null)
                    model.setVgmMzdTpCd(vgmMzdTpCd[i]);
                if (lbpFlg[i] != null) 
		    		model.setLbpFlg(lbpFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getContainerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ContainerVO[]
	 */
    public ContainerVO[] getContainerVOs() {
        ContainerVO[] vos = (ContainerVO[]) models.toArray(new ContainerVO[models.size()]);
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
        this.cntrDpSeq = this.cntrDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoRcvDt = this.cgoRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.advShtgCd = this.advShtgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNoOld = this.cntrNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnmvStsCd = this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmFlg = this.cmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstTpszCd = this.eqSubstTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrPrtFlg = this.cntrPrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnmvEvntDt = this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCfmFlg = this.cntrCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgYdCd = this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoRcvDtFlg = this.cgoRcvDtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doNo = this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoCnt = this.dcgoCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVolQty = this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oneWyFreeFlg = this.oneWyFreeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfCfmFlg = this.mfCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgt = this.vgmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgtUtCd = this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmVrfyDt = this.vgmVrfyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmDtmnDt = this.vgmDtmnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmVrfySigCtnt = this.vgmVrfySigCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmMzdTpCd = this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lbpFlg = this.lbpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
