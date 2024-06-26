/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOwnBBListVO.java
*@FileTitle : SearchOwnBBListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.10.16 이도형 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchOwnBBListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchOwnBBListVO> models = new ArrayList<SearchOwnBBListVO>();

    /* Column Info */
    private String spclCgoRqstSeq = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String no = null;

    /* Column Info */
    private String scgFlg = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String crrCode = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String dimWdt = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String spclCgoAuthNo = null;

    /* Column Info */
    private String rgnShpOprCd = null;

    /* Column Info */
    private String authOfcCd = null;

    /* Column Info */
    private String authDt = null;

    /* Column Info */
    private String dimHgt = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String spclCgoCateCd = null;

    /* Column Info */
    private String podClptIndSeq = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String spclCgoAuthRjctCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String spclCgoAuthRmk = null;

    /* Column Info */
    private String bbCgoQty = null;

    /* Column Info */
    private String bbCgoSeq = null;

    /* Column Info */
    private String spclCgoAuthSeq = null;

    /* Column Info */
    private String authUsrId = null;

    /* Column Info */
    private String aproRefNo = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String rqstUsrId = null;

    /* Column Info */
    private String rqstDay = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String bkgRcvTermCd = null;

    /* Column Info */
    private String vslSeq = null;

    /* Column Info */
    private String ovrVoidSltQty = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String lstRqstDatFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dimLen = null;

    /* Column Info */
    private String spclCgoAproRqstSeq = null;

    /* Column Info */
    private String vslPrePstCd = null;

    /* Column Info */
    private String vslPrePstNm = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String rqstAuthCd = null;

    /* Column Info */
    private String bookingNo = null;

    /* Column Info */
    private String spclCgoAuthCd = null;

    /* Column Info */
    private String emlSndNo = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String rqstOfcCd = null;

    /* Column Info */
    private String bkgDeTermCd = null;

    /* Column Info */
    private String rqstGdt = null;

    /* Column Info */
    private String authGdt = null;

    /* Column Info */
    private String updDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchOwnBBListVO() {
    }

    public SearchOwnBBListVO(String ibflag, String pagerows, String no, String bookingNo, String bkgStsCd, String bbCgoSeq, String rqstDay, String spclCgoAuthCd, String spclCgoAuthRjctCd, String aproRefNo, String emlSndNo, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String crrCd, String crrCode, String porCd, String polCd, String vpsEtaDt, String podCd, String delCd, String cmdtNm, String dimLen, String dimWdt, String dimHgt, String grsWgt, String ovrVoidSltQty, String rqstDt, String bkgNo, String spclCgoAproRqstSeq, String spclCgoRqstSeq, String vslPrePstCd, String vslPrePstNm, String vslSeq, String spclCgoCateCd, String bbCgoQty, String lstRqstDatFlg, String bkgRcvTermCd, String bkgDeTermCd, String polClptIndSeq, String podClptIndSeq, String polYdCd, String podYdCd, String rgnShpOprCd, String spclCgoAuthNo, String authOfcCd, String spclCgoAuthSeq, String scgFlg, String rqstAuthCd, String rqstOfcCd, String rqstUsrId, String authDt, String authUsrId, String spclCgoAuthRmk, String rqstGdt, String authGdt, String updDt) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.vslCd = vslCd;
        this.no = no;
        this.scgFlg = scgFlg;
        this.crrCd = crrCd;
        this.crrCode = crrCode;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.dimWdt = dimWdt;
        this.polClptIndSeq = polClptIndSeq;
        this.spclCgoAuthNo = spclCgoAuthNo;
        this.rgnShpOprCd = rgnShpOprCd;
        this.authOfcCd = authOfcCd;
        this.authDt = authDt;
        this.dimHgt = dimHgt;
        this.delCd = delCd;
        this.spclCgoCateCd = spclCgoCateCd;
        this.podClptIndSeq = podClptIndSeq;
        this.skdVoyNo = skdVoyNo;
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.spclCgoAuthRmk = spclCgoAuthRmk;
        this.bbCgoQty = bbCgoQty;
        this.bbCgoSeq = bbCgoSeq;
        this.spclCgoAuthSeq = spclCgoAuthSeq;
        this.authUsrId = authUsrId;
        this.aproRefNo = aproRefNo;
        this.grsWgt = grsWgt;
        this.porCd = porCd;
        this.rqstUsrId = rqstUsrId;
        this.rqstDay = rqstDay;
        this.bkgStsCd = bkgStsCd;
        this.bkgRcvTermCd = bkgRcvTermCd;
        this.vslSeq = vslSeq;
        this.ovrVoidSltQty = ovrVoidSltQty;
        this.vpsEtaDt = vpsEtaDt;
        this.lstRqstDatFlg = lstRqstDatFlg;
        this.ibflag = ibflag;
        this.dimLen = dimLen;
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
        this.vslPrePstCd = vslPrePstCd;
        this.vslPrePstNm = vslPrePstNm;
        this.podYdCd = podYdCd;
        this.rqstDt = rqstDt;
        this.rqstAuthCd = rqstAuthCd;
        this.bookingNo = bookingNo;
        this.spclCgoAuthCd = spclCgoAuthCd;
        this.emlSndNo = emlSndNo;
        this.cmdtNm = cmdtNm;
        this.skdDirCd = skdDirCd;
        this.slanCd = slanCd;
        this.polYdCd = polYdCd;
        this.rqstOfcCd = rqstOfcCd;
        this.bkgDeTermCd = bkgDeTermCd;
        this.rqstGdt = rqstGdt;
        this.authGdt = authGdt;
        this.updDt = updDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("no", getNo());
        this.hashColumns.put("scg_flg", getScgFlg());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("crr_code", getCrrCode());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("dim_wdt", getDimWdt());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("spcl_cgo_auth_no", getSpclCgoAuthNo());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("auth_dt", getAuthDt());
        this.hashColumns.put("dim_hgt", getDimHgt());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
        this.hashColumns.put("bb_cgo_qty", getBbCgoQty());
        this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
        this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
        this.hashColumns.put("auth_usr_id", getAuthUsrId());
        this.hashColumns.put("apro_ref_no", getAproRefNo());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("rqst_usr_id", getRqstUsrId());
        this.hashColumns.put("rqst_day", getRqstDay());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
        this.hashColumns.put("vsl_seq", getVslSeq());
        this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("dim_len", getDimLen());
        this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("vsl_pre_pst_nm", getVslPrePstNm());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("rqst_auth_cd", getRqstAuthCd());
        this.hashColumns.put("booking_no", getBookingNo());
        this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
        this.hashColumns.put("eml_snd_no", getEmlSndNo());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
        this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
        this.hashColumns.put("rqst_gdt", getRqstGdt());
        this.hashColumns.put("auth_gdt", getAuthGdt());
        this.hashColumns.put("upd_dt", getUpdDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("no", "no");
        this.hashFields.put("scg_flg", "scgFlg");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("crr_code", "crrCode");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("dim_wdt", "dimWdt");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("spcl_cgo_auth_no", "spclCgoAuthNo");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("auth_dt", "authDt");
        this.hashFields.put("dim_hgt", "dimHgt");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
        this.hashFields.put("bb_cgo_qty", "bbCgoQty");
        this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
        this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
        this.hashFields.put("auth_usr_id", "authUsrId");
        this.hashFields.put("apro_ref_no", "aproRefNo");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("rqst_usr_id", "rqstUsrId");
        this.hashFields.put("rqst_day", "rqstDay");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
        this.hashFields.put("vsl_seq", "vslSeq");
        this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("dim_len", "dimLen");
        this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("vsl_pre_pst_nm", "vslPrePstNm");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("rqst_auth_cd", "rqstAuthCd");
        this.hashFields.put("booking_no", "bookingNo");
        this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
        this.hashFields.put("eml_snd_no", "emlSndNo");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
        this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
        this.hashFields.put("rqst_gdt", "rqstGdt");
        this.hashFields.put("auth_gdt", "authGdt");
        this.hashFields.put("upd_dt", "updDt");
        return this.hashFields;
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
	 * @return no
	 */
    public String getNo() {
        return this.no;
    }

    /**
	 * Column Info
	 * @return scgFlg
	 */
    public String getScgFlg() {
        return this.scgFlg;
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
	 * @return crrCode
	 */
    public String getCrrCode() {
        return this.crrCode;
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
	 * @return dimWdt
	 */
    public String getDimWdt() {
        return this.dimWdt;
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
	 * @return spclCgoAuthNo
	 */
    public String getSpclCgoAuthNo() {
        return this.spclCgoAuthNo;
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
	 * @return authOfcCd
	 */
    public String getAuthOfcCd() {
        return this.authOfcCd;
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
	 * @return dimHgt
	 */
    public String getDimHgt() {
        return this.dimHgt;
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
	 * @return spclCgoCateCd
	 */
    public String getSpclCgoCateCd() {
        return this.spclCgoCateCd;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthRjctCd
	 */
    public String getSpclCgoAuthRjctCd() {
        return this.spclCgoAuthRjctCd;
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
	 * @return spclCgoAuthRmk
	 */
    public String getSpclCgoAuthRmk() {
        return this.spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @return bbCgoQty
	 */
    public String getBbCgoQty() {
        return this.bbCgoQty;
    }

    /**
	 * Column Info
	 * @return bbCgoSeq
	 */
    public String getBbCgoSeq() {
        return this.bbCgoSeq;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthSeq
	 */
    public String getSpclCgoAuthSeq() {
        return this.spclCgoAuthSeq;
    }

    /**
	 * Column Info
	 * @return authUsrId
	 */
    public String getAuthUsrId() {
        return this.authUsrId;
    }

    /**
	 * Column Info
	 * @return aproRefNo
	 */
    public String getAproRefNo() {
        return this.aproRefNo;
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
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
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
	 * @return rqstDay
	 */
    public String getRqstDay() {
        return this.rqstDay;
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
	 * @return bkgRcvTermCd
	 */
    public String getBkgRcvTermCd() {
        return this.bkgRcvTermCd;
    }

    /**
	 * Column Info
	 * @return vslSeq
	 */
    public String getVslSeq() {
        return this.vslSeq;
    }

    /**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
    public String getOvrVoidSltQty() {
        return this.ovrVoidSltQty;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return lstRqstDatFlg
	 */
    public String getLstRqstDatFlg() {
        return this.lstRqstDatFlg;
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
	 * @return dimLen
	 */
    public String getDimLen() {
        return this.dimLen;
    }

    /**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
    public String getSpclCgoAproRqstSeq() {
        return this.spclCgoAproRqstSeq;
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
	 * @return vslPrePstNm
	 */
    public String getVslPrePstNm() {
        return this.vslPrePstNm;
    }

    /**
	 * Column Info
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
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
	 * @return rqstAuthCd
	 */
    public String getRqstAuthCd() {
        return this.rqstAuthCd;
    }

    /**
	 * Column Info
	 * @return bookingNo
	 */
    public String getBookingNo() {
        return this.bookingNo;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthCd
	 */
    public String getSpclCgoAuthCd() {
        return this.spclCgoAuthCd;
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
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
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
	 * @return polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
    }

    /**
	 * Column Info
	 * @return rqstOfcCd
	 */
    public String getRqstOfcCd() {
        return this.rqstOfcCd;
    }

    /**
	 * Column Info
	 * @return bkgDeTermCd
	 */
    public String getBkgDeTermCd() {
        return this.bkgDeTermCd;
    }

    /**
	 * Column Info
	 * @return rqstGdt
	 */
    public String getRqstGdt() {
        return this.rqstGdt;
    }

    /**
	 * Column Info
	 * @return authGdt
	 */
    public String getAuthGdt() {
        return this.authGdt;
    }

    /**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
    public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
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
	 * @param no
	 */
    public void setNo(String no) {
        this.no = no;
    }

    /**
	 * Column Info
	 * @param scgFlg
	 */
    public void setScgFlg(String scgFlg) {
        this.scgFlg = scgFlg;
    }

    /**
	 * Column Info
	 * @param crrCd
	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * Column Info
	 * @param crrCode
	 */
    public void setCrrCode(String crrCode) {
        this.crrCode = crrCode;
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
	 * @param dimWdt
	 */
    public void setDimWdt(String dimWdt) {
        this.dimWdt = dimWdt;
    }

    /**
	 * Column Info
	 * @param polClptIndSeq
	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthNo
	 */
    public void setSpclCgoAuthNo(String spclCgoAuthNo) {
        this.spclCgoAuthNo = spclCgoAuthNo;
    }

    /**
	 * Column Info
	 * @param rgnShpOprCd
	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @param authOfcCd
	 */
    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
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
	 * @param dimHgt
	 */
    public void setDimHgt(String dimHgt) {
        this.dimHgt = dimHgt;
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
	 * @param spclCgoCateCd
	 */
    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param podClptIndSeq
	 */
    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
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
	 * @param spclCgoAuthRjctCd
	 */
    public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
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
	 * @param spclCgoAuthRmk
	 */
    public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
        this.spclCgoAuthRmk = spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @param bbCgoQty
	 */
    public void setBbCgoQty(String bbCgoQty) {
        this.bbCgoQty = bbCgoQty;
    }

    /**
	 * Column Info
	 * @param bbCgoSeq
	 */
    public void setBbCgoSeq(String bbCgoSeq) {
        this.bbCgoSeq = bbCgoSeq;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthSeq
	 */
    public void setSpclCgoAuthSeq(String spclCgoAuthSeq) {
        this.spclCgoAuthSeq = spclCgoAuthSeq;
    }

    /**
	 * Column Info
	 * @param authUsrId
	 */
    public void setAuthUsrId(String authUsrId) {
        this.authUsrId = authUsrId;
    }

    /**
	 * Column Info
	 * @param aproRefNo
	 */
    public void setAproRefNo(String aproRefNo) {
        this.aproRefNo = aproRefNo;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
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
	 * @param rqstDay
	 */
    public void setRqstDay(String rqstDay) {
        this.rqstDay = rqstDay;
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
	 * @param bkgRcvTermCd
	 */
    public void setBkgRcvTermCd(String bkgRcvTermCd) {
        this.bkgRcvTermCd = bkgRcvTermCd;
    }

    /**
	 * Column Info
	 * @param vslSeq
	 */
    public void setVslSeq(String vslSeq) {
        this.vslSeq = vslSeq;
    }

    /**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
    public void setOvrVoidSltQty(String ovrVoidSltQty) {
        this.ovrVoidSltQty = ovrVoidSltQty;
    }

    /**
	 * Column Info
	 * @param vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param lstRqstDatFlg
	 */
    public void setLstRqstDatFlg(String lstRqstDatFlg) {
        this.lstRqstDatFlg = lstRqstDatFlg;
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
	 * @param dimLen
	 */
    public void setDimLen(String dimLen) {
        this.dimLen = dimLen;
    }

    /**
	 * Column Info
	 * @param spclCgoAproRqstSeq
	 */
    public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
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
	 * @param vslPrePstNm
	 */
    public void setVslPrePstNm(String vslPrePstNm) {
        this.vslPrePstNm = vslPrePstNm;
    }

    /**
	 * Column Info
	 * @param podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
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
	 * @param rqstAuthCd
	 */
    public void setRqstAuthCd(String rqstAuthCd) {
        this.rqstAuthCd = rqstAuthCd;
    }

    /**
	 * Column Info
	 * @param bookingNo
	 */
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthCd
	 */
    public void setSpclCgoAuthCd(String spclCgoAuthCd) {
        this.spclCgoAuthCd = spclCgoAuthCd;
    }

    /**
	 * Column Info
	 * @param emlSndNo
	 */
    public void setEmlSndNo(String emlSndNo) {
        this.emlSndNo = emlSndNo;
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
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param polYdCd
	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * Column Info
	 * @param rqstOfcCd
	 */
    public void setRqstOfcCd(String rqstOfcCd) {
        this.rqstOfcCd = rqstOfcCd;
    }

    /**
	 * Column Info
	 * @param bkgDeTermCd
	 */
    public void setBkgDeTermCd(String bkgDeTermCd) {
        this.bkgDeTermCd = bkgDeTermCd;
    }

    /**
	 * Column Info
	 * @param rqstGdt
	 */
    public void setRqstGdt(String rqstGdt) {
        this.rqstGdt = rqstGdt;
    }

    /**
	 * Column Info
	 * @param authGdt
	 */
    public void setAuthGdt(String authGdt) {
        this.authGdt = authGdt;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, "spcl_cgo_rqst_seq", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setNo(JSPUtil.getParameter(request, "no", ""));
        setScgFlg(JSPUtil.getParameter(request, "scg_flg", ""));
        setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
        setCrrCode(JSPUtil.getParameter(request, "crr_code", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setDimWdt(JSPUtil.getParameter(request, "dim_wdt", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, "pol_clpt_ind_seq", ""));
        setSpclCgoAuthNo(JSPUtil.getParameter(request, "spcl_cgo_auth_no", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, "rgn_shp_opr_cd", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, "auth_ofc_cd", ""));
        setAuthDt(JSPUtil.getParameter(request, "auth_dt", ""));
        setDimHgt(JSPUtil.getParameter(request, "dim_hgt", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, "spcl_cgo_cate_cd", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setSpclCgoAuthRjctCd(JSPUtil.getParameter(request, "spcl_cgo_auth_rjct_cd", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setSpclCgoAuthRmk(JSPUtil.getParameter(request, "spcl_cgo_auth_rmk", ""));
        setBbCgoQty(JSPUtil.getParameter(request, "bb_cgo_qty", ""));
        setBbCgoSeq(JSPUtil.getParameter(request, "bb_cgo_seq", ""));
        setSpclCgoAuthSeq(JSPUtil.getParameter(request, "spcl_cgo_auth_seq", ""));
        setAuthUsrId(JSPUtil.getParameter(request, "auth_usr_id", ""));
        setAproRefNo(JSPUtil.getParameter(request, "apro_ref_no", ""));
        setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
        setRqstDay(JSPUtil.getParameter(request, "rqst_day", ""));
        setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
        setBkgRcvTermCd(JSPUtil.getParameter(request, "bkg_rcv_term_cd", ""));
        setVslSeq(JSPUtil.getParameter(request, "vsl_seq", ""));
        setOvrVoidSltQty(JSPUtil.getParameter(request, "ovr_void_slt_qty", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
        setLstRqstDatFlg(JSPUtil.getParameter(request, "lst_rqst_dat_flg", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
        setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, "spcl_cgo_apro_rqst_seq", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
        setVslPrePstNm(JSPUtil.getParameter(request, "vsl_pre_pst_nm", ""));
        setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
        setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
        setRqstAuthCd(JSPUtil.getParameter(request, "rqst_auth_cd", ""));
        setBookingNo(JSPUtil.getParameter(request, "booking_no", ""));
        setSpclCgoAuthCd(JSPUtil.getParameter(request, "spcl_cgo_auth_cd", ""));
        setEmlSndNo(JSPUtil.getParameter(request, "eml_snd_no", ""));
        setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
        setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
        setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
        setBkgDeTermCd(JSPUtil.getParameter(request, "bkg_de_term_cd", ""));
        setRqstGdt(JSPUtil.getParameter(request, "rqst_gdt", ""));
        setAuthGdt(JSPUtil.getParameter(request, "auth_gdt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnBBListVO[]
	 */
    public SearchOwnBBListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnBBListVO[]
	 */
    public SearchOwnBBListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchOwnBBListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] no = (JSPUtil.getParameter(request, prefix + "no", length));
            String[] scgFlg = (JSPUtil.getParameter(request, prefix + "scg_flg", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] crrCode = (JSPUtil.getParameter(request, prefix + "crr_code", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] dimWdt = (JSPUtil.getParameter(request, prefix + "dim_wdt", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] spclCgoAuthNo = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_no", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] authDt = (JSPUtil.getParameter(request, prefix + "auth_dt", length));
            String[] dimHgt = (JSPUtil.getParameter(request, prefix + "dim_hgt", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", length));
            String[] bbCgoQty = (JSPUtil.getParameter(request, prefix + "bb_cgo_qty", length));
            String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix + "bb_cgo_seq", length));
            String[] spclCgoAuthSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", length));
            String[] authUsrId = (JSPUtil.getParameter(request, prefix + "auth_usr_id", length));
            String[] aproRefNo = (JSPUtil.getParameter(request, prefix + "apro_ref_no", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] rqstUsrId = (JSPUtil.getParameter(request, prefix + "rqst_usr_id", length));
            String[] rqstDay = (JSPUtil.getParameter(request, prefix + "rqst_day", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", length));
            String[] vslSeq = (JSPUtil.getParameter(request, prefix + "vsl_seq", length));
            String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] lstRqstDatFlg = (JSPUtil.getParameter(request, prefix + "lst_rqst_dat_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dimLen = (JSPUtil.getParameter(request, prefix + "dim_len", length));
            String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] vslPrePstNm = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_nm", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] rqstAuthCd = (JSPUtil.getParameter(request, prefix + "rqst_auth_cd", length));
            String[] bookingNo = (JSPUtil.getParameter(request, prefix + "booking_no", length));
            String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", length));
            String[] emlSndNo = (JSPUtil.getParameter(request, prefix + "eml_snd_no", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", length));
            String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", length));
            String[] rqstGdt = (JSPUtil.getParameter(request, prefix + "rqst_gdt", length));
            String[] authGdt = (JSPUtil.getParameter(request, prefix + "auth_gdt", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchOwnBBListVO();
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (no[i] != null)
                    model.setNo(no[i]);
                if (scgFlg[i] != null)
                    model.setScgFlg(scgFlg[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (crrCode[i] != null)
                    model.setCrrCode(crrCode[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (dimWdt[i] != null)
                    model.setDimWdt(dimWdt[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (spclCgoAuthNo[i] != null)
                    model.setSpclCgoAuthNo(spclCgoAuthNo[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (authDt[i] != null)
                    model.setAuthDt(authDt[i]);
                if (dimHgt[i] != null)
                    model.setDimHgt(dimHgt[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (spclCgoAuthRjctCd[i] != null)
                    model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (spclCgoAuthRmk[i] != null)
                    model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
                if (bbCgoQty[i] != null)
                    model.setBbCgoQty(bbCgoQty[i]);
                if (bbCgoSeq[i] != null)
                    model.setBbCgoSeq(bbCgoSeq[i]);
                if (spclCgoAuthSeq[i] != null)
                    model.setSpclCgoAuthSeq(spclCgoAuthSeq[i]);
                if (authUsrId[i] != null)
                    model.setAuthUsrId(authUsrId[i]);
                if (aproRefNo[i] != null)
                    model.setAproRefNo(aproRefNo[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (rqstUsrId[i] != null)
                    model.setRqstUsrId(rqstUsrId[i]);
                if (rqstDay[i] != null)
                    model.setRqstDay(rqstDay[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (bkgRcvTermCd[i] != null)
                    model.setBkgRcvTermCd(bkgRcvTermCd[i]);
                if (vslSeq[i] != null)
                    model.setVslSeq(vslSeq[i]);
                if (ovrVoidSltQty[i] != null)
                    model.setOvrVoidSltQty(ovrVoidSltQty[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (lstRqstDatFlg[i] != null)
                    model.setLstRqstDatFlg(lstRqstDatFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dimLen[i] != null)
                    model.setDimLen(dimLen[i]);
                if (spclCgoAproRqstSeq[i] != null)
                    model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (vslPrePstNm[i] != null)
                    model.setVslPrePstNm(vslPrePstNm[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (rqstAuthCd[i] != null)
                    model.setRqstAuthCd(rqstAuthCd[i]);
                if (bookingNo[i] != null)
                    model.setBookingNo(bookingNo[i]);
                if (spclCgoAuthCd[i] != null)
                    model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
                if (emlSndNo[i] != null)
                    model.setEmlSndNo(emlSndNo[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (rqstOfcCd[i] != null)
                    model.setRqstOfcCd(rqstOfcCd[i]);
                if (bkgDeTermCd[i] != null)
                    model.setBkgDeTermCd(bkgDeTermCd[i]);
                if (rqstGdt[i] != null)
                    model.setRqstGdt(rqstGdt[i]);
                if (authGdt[i] != null)
                    model.setAuthGdt(authGdt[i]);
                if (updDt[i] != null) 
		    		model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchOwnBBListVOs();
    }

    /** s
	 * VO 배열을 반환
	 * @return SearchOwnBBListVO[]
	 */
    public SearchOwnBBListVO[] getSearchOwnBBListVOs() {
        SearchOwnBBListVO[] vos = (SearchOwnBBListVO[]) models.toArray(new SearchOwnBBListVO[models.size()]);
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
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.no = this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgFlg = this.scgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCode = this.crrCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dimWdt = this.dimWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthNo = this.spclCgoAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authDt = this.authDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dimHgt = this.dimHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRmk = this.spclCgoAuthRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoQty = this.bbCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoSeq = this.bbCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthSeq = this.spclCgoAuthSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authUsrId = this.authUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrId = this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDay = this.rqstDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRcvTermCd = this.bkgRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSeq = this.vslSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrVoidSltQty = this.ovrVoidSltQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstRqstDatFlg = this.lstRqstDatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dimLen = this.dimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstNm = this.vslPrePstNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstAuthCd = this.rqstAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bookingNo = this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthCd = this.spclCgoAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndNo = this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgDeTermCd = this.bkgDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstGdt = this.rqstGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authGdt = this.authGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
