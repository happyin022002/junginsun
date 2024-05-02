/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendDgEdiRequestVO.java
 *@FileTitle : SendDgEdiRequestVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.02
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.02.02 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
public class SendDgEdiRequestVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SendDgEdiRequestVO> models = new ArrayList<SendDgEdiRequestVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String num = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String crrCd = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String vpsEtaDt = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String bookingNo = null;

    /*	Column Info	*/
    private String rqstDay = null;

    /*	Column Info	*/
    private String emlSndNo = null;

    /*	Column Info	*/
    private String seqno = null;

    /*	Column Info	*/
    private String spclCgoAuthCd = null;

    /*	Column Info	*/
    private String spclCgoAuthRjctCd = null;

    /*	Column Info	*/
    private String aproRefNo = null;

    /*	Column Info	*/
    private String dgCntrSeq = null;

    /*	Column Info	*/
    private String cntrCgoSeq = null;

    /*	Column Info	*/
    private String cntrTpszCd = null;

    /*	Column Info	*/
    private String dgTp = null;

    /*	Column Info	*/
    private String imdgUnNo = null;

    /*	Column Info	*/
    private String imdgUnNoSeq = null;

    /*	Column Info	*/
    private String imdgClssCd = null;

    /*	Column Info	*/
    private String imdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String mrnPolutFlg = null;

    /*	Column Info	*/
    private String imdgPckGrpCd = null;

    /*	Column Info	*/
    private String imdgLmtQtyFlg = null;

    /*	Column Info	*/
    private String imdgExptQtyFlg = null;

    /*	Column Info	*/
    private String flshPntCdoTemp = null;

    /*	Column Info	*/
    private String grsWgt = null;

    /*	Column Info	*/
    private String netWgt = null;

    /*	Column Info	*/
    private String psaNo = null;

    /*	Column Info	*/
    private String hcdgFlg = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String cntrNo = null;

    /*	Column Info	*/
    private String spclCgoAproRqstSeq = null;

    /*	Column Info	*/
    private String vslPrePstCd = null;

    /*	Column Info	*/
    private String vslSeq = null;

    /*	Column Info	*/
    private String spclCgoAuthSeq = null;

    /*	Column Info	*/
    private String dcgoSeq = null;

    /*	Column Info	*/
    private String spclCgoCateCd = null;

    /*	Column Info	*/
    private String spclCgoAuthRmk = null;

    /*	Column Info	*/
    private String netWgtSum = null;

    /*	Column Info	*/
    private String polYdCd = null;

    /*	Column Info	*/
    private String podYdCd = null;

    /*	Column Info	*/
    private String crrCode = null;

    /*	Column Info	*/
    private String spclCgoRqstSeq = null;

    /*	Column Info	*/
    private String rgnShpOprCd = null;

    /*	Column Info	*/
    private String ediStatus = null;

    /*	Column Info	*/
    private String fltFileRefNo = null;

    /*	Column Info	*/
    private String preSeq = null;

    /*	Column Info	*/
    private String ediMsgStsCd = null;

    /*	Column Info	*/
    private String ediDelStsCd = null;

    /*	Column Info	*/
    private String dcgoRefNo = null;

    /* Column Info */
    private String cgoOprCd = null;

    /* Column Info */
    private String ediRcvrId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public SendDgEdiRequestVO() {
    }

    public SendDgEdiRequestVO(String ibflag, String pagerows, String num, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String crrCd, String polCd, String vpsEtaDt, String podCd, String bookingNo, String rqstDay, String emlSndNo, String seqno, String spclCgoAuthCd, String spclCgoAuthRjctCd, String aproRefNo, String dgCntrSeq, String cntrCgoSeq, String cntrTpszCd, String dgTp, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String imdgSubsRskLblCd, String mrnPolutFlg, String imdgPckGrpCd, String imdgLmtQtyFlg, String imdgExptQtyFlg, String flshPntCdoTemp, String grsWgt, String netWgt, String psaNo, String hcdgFlg, String bkgNo, String cntrNo, String spclCgoAproRqstSeq, String vslPrePstCd, String vslSeq, String spclCgoAuthSeq, String dcgoSeq, String spclCgoCateCd, String spclCgoAuthRmk, String netWgtSum, String polYdCd, String podYdCd, String crrCode, String spclCgoRqstSeq, String rgnShpOprCd, String ediStatus, String fltFileRefNo, String preSeq, String ediMsgStsCd, String ediDelStsCd, String dcgoRefNo, String cgoOprCd, String ediRcvrId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.num = num;
        this.slanCd = slanCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.crrCd = crrCd;
        this.polCd = polCd;
        this.vpsEtaDt = vpsEtaDt;
        this.podCd = podCd;
        this.bookingNo = bookingNo;
        this.rqstDay = rqstDay;
        this.emlSndNo = emlSndNo;
        this.seqno = seqno;
        this.spclCgoAuthCd = spclCgoAuthCd;
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
        this.aproRefNo = aproRefNo;
        this.dgCntrSeq = dgCntrSeq;
        this.cntrCgoSeq = cntrCgoSeq;
        this.cntrTpszCd = cntrTpszCd;
        this.dgTp = dgTp;
        this.imdgUnNo = imdgUnNo;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.imdgClssCd = imdgClssCd;
        this.imdgSubsRskLblCd = imdgSubsRskLblCd;
        this.mrnPolutFlg = mrnPolutFlg;
        this.imdgPckGrpCd = imdgPckGrpCd;
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
        this.imdgExptQtyFlg = imdgExptQtyFlg;
        this.flshPntCdoTemp = flshPntCdoTemp;
        this.grsWgt = grsWgt;
        this.netWgt = netWgt;
        this.psaNo = psaNo;
        this.hcdgFlg = hcdgFlg;
        this.bkgNo = bkgNo;
        this.cntrNo = cntrNo;
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
        this.vslPrePstCd = vslPrePstCd;
        this.vslSeq = vslSeq;
        this.spclCgoAuthSeq = spclCgoAuthSeq;
        this.dcgoSeq = dcgoSeq;
        this.spclCgoCateCd = spclCgoCateCd;
        this.spclCgoAuthRmk = spclCgoAuthRmk;
        this.netWgtSum = netWgtSum;
        this.polYdCd = polYdCd;
        this.podYdCd = podYdCd;
        this.crrCode = crrCode;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.rgnShpOprCd = rgnShpOprCd;
        this.ediStatus = ediStatus;
        this.fltFileRefNo = fltFileRefNo;
        this.preSeq = preSeq;
        this.ediMsgStsCd = ediMsgStsCd;
        this.ediDelStsCd = ediDelStsCd;
        this.dcgoRefNo = dcgoRefNo;
        this.cgoOprCd = cgoOprCd;
        this.ediRcvrId = ediRcvrId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("num", getNum());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("booking_no", getBookingNo());
        this.hashColumns.put("rqst_day", getRqstDay());
        this.hashColumns.put("eml_snd_no", getEmlSndNo());
        this.hashColumns.put("seqNo", getSeqno());
        this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
        this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
        this.hashColumns.put("apro_ref_no", getAproRefNo());
        this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
        this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("dg_tp", getDgTp());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
        this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
        this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
        this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
        this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
        this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("psa_no", getPsaNo());
        this.hashColumns.put("hcdg_flg", getHcdgFlg());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("vsl_seq", getVslSeq());
        this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
        this.hashColumns.put("dcgo_seq", getDcgoSeq());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
        this.hashColumns.put("net_wgt_sum", getNetWgtSum());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("crr_code", getCrrCode());
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("edi_status", getEdiStatus());
        this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
        this.hashColumns.put("pre_seq", getPreSeq());
        this.hashColumns.put("edi_msg_sts_cd", getEdiMsgStsCd());
        this.hashColumns.put("edi_del_sts_cd", getEdiDelStsCd());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("edi_rcvr_id", getEdiRcvrId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("num", "num");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("booking_no", "bookingNo");
        this.hashFields.put("rqst_day", "rqstDay");
        this.hashFields.put("eml_snd_no", "emlSndNo");
        this.hashFields.put("seqNo", "seqno");
        this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
        this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
        this.hashFields.put("apro_ref_no", "aproRefNo");
        this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
        this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("dg_tp", "dgTp");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
        this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
        this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
        this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
        this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
        this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("psa_no", "psaNo");
        this.hashFields.put("hcdg_flg", "hcdgFlg");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("vsl_seq", "vslSeq");
        this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
        this.hashFields.put("dcgo_seq", "dcgoSeq");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
        this.hashFields.put("net_wgt_sum", "netWgtSum");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("crr_code", "crrCode");
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("edi_status", "ediStatus");
        this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
        this.hashFields.put("pre_seq", "preSeq");
        this.hashFields.put("edi_msg_sts_cd", "ediMsgStsCd");
        this.hashFields.put("edi_del_sts_cd", "ediDelStsCd");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("edi_rcvr_id", "ediRcvrId");
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
	 * @return num
	 */
    public String getNum() {
        return this.num;
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
	 * @return crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
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
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
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
	 * @return bookingNo
	 */
    public String getBookingNo() {
        return this.bookingNo;
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
	 * @return emlSndNo
	 */
    public String getEmlSndNo() {
        return this.emlSndNo;
    }

    /**
	 * Column Info
	 * @return seqno
	 */
    public String getSeqno() {
        return this.seqno;
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
	 * @return spclCgoAuthRjctCd
	 */
    public String getSpclCgoAuthRjctCd() {
        return this.spclCgoAuthRjctCd;
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
	 * @return dgCntrSeq
	 */
    public String getDgCntrSeq() {
        return this.dgCntrSeq;
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
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return dgTp
	 */
    public String getDgTp() {
        return this.dgTp;
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
	 * @return imdgUnNoSeq
	 */
    public String getImdgUnNoSeq() {
        return this.imdgUnNoSeq;
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
	 * @return imdgSubsRskLblCd
	 */
    public String getImdgSubsRskLblCd() {
        return this.imdgSubsRskLblCd;
    }

    /**
	 * Column Info
	 * @return mrnPolutFlg
	 */
    public String getMrnPolutFlg() {
        return this.mrnPolutFlg;
    }

    /**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
    public String getImdgPckGrpCd() {
        return this.imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
    public String getImdgLmtQtyFlg() {
        return this.imdgLmtQtyFlg;
    }

    /**
	 * Column Info
	 * @return imdgExptQtyFlg
	 */
    public String getImdgExptQtyFlg() {
        return this.imdgExptQtyFlg;
    }

    /**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
    public String getFlshPntCdoTemp() {
        return this.flshPntCdoTemp;
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
	 * @return netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 * Column Info
	 * @return psaNo
	 */
    public String getPsaNo() {
        return this.psaNo;
    }

    /**
	 * Column Info
	 * @return hcdgFlg
	 */
    public String getHcdgFlg() {
        return this.hcdgFlg;
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
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
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
	 * @return vslSeq
	 */
    public String getVslSeq() {
        return this.vslSeq;
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
	 * @return dcgoSeq
	 */
    public String getDcgoSeq() {
        return this.dcgoSeq;
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
	 * @return spclCgoAuthRmk
	 */
    public String getSpclCgoAuthRmk() {
        return this.spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @return netWgtSum
	 */
    public String getNetWgtSum() {
        return this.netWgtSum;
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
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
    }

    /**
	 * Column Info
	 * @return crrCode
	 */
    public String getCrrCode() {
        return this.crrCode;
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
	 * @return rgnShpOprCd
	 */
    public String getRgnShpOprCd() {
        return this.rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @return ediStatus
	 */
    public String getEdiStatus() {
        return this.ediStatus;
    }

    /**
	 * Column Info
	 * @return fltFileRefNo
	 */
    public String getFltFileRefNo() {
        return this.fltFileRefNo;
    }

    /**
	 * Column Info
	 * @return preSeq
	 */
    public String getPreSeq() {
        return this.preSeq;
    }

    /**
	 * Column Info
	 * @return ediMsgStsCd
	 */
    public String getEdiMsgStsCd() {
        return this.ediMsgStsCd;
    }

    /**
	 * Column Info
	 * @return ediDelStsCd
	 */
    public String getEdiDelStsCd() {
        return this.ediDelStsCd;
    }

    /**
	 * Column Info
	 * @return dcgoRefNo
	 */
    public String getDcgoRefNo() {
        return this.dcgoRefNo;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  dcgoRefNo
 	 */
    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
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
	 * @param  num
 	 */
    public void setNum(String num) {
        this.num = num;
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
	 * @param  crrCd
 	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
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
	 * @param  vpsEtaDt
 	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
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
	 * @param  bookingNo
 	 */
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    /**
	 * Column Info
	 * @param  rqstDay
 	 */
    public void setRqstDay(String rqstDay) {
        this.rqstDay = rqstDay;
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
	 * @param  seqno
 	 */
    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthCd
 	 */
    public void setSpclCgoAuthCd(String spclCgoAuthCd) {
        this.spclCgoAuthCd = spclCgoAuthCd;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthRjctCd
 	 */
    public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
    }

    /**
	 * Column Info
	 * @param  aproRefNo
 	 */
    public void setAproRefNo(String aproRefNo) {
        this.aproRefNo = aproRefNo;
    }

    /**
	 * Column Info
	 * @param  dgCntrSeq
 	 */
    public void setDgCntrSeq(String dgCntrSeq) {
        this.dgCntrSeq = dgCntrSeq;
    }

    /**
	 * Column Info
	 * @param  cntrCgoSeq
 	 */
    public void setCntrCgoSeq(String cntrCgoSeq) {
        this.cntrCgoSeq = cntrCgoSeq;
    }

    /**
	 * Column Info
	 * @param  cntrTpszCd
 	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param  dgTp
 	 */
    public void setDgTp(String dgTp) {
        this.dgTp = dgTp;
    }

    /**
	 * Column Info
	 * @param  imdgUnNo
 	 */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
    }

    /**
	 * Column Info
	 * @param  imdgUnNoSeq
 	 */
    public void setImdgUnNoSeq(String imdgUnNoSeq) {
        this.imdgUnNoSeq = imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @param  imdgClssCd
 	 */
    public void setImdgClssCd(String imdgClssCd) {
        this.imdgClssCd = imdgClssCd;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblCd
 	 */
    public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
        this.imdgSubsRskLblCd = imdgSubsRskLblCd;
    }

    /**
	 * Column Info
	 * @param  mrnPolutFlg
 	 */
    public void setMrnPolutFlg(String mrnPolutFlg) {
        this.mrnPolutFlg = mrnPolutFlg;
    }

    /**
	 * Column Info
	 * @param  imdgPckGrpCd
 	 */
    public void setImdgPckGrpCd(String imdgPckGrpCd) {
        this.imdgPckGrpCd = imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @param  imdgLmtQtyFlg
 	 */
    public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
    }

    /**
	 * Column Info
	 * @param  imdgExptQtyFlg
 	 */
    public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
        this.imdgExptQtyFlg = imdgExptQtyFlg;
    }

    /**
	 * Column Info
	 * @param  flshPntCdoTemp
 	 */
    public void setFlshPntCdoTemp(String flshPntCdoTemp) {
        this.flshPntCdoTemp = flshPntCdoTemp;
    }

    /**
	 * Column Info
	 * @param  grsWgt
 	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * Column Info
	 * @param  netWgt
 	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * Column Info
	 * @param  psaNo
 	 */
    public void setPsaNo(String psaNo) {
        this.psaNo = psaNo;
    }

    /**
	 * Column Info
	 * @param  hcdgFlg
 	 */
    public void setHcdgFlg(String hcdgFlg) {
        this.hcdgFlg = hcdgFlg;
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
	 * @param  cntrNo
 	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param  spclCgoAproRqstSeq
 	 */
    public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @param  vslPrePstCd
 	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
    }

    /**
	 * Column Info
	 * @param  vslSeq
 	 */
    public void setVslSeq(String vslSeq) {
        this.vslSeq = vslSeq;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthSeq
 	 */
    public void setSpclCgoAuthSeq(String spclCgoAuthSeq) {
        this.spclCgoAuthSeq = spclCgoAuthSeq;
    }

    /**
	 * Column Info
	 * @param  dcgoSeq
 	 */
    public void setDcgoSeq(String dcgoSeq) {
        this.dcgoSeq = dcgoSeq;
    }

    /**
	 * Column Info
	 * @param  spclCgoCateCd
 	 */
    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthRmk
 	 */
    public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
        this.spclCgoAuthRmk = spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @param  netWgtSum
 	 */
    public void setNetWgtSum(String netWgtSum) {
        this.netWgtSum = netWgtSum;
    }

    /**
	 * Column Info
	 * @param  polYdCd
 	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * Column Info
	 * @param  podYdCd
 	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
    }

    /**
	 * Column Info
	 * @param  crrCode
 	 */
    public void setCrrCode(String crrCode) {
        this.crrCode = crrCode;
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
	 * @param  rgnShpOprCd
 	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @param  ediStatus
 	 */
    public void setEdiStatus(String ediStatus) {
        this.ediStatus = ediStatus;
    }

    /**
	 * Column Info
	 * @param  fltFileRefNo
 	 */
    public void setFltFileRefNo(String fltFileRefNo) {
        this.fltFileRefNo = fltFileRefNo;
    }

    /**
	 * Column Info
	 * @param  preSeq
 	 */
    public void setPreSeq(String preSeq) {
        this.preSeq = preSeq;
    }

    /**
	 * Column Info
	 * @param  ediMsgStsCd
 	 */
    public void setEdiMsgStsCd(String ediMsgStsCd) {
        this.ediMsgStsCd = ediMsgStsCd;
    }

    /**
	 * Column Info
	 * @param  ediDelStsCd
 	 */
    public void setEdiDelStsCd(String ediDelStsCd) {
        this.ediDelStsCd = ediDelStsCd;
    }

    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
    }

    public String getCgoOprCd() {
        return this.cgoOprCd;
    }

    public void setEdiRcvrId(String ediRcvrId) {
        this.ediRcvrId = ediRcvrId;
    }

    public String getEdiRcvrId() {
        return this.ediRcvrId;
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
        setNum(JSPUtil.getParameter(request, prefix + "num", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
        setRqstDay(JSPUtil.getParameter(request, prefix + "rqst_day", ""));
        setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
        setSeqno(JSPUtil.getParameter(request, prefix + "seqNo", ""));
        setSpclCgoAuthCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", ""));
        setSpclCgoAuthRjctCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", ""));
        setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
        setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
        setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setDgTp(JSPUtil.getParameter(request, prefix + "dg_tp", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
        setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
        setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
        setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
        setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
        setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
        setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
        setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
        setSpclCgoAuthSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", ""));
        setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setSpclCgoAuthRmk(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", ""));
        setNetWgtSum(JSPUtil.getParameter(request, prefix + "net_wgt_sum", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setCrrCode(JSPUtil.getParameter(request, prefix + "crr_code", ""));
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
        setEdiStatus(JSPUtil.getParameter(request, prefix + "edi_status", ""));
        setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
        setPreSeq(JSPUtil.getParameter(request, prefix + "pre_seq", ""));
        setEdiMsgStsCd(JSPUtil.getParameter(request, prefix + "edi_msg_sts_cd", ""));
        setEdiDelStsCd(JSPUtil.getParameter(request, prefix + "edi_del_sts_cd", ""));
        setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setEdiRcvrId(JSPUtil.getParameter(request, prefix + "edi_rcvr_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendDgEdiRequestVO[]
	 */
    public SendDgEdiRequestVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendDgEdiRequestVO[]
	 */
    public SendDgEdiRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SendDgEdiRequestVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] num = (JSPUtil.getParameter(request, prefix + "num", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bookingNo = (JSPUtil.getParameter(request, prefix + "booking_no", length));
            String[] rqstDay = (JSPUtil.getParameter(request, prefix + "rqst_day", length));
            String[] emlSndNo = (JSPUtil.getParameter(request, prefix + "eml_snd_no", length));
            String[] seqno = (JSPUtil.getParameter(request, prefix + "seqNo", length));
            String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", length));
            String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", length));
            String[] aproRefNo = (JSPUtil.getParameter(request, prefix + "apro_ref_no", length));
            String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix + "dg_cntr_seq", length));
            String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] dgTp = (JSPUtil.getParameter(request, prefix + "dg_tp", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", length));
            String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix + "mrn_polut_flg", length));
            String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", length));
            String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", length));
            String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", length));
            String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] psaNo = (JSPUtil.getParameter(request, prefix + "psa_no", length));
            String[] hcdgFlg = (JSPUtil.getParameter(request, prefix + "hcdg_flg", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] vslSeq = (JSPUtil.getParameter(request, prefix + "vsl_seq", length));
            String[] spclCgoAuthSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", length));
            String[] dcgoSeq = (JSPUtil.getParameter(request, prefix + "dcgo_seq", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", length));
            String[] netWgtSum = (JSPUtil.getParameter(request, prefix + "net_wgt_sum", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] crrCode = (JSPUtil.getParameter(request, prefix + "crr_code", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] ediStatus = (JSPUtil.getParameter(request, prefix + "edi_status", length));
            String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix + "flt_file_ref_no", length));
            String[] preSeq = (JSPUtil.getParameter(request, prefix + "pre_seq", length));
            String[] ediMsgStsCd = (JSPUtil.getParameter(request, prefix + "edi_msg_sts_cd", length));
            String[] ediDelStsCd = (JSPUtil.getParameter(request, prefix + "edi_del_sts_cd", length));
            String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix + "dcgo_ref_no", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] ediRcvrId = (JSPUtil.getParameter(request, prefix + "edi_rcvr_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SendDgEdiRequestVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (num[i] != null)
                    model.setNum(num[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bookingNo[i] != null)
                    model.setBookingNo(bookingNo[i]);
                if (rqstDay[i] != null)
                    model.setRqstDay(rqstDay[i]);
                if (emlSndNo[i] != null)
                    model.setEmlSndNo(emlSndNo[i]);
                if (seqno[i] != null)
                    model.setSeqno(seqno[i]);
                if (spclCgoAuthCd[i] != null)
                    model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
                if (spclCgoAuthRjctCd[i] != null)
                    model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
                if (aproRefNo[i] != null)
                    model.setAproRefNo(aproRefNo[i]);
                if (dgCntrSeq[i] != null)
                    model.setDgCntrSeq(dgCntrSeq[i]);
                if (cntrCgoSeq[i] != null)
                    model.setCntrCgoSeq(cntrCgoSeq[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (dgTp[i] != null)
                    model.setDgTp(dgTp[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (imdgSubsRskLblCd[i] != null)
                    model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
                if (mrnPolutFlg[i] != null)
                    model.setMrnPolutFlg(mrnPolutFlg[i]);
                if (imdgPckGrpCd[i] != null)
                    model.setImdgPckGrpCd(imdgPckGrpCd[i]);
                if (imdgLmtQtyFlg[i] != null)
                    model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
                if (imdgExptQtyFlg[i] != null)
                    model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
                if (flshPntCdoTemp[i] != null)
                    model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (psaNo[i] != null)
                    model.setPsaNo(psaNo[i]);
                if (hcdgFlg[i] != null)
                    model.setHcdgFlg(hcdgFlg[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (spclCgoAproRqstSeq[i] != null)
                    model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (vslSeq[i] != null)
                    model.setVslSeq(vslSeq[i]);
                if (spclCgoAuthSeq[i] != null)
                    model.setSpclCgoAuthSeq(spclCgoAuthSeq[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (spclCgoAuthRmk[i] != null)
                    model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
                if (netWgtSum[i] != null)
                    model.setNetWgtSum(netWgtSum[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (crrCode[i] != null)
                    model.setCrrCode(crrCode[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (ediStatus[i] != null)
                    model.setEdiStatus(ediStatus[i]);
                if (fltFileRefNo[i] != null)
                    model.setFltFileRefNo(fltFileRefNo[i]);
                if (preSeq[i] != null)
                    model.setPreSeq(preSeq[i]);
                if (ediMsgStsCd[i] != null)
                    model.setEdiMsgStsCd(ediMsgStsCd[i]);
                if (ediDelStsCd[i] != null)
                    model.setEdiDelStsCd(ediDelStsCd[i]);
                if (dcgoRefNo[i] != null)
                    model.setDcgoRefNo(dcgoRefNo[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (ediRcvrId[i] != null) 
		    		model.setEdiRcvrId(ediRcvrId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSendDgEdiRequestVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return SendDgEdiRequestVO[]
	 */
    public SendDgEdiRequestVO[] getSendDgEdiRequestVOs() {
        SendDgEdiRequestVO[] vos = (SendDgEdiRequestVO[]) models.toArray(new SendDgEdiRequestVO[models.size()]);
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
        this.num = this.num.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bookingNo = this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDay = this.rqstDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndNo = this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seqno = this.seqno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthCd = this.spclCgoAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCntrSeq = this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoSeq = this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgTp = this.dgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd = this.imdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnPolutFlg = this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCd = this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyFlg = this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyFlg = this.imdgExptQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntCdoTemp = this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psaNo = this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgFlg = this.hcdgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSeq = this.vslSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthSeq = this.spclCgoAuthSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoSeq = this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRmk = this.spclCgoAuthRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgtSum = this.netWgtSum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCode = this.crrCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediStatus = this.ediStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fltFileRefNo = this.fltFileRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preSeq = this.preSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediMsgStsCd = this.ediMsgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediDelStsCd = this.ediDelStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediRcvrId = this.ediRcvrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
