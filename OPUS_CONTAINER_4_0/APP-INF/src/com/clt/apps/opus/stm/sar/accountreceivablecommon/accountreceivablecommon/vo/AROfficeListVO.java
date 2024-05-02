/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AROfficeListVO.java
*@FileTitle : AROfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AROfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AROfficeListVO> models = new ArrayList<AROfficeListVO>();
	
	/* Column Info */
	private String ofcBrncAgnTpCd = null;
	/* Column Info */
	private String agnPfxCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String agnOtsLmtAmt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String bankCtrlCd = null;
	/* Column Info */
	private String chkOfcYn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcEntrLvlCd = null;
	/* Column Info */
	private String otsCd = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String rctTpCd = null;
	/* Column Info */
	private String agnCurrCd = null;
	/* Column Info */
	private String rctDocCd = null;
	/* Column Info */
	private String agnCmbCd = null;
	/* Column Info */
	private String repOtsOfcCd = null;
	/* Column Info */
	private String rctUnapyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AROfficeListVO() {}

	public AROfficeListVO(String ibflag, String pagerows, String ofcBrncAgnTpCd, String agnPfxCd, String rhqCd, String arCurrCd, String otsSmryCd, String agnOtsLmtAmt, String arOfcCd, String dpPrcsKnt, String bankCtrlCd, String ofcEntrLvlCd, String otsOfcCd, String otsCd, String rctTpCd, String agnCurrCd, String agnCmbCd, String repOtsOfcCd, String rctUnapyFlg, String rctDocCd, String ctrlOfcCd, String chkOfcYn) {
		this.ofcBrncAgnTpCd = ofcBrncAgnTpCd;
		this.agnPfxCd = agnPfxCd;
		this.rhqCd = rhqCd;
		this.arCurrCd = arCurrCd;
		this.otsSmryCd = otsSmryCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.agnOtsLmtAmt = agnOtsLmtAmt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.bankCtrlCd = bankCtrlCd;
		this.chkOfcYn = chkOfcYn;
		this.ibflag = ibflag;
		this.ofcEntrLvlCd = ofcEntrLvlCd;
		this.otsCd = otsCd;
		this.otsOfcCd = otsOfcCd;
		this.rctTpCd = rctTpCd;
		this.agnCurrCd = agnCurrCd;
		this.rctDocCd = rctDocCd;
		this.agnCmbCd = agnCmbCd;
		this.repOtsOfcCd = repOtsOfcCd;
		this.rctUnapyFlg = rctUnapyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_brnc_agn_tp_cd", getOfcBrncAgnTpCd());
		this.hashColumns.put("agn_pfx_cd", getAgnPfxCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("agn_ots_lmt_amt", getAgnOtsLmtAmt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("bank_ctrl_cd", getBankCtrlCd());
		this.hashColumns.put("chk_ofc_yn", getChkOfcYn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_entr_lvl_cd", getOfcEntrLvlCd());
		this.hashColumns.put("ots_cd", getOtsCd());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("rct_tp_cd", getRctTpCd());
		this.hashColumns.put("agn_curr_cd", getAgnCurrCd());
		this.hashColumns.put("rct_doc_cd", getRctDocCd());
		this.hashColumns.put("agn_cmb_cd", getAgnCmbCd());
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());
		this.hashColumns.put("rct_unapy_flg", getRctUnapyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_brnc_agn_tp_cd", "ofcBrncAgnTpCd");
		this.hashFields.put("agn_pfx_cd", "agnPfxCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("agn_ots_lmt_amt", "agnOtsLmtAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("bank_ctrl_cd", "bankCtrlCd");
		this.hashFields.put("chk_ofc_yn", "chkOfcYn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_entr_lvl_cd", "ofcEntrLvlCd");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("agn_curr_cd", "agnCurrCd");
		this.hashFields.put("rct_doc_cd", "rctDocCd");
		this.hashFields.put("agn_cmb_cd", "agnCmbCd");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("rct_unapy_flg", "rctUnapyFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcBrncAgnTpCd
	 */
	public String getOfcBrncAgnTpCd() {
		return this.ofcBrncAgnTpCd;
	}
	
	/**
	 * Column Info
	 * @return agnPfxCd
	 */
	public String getAgnPfxCd() {
		return this.agnPfxCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agnOtsLmtAmt
	 */
	public String getAgnOtsLmtAmt() {
		return this.agnOtsLmtAmt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return bankCtrlCd
	 */
	public String getBankCtrlCd() {
		return this.bankCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return chkOfcYn
	 */
	public String getChkOfcYn() {
		return this.chkOfcYn;
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
	 * @return ofcEntrLvlCd
	 */
	public String getOfcEntrLvlCd() {
		return this.ofcEntrLvlCd;
	}
	
	/**
	 * Column Info
	 * @return otsCd
	 */
	public String getOtsCd() {
		return this.otsCd;
	}
	
	/**
	 * Column Info
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctTpCd
	 */
	public String getRctTpCd() {
		return this.rctTpCd;
	}
	
	/**
	 * Column Info
	 * @return agnCurrCd
	 */
	public String getAgnCurrCd() {
		return this.agnCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rctDocCd
	 */
	public String getRctDocCd() {
		return this.rctDocCd;
	}
	
	/**
	 * Column Info
	 * @return agnCmbCd
	 */
	public String getAgnCmbCd() {
		return this.agnCmbCd;
	}
	
	/**
	 * Column Info
	 * @return repOtsOfcCd
	 */
	public String getRepOtsOfcCd() {
		return this.repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctUnapyFlg
	 */
	public String getRctUnapyFlg() {
		return this.rctUnapyFlg;
	}
	

	/**
	 * Column Info
	 * @param ofcBrncAgnTpCd
	 */
	public void setOfcBrncAgnTpCd(String ofcBrncAgnTpCd) {
		this.ofcBrncAgnTpCd = ofcBrncAgnTpCd;
	}
	
	/**
	 * Column Info
	 * @param agnPfxCd
	 */
	public void setAgnPfxCd(String agnPfxCd) {
		this.agnPfxCd = agnPfxCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agnOtsLmtAmt
	 */
	public void setAgnOtsLmtAmt(String agnOtsLmtAmt) {
		this.agnOtsLmtAmt = agnOtsLmtAmt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param bankCtrlCd
	 */
	public void setBankCtrlCd(String bankCtrlCd) {
		this.bankCtrlCd = bankCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param chkOfcYn
	 */
	public void setChkOfcYn(String chkOfcYn) {
		this.chkOfcYn = chkOfcYn;
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
	 * @param ofcEntrLvlCd
	 */
	public void setOfcEntrLvlCd(String ofcEntrLvlCd) {
		this.ofcEntrLvlCd = ofcEntrLvlCd;
	}
	
	/**
	 * Column Info
	 * @param otsCd
	 */
	public void setOtsCd(String otsCd) {
		this.otsCd = otsCd;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctTpCd
	 */
	public void setRctTpCd(String rctTpCd) {
		this.rctTpCd = rctTpCd;
	}
	
	/**
	 * Column Info
	 * @param agnCurrCd
	 */
	public void setAgnCurrCd(String agnCurrCd) {
		this.agnCurrCd = agnCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rctDocCd
	 */
	public void setRctDocCd(String rctDocCd) {
		this.rctDocCd = rctDocCd;
	}
	
	/**
	 * Column Info
	 * @param agnCmbCd
	 */
	public void setAgnCmbCd(String agnCmbCd) {
		this.agnCmbCd = agnCmbCd;
	}
	
	/**
	 * Column Info
	 * @param repOtsOfcCd
	 */
	public void setRepOtsOfcCd(String repOtsOfcCd) {
		this.repOtsOfcCd = repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctUnapyFlg
	 */
	public void setRctUnapyFlg(String rctUnapyFlg) {
		this.rctUnapyFlg = rctUnapyFlg;
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
		setOfcBrncAgnTpCd(JSPUtil.getParameter(request, prefix + "ofc_brnc_agn_tp_cd", ""));
		setAgnPfxCd(JSPUtil.getParameter(request, prefix + "agn_pfx_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, prefix + "ots_smry_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setAgnOtsLmtAmt(JSPUtil.getParameter(request, prefix + "agn_ots_lmt_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setBankCtrlCd(JSPUtil.getParameter(request, prefix + "bank_ctrl_cd", ""));
		setChkOfcYn(JSPUtil.getParameter(request, prefix + "chk_ofc_yn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcEntrLvlCd(JSPUtil.getParameter(request, prefix + "ofc_entr_lvl_cd", ""));
		setOtsCd(JSPUtil.getParameter(request, prefix + "ots_cd", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setRctTpCd(JSPUtil.getParameter(request, prefix + "rct_tp_cd", ""));
		setAgnCurrCd(JSPUtil.getParameter(request, prefix + "agn_curr_cd", ""));
		setRctDocCd(JSPUtil.getParameter(request, prefix + "rct_doc_cd", ""));
		setAgnCmbCd(JSPUtil.getParameter(request, prefix + "agn_cmb_cd", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request, prefix + "rep_ots_ofc_cd", ""));
		setRctUnapyFlg(JSPUtil.getParameter(request, prefix + "rct_unapy_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AROfficeListVO[]
	 */
	public AROfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AROfficeListVO[]
	 */
	public AROfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AROfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcBrncAgnTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_brnc_agn_tp_cd", length));
			String[] agnPfxCd = (JSPUtil.getParameter(request, prefix	+ "agn_pfx_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] agnOtsLmtAmt = (JSPUtil.getParameter(request, prefix	+ "agn_ots_lmt_amt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] bankCtrlCd = (JSPUtil.getParameter(request, prefix	+ "bank_ctrl_cd", length));
			String[] chkOfcYn = (JSPUtil.getParameter(request, prefix	+ "chk_ofc_yn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcEntrLvlCd = (JSPUtil.getParameter(request, prefix	+ "ofc_entr_lvl_cd", length));
			String[] otsCd = (JSPUtil.getParameter(request, prefix	+ "ots_cd", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] rctTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_tp_cd", length));
			String[] agnCurrCd = (JSPUtil.getParameter(request, prefix	+ "agn_curr_cd", length));
			String[] rctDocCd = (JSPUtil.getParameter(request, prefix	+ "rct_doc_cd", length));
			String[] agnCmbCd = (JSPUtil.getParameter(request, prefix	+ "agn_cmb_cd", length));
			String[] repOtsOfcCd = (JSPUtil.getParameter(request, prefix	+ "rep_ots_ofc_cd", length));
			String[] rctUnapyFlg = (JSPUtil.getParameter(request, prefix	+ "rct_unapy_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AROfficeListVO();
				if (ofcBrncAgnTpCd[i] != null)
					model.setOfcBrncAgnTpCd(ofcBrncAgnTpCd[i]);
				if (agnPfxCd[i] != null)
					model.setAgnPfxCd(agnPfxCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (agnOtsLmtAmt[i] != null)
					model.setAgnOtsLmtAmt(agnOtsLmtAmt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (bankCtrlCd[i] != null)
					model.setBankCtrlCd(bankCtrlCd[i]);
				if (chkOfcYn[i] != null)
					model.setChkOfcYn(chkOfcYn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcEntrLvlCd[i] != null)
					model.setOfcEntrLvlCd(ofcEntrLvlCd[i]);
				if (otsCd[i] != null)
					model.setOtsCd(otsCd[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (rctTpCd[i] != null)
					model.setRctTpCd(rctTpCd[i]);
				if (agnCurrCd[i] != null)
					model.setAgnCurrCd(agnCurrCd[i]);
				if (rctDocCd[i] != null)
					model.setRctDocCd(rctDocCd[i]);
				if (agnCmbCd[i] != null)
					model.setAgnCmbCd(agnCmbCd[i]);
				if (repOtsOfcCd[i] != null)
					model.setRepOtsOfcCd(repOtsOfcCd[i]);
				if (rctUnapyFlg[i] != null)
					model.setRctUnapyFlg(rctUnapyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAROfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AROfficeListVO[]
	 */
	public AROfficeListVO[] getAROfficeListVOs(){
		AROfficeListVO[] vos = (AROfficeListVO[])models.toArray(new AROfficeListVO[models.size()]);
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
		this.ofcBrncAgnTpCd = this.ofcBrncAgnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnPfxCd = this.agnPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOtsLmtAmt = this.agnOtsLmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankCtrlCd = this.bankCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOfcYn = this.chkOfcYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEntrLvlCd = this.ofcEntrLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd = this.otsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd = this.rctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCurrCd = this.agnCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDocCd = this.rctDocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCmbCd = this.agnCmbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd = this.repOtsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUnapyFlg = this.rctUnapyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
