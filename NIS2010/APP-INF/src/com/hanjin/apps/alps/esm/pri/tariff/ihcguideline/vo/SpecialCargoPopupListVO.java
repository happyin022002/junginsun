/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoPopupListVO.java
*@FileTitle : SpecialCargoPopupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.18
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.07.18 서미진 
* 1.0 Creation
* 2013.08.06 전윤주 [CHM-201326196] Overweight Fixed AMT 를 Local curr. 금액 그대로 IF 하는 컬럼 추가
*                    locl_curr_cd, locl_ovr_wgt_rt_amt 컬럼 추가
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpecialCargoPopupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpecialCargoPopupListVO> models = new ArrayList<SpecialCargoPopupListVO>();
	
	/* Column Info */
	private String ovrWgtRtAmt = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String dgRtRto = null;
	/* Column Info */
	private String rcSvcFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String prcTrspModCdNm = null;
	/* Column Info */
	private String dgFltPctTpCd = null;
	/* Column Info */
	private String rfRtRto = null;
	/* Column Info */
	private String ovrWgtFltPctTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcInlndTrfCntrTpszCd = null;
	/* Column Info */
	private String rfFltPctTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrWgtRtRto = null;
	/* Column Info */
	private String minCgoWgt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String dcgoSvcFlg = null;
	/* Column Info */
	private String dgRtAmt = null;
	/* Column Info */
	private String ovrWgtCgoSvcFlg = null;
	/* Column Info */
	private String rfRtAmt = null;
	/* Column Info */
	private String maxCgoWgt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String loclOvrWgtRtAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpecialCargoPopupListVO() {}

	public SpecialCargoPopupListVO(String ibflag, String pagerows, String svcScpCd, String ihcTrfNo, String prcTrspModCd, String prcTrspModCdNm, String prcInlndTrfCntrTpszCd, String rfFltPctTpCd, String rfRtAmt, String rfRtRto, String dgFltPctTpCd, String dgRtAmt, String dgRtRto, String minCgoWgt, String maxCgoWgt, String loclCurrCd, String loclOvrWgtRtAmt, String ovrWgtFltPctTpCd, String ovrWgtRtAmt, String ovrWgtRtRto, String rcSvcFlg, String dcgoSvcFlg, String ovrWgtCgoSvcFlg) {
		this.ovrWgtRtAmt = ovrWgtRtAmt;
		this.ihcTrfNo = ihcTrfNo;
		this.dgRtRto = dgRtRto;
		this.rcSvcFlg = rcSvcFlg;
		this.svcScpCd = svcScpCd;
		this.prcTrspModCdNm = prcTrspModCdNm;
		this.dgFltPctTpCd = dgFltPctTpCd;
		this.rfRtRto = rfRtRto;
		this.ovrWgtFltPctTpCd = ovrWgtFltPctTpCd;
		this.pagerows = pagerows;
		this.prcInlndTrfCntrTpszCd = prcInlndTrfCntrTpszCd;
		this.rfFltPctTpCd = rfFltPctTpCd;
		this.ibflag = ibflag;
		this.ovrWgtRtRto = ovrWgtRtRto;
		this.minCgoWgt = minCgoWgt;
		this.prcTrspModCd = prcTrspModCd;
		this.dcgoSvcFlg = dcgoSvcFlg;
		this.dgRtAmt = dgRtAmt;
		this.ovrWgtCgoSvcFlg = ovrWgtCgoSvcFlg;
		this.rfRtAmt = rfRtAmt;
		this.maxCgoWgt = maxCgoWgt;
		this.loclCurrCd = loclCurrCd;
		this.loclOvrWgtRtAmt = loclOvrWgtRtAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_wgt_rt_amt", getOvrWgtRtAmt());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("dg_rt_rto", getDgRtRto());
		this.hashColumns.put("rc_svc_flg", getRcSvcFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prc_trsp_mod_cd_nm", getPrcTrspModCdNm());
		this.hashColumns.put("dg_flt_pct_tp_cd", getDgFltPctTpCd());
		this.hashColumns.put("rf_rt_rto", getRfRtRto());
		this.hashColumns.put("ovr_wgt_flt_pct_tp_cd", getOvrWgtFltPctTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_inlnd_trf_cntr_tpsz_cd", getPrcInlndTrfCntrTpszCd());
		this.hashColumns.put("rf_flt_pct_tp_cd", getRfFltPctTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_wgt_rt_rto", getOvrWgtRtRto());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("dcgo_svc_flg", getDcgoSvcFlg());
		this.hashColumns.put("dg_rt_amt", getDgRtAmt());
		this.hashColumns.put("ovr_wgt_cgo_svc_flg", getOvrWgtCgoSvcFlg());
		this.hashColumns.put("rf_rt_amt", getRfRtAmt());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("locl_ovr_wgt_rt_amt", getLoclOvrWgtRtAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_wgt_rt_amt", "ovrWgtRtAmt");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("dg_rt_rto", "dgRtRto");
		this.hashFields.put("rc_svc_flg", "rcSvcFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prc_trsp_mod_cd_nm", "prcTrspModCdNm");
		this.hashFields.put("dg_flt_pct_tp_cd", "dgFltPctTpCd");
		this.hashFields.put("rf_rt_rto", "rfRtRto");
		this.hashFields.put("ovr_wgt_flt_pct_tp_cd", "ovrWgtFltPctTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_inlnd_trf_cntr_tpsz_cd", "prcInlndTrfCntrTpszCd");
		this.hashFields.put("rf_flt_pct_tp_cd", "rfFltPctTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_wgt_rt_rto", "ovrWgtRtRto");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("dcgo_svc_flg", "dcgoSvcFlg");
		this.hashFields.put("dg_rt_amt", "dgRtAmt");
		this.hashFields.put("ovr_wgt_cgo_svc_flg", "ovrWgtCgoSvcFlg");
		this.hashFields.put("rf_rt_amt", "rfRtAmt");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("locl_ovr_wgt_rt_amt", "loclOvrWgtRtAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtRtAmt
	 */
	public String getOvrWgtRtAmt() {
		return this.ovrWgtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @return dgRtRto
	 */
	public String getDgRtRto() {
		return this.dgRtRto;
	}
	
	/**
	 * Column Info
	 * @return rcSvcFlg
	 */
	public String getRcSvcFlg() {
		return this.rcSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCdNm
	 */
	public String getPrcTrspModCdNm() {
		return this.prcTrspModCdNm;
	}
	
	/**
	 * Column Info
	 * @return dgFltPctTpCd
	 */
	public String getDgFltPctTpCd() {
		return this.dgFltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfRtRto
	 */
	public String getRfRtRto() {
		return this.rfRtRto;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtFltPctTpCd
	 */
	public String getOvrWgtFltPctTpCd() {
		return this.ovrWgtFltPctTpCd;
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
	 * @return prcInlndTrfCntrTpszCd
	 */
	public String getPrcInlndTrfCntrTpszCd() {
		return this.prcInlndTrfCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rfFltPctTpCd
	 */
	public String getRfFltPctTpCd() {
		return this.rfFltPctTpCd;
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
	 * @return ovrWgtRtRto
	 */
	public String getOvrWgtRtRto() {
		return this.ovrWgtRtRto;
	}
	
	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public String getMinCgoWgt() {
		return this.minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoSvcFlg
	 */
	public String getDcgoSvcFlg() {
		return this.dcgoSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return dgRtAmt
	 */
	public String getDgRtAmt() {
		return this.dgRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtCgoSvcFlg
	 */
	public String getOvrWgtCgoSvcFlg() {
		return this.ovrWgtCgoSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return rfRtAmt
	 */
	public String getRfRtAmt() {
		return this.rfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public String getMaxCgoWgt() {
		return this.maxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return loclOvrWgtRtAmt
	 */
	public String getLoclOvrWgtRtAmt() {
		return this.loclOvrWgtRtAmt;
	}
	

	/**
	 * Column Info
	 * @param ovrWgtRtAmt
	 */
	public void setOvrWgtRtAmt(String ovrWgtRtAmt) {
		this.ovrWgtRtAmt = ovrWgtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @param dgRtRto
	 */
	public void setDgRtRto(String dgRtRto) {
		this.dgRtRto = dgRtRto;
	}
	
	/**
	 * Column Info
	 * @param rcSvcFlg
	 */
	public void setRcSvcFlg(String rcSvcFlg) {
		this.rcSvcFlg = rcSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCdNm
	 */
	public void setPrcTrspModCdNm(String prcTrspModCdNm) {
		this.prcTrspModCdNm = prcTrspModCdNm;
	}
	
	/**
	 * Column Info
	 * @param dgFltPctTpCd
	 */
	public void setDgFltPctTpCd(String dgFltPctTpCd) {
		this.dgFltPctTpCd = dgFltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfRtRto
	 */
	public void setRfRtRto(String rfRtRto) {
		this.rfRtRto = rfRtRto;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtFltPctTpCd
	 */
	public void setOvrWgtFltPctTpCd(String ovrWgtFltPctTpCd) {
		this.ovrWgtFltPctTpCd = ovrWgtFltPctTpCd;
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
	 * @param prcInlndTrfCntrTpszCd
	 */
	public void setPrcInlndTrfCntrTpszCd(String prcInlndTrfCntrTpszCd) {
		this.prcInlndTrfCntrTpszCd = prcInlndTrfCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rfFltPctTpCd
	 */
	public void setRfFltPctTpCd(String rfFltPctTpCd) {
		this.rfFltPctTpCd = rfFltPctTpCd;
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
	 * @param ovrWgtRtRto
	 */
	public void setOvrWgtRtRto(String ovrWgtRtRto) {
		this.ovrWgtRtRto = ovrWgtRtRto;
	}
	
	/**
	 * Column Info
	 * @param minCgoWgt
	 */
	public void setMinCgoWgt(String minCgoWgt) {
		this.minCgoWgt = minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoSvcFlg
	 */
	public void setDcgoSvcFlg(String dcgoSvcFlg) {
		this.dcgoSvcFlg = dcgoSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param dgRtAmt
	 */
	public void setDgRtAmt(String dgRtAmt) {
		this.dgRtAmt = dgRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtCgoSvcFlg
	 */
	public void setOvrWgtCgoSvcFlg(String ovrWgtCgoSvcFlg) {
		this.ovrWgtCgoSvcFlg = ovrWgtCgoSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param rfRtAmt
	 */
	public void setRfRtAmt(String rfRtAmt) {
		this.rfRtAmt = rfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param maxCgoWgt
	 */
	public void setMaxCgoWgt(String maxCgoWgt) {
		this.maxCgoWgt = maxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param loclOvrWgtRtAmt
	 */
	public void setLoclOvrWgtRtAmt(String loclOvrWgtRtAmt) {
		this.loclOvrWgtRtAmt = loclOvrWgtRtAmt;
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
		setOvrWgtRtAmt(JSPUtil.getParameter(request, prefix + "ovr_wgt_rt_amt", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setDgRtRto(JSPUtil.getParameter(request, prefix + "dg_rt_rto", ""));
		setRcSvcFlg(JSPUtil.getParameter(request, prefix + "rc_svc_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPrcTrspModCdNm(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd_nm", ""));
		setDgFltPctTpCd(JSPUtil.getParameter(request, prefix + "dg_flt_pct_tp_cd", ""));
		setRfRtRto(JSPUtil.getParameter(request, prefix + "rf_rt_rto", ""));
		setOvrWgtFltPctTpCd(JSPUtil.getParameter(request, prefix + "ovr_wgt_flt_pct_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcInlndTrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prc_inlnd_trf_cntr_tpsz_cd", ""));
		setRfFltPctTpCd(JSPUtil.getParameter(request, prefix + "rf_flt_pct_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOvrWgtRtRto(JSPUtil.getParameter(request, prefix + "ovr_wgt_rt_rto", ""));
		setMinCgoWgt(JSPUtil.getParameter(request, prefix + "min_cgo_wgt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setDcgoSvcFlg(JSPUtil.getParameter(request, prefix + "dcgo_svc_flg", ""));
		setDgRtAmt(JSPUtil.getParameter(request, prefix + "dg_rt_amt", ""));
		setOvrWgtCgoSvcFlg(JSPUtil.getParameter(request, prefix + "ovr_wgt_cgo_svc_flg", ""));
		setRfRtAmt(JSPUtil.getParameter(request, prefix + "rf_rt_amt", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request, prefix + "max_cgo_wgt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setLoclOvrWgtRtAmt(JSPUtil.getParameter(request, prefix + "locl_ovr_wgt_rt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpecialCargoPopupListVO[]
	 */
	public SpecialCargoPopupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpecialCargoPopupListVO[]
	 */
	public SpecialCargoPopupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpecialCargoPopupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrWgtRtAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_rt_amt", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] dgRtRto = (JSPUtil.getParameter(request, prefix	+ "dg_rt_rto", length));
			String[] rcSvcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_svc_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] prcTrspModCdNm = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd_nm", length));
			String[] dgFltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "dg_flt_pct_tp_cd", length));
			String[] rfRtRto = (JSPUtil.getParameter(request, prefix	+ "rf_rt_rto", length));
			String[] ovrWgtFltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_flt_pct_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcInlndTrfCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "prc_inlnd_trf_cntr_tpsz_cd", length));
			String[] rfFltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_flt_pct_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrWgtRtRto = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_rt_rto", length));
			String[] minCgoWgt = (JSPUtil.getParameter(request, prefix	+ "min_cgo_wgt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] dcgoSvcFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_svc_flg", length));
			String[] dgRtAmt = (JSPUtil.getParameter(request, prefix	+ "dg_rt_amt", length));
			String[] ovrWgtCgoSvcFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_cgo_svc_flg", length));
			String[] rfRtAmt = (JSPUtil.getParameter(request, prefix	+ "rf_rt_amt", length));
			String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_wgt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] loclOvrWgtRtAmt = (JSPUtil.getParameter(request, prefix + "locl_ovr_wgt_rt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpecialCargoPopupListVO();
				if (ovrWgtRtAmt[i] != null)
					model.setOvrWgtRtAmt(ovrWgtRtAmt[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (dgRtRto[i] != null)
					model.setDgRtRto(dgRtRto[i]);
				if (rcSvcFlg[i] != null)
					model.setRcSvcFlg(rcSvcFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (prcTrspModCdNm[i] != null)
					model.setPrcTrspModCdNm(prcTrspModCdNm[i]);
				if (dgFltPctTpCd[i] != null)
					model.setDgFltPctTpCd(dgFltPctTpCd[i]);
				if (rfRtRto[i] != null)
					model.setRfRtRto(rfRtRto[i]);
				if (ovrWgtFltPctTpCd[i] != null)
					model.setOvrWgtFltPctTpCd(ovrWgtFltPctTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcInlndTrfCntrTpszCd[i] != null)
					model.setPrcInlndTrfCntrTpszCd(prcInlndTrfCntrTpszCd[i]);
				if (rfFltPctTpCd[i] != null)
					model.setRfFltPctTpCd(rfFltPctTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrWgtRtRto[i] != null)
					model.setOvrWgtRtRto(ovrWgtRtRto[i]);
				if (minCgoWgt[i] != null)
					model.setMinCgoWgt(minCgoWgt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (dcgoSvcFlg[i] != null)
					model.setDcgoSvcFlg(dcgoSvcFlg[i]);
				if (dgRtAmt[i] != null)
					model.setDgRtAmt(dgRtAmt[i]);
				if (ovrWgtCgoSvcFlg[i] != null)
					model.setOvrWgtCgoSvcFlg(ovrWgtCgoSvcFlg[i]);
				if (rfRtAmt[i] != null)
					model.setRfRtAmt(rfRtAmt[i]);
				if (maxCgoWgt[i] != null)
					model.setMaxCgoWgt(maxCgoWgt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (loclOvrWgtRtAmt[i] != null)
					model.setLoclOvrWgtRtAmt(loclOvrWgtRtAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpecialCargoPopupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpecialCargoPopupListVO[]
	 */
	public SpecialCargoPopupListVO[] getSpecialCargoPopupListVOs(){
		SpecialCargoPopupListVO[] vos = (SpecialCargoPopupListVO[])models.toArray(new SpecialCargoPopupListVO[models.size()]);
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
		this.ovrWgtRtAmt = this.ovrWgtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRtRto = this.dgRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSvcFlg = this.rcSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCdNm = this.prcTrspModCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFltPctTpCd = this.dgFltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRtRto = this.rfRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtFltPctTpCd = this.ovrWgtFltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcInlndTrfCntrTpszCd = this.prcInlndTrfCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFltPctTpCd = this.rfFltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtRtRto = this.ovrWgtRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt = this.minCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSvcFlg = this.dcgoSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRtAmt = this.dgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtCgoSvcFlg = this.ovrWgtCgoSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRtAmt = this.rfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt = this.maxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclOvrWgtRtAmt = this.loclOvrWgtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
