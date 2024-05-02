/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : XterRqstMstVO.java
 *@FileTitle : XterRqstMstVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.08.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.08.24  
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class XterRqstMstVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<XterRqstMstVO> models = new ArrayList<XterRqstMstVO>();

    /*	Column Info	*/
    private String xterChgArrFlg = null;

    /*	Column Info	*/
    private String blNoCtnt = null;

    /*	Column Info	*/
    private String tel = null;

    /*	Column Info	*/
    private String polNm = null;

    /*	Column Info	*/
    private String siMobile = null;

    /*	Column Info	*/
    private String autoNotification = null;

    /*	Column Info	*/
    private String departureDt = null;

    /*	Column Info	*/
    private String srepCd = null;

    /*	Column Info	*/
    private String docTpCd = null;

    /*	Column Info	*/
    private String pagerows = null;

    /*	Column Info	*/
    private String scRfa = null;

    /*	Column Info	*/
    private String ctrtNo = null;

    /*	Column Info	*/
    private String blIssDt = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String fnlDestNm = null;

    /*	Column Info	*/
    private String shCustSeq = null;

    /*	Column Info	*/
    private String hblKnt = null;

    /*	Column Info	*/
    private String returnDt = null;

    /*	Column Info	*/
    private String xterRqstAcptUsrId = null;

    /*	Column Info	*/
    private String bkgUpldStsNm = null;

    /*	Column Info	*/
    private String cndCstmsFileCd = null;

    /*	Column Info	*/
    private String custRefNo = null;

    /*	Column Info	*/
    private String xterAgnDpFlg = null;

    /*	Column Info	*/
    private String fax = null;

    /*	Column Info	*/
    private String awkCgoFlg = null;

    /*	Column Info	*/
    private String snaccsSplitNo = null;

    /*	Column Info	*/
    private String frtTermCd = null;

    /*	Column Info	*/
    private String delCd = null;

    /*	Column Info	*/
    private String estmWgtUtCd = null;

    /*	Column Info	*/
    private String usaCstmsFileCtnt = null;

    /*	Column Info	*/
    private String vvd = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String xterRqstAcptCd = null;

    /*	Column Info	*/
    private String porNm = null;

    /*	Column Info	*/
    private String shCustNm = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String cmdtDesc = null;

    /*	Column Info	*/
    private String rcvTerm = null;

    /*	Column Info	*/
    private String dlvTerm = null;

    /*	Column Info	*/
    private String xterListDpFlg = null;

    /*	Column Info	*/
    private String siTel = null;

    /*	Column Info	*/
    private String rcFlg = null;

    /*	Column Info	*/
    private String mobile = null;

    /*	Column Info	*/
    private String porCd = null;

    /*	Column Info	*/
    private String xterRqstViaNm = null;

    /*	Column Info	*/
    private String cntcEml = null;

    /*	Column Info	*/
    private String xterBkgRqstStsCd = null;

    /*	Column Info	*/
    private String ffCustSeq = null;

    /*	Column Info	*/
    private String bkgUpldStsCd = null;

    /*	Column Info	*/
    private String estmWgt = null;

    /*	Column Info	*/
    private String ibflag = null;

    /*	Column Info	*/
    private String ffCustNm = null;

    /*	Column Info	*/
    private String scacCd = null;

    /*	Column Info	*/
    private String cmdtCd = null;

    /*	Column Info	*/
    private String shCntCd = null;

    /*	Column Info	*/
    private String bbCgoFlg = null;

    /*	Column Info	*/
    private String dcgoFlg = null;

    /*	Column Info	*/
    private String xterRqstViaCd = null;

    /*	Column Info	*/
    private String alps = null;

    /*	Column Info	*/
    private String rmk = null;

    /*	Column Info	*/
    private String xterRqstAcptUsrNm = null;

    /*	Column Info	*/
    private String podNm = null;

    /*	Column Info	*/
    private String delNm = null;

    /*	Column Info	*/
    private String inclRtBlKnt = null;

    /*	Column Info	*/
    private String vslNm = null;

    /*	Column Info	*/
    private String xcldRtBlKnt = null;

    /*	Column Info	*/
    private String twnSoNo = null;

    /*	Column Info	*/
    private String socFlg = null;

    /*	Column Info	*/
    private String arrivalDt = null;

    /*	Column Info	*/
    private String blIssLocCd = null;

    /*	Column Info	*/
    private String wyBlFlg = null;

    /*	Column Info	*/
    private String ffCntCd = null;

    /*	Column Info	*/
    private String siCntcNm = null;

    /*	Column Info	*/
    private String cntcNm = null;

    /*	Column Info	*/
    private String xterRqstNo = null;

    /*	Column Info	*/
    private String siFax = null;

    /*	Column Info	*/
    private String siCntcEml = null;

    /*	Column Info	*/
    private String mtyPkupDt = null;

    /*	Column Info	*/
    private String troPkupDt = null;

    /*	Column Info	*/
    private String splitStsCd = null;

    /*	Column Info	*/
    private String nonNegoRtInclKnt = null;

    /*	Column Info	*/
    private String nonNegoRtXcldKnt = null;

    /*	Column Info	*/
    private String bkgRefNo = null;

    /*	Column Info	*/
    private String siRefNo = null;

    /*	Column Info	*/
    private String invRefNo = null;

    /*	Column Info	*/
    private String regBkgNo = null;

    /*	Column Info	*/
    private String extMrnNo = null;

    /*	Column Info	*/
    private String porYdCd = null;

    /*	Column Info	*/
    private String polYdCd = null;

    /*	Column Info	*/
    private String podYdCd = null;

    /*	Column Info	*/
    private String delYdCd = null;

    /*	Column Info	*/
    private String custId = null;

    /*	Column Info	*/
    private String flexHgtFlg = null;

    /*	Column Info	*/
    private String sysUpldFlg = null;

    /*	Column Info	*/
    private String siAudFlg = null;

    /*	Column Info	*/
    private String cmpbRtFlg = null;

    /*	Column Info	*/
    private String hndlOfcCd = null;

    /*	Column Info	*/
    private String spcCtrlrRmk = null;

    /* Column Info */
    private String bkgShRefNo = null;

    /* Column Info */
    private String bkgFfRefNo = null;

    /* Column Info */
    private String siShRefNo = null;

    /* Column Info */
    private String siFfRefNo = null;

    /* hashColumnInpo */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /* hashFildInpo	*/
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /**	Constructor	*/
    public XterRqstMstVO() {
    }

    public XterRqstMstVO(String xterChgArrFlg, String blNoCtnt, String tel, String polNm, String siMobile, String autoNotification, String departureDt, String srepCd, String docTpCd, String pagerows, String scRfa, String ctrtNo, String blIssDt, String polCd, String fnlDestNm, String shCustSeq, String hblKnt, String returnDt, String xterRqstAcptUsrId, String bkgUpldStsNm, String cndCstmsFileCd, String custRefNo, String xterAgnDpFlg, String fax, String awkCgoFlg, String snaccsSplitNo, String frtTermCd, String delCd, String estmWgtUtCd, String usaCstmsFileCtnt, String vvd, String podCd, String xterRqstAcptCd, String porNm, String shCustNm, String bkgNo, String cmdtDesc, String rcvTerm, String dlvTerm, String xterListDpFlg, String siTel, String rcFlg, String mobile, String porCd, String xterRqstViaNm, String cntcEml, String xterBkgRqstStsCd, String ffCustSeq, String bkgUpldStsCd, String estmWgt, String ibflag, String ffCustNm, String scacCd, String cmdtCd, String shCntCd, String bbCgoFlg, String dcgoFlg, String xterRqstViaCd, String alps, String rmk, String xterRqstAcptUsrNm, String podNm, String delNm, String inclRtBlKnt, String vslNm, String xcldRtBlKnt, String twnSoNo, String socFlg, String arrivalDt, String blIssLocCd, String wyBlFlg, String ffCntCd, String siCntcNm, String cntcNm, String xterRqstNo, String siFax, String siCntcEml, String mtyPkupDt, String troPkupDt, String splitStsCd, String nonNegoRtInclKnt, String nonNegoRtXcldKnt, String bkgRefNo, String siRefNo, String invRefNo, String regBkgNo, String extMrnNo, String porYdCd, String polYdCd, String podYdCd, String delYdCd, String custId, String flexHgtFlg, String sysUpldFlg, String siAudFlg, String cmpbRtFlg, String hndlOfcCd, String spcCtrlrRmk, String bkgShRefNo, String bkgFfRefNo, String siShRefNo, String siFfRefNo) {
        this.xterChgArrFlg = xterChgArrFlg;
        this.blNoCtnt = blNoCtnt;
        this.tel = tel;
        this.polNm = polNm;
        this.siMobile = siMobile;
        this.autoNotification = autoNotification;
        this.departureDt = departureDt;
        this.srepCd = srepCd;
        this.docTpCd = docTpCd;
        this.pagerows = pagerows;
        this.scRfa = scRfa;
        this.ctrtNo = ctrtNo;
        this.blIssDt = blIssDt;
        this.polCd = polCd;
        this.fnlDestNm = fnlDestNm;
        this.shCustSeq = shCustSeq;
        this.hblKnt = hblKnt;
        this.returnDt = returnDt;
        this.xterRqstAcptUsrId = xterRqstAcptUsrId;
        this.bkgUpldStsNm = bkgUpldStsNm;
        this.cndCstmsFileCd = cndCstmsFileCd;
        this.custRefNo = custRefNo;
        this.xterAgnDpFlg = xterAgnDpFlg;
        this.fax = fax;
        this.awkCgoFlg = awkCgoFlg;
        this.snaccsSplitNo = snaccsSplitNo;
        this.frtTermCd = frtTermCd;
        this.delCd = delCd;
        this.estmWgtUtCd = estmWgtUtCd;
        this.usaCstmsFileCtnt = usaCstmsFileCtnt;
        this.vvd = vvd;
        this.podCd = podCd;
        this.xterRqstAcptCd = xterRqstAcptCd;
        this.porNm = porNm;
        this.shCustNm = shCustNm;
        this.bkgNo = bkgNo;
        this.cmdtDesc = cmdtDesc;
        this.rcvTerm = rcvTerm;
        this.dlvTerm = dlvTerm;
        this.xterListDpFlg = xterListDpFlg;
        this.siTel = siTel;
        this.rcFlg = rcFlg;
        this.mobile = mobile;
        this.porCd = porCd;
        this.xterRqstViaNm = xterRqstViaNm;
        this.cntcEml = cntcEml;
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
        this.ffCustSeq = ffCustSeq;
        this.bkgUpldStsCd = bkgUpldStsCd;
        this.estmWgt = estmWgt;
        this.ibflag = ibflag;
        this.ffCustNm = ffCustNm;
        this.scacCd = scacCd;
        this.cmdtCd = cmdtCd;
        this.shCntCd = shCntCd;
        this.bbCgoFlg = bbCgoFlg;
        this.dcgoFlg = dcgoFlg;
        this.xterRqstViaCd = xterRqstViaCd;
        this.alps = alps;
        this.rmk = rmk;
        this.xterRqstAcptUsrNm = xterRqstAcptUsrNm;
        this.podNm = podNm;
        this.delNm = delNm;
        this.inclRtBlKnt = inclRtBlKnt;
        this.vslNm = vslNm;
        this.xcldRtBlKnt = xcldRtBlKnt;
        this.twnSoNo = twnSoNo;
        this.socFlg = socFlg;
        this.arrivalDt = arrivalDt;
        this.blIssLocCd = blIssLocCd;
        this.wyBlFlg = wyBlFlg;
        this.ffCntCd = ffCntCd;
        this.siCntcNm = siCntcNm;
        this.cntcNm = cntcNm;
        this.xterRqstNo = xterRqstNo;
        this.siFax = siFax;
        this.siCntcEml = siCntcEml;
        this.mtyPkupDt = mtyPkupDt;
        this.troPkupDt = troPkupDt;
        this.splitStsCd = splitStsCd;
        this.nonNegoRtInclKnt = nonNegoRtInclKnt;
        this.nonNegoRtXcldKnt = nonNegoRtXcldKnt;
        this.bkgRefNo = bkgRefNo;
        this.siRefNo = siRefNo;
        this.invRefNo = invRefNo;
        this.regBkgNo = regBkgNo;
        this.extMrnNo = extMrnNo;
        this.porYdCd = porYdCd;
        this.polYdCd = polYdCd;
        this.podYdCd = podYdCd;
        this.delYdCd = delYdCd;
        this.custId = custId;
        this.flexHgtFlg = flexHgtFlg;
        this.sysUpldFlg = sysUpldFlg;
        this.siAudFlg = siAudFlg;
        this.cmpbRtFlg = cmpbRtFlg;
        this.hndlOfcCd = hndlOfcCd;
        this.spcCtrlrRmk = spcCtrlrRmk;
        this.bkgShRefNo = bkgShRefNo;
        this.bkgFfRefNo = bkgFfRefNo;
        this.siShRefNo = siShRefNo;
        this.siFfRefNo = siFfRefNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("xter_chg_arr_flg", getXterChgArrFlg());
        this.hashColumns.put("bl_no_ctnt", getBlNoCtnt());
        this.hashColumns.put("tel", getTel());
        this.hashColumns.put("pol_nm", getPolNm());
        this.hashColumns.put("si_mobile", getSiMobile());
        this.hashColumns.put("auto_notification", getAutoNotification());
        this.hashColumns.put("departure_dt", getDepartureDt());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("sc_rfa", getScRfa());
        this.hashColumns.put("ctrt_no", getCtrtNo());
        this.hashColumns.put("bl_iss_dt", getBlIssDt());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("fnl_dest_nm", getFnlDestNm());
        this.hashColumns.put("sh_cust_seq", getShCustSeq());
        this.hashColumns.put("hbl_knt", getHblKnt());
        this.hashColumns.put("return_dt", getReturnDt());
        this.hashColumns.put("xter_rqst_acpt_usr_id", getXterRqstAcptUsrId());
        this.hashColumns.put("bkg_upld_sts_nm", getBkgUpldStsNm());
        this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
        this.hashColumns.put("cust_ref_no", getCustRefNo());
        this.hashColumns.put("xter_agn_dp_flg", getXterAgnDpFlg());
        this.hashColumns.put("fax", getFax());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("snaccs_split_no", getSnaccsSplitNo());
        this.hashColumns.put("frt_term_cd", getFrtTermCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("estm_wgt_ut_cd", getEstmWgtUtCd());
        this.hashColumns.put("usa_cstms_file_ctnt", getUsaCstmsFileCtnt());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("xter_rqst_acpt_cd", getXterRqstAcptCd());
        this.hashColumns.put("por_nm", getPorNm());
        this.hashColumns.put("sh_cust_nm", getShCustNm());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("rcv_term", getRcvTerm());
        this.hashColumns.put("dlv_term", getDlvTerm());
        this.hashColumns.put("xter_list_dp_flg", getXterListDpFlg());
        this.hashColumns.put("si_tel", getSiTel());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("mobile", getMobile());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("xter_rqst_via_nm", getXterRqstViaNm());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
        this.hashColumns.put("ff_cust_seq", getFfCustSeq());
        this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
        this.hashColumns.put("estm_wgt", getEstmWgt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ff_cust_nm", getFfCustNm());
        this.hashColumns.put("scac_cd", getScacCd());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("sh_cnt_cd", getShCntCd());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
        this.hashColumns.put("alps", getAlps());
        this.hashColumns.put("rmk", getRmk());
        this.hashColumns.put("xter_rqst_acpt_usr_nm", getXterRqstAcptUsrNm());
        this.hashColumns.put("pod_nm", getPodNm());
        this.hashColumns.put("del_nm", getDelNm());
        this.hashColumns.put("incl_rt_bl_knt", getInclRtBlKnt());
        this.hashColumns.put("vsl_nm", getVslNm());
        this.hashColumns.put("xcld_rt_bl_knt", getXcldRtBlKnt());
        this.hashColumns.put("twn_so_no", getTwnSoNo());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("arrival_dt", getArrivalDt());
        this.hashColumns.put("bl_iss_loc_cd", getBlIssLocCd());
        this.hashColumns.put("wy_bl_flg", getWyBlFlg());
        this.hashColumns.put("ff_cnt_cd", getFfCntCd());
        this.hashColumns.put("si_cntc_nm", getSiCntcNm());
        this.hashColumns.put("cntc_nm", getCntcNm());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("si_fax", getSiFax());
        this.hashColumns.put("si_cntc_eml", getSiCntcEml());
        this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
        this.hashColumns.put("tro_pkup_dt", getTroPkupDt());
        this.hashColumns.put("split_sts_cd", getSplitStsCd());
        this.hashColumns.put("non_nego_rt_incl_knt", getNonNegoRtInclKnt());
        this.hashColumns.put("non_nego_rt_xcld_knt", getNonNegoRtXcldKnt());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("si_ref_no", getSiRefNo());
        this.hashColumns.put("inv_ref_no", getInvRefNo());
        this.hashColumns.put("reg_bkg_no", getRegBkgNo());
        this.hashColumns.put("ext_mrn_no", getExtMrnNo());
        this.hashColumns.put("por_yd_cd", getPorYdCd());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("del_yd_cd", getDelYdCd());
        this.hashColumns.put("cust_id", getCustId());
        this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
        this.hashColumns.put("sys_upld_flg", getSysUpldFlg());
        this.hashColumns.put("si_aud_flg", getSiAudFlg());
        this.hashColumns.put("cmpb_rt_flg", getCmpbRtFlg());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("spc_ctrlr_rmk", getSpcCtrlrRmk());
        this.hashColumns.put("bkg_sh_ref_no", getBkgShRefNo());
        this.hashColumns.put("bkg_ff_ref_no", getBkgFfRefNo());
        this.hashColumns.put("si_sh_ref_no", getSiShRefNo());
        this.hashColumns.put("si_ff_ref_no", getSiFfRefNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("xter_chg_arr_flg", "xterChgArrFlg");
        this.hashFields.put("bl_no_ctnt", "blNoCtnt");
        this.hashFields.put("tel", "tel");
        this.hashFields.put("pol_nm", "polNm");
        this.hashFields.put("si_mobile", "siMobile");
        this.hashFields.put("auto_notification", "autoNotification");
        this.hashFields.put("departure_dt", "departureDt");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("sc_rfa", "scRfa");
        this.hashFields.put("ctrt_no", "ctrtNo");
        this.hashFields.put("bl_iss_dt", "blIssDt");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("fnl_dest_nm", "fnlDestNm");
        this.hashFields.put("sh_cust_seq", "shCustSeq");
        this.hashFields.put("hbl_knt", "hblKnt");
        this.hashFields.put("return_dt", "returnDt");
        this.hashFields.put("xter_rqst_acpt_usr_id", "xterRqstAcptUsrId");
        this.hashFields.put("bkg_upld_sts_nm", "bkgUpldStsNm");
        this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
        this.hashFields.put("cust_ref_no", "custRefNo");
        this.hashFields.put("xter_agn_dp_flg", "xterAgnDpFlg");
        this.hashFields.put("fax", "fax");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("snaccs_split_no", "snaccsSplitNo");
        this.hashFields.put("frt_term_cd", "frtTermCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("estm_wgt_ut_cd", "estmWgtUtCd");
        this.hashFields.put("usa_cstms_file_ctnt", "usaCstmsFileCtnt");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("xter_rqst_acpt_cd", "xterRqstAcptCd");
        this.hashFields.put("por_nm", "porNm");
        this.hashFields.put("sh_cust_nm", "shCustNm");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("rcv_term", "rcvTerm");
        this.hashFields.put("dlv_term", "dlvTerm");
        this.hashFields.put("xter_list_dp_flg", "xterListDpFlg");
        this.hashFields.put("si_tel", "siTel");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("mobile", "mobile");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("xter_rqst_via_nm", "xterRqstViaNm");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
        this.hashFields.put("ff_cust_seq", "ffCustSeq");
        this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
        this.hashFields.put("estm_wgt", "estmWgt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ff_cust_nm", "ffCustNm");
        this.hashFields.put("scac_cd", "scacCd");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("sh_cnt_cd", "shCntCd");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
        this.hashFields.put("alps", "alps");
        this.hashFields.put("rmk", "rmk");
        this.hashFields.put("xter_rqst_acpt_usr_nm", "xterRqstAcptUsrNm");
        this.hashFields.put("pod_nm", "podNm");
        this.hashFields.put("del_nm", "delNm");
        this.hashFields.put("incl_rt_bl_knt", "inclRtBlKnt");
        this.hashFields.put("vsl_nm", "vslNm");
        this.hashFields.put("xcld_rt_bl_knt", "xcldRtBlKnt");
        this.hashFields.put("twn_so_no", "twnSoNo");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("arrival_dt", "arrivalDt");
        this.hashFields.put("bl_iss_loc_cd", "blIssLocCd");
        this.hashFields.put("wy_bl_flg", "wyBlFlg");
        this.hashFields.put("ff_cnt_cd", "ffCntCd");
        this.hashFields.put("si_cntc_nm", "siCntcNm");
        this.hashFields.put("cntc_nm", "cntcNm");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("si_fax", "siFax");
        this.hashFields.put("si_cntc_eml", "siCntcEml");
        this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
        this.hashFields.put("tro_pkup_dt", "troPkupDt");
        this.hashFields.put("split_sts_cd", "splitStsCd");
        this.hashFields.put("non_nego_rt_incl_knt", "nonNegoRtInclKnt");
        this.hashFields.put("non_nego_rt_xcld_knt", "nonNegoRtXcldKnt");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("si_ref_no", "siRefNo");
        this.hashFields.put("inv_ref_no", "invRefNo");
        this.hashFields.put("reg_bkg_no", "regBkgNo");
        this.hashFields.put("ext_mrn_no", "extMrnNo");
        this.hashFields.put("por_yd_cd", "porYdCd");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("del_yd_cd", "delYdCd");
        this.hashFields.put("cust_id", "custId");
        this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
        this.hashFields.put("sys_upld_flg", "sysUpldFlg");
        this.hashFields.put("si_aud_flg", "siAudFlg");
        this.hashFields.put("cmpb_rt_flg", "cmpbRtFlg");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("spc_ctrlr_rmk", "spcCtrlrRmk");
        this.hashFields.put("bkg_sh_ref_no", "bkgShRefNo");
        this.hashFields.put("bkg_ff_ref_no", "bkgFfRefNo");
        this.hashFields.put("si_sh_ref_no", "siShRefNo");
        this.hashFields.put("si_ff_ref_no", "siFfRefNo");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	* Column Info
	* @param  xterChgArrFlg
	*/
    public void setXterChgArrFlg(String xterChgArrFlg) {
        this.xterChgArrFlg = xterChgArrFlg;
    }

    /**
	 * Column Info
	 * @return	xterChgArrFlg
	 */
    public String getXterChgArrFlg() {
        return this.xterChgArrFlg;
    }

    /**
	* Column Info
	* @param  blNoCtnt
	*/
    public void setBlNoCtnt(String blNoCtnt) {
        this.blNoCtnt = blNoCtnt;
    }

    /**
	 * Column Info
	 * @return	blNoCtnt
	 */
    public String getBlNoCtnt() {
        return this.blNoCtnt;
    }

    /**
	* Column Info
	* @param  tel
	*/
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
	 * Column Info
	 * @return	tel
	 */
    public String getTel() {
        return this.tel;
    }

    /**
	* Column Info
	* @param  polNm
	*/
    public void setPolNm(String polNm) {
        this.polNm = polNm;
    }

    /**
	 * Column Info
	 * @return	polNm
	 */
    public String getPolNm() {
        return this.polNm;
    }

    /**
	* Column Info
	* @param  siMobile
	*/
    public void setSiMobile(String siMobile) {
        this.siMobile = siMobile;
    }

    /**
	 * Column Info
	 * @return	siMobile
	 */
    public String getSiMobile() {
        return this.siMobile;
    }

    /**
	* Column Info
	* @param  autoNotification
	*/
    public void setAutoNotification(String autoNotification) {
        this.autoNotification = autoNotification;
    }

    /**
	 * Column Info
	 * @return	autoNotification
	 */
    public String getAutoNotification() {
        return this.autoNotification;
    }

    /**
	* Column Info
	* @param  departureDt
	*/
    public void setDepartureDt(String departureDt) {
        this.departureDt = departureDt;
    }

    /**
	 * Column Info
	 * @return	departureDt
	 */
    public String getDepartureDt() {
        return this.departureDt;
    }

    /**
	* Column Info
	* @param  srepCd
	*/
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * Column Info
	 * @return	srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	* Column Info
	* @param  docTpCd
	*/
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
    }

    /**
	 * Column Info
	 * @return	docTpCd
	 */
    public String getDocTpCd() {
        return this.docTpCd;
    }

    /**
	* Column Info
	* @param  pagerows
	*/
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @return	pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	* Column Info
	* @param  scRfa
	*/
    public void setScRfa(String scRfa) {
        this.scRfa = scRfa;
    }

    /**
	 * Column Info
	 * @return	scRfa
	 */
    public String getScRfa() {
        return this.scRfa;
    }

    /**
	* Column Info
	* @param  ctrtNo
	*/
    public void setCtrtNo(String ctrtNo) {
        this.ctrtNo = ctrtNo;
    }

    /**
	 * Column Info
	 * @return	ctrtNo
	 */
    public String getCtrtNo() {
        return this.ctrtNo;
    }

    /**
	* Column Info
	* @param  blIssDt
	*/
    public void setBlIssDt(String blIssDt) {
        this.blIssDt = blIssDt;
    }

    /**
	 * Column Info
	 * @return	blIssDt
	 */
    public String getBlIssDt() {
        return this.blIssDt;
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
	 * @return	polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	* Column Info
	* @param  fnlDestNm
	*/
    public void setFnlDestNm(String fnlDestNm) {
        this.fnlDestNm = fnlDestNm;
    }

    /**
	 * Column Info
	 * @return	fnlDestNm
	 */
    public String getFnlDestNm() {
        return this.fnlDestNm;
    }

    /**
	* Column Info
	* @param  shCustSeq
	*/
    public void setShCustSeq(String shCustSeq) {
        this.shCustSeq = shCustSeq;
    }

    /**
	 * Column Info
	 * @return	shCustSeq
	 */
    public String getShCustSeq() {
        return this.shCustSeq;
    }

    /**
	* Column Info
	* @param  hblKnt
	*/
    public void setHblKnt(String hblKnt) {
        this.hblKnt = hblKnt;
    }

    /**
	 * Column Info
	 * @return	hblKnt
	 */
    public String getHblKnt() {
        return this.hblKnt;
    }

    /**
	* Column Info
	* @param  returnDt
	*/
    public void setReturnDt(String returnDt) {
        this.returnDt = returnDt;
    }

    /**
	 * Column Info
	 * @return	returnDt
	 */
    public String getReturnDt() {
        return this.returnDt;
    }

    /**
	* Column Info
	* @param  xterRqstAcptUsrId
	*/
    public void setXterRqstAcptUsrId(String xterRqstAcptUsrId) {
        this.xterRqstAcptUsrId = xterRqstAcptUsrId;
    }

    /**
	 * Column Info
	 * @return	xterRqstAcptUsrId
	 */
    public String getXterRqstAcptUsrId() {
        return this.xterRqstAcptUsrId;
    }

    /**
	* Column Info
	* @param  bkgUpldStsNm
	*/
    public void setBkgUpldStsNm(String bkgUpldStsNm) {
        this.bkgUpldStsNm = bkgUpldStsNm;
    }

    /**
	 * Column Info
	 * @return	bkgUpldStsNm
	 */
    public String getBkgUpldStsNm() {
        return this.bkgUpldStsNm;
    }

    /**
	* Column Info
	* @param  cndCstmsFileCd
	*/
    public void setCndCstmsFileCd(String cndCstmsFileCd) {
        this.cndCstmsFileCd = cndCstmsFileCd;
    }

    /**
	 * Column Info
	 * @return	cndCstmsFileCd
	 */
    public String getCndCstmsFileCd() {
        return this.cndCstmsFileCd;
    }

    /**
	* Column Info
	* @param  custRefNo
	*/
    public void setCustRefNo(String custRefNo) {
        this.custRefNo = custRefNo;
    }

    /**
	 * Column Info
	 * @return	custRefNo
	 */
    public String getCustRefNo() {
        return this.custRefNo;
    }

    /**
	* Column Info
	* @param  xterAgnDpFlg
	*/
    public void setXterAgnDpFlg(String xterAgnDpFlg) {
        this.xterAgnDpFlg = xterAgnDpFlg;
    }

    /**
	 * Column Info
	 * @return	xterAgnDpFlg
	 */
    public String getXterAgnDpFlg() {
        return this.xterAgnDpFlg;
    }

    /**
	* Column Info
	* @param  fax
	*/
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
	 * Column Info
	 * @return	fax
	 */
    public String getFax() {
        return this.fax;
    }

    /**
	* Column Info
	* @param  awkCgoFlg
	*/
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
    }

    /**
	 * Column Info
	 * @return	awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
    }

    /**
	* Column Info
	* @param  snaccsSplitNo
	*/
    public void setSnaccsSplitNo(String snaccsSplitNo) {
        this.snaccsSplitNo = snaccsSplitNo;
    }

    /**
	 * Column Info
	 * @return	snaccsSplitNo
	 */
    public String getSnaccsSplitNo() {
        return this.snaccsSplitNo;
    }

    /**
	* Column Info
	* @param  frtTermCd
	*/
    public void setFrtTermCd(String frtTermCd) {
        this.frtTermCd = frtTermCd;
    }

    /**
	 * Column Info
	 * @return	frtTermCd
	 */
    public String getFrtTermCd() {
        return this.frtTermCd;
    }

    /**
	* Column Info
	* @param  delCd
	*/
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @return	delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	* Column Info
	* @param  estmWgtUtCd
	*/
    public void setEstmWgtUtCd(String estmWgtUtCd) {
        this.estmWgtUtCd = estmWgtUtCd;
    }

    /**
	 * Column Info
	 * @return	estmWgtUtCd
	 */
    public String getEstmWgtUtCd() {
        return this.estmWgtUtCd;
    }

    /**
	* Column Info
	* @param  usaCstmsFileCtnt
	*/
    public void setUsaCstmsFileCtnt(String usaCstmsFileCtnt) {
        this.usaCstmsFileCtnt = usaCstmsFileCtnt;
    }

    /**
	 * Column Info
	 * @return	usaCstmsFileCtnt
	 */
    public String getUsaCstmsFileCtnt() {
        return this.usaCstmsFileCtnt;
    }

    /**
	* Column Info
	* @param  vvd
	*/
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @return	vvd
	 */
    public String getVvd() {
        return this.vvd;
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
	 * @return	podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	* Column Info
	* @param  xterRqstAcptCd
	*/
    public void setXterRqstAcptCd(String xterRqstAcptCd) {
        this.xterRqstAcptCd = xterRqstAcptCd;
    }

    /**
	 * Column Info
	 * @return	xterRqstAcptCd
	 */
    public String getXterRqstAcptCd() {
        return this.xterRqstAcptCd;
    }

    /**
	* Column Info
	* @param  porNm
	*/
    public void setPorNm(String porNm) {
        this.porNm = porNm;
    }

    /**
	 * Column Info
	 * @return	porNm
	 */
    public String getPorNm() {
        return this.porNm;
    }

    /**
	* Column Info
	* @param  shCustNm
	*/
    public void setShCustNm(String shCustNm) {
        this.shCustNm = shCustNm;
    }

    /**
	 * Column Info
	 * @return	shCustNm
	 */
    public String getShCustNm() {
        return this.shCustNm;
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
	 * @return	bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	* Column Info
	* @param  cmdtDesc
	*/
    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    /**
	 * Column Info
	 * @return	cmdtDesc
	 */
    public String getCmdtDesc() {
        return this.cmdtDesc;
    }

    /**
	* Column Info
	* @param  rcvTerm
	*/
    public void setRcvTerm(String rcvTerm) {
        this.rcvTerm = rcvTerm;
    }

    /**
	 * Column Info
	 * @return	rcvTerm
	 */
    public String getRcvTerm() {
        return this.rcvTerm;
    }

    /**
	* Column Info
	* @param  dlvTerm
	*/
    public void setDlvTerm(String dlvTerm) {
        this.dlvTerm = dlvTerm;
    }

    /**
	 * Column Info
	 * @return	dlvTerm
	 */
    public String getDlvTerm() {
        return this.dlvTerm;
    }

    /**
	* Column Info
	* @param  xterListDpFlg
	*/
    public void setXterListDpFlg(String xterListDpFlg) {
        this.xterListDpFlg = xterListDpFlg;
    }

    /**
	 * Column Info
	 * @return	xterListDpFlg
	 */
    public String getXterListDpFlg() {
        return this.xterListDpFlg;
    }

    /**
	* Column Info
	* @param  siTel
	*/
    public void setSiTel(String siTel) {
        this.siTel = siTel;
    }

    /**
	 * Column Info
	 * @return	siTel
	 */
    public String getSiTel() {
        return this.siTel;
    }

    /**
	* Column Info
	* @param  rcFlg
	*/
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @return	rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	* Column Info
	* @param  mobile
	*/
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
	 * Column Info
	 * @return	mobile
	 */
    public String getMobile() {
        return this.mobile;
    }

    /**
	* Column Info
	* @param  porCd
	*/
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @return	porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	* Column Info
	* @param  xterRqstViaNm
	*/
    public void setXterRqstViaNm(String xterRqstViaNm) {
        this.xterRqstViaNm = xterRqstViaNm;
    }

    /**
	 * Column Info
	 * @return	xterRqstViaNm
	 */
    public String getXterRqstViaNm() {
        return this.xterRqstViaNm;
    }

    /**
	* Column Info
	* @param  cntcEml
	*/
    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    /**
	 * Column Info
	 * @return	cntcEml
	 */
    public String getCntcEml() {
        return this.cntcEml;
    }

    /**
	* Column Info
	* @param  xterBkgRqstStsCd
	*/
    public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @return	xterBkgRqstStsCd
	 */
    public String getXterBkgRqstStsCd() {
        return this.xterBkgRqstStsCd;
    }

    /**
	* Column Info
	* @param  ffCustSeq
	*/
    public void setFfCustSeq(String ffCustSeq) {
        this.ffCustSeq = ffCustSeq;
    }

    /**
	 * Column Info
	 * @return	ffCustSeq
	 */
    public String getFfCustSeq() {
        return this.ffCustSeq;
    }

    /**
	* Column Info
	* @param  bkgUpldStsCd
	*/
    public void setBkgUpldStsCd(String bkgUpldStsCd) {
        this.bkgUpldStsCd = bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @return	bkgUpldStsCd
	 */
    public String getBkgUpldStsCd() {
        return this.bkgUpldStsCd;
    }

    /**
	* Column Info
	* @param  estmWgt
	*/
    public void setEstmWgt(String estmWgt) {
        this.estmWgt = estmWgt;
    }

    /**
	 * Column Info
	 * @return	estmWgt
	 */
    public String getEstmWgt() {
        return this.estmWgt;
    }

    /**
	* Column Info
	* @param  ibflag
	*/
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @return	ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	* Column Info
	* @param  ffCustNm
	*/
    public void setFfCustNm(String ffCustNm) {
        this.ffCustNm = ffCustNm;
    }

    /**
	 * Column Info
	 * @return	ffCustNm
	 */
    public String getFfCustNm() {
        return this.ffCustNm;
    }

    /**
	* Column Info
	* @param  scacCd
	*/
    public void setScacCd(String scacCd) {
        this.scacCd = scacCd;
    }

    /**
	 * Column Info
	 * @return	scacCd
	 */
    public String getScacCd() {
        return this.scacCd;
    }

    /**
	* Column Info
	* @param  cmdtCd
	*/
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @return	cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	* Column Info
	* @param  shCntCd
	*/
    public void setShCntCd(String shCntCd) {
        this.shCntCd = shCntCd;
    }

    /**
	 * Column Info
	 * @return	shCntCd
	 */
    public String getShCntCd() {
        return this.shCntCd;
    }

    /**
	* Column Info
	* @param  bbCgoFlg
	*/
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
    }

    /**
	 * Column Info
	 * @return	bbCgoFlg
	 */
    public String getBbCgoFlg() {
        return this.bbCgoFlg;
    }

    /**
	* Column Info
	* @param  dcgoFlg
	*/
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
    }

    /**
	 * Column Info
	 * @return	dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
    }

    /**
	* Column Info
	* @param  xterRqstViaCd
	*/
    public void setXterRqstViaCd(String xterRqstViaCd) {
        this.xterRqstViaCd = xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @return	xterRqstViaCd
	 */
    public String getXterRqstViaCd() {
        return this.xterRqstViaCd;
    }

    /**
	* Column Info
	* @param  alps
	*/
    public void setAlps(String alps) {
        this.alps = alps;
    }

    /**
	 * Column Info
	 * @return	alps
	 */
    public String getAlps() {
        return this.alps;
    }

    /**
	* Column Info
	* @param  rmk
	*/
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
	 * Column Info
	 * @return	rmk
	 */
    public String getRmk() {
        return this.rmk;
    }

    /**
	* Column Info
	* @param  xterRqstAcptUsrNm
	*/
    public void setXterRqstAcptUsrNm(String xterRqstAcptUsrNm) {
        this.xterRqstAcptUsrNm = xterRqstAcptUsrNm;
    }

    /**
	 * Column Info
	 * @return	xterRqstAcptUsrNm
	 */
    public String getXterRqstAcptUsrNm() {
        return this.xterRqstAcptUsrNm;
    }

    /**
	* Column Info
	* @param  podNm
	*/
    public void setPodNm(String podNm) {
        this.podNm = podNm;
    }

    /**
	 * Column Info
	 * @return	podNm
	 */
    public String getPodNm() {
        return this.podNm;
    }

    /**
	* Column Info
	* @param  delNm
	*/
    public void setDelNm(String delNm) {
        this.delNm = delNm;
    }

    /**
	 * Column Info
	 * @return	delNm
	 */
    public String getDelNm() {
        return this.delNm;
    }

    /**
	* Column Info
	* @param  inclRtBlKnt
	*/
    public void setInclRtBlKnt(String inclRtBlKnt) {
        this.inclRtBlKnt = inclRtBlKnt;
    }

    /**
	 * Column Info
	 * @return	inclRtBlKnt
	 */
    public String getInclRtBlKnt() {
        return this.inclRtBlKnt;
    }

    /**
	* Column Info
	* @param  vslNm
	*/
    public void setVslNm(String vslNm) {
        this.vslNm = vslNm;
    }

    /**
	 * Column Info
	 * @return	vslNm
	 */
    public String getVslNm() {
        return this.vslNm;
    }

    /**
	* Column Info
	* @param  xcldRtBlKnt
	*/
    public void setXcldRtBlKnt(String xcldRtBlKnt) {
        this.xcldRtBlKnt = xcldRtBlKnt;
    }

    /**
	 * Column Info
	 * @return	xcldRtBlKnt
	 */
    public String getXcldRtBlKnt() {
        return this.xcldRtBlKnt;
    }

    /**
	* Column Info
	* @param  twnSoNo
	*/
    public void setTwnSoNo(String twnSoNo) {
        this.twnSoNo = twnSoNo;
    }

    /**
	 * Column Info
	 * @return	twnSoNo
	 */
    public String getTwnSoNo() {
        return this.twnSoNo;
    }

    /**
	* Column Info
	* @param  socFlg
	*/
    public void setSocFlg(String socFlg) {
        this.socFlg = socFlg;
    }

    /**
	 * Column Info
	 * @return	socFlg
	 */
    public String getSocFlg() {
        return this.socFlg;
    }

    /**
	* Column Info
	* @param  arrivalDt
	*/
    public void setArrivalDt(String arrivalDt) {
        this.arrivalDt = arrivalDt;
    }

    /**
	 * Column Info
	 * @return	arrivalDt
	 */
    public String getArrivalDt() {
        return this.arrivalDt;
    }

    /**
	* Column Info
	* @param  blIssLocCd
	*/
    public void setBlIssLocCd(String blIssLocCd) {
        this.blIssLocCd = blIssLocCd;
    }

    /**
	 * Column Info
	 * @return	blIssLocCd
	 */
    public String getBlIssLocCd() {
        return this.blIssLocCd;
    }

    /**
	* Column Info
	* @param  wyBlFlg
	*/
    public void setWyBlFlg(String wyBlFlg) {
        this.wyBlFlg = wyBlFlg;
    }

    /**
	 * Column Info
	 * @return	wyBlFlg
	 */
    public String getWyBlFlg() {
        return this.wyBlFlg;
    }

    /**
	* Column Info
	* @param  ffCntCd
	*/
    public void setFfCntCd(String ffCntCd) {
        this.ffCntCd = ffCntCd;
    }

    /**
	 * Column Info
	 * @return	ffCntCd
	 */
    public String getFfCntCd() {
        return this.ffCntCd;
    }

    /**
	* Column Info
	* @param  siCntcNm
	*/
    public void setSiCntcNm(String siCntcNm) {
        this.siCntcNm = siCntcNm;
    }

    /**
	 * Column Info
	 * @return	siCntcNm
	 */
    public String getSiCntcNm() {
        return this.siCntcNm;
    }

    /**
	* Column Info
	* @param  cntcNm
	*/
    public void setCntcNm(String cntcNm) {
        this.cntcNm = cntcNm;
    }

    /**
	 * Column Info
	 * @return	cntcNm
	 */
    public String getCntcNm() {
        return this.cntcNm;
    }

    /**
	* Column Info
	* @param  xterRqstNo
	*/
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * Column Info
	 * @return	xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    /**
	* Column Info
	* @param  siFax
	*/
    public void setSiFax(String siFax) {
        this.siFax = siFax;
    }

    /**
	 * Column Info
	 * @return	siFax
	 */
    public String getSiFax() {
        return this.siFax;
    }

    /**
	* Column Info
	* @param  siCntcEml
	*/
    public void setSiCntcEml(String siCntcEml) {
        this.siCntcEml = siCntcEml;
    }

    /**
	 * Column Info
	 * @return	siCntcEml
	 */
    public String getSiCntcEml() {
        return this.siCntcEml;
    }

    /**
	* Column Info
	* @param  mtyPkupDt
	*/
    public void setMtyPkupDt(String mtyPkupDt) {
        this.mtyPkupDt = mtyPkupDt;
    }

    /**
	 * Column Info
	 * @return	mtyPkupDt
	 */
    public String getMtyPkupDt() {
        return this.mtyPkupDt;
    }

    /**
	* Column Info
	* @param  troPkupDt
	*/
    public void setTroPkupDt(String troPkupDt) {
        this.troPkupDt = troPkupDt;
    }

    /**
	 * Column Info
	 * @return	troPkupDt
	 */
    public String getTroPkupDt() {
        return this.troPkupDt;
    }

    /**
	* Column Info
	* @param  splitStsCd
	*/
    public void setSplitStsCd(String splitStsCd) {
        this.splitStsCd = splitStsCd;
    }

    /**
	 * Column Info
	 * @return	splitStsCd
	 */
    public String getSplitStsCd() {
        return this.splitStsCd;
    }

    /**
	* Column Info
	* @param  nonNegoRtInclKnt
	*/
    public void setNonNegoRtInclKnt(String nonNegoRtInclKnt) {
        this.nonNegoRtInclKnt = nonNegoRtInclKnt;
    }

    /**
	 * Column Info
	 * @return	nonNegoRtInclKnt
	 */
    public String getNonNegoRtInclKnt() {
        return this.nonNegoRtInclKnt;
    }

    /**
	* Column Info
	* @param  nonNegoRtXcldKnt
	*/
    public void setNonNegoRtXcldKnt(String nonNegoRtXcldKnt) {
        this.nonNegoRtXcldKnt = nonNegoRtXcldKnt;
    }

    /**
	 * Column Info
	 * @return	nonNegoRtXcldKnt
	 */
    public String getNonNegoRtXcldKnt() {
        return this.nonNegoRtXcldKnt;
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
	 * @return	bkgRefNo
	 */
    public String getBkgRefNo() {
        return this.bkgRefNo;
    }

    /**
	* Column Info
	* @param  siRefNo
	*/
    public void setSiRefNo(String siRefNo) {
        this.siRefNo = siRefNo;
    }

    /**
	 * Column Info
	 * @return	siRefNo
	 */
    public String getSiRefNo() {
        return this.siRefNo;
    }

    /**
	* Column Info
	* @param  invRefNo
	*/
    public void setInvRefNo(String invRefNo) {
        this.invRefNo = invRefNo;
    }

    /**
	 * Column Info
	 * @return	invRefNo
	 */
    public String getInvRefNo() {
        return this.invRefNo;
    }

    /**
	* Column Info
	* @param  regBkgNo
	*/
    public void setRegBkgNo(String regBkgNo) {
        this.regBkgNo = regBkgNo;
    }

    /**
	 * Column Info
	 * @return	regBkgNo
	 */
    public String getRegBkgNo() {
        return this.regBkgNo;
    }

    /**
	* Column Info
	* @param  extMrnNo
	*/
    public void setExtMrnNo(String extMrnNo) {
        this.extMrnNo = extMrnNo;
    }

    /**
	 * Column Info
	 * @return	extMrnNo
	 */
    public String getExtMrnNo() {
        return this.extMrnNo;
    }

    /**
	* Column Info
	* @param  porYdCd
	*/
    public void setPorYdCd(String porYdCd) {
        this.porYdCd = porYdCd;
    }

    /**
	 * Column Info
	 * @return	porYdCd
	 */
    public String getPorYdCd() {
        return this.porYdCd;
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
	 * @return	polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
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
	 * @return	podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
    }

    /**
	* Column Info
	* @param  delYdCd
	*/
    public void setDelYdCd(String delYdCd) {
        this.delYdCd = delYdCd;
    }

    /**
	 * Column Info
	 * @return	delYdCd
	 */
    public String getDelYdCd() {
        return this.delYdCd;
    }

    /**
	* Column Info
	* @param  custId
	*/
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
	 * Column Info
	 * @return	custId
	 */
    public String getCustId() {
        return this.custId;
    }

    /**
	* Column Info
	* @param  flexHgtFlg
	*/
    public void setFlexHgtFlg(String flexHgtFlg) {
        this.flexHgtFlg = flexHgtFlg;
    }

    /**
	 * Column Info
	 * @return	flexHgtFlg
	 */
    public String getFlexHgtFlg() {
        return this.flexHgtFlg;
    }

    /**
	* Column Info
	* @param  sysUpldFlg
	*/
    public void setSysUpldFlg(String sysUpldFlg) {
        this.sysUpldFlg = sysUpldFlg;
    }

    /**
	 * Column Info
	 * @return	sysUpldFlg
	 */
    public String getSysUpldFlg() {
        return this.sysUpldFlg;
    }

    /**
	* Column Info
	* @param  siAudFlg
	*/
    public void setSiAudFlg(String siAudFlg) {
        this.siAudFlg = siAudFlg;
    }

    /**
	 * Column Info
	 * @return	siAudFlg
	 */
    public String getSiAudFlg() {
        return this.siAudFlg;
    }

    /**
	* Column Info
	* @param  cmpbRtFlg
	*/
    public void setCmpbRtFlg(String cmpbRtFlg) {
        this.cmpbRtFlg = cmpbRtFlg;
    }

    /**
	 * Column Info
	 * @return	cmpbRtFlg
	 */
    public String getCmpbRtFlg() {
        return this.cmpbRtFlg;
    }

    /**
	* Column Info
	* @param  hndlOfcCd
	*/
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
    }

    /**
	 * Column Info
	 * @return	hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
    }

    /**
	* Column Info
	* @param  spcCtrlrRmk
	*/
    public void setSpcCtrlrRmk(String spcCtrlrRmk) {
        this.spcCtrlrRmk = spcCtrlrRmk;
    }

    /**
	 * Column Info
	 * @return	spcCtrlrRmk
	 */
    public String getSpcCtrlrRmk() {
        return this.spcCtrlrRmk;
    }

    public void setBkgShRefNo(String bkgShRefNo) {
        this.bkgShRefNo = bkgShRefNo;
    }

    public String getBkgShRefNo() {
        return this.bkgShRefNo;
    }

    public void setBkgFfRefNo(String bkgFfRefNo) {
        this.bkgFfRefNo = bkgFfRefNo;
    }

    public String getBkgFfRefNo() {
        return this.bkgFfRefNo;
    }

    public void setSiShRefNo(String siShRefNo) {
        this.siShRefNo = siShRefNo;
    }

    public String getSiShRefNo() {
        return this.siShRefNo;
    }

    public void setSiFfRefNo(String siFfRefNo) {
        this.siFfRefNo = siFfRefNo;
    }

    public String getSiFfRefNo() {
        return this.siFfRefNo;
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
        setXterChgArrFlg(JSPUtil.getParameter(request, prefix + "xter_chg_arr_flg", ""));
        setBlNoCtnt(JSPUtil.getParameter(request, prefix + "bl_no_ctnt", ""));
        setTel(JSPUtil.getParameter(request, prefix + "tel", ""));
        setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
        setSiMobile(JSPUtil.getParameter(request, prefix + "si_mobile", ""));
        setAutoNotification(JSPUtil.getParameter(request, prefix + "auto_notification", ""));
        setDepartureDt(JSPUtil.getParameter(request, prefix + "departure_dt", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setScRfa(JSPUtil.getParameter(request, prefix + "sc_rfa", ""));
        setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
        setBlIssDt(JSPUtil.getParameter(request, prefix + "bl_iss_dt", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setFnlDestNm(JSPUtil.getParameter(request, prefix + "fnl_dest_nm", ""));
        setShCustSeq(JSPUtil.getParameter(request, prefix + "sh_cust_seq", ""));
        setHblKnt(JSPUtil.getParameter(request, prefix + "hbl_knt", ""));
        setReturnDt(JSPUtil.getParameter(request, prefix + "return_dt", ""));
        setXterRqstAcptUsrId(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_id", ""));
        setBkgUpldStsNm(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_nm", ""));
        setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
        setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
        setXterAgnDpFlg(JSPUtil.getParameter(request, prefix + "xter_agn_dp_flg", ""));
        setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setSnaccsSplitNo(JSPUtil.getParameter(request, prefix + "snaccs_split_no", ""));
        setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setEstmWgtUtCd(JSPUtil.getParameter(request, prefix + "estm_wgt_ut_cd", ""));
        setUsaCstmsFileCtnt(JSPUtil.getParameter(request, prefix + "usa_cstms_file_ctnt", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setXterRqstAcptCd(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_cd", ""));
        setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
        setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setRcvTerm(JSPUtil.getParameter(request, prefix + "rcv_term", ""));
        setDlvTerm(JSPUtil.getParameter(request, prefix + "dlv_term", ""));
        setXterListDpFlg(JSPUtil.getParameter(request, prefix + "xter_list_dp_flg", ""));
        setSiTel(JSPUtil.getParameter(request, prefix + "si_tel", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setMobile(JSPUtil.getParameter(request, prefix + "mobile", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setXterRqstViaNm(JSPUtil.getParameter(request, prefix + "xter_rqst_via_nm", ""));
        setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
        setXterBkgRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", ""));
        setFfCustSeq(JSPUtil.getParameter(request, prefix + "ff_cust_seq", ""));
        setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
        setEstmWgt(JSPUtil.getParameter(request, prefix + "estm_wgt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setFfCustNm(JSPUtil.getParameter(request, prefix + "ff_cust_nm", ""));
        setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setShCntCd(JSPUtil.getParameter(request, prefix + "sh_cnt_cd", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
        setAlps(JSPUtil.getParameter(request, prefix + "alps", ""));
        setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
        setXterRqstAcptUsrNm(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_nm", ""));
        setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
        setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
        setInclRtBlKnt(JSPUtil.getParameter(request, prefix + "incl_rt_bl_knt", ""));
        setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
        setXcldRtBlKnt(JSPUtil.getParameter(request, prefix + "xcld_rt_bl_knt", ""));
        setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setArrivalDt(JSPUtil.getParameter(request, prefix + "arrival_dt", ""));
        setBlIssLocCd(JSPUtil.getParameter(request, prefix + "bl_iss_loc_cd", ""));
        setWyBlFlg(JSPUtil.getParameter(request, prefix + "wy_bl_flg", ""));
        setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
        setSiCntcNm(JSPUtil.getParameter(request, prefix + "si_cntc_nm", ""));
        setCntcNm(JSPUtil.getParameter(request, prefix + "cntc_nm", ""));
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setSiFax(JSPUtil.getParameter(request, prefix + "si_fax", ""));
        setSiCntcEml(JSPUtil.getParameter(request, prefix + "si_cntc_eml", ""));
        setMtyPkupDt(JSPUtil.getParameter(request, prefix + "mty_pkup_dt", ""));
        setTroPkupDt(JSPUtil.getParameter(request, prefix + "tro_pkup_dt", ""));
        setSplitStsCd(JSPUtil.getParameter(request, prefix + "split_sts_cd", ""));
        setNonNegoRtInclKnt(JSPUtil.getParameter(request, prefix + "non_nego_rt_incl_knt", ""));
        setNonNegoRtXcldKnt(JSPUtil.getParameter(request, prefix + "non_nego_rt_xcld_knt", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setSiRefNo(JSPUtil.getParameter(request, prefix + "si_ref_no", ""));
        setInvRefNo(JSPUtil.getParameter(request, prefix + "inv_ref_no", ""));
        setRegBkgNo(JSPUtil.getParameter(request, prefix + "reg_bkg_no", ""));
        setExtMrnNo(JSPUtil.getParameter(request, prefix + "ext_mrn_no", ""));
        setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
        setCustId(JSPUtil.getParameter(request, prefix + "cust_id", ""));
        setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
        setSysUpldFlg(JSPUtil.getParameter(request, prefix + "sys_upld_flg", ""));
        setSiAudFlg(JSPUtil.getParameter(request, prefix + "si_aud_flg", ""));
        setCmpbRtFlg(JSPUtil.getParameter(request, prefix + "cmpb_rt_flg", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
        setSpcCtrlrRmk(JSPUtil.getParameter(request, prefix + "spc_ctrlr_rmk", ""));
        setBkgShRefNo(JSPUtil.getParameter(request, prefix + "bkg_sh_ref_no", ""));
        setBkgFfRefNo(JSPUtil.getParameter(request, prefix + "bkg_ff_ref_no", ""));
        setSiShRefNo(JSPUtil.getParameter(request, prefix + "si_sh_ref_no", ""));
        setSiFfRefNo(JSPUtil.getParameter(request, prefix + "si_ff_ref_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterRqstMstVO[]
	 */
    public XterRqstMstVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return XterRqstMstVO[]
	 */
    public XterRqstMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        XterRqstMstVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] xterChgArrFlg = (JSPUtil.getParameter(request, prefix + "xter_chg_arr_flg".trim(), length));
            String[] blNoCtnt = (JSPUtil.getParameter(request, prefix + "bl_no_ctnt".trim(), length));
            String[] tel = (JSPUtil.getParameter(request, prefix + "tel".trim(), length));
            String[] polNm = (JSPUtil.getParameter(request, prefix + "pol_nm".trim(), length));
            String[] siMobile = (JSPUtil.getParameter(request, prefix + "si_mobile".trim(), length));
            String[] autoNotification = (JSPUtil.getParameter(request, prefix + "auto_notification".trim(), length));
            String[] departureDt = (JSPUtil.getParameter(request, prefix + "departure_dt".trim(), length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd".trim(), length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] scRfa = (JSPUtil.getParameter(request, prefix + "sc_rfa".trim(), length));
            String[] ctrtNo = (JSPUtil.getParameter(request, prefix + "ctrt_no".trim(), length));
            String[] blIssDt = (JSPUtil.getParameter(request, prefix + "bl_iss_dt".trim(), length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd".trim(), length));
            String[] fnlDestNm = (JSPUtil.getParameter(request, prefix + "fnl_dest_nm".trim(), length));
            String[] shCustSeq = (JSPUtil.getParameter(request, prefix + "sh_cust_seq".trim(), length));
            String[] hblKnt = (JSPUtil.getParameter(request, prefix + "hbl_knt".trim(), length));
            String[] returnDt = (JSPUtil.getParameter(request, prefix + "return_dt".trim(), length));
            String[] xterRqstAcptUsrId = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_id".trim(), length));
            String[] bkgUpldStsNm = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_nm".trim(), length));
            String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd".trim(), length));
            String[] custRefNo = (JSPUtil.getParameter(request, prefix + "cust_ref_no".trim(), length));
            String[] xterAgnDpFlg = (JSPUtil.getParameter(request, prefix + "xter_agn_dp_flg".trim(), length));
            String[] fax = (JSPUtil.getParameter(request, prefix + "fax".trim(), length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg".trim(), length));
            String[] snaccsSplitNo = (JSPUtil.getParameter(request, prefix + "snaccs_split_no".trim(), length));
            String[] frtTermCd = (JSPUtil.getParameter(request, prefix + "frt_term_cd".trim(), length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd".trim(), length));
            String[] estmWgtUtCd = (JSPUtil.getParameter(request, prefix + "estm_wgt_ut_cd".trim(), length));
            String[] usaCstmsFileCtnt = (JSPUtil.getParameter(request, prefix + "usa_cstms_file_ctnt".trim(), length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd".trim(), length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd".trim(), length));
            String[] xterRqstAcptCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_cd".trim(), length));
            String[] porNm = (JSPUtil.getParameter(request, prefix + "por_nm".trim(), length));
            String[] shCustNm = (JSPUtil.getParameter(request, prefix + "sh_cust_nm".trim(), length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no".trim(), length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc".trim(), length));
            String[] rcvTerm = (JSPUtil.getParameter(request, prefix + "rcv_term".trim(), length));
            String[] dlvTerm = (JSPUtil.getParameter(request, prefix + "dlv_term".trim(), length));
            String[] xterListDpFlg = (JSPUtil.getParameter(request, prefix + "xter_list_dp_flg".trim(), length));
            String[] siTel = (JSPUtil.getParameter(request, prefix + "si_tel".trim(), length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg".trim(), length));
            String[] mobile = (JSPUtil.getParameter(request, prefix + "mobile".trim(), length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd".trim(), length));
            String[] xterRqstViaNm = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_nm".trim(), length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml".trim(), length));
            String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd".trim(), length));
            String[] ffCustSeq = (JSPUtil.getParameter(request, prefix + "ff_cust_seq".trim(), length));
            String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd".trim(), length));
            String[] estmWgt = (JSPUtil.getParameter(request, prefix + "estm_wgt".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] ffCustNm = (JSPUtil.getParameter(request, prefix + "ff_cust_nm".trim(), length));
            String[] scacCd = (JSPUtil.getParameter(request, prefix + "scac_cd".trim(), length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd".trim(), length));
            String[] shCntCd = (JSPUtil.getParameter(request, prefix + "sh_cnt_cd".trim(), length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg".trim(), length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg".trim(), length));
            String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd".trim(), length));
            String[] alps = (JSPUtil.getParameter(request, prefix + "alps".trim(), length));
            String[] rmk = (JSPUtil.getParameter(request, prefix + "rmk".trim(), length));
            String[] xterRqstAcptUsrNm = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_nm".trim(), length));
            String[] podNm = (JSPUtil.getParameter(request, prefix + "pod_nm".trim(), length));
            String[] delNm = (JSPUtil.getParameter(request, prefix + "del_nm".trim(), length));
            String[] inclRtBlKnt = (JSPUtil.getParameter(request, prefix + "incl_rt_bl_knt".trim(), length));
            String[] vslNm = (JSPUtil.getParameter(request, prefix + "vsl_nm".trim(), length));
            String[] xcldRtBlKnt = (JSPUtil.getParameter(request, prefix + "xcld_rt_bl_knt".trim(), length));
            String[] twnSoNo = (JSPUtil.getParameter(request, prefix + "twn_so_no".trim(), length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg".trim(), length));
            String[] arrivalDt = (JSPUtil.getParameter(request, prefix + "arrival_dt".trim(), length));
            String[] blIssLocCd = (JSPUtil.getParameter(request, prefix + "bl_iss_loc_cd".trim(), length));
            String[] wyBlFlg = (JSPUtil.getParameter(request, prefix + "wy_bl_flg".trim(), length));
            String[] ffCntCd = (JSPUtil.getParameter(request, prefix + "ff_cnt_cd".trim(), length));
            String[] siCntcNm = (JSPUtil.getParameter(request, prefix + "si_cntc_nm".trim(), length));
            String[] cntcNm = (JSPUtil.getParameter(request, prefix + "cntc_nm".trim(), length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no".trim(), length));
            String[] siFax = (JSPUtil.getParameter(request, prefix + "si_fax".trim(), length));
            String[] siCntcEml = (JSPUtil.getParameter(request, prefix + "si_cntc_eml".trim(), length));
            String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix + "mty_pkup_dt".trim(), length));
            String[] troPkupDt = (JSPUtil.getParameter(request, prefix + "tro_pkup_dt".trim(), length));
            String[] splitStsCd = (JSPUtil.getParameter(request, prefix + "split_sts_cd".trim(), length));
            String[] nonNegoRtInclKnt = (JSPUtil.getParameter(request, prefix + "non_nego_rt_incl_knt".trim(), length));
            String[] nonNegoRtXcldKnt = (JSPUtil.getParameter(request, prefix + "non_nego_rt_xcld_knt".trim(), length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no".trim(), length));
            String[] siRefNo = (JSPUtil.getParameter(request, prefix + "si_ref_no".trim(), length));
            String[] invRefNo = (JSPUtil.getParameter(request, prefix + "inv_ref_no".trim(), length));
            String[] regBkgNo = (JSPUtil.getParameter(request, prefix + "reg_bkg_no".trim(), length));
            String[] extMrnNo = (JSPUtil.getParameter(request, prefix + "ext_mrn_no".trim(), length));
            String[] porYdCd = (JSPUtil.getParameter(request, prefix + "por_yd_cd".trim(), length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd".trim(), length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd".trim(), length));
            String[] delYdCd = (JSPUtil.getParameter(request, prefix + "del_yd_cd".trim(), length));
            String[] custId = (JSPUtil.getParameter(request, prefix + "cust_id".trim(), length));
            String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix + "flex_hgt_flg".trim(), length));
            String[] sysUpldFlg = (JSPUtil.getParameter(request, prefix + "sys_upld_flg".trim(), length));
            String[] siAudFlg = (JSPUtil.getParameter(request, prefix + "si_aud_flg".trim(), length));
            String[] cmpbRtFlg = (JSPUtil.getParameter(request, prefix + "cmpb_rt_flg".trim(), length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd".trim(), length));
            String[] spcCtrlrRmk = (JSPUtil.getParameter(request, prefix + "spc_ctrlr_rmk".trim(), length));
            String[] bkgShRefNo = (JSPUtil.getParameter(request, prefix + "bkg_sh_ref_no", length));
	    	String[] bkgFfRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ff_ref_no", length));
	    	String[] siShRefNo = (JSPUtil.getParameter(request, prefix + "si_sh_ref_no", length));
	    	String[] siFfRefNo = (JSPUtil.getParameter(request, prefix + "si_ff_ref_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new XterRqstMstVO();
                if (xterChgArrFlg[i] != null)
                    model.setXterChgArrFlg(xterChgArrFlg[i]);
                if (blNoCtnt[i] != null)
                    model.setBlNoCtnt(blNoCtnt[i]);
                if (tel[i] != null)
                    model.setTel(tel[i]);
                if (polNm[i] != null)
                    model.setPolNm(polNm[i]);
                if (siMobile[i] != null)
                    model.setSiMobile(siMobile[i]);
                if (autoNotification[i] != null)
                    model.setAutoNotification(autoNotification[i]);
                if (departureDt[i] != null)
                    model.setDepartureDt(departureDt[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (scRfa[i] != null)
                    model.setScRfa(scRfa[i]);
                if (ctrtNo[i] != null)
                    model.setCtrtNo(ctrtNo[i]);
                if (blIssDt[i] != null)
                    model.setBlIssDt(blIssDt[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (fnlDestNm[i] != null)
                    model.setFnlDestNm(fnlDestNm[i]);
                if (shCustSeq[i] != null)
                    model.setShCustSeq(shCustSeq[i]);
                if (hblKnt[i] != null)
                    model.setHblKnt(hblKnt[i]);
                if (returnDt[i] != null)
                    model.setReturnDt(returnDt[i]);
                if (xterRqstAcptUsrId[i] != null)
                    model.setXterRqstAcptUsrId(xterRqstAcptUsrId[i]);
                if (bkgUpldStsNm[i] != null)
                    model.setBkgUpldStsNm(bkgUpldStsNm[i]);
                if (cndCstmsFileCd[i] != null)
                    model.setCndCstmsFileCd(cndCstmsFileCd[i]);
                if (custRefNo[i] != null)
                    model.setCustRefNo(custRefNo[i]);
                if (xterAgnDpFlg[i] != null)
                    model.setXterAgnDpFlg(xterAgnDpFlg[i]);
                if (fax[i] != null)
                    model.setFax(fax[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (snaccsSplitNo[i] != null)
                    model.setSnaccsSplitNo(snaccsSplitNo[i]);
                if (frtTermCd[i] != null)
                    model.setFrtTermCd(frtTermCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (estmWgtUtCd[i] != null)
                    model.setEstmWgtUtCd(estmWgtUtCd[i]);
                if (usaCstmsFileCtnt[i] != null)
                    model.setUsaCstmsFileCtnt(usaCstmsFileCtnt[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (xterRqstAcptCd[i] != null)
                    model.setXterRqstAcptCd(xterRqstAcptCd[i]);
                if (porNm[i] != null)
                    model.setPorNm(porNm[i]);
                if (shCustNm[i] != null)
                    model.setShCustNm(shCustNm[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (rcvTerm[i] != null)
                    model.setRcvTerm(rcvTerm[i]);
                if (dlvTerm[i] != null)
                    model.setDlvTerm(dlvTerm[i]);
                if (xterListDpFlg[i] != null)
                    model.setXterListDpFlg(xterListDpFlg[i]);
                if (siTel[i] != null)
                    model.setSiTel(siTel[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (mobile[i] != null)
                    model.setMobile(mobile[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (xterRqstViaNm[i] != null)
                    model.setXterRqstViaNm(xterRqstViaNm[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (xterBkgRqstStsCd[i] != null)
                    model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
                if (ffCustSeq[i] != null)
                    model.setFfCustSeq(ffCustSeq[i]);
                if (bkgUpldStsCd[i] != null)
                    model.setBkgUpldStsCd(bkgUpldStsCd[i]);
                if (estmWgt[i] != null)
                    model.setEstmWgt(estmWgt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ffCustNm[i] != null)
                    model.setFfCustNm(ffCustNm[i]);
                if (scacCd[i] != null)
                    model.setScacCd(scacCd[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (shCntCd[i] != null)
                    model.setShCntCd(shCntCd[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (xterRqstViaCd[i] != null)
                    model.setXterRqstViaCd(xterRqstViaCd[i]);
                if (alps[i] != null)
                    model.setAlps(alps[i]);
                if (rmk[i] != null)
                    model.setRmk(rmk[i]);
                if (xterRqstAcptUsrNm[i] != null)
                    model.setXterRqstAcptUsrNm(xterRqstAcptUsrNm[i]);
                if (podNm[i] != null)
                    model.setPodNm(podNm[i]);
                if (delNm[i] != null)
                    model.setDelNm(delNm[i]);
                if (inclRtBlKnt[i] != null)
                    model.setInclRtBlKnt(inclRtBlKnt[i]);
                if (vslNm[i] != null)
                    model.setVslNm(vslNm[i]);
                if (xcldRtBlKnt[i] != null)
                    model.setXcldRtBlKnt(xcldRtBlKnt[i]);
                if (twnSoNo[i] != null)
                    model.setTwnSoNo(twnSoNo[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (arrivalDt[i] != null)
                    model.setArrivalDt(arrivalDt[i]);
                if (blIssLocCd[i] != null)
                    model.setBlIssLocCd(blIssLocCd[i]);
                if (wyBlFlg[i] != null)
                    model.setWyBlFlg(wyBlFlg[i]);
                if (ffCntCd[i] != null)
                    model.setFfCntCd(ffCntCd[i]);
                if (siCntcNm[i] != null)
                    model.setSiCntcNm(siCntcNm[i]);
                if (cntcNm[i] != null)
                    model.setCntcNm(cntcNm[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (siFax[i] != null)
                    model.setSiFax(siFax[i]);
                if (siCntcEml[i] != null)
                    model.setSiCntcEml(siCntcEml[i]);
                if (mtyPkupDt[i] != null)
                    model.setMtyPkupDt(mtyPkupDt[i]);
                if (troPkupDt[i] != null)
                    model.setTroPkupDt(troPkupDt[i]);
                if (splitStsCd[i] != null)
                    model.setSplitStsCd(splitStsCd[i]);
                if (nonNegoRtInclKnt[i] != null)
                    model.setNonNegoRtInclKnt(nonNegoRtInclKnt[i]);
                if (nonNegoRtXcldKnt[i] != null)
                    model.setNonNegoRtXcldKnt(nonNegoRtXcldKnt[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (siRefNo[i] != null)
                    model.setSiRefNo(siRefNo[i]);
                if (invRefNo[i] != null)
                    model.setInvRefNo(invRefNo[i]);
                if (regBkgNo[i] != null)
                    model.setRegBkgNo(regBkgNo[i]);
                if (extMrnNo[i] != null)
                    model.setExtMrnNo(extMrnNo[i]);
                if (porYdCd[i] != null)
                    model.setPorYdCd(porYdCd[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (delYdCd[i] != null)
                    model.setDelYdCd(delYdCd[i]);
                if (custId[i] != null)
                    model.setCustId(custId[i]);
                if (flexHgtFlg[i] != null)
                    model.setFlexHgtFlg(flexHgtFlg[i]);
                if (sysUpldFlg[i] != null)
                    model.setSysUpldFlg(sysUpldFlg[i]);
                if (siAudFlg[i] != null)
                    model.setSiAudFlg(siAudFlg[i]);
                if (cmpbRtFlg[i] != null)
                    model.setCmpbRtFlg(cmpbRtFlg[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (spcCtrlrRmk[i] != null)
                    model.setSpcCtrlrRmk(spcCtrlrRmk[i]);
                if (bkgShRefNo[i] != null) 
		    		model.setBkgShRefNo(bkgShRefNo[i]);
				if (bkgFfRefNo[i] != null) 
		    		model.setBkgFfRefNo(bkgFfRefNo[i]);
				if (siShRefNo[i] != null) 
		    		model.setSiShRefNo(siShRefNo[i]);
				if (siFfRefNo[i] != null) 
		    		model.setSiFfRefNo(siFfRefNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getXterRqstMstVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return XterRqstMstVO[]
	 */
    public XterRqstMstVO[] getXterRqstMstVOs() {
        XterRqstMstVO[] vos = (XterRqstMstVO[]) models.toArray(new XterRqstMstVO[models.size()]);
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
        this.xterChgArrFlg = this.xterChgArrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoCtnt = this.blNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tel = this.tel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNm = this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siMobile = this.siMobile.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoNotification = this.autoNotification.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.departureDt = this.departureDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scRfa = this.scRfa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blIssDt = this.blIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestNm = this.fnlDestNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCustSeq = this.shCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hblKnt = this.hblKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.returnDt = this.returnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptUsrId = this.xterRqstAcptUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsNm = this.bkgUpldStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndCstmsFileCd = this.cndCstmsFileCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRefNo = this.custRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterAgnDpFlg = this.xterAgnDpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fax = this.fax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.snaccsSplitNo = this.snaccsSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtTermCd = this.frtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmWgtUtCd = this.estmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usaCstmsFileCtnt = this.usaCstmsFileCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptCd = this.xterRqstAcptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNm = this.porNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCustNm = this.shCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTerm = this.rcvTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dlvTerm = this.dlvTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterListDpFlg = this.xterListDpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siTel = this.siTel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mobile = this.mobile.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaNm = this.xterRqstViaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstStsCd = this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffCustSeq = this.ffCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsCd = this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmWgt = this.estmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffCustNm = this.ffCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scacCd = this.scacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCntCd = this.shCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaCd = this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.alps = this.alps.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rmk = this.rmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptUsrNm = this.xterRqstAcptUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNm = this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNm = this.delNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inclRtBlKnt = this.inclRtBlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslNm = this.vslNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xcldRtBlKnt = this.xcldRtBlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.twnSoNo = this.twnSoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arrivalDt = this.arrivalDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blIssLocCd = this.blIssLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wyBlFlg = this.wyBlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffCntCd = this.ffCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcNm = this.siCntcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcNm = this.cntcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siFax = this.siFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcEml = this.siCntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupDt = this.mtyPkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troPkupDt = this.troPkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitStsCd = this.splitStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoRtInclKnt = this.nonNegoRtInclKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoRtXcldKnt = this.nonNegoRtXcldKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siRefNo = this.siRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRefNo = this.invRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.regBkgNo = this.regBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.extMrnNo = this.extMrnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porYdCd = this.porYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delYdCd = this.delYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custId = this.custId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flexHgtFlg = this.flexHgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysUpldFlg = this.sysUpldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siAudFlg = this.siAudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmpbRtFlg = this.cmpbRtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spcCtrlrRmk = this.spcCtrlrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgShRefNo = this.bkgShRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgFfRefNo = this.bkgFfRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siShRefNo = this.siShRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siFfRefNo = this.siFfRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
