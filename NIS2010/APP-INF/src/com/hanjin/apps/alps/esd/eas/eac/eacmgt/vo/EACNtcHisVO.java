/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACNtcHisVO.java
*@FileTitle : EACNtcHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.06 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACNtcHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACNtcHisVO> models = new ArrayList<EACNtcHisVO>();
	
	/* Column Info */
	private String sSndToDt = null;
	/* Column Info */
	private String sSndRsltCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String sndTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String vndrCntcPntSeq = null;
	/* Column Info */
	private String ntcSndDt = null;
	/* Column Info */
	private String n3ptySrcDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rcvrFaxNo = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String sSndFmDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invAudAmt = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Column Info */
	private String vvdCdCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sSndTpCd = null;
	/* Column Info */
	private String ntcHisSeq = null;
	/* Column Info */
	private String invAudUsdAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String eacEmlUseFlg = null;
	/* Column Info */
	private String rcvrPhnNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String eacDesc = null;
	/* Column Info */
	private String emlStsNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eacFaxUseFlg = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String invCngAmt = null;
	/* Column Info */
	private String sEacYrmonFm = null;
	/* Column Info */
	private String sEacYrmonTo = null;
	/* Column Info */
	private String sndYn = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String eacExpnTpCd = null;
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String sEacRegUsrId = null;
	/* Column Info */
	private String faxStsNm = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String woNoCtnt = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACNtcHisVO() {}

	public EACNtcHisVO(String ibflag, String pagerows, String eacNo, String ntcHisSeq, String vndrCntcPntSeq, String emlSubjCtnt, String emlCtnt, String emlSndDt, String rcvrEml, String emlStsNm, String rcvrPhnNo, String rcvrFaxNo, String faxStsNm, String eacEmlUseFlg, String eacFaxUseFlg, String emlSndNo, String faxSndNo, String creUsrId, String creUsrNm, String creDt, String updUsrId, String updDt, String vndrSeq, String vndrNm, String sndTpCd, String ntcSndDt, String creOfcCd, String n3ptySrcNo, String n3ptySrcDt, String currCd, String invAmt, String invCngAmt, String invAudAmt, String invAudUsdAmt, String woNoCtnt, String vvdCdCtnt, String blNo, String eacExpnTpCd, String eacDesc, String fileSavId, String sEacYrmonFm, String sEacYrmonTo, String sRhqOfcCd, String sOfcCd, String sEacRegUsrId, String sSndTpCd, String sSndFmDt, String sSndToDt, String sVndrSeq, String sSndRsltCd, String sndYn) {
		this.sSndToDt = sSndToDt;
		this.sSndRsltCd = sSndRsltCd;
		this.emlSndDt = emlSndDt;
		this.sndTpCd = sndTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.vndrCntcPntSeq = vndrCntcPntSeq;
		this.ntcSndDt = ntcSndDt;
		this.n3ptySrcDt = n3ptySrcDt;
		this.updUsrId = updUsrId;
		this.rcvrFaxNo = rcvrFaxNo;
		this.sOfcCd = sOfcCd;
		this.creUsrNm = creUsrNm;
		this.sSndFmDt = sSndFmDt;
		this.creUsrId = creUsrId;
		this.rcvrEml = rcvrEml;
		this.vndrSeq = vndrSeq;
		this.invAudAmt = invAudAmt;
		this.faxSndNo = faxSndNo;
		this.sRhqOfcCd = sRhqOfcCd;
		this.currCd = currCd;
		this.creDt = creDt;
		this.emlCtnt = emlCtnt;
		this.vvdCdCtnt = vvdCdCtnt;
		this.ibflag = ibflag;
		this.sSndTpCd = sSndTpCd;
		this.ntcHisSeq = ntcHisSeq;
		this.invAudUsdAmt = invAudUsdAmt;
		this.creOfcCd = creOfcCd;
		this.eacEmlUseFlg = eacEmlUseFlg;
		this.rcvrPhnNo = rcvrPhnNo;
		this.invAmt = invAmt;
		this.eacDesc = eacDesc;
		this.emlStsNm = emlStsNm;
		this.updDt = updDt;
		this.eacFaxUseFlg = eacFaxUseFlg;
		this.fileSavId = fileSavId;
		this.invCngAmt = invCngAmt;
		this.sEacYrmonFm = sEacYrmonFm;
		this.sEacYrmonTo = sEacYrmonTo;
		this.sndYn = sndYn;
		this.sVndrSeq = sVndrSeq;
		this.emlSndNo = emlSndNo;
		this.eacExpnTpCd = eacExpnTpCd;
		this.eacNo = eacNo;
		this.sEacRegUsrId = sEacRegUsrId;
		this.faxStsNm = faxStsNm;
		this.emlSubjCtnt = emlSubjCtnt;
		this.woNoCtnt = woNoCtnt;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_snd_to_dt", getSSndToDt());
		this.hashColumns.put("s_snd_rslt_cd", getSSndRsltCd());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("snd_tp_cd", getSndTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
		this.hashColumns.put("ntc_snd_dt", getNtcSndDt());
		this.hashColumns.put("n3pty_src_dt", getN3ptySrcDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("s_snd_fm_dt", getSSndFmDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_aud_amt", getInvAudAmt());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("vvd_cd_ctnt", getVvdCdCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_snd_tp_cd", getSSndTpCd());
		this.hashColumns.put("ntc_his_seq", getNtcHisSeq());
		this.hashColumns.put("inv_aud_usd_amt", getInvAudUsdAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("eac_eml_use_flg", getEacEmlUseFlg());
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("eac_desc", getEacDesc());
		this.hashColumns.put("eml_sts_nm", getEmlStsNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eac_fax_use_flg", getEacFaxUseFlg());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("inv_cng_amt", getInvCngAmt());
		this.hashColumns.put("s_eac_yrmon_fm", getSEacYrmonFm());
		this.hashColumns.put("s_eac_yrmon_to", getSEacYrmonTo());
		this.hashColumns.put("snd_yn", getSndYn());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("eac_expn_tp_cd", getEacExpnTpCd());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("s_eac_reg_usr_id", getSEacRegUsrId());
		this.hashColumns.put("fax_sts_nm", getFaxStsNm());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("wo_no_ctnt", getWoNoCtnt());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_snd_to_dt", "sSndToDt");
		this.hashFields.put("s_snd_rslt_cd", "sSndRsltCd");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("snd_tp_cd", "sndTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
		this.hashFields.put("ntc_snd_dt", "ntcSndDt");
		this.hashFields.put("n3pty_src_dt", "n3ptySrcDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("s_snd_fm_dt", "sSndFmDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_aud_amt", "invAudAmt");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("vvd_cd_ctnt", "vvdCdCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_snd_tp_cd", "sSndTpCd");
		this.hashFields.put("ntc_his_seq", "ntcHisSeq");
		this.hashFields.put("inv_aud_usd_amt", "invAudUsdAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("eac_eml_use_flg", "eacEmlUseFlg");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("eac_desc", "eacDesc");
		this.hashFields.put("eml_sts_nm", "emlStsNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eac_fax_use_flg", "eacFaxUseFlg");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("inv_cng_amt", "invCngAmt");
		this.hashFields.put("s_eac_yrmon_fm", "sEacYrmonFm");
		this.hashFields.put("s_eac_yrmon_to", "sEacYrmonTo");
		this.hashFields.put("snd_yn", "sndYn");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("eac_expn_tp_cd", "eacExpnTpCd");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("s_eac_reg_usr_id", "sEacRegUsrId");
		this.hashFields.put("fax_sts_nm", "faxStsNm");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("wo_no_ctnt", "woNoCtnt");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sSndToDt
	 */
	public String getSSndToDt() {
		return this.sSndToDt;
	}
	
	/**
	 * Column Info
	 * @return sSndRsltCd
	 */
	public String getSSndRsltCd() {
		return this.sSndRsltCd;
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
	 * @return sndTpCd
	 */
	public String getSndTpCd() {
		return this.sndTpCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return vndrCntcPntSeq
	 */
	public String getVndrCntcPntSeq() {
		return this.vndrCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return ntcSndDt
	 */
	public String getNtcSndDt() {
		return this.ntcSndDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcDt
	 */
	public String getN3ptySrcDt() {
		return this.n3ptySrcDt;
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
	 * @return rcvrFaxNo
	 */
	public String getRcvrFaxNo() {
		return this.rcvrFaxNo;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return sSndFmDt
	 */
	public String getSSndFmDt() {
		return this.sSndFmDt;
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
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invAudAmt
	 */
	public String getInvAudAmt() {
		return this.invAudAmt;
	}
	
	/**
	 * Column Info
	 * @return faxSndNo
	 */
	public String getFaxSndNo() {
		return this.faxSndNo;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
	}
	
	/**
	 * Column Info
	 * @return vvdCdCtnt
	 */
	public String getVvdCdCtnt() {
		return this.vvdCdCtnt;
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
	 * @return sSndTpCd
	 */
	public String getSSndTpCd() {
		return this.sSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcHisSeq
	 */
	public String getNtcHisSeq() {
		return this.ntcHisSeq;
	}
	
	/**
	 * Column Info
	 * @return invAudUsdAmt
	 */
	public String getInvAudUsdAmt() {
		return this.invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacEmlUseFlg
	 */
	public String getEacEmlUseFlg() {
		return this.eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvrPhnNo
	 */
	public String getRcvrPhnNo() {
		return this.rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return eacDesc
	 */
	public String getEacDesc() {
		return this.eacDesc;
	}
	
	/**
	 * Column Info
	 * @return emlStsNm
	 */
	public String getEmlStsNm() {
		return this.emlStsNm;
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
	 * @return eacFaxUseFlg
	 */
	public String getEacFaxUseFlg() {
		return this.eacFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return invCngAmt
	 */
	public String getInvCngAmt() {
		return this.invCngAmt;
	}
	
	/**
	 * Column Info
	 * @return sEacYrmonFm
	 */
	public String getSEacYrmonFm() {
		return this.sEacYrmonFm;
	}
	
	/**
	 * Column Info
	 * @return sEacYrmonTo
	 */
	public String getSEacYrmonTo() {
		return this.sEacYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return sndYn
	 */
	public String getSndYn() {
		return this.sndYn;
	}
	
	/**
	 * Column Info
	 * @return sVndrSeq
	 */
	public String getSVndrSeq() {
		return this.sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return eacExpnTpCd
	 */
	public String getEacExpnTpCd() {
		return this.eacExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return eacNo
	 */
	public String getEacNo() {
		return this.eacNo;
	}
	
	/**
	 * Column Info
	 * @return sEacRegUsrId
	 */
	public String getSEacRegUsrId() {
		return this.sEacRegUsrId;
	}
	
	/**
	 * Column Info
	 * @return faxStsNm
	 */
	public String getFaxStsNm() {
		return this.faxStsNm;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return woNoCtnt
	 */
	public String getWoNoCtnt() {
		return this.woNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	

	/**
	 * Column Info
	 * @param sSndToDt
	 */
	public void setSSndToDt(String sSndToDt) {
		this.sSndToDt = sSndToDt;
	}
	
	/**
	 * Column Info
	 * @param sSndRsltCd
	 */
	public void setSSndRsltCd(String sSndRsltCd) {
		this.sSndRsltCd = sSndRsltCd;
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
	 * @param sndTpCd
	 */
	public void setSndTpCd(String sndTpCd) {
		this.sndTpCd = sndTpCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param vndrCntcPntSeq
	 */
	public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
		this.vndrCntcPntSeq = vndrCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param ntcSndDt
	 */
	public void setNtcSndDt(String ntcSndDt) {
		this.ntcSndDt = ntcSndDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcDt
	 */
	public void setN3ptySrcDt(String n3ptySrcDt) {
		this.n3ptySrcDt = n3ptySrcDt;
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
	 * @param rcvrFaxNo
	 */
	public void setRcvrFaxNo(String rcvrFaxNo) {
		this.rcvrFaxNo = rcvrFaxNo;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param sSndFmDt
	 */
	public void setSSndFmDt(String sSndFmDt) {
		this.sSndFmDt = sSndFmDt;
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
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invAudAmt
	 */
	public void setInvAudAmt(String invAudAmt) {
		this.invAudAmt = invAudAmt;
	}
	
	/**
	 * Column Info
	 * @param faxSndNo
	 */
	public void setFaxSndNo(String faxSndNo) {
		this.faxSndNo = faxSndNo;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
	}
	
	/**
	 * Column Info
	 * @param vvdCdCtnt
	 */
	public void setVvdCdCtnt(String vvdCdCtnt) {
		this.vvdCdCtnt = vvdCdCtnt;
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
	 * @param sSndTpCd
	 */
	public void setSSndTpCd(String sSndTpCd) {
		this.sSndTpCd = sSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcHisSeq
	 */
	public void setNtcHisSeq(String ntcHisSeq) {
		this.ntcHisSeq = ntcHisSeq;
	}
	
	/**
	 * Column Info
	 * @param invAudUsdAmt
	 */
	public void setInvAudUsdAmt(String invAudUsdAmt) {
		this.invAudUsdAmt = invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacEmlUseFlg
	 */
	public void setEacEmlUseFlg(String eacEmlUseFlg) {
		this.eacEmlUseFlg = eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvrPhnNo
	 */
	public void setRcvrPhnNo(String rcvrPhnNo) {
		this.rcvrPhnNo = rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param eacDesc
	 */
	public void setEacDesc(String eacDesc) {
		this.eacDesc = eacDesc;
	}
	
	/**
	 * Column Info
	 * @param emlStsNm
	 */
	public void setEmlStsNm(String emlStsNm) {
		this.emlStsNm = emlStsNm;
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
	 * @param eacFaxUseFlg
	 */
	public void setEacFaxUseFlg(String eacFaxUseFlg) {
		this.eacFaxUseFlg = eacFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param invCngAmt
	 */
	public void setInvCngAmt(String invCngAmt) {
		this.invCngAmt = invCngAmt;
	}
	
	/**
	 * Column Info
	 * @param sEacYrmonFm
	 */
	public void setSEacYrmonFm(String sEacYrmonFm) {
		this.sEacYrmonFm = sEacYrmonFm;
	}
	
	/**
	 * Column Info
	 * @param sEacYrmonTo
	 */
	public void setSEacYrmonTo(String sEacYrmonTo) {
		this.sEacYrmonTo = sEacYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param sndYn
	 */
	public void setSndYn(String sndYn) {
		this.sndYn = sndYn;
	}
	
	/**
	 * Column Info
	 * @param sVndrSeq
	 */
	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param eacExpnTpCd
	 */
	public void setEacExpnTpCd(String eacExpnTpCd) {
		this.eacExpnTpCd = eacExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param eacNo
	 */
	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
	}
	
	/**
	 * Column Info
	 * @param sEacRegUsrId
	 */
	public void setSEacRegUsrId(String sEacRegUsrId) {
		this.sEacRegUsrId = sEacRegUsrId;
	}
	
	/**
	 * Column Info
	 * @param faxStsNm
	 */
	public void setFaxStsNm(String faxStsNm) {
		this.faxStsNm = faxStsNm;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param woNoCtnt
	 */
	public void setWoNoCtnt(String woNoCtnt) {
		this.woNoCtnt = woNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
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
		setSSndToDt(JSPUtil.getParameter(request, prefix + "s_snd_to_dt", ""));
		setSSndRsltCd(JSPUtil.getParameter(request, prefix + "s_snd_rslt_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setSndTpCd(JSPUtil.getParameter(request, prefix + "snd_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
		setNtcSndDt(JSPUtil.getParameter(request, prefix + "ntc_snd_dt", ""));
		setN3ptySrcDt(JSPUtil.getParameter(request, prefix + "n3pty_src_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRcvrFaxNo(JSPUtil.getParameter(request, prefix + "rcvr_fax_no", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setSSndFmDt(JSPUtil.getParameter(request, prefix + "s_snd_fm_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setInvAudAmt(JSPUtil.getParameter(request, prefix + "inv_aud_amt", ""));
		setFaxSndNo(JSPUtil.getParameter(request, prefix + "fax_snd_no", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setVvdCdCtnt(JSPUtil.getParameter(request, prefix + "vvd_cd_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSSndTpCd(JSPUtil.getParameter(request, prefix + "s_snd_tp_cd", ""));
		setNtcHisSeq(JSPUtil.getParameter(request, prefix + "ntc_his_seq", ""));
		setInvAudUsdAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setEacEmlUseFlg(JSPUtil.getParameter(request, prefix + "eac_eml_use_flg", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request, prefix + "rcvr_phn_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setEacDesc(JSPUtil.getParameter(request, prefix + "eac_desc", ""));
		setEmlStsNm(JSPUtil.getParameter(request, prefix + "eml_sts_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEacFaxUseFlg(JSPUtil.getParameter(request, prefix + "eac_fax_use_flg", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setInvCngAmt(JSPUtil.getParameter(request, prefix + "inv_cng_amt", ""));
		setSEacYrmonFm(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_fm", ""));
		setSEacYrmonTo(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_to", ""));
		setSndYn(JSPUtil.getParameter(request, prefix + "snd_yn", ""));
		setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setEacExpnTpCd(JSPUtil.getParameter(request, prefix + "eac_expn_tp_cd", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setSEacRegUsrId(JSPUtil.getParameter(request, prefix + "s_eac_reg_usr_id", ""));
		setFaxStsNm(JSPUtil.getParameter(request, prefix + "fax_sts_nm", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setWoNoCtnt(JSPUtil.getParameter(request, prefix + "wo_no_ctnt", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACNtcHisVO[]
	 */
	public EACNtcHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACNtcHisVO[]
	 */
	public EACNtcHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACNtcHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sSndToDt = (JSPUtil.getParameter(request, prefix	+ "s_snd_to_dt", length));
			String[] sSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "s_snd_rslt_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] sndTpCd = (JSPUtil.getParameter(request, prefix	+ "snd_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_seq", length));
			String[] ntcSndDt = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_dt", length));
			String[] n3ptySrcDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rcvrFaxNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_fax_no", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] sSndFmDt = (JSPUtil.getParameter(request, prefix	+ "s_snd_fm_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invAudAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_amt", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] vvdCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sSndTpCd = (JSPUtil.getParameter(request, prefix	+ "s_snd_tp_cd", length));
			String[] ntcHisSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_his_seq", length));
			String[] invAudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_usd_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] eacEmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_eml_use_flg", length));
			String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_phn_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] eacDesc = (JSPUtil.getParameter(request, prefix	+ "eac_desc", length));
			String[] emlStsNm = (JSPUtil.getParameter(request, prefix	+ "eml_sts_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eacFaxUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_fax_use_flg", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] invCngAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cng_amt", length));
			String[] sEacYrmonFm = (JSPUtil.getParameter(request, prefix	+ "s_eac_yrmon_fm", length));
			String[] sEacYrmonTo = (JSPUtil.getParameter(request, prefix	+ "s_eac_yrmon_to", length));
			String[] sndYn = (JSPUtil.getParameter(request, prefix	+ "snd_yn", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] eacExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_expn_tp_cd", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] sEacRegUsrId = (JSPUtil.getParameter(request, prefix	+ "s_eac_reg_usr_id", length));
			String[] faxStsNm = (JSPUtil.getParameter(request, prefix	+ "fax_sts_nm", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] woNoCtnt = (JSPUtil.getParameter(request, prefix	+ "wo_no_ctnt", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACNtcHisVO();
				if (sSndToDt[i] != null)
					model.setSSndToDt(sSndToDt[i]);
				if (sSndRsltCd[i] != null)
					model.setSSndRsltCd(sSndRsltCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (sndTpCd[i] != null)
					model.setSndTpCd(sndTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (vndrCntcPntSeq[i] != null)
					model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
				if (ntcSndDt[i] != null)
					model.setNtcSndDt(ntcSndDt[i]);
				if (n3ptySrcDt[i] != null)
					model.setN3ptySrcDt(n3ptySrcDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rcvrFaxNo[i] != null)
					model.setRcvrFaxNo(rcvrFaxNo[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (sSndFmDt[i] != null)
					model.setSSndFmDt(sSndFmDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invAudAmt[i] != null)
					model.setInvAudAmt(invAudAmt[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (vvdCdCtnt[i] != null)
					model.setVvdCdCtnt(vvdCdCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sSndTpCd[i] != null)
					model.setSSndTpCd(sSndTpCd[i]);
				if (ntcHisSeq[i] != null)
					model.setNtcHisSeq(ntcHisSeq[i]);
				if (invAudUsdAmt[i] != null)
					model.setInvAudUsdAmt(invAudUsdAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (eacEmlUseFlg[i] != null)
					model.setEacEmlUseFlg(eacEmlUseFlg[i]);
				if (rcvrPhnNo[i] != null)
					model.setRcvrPhnNo(rcvrPhnNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (eacDesc[i] != null)
					model.setEacDesc(eacDesc[i]);
				if (emlStsNm[i] != null)
					model.setEmlStsNm(emlStsNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eacFaxUseFlg[i] != null)
					model.setEacFaxUseFlg(eacFaxUseFlg[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (invCngAmt[i] != null)
					model.setInvCngAmt(invCngAmt[i]);
				if (sEacYrmonFm[i] != null)
					model.setSEacYrmonFm(sEacYrmonFm[i]);
				if (sEacYrmonTo[i] != null)
					model.setSEacYrmonTo(sEacYrmonTo[i]);
				if (sndYn[i] != null)
					model.setSndYn(sndYn[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (eacExpnTpCd[i] != null)
					model.setEacExpnTpCd(eacExpnTpCd[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (sEacRegUsrId[i] != null)
					model.setSEacRegUsrId(sEacRegUsrId[i]);
				if (faxStsNm[i] != null)
					model.setFaxStsNm(faxStsNm[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (woNoCtnt[i] != null)
					model.setWoNoCtnt(woNoCtnt[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACNtcHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACNtcHisVO[]
	 */
	public EACNtcHisVO[] getEACNtcHisVOs(){
		EACNtcHisVO[] vos = (EACNtcHisVO[])models.toArray(new EACNtcHisVO[models.size()]);
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
		this.sSndToDt = this.sSndToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndRsltCd = this.sSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTpCd = this.sndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntSeq = this.vndrCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndDt = this.ntcSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcDt = this.n3ptySrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrFaxNo = this.rcvrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndFmDt = this.sSndFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudAmt = this.invAudAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdCtnt = this.vvdCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndTpCd = this.sSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcHisSeq = this.ntcHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudUsdAmt = this.invAudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacEmlUseFlg = this.eacEmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo = this.rcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacDesc = this.eacDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlStsNm = this.emlStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFaxUseFlg = this.eacFaxUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCngAmt = this.invCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacYrmonFm = this.sEacYrmonFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacYrmonTo = this.sEacYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndYn = this.sndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacExpnTpCd = this.eacExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacRegUsrId = this.sEacRegUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxStsNm = this.faxStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNoCtnt = this.woNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
