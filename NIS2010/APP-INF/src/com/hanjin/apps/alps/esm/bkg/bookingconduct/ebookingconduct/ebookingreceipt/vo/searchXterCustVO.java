/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : searchXterCustVO.java
*@FileTitle : searchXterCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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

public class searchXterCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchXterCustVO> models = new ArrayList<searchXterCustVO>();
	
	/* Column Info */
	private String nfCustCtyNm = null;
	/* Column Info */
	private String agmtActCntCd = null;
	/* Column Info */
	private String exCustLglEngNm = null;
	/* Column Info */
	private String nfCustAddr = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String shEoriNo = null;
	/* Column Info */
	private String cnCustZipId = null;
	/* Column Info */
	private String cnCustToOrdFlg = null;
	/* Column Info */
	private String cnCustSeq = null;
	/* Column Info */
	private String nfCustEml = null;
	/* Column Info */
	private String anCustLglEngNm = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String nfCustFaxNo = null;
	/* Column Info */
	private String nfEurCstmsPstId = null;
	/* Column Info */
	private String anCustAddr = null;
	/* Column Info */
	private String exCustCntCd = null;
	/* Column Info */
	private String cnEurCstmsPstId = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String cnCntSeq = null;
	/* Column Info */
	private String nfCntSeq = null;
	/* Column Info */
	private String anCntSeq = null;
	/* Column Info */
	private String cnCustSteCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String anCustCntCd = null;
	/* Column Info */
	private String nfCustCntCd = null;
	/* Column Info */
	private String shCntSeq = null;
	/* Column Info */
	private String nfCustSeq = null;
	/* Column Info */
	private String exCustSeq = null;
	/* Column Info */
	private String brCustAddr = null;
	/* Column Info */
	private String ffCustAddr = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String shEurCstmsPstId = null;
	/* Column Info */
	private String cnCustEml = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String cbrFaxNo1 = null;
	/* Column Info */
	private String shCustCtyNm = null;
	/* Column Info */
	private String cbrFaxNo2 = null;
	/* Column Info */
	private String shCustSteCd = null;
	/* Column Info */
	private String cnCustLglEngNm = null;
	/* Column Info */
	private String shKrCstmsCustTpCd = null;
	/* Column Info */
	private String exCustNm = null;
	/* Column Info */
	private String cnCustFaxNo = null;
	/* Column Info */
	private String cbrFaxNo3 = null;
	/* Column Info */
	private String nfCustSteCd = null;
	/* Column Info */
	private String ffCustNm = null;
	/* Column Info */
	private String anCustSeq = null;
	/* Column Info */
	private String cnEurCstmsStNm = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String ffCustCntCd = null;
	/* Column Info */
	private String ffCustSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String anCustNm = null;
	/* Column Info */
	private String shEurCstmsStNm = null;
	/* Column Info */
	private String orgCntNm = null;
	/* Column Info */
	private String cnCstmsDeclCntCd = null;
	/* Column Info */
	private String nfEoriNo = null;
	/* Column Info */
	private String brCustNm = null;
	/* Column Info */
	private String cnCustAddr = null;
	/* Column Info */
	private String agmtActCustSeq = null;
	/* Column Info */
	private String shCustSeq = null;
	/* Column Info */
	private String cnEoriNo = null;
	/* Column Info */
	private String shCustZipId = null;
	/* Column Info */
	private String cnCustCtyNm = null;
	/* Column Info */
	private String shCstmsDeclCntCd = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String ffCustLglEngNm = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String shCustAddr = null;
	/* Column Info */
	private String cbrCustNm = null;
	/* Column Info */
	private String nfCustZipId = null;
	/* Column Info */
	private String cnIecFax = null;
	/* Column Info */
	private String brCustCntCd = null;
	/* Column Info */
	private String shCustLglEngNm = null;
	/* Column Info */
	private String nfCstmsDeclCntCd = null;
	/* Column Info */
	private String cnCustCntCd = null;
	/* Column Info */
	private String nfCustLglEngNm = null;
	/* Column Info */
	private String nfEurCstmsStNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public searchXterCustVO() {}

	public searchXterCustVO(String ibflag, String pagerows, String xterRqstNo, String xterSndrId, String xterRqstSeq, String shCustCntCd, String shCustSeq, String shCntSeq, String shCustNm, String shCustLglEngNm, String shCustAddr, String shCustCtyNm, String shCustSteCd, String shCstmsDeclCntCd, String shCustZipId, String shEoriNo, String shEurCstmsPstId, String shEurCstmsStNm, String cnCustCntCd, String cnCustSeq, String cnCntSeq, String cnCustNm, String cnCustLglEngNm, String cnCustAddr, String cnCustCtyNm, String cnCustSteCd, String cnCustFaxNo, String cnCustEml, String cnCstmsDeclCntCd, String cnCustZipId, String cnEoriNo, String cnEurCstmsPstId, String cnEurCstmsStNm, String cnIecFax, String nfCustCntCd, String nfCustSeq, String nfCntSeq, String nfCustNm, String nfCustLglEngNm, String nfCustAddr, String nfCustCtyNm, String nfCustSteCd, String nfCstmsDeclCntCd, String nfCustZipId, String nfCustFaxNo, String nfCustEml, String nfEoriNo, String nfEurCstmsPstId, String nfEurCstmsStNm, String ffCustCntCd, String ffCustSeq, String ffCntSeq, String ffCustNm, String ffCustLglEngNm, String ffCustAddr, String anCustCntCd, String anCustSeq, String anCntSeq, String anCustNm, String anCustLglEngNm, String anCustAddr, String exCustCntCd, String exCustSeq, String exCustNm, String exCustLglEngNm, String brCustCntCd, String brCustNm, String brCustAddr, String shKrCstmsCustTpCd, String cnCustToOrdFlg, String rvisCntrCustTpCd, String cbrCustNm, String cbrFaxNo1, String cbrFaxNo2, String cbrFaxNo3, String orgCntNm, String agmtActCntCd, String agmtActCustSeq) {
		this.nfCustCtyNm = nfCustCtyNm;
		this.agmtActCntCd = agmtActCntCd;
		this.exCustLglEngNm = exCustLglEngNm;
		this.nfCustAddr = nfCustAddr;
		this.xterSndrId = xterSndrId;
		this.shEoriNo = shEoriNo;
		this.cnCustZipId = cnCustZipId;
		this.cnCustToOrdFlg = cnCustToOrdFlg;
		this.cnCustSeq = cnCustSeq;
		this.nfCustEml = nfCustEml;
		this.anCustLglEngNm = anCustLglEngNm;
		this.shCustNm = shCustNm;
		this.nfCustFaxNo = nfCustFaxNo;
		this.nfEurCstmsPstId = nfEurCstmsPstId;
		this.anCustAddr = anCustAddr;
		this.exCustCntCd = exCustCntCd;
		this.cnEurCstmsPstId = cnEurCstmsPstId;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.ffCntSeq = ffCntSeq;
		this.cnCntSeq = cnCntSeq;
		this.nfCntSeq = nfCntSeq;
		this.anCntSeq = anCntSeq;
		this.cnCustSteCd = cnCustSteCd;
		this.pagerows = pagerows;
		this.anCustCntCd = anCustCntCd;
		this.nfCustCntCd = nfCustCntCd;
		this.shCntSeq = shCntSeq;
		this.nfCustSeq = nfCustSeq;
		this.exCustSeq = exCustSeq;
		this.brCustAddr = brCustAddr;
		this.ffCustAddr = ffCustAddr;
		this.xterRqstSeq = xterRqstSeq;
		this.shEurCstmsPstId = shEurCstmsPstId;
		this.cnCustEml = cnCustEml;
		this.nfCustNm = nfCustNm;
		this.cbrFaxNo1 = cbrFaxNo1;
		this.shCustCtyNm = shCustCtyNm;
		this.cbrFaxNo2 = cbrFaxNo2;
		this.shCustSteCd = shCustSteCd;
		this.cnCustLglEngNm = cnCustLglEngNm;
		this.shKrCstmsCustTpCd = shKrCstmsCustTpCd;
		this.exCustNm = exCustNm;
		this.cnCustFaxNo = cnCustFaxNo;
		this.cbrFaxNo3 = cbrFaxNo3;
		this.nfCustSteCd = nfCustSteCd;
		this.ffCustNm = ffCustNm;
		this.anCustSeq = anCustSeq;
		this.cnEurCstmsStNm = cnEurCstmsStNm;
		this.cnCustNm = cnCustNm;
		this.ffCustCntCd = ffCustCntCd;
		this.ffCustSeq = ffCustSeq;
		this.ibflag = ibflag;
		this.anCustNm = anCustNm;
		this.shEurCstmsStNm = shEurCstmsStNm;
		this.orgCntNm = orgCntNm;
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
		this.nfEoriNo = nfEoriNo;
		this.brCustNm = brCustNm;
		this.cnCustAddr = cnCustAddr;
		this.agmtActCustSeq = agmtActCustSeq;
		this.shCustSeq = shCustSeq;
		this.cnEoriNo = cnEoriNo;
		this.shCustZipId = shCustZipId;
		this.cnCustCtyNm = cnCustCtyNm;
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
		this.xterRqstNo = xterRqstNo;
		this.ffCustLglEngNm = ffCustLglEngNm;
		this.shCustCntCd = shCustCntCd;
		this.shCustAddr = shCustAddr;
		this.cbrCustNm = cbrCustNm;
		this.nfCustZipId = nfCustZipId;
		this.cnIecFax = cnIecFax;
		this.brCustCntCd = brCustCntCd;
		this.shCustLglEngNm = shCustLglEngNm;
		this.nfCstmsDeclCntCd = nfCstmsDeclCntCd;
		this.cnCustCntCd = cnCustCntCd;
		this.nfCustLglEngNm = nfCustLglEngNm;
		this.nfEurCstmsStNm = nfEurCstmsStNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nf_cust_cty_nm", getNfCustCtyNm());
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());
		this.hashColumns.put("ex_cust_lgl_eng_nm", getExCustLglEngNm());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("sh_eori_no", getShEoriNo());
		this.hashColumns.put("cn_cust_zip_id", getCnCustZipId());
		this.hashColumns.put("cn_cust_to_ord_flg", getCnCustToOrdFlg());
		this.hashColumns.put("cn_cust_seq", getCnCustSeq());
		this.hashColumns.put("nf_cust_eml", getNfCustEml());
		this.hashColumns.put("an_cust_lgl_eng_nm", getAnCustLglEngNm());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("nf_cust_fax_no", getNfCustFaxNo());
		this.hashColumns.put("nf_eur_cstms_pst_id", getNfEurCstmsPstId());
		this.hashColumns.put("an_cust_addr", getAnCustAddr());
		this.hashColumns.put("ex_cust_cnt_cd", getExCustCntCd());
		this.hashColumns.put("cn_eur_cstms_pst_id", getCnEurCstmsPstId());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("cn_cnt_seq", getCnCntSeq());
		this.hashColumns.put("nf_cnt_seq", getNfCntSeq());
		this.hashColumns.put("an_cnt_seq", getAnCntSeq());
		this.hashColumns.put("cn_cust_ste_cd", getCnCustSteCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("an_cust_cnt_cd", getAnCustCntCd());
		this.hashColumns.put("nf_cust_cnt_cd", getNfCustCntCd());
		this.hashColumns.put("sh_cnt_seq", getShCntSeq());
		this.hashColumns.put("nf_cust_seq", getNfCustSeq());
		this.hashColumns.put("ex_cust_seq", getExCustSeq());
		this.hashColumns.put("br_cust_addr", getBrCustAddr());
		this.hashColumns.put("ff_cust_addr", getFfCustAddr());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("sh_eur_cstms_pst_id", getShEurCstmsPstId());
		this.hashColumns.put("cn_cust_eml", getCnCustEml());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("cbr_fax_no1", getCbrFaxNo1());
		this.hashColumns.put("sh_cust_cty_nm", getShCustCtyNm());
		this.hashColumns.put("cbr_fax_no2", getCbrFaxNo2());
		this.hashColumns.put("sh_cust_ste_cd", getShCustSteCd());
		this.hashColumns.put("cn_cust_lgl_eng_nm", getCnCustLglEngNm());
		this.hashColumns.put("sh_kr_cstms_cust_tp_cd", getShKrCstmsCustTpCd());
		this.hashColumns.put("ex_cust_nm", getExCustNm());
		this.hashColumns.put("cn_cust_fax_no", getCnCustFaxNo());
		this.hashColumns.put("cbr_fax_no3", getCbrFaxNo3());
		this.hashColumns.put("nf_cust_ste_cd", getNfCustSteCd());
		this.hashColumns.put("ff_cust_nm", getFfCustNm());
		this.hashColumns.put("an_cust_seq", getAnCustSeq());
		this.hashColumns.put("cn_eur_cstms_st_nm", getCnEurCstmsStNm());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("ff_cust_cnt_cd", getFfCustCntCd());
		this.hashColumns.put("ff_cust_seq", getFfCustSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("sh_eur_cstms_st_nm", getShEurCstmsStNm());
		this.hashColumns.put("org_cnt_nm", getOrgCntNm());
		this.hashColumns.put("cn_cstms_decl_cnt_cd", getCnCstmsDeclCntCd());
		this.hashColumns.put("nf_eori_no", getNfEoriNo());
		this.hashColumns.put("br_cust_nm", getBrCustNm());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("agmt_act_cust_seq", getAgmtActCustSeq());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("cn_eori_no", getCnEoriNo());
		this.hashColumns.put("sh_cust_zip_id", getShCustZipId());
		this.hashColumns.put("cn_cust_cty_nm", getCnCustCtyNm());
		this.hashColumns.put("sh_cstms_decl_cnt_cd", getShCstmsDeclCntCd());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("ff_cust_lgl_eng_nm", getFfCustLglEngNm());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("cbr_cust_nm", getCbrCustNm());
		this.hashColumns.put("nf_cust_zip_id", getNfCustZipId());
		this.hashColumns.put("cn_iec_fax", getCnIecFax());
		this.hashColumns.put("br_cust_cnt_cd", getBrCustCntCd());
		this.hashColumns.put("sh_cust_lgl_eng_nm", getShCustLglEngNm());
		this.hashColumns.put("nf_cstms_decl_cnt_cd", getNfCstmsDeclCntCd());
		this.hashColumns.put("cn_cust_cnt_cd", getCnCustCntCd());
		this.hashColumns.put("nf_cust_lgl_eng_nm", getNfCustLglEngNm());
		this.hashColumns.put("nf_eur_cstms_st_nm", getNfEurCstmsStNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nf_cust_cty_nm", "nfCustCtyNm");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("ex_cust_lgl_eng_nm", "exCustLglEngNm");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("sh_eori_no", "shEoriNo");
		this.hashFields.put("cn_cust_zip_id", "cnCustZipId");
		this.hashFields.put("cn_cust_to_ord_flg", "cnCustToOrdFlg");
		this.hashFields.put("cn_cust_seq", "cnCustSeq");
		this.hashFields.put("nf_cust_eml", "nfCustEml");
		this.hashFields.put("an_cust_lgl_eng_nm", "anCustLglEngNm");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("nf_cust_fax_no", "nfCustFaxNo");
		this.hashFields.put("nf_eur_cstms_pst_id", "nfEurCstmsPstId");
		this.hashFields.put("an_cust_addr", "anCustAddr");
		this.hashFields.put("ex_cust_cnt_cd", "exCustCntCd");
		this.hashFields.put("cn_eur_cstms_pst_id", "cnEurCstmsPstId");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("cn_cnt_seq", "cnCntSeq");
		this.hashFields.put("nf_cnt_seq", "nfCntSeq");
		this.hashFields.put("an_cnt_seq", "anCntSeq");
		this.hashFields.put("cn_cust_ste_cd", "cnCustSteCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("an_cust_cnt_cd", "anCustCntCd");
		this.hashFields.put("nf_cust_cnt_cd", "nfCustCntCd");
		this.hashFields.put("sh_cnt_seq", "shCntSeq");
		this.hashFields.put("nf_cust_seq", "nfCustSeq");
		this.hashFields.put("ex_cust_seq", "exCustSeq");
		this.hashFields.put("br_cust_addr", "brCustAddr");
		this.hashFields.put("ff_cust_addr", "ffCustAddr");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("sh_eur_cstms_pst_id", "shEurCstmsPstId");
		this.hashFields.put("cn_cust_eml", "cnCustEml");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("cbr_fax_no1", "cbrFaxNo1");
		this.hashFields.put("sh_cust_cty_nm", "shCustCtyNm");
		this.hashFields.put("cbr_fax_no2", "cbrFaxNo2");
		this.hashFields.put("sh_cust_ste_cd", "shCustSteCd");
		this.hashFields.put("cn_cust_lgl_eng_nm", "cnCustLglEngNm");
		this.hashFields.put("sh_kr_cstms_cust_tp_cd", "shKrCstmsCustTpCd");
		this.hashFields.put("ex_cust_nm", "exCustNm");
		this.hashFields.put("cn_cust_fax_no", "cnCustFaxNo");
		this.hashFields.put("cbr_fax_no3", "cbrFaxNo3");
		this.hashFields.put("nf_cust_ste_cd", "nfCustSteCd");
		this.hashFields.put("ff_cust_nm", "ffCustNm");
		this.hashFields.put("an_cust_seq", "anCustSeq");
		this.hashFields.put("cn_eur_cstms_st_nm", "cnEurCstmsStNm");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("ff_cust_cnt_cd", "ffCustCntCd");
		this.hashFields.put("ff_cust_seq", "ffCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("sh_eur_cstms_st_nm", "shEurCstmsStNm");
		this.hashFields.put("org_cnt_nm", "orgCntNm");
		this.hashFields.put("cn_cstms_decl_cnt_cd", "cnCstmsDeclCntCd");
		this.hashFields.put("nf_eori_no", "nfEoriNo");
		this.hashFields.put("br_cust_nm", "brCustNm");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("agmt_act_cust_seq", "agmtActCustSeq");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("cn_eori_no", "cnEoriNo");
		this.hashFields.put("sh_cust_zip_id", "shCustZipId");
		this.hashFields.put("cn_cust_cty_nm", "cnCustCtyNm");
		this.hashFields.put("sh_cstms_decl_cnt_cd", "shCstmsDeclCntCd");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("ff_cust_lgl_eng_nm", "ffCustLglEngNm");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("cbr_cust_nm", "cbrCustNm");
		this.hashFields.put("nf_cust_zip_id", "nfCustZipId");
		this.hashFields.put("cn_iec_fax", "cnIecFax");
		this.hashFields.put("br_cust_cnt_cd", "brCustCntCd");
		this.hashFields.put("sh_cust_lgl_eng_nm", "shCustLglEngNm");
		this.hashFields.put("nf_cstms_decl_cnt_cd", "nfCstmsDeclCntCd");
		this.hashFields.put("cn_cust_cnt_cd", "cnCustCntCd");
		this.hashFields.put("nf_cust_lgl_eng_nm", "nfCustLglEngNm");
		this.hashFields.put("nf_eur_cstms_st_nm", "nfEurCstmsStNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nfCustCtyNm
	 */
	public String getNfCustCtyNm() {
		return this.nfCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return agmtActCntCd
	 */
	public String getAgmtActCntCd() {
		return this.agmtActCntCd;
	}
	
	/**
	 * Column Info
	 * @return exCustLglEngNm
	 */
	public String getExCustLglEngNm() {
		return this.exCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return nfCustAddr
	 */
	public String getNfCustAddr() {
		return this.nfCustAddr;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return shEoriNo
	 */
	public String getShEoriNo() {
		return this.shEoriNo;
	}
	
	/**
	 * Column Info
	 * @return cnCustZipId
	 */
	public String getCnCustZipId() {
		return this.cnCustZipId;
	}
	
	/**
	 * Column Info
	 * @return cnCustToOrdFlg
	 */
	public String getCnCustToOrdFlg() {
		return this.cnCustToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return cnCustSeq
	 */
	public String getCnCustSeq() {
		return this.cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @return nfCustEml
	 */
	public String getNfCustEml() {
		return this.nfCustEml;
	}
	
	/**
	 * Column Info
	 * @return anCustLglEngNm
	 */
	public String getAnCustLglEngNm() {
		return this.anCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return nfCustFaxNo
	 */
	public String getNfCustFaxNo() {
		return this.nfCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return nfEurCstmsPstId
	 */
	public String getNfEurCstmsPstId() {
		return this.nfEurCstmsPstId;
	}
	
	/**
	 * Column Info
	 * @return anCustAddr
	 */
	public String getAnCustAddr() {
		return this.anCustAddr;
	}
	
	/**
	 * Column Info
	 * @return exCustCntCd
	 */
	public String getExCustCntCd() {
		return this.exCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cnEurCstmsPstId
	 */
	public String getCnEurCstmsPstId() {
		return this.cnEurCstmsPstId;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
	}
	
	/**
	 * Column Info
	 * @return cnCntSeq
	 */
	public String getCnCntSeq() {
		return this.cnCntSeq;
	}
	
	/**
	 * Column Info
	 * @return nfCntSeq
	 */
	public String getNfCntSeq() {
		return this.nfCntSeq;
	}
	
	/**
	 * Column Info
	 * @return anCntSeq
	 */
	public String getAnCntSeq() {
		return this.anCntSeq;
	}
	
	/**
	 * Column Info
	 * @return cnCustSteCd
	 */
	public String getCnCustSteCd() {
		return this.cnCustSteCd;
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
	 * @return anCustCntCd
	 */
	public String getAnCustCntCd() {
		return this.anCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustCntCd
	 */
	public String getNfCustCntCd() {
		return this.nfCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return shCntSeq
	 */
	public String getShCntSeq() {
		return this.shCntSeq;
	}
	
	/**
	 * Column Info
	 * @return nfCustSeq
	 */
	public String getNfCustSeq() {
		return this.nfCustSeq;
	}
	
	/**
	 * Column Info
	 * @return exCustSeq
	 */
	public String getExCustSeq() {
		return this.exCustSeq;
	}
	
	/**
	 * Column Info
	 * @return brCustAddr
	 */
	public String getBrCustAddr() {
		return this.brCustAddr;
	}
	
	/**
	 * Column Info
	 * @return ffCustAddr
	 */
	public String getFfCustAddr() {
		return this.ffCustAddr;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return shEurCstmsPstId
	 */
	public String getShEurCstmsPstId() {
		return this.shEurCstmsPstId;
	}
	
	/**
	 * Column Info
	 * @return cnCustEml
	 */
	public String getCnCustEml() {
		return this.cnCustEml;
	}
	
	/**
	 * Column Info
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
	}
	
	/**
	 * Column Info
	 * @return cbrFaxNo1
	 */
	public String getCbrFaxNo1() {
		return this.cbrFaxNo1;
	}
	
	/**
	 * Column Info
	 * @return shCustCtyNm
	 */
	public String getShCustCtyNm() {
		return this.shCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return cbrFaxNo2
	 */
	public String getCbrFaxNo2() {
		return this.cbrFaxNo2;
	}
	
	/**
	 * Column Info
	 * @return shCustSteCd
	 */
	public String getShCustSteCd() {
		return this.shCustSteCd;
	}
	
	/**
	 * Column Info
	 * @return cnCustLglEngNm
	 */
	public String getCnCustLglEngNm() {
		return this.cnCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return shKrCstmsCustTpCd
	 */
	public String getShKrCstmsCustTpCd() {
		return this.shKrCstmsCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return exCustNm
	 */
	public String getExCustNm() {
		return this.exCustNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustFaxNo
	 */
	public String getCnCustFaxNo() {
		return this.cnCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return cbrFaxNo3
	 */
	public String getCbrFaxNo3() {
		return this.cbrFaxNo3;
	}
	
	/**
	 * Column Info
	 * @return nfCustSteCd
	 */
	public String getNfCustSteCd() {
		return this.nfCustSteCd;
	}
	
	/**
	 * Column Info
	 * @return ffCustNm
	 */
	public String getFfCustNm() {
		return this.ffCustNm;
	}
	
	/**
	 * Column Info
	 * @return anCustSeq
	 */
	public String getAnCustSeq() {
		return this.anCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cnEurCstmsStNm
	 */
	public String getCnEurCstmsStNm() {
		return this.cnEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
	}
	
	/**
	 * Column Info
	 * @return ffCustCntCd
	 */
	public String getFfCustCntCd() {
		return this.ffCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ffCustSeq
	 */
	public String getFfCustSeq() {
		return this.ffCustSeq;
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
	 * @return anCustNm
	 */
	public String getAnCustNm() {
		return this.anCustNm;
	}
	
	/**
	 * Column Info
	 * @return shEurCstmsStNm
	 */
	public String getShEurCstmsStNm() {
		return this.shEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @return orgCntNm
	 */
	public String getOrgCntNm() {
		return this.orgCntNm;
	}
	
	/**
	 * Column Info
	 * @return cnCstmsDeclCntCd
	 */
	public String getCnCstmsDeclCntCd() {
		return this.cnCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return nfEoriNo
	 */
	public String getNfEoriNo() {
		return this.nfEoriNo;
	}
	
	/**
	 * Column Info
	 * @return brCustNm
	 */
	public String getBrCustNm() {
		return this.brCustNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustAddr
	 */
	public String getCnCustAddr() {
		return this.cnCustAddr;
	}
	
	/**
	 * Column Info
	 * @return agmtActCustSeq
	 */
	public String getAgmtActCustSeq() {
		return this.agmtActCustSeq;
	}
	
	/**
	 * Column Info
	 * @return shCustSeq
	 */
	public String getShCustSeq() {
		return this.shCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cnEoriNo
	 */
	public String getCnEoriNo() {
		return this.cnEoriNo;
	}
	
	/**
	 * Column Info
	 * @return shCustZipId
	 */
	public String getShCustZipId() {
		return this.shCustZipId;
	}
	
	/**
	 * Column Info
	 * @return cnCustCtyNm
	 */
	public String getCnCustCtyNm() {
		return this.cnCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return shCstmsDeclCntCd
	 */
	public String getShCstmsDeclCntCd() {
		return this.shCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return ffCustLglEngNm
	 */
	public String getFfCustLglEngNm() {
		return this.ffCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return shCustCntCd
	 */
	public String getShCustCntCd() {
		return this.shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return shCustAddr
	 */
	public String getShCustAddr() {
		return this.shCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cbrCustNm
	 */
	public String getCbrCustNm() {
		return this.cbrCustNm;
	}
	
	/**
	 * Column Info
	 * @return nfCustZipId
	 */
	public String getNfCustZipId() {
		return this.nfCustZipId;
	}
	
	/**
	 * Column Info
	 * @return cnIecFax
	 */
	public String getCnIecFax() {
		return this.cnIecFax;
	}
	
	/**
	 * Column Info
	 * @return brCustCntCd
	 */
	public String getBrCustCntCd() {
		return this.brCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return shCustLglEngNm
	 */
	public String getShCustLglEngNm() {
		return this.shCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return nfCstmsDeclCntCd
	 */
	public String getNfCstmsDeclCntCd() {
		return this.nfCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return cnCustCntCd
	 */
	public String getCnCustCntCd() {
		return this.cnCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustLglEngNm
	 */
	public String getNfCustLglEngNm() {
		return this.nfCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return nfEurCstmsStNm
	 */
	public String getNfEurCstmsStNm() {
		return this.nfEurCstmsStNm;
	}
	

	/**
	 * Column Info
	 * @param nfCustCtyNm
	 */
	public void setNfCustCtyNm(String nfCustCtyNm) {
		this.nfCustCtyNm = nfCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param agmtActCntCd
	 */
	public void setAgmtActCntCd(String agmtActCntCd) {
		this.agmtActCntCd = agmtActCntCd;
	}
	
	/**
	 * Column Info
	 * @param exCustLglEngNm
	 */
	public void setExCustLglEngNm(String exCustLglEngNm) {
		this.exCustLglEngNm = exCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param nfCustAddr
	 */
	public void setNfCustAddr(String nfCustAddr) {
		this.nfCustAddr = nfCustAddr;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param shEoriNo
	 */
	public void setShEoriNo(String shEoriNo) {
		this.shEoriNo = shEoriNo;
	}
	
	/**
	 * Column Info
	 * @param cnCustZipId
	 */
	public void setCnCustZipId(String cnCustZipId) {
		this.cnCustZipId = cnCustZipId;
	}
	
	/**
	 * Column Info
	 * @param cnCustToOrdFlg
	 */
	public void setCnCustToOrdFlg(String cnCustToOrdFlg) {
		this.cnCustToOrdFlg = cnCustToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param cnCustSeq
	 */
	public void setCnCustSeq(String cnCustSeq) {
		this.cnCustSeq = cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @param nfCustEml
	 */
	public void setNfCustEml(String nfCustEml) {
		this.nfCustEml = nfCustEml;
	}
	
	/**
	 * Column Info
	 * @param anCustLglEngNm
	 */
	public void setAnCustLglEngNm(String anCustLglEngNm) {
		this.anCustLglEngNm = anCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param nfCustFaxNo
	 */
	public void setNfCustFaxNo(String nfCustFaxNo) {
		this.nfCustFaxNo = nfCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param nfEurCstmsPstId
	 */
	public void setNfEurCstmsPstId(String nfEurCstmsPstId) {
		this.nfEurCstmsPstId = nfEurCstmsPstId;
	}
	
	/**
	 * Column Info
	 * @param anCustAddr
	 */
	public void setAnCustAddr(String anCustAddr) {
		this.anCustAddr = anCustAddr;
	}
	
	/**
	 * Column Info
	 * @param exCustCntCd
	 */
	public void setExCustCntCd(String exCustCntCd) {
		this.exCustCntCd = exCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cnEurCstmsPstId
	 */
	public void setCnEurCstmsPstId(String cnEurCstmsPstId) {
		this.cnEurCstmsPstId = cnEurCstmsPstId;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
	}
	
	/**
	 * Column Info
	 * @param cnCntSeq
	 */
	public void setCnCntSeq(String cnCntSeq) {
		this.cnCntSeq = cnCntSeq;
	}
	
	/**
	 * Column Info
	 * @param nfCntSeq
	 */
	public void setNfCntSeq(String nfCntSeq) {
		this.nfCntSeq = nfCntSeq;
	}
	
	/**
	 * Column Info
	 * @param anCntSeq
	 */
	public void setAnCntSeq(String anCntSeq) {
		this.anCntSeq = anCntSeq;
	}
	
	/**
	 * Column Info
	 * @param cnCustSteCd
	 */
	public void setCnCustSteCd(String cnCustSteCd) {
		this.cnCustSteCd = cnCustSteCd;
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
	 * @param anCustCntCd
	 */
	public void setAnCustCntCd(String anCustCntCd) {
		this.anCustCntCd = anCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustCntCd
	 */
	public void setNfCustCntCd(String nfCustCntCd) {
		this.nfCustCntCd = nfCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param shCntSeq
	 */
	public void setShCntSeq(String shCntSeq) {
		this.shCntSeq = shCntSeq;
	}
	
	/**
	 * Column Info
	 * @param nfCustSeq
	 */
	public void setNfCustSeq(String nfCustSeq) {
		this.nfCustSeq = nfCustSeq;
	}
	
	/**
	 * Column Info
	 * @param exCustSeq
	 */
	public void setExCustSeq(String exCustSeq) {
		this.exCustSeq = exCustSeq;
	}
	
	/**
	 * Column Info
	 * @param brCustAddr
	 */
	public void setBrCustAddr(String brCustAddr) {
		this.brCustAddr = brCustAddr;
	}
	
	/**
	 * Column Info
	 * @param ffCustAddr
	 */
	public void setFfCustAddr(String ffCustAddr) {
		this.ffCustAddr = ffCustAddr;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param shEurCstmsPstId
	 */
	public void setShEurCstmsPstId(String shEurCstmsPstId) {
		this.shEurCstmsPstId = shEurCstmsPstId;
	}
	
	/**
	 * Column Info
	 * @param cnCustEml
	 */
	public void setCnCustEml(String cnCustEml) {
		this.cnCustEml = cnCustEml;
	}
	
	/**
	 * Column Info
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
	}
	
	/**
	 * Column Info
	 * @param cbrFaxNo1
	 */
	public void setCbrFaxNo1(String cbrFaxNo1) {
		this.cbrFaxNo1 = cbrFaxNo1;
	}
	
	/**
	 * Column Info
	 * @param shCustCtyNm
	 */
	public void setShCustCtyNm(String shCustCtyNm) {
		this.shCustCtyNm = shCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param cbrFaxNo2
	 */
	public void setCbrFaxNo2(String cbrFaxNo2) {
		this.cbrFaxNo2 = cbrFaxNo2;
	}
	
	/**
	 * Column Info
	 * @param shCustSteCd
	 */
	public void setShCustSteCd(String shCustSteCd) {
		this.shCustSteCd = shCustSteCd;
	}
	
	/**
	 * Column Info
	 * @param cnCustLglEngNm
	 */
	public void setCnCustLglEngNm(String cnCustLglEngNm) {
		this.cnCustLglEngNm = cnCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param shKrCstmsCustTpCd
	 */
	public void setShKrCstmsCustTpCd(String shKrCstmsCustTpCd) {
		this.shKrCstmsCustTpCd = shKrCstmsCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param exCustNm
	 */
	public void setExCustNm(String exCustNm) {
		this.exCustNm = exCustNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustFaxNo
	 */
	public void setCnCustFaxNo(String cnCustFaxNo) {
		this.cnCustFaxNo = cnCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param cbrFaxNo3
	 */
	public void setCbrFaxNo3(String cbrFaxNo3) {
		this.cbrFaxNo3 = cbrFaxNo3;
	}
	
	/**
	 * Column Info
	 * @param nfCustSteCd
	 */
	public void setNfCustSteCd(String nfCustSteCd) {
		this.nfCustSteCd = nfCustSteCd;
	}
	
	/**
	 * Column Info
	 * @param ffCustNm
	 */
	public void setFfCustNm(String ffCustNm) {
		this.ffCustNm = ffCustNm;
	}
	
	/**
	 * Column Info
	 * @param anCustSeq
	 */
	public void setAnCustSeq(String anCustSeq) {
		this.anCustSeq = anCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cnEurCstmsStNm
	 */
	public void setCnEurCstmsStNm(String cnEurCstmsStNm) {
		this.cnEurCstmsStNm = cnEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param ffCustCntCd
	 */
	public void setFfCustCntCd(String ffCustCntCd) {
		this.ffCustCntCd = ffCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ffCustSeq
	 */
	public void setFfCustSeq(String ffCustSeq) {
		this.ffCustSeq = ffCustSeq;
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
	 * @param anCustNm
	 */
	public void setAnCustNm(String anCustNm) {
		this.anCustNm = anCustNm;
	}
	
	/**
	 * Column Info
	 * @param shEurCstmsStNm
	 */
	public void setShEurCstmsStNm(String shEurCstmsStNm) {
		this.shEurCstmsStNm = shEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @param orgCntNm
	 */
	public void setOrgCntNm(String orgCntNm) {
		this.orgCntNm = orgCntNm;
	}
	
	/**
	 * Column Info
	 * @param cnCstmsDeclCntCd
	 */
	public void setCnCstmsDeclCntCd(String cnCstmsDeclCntCd) {
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param nfEoriNo
	 */
	public void setNfEoriNo(String nfEoriNo) {
		this.nfEoriNo = nfEoriNo;
	}
	
	/**
	 * Column Info
	 * @param brCustNm
	 */
	public void setBrCustNm(String brCustNm) {
		this.brCustNm = brCustNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustAddr
	 */
	public void setCnCustAddr(String cnCustAddr) {
		this.cnCustAddr = cnCustAddr;
	}
	
	/**
	 * Column Info
	 * @param agmtActCustSeq
	 */
	public void setAgmtActCustSeq(String agmtActCustSeq) {
		this.agmtActCustSeq = agmtActCustSeq;
	}
	
	/**
	 * Column Info
	 * @param shCustSeq
	 */
	public void setShCustSeq(String shCustSeq) {
		this.shCustSeq = shCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cnEoriNo
	 */
	public void setCnEoriNo(String cnEoriNo) {
		this.cnEoriNo = cnEoriNo;
	}
	
	/**
	 * Column Info
	 * @param shCustZipId
	 */
	public void setShCustZipId(String shCustZipId) {
		this.shCustZipId = shCustZipId;
	}
	
	/**
	 * Column Info
	 * @param cnCustCtyNm
	 */
	public void setCnCustCtyNm(String cnCustCtyNm) {
		this.cnCustCtyNm = cnCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param shCstmsDeclCntCd
	 */
	public void setShCstmsDeclCntCd(String shCstmsDeclCntCd) {
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param ffCustLglEngNm
	 */
	public void setFfCustLglEngNm(String ffCustLglEngNm) {
		this.ffCustLglEngNm = ffCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param shCustCntCd
	 */
	public void setShCustCntCd(String shCustCntCd) {
		this.shCustCntCd = shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param shCustAddr
	 */
	public void setShCustAddr(String shCustAddr) {
		this.shCustAddr = shCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cbrCustNm
	 */
	public void setCbrCustNm(String cbrCustNm) {
		this.cbrCustNm = cbrCustNm;
	}
	
	/**
	 * Column Info
	 * @param nfCustZipId
	 */
	public void setNfCustZipId(String nfCustZipId) {
		this.nfCustZipId = nfCustZipId;
	}
	
	/**
	 * Column Info
	 * @param cnIecFax
	 */
	public void setCnIecFax(String cnIecFax) {
		this.cnIecFax = cnIecFax;
	}
	
	/**
	 * Column Info
	 * @param brCustCntCd
	 */
	public void setBrCustCntCd(String brCustCntCd) {
		this.brCustCntCd = brCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param shCustLglEngNm
	 */
	public void setShCustLglEngNm(String shCustLglEngNm) {
		this.shCustLglEngNm = shCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param nfCstmsDeclCntCd
	 */
	public void setNfCstmsDeclCntCd(String nfCstmsDeclCntCd) {
		this.nfCstmsDeclCntCd = nfCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param cnCustCntCd
	 */
	public void setCnCustCntCd(String cnCustCntCd) {
		this.cnCustCntCd = cnCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustLglEngNm
	 */
	public void setNfCustLglEngNm(String nfCustLglEngNm) {
		this.nfCustLglEngNm = nfCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param nfEurCstmsStNm
	 */
	public void setNfEurCstmsStNm(String nfEurCstmsStNm) {
		this.nfEurCstmsStNm = nfEurCstmsStNm;
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
		setNfCustCtyNm(JSPUtil.getParameter(request, prefix + "nf_cust_cty_nm", ""));
		setAgmtActCntCd(JSPUtil.getParameter(request, prefix + "agmt_act_cnt_cd", ""));
		setExCustLglEngNm(JSPUtil.getParameter(request, prefix + "ex_cust_lgl_eng_nm", ""));
		setNfCustAddr(JSPUtil.getParameter(request, prefix + "nf_cust_addr", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setShEoriNo(JSPUtil.getParameter(request, prefix + "sh_eori_no", ""));
		setCnCustZipId(JSPUtil.getParameter(request, prefix + "cn_cust_zip_id", ""));
		setCnCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cn_cust_to_ord_flg", ""));
		setCnCustSeq(JSPUtil.getParameter(request, prefix + "cn_cust_seq", ""));
		setNfCustEml(JSPUtil.getParameter(request, prefix + "nf_cust_eml", ""));
		setAnCustLglEngNm(JSPUtil.getParameter(request, prefix + "an_cust_lgl_eng_nm", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setNfCustFaxNo(JSPUtil.getParameter(request, prefix + "nf_cust_fax_no", ""));
		setNfEurCstmsPstId(JSPUtil.getParameter(request, prefix + "nf_eur_cstms_pst_id", ""));
		setAnCustAddr(JSPUtil.getParameter(request, prefix + "an_cust_addr", ""));
		setExCustCntCd(JSPUtil.getParameter(request, prefix + "ex_cust_cnt_cd", ""));
		setCnEurCstmsPstId(JSPUtil.getParameter(request, prefix + "cn_eur_cstms_pst_id", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setCnCntSeq(JSPUtil.getParameter(request, prefix + "cn_cnt_seq", ""));
		setNfCntSeq(JSPUtil.getParameter(request, prefix + "nf_cnt_seq", ""));
		setAnCntSeq(JSPUtil.getParameter(request, prefix + "an_cnt_seq", ""));
		setCnCustSteCd(JSPUtil.getParameter(request, prefix + "cn_cust_ste_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAnCustCntCd(JSPUtil.getParameter(request, prefix + "an_cust_cnt_cd", ""));
		setNfCustCntCd(JSPUtil.getParameter(request, prefix + "nf_cust_cnt_cd", ""));
		setShCntSeq(JSPUtil.getParameter(request, prefix + "sh_cnt_seq", ""));
		setNfCustSeq(JSPUtil.getParameter(request, prefix + "nf_cust_seq", ""));
		setExCustSeq(JSPUtil.getParameter(request, prefix + "ex_cust_seq", ""));
		setBrCustAddr(JSPUtil.getParameter(request, prefix + "br_cust_addr", ""));
		setFfCustAddr(JSPUtil.getParameter(request, prefix + "ff_cust_addr", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setShEurCstmsPstId(JSPUtil.getParameter(request, prefix + "sh_eur_cstms_pst_id", ""));
		setCnCustEml(JSPUtil.getParameter(request, prefix + "cn_cust_eml", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setCbrFaxNo1(JSPUtil.getParameter(request, prefix + "cbr_fax_no1", ""));
		setShCustCtyNm(JSPUtil.getParameter(request, prefix + "sh_cust_cty_nm", ""));
		setCbrFaxNo2(JSPUtil.getParameter(request, prefix + "cbr_fax_no2", ""));
		setShCustSteCd(JSPUtil.getParameter(request, prefix + "sh_cust_ste_cd", ""));
		setCnCustLglEngNm(JSPUtil.getParameter(request, prefix + "cn_cust_lgl_eng_nm", ""));
		setShKrCstmsCustTpCd(JSPUtil.getParameter(request, prefix + "sh_kr_cstms_cust_tp_cd", ""));
		setExCustNm(JSPUtil.getParameter(request, prefix + "ex_cust_nm", ""));
		setCnCustFaxNo(JSPUtil.getParameter(request, prefix + "cn_cust_fax_no", ""));
		setCbrFaxNo3(JSPUtil.getParameter(request, prefix + "cbr_fax_no3", ""));
		setNfCustSteCd(JSPUtil.getParameter(request, prefix + "nf_cust_ste_cd", ""));
		setFfCustNm(JSPUtil.getParameter(request, prefix + "ff_cust_nm", ""));
		setAnCustSeq(JSPUtil.getParameter(request, prefix + "an_cust_seq", ""));
		setCnEurCstmsStNm(JSPUtil.getParameter(request, prefix + "cn_eur_cstms_st_nm", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setFfCustCntCd(JSPUtil.getParameter(request, prefix + "ff_cust_cnt_cd", ""));
		setFfCustSeq(JSPUtil.getParameter(request, prefix + "ff_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAnCustNm(JSPUtil.getParameter(request, prefix + "an_cust_nm", ""));
		setShEurCstmsStNm(JSPUtil.getParameter(request, prefix + "sh_eur_cstms_st_nm", ""));
		setOrgCntNm(JSPUtil.getParameter(request, prefix + "org_cnt_nm", ""));
		setCnCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cn_cstms_decl_cnt_cd", ""));
		setNfEoriNo(JSPUtil.getParameter(request, prefix + "nf_eori_no", ""));
		setBrCustNm(JSPUtil.getParameter(request, prefix + "br_cust_nm", ""));
		setCnCustAddr(JSPUtil.getParameter(request, prefix + "cn_cust_addr", ""));
		setAgmtActCustSeq(JSPUtil.getParameter(request, prefix + "agmt_act_cust_seq", ""));
		setShCustSeq(JSPUtil.getParameter(request, prefix + "sh_cust_seq", ""));
		setCnEoriNo(JSPUtil.getParameter(request, prefix + "cn_eori_no", ""));
		setShCustZipId(JSPUtil.getParameter(request, prefix + "sh_cust_zip_id", ""));
		setCnCustCtyNm(JSPUtil.getParameter(request, prefix + "cn_cust_cty_nm", ""));
		setShCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "sh_cstms_decl_cnt_cd", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setFfCustLglEngNm(JSPUtil.getParameter(request, prefix + "ff_cust_lgl_eng_nm", ""));
		setShCustCntCd(JSPUtil.getParameter(request, prefix + "sh_cust_cnt_cd", ""));
		setShCustAddr(JSPUtil.getParameter(request, prefix + "sh_cust_addr", ""));
		setCbrCustNm(JSPUtil.getParameter(request, prefix + "cbr_cust_nm", ""));
		setNfCustZipId(JSPUtil.getParameter(request, prefix + "nf_cust_zip_id", ""));
		setCnIecFax(JSPUtil.getParameter(request, prefix + "cn_iec_fax", ""));
		setBrCustCntCd(JSPUtil.getParameter(request, prefix + "br_cust_cnt_cd", ""));
		setShCustLglEngNm(JSPUtil.getParameter(request, prefix + "sh_cust_lgl_eng_nm", ""));
		setNfCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "nf_cstms_decl_cnt_cd", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, prefix + "cn_cust_cnt_cd", ""));
		setNfCustLglEngNm(JSPUtil.getParameter(request, prefix + "nf_cust_lgl_eng_nm", ""));
		setNfEurCstmsStNm(JSPUtil.getParameter(request, prefix + "nf_eur_cstms_st_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchXterCustVO[]
	 */
	public searchXterCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchXterCustVO[]
	 */
	public searchXterCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchXterCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nfCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cty_nm", length));
			String[] agmtActCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cnt_cd", length));
			String[] exCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_lgl_eng_nm", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] shEoriNo = (JSPUtil.getParameter(request, prefix	+ "sh_eori_no", length));
			String[] cnCustZipId = (JSPUtil.getParameter(request, prefix	+ "cn_cust_zip_id", length));
			String[] cnCustToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cn_cust_to_ord_flg", length));
			String[] cnCustSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cust_seq", length));
			String[] nfCustEml = (JSPUtil.getParameter(request, prefix	+ "nf_cust_eml", length));
			String[] anCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_lgl_eng_nm", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] nfCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "nf_cust_fax_no", length));
			String[] nfEurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "nf_eur_cstms_pst_id", length));
			String[] anCustAddr = (JSPUtil.getParameter(request, prefix	+ "an_cust_addr", length));
			String[] exCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ex_cust_cnt_cd", length));
			String[] cnEurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "cn_eur_cstms_pst_id", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] cnCntSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cnt_seq", length));
			String[] nfCntSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cnt_seq", length));
			String[] anCntSeq = (JSPUtil.getParameter(request, prefix	+ "an_cnt_seq", length));
			String[] cnCustSteCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_ste_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] anCustCntCd = (JSPUtil.getParameter(request, prefix	+ "an_cust_cnt_cd", length));
			String[] nfCustCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt_cd", length));
			String[] shCntSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cnt_seq", length));
			String[] nfCustSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cust_seq", length));
			String[] exCustSeq = (JSPUtil.getParameter(request, prefix	+ "ex_cust_seq", length));
			String[] brCustAddr = (JSPUtil.getParameter(request, prefix	+ "br_cust_addr", length));
			String[] ffCustAddr = (JSPUtil.getParameter(request, prefix	+ "ff_cust_addr", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] shEurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "sh_eur_cstms_pst_id", length));
			String[] cnCustEml = (JSPUtil.getParameter(request, prefix	+ "cn_cust_eml", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] cbrFaxNo1 = (JSPUtil.getParameter(request, prefix	+ "cbr_fax_no1", length));
			String[] shCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cty_nm", length));
			String[] cbrFaxNo2 = (JSPUtil.getParameter(request, prefix	+ "cbr_fax_no2", length));
			String[] shCustSteCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_ste_cd", length));
			String[] cnCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_lgl_eng_nm", length));
			String[] shKrCstmsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "sh_kr_cstms_cust_tp_cd", length));
			String[] exCustNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_nm", length));
			String[] cnCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "cn_cust_fax_no", length));
			String[] cbrFaxNo3 = (JSPUtil.getParameter(request, prefix	+ "cbr_fax_no3", length));
			String[] nfCustSteCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_ste_cd", length));
			String[] ffCustNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_nm", length));
			String[] anCustSeq = (JSPUtil.getParameter(request, prefix	+ "an_cust_seq", length));
			String[] cnEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "cn_eur_cstms_st_nm", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] ffCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cust_cnt_cd", length));
			String[] ffCustSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] shEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "sh_eur_cstms_st_nm", length));
			String[] orgCntNm = (JSPUtil.getParameter(request, prefix	+ "org_cnt_nm", length));
			String[] cnCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cstms_decl_cnt_cd", length));
			String[] nfEoriNo = (JSPUtil.getParameter(request, prefix	+ "nf_eori_no", length));
			String[] brCustNm = (JSPUtil.getParameter(request, prefix	+ "br_cust_nm", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] agmtActCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cust_seq", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] cnEoriNo = (JSPUtil.getParameter(request, prefix	+ "cn_eori_no", length));
			String[] shCustZipId = (JSPUtil.getParameter(request, prefix	+ "sh_cust_zip_id", length));
			String[] cnCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cty_nm", length));
			String[] shCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cstms_decl_cnt_cd", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] ffCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_lgl_eng_nm", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] cbrCustNm = (JSPUtil.getParameter(request, prefix	+ "cbr_cust_nm", length));
			String[] nfCustZipId = (JSPUtil.getParameter(request, prefix	+ "nf_cust_zip_id", length));
			String[] cnIecFax = (JSPUtil.getParameter(request, prefix	+ "cn_iec_fax", length));
			String[] brCustCntCd = (JSPUtil.getParameter(request, prefix	+ "br_cust_cnt_cd", length));
			String[] shCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_lgl_eng_nm", length));
			String[] nfCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cstms_decl_cnt_cd", length));
			String[] cnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cnt_cd", length));
			String[] nfCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_lgl_eng_nm", length));
			String[] nfEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "nf_eur_cstms_st_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchXterCustVO();
				if (nfCustCtyNm[i] != null)
					model.setNfCustCtyNm(nfCustCtyNm[i]);
				if (agmtActCntCd[i] != null)
					model.setAgmtActCntCd(agmtActCntCd[i]);
				if (exCustLglEngNm[i] != null)
					model.setExCustLglEngNm(exCustLglEngNm[i]);
				if (nfCustAddr[i] != null)
					model.setNfCustAddr(nfCustAddr[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (shEoriNo[i] != null)
					model.setShEoriNo(shEoriNo[i]);
				if (cnCustZipId[i] != null)
					model.setCnCustZipId(cnCustZipId[i]);
				if (cnCustToOrdFlg[i] != null)
					model.setCnCustToOrdFlg(cnCustToOrdFlg[i]);
				if (cnCustSeq[i] != null)
					model.setCnCustSeq(cnCustSeq[i]);
				if (nfCustEml[i] != null)
					model.setNfCustEml(nfCustEml[i]);
				if (anCustLglEngNm[i] != null)
					model.setAnCustLglEngNm(anCustLglEngNm[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (nfCustFaxNo[i] != null)
					model.setNfCustFaxNo(nfCustFaxNo[i]);
				if (nfEurCstmsPstId[i] != null)
					model.setNfEurCstmsPstId(nfEurCstmsPstId[i]);
				if (anCustAddr[i] != null)
					model.setAnCustAddr(anCustAddr[i]);
				if (exCustCntCd[i] != null)
					model.setExCustCntCd(exCustCntCd[i]);
				if (cnEurCstmsPstId[i] != null)
					model.setCnEurCstmsPstId(cnEurCstmsPstId[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (cnCntSeq[i] != null)
					model.setCnCntSeq(cnCntSeq[i]);
				if (nfCntSeq[i] != null)
					model.setNfCntSeq(nfCntSeq[i]);
				if (anCntSeq[i] != null)
					model.setAnCntSeq(anCntSeq[i]);
				if (cnCustSteCd[i] != null)
					model.setCnCustSteCd(cnCustSteCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (anCustCntCd[i] != null)
					model.setAnCustCntCd(anCustCntCd[i]);
				if (nfCustCntCd[i] != null)
					model.setNfCustCntCd(nfCustCntCd[i]);
				if (shCntSeq[i] != null)
					model.setShCntSeq(shCntSeq[i]);
				if (nfCustSeq[i] != null)
					model.setNfCustSeq(nfCustSeq[i]);
				if (exCustSeq[i] != null)
					model.setExCustSeq(exCustSeq[i]);
				if (brCustAddr[i] != null)
					model.setBrCustAddr(brCustAddr[i]);
				if (ffCustAddr[i] != null)
					model.setFfCustAddr(ffCustAddr[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (shEurCstmsPstId[i] != null)
					model.setShEurCstmsPstId(shEurCstmsPstId[i]);
				if (cnCustEml[i] != null)
					model.setCnCustEml(cnCustEml[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (cbrFaxNo1[i] != null)
					model.setCbrFaxNo1(cbrFaxNo1[i]);
				if (shCustCtyNm[i] != null)
					model.setShCustCtyNm(shCustCtyNm[i]);
				if (cbrFaxNo2[i] != null)
					model.setCbrFaxNo2(cbrFaxNo2[i]);
				if (shCustSteCd[i] != null)
					model.setShCustSteCd(shCustSteCd[i]);
				if (cnCustLglEngNm[i] != null)
					model.setCnCustLglEngNm(cnCustLglEngNm[i]);
				if (shKrCstmsCustTpCd[i] != null)
					model.setShKrCstmsCustTpCd(shKrCstmsCustTpCd[i]);
				if (exCustNm[i] != null)
					model.setExCustNm(exCustNm[i]);
				if (cnCustFaxNo[i] != null)
					model.setCnCustFaxNo(cnCustFaxNo[i]);
				if (cbrFaxNo3[i] != null)
					model.setCbrFaxNo3(cbrFaxNo3[i]);
				if (nfCustSteCd[i] != null)
					model.setNfCustSteCd(nfCustSteCd[i]);
				if (ffCustNm[i] != null)
					model.setFfCustNm(ffCustNm[i]);
				if (anCustSeq[i] != null)
					model.setAnCustSeq(anCustSeq[i]);
				if (cnEurCstmsStNm[i] != null)
					model.setCnEurCstmsStNm(cnEurCstmsStNm[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (ffCustCntCd[i] != null)
					model.setFfCustCntCd(ffCustCntCd[i]);
				if (ffCustSeq[i] != null)
					model.setFfCustSeq(ffCustSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (anCustNm[i] != null)
					model.setAnCustNm(anCustNm[i]);
				if (shEurCstmsStNm[i] != null)
					model.setShEurCstmsStNm(shEurCstmsStNm[i]);
				if (orgCntNm[i] != null)
					model.setOrgCntNm(orgCntNm[i]);
				if (cnCstmsDeclCntCd[i] != null)
					model.setCnCstmsDeclCntCd(cnCstmsDeclCntCd[i]);
				if (nfEoriNo[i] != null)
					model.setNfEoriNo(nfEoriNo[i]);
				if (brCustNm[i] != null)
					model.setBrCustNm(brCustNm[i]);
				if (cnCustAddr[i] != null)
					model.setCnCustAddr(cnCustAddr[i]);
				if (agmtActCustSeq[i] != null)
					model.setAgmtActCustSeq(agmtActCustSeq[i]);
				if (shCustSeq[i] != null)
					model.setShCustSeq(shCustSeq[i]);
				if (cnEoriNo[i] != null)
					model.setCnEoriNo(cnEoriNo[i]);
				if (shCustZipId[i] != null)
					model.setShCustZipId(shCustZipId[i]);
				if (cnCustCtyNm[i] != null)
					model.setCnCustCtyNm(cnCustCtyNm[i]);
				if (shCstmsDeclCntCd[i] != null)
					model.setShCstmsDeclCntCd(shCstmsDeclCntCd[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (ffCustLglEngNm[i] != null)
					model.setFfCustLglEngNm(ffCustLglEngNm[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (shCustAddr[i] != null)
					model.setShCustAddr(shCustAddr[i]);
				if (cbrCustNm[i] != null)
					model.setCbrCustNm(cbrCustNm[i]);
				if (nfCustZipId[i] != null)
					model.setNfCustZipId(nfCustZipId[i]);
				if (cnIecFax[i] != null)
					model.setCnIecFax(cnIecFax[i]);
				if (brCustCntCd[i] != null)
					model.setBrCustCntCd(brCustCntCd[i]);
				if (shCustLglEngNm[i] != null)
					model.setShCustLglEngNm(shCustLglEngNm[i]);
				if (nfCstmsDeclCntCd[i] != null)
					model.setNfCstmsDeclCntCd(nfCstmsDeclCntCd[i]);
				if (cnCustCntCd[i] != null)
					model.setCnCustCntCd(cnCustCntCd[i]);
				if (nfCustLglEngNm[i] != null)
					model.setNfCustLglEngNm(nfCustLglEngNm[i]);
				if (nfEurCstmsStNm[i] != null)
					model.setNfEurCstmsStNm(nfEurCstmsStNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchXterCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchXterCustVO[]
	 */
	public searchXterCustVO[] getsearchXterCustVOs(){
		searchXterCustVO[] vos = (searchXterCustVO[])models.toArray(new searchXterCustVO[models.size()]);
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
		this.nfCustCtyNm = this.nfCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCntCd = this.agmtActCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustLglEngNm = this.exCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEoriNo = this.shEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustZipId = this.cnCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustToOrdFlg = this.cnCustToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSeq = this.cnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustEml = this.nfCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustLglEngNm = this.anCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustFaxNo = this.nfCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEurCstmsPstId = this.nfEurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustAddr = this.anCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustCntCd = this.exCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEurCstmsPstId = this.cnEurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCntSeq = this.cnCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCntSeq = this.nfCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCntSeq = this.anCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSteCd = this.cnCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustCntCd = this.anCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCntCd = this.nfCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCntSeq = this.shCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSeq = this.nfCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustSeq = this.exCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustAddr = this.brCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustAddr = this.ffCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEurCstmsPstId = this.shEurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustEml = this.cnCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrFaxNo1 = this.cbrFaxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCtyNm = this.shCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrFaxNo2 = this.cbrFaxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSteCd = this.shCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustLglEngNm = this.cnCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shKrCstmsCustTpCd = this.shKrCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustNm = this.exCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustFaxNo = this.cnCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrFaxNo3 = this.cbrFaxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSteCd = this.nfCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustNm = this.ffCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustSeq = this.anCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEurCstmsStNm = this.cnEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustCntCd = this.ffCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeq = this.ffCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEurCstmsStNm = this.shEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntNm = this.orgCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCstmsDeclCntCd = this.cnCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEoriNo = this.nfEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustNm = this.brCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCustSeq = this.agmtActCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEoriNo = this.cnEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustZipId = this.shCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCtyNm = this.cnCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCstmsDeclCntCd = this.shCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustLglEngNm = this.ffCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrCustNm = this.cbrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustZipId = this.nfCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnIecFax = this.cnIecFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustCntCd = this.brCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustLglEngNm = this.shCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCstmsDeclCntCd = this.nfCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCntCd = this.cnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustLglEngNm = this.nfCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEurCstmsStNm = this.nfEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
