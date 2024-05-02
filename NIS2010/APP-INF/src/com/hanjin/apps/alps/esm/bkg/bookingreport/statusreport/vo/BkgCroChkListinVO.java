/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCMCroChkListinVO.java
*@FileTitle : BkgCMCroChkListinVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.10 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCroChkListinVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCroChkListinVO> models = new ArrayList<BkgCroChkListinVO>();
	
	/* Column Info */
	private String cntrSealSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bCntrNo = null;
	/* Column Info */
	private String bCustAddrC = null;
	/* Column Info */
	private String measQtyCm = null;
	/* Column Info */
	private String custCtyNmN = null;
	/* Column Info */
	private String measQtyCo = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String bPckQtyDa = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String custCtyNmS = null;
	/* Column Info */
	private String bCustNmC = null;
	/* Column Info */
	private String bUsaCstmsFileNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String bCntrMfNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String bCntrMfGdsDesc = null;
	/* Column Info */
	private String bCustNmN = null;
	/* Column Info */
	private String bPckQtyCo = null;
	/* Column Info */
	private String custCtyNmC = null;
	/* Column Info */
	private String bPckQtyCm = null;
	/* Column Info */
	private String custNmS = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bCustNmS = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String custNmN = null;
	/* Column Info */
	private String bCntrMfMkDesc = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String bMeasQtyChk = null;
	/* Column Info */
	private String bHblWgtDa = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String custNmC = null;
	/* Column Info */
	private String bCustAddrN = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bHblNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tabItem = null;
	/* Column Info */
	private String bCustAddrS = null;
	/* Column Info */
	private String actWetChk = null;
	/* Column Info */
	private String measQtyDa = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String custAddrS = null;
	/* Column Info */
	private String bBlNo = null;
	/* Column Info */
	private String bCntrSealNo = null;
	/* Column Info */
	private String pckQtyChk = null;
	/* Column Info */
	private String custAddrN = null;
	/* Column Info */
	private String pckQtyDa = null;
	/* Column Info */
	private String bMeasQtyDa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckQtyCo = null;
	/* Column Info */
	private String custZipIdS = null;
	/* Column Info */
	private String pckQtyCm = null;
	/* Column Info */
	private String custZipIdN = null;
	/* Column Info */
	private String chkErr = null;
	/* Column Info */
	private String bPckQtyChk = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String custZipIdC = null;
	/* Column Info */
	private String custSteCdC = null;
	/* Column Info */
	private String custSteCdN = null;
	/* Column Info */
	private String bCntrWgtCm = null;
	/* Column Info */
	private String cstmsDeclCntCdC = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bCntrWgtCo = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String custAddrC = null;
	/* Column Info */
	private String bHblWetChk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String cstmsDeclCntCdS = null;
	/* Column Info */
	private String measQtyChk = null;
	/* Column Info */
	private String bMeasQtyCm = null;
	/* Column Info */
	private String bMeasQtyCo = null;
	/* Column Info */
	private String cstmsDeclCntCdN = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String custTaxIdC = null;
	/* Column Info */
	private String custTaxIdN = null;
	/* Column Info */
	private String custStNmN = null;
	/* Column Info */
	private String custTaxIdS = null;
	/* Column Info */
	private String custStNmC = null;
	/* Column Info */
	private String custStNmS = null;
	/* Column Info */
	private String custEoriNoC = null;
	/* Column Info */
	private String custEoriNoS = null;
	/* Column Info */
	private String custEoriNoN = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCroChkListinVO() {}

	public BkgCroChkListinVO(String ibflag, String pagerows, String bkgNo, String blNo, String usaCstmsFileCd, String cndCstmsFileCd, String oblIssOfcCd, String oblIssUsrId, String custNmS, String custAddrS, String custCtyNmS, String cstmsDeclCntCdS, String custZipIdS, String custNmC, String custAddrC, String custCtyNmC, String cstmsDeclCntCdC, String custSteCdC, String custZipIdC, String custNmN, String custAddrN, String custCtyNmN, String cstmsDeclCntCdN, String custSteCdN, String custZipIdN, String pckQtyDa, String actWgt, String measQtyDa, String pckQtyChk, String actWetChk, String measQtyChk, String pckQtyCm, String cntrMfWgt, String measQtyCm, String cntrMfMkDesc, String cntrMfGdsDesc, String cntrNo, String pckQtyCo, String cntrWgt, String measQtyCo, String cntrSealSeq, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String polYdCd, String podCd, String podYdCd, String custCntCd, String custSeq, String chkErr, String bkgOfcCd, String creUsrId, String obSrepCd, String tabItem, String bBlNo, String bUsaCstmsFileNo, String bHblNo, String bCustNmS, String bCustAddrS, String bCustNmC, String bCustAddrC, String bCustNmN, String bCustAddrN, String bPckQtyDa, String bHblWgtDa, String bMeasQtyDa, String bPckQtyChk, String bHblWetChk, String bMeasQtyChk, String bPckQtyCm, String bCntrWgtCm, String bMeasQtyCm, String bCntrMfMkDesc, String bCntrMfGdsDesc, String bCntrMfNo, String bCntrNo, String bCntrSealNo, String bPckQtyCo, String bCntrWgtCo, String bMeasQtyCo, String bkgCgoTpCd, String custTaxIdC, String custTaxIdN, String custTaxIdS, String custStNmN, String custStNmC, String custStNmS, String custEoriNoS, String custEoriNoC, String custEoriNoN) {
		this.cntrSealSeq = cntrSealSeq;
		this.vslCd = vslCd;
		this.bCntrNo = bCntrNo;
		this.bCustAddrC = bCustAddrC;
		this.measQtyCm = measQtyCm;
		this.custCtyNmN = custCtyNmN;
		this.measQtyCo = measQtyCo;
		this.cntrMfWgt = cntrMfWgt;
		this.bPckQtyDa = bPckQtyDa;
		this.blNo = blNo;
		this.custCtyNmS = custCtyNmS;
		this.bCustNmC = bCustNmC;
		this.bUsaCstmsFileNo = bUsaCstmsFileNo;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.bCntrMfNo = bCntrMfNo;
		this.polCd = polCd;
		this.oblIssUsrId = oblIssUsrId;
		this.bCntrMfGdsDesc = bCntrMfGdsDesc;
		this.bCustNmN = bCustNmN;
		this.bPckQtyCo = bPckQtyCo;
		this.custCtyNmC = custCtyNmC;
		this.bPckQtyCm = bPckQtyCm;
		this.custNmS = custNmS;
		this.custCntCd = custCntCd;
		this.bCustNmS = bCustNmS;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.oblIssOfcCd = oblIssOfcCd;
		this.bkgOfcCd = bkgOfcCd;
		this.custNmN = custNmN;
		this.bCntrMfMkDesc = bCntrMfMkDesc;
		this.cntrWgt = cntrWgt;
		this.bMeasQtyChk = bMeasQtyChk;
		this.bHblWgtDa = bHblWgtDa;
		this.skdVoyNo = skdVoyNo;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.custNmC = custNmC;
		this.bCustAddrN = bCustAddrN;
		this.podCd = podCd;
		this.bHblNo = bHblNo;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.tabItem = tabItem;
		this.bCustAddrS = bCustAddrS;
		this.actWetChk = actWetChk;
		this.measQtyDa = measQtyDa;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.custAddrS = custAddrS;
		this.bBlNo = bBlNo;
		this.bCntrSealNo = bCntrSealNo;
		this.pckQtyChk = pckQtyChk;
		this.custAddrN = custAddrN;
		this.pckQtyDa = pckQtyDa;
		this.bMeasQtyDa = bMeasQtyDa;
		this.ibflag = ibflag;
		this.pckQtyCo = pckQtyCo;
		this.custZipIdS = custZipIdS;
		this.pckQtyCm = pckQtyCm;
		this.custZipIdN = custZipIdN;
		this.chkErr = chkErr;
		this.bPckQtyChk = bPckQtyChk;
		this.podYdCd = podYdCd;
		this.custZipIdC = custZipIdC;
		this.custSteCdC = custSteCdC;
		this.custSteCdN = custSteCdN;
		this.bCntrWgtCm = bCntrWgtCm;
		this.cstmsDeclCntCdC = cstmsDeclCntCdC;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.bCntrWgtCo = bCntrWgtCo;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.actWgt = actWgt;
		this.custAddrC = custAddrC;
		this.bHblWetChk = bHblWetChk;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.cstmsDeclCntCdS = cstmsDeclCntCdS;
		this.measQtyChk = measQtyChk;
		this.bMeasQtyCm = bMeasQtyCm;
		this.bMeasQtyCo = bMeasQtyCo;
		this.cstmsDeclCntCdN = cstmsDeclCntCdN;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.custTaxIdC = custTaxIdC;
		this.custTaxIdN = custTaxIdN;
		this.custStNmN = custStNmN;
		this.custTaxIdS = custTaxIdS;
		this.custStNmC = custStNmC;
		this.custStNmS = custStNmS;
		this.custEoriNoS = custEoriNoS;
		this.custEoriNoN = custEoriNoN;
		this.custEoriNoC = custEoriNoC;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_seal_seq", getCntrSealSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("b_cntr_no", getBCntrNo());
		this.hashColumns.put("b_cust_addr_c", getBCustAddrC());
		this.hashColumns.put("meas_qty_cm", getMeasQtyCm());
		this.hashColumns.put("cust_cty_nm_n", getCustCtyNmN());
		this.hashColumns.put("meas_qty_co", getMeasQtyCo());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("b_pck_qty_da", getBPckQtyDa());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cust_cty_nm_s", getCustCtyNmS());
		this.hashColumns.put("b_cust_nm_c", getBCustNmC());
		this.hashColumns.put("b_usa_cstms_file_no", getBUsaCstmsFileNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("b_cntr_mf_no", getBCntrMfNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("b_cntr_mf_gds_desc", getBCntrMfGdsDesc());
		this.hashColumns.put("b_cust_nm_n", getBCustNmN());
		this.hashColumns.put("b_pck_qty_co", getBPckQtyCo());
		this.hashColumns.put("cust_cty_nm_c", getCustCtyNmC());
		this.hashColumns.put("b_pck_qty_cm", getBPckQtyCm());
		this.hashColumns.put("cust_nm_s", getCustNmS());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("b_cust_nm_s", getBCustNmS());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cust_nm_n", getCustNmN());
		this.hashColumns.put("b_cntr_mf_mk_desc", getBCntrMfMkDesc());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("b_meas_qty_chk", getBMeasQtyChk());
		this.hashColumns.put("b_hbl_wgt_da", getBHblWgtDa());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("cust_nm_c", getCustNmC());
		this.hashColumns.put("b_cust_addr_n", getBCustAddrN());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("b_hbl_no", getBHblNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tab_item", getTabItem());
		this.hashColumns.put("b_cust_addr_s", getBCustAddrS());
		this.hashColumns.put("act_wet_chk", getActWetChk());
		this.hashColumns.put("meas_qty_da", getMeasQtyDa());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("cust_addr_s", getCustAddrS());
		this.hashColumns.put("b_bl_no", getBBlNo());
		this.hashColumns.put("b_cntr_seal_no", getBCntrSealNo());
		this.hashColumns.put("pck_qty_chk", getPckQtyChk());
		this.hashColumns.put("cust_addr_n", getCustAddrN());
		this.hashColumns.put("pck_qty_da", getPckQtyDa());
		this.hashColumns.put("b_meas_qty_da", getBMeasQtyDa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_qty_co", getPckQtyCo());
		this.hashColumns.put("cust_zip_id_s", getCustZipIdS());
		this.hashColumns.put("pck_qty_cm", getPckQtyCm());
		this.hashColumns.put("cust_zip_id_n", getCustZipIdN());
		this.hashColumns.put("chk_err", getChkErr());
		this.hashColumns.put("b_pck_qty_chk", getBPckQtyChk());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("cust_zip_id_c", getCustZipIdC());
		this.hashColumns.put("cust_ste_cd_c", getCustSteCdC());
		this.hashColumns.put("cust_ste_cd_n", getCustSteCdN());
		this.hashColumns.put("b_cntr_wgt_cm", getBCntrWgtCm());
		this.hashColumns.put("cstms_decl_cnt_cd_c", getCstmsDeclCntCdC());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("b_cntr_wgt_co", getBCntrWgtCo());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cust_addr_c", getCustAddrC());
		this.hashColumns.put("b_hbl_wet_chk", getBHblWetChk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cstms_decl_cnt_cd_s", getCstmsDeclCntCdS());
		this.hashColumns.put("meas_qty_chk", getMeasQtyChk());
		this.hashColumns.put("b_meas_qty_cm", getBMeasQtyCm());
		this.hashColumns.put("b_meas_qty_co", getBMeasQtyCo());
		this.hashColumns.put("cstms_decl_cnt_cd_n", getCstmsDeclCntCdN());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cust_tax_id_c", getCustTaxIdC());
		this.hashColumns.put("cust_tax_id_s", getCustTaxIdS());
		this.hashColumns.put("cust_tax_id_n", getCustTaxIdN());
		this.hashColumns.put("cust_st_nm_c", getCustStNmC());
		this.hashColumns.put("cust_st_nm_n", getCustStNmN());
		this.hashColumns.put("cust_st_nm_s", getCustStNmS());
		this.hashColumns.put("cust_eori_no_n", getCustEoriNoN());
		this.hashColumns.put("cust_eori_no_c", getCustEoriNoC());
		this.hashColumns.put("cust_eori_no_s", getCustEoriNoS());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_seal_seq", "cntrSealSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("b_cntr_no", "bCntrNo");
		this.hashFields.put("b_cust_addr_c", "bCustAddrC");
		this.hashFields.put("meas_qty_cm", "measQtyCm");
		this.hashFields.put("cust_cty_nm_n", "custCtyNmN");
		this.hashFields.put("meas_qty_co", "measQtyCo");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("b_pck_qty_da", "bPckQtyDa");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cust_cty_nm_s", "custCtyNmS");
		this.hashFields.put("b_cust_nm_c", "bCustNmC");
		this.hashFields.put("b_usa_cstms_file_no", "bUsaCstmsFileNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("b_cntr_mf_no", "bCntrMfNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("b_cntr_mf_gds_desc", "bCntrMfGdsDesc");
		this.hashFields.put("b_cust_nm_n", "bCustNmN");
		this.hashFields.put("b_pck_qty_co", "bPckQtyCo");
		this.hashFields.put("cust_cty_nm_c", "custCtyNmC");
		this.hashFields.put("b_pck_qty_cm", "bPckQtyCm");
		this.hashFields.put("cust_nm_s", "custNmS");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("b_cust_nm_s", "bCustNmS");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cust_nm_n", "custNmN");
		this.hashFields.put("b_cntr_mf_mk_desc", "bCntrMfMkDesc");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("b_meas_qty_chk", "bMeasQtyChk");
		this.hashFields.put("b_hbl_wgt_da", "bHblWgtDa");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("cust_nm_c", "custNmC");
		this.hashFields.put("b_cust_addr_n", "bCustAddrN");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("b_hbl_no", "bHblNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tab_item", "tabItem");
		this.hashFields.put("b_cust_addr_s", "bCustAddrS");
		this.hashFields.put("act_wet_chk", "actWetChk");
		this.hashFields.put("meas_qty_da", "measQtyDa");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("cust_addr_s", "custAddrS");
		this.hashFields.put("b_bl_no", "bBlNo");
		this.hashFields.put("b_cntr_seal_no", "bCntrSealNo");
		this.hashFields.put("pck_qty_chk", "pckQtyChk");
		this.hashFields.put("cust_addr_n", "custAddrN");
		this.hashFields.put("pck_qty_da", "pckQtyDa");
		this.hashFields.put("b_meas_qty_da", "bMeasQtyDa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_qty_co", "pckQtyCo");
		this.hashFields.put("cust_zip_id_s", "custZipIdS");
		this.hashFields.put("pck_qty_cm", "pckQtyCm");
		this.hashFields.put("cust_zip_id_n", "custZipIdN");
		this.hashFields.put("chk_err", "chkErr");
		this.hashFields.put("b_pck_qty_chk", "bPckQtyChk");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("cust_zip_id_c", "custZipIdC");
		this.hashFields.put("cust_ste_cd_c", "custSteCdC");
		this.hashFields.put("cust_ste_cd_n", "custSteCdN");
		this.hashFields.put("b_cntr_wgt_cm", "bCntrWgtCm");
		this.hashFields.put("cstms_decl_cnt_cd_c", "cstmsDeclCntCdC");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("b_cntr_wgt_co", "bCntrWgtCo");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cust_addr_c", "custAddrC");
		this.hashFields.put("b_hbl_wet_chk", "bHblWetChk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cstms_decl_cnt_cd_s", "cstmsDeclCntCdS");
		this.hashFields.put("meas_qty_chk", "measQtyChk");
		this.hashFields.put("b_meas_qty_cm", "bMeasQtyCm");
		this.hashFields.put("b_meas_qty_co", "bMeasQtyCo");
		this.hashFields.put("cstms_decl_cnt_cd_n", "cstmsDeclCntCdN");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cust_tax_id_c", "custTaxIdC");
		this.hashFields.put("cust_tax_id_s", "custTaxIdS");
		this.hashFields.put("cust_tax_id_n", "custTaxIdN");
		this.hashFields.put("cust_st_nm_c", "custStNmC");
		this.hashFields.put("cust_st_nm_n", "custStNmN");
		this.hashFields.put("cust_st_nm_s", "custStNmS");
		this.hashFields.put("cust_eori_no_n", "custEoriNoN");
		this.hashFields.put("cust_eori_no_c", "custEoriNoC");
		this.hashFields.put("cust_eori_no_s", "custEoriNoS");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrSealSeq
	 */
	public String getCntrSealSeq() {
		return this.cntrSealSeq;
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
	 * @return bCntrNo
	 */
	public String getBCntrNo() {
		return this.bCntrNo;
	}
	
	/**
	 * Column Info
	 * @return bCustAddrC
	 */
	public String getBCustAddrC() {
		return this.bCustAddrC;
	}
	
	/**
	 * Column Info
	 * @return measQtyCm
	 */
	public String getMeasQtyCm() {
		return this.measQtyCm;
	}
	
	/**
	 * Column Info
	 * @return custCtyNmN
	 */
	public String getCustCtyNmN() {
		return this.custCtyNmN;
	}
	
	/**
	 * Column Info
	 * @return measQtyCo
	 */
	public String getMeasQtyCo() {
		return this.measQtyCo;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyDa
	 */
	public String getBPckQtyDa() {
		return this.bPckQtyDa;
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
	 * @return custCtyNmS
	 */
	public String getCustCtyNmS() {
		return this.custCtyNmS;
	}
	
	/**
	 * Column Info
	 * @return bCustNmC
	 */
	public String getBCustNmC() {
		return this.bCustNmC;
	}
	
	/**
	 * Column Info
	 * @return bUsaCstmsFileNo
	 */
	public String getBUsaCstmsFileNo() {
		return this.bUsaCstmsFileNo;
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
	 * @return bCntrMfNo
	 */
	public String getBCntrMfNo() {
		return this.bCntrMfNo;
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
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return bCntrMfGdsDesc
	 */
	public String getBCntrMfGdsDesc() {
		return this.bCntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return bCustNmN
	 */
	public String getBCustNmN() {
		return this.bCustNmN;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyCo
	 */
	public String getBPckQtyCo() {
		return this.bPckQtyCo;
	}
	
	/**
	 * Column Info
	 * @return custCtyNmC
	 */
	public String getCustCtyNmC() {
		return this.custCtyNmC;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyCm
	 */
	public String getBPckQtyCm() {
		return this.bPckQtyCm;
	}
	
	/**
	 * Column Info
	 * @return custNmS
	 */
	public String getCustNmS() {
		return this.custNmS;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return bCustNmS
	 */
	public String getBCustNmS() {
		return this.bCustNmS;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custNmN
	 */
	public String getCustNmN() {
		return this.custNmN;
	}
	
	/**
	 * Column Info
	 * @return bCntrMfMkDesc
	 */
	public String getBCntrMfMkDesc() {
		return this.bCntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyChk
	 */
	public String getBMeasQtyChk() {
		return this.bMeasQtyChk;
	}
	
	/**
	 * Column Info
	 * @return bHblWgtDa
	 */
	public String getBHblWgtDa() {
		return this.bHblWgtDa;
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
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return custNmC
	 */
	public String getCustNmC() {
		return this.custNmC;
	}
	
	/**
	 * Column Info
	 * @return bCustAddrN
	 */
	public String getBCustAddrN() {
		return this.bCustAddrN;
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
	 * @return bHblNo
	 */
	public String getBHblNo() {
		return this.bHblNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return tabItem
	 */
	public String getTabItem() {
		return this.tabItem;
	}
	
	/**
	 * Column Info
	 * @return bCustAddrS
	 */
	public String getBCustAddrS() {
		return this.bCustAddrS;
	}
	
	/**
	 * Column Info
	 * @return actWetChk
	 */
	public String getActWetChk() {
		return this.actWetChk;
	}
	
	/**
	 * Column Info
	 * @return measQtyDa
	 */
	public String getMeasQtyDa() {
		return this.measQtyDa;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return custAddrS
	 */
	public String getCustAddrS() {
		return this.custAddrS;
	}
	
	/**
	 * Column Info
	 * @return bBlNo
	 */
	public String getBBlNo() {
		return this.bBlNo;
	}
	
	/**
	 * Column Info
	 * @return bCntrSealNo
	 */
	public String getBCntrSealNo() {
		return this.bCntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return pckQtyChk
	 */
	public String getPckQtyChk() {
		return this.pckQtyChk;
	}
	
	/**
	 * Column Info
	 * @return custAddrN
	 */
	public String getCustAddrN() {
		return this.custAddrN;
	}
	
	/**
	 * Column Info
	 * @return pckQtyDa
	 */
	public String getPckQtyDa() {
		return this.pckQtyDa;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyDa
	 */
	public String getBMeasQtyDa() {
		return this.bMeasQtyDa;
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
	 * @return pckQtyCo
	 */
	public String getPckQtyCo() {
		return this.pckQtyCo;
	}
	
	/**
	 * Column Info
	 * @return custZipIdS
	 */
	public String getCustZipIdS() {
		return this.custZipIdS;
	}
	
	/**
	 * Column Info
	 * @return pckQtyCm
	 */
	public String getPckQtyCm() {
		return this.pckQtyCm;
	}
	
	/**
	 * Column Info
	 * @return custZipIdN
	 */
	public String getCustZipIdN() {
		return this.custZipIdN;
	}
	
	/**
	 * Column Info
	 * @return chkErr
	 */
	public String getChkErr() {
		return this.chkErr;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyChk
	 */
	public String getBPckQtyChk() {
		return this.bPckQtyChk;
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
	 * @return custZipIdC
	 */
	public String getCustZipIdC() {
		return this.custZipIdC;
	}
	
	/**
	 * Column Info
	 * @return custSteCdC
	 */
	public String getCustSteCdC() {
		return this.custSteCdC;
	}
	
	/**
	 * Column Info
	 * @return custSteCdN
	 */
	public String getCustSteCdN() {
		return this.custSteCdN;
	}
	
	/**
	 * Column Info
	 * @return bCntrWgtCm
	 */
	public String getBCntrWgtCm() {
		return this.bCntrWgtCm;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCdC
	 */
	public String getCstmsDeclCntCdC() {
		return this.cstmsDeclCntCdC;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return bCntrWgtCo
	 */
	public String getBCntrWgtCo() {
		return this.bCntrWgtCo;
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
	 * @return custAddrC
	 */
	public String getCustAddrC() {
		return this.custAddrC;
	}
	
	/**
	 * Column Info
	 * @return bHblWetChk
	 */
	public String getBHblWetChk() {
		return this.bHblWetChk;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCdS
	 */
	public String getCstmsDeclCntCdS() {
		return this.cstmsDeclCntCdS;
	}
	
	/**
	 * Column Info
	 * @return measQtyChk
	 */
	public String getMeasQtyChk() {
		return this.measQtyChk;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyCm
	 */
	public String getBMeasQtyCm() {
		return this.bMeasQtyCm;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyCo
	 */
	public String getBMeasQtyCo() {
		return this.bMeasQtyCo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCdN
	 */
	public String getCstmsDeclCntCdN() {
		return this.cstmsDeclCntCdN;
	}

	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return custTaxIdC
	 */
	public String getCustTaxIdC() {
		return this.custTaxIdC;
	}
	
	/**
	 * Column Info
	 * @return custTaxIdS
	 */
	public String getCustTaxIdS() {
		return this.custTaxIdS;
	}

	/**
	 * Column Info
	 * @return custTaxIdN
	 */
	public String getCustTaxIdN() {
		return this.custTaxIdN;
	}
	
	/**
	 * Column Info
	 * @return custStNmC
	 */
	public String getCustStNmC() {
		return this.custStNmC;
	}
	
	/**
	 * Column Info
	 * @return custStNmN
	 */
	public String getCustStNmN() {
		return this.custStNmN;
	}
	
	/**
	 * Column Info
	 * @return custStNmS
	 */
	public String getCustStNmS() {
		return this.custStNmS;
	}
	
	/**
	 * Column Info
	 * @return custEoriNoN
	 */
	public String getCustEoriNoN() {
		return this.custEoriNoN;
	}
	
	/**
	 * Column Info
	 * @return custEoriNoS
	 */
	public String getCustEoriNoS() {
		return this.custEoriNoS;
	}
	
	/**
	 * Column Info
	 * @return custEoriNoC
	 */
	public String getCustEoriNoC() {
		return this.custEoriNoC;
	}

	/**
	 * Column Info
	 * @param cntrSealSeq
	 */
	public void setCntrSealSeq(String cntrSealSeq) {
		this.cntrSealSeq = cntrSealSeq;
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
	 * @param bCntrNo
	 */
	public void setBCntrNo(String bCntrNo) {
		this.bCntrNo = bCntrNo;
	}
	
	/**
	 * Column Info
	 * @param bCustAddrC
	 */
	public void setBCustAddrC(String bCustAddrC) {
		this.bCustAddrC = bCustAddrC;
	}
	
	/**
	 * Column Info
	 * @param measQtyCm
	 */
	public void setMeasQtyCm(String measQtyCm) {
		this.measQtyCm = measQtyCm;
	}
	
	/**
	 * Column Info
	 * @param custCtyNmN
	 */
	public void setCustCtyNmN(String custCtyNmN) {
		this.custCtyNmN = custCtyNmN;
	}
	
	/**
	 * Column Info
	 * @param measQtyCo
	 */
	public void setMeasQtyCo(String measQtyCo) {
		this.measQtyCo = measQtyCo;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyDa
	 */
	public void setBPckQtyDa(String bPckQtyDa) {
		this.bPckQtyDa = bPckQtyDa;
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
	 * @param custCtyNmS
	 */
	public void setCustCtyNmS(String custCtyNmS) {
		this.custCtyNmS = custCtyNmS;
	}
	
	/**
	 * Column Info
	 * @param bCustNmC
	 */
	public void setBCustNmC(String bCustNmC) {
		this.bCustNmC = bCustNmC;
	}
	
	/**
	 * Column Info
	 * @param bUsaCstmsFileNo
	 */
	public void setBUsaCstmsFileNo(String bUsaCstmsFileNo) {
		this.bUsaCstmsFileNo = bUsaCstmsFileNo;
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
	 * @param bCntrMfNo
	 */
	public void setBCntrMfNo(String bCntrMfNo) {
		this.bCntrMfNo = bCntrMfNo;
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
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param bCntrMfGdsDesc
	 */
	public void setBCntrMfGdsDesc(String bCntrMfGdsDesc) {
		this.bCntrMfGdsDesc = bCntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param bCustNmN
	 */
	public void setBCustNmN(String bCustNmN) {
		this.bCustNmN = bCustNmN;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyCo
	 */
	public void setBPckQtyCo(String bPckQtyCo) {
		this.bPckQtyCo = bPckQtyCo;
	}
	
	/**
	 * Column Info
	 * @param custCtyNmC
	 */
	public void setCustCtyNmC(String custCtyNmC) {
		this.custCtyNmC = custCtyNmC;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyCm
	 */
	public void setBPckQtyCm(String bPckQtyCm) {
		this.bPckQtyCm = bPckQtyCm;
	}
	
	/**
	 * Column Info
	 * @param custNmS
	 */
	public void setCustNmS(String custNmS) {
		this.custNmS = custNmS;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param bCustNmS
	 */
	public void setBCustNmS(String bCustNmS) {
		this.bCustNmS = bCustNmS;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custNmN
	 */
	public void setCustNmN(String custNmN) {
		this.custNmN = custNmN;
	}
	
	/**
	 * Column Info
	 * @param bCntrMfMkDesc
	 */
	public void setBCntrMfMkDesc(String bCntrMfMkDesc) {
		this.bCntrMfMkDesc = bCntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyChk
	 */
	public void setBMeasQtyChk(String bMeasQtyChk) {
		this.bMeasQtyChk = bMeasQtyChk;
	}
	
	/**
	 * Column Info
	 * @param bHblWgtDa
	 */
	public void setBHblWgtDa(String bHblWgtDa) {
		this.bHblWgtDa = bHblWgtDa;
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
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param custNmC
	 */
	public void setCustNmC(String custNmC) {
		this.custNmC = custNmC;
	}
	
	/**
	 * Column Info
	 * @param bCustAddrN
	 */
	public void setBCustAddrN(String bCustAddrN) {
		this.bCustAddrN = bCustAddrN;
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
	 * @param bHblNo
	 */
	public void setBHblNo(String bHblNo) {
		this.bHblNo = bHblNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param tabItem
	 */
	public void setTabItem(String tabItem) {
		this.tabItem = tabItem;
	}
	
	/**
	 * Column Info
	 * @param bCustAddrS
	 */
	public void setBCustAddrS(String bCustAddrS) {
		this.bCustAddrS = bCustAddrS;
	}
	
	/**
	 * Column Info
	 * @param actWetChk
	 */
	public void setActWetChk(String actWetChk) {
		this.actWetChk = actWetChk;
	}
	
	/**
	 * Column Info
	 * @param measQtyDa
	 */
	public void setMeasQtyDa(String measQtyDa) {
		this.measQtyDa = measQtyDa;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param custAddrS
	 */
	public void setCustAddrS(String custAddrS) {
		this.custAddrS = custAddrS;
	}
	
	/**
	 * Column Info
	 * @param bBlNo
	 */
	public void setBBlNo(String bBlNo) {
		this.bBlNo = bBlNo;
	}
	
	/**
	 * Column Info
	 * @param bCntrSealNo
	 */
	public void setBCntrSealNo(String bCntrSealNo) {
		this.bCntrSealNo = bCntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param pckQtyChk
	 */
	public void setPckQtyChk(String pckQtyChk) {
		this.pckQtyChk = pckQtyChk;
	}
	
	/**
	 * Column Info
	 * @param custAddrN
	 */
	public void setCustAddrN(String custAddrN) {
		this.custAddrN = custAddrN;
	}
	
	/**
	 * Column Info
	 * @param pckQtyDa
	 */
	public void setPckQtyDa(String pckQtyDa) {
		this.pckQtyDa = pckQtyDa;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyDa
	 */
	public void setBMeasQtyDa(String bMeasQtyDa) {
		this.bMeasQtyDa = bMeasQtyDa;
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
	 * @param pckQtyCo
	 */
	public void setPckQtyCo(String pckQtyCo) {
		this.pckQtyCo = pckQtyCo;
	}
	
	/**
	 * Column Info
	 * @param custZipIdS
	 */
	public void setCustZipIdS(String custZipIdS) {
		this.custZipIdS = custZipIdS;
	}
	
	/**
	 * Column Info
	 * @param pckQtyCm
	 */
	public void setPckQtyCm(String pckQtyCm) {
		this.pckQtyCm = pckQtyCm;
	}
	
	/**
	 * Column Info
	 * @param custZipIdN
	 */
	public void setCustZipIdN(String custZipIdN) {
		this.custZipIdN = custZipIdN;
	}
	
	/**
	 * Column Info
	 * @param chkErr
	 */
	public void setChkErr(String chkErr) {
		this.chkErr = chkErr;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyChk
	 */
	public void setBPckQtyChk(String bPckQtyChk) {
		this.bPckQtyChk = bPckQtyChk;
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
	 * @param custZipIdC
	 */
	public void setCustZipIdC(String custZipIdC) {
		this.custZipIdC = custZipIdC;
	}
	
	/**
	 * Column Info
	 * @param custSteCdC
	 */
	public void setCustSteCdC(String custSteCdC) {
		this.custSteCdC = custSteCdC;
	}
	
	/**
	 * Column Info
	 * @param custSteCdN
	 */
	public void setCustSteCdN(String custSteCdN) {
		this.custSteCdN = custSteCdN;
	}
	
	/**
	 * Column Info
	 * @param bCntrWgtCm
	 */
	public void setBCntrWgtCm(String bCntrWgtCm) {
		this.bCntrWgtCm = bCntrWgtCm;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCdC
	 */
	public void setCstmsDeclCntCdC(String cstmsDeclCntCdC) {
		this.cstmsDeclCntCdC = cstmsDeclCntCdC;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param bCntrWgtCo
	 */
	public void setBCntrWgtCo(String bCntrWgtCo) {
		this.bCntrWgtCo = bCntrWgtCo;
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
	 * @param custAddrC
	 */
	public void setCustAddrC(String custAddrC) {
		this.custAddrC = custAddrC;
	}
	
	/**
	 * Column Info
	 * @param bHblWetChk
	 */
	public void setBHblWetChk(String bHblWetChk) {
		this.bHblWetChk = bHblWetChk;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCdS
	 */
	public void setCstmsDeclCntCdS(String cstmsDeclCntCdS) {
		this.cstmsDeclCntCdS = cstmsDeclCntCdS;
	}
	
	/**
	 * Column Info
	 * @param measQtyChk
	 */
	public void setMeasQtyChk(String measQtyChk) {
		this.measQtyChk = measQtyChk;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyCm
	 */
	public void setBMeasQtyCm(String bMeasQtyCm) {
		this.bMeasQtyCm = bMeasQtyCm;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyCo
	 */
	public void setBMeasQtyCo(String bMeasQtyCo) {
		this.bMeasQtyCo = bMeasQtyCo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCdN
	 */
	public void setCstmsDeclCntCdN(String cstmsDeclCntCdN) {
		this.cstmsDeclCntCdN = cstmsDeclCntCdN;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param custTaxIdC
	 */
	public void setCustTaxIdC(String custTaxIdC) {
		this.custTaxIdC = custTaxIdC;
	}
	
	/**
	 * Column Info
	 * @param custTaxIdN
	 */
	public void setCustTaxIdN(String custTaxIdN) {
		this.custTaxIdN = custTaxIdN;
	}
	
	/**
	 * Column Info
	 * @param custTaxIdS
	 */
	public void setCustTaxIdS(String custTaxIdS) {
		this.custTaxIdS = custTaxIdS;
	}
	
	/**
	 * Column Info
	 * @param custEoriNoN
	 */
	public void setCustEoriNoN(String custEoriNoN) {
		this.custEoriNoN = custEoriNoN;
	}
	
	/**
	 * Column Info
	 * @param custEoriNoS
	 */
	public void setCustEoriNoS(String custEoriNoS) {
		this.custEoriNoS = custEoriNoS;
	}
	
	/**
	 * Column Info
	 * @param custEoriNoC
	 */
	public void setCustEoriNoC(String custEoriNoC) {
		this.custEoriNoC = custEoriNoC;
	}
	
	/**
	 * Column Info
	 * @param custStNmC
	 */
	public void setCustStNmC(String custStNmC) {
		this.custStNmC = custStNmC;
	}
	
	/**
	 * Column Info
	 * @param custStNmS
	 */
	public void setCustStNmS(String custStNmS) {
		this.custStNmS = custStNmS;
	}
	
	/**
	 * Column Info
	 * @param custStNmN
	 */
	public void setCustStNmN(String custStNmN) {
		this.custStNmN = custStNmN;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrSealSeq(JSPUtil.getParameter(request, "cntr_seal_seq", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBCntrNo(JSPUtil.getParameter(request, "b_cntr_no", ""));
		setBCustAddrC(JSPUtil.getParameter(request, "b_cust_addr_c", ""));
		setMeasQtyCm(JSPUtil.getParameter(request, "meas_qty_cm", ""));
		setCustCtyNmN(JSPUtil.getParameter(request, "cust_cty_nm_n", ""));
		setMeasQtyCo(JSPUtil.getParameter(request, "meas_qty_co", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, "cntr_mf_wgt", ""));
		setBPckQtyDa(JSPUtil.getParameter(request, "b_pck_qty_da", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCustCtyNmS(JSPUtil.getParameter(request, "cust_cty_nm_s", ""));
		setBCustNmC(JSPUtil.getParameter(request, "b_cust_nm_c", ""));
		setBUsaCstmsFileNo(JSPUtil.getParameter(request, "b_usa_cstms_file_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setBCntrMfNo(JSPUtil.getParameter(request, "b_cntr_mf_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setBCntrMfGdsDesc(JSPUtil.getParameter(request, "b_cntr_mf_gds_desc", ""));
		setBCustNmN(JSPUtil.getParameter(request, "b_cust_nm_n", ""));
		setBPckQtyCo(JSPUtil.getParameter(request, "b_pck_qty_co", ""));
		setCustCtyNmC(JSPUtil.getParameter(request, "cust_cty_nm_c", ""));
		setBPckQtyCm(JSPUtil.getParameter(request, "b_pck_qty_cm", ""));
		setCustNmS(JSPUtil.getParameter(request, "cust_nm_s", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setBCustNmS(JSPUtil.getParameter(request, "b_cust_nm_s", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, "cnd_cstms_file_cd", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, "obl_iss_ofc_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setCustNmN(JSPUtil.getParameter(request, "cust_nm_n", ""));
		setBCntrMfMkDesc(JSPUtil.getParameter(request, "b_cntr_mf_mk_desc", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setBMeasQtyChk(JSPUtil.getParameter(request, "b_meas_qty_chk", ""));
		setBHblWgtDa(JSPUtil.getParameter(request, "b_hbl_wgt_da", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, "cntr_mf_mk_desc", ""));
		setCustNmC(JSPUtil.getParameter(request, "cust_nm_c", ""));
		setBCustAddrN(JSPUtil.getParameter(request, "b_cust_addr_n", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBHblNo(JSPUtil.getParameter(request, "b_hbl_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTabItem(JSPUtil.getParameter(request, "tab_item", ""));
		setBCustAddrS(JSPUtil.getParameter(request, "b_cust_addr_s", ""));
		setActWetChk(JSPUtil.getParameter(request, "act_wet_chk", ""));
		setMeasQtyDa(JSPUtil.getParameter(request, "meas_qty_da", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, "cntr_mf_gds_desc", ""));
		setCustAddrS(JSPUtil.getParameter(request, "cust_addr_s", ""));
		setBBlNo(JSPUtil.getParameter(request, "b_bl_no", ""));
		setBCntrSealNo(JSPUtil.getParameter(request, "b_cntr_seal_no", ""));
		setPckQtyChk(JSPUtil.getParameter(request, "pck_qty_chk", ""));
		setCustAddrN(JSPUtil.getParameter(request, "cust_addr_n", ""));
		setPckQtyDa(JSPUtil.getParameter(request, "pck_qty_da", ""));
		setBMeasQtyDa(JSPUtil.getParameter(request, "b_meas_qty_da", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPckQtyCo(JSPUtil.getParameter(request, "pck_qty_co", ""));
		setCustZipIdS(JSPUtil.getParameter(request, "cust_zip_id_s", ""));
		setPckQtyCm(JSPUtil.getParameter(request, "pck_qty_cm", ""));
		setCustZipIdN(JSPUtil.getParameter(request, "cust_zip_id_n", ""));
		setChkErr(JSPUtil.getParameter(request, "chk_err", ""));
		setBPckQtyChk(JSPUtil.getParameter(request, "b_pck_qty_chk", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setCustZipIdC(JSPUtil.getParameter(request, "cust_zip_id_c", ""));
		setCustSteCdC(JSPUtil.getParameter(request, "cust_ste_cd_c", ""));
		setCustSteCdN(JSPUtil.getParameter(request, "cust_ste_cd_n", ""));
		setBCntrWgtCm(JSPUtil.getParameter(request, "b_cntr_wgt_cm", ""));
		setCstmsDeclCntCdC(JSPUtil.getParameter(request, "cstms_decl_cnt_cd_c", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBCntrWgtCo(JSPUtil.getParameter(request, "b_cntr_wgt_co", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, "usa_cstms_file_cd", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setCustAddrC(JSPUtil.getParameter(request, "cust_addr_c", ""));
		setBHblWetChk(JSPUtil.getParameter(request, "b_hbl_wet_chk", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setCstmsDeclCntCdS(JSPUtil.getParameter(request, "cstms_decl_cnt_cd_s", ""));
		setMeasQtyChk(JSPUtil.getParameter(request, "meas_qty_chk", ""));
		setBMeasQtyCm(JSPUtil.getParameter(request, "b_meas_qty_cm", ""));
		setBMeasQtyCo(JSPUtil.getParameter(request, "b_meas_qty_co", ""));
		setCstmsDeclCntCdN(JSPUtil.getParameter(request, "cstms_decl_cnt_cd_n", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request,  "bkg_cgo_tp_cd", ""));
		setCustTaxIdC(JSPUtil.getParameter(request,  "cust_tax_id_c", ""));
		setCustTaxIdS(JSPUtil.getParameter(request,  "cust_tax_id_s", ""));
		setCustTaxIdN(JSPUtil.getParameter(request,  "cust_tax_id_n", ""));
		setCustStNmC(JSPUtil.getParameter(request,  "cust_st_nm_c", ""));
		setCustStNmS(JSPUtil.getParameter(request,  "cust_st_nm_s", ""));
		setCustStNmN(JSPUtil.getParameter(request,  "cust_st_nm_N", ""));
		setCustEoriNoS(JSPUtil.getParameter(request, "cust_eori_no_s", ""));
		setCustEoriNoC(JSPUtil.getParameter(request, "cust_eori_no_c", ""));
		setCustEoriNoN(JSPUtil.getParameter(request, "cust_eori_no_n", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCMCroChkListinVO[]
	 */
	public BkgCroChkListinVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCMCroChkListinVO[]
	 */
	public BkgCroChkListinVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCroChkListinVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrSealSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_seq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bCntrNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_no", length));
			String[] bCustAddrC = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_c", length));
			String[] measQtyCm = (JSPUtil.getParameter(request, prefix	+ "meas_qty_cm", length));
			String[] custCtyNmN = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_n", length));
			String[] measQtyCo = (JSPUtil.getParameter(request, prefix	+ "meas_qty_co", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] bPckQtyDa = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_da", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] custCtyNmS = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_s", length));
			String[] bCustNmC = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_c", length));
			String[] bUsaCstmsFileNo = (JSPUtil.getParameter(request, prefix	+ "b_usa_cstms_file_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] bCntrMfNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] bCntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_gds_desc", length));
			String[] bCustNmN = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_n", length));
			String[] bPckQtyCo = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_co", length));
			String[] custCtyNmC = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_c", length));
			String[] bPckQtyCm = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_cm", length));
			String[] custNmS = (JSPUtil.getParameter(request, prefix	+ "cust_nm_s", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bCustNmS = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_s", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] custNmN = (JSPUtil.getParameter(request, prefix	+ "cust_nm_n", length));
			String[] bCntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_mk_desc", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] bMeasQtyChk = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_chk", length));
			String[] bHblWgtDa = (JSPUtil.getParameter(request, prefix	+ "b_hbl_wgt_da", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] custNmC = (JSPUtil.getParameter(request, prefix	+ "cust_nm_c", length));
			String[] bCustAddrN = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_n", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bHblNo = (JSPUtil.getParameter(request, prefix	+ "b_hbl_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tabItem = (JSPUtil.getParameter(request, prefix	+ "tab_item", length));
			String[] bCustAddrS = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_s", length));
			String[] actWetChk = (JSPUtil.getParameter(request, prefix	+ "act_wet_chk", length));
			String[] measQtyDa = (JSPUtil.getParameter(request, prefix	+ "meas_qty_da", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] custAddrS = (JSPUtil.getParameter(request, prefix	+ "cust_addr_s", length));
			String[] bBlNo = (JSPUtil.getParameter(request, prefix	+ "b_bl_no", length));
			String[] bCntrSealNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_seal_no", length));
			String[] pckQtyChk = (JSPUtil.getParameter(request, prefix	+ "pck_qty_chk", length));
			String[] custAddrN = (JSPUtil.getParameter(request, prefix	+ "cust_addr_n", length));
			String[] pckQtyDa = (JSPUtil.getParameter(request, prefix	+ "pck_qty_da", length));
			String[] bMeasQtyDa = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_da", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckQtyCo = (JSPUtil.getParameter(request, prefix	+ "pck_qty_co", length));
			String[] custZipIdS = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_s", length));
			String[] pckQtyCm = (JSPUtil.getParameter(request, prefix	+ "pck_qty_cm", length));
			String[] custZipIdN = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_n", length));
			String[] chkErr = (JSPUtil.getParameter(request, prefix	+ "chk_err", length));
			String[] bPckQtyChk = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_chk", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] custZipIdC = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_c", length));
			String[] custSteCdC = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd_c", length));
			String[] custSteCdN = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd_n", length));
			String[] bCntrWgtCm = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_cm", length));
			String[] cstmsDeclCntCdC = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_c", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bCntrWgtCo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_co", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] custAddrC = (JSPUtil.getParameter(request, prefix	+ "cust_addr_c", length));
			String[] bHblWetChk = (JSPUtil.getParameter(request, prefix	+ "b_hbl_wet_chk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] cstmsDeclCntCdS = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_s", length));
			String[] measQtyChk = (JSPUtil.getParameter(request, prefix	+ "meas_qty_chk", length));
			String[] bMeasQtyCm = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_cm", length));
			String[] bMeasQtyCo = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_co", length));
			String[] cstmsDeclCntCdN = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_n", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] custTaxIdC = (JSPUtil.getParameter(request, prefix	+ "cust_tax_id_c", length));
			String[] custTaxIdS = (JSPUtil.getParameter(request, prefix	+ "cust_tax_id_s", length));
			String[] custTaxIdN = (JSPUtil.getParameter(request, prefix	+ "cust_tax_id_n", length));
			String[] custStNmC = (JSPUtil.getParameter(request, prefix	+ "cust_st_nm_c", length));
			String[] custStNmS = (JSPUtil.getParameter(request, prefix	+ "cust_st_nm_s", length));
			String[] custStNmN = (JSPUtil.getParameter(request, prefix	+ "cust_st_nm_n", length));
			String[] custEoriNoN = (JSPUtil.getParameter(request, prefix	+ "cust_eori_no_n", length));
			String[] custEoriNoC = (JSPUtil.getParameter(request, prefix	+ "cust_eori_no_c", length));
			String[] custEoriNoS = (JSPUtil.getParameter(request, prefix	+ "cust_eori_no_s", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new BkgCroChkListinVO();
				if (cntrSealSeq[i] != null)
					model.setCntrSealSeq(cntrSealSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bCntrNo[i] != null)
					model.setBCntrNo(bCntrNo[i]);
				if (bCustAddrC[i] != null)
					model.setBCustAddrC(bCustAddrC[i]);
				if (measQtyCm[i] != null)
					model.setMeasQtyCm(measQtyCm[i]);
				if (custCtyNmN[i] != null)
					model.setCustCtyNmN(custCtyNmN[i]);
				if (measQtyCo[i] != null)
					model.setMeasQtyCo(measQtyCo[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (bPckQtyDa[i] != null)
					model.setBPckQtyDa(bPckQtyDa[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (custCtyNmS[i] != null)
					model.setCustCtyNmS(custCtyNmS[i]);
				if (bCustNmC[i] != null)
					model.setBCustNmC(bCustNmC[i]);
				if (bUsaCstmsFileNo[i] != null)
					model.setBUsaCstmsFileNo(bUsaCstmsFileNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (bCntrMfNo[i] != null)
					model.setBCntrMfNo(bCntrMfNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (bCntrMfGdsDesc[i] != null)
					model.setBCntrMfGdsDesc(bCntrMfGdsDesc[i]);
				if (bCustNmN[i] != null)
					model.setBCustNmN(bCustNmN[i]);
				if (bPckQtyCo[i] != null)
					model.setBPckQtyCo(bPckQtyCo[i]);
				if (custCtyNmC[i] != null)
					model.setCustCtyNmC(custCtyNmC[i]);
				if (bPckQtyCm[i] != null)
					model.setBPckQtyCm(bPckQtyCm[i]);
				if (custNmS[i] != null)
					model.setCustNmS(custNmS[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bCustNmS[i] != null)
					model.setBCustNmS(bCustNmS[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (custNmN[i] != null)
					model.setCustNmN(custNmN[i]);
				if (bCntrMfMkDesc[i] != null)
					model.setBCntrMfMkDesc(bCntrMfMkDesc[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (bMeasQtyChk[i] != null)
					model.setBMeasQtyChk(bMeasQtyChk[i]);
				if (bHblWgtDa[i] != null)
					model.setBHblWgtDa(bHblWgtDa[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (custNmC[i] != null)
					model.setCustNmC(custNmC[i]);
				if (bCustAddrN[i] != null)
					model.setBCustAddrN(bCustAddrN[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bHblNo[i] != null)
					model.setBHblNo(bHblNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tabItem[i] != null)
					model.setTabItem(tabItem[i]);
				if (bCustAddrS[i] != null)
					model.setBCustAddrS(bCustAddrS[i]);
				if (actWetChk[i] != null)
					model.setActWetChk(actWetChk[i]);
				if (measQtyDa[i] != null)
					model.setMeasQtyDa(measQtyDa[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (custAddrS[i] != null)
					model.setCustAddrS(custAddrS[i]);
				if (bBlNo[i] != null)
					model.setBBlNo(bBlNo[i]);
				if (bCntrSealNo[i] != null)
					model.setBCntrSealNo(bCntrSealNo[i]);
				if (pckQtyChk[i] != null)
					model.setPckQtyChk(pckQtyChk[i]);
				if (custAddrN[i] != null)
					model.setCustAddrN(custAddrN[i]);
				if (pckQtyDa[i] != null)
					model.setPckQtyDa(pckQtyDa[i]);
				if (bMeasQtyDa[i] != null)
					model.setBMeasQtyDa(bMeasQtyDa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckQtyCo[i] != null)
					model.setPckQtyCo(pckQtyCo[i]);
				if (custZipIdS[i] != null)
					model.setCustZipIdS(custZipIdS[i]);
				if (pckQtyCm[i] != null)
					model.setPckQtyCm(pckQtyCm[i]);
				if (custZipIdN[i] != null)
					model.setCustZipIdN(custZipIdN[i]);
				if (chkErr[i] != null)
					model.setChkErr(chkErr[i]);
				if (bPckQtyChk[i] != null)
					model.setBPckQtyChk(bPckQtyChk[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (custZipIdC[i] != null)
					model.setCustZipIdC(custZipIdC[i]);
				if (custSteCdC[i] != null)
					model.setCustSteCdC(custSteCdC[i]);
				if (custSteCdN[i] != null)
					model.setCustSteCdN(custSteCdN[i]);
				if (bCntrWgtCm[i] != null)
					model.setBCntrWgtCm(bCntrWgtCm[i]);
				if (cstmsDeclCntCdC[i] != null)
					model.setCstmsDeclCntCdC(cstmsDeclCntCdC[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bCntrWgtCo[i] != null)
					model.setBCntrWgtCo(bCntrWgtCo[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (custAddrC[i] != null)
					model.setCustAddrC(custAddrC[i]);
				if (bHblWetChk[i] != null)
					model.setBHblWetChk(bHblWetChk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (cstmsDeclCntCdS[i] != null)
					model.setCstmsDeclCntCdS(cstmsDeclCntCdS[i]);
				if (measQtyChk[i] != null)
					model.setMeasQtyChk(measQtyChk[i]);
				if (bMeasQtyCm[i] != null)
					model.setBMeasQtyCm(bMeasQtyCm[i]);
				if (bMeasQtyCo[i] != null)
					model.setBMeasQtyCo(bMeasQtyCo[i]);
				if (cstmsDeclCntCdN[i] != null)
					model.setCstmsDeclCntCdN(cstmsDeclCntCdN[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (custTaxIdC[i] != null)
					model.setCustTaxIdC(custTaxIdC[i]);
				if (custTaxIdS[i] != null)
					model.setCustTaxIdS(custTaxIdS[i]);
				if (custTaxIdN[i] != null)
					model.setCustTaxIdN(custTaxIdN[i]);
				if (custStNmC[i] != null)
					model.setCustStNmC(custStNmC[i]);
				if (custStNmN[i] != null)
					model.setCustStNmN(custStNmN[i]);
				if (custStNmS[i] != null)
					model.setCustStNmS(custStNmS[i]);
				if (custEoriNoN[i] != null)
					model.setCustEoriNoN(custEoriNoN[i]);
				if (custEoriNoS[i] != null)
					model.setCustEoriNoS(custEoriNoS[i]);
				if (custEoriNoC[i] != null)
					model.setCustEoriNoC(custEoriNoC[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCMCroChkListinVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCMCroChkListinVO[]
	 */
	public BkgCroChkListinVO[] getBkgCMCroChkListinVOs(){
		BkgCroChkListinVO[] vos = (BkgCroChkListinVO[])models.toArray(new BkgCroChkListinVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cntrSealSeq = this.cntrSealSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrNo = this.bCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrC = this.bCustAddrC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCm = this.measQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmN = this.custCtyNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCo = this.measQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyDa = this.bPckQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmS = this.custCtyNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmC = this.bCustNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bUsaCstmsFileNo = this.bUsaCstmsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfNo = this.bCntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfGdsDesc = this.bCntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmN = this.bCustNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyCo = this.bPckQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmC = this.custCtyNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyCm = this.bPckQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmS = this.custNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmS = this.bCustNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmN = this.custNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfMkDesc = this.bCntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyChk = this.bMeasQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblWgtDa = this.bHblWgtDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmC = this.custNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrN = this.bCustAddrN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblNo = this.bHblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabItem = this.tabItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrS = this.bCustAddrS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWetChk = this.actWetChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyDa = this.measQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrS = this.custAddrS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBlNo = this.bBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrSealNo = this.bCntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyChk = this.pckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrN = this.custAddrN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyDa = this.pckQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyDa = this.bMeasQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyCo = this.pckQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdS = this.custZipIdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyCm = this.pckQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdN = this.custZipIdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkErr = this.chkErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyChk = this.bPckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdC = this.custZipIdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCdC = this.custSteCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCdN = this.custSteCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtCm = this.bCntrWgtCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdC = this.cstmsDeclCntCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtCo = this.bCntrWgtCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrC = this.custAddrC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblWetChk = this.bHblWetChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdS = this.cstmsDeclCntCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyChk = this.measQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyCm = this.bMeasQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyCo = this.bMeasQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdN = this.cstmsDeclCntCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTaxIdC = this.custTaxIdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTaxIdN = this.custTaxIdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTaxIdS = this.custTaxIdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStNmC = this.custStNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStNmN = this.custStNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStNmS = this.custStNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEoriNoN = this.custEoriNoN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEoriNoC = this.custEoriNoC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEoriNoS = this.custEoriNoS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
