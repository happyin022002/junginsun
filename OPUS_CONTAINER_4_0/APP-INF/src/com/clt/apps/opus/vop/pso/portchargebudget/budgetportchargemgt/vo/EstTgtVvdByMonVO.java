/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstTgtVvdByMonVO.java
*@FileTitle : EstTgtVvdByMonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.10 박명종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstTgtVvdByMonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstTgtVvdByMonVO> models = new ArrayList<EstTgtVvdByMonVO>();
	
	/* Column Info */
	private String estimaVsActualAmount = null;
	/* Column Info */
	private String budgetVsEstimaAmount = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String combo2 = null;
	/* Column Info */
	private String combo1 = null;
	/* Column Info */
	private String actualCall = null;
	/* Column Info */
	private String budgetCall = null;
	/* Column Info */
	private String creDtTo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String estimaCall = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String budgetVsActualCall = null;
	/* Column Info */
	private String budgetVsEstimaCall = null;
	/* Column Info */
	private String budgetVsActualAmount = null;
	/* Column Info */
	private String estimaVsActualCall = null;
	/* Column Info */
	private String budgetAmount = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String termCode = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String estimaAmount = null;
	/* Column Info */
	private String actualAmount = null;
	/* Column Info */
	private String creDtFr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstTgtVvdByMonVO() {}

	public EstTgtVvdByMonVO(String ibflag, String pagerows, String vslSlanCd, String lgsCostCd, String budgetAmount, String budgetCall, String estimaAmount, String estimaCall, String actualAmount, String actualCall, String budgetVsActualAmount, String budgetVsActualCall, String estimaVsActualAmount, String estimaVsActualCall, String budgetVsEstimaAmount, String budgetVsEstimaCall, String portCd, String termCode, String creDtFr, String creDtTo, String combo1, String combo2, String gubun) {
		this.estimaVsActualAmount = estimaVsActualAmount;
		this.budgetVsEstimaAmount = budgetVsEstimaAmount;
		this.gubun = gubun;
		this.combo2 = combo2;
		this.combo1 = combo1;
		this.actualCall = actualCall;
		this.budgetCall = budgetCall;
		this.creDtTo = creDtTo;
		this.vslSlanCd = vslSlanCd;
		this.estimaCall = estimaCall;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.budgetVsActualCall = budgetVsActualCall;
		this.budgetVsEstimaCall = budgetVsEstimaCall;
		this.budgetVsActualAmount = budgetVsActualAmount;
		this.estimaVsActualCall = estimaVsActualCall;
		this.budgetAmount = budgetAmount;
		this.lgsCostCd = lgsCostCd;
		this.termCode = termCode;
		this.portCd = portCd;
		this.estimaAmount = estimaAmount;
		this.actualAmount = actualAmount;
		this.creDtFr = creDtFr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("estima_vs_actual_amount", getEstimaVsActualAmount());
		this.hashColumns.put("budget_vs_estima_amount", getBudgetVsEstimaAmount());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("combo2", getCombo2());
		this.hashColumns.put("combo1", getCombo1());
		this.hashColumns.put("actual_call", getActualCall());
		this.hashColumns.put("budget_call", getBudgetCall());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("estima_call", getEstimaCall());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("budget_vs_actual_call", getBudgetVsActualCall());
		this.hashColumns.put("budget_vs_estima_call", getBudgetVsEstimaCall());
		this.hashColumns.put("budget_vs_actual_amount", getBudgetVsActualAmount());
		this.hashColumns.put("estima_vs_actual_call", getEstimaVsActualCall());
		this.hashColumns.put("budget_amount", getBudgetAmount());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("term_code", getTermCode());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("estima_amount", getEstimaAmount());
		this.hashColumns.put("actual_amount", getActualAmount());
		this.hashColumns.put("cre_dt_fr", getCreDtFr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("estima_vs_actual_amount", "estimaVsActualAmount");
		this.hashFields.put("budget_vs_estima_amount", "budgetVsEstimaAmount");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("combo2", "combo2");
		this.hashFields.put("combo1", "combo1");
		this.hashFields.put("actual_call", "actualCall");
		this.hashFields.put("budget_call", "budgetCall");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("estima_call", "estimaCall");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("budget_vs_actual_call", "budgetVsActualCall");
		this.hashFields.put("budget_vs_estima_call", "budgetVsEstimaCall");
		this.hashFields.put("budget_vs_actual_amount", "budgetVsActualAmount");
		this.hashFields.put("estima_vs_actual_call", "estimaVsActualCall");
		this.hashFields.put("budget_amount", "budgetAmount");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("term_code", "termCode");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("estima_amount", "estimaAmount");
		this.hashFields.put("actual_amount", "actualAmount");
		this.hashFields.put("cre_dt_fr", "creDtFr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return estimaVsActualAmount
	 */
	public String getEstimaVsActualAmount() {
		return this.estimaVsActualAmount;
	}
	
	/**
	 * Column Info
	 * @return budgetVsEstimaAmount
	 */
	public String getBudgetVsEstimaAmount() {
		return this.budgetVsEstimaAmount;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return combo2
	 */
	public String getCombo2() {
		return this.combo2;
	}
	
	/**
	 * Column Info
	 * @return combo1
	 */
	public String getCombo1() {
		return this.combo1;
	}
	
	/**
	 * Column Info
	 * @return actualCall
	 */
	public String getActualCall() {
		return this.actualCall;
	}
	
	/**
	 * Column Info
	 * @return budgetCall
	 */
	public String getBudgetCall() {
		return this.budgetCall;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return estimaCall
	 */
	public String getEstimaCall() {
		return this.estimaCall;
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
	 * @return budgetVsActualCall
	 */
	public String getBudgetVsActualCall() {
		return this.budgetVsActualCall;
	}
	
	/**
	 * Column Info
	 * @return budgetVsEstimaCall
	 */
	public String getBudgetVsEstimaCall() {
		return this.budgetVsEstimaCall;
	}
	
	/**
	 * Column Info
	 * @return budgetVsActualAmount
	 */
	public String getBudgetVsActualAmount() {
		return this.budgetVsActualAmount;
	}
	
	/**
	 * Column Info
	 * @return estimaVsActualCall
	 */
	public String getEstimaVsActualCall() {
		return this.estimaVsActualCall;
	}
	
	/**
	 * Column Info
	 * @return budgetAmount
	 */
	public String getBudgetAmount() {
		return this.budgetAmount;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return termCode
	 */
	public String getTermCode() {
		return this.termCode;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return estimaAmount
	 */
	public String getEstimaAmount() {
		return this.estimaAmount;
	}
	
	/**
	 * Column Info
	 * @return actualAmount
	 */
	public String getActualAmount() {
		return this.actualAmount;
	}
	
	/**
	 * Column Info
	 * @return creDtFr
	 */
	public String getCreDtFr() {
		return this.creDtFr;
	}
	

	/**
	 * Column Info
	 * @param estimaVsActualAmount
	 */
	public void setEstimaVsActualAmount(String estimaVsActualAmount) {
		this.estimaVsActualAmount = estimaVsActualAmount;
	}
	
	/**
	 * Column Info
	 * @param budgetVsEstimaAmount
	 */
	public void setBudgetVsEstimaAmount(String budgetVsEstimaAmount) {
		this.budgetVsEstimaAmount = budgetVsEstimaAmount;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param combo2
	 */
	public void setCombo2(String combo2) {
		this.combo2 = combo2;
	}
	
	/**
	 * Column Info
	 * @param combo1
	 */
	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}
	
	/**
	 * Column Info
	 * @param actualCall
	 */
	public void setActualCall(String actualCall) {
		this.actualCall = actualCall;
	}
	
	/**
	 * Column Info
	 * @param budgetCall
	 */
	public void setBudgetCall(String budgetCall) {
		this.budgetCall = budgetCall;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param estimaCall
	 */
	public void setEstimaCall(String estimaCall) {
		this.estimaCall = estimaCall;
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
	 * @param budgetVsActualCall
	 */
	public void setBudgetVsActualCall(String budgetVsActualCall) {
		this.budgetVsActualCall = budgetVsActualCall;
	}
	
	/**
	 * Column Info
	 * @param budgetVsEstimaCall
	 */
	public void setBudgetVsEstimaCall(String budgetVsEstimaCall) {
		this.budgetVsEstimaCall = budgetVsEstimaCall;
	}
	
	/**
	 * Column Info
	 * @param budgetVsActualAmount
	 */
	public void setBudgetVsActualAmount(String budgetVsActualAmount) {
		this.budgetVsActualAmount = budgetVsActualAmount;
	}
	
	/**
	 * Column Info
	 * @param estimaVsActualCall
	 */
	public void setEstimaVsActualCall(String estimaVsActualCall) {
		this.estimaVsActualCall = estimaVsActualCall;
	}
	
	/**
	 * Column Info
	 * @param budgetAmount
	 */
	public void setBudgetAmount(String budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param termCode
	 */
	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param estimaAmount
	 */
	public void setEstimaAmount(String estimaAmount) {
		this.estimaAmount = estimaAmount;
	}
	
	/**
	 * Column Info
	 * @param actualAmount
	 */
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	
	/**
	 * Column Info
	 * @param creDtFr
	 */
	public void setCreDtFr(String creDtFr) {
		this.creDtFr = creDtFr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEstimaVsActualAmount(JSPUtil.getParameter(request, "estima_vs_actual_amount", ""));
		setBudgetVsEstimaAmount(JSPUtil.getParameter(request, "budget_vs_estima_amount", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setCombo2(JSPUtil.getParameter(request, "combo2", ""));
		setCombo1(JSPUtil.getParameter(request, "combo1", ""));
		setActualCall(JSPUtil.getParameter(request, "actual_call", ""));
		setBudgetCall(JSPUtil.getParameter(request, "budget_call", ""));
		setCreDtTo(JSPUtil.getParameter(request, "cre_dt_to", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setEstimaCall(JSPUtil.getParameter(request, "estima_call", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBudgetVsActualCall(JSPUtil.getParameter(request, "budget_vs_actual_call", ""));
		setBudgetVsEstimaCall(JSPUtil.getParameter(request, "budget_vs_estima_call", ""));
		setBudgetVsActualAmount(JSPUtil.getParameter(request, "budget_vs_actual_amount", ""));
		setEstimaVsActualCall(JSPUtil.getParameter(request, "estima_vs_actual_call", ""));
		setBudgetAmount(JSPUtil.getParameter(request, "budget_amount", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setTermCode(JSPUtil.getParameter(request, "term_code", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setEstimaAmount(JSPUtil.getParameter(request, "estima_amount", ""));
		setActualAmount(JSPUtil.getParameter(request, "actual_amount", ""));
		setCreDtFr(JSPUtil.getParameter(request, "cre_dt_fr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstTgtVvdByMonVO[]
	 */
	public EstTgtVvdByMonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstTgtVvdByMonVO[]
	 */
	public EstTgtVvdByMonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstTgtVvdByMonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] estimaVsActualAmount = (JSPUtil.getParameter(request, prefix	+ "estima_vs_actual_amount".trim(), length));
			String[] budgetVsEstimaAmount = (JSPUtil.getParameter(request, prefix	+ "budget_vs_estima_amount".trim(), length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun".trim(), length));
			String[] combo2 = (JSPUtil.getParameter(request, prefix	+ "combo2".trim(), length));
			String[] combo1 = (JSPUtil.getParameter(request, prefix	+ "combo1".trim(), length));
			String[] actualCall = (JSPUtil.getParameter(request, prefix	+ "actual_call".trim(), length));
			String[] budgetCall = (JSPUtil.getParameter(request, prefix	+ "budget_call".trim(), length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] estimaCall = (JSPUtil.getParameter(request, prefix	+ "estima_call".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] budgetVsActualCall = (JSPUtil.getParameter(request, prefix	+ "budget_vs_actual_call".trim(), length));
			String[] budgetVsEstimaCall = (JSPUtil.getParameter(request, prefix	+ "budget_vs_estima_call".trim(), length));
			String[] budgetVsActualAmount = (JSPUtil.getParameter(request, prefix	+ "budget_vs_actual_amount".trim(), length));
			String[] estimaVsActualCall = (JSPUtil.getParameter(request, prefix	+ "estima_vs_actual_call".trim(), length));
			String[] budgetAmount = (JSPUtil.getParameter(request, prefix	+ "budget_amount".trim(), length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd".trim(), length));
			String[] termCode = (JSPUtil.getParameter(request, prefix	+ "term_code".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] estimaAmount = (JSPUtil.getParameter(request, prefix	+ "estima_amount".trim(), length));
			String[] actualAmount = (JSPUtil.getParameter(request, prefix	+ "actual_amount".trim(), length));
			String[] creDtFr = (JSPUtil.getParameter(request, prefix	+ "cre_dt_fr".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new EstTgtVvdByMonVO();
				if (estimaVsActualAmount[i] != null)
					model.setEstimaVsActualAmount(estimaVsActualAmount[i]);
				if (budgetVsEstimaAmount[i] != null)
					model.setBudgetVsEstimaAmount(budgetVsEstimaAmount[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (combo2[i] != null)
					model.setCombo2(combo2[i]);
				if (combo1[i] != null)
					model.setCombo1(combo1[i]);
				if (actualCall[i] != null)
					model.setActualCall(actualCall[i]);
				if (budgetCall[i] != null)
					model.setBudgetCall(budgetCall[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (estimaCall[i] != null)
					model.setEstimaCall(estimaCall[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (budgetVsActualCall[i] != null)
					model.setBudgetVsActualCall(budgetVsActualCall[i]);
				if (budgetVsEstimaCall[i] != null)
					model.setBudgetVsEstimaCall(budgetVsEstimaCall[i]);
				if (budgetVsActualAmount[i] != null)
					model.setBudgetVsActualAmount(budgetVsActualAmount[i]);
				if (estimaVsActualCall[i] != null)
					model.setEstimaVsActualCall(estimaVsActualCall[i]);
				if (budgetAmount[i] != null)
					model.setBudgetAmount(budgetAmount[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (termCode[i] != null)
					model.setTermCode(termCode[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (estimaAmount[i] != null)
					model.setEstimaAmount(estimaAmount[i]);
				if (actualAmount[i] != null)
					model.setActualAmount(actualAmount[i]);
				if (creDtFr[i] != null)
					model.setCreDtFr(creDtFr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstTgtVvdByMonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstTgtVvdByMonVO[]
	 */
	public EstTgtVvdByMonVO[] getEstTgtVvdByMonVOs(){
		EstTgtVvdByMonVO[] vos = (EstTgtVvdByMonVO[])models.toArray(new EstTgtVvdByMonVO[models.size()]);
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
		this.estimaVsActualAmount = this.estimaVsActualAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budgetVsEstimaAmount = this.budgetVsEstimaAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo2 = this.combo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo1 = this.combo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualCall = this.actualCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budgetCall = this.budgetCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estimaCall = this.estimaCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budgetVsActualCall = this.budgetVsActualCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budgetVsEstimaCall = this.budgetVsEstimaCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budgetVsActualAmount = this.budgetVsActualAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estimaVsActualCall = this.estimaVsActualCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budgetAmount = this.budgetAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCode = this.termCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estimaAmount = this.estimaAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualAmount = this.actualAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtFr = this.creDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
