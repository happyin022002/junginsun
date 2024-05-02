/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActSkdDtlVO.java
*@FileTitle : ActSkdDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.09.02 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActSkdDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActSkdDtlVO> models = new ArrayList<ActSkdDtlVO>();
	
	/* Column Info */
	private String actBrthDt = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String atbOverDays = null;
	/* Column Info */
	private String rptAtd = null;
	/* Column Info */
	private String rptAtb = null;
	/* Column Info */
	private String rptAta = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String actArrDt = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String actDepDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String optHrs = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String ataOverDays = null;
	/* Column Info */
	private String atdOverDays = null;
	
	/* Column Info */
	private String inputATADateEffectiveness = null;
	/* Column Info */
	private String inputATBDateEffectiveness = null;
	/* Column Info */
	private String inputATDDateEffectiveness = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActSkdDtlVO() {}

	public ActSkdDtlVO(String ibflag, String pagerows, String vslSlanCd, String slsOfcCd, String vpsPortCd, String ydCd, String tmlCd, String vvd, String vpsEtaDt, String actArrDt, String rptAta, String ataOverDays, String vpsEtbDt, String actBrthDt, String rptAtb, String atbOverDays, String vpsEtdDt, String actDepDt, String rptAtd, String atdOverDays, String optHrs) {
		this.actBrthDt = actBrthDt;
		this.vpsEtbDt = vpsEtbDt;
		this.vpsEtdDt = vpsEtdDt;
		this.atbOverDays = atbOverDays;
		this.rptAtd = rptAtd;
		this.rptAtb = rptAtb;
		this.rptAta = rptAta;
		this.vslSlanCd = vslSlanCd;
		this.actArrDt = actArrDt;
		this.tmlCd = tmlCd;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.actDepDt = actDepDt;
		this.ibflag = ibflag;
		this.optHrs = optHrs;
		this.ydCd = ydCd;
		this.slsOfcCd = slsOfcCd;
		this.ataOverDays = ataOverDays;
		this.inputATADateEffectiveness = inputATADateEffectiveness;
		this.inputATBDateEffectiveness = inputATBDateEffectiveness;
		this.inputATDDateEffectiveness = inputATDDateEffectiveness;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_brth_dt", getActBrthDt());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("atb_over_days", getAtbOverDays());
		this.hashColumns.put("rpt_atd", getRptAtd());
		this.hashColumns.put("rpt_atb", getRptAtb());
		this.hashColumns.put("rpt_ata", getRptAta());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opt_hrs", getOptHrs());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("ata_over_days", getAtaOverDays());
		this.hashColumns.put("atd_over_days", getAtdOverDays());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_brth_dt", "actBrthDt");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("atb_over_days", "atbOverDays");
		this.hashFields.put("rpt_atd", "rptAtd");
		this.hashFields.put("rpt_atb", "rptAtb");
		this.hashFields.put("rpt_ata", "rptAta");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opt_hrs", "optHrs");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("ata_over_days", "ataOverDays");
		this.hashFields.put("atd_over_days", "atdOverDays");
		
		this.hashFields.put("input_ata_date_effectiveness", "inputATADateEffectiveness");
		this.hashFields.put("input_atb_date_effectiveness", "inputATBDateEffectiveness");
		this.hashFields.put("input_atd_date_effectiveness", "inputATDDateEffectiveness");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actBrthDt
	 */
	public String getActBrthDt() {
		return this.actBrthDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return atbOverDays
	 */
	public String getAtbOverDays() {
		return this.atbOverDays;
	}
	
	/**
	 * Column Info
	 * @return rptAtd
	 */
	public String getRptAtd() {
		return this.rptAtd;
	}
	
	/**
	 * Column Info
	 * @return rptAtb
	 */
	public String getRptAtb() {
		return this.rptAtb;
	}
	
	/**
	 * Column Info
	 * @return rptAta
	 */
	public String getRptAta() {
		return this.rptAta;
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
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
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
	 * @return optHrs
	 */
	public String getOptHrs() {
		return this.optHrs;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ataOverDays
	 */
	public String getAtaOverDays() {
		return this.ataOverDays;
	}
	
	/**
	 * Column Info
	 * @return atdOverDays
	 */
	public String getAtdOverDays() {
		return this.atdOverDays;
	}
	
	
	/**
	 * Column Info
	 * @return inputATADateEffectiveness
	 */
	public String getInputATADateEffectiveness() {
		return this.inputATADateEffectiveness;
	}
	/**
	 * Column Info
	 * @return inputATBDateEffectiveness
	 */
	public String getInputATBDateEffectiveness() {
		return this.inputATBDateEffectiveness;
	}
	/**
	 * Column Info
	 * @return inputATDDateEffectiveness
	 */
	public String getInputATDDateEffectiveness() {
		return this.inputATDDateEffectiveness;
	}
	
	/**
	 * Column Info
	 * @param inputATADateEffectiveness
	 */
	public void setInputATADateEffectiveness(String inputATADateEffectiveness) {
		this.inputATADateEffectiveness = inputATADateEffectiveness;
	}
	/**
	 * Column Info
	 * @param inputATBDateEffectiveness
	 */
	public void setInputATBDateEffectiveness(String inputATBDateEffectiveness) {
		this.inputATBDateEffectiveness = inputATBDateEffectiveness;
	}
	/**
	 * Column Info
	 * @param inputATDDateEffectiveness
	 */
	public void setInputATDDateEffectiveness(String inputATDDateEffectiveness) {
		this.inputATDDateEffectiveness = inputATDDateEffectiveness;
	}
	
	
	
	/**
	 * Column Info
	 * @param actBrthDt
	 */
	public void setActBrthDt(String actBrthDt) {
		this.actBrthDt = actBrthDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param atbOverDays
	 */
	public void setAtbOverDays(String atbOverDays) {
		this.atbOverDays = atbOverDays;
	}
	
	/**
	 * Column Info
	 * @param rptAtd
	 */
	public void setRptAtd(String rptAtd) {
		this.rptAtd = rptAtd;
	}
	
	/**
	 * Column Info
	 * @param rptAtb
	 */
	public void setRptAtb(String rptAtb) {
		this.rptAtb = rptAtb;
	}
	
	/**
	 * Column Info
	 * @param rptAta
	 */
	public void setRptAta(String rptAta) {
		this.rptAta = rptAta;
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
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
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
	 * @param optHrs
	 */
	public void setOptHrs(String optHrs) {
		this.optHrs = optHrs;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ataOverDays
	 */
	public void setAtaOverDays(String ataOverDays) {
		this.ataOverDays = ataOverDays;
	}
	
	/**
	 * Column Info
	 * @param atdOverDays
	 */
	public void setAtdOverDays(String atdOverDays) {
		this.atdOverDays = atdOverDays;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActBrthDt(JSPUtil.getParameter(request, "act_brth_dt", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setAtbOverDays(JSPUtil.getParameter(request, "atb_over_days", ""));
		setRptAtd(JSPUtil.getParameter(request, "rpt_atd", ""));
		setRptAtb(JSPUtil.getParameter(request, "rpt_atb", ""));
		setRptAta(JSPUtil.getParameter(request, "rpt_ata", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setActDepDt(JSPUtil.getParameter(request, "act_dep_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOptHrs(JSPUtil.getParameter(request, "opt_hrs", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setAtaOverDays(JSPUtil.getParameter(request, "ata_over_days", ""));
		setAtdOverDays(JSPUtil.getParameter(request, "atd_over_days", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActSkdDtlVO[]
	 */
	public ActSkdDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActSkdDtlVO[]
	 */
	public ActSkdDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActSkdDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actBrthDt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] atbOverDays = (JSPUtil.getParameter(request, prefix	+ "atb_over_days", length));
			String[] rptAtd = (JSPUtil.getParameter(request, prefix	+ "rpt_atd", length));
			String[] rptAtb = (JSPUtil.getParameter(request, prefix	+ "rpt_atb", length));
			String[] rptAta = (JSPUtil.getParameter(request, prefix	+ "rpt_ata", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] optHrs = (JSPUtil.getParameter(request, prefix	+ "opt_hrs", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] ataOverDays = (JSPUtil.getParameter(request, prefix	+ "ata_over_days", length));
			String[] atdOverDays = (JSPUtil.getParameter(request, prefix	+ "atd_over_days", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActSkdDtlVO();
				if (actBrthDt[i] != null)
					model.setActBrthDt(actBrthDt[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (atbOverDays[i] != null)
					model.setAtbOverDays(atbOverDays[i]);
				if (rptAtd[i] != null)
					model.setRptAtd(rptAtd[i]);
				if (rptAtb[i] != null)
					model.setRptAtb(rptAtb[i]);
				if (rptAta[i] != null)
					model.setRptAta(rptAta[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (optHrs[i] != null)
					model.setOptHrs(optHrs[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (ataOverDays[i] != null)
					model.setAtaOverDays(ataOverDays[i]);
				if (atdOverDays[i] != null)
					model.setAtdOverDays(atdOverDays[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActSkdDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActSkdDtlVO[]
	 */
	public ActSkdDtlVO[] getActSkdDtlVOs(){
		ActSkdDtlVO[] vos = (ActSkdDtlVO[])models.toArray(new ActSkdDtlVO[models.size()]);
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
		this.actBrthDt = this.actBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbOverDays = this.atbOverDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptAtd = this.rptAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptAtb = this.rptAtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptAta = this.rptAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optHrs = this.optHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataOverDays = this.ataOverDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdOverDays = this.atdOverDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
