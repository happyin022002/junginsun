/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurManifestTransmitVO.java
*@FileTitle : EurManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.30
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.30 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurManifestTransmitVO> models = new ArrayList<EurManifestTransmitVO>();
	
	/* Column Info */
	private String pOriAmdCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String tvvdCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String modeType = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String receiverId = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bPodCd = null;
	/* Column Info */
	private String bkgSpeAk = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String uvi = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String bkgSpeBb = null;
	/* Column Info */
	private String searchPodCd = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgSpeDg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bPolCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String bkgSpeRf = null;
	/* Column Info */
	private String callType = null;
	/* Column Info */
	private String apRef = null;
	/* Column Info */
	private String msgAckRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurManifestTransmitVO() {}

	public EurManifestTransmitVO(String ibflag, String pagerows, String vvdCd, String polCd, String podCd, String receiverId, String uvi, String bkgNo, String bkgCgoTp, String bkgSpeRf, String bkgSpeDg, String bkgSpeAk, String bkgSpeBb, String cmdtDesc, String cmdtCd, String ofcCd, String callType, String delCd, String porCd, String blNo, String bkgStsCd, String bkgOfcCd, String bndCd, String tvvdCd, String bPolCd, String bPodCd, String cntrCd, String pOriAmdCd, String searchPodCd, String podYdCd, String polYdCd, String modeType
								, String apRef, String msgAckRefNo) {
		this.pOriAmdCd = pOriAmdCd;
		this.porCd = porCd;
		this.tvvdCd = tvvdCd;
		this.bkgStsCd = bkgStsCd;
		this.modeType = modeType;
		this.blNo = blNo;
		this.cntrCd = cntrCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.receiverId = receiverId;
		this.cmdtCd = cmdtCd;
		this.bPodCd = bPodCd;
		this.bkgSpeAk = bkgSpeAk;
		this.podYdCd = podYdCd;
		this.uvi = uvi;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgCgoTp = bkgCgoTp;
		this.bkgSpeBb = bkgSpeBb;
		this.searchPodCd = searchPodCd;
		this.bndCd = bndCd;
		this.delCd = delCd;
		this.bkgSpeDg = bkgSpeDg;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.bPolCd = bPolCd;
		this.cmdtDesc = cmdtDesc;
		this.polYdCd = polYdCd;
		this.bkgSpeRf = bkgSpeRf;
		this.callType = callType;
		this.apRef = apRef;
		this.msgAckRefNo = msgAckRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_ori_amd_cd", getPOriAmdCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("tvvd_cd", getTvvdCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("mode_type", getModeType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_cd", getCntrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("receiver_id", getReceiverId());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("b_pod_cd", getBPodCd());
		this.hashColumns.put("bkg_spe_ak", getBkgSpeAk());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("uvi", getUvi());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("bkg_spe_bb", getBkgSpeBb());
		this.hashColumns.put("search_pod_cd", getSearchPodCd());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_spe_dg", getBkgSpeDg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("b_pol_cd", getBPolCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("bkg_spe_rf", getBkgSpeRf());
		this.hashColumns.put("call_type", getCallType());
		this.hashColumns.put("ap_ref", getApRef());
		this.hashColumns.put("msg_ack_ref_no", getMsgAckRefNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_ori_amd_cd", "pOriAmdCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("tvvd_cd", "tvvdCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("mode_type", "modeType");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_cd", "cntrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("receiver_id", "receiverId");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("b_pod_cd", "bPodCd");
		this.hashFields.put("bkg_spe_ak", "bkgSpeAk");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("uvi", "uvi");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("bkg_spe_bb", "bkgSpeBb");
		this.hashFields.put("search_pod_cd", "searchPodCd");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_spe_dg", "bkgSpeDg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("b_pol_cd", "bPolCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("bkg_spe_rf", "bkgSpeRf");
		this.hashFields.put("call_type", "callType");
		this.hashFields.put("ap_ref", "apRef");
		this.hashFields.put("msg_ack_ref_no", "msgAckRefNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pOriAmdCd
	 */
	public String getPOriAmdCd() {
		return this.pOriAmdCd;
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
	 * @return tvvdCd
	 */
	public String getTvvdCd() {
		return this.tvvdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return modeType
	 */
	public String getModeType() {
		return this.modeType;
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
	 * @return cntrCd
	 */
	public String getCntrCd() {
		return this.cntrCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return receiverId
	 */
	public String getReceiverId() {
		return this.receiverId;
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
	 * @return bPodCd
	 */
	public String getBPodCd() {
		return this.bPodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeAk
	 */
	public String getBkgSpeAk() {
		return this.bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return uvi
	 */
	public String getUvi() {
		return this.uvi;
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
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeBb
	 */
	public String getBkgSpeBb() {
		return this.bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @return searchPodCd
	 */
	public String getSearchPodCd() {
		return this.searchPodCd;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
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
	 * @return bkgSpeDg
	 */
	public String getBkgSpeDg() {
		return this.bkgSpeDg;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bPolCd
	 */
	public String getBPolCd() {
		return this.bPolCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeRf
	 */
	public String getBkgSpeRf() {
		return this.bkgSpeRf;
	}
	
	/**
	 * Column Info
	 * @return callType
	 */
	public String getCallType() {
		return this.callType;
	}
	
	/**
	 * Column Info
	 * @return apRef
	 */
	public String getApRef() {
		return this.apRef;
	}
	
	/**
	 * Column Info
	 * @return msgAckRefNo
	 */
	public String getMsgAckRefNo() {
		return this.msgAckRefNo;
	}
	
	/**
	 * Column Info
	 * @param pOriAmdCd
	 */
	public void setPOriAmdCd(String pOriAmdCd) {
		this.pOriAmdCd = pOriAmdCd;
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
	 * @param tvvdCd
	 */
	public void setTvvdCd(String tvvdCd) {
		this.tvvdCd = tvvdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param modeType
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
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
	 * @param cntrCd
	 */
	public void setCntrCd(String cntrCd) {
		this.cntrCd = cntrCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param receiverId
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
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
	 * @param bPodCd
	 */
	public void setBPodCd(String bPodCd) {
		this.bPodCd = bPodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeAk
	 */
	public void setBkgSpeAk(String bkgSpeAk) {
		this.bkgSpeAk = bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param uvi
	 */
	public void setUvi(String uvi) {
		this.uvi = uvi;
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
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeBb
	 */
	public void setBkgSpeBb(String bkgSpeBb) {
		this.bkgSpeBb = bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @param searchPodCd
	 */
	public void setSearchPodCd(String searchPodCd) {
		this.searchPodCd = searchPodCd;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
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
	 * @param bkgSpeDg
	 */
	public void setBkgSpeDg(String bkgSpeDg) {
		this.bkgSpeDg = bkgSpeDg;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bPolCd
	 */
	public void setBPolCd(String bPolCd) {
		this.bPolCd = bPolCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeRf
	 */
	public void setBkgSpeRf(String bkgSpeRf) {
		this.bkgSpeRf = bkgSpeRf;
	}
	
	/**
	 * Column Info
	 * @param callType
	 */
	public void setCallType(String callType) {
		this.callType = callType;
	}
	
	/**
	 * Column Info
	 * @param apRef
	 */
	public void setApRef(String apRef) {
		this.apRef = apRef;
	}
	
	/**
	 * Column Info
	 * @param msgAckRefNo
	 */
	public void setMsgAckRefNo(String msgAckRefNo) {
		this.msgAckRefNo = msgAckRefNo;
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
		setPOriAmdCd(JSPUtil.getParameter(request, prefix + "p_ori_amd_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTvvdCd(JSPUtil.getParameter(request, prefix + "tvvd_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setModeType(JSPUtil.getParameter(request, prefix + "mode_type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrCd(JSPUtil.getParameter(request, prefix + "cntr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setReceiverId(JSPUtil.getParameter(request, prefix + "receiver_id", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBPodCd(JSPUtil.getParameter(request, prefix + "b_pod_cd", ""));
		setBkgSpeAk(JSPUtil.getParameter(request, prefix + "bkg_spe_ak", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setUvi(JSPUtil.getParameter(request, prefix + "uvi", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp", ""));
		setBkgSpeBb(JSPUtil.getParameter(request, prefix + "bkg_spe_bb", ""));
		setSearchPodCd(JSPUtil.getParameter(request, prefix + "search_pod_cd", ""));
		setBndCd(JSPUtil.getParameter(request, prefix + "bnd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgSpeDg(JSPUtil.getParameter(request, prefix + "bkg_spe_dg", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBPolCd(JSPUtil.getParameter(request, prefix + "b_pol_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setBkgSpeRf(JSPUtil.getParameter(request, prefix + "bkg_spe_rf", ""));
		setCallType(JSPUtil.getParameter(request, prefix + "call_type", ""));
		setApRef(JSPUtil.getParameter(request, prefix + "ap_ref", ""));
		setMsgAckRefNo(JSPUtil.getParameter(request, prefix + "msg_ack_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurManifestTransmitVO[]
	 */
	public EurManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurManifestTransmitVO[]
	 */
	public EurManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pOriAmdCd = (JSPUtil.getParameter(request, prefix	+ "p_ori_amd_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] tvvdCd = (JSPUtil.getParameter(request, prefix	+ "tvvd_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] modeType = (JSPUtil.getParameter(request, prefix	+ "mode_type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrCd = (JSPUtil.getParameter(request, prefix	+ "cntr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] receiverId = (JSPUtil.getParameter(request, prefix	+ "receiver_id", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bPodCd = (JSPUtil.getParameter(request, prefix	+ "b_pod_cd", length));
			String[] bkgSpeAk = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_ak", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] uvi = (JSPUtil.getParameter(request, prefix	+ "uvi", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] bkgSpeBb = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_bb", length));
			String[] searchPodCd = (JSPUtil.getParameter(request, prefix	+ "search_pod_cd", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgSpeDg = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_dg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bPolCd = (JSPUtil.getParameter(request, prefix	+ "b_pol_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] bkgSpeRf = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rf", length));
			String[] callType = (JSPUtil.getParameter(request, prefix	+ "call_type", length));
			String[] apRef = (JSPUtil.getParameter(request, prefix	+ "ap_ref", length));
			String[] msgAckRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_ack_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurManifestTransmitVO();
				if (pOriAmdCd[i] != null)
					model.setPOriAmdCd(pOriAmdCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (tvvdCd[i] != null)
					model.setTvvdCd(tvvdCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (modeType[i] != null)
					model.setModeType(modeType[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrCd[i] != null)
					model.setCntrCd(cntrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (receiverId[i] != null)
					model.setReceiverId(receiverId[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bPodCd[i] != null)
					model.setBPodCd(bPodCd[i]);
				if (bkgSpeAk[i] != null)
					model.setBkgSpeAk(bkgSpeAk[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (uvi[i] != null)
					model.setUvi(uvi[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (bkgSpeBb[i] != null)
					model.setBkgSpeBb(bkgSpeBb[i]);
				if (searchPodCd[i] != null)
					model.setSearchPodCd(searchPodCd[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgSpeDg[i] != null)
					model.setBkgSpeDg(bkgSpeDg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bPolCd[i] != null)
					model.setBPolCd(bPolCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (bkgSpeRf[i] != null)
					model.setBkgSpeRf(bkgSpeRf[i]);
				if (callType[i] != null)
					model.setCallType(callType[i]);
				if (apRef[i] != null)
					model.setApRef(apRef[i]);
				if (msgAckRefNo[i] != null)
					model.setMsgAckRefNo(msgAckRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurManifestTransmitVO[]
	 */
	public EurManifestTransmitVO[] getEurManifestTransmitVOs(){
		EurManifestTransmitVO[] vos = (EurManifestTransmitVO[])models.toArray(new EurManifestTransmitVO[models.size()]);
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
		this.pOriAmdCd = this.pOriAmdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvdCd = this.tvvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeType = this.modeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCd = this.cntrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverId = this.receiverId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPodCd = this.bPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeAk = this.bkgSpeAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uvi = this.uvi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeBb = this.bkgSpeBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchPodCd = this.searchPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeDg = this.bkgSpeDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPolCd = this.bPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRf = this.bkgSpeRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callType = this.callType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRef = this.apRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckRefNo = this.msgAckRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
