/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaListByBkgVO.java
*@FileTitle : CaListByBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.11.18 이남경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaListByBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaListByBkgVO> models = new ArrayList<CaListByBkgVO>();
	
	/* Column Info */
	private String trnkVslCorrFlg = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String corrDt = null;
	/* Column Info */
	private String rtCorrFlg = null;
	/* Column Info */
	private String qtyCorrFlg = null;
	/* Column Info */
	private String ratFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String caOtrRsnCorrFlg = null;
	/* Column Info */
	private String expnFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String prpstVslCorrFlg = null;
	/* Column Info */
	private String custCorrFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvdeTermCorrFlg = null;
	/* Column Info */
	private String routCorrFlg = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String docPerfExptCd = null;
	/* Column Info */
	private String measQtyCorrFlg = null;
	/* Column Info */
	private String cmdtCorrFlg = null;
	/* Column Info */
	private String chgTermCorrFlg = null;
	/* Column Info */
	private String bkgCorrRmk = null;
	/* Column Info */
	private String corrOfcCd = null;
	/* Column Info */
	private String corrUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaListByBkgVO() {}

	public CaListByBkgVO(String ibflag, String pagerows, String caNo, String corrOfcCd, String ctrtOfcCd, String corrDt, String caRsnCd, String ratFlg, String expnFlg, String docPerfExptCd, String rtCorrFlg, String chgTermCorrFlg, String rcvdeTermCorrFlg, String routCorrFlg, String custCorrFlg, String qtyCorrFlg, String measQtyCorrFlg, String cmdtCorrFlg, String trnkVslCorrFlg, String prpstVslCorrFlg, String caOtrRsnCorrFlg, String bkgNo, String bkgCorrRmk, String corrUsrId) {
		this.trnkVslCorrFlg = trnkVslCorrFlg;
		this.caRsnCd = caRsnCd;
		this.corrDt = corrDt;
		this.rtCorrFlg = rtCorrFlg;
		this.qtyCorrFlg = qtyCorrFlg;
		this.ratFlg = ratFlg;
		this.pagerows = pagerows;
		this.caOtrRsnCorrFlg = caOtrRsnCorrFlg;
		this.expnFlg = expnFlg;
		this.bkgNo = bkgNo;
		this.prpstVslCorrFlg = prpstVslCorrFlg;
		this.custCorrFlg = custCorrFlg;
		this.ibflag = ibflag;
		this.rcvdeTermCorrFlg = rcvdeTermCorrFlg;
		this.routCorrFlg = routCorrFlg;
		this.ctrtOfcCd = ctrtOfcCd;
		this.caNo = caNo;
		this.docPerfExptCd = docPerfExptCd;
		this.measQtyCorrFlg = measQtyCorrFlg;
		this.cmdtCorrFlg = cmdtCorrFlg;
		this.chgTermCorrFlg = chgTermCorrFlg;
		this.bkgCorrRmk = bkgCorrRmk;
		this.corrOfcCd = corrOfcCd;
		this.corrUsrId = corrUsrId;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trnk_vsl_corr_flg", getTrnkVslCorrFlg());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("corr_dt", getCorrDt());
		this.hashColumns.put("rt_corr_flg", getRtCorrFlg());
		this.hashColumns.put("qty_corr_flg", getQtyCorrFlg());
		this.hashColumns.put("rat_flg", getRatFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ca_otr_rsn_corr_flg", getCaOtrRsnCorrFlg());
		this.hashColumns.put("expn_flg", getExpnFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prpst_vsl_corr_flg", getPrpstVslCorrFlg());
		this.hashColumns.put("cust_corr_flg", getCustCorrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcvde_term_corr_flg", getRcvdeTermCorrFlg());
		this.hashColumns.put("rout_corr_flg", getRoutCorrFlg());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("doc_perf_expt_cd", getDocPerfExptCd());
		this.hashColumns.put("meas_qty_corr_flg", getMeasQtyCorrFlg());
		this.hashColumns.put("cmdt_corr_flg", getCmdtCorrFlg());
		this.hashColumns.put("chg_term_corr_flg", getChgTermCorrFlg());
		this.hashColumns.put("bkg_corr_rmk", getBkgCorrRmk());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		this.hashColumns.put("corr_usr_id", getCorrUsrId());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trnk_vsl_corr_flg", "trnkVslCorrFlg");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("corr_dt", "corrDt");
		this.hashFields.put("rt_corr_flg", "rtCorrFlg");
		this.hashFields.put("qty_corr_flg", "qtyCorrFlg");
		this.hashFields.put("rat_flg", "ratFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ca_otr_rsn_corr_flg", "caOtrRsnCorrFlg");
		this.hashFields.put("expn_flg", "expnFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prpst_vsl_corr_flg", "prpstVslCorrFlg");
		this.hashFields.put("cust_corr_flg", "custCorrFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcvde_term_corr_flg", "rcvdeTermCorrFlg");
		this.hashFields.put("rout_corr_flg", "routCorrFlg");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("doc_perf_expt_cd", "docPerfExptCd");
		this.hashFields.put("meas_qty_corr_flg", "measQtyCorrFlg");
		this.hashFields.put("cmdt_corr_flg", "cmdtCorrFlg");
		this.hashFields.put("chg_term_corr_flg", "chgTermCorrFlg");
		this.hashFields.put("bkg_corr_rmk", "bkgCorrRmk");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
		this.hashFields.put("corr_usr_id", "corrUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trnkVslCorrFlg
	 */
	public String getTrnkVslCorrFlg() {
		return this.trnkVslCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
	}
	
	/**
	 * Column Info
	 * @return corrDt
	 */
	public String getCorrDt() {
		return this.corrDt;
	}
	
	/**
	 * Column Info
	 * @return rtCorrFlg
	 */
	public String getRtCorrFlg() {
		return this.rtCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return qtyCorrFlg
	 */
	public String getQtyCorrFlg() {
		return this.qtyCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return ratFlg
	 */
	public String getRatFlg() {
		return this.ratFlg;
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
	 * @return caOtrRsnCorrFlg
	 */
	public String getCaOtrRsnCorrFlg() {
		return this.caOtrRsnCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return expnFlg
	 */
	public String getExpnFlg() {
		return this.expnFlg;
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
	 * @return prpstVslCorrFlg
	 */
	public String getPrpstVslCorrFlg() {
		return this.prpstVslCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return custCorrFlg
	 */
	public String getCustCorrFlg() {
		return this.custCorrFlg;
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
	 * @return rcvdeTermCorrFlg
	 */
	public String getRcvdeTermCorrFlg() {
		return this.rcvdeTermCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return routCorrFlg
	 */
	public String getRoutCorrFlg() {
		return this.routCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return caNo
	 */
	public String getCaNo() {
		return this.caNo;
	}
	
	/**
	 * Column Info
	 * @return docPerfExptCd
	 */
	public String getDocPerfExptCd() {
		return this.docPerfExptCd;
	}
	
	/**
	 * Column Info
	 * @return measQtyCorrFlg
	 */
	public String getMeasQtyCorrFlg() {
		return this.measQtyCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtCorrFlg
	 */
	public String getCmdtCorrFlg() {
		return this.cmdtCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return chgTermCorrFlg
	 */
	public String getChgTermCorrFlg() {
		return this.chgTermCorrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrRmk
	 */
	public String getBkgCorrRmk() {
		return this.bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
	}
	

	/**
	 * Column Info
	 * @param trnkVslCorrFlg
	 */
	public void setTrnkVslCorrFlg(String trnkVslCorrFlg) {
		this.trnkVslCorrFlg = trnkVslCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}
	
	/**
	 * Column Info
	 * @param corrDt
	 */
	public void setCorrDt(String corrDt) {
		this.corrDt = corrDt;
	}
	
	/**
	 * Column Info
	 * @param rtCorrFlg
	 */
	public void setRtCorrFlg(String rtCorrFlg) {
		this.rtCorrFlg = rtCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param qtyCorrFlg
	 */
	public void setQtyCorrFlg(String qtyCorrFlg) {
		this.qtyCorrFlg = qtyCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param ratFlg
	 */
	public void setRatFlg(String ratFlg) {
		this.ratFlg = ratFlg;
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
	 * @param caOtrRsnCorrFlg
	 */
	public void setCaOtrRsnCorrFlg(String caOtrRsnCorrFlg) {
		this.caOtrRsnCorrFlg = caOtrRsnCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param expnFlg
	 */
	public void setExpnFlg(String expnFlg) {
		this.expnFlg = expnFlg;
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
	 * @param prpstVslCorrFlg
	 */
	public void setPrpstVslCorrFlg(String prpstVslCorrFlg) {
		this.prpstVslCorrFlg = prpstVslCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param custCorrFlg
	 */
	public void setCustCorrFlg(String custCorrFlg) {
		this.custCorrFlg = custCorrFlg;
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
	 * @param rcvdeTermCorrFlg
	 */
	public void setRcvdeTermCorrFlg(String rcvdeTermCorrFlg) {
		this.rcvdeTermCorrFlg = rcvdeTermCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param routCorrFlg
	 */
	public void setRoutCorrFlg(String routCorrFlg) {
		this.routCorrFlg = routCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param caNo
	 */
	public void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	
	/**
	 * Column Info
	 * @param docPerfExptCd
	 */
	public void setDocPerfExptCd(String docPerfExptCd) {
		this.docPerfExptCd = docPerfExptCd;
	}
	
	/**
	 * Column Info
	 * @param measQtyCorrFlg
	 */
	public void setMeasQtyCorrFlg(String measQtyCorrFlg) {
		this.measQtyCorrFlg = measQtyCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtCorrFlg
	 */
	public void setCmdtCorrFlg(String cmdtCorrFlg) {
		this.cmdtCorrFlg = cmdtCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param chgTermCorrFlg
	 */
	public void setChgTermCorrFlg(String chgTermCorrFlg) {
		this.chgTermCorrFlg = chgTermCorrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrRmk
	 */
	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.corrOfcCd = corrOfcCd;
	}
	
	public String getCorrUsrId() {
		return corrUsrId;
	}

	public void setCorrUsrId(String corrUsrId) {
		this.corrUsrId = corrUsrId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrnkVslCorrFlg(JSPUtil.getParameter(request, "trnk_vsl_corr_flg", ""));
		setCaRsnCd(JSPUtil.getParameter(request, "ca_rsn_cd", ""));
		setCorrDt(JSPUtil.getParameter(request, "corr_dt", ""));
		setRtCorrFlg(JSPUtil.getParameter(request, "rt_corr_flg", ""));
		setQtyCorrFlg(JSPUtil.getParameter(request, "qty_corr_flg", ""));
		setRatFlg(JSPUtil.getParameter(request, "rat_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCaOtrRsnCorrFlg(JSPUtil.getParameter(request, "ca_otr_rsn_corr_flg", ""));
		setExpnFlg(JSPUtil.getParameter(request, "expn_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPrpstVslCorrFlg(JSPUtil.getParameter(request, "prpst_vsl_corr_flg", ""));
		setCustCorrFlg(JSPUtil.getParameter(request, "cust_corr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvdeTermCorrFlg(JSPUtil.getParameter(request, "rcvde_term_corr_flg", ""));
		setRoutCorrFlg(JSPUtil.getParameter(request, "rout_corr_flg", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, "ctrt_ofc_cd", ""));
		setCaNo(JSPUtil.getParameter(request, "ca_no", ""));
		setDocPerfExptCd(JSPUtil.getParameter(request, "doc_perf_expt_cd", ""));
		setMeasQtyCorrFlg(JSPUtil.getParameter(request, "meas_qty_corr_flg", ""));
		setCmdtCorrFlg(JSPUtil.getParameter(request, "cmdt_corr_flg", ""));
		setChgTermCorrFlg(JSPUtil.getParameter(request, "chg_term_corr_flg", ""));
		setBkgCorrRmk(JSPUtil.getParameter(request, "bkg_corr_rmk", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, "corr_ofc_cd", ""));
		setCorrUsrId(JSPUtil.getParameter(request, "corr_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaListByBkgVO[]
	 */
	public CaListByBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaListByBkgVO[]
	 */
	public CaListByBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaListByBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trnkVslCorrFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_corr_flg", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] corrDt = (JSPUtil.getParameter(request, prefix	+ "corr_dt", length));
			String[] rtCorrFlg = (JSPUtil.getParameter(request, prefix	+ "rt_corr_flg", length));
			String[] qtyCorrFlg = (JSPUtil.getParameter(request, prefix	+ "qty_corr_flg", length));
			String[] ratFlg = (JSPUtil.getParameter(request, prefix	+ "rat_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] caOtrRsnCorrFlg = (JSPUtil.getParameter(request, prefix	+ "ca_otr_rsn_corr_flg", length));
			String[] expnFlg = (JSPUtil.getParameter(request, prefix	+ "expn_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] prpstVslCorrFlg = (JSPUtil.getParameter(request, prefix	+ "prpst_vsl_corr_flg", length));
			String[] custCorrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_corr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvdeTermCorrFlg = (JSPUtil.getParameter(request, prefix	+ "rcvde_term_corr_flg", length));
			String[] routCorrFlg = (JSPUtil.getParameter(request, prefix	+ "rout_corr_flg", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] docPerfExptCd = (JSPUtil.getParameter(request, prefix	+ "doc_perf_expt_cd", length));
			String[] measQtyCorrFlg = (JSPUtil.getParameter(request, prefix	+ "meas_qty_corr_flg", length));
			String[] cmdtCorrFlg = (JSPUtil.getParameter(request, prefix	+ "cmdt_corr_flg", length));
			String[] chgTermCorrFlg = (JSPUtil.getParameter(request, prefix	+ "chg_term_corr_flg", length));
			String[] bkgCorrRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_rmk", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			String[] corrUsrId = (JSPUtil.getParameter(request, prefix	+ "corr_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaListByBkgVO();
				if (trnkVslCorrFlg[i] != null)
					model.setTrnkVslCorrFlg(trnkVslCorrFlg[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (corrDt[i] != null)
					model.setCorrDt(corrDt[i]);
				if (rtCorrFlg[i] != null)
					model.setRtCorrFlg(rtCorrFlg[i]);
				if (qtyCorrFlg[i] != null)
					model.setQtyCorrFlg(qtyCorrFlg[i]);
				if (ratFlg[i] != null)
					model.setRatFlg(ratFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (caOtrRsnCorrFlg[i] != null)
					model.setCaOtrRsnCorrFlg(caOtrRsnCorrFlg[i]);
				if (expnFlg[i] != null)
					model.setExpnFlg(expnFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (prpstVslCorrFlg[i] != null)
					model.setPrpstVslCorrFlg(prpstVslCorrFlg[i]);
				if (custCorrFlg[i] != null)
					model.setCustCorrFlg(custCorrFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvdeTermCorrFlg[i] != null)
					model.setRcvdeTermCorrFlg(rcvdeTermCorrFlg[i]);
				if (routCorrFlg[i] != null)
					model.setRoutCorrFlg(routCorrFlg[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (docPerfExptCd[i] != null)
					model.setDocPerfExptCd(docPerfExptCd[i]);
				if (measQtyCorrFlg[i] != null)
					model.setMeasQtyCorrFlg(measQtyCorrFlg[i]);
				if (cmdtCorrFlg[i] != null)
					model.setCmdtCorrFlg(cmdtCorrFlg[i]);
				if (chgTermCorrFlg[i] != null)
					model.setChgTermCorrFlg(chgTermCorrFlg[i]);
				if (bkgCorrRmk[i] != null)
					model.setBkgCorrRmk(bkgCorrRmk[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				if (corrUsrId[i] != null)
					model.setCorrUsrId(corrUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaListByBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaListByBkgVO[]
	 */
	public CaListByBkgVO[] getCaListByBkgVOs(){
		CaListByBkgVO[] vos = (CaListByBkgVO[])models.toArray(new CaListByBkgVO[models.size()]);
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
		this.trnkVslCorrFlg = this.trnkVslCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrDt = this.corrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCorrFlg = this.rtCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyCorrFlg = this.qtyCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratFlg = this.ratFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caOtrRsnCorrFlg = this.caOtrRsnCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnFlg = this.expnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpstVslCorrFlg = this.prpstVslCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCorrFlg = this.custCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvdeTermCorrFlg = this.rcvdeTermCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCorrFlg = this.routCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPerfExptCd = this.docPerfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCorrFlg = this.measQtyCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCorrFlg = this.cmdtCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTermCorrFlg = this.chgTermCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrRmk = this.bkgCorrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrId = this.corrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
