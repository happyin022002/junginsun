/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndCstmsTrsmRsltVO.java
*@FileTitle : CndCstmsTrsmRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.24 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsTrsmRsltVO extends CstmsTrsmRsltVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsTrsmRsltVO> models = new ArrayList<CndCstmsTrsmRsltVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String cstmsAckRjctMsg = null;
	/* Column Info */
	private String cstmsFileTpCd = null;
	/* Column Info */
	private String sentByA6a = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unmanifest = null;
	/* Column Info */
	private String errTpCtnt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ackDesc = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String errCdDesc = null;
	/* Column Info */
	private String cstmsAckRcvRsltCd = null;
	/* Column Info */
	private String cstmsAckProcRsltCd = null;
	/* Column Info */
	private String cstmsAckRcvDt = null;
	/* Column Info */
	private String error = null;
	/* Column Info */
	private String amdtSndDt = null;
	/* Column Info */
	private String cstmsTrsmStsCd = null;
	/* Column Info */
	private String resultDesc = null;
	/* Column Info */
	private String targetTtl = null;
	/* Column Info */
	private String cstmsTrsmStsDesc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String processed = null;
	/* Column Info */
	private String cstmsAckRjctCd = null;
	/* Column Info */
	private String sentByAl = null;
	/* Column Info */
	private String manifestTtl = null;
	/* Column Info */
	private String fullMtyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsTrsmRsltVO() {}

	public CndCstmsTrsmRsltVO(String ibflag, String pagerows, String vvdCd, String polCd, String podCd, String blNo, String cstmsFileTpCd, String cstmsTrsmStsCd, String mfStsCd, String cstmsAckRcvRsltCd, String cstmsAckProcRsltCd, String fullMtyCd, String amdtSndDt, String cstmsAckRcvDt, String cstmsAckRjctCd, String cstmsAckRjctMsg, String ackDesc, String resultDesc, String cstmsTrsmStsDesc, String errCdDesc, String errTpCtnt, String manifestTtl, String sentByA6a, String sentByAl, String targetTtl, String unmanifest, String total, String processed, String error) {
		this.total = total;
		this.cstmsAckRjctMsg = cstmsAckRjctMsg;
		this.cstmsFileTpCd = cstmsFileTpCd;
		this.sentByA6a = sentByA6a;
		this.blNo = blNo;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.unmanifest = unmanifest;
		this.errTpCtnt = errTpCtnt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ackDesc = ackDesc;
		this.vvdCd = vvdCd;
		this.errCdDesc = errCdDesc;
		this.cstmsAckRcvRsltCd = cstmsAckRcvRsltCd;
		this.cstmsAckProcRsltCd = cstmsAckProcRsltCd;
		this.cstmsAckRcvDt = cstmsAckRcvDt;
		this.error = error;
		this.amdtSndDt = amdtSndDt;
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
		this.resultDesc = resultDesc;
		this.targetTtl = targetTtl;
		this.cstmsTrsmStsDesc = cstmsTrsmStsDesc;
		this.podCd = podCd;
		this.processed = processed;
		this.cstmsAckRjctCd = cstmsAckRjctCd;
		this.sentByAl = sentByAl;
		this.manifestTtl = manifestTtl;
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("cstms_ack_rjct_msg", getCstmsAckRjctMsg());
		this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
		this.hashColumns.put("sent_by_a6a", getSentByA6a());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("unmanifest", getUnmanifest());
		this.hashColumns.put("err_tp_ctnt", getErrTpCtnt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ack_desc", getAckDesc());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("err_cd_desc", getErrCdDesc());
		this.hashColumns.put("cstms_ack_rcv_rslt_cd", getCstmsAckRcvRsltCd());
		this.hashColumns.put("cstms_ack_proc_rslt_cd", getCstmsAckProcRsltCd());
		this.hashColumns.put("cstms_ack_rcv_dt", getCstmsAckRcvDt());
		this.hashColumns.put("error", getError());
		this.hashColumns.put("amdt_snd_dt", getAmdtSndDt());
		this.hashColumns.put("cstms_trsm_sts_cd", getCstmsTrsmStsCd());
		this.hashColumns.put("result_desc", getResultDesc());
		this.hashColumns.put("target_ttl", getTargetTtl());
		this.hashColumns.put("cstms_trsm_sts_desc", getCstmsTrsmStsDesc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("processed", getProcessed());
		this.hashColumns.put("cstms_ack_rjct_cd", getCstmsAckRjctCd());
		this.hashColumns.put("sent_by_al", getSentByAl());
		this.hashColumns.put("manifest_ttl", getManifestTtl());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("cstms_ack_rjct_msg", "cstmsAckRjctMsg");
		this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
		this.hashFields.put("sent_by_a6a", "sentByA6a");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("unmanifest", "unmanifest");
		this.hashFields.put("err_tp_ctnt", "errTpCtnt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ack_desc", "ackDesc");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("err_cd_desc", "errCdDesc");
		this.hashFields.put("cstms_ack_rcv_rslt_cd", "cstmsAckRcvRsltCd");
		this.hashFields.put("cstms_ack_proc_rslt_cd", "cstmsAckProcRsltCd");
		this.hashFields.put("cstms_ack_rcv_dt", "cstmsAckRcvDt");
		this.hashFields.put("error", "error");
		this.hashFields.put("amdt_snd_dt", "amdtSndDt");
		this.hashFields.put("cstms_trsm_sts_cd", "cstmsTrsmStsCd");
		this.hashFields.put("result_desc", "resultDesc");
		this.hashFields.put("target_ttl", "targetTtl");
		this.hashFields.put("cstms_trsm_sts_desc", "cstmsTrsmStsDesc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("processed", "processed");
		this.hashFields.put("cstms_ack_rjct_cd", "cstmsAckRjctCd");
		this.hashFields.put("sent_by_al", "sentByAl");
		this.hashFields.put("manifest_ttl", "manifestTtl");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckRjctMsg
	 */
	public String getCstmsAckRjctMsg() {
		return this.cstmsAckRjctMsg;
	}
	
	/**
	 * Column Info
	 * @return cstmsFileTpCd
	 */
	public String getCstmsFileTpCd() {
		return this.cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return sentByA6a
	 */
	public String getSentByA6a() {
		return this.sentByA6a;
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
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @return unmanifest
	 */
	public String getUnmanifest() {
		return this.unmanifest;
	}
	
	/**
	 * Column Info
	 * @return errTpCtnt
	 */
	public String getErrTpCtnt() {
		return this.errTpCtnt;
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
	 * @return ackDesc
	 */
	public String getAckDesc() {
		return this.ackDesc;
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
	 * @return errCdDesc
	 */
	public String getErrCdDesc() {
		return this.errCdDesc;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckRcvRsltCd
	 */
	public String getCstmsAckRcvRsltCd() {
		return this.cstmsAckRcvRsltCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckProcRsltCd
	 */
	public String getCstmsAckProcRsltCd() {
		return this.cstmsAckProcRsltCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckRcvDt
	 */
	public String getCstmsAckRcvDt() {
		return this.cstmsAckRcvDt;
	}
	
	/**
	 * Column Info
	 * @return error
	 */
	public String getError() {
		return this.error;
	}
	
	/**
	 * Column Info
	 * @return amdtSndDt
	 */
	public String getAmdtSndDt() {
		return this.amdtSndDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsTrsmStsCd
	 */
	public String getCstmsTrsmStsCd() {
		return this.cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @return resultDesc
	 */
	public String getResultDesc() {
		return this.resultDesc;
	}
	
	/**
	 * Column Info
	 * @return targetTtl
	 */
	public String getTargetTtl() {
		return this.targetTtl;
	}
	
	/**
	 * Column Info
	 * @return cstmsTrsmStsDesc
	 */
	public String getCstmsTrsmStsDesc() {
		return this.cstmsTrsmStsDesc;
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
	 * @return processed
	 */
	public String getProcessed() {
		return this.processed;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckRjctCd
	 */
	public String getCstmsAckRjctCd() {
		return this.cstmsAckRjctCd;
	}
	
	/**
	 * Column Info
	 * @return sentByAl
	 */
	public String getSentByAl() {
		return this.sentByAl;
	}
	
	/**
	 * Column Info
	 * @return manifestTtl
	 */
	public String getManifestTtl() {
		return this.manifestTtl;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckRjctMsg
	 */
	public void setCstmsAckRjctMsg(String cstmsAckRjctMsg) {
		this.cstmsAckRjctMsg = cstmsAckRjctMsg;
	}
	
	/**
	 * Column Info
	 * @param cstmsFileTpCd
	 */
	public void setCstmsFileTpCd(String cstmsFileTpCd) {
		this.cstmsFileTpCd = cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param sentByA6a
	 */
	public void setSentByA6a(String sentByA6a) {
		this.sentByA6a = sentByA6a;
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
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
	 * @param unmanifest
	 */
	public void setUnmanifest(String unmanifest) {
		this.unmanifest = unmanifest;
	}
	
	/**
	 * Column Info
	 * @param errTpCtnt
	 */
	public void setErrTpCtnt(String errTpCtnt) {
		this.errTpCtnt = errTpCtnt;
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
	 * @param ackDesc
	 */
	public void setAckDesc(String ackDesc) {
		this.ackDesc = ackDesc;
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
	 * @param errCdDesc
	 */
	public void setErrCdDesc(String errCdDesc) {
		this.errCdDesc = errCdDesc;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckRcvRsltCd
	 */
	public void setCstmsAckRcvRsltCd(String cstmsAckRcvRsltCd) {
		this.cstmsAckRcvRsltCd = cstmsAckRcvRsltCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckProcRsltCd
	 */
	public void setCstmsAckProcRsltCd(String cstmsAckProcRsltCd) {
		this.cstmsAckProcRsltCd = cstmsAckProcRsltCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckRcvDt
	 */
	public void setCstmsAckRcvDt(String cstmsAckRcvDt) {
		this.cstmsAckRcvDt = cstmsAckRcvDt;
	}
	
	/**
	 * Column Info
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * Column Info
	 * @param amdtSndDt
	 */
	public void setAmdtSndDt(String amdtSndDt) {
		this.amdtSndDt = amdtSndDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsTrsmStsCd
	 */
	public void setCstmsTrsmStsCd(String cstmsTrsmStsCd) {
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @param resultDesc
	 */
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	
	/**
	 * Column Info
	 * @param targetTtl
	 */
	public void setTargetTtl(String targetTtl) {
		this.targetTtl = targetTtl;
	}
	
	/**
	 * Column Info
	 * @param cstmsTrsmStsDesc
	 */
	public void setCstmsTrsmStsDesc(String cstmsTrsmStsDesc) {
		this.cstmsTrsmStsDesc = cstmsTrsmStsDesc;
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
	 * @param processed
	 */
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckRjctCd
	 */
	public void setCstmsAckRjctCd(String cstmsAckRjctCd) {
		this.cstmsAckRjctCd = cstmsAckRjctCd;
	}
	
	/**
	 * Column Info
	 * @param sentByAl
	 */
	public void setSentByAl(String sentByAl) {
		this.sentByAl = sentByAl;
	}
	
	/**
	 * Column Info
	 * @param manifestTtl
	 */
	public void setManifestTtl(String manifestTtl) {
		this.manifestTtl = manifestTtl;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setCstmsAckRjctMsg(JSPUtil.getParameter(request, prefix + "cstms_ack_rjct_msg", ""));
		setCstmsFileTpCd(JSPUtil.getParameter(request, prefix + "cstms_file_tp_cd", ""));
		setSentByA6a(JSPUtil.getParameter(request, prefix + "sent_by_a6a", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUnmanifest(JSPUtil.getParameter(request, prefix + "unmanifest", ""));
		setErrTpCtnt(JSPUtil.getParameter(request, prefix + "err_tp_ctnt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAckDesc(JSPUtil.getParameter(request, prefix + "ack_desc", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setErrCdDesc(JSPUtil.getParameter(request, prefix + "err_cd_desc", ""));
		setCstmsAckRcvRsltCd(JSPUtil.getParameter(request, prefix + "cstms_ack_rcv_rslt_cd", ""));
		setCstmsAckProcRsltCd(JSPUtil.getParameter(request, prefix + "cstms_ack_proc_rslt_cd", ""));
		setCstmsAckRcvDt(JSPUtil.getParameter(request, prefix + "cstms_ack_rcv_dt", ""));
		setError(JSPUtil.getParameter(request, prefix + "error", ""));
		setAmdtSndDt(JSPUtil.getParameter(request, prefix + "amdt_snd_dt", ""));
		setCstmsTrsmStsCd(JSPUtil.getParameter(request, prefix + "cstms_trsm_sts_cd", ""));
		setResultDesc(JSPUtil.getParameter(request, prefix + "result_desc", ""));
		setTargetTtl(JSPUtil.getParameter(request, prefix + "target_ttl", ""));
		setCstmsTrsmStsDesc(JSPUtil.getParameter(request, prefix + "cstms_trsm_sts_desc", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setProcessed(JSPUtil.getParameter(request, prefix + "processed", ""));
		setCstmsAckRjctCd(JSPUtil.getParameter(request, prefix + "cstms_ack_rjct_cd", ""));
		setSentByAl(JSPUtil.getParameter(request, prefix + "sent_by_al", ""));
		setManifestTtl(JSPUtil.getParameter(request, prefix + "manifest_ttl", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsTrsmRsltVO[]
	 */
	public CndCstmsTrsmRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsTrsmRsltVO[]
	 */
	public CndCstmsTrsmRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsTrsmRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] cstmsAckRjctMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_rjct_msg", length));
			String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_tp_cd", length));
			String[] sentByA6a = (JSPUtil.getParameter(request, prefix	+ "sent_by_a6a", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unmanifest = (JSPUtil.getParameter(request, prefix	+ "unmanifest", length));
			String[] errTpCtnt = (JSPUtil.getParameter(request, prefix	+ "err_tp_ctnt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ackDesc = (JSPUtil.getParameter(request, prefix	+ "ack_desc", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] errCdDesc = (JSPUtil.getParameter(request, prefix	+ "err_cd_desc", length));
			String[] cstmsAckRcvRsltCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_rcv_rslt_cd", length));
			String[] cstmsAckProcRsltCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_proc_rslt_cd", length));
			String[] cstmsAckRcvDt = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_rcv_dt", length));
			String[] error = (JSPUtil.getParameter(request, prefix	+ "error", length));
			String[] amdtSndDt = (JSPUtil.getParameter(request, prefix	+ "amdt_snd_dt", length));
			String[] cstmsTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_trsm_sts_cd", length));
			String[] resultDesc = (JSPUtil.getParameter(request, prefix	+ "result_desc", length));
			String[] targetTtl = (JSPUtil.getParameter(request, prefix	+ "target_ttl", length));
			String[] cstmsTrsmStsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_trsm_sts_desc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] processed = (JSPUtil.getParameter(request, prefix	+ "processed", length));
			String[] cstmsAckRjctCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_rjct_cd", length));
			String[] sentByAl = (JSPUtil.getParameter(request, prefix	+ "sent_by_al", length));
			String[] manifestTtl = (JSPUtil.getParameter(request, prefix	+ "manifest_ttl", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsTrsmRsltVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (cstmsAckRjctMsg[i] != null)
					model.setCstmsAckRjctMsg(cstmsAckRjctMsg[i]);
				if (cstmsFileTpCd[i] != null)
					model.setCstmsFileTpCd(cstmsFileTpCd[i]);
				if (sentByA6a[i] != null)
					model.setSentByA6a(sentByA6a[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unmanifest[i] != null)
					model.setUnmanifest(unmanifest[i]);
				if (errTpCtnt[i] != null)
					model.setErrTpCtnt(errTpCtnt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ackDesc[i] != null)
					model.setAckDesc(ackDesc[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (errCdDesc[i] != null)
					model.setErrCdDesc(errCdDesc[i]);
				if (cstmsAckRcvRsltCd[i] != null)
					model.setCstmsAckRcvRsltCd(cstmsAckRcvRsltCd[i]);
				if (cstmsAckProcRsltCd[i] != null)
					model.setCstmsAckProcRsltCd(cstmsAckProcRsltCd[i]);
				if (cstmsAckRcvDt[i] != null)
					model.setCstmsAckRcvDt(cstmsAckRcvDt[i]);
				if (error[i] != null)
					model.setError(error[i]);
				if (amdtSndDt[i] != null)
					model.setAmdtSndDt(amdtSndDt[i]);
				if (cstmsTrsmStsCd[i] != null)
					model.setCstmsTrsmStsCd(cstmsTrsmStsCd[i]);
				if (resultDesc[i] != null)
					model.setResultDesc(resultDesc[i]);
				if (targetTtl[i] != null)
					model.setTargetTtl(targetTtl[i]);
				if (cstmsTrsmStsDesc[i] != null)
					model.setCstmsTrsmStsDesc(cstmsTrsmStsDesc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (processed[i] != null)
					model.setProcessed(processed[i]);
				if (cstmsAckRjctCd[i] != null)
					model.setCstmsAckRjctCd(cstmsAckRjctCd[i]);
				if (sentByAl[i] != null)
					model.setSentByAl(sentByAl[i]);
				if (manifestTtl[i] != null)
					model.setManifestTtl(manifestTtl[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsTrsmRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsTrsmRsltVO[]
	 */
	public CndCstmsTrsmRsltVO[] getCndCstmsTrsmRsltVOs(){
		CndCstmsTrsmRsltVO[] vos = (CndCstmsTrsmRsltVO[])models.toArray(new CndCstmsTrsmRsltVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckRjctMsg = this.cstmsAckRjctMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFileTpCd = this.cstmsFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentByA6a = this.sentByA6a .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmanifest = this.unmanifest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errTpCtnt = this.errTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDesc = this.ackDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCdDesc = this.errCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckRcvRsltCd = this.cstmsAckRcvRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckProcRsltCd = this.cstmsAckProcRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckRcvDt = this.cstmsAckRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.error = this.error .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSndDt = this.amdtSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsTrsmStsCd = this.cstmsTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultDesc = this.resultDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetTtl = this.targetTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsTrsmStsDesc = this.cstmsTrsmStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.processed = this.processed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckRjctCd = this.cstmsAckRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentByAl = this.sentByAl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manifestTtl = this.manifestTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
