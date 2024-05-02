/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InPrsProposalSummarySimulationVO.java
*@FileTitle : InPrsProposalSummarySimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.28 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPrsProposalSummarySimulationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsProposalSummarySimulationVO> models = new ArrayList<InPrsProposalSummarySimulationVO>();
	
	/* Column Info */
	private String destRoutCd = null;
	/* Column Info */
	private String application = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String score = null;
	/* Column Info */
	private String destLocTp = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oriRoutCd = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String propNoList = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String oriLocTp = null;
	/* Column Info */
	private String aprOfcCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String custTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsProposalSummarySimulationVO() {}

	public InPrsProposalSummarySimulationVO(String ibflag, String pagerows, String aprOfcCd, String application, String custTpCd, String calcTpCd, String oriRoutCd, String oriLocTp, String destRoutCd, String destLocTp, String amount, String effDt, String expDt, String chgCd, String svcScpCd, String propNoList, String score) {
		this.destRoutCd = destRoutCd;
		this.application = application;
		this.svcScpCd = svcScpCd;
		this.score = score;
		this.destLocTp = destLocTp;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.oriRoutCd = oriRoutCd;
		this.amount = amount;
		this.propNoList = propNoList;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.oriLocTp = oriLocTp;
		this.aprOfcCd = aprOfcCd;
		this.expDt = expDt;
		this.custTpCd = custTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_cd", getDestRoutCd());
		this.hashColumns.put("application", getApplication());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("score", getScore());
		this.hashColumns.put("dest_loc_tp", getDestLocTp());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ori_rout_cd", getOriRoutCd());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("prop_no_list", getPropNoList());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ori_loc_tp", getOriLocTp());
		this.hashColumns.put("apr_ofc_cd", getAprOfcCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_cd", "destRoutCd");
		this.hashFields.put("application", "application");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("score", "score");
		this.hashFields.put("dest_loc_tp", "destLocTp");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ori_rout_cd", "oriRoutCd");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("prop_no_list", "propNoList");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ori_loc_tp", "oriLocTp");
		this.hashFields.put("apr_ofc_cd", "aprOfcCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destRoutCd
	 */
	public String getDestRoutCd() {
		return this.destRoutCd;
	}
	
	/**
	 * Column Info
	 * @return application
	 */
	public String getApplication() {
		return this.application;
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
	 * @return score
	 */
	public String getScore() {
		return this.score;
	}
	
	/**
	 * Column Info
	 * @return destLocTp
	 */
	public String getDestLocTp() {
		return this.destLocTp;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return oriRoutCd
	 */
	public String getOriRoutCd() {
		return this.oriRoutCd;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return propNoList
	 */
	public String getPropNoList() {
		return this.propNoList;
	}
	
	/**
	 * Column Info
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return oriLocTp
	 */
	public String getOriLocTp() {
		return this.oriLocTp;
	}
	
	/**
	 * Column Info
	 * @return aprOfcCd
	 */
	public String getAprOfcCd() {
		return this.aprOfcCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	

	/**
	 * Column Info
	 * @param destRoutCd
	 */
	public void setDestRoutCd(String destRoutCd) {
		this.destRoutCd = destRoutCd;
	}
	
	/**
	 * Column Info
	 * @param application
	 */
	public void setApplication(String application) {
		this.application = application;
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
	 * @param score
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * Column Info
	 * @param destLocTp
	 */
	public void setDestLocTp(String destLocTp) {
		this.destLocTp = destLocTp;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param oriRoutCd
	 */
	public void setOriRoutCd(String oriRoutCd) {
		this.oriRoutCd = oriRoutCd;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param propNoList
	 */
	public void setPropNoList(String propNoList) {
		this.propNoList = propNoList;
	}
	
	/**
	 * Column Info
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param oriLocTp
	 */
	public void setOriLocTp(String oriLocTp) {
		this.oriLocTp = oriLocTp;
	}
	
	/**
	 * Column Info
	 * @param aprOfcCd
	 */
	public void setAprOfcCd(String aprOfcCd) {
		this.aprOfcCd = aprOfcCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
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
		setDestRoutCd(JSPUtil.getParameter(request, prefix + "dest_rout_cd", ""));
		setApplication(JSPUtil.getParameter(request, prefix + "application", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setScore(JSPUtil.getParameter(request, prefix + "score", ""));
		setDestLocTp(JSPUtil.getParameter(request, prefix + "dest_loc_tp", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOriRoutCd(JSPUtil.getParameter(request, prefix + "ori_rout_cd", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setPropNoList(JSPUtil.getParameter(request, prefix + "prop_no_list", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setOriLocTp(JSPUtil.getParameter(request, prefix + "ori_loc_tp", ""));
		setAprOfcCd(JSPUtil.getParameter(request, prefix + "apr_ofc_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrsProposalSummarySimulationVO[]
	 */
	public InPrsProposalSummarySimulationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrsProposalSummarySimulationVO[]
	 */
	public InPrsProposalSummarySimulationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrsProposalSummarySimulationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_cd", length));
			String[] application = (JSPUtil.getParameter(request, prefix	+ "application", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] score = (JSPUtil.getParameter(request, prefix	+ "score", length));
			String[] destLocTp = (JSPUtil.getParameter(request, prefix	+ "dest_loc_tp", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oriRoutCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_cd", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] propNoList = (JSPUtil.getParameter(request, prefix	+ "prop_no_list", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] oriLocTp = (JSPUtil.getParameter(request, prefix	+ "ori_loc_tp", length));
			String[] aprOfcCd = (JSPUtil.getParameter(request, prefix	+ "apr_ofc_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrsProposalSummarySimulationVO();
				if (destRoutCd[i] != null)
					model.setDestRoutCd(destRoutCd[i]);
				if (application[i] != null)
					model.setApplication(application[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (score[i] != null)
					model.setScore(score[i]);
				if (destLocTp[i] != null)
					model.setDestLocTp(destLocTp[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oriRoutCd[i] != null)
					model.setOriRoutCd(oriRoutCd[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (propNoList[i] != null)
					model.setPropNoList(propNoList[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (oriLocTp[i] != null)
					model.setOriLocTp(oriLocTp[i]);
				if (aprOfcCd[i] != null)
					model.setAprOfcCd(aprOfcCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrsProposalSummarySimulationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrsProposalSummarySimulationVO[]
	 */
	public InPrsProposalSummarySimulationVO[] getInPrsProposalSummarySimulationVOs(){
		InPrsProposalSummarySimulationVO[] vos = (InPrsProposalSummarySimulationVO[])models.toArray(new InPrsProposalSummarySimulationVO[models.size()]);
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
		this.destRoutCd = this.destRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.application = this.application .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.score = this.score .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocTp = this.destLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutCd = this.oriRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNoList = this.propNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLocTp = this.oriLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprOfcCd = this.aprOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
