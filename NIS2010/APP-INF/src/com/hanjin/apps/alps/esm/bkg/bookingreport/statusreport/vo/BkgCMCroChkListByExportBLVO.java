/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCMCroChkListByExportBLVO.java
*@FileTitle : BkgCMCroChkListByExportBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br> 
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCMCroChkListByExportBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCMCroChkListByExportBLVO> models = new ArrayList<BkgCMCroChkListByExportBLVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrSealSeq = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String measQtyCm = null;
	/* Column Info */
	private String vehCmdtFlg = null;
	/* Column Info */
	private String custCtyNmN = null;
	/* Column Info */
	private String measQtyCo = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String custCtyNmS = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String siFlg = null;
	/* Column Info */
	private String custCtyNmC = null;
	/* Column Info */
	private String xterSiCd = null;
	/* Column Info */
	private String custNmS = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String custNmN = null;
	/* Column Info */
	private String entrClssTpCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String sCustAddrNm = null;
	/* Column Info */
	private String custNmC = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actWetChk = null;
	/* Column Info */
	private String measQtyDa = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String custAddrS = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String pckQtyChk = null;
	/* Column Info */
	private String custAddrN = null;
	/* Column Info */
	private String pckQtyDa = null;
	/* Column Info */
	private String cntrMfNcm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String md = null;
	/* Column Info */
	private String pckQtyCo = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String custZipIdS = null;
	/* Column Info */
	private String pckQtyCm = null;
	/* Column Info */
	private String custZipIdN = null;
	/* Column Info */
	private String chkErr = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String entrClssRmk = null;
	/* Column Info */
	private String entrClssTpGubun = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String custZipIdC = null;
	/* Column Info */
	private String custSteCdC = null;
	/* Column Info */
	private String custSteCdN = null;
	/* Column Info */
	private String cstmsDeclCntCdC = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrMfHts = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String custAddrC = null;
	/* Column Info */
	private String cntrMfHs = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cstmsDeclCntCdS = null;
	/* Column Info */
	private String measQtyChk = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String pckCmdtDesc = null;
	/* Column Info */
	private String aesInlndTrnsNo = null;
	/* Column Info */
	private String cstmsDeclCntCdN = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCMCroChkListByExportBLVO() {}

	public BkgCMCroChkListByExportBLVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String bkgCgoTpCd, String usaCstmsFileCd, String cndCstmsFileCd, String custNmS, String custAddrS, String custCtyNmS, String cstmsDeclCntCdS, String custZipIdS, String custNmC, String custAddrC, String custCtyNmC, String cstmsDeclCntCdC, String custSteCdC, String custZipIdC, String custNmN, String custAddrN, String custCtyNmN, String cstmsDeclCntCdN, String custSteCdN, String custZipIdN, String custNm, String sCustNm, String nCustNm, String pckQtyDa, String actWgt, String measQtyDa, String pckQtyChk, String actWetChk, String measQtyChk, String pckQtyCm, String cntrMfWgt, String measQtyCm, String cntrMfMkDesc, String cntrMfGdsDesc, String cntrNo, String pckQtyCo, String cntrWgt, String measQtyCo, String cntrSealSeq, String seq, String cntrMfHts, String cntrMfHs, String cntrMfNcm, String sCustAddrNm, String aesInlndTrnsNo, String entrClssTpCd, String entrClssRmk, String bkgQty, String cntrQty, String pckCmdtDesc, String md, String pckTpCd, String dcgoFlg, String vehCmdtFlg, String siFlg, String xterSiCd, String vslCd, String polCd, String podCd, String polYdCd, String podYdCd, String chkErr, String entrClssTpGubun, String skdVoyNo, String skdDirCd) {
		this.vslCd = vslCd;
		this.cntrSealSeq = cntrSealSeq;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.measQtyCm = measQtyCm;
		this.vehCmdtFlg = vehCmdtFlg;
		this.custCtyNmN = custCtyNmN;
		this.measQtyCo = measQtyCo;
		this.cntrMfWgt = cntrMfWgt;
		this.blNo = blNo;
		this.custCtyNmS = custCtyNmS;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.siFlg = siFlg;
		this.custCtyNmC = custCtyNmC;
		this.xterSiCd = xterSiCd;
		this.custNmS = custNmS;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.custNmN = custNmN;
		this.entrClssTpCd = entrClssTpCd;
		this.cntrWgt = cntrWgt;
		this.skdVoyNo = skdVoyNo;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.sCustAddrNm = sCustAddrNm;
		this.custNmC = custNmC;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.actWetChk = actWetChk;
		this.measQtyDa = measQtyDa;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.custAddrS = custAddrS;
		this.custNm = custNm;
		this.pckQtyChk = pckQtyChk;
		this.custAddrN = custAddrN;
		this.pckQtyDa = pckQtyDa;
		this.cntrMfNcm = cntrMfNcm;
		this.ibflag = ibflag;
		this.md = md;
		this.pckQtyCo = pckQtyCo;
		this.bkgQty = bkgQty;
		this.dcgoFlg = dcgoFlg;
		this.custZipIdS = custZipIdS;
		this.pckQtyCm = pckQtyCm;
		this.custZipIdN = custZipIdN;
		this.chkErr = chkErr;
		this.cntrQty = cntrQty;
		this.nCustNm = nCustNm;
		this.podYdCd = podYdCd;
		this.pckTpCd = pckTpCd;
		this.entrClssRmk = entrClssRmk;
		this.entrClssTpGubun = entrClssTpGubun;
		this.sCustNm = sCustNm;
		this.custZipIdC = custZipIdC;
		this.custSteCdC = custSteCdC;
		this.custSteCdN = custSteCdN;
		this.cstmsDeclCntCdC = cstmsDeclCntCdC;
		this.skdDirCd = skdDirCd;
		this.cntrMfHts = cntrMfHts;
		this.blTpCd = blTpCd;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.actWgt = actWgt;
		this.custAddrC = custAddrC;
		this.cntrMfHs = cntrMfHs;
		this.polYdCd = polYdCd;
		this.cntrNo = cntrNo;
		this.cstmsDeclCntCdS = cstmsDeclCntCdS;
		this.measQtyChk = measQtyChk;
		this.seq = seq;
		this.pckCmdtDesc = pckCmdtDesc;
		this.aesInlndTrnsNo = aesInlndTrnsNo;
		this.cstmsDeclCntCdN = cstmsDeclCntCdN;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_seal_seq", getCntrSealSeq());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("meas_qty_cm", getMeasQtyCm());
		this.hashColumns.put("veh_cmdt_flg", getVehCmdtFlg());
		this.hashColumns.put("cust_cty_nm_n", getCustCtyNmN());
		this.hashColumns.put("meas_qty_co", getMeasQtyCo());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cust_cty_nm_s", getCustCtyNmS());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("si_flg", getSiFlg());
		this.hashColumns.put("cust_cty_nm_c", getCustCtyNmC());
		this.hashColumns.put("xter_si_cd", getXterSiCd());
		this.hashColumns.put("cust_nm_s", getCustNmS());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("cust_nm_n", getCustNmN());
		this.hashColumns.put("entr_clss_tp_cd", getEntrClssTpCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("s_cust_addr_nm", getSCustAddrNm());
		this.hashColumns.put("cust_nm_c", getCustNmC());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_wet_chk", getActWetChk());
		this.hashColumns.put("meas_qty_da", getMeasQtyDa());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("cust_addr_s", getCustAddrS());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("pck_qty_chk", getPckQtyChk());
		this.hashColumns.put("cust_addr_n", getCustAddrN());
		this.hashColumns.put("pck_qty_da", getPckQtyDa());
		this.hashColumns.put("cntr_mf_ncm", getCntrMfNcm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("md", getMd());
		this.hashColumns.put("pck_qty_co", getPckQtyCo());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cust_zip_id_s", getCustZipIdS());
		this.hashColumns.put("pck_qty_cm", getPckQtyCm());
		this.hashColumns.put("cust_zip_id_n", getCustZipIdN());
		this.hashColumns.put("chk_err", getChkErr());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("entr_clss_rmk", getEntrClssRmk());
		this.hashColumns.put("entr_clss_tp_gubun", getEntrClssTpGubun());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("cust_zip_id_c", getCustZipIdC());
		this.hashColumns.put("cust_ste_cd_c", getCustSteCdC());
		this.hashColumns.put("cust_ste_cd_n", getCustSteCdN());
		this.hashColumns.put("cstms_decl_cnt_cd_c", getCstmsDeclCntCdC());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_mf_hts", getCntrMfHts());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cust_addr_c", getCustAddrC());
		this.hashColumns.put("cntr_mf_hs", getCntrMfHs());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cstms_decl_cnt_cd_s", getCstmsDeclCntCdS());
		this.hashColumns.put("meas_qty_chk", getMeasQtyChk());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pck_cmdt_desc", getPckCmdtDesc());
		this.hashColumns.put("aes_inlnd_trns_no", getAesInlndTrnsNo());
		this.hashColumns.put("cstms_decl_cnt_cd_n", getCstmsDeclCntCdN());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_seal_seq", "cntrSealSeq");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("meas_qty_cm", "measQtyCm");
		this.hashFields.put("veh_cmdt_flg", "vehCmdtFlg");
		this.hashFields.put("cust_cty_nm_n", "custCtyNmN");
		this.hashFields.put("meas_qty_co", "measQtyCo");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cust_cty_nm_s", "custCtyNmS");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("si_flg", "siFlg");
		this.hashFields.put("cust_cty_nm_c", "custCtyNmC");
		this.hashFields.put("xter_si_cd", "xterSiCd");
		this.hashFields.put("cust_nm_s", "custNmS");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("cust_nm_n", "custNmN");
		this.hashFields.put("entr_clss_tp_cd", "entrClssTpCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("s_cust_addr_nm", "sCustAddrNm");
		this.hashFields.put("cust_nm_c", "custNmC");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_wet_chk", "actWetChk");
		this.hashFields.put("meas_qty_da", "measQtyDa");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("cust_addr_s", "custAddrS");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("pck_qty_chk", "pckQtyChk");
		this.hashFields.put("cust_addr_n", "custAddrN");
		this.hashFields.put("pck_qty_da", "pckQtyDa");
		this.hashFields.put("cntr_mf_ncm", "cntrMfNcm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("md", "md");
		this.hashFields.put("pck_qty_co", "pckQtyCo");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cust_zip_id_s", "custZipIdS");
		this.hashFields.put("pck_qty_cm", "pckQtyCm");
		this.hashFields.put("cust_zip_id_n", "custZipIdN");
		this.hashFields.put("chk_err", "chkErr");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("entr_clss_rmk", "entrClssRmk");
		this.hashFields.put("entr_clss_tp_gubun", "entrClssTpGubun");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("cust_zip_id_c", "custZipIdC");
		this.hashFields.put("cust_ste_cd_c", "custSteCdC");
		this.hashFields.put("cust_ste_cd_n", "custSteCdN");
		this.hashFields.put("cstms_decl_cnt_cd_c", "cstmsDeclCntCdC");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_mf_hts", "cntrMfHts");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cust_addr_c", "custAddrC");
		this.hashFields.put("cntr_mf_hs", "cntrMfHs");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cstms_decl_cnt_cd_s", "cstmsDeclCntCdS");
		this.hashFields.put("meas_qty_chk", "measQtyChk");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pck_cmdt_desc", "pckCmdtDesc");
		this.hashFields.put("aes_inlnd_trns_no", "aesInlndTrnsNo");
		this.hashFields.put("cstms_decl_cnt_cd_n", "cstmsDeclCntCdN");
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
	 * @return cntrSealSeq
	 */
	public String getCntrSealSeq() {
		return this.cntrSealSeq;
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
	 * @return measQtyCm
	 */
	public String getMeasQtyCm() {
		return this.measQtyCm;
	}
	
	/**
	 * Column Info
	 * @return vehCmdtFlg
	 */
	public String getVehCmdtFlg() {
		return this.vehCmdtFlg;
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
	 * @return siFlg
	 */
	public String getSiFlg() {
		return this.siFlg;
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
	 * @return xterSiCd
	 */
	public String getXterSiCd() {
		return this.xterSiCd;
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
	 * @return cndCstmsFileCd
	 */
	public String getCndCstmsFileCd() {
		return this.cndCstmsFileCd;
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
	 * @return entrClssTpCd
	 */
	public String getEntrClssTpCd() {
		return this.entrClssTpCd;
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
	 * @return sCustAddrNm
	 */
	public String getSCustAddrNm() {
		return this.sCustAddrNm;
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
	 * @return cntrMfNcm
	 */
	public String getCntrMfNcm() {
		return this.cntrMfNcm;
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
	 * @return md
	 */
	public String getMd() {
		return this.md;
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
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
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
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
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
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return entrClssRmk
	 */
	public String getEntrClssRmk() {
		return this.entrClssRmk;
	}
	
	/**
	 * Column Info
	 * @return entrClssTpGubun
	 */
	public String getEntrClssTpGubun() {
		return this.entrClssTpGubun;
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
	 * @return custSteCdN
	 */
	public String getCustSteCdN() {
		return this.custSteCdN;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return custAddrC
	 */
	public String getCustAddrC() {
		return this.custAddrC;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
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
	 * @return pckCmdtDesc
	 */
	public String getPckCmdtDesc() {
		return this.pckCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return aesInlndTrnsNo
	 */
	public String getAesInlndTrnsNo() {
		return this.aesInlndTrnsNo;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param vehCmdtFlg
	 */
	public void setVehCmdtFlg(String vehCmdtFlg) {
		this.vehCmdtFlg = vehCmdtFlg;
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
	 * @param siFlg
	 */
	public void setSiFlg(String siFlg) {
		this.siFlg = siFlg;
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
	 * @param xterSiCd
	 */
	public void setXterSiCd(String xterSiCd) {
		this.xterSiCd = xterSiCd;
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
	 * @param cndCstmsFileCd
	 */
	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
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
	 * @param entrClssTpCd
	 */
	public void setEntrClssTpCd(String entrClssTpCd) {
		this.entrClssTpCd = entrClssTpCd;
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
	 * @param sCustAddrNm
	 */
	public void setSCustAddrNm(String sCustAddrNm) {
		this.sCustAddrNm = sCustAddrNm;
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
	 * @param cntrMfNcm
	 */
	public void setCntrMfNcm(String cntrMfNcm) {
		this.cntrMfNcm = cntrMfNcm;
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
	 * @param md
	 */
	public void setMd(String md) {
		this.md = md;
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
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
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
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
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
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param entrClssRmk
	 */
	public void setEntrClssRmk(String entrClssRmk) {
		this.entrClssRmk = entrClssRmk;
	}
	
	/**
	 * Column Info
	 * @param entrClssTpGubun
	 */
	public void setEntrClssTpGubun(String entrClssTpGubun) {
		this.entrClssTpGubun = entrClssTpGubun;
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
	 * @param custSteCdN
	 */
	public void setCustSteCdN(String custSteCdN) {
		this.custSteCdN = custSteCdN;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param custAddrC
	 */
	public void setCustAddrC(String custAddrC) {
		this.custAddrC = custAddrC;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
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
	 * @param pckCmdtDesc
	 */
	public void setPckCmdtDesc(String pckCmdtDesc) {
		this.pckCmdtDesc = pckCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param aesInlndTrnsNo
	 */
	public void setAesInlndTrnsNo(String aesInlndTrnsNo) {
		this.aesInlndTrnsNo = aesInlndTrnsNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCdN
	 */
	public void setCstmsDeclCntCdN(String cstmsDeclCntCdN) {
		this.cstmsDeclCntCdN = cstmsDeclCntCdN;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntrSealSeq(JSPUtil.getParameter(request, prefix + "cntr_seal_seq", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setMeasQtyCm(JSPUtil.getParameter(request, prefix + "meas_qty_cm", ""));
		setVehCmdtFlg(JSPUtil.getParameter(request, prefix + "veh_cmdt_flg", ""));
		setCustCtyNmN(JSPUtil.getParameter(request, prefix + "cust_cty_nm_n", ""));
		setMeasQtyCo(JSPUtil.getParameter(request, prefix + "meas_qty_co", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCustCtyNmS(JSPUtil.getParameter(request, prefix + "cust_cty_nm_s", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
		setCustCtyNmC(JSPUtil.getParameter(request, prefix + "cust_cty_nm_c", ""));
		setXterSiCd(JSPUtil.getParameter(request, prefix + "xter_si_cd", ""));
		setCustNmS(JSPUtil.getParameter(request, prefix + "cust_nm_s", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
		setCustNmN(JSPUtil.getParameter(request, prefix + "cust_nm_n", ""));
		setEntrClssTpCd(JSPUtil.getParameter(request, prefix + "entr_clss_tp_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setSCustAddrNm(JSPUtil.getParameter(request, prefix + "s_cust_addr_nm", ""));
		setCustNmC(JSPUtil.getParameter(request, prefix + "cust_nm_c", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setActWetChk(JSPUtil.getParameter(request, prefix + "act_wet_chk", ""));
		setMeasQtyDa(JSPUtil.getParameter(request, prefix + "meas_qty_da", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setCustAddrS(JSPUtil.getParameter(request, prefix + "cust_addr_s", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPckQtyChk(JSPUtil.getParameter(request, prefix + "pck_qty_chk", ""));
		setCustAddrN(JSPUtil.getParameter(request, prefix + "cust_addr_n", ""));
		setPckQtyDa(JSPUtil.getParameter(request, prefix + "pck_qty_da", ""));
		setCntrMfNcm(JSPUtil.getParameter(request, prefix + "cntr_mf_ncm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMd(JSPUtil.getParameter(request, prefix + "md", ""));
		setPckQtyCo(JSPUtil.getParameter(request, prefix + "pck_qty_co", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCustZipIdS(JSPUtil.getParameter(request, prefix + "cust_zip_id_s", ""));
		setPckQtyCm(JSPUtil.getParameter(request, prefix + "pck_qty_cm", ""));
		setCustZipIdN(JSPUtil.getParameter(request, prefix + "cust_zip_id_n", ""));
		setChkErr(JSPUtil.getParameter(request, prefix + "chk_err", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setEntrClssRmk(JSPUtil.getParameter(request, prefix + "entr_clss_rmk", ""));
		setEntrClssTpGubun(JSPUtil.getParameter(request, prefix + "entr_clss_tp_gubun", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setCustZipIdC(JSPUtil.getParameter(request, prefix + "cust_zip_id_c", ""));
		setCustSteCdC(JSPUtil.getParameter(request, prefix + "cust_ste_cd_c", ""));
		setCustSteCdN(JSPUtil.getParameter(request, prefix + "cust_ste_cd_n", ""));
		setCstmsDeclCntCdC(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd_c", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrMfHts(JSPUtil.getParameter(request, prefix + "cntr_mf_hts", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setCustAddrC(JSPUtil.getParameter(request, prefix + "cust_addr_c", ""));
		setCntrMfHs(JSPUtil.getParameter(request, prefix + "cntr_mf_hs", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCstmsDeclCntCdS(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd_s", ""));
		setMeasQtyChk(JSPUtil.getParameter(request, prefix + "meas_qty_chk", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setPckCmdtDesc(JSPUtil.getParameter(request, prefix + "pck_cmdt_desc", ""));
		setAesInlndTrnsNo(JSPUtil.getParameter(request, prefix + "aes_inlnd_trns_no", ""));
		setCstmsDeclCntCdN(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd_n", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCMCroChkListByExportBLVO[]
	 */
	public BkgCMCroChkListByExportBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCMCroChkListByExportBLVO[]
	 */
	public BkgCMCroChkListByExportBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCMCroChkListByExportBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrSealSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_seq", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] measQtyCm = (JSPUtil.getParameter(request, prefix	+ "meas_qty_cm", length));
			String[] vehCmdtFlg = (JSPUtil.getParameter(request, prefix	+ "veh_cmdt_flg", length));
			String[] custCtyNmN = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_n", length));
			String[] measQtyCo = (JSPUtil.getParameter(request, prefix	+ "meas_qty_co", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] custCtyNmS = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_s", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] siFlg = (JSPUtil.getParameter(request, prefix	+ "si_flg", length));
			String[] custCtyNmC = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm_c", length));
			String[] xterSiCd = (JSPUtil.getParameter(request, prefix	+ "xter_si_cd", length));
			String[] custNmS = (JSPUtil.getParameter(request, prefix	+ "cust_nm_s", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] custNmN = (JSPUtil.getParameter(request, prefix	+ "cust_nm_n", length));
			String[] entrClssTpCd = (JSPUtil.getParameter(request, prefix	+ "entr_clss_tp_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] sCustAddrNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr_nm", length));
			String[] custNmC = (JSPUtil.getParameter(request, prefix	+ "cust_nm_c", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actWetChk = (JSPUtil.getParameter(request, prefix	+ "act_wet_chk", length));
			String[] measQtyDa = (JSPUtil.getParameter(request, prefix	+ "meas_qty_da", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] custAddrS = (JSPUtil.getParameter(request, prefix	+ "cust_addr_s", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] pckQtyChk = (JSPUtil.getParameter(request, prefix	+ "pck_qty_chk", length));
			String[] custAddrN = (JSPUtil.getParameter(request, prefix	+ "cust_addr_n", length));
			String[] pckQtyDa = (JSPUtil.getParameter(request, prefix	+ "pck_qty_da", length));
			String[] cntrMfNcm = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_ncm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] md = (JSPUtil.getParameter(request, prefix	+ "md", length));
			String[] pckQtyCo = (JSPUtil.getParameter(request, prefix	+ "pck_qty_co", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] custZipIdS = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_s", length));
			String[] pckQtyCm = (JSPUtil.getParameter(request, prefix	+ "pck_qty_cm", length));
			String[] custZipIdN = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_n", length));
			String[] chkErr = (JSPUtil.getParameter(request, prefix	+ "chk_err", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] entrClssRmk = (JSPUtil.getParameter(request, prefix	+ "entr_clss_rmk", length));
			String[] entrClssTpGubun = (JSPUtil.getParameter(request, prefix	+ "entr_clss_tp_gubun", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] custZipIdC = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id_c", length));
			String[] custSteCdC = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd_c", length));
			String[] custSteCdN = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd_n", length));
			String[] cstmsDeclCntCdC = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_c", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrMfHts = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_hts", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] custAddrC = (JSPUtil.getParameter(request, prefix	+ "cust_addr_c", length));
			String[] cntrMfHs = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_hs", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cstmsDeclCntCdS = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_s", length));
			String[] measQtyChk = (JSPUtil.getParameter(request, prefix	+ "meas_qty_chk", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pckCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "pck_cmdt_desc", length));
			String[] aesInlndTrnsNo = (JSPUtil.getParameter(request, prefix	+ "aes_inlnd_trns_no", length));
			String[] cstmsDeclCntCdN = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd_n", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCMCroChkListByExportBLVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrSealSeq[i] != null)
					model.setCntrSealSeq(cntrSealSeq[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (measQtyCm[i] != null)
					model.setMeasQtyCm(measQtyCm[i]);
				if (vehCmdtFlg[i] != null)
					model.setVehCmdtFlg(vehCmdtFlg[i]);
				if (custCtyNmN[i] != null)
					model.setCustCtyNmN(custCtyNmN[i]);
				if (measQtyCo[i] != null)
					model.setMeasQtyCo(measQtyCo[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (custCtyNmS[i] != null)
					model.setCustCtyNmS(custCtyNmS[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (siFlg[i] != null)
					model.setSiFlg(siFlg[i]);
				if (custCtyNmC[i] != null)
					model.setCustCtyNmC(custCtyNmC[i]);
				if (xterSiCd[i] != null)
					model.setXterSiCd(xterSiCd[i]);
				if (custNmS[i] != null)
					model.setCustNmS(custNmS[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (custNmN[i] != null)
					model.setCustNmN(custNmN[i]);
				if (entrClssTpCd[i] != null)
					model.setEntrClssTpCd(entrClssTpCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (sCustAddrNm[i] != null)
					model.setSCustAddrNm(sCustAddrNm[i]);
				if (custNmC[i] != null)
					model.setCustNmC(custNmC[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actWetChk[i] != null)
					model.setActWetChk(actWetChk[i]);
				if (measQtyDa[i] != null)
					model.setMeasQtyDa(measQtyDa[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (custAddrS[i] != null)
					model.setCustAddrS(custAddrS[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (pckQtyChk[i] != null)
					model.setPckQtyChk(pckQtyChk[i]);
				if (custAddrN[i] != null)
					model.setCustAddrN(custAddrN[i]);
				if (pckQtyDa[i] != null)
					model.setPckQtyDa(pckQtyDa[i]);
				if (cntrMfNcm[i] != null)
					model.setCntrMfNcm(cntrMfNcm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (md[i] != null)
					model.setMd(md[i]);
				if (pckQtyCo[i] != null)
					model.setPckQtyCo(pckQtyCo[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (custZipIdS[i] != null)
					model.setCustZipIdS(custZipIdS[i]);
				if (pckQtyCm[i] != null)
					model.setPckQtyCm(pckQtyCm[i]);
				if (custZipIdN[i] != null)
					model.setCustZipIdN(custZipIdN[i]);
				if (chkErr[i] != null)
					model.setChkErr(chkErr[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (entrClssRmk[i] != null)
					model.setEntrClssRmk(entrClssRmk[i]);
				if (entrClssTpGubun[i] != null)
					model.setEntrClssTpGubun(entrClssTpGubun[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (custZipIdC[i] != null)
					model.setCustZipIdC(custZipIdC[i]);
				if (custSteCdC[i] != null)
					model.setCustSteCdC(custSteCdC[i]);
				if (custSteCdN[i] != null)
					model.setCustSteCdN(custSteCdN[i]);
				if (cstmsDeclCntCdC[i] != null)
					model.setCstmsDeclCntCdC(cstmsDeclCntCdC[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrMfHts[i] != null)
					model.setCntrMfHts(cntrMfHts[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (custAddrC[i] != null)
					model.setCustAddrC(custAddrC[i]);
				if (cntrMfHs[i] != null)
					model.setCntrMfHs(cntrMfHs[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cstmsDeclCntCdS[i] != null)
					model.setCstmsDeclCntCdS(cstmsDeclCntCdS[i]);
				if (measQtyChk[i] != null)
					model.setMeasQtyChk(measQtyChk[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pckCmdtDesc[i] != null)
					model.setPckCmdtDesc(pckCmdtDesc[i]);
				if (aesInlndTrnsNo[i] != null)
					model.setAesInlndTrnsNo(aesInlndTrnsNo[i]);
				if (cstmsDeclCntCdN[i] != null)
					model.setCstmsDeclCntCdN(cstmsDeclCntCdN[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCMCroChkListByExportBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCMCroChkListByExportBLVO[]
	 */
	public BkgCMCroChkListByExportBLVO[] getBkgCMCroChkListByExportBLVOs(){
		BkgCMCroChkListByExportBLVO[] vos = (BkgCMCroChkListByExportBLVO[])models.toArray(new BkgCMCroChkListByExportBLVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealSeq = this.cntrSealSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCm = this.measQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vehCmdtFlg = this.vehCmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmN = this.custCtyNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCo = this.measQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmS = this.custCtyNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siFlg = this.siFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNmC = this.custCtyNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiCd = this.xterSiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmS = this.custNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmN = this.custNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrClssTpCd = this.entrClssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddrNm = this.sCustAddrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmC = this.custNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWetChk = this.actWetChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyDa = this.measQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrS = this.custAddrS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyChk = this.pckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrN = this.custAddrN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyDa = this.pckQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNcm = this.cntrMfNcm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.md = this.md .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyCo = this.pckQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdS = this.custZipIdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyCm = this.pckQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdN = this.custZipIdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkErr = this.chkErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrClssRmk = this.entrClssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrClssTpGubun = this.entrClssTpGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipIdC = this.custZipIdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCdC = this.custSteCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCdN = this.custSteCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdC = this.cstmsDeclCntCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfHts = this.cntrMfHts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrC = this.custAddrC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfHs = this.cntrMfHs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdS = this.cstmsDeclCntCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyChk = this.measQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCmdtDesc = this.pckCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesInlndTrnsNo = this.aesInlndTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCdN = this.cstmsDeclCntCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
