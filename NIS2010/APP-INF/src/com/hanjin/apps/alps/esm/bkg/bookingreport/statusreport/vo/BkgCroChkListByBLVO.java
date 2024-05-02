/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCMCroChkListByBLVO.java
*@FileTitle : BkgCMCroChkListByBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.05.04 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCroChkListByBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCroChkListByBLVO> models = new ArrayList<BkgCroChkListByBLVO>();
	
	/* Column Info */
	private String cntrSealSeq = null;
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
	private String bCustCtS = null;
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
	private String bCntrMfNo = null;
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
	private String bCustNmS = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String oblIssOfcCd = null;
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
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String custNmC = null;
	/* Column Info */
	private String bCustStC = null;
	/* Column Info */
	private String bCustAddrN = null;
	/* Column Info */
	private String bHblNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tabItem = null;
	/* Column Info */
	private String bCustAddrS = null;
	/* Column Info */
	private String actWetChk = null;
	/* Column Info */
	private String bCustCtC = null;
	/* Column Info */
	private String measQtyDa = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String bCntrMfHts = null;
	/* Column Info */
	private String custAddrS = null;
	/* Column Info */
	private String bBlNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String pckQtyChk = null;
	/* Column Info */
	private String custAddrN = null;
	/* Column Info */
	private String pckQtyDa = null;
	/* Column Info */
	private String bCustCnC = null;
	/* Column Info */
	private String bMeasQtyDa = null;
	/* Column Info */
	private String cntrMfNcm = null;
	/* Column Info */
	private String bCntrMfHs = null;
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
	private String bCustCnS = null;
	/* Column Info */
	private String bPckQtyChk = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String bCntrSealSeq = null;
	/* Column Info */
	private String bHblWgtChk = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String custZipIdC = null;
	/* Column Info */
	private String custSteCdC = null;
	/* Column Info */
	private String bCntrMfNcm = null;
	/* Column Info */
	private String custSteCdN = null;
	/* Column Info */
	private String bCntrWgtCm = null;
	/* Column Info */
	private String cstmsDeclCntCdC = null;
	/* Column Info */
	private String cntrMfHts = null;
	/* Column Info */
	private String bCntrWgtCo = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String cntrMfHs = null;
	/* Column Info */
	private String custAddrC = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cstmsDeclCntCdS = null;
	/* Column Info */
	private String measQtyChk = null;
	/* Column Info */
	private String seq = null;
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
	/* Column Info */
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCroChkListByBLVO() {}

	public BkgCroChkListByBLVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String usaCstmsFileCd, String cndCstmsFileCd, String oblIssOfcCd, String oblIssUsrId, String custNmS, String custAddrS, String custCtyNmS, String cstmsDeclCntCdS, String custZipIdS, String custNmC, String custAddrC, String custCtyNmC, String cstmsDeclCntCdC, String custSteCdC, String custZipIdC, String custNmN, String custAddrN, String custCtyNmN, String cstmsDeclCntCdN, String custSteCdN, String custZipIdN, String custNm, String sCustNm, String nCustNm, String pckQtyDa, String actWgt, String measQtyDa, String pckQtyChk, String actWetChk, String measQtyChk, String pckQtyCm, String cntrMfWgt, String measQtyCm, String cntrMfMkDesc, String cntrMfGdsDesc, String cntrNo, String pckQtyCo, String cntrWgt, String measQtyCo, String cntrSealSeq, String seq, String bBlNo, String bUsaCstmsFileNo, String bHblNo, String bCustNmS, String bCustAddrS, String bCustNmC, String bCustAddrC, String bCustNmN, String bCustAddrN, String bPckQtyDa, String bHblWgtDa, String bMeasQtyDa, String bPckQtyChk, String bHblWgtChk, String bMeasQtyChk, String bPckQtyCm, String bCntrWgtCm, String bMeasQtyCm, String bCntrMfMkDesc, String bCntrMfGdsDesc, String bCntrMfNo, String bCntrNo, String bCntrSealSeq, String bPckQtyCo, String bCntrWgtCo, String bMeasQtyCo, String tabItem, String cntrMfHts, String cntrMfHs, String cntrMfNcm, String bCntrMfHts, String bCntrMfHs, String bCntrMfNcm, String bCustCtS, String bCustCnS, String bCustCtC, String bCustStC, String bCustCnC, String bkgCgoTpCd, String custTaxIdC, String custTaxIdN, String custTaxIdS, String custStNmN, String custStNmC, String custStNmS, String custEoriNoS, String custEoriNoC, String custEoriNoN) {
		this.cntrSealSeq = cntrSealSeq;
		this.bCntrNo = bCntrNo;
		this.bCustAddrC = bCustAddrC;
		this.measQtyCm = measQtyCm;
		this.custCtyNmN = custCtyNmN;
		this.measQtyCo = measQtyCo;
		this.cntrMfWgt = cntrMfWgt;
		this.bCustCtS = bCustCtS;
		this.bPckQtyDa = bPckQtyDa;
		this.blNo = blNo;
		this.custCtyNmS = custCtyNmS;
		this.bCustNmC = bCustNmC;
		this.bUsaCstmsFileNo = bUsaCstmsFileNo;
		this.pagerows = pagerows;
		this.bCntrMfNo = bCntrMfNo;
		this.oblIssUsrId = oblIssUsrId;
		this.bCntrMfGdsDesc = bCntrMfGdsDesc;
		this.bCustNmN = bCustNmN;
		this.bPckQtyCo = bPckQtyCo;
		this.custCtyNmC = custCtyNmC;
		this.bPckQtyCm = bPckQtyCm;
		this.custNmS = custNmS;
		this.bCustNmS = bCustNmS;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.oblIssOfcCd = oblIssOfcCd;
		this.custNmN = custNmN;
		this.bCntrMfMkDesc = bCntrMfMkDesc;
		this.cntrWgt = cntrWgt;
		this.bMeasQtyChk = bMeasQtyChk;
		this.bHblWgtDa = bHblWgtDa;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.custNmC = custNmC;
		this.bCustStC = bCustStC;
		this.bCustAddrN = bCustAddrN;
		this.bHblNo = bHblNo;
		this.bkgNo = bkgNo;
		this.tabItem = tabItem;
		this.bCustAddrS = bCustAddrS;
		this.actWetChk = actWetChk;
		this.bCustCtC = bCustCtC;
		this.measQtyDa = measQtyDa;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.bCntrMfHts = bCntrMfHts;
		this.custAddrS = custAddrS;
		this.bBlNo = bBlNo;
		this.custNm = custNm;
		this.pckQtyChk = pckQtyChk;
		this.custAddrN = custAddrN;
		this.pckQtyDa = pckQtyDa;
		this.bCustCnC = bCustCnC;
		this.bMeasQtyDa = bMeasQtyDa;
		this.cntrMfNcm = cntrMfNcm;
		this.bCntrMfHs = bCntrMfHs;
		this.ibflag = ibflag;
		this.pckQtyCo = pckQtyCo;
		this.custZipIdS = custZipIdS;
		this.pckQtyCm = pckQtyCm;
		this.custZipIdN = custZipIdN;
		this.bCustCnS = bCustCnS;
		this.bPckQtyChk = bPckQtyChk;
		this.nCustNm = nCustNm;
		this.bCntrSealSeq = bCntrSealSeq;
		this.bHblWgtChk = bHblWgtChk;
		this.sCustNm = sCustNm;
		this.custZipIdC = custZipIdC;
		this.custSteCdC = custSteCdC;
		this.bCntrMfNcm = bCntrMfNcm;
		this.custSteCdN = custSteCdN;
		this.bCntrWgtCm = bCntrWgtCm;
		this.cstmsDeclCntCdC = cstmsDeclCntCdC;
		this.cntrMfHts = cntrMfHts;
		this.bCntrWgtCo = bCntrWgtCo;
		this.blTpCd = blTpCd;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.actWgt = actWgt;
		this.cntrMfHs = cntrMfHs;
		this.custAddrC = custAddrC;
		this.cntrNo = cntrNo;
		this.cstmsDeclCntCdS = cstmsDeclCntCdS;
		this.measQtyChk = measQtyChk;
		this.seq = seq;
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
		this.hashColumns.put("b_cntr_no", getBCntrNo());
		this.hashColumns.put("b_cust_addr_c", getBCustAddrC());
		this.hashColumns.put("meas_qty_cm", getMeasQtyCm());
		this.hashColumns.put("cust_cty_nm_n", getCustCtyNmN());
		this.hashColumns.put("meas_qty_co", getMeasQtyCo());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("b_cust_ct_s", getBCustCtS());
		this.hashColumns.put("b_pck_qty_da", getBPckQtyDa());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cust_cty_nm_s", getCustCtyNmS());
		this.hashColumns.put("b_cust_nm_c", getBCustNmC());
		this.hashColumns.put("b_usa_cstms_file_no", getBUsaCstmsFileNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("b_cntr_mf_no", getBCntrMfNo());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("b_cntr_mf_gds_desc", getBCntrMfGdsDesc());
		this.hashColumns.put("b_cust_nm_n", getBCustNmN());
		this.hashColumns.put("b_pck_qty_co", getBPckQtyCo());
		this.hashColumns.put("cust_cty_nm_c", getCustCtyNmC());
		this.hashColumns.put("b_pck_qty_cm", getBPckQtyCm());
		this.hashColumns.put("cust_nm_s", getCustNmS());
		this.hashColumns.put("b_cust_nm_s", getBCustNmS());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("cust_nm_n", getCustNmN());
		this.hashColumns.put("b_cntr_mf_mk_desc", getBCntrMfMkDesc());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("b_meas_qty_chk", getBMeasQtyChk());
		this.hashColumns.put("b_hbl_wgt_da", getBHblWgtDa());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("cust_nm_c", getCustNmC());
		this.hashColumns.put("b_cust_st_c", getBCustStC());
		this.hashColumns.put("b_cust_addr_n", getBCustAddrN());
		this.hashColumns.put("b_hbl_no", getBHblNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tab_item", getTabItem());
		this.hashColumns.put("b_cust_addr_s", getBCustAddrS());
		this.hashColumns.put("act_wet_chk", getActWetChk());
		this.hashColumns.put("b_cust_ct_c", getBCustCtC());
		this.hashColumns.put("meas_qty_da", getMeasQtyDa());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("b_cntr_mf_hts", getBCntrMfHts());
		this.hashColumns.put("cust_addr_s", getCustAddrS());
		this.hashColumns.put("b_bl_no", getBBlNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("pck_qty_chk", getPckQtyChk());
		this.hashColumns.put("cust_addr_n", getCustAddrN());
		this.hashColumns.put("pck_qty_da", getPckQtyDa());
		this.hashColumns.put("b_cust_cn_c", getBCustCnC());
		this.hashColumns.put("b_meas_qty_da", getBMeasQtyDa());
		this.hashColumns.put("cntr_mf_ncm", getCntrMfNcm());
		this.hashColumns.put("b_cntr_mf_hs", getBCntrMfHs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_qty_co", getPckQtyCo());
		this.hashColumns.put("cust_zip_id_s", getCustZipIdS());
		this.hashColumns.put("pck_qty_cm", getPckQtyCm());
		this.hashColumns.put("cust_zip_id_n", getCustZipIdN());
		this.hashColumns.put("b_cust_cn_s", getBCustCnS());
		this.hashColumns.put("b_pck_qty_chk", getBPckQtyChk());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("b_cntr_seal_seq", getBCntrSealSeq());
		this.hashColumns.put("b_hbl_wgt_chk", getBHblWgtChk());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("cust_zip_id_c", getCustZipIdC());
		this.hashColumns.put("cust_ste_cd_c", getCustSteCdC());
		this.hashColumns.put("b_cntr_mf_ncm", getBCntrMfNcm());
		this.hashColumns.put("cust_ste_cd_n", getCustSteCdN());
		this.hashColumns.put("b_cntr_wgt_cm", getBCntrWgtCm());
		this.hashColumns.put("cstms_decl_cnt_cd_c", getCstmsDeclCntCdC());
		this.hashColumns.put("cntr_mf_hts", getCntrMfHts());
		this.hashColumns.put("b_cntr_wgt_co", getBCntrWgtCo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cntr_mf_hs", getCntrMfHs());
		this.hashColumns.put("cust_addr_c", getCustAddrC());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cstms_decl_cnt_cd_s", getCstmsDeclCntCdS());
		this.hashColumns.put("meas_qty_chk", getMeasQtyChk());
		this.hashColumns.put("seq", getSeq());
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
		this.hashFields.put("b_cntr_no", "bCntrNo");
		this.hashFields.put("b_cust_addr_c", "bCustAddrC");
		this.hashFields.put("meas_qty_cm", "measQtyCm");
		this.hashFields.put("cust_cty_nm_n", "custCtyNmN");
		this.hashFields.put("meas_qty_co", "measQtyCo");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("b_cust_ct_s", "bCustCtS");
		this.hashFields.put("b_pck_qty_da", "bPckQtyDa");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cust_cty_nm_s", "custCtyNmS");
		this.hashFields.put("b_cust_nm_c", "bCustNmC");
		this.hashFields.put("b_usa_cstms_file_no", "bUsaCstmsFileNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("b_cntr_mf_no", "bCntrMfNo");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("b_cntr_mf_gds_desc", "bCntrMfGdsDesc");
		this.hashFields.put("b_cust_nm_n", "bCustNmN");
		this.hashFields.put("b_pck_qty_co", "bPckQtyCo");
		this.hashFields.put("cust_cty_nm_c", "custCtyNmC");
		this.hashFields.put("b_pck_qty_cm", "bPckQtyCm");
		this.hashFields.put("cust_nm_s", "custNmS");
		this.hashFields.put("b_cust_nm_s", "bCustNmS");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("cust_nm_n", "custNmN");
		this.hashFields.put("b_cntr_mf_mk_desc", "bCntrMfMkDesc");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("b_meas_qty_chk", "bMeasQtyChk");
		this.hashFields.put("b_hbl_wgt_da", "bHblWgtDa");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("cust_nm_c", "custNmC");
		this.hashFields.put("b_cust_st_c", "bCustStC");
		this.hashFields.put("b_cust_addr_n", "bCustAddrN");
		this.hashFields.put("b_hbl_no", "bHblNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tab_item", "tabItem");
		this.hashFields.put("b_cust_addr_s", "bCustAddrS");
		this.hashFields.put("act_wet_chk", "actWetChk");
		this.hashFields.put("b_cust_ct_c", "bCustCtC");
		this.hashFields.put("meas_qty_da", "measQtyDa");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("b_cntr_mf_hts", "bCntrMfHts");
		this.hashFields.put("cust_addr_s", "custAddrS");
		this.hashFields.put("b_bl_no", "bBlNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("pck_qty_chk", "pckQtyChk");
		this.hashFields.put("cust_addr_n", "custAddrN");
		this.hashFields.put("pck_qty_da", "pckQtyDa");
		this.hashFields.put("b_cust_cn_c", "bCustCnC");
		this.hashFields.put("b_meas_qty_da", "bMeasQtyDa");
		this.hashFields.put("cntr_mf_ncm", "cntrMfNcm");
		this.hashFields.put("b_cntr_mf_hs", "bCntrMfHs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_qty_co", "pckQtyCo");
		this.hashFields.put("cust_zip_id_s", "custZipIdS");
		this.hashFields.put("pck_qty_cm", "pckQtyCm");
		this.hashFields.put("cust_zip_id_n", "custZipIdN");
		this.hashFields.put("b_cust_cn_s", "bCustCnS");
		this.hashFields.put("b_pck_qty_chk", "bPckQtyChk");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("b_cntr_seal_seq", "bCntrSealSeq");
		this.hashFields.put("b_hbl_wgt_chk", "bHblWgtChk");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("cust_zip_id_c", "custZipIdC");
		this.hashFields.put("cust_ste_cd_c", "custSteCdC");
		this.hashFields.put("b_cntr_mf_ncm", "bCntrMfNcm");
		this.hashFields.put("cust_ste_cd_n", "custSteCdN");
		this.hashFields.put("b_cntr_wgt_cm", "bCntrWgtCm");
		this.hashFields.put("cstms_decl_cnt_cd_c", "cstmsDeclCntCdC");
		this.hashFields.put("cntr_mf_hts", "cntrMfHts");
		this.hashFields.put("b_cntr_wgt_co", "bCntrWgtCo");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cntr_mf_hs", "cntrMfHs");
		this.hashFields.put("cust_addr_c", "custAddrC");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cstms_decl_cnt_cd_s", "cstmsDeclCntCdS");
		this.hashFields.put("meas_qty_chk", "measQtyChk");
		this.hashFields.put("seq", "seq");
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
	 * @return bCustCtS
	 */
	public String getBCustCtS() {
		return this.bCustCtS;
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
	 * @return bCntrMfNo
	 */
	public String getBCntrMfNo() {
		return this.bCntrMfNo;
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
	 * @return bCustStC
	 */
	public String getBCustStC() {
		return this.bCustStC;
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
	 * @return bHblNo
	 */
	public String getBHblNo() {
		return this.bHblNo;
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
	 * @return bCustCtC
	 */
	public String getBCustCtC() {
		return this.bCustCtC;
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
	 * @return bCntrMfHts
	 */
	public String getBCntrMfHts() {
		return this.bCntrMfHts;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return bCustCnC
	 */
	public String getBCustCnC() {
		return this.bCustCnC;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyDa
	 */
	public String getBMeasQtyDa() {
		return this.bMeasQtyDa;
	}
	
	/**
	 * Column Info
	 * @return cntrMfNcm
	 */
	public String getCntrMfNcm() {
		return this.cntrMfNcm;
	}
	
	/**
	 * Column Info
	 * @return bCntrMfHs
	 */
	public String getBCntrMfHs() {
		return this.bCntrMfHs;
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
	 * @return bCustCnS
	 */
	public String getBCustCnS() {
		return this.bCustCnS;
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
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return bCntrSealSeq
	 */
	public String getBCntrSealSeq() {
		return this.bCntrSealSeq;
	}
	
	/**
	 * Column Info
	 * @return bHblWgtChk
	 */
	public String getBHblWgtChk() {
		return this.bHblWgtChk;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
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
	 * @return bCntrMfNcm
	 */
	public String getBCntrMfNcm() {
		return this.bCntrMfNcm;
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
	 * @return cntrMfHts
	 */
	public String getCntrMfHts() {
		return this.cntrMfHts;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return cntrMfHs
	 */
	public String getCntrMfHs() {
		return this.cntrMfHs;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @param bCustCtS
	 */
	public void setBCustCtS(String bCustCtS) {
		this.bCustCtS = bCustCtS;
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
	 * @param bCntrMfNo
	 */
	public void setBCntrMfNo(String bCntrMfNo) {
		this.bCntrMfNo = bCntrMfNo;
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
	 * @param bCustStC
	 */
	public void setBCustStC(String bCustStC) {
		this.bCustStC = bCustStC;
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
	 * @param bHblNo
	 */
	public void setBHblNo(String bHblNo) {
		this.bHblNo = bHblNo;
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
	 * @param bCustCtC
	 */
	public void setBCustCtC(String bCustCtC) {
		this.bCustCtC = bCustCtC;
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
	 * @param bCntrMfHts
	 */
	public void setBCntrMfHts(String bCntrMfHts) {
		this.bCntrMfHts = bCntrMfHts;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param bCustCnC
	 */
	public void setBCustCnC(String bCustCnC) {
		this.bCustCnC = bCustCnC;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyDa
	 */
	public void setBMeasQtyDa(String bMeasQtyDa) {
		this.bMeasQtyDa = bMeasQtyDa;
	}
	
	/**
	 * Column Info
	 * @param cntrMfNcm
	 */
	public void setCntrMfNcm(String cntrMfNcm) {
		this.cntrMfNcm = cntrMfNcm;
	}
	
	/**
	 * Column Info
	 * @param bCntrMfHs
	 */
	public void setBCntrMfHs(String bCntrMfHs) {
		this.bCntrMfHs = bCntrMfHs;
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
	 * @param bCustCnS
	 */
	public void setBCustCnS(String bCustCnS) {
		this.bCustCnS = bCustCnS;
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
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param bCntrSealSeq
	 */
	public void setBCntrSealSeq(String bCntrSealSeq) {
		this.bCntrSealSeq = bCntrSealSeq;
	}
	
	/**
	 * Column Info
	 * @param bHblWgtChk
	 */
	public void setBHblWgtChk(String bHblWgtChk) {
		this.bHblWgtChk = bHblWgtChk;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
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
	 * @param bCntrMfNcm
	 */
	public void setBCntrMfNcm(String bCntrMfNcm) {
		this.bCntrMfNcm = bCntrMfNcm;
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
	 * @param cntrMfHts
	 */
	public void setCntrMfHts(String cntrMfHts) {
		this.cntrMfHts = cntrMfHts;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param cntrMfHs
	 */
	public void setCntrMfHs(String cntrMfHs) {
		this.cntrMfHs = cntrMfHs;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCntrSealSeq(JSPUtil.getParameter(request, prefix + "cntr_seal_seq", ""));
		setBCntrNo(JSPUtil.getParameter(request, prefix + "b_cntr_no", ""));
		setBCustAddrC(JSPUtil.getParameter(request, prefix + "b_cust_addr_c", ""));
		setMeasQtyCm(JSPUtil.getParameter(request, prefix + "meas_qty_cm", ""));
		setCustCtyNmN(JSPUtil.getParameter(request, prefix + "cust_cty_nm_n", ""));
		setMeasQtyCo(JSPUtil.getParameter(request, prefix + "meas_qty_co", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setBCustCtS(JSPUtil.getParameter(request, prefix + "b_cust_ct_s", ""));
		setBPckQtyDa(JSPUtil.getParameter(request, prefix + "b_pck_qty_da", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCustCtyNmS(JSPUtil.getParameter(request, prefix + "cust_cty_nm_s", ""));
		setBCustNmC(JSPUtil.getParameter(request, prefix + "b_cust_nm_c", ""));
		setBUsaCstmsFileNo(JSPUtil.getParameter(request, prefix + "b_usa_cstms_file_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBCntrMfNo(JSPUtil.getParameter(request, prefix + "b_cntr_mf_no", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, prefix + "obl_iss_usr_id", ""));
		setBCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "b_cntr_mf_gds_desc", ""));
		setBCustNmN(JSPUtil.getParameter(request, prefix + "b_cust_nm_n", ""));
		setBPckQtyCo(JSPUtil.getParameter(request, prefix + "b_pck_qty_co", ""));
		setCustCtyNmC(JSPUtil.getParameter(request, prefix + "cust_cty_nm_c", ""));
		setBPckQtyCm(JSPUtil.getParameter(request, prefix + "b_pck_qty_cm", ""));
		setCustNmS(JSPUtil.getParameter(request, prefix + "cust_nm_s", ""));
		setBCustNmS(JSPUtil.getParameter(request, prefix + "b_cust_nm_s", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setCustNmN(JSPUtil.getParameter(request, prefix + "cust_nm_n", ""));
		setBCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "b_cntr_mf_mk_desc", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setBMeasQtyChk(JSPUtil.getParameter(request, prefix + "b_meas_qty_chk", ""));
		setBHblWgtDa(JSPUtil.getParameter(request, prefix + "b_hbl_wgt_da", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setCustNmC(JSPUtil.getParameter(request, prefix + "cust_nm_c", ""));
		setBCustStC(JSPUtil.getParameter(request, prefix + "b_cust_st_c", ""));
		setBCustAddrN(JSPUtil.getParameter(request, prefix + "b_cust_addr_n", ""));
		setBHblNo(JSPUtil.getParameter(request, prefix + "b_hbl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTabItem(JSPUtil.getParameter(request, prefix + "tab_item", ""));
		setBCustAddrS(JSPUtil.getParameter(request, prefix + "b_cust_addr_s", ""));
		setActWetChk(JSPUtil.getParameter(request, prefix + "act_wet_chk", ""));
		setBCustCtC(JSPUtil.getParameter(request, prefix + "b_cust_ct_c", ""));
		setMeasQtyDa(JSPUtil.getParameter(request, prefix + "meas_qty_da", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setBCntrMfHts(JSPUtil.getParameter(request, prefix + "b_cntr_mf_hts", ""));
		setCustAddrS(JSPUtil.getParameter(request, prefix + "cust_addr_s", ""));
		setBBlNo(JSPUtil.getParameter(request, prefix + "b_bl_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPckQtyChk(JSPUtil.getParameter(request, prefix + "pck_qty_chk", ""));
		setCustAddrN(JSPUtil.getParameter(request, prefix + "cust_addr_n", ""));
		setPckQtyDa(JSPUtil.getParameter(request, prefix + "pck_qty_da", ""));
		setBCustCnC(JSPUtil.getParameter(request, prefix + "b_cust_cn_c", ""));
		setBMeasQtyDa(JSPUtil.getParameter(request, prefix + "b_meas_qty_da", ""));
		setCntrMfNcm(JSPUtil.getParameter(request, prefix + "cntr_mf_ncm", ""));
		setBCntrMfHs(JSPUtil.getParameter(request, prefix + "b_cntr_mf_hs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPckQtyCo(JSPUtil.getParameter(request, prefix + "pck_qty_co", ""));
		setCustZipIdS(JSPUtil.getParameter(request, prefix + "cust_zip_id_s", ""));
		setPckQtyCm(JSPUtil.getParameter(request, prefix + "pck_qty_cm", ""));
		setCustZipIdN(JSPUtil.getParameter(request, prefix + "cust_zip_id_n", ""));
		setBCustCnS(JSPUtil.getParameter(request, prefix + "b_cust_cn_s", ""));
		setBPckQtyChk(JSPUtil.getParameter(request, prefix + "b_pck_qty_chk", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setBCntrSealSeq(JSPUtil.getParameter(request, prefix + "b_cntr_seal_seq", ""));
		setBHblWgtChk(JSPUtil.getParameter(request, prefix + "b_hbl_wgt_chk", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setCustZipIdC(JSPUtil.getParameter(request, prefix + "cust_zip_id_c", ""));
		setCustSteCdC(JSPUtil.getParameter(request, prefix + "cust_ste_cd_c", ""));
		setBCntrMfNcm(JSPUtil.getParameter(request, prefix + "b_cntr_mf_ncm", ""));
		setCustSteCdN(JSPUtil.getParameter(request, prefix + "cust_ste_cd_n", ""));
		setBCntrWgtCm(JSPUtil.getParameter(request, prefix + "b_cntr_wgt_cm", ""));
		setCstmsDeclCntCdC(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd_c", ""));
		setCntrMfHts(JSPUtil.getParameter(request, prefix + "cntr_mf_hts", ""));
		setBCntrWgtCo(JSPUtil.getParameter(request, prefix + "b_cntr_wgt_co", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setCntrMfHs(JSPUtil.getParameter(request, prefix + "cntr_mf_hs", ""));
		setCustAddrC(JSPUtil.getParameter(request, prefix + "cust_addr_c", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCstmsDeclCntCdS(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd_s", ""));
		setMeasQtyChk(JSPUtil.getParameter(request, prefix + "meas_qty_chk", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setBMeasQtyCm(JSPUtil.getParameter(request, prefix + "b_meas_qty_cm", ""));
		setBMeasQtyCo(JSPUtil.getParameter(request, prefix + "b_meas_qty_co", ""));
		setCstmsDeclCntCdN(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd_n", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCustTaxIdC(JSPUtil.getParameter(request, prefix + "cust_tax_id_c", ""));
		setCustTaxIdS(JSPUtil.getParameter(request, prefix + "cust_tax_id_s", ""));
		setCustTaxIdN(JSPUtil.getParameter(request, prefix + "cust_tax_id_n", ""));
		setCustStNmC(JSPUtil.getParameter(request, prefix + "cust_st_nm_c", ""));
		setCustStNmS(JSPUtil.getParameter(request, prefix + "cust_st_nm_s", ""));
		setCustStNmN(JSPUtil.getParameter(request, prefix + "cust_st_nm_N", ""));
		setCustEoriNoS(JSPUtil.getParameter(request, prefix + "cust_eori_no_s", ""));
		setCustEoriNoC(JSPUtil.getParameter(request, prefix + "cust_eori_no_c", ""));
		setCustEoriNoN(JSPUtil.getParameter(request, prefix + "cust_eori_no_n", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCMCroChkListByBLVO[]
	 */
	public BkgCroChkListByBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCMCroChkListByBLVO[]
	 */
	public BkgCroChkListByBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCroChkListByBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrSealSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_seq", length));
			String[] bCntrNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_no", length));
			String[] bCustAddrC = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_c", length));
			String[] measQtyCm = (JSPUtil.getParameter(request, prefix	+ "meas_qty_cm", length));
			String[] custCtyNmN = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_n", length));
			String[] measQtyCo = (JSPUtil.getParameter(request, prefix	+ "meas_qty_co", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] bCustCtS = (JSPUtil.getParameter(request, prefix	+ "b_cust_ct_s", length));
			String[] bPckQtyDa = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_da", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] custCtyNmS = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_s", length));
			String[] bCustNmC = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_c", length));
			String[] bUsaCstmsFileNo = (JSPUtil.getParameter(request, prefix	+ "b_usa_cstms_file_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bCntrMfNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_no", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] bCntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_gds_desc", length));
			String[] bCustNmN = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_n", length));
			String[] bPckQtyCo = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_co", length));
			String[] custCtyNmC = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_c", length));
			String[] bPckQtyCm = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_cm", length));
			String[] custNmS = (JSPUtil.getParameter(request, prefix	+ "cust_nm_s", length));
			String[] bCustNmS = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_s", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] custNmN = (JSPUtil.getParameter(request, prefix	+ "cust_nm_n", length));
			String[] bCntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_mk_desc", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] bMeasQtyChk = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_chk", length));
			String[] bHblWgtDa = (JSPUtil.getParameter(request, prefix	+ "b_hbl_wgt_da", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] custNmC = (JSPUtil.getParameter(request, prefix	+ "cust_nm_c", length));
			String[] bCustStC = (JSPUtil.getParameter(request, prefix	+ "b_cust_st_c", length));
			String[] bCustAddrN = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_n", length));
			String[] bHblNo = (JSPUtil.getParameter(request, prefix	+ "b_hbl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tabItem = (JSPUtil.getParameter(request, prefix	+ "tab_item", length));
			String[] bCustAddrS = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_s", length));
			String[] actWetChk = (JSPUtil.getParameter(request, prefix	+ "act_wet_chk", length));
			String[] bCustCtC = (JSPUtil.getParameter(request, prefix	+ "b_cust_ct_c", length));
			String[] measQtyDa = (JSPUtil.getParameter(request, prefix	+ "meas_qty_da", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] bCntrMfHts = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_hts", length));
			String[] custAddrS = (JSPUtil.getParameter(request, prefix	+ "cust_addr_s", length));
			String[] bBlNo = (JSPUtil.getParameter(request, prefix	+ "b_bl_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] pckQtyChk = (JSPUtil.getParameter(request, prefix	+ "pck_qty_chk", length));
			String[] custAddrN = (JSPUtil.getParameter(request, prefix	+ "cust_addr_n", length));
			String[] pckQtyDa = (JSPUtil.getParameter(request, prefix	+ "pck_qty_da", length));
			String[] bCustCnC = (JSPUtil.getParameter(request, prefix	+ "b_cust_cn_c", length));
			String[] bMeasQtyDa = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_da", length));
			String[] cntrMfNcm = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_ncm", length));
			String[] bCntrMfHs = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_hs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckQtyCo = (JSPUtil.getParameter(request, prefix	+ "pck_qty_co", length));
			String[] custZipIdS = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_s", length));
			String[] pckQtyCm = (JSPUtil.getParameter(request, prefix	+ "pck_qty_cm", length));
			String[] custZipIdN = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_n", length));
			String[] bCustCnS = (JSPUtil.getParameter(request, prefix	+ "b_cust_cn_s", length));
			String[] bPckQtyChk = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_chk", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] bCntrSealSeq = (JSPUtil.getParameter(request, prefix	+ "b_cntr_seal_seq", length));
			String[] bHblWgtChk = (JSPUtil.getParameter(request, prefix	+ "b_hbl_wgt_chk", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] custZipIdC = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_c", length));
			String[] custSteCdC = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd_c", length));
			String[] bCntrMfNcm = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_ncm", length));
			String[] custSteCdN = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd_n", length));
			String[] bCntrWgtCm = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_cm", length));
			String[] cstmsDeclCntCdC = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_c", length));
			String[] cntrMfHts = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_hts", length));
			String[] bCntrWgtCo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_co", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] cntrMfHs = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_hs", length));
			String[] custAddrC = (JSPUtil.getParameter(request, prefix	+ "cust_addr_c", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cstmsDeclCntCdS = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_s", length));
			String[] measQtyChk = (JSPUtil.getParameter(request, prefix	+ "meas_qty_chk", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
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
				model = new BkgCroChkListByBLVO();
				if (cntrSealSeq[i] != null)
					model.setCntrSealSeq(cntrSealSeq[i]);
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
				if (bCustCtS[i] != null)
					model.setBCustCtS(bCustCtS[i]);
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
				if (bCntrMfNo[i] != null)
					model.setBCntrMfNo(bCntrMfNo[i]);
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
				if (bCustNmS[i] != null)
					model.setBCustNmS(bCustNmS[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
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
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (custNmC[i] != null)
					model.setCustNmC(custNmC[i]);
				if (bCustStC[i] != null)
					model.setBCustStC(bCustStC[i]);
				if (bCustAddrN[i] != null)
					model.setBCustAddrN(bCustAddrN[i]);
				if (bHblNo[i] != null)
					model.setBHblNo(bHblNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tabItem[i] != null)
					model.setTabItem(tabItem[i]);
				if (bCustAddrS[i] != null)
					model.setBCustAddrS(bCustAddrS[i]);
				if (actWetChk[i] != null)
					model.setActWetChk(actWetChk[i]);
				if (bCustCtC[i] != null)
					model.setBCustCtC(bCustCtC[i]);
				if (measQtyDa[i] != null)
					model.setMeasQtyDa(measQtyDa[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (bCntrMfHts[i] != null)
					model.setBCntrMfHts(bCntrMfHts[i]);
				if (custAddrS[i] != null)
					model.setCustAddrS(custAddrS[i]);
				if (bBlNo[i] != null)
					model.setBBlNo(bBlNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (pckQtyChk[i] != null)
					model.setPckQtyChk(pckQtyChk[i]);
				if (custAddrN[i] != null)
					model.setCustAddrN(custAddrN[i]);
				if (pckQtyDa[i] != null)
					model.setPckQtyDa(pckQtyDa[i]);
				if (bCustCnC[i] != null)
					model.setBCustCnC(bCustCnC[i]);
				if (bMeasQtyDa[i] != null)
					model.setBMeasQtyDa(bMeasQtyDa[i]);
				if (cntrMfNcm[i] != null)
					model.setCntrMfNcm(cntrMfNcm[i]);
				if (bCntrMfHs[i] != null)
					model.setBCntrMfHs(bCntrMfHs[i]);
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
				if (bCustCnS[i] != null)
					model.setBCustCnS(bCustCnS[i]);
				if (bPckQtyChk[i] != null)
					model.setBPckQtyChk(bPckQtyChk[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (bCntrSealSeq[i] != null)
					model.setBCntrSealSeq(bCntrSealSeq[i]);
				if (bHblWgtChk[i] != null)
					model.setBHblWgtChk(bHblWgtChk[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (custZipIdC[i] != null)
					model.setCustZipIdC(custZipIdC[i]);
				if (custSteCdC[i] != null)
					model.setCustSteCdC(custSteCdC[i]);
				if (bCntrMfNcm[i] != null)
					model.setBCntrMfNcm(bCntrMfNcm[i]);
				if (custSteCdN[i] != null)
					model.setCustSteCdN(custSteCdN[i]);
				if (bCntrWgtCm[i] != null)
					model.setBCntrWgtCm(bCntrWgtCm[i]);
				if (cstmsDeclCntCdC[i] != null)
					model.setCstmsDeclCntCdC(cstmsDeclCntCdC[i]);
				if (cntrMfHts[i] != null)
					model.setCntrMfHts(cntrMfHts[i]);
				if (bCntrWgtCo[i] != null)
					model.setBCntrWgtCo(bCntrWgtCo[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (cntrMfHs[i] != null)
					model.setCntrMfHs(cntrMfHs[i]);
				if (custAddrC[i] != null)
					model.setCustAddrC(custAddrC[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cstmsDeclCntCdS[i] != null)
					model.setCstmsDeclCntCdS(cstmsDeclCntCdS[i]);
				if (measQtyChk[i] != null)
					model.setMeasQtyChk(measQtyChk[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
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
		return getBkgCMCroChkListByBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCMCroChkListByBLVO[]
	 */
	public BkgCroChkListByBLVO[] getBkgCMCroChkListByBLVOs(){
		BkgCroChkListByBLVO[] vos = (BkgCroChkListByBLVO[])models.toArray(new BkgCroChkListByBLVO[models.size()]);
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
		this.cntrSealSeq = this.cntrSealSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrNo = this.bCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrC = this.bCustAddrC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCm = this.measQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmN = this.custCtyNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCo = this.measQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustCtS = this.bCustCtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyDa = this.bPckQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmS = this.custCtyNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmC = this.bCustNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bUsaCstmsFileNo = this.bUsaCstmsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfNo = this.bCntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfGdsDesc = this.bCntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmN = this.bCustNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyCo = this.bPckQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmC = this.custCtyNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyCm = this.bPckQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmS = this.custNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmS = this.bCustNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmN = this.custNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfMkDesc = this.bCntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyChk = this.bMeasQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblWgtDa = this.bHblWgtDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmC = this.custNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustStC = this.bCustStC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrN = this.bCustAddrN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblNo = this.bHblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabItem = this.tabItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrS = this.bCustAddrS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWetChk = this.actWetChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustCtC = this.bCustCtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyDa = this.measQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfHts = this.bCntrMfHts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrS = this.custAddrS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBlNo = this.bBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyChk = this.pckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrN = this.custAddrN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyDa = this.pckQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustCnC = this.bCustCnC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyDa = this.bMeasQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNcm = this.cntrMfNcm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfHs = this.bCntrMfHs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyCo = this.pckQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdS = this.custZipIdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyCm = this.pckQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdN = this.custZipIdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustCnS = this.bCustCnS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyChk = this.bPckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrSealSeq = this.bCntrSealSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblWgtChk = this.bHblWgtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdC = this.custZipIdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCdC = this.custSteCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfNcm = this.bCntrMfNcm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCdN = this.custSteCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtCm = this.bCntrWgtCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdC = this.cstmsDeclCntCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfHts = this.cntrMfHts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtCo = this.bCntrWgtCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfHs = this.cntrMfHs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrC = this.custAddrC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdS = this.cstmsDeclCntCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyChk = this.measQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
