/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgXterCustVO.java
*@FileTitle : BkgXterCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.24 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgXterCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgXterCustVO> models = new ArrayList<BkgXterCustVO>();
	
	/* Column Info */
	private String cnCustFaxNo = null;
	/* Column Info */
	private String shKrCstmsCustTpCd = null;
	/* Column Info */
	private String ffCustLglEngNm = null;
	/* Column Info */
	private String brCustCntCd = null;
	/* Column Info */
	private String nfCustSteCd = null;
	/* Column Info */
	private String anCntSeq = null;
	/* Column Info */
	private String shCustCtyNm = null;
	/* Column Info */
	private String exCustNm = null;
	/* Column Info */
	private String cnCustAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnCustEml = null;
	/* Column Info */
	private String shCustSeq = null;
	/* Column Info */
	private String nfCustCntCd = null;
	/* Column Info */
	private String brCustNm = null;
	/* Column Info */
	private String anCustNm = null;
	/* Column Info */
	private String nfCustSeq = null;
	/* Column Info */
	private String anCustSeq = null;
	/* Column Info */
	private String cnCustLglEngNm = null;
	/* Column Info */
	private String nfCustZipId = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String nfCstmsDeclCntCd = null;
	/* Column Info */
	private String shCustZipId = null;
	/* Column Info */
	private String brCustAddr = null;
	/* Column Info */
	private String shCustLglEngNm = null;
	/* Column Info */
	private String nfCntSeq = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String nfCustLglEngNm = null;
	/* Column Info */
	private String cnCustZipId = null;
	/* Column Info */
	private String cnCustCtyNm = null;
	/* Column Info */
	private String cnCustCntCd = null;
	/* Column Info */
	private String ffCustSeq = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String anCustLglEngNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnCustSeq = null;
	/* Column Info */
	private String ffCustNm = null;
	/* Column Info */
	private String ffCustAddr = null;
	/* Column Info */
	private String shCntSeq = null;
	/* Column Info */
	private String shCstmsDeclCntCd = null;
	/* Column Info */
	private String anCustCntCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String nfCustCtyNm = null;
	/* Column Info */
	private String nfCustAddr = null;
	/* Column Info */
	private String cnCustToOrdFlg = null;
	/* Column Info */
	private String nfCustEml = null;
	/* Column Info */
	private String nfCustFaxNo = null;
	/* Column Info */
	private String shCustAddr = null;
	/* Column Info */
	private String cnCstmsDeclCntCd = null;
	/* Column Info */
	private String cnCustSteCd = null;
	/* Column Info */
	private String anCustAddr = null;
	/* Column Info */
	private String cnCntSeq = null;
	/* Column Info */
	private String ffCustCntCd = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String shCustSteCd = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String cbrCustNm = null;
	/* Column Info */
	private String cbrFaxNo1 = null;
	/* Column Info */
	private String cbrFaxNo2 = null;
	/* Column Info */
	private String cbrFaxNo3 = null;
	/* Column Info */
	private String orgCntNm = null;

	/* Column Info */
	private String shEurCstmsStNm = null;
	/* Column Info */
	private String shEurCstmsPstId = null;
	/* Column Info */
	private String shEoriNo = null;
	/* Column Info */
	private String cnEurCstmsStNm = null;
	/* Column Info */
	private String cnEurCstmsPstId = null;
	/* Column Info */
	private String cnEoriNo = null;
	/* Column Info */
	private String nfEurCstmsStNm = null;
	/* Column Info */
	private String nfEurCstmsPstId = null;
	/* Column Info */
	private String nfEoriNo = null;
	/* Column Info */
	private String shKrCstmsCustTpCd2 = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgXterCustVO() {}

	public BkgXterCustVO(String ibflag, String pagerows, String xterRqstNo, String xterRqstSeq, String shCustCntCd, String shCustSeq, String shCntSeq, String shCustNm, String shCustLglEngNm, String shCustAddr, String shCustCtyNm, String shCustSteCd, String shCstmsDeclCntCd, String shCustZipId, String cnCustCntCd, String cnCustSeq, String cnCntSeq, String cnCustNm, String cnCustLglEngNm, String cnCustAddr, String cnCustCtyNm, String cnCustSteCd, String cnCustFaxNo, String cnCustEml, String cnCstmsDeclCntCd, String cnCustZipId, String nfCustCntCd, String nfCustSeq, String nfCntSeq, String nfCustNm, String nfCustLglEngNm, String nfCustAddr, String nfCustCtyNm, String nfCustSteCd, String nfCstmsDeclCntCd, String nfCustZipId, String nfCustFaxNo, String nfCustEml, String ffCustCntCd, String ffCustSeq, String ffCntSeq, String ffCustNm, String ffCustLglEngNm, String ffCustAddr, String anCustCntCd, String anCustSeq, String anCntSeq, String anCustNm, String anCustLglEngNm, String anCustAddr, String exCustNm, String brCustCntCd, String brCustNm, String brCustAddr, String shKrCstmsCustTpCd, String shKrCstmsCustTpCd2, String cnCustToOrdFlg, String rvisCntrCustTpCd, String cbrCustNm, String cbrFaxNo1, String cbrFaxNo2, String cbrFaxNo3, String orgCntNm, String shEurCstmsStNm, String shEurCstmsPstId, String shEoriNo, String cnEurCstmsStNm, String cnEurCstmsPstId, String cnEoriNo, String nfEurCstmsStNm, String nfEurCstmsPstId, String nfEoriNo) {
		this.cnCustFaxNo = cnCustFaxNo;
		this.shKrCstmsCustTpCd = shKrCstmsCustTpCd;
		this.ffCustLglEngNm = ffCustLglEngNm;
		this.brCustCntCd = brCustCntCd;
		this.nfCustSteCd = nfCustSteCd;
		this.anCntSeq = anCntSeq;
		this.shCustCtyNm = shCustCtyNm;
		this.exCustNm = exCustNm;
		this.cnCustAddr = cnCustAddr;
		this.pagerows = pagerows;
		this.cnCustEml = cnCustEml;
		this.shCustSeq = shCustSeq;
		this.nfCustCntCd = nfCustCntCd;
		this.brCustNm = brCustNm;
		this.anCustNm = anCustNm;
		this.nfCustSeq = nfCustSeq;
		this.anCustSeq = anCustSeq;
		this.cnCustLglEngNm = cnCustLglEngNm;
		this.nfCustZipId = nfCustZipId;
		this.shCustNm = shCustNm;
		this.nfCstmsDeclCntCd = nfCstmsDeclCntCd;
		this.shCustZipId = shCustZipId;
		this.brCustAddr = brCustAddr;
		this.shCustLglEngNm = shCustLglEngNm;
		this.nfCntSeq = nfCntSeq;
		this.shCustCntCd = shCustCntCd;
		this.nfCustLglEngNm = nfCustLglEngNm;
		this.cnCustZipId = cnCustZipId;
		this.cnCustCtyNm = cnCustCtyNm;
		this.cnCustCntCd = cnCustCntCd;
		this.ffCustSeq = ffCustSeq;
		this.ffCntSeq = ffCntSeq;
		this.anCustLglEngNm = anCustLglEngNm;
		this.ibflag = ibflag;
		this.cnCustSeq = cnCustSeq;
		this.ffCustNm = ffCustNm;
		this.ffCustAddr = ffCustAddr;
		this.shCntSeq = shCntSeq;
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
		this.anCustCntCd = anCustCntCd;
		this.nfCustNm = nfCustNm;
		this.nfCustCtyNm = nfCustCtyNm;
		this.nfCustAddr = nfCustAddr;
		this.cnCustToOrdFlg = cnCustToOrdFlg;
		this.nfCustEml = nfCustEml;
		this.nfCustFaxNo = nfCustFaxNo;
		this.shCustAddr = shCustAddr;
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
		this.cnCustSteCd = cnCustSteCd;
		this.anCustAddr = anCustAddr;
		this.cnCntSeq = cnCntSeq;
		this.ffCustCntCd = ffCustCntCd;
		this.xterRqstSeq = xterRqstSeq;
		this.shCustSteCd = shCustSteCd;
		this.cnCustNm = cnCustNm;
		this.xterRqstNo = xterRqstNo;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.cbrCustNm = cbrCustNm;
		this.cbrFaxNo1 = cbrFaxNo1;
		this.cbrFaxNo2 = cbrFaxNo2;
		this.cbrFaxNo3 = cbrFaxNo3;
		this.orgCntNm = orgCntNm;
		this.shEurCstmsStNm = shEurCstmsStNm;
		this.shEurCstmsPstId = shEurCstmsPstId;
		this.shEoriNo = shEoriNo;
		this.cnEurCstmsStNm = cnEurCstmsStNm;
		this.cnEurCstmsPstId = cnEurCstmsPstId;
		this.cnEoriNo = cnEoriNo;
		this.nfEurCstmsStNm = nfEurCstmsStNm;
		this.nfEurCstmsPstId = nfEurCstmsPstId;
		this.nfEoriNo = nfEoriNo;
		this.shKrCstmsCustTpCd2 = shKrCstmsCustTpCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cn_cust_fax_no", getCnCustFaxNo());
		this.hashColumns.put("sh_kr_cstms_cust_tp_cd", getShKrCstmsCustTpCd());
		this.hashColumns.put("ff_cust_lgl_eng_nm", getFfCustLglEngNm());
		this.hashColumns.put("br_cust_cnt_cd", getBrCustCntCd());
		this.hashColumns.put("nf_cust_ste_cd", getNfCustSteCd());
		this.hashColumns.put("an_cnt_seq", getAnCntSeq());
		this.hashColumns.put("sh_cust_cty_nm", getShCustCtyNm());
		this.hashColumns.put("ex_cust_nm", getExCustNm());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cn_cust_eml", getCnCustEml());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("nf_cust_cnt_cd", getNfCustCntCd());
		this.hashColumns.put("br_cust_nm", getBrCustNm());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("nf_cust_seq", getNfCustSeq());
		this.hashColumns.put("an_cust_seq", getAnCustSeq());
		this.hashColumns.put("cn_cust_lgl_eng_nm", getCnCustLglEngNm());
		this.hashColumns.put("nf_cust_zip_id", getNfCustZipId());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("nf_cstms_decl_cnt_cd", getNfCstmsDeclCntCd());
		this.hashColumns.put("sh_cust_zip_id", getShCustZipId());
		this.hashColumns.put("br_cust_addr", getBrCustAddr());
		this.hashColumns.put("sh_cust_lgl_eng_nm", getShCustLglEngNm());
		this.hashColumns.put("nf_cnt_seq", getNfCntSeq());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("nf_cust_lgl_eng_nm", getNfCustLglEngNm());
		this.hashColumns.put("cn_cust_zip_id", getCnCustZipId());
		this.hashColumns.put("cn_cust_cty_nm", getCnCustCtyNm());
		this.hashColumns.put("cn_cust_cnt_cd", getCnCustCntCd());
		this.hashColumns.put("ff_cust_seq", getFfCustSeq());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("an_cust_lgl_eng_nm", getAnCustLglEngNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cn_cust_seq", getCnCustSeq());
		this.hashColumns.put("ff_cust_nm", getFfCustNm());
		this.hashColumns.put("ff_cust_addr", getFfCustAddr());
		this.hashColumns.put("sh_cnt_seq", getShCntSeq());
		this.hashColumns.put("sh_cstms_decl_cnt_cd", getShCstmsDeclCntCd());
		this.hashColumns.put("an_cust_cnt_cd", getAnCustCntCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("nf_cust_cty_nm", getNfCustCtyNm());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("cn_cust_to_ord_flg", getCnCustToOrdFlg());
		this.hashColumns.put("nf_cust_eml", getNfCustEml());
		this.hashColumns.put("nf_cust_fax_no", getNfCustFaxNo());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("cn_cstms_decl_cnt_cd", getCnCstmsDeclCntCd());
		this.hashColumns.put("cn_cust_ste_cd", getCnCustSteCd());
		this.hashColumns.put("an_cust_addr", getAnCustAddr());
		this.hashColumns.put("cn_cnt_seq", getCnCntSeq());
		this.hashColumns.put("ff_cust_cnt_cd", getFfCustCntCd());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("sh_cust_ste_cd", getShCustSteCd());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("cbr_cust_nm", getCbrCustNm());
		this.hashColumns.put("cbr_fax_no1", getCbrFaxNo1());
		this.hashColumns.put("cbr_fax_no2", getCbrFaxNo2());
		this.hashColumns.put("cbr_fax_no3", getCbrFaxNo3());
		this.hashColumns.put("org_cnt_nm", getOrgCntNm());
		this.hashColumns.put("sh_eur_cstms_st_nm", getShEurCstmsStNm());
		this.hashColumns.put("sh_eur_cstms_pst_id", getShEurCstmsPstId());
		this.hashColumns.put("sh_eori_no", getShEoriNo());
		this.hashColumns.put("cn_eur_cstms_st_nm", getCnEurCstmsStNm());
		this.hashColumns.put("cn_eur_cstms_pst_id", getCnEurCstmsPstId());
		this.hashColumns.put("cn_eori_no", getCnEoriNo());
		this.hashColumns.put("nf_eur_cstms_st_nm", getNfEurCstmsStNm());
		this.hashColumns.put("nf_eur_cstms_pst_id", getNfEurCstmsPstId());
		this.hashColumns.put("nf_eori_no", getNfEoriNo());		
		this.hashColumns.put("sh_kr_cstms_cust_tp_cd2", getShKrCstmsCustTpCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cn_cust_fax_no", "cnCustFaxNo");
		this.hashFields.put("sh_kr_cstms_cust_tp_cd", "shKrCstmsCustTpCd");
		this.hashFields.put("ff_cust_lgl_eng_nm", "ffCustLglEngNm");
		this.hashFields.put("br_cust_cnt_cd", "brCustCntCd");
		this.hashFields.put("nf_cust_ste_cd", "nfCustSteCd");
		this.hashFields.put("an_cnt_seq", "anCntSeq");
		this.hashFields.put("sh_cust_cty_nm", "shCustCtyNm");
		this.hashFields.put("ex_cust_nm", "exCustNm");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cn_cust_eml", "cnCustEml");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("nf_cust_cnt_cd", "nfCustCntCd");
		this.hashFields.put("br_cust_nm", "brCustNm");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("nf_cust_seq", "nfCustSeq");
		this.hashFields.put("an_cust_seq", "anCustSeq");
		this.hashFields.put("cn_cust_lgl_eng_nm", "cnCustLglEngNm");
		this.hashFields.put("nf_cust_zip_id", "nfCustZipId");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("nf_cstms_decl_cnt_cd", "nfCstmsDeclCntCd");
		this.hashFields.put("sh_cust_zip_id", "shCustZipId");
		this.hashFields.put("br_cust_addr", "brCustAddr");
		this.hashFields.put("sh_cust_lgl_eng_nm", "shCustLglEngNm");
		this.hashFields.put("nf_cnt_seq", "nfCntSeq");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("nf_cust_lgl_eng_nm", "nfCustLglEngNm");
		this.hashFields.put("cn_cust_zip_id", "cnCustZipId");
		this.hashFields.put("cn_cust_cty_nm", "cnCustCtyNm");
		this.hashFields.put("cn_cust_cnt_cd", "cnCustCntCd");
		this.hashFields.put("ff_cust_seq", "ffCustSeq");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("an_cust_lgl_eng_nm", "anCustLglEngNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cn_cust_seq", "cnCustSeq");
		this.hashFields.put("ff_cust_nm", "ffCustNm");
		this.hashFields.put("ff_cust_addr", "ffCustAddr");
		this.hashFields.put("sh_cnt_seq", "shCntSeq");
		this.hashFields.put("sh_cstms_decl_cnt_cd", "shCstmsDeclCntCd");
		this.hashFields.put("an_cust_cnt_cd", "anCustCntCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("nf_cust_cty_nm", "nfCustCtyNm");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("cn_cust_to_ord_flg", "cnCustToOrdFlg");
		this.hashFields.put("nf_cust_eml", "nfCustEml");
		this.hashFields.put("nf_cust_fax_no", "nfCustFaxNo");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("cn_cstms_decl_cnt_cd", "cnCstmsDeclCntCd");
		this.hashFields.put("cn_cust_ste_cd", "cnCustSteCd");
		this.hashFields.put("an_cust_addr", "anCustAddr");
		this.hashFields.put("cn_cnt_seq", "cnCntSeq");
		this.hashFields.put("ff_cust_cnt_cd", "ffCustCntCd");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("sh_cust_ste_cd", "shCustSteCd");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("cbr_cust_nm", "cbrCustNm");
		this.hashFields.put("cbr_fax_no1", "cbrFaxNo1");
		this.hashFields.put("cbr_fax_no2", "cbrFaxNo2");
		this.hashFields.put("cbr_fax_no3", "cbrFaxNo3");
		this.hashFields.put("org_cnt_nm", "orgCntNm");
		this.hashFields.put("sh_eur_cstms_st_nm", "shEurCstmsStNm");
		this.hashFields.put("sh_eur_cstms_pst_id", "shEurCstmsPstId");
		this.hashFields.put("sh_eori_no", "shEoriNo");
		this.hashFields.put("cn_eur_cstms_st_nm", "cnEurCstmsStNm");
		this.hashFields.put("cn_eur_cstms_pst_id", "cnEurCstmsPstId");
		this.hashFields.put("cn_eori_no", "cnEoriNo");
		this.hashFields.put("nf_eur_cstms_st_nm", "nfEurCstmsStNm");
		this.hashFields.put("nf_eur_cstms_pst_id", "nfEurCstmsPstId");
		this.hashFields.put("nf_eori_no", "nfEoriNo");		
		this.hashFields.put("sh_kr_cstms_cust_tp_cd2", "shKrCstmsCustTpCd2");
		return this.hashFields;
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
	 * @return shKrCstmsCustTpCd
	 */
	public String getShKrCstmsCustTpCd() {
		return this.shKrCstmsCustTpCd;
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
	 * @return brCustCntCd
	 */
	public String getBrCustCntCd() {
		return this.brCustCntCd;
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
	 * @return anCntSeq
	 */
	public String getAnCntSeq() {
		return this.anCntSeq;
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
	 * @return exCustNm
	 */
	public String getExCustNm() {
		return this.exCustNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustAddr
	 */
	public String getCnCustAddr() {
		return this.cnCustAddr;
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
	 * @return cnCustEml
	 */
	public String getCnCustEml() {
		return this.cnCustEml;
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
	 * @return nfCustCntCd
	 */
	public String getNfCustCntCd() {
		return this.nfCustCntCd;
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
	 * @return anCustNm
	 */
	public String getAnCustNm() {
		return this.anCustNm;
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
	 * @return anCustSeq
	 */
	public String getAnCustSeq() {
		return this.anCustSeq;
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
	 * @return nfCustZipId
	 */
	public String getNfCustZipId() {
		return this.nfCustZipId;
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
	 * @return nfCstmsDeclCntCd
	 */
	public String getNfCstmsDeclCntCd() {
		return this.nfCstmsDeclCntCd;
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
	 * @return brCustAddr
	 */
	public String getBrCustAddr() {
		return this.brCustAddr;
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
	 * @return nfCntSeq
	 */
	public String getNfCntSeq() {
		return this.nfCntSeq;
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
	 * @return nfCustLglEngNm
	 */
	public String getNfCustLglEngNm() {
		return this.nfCustLglEngNm;
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
	 * @return cnCustCtyNm
	 */
	public String getCnCustCtyNm() {
		return this.cnCustCtyNm;
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
	 * @return ffCustSeq
	 */
	public String getFfCustSeq() {
		return this.ffCustSeq;
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
	 * @return anCustLglEngNm
	 */
	public String getAnCustLglEngNm() {
		return this.anCustLglEngNm;
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
	 * @return cnCustSeq
	 */
	public String getCnCustSeq() {
		return this.cnCustSeq;
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
	 * @return ffCustAddr
	 */
	public String getFfCustAddr() {
		return this.ffCustAddr;
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
	 * @return shCstmsDeclCntCd
	 */
	public String getShCstmsDeclCntCd() {
		return this.shCstmsDeclCntCd;
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
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
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
	 * @return nfCustAddr
	 */
	public String getNfCustAddr() {
		return this.nfCustAddr;
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
	 * @return nfCustEml
	 */
	public String getNfCustEml() {
		return this.nfCustEml;
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
	 * @return shCustAddr
	 */
	public String getShCustAddr() {
		return this.shCustAddr;
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
	 * @return cnCustSteCd
	 */
	public String getCnCustSteCd() {
		return this.cnCustSteCd;
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
	 * @return cnCntSeq
	 */
	public String getCnCntSeq() {
		return this.cnCntSeq;
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
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
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
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
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
	 * @return shKrCstmsCustTpCd2
	 */
	public String getShKrCstmsCustTpCd2() {
		return this.shKrCstmsCustTpCd2;
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
	 * @param shKrCstmsCustTpCd
	 */
	public void setShKrCstmsCustTpCd(String shKrCstmsCustTpCd) {
		this.shKrCstmsCustTpCd = shKrCstmsCustTpCd;
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
	 * @param brCustCntCd
	 */
	public void setBrCustCntCd(String brCustCntCd) {
		this.brCustCntCd = brCustCntCd;
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
	 * @param anCntSeq
	 */
	public void setAnCntSeq(String anCntSeq) {
		this.anCntSeq = anCntSeq;
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
	 * @param exCustNm
	 */
	public void setExCustNm(String exCustNm) {
		this.exCustNm = exCustNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustAddr
	 */
	public void setCnCustAddr(String cnCustAddr) {
		this.cnCustAddr = cnCustAddr;
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
	 * @param cnCustEml
	 */
	public void setCnCustEml(String cnCustEml) {
		this.cnCustEml = cnCustEml;
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
	 * @param nfCustCntCd
	 */
	public void setNfCustCntCd(String nfCustCntCd) {
		this.nfCustCntCd = nfCustCntCd;
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
	 * @param anCustNm
	 */
	public void setAnCustNm(String anCustNm) {
		this.anCustNm = anCustNm;
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
	 * @param anCustSeq
	 */
	public void setAnCustSeq(String anCustSeq) {
		this.anCustSeq = anCustSeq;
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
	 * @param nfCustZipId
	 */
	public void setNfCustZipId(String nfCustZipId) {
		this.nfCustZipId = nfCustZipId;
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
	 * @param nfCstmsDeclCntCd
	 */
	public void setNfCstmsDeclCntCd(String nfCstmsDeclCntCd) {
		this.nfCstmsDeclCntCd = nfCstmsDeclCntCd;
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
	 * @param brCustAddr
	 */
	public void setBrCustAddr(String brCustAddr) {
		this.brCustAddr = brCustAddr;
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
	 * @param nfCntSeq
	 */
	public void setNfCntSeq(String nfCntSeq) {
		this.nfCntSeq = nfCntSeq;
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
	 * @param nfCustLglEngNm
	 */
	public void setNfCustLglEngNm(String nfCustLglEngNm) {
		this.nfCustLglEngNm = nfCustLglEngNm;
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
	 * @param cnCustCtyNm
	 */
	public void setCnCustCtyNm(String cnCustCtyNm) {
		this.cnCustCtyNm = cnCustCtyNm;
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
	 * @param ffCustSeq
	 */
	public void setFfCustSeq(String ffCustSeq) {
		this.ffCustSeq = ffCustSeq;
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
	 * @param anCustLglEngNm
	 */
	public void setAnCustLglEngNm(String anCustLglEngNm) {
		this.anCustLglEngNm = anCustLglEngNm;
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
	 * @param cnCustSeq
	 */
	public void setCnCustSeq(String cnCustSeq) {
		this.cnCustSeq = cnCustSeq;
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
	 * @param ffCustAddr
	 */
	public void setFfCustAddr(String ffCustAddr) {
		this.ffCustAddr = ffCustAddr;
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
	 * @param shCstmsDeclCntCd
	 */
	public void setShCstmsDeclCntCd(String shCstmsDeclCntCd) {
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
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
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
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
	 * @param nfCustAddr
	 */
	public void setNfCustAddr(String nfCustAddr) {
		this.nfCustAddr = nfCustAddr;
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
	 * @param nfCustEml
	 */
	public void setNfCustEml(String nfCustEml) {
		this.nfCustEml = nfCustEml;
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
	 * @param shCustAddr
	 */
	public void setShCustAddr(String shCustAddr) {
		this.shCustAddr = shCustAddr;
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
	 * @param cnCustSteCd
	 */
	public void setCnCustSteCd(String cnCustSteCd) {
		this.cnCustSteCd = cnCustSteCd;
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
	 * @param cnCntSeq
	 */
	public void setCnCntSeq(String cnCntSeq) {
		this.cnCntSeq = cnCntSeq;
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
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
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
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	public String getRvisCntrCustTpCd() {
		return rvisCntrCustTpCd;
	}

	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
	}

	public String getCbrCustNm() {
		return cbrCustNm;
	}

	public void setCbrCustNm(String cbrCustNm) {
		this.cbrCustNm = cbrCustNm;
	}

	public String getCbrFaxNo1() {
		return cbrFaxNo1;
	}

	public void setCbrFaxNo1(String cbrFaxNo1) {
		this.cbrFaxNo1 = cbrFaxNo1;
	}

	public String getCbrFaxNo2() {
		return cbrFaxNo2;
	}

	public void setCbrFaxNo2(String cbrFaxNo2) {
		this.cbrFaxNo2 = cbrFaxNo2;
	}

	public String getCbrFaxNo3() {
		return cbrFaxNo3;
	}

	public void setCbrFaxNo3(String cbrFaxNo3) {
		this.cbrFaxNo3 = cbrFaxNo3;
	}
	
	public String getOrgCntNm() {
		return orgCntNm;
	}

	public void setOrgCntNm(String orgCntNm) {
		this.orgCntNm = orgCntNm;
	}

	
	public String getShEurCstmsStNm() {
		return shEurCstmsStNm;
	} 

	public void setShEurCstmsStNm(String shEurCstmsStNm) {
		this.shEurCstmsStNm = shEurCstmsStNm;
	}

	public String getShEurCstmsPstId() {
		return shEurCstmsPstId;
	}

	public void setShEurCstmsPstId(String shEurCstmsPstId) {
		this.shEurCstmsPstId = shEurCstmsPstId;
	}

	public String getShEoriNo() {
		return shEoriNo;
	}

	public void setShEoriNo(String shEoriNo) {
		this.shEoriNo = shEoriNo;
	}

	public String getCnEurCstmsStNm() {
		return cnEurCstmsStNm;
	}

	public void setCnEurCstmsStNm(String cnEurCstmsStNm) {
		this.cnEurCstmsStNm = cnEurCstmsStNm;
	}

	public String getCnEurCstmsPstId() {
		return cnEurCstmsPstId;
	}

	public void setCnEurCstmsPstId(String cnEurCstmsPstId) {
		this.cnEurCstmsPstId = cnEurCstmsPstId;
	}

	public String getCnEoriNo() {
		return cnEoriNo;
	}

	public void setCnEoriNo(String cnEoriNo) {
		this.cnEoriNo = cnEoriNo;
	}

	public String getNfEurCstmsStNm() {
		return nfEurCstmsStNm;
	}

	public void setNfEurCstmsStNm(String nfEurCstmsStNm) {
		this.nfEurCstmsStNm = nfEurCstmsStNm;
	}

	public String getNfEurCstmsPstId() {
		return nfEurCstmsPstId;
	}

	public void setNfEurCstmsPstId(String nfEurCstmsPstId) {
		this.nfEurCstmsPstId = nfEurCstmsPstId;
	}

	public String getNfEoriNo() {
		return nfEoriNo;
	}

	public void setNfEoriNo(String nfEoriNo) {
		this.nfEoriNo = nfEoriNo;
	}

	/**
	 * Column Info
	 * @param shKrCstmsCustTpCd2
	 */
	public void setShKrCstmsCustTpCd2(String shKrCstmsCustTpCd2) {
		this.shKrCstmsCustTpCd2 = shKrCstmsCustTpCd2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCnCustFaxNo(JSPUtil.getParameter(request, "cn_cust_fax_no", ""));
		setShKrCstmsCustTpCd(JSPUtil.getParameter(request, "sh_kr_cstms_cust_tp_cd", ""));
		setFfCustLglEngNm(JSPUtil.getParameter(request, "ff_cust_lgl_eng_nm", ""));
		setBrCustCntCd(JSPUtil.getParameter(request, "br_cust_cnt_cd", ""));
		setNfCustSteCd(JSPUtil.getParameter(request, "nf_cust_ste_cd", ""));
		setAnCntSeq(JSPUtil.getParameter(request, "an_cnt_seq", ""));
		setShCustCtyNm(JSPUtil.getParameter(request, "sh_cust_cty_nm", ""));
		setExCustNm(JSPUtil.getParameter(request, "ex_cust_nm", ""));
		setCnCustAddr(JSPUtil.getParameter(request, "cn_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnCustEml(JSPUtil.getParameter(request, "cn_cust_eml", ""));
		setShCustSeq(JSPUtil.getParameter(request, "sh_cust_seq", ""));
		setNfCustCntCd(JSPUtil.getParameter(request, "nf_cust_cnt_cd", ""));
		setBrCustNm(JSPUtil.getParameter(request, "br_cust_nm", ""));
		setAnCustNm(JSPUtil.getParameter(request, "an_cust_nm", ""));
		setNfCustSeq(JSPUtil.getParameter(request, "nf_cust_seq", ""));
		setAnCustSeq(JSPUtil.getParameter(request, "an_cust_seq", ""));
		setCnCustLglEngNm(JSPUtil.getParameter(request, "cn_cust_lgl_eng_nm", ""));
		setNfCustZipId(JSPUtil.getParameter(request, "nf_cust_zip_id", ""));
		setShCustNm(JSPUtil.getParameter(request, "sh_cust_nm", ""));
		setNfCstmsDeclCntCd(JSPUtil.getParameter(request, "nf_cstms_decl_cnt_cd", ""));
		setShCustZipId(JSPUtil.getParameter(request, "sh_cust_zip_id", ""));
		setBrCustAddr(JSPUtil.getParameter(request, "br_cust_addr", ""));
		setShCustLglEngNm(JSPUtil.getParameter(request, "sh_cust_lgl_eng_nm", ""));
		setNfCntSeq(JSPUtil.getParameter(request, "nf_cnt_seq", ""));
		setShCustCntCd(JSPUtil.getParameter(request, "sh_cust_cnt_cd", ""));
		setNfCustLglEngNm(JSPUtil.getParameter(request, "nf_cust_lgl_eng_nm", ""));
		setCnCustZipId(JSPUtil.getParameter(request, "cn_cust_zip_id", ""));
		setCnCustCtyNm(JSPUtil.getParameter(request, "cn_cust_cty_nm", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, "cn_cust_cnt_cd", ""));
		setFfCustSeq(JSPUtil.getParameter(request, "ff_cust_seq", ""));
		setFfCntSeq(JSPUtil.getParameter(request, "ff_cnt_seq", ""));
		setAnCustLglEngNm(JSPUtil.getParameter(request, "an_cust_lgl_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnCustSeq(JSPUtil.getParameter(request, "cn_cust_seq", ""));
		setFfCustNm(JSPUtil.getParameter(request, "ff_cust_nm", ""));
		setFfCustAddr(JSPUtil.getParameter(request, "ff_cust_addr", ""));
		setShCntSeq(JSPUtil.getParameter(request, "sh_cnt_seq", ""));
		setShCstmsDeclCntCd(JSPUtil.getParameter(request, "sh_cstms_decl_cnt_cd", ""));
		setAnCustCntCd(JSPUtil.getParameter(request, "an_cust_cnt_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, "nf_cust_nm", ""));
		setNfCustCtyNm(JSPUtil.getParameter(request, "nf_cust_cty_nm", ""));
		setNfCustAddr(JSPUtil.getParameter(request, "nf_cust_addr", ""));
		setCnCustToOrdFlg(JSPUtil.getParameter(request, "cn_cust_to_ord_flg", ""));
		setNfCustEml(JSPUtil.getParameter(request, "nf_cust_eml", ""));
		setNfCustFaxNo(JSPUtil.getParameter(request, "nf_cust_fax_no", ""));
		setShCustAddr(JSPUtil.getParameter(request, "sh_cust_addr", ""));
		setCnCstmsDeclCntCd(JSPUtil.getParameter(request, "cn_cstms_decl_cnt_cd", ""));
		setCnCustSteCd(JSPUtil.getParameter(request, "cn_cust_ste_cd", ""));
		setAnCustAddr(JSPUtil.getParameter(request, "an_cust_addr", ""));
		setCnCntSeq(JSPUtil.getParameter(request, "cn_cnt_seq", ""));
		setFfCustCntCd(JSPUtil.getParameter(request, "ff_cust_cnt_cd", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, "xter_rqst_seq", ""));
		setShCustSteCd(JSPUtil.getParameter(request, "sh_cust_ste_cd", ""));
		setCnCustNm(JSPUtil.getParameter(request, "cn_cust_nm", ""));
		setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, "rvis_cntr_cust_tp_cd", ""));
		setCbrCustNm(JSPUtil.getParameter(request, "cbr_cust_nm", ""));
		setCbrFaxNo1(JSPUtil.getParameter(request, "cbr_fax_no1", ""));
		setCbrFaxNo2(JSPUtil.getParameter(request, "cbr_fax_no2", ""));
		setCbrFaxNo3(JSPUtil.getParameter(request, "cbr_fax_no3", ""));
		setShEurCstmsStNm(JSPUtil.getParameter(request, "sh_eur_cstms_st_nm", ""));
		setShEurCstmsPstId(JSPUtil.getParameter(request, "sh_eur_cstms_pst_id", ""));
		setShEoriNo(JSPUtil.getParameter(request, "sh_eori_no", ""));
		setCnEurCstmsStNm(JSPUtil.getParameter(request, "cn_eur_cstms_st_nm", ""));
		setCnEurCstmsPstId(JSPUtil.getParameter(request, "cn_eur_cstms_pst_id", ""));
		setCnEoriNo(JSPUtil.getParameter(request, "cn_eori_no", ""));
		setNfEurCstmsStNm(JSPUtil.getParameter(request, "nf_eur_cstms_st_nm", ""));
		setNfEurCstmsPstId(JSPUtil.getParameter(request, "nf_eur_cstms_pst_id", ""));
		setNfEoriNo(JSPUtil.getParameter(request, "nf_eori_no", ""));		
		setShKrCstmsCustTpCd2(JSPUtil.getParameter(request, "sh_kr_cstms_cust_tp_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterCustVO[]
	 */
	public BkgXterCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterCustVO[]
	 */
	public BkgXterCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "cn_cust_fax_no", length));
			String[] shKrCstmsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "sh_kr_cstms_cust_tp_cd", length));
			String[] ffCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_lgl_eng_nm", length));
			String[] brCustCntCd = (JSPUtil.getParameter(request, prefix	+ "br_cust_cnt_cd", length));
			String[] nfCustSteCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_ste_cd", length));
			String[] anCntSeq = (JSPUtil.getParameter(request, prefix	+ "an_cnt_seq", length));
			String[] shCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cty_nm", length));
			String[] exCustNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_nm", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnCustEml = (JSPUtil.getParameter(request, prefix	+ "cn_cust_eml", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] nfCustCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt_cd", length));
			String[] brCustNm = (JSPUtil.getParameter(request, prefix	+ "br_cust_nm", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] nfCustSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cust_seq", length));
			String[] anCustSeq = (JSPUtil.getParameter(request, prefix	+ "an_cust_seq", length));
			String[] cnCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_lgl_eng_nm", length));
			String[] nfCustZipId = (JSPUtil.getParameter(request, prefix	+ "nf_cust_zip_id", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] nfCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cstms_decl_cnt_cd", length));
			String[] shCustZipId = (JSPUtil.getParameter(request, prefix	+ "sh_cust_zip_id", length));
			String[] brCustAddr = (JSPUtil.getParameter(request, prefix	+ "br_cust_addr", length));
			String[] shCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_lgl_eng_nm", length));
			String[] nfCntSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cnt_seq", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] nfCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_lgl_eng_nm", length));
			String[] cnCustZipId = (JSPUtil.getParameter(request, prefix	+ "cn_cust_zip_id", length));
			String[] cnCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cty_nm", length));
			String[] cnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cnt_cd", length));
			String[] ffCustSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] anCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_lgl_eng_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnCustSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cust_seq", length));
			String[] ffCustNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_nm", length));
			String[] ffCustAddr = (JSPUtil.getParameter(request, prefix	+ "ff_cust_addr", length));
			String[] shCntSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cnt_seq", length));
			String[] shCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cstms_decl_cnt_cd", length));
			String[] anCustCntCd = (JSPUtil.getParameter(request, prefix	+ "an_cust_cnt_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] nfCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cty_nm", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] cnCustToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cn_cust_to_ord_flg", length));
			String[] nfCustEml = (JSPUtil.getParameter(request, prefix	+ "nf_cust_eml", length));
			String[] nfCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "nf_cust_fax_no", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] cnCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cstms_decl_cnt_cd", length));
			String[] cnCustSteCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_ste_cd", length));
			String[] anCustAddr = (JSPUtil.getParameter(request, prefix	+ "an_cust_addr", length));
			String[] cnCntSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cnt_seq", length));
			String[] ffCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cust_cnt_cd", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] shCustSteCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_ste_cd", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] cbrCustNm = (JSPUtil.getParameter(request, prefix	+ "cbr_cust_nm", length));
			String[] cbrFaxNo1 = (JSPUtil.getParameter(request, prefix	+ "cbr_fax_no1", length));
			String[] cbrFaxNo2 = (JSPUtil.getParameter(request, prefix	+ "cbr_fax_no2", length));
			String[] cbrFaxNo3 = (JSPUtil.getParameter(request, prefix	+ "cbr_fax_no3", length));
			String[] orgCntNm = (JSPUtil.getParameter(request, prefix	+ "org_cnt_nm", length));
			String[] shEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "sh_eur_cstms_st_nm", length));
			String[] shEurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "sh_eur_cstms_pst_id", length));
			String[] shEoriNo = (JSPUtil.getParameter(request, prefix	+ "sh_eori_no", length));
			String[] cnEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "cn_eur_cstms_st_nm", length));
			String[] cnEurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "cn_eur_cstms_pst_id", length));
			String[] cnEoriNo = (JSPUtil.getParameter(request, prefix	+ "cn_eori_no", length));
			String[] nfEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "nf_eur_cstms_st_nm", length));
			String[] nfEurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "nf_eur_cstms_pst_id", length));
			String[] nfEoriNo = (JSPUtil.getParameter(request, prefix	+ "nf_eori_no", length));
			String[] shKrCstmsCustTpCd2 = (JSPUtil.getParameter(request, prefix	+ "sh_kr_cstms_cust_tp_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgXterCustVO();
				if (cnCustFaxNo[i] != null)
					model.setCnCustFaxNo(cnCustFaxNo[i]);
				if (shKrCstmsCustTpCd[i] != null)
					model.setShKrCstmsCustTpCd(shKrCstmsCustTpCd[i]);
				if (ffCustLglEngNm[i] != null)
					model.setFfCustLglEngNm(ffCustLglEngNm[i]);
				if (brCustCntCd[i] != null)
					model.setBrCustCntCd(brCustCntCd[i]);
				if (nfCustSteCd[i] != null)
					model.setNfCustSteCd(nfCustSteCd[i]);
				if (anCntSeq[i] != null)
					model.setAnCntSeq(anCntSeq[i]);
				if (shCustCtyNm[i] != null)
					model.setShCustCtyNm(shCustCtyNm[i]);
				if (exCustNm[i] != null)
					model.setExCustNm(exCustNm[i]);
				if (cnCustAddr[i] != null)
					model.setCnCustAddr(cnCustAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnCustEml[i] != null)
					model.setCnCustEml(cnCustEml[i]);
				if (shCustSeq[i] != null)
					model.setShCustSeq(shCustSeq[i]);
				if (nfCustCntCd[i] != null)
					model.setNfCustCntCd(nfCustCntCd[i]);
				if (brCustNm[i] != null)
					model.setBrCustNm(brCustNm[i]);
				if (anCustNm[i] != null)
					model.setAnCustNm(anCustNm[i]);
				if (nfCustSeq[i] != null)
					model.setNfCustSeq(nfCustSeq[i]);
				if (anCustSeq[i] != null)
					model.setAnCustSeq(anCustSeq[i]);
				if (cnCustLglEngNm[i] != null)
					model.setCnCustLglEngNm(cnCustLglEngNm[i]);
				if (nfCustZipId[i] != null)
					model.setNfCustZipId(nfCustZipId[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (nfCstmsDeclCntCd[i] != null)
					model.setNfCstmsDeclCntCd(nfCstmsDeclCntCd[i]);
				if (shCustZipId[i] != null)
					model.setShCustZipId(shCustZipId[i]);
				if (brCustAddr[i] != null)
					model.setBrCustAddr(brCustAddr[i]);
				if (shCustLglEngNm[i] != null)
					model.setShCustLglEngNm(shCustLglEngNm[i]);
				if (nfCntSeq[i] != null)
					model.setNfCntSeq(nfCntSeq[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (nfCustLglEngNm[i] != null)
					model.setNfCustLglEngNm(nfCustLglEngNm[i]);
				if (cnCustZipId[i] != null)
					model.setCnCustZipId(cnCustZipId[i]);
				if (cnCustCtyNm[i] != null)
					model.setCnCustCtyNm(cnCustCtyNm[i]);
				if (cnCustCntCd[i] != null)
					model.setCnCustCntCd(cnCustCntCd[i]);
				if (ffCustSeq[i] != null)
					model.setFfCustSeq(ffCustSeq[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (anCustLglEngNm[i] != null)
					model.setAnCustLglEngNm(anCustLglEngNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnCustSeq[i] != null)
					model.setCnCustSeq(cnCustSeq[i]);
				if (ffCustNm[i] != null)
					model.setFfCustNm(ffCustNm[i]);
				if (ffCustAddr[i] != null)
					model.setFfCustAddr(ffCustAddr[i]);
				if (shCntSeq[i] != null)
					model.setShCntSeq(shCntSeq[i]);
				if (shCstmsDeclCntCd[i] != null)
					model.setShCstmsDeclCntCd(shCstmsDeclCntCd[i]);
				if (anCustCntCd[i] != null)
					model.setAnCustCntCd(anCustCntCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (nfCustCtyNm[i] != null)
					model.setNfCustCtyNm(nfCustCtyNm[i]);
				if (nfCustAddr[i] != null)
					model.setNfCustAddr(nfCustAddr[i]);
				if (cnCustToOrdFlg[i] != null)
					model.setCnCustToOrdFlg(cnCustToOrdFlg[i]);
				if (nfCustEml[i] != null)
					model.setNfCustEml(nfCustEml[i]);
				if (nfCustFaxNo[i] != null)
					model.setNfCustFaxNo(nfCustFaxNo[i]);
				if (shCustAddr[i] != null)
					model.setShCustAddr(shCustAddr[i]);
				if (cnCstmsDeclCntCd[i] != null)
					model.setCnCstmsDeclCntCd(cnCstmsDeclCntCd[i]);
				if (cnCustSteCd[i] != null)
					model.setCnCustSteCd(cnCustSteCd[i]);
				if (anCustAddr[i] != null)
					model.setAnCustAddr(anCustAddr[i]);
				if (cnCntSeq[i] != null)
					model.setCnCntSeq(cnCntSeq[i]);
				if (ffCustCntCd[i] != null)
					model.setFfCustCntCd(ffCustCntCd[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (shCustSteCd[i] != null)
					model.setShCustSteCd(shCustSteCd[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (cbrCustNm[i] != null)
					model.setCbrCustNm(cbrCustNm[i]);
				if (cbrFaxNo1[i] != null)
					model.setCbrFaxNo1(cbrFaxNo1[i]);
				if (cbrFaxNo2[i] != null)
					model.setCbrFaxNo2(cbrFaxNo2[i]);
				if (cbrFaxNo3[i] != null)
					model.setCbrFaxNo3(cbrFaxNo3[i]);
				if (orgCntNm[i] != null)
					model.setOrgCntNm(orgCntNm[i]);
				if (shEurCstmsStNm[i] != null)
					model.setShEurCstmsStNm(shEurCstmsStNm[i]);
				if (shEurCstmsPstId[i] != null)
					model.setShEurCstmsPstId(shEurCstmsPstId[i]);
				if (shEoriNo[i] != null)
					model.setShEoriNo(shEoriNo[i]);
				if (cnEurCstmsStNm[i] != null)
					model.setCnEurCstmsStNm(cnEurCstmsStNm[i]);
				if (cnEurCstmsPstId[i] != null)
					model.setCnEurCstmsPstId(cnEurCstmsPstId[i]);
				if (cnEoriNo[i] != null)
					model.setCnEoriNo(cnEoriNo[i]);
				if (nfEurCstmsStNm[i] != null)
					model.setNfEurCstmsStNm(nfEurCstmsStNm[i]);
				if (nfEurCstmsPstId[i] != null)
					model.setNfEurCstmsPstId(nfEurCstmsPstId[i]);
				if (nfEoriNo[i] != null)
					model.setNfEoriNo(nfEoriNo[i]);
				if (shKrCstmsCustTpCd2[i] != null)
					model.setShKrCstmsCustTpCd2(shKrCstmsCustTpCd2[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterCustVO[]
	 */
	public BkgXterCustVO[] getBkgXterCustVOs(){
		BkgXterCustVO[] vos = (BkgXterCustVO[])models.toArray(new BkgXterCustVO[models.size()]);
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
		this.cnCustFaxNo = this.cnCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shKrCstmsCustTpCd = this.shKrCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustLglEngNm = this.ffCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustCntCd = this.brCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSteCd = this.nfCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCntSeq = this.anCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCtyNm = this.shCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustNm = this.exCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustEml = this.cnCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCntCd = this.nfCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustNm = this.brCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSeq = this.nfCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustSeq = this.anCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustLglEngNm = this.cnCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustZipId = this.nfCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCstmsDeclCntCd = this.nfCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustZipId = this.shCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustAddr = this.brCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustLglEngNm = this.shCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCntSeq = this.nfCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustLglEngNm = this.nfCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustZipId = this.cnCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCtyNm = this.cnCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCntCd = this.cnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeq = this.ffCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustLglEngNm = this.anCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSeq = this.cnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustNm = this.ffCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustAddr = this.ffCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCntSeq = this.shCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCstmsDeclCntCd = this.shCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustCntCd = this.anCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCtyNm = this.nfCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustToOrdFlg = this.cnCustToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustEml = this.nfCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustFaxNo = this.nfCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCstmsDeclCntCd = this.cnCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSteCd = this.cnCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustAddr = this.anCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCntSeq = this.cnCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustCntCd = this.ffCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSteCd = this.shCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrCustNm = this.cbrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrFaxNo1 = this.cbrFaxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrFaxNo2 = this.cbrFaxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrFaxNo3 = this.cbrFaxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntNm = this.orgCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEurCstmsStNm = this.shEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEurCstmsPstId = this.shEurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEoriNo = this.shEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEurCstmsStNm = this.cnEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEurCstmsPstId = this.cnEurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEoriNo = this.cnEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEurCstmsStNm = this.nfEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEurCstmsPstId = this.nfEurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEoriNo = this.nfEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shKrCstmsCustTpCd2 = this.shKrCstmsCustTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
