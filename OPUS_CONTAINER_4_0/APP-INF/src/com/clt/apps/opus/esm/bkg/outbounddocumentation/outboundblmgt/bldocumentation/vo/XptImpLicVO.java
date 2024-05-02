/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XptImpLicVO.java
*@FileTitle : XptImpLicVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.06.18 최도순
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XptImpLicVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<XptImpLicVO> models = new ArrayList<XptImpLicVO>();

	/* Column Info */
	private String ndrRefId = null;
	/* Column Info */
	private String tsRefNo = null;
	/* Column Info */
	private String idaIecNo = null;
	/* Column Info */
	private String aesPtuDt = null;
	/* Column Info */
	private String shprTaxNo = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String aesExptCtnt = null;
	/* Column Info */
	private String aesExptId = null;
	/* Column Info */
	private String samPckId = null;
	/* Column Info */
	private String ausMfRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divdPckQty = null;
	/* Column Info */
	private String b13aXptDt = null;
	/* Column Info */
	private String caedNo1 = null;
	/* Column Info */
	private String samPckTpCd = null;
	/* Column Info */
	private String caedNo3 = null;
	/* Column Info */
	private String caedNo2 = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String aesPtuPfxCtnt = null;
	/* Column Info */
	private String b13aXptNo2 = null;
	/* Column Info */
	private String aesInlndTrnsPfxCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cgoCtrlPfxCtnt = null;
	/* Column Info */
	private String b13aXptNo1 = null;
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
	private String cneeTaxNo = null;
	/* Column Info */
	private String mfSmryRptNo = null;
	/* Column Info */
	private String cneeTaxCpyDescFlg = null;
	/* Column Info */
	private String aesTpCd = null;
	/* Column Info */
	private String divdPckTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shprTaxCpyDescFlg = null;
	/* Column Info */
	private String aesPtuNo = null;
	/* Column Info */
	private String divdWgt = null;
	/* Column Info */
	private String ntfyTaxNo = null;
	/* Column Info */
	private String divdWgtUtCd = null;
	/* Column Info */
	private String ndrRefPfxCtnt = null;
	/* Column Info */
	private String g7EdiNo2 = null;
	/* Column Info */
	private String b13aXptPfxCtnt = null;
	/* Column Info */
	private String g7EdiNo1 = null;
	/* Column Info */
	private String aesPtaNo1 = null;
	/* Column Info */
	private String aesPtaNo2 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aesDwnPfxCtnt = null;
	/* Column Info */
	private String xptImpSeq = null;
	/* Column Info */
	private String samPckQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String idXptNo = null;
	/* Column Info */
	private String idaIecCpyDescFlg = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String caedTpCd = null;
	/* Column Info */
	private String ntfyTaxCpyDescFlg = null;
	/* Column Info */
	private String divdSeq = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String mfSmryRptPfxCtnt = null;
	/* Column Info */
	private String brzDeclCpyDescFlg = null;
	/* Column Info */
	private String idDeclCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String brzCmdtCd = null;
	/* Column Info */
	private String idXptNoIssDt = null;
	/* Column Info */
	private String aesDwnNo = null;
	/* Column Info */
	private String brzDeclNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mfWgt = null;
	/* Column Info */
	private String idOfcCd = null;
	/* Column Info */
	private String caedPfxCtnt = null;
	/* Column Info */
	private String ucrNo = null;
	/* Column Info */
	private String divdFlg = null;
	/* Column Info */
	private String cgoCtrlNo = null;
	/* Column Info */
	private String aesInlndTrnsNo = null;
	/* Column Info */
	private String mxShprTaxId = null;	
	/* Column Info */
	private String mxCneeTaxId = null;	
	/* Column Info */
	private String mxNtfyTaxId = null;
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
	private String entrClssTpCd = null;	
	/* Column Info */
	private String entrClssRmk = null;	
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String aesTpPrnFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public XptImpLicVO() {}

	public XptImpLicVO(String ibflag, String pagerows, String bkgNo, String ioBndCd, String xptImpSeq, String cntCd, String xptLicNo, String tsRefNo, String pckQty, String pckTpCd, String mfWgt, String wgtUtCd, String divdFlg, String divdSeq, String divdPckQty, String divdPckTpCd, String divdWgt, String divdWgtUtCd, String samPckId, String samPckQty, String samPckTpCd, String ucrNo, String ausMfRefNo, String aesTpCd, String aesInlndTrnsPfxCtnt, String aesInlndTrnsNo, String aesPtaPfxCtnt, String aesPtaNo1, String aesPtaNo2, String aesPtaDt, String aesPtuPfxCtnt, String aesPtuNo, String aesPtuDt, String aesDwnPfxCtnt, String aesDwnNo, String aesDwnDt, String aesExptId, String aesExptCtnt, String shprTaxNo, String shprTaxCpyDescFlg, String cneeTaxNo, String cneeTaxCpyDescFlg, String ntfyTaxNo, String ntfyTaxCpyDescFlg, String brzDeclNo, String brzDeclCpyDescFlg, String brzCmdtCd, String idDeclCd, String idXptNo, String idXptNoIssDt, String idOfcCd, String idaIecNo, String idaIecCpyDescFlg, String caedTpCd, String caedPfxCtnt, String caedNo1, String caedNo2, String caedNo3, String g7EdiPfxCtnt, String g7EdiNo1, String g7EdiNo2, String b13aXptPfxCtnt, String b13aXptDt, String b13aXptNo1, String b13aXptNo2, String mfSmryRptPfxCtnt, String mfSmryRptNo, String cgoCtrlPfxCtnt, String cgoCtrlNo, String ndrRefPfxCtnt, String ndrRefId, String ndrRefCtnt, String creUsrId, String creDt, String updUsrId, String updDt,String seq, String mxShprTaxId, String mxCneeTaxId, String mxNtfyTaxId, String trShprTaxId, String trCneeTaxId, String trNtfyTaxId, String ilShprTaxId, String ilCneeTaxId, String ilNtfyTaxId, String lbShprTaxId, String lbCneeTaxId, String lbNtfyTaxId, String entrClssTpCd, String entrClssRmk, String porCd, String aesTpPrnFlg ) {
		this.ndrRefId = ndrRefId;
		this.tsRefNo = tsRefNo;
		this.idaIecNo = idaIecNo;
		this.aesPtuDt = aesPtuDt;
		this.shprTaxNo = shprTaxNo;
		this.xptLicNo = xptLicNo;
		this.aesExptCtnt = aesExptCtnt;
		this.aesExptId = aesExptId;
		this.samPckId = samPckId;
		this.ausMfRefNo = ausMfRefNo;
		this.pagerows = pagerows;
		this.divdPckQty = divdPckQty;
		this.b13aXptDt = b13aXptDt;
		this.caedNo1 = caedNo1;
		this.samPckTpCd = samPckTpCd;
		this.caedNo3 = caedNo3;
		this.caedNo2 = caedNo2;
		this.cntCd = cntCd;
		this.wgtUtCd = wgtUtCd;
		this.aesPtuPfxCtnt = aesPtuPfxCtnt;
		this.b13aXptNo2 = b13aXptNo2;
		this.aesInlndTrnsPfxCtnt = aesInlndTrnsPfxCtnt;
		this.updUsrId = updUsrId;
		this.cgoCtrlPfxCtnt = cgoCtrlPfxCtnt;
		this.b13aXptNo1 = b13aXptNo1;
		this.ndrRefCtnt = ndrRefCtnt;
		this.aesPtaDt = aesPtaDt;
		this.aesDwnDt = aesDwnDt;
		this.g7EdiPfxCtnt = g7EdiPfxCtnt;
		this.aesPtaPfxCtnt = aesPtaPfxCtnt;
		this.cneeTaxNo = cneeTaxNo;
		this.mfSmryRptNo = mfSmryRptNo;
		this.cneeTaxCpyDescFlg = cneeTaxCpyDescFlg;
		this.aesTpCd = aesTpCd;
		this.divdPckTpCd = divdPckTpCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.shprTaxCpyDescFlg = shprTaxCpyDescFlg;
		this.aesPtuNo = aesPtuNo;
		this.divdWgt = divdWgt;
		this.ntfyTaxNo = ntfyTaxNo;
		this.divdWgtUtCd = divdWgtUtCd;
		this.ndrRefPfxCtnt = ndrRefPfxCtnt;
		this.g7EdiNo2 = g7EdiNo2;
		this.b13aXptPfxCtnt = b13aXptPfxCtnt;
		this.g7EdiNo1 = g7EdiNo1;
		this.aesPtaNo1 = aesPtaNo1;
		this.aesPtaNo2 = aesPtaNo2;
		this.creDt = creDt;
		this.aesDwnPfxCtnt = aesDwnPfxCtnt;
		this.xptImpSeq = xptImpSeq;
		this.samPckQty = samPckQty;
		this.ibflag = ibflag;
		this.idXptNo = idXptNo;
		this.idaIecCpyDescFlg = idaIecCpyDescFlg;
		this.pckQty = pckQty;
		this.caedTpCd = caedTpCd;
		this.ntfyTaxCpyDescFlg = ntfyTaxCpyDescFlg;
		this.divdSeq = divdSeq;
		this.pckTpCd = pckTpCd;
		this.mfSmryRptPfxCtnt = mfSmryRptPfxCtnt;
		this.brzDeclCpyDescFlg = brzDeclCpyDescFlg;
		this.idDeclCd = idDeclCd;
		this.updDt = updDt;
		this.brzCmdtCd = brzCmdtCd;
		this.idXptNoIssDt = idXptNoIssDt;
		this.aesDwnNo = aesDwnNo;
		this.brzDeclNo = brzDeclNo;
		this.ioBndCd = ioBndCd;
		this.mfWgt = mfWgt;
		this.idOfcCd = idOfcCd;
		this.caedPfxCtnt = caedPfxCtnt;
		this.ucrNo = ucrNo;
		this.divdFlg = divdFlg;
		this.cgoCtrlNo = cgoCtrlNo;
		this.aesInlndTrnsNo = aesInlndTrnsNo;
		this.mxShprTaxId = mxShprTaxId;
		this.mxCneeTaxId = mxCneeTaxId;
		this.mxNtfyTaxId = mxNtfyTaxId;
		this.trShprTaxId = trShprTaxId;
		this.trCneeTaxId = trCneeTaxId;
		this.trNtfyTaxId = trNtfyTaxId;
		this.ilShprTaxId = ilShprTaxId;
		this.ilCneeTaxId = ilCneeTaxId;
		this.ilNtfyTaxId = ilNtfyTaxId;
		this.lbShprTaxId = lbShprTaxId;
		this.lbCneeTaxId = lbCneeTaxId;
		this.lbNtfyTaxId = lbNtfyTaxId;
		this.entrClssTpCd = entrClssTpCd;
		this.entrClssRmk = entrClssRmk;
		this.seq = seq;
		this.porCd = porCd;
		this.aesTpPrnFlg = aesTpPrnFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ndr_ref_id", getNdrRefId());
		this.hashColumns.put("ts_ref_no", getTsRefNo());
		this.hashColumns.put("ida_iec_no", getIdaIecNo());
		this.hashColumns.put("aes_ptu_dt", getAesPtuDt());
		this.hashColumns.put("shpr_tax_no", getShprTaxNo());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("aes_expt_ctnt", getAesExptCtnt());
		this.hashColumns.put("aes_expt_id", getAesExptId());
		this.hashColumns.put("sam_pck_id", getSamPckId());
		this.hashColumns.put("aus_mf_ref_no", getAusMfRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("divd_pck_qty", getDivdPckQty());
		this.hashColumns.put("b13a_xpt_dt", getB13aXptDt());
		this.hashColumns.put("caed_no1", getCaedNo1());
		this.hashColumns.put("sam_pck_tp_cd", getSamPckTpCd());
		this.hashColumns.put("caed_no3", getCaedNo3());
		this.hashColumns.put("caed_no2", getCaedNo2());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("aes_ptu_pfx_ctnt", getAesPtuPfxCtnt());
		this.hashColumns.put("b13a_xpt_no2", getB13aXptNo2());
		this.hashColumns.put("aes_inlnd_trns_pfx_ctnt", getAesInlndTrnsPfxCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cgo_ctrl_pfx_ctnt", getCgoCtrlPfxCtnt());
		this.hashColumns.put("b13a_xpt_no1", getB13aXptNo1());
		this.hashColumns.put("ndr_ref_ctnt", getNdrRefCtnt());
		this.hashColumns.put("aes_pta_dt", getAesPtaDt());
		this.hashColumns.put("aes_dwn_dt", getAesDwnDt());
		this.hashColumns.put("g7_edi_pfx_ctnt", getG7EdiPfxCtnt());
		this.hashColumns.put("aes_pta_pfx_ctnt", getAesPtaPfxCtnt());
		this.hashColumns.put("cnee_tax_no", getCneeTaxNo());
		this.hashColumns.put("mf_smry_rpt_no", getMfSmryRptNo());
		this.hashColumns.put("cnee_tax_cpy_desc_flg", getCneeTaxCpyDescFlg());
		this.hashColumns.put("aes_tp_cd", getAesTpCd());
		this.hashColumns.put("divd_pck_tp_cd", getDivdPckTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("shpr_tax_cpy_desc_flg", getShprTaxCpyDescFlg());
		this.hashColumns.put("aes_ptu_no", getAesPtuNo());
		this.hashColumns.put("divd_wgt", getDivdWgt());
		this.hashColumns.put("ntfy_tax_no", getNtfyTaxNo());
		this.hashColumns.put("divd_wgt_ut_cd", getDivdWgtUtCd());
		this.hashColumns.put("ndr_ref_pfx_ctnt", getNdrRefPfxCtnt());
		this.hashColumns.put("g7_edi_no2", getG7EdiNo2());
		this.hashColumns.put("b13a_xpt_pfx_ctnt", getB13aXptPfxCtnt());
		this.hashColumns.put("g7_edi_no1", getG7EdiNo1());
		this.hashColumns.put("aes_pta_no1", getAesPtaNo1());
		this.hashColumns.put("aes_pta_no2", getAesPtaNo2());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aes_dwn_pfx_ctnt", getAesDwnPfxCtnt());
		this.hashColumns.put("xpt_imp_seq", getXptImpSeq());
		this.hashColumns.put("sam_pck_qty", getSamPckQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("id_xpt_no", getIdXptNo());
		this.hashColumns.put("ida_iec_cpy_desc_flg", getIdaIecCpyDescFlg());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("caed_tp_cd", getCaedTpCd());
		this.hashColumns.put("ntfy_tax_cpy_desc_flg", getNtfyTaxCpyDescFlg());
		this.hashColumns.put("divd_seq", getDivdSeq());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("mf_smry_rpt_pfx_ctnt", getMfSmryRptPfxCtnt());
		this.hashColumns.put("brz_decl_cpy_desc_flg", getBrzDeclCpyDescFlg());
		this.hashColumns.put("id_decl_cd", getIdDeclCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("brz_cmdt_cd", getBrzCmdtCd());
		this.hashColumns.put("id_xpt_no_iss_dt", getIdXptNoIssDt());
		this.hashColumns.put("aes_dwn_no", getAesDwnNo());
		this.hashColumns.put("brz_decl_no", getBrzDeclNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mf_wgt", getMfWgt());
		this.hashColumns.put("id_ofc_cd", getIdOfcCd());
		this.hashColumns.put("caed_pfx_ctnt", getCaedPfxCtnt());
		this.hashColumns.put("ucr_no", getUcrNo());
		this.hashColumns.put("divd_flg", getDivdFlg());
		this.hashColumns.put("cgo_ctrl_no", getCgoCtrlNo());
		this.hashColumns.put("aes_inlnd_trns_no", getAesInlndTrnsNo());
		this.hashColumns.put("mx_shpr_tax_id", getMxShprTaxId());
		this.hashColumns.put("mx_cnee_tax_id", getMxCneeTaxId());
		this.hashColumns.put("mx_ntfy_tax_id", getMxNtfyTaxId());
		this.hashColumns.put("tr_shpr_tax_id", getTrShprTaxId());
		this.hashColumns.put("tr_cnee_tax_id", getTrCneeTaxId());
		this.hashColumns.put("tr_ntfy_tax_id", getTrNtfyTaxId());
		this.hashColumns.put("il_shpr_tax_id", getIlShprTaxId());
		this.hashColumns.put("il_cnee_tax_id", getIlCneeTaxId());
		this.hashColumns.put("il_ntfy_tax_id", getIlNtfyTaxId());
		this.hashColumns.put("lb_shpr_tax_id", getLbShprTaxId());
		this.hashColumns.put("lb_cnee_tax_id", getLbCneeTaxId());
		this.hashColumns.put("lb_ntfy_tax_id", getLbNtfyTaxId());
		this.hashColumns.put("entr_clss_tp_cd", getEntrClssTpCd());
		this.hashColumns.put("entr_clss_rmk", getEntrClssRmk());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("aes_tp_prn_flg", getAesTpPrnFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ndr_ref_id", "ndrRefId");
		this.hashFields.put("ts_ref_no", "tsRefNo");
		this.hashFields.put("ida_iec_no", "idaIecNo");
		this.hashFields.put("aes_ptu_dt", "aesPtuDt");
		this.hashFields.put("shpr_tax_no", "shprTaxNo");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("aes_expt_ctnt", "aesExptCtnt");
		this.hashFields.put("aes_expt_id", "aesExptId");
		this.hashFields.put("sam_pck_id", "samPckId");
		this.hashFields.put("aus_mf_ref_no", "ausMfRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("divd_pck_qty", "divdPckQty");
		this.hashFields.put("b13a_xpt_dt", "b13aXptDt");
		this.hashFields.put("caed_no1", "caedNo1");
		this.hashFields.put("sam_pck_tp_cd", "samPckTpCd");
		this.hashFields.put("caed_no3", "caedNo3");
		this.hashFields.put("caed_no2", "caedNo2");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("aes_ptu_pfx_ctnt", "aesPtuPfxCtnt");
		this.hashFields.put("b13a_xpt_no2", "b13aXptNo2");
		this.hashFields.put("aes_inlnd_trns_pfx_ctnt", "aesInlndTrnsPfxCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cgo_ctrl_pfx_ctnt", "cgoCtrlPfxCtnt");
		this.hashFields.put("b13a_xpt_no1", "b13aXptNo1");
		this.hashFields.put("ndr_ref_ctnt", "ndrRefCtnt");
		this.hashFields.put("aes_pta_dt", "aesPtaDt");
		this.hashFields.put("aes_dwn_dt", "aesDwnDt");
		this.hashFields.put("g7_edi_pfx_ctnt", "g7EdiPfxCtnt");
		this.hashFields.put("aes_pta_pfx_ctnt", "aesPtaPfxCtnt");
		this.hashFields.put("cnee_tax_no", "cneeTaxNo");
		this.hashFields.put("mf_smry_rpt_no", "mfSmryRptNo");
		this.hashFields.put("cnee_tax_cpy_desc_flg", "cneeTaxCpyDescFlg");
		this.hashFields.put("aes_tp_cd", "aesTpCd");
		this.hashFields.put("divd_pck_tp_cd", "divdPckTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("shpr_tax_cpy_desc_flg", "shprTaxCpyDescFlg");
		this.hashFields.put("aes_ptu_no", "aesPtuNo");
		this.hashFields.put("divd_wgt", "divdWgt");
		this.hashFields.put("ntfy_tax_no", "ntfyTaxNo");
		this.hashFields.put("divd_wgt_ut_cd", "divdWgtUtCd");
		this.hashFields.put("ndr_ref_pfx_ctnt", "ndrRefPfxCtnt");
		this.hashFields.put("g7_edi_no2", "g7EdiNo2");
		this.hashFields.put("b13a_xpt_pfx_ctnt", "b13aXptPfxCtnt");
		this.hashFields.put("g7_edi_no1", "g7EdiNo1");
		this.hashFields.put("aes_pta_no1", "aesPtaNo1");
		this.hashFields.put("aes_pta_no2", "aesPtaNo2");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aes_dwn_pfx_ctnt", "aesDwnPfxCtnt");
		this.hashFields.put("xpt_imp_seq", "xptImpSeq");
		this.hashFields.put("sam_pck_qty", "samPckQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("id_xpt_no", "idXptNo");
		this.hashFields.put("ida_iec_cpy_desc_flg", "idaIecCpyDescFlg");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("caed_tp_cd", "caedTpCd");
		this.hashFields.put("ntfy_tax_cpy_desc_flg", "ntfyTaxCpyDescFlg");
		this.hashFields.put("divd_seq", "divdSeq");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("mf_smry_rpt_pfx_ctnt", "mfSmryRptPfxCtnt");
		this.hashFields.put("brz_decl_cpy_desc_flg", "brzDeclCpyDescFlg");
		this.hashFields.put("id_decl_cd", "idDeclCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("brz_cmdt_cd", "brzCmdtCd");
		this.hashFields.put("id_xpt_no_iss_dt", "idXptNoIssDt");
		this.hashFields.put("aes_dwn_no", "aesDwnNo");
		this.hashFields.put("brz_decl_no", "brzDeclNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mf_wgt", "mfWgt");
		this.hashFields.put("id_ofc_cd", "idOfcCd");
		this.hashFields.put("caed_pfx_ctnt", "caedPfxCtnt");
		this.hashFields.put("ucr_no", "ucrNo");
		this.hashFields.put("divd_flg", "divdFlg");
		this.hashFields.put("cgo_ctrl_no", "cgoCtrlNo");
		this.hashFields.put("aes_inlnd_trns_no", "aesInlndTrnsNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("mx_shpr_tax_id", "mxShprTaxId");
		this.hashFields.put("mx_cnee_tax_id", "mxCneeTaxId");
		this.hashFields.put("mx_ntfy_tax_id", "mxNtfyTaxId");
		this.hashFields.put("tr_shpr_tax_id", "trShprTaxId");
		this.hashFields.put("tr_cnee_tax_id", "trCneeTaxId");
		this.hashFields.put("tr_ntfy_tax_id", "trNtfyTaxId");
		this.hashFields.put("il_shpr_tax_id", "ilShprTaxId");
		this.hashFields.put("il_cnee_tax_id", "ilCneeTaxId");
		this.hashFields.put("il_ntfy_tax_id", "ilNtfyTaxId");
		this.hashFields.put("lb_shpr_tax_id", "lbShprTaxId");
		this.hashFields.put("lb_cnee_tax_id", "lbCneeTaxId");
		this.hashFields.put("lb_ntfy_tax_id", "lbNtfyTaxId");
		this.hashFields.put("entr_clss_tp_cd", "entrClssTpCd");
		this.hashFields.put("entr_clss_rmk", "entrClssRmk");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("aes_tp_prn_flg", "aesTpPrnFlg");
		return this.hashFields;
	}

	
	/**
	 * @return the entrClssTpCd
	 */
	public String getEntrClssTpCd() {
		return entrClssTpCd;
	}

	/**
	 * @param entrClssTpCd the entrClssTpCd to set
	 */
	public void setEntrClssTpCd(String entrClssTpCd) {
		this.entrClssTpCd = entrClssTpCd;
	}

	/**
	 * @return the entrClssRmk
	 */
	public String getEntrClssRmk() {
		return entrClssRmk;
	}

	/**
	 * @param entrClssRmk the entrClssRmk to set
	 */
	public void setEntrClssRmk(String entrClssRmk) {
		this.entrClssRmk = entrClssRmk;
	}

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @return idaIecNo
	 */
	public String getIdaIecNo() {
		return this.idaIecNo;
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
	 * @return shprTaxNo
	 */
	public String getShprTaxNo() {
		return this.shprTaxNo;
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
	 * Column Info
	 * @return ausMfRefNo
	 */
	public String getAusMfRefNo() {
		return this.ausMfRefNo;
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
	 * @return b13aXptDt
	 */
	public String getB13aXptDt() {
		return this.b13aXptDt;
	}

	/**
	 * Column Info
	 * @return caedNo1
	 */
	public String getCaedNo1() {
		return this.caedNo1;
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
	 * @return caedNo3
	 */
	public String getCaedNo3() {
		return this.caedNo3;
	}

	/**
	 * Column Info
	 * @return caedNo2
	 */
	public String getCaedNo2() {
		return this.caedNo2;
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
	 * @return b13aXptNo2
	 */
	public String getB13aXptNo2() {
		return this.b13aXptNo2;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return b13aXptNo1
	 */
	public String getB13aXptNo1() {
		return this.b13aXptNo1;
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
	 * @return cneeTaxNo
	 */
	public String getCneeTaxNo() {
		return this.cneeTaxNo;
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
	 * @return cneeTaxCpyDescFlg
	 */
	public String getCneeTaxCpyDescFlg() {
		return this.cneeTaxCpyDescFlg;
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
	 * @return shprTaxCpyDescFlg
	 */
	public String getShprTaxCpyDescFlg() {
		return this.shprTaxCpyDescFlg;
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
	 * @return ntfyTaxNo
	 */
	public String getNtfyTaxNo() {
		return this.ntfyTaxNo;
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
	 * @return g7EdiNo2
	 */
	public String getG7EdiNo2() {
		return this.g7EdiNo2;
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
	 * @return g7EdiNo1
	 */
	public String getG7EdiNo1() {
		return this.g7EdiNo1;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return idXptNo
	 */
	public String getIdXptNo() {
		return this.idXptNo;
	}

	/**
	 * Column Info
	 * @return idaIecCpyDescFlg
	 */
	public String getIdaIecCpyDescFlg() {
		return this.idaIecCpyDescFlg;
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
	 * @return ntfyTaxCpyDescFlg
	 */
	public String getNtfyTaxCpyDescFlg() {
		return this.ntfyTaxCpyDescFlg;
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
	 * @return brzDeclCpyDescFlg
	 */
	public String getBrzDeclCpyDescFlg() {
		return this.brzDeclCpyDescFlg;
	}

	/**
	 * Column Info
	 * @return idDeclCd
	 */
	public String getIdDeclCd() {
		return this.idDeclCd;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * @return brzCmdtCd
	 */
	public String getBrzCmdtCd() {
		return this.brzCmdtCd;
	}

	/**
	 * Column Info
	 * @return idXptNoIssDt
	 */
	public String getIdXptNoIssDt() {
		return this.idXptNoIssDt;
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
	 * @return brzDeclNo
	 */
	public String getBrzDeclNo() {
		return this.brzDeclNo;
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
	 * @return idOfcCd
	 */
	public String getIdOfcCd() {
		return this.idOfcCd;
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
	 * @return ucrNo
	 */
	public String getUcrNo() {
		return this.ucrNo;
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
	 * @return cgoCtrlNo
	 */
	public String getCgoCtrlNo() {
		return this.cgoCtrlNo;
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
	 * @return mxShprTaxId
	 */
	public String getMxShprTaxId() {
		return this.mxShprTaxId;
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
	 * @return mxNtfyeTaxId
	 */
	public String getMxNtfyTaxId() {
		return this.mxNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @return trShprTaxId
	 */
	public String getTrShprTaxId() {
		return this.trShprTaxId;
	}

	/**
	 * Column Info
	 * @return trCneeTaxId
	 */
	public String getTrCneeTaxId() {
		return this.trCneeTaxId;
	}

	/**
	 * Column Info
	 * @return trNtfyeTaxId
	 */
	public String getTrNtfyTaxId() {
		return this.trNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @return ilShprTaxId
	 */
	public String getIlShprTaxId() {
		return this.ilShprTaxId;
	}
	
	/**
	 * Column Info
	 * @return ilCneeTaxId
	 */
	public String getIlCneeTaxId() {
		return this.ilCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @return ilNtfyTaxId
	 */
	public String getIlNtfyTaxId() {
		return this.ilNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @return lbShprTaxId
	 */
	public String getLbShprTaxId() {
		return this.lbShprTaxId;
	}
	
	/**
	 * Column Info
	 * @return lbCneeTaxId
	 */
	public String getLbCneeTaxId() {
		return this.lbCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @return lbNtfyTaxId
	 */
	public String getLbNtfyTaxId() {
		return this.lbNtfyTaxId;
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
	 * @param idaIecNo
	 */
	public void setIdaIecNo(String idaIecNo) {
		this.idaIecNo = idaIecNo;
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
	 * @param shprTaxNo
	 */
	public void setShprTaxNo(String shprTaxNo) {
		this.shprTaxNo = shprTaxNo;
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
	 * Column Info
	 * @param ausMfRefNo
	 */
	public void setAusMfRefNo(String ausMfRefNo) {
		this.ausMfRefNo = ausMfRefNo;
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
	 * @param b13aXptDt
	 */
	public void setB13aXptDt(String b13aXptDt) {
		this.b13aXptDt = b13aXptDt;
	}

	/**
	 * Column Info
	 * @param caedNo1
	 */
	public void setCaedNo1(String caedNo1) {
		this.caedNo1 = caedNo1;
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
	 * @param caedNo3
	 */
	public void setCaedNo3(String caedNo3) {
		this.caedNo3 = caedNo3;
	}

	/**
	 * Column Info
	 * @param caedNo2
	 */
	public void setCaedNo2(String caedNo2) {
		this.caedNo2 = caedNo2;
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
	 * @param b13aXptNo2
	 */
	public void setB13aXptNo2(String b13aXptNo2) {
		this.b13aXptNo2 = b13aXptNo2;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param b13aXptNo1
	 */
	public void setB13aXptNo1(String b13aXptNo1) {
		this.b13aXptNo1 = b13aXptNo1;
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
	 * @param cneeTaxNo
	 */
	public void setCneeTaxNo(String cneeTaxNo) {
		this.cneeTaxNo = cneeTaxNo;
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
	 * @param cneeTaxCpyDescFlg
	 */
	public void setCneeTaxCpyDescFlg(String cneeTaxCpyDescFlg) {
		this.cneeTaxCpyDescFlg = cneeTaxCpyDescFlg;
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
	 * @param shprTaxCpyDescFlg
	 */
	public void setShprTaxCpyDescFlg(String shprTaxCpyDescFlg) {
		this.shprTaxCpyDescFlg = shprTaxCpyDescFlg;
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
	 * @param ntfyTaxNo
	 */
	public void setNtfyTaxNo(String ntfyTaxNo) {
		this.ntfyTaxNo = ntfyTaxNo;
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
	 * @param g7EdiNo2
	 */
	public void setG7EdiNo2(String g7EdiNo2) {
		this.g7EdiNo2 = g7EdiNo2;
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
	 * @param g7EdiNo1
	 */
	public void setG7EdiNo1(String g7EdiNo1) {
		this.g7EdiNo1 = g7EdiNo1;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param idXptNo
	 */
	public void setIdXptNo(String idXptNo) {
		this.idXptNo = idXptNo;
	}

	/**
	 * Column Info
	 * @param idaIecCpyDescFlg
	 */
	public void setIdaIecCpyDescFlg(String idaIecCpyDescFlg) {
		this.idaIecCpyDescFlg = idaIecCpyDescFlg;
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
	 * @param ntfyTaxCpyDescFlg
	 */
	public void setNtfyTaxCpyDescFlg(String ntfyTaxCpyDescFlg) {
		this.ntfyTaxCpyDescFlg = ntfyTaxCpyDescFlg;
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
	 * @param brzDeclCpyDescFlg
	 */
	public void setBrzDeclCpyDescFlg(String brzDeclCpyDescFlg) {
		this.brzDeclCpyDescFlg = brzDeclCpyDescFlg;
	}

	/**
	 * Column Info
	 * @param idDeclCd
	 */
	public void setIdDeclCd(String idDeclCd) {
		this.idDeclCd = idDeclCd;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param brzCmdtCd
	 */
	public void setBrzCmdtCd(String brzCmdtCd) {
		this.brzCmdtCd = brzCmdtCd;
	}

	/**
	 * Column Info
	 * @param idXptNoIssDt
	 */
	public void setIdXptNoIssDt(String idXptNoIssDt) {
		this.idXptNoIssDt = idXptNoIssDt;
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
	 * @param brzDeclNo
	 */
	public void setBrzDeclNo(String brzDeclNo) {
		this.brzDeclNo = brzDeclNo;
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
	 * @param idOfcCd
	 */
	public void setIdOfcCd(String idOfcCd) {
		this.idOfcCd = idOfcCd;
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
	 * @param ucrNo
	 */
	public void setUcrNo(String ucrNo) {
		this.ucrNo = ucrNo;
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
	 * @param cgoCtrlNo
	 */
	public void setCgoCtrlNo(String cgoCtrlNo) {
		this.cgoCtrlNo = cgoCtrlNo;
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
	 * @param mxShprTaxId
	 */
	public void setMxShprTaxId(String mxShprTaxId) {
		this.mxShprTaxId = mxShprTaxId;
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
	 * @param mxNtfyTaxId
	 */
	public void setMxNtfyTaxId(String mxNtfyTaxId) {
		this.mxNtfyTaxId = mxNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @param trShprTaxId
	 */
	public void setTrShprTaxId(String trShprTaxId) {
		this.trShprTaxId = trShprTaxId;
	}
	
	/**
	 * Column Info
	 * @param trCneeTaxId
	 */
	public void setTrCneeTaxId(String trCneeTaxId) {
		this.trCneeTaxId = trCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @param trNtfyTaxId
	 */
	public void setTrNtfyTaxId(String trNtfyTaxId) {
		this.trNtfyTaxId = trNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @param ilShprTaxId
	 */
	public void setIlShprTaxId(String ilShprTaxId) {
		this.ilShprTaxId = ilShprTaxId;
	}
	
	/**
	 * Column Info
	 * @param ilCneeTaxId
	 */
	public void setIlCneeTaxId(String ilCneeTaxId) {
		this.ilCneeTaxId = ilCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @param ilNtfyTaxId
	 */
	public void setIlNtfyTaxId(String ilNtfyTaxId) {
		this.ilNtfyTaxId = ilNtfyTaxId;
	}
	
	/**
	 * Column Info
	 * @param lbShprTaxId
	 */
	public void setLbShprTaxId(String lbShprTaxId) {
		this.lbShprTaxId = lbShprTaxId;
	}
	
	/**
	 * Column Info
	 * @param lbCneeTaxId
	 */
	public void setLbCneeTaxId(String lbCneeTaxId) {
		this.lbCneeTaxId = lbCneeTaxId;
	}
	
	/**
	 * Column Info
	 * @param lbNtfyTaxId
	 */
	public void setLbNtfyTaxId(String lbNtfyTaxId) {
		this.lbNtfyTaxId = lbNtfyTaxId;
	}
	
	/**
	 * @return the porCd
	 */
	public String getPorCd() {
		return porCd;
	}

	/**
	 * @param porCd the porCd to set
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * @return the aesTpPrnFlg
	 */
	public String getAesTpPrnFlg() {
		return aesTpPrnFlg;
	}

	/**
	 * @param aesTpPrnFlg
	 */
	public void setAesTpPrnFlg(String aesTpPrnFlg) {
		this.aesTpPrnFlg = aesTpPrnFlg;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNdrRefId(JSPUtil.getParameter(request, "ndr_ref_id", ""));
		setTsRefNo(JSPUtil.getParameter(request, "ts_ref_no", ""));
		setIdaIecNo(JSPUtil.getParameter(request, "ida_iec_no", ""));
		setAesPtuDt(JSPUtil.getParameter(request, "aes_ptu_dt", ""));
		setShprTaxNo(JSPUtil.getParameter(request, "shpr_tax_no", ""));
		setXptLicNo(JSPUtil.getParameter(request, "xpt_lic_no", ""));
		setAesExptCtnt(JSPUtil.getParameter(request, "aes_expt_ctnt", ""));
		setAesExptId(JSPUtil.getParameter(request, "aes_expt_id", ""));
		setSamPckId(JSPUtil.getParameter(request, "sam_pck_id", ""));
		setAusMfRefNo(JSPUtil.getParameter(request, "aus_mf_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDivdPckQty(JSPUtil.getParameter(request, "divd_pck_qty", ""));
		setB13aXptDt(JSPUtil.getParameter(request, "b13a_xpt_dt", ""));
		setCaedNo1(JSPUtil.getParameter(request, "caed_no1", ""));
		setSamPckTpCd(JSPUtil.getParameter(request, "sam_pck_tp_cd", ""));
		setCaedNo3(JSPUtil.getParameter(request, "caed_no3", ""));
		setCaedNo2(JSPUtil.getParameter(request, "caed_no2", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setAesPtuPfxCtnt(JSPUtil.getParameter(request, "aes_ptu_pfx_ctnt", ""));
		setB13aXptNo2(JSPUtil.getParameter(request, "b13a_xpt_no2", ""));
		setAesInlndTrnsPfxCtnt(JSPUtil.getParameter(request, "aes_inlnd_trns_pfx_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCgoCtrlPfxCtnt(JSPUtil.getParameter(request, "cgo_ctrl_pfx_ctnt", ""));
		setB13aXptNo1(JSPUtil.getParameter(request, "b13a_xpt_no1", ""));
		setNdrRefCtnt(JSPUtil.getParameter(request, "ndr_ref_ctnt", ""));
		setAesPtaDt(JSPUtil.getParameter(request, "aes_pta_dt", ""));
		setAesDwnDt(JSPUtil.getParameter(request, "aes_dwn_dt", ""));
		setG7EdiPfxCtnt(JSPUtil.getParameter(request, "g7_edi_pfx_ctnt", ""));
		setAesPtaPfxCtnt(JSPUtil.getParameter(request, "aes_pta_pfx_ctnt", ""));
		setCneeTaxNo(JSPUtil.getParameter(request, "cnee_tax_no", ""));
		setMfSmryRptNo(JSPUtil.getParameter(request, "mf_smry_rpt_no", ""));
		setCneeTaxCpyDescFlg(JSPUtil.getParameter(request, "cnee_tax_cpy_desc_flg", ""));
		setAesTpCd(JSPUtil.getParameter(request, "aes_tp_cd", ""));
		setDivdPckTpCd(JSPUtil.getParameter(request, "divd_pck_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setShprTaxCpyDescFlg(JSPUtil.getParameter(request, "shpr_tax_cpy_desc_flg", ""));
		setAesPtuNo(JSPUtil.getParameter(request, "aes_ptu_no", ""));
		setDivdWgt(JSPUtil.getParameter(request, "divd_wgt", ""));
		setNtfyTaxNo(JSPUtil.getParameter(request, "ntfy_tax_no", ""));
		setDivdWgtUtCd(JSPUtil.getParameter(request, "divd_wgt_ut_cd", ""));
		setNdrRefPfxCtnt(JSPUtil.getParameter(request, "ndr_ref_pfx_ctnt", ""));
		setG7EdiNo2(JSPUtil.getParameter(request, "g7_edi_no2", ""));
		setB13aXptPfxCtnt(JSPUtil.getParameter(request, "b13a_xpt_pfx_ctnt", ""));
		setG7EdiNo1(JSPUtil.getParameter(request, "g7_edi_no1", ""));
		setAesPtaNo1(JSPUtil.getParameter(request, "aes_pta_no1", ""));
		setAesPtaNo2(JSPUtil.getParameter(request, "aes_pta_no2", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAesDwnPfxCtnt(JSPUtil.getParameter(request, "aes_dwn_pfx_ctnt", ""));
		setXptImpSeq(JSPUtil.getParameter(request, "xpt_imp_seq", ""));
		setSamPckQty(JSPUtil.getParameter(request, "sam_pck_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIdXptNo(JSPUtil.getParameter(request, "id_xpt_no", ""));
		setIdaIecCpyDescFlg(JSPUtil.getParameter(request, "ida_iec_cpy_desc_flg", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setCaedTpCd(JSPUtil.getParameter(request, "caed_tp_cd", ""));
		setNtfyTaxCpyDescFlg(JSPUtil.getParameter(request, "ntfy_tax_cpy_desc_flg", ""));
		setDivdSeq(JSPUtil.getParameter(request, "divd_seq", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMfSmryRptPfxCtnt(JSPUtil.getParameter(request, "mf_smry_rpt_pfx_ctnt", ""));
		setBrzDeclCpyDescFlg(JSPUtil.getParameter(request, "brz_decl_cpy_desc_flg", ""));
		setIdDeclCd(JSPUtil.getParameter(request, "id_decl_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBrzCmdtCd(JSPUtil.getParameter(request, "brz_cmdt_cd", ""));
		setIdXptNoIssDt(JSPUtil.getParameter(request, "id_xpt_no_iss_dt", ""));
		setAesDwnNo(JSPUtil.getParameter(request, "aes_dwn_no", ""));
		setBrzDeclNo(JSPUtil.getParameter(request, "brz_decl_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setMfWgt(JSPUtil.getParameter(request, "mf_wgt", ""));
		setIdOfcCd(JSPUtil.getParameter(request, "id_ofc_cd", ""));
		setCaedPfxCtnt(JSPUtil.getParameter(request, "caed_pfx_ctnt", ""));
		setUcrNo(JSPUtil.getParameter(request, "ucr_no", ""));
		setDivdFlg(JSPUtil.getParameter(request, "divd_flg", ""));
		setCgoCtrlNo(JSPUtil.getParameter(request, "cgo_ctrl_no", ""));
		setAesInlndTrnsNo(JSPUtil.getParameter(request, "aes_inlnd_trns_no", ""));
		setMxShprTaxId(JSPUtil.getParameter(request, "mx_shpr_tax_id", ""));
		setMxCneeTaxId(JSPUtil.getParameter(request, "mx_cnee_tax_id", ""));
		setMxNtfyTaxId(JSPUtil.getParameter(request, "mx_ntfy_tax_id", ""));
		setTrShprTaxId(JSPUtil.getParameter(request, "tr_shpr_tax_id", ""));
		setTrCneeTaxId(JSPUtil.getParameter(request, "tr_cnee_tax_id", ""));
		setTrNtfyTaxId(JSPUtil.getParameter(request, "tr_ntfy_tax_id", ""));
		setIlShprTaxId(JSPUtil.getParameter(request, "il_shpr_tax_id", ""));
		setIlCneeTaxId(JSPUtil.getParameter(request, "il_cnee_tax_id", ""));
		setIlNtfyTaxId(JSPUtil.getParameter(request, "il_ntfy_tax_id", ""));
		setLbShprTaxId(JSPUtil.getParameter(request, "lb_shpr_tax_id", ""));
		setLbCneeTaxId(JSPUtil.getParameter(request, "lb_cnee_tax_id", ""));
		setLbNtfyTaxId(JSPUtil.getParameter(request, "lb_ntfy_tax_id", ""));
		setEntrClssTpCd(JSPUtil.getParameter(request, "entr_clss_tp_cd", ""));
		setEntrClssRmk(JSPUtil.getParameter(request, "entr_clss_rmk", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setAesTpPrnFlg(JSPUtil.getParameter(request, "aes_tp_prn_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XptImpLicVO[]
	 */
	public XptImpLicVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return XptImpLicVO[]
	 */
	public XptImpLicVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XptImpLicVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ndrRefId = (JSPUtil.getParameter(request, prefix	+ "ndr_ref_id", length));
			String[] tsRefNo = (JSPUtil.getParameter(request, prefix	+ "ts_ref_no", length));
			String[] idaIecNo = (JSPUtil.getParameter(request, prefix	+ "ida_iec_no", length));
			String[] aesPtuDt = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_dt", length));
			String[] shprTaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_no", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] aesExptCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_expt_ctnt", length));
			String[] aesExptId = (JSPUtil.getParameter(request, prefix	+ "aes_expt_id", length));
			String[] samPckId = (JSPUtil.getParameter(request, prefix	+ "sam_pck_id", length));
			String[] ausMfRefNo = (JSPUtil.getParameter(request, prefix	+ "aus_mf_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divdPckQty = (JSPUtil.getParameter(request, prefix	+ "divd_pck_qty", length));
			String[] b13aXptDt = (JSPUtil.getParameter(request, prefix	+ "b13a_xpt_dt", length));
			String[] caedNo1 = (JSPUtil.getParameter(request, prefix	+ "caed_no1", length));
			String[] samPckTpCd = (JSPUtil.getParameter(request, prefix	+ "sam_pck_tp_cd", length));
			String[] caedNo3 = (JSPUtil.getParameter(request, prefix	+ "caed_no3", length));
			String[] caedNo2 = (JSPUtil.getParameter(request, prefix	+ "caed_no2", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] aesPtuPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_pfx_ctnt", length));
			String[] b13aXptNo2 = (JSPUtil.getParameter(request, prefix	+ "b13a_xpt_no2", length));
			String[] aesInlndTrnsPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_inlnd_trns_pfx_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cgoCtrlPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "cgo_ctrl_pfx_ctnt", length));
			String[] b13aXptNo1 = (JSPUtil.getParameter(request, prefix	+ "b13a_xpt_no1", length));
			String[] ndrRefCtnt = (JSPUtil.getParameter(request, prefix	+ "ndr_ref_ctnt", length));
			String[] aesPtaDt = (JSPUtil.getParameter(request, prefix	+ "aes_pta_dt", length));
			String[] aesDwnDt = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_dt", length));
			String[] g7EdiPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "g7_edi_pfx_ctnt", length));
			String[] aesPtaPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_pta_pfx_ctnt", length));
			String[] cneeTaxNo = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_no", length));
			String[] mfSmryRptNo = (JSPUtil.getParameter(request, prefix	+ "mf_smry_rpt_no", length));
			String[] cneeTaxCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_cpy_desc_flg", length));
			String[] aesTpCd = (JSPUtil.getParameter(request, prefix	+ "aes_tp_cd", length));
			String[] divdPckTpCd = (JSPUtil.getParameter(request, prefix	+ "divd_pck_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shprTaxCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_cpy_desc_flg", length));
			String[] aesPtuNo = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_no", length));
			String[] divdWgt = (JSPUtil.getParameter(request, prefix	+ "divd_wgt", length));
			String[] ntfyTaxNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_no", length));
			String[] divdWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_wgt_ut_cd", length));
			String[] ndrRefPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "ndr_ref_pfx_ctnt", length));
			String[] g7EdiNo2 = (JSPUtil.getParameter(request, prefix	+ "g7_edi_no2", length));
			String[] b13aXptPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "b13a_xpt_pfx_ctnt", length));
			String[] g7EdiNo1 = (JSPUtil.getParameter(request, prefix	+ "g7_edi_no1", length));
			String[] aesPtaNo1 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_no1", length));
			String[] aesPtaNo2 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_no2", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aesDwnPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_pfx_ctnt", length));
			String[] xptImpSeq = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_seq", length));
			String[] samPckQty = (JSPUtil.getParameter(request, prefix	+ "sam_pck_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] idXptNo = (JSPUtil.getParameter(request, prefix	+ "id_xpt_no", length));
			String[] idaIecCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "ida_iec_cpy_desc_flg", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] caedTpCd = (JSPUtil.getParameter(request, prefix	+ "caed_tp_cd", length));
			String[] ntfyTaxCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_cpy_desc_flg", length));
			String[] divdSeq = (JSPUtil.getParameter(request, prefix	+ "divd_seq", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] mfSmryRptPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "mf_smry_rpt_pfx_ctnt", length));
			String[] brzDeclCpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "brz_decl_cpy_desc_flg", length));
			String[] idDeclCd = (JSPUtil.getParameter(request, prefix	+ "id_decl_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] brzCmdtCd = (JSPUtil.getParameter(request, prefix	+ "brz_cmdt_cd", length));
			String[] idXptNoIssDt = (JSPUtil.getParameter(request, prefix	+ "id_xpt_no_iss_dt", length));
			String[] aesDwnNo = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_no", length));
			String[] brzDeclNo = (JSPUtil.getParameter(request, prefix	+ "brz_decl_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] mfWgt = (JSPUtil.getParameter(request, prefix	+ "mf_wgt", length));
			String[] idOfcCd = (JSPUtil.getParameter(request, prefix	+ "id_ofc_cd", length));
			String[] caedPfxCtnt = (JSPUtil.getParameter(request, prefix	+ "caed_pfx_ctnt", length));
			String[] ucrNo = (JSPUtil.getParameter(request, prefix	+ "ucr_no", length));
			String[] divdFlg = (JSPUtil.getParameter(request, prefix	+ "divd_flg", length));
			String[] cgoCtrlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_ctrl_no", length));
			String[] aesInlndTrnsNo = (JSPUtil.getParameter(request, prefix	+ "aes_inlnd_trns_no", length));
			String[] mxShprTaxId = (JSPUtil.getParameter(request, prefix	+ "mx_shpr_tax_id", length));
			String[] mxCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "mx_cnee_tax_id", length));
			String[] mxNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "mx_ntfy_tax_id", length));
			String[] trShprTaxId = (JSPUtil.getParameter(request, prefix	+ "tr_shpr_tax_id", length));
			String[] trCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "tr_cnee_tax_id", length));
			String[] trNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "tr_ntfy_tax_id", length));
			String[] ilShprTaxId = (JSPUtil.getParameter(request, prefix	+ "il_shpr_tax_id", length));
			String[] ilCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "il_cnee_tax_id", length));
			String[] ilNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "il_ntfy_tax_id", length));
			String[] lbShprTaxId = (JSPUtil.getParameter(request, prefix	+ "lb_shpr_tax_id", length));
			String[] lbCneeTaxId = (JSPUtil.getParameter(request, prefix	+ "lb_cnee_tax_id", length));
			String[] lbNtfyTaxId = (JSPUtil.getParameter(request, prefix	+ "lb_ntfy_tax_id", length));
			String[] entrClssTpCd = (JSPUtil.getParameter(request, prefix	+ "entr_clss_tp_cd", length));
			String[] entrClssRmk = (JSPUtil.getParameter(request, prefix	+ "entr_clss_rmk", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] aesTpPrnFlg = (JSPUtil.getParameter(request, prefix	+ "aes_tp_prn_flg", length));

			for (int i = 0; i < length; i++) {
				model = new XptImpLicVO();
				if (ndrRefId[i] != null)
					model.setNdrRefId(ndrRefId[i]);
				if (tsRefNo[i] != null)
					model.setTsRefNo(tsRefNo[i]);
				if (idaIecNo[i] != null)
					model.setIdaIecNo(idaIecNo[i]);
				if (aesPtuDt[i] != null)
					model.setAesPtuDt(aesPtuDt[i]);
				if (shprTaxNo[i] != null)
					model.setShprTaxNo(shprTaxNo[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (aesExptCtnt[i] != null)
					model.setAesExptCtnt(aesExptCtnt[i]);
				if (aesExptId[i] != null)
					model.setAesExptId(aesExptId[i]);
				if (samPckId[i] != null)
					model.setSamPckId(samPckId[i]);
				if (ausMfRefNo[i] != null)
					model.setAusMfRefNo(ausMfRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divdPckQty[i] != null)
					model.setDivdPckQty(divdPckQty[i]);
				if (b13aXptDt[i] != null)
					model.setB13aXptDt(b13aXptDt[i]);
				if (caedNo1[i] != null)
					model.setCaedNo1(caedNo1[i]);
				if (samPckTpCd[i] != null)
					model.setSamPckTpCd(samPckTpCd[i]);
				if (caedNo3[i] != null)
					model.setCaedNo3(caedNo3[i]);
				if (caedNo2[i] != null)
					model.setCaedNo2(caedNo2[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (aesPtuPfxCtnt[i] != null)
					model.setAesPtuPfxCtnt(aesPtuPfxCtnt[i]);
				if (b13aXptNo2[i] != null)
					model.setB13aXptNo2(b13aXptNo2[i]);
				if (aesInlndTrnsPfxCtnt[i] != null)
					model.setAesInlndTrnsPfxCtnt(aesInlndTrnsPfxCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cgoCtrlPfxCtnt[i] != null)
					model.setCgoCtrlPfxCtnt(cgoCtrlPfxCtnt[i]);
				if (b13aXptNo1[i] != null)
					model.setB13aXptNo1(b13aXptNo1[i]);
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
				if (cneeTaxNo[i] != null)
					model.setCneeTaxNo(cneeTaxNo[i]);
				if (mfSmryRptNo[i] != null)
					model.setMfSmryRptNo(mfSmryRptNo[i]);
				if (cneeTaxCpyDescFlg[i] != null)
					model.setCneeTaxCpyDescFlg(cneeTaxCpyDescFlg[i]);
				if (aesTpCd[i] != null)
					model.setAesTpCd(aesTpCd[i]);
				if (divdPckTpCd[i] != null)
					model.setDivdPckTpCd(divdPckTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shprTaxCpyDescFlg[i] != null)
					model.setShprTaxCpyDescFlg(shprTaxCpyDescFlg[i]);
				if (aesPtuNo[i] != null)
					model.setAesPtuNo(aesPtuNo[i]);
				if (divdWgt[i] != null)
					model.setDivdWgt(divdWgt[i]);
				if (ntfyTaxNo[i] != null)
					model.setNtfyTaxNo(ntfyTaxNo[i]);
				if (divdWgtUtCd[i] != null)
					model.setDivdWgtUtCd(divdWgtUtCd[i]);
				if (ndrRefPfxCtnt[i] != null)
					model.setNdrRefPfxCtnt(ndrRefPfxCtnt[i]);
				if (g7EdiNo2[i] != null)
					model.setG7EdiNo2(g7EdiNo2[i]);
				if (b13aXptPfxCtnt[i] != null)
					model.setB13aXptPfxCtnt(b13aXptPfxCtnt[i]);
				if (g7EdiNo1[i] != null)
					model.setG7EdiNo1(g7EdiNo1[i]);
				if (aesPtaNo1[i] != null)
					model.setAesPtaNo1(aesPtaNo1[i]);
				if (aesPtaNo2[i] != null)
					model.setAesPtaNo2(aesPtaNo2[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aesDwnPfxCtnt[i] != null)
					model.setAesDwnPfxCtnt(aesDwnPfxCtnt[i]);
				if (xptImpSeq[i] != null)
					model.setXptImpSeq(xptImpSeq[i]);
				if (samPckQty[i] != null)
					model.setSamPckQty(samPckQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (idXptNo[i] != null)
					model.setIdXptNo(idXptNo[i]);
				if (idaIecCpyDescFlg[i] != null)
					model.setIdaIecCpyDescFlg(idaIecCpyDescFlg[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (caedTpCd[i] != null)
					model.setCaedTpCd(caedTpCd[i]);
				if (ntfyTaxCpyDescFlg[i] != null)
					model.setNtfyTaxCpyDescFlg(ntfyTaxCpyDescFlg[i]);
				if (divdSeq[i] != null)
					model.setDivdSeq(divdSeq[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (mfSmryRptPfxCtnt[i] != null)
					model.setMfSmryRptPfxCtnt(mfSmryRptPfxCtnt[i]);
				if (brzDeclCpyDescFlg[i] != null)
					model.setBrzDeclCpyDescFlg(brzDeclCpyDescFlg[i]);
				if (idDeclCd[i] != null)
					model.setIdDeclCd(idDeclCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (brzCmdtCd[i] != null)
					model.setBrzCmdtCd(brzCmdtCd[i]);
				if (idXptNoIssDt[i] != null)
					model.setIdXptNoIssDt(idXptNoIssDt[i]);
				if (aesDwnNo[i] != null)
					model.setAesDwnNo(aesDwnNo[i]);
				if (brzDeclNo[i] != null)
					model.setBrzDeclNo(brzDeclNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mfWgt[i] != null)
					model.setMfWgt(mfWgt[i]);
				if (idOfcCd[i] != null)
					model.setIdOfcCd(idOfcCd[i]);
				if (caedPfxCtnt[i] != null)
					model.setCaedPfxCtnt(caedPfxCtnt[i]);
				if (ucrNo[i] != null)
					model.setUcrNo(ucrNo[i]);
				if (divdFlg[i] != null)
					model.setDivdFlg(divdFlg[i]);
				if (cgoCtrlNo[i] != null)
					model.setCgoCtrlNo(cgoCtrlNo[i]);
				if (aesInlndTrnsNo[i] != null)
					model.setAesInlndTrnsNo(aesInlndTrnsNo[i]);
				if (mxShprTaxId[i] != null)
					model.setMxShprTaxId(mxShprTaxId[i]);
				if (mxCneeTaxId[i] != null)
					model.setMxCneeTaxId(mxCneeTaxId[i]);
				if (mxNtfyTaxId[i] != null)
					model.setMxNtfyTaxId(mxNtfyTaxId[i]);
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
				if (entrClssTpCd[i] != null)
					model.setEntrClssTpCd(entrClssTpCd[i]);
				if (entrClssRmk[i] != null)
					model.setEntrClssRmk(entrClssRmk[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (aesTpPrnFlg[i] != null)
					model.setAesTpPrnFlg(aesTpPrnFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXptImpLicVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XptImpLicVO[]
	 */
	public XptImpLicVO[] getXptImpLicVOs(){
		XptImpLicVO[] vos = (XptImpLicVO[])models.toArray(new XptImpLicVO[models.size()]);
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
		this.ndrRefId = this.ndrRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRefNo = this.tsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIecNo = this.idaIecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuDt = this.aesPtuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxNo = this.shprTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesExptCtnt = this.aesExptCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesExptId = this.aesExptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckId = this.samPckId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausMfRefNo = this.ausMfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckQty = this.divdPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aXptDt = this.b13aXptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedNo1 = this.caedNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckTpCd = this.samPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedNo3 = this.caedNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedNo2 = this.caedNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuPfxCtnt = this.aesPtuPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aXptNo2 = this.b13aXptNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesInlndTrnsPfxCtnt = this.aesInlndTrnsPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCtrlPfxCtnt = this.cgoCtrlPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aXptNo1 = this.b13aXptNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndrRefCtnt = this.ndrRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaDt = this.aesPtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnDt = this.aesDwnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g7EdiPfxCtnt = this.g7EdiPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaPfxCtnt = this.aesPtaPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxNo = this.cneeTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSmryRptNo = this.mfSmryRptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxCpyDescFlg = this.cneeTaxCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesTpCd = this.aesTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckTpCd = this.divdPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxCpyDescFlg = this.shprTaxCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuNo = this.aesPtuNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgt = this.divdWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxNo = this.ntfyTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgtUtCd = this.divdWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndrRefPfxCtnt = this.ndrRefPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g7EdiNo2 = this.g7EdiNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aXptPfxCtnt = this.b13aXptPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g7EdiNo1 = this.g7EdiNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaNo1 = this.aesPtaNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaNo2 = this.aesPtaNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnPfxCtnt = this.aesDwnPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpSeq = this.xptImpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckQty = this.samPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idXptNo = this.idXptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIecCpyDescFlg = this.idaIecCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedTpCd = this.caedTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxCpyDescFlg = this.ntfyTaxCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdSeq = this.divdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSmryRptPfxCtnt = this.mfSmryRptPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclCpyDescFlg = this.brzDeclCpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idDeclCd = this.idDeclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzCmdtCd = this.brzCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idXptNoIssDt = this.idXptNoIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnNo = this.aesDwnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclNo = this.brzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfWgt = this.mfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idOfcCd = this.idOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedPfxCtnt = this.caedPfxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucrNo = this.ucrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdFlg = this.divdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCtrlNo = this.cgoCtrlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesInlndTrnsNo = this.aesInlndTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mxShprTaxId = this.mxShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mxCneeTaxId = this.mxCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mxNtfyTaxId = this.mxNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trShprTaxId = this.trShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trCneeTaxId = this.trCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trNtfyTaxId = this.trNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilShprTaxId = this.ilShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilCneeTaxId = this.ilCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilNtfyTaxId = this.ilNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbShprTaxId = this.lbShprTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbCneeTaxId = this.lbCneeTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbNtfyTaxId = this.lbNtfyTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrClssTpCd = this.entrClssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrClssRmk = this.entrClssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesTpPrnFlg = this.aesTpPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
