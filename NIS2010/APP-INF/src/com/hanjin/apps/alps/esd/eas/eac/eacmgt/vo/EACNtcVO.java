/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACNtcVO.java
*@FileTitle : EACNtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.08 백형인 
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

public class EACNtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACNtcVO> models = new ArrayList<EACNtcVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ntcCcRcvEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCdCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invAudUsdAmt = null;
	/* Column Info */
	private String ntcHisSeq = null;
	/* Column Info */
	private String rdPath = null;
	/* Column Info */
	private String vndrCntcPntSeq = null;
	/* Column Info */
	private String rdName = null;
	/* Column Info */
	private String rcvrPhnNo = null;
	/* Column Info */
	private String eacEmlUseFlg = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String n3ptySrcDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eacOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String eacFaxUseFlg = null;
	/* Column Info */
	private String rdParam = null;
	/* Column Info */
	private String invCngAmt = null;
	/* Column Info */
	private String rcvrFaxNo = null;
	/* Column Info */
	private String sndYn = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String eacExpnTpCd = null;
	/* Column Info */
	private String rcvrName = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invAudAmt = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String woNoCtnt = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACNtcVO() {}

	public EACNtcVO(String ibflag, String pagerows, String rdParam, String rdPath, String ntcCcRcvEml, String eacNo, String ntcHisSeq, String vndrCntcPntSeq, String emlSubjCtnt, String emlCtnt, String emlSndDt, String rcvrEml, String rcvrName, String rcvrPhnNo, String rcvrFaxNo, String eacEmlUseFlg, String eacFaxUseFlg, String emlSndNo, String faxSndNo, String creUsrId, String creDt, String updUsrId, String updDt, String vndrSeq, String n3ptySrcNo, String n3ptySrcDt, String currCd, String invAmt, String invCngAmt, String invAudAmt, String invAudUsdAmt, String woNoCtnt, String vvdCdCtnt, String blNo, String eacExpnTpCd, String eacOfcCd, String rdName, String vndrEml, String phnNo, String faxNo, String usrEml, String sndYn) {
		this.currCd = currCd;
		this.emlSndDt = emlSndDt;
		this.creDt = creDt;
		this.emlCtnt = emlCtnt;
		this.blNo = blNo;
		this.ntcCcRcvEml = ntcCcRcvEml;
		this.pagerows = pagerows;
		this.vvdCdCtnt = vvdCdCtnt;
		this.ibflag = ibflag;
		this.invAudUsdAmt = invAudUsdAmt;
		this.ntcHisSeq = ntcHisSeq;
		this.rdPath = rdPath;
		this.vndrCntcPntSeq = vndrCntcPntSeq;
		this.rdName = rdName;
		this.rcvrPhnNo = rcvrPhnNo;
		this.eacEmlUseFlg = eacEmlUseFlg;
		this.usrEml = usrEml;
		this.invAmt = invAmt;
		this.n3ptySrcDt = n3ptySrcDt;
		this.updUsrId = updUsrId;
		this.eacOfcCd = eacOfcCd;
		this.updDt = updDt;
		this.phnNo = phnNo;
		this.eacFaxUseFlg = eacFaxUseFlg;
		this.rdParam = rdParam;
		this.invCngAmt = invCngAmt;
		this.rcvrFaxNo = rcvrFaxNo;
		this.sndYn = sndYn;
		this.emlSndNo = emlSndNo;
		this.eacExpnTpCd = eacExpnTpCd;
		this.rcvrName = rcvrName;
		this.vndrEml = vndrEml;
		this.eacNo = eacNo;
		this.rcvrEml = rcvrEml;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.invAudAmt = invAudAmt;
		this.faxNo = faxNo;
		this.woNoCtnt = woNoCtnt;
		this.emlSubjCtnt = emlSubjCtnt;
		this.faxSndNo = faxSndNo;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ntc_cc_rcv_eml", getNtcCcRcvEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd_ctnt", getVvdCdCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_aud_usd_amt", getInvAudUsdAmt());
		this.hashColumns.put("ntc_his_seq", getNtcHisSeq());
		this.hashColumns.put("rd_path", getRdPath());
		this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
		this.hashColumns.put("rd_name", getRdName());
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
		this.hashColumns.put("eac_eml_use_flg", getEacEmlUseFlg());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("n3pty_src_dt", getN3ptySrcDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eac_ofc_cd", getEacOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("eac_fax_use_flg", getEacFaxUseFlg());
		this.hashColumns.put("rd_param", getRdParam());
		this.hashColumns.put("inv_cng_amt", getInvCngAmt());
		this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());
		this.hashColumns.put("snd_yn", getSndYn());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("eac_expn_tp_cd", getEacExpnTpCd());
		this.hashColumns.put("rcvr_name", getRcvrName());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_aud_amt", getInvAudAmt());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("wo_no_ctnt", getWoNoCtnt());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ntc_cc_rcv_eml", "ntcCcRcvEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd_ctnt", "vvdCdCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_aud_usd_amt", "invAudUsdAmt");
		this.hashFields.put("ntc_his_seq", "ntcHisSeq");
		this.hashFields.put("rd_path", "rdPath");
		this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("eac_eml_use_flg", "eacEmlUseFlg");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("n3pty_src_dt", "n3ptySrcDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eac_ofc_cd", "eacOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("eac_fax_use_flg", "eacFaxUseFlg");
		this.hashFields.put("rd_param", "rdParam");
		this.hashFields.put("inv_cng_amt", "invCngAmt");
		this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
		this.hashFields.put("snd_yn", "sndYn");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("eac_expn_tp_cd", "eacExpnTpCd");
		this.hashFields.put("rcvr_name", "rcvrName");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_aud_amt", "invAudAmt");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("wo_no_ctnt", "woNoCtnt");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
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
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ntcCcRcvEml
	 */
	public String getNtcCcRcvEml() {
		return this.ntcCcRcvEml;
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
	 * @return invAudUsdAmt
	 */
	public String getInvAudUsdAmt() {
		return this.invAudUsdAmt;
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
	 * @return rdPath
	 */
	public String getRdPath() {
		return this.rdPath;
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
	 * @return rdName
	 */
	public String getRdName() {
		return this.rdName;
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
	 * @return eacEmlUseFlg
	 */
	public String getEacEmlUseFlg() {
		return this.eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
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
	 * @return eacOfcCd
	 */
	public String getEacOfcCd() {
		return this.eacOfcCd;
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
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
	 * @return rdParam
	 */
	public String getRdParam() {
		return this.rdParam;
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
	 * @return rcvrFaxNo
	 */
	public String getRcvrFaxNo() {
		return this.rcvrFaxNo;
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
	 * @return rcvrName
	 */
	public String getRcvrName() {
		return this.rcvrName;
	}
	
	/**
	 * Column Info
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
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
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
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
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
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
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
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
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ntcCcRcvEml
	 */
	public void setNtcCcRcvEml(String ntcCcRcvEml) {
		this.ntcCcRcvEml = ntcCcRcvEml;
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
	 * @param invAudUsdAmt
	 */
	public void setInvAudUsdAmt(String invAudUsdAmt) {
		this.invAudUsdAmt = invAudUsdAmt;
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
	 * @param rdPath
	 */
	public void setRdPath(String rdPath) {
		this.rdPath = rdPath;
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
	 * @param rdName
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
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
	 * @param eacEmlUseFlg
	 */
	public void setEacEmlUseFlg(String eacEmlUseFlg) {
		this.eacEmlUseFlg = eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
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
	 * @param eacOfcCd
	 */
	public void setEacOfcCd(String eacOfcCd) {
		this.eacOfcCd = eacOfcCd;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
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
	 * @param rdParam
	 */
	public void setRdParam(String rdParam) {
		this.rdParam = rdParam;
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
	 * @param rcvrFaxNo
	 */
	public void setRcvrFaxNo(String rcvrFaxNo) {
		this.rcvrFaxNo = rcvrFaxNo;
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
	 * @param rcvrName
	 */
	public void setRcvrName(String rcvrName) {
		this.rcvrName = rcvrName;
	}
	
	/**
	 * Column Info
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
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
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setNtcCcRcvEml(JSPUtil.getParameter(request, prefix + "ntc_cc_rcv_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdCdCtnt(JSPUtil.getParameter(request, prefix + "vvd_cd_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvAudUsdAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_amt", ""));
		setNtcHisSeq(JSPUtil.getParameter(request, prefix + "ntc_his_seq", ""));
		setRdPath(JSPUtil.getParameter(request, prefix + "rd_path", ""));
		setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
		setRdName(JSPUtil.getParameter(request, prefix + "rd_name", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request, prefix + "rcvr_phn_no", ""));
		setEacEmlUseFlg(JSPUtil.getParameter(request, prefix + "eac_eml_use_flg", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setN3ptySrcDt(JSPUtil.getParameter(request, prefix + "n3pty_src_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEacOfcCd(JSPUtil.getParameter(request, prefix + "eac_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setEacFaxUseFlg(JSPUtil.getParameter(request, prefix + "eac_fax_use_flg", ""));
		setRdParam(JSPUtil.getParameter(request, prefix + "rd_param", ""));
		setInvCngAmt(JSPUtil.getParameter(request, prefix + "inv_cng_amt", ""));
		setRcvrFaxNo(JSPUtil.getParameter(request, prefix + "rcvr_fax_no", ""));
		setSndYn(JSPUtil.getParameter(request, prefix + "snd_yn", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setEacExpnTpCd(JSPUtil.getParameter(request, prefix + "eac_expn_tp_cd", ""));
		setRcvrName(JSPUtil.getParameter(request, prefix + "rcvr_name", ""));
		setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setInvAudAmt(JSPUtil.getParameter(request, prefix + "inv_aud_amt", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setWoNoCtnt(JSPUtil.getParameter(request, prefix + "wo_no_ctnt", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setFaxSndNo(JSPUtil.getParameter(request, prefix + "fax_snd_no", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACNtcVO[]
	 */
	public EACNtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACNtcVO[]
	 */
	public EACNtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACNtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ntcCcRcvEml = (JSPUtil.getParameter(request, prefix	+ "ntc_cc_rcv_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invAudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_usd_amt", length));
			String[] ntcHisSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_his_seq", length));
			String[] rdPath = (JSPUtil.getParameter(request, prefix	+ "rd_path", length));
			String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_seq", length));
			String[] rdName = (JSPUtil.getParameter(request, prefix	+ "rd_name", length));
			String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_phn_no", length));
			String[] eacEmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_eml_use_flg", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] n3ptySrcDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eacOfcCd = (JSPUtil.getParameter(request, prefix	+ "eac_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] eacFaxUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_fax_use_flg", length));
			String[] rdParam = (JSPUtil.getParameter(request, prefix	+ "rd_param", length));
			String[] invCngAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cng_amt", length));
			String[] rcvrFaxNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_fax_no", length));
			String[] sndYn = (JSPUtil.getParameter(request, prefix	+ "snd_yn", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] eacExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_expn_tp_cd", length));
			String[] rcvrName = (JSPUtil.getParameter(request, prefix	+ "rcvr_name", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invAudAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_amt", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] woNoCtnt = (JSPUtil.getParameter(request, prefix	+ "wo_no_ctnt", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACNtcVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ntcCcRcvEml[i] != null)
					model.setNtcCcRcvEml(ntcCcRcvEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCdCtnt[i] != null)
					model.setVvdCdCtnt(vvdCdCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invAudUsdAmt[i] != null)
					model.setInvAudUsdAmt(invAudUsdAmt[i]);
				if (ntcHisSeq[i] != null)
					model.setNtcHisSeq(ntcHisSeq[i]);
				if (rdPath[i] != null)
					model.setRdPath(rdPath[i]);
				if (vndrCntcPntSeq[i] != null)
					model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
				if (rdName[i] != null)
					model.setRdName(rdName[i]);
				if (rcvrPhnNo[i] != null)
					model.setRcvrPhnNo(rcvrPhnNo[i]);
				if (eacEmlUseFlg[i] != null)
					model.setEacEmlUseFlg(eacEmlUseFlg[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (n3ptySrcDt[i] != null)
					model.setN3ptySrcDt(n3ptySrcDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eacOfcCd[i] != null)
					model.setEacOfcCd(eacOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (eacFaxUseFlg[i] != null)
					model.setEacFaxUseFlg(eacFaxUseFlg[i]);
				if (rdParam[i] != null)
					model.setRdParam(rdParam[i]);
				if (invCngAmt[i] != null)
					model.setInvCngAmt(invCngAmt[i]);
				if (rcvrFaxNo[i] != null)
					model.setRcvrFaxNo(rcvrFaxNo[i]);
				if (sndYn[i] != null)
					model.setSndYn(sndYn[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (eacExpnTpCd[i] != null)
					model.setEacExpnTpCd(eacExpnTpCd[i]);
				if (rcvrName[i] != null)
					model.setRcvrName(rcvrName[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invAudAmt[i] != null)
					model.setInvAudAmt(invAudAmt[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (woNoCtnt[i] != null)
					model.setWoNoCtnt(woNoCtnt[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACNtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACNtcVO[]
	 */
	public EACNtcVO[] getEACNtcVOs(){
		EACNtcVO[] vos = (EACNtcVO[])models.toArray(new EACNtcVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcCcRcvEml = this.ntcCcRcvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdCtnt = this.vvdCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudUsdAmt = this.invAudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcHisSeq = this.ntcHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdPath = this.rdPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntSeq = this.vndrCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName = this.rdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo = this.rcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacEmlUseFlg = this.eacEmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcDt = this.n3ptySrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacOfcCd = this.eacOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFaxUseFlg = this.eacFaxUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdParam = this.rdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCngAmt = this.invCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrFaxNo = this.rcvrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndYn = this.sndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacExpnTpCd = this.eacExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrName = this.rcvrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudAmt = this.invAudAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNoCtnt = this.woNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
