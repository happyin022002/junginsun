/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : CargoInfoHeaderVO.java
*@FileTitle : CargoInfoHeaderVO
*Open Issues :
*Change history :
*	2017.09.07 하대성 delCd, delReason, tCmrKind Column Add
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2014.03.07 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CargoInfoHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CargoInfoHeaderVO> models = new ArrayList<CargoInfoHeaderVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String rlxDiv = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfSndFlg = null;
	/* Column Info */
	private String vpsDt = null;
	/* Column Info */
	private String vpsDtDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String errorDiv = null;
	/* Column Info */
	private String podPostfix = null;
	/* Column Info */
	private String polDiv = null;
	/* Column Info */
	private String atdRst = null;
	/* Column Info */
	private String delTrasmitFlag = null;
	/* Column Info */
	private String delNewTrasmitFlag = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String searchDiv = null;
	/* Column Info */
	private String podSplitNo = null;
	/* Column Info */
	private String ltDiv = null;
	/* Column Info */
	private String polCdHdr = null;
	/* Column Info */
	private String polSplitNo = null;
	/* Column Info */
	private String podPrefix = null;
	/* Column Info */
	private String fnlEdiSndFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vvdHdr = null;
	/* Column Info */
	private String cstmsRslts = null;
	/* Column Info */
	private String vvdDateDiv = null;
	/* Column Info */	
	private String delCd = null;
	/* Column Info */	
	private String delReason = null;
	/* Column Info */	
	private String tCmrKind = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CargoInfoHeaderVO() {}

	public CargoInfoHeaderVO(String ibflag, String pagerows, String delTrasmitFlag, String delNewTrasmitFlag, String vvdDateDiv, String vvdHdr, String searchDiv, String errorDiv, String callSgnNo, String vpsDtDiv, String dateFm, String dateTo, String polDiv, String polCdHdr, String polSplitNo, String podPrefix, String podPostfix, String podSplitNo, String bkgOfcCd, String ltDiv, String blNo, String cstmsRslts, String docUsrId, String mfSndFlg, String fnlEdiSndFlg, String vvd, String vpsDt, String polCd, String podCd, String rcvDt, String atdRst, String rlxDiv, String usrId, String delCd, String delReason, String tCmrKind) {
		this.dateFm = dateFm;
		this.docUsrId = docUsrId;
		this.rlxDiv = rlxDiv;
		this.blNo = blNo;
		this.mfSndFlg = mfSndFlg;
		this.vpsDt = vpsDt;
		this.vpsDtDiv = vpsDtDiv;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.rcvDt = rcvDt;
		this.errorDiv = errorDiv;
		this.podPostfix = podPostfix;
		this.polDiv = polDiv;
		this.atdRst = atdRst;
		this.delTrasmitFlag = delTrasmitFlag;
		this.delNewTrasmitFlag = delNewTrasmitFlag;
		this.bkgOfcCd = bkgOfcCd;
		this.dateTo = dateTo;
		this.callSgnNo = callSgnNo;
		this.searchDiv = searchDiv;
		this.podSplitNo = podSplitNo;
		this.ltDiv = ltDiv;
		this.polCdHdr = polCdHdr;
		this.polSplitNo = polSplitNo;
		this.podPrefix = podPrefix;
		this.fnlEdiSndFlg = fnlEdiSndFlg;
		this.podCd = podCd;
		this.vvd = vvd;
		this.vvdHdr = vvdHdr;
		this.cstmsRslts = cstmsRslts;
		this.vvdDateDiv = vvdDateDiv;
		this.delCd = delCd;
		this.delReason = delReason;
		this.tCmrKind = tCmrKind;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("rlx_div", getRlxDiv());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_snd_flg", getMfSndFlg());
		this.hashColumns.put("vps_dt", getVpsDt());
		this.hashColumns.put("vps_dt_div", getVpsDtDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("error_div", getErrorDiv());
		this.hashColumns.put("pod_postfix", getPodPostfix());
		this.hashColumns.put("pol_div", getPolDiv());
		this.hashColumns.put("atd_rst", getAtdRst());
		this.hashColumns.put("del_trasmit_flag", getDelTrasmitFlag());
		this.hashColumns.put("del_new_trasmit_flag", getDelNewTrasmitFlag());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("search_div", getSearchDiv());
		this.hashColumns.put("pod_split_no", getPodSplitNo());
		this.hashColumns.put("lt_div", getLtDiv());
		this.hashColumns.put("pol_cd_hdr", getPolCdHdr());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		this.hashColumns.put("pod_prefix", getPodPrefix());
		this.hashColumns.put("fnl_edi_snd_flg", getFnlEdiSndFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vvd_hdr", getVvdHdr());
		this.hashColumns.put("cstms_rslts", getCstmsRslts());
		this.hashColumns.put("vvd_date_div", getVvdDateDiv());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("del_reason", getDelReason());
		this.hashColumns.put("t_cmr_kind", getTCmrKind());
		 
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("rlx_div", "rlxDiv");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_snd_flg", "mfSndFlg");
		this.hashFields.put("vps_dt", "vpsDt");
		this.hashFields.put("vps_dt_div", "vpsDtDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("error_div", "errorDiv");
		this.hashFields.put("pod_postfix", "podPostfix");
		this.hashFields.put("pol_div", "polDiv");
		this.hashFields.put("atd_rst", "atdRst");
		this.hashFields.put("del_trasmit_flag", "delTrasmitFlag");
		this.hashFields.put("del_new_trasmit_flag", "delNewTrasmitFlag");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("search_div", "searchDiv");
		this.hashFields.put("pod_split_no", "podSplitNo");
		this.hashFields.put("lt_div", "ltDiv");
		this.hashFields.put("pol_cd_hdr", "polCdHdr");
		this.hashFields.put("pol_split_no", "polSplitNo");
		this.hashFields.put("pod_prefix", "podPrefix");
		this.hashFields.put("fnl_edi_snd_flg", "fnlEdiSndFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vvd_hdr", "vvdHdr");
		this.hashFields.put("cstms_rslts", "cstmsRslts");
		this.hashFields.put("vvd_date_div", "vvdDateDiv");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("del_reason", "delReason");
		this.hashFields.put("t_cmr_kind", "tCmrKind");
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
	 * @return vpsDt
	 */
	public String getVpsDt() {
		return this.vpsDt;
	}
	
	/**
	 * Column Info
	 * @return vpsDtDiv
	 */
	public String getVpsDtDiv() {
		return this.vpsDtDiv;
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
	 * @return podPostfix
	 */
	public String getPodPostfix() {
		return this.podPostfix;
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
	 * @return delNewTrasmitFlag
	 */
	public String getDelNewTrasmitFlag() {
		return this.delNewTrasmitFlag;
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
	 * @return searchDiv
	 */
	public String getSearchDiv() {
		return this.searchDiv;
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
	 * @return ltDiv
	 */
	public String getLtDiv() {
		return this.ltDiv;
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
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
	}
	
	/**
	 * Column Info
	 * @return podPrefix
	 */
	public String getPodPrefix() {
		return this.podPrefix;
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
	 * @return vvdHdr
	 */
	public String getVvdHdr() {
		return this.vvdHdr;
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
	 * @return delCd
	 */	
	public String getDelCd() {
		return this.delCd;
	}

	/**
	 * Column Info
	 * @return delReason
	 */		
	public String getDelReason() {
		return this.delReason;
	}

	/**
	 * Column Info
	 * @return tCmrKind
	 */		
	public String getTCmrKind() {
		return this.tCmrKind;
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
	 * @param vpsDt
	 */
	public void setVpsDt(String vpsDt) {
		this.vpsDt = vpsDt;
	}
	
	/**
	 * Column Info
	 * @param vpsDtDiv
	 */
	public void setVpsDtDiv(String vpsDtDiv) {
		this.vpsDtDiv = vpsDtDiv;
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
	 * @param podPostfix
	 */
	public void setPodPostfix(String podPostfix) {
		this.podPostfix = podPostfix;
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
	 * @param delNewTrasmitFlag
	 */
	public void setDelNewTrasmitFlag(String delNewTrasmitFlag) {
		this.delNewTrasmitFlag = delNewTrasmitFlag;
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
	 * @param searchDiv
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
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
	 * @param ltDiv
	 */
	public void setLtDiv(String ltDiv) {
		this.ltDiv = ltDiv;
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
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * Column Info
	 * @param podPrefix
	 */
	public void setPodPrefix(String podPrefix) {
		this.podPrefix = podPrefix;
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
	 * @param vvdHdr
	 */
	public void setVvdHdr(String vvdHdr) {
		this.vvdHdr = vvdHdr;
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
	 * Column Info
	 * @return delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * @return delReason
	 */
	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}
	
	/**
	 * Column Info
	 * @return delReason
	 */
	public void setTCmrKind(String tCmrKind) {
		this.tCmrKind = tCmrKind;
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
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setRlxDiv(JSPUtil.getParameter(request, prefix + "rlx_div", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMfSndFlg(JSPUtil.getParameter(request, prefix + "mf_snd_flg", ""));
		setVpsDt(JSPUtil.getParameter(request, prefix + "vps_dt", ""));
		setVpsDtDiv(JSPUtil.getParameter(request, prefix + "vps_dt_div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setErrorDiv(JSPUtil.getParameter(request, prefix + "error_div", ""));
		setPodPostfix(JSPUtil.getParameter(request, prefix + "pod_postfix", ""));
		setPolDiv(JSPUtil.getParameter(request, prefix + "pol_div", ""));
		setAtdRst(JSPUtil.getParameter(request, prefix + "atd_rst", ""));
		setDelTrasmitFlag(JSPUtil.getParameter(request, prefix + "del_trasmit_flag", ""));
		setDelNewTrasmitFlag(JSPUtil.getParameter(request, prefix + "del_new_trasmit_flag", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setSearchDiv(JSPUtil.getParameter(request, prefix + "search_div", ""));
		setPodSplitNo(JSPUtil.getParameter(request, prefix + "pod_split_no", ""));
		setLtDiv(JSPUtil.getParameter(request, prefix + "lt_div", ""));
		setPolCdHdr(JSPUtil.getParameter(request, prefix + "pol_cd_hdr", ""));
		setPolSplitNo(JSPUtil.getParameter(request, prefix + "pol_split_no", ""));
		setPodPrefix(JSPUtil.getParameter(request, prefix + "pod_prefix", ""));
		setFnlEdiSndFlg(JSPUtil.getParameter(request, prefix + "fnl_edi_snd_flg", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVvdHdr(JSPUtil.getParameter(request, prefix + "vvd_hdr", ""));
		setCstmsRslts(JSPUtil.getParameter(request, prefix + "cstms_rslts", ""));
		setVvdDateDiv(JSPUtil.getParameter(request, prefix + "vvd_date_div", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDelReason(JSPUtil.getParameter(request, prefix + "del_reason", ""));
		setTCmrKind(JSPUtil.getParameter(request, prefix + "t_cmr_kind", ""));
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
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] rlxDiv = (JSPUtil.getParameter(request, prefix	+ "rlx_div", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mfSndFlg = (JSPUtil.getParameter(request, prefix	+ "mf_snd_flg", length));
			String[] vpsDt = (JSPUtil.getParameter(request, prefix	+ "vps_dt", length));
			String[] vpsDtDiv = (JSPUtil.getParameter(request, prefix	+ "vps_dt_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] errorDiv = (JSPUtil.getParameter(request, prefix	+ "error_div", length));
			String[] podPostfix = (JSPUtil.getParameter(request, prefix	+ "pod_postfix", length));
			String[] polDiv = (JSPUtil.getParameter(request, prefix	+ "pol_div", length));
			String[] atdRst = (JSPUtil.getParameter(request, prefix	+ "atd_rst", length));
			String[] delTrasmitFlag = (JSPUtil.getParameter(request, prefix	+ "del_trasmit_flag", length));
			String[] delNewTrasmitFlag = (JSPUtil.getParameter(request, prefix	+ "del_new_trasmit_flag", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] searchDiv = (JSPUtil.getParameter(request, prefix	+ "search_div", length));
			String[] podSplitNo = (JSPUtil.getParameter(request, prefix	+ "pod_split_no", length));
			String[] ltDiv = (JSPUtil.getParameter(request, prefix	+ "lt_div", length));
			String[] polCdHdr = (JSPUtil.getParameter(request, prefix	+ "pol_cd_hdr", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			String[] podPrefix = (JSPUtil.getParameter(request, prefix	+ "pod_prefix", length));
			String[] fnlEdiSndFlg = (JSPUtil.getParameter(request, prefix	+ "fnl_edi_snd_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vvdHdr = (JSPUtil.getParameter(request, prefix	+ "vvd_hdr", length));
			String[] cstmsRslts = (JSPUtil.getParameter(request, prefix	+ "cstms_rslts", length));
			String[] vvdDateDiv = (JSPUtil.getParameter(request, prefix	+ "vvd_date_div", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));		
			String[] delReason = (JSPUtil.getParameter(request, prefix + "del_reason", length));
			String[] tCmrKind = (JSPUtil.getParameter(request, prefix + "t_cmr_kind", length));
			
			for (int i = 0; i < length; i++) {
				model = new CargoInfoHeaderVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (rlxDiv[i] != null)
					model.setRlxDiv(rlxDiv[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfSndFlg[i] != null)
					model.setMfSndFlg(mfSndFlg[i]);
				if (vpsDt[i] != null)
					model.setVpsDt(vpsDt[i]);
				if (vpsDtDiv[i] != null)
					model.setVpsDtDiv(vpsDtDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (errorDiv[i] != null)
					model.setErrorDiv(errorDiv[i]);
				if (podPostfix[i] != null)
					model.setPodPostfix(podPostfix[i]);
				if (polDiv[i] != null)
					model.setPolDiv(polDiv[i]);
				if (atdRst[i] != null)
					model.setAtdRst(atdRst[i]);
				if (delTrasmitFlag[i] != null)
					model.setDelTrasmitFlag(delTrasmitFlag[i]);
				if (delNewTrasmitFlag[i] != null)
					model.setDelNewTrasmitFlag(delNewTrasmitFlag[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (searchDiv[i] != null)
					model.setSearchDiv(searchDiv[i]);
				if (podSplitNo[i] != null)
					model.setPodSplitNo(podSplitNo[i]);
				if (ltDiv[i] != null)
					model.setLtDiv(ltDiv[i]);
				if (polCdHdr[i] != null)
					model.setPolCdHdr(polCdHdr[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				if (podPrefix[i] != null)
					model.setPodPrefix(podPrefix[i]);
				if (fnlEdiSndFlg[i] != null)
					model.setFnlEdiSndFlg(fnlEdiSndFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vvdHdr[i] != null)
					model.setVvdHdr(vvdHdr[i]);
				if (cstmsRslts[i] != null)
					model.setCstmsRslts(cstmsRslts[i]);
				if (vvdDateDiv[i] != null)
					model.setVvdDateDiv(vvdDateDiv[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (delReason[i] != null)
					model.setDelReason(delReason[i]);
				if (tCmrKind[i] != null)
					model.setTCmrKind(tCmrKind[i]);
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
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlxDiv = this.rlxDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndFlg = this.mfSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDt = this.vpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDtDiv = this.vpsDtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorDiv = this.errorDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPostfix = this.podPostfix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDiv = this.polDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdRst = this.atdRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTrasmitFlag = this.delTrasmitFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNewTrasmitFlag = this.delNewTrasmitFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDiv = this.searchDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplitNo = this.podSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltDiv = this.ltDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdHdr = this.polCdHdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPrefix = this.podPrefix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlEdiSndFlg = this.fnlEdiSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdHdr = this.vvdHdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRslts = this.cstmsRslts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDateDiv = this.vvdDateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delReason = this.delReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCmrKind = this.tCmrKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
