/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsProposalSummarySimulationListVO.java
*@FileTitle : RsltPrsProposalSummarySimulationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.18 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPrsProposalSummarySimulationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsProposalSummarySimulationListVO> models = new ArrayList<RsltPrsProposalSummarySimulationListVO>();
	
	/* Column Info */
	private String opbOffice = null;
	/* Column Info */
	private String simulTpCd = null;
	/* Column Info */
	private String cmpbTrade = null;
	/* Column Info */
	private String cmpbOffice = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String gRev = null;
	/* Column Info */
	private String opOffice = null;
	/* Column Info */
	private String cmTrade = null;
	/* Column Info */
	private String surcharge = null;
	/* Column Info */
	private String costTrade = null;
	/* Column Info */
	private String cmOffice = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String costOpOffice = null;
	/* Column Info */
	private String costOffice = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsProposalSummarySimulationListVO() {}

	public RsltPrsProposalSummarySimulationListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String load, String gRev, String costTrade, String costOffice, String costOpOffice, String rate, String surcharge, String cmOffice, String cmTrade, String opOffice, String cmpbOffice, String cmpbTrade, String opbOffice, String simulTpCd) {
		this.opbOffice = opbOffice;
		this.simulTpCd = simulTpCd;
		this.cmpbTrade = cmpbTrade;
		this.cmpbOffice = cmpbOffice;
		this.amdtSeq = amdtSeq;
		this.gRev = gRev;
		this.opOffice = opOffice;
		this.cmTrade = cmTrade;
		this.surcharge = surcharge;
		this.costTrade = costTrade;
		this.cmOffice = cmOffice;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rate = rate;
		this.propNo = propNo;
		this.load = load;
		this.costOpOffice = costOpOffice;
		this.costOffice = costOffice;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("opb_office", getOpbOffice());
		this.hashColumns.put("simul_tp_cd", getSimulTpCd());
		this.hashColumns.put("cmpb_trade", getCmpbTrade());
		this.hashColumns.put("cmpb_office", getCmpbOffice());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("g_rev", getGRev());
		this.hashColumns.put("op_office", getOpOffice());
		this.hashColumns.put("cm_trade", getCmTrade());
		this.hashColumns.put("surcharge", getSurcharge());
		this.hashColumns.put("cost_trade", getCostTrade());
		this.hashColumns.put("cm_office", getCmOffice());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("cost_op_office", getCostOpOffice());
		this.hashColumns.put("cost_office", getCostOffice());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("opb_office", "opbOffice");
		this.hashFields.put("simul_tp_cd", "simulTpCd");
		this.hashFields.put("cmpb_trade", "cmpbTrade");
		this.hashFields.put("cmpb_office", "cmpbOffice");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("g_rev", "gRev");
		this.hashFields.put("op_office", "opOffice");
		this.hashFields.put("cm_trade", "cmTrade");
		this.hashFields.put("surcharge", "surcharge");
		this.hashFields.put("cost_trade", "costTrade");
		this.hashFields.put("cm_office", "cmOffice");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("load", "load");
		this.hashFields.put("cost_op_office", "costOpOffice");
		this.hashFields.put("cost_office", "costOffice");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return opbOffice
	 */
	public String getOpbOffice() {
		return this.opbOffice;
	}
	
	/**
	 * Column Info
	 * @return simulTpCd
	 */
	public String getSimulTpCd() {
		return this.simulTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbTrade
	 */
	public String getCmpbTrade() {
		return this.cmpbTrade;
	}
	
	/**
	 * Column Info
	 * @return cmpbOffice
	 */
	public String getCmpbOffice() {
		return this.cmpbOffice;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return gRev
	 */
	public String getGRev() {
		return this.gRev;
	}
	
	/**
	 * Column Info
	 * @return opOffice
	 */
	public String getOpOffice() {
		return this.opOffice;
	}
	
	/**
	 * Column Info
	 * @return cmTrade
	 */
	public String getCmTrade() {
		return this.cmTrade;
	}
	
	/**
	 * Column Info
	 * @return surcharge
	 */
	public String getSurcharge() {
		return this.surcharge;
	}
	
	/**
	 * Column Info
	 * @return costTrade
	 */
	public String getCostTrade() {
		return this.costTrade;
	}
	
	/**
	 * Column Info
	 * @return cmOffice
	 */
	public String getCmOffice() {
		return this.cmOffice;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return costOpOffice
	 */
	public String getCostOpOffice() {
		return this.costOpOffice;
	}
	
	/**
	 * Column Info
	 * @return costOffice
	 */
	public String getCostOffice() {
		return this.costOffice;
	}
	

	/**
	 * Column Info
	 * @param opbOffice
	 */
	public void setOpbOffice(String opbOffice) {
		this.opbOffice = opbOffice;
	}
	
	/**
	 * Column Info
	 * @param simulTpCd
	 */
	public void setSimulTpCd(String simulTpCd) {
		this.simulTpCd = simulTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbTrade
	 */
	public void setCmpbTrade(String cmpbTrade) {
		this.cmpbTrade = cmpbTrade;
	}
	
	/**
	 * Column Info
	 * @param cmpbOffice
	 */
	public void setCmpbOffice(String cmpbOffice) {
		this.cmpbOffice = cmpbOffice;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param gRev
	 */
	public void setGRev(String gRev) {
		this.gRev = gRev;
	}
	
	/**
	 * Column Info
	 * @param opOffice
	 */
	public void setOpOffice(String opOffice) {
		this.opOffice = opOffice;
	}
	
	/**
	 * Column Info
	 * @param cmTrade
	 */
	public void setCmTrade(String cmTrade) {
		this.cmTrade = cmTrade;
	}
	
	/**
	 * Column Info
	 * @param surcharge
	 */
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	
	/**
	 * Column Info
	 * @param costTrade
	 */
	public void setCostTrade(String costTrade) {
		this.costTrade = costTrade;
	}
	
	/**
	 * Column Info
	 * @param cmOffice
	 */
	public void setCmOffice(String cmOffice) {
		this.cmOffice = cmOffice;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param costOpOffice
	 */
	public void setCostOpOffice(String costOpOffice) {
		this.costOpOffice = costOpOffice;
	}
	
	/**
	 * Column Info
	 * @param costOffice
	 */
	public void setCostOffice(String costOffice) {
		this.costOffice = costOffice;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOpbOffice(JSPUtil.getParameter(request, "opb_office", ""));
		setSimulTpCd(JSPUtil.getParameter(request, "simul_tp_cd", ""));
		setCmpbTrade(JSPUtil.getParameter(request, "cmpb_trade", ""));
		setCmpbOffice(JSPUtil.getParameter(request, "cmpb_office", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setGRev(JSPUtil.getParameter(request, "g_rev", ""));
		setOpOffice(JSPUtil.getParameter(request, "op_office", ""));
		setCmTrade(JSPUtil.getParameter(request, "cm_trade", ""));
		setSurcharge(JSPUtil.getParameter(request, "surcharge", ""));
		setCostTrade(JSPUtil.getParameter(request, "cost_trade", ""));
		setCmOffice(JSPUtil.getParameter(request, "cm_office", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
		setCostOpOffice(JSPUtil.getParameter(request, "cost_op_office", ""));
		setCostOffice(JSPUtil.getParameter(request, "cost_office", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsProposalSummarySimulationListVO[]
	 */
	public RsltPrsProposalSummarySimulationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsProposalSummarySimulationListVO[]
	 */
	public RsltPrsProposalSummarySimulationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsProposalSummarySimulationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] opbOffice = (JSPUtil.getParameter(request, prefix	+ "opb_office", length));
			String[] simulTpCd = (JSPUtil.getParameter(request, prefix	+ "simul_tp_cd", length));
			String[] cmpbTrade = (JSPUtil.getParameter(request, prefix	+ "cmpb_trade", length));
			String[] cmpbOffice = (JSPUtil.getParameter(request, prefix	+ "cmpb_office", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] gRev = (JSPUtil.getParameter(request, prefix	+ "g_rev", length));
			String[] opOffice = (JSPUtil.getParameter(request, prefix	+ "op_office", length));
			String[] cmTrade = (JSPUtil.getParameter(request, prefix	+ "cm_trade", length));
			String[] surcharge = (JSPUtil.getParameter(request, prefix	+ "surcharge", length));
			String[] costTrade = (JSPUtil.getParameter(request, prefix	+ "cost_trade", length));
			String[] cmOffice = (JSPUtil.getParameter(request, prefix	+ "cm_office", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] costOpOffice = (JSPUtil.getParameter(request, prefix	+ "cost_op_office", length));
			String[] costOffice = (JSPUtil.getParameter(request, prefix	+ "cost_office", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsProposalSummarySimulationListVO();
				if (opbOffice[i] != null)
					model.setOpbOffice(opbOffice[i]);
				if (simulTpCd[i] != null)
					model.setSimulTpCd(simulTpCd[i]);
				if (cmpbTrade[i] != null)
					model.setCmpbTrade(cmpbTrade[i]);
				if (cmpbOffice[i] != null)
					model.setCmpbOffice(cmpbOffice[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (gRev[i] != null)
					model.setGRev(gRev[i]);
				if (opOffice[i] != null)
					model.setOpOffice(opOffice[i]);
				if (cmTrade[i] != null)
					model.setCmTrade(cmTrade[i]);
				if (surcharge[i] != null)
					model.setSurcharge(surcharge[i]);
				if (costTrade[i] != null)
					model.setCostTrade(costTrade[i]);
				if (cmOffice[i] != null)
					model.setCmOffice(cmOffice[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (costOpOffice[i] != null)
					model.setCostOpOffice(costOpOffice[i]);
				if (costOffice[i] != null)
					model.setCostOffice(costOffice[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsProposalSummarySimulationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsProposalSummarySimulationListVO[]
	 */
	public RsltPrsProposalSummarySimulationListVO[] getRsltPrsProposalSummarySimulationListVOs(){
		RsltPrsProposalSummarySimulationListVO[] vos = (RsltPrsProposalSummarySimulationListVO[])models.toArray(new RsltPrsProposalSummarySimulationListVO[models.size()]);
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
		this.opbOffice = this.opbOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simulTpCd = this.simulTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbTrade = this.cmpbTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbOffice = this.cmpbOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRev = this.gRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opOffice = this.opOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmTrade = this.cmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surcharge = this.surcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrade = this.costTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOffice = this.cmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOpOffice = this.costOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOffice = this.costOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
