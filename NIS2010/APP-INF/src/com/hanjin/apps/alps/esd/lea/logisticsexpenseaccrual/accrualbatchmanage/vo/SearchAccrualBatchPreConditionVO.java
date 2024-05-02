/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchPreConditionVO.java
*@FileTitle : SearchAccrualBatchPreConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.10.05 전재홍 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo;

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
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchPreConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchPreConditionVO> models = new ArrayList<SearchAccrualBatchPreConditionVO>();
	
	/* Column Info */
	private String revVvdIfFlg = null;
	/* Column Info */
	private String revVvdDupCnt = null;
	/* Column Info */
	private String monAvgXchRtIfFlg = null;
	/* Column Info */
	private String mnlInpFlgNm = null;
	/* Column Info */
	private String monAvgXchRtIfKnt = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String revVvdIfKnt = null;
	/* Column Info */
	private String apClzFlg = null;
	/* Column Info */
	private String condCfmFlg = null;
	/* Column Info */
	private String frmExeYrmon = null;
	/* Column Info */
	private String erpIfDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revVvdIfDesc = null;
	/* Column Info */
	private String condCfmFlgNm = null;
	/* Column Info */
	private String monAvgXchRtIfFlgDesc = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String apClzFlgNm = null;
	/* Column Info */
	private String erpIfFlg = null;
	/* Column Info */
	private String erpIfFlgDesc = null;
	/* Column Info */
	private String monAvgXchRtIfFlgNm = null;
	/* Column Info */
	private String erpIfFlgNm = null;
	/* Column Info */
	private String revVvdIfFlgNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchPreConditionVO() {}

	public SearchAccrualBatchPreConditionVO(String ibflag, String pagerows, String exeYrmon, String apClzFlg, String apClzFlgNm, String revVvdIfFlg, String revVvdIfFlgNm, String revVvdDupCnt, String revVvdIfKnt, String revVvdIfDesc, String monAvgXchRtIfFlg, String monAvgXchRtIfFlgNm, String monAvgXchRtIfKnt, String monAvgXchRtIfFlgDesc, String condCfmFlg, String condCfmFlgNm, String mnlInpFlg, String mnlInpFlgNm, String erpIfFlg, String erpIfFlgNm, String erpIfFlgDesc, String erpIfDt, String frmExeYrmon) {
		this.revVvdIfFlg = revVvdIfFlg;
		this.revVvdDupCnt = revVvdDupCnt;
		this.monAvgXchRtIfFlg = monAvgXchRtIfFlg;
		this.mnlInpFlgNm = mnlInpFlgNm;
		this.monAvgXchRtIfKnt = monAvgXchRtIfKnt;
		this.exeYrmon = exeYrmon;
		this.revVvdIfKnt = revVvdIfKnt;
		this.apClzFlg = apClzFlg;
		this.condCfmFlg = condCfmFlg;
		this.frmExeYrmon = frmExeYrmon;
		this.erpIfDt = erpIfDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.revVvdIfDesc = revVvdIfDesc;
		this.condCfmFlgNm = condCfmFlgNm;
		this.monAvgXchRtIfFlgDesc = monAvgXchRtIfFlgDesc;
		this.mnlInpFlg = mnlInpFlg;
		this.apClzFlgNm = apClzFlgNm;
		this.erpIfFlg = erpIfFlg;
		this.erpIfFlgDesc = erpIfFlgDesc;
		this.monAvgXchRtIfFlgNm = monAvgXchRtIfFlgNm;
		this.erpIfFlgNm = erpIfFlgNm;
		this.revVvdIfFlgNm = revVvdIfFlgNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_vvd_if_flg", getRevVvdIfFlg());
		this.hashColumns.put("rev_vvd_dup_cnt", getRevVvdDupCnt());
		this.hashColumns.put("mon_avg_xch_rt_if_flg", getMonAvgXchRtIfFlg());
		this.hashColumns.put("mnl_inp_flg_nm", getMnlInpFlgNm());
		this.hashColumns.put("mon_avg_xch_rt_if_knt", getMonAvgXchRtIfKnt());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("rev_vvd_if_knt", getRevVvdIfKnt());
		this.hashColumns.put("ap_clz_flg", getApClzFlg());
		this.hashColumns.put("cond_cfm_flg", getCondCfmFlg());
		this.hashColumns.put("frm_exe_yrmon", getFrmExeYrmon());
		this.hashColumns.put("erp_if_dt", getErpIfDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_vvd_if_desc", getRevVvdIfDesc());
		this.hashColumns.put("cond_cfm_flg_nm", getCondCfmFlgNm());
		this.hashColumns.put("mon_avg_xch_rt_if_flg_desc", getMonAvgXchRtIfFlgDesc());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("ap_clz_flg_nm", getApClzFlgNm());
		this.hashColumns.put("erp_if_flg", getErpIfFlg());
		this.hashColumns.put("erp_if_flg_desc", getErpIfFlgDesc());
		this.hashColumns.put("mon_avg_xch_rt_if_flg_nm", getMonAvgXchRtIfFlgNm());
		this.hashColumns.put("erp_if_flg_nm", getErpIfFlgNm());
		this.hashColumns.put("rev_vvd_if_flg_nm", getRevVvdIfFlgNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_vvd_if_flg", "revVvdIfFlg");
		this.hashFields.put("rev_vvd_dup_cnt", "revVvdDupCnt");
		this.hashFields.put("mon_avg_xch_rt_if_flg", "monAvgXchRtIfFlg");
		this.hashFields.put("mnl_inp_flg_nm", "mnlInpFlgNm");
		this.hashFields.put("mon_avg_xch_rt_if_knt", "monAvgXchRtIfKnt");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("rev_vvd_if_knt", "revVvdIfKnt");
		this.hashFields.put("ap_clz_flg", "apClzFlg");
		this.hashFields.put("cond_cfm_flg", "condCfmFlg");
		this.hashFields.put("frm_exe_yrmon", "frmExeYrmon");
		this.hashFields.put("erp_if_dt", "erpIfDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_vvd_if_desc", "revVvdIfDesc");
		this.hashFields.put("cond_cfm_flg_nm", "condCfmFlgNm");
		this.hashFields.put("mon_avg_xch_rt_if_flg_desc", "monAvgXchRtIfFlgDesc");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("ap_clz_flg_nm", "apClzFlgNm");
		this.hashFields.put("erp_if_flg", "erpIfFlg");
		this.hashFields.put("erp_if_flg_desc", "erpIfFlgDesc");
		this.hashFields.put("mon_avg_xch_rt_if_flg_nm", "monAvgXchRtIfFlgNm");
		this.hashFields.put("erp_if_flg_nm", "erpIfFlgNm");
		this.hashFields.put("rev_vvd_if_flg_nm", "revVvdIfFlgNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revVvdIfFlg
	 */
	public String getRevVvdIfFlg() {
		return this.revVvdIfFlg;
	}
	
	/**
	 * Column Info
	 * @return revVvdDupCnt
	 */
	public String getRevVvdDupCnt() {
		return this.revVvdDupCnt;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfFlg
	 */
	public String getMonAvgXchRtIfFlg() {
		return this.monAvgXchRtIfFlg;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlgNm
	 */
	public String getMnlInpFlgNm() {
		return this.mnlInpFlgNm;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfKnt
	 */
	public String getMonAvgXchRtIfKnt() {
		return this.monAvgXchRtIfKnt;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return revVvdIfKnt
	 */
	public String getRevVvdIfKnt() {
		return this.revVvdIfKnt;
	}
	
	/**
	 * Column Info
	 * @return apClzFlg
	 */
	public String getApClzFlg() {
		return this.apClzFlg;
	}
	
	/**
	 * Column Info
	 * @return condCfmFlg
	 */
	public String getCondCfmFlg() {
		return this.condCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return frmExeYrmon
	 */
	public String getFrmExeYrmon() {
		return this.frmExeYrmon;
	}
	
	/**
	 * Column Info
	 * @return erpIfDt
	 */
	public String getErpIfDt() {
		return this.erpIfDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return revVvdIfDesc
	 */
	public String getRevVvdIfDesc() {
		return this.revVvdIfDesc;
	}
	
	/**
	 * Column Info
	 * @return condCfmFlgNm
	 */
	public String getCondCfmFlgNm() {
		return this.condCfmFlgNm;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfFlgDesc
	 */
	public String getMonAvgXchRtIfFlgDesc() {
		return this.monAvgXchRtIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @return apClzFlgNm
	 */
	public String getApClzFlgNm() {
		return this.apClzFlgNm;
	}
	
	/**
	 * Column Info
	 * @return erpIfFlg
	 */
	public String getErpIfFlg() {
		return this.erpIfFlg;
	}
	
	/**
	 * Column Info
	 * @return erpIfFlgDesc
	 */
	public String getErpIfFlgDesc() {
		return this.erpIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfFlgNm
	 */
	public String getMonAvgXchRtIfFlgNm() {
		return this.monAvgXchRtIfFlgNm;
	}
	
	/**
	 * Column Info
	 * @return erpIfFlgNm
	 */
	public String getErpIfFlgNm() {
		return this.erpIfFlgNm;
	}
	
	/**
	 * Column Info
	 * @return revVvdIfFlgNm
	 */
	public String getRevVvdIfFlgNm() {
		return this.revVvdIfFlgNm;
	}
	

	/**
	 * Column Info
	 * @param revVvdIfFlg
	 */
	public void setRevVvdIfFlg(String revVvdIfFlg) {
		this.revVvdIfFlg = revVvdIfFlg;
	}
	
	/**
	 * Column Info
	 * @param revVvdDupCnt
	 */
	public void setRevVvdDupCnt(String revVvdDupCnt) {
		this.revVvdDupCnt = revVvdDupCnt;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfFlg
	 */
	public void setMonAvgXchRtIfFlg(String monAvgXchRtIfFlg) {
		this.monAvgXchRtIfFlg = monAvgXchRtIfFlg;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlgNm
	 */
	public void setMnlInpFlgNm(String mnlInpFlgNm) {
		this.mnlInpFlgNm = mnlInpFlgNm;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfKnt
	 */
	public void setMonAvgXchRtIfKnt(String monAvgXchRtIfKnt) {
		this.monAvgXchRtIfKnt = monAvgXchRtIfKnt;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param revVvdIfKnt
	 */
	public void setRevVvdIfKnt(String revVvdIfKnt) {
		this.revVvdIfKnt = revVvdIfKnt;
	}
	
	/**
	 * Column Info
	 * @param apClzFlg
	 */
	public void setApClzFlg(String apClzFlg) {
		this.apClzFlg = apClzFlg;
	}
	
	/**
	 * Column Info
	 * @param condCfmFlg
	 */
	public void setCondCfmFlg(String condCfmFlg) {
		this.condCfmFlg = condCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param frmExeYrmon
	 */
	public void setFrmExeYrmon(String frmExeYrmon) {
		this.frmExeYrmon = frmExeYrmon;
	}
	
	/**
	 * Column Info
	 * @param erpIfDt
	 */
	public void setErpIfDt(String erpIfDt) {
		this.erpIfDt = erpIfDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param revVvdIfDesc
	 */
	public void setRevVvdIfDesc(String revVvdIfDesc) {
		this.revVvdIfDesc = revVvdIfDesc;
	}
	
	/**
	 * Column Info
	 * @param condCfmFlgNm
	 */
	public void setCondCfmFlgNm(String condCfmFlgNm) {
		this.condCfmFlgNm = condCfmFlgNm;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfFlgDesc
	 */
	public void setMonAvgXchRtIfFlgDesc(String monAvgXchRtIfFlgDesc) {
		this.monAvgXchRtIfFlgDesc = monAvgXchRtIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @param apClzFlgNm
	 */
	public void setApClzFlgNm(String apClzFlgNm) {
		this.apClzFlgNm = apClzFlgNm;
	}
	
	/**
	 * Column Info
	 * @param erpIfFlg
	 */
	public void setErpIfFlg(String erpIfFlg) {
		this.erpIfFlg = erpIfFlg;
	}
	
	/**
	 * Column Info
	 * @param erpIfFlgDesc
	 */
	public void setErpIfFlgDesc(String erpIfFlgDesc) {
		this.erpIfFlgDesc = erpIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfFlgNm
	 */
	public void setMonAvgXchRtIfFlgNm(String monAvgXchRtIfFlgNm) {
		this.monAvgXchRtIfFlgNm = monAvgXchRtIfFlgNm;
	}
	
	/**
	 * Column Info
	 * @param erpIfFlgNm
	 */
	public void setErpIfFlgNm(String erpIfFlgNm) {
		this.erpIfFlgNm = erpIfFlgNm;
	}
	
	/**
	 * Column Info
	 * @param revVvdIfFlgNm
	 */
	public void setRevVvdIfFlgNm(String revVvdIfFlgNm) {
		this.revVvdIfFlgNm = revVvdIfFlgNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRevVvdIfFlg(JSPUtil.getParameter(request, "rev_vvd_if_flg", ""));
		setRevVvdDupCnt(JSPUtil.getParameter(request, "rev_vvd_dup_cnt", ""));
		setMonAvgXchRtIfFlg(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_flg", ""));
		setMnlInpFlgNm(JSPUtil.getParameter(request, "mnl_inp_flg_nm", ""));
		setMonAvgXchRtIfKnt(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_knt", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setRevVvdIfKnt(JSPUtil.getParameter(request, "rev_vvd_if_knt", ""));
		setApClzFlg(JSPUtil.getParameter(request, "ap_clz_flg", ""));
		setCondCfmFlg(JSPUtil.getParameter(request, "cond_cfm_flg", ""));
		setFrmExeYrmon(JSPUtil.getParameter(request, "frm_exe_yrmon", ""));
		setErpIfDt(JSPUtil.getParameter(request, "erp_if_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevVvdIfDesc(JSPUtil.getParameter(request, "rev_vvd_if_desc", ""));
		setCondCfmFlgNm(JSPUtil.getParameter(request, "cond_cfm_flg_nm", ""));
		setMonAvgXchRtIfFlgDesc(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_flg_desc", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, "mnl_inp_flg", ""));
		setApClzFlgNm(JSPUtil.getParameter(request, "ap_clz_flg_nm", ""));
		setErpIfFlg(JSPUtil.getParameter(request, "erp_if_flg", ""));
		setErpIfFlgDesc(JSPUtil.getParameter(request, "erp_if_flg_desc", ""));
		setMonAvgXchRtIfFlgNm(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_flg_nm", ""));
		setErpIfFlgNm(JSPUtil.getParameter(request, "erp_if_flg_nm", ""));
		setRevVvdIfFlgNm(JSPUtil.getParameter(request, "rev_vvd_if_flg_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchPreConditionVO[]
	 */
	public SearchAccrualBatchPreConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchPreConditionVO[]
	 */
	public SearchAccrualBatchPreConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchPreConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revVvdIfFlg = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_flg", length));
			String[] revVvdDupCnt = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_dup_cnt", length));
			String[] monAvgXchRtIfFlg = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_flg", length));
			String[] mnlInpFlgNm = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg_nm", length));
			String[] monAvgXchRtIfKnt = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_knt", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] revVvdIfKnt = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_knt", length));
			String[] apClzFlg = (JSPUtil.getParameter(request, prefix	+ "ap_clz_flg", length));
			String[] condCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cond_cfm_flg", length));
			String[] frmExeYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_exe_yrmon", length));
			String[] erpIfDt = (JSPUtil.getParameter(request, prefix	+ "erp_if_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revVvdIfDesc = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_desc", length));
			String[] condCfmFlgNm = (JSPUtil.getParameter(request, prefix	+ "cond_cfm_flg_nm", length));
			String[] monAvgXchRtIfFlgDesc = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_flg_desc", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] apClzFlgNm = (JSPUtil.getParameter(request, prefix	+ "ap_clz_flg_nm", length));
			String[] erpIfFlg = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg", length));
			String[] erpIfFlgDesc = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg_desc", length));
			String[] monAvgXchRtIfFlgNm = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_flg_nm", length));
			String[] erpIfFlgNm = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg_nm", length));
			String[] revVvdIfFlgNm = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_flg_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchPreConditionVO();
				if (revVvdIfFlg[i] != null)
					model.setRevVvdIfFlg(revVvdIfFlg[i]);
				if (revVvdDupCnt[i] != null)
					model.setRevVvdDupCnt(revVvdDupCnt[i]);
				if (monAvgXchRtIfFlg[i] != null)
					model.setMonAvgXchRtIfFlg(monAvgXchRtIfFlg[i]);
				if (mnlInpFlgNm[i] != null)
					model.setMnlInpFlgNm(mnlInpFlgNm[i]);
				if (monAvgXchRtIfKnt[i] != null)
					model.setMonAvgXchRtIfKnt(monAvgXchRtIfKnt[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (revVvdIfKnt[i] != null)
					model.setRevVvdIfKnt(revVvdIfKnt[i]);
				if (apClzFlg[i] != null)
					model.setApClzFlg(apClzFlg[i]);
				if (condCfmFlg[i] != null)
					model.setCondCfmFlg(condCfmFlg[i]);
				if (frmExeYrmon[i] != null)
					model.setFrmExeYrmon(frmExeYrmon[i]);
				if (erpIfDt[i] != null)
					model.setErpIfDt(erpIfDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revVvdIfDesc[i] != null)
					model.setRevVvdIfDesc(revVvdIfDesc[i]);
				if (condCfmFlgNm[i] != null)
					model.setCondCfmFlgNm(condCfmFlgNm[i]);
				if (monAvgXchRtIfFlgDesc[i] != null)
					model.setMonAvgXchRtIfFlgDesc(monAvgXchRtIfFlgDesc[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (apClzFlgNm[i] != null)
					model.setApClzFlgNm(apClzFlgNm[i]);
				if (erpIfFlg[i] != null)
					model.setErpIfFlg(erpIfFlg[i]);
				if (erpIfFlgDesc[i] != null)
					model.setErpIfFlgDesc(erpIfFlgDesc[i]);
				if (monAvgXchRtIfFlgNm[i] != null)
					model.setMonAvgXchRtIfFlgNm(monAvgXchRtIfFlgNm[i]);
				if (erpIfFlgNm[i] != null)
					model.setErpIfFlgNm(erpIfFlgNm[i]);
				if (revVvdIfFlgNm[i] != null)
					model.setRevVvdIfFlgNm(revVvdIfFlgNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchPreConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchPreConditionVO[]
	 */
	public SearchAccrualBatchPreConditionVO[] getSearchAccrualBatchPreConditionVOs(){
		SearchAccrualBatchPreConditionVO[] vos = (SearchAccrualBatchPreConditionVO[])models.toArray(new SearchAccrualBatchPreConditionVO[models.size()]);
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
		this.revVvdIfFlg = this.revVvdIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdDupCnt = this.revVvdDupCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfFlg = this.monAvgXchRtIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlgNm = this.mnlInpFlgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfKnt = this.monAvgXchRtIfKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdIfKnt = this.revVvdIfKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apClzFlg = this.apClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condCfmFlg = this.condCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmExeYrmon = this.frmExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfDt = this.erpIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdIfDesc = this.revVvdIfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condCfmFlgNm = this.condCfmFlgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfFlgDesc = this.monAvgXchRtIfFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apClzFlgNm = this.apClzFlgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlg = this.erpIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlgDesc = this.erpIfFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfFlgNm = this.monAvgXchRtIfFlgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlgNm = this.erpIfFlgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdIfFlgNm = this.revVvdIfFlgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
