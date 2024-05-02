/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : XterXptLicVO.java
*@FileTitle : XterXptLicVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.24 류대영 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2014.10.02 김태균 e-Commerce M&D 탭에서 Export Information 수정(ESM_BKG_0229_04)
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

public class XterXptLicVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterXptLicVO> models = new ArrayList<XterXptLicVO>();
	
	/* Column Info */
	private String g7EdiNo2 = null;
	/* Column Info */
	private String ptaFlg2 = null;
	/* Column Info */
	private String exptFlg2 = null;
	/* Column Info */
	private String nonDeclFlg2 = null;
	/* Column Info */
	private String caedCtnt2 = null;
	/* Column Info */
	private String aesPtaNo22 = null;
	/* Column Info */
	private String aesPtuDt2 = null;
	/* Column Info */
	private String b13aCtnt2 = null;
	/* Column Info */
	private String aesPtaDt2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String smryRptCtnt2 = null;
	/* Column Info */
	private String aesPtuNo2 = null;
	/* Column Info */
	private String aesFlg2 = null;
	/* Column Info */
	private String cneeTaxNo2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inlndTzCgoFlg2 = null;
	/* Column Info */
	private String aesDwnDt2 = null;
	/* Column Info */
	private String g7EdiFlg2 = null;
	/* Column Info */
	private String mnlInpFlg2 = null;
	/* Column Info */
	private String mnlInpCtnt2 = null;
	/* Column Info */
	private String inlndTzCgoCtnt2 = null;
	/* Column Info */
	private String b13aFlg2 = null;
	/* Column Info */
	private String smryRptFlg2 = null;
	/* Column Info */
	private String nonDeclCtnt2 = null;
	/* Column Info */
	private String ptuFlg2 = null;
	/* Column Info */
	private String ntfyTaxNo2 = null;
	/* Column Info */
	private String aesInlndTrnsNo2 = null;
	/* Column Info */
	private String aesExptId2 = null;
	/* Column Info */
	private String shprTaxNo2 = null;
	/* Column Info */
	private String dwnFlg2 = null;
	/* Column Info */
	private String aesPtaNo12 = null;
	/* Column Info */
	private String caedFlg2 = null;
	/* Column Info */
	private String aesDwnNo2 = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterXptLicVO() {}

	public XterXptLicVO(String ibflag, String pagerows, String shprTaxNo2, String cneeTaxNo2, String ntfyTaxNo2, String aesInlndTrnsNo2, String aesPtaNo12, String aesPtaNo22, String aesPtaDt2, String aesPtuNo2, String aesPtuDt2, String aesDwnNo2, String aesDwnDt2, String aesExptId2, String aesFlg2, String ptaFlg2, String ptuFlg2, String dwnFlg2, String exptFlg2, String caedFlg2, String g7EdiFlg2, String smryRptFlg2, String b13aFlg2, String inlndTzCgoFlg2, String mnlInpFlg2, String nonDeclFlg2, String caedCtnt2, String g7EdiNo2, String smryRptCtnt2, String b13aCtnt2, String inlndTzCgoCtnt2, String mnlInpCtnt2, String nonDeclCtnt2, String trShprTaxId, String trCneeTaxId, String trNtfyTaxId, String ilShprTaxId, String ilCneeTaxId, String ilNtfyTaxId, String lbShprTaxId, String lbCneeTaxId, String lbNtfyTaxId, String brShprTaxId, String brCneeTaxId, String brNtfyTaxId) {
		this.g7EdiNo2 = g7EdiNo2;
		this.ptaFlg2 = ptaFlg2;
		this.exptFlg2 = exptFlg2;
		this.nonDeclFlg2 = nonDeclFlg2;
		this.caedCtnt2 = caedCtnt2;
		this.aesPtaNo22 = aesPtaNo22;
		this.aesPtuDt2 = aesPtuDt2;
		this.b13aCtnt2 = b13aCtnt2;
		this.aesPtaDt2 = aesPtaDt2;
		this.pagerows = pagerows;
		this.smryRptCtnt2 = smryRptCtnt2;
		this.aesPtuNo2 = aesPtuNo2;
		this.aesFlg2 = aesFlg2;
		this.cneeTaxNo2 = cneeTaxNo2;
		this.ibflag = ibflag;
		this.inlndTzCgoFlg2 = inlndTzCgoFlg2;
		this.aesDwnDt2 = aesDwnDt2;
		this.g7EdiFlg2 = g7EdiFlg2;
		this.mnlInpFlg2 = mnlInpFlg2;
		this.mnlInpCtnt2 = mnlInpCtnt2;
		this.inlndTzCgoCtnt2 = inlndTzCgoCtnt2;
		this.b13aFlg2 = b13aFlg2;
		this.smryRptFlg2 = smryRptFlg2;
		this.nonDeclCtnt2 = nonDeclCtnt2;
		this.ptuFlg2 = ptuFlg2;
		this.ntfyTaxNo2 = ntfyTaxNo2;
		this.aesInlndTrnsNo2 = aesInlndTrnsNo2;
		this.aesExptId2 = aesExptId2;
		this.shprTaxNo2 = shprTaxNo2;
		this.dwnFlg2 = dwnFlg2;
		this.aesPtaNo12 = aesPtaNo12;
		this.caedFlg2 = caedFlg2;
		this.aesDwnNo2 = aesDwnNo2;
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
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("g7_edi_no2", getG7EdiNo2());
		this.hashColumns.put("pta_flg2", getPtaFlg2());
		this.hashColumns.put("expt_flg2", getExptFlg2());
		this.hashColumns.put("non_decl_flg2", getNonDeclFlg2());
		this.hashColumns.put("caed_ctnt2", getCaedCtnt2());
		this.hashColumns.put("aes_pta_no22", getAesPtaNo22());
		this.hashColumns.put("aes_ptu_dt2", getAesPtuDt2());
		this.hashColumns.put("b13a_ctnt2", getB13aCtnt2());
		this.hashColumns.put("aes_pta_dt2", getAesPtaDt2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("smry_rpt_ctnt2", getSmryRptCtnt2());
		this.hashColumns.put("aes_ptu_no2", getAesPtuNo2());
		this.hashColumns.put("aes_flg2", getAesFlg2());
		this.hashColumns.put("cnee_tax_no2", getCneeTaxNo2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inlnd_tz_cgo_flg2", getInlndTzCgoFlg2());
		this.hashColumns.put("aes_dwn_dt2", getAesDwnDt2());
		this.hashColumns.put("g7_edi_flg2", getG7EdiFlg2());
		this.hashColumns.put("mnl_inp_flg2", getMnlInpFlg2());
		this.hashColumns.put("mnl_inp_ctnt2", getMnlInpCtnt2());
		this.hashColumns.put("inlnd_tz_cgo_ctnt2", getInlndTzCgoCtnt2());
		this.hashColumns.put("b13a_flg2", getB13aFlg2());
		this.hashColumns.put("smry_rpt_flg2", getSmryRptFlg2());
		this.hashColumns.put("non_decl_ctnt2", getNonDeclCtnt2());
		this.hashColumns.put("ptu_flg2", getPtuFlg2());
		this.hashColumns.put("ntfy_tax_no2", getNtfyTaxNo2());
		this.hashColumns.put("aes_inlnd_trns_no2", getAesInlndTrnsNo2());
		this.hashColumns.put("aes_expt_id2", getAesExptId2());
		this.hashColumns.put("shpr_tax_no2", getShprTaxNo2());
		this.hashColumns.put("dwn_flg2", getDwnFlg2());
		this.hashColumns.put("aes_pta_no12", getAesPtaNo12());
		this.hashColumns.put("caed_flg2", getCaedFlg2());
		this.hashColumns.put("aes_dwn_no2", getAesDwnNo2());
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
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("g7_edi_no2", "g7EdiNo2");
		this.hashFields.put("pta_flg2", "ptaFlg2");
		this.hashFields.put("expt_flg2", "exptFlg2");
		this.hashFields.put("non_decl_flg2", "nonDeclFlg2");
		this.hashFields.put("caed_ctnt2", "caedCtnt2");
		this.hashFields.put("aes_pta_no22", "aesPtaNo22");
		this.hashFields.put("aes_ptu_dt2", "aesPtuDt2");
		this.hashFields.put("b13a_ctnt2", "b13aCtnt2");
		this.hashFields.put("aes_pta_dt2", "aesPtaDt2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("smry_rpt_ctnt2", "smryRptCtnt2");
		this.hashFields.put("aes_ptu_no2", "aesPtuNo2");
		this.hashFields.put("aes_flg2", "aesFlg2");
		this.hashFields.put("cnee_tax_no2", "cneeTaxNo2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inlnd_tz_cgo_flg2", "inlndTzCgoFlg2");
		this.hashFields.put("aes_dwn_dt2", "aesDwnDt2");
		this.hashFields.put("g7_edi_flg2", "g7EdiFlg2");
		this.hashFields.put("mnl_inp_flg2", "mnlInpFlg2");
		this.hashFields.put("mnl_inp_ctnt2", "mnlInpCtnt2");
		this.hashFields.put("inlnd_tz_cgo_ctnt2", "inlndTzCgoCtnt2");
		this.hashFields.put("b13a_flg2", "b13aFlg2");
		this.hashFields.put("smry_rpt_flg2", "smryRptFlg2");
		this.hashFields.put("non_decl_ctnt2", "nonDeclCtnt2");
		this.hashFields.put("ptu_flg2", "ptuFlg2");
		this.hashFields.put("ntfy_tax_no2", "ntfyTaxNo2");
		this.hashFields.put("aes_inlnd_trns_no2", "aesInlndTrnsNo2");
		this.hashFields.put("aes_expt_id2", "aesExptId2");
		this.hashFields.put("shpr_tax_no2", "shprTaxNo2");
		this.hashFields.put("dwn_flg2", "dwnFlg2");
		this.hashFields.put("aes_pta_no12", "aesPtaNo12");
		this.hashFields.put("caed_flg2", "caedFlg2");
		this.hashFields.put("aes_dwn_no2", "aesDwnNo2");
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
		return this.hashFields;
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
	 * @return ptaFlg2
	 */
	public String getPtaFlg2() {
		return this.ptaFlg2;
	}
	
	/**
	 * Column Info
	 * @return exptFlg2
	 */
	public String getExptFlg2() {
		return this.exptFlg2;
	}
	
	/**
	 * Column Info
	 * @return nonDeclFlg2
	 */
	public String getNonDeclFlg2() {
		return this.nonDeclFlg2;
	}
	
	/**
	 * Column Info
	 * @return caedCtnt2
	 */
	public String getCaedCtnt2() {
		return this.caedCtnt2;
	}
	
	/**
	 * Column Info
	 * @return aesPtaNo22
	 */
	public String getAesPtaNo22() {
		return this.aesPtaNo22;
	}
	
	/**
	 * Column Info
	 * @return aesPtuDt2
	 */
	public String getAesPtuDt2() {
		return this.aesPtuDt2;
	}
	
	/**
	 * Column Info
	 * @return b13aCtnt2
	 */
	public String getB13aCtnt2() {
		return this.b13aCtnt2;
	}
	
	/**
	 * Column Info
	 * @return aesPtaDt2
	 */
	public String getAesPtaDt2() {
		return this.aesPtaDt2;
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
	 * @return smryRptCtnt2
	 */
	public String getSmryRptCtnt2() {
		return this.smryRptCtnt2;
	}
	
	/**
	 * Column Info
	 * @return aesPtuNo2
	 */
	public String getAesPtuNo2() {
		return this.aesPtuNo2;
	}
	
	/**
	 * Column Info
	 * @return aesFlg2
	 */
	public String getAesFlg2() {
		return this.aesFlg2;
	}
	
	/**
	 * Column Info
	 * @return cneeTaxNo2
	 */
	public String getCneeTaxNo2() {
		return this.cneeTaxNo2;
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
	 * @return inlndTzCgoFlg2
	 */
	public String getInlndTzCgoFlg2() {
		return this.inlndTzCgoFlg2;
	}
	
	/**
	 * Column Info
	 * @return aesDwnDt2
	 */
	public String getAesDwnDt2() {
		return this.aesDwnDt2;
	}
	
	/**
	 * Column Info
	 * @return g7EdiFlg2
	 */
	public String getG7EdiFlg2() {
		return this.g7EdiFlg2;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg2
	 */
	public String getMnlInpFlg2() {
		return this.mnlInpFlg2;
	}
	
	/**
	 * Column Info
	 * @return mnlInpCtnt2
	 */
	public String getMnlInpCtnt2() {
		return this.mnlInpCtnt2;
	}
	
	/**
	 * Column Info
	 * @return inlndTzCgoCtnt2
	 */
	public String getInlndTzCgoCtnt2() {
		return this.inlndTzCgoCtnt2;
	}
	
	/**
	 * Column Info
	 * @return b13aFlg2
	 */
	public String getB13aFlg2() {
		return this.b13aFlg2;
	}
	
	/**
	 * Column Info
	 * @return smryRptFlg2
	 */
	public String getSmryRptFlg2() {
		return this.smryRptFlg2;
	}
	
	/**
	 * Column Info
	 * @return nonDeclCtnt2
	 */
	public String getNonDeclCtnt2() {
		return this.nonDeclCtnt2;
	}
	
	/**
	 * Column Info
	 * @return ptuFlg2
	 */
	public String getPtuFlg2() {
		return this.ptuFlg2;
	}
	
	/**
	 * Column Info
	 * @return ntfyTaxNo2
	 */
	public String getNtfyTaxNo2() {
		return this.ntfyTaxNo2;
	}
	
	/**
	 * Column Info
	 * @return aesInlndTrnsNo2
	 */
	public String getAesInlndTrnsNo2() {
		return this.aesInlndTrnsNo2;
	}
	
	/**
	 * Column Info
	 * @return aesExptId2
	 */
	public String getAesExptId2() {
		return this.aesExptId2;
	}
	
	/**
	 * Column Info
	 * @return shprTaxNo2
	 */
	public String getShprTaxNo2() {
		return this.shprTaxNo2;
	}
	
	/**
	 * Column Info
	 * @return dwnFlg2
	 */
	public String getDwnFlg2() {
		return this.dwnFlg2;
	}
	
	/**
	 * Column Info
	 * @return aesPtaNo12
	 */
	public String getAesPtaNo12() {
		return this.aesPtaNo12;
	}
	
	/**
	 * Column Info
	 * @return caedFlg2
	 */
	public String getCaedFlg2() {
		return this.caedFlg2;
	}
	
	/**
	 * Column Info
	 * @return aesDwnNo2
	 */
	public String getAesDwnNo2() {
		return this.aesDwnNo2;
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
	 * @param g7EdiNo2
	 */
	public void setG7EdiNo2(String g7EdiNo2) {
		this.g7EdiNo2 = g7EdiNo2;
	}
	
	/**
	 * Column Info
	 * @param ptaFlg2
	 */
	public void setPtaFlg2(String ptaFlg2) {
		this.ptaFlg2 = ptaFlg2;
	}
	
	/**
	 * Column Info
	 * @param exptFlg2
	 */
	public void setExptFlg2(String exptFlg2) {
		this.exptFlg2 = exptFlg2;
	}
	
	/**
	 * Column Info
	 * @param nonDeclFlg2
	 */
	public void setNonDeclFlg2(String nonDeclFlg2) {
		this.nonDeclFlg2 = nonDeclFlg2;
	}
	
	/**
	 * Column Info
	 * @param caedCtnt2
	 */
	public void setCaedCtnt2(String caedCtnt2) {
		this.caedCtnt2 = caedCtnt2;
	}
	
	/**
	 * Column Info
	 * @param aesPtaNo22
	 */
	public void setAesPtaNo22(String aesPtaNo22) {
		this.aesPtaNo22 = aesPtaNo22;
	}
	
	/**
	 * Column Info
	 * @param aesPtuDt2
	 */
	public void setAesPtuDt2(String aesPtuDt2) {
		this.aesPtuDt2 = aesPtuDt2;
	}
	
	/**
	 * Column Info
	 * @param b13aCtnt2
	 */
	public void setB13aCtnt2(String b13aCtnt2) {
		this.b13aCtnt2 = b13aCtnt2;
	}
	
	/**
	 * Column Info
	 * @param aesPtaDt2
	 */
	public void setAesPtaDt2(String aesPtaDt2) {
		this.aesPtaDt2 = aesPtaDt2;
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
	 * @param smryRptCtnt2
	 */
	public void setSmryRptCtnt2(String smryRptCtnt2) {
		this.smryRptCtnt2 = smryRptCtnt2;
	}
	
	/**
	 * Column Info
	 * @param aesPtuNo2
	 */
	public void setAesPtuNo2(String aesPtuNo2) {
		this.aesPtuNo2 = aesPtuNo2;
	}
	
	/**
	 * Column Info
	 * @param aesFlg2
	 */
	public void setAesFlg2(String aesFlg2) {
		this.aesFlg2 = aesFlg2;
	}
	
	/**
	 * Column Info
	 * @param cneeTaxNo2
	 */
	public void setCneeTaxNo2(String cneeTaxNo2) {
		this.cneeTaxNo2 = cneeTaxNo2;
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
	 * @param inlndTzCgoFlg2
	 */
	public void setInlndTzCgoFlg2(String inlndTzCgoFlg2) {
		this.inlndTzCgoFlg2 = inlndTzCgoFlg2;
	}
	
	/**
	 * Column Info
	 * @param aesDwnDt2
	 */
	public void setAesDwnDt2(String aesDwnDt2) {
		this.aesDwnDt2 = aesDwnDt2;
	}
	
	/**
	 * Column Info
	 * @param g7EdiFlg2
	 */
	public void setG7EdiFlg2(String g7EdiFlg2) {
		this.g7EdiFlg2 = g7EdiFlg2;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlg2
	 */
	public void setMnlInpFlg2(String mnlInpFlg2) {
		this.mnlInpFlg2 = mnlInpFlg2;
	}
	
	/**
	 * Column Info
	 * @param mnlInpCtnt2
	 */
	public void setMnlInpCtnt2(String mnlInpCtnt2) {
		this.mnlInpCtnt2 = mnlInpCtnt2;
	}
	
	/**
	 * Column Info
	 * @param inlndTzCgoCtnt2
	 */
	public void setInlndTzCgoCtnt2(String inlndTzCgoCtnt2) {
		this.inlndTzCgoCtnt2 = inlndTzCgoCtnt2;
	}
	
	/**
	 * Column Info
	 * @param b13aFlg2
	 */
	public void setB13aFlg2(String b13aFlg2) {
		this.b13aFlg2 = b13aFlg2;
	}
	
	/**
	 * Column Info
	 * @param smryRptFlg2
	 */
	public void setSmryRptFlg2(String smryRptFlg2) {
		this.smryRptFlg2 = smryRptFlg2;
	}
	
	/**
	 * Column Info
	 * @param nonDeclCtnt2
	 */
	public void setNonDeclCtnt2(String nonDeclCtnt2) {
		this.nonDeclCtnt2 = nonDeclCtnt2;
	}
	
	/**
	 * Column Info
	 * @param ptuFlg2
	 */
	public void setPtuFlg2(String ptuFlg2) {
		this.ptuFlg2 = ptuFlg2;
	}
	
	/**
	 * Column Info
	 * @param ntfyTaxNo2
	 */
	public void setNtfyTaxNo2(String ntfyTaxNo2) {
		this.ntfyTaxNo2 = ntfyTaxNo2;
	}
	
	/**
	 * Column Info
	 * @param aesInlndTrnsNo2
	 */
	public void setAesInlndTrnsNo2(String aesInlndTrnsNo2) {
		this.aesInlndTrnsNo2 = aesInlndTrnsNo2;
	}
	
	/**
	 * Column Info
	 * @param aesExptId2
	 */
	public void setAesExptId2(String aesExptId2) {
		this.aesExptId2 = aesExptId2;
	}
	
	/**
	 * Column Info
	 * @param shprTaxNo2
	 */
	public void setShprTaxNo2(String shprTaxNo2) {
		this.shprTaxNo2 = shprTaxNo2;
	}
	
	/**
	 * Column Info
	 * @param dwnFlg2
	 */
	public void setDwnFlg2(String dwnFlg2) {
		this.dwnFlg2 = dwnFlg2;
	}
	
	/**
	 * Column Info
	 * @param aesPtaNo12
	 */
	public void setAesPtaNo12(String aesPtaNo12) {
		this.aesPtaNo12 = aesPtaNo12;
	}
	
	/**
	 * Column Info
	 * @param caedFlg2
	 */
	public void setCaedFlg2(String caedFlg2) {
		this.caedFlg2 = caedFlg2;
	}
	
	/**
	 * Column Info
	 * @param aesDwnNo2
	 */
	public void setAesDwnNo2(String aesDwnNo2) {
		this.aesDwnNo2 = aesDwnNo2;
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
		setG7EdiNo2(JSPUtil.getParameter(request, prefix + "g7_edi_no2", ""));
		setPtaFlg2(JSPUtil.getParameter(request, prefix + "pta_flg2", ""));
		setExptFlg2(JSPUtil.getParameter(request, prefix + "expt_flg2", ""));
		setNonDeclFlg2(JSPUtil.getParameter(request, prefix + "non_decl_flg2", ""));
		setCaedCtnt2(JSPUtil.getParameter(request, prefix + "caed_ctnt2", ""));
		setAesPtaNo22(JSPUtil.getParameter(request, prefix + "aes_pta_no22", ""));
		setAesPtuDt2(JSPUtil.getParameter(request, prefix + "aes_ptu_dt2", ""));
		setB13aCtnt2(JSPUtil.getParameter(request, prefix + "b13a_ctnt2", ""));
		setAesPtaDt2(JSPUtil.getParameter(request, prefix + "aes_pta_dt2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSmryRptCtnt2(JSPUtil.getParameter(request, prefix + "smry_rpt_ctnt2", ""));
		setAesPtuNo2(JSPUtil.getParameter(request, prefix + "aes_ptu_no2", ""));
		setAesFlg2(JSPUtil.getParameter(request, prefix + "aes_flg2", ""));
		setCneeTaxNo2(JSPUtil.getParameter(request, prefix + "cnee_tax_no2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInlndTzCgoFlg2(JSPUtil.getParameter(request, prefix + "inlnd_tz_cgo_flg2", ""));
		setAesDwnDt2(JSPUtil.getParameter(request, prefix + "aes_dwn_dt2", ""));
		setG7EdiFlg2(JSPUtil.getParameter(request, prefix + "g7_edi_flg2", ""));
		setMnlInpFlg2(JSPUtil.getParameter(request, prefix + "mnl_inp_flg2", ""));
		setMnlInpCtnt2(JSPUtil.getParameter(request, prefix + "mnl_inp_ctnt2", ""));
		setInlndTzCgoCtnt2(JSPUtil.getParameter(request, prefix + "inlnd_tz_cgo_ctnt2", ""));
		setB13aFlg2(JSPUtil.getParameter(request, prefix + "b13a_flg2", ""));
		setSmryRptFlg2(JSPUtil.getParameter(request, prefix + "smry_rpt_flg2", ""));
		setNonDeclCtnt2(JSPUtil.getParameter(request, prefix + "non_decl_ctnt2", ""));
		setPtuFlg2(JSPUtil.getParameter(request, prefix + "ptu_flg2", ""));
		setNtfyTaxNo2(JSPUtil.getParameter(request, prefix + "ntfy_tax_no2", ""));
		setAesInlndTrnsNo2(JSPUtil.getParameter(request, prefix + "aes_inlnd_trns_no2", ""));
		setAesExptId2(JSPUtil.getParameter(request, prefix + "aes_expt_id2", ""));
		setShprTaxNo2(JSPUtil.getParameter(request, prefix + "shpr_tax_no2", ""));
		setDwnFlg2(JSPUtil.getParameter(request, prefix + "dwn_flg2", ""));
		setAesPtaNo12(JSPUtil.getParameter(request, prefix + "aes_pta_no12", ""));
		setCaedFlg2(JSPUtil.getParameter(request, prefix + "caed_flg2", ""));
		setAesDwnNo2(JSPUtil.getParameter(request, prefix + "aes_dwn_no2", ""));
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
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterXptLicVO[]
	 */
	public XterXptLicVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterXptLicVO[]
	 */
	public XterXptLicVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterXptLicVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] g7EdiNo2 = (JSPUtil.getParameter(request, prefix	+ "g7_edi_no2", length));
			String[] ptaFlg2 = (JSPUtil.getParameter(request, prefix	+ "pta_flg2", length));
			String[] exptFlg2 = (JSPUtil.getParameter(request, prefix	+ "expt_flg2", length));
			String[] nonDeclFlg2 = (JSPUtil.getParameter(request, prefix	+ "non_decl_flg2", length));
			String[] caedCtnt2 = (JSPUtil.getParameter(request, prefix	+ "caed_ctnt2", length));
			String[] aesPtaNo22 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_no22", length));
			String[] aesPtuDt2 = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_dt2", length));
			String[] b13aCtnt2 = (JSPUtil.getParameter(request, prefix	+ "b13a_ctnt2", length));
			String[] aesPtaDt2 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_dt2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] smryRptCtnt2 = (JSPUtil.getParameter(request, prefix	+ "smry_rpt_ctnt2", length));
			String[] aesPtuNo2 = (JSPUtil.getParameter(request, prefix	+ "aes_ptu_no2", length));
			String[] aesFlg2 = (JSPUtil.getParameter(request, prefix	+ "aes_flg2", length));
			String[] cneeTaxNo2 = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_no2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inlndTzCgoFlg2 = (JSPUtil.getParameter(request, prefix	+ "inlnd_tz_cgo_flg2", length));
			String[] aesDwnDt2 = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_dt2", length));
			String[] g7EdiFlg2 = (JSPUtil.getParameter(request, prefix	+ "g7_edi_flg2", length));
			String[] mnlInpFlg2 = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg2", length));
			String[] mnlInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_ctnt2", length));
			String[] inlndTzCgoCtnt2 = (JSPUtil.getParameter(request, prefix	+ "inlnd_tz_cgo_ctnt2", length));
			String[] b13aFlg2 = (JSPUtil.getParameter(request, prefix	+ "b13a_flg2", length));
			String[] smryRptFlg2 = (JSPUtil.getParameter(request, prefix	+ "smry_rpt_flg2", length));
			String[] nonDeclCtnt2 = (JSPUtil.getParameter(request, prefix	+ "non_decl_ctnt2", length));
			String[] ptuFlg2 = (JSPUtil.getParameter(request, prefix	+ "ptu_flg2", length));
			String[] ntfyTaxNo2 = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_no2", length));
			String[] aesInlndTrnsNo2 = (JSPUtil.getParameter(request, prefix	+ "aes_inlnd_trns_no2", length));
			String[] aesExptId2 = (JSPUtil.getParameter(request, prefix	+ "aes_expt_id2", length));
			String[] shprTaxNo2 = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_no2", length));
			String[] dwnFlg2 = (JSPUtil.getParameter(request, prefix	+ "dwn_flg2", length));
			String[] aesPtaNo12 = (JSPUtil.getParameter(request, prefix	+ "aes_pta_no12", length));
			String[] caedFlg2 = (JSPUtil.getParameter(request, prefix	+ "caed_flg2", length));
			String[] aesDwnNo2 = (JSPUtil.getParameter(request, prefix	+ "aes_dwn_no2", length));
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
			
			for (int i = 0; i < length; i++) {
				model = new XterXptLicVO();
				if (g7EdiNo2[i] != null)
					model.setG7EdiNo2(g7EdiNo2[i]);
				if (ptaFlg2[i] != null)
					model.setPtaFlg2(ptaFlg2[i]);
				if (exptFlg2[i] != null)
					model.setExptFlg2(exptFlg2[i]);
				if (nonDeclFlg2[i] != null)
					model.setNonDeclFlg2(nonDeclFlg2[i]);
				if (caedCtnt2[i] != null)
					model.setCaedCtnt2(caedCtnt2[i]);
				if (aesPtaNo22[i] != null)
					model.setAesPtaNo22(aesPtaNo22[i]);
				if (aesPtuDt2[i] != null)
					model.setAesPtuDt2(aesPtuDt2[i]);
				if (b13aCtnt2[i] != null)
					model.setB13aCtnt2(b13aCtnt2[i]);
				if (aesPtaDt2[i] != null)
					model.setAesPtaDt2(aesPtaDt2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (smryRptCtnt2[i] != null)
					model.setSmryRptCtnt2(smryRptCtnt2[i]);
				if (aesPtuNo2[i] != null)
					model.setAesPtuNo2(aesPtuNo2[i]);
				if (aesFlg2[i] != null)
					model.setAesFlg2(aesFlg2[i]);
				if (cneeTaxNo2[i] != null)
					model.setCneeTaxNo2(cneeTaxNo2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inlndTzCgoFlg2[i] != null)
					model.setInlndTzCgoFlg2(inlndTzCgoFlg2[i]);
				if (aesDwnDt2[i] != null)
					model.setAesDwnDt2(aesDwnDt2[i]);
				if (g7EdiFlg2[i] != null)
					model.setG7EdiFlg2(g7EdiFlg2[i]);
				if (mnlInpFlg2[i] != null)
					model.setMnlInpFlg2(mnlInpFlg2[i]);
				if (mnlInpCtnt2[i] != null)
					model.setMnlInpCtnt2(mnlInpCtnt2[i]);
				if (inlndTzCgoCtnt2[i] != null)
					model.setInlndTzCgoCtnt2(inlndTzCgoCtnt2[i]);
				if (b13aFlg2[i] != null)
					model.setB13aFlg2(b13aFlg2[i]);
				if (smryRptFlg2[i] != null)
					model.setSmryRptFlg2(smryRptFlg2[i]);
				if (nonDeclCtnt2[i] != null)
					model.setNonDeclCtnt2(nonDeclCtnt2[i]);
				if (ptuFlg2[i] != null)
					model.setPtuFlg2(ptuFlg2[i]);
				if (ntfyTaxNo2[i] != null)
					model.setNtfyTaxNo2(ntfyTaxNo2[i]);
				if (aesInlndTrnsNo2[i] != null)
					model.setAesInlndTrnsNo2(aesInlndTrnsNo2[i]);
				if (aesExptId2[i] != null)
					model.setAesExptId2(aesExptId2[i]);
				if (shprTaxNo2[i] != null)
					model.setShprTaxNo2(shprTaxNo2[i]);
				if (dwnFlg2[i] != null)
					model.setDwnFlg2(dwnFlg2[i]);
				if (aesPtaNo12[i] != null)
					model.setAesPtaNo12(aesPtaNo12[i]);
				if (caedFlg2[i] != null)
					model.setCaedFlg2(caedFlg2[i]);
				if (aesDwnNo2[i] != null)
					model.setAesDwnNo2(aesDwnNo2[i]);
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

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterXptLicVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterXptLicVO[]
	 */
	public XterXptLicVO[] getXterXptLicVOs(){
		XterXptLicVO[] vos = (XterXptLicVO[])models.toArray(new XterXptLicVO[models.size()]);
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
		this.g7EdiNo2 = this.g7EdiNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptaFlg2 = this.ptaFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFlg2 = this.exptFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDeclFlg2 = this.nonDeclFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedCtnt2 = this.caedCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaNo22 = this.aesPtaNo22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuDt2 = this.aesPtuDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aCtnt2 = this.b13aCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaDt2 = this.aesPtaDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smryRptCtnt2 = this.smryRptCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtuNo2 = this.aesPtuNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesFlg2 = this.aesFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxNo2 = this.cneeTaxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTzCgoFlg2 = this.inlndTzCgoFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnDt2 = this.aesDwnDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g7EdiFlg2 = this.g7EdiFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg2 = this.mnlInpFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpCtnt2 = this.mnlInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTzCgoCtnt2 = this.inlndTzCgoCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b13aFlg2 = this.b13aFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smryRptFlg2 = this.smryRptFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDeclCtnt2 = this.nonDeclCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptuFlg2 = this.ptuFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxNo2 = this.ntfyTaxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesInlndTrnsNo2 = this.aesInlndTrnsNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesExptId2 = this.aesExptId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxNo2 = this.shprTaxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwnFlg2 = this.dwnFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesPtaNo12 = this.aesPtaNo12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedFlg2 = this.caedFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesDwnNo2 = this.aesDwnNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
	}
}
