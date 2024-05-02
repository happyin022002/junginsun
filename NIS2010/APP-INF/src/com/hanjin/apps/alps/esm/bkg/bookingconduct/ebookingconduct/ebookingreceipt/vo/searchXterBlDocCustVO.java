/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : searchXterBlDocCustVO.java
*@FileTitle : searchXterBlDocCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.16  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchXterBlDocCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchXterBlDocCustVO> models = new ArrayList<searchXterBlDocCustVO>();
	
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
	private String ffCustEml = null;
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
	private String ffCustZipId = null;
	/* Column Info */
	private String exAddrPrnFlg = null;
	/* Column Info */
	private String ffCustSteCd = null;
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
	private String ffAddrPrnFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String nfCstmsDeclCntCd = null;
	/* Column Info */
	private String ffCustFaxNo = null;
	/* Column Info */
	private String shCustZipId = null;
	/* Column Info */
	private String nfAddrPrnFlg = null;
	/* Column Info */
	private String brCustAddr = null;
	/* Column Info */
	private String ffCstmsDeclCntCd = null;
	/* Column Info */
	private String shCustLglEngNm = null;
	/* Column Info */
	private String nfCntSeq = null;
	/* Column Info */
	private String shAddrPrnFlg = null;
	/* Column Info */
	private String anAddrPrnFlg = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String nfCustLglEngNm = null;
	/* Column Info */
	private String ffCustCtyNm = null;
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
	private String anCustCntCd = null;
	/* Column Info */
	private String shCstmsDeclCntCd = null;
	/* Column Info */
	private String shCntSeq = null;
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
	private String cnCustSteCd = null;
	/* Column Info */
	private String cnCstmsDeclCntCd = null;
	/* Column Info */
	private String anCustAddr = null;
	/* Column Info */
	private String cnCntSeq = null;
	/* Column Info */
	private String cnAddrPrnFlg = null;
	/* Column Info */
	private String ffCustCntCd = null;
	/* Column Info */
	private String shCustSteCd = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String shCustTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchXterBlDocCustVO() {}

	public searchXterBlDocCustVO(String ibflag, String pagerows, String bkgNo, String shCustCntCd, String shCustSeq, String shCntSeq, String shKrCstmsCustTpCd, String shCustNm, String shCustLglEngNm, String shAddrPrnFlg, String shCustAddr, String shCustCtyNm, String shCustSteCd, String shCstmsDeclCntCd, String shCustZipId, String shCustTp, String cnCustCntCd, String cnCustSeq, String cnCntSeq, String cnCustToOrdFlg, String cnCustNm, String cnCustLglEngNm, String cnAddrPrnFlg, String cnCustAddr, String cnCustCtyNm, String cnCustSteCd, String cnCstmsDeclCntCd, String cnCustZipId, String cnCustFaxNo, String cnCustEml, String nfCustCntCd, String nfCustSeq, String nfCntSeq, String nfCustNm, String nfCustLglEngNm, String nfAddrPrnFlg, String nfCustAddr, String nfCustCtyNm, String nfCustSteCd, String nfCstmsDeclCntCd, String nfCustZipId, String nfCustFaxNo, String nfCustEml, String ffCustCntCd, String ffCustSeq, String ffCntSeq, String ffCustNm, String ffCustLglEngNm, String ffAddrPrnFlg, String ffCustAddr, String ffCustCtyNm, String ffCustSteCd, String ffCstmsDeclCntCd, String ffCustZipId, String ffCustFaxNo, String ffCustEml, String anCustCntCd, String anCustSeq, String anCntSeq, String anCustNm, String anCustLglEngNm, String anAddrPrnFlg, String anCustAddr, String exCustNm, String exAddrPrnFlg, String brCustCntCd, String brCustNm, String brCustAddr) {
		this.cnCustFaxNo = cnCustFaxNo;
		this.shKrCstmsCustTpCd = shKrCstmsCustTpCd;
		this.ffCustLglEngNm = ffCustLglEngNm;
		this.brCustCntCd = brCustCntCd;
		this.nfCustSteCd = nfCustSteCd;
		this.anCntSeq = anCntSeq;
		this.ffCustEml = ffCustEml;
		this.shCustCtyNm = shCustCtyNm;
		this.exCustNm = exCustNm;
		this.cnCustAddr = cnCustAddr;
		this.pagerows = pagerows;
		this.cnCustEml = cnCustEml;
		this.shCustSeq = shCustSeq;
		this.ffCustZipId = ffCustZipId;
		this.exAddrPrnFlg = exAddrPrnFlg;
		this.ffCustSteCd = ffCustSteCd;
		this.nfCustCntCd = nfCustCntCd;
		this.brCustNm = brCustNm;
		this.anCustNm = anCustNm;
		this.nfCustSeq = nfCustSeq;
		this.anCustSeq = anCustSeq;
		this.cnCustLglEngNm = cnCustLglEngNm;
		this.nfCustZipId = nfCustZipId;
		this.ffAddrPrnFlg = ffAddrPrnFlg;
		this.bkgNo = bkgNo;
		this.shCustNm = shCustNm;
		this.nfCstmsDeclCntCd = nfCstmsDeclCntCd;
		this.ffCustFaxNo = ffCustFaxNo;
		this.shCustZipId = shCustZipId;
		this.nfAddrPrnFlg = nfAddrPrnFlg;
		this.brCustAddr = brCustAddr;
		this.ffCstmsDeclCntCd = ffCstmsDeclCntCd;
		this.shCustLglEngNm = shCustLglEngNm;
		this.nfCntSeq = nfCntSeq;
		this.shAddrPrnFlg = shAddrPrnFlg;
		this.anAddrPrnFlg = anAddrPrnFlg;
		this.shCustCntCd = shCustCntCd;
		this.nfCustLglEngNm = nfCustLglEngNm;
		this.ffCustCtyNm = ffCustCtyNm;
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
		this.anCustCntCd = anCustCntCd;
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
		this.shCntSeq = shCntSeq;
		this.nfCustNm = nfCustNm;
		this.nfCustCtyNm = nfCustCtyNm;
		this.nfCustAddr = nfCustAddr;
		this.cnCustToOrdFlg = cnCustToOrdFlg;
		this.nfCustEml = nfCustEml;
		this.nfCustFaxNo = nfCustFaxNo;
		this.shCustAddr = shCustAddr;
		this.cnCustSteCd = cnCustSteCd;
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
		this.anCustAddr = anCustAddr;
		this.cnCntSeq = cnCntSeq;
		this.cnAddrPrnFlg = cnAddrPrnFlg;
		this.ffCustCntCd = ffCustCntCd;
		this.shCustSteCd = shCustSteCd;
		this.cnCustNm = cnCustNm;
		this.shCustTp = shCustTp;
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
		this.hashColumns.put("ff_cust_eml", getFfCustEml());
		this.hashColumns.put("sh_cust_cty_nm", getShCustCtyNm());
		this.hashColumns.put("ex_cust_nm", getExCustNm());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cn_cust_eml", getCnCustEml());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("ff_cust_zip_id", getFfCustZipId());
		this.hashColumns.put("ex_addr_prn_flg", getExAddrPrnFlg());
		this.hashColumns.put("ff_cust_ste_cd", getFfCustSteCd());
		this.hashColumns.put("nf_cust_cnt_cd", getNfCustCntCd());
		this.hashColumns.put("br_cust_nm", getBrCustNm());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("nf_cust_seq", getNfCustSeq());
		this.hashColumns.put("an_cust_seq", getAnCustSeq());
		this.hashColumns.put("cn_cust_lgl_eng_nm", getCnCustLglEngNm());
		this.hashColumns.put("nf_cust_zip_id", getNfCustZipId());
		this.hashColumns.put("ff_addr_prn_flg", getFfAddrPrnFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("nf_cstms_decl_cnt_cd", getNfCstmsDeclCntCd());
		this.hashColumns.put("ff_cust_fax_no", getFfCustFaxNo());
		this.hashColumns.put("sh_cust_zip_id", getShCustZipId());
		this.hashColumns.put("nf_addr_prn_flg", getNfAddrPrnFlg());
		this.hashColumns.put("br_cust_addr", getBrCustAddr());
		this.hashColumns.put("ff_cstms_decl_cnt_cd", getFfCstmsDeclCntCd());
		this.hashColumns.put("sh_cust_lgl_eng_nm", getShCustLglEngNm());
		this.hashColumns.put("nf_cnt_seq", getNfCntSeq());
		this.hashColumns.put("sh_addr_prn_flg", getShAddrPrnFlg());
		this.hashColumns.put("an_addr_prn_flg", getAnAddrPrnFlg());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("nf_cust_lgl_eng_nm", getNfCustLglEngNm());
		this.hashColumns.put("ff_cust_cty_nm", getFfCustCtyNm());
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
		this.hashColumns.put("an_cust_cnt_cd", getAnCustCntCd());
		this.hashColumns.put("sh_cstms_decl_cnt_cd", getShCstmsDeclCntCd());
		this.hashColumns.put("sh_cnt_seq", getShCntSeq());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("nf_cust_cty_nm", getNfCustCtyNm());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("cn_cust_to_ord_flg", getCnCustToOrdFlg());
		this.hashColumns.put("nf_cust_eml", getNfCustEml());
		this.hashColumns.put("nf_cust_fax_no", getNfCustFaxNo());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("cn_cust_ste_cd", getCnCustSteCd());
		this.hashColumns.put("cn_cstms_decl_cnt_cd", getCnCstmsDeclCntCd());
		this.hashColumns.put("an_cust_addr", getAnCustAddr());
		this.hashColumns.put("cn_cnt_seq", getCnCntSeq());
		this.hashColumns.put("cn_addr_prn_flg", getCnAddrPrnFlg());
		this.hashColumns.put("ff_cust_cnt_cd", getFfCustCntCd());
		this.hashColumns.put("sh_cust_ste_cd", getShCustSteCd());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("sh_cust_tp", getShCustTp());
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
		this.hashFields.put("ff_cust_eml", "ffCustEml");
		this.hashFields.put("sh_cust_cty_nm", "shCustCtyNm");
		this.hashFields.put("ex_cust_nm", "exCustNm");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cn_cust_eml", "cnCustEml");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("ff_cust_zip_id", "ffCustZipId");
		this.hashFields.put("ex_addr_prn_flg", "exAddrPrnFlg");
		this.hashFields.put("ff_cust_ste_cd", "ffCustSteCd");
		this.hashFields.put("nf_cust_cnt_cd", "nfCustCntCd");
		this.hashFields.put("br_cust_nm", "brCustNm");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("nf_cust_seq", "nfCustSeq");
		this.hashFields.put("an_cust_seq", "anCustSeq");
		this.hashFields.put("cn_cust_lgl_eng_nm", "cnCustLglEngNm");
		this.hashFields.put("nf_cust_zip_id", "nfCustZipId");
		this.hashFields.put("ff_addr_prn_flg", "ffAddrPrnFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("nf_cstms_decl_cnt_cd", "nfCstmsDeclCntCd");
		this.hashFields.put("ff_cust_fax_no", "ffCustFaxNo");
		this.hashFields.put("sh_cust_zip_id", "shCustZipId");
		this.hashFields.put("nf_addr_prn_flg", "nfAddrPrnFlg");
		this.hashFields.put("br_cust_addr", "brCustAddr");
		this.hashFields.put("ff_cstms_decl_cnt_cd", "ffCstmsDeclCntCd");
		this.hashFields.put("sh_cust_lgl_eng_nm", "shCustLglEngNm");
		this.hashFields.put("nf_cnt_seq", "nfCntSeq");
		this.hashFields.put("sh_addr_prn_flg", "shAddrPrnFlg");
		this.hashFields.put("an_addr_prn_flg", "anAddrPrnFlg");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("nf_cust_lgl_eng_nm", "nfCustLglEngNm");
		this.hashFields.put("ff_cust_cty_nm", "ffCustCtyNm");
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
		this.hashFields.put("an_cust_cnt_cd", "anCustCntCd");
		this.hashFields.put("sh_cstms_decl_cnt_cd", "shCstmsDeclCntCd");
		this.hashFields.put("sh_cnt_seq", "shCntSeq");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("nf_cust_cty_nm", "nfCustCtyNm");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("cn_cust_to_ord_flg", "cnCustToOrdFlg");
		this.hashFields.put("nf_cust_eml", "nfCustEml");
		this.hashFields.put("nf_cust_fax_no", "nfCustFaxNo");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("cn_cust_ste_cd", "cnCustSteCd");
		this.hashFields.put("cn_cstms_decl_cnt_cd", "cnCstmsDeclCntCd");
		this.hashFields.put("an_cust_addr", "anCustAddr");
		this.hashFields.put("cn_cnt_seq", "cnCntSeq");
		this.hashFields.put("cn_addr_prn_flg", "cnAddrPrnFlg");
		this.hashFields.put("ff_cust_cnt_cd", "ffCustCntCd");
		this.hashFields.put("sh_cust_ste_cd", "shCustSteCd");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("sh_cust_tp", "shCustTp");
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
	 * @return ffCustEml
	 */
	public String getFfCustEml() {
		return this.ffCustEml;
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
	 * @return ffCustZipId
	 */
	public String getFfCustZipId() {
		return this.ffCustZipId;
	}
	
	/**
	 * Column Info
	 * @return exAddrPrnFlg
	 */
	public String getExAddrPrnFlg() {
		return this.exAddrPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return ffCustSteCd
	 */
	public String getFfCustSteCd() {
		return this.ffCustSteCd;
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
	 * @return ffAddrPrnFlg
	 */
	public String getFfAddrPrnFlg() {
		return this.ffAddrPrnFlg;
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
	 * @return ffCustFaxNo
	 */
	public String getFfCustFaxNo() {
		return this.ffCustFaxNo;
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
	 * @return nfAddrPrnFlg
	 */
	public String getNfAddrPrnFlg() {
		return this.nfAddrPrnFlg;
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
	 * @return ffCstmsDeclCntCd
	 */
	public String getFfCstmsDeclCntCd() {
		return this.ffCstmsDeclCntCd;
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
	 * @return shAddrPrnFlg
	 */
	public String getShAddrPrnFlg() {
		return this.shAddrPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return anAddrPrnFlg
	 */
	public String getAnAddrPrnFlg() {
		return this.anAddrPrnFlg;
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
	 * @return ffCustCtyNm
	 */
	public String getFfCustCtyNm() {
		return this.ffCustCtyNm;
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
	 * @return anCustCntCd
	 */
	public String getAnCustCntCd() {
		return this.anCustCntCd;
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
	 * @return shCntSeq
	 */
	public String getShCntSeq() {
		return this.shCntSeq;
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
	 * @return cnCustSteCd
	 */
	public String getCnCustSteCd() {
		return this.cnCustSteCd;
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
	 * @return cnAddrPrnFlg
	 */
	public String getCnAddrPrnFlg() {
		return this.cnAddrPrnFlg;
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
	 * @return shCustTp
	 */
	public String getShCustTp() {
		return this.shCustTp;
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
	 * @param ffCustEml
	 */
	public void setFfCustEml(String ffCustEml) {
		this.ffCustEml = ffCustEml;
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
	 * @param ffCustZipId
	 */
	public void setFfCustZipId(String ffCustZipId) {
		this.ffCustZipId = ffCustZipId;
	}
	
	/**
	 * Column Info
	 * @param exAddrPrnFlg
	 */
	public void setExAddrPrnFlg(String exAddrPrnFlg) {
		this.exAddrPrnFlg = exAddrPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param ffCustSteCd
	 */
	public void setFfCustSteCd(String ffCustSteCd) {
		this.ffCustSteCd = ffCustSteCd;
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
	 * @param ffAddrPrnFlg
	 */
	public void setFfAddrPrnFlg(String ffAddrPrnFlg) {
		this.ffAddrPrnFlg = ffAddrPrnFlg;
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
	 * @param ffCustFaxNo
	 */
	public void setFfCustFaxNo(String ffCustFaxNo) {
		this.ffCustFaxNo = ffCustFaxNo;
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
	 * @param nfAddrPrnFlg
	 */
	public void setNfAddrPrnFlg(String nfAddrPrnFlg) {
		this.nfAddrPrnFlg = nfAddrPrnFlg;
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
	 * @param ffCstmsDeclCntCd
	 */
	public void setFfCstmsDeclCntCd(String ffCstmsDeclCntCd) {
		this.ffCstmsDeclCntCd = ffCstmsDeclCntCd;
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
	 * @param shAddrPrnFlg
	 */
	public void setShAddrPrnFlg(String shAddrPrnFlg) {
		this.shAddrPrnFlg = shAddrPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param anAddrPrnFlg
	 */
	public void setAnAddrPrnFlg(String anAddrPrnFlg) {
		this.anAddrPrnFlg = anAddrPrnFlg;
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
	 * @param ffCustCtyNm
	 */
	public void setFfCustCtyNm(String ffCustCtyNm) {
		this.ffCustCtyNm = ffCustCtyNm;
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
	 * @param anCustCntCd
	 */
	public void setAnCustCntCd(String anCustCntCd) {
		this.anCustCntCd = anCustCntCd;
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
	 * @param shCntSeq
	 */
	public void setShCntSeq(String shCntSeq) {
		this.shCntSeq = shCntSeq;
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
	 * @param cnCustSteCd
	 */
	public void setCnCustSteCd(String cnCustSteCd) {
		this.cnCustSteCd = cnCustSteCd;
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
	 * @param cnAddrPrnFlg
	 */
	public void setCnAddrPrnFlg(String cnAddrPrnFlg) {
		this.cnAddrPrnFlg = cnAddrPrnFlg;
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
	 * @param shCustTp
	 */
	public void setShCustTp(String shCustTp) {
		this.shCustTp = shCustTp;
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
		setCnCustFaxNo(JSPUtil.getParameter(request, prefix + "cn_cust_fax_no", ""));
		setShKrCstmsCustTpCd(JSPUtil.getParameter(request, prefix + "sh_kr_cstms_cust_tp_cd", ""));
		setFfCustLglEngNm(JSPUtil.getParameter(request, prefix + "ff_cust_lgl_eng_nm", ""));
		setBrCustCntCd(JSPUtil.getParameter(request, prefix + "br_cust_cnt_cd", ""));
		setNfCustSteCd(JSPUtil.getParameter(request, prefix + "nf_cust_ste_cd", ""));
		setAnCntSeq(JSPUtil.getParameter(request, prefix + "an_cnt_seq", ""));
		setFfCustEml(JSPUtil.getParameter(request, prefix + "ff_cust_eml", ""));
		setShCustCtyNm(JSPUtil.getParameter(request, prefix + "sh_cust_cty_nm", ""));
		setExCustNm(JSPUtil.getParameter(request, prefix + "ex_cust_nm", ""));
		setCnCustAddr(JSPUtil.getParameter(request, prefix + "cn_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnCustEml(JSPUtil.getParameter(request, prefix + "cn_cust_eml", ""));
		setShCustSeq(JSPUtil.getParameter(request, prefix + "sh_cust_seq", ""));
		setFfCustZipId(JSPUtil.getParameter(request, prefix + "ff_cust_zip_id", ""));
		setExAddrPrnFlg(JSPUtil.getParameter(request, prefix + "ex_addr_prn_flg", ""));
		setFfCustSteCd(JSPUtil.getParameter(request, prefix + "ff_cust_ste_cd", ""));
		setNfCustCntCd(JSPUtil.getParameter(request, prefix + "nf_cust_cnt_cd", ""));
		setBrCustNm(JSPUtil.getParameter(request, prefix + "br_cust_nm", ""));
		setAnCustNm(JSPUtil.getParameter(request, prefix + "an_cust_nm", ""));
		setNfCustSeq(JSPUtil.getParameter(request, prefix + "nf_cust_seq", ""));
		setAnCustSeq(JSPUtil.getParameter(request, prefix + "an_cust_seq", ""));
		setCnCustLglEngNm(JSPUtil.getParameter(request, prefix + "cn_cust_lgl_eng_nm", ""));
		setNfCustZipId(JSPUtil.getParameter(request, prefix + "nf_cust_zip_id", ""));
		setFfAddrPrnFlg(JSPUtil.getParameter(request, prefix + "ff_addr_prn_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setNfCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "nf_cstms_decl_cnt_cd", ""));
		setFfCustFaxNo(JSPUtil.getParameter(request, prefix + "ff_cust_fax_no", ""));
		setShCustZipId(JSPUtil.getParameter(request, prefix + "sh_cust_zip_id", ""));
		setNfAddrPrnFlg(JSPUtil.getParameter(request, prefix + "nf_addr_prn_flg", ""));
		setBrCustAddr(JSPUtil.getParameter(request, prefix + "br_cust_addr", ""));
		setFfCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "ff_cstms_decl_cnt_cd", ""));
		setShCustLglEngNm(JSPUtil.getParameter(request, prefix + "sh_cust_lgl_eng_nm", ""));
		setNfCntSeq(JSPUtil.getParameter(request, prefix + "nf_cnt_seq", ""));
		setShAddrPrnFlg(JSPUtil.getParameter(request, prefix + "sh_addr_prn_flg", ""));
		setAnAddrPrnFlg(JSPUtil.getParameter(request, prefix + "an_addr_prn_flg", ""));
		setShCustCntCd(JSPUtil.getParameter(request, prefix + "sh_cust_cnt_cd", ""));
		setNfCustLglEngNm(JSPUtil.getParameter(request, prefix + "nf_cust_lgl_eng_nm", ""));
		setFfCustCtyNm(JSPUtil.getParameter(request, prefix + "ff_cust_cty_nm", ""));
		setCnCustZipId(JSPUtil.getParameter(request, prefix + "cn_cust_zip_id", ""));
		setCnCustCtyNm(JSPUtil.getParameter(request, prefix + "cn_cust_cty_nm", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, prefix + "cn_cust_cnt_cd", ""));
		setFfCustSeq(JSPUtil.getParameter(request, prefix + "ff_cust_seq", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setAnCustLglEngNm(JSPUtil.getParameter(request, prefix + "an_cust_lgl_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnCustSeq(JSPUtil.getParameter(request, prefix + "cn_cust_seq", ""));
		setFfCustNm(JSPUtil.getParameter(request, prefix + "ff_cust_nm", ""));
		setFfCustAddr(JSPUtil.getParameter(request, prefix + "ff_cust_addr", ""));
		setAnCustCntCd(JSPUtil.getParameter(request, prefix + "an_cust_cnt_cd", ""));
		setShCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "sh_cstms_decl_cnt_cd", ""));
		setShCntSeq(JSPUtil.getParameter(request, prefix + "sh_cnt_seq", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setNfCustCtyNm(JSPUtil.getParameter(request, prefix + "nf_cust_cty_nm", ""));
		setNfCustAddr(JSPUtil.getParameter(request, prefix + "nf_cust_addr", ""));
		setCnCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cn_cust_to_ord_flg", ""));
		setNfCustEml(JSPUtil.getParameter(request, prefix + "nf_cust_eml", ""));
		setNfCustFaxNo(JSPUtil.getParameter(request, prefix + "nf_cust_fax_no", ""));
		setShCustAddr(JSPUtil.getParameter(request, prefix + "sh_cust_addr", ""));
		setCnCustSteCd(JSPUtil.getParameter(request, prefix + "cn_cust_ste_cd", ""));
		setCnCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cn_cstms_decl_cnt_cd", ""));
		setAnCustAddr(JSPUtil.getParameter(request, prefix + "an_cust_addr", ""));
		setCnCntSeq(JSPUtil.getParameter(request, prefix + "cn_cnt_seq", ""));
		setCnAddrPrnFlg(JSPUtil.getParameter(request, prefix + "cn_addr_prn_flg", ""));
		setFfCustCntCd(JSPUtil.getParameter(request, prefix + "ff_cust_cnt_cd", ""));
		setShCustSteCd(JSPUtil.getParameter(request, prefix + "sh_cust_ste_cd", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setShCustTp(JSPUtil.getParameter(request, prefix + "sh_cust_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchXterBlDocCustVO[]
	 */
	public searchXterBlDocCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchXterBlDocCustVO[]
	 */
	public searchXterBlDocCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchXterBlDocCustVO model = null;
		
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
			String[] ffCustEml = (JSPUtil.getParameter(request, prefix	+ "ff_cust_eml", length));
			String[] shCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cty_nm", length));
			String[] exCustNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_nm", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnCustEml = (JSPUtil.getParameter(request, prefix	+ "cn_cust_eml", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] ffCustZipId = (JSPUtil.getParameter(request, prefix	+ "ff_cust_zip_id", length));
			String[] exAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "ex_addr_prn_flg", length));
			String[] ffCustSteCd = (JSPUtil.getParameter(request, prefix	+ "ff_cust_ste_cd", length));
			String[] nfCustCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt_cd", length));
			String[] brCustNm = (JSPUtil.getParameter(request, prefix	+ "br_cust_nm", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] nfCustSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cust_seq", length));
			String[] anCustSeq = (JSPUtil.getParameter(request, prefix	+ "an_cust_seq", length));
			String[] cnCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_lgl_eng_nm", length));
			String[] nfCustZipId = (JSPUtil.getParameter(request, prefix	+ "nf_cust_zip_id", length));
			String[] ffAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "ff_addr_prn_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] nfCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cstms_decl_cnt_cd", length));
			String[] ffCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "ff_cust_fax_no", length));
			String[] shCustZipId = (JSPUtil.getParameter(request, prefix	+ "sh_cust_zip_id", length));
			String[] nfAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "nf_addr_prn_flg", length));
			String[] brCustAddr = (JSPUtil.getParameter(request, prefix	+ "br_cust_addr", length));
			String[] ffCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cstms_decl_cnt_cd", length));
			String[] shCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_lgl_eng_nm", length));
			String[] nfCntSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cnt_seq", length));
			String[] shAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "sh_addr_prn_flg", length));
			String[] anAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "an_addr_prn_flg", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] nfCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_lgl_eng_nm", length));
			String[] ffCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_cty_nm", length));
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
			String[] anCustCntCd = (JSPUtil.getParameter(request, prefix	+ "an_cust_cnt_cd", length));
			String[] shCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cstms_decl_cnt_cd", length));
			String[] shCntSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cnt_seq", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] nfCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cty_nm", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] cnCustToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cn_cust_to_ord_flg", length));
			String[] nfCustEml = (JSPUtil.getParameter(request, prefix	+ "nf_cust_eml", length));
			String[] nfCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "nf_cust_fax_no", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] cnCustSteCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_ste_cd", length));
			String[] cnCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cstms_decl_cnt_cd", length));
			String[] anCustAddr = (JSPUtil.getParameter(request, prefix	+ "an_cust_addr", length));
			String[] cnCntSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cnt_seq", length));
			String[] cnAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cn_addr_prn_flg", length));
			String[] ffCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cust_cnt_cd", length));
			String[] shCustSteCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_ste_cd", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] shCustTp = (JSPUtil.getParameter(request, prefix	+ "sh_cust_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchXterBlDocCustVO();
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
				if (ffCustEml[i] != null)
					model.setFfCustEml(ffCustEml[i]);
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
				if (ffCustZipId[i] != null)
					model.setFfCustZipId(ffCustZipId[i]);
				if (exAddrPrnFlg[i] != null)
					model.setExAddrPrnFlg(exAddrPrnFlg[i]);
				if (ffCustSteCd[i] != null)
					model.setFfCustSteCd(ffCustSteCd[i]);
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
				if (ffAddrPrnFlg[i] != null)
					model.setFfAddrPrnFlg(ffAddrPrnFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (nfCstmsDeclCntCd[i] != null)
					model.setNfCstmsDeclCntCd(nfCstmsDeclCntCd[i]);
				if (ffCustFaxNo[i] != null)
					model.setFfCustFaxNo(ffCustFaxNo[i]);
				if (shCustZipId[i] != null)
					model.setShCustZipId(shCustZipId[i]);
				if (nfAddrPrnFlg[i] != null)
					model.setNfAddrPrnFlg(nfAddrPrnFlg[i]);
				if (brCustAddr[i] != null)
					model.setBrCustAddr(brCustAddr[i]);
				if (ffCstmsDeclCntCd[i] != null)
					model.setFfCstmsDeclCntCd(ffCstmsDeclCntCd[i]);
				if (shCustLglEngNm[i] != null)
					model.setShCustLglEngNm(shCustLglEngNm[i]);
				if (nfCntSeq[i] != null)
					model.setNfCntSeq(nfCntSeq[i]);
				if (shAddrPrnFlg[i] != null)
					model.setShAddrPrnFlg(shAddrPrnFlg[i]);
				if (anAddrPrnFlg[i] != null)
					model.setAnAddrPrnFlg(anAddrPrnFlg[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (nfCustLglEngNm[i] != null)
					model.setNfCustLglEngNm(nfCustLglEngNm[i]);
				if (ffCustCtyNm[i] != null)
					model.setFfCustCtyNm(ffCustCtyNm[i]);
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
				if (anCustCntCd[i] != null)
					model.setAnCustCntCd(anCustCntCd[i]);
				if (shCstmsDeclCntCd[i] != null)
					model.setShCstmsDeclCntCd(shCstmsDeclCntCd[i]);
				if (shCntSeq[i] != null)
					model.setShCntSeq(shCntSeq[i]);
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
				if (cnCustSteCd[i] != null)
					model.setCnCustSteCd(cnCustSteCd[i]);
				if (cnCstmsDeclCntCd[i] != null)
					model.setCnCstmsDeclCntCd(cnCstmsDeclCntCd[i]);
				if (anCustAddr[i] != null)
					model.setAnCustAddr(anCustAddr[i]);
				if (cnCntSeq[i] != null)
					model.setCnCntSeq(cnCntSeq[i]);
				if (cnAddrPrnFlg[i] != null)
					model.setCnAddrPrnFlg(cnAddrPrnFlg[i]);
				if (ffCustCntCd[i] != null)
					model.setFfCustCntCd(ffCustCntCd[i]);
				if (shCustSteCd[i] != null)
					model.setShCustSteCd(shCustSteCd[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (shCustTp[i] != null)
					model.setShCustTp(shCustTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchXterBlDocCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchXterBlDocCustVO[]
	 */
	public searchXterBlDocCustVO[] getsearchXterBlDocCustVOs(){
		searchXterBlDocCustVO[] vos = (searchXterBlDocCustVO[])models.toArray(new searchXterBlDocCustVO[models.size()]);
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
		this.cnCustFaxNo = this.cnCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shKrCstmsCustTpCd = this.shKrCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustLglEngNm = this.ffCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustCntCd = this.brCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSteCd = this.nfCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCntSeq = this.anCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustEml = this.ffCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCtyNm = this.shCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustNm = this.exCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustEml = this.cnCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustZipId = this.ffCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exAddrPrnFlg = this.exAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSteCd = this.ffCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCntCd = this.nfCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustNm = this.brCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSeq = this.nfCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustSeq = this.anCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustLglEngNm = this.cnCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustZipId = this.nfCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffAddrPrnFlg = this.ffAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCstmsDeclCntCd = this.nfCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustFaxNo = this.ffCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustZipId = this.shCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfAddrPrnFlg = this.nfAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustAddr = this.brCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCstmsDeclCntCd = this.ffCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustLglEngNm = this.shCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCntSeq = this.nfCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shAddrPrnFlg = this.shAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anAddrPrnFlg = this.anAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustLglEngNm = this.nfCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustCtyNm = this.ffCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.anCustCntCd = this.anCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCstmsDeclCntCd = this.shCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCntSeq = this.shCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCtyNm = this.nfCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustToOrdFlg = this.cnCustToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustEml = this.nfCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustFaxNo = this.nfCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSteCd = this.cnCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCstmsDeclCntCd = this.cnCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustAddr = this.anCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCntSeq = this.cnCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnAddrPrnFlg = this.cnAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustCntCd = this.ffCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSteCd = this.shCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustTp = this.shCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
