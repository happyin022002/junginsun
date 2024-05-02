/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrAproRqstVO.java
 *@FileTitle : ScgPrnrAproRqstVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.01
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.01 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

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
public class ScgPrnrAproRqstVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgPrnrAproRqstVO> models = new ArrayList<ScgPrnrAproRqstVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String crrCd = null;

    /*	Column Info	*/
    private String bkgRefNo = null;

    /*	Column Info	*/
    private String spclCgoRqstSeq = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String rgnShpOprCd = null;

    /*	Column Info	*/
    private String cgoOprCd = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String etaDt = null;

    /*	Column Info	*/
    private String dgFlg = null;

    /*	Column Info	*/
    private String awkFlg = null;

    /*	Column Info	*/
    private String polClptIndSeq = null;

    /*	Column Info	*/
    private String podClptIndSeq = null;

    /*	Column Info	*/
    private String srcTpCd = null;

    /*	Column Info	*/
    private String mapgTrsmBndCd = null;

    /*	Column Info	*/
    private String mapgTrsmDt = null;

    /*	Column Info	*/
    private String mapgTrsmSpclCgoCateCd = null;

    /*	Column Info	*/
    private String mapgPrnrSpclCgoSeq = null;

    /*	Column Info	*/
    private String mapgEdiTrsmStsCd = null;

    /*	Column Info	*/
    private String emlSndNo = null;

    /*	Column Info	*/
    private String lstRqstDatFlg = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String dcgoRefNo = null;

    // request 동록처리 skip여부
    private boolean skip = false;

    /* Column Info */
    private String trsmDt = null;

    /* Column Info */
    private String prnrSpclCgoSeq = null;

    /* Column Info */
    private String prnrCgoRqstSeq = null;

    /* Column Info */
    private String spclCgoCateCd = null;

    /* Column Info */
    private String ediUnmapKndCd = null;

    /* Column Info */
    private String ediUnmapDtlCd = null;
    
    /* Column Info */
    private String ediUnmapCorrRmk = null;

    /* Column Info */
    private String unmapPolCd = null;
    
    /* Column Info */
    private String unmapPodCd = null;
    
    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /*	Column Info	*/
    private String rqstOfcCd = null;

    /**	Constructor	*/
    public ScgPrnrAproRqstVO() {
    }

    public ScgPrnrAproRqstVO(String ibflag, String pagerows, String crrCd, String bkgRefNo, String spclCgoRqstSeq, String vslCd, String skdVoyNo, String skdDirCd, String slanCd, String rgnShpOprCd, String cgoOprCd, String polCd, String podCd, String etaDt, String dgFlg, String awkFlg, String polClptIndSeq, String podClptIndSeq, String srcTpCd, String mapgTrsmBndCd, String mapgTrsmDt, String mapgTrsmSpclCgoCateCd, String mapgPrnrSpclCgoSeq, String mapgEdiTrsmStsCd, String emlSndNo, String lstRqstDatFlg, String creUsrId, String creDt, String updUsrId, String updDt, String dcgoRefNo, String rqstOfcCd, String prnrCgoRqstSeq, String trsmDt, String prnrSpclCgoSeq, String spclCgoCateCd, String ediUnmapKndCd, String ediUnmapDtlCd, String ediUnmapCorrRmk, String unmapPolCd, String unmapPodCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.crrCd = crrCd;
        this.bkgRefNo = bkgRefNo;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.slanCd = slanCd;
        this.rgnShpOprCd = rgnShpOprCd;
        this.cgoOprCd = cgoOprCd;
        this.polCd = polCd;
        this.podCd = podCd;
        this.etaDt = etaDt;
        this.dgFlg = dgFlg;
        this.awkFlg = awkFlg;
        this.polClptIndSeq = polClptIndSeq;
        this.podClptIndSeq = podClptIndSeq;
        this.srcTpCd = srcTpCd;
        this.mapgTrsmBndCd = mapgTrsmBndCd;
        this.mapgTrsmDt = mapgTrsmDt;
        this.mapgTrsmSpclCgoCateCd = mapgTrsmSpclCgoCateCd;
        this.mapgPrnrSpclCgoSeq = mapgPrnrSpclCgoSeq;
        this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
        this.emlSndNo = emlSndNo;
        this.lstRqstDatFlg = lstRqstDatFlg;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.dcgoRefNo = dcgoRefNo;
        this.rqstOfcCd = rqstOfcCd;
        this.trsmDt = trsmDt;
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
        this.spclCgoCateCd = spclCgoCateCd;
        this.ediUnmapKndCd = ediUnmapKndCd;
        this.ediUnmapDtlCd = ediUnmapDtlCd;
        this.ediUnmapCorrRmk = ediUnmapCorrRmk;
        this.unmapPolCd = unmapPolCd;
        this.unmapPodCd = unmapPodCd;
        
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("eta_dt", getEtaDt());
        this.hashColumns.put("dg_flg", getDgFlg());
        this.hashColumns.put("awk_flg", getAwkFlg());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("src_tp_cd", getSrcTpCd());
        this.hashColumns.put("mapg_trsm_bnd_cd", getMapgTrsmBndCd());
        this.hashColumns.put("mapg_trsm_dt", getMapgTrsmDt());
        this.hashColumns.put("mapg_trsm_spcl_cgo_cate_cd", getMapgTrsmSpclCgoCateCd());
        this.hashColumns.put("mapg_prnr_spcl_cgo_seq", getMapgPrnrSpclCgoSeq());
        this.hashColumns.put("mapg_edi_trsm_sts_cd", getMapgEdiTrsmStsCd());
        this.hashColumns.put("eml_snd_no", getEmlSndNo());
        this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
        this.hashColumns.put("trsm_dt", getTrsmDt());
        this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
        this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("edi_unmap_knd_cd", getEdiUnmapKndCd());
        this.hashColumns.put("edi_unmap_dtl_cd", getEdiUnmapDtlCd());
        this.hashColumns.put("edi_unmap_corr_rmk", getEdiUnmapCorrRmk());
        this.hashColumns.put("unmap_pol_cd", getUnmapPolCd());
        this.hashColumns.put("unmap_pod_cd", getUnmapPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("eta_dt", "etaDt");
        this.hashFields.put("dg_flg", "dgFlg");
        this.hashFields.put("awk_flg", "awkFlg");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("src_tp_cd", "srcTpCd");
        this.hashFields.put("mapg_trsm_bnd_cd", "mapgTrsmBndCd");
        this.hashFields.put("mapg_trsm_dt", "mapgTrsmDt");
        this.hashFields.put("mapg_trsm_spcl_cgo_cate_cd", "mapgTrsmSpclCgoCateCd");
        this.hashFields.put("mapg_prnr_spcl_cgo_seq", "mapgPrnrSpclCgoSeq");
        this.hashFields.put("mapg_edi_trsm_sts_cd", "mapgEdiTrsmStsCd");
        this.hashFields.put("eml_snd_no", "emlSndNo");
        this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
        this.hashFields.put("trsm_dt", "trsmDt");
        this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
        this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("edi_unmap_knd_cd", "ediUnmapKndCd");
        this.hashFields.put("edi_unmap_dtl_cd", "ediUnmapDtlCd");
        this.hashFields.put("edi_unmap_corr_rmk", "ediUnmapCorrRmk");
        this.hashFields.put("unmap_pol_cd", "unmapPolCd");
        this.hashFields.put("unmap_pod_cd", "unmapPodCd");
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
	 * @return crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
    }

    /**
	 * Column Info
	 * @return bkgRefNo
	 */
    public String getBkgRefNo() {
        return this.bkgRefNo;
    }

    /**
	 * Column Info
	 * @return spclCgoRqstSeq
	 */
    public String getSpclCgoRqstSeq() {
        return this.spclCgoRqstSeq;
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
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 * Column Info
	 * @return rgnShpOprCd
	 */
    public String getRgnShpOprCd() {
        return this.rgnShpOprCd;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return etaDt
	 */
    public String getEtaDt() {
        return this.etaDt;
    }

    /**
	 * Column Info
	 * @return dgFlg
	 */
    public String getDgFlg() {
        return this.dgFlg;
    }

    /**
	 * Column Info
	 * @return awkFlg
	 */
    public String getAwkFlg() {
        return this.awkFlg;
    }

    /**
	 * Column Info
	 * @return polClptIndSeq
	 */
    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    /**
	 * Column Info
	 * @return podClptIndSeq
	 */
    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
    }

    /**
	 * Column Info
	 * @return srcTpCd
	 */
    public String getSrcTpCd() {
        return this.srcTpCd;
    }

    /**
	 * Column Info
	 * @return mapgTrsmBndCd
	 */
    public String getMapgTrsmBndCd() {
        return this.mapgTrsmBndCd;
    }

    /**
	 * Column Info
	 * @return mapgTrsmDt
	 */
    public String getMapgTrsmDt() {
        return this.mapgTrsmDt;
    }

    /**
	 * Column Info
	 * @return mapgTrsmSpclCgoCateCd
	 */
    public String getMapgTrsmSpclCgoCateCd() {
        return this.mapgTrsmSpclCgoCateCd;
    }

    /**
	 * Column Info
	 * @return mapgPrnrSpclCgoSeq
	 */
    public String getMapgPrnrSpclCgoSeq() {
        return this.mapgPrnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @return mapgEdiTrsmStsCd
	 */
    public String getMapgEdiTrsmStsCd() {
        return this.mapgEdiTrsmStsCd;
    }

    /**
	 * Column Info
	 * @return emlSndNo
	 */
    public String getEmlSndNo() {
        return this.emlSndNo;
    }

    /**
	 * Column Info
	 * @return lstRqstDatFlg
	 */
    public String getLstRqstDatFlg() {
        return this.lstRqstDatFlg;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
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
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
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
	 * @return rqstOfcCd
	 */
    public String getRqstOfcCd() {
        return this.rqstOfcCd;
    }

    /**
	 * skip여부(requst등록 중복 방지용)
	 * @return skip
	 */
    public boolean getSkip() {
        return this.skip;
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
	 * @param  crrCd
 	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * Column Info
	 * @param  bkgRefNo
 	 */
    public void setBkgRefNo(String bkgRefNo) {
        this.bkgRefNo = bkgRefNo;
    }

    /**
	 * Column Info
	 * @param  spclCgoRqstSeq
 	 */
    public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
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
	 * @param  slanCd
 	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param  rgnShpOprCd
 	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @param  cgoOprCd
 	 */
    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
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
	 * @param  podCd
 	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param  etaDt
 	 */
    public void setEtaDt(String etaDt) {
        this.etaDt = etaDt;
    }

    /**
	 * Column Info
	 * @param  dgFlg
 	 */
    public void setDgFlg(String dgFlg) {
        this.dgFlg = dgFlg;
    }

    /**
	 * Column Info
	 * @param  awkFlg
 	 */
    public void setAwkFlg(String awkFlg) {
        this.awkFlg = awkFlg;
    }

    /**
	 * Column Info
	 * @param  polClptIndSeq
 	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  podClptIndSeq
 	 */
    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  srcTpCd
 	 */
    public void setSrcTpCd(String srcTpCd) {
        this.srcTpCd = srcTpCd;
    }

    /**
	 * Column Info
	 * @param  mapgTrsmBndCd
 	 */
    public void setMapgTrsmBndCd(String mapgTrsmBndCd) {
        this.mapgTrsmBndCd = mapgTrsmBndCd;
    }

    /**
	 * Column Info
	 * @param  mapgTrsmDt
 	 */
    public void setMapgTrsmDt(String mapgTrsmDt) {
        this.mapgTrsmDt = mapgTrsmDt;
    }

    /**
	 * Column Info
	 * @param  mapgTrsmSpclCgoCateCd
 	 */
    public void setMapgTrsmSpclCgoCateCd(String mapgTrsmSpclCgoCateCd) {
        this.mapgTrsmSpclCgoCateCd = mapgTrsmSpclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param  mapgPrnrSpclCgoSeq
 	 */
    public void setMapgPrnrSpclCgoSeq(String mapgPrnrSpclCgoSeq) {
        this.mapgPrnrSpclCgoSeq = mapgPrnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @param  mapgEdiTrsmStsCd
 	 */
    public void setMapgEdiTrsmStsCd(String mapgEdiTrsmStsCd) {
        this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
    }

    /**
	 * Column Info
	 * @param  emlSndNo
 	 */
    public void setEmlSndNo(String emlSndNo) {
        this.emlSndNo = emlSndNo;
    }

    /**
	 * Column Info
	 * @param  lstRqstDatFlg
 	 */
    public void setLstRqstDatFlg(String lstRqstDatFlg) {
        this.lstRqstDatFlg = lstRqstDatFlg;
    }

    /**
	 * Column Info
	 * @param  creUsrId
 	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param  creDt
 	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public void setTrsmDt(String trsmDt) {
        this.trsmDt = trsmDt;
    }

    public String getTrsmDt() {
        return this.trsmDt;
    }

    public void setPrnrSpclCgoSeq(String prnrSpclCgoSeq) {
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
    }

    public String getPrnrSpclCgoSeq() {
        return this.prnrSpclCgoSeq;
    }

    public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
    }

    public String getPrnrCgoRqstSeq() {
        return this.prnrCgoRqstSeq;
    }

    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    public String getSpclCgoCateCd() {
        return this.spclCgoCateCd;
    }

    public void setEdiUnmapKndCd(String ediUnmapKndCd) {
        this.ediUnmapKndCd = ediUnmapKndCd;
    }

    public String getEdiUnmapKndCd() {
        return this.ediUnmapKndCd;
    }

    public void setEdiUnmapDtlCd(String ediUnmapDtlCd) {
        this.ediUnmapDtlCd = ediUnmapDtlCd;
    }

    public String getEdiUnmapDtlCd() {
        return this.ediUnmapDtlCd;
    }
    
    public void setEdiUnmapCorrRmk(String ediUnmapCorrRmk) {
        this.ediUnmapCorrRmk = ediUnmapCorrRmk;
    }

    public String getEdiUnmapCorrRmk() {
        return this.ediUnmapCorrRmk;
    }

    public void setUnmapPolCd(String unmapPolCd) {
        this.unmapPolCd = unmapPolCd;
    }

    public String getUnmapPolCd() {
        return this.unmapPolCd;
    }
    
    public void setUnmapPodCd(String unmapPodCd) {
        this.unmapPodCd = unmapPodCd;
    }

    public String getUnmapPodCd() {
        return this.unmapPodCd;
    }
    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Column Info
	 * @param  dcgoRefNo
 	 */
    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
    }

    /**
	 * Column Info
	 * @param  rqstOfcCd
 	 */
    public void setRqstOfcCd(String rqstOfcCd) {
        this.rqstOfcCd = rqstOfcCd;
    }

    /**
	 * skip여부(requst등록 중복 방지용)
	 * @param skip
	 */
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
        setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
        setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
        setSrcTpCd(JSPUtil.getParameter(request, prefix + "src_tp_cd", ""));
        setMapgTrsmBndCd(JSPUtil.getParameter(request, prefix + "mapg_trsm_bnd_cd", ""));
        setMapgTrsmDt(JSPUtil.getParameter(request, prefix + "mapg_trsm_dt", ""));
        setMapgTrsmSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "mapg_trsm_spcl_cgo_cate_cd", ""));
        setMapgPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "mapg_prnr_spcl_cgo_seq", ""));
        setMapgEdiTrsmStsCd(JSPUtil.getParameter(request, prefix + "mapg_edi_trsm_sts_cd", ""));
        setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
        setLstRqstDatFlg(JSPUtil.getParameter(request, prefix + "lst_rqst_dat_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
        setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
        setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
        setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
        setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
        setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setEdiUnmapKndCd(JSPUtil.getParameter(request, prefix + "edi_unmap_knd_cd", ""));
        setEdiUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", ""));
        setEdiUnmapCorrRmk(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rmk", ""));
        setUnmapPolCd(JSPUtil.getParameter(request, prefix + "unmap_pol_cd", ""));
        setUnmapPodCd(JSPUtil.getParameter(request, prefix + "unmap_pod_cd", ""));
        
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrAproRqstVO[]
	 */
    public ScgPrnrAproRqstVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrAproRqstVO[]
	 */
    public ScgPrnrAproRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgPrnrAproRqstVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] etaDt = (JSPUtil.getParameter(request, prefix + "eta_dt", length));
            String[] dgFlg = (JSPUtil.getParameter(request, prefix + "dg_flg", length));
            String[] awkFlg = (JSPUtil.getParameter(request, prefix + "awk_flg", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
            String[] srcTpCd = (JSPUtil.getParameter(request, prefix + "src_tp_cd", length));
            String[] mapgTrsmBndCd = (JSPUtil.getParameter(request, prefix + "mapg_trsm_bnd_cd", length));
            String[] mapgTrsmDt = (JSPUtil.getParameter(request, prefix + "mapg_trsm_dt", length));
            String[] mapgTrsmSpclCgoCateCd = (JSPUtil.getParameter(request, prefix + "mapg_trsm_spcl_cgo_cate_cd", length));
            String[] mapgPrnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "mapg_prnr_spcl_cgo_seq", length));
            String[] mapgEdiTrsmStsCd = (JSPUtil.getParameter(request, prefix + "mapg_edi_trsm_sts_cd", length));
            String[] emlSndNo = (JSPUtil.getParameter(request, prefix + "eml_snd_no", length));
            String[] lstRqstDatFlg = (JSPUtil.getParameter(request, prefix + "lst_rqst_dat_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix + "dcgo_ref_no", length));
            String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", length));
            String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", length));
            String[] trsmDt = (JSPUtil.getParameter(request, prefix + "trsm_dt", length));
            String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] ediUnmapKndCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_knd_cd", length));
            String[] ediUnmapDtlCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", length));
            String[] ediUnmapCorrRmk = (JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rmk", length));
            String[] unmapPolCd = (JSPUtil.getParameter(request, prefix + "unmap_pol_cd", length));
            String[] unmapPodCd = (JSPUtil.getParameter(request, prefix + "unmap_pod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgPrnrAproRqstVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (etaDt[i] != null)
                    model.setEtaDt(etaDt[i]);
                if (dgFlg[i] != null)
                    model.setDgFlg(dgFlg[i]);
                if (awkFlg[i] != null)
                    model.setAwkFlg(awkFlg[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (srcTpCd[i] != null)
                    model.setSrcTpCd(srcTpCd[i]);
                if (mapgTrsmBndCd[i] != null)
                    model.setMapgTrsmBndCd(mapgTrsmBndCd[i]);
                if (mapgTrsmDt[i] != null)
                    model.setMapgTrsmDt(mapgTrsmDt[i]);
                if (mapgTrsmSpclCgoCateCd[i] != null)
                    model.setMapgTrsmSpclCgoCateCd(mapgTrsmSpclCgoCateCd[i]);
                if (mapgPrnrSpclCgoSeq[i] != null)
                    model.setMapgPrnrSpclCgoSeq(mapgPrnrSpclCgoSeq[i]);
                if (mapgEdiTrsmStsCd[i] != null)
                    model.setMapgEdiTrsmStsCd(mapgEdiTrsmStsCd[i]);
                if (emlSndNo[i] != null)
                    model.setEmlSndNo(emlSndNo[i]);
                if (lstRqstDatFlg[i] != null)
                    model.setLstRqstDatFlg(lstRqstDatFlg[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (dcgoRefNo[i] != null)
                    model.setDcgoRefNo(dcgoRefNo[i]);
                if (rqstOfcCd[i] != null)
                    model.setRqstOfcCd(rqstOfcCd[i]);
                if (prnrCgoRqstSeq[i] != null)
                    model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
                if (trsmDt[i] != null)
                    model.setTrsmDt(trsmDt[i]);
                if (prnrSpclCgoSeq[i] != null)
                    model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (ediUnmapKndCd[i] != null) 
		    		model.setEdiUnmapKndCd(ediUnmapKndCd[i]);
                if (ediUnmapDtlCd[i] != null) 
		    		model.setEdiUnmapDtlCd(ediUnmapDtlCd[i]);
                if (ediUnmapCorrRmk[i] != null) 
		    		model.setEdiUnmapCorrRmk(ediUnmapCorrRmk[i]);
                if (unmapPolCd[i] != null) 
		    		model.setUnmapPolCd(unmapPolCd[i]);
                if (unmapPodCd[i] != null) 
		    		model.setUnmapPodCd(unmapPodCd[i]);                
                /* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgPrnrAproRqstVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ScgPrnrAproRqstVO[]
	 */
    public ScgPrnrAproRqstVO[] getScgPrnrAproRqstVOs() {
        ScgPrnrAproRqstVO[] vos = (ScgPrnrAproRqstVO[]) models.toArray(new ScgPrnrAproRqstVO[models.size()]);
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
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etaDt = this.etaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgFlg = this.dgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkFlg = this.awkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srcTpCd = this.srcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgTrsmBndCd = this.mapgTrsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgTrsmDt = this.mapgTrsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgTrsmSpclCgoCateCd = this.mapgTrsmSpclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgPrnrSpclCgoSeq = this.mapgPrnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgEdiTrsmStsCd = this.mapgEdiTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndNo = this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstRqstDatFlg = this.lstRqstDatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRefNo = this.dcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmDt = this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSeq = this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrCgoRqstSeq = this.prnrCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapKndCd = this.ediUnmapKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapDtlCd = this.ediUnmapDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapCorrRmk = this.ediUnmapCorrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unmapPolCd = this.unmapPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unmapPodCd = this.unmapPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
