/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MtyRlseOrdExcelBkgRoot.java
*@FileTitle : MtyRlseOrdExcelBkgRoot
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
public class MtyRlseOrdExcelBkgRootVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MtyRlseOrdExcelBkgRootVO> models = new ArrayList<MtyRlseOrdExcelBkgRootVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String bkgCreDt = null;

    /* Column Info */
    private String status = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String slanCd1 = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vvd1LloydNo = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String vvd1CallSign = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String vslCd1 = null;

    /* Column Info */
    private String trunkVesselLloydNo = null;

    /* Column Info */
    private String vslEngNm1 = null;

    /* Column Info */
    private String trunkVesselCallSign = null;

    /* Column Info */
    private String skdVoyNo1 = null;

    /* Column Info */
    private String skdDirCd2 = null;

    /* Column Info */
    private String locNm = null;

    /* Column Info */
    private String porOpscode = null;

    /* Column Info */
    private String unLocCd = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String locNm1 = null;

    /* Column Info */
    private String unLocCd1 = null;

    /* Column Info */
    private String polNodCd = null;

    /* Column Info */
    private String vpsEtaDt1 = null;

    /* Column Info */
    private String vpsEtdDt1 = null;

    /* Column Info */
    private String cutOffTimeFirstPol = null;

    /* Column Info */
    private String locNm2 = null;

    /* Column Info */
    private String unLocCd2 = null;

    /* Column Info */
    private String delOpusCode = null;

    /* Column Info */
    private String locNm3 = null;

    /* Column Info */
    private String unLocCd3 = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String xterRmk = null;

    /* Column Info */
    private String vndrRmk = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String mtyPkupYdCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String custNm1 = null;

    /* Column Info */
    private String custNm2 = null;

    /* Column Info */
    private String custCntCd1 = null;

    /* Column Info */
    private String custCntCd2 = null;

    /* Column Info */
    private String custCntCd3 = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String hngrFlg = null;

    /* Column Info */
    private String stwgRmk = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String bkgContactPoint = null;

    /* Column Info */
    private String twnSoNo = null;

    /* Column Info */
    private String blckStwgCd = null;

    /* Column Info */
    private String mtyPkupDate = null;

    /* Column Info */
    private String mtyPkupDate1 = null;

    /* Column Info */
    private String mtyPkupYdCd1 = null;

    /* Column Info */
    private String fullReturnYardCountry = null;

    /* Column Info */
    private String fullRtnYdCd = null;

    /* Column Info */
    private String fullReturnYardName = null;

    /* Column Info */
    private String stowRemark = null;

    /* Column Info */
    private String custRefNoCtnt = null;

    /* Column Info */
    private String skdDirCdT = null;

    /* Column Info */
    private String mtyPkupYdCdT = null;

    /* Column Info */
    private String vvdLloydNo = null;

    /* Column Info */
    private String vvdCallSign = null;

    /* Column Info */
    private String consVoy = null;
    /* Column Info */
    private String scNo = null;
    /* Column Info */
	private String rfaNo = null;
    /* Column Info */
	private String taaNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MtyRlseOrdExcelBkgRootVO() {
    }

    public MtyRlseOrdExcelBkgRootVO(String ibflag, String pagerows, String bkgNo, String bkgCreDt, String status, String slanCd, String slanCd1, String vslCd, String vvd1LloydNo, String vslEngNm, String vvd1CallSign, String skdVoyNo, String skdDirCd, String vpsEtdDt, String vpsEtaDt, String vslCd1, String trunkVesselLloydNo, String vslEngNm1, String trunkVesselCallSign, String skdVoyNo1, String skdDirCd2, String locNm, String porOpscode, String unLocCd, String porNodCd, String locNm1, String unLocCd1, String polNodCd, String vpsEtaDt1, String vpsEtdDt1, String cutOffTimeFirstPol, String locNm2, String unLocCd2, String delOpusCode, String locNm3, String unLocCd3, String rcvTermCd, String xterRmk, String vndrRmk, String cmdtCd, String cmdtNm, String mtyPkupYdCd, String custNm, String custNm1, String custNm2, String custCntCd1, String custCntCd2, String custCntCd3, String bkgStsCd, String rdCgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String hngrFlg, String stwgRmk, String stwgCd, String bkgOfcCd, String bkgContactPoint, String twnSoNo, String blckStwgCd, String mtyPkupDate, String mtyPkupDate1, String mtyPkupYdCd1, String fullReturnYardCountry, String fullRtnYdCd, String fullReturnYardName, String stowRemark, String custRefNoCtnt, String skdDirCdT, String mtyPkupYdCdT, String vvdLloydNo, String vvdCallSign, String consVoy, String scNo, String rfaNo, String taaNo) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.bkgCreDt = bkgCreDt;
        this.status = status;
        this.slanCd = slanCd;
        this.slanCd1 = slanCd1;
        this.vslCd = vslCd;
        this.vvd1LloydNo = vvd1LloydNo;
        this.vslEngNm = vslEngNm;
        this.vvd1CallSign = vvd1CallSign;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.vpsEtdDt = vpsEtdDt;
        this.vpsEtaDt = vpsEtaDt;
        this.vslCd1 = vslCd1;
        this.trunkVesselLloydNo = trunkVesselLloydNo;
        this.vslEngNm1 = vslEngNm1;
        this.trunkVesselCallSign = trunkVesselCallSign;
        this.skdVoyNo1 = skdVoyNo1;
        this.skdDirCd2 = skdDirCd2;
        this.locNm = locNm;
        this.porOpscode = porOpscode;
        this.unLocCd = unLocCd;
        this.porNodCd = porNodCd;
        this.locNm1 = locNm1;
        this.unLocCd1 = unLocCd1;
        this.polNodCd = polNodCd;
        this.vpsEtaDt1 = vpsEtaDt1;
        this.vpsEtdDt1 = vpsEtdDt1;
        this.cutOffTimeFirstPol = cutOffTimeFirstPol;
        this.locNm2 = locNm2;
        this.unLocCd2 = unLocCd2;
        this.delOpusCode = delOpusCode;
        this.locNm3 = locNm3;
        this.unLocCd3 = unLocCd3;
        this.rcvTermCd = rcvTermCd;
        this.xterRmk = xterRmk;
        this.vndrRmk = vndrRmk;
        this.cmdtCd = cmdtCd;
        this.cmdtNm = cmdtNm;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.custNm = custNm;
        this.custNm1 = custNm1;
        this.custNm2 = custNm2;
        this.custCntCd1 = custCntCd1;
        this.custCntCd2 = custCntCd2;
        this.custCntCd3 = custCntCd3;
        this.bkgStsCd = bkgStsCd;
        this.rdCgoFlg = rdCgoFlg;
        this.rcFlg = rcFlg;
        this.awkCgoFlg = awkCgoFlg;
        this.bbCgoFlg = bbCgoFlg;
        this.hngrFlg = hngrFlg;
        this.stwgRmk = stwgRmk;
        this.stwgCd = stwgCd;
        this.bkgOfcCd = bkgOfcCd;
        this.bkgContactPoint = bkgContactPoint;
        this.twnSoNo = twnSoNo;
        this.blckStwgCd = blckStwgCd;
        this.mtyPkupDate = mtyPkupDate;
        this.mtyPkupDate1 = mtyPkupDate1;
        this.mtyPkupYdCd1 = mtyPkupYdCd1;
        this.fullReturnYardCountry = fullReturnYardCountry;
        this.fullRtnYdCd = fullRtnYdCd;
        this.fullReturnYardName = fullReturnYardName;
        this.stowRemark = stowRemark;
        this.custRefNoCtnt = custRefNoCtnt;
        this.skdDirCdT = skdDirCdT;
        this.mtyPkupYdCdT = mtyPkupYdCdT;
        this.vvdLloydNo = vvdLloydNo;
        this.vvdCallSign = vvdCallSign;
        this.consVoy = consVoy;
        this.scNo = scNo;
        this.rfaNo = rfaNo;
		this.taaNo = taaNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
        this.hashColumns.put("status", getStatus());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("slan_cd1", getSlanCd1());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vvd1lloyd_no", getVvd1LloydNo());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("vvd1call_sign", getVvd1CallSign());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("vsl_cd1", getVslCd1());
        this.hashColumns.put("trunk_vessel_lloyd_no", getTrunkVesselLloydNo());
        this.hashColumns.put("vsl_eng_nm1", getVslEngNm1());
        this.hashColumns.put("trunk_vessel_call_sign", getTrunkVesselCallSign());
        this.hashColumns.put("skd_voy_no1", getSkdVoyNo1());
        this.hashColumns.put("skd_dir_cd2", getSkdDirCd2());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("por_opscode", getPorOpscode());
        this.hashColumns.put("un_loc_cd", getUnLocCd());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("loc_nm1", getLocNm1());
        this.hashColumns.put("un_loc_cd1", getUnLocCd1());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("vps_eta_dt1", getVpsEtaDt1());
        this.hashColumns.put("vps_etd_dt1", getVpsEtdDt1());
        this.hashColumns.put("cut_off_time_first_pol", getCutOffTimeFirstPol());
        this.hashColumns.put("loc_nm2", getLocNm2());
        this.hashColumns.put("un_loc_cd2", getUnLocCd2());
        this.hashColumns.put("del_opus_code", getDelOpusCode());
        this.hashColumns.put("loc_nm3", getLocNm3());
        this.hashColumns.put("un_loc_cd3", getUnLocCd3());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("xter_rmk", getXterRmk());
        this.hashColumns.put("vndr_rmk", getVndrRmk());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cust_nm1", getCustNm1());
        this.hashColumns.put("cust_nm2", getCustNm2());
        this.hashColumns.put("cust_cnt_cd1", getCustCntCd1());
        this.hashColumns.put("cust_cnt_cd2", getCustCntCd2());
        this.hashColumns.put("cust_cnt_cd3", getCustCntCd3());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("stwg_rmk", getStwgRmk());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("bkg_contact_point", getBkgContactPoint());
        this.hashColumns.put("twn_so_no", getTwnSoNo());
        this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
        this.hashColumns.put("mty_pkup_date", getMtyPkupDate());
        this.hashColumns.put("mty_pkup_date1", getMtyPkupDate1());
        this.hashColumns.put("mty_pkup_yd_cd1", getMtyPkupYdCd1());
        this.hashColumns.put("full_return_yard_country", getFullReturnYardCountry());
        this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
        this.hashColumns.put("full_return_yard_name", getFullReturnYardName());
        this.hashColumns.put("stow_remark", getStowRemark());
        this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
        this.hashColumns.put("skd_dir_cd_t", getSkdDirCdT());
        this.hashColumns.put("mty_pkup_yd_cd_t", getMtyPkupYdCdT());
        this.hashColumns.put("vvd_lloyd_no", getVvdLloydNo());
        this.hashColumns.put("vvd_call_sign", getVvdCallSign());
        this.hashColumns.put("cons_voy", getConsVoy());
        this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("taa_no", getTaaNo());
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
        this.hashFields.put("bkg_cre_dt", "bkgCreDt");
        this.hashFields.put("status", "status");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("slan_cd1", "slanCd1");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vvd1lloyd_no", "vvd1LloydNo");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("vvd1call_sign", "vvd1CallSign");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("vsl_cd1", "vslCd1");
        this.hashFields.put("trunk_vessel_lloyd_no", "trunkVesselLloydNo");
        this.hashFields.put("vsl_eng_nm1", "vslEngNm1");
        this.hashFields.put("trunk_vessel_call_sign", "trunkVesselCallSign");
        this.hashFields.put("skd_voy_no1", "skdVoyNo1");
        this.hashFields.put("skd_dir_cd2", "skdDirCd2");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("por_opscode", "porOpscode");
        this.hashFields.put("un_loc_cd", "unLocCd");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("loc_nm1", "locNm1");
        this.hashFields.put("un_loc_cd1", "unLocCd1");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("vps_eta_dt1", "vpsEtaDt1");
        this.hashFields.put("vps_etd_dt1", "vpsEtdDt1");
        this.hashFields.put("cut_off_time_first_pol", "cutOffTimeFirstPol");
        this.hashFields.put("loc_nm2", "locNm2");
        this.hashFields.put("un_loc_cd2", "unLocCd2");
        this.hashFields.put("del_opus_code", "delOpusCode");
        this.hashFields.put("loc_nm3", "locNm3");
        this.hashFields.put("un_loc_cd3", "unLocCd3");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("xter_rmk", "xterRmk");
        this.hashFields.put("vndr_rmk", "vndrRmk");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cust_nm1", "custNm1");
        this.hashFields.put("cust_nm2", "custNm2");
        this.hashFields.put("cust_cnt_cd1", "custCntCd1");
        this.hashFields.put("cust_cnt_cd2", "custCntCd2");
        this.hashFields.put("cust_cnt_cd3", "custCntCd3");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("stwg_rmk", "stwgRmk");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("bkg_contact_point", "bkgContactPoint");
        this.hashFields.put("twn_so_no", "twnSoNo");
        this.hashFields.put("blck_stwg_cd", "blckStwgCd");
        this.hashFields.put("mty_pkup_date", "mtyPkupDate");
        this.hashFields.put("mty_pkup_date1", "mtyPkupDate1");
        this.hashFields.put("mty_pkup_yd_cd1", "mtyPkupYdCd1");
        this.hashFields.put("full_return_yard_country", "fullReturnYardCountry");
        this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
        this.hashFields.put("full_return_yard_name", "fullReturnYardName");
        this.hashFields.put("stow_remark", "stowRemark");
        this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
        this.hashFields.put("skd_dir_cd_t", "skdDirCdT");
        this.hashFields.put("mty_pkup_yd_cd_t", "mtyPkupYdCdT");
        this.hashFields.put("vvd_lloyd_no", "vvdLloydNo");
        this.hashFields.put("vvd_call_sign", "vvdCallSign");
        this.hashFields.put("cons_voy", "consVoy");
        this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("taa_no", "taaNo");
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
	 * @param String bkgCreDt
	 */
    public void setBkgCreDt(String bkgCreDt) {
        this.bkgCreDt = bkgCreDt;
    }

    /**
	 * 
	 * @return String bkgCreDt
	 */
    public String getBkgCreDt() {
        return this.bkgCreDt;
    }

    /**
	 *
	 * @param String status
	 */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
	 * 
	 * @return String status
	 */
    public String getStatus() {
        return this.status;
    }

    /**
	 *
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 *
	 * @param String slanCd1
	 */
    public void setSlanCd1(String slanCd1) {
        this.slanCd1 = slanCd1;
    }

    /**
	 * 
	 * @return String slanCd1
	 */
    public String getSlanCd1() {
        return this.slanCd1;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String vvd1LloydNo
	 */
    public void setVvd1LloydNo(String vvd1LloydNo) {
        this.vvd1LloydNo = vvd1LloydNo;
    }

    /**
	 * 
	 * @return String vvd1LloydNo
	 */
    public String getVvd1LloydNo() {
        return this.vvd1LloydNo;
    }

    /**
	 *
	 * @param String vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * 
	 * @return String vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 *
	 * @param String vvd1CallSign
	 */
    public void setVvd1CallSign(String vvd1CallSign) {
        this.vvd1CallSign = vvd1CallSign;
    }

    /**
	 * 
	 * @return String vvd1CallSign
	 */
    public String getVvd1CallSign() {
        return this.vvd1CallSign;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String vpsEtdDt
	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * 
	 * @return String vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 *
	 * @param String vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * 
	 * @return String vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 *
	 * @param String vslCd1
	 */
    public void setVslCd1(String vslCd1) {
        this.vslCd1 = vslCd1;
    }

    /**
	 * 
	 * @return String vslCd1
	 */
    public String getVslCd1() {
        return this.vslCd1;
    }

    /**
	 *
	 * @param String trunkVesselLloydNo
	 */
    public void setTrunkVesselLloydNo(String trunkVesselLloydNo) {
        this.trunkVesselLloydNo = trunkVesselLloydNo;
    }

    /**
	 * 
	 * @return String trunkVesselLloydNo
	 */
    public String getTrunkVesselLloydNo() {
        return this.trunkVesselLloydNo;
    }

    /**
	 *
	 * @param String vslEngNm1
	 */
    public void setVslEngNm1(String vslEngNm1) {
        this.vslEngNm1 = vslEngNm1;
    }

    /**
	 * 
	 * @return String vslEngNm1
	 */
    public String getVslEngNm1() {
        return this.vslEngNm1;
    }

    /**
	 *
	 * @param String trunkVesselCallSign
	 */
    public void setTrunkVesselCallSign(String trunkVesselCallSign) {
        this.trunkVesselCallSign = trunkVesselCallSign;
    }

    /**
	 * 
	 * @return String trunkVesselCallSign
	 */
    public String getTrunkVesselCallSign() {
        return this.trunkVesselCallSign;
    }

    /**
	 *
	 * @param String skdVoyNo1
	 */
    public void setSkdVoyNo1(String skdVoyNo1) {
        this.skdVoyNo1 = skdVoyNo1;
    }

    /**
	 * 
	 * @return String skdVoyNo1
	 */
    public String getSkdVoyNo1() {
        return this.skdVoyNo1;
    }

    /**
	 *
	 * @param String skdDirCd2
	 */
    public void setSkdDirCd2(String skdDirCd2) {
        this.skdDirCd2 = skdDirCd2;
    }

    /**
	 * 
	 * @return String skdDirCd2
	 */
    public String getSkdDirCd2() {
        return this.skdDirCd2;
    }

    /**
	 *
	 * @param String locNm
	 */
    public void setLocNm(String locNm) {
        this.locNm = locNm;
    }

    /**
	 * 
	 * @return String locNm
	 */
    public String getLocNm() {
        return this.locNm;
    }

    /**
	 *
	 * @param String porOpscode
	 */
    public void setPorOpscode(String porOpscode) {
        this.porOpscode = porOpscode;
    }

    /**
	 * 
	 * @return String porOpscode
	 */
    public String getPorOpscode() {
        return this.porOpscode;
    }

    /**
	 *
	 * @param String unLocCd
	 */
    public void setUnLocCd(String unLocCd) {
        this.unLocCd = unLocCd;
    }

    /**
	 * 
	 * @return String unLocCd
	 */
    public String getUnLocCd() {
        return this.unLocCd;
    }

    /**
	 *
	 * @param String porNodCd
	 */
    public void setPorNodCd(String porNodCd) {
        this.porNodCd = porNodCd;
    }

    /**
	 * 
	 * @return String porNodCd
	 */
    public String getPorNodCd() {
        return this.porNodCd;
    }

    /**
	 *
	 * @param String locNm1
	 */
    public void setLocNm1(String locNm1) {
        this.locNm1 = locNm1;
    }

    /**
	 * 
	 * @return String locNm1
	 */
    public String getLocNm1() {
        return this.locNm1;
    }

    /**
	 *
	 * @param String unLocCd1
	 */
    public void setUnLocCd1(String unLocCd1) {
        this.unLocCd1 = unLocCd1;
    }

    /**
	 * 
	 * @return String unLocCd1
	 */
    public String getUnLocCd1() {
        return this.unLocCd1;
    }

    /**
	 *
	 * @param String polNodCd
	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * 
	 * @return String polNodCd
	 */
    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 *
	 * @param String vpsEtaDt1
	 */
    public void setVpsEtaDt1(String vpsEtaDt1) {
        this.vpsEtaDt1 = vpsEtaDt1;
    }

    /**
	 * 
	 * @return String vpsEtaDt1
	 */
    public String getVpsEtaDt1() {
        return this.vpsEtaDt1;
    }

    /**
	 *
	 * @param String vpsEtdDt1
	 */
    public void setVpsEtdDt1(String vpsEtdDt1) {
        this.vpsEtdDt1 = vpsEtdDt1;
    }

    /**
	 * 
	 * @return String vpsEtdDt1
	 */
    public String getVpsEtdDt1() {
        return this.vpsEtdDt1;
    }

    /**
	 *
	 * @param String cutOffTimeFirstPol
	 */
    public void setCutOffTimeFirstPol(String cutOffTimeFirstPol) {
        this.cutOffTimeFirstPol = cutOffTimeFirstPol;
    }

    /**
	 * 
	 * @return String cutOffTimeFirstPol
	 */
    public String getCutOffTimeFirstPol() {
        return this.cutOffTimeFirstPol;
    }

    /**
	 *
	 * @param String locNm2
	 */
    public void setLocNm2(String locNm2) {
        this.locNm2 = locNm2;
    }

    /**
	 * 
	 * @return String locNm2
	 */
    public String getLocNm2() {
        return this.locNm2;
    }

    /**
	 *
	 * @param String unLocCd2
	 */
    public void setUnLocCd2(String unLocCd2) {
        this.unLocCd2 = unLocCd2;
    }

    /**
	 * 
	 * @return String unLocCd2
	 */
    public String getUnLocCd2() {
        return this.unLocCd2;
    }

    /**
	 *
	 * @param String delOpusCode
	 */
    public void setDelOpusCode(String delOpusCode) {
        this.delOpusCode = delOpusCode;
    }

    /**
	 * 
	 * @return String delOpusCode
	 */
    public String getDelOpusCode() {
        return this.delOpusCode;
    }

    /**
	 *
	 * @param String locNm3
	 */
    public void setLocNm3(String locNm3) {
        this.locNm3 = locNm3;
    }

    /**
	 * 
	 * @return String locNm3
	 */
    public String getLocNm3() {
        return this.locNm3;
    }

    /**
	 *
	 * @param String unLocCd3
	 */
    public void setUnLocCd3(String unLocCd3) {
        this.unLocCd3 = unLocCd3;
    }

    /**
	 * 
	 * @return String unLocCd3
	 */
    public String getUnLocCd3() {
        return this.unLocCd3;
    }

    /**
	 *
	 * @param String rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * 
	 * @return String rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	 *
	 * @param String xterRmk
	 */
    public void setXterRmk(String xterRmk) {
        this.xterRmk = xterRmk;
    }

    /**
	 * 
	 * @return String xterRmk
	 */
    public String getXterRmk() {
        return this.xterRmk;
    }

    /**
	 *
	 * @param String vndrRmk
	 */
    public void setVndrRmk(String vndrRmk) {
        this.vndrRmk = vndrRmk;
    }

    /**
	 * 
	 * @return String vndrRmk
	 */
    public String getVndrRmk() {
        return this.vndrRmk;
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
	 * @param String cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * 
	 * @return String cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 *
	 * @param String mtyPkupYdCd
	 */
    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    /**
	 * 
	 * @return String mtyPkupYdCd
	 */
    public String getMtyPkupYdCd() {
        return this.mtyPkupYdCd;
    }

    /**
	 *
	 * @param String custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * 
	 * @return String custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 *
	 * @param String custNm1
	 */
    public void setCustNm1(String custNm1) {
        this.custNm1 = custNm1;
    }

    /**
	 * 
	 * @return String custNm1
	 */
    public String getCustNm1() {
        return this.custNm1;
    }

    /**
	 *
	 * @param String custNm2
	 */
    public void setCustNm2(String custNm2) {
        this.custNm2 = custNm2;
    }

    /**
	 * 
	 * @return String custNm2
	 */
    public String getCustNm2() {
        return this.custNm2;
    }

    /**
	 *
	 * @param String custCntCd1
	 */
    public void setCustCntCd1(String custCntCd1) {
        this.custCntCd1 = custCntCd1;
    }

    /**
	 * 
	 * @return String custCntCd1
	 */
    public String getCustCntCd1() {
        return this.custCntCd1;
    }

    /**
	 *
	 * @param String custCntCd2
	 */
    public void setCustCntCd2(String custCntCd2) {
        this.custCntCd2 = custCntCd2;
    }

    /**
	 * 
	 * @return String custCntCd2
	 */
    public String getCustCntCd2() {
        return this.custCntCd2;
    }

    /**
	 *
	 * @param String custCntCd3
	 */
    public void setCustCntCd3(String custCntCd3) {
        this.custCntCd3 = custCntCd3;
    }

    /**
	 * 
	 * @return String custCntCd3
	 */
    public String getCustCntCd3() {
        return this.custCntCd3;
    }

    /**
	 *
	 * @param String bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * 
	 * @return String bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 *
	 * @param String rdCgoFlg
	 */
    public void setRdCgoFlg(String rdCgoFlg) {
        this.rdCgoFlg = rdCgoFlg;
    }

    /**
	 * 
	 * @return String rdCgoFlg
	 */
    public String getRdCgoFlg() {
        return this.rdCgoFlg;
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
	 * @param String hngrFlg
	 */
    public void setHngrFlg(String hngrFlg) {
        this.hngrFlg = hngrFlg;
    }

    /**
	 * 
	 * @return String hngrFlg
	 */
    public String getHngrFlg() {
        return this.hngrFlg;
    }

    /**
	 *
	 * @param String stwgRmk
	 */
    public void setStwgRmk(String stwgRmk) {
        this.stwgRmk = stwgRmk;
    }

    /**
	 * 
	 * @return String stwgRmk
	 */
    public String getStwgRmk() {
        return this.stwgRmk;
    }

    /**
	 *
	 * @param String stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    /**
	 * 
	 * @return String stwgCd
	 */
    public String getStwgCd() {
        return this.stwgCd;
    }

    /**
	 *
	 * @param String bkgOfcCd
	 */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
    }

    /**
	 * 
	 * @return String bkgOfcCd
	 */
    public String getBkgOfcCd() {
        return this.bkgOfcCd;
    }

    /**
	 *
	 * @param String bkgContactPoint
	 */
    public void setBkgContactPoint(String bkgContactPoint) {
        this.bkgContactPoint = bkgContactPoint;
    }

    /**
	 * 
	 * @return String bkgContactPoint
	 */
    public String getBkgContactPoint() {
        return this.bkgContactPoint;
    }

    /**
	 *
	 * @param String twnSoNo
	 */
    public void setTwnSoNo(String twnSoNo) {
        this.twnSoNo = twnSoNo;
    }

    /**
	 * 
	 * @return String twnSoNo
	 */
    public String getTwnSoNo() {
        return this.twnSoNo;
    }

    /**
	 *
	 * @param String blckStwgCd
	 */
    public void setBlckStwgCd(String blckStwgCd) {
        this.blckStwgCd = blckStwgCd;
    }

    /**
	 * 
	 * @return String blckStwgCd
	 */
    public String getBlckStwgCd() {
        return this.blckStwgCd;
    }

    /**
	 *
	 * @param String mtyPkupDate
	 */
    public void setMtyPkupDate(String mtyPkupDate) {
        this.mtyPkupDate = mtyPkupDate;
    }

    /**
	 * 
	 * @return String mtyPkupDate
	 */
    public String getMtyPkupDate() {
        return this.mtyPkupDate;
    }

    /**
	 *
	 * @param String mtyPkupDate1
	 */
    public void setMtyPkupDate1(String mtyPkupDate1) {
        this.mtyPkupDate1 = mtyPkupDate1;
    }

    /**
	 * 
	 * @return String mtyPkupDate1
	 */
    public String getMtyPkupDate1() {
        return this.mtyPkupDate1;
    }

    /**
	 *
	 * @param String mtyPkupYdCd1
	 */
    public void setMtyPkupYdCd1(String mtyPkupYdCd1) {
        this.mtyPkupYdCd1 = mtyPkupYdCd1;
    }

    /**
	 * 
	 * @return String mtyPkupYdCd1
	 */
    public String getMtyPkupYdCd1() {
        return this.mtyPkupYdCd1;
    }

    /**
	 *
	 * @param String fullReturnYardCountry
	 */
    public void setFullReturnYardCountry(String fullReturnYardCountry) {
        this.fullReturnYardCountry = fullReturnYardCountry;
    }

    /**
	 * 
	 * @return String fullReturnYardCountry
	 */
    public String getFullReturnYardCountry() {
        return this.fullReturnYardCountry;
    }

    /**
	 *
	 * @param String fullRtnYdCd
	 */
    public void setFullRtnYdCd(String fullRtnYdCd) {
        this.fullRtnYdCd = fullRtnYdCd;
    }

    /**
	 * 
	 * @return String fullRtnYdCd
	 */
    public String getFullRtnYdCd() {
        return this.fullRtnYdCd;
    }

    /**
	 *
	 * @param String fullReturnYardName
	 */
    public void setFullReturnYardName(String fullReturnYardName) {
        this.fullReturnYardName = fullReturnYardName;
    }

    /**
	 * 
	 * @return String fullReturnYardName
	 */
    public String getFullReturnYardName() {
        return this.fullReturnYardName;
    }

    /**
	 *
	 * @param String stowRemark
	 */
    public void setStowRemark(String stowRemark) {
        this.stowRemark = stowRemark;
    }

    /**
	 * 
	 * @return String stowRemark
	 */
    public String getStowRemark() {
        return this.stowRemark;
    }

    /**
	 *
	 * @param String custRefNoCtnt
	 */
    public void setCustRefNoCtnt(String custRefNoCtnt) {
        this.custRefNoCtnt = custRefNoCtnt;
    }

    /**
	 * 
	 * @return String custRefNoCtnt
	 */
    public String getCustRefNoCtnt() {
        return this.custRefNoCtnt;
    }

    public void setSkdDirCdT(String skdDirCdT) {
        this.skdDirCdT = skdDirCdT;
    }

    public String getSkdDirCdT() {
        return this.skdDirCdT;
    }

    public void setMtyPkupYdCdT(String mtyPkupYdCdT) {
        this.mtyPkupYdCdT = mtyPkupYdCdT;
    }

    public String getMtyPkupYdCdT() {
        return this.mtyPkupYdCdT;
    }

    public void setVvdLloydNo(String vvdLloydNo) {
        this.vvdLloydNo = vvdLloydNo;
    }

    public String getVvdLloydNo() {
        return this.vvdLloydNo;
    }

    public void setVvdCallSign(String vvdCallSign) {
        this.vvdCallSign = vvdCallSign;
    }

    public String getVvdCallSign() {
        return this.vvdCallSign;
    }

    public void setConsVoy(String consVoy) {
        this.consVoy = consVoy;
    }

    public String getConsVoy() {
        return this.consVoy;
    }

    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    public String getScNo() {
        return this.scNo;
    }

	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}

	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
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
        setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
        setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setSlanCd1(JSPUtil.getParameter(request, prefix + "slan_cd1", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVvd1LloydNo(JSPUtil.getParameter(request, prefix + "vvd1lloyd_no", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setVvd1CallSign(JSPUtil.getParameter(request, prefix + "vvd1call_sign", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setVslCd1(JSPUtil.getParameter(request, prefix + "vsl_cd1", ""));
        setTrunkVesselLloydNo(JSPUtil.getParameter(request, prefix + "trunk_vessel_lloyd_no", ""));
        setVslEngNm1(JSPUtil.getParameter(request, prefix + "vsl_eng_nm1", ""));
        setTrunkVesselCallSign(JSPUtil.getParameter(request, prefix + "trunk_vessel_call_sign", ""));
        setSkdVoyNo1(JSPUtil.getParameter(request, prefix + "skd_voy_no1", ""));
        setSkdDirCd2(JSPUtil.getParameter(request, prefix + "skd_dir_cd2", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setPorOpscode(JSPUtil.getParameter(request, prefix + "por_opscode", ""));
        setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setLocNm1(JSPUtil.getParameter(request, prefix + "loc_nm1", ""));
        setUnLocCd1(JSPUtil.getParameter(request, prefix + "un_loc_cd1", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setVpsEtaDt1(JSPUtil.getParameter(request, prefix + "vps_eta_dt1", ""));
        setVpsEtdDt1(JSPUtil.getParameter(request, prefix + "vps_etd_dt1", ""));
        setCutOffTimeFirstPol(JSPUtil.getParameter(request, prefix + "cut_off_time_first_pol", ""));
        setLocNm2(JSPUtil.getParameter(request, prefix + "loc_nm2", ""));
        setUnLocCd2(JSPUtil.getParameter(request, prefix + "un_loc_cd2", ""));
        setDelOpusCode(JSPUtil.getParameter(request, prefix + "del_opus_code", ""));
        setLocNm3(JSPUtil.getParameter(request, prefix + "loc_nm3", ""));
        setUnLocCd3(JSPUtil.getParameter(request, prefix + "un_loc_cd3", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
        setVndrRmk(JSPUtil.getParameter(request, prefix + "vndr_rmk", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCustNm1(JSPUtil.getParameter(request, prefix + "cust_nm1", ""));
        setCustNm2(JSPUtil.getParameter(request, prefix + "cust_nm2", ""));
        setCustCntCd1(JSPUtil.getParameter(request, prefix + "cust_cnt_cd1", ""));
        setCustCntCd2(JSPUtil.getParameter(request, prefix + "cust_cnt_cd2", ""));
        setCustCntCd3(JSPUtil.getParameter(request, prefix + "cust_cnt_cd3", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setStwgRmk(JSPUtil.getParameter(request, prefix + "stwg_rmk", ""));
        setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setBkgContactPoint(JSPUtil.getParameter(request, prefix + "bkg_contact_point", ""));
        setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
        setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
        setMtyPkupDate(JSPUtil.getParameter(request, prefix + "mty_pkup_date", ""));
        setMtyPkupDate1(JSPUtil.getParameter(request, prefix + "mty_pkup_date1", ""));
        setMtyPkupYdCd1(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd1", ""));
        setFullReturnYardCountry(JSPUtil.getParameter(request, prefix + "full_return_yard_country", ""));
        setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
        setFullReturnYardName(JSPUtil.getParameter(request, prefix + "full_return_yard_name", ""));
        setStowRemark(JSPUtil.getParameter(request, prefix + "stow_remark", ""));
        setCustRefNoCtnt(JSPUtil.getParameter(request, prefix + "cust_ref_no_ctnt", ""));
        setSkdDirCdT(JSPUtil.getParameter(request, prefix + "skd_dir_cd_t", ""));
        setMtyPkupYdCdT(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd_t", ""));
        setVvdLloydNo(JSPUtil.getParameter(request, prefix + "vvd_lloyd_no", ""));
        setVvdCallSign(JSPUtil.getParameter(request, prefix + "vvd_call_sign", ""));
        setConsVoy(JSPUtil.getParameter(request, prefix + "cons_voy", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelBkgRoot[]
	 */
    public MtyRlseOrdExcelBkgRootVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelBkgRoot[]
	 */
    public MtyRlseOrdExcelBkgRootVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MtyRlseOrdExcelBkgRootVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] bkgCreDt = (JSPUtil.getParameter(request, prefix + "bkg_cre_dt", length));
            String[] status = (JSPUtil.getParameter(request, prefix + "status", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] slanCd1 = (JSPUtil.getParameter(request, prefix + "slan_cd1", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vvd1LloydNo = (JSPUtil.getParameter(request, prefix + "vvd1lloyd_no", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] vvd1CallSign = (JSPUtil.getParameter(request, prefix + "vvd1call_sign", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] vslCd1 = (JSPUtil.getParameter(request, prefix + "vsl_cd1", length));
            String[] trunkVesselLloydNo = (JSPUtil.getParameter(request, prefix + "trunk_vessel_lloyd_no", length));
            String[] vslEngNm1 = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm1", length));
            String[] trunkVesselCallSign = (JSPUtil.getParameter(request, prefix + "trunk_vessel_call_sign", length));
            String[] skdVoyNo1 = (JSPUtil.getParameter(request, prefix + "skd_voy_no1", length));
            String[] skdDirCd2 = (JSPUtil.getParameter(request, prefix + "skd_dir_cd2", length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm", length));
            String[] porOpscode = (JSPUtil.getParameter(request, prefix + "por_opscode", length));
            String[] unLocCd = (JSPUtil.getParameter(request, prefix + "un_loc_cd", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] locNm1 = (JSPUtil.getParameter(request, prefix + "loc_nm1", length));
            String[] unLocCd1 = (JSPUtil.getParameter(request, prefix + "un_loc_cd1", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] vpsEtaDt1 = (JSPUtil.getParameter(request, prefix + "vps_eta_dt1", length));
            String[] vpsEtdDt1 = (JSPUtil.getParameter(request, prefix + "vps_etd_dt1", length));
            String[] cutOffTimeFirstPol = (JSPUtil.getParameter(request, prefix + "cut_off_time_first_pol", length));
            String[] locNm2 = (JSPUtil.getParameter(request, prefix + "loc_nm2", length));
            String[] unLocCd2 = (JSPUtil.getParameter(request, prefix + "un_loc_cd2", length));
            String[] delOpusCode = (JSPUtil.getParameter(request, prefix + "del_opus_code", length));
            String[] locNm3 = (JSPUtil.getParameter(request, prefix + "loc_nm3", length));
            String[] unLocCd3 = (JSPUtil.getParameter(request, prefix + "un_loc_cd3", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] xterRmk = (JSPUtil.getParameter(request, prefix + "xter_rmk", length));
            String[] vndrRmk = (JSPUtil.getParameter(request, prefix + "vndr_rmk", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] custNm1 = (JSPUtil.getParameter(request, prefix + "cust_nm1", length));
            String[] custNm2 = (JSPUtil.getParameter(request, prefix + "cust_nm2", length));
            String[] custCntCd1 = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd1", length));
            String[] custCntCd2 = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd2", length));
            String[] custCntCd3 = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd3", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] stwgRmk = (JSPUtil.getParameter(request, prefix + "stwg_rmk", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] bkgContactPoint = (JSPUtil.getParameter(request, prefix + "bkg_contact_point", length));
            String[] twnSoNo = (JSPUtil.getParameter(request, prefix + "twn_so_no", length));
            String[] blckStwgCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_cd", length));
            String[] mtyPkupDate = (JSPUtil.getParameter(request, prefix + "mty_pkup_date", length));
            String[] mtyPkupDate1 = (JSPUtil.getParameter(request, prefix + "mty_pkup_date1", length));
            String[] mtyPkupYdCd1 = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd1", length));
            String[] fullReturnYardCountry = (JSPUtil.getParameter(request, prefix + "full_return_yard_country", length));
            String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", length));
            String[] fullReturnYardName = (JSPUtil.getParameter(request, prefix + "full_return_yard_name", length));
            String[] stowRemark = (JSPUtil.getParameter(request, prefix + "stow_remark", length));
            String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix + "cust_ref_no_ctnt", length));
            String[] skdDirCdT = (JSPUtil.getParameter(request, prefix + "skd_dir_cd_t", length));
            String[] mtyPkupYdCdT = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd_t", length));
            String[] vvdLloydNo = (JSPUtil.getParameter(request, prefix + "vvd_lloyd_no", length));
            String[] vvdCallSign = (JSPUtil.getParameter(request, prefix + "vvd_call_sign", length));
            String[] consVoy = (JSPUtil.getParameter(request, prefix + "cons_voy", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MtyRlseOrdExcelBkgRootVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (bkgCreDt[i] != null)
                    model.setBkgCreDt(bkgCreDt[i]);
                if (status[i] != null)
                    model.setStatus(status[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (slanCd1[i] != null)
                    model.setSlanCd1(slanCd1[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vvd1LloydNo[i] != null)
                    model.setVvd1LloydNo(vvd1LloydNo[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (vvd1CallSign[i] != null)
                    model.setVvd1CallSign(vvd1CallSign[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (vslCd1[i] != null)
                    model.setVslCd1(vslCd1[i]);
                if (trunkVesselLloydNo[i] != null)
                    model.setTrunkVesselLloydNo(trunkVesselLloydNo[i]);
                if (vslEngNm1[i] != null)
                    model.setVslEngNm1(vslEngNm1[i]);
                if (trunkVesselCallSign[i] != null)
                    model.setTrunkVesselCallSign(trunkVesselCallSign[i]);
                if (skdVoyNo1[i] != null)
                    model.setSkdVoyNo1(skdVoyNo1[i]);
                if (skdDirCd2[i] != null)
                    model.setSkdDirCd2(skdDirCd2[i]);
                if (locNm[i] != null)
                    model.setLocNm(locNm[i]);
                if (porOpscode[i] != null)
                    model.setPorOpscode(porOpscode[i]);
                if (unLocCd[i] != null)
                    model.setUnLocCd(unLocCd[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (locNm1[i] != null)
                    model.setLocNm1(locNm1[i]);
                if (unLocCd1[i] != null)
                    model.setUnLocCd1(unLocCd1[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (vpsEtaDt1[i] != null)
                    model.setVpsEtaDt1(vpsEtaDt1[i]);
                if (vpsEtdDt1[i] != null)
                    model.setVpsEtdDt1(vpsEtdDt1[i]);
                if (cutOffTimeFirstPol[i] != null)
                    model.setCutOffTimeFirstPol(cutOffTimeFirstPol[i]);
                if (locNm2[i] != null)
                    model.setLocNm2(locNm2[i]);
                if (unLocCd2[i] != null)
                    model.setUnLocCd2(unLocCd2[i]);
                if (delOpusCode[i] != null)
                    model.setDelOpusCode(delOpusCode[i]);
                if (locNm3[i] != null)
                    model.setLocNm3(locNm3[i]);
                if (unLocCd3[i] != null)
                    model.setUnLocCd3(unLocCd3[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (xterRmk[i] != null)
                    model.setXterRmk(xterRmk[i]);
                if (vndrRmk[i] != null)
                    model.setVndrRmk(vndrRmk[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (mtyPkupYdCd[i] != null)
                    model.setMtyPkupYdCd(mtyPkupYdCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (custNm1[i] != null)
                    model.setCustNm1(custNm1[i]);
                if (custNm2[i] != null)
                    model.setCustNm2(custNm2[i]);
                if (custCntCd1[i] != null)
                    model.setCustCntCd1(custCntCd1[i]);
                if (custCntCd2[i] != null)
                    model.setCustCntCd2(custCntCd2[i]);
                if (custCntCd3[i] != null)
                    model.setCustCntCd3(custCntCd3[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (hngrFlg[i] != null)
                    model.setHngrFlg(hngrFlg[i]);
                if (stwgRmk[i] != null)
                    model.setStwgRmk(stwgRmk[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (bkgContactPoint[i] != null)
                    model.setBkgContactPoint(bkgContactPoint[i]);
                if (twnSoNo[i] != null)
                    model.setTwnSoNo(twnSoNo[i]);
                if (blckStwgCd[i] != null)
                    model.setBlckStwgCd(blckStwgCd[i]);
                if (mtyPkupDate[i] != null)
                    model.setMtyPkupDate(mtyPkupDate[i]);
                if (mtyPkupDate1[i] != null)
                    model.setMtyPkupDate1(mtyPkupDate1[i]);
                if (mtyPkupYdCd1[i] != null)
                    model.setMtyPkupYdCd1(mtyPkupYdCd1[i]);
                if (fullReturnYardCountry[i] != null)
                    model.setFullReturnYardCountry(fullReturnYardCountry[i]);
                if (fullRtnYdCd[i] != null)
                    model.setFullRtnYdCd(fullRtnYdCd[i]);
                if (fullReturnYardName[i] != null)
                    model.setFullReturnYardName(fullReturnYardName[i]);
                if (stowRemark[i] != null)
                    model.setStowRemark(stowRemark[i]);
                if (custRefNoCtnt[i] != null)
                    model.setCustRefNoCtnt(custRefNoCtnt[i]);
                if (skdDirCdT[i] != null)
                    model.setSkdDirCdT(skdDirCdT[i]);
                if (mtyPkupYdCdT[i] != null)
                    model.setMtyPkupYdCdT(mtyPkupYdCdT[i]);
                if (vvdLloydNo[i] != null)
                    model.setVvdLloydNo(vvdLloydNo[i]);
                if (vvdCallSign[i] != null)
                    model.setVvdCallSign(vvdCallSign[i]);
                if (consVoy[i] != null) 
		    		model.setConsVoy(consVoy[i]);
                if (scNo[i] != null) 
		    		model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMtyRlseOrdExcelBkgRoots();
    }

    /**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelBkgRoot[]
	 */
    public MtyRlseOrdExcelBkgRootVO[] getMtyRlseOrdExcelBkgRoots() {
        MtyRlseOrdExcelBkgRootVO[] vos = (MtyRlseOrdExcelBkgRootVO[]) models.toArray(new MtyRlseOrdExcelBkgRootVO[models.size()]);
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
        this.bkgCreDt = this.bkgCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.status = this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd1 = this.slanCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd1LloydNo = this.vvd1LloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd1CallSign = this.vvd1CallSign.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd1 = this.vslCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkVesselLloydNo = this.trunkVesselLloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm1 = this.vslEngNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkVesselCallSign = this.trunkVesselCallSign.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo1 = this.skdVoyNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd2 = this.skdDirCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porOpscode = this.porOpscode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd = this.unLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm1 = this.locNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd1 = this.unLocCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt1 = this.vpsEtaDt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt1 = this.vpsEtdDt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cutOffTimeFirstPol = this.cutOffTimeFirstPol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm2 = this.locNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd2 = this.unLocCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delOpusCode = this.delOpusCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm3 = this.locNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd3 = this.unLocCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRmk = this.xterRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrRmk = this.vndrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm1 = this.custNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm2 = this.custNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd1 = this.custCntCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd2 = this.custCntCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd3 = this.custCntCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgRmk = this.stwgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgContactPoint = this.bkgContactPoint.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.twnSoNo = this.twnSoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupDate = this.mtyPkupDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupDate1 = this.mtyPkupDate1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd1 = this.mtyPkupYdCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullReturnYardCountry = this.fullReturnYardCountry.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullRtnYdCd = this.fullRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullReturnYardName = this.fullReturnYardName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stowRemark = this.stowRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRefNoCtnt = this.custRefNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCdT = this.skdDirCdT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCdT = this.mtyPkupYdCdT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdLloydNo = this.vvdLloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCallSign = this.vvdCallSign.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consVoy = this.consVoy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
