/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgRequestListOptionVO.java
 *@FileTitle : ScgRequestListOptionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.18
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.18 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
public class ScgRequestListOptionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgRequestListOptionVO> models = new ArrayList<ScgRequestListOptionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String slanCd3 = null;

    /*	Column Info	*/
    private String slanCd4 = null;

    /*	Column Info	*/
    private String authFlg = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String slanCd5 = null;

    /*	Column Info	*/
    private String slanCd6 = null;

    /*	Column Info	*/
    private String valOprTpCd = null;

    /*	Column Info	*/
    private String slanCd1 = null;

    /*	Column Info	*/
    private String imdgUnNoSeq = null;

    /*	Column Info	*/
    private String slanCd2 = null;

    /*	Column Info	*/
    private String scgFlg = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String toEtaDt = null;

    /*	Column Info	*/
    private String fromEtaDt = null;

    /*	Column Info	*/
    private String spclCgoAproRqstSeq = null;

    /*	Column Info	*/
    private String shprNm = null;

    /*	Column Info	*/
    private String slanCd8 = null;

    /*	Column Info	*/
    private String slanCd7 = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String imdgUnNo = null;

    /*	Column Info	*/
    private String slanCd9 = null;

    /*	Column Info	*/
    private String rgnShpOprCd = null;

    /*	Column Info	*/
    private String bookingNo = null;

    /*	Column Info	*/
    private String slanCd11 = null;

    /*	Column Info	*/
    private String slanCd10 = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String emlSndNo = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String cgoOprCd = null;

    /*	Column Info	*/
    private String prpShpNm = null;

    /*	Column Info	*/
    private String dcgoRefNo = null;

    /*	Column Info	*/
    private String aproRefNo = null;

    /*	Column Info	*/
    private String imdgClssCd = null;

    /*	Column Info	*/
    private String vslPrePstCd = null;

    /*	Column Info	*/
    private String vslSeq = null;

    /*	Column Info	*/
    private String spclCgoAuthSeq = null;

    /*	Column Info	*/
    private String dgCancel = null;

    /*	Column Info	*/
    private String rqstFromDt = null;

    /*	Column Info	*/
    private String rqstToDt = null;

    private String scgAllFlg = null;

    /* Column Info */
    private String emlSndTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public ScgRequestListOptionVO() {
    }

    public ScgRequestListOptionVO(String ibflag, String pagerows, String slanCd3, String slanCd4, String authFlg, String vslCd, String slanCd5, String slanCd6, String valOprTpCd, String slanCd1, String imdgUnNoSeq, String slanCd2, String scgFlg, String polCd, String toEtaDt, String fromEtaDt, String spclCgoAproRqstSeq, String shprNm, String slanCd8, String slanCd7, String updUsrId, String imdgUnNo, String slanCd9, String rgnShpOprCd, String bookingNo, String slanCd11, String slanCd10, String skdVoyNo, String emlSndNo, String skdDirCd, String podCd, String bkgNo, String cgoOprCd, String prpShpNm, String dcgoRefNo, String aproRefNo, String imdgClssCd, String vslPrePstCd, String vslSeq, String spclCgoAuthSeq, String dgCancel, String rqstFromDt, String rqstToDt, String scgAllFlg, String emlSndTpCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.slanCd3 = slanCd3;
        this.slanCd4 = slanCd4;
        this.authFlg = authFlg;
        this.vslCd = vslCd;
        this.slanCd5 = slanCd5;
        this.slanCd6 = slanCd6;
        this.valOprTpCd = valOprTpCd;
        this.slanCd1 = slanCd1;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.slanCd2 = slanCd2;
        this.scgFlg = scgFlg;
        this.polCd = polCd;
        this.toEtaDt = toEtaDt;
        this.fromEtaDt = fromEtaDt;
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
        this.shprNm = shprNm;
        this.slanCd8 = slanCd8;
        this.slanCd7 = slanCd7;
        this.updUsrId = updUsrId;
        this.imdgUnNo = imdgUnNo;
        this.slanCd9 = slanCd9;
        this.rgnShpOprCd = rgnShpOprCd;
        this.bookingNo = bookingNo;
        this.slanCd11 = slanCd11;
        this.slanCd10 = slanCd10;
        this.skdVoyNo = skdVoyNo;
        this.emlSndNo = emlSndNo;
        this.skdDirCd = skdDirCd;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.cgoOprCd = cgoOprCd;
        this.prpShpNm = prpShpNm;
        this.dcgoRefNo = dcgoRefNo;
        this.aproRefNo = aproRefNo;
        this.imdgClssCd = imdgClssCd;
        this.vslPrePstCd = vslPrePstCd;
        this.vslSeq = vslSeq;
        this.spclCgoAuthSeq = spclCgoAuthSeq;
        this.dgCancel = dgCancel;
        this.rqstFromDt = rqstFromDt;
        this.rqstToDt = rqstToDt;
        this.scgAllFlg = scgAllFlg;
        this.emlSndTpCd = emlSndTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("slan_cd3", getSlanCd3());
        this.hashColumns.put("slan_cd4", getSlanCd4());
        this.hashColumns.put("auth_flg", getAuthFlg());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("slan_cd5", getSlanCd5());
        this.hashColumns.put("slan_cd6", getSlanCd6());
        this.hashColumns.put("val_opr_tp_cd", getValOprTpCd());
        this.hashColumns.put("slan_cd1", getSlanCd1());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("slan_cd2", getSlanCd2());
        this.hashColumns.put("scg_flg", getScgFlg());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("to_eta_dt", getToEtaDt());
        this.hashColumns.put("from_eta_dt", getFromEtaDt());
        this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
        this.hashColumns.put("shpr_nm", getShprNm());
        this.hashColumns.put("slan_cd8", getSlanCd8());
        this.hashColumns.put("slan_cd7", getSlanCd7());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("slan_cd9", getSlanCd9());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("booking_no", getBookingNo());
        this.hashColumns.put("slan_cd11", getSlanCd11());
        this.hashColumns.put("slan_cd10", getSlanCd10());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("eml_snd_no", getEmlSndNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("apro_ref_no", getAproRefNo());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("vsl_seq", getVslSeq());
        this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
        this.hashColumns.put("dg_cancel", getDgCancel());
        this.hashColumns.put("rqst_from_dt", getRqstFromDt());
        this.hashColumns.put("rqst_to_dt", getRqstToDt());
        this.hashColumns.put("scg_all_flg", getScgAllFlg());
        this.hashColumns.put("eml_snd_tp_cd", getEmlSndTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("slan_cd3", "slanCd3");
        this.hashFields.put("slan_cd4", "slanCd4");
        this.hashFields.put("auth_flg", "authFlg");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("slan_cd5", "slanCd5");
        this.hashFields.put("slan_cd6", "slanCd6");
        this.hashFields.put("val_opr_tp_cd", "valOprTpCd");
        this.hashFields.put("slan_cd1", "slanCd1");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("slan_cd2", "slanCd2");
        this.hashFields.put("scg_flg", "scgFlg");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("to_eta_dt", "toEtaDt");
        this.hashFields.put("from_eta_dt", "fromEtaDt");
        this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
        this.hashFields.put("shpr_nm", "shprNm");
        this.hashFields.put("slan_cd8", "slanCd8");
        this.hashFields.put("slan_cd7", "slanCd7");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("slan_cd9", "slanCd9");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("booking_no", "bookingNo");
        this.hashFields.put("slan_cd11", "slanCd11");
        this.hashFields.put("slan_cd10", "slanCd10");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("eml_snd_no", "emlSndNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("apro_ref_no", "aproRefNo");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("vsl_seq", "vslSeq");
        this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
        this.hashFields.put("dg_cancel", "dgCancel");
        this.hashFields.put("rqst_from_dt", "rqstFromDt");
        this.hashFields.put("rqst_to_dt", "rqstToDt");
        this.hashFields.put("scg_all_flg", "scgAllFlg");
        this.hashFields.put("eml_snd_tp_cd", "emlSndTpCd");
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
	 * @return slanCd3
	 */
    public String getSlanCd3() {
        return this.slanCd3;
    }

    /**
	 * Column Info
	 * @return slanCd4
	 */
    public String getSlanCd4() {
        return this.slanCd4;
    }

    /**
	 * Column Info
	 * @return authFlg
	 */
    public String getAuthFlg() {
        return this.authFlg;
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
	 * @return slanCd5
	 */
    public String getSlanCd5() {
        return this.slanCd5;
    }

    /**
	 * Column Info
	 * @return slanCd6
	 */
    public String getSlanCd6() {
        return this.slanCd6;
    }

    /**
	 * Column Info
	 * @return valOprTpCd
	 */
    public String getValOprTpCd() {
        return this.valOprTpCd;
    }

    /**
	 * Column Info
	 * @return slanCd1
	 */
    public String getSlanCd1() {
        return this.slanCd1;
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
	 * @return slanCd2
	 */
    public String getSlanCd2() {
        return this.slanCd2;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return toEtaDt
	 */
    public String getToEtaDt() {
        return this.toEtaDt;
    }

    /**
	 * Column Info
	 * @return fromEtaDt
	 */
    public String getFromEtaDt() {
        return this.fromEtaDt;
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
	 * @return shprNm
	 */
    public String getShprNm() {
        return this.shprNm;
    }

    /**
	 * Column Info
	 * @return slanCd8
	 */
    public String getSlanCd8() {
        return this.slanCd8;
    }

    /**
	 * Column Info
	 * @return slanCd7
	 */
    public String getSlanCd7() {
        return this.slanCd7;
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
	 * @return imdgUnNo
	 */
    public String getImdgUnNo() {
        return this.imdgUnNo;
    }

    /**
	 * Column Info
	 * @return slanCd9
	 */
    public String getSlanCd9() {
        return this.slanCd9;
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
	 * @return bookingNo
	 */
    public String getBookingNo() {
        return this.bookingNo;
    }

    /**
	 * Column Info
	 * @return slanCd11
	 */
    public String getSlanCd11() {
        return this.slanCd11;
    }

    /**
	 * Column Info
	 * @return slanCd10
	 */
    public String getSlanCd10() {
        return this.slanCd10;
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
	 * @return emlSndNo
	 */
    public String getEmlSndNo() {
        return this.emlSndNo;
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
	 * @return cgoOprCd
	 */
    public String getCgoOprCd() {
        return this.cgoOprCd;
    }

    /**
	 * Column Info
	 * @return prpShpNm
	 */
    public String getPrpShpNm() {
        return this.prpShpNm;
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
	 * @return aproRefNo
	 */
    public String getAproRefNo() {
        return this.aproRefNo;
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
	 * @return dgCancel
	 */
    public String getDgCancel() {
        return this.dgCancel;
    }

    /**
	 * Column Info
	 * @return rqstFromDt
	 */
    public String getRqstFromDt() {
        return this.rqstFromDt;
    }

    /**
	 * Column Info
	 * @return rqstToDt
	 */
    public String getRqstToDt() {
        return this.rqstToDt;
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
	 * @param  slanCd3
 	 */
    public void setSlanCd3(String slanCd3) {
        this.slanCd3 = slanCd3;
    }

    /**
	 * Column Info
	 * @param  slanCd4
 	 */
    public void setSlanCd4(String slanCd4) {
        this.slanCd4 = slanCd4;
    }

    /**
	 * Column Info
	 * @param  authFlg
 	 */
    public void setAuthFlg(String authFlg) {
        this.authFlg = authFlg;
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
	 * @param  slanCd5
 	 */
    public void setSlanCd5(String slanCd5) {
        this.slanCd5 = slanCd5;
    }

    /**
	 * Column Info
	 * @param  slanCd6
 	 */
    public void setSlanCd6(String slanCd6) {
        this.slanCd6 = slanCd6;
    }

    /**
	 * Column Info
	 * @param  valOprTpCd
 	 */
    public void setValOprTpCd(String valOprTpCd) {
        this.valOprTpCd = valOprTpCd;
    }

    /**
	 * Column Info
	 * @param  slanCd1
 	 */
    public void setSlanCd1(String slanCd1) {
        this.slanCd1 = slanCd1;
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
	 * @param  slanCd2
 	 */
    public void setSlanCd2(String slanCd2) {
        this.slanCd2 = slanCd2;
    }

    /**
	 * Column Info
	 * @param  scgFlg
 	 */
    public void setScgFlg(String scgFlg) {
        this.scgFlg = scgFlg;
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
	 * @param  toEtaDt
 	 */
    public void setToEtaDt(String toEtaDt) {
        this.toEtaDt = toEtaDt;
    }

    /**
	 * Column Info
	 * @param  fromEtaDt
 	 */
    public void setFromEtaDt(String fromEtaDt) {
        this.fromEtaDt = fromEtaDt;
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
	 * @param  shprNm
 	 */
    public void setShprNm(String shprNm) {
        this.shprNm = shprNm;
    }

    /**
	 * Column Info
	 * @param  slanCd8
 	 */
    public void setSlanCd8(String slanCd8) {
        this.slanCd8 = slanCd8;
    }

    /**
	 * Column Info
	 * @param  slanCd7
 	 */
    public void setSlanCd7(String slanCd7) {
        this.slanCd7 = slanCd7;
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
	 * @param  imdgUnNo
 	 */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
    }

    /**
	 * Column Info
	 * @param  slanCd9
 	 */
    public void setSlanCd9(String slanCd9) {
        this.slanCd9 = slanCd9;
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
	 * @param  bookingNo
 	 */
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    /**
	 * Column Info
	 * @param  slanCd11
 	 */
    public void setSlanCd11(String slanCd11) {
        this.slanCd11 = slanCd11;
    }

    /**
	 * Column Info
	 * @param  slanCd10
 	 */
    public void setSlanCd10(String slanCd10) {
        this.slanCd10 = slanCd10;
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
	 * @param  emlSndNo
 	 */
    public void setEmlSndNo(String emlSndNo) {
        this.emlSndNo = emlSndNo;
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
	 * @param  podCd
 	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
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
	 * @param  cgoOprCd
 	 */
    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
    }

    /**
	 * Column Info
	 * @param  prpShpNm
 	 */
    public void setPrpShpNm(String prpShpNm) {
        this.prpShpNm = prpShpNm;
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
	 * @param  aproRefNo
 	 */
    public void setAproRefNo(String aproRefNo) {
        this.aproRefNo = aproRefNo;
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
	 * @param  dgCancel
 	 */
    public void setDgCancel(String dgCancel) {
        this.dgCancel = dgCancel;
    }

    /**
	 * Column Info
	 * @param  rqstFromDt
 	 */
    public void setRqstFromDt(String rqstFromDt) {
        this.rqstFromDt = rqstFromDt;
    }

    /**
	 * Column Info
	 * @param  rqstToDt
 	 */
    public void setRqstToDt(String rqstToDt) {
        this.rqstToDt = rqstToDt;
    }

    public String getScgAllFlg() {
        return scgAllFlg;
    }

    public void setScgAllFlg(String scgAllFlg) {
        this.scgAllFlg = scgAllFlg;
    }

    public void setEmlSndTpCd(String emlSndTpCd) {
        this.emlSndTpCd = emlSndTpCd;
    }

    public String getEmlSndTpCd() {
        return this.emlSndTpCd;
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
        setSlanCd3(JSPUtil.getParameter(request, prefix + "slan_cd3", ""));
        setSlanCd4(JSPUtil.getParameter(request, prefix + "slan_cd4", ""));
        setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSlanCd5(JSPUtil.getParameter(request, prefix + "slan_cd5", ""));
        setSlanCd6(JSPUtil.getParameter(request, prefix + "slan_cd6", ""));
        setValOprTpCd(JSPUtil.getParameter(request, prefix + "val_opr_tp_cd", ""));
        setSlanCd1(JSPUtil.getParameter(request, prefix + "slan_cd1", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setSlanCd2(JSPUtil.getParameter(request, prefix + "slan_cd2", ""));
        setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
        setFromEtaDt(JSPUtil.getParameter(request, prefix + "from_eta_dt", ""));
        setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
        setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
        setSlanCd8(JSPUtil.getParameter(request, prefix + "slan_cd8", ""));
        setSlanCd7(JSPUtil.getParameter(request, prefix + "slan_cd7", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setSlanCd9(JSPUtil.getParameter(request, prefix + "slan_cd9", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
        setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
        setSlanCd11(JSPUtil.getParameter(request, prefix + "slan_cd11", ""));
        setSlanCd10(JSPUtil.getParameter(request, prefix + "slan_cd10", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
        setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
        setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
        setSpclCgoAuthSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", ""));
        setDgCancel(JSPUtil.getParameter(request, prefix + "dg_cancel", ""));
        setRqstFromDt(JSPUtil.getParameter(request, prefix + "rqst_from_dt", ""));
        setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
        setScgAllFlg(JSPUtil.getParameter(request, prefix + "scg_all_flg", ""));
        setEmlSndTpCd(JSPUtil.getParameter(request, prefix + "eml_snd_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgRequestListOptionVO[]
	 */
    public ScgRequestListOptionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgRequestListOptionVO[]
	 */
    public ScgRequestListOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgRequestListOptionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] slanCd3 = (JSPUtil.getParameter(request, prefix + "slan_cd3", length));
            String[] slanCd4 = (JSPUtil.getParameter(request, prefix + "slan_cd4", length));
            String[] authFlg = (JSPUtil.getParameter(request, prefix + "auth_flg", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] slanCd5 = (JSPUtil.getParameter(request, prefix + "slan_cd5", length));
            String[] slanCd6 = (JSPUtil.getParameter(request, prefix + "slan_cd6", length));
            String[] valOprTpCd = (JSPUtil.getParameter(request, prefix + "val_opr_tp_cd", length));
            String[] slanCd1 = (JSPUtil.getParameter(request, prefix + "slan_cd1", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] slanCd2 = (JSPUtil.getParameter(request, prefix + "slan_cd2", length));
            String[] scgFlg = (JSPUtil.getParameter(request, prefix + "scg_flg", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] toEtaDt = (JSPUtil.getParameter(request, prefix + "to_eta_dt", length));
            String[] fromEtaDt = (JSPUtil.getParameter(request, prefix + "from_eta_dt", length));
            String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", length));
            String[] shprNm = (JSPUtil.getParameter(request, prefix + "shpr_nm", length));
            String[] slanCd8 = (JSPUtil.getParameter(request, prefix + "slan_cd8", length));
            String[] slanCd7 = (JSPUtil.getParameter(request, prefix + "slan_cd7", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] slanCd9 = (JSPUtil.getParameter(request, prefix + "slan_cd9", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] bookingNo = (JSPUtil.getParameter(request, prefix + "booking_no", length));
            String[] slanCd11 = (JSPUtil.getParameter(request, prefix + "slan_cd11", length));
            String[] slanCd10 = (JSPUtil.getParameter(request, prefix + "slan_cd10", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] emlSndNo = (JSPUtil.getParameter(request, prefix + "eml_snd_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix + "dcgo_ref_no", length));
            String[] aproRefNo = (JSPUtil.getParameter(request, prefix + "apro_ref_no", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] vslSeq = (JSPUtil.getParameter(request, prefix + "vsl_seq", length));
            String[] spclCgoAuthSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", length));
            String[] dgCancel = (JSPUtil.getParameter(request, prefix + "dg_cancel", length));
            String[] rqstFromDt = (JSPUtil.getParameter(request, prefix + "rqst_from_dt", length));
            String[] rqstToDt = (JSPUtil.getParameter(request, prefix + "rqst_to_dt", length));
            String[] scgAllFlg = (JSPUtil.getParameter(request, prefix + "scg_all_flg", length));
            String[] emlSndTpCd = (JSPUtil.getParameter(request, prefix + "eml_snd_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgRequestListOptionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (slanCd3[i] != null)
                    model.setSlanCd3(slanCd3[i]);
                if (slanCd4[i] != null)
                    model.setSlanCd4(slanCd4[i]);
                if (authFlg[i] != null)
                    model.setAuthFlg(authFlg[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (slanCd5[i] != null)
                    model.setSlanCd5(slanCd5[i]);
                if (slanCd6[i] != null)
                    model.setSlanCd6(slanCd6[i]);
                if (valOprTpCd[i] != null)
                    model.setValOprTpCd(valOprTpCd[i]);
                if (slanCd1[i] != null)
                    model.setSlanCd1(slanCd1[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (slanCd2[i] != null)
                    model.setSlanCd2(slanCd2[i]);
                if (scgFlg[i] != null)
                    model.setScgFlg(scgFlg[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (toEtaDt[i] != null)
                    model.setToEtaDt(toEtaDt[i]);
                if (fromEtaDt[i] != null)
                    model.setFromEtaDt(fromEtaDt[i]);
                if (spclCgoAproRqstSeq[i] != null)
                    model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
                if (shprNm[i] != null)
                    model.setShprNm(shprNm[i]);
                if (slanCd8[i] != null)
                    model.setSlanCd8(slanCd8[i]);
                if (slanCd7[i] != null)
                    model.setSlanCd7(slanCd7[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (slanCd9[i] != null)
                    model.setSlanCd9(slanCd9[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (bookingNo[i] != null)
                    model.setBookingNo(bookingNo[i]);
                if (slanCd11[i] != null)
                    model.setSlanCd11(slanCd11[i]);
                if (slanCd10[i] != null)
                    model.setSlanCd10(slanCd10[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (emlSndNo[i] != null)
                    model.setEmlSndNo(emlSndNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (dcgoRefNo[i] != null)
                    model.setDcgoRefNo(dcgoRefNo[i]);
                if (aproRefNo[i] != null)
                    model.setAproRefNo(aproRefNo[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (vslSeq[i] != null)
                    model.setVslSeq(vslSeq[i]);
                if (spclCgoAuthSeq[i] != null)
                    model.setSpclCgoAuthSeq(spclCgoAuthSeq[i]);
                if (dgCancel[i] != null)
                    model.setDgCancel(dgCancel[i]);
                if (rqstFromDt[i] != null)
                    model.setRqstFromDt(rqstFromDt[i]);
                if (rqstToDt[i] != null)
                    model.setRqstToDt(rqstToDt[i]);
                if (scgAllFlg[i] != null)
                    model.setScgAllFlg(scgAllFlg[i]);
                if (emlSndTpCd[i] != null) 
		    		model.setEmlSndTpCd(emlSndTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgRequestListOptionVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ScgRequestListOptionVO[]
	 */
    public ScgRequestListOptionVO[] getScgRequestListOptionVOs() {
        ScgRequestListOptionVO[] vos = (ScgRequestListOptionVO[]) models.toArray(new ScgRequestListOptionVO[models.size()]);
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
        this.slanCd3 = this.slanCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd4 = this.slanCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authFlg = this.authFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd5 = this.slanCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd6 = this.slanCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.valOprTpCd = this.valOprTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd1 = this.slanCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd2 = this.slanCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgFlg = this.scgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toEtaDt = this.toEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromEtaDt = this.fromEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprNm = this.shprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd8 = this.slanCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd7 = this.slanCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd9 = this.slanCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bookingNo = this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd11 = this.slanCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd10 = this.slanCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndNo = this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRefNo = this.dcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSeq = this.vslSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthSeq = this.spclCgoAuthSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCancel = this.dgCancel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstFromDt = this.rqstFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstToDt = this.rqstToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgAllFlg = this.scgAllFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndTpCd = this.emlSndTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
