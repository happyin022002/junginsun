/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExternalRqstListVO.java
*@FileTitle : ExternalRqstListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.20 류대영 
* 1.0 Creation
* ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ExternalRqstListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ExternalRqstListVO> models = new ArrayList<ExternalRqstListVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String xterDelNm = null;

    /* Column Info */
    private String rowCount = null;

    /* Column Info */
    private String cntcEml = null;

    /* Column Info */
    private String rqstAcptDesc = null;

    /* Column Info */
    private String xterPodCd = null;

    /* Column Info */
    private String bkgUpldStsCd = null;

    /* Column Info */
    private String xterBkgRqstStsCd = null;

    /* Column Info */
    private String docTpCd = null;

    /* Column Info */
    private String hndlOfcCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String xterPorNm = null;

    /* Column Info */
    private String xterDelCd = null;

    /* Column Info */
    private String xterPolCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String xterPorCd = null;

    /* Column Info */
    private String xterRqstAcptUsrId = null;

    /* Column Info */
    private String shNm = null;

    /* Column Info */
    private String xterRqstViaCd = null;

    /* Column Info */
    private String upldDt = null;

    /* Column Info */
    private String xterSndrId = null;

    /* Column Info */
    private String upldUsrId = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String xterRqstAcptUsrNm = null;

    /* Column Info */
    private String snaccsSplitNo = null;

    /* Column Info */
    private String origin = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String rqstDepDt = null;

    /* Column Info */
    private String ffNm = null;

    /* Column Info */
    private String xterPolNm = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String upldUsrNm = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String poNo = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String xterPodNm = null;

    /* Column Info */
    private String xterRqstSeq = null;

    /* Column Info */
    private String xterRqstNo = null;

    /* Column Info */
    private String delivery = null;

    /* Column Info */
    private String rowNum = null;

    /* Column Info */
    private String cnNm = null;

    /* Column Info */
    private String xterRjctRsnNm = null;

    /* Column Info */
    private String custRefNo = null;

    /* Column Info */
    private String xterRqstRvisSeq = null;

    /* Column Info */
    private String blPrfShprFlg = null;

    /* Column Info */
    private String blNoCtnt = null;

    /* Column Info */
    private String preHndlOfccd = null;

    /* Column Info */
    private String cngHndlOfcUsrId = null;

    /* Column Info */
    private String cngHndlOfcUpdDt = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String bkgCntrTpSz = null;

    /* Column Info */
    private String rqstCntrTpSz = null;

    /* Column Info */
    private String xterRqstNo2 = null;

    /* Column Info */
    private String blIssTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ExternalRqstListVO() {
    }

    public ExternalRqstListVO(String ibflag, String pagerows, String docTpCd, String rqstDt, String xterRqstNo, String xterRqstSeq, String xterBkgRqstStsCd, String xterRqstViaCd, String bkgNo, String bkgUpldStsCd, String shNm, String cnNm, String ffNm, String hndlOfcCd, String origin, String delivery, String xterPorCd, String xterPorNm, String xterPolCd, String xterPolNm, String xterPodCd, String xterPodNm, String xterDelCd, String xterDelNm, String rqstDepDt, String vvd, String vslEngNm, String skdVoyNo, String poNo, String cntcEml, String ofcCd, String upldUsrId, String upldUsrNm, String upldDt, String xterSndrId, String vslCd, String bkgStsCd, String snaccsSplitNo, String rqstAcptDesc, String xterRqstAcptUsrId, String xterRqstAcptUsrNm, String rowNum, String rowCount, String xterRjctRsnNm, String custRefNo, String xterRqstRvisSeq, String blPrfShprFlg, String blNoCtnt, String preHndlOfccd, String cngHndlOfcUsrId, String cngHndlOfcUpdDt, String slanCd, String bkgCntrTpSz, String rqstCntrTpSz, String xterRqstNo2, String blIssTpCd) {
        this.vslCd = vslCd;
        this.bkgStsCd = bkgStsCd;
        this.xterDelNm = xterDelNm;
        this.rowCount = rowCount;
        this.cntcEml = cntcEml;
        this.rqstAcptDesc = rqstAcptDesc;
        this.xterPodCd = xterPodCd;
        this.bkgUpldStsCd = bkgUpldStsCd;
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
        this.docTpCd = docTpCd;
        this.hndlOfcCd = hndlOfcCd;
        this.pagerows = pagerows;
        this.xterPorNm = xterPorNm;
        this.xterDelCd = xterDelCd;
        this.xterPolCd = xterPolCd;
        this.ibflag = ibflag;
        this.vslEngNm = vslEngNm;
        this.xterPorCd = xterPorCd;
        this.xterRqstAcptUsrId = xterRqstAcptUsrId;
        this.shNm = shNm;
        this.xterRqstViaCd = xterRqstViaCd;
        this.upldDt = upldDt;
        this.xterSndrId = xterSndrId;
        this.upldUsrId = upldUsrId;
        this.rqstDt = rqstDt;
        this.xterRqstAcptUsrNm = xterRqstAcptUsrNm;
        this.snaccsSplitNo = snaccsSplitNo;
        this.origin = origin;
        this.skdVoyNo = skdVoyNo;
        this.rqstDepDt = rqstDepDt;
        this.ffNm = ffNm;
        this.xterPolNm = xterPolNm;
        this.vvd = vvd;
        this.upldUsrNm = upldUsrNm;
        this.ofcCd = ofcCd;
        this.poNo = poNo;
        this.bkgNo = bkgNo;
        this.xterPodNm = xterPodNm;
        this.xterRqstSeq = xterRqstSeq;
        this.xterRqstNo = xterRqstNo;
        this.delivery = delivery;
        this.rowNum = rowNum;
        this.cnNm = cnNm;
        this.xterRjctRsnNm = xterRjctRsnNm;
        this.custRefNo = custRefNo;
        this.xterRqstRvisSeq = xterRqstRvisSeq;
        this.blPrfShprFlg = blPrfShprFlg;
        this.blNoCtnt = blNoCtnt;
        this.preHndlOfccd = preHndlOfccd;
        this.cngHndlOfcUsrId = cngHndlOfcUsrId;
        this.cngHndlOfcUpdDt = cngHndlOfcUpdDt;
        this.slanCd = slanCd;
        this.bkgCntrTpSz = bkgCntrTpSz;
        this.rqstCntrTpSz = rqstCntrTpSz;
        this.xterRqstNo2 = xterRqstNo2;
        this.blIssTpCd = blIssTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("xter_del_nm", getXterDelNm());
        this.hashColumns.put("row_count", getRowCount());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("rqst_acpt_desc", getRqstAcptDesc());
        this.hashColumns.put("xter_pod_cd", getXterPodCd());
        this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
        this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("xter_por_nm", getXterPorNm());
        this.hashColumns.put("xter_del_cd", getXterDelCd());
        this.hashColumns.put("xter_pol_cd", getXterPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("xter_por_cd", getXterPorCd());
        this.hashColumns.put("xter_rqst_acpt_usr_id", getXterRqstAcptUsrId());
        this.hashColumns.put("sh_nm", getShNm());
        this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
        this.hashColumns.put("upld_dt", getUpldDt());
        this.hashColumns.put("xter_sndr_id", getXterSndrId());
        this.hashColumns.put("upld_usr_id", getUpldUsrId());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("xter_rqst_acpt_usr_nm", getXterRqstAcptUsrNm());
        this.hashColumns.put("snaccs_split_no", getSnaccsSplitNo());
        this.hashColumns.put("origin", getOrigin());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("rqst_dep_dt", getRqstDepDt());
        this.hashColumns.put("ff_nm", getFfNm());
        this.hashColumns.put("xter_pol_nm", getXterPolNm());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("upld_usr_nm", getUpldUsrNm());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("po_no", getPoNo());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("xter_pod_nm", getXterPodNm());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("delivery", getDelivery());
        this.hashColumns.put("row_num", getRowNum());
        this.hashColumns.put("cn_nm", getCnNm());
        this.hashColumns.put("xter_rjct_rsn_nm", getXterRjctRsnNm());
        this.hashColumns.put("cust_ref_no", getCustRefNo());
        this.hashColumns.put("xter_rqst_rvis_seq", getXterRqstRvisSeq());
        this.hashColumns.put("bl_prf_shpr_flg", getBlPrfShprFlg());
        this.hashColumns.put("bl_no_ctnt", getBlNoCtnt());
        this.hashColumns.put("pre_hndl_ofc_cd", getPreHndlOfccd());
        this.hashColumns.put("cng_hndl_ofc_usr_id", getCngHndlOfcUsrId());
        this.hashColumns.put("cng_hndl_ofc_upd_dt", getCngHndlOfcUpdDt());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("bkg_cntr_tp_sz", getBkgCntrTpSz());
        this.hashColumns.put("rqst_cntr_tp_sz", getRqstCntrTpSz());
        this.hashColumns.put("xter_rqst_no2", getXterRqstNo2());
        this.hashColumns.put("bl_iss_tp_cd", getBlIssTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("xter_del_nm", "xterDelNm");
        this.hashFields.put("row_count", "rowCount");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("rqst_acpt_desc", "rqstAcptDesc");
        this.hashFields.put("xter_pod_cd", "xterPodCd");
        this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
        this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("xter_por_nm", "xterPorNm");
        this.hashFields.put("xter_del_cd", "xterDelCd");
        this.hashFields.put("xter_pol_cd", "xterPolCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("xter_por_cd", "xterPorCd");
        this.hashFields.put("xter_rqst_acpt_usr_id", "xterRqstAcptUsrId");
        this.hashFields.put("sh_nm", "shNm");
        this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
        this.hashFields.put("upld_dt", "upldDt");
        this.hashFields.put("xter_sndr_id", "xterSndrId");
        this.hashFields.put("upld_usr_id", "upldUsrId");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("xter_rqst_acpt_usr_nm", "xterRqstAcptUsrNm");
        this.hashFields.put("snaccs_split_no", "snaccsSplitNo");
        this.hashFields.put("origin", "origin");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("rqst_dep_dt", "rqstDepDt");
        this.hashFields.put("ff_nm", "ffNm");
        this.hashFields.put("xter_pol_nm", "xterPolNm");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("upld_usr_nm", "upldUsrNm");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("xter_pod_nm", "xterPodNm");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("delivery", "delivery");
        this.hashFields.put("row_num", "rowNum");
        this.hashFields.put("cn_nm", "cnNm");
        this.hashFields.put("xter_rjct_rsn_nm", "xterRjctRsnNm");
        this.hashFields.put("cust_ref_no", "custRefNo");
        this.hashFields.put("xter_rqst_rvis_seq", "xterRqstRvisSeq");
        this.hashFields.put("bl_prf_shpr_flg", "blPrfShprFlg");
        this.hashFields.put("bl_no_ctnt", "blNoCtnt");
        this.hashFields.put("pre_hndl_ofc_cd", "preHndlOfccd");
        this.hashFields.put("cng_hndl_ofc_usr_id", "cngHndlOfcUsrId");
        this.hashFields.put("cng_hndl_ofc_upd_dt", "cngHndlOfcUpdDt");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("bkg_cntr_tp_sz", "bkgCntrTpSz");
        this.hashFields.put("rqst_cntr_tp_sz", "rqstCntrTpSz");
        this.hashFields.put("xter_rqst_no2", "xterRqstNo2");
        this.hashFields.put("bl_iss_tp_cd", "blIssTpCd");
        return this.hashFields;
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
	 * @return xterDelNm
	 */
    public String getXterDelNm() {
        return this.xterDelNm;
    }

    /**
	 * Column Info
	 * @return rowCount
	 */
    public String getRowCount() {
        return this.rowCount;
    }

    /**
	 * Column Info
	 * @return cntcEml
	 */
    public String getCntcEml() {
        return this.cntcEml;
    }

    /**
	 * Column Info
	 * @return rqstAcptDesc
	 */
    public String getRqstAcptDesc() {
        return this.rqstAcptDesc;
    }

    /**
	 * Column Info
	 * @return xterPodCd
	 */
    public String getXterPodCd() {
        return this.xterPodCd;
    }

    /**
	 * Column Info
	 * @return bkgUpldStsCd
	 */
    public String getBkgUpldStsCd() {
        return this.bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @return xterBkgRqstStsCd
	 */
    public String getXterBkgRqstStsCd() {
        return this.xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @return docTpCd
	 */
    public String getDocTpCd() {
        return this.docTpCd;
    }

    /**
	 * Column Info
	 * @return hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
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
	 * @return xterPorNm
	 */
    public String getXterPorNm() {
        return this.xterPorNm;
    }

    /**
	 * Column Info
	 * @return xterDelCd
	 */
    public String getXterDelCd() {
        return this.xterDelCd;
    }

    /**
	 * Column Info
	 * @return xterPolCd
	 */
    public String getXterPolCd() {
        return this.xterPolCd;
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
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @return xterPorCd
	 */
    public String getXterPorCd() {
        return this.xterPorCd;
    }

    /**
	 * Column Info
	 * @return xterRqstAcptUsrId
	 */
    public String getXterRqstAcptUsrId() {
        return this.xterRqstAcptUsrId;
    }

    /**
	 * Column Info
	 * @return shNm
	 */
    public String getShNm() {
        return this.shNm;
    }

    /**
	 * Column Info
	 * @return xterRqstViaCd
	 */
    public String getXterRqstViaCd() {
        return this.xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @return upldDt
	 */
    public String getUpldDt() {
        return this.upldDt;
    }

    /**
	 * Column Info
	 * @return xterSndrId
	 */
    public String getXterSndrId() {
        return this.xterSndrId;
    }

    /**
	 * Column Info
	 * @return upldUsrId
	 */
    public String getUpldUsrId() {
        return this.upldUsrId;
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
	 * @return xterRqstAcptUsrNm
	 */
    public String getXterRqstAcptUsrNm() {
        return this.xterRqstAcptUsrNm;
    }

    /**
	 * Column Info
	 * @return snaccsSplitNo
	 */
    public String getSnaccsSplitNo() {
        return this.snaccsSplitNo;
    }

    /**
	 * Column Info
	 * @return origin
	 */
    public String getOrigin() {
        return this.origin;
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
	 * @return rqstDepDt
	 */
    public String getRqstDepDt() {
        return this.rqstDepDt;
    }

    /**
	 * Column Info
	 * @return ffNm
	 */
    public String getFfNm() {
        return this.ffNm;
    }

    /**
	 * Column Info
	 * @return xterPolNm
	 */
    public String getXterPolNm() {
        return this.xterPolNm;
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
	 * @return upldUsrNm
	 */
    public String getUpldUsrNm() {
        return this.upldUsrNm;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
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
	 * @return xterPodNm
	 */
    public String getXterPodNm() {
        return this.xterPodNm;
    }

    /**
	 * Column Info
	 * @return xterRqstSeq
	 */
    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    /**
	 * Column Info
	 * @return xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    /**
	 * Column Info
	 * @return delivery
	 */
    public String getDelivery() {
        return this.delivery;
    }

    /**
	 * Column Info
	 * @return rowNum
	 */
    public String getRowNum() {
        return this.rowNum;
    }

    /**
	 * Column Info
	 * @return cnNm
	 */
    public String getCnNm() {
        return this.cnNm;
    }

    /**
	 * Column Info
	 * @return blNoCtnt
	 */
    public String getBlNoCtnt() {
        return this.blNoCtnt;
    }

    /**
	 * Column Info
	 * @return preHndlOfccd
	 */
    public String getPreHndlOfccd() {
        return this.preHndlOfccd;
    }

    /**
	 * Column Info
	 * @return cngHndlOfcUsrId
	 */
    public String getCngHndlOfcUsrId() {
        return this.cngHndlOfcUsrId;
    }

    /**
	 * Column Info
	 * @return cngHndlOfcUpdDt
	 */
    public String getCngHndlOfcUpdDt() {
        return this.cngHndlOfcUpdDt;
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
	 * @param xterDelNm
	 */
    public void setXterDelNm(String xterDelNm) {
        this.xterDelNm = xterDelNm;
    }

    /**
	 * Column Info
	 * @param rowCount
	 */
    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    /**
	 * Column Info
	 * @param cntcEml
	 */
    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    /**
	 * Column Info
	 * @param rqstAcptDesc
	 */
    public void setRqstAcptDesc(String rqstAcptDesc) {
        this.rqstAcptDesc = rqstAcptDesc;
    }

    /**
	 * Column Info
	 * @param xterPodCd
	 */
    public void setXterPodCd(String xterPodCd) {
        this.xterPodCd = xterPodCd;
    }

    /**
	 * Column Info
	 * @param bkgUpldStsCd
	 */
    public void setBkgUpldStsCd(String bkgUpldStsCd) {
        this.bkgUpldStsCd = bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @param xterBkgRqstStsCd
	 */
    public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @param docTpCd
	 */
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
    }

    /**
	 * Column Info
	 * @param hndlOfcCd
	 */
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
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
	 * @param xterPorNm
	 */
    public void setXterPorNm(String xterPorNm) {
        this.xterPorNm = xterPorNm;
    }

    /**
	 * Column Info
	 * @param xterDelCd
	 */
    public void setXterDelCd(String xterDelCd) {
        this.xterDelCd = xterDelCd;
    }

    /**
	 * Column Info
	 * @param xterPolCd
	 */
    public void setXterPolCd(String xterPolCd) {
        this.xterPolCd = xterPolCd;
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
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param xterPorCd
	 */
    public void setXterPorCd(String xterPorCd) {
        this.xterPorCd = xterPorCd;
    }

    /**
	 * Column Info
	 * @param xterRqstAcptUsrId
	 */
    public void setXterRqstAcptUsrId(String xterRqstAcptUsrId) {
        this.xterRqstAcptUsrId = xterRqstAcptUsrId;
    }

    /**
	 * Column Info
	 * @param shNm
	 */
    public void setShNm(String shNm) {
        this.shNm = shNm;
    }

    /**
	 * Column Info
	 * @param xterRqstViaCd
	 */
    public void setXterRqstViaCd(String xterRqstViaCd) {
        this.xterRqstViaCd = xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @param upldDt
	 */
    public void setUpldDt(String upldDt) {
        this.upldDt = upldDt;
    }

    /**
	 * Column Info
	 * @param xterSndrId
	 */
    public void setXterSndrId(String xterSndrId) {
        this.xterSndrId = xterSndrId;
    }

    /**
	 * Column Info
	 * @param upldUsrId
	 */
    public void setUpldUsrId(String upldUsrId) {
        this.upldUsrId = upldUsrId;
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
	 * @param xterRqstAcptUsrNm
	 */
    public void setXterRqstAcptUsrNm(String xterRqstAcptUsrNm) {
        this.xterRqstAcptUsrNm = xterRqstAcptUsrNm;
    }

    /**
	 * Column Info
	 * @param snaccsSplitNo
	 */
    public void setSnaccsSplitNo(String snaccsSplitNo) {
        this.snaccsSplitNo = snaccsSplitNo;
    }

    /**
	 * Column Info
	 * @param origin
	 */
    public void setOrigin(String origin) {
        this.origin = origin;
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
	 * @param rqstDepDt
	 */
    public void setRqstDepDt(String rqstDepDt) {
        this.rqstDepDt = rqstDepDt;
    }

    /**
	 * Column Info
	 * @param ffNm
	 */
    public void setFfNm(String ffNm) {
        this.ffNm = ffNm;
    }

    /**
	 * Column Info
	 * @param xterPolNm
	 */
    public void setXterPolNm(String xterPolNm) {
        this.xterPolNm = xterPolNm;
    }

    /**
	 * Column Info
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param upldUsrNm
	 */
    public void setUpldUsrNm(String upldUsrNm) {
        this.upldUsrNm = upldUsrNm;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
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
	 * @param xterPodNm
	 */
    public void setXterPodNm(String xterPodNm) {
        this.xterPodNm = xterPodNm;
    }

    /**
	 * Column Info
	 * @param xterRqstSeq
	 */
    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    /**
	 * Column Info
	 * @param xterRqstNo
	 */
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * Column Info
	 * @param delivery
	 */
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /**
	 * Column Info
	 * @param rowNum
	 */
    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    /**
	 * Column Info
	 * @param cnNm
	 */
    public void setCnNm(String cnNm) {
        this.cnNm = cnNm;
    }

    public String getXterRjctRsnNm() {
        return xterRjctRsnNm;
    }

    public void setXterRjctRsnNm(String xterRjctRsnNm) {
        this.xterRjctRsnNm = xterRjctRsnNm;
    }

    public String getCustRefNo() {
        return custRefNo;
    }

    public void setCustRefNo(String custRefNo) {
        this.custRefNo = custRefNo;
    }

    public String getXterRqstRvisSeq() {
        return xterRqstRvisSeq;
    }

    public void setXterRqstRvisSeq(String xterRqstRvisSeq) {
        this.xterRqstRvisSeq = xterRqstRvisSeq;
    }

    public void setBlPrfShprFlg(String blPrfShprFlg) {
        this.blPrfShprFlg = blPrfShprFlg;
    }

    public String getBlPrfShprFlg() {
        return this.blPrfShprFlg;
    }

    public void setBlNoCtnt(String blNoCtnt) {
        this.blNoCtnt = blNoCtnt;
    }

    public void setPreHndlOfccd(String preHndlOfccd) {
        this.preHndlOfccd = preHndlOfccd;
    }

    public void setCngHndlOfcUsrId(String cngHndlOfcUsrId) {
        this.cngHndlOfcUsrId = cngHndlOfcUsrId;
    }

    public void setCngHndlOfcUpdDt(String cngHndlOfcUpdDt) {
        this.cngHndlOfcUpdDt = cngHndlOfcUpdDt;
    }

    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    public String getSlanCd() {
        return this.slanCd;
    }

    public void setBkgCntrTpSz(String bkgCntrTpSz) {
        this.bkgCntrTpSz = bkgCntrTpSz;
    }

    public String getBkgCntrTpSz() {
        return this.bkgCntrTpSz;
    }

    public void setRqstCntrTpSz(String rqstCntrTpSz) {
        this.rqstCntrTpSz = rqstCntrTpSz;
    }

    public String getRqstCntrTpSz() {
        return this.rqstCntrTpSz;
    }

    public void setXterRqstNo2(String xterRqstNo2) {
        this.xterRqstNo2 = xterRqstNo2;
    }

    public String getXterRqstNo2() {
        return this.xterRqstNo2;
    }

    public void setBlIssTpCd(String blIssTpCd) {
        this.blIssTpCd = blIssTpCd;
    }

    public String getBlIssTpCd() {
        return this.blIssTpCd;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setXterDelNm(JSPUtil.getParameter(request, prefix + "xter_del_nm", ""));
        setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
        setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
        setRqstAcptDesc(JSPUtil.getParameter(request, prefix + "rqst_acpt_desc", ""));
        setXterPodCd(JSPUtil.getParameter(request, prefix + "xter_pod_cd", ""));
        setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
        setXterBkgRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setXterPorNm(JSPUtil.getParameter(request, prefix + "xter_por_nm", ""));
        setXterDelCd(JSPUtil.getParameter(request, prefix + "xter_del_cd", ""));
        setXterPolCd(JSPUtil.getParameter(request, prefix + "xter_pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setXterPorCd(JSPUtil.getParameter(request, prefix + "xter_por_cd", ""));
        setXterRqstAcptUsrId(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_id", ""));
        setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
        setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
        setUpldDt(JSPUtil.getParameter(request, prefix + "upld_dt", ""));
        setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
        setUpldUsrId(JSPUtil.getParameter(request, prefix + "upld_usr_id", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setXterRqstAcptUsrNm(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_nm", ""));
        setSnaccsSplitNo(JSPUtil.getParameter(request, prefix + "snaccs_split_no", ""));
        setOrigin(JSPUtil.getParameter(request, prefix + "origin", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setRqstDepDt(JSPUtil.getParameter(request, prefix + "rqst_dep_dt", ""));
        setFfNm(JSPUtil.getParameter(request, prefix + "ff_nm", ""));
        setXterPolNm(JSPUtil.getParameter(request, prefix + "xter_pol_nm", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setUpldUsrNm(JSPUtil.getParameter(request, prefix + "upld_usr_nm", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setXterPodNm(JSPUtil.getParameter(request, prefix + "xter_pod_nm", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setDelivery(JSPUtil.getParameter(request, prefix + "delivery", ""));
        setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
        setCnNm(JSPUtil.getParameter(request, prefix + "cn_nm", ""));
        setXterRjctRsnNm(JSPUtil.getParameter(request, prefix + "xter_rjct_rsn_nm", ""));
        setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
        setXterRqstRvisSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_rvis_seq", ""));
        setBlPrfShprFlg(JSPUtil.getParameter(request, prefix + "bl_prf_shpr_flg", ""));
        setBlNoCtnt(JSPUtil.getParameter(request, prefix + "bl_no_ctnt", ""));
        setPreHndlOfccd(JSPUtil.getParameter(request, prefix + "pre_hndl_ofc_cd", ""));
        setCngHndlOfcUsrId(JSPUtil.getParameter(request, prefix + "cng_hndl_ofc_usr_id", ""));
        setCngHndlOfcUpdDt(JSPUtil.getParameter(request, prefix + "cng_hndl_ofc_upd_dt", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setBkgCntrTpSz(JSPUtil.getParameter(request, prefix + "bkg_cntr_tp_sz", ""));
        setRqstCntrTpSz(JSPUtil.getParameter(request, prefix + "rqst_cntr_tp_sz", ""));
        setXterRqstNo2(JSPUtil.getParameter(request, prefix + "xter_rqst_no2", ""));
        setBlIssTpCd(JSPUtil.getParameter(request, prefix + "bl_iss_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExternalRqstListVO[]
	 */
    public ExternalRqstListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExternalRqstListVO[]
	 */
    public ExternalRqstListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ExternalRqstListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] xterDelNm = (JSPUtil.getParameter(request, prefix + "xter_del_nm", length));
            String[] rowCount = (JSPUtil.getParameter(request, prefix + "row_count", length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml", length));
            String[] rqstAcptDesc = (JSPUtil.getParameter(request, prefix + "rqst_acpt_desc", length));
            String[] xterPodCd = (JSPUtil.getParameter(request, prefix + "xter_pod_cd", length));
            String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", length));
            String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd", length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] xterPorNm = (JSPUtil.getParameter(request, prefix + "xter_por_nm", length));
            String[] xterDelCd = (JSPUtil.getParameter(request, prefix + "xter_del_cd", length));
            String[] xterPolCd = (JSPUtil.getParameter(request, prefix + "xter_pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] xterPorCd = (JSPUtil.getParameter(request, prefix + "xter_por_cd", length));
            String[] xterRqstAcptUsrId = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_id", length));
            String[] shNm = (JSPUtil.getParameter(request, prefix + "sh_nm", length));
            String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", length));
            String[] upldDt = (JSPUtil.getParameter(request, prefix + "upld_dt", length));
            String[] xterSndrId = (JSPUtil.getParameter(request, prefix + "xter_sndr_id", length));
            String[] upldUsrId = (JSPUtil.getParameter(request, prefix + "upld_usr_id", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] xterRqstAcptUsrNm = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_nm", length));
            String[] snaccsSplitNo = (JSPUtil.getParameter(request, prefix + "snaccs_split_no", length));
            String[] origin = (JSPUtil.getParameter(request, prefix + "origin", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] rqstDepDt = (JSPUtil.getParameter(request, prefix + "rqst_dep_dt", length));
            String[] ffNm = (JSPUtil.getParameter(request, prefix + "ff_nm", length));
            String[] xterPolNm = (JSPUtil.getParameter(request, prefix + "xter_pol_nm", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] upldUsrNm = (JSPUtil.getParameter(request, prefix + "upld_usr_nm", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] xterPodNm = (JSPUtil.getParameter(request, prefix + "xter_pod_nm", length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq", length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no", length));
            String[] delivery = (JSPUtil.getParameter(request, prefix + "delivery", length));
            String[] rowNum = (JSPUtil.getParameter(request, prefix + "row_num", length));
            String[] cnNm = (JSPUtil.getParameter(request, prefix + "cn_nm", length));
            String[] xterRjctRsnNm = (JSPUtil.getParameter(request, prefix + "xter_rjct_rsn_nm", length));
            String[] custRefNo = (JSPUtil.getParameter(request, prefix + "cust_ref_no", length));
            String[] xterRqstRvisSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_rvis_seq", length));
            String[] blPrfShprFlg = (JSPUtil.getParameter(request, prefix + "bl_prf_shpr_flg", length));
            String[] blNoCtnt = (JSPUtil.getParameter(request, prefix + "bl_no_ctnt", length));
            String[] preHndlOfccd = (JSPUtil.getParameter(request, prefix + "pre_hndl_ofc_cd", length));
            String[] cngHndlOfcUsrId = (JSPUtil.getParameter(request, prefix + "cng_hndl_ofc_usr_id", length));
            String[] cngHndlOfcUpdDt = (JSPUtil.getParameter(request, prefix + "cng_hndl_ofc_upd_dt", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] bkgCntrTpSz = (JSPUtil.getParameter(request, prefix + "bkg_cntr_tp_sz", length));
            String[] rqstCntrTpSz = (JSPUtil.getParameter(request, prefix + "rqst_cntr_tp_sz", length));
            String[] xterRqstNo2 = (JSPUtil.getParameter(request, prefix + "xter_rqst_no2", length));
            String[] blIssTpCd = (JSPUtil.getParameter(request, prefix + "bl_iss_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ExternalRqstListVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (xterDelNm[i] != null)
                    model.setXterDelNm(xterDelNm[i]);
                if (rowCount[i] != null)
                    model.setRowCount(rowCount[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (rqstAcptDesc[i] != null)
                    model.setRqstAcptDesc(rqstAcptDesc[i]);
                if (xterPodCd[i] != null)
                    model.setXterPodCd(xterPodCd[i]);
                if (bkgUpldStsCd[i] != null)
                    model.setBkgUpldStsCd(bkgUpldStsCd[i]);
                if (xterBkgRqstStsCd[i] != null)
                    model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (xterPorNm[i] != null)
                    model.setXterPorNm(xterPorNm[i]);
                if (xterDelCd[i] != null)
                    model.setXterDelCd(xterDelCd[i]);
                if (xterPolCd[i] != null)
                    model.setXterPolCd(xterPolCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (xterPorCd[i] != null)
                    model.setXterPorCd(xterPorCd[i]);
                if (xterRqstAcptUsrId[i] != null)
                    model.setXterRqstAcptUsrId(xterRqstAcptUsrId[i]);
                if (shNm[i] != null)
                    model.setShNm(shNm[i]);
                if (xterRqstViaCd[i] != null)
                    model.setXterRqstViaCd(xterRqstViaCd[i]);
                if (upldDt[i] != null)
                    model.setUpldDt(upldDt[i]);
                if (xterSndrId[i] != null)
                    model.setXterSndrId(xterSndrId[i]);
                if (upldUsrId[i] != null)
                    model.setUpldUsrId(upldUsrId[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (xterRqstAcptUsrNm[i] != null)
                    model.setXterRqstAcptUsrNm(xterRqstAcptUsrNm[i]);
                if (snaccsSplitNo[i] != null)
                    model.setSnaccsSplitNo(snaccsSplitNo[i]);
                if (origin[i] != null)
                    model.setOrigin(origin[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (rqstDepDt[i] != null)
                    model.setRqstDepDt(rqstDepDt[i]);
                if (ffNm[i] != null)
                    model.setFfNm(ffNm[i]);
                if (xterPolNm[i] != null)
                    model.setXterPolNm(xterPolNm[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (upldUsrNm[i] != null)
                    model.setUpldUsrNm(upldUsrNm[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (poNo[i] != null)
                    model.setPoNo(poNo[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (xterPodNm[i] != null)
                    model.setXterPodNm(xterPodNm[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (delivery[i] != null)
                    model.setDelivery(delivery[i]);
                if (rowNum[i] != null)
                    model.setRowNum(rowNum[i]);
                if (cnNm[i] != null)
                    model.setCnNm(cnNm[i]);
                if (xterRjctRsnNm[i] != null)
                    model.setXterRjctRsnNm(xterRjctRsnNm[i]);
                if (custRefNo[i] != null)
                    model.setCustRefNo(custRefNo[i]);
                if (xterRqstRvisSeq[i] != null)
                    model.setXterRqstRvisSeq(xterRqstRvisSeq[i]);
                if (blPrfShprFlg[i] != null)
                    model.setBlPrfShprFlg(blPrfShprFlg[i]);
                if (blNoCtnt[i] != null)
                    model.setBlNoCtnt(blNoCtnt[i]);
                if (preHndlOfccd[i] != null)
                    model.setPreHndlOfccd(preHndlOfccd[i]);
                if (cngHndlOfcUsrId[i] != null)
                    model.setCngHndlOfcUsrId(cngHndlOfcUsrId[i]);
                if (cngHndlOfcUpdDt[i] != null)
                    model.setCngHndlOfcUpdDt(cngHndlOfcUpdDt[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (bkgCntrTpSz[i] != null)
                    model.setBkgCntrTpSz(bkgCntrTpSz[i]);
                if (rqstCntrTpSz[i] != null)
                    model.setRqstCntrTpSz(rqstCntrTpSz[i]);
                if (xterRqstNo2[i] != null)
                    model.setXterRqstNo2(xterRqstNo2[i]);
                if (blIssTpCd[i] != null) 
		    		model.setBlIssTpCd(blIssTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getExternalRqstListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ExternalRqstListVO[]
	 */
    public ExternalRqstListVO[] getExternalRqstListVOs() {
        ExternalRqstListVO[] vos = (ExternalRqstListVO[]) models.toArray(new ExternalRqstListVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterDelNm = this.xterDelNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowCount = this.rowCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstAcptDesc = this.rqstAcptDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPodCd = this.xterPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsCd = this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstStsCd = this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPorNm = this.xterPorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterDelCd = this.xterDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPolCd = this.xterPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPorCd = this.xterPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptUsrId = this.xterRqstAcptUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shNm = this.shNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaCd = this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldDt = this.upldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSndrId = this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldUsrId = this.upldUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptUsrNm = this.xterRqstAcptUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.snaccsSplitNo = this.snaccsSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.origin = this.origin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDepDt = this.rqstDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffNm = this.ffNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPolNm = this.xterPolNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldUsrNm = this.upldUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPodNm = this.xterPodNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delivery = this.delivery.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowNum = this.rowNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnNm = this.cnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRjctRsnNm = this.xterRjctRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRefNo = this.custRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstRvisSeq = this.xterRqstRvisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blPrfShprFlg = this.blPrfShprFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoCtnt = this.blNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preHndlOfccd = this.preHndlOfccd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngHndlOfcUsrId = this.cngHndlOfcUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngHndlOfcUpdDt = this.cngHndlOfcUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntrTpSz = this.bkgCntrTpSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstCntrTpSz = this.rqstCntrTpSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo2 = this.xterRqstNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blIssTpCd = this.blIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
