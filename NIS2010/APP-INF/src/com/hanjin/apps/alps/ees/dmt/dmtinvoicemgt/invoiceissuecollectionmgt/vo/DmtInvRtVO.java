/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtInvRtVO.java
*@FileTitle : DmtInvRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.13 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtInvRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtInvRtVO> models = new ArrayList<DmtInvRtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rtOvrChgAmt = null;
	/* Column Info */
	private String invRtAmt = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String bzcTrfRtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bzcCurrCd = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oldDmtInvNo = null;
	/* Column Info */
	private String invRtSeq = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtOvrDys = null;
	/* Column Info */
	private String bzcDmdtTrfCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String bzcTrfGrpSeq = null;
	/* Column Info */
	private String bzcTrfSeq = null;
	/* Column Info */
	private String ftUndDys = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Number */
	private String bzcDmdtDeTermCd = null;
	/* Column Number */
	private String bzcDmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtInvRtVO() {}

	public DmtInvRtVO(String ibflag, String pagerows, String dmdtInvNo, String creOfcCd, String invDtlSeq, String invRtSeq, String svrId, String bzcDmdtTrfCd, String bzcTrfSeq, String bzcTrfGrpSeq, String bzcTrfRtSeq, String ftOvrDys, String ftUndDys, String invRtAmt, String rtOvrDys, String rtOvrChgAmt, String bzcCurrCd, String creUsrId, String creDt, String updUsrId, String updDt, String updOfcCd, String oldDmtInvNo, String bzcDmdtDeTermCd, String bzcDmdtDeTermNm) {
		this.updDt = updDt;
		this.rtOvrChgAmt = rtOvrChgAmt;
		this.invRtAmt = invRtAmt;
		this.dmdtInvNo = dmdtInvNo;
		this.bzcTrfRtSeq = bzcTrfRtSeq;
		this.creDt = creDt;
		this.bzcCurrCd = bzcCurrCd;
		this.ftOvrDys = ftOvrDys;
		this.pagerows = pagerows;
		this.oldDmtInvNo = oldDmtInvNo;
		this.invRtSeq = invRtSeq;
		this.svrId = svrId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rtOvrDys = rtOvrDys;
		this.bzcDmdtTrfCd = bzcDmdtTrfCd;
		this.creOfcCd = creOfcCd;
		this.invDtlSeq = invDtlSeq;
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
		this.bzcTrfSeq = bzcTrfSeq;
		this.ftUndDys = ftUndDys;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rt_ovr_chg_amt", getRtOvrChgAmt());
		this.hashColumns.put("inv_rt_amt", getInvRtAmt());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("bzc_trf_rt_seq", getBzcTrfRtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bzc_curr_cd", getBzcCurrCd());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_dmt_inv_no", getOldDmtInvNo());
		this.hashColumns.put("inv_rt_seq", getInvRtSeq());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_ovr_dys", getRtOvrDys());
		this.hashColumns.put("bzc_dmdt_trf_cd", getBzcDmdtTrfCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("bzc_trf_grp_seq", getBzcTrfGrpSeq());
		this.hashColumns.put("bzc_trf_seq", getBzcTrfSeq());
		this.hashColumns.put("ft_und_dys", getFtUndDys());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bzc_dmdt_de_term_cd", getBzcDmdtDeTermCd());
		this.hashColumns.put("bzc_dmdt_de_term_nm", getBzcDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rt_ovr_chg_amt", "rtOvrChgAmt");
		this.hashFields.put("inv_rt_amt", "invRtAmt");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("bzc_trf_rt_seq", "bzcTrfRtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bzc_curr_cd", "bzcCurrCd");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_dmt_inv_no", "oldDmtInvNo");
		this.hashFields.put("inv_rt_seq", "invRtSeq");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_ovr_dys", "rtOvrDys");
		this.hashFields.put("bzc_dmdt_trf_cd", "bzcDmdtTrfCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("bzc_trf_grp_seq", "bzcTrfGrpSeq");
		this.hashFields.put("bzc_trf_seq", "bzcTrfSeq");
		this.hashFields.put("ft_und_dys", "ftUndDys");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bzc_dmdt_de_term_cd", "bzcDmdtDeTermCd");
		this.hashFields.put("bzc_dmdt_de_term_nm", "bzcDmdtDeTermNm");
		
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
	 * @return rtOvrChgAmt
	 */
	public String getRtOvrChgAmt() {
		return this.rtOvrChgAmt;
	}
	
	/**
	 * Column Info
	 * @return invRtAmt
	 */
	public String getInvRtAmt() {
		return this.invRtAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfRtSeq
	 */
	public String getBzcTrfRtSeq() {
		return this.bzcTrfRtSeq;
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
	 * @return bzcCurrCd
	 */
	public String getBzcCurrCd() {
		return this.bzcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ftOvrDys
	 */
	public String getFtOvrDys() {
		return this.ftOvrDys;
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
	 * @return oldDmtInvNo
	 */
	public String getOldDmtInvNo() {
		return this.oldDmtInvNo;
	}
	
	/**
	 * Column Info
	 * @return invRtSeq
	 */
	public String getInvRtSeq() {
		return this.invRtSeq;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return rtOvrDys
	 */
	public String getRtOvrDys() {
		return this.rtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return bzcDmdtTrfCd
	 */
	public String getBzcDmdtTrfCd() {
		return this.bzcDmdtTrfCd;
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
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfGrpSeq
	 */
	public String getBzcTrfGrpSeq() {
		return this.bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfSeq
	 */
	public String getBzcTrfSeq() {
		return this.bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return ftUndDys
	 */
	public String getFtUndDys() {
		return this.ftUndDys;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return bzcDmdtDeTermCd
	 */
	public String getBzcDmdtDeTermCd() {
		return this.bzcDmdtDeTermCd;
	}

	/**
	 * Column Info
	 * @return bzcDmdtDeTermNm
	 */
	public String getBzcDmdtDeTermNm() {
		return this.bzcDmdtDeTermNm;
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
	 * @param rtOvrChgAmt
	 */
	public void setRtOvrChgAmt(String rtOvrChgAmt) {
		this.rtOvrChgAmt = rtOvrChgAmt;
	}
	
	/**
	 * Column Info
	 * @param invRtAmt
	 */
	public void setInvRtAmt(String invRtAmt) {
		this.invRtAmt = invRtAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfRtSeq
	 */
	public void setBzcTrfRtSeq(String bzcTrfRtSeq) {
		this.bzcTrfRtSeq = bzcTrfRtSeq;
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
	 * @param bzcCurrCd
	 */
	public void setBzcCurrCd(String bzcCurrCd) {
		this.bzcCurrCd = bzcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ftOvrDys
	 */
	public void setFtOvrDys(String ftOvrDys) {
		this.ftOvrDys = ftOvrDys;
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
	 * @param oldDmtInvNo
	 */
	public void setOldDmtInvNo(String oldDmtInvNo) {
		this.oldDmtInvNo = oldDmtInvNo;
	}
	
	/**
	 * Column Info
	 * @param invRtSeq
	 */
	public void setInvRtSeq(String invRtSeq) {
		this.invRtSeq = invRtSeq;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param rtOvrDys
	 */
	public void setRtOvrDys(String rtOvrDys) {
		this.rtOvrDys = rtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param bzcDmdtTrfCd
	 */
	public void setBzcDmdtTrfCd(String bzcDmdtTrfCd) {
		this.bzcDmdtTrfCd = bzcDmdtTrfCd;
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
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfGrpSeq
	 */
	public void setBzcTrfGrpSeq(String bzcTrfGrpSeq) {
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfSeq
	 */
	public void setBzcTrfSeq(String bzcTrfSeq) {
		this.bzcTrfSeq = bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param ftUndDys
	 */
	public void setFtUndDys(String ftUndDys) {
		this.ftUndDys = ftUndDys;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param bzcDmdtDeTermCd
	 */
	public void setBzcDmdtDeTermCd(String bzcDmdtDeTermCd) {
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param bzcDmdtDeTermNm
	 */
	public void setBzcDmdtDeTermNm(String bzcDmdtDeTermNm) {
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRtOvrChgAmt(JSPUtil.getParameter(request, "rt_ovr_chg_amt", ""));
		setInvRtAmt(JSPUtil.getParameter(request, "inv_rt_amt", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, "dmdt_inv_no", ""));
		setBzcTrfRtSeq(JSPUtil.getParameter(request, "bzc_trf_rt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBzcCurrCd(JSPUtil.getParameter(request, "bzc_curr_cd", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOldDmtInvNo(JSPUtil.getParameter(request, "old_dmt_inv_no", ""));
		setInvRtSeq(JSPUtil.getParameter(request, "inv_rt_seq", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRtOvrDys(JSPUtil.getParameter(request, "rt_ovr_dys", ""));
		setBzcDmdtTrfCd(JSPUtil.getParameter(request, "bzc_dmdt_trf_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setBzcTrfGrpSeq(JSPUtil.getParameter(request, "bzc_trf_grp_seq", ""));
		setBzcTrfSeq(JSPUtil.getParameter(request, "bzc_trf_seq", ""));
		setFtUndDys(JSPUtil.getParameter(request, "ft_und_dys", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setBzcDmdtDeTermCd(JSPUtil.getParameter(request, "bzc_dmdt_de_term_cd", ""));
		setBzcDmdtDeTermNm(JSPUtil.getParameter(request, "bzc_dmdt_de_term_nm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtInvRtVO[]
	 */
	public DmtInvRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtInvRtVO[]
	 */
	public DmtInvRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtInvRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rtOvrChgAmt = (JSPUtil.getParameter(request, prefix	+ "rt_ovr_chg_amt", length));
			String[] invRtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_rt_amt", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] bzcTrfRtSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_rt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bzcCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_curr_cd", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldDmtInvNo = (JSPUtil.getParameter(request, prefix	+ "old_dmt_inv_no", length));
			String[] invRtSeq = (JSPUtil.getParameter(request, prefix	+ "inv_rt_seq", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtOvrDys = (JSPUtil.getParameter(request, prefix	+ "rt_ovr_dys", length));
			String[] bzcDmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_trf_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] bzcTrfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_grp_seq", length));
			String[] bzcTrfSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_seq", length));
			String[] ftUndDys = (JSPUtil.getParameter(request, prefix	+ "ft_und_dys", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bzcDmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_cd", length));
			String[] bzcDmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtInvRtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rtOvrChgAmt[i] != null)
					model.setRtOvrChgAmt(rtOvrChgAmt[i]);
				if (invRtAmt[i] != null)
					model.setInvRtAmt(invRtAmt[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (bzcTrfRtSeq[i] != null)
					model.setBzcTrfRtSeq(bzcTrfRtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bzcCurrCd[i] != null)
					model.setBzcCurrCd(bzcCurrCd[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldDmtInvNo[i] != null)
					model.setOldDmtInvNo(oldDmtInvNo[i]);
				if (invRtSeq[i] != null)
					model.setInvRtSeq(invRtSeq[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtOvrDys[i] != null)
					model.setRtOvrDys(rtOvrDys[i]);
				if (bzcDmdtTrfCd[i] != null)
					model.setBzcDmdtTrfCd(bzcDmdtTrfCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (bzcTrfGrpSeq[i] != null)
					model.setBzcTrfGrpSeq(bzcTrfGrpSeq[i]);
				if (bzcTrfSeq[i] != null)
					model.setBzcTrfSeq(bzcTrfSeq[i]);
				if (ftUndDys[i] != null)
					model.setFtUndDys(ftUndDys[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bzcDmdtDeTermCd[i] != null)
					model.setBzcDmdtDeTermCd(bzcDmdtDeTermCd[i]);
				if (bzcDmdtDeTermNm[i] != null)
					model.setBzcDmdtDeTermNm(bzcDmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtInvRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtInvRtVO[]
	 */
	public DmtInvRtVO[] getDmtInvRtVOs(){
		DmtInvRtVO[] vos = (DmtInvRtVO[])models.toArray(new DmtInvRtVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOvrChgAmt = this.rtOvrChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRtAmt = this.invRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfRtSeq = this.bzcTrfRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcCurrCd = this.bzcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDmtInvNo = this.oldDmtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRtSeq = this.invRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOvrDys = this.rtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtTrfCd = this.bzcDmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfGrpSeq = this.bzcTrfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfSeq = this.bzcTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftUndDys = this.ftUndDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermCd = this.bzcDmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermNm = this.bzcDmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
