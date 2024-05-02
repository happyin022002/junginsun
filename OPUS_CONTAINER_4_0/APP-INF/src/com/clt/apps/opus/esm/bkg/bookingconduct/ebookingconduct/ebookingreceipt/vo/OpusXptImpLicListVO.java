/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpusXptImpLicListVO.java
*@FileTitle : OpusXptImpLicListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.24 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
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

public class OpusXptImpLicListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpusXptImpLicListVO> models = new ArrayList<OpusXptImpLicListVO>();
	
	/* Column Info */
	private String ndrRefId = null;
	/* Column Info */
	private String tsRefNo = null;
	/* Column Info */
	private String aesPtuDt = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String aesExptCtnt = null;
	/* Column Info */
	private String aesExptId = null;
	/* Column Info */
	private String samPckId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divdPckQty = null;
	/* Column Info */
	private String samPckTpCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String aesPtuPfxCtnt = null;
	/* Column Info */
	private String aesInlndTrnsPfxCtnt = null;
	/* Column Info */
	private String cgoCtrlPfxCtnt = null;
	/* Column Info */
	private String ndrRefCtnt = null;
	/* Column Info */
	private String aesPtaDt = null;
	/* Column Info */
	private String aesDwnDt = null;
	/* Column Info */
	private String g7EdiPfxCtnt = null;
	/* Column Info */
	private String aesPtaPfxCtnt = null;
	/* Column Info */
	private String mfSmryRptNo = null;
	/* Column Info */
	private String mxNtfyTaxId = null;
	/* Column Info */
	private String aesTpCd = null;
	/* Column Info */
	private String divdPckTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String aesPtuNo = null;
	/* Column Info */
	private String divdWgt = null;
	/* Column Info */
	private String divdWgtUtCd = null;
	/* Column Info */
	private String ndrRefPfxCtnt = null;
	/* Column Info */
	private String mxCneeTaxId = null;
	/* Column Info */
	private String b13aXptPfxCtnt = null;
	/* Column Info */
	private String aesPtaNo1 = null;
	/* Column Info */
	private String aesPtaNo2 = null;
	/* Column Info */
	private String aesDwnPfxCtnt = null;
	/* Column Info */
	private String xptImpSeq = null;
	/* Column Info */
	private String samPckQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String g7EdiCtnt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String caedTpCd = null;
	/* Column Info */
	private String divdSeq = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String mfSmryRptPfxCtnt = null;
	/* Column Info */
	private String aesDwnNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mfWgt = null;
	/* Column Info */
	private String caedPfxCtnt = null;
	/* Column Info */
	private String caedCtnt = null;
	/* Column Info */
	private String divdFlg = null;
	/* Column Info */
	private String mxShprTaxId = null;
	/* Column Info */
	private String cgoCtrlNo = null;
	/* Column Info */
	private String b13aXptCtnt = null;
	/* Column Info */
	private String aesInlndTrnsNo = null;
	/* Column Info */
	private String trShprTaxId = null;
	/* Column Info */
	private String trCneeTaxId = null;
	/* Column Info */
	private String trNtfyTaxId = null;
	/* Column Info */
	private String ilShprTaxId = null;
	/* Column Info */
	private String ilCneeTaxId = null;
	/* Column Info */
	private String ilNtfyTaxId = null;
	/* Column Info */
	private String lbShprTaxId = null;
	/* Column Info */
	private String lbCneeTaxId = null;
	/* Column Info */
	private String lbNtfyTaxId = null;
	/* Column Info */
	private String brShprTaxId = null;
	/* Column Info */
	private String brCneeTaxId = null;
	/* Column Info */
	private String brNtfyTaxId = null;
	/* Column Info */
	private String shprTaxCpyDescFlg = null;
	/* Column Info */
	private String ntfyTaxCpyDescFlg = null;
	/* Column Info */
	private String cneeTaxCpyDescFlg = null;
	/* Column Info */
	private String brzDeclNo = null;
	/* Column Info */
	private String brzDeclCpyDescFlg = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpusXptImpLicListVO() {}

	public OpusXptImpLicListVO(String ibflag, String pagerows, String bkgNo, String ioBndCd, String xptImpSeq, String cntCd, String xptLicNo, String tsRefNo, String pckQty, String pckTpCd, String mfWgt, String wgtUtCd, String divdFlg, String divdSeq, String divdPckQty, String divdPckTpCd, String divdWgt, String divdWgtUtCd, String samPckId, String samPckQty, String samPckTpCd, String aesTpCd, String aesInlndTrnsPfxCtnt, String aesInlndTrnsNo, String aesPtaPfxCtnt, String aesPtaNo1, String aesPtaNo2, String aesPtaDt, String aesPtuPfxCtnt, String aesPtuNo, String aesPtuDt, String aesDwnPfxCtnt, String aesDwnNo, String aesDwnDt, String aesExptId, String aesExptCtnt, String caedTpCd, String caedPfxCtnt, String caedCtnt, String g7EdiPfxCtnt, String g7EdiCtnt, String b13aXptPfxCtnt, String b13aXptCtnt, String mfSmryRptPfxCtnt, String mfSmryRptNo, String cgoCtrlPfxCtnt, String cgoCtrlNo, String ndrRefPfxCtnt, String ndrRefId, String ndrRefCtnt, String mxShprTaxId, String mxCneeTaxId, String mxNtfyTaxId,String trShprTaxId, String trCneeTaxId, String trNtfyTaxId, String ilShprTaxId, String ilCneeTaxId, String ilNtfyTaxId, String lbShprTaxId, String lbCneeTaxId, String lbNtfyTaxId, String brShprTaxId, String brCneeTaxId, String brNtfyTaxId, String shprTaxCpyDescFlg, String ntfyTaxCpyDescFlg, String cneeTaxCpyDescFlg, String brzDeclNo, String brzDeclCpyDescFlg) {
		this.ndrRefId = ndrRefId;
		this.tsRefNo = tsRefNo;
		this.aesPtuDt = aesPtuDt;
		this.xptLicNo = xptLicNo;
		this.aesExptCtnt = aesExptCtnt;
		this.aesExptId = aesExptId;
		this.samPckId = samPckId;
		this.pagerows = pagerows;
		this.divdPckQty = divdPckQty;
		this.samPckTpCd = samPckTpCd;
		this.cntCd = cntCd;
		this.wgtUtCd = wgtUtCd;
		this.aesPtuPfxCtnt = aesPtuPfxCtnt;
		this.aesInlndTrnsPfxCtnt = aesInlndTrnsPfxCtnt;
		this.cgoCtrlPfxCtnt = cgoCtrlPfxCtnt;
		this.ndrRefCtnt = ndrRefCtnt;
		this.aesPtaDt = aesPtaDt;
		this.aesDwnDt = aesDwnDt;
		this.g7EdiPfxCtnt = g7EdiPfxCtnt;
		this.aesPtaPfxCtnt = aesPtaPfxCtnt;
		this.mfSmryRptNo = mfSmryRptNo;
		this.mxNtfyTaxId = mxNtfyTaxId;
		this.aesTpCd = aesTpCd;
		this.divdPckTpCd = divdPckTpCd;
		this.bkgNo = bkgNo;
		this.aesPtuNo = aesPtuNo;
		this.divdWgt = divdWgt;
		this.divdWgtUtCd = divdWgtUtCd;
		this.ndrRefPfxCtnt = ndrRefPfxCtnt;
		this.mxCneeTaxId = mxCneeTaxId;
		this.b13aXptPfxCtnt = b13aXptPfxCtnt;
		this.aesPtaNo1 = aesPtaNo1;
		this.aesPtaNo2 = aesPtaNo2;
		this.aesDwnPfxCtnt = aesDwnPfxCtnt;
		this.xptImpSeq = xptImpSeq;
		this.samPckQty = samPckQty;
		this.ibflag = ibflag;
		this.g7EdiCtnt = g7EdiCtnt;
		this.pckQty = pckQty;
		this.caedTpCd = caedTpCd;
		this.divdSeq = divdSeq;
		this.pckTpCd = pckTpCd;
		this.mfSmryRptPfxCtnt = mfSmryRptPfxCtnt;
		this.aesDwnNo = aesDwnNo;
		this.ioBndCd = ioBndCd;
		this.mfWgt = mfWgt;
		this.caedPfxCtnt = caedPfxCtnt;
		this.caedCtnt = caedCtnt;
		this.divdFlg = divdFlg;
		this.mxShprTaxId = mxShprTaxId;
		this.cgoCtrlNo = cgoCtrlNo;
		this.b13aXptCtnt = b13aXptCtnt;
		this.aesInlndTrnsNo = aesInlndTrnsNo;
		this.trShprTaxId = trShprTaxId;
		this.trCneeTaxId = trCneeTaxId;
		this.trNtfyTaxId = trNtfyTaxId;
		this.ilShprTaxId = ilShprTaxId;
		this.ilCneeTaxId = ilCneeTaxId;
		this.ilNtfyTaxId = ilNtfyTaxId;
		this.lbShprTaxId = lbShprTaxId;
		this.lbCneeTaxId = lbCneeTaxId;
		this.lbNtfyTaxId = lbNtfyTaxId;
		this.brShprTaxId = brShprTaxId;
		this.brCneeTaxId = brCneeTaxId;
		this.brNtfyTaxId = brNtfyTaxId;
		this.shprTaxCpyDescFlg = shprTaxCpyDescFlg;
		this.ntfyTaxCpyDescFlg = ntfyTaxCpyDescFlg;
		this.cneeTaxCpyDescFlg = cneeTaxCpyDescFlg;
		this.brzDeclNo = brzDeclNo;
		this.brzDeclCpyDescFlg = brzDeclCpyDescFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ndr_ref_id", getNdrRefId());
		this.hashColumns.put("ts_ref_no", getTsRefNo());
		this.hashColumns.put("aes_ptu_dt", getAesPtuDt());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("aes_expt_ctnt", getAesExptCtnt());
		this.hashColumns.put("aes_expt_id", getAesExptId());
		this.hashColumns.put("sam_pck_id", getSamPckId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("divd_pck_qty", getDivdPckQty());
		this.hashColumns.put("sam_pck_tp_cd", getSamPckTpCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("aes_ptu_pfx_ctnt", getAesPtuPfxCtnt());
		this.hashColumns.put("aes_inlnd_trns_pfx_ctnt", getAesInlndTrnsPfxCtnt());
		this.hashColumns.put("cgo_ctrl_pfx_ctnt", getCgoCtrlPfxCtnt());
		this.hashColumns.put("ndr_ref_ctnt", getNdrRefCtnt());
		this.hashColumns.put("aes_pta_dt", getAesPtaDt());
		this.hashColumns.put("aes_dwn_dt", getAesDwnDt());
		this.hashColumns.put("g7_edi_pfx_ctnt", getG7EdiPfxCtnt());
		this.hashColumns.put("aes_pta_pfx_ctnt", getAesPtaPfxCtnt());
		this.hashColumns.put("mf_smry_rpt_no", getMfSmryRptNo());
		this.hashColumns.put("mx_ntfy_tax_id", getMxNtfyTaxId());
		this.hashColumns.put("aes_tp_cd", getAesTpCd());
		this.hashColumns.put("divd_pck_tp_cd", getDivdPckTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("aes_ptu_no", getAesPtuNo());
		this.hashColumns.put("divd_wgt", getDivdWgt());
		this.hashColumns.put("divd_wgt_ut_cd", getDivdWgtUtCd());
		this.hashColumns.put("ndr_ref_pfx_ctnt", getNdrRefPfxCtnt());
		this.hashColumns.put("mx_cnee_tax_id", getMxCneeTaxId());
		this.hashColumns.put("b13a_xpt_pfx_ctnt", getB13aXptPfxCtnt());
		this.hashColumns.put("aes_pta_no1", getAesPtaNo1());
		this.hashColumns.put("aes_pta_no2", getAesPtaNo2());
		this.hashColumns.put("aes_dwn_pfx_ctnt", getAesDwnPfxCtnt());
		this.hashColumns.put("xpt_imp_seq", getXptImpSeq());
		this.hashColumns.put("sam_pck_qty", getSamPckQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("g7_edi_ctnt", getG7EdiCtnt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("caed_tp_cd", getCaedTpCd());
		this.hashColumns.put("divd_seq", getDivdSeq());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("mf_smry_rpt_pfx_ctnt", getMfSmryRptPfxCtnt());
		this.hashColumns.put("aes_dwn_no", getAesDwnNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mf_wgt", getMfWgt());
		this.hashColumns.put("caed_pfx_ctnt", getCaedPfxCtnt());
		this.hashColumns.put("caed_ctnt", getCaedCtnt());
		this.hashColumns.put("divd_flg", getDivdFlg());
		this.hashColumns.put("mx_shpr_tax_id", getMxShprTaxId());
		this.hashColumns.put("cgo_ctrl_no", getCgoCtrlNo());
		this.hashColumns.put("b13a_xpt_ctnt", getB13aXptCtnt());
		this.hashColumns.put("aes_inlnd_trns_no", getAesInlndTrnsNo());
		this.hashColumns.put("tr_shpr_tax_id", getTrShprTaxId());
		this.hashColumns.put("tr_cnee_tax_id", getTrCneeTaxId());
		this.hashColumns.put("tr_ntfy_tax_id", getTrNtfyTaxId());
		this.hashColumns.put("il_shpr_tax_id", getIlShprTaxId());
		this.hashColumns.put("il_cnee_tax_id", getIlCneeTaxId());
		this.hashColumns.put("il_ntfy_tax_id", getIlNtfyTaxId());
		this.hashColumns.put("lb_shpr_tax_id", getLbShprTaxId());
		this.hashColumns.put("lb_cnee_tax_id", getLbCneeTaxId());
		this.hashColumns.put("lb_ntfy_tax_id", getLbNtfyTaxId());
		this.hashColumns.put("br_shpr_tax_id", getBrShprTaxId());
		this.hashColumns.put("br_cnee_tax_id", getBrCneeTaxId());
		this.hashColumns.put("br_ntfy_tax_id", getBrNtfyTaxId());
		this.hashColumns.put("shpr_tax_cpy_desc_flg", getShprTaxCpyDescFlg());
		this.hashColumns.put("ntfy_tax_cpy_desc_flg", getNtfyTaxCpyDescFlg());
		this.hashColumns.put("cnee_tax_cpy_desc_flg", getCneeTaxCpyDescFlg());
		this.hashColumns.put("brz_decl_cpy_desc_flg", getBrzDeclCpyDescFlg());
		this.hashColumns.put("brz_decl_no", getBrzDeclNo());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ndr_ref_id", "ndrRefId");
		this.hashFields.put("ts_ref_no", "tsRefNo");
		this.hashFields.put("aes_ptu_dt", "aesPtuDt");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("aes_expt_ctnt", "aesExptCtnt");
		this.hashFields.put("aes_expt_id", "aesExptId");
		this.hashFields.put("sam_pck_id", "samPckId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("divd_pck_qty", "divdPckQty");
		this.hashFields.put("sam_pck_tp_cd", "samPckTpCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("aes_ptu_pfx_ctnt", "aesPtuPfxCtnt");
		this.hashFields.put("aes_inlnd_trns_pfx_ctnt", "aesInlndTrnsPfxCtnt");
		this.hashFields.put("cgo_ctrl_pfx_ctnt", "cgoCtrlPfxCtnt");
		this.hashFields.put("ndr_ref_ctnt", "ndrRefCtnt");
		this.hashFields.put("aes_pta_dt", "aesPtaDt");
		this.hashFields.put("aes_dwn_dt", "aesDwnDt");
		this.hashFields.put("g7_edi_pfx_ctnt", "g7EdiPfxCtnt");
		this.hashFields.put("aes_pta_pfx_ctnt", "aesPtaPfxCtnt");
		this.hashFields.put("mf_smry_rpt_no", "mfSmryRptNo");
		this.hashFields.put("mx_ntfy_tax_id", "mxNtfyTaxId");
		this.hashFields.put("aes_tp_cd", "aesTpCd");
		this.hashFields.put("divd_pck_tp_cd", "divdPckTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("aes_ptu_no", "aesPtuNo");
		this.hashFields.put("divd_wgt", "divdWgt");
		this.hashFields.put("divd_wgt_ut_cd", "divdWgtUtCd");
		this.hashFields.put("ndr_ref_pfx_ctnt", "ndrRefPfxCtnt");
		this.hashFields.put("mx_cnee_tax_id", "mxCneeTaxId");
		this.hashFields.put("b13a_xpt_pfx_ctnt", "b13aXptPfxCtnt");
		this.hashFields.put("aes_pta_no1", "aesPtaNo1");
		this.hashFields.put("aes_pta_no2", "aesPtaNo2");
		this.hashFields.put("aes_dwn_pfx_ctnt", "aesDwnPfxCtnt");
		this.hashFields.put("xpt_imp_seq", "xptImpSeq");
		this.hashFields.put("sam_pck_qty", "samPckQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("g7_edi_ctnt", "g7EdiCtnt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("caed_tp_cd", "caedTpCd");
		this.hashFields.put("divd_seq", "divdSeq");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("mf_smry_rpt_pfx_ctnt", "mfSmryRptPfxCtnt");
		this.hashFields.put("aes_dwn_no", "aesDwnNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mf_wgt", "mfWgt");
		this.hashFields.put("caed_pfx_ctnt", "caedPfxCtnt");
		this.hashFields.put("caed_ctnt", "caedCtnt");
		this.hashFields.put("divd_flg", "divdFlg");
		this.hashFields.put("mx_shpr_tax_id", "mxShprTaxId");
		this.hashFields.put("cgo_ctrl_no", "cgoCtrlNo");
		this.hashFields.put("b13a_xpt_ctnt", "b13aXptCtnt");
		this.hashFields.put("aes_inlnd_trns_no", "aesInlndTrnsNo");
		this.hashFields.put("tr_shpr_tax_id", "trShprTaxId");
		this.hashFields.put("tr_cnee_tax_id", "trCneeTaxId");
		this.hashFields.put("tr_ntfy_tax_id", "trNtfyTaxId");
		this.hashFields.put("il_shpr_tax_id", "ilShprTaxId");
		this.hashFields.put("il_cnee_tax_id", "ilCneeTaxId");
		this.hashFields.put("il_ntfy_tax_id", "ilNtfyTaxId");
		this.hashFields.put("lb_shpr_tax_id", "lbShprTaxId");
		this.hashFields.put("lb_cnee_tax_id", "lbCneeTaxId");
		this.hashFields.put("lb_ntfy_tax_id", "lbNtfyTaxId");
		this.hashFields.put("br_shpr_tax_id", "brShprTaxId");
		this.hashFields.put("br_cnee_tax_id", "brCneeTaxId");
		this.hashFields.put("br_ntfy_tax_id", "brNtfyTaxId");                  
		this.hashFields.put("shpr_tax_cpy_desc_flg", "shpr_tax_cpy_desc_flg"); 
		this.hashFields.put("ntfy_tax_cpy_desc_flg", "ntfy_tax_cpy_desc_flg"); 
		this.hashFields.put("cnee_tax_cpy_desc_flg", "cnee_tax_cpy_desc_flg"); 
		this.hashFields.put("brz_decl_cpy_desc_flg", "brz_decl_cpy_desc_flg"); 
		this.hashFields.put("brz_decl_no", "brz_decl_no");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ndrRefId
	 */
	public String getNdrRefId() {
		return this.ndrRefId;
	}
	
	/**
	 * Column Info
	 * @return tsRefNo
	 */
	public String getTsRefNo() {
		return this.tsRefNo;
	}
	
	/**
	 * Column Info
	 * @return aesPtuDt
	 */
	public String getAesPtuDt() {
		return this.aesPtuDt;
	}
	
	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
	}
	
	/**
	 * Column Info
	 * @return aesExptCtnt
	 */
	public String getAesExptCtnt() {
		return this.aesExptCtnt;
	}
	
	/**
	 * Column Info
	 * @return aesExptId
	 */
	public String getAesExptId() {
		return this.aesExptId;
	}
	
	/**
	 * Column Info
	 * @return samPckId
	 */
	public String getSamPckId() {
		return this.samPckId;
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
	 * @return divdPckQty
	 */
	public String getDivdPckQty() {
		return this.divdPckQty;
	}
	
	/**
	 * Column Info
	 * @return samPckTpCd
	 */
	public String getSamPckTpCd() {
		return this.samPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return aesPtuPfxCtnt
	 */
	public String getAesPtuPfxCtnt() {
		return this.aesPtuPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return aesInlndTrnsPfxCtnt
	 */
	public String getAesInlndTrnsPfxCtnt() {
		return this.aesInlndTrnsPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return cgoCtrlPfxCtnt
	 */
	public String getCgoCtrlPfxCtnt() {
		return this.cgoCtrlPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return ndrRefCtnt
	 */
	public String getNdrRefCtnt() {
		return this.ndrRefCtnt;
	}
	
	/**
	 * Column Info
	 * @return aesPtaDt
	 */
	public String getAesPtaDt() {
		return this.aesPtaDt;
	}
	
	/**
	 * Column Info
	 * @return aesDwnDt
	 */
	public String getAesDwnDt() {
		return this.aesDwnDt;
	}
	
	/**
	 * Column Info
	 * @return g7EdiPfxCtnt
	 */
	public String getG7EdiPfxCtnt() {
		return this.g7EdiPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return aesPtaPfxCtnt
	 */
	public String getAesPtaPfxCtnt() {
		return this.aesPtaPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return mfSmryRptNo
	 */
	public String getMfSmryRptNo() {
		return this.mfSmryRptNo;
	}
	
	/**
	 * Column Info
	 * @return mxNtfyTaxId
	 */
	public String getMxNtfyTaxId() {
		return this.mxNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @return aesTpCd
	 */
	public String getAesTpCd() {
		return this.aesTpCd;
	}
	
	/**
	 * Column Info
	 * @return divdPckTpCd
	 */
	public String getDivdPckTpCd() {
		return this.divdPckTpCd;
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
	 * @return aesPtuNo
	 */
	public String getAesPtuNo() {
		return this.aesPtuNo;
	}
	
	/**
	 * Column Info
	 * @return divdWgt
	 */
	public String getDivdWgt() {
		return this.divdWgt;
	}
	
	/**
	 * Column Info
	 * @return divdWgtUtCd
	 */
	public String getDivdWgtUtCd() {
		return this.divdWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return ndrRefPfxCtnt
	 */
	public String getNdrRefPfxCtnt() {
		return this.ndrRefPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return mxCneeTaxId
	 */
	public String getMxCneeTaxId() {
		return this.mxCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @return b13aXptPfxCtnt
	 */
	public String getB13aXptPfxCtnt() {
		return this.b13aXptPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return aesPtaNo1
	 */
	public String getAesPtaNo1() {
		return this.aesPtaNo1;
	}
	
	/**
	 * Column Info
	 * @return aesPtaNo2
	 */
	public String getAesPtaNo2() {
		return this.aesPtaNo2;
	}
	
	/**
	 * Column Info
	 * @return aesDwnPfxCtnt
	 */
	public String getAesDwnPfxCtnt() {
		return this.aesDwnPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return xptImpSeq
	 */
	public String getXptImpSeq() {
		return this.xptImpSeq;
	}
	
	/**
	 * Column Info
	 * @return samPckQty
	 */
	public String getSamPckQty() {
		return this.samPckQty;
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
	 * @return g7EdiCtnt
	 */
	public String getG7EdiCtnt() {
		return this.g7EdiCtnt;
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
	 * @return caedTpCd
	 */
	public String getCaedTpCd() {
		return this.caedTpCd;
	}
	
	/**
	 * Column Info
	 * @return divdSeq
	 */
	public String getDivdSeq() {
		return this.divdSeq;
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
	 * @return mfSmryRptPfxCtnt
	 */
	public String getMfSmryRptPfxCtnt() {
		return this.mfSmryRptPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return aesDwnNo
	 */
	public String getAesDwnNo() {
		return this.aesDwnNo;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return mfWgt
	 */
	public String getMfWgt() {
		return this.mfWgt;
	}
	
	/**
	 * Column Info
	 * @return caedPfxCtnt
	 */
	public String getCaedPfxCtnt() {
		return this.caedPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @return caedCtnt
	 */
	public String getCaedCtnt() {
		return this.caedCtnt;
	}
	
	/**
	 * Column Info
	 * @return divdFlg
	 */
	public String getDivdFlg() {
		return this.divdFlg;
	}
	
	/**
	 * Column Info
	 * @return mxShprTaxId
	 */
	public String getMxShprTaxId() {
		return this.mxShprTaxId;
	}
	
	/**
	 * Column Info
	 * @return cgoCtrlNo
	 */
	public String getCgoCtrlNo() {
		return this.cgoCtrlNo;
	}
	
	/**
	 * Column Info
	 * @return b13aXptCtnt
	 */
	public String getB13aXptCtnt() {
		return this.b13aXptCtnt;
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
	 * @return trShprTaxId
	 */
	public String getTrShprTaxId() {
		return trShprTaxId;
	}

	/**
	 * Column Info
	 * @return trCneeTaxId
	 */
	public String getTrCneeTaxId() {
		return trCneeTaxId;
	}

	/**
	 * Column Info
	 * @return trNtfyTaxId
	 */
	public String getTrNtfyTaxId() {
		return trNtfyTaxId;
	}

	/**
	 * Column Info
	 * @return ilShprTaxId
	 */
	public String getIlShprTaxId() {
		return ilShprTaxId;
	}

	/**
	 * Column Info
	 * @return ilCneeTaxId
	 */
	public String getIlCneeTaxId() {
		return ilCneeTaxId;
	}

	/**
	 * Column Info
	 * @return ilNtfyTaxId
	 */
	public String getIlNtfyTaxId() {
		return ilNtfyTaxId;
	}

	/**
	 * Column Info
	 * @return lbShprTaxId
	 */
	public String getLbShprTaxId() {
		return lbShprTaxId;
	}

	/**
	 * Column Info
	 * @return lbCneeTaxId
	 */
	public String getLbCneeTaxId() {
		return lbCneeTaxId;
	}

	/**
	 * Column Info
	 * @return lbNtfyTaxId
	 */
	public String getLbNtfyTaxId() {
		return lbNtfyTaxId;
	}

	/**
	 * Column Info
	 * @return brShprTaxId
	 */
	public String getBrShprTaxId() {
		return brShprTaxId;
	}

	/**
	 * Column Info
	 * @return brCneeTaxId
	 */
	public String getBrCneeTaxId() {
		return brCneeTaxId;
	}

	/**
	 * Column Info
	 * @return brNtfyTaxId
	 */
	public String getBrNtfyTaxId() {
		return brNtfyTaxId;
	}

	/**
	 * Column Info
	 * @return shprTaxCpyDescFlg
	 */
	public String getShprTaxCpyDescFlg() {
		return shprTaxCpyDescFlg;
	}

	/**
	 * Column Info
	 * @return ntfyTaxCpyDescFlg
	 */
	public String getNtfyTaxCpyDescFlg() {
		return ntfyTaxCpyDescFlg;
	}

	/**
	 * Column Info
	 * @return cneeTaxCpyDescFlg
	 */
	public String getCneeTaxCpyDescFlg() {
		return cneeTaxCpyDescFlg;
	}

	/**
	 * Column Info
	 * @return brzDeclNo
	 */
	public String getBrzDeclNo() {
		return brzDeclNo;
	}

	/**
	 * Column Info
	 * @return brzDeclCpyDescFlg
	 */
	public String getBrzDeclCpyDescFlg() {
		return brzDeclCpyDescFlg;
	}

	/**
	 * Column Info
	 * @param ndrRefId
	 */
	public void setNdrRefId(String ndrRefId) {
		this.ndrRefId = ndrRefId;
	}
	
	/**
	 * Column Info
	 * @param tsRefNo
	 */
	public void setTsRefNo(String tsRefNo) {
		this.tsRefNo = tsRefNo;
	}
	
	/**
	 * Column Info
	 * @param aesPtuDt
	 */
	public void setAesPtuDt(String aesPtuDt) {
		this.aesPtuDt = aesPtuDt;
	}
	
	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
	}
	
	/**
	 * Column Info
	 * @param aesExptCtnt
	 */
	public void setAesExptCtnt(String aesExptCtnt) {
		this.aesExptCtnt = aesExptCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesExptId
	 */
	public void setAesExptId(String aesExptId) {
		this.aesExptId = aesExptId;
	}
	
	/**
	 * Column Info
	 * @param samPckId
	 */
	public void setSamPckId(String samPckId) {
		this.samPckId = samPckId;
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
	 * @param divdPckQty
	 */
	public void setDivdPckQty(String divdPckQty) {
		this.divdPckQty = divdPckQty;
	}
	
	/**
	 * Column Info
	 * @param samPckTpCd
	 */
	public void setSamPckTpCd(String samPckTpCd) {
		this.samPckTpCd = samPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param aesPtuPfxCtnt
	 */
	public void setAesPtuPfxCtnt(String aesPtuPfxCtnt) {
		this.aesPtuPfxCtnt = aesPtuPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesInlndTrnsPfxCtnt
	 */
	public void setAesInlndTrnsPfxCtnt(String aesInlndTrnsPfxCtnt) {
		this.aesInlndTrnsPfxCtnt = aesInlndTrnsPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param cgoCtrlPfxCtnt
	 */
	public void setCgoCtrlPfxCtnt(String cgoCtrlPfxCtnt) {
		this.cgoCtrlPfxCtnt = cgoCtrlPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param ndrRefCtnt
	 */
	public void setNdrRefCtnt(String ndrRefCtnt) {
		this.ndrRefCtnt = ndrRefCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesPtaDt
	 */
	public void setAesPtaDt(String aesPtaDt) {
		this.aesPtaDt = aesPtaDt;
	}
	
	/**
	 * Column Info
	 * @param aesDwnDt
	 */
	public void setAesDwnDt(String aesDwnDt) {
		this.aesDwnDt = aesDwnDt;
	}
	
	/**
	 * Column Info
	 * @param g7EdiPfxCtnt
	 */
	public void setG7EdiPfxCtnt(String g7EdiPfxCtnt) {
		this.g7EdiPfxCtnt = g7EdiPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesPtaPfxCtnt
	 */
	public void setAesPtaPfxCtnt(String aesPtaPfxCtnt) {
		this.aesPtaPfxCtnt = aesPtaPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param mfSmryRptNo
	 */
	public void setMfSmryRptNo(String mfSmryRptNo) {
		this.mfSmryRptNo = mfSmryRptNo;
	}
	
	/**
	 * Column Info
	 * @param mxNtfyTaxId
	 */
	public void setMxNtfyTaxId(String mxNtfyTaxId) {
		this.mxNtfyTaxId = mxNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @param aesTpCd
	 */
	public void setAesTpCd(String aesTpCd) {
		this.aesTpCd = aesTpCd;
	}
	
	/**
	 * Column Info
	 * @param divdPckTpCd
	 */
	public void setDivdPckTpCd(String divdPckTpCd) {
		this.divdPckTpCd = divdPckTpCd;
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
	 * @param aesPtuNo
	 */
	public void setAesPtuNo(String aesPtuNo) {
		this.aesPtuNo = aesPtuNo;
	}
	
	/**
	 * Column Info
	 * @param divdWgt
	 */
	public void setDivdWgt(String divdWgt) {
		this.divdWgt = divdWgt;
	}
	
	/**
	 * Column Info
	 * @param divdWgtUtCd
	 */
	public void setDivdWgtUtCd(String divdWgtUtCd) {
		this.divdWgtUtCd = divdWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param ndrRefPfxCtnt
	 */
	public void setNdrRefPfxCtnt(String ndrRefPfxCtnt) {
		this.ndrRefPfxCtnt = ndrRefPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param mxCneeTaxId
	 */
	public void setMxCneeTaxId(String mxCneeTaxId) {
		this.mxCneeTaxId = mxCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @param b13aXptPfxCtnt
	 */
	public void setB13aXptPfxCtnt(String b13aXptPfxCtnt) {
		this.b13aXptPfxCtnt = b13aXptPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesPtaNo1
	 */
	public void setAesPtaNo1(String aesPtaNo1) {
		this.aesPtaNo1 = aesPtaNo1;
	}
	
	/**
	 * Column Info
	 * @param aesPtaNo2
	 */
	public void setAesPtaNo2(String aesPtaNo2) {
		this.aesPtaNo2 = aesPtaNo2;
	}
	
	/**
	 * Column Info
	 * @param aesDwnPfxCtnt
	 */
	public void setAesDwnPfxCtnt(String aesDwnPfxCtnt) {
		this.aesDwnPfxCtnt = aesDwnPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param xptImpSeq
	 */
	public void setXptImpSeq(String xptImpSeq) {
		this.xptImpSeq = xptImpSeq;
	}
	
	/**
	 * Column Info
	 * @param samPckQty
	 */
	public void setSamPckQty(String samPckQty) {
		this.samPckQty = samPckQty;
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
	 * @param g7EdiCtnt
	 */
	public void setG7EdiCtnt(String g7EdiCtnt) {
		this.g7EdiCtnt = g7EdiCtnt;
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
	 * @param caedTpCd
	 */
	public void setCaedTpCd(String caedTpCd) {
		this.caedTpCd = caedTpCd;
	}
	
	/**
	 * Column Info
	 * @param divdSeq
	 */
	public void setDivdSeq(String divdSeq) {
		this.divdSeq = divdSeq;
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
	 * @param mfSmryRptPfxCtnt
	 */
	public void setMfSmryRptPfxCtnt(String mfSmryRptPfxCtnt) {
		this.mfSmryRptPfxCtnt = mfSmryRptPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesDwnNo
	 */
	public void setAesDwnNo(String aesDwnNo) {
		this.aesDwnNo = aesDwnNo;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param mfWgt
	 */
	public void setMfWgt(String mfWgt) {
		this.mfWgt = mfWgt;
	}
	
	/**
	 * Column Info
	 * @param caedPfxCtnt
	 */
	public void setCaedPfxCtnt(String caedPfxCtnt) {
		this.caedPfxCtnt = caedPfxCtnt;
	}
	
	/**
	 * Column Info
	 * @param caedCtnt
	 */
	public void setCaedCtnt(String caedCtnt) {
		this.caedCtnt = caedCtnt;
	}
	
	/**
	 * Column Info
	 * @param divdFlg
	 */
	public void setDivdFlg(String divdFlg) {
		this.divdFlg = divdFlg;
	}
	
	/**
	 * Column Info
	 * @param mxShprTaxId
	 */
	public void setMxShprTaxId(String mxShprTaxId) {
		this.mxShprTaxId = mxShprTaxId;
	}
	
	/**
	 * Column Info
	 * @param cgoCtrlNo
	 */
	public void setCgoCtrlNo(String cgoCtrlNo) {
		this.cgoCtrlNo = cgoCtrlNo;
	}
	
	/**
	 * Column Info
	 * @param b13aXptCtnt
	 */
	public void setB13aXptCtnt(String b13aXptCtnt) {
		this.b13aXptCtnt = b13aXptCtnt;
	}
	
	/**
	 * Column Info
	 * @param aesInlndTrnsNo
	 */
	public void setAesInlndTrnsNo(String aesInlndTrnsNo) {
		this.aesInlndTrnsNo = aesInlndTrnsNo;
	}
	
	/**
	 * Colum Info
	 * @param trShprTaxId
	 */
	public void setTrShprTaxId(String trShprTaxId) {
		this.trShprTaxId = trShprTaxId;
	}

	/**
	 * Colum Info
	 * @param trCneeTaxId
	 */
	public void setTrCneeTaxId(String trCneeTaxId) {
		this.trCneeTaxId = trCneeTaxId;
	}

	/**
	 * Colum Info
	 * @param trNtfyTaxId
	 */
	public void setTrNtfyTaxId(String trNtfyTaxId) {
		this.trNtfyTaxId = trNtfyTaxId;
	}

	/**
	 * Colum Info
	 * @param ilShprTaxId
	 */
	public void setIlShprTaxId(String ilShprTaxId) {
		this.ilShprTaxId = ilShprTaxId;
	}

	/**
	 * Colum Info
	 * @param ilCneeTaxId
	 */
	public void setIlCneeTaxId(String ilCneeTaxId) {
		this.ilCneeTaxId = ilCneeTaxId;
	}

	/**
	 * Colum Info
	 * @param ilNtfyTaxId
	 */
	public void setIlNtfyTaxId(String ilNtfyTaxId) {
		this.ilNtfyTaxId = ilNtfyTaxId;
	}

	/**
	 * Colum Info
	 * @param lbShprTaxId
	 */
	public void setLbShprTaxId(String lbShprTaxId) {
		this.lbShprTaxId = lbShprTaxId;
	}

	/**
	 * Colum Info
	 * @param lbCneeTaxId
	 */
	public void setLbCneeTaxId(String lbCneeTaxId) {
		this.lbCneeTaxId = lbCneeTaxId;
	}

	/**
	 * Colum Info
	 * @param lbNtfyTaxId
	 */
	public void setLbNtfyTaxId(String lbNtfyTaxId) {
		this.lbNtfyTaxId = lbNtfyTaxId;
	}

	/**
	 * Colum Info
	 * @param brShprTaxId
	 */
	public void setBrShprTaxId(String brShprTaxId) {
		this.brShprTaxId = brShprTaxId;
	}

	/**
	 * Colum Info
	 * @param brCneeTaxId
	 */
	public void setBrCneeTaxId(String brCneeTaxId) {
		this.brCneeTaxId = brCneeTaxId;
	}

	/**
	 * Colum Info
	 * @param brNtfyTaxId
	 */
	public void setBrNtfyTaxId(String brNtfyTaxId) {
		this.brNtfyTaxId = brNtfyTaxId;
	}

	/**
	 * Colum Info
	 * @param shprTaxCpyDescFlg
	 */
	public void setShprTaxCpyDescFlg(String shprTaxCpyDescFlg) {
		this.shprTaxCpyDescFlg = shprTaxCpyDescFlg;
	}

	/**
	 * Colum Info
	 * @param ntfyTaxCpyDescFlg
	 */
	public void setNtfyTaxCpyDescFlg(String ntfyTaxCpyDescFlg) {
		this.ntfyTaxCpyDescFlg = ntfyTaxCpyDescFlg;
	}

	/**
	 * Colum Info
	 * @param cneeTaxCpyDescFlg
	 */
	public void setCneeTaxCpyDescFlg(String cneeTaxCpyDescFlg) {
		this.cneeTaxCpyDescFlg = cneeTaxCpyDescFlg;
	}

	/**
	 * Colum Info
	 * @param brzDeclNo
	 */
	public void setBrzDeclNo(String brzDeclNo) {
		this.brzDeclNo = brzDeclNo;
	}

	/**
	 * Colum Info
	 * @param brzDeclCpyDescFlg
	 */
	public void setBrzDeclCpyDescFlg(String brzDeclCpyDescFlg) {
		this.brzDeclCpyDescFlg = brzDeclCpyDescFlg;
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
		setNdrRefId(JSPUtil.getParameter(request, prefix + "ndr_ref_id", ""));
		setTsRefNo(JSPUtil.getParameter(request, prefix + "ts_ref_no", ""));
		setAesPtuDt(JSPUtil.getParameter(request, prefix + "aes_ptu_dt", ""));
		setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
		setAesExptCtnt(JSPUtil.getParameter(request, prefix + "aes_expt_ctnt", ""));
		setAesExptId(JSPUtil.getParameter(request, prefix + "aes_expt_id", ""));
		setSamPckId(JSPUtil.getParameter(request, prefix + "sam_pck_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDivdPckQty(JSPUtil.getParameter(request, prefix + "divd_pck_qty", ""));
		setSamPckTpCd(JSPUtil.getParameter(request, prefix + "sam_pck_tp_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setAesPtuPfxCtnt(JSPUtil.getParameter(request, prefix + "aes_ptu_pfx_ctnt", ""));
		setAesInlndTrnsPfxCtnt(JSPUtil.getParameter(request, prefix + "aes_inlnd_trns_pfx_ctnt", ""));
		setCgoCtrlPfxCtnt(JSPUtil.getParameter(request, prefix + "cgo_ctrl_pfx_ctnt", ""));
		setNdrRefCtnt(JSPUtil.getParameter(request, prefix + "ndr_ref_ctnt", ""));
		setAesPtaDt(JSPUtil.getParameter(request, prefix + "aes_pta_dt", ""));
		setAesDwnDt(JSPUtil.getParameter(request, prefix + "aes_dwn_dt", ""));
		setG7EdiPfxCtnt(JSPUtil.getParameter(request, prefix + "g7_edi_pfx_ctnt", ""));
		setAesPtaPfxCtnt(JSPUtil.getParameter(request, prefix + "aes_pta_pfx_ctnt", ""));
		setMfSmryRptNo(JSPUtil.getParameter(request, prefix + "mf_smry_rpt_no", ""));
		setMxNtfyTaxId(JSPUtil.getParameter(request, prefix + "mx_ntfy_tax_id", ""));
		setAesTpCd(JSPUtil.getParameter(request, prefix + "aes_tp_cd", ""));
		setDivdPckTpCd(JSPUtil.getParameter(request, prefix + "divd_pck_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAesPtuNo(JSPUtil.getParameter(request, prefix + "aes_ptu_no", ""));
		setDivdWgt(JSPUtil.getParameter(request, prefix + "divd_wgt", ""));
		setDivdWgtUtCd(JSPUtil.getParameter(request, prefix + "divd_wgt_ut_cd", ""));
		setNdrRefPfxCtnt(JSPUtil.getParameter(request, prefix + "ndr_ref_pfx_ctnt", ""));
		setMxCneeTaxId(JSPUtil.getParameter(request, prefix + "mx_cnee_tax_id", ""));
		setB13aXptPfxCtnt(JSPUtil.getParameter(request, prefix + "b13a_xpt_pfx_ctnt", ""));
		setAesPtaNo1(JSPUtil.getParameter(request, prefix + "aes_pta_no1", ""));
		setAesPtaNo2(JSPUtil.getParameter(request, prefix + "aes_pta_no2", ""));
		setAesDwnPfxCtnt(JSPUtil.getParameter(request, prefix + "aes_dwn_pfx_ctnt", ""));
		setXptImpSeq(JSPUtil.getParameter(request, prefix + "xpt_imp_seq", ""));
		setSamPckQty(JSPUtil.getParameter(request, prefix + "sam_pck_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setG7EdiCtnt(JSPUtil.getParameter(request, prefix + "g7_edi_ctnt", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCaedTpCd(JSPUtil.getParameter(request, prefix + "caed_tp_cd", ""));
		setDivdSeq(JSPUtil.getParameter(request, prefix + "divd_seq", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMfSmryRptPfxCtnt(JSPUtil.getParameter(request, prefix + "mf_smry_rpt_pfx_ctnt", ""));
		setAesDwnNo(JSPUtil.getParameter(request, prefix + "aes_dwn_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setMfWgt(JSPUtil.getParameter(request, prefix + "mf_wgt", ""));
		setCaedPfxCtnt(JSPUtil.getParameter(request, prefix + "caed_pfx_ctnt", ""));
		setCaedCtnt(JSPUtil.getParameter(request, prefix + "caed_ctnt", ""));
		setDivdFlg(JSPUtil.getParameter(request, prefix + "divd_flg", ""));
		setMxShprTaxId(JSPUtil.getParameter(request, prefix + "mx_shpr_tax_id", ""));
		setCgoCtrlNo(JSPUtil.getParameter(request, prefix + "cgo_ctrl_no", ""));
		setB13aXptCtnt(JSPUtil.getParameter(request, prefix + "b13a_xpt_ctnt", ""));
		setAesInlndTrnsNo(JSPUtil.getParameter(request, prefix + "aes_inlnd_trns_no", ""));
		setTrShprTaxId(JSPUtil.getParameter(request, prefix + "tr_shpr_tax_id", ""));
		setTrCneeTaxId(JSPUtil.getParameter(request, prefix + "tr_cnee_tax_id", ""));
		setTrNtfyTaxId(JSPUtil.getParameter(request, prefix + "tr_ntfy_tax_id", ""));
		setIlShprTaxId(JSPUtil.getParameter(request, prefix + "il_shpr_tax_id", ""));
		setIlCneeTaxId(JSPUtil.getParameter(request, prefix + "il_cnee_tax_id", ""));
		setIlNtfyTaxId(JSPUtil.getParameter(request, prefix + "il_ntfy_tax_id", ""));
		setLbShprTaxId(JSPUtil.getParameter(request, prefix + "lb_shpr_tax_id", ""));
		setLbCneeTaxId(JSPUtil.getParameter(request, prefix + "lb_cnee_tax_id", ""));
		setLbNtfyTaxId(JSPUtil.getParameter(request, prefix + "lb_ntfy_tax_id", ""));
		setBrShprTaxId(JSPUtil.getParameter(request, prefix + "br_shpr_tax_id", ""));
		setBrCneeTaxId(JSPUtil.getParameter(request, prefix + "br_cnee_tax_id", ""));
		setBrNtfyTaxId(JSPUtil.getParameter(request, prefix + "br_ntfy_tax_id", ""));
		setShprTaxCpyDescFlg(JSPUtil.getParameter(request, prefix + "shpr_tax_cpy_desc_flg", ""));
		setNtfyTaxCpyDescFlg(JSPUtil.getParameter(request, prefix + "ntfy_tax_cpy_desc_flg", ""));
		setCneeTaxCpyDescFlg(JSPUtil.getParameter(request, prefix + "cnee_tax_cpy_desc_flg", ""));
		setBrzDeclCpyDescFlg(JSPUtil.getParameter(request, prefix + "brz_decl_cpy_desc_flg", ""));
		setBrzDeclNo(JSPUtil.getParameter(request, prefix + "brz_decl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusXptImpLicListVO[]
	 */
	public OpusXptImpLicListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusXptImpLicListVO[]
	 */
	public OpusXptImpLicListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpusXptImpLicListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ndrRefId = (JSPUtil.getParameter(request, prefix	+ "ndr_ref_id", length));
			String[] tsRefNo = (JSPUtil.getParameter(request, prefix	+ "ts_ref_no", length));
			String[] aesPtuDt = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_dt", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] aesExptCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_expt_ctnt", length));
			String[] aesExptId = (JSPUtil.getParameter(request, prefix	+ "aes_expt_id", length));
			String[] samPckId = (JSPUtil.getParameter(request, prefix	+ "sam_pck_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divdPckQty = (JSPUtil.getParameter(request, prefix	+ "divd_pck_qty", length));
			String[] samPckTpCd = (JSPUtil.getParameter(request, prefix	+ "sam_pck_tp_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] aesPtuPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_pfx_ctnt", length));
			String[] aesInlndTrnsPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_inlnd_trns_pfx_ctnt", length));
			String[] cgoCtrlPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "cgo_ctrl_pfx_ctnt", length));
			String[] ndrRefCtnt = (JSPUtil.getParameter(request, prefix	+ "ndr_ref_ctnt", length));
			String[] aesPtaDt = (JSPUtil.getParameter(request, prefix	+ "aes_pta_dt", length));
			String[] aesDwnDt = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_dt", length));
			String[] g7EdiPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "g7_edi_pfx_ctnt", length));
			String[] aesPtaPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_pta_pfx_ctnt", length));
			String[] mfSmryRptNo = (JSPUtil.getParameter(request, prefix	+ "mf_smry_rpt_no", length));
			String[] mxNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "mx_ntfy_tax_id", length));
			String[] aesTpCd = (JSPUtil.getParameter(request, prefix	+ "aes_tp_cd", length));
			String[] divdPckTpCd = (JSPUtil.getParameter(request, prefix	+ "divd_pck_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] aesPtuNo = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_no", length));
			String[] divdWgt = (JSPUtil.getParameter(request, prefix	+ "divd_wgt", length));
			String[] divdWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_wgt_ut_cd", length));
			String[] ndrRefPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "ndr_ref_pfx_ctnt", length));
			String[] mxCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "mx_cnee_tax_id", length));
			String[] b13aXptPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "b13a_xpt_pfx_ctnt", length));
			String[] aesPtaNo1 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_no1", length));
			String[] aesPtaNo2 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_no2", length));
			String[] aesDwnPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_pfx_ctnt", length));
			String[] xptImpSeq = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_seq", length));
			String[] samPckQty = (JSPUtil.getParameter(request, prefix	+ "sam_pck_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] g7EdiCtnt = (JSPUtil.getParameter(request, prefix	+ "g7_edi_ctnt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] caedTpCd = (JSPUtil.getParameter(request, prefix	+ "caed_tp_cd", length));
			String[] divdSeq = (JSPUtil.getParameter(request, prefix	+ "divd_seq", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] mfSmryRptPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "mf_smry_rpt_pfx_ctnt", length));
			String[] aesDwnNo = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] mfWgt = (JSPUtil.getParameter(request, prefix	+ "mf_wgt", length));
			String[] caedPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "caed_pfx_ctnt", length));
			String[] caedCtnt = (JSPUtil.getParameter(request, prefix	+ "caed_ctnt", length));
			String[] divdFlg = (JSPUtil.getParameter(request, prefix	+ "divd_flg", length));
			String[] mxShprTaxId = (JSPUtil.getParameter(request, prefix	+ "mx_shpr_tax_id", length));
			String[] cgoCtrlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_ctrl_no", length));
			String[] b13aXptCtnt = (JSPUtil.getParameter(request, prefix	+ "b13a_xpt_ctnt", length));
			String[] aesInlndTrnsNo = (JSPUtil.getParameter(request, prefix	+ "aes_inlnd_trns_no", length));
			String[] trShprTaxId = (JSPUtil.getParameter(request, prefix	+ "tr_shpr_tax_id", length));
			String[] trCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "tr_cnee_tax_id", length));
			String[] trNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "tr_ntfy_tax_id", length));
			String[] ilShprTaxId = (JSPUtil.getParameter(request, prefix	+ "il_shpr_tax_id", length));
			String[] ilCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "il_cnee_tax_id", length));
			String[] ilNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "il_ntfy_tax_id", length));
			String[] lbShprTaxId = (JSPUtil.getParameter(request, prefix	+ "lb_shpr_tax_id", length));
			String[] lbCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "lb_cnee_tax_id", length));
			String[] lbNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "lb_ntfy_tax_id", length));
			String[] brShprTaxId = (JSPUtil.getParameter(request, prefix	+ "br_shpr_tax_id", length));
			String[] brCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "br_cnee_tax_id", length));
			String[] brNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "br_ntfy_tax_id", length));
			String[] shprTaxCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_cpy_desc_flg", length));
			String[] ntfyTaxCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_cpy_desc_flg", length));
			String[] cneeTaxCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_cpy_desc_flg", length));
			String[] brzDeclCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "brz_decl_cpy_desc_flg", length));
			String[] brzDeclNo = (JSPUtil.getParameter(request, prefix	+ "brz_decl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpusXptImpLicListVO();
				if (ndrRefId[i] != null)
					model.setNdrRefId(ndrRefId[i]);
				if (tsRefNo[i] != null)
					model.setTsRefNo(tsRefNo[i]);
				if (aesPtuDt[i] != null)
					model.setAesPtuDt(aesPtuDt[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (aesExptCtnt[i] != null)
					model.setAesExptCtnt(aesExptCtnt[i]);
				if (aesExptId[i] != null)
					model.setAesExptId(aesExptId[i]);
				if (samPckId[i] != null)
					model.setSamPckId(samPckId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divdPckQty[i] != null)
					model.setDivdPckQty(divdPckQty[i]);
				if (samPckTpCd[i] != null)
					model.setSamPckTpCd(samPckTpCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (aesPtuPfxCtnt[i] != null)
					model.setAesPtuPfxCtnt(aesPtuPfxCtnt[i]);
				if (aesInlndTrnsPfxCtnt[i] != null)
					model.setAesInlndTrnsPfxCtnt(aesInlndTrnsPfxCtnt[i]);
				if (cgoCtrlPfxCtnt[i] != null)
					model.setCgoCtrlPfxCtnt(cgoCtrlPfxCtnt[i]);
				if (ndrRefCtnt[i] != null)
					model.setNdrRefCtnt(ndrRefCtnt[i]);
				if (aesPtaDt[i] != null)
					model.setAesPtaDt(aesPtaDt[i]);
				if (aesDwnDt[i] != null)
					model.setAesDwnDt(aesDwnDt[i]);
				if (g7EdiPfxCtnt[i] != null)
					model.setG7EdiPfxCtnt(g7EdiPfxCtnt[i]);
				if (aesPtaPfxCtnt[i] != null)
					model.setAesPtaPfxCtnt(aesPtaPfxCtnt[i]);
				if (mfSmryRptNo[i] != null)
					model.setMfSmryRptNo(mfSmryRptNo[i]);
				if (mxNtfyTaxId[i] != null)
					model.setMxNtfyTaxId(mxNtfyTaxId[i]);
				if (aesTpCd[i] != null)
					model.setAesTpCd(aesTpCd[i]);
				if (divdPckTpCd[i] != null)
					model.setDivdPckTpCd(divdPckTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (aesPtuNo[i] != null)
					model.setAesPtuNo(aesPtuNo[i]);
				if (divdWgt[i] != null)
					model.setDivdWgt(divdWgt[i]);
				if (divdWgtUtCd[i] != null)
					model.setDivdWgtUtCd(divdWgtUtCd[i]);
				if (ndrRefPfxCtnt[i] != null)
					model.setNdrRefPfxCtnt(ndrRefPfxCtnt[i]);
				if (mxCneeTaxId[i] != null)
					model.setMxCneeTaxId(mxCneeTaxId[i]);
				if (b13aXptPfxCtnt[i] != null)
					model.setB13aXptPfxCtnt(b13aXptPfxCtnt[i]);
				if (aesPtaNo1[i] != null)
					model.setAesPtaNo1(aesPtaNo1[i]);
				if (aesPtaNo2[i] != null)
					model.setAesPtaNo2(aesPtaNo2[i]);
				if (aesDwnPfxCtnt[i] != null)
					model.setAesDwnPfxCtnt(aesDwnPfxCtnt[i]);
				if (xptImpSeq[i] != null)
					model.setXptImpSeq(xptImpSeq[i]);
				if (samPckQty[i] != null)
					model.setSamPckQty(samPckQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (g7EdiCtnt[i] != null)
					model.setG7EdiCtnt(g7EdiCtnt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (caedTpCd[i] != null)
					model.setCaedTpCd(caedTpCd[i]);
				if (divdSeq[i] != null)
					model.setDivdSeq(divdSeq[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (mfSmryRptPfxCtnt[i] != null)
					model.setMfSmryRptPfxCtnt(mfSmryRptPfxCtnt[i]);
				if (aesDwnNo[i] != null)
					model.setAesDwnNo(aesDwnNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mfWgt[i] != null)
					model.setMfWgt(mfWgt[i]);
				if (caedPfxCtnt[i] != null)
					model.setCaedPfxCtnt(caedPfxCtnt[i]);
				if (caedCtnt[i] != null)
					model.setCaedCtnt(caedCtnt[i]);
				if (divdFlg[i] != null)
					model.setDivdFlg(divdFlg[i]);
				if (mxShprTaxId[i] != null)
					model.setMxShprTaxId(mxShprTaxId[i]);
				if (cgoCtrlNo[i] != null)
					model.setCgoCtrlNo(cgoCtrlNo[i]);
				if (b13aXptCtnt[i] != null)
					model.setB13aXptCtnt(b13aXptCtnt[i]);
				if (aesInlndTrnsNo[i] != null)
					model.setAesInlndTrnsNo(aesInlndTrnsNo[i]);
				if (trShprTaxId[i] != null)					
					model.setTrShprTaxId(trShprTaxId[i]);
				if (trCneeTaxId[i] != null)					
					model.setTrCneeTaxId(trCneeTaxId[i]);
				if (trNtfyTaxId[i] != null)					
					model.setTrNtfyTaxId(trNtfyTaxId[i]);
				if (ilShprTaxId[i] != null)					
					model.setIlShprTaxId(ilShprTaxId[i]);
				if (ilCneeTaxId[i] != null)					
					model.setIlCneeTaxId(ilCneeTaxId[i]);
				if (ilNtfyTaxId[i] != null)					
					model.setIlNtfyTaxId(ilNtfyTaxId[i]);
				if (lbShprTaxId[i] != null)					
					model.setLbShprTaxId(lbShprTaxId[i]);
				if (lbCneeTaxId[i] != null)					
					model.setLbCneeTaxId(lbCneeTaxId[i]);
				if (lbNtfyTaxId[i] != null)					
					model.setLbNtfyTaxId(lbNtfyTaxId[i]);
				if (brShprTaxId[i] != null)					
					model.setBrShprTaxId(brShprTaxId[i]);
				if (brCneeTaxId[i] != null)					
					model.setBrCneeTaxId(brCneeTaxId[i]);
				if (brNtfyTaxId[i] != null)					
					model.setBrNtfyTaxId(brNtfyTaxId[i]);
				if (shprTaxCpyDescFlg[i] != null)			
					model.setShprTaxCpyDescFlg(shprTaxCpyDescFlg[i]);
				if (ntfyTaxCpyDescFlg[i] != null)			
					model.setNtfyTaxCpyDescFlg(ntfyTaxCpyDescFlg[i]);
				if (cneeTaxCpyDescFlg[i] != null)			
					model.setCneeTaxCpyDescFlg(cneeTaxCpyDescFlg[i]);
				if (brzDeclCpyDescFlg[i] != null)			
					model.setBrzDeclCpyDescFlg(brzDeclCpyDescFlg[i]);
				if (brzDeclNo[i] != null)					
					model.setBrzDeclNo(brzDeclNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpusXptImpLicListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpusXptImpLicListVO[]
	 */
	public OpusXptImpLicListVO[] getOpusXptImpLicListVOs(){
		OpusXptImpLicListVO[] vos = (OpusXptImpLicListVO[])models.toArray(new OpusXptImpLicListVO[models.size()]);
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
		this.ndrRefId = this.ndrRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRefNo = this.tsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuDt = this.aesPtuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesExptCtnt = this.aesExptCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesExptId = this.aesExptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckId = this.samPckId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckQty = this.divdPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckTpCd = this.samPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuPfxCtnt = this.aesPtuPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesInlndTrnsPfxCtnt = this.aesInlndTrnsPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCtrlPfxCtnt = this.cgoCtrlPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndrRefCtnt = this.ndrRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaDt = this.aesPtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnDt = this.aesDwnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g7EdiPfxCtnt = this.g7EdiPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaPfxCtnt = this.aesPtaPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSmryRptNo = this.mfSmryRptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mxNtfyTaxId = this.mxNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesTpCd = this.aesTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckTpCd = this.divdPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuNo = this.aesPtuNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgt = this.divdWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgtUtCd = this.divdWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndrRefPfxCtnt = this.ndrRefPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mxCneeTaxId = this.mxCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aXptPfxCtnt = this.b13aXptPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaNo1 = this.aesPtaNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaNo2 = this.aesPtaNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnPfxCtnt = this.aesDwnPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpSeq = this.xptImpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckQty = this.samPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g7EdiCtnt = this.g7EdiCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedTpCd = this.caedTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdSeq = this.divdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSmryRptPfxCtnt = this.mfSmryRptPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnNo = this.aesDwnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfWgt = this.mfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedPfxCtnt = this.caedPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedCtnt = this.caedCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdFlg = this.divdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mxShprTaxId = this.mxShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCtrlNo = this.cgoCtrlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aXptCtnt = this.b13aXptCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesInlndTrnsNo = this.aesInlndTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trShprTaxId = this.trShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trCneeTaxId = this.trCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trNtfyTaxId = this.trNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilShprTaxId = this.ilShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilCneeTaxId = this.ilCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilNtfyTaxId = this.ilNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbShprTaxId = this.lbShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbCneeTaxId = this.lbCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbNtfyTaxId = this.lbNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brShprTaxId = this.brShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCneeTaxId = this.brCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brNtfyTaxId = this.brNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxCpyDescFlg = this.shprTaxCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxCpyDescFlg = this.ntfyTaxCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxCpyDescFlg = this.cneeTaxCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclCpyDescFlg = this.brzDeclCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclNo = this.brzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
