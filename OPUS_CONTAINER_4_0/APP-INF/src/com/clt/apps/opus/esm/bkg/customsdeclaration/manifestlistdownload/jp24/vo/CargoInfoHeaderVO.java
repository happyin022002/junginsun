/*========================================================= 
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoInfoHeaderVO.java
*@FileTitle : CargoInfoHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class CargoInfoHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CargoInfoHeaderVO> models = new ArrayList<CargoInfoHeaderVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String corrRsnCd = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String rlxDiv = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfSndFlg = null;
	/* Column Info */
	private String vpsDtDiv = null;
	/* Column Info */
	private String vpsDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgPodHdr = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String errorDiv = null;
	/* Column Info */
	private String callSgnNoOrg = null;
	/* Column Info */
	private String polDiv = null;
	/* Column Info */
	private String atdRst = null;
	/* Column Info */
	private String delTrasmitFlag = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String podDiv = null;
	/* Column Info */
	private String vvdPodPrefix = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String searchDiv = null;
	/* Column Info */
	private String ltDiv = null;
	/* Column Info */
	private String podSplitNo = null;
	/* Column Info */
	private String ibCssmVoyNoOrg = null;
	/* Column Info */
	private String polSplitNo = null;
	/* Column Info */
	private String polCdHdr = null;
	/* Column Info */
	private String fnlEdiSndFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvdHdr = null;
	/* Column Info */
	private String pgmDiv = null;
	/* Column Info */
	private String vvdPodPostfix = null;
	/* Column Info */
	private String cstmsRslts = null;
	/* Column Info */
	private String vvdDateDiv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CargoInfoHeaderVO() {}

	public CargoInfoHeaderVO(String ibflag, String pagerows, String atdRst, String bkgOfcCd, String bkgPodHdr, String blNo, String callSgnNo, String callSgnNoOrg, String corrRsn, String corrRsnCd, String cstmsRslts, String dateFm, String dateTo, String delTrasmitFlag, String docUsrId, String errorDiv, String fnlEdiSndFlg, String ibCssmVoyNo, String ibCssmVoyNoOrg, String ltDiv, String mfSndFlg, String pgmDiv, String podCd, String podDiv, String podSplitNo, String polCd, String polCdHdr, String polDiv, String polSplitNo, String rcvDt, String rlxDiv, String searchDiv, String usrId, String vpsDt, String vpsDtDiv, String vvd, String vvdDateDiv, String vvdHdr, String vvdPodPostfix, String vvdPodPrefix) {
		this.dateFm = dateFm;
		this.corrRsnCd = corrRsnCd;
		this.docUsrId = docUsrId;
		this.rlxDiv = rlxDiv;
		this.blNo = blNo;
		this.mfSndFlg = mfSndFlg;
		this.vpsDtDiv = vpsDtDiv;
		this.vpsDt = vpsDt;
		this.pagerows = pagerows;
		this.bkgPodHdr = bkgPodHdr;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.usrId = usrId;
		this.rcvDt = rcvDt;
		this.errorDiv = errorDiv;
		this.callSgnNoOrg = callSgnNoOrg;
		this.polDiv = polDiv;
		this.atdRst = atdRst;
		this.delTrasmitFlag = delTrasmitFlag;
		this.bkgOfcCd = bkgOfcCd;
		this.podDiv = podDiv;
		this.vvdPodPrefix = vvdPodPrefix;
		this.dateTo = dateTo;
		this.callSgnNo = callSgnNo;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.searchDiv = searchDiv;
		this.ltDiv = ltDiv;
		this.podSplitNo = podSplitNo;
		this.ibCssmVoyNoOrg = ibCssmVoyNoOrg;
		this.polSplitNo = polSplitNo;
		this.polCdHdr = polCdHdr;
		this.fnlEdiSndFlg = fnlEdiSndFlg;
		this.vvd = vvd;
		this.podCd = podCd;
		this.vvdHdr = vvdHdr;
		this.pgmDiv = pgmDiv;
		this.vvdPodPostfix = vvdPodPostfix;
		this.cstmsRslts = cstmsRslts;
		this.vvdDateDiv = vvdDateDiv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("corr_rsn_cd", getCorrRsnCd());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("rlx_div", getRlxDiv());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_snd_flg", getMfSndFlg());
		this.hashColumns.put("vps_dt_div", getVpsDtDiv());
		this.hashColumns.put("vps_dt", getVpsDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_pod_hdr", getBkgPodHdr());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("error_div", getErrorDiv());
		this.hashColumns.put("call_sgn_no_org", getCallSgnNoOrg());
		this.hashColumns.put("pol_div", getPolDiv());
		this.hashColumns.put("atd_rst", getAtdRst());
		this.hashColumns.put("del_trasmit_flag", getDelTrasmitFlag());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("pod_div", getPodDiv());
		this.hashColumns.put("vvd_pod_prefix", getVvdPodPrefix());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("search_div", getSearchDiv());
		this.hashColumns.put("lt_div", getLtDiv());
		this.hashColumns.put("pod_split_no", getPodSplitNo());
		this.hashColumns.put("ib_cssm_voy_no_org", getIbCssmVoyNoOrg());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		this.hashColumns.put("pol_cd_hdr", getPolCdHdr());
		this.hashColumns.put("fnl_edi_snd_flg", getFnlEdiSndFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd_hdr", getVvdHdr());
		this.hashColumns.put("pgm_div", getPgmDiv());
		this.hashColumns.put("vvd_pod_postfix", getVvdPodPostfix());
		this.hashColumns.put("cstms_rslts", getCstmsRslts());
		this.hashColumns.put("vvd_date_div", getVvdDateDiv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("corr_rsn_cd", "corrRsnCd");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("rlx_div", "rlxDiv");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_snd_flg", "mfSndFlg");
		this.hashFields.put("vps_dt_div", "vpsDtDiv");
		this.hashFields.put("vps_dt", "vpsDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_pod_hdr", "bkgPodHdr");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("error_div", "errorDiv");
		this.hashFields.put("call_sgn_no_org", "callSgnNoOrg");
		this.hashFields.put("pol_div", "polDiv");
		this.hashFields.put("atd_rst", "atdRst");
		this.hashFields.put("del_trasmit_flag", "delTrasmitFlag");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("pod_div", "podDiv");
		this.hashFields.put("vvd_pod_prefix", "vvdPodPrefix");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("search_div", "searchDiv");
		this.hashFields.put("lt_div", "ltDiv");
		this.hashFields.put("pod_split_no", "podSplitNo");
		this.hashFields.put("ib_cssm_voy_no_org", "ibCssmVoyNoOrg");
		this.hashFields.put("pol_split_no", "polSplitNo");
		this.hashFields.put("pol_cd_hdr", "polCdHdr");
		this.hashFields.put("fnl_edi_snd_flg", "fnlEdiSndFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd_hdr", "vvdHdr");
		this.hashFields.put("pgm_div", "pgmDiv");
		this.hashFields.put("vvd_pod_postfix", "vvdPodPostfix");
		this.hashFields.put("cstms_rslts", "cstmsRslts");
		this.hashFields.put("vvd_date_div", "vvdDateDiv");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}
	
	/**
	 * Column Info
	 * @return corrRsnCd
	 */
	public String getCorrRsnCd() {
		return this.corrRsnCd;
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
	 * @return rlxDiv
	 */
	public String getRlxDiv() {
		return this.rlxDiv;
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
	 * @return mfSndFlg
	 */
	public String getMfSndFlg() {
		return this.mfSndFlg;
	}
	
	/**
	 * Column Info
	 * @return vpsDtDiv
	 */
	public String getVpsDtDiv() {
		return this.vpsDtDiv;
	}
	
	/**
	 * Column Info
	 * @return vpsDt
	 */
	public String getVpsDt() {
		return this.vpsDt;
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
	 * @return bkgPodHdr
	 */
	public String getBkgPodHdr() {
		return this.bkgPodHdr;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return errorDiv
	 */
	public String getErrorDiv() {
		return this.errorDiv;
	}
	
	/**
	 * Column Info
	 * @return callSgnNoOrg
	 */
	public String getCallSgnNoOrg() {
		return this.callSgnNoOrg;
	}
	
	/**
	 * Column Info
	 * @return polDiv
	 */
	public String getPolDiv() {
		return this.polDiv;
	}
	
	/**
	 * Column Info
	 * @return atdRst
	 */
	public String getAtdRst() {
		return this.atdRst;
	}
	
	/**
	 * Column Info
	 * @return delTrasmitFlag
	 */
	public String getDelTrasmitFlag() {
		return this.delTrasmitFlag;
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
	 * @return podDiv
	 */
	public String getPodDiv() {
		return this.podDiv;
	}
	
	/**
	 * Column Info
	 * @return vvdPodPrefix
	 */
	public String getVvdPodPrefix() {
		return this.vvdPodPrefix;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return searchDiv
	 */
	public String getSearchDiv() {
		return this.searchDiv;
	}
	
	/**
	 * Column Info
	 * @return ltDiv
	 */
	public String getLtDiv() {
		return this.ltDiv;
	}
	
	/**
	 * Column Info
	 * @return podSplitNo
	 */
	public String getPodSplitNo() {
		return this.podSplitNo;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNoOrg
	 */
	public String getIbCssmVoyNoOrg() {
		return this.ibCssmVoyNoOrg;
	}
	
	/**
	 * Column Info
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
	}
	
	/**
	 * Column Info
	 * @return polCdHdr
	 */
	public String getPolCdHdr() {
		return this.polCdHdr;
	}
	
	/**
	 * Column Info
	 * @return fnlEdiSndFlg
	 */
	public String getFnlEdiSndFlg() {
		return this.fnlEdiSndFlg;
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
	 * @return vvdHdr
	 */
	public String getVvdHdr() {
		return this.vvdHdr;
	}
	
	/**
	 * Column Info
	 * @return pgmDiv
	 */
	public String getPgmDiv() {
		return this.pgmDiv;
	}
	
	/**
	 * Column Info
	 * @return vvdPodPostfix
	 */
	public String getVvdPodPostfix() {
		return this.vvdPodPostfix;
	}
	
	/**
	 * Column Info
	 * @return cstmsRslts
	 */
	public String getCstmsRslts() {
		return this.cstmsRslts;
	}
	
	/**
	 * Column Info
	 * @return vvdDateDiv
	 */
	public String getVvdDateDiv() {
		return this.vvdDateDiv;
	}
	

	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}
	
	/**
	 * Column Info
	 * @param corrRsnCd
	 */
	public void setCorrRsnCd(String corrRsnCd) {
		this.corrRsnCd = corrRsnCd;
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
	 * @param rlxDiv
	 */
	public void setRlxDiv(String rlxDiv) {
		this.rlxDiv = rlxDiv;
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
	 * @param mfSndFlg
	 */
	public void setMfSndFlg(String mfSndFlg) {
		this.mfSndFlg = mfSndFlg;
	}
	
	/**
	 * Column Info
	 * @param vpsDtDiv
	 */
	public void setVpsDtDiv(String vpsDtDiv) {
		this.vpsDtDiv = vpsDtDiv;
	}
	
	/**
	 * Column Info
	 * @param vpsDt
	 */
	public void setVpsDt(String vpsDt) {
		this.vpsDt = vpsDt;
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
	 * @param bkgPodHdr
	 */
	public void setBkgPodHdr(String bkgPodHdr) {
		this.bkgPodHdr = bkgPodHdr;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param errorDiv
	 */
	public void setErrorDiv(String errorDiv) {
		this.errorDiv = errorDiv;
	}
	
	/**
	 * Column Info
	 * @param callSgnNoOrg
	 */
	public void setCallSgnNoOrg(String callSgnNoOrg) {
		this.callSgnNoOrg = callSgnNoOrg;
	}
	
	/**
	 * Column Info
	 * @param polDiv
	 */
	public void setPolDiv(String polDiv) {
		this.polDiv = polDiv;
	}
	
	/**
	 * Column Info
	 * @param atdRst
	 */
	public void setAtdRst(String atdRst) {
		this.atdRst = atdRst;
	}
	
	/**
	 * Column Info
	 * @param delTrasmitFlag
	 */
	public void setDelTrasmitFlag(String delTrasmitFlag) {
		this.delTrasmitFlag = delTrasmitFlag;
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
	 * @param podDiv
	 */
	public void setPodDiv(String podDiv) {
		this.podDiv = podDiv;
	}
	
	/**
	 * Column Info
	 * @param vvdPodPrefix
	 */
	public void setVvdPodPrefix(String vvdPodPrefix) {
		this.vvdPodPrefix = vvdPodPrefix;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param searchDiv
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	
	/**
	 * Column Info
	 * @param ltDiv
	 */
	public void setLtDiv(String ltDiv) {
		this.ltDiv = ltDiv;
	}
	
	/**
	 * Column Info
	 * @param podSplitNo
	 */
	public void setPodSplitNo(String podSplitNo) {
		this.podSplitNo = podSplitNo;
	}
	
	/**
	 * Column Info
	 * @param ibCssmVoyNoOrg
	 */
	public void setIbCssmVoyNoOrg(String ibCssmVoyNoOrg) {
		this.ibCssmVoyNoOrg = ibCssmVoyNoOrg;
	}
	
	/**
	 * Column Info
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * Column Info
	 * @param polCdHdr
	 */
	public void setPolCdHdr(String polCdHdr) {
		this.polCdHdr = polCdHdr;
	}
	
	/**
	 * Column Info
	 * @param fnlEdiSndFlg
	 */
	public void setFnlEdiSndFlg(String fnlEdiSndFlg) {
		this.fnlEdiSndFlg = fnlEdiSndFlg;
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
	 * @param vvdHdr
	 */
	public void setVvdHdr(String vvdHdr) {
		this.vvdHdr = vvdHdr;
	}
	
	/**
	 * Column Info
	 * @param pgmDiv
	 */
	public void setPgmDiv(String pgmDiv) {
		this.pgmDiv = pgmDiv;
	}
	
	/**
	 * Column Info
	 * @param vvdPodPostfix
	 */
	public void setVvdPodPostfix(String vvdPodPostfix) {
		this.vvdPodPostfix = vvdPodPostfix;
	}
	
	/**
	 * Column Info
	 * @param cstmsRslts
	 */
	public void setCstmsRslts(String cstmsRslts) {
		this.cstmsRslts = cstmsRslts;
	}
	
	/**
	 * Column Info
	 * @param vvdDateDiv
	 */
	public void setVvdDateDiv(String vvdDateDiv) {
		this.vvdDateDiv = vvdDateDiv;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setCorrRsnCd(JSPUtil.getParameter(request, prefix + "corr_rsn_cd", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setRlxDiv(JSPUtil.getParameter(request, prefix + "rlx_div", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMfSndFlg(JSPUtil.getParameter(request, prefix + "mf_snd_flg", ""));
		setVpsDtDiv(JSPUtil.getParameter(request, prefix + "vps_dt_div", ""));
		setVpsDt(JSPUtil.getParameter(request, prefix + "vps_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgPodHdr(JSPUtil.getParameter(request, prefix + "bkg_pod_hdr", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setErrorDiv(JSPUtil.getParameter(request, prefix + "error_div", ""));
		setCallSgnNoOrg(JSPUtil.getParameter(request, prefix + "call_sgn_no_org", ""));
		setPolDiv(JSPUtil.getParameter(request, prefix + "pol_div", ""));
		setAtdRst(JSPUtil.getParameter(request, prefix + "atd_rst", ""));
		setDelTrasmitFlag(JSPUtil.getParameter(request, prefix + "del_trasmit_flag", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setPodDiv(JSPUtil.getParameter(request, prefix + "pod_div", ""));
		setVvdPodPrefix(JSPUtil.getParameter(request, prefix + "vvd_pod_prefix", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setSearchDiv(JSPUtil.getParameter(request, prefix + "search_div", ""));
		setLtDiv(JSPUtil.getParameter(request, prefix + "lt_div", ""));
		setPodSplitNo(JSPUtil.getParameter(request, prefix + "pod_split_no", ""));
		setIbCssmVoyNoOrg(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no_org", ""));
		setPolSplitNo(JSPUtil.getParameter(request, prefix + "pol_split_no", ""));
		setPolCdHdr(JSPUtil.getParameter(request, prefix + "pol_cd_hdr", ""));
		setFnlEdiSndFlg(JSPUtil.getParameter(request, prefix + "fnl_edi_snd_flg", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvdHdr(JSPUtil.getParameter(request, prefix + "vvd_hdr", ""));
		setPgmDiv(JSPUtil.getParameter(request, prefix + "pgm_div", ""));
		setVvdPodPostfix(JSPUtil.getParameter(request, prefix + "vvd_pod_postfix", ""));
		setCstmsRslts(JSPUtil.getParameter(request, prefix + "cstms_rslts", ""));
		setVvdDateDiv(JSPUtil.getParameter(request, prefix + "vvd_date_div", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CargoInfoHeaderVO[]
	 */
	public CargoInfoHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CargoInfoHeaderVO[]
	 */
	public CargoInfoHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CargoInfoHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] corrRsnCd = (JSPUtil.getParameter(request, prefix	+ "corr_rsn_cd", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] rlxDiv = (JSPUtil.getParameter(request, prefix	+ "rlx_div", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mfSndFlg = (JSPUtil.getParameter(request, prefix	+ "mf_snd_flg", length));
			String[] vpsDtDiv = (JSPUtil.getParameter(request, prefix	+ "vps_dt_div", length));
			String[] vpsDt = (JSPUtil.getParameter(request, prefix	+ "vps_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgPodHdr = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_hdr", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] errorDiv = (JSPUtil.getParameter(request, prefix	+ "error_div", length));
			String[] callSgnNoOrg = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no_org", length));
			String[] polDiv = (JSPUtil.getParameter(request, prefix	+ "pol_div", length));
			String[] atdRst = (JSPUtil.getParameter(request, prefix	+ "atd_rst", length));
			String[] delTrasmitFlag = (JSPUtil.getParameter(request, prefix	+ "del_trasmit_flag", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] podDiv = (JSPUtil.getParameter(request, prefix	+ "pod_div", length));
			String[] vvdPodPrefix = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_prefix", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] searchDiv = (JSPUtil.getParameter(request, prefix	+ "search_div", length));
			String[] ltDiv = (JSPUtil.getParameter(request, prefix	+ "lt_div", length));
			String[] podSplitNo = (JSPUtil.getParameter(request, prefix	+ "pod_split_no", length));
			String[] ibCssmVoyNoOrg = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no_org", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			String[] polCdHdr = (JSPUtil.getParameter(request, prefix	+ "pol_cd_hdr", length));
			String[] fnlEdiSndFlg = (JSPUtil.getParameter(request, prefix	+ "fnl_edi_snd_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvdHdr = (JSPUtil.getParameter(request, prefix	+ "vvd_hdr", length));
			String[] pgmDiv = (JSPUtil.getParameter(request, prefix	+ "pgm_div", length));
			String[] vvdPodPostfix = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_postfix", length));
			String[] cstmsRslts = (JSPUtil.getParameter(request, prefix	+ "cstms_rslts", length));
			String[] vvdDateDiv = (JSPUtil.getParameter(request, prefix	+ "vvd_date_div", length));
			
			for (int i = 0; i < length; i++) {
				model = new CargoInfoHeaderVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (corrRsnCd[i] != null)
					model.setCorrRsnCd(corrRsnCd[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (rlxDiv[i] != null)
					model.setRlxDiv(rlxDiv[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfSndFlg[i] != null)
					model.setMfSndFlg(mfSndFlg[i]);
				if (vpsDtDiv[i] != null)
					model.setVpsDtDiv(vpsDtDiv[i]);
				if (vpsDt[i] != null)
					model.setVpsDt(vpsDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgPodHdr[i] != null)
					model.setBkgPodHdr(bkgPodHdr[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (errorDiv[i] != null)
					model.setErrorDiv(errorDiv[i]);
				if (callSgnNoOrg[i] != null)
					model.setCallSgnNoOrg(callSgnNoOrg[i]);
				if (polDiv[i] != null)
					model.setPolDiv(polDiv[i]);
				if (atdRst[i] != null)
					model.setAtdRst(atdRst[i]);
				if (delTrasmitFlag[i] != null)
					model.setDelTrasmitFlag(delTrasmitFlag[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (podDiv[i] != null)
					model.setPodDiv(podDiv[i]);
				if (vvdPodPrefix[i] != null)
					model.setVvdPodPrefix(vvdPodPrefix[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (searchDiv[i] != null)
					model.setSearchDiv(searchDiv[i]);
				if (ltDiv[i] != null)
					model.setLtDiv(ltDiv[i]);
				if (podSplitNo[i] != null)
					model.setPodSplitNo(podSplitNo[i]);
				if (ibCssmVoyNoOrg[i] != null)
					model.setIbCssmVoyNoOrg(ibCssmVoyNoOrg[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				if (polCdHdr[i] != null)
					model.setPolCdHdr(polCdHdr[i]);
				if (fnlEdiSndFlg[i] != null)
					model.setFnlEdiSndFlg(fnlEdiSndFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvdHdr[i] != null)
					model.setVvdHdr(vvdHdr[i]);
				if (pgmDiv[i] != null)
					model.setPgmDiv(pgmDiv[i]);
				if (vvdPodPostfix[i] != null)
					model.setVvdPodPostfix(vvdPodPostfix[i]);
				if (cstmsRslts[i] != null)
					model.setCstmsRslts(cstmsRslts[i]);
				if (vvdDateDiv[i] != null)
					model.setVvdDateDiv(vvdDateDiv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCargoInfoHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CargoInfoHeaderVO[]
	 */
	public CargoInfoHeaderVO[] getCargoInfoHeaderVOs(){
		CargoInfoHeaderVO[] vos = (CargoInfoHeaderVO[])models.toArray(new CargoInfoHeaderVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsnCd = this.corrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlxDiv = this.rlxDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndFlg = this.mfSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDtDiv = this.vpsDtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDt = this.vpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodHdr = this.bkgPodHdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorDiv = this.errorDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNoOrg = this.callSgnNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDiv = this.polDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdRst = this.atdRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTrasmitFlag = this.delTrasmitFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDiv = this.podDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodPrefix = this.vvdPodPrefix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDiv = this.searchDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltDiv = this.ltDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplitNo = this.podSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNoOrg = this.ibCssmVoyNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdHdr = this.polCdHdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlEdiSndFlg = this.fnlEdiSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdHdr = this.vvdHdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmDiv = this.pgmDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodPostfix = this.vvdPodPostfix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRslts = this.cstmsRslts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDateDiv = this.vvdDateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
