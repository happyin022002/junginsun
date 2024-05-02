/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActCostMonBudgetVO.java
*@FileTitle : ActCostMonBudgetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActCostMonBudgetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActCostMonBudgetVO> models = new ArrayList<ActCostMonBudgetVO>();
	
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String yryBudUsdAmt = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String ttlUsdAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costSrcSysCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String monBudUsdAmt = null;
	/* Column Info */
	private String mnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ActCostMonBudgetVO() {}

	public ActCostMonBudgetVO(String ibflag, String pagerows, String bseYr, String rhqCd, String ctrlOfcCd, String costSrcSysCd, String coaCostSrcCd, String lgsCostFullNm, String acctCd, String ttlUsdAmt, String monBudUsdAmt, String yryBudUsdAmt, String mnlFlg, String creUsrId, String updUsrId) {
		this.rhqCd = rhqCd;
		this.coaCostSrcCd = coaCostSrcCd;
		this.yryBudUsdAmt = yryBudUsdAmt;
		this.bseYr = bseYr;
		this.ctrlOfcCd = ctrlOfcCd;
		this.ttlUsdAmt = ttlUsdAmt;
		this.pagerows = pagerows;
		this.costSrcSysCd = costSrcSysCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.updUsrId = updUsrId;
		this.lgsCostFullNm = lgsCostFullNm;
		this.monBudUsdAmt = monBudUsdAmt;
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("yry_bud_usd_amt", getYryBudUsdAmt());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("ttl_usd_amt", getTtlUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_src_sys_cd", getCostSrcSysCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("mon_bud_usd_amt", getMonBudUsdAmt());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("yry_bud_usd_amt", "yryBudUsdAmt");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("ttl_usd_amt", "ttlUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_src_sys_cd", "costSrcSysCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("mon_bud_usd_amt", "monBudUsdAmt");
		this.hashFields.put("mnl_flg", "mnlFlg");
		return this.hashFields;
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return yryBudUsdAmt
	 */
	public String getYryBudUsdAmt() {
		return this.yryBudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return ttlUsdAmt
	 */
	public String getTtlUsdAmt() {
		return this.ttlUsdAmt;
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
	 * @return costSrcSysCd
	 */
	public String getCostSrcSysCd() {
		return this.costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @return monBudUsdAmt
	 */
	public String getMonBudUsdAmt() {
		return this.monBudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param yryBudUsdAmt
	 */
	public void setYryBudUsdAmt(String yryBudUsdAmt) {
		this.yryBudUsdAmt = yryBudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param ttlUsdAmt
	 */
	public void setTtlUsdAmt(String ttlUsdAmt) {
		this.ttlUsdAmt = ttlUsdAmt;
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
	 * @param costSrcSysCd
	 */
	public void setCostSrcSysCd(String costSrcSysCd) {
		this.costSrcSysCd = costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @param monBudUsdAmt
	 */
	public void setMonBudUsdAmt(String monBudUsdAmt) {
		this.monBudUsdAmt = monBudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
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
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setYryBudUsdAmt(JSPUtil.getParameter(request, prefix + "yry_bud_usd_amt", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setTtlUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostSrcSysCd(JSPUtil.getParameter(request, prefix + "cost_src_sys_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setMonBudUsdAmt(JSPUtil.getParameter(request, prefix + "mon_bud_usd_amt", ""));
		setMnlFlg(JSPUtil.getParameter(request, prefix + "mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActCostMonBudgetVO[]
	 */
	public ActCostMonBudgetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActCostMonBudgetVO[]
	 */
	public ActCostMonBudgetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActCostMonBudgetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] yryBudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "yry_bud_usd_amt", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] ttlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "cost_src_sys_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] monBudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "mon_bud_usd_amt", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActCostMonBudgetVO();
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (yryBudUsdAmt[i] != null)
					model.setYryBudUsdAmt(yryBudUsdAmt[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (ttlUsdAmt[i] != null)
					model.setTtlUsdAmt(ttlUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costSrcSysCd[i] != null)
					model.setCostSrcSysCd(costSrcSysCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (monBudUsdAmt[i] != null)
					model.setMonBudUsdAmt(monBudUsdAmt[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActCostMonBudgetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActCostMonBudgetVO[]
	 */
	public ActCostMonBudgetVO[] getActCostMonBudgetVOs(){
		ActCostMonBudgetVO[] vos = (ActCostMonBudgetVO[])models.toArray(new ActCostMonBudgetVO[models.size()]);
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
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yryBudUsdAmt = this.yryBudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt = this.ttlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcSysCd = this.costSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monBudUsdAmt = this.monBudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
