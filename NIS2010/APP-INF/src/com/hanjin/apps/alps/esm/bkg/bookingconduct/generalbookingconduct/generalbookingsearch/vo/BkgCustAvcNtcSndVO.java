/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCustAvcNtcSndVO.java
*@FileTitle : BkgCustAvcNtcSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23  
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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

public class BkgCustAvcNtcSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustAvcNtcSndVO> models = new ArrayList<BkgCustAvcNtcSndVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String shFaxEvntFlg = null;
	/* Column Info */
	private String shEmlNtcSndRsltCd = null;
	/* Column Info */
	private String emlChk = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cnCustAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String shFaxNtcSndRsltCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String nfFaxNtcSndRsltCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String anCustNm = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String cnEml = null;
	/* Column Info */
	private String cnFaxNtcSndRsltCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String faxChk = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cnEmlNtcSndRsltNm = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String nfEmailEvntFlg = null;
	/* Column Info */
	private String nfFaxEvntFlg = null;
	/* Column Info */
	private String sentFlg = null;
	/* Column Info */
	private String shFaxNo = null;
	/* Column Info */
	private String fnCustNm = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Column Info */
	private String cnEmlNtcSndRsltCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileKey = null;
	/* Column Info */
	private String shEmlNtcSndRsltNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String cnFaxEvntFlg = null;
	/* Column Info */
	private String nfEml = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String nfCustAddr = null;
	/* Column Info */
	private String nfEmlNtcSndRsltCd = null;
	/* Column Info */
	private String cnEmailEvntFlg = null;
	/* Column Info */
	private String srcDatTpCd = null;
	/* Column Info */
	private String shFaxNtcSndRsltNm = null;
	/* Column Info */
	private String nfFaxNtcSndRsltNm = null;
	/* Column Info */
	private String shCustAddr = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String nfFaxNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String nfEmlNtcSndRsltNm = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String shEmailEvntFlg = null;
	/* Column Info */
	private String shEml = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnFaxNo = null;
	/* Column Info */
	private String cnFaxNtcSndRsltNm = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String selSeq = null;
	/* Column Info */
	private String ctrtEmlNm = null;
	/* Column Info */
	private String ctrtFaxNm = null;
	/* Column Info */
	private String ctrtCustEml = null;
	/* Column Info */
	private String ctrtFaxNo = null;
	/* Column Info */
	private String keyAcctFlg = null;
	/* Column Info */
	private String gloAcctFlg = null;
	/* Column Info */
	private String rgnAcctFlg = null;
	/* Column Info */
	private String lclAcctFlg = null;
	
	/* Column Info */
	private String ctrtFaxEvntFlg = null;
	/* Column Info */
	private String ctrtFaxNtcSndRsltCd = null;
	/* Column Info */
	private String ctrtFaxNtcSndRsltNm = null;
	/* Column Info */
	private String ctrtEmailEvntFlg = null;
	/* Column Info */
	private String ctrtEmlNtcSndRsltCd = null;
	/* Column Info */
	private String ctrtEmlNtcSndRsltNm = null;
	
	/* Column Info */
	private String acctClssFax = null;
	/* Column Info */
	private String acctClssEml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCustAvcNtcSndVO() {}

	public BkgCustAvcNtcSndVO(String ibflag, String pagerows, String blNo, String bkgNo, String cntrNo, String cntrNo1, String teu, String feu, String cmdtCd, String cstmsDesc, String bkgOfcCd, String docUsrId, String ctrtOfcCd, String ctrtSrepCd, String obSlsOfcCd, String obSrepCd, String scNo, String rfaNo, String taaNo, String shCustAddr, String cnCustAddr, String nfCustAddr, String anCustNm, String fnCustNm, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String porCd, String polCd, String podCd, String delCd, String shCustNm, String cnCustNm, String nfCustNm, String shFaxNo, String cnFaxNo, String nfFaxNo, String shFaxNtcSndRsltCd, String cnFaxNtcSndRsltCd, String nfFaxNtcSndRsltCd, String shFaxNtcSndRsltNm, String cnFaxNtcSndRsltNm, String nfFaxNtcSndRsltNm, String shEml, String cnEml, String nfEml, String shEmlNtcSndRsltCd, String cnEmlNtcSndRsltCd, String nfEmlNtcSndRsltCd, String shEmlNtcSndRsltNm, String cnEmlNtcSndRsltNm, String nfEmlNtcSndRsltNm, String sentFlg, String ofcCd, String faxChk, String emlChk, String shFaxEvntFlg, String shEmailEvntFlg, String fileKey, String cnFaxEvntFlg, String nfFaxEvntFlg, String cnEmailEvntFlg, String nfEmailEvntFlg, String srcDatTpCd, String selSeq, String ctrtEmlNm ,String ctrtFaxNm, String ctrtCustEml , String ctrtFaxNo ,String keyAcctFlg ,String gloAcctFlg ,String rgnAcctFlg ,String lclAcctFlg, String ctrtFaxEvntFlg ,String ctrtFaxNtcSndRsltCd ,String ctrtFaxNtcSndRsltNm ,String ctrtEmailEvntFlg,String ctrtEmlNtcSndRsltCd ,String ctrtEmlNtcSndRsltNm, String acctClssFax, String acctClssEml ) {
		this.vslCd = vslCd;
		this.shFaxEvntFlg = shFaxEvntFlg;
		this.shEmlNtcSndRsltCd = shEmlNtcSndRsltCd;
		this.emlChk = emlChk;
		this.blNo = blNo;
		this.cnCustAddr = cnCustAddr;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.polCd = polCd;
		this.scNo = scNo;
		this.ctrtOfcCd = ctrtOfcCd;
		this.shFaxNtcSndRsltCd = shFaxNtcSndRsltCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.nfFaxNtcSndRsltCd = nfFaxNtcSndRsltCd;
		this.bkgOfcCd = bkgOfcCd;
		this.anCustNm = anCustNm;
		this.feu = feu;
		this.cnEml = cnEml;
		this.cnFaxNtcSndRsltCd = cnFaxNtcSndRsltCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.faxChk = faxChk;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.shCustNm = shCustNm;
		this.ctrtSrepCd = ctrtSrepCd;
		this.teu = teu;
		this.porCd = porCd;
		this.cnEmlNtcSndRsltNm = cnEmlNtcSndRsltNm;
		this.docUsrId = docUsrId;
		this.nfEmailEvntFlg = nfEmailEvntFlg;
		this.nfFaxEvntFlg = nfFaxEvntFlg;
		this.sentFlg = sentFlg;
		this.shFaxNo = shFaxNo;
		this.fnCustNm = fnCustNm;
		this.cntrNo1 = cntrNo1;
		this.cnEmlNtcSndRsltCd = cnEmlNtcSndRsltCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.fileKey = fileKey;
		this.shEmlNtcSndRsltNm = shEmlNtcSndRsltNm;
		this.cmdtCd = cmdtCd;
		this.cstmsDesc = cstmsDesc;
		this.cnFaxEvntFlg = cnFaxEvntFlg;
		this.nfEml = nfEml;
		this.nfCustNm = nfCustNm;
		this.nfCustAddr = nfCustAddr;
		this.nfEmlNtcSndRsltCd = nfEmlNtcSndRsltCd;
		this.cnEmailEvntFlg = cnEmailEvntFlg;
		this.srcDatTpCd = srcDatTpCd;
		this.shFaxNtcSndRsltNm = shFaxNtcSndRsltNm;
		this.nfFaxNtcSndRsltNm = nfFaxNtcSndRsltNm;
		this.shCustAddr = shCustAddr;
		this.skdDirCd = skdDirCd;
		this.nfFaxNo = nfFaxNo;
		this.ofcCd = ofcCd;
		this.nfEmlNtcSndRsltNm = nfEmlNtcSndRsltNm;
		this.taaNo = taaNo;
		this.shEmailEvntFlg = shEmailEvntFlg;
		this.shEml = shEml;
		this.cntrNo = cntrNo;
		this.cnFaxNo = cnFaxNo;
		this.cnFaxNtcSndRsltNm = cnFaxNtcSndRsltNm;
		this.cnCustNm = cnCustNm;
		this.selSeq = selSeq;
		
		this.ctrtEmlNm = ctrtEmlNm;
		this.ctrtFaxNm = ctrtFaxNm;
		this.ctrtCustEml = ctrtCustEml;
		this.ctrtFaxNo = ctrtFaxNo;
		this.keyAcctFlg = keyAcctFlg;
		this.gloAcctFlg = gloAcctFlg;
		this.rgnAcctFlg = rgnAcctFlg;
		this.lclAcctFlg = lclAcctFlg;
		
		this.ctrtFaxEvntFlg = ctrtFaxEvntFlg;
		this.ctrtFaxNtcSndRsltCd = ctrtFaxNtcSndRsltCd;
		this.ctrtFaxNtcSndRsltNm = ctrtFaxNtcSndRsltNm;
		this.ctrtEmailEvntFlg = ctrtEmailEvntFlg;
		this.ctrtEmlNtcSndRsltCd = ctrtEmlNtcSndRsltCd;
		this.ctrtEmlNtcSndRsltNm = ctrtEmlNtcSndRsltNm;
		
		this.acctClssFax = acctClssFax;
		this.acctClssEml = acctClssEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sh_fax_evnt_flg", getShFaxEvntFlg());
		this.hashColumns.put("sh_eml_ntc_snd_rslt_cd", getShEmlNtcSndRsltCd());
		this.hashColumns.put("eml_chk", getEmlChk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sh_fax_ntc_snd_rslt_cd", getShFaxNtcSndRsltCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("nf_fax_ntc_snd_rslt_cd", getNfFaxNtcSndRsltCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("cn_eml", getCnEml());
		this.hashColumns.put("cn_fax_ntc_snd_rslt_cd", getCnFaxNtcSndRsltCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("fax_chk", getFaxChk());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cn_eml_ntc_snd_rslt_nm", getCnEmlNtcSndRsltNm());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("nf_email_evnt_flg", getNfEmailEvntFlg());
		this.hashColumns.put("nf_fax_evnt_flg", getNfFaxEvntFlg());
		this.hashColumns.put("sent_flg", getSentFlg());
		this.hashColumns.put("sh_fax_no", getShFaxNo());
		this.hashColumns.put("fn_cust_nm", getFnCustNm());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("cn_eml_ntc_snd_rslt_cd", getCnEmlNtcSndRsltCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_key", getFileKey());
		this.hashColumns.put("sh_eml_ntc_snd_rslt_nm", getShEmlNtcSndRsltNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("cn_fax_evnt_flg", getCnFaxEvntFlg());
		this.hashColumns.put("nf_eml", getNfEml());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("nf_eml_ntc_snd_rslt_cd", getNfEmlNtcSndRsltCd());
		this.hashColumns.put("cn_email_evnt_flg", getCnEmailEvntFlg());
		this.hashColumns.put("src_dat_tp_cd", getSrcDatTpCd());
		this.hashColumns.put("sh_fax_ntc_snd_rslt_nm", getShFaxNtcSndRsltNm());
		this.hashColumns.put("nf_fax_ntc_snd_rslt_nm", getNfFaxNtcSndRsltNm());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("nf_fax_no", getNfFaxNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("nf_eml_ntc_snd_rslt_nm", getNfEmlNtcSndRsltNm());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("sh_email_evnt_flg", getShEmailEvntFlg());
		this.hashColumns.put("sh_eml", getShEml());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cn_fax_no", getCnFaxNo());
		this.hashColumns.put("cn_fax_ntc_snd_rslt_nm", getCnFaxNtcSndRsltNm());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("sel_seq", getSelSeq());
		
		this.hashColumns.put("ctrt_eml_nm", getCtrtEmlNm());
		this.hashColumns.put("ctrt_fax_nm", getCtrtFaxNm());
		this.hashColumns.put("ctrt_cust_eml", getCtrtCustEml());
		this.hashColumns.put("ctrt_fax_no", getCtrtFaxNo());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
		this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
		this.hashColumns.put("lcl_acct_flg", getLclAcctFlg());
		
		this.hashColumns.put("ctrt_fax_evnt_flg", getCtrtFaxEvntFlg());
		this.hashColumns.put("ctrt_fax_ntc_snd_rslt_cd", getCtrtFaxNtcSndRsltCd());
		this.hashColumns.put("ctrt_fax_ntc_snd_rslt_nm", getCtrtFaxNtcSndRsltNm());
		this.hashColumns.put("ctrt_email_evnt_flg", getCtrtEmailEvntFlg());
		this.hashColumns.put("ctrt_eml_ntc_snd_rslt_cd", getCtrtEmlNtcSndRsltCd());
		this.hashColumns.put("ctrt_eml_ntc_snd_rslt_nm", getCtrtEmlNtcSndRsltNm());
		
		this.hashColumns.put("acct_clss_fax", getAcctClssFax());
		this.hashColumns.put("acct_clss_eml", getAcctClssEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sh_fax_evnt_flg", "shFaxEvntFlg");
		this.hashFields.put("sh_eml_ntc_snd_rslt_cd", "shEmlNtcSndRsltCd");
		this.hashFields.put("eml_chk", "emlChk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sh_fax_ntc_snd_rslt_cd", "shFaxNtcSndRsltCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("nf_fax_ntc_snd_rslt_cd", "nfFaxNtcSndRsltCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("cn_eml", "cnEml");
		this.hashFields.put("cn_fax_ntc_snd_rslt_cd", "cnFaxNtcSndRsltCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("fax_chk", "faxChk");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cn_eml_ntc_snd_rslt_nm", "cnEmlNtcSndRsltNm");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("nf_email_evnt_flg", "nfEmailEvntFlg");
		this.hashFields.put("nf_fax_evnt_flg", "nfFaxEvntFlg");
		this.hashFields.put("sent_flg", "sentFlg");
		this.hashFields.put("sh_fax_no", "shFaxNo");
		this.hashFields.put("fn_cust_nm", "fnCustNm");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("cn_eml_ntc_snd_rslt_cd", "cnEmlNtcSndRsltCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_key", "fileKey");
		this.hashFields.put("sh_eml_ntc_snd_rslt_nm", "shEmlNtcSndRsltNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("cn_fax_evnt_flg", "cnFaxEvntFlg");
		this.hashFields.put("nf_eml", "nfEml");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("nf_eml_ntc_snd_rslt_cd", "nfEmlNtcSndRsltCd");
		this.hashFields.put("cn_email_evnt_flg", "cnEmailEvntFlg");
		this.hashFields.put("src_dat_tp_cd", "srcDatTpCd");
		this.hashFields.put("sh_fax_ntc_snd_rslt_nm", "shFaxNtcSndRsltNm");
		this.hashFields.put("nf_fax_ntc_snd_rslt_nm", "nfFaxNtcSndRsltNm");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("nf_fax_no", "nfFaxNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("nf_eml_ntc_snd_rslt_nm", "nfEmlNtcSndRsltNm");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("sh_email_evnt_flg", "shEmailEvntFlg");
		this.hashFields.put("sh_eml", "shEml");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cn_fax_no", "cnFaxNo");
		this.hashFields.put("cn_fax_ntc_snd_rslt_nm", "cnFaxNtcSndRsltNm");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("sel_seq", "selSeq");
		
		this.hashFields.put("ctrt_eml_nm", "ctrtEmlNm");
		this.hashFields.put("ctrt_fax_nm", "ctrtFaxNm");
		this.hashFields.put("ctrt_cust_eml", "ctrtCustEml");
		this.hashFields.put("ctrt_fax_no", "ctrtFaxNo");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("glo_acct_flg", "gloAcctFlg");
		this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
		this.hashFields.put("lcl_acct_flg", "lclAcctFlg");
		
		this.hashFields.put("ctrt_fax_evnt_flg", "ctrtFaxEvntFlg");
		this.hashFields.put("ctrt_fax_ntc_snd_rslt_cd", "ctrtFaxNtcSndRsltCd");
		this.hashFields.put("ctrt_fax_ntc_snd_rslt_nm", "ctrtFaxNtcSndRsltNm");
		this.hashFields.put("ctrt_email_evnt_flg", "ctrtEmailEvntFlg");
		this.hashFields.put("ctrt_eml_ntc_snd_rslt_cd", "ctrtEmlNtcSndRsltCd");
		this.hashFields.put("ctrt_eml_ntc_snd_rslt_nm", "ctrtEmlNtcSndRsltNm");
		
		this.hashFields.put("acct_clss_fax", "acctClssFax");
		this.hashFields.put("acct_clss_eml", "acctClssEml");
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
	 * @return shFaxEvntFlg
	 */
	public String getShFaxEvntFlg() {
		return this.shFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return shEmlNtcSndRsltCd
	 */
	public String getShEmlNtcSndRsltCd() {
		return this.shEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return emlChk
	 */
	public String getEmlChk() {
		return this.emlChk;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return shFaxNtcSndRsltCd
	 */
	public String getShFaxNtcSndRsltCd() {
		return this.shFaxNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return nfFaxNtcSndRsltCd
	 */
	public String getNfFaxNtcSndRsltCd() {
		return this.nfFaxNtcSndRsltCd;
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
	 * @return anCustNm
	 */
	public String getAnCustNm() {
		return this.anCustNm;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return cnEml
	 */
	public String getCnEml() {
		return this.cnEml;
	}
	
	/**
	 * Column Info
	 * @return cnFaxNtcSndRsltCd
	 */
	public String getCnFaxNtcSndRsltCd() {
		return this.cnFaxNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return faxChk
	 */
	public String getFaxChk() {
		return this.faxChk;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtSrepCd
	 */
	public String getCtrtSrepCd() {
		return this.ctrtSrepCd;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return cnEmlNtcSndRsltNm
	 */
	public String getCnEmlNtcSndRsltNm() {
		return this.cnEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return nfEmailEvntFlg
	 */
	public String getNfEmailEvntFlg() {
		return this.nfEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return nfFaxEvntFlg
	 */
	public String getNfFaxEvntFlg() {
		return this.nfFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return sentFlg
	 */
	public String getSentFlg() {
		return this.sentFlg;
	}
	
	/**
	 * Column Info
	 * @return shFaxNo
	 */
	public String getShFaxNo() {
		return this.shFaxNo;
	}
	
	/**
	 * Column Info
	 * @return fnCustNm
	 */
	public String getFnCustNm() {
		return this.fnCustNm;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
	}
	
	/**
	 * Column Info
	 * @return cnEmlNtcSndRsltCd
	 */
	public String getCnEmlNtcSndRsltCd() {
		return this.cnEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return fileKey
	 */
	public String getFileKey() {
		return this.fileKey;
	}
	
	/**
	 * Column Info
	 * @return shEmlNtcSndRsltNm
	 */
	public String getShEmlNtcSndRsltNm() {
		return this.shEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return cnFaxEvntFlg
	 */
	public String getCnFaxEvntFlg() {
		return this.cnFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return nfEml
	 */
	public String getNfEml() {
		return this.nfEml;
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
	 * @return nfCustAddr
	 */
	public String getNfCustAddr() {
		return this.nfCustAddr;
	}
	
	/**
	 * Column Info
	 * @return nfEmlNtcSndRsltCd
	 */
	public String getNfEmlNtcSndRsltCd() {
		return this.nfEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return cnEmailEvntFlg
	 */
	public String getCnEmailEvntFlg() {
		return this.cnEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return srcDatTpCd
	 */
	public String getSrcDatTpCd() {
		return this.srcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @return shFaxNtcSndRsltNm
	 */
	public String getShFaxNtcSndRsltNm() {
		return this.shFaxNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return nfFaxNtcSndRsltNm
	 */
	public String getNfFaxNtcSndRsltNm() {
		return this.nfFaxNtcSndRsltNm;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return nfFaxNo
	 */
	public String getNfFaxNo() {
		return this.nfFaxNo;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return nfEmlNtcSndRsltNm
	 */
	public String getNfEmlNtcSndRsltNm() {
		return this.nfEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return shEmailEvntFlg
	 */
	public String getShEmailEvntFlg() {
		return this.shEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return shEml
	 */
	public String getShEml() {
		return this.shEml;
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
	 * @return cnFaxNo
	 */
	public String getCnFaxNo() {
		return this.cnFaxNo;
	}
	
	/**
	 * Column Info
	 * @return cnFaxNtcSndRsltNm
	 */
	public String getCnFaxNtcSndRsltNm() {
		return this.cnFaxNtcSndRsltNm;
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
	 * @return selSeq
	 */
	public String getSelSeq() {
		return this.selSeq;
	}
	
	
	/**
	 * Column Info
	 * @return ctrtEmlNm
	 */
	public String getCtrtEmlNm() {
		return this.ctrtEmlNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtFaxNm
	 */
	public String getCtrtFaxNm() {
		return this.ctrtFaxNm;
	}
	
	
	/**
	 * Column Info
	 * @return ctrtCustEml
	 */
	public String getCtrtCustEml() {
		return this.ctrtCustEml;
	}
	
	/**
	 * Column Info
	 * @return ctrtFaxNo
	 */
	public String getCtrtFaxNo() {
		return this.ctrtFaxNo;
	}
	
	/**
	 * Column Info
	 * @return keyAcctFlg
	 */
	public String getKeyAcctFlg() {
		return this.keyAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return gloAcctFlg
	 */
	public String getGloAcctFlg() {
		return this.gloAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnAcctFlg
	 */
	public String getRgnAcctFlg() {
		return this.rgnAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return lclAcctFlg
	 */
	public String getLclAcctFlg() {
		return this.lclAcctFlg;
	}
	
	
	
	
	/**
	 * Column Info
	 * @return ctrtFaxEvntFlg
	 */
	public String getCtrtFaxEvntFlg() {
		return this.ctrtFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtFaxNtcSndRsltCd
	 */
	public String getCtrtFaxNtcSndRsltCd() {
		return this.ctrtFaxNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtFaxNtcSndRsltNm
	 */
	public String getCtrtFaxNtcSndRsltNm() {
		return this.ctrtFaxNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtEmailEvntFlg
	 */
	public String getCtrtEmailEvntFlg() {
		return this.ctrtEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtEmlNtcSndRsltCd
	 */
	public String getCtrtEmlNtcSndRsltCd() {
		return this.ctrtEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtEmlNtcSndRsltNm
	 */
	public String getCtrtEmlNtcSndRsltNm() {
		return this.ctrtEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return acctClssFax
	 */
	public String getAcctClssFax() {
		return this.acctClssFax;
	}
	
	/**
	 * Column Info
	 * @return acctClssEml
	 */
	public String getAcctClssEml() {
		return this.acctClssEml;
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
	 * @param shFaxEvntFlg
	 */
	public void setShFaxEvntFlg(String shFaxEvntFlg) {
		this.shFaxEvntFlg = shFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param shEmlNtcSndRsltCd
	 */
	public void setShEmlNtcSndRsltCd(String shEmlNtcSndRsltCd) {
		this.shEmlNtcSndRsltCd = shEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param emlChk
	 */
	public void setEmlChk(String emlChk) {
		this.emlChk = emlChk;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param shFaxNtcSndRsltCd
	 */
	public void setShFaxNtcSndRsltCd(String shFaxNtcSndRsltCd) {
		this.shFaxNtcSndRsltCd = shFaxNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param nfFaxNtcSndRsltCd
	 */
	public void setNfFaxNtcSndRsltCd(String nfFaxNtcSndRsltCd) {
		this.nfFaxNtcSndRsltCd = nfFaxNtcSndRsltCd;
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
	 * @param anCustNm
	 */
	public void setAnCustNm(String anCustNm) {
		this.anCustNm = anCustNm;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param cnEml
	 */
	public void setCnEml(String cnEml) {
		this.cnEml = cnEml;
	}
	
	/**
	 * Column Info
	 * @param cnFaxNtcSndRsltCd
	 */
	public void setCnFaxNtcSndRsltCd(String cnFaxNtcSndRsltCd) {
		this.cnFaxNtcSndRsltCd = cnFaxNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param faxChk
	 */
	public void setFaxChk(String faxChk) {
		this.faxChk = faxChk;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtSrepCd
	 */
	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param cnEmlNtcSndRsltNm
	 */
	public void setCnEmlNtcSndRsltNm(String cnEmlNtcSndRsltNm) {
		this.cnEmlNtcSndRsltNm = cnEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param nfEmailEvntFlg
	 */
	public void setNfEmailEvntFlg(String nfEmailEvntFlg) {
		this.nfEmailEvntFlg = nfEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param nfFaxEvntFlg
	 */
	public void setNfFaxEvntFlg(String nfFaxEvntFlg) {
		this.nfFaxEvntFlg = nfFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param sentFlg
	 */
	public void setSentFlg(String sentFlg) {
		this.sentFlg = sentFlg;
	}
	
	/**
	 * Column Info
	 * @param shFaxNo
	 */
	public void setShFaxNo(String shFaxNo) {
		this.shFaxNo = shFaxNo;
	}
	
	/**
	 * Column Info
	 * @param fnCustNm
	 */
	public void setFnCustNm(String fnCustNm) {
		this.fnCustNm = fnCustNm;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
	}
	
	/**
	 * Column Info
	 * @param cnEmlNtcSndRsltCd
	 */
	public void setCnEmlNtcSndRsltCd(String cnEmlNtcSndRsltCd) {
		this.cnEmlNtcSndRsltCd = cnEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param fileKey
	 */
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	
	/**
	 * Column Info
	 * @param shEmlNtcSndRsltNm
	 */
	public void setShEmlNtcSndRsltNm(String shEmlNtcSndRsltNm) {
		this.shEmlNtcSndRsltNm = shEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param cnFaxEvntFlg
	 */
	public void setCnFaxEvntFlg(String cnFaxEvntFlg) {
		this.cnFaxEvntFlg = cnFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param nfEml
	 */
	public void setNfEml(String nfEml) {
		this.nfEml = nfEml;
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
	 * @param nfCustAddr
	 */
	public void setNfCustAddr(String nfCustAddr) {
		this.nfCustAddr = nfCustAddr;
	}
	
	/**
	 * Column Info
	 * @param nfEmlNtcSndRsltCd
	 */
	public void setNfEmlNtcSndRsltCd(String nfEmlNtcSndRsltCd) {
		this.nfEmlNtcSndRsltCd = nfEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param cnEmailEvntFlg
	 */
	public void setCnEmailEvntFlg(String cnEmailEvntFlg) {
		this.cnEmailEvntFlg = cnEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param srcDatTpCd
	 */
	public void setSrcDatTpCd(String srcDatTpCd) {
		this.srcDatTpCd = srcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @param shFaxNtcSndRsltNm
	 */
	public void setShFaxNtcSndRsltNm(String shFaxNtcSndRsltNm) {
		this.shFaxNtcSndRsltNm = shFaxNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param nfFaxNtcSndRsltNm
	 */
	public void setNfFaxNtcSndRsltNm(String nfFaxNtcSndRsltNm) {
		this.nfFaxNtcSndRsltNm = nfFaxNtcSndRsltNm;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param nfFaxNo
	 */
	public void setNfFaxNo(String nfFaxNo) {
		this.nfFaxNo = nfFaxNo;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param nfEmlNtcSndRsltNm
	 */
	public void setNfEmlNtcSndRsltNm(String nfEmlNtcSndRsltNm) {
		this.nfEmlNtcSndRsltNm = nfEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}
	
	/**
	 * Column Info
	 * @param shEmailEvntFlg
	 */
	public void setShEmailEvntFlg(String shEmailEvntFlg) {
		this.shEmailEvntFlg = shEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param shEml
	 */
	public void setShEml(String shEml) {
		this.shEml = shEml;
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
	 * @param cnFaxNo
	 */
	public void setCnFaxNo(String cnFaxNo) {
		this.cnFaxNo = cnFaxNo;
	}
	
	/**
	 * Column Info
	 * @param cnFaxNtcSndRsltNm
	 */
	public void setCnFaxNtcSndRsltNm(String cnFaxNtcSndRsltNm) {
		this.cnFaxNtcSndRsltNm = cnFaxNtcSndRsltNm;
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
	 * @param selSeq
	 */
	public void setSelSeq(String selSeq){
		this.selSeq = selSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrtEmlNm
	 */
	public void setCtrtEmlNm(String ctrtEmlNm) {
		this.ctrtEmlNm = ctrtEmlNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtFaxNm
	 */
	public void setCtrtFaxNm(String ctrtFaxNm) {
		this.ctrtFaxNm = ctrtFaxNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustEml
	 */
	public void setCtrtCustEml(String ctrtCustEml) {
		this.ctrtCustEml = ctrtCustEml;
	}
	
	/**
	 * Column Info
	 * @param ctrtFaxNo
	 */
	public void setCtrtFaxNo(String ctrtFaxNo) {
		this.ctrtFaxNo = ctrtFaxNo;
	}
	
	/**
	 * Column Info
	 * @param keyAcctFlg
	 */
	public void setKeyAcctFlg(String keyAcctFlg) {
		this.keyAcctFlg = keyAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param gloAcctFlg
	 */
	public void setGloAcctFlg(String gloAcctFlg) {
		this.gloAcctFlg = gloAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnAcctFlg
	 */
	public void setRgnAcctFlg(String rgnAcctFlg) {
		this.rgnAcctFlg = rgnAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param lclAcctFlg
	 */
	public void setLclAcctFlg(String lclAcctFlg){
		this.lclAcctFlg = lclAcctFlg;
	}
	
	
	
	/**
	 * Column Info
	 * @param ctrtFaxEvntFlg
	 */
	public void setCtrtFaxEvntFlg(String ctrtFaxEvntFlg) {
		this.ctrtFaxEvntFlg = ctrtFaxEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtFaxNtcSndRsltCd
	 */
	public void setCtrtFaxNtcSndRsltCd(String ctrtFaxNtcSndRsltCd) {
		this.ctrtFaxNtcSndRsltCd = ctrtFaxNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtFaxNtcSndRsltNm
	 */
	public void setCtrtFaxNtcSndRsltNm(String ctrtFaxNtcSndRsltNm) {
		this.ctrtFaxNtcSndRsltNm = ctrtFaxNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtEmailEvntFlg
	 */
	public void setCtrtEmailEvntFlg(String ctrtEmailEvntFlg) {
		this.ctrtEmailEvntFlg = ctrtEmailEvntFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtEmlNtcSndRsltCd
	 */
	public void setCtrtEmlNtcSndRsltCd(String ctrtEmlNtcSndRsltCd) {
		this.ctrtEmlNtcSndRsltCd = ctrtEmlNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtEmlNtcSndRsltNm
	 */
	public void setCtrtEmlNtcSndRsltNm(String ctrtEmlNtcSndRsltNm){
		this.ctrtEmlNtcSndRsltNm = ctrtEmlNtcSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param acctClssFax
	 */
	public void setAcctClssFax(String acctClssFax) {
		this.acctClssFax = acctClssFax;
	}
	
	/**
	 * Column Info
	 * @param acctClssEml
	 */
	public void setAcctClssEml(String acctClssEml){
		this.acctClssEml = acctClssEml;
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
		setShFaxEvntFlg(JSPUtil.getParameter(request, prefix + "sh_fax_evnt_flg", ""));
		setShEmlNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "sh_eml_ntc_snd_rslt_cd", ""));
		setEmlChk(JSPUtil.getParameter(request, prefix + "eml_chk", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCnCustAddr(JSPUtil.getParameter(request, prefix + "cn_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setShFaxNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "sh_fax_ntc_snd_rslt_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setNfFaxNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "nf_fax_ntc_snd_rslt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setAnCustNm(JSPUtil.getParameter(request, prefix + "an_cust_nm", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setCnEml(JSPUtil.getParameter(request, prefix + "cn_eml", ""));
		setCnFaxNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "cn_fax_ntc_snd_rslt_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setFaxChk(JSPUtil.getParameter(request, prefix + "fax_chk", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCnEmlNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "cn_eml_ntc_snd_rslt_nm", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setNfEmailEvntFlg(JSPUtil.getParameter(request, prefix + "nf_email_evnt_flg", ""));
		setNfFaxEvntFlg(JSPUtil.getParameter(request, prefix + "nf_fax_evnt_flg", ""));
		setSentFlg(JSPUtil.getParameter(request, prefix + "sent_flg", ""));
		setShFaxNo(JSPUtil.getParameter(request, prefix + "sh_fax_no", ""));
		setFnCustNm(JSPUtil.getParameter(request, prefix + "fn_cust_nm", ""));
		setCntrNo1(JSPUtil.getParameter(request, prefix + "cntr_no1", ""));
		setCnEmlNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "cn_eml_ntc_snd_rslt_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileKey(JSPUtil.getParameter(request, prefix + "file_key", ""));
		setShEmlNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "sh_eml_ntc_snd_rslt_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setCnFaxEvntFlg(JSPUtil.getParameter(request, prefix + "cn_fax_evnt_flg", ""));
		setNfEml(JSPUtil.getParameter(request, prefix + "nf_eml", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setNfCustAddr(JSPUtil.getParameter(request, prefix + "nf_cust_addr", ""));
		setNfEmlNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "nf_eml_ntc_snd_rslt_cd", ""));
		setCnEmailEvntFlg(JSPUtil.getParameter(request, prefix + "cn_email_evnt_flg", ""));
		setSrcDatTpCd(JSPUtil.getParameter(request, prefix + "src_dat_tp_cd", ""));
		setShFaxNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "sh_fax_ntc_snd_rslt_nm", ""));
		setNfFaxNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "nf_fax_ntc_snd_rslt_nm", ""));
		setShCustAddr(JSPUtil.getParameter(request, prefix + "sh_cust_addr", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setNfFaxNo(JSPUtil.getParameter(request, prefix + "nf_fax_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setNfEmlNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "nf_eml_ntc_snd_rslt_nm", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setShEmailEvntFlg(JSPUtil.getParameter(request, prefix + "sh_email_evnt_flg", ""));
		setShEml(JSPUtil.getParameter(request, prefix + "sh_eml", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCnFaxNo(JSPUtil.getParameter(request, prefix + "cn_fax_no", ""));
		setCnFaxNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "cn_fax_ntc_snd_rslt_nm", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setSelSeq(JSPUtil.getParameter(request, prefix + "sel_seq", ""));
		
		setCtrtEmlNm(JSPUtil.getParameter(request, prefix + "ctrt_eml_nm", ""));
		setCtrtFaxNm(JSPUtil.getParameter(request, prefix + "ctrt_fax_nm", ""));
		setCtrtCustEml(JSPUtil.getParameter(request, prefix + "ctrt_cust_eml", ""));
		setCtrtFaxNo(JSPUtil.getParameter(request, prefix + "ctrt_fax_no", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
		setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
		setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
		setLclAcctFlg(JSPUtil.getParameter(request, prefix + "lcl_acct_flg", ""));
		
		setCtrtFaxEvntFlg(JSPUtil.getParameter(request, prefix + "ctrt_fax_evnt_flg", ""));
		setCtrtFaxNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "ctrt_fax_ntc_snd_rslt_cd", ""));
		setCtrtFaxNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "ctrt_fax_ntc_snd_rslt_nm", ""));
		setCtrtEmailEvntFlg(JSPUtil.getParameter(request, prefix + "ctrt_email_evnt_flg", ""));
		setCtrtEmlNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "ctrt_eml_ntc_snd_rslt_cd", ""));
		setCtrtEmlNtcSndRsltNm(JSPUtil.getParameter(request, prefix + "ctrt_eml_ntc_snd_rslt_nm", ""));
		
		setAcctClssFax(JSPUtil.getParameter(request, prefix + "acct_clss_fax", ""));
		setAcctClssEml(JSPUtil.getParameter(request, prefix + "acct_clss_eml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcSndVO[]
	 */
	public BkgCustAvcNtcSndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcSndVO[]
	 */
	public BkgCustAvcNtcSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustAvcNtcSndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] shFaxEvntFlg = (JSPUtil.getParameter(request, prefix	+ "sh_fax_evnt_flg", length));
			String[] shEmlNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "sh_eml_ntc_snd_rslt_cd", length));
			String[] emlChk = (JSPUtil.getParameter(request, prefix	+ "eml_chk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] shFaxNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "sh_fax_ntc_snd_rslt_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] nfFaxNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "nf_fax_ntc_snd_rslt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] cnEml = (JSPUtil.getParameter(request, prefix	+ "cn_eml", length));
			String[] cnFaxNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "cn_fax_ntc_snd_rslt_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] faxChk = (JSPUtil.getParameter(request, prefix	+ "fax_chk", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cnEmlNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "cn_eml_ntc_snd_rslt_nm", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] nfEmailEvntFlg = (JSPUtil.getParameter(request, prefix	+ "nf_email_evnt_flg", length));
			String[] nfFaxEvntFlg = (JSPUtil.getParameter(request, prefix	+ "nf_fax_evnt_flg", length));
			String[] sentFlg = (JSPUtil.getParameter(request, prefix	+ "sent_flg", length));
			String[] shFaxNo = (JSPUtil.getParameter(request, prefix	+ "sh_fax_no", length));
			String[] fnCustNm = (JSPUtil.getParameter(request, prefix	+ "fn_cust_nm", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] cnEmlNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "cn_eml_ntc_snd_rslt_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileKey = (JSPUtil.getParameter(request, prefix	+ "file_key", length));
			String[] shEmlNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "sh_eml_ntc_snd_rslt_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] cnFaxEvntFlg = (JSPUtil.getParameter(request, prefix	+ "cn_fax_evnt_flg", length));
			String[] nfEml = (JSPUtil.getParameter(request, prefix	+ "nf_eml", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] nfEmlNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "nf_eml_ntc_snd_rslt_cd", length));
			String[] cnEmailEvntFlg = (JSPUtil.getParameter(request, prefix	+ "cn_email_evnt_flg", length));
			String[] srcDatTpCd = (JSPUtil.getParameter(request, prefix	+ "src_dat_tp_cd", length));
			String[] shFaxNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "sh_fax_ntc_snd_rslt_nm", length));
			String[] nfFaxNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "nf_fax_ntc_snd_rslt_nm", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] nfFaxNo = (JSPUtil.getParameter(request, prefix	+ "nf_fax_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] nfEmlNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "nf_eml_ntc_snd_rslt_nm", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] shEmailEvntFlg = (JSPUtil.getParameter(request, prefix	+ "sh_email_evnt_flg", length));
			String[] shEml = (JSPUtil.getParameter(request, prefix	+ "sh_eml", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnFaxNo = (JSPUtil.getParameter(request, prefix	+ "cn_fax_no", length));
			String[] cnFaxNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "cn_fax_ntc_snd_rslt_nm", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] selSeq = (JSPUtil.getParameter(request, prefix	+ "sel_seq", length));
			
			String[] ctrtEmlNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_eml_nm", length));
			String[] ctrtFaxNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_fax_nm", length));
			String[] ctrtCustEml = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_eml", length));
			String[] ctrtFaxNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_fax_no", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix	+ "glo_acct_flg", length));
			String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_acct_flg", length));
			String[] lclAcctFlg = (JSPUtil.getParameter(request, prefix	+ "lcl_acct_flg", length));
			
			String[] ctrtFaxEvntFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_fax_evnt_flg", length));
			String[] ctrtFaxNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_fax_ntc_snd_rslt_cd", length));
			String[] ctrtFaxNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_fax_ntc_snd_rslt_nm", length));
			String[] ctrtEmailEvntFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_email_evnt_flg", length));
			String[] ctrtEmlNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_eml_ntc_snd_rslt_cd", length));
			String[] ctrtEmlNtcSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_eml_ntc_snd_rslt_nm", length));
			
			String[] acctClssFax = (JSPUtil.getParameter(request, prefix	+ "acct_clss_fax", length));
			String[] acctClssEml = (JSPUtil.getParameter(request, prefix	+ "acct_clss_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustAvcNtcSndVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (shFaxEvntFlg[i] != null)
					model.setShFaxEvntFlg(shFaxEvntFlg[i]);
				if (shEmlNtcSndRsltCd[i] != null)
					model.setShEmlNtcSndRsltCd(shEmlNtcSndRsltCd[i]);
				if (emlChk[i] != null)
					model.setEmlChk(emlChk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cnCustAddr[i] != null)
					model.setCnCustAddr(cnCustAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (shFaxNtcSndRsltCd[i] != null)
					model.setShFaxNtcSndRsltCd(shFaxNtcSndRsltCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (nfFaxNtcSndRsltCd[i] != null)
					model.setNfFaxNtcSndRsltCd(nfFaxNtcSndRsltCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (anCustNm[i] != null)
					model.setAnCustNm(anCustNm[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (cnEml[i] != null)
					model.setCnEml(cnEml[i]);
				if (cnFaxNtcSndRsltCd[i] != null)
					model.setCnFaxNtcSndRsltCd(cnFaxNtcSndRsltCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (faxChk[i] != null)
					model.setFaxChk(faxChk[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cnEmlNtcSndRsltNm[i] != null)
					model.setCnEmlNtcSndRsltNm(cnEmlNtcSndRsltNm[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (nfEmailEvntFlg[i] != null)
					model.setNfEmailEvntFlg(nfEmailEvntFlg[i]);
				if (nfFaxEvntFlg[i] != null)
					model.setNfFaxEvntFlg(nfFaxEvntFlg[i]);
				if (sentFlg[i] != null)
					model.setSentFlg(sentFlg[i]);
				if (shFaxNo[i] != null)
					model.setShFaxNo(shFaxNo[i]);
				if (fnCustNm[i] != null)
					model.setFnCustNm(fnCustNm[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (cnEmlNtcSndRsltCd[i] != null)
					model.setCnEmlNtcSndRsltCd(cnEmlNtcSndRsltCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileKey[i] != null)
					model.setFileKey(fileKey[i]);
				if (shEmlNtcSndRsltNm[i] != null)
					model.setShEmlNtcSndRsltNm(shEmlNtcSndRsltNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (cnFaxEvntFlg[i] != null)
					model.setCnFaxEvntFlg(cnFaxEvntFlg[i]);
				if (nfEml[i] != null)
					model.setNfEml(nfEml[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (nfCustAddr[i] != null)
					model.setNfCustAddr(nfCustAddr[i]);
				if (nfEmlNtcSndRsltCd[i] != null)
					model.setNfEmlNtcSndRsltCd(nfEmlNtcSndRsltCd[i]);
				if (cnEmailEvntFlg[i] != null)
					model.setCnEmailEvntFlg(cnEmailEvntFlg[i]);
				if (srcDatTpCd[i] != null)
					model.setSrcDatTpCd(srcDatTpCd[i]);
				if (shFaxNtcSndRsltNm[i] != null)
					model.setShFaxNtcSndRsltNm(shFaxNtcSndRsltNm[i]);
				if (nfFaxNtcSndRsltNm[i] != null)
					model.setNfFaxNtcSndRsltNm(nfFaxNtcSndRsltNm[i]);
				if (shCustAddr[i] != null)
					model.setShCustAddr(shCustAddr[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (nfFaxNo[i] != null)
					model.setNfFaxNo(nfFaxNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (nfEmlNtcSndRsltNm[i] != null)
					model.setNfEmlNtcSndRsltNm(nfEmlNtcSndRsltNm[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (shEmailEvntFlg[i] != null)
					model.setShEmailEvntFlg(shEmailEvntFlg[i]);
				if (shEml[i] != null)
					model.setShEml(shEml[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnFaxNo[i] != null)
					model.setCnFaxNo(cnFaxNo[i]);
				if (cnFaxNtcSndRsltNm[i] != null)
					model.setCnFaxNtcSndRsltNm(cnFaxNtcSndRsltNm[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (selSeq[i] != null)
					model.setSelSeq(selSeq[i]);
				
				if (ctrtEmlNm[i] != null)
					model.setCtrtEmlNm(ctrtEmlNm[i]);
				if (ctrtFaxNm[i] != null)
					model.setCtrtFaxNm(ctrtFaxNm[i]);
				if (ctrtCustEml[i] != null)
					model.setCtrtCustEml(ctrtCustEml[i]);
				if (ctrtFaxNo[i] != null)
					model.setCtrtFaxNo(ctrtFaxNo[i]);
				if (keyAcctFlg[i] != null)
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (gloAcctFlg[i] != null)
					model.setGloAcctFlg(gloAcctFlg[i]);
				if (rgnAcctFlg[i] != null)
					model.setRgnAcctFlg(rgnAcctFlg[i]);
				if (lclAcctFlg[i] != null)
					model.setLclAcctFlg(lclAcctFlg[i]);
				
				if (ctrtFaxEvntFlg[i] != null)
					model.setCtrtFaxEvntFlg(ctrtFaxEvntFlg[i]);
				if (ctrtFaxNtcSndRsltCd[i] != null)
					model.setCtrtFaxNtcSndRsltCd(ctrtFaxNtcSndRsltCd[i]);
				if (ctrtFaxNtcSndRsltNm[i] != null)
					model.setCtrtFaxNtcSndRsltNm(ctrtFaxNtcSndRsltNm[i]);
				if (ctrtEmailEvntFlg[i] != null)
					model.setCtrtEmailEvntFlg(ctrtEmailEvntFlg[i]);
				if (ctrtEmlNtcSndRsltCd[i] != null)
					model.setCtrtEmlNtcSndRsltCd(ctrtEmlNtcSndRsltCd[i]);
				if (ctrtEmlNtcSndRsltNm[i] != null)
					model.setCtrtEmlNtcSndRsltNm(ctrtEmlNtcSndRsltNm[i]);
				
				if (acctClssFax[i] != null)
					model.setAcctClssFax(acctClssFax[i]);
				if (acctClssEml[i] != null)
					model.setAcctClssEml(acctClssEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustAvcNtcSndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcSndVO[]
	 */
	public BkgCustAvcNtcSndVO[] getBkgCustAvcNtcSndVOs(){
		BkgCustAvcNtcSndVO[] vos = (BkgCustAvcNtcSndVO[])models.toArray(new BkgCustAvcNtcSndVO[models.size()]);
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
		this.shFaxEvntFlg = this.shFaxEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEmlNtcSndRsltCd = this.shEmlNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlChk = this.emlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shFaxNtcSndRsltCd = this.shFaxNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfFaxNtcSndRsltCd = this.nfFaxNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEml = this.cnEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnFaxNtcSndRsltCd = this.cnFaxNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxChk = this.faxChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEmlNtcSndRsltNm = this.cnEmlNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEmailEvntFlg = this.nfEmailEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfFaxEvntFlg = this.nfFaxEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentFlg = this.sentFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shFaxNo = this.shFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnCustNm = this.fnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEmlNtcSndRsltCd = this.cnEmlNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileKey = this.fileKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEmlNtcSndRsltNm = this.shEmlNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnFaxEvntFlg = this.cnFaxEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEml = this.nfEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEmlNtcSndRsltCd = this.nfEmlNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnEmailEvntFlg = this.cnEmailEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcDatTpCd = this.srcDatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shFaxNtcSndRsltNm = this.shFaxNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfFaxNtcSndRsltNm = this.nfFaxNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfFaxNo = this.nfFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfEmlNtcSndRsltNm = this.nfEmlNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEmailEvntFlg = this.shEmailEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEml = this.shEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnFaxNo = this.cnFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnFaxNtcSndRsltNm = this.cnFaxNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSeq = this.selSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.ctrtEmlNm = this.ctrtEmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFaxNm = this.ctrtFaxNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustEml = this.ctrtCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFaxNo = this.ctrtFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAcctFlg = this.gloAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAcctFlg = this.rgnAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAcctFlg = this.lclAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.ctrtFaxEvntFlg = this.ctrtFaxEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFaxNtcSndRsltCd = this.ctrtFaxNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFaxNtcSndRsltNm = this.ctrtFaxNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEmailEvntFlg = this.ctrtEmailEvntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEmlNtcSndRsltCd = this.ctrtEmlNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEmlNtcSndRsltNm = this.ctrtEmlNtcSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClssFax = this.acctClssFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClssEml = this.acctClssEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
