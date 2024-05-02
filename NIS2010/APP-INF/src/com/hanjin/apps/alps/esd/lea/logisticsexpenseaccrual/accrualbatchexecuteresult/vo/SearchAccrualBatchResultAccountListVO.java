/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultAccountListVO.java
*@FileTitle : SearchAccrualBatchResultAccountListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.25 전재홍
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

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

public class SearchAccrualBatchResultAccountListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultAccountListVO> models = new ArrayList<SearchAccrualBatchResultAccountListVO>();
	
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String preActCostAmt = null;
	/* Column Info */
	private String pstActCostAmt = null;
	/* Column Info */
	private String diffCostAmt = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Column Info */
	private String erpIfDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acclAutoCd = null;
	/* Column Info */
	private String actCostRatio = null;
	/* Column Info */
	private String diffActCostAmt = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String confirmedCostAmt = null;
	/* Column Info */
	private String erpIfFlg = null;
	/* Column Info */
	private String acctCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultAccountListVO() {}

	public SearchAccrualBatchResultAccountListVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String acclAutoCd, String acctCd, String acctCdNm, String estmCostAmt, String preActCostAmt, String pstActCostAmt, String diffActCostAmt, String actCostRatio, String acclCostAmt, String confirmedCostAmt, String diffCostAmt, String mnlInpFlg, String erpIfFlg, String erpIfDt) {
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.acclCostAmt = acclCostAmt;
		this.preActCostAmt = preActCostAmt;
		this.pstActCostAmt = pstActCostAmt;
		this.diffCostAmt = diffCostAmt;
		this.estmCostAmt = estmCostAmt;
		this.erpIfDt = erpIfDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.acclAutoCd = acclAutoCd;
		this.actCostRatio = actCostRatio;
		this.diffActCostAmt = diffActCostAmt;
		this.mnlInpFlg = mnlInpFlg;
		this.acctCd = acctCd;
		this.confirmedCostAmt = confirmedCostAmt;
		this.erpIfFlg = erpIfFlg;
		this.acctCdNm = acctCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("pre_act_cost_amt", getPreActCostAmt());
		this.hashColumns.put("pst_act_cost_amt", getPstActCostAmt());
		this.hashColumns.put("diff_cost_amt", getDiffCostAmt());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("erp_if_dt", getErpIfDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("accl_auto_cd", getAcclAutoCd());
		this.hashColumns.put("act_cost_ratio", getActCostRatio());
		this.hashColumns.put("diff_act_cost_amt", getDiffActCostAmt());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("confirmed_cost_amt", getConfirmedCostAmt());
		this.hashColumns.put("erp_if_flg", getErpIfFlg());
		this.hashColumns.put("acct_cd_nm", getAcctCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("pre_act_cost_amt", "preActCostAmt");
		this.hashFields.put("pst_act_cost_amt", "pstActCostAmt");
		this.hashFields.put("diff_cost_amt", "diffCostAmt");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("erp_if_dt", "erpIfDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("accl_auto_cd", "acclAutoCd");
		this.hashFields.put("act_cost_ratio", "actCostRatio");
		this.hashFields.put("diff_act_cost_amt", "diffActCostAmt");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("confirmed_cost_amt", "confirmedCostAmt");
		this.hashFields.put("erp_if_flg", "erpIfFlg");
		this.hashFields.put("acct_cd_nm", "acctCdNm");
		return this.hashFields;
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
	 * @return acclAutoCd
	 */
	public String getAcclAutoCd() {
		return this.acclAutoCd;
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
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
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
	 * @return confirmedCostAmt
	 */
	public String getConfirmedCostAmt() {
		return this.confirmedCostAmt;
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
	 * @return acctCdNm
	 */
	public String getAcctCdNm() {
		return this.acctCdNm;
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
	 * @param acclAutoCd
	 */
	public void setAcclAutoCd(String acclAutoCd) {
		this.acclAutoCd = acclAutoCd;
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
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
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
	 * @param confirmedCostAmt
	 */
	public void setConfirmedCostAmt(String confirmedCostAmt) {
		this.confirmedCostAmt = confirmedCostAmt;
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
	 * @param acctCdNm
	 */
	public void setAcctCdNm(String acctCdNm) {
		this.acctCdNm = acctCdNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, "accl_cost_amt", ""));
		setPreActCostAmt(JSPUtil.getParameter(request, "pre_act_cost_amt", ""));
		setPstActCostAmt(JSPUtil.getParameter(request, "pst_act_cost_amt", ""));
		setDiffCostAmt(JSPUtil.getParameter(request, "diff_cost_amt", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, "estm_cost_amt", ""));
		setErpIfDt(JSPUtil.getParameter(request, "erp_if_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcclAutoCd(JSPUtil.getParameter(request, "accl_auto_cd", ""));
		setActCostRatio(JSPUtil.getParameter(request, "act_cost_ratio", ""));
		setDiffActCostAmt(JSPUtil.getParameter(request, "diff_act_cost_amt", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, "mnl_inp_flg", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setConfirmedCostAmt(JSPUtil.getParameter(request, "confirmed_cost_amt", ""));
		setErpIfFlg(JSPUtil.getParameter(request, "erp_if_flg", ""));
		setAcctCdNm(JSPUtil.getParameter(request, "acct_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultAccountListVO[]
	 */
	public SearchAccrualBatchResultAccountListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultAccountListVO[]
	 */
	public SearchAccrualBatchResultAccountListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultAccountListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] preActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pre_act_cost_amt", length));
			String[] pstActCostAmt = (JSPUtil.getParameter(request, prefix	+ "pst_act_cost_amt", length));
			String[] diffCostAmt = (JSPUtil.getParameter(request, prefix	+ "diff_cost_amt", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] erpIfDt = (JSPUtil.getParameter(request, prefix	+ "erp_if_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acclAutoCd = (JSPUtil.getParameter(request, prefix	+ "accl_auto_cd", length));
			String[] actCostRatio = (JSPUtil.getParameter(request, prefix	+ "act_cost_ratio", length));
			String[] diffActCostAmt = (JSPUtil.getParameter(request, prefix	+ "diff_act_cost_amt", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] confirmedCostAmt = (JSPUtil.getParameter(request, prefix	+ "confirmed_cost_amt", length));
			String[] erpIfFlg = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg", length));
			String[] acctCdNm = (JSPUtil.getParameter(request, prefix	+ "acct_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultAccountListVO();
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (preActCostAmt[i] != null)
					model.setPreActCostAmt(preActCostAmt[i]);
				if (pstActCostAmt[i] != null)
					model.setPstActCostAmt(pstActCostAmt[i]);
				if (diffCostAmt[i] != null)
					model.setDiffCostAmt(diffCostAmt[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (erpIfDt[i] != null)
					model.setErpIfDt(erpIfDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acclAutoCd[i] != null)
					model.setAcclAutoCd(acclAutoCd[i]);
				if (actCostRatio[i] != null)
					model.setActCostRatio(actCostRatio[i]);
				if (diffActCostAmt[i] != null)
					model.setDiffActCostAmt(diffActCostAmt[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (confirmedCostAmt[i] != null)
					model.setConfirmedCostAmt(confirmedCostAmt[i]);
				if (erpIfFlg[i] != null)
					model.setErpIfFlg(erpIfFlg[i]);
				if (acctCdNm[i] != null)
					model.setAcctCdNm(acctCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultAccountListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultAccountListVO[]
	 */
	public SearchAccrualBatchResultAccountListVO[] getSearchAccrualBatchResultAccountListVOs(){
		SearchAccrualBatchResultAccountListVO[] vos = (SearchAccrualBatchResultAccountListVO[])models.toArray(new SearchAccrualBatchResultAccountListVO[models.size()]);
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
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preActCostAmt = this.preActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstActCostAmt = this.pstActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCostAmt = this.diffCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfDt = this.erpIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAutoCd = this.acclAutoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostRatio = this.actCostRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffActCostAmt = this.diffActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmedCostAmt = this.confirmedCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlg = this.erpIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCdNm = this.acctCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
