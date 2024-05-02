/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltFicGuidelineRateForAddOnTariffVO.java
*@FileTitle : RsltFicGuidelineRateForAddOnTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.12.06 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltFicGuidelineRateForAddOnTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltFicGuidelineRateForAddOnTariffVO> models = new ArrayList<RsltFicGuidelineRateForAddOnTariffVO>();
	
	/* Column Info */
	private String rf40ftAmt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String basePortList = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;
	/* Column Info */
	private String dgLoc20ftAmt = null;
	/* Column Info */
	private String dg40ftAmt = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String drLoc20ftAmt = null;
	/* Column Info */
	private String drLoc40ftAmt = null;
	/* Column Info */
	private String dgLoc40ftAmt = null;
	/* Column Info */
	private String rf20ftAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String groupNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hSeq = null;
	/* Column Info */
	private String locCurrCd = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String rfLoc40ftAmt = null;
	/* Column Info */
	private String rfLoc20ftAmt = null;
	/* Column Info */
	private String dg20ftAmt = null;
	/* Column Info */
	private String cmdtRout = null;
	/* Column Info */
	private String dr20ftAmt = null;
	/* Column Info */
	private String dr40ftAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltFicGuidelineRateForAddOnTariffVO() {}

	public RsltFicGuidelineRateForAddOnTariffVO(String ibflag, String pagerows, String hSeq, String routDpSeq, String cmdtDpSeq, String ficRtUseStsCd, String ficRoutCmbTpCd, String optmTrspModFlg, String groupNo, String dr20ftAmt, String rf20ftAmt, String dg20ftAmt, String dr40ftAmt, String rf40ftAmt, String dg40ftAmt, String locCurrCd, String drLoc20ftAmt, String rfLoc20ftAmt, String dgLoc20ftAmt, String drLoc40ftAmt, String rfLoc40ftAmt, String dgLoc40ftAmt, String basePortList, String cmdtRout) {
		this.rf40ftAmt = rf40ftAmt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.basePortList = basePortList;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
		this.dgLoc20ftAmt = dgLoc20ftAmt;
		this.dg40ftAmt = dg40ftAmt;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.drLoc20ftAmt = drLoc20ftAmt;
		this.drLoc40ftAmt = drLoc40ftAmt;
		this.dgLoc40ftAmt = dgLoc40ftAmt;
		this.rf20ftAmt = rf20ftAmt;
		this.pagerows = pagerows;
		this.groupNo = groupNo;
		this.ibflag = ibflag;
		this.hSeq = hSeq;
		this.locCurrCd = locCurrCd;
		this.routDpSeq = routDpSeq;
		this.cmdtDpSeq = cmdtDpSeq;
		this.rfLoc40ftAmt = rfLoc40ftAmt;
		this.rfLoc20ftAmt = rfLoc20ftAmt;
		this.dg20ftAmt = dg20ftAmt;
		this.cmdtRout = cmdtRout;
		this.dr20ftAmt = dr20ftAmt;
		this.dr40ftAmt = dr40ftAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_40ft_amt", getRf40ftAmt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("base_port_list", getBasePortList());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		this.hashColumns.put("dg_loc_20ft_amt", getDgLoc20ftAmt());
		this.hashColumns.put("dg_40ft_amt", getDg40ftAmt());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("dr_loc_20ft_amt", getDrLoc20ftAmt());
		this.hashColumns.put("dr_loc_40ft_amt", getDrLoc40ftAmt());
		this.hashColumns.put("dg_loc_40ft_amt", getDgLoc40ftAmt());
		this.hashColumns.put("rf_20ft_amt", getRf20ftAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("group_no", getGroupNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("h_seq", getHSeq());
		this.hashColumns.put("loc_curr_cd", getLocCurrCd());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("rf_loc_40ft_amt", getRfLoc40ftAmt());
		this.hashColumns.put("rf_loc_20ft_amt", getRfLoc20ftAmt());
		this.hashColumns.put("dg_20ft_amt", getDg20ftAmt());
		this.hashColumns.put("cmdt_rout", getCmdtRout());
		this.hashColumns.put("dr_20ft_amt", getDr20ftAmt());
		this.hashColumns.put("dr_40ft_amt", getDr40ftAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_40ft_amt", "rf40ftAmt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("base_port_list", "basePortList");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		this.hashFields.put("dg_loc_20ft_amt", "dgLoc20ftAmt");
		this.hashFields.put("dg_40ft_amt", "dg40ftAmt");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("dr_loc_20ft_amt", "drLoc20ftAmt");
		this.hashFields.put("dr_loc_40ft_amt", "drLoc40ftAmt");
		this.hashFields.put("dg_loc_40ft_amt", "dgLoc40ftAmt");
		this.hashFields.put("rf_20ft_amt", "rf20ftAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("group_no", "groupNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("h_seq", "hSeq");
		this.hashFields.put("loc_curr_cd", "locCurrCd");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("rf_loc_40ft_amt", "rfLoc40ftAmt");
		this.hashFields.put("rf_loc_20ft_amt", "rfLoc20ftAmt");
		this.hashFields.put("dg_20ft_amt", "dg20ftAmt");
		this.hashFields.put("cmdt_rout", "cmdtRout");
		this.hashFields.put("dr_20ft_amt", "dr20ftAmt");
		this.hashFields.put("dr_40ft_amt", "dr40ftAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rf40ftAmt
	 */
	public String getRf40ftAmt() {
		return this.rf40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @return basePortList
	 */
	public String getBasePortList() {
		return this.basePortList;
	}
	
	/**
	 * Column Info
	 * @return ficRoutCmbTpCd
	 */
	public String getFicRoutCmbTpCd() {
		return this.ficRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return dgLoc20ftAmt
	 */
	public String getDgLoc20ftAmt() {
		return this.dgLoc20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dg40ftAmt
	 */
	public String getDg40ftAmt() {
		return this.dg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return drLoc20ftAmt
	 */
	public String getDrLoc20ftAmt() {
		return this.drLoc20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return drLoc40ftAmt
	 */
	public String getDrLoc40ftAmt() {
		return this.drLoc40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dgLoc40ftAmt
	 */
	public String getDgLoc40ftAmt() {
		return this.dgLoc40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rf20ftAmt
	 */
	public String getRf20ftAmt() {
		return this.rf20ftAmt;
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
	 * @return groupNo
	 */
	public String getGroupNo() {
		return this.groupNo;
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
	 * @return hSeq
	 */
	public String getHSeq() {
		return this.hSeq;
	}
	
	/**
	 * Column Info
	 * @return locCurrCd
	 */
	public String getLocCurrCd() {
		return this.locCurrCd;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return rfLoc40ftAmt
	 */
	public String getRfLoc40ftAmt() {
		return this.rfLoc40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rfLoc20ftAmt
	 */
	public String getRfLoc20ftAmt() {
		return this.rfLoc20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dg20ftAmt
	 */
	public String getDg20ftAmt() {
		return this.dg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdtRout
	 */
	public String getCmdtRout() {
		return this.cmdtRout;
	}
	
	/**
	 * Column Info
	 * @return dr20ftAmt
	 */
	public String getDr20ftAmt() {
		return this.dr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dr40ftAmt
	 */
	public String getDr40ftAmt() {
		return this.dr40ftAmt;
	}
	

	/**
	 * Column Info
	 * @param rf40ftAmt
	 */
	public void setRf40ftAmt(String rf40ftAmt) {
		this.rf40ftAmt = rf40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
	}
	
	/**
	 * Column Info
	 * @param basePortList
	 */
	public void setBasePortList(String basePortList) {
		this.basePortList = basePortList;
	}
	
	/**
	 * Column Info
	 * @param ficRoutCmbTpCd
	 */
	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param dgLoc20ftAmt
	 */
	public void setDgLoc20ftAmt(String dgLoc20ftAmt) {
		this.dgLoc20ftAmt = dgLoc20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dg40ftAmt
	 */
	public void setDg40ftAmt(String dg40ftAmt) {
		this.dg40ftAmt = dg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param drLoc20ftAmt
	 */
	public void setDrLoc20ftAmt(String drLoc20ftAmt) {
		this.drLoc20ftAmt = drLoc20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param drLoc40ftAmt
	 */
	public void setDrLoc40ftAmt(String drLoc40ftAmt) {
		this.drLoc40ftAmt = drLoc40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dgLoc40ftAmt
	 */
	public void setDgLoc40ftAmt(String dgLoc40ftAmt) {
		this.dgLoc40ftAmt = dgLoc40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rf20ftAmt
	 */
	public void setRf20ftAmt(String rf20ftAmt) {
		this.rf20ftAmt = rf20ftAmt;
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
	 * @param groupNo
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
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
	 * @param hSeq
	 */
	public void setHSeq(String hSeq) {
		this.hSeq = hSeq;
	}
	
	/**
	 * Column Info
	 * @param locCurrCd
	 */
	public void setLocCurrCd(String locCurrCd) {
		this.locCurrCd = locCurrCd;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param rfLoc40ftAmt
	 */
	public void setRfLoc40ftAmt(String rfLoc40ftAmt) {
		this.rfLoc40ftAmt = rfLoc40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rfLoc20ftAmt
	 */
	public void setRfLoc20ftAmt(String rfLoc20ftAmt) {
		this.rfLoc20ftAmt = rfLoc20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dg20ftAmt
	 */
	public void setDg20ftAmt(String dg20ftAmt) {
		this.dg20ftAmt = dg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdtRout
	 */
	public void setCmdtRout(String cmdtRout) {
		this.cmdtRout = cmdtRout;
	}
	
	/**
	 * Column Info
	 * @param dr20ftAmt
	 */
	public void setDr20ftAmt(String dr20ftAmt) {
		this.dr20ftAmt = dr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dr40ftAmt
	 */
	public void setDr40ftAmt(String dr40ftAmt) {
		this.dr40ftAmt = dr40ftAmt;
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
		setRf40ftAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_amt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setBasePortList(JSPUtil.getParameter(request, prefix + "base_port_list", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", ""));
		setDgLoc20ftAmt(JSPUtil.getParameter(request, prefix + "dg_loc_20ft_amt", ""));
		setDg40ftAmt(JSPUtil.getParameter(request, prefix + "dg_40ft_amt", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setDrLoc20ftAmt(JSPUtil.getParameter(request, prefix + "dr_loc_20ft_amt", ""));
		setDrLoc40ftAmt(JSPUtil.getParameter(request, prefix + "dr_loc_40ft_amt", ""));
		setDgLoc40ftAmt(JSPUtil.getParameter(request, prefix + "dg_loc_40ft_amt", ""));
		setRf20ftAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGroupNo(JSPUtil.getParameter(request, prefix + "group_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHSeq(JSPUtil.getParameter(request, prefix + "h_seq", ""));
		setLocCurrCd(JSPUtil.getParameter(request, prefix + "loc_curr_cd", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setRfLoc40ftAmt(JSPUtil.getParameter(request, prefix + "rf_loc_40ft_amt", ""));
		setRfLoc20ftAmt(JSPUtil.getParameter(request, prefix + "rf_loc_20ft_amt", ""));
		setDg20ftAmt(JSPUtil.getParameter(request, prefix + "dg_20ft_amt", ""));
		setCmdtRout(JSPUtil.getParameter(request, prefix + "cmdt_rout", ""));
		setDr20ftAmt(JSPUtil.getParameter(request, prefix + "dr_20ft_amt", ""));
		setDr40ftAmt(JSPUtil.getParameter(request, prefix + "dr_40ft_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltFicGuidelineRateForAddOnTariffVO[]
	 */
	public RsltFicGuidelineRateForAddOnTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltFicGuidelineRateForAddOnTariffVO[]
	 */
	public RsltFicGuidelineRateForAddOnTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltFicGuidelineRateForAddOnTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rf40ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_amt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] basePortList = (JSPUtil.getParameter(request, prefix	+ "base_port_list", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_rout_cmb_tp_cd", length));
			String[] dgLoc20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_loc_20ft_amt", length));
			String[] dg40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_40ft_amt", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] drLoc20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_loc_20ft_amt", length));
			String[] drLoc40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_loc_40ft_amt", length));
			String[] dgLoc40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_loc_40ft_amt", length));
			String[] rf20ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] groupNo = (JSPUtil.getParameter(request, prefix	+ "group_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hSeq = (JSPUtil.getParameter(request, prefix	+ "h_seq", length));
			String[] locCurrCd = (JSPUtil.getParameter(request, prefix	+ "loc_curr_cd", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] rfLoc40ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_loc_40ft_amt", length));
			String[] rfLoc20ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_loc_20ft_amt", length));
			String[] dg20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_20ft_amt", length));
			String[] cmdtRout = (JSPUtil.getParameter(request, prefix	+ "cmdt_rout", length));
			String[] dr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_20ft_amt", length));
			String[] dr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_40ft_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltFicGuidelineRateForAddOnTariffVO();
				if (rf40ftAmt[i] != null)
					model.setRf40ftAmt(rf40ftAmt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (basePortList[i] != null)
					model.setBasePortList(basePortList[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (dgLoc20ftAmt[i] != null)
					model.setDgLoc20ftAmt(dgLoc20ftAmt[i]);
				if (dg40ftAmt[i] != null)
					model.setDg40ftAmt(dg40ftAmt[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (drLoc20ftAmt[i] != null)
					model.setDrLoc20ftAmt(drLoc20ftAmt[i]);
				if (drLoc40ftAmt[i] != null)
					model.setDrLoc40ftAmt(drLoc40ftAmt[i]);
				if (dgLoc40ftAmt[i] != null)
					model.setDgLoc40ftAmt(dgLoc40ftAmt[i]);
				if (rf20ftAmt[i] != null)
					model.setRf20ftAmt(rf20ftAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (groupNo[i] != null)
					model.setGroupNo(groupNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hSeq[i] != null)
					model.setHSeq(hSeq[i]);
				if (locCurrCd[i] != null)
					model.setLocCurrCd(locCurrCd[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (rfLoc40ftAmt[i] != null)
					model.setRfLoc40ftAmt(rfLoc40ftAmt[i]);
				if (rfLoc20ftAmt[i] != null)
					model.setRfLoc20ftAmt(rfLoc20ftAmt[i]);
				if (dg20ftAmt[i] != null)
					model.setDg20ftAmt(dg20ftAmt[i]);
				if (cmdtRout[i] != null)
					model.setCmdtRout(cmdtRout[i]);
				if (dr20ftAmt[i] != null)
					model.setDr20ftAmt(dr20ftAmt[i]);
				if (dr40ftAmt[i] != null)
					model.setDr40ftAmt(dr40ftAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltFicGuidelineRateForAddOnTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltFicGuidelineRateForAddOnTariffVO[]
	 */
	public RsltFicGuidelineRateForAddOnTariffVO[] getRsltFicGuidelineRateForAddOnTariffVOs(){
		RsltFicGuidelineRateForAddOnTariffVO[] vos = (RsltFicGuidelineRateForAddOnTariffVO[])models.toArray(new RsltFicGuidelineRateForAddOnTariffVO[models.size()]);
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
		this.rf40ftAmt = this.rf40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basePortList = this.basePortList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgLoc20ftAmt = this.dgLoc20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40ftAmt = this.dg40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLoc20ftAmt = this.drLoc20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLoc40ftAmt = this.drLoc40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgLoc40ftAmt = this.dgLoc40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftAmt = this.rf20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupNo = this.groupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hSeq = this.hSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCurrCd = this.locCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfLoc40ftAmt = this.rfLoc40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfLoc20ftAmt = this.rfLoc20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20ftAmt = this.dg20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtRout = this.cmdtRout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dr20ftAmt = this.dr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dr40ftAmt = this.dr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
