/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AlpsBkgVO.java
*@FileTitle : AlpsBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.22 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AlpsBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AlpsBkgVO> models = new ArrayList<AlpsBkgVO>();
	
	/* Column Info */
	private String bkCntcPsonMphnNo = null;
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String delYdCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String autoNotification = null;
	/* Column Info */
	private String shSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String pkupDate = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String fnlDestNm = null;
	/* Column Info */
	private String siFlg = null;
	/* Column Info */
	private String mnlBkgNoFlg = null;
	/* Column Info */
	private String bkCntcPsonPhnNo = null;
	/* Column Info */
	private String xterSiRefNo = null;
	/* Column Info */
	private String orgScontiCd = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String bkCntcPsonNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediHldFlg = null;
	/* Column Info */
	private String dlvTerm = null;
	/* Column Info */
	private String fCustSubstFlg = null;
	/* Column Info */
	private String siCntcPsonFaxNo = null;
	/* Column Info */
	private String partialVvdAssignFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String loadingDate = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* Column Info */
	private String siCntcPsonPhnNo = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String fCustExistFlg = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String fullPkupYdCd = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String bkCntcPsonEml = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String destScontiCd = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String siCntcPsonMphnNo = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String doorDate = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String mstBkgNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String docTpCd = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String rollOvrCnt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String sCustSubstFlg = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String deliveryDate = null;
	/* Column Info */
	private String bkCntcPsonFaxNo = null;
	/* Column Info */
	private String bkgUpldStsNm = null;
	/* Column Info */
	private String xterSiCd = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String xterBkgRqstCd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String fnlDestCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ffCnt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String rcvTerm = null;
	/* Column Info */
	private String sCustExistFlg = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String vvdFlg = null;
	/* Column Info */
	private String xterBkgRqstRefNo = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String orgTrnsSvcModCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String siCntcPsonEml = null;
	/* Column Info */
	private String bkgUpldStsCd = null;
	/* Column Info */
	private String porYdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String siCntcPsonNm = null;
	/* Column Info */
	private String premiumAvailableFlg = null;
	/* Column Info */
	private String ffNm = null;
	/* Column Info */
	private String twnSoNo = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String shCnt = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String ctrtType = null;
	/* Column Info */
	private String mtyRtnYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AlpsBkgVO() {}

	public AlpsBkgVO(String ibflag, String pagerows, String bkgNo, String pctlNo, String mstBkgNo, String mnlBkgNoFlg, String bkgUpldStsCd, String bkgUpldStsNm, String blNo, String docTpCd, String shCnt, String shSeq, String shNm, String sCustSubstFlg, String sCustExistFlg, String ffCnt, String ffSeq, String ffNm, String fCustSubstFlg, String fCustExistFlg, String obSrepCd, String obSlsOfcCd, String vvd, String vslEngNm, String porCd, String porYdCd, String porNm, String polCd, String polYdCd, String polNm, String podCd, String podYdCd, String podNm, String delCd, String delYdCd, String delNm, String preRlyPortCd, String pstRlyPortCd, String fnlDestCd, String fnlDestNm, String rcvTerm, String dlvTerm, String orgScontiCd, String destScontiCd, String orgTrnsSvcModCd, String destTrnsSvcModCd, String orgTrnsModCd, String destTrnsModCd, String frtTermCd, String ctrtType, String scNo, String rfaNo, String taaNo, String twnSoNo, String cmdtCd, String cmdtNm, String repCmdtCd, String repCmdtNm, String usaCstmsFileCd, String cndCstmsFileCd, String actWgt, String wgtUtCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String socFlg, String flexHgtFlg, String doorDate, String loadingDate, String deliveryDate, String mtyPkupYdCd, String pkupDate, String fullRtnYdCd, String mtyRtnYdCd, String fullPkupYdCd, String xterRmk, String interRmk, String bdrFlg, String caFlg, String ediHldFlg, String autoNotification, String bkCntcPsonNm, String bkCntcPsonPhnNo, String bkCntcPsonMphnNo, String bkCntcPsonFaxNo, String bkCntcPsonEml, String siCntcPsonNm, String siCntcPsonPhnNo, String siCntcPsonMphnNo, String siCntcPsonFaxNo, String siCntcPsonEml, String bkgStsCd, String xterBkgRqstCd, String xterBkgRqstRefNo, String siFlg, String xterSiCd, String xterSiRefNo, String rollOvrCnt, String premiumAvailableFlg, String partialVvdAssignFlg, String vvdFlg) {
		this.bkCntcPsonMphnNo = bkCntcPsonMphnNo;
		this.orgTrnsModCd = orgTrnsModCd;
		this.delYdCd = delYdCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.autoNotification = autoNotification;
		this.shSeq = shSeq;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.pkupDate = pkupDate;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.fnlDestNm = fnlDestNm;
		this.siFlg = siFlg;
		this.mnlBkgNoFlg = mnlBkgNoFlg;
		this.bkCntcPsonPhnNo = bkCntcPsonPhnNo;
		this.xterSiRefNo = xterSiRefNo;
		this.orgScontiCd = orgScontiCd;
		this.fullRtnYdCd = fullRtnYdCd;
		this.bkCntcPsonNm = bkCntcPsonNm;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ediHldFlg = ediHldFlg;
		this.dlvTerm = dlvTerm;
		this.fCustSubstFlg = fCustSubstFlg;
		this.siCntcPsonFaxNo = siCntcPsonFaxNo;
		this.partialVvdAssignFlg = partialVvdAssignFlg;
		this.rcFlg = rcFlg;
		this.loadingDate = loadingDate;
		this.destTrnsModCd = destTrnsModCd;
		this.siCntcPsonPhnNo = siCntcPsonPhnNo;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgStsCd = bkgStsCd;
		this.interRmk = interRmk;
		this.fCustExistFlg = fCustExistFlg;
		this.cmdtCd = cmdtCd;
		this.fullPkupYdCd = fullPkupYdCd;
		this.shNm = shNm;
		this.bkCntcPsonEml = bkCntcPsonEml;
		this.podNm = podNm;
		this.delNm = delNm;
		this.destScontiCd = destScontiCd;
		this.taaNo = taaNo;
		this.siCntcPsonMphnNo = siCntcPsonMphnNo;
		this.flexHgtFlg = flexHgtFlg;
		this.repCmdtCd = repCmdtCd;
		this.doorDate = doorDate;
		this.polNm = polNm;
		this.mstBkgNo = mstBkgNo;
		this.blNo = blNo;
		this.docTpCd = docTpCd;
		this.pctlNo = pctlNo;
		this.polCd = polCd;
		this.ffSeq = ffSeq;
		this.rollOvrCnt = rollOvrCnt;
		this.scNo = scNo;
		this.wgtUtCd = wgtUtCd;
		this.sCustSubstFlg = sCustSubstFlg;
		this.obSlsOfcCd = obSlsOfcCd;
		this.deliveryDate = deliveryDate;
		this.bkCntcPsonFaxNo = bkCntcPsonFaxNo;
		this.bkgUpldStsNm = bkgUpldStsNm;
		this.xterSiCd = xterSiCd;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.xterBkgRqstCd = xterBkgRqstCd;
		this.preRlyPortCd = preRlyPortCd;
		this.repCmdtNm = repCmdtNm;
		this.awkCgoFlg = awkCgoFlg;
		this.frtTermCd = frtTermCd;
		this.fnlDestCd = fnlDestCd;
		this.delCd = delCd;
		this.ffCnt = ffCnt;
		this.vvd = vvd;
		this.porNm = porNm;
		this.rcvTerm = rcvTerm;
		this.sCustExistFlg = sCustExistFlg;
		this.xterRmk = xterRmk;
		this.vvdFlg = vvdFlg;
		this.xterBkgRqstRefNo = xterBkgRqstRefNo;
		this.pstRlyPortCd = pstRlyPortCd;
		this.porCd = porCd;
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
		this.bdrFlg = bdrFlg;
		this.siCntcPsonEml = siCntcPsonEml;
		this.bkgUpldStsCd = bkgUpldStsCd;
		this.porYdCd = porYdCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.caFlg = caFlg;
		this.podYdCd = podYdCd;
		this.siCntcPsonNm = siCntcPsonNm;
		this.premiumAvailableFlg = premiumAvailableFlg;
		this.ffNm = ffNm;
		this.twnSoNo = twnSoNo;
		this.cmdtNm = cmdtNm;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.actWgt = actWgt;
		this.socFlg = socFlg;
		this.shCnt = shCnt;
		this.polYdCd = polYdCd;
		this.ctrtType = ctrtType;
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bk_cntc_pson_mphn_no", getBkCntcPsonMphnNo());
		this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
		this.hashColumns.put("del_yd_cd", getDelYdCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("auto_notification", getAutoNotification());
		this.hashColumns.put("sh_seq", getShSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("pkup_date", getPkupDate());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("fnl_dest_nm", getFnlDestNm());
		this.hashColumns.put("si_flg", getSiFlg());
		this.hashColumns.put("mnl_bkg_no_flg", getMnlBkgNoFlg());
		this.hashColumns.put("bk_cntc_pson_phn_no", getBkCntcPsonPhnNo());
		this.hashColumns.put("xter_si_ref_no", getXterSiRefNo());
		this.hashColumns.put("org_sconti_cd", getOrgScontiCd());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("bk_cntc_pson_nm", getBkCntcPsonNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
		this.hashColumns.put("dlv_term", getDlvTerm());
		this.hashColumns.put("f_cust_subst_flg", getFCustSubstFlg());
		this.hashColumns.put("si_cntc_pson_fax_no", getSiCntcPsonFaxNo());
		this.hashColumns.put("partial_vvd_assign_flg", getPartialVvdAssignFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("loading_date", getLoadingDate());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		this.hashColumns.put("si_cntc_pson_phn_no", getSiCntcPsonPhnNo());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("f_cust_exist_flg", getFCustExistFlg());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("full_pkup_yd_cd", getFullPkupYdCd());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("bk_cntc_pson_eml", getBkCntcPsonEml());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("dest_sconti_cd", getDestScontiCd());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("si_cntc_pson_mphn_no", getSiCntcPsonMphnNo());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("door_date", getDoorDate());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("mst_bkg_no", getMstBkgNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("roll_ovr_cnt", getRollOvrCnt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("s_cust_subst_flg", getSCustSubstFlg());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("delivery_date", getDeliveryDate());
		this.hashColumns.put("bk_cntc_pson_fax_no", getBkCntcPsonFaxNo());
		this.hashColumns.put("bkg_upld_sts_nm", getBkgUpldStsNm());
		this.hashColumns.put("xter_si_cd", getXterSiCd());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("xter_bkg_rqst_cd", getXterBkgRqstCd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("fnl_dest_cd", getFnlDestCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ff_cnt", getFfCnt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("rcv_term", getRcvTerm());
		this.hashColumns.put("s_cust_exist_flg", getSCustExistFlg());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("vvd_flg", getVvdFlg());
		this.hashColumns.put("xter_bkg_rqst_ref_no", getXterBkgRqstRefNo());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("si_cntc_pson_eml", getSiCntcPsonEml());
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("si_cntc_pson_nm", getSiCntcPsonNm());
		this.hashColumns.put("premium_available_flg", getPremiumAvailableFlg());
		this.hashColumns.put("ff_nm", getFfNm());
		this.hashColumns.put("twn_so_no", getTwnSoNo());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("sh_cnt", getShCnt());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("ctrt_type", getCtrtType());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bk_cntc_pson_mphn_no", "bkCntcPsonMphnNo");
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("del_yd_cd", "delYdCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("auto_notification", "autoNotification");
		this.hashFields.put("sh_seq", "shSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("pkup_date", "pkupDate");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("fnl_dest_nm", "fnlDestNm");
		this.hashFields.put("si_flg", "siFlg");
		this.hashFields.put("mnl_bkg_no_flg", "mnlBkgNoFlg");
		this.hashFields.put("bk_cntc_pson_phn_no", "bkCntcPsonPhnNo");
		this.hashFields.put("xter_si_ref_no", "xterSiRefNo");
		this.hashFields.put("org_sconti_cd", "orgScontiCd");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("bk_cntc_pson_nm", "bkCntcPsonNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_hld_flg", "ediHldFlg");
		this.hashFields.put("dlv_term", "dlvTerm");
		this.hashFields.put("f_cust_subst_flg", "fCustSubstFlg");
		this.hashFields.put("si_cntc_pson_fax_no", "siCntcPsonFaxNo");
		this.hashFields.put("partial_vvd_assign_flg", "partialVvdAssignFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("loading_date", "loadingDate");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("si_cntc_pson_phn_no", "siCntcPsonPhnNo");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("f_cust_exist_flg", "fCustExistFlg");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("bk_cntc_pson_eml", "bkCntcPsonEml");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("dest_sconti_cd", "destScontiCd");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("si_cntc_pson_mphn_no", "siCntcPsonMphnNo");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("door_date", "doorDate");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("mst_bkg_no", "mstBkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("roll_ovr_cnt", "rollOvrCnt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("s_cust_subst_flg", "sCustSubstFlg");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("delivery_date", "deliveryDate");
		this.hashFields.put("bk_cntc_pson_fax_no", "bkCntcPsonFaxNo");
		this.hashFields.put("bkg_upld_sts_nm", "bkgUpldStsNm");
		this.hashFields.put("xter_si_cd", "xterSiCd");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("xter_bkg_rqst_cd", "xterBkgRqstCd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("fnl_dest_cd", "fnlDestCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ff_cnt", "ffCnt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("rcv_term", "rcvTerm");
		this.hashFields.put("s_cust_exist_flg", "sCustExistFlg");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("vvd_flg", "vvdFlg");
		this.hashFields.put("xter_bkg_rqst_ref_no", "xterBkgRqstRefNo");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("si_cntc_pson_eml", "siCntcPsonEml");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("por_yd_cd", "porYdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("si_cntc_pson_nm", "siCntcPsonNm");
		this.hashFields.put("premium_available_flg", "premiumAvailableFlg");
		this.hashFields.put("ff_nm", "ffNm");
		this.hashFields.put("twn_so_no", "twnSoNo");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("sh_cnt", "shCnt");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("ctrt_type", "ctrtType");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkCntcPsonMphnNo
	 */
	public String getBkCntcPsonMphnNo() {
		return this.bkCntcPsonMphnNo;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsModCd
	 */
	public String getOrgTrnsModCd() {
		return this.orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return delYdCd
	 */
	public String getDelYdCd() {
		return this.delYdCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return autoNotification
	 */
	public String getAutoNotification() {
		return this.autoNotification;
	}
	
	/**
	 * Column Info
	 * @return shSeq
	 */
	public String getShSeq() {
		return this.shSeq;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return pkupDate
	 */
	public String getPkupDate() {
		return this.pkupDate;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestNm
	 */
	public String getFnlDestNm() {
		return this.fnlDestNm;
	}
	
	/**
	 * Column Info
	 * @return siFlg
	 */
	public String getSiFlg() {
		return this.siFlg;
	}
	
	/**
	 * Column Info
	 * @return mnlBkgNoFlg
	 */
	public String getMnlBkgNoFlg() {
		return this.mnlBkgNoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkCntcPsonPhnNo
	 */
	public String getBkCntcPsonPhnNo() {
		return this.bkCntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @return xterSiRefNo
	 */
	public String getXterSiRefNo() {
		return this.xterSiRefNo;
	}
	
	/**
	 * Column Info
	 * @return orgScontiCd
	 */
	public String getOrgScontiCd() {
		return this.orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkCntcPsonNm
	 */
	public String getBkCntcPsonNm() {
		return this.bkCntcPsonNm;
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
	 * @return ediHldFlg
	 */
	public String getEdiHldFlg() {
		return this.ediHldFlg;
	}
	
	/**
	 * Column Info
	 * @return dlvTerm
	 */
	public String getDlvTerm() {
		return this.dlvTerm;
	}
	
	/**
	 * Column Info
	 * @return fCustSubstFlg
	 */
	public String getFCustSubstFlg() {
		return this.fCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return siCntcPsonFaxNo
	 */
	public String getSiCntcPsonFaxNo() {
		return this.siCntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @return partialVvdAssignFlg
	 */
	public String getPartialVvdAssignFlg() {
		return this.partialVvdAssignFlg;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return loadingDate
	 */
	public String getLoadingDate() {
		return this.loadingDate;
	}
	
	/**
	 * Column Info
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return siCntcPsonPhnNo
	 */
	public String getSiCntcPsonPhnNo() {
		return this.siCntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return fCustExistFlg
	 */
	public String getFCustExistFlg() {
		return this.fCustExistFlg;
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
	 * @return fullPkupYdCd
	 */
	public String getFullPkupYdCd() {
		return this.fullPkupYdCd;
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
	 * @return bkCntcPsonEml
	 */
	public String getBkCntcPsonEml() {
		return this.bkCntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return destScontiCd
	 */
	public String getDestScontiCd() {
		return this.destScontiCd;
	}
	
	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return siCntcPsonMphnNo
	 */
	public String getSiCntcPsonMphnNo() {
		return this.siCntcPsonMphnNo;
	}
	
	/**
	 * Column Info
	 * @return flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return doorDate
	 */
	public String getDoorDate() {
		return this.doorDate;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return mstBkgNo
	 */
	public String getMstBkgNo() {
		return this.mstBkgNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
	}
	
	/**
	 * Column Info
	 * @return rollOvrCnt
	 */
	public String getRollOvrCnt() {
		return this.rollOvrCnt;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return sCustSubstFlg
	 */
	public String getSCustSubstFlg() {
		return this.sCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return deliveryDate
	 */
	public String getDeliveryDate() {
		return this.deliveryDate;
	}
	
	/**
	 * Column Info
	 * @return bkCntcPsonFaxNo
	 */
	public String getBkCntcPsonFaxNo() {
		return this.bkCntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @return bkgUpldStsNm
	 */
	public String getBkgUpldStsNm() {
		return this.bkgUpldStsNm;
	}
	
	/**
	 * Column Info
	 * @return xterSiCd
	 */
	public String getXterSiCd() {
		return this.xterSiCd;
	}
	
	/**
	 * Column Info
	 * @return cndCstmsFileCd
	 */
	public String getCndCstmsFileCd() {
		return this.cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return xterBkgRqstCd
	 */
	public String getXterBkgRqstCd() {
		return this.xterBkgRqstCd;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestCd
	 */
	public String getFnlDestCd() {
		return this.fnlDestCd;
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
	 * @return ffCnt
	 */
	public String getFfCnt() {
		return this.ffCnt;
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
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
	}
	
	/**
	 * Column Info
	 * @return rcvTerm
	 */
	public String getRcvTerm() {
		return this.rcvTerm;
	}
	
	/**
	 * Column Info
	 * @return sCustExistFlg
	 */
	public String getSCustExistFlg() {
		return this.sCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return vvdFlg
	 */
	public String getVvdFlg() {
		return this.vvdFlg;
	}
	
	/**
	 * Column Info
	 * @return xterBkgRqstRefNo
	 */
	public String getXterBkgRqstRefNo() {
		return this.xterBkgRqstRefNo;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
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
	 * @return orgTrnsSvcModCd
	 */
	public String getOrgTrnsSvcModCd() {
		return this.orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return siCntcPsonEml
	 */
	public String getSiCntcPsonEml() {
		return this.siCntcPsonEml;
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
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
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
	 * @return siCntcPsonNm
	 */
	public String getSiCntcPsonNm() {
		return this.siCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return premiumAvailableFlg
	 */
	public String getPremiumAvailableFlg() {
		return this.premiumAvailableFlg;
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
	 * @return twnSoNo
	 */
	public String getTwnSoNo() {
		return this.twnSoNo;
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
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return shCnt
	 */
	public String getShCnt() {
		return this.shCnt;
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
	 * @return ctrtType
	 */
	public String getCtrtType() {
		return this.ctrtType;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return this.mtyRtnYdCd;
	}
	

	/**
	 * Column Info
	 * @param bkCntcPsonMphnNo
	 */
	public void setBkCntcPsonMphnNo(String bkCntcPsonMphnNo) {
		this.bkCntcPsonMphnNo = bkCntcPsonMphnNo;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsModCd
	 */
	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param delYdCd
	 */
	public void setDelYdCd(String delYdCd) {
		this.delYdCd = delYdCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param autoNotification
	 */
	public void setAutoNotification(String autoNotification) {
		this.autoNotification = autoNotification;
	}
	
	/**
	 * Column Info
	 * @param shSeq
	 */
	public void setShSeq(String shSeq) {
		this.shSeq = shSeq;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param pkupDate
	 */
	public void setPkupDate(String pkupDate) {
		this.pkupDate = pkupDate;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestNm
	 */
	public void setFnlDestNm(String fnlDestNm) {
		this.fnlDestNm = fnlDestNm;
	}
	
	/**
	 * Column Info
	 * @param siFlg
	 */
	public void setSiFlg(String siFlg) {
		this.siFlg = siFlg;
	}
	
	/**
	 * Column Info
	 * @param mnlBkgNoFlg
	 */
	public void setMnlBkgNoFlg(String mnlBkgNoFlg) {
		this.mnlBkgNoFlg = mnlBkgNoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkCntcPsonPhnNo
	 */
	public void setBkCntcPsonPhnNo(String bkCntcPsonPhnNo) {
		this.bkCntcPsonPhnNo = bkCntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @param xterSiRefNo
	 */
	public void setXterSiRefNo(String xterSiRefNo) {
		this.xterSiRefNo = xterSiRefNo;
	}
	
	/**
	 * Column Info
	 * @param orgScontiCd
	 */
	public void setOrgScontiCd(String orgScontiCd) {
		this.orgScontiCd = orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkCntcPsonNm
	 */
	public void setBkCntcPsonNm(String bkCntcPsonNm) {
		this.bkCntcPsonNm = bkCntcPsonNm;
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
	 * @param ediHldFlg
	 */
	public void setEdiHldFlg(String ediHldFlg) {
		this.ediHldFlg = ediHldFlg;
	}
	
	/**
	 * Column Info
	 * @param dlvTerm
	 */
	public void setDlvTerm(String dlvTerm) {
		this.dlvTerm = dlvTerm;
	}
	
	/**
	 * Column Info
	 * @param fCustSubstFlg
	 */
	public void setFCustSubstFlg(String fCustSubstFlg) {
		this.fCustSubstFlg = fCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param siCntcPsonFaxNo
	 */
	public void setSiCntcPsonFaxNo(String siCntcPsonFaxNo) {
		this.siCntcPsonFaxNo = siCntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @param partialVvdAssignFlg
	 */
	public void setPartialVvdAssignFlg(String partialVvdAssignFlg) {
		this.partialVvdAssignFlg = partialVvdAssignFlg;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param loadingDate
	 */
	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}
	
	/**
	 * Column Info
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param siCntcPsonPhnNo
	 */
	public void setSiCntcPsonPhnNo(String siCntcPsonPhnNo) {
		this.siCntcPsonPhnNo = siCntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param fCustExistFlg
	 */
	public void setFCustExistFlg(String fCustExistFlg) {
		this.fCustExistFlg = fCustExistFlg;
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
	 * @param fullPkupYdCd
	 */
	public void setFullPkupYdCd(String fullPkupYdCd) {
		this.fullPkupYdCd = fullPkupYdCd;
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
	 * @param bkCntcPsonEml
	 */
	public void setBkCntcPsonEml(String bkCntcPsonEml) {
		this.bkCntcPsonEml = bkCntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param destScontiCd
	 */
	public void setDestScontiCd(String destScontiCd) {
		this.destScontiCd = destScontiCd;
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
	 * @param siCntcPsonMphnNo
	 */
	public void setSiCntcPsonMphnNo(String siCntcPsonMphnNo) {
		this.siCntcPsonMphnNo = siCntcPsonMphnNo;
	}
	
	/**
	 * Column Info
	 * @param flexHgtFlg
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param doorDate
	 */
	public void setDoorDate(String doorDate) {
		this.doorDate = doorDate;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param mstBkgNo
	 */
	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
	}
	
	/**
	 * Column Info
	 * @param rollOvrCnt
	 */
	public void setRollOvrCnt(String rollOvrCnt) {
		this.rollOvrCnt = rollOvrCnt;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param sCustSubstFlg
	 */
	public void setSCustSubstFlg(String sCustSubstFlg) {
		this.sCustSubstFlg = sCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param deliveryDate
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * Column Info
	 * @param bkCntcPsonFaxNo
	 */
	public void setBkCntcPsonFaxNo(String bkCntcPsonFaxNo) {
		this.bkCntcPsonFaxNo = bkCntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @param bkgUpldStsNm
	 */
	public void setBkgUpldStsNm(String bkgUpldStsNm) {
		this.bkgUpldStsNm = bkgUpldStsNm;
	}
	
	/**
	 * Column Info
	 * @param xterSiCd
	 */
	public void setXterSiCd(String xterSiCd) {
		this.xterSiCd = xterSiCd;
	}
	
	/**
	 * Column Info
	 * @param cndCstmsFileCd
	 */
	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param xterBkgRqstCd
	 */
	public void setXterBkgRqstCd(String xterBkgRqstCd) {
		this.xterBkgRqstCd = xterBkgRqstCd;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestCd
	 */
	public void setFnlDestCd(String fnlDestCd) {
		this.fnlDestCd = fnlDestCd;
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
	 * @param ffCnt
	 */
	public void setFfCnt(String ffCnt) {
		this.ffCnt = ffCnt;
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
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
	}
	
	/**
	 * Column Info
	 * @param rcvTerm
	 */
	public void setRcvTerm(String rcvTerm) {
		this.rcvTerm = rcvTerm;
	}
	
	/**
	 * Column Info
	 * @param sCustExistFlg
	 */
	public void setSCustExistFlg(String sCustExistFlg) {
		this.sCustExistFlg = sCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param vvdFlg
	 */
	public void setVvdFlg(String vvdFlg) {
		this.vvdFlg = vvdFlg;
	}
	
	/**
	 * Column Info
	 * @param xterBkgRqstRefNo
	 */
	public void setXterBkgRqstRefNo(String xterBkgRqstRefNo) {
		this.xterBkgRqstRefNo = xterBkgRqstRefNo;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
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
	 * @param orgTrnsSvcModCd
	 */
	public void setOrgTrnsSvcModCd(String orgTrnsSvcModCd) {
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param siCntcPsonEml
	 */
	public void setSiCntcPsonEml(String siCntcPsonEml) {
		this.siCntcPsonEml = siCntcPsonEml;
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
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
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
	 * @param siCntcPsonNm
	 */
	public void setSiCntcPsonNm(String siCntcPsonNm) {
		this.siCntcPsonNm = siCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param premiumAvailableFlg
	 */
	public void setPremiumAvailableFlg(String premiumAvailableFlg) {
		this.premiumAvailableFlg = premiumAvailableFlg;
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
	 * @param twnSoNo
	 */
	public void setTwnSoNo(String twnSoNo) {
		this.twnSoNo = twnSoNo;
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
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param shCnt
	 */
	public void setShCnt(String shCnt) {
		this.shCnt = shCnt;
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
	 * @param ctrtType
	 */
	public void setCtrtType(String ctrtType) {
		this.ctrtType = ctrtType;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBkCntcPsonMphnNo(JSPUtil.getParameter(request, prefix + "bk_cntc_pson_mphn_no", ""));
		setOrgTrnsModCd(JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", ""));
		setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setAutoNotification(JSPUtil.getParameter(request, prefix + "auto_notification", ""));
		setShSeq(JSPUtil.getParameter(request, prefix + "sh_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setPkupDate(JSPUtil.getParameter(request, prefix + "pkup_date", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
		setFnlDestNm(JSPUtil.getParameter(request, prefix + "fnl_dest_nm", ""));
		setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
		setMnlBkgNoFlg(JSPUtil.getParameter(request, prefix + "mnl_bkg_no_flg", ""));
		setBkCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "bk_cntc_pson_phn_no", ""));
		setXterSiRefNo(JSPUtil.getParameter(request, prefix + "xter_si_ref_no", ""));
		setOrgScontiCd(JSPUtil.getParameter(request, prefix + "org_sconti_cd", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setBkCntcPsonNm(JSPUtil.getParameter(request, prefix + "bk_cntc_pson_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
		setDlvTerm(JSPUtil.getParameter(request, prefix + "dlv_term", ""));
		setFCustSubstFlg(JSPUtil.getParameter(request, prefix + "f_cust_subst_flg", ""));
		setSiCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_fax_no", ""));
		setPartialVvdAssignFlg(JSPUtil.getParameter(request, prefix + "partial_vvd_assign_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setLoadingDate(JSPUtil.getParameter(request, prefix + "loading_date", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
		setSiCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_phn_no", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setFCustExistFlg(JSPUtil.getParameter(request, prefix + "f_cust_exist_flg", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setFullPkupYdCd(JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setBkCntcPsonEml(JSPUtil.getParameter(request, prefix + "bk_cntc_pson_eml", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setDestScontiCd(JSPUtil.getParameter(request, prefix + "dest_sconti_cd", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setSiCntcPsonMphnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_mphn_no", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setDoorDate(JSPUtil.getParameter(request, prefix + "door_date", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setMstBkgNo(JSPUtil.getParameter(request, prefix + "mst_bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setRollOvrCnt(JSPUtil.getParameter(request, prefix + "roll_ovr_cnt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setSCustSubstFlg(JSPUtil.getParameter(request, prefix + "s_cust_subst_flg", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setDeliveryDate(JSPUtil.getParameter(request, prefix + "delivery_date", ""));
		setBkCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "bk_cntc_pson_fax_no", ""));
		setBkgUpldStsNm(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_nm", ""));
		setXterSiCd(JSPUtil.getParameter(request, prefix + "xter_si_cd", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
		setXterBkgRqstCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setFnlDestCd(JSPUtil.getParameter(request, prefix + "fnl_dest_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFfCnt(JSPUtil.getParameter(request, prefix + "ff_cnt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setRcvTerm(JSPUtil.getParameter(request, prefix + "rcv_term", ""));
		setSCustExistFlg(JSPUtil.getParameter(request, prefix + "s_cust_exist_flg", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setVvdFlg(JSPUtil.getParameter(request, prefix + "vvd_flg", ""));
		setXterBkgRqstRefNo(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setSiCntcPsonEml(JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
		setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setSiCntcPsonNm(JSPUtil.getParameter(request, prefix + "si_cntc_pson_nm", ""));
		setPremiumAvailableFlg(JSPUtil.getParameter(request, prefix + "premium_available_flg", ""));
		setFfNm(JSPUtil.getParameter(request, prefix + "ff_nm", ""));
		setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setShCnt(JSPUtil.getParameter(request, prefix + "sh_cnt", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setCtrtType(JSPUtil.getParameter(request, prefix + "ctrt_type", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_rtn_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AlpsBkgVO[]
	 */
	public AlpsBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AlpsBkgVO[]
	 */
	public AlpsBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AlpsBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkCntcPsonMphnNo = (JSPUtil.getParameter(request, prefix	+ "bk_cntc_pson_mphn_no", length));
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] delYdCd = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] autoNotification = (JSPUtil.getParameter(request, prefix	+ "auto_notification", length));
			String[] shSeq = (JSPUtil.getParameter(request, prefix	+ "sh_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] pkupDate = (JSPUtil.getParameter(request, prefix	+ "pkup_date", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] fnlDestNm = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_nm", length));
			String[] siFlg = (JSPUtil.getParameter(request, prefix	+ "si_flg", length));
			String[] mnlBkgNoFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_bkg_no_flg", length));
			String[] bkCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "bk_cntc_pson_phn_no", length));
			String[] xterSiRefNo = (JSPUtil.getParameter(request, prefix	+ "xter_si_ref_no", length));
			String[] orgScontiCd = (JSPUtil.getParameter(request, prefix	+ "org_sconti_cd", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] bkCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "bk_cntc_pson_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediHldFlg = (JSPUtil.getParameter(request, prefix	+ "edi_hld_flg", length));
			String[] dlvTerm = (JSPUtil.getParameter(request, prefix	+ "dlv_term", length));
			String[] fCustSubstFlg = (JSPUtil.getParameter(request, prefix	+ "f_cust_subst_flg", length));
			String[] siCntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_fax_no", length));
			String[] partialVvdAssignFlg = (JSPUtil.getParameter(request, prefix	+ "partial_vvd_assign_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] loadingDate = (JSPUtil.getParameter(request, prefix	+ "loading_date", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] siCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_phn_no", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] fCustExistFlg = (JSPUtil.getParameter(request, prefix	+ "f_cust_exist_flg", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "full_pkup_yd_cd", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] bkCntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "bk_cntc_pson_eml", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] destScontiCd = (JSPUtil.getParameter(request, prefix	+ "dest_sconti_cd", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] siCntcPsonMphnNo = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_mphn_no", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] doorDate = (JSPUtil.getParameter(request, prefix	+ "door_date", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] mstBkgNo = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] rollOvrCnt = (JSPUtil.getParameter(request, prefix	+ "roll_ovr_cnt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] sCustSubstFlg = (JSPUtil.getParameter(request, prefix	+ "s_cust_subst_flg", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] deliveryDate = (JSPUtil.getParameter(request, prefix	+ "delivery_date", length));
			String[] bkCntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "bk_cntc_pson_fax_no", length));
			String[] bkgUpldStsNm = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_nm", length));
			String[] xterSiCd = (JSPUtil.getParameter(request, prefix	+ "xter_si_cd", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] xterBkgRqstCd = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_cd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] fnlDestCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ffCnt = (JSPUtil.getParameter(request, prefix	+ "ff_cnt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] rcvTerm = (JSPUtil.getParameter(request, prefix	+ "rcv_term", length));
			String[] sCustExistFlg = (JSPUtil.getParameter(request, prefix	+ "s_cust_exist_flg", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] vvdFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_flg", length));
			String[] xterBkgRqstRefNo = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_ref_no", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_svc_mod_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] siCntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_eml", length));
			String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_cd", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] siCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_nm", length));
			String[] premiumAvailableFlg = (JSPUtil.getParameter(request, prefix	+ "premium_available_flg", length));
			String[] ffNm = (JSPUtil.getParameter(request, prefix	+ "ff_nm", length));
			String[] twnSoNo = (JSPUtil.getParameter(request, prefix	+ "twn_so_no", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] shCnt = (JSPUtil.getParameter(request, prefix	+ "sh_cnt", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] ctrtType = (JSPUtil.getParameter(request, prefix	+ "ctrt_type", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AlpsBkgVO();
				if (bkCntcPsonMphnNo[i] != null)
					model.setBkCntcPsonMphnNo(bkCntcPsonMphnNo[i]);
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (autoNotification[i] != null)
					model.setAutoNotification(autoNotification[i]);
				if (shSeq[i] != null)
					model.setShSeq(shSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (pkupDate[i] != null)
					model.setPkupDate(pkupDate[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (fnlDestNm[i] != null)
					model.setFnlDestNm(fnlDestNm[i]);
				if (siFlg[i] != null)
					model.setSiFlg(siFlg[i]);
				if (mnlBkgNoFlg[i] != null)
					model.setMnlBkgNoFlg(mnlBkgNoFlg[i]);
				if (bkCntcPsonPhnNo[i] != null)
					model.setBkCntcPsonPhnNo(bkCntcPsonPhnNo[i]);
				if (xterSiRefNo[i] != null)
					model.setXterSiRefNo(xterSiRefNo[i]);
				if (orgScontiCd[i] != null)
					model.setOrgScontiCd(orgScontiCd[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (bkCntcPsonNm[i] != null)
					model.setBkCntcPsonNm(bkCntcPsonNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediHldFlg[i] != null)
					model.setEdiHldFlg(ediHldFlg[i]);
				if (dlvTerm[i] != null)
					model.setDlvTerm(dlvTerm[i]);
				if (fCustSubstFlg[i] != null)
					model.setFCustSubstFlg(fCustSubstFlg[i]);
				if (siCntcPsonFaxNo[i] != null)
					model.setSiCntcPsonFaxNo(siCntcPsonFaxNo[i]);
				if (partialVvdAssignFlg[i] != null)
					model.setPartialVvdAssignFlg(partialVvdAssignFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (loadingDate[i] != null)
					model.setLoadingDate(loadingDate[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (siCntcPsonPhnNo[i] != null)
					model.setSiCntcPsonPhnNo(siCntcPsonPhnNo[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (fCustExistFlg[i] != null)
					model.setFCustExistFlg(fCustExistFlg[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (bkCntcPsonEml[i] != null)
					model.setBkCntcPsonEml(bkCntcPsonEml[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (destScontiCd[i] != null)
					model.setDestScontiCd(destScontiCd[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (siCntcPsonMphnNo[i] != null)
					model.setSiCntcPsonMphnNo(siCntcPsonMphnNo[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (doorDate[i] != null)
					model.setDoorDate(doorDate[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (mstBkgNo[i] != null)
					model.setMstBkgNo(mstBkgNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (rollOvrCnt[i] != null)
					model.setRollOvrCnt(rollOvrCnt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (sCustSubstFlg[i] != null)
					model.setSCustSubstFlg(sCustSubstFlg[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (deliveryDate[i] != null)
					model.setDeliveryDate(deliveryDate[i]);
				if (bkCntcPsonFaxNo[i] != null)
					model.setBkCntcPsonFaxNo(bkCntcPsonFaxNo[i]);
				if (bkgUpldStsNm[i] != null)
					model.setBkgUpldStsNm(bkgUpldStsNm[i]);
				if (xterSiCd[i] != null)
					model.setXterSiCd(xterSiCd[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (xterBkgRqstCd[i] != null)
					model.setXterBkgRqstCd(xterBkgRqstCd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (fnlDestCd[i] != null)
					model.setFnlDestCd(fnlDestCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ffCnt[i] != null)
					model.setFfCnt(ffCnt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (rcvTerm[i] != null)
					model.setRcvTerm(rcvTerm[i]);
				if (sCustExistFlg[i] != null)
					model.setSCustExistFlg(sCustExistFlg[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (vvdFlg[i] != null)
					model.setVvdFlg(vvdFlg[i]);
				if (xterBkgRqstRefNo[i] != null)
					model.setXterBkgRqstRefNo(xterBkgRqstRefNo[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (orgTrnsSvcModCd[i] != null)
					model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (siCntcPsonEml[i] != null)
					model.setSiCntcPsonEml(siCntcPsonEml[i]);
				if (bkgUpldStsCd[i] != null)
					model.setBkgUpldStsCd(bkgUpldStsCd[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (siCntcPsonNm[i] != null)
					model.setSiCntcPsonNm(siCntcPsonNm[i]);
				if (premiumAvailableFlg[i] != null)
					model.setPremiumAvailableFlg(premiumAvailableFlg[i]);
				if (ffNm[i] != null)
					model.setFfNm(ffNm[i]);
				if (twnSoNo[i] != null)
					model.setTwnSoNo(twnSoNo[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (shCnt[i] != null)
					model.setShCnt(shCnt[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (ctrtType[i] != null)
					model.setCtrtType(ctrtType[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAlpsBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AlpsBkgVO[]
	 */
	public AlpsBkgVO[] getAlpsBkgVOs(){
		AlpsBkgVO[] vos = (AlpsBkgVO[])models.toArray(new AlpsBkgVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkCntcPsonMphnNo = this.bkCntcPsonMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoNotification = this.autoNotification .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shSeq = this.shSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDate = this.pkupDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestNm = this.fnlDestNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siFlg = this.siFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBkgNoFlg = this.mnlBkgNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkCntcPsonPhnNo = this.bkCntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiRefNo = this.xterSiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgScontiCd = this.orgScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkCntcPsonNm = this.bkCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHldFlg = this.ediHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvTerm = this.dlvTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSubstFlg = this.fCustSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonFaxNo = this.siCntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partialVvdAssignFlg = this.partialVvdAssignFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadingDate = this.loadingDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonPhnNo = this.siCntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustExistFlg = this.fCustExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPkupYdCd = this.fullPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkCntcPsonEml = this.bkCntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destScontiCd = this.destScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonMphnNo = this.siCntcPsonMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorDate = this.doorDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgNo = this.mstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvrCnt = this.rollOvrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSubstFlg = this.sCustSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliveryDate = this.deliveryDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkCntcPsonFaxNo = this.bkCntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsNm = this.bkgUpldStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiCd = this.xterSiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstCd = this.xterBkgRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestCd = this.fnlDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCnt = this.ffCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTerm = this.rcvTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustExistFlg = this.sCustExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdFlg = this.vvdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstRefNo = this.xterBkgRqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsSvcModCd = this.orgTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonEml = this.siCntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd = this.bkgUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonNm = this.siCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.premiumAvailableFlg = this.premiumAvailableFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm = this.ffNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnSoNo = this.twnSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCnt = this.shCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtType = this.ctrtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
