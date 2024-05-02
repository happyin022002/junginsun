/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : EurManifestListVO.java
 *@FileTitle : EurManifestListVO
 *Open Issues :
 *Change history : 
 *@LastModifyDate : 2011.11.18
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2011.11.18 김보배 
 * 1.0 Creation
 * ----------------------------------------------------
 * History
 * 2012.04.02 김보배 [CHM-201217042] [BKG] [EUR Customs EDI화면] EXS MRN / Export MRN 추가 - U/I 및 Flat file 업데이트
 * 2013.05.30 김보배 [CHM-201324949] EU customs EDI 화면 수정 및 Receiver ID 추가요청
 * 2013.07.08 김보배 [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory 설정요청
 * 2013.09.12 김보배 [CHM-201326134] DE 요청사항 #1,2 (EU customs EDI and CTA Transmit history 상 Partial mark 추가)
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
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
public class EurManifestListVO extends ManifestListDetailVO {

    private static final long serialVersionUID = 1L;

    private Collection<EurManifestListVO> models = new ArrayList<EurManifestListVO>();

    /* Column Info */
    private String ntfyZip = null;

    /* Column Info */
    private String eta = null;

    /* Column Info */
    private String cneeStr1 = null;

    /* Column Info */
    private String dtSeq = null;

    /* Column Info */
    private String cntrNos = null;

    /* Column Info */
    private String etd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String ntfyNm1 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cneeCt = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cneeZip1 = null;

    /* Column Info */
    private String custToOrdFlg = null;

    /* Column Info */
    private String cneeCn = null;

    /* Column Info */
    private String cneeStr = null;

    /* Column Info */
    private String vslFullname = null;

    /* Column Info */
    private String cneeCt1 = null;

    /* Column Info */
    private String vslCallsign = null;

    /* Column Info */
    private String ntfyCt1 = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String ntfyAd = null;

    /* Column Info */
    private String cneeZip = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String cneeAd = null;

    /* Column Info */
    private String bPolCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String ntfyStr = null;

    /* Column Info */
    private String shCt = null;

    /* Column Info */
    private String cneeAd1 = null;

    /* Column Info */
    private String shCn = null;

    /* Column Info */
    private String ntfyStr1 = null;

    /* Column Info */
    private String pofe = null;

    /* Column Info */
    private String shZip = null;

    /* Column Info */
    private String pofeEta = null;

    /* Column Info */
    private String shAd = null;

    /* Column Info */
    private String mrn = null;

    /* Column Info */
    private String exsMrn = null;

    /* Column Info */
    private String exportMrn = null;

    /* Column Info */
    private String cneeEori1 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ntfyCn = null;

    /* Column Info */
    private String ensInfo = null;

    /* Column Info */
    private String errYn = null;

    /* Column Info */
    private String bPodCd = null;

    /* Column Info */
    private String ntfyEori = null;

    /* Column Info */
    private String shEori = null;

    /* Column Info */
    private String shNm = null;

    /* Column Info */
    private String ntfyCt = null;

    /* Column Info */
    private String ntfyCn1 = null;

    /* Column Info */
    private String cneeEori = null;

    /* Column Info */
    private String cneeNm1 = null;

    /* Column Info */
    private String ntfyNm = null;

    /* Column Info */
    private String cneeNm = null;

    /* Column Info */
    private String ntfyAd1 = null;

    /* Column Info */
    private String vslLloydcode = null;

    /* Column Info */
    private String shStr = null;

    /* Column Info */
    private String cneeCn1 = null;

    /* Column Info */
    private String ntfyZip1 = null;

    /* Column Info */
    private String ntfyEori1 = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String cntrPrtFlg = null;

    /* Column Info */
    private String cargoType = null;
    
    /* Column Info */
    private String tranStatus = null;
    
    /* Column Info */
    private String receiveStatus = null;
    
    /* Column Info */
    private String trnsModCd = null;

    /* 테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public EurManifestListVO() {
    }

    public EurManifestListVO(String ibflag, String pagerows, String blNo, String dtSeq, String cntrNos, String polCd, String podCd, String bPolCd, String bPodCd, String delCd, String custToOrdFlg, String ensInfo, String shNm, String shAd, String shCt, String shCn, String shZip, String shStr, String shEori, String cneeNm1, String cneeAd1, String cneeCt1, String cneeCn1, String cneeZip1, String cneeStr1, String cneeEori1, String ntfyNm1, String ntfyAd1, String ntfyCt1, String ntfyCn1, String ntfyZip1, String ntfyStr1, String ntfyEori1, String bkgNo, String vslCallsign, String vslLloydcode, String vslFullname, String eta, String etd, String pofe, String mrn, String exsMrn, String exportMrn, String pofeEta, String cneeNm, String cneeAd, String cneeCt, String cneeCn, String cneeZip, String cneeStr, String cneeEori, String ntfyNm, String ntfyAd, String ntfyCt, String ntfyCn, String ntfyZip, String ntfyStr, String ntfyEori, String errYn, String polYdCd, String podYdCd, String slanCd, String cntrPrtFlg, String cargoType, String tranStatus, String receiveStatus, String trnsModCd) {
        this.ntfyZip = ntfyZip;
        this.eta = eta;
        this.cneeStr1 = cneeStr1;
        this.dtSeq = dtSeq;
        this.cntrNos = cntrNos;
        this.etd = etd;
        this.blNo = blNo;
        this.ntfyNm1 = ntfyNm1;
        this.pagerows = pagerows;
        this.cneeCt = cneeCt;
        this.polCd = polCd;
        this.cneeZip1 = cneeZip1;
        this.custToOrdFlg = custToOrdFlg;
        this.cneeCn = cneeCn;
        this.cneeStr = cneeStr;
        this.vslFullname = vslFullname;
        this.cneeCt1 = cneeCt1;
        this.vslCallsign = vslCallsign;
        this.ntfyCt1 = ntfyCt1;
        this.delCd = delCd;
        this.ntfyAd = ntfyAd;
        this.cneeZip = cneeZip;
        this.podCd = podCd;
        this.cneeAd = cneeAd;
        this.bPolCd = bPolCd;
        this.bkgNo = bkgNo;
        this.ntfyStr = ntfyStr;
        this.shCt = shCt;
        this.cneeAd1 = cneeAd1;
        this.shCn = shCn;
        this.ntfyStr1 = ntfyStr1;
        this.pofe = pofe;
        this.shZip = shZip;
        this.pofeEta = pofeEta;
        this.shAd = shAd;
        this.mrn = mrn;
        this.exsMrn = exsMrn;
        this.exportMrn = exportMrn;
        this.cneeEori1 = cneeEori1;
        this.ibflag = ibflag;
        this.ntfyCn = ntfyCn;
        this.ensInfo = ensInfo;
        this.errYn = errYn;
        this.bPodCd = bPodCd;
        this.ntfyEori = ntfyEori;
        this.shEori = shEori;
        this.shNm = shNm;
        this.ntfyCt = ntfyCt;
        this.ntfyCn1 = ntfyCn1;
        this.cneeEori = cneeEori;
        this.cneeNm1 = cneeNm1;
        this.ntfyNm = ntfyNm;
        this.cneeNm = cneeNm;
        this.ntfyAd1 = ntfyAd1;
        this.vslLloydcode = vslLloydcode;
        this.shStr = shStr;
        this.cneeCn1 = cneeCn1;
        this.ntfyZip1 = ntfyZip1;
        this.ntfyEori1 = ntfyEori1;
        this.polYdCd = polYdCd;
        this.podYdCd = podYdCd;
        this.slanCd = slanCd;
        this.cntrPrtFlg = cntrPrtFlg;
        this.cargoType = cargoType;
        this.tranStatus = tranStatus;
        this.receiveStatus = receiveStatus;
        this.trnsModCd = trnsModCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ntfy_zip", getNtfyZip());
        this.hashColumns.put("eta", getEta());
        this.hashColumns.put("cnee_str1", getCneeStr1());
        this.hashColumns.put("dt_seq", getDtSeq());
        this.hashColumns.put("cntr_nos", getCntrNos());
        this.hashColumns.put("etd", getEtd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("ntfy_nm1", getNtfyNm1());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cnee_ct", getCneeCt());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cnee_zip1", getCneeZip1());
        this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
        this.hashColumns.put("cnee_cn", getCneeCn());
        this.hashColumns.put("cnee_str", getCneeStr());
        this.hashColumns.put("vsl_fullname", getVslFullname());
        this.hashColumns.put("cnee_ct1", getCneeCt1());
        this.hashColumns.put("vsl_callsign", getVslCallsign());
        this.hashColumns.put("ntfy_ct1", getNtfyCt1());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("ntfy_ad", getNtfyAd());
        this.hashColumns.put("cnee_zip", getCneeZip());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("cnee_ad", getCneeAd());
        this.hashColumns.put("b_pol_cd", getBPolCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ntfy_str", getNtfyStr());
        this.hashColumns.put("sh_ct", getShCt());
        this.hashColumns.put("cnee_ad1", getCneeAd1());
        this.hashColumns.put("sh_cn", getShCn());
        this.hashColumns.put("ntfy_str1", getNtfyStr1());
        this.hashColumns.put("pofe", getPofe());
        this.hashColumns.put("sh_zip", getShZip());
        this.hashColumns.put("pofe_eta", getPofeEta());
        this.hashColumns.put("sh_ad", getShAd());
        this.hashColumns.put("mrn", getMrn());
        this.hashColumns.put("exs_mrn", getExsMrn());
        this.hashColumns.put("export_mrn", getExportMrn());
        this.hashColumns.put("cnee_eori1", getCneeEori1());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ntfy_cn", getNtfyCn());
        this.hashColumns.put("ens_info", getEnsInfo());
        this.hashColumns.put("err_yn", getErrYn());
        this.hashColumns.put("b_pod_cd", getBPodCd());
        this.hashColumns.put("ntfy_eori", getNtfyEori());
        this.hashColumns.put("sh_eori", getShEori());
        this.hashColumns.put("sh_nm", getShNm());
        this.hashColumns.put("ntfy_ct", getNtfyCt());
        this.hashColumns.put("ntfy_cn1", getNtfyCn1());
        this.hashColumns.put("cnee_eori", getCneeEori());
        this.hashColumns.put("cnee_nm1", getCneeNm1());
        this.hashColumns.put("ntfy_nm", getNtfyNm());
        this.hashColumns.put("cnee_nm", getCneeNm());
        this.hashColumns.put("ntfy_ad1", getNtfyAd1());
        this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
        this.hashColumns.put("sh_str", getShStr());
        this.hashColumns.put("cnee_cn1", getCneeCn1());
        this.hashColumns.put("ntfy_zip1", getNtfyZip1());
        this.hashColumns.put("ntfy_eori1", getNtfyEori1());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
        this.hashColumns.put("cargo_type", getCargoType());
        this.hashColumns.put("tran_status", getTranStatus());
        this.hashColumns.put("receive_status", getReceiveStatus());
        this.hashColumns.put("trns_mod_cd", getTrnsModCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ntfy_zip", "ntfyZip");
        this.hashFields.put("eta", "eta");
        this.hashFields.put("cnee_str1", "cneeStr1");
        this.hashFields.put("dt_seq", "dtSeq");
        this.hashFields.put("cntr_nos", "cntrNos");
        this.hashFields.put("etd", "etd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("ntfy_nm1", "ntfyNm1");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cnee_ct", "cneeCt");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cnee_zip1", "cneeZip1");
        this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
        this.hashFields.put("cnee_cn", "cneeCn");
        this.hashFields.put("cnee_str", "cneeStr");
        this.hashFields.put("vsl_fullname", "vslFullname");
        this.hashFields.put("cnee_ct1", "cneeCt1");
        this.hashFields.put("vsl_callsign", "vslCallsign");
        this.hashFields.put("ntfy_ct1", "ntfyCt1");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("ntfy_ad", "ntfyAd");
        this.hashFields.put("cnee_zip", "cneeZip");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("cnee_ad", "cneeAd");
        this.hashFields.put("b_pol_cd", "bPolCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ntfy_str", "ntfyStr");
        this.hashFields.put("sh_ct", "shCt");
        this.hashFields.put("cnee_ad1", "cneeAd1");
        this.hashFields.put("sh_cn", "shCn");
        this.hashFields.put("ntfy_str1", "ntfyStr1");
        this.hashFields.put("pofe", "pofe");
        this.hashFields.put("sh_zip", "shZip");
        this.hashFields.put("pofe_eta", "pofeEta");
        this.hashFields.put("sh_ad", "shAd");
        this.hashFields.put("mrn", "mrn");
        this.hashFields.put("exs_mrn", "exsMrn");
        this.hashFields.put("export_mrn", "exportMrn");
        this.hashFields.put("cnee_eori1", "cneeEori1");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ntfy_cn", "ntfyCn");
        this.hashFields.put("ens_info", "ensInfo");
        this.hashFields.put("err_yn", "errYn");
        this.hashFields.put("b_pod_cd", "bPodCd");
        this.hashFields.put("ntfy_eori", "ntfyEori");
        this.hashFields.put("sh_eori", "shEori");
        this.hashFields.put("sh_nm", "shNm");
        this.hashFields.put("ntfy_ct", "ntfyCt");
        this.hashFields.put("ntfy_cn1", "ntfyCn1");
        this.hashFields.put("cnee_eori", "cneeEori");
        this.hashFields.put("cnee_nm1", "cneeNm1");
        this.hashFields.put("ntfy_nm", "ntfyNm");
        this.hashFields.put("cnee_nm", "cneeNm");
        this.hashFields.put("ntfy_ad1", "ntfyAd1");
        this.hashFields.put("vsl_lloydcode", "vslLloydcode");
        this.hashFields.put("sh_str", "shStr");
        this.hashFields.put("cnee_cn1", "cneeCn1");
        this.hashFields.put("ntfy_zip1", "ntfyZip1");
        this.hashFields.put("ntfy_eori1", "ntfyEori1");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
        this.hashFields.put("cargo_type", "cargoType");
        this.hashFields.put("tran_status", "tranStatus");
        this.hashFields.put("receive_status", "receiveStatus");
        this.hashFields.put("trns_mod_cd", "trnsModCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyZip
	 */
    public String getNtfyZip() {
        return this.ntfyZip;
    }

    /**
	 * Column Info
	 * 
	 * @return eta
	 */
    public String getEta() {
        return this.eta;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeStr1
	 */
    public String getCneeStr1() {
        return this.cneeStr1;
    }

    /**
	 * Column Info
	 * 
	 * @return dtSeq
	 */
    public String getDtSeq() {
        return this.dtSeq;
    }

    /**
	 * Column Info
	 * 
	 * @return cntrNos
	 */
    public String getCntrNos() {
        return this.cntrNos;
    }

    /**
	 * Column Info
	 * 
	 * @return etd
	 */
    public String getEtd() {
        return this.etd;
    }

    /**
	 * Column Info
	 * 
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyNm1
	 */
    public String getNtfyNm1() {
        return this.ntfyNm1;
    }

    /**
	 * Page Number
	 * 
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeCt
	 */
    public String getCneeCt() {
        return this.cneeCt;
    }

    /**
	 * Column Info
	 * 
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeZip1
	 */
    public String getCneeZip1() {
        return this.cneeZip1;
    }

    /**
	 * Column Info
	 * 
	 * @return custToOrdFlg
	 */
    public String getCustToOrdFlg() {
        return this.custToOrdFlg;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeCn
	 */
    public String getCneeCn() {
        return this.cneeCn;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeStr
	 */
    public String getCneeStr() {
        return this.cneeStr;
    }

    /**
	 * Column Info
	 * 
	 * @return vslFullname
	 */
    public String getVslFullname() {
        return this.vslFullname;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeCt1
	 */
    public String getCneeCt1() {
        return this.cneeCt1;
    }

    /**
	 * Column Info
	 * 
	 * @return vslCallsign
	 */
    public String getVslCallsign() {
        return this.vslCallsign;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyCt1
	 */
    public String getNtfyCt1() {
        return this.ntfyCt1;
    }

    /**
	 * Column Info
	 * 
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyAd
	 */
    public String getNtfyAd() {
        return this.ntfyAd;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeZip
	 */
    public String getCneeZip() {
        return this.cneeZip;
    }

    /**
	 * Column Info
	 * 
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeAd
	 */
    public String getCneeAd() {
        return this.cneeAd;
    }

    /**
	 * Column Info
	 * 
	 * @return bPolCd
	 */
    public String getBPolCd() {
        return this.bPolCd;
    }

    /**
	 * Column Info
	 * 
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyStr
	 */
    public String getNtfyStr() {
        return this.ntfyStr;
    }

    /**
	 * Column Info
	 * 
	 * @return shCt
	 */
    public String getShCt() {
        return this.shCt;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeAd1
	 */
    public String getCneeAd1() {
        return this.cneeAd1;
    }

    /**
	 * Column Info
	 * 
	 * @return shCn
	 */
    public String getShCn() {
        return this.shCn;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyStr1
	 */
    public String getNtfyStr1() {
        return this.ntfyStr1;
    }

    /**
	 * Column Info
	 * 
	 * @return pofe
	 */
    public String getPofe() {
        return this.pofe;
    }

    /**
	 * Column Info
	 * 
	 * @return shZip
	 */
    public String getShZip() {
        return this.shZip;
    }

    /**
	 * Column Info
	 * 
	 * @return pofeEta
	 */
    public String getPofeEta() {
        return this.pofeEta;
    }

    /**
	 * Column Info
	 * 
	 * @return shAd
	 */
    public String getShAd() {
        return this.shAd;
    }

    /**
	 * Column Info
	 * 
	 * @return mrn
	 */
    public String getMrn() {
        return this.mrn;
    }

    /**
	 * Column Info
	 * 
	 * @return exsMrn
	 */
    public String getExsMrn() {
        return this.exsMrn;
    }

    /**
	 * Column Info
	 * 
	 * @return exportMrn
	 */
    public String getExportMrn() {
        return this.exportMrn;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeEori1
	 */
    public String getCneeEori1() {
        return this.cneeEori1;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyCn
	 */
    public String getNtfyCn() {
        return this.ntfyCn;
    }

    /**
	 * Column Info
	 * 
	 * @return ensInfo
	 */
    public String getEnsInfo() {
        return this.ensInfo;
    }

    /**
	 * Column Info
	 * 
	 * @return errYn
	 */
    public String getErrYn() {
        return this.errYn;
    }

    /**
	 * Column Info
	 * 
	 * @return bPodCd
	 */
    public String getBPodCd() {
        return this.bPodCd;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyEori
	 */
    public String getNtfyEori() {
        return this.ntfyEori;
    }

    /**
	 * Column Info
	 * 
	 * @return shEori
	 */
    public String getShEori() {
        return this.shEori;
    }

    /**
	 * Column Info
	 * 
	 * @return shNm
	 */
    public String getShNm() {
        return this.shNm;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyCt
	 */
    public String getNtfyCt() {
        return this.ntfyCt;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyCn1
	 */
    public String getNtfyCn1() {
        return this.ntfyCn1;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeEori
	 */
    public String getCneeEori() {
        return this.cneeEori;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeNm1
	 */
    public String getCneeNm1() {
        return this.cneeNm1;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyNm
	 */
    public String getNtfyNm() {
        return this.ntfyNm;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeNm
	 */
    public String getCneeNm() {
        return this.cneeNm;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyAd1
	 */
    public String getNtfyAd1() {
        return this.ntfyAd1;
    }

    /**
	 * Column Info
	 * 
	 * @return vslLloydcode
	 */
    public String getVslLloydcode() {
        return this.vslLloydcode;
    }

    /**
	 * Column Info
	 * 
	 * @return shStr
	 */
    public String getShStr() {
        return this.shStr;
    }

    /**
	 * Column Info
	 * 
	 * @return cneeCn1
	 */
    public String getCneeCn1() {
        return this.cneeCn1;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyZip1
	 */
    public String getNtfyZip1() {
        return this.ntfyZip1;
    }

    /**
	 * Column Info
	 * 
	 * @return ntfyEori1
	 */
    public String getNtfyEori1() {
        return this.ntfyEori1;
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
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
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
   	 * @return tranStatus
   	 */
       public String getTranStatus() {
           return this.tranStatus;
       }

    /**
  	 * Column Info
  	 * @return receiveStatus
  	 */
      public String getReceiveStatus() {
          return this.receiveStatus;
      }

    /**
	 * Column Info
	 * @return trnsModCd
	 */
      public String getTrnsModCd() {
        return this.trnsModCd;
    }
      
    /**
	 * Column Info
	 * 
	 * @param ntfyZip
	 */
    public void setNtfyZip(String ntfyZip) {
        this.ntfyZip = ntfyZip;
    }

    /**
	 * Column Info
	 * 
	 * @param eta
	 */
    public void setEta(String eta) {
        this.eta = eta;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeStr1
	 */
    public void setCneeStr1(String cneeStr1) {
        this.cneeStr1 = cneeStr1;
    }

    /**
	 * Column Info
	 * 
	 * @param dtSeq
	 */
    public void setDtSeq(String dtSeq) {
        this.dtSeq = dtSeq;
    }

    /**
	 * Column Info
	 * 
	 * @param cntrNos
	 */
    public void setCntrNos(String cntrNos) {
        this.cntrNos = cntrNos;
    }

    /**
	 * Column Info
	 * 
	 * @param etd
	 */
    public void setEtd(String etd) {
        this.etd = etd;
    }

    /**
	 * Column Info
	 * 
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyNm1
	 */
    public void setNtfyNm1(String ntfyNm1) {
        this.ntfyNm1 = ntfyNm1;
    }

    /**
	 * Page Number
	 * 
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeCt
	 */
    public void setCneeCt(String cneeCt) {
        this.cneeCt = cneeCt;
    }

    /**
	 * Column Info
	 * 
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeZip1
	 */
    public void setCneeZip1(String cneeZip1) {
        this.cneeZip1 = cneeZip1;
    }

    /**
	 * Column Info
	 * 
	 * @param custToOrdFlg
	 */
    public void setCustToOrdFlg(String custToOrdFlg) {
        this.custToOrdFlg = custToOrdFlg;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeCn
	 */
    public void setCneeCn(String cneeCn) {
        this.cneeCn = cneeCn;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeStr
	 */
    public void setCneeStr(String cneeStr) {
        this.cneeStr = cneeStr;
    }

    /**
	 * Column Info
	 * 
	 * @param vslFullname
	 */
    public void setVslFullname(String vslFullname) {
        this.vslFullname = vslFullname;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeCt1
	 */
    public void setCneeCt1(String cneeCt1) {
        this.cneeCt1 = cneeCt1;
    }

    /**
	 * Column Info
	 * 
	 * @param vslCallsign
	 */
    public void setVslCallsign(String vslCallsign) {
        this.vslCallsign = vslCallsign;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyCt1
	 */
    public void setNtfyCt1(String ntfyCt1) {
        this.ntfyCt1 = ntfyCt1;
    }

    /**
	 * Column Info
	 * 
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyAd
	 */
    public void setNtfyAd(String ntfyAd) {
        this.ntfyAd = ntfyAd;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeZip
	 */
    public void setCneeZip(String cneeZip) {
        this.cneeZip = cneeZip;
    }

    /**
	 * Column Info
	 * 
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeAd
	 */
    public void setCneeAd(String cneeAd) {
        this.cneeAd = cneeAd;
    }

    /**
	 * Column Info
	 * 
	 * @param bPolCd
	 */
    public void setBPolCd(String bPolCd) {
        this.bPolCd = bPolCd;
    }

    /**
	 * Column Info
	 * 
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyStr
	 */
    public void setNtfyStr(String ntfyStr) {
        this.ntfyStr = ntfyStr;
    }

    /**
	 * Column Info
	 * 
	 * @param shCt
	 */
    public void setShCt(String shCt) {
        this.shCt = shCt;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeAd1
	 */
    public void setCneeAd1(String cneeAd1) {
        this.cneeAd1 = cneeAd1;
    }

    /**
	 * Column Info
	 * 
	 * @param shCn
	 */
    public void setShCn(String shCn) {
        this.shCn = shCn;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyStr1
	 */
    public void setNtfyStr1(String ntfyStr1) {
        this.ntfyStr1 = ntfyStr1;
    }

    /**
	 * Column Info
	 * 
	 * @param pofe
	 */
    public void setPofe(String pofe) {
        this.pofe = pofe;
    }

    /**
	 * Column Info
	 * 
	 * @param shZip
	 */
    public void setShZip(String shZip) {
        this.shZip = shZip;
    }

    /**
	 * Column Info
	 * 
	 * @param pofeEta
	 */
    public void setPofeEta(String pofeEta) {
        this.pofeEta = pofeEta;
    }

    /**
	 * Column Info
	 * 
	 * @param shAd
	 */
    public void setShAd(String shAd) {
        this.shAd = shAd;
    }

    /**
	 * Column Info
	 * 
	 * @param mrn
	 */
    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    /**
	 * Column Info
	 * 
	 * @param exsMrn
	 */
    public void setExsMrn(String exsMrn) {
        this.exsMrn = exsMrn;
    }

    /**
	 * Column Info
	 * 
	 * @param exportMrn
	 */
    public void setExportMrn(String exportMrn) {
        this.exportMrn = exportMrn;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeEori1
	 */
    public void setCneeEori1(String cneeEori1) {
        this.cneeEori1 = cneeEori1;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyCn
	 */
    public void setNtfyCn(String ntfyCn) {
        this.ntfyCn = ntfyCn;
    }

    /**
	 * Column Info
	 * 
	 * @param ensInfo
	 */
    public void setEnsInfo(String ensInfo) {
        this.ensInfo = ensInfo;
    }

    /**
	 * Column Info
	 * 
	 * @param errYn
	 */
    public void setErrYn(String errYn) {
        this.errYn = errYn;
    }

    /**
	 * Column Info
	 * 
	 * @param bPodCd
	 */
    public void setBPodCd(String bPodCd) {
        this.bPodCd = bPodCd;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyEori
	 */
    public void setNtfyEori(String ntfyEori) {
        this.ntfyEori = ntfyEori;
    }

    /**
	 * Column Info
	 * 
	 * @param shEori
	 */
    public void setShEori(String shEori) {
        this.shEori = shEori;
    }

    /**
	 * Column Info
	 * 
	 * @param shNm
	 */
    public void setShNm(String shNm) {
        this.shNm = shNm;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyCt
	 */
    public void setNtfyCt(String ntfyCt) {
        this.ntfyCt = ntfyCt;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyCn1
	 */
    public void setNtfyCn1(String ntfyCn1) {
        this.ntfyCn1 = ntfyCn1;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeEori
	 */
    public void setCneeEori(String cneeEori) {
        this.cneeEori = cneeEori;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeNm1
	 */
    public void setCneeNm1(String cneeNm1) {
        this.cneeNm1 = cneeNm1;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyNm
	 */
    public void setNtfyNm(String ntfyNm) {
        this.ntfyNm = ntfyNm;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeNm
	 */
    public void setCneeNm(String cneeNm) {
        this.cneeNm = cneeNm;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyAd1
	 */
    public void setNtfyAd1(String ntfyAd1) {
        this.ntfyAd1 = ntfyAd1;
    }

    /**
	 * Column Info
	 * 
	 * @param vslLloydcode
	 */
    public void setVslLloydcode(String vslLloydcode) {
        this.vslLloydcode = vslLloydcode;
    }

    /**
	 * Column Info
	 * 
	 * @param shStr
	 */
    public void setShStr(String shStr) {
        this.shStr = shStr;
    }

    /**
	 * Column Info
	 * 
	 * @param cneeCn1
	 */
    public void setCneeCn1(String cneeCn1) {
        this.cneeCn1 = cneeCn1;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyZip1
	 */
    public void setNtfyZip1(String ntfyZip1) {
        this.ntfyZip1 = ntfyZip1;
    }

    /**
	 * Column Info
	 * 
	 * @param ntfyEori1
	 */
    public void setNtfyEori1(String ntfyEori1) {
        this.ntfyEori1 = ntfyEori1;
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
	 * @param podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
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
	 * @param cntrPrtFlg
	 */
    public void setCntrPrtFlg(String cntrPrtFlg) {
        this.cntrPrtFlg = cntrPrtFlg;
    }
    /**
	 * Column Info
	 * @param cargoType
	 */
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
    /**
	 * Column Info
	 * @param cargoType
	 */
    public String getCargoType() {
        return this.cargoType;
    }
    /**
	 * Column Info
	 * @param tranStatus
	 */
    public String setTranStatus(String tranStatus) {
        return this.tranStatus;
    }
    
    /**
   	 * Column Info
   	 * @param receiveStatus
   	 */
       public String setReceiveStatus(String receiveStatus) {
           return this.receiveStatus;
       }

     /**
      * Column Info
      * @param fderPol
      */
       public String setTrnsModCd(String trnsModCd) {
              return this.trnsModCd;
       }
       
    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setNtfyZip(JSPUtil.getParameter(request, prefix + "ntfy_zip", ""));
        setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
        setCneeStr1(JSPUtil.getParameter(request, prefix + "cnee_str1", ""));
        setDtSeq(JSPUtil.getParameter(request, prefix + "dt_seq", ""));
        setCntrNos(JSPUtil.getParameter(request, prefix + "cntr_nos", ""));
        setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setNtfyNm1(JSPUtil.getParameter(request, prefix + "ntfy_nm1", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCneeCt(JSPUtil.getParameter(request, prefix + "cnee_ct", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCneeZip1(JSPUtil.getParameter(request, prefix + "cnee_zip1", ""));
        setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
        setCneeCn(JSPUtil.getParameter(request, prefix + "cnee_cn", ""));
        setCneeStr(JSPUtil.getParameter(request, prefix + "cnee_str", ""));
        setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
        setCneeCt1(JSPUtil.getParameter(request, prefix + "cnee_ct1", ""));
        setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
        setNtfyCt1(JSPUtil.getParameter(request, prefix + "ntfy_ct1", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setNtfyAd(JSPUtil.getParameter(request, prefix + "ntfy_ad", ""));
        setCneeZip(JSPUtil.getParameter(request, prefix + "cnee_zip", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setCneeAd(JSPUtil.getParameter(request, prefix + "cnee_ad", ""));
        setBPolCd(JSPUtil.getParameter(request, prefix + "b_pol_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setNtfyStr(JSPUtil.getParameter(request, prefix + "ntfy_str", ""));
        setShCt(JSPUtil.getParameter(request, prefix + "sh_ct", ""));
        setCneeAd1(JSPUtil.getParameter(request, prefix + "cnee_ad1", ""));
        setShCn(JSPUtil.getParameter(request, prefix + "sh_cn", ""));
        setNtfyStr1(JSPUtil.getParameter(request, prefix + "ntfy_str1", ""));
        setPofe(JSPUtil.getParameter(request, prefix + "pofe", ""));
        setShZip(JSPUtil.getParameter(request, prefix + "sh_zip", ""));
        setPofeEta(JSPUtil.getParameter(request, prefix + "pofe_eta", ""));
        setShAd(JSPUtil.getParameter(request, prefix + "sh_ad", ""));
        setMrn(JSPUtil.getParameter(request, prefix + "mrn", ""));
        setExsMrn(JSPUtil.getParameter(request, prefix + "exs_mrn", ""));
        setExportMrn(JSPUtil.getParameter(request, prefix + "export_mrn", ""));
        setCneeEori1(JSPUtil.getParameter(request, prefix + "cnee_eori1", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setNtfyCn(JSPUtil.getParameter(request, prefix + "ntfy_cn", ""));
        setEnsInfo(JSPUtil.getParameter(request, prefix + "ens_info", ""));
        setErrYn(JSPUtil.getParameter(request, prefix + "err_yn", ""));
        setBPodCd(JSPUtil.getParameter(request, prefix + "b_pod_cd", ""));
        setNtfyEori(JSPUtil.getParameter(request, prefix + "ntfy_eori", ""));
        setShEori(JSPUtil.getParameter(request, prefix + "sh_eori", ""));
        setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
        setNtfyCt(JSPUtil.getParameter(request, prefix + "ntfy_ct", ""));
        setNtfyCn1(JSPUtil.getParameter(request, prefix + "ntfy_cn1", ""));
        setCneeEori(JSPUtil.getParameter(request, prefix + "cnee_eori", ""));
        setCneeNm1(JSPUtil.getParameter(request, prefix + "cnee_nm1", ""));
        setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
        setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
        setNtfyAd1(JSPUtil.getParameter(request, prefix + "ntfy_ad1", ""));
        setVslLloydcode(JSPUtil.getParameter(request, prefix + "vsl_lloydcode", ""));
        setShStr(JSPUtil.getParameter(request, prefix + "sh_str", ""));
        setCneeCn1(JSPUtil.getParameter(request, prefix + "cnee_cn1", ""));
        setNtfyZip1(JSPUtil.getParameter(request, prefix + "ntfy_zip1", ""));
        setNtfyEori1(JSPUtil.getParameter(request, prefix + "ntfy_eori1", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
        setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
        setCargoType(JSPUtil.getParameter(request, prefix + "tran_status", ""));
        setCargoType(JSPUtil.getParameter(request, prefix + "receive_status", ""));
        setTrnsModCd(JSPUtil.getParameter(request, prefix + "trns_mod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return EurManifestListVO[]
	 */
    public EurManifestListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return EurManifestListVO[]
	 */
    public EurManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EurManifestListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ntfyZip = (JSPUtil.getParameter(request, prefix + "ntfy_zip", length));
            String[] eta = (JSPUtil.getParameter(request, prefix + "eta", length));
            String[] cneeStr1 = (JSPUtil.getParameter(request, prefix + "cnee_str1", length));
            String[] dtSeq = (JSPUtil.getParameter(request, prefix + "dt_seq", length));
            String[] cntrNos = (JSPUtil.getParameter(request, prefix + "cntr_nos", length));
            String[] etd = (JSPUtil.getParameter(request, prefix + "etd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] ntfyNm1 = (JSPUtil.getParameter(request, prefix + "ntfy_nm1", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cneeCt = (JSPUtil.getParameter(request, prefix + "cnee_ct", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cneeZip1 = (JSPUtil.getParameter(request, prefix + "cnee_zip1", length));
            String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", length));
            String[] cneeCn = (JSPUtil.getParameter(request, prefix + "cnee_cn", length));
            String[] cneeStr = (JSPUtil.getParameter(request, prefix + "cnee_str", length));
            String[] vslFullname = (JSPUtil.getParameter(request, prefix + "vsl_fullname", length));
            String[] cneeCt1 = (JSPUtil.getParameter(request, prefix + "cnee_ct1", length));
            String[] vslCallsign = (JSPUtil.getParameter(request, prefix + "vsl_callsign", length));
            String[] ntfyCt1 = (JSPUtil.getParameter(request, prefix + "ntfy_ct1", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] ntfyAd = (JSPUtil.getParameter(request, prefix + "ntfy_ad", length));
            String[] cneeZip = (JSPUtil.getParameter(request, prefix + "cnee_zip", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] cneeAd = (JSPUtil.getParameter(request, prefix + "cnee_ad", length));
            String[] bPolCd = (JSPUtil.getParameter(request, prefix + "b_pol_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ntfyStr = (JSPUtil.getParameter(request, prefix + "ntfy_str", length));
            String[] shCt = (JSPUtil.getParameter(request, prefix + "sh_ct", length));
            String[] cneeAd1 = (JSPUtil.getParameter(request, prefix + "cnee_ad1", length));
            String[] shCn = (JSPUtil.getParameter(request, prefix + "sh_cn", length));
            String[] ntfyStr1 = (JSPUtil.getParameter(request, prefix + "ntfy_str1", length));
            String[] pofe = (JSPUtil.getParameter(request, prefix + "pofe", length));
            String[] shZip = (JSPUtil.getParameter(request, prefix + "sh_zip", length));
            String[] pofeEta = (JSPUtil.getParameter(request, prefix + "pofe_eta", length));
            String[] shAd = (JSPUtil.getParameter(request, prefix + "sh_ad", length));
            String[] mrn = (JSPUtil.getParameter(request, prefix + "mrn", length));
            String[] exsMrn = (JSPUtil.getParameter(request, prefix + "exs_mrn", length));
            String[] exportMrn = (JSPUtil.getParameter(request, prefix + "export_mrn", length));
            String[] cneeEori1 = (JSPUtil.getParameter(request, prefix + "cnee_eori1", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ntfyCn = (JSPUtil.getParameter(request, prefix + "ntfy_cn", length));
            String[] ensInfo = (JSPUtil.getParameter(request, prefix + "ens_info", length));
            String[] errYn = (JSPUtil.getParameter(request, prefix + "err_yn", length));
            String[] bPodCd = (JSPUtil.getParameter(request, prefix + "b_pod_cd", length));
            String[] ntfyEori = (JSPUtil.getParameter(request, prefix + "ntfy_eori", length));
            String[] shEori = (JSPUtil.getParameter(request, prefix + "sh_eori", length));
            String[] shNm = (JSPUtil.getParameter(request, prefix + "sh_nm", length));
            String[] ntfyCt = (JSPUtil.getParameter(request, prefix + "ntfy_ct", length));
            String[] ntfyCn1 = (JSPUtil.getParameter(request, prefix + "ntfy_cn1", length));
            String[] cneeEori = (JSPUtil.getParameter(request, prefix + "cnee_eori", length));
            String[] cneeNm1 = (JSPUtil.getParameter(request, prefix + "cnee_nm1", length));
            String[] ntfyNm = (JSPUtil.getParameter(request, prefix + "ntfy_nm", length));
            String[] cneeNm = (JSPUtil.getParameter(request, prefix + "cnee_nm", length));
            String[] ntfyAd1 = (JSPUtil.getParameter(request, prefix + "ntfy_ad1", length));
            String[] vslLloydcode = (JSPUtil.getParameter(request, prefix + "vsl_lloydcode", length));
            String[] shStr = (JSPUtil.getParameter(request, prefix + "sh_str", length));
            String[] cneeCn1 = (JSPUtil.getParameter(request, prefix + "cnee_cn1", length));
            String[] ntfyZip1 = (JSPUtil.getParameter(request, prefix + "ntfy_zip1", length));
            String[] ntfyEori1 = (JSPUtil.getParameter(request, prefix + "ntfy_eori1", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix + "cntr_prt_flg", length));
            String[] tranStatus = (JSPUtil.getParameter(request, prefix + "tran_status", length));
            String[] receiveStatus = (JSPUtil.getParameter(request, prefix + "receive_status", length));
            String[] trnsModCd = (JSPUtil.getParameter(request, prefix + "trns_mod_cd", length));
            for (int i = 0; i < length; i++) {
                model = new EurManifestListVO();
                if (ntfyZip[i] != null)
                    model.setNtfyZip(ntfyZip[i]);
                if (eta[i] != null)
                    model.setEta(eta[i]);
                if (cneeStr1[i] != null)
                    model.setCneeStr1(cneeStr1[i]);
                if (dtSeq[i] != null)
                    model.setDtSeq(dtSeq[i]);
                if (cntrNos[i] != null)
                    model.setCntrNos(cntrNos[i]);
                if (etd[i] != null)
                    model.setEtd(etd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (ntfyNm1[i] != null)
                    model.setNtfyNm1(ntfyNm1[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cneeCt[i] != null)
                    model.setCneeCt(cneeCt[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cneeZip1[i] != null)
                    model.setCneeZip1(cneeZip1[i]);
                if (custToOrdFlg[i] != null)
                    model.setCustToOrdFlg(custToOrdFlg[i]);
                if (cneeCn[i] != null)
                    model.setCneeCn(cneeCn[i]);
                if (cneeStr[i] != null)
                    model.setCneeStr(cneeStr[i]);
                if (vslFullname[i] != null)
                    model.setVslFullname(vslFullname[i]);
                if (cneeCt1[i] != null)
                    model.setCneeCt1(cneeCt1[i]);
                if (vslCallsign[i] != null)
                    model.setVslCallsign(vslCallsign[i]);
                if (ntfyCt1[i] != null)
                    model.setNtfyCt1(ntfyCt1[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (ntfyAd[i] != null)
                    model.setNtfyAd(ntfyAd[i]);
                if (cneeZip[i] != null)
                    model.setCneeZip(cneeZip[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (cneeAd[i] != null)
                    model.setCneeAd(cneeAd[i]);
                if (bPolCd[i] != null)
                    model.setBPolCd(bPolCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ntfyStr[i] != null)
                    model.setNtfyStr(ntfyStr[i]);
                if (shCt[i] != null)
                    model.setShCt(shCt[i]);
                if (cneeAd1[i] != null)
                    model.setCneeAd1(cneeAd1[i]);
                if (shCn[i] != null)
                    model.setShCn(shCn[i]);
                if (ntfyStr1[i] != null)
                    model.setNtfyStr1(ntfyStr1[i]);
                if (pofe[i] != null)
                    model.setPofe(pofe[i]);
                if (shZip[i] != null)
                    model.setShZip(shZip[i]);
                if (pofeEta[i] != null)
                    model.setPofeEta(pofeEta[i]);
                if (shAd[i] != null)
                    model.setShAd(shAd[i]);
                if (mrn[i] != null)
                    model.setMrn(mrn[i]);
                if (exsMrn[i] != null)
                    model.setExsMrn(exsMrn[i]);
                if (exportMrn[i] != null)
                    model.setExportMrn(exportMrn[i]);
                if (cneeEori1[i] != null)
                    model.setCneeEori1(cneeEori1[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ntfyCn[i] != null)
                    model.setNtfyCn(ntfyCn[i]);
                if (ensInfo[i] != null)
                    model.setEnsInfo(ensInfo[i]);
                if (errYn[i] != null)
                    model.setErrYn(errYn[i]);
                if (bPodCd[i] != null)
                    model.setBPodCd(bPodCd[i]);
                if (ntfyEori[i] != null)
                    model.setNtfyEori(ntfyEori[i]);
                if (shEori[i] != null)
                    model.setShEori(shEori[i]);
                if (shNm[i] != null)
                    model.setShNm(shNm[i]);
                if (ntfyCt[i] != null)
                    model.setNtfyCt(ntfyCt[i]);
                if (ntfyCn1[i] != null)
                    model.setNtfyCn1(ntfyCn1[i]);
                if (cneeEori[i] != null)
                    model.setCneeEori(cneeEori[i]);
                if (cneeNm1[i] != null)
                    model.setCneeNm1(cneeNm1[i]);
                if (ntfyNm[i] != null)
                    model.setNtfyNm(ntfyNm[i]);
                if (cneeNm[i] != null)
                    model.setCneeNm(cneeNm[i]);
                if (ntfyAd1[i] != null)
                    model.setNtfyAd1(ntfyAd1[i]);
                if (vslLloydcode[i] != null)
                    model.setVslLloydcode(vslLloydcode[i]);
                if (shStr[i] != null)
                    model.setShStr(shStr[i]);
                if (cneeCn1[i] != null)
                    model.setCneeCn1(cneeCn1[i]);
                if (ntfyZip1[i] != null)
                    model.setNtfyZip1(ntfyZip1[i]);
                if (ntfyEori1[i] != null)
                    model.setNtfyEori1(ntfyEori1[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (cntrPrtFlg[i] != null)
                    model.setCntrPrtFlg(cntrPrtFlg[i]);
                if (tranStatus[i] != null)
                    model.setTranStatus(tranStatus[i]);
                if (receiveStatus[i] != null)
                    model.setReceiveStatus(receiveStatus[i]);
                if (trnsModCd[i] != null)
                    model.setTrnsModCd(trnsModCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEurManifestListVOs();
    }

    /**
	 * VO 배열을 반환
	 * 
	 * @return EurManifestListVO[]
	 */
    public EurManifestListVO[] getEurManifestListVOs() {
        EurManifestListVO[] vos = (EurManifestListVO[]) models.toArray(new EurManifestListVO[models.size()]);
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
        this.ntfyZip = this.ntfyZip.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eta = this.eta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeStr1 = this.cneeStr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dtSeq = this.dtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNos = this.cntrNos.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etd = this.etd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyNm1 = this.ntfyNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCt = this.cneeCt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeZip1 = this.cneeZip1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custToOrdFlg = this.custToOrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCn = this.cneeCn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeStr = this.cneeStr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslFullname = this.vslFullname.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCt1 = this.cneeCt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCallsign = this.vslCallsign.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCt1 = this.ntfyCt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyAd = this.ntfyAd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeZip = this.cneeZip.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeAd = this.cneeAd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bPolCd = this.bPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyStr = this.ntfyStr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCt = this.shCt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeAd1 = this.cneeAd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCn = this.shCn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyStr1 = this.ntfyStr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pofe = this.pofe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shZip = this.shZip.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pofeEta = this.pofeEta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shAd = this.shAd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrn = this.mrn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exsMrn = this.exsMrn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exportMrn = this.exportMrn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeEori1 = this.cneeEori1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCn = this.ntfyCn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ensInfo = this.ensInfo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errYn = this.errYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bPodCd = this.bPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyEori = this.ntfyEori.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shEori = this.shEori.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shNm = this.shNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCt = this.ntfyCt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCn1 = this.ntfyCn1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeEori = this.cneeEori.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeNm1 = this.cneeNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyNm = this.ntfyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeNm = this.cneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyAd1 = this.ntfyAd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLloydcode = this.vslLloydcode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shStr = this.shStr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCn1 = this.cneeCn1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyZip1 = this.ntfyZip1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyEori1 = this.ntfyEori1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrPrtFlg = this.cntrPrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cargoType = this.cargoType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tranStatus = this.tranStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.receiveStatus = this.receiveStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnsModCd = this.trnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
