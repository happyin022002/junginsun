/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InPrsAmendmentSummarySimulationVO.java
*@FileTitle : InPrsAmendmentSummarySimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.10.28 송민석 
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

public class InPrsAmendmentSummarySimulationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsAmendmentSummarySimulationVO> models = new ArrayList<InPrsAmendmentSummarySimulationVO>();
	
	/* Column Info */
	private String destRoutCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String expYrwk = null;
	/* Column Info */
	private String score = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String expYr = null;
	/* Column Info */
	private String destLocTp = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String oriRoutCd = null;
	/* Column Info */
	private String propNoList = null;
	/* Column Info */
	private String expWk = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oriLocTp = null;
	/* Column Info */
	private String aprOfcCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String effYrwk = null;
	/* Column Info */
	private String effYr = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String effWk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsAmendmentSummarySimulationVO() {}

	public InPrsAmendmentSummarySimulationVO(String ibflag, String pagerows, String trdCd, String dirCd, String subTrdCd, String rlaneCd, String oriRoutCd, String destRoutCd, String oriLocTp, String destLocTp, String aprOfcCd, String custTpCd, String calcTpCd, String amount, String effYr, String effWk, String expYr, String expWk, String chgCd, String svcScpCd, String propNoList, String score, String effYrwk, String expYrwk) {
		this.destRoutCd = destRoutCd;
		this.svcScpCd = svcScpCd;
		this.expYrwk = expYrwk;
		this.score = score;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.expYr = expYr;
		this.destLocTp = destLocTp;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.amount = amount;
		this.oriRoutCd = oriRoutCd;
		this.propNoList = propNoList;
		this.expWk = expWk;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.oriLocTp = oriLocTp;
		this.aprOfcCd = aprOfcCd;
		this.dirCd = dirCd;
		this.effYrwk = effYrwk;
		this.effYr = effYr;
		this.custTpCd = custTpCd;
		this.subTrdCd = subTrdCd;
		this.effWk = effWk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_cd", getDestRoutCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("exp_yrwk", getExpYrwk());
		this.hashColumns.put("score", getScore());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("exp_yr", getExpYr());
		this.hashColumns.put("dest_loc_tp", getDestLocTp());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("ori_rout_cd", getOriRoutCd());
		this.hashColumns.put("prop_no_list", getPropNoList());
		this.hashColumns.put("exp_wk", getExpWk());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ori_loc_tp", getOriLocTp());
		this.hashColumns.put("apr_ofc_cd", getAprOfcCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("eff_yrwk", getEffYrwk());
		this.hashColumns.put("eff_yr", getEffYr());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("eff_wk", getEffWk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_cd", "destRoutCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("exp_yrwk", "expYrwk");
		this.hashFields.put("score", "score");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("exp_yr", "expYr");
		this.hashFields.put("dest_loc_tp", "destLocTp");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ori_rout_cd", "oriRoutCd");
		this.hashFields.put("prop_no_list", "propNoList");
		this.hashFields.put("exp_wk", "expWk");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ori_loc_tp", "oriLocTp");
		this.hashFields.put("apr_ofc_cd", "aprOfcCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("eff_yrwk", "effYrwk");
		this.hashFields.put("eff_yr", "effYr");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("eff_wk", "effWk");
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return expYrwk
	 */
	public String getExpYrwk() {
		return this.expYrwk;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return expYr
	 */
	public String getExpYr() {
		return this.expYr;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
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
	 * @return propNoList
	 */
	public String getPropNoList() {
		return this.propNoList;
	}
	
	/**
	 * Column Info
	 * @return expWk
	 */
	public String getExpWk() {
		return this.expWk;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return effYrwk
	 */
	public String getEffYrwk() {
		return this.effYrwk;
	}
	
	/**
	 * Column Info
	 * @return effYr
	 */
	public String getEffYr() {
		return this.effYr;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return effWk
	 */
	public String getEffWk() {
		return this.effWk;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param expYrwk
	 */
	public void setExpYrwk(String expYrwk) {
		this.expYrwk = expYrwk;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param expYr
	 */
	public void setExpYr(String expYr) {
		this.expYr = expYr;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @param propNoList
	 */
	public void setPropNoList(String propNoList) {
		this.propNoList = propNoList;
	}
	
	/**
	 * Column Info
	 * @param expWk
	 */
	public void setExpWk(String expWk) {
		this.expWk = expWk;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param effYrwk
	 */
	public void setEffYrwk(String effYrwk) {
		this.effYrwk = effYrwk;
	}
	
	/**
	 * Column Info
	 * @param effYr
	 */
	public void setEffYr(String effYr) {
		this.effYr = effYr;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param effWk
	 */
	public void setEffWk(String effWk) {
		this.effWk = effWk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDestRoutCd(JSPUtil.getParameter(request, "dest_rout_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setExpYrwk(JSPUtil.getParameter(request, "exp_yrwk", ""));
		setScore(JSPUtil.getParameter(request, "score", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setExpYr(JSPUtil.getParameter(request, "exp_yr", ""));
		setDestLocTp(JSPUtil.getParameter(request, "dest_loc_tp", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setOriRoutCd(JSPUtil.getParameter(request, "ori_rout_cd", ""));
		setPropNoList(JSPUtil.getParameter(request, "prop_no_list", ""));
		setExpWk(JSPUtil.getParameter(request, "exp_wk", ""));
		setCalcTpCd(JSPUtil.getParameter(request, "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOriLocTp(JSPUtil.getParameter(request, "ori_loc_tp", ""));
		setAprOfcCd(JSPUtil.getParameter(request, "apr_ofc_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setEffYrwk(JSPUtil.getParameter(request, "eff_yrwk", ""));
		setEffYr(JSPUtil.getParameter(request, "eff_yr", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setEffWk(JSPUtil.getParameter(request, "eff_wk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrsAmendmentSummarySimulationVO[]
	 */
	public InPrsAmendmentSummarySimulationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrsAmendmentSummarySimulationVO[]
	 */
	public InPrsAmendmentSummarySimulationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrsAmendmentSummarySimulationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] expYrwk = (JSPUtil.getParameter(request, prefix	+ "exp_yrwk", length));
			String[] score = (JSPUtil.getParameter(request, prefix	+ "score", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] expYr = (JSPUtil.getParameter(request, prefix	+ "exp_yr", length));
			String[] destLocTp = (JSPUtil.getParameter(request, prefix	+ "dest_loc_tp", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] oriRoutCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_cd", length));
			String[] propNoList = (JSPUtil.getParameter(request, prefix	+ "prop_no_list", length));
			String[] expWk = (JSPUtil.getParameter(request, prefix	+ "exp_wk", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oriLocTp = (JSPUtil.getParameter(request, prefix	+ "ori_loc_tp", length));
			String[] aprOfcCd = (JSPUtil.getParameter(request, prefix	+ "apr_ofc_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] effYrwk = (JSPUtil.getParameter(request, prefix	+ "eff_yrwk", length));
			String[] effYr = (JSPUtil.getParameter(request, prefix	+ "eff_yr", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] effWk = (JSPUtil.getParameter(request, prefix	+ "eff_wk", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrsAmendmentSummarySimulationVO();
				if (destRoutCd[i] != null)
					model.setDestRoutCd(destRoutCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (expYrwk[i] != null)
					model.setExpYrwk(expYrwk[i]);
				if (score[i] != null)
					model.setScore(score[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (expYr[i] != null)
					model.setExpYr(expYr[i]);
				if (destLocTp[i] != null)
					model.setDestLocTp(destLocTp[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (oriRoutCd[i] != null)
					model.setOriRoutCd(oriRoutCd[i]);
				if (propNoList[i] != null)
					model.setPropNoList(propNoList[i]);
				if (expWk[i] != null)
					model.setExpWk(expWk[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oriLocTp[i] != null)
					model.setOriLocTp(oriLocTp[i]);
				if (aprOfcCd[i] != null)
					model.setAprOfcCd(aprOfcCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (effYrwk[i] != null)
					model.setEffYrwk(effYrwk[i]);
				if (effYr[i] != null)
					model.setEffYr(effYr[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (effWk[i] != null)
					model.setEffWk(effWk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrsAmendmentSummarySimulationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrsAmendmentSummarySimulationVO[]
	 */
	public InPrsAmendmentSummarySimulationVO[] getInPrsAmendmentSummarySimulationVOs(){
		InPrsAmendmentSummarySimulationVO[] vos = (InPrsAmendmentSummarySimulationVO[])models.toArray(new InPrsAmendmentSummarySimulationVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expYrwk = this.expYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.score = this.score .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expYr = this.expYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocTp = this.destLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutCd = this.oriRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNoList = this.propNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expWk = this.expWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLocTp = this.oriLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprOfcCd = this.aprOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrwk = this.effYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYr = this.effYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effWk = this.effWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
