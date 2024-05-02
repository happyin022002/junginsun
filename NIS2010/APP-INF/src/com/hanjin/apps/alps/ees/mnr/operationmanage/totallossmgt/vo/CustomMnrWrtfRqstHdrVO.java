/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomMnrWrtfRqstHdrVO.java
*@FileTitle : CustomMnrWrtfRqstHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo;

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

public class CustomMnrWrtfRqstHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrWrtfRqstHdrVO> models = new ArrayList<CustomMnrWrtfRqstHdrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String wrtfRqstDt = null;
	/* Column Info */
	private String wrtfAproUsrId = null;
	/* Column Info */
	private String wrtfCfmOfcCd = null;
	/* Column Info */
	private String wrtfAproOfcCd = null;
	/* Column Info */
	private String ttlLssNo = null;
	/* Column Info */
	private String wrtfStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvrActHisRmk = null;
	/* Column Info */
	private String ttlLssDtlRsnRmk = null;
	/* Column Info */
	private String dpcCltFaldRsnRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String wrtfCfmDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wrtfRqstUsrId = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String wrtfAproDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String wrtfCfmUsrId = null;
	/* Column Info */
	private String wrtfNo = null;
	/* Column Info */
	private String wrtfRqstOfcCd = null;
	/* Column Info */
	private String subFileSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrWrtfRqstHdrVO() {}

	public CustomMnrWrtfRqstHdrVO(String ibflag, String pagerows, String wrtfNo, String wrtfStsCd, String ttlLssNo, String wrtfRqstDt, String wrtfRqstOfcCd, String wrtfRqstUsrId, String wrtfAproDt, String wrtfAproOfcCd, String wrtfAproUsrId, String wrtfCfmDt, String wrtfCfmOfcCd, String wrtfCfmUsrId, String ttlLssDtlRsnRmk, String dpcCltFaldRsnRmk, String rcvrActHisRmk, String fileSeq, String creUsrId, String creDt, String updUsrId, String updDt, String subFileSeq) {
		this.updDt = updDt;
		this.wrtfRqstDt = wrtfRqstDt;
		this.wrtfAproUsrId = wrtfAproUsrId;
		this.wrtfCfmOfcCd = wrtfCfmOfcCd;
		this.wrtfAproOfcCd = wrtfAproOfcCd;
		this.ttlLssNo = ttlLssNo;
		this.wrtfStsCd = wrtfStsCd;
		this.creDt = creDt;
		this.rcvrActHisRmk = rcvrActHisRmk;
		this.ttlLssDtlRsnRmk = ttlLssDtlRsnRmk;
		this.dpcCltFaldRsnRmk = dpcCltFaldRsnRmk;
		this.pagerows = pagerows;
		this.wrtfCfmDt = wrtfCfmDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.wrtfRqstUsrId = wrtfRqstUsrId;
		this.fileSeq = fileSeq;
		this.wrtfAproDt = wrtfAproDt;
		this.updUsrId = updUsrId;
		this.wrtfCfmUsrId = wrtfCfmUsrId;
		this.wrtfNo = wrtfNo;
		this.wrtfRqstOfcCd = wrtfRqstOfcCd;
		this.subFileSeq = subFileSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("wrtf_rqst_dt", getWrtfRqstDt());
		this.hashColumns.put("wrtf_apro_usr_id", getWrtfAproUsrId());
		this.hashColumns.put("wrtf_cfm_ofc_cd", getWrtfCfmOfcCd());
		this.hashColumns.put("wrtf_apro_ofc_cd", getWrtfAproOfcCd());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("wrtf_sts_cd", getWrtfStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcvr_act_his_rmk", getRcvrActHisRmk());
		this.hashColumns.put("ttl_lss_dtl_rsn_rmk", getTtlLssDtlRsnRmk());
		this.hashColumns.put("dpc_clt_fald_rsn_rmk", getDpcCltFaldRsnRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wrtf_cfm_dt", getWrtfCfmDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wrtf_rqst_usr_id", getWrtfRqstUsrId());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("wrtf_apro_dt", getWrtfAproDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("wrtf_cfm_usr_id", getWrtfCfmUsrId());
		this.hashColumns.put("wrtf_no", getWrtfNo());
		this.hashColumns.put("wrtf_rqst_ofc_cd", getWrtfRqstOfcCd());
		this.hashColumns.put("sub_file_seq", getSubFileSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("wrtf_rqst_dt", "wrtfRqstDt");
		this.hashFields.put("wrtf_apro_usr_id", "wrtfAproUsrId");
		this.hashFields.put("wrtf_cfm_ofc_cd", "wrtfCfmOfcCd");
		this.hashFields.put("wrtf_apro_ofc_cd", "wrtfAproOfcCd");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("wrtf_sts_cd", "wrtfStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcvr_act_his_rmk", "rcvrActHisRmk");
		this.hashFields.put("ttl_lss_dtl_rsn_rmk", "ttlLssDtlRsnRmk");
		this.hashFields.put("dpc_clt_fald_rsn_rmk", "dpcCltFaldRsnRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wrtf_cfm_dt", "wrtfCfmDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wrtf_rqst_usr_id", "wrtfRqstUsrId");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("wrtf_apro_dt", "wrtfAproDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("wrtf_cfm_usr_id", "wrtfCfmUsrId");
		this.hashFields.put("wrtf_no", "wrtfNo");
		this.hashFields.put("wrtf_rqst_ofc_cd", "wrtfRqstOfcCd");
		this.hashFields.put("sub_file_seq", "subFileSeq");
		return this.hashFields;
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
	 * @return wrtfRqstDt
	 */
	public String getWrtfRqstDt() {
		return this.wrtfRqstDt;
	}
	
	/**
	 * Column Info
	 * @return wrtfAproUsrId
	 */
	public String getWrtfAproUsrId() {
		return this.wrtfAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return wrtfCfmOfcCd
	 */
	public String getWrtfCfmOfcCd() {
		return this.wrtfCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return wrtfAproOfcCd
	 */
	public String getWrtfAproOfcCd() {
		return this.wrtfAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ttlLssNo
	 */
	public String getTtlLssNo() {
		return this.ttlLssNo;
	}
	
	/**
	 * Column Info
	 * @return wrtfStsCd
	 */
	public String getWrtfStsCd() {
		return this.wrtfStsCd;
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
	 * @return rcvrActHisRmk
	 */
	public String getRcvrActHisRmk() {
		return this.rcvrActHisRmk;
	}
	
	/**
	 * Column Info
	 * @return ttlLssDtlRsnRmk
	 */
	public String getTtlLssDtlRsnRmk() {
		return this.ttlLssDtlRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return dpcCltFaldRsnRmk
	 */
	public String getDpcCltFaldRsnRmk() {
		return this.dpcCltFaldRsnRmk;
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
	 * @return wrtfCfmDt
	 */
	public String getWrtfCfmDt() {
		return this.wrtfCfmDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return wrtfRqstUsrId
	 */
	public String getWrtfRqstUsrId() {
		return this.wrtfRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return wrtfAproDt
	 */
	public String getWrtfAproDt() {
		return this.wrtfAproDt;
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
	 * @return wrtfCfmUsrId
	 */
	public String getWrtfCfmUsrId() {
		return this.wrtfCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return wrtfNo
	 */
	public String getWrtfNo() {
		return this.wrtfNo;
	}
	
	/**
	 * Column Info
	 * @return wrtfRqstOfcCd
	 */
	public String getWrtfRqstOfcCd() {
		return this.wrtfRqstOfcCd;
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
	 * @param wrtfRqstDt
	 */
	public void setWrtfRqstDt(String wrtfRqstDt) {
		this.wrtfRqstDt = wrtfRqstDt;
	}
	
	/**
	 * Column Info
	 * @param wrtfAproUsrId
	 */
	public void setWrtfAproUsrId(String wrtfAproUsrId) {
		this.wrtfAproUsrId = wrtfAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param wrtfCfmOfcCd
	 */
	public void setWrtfCfmOfcCd(String wrtfCfmOfcCd) {
		this.wrtfCfmOfcCd = wrtfCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param wrtfAproOfcCd
	 */
	public void setWrtfAproOfcCd(String wrtfAproOfcCd) {
		this.wrtfAproOfcCd = wrtfAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ttlLssNo
	 */
	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}
	
	/**
	 * Column Info
	 * @param wrtfStsCd
	 */
	public void setWrtfStsCd(String wrtfStsCd) {
		this.wrtfStsCd = wrtfStsCd;
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
	 * @param rcvrActHisRmk
	 */
	public void setRcvrActHisRmk(String rcvrActHisRmk) {
		this.rcvrActHisRmk = rcvrActHisRmk;
	}
	
	/**
	 * Column Info
	 * @param ttlLssDtlRsnRmk
	 */
	public void setTtlLssDtlRsnRmk(String ttlLssDtlRsnRmk) {
		this.ttlLssDtlRsnRmk = ttlLssDtlRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param dpcCltFaldRsnRmk
	 */
	public void setDpcCltFaldRsnRmk(String dpcCltFaldRsnRmk) {
		this.dpcCltFaldRsnRmk = dpcCltFaldRsnRmk;
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
	 * @param wrtfCfmDt
	 */
	public void setWrtfCfmDt(String wrtfCfmDt) {
		this.wrtfCfmDt = wrtfCfmDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param wrtfRqstUsrId
	 */
	public void setWrtfRqstUsrId(String wrtfRqstUsrId) {
		this.wrtfRqstUsrId = wrtfRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param wrtfAproDt
	 */
	public void setWrtfAproDt(String wrtfAproDt) {
		this.wrtfAproDt = wrtfAproDt;
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
	 * @param wrtfCfmUsrId
	 */
	public void setWrtfCfmUsrId(String wrtfCfmUsrId) {
		this.wrtfCfmUsrId = wrtfCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param wrtfNo
	 */
	public void setWrtfNo(String wrtfNo) {
		this.wrtfNo = wrtfNo;
	}
	
	/**
	 * Column Info
	 * @param wrtfRqstOfcCd
	 */
	public void setWrtfRqstOfcCd(String wrtfRqstOfcCd) {
		this.wrtfRqstOfcCd = wrtfRqstOfcCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	public String getSubFileSeq() {
		return subFileSeq;
	}

	public void setSubFileSeq(String subFileSeq) {
		this.subFileSeq = subFileSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setWrtfRqstDt(JSPUtil.getParameter(request, prefix + "wrtf_rqst_dt", ""));
		setWrtfAproUsrId(JSPUtil.getParameter(request, prefix + "wrtf_apro_usr_id", ""));
		setWrtfCfmOfcCd(JSPUtil.getParameter(request, prefix + "wrtf_cfm_ofc_cd", ""));
		setWrtfAproOfcCd(JSPUtil.getParameter(request, prefix + "wrtf_apro_ofc_cd", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setWrtfStsCd(JSPUtil.getParameter(request, prefix + "wrtf_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRcvrActHisRmk(JSPUtil.getParameter(request, prefix + "rcvr_act_his_rmk", ""));
		setTtlLssDtlRsnRmk(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_rmk", ""));
		setDpcCltFaldRsnRmk(JSPUtil.getParameter(request, prefix + "dpc_clt_fald_rsn_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setWrtfCfmDt(JSPUtil.getParameter(request, prefix + "wrtf_cfm_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWrtfRqstUsrId(JSPUtil.getParameter(request, prefix + "wrtf_rqst_usr_id", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setWrtfAproDt(JSPUtil.getParameter(request, prefix + "wrtf_apro_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setWrtfCfmUsrId(JSPUtil.getParameter(request, prefix + "wrtf_cfm_usr_id", ""));
		setWrtfNo(JSPUtil.getParameter(request, prefix + "wrtf_no", ""));
		setWrtfRqstOfcCd(JSPUtil.getParameter(request, prefix + "wrtf_rqst_ofc_cd", ""));
		setSubFileSeq(JSPUtil.getParameter(request, prefix + "sub_file_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrWrtfRqstHdrVO[]
	 */
	public CustomMnrWrtfRqstHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrWrtfRqstHdrVO[]
	 */
	public CustomMnrWrtfRqstHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrWrtfRqstHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] wrtfRqstDt = (JSPUtil.getParameter(request, prefix	+ "wrtf_rqst_dt", length));
			String[] wrtfAproUsrId = (JSPUtil.getParameter(request, prefix	+ "wrtf_apro_usr_id", length));
			String[] wrtfCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "wrtf_cfm_ofc_cd", length));
			String[] wrtfAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "wrtf_apro_ofc_cd", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] wrtfStsCd = (JSPUtil.getParameter(request, prefix	+ "wrtf_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvrActHisRmk = (JSPUtil.getParameter(request, prefix	+ "rcvr_act_his_rmk", length));
			String[] ttlLssDtlRsnRmk = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_rmk", length));
			String[] dpcCltFaldRsnRmk = (JSPUtil.getParameter(request, prefix	+ "dpc_clt_fald_rsn_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] wrtfCfmDt = (JSPUtil.getParameter(request, prefix	+ "wrtf_cfm_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wrtfRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "wrtf_rqst_usr_id", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] wrtfAproDt = (JSPUtil.getParameter(request, prefix	+ "wrtf_apro_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] wrtfCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "wrtf_cfm_usr_id", length));
			String[] wrtfNo = (JSPUtil.getParameter(request, prefix	+ "wrtf_no", length));
			String[] wrtfRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "wrtf_rqst_ofc_cd", length));
			String[] subFileSeq = (JSPUtil.getParameter(request, prefix	+ "sub_file_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrWrtfRqstHdrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (wrtfRqstDt[i] != null)
					model.setWrtfRqstDt(wrtfRqstDt[i]);
				if (wrtfAproUsrId[i] != null)
					model.setWrtfAproUsrId(wrtfAproUsrId[i]);
				if (wrtfCfmOfcCd[i] != null)
					model.setWrtfCfmOfcCd(wrtfCfmOfcCd[i]);
				if (wrtfAproOfcCd[i] != null)
					model.setWrtfAproOfcCd(wrtfAproOfcCd[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (wrtfStsCd[i] != null)
					model.setWrtfStsCd(wrtfStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvrActHisRmk[i] != null)
					model.setRcvrActHisRmk(rcvrActHisRmk[i]);
				if (ttlLssDtlRsnRmk[i] != null)
					model.setTtlLssDtlRsnRmk(ttlLssDtlRsnRmk[i]);
				if (dpcCltFaldRsnRmk[i] != null)
					model.setDpcCltFaldRsnRmk(dpcCltFaldRsnRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (wrtfCfmDt[i] != null)
					model.setWrtfCfmDt(wrtfCfmDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wrtfRqstUsrId[i] != null)
					model.setWrtfRqstUsrId(wrtfRqstUsrId[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (wrtfAproDt[i] != null)
					model.setWrtfAproDt(wrtfAproDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (wrtfCfmUsrId[i] != null)
					model.setWrtfCfmUsrId(wrtfCfmUsrId[i]);
				if (wrtfNo[i] != null)
					model.setWrtfNo(wrtfNo[i]);
				if (wrtfRqstOfcCd[i] != null)
					model.setWrtfRqstOfcCd(wrtfRqstOfcCd[i]);
				if (subFileSeq[i] != null)
					model.setSubFileSeq(subFileSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrWrtfRqstHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrWrtfRqstHdrVO[]
	 */
	public CustomMnrWrtfRqstHdrVO[] getCustomMnrWrtfRqstHdrVOs(){
		CustomMnrWrtfRqstHdrVO[] vos = (CustomMnrWrtfRqstHdrVO[])models.toArray(new CustomMnrWrtfRqstHdrVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfRqstDt = this.wrtfRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfAproUsrId = this.wrtfAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCfmOfcCd = this.wrtfCfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfAproOfcCd = this.wrtfAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfStsCd = this.wrtfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrActHisRmk = this.rcvrActHisRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnRmk = this.ttlLssDtlRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcCltFaldRsnRmk = this.dpcCltFaldRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCfmDt = this.wrtfCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfRqstUsrId = this.wrtfRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfAproDt = this.wrtfAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCfmUsrId = this.wrtfCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfNo = this.wrtfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfRqstOfcCd = this.wrtfRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subFileSeq = this.subFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
