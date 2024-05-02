/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgAwkCgoVO.java
*@FileTitle : BkgAwkCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.22  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgAwkCgoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgAwkCgoVO> models = new ArrayList<BkgAwkCgoVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String pstLckPinFlg = null;

    /* Column Info */
    private String rqstUsrId = null;

    /* Column Info */
    private String ttlDimWdt = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String awkCgoSeq = null;

    /* Column Info */
    private String ovrVoidSltQty = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ovrHgt = null;

    /* Column Info */
    private String undDeckTopFlg = null;

    /* Column Info */
    private String spclCgoAproCd = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String awkDcgoSeq = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String stwgRqstDesc = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String gravCtrDesc = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String xtdOvrQty = null;

    /* Column Info */
    private String inGaFlg = null;

    /* Column Info */
    private String netWgt = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String ovrLfLen = null;

    /* Column Info */
    private String ttlDimHgt = null;

    /* Column Info */
    private String cntrCgoSeq = null;

    /* Column Info */
    private String eqTpsz = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String ovrRtLen = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String awkCgoRqstGrpEml2 = null;

    /* Column Info */
    private String aplyNo = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String awkCgoRqstGrpEml1 = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String ovrBkwdLen = null;

    /* Column Info */
    private String ttlDimLen = null;

    /* Column Info */
    private String crnPstStsCd = null;

    /* Column Info */
    private String cntrVolQty = null;

    /* Column Info */
    private String ovrFwrdLen = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String bkgCntrWgt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgAwkCgoVO() {
    }

    public BkgAwkCgoVO(String ibflag, String pagerows, String bkgNo, String awkCgoSeq, String rcvTermCd, String deTermCd, String cntrTpszCd, String cntrNo, String pckTpCd, String pckQty, String grsWgt, String netWgt, String wgtUtCd, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String ovrLfLen, String ovrRtLen, String ovrVoidSltQty, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String awkDcgoSeq, String cmdtCd, String cmdtNm, String inGaFlg, String crnPstStsCd, String xtdOvrQty, String pstLckPinFlg, String gravCtrDesc, String stwgRqstDesc, String diffRmk, String spclCgoAproCd, String cntrVolQty, String rqstDt, String rqstUsrId, String creUsrId, String creDt, String updUsrId, String updDt, String undDeckTopFlg, String porCd, String delCd, String eqTpsz, String cntrCgoSeq, String aplyNo, String awkCgoRqstGrpEml1, String awkCgoRqstGrpEml2, String bkgCntrWgt) {
        this.porCd = porCd;
        this.pstLckPinFlg = pstLckPinFlg;
        this.rqstUsrId = rqstUsrId;
        this.ttlDimWdt = ttlDimWdt;
        this.creDt = creDt;
        this.awkCgoSeq = awkCgoSeq;
        this.ovrVoidSltQty = ovrVoidSltQty;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.ovrHgt = ovrHgt;
        this.undDeckTopFlg = undDeckTopFlg;
        this.spclCgoAproCd = spclCgoAproCd;
        this.cmdtCd = cmdtCd;
        this.wgtUtCd = wgtUtCd;
        this.cntrTpszCd = cntrTpszCd;
        this.pckQty = pckQty;
        this.awkDcgoSeq = awkDcgoSeq;
        this.rcvTermCd = rcvTermCd;
        this.stwgRqstDesc = stwgRqstDesc;
        this.pckTpCd = pckTpCd;
        this.updUsrId = updUsrId;
        this.gravCtrDesc = gravCtrDesc;
        this.updDt = updDt;
        this.rqstDt = rqstDt;
        this.xtdOvrQty = xtdOvrQty;
        this.inGaFlg = inGaFlg;
        this.netWgt = netWgt;
        this.delCd = delCd;
        this.ovrLfLen = ovrLfLen;
        this.ttlDimHgt = ttlDimHgt;
        this.cntrCgoSeq = cntrCgoSeq;
        this.eqTpsz = eqTpsz;
        this.cmdtNm = cmdtNm;
        this.ovrRtLen = ovrRtLen;
        this.deTermCd = deTermCd;
        this.awkCgoRqstGrpEml2 = awkCgoRqstGrpEml2;
        this.aplyNo = aplyNo;
        this.creUsrId = creUsrId;
        this.bkgNo = bkgNo;
        this.awkCgoRqstGrpEml1 = awkCgoRqstGrpEml1;
        this.diffRmk = diffRmk;
        this.cntrNo = cntrNo;
        this.ovrBkwdLen = ovrBkwdLen;
        this.ttlDimLen = ttlDimLen;
        this.crnPstStsCd = crnPstStsCd;
        this.cntrVolQty = cntrVolQty;
        this.ovrFwrdLen = ovrFwrdLen;
        this.grsWgt = grsWgt;
        this.bkgCntrWgt = bkgCntrWgt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("pst_lck_pin_flg", getPstLckPinFlg());
        this.hashColumns.put("rqst_usr_id", getRqstUsrId());
        this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
        this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ovr_hgt", getOvrHgt());
        this.hashColumns.put("und_deck_top_flg", getUndDeckTopFlg());
        this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("awk_dcgo_seq", getAwkDcgoSeq());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("stwg_rqst_desc", getStwgRqstDesc());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("grav_ctr_desc", getGravCtrDesc());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("xtd_ovr_qty", getXtdOvrQty());
        this.hashColumns.put("in_ga_flg", getInGaFlg());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("ovr_lf_len", getOvrLfLen());
        this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
        this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
        this.hashColumns.put("eq_tpsz", getEqTpsz());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("ovr_rt_len", getOvrRtLen());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("awk_cgo_rqst_grp_eml2", getAwkCgoRqstGrpEml2());
        this.hashColumns.put("aply_no", getAplyNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("awk_cgo_rqst_grp_eml1", getAwkCgoRqstGrpEml1());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
        this.hashColumns.put("ttl_dim_len", getTtlDimLen());
        this.hashColumns.put("crn_pst_sts_cd", getCrnPstStsCd());
        this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
        this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("bkg_cntr_wgt", getBkgCntrWgt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("pst_lck_pin_flg", "pstLckPinFlg");
        this.hashFields.put("rqst_usr_id", "rqstUsrId");
        this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
        this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ovr_hgt", "ovrHgt");
        this.hashFields.put("und_deck_top_flg", "undDeckTopFlg");
        this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("awk_dcgo_seq", "awkDcgoSeq");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("stwg_rqst_desc", "stwgRqstDesc");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("grav_ctr_desc", "gravCtrDesc");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("xtd_ovr_qty", "xtdOvrQty");
        this.hashFields.put("in_ga_flg", "inGaFlg");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("ovr_lf_len", "ovrLfLen");
        this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
        this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
        this.hashFields.put("eq_tpsz", "eqTpsz");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("ovr_rt_len", "ovrRtLen");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("awk_cgo_rqst_grp_eml2", "awkCgoRqstGrpEml2");
        this.hashFields.put("aply_no", "aplyNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("awk_cgo_rqst_grp_eml1", "awkCgoRqstGrpEml1");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
        this.hashFields.put("ttl_dim_len", "ttlDimLen");
        this.hashFields.put("crn_pst_sts_cd", "crnPstStsCd");
        this.hashFields.put("cntr_vol_qty", "cntrVolQty");
        this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("bkg_cntr_wgt", "bkgCntrWgt");
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
	 * @return pstLckPinFlg
	 */
    public String getPstLckPinFlg() {
        return this.pstLckPinFlg;
    }

    /**
	 * Column Info
	 * @return rqstUsrId
	 */
    public String getRqstUsrId() {
        return this.rqstUsrId;
    }

    /**
	 * Column Info
	 * @return ttlDimWdt
	 */
    public String getTtlDimWdt() {
        return this.ttlDimWdt;
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
	 * @return awkCgoSeq
	 */
    public String getAwkCgoSeq() {
        return this.awkCgoSeq;
    }

    /**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
    public String getOvrVoidSltQty() {
        return this.ovrVoidSltQty;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return ovrHgt
	 */
    public String getOvrHgt() {
        return this.ovrHgt;
    }

    /**
	 * Column Info
	 * @return undDeckTopFlg
	 */
    public String getUndDeckTopFlg() {
        return this.undDeckTopFlg;
    }

    /**
	 * Column Info
	 * @return spclCgoAproCd
	 */
    public String getSpclCgoAproCd() {
        return this.spclCgoAproCd;
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
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
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
	 * @return awkDcgoSeq
	 */
    public String getAwkDcgoSeq() {
        return this.awkDcgoSeq;
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
	 * @return stwgRqstDesc
	 */
    public String getStwgRqstDesc() {
        return this.stwgRqstDesc;
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
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return gravCtrDesc
	 */
    public String getGravCtrDesc() {
        return this.gravCtrDesc;
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
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 * Column Info
	 * @return xtdOvrQty
	 */
    public String getXtdOvrQty() {
        return this.xtdOvrQty;
    }

    /**
	 * Column Info
	 * @return inGaFlg
	 */
    public String getInGaFlg() {
        return this.inGaFlg;
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
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	 * Column Info
	 * @return ovrLfLen
	 */
    public String getOvrLfLen() {
        return this.ovrLfLen;
    }

    /**
	 * Column Info
	 * @return ttlDimHgt
	 */
    public String getTtlDimHgt() {
        return this.ttlDimHgt;
    }

    /**
	 * Column Info
	 * @return cntrCgoSeq
	 */
    public String getCntrCgoSeq() {
        return this.cntrCgoSeq;
    }

    /**
	 * Column Info
	 * @return eqTpsz
	 */
    public String getEqTpsz() {
        return this.eqTpsz;
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
	 * @return ovrRtLen
	 */
    public String getOvrRtLen() {
        return this.ovrRtLen;
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
	 * @return awkCgoRqstGrpEml2
	 */
    public String getAwkCgoRqstGrpEml2() {
        return this.awkCgoRqstGrpEml2;
    }

    /**
	 * Column Info
	 * @return aplyNo
	 */
    public String getAplyNo() {
        return this.aplyNo;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return awkCgoRqstGrpEml1
	 */
    public String getAwkCgoRqstGrpEml1() {
        return this.awkCgoRqstGrpEml1;
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
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return ovrBkwdLen
	 */
    public String getOvrBkwdLen() {
        return this.ovrBkwdLen;
    }

    /**
	 * Column Info
	 * @return ttlDimLen
	 */
    public String getTtlDimLen() {
        return this.ttlDimLen;
    }

    /**
	 * Column Info
	 * @return crnPstStsCd
	 */
    public String getCrnPstStsCd() {
        return this.crnPstStsCd;
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
	 * @return ovrFwrdLen
	 */
    public String getOvrFwrdLen() {
        return this.ovrFwrdLen;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param pstLckPinFlg
	 */
    public void setPstLckPinFlg(String pstLckPinFlg) {
        this.pstLckPinFlg = pstLckPinFlg;
    }

    /**
	 * Column Info
	 * @param rqstUsrId
	 */
    public void setRqstUsrId(String rqstUsrId) {
        this.rqstUsrId = rqstUsrId;
    }

    /**
	 * Column Info
	 * @param ttlDimWdt
	 */
    public void setTtlDimWdt(String ttlDimWdt) {
        this.ttlDimWdt = ttlDimWdt;
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
	 * @param awkCgoSeq
	 */
    public void setAwkCgoSeq(String awkCgoSeq) {
        this.awkCgoSeq = awkCgoSeq;
    }

    /**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
    public void setOvrVoidSltQty(String ovrVoidSltQty) {
        this.ovrVoidSltQty = ovrVoidSltQty;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param ovrHgt
	 */
    public void setOvrHgt(String ovrHgt) {
        this.ovrHgt = ovrHgt;
    }

    /**
	 * Column Info
	 * @param undDeckTopFlg
	 */
    public void setUndDeckTopFlg(String undDeckTopFlg) {
        this.undDeckTopFlg = undDeckTopFlg;
    }

    /**
	 * Column Info
	 * @param spclCgoAproCd
	 */
    public void setSpclCgoAproCd(String spclCgoAproCd) {
        this.spclCgoAproCd = spclCgoAproCd;
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
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
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
	 * @param awkDcgoSeq
	 */
    public void setAwkDcgoSeq(String awkDcgoSeq) {
        this.awkDcgoSeq = awkDcgoSeq;
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
	 * @param stwgRqstDesc
	 */
    public void setStwgRqstDesc(String stwgRqstDesc) {
        this.stwgRqstDesc = stwgRqstDesc;
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
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param gravCtrDesc
	 */
    public void setGravCtrDesc(String gravCtrDesc) {
        this.gravCtrDesc = gravCtrDesc;
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
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param xtdOvrQty
	 */
    public void setXtdOvrQty(String xtdOvrQty) {
        this.xtdOvrQty = xtdOvrQty;
    }

    /**
	 * Column Info
	 * @param inGaFlg
	 */
    public void setInGaFlg(String inGaFlg) {
        this.inGaFlg = inGaFlg;
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
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param ovrLfLen
	 */
    public void setOvrLfLen(String ovrLfLen) {
        this.ovrLfLen = ovrLfLen;
    }

    /**
	 * Column Info
	 * @param ttlDimHgt
	 */
    public void setTtlDimHgt(String ttlDimHgt) {
        this.ttlDimHgt = ttlDimHgt;
    }

    /**
	 * Column Info
	 * @param cntrCgoSeq
	 */
    public void setCntrCgoSeq(String cntrCgoSeq) {
        this.cntrCgoSeq = cntrCgoSeq;
    }

    /**
	 * Column Info
	 * @param eqTpsz
	 */
    public void setEqTpsz(String eqTpsz) {
        this.eqTpsz = eqTpsz;
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
	 * @param ovrRtLen
	 */
    public void setOvrRtLen(String ovrRtLen) {
        this.ovrRtLen = ovrRtLen;
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
	 * @param awkCgoRqstGrpEml2
	 */
    public void setAwkCgoRqstGrpEml2(String awkCgoRqstGrpEml2) {
        this.awkCgoRqstGrpEml2 = awkCgoRqstGrpEml2;
    }

    /**
	 * Column Info
	 * @param aplyNo
	 */
    public void setAplyNo(String aplyNo) {
        this.aplyNo = aplyNo;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param awkCgoRqstGrpEml1
	 */
    public void setAwkCgoRqstGrpEml1(String awkCgoRqstGrpEml1) {
        this.awkCgoRqstGrpEml1 = awkCgoRqstGrpEml1;
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
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param ovrBkwdLen
	 */
    public void setOvrBkwdLen(String ovrBkwdLen) {
        this.ovrBkwdLen = ovrBkwdLen;
    }

    /**
	 * Column Info
	 * @param ttlDimLen
	 */
    public void setTtlDimLen(String ttlDimLen) {
        this.ttlDimLen = ttlDimLen;
    }

    /**
	 * Column Info
	 * @param crnPstStsCd
	 */
    public void setCrnPstStsCd(String crnPstStsCd) {
        this.crnPstStsCd = crnPstStsCd;
    }

    /**
	 * Column Info
	 * @param cntrVolQty
	 */
    public void setCntrVolQty(String cntrVolQty) {
        this.cntrVolQty = cntrVolQty;
    }

    /**
	 * Column Info
	 * @param ovrFwrdLen
	 */
    public void setOvrFwrdLen(String ovrFwrdLen) {
        this.ovrFwrdLen = ovrFwrdLen;
    }

    /**
	 * Column Info
	 * @param grsWgt
	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    public void setBkgCntrWgt(String bkgCntrWgt) {
        this.bkgCntrWgt = bkgCntrWgt;
    }

    public String getBkgCntrWgt() {
        return this.bkgCntrWgt;
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
        setPstLckPinFlg(JSPUtil.getParameter(request, prefix + "pst_lck_pin_flg", ""));
        setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
        setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
        setOvrVoidSltQty(JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
        setUndDeckTopFlg(JSPUtil.getParameter(request, prefix + "und_deck_top_flg", ""));
        setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setAwkDcgoSeq(JSPUtil.getParameter(request, prefix + "awk_dcgo_seq", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setStwgRqstDesc(JSPUtil.getParameter(request, prefix + "stwg_rqst_desc", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setGravCtrDesc(JSPUtil.getParameter(request, prefix + "grav_ctr_desc", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setXtdOvrQty(JSPUtil.getParameter(request, prefix + "xtd_ovr_qty", ""));
        setInGaFlg(JSPUtil.getParameter(request, prefix + "in_ga_flg", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
        setTtlDimHgt(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", ""));
        setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
        setEqTpsz(JSPUtil.getParameter(request, prefix + "eq_tpsz", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setAwkCgoRqstGrpEml2(JSPUtil.getParameter(request, prefix + "awk_cgo_rqst_grp_eml2", ""));
        setAplyNo(JSPUtil.getParameter(request, prefix + "aply_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setAwkCgoRqstGrpEml1(JSPUtil.getParameter(request, prefix + "awk_cgo_rqst_grp_eml1", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
        setTtlDimLen(JSPUtil.getParameter(request, prefix + "ttl_dim_len", ""));
        setCrnPstStsCd(JSPUtil.getParameter(request, prefix + "crn_pst_sts_cd", ""));
        setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
        setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setBkgCntrWgt(JSPUtil.getParameter(request, prefix + "bkg_cntr_wgt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgAwkCgoVO[]
	 */
    public BkgAwkCgoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgAwkCgoVO[]
	 */
    public BkgAwkCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgAwkCgoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] pstLckPinFlg = (JSPUtil.getParameter(request, prefix + "pst_lck_pin_flg", length));
            String[] rqstUsrId = (JSPUtil.getParameter(request, prefix + "rqst_usr_id", length));
            String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix + "awk_cgo_seq", length));
            String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ovrHgt = (JSPUtil.getParameter(request, prefix + "ovr_hgt", length));
            String[] undDeckTopFlg = (JSPUtil.getParameter(request, prefix + "und_deck_top_flg", length));
            String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] awkDcgoSeq = (JSPUtil.getParameter(request, prefix + "awk_dcgo_seq", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] stwgRqstDesc = (JSPUtil.getParameter(request, prefix + "stwg_rqst_desc", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] gravCtrDesc = (JSPUtil.getParameter(request, prefix + "grav_ctr_desc", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] xtdOvrQty = (JSPUtil.getParameter(request, prefix + "xtd_ovr_qty", length));
            String[] inGaFlg = (JSPUtil.getParameter(request, prefix + "in_ga_flg", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] ovrLfLen = (JSPUtil.getParameter(request, prefix + "ovr_lf_len", length));
            String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", length));
            String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", length));
            String[] eqTpsz = (JSPUtil.getParameter(request, prefix + "eq_tpsz", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] ovrRtLen = (JSPUtil.getParameter(request, prefix + "ovr_rt_len", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] awkCgoRqstGrpEml2 = (JSPUtil.getParameter(request, prefix + "awk_cgo_rqst_grp_eml2", length));
            String[] aplyNo = (JSPUtil.getParameter(request, prefix + "aply_no", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] awkCgoRqstGrpEml1 = (JSPUtil.getParameter(request, prefix + "awk_cgo_rqst_grp_eml1", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", length));
            String[] ttlDimLen = (JSPUtil.getParameter(request, prefix + "ttl_dim_len", length));
            String[] crnPstStsCd = (JSPUtil.getParameter(request, prefix + "crn_pst_sts_cd", length));
            String[] cntrVolQty = (JSPUtil.getParameter(request, prefix + "cntr_vol_qty", length));
            String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] bkgCntrWgt = (JSPUtil.getParameter(request, prefix + "bkg_cntr_wgt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgAwkCgoVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (pstLckPinFlg[i] != null)
                    model.setPstLckPinFlg(pstLckPinFlg[i]);
                if (rqstUsrId[i] != null)
                    model.setRqstUsrId(rqstUsrId[i]);
                if (ttlDimWdt[i] != null)
                    model.setTtlDimWdt(ttlDimWdt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (awkCgoSeq[i] != null)
                    model.setAwkCgoSeq(awkCgoSeq[i]);
                if (ovrVoidSltQty[i] != null)
                    model.setOvrVoidSltQty(ovrVoidSltQty[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ovrHgt[i] != null)
                    model.setOvrHgt(ovrHgt[i]);
                if (undDeckTopFlg[i] != null)
                    model.setUndDeckTopFlg(undDeckTopFlg[i]);
                if (spclCgoAproCd[i] != null)
                    model.setSpclCgoAproCd(spclCgoAproCd[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (awkDcgoSeq[i] != null)
                    model.setAwkDcgoSeq(awkDcgoSeq[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (stwgRqstDesc[i] != null)
                    model.setStwgRqstDesc(stwgRqstDesc[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (gravCtrDesc[i] != null)
                    model.setGravCtrDesc(gravCtrDesc[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (xtdOvrQty[i] != null)
                    model.setXtdOvrQty(xtdOvrQty[i]);
                if (inGaFlg[i] != null)
                    model.setInGaFlg(inGaFlg[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (ovrLfLen[i] != null)
                    model.setOvrLfLen(ovrLfLen[i]);
                if (ttlDimHgt[i] != null)
                    model.setTtlDimHgt(ttlDimHgt[i]);
                if (cntrCgoSeq[i] != null)
                    model.setCntrCgoSeq(cntrCgoSeq[i]);
                if (eqTpsz[i] != null)
                    model.setEqTpsz(eqTpsz[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (ovrRtLen[i] != null)
                    model.setOvrRtLen(ovrRtLen[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (awkCgoRqstGrpEml2[i] != null)
                    model.setAwkCgoRqstGrpEml2(awkCgoRqstGrpEml2[i]);
                if (aplyNo[i] != null)
                    model.setAplyNo(aplyNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (awkCgoRqstGrpEml1[i] != null)
                    model.setAwkCgoRqstGrpEml1(awkCgoRqstGrpEml1[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (ovrBkwdLen[i] != null)
                    model.setOvrBkwdLen(ovrBkwdLen[i]);
                if (ttlDimLen[i] != null)
                    model.setTtlDimLen(ttlDimLen[i]);
                if (crnPstStsCd[i] != null)
                    model.setCrnPstStsCd(crnPstStsCd[i]);
                if (cntrVolQty[i] != null)
                    model.setCntrVolQty(cntrVolQty[i]);
                if (ovrFwrdLen[i] != null)
                    model.setOvrFwrdLen(ovrFwrdLen[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (bkgCntrWgt[i] != null) 
		    		model.setBkgCntrWgt(bkgCntrWgt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgAwkCgoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgAwkCgoVO[]
	 */
    public BkgAwkCgoVO[] getBkgAwkCgoVOs() {
        BkgAwkCgoVO[] vos = (BkgAwkCgoVO[]) models.toArray(new BkgAwkCgoVO[models.size()]);
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
        this.pstLckPinFlg = this.pstLckPinFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrId = this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimWdt = this.ttlDimWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoSeq = this.awkCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrVoidSltQty = this.ovrVoidSltQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrHgt = this.ovrHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.undDeckTopFlg = this.undDeckTopFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproCd = this.spclCgoAproCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkDcgoSeq = this.awkDcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgRqstDesc = this.stwgRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gravCtrDesc = this.gravCtrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xtdOvrQty = this.xtdOvrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inGaFlg = this.inGaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrLfLen = this.ovrLfLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimHgt = this.ttlDimHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoSeq = this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqTpsz = this.eqTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrRtLen = this.ovrRtLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoRqstGrpEml2 = this.awkCgoRqstGrpEml2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aplyNo = this.aplyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoRqstGrpEml1 = this.awkCgoRqstGrpEml1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrBkwdLen = this.ovrBkwdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimLen = this.ttlDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crnPstStsCd = this.crnPstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVolQty = this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrFwrdLen = this.ovrFwrdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntrWgt = this.bkgCntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}