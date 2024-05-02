/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrNtcSendListVO.java
*@FileTitle : ArrNtcSendListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.22 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class ArrNtcSendListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcSendListVO> models = new ArrayList<ArrNtcSendListVO>();
	
	/* Column Info */
	private String faxNo1 = null;
	/* Column Info */
	private String faxNtcSndRsltNm2 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String faxNtcSndRsltNm1 = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String faxNtcSndRsltNm4 = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String faxNtcSndRsltNm3 = null;
	/* Column Info */
	private String faxNo5 = null;
	/* Column Info */
	private String faxNo4 = null;
	/* Column Info */
	private String faxNtcSndRsltNm5 = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String faxSndFlg3 = null;
	/* Column Info */
	private String faxSndFlg4 = null;
	/* Column Info */
	private String faxSndFlg1 = null;
	/* Column Info */
	private String faxSndFlg2 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String emlNtcSndRsltCd1 = null;
	/* Column Info */
	private String emlNtcSndRsltCd2 = null;
	/* Column Info */
	private String emlNtcSndRsltCd3 = null;
	/* Column Info */
	private String emlNtcSndRsltCd4 = null;
	/* Column Info */
	private String emlNtcSndRsltCd5 = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String chkEmail = null;
	/* Column Info */
	private String faxEvntFlg2 = null;
	/* Column Info */
	private String faxEvntFlg1 = null;
	/* Column Info */
	private String faxEvntFlg4 = null;
	/* Column Info */
	private String faxEvntFlg3 = null;
	/* Column Info */
	private String isHold = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String emlNtcSndRsltNm4 = null;
	/* Column Info */
	private String comParam = null;
	/* Column Info */
	private String emlNtcSndRsltNm5 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String eclzBlCpyFlg = null;
	/* Column Info */
	private String emlNtcSndRsltNm1 = null;
	/* Column Info */
	private String faxEvntFlg5 = null;
	/* Column Info */
	private String emlNtcSndRsltNm2 = null;
	/* Column Info */
	private String emlNtcSndRsltNm3 = null;
	/* Column Info */
	private String arrPrvFomCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String faxSndFlg5 = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String anFomCd = null;
	/* Column Info */
	private String rdPrtFlg = null;
	/* Column Info */
	private String emlSndFlg5 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String emlSndFlg4 = null;
	/* Column Info */
	private String rvisFlg = null;
	/* Column Info */
	private String emlSndFlg1 = null;
	/* Column Info */
	private String emlSndFlg3 = null;
	/* Column Info */
	private String emlSndFlg2 = null;
	/* Column Info */
	private String tsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileKey = null;
	/* Column Info */
	private String loclLangFlg = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String emlEvntFlg1 = null;
	/* Column Info */
	private String emlEvntFlg5 = null;
	/* Column Info */
	private String faxNtcSndRsltCd3 = null;
	/* Column Info */
	private String emlEvntFlg4 = null;
	/* Column Info */
	private String faxNtcSndRsltCd4 = null;
	/* Column Info */
	private String emlEvntFlg3 = null;
	/* Column Info */
	private String faxNtcSndRsltCd5 = null;
	/* Column Info */
	private String emlEvntFlg2 = null;
	/* Column Info */
	private String faxNtcSndRsltCd2 = null;
	/* Column Info */
	private String faxNtcSndRsltCd1 = null;
	/* Column Info */
	private String ntcEml1 = null;
	/* Column Info */
	private String ntcEml2 = null;
	/* Column Info */
	private String ntcEml3 = null;
	/* Column Info */
	private String ntcEml4 = null;
	/* Column Info */
	private String ntcEml5 = null;
	/* Column Info */
	private String chkFax = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String anSent = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String isValidated = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String chgDpFlg = null;
	/* Column Info */
	private String mrdId = null;
	/* Column Info */
	private String hubLocCd = null;
	
	/* Column Info */
	private String showPuFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcSendListVO() {}

	public ArrNtcSendListVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String chkFax, String chkEmail, String anFomCd, String bkgNo, String chgDpFlg, String blNo, String bkgCustTpCd, String custCntCd, String custSeq, String scNo, String custCd, String custNm, String anSent, String faxNo1, String faxNo2, String faxNo3, String faxNo4, String faxNo5, String faxSndFlg1, String faxSndFlg2, String faxSndFlg3, String faxSndFlg4, String faxSndFlg5, String faxNtcSndRsltCd1, String faxNtcSndRsltNm1, String faxNtcSndRsltCd2, String faxNtcSndRsltNm2, String faxNtcSndRsltCd3, String faxNtcSndRsltNm3, String faxNtcSndRsltCd4, String faxNtcSndRsltNm4, String faxNtcSndRsltCd5, String faxNtcSndRsltNm5, String faxSndDt, String faxEvntFlg1, String faxEvntFlg2, String faxEvntFlg3, String faxEvntFlg4, String faxEvntFlg5, String ntcEml1, String ntcEml2, String ntcEml3, String ntcEml4, String ntcEml5, String emlSndFlg1, String emlSndFlg2, String emlSndFlg3, String emlSndFlg4, String emlSndFlg5, String emlNtcSndRsltCd1, String emlNtcSndRsltNm1, String emlNtcSndRsltCd2, String emlNtcSndRsltNm2, String emlNtcSndRsltCd3, String emlNtcSndRsltNm3, String emlNtcSndRsltCd4, String emlNtcSndRsltNm4, String emlNtcSndRsltCd5, String emlNtcSndRsltNm5, String emlSndDt, String emlEvntFlg1, String emlEvntFlg2, String emlEvntFlg3, String emlEvntFlg4, String emlEvntFlg5, String cstmsClrTpCd, String hubLocCd, String podCd, String delCd, String deTermCd, String isHold, String usrId, String diffRmk, String sndUsrId, String usrNm, String fileKey, String isValidated, String bkgCgoTpCd, String rvisFlg, String tsFlg, String rdPrtFlg, String arrPrvFomCd, String loclLangFlg, String eclzBlCpyFlg, String mrdId, String comParam, String showPuFlg) {
		this.faxNo1 = faxNo1;
		this.faxNtcSndRsltNm2 = faxNtcSndRsltNm2;
		this.vslCd = vslCd;
		this.faxNtcSndRsltNm1 = faxNtcSndRsltNm1;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.faxNtcSndRsltNm4 = faxNtcSndRsltNm4;
		this.emlSndDt = emlSndDt;
		this.faxNtcSndRsltNm3 = faxNtcSndRsltNm3;
		this.faxNo5 = faxNo5;
		this.faxNo4 = faxNo4;
		this.faxNtcSndRsltNm5 = faxNtcSndRsltNm5;
		this.faxNo3 = faxNo3;
		this.faxNo2 = faxNo2;
		this.faxSndFlg3 = faxSndFlg3;
		this.faxSndFlg4 = faxSndFlg4;
		this.faxSndFlg1 = faxSndFlg1;
		this.faxSndFlg2 = faxSndFlg2;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.scNo = scNo;
		this.emlNtcSndRsltCd1 = emlNtcSndRsltCd1;
		this.emlNtcSndRsltCd2 = emlNtcSndRsltCd2;
		this.emlNtcSndRsltCd3 = emlNtcSndRsltCd3;
		this.emlNtcSndRsltCd4 = emlNtcSndRsltCd4;
		this.emlNtcSndRsltCd5 = emlNtcSndRsltCd5;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.chkEmail = chkEmail;
		this.faxEvntFlg2 = faxEvntFlg2;
		this.faxEvntFlg1 = faxEvntFlg1;
		this.faxEvntFlg4 = faxEvntFlg4;
		this.faxEvntFlg3 = faxEvntFlg3;
		this.isHold = isHold;
		this.delCd = delCd;
		this.emlNtcSndRsltNm4 = emlNtcSndRsltNm4;
		this.comParam = comParam;
		this.emlNtcSndRsltNm5 = emlNtcSndRsltNm5;
		this.skdVoyNo = skdVoyNo;
		this.eclzBlCpyFlg = eclzBlCpyFlg;
		this.emlNtcSndRsltNm1 = emlNtcSndRsltNm1;
		this.faxEvntFlg5 = faxEvntFlg5;
		this.emlNtcSndRsltNm2 = emlNtcSndRsltNm2;
		this.emlNtcSndRsltNm3 = emlNtcSndRsltNm3;
		this.arrPrvFomCd = arrPrvFomCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.sndUsrId = sndUsrId;
		this.bkgNo = bkgNo;
		this.faxSndFlg5 = faxSndFlg5;
		this.custCd = custCd;
		this.anFomCd = anFomCd;
		this.rdPrtFlg = rdPrtFlg;
		this.emlSndFlg5 = emlSndFlg5;
		this.custNm = custNm;
		this.emlSndFlg4 = emlSndFlg4;
		this.rvisFlg = rvisFlg;
		this.emlSndFlg1 = emlSndFlg1;
		this.emlSndFlg3 = emlSndFlg3;
		this.emlSndFlg2 = emlSndFlg2;
		this.tsFlg = tsFlg;
		this.ibflag = ibflag;
		this.fileKey = fileKey;
		this.loclLangFlg = loclLangFlg;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.emlEvntFlg1 = emlEvntFlg1;
		this.emlEvntFlg5 = emlEvntFlg5;
		this.faxNtcSndRsltCd3 = faxNtcSndRsltCd3;
		this.emlEvntFlg4 = emlEvntFlg4;
		this.faxNtcSndRsltCd4 = faxNtcSndRsltCd4;
		this.emlEvntFlg3 = emlEvntFlg3;
		this.faxNtcSndRsltCd5 = faxNtcSndRsltCd5;
		this.emlEvntFlg2 = emlEvntFlg2;
		this.faxNtcSndRsltCd2 = faxNtcSndRsltCd2;
		this.faxNtcSndRsltCd1 = faxNtcSndRsltCd1;
		this.ntcEml1 = ntcEml1;
		this.ntcEml2 = ntcEml2;
		this.ntcEml3 = ntcEml3;
		this.ntcEml4 = ntcEml4;
		this.ntcEml5 = ntcEml5;
		this.chkFax = chkFax;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.anSent = anSent;
		this.deTermCd = deTermCd;
		this.diffRmk = diffRmk;
		this.isValidated = isValidated;
		this.faxSndDt = faxSndDt;
		this.chgDpFlg = chgDpFlg;
		this.mrdId = mrdId;
		this.hubLocCd = hubLocCd;
		this.showPuFlg = showPuFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fax_no1", getFaxNo1());
		this.hashColumns.put("fax_ntc_snd_rslt_nm2", getFaxNtcSndRsltNm2());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("fax_ntc_snd_rslt_nm1", getFaxNtcSndRsltNm1());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("fax_ntc_snd_rslt_nm4", getFaxNtcSndRsltNm4());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("fax_ntc_snd_rslt_nm3", getFaxNtcSndRsltNm3());
		this.hashColumns.put("fax_no5", getFaxNo5());
		this.hashColumns.put("fax_no4", getFaxNo4());
		this.hashColumns.put("fax_ntc_snd_rslt_nm5", getFaxNtcSndRsltNm5());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("fax_snd_flg3", getFaxSndFlg3());
		this.hashColumns.put("fax_snd_flg4", getFaxSndFlg4());
		this.hashColumns.put("fax_snd_flg1", getFaxSndFlg1());
		this.hashColumns.put("fax_snd_flg2", getFaxSndFlg2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("eml_ntc_snd_rslt_cd1", getEmlNtcSndRsltCd1());
		this.hashColumns.put("eml_ntc_snd_rslt_cd2", getEmlNtcSndRsltCd2());
		this.hashColumns.put("eml_ntc_snd_rslt_cd3", getEmlNtcSndRsltCd3());
		this.hashColumns.put("eml_ntc_snd_rslt_cd4", getEmlNtcSndRsltCd4());
		this.hashColumns.put("eml_ntc_snd_rslt_cd5", getEmlNtcSndRsltCd5());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("chk_email", getChkEmail());
		this.hashColumns.put("fax_evnt_flg2", getFaxEvntFlg2());
		this.hashColumns.put("fax_evnt_flg1", getFaxEvntFlg1());
		this.hashColumns.put("fax_evnt_flg4", getFaxEvntFlg4());
		this.hashColumns.put("fax_evnt_flg3", getFaxEvntFlg3());
		this.hashColumns.put("is_hold", getIsHold());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("eml_ntc_snd_rslt_nm4", getEmlNtcSndRsltNm4());
		this.hashColumns.put("com_param", getComParam());
		this.hashColumns.put("eml_ntc_snd_rslt_nm5", getEmlNtcSndRsltNm5());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("eclz_bl_cpy_flg", getEclzBlCpyFlg());
		this.hashColumns.put("eml_ntc_snd_rslt_nm1", getEmlNtcSndRsltNm1());
		this.hashColumns.put("fax_evnt_flg5", getFaxEvntFlg5());
		this.hashColumns.put("eml_ntc_snd_rslt_nm2", getEmlNtcSndRsltNm2());
		this.hashColumns.put("eml_ntc_snd_rslt_nm3", getEmlNtcSndRsltNm3());
		this.hashColumns.put("arr_prv_fom_cd", getArrPrvFomCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fax_snd_flg5", getFaxSndFlg5());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("an_fom_cd", getAnFomCd());
		this.hashColumns.put("rd_prt_flg", getRdPrtFlg());
		this.hashColumns.put("eml_snd_flg5", getEmlSndFlg5());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("eml_snd_flg4", getEmlSndFlg4());
		this.hashColumns.put("rvis_flg", getRvisFlg());
		this.hashColumns.put("eml_snd_flg1", getEmlSndFlg1());
		this.hashColumns.put("eml_snd_flg3", getEmlSndFlg3());
		this.hashColumns.put("eml_snd_flg2", getEmlSndFlg2());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_key", getFileKey());
		this.hashColumns.put("locl_lang_flg", getLoclLangFlg());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("eml_evnt_flg1", getEmlEvntFlg1());
		this.hashColumns.put("eml_evnt_flg5", getEmlEvntFlg5());
		this.hashColumns.put("fax_ntc_snd_rslt_cd3", getFaxNtcSndRsltCd3());
		this.hashColumns.put("eml_evnt_flg4", getEmlEvntFlg4());
		this.hashColumns.put("fax_ntc_snd_rslt_cd4", getFaxNtcSndRsltCd4());
		this.hashColumns.put("eml_evnt_flg3", getEmlEvntFlg3());
		this.hashColumns.put("fax_ntc_snd_rslt_cd5", getFaxNtcSndRsltCd5());
		this.hashColumns.put("eml_evnt_flg2", getEmlEvntFlg2());
		this.hashColumns.put("fax_ntc_snd_rslt_cd2", getFaxNtcSndRsltCd2());
		this.hashColumns.put("fax_ntc_snd_rslt_cd1", getFaxNtcSndRsltCd1());
		this.hashColumns.put("ntc_eml1", getNtcEml1());
		this.hashColumns.put("ntc_eml2", getNtcEml2());
		this.hashColumns.put("ntc_eml3", getNtcEml3());
		this.hashColumns.put("ntc_eml4", getNtcEml4());
		this.hashColumns.put("ntc_eml5", getNtcEml5());
		this.hashColumns.put("chk_fax", getChkFax());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("an_sent", getAnSent());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("is_validated", getIsValidated());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("chg_dp_flg", getChgDpFlg());
		this.hashColumns.put("mrd_id", getMrdId());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("show_pu_flg", getShowPuFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fax_no1", "faxNo1");
		this.hashFields.put("fax_ntc_snd_rslt_nm2", "faxNtcSndRsltNm2");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("fax_ntc_snd_rslt_nm1", "faxNtcSndRsltNm1");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("fax_ntc_snd_rslt_nm4", "faxNtcSndRsltNm4");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("fax_ntc_snd_rslt_nm3", "faxNtcSndRsltNm3");
		this.hashFields.put("fax_no5", "faxNo5");
		this.hashFields.put("fax_no4", "faxNo4");
		this.hashFields.put("fax_ntc_snd_rslt_nm5", "faxNtcSndRsltNm5");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("fax_snd_flg3", "faxSndFlg3");
		this.hashFields.put("fax_snd_flg4", "faxSndFlg4");
		this.hashFields.put("fax_snd_flg1", "faxSndFlg1");
		this.hashFields.put("fax_snd_flg2", "faxSndFlg2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("eml_ntc_snd_rslt_cd1", "emlNtcSndRsltCd1");
		this.hashFields.put("eml_ntc_snd_rslt_cd2", "emlNtcSndRsltCd2");
		this.hashFields.put("eml_ntc_snd_rslt_cd3", "emlNtcSndRsltCd3");
		this.hashFields.put("eml_ntc_snd_rslt_cd4", "emlNtcSndRsltCd4");
		this.hashFields.put("eml_ntc_snd_rslt_cd5", "emlNtcSndRsltCd5");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("chk_email", "chkEmail");
		this.hashFields.put("fax_evnt_flg2", "faxEvntFlg2");
		this.hashFields.put("fax_evnt_flg1", "faxEvntFlg1");
		this.hashFields.put("fax_evnt_flg4", "faxEvntFlg4");
		this.hashFields.put("fax_evnt_flg3", "faxEvntFlg3");
		this.hashFields.put("is_hold", "isHold");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("eml_ntc_snd_rslt_nm4", "emlNtcSndRsltNm4");
		this.hashFields.put("com_param", "comParam");
		this.hashFields.put("eml_ntc_snd_rslt_nm5", "emlNtcSndRsltNm5");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eclz_bl_cpy_flg", "eclzBlCpyFlg");
		this.hashFields.put("eml_ntc_snd_rslt_nm1", "emlNtcSndRsltNm1");
		this.hashFields.put("fax_evnt_flg5", "faxEvntFlg5");
		this.hashFields.put("eml_ntc_snd_rslt_nm2", "emlNtcSndRsltNm2");
		this.hashFields.put("eml_ntc_snd_rslt_nm3", "emlNtcSndRsltNm3");
		this.hashFields.put("arr_prv_fom_cd", "arrPrvFomCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fax_snd_flg5", "faxSndFlg5");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("an_fom_cd", "anFomCd");
		this.hashFields.put("rd_prt_flg", "rdPrtFlg");
		this.hashFields.put("eml_snd_flg5", "emlSndFlg5");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("eml_snd_flg4", "emlSndFlg4");
		this.hashFields.put("rvis_flg", "rvisFlg");
		this.hashFields.put("eml_snd_flg1", "emlSndFlg1");
		this.hashFields.put("eml_snd_flg3", "emlSndFlg3");
		this.hashFields.put("eml_snd_flg2", "emlSndFlg2");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_key", "fileKey");
		this.hashFields.put("locl_lang_flg", "loclLangFlg");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("eml_evnt_flg1", "emlEvntFlg1");
		this.hashFields.put("eml_evnt_flg5", "emlEvntFlg5");
		this.hashFields.put("fax_ntc_snd_rslt_cd3", "faxNtcSndRsltCd3");
		this.hashFields.put("eml_evnt_flg4", "emlEvntFlg4");
		this.hashFields.put("fax_ntc_snd_rslt_cd4", "faxNtcSndRsltCd4");
		this.hashFields.put("eml_evnt_flg3", "emlEvntFlg3");
		this.hashFields.put("fax_ntc_snd_rslt_cd5", "faxNtcSndRsltCd5");
		this.hashFields.put("eml_evnt_flg2", "emlEvntFlg2");
		this.hashFields.put("fax_ntc_snd_rslt_cd2", "faxNtcSndRsltCd2");
		this.hashFields.put("fax_ntc_snd_rslt_cd1", "faxNtcSndRsltCd1");
		this.hashFields.put("ntc_eml1", "ntcEml1");
		this.hashFields.put("ntc_eml2", "ntcEml2");
		this.hashFields.put("ntc_eml3", "ntcEml3");
		this.hashFields.put("ntc_eml4", "ntcEml4");
		this.hashFields.put("ntc_eml5", "ntcEml5");
		this.hashFields.put("chk_fax", "chkFax");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("an_sent", "anSent");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("is_validated", "isValidated");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("chg_dp_flg", "chgDpFlg");
		this.hashFields.put("mrd_id", "mrdId");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("show_pu_flg", "showPuFlg");
		
		
		return this.hashFields;
	}
	
	
	/**
	 * Column Info
	 * @return showPuFlg
	 */
	public String getShowPuFlg() {
		return this.showPuFlg;
	}

	
	/**
	 * Column Info
	 * @return faxNo1
	 */
	public String getFaxNo1() {
		return this.faxNo1;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm2
	 */
	public String getFaxNtcSndRsltNm2() {
		return this.faxNtcSndRsltNm2;
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
	 * @return faxNtcSndRsltNm1
	 */
	public String getFaxNtcSndRsltNm1() {
		return this.faxNtcSndRsltNm1;
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
	 * @return faxNtcSndRsltNm4
	 */
	public String getFaxNtcSndRsltNm4() {
		return this.faxNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm3
	 */
	public String getFaxNtcSndRsltNm3() {
		return this.faxNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return faxNo5
	 */
	public String getFaxNo5() {
		return this.faxNo5;
	}
	
	/**
	 * Column Info
	 * @return faxNo4
	 */
	public String getFaxNo4() {
		return this.faxNo4;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm5
	 */
	public String getFaxNtcSndRsltNm5() {
		return this.faxNtcSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}
	
	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg3
	 */
	public String getFaxSndFlg3() {
		return this.faxSndFlg3;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg4
	 */
	public String getFaxSndFlg4() {
		return this.faxSndFlg4;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg1
	 */
	public String getFaxSndFlg1() {
		return this.faxSndFlg1;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg2
	 */
	public String getFaxSndFlg2() {
		return this.faxSndFlg2;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd1
	 */
	public String getEmlNtcSndRsltCd1() {
		return this.emlNtcSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd2
	 */
	public String getEmlNtcSndRsltCd2() {
		return this.emlNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd3
	 */
	public String getEmlNtcSndRsltCd3() {
		return this.emlNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd4
	 */
	public String getEmlNtcSndRsltCd4() {
		return this.emlNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd5
	 */
	public String getEmlNtcSndRsltCd5() {
		return this.emlNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return chkEmail
	 */
	public String getChkEmail() {
		return this.chkEmail;
	}
	
	/**
	 * Column Info
	 * @return faxEvntFlg2
	 */
	public String getFaxEvntFlg2() {
		return this.faxEvntFlg2;
	}
	
	/**
	 * Column Info
	 * @return faxEvntFlg1
	 */
	public String getFaxEvntFlg1() {
		return this.faxEvntFlg1;
	}
	
	/**
	 * Column Info
	 * @return faxEvntFlg4
	 */
	public String getFaxEvntFlg4() {
		return this.faxEvntFlg4;
	}
	
	/**
	 * Column Info
	 * @return faxEvntFlg3
	 */
	public String getFaxEvntFlg3() {
		return this.faxEvntFlg3;
	}
	
	/**
	 * Column Info
	 * @return isHold
	 */
	public String getIsHold() {
		return this.isHold;
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
	 * @return emlNtcSndRsltNm4
	 */
	public String getEmlNtcSndRsltNm4() {
		return this.emlNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return comParam
	 */
	public String getComParam() {
		return this.comParam;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm5
	 */
	public String getEmlNtcSndRsltNm5() {
		return this.emlNtcSndRsltNm5;
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
	 * @return eclzBlCpyFlg
	 */
	public String getEclzBlCpyFlg() {
		return this.eclzBlCpyFlg;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm1
	 */
	public String getEmlNtcSndRsltNm1() {
		return this.emlNtcSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @return faxEvntFlg5
	 */
	public String getFaxEvntFlg5() {
		return this.faxEvntFlg5;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm2
	 */
	public String getEmlNtcSndRsltNm2() {
		return this.emlNtcSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm3
	 */
	public String getEmlNtcSndRsltNm3() {
		return this.emlNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return arrPrvFomCd
	 */
	public String getArrPrvFomCd() {
		return this.arrPrvFomCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return faxSndFlg5
	 */
	public String getFaxSndFlg5() {
		return this.faxSndFlg5;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return anFomCd
	 */
	public String getAnFomCd() {
		return this.anFomCd;
	}
	
	/**
	 * Column Info
	 * @return rdPrtFlg
	 */
	public String getRdPrtFlg() {
		return this.rdPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg5
	 */
	public String getEmlSndFlg5() {
		return this.emlSndFlg5;
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
	 * @return emlSndFlg4
	 */
	public String getEmlSndFlg4() {
		return this.emlSndFlg4;
	}
	
	/**
	 * Column Info
	 * @return rvisFlg
	 */
	public String getRvisFlg() {
		return this.rvisFlg;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg1
	 */
	public String getEmlSndFlg1() {
		return this.emlSndFlg1;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg3
	 */
	public String getEmlSndFlg3() {
		return this.emlSndFlg3;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg2
	 */
	public String getEmlSndFlg2() {
		return this.emlSndFlg2;
	}
	
	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
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
	 * @return loclLangFlg
	 */
	public String getLoclLangFlg() {
		return this.loclLangFlg;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @return emlEvntFlg1
	 */
	public String getEmlEvntFlg1() {
		return this.emlEvntFlg1;
	}
	
	/**
	 * Column Info
	 * @return emlEvntFlg5
	 */
	public String getEmlEvntFlg5() {
		return this.emlEvntFlg5;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd3
	 */
	public String getFaxNtcSndRsltCd3() {
		return this.faxNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return emlEvntFlg4
	 */
	public String getEmlEvntFlg4() {
		return this.emlEvntFlg4;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd4
	 */
	public String getFaxNtcSndRsltCd4() {
		return this.faxNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return emlEvntFlg3
	 */
	public String getEmlEvntFlg3() {
		return this.emlEvntFlg3;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd5
	 */
	public String getFaxNtcSndRsltCd5() {
		return this.faxNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @return emlEvntFlg2
	 */
	public String getEmlEvntFlg2() {
		return this.emlEvntFlg2;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd2
	 */
	public String getFaxNtcSndRsltCd2() {
		return this.faxNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd1
	 */
	public String getFaxNtcSndRsltCd1() {
		return this.faxNtcSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml1
	 */
	public String getNtcEml1() {
		return this.ntcEml1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml2
	 */
	public String getNtcEml2() {
		return this.ntcEml2;
	}
	
	/**
	 * Column Info
	 * @return ntcEml3
	 */
	public String getNtcEml3() {
		return this.ntcEml3;
	}
	
	/**
	 * Column Info
	 * @return ntcEml4
	 */
	public String getNtcEml4() {
		return this.ntcEml4;
	}
	
	/**
	 * Column Info
	 * @return ntcEml5
	 */
	public String getNtcEml5() {
		return this.ntcEml5;
	}
	
	/**
	 * Column Info
	 * @return chkFax
	 */
	public String getChkFax() {
		return this.chkFax;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return anSent
	 */
	public String getAnSent() {
		return this.anSent;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return isValidated
	 */
	public String getIsValidated() {
		return this.isValidated;
	}
	
	/**
	 * Column Info
	 * @return faxSndDt
	 */
	public String getFaxSndDt() {
		return this.faxSndDt;
	}
	
	/**
	 * Column Info
	 * @return chgDpFlg
	 */
	public String getChgDpFlg() {
		return this.chgDpFlg;
	}
	
	/**
	 * Column Info
	 * @return mrdId
	 */
	public String getMrdId() {
		return this.mrdId;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	

	/**
	 * Column Info
	 * @param faxNo1
	 */
	public void setShowPuFlg(String showPuFlg) {
		this.showPuFlg = showPuFlg;
	}

	/**
	 * Column Info
	 * @param faxNo1
	 */
	public void setFaxNo1(String faxNo1) {
		this.faxNo1 = faxNo1;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm2
	 */
	public void setFaxNtcSndRsltNm2(String faxNtcSndRsltNm2) {
		this.faxNtcSndRsltNm2 = faxNtcSndRsltNm2;
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
	 * @param faxNtcSndRsltNm1
	 */
	public void setFaxNtcSndRsltNm1(String faxNtcSndRsltNm1) {
		this.faxNtcSndRsltNm1 = faxNtcSndRsltNm1;
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
	 * @param faxNtcSndRsltNm4
	 */
	public void setFaxNtcSndRsltNm4(String faxNtcSndRsltNm4) {
		this.faxNtcSndRsltNm4 = faxNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm3
	 */
	public void setFaxNtcSndRsltNm3(String faxNtcSndRsltNm3) {
		this.faxNtcSndRsltNm3 = faxNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param faxNo5
	 */
	public void setFaxNo5(String faxNo5) {
		this.faxNo5 = faxNo5;
	}
	
	/**
	 * Column Info
	 * @param faxNo4
	 */
	public void setFaxNo4(String faxNo4) {
		this.faxNo4 = faxNo4;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm5
	 */
	public void setFaxNtcSndRsltNm5(String faxNtcSndRsltNm5) {
		this.faxNtcSndRsltNm5 = faxNtcSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}
	
	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg3
	 */
	public void setFaxSndFlg3(String faxSndFlg3) {
		this.faxSndFlg3 = faxSndFlg3;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg4
	 */
	public void setFaxSndFlg4(String faxSndFlg4) {
		this.faxSndFlg4 = faxSndFlg4;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg1
	 */
	public void setFaxSndFlg1(String faxSndFlg1) {
		this.faxSndFlg1 = faxSndFlg1;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg2
	 */
	public void setFaxSndFlg2(String faxSndFlg2) {
		this.faxSndFlg2 = faxSndFlg2;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd1
	 */
	public void setEmlNtcSndRsltCd1(String emlNtcSndRsltCd1) {
		this.emlNtcSndRsltCd1 = emlNtcSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd2
	 */
	public void setEmlNtcSndRsltCd2(String emlNtcSndRsltCd2) {
		this.emlNtcSndRsltCd2 = emlNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd3
	 */
	public void setEmlNtcSndRsltCd3(String emlNtcSndRsltCd3) {
		this.emlNtcSndRsltCd3 = emlNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd4
	 */
	public void setEmlNtcSndRsltCd4(String emlNtcSndRsltCd4) {
		this.emlNtcSndRsltCd4 = emlNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd5
	 */
	public void setEmlNtcSndRsltCd5(String emlNtcSndRsltCd5) {
		this.emlNtcSndRsltCd5 = emlNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param chkEmail
	 */
	public void setChkEmail(String chkEmail) {
		this.chkEmail = chkEmail;
	}
	
	/**
	 * Column Info
	 * @param faxEvntFlg2
	 */
	public void setFaxEvntFlg2(String faxEvntFlg2) {
		this.faxEvntFlg2 = faxEvntFlg2;
	}
	
	/**
	 * Column Info
	 * @param faxEvntFlg1
	 */
	public void setFaxEvntFlg1(String faxEvntFlg1) {
		this.faxEvntFlg1 = faxEvntFlg1;
	}
	
	/**
	 * Column Info
	 * @param faxEvntFlg4
	 */
	public void setFaxEvntFlg4(String faxEvntFlg4) {
		this.faxEvntFlg4 = faxEvntFlg4;
	}
	
	/**
	 * Column Info
	 * @param faxEvntFlg3
	 */
	public void setFaxEvntFlg3(String faxEvntFlg3) {
		this.faxEvntFlg3 = faxEvntFlg3;
	}
	
	/**
	 * Column Info
	 * @param isHold
	 */
	public void setIsHold(String isHold) {
		this.isHold = isHold;
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
	 * @param emlNtcSndRsltNm4
	 */
	public void setEmlNtcSndRsltNm4(String emlNtcSndRsltNm4) {
		this.emlNtcSndRsltNm4 = emlNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param comParam
	 */
	public void setComParam(String comParam) {
		this.comParam = comParam;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm5
	 */
	public void setEmlNtcSndRsltNm5(String emlNtcSndRsltNm5) {
		this.emlNtcSndRsltNm5 = emlNtcSndRsltNm5;
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
	 * @param eclzBlCpyFlg
	 */
	public void setEclzBlCpyFlg(String eclzBlCpyFlg) {
		this.eclzBlCpyFlg = eclzBlCpyFlg;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm1
	 */
	public void setEmlNtcSndRsltNm1(String emlNtcSndRsltNm1) {
		this.emlNtcSndRsltNm1 = emlNtcSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @param faxEvntFlg5
	 */
	public void setFaxEvntFlg5(String faxEvntFlg5) {
		this.faxEvntFlg5 = faxEvntFlg5;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm2
	 */
	public void setEmlNtcSndRsltNm2(String emlNtcSndRsltNm2) {
		this.emlNtcSndRsltNm2 = emlNtcSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm3
	 */
	public void setEmlNtcSndRsltNm3(String emlNtcSndRsltNm3) {
		this.emlNtcSndRsltNm3 = emlNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param arrPrvFomCd
	 */
	public void setArrPrvFomCd(String arrPrvFomCd) {
		this.arrPrvFomCd = arrPrvFomCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param faxSndFlg5
	 */
	public void setFaxSndFlg5(String faxSndFlg5) {
		this.faxSndFlg5 = faxSndFlg5;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param anFomCd
	 */
	public void setAnFomCd(String anFomCd) {
		this.anFomCd = anFomCd;
	}
	
	/**
	 * Column Info
	 * @param rdPrtFlg
	 */
	public void setRdPrtFlg(String rdPrtFlg) {
		this.rdPrtFlg = rdPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg5
	 */
	public void setEmlSndFlg5(String emlSndFlg5) {
		this.emlSndFlg5 = emlSndFlg5;
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
	 * @param emlSndFlg4
	 */
	public void setEmlSndFlg4(String emlSndFlg4) {
		this.emlSndFlg4 = emlSndFlg4;
	}
	
	/**
	 * Column Info
	 * @param rvisFlg
	 */
	public void setRvisFlg(String rvisFlg) {
		this.rvisFlg = rvisFlg;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg1
	 */
	public void setEmlSndFlg1(String emlSndFlg1) {
		this.emlSndFlg1 = emlSndFlg1;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg3
	 */
	public void setEmlSndFlg3(String emlSndFlg3) {
		this.emlSndFlg3 = emlSndFlg3;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg2
	 */
	public void setEmlSndFlg2(String emlSndFlg2) {
		this.emlSndFlg2 = emlSndFlg2;
	}
	
	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
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
	 * @param loclLangFlg
	 */
	public void setLoclLangFlg(String loclLangFlg) {
		this.loclLangFlg = loclLangFlg;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @param emlEvntFlg1
	 */
	public void setEmlEvntFlg1(String emlEvntFlg1) {
		this.emlEvntFlg1 = emlEvntFlg1;
	}
	
	/**
	 * Column Info
	 * @param emlEvntFlg5
	 */
	public void setEmlEvntFlg5(String emlEvntFlg5) {
		this.emlEvntFlg5 = emlEvntFlg5;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd3
	 */
	public void setFaxNtcSndRsltCd3(String faxNtcSndRsltCd3) {
		this.faxNtcSndRsltCd3 = faxNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param emlEvntFlg4
	 */
	public void setEmlEvntFlg4(String emlEvntFlg4) {
		this.emlEvntFlg4 = emlEvntFlg4;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd4
	 */
	public void setFaxNtcSndRsltCd4(String faxNtcSndRsltCd4) {
		this.faxNtcSndRsltCd4 = faxNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param emlEvntFlg3
	 */
	public void setEmlEvntFlg3(String emlEvntFlg3) {
		this.emlEvntFlg3 = emlEvntFlg3;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd5
	 */
	public void setFaxNtcSndRsltCd5(String faxNtcSndRsltCd5) {
		this.faxNtcSndRsltCd5 = faxNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @param emlEvntFlg2
	 */
	public void setEmlEvntFlg2(String emlEvntFlg2) {
		this.emlEvntFlg2 = emlEvntFlg2;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd2
	 */
	public void setFaxNtcSndRsltCd2(String faxNtcSndRsltCd2) {
		this.faxNtcSndRsltCd2 = faxNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd1
	 */
	public void setFaxNtcSndRsltCd1(String faxNtcSndRsltCd1) {
		this.faxNtcSndRsltCd1 = faxNtcSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml1
	 */
	public void setNtcEml1(String ntcEml1) {
		this.ntcEml1 = ntcEml1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml2
	 */
	public void setNtcEml2(String ntcEml2) {
		this.ntcEml2 = ntcEml2;
	}
	
	/**
	 * Column Info
	 * @param ntcEml3
	 */
	public void setNtcEml3(String ntcEml3) {
		this.ntcEml3 = ntcEml3;
	}
	
	/**
	 * Column Info
	 * @param ntcEml4
	 */
	public void setNtcEml4(String ntcEml4) {
		this.ntcEml4 = ntcEml4;
	}
	
	/**
	 * Column Info
	 * @param ntcEml5
	 */
	public void setNtcEml5(String ntcEml5) {
		this.ntcEml5 = ntcEml5;
	}
	
	/**
	 * Column Info
	 * @param chkFax
	 */
	public void setChkFax(String chkFax) {
		this.chkFax = chkFax;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param anSent
	 */
	public void setAnSent(String anSent) {
		this.anSent = anSent;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param isValidated
	 */
	public void setIsValidated(String isValidated) {
		this.isValidated = isValidated;
	}
	
	/**
	 * Column Info
	 * @param faxSndDt
	 */
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
	}
	
	/**
	 * Column Info
	 * @param chgDpFlg
	 */
	public void setChgDpFlg(String chgDpFlg) {
		this.chgDpFlg = chgDpFlg;
	}
	
	/**
	 * Column Info
	 * @param mrdId
	 */
	public void setMrdId(String mrdId) {
		this.mrdId = mrdId;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setFaxNo1(JSPUtil.getParameter(request, prefix + "fax_no1", ""));
		setFaxNtcSndRsltNm2(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_nm2", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFaxNtcSndRsltNm1(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_nm1", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setFaxNtcSndRsltNm4(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_nm4", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setFaxNtcSndRsltNm3(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_nm3", ""));
		setFaxNo5(JSPUtil.getParameter(request, prefix + "fax_no5", ""));
		setFaxNo4(JSPUtil.getParameter(request, prefix + "fax_no4", ""));
		setFaxNtcSndRsltNm5(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_nm5", ""));
		setFaxNo3(JSPUtil.getParameter(request, prefix + "fax_no3", ""));
		setFaxNo2(JSPUtil.getParameter(request, prefix + "fax_no2", ""));
		setFaxSndFlg3(JSPUtil.getParameter(request, prefix + "fax_snd_flg3", ""));
		setFaxSndFlg4(JSPUtil.getParameter(request, prefix + "fax_snd_flg4", ""));
		setFaxSndFlg1(JSPUtil.getParameter(request, prefix + "fax_snd_flg1", ""));
		setFaxSndFlg2(JSPUtil.getParameter(request, prefix + "fax_snd_flg2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setEmlNtcSndRsltCd1(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_cd1", ""));
		setEmlNtcSndRsltCd2(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_cd2", ""));
		setEmlNtcSndRsltCd3(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_cd3", ""));
		setEmlNtcSndRsltCd4(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_cd4", ""));
		setEmlNtcSndRsltCd5(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_cd5", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setChkEmail(JSPUtil.getParameter(request, prefix + "chk_email", ""));
		setFaxEvntFlg2(JSPUtil.getParameter(request, prefix + "fax_evnt_flg2", ""));
		setFaxEvntFlg1(JSPUtil.getParameter(request, prefix + "fax_evnt_flg1", ""));
		setFaxEvntFlg4(JSPUtil.getParameter(request, prefix + "fax_evnt_flg4", ""));
		setFaxEvntFlg3(JSPUtil.getParameter(request, prefix + "fax_evnt_flg3", ""));
		setIsHold(JSPUtil.getParameter(request, prefix + "is_hold", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setEmlNtcSndRsltNm4(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_nm4", ""));
		setComParam(JSPUtil.getParameter(request, prefix + "com_param", ""));
		setEmlNtcSndRsltNm5(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_nm5", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEclzBlCpyFlg(JSPUtil.getParameter(request, prefix + "eclz_bl_cpy_flg", ""));
		setEmlNtcSndRsltNm1(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_nm1", ""));
		setFaxEvntFlg5(JSPUtil.getParameter(request, prefix + "fax_evnt_flg5", ""));
		setEmlNtcSndRsltNm2(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_nm2", ""));
		setEmlNtcSndRsltNm3(JSPUtil.getParameter(request, prefix + "eml_ntc_snd_rslt_nm3", ""));
		setArrPrvFomCd(JSPUtil.getParameter(request, prefix + "arr_prv_fom_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFaxSndFlg5(JSPUtil.getParameter(request, prefix + "fax_snd_flg5", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setAnFomCd(JSPUtil.getParameter(request, prefix + "an_fom_cd", ""));
		setRdPrtFlg(JSPUtil.getParameter(request, prefix + "rd_prt_flg", ""));
		setEmlSndFlg5(JSPUtil.getParameter(request, prefix + "eml_snd_flg5", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setEmlSndFlg4(JSPUtil.getParameter(request, prefix + "eml_snd_flg4", ""));
		setRvisFlg(JSPUtil.getParameter(request, prefix + "rvis_flg", ""));
		setEmlSndFlg1(JSPUtil.getParameter(request, prefix + "eml_snd_flg1", ""));
		setEmlSndFlg3(JSPUtil.getParameter(request, prefix + "eml_snd_flg3", ""));
		setEmlSndFlg2(JSPUtil.getParameter(request, prefix + "eml_snd_flg2", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileKey(JSPUtil.getParameter(request, prefix + "file_key", ""));
		setLoclLangFlg(JSPUtil.getParameter(request, prefix + "locl_lang_flg", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd", ""));
		setEmlEvntFlg1(JSPUtil.getParameter(request, prefix + "eml_evnt_flg1", ""));
		setEmlEvntFlg5(JSPUtil.getParameter(request, prefix + "eml_evnt_flg5", ""));
		setFaxNtcSndRsltCd3(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_cd3", ""));
		setEmlEvntFlg4(JSPUtil.getParameter(request, prefix + "eml_evnt_flg4", ""));
		setFaxNtcSndRsltCd4(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_cd4", ""));
		setEmlEvntFlg3(JSPUtil.getParameter(request, prefix + "eml_evnt_flg3", ""));
		setFaxNtcSndRsltCd5(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_cd5", ""));
		setEmlEvntFlg2(JSPUtil.getParameter(request, prefix + "eml_evnt_flg2", ""));
		setFaxNtcSndRsltCd2(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_cd2", ""));
		setFaxNtcSndRsltCd1(JSPUtil.getParameter(request, prefix + "fax_ntc_snd_rslt_cd1", ""));
		setNtcEml1(JSPUtil.getParameter(request, prefix + "ntc_eml1", ""));
		setNtcEml2(JSPUtil.getParameter(request, prefix + "ntc_eml2", ""));
		setNtcEml3(JSPUtil.getParameter(request, prefix + "ntc_eml3", ""));
		setNtcEml4(JSPUtil.getParameter(request, prefix + "ntc_eml4", ""));
		setNtcEml5(JSPUtil.getParameter(request, prefix + "ntc_eml5", ""));
		setChkFax(JSPUtil.getParameter(request, prefix + "chk_fax", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setAnSent(JSPUtil.getParameter(request, prefix + "an_sent", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setIsValidated(JSPUtil.getParameter(request, prefix + "is_validated", ""));
		setFaxSndDt(JSPUtil.getParameter(request, prefix + "fax_snd_dt", ""));
		setChgDpFlg(JSPUtil.getParameter(request, prefix + "chg_dp_flg", ""));
		setMrdId(JSPUtil.getParameter(request, prefix + "mrd_id", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setShowPuFlg(JSPUtil.getParameter(request, prefix + "show_pu_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcSendListVO[]
	 */
	public ArrNtcSendListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcSendListVO[]
	 */
	public ArrNtcSendListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcSendListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faxNo1 = (JSPUtil.getParameter(request, prefix	+ "fax_no1", length));
			String[] faxNtcSndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm2", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] faxNtcSndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm1", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] faxNtcSndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm4", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] faxNtcSndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm3", length));
			String[] faxNo5 = (JSPUtil.getParameter(request, prefix	+ "fax_no5", length));
			String[] faxNo4 = (JSPUtil.getParameter(request, prefix	+ "fax_no4", length));
			String[] faxNtcSndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm5", length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3", length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2", length));
			String[] faxSndFlg3 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg3", length));
			String[] faxSndFlg4 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg4", length));
			String[] faxSndFlg1 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg1", length));
			String[] faxSndFlg2 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] emlNtcSndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd1", length));
			String[] emlNtcSndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd2", length));
			String[] emlNtcSndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd3", length));
			String[] emlNtcSndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd4", length));
			String[] emlNtcSndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd5", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] chkEmail = (JSPUtil.getParameter(request, prefix	+ "chk_email", length));
			String[] faxEvntFlg2 = (JSPUtil.getParameter(request, prefix	+ "fax_evnt_flg2", length));
			String[] faxEvntFlg1 = (JSPUtil.getParameter(request, prefix	+ "fax_evnt_flg1", length));
			String[] faxEvntFlg4 = (JSPUtil.getParameter(request, prefix	+ "fax_evnt_flg4", length));
			String[] faxEvntFlg3 = (JSPUtil.getParameter(request, prefix	+ "fax_evnt_flg3", length));
			String[] isHold = (JSPUtil.getParameter(request, prefix	+ "is_hold", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] emlNtcSndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm4", length));
			String[] comParam = (JSPUtil.getParameter(request, prefix	+ "com_param", length));
			String[] emlNtcSndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm5", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] eclzBlCpyFlg = (JSPUtil.getParameter(request, prefix	+ "eclz_bl_cpy_flg", length));
			String[] emlNtcSndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm1", length));
			String[] faxEvntFlg5 = (JSPUtil.getParameter(request, prefix	+ "fax_evnt_flg5", length));
			String[] emlNtcSndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm2", length));
			String[] emlNtcSndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm3", length));
			String[] arrPrvFomCd = (JSPUtil.getParameter(request, prefix	+ "arr_prv_fom_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] faxSndFlg5 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg5", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] anFomCd = (JSPUtil.getParameter(request, prefix	+ "an_fom_cd", length));
			String[] rdPrtFlg = (JSPUtil.getParameter(request, prefix	+ "rd_prt_flg", length));
			String[] emlSndFlg5 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg5", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] emlSndFlg4 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg4", length));
			String[] rvisFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_flg", length));
			String[] emlSndFlg1 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg1", length));
			String[] emlSndFlg3 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg3", length));
			String[] emlSndFlg2 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg2", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileKey = (JSPUtil.getParameter(request, prefix	+ "file_key", length));
			String[] loclLangFlg = (JSPUtil.getParameter(request, prefix	+ "locl_lang_flg", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] emlEvntFlg1 = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_flg1", length));
			String[] emlEvntFlg5 = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_flg5", length));
			String[] faxNtcSndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd3", length));
			String[] emlEvntFlg4 = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_flg4", length));
			String[] faxNtcSndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd4", length));
			String[] emlEvntFlg3 = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_flg3", length));
			String[] faxNtcSndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd5", length));
			String[] emlEvntFlg2 = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_flg2", length));
			String[] faxNtcSndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd2", length));
			String[] faxNtcSndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd1", length));
			String[] ntcEml1 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml1", length));
			String[] ntcEml2 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml2", length));
			String[] ntcEml3 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml3", length));
			String[] ntcEml4 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml4", length));
			String[] ntcEml5 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml5", length));
			String[] chkFax = (JSPUtil.getParameter(request, prefix	+ "chk_fax", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] anSent = (JSPUtil.getParameter(request, prefix	+ "an_sent", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] isValidated = (JSPUtil.getParameter(request, prefix	+ "is_validated", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] chgDpFlg = (JSPUtil.getParameter(request, prefix	+ "chg_dp_flg", length));
			String[] mrdId = (JSPUtil.getParameter(request, prefix	+ "mrd_id", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] showPuFlg = (JSPUtil.getParameter(request, prefix	+ "show_pu_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcSendListVO();
				if (faxNo1[i] != null)
					model.setFaxNo1(faxNo1[i]);
				if (faxNtcSndRsltNm2[i] != null)
					model.setFaxNtcSndRsltNm2(faxNtcSndRsltNm2[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (faxNtcSndRsltNm1[i] != null)
					model.setFaxNtcSndRsltNm1(faxNtcSndRsltNm1[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (faxNtcSndRsltNm4[i] != null)
					model.setFaxNtcSndRsltNm4(faxNtcSndRsltNm4[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (faxNtcSndRsltNm3[i] != null)
					model.setFaxNtcSndRsltNm3(faxNtcSndRsltNm3[i]);
				if (faxNo5[i] != null)
					model.setFaxNo5(faxNo5[i]);
				if (faxNo4[i] != null)
					model.setFaxNo4(faxNo4[i]);
				if (faxNtcSndRsltNm5[i] != null)
					model.setFaxNtcSndRsltNm5(faxNtcSndRsltNm5[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (faxSndFlg3[i] != null)
					model.setFaxSndFlg3(faxSndFlg3[i]);
				if (faxSndFlg4[i] != null)
					model.setFaxSndFlg4(faxSndFlg4[i]);
				if (faxSndFlg1[i] != null)
					model.setFaxSndFlg1(faxSndFlg1[i]);
				if (faxSndFlg2[i] != null)
					model.setFaxSndFlg2(faxSndFlg2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (emlNtcSndRsltCd1[i] != null)
					model.setEmlNtcSndRsltCd1(emlNtcSndRsltCd1[i]);
				if (emlNtcSndRsltCd2[i] != null)
					model.setEmlNtcSndRsltCd2(emlNtcSndRsltCd2[i]);
				if (emlNtcSndRsltCd3[i] != null)
					model.setEmlNtcSndRsltCd3(emlNtcSndRsltCd3[i]);
				if (emlNtcSndRsltCd4[i] != null)
					model.setEmlNtcSndRsltCd4(emlNtcSndRsltCd4[i]);
				if (emlNtcSndRsltCd5[i] != null)
					model.setEmlNtcSndRsltCd5(emlNtcSndRsltCd5[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (chkEmail[i] != null)
					model.setChkEmail(chkEmail[i]);
				if (faxEvntFlg2[i] != null)
					model.setFaxEvntFlg2(faxEvntFlg2[i]);
				if (faxEvntFlg1[i] != null)
					model.setFaxEvntFlg1(faxEvntFlg1[i]);
				if (faxEvntFlg4[i] != null)
					model.setFaxEvntFlg4(faxEvntFlg4[i]);
				if (faxEvntFlg3[i] != null)
					model.setFaxEvntFlg3(faxEvntFlg3[i]);
				if (isHold[i] != null)
					model.setIsHold(isHold[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (emlNtcSndRsltNm4[i] != null)
					model.setEmlNtcSndRsltNm4(emlNtcSndRsltNm4[i]);
				if (comParam[i] != null)
					model.setComParam(comParam[i]);
				if (emlNtcSndRsltNm5[i] != null)
					model.setEmlNtcSndRsltNm5(emlNtcSndRsltNm5[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (eclzBlCpyFlg[i] != null)
					model.setEclzBlCpyFlg(eclzBlCpyFlg[i]);
				if (emlNtcSndRsltNm1[i] != null)
					model.setEmlNtcSndRsltNm1(emlNtcSndRsltNm1[i]);
				if (faxEvntFlg5[i] != null)
					model.setFaxEvntFlg5(faxEvntFlg5[i]);
				if (emlNtcSndRsltNm2[i] != null)
					model.setEmlNtcSndRsltNm2(emlNtcSndRsltNm2[i]);
				if (emlNtcSndRsltNm3[i] != null)
					model.setEmlNtcSndRsltNm3(emlNtcSndRsltNm3[i]);
				if (arrPrvFomCd[i] != null)
					model.setArrPrvFomCd(arrPrvFomCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (faxSndFlg5[i] != null)
					model.setFaxSndFlg5(faxSndFlg5[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (anFomCd[i] != null)
					model.setAnFomCd(anFomCd[i]);
				if (rdPrtFlg[i] != null)
					model.setRdPrtFlg(rdPrtFlg[i]);
				if (emlSndFlg5[i] != null)
					model.setEmlSndFlg5(emlSndFlg5[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (emlSndFlg4[i] != null)
					model.setEmlSndFlg4(emlSndFlg4[i]);
				if (rvisFlg[i] != null)
					model.setRvisFlg(rvisFlg[i]);
				if (emlSndFlg1[i] != null)
					model.setEmlSndFlg1(emlSndFlg1[i]);
				if (emlSndFlg3[i] != null)
					model.setEmlSndFlg3(emlSndFlg3[i]);
				if (emlSndFlg2[i] != null)
					model.setEmlSndFlg2(emlSndFlg2[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileKey[i] != null)
					model.setFileKey(fileKey[i]);
				if (loclLangFlg[i] != null)
					model.setLoclLangFlg(loclLangFlg[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (emlEvntFlg1[i] != null)
					model.setEmlEvntFlg1(emlEvntFlg1[i]);
				if (emlEvntFlg5[i] != null)
					model.setEmlEvntFlg5(emlEvntFlg5[i]);
				if (faxNtcSndRsltCd3[i] != null)
					model.setFaxNtcSndRsltCd3(faxNtcSndRsltCd3[i]);
				if (emlEvntFlg4[i] != null)
					model.setEmlEvntFlg4(emlEvntFlg4[i]);
				if (faxNtcSndRsltCd4[i] != null)
					model.setFaxNtcSndRsltCd4(faxNtcSndRsltCd4[i]);
				if (emlEvntFlg3[i] != null)
					model.setEmlEvntFlg3(emlEvntFlg3[i]);
				if (faxNtcSndRsltCd5[i] != null)
					model.setFaxNtcSndRsltCd5(faxNtcSndRsltCd5[i]);
				if (emlEvntFlg2[i] != null)
					model.setEmlEvntFlg2(emlEvntFlg2[i]);
				if (faxNtcSndRsltCd2[i] != null)
					model.setFaxNtcSndRsltCd2(faxNtcSndRsltCd2[i]);
				if (faxNtcSndRsltCd1[i] != null)
					model.setFaxNtcSndRsltCd1(faxNtcSndRsltCd1[i]);
				if (ntcEml1[i] != null)
					model.setNtcEml1(ntcEml1[i]);
				if (ntcEml2[i] != null)
					model.setNtcEml2(ntcEml2[i]);
				if (ntcEml3[i] != null)
					model.setNtcEml3(ntcEml3[i]);
				if (ntcEml4[i] != null)
					model.setNtcEml4(ntcEml4[i]);
				if (ntcEml5[i] != null)
					model.setNtcEml5(ntcEml5[i]);
				if (chkFax[i] != null)
					model.setChkFax(chkFax[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (anSent[i] != null)
					model.setAnSent(anSent[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (isValidated[i] != null)
					model.setIsValidated(isValidated[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (chgDpFlg[i] != null)
					model.setChgDpFlg(chgDpFlg[i]);
				if (mrdId[i] != null)
					model.setMrdId(mrdId[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (showPuFlg[i] != null)
					model.setShowPuFlg(showPuFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcSendListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcSendListVO[]
	 */
	public ArrNtcSendListVO[] getArrNtcSendListVOs(){
		ArrNtcSendListVO[] vos = (ArrNtcSendListVO[])models.toArray(new ArrNtcSendListVO[models.size()]);
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
		this.faxNo1 = this.faxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm2 = this.faxNtcSndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm1 = this.faxNtcSndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm4 = this.faxNtcSndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm3 = this.faxNtcSndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo5 = this.faxNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo4 = this.faxNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm5 = this.faxNtcSndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg3 = this.faxSndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg4 = this.faxSndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg1 = this.faxSndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg2 = this.faxSndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd1 = this.emlNtcSndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd2 = this.emlNtcSndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd3 = this.emlNtcSndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd4 = this.emlNtcSndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd5 = this.emlNtcSndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkEmail = this.chkEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEvntFlg2 = this.faxEvntFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEvntFlg1 = this.faxEvntFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEvntFlg4 = this.faxEvntFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEvntFlg3 = this.faxEvntFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isHold = this.isHold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm4 = this.emlNtcSndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comParam = this.comParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm5 = this.emlNtcSndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eclzBlCpyFlg = this.eclzBlCpyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm1 = this.emlNtcSndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEvntFlg5 = this.faxEvntFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm2 = this.emlNtcSndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm3 = this.emlNtcSndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrPrvFomCd = this.arrPrvFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg5 = this.faxSndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFomCd = this.anFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdPrtFlg = this.rdPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg5 = this.emlSndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg4 = this.emlSndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisFlg = this.rvisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg1 = this.emlSndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg3 = this.emlSndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg2 = this.emlSndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileKey = this.fileKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclLangFlg = this.loclLangFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntFlg1 = this.emlEvntFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntFlg5 = this.emlEvntFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd3 = this.faxNtcSndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntFlg4 = this.emlEvntFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd4 = this.faxNtcSndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntFlg3 = this.emlEvntFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd5 = this.faxNtcSndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntFlg2 = this.emlEvntFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd2 = this.faxNtcSndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd1 = this.faxNtcSndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml1 = this.ntcEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml2 = this.ntcEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml3 = this.ntcEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml4 = this.ntcEml4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml5 = this.ntcEml5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFax = this.chkFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anSent = this.anSent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidated = this.isValidated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDpFlg = this.chgDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdId = this.mrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.showPuFlg = this.showPuFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
