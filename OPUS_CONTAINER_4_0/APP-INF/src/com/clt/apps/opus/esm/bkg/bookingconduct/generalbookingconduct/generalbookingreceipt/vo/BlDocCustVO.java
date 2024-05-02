/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlDocCustVO.java
*@FileTitle : BlDocCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlDocCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlDocCustVO> models = new ArrayList<BlDocCustVO>();
	
	/* Column Info */
	private String cnCustFaxNo = null;
	/* Column Info */
	private String ffCustLglEngNm = null;
	/* Column Info */
	private String anCstmsDeclCntCd = null;
	/* Column Info */
	private String brCustCntCd = null;
	/* Column Info */
	private String nfCustSteCd = null;
	/* Column Info */
	private String ffCustEml = null;
	/* Column Info */
	private String shCustCtyNm = null;
	/* Column Info */
	private String exCustNm = null;
	/* Column Info */
	private String anCustSteCd = null;
	/* Column Info */
	private String cnCustAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnCustEml = null;
	/* Column Info */
	private String cnMdmAddress = null;
	/* Column Info */
	private String shCustSeq = null;
	/* Column Info */
	private String ffCustTp = null;
	/* Column Info */
	private String ffCustZipId = null;
	/* Column Info */
	private String nfMdmAddress = null;
	/* Column Info */
	private String exAddrPrnFlg = null;
	/* Column Info */
	private String ffCustSteCd = null;
	/* Column Info */
	private String shEurCstmsStNm = null;
	/* Column Info */
	private String nfCustCntCd = null;
	/* Column Info */
	private String exCustSeq = null;
	/* Column Info */
	private String brCustNm = null;
	/* Column Info */
	private String anCustNm = null;
	/* Column Info */
	private String shEoriNo = null;
	/* Column Info */
	private String nfCustSeq = null;
	/* Column Info */
	private String anCustSeq = null;
	/* Column Info */
	private String cnCustLglEngNm = null;
	/* Column Info */
	private String nfCustZipId = null;
	/* Column Info */
	private String shMdmAddress = null;
	/* Column Info */
	private String anMdmAddress = null;
	/* Column Info */
	private String ffAddrPrnFlg = null;
	/* Column Info */
	private String nfEoriNo = null;
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
	private String brCustSeq = null;
	/* Column Info */
	private String nfAddrPrnFlg = null;
	/* Column Info */
	private String brCustAddr = null;
	/* Column Info */
	private String ffCstmsDeclCntCd = null;
	/* Column Info */
	private String shCustLglEngNm = null;
	/* Column Info */
	private String shAddrPrnFlg = null;
	/* Column Info */
	private String anAddrPrnFlg = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String nfCustLglEngNm = null;
	/* Column Info */
	private String cnCustTp = null;
	/* Column Info */
	private String anCustEml = null;
	/* Column Info */
	private String cnEoriNo = null;
	/* Column Info */
	private String ffCustCtyNm = null;
	/* Column Info */
	private String cnCustZipId = null;
	/* Column Info */
	private String ffCustSeq = null;
	/* Column Info */
	private String cnCustCtyNm = null;
	/* Column Info */
	private String cnCustCntCd = null;
	/* Column Info */
	private String anCustTp = null;
	/* Column Info */
	private String anCustLglEngNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffCustNm = null;
	/* Column Info */
	private String cnCustSeq = null;
	/* Column Info */
	private String ffCustAddr = null;
	/* Column Info */
	private String nfEurCstmsStNm = null;
	/* Column Info */
	private String anCustCntCd = null;
	/* Column Info */
	private String shCstmsDeclCntCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String nfCustCtyNm = null;
	/* Column Info */
	private String nfCustAddr = null;
	/* Column Info */
	private String nfCustEml = null;
	/* Column Info */
	private String anCustFaxNo = null;
	/* Column Info */
	private String nfCustFaxNo = null;
	/* Column Info */
	private String shCustAddr = null;
	/* Column Info */
	private String cnCustSteCd = null;
	/* Column Info */
	private String cnCstmsDeclCntCd = null;
	/* Column Info */
	private String anCustZipId = null;
	/* Column Info */
	private String anCustAddr = null;
	/* Column Info */
	private String cnEurCstmsStNm = null;
	/* Column Info */
	private String cnAddrPrnFlg = null;
	/* Column Info */
	private String ffCustCntCd = null;
	/* Column Info */
	private String nfCustTp = null;
	/* Column Info */
	private String ffMdmAddress = null;
	/* Column Info */
	private String shCustSteCd = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String shCustTp = null;
	/* Column Info */
	private String exCustCntCd = null;
    /* Column Info */
    private String nmAndAddrOvflwFlg = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlDocCustVO() {}

	public BlDocCustVO(String ibflag, String pagerows, String bkgNo, String shCustCntCd, String shCustSeq, String shCustLglEngNm, String shCustNm, String shAddrPrnFlg, String shCustAddr, String shCustCtyNm, String shCustSteCd, String shCstmsDeclCntCd, String shCustZipId, String shEurCstmsStNm, String shEoriNo, String shCustTp, String shMdmAddress, String cnCustCntCd, String cnCustSeq, String cnCustLglEngNm, String cnCustNm, String cnAddrPrnFlg, String cnCustAddr, String cnCustCtyNm, String cnCustSteCd, String cnCstmsDeclCntCd, String cnCustZipId, String cnCustFaxNo, String cnCustEml, String cnEurCstmsStNm, String cnEoriNo, String cnCustTp, String cnMdmAddress, String nfCustCntCd, String nfCustSeq, String nfCustLglEngNm, String nfCustNm, String nfAddrPrnFlg, String nfCustAddr, String nfCustCtyNm, String nfCustSteCd, String nfCstmsDeclCntCd, String nfCustZipId, String nfCustFaxNo, String nfCustEml, String nfEurCstmsStNm, String nfEoriNo, String nfCustTp, String nfMdmAddress, String ffCustCntCd, String ffCustSeq, String ffCustLglEngNm, String ffCustNm, String ffCustAddr, String ffAddrPrnFlg, String ffCustCtyNm, String ffCustSteCd, String ffCstmsDeclCntCd, String ffCustZipId, String ffCustFaxNo, String ffCustEml, String ffCustTp, String ffMdmAddress, String anCustCntCd, String anCustSeq, String anCustLglEngNm, String anCustNm, String anCustAddr, String anAddrPrnFlg, String anCustSteCd, String anCstmsDeclCntCd, String anCustZipId, String anCustFaxNo, String anCustEml, String anCustTp, String anMdmAddress, String exCustCntCd, String exCustSeq, String exCustNm, String exAddrPrnFlg, String brCustCntCd, String brCustSeq, String brCustNm, String brCustAddr, String nmAndAddrOvflwFlg) {
		this.cnCustFaxNo = cnCustFaxNo;
		this.ffCustLglEngNm = ffCustLglEngNm;
		this.anCstmsDeclCntCd = anCstmsDeclCntCd;
		this.brCustCntCd = brCustCntCd;
		this.nfCustSteCd = nfCustSteCd;
		this.ffCustEml = ffCustEml;
		this.shCustCtyNm = shCustCtyNm;
		this.exCustNm = exCustNm;
		this.anCustSteCd = anCustSteCd;
		this.cnCustAddr = cnCustAddr;
		this.pagerows = pagerows;
		this.cnCustEml = cnCustEml;
		this.cnMdmAddress = cnMdmAddress;
		this.shCustSeq = shCustSeq;
		this.ffCustTp = ffCustTp;
		this.ffCustZipId = ffCustZipId;
		this.nfMdmAddress = nfMdmAddress;
		this.exAddrPrnFlg = exAddrPrnFlg;
		this.ffCustSteCd = ffCustSteCd;
		this.shEurCstmsStNm = shEurCstmsStNm;
		this.nfCustCntCd = nfCustCntCd;
		this.exCustSeq = exCustSeq;
		this.brCustNm = brCustNm;
		this.anCustNm = anCustNm;
		this.shEoriNo = shEoriNo;
		this.nfCustSeq = nfCustSeq;
		this.anCustSeq = anCustSeq;
		this.cnCustLglEngNm = cnCustLglEngNm;
		this.nfCustZipId = nfCustZipId;
		this.shMdmAddress = shMdmAddress;
		this.anMdmAddress = anMdmAddress;
		this.ffAddrPrnFlg = ffAddrPrnFlg;
		this.nfEoriNo = nfEoriNo;
		this.bkgNo = bkgNo;
		this.shCustNm = shCustNm;
		this.nfCstmsDeclCntCd = nfCstmsDeclCntCd;
		this.ffCustFaxNo = ffCustFaxNo;
		this.shCustZipId = shCustZipId;
		this.brCustSeq = brCustSeq;
		this.nfAddrPrnFlg = nfAddrPrnFlg;
		this.brCustAddr = brCustAddr;
		this.ffCstmsDeclCntCd = ffCstmsDeclCntCd;
		this.shCustLglEngNm = shCustLglEngNm;
		this.shAddrPrnFlg = shAddrPrnFlg;
		this.anAddrPrnFlg = anAddrPrnFlg;
		this.shCustCntCd = shCustCntCd;
		this.nfCustLglEngNm = nfCustLglEngNm;
		this.cnCustTp = cnCustTp;
		this.anCustEml = anCustEml;
		this.cnEoriNo = cnEoriNo;
		this.ffCustCtyNm = ffCustCtyNm;
		this.cnCustZipId = cnCustZipId;
		this.ffCustSeq = ffCustSeq;
		this.cnCustCtyNm = cnCustCtyNm;
		this.cnCustCntCd = cnCustCntCd;
		this.anCustTp = anCustTp;
		this.anCustLglEngNm = anCustLglEngNm;
		this.ibflag = ibflag;
		this.ffCustNm = ffCustNm;
		this.cnCustSeq = cnCustSeq;
		this.ffCustAddr = ffCustAddr;
		this.nfEurCstmsStNm = nfEurCstmsStNm;
		this.anCustCntCd = anCustCntCd;
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
		this.nfCustNm = nfCustNm;
		this.nfCustCtyNm = nfCustCtyNm;
		this.nfCustAddr = nfCustAddr;
		this.nfCustEml = nfCustEml;
		this.anCustFaxNo = anCustFaxNo;
		this.nfCustFaxNo = nfCustFaxNo;
		this.shCustAddr = shCustAddr;
		this.cnCustSteCd = cnCustSteCd;
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
		this.anCustZipId = anCustZipId;
		this.anCustAddr = anCustAddr;
		this.cnEurCstmsStNm = cnEurCstmsStNm;
		this.cnAddrPrnFlg = cnAddrPrnFlg;
		this.ffCustCntCd = ffCustCntCd;
		this.nfCustTp = nfCustTp;
		this.ffMdmAddress = ffMdmAddress;
		this.shCustSteCd = shCustSteCd;
		this.cnCustNm = cnCustNm;
		this.shCustTp = shCustTp;
		this.exCustCntCd = exCustCntCd;
        this.nmAndAddrOvflwFlg = nmAndAddrOvflwFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cn_cust_fax_no", getCnCustFaxNo());
		this.hashColumns.put("ff_cust_lgl_eng_nm", getFfCustLglEngNm());
		this.hashColumns.put("an_cstms_decl_cnt_cd", getAnCstmsDeclCntCd());
		this.hashColumns.put("br_cust_cnt_cd", getBrCustCntCd());
		this.hashColumns.put("nf_cust_ste_cd", getNfCustSteCd());
		this.hashColumns.put("ff_cust_eml", getFfCustEml());
		this.hashColumns.put("sh_cust_cty_nm", getShCustCtyNm());
		this.hashColumns.put("ex_cust_nm", getExCustNm());
		this.hashColumns.put("an_cust_ste_cd", getAnCustSteCd());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cn_cust_eml", getCnCustEml());
		this.hashColumns.put("cn_mdm_address", getCnMdmAddress());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("ff_cust_tp", getFfCustTp());
		this.hashColumns.put("ff_cust_zip_id", getFfCustZipId());
		this.hashColumns.put("nf_mdm_address", getNfMdmAddress());
		this.hashColumns.put("ex_addr_prn_flg", getExAddrPrnFlg());
		this.hashColumns.put("ff_cust_ste_cd", getFfCustSteCd());
		this.hashColumns.put("sh_eur_cstms_st_nm", getShEurCstmsStNm());
		this.hashColumns.put("nf_cust_cnt_cd", getNfCustCntCd());
		this.hashColumns.put("ex_cust_seq", getExCustSeq());
		this.hashColumns.put("br_cust_nm", getBrCustNm());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("sh_eori_no", getShEoriNo());
		this.hashColumns.put("nf_cust_seq", getNfCustSeq());
		this.hashColumns.put("an_cust_seq", getAnCustSeq());
		this.hashColumns.put("cn_cust_lgl_eng_nm", getCnCustLglEngNm());
		this.hashColumns.put("nf_cust_zip_id", getNfCustZipId());
		this.hashColumns.put("sh_mdm_address", getShMdmAddress());
		this.hashColumns.put("an_mdm_address", getAnMdmAddress());
		this.hashColumns.put("ff_addr_prn_flg", getFfAddrPrnFlg());
		this.hashColumns.put("nf_eori_no", getNfEoriNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("nf_cstms_decl_cnt_cd", getNfCstmsDeclCntCd());
		this.hashColumns.put("ff_cust_fax_no", getFfCustFaxNo());
		this.hashColumns.put("sh_cust_zip_id", getShCustZipId());
		this.hashColumns.put("br_cust_seq", getBrCustSeq());
		this.hashColumns.put("nf_addr_prn_flg", getNfAddrPrnFlg());
		this.hashColumns.put("br_cust_addr", getBrCustAddr());
		this.hashColumns.put("ff_cstms_decl_cnt_cd", getFfCstmsDeclCntCd());
		this.hashColumns.put("sh_cust_lgl_eng_nm", getShCustLglEngNm());
		this.hashColumns.put("sh_addr_prn_flg", getShAddrPrnFlg());
		this.hashColumns.put("an_addr_prn_flg", getAnAddrPrnFlg());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("nf_cust_lgl_eng_nm", getNfCustLglEngNm());
		this.hashColumns.put("cn_cust_tp", getCnCustTp());
		this.hashColumns.put("an_cust_eml", getAnCustEml());
		this.hashColumns.put("cn_eori_no", getCnEoriNo());
		this.hashColumns.put("ff_cust_cty_nm", getFfCustCtyNm());
		this.hashColumns.put("cn_cust_zip_id", getCnCustZipId());
		this.hashColumns.put("ff_cust_seq", getFfCustSeq());
		this.hashColumns.put("cn_cust_cty_nm", getCnCustCtyNm());
		this.hashColumns.put("cn_cust_cnt_cd", getCnCustCntCd());
		this.hashColumns.put("an_cust_tp", getAnCustTp());
		this.hashColumns.put("an_cust_lgl_eng_nm", getAnCustLglEngNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ff_cust_nm", getFfCustNm());
		this.hashColumns.put("cn_cust_seq", getCnCustSeq());
		this.hashColumns.put("ff_cust_addr", getFfCustAddr());
		this.hashColumns.put("nf_eur_cstms_st_nm", getNfEurCstmsStNm());
		this.hashColumns.put("an_cust_cnt_cd", getAnCustCntCd());
		this.hashColumns.put("sh_cstms_decl_cnt_cd", getShCstmsDeclCntCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("nf_cust_cty_nm", getNfCustCtyNm());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("nf_cust_eml", getNfCustEml());
		this.hashColumns.put("an_cust_fax_no", getAnCustFaxNo());
		this.hashColumns.put("nf_cust_fax_no", getNfCustFaxNo());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("cn_cust_ste_cd", getCnCustSteCd());
		this.hashColumns.put("cn_cstms_decl_cnt_cd", getCnCstmsDeclCntCd());
		this.hashColumns.put("an_cust_zip_id", getAnCustZipId());
		this.hashColumns.put("an_cust_addr", getAnCustAddr());
		this.hashColumns.put("cn_eur_cstms_st_nm", getCnEurCstmsStNm());
		this.hashColumns.put("cn_addr_prn_flg", getCnAddrPrnFlg());
		this.hashColumns.put("ff_cust_cnt_cd", getFfCustCntCd());
		this.hashColumns.put("nf_cust_tp", getNfCustTp());
		this.hashColumns.put("ff_mdm_address", getFfMdmAddress());
		this.hashColumns.put("sh_cust_ste_cd", getShCustSteCd());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("sh_cust_tp", getShCustTp());
		this.hashColumns.put("ex_cust_cnt_cd", getExCustCntCd());
        this.hashColumns.put("nm_and_addr_ovflw_flg", getNmAndAddrOvflwFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cn_cust_fax_no", "cnCustFaxNo");
		this.hashFields.put("ff_cust_lgl_eng_nm", "ffCustLglEngNm");
		this.hashFields.put("an_cstms_decl_cnt_cd", "anCstmsDeclCntCd");
		this.hashFields.put("br_cust_cnt_cd", "brCustCntCd");
		this.hashFields.put("nf_cust_ste_cd", "nfCustSteCd");
		this.hashFields.put("ff_cust_eml", "ffCustEml");
		this.hashFields.put("sh_cust_cty_nm", "shCustCtyNm");
		this.hashFields.put("ex_cust_nm", "exCustNm");
		this.hashFields.put("an_cust_ste_cd", "anCustSteCd");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cn_cust_eml", "cnCustEml");
		this.hashFields.put("cn_mdm_address", "cnMdmAddress");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("ff_cust_tp", "ffCustTp");
		this.hashFields.put("ff_cust_zip_id", "ffCustZipId");
		this.hashFields.put("nf_mdm_address", "nfMdmAddress");
		this.hashFields.put("ex_addr_prn_flg", "exAddrPrnFlg");
		this.hashFields.put("ff_cust_ste_cd", "ffCustSteCd");
		this.hashFields.put("sh_eur_cstms_st_nm", "shEurCstmsStNm");
		this.hashFields.put("nf_cust_cnt_cd", "nfCustCntCd");
		this.hashFields.put("ex_cust_seq", "exCustSeq");
		this.hashFields.put("br_cust_nm", "brCustNm");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("sh_eori_no", "shEoriNo");
		this.hashFields.put("nf_cust_seq", "nfCustSeq");
		this.hashFields.put("an_cust_seq", "anCustSeq");
		this.hashFields.put("cn_cust_lgl_eng_nm", "cnCustLglEngNm");
		this.hashFields.put("nf_cust_zip_id", "nfCustZipId");
		this.hashFields.put("sh_mdm_address", "shMdmAddress");
		this.hashFields.put("an_mdm_address", "anMdmAddress");
		this.hashFields.put("ff_addr_prn_flg", "ffAddrPrnFlg");
		this.hashFields.put("nf_eori_no", "nfEoriNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("nf_cstms_decl_cnt_cd", "nfCstmsDeclCntCd");
		this.hashFields.put("ff_cust_fax_no", "ffCustFaxNo");
		this.hashFields.put("sh_cust_zip_id", "shCustZipId");
		this.hashFields.put("br_cust_seq", "brCustSeq");
		this.hashFields.put("nf_addr_prn_flg", "nfAddrPrnFlg");
		this.hashFields.put("br_cust_addr", "brCustAddr");
		this.hashFields.put("ff_cstms_decl_cnt_cd", "ffCstmsDeclCntCd");
		this.hashFields.put("sh_cust_lgl_eng_nm", "shCustLglEngNm");
		this.hashFields.put("sh_addr_prn_flg", "shAddrPrnFlg");
		this.hashFields.put("an_addr_prn_flg", "anAddrPrnFlg");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("nf_cust_lgl_eng_nm", "nfCustLglEngNm");
		this.hashFields.put("cn_cust_tp", "cnCustTp");
		this.hashFields.put("an_cust_eml", "anCustEml");
		this.hashFields.put("cn_eori_no", "cnEoriNo");
		this.hashFields.put("ff_cust_cty_nm", "ffCustCtyNm");
		this.hashFields.put("cn_cust_zip_id", "cnCustZipId");
		this.hashFields.put("ff_cust_seq", "ffCustSeq");
		this.hashFields.put("cn_cust_cty_nm", "cnCustCtyNm");
		this.hashFields.put("cn_cust_cnt_cd", "cnCustCntCd");
		this.hashFields.put("an_cust_tp", "anCustTp");
		this.hashFields.put("an_cust_lgl_eng_nm", "anCustLglEngNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ff_cust_nm", "ffCustNm");
		this.hashFields.put("cn_cust_seq", "cnCustSeq");
		this.hashFields.put("ff_cust_addr", "ffCustAddr");
		this.hashFields.put("nf_eur_cstms_st_nm", "nfEurCstmsStNm");
		this.hashFields.put("an_cust_cnt_cd", "anCustCntCd");
		this.hashFields.put("sh_cstms_decl_cnt_cd", "shCstmsDeclCntCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("nf_cust_cty_nm", "nfCustCtyNm");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("nf_cust_eml", "nfCustEml");
		this.hashFields.put("an_cust_fax_no", "anCustFaxNo");
		this.hashFields.put("nf_cust_fax_no", "nfCustFaxNo");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("cn_cust_ste_cd", "cnCustSteCd");
		this.hashFields.put("cn_cstms_decl_cnt_cd", "cnCstmsDeclCntCd");
		this.hashFields.put("an_cust_zip_id", "anCustZipId");
		this.hashFields.put("an_cust_addr", "anCustAddr");
		this.hashFields.put("cn_eur_cstms_st_nm", "cnEurCstmsStNm");
		this.hashFields.put("cn_addr_prn_flg", "cnAddrPrnFlg");
		this.hashFields.put("ff_cust_cnt_cd", "ffCustCntCd");
		this.hashFields.put("nf_cust_tp", "nfCustTp");
		this.hashFields.put("ff_mdm_address", "ffMdmAddress");
		this.hashFields.put("sh_cust_ste_cd", "shCustSteCd");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("sh_cust_tp", "shCustTp");
		this.hashFields.put("ex_cust_cnt_cd", "exCustCntCd");
        this.hashFields.put("nm_and_addr_ovflw_flg", "nmAndAddrOvflwFlg");
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
	 * @return ffCustLglEngNm
	 */
	public String getFfCustLglEngNm() {
		return this.ffCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return anCstmsDeclCntCd
	 */
	public String getAnCstmsDeclCntCd() {
		return this.anCstmsDeclCntCd;
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
	 * @return anCustSteCd
	 */
	public String getAnCustSteCd() {
		return this.anCustSteCd;
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
	 * @return cnMdmAddress
	 */
	public String getCnMdmAddress() {
		return this.cnMdmAddress;
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
	 * @return ffCustTp
	 */
	public String getFfCustTp() {
		return this.ffCustTp;
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
	 * @return nfMdmAddress
	 */
	public String getNfMdmAddress() {
		return this.nfMdmAddress;
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
	 * @return shEurCstmsStNm
	 */
	public String getShEurCstmsStNm() {
		return this.shEurCstmsStNm;
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
	 * @return exCustSeq
	 */
	public String getExCustSeq() {
		return this.exCustSeq;
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
	 * @return shEoriNo
	 */
	public String getShEoriNo() {
		return this.shEoriNo;
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
	 * @return shMdmAddress
	 */
	public String getShMdmAddress() {
		return this.shMdmAddress;
	}
	
	/**
	 * Column Info
	 * @return anMdmAddress
	 */
	public String getAnMdmAddress() {
		return this.anMdmAddress;
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
	 * @return nfEoriNo
	 */
	public String getNfEoriNo() {
		return this.nfEoriNo;
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
	 * @return brCustSeq
	 */
	public String getBrCustSeq() {
		return this.brCustSeq;
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
	 * @return cnCustTp
	 */
	public String getCnCustTp() {
		return this.cnCustTp;
	}
	
	/**
	 * Column Info
	 * @return anCustEml
	 */
	public String getAnCustEml() {
		return this.anCustEml;
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
	 * @return ffCustSeq
	 */
	public String getFfCustSeq() {
		return this.ffCustSeq;
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
	 * @return anCustTp
	 */
	public String getAnCustTp() {
		return this.anCustTp;
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
	 * @return ffCustNm
	 */
	public String getFfCustNm() {
		return this.ffCustNm;
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
	 * @return ffCustAddr
	 */
	public String getFfCustAddr() {
		return this.ffCustAddr;
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
	 * @return nfCustEml
	 */
	public String getNfCustEml() {
		return this.nfCustEml;
	}
	
	/**
	 * Column Info
	 * @return anCustFaxNo
	 */
	public String getAnCustFaxNo() {
		return this.anCustFaxNo;
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
	 * @return anCustZipId
	 */
	public String getAnCustZipId() {
		return this.anCustZipId;
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
	 * @return cnEurCstmsStNm
	 */
	public String getCnEurCstmsStNm() {
		return this.cnEurCstmsStNm;
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
	 * @return nfCustTp
	 */
	public String getNfCustTp() {
		return this.nfCustTp;
	}
	
	/**
	 * Column Info
	 * @return ffMdmAddress
	 */
	public String getFfMdmAddress() {
		return this.ffMdmAddress;
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
	 * @return exCustCntCd
	 */
	public String getExCustCntCd() {
		return this.exCustCntCd;
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
	 * @param ffCustLglEngNm
	 */
	public void setFfCustLglEngNm(String ffCustLglEngNm) {
		this.ffCustLglEngNm = ffCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param anCstmsDeclCntCd
	 */
	public void setAnCstmsDeclCntCd(String anCstmsDeclCntCd) {
		this.anCstmsDeclCntCd = anCstmsDeclCntCd;
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
	 * @param anCustSteCd
	 */
	public void setAnCustSteCd(String anCustSteCd) {
		this.anCustSteCd = anCustSteCd;
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
	 * @param cnMdmAddress
	 */
	public void setCnMdmAddress(String cnMdmAddress) {
		this.cnMdmAddress = cnMdmAddress;
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
	 * @param ffCustTp
	 */
	public void setFfCustTp(String ffCustTp) {
		this.ffCustTp = ffCustTp;
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
	 * @param nfMdmAddress
	 */
	public void setNfMdmAddress(String nfMdmAddress) {
		this.nfMdmAddress = nfMdmAddress;
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
	 * @param shEurCstmsStNm
	 */
	public void setShEurCstmsStNm(String shEurCstmsStNm) {
		this.shEurCstmsStNm = shEurCstmsStNm;
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
	 * @param exCustSeq
	 */
	public void setExCustSeq(String exCustSeq) {
		this.exCustSeq = exCustSeq;
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
	 * @param shEoriNo
	 */
	public void setShEoriNo(String shEoriNo) {
		this.shEoriNo = shEoriNo;
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
	 * @param shMdmAddress
	 */
	public void setShMdmAddress(String shMdmAddress) {
		this.shMdmAddress = shMdmAddress;
	}
	
	/**
	 * Column Info
	 * @param anMdmAddress
	 */
	public void setAnMdmAddress(String anMdmAddress) {
		this.anMdmAddress = anMdmAddress;
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
	 * @param nfEoriNo
	 */
	public void setNfEoriNo(String nfEoriNo) {
		this.nfEoriNo = nfEoriNo;
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
	 * @param brCustSeq
	 */
	public void setBrCustSeq(String brCustSeq) {
		this.brCustSeq = brCustSeq;
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
	 * @param cnCustTp
	 */
	public void setCnCustTp(String cnCustTp) {
		this.cnCustTp = cnCustTp;
	}
	
	/**
	 * Column Info
	 * @param anCustEml
	 */
	public void setAnCustEml(String anCustEml) {
		this.anCustEml = anCustEml;
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
	 * @param ffCustSeq
	 */
	public void setFfCustSeq(String ffCustSeq) {
		this.ffCustSeq = ffCustSeq;
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
	 * @param anCustTp
	 */
	public void setAnCustTp(String anCustTp) {
		this.anCustTp = anCustTp;
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
	 * @param ffCustNm
	 */
	public void setFfCustNm(String ffCustNm) {
		this.ffCustNm = ffCustNm;
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
	 * @param ffCustAddr
	 */
	public void setFfCustAddr(String ffCustAddr) {
		this.ffCustAddr = ffCustAddr;
	}
	
	/**
	 * Column Info
	 * @param nfEurCstmsStNm
	 */
	public void setNfEurCstmsStNm(String nfEurCstmsStNm) {
		this.nfEurCstmsStNm = nfEurCstmsStNm;
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
	 * @param nfCustEml
	 */
	public void setNfCustEml(String nfCustEml) {
		this.nfCustEml = nfCustEml;
	}
	
	/**
	 * Column Info
	 * @param anCustFaxNo
	 */
	public void setAnCustFaxNo(String anCustFaxNo) {
		this.anCustFaxNo = anCustFaxNo;
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
	 * @param anCustZipId
	 */
	public void setAnCustZipId(String anCustZipId) {
		this.anCustZipId = anCustZipId;
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
	 * @param cnEurCstmsStNm
	 */
	public void setCnEurCstmsStNm(String cnEurCstmsStNm) {
		this.cnEurCstmsStNm = cnEurCstmsStNm;
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
	 * @param nfCustTp
	 */
	public void setNfCustTp(String nfCustTp) {
		this.nfCustTp = nfCustTp;
	}
	
	/**
	 * Column Info
	 * @param ffMdmAddress
	 */
	public void setFfMdmAddress(String ffMdmAddress) {
		this.ffMdmAddress = ffMdmAddress;
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
	 * Column Info
	 * @param exCustCntCd
	 */
	public void setExCustCntCd(String exCustCntCd) {
		this.exCustCntCd = exCustCntCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

    public String getNmAndAddrOvflwFlg() {
		return nmAndAddrOvflwFlg;
	}

	public void setNmAndAddrOvflwFlg(String nmAndAddrOvflwFlg) {
		this.nmAndAddrOvflwFlg = nmAndAddrOvflwFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCnCustFaxNo(JSPUtil.getParameter(request, prefix + "cn_cust_fax_no", ""));
		setFfCustLglEngNm(JSPUtil.getParameter(request, prefix + "ff_cust_lgl_eng_nm", ""));
		setAnCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "an_cstms_decl_cnt_cd", ""));
		setBrCustCntCd(JSPUtil.getParameter(request, prefix + "br_cust_cnt_cd", ""));
		setNfCustSteCd(JSPUtil.getParameter(request, prefix + "nf_cust_ste_cd", ""));
		setFfCustEml(JSPUtil.getParameter(request, prefix + "ff_cust_eml", ""));
		setShCustCtyNm(JSPUtil.getParameter(request, prefix + "sh_cust_cty_nm", ""));
		setExCustNm(JSPUtil.getParameter(request, prefix + "ex_cust_nm", ""));
		setAnCustSteCd(JSPUtil.getParameter(request, prefix + "an_cust_ste_cd", ""));
		setCnCustAddr(JSPUtil.getParameter(request, prefix + "cn_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnCustEml(JSPUtil.getParameter(request, prefix + "cn_cust_eml", ""));
		setCnMdmAddress(JSPUtil.getParameter(request, prefix + "cn_mdm_address", ""));
		setShCustSeq(JSPUtil.getParameter(request, prefix + "sh_cust_seq", ""));
		setFfCustTp(JSPUtil.getParameter(request, prefix + "ff_cust_tp", ""));
		setFfCustZipId(JSPUtil.getParameter(request, prefix + "ff_cust_zip_id", ""));
		setNfMdmAddress(JSPUtil.getParameter(request, prefix + "nf_mdm_address", ""));
		setExAddrPrnFlg(JSPUtil.getParameter(request, prefix + "ex_addr_prn_flg", ""));
		setFfCustSteCd(JSPUtil.getParameter(request, prefix + "ff_cust_ste_cd", ""));
		setShEurCstmsStNm(JSPUtil.getParameter(request, prefix + "sh_eur_cstms_st_nm", ""));
		setNfCustCntCd(JSPUtil.getParameter(request, prefix + "nf_cust_cnt_cd", ""));
		setExCustSeq(JSPUtil.getParameter(request, prefix + "ex_cust_seq", ""));
		setBrCustNm(JSPUtil.getParameter(request, prefix + "br_cust_nm", ""));
		setAnCustNm(JSPUtil.getParameter(request, prefix + "an_cust_nm", ""));
		setShEoriNo(JSPUtil.getParameter(request, prefix + "sh_eori_no", ""));
		setNfCustSeq(JSPUtil.getParameter(request, prefix + "nf_cust_seq", ""));
		setAnCustSeq(JSPUtil.getParameter(request, prefix + "an_cust_seq", ""));
		setCnCustLglEngNm(JSPUtil.getParameter(request, prefix + "cn_cust_lgl_eng_nm", ""));
		setNfCustZipId(JSPUtil.getParameter(request, prefix + "nf_cust_zip_id", ""));
		setShMdmAddress(JSPUtil.getParameter(request, prefix + "sh_mdm_address", ""));
		setAnMdmAddress(JSPUtil.getParameter(request, prefix + "an_mdm_address", ""));
		setFfAddrPrnFlg(JSPUtil.getParameter(request, prefix + "ff_addr_prn_flg", ""));
		setNfEoriNo(JSPUtil.getParameter(request, prefix + "nf_eori_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setNfCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "nf_cstms_decl_cnt_cd", ""));
		setFfCustFaxNo(JSPUtil.getParameter(request, prefix + "ff_cust_fax_no", ""));
		setShCustZipId(JSPUtil.getParameter(request, prefix + "sh_cust_zip_id", ""));
		setBrCustSeq(JSPUtil.getParameter(request, prefix + "br_cust_seq", ""));
		setNfAddrPrnFlg(JSPUtil.getParameter(request, prefix + "nf_addr_prn_flg", ""));
		setBrCustAddr(JSPUtil.getParameter(request, prefix + "br_cust_addr", ""));
		setFfCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "ff_cstms_decl_cnt_cd", ""));
		setShCustLglEngNm(JSPUtil.getParameter(request, prefix + "sh_cust_lgl_eng_nm", ""));
		setShAddrPrnFlg(JSPUtil.getParameter(request, prefix + "sh_addr_prn_flg", ""));
		setAnAddrPrnFlg(JSPUtil.getParameter(request, prefix + "an_addr_prn_flg", ""));
		setShCustCntCd(JSPUtil.getParameter(request, prefix + "sh_cust_cnt_cd", ""));
		setNfCustLglEngNm(JSPUtil.getParameter(request, prefix + "nf_cust_lgl_eng_nm", ""));
		setCnCustTp(JSPUtil.getParameter(request, prefix + "cn_cust_tp", ""));
		setAnCustEml(JSPUtil.getParameter(request, prefix + "an_cust_eml", ""));
		setCnEoriNo(JSPUtil.getParameter(request, prefix + "cn_eori_no", ""));
		setFfCustCtyNm(JSPUtil.getParameter(request, prefix + "ff_cust_cty_nm", ""));
		setCnCustZipId(JSPUtil.getParameter(request, prefix + "cn_cust_zip_id", ""));
		setFfCustSeq(JSPUtil.getParameter(request, prefix + "ff_cust_seq", ""));
		setCnCustCtyNm(JSPUtil.getParameter(request, prefix + "cn_cust_cty_nm", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, prefix + "cn_cust_cnt_cd", ""));
		setAnCustTp(JSPUtil.getParameter(request, prefix + "an_cust_tp", ""));
		setAnCustLglEngNm(JSPUtil.getParameter(request, prefix + "an_cust_lgl_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFfCustNm(JSPUtil.getParameter(request, prefix + "ff_cust_nm", ""));
		setCnCustSeq(JSPUtil.getParameter(request, prefix + "cn_cust_seq", ""));
		setFfCustAddr(JSPUtil.getParameter(request, prefix + "ff_cust_addr", ""));
		setNfEurCstmsStNm(JSPUtil.getParameter(request, prefix + "nf_eur_cstms_st_nm", ""));
		setAnCustCntCd(JSPUtil.getParameter(request, prefix + "an_cust_cnt_cd", ""));
		setShCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "sh_cstms_decl_cnt_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setNfCustCtyNm(JSPUtil.getParameter(request, prefix + "nf_cust_cty_nm", ""));
		setNfCustAddr(JSPUtil.getParameter(request, prefix + "nf_cust_addr", ""));
		setNfCustEml(JSPUtil.getParameter(request, prefix + "nf_cust_eml", ""));
		setAnCustFaxNo(JSPUtil.getParameter(request, prefix + "an_cust_fax_no", ""));
		setNfCustFaxNo(JSPUtil.getParameter(request, prefix + "nf_cust_fax_no", ""));
		setShCustAddr(JSPUtil.getParameter(request, prefix + "sh_cust_addr", ""));
		setCnCustSteCd(JSPUtil.getParameter(request, prefix + "cn_cust_ste_cd", ""));
		setCnCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cn_cstms_decl_cnt_cd", ""));
		setAnCustZipId(JSPUtil.getParameter(request, prefix + "an_cust_zip_id", ""));
		setAnCustAddr(JSPUtil.getParameter(request, prefix + "an_cust_addr", ""));
		setCnEurCstmsStNm(JSPUtil.getParameter(request, prefix + "cn_eur_cstms_st_nm", ""));
		setCnAddrPrnFlg(JSPUtil.getParameter(request, prefix + "cn_addr_prn_flg", ""));
		setFfCustCntCd(JSPUtil.getParameter(request, prefix + "ff_cust_cnt_cd", ""));
		setNfCustTp(JSPUtil.getParameter(request, prefix + "nf_cust_tp", ""));
		setFfMdmAddress(JSPUtil.getParameter(request, prefix + "ff_mdm_address", ""));
		setShCustSteCd(JSPUtil.getParameter(request, prefix + "sh_cust_ste_cd", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setShCustTp(JSPUtil.getParameter(request, prefix + "sh_cust_tp", ""));
		setExCustCntCd(JSPUtil.getParameter(request, prefix + "ex_cust_cnt_cd", ""));
        setNmAndAddrOvflwFlg(JSPUtil.getParameter(request, prefix + "nm_and_addr_ovflw_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlDocCustVO[]
	 */
	public BlDocCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlDocCustVO[]
	 */
	public BlDocCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlDocCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "cn_cust_fax_no", length));
			String[] ffCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_lgl_eng_nm", length));
			String[] anCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "an_cstms_decl_cnt_cd", length));
			String[] brCustCntCd = (JSPUtil.getParameter(request, prefix	+ "br_cust_cnt_cd", length));
			String[] nfCustSteCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_ste_cd", length));
			String[] ffCustEml = (JSPUtil.getParameter(request, prefix	+ "ff_cust_eml", length));
			String[] shCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cty_nm", length));
			String[] exCustNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_nm", length));
			String[] anCustSteCd = (JSPUtil.getParameter(request, prefix	+ "an_cust_ste_cd", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnCustEml = (JSPUtil.getParameter(request, prefix	+ "cn_cust_eml", length));
			String[] cnMdmAddress = (JSPUtil.getParameter(request, prefix	+ "cn_mdm_address", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] ffCustTp = (JSPUtil.getParameter(request, prefix	+ "ff_cust_tp", length));
			String[] ffCustZipId = (JSPUtil.getParameter(request, prefix	+ "ff_cust_zip_id", length));
			String[] nfMdmAddress = (JSPUtil.getParameter(request, prefix	+ "nf_mdm_address", length));
			String[] exAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "ex_addr_prn_flg", length));
			String[] ffCustSteCd = (JSPUtil.getParameter(request, prefix	+ "ff_cust_ste_cd", length));
			String[] shEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "sh_eur_cstms_st_nm", length));
			String[] nfCustCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt_cd", length));
			String[] exCustSeq = (JSPUtil.getParameter(request, prefix	+ "ex_cust_seq", length));
			String[] brCustNm = (JSPUtil.getParameter(request, prefix	+ "br_cust_nm", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] shEoriNo = (JSPUtil.getParameter(request, prefix	+ "sh_eori_no", length));
			String[] nfCustSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cust_seq", length));
			String[] anCustSeq = (JSPUtil.getParameter(request, prefix	+ "an_cust_seq", length));
			String[] cnCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_lgl_eng_nm", length));
			String[] nfCustZipId = (JSPUtil.getParameter(request, prefix	+ "nf_cust_zip_id", length));
			String[] shMdmAddress = (JSPUtil.getParameter(request, prefix	+ "sh_mdm_address", length));
			String[] anMdmAddress = (JSPUtil.getParameter(request, prefix	+ "an_mdm_address", length));
			String[] ffAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "ff_addr_prn_flg", length));
			String[] nfEoriNo = (JSPUtil.getParameter(request, prefix	+ "nf_eori_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] nfCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cstms_decl_cnt_cd", length));
			String[] ffCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "ff_cust_fax_no", length));
			String[] shCustZipId = (JSPUtil.getParameter(request, prefix	+ "sh_cust_zip_id", length));
			String[] brCustSeq = (JSPUtil.getParameter(request, prefix	+ "br_cust_seq", length));
			String[] nfAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "nf_addr_prn_flg", length));
			String[] brCustAddr = (JSPUtil.getParameter(request, prefix	+ "br_cust_addr", length));
			String[] ffCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cstms_decl_cnt_cd", length));
			String[] shCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_lgl_eng_nm", length));
			String[] shAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "sh_addr_prn_flg", length));
			String[] anAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "an_addr_prn_flg", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] nfCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_lgl_eng_nm", length));
			String[] cnCustTp = (JSPUtil.getParameter(request, prefix	+ "cn_cust_tp", length));
			String[] anCustEml = (JSPUtil.getParameter(request, prefix	+ "an_cust_eml", length));
			String[] cnEoriNo = (JSPUtil.getParameter(request, prefix	+ "cn_eori_no", length));
			String[] ffCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_cty_nm", length));
			String[] cnCustZipId = (JSPUtil.getParameter(request, prefix	+ "cn_cust_zip_id", length));
			String[] ffCustSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq", length));
			String[] cnCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cty_nm", length));
			String[] cnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cnt_cd", length));
			String[] anCustTp = (JSPUtil.getParameter(request, prefix	+ "an_cust_tp", length));
			String[] anCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_lgl_eng_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffCustNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_nm", length));
			String[] cnCustSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cust_seq", length));
			String[] ffCustAddr = (JSPUtil.getParameter(request, prefix	+ "ff_cust_addr", length));
			String[] nfEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "nf_eur_cstms_st_nm", length));
			String[] anCustCntCd = (JSPUtil.getParameter(request, prefix	+ "an_cust_cnt_cd", length));
			String[] shCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cstms_decl_cnt_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] nfCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cty_nm", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] nfCustEml = (JSPUtil.getParameter(request, prefix	+ "nf_cust_eml", length));
			String[] anCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "an_cust_fax_no", length));
			String[] nfCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "nf_cust_fax_no", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] cnCustSteCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_ste_cd", length));
			String[] cnCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cstms_decl_cnt_cd", length));
			String[] anCustZipId = (JSPUtil.getParameter(request, prefix	+ "an_cust_zip_id", length));
			String[] anCustAddr = (JSPUtil.getParameter(request, prefix	+ "an_cust_addr", length));
			String[] cnEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "cn_eur_cstms_st_nm", length));
			String[] cnAddrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cn_addr_prn_flg", length));
			String[] ffCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cust_cnt_cd", length));
			String[] nfCustTp = (JSPUtil.getParameter(request, prefix	+ "nf_cust_tp", length));
			String[] ffMdmAddress = (JSPUtil.getParameter(request, prefix	+ "ff_mdm_address", length));
			String[] shCustSteCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_ste_cd", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] shCustTp = (JSPUtil.getParameter(request, prefix	+ "sh_cust_tp", length));
			String[] exCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ex_cust_cnt_cd", length));
            String[] nmAndAddrOvflwFlg = (JSPUtil.getParameter(request, prefix + "nm_and_addr_ovflw_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlDocCustVO();
				if (cnCustFaxNo[i] != null)
					model.setCnCustFaxNo(cnCustFaxNo[i]);
				if (ffCustLglEngNm[i] != null)
					model.setFfCustLglEngNm(ffCustLglEngNm[i]);
				if (anCstmsDeclCntCd[i] != null)
					model.setAnCstmsDeclCntCd(anCstmsDeclCntCd[i]);
				if (brCustCntCd[i] != null)
					model.setBrCustCntCd(brCustCntCd[i]);
				if (nfCustSteCd[i] != null)
					model.setNfCustSteCd(nfCustSteCd[i]);
				if (ffCustEml[i] != null)
					model.setFfCustEml(ffCustEml[i]);
				if (shCustCtyNm[i] != null)
					model.setShCustCtyNm(shCustCtyNm[i]);
				if (exCustNm[i] != null)
					model.setExCustNm(exCustNm[i]);
				if (anCustSteCd[i] != null)
					model.setAnCustSteCd(anCustSteCd[i]);
				if (cnCustAddr[i] != null)
					model.setCnCustAddr(cnCustAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnCustEml[i] != null)
					model.setCnCustEml(cnCustEml[i]);
				if (cnMdmAddress[i] != null)
					model.setCnMdmAddress(cnMdmAddress[i]);
				if (shCustSeq[i] != null)
					model.setShCustSeq(shCustSeq[i]);
				if (ffCustTp[i] != null)
					model.setFfCustTp(ffCustTp[i]);
				if (ffCustZipId[i] != null)
					model.setFfCustZipId(ffCustZipId[i]);
				if (nfMdmAddress[i] != null)
					model.setNfMdmAddress(nfMdmAddress[i]);
				if (exAddrPrnFlg[i] != null)
					model.setExAddrPrnFlg(exAddrPrnFlg[i]);
				if (ffCustSteCd[i] != null)
					model.setFfCustSteCd(ffCustSteCd[i]);
				if (shEurCstmsStNm[i] != null)
					model.setShEurCstmsStNm(shEurCstmsStNm[i]);
				if (nfCustCntCd[i] != null)
					model.setNfCustCntCd(nfCustCntCd[i]);
				if (exCustSeq[i] != null)
					model.setExCustSeq(exCustSeq[i]);
				if (brCustNm[i] != null)
					model.setBrCustNm(brCustNm[i]);
				if (anCustNm[i] != null)
					model.setAnCustNm(anCustNm[i]);
				if (shEoriNo[i] != null)
					model.setShEoriNo(shEoriNo[i]);
				if (nfCustSeq[i] != null)
					model.setNfCustSeq(nfCustSeq[i]);
				if (anCustSeq[i] != null)
					model.setAnCustSeq(anCustSeq[i]);
				if (cnCustLglEngNm[i] != null)
					model.setCnCustLglEngNm(cnCustLglEngNm[i]);
				if (nfCustZipId[i] != null)
					model.setNfCustZipId(nfCustZipId[i]);
				if (shMdmAddress[i] != null)
					model.setShMdmAddress(shMdmAddress[i]);
				if (anMdmAddress[i] != null)
					model.setAnMdmAddress(anMdmAddress[i]);
				if (ffAddrPrnFlg[i] != null)
					model.setFfAddrPrnFlg(ffAddrPrnFlg[i]);
				if (nfEoriNo[i] != null)
					model.setNfEoriNo(nfEoriNo[i]);
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
				if (brCustSeq[i] != null)
					model.setBrCustSeq(brCustSeq[i]);
				if (nfAddrPrnFlg[i] != null)
					model.setNfAddrPrnFlg(nfAddrPrnFlg[i]);
				if (brCustAddr[i] != null)
					model.setBrCustAddr(brCustAddr[i]);
				if (ffCstmsDeclCntCd[i] != null)
					model.setFfCstmsDeclCntCd(ffCstmsDeclCntCd[i]);
				if (shCustLglEngNm[i] != null)
					model.setShCustLglEngNm(shCustLglEngNm[i]);
				if (shAddrPrnFlg[i] != null)
					model.setShAddrPrnFlg(shAddrPrnFlg[i]);
				if (anAddrPrnFlg[i] != null)
					model.setAnAddrPrnFlg(anAddrPrnFlg[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (nfCustLglEngNm[i] != null)
					model.setNfCustLglEngNm(nfCustLglEngNm[i]);
				if (cnCustTp[i] != null)
					model.setCnCustTp(cnCustTp[i]);
				if (anCustEml[i] != null)
					model.setAnCustEml(anCustEml[i]);
				if (cnEoriNo[i] != null)
					model.setCnEoriNo(cnEoriNo[i]);
				if (ffCustCtyNm[i] != null)
					model.setFfCustCtyNm(ffCustCtyNm[i]);
				if (cnCustZipId[i] != null)
					model.setCnCustZipId(cnCustZipId[i]);
				if (ffCustSeq[i] != null)
					model.setFfCustSeq(ffCustSeq[i]);
				if (cnCustCtyNm[i] != null)
					model.setCnCustCtyNm(cnCustCtyNm[i]);
				if (cnCustCntCd[i] != null)
					model.setCnCustCntCd(cnCustCntCd[i]);
				if (anCustTp[i] != null)
					model.setAnCustTp(anCustTp[i]);
				if (anCustLglEngNm[i] != null)
					model.setAnCustLglEngNm(anCustLglEngNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffCustNm[i] != null)
					model.setFfCustNm(ffCustNm[i]);
				if (cnCustSeq[i] != null)
					model.setCnCustSeq(cnCustSeq[i]);
				if (ffCustAddr[i] != null)
					model.setFfCustAddr(ffCustAddr[i]);
				if (nfEurCstmsStNm[i] != null)
					model.setNfEurCstmsStNm(nfEurCstmsStNm[i]);
				if (anCustCntCd[i] != null)
					model.setAnCustCntCd(anCustCntCd[i]);
				if (shCstmsDeclCntCd[i] != null)
					model.setShCstmsDeclCntCd(shCstmsDeclCntCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (nfCustCtyNm[i] != null)
					model.setNfCustCtyNm(nfCustCtyNm[i]);
				if (nfCustAddr[i] != null)
					model.setNfCustAddr(nfCustAddr[i]);
				if (nfCustEml[i] != null)
					model.setNfCustEml(nfCustEml[i]);
				if (anCustFaxNo[i] != null)
					model.setAnCustFaxNo(anCustFaxNo[i]);
				if (nfCustFaxNo[i] != null)
					model.setNfCustFaxNo(nfCustFaxNo[i]);
				if (shCustAddr[i] != null)
					model.setShCustAddr(shCustAddr[i]);
				if (cnCustSteCd[i] != null)
					model.setCnCustSteCd(cnCustSteCd[i]);
				if (cnCstmsDeclCntCd[i] != null)
					model.setCnCstmsDeclCntCd(cnCstmsDeclCntCd[i]);
				if (anCustZipId[i] != null)
					model.setAnCustZipId(anCustZipId[i]);
				if (anCustAddr[i] != null)
					model.setAnCustAddr(anCustAddr[i]);
				if (cnEurCstmsStNm[i] != null)
					model.setCnEurCstmsStNm(cnEurCstmsStNm[i]);
				if (cnAddrPrnFlg[i] != null)
					model.setCnAddrPrnFlg(cnAddrPrnFlg[i]);
				if (ffCustCntCd[i] != null)
					model.setFfCustCntCd(ffCustCntCd[i]);
				if (nfCustTp[i] != null)
					model.setNfCustTp(nfCustTp[i]);
				if (ffMdmAddress[i] != null)
					model.setFfMdmAddress(ffMdmAddress[i]);
				if (shCustSteCd[i] != null)
					model.setShCustSteCd(shCustSteCd[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (shCustTp[i] != null)
					model.setShCustTp(shCustTp[i]);
				if (exCustCntCd[i] != null)
					model.setExCustCntCd(exCustCntCd[i]);
                if (nmAndAddrOvflwFlg[i] != null) 
		    		model.setNmAndAddrOvflwFlg(nmAndAddrOvflwFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlDocCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlDocCustVO[]
	 */
	public BlDocCustVO[] getBlDocCustVOs(){
		BlDocCustVO[] vos = (BlDocCustVO[])models.toArray(new BlDocCustVO[models.size()]);
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
		this.ffCustLglEngNm = this.ffCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCstmsDeclCntCd = this.anCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustCntCd = this.brCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSteCd = this.nfCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustEml = this.ffCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCtyNm = this.shCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustNm = this.exCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustSteCd = this.anCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustEml = this.cnCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnMdmAddress = this.cnMdmAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustTp = this.ffCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustZipId = this.ffCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfMdmAddress = this.nfMdmAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exAddrPrnFlg = this.exAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSteCd = this.ffCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEurCstmsStNm = this.shEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCntCd = this.nfCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustSeq = this.exCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustNm = this.brCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEoriNo = this.shEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSeq = this.nfCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustSeq = this.anCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustLglEngNm = this.cnCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustZipId = this.nfCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shMdmAddress = this.shMdmAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anMdmAddress = this.anMdmAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffAddrPrnFlg = this.ffAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEoriNo = this.nfEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCstmsDeclCntCd = this.nfCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustFaxNo = this.ffCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustZipId = this.shCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustSeq = this.brCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfAddrPrnFlg = this.nfAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brCustAddr = this.brCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCstmsDeclCntCd = this.ffCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustLglEngNm = this.shCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shAddrPrnFlg = this.shAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anAddrPrnFlg = this.anAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustLglEngNm = this.nfCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustTp = this.cnCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustEml = this.anCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEoriNo = this.cnEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustCtyNm = this.ffCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustZipId = this.cnCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeq = this.ffCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCtyNm = this.cnCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCntCd = this.cnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustTp = this.anCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustLglEngNm = this.anCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustNm = this.ffCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSeq = this.cnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustAddr = this.ffCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEurCstmsStNm = this.nfEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustCntCd = this.anCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCstmsDeclCntCd = this.shCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCtyNm = this.nfCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustEml = this.nfCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustFaxNo = this.anCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustFaxNo = this.nfCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSteCd = this.cnCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCstmsDeclCntCd = this.cnCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustZipId = this.anCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustAddr = this.anCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEurCstmsStNm = this.cnEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnAddrPrnFlg = this.cnAddrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustCntCd = this.ffCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustTp = this.nfCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffMdmAddress = this.ffMdmAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSteCd = this.shCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustTp = this.shCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustCntCd = this.exCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nmAndAddrOvflwFlg = this.nmAndAddrOvflwFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
