/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSubscriberGroupMappingVO.java
*@FileTitle : SearchSubscriberGroupMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.22 이중환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSubscriberGroupMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSubscriberGroupMappingVO> models = new ArrayList<SearchSubscriberGroupMappingVO>();
	
	/* Column Info */
	private String copExptSubscGrpNm = null;
	/* Column Info */
	private String exptTpDesc = null;
	/* Column Info */
	private String fmActNm = null;
	/* Column Info */
	private String subscGrpNtfdPtyNm = null;
	/* Column Info */
	private String copExptTpDtlDesc = null;
	/* Column Info */
	private String copExptSubscCsSeq = null;
	/* Column Info */
	private String rExptTpDtl = null;
	/* Column Info */
	private String rToAct = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String copExptTpNm = null;
	/* Column Info */
	private String rFmAct = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rExptTp = null;
	/* Column Info */
	private String toActNm = null;
	/* Column Info */
	private String rSubseqGrp = null;
	/* Column Info */
	private String rAct = null;
	/* Column Info */
	private String rUsrId = null;
	/* Column Info */
	private String rNotiPrty = null;
	/* Column Info */
	private String toActDesc = null;
	/* Column Info */
	private String copExptTpDtlNm = null;
	/* Column Info */
	private String fmActDesc = null;
	/* Column Info */
	private String rUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSubscriberGroupMappingVO() {}

	public SearchSubscriberGroupMappingVO(String ibflag, String pagerows, String copExptSubscCsSeq, String rExptTp, String copExptTpNm, String exptTpDesc, String rExptTpDtl, String copExptTpDtlNm, String copExptTpDtlDesc, String rFmAct, String fmActNm, String fmActDesc, String rToAct, String toActNm, String toActDesc, String rSubseqGrp, String copExptSubscGrpNm, String rNotiPrty, String subscGrpNtfdPtyNm, String creUsrId, String rUsrId, String rUpdDt, String rAct) {
		this.copExptSubscGrpNm = copExptSubscGrpNm;
		this.exptTpDesc = exptTpDesc;
		this.fmActNm = fmActNm;
		this.subscGrpNtfdPtyNm = subscGrpNtfdPtyNm;
		this.copExptTpDtlDesc = copExptTpDtlDesc;
		this.copExptSubscCsSeq = copExptSubscCsSeq;
		this.rExptTpDtl = rExptTpDtl;
		this.rToAct = rToAct;
		this.pagerows = pagerows;
		this.copExptTpNm = copExptTpNm;
		this.rFmAct = rFmAct;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rExptTp = rExptTp;
		this.toActNm = toActNm;
		this.rSubseqGrp = rSubseqGrp;
		this.rAct = rAct;
		this.rUsrId = rUsrId;
		this.rNotiPrty = rNotiPrty;
		this.toActDesc = toActDesc;
		this.copExptTpDtlNm = copExptTpDtlNm;
		this.fmActDesc = fmActDesc;
		this.rUpdDt = rUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cop_expt_subsc_grp_nm", getCopExptSubscGrpNm());
		this.hashColumns.put("expt_tp_desc", getExptTpDesc());
		this.hashColumns.put("fm_act_nm", getFmActNm());
		this.hashColumns.put("subsc_grp_ntfd_pty_nm", getSubscGrpNtfdPtyNm());
		this.hashColumns.put("cop_expt_tp_dtl_desc", getCopExptTpDtlDesc());
		this.hashColumns.put("cop_expt_subsc_cs_seq", getCopExptSubscCsSeq());
		this.hashColumns.put("r_expt_tp_dtl", getRExptTpDtl());
		this.hashColumns.put("r_to_act", getRToAct());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cop_expt_tp_nm", getCopExptTpNm());
		this.hashColumns.put("r_fm_act", getRFmAct());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_expt_tp", getRExptTp());
		this.hashColumns.put("to_act_nm", getToActNm());
		this.hashColumns.put("r_subseq_grp", getRSubseqGrp());
		this.hashColumns.put("r_act", getRAct());
		this.hashColumns.put("r_usr_id", getRUsrId());
		this.hashColumns.put("r_noti_prty", getRNotiPrty());
		this.hashColumns.put("to_act_desc", getToActDesc());
		this.hashColumns.put("cop_expt_tp_dtl_nm", getCopExptTpDtlNm());
		this.hashColumns.put("fm_act_desc", getFmActDesc());
		this.hashColumns.put("r_upd_dt", getRUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cop_expt_subsc_grp_nm", "copExptSubscGrpNm");
		this.hashFields.put("expt_tp_desc", "exptTpDesc");
		this.hashFields.put("fm_act_nm", "fmActNm");
		this.hashFields.put("subsc_grp_ntfd_pty_nm", "subscGrpNtfdPtyNm");
		this.hashFields.put("cop_expt_tp_dtl_desc", "copExptTpDtlDesc");
		this.hashFields.put("cop_expt_subsc_cs_seq", "copExptSubscCsSeq");
		this.hashFields.put("r_expt_tp_dtl", "rExptTpDtl");
		this.hashFields.put("r_to_act", "rToAct");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cop_expt_tp_nm", "copExptTpNm");
		this.hashFields.put("r_fm_act", "rFmAct");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_expt_tp", "rExptTp");
		this.hashFields.put("to_act_nm", "toActNm");
		this.hashFields.put("r_subseq_grp", "rSubseqGrp");
		this.hashFields.put("r_act", "rAct");
		this.hashFields.put("r_usr_id", "rUsrId");
		this.hashFields.put("r_noti_prty", "rNotiPrty");
		this.hashFields.put("to_act_desc", "toActDesc");
		this.hashFields.put("cop_expt_tp_dtl_nm", "copExptTpDtlNm");
		this.hashFields.put("fm_act_desc", "fmActDesc");
		this.hashFields.put("r_upd_dt", "rUpdDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return copExptSubscGrpNm
	 */
	public String getCopExptSubscGrpNm() {
		return this.copExptSubscGrpNm;
	}
	
	/**
	 * Column Info
	 * @return exptTpDesc
	 */
	public String getExptTpDesc() {
		return this.exptTpDesc;
	}
	
	/**
	 * Column Info
	 * @return fmActNm
	 */
	public String getFmActNm() {
		return this.fmActNm;
	}
	
	/**
	 * Column Info
	 * @return subscGrpNtfdPtyNm
	 */
	public String getSubscGrpNtfdPtyNm() {
		return this.subscGrpNtfdPtyNm;
	}
	
	/**
	 * Column Info
	 * @return copExptTpDtlDesc
	 */
	public String getCopExptTpDtlDesc() {
		return this.copExptTpDtlDesc;
	}
	
	/**
	 * Column Info
	 * @return copExptSubscCsSeq
	 */
	public String getCopExptSubscCsSeq() {
		return this.copExptSubscCsSeq;
	}
	
	/**
	 * Column Info
	 * @return rExptTpDtl
	 */
	public String getRExptTpDtl() {
		return this.rExptTpDtl;
	}
	
	/**
	 * Column Info
	 * @return rToAct
	 */
	public String getRToAct() {
		return this.rToAct;
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
	 * @return copExptTpNm
	 */
	public String getCopExptTpNm() {
		return this.copExptTpNm;
	}
	
	/**
	 * Column Info
	 * @return rFmAct
	 */
	public String getRFmAct() {
		return this.rFmAct;
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
	 * @return rExptTp
	 */
	public String getRExptTp() {
		return this.rExptTp;
	}
	
	/**
	 * Column Info
	 * @return toActNm
	 */
	public String getToActNm() {
		return this.toActNm;
	}
	
	/**
	 * Column Info
	 * @return rSubseqGrp
	 */
	public String getRSubseqGrp() {
		return this.rSubseqGrp;
	}
	
	/**
	 * Column Info
	 * @return rAct
	 */
	public String getRAct() {
		return this.rAct;
	}
	
	/**
	 * Column Info
	 * @return rUsrId
	 */
	public String getRUsrId() {
		return this.rUsrId;
	}
	
	/**
	 * Column Info
	 * @return rNotiPrty
	 */
	public String getRNotiPrty() {
		return this.rNotiPrty;
	}
	
	/**
	 * Column Info
	 * @return toActDesc
	 */
	public String getToActDesc() {
		return this.toActDesc;
	}
	
	/**
	 * Column Info
	 * @return copExptTpDtlNm
	 */
	public String getCopExptTpDtlNm() {
		return this.copExptTpDtlNm;
	}
	
	/**
	 * Column Info
	 * @return fmActDesc
	 */
	public String getFmActDesc() {
		return this.fmActDesc;
	}
	
	/**
	 * Column Info
	 * @return rUpdDt
	 */
	public String getRUpdDt() {
		return this.rUpdDt;
	}
	

	/**
	 * Column Info
	 * @param copExptSubscGrpNm
	 */
	public void setCopExptSubscGrpNm(String copExptSubscGrpNm) {
		this.copExptSubscGrpNm = copExptSubscGrpNm;
	}
	
	/**
	 * Column Info
	 * @param exptTpDesc
	 */
	public void setExptTpDesc(String exptTpDesc) {
		this.exptTpDesc = exptTpDesc;
	}
	
	/**
	 * Column Info
	 * @param fmActNm
	 */
	public void setFmActNm(String fmActNm) {
		this.fmActNm = fmActNm;
	}
	
	/**
	 * Column Info
	 * @param subscGrpNtfdPtyNm
	 */
	public void setSubscGrpNtfdPtyNm(String subscGrpNtfdPtyNm) {
		this.subscGrpNtfdPtyNm = subscGrpNtfdPtyNm;
	}
	
	/**
	 * Column Info
	 * @param copExptTpDtlDesc
	 */
	public void setCopExptTpDtlDesc(String copExptTpDtlDesc) {
		this.copExptTpDtlDesc = copExptTpDtlDesc;
	}
	
	/**
	 * Column Info
	 * @param copExptSubscCsSeq
	 */
	public void setCopExptSubscCsSeq(String copExptSubscCsSeq) {
		this.copExptSubscCsSeq = copExptSubscCsSeq;
	}
	
	/**
	 * Column Info
	 * @param rExptTpDtl
	 */
	public void setRExptTpDtl(String rExptTpDtl) {
		this.rExptTpDtl = rExptTpDtl;
	}
	
	/**
	 * Column Info
	 * @param rToAct
	 */
	public void setRToAct(String rToAct) {
		this.rToAct = rToAct;
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
	 * @param copExptTpNm
	 */
	public void setCopExptTpNm(String copExptTpNm) {
		this.copExptTpNm = copExptTpNm;
	}
	
	/**
	 * Column Info
	 * @param rFmAct
	 */
	public void setRFmAct(String rFmAct) {
		this.rFmAct = rFmAct;
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
	 * @param rExptTp
	 */
	public void setRExptTp(String rExptTp) {
		this.rExptTp = rExptTp;
	}
	
	/**
	 * Column Info
	 * @param toActNm
	 */
	public void setToActNm(String toActNm) {
		this.toActNm = toActNm;
	}
	
	/**
	 * Column Info
	 * @param rSubseqGrp
	 */
	public void setRSubseqGrp(String rSubseqGrp) {
		this.rSubseqGrp = rSubseqGrp;
	}
	
	/**
	 * Column Info
	 * @param rAct
	 */
	public void setRAct(String rAct) {
		this.rAct = rAct;
	}
	
	/**
	 * Column Info
	 * @param rUsrId
	 */
	public void setRUsrId(String rUsrId) {
		this.rUsrId = rUsrId;
	}
	
	/**
	 * Column Info
	 * @param rNotiPrty
	 */
	public void setRNotiPrty(String rNotiPrty) {
		this.rNotiPrty = rNotiPrty;
	}
	
	/**
	 * Column Info
	 * @param toActDesc
	 */
	public void setToActDesc(String toActDesc) {
		this.toActDesc = toActDesc;
	}
	
	/**
	 * Column Info
	 * @param copExptTpDtlNm
	 */
	public void setCopExptTpDtlNm(String copExptTpDtlNm) {
		this.copExptTpDtlNm = copExptTpDtlNm;
	}
	
	/**
	 * Column Info
	 * @param fmActDesc
	 */
	public void setFmActDesc(String fmActDesc) {
		this.fmActDesc = fmActDesc;
	}
	
	/**
	 * Column Info
	 * @param rUpdDt
	 */
	public void setRUpdDt(String rUpdDt) {
		this.rUpdDt = rUpdDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCopExptSubscGrpNm(JSPUtil.getParameter(request, "cop_expt_subsc_grp_nm", ""));
		setExptTpDesc(JSPUtil.getParameter(request, "expt_tp_desc", ""));
		setFmActNm(JSPUtil.getParameter(request, "fm_act_nm", ""));
		setSubscGrpNtfdPtyNm(JSPUtil.getParameter(request, "subsc_grp_ntfd_pty_nm", ""));
		setCopExptTpDtlDesc(JSPUtil.getParameter(request, "cop_expt_tp_dtl_desc", ""));
		setCopExptSubscCsSeq(JSPUtil.getParameter(request, "cop_expt_subsc_cs_seq", ""));
		setRExptTpDtl(JSPUtil.getParameter(request, "r_expt_tp_dtl", ""));
		setRToAct(JSPUtil.getParameter(request, "r_to_act", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCopExptTpNm(JSPUtil.getParameter(request, "cop_expt_tp_nm", ""));
		setRFmAct(JSPUtil.getParameter(request, "r_fm_act", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRExptTp(JSPUtil.getParameter(request, "r_expt_tp", ""));
		setToActNm(JSPUtil.getParameter(request, "to_act_nm", ""));
		setRSubseqGrp(JSPUtil.getParameter(request, "r_subseq_grp", ""));
		setRAct(JSPUtil.getParameter(request, "r_act", ""));
		setRUsrId(JSPUtil.getParameter(request, "r_usr_id", ""));
		setRNotiPrty(JSPUtil.getParameter(request, "r_noti_prty", ""));
		setToActDesc(JSPUtil.getParameter(request, "to_act_desc", ""));
		setCopExptTpDtlNm(JSPUtil.getParameter(request, "cop_expt_tp_dtl_nm", ""));
		setFmActDesc(JSPUtil.getParameter(request, "fm_act_desc", ""));
		setRUpdDt(JSPUtil.getParameter(request, "r_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSubscriberGroupMappingVO[]
	 */
	public SearchSubscriberGroupMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSubscriberGroupMappingVO[]
	 */
	public SearchSubscriberGroupMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSubscriberGroupMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] copExptSubscGrpNm = (JSPUtil.getParameter(request, prefix	+ "cop_expt_subsc_grp_nm", length));
			String[] exptTpDesc = (JSPUtil.getParameter(request, prefix	+ "expt_tp_desc", length));
			String[] fmActNm = (JSPUtil.getParameter(request, prefix	+ "fm_act_nm", length));
			String[] subscGrpNtfdPtyNm = (JSPUtil.getParameter(request, prefix	+ "subsc_grp_ntfd_pty_nm", length));
			String[] copExptTpDtlDesc = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_dtl_desc", length));
			String[] copExptSubscCsSeq = (JSPUtil.getParameter(request, prefix	+ "cop_expt_subsc_cs_seq", length));
			String[] rExptTpDtl = (JSPUtil.getParameter(request, prefix	+ "r_expt_tp_dtl", length));
			String[] rToAct = (JSPUtil.getParameter(request, prefix	+ "r_to_act", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] copExptTpNm = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_nm", length));
			String[] rFmAct = (JSPUtil.getParameter(request, prefix	+ "r_fm_act", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rExptTp = (JSPUtil.getParameter(request, prefix	+ "r_expt_tp", length));
			String[] toActNm = (JSPUtil.getParameter(request, prefix	+ "to_act_nm", length));
			String[] rSubseqGrp = (JSPUtil.getParameter(request, prefix	+ "r_subseq_grp", length));
			String[] rAct = (JSPUtil.getParameter(request, prefix	+ "r_act", length));
			String[] rUsrId = (JSPUtil.getParameter(request, prefix	+ "r_usr_id", length));
			String[] rNotiPrty = (JSPUtil.getParameter(request, prefix	+ "r_noti_prty", length));
			String[] toActDesc = (JSPUtil.getParameter(request, prefix	+ "to_act_desc", length));
			String[] copExptTpDtlNm = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_dtl_nm", length));
			String[] fmActDesc = (JSPUtil.getParameter(request, prefix	+ "fm_act_desc", length));
			String[] rUpdDt = (JSPUtil.getParameter(request, prefix	+ "r_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSubscriberGroupMappingVO();
				if (copExptSubscGrpNm[i] != null)
					model.setCopExptSubscGrpNm(copExptSubscGrpNm[i]);
				if (exptTpDesc[i] != null)
					model.setExptTpDesc(exptTpDesc[i]);
				if (fmActNm[i] != null)
					model.setFmActNm(fmActNm[i]);
				if (subscGrpNtfdPtyNm[i] != null)
					model.setSubscGrpNtfdPtyNm(subscGrpNtfdPtyNm[i]);
				if (copExptTpDtlDesc[i] != null)
					model.setCopExptTpDtlDesc(copExptTpDtlDesc[i]);
				if (copExptSubscCsSeq[i] != null)
					model.setCopExptSubscCsSeq(copExptSubscCsSeq[i]);
				if (rExptTpDtl[i] != null)
					model.setRExptTpDtl(rExptTpDtl[i]);
				if (rToAct[i] != null)
					model.setRToAct(rToAct[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (copExptTpNm[i] != null)
					model.setCopExptTpNm(copExptTpNm[i]);
				if (rFmAct[i] != null)
					model.setRFmAct(rFmAct[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rExptTp[i] != null)
					model.setRExptTp(rExptTp[i]);
				if (toActNm[i] != null)
					model.setToActNm(toActNm[i]);
				if (rSubseqGrp[i] != null)
					model.setRSubseqGrp(rSubseqGrp[i]);
				if (rAct[i] != null)
					model.setRAct(rAct[i]);
				if (rUsrId[i] != null)
					model.setRUsrId(rUsrId[i]);
				if (rNotiPrty[i] != null)
					model.setRNotiPrty(rNotiPrty[i]);
				if (toActDesc[i] != null)
					model.setToActDesc(toActDesc[i]);
				if (copExptTpDtlNm[i] != null)
					model.setCopExptTpDtlNm(copExptTpDtlNm[i]);
				if (fmActDesc[i] != null)
					model.setFmActDesc(fmActDesc[i]);
				if (rUpdDt[i] != null)
					model.setRUpdDt(rUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSubscriberGroupMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSubscriberGroupMappingVO[]
	 */
	public SearchSubscriberGroupMappingVO[] getSearchSubscriberGroupMappingVOs(){
		SearchSubscriberGroupMappingVO[] vos = (SearchSubscriberGroupMappingVO[])models.toArray(new SearchSubscriberGroupMappingVO[models.size()]);
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
		this.copExptSubscGrpNm = this.copExptSubscGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTpDesc = this.exptTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmActNm = this.fmActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscGrpNtfdPtyNm = this.subscGrpNtfdPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpDtlDesc = this.copExptTpDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptSubscCsSeq = this.copExptSubscCsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rExptTpDtl = this.rExptTpDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rToAct = this.rToAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpNm = this.copExptTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFmAct = this.rFmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rExptTp = this.rExptTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toActNm = this.toActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSubseqGrp = this.rSubseqGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rAct = this.rAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUsrId = this.rUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rNotiPrty = this.rNotiPrty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toActDesc = this.toActDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpDtlNm = this.copExptTpDtlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmActDesc = this.fmActDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUpdDt = this.rUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
