/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsManifestDtlListVO.java
*@FileTitle : CndCstmsManifestDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.11.26 김민정 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CndCstmsManifestDtlListVO extends CstmsManifestVO {

    private static final long serialVersionUID = 1L;

    private Collection<CndCstmsManifestDtlListVO> models = new ArrayList<CndCstmsManifestDtlListVO>();

    /* Column Info */
    private String cstmsFileTpCd = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String trspModId = null;

    /* Column Info */
    private String cgoWgt = null;

    /* Column Info */
    private String blPckQty = null;

    /* Column Info */
    private String usaIbTrspNo = null;

    /* Column Info */
    private String railCrrRefNo = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String mbl2Count = null;

    /* Column Info */
    private String blTotCount = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String fullMtyCd = null;

    /* Column Info */
    private String custNm3 = null;

    /* Column Info */
    private String custNm2 = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String edi = null;

    /* Column Info */
    private String custSteCd1 = null;

    /* Column Info */
    private String mkDesc = null;

    /* Column Info */
    private String mfStsCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sentTime = null;

    /* Column Info */
    private String custCntCd3 = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String hblCount = null;

    /* Column Info */
    private String mh = null;

    /* Column Info */
    private String mbl3Count = null;

    /* Column Info */
    private String custCntCd1 = null;

    /* Column Info */
    private String custNm1 = null;

    /* Column Info */
    private String custCntCd2 = null;

    /* Column Info */
    private String custAddr1 = null;

    /* Column Info */
    private String sealNo = null;

    /* Column Info */
    private String custAddr3 = null;

    /* Column Info */
    private String custAddr2 = null;

    /* Column Info */
    private String blNo2 = null;

    /* Column Info */
    private String custCtyNm1 = null;

    /* Column Info */
    private String custCtyNm2 = null;

    /* Column Info */
    private String custCtyNm3 = null;

    /* Column Info */
    private String cgoDesc = null;

    /* Column Info */
    private String mbl1Count = null;

    /* Column Info */
    private String ibdLocGdsDesc = null;

    /* Column Info */
    private String custSteCd3 = null;

    /* Column Info */
    private String custSteCd2 = null;

    /* Column Info */
    private String custZipId3 = null;

    /* Column Info */
    private String custZipId2 = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String custZipId1 = null;

    /* Column Info */
    private String hubLocCd = null;

    /* Column Info */
    private String blCnt = null;

    /* Column Info */
    private String error = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CndCstmsManifestDtlListVO() {
    }

    public CndCstmsManifestDtlListVO(String ibflag, String pagerows, String blNo, String blNo2, String polCd, String podCd, String delCd, String hubLocCd, String cstmsFileTpCd, String trspModId, String blPckQty, String cgoWgt, String ibdLocGdsDesc, String mfStsCd, String custNm1, String custAddr1, String custCtyNm1, String custSteCd1, String custCntCd1, String custZipId1, String custNm2, String custAddr2, String custCtyNm2, String custSteCd2, String custCntCd2, String custZipId2, String custNm3, String custAddr3, String custCtyNm3, String custSteCd3, String custCntCd3, String custZipId3, String cntrNo, String railCrrRefNo, String usaIbTrspNo, String pckQty, String grsWgt, String mkDesc, String cgoDesc, String sealNo, String edi, String sentTime, String blCnt, String hblCount, String mbl1Count, String mbl2Count, String mbl3Count, String blTotCount, String mh, String fullMtyCd, String error) {
        this.cstmsFileTpCd = cstmsFileTpCd;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.trspModId = trspModId;
        this.cgoWgt = cgoWgt;
        this.blPckQty = blPckQty;
        this.usaIbTrspNo = usaIbTrspNo;
        this.railCrrRefNo = railCrrRefNo;
        this.delCd = delCd;
        this.mbl2Count = mbl2Count;
        this.blTotCount = blTotCount;
        this.podCd = podCd;
        this.fullMtyCd = fullMtyCd;
        this.custNm3 = custNm3;
        this.custNm2 = custNm2;
        this.grsWgt = grsWgt;
        this.edi = edi;
        this.custSteCd1 = custSteCd1;
        this.mkDesc = mkDesc;
        this.mfStsCd = mfStsCd;
        this.ibflag = ibflag;
        this.sentTime = sentTime;
        this.custCntCd3 = custCntCd3;
        this.pckQty = pckQty;
        this.hblCount = hblCount;
        this.mh = mh;
        this.mbl3Count = mbl3Count;
        this.custCntCd1 = custCntCd1;
        this.custNm1 = custNm1;
        this.custCntCd2 = custCntCd2;
        this.custAddr1 = custAddr1;
        this.sealNo = sealNo;
        this.custAddr3 = custAddr3;
        this.custAddr2 = custAddr2;
        this.blNo2 = blNo2;
        this.custCtyNm1 = custCtyNm1;
        this.custCtyNm2 = custCtyNm2;
        this.custCtyNm3 = custCtyNm3;
        this.cgoDesc = cgoDesc;
        this.mbl1Count = mbl1Count;
        this.ibdLocGdsDesc = ibdLocGdsDesc;
        this.custSteCd3 = custSteCd3;
        this.custSteCd2 = custSteCd2;
        this.custZipId3 = custZipId3;
        this.custZipId2 = custZipId2;
        this.cntrNo = cntrNo;
        this.custZipId1 = custZipId1;
        this.hubLocCd = hubLocCd;
        this.blCnt = blCnt;
        this.error = error;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("trsp_mod_id", getTrspModId());
        this.hashColumns.put("cgo_wgt", getCgoWgt());
        this.hashColumns.put("bl_pck_qty", getBlPckQty());
        this.hashColumns.put("usa_ib_trsp_no", getUsaIbTrspNo());
        this.hashColumns.put("rail_crr_ref_no", getRailCrrRefNo());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("mbl2_count", getMbl2Count());
        this.hashColumns.put("bl_tot_count", getBlTotCount());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("full_mty_cd", getFullMtyCd());
        this.hashColumns.put("cust_nm3", getCustNm3());
        this.hashColumns.put("cust_nm2", getCustNm2());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("edi", getEdi());
        this.hashColumns.put("cust_ste_cd1", getCustSteCd1());
        this.hashColumns.put("mk_desc", getMkDesc());
        this.hashColumns.put("mf_sts_cd", getMfStsCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("sent_time", getSentTime());
        this.hashColumns.put("cust_cnt_cd3", getCustCntCd3());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("hbl_count", getHblCount());
        this.hashColumns.put("mh", getMh());
        this.hashColumns.put("mbl3_count", getMbl3Count());
        this.hashColumns.put("cust_cnt_cd1", getCustCntCd1());
        this.hashColumns.put("cust_nm1", getCustNm1());
        this.hashColumns.put("cust_cnt_cd2", getCustCntCd2());
        this.hashColumns.put("cust_addr1", getCustAddr1());
        this.hashColumns.put("seal_no", getSealNo());
        this.hashColumns.put("cust_addr3", getCustAddr3());
        this.hashColumns.put("cust_addr2", getCustAddr2());
        this.hashColumns.put("bl_no2", getBlNo2());
        this.hashColumns.put("cust_cty_nm1", getCustCtyNm1());
        this.hashColumns.put("cust_cty_nm2", getCustCtyNm2());
        this.hashColumns.put("cust_cty_nm3", getCustCtyNm3());
        this.hashColumns.put("cgo_desc", getCgoDesc());
        this.hashColumns.put("mbl1_count", getMbl1Count());
        this.hashColumns.put("ibd_loc_gds_desc", getIbdLocGdsDesc());
        this.hashColumns.put("cust_ste_cd3", getCustSteCd3());
        this.hashColumns.put("cust_ste_cd2", getCustSteCd2());
        this.hashColumns.put("cust_zip_id3", getCustZipId3());
        this.hashColumns.put("cust_zip_id2", getCustZipId2());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cust_zip_id1", getCustZipId1());
        this.hashColumns.put("hub_loc_cd", getHubLocCd());
        this.hashColumns.put("bl_cnt", getBlCnt());
        this.hashColumns.put("error", getError());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("trsp_mod_id", "trspModId");
        this.hashFields.put("cgo_wgt", "cgoWgt");
        this.hashFields.put("bl_pck_qty", "blPckQty");
        this.hashFields.put("usa_ib_trsp_no", "usaIbTrspNo");
        this.hashFields.put("rail_crr_ref_no", "railCrrRefNo");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("mbl2_count", "mbl2Count");
        this.hashFields.put("bl_tot_count", "blTotCount");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("full_mty_cd", "fullMtyCd");
        this.hashFields.put("cust_nm3", "custNm3");
        this.hashFields.put("cust_nm2", "custNm2");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("edi", "edi");
        this.hashFields.put("cust_ste_cd1", "custSteCd1");
        this.hashFields.put("mk_desc", "mkDesc");
        this.hashFields.put("mf_sts_cd", "mfStsCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("sent_time", "sentTime");
        this.hashFields.put("cust_cnt_cd3", "custCntCd3");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("hbl_count", "hblCount");
        this.hashFields.put("mh", "mh");
        this.hashFields.put("mbl3_count", "mbl3Count");
        this.hashFields.put("cust_cnt_cd1", "custCntCd1");
        this.hashFields.put("cust_nm1", "custNm1");
        this.hashFields.put("cust_cnt_cd2", "custCntCd2");
        this.hashFields.put("cust_addr1", "custAddr1");
        this.hashFields.put("seal_no", "sealNo");
        this.hashFields.put("cust_addr3", "custAddr3");
        this.hashFields.put("cust_addr2", "custAddr2");
        this.hashFields.put("bl_no2", "blNo2");
        this.hashFields.put("cust_cty_nm1", "custCtyNm1");
        this.hashFields.put("cust_cty_nm2", "custCtyNm2");
        this.hashFields.put("cust_cty_nm3", "custCtyNm3");
        this.hashFields.put("cgo_desc", "cgoDesc");
        this.hashFields.put("mbl1_count", "mbl1Count");
        this.hashFields.put("ibd_loc_gds_desc", "ibdLocGdsDesc");
        this.hashFields.put("cust_ste_cd3", "custSteCd3");
        this.hashFields.put("cust_ste_cd2", "custSteCd2");
        this.hashFields.put("cust_zip_id3", "custZipId3");
        this.hashFields.put("cust_zip_id2", "custZipId2");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cust_zip_id1", "custZipId1");
        this.hashFields.put("hub_loc_cd", "hubLocCd");
        this.hashFields.put("bl_cnt", "blCnt");
        this.hashFields.put("error", "error");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return cstmsFileTpCd
	 */
    public String getCstmsFileTpCd() {
        return this.cstmsFileTpCd;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return trspModId
	 */
    public String getTrspModId() {
        return this.trspModId;
    }

    /**
	 * Column Info
	 * @return cgoWgt
	 */
    public String getCgoWgt() {
        return this.cgoWgt;
    }

    /**
	 * Column Info
	 * @return blPckQty
	 */
    public String getBlPckQty() {
        return this.blPckQty;
    }

    /**
	 * Column Info
	 * @return usaIbTrspNo
	 */
    public String getUsaIbTrspNo() {
        return this.usaIbTrspNo;
    }

    /**
	 * Column Info
	 * @return railCrrRefNo
	 */
    public String getRailCrrRefNo() {
        return this.railCrrRefNo;
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
	 * @return mbl2Count
	 */
    public String getMbl2Count() {
        return this.mbl2Count;
    }

    /**
	 * Column Info
	 * @return blTotCount
	 */
    public String getBlTotCount() {
        return this.blTotCount;
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
	 * @return fullMtyCd
	 */
    public String getFullMtyCd() {
        return this.fullMtyCd;
    }

    /**
	 * Column Info
	 * @return custNm3
	 */
    public String getCustNm3() {
        return this.custNm3;
    }

    /**
	 * Column Info
	 * @return custNm2
	 */
    public String getCustNm2() {
        return this.custNm2;
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
	 * @return edi
	 */
    public String getEdi() {
        return this.edi;
    }

    /**
	 * Column Info
	 * @return custSteCd1
	 */
    public String getCustSteCd1() {
        return this.custSteCd1;
    }

    /**
	 * Column Info
	 * @return mkDesc
	 */
    public String getMkDesc() {
        return this.mkDesc;
    }

    /**
	 * Column Info
	 * @return mfStsCd
	 */
    public String getMfStsCd() {
        return this.mfStsCd;
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
	 * @return sentTime
	 */
    public String getSentTime() {
        return this.sentTime;
    }

    /**
	 * Column Info
	 * @return custCntCd3
	 */
    public String getCustCntCd3() {
        return this.custCntCd3;
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
	 * @return hblCount
	 */
    public String getHblCount() {
        return this.hblCount;
    }

    /**
	 * Column Info
	 * @return mh
	 */
    public String getMh() {
        return this.mh;
    }

    /**
	 * Column Info
	 * @return mbl3Count
	 */
    public String getMbl3Count() {
        return this.mbl3Count;
    }

    /**
	 * Column Info
	 * @return custCntCd1
	 */
    public String getCustCntCd1() {
        return this.custCntCd1;
    }

    /**
	 * Column Info
	 * @return custNm1
	 */
    public String getCustNm1() {
        return this.custNm1;
    }

    /**
	 * Column Info
	 * @return custCntCd2
	 */
    public String getCustCntCd2() {
        return this.custCntCd2;
    }

    /**
	 * Column Info
	 * @return custAddr1
	 */
    public String getCustAddr1() {
        return this.custAddr1;
    }

    /**
	 * Column Info
	 * @return sealNo
	 */
    public String getSealNo() {
        return this.sealNo;
    }

    /**
	 * Column Info
	 * @return custAddr3
	 */
    public String getCustAddr3() {
        return this.custAddr3;
    }

    /**
	 * Column Info
	 * @return custAddr2
	 */
    public String getCustAddr2() {
        return this.custAddr2;
    }

    /**
	 * Column Info
	 * @return blNo2
	 */
    public String getBlNo2() {
        return this.blNo2;
    }

    /**
	 * Column Info
	 * @return custCtyNm1
	 */
    public String getCustCtyNm1() {
        return this.custCtyNm1;
    }

    /**
	 * Column Info
	 * @return custCtyNm2
	 */
    public String getCustCtyNm2() {
        return this.custCtyNm2;
    }

    /**
	 * Column Info
	 * @return custCtyNm3
	 */
    public String getCustCtyNm3() {
        return this.custCtyNm3;
    }

    /**
	 * Column Info
	 * @return cgoDesc
	 */
    public String getCgoDesc() {
        return this.cgoDesc;
    }

    /**
	 * Column Info
	 * @return mbl1Count
	 */
    public String getMbl1Count() {
        return this.mbl1Count;
    }

    /**
	 * Column Info
	 * @return ibdLocGdsDesc
	 */
    public String getIbdLocGdsDesc() {
        return this.ibdLocGdsDesc;
    }

    /**
	 * Column Info
	 * @return custSteCd3
	 */
    public String getCustSteCd3() {
        return this.custSteCd3;
    }

    /**
	 * Column Info
	 * @return custSteCd2
	 */
    public String getCustSteCd2() {
        return this.custSteCd2;
    }

    /**
	 * Column Info
	 * @return custZipId3
	 */
    public String getCustZipId3() {
        return this.custZipId3;
    }

    /**
	 * Column Info
	 * @return custZipId2
	 */
    public String getCustZipId2() {
        return this.custZipId2;
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
	 * @return custZipId1
	 */
    public String getCustZipId1() {
        return this.custZipId1;
    }

    /**
	 * Column Info
	 * @return hubLocCd
	 */
    public String getHubLocCd() {
        return this.hubLocCd;
    }

    /**
	 * Column Info
	 * @return blCnt
	 */
    public String getBlCnt() {
        return this.blCnt;
    }

    /**
	 * Column Info
	 * @param cstmsFileTpCd
	 */
    public void setCstmsFileTpCd(String cstmsFileTpCd) {
        this.cstmsFileTpCd = cstmsFileTpCd;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param trspModId
	 */
    public void setTrspModId(String trspModId) {
        this.trspModId = trspModId;
    }

    /**
	 * Column Info
	 * @param cgoWgt
	 */
    public void setCgoWgt(String cgoWgt) {
        this.cgoWgt = cgoWgt;
    }

    /**
	 * Column Info
	 * @param blPckQty
	 */
    public void setBlPckQty(String blPckQty) {
        this.blPckQty = blPckQty;
    }

    /**
	 * Column Info
	 * @param usaIbTrspNo
	 */
    public void setUsaIbTrspNo(String usaIbTrspNo) {
        this.usaIbTrspNo = usaIbTrspNo;
    }

    /**
	 * Column Info
	 * @param railCrrRefNo
	 */
    public void setRailCrrRefNo(String railCrrRefNo) {
        this.railCrrRefNo = railCrrRefNo;
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
	 * @param mbl2Count
	 */
    public void setMbl2Count(String mbl2Count) {
        this.mbl2Count = mbl2Count;
    }

    /**
	 * Column Info
	 * @param blTotCount
	 */
    public void setBlTotCount(String blTotCount) {
        this.blTotCount = blTotCount;
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
	 * @param fullMtyCd
	 */
    public void setFullMtyCd(String fullMtyCd) {
        this.fullMtyCd = fullMtyCd;
    }

    /**
	 * Column Info
	 * @param custNm3
	 */
    public void setCustNm3(String custNm3) {
        this.custNm3 = custNm3;
    }

    /**
	 * Column Info
	 * @param custNm2
	 */
    public void setCustNm2(String custNm2) {
        this.custNm2 = custNm2;
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
	 * @param edi
	 */
    public void setEdi(String edi) {
        this.edi = edi;
    }

    /**
	 * Column Info
	 * @param custSteCd1
	 */
    public void setCustSteCd1(String custSteCd1) {
        this.custSteCd1 = custSteCd1;
    }

    /**
	 * Column Info
	 * @param mkDesc
	 */
    public void setMkDesc(String mkDesc) {
        this.mkDesc = mkDesc;
    }

    /**
	 * Column Info
	 * @param mfStsCd
	 */
    public void setMfStsCd(String mfStsCd) {
        this.mfStsCd = mfStsCd;
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
	 * @param sentTime
	 */
    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    /**
	 * Column Info
	 * @param custCntCd3
	 */
    public void setCustCntCd3(String custCntCd3) {
        this.custCntCd3 = custCntCd3;
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
	 * @param hblCount
	 */
    public void setHblCount(String hblCount) {
        this.hblCount = hblCount;
    }

    /**
	 * Column Info
	 * @param mh
	 */
    public void setMh(String mh) {
        this.mh = mh;
    }

    /**
	 * Column Info
	 * @param mbl3Count
	 */
    public void setMbl3Count(String mbl3Count) {
        this.mbl3Count = mbl3Count;
    }

    /**
	 * Column Info
	 * @param custCntCd1
	 */
    public void setCustCntCd1(String custCntCd1) {
        this.custCntCd1 = custCntCd1;
    }

    /**
	 * Column Info
	 * @param custNm1
	 */
    public void setCustNm1(String custNm1) {
        this.custNm1 = custNm1;
    }

    /**
	 * Column Info
	 * @param custCntCd2
	 */
    public void setCustCntCd2(String custCntCd2) {
        this.custCntCd2 = custCntCd2;
    }

    /**
	 * Column Info
	 * @param custAddr1
	 */
    public void setCustAddr1(String custAddr1) {
        this.custAddr1 = custAddr1;
    }

    /**
	 * Column Info
	 * @param sealNo
	 */
    public void setSealNo(String sealNo) {
        this.sealNo = sealNo;
    }

    /**
	 * Column Info
	 * @param custAddr3
	 */
    public void setCustAddr3(String custAddr3) {
        this.custAddr3 = custAddr3;
    }

    /**
	 * Column Info
	 * @param custAddr2
	 */
    public void setCustAddr2(String custAddr2) {
        this.custAddr2 = custAddr2;
    }

    /**
	 * Column Info
	 * @param blNo2
	 */
    public void setBlNo2(String blNo2) {
        this.blNo2 = blNo2;
    }

    /**
	 * Column Info
	 * @param custCtyNm1
	 */
    public void setCustCtyNm1(String custCtyNm1) {
        this.custCtyNm1 = custCtyNm1;
    }

    /**
	 * Column Info
	 * @param custCtyNm2
	 */
    public void setCustCtyNm2(String custCtyNm2) {
        this.custCtyNm2 = custCtyNm2;
    }

    /**
	 * Column Info
	 * @param custCtyNm3
	 */
    public void setCustCtyNm3(String custCtyNm3) {
        this.custCtyNm3 = custCtyNm3;
    }

    /**
	 * Column Info
	 * @param cgoDesc
	 */
    public void setCgoDesc(String cgoDesc) {
        this.cgoDesc = cgoDesc;
    }

    /**
	 * Column Info
	 * @param mbl1Count
	 */
    public void setMbl1Count(String mbl1Count) {
        this.mbl1Count = mbl1Count;
    }

    /**
	 * Column Info
	 * @param ibdLocGdsDesc
	 */
    public void setIbdLocGdsDesc(String ibdLocGdsDesc) {
        this.ibdLocGdsDesc = ibdLocGdsDesc;
    }

    /**
	 * Column Info
	 * @param custSteCd3
	 */
    public void setCustSteCd3(String custSteCd3) {
        this.custSteCd3 = custSteCd3;
    }

    /**
	 * Column Info
	 * @param custSteCd2
	 */
    public void setCustSteCd2(String custSteCd2) {
        this.custSteCd2 = custSteCd2;
    }

    /**
	 * Column Info
	 * @param custZipId3
	 */
    public void setCustZipId3(String custZipId3) {
        this.custZipId3 = custZipId3;
    }

    /**
	 * Column Info
	 * @param custZipId2
	 */
    public void setCustZipId2(String custZipId2) {
        this.custZipId2 = custZipId2;
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
	 * @param custZipId1
	 */
    public void setCustZipId1(String custZipId1) {
        this.custZipId1 = custZipId1;
    }

    /**
	 * Column Info
	 * @param hubLocCd
	 */
    public void setHubLocCd(String hubLocCd) {
        this.hubLocCd = hubLocCd;
    }

    /**
	 * Column Info
	 * @param blCnt
	 */
    public void setBlCnt(String blCnt) {
        this.blCnt = blCnt;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCstmsFileTpCd(JSPUtil.getParameter(request, "cstms_file_tp_cd", ""));
        setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setTrspModId(JSPUtil.getParameter(request, "trsp_mod_id", ""));
        setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
        setBlPckQty(JSPUtil.getParameter(request, "bl_pck_qty", ""));
        setUsaIbTrspNo(JSPUtil.getParameter(request, "usa_ib_trsp_no", ""));
        setRailCrrRefNo(JSPUtil.getParameter(request, "rail_crr_ref_no", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setMbl2Count(JSPUtil.getParameter(request, "mbl2_count", ""));
        setBlTotCount(JSPUtil.getParameter(request, "bl_tot_count", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
        setCustNm3(JSPUtil.getParameter(request, "cust_nm3", ""));
        setCustNm2(JSPUtil.getParameter(request, "cust_nm2", ""));
        setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
        setEdi(JSPUtil.getParameter(request, "edi", ""));
        setCustSteCd1(JSPUtil.getParameter(request, "cust_ste_cd1", ""));
        setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
        setMfStsCd(JSPUtil.getParameter(request, "mf_sts_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setSentTime(JSPUtil.getParameter(request, "sent_time", ""));
        setCustCntCd3(JSPUtil.getParameter(request, "cust_cnt_cd3", ""));
        setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
        setHblCount(JSPUtil.getParameter(request, "hbl_count", ""));
        setMh(JSPUtil.getParameter(request, "mh", ""));
        setMbl3Count(JSPUtil.getParameter(request, "mbl3_count", ""));
        setCustCntCd1(JSPUtil.getParameter(request, "cust_cnt_cd1", ""));
        setCustNm1(JSPUtil.getParameter(request, "cust_nm1", ""));
        setCustCntCd2(JSPUtil.getParameter(request, "cust_cnt_cd2", ""));
        setCustAddr1(JSPUtil.getParameter(request, "cust_addr1", ""));
        setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
        setCustAddr3(JSPUtil.getParameter(request, "cust_addr3", ""));
        setCustAddr2(JSPUtil.getParameter(request, "cust_addr2", ""));
        setBlNo2(JSPUtil.getParameter(request, "bl_no2", ""));
        setCustCtyNm1(JSPUtil.getParameter(request, "cust_cty_nm1", ""));
        setCustCtyNm2(JSPUtil.getParameter(request, "cust_cty_nm2", ""));
        setCustCtyNm3(JSPUtil.getParameter(request, "cust_cty_nm3", ""));
        setCgoDesc(JSPUtil.getParameter(request, "cgo_desc", ""));
        setMbl1Count(JSPUtil.getParameter(request, "mbl1_count", ""));
        setIbdLocGdsDesc(JSPUtil.getParameter(request, "ibd_loc_gds_desc", ""));
        setCustSteCd3(JSPUtil.getParameter(request, "cust_ste_cd3", ""));
        setCustSteCd2(JSPUtil.getParameter(request, "cust_ste_cd2", ""));
        setCustZipId3(JSPUtil.getParameter(request, "cust_zip_id3", ""));
        setCustZipId2(JSPUtil.getParameter(request, "cust_zip_id2", ""));
        setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
        setCustZipId1(JSPUtil.getParameter(request, "cust_zip_id1", ""));
        setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
        setBlCnt(JSPUtil.getParameter(request, "bl_cnt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsManifestDtlListVO[]
	 */
    public CndCstmsManifestDtlListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsManifestDtlListVO[]
	 */
    public CndCstmsManifestDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CndCstmsManifestDtlListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix + "cstms_file_tp_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] trspModId = (JSPUtil.getParameter(request, prefix + "trsp_mod_id", length));
            String[] cgoWgt = (JSPUtil.getParameter(request, prefix + "cgo_wgt", length));
            String[] blPckQty = (JSPUtil.getParameter(request, prefix + "bl_pck_qty", length));
            String[] usaIbTrspNo = (JSPUtil.getParameter(request, prefix + "usa_ib_trsp_no", length));
            String[] railCrrRefNo = (JSPUtil.getParameter(request, prefix + "rail_crr_ref_no", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] mbl2Count = (JSPUtil.getParameter(request, prefix + "mbl2_count", length));
            String[] blTotCount = (JSPUtil.getParameter(request, prefix + "bl_tot_count", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] fullMtyCd = (JSPUtil.getParameter(request, prefix + "full_mty_cd", length));
            String[] custNm3 = (JSPUtil.getParameter(request, prefix + "cust_nm3", length));
            String[] custNm2 = (JSPUtil.getParameter(request, prefix + "cust_nm2", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] edi = (JSPUtil.getParameter(request, prefix + "edi", length));
            String[] custSteCd1 = (JSPUtil.getParameter(request, prefix + "cust_ste_cd1", length));
            String[] mkDesc = (JSPUtil.getParameter(request, prefix + "mk_desc", length));
            String[] mfStsCd = (JSPUtil.getParameter(request, prefix + "mf_sts_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sentTime = (JSPUtil.getParameter(request, prefix + "sent_time", length));
            String[] custCntCd3 = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd3", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] hblCount = (JSPUtil.getParameter(request, prefix + "hbl_count", length));
            String[] mh = (JSPUtil.getParameter(request, prefix + "mh", length));
            String[] mbl3Count = (JSPUtil.getParameter(request, prefix + "mbl3_count", length));
            String[] custCntCd1 = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd1", length));
            String[] custNm1 = (JSPUtil.getParameter(request, prefix + "cust_nm1", length));
            String[] custCntCd2 = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd2", length));
            String[] custAddr1 = (JSPUtil.getParameter(request, prefix + "cust_addr1", length));
            String[] sealNo = (JSPUtil.getParameter(request, prefix + "seal_no", length));
            String[] custAddr3 = (JSPUtil.getParameter(request, prefix + "cust_addr3", length));
            String[] custAddr2 = (JSPUtil.getParameter(request, prefix + "cust_addr2", length));
            String[] blNo2 = (JSPUtil.getParameter(request, prefix + "bl_no2", length));
            String[] custCtyNm1 = (JSPUtil.getParameter(request, prefix + "cust_cty_nm1", length));
            String[] custCtyNm2 = (JSPUtil.getParameter(request, prefix + "cust_cty_nm2", length));
            String[] custCtyNm3 = (JSPUtil.getParameter(request, prefix + "cust_cty_nm3", length));
            String[] cgoDesc = (JSPUtil.getParameter(request, prefix + "cgo_desc", length));
            String[] mbl1Count = (JSPUtil.getParameter(request, prefix + "mbl1_count", length));
            String[] ibdLocGdsDesc = (JSPUtil.getParameter(request, prefix + "ibd_loc_gds_desc", length));
            String[] custSteCd3 = (JSPUtil.getParameter(request, prefix + "cust_ste_cd3", length));
            String[] custSteCd2 = (JSPUtil.getParameter(request, prefix + "cust_ste_cd2", length));
            String[] custZipId3 = (JSPUtil.getParameter(request, prefix + "cust_zip_id3", length));
            String[] custZipId2 = (JSPUtil.getParameter(request, prefix + "cust_zip_id2", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] custZipId1 = (JSPUtil.getParameter(request, prefix + "cust_zip_id1", length));
            String[] hubLocCd = (JSPUtil.getParameter(request, prefix + "hub_loc_cd", length));
            String[] blCnt = (JSPUtil.getParameter(request, prefix + "bl_cnt", length));
            for (int i = 0; i < length; i++) {
                model = new CndCstmsManifestDtlListVO();
                if (cstmsFileTpCd[i] != null)
                    model.setCstmsFileTpCd(cstmsFileTpCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (trspModId[i] != null)
                    model.setTrspModId(trspModId[i]);
                if (cgoWgt[i] != null)
                    model.setCgoWgt(cgoWgt[i]);
                if (blPckQty[i] != null)
                    model.setBlPckQty(blPckQty[i]);
                if (usaIbTrspNo[i] != null)
                    model.setUsaIbTrspNo(usaIbTrspNo[i]);
                if (railCrrRefNo[i] != null)
                    model.setRailCrrRefNo(railCrrRefNo[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (mbl2Count[i] != null)
                    model.setMbl2Count(mbl2Count[i]);
                if (blTotCount[i] != null)
                    model.setBlTotCount(blTotCount[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (fullMtyCd[i] != null)
                    model.setFullMtyCd(fullMtyCd[i]);
                if (custNm3[i] != null)
                    model.setCustNm3(custNm3[i]);
                if (custNm2[i] != null)
                    model.setCustNm2(custNm2[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (edi[i] != null)
                    model.setEdi(edi[i]);
                if (custSteCd1[i] != null)
                    model.setCustSteCd1(custSteCd1[i]);
                if (mkDesc[i] != null)
                    model.setMkDesc(mkDesc[i]);
                if (mfStsCd[i] != null)
                    model.setMfStsCd(mfStsCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sentTime[i] != null)
                    model.setSentTime(sentTime[i]);
                if (custCntCd3[i] != null)
                    model.setCustCntCd3(custCntCd3[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (hblCount[i] != null)
                    model.setHblCount(hblCount[i]);
                if (mh[i] != null)
                    model.setMh(mh[i]);
                if (mbl3Count[i] != null)
                    model.setMbl3Count(mbl3Count[i]);
                if (custCntCd1[i] != null)
                    model.setCustCntCd1(custCntCd1[i]);
                if (custNm1[i] != null)
                    model.setCustNm1(custNm1[i]);
                if (custCntCd2[i] != null)
                    model.setCustCntCd2(custCntCd2[i]);
                if (custAddr1[i] != null)
                    model.setCustAddr1(custAddr1[i]);
                if (sealNo[i] != null)
                    model.setSealNo(sealNo[i]);
                if (custAddr3[i] != null)
                    model.setCustAddr3(custAddr3[i]);
                if (custAddr2[i] != null)
                    model.setCustAddr2(custAddr2[i]);
                if (blNo2[i] != null)
                    model.setBlNo2(blNo2[i]);
                if (custCtyNm1[i] != null)
                    model.setCustCtyNm1(custCtyNm1[i]);
                if (custCtyNm2[i] != null)
                    model.setCustCtyNm2(custCtyNm2[i]);
                if (custCtyNm3[i] != null)
                    model.setCustCtyNm3(custCtyNm3[i]);
                if (cgoDesc[i] != null)
                    model.setCgoDesc(cgoDesc[i]);
                if (mbl1Count[i] != null)
                    model.setMbl1Count(mbl1Count[i]);
                if (ibdLocGdsDesc[i] != null)
                    model.setIbdLocGdsDesc(ibdLocGdsDesc[i]);
                if (custSteCd3[i] != null)
                    model.setCustSteCd3(custSteCd3[i]);
                if (custSteCd2[i] != null)
                    model.setCustSteCd2(custSteCd2[i]);
                if (custZipId3[i] != null)
                    model.setCustZipId3(custZipId3[i]);
                if (custZipId2[i] != null)
                    model.setCustZipId2(custZipId2[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (custZipId1[i] != null)
                    model.setCustZipId1(custZipId1[i]);
                if (hubLocCd[i] != null)
                    model.setHubLocCd(hubLocCd[i]);
                if (blCnt[i] != null)
                    model.setBlCnt(blCnt[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCndCstmsManifestDtlListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CndCstmsManifestDtlListVO[]
	 */
    public CndCstmsManifestDtlListVO[] getCndCstmsManifestDtlListVOs() {
        CndCstmsManifestDtlListVO[] vos = (CndCstmsManifestDtlListVO[]) models.toArray(new CndCstmsManifestDtlListVO[models.size()]);
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
        this.cstmsFileTpCd = this.cstmsFileTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspModId = this.trspModId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoWgt = this.cgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blPckQty = this.blPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usaIbTrspNo = this.usaIbTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railCrrRefNo = this.railCrrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mbl2Count = this.mbl2Count.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blTotCount = this.blTotCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullMtyCd = this.fullMtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm3 = this.custNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm2 = this.custNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.edi = this.edi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSteCd1 = this.custSteCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mkDesc = this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfStsCd = this.mfStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sentTime = this.sentTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd3 = this.custCntCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hblCount = this.hblCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mh = this.mh.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mbl3Count = this.mbl3Count.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd1 = this.custCntCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm1 = this.custNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd2 = this.custCntCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr1 = this.custAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealNo = this.sealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr3 = this.custAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr2 = this.custAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo2 = this.blNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCtyNm1 = this.custCtyNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCtyNm2 = this.custCtyNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCtyNm3 = this.custCtyNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoDesc = this.cgoDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mbl1Count = this.mbl1Count.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibdLocGdsDesc = this.ibdLocGdsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSteCd3 = this.custSteCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSteCd2 = this.custSteCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custZipId3 = this.custZipId3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custZipId2 = this.custZipId2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custZipId1 = this.custZipId1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubLocCd = this.hubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCnt = this.blCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.error = this.error.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
