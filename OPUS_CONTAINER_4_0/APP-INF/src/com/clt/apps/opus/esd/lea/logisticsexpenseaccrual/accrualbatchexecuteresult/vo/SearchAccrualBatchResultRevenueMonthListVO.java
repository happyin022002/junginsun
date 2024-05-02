/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultRevenueMonthListVO.java
*@FileTitle : SearchAccrualBatchResultRevenueMonthListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.08 전재홍 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
  
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchResultRevenueMonthListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultRevenueMonthListVO> models = new ArrayList<SearchAccrualBatchResultRevenueMonthListVO>();
	
	/* Column Info */
	private String fCostTypeF = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String preActCostAmt = null;
	/* Column Info */
	private String frmExeYrmon = null;
	/* Column Info */
	private String pstActCostAmt = null;
	/* Column Info */
	private String diffCostAmt = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String mnCostTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmRevYrmonFrom = null;
	/* Column Info */
	private String actCostRatio = null;
	/* Column Info */
	private String diffActCostAmt = null;
	/* Column Info */
	private String confirmedCostAmt = null;
	/* Column Info */
	private String subCostTpCd = null;
	/* Column Info */
	private String fCostTypeM = null;
	/* Column Info */
	private String frmRevYrmonTo = null;
	/* Column Info */
	private String frmRetrieveDiv = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultRevenueMonthListVO() {}

	public SearchAccrualBatchResultRevenueMonthListVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String mnCostTpCd, String subCostTpCd, String subCostTpNm, String estmCostAmt, String preActCostAmt, String pstActCostAmt, String diffActCostAmt, String actCostRatio, String acclCostAmt, String confirmedCostAmt, String diffCostAmt, String frmExeYrmon, String frmRevYrmonFrom, String frmRevYrmonTo, String fCostTypeF, String fCostTypeM, String frmRetrieveDiv) {
		this.fCostTypeF = fCostTypeF;
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.acclCostAmt = acclCostAmt;
		this.preActCostAmt = preActCostAmt;
		this.frmExeYrmon = frmExeYrmon;
		this.pstActCostAmt = pstActCostAmt;
		this.diffCostAmt = diffCostAmt;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.subCostTpNm = subCostTpNm;
		this.mnCostTpCd = mnCostTpCd;
		this.ibflag = ibflag;
		this.frmRevYrmonFrom = frmRevYrmonFrom;
		this.actCostRatio = actCostRatio;
		this.diffActCostAmt = diffActCostAmt;
		this.confirmedCostAmt = confirmedCostAmt;
		this.subCostTpCd = subCostTpCd;
		this.fCostTypeM = fCostTypeM;
		this.frmRevYrmonTo = frmRevYrmonTo;
		this.frmRetrieveDiv = frmRetrieveDiv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_cost_type_f", getFCostTypeF());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("pre_act_cost_amt", getPreActCostAmt());
		this.hashColumns.put("frm_exe_yrmon", getFrmExeYrmon());
		this.hashColumns.put("pst_act_cost_amt", getPstActCostAmt());
		this.hashColumns.put("diff_cost_amt", getDiffCostAmt());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("mn_cost_tp_cd", getMnCostTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_rev_yrmon_from", getFrmRevYrmonFrom());
		this.hashColumns.put("act_cost_ratio", getActCostRatio());
		this.hashColumns.put("diff_act_cost_amt", getDiffActCostAmt());
		this.hashColumns.put("confirmed_cost_amt", getConfirmedCostAmt());
		this.hashColumns.put("sub_cost_tp_cd", getSubCostTpCd());
		this.hashColumns.put("f_cost_type_m", getFCostTypeM());
		this.hashColumns.put("frm_rev_yrmon_to", getFrmRevYrmonTo());
		this.hashColumns.put("frm_retrieveDiv", getFrmRetrieveDiv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_cost_type_f", "fCostTypeF");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("pre_act_cost_amt", "preActCostAmt");
		this.hashFields.put("frm_exe_yrmon", "frmExeYrmon");
		this.hashFields.put("pst_act_cost_amt", "pstActCostAmt");
		this.hashFields.put("diff_cost_amt", "diffCostAmt");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("mn_cost_tp_cd", "mnCostTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_rev_yrmon_from", "frmRevYrmonFrom");
		this.hashFields.put("act_cost_ratio", "actCostRatio");
		this.hashFields.put("diff_act_cost_amt", "diffActCostAmt");
		this.hashFields.put("confirmed_cost_amt", "confirmedCostAmt");
		this.hashFields.put("sub_cost_tp_cd", "subCostTpCd");
		this.hashFields.put("f_cost_type_m", "fCostTypeM");
		this.hashFields.put("frm_rev_yrmon_to", "frmRevYrmonTo");
		this.hashFields.put("frm_retrieveDiv", "frmRetrieveDiv");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeF
	 */
	public String getFCostTypeF() {
		return this.fCostTypeF;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
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
	 * @return acclCostAmt
	 */
	public String getAcclCostAmt() {
		return this.acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @return preActCostAmt
	 */
	public String getPreActCostAmt() {
		return this.preActCostAmt;
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
	 * @return pstActCostAmt
	 */
	public String getPstActCostAmt() {
		return this.pstActCostAmt;
	}
	
	/**
	 * Column Info
	 * @return diffCostAmt
	 */
	public String getDiffCostAmt() {
		return this.diffCostAmt;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
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
	 * @return subCostTpNm
	 */
	public String getSubCostTpNm() {
		return this.subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @return mnCostTpCd
	 */
	public String getMnCostTpCd() {
		return this.mnCostTpCd;
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
	 * @return frmRevYrmonFrom
	 */
	public String getFrmRevYrmonFrom() {
		return this.frmRevYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @return actCostRatio
	 */
	public String getActCostRatio() {
		return this.actCostRatio;
	}
	
	/**
	 * Column Info
	 * @return diffActCostAmt
	 */
	public String getDiffActCostAmt() {
		return this.diffActCostAmt;
	}
	
	/**
	 * Column Info
	 * @return confirmedCostAmt
	 */
	public String getConfirmedCostAmt() {
		return this.confirmedCostAmt;
	}
	
	/**
	 * Column Info
	 * @return subCostTpCd
	 */
	public String getSubCostTpCd() {
		return this.subCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeM
	 */
	public String getFCostTypeM() {
		return this.fCostTypeM;
	}
	
	/**
	 * Column Info
	 * @return frmRevYrmonTo
	 */
	public String getFrmRevYrmonTo() {
		return this.frmRevYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return frmRetrieveDiv
	 */
	public String getFrmRetrieveDiv() {
		return this.frmRetrieveDiv;
	}
	
	

	/**
	 * Column Info
	 * @param fCostTypeF
	 */
	public void setFCostTypeF(String fCostTypeF) {
		this.fCostTypeF = fCostTypeF;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
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
	 * @param acclCostAmt
	 */
	public void setAcclCostAmt(String acclCostAmt) {
		this.acclCostAmt = acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @param preActCostAmt
	 */
	public void setPreActCostAmt(String preActCostAmt) {
		this.preActCostAmt = preActCostAmt;
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
	 * @param pstActCostAmt
	 */
	public void setPstActCostAmt(String pstActCostAmt) {
		this.pstActCostAmt = pstActCostAmt;
	}
	
	/**
	 * Column Info
	 * @param diffCostAmt
	 */
	public void setDiffCostAmt(String diffCostAmt) {
		this.diffCostAmt = diffCostAmt;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
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
	 * @param subCostTpNm
	 */
	public void setSubCostTpNm(String subCostTpNm) {
		this.subCostTpNm = subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param mnCostTpCd
	 */
	public void setMnCostTpCd(String mnCostTpCd) {
		this.mnCostTpCd = mnCostTpCd;
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
	 * @param frmRevYrmonFrom
	 */
	public void setFrmRevYrmonFrom(String frmRevYrmonFrom) {
		this.frmRevYrmonFrom = frmRevYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @param actCostRatio
	 */
	public void setActCostRatio(String actCostRatio) {
		this.actCostRatio = actCostRatio;
	}
	
	/**
	 * Column Info
	 * @param diffActCostAmt
	 */
	public void setDiffActCostAmt(String diffActCostAmt) {
		this.diffActCostAmt = diffActCostAmt;
	}
	
	/**
	 * Column Info
	 * @param confirmedCostAmt
	 */
	public void setConfirmedCostAmt(String confirmedCostAmt) {
		this.confirmedCostAmt = confirmedCostAmt;
	}
	
	/**
	 * Column Info
	 * @param subCostTpCd
	 */
	public void setSubCostTpCd(String subCostTpCd) {
		this.subCostTpCd = subCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeM
	 */
	public void setFCostTypeM(String fCostTypeM) {
		this.fCostTypeM = fCostTypeM;
	}
	
	/**
	 * Column Info
	 * @param frmRevYrmonTo
	 */
	public void setFrmRevYrmonTo(String frmRevYrmonTo) {
		this.frmRevYrmonTo = frmRevYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param frmRetrieveDiv
	 */
	public void setFrmRetrieveDiv(String frmRetrieveDiv) {
		this.frmRetrieveDiv = frmRetrieveDiv;
	}
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFCostTypeF(JSPUtil.getParameter(request, "f_cost_type_f", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, "accl_cost_amt", ""));
		setPreActCostAmt(JSPUtil.getParameter(request, "pre_act_cost_amt", ""));
		setFrmExeYrmon(JSPUtil.getParameter(request, "frm_exe_yrmon", ""));
		setPstActCostAmt(JSPUtil.getParameter(request, "pst_act_cost_amt", ""));
		setDiffCostAmt(JSPUtil.getParameter(request, "diff_cost_amt", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, "sub_cost_tp_nm", ""));
		setMnCostTpCd(JSPUtil.getParameter(request, "mn_cost_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrmRevYrmonFrom(JSPUtil.getParameter(request, "frm_rev_yrmon_from", ""));
		setActCostRatio(JSPUtil.getParameter(request, "act_cost_ratio", ""));
		setDiffActCostAmt(JSPUtil.getParameter(request, "diff_act_cost_amt", ""));
		setConfirmedCostAmt(JSPUtil.getParameter(request, "confirmed_cost_amt", ""));
		setSubCostTpCd(JSPUtil.getParameter(request, "sub_cost_tp_cd", ""));
		setFCostTypeM(JSPUtil.getParameter(request, "f_cost_type_m", ""));
		setFrmRevYrmonTo(JSPUtil.getParameter(request, "frm_rev_yrmon_to", ""));
		setFrmRetrieveDiv(JSPUtil.getParameter(request, "frm_retrieveDiv", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultRevenueMonthListVO[]
	 */
	public SearchAccrualBatchResultRevenueMonthListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultRevenueMonthListVO[]
	 */
	public SearchAccrualBatchResultRevenueMonthListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultRevenueMonthListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fCostTypeF = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_f", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] preActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pre_act_cost_amt", length));
			String[] frmExeYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_exe_yrmon", length));
			String[] pstActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pst_act_cost_amt", length));
			String[] diffCostAmt = (JSPUtil.getParameter(request, prefix	+ "diff_cost_amt", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] mnCostTpCd = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmRevYrmonFrom = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_from", length));
			String[] actCostRatio = (JSPUtil.getParameter(request, prefix	+ "act_cost_ratio", length));
			String[] diffActCostAmt = (JSPUtil.getParameter(request, prefix	+ "diff_act_cost_amt", length));
			String[] confirmedCostAmt = (JSPUtil.getParameter(request, prefix	+ "confirmed_cost_amt", length));
			String[] subCostTpCd = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_cd", length));
			String[] fCostTypeM = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_m", length));
			String[] frmRevYrmonTo = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_to", length));
			String[] frmRetrieveDiv = (JSPUtil.getParameter(request, prefix	+ "frm_retrieveDiv", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultRevenueMonthListVO();
				if (fCostTypeF[i] != null)
					model.setFCostTypeF(fCostTypeF[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (preActCostAmt[i] != null)
					model.setPreActCostAmt(preActCostAmt[i]);
				if (frmExeYrmon[i] != null)
					model.setFrmExeYrmon(frmExeYrmon[i]);
				if (pstActCostAmt[i] != null)
					model.setPstActCostAmt(pstActCostAmt[i]);
				if (diffCostAmt[i] != null)
					model.setDiffCostAmt(diffCostAmt[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (mnCostTpCd[i] != null)
					model.setMnCostTpCd(mnCostTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmRevYrmonFrom[i] != null)
					model.setFrmRevYrmonFrom(frmRevYrmonFrom[i]);
				if (actCostRatio[i] != null)
					model.setActCostRatio(actCostRatio[i]);
				if (diffActCostAmt[i] != null)
					model.setDiffActCostAmt(diffActCostAmt[i]);
				if (confirmedCostAmt[i] != null)
					model.setConfirmedCostAmt(confirmedCostAmt[i]);
				if (subCostTpCd[i] != null)
					model.setSubCostTpCd(subCostTpCd[i]);
				if (fCostTypeM[i] != null)
					model.setFCostTypeM(fCostTypeM[i]);
				if (frmRevYrmonTo[i] != null)
					model.setFrmRevYrmonTo(frmRevYrmonTo[i]);
				if (frmRetrieveDiv[i] != null)
					model.setFrmRetrieveDiv(frmRetrieveDiv[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultRevenueMonthListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultRevenueMonthListVO[]
	 */
	public SearchAccrualBatchResultRevenueMonthListVO[] getSearchAccrualBatchResultRevenueMonthListVOs(){
		SearchAccrualBatchResultRevenueMonthListVO[] vos = (SearchAccrualBatchResultRevenueMonthListVO[])models.toArray(new SearchAccrualBatchResultRevenueMonthListVO[models.size()]);
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
		this.fCostTypeF = this.fCostTypeF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preActCostAmt = this.preActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmExeYrmon = this.frmExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstActCostAmt = this.pstActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCostAmt = this.diffCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpCd = this.mnCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonFrom = this.frmRevYrmonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostRatio = this.actCostRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffActCostAmt = this.diffActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmedCostAmt = this.confirmedCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpCd = this.subCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeM = this.fCostTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonTo = this.frmRevYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRetrieveDiv = this.frmRetrieveDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
