/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultBookingListVO.java
*@FileTitle : SearchAccrualBatchResultBookingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.08.28 Jeon Jae Hong 
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
 * @author Jeon Jae Hong
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchResultBookingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultBookingListVO> models = new ArrayList<SearchAccrualBatchResultBookingListVO>();
	
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String revVvdNo = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String frmCostDiffAmt = null;
	/* Column Info */
	private String frmCostDiffPer = null;
	/* Column Info */
	private String frmExeYrmon = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Column Info */
	private String frmDiffDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frmBkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String frmRevYrmon = null;
	/* Column Info */
	private String confirmedCostAmt = null;
	/* Column Info */
	private String frmAcctCd = null;
	/* Column Info */
	private String frmVvdNo = null;
	/* Column Info */
	private String actCostAmt = null;
	/* Column Info */
	private String costDiffPer = null;
	/* Column Info */
	private String costDiffAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultBookingListVO() {}

	public SearchAccrualBatchResultBookingListVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String revVvdNo, String bkgNo, String estmCostAmt, String actCostAmt, String acclCostAmt, String confirmedCostAmt, String costDiffAmt, String costDiffPer, String frmRevYrmon, String frmExeYrmon, String frmAcctCd, String frmBkgNo, String frmDiffDiv, String frmCostDiffAmt, String frmCostDiffPer) {
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.revVvdNo = revVvdNo;
		this.acclCostAmt = acclCostAmt;
		this.frmCostDiffAmt = frmCostDiffAmt;
		this.frmCostDiffPer = frmCostDiffPer;
		this.frmExeYrmon = frmExeYrmon;
		this.estmCostAmt = estmCostAmt;
		this.frmDiffDiv = frmDiffDiv;
		this.pagerows = pagerows;
		this.frmBkgNo = frmBkgNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.frmRevYrmon = frmRevYrmon;
		this.confirmedCostAmt = confirmedCostAmt;
		this.frmAcctCd = frmAcctCd;
		this.frmVvdNo = frmVvdNo;
		this.actCostAmt = actCostAmt;
		this.costDiffPer = costDiffPer;
		this.costDiffAmt = costDiffAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("rev_vvd_no", getRevVvdNo());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("frm_cost_diff_amt", getFrmCostDiffAmt());
		this.hashColumns.put("frm_cost_diff_per", getFrmCostDiffPer());
		this.hashColumns.put("frm_exe_yrmon", getFrmExeYrmon());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("frm_diff_div", getFrmDiffDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frm_bkg_no", getFrmBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("frm_rev_yrmon", getFrmRevYrmon());
		this.hashColumns.put("confirmed_cost_amt", getConfirmedCostAmt());
		this.hashColumns.put("frm_acct_cd", getFrmAcctCd());
		this.hashColumns.put("frm_vvd_no", getFrmVvdNo());
		this.hashColumns.put("act_cost_amt", getActCostAmt());
		this.hashColumns.put("cost_diff_per", getCostDiffPer());
		this.hashColumns.put("cost_diff_amt", getCostDiffAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("rev_vvd_no", "revVvdNo");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("frm_cost_diff_amt", "frmCostDiffAmt");
		this.hashFields.put("frm_cost_diff_per", "frmCostDiffPer");
		this.hashFields.put("frm_exe_yrmon", "frmExeYrmon");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("frm_diff_div", "frmDiffDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frm_bkg_no", "frmBkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("frm_rev_yrmon", "frmRevYrmon");
		this.hashFields.put("confirmed_cost_amt", "confirmedCostAmt");
		this.hashFields.put("frm_acct_cd", "frmAcctCd");
		this.hashFields.put("frm_vvd_no", "frmVvdNo");
		this.hashFields.put("act_cost_amt", "actCostAmt");
		this.hashFields.put("cost_diff_per", "costDiffPer");
		this.hashFields.put("cost_diff_amt", "costDiffAmt");
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
	 * @return revVvdNo
	 */
	public String getRevVvdNo() {
		return this.revVvdNo;
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
	 * @return frmCostDiffAmt
	 */
	public String getFrmCostDiffAmt() {
		return this.frmCostDiffAmt;
	}
	
	/**
	 * Column Info
	 * @return frmCostDiffPer
	 */
	public String getFrmCostDiffPer() {
		return this.frmCostDiffPer;
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
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return frmDiffDiv
	 */
	public String getFrmDiffDiv() {
		return this.frmDiffDiv;
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
	 * @return frmBkgNo
	 */
	public String getFrmBkgNo() {
		return this.frmBkgNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return frmRevYrmon
	 */
	public String getFrmRevYrmon() {
		return this.frmRevYrmon;
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
	 * @return frmAcctCd
	 */
	public String getFrmAcctCd() {
		return this.frmAcctCd;
	}
	
	/**
	 * Column Info
	 * @return frmAcctCd
	 */
	public String getFrmVvdNo() {
		return this.frmVvdNo;
	}
	
	/**
	 * Column Info
	 * @return actCostAmt
	 */
	public String getActCostAmt() {
		return this.actCostAmt;
	}
	
	/**
	 * Column Info
	 * @return costDiffPer
	 */
	public String getCostDiffPer() {
		return this.costDiffPer;
	}
	
	/**
	 * Column Info
	 * @return costDiffAmt
	 */
	public String getCostDiffAmt() {
		return this.costDiffAmt;
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
	 * @param revVvdNo
	 */
	public void setRevVvdNo(String revVvdNo) {
		this.revVvdNo = revVvdNo;
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
	 * @param frmCostDiffAmt
	 */
	public void setFrmCostDiffAmt(String frmCostDiffAmt) {
		this.frmCostDiffAmt = frmCostDiffAmt;
	}
	
	/**
	 * Column Info
	 * @param frmCostDiffPer
	 */
	public void setFrmCostDiffPer(String frmCostDiffPer) {
		this.frmCostDiffPer = frmCostDiffPer;
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
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param frmDiffDiv
	 */
	public void setFrmDiffDiv(String frmDiffDiv) {
		this.frmDiffDiv = frmDiffDiv;
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
	 * @param frmBkgNo
	 */
	public void setFrmBkgNo(String frmBkgNo) {
		this.frmBkgNo = frmBkgNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param frmRevYrmon
	 */
	public void setFrmRevYrmon(String frmRevYrmon) {
		this.frmRevYrmon = frmRevYrmon;
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
	 * @param frmAcctCd
	 */
	public void setFrmAcctCd(String frmAcctCd) {
		this.frmAcctCd = frmAcctCd;
	}
	
	/**
	 * Column Info
	 * @param frmVvdNo
	 */
	public void setFrmVvdNo(String frmVvdNo) {
		this.frmVvdNo = frmVvdNo;
	}
	
	/**
	 * Column Info
	 * @param actCostAmt
	 */
	public void setActCostAmt(String actCostAmt) {
		this.actCostAmt = actCostAmt;
	}
	
	/**
	 * Column Info
	 * @param costDiffPer
	 */
	public void setCostDiffPer(String costDiffPer) {
		this.costDiffPer = costDiffPer;
	}
	
	/**
	 * Column Info
	 * @param costDiffAmt
	 */
	public void setCostDiffAmt(String costDiffAmt) {
		this.costDiffAmt = costDiffAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setRevVvdNo(JSPUtil.getParameter(request, "rev_vvd_no", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, "accl_cost_amt", ""));
		setFrmCostDiffAmt(JSPUtil.getParameter(request, "frm_cost_diff_amt", ""));
		setFrmCostDiffPer(JSPUtil.getParameter(request, "frm_cost_diff_per", ""));
		setFrmExeYrmon(JSPUtil.getParameter(request, "frm_exe_yrmon", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, "estm_cost_amt", ""));
		setFrmDiffDiv(JSPUtil.getParameter(request, "frm_diff_div", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFrmBkgNo(JSPUtil.getParameter(request, "frm_bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFrmRevYrmon(JSPUtil.getParameter(request, "frm_rev_yrmon", ""));
		setConfirmedCostAmt(JSPUtil.getParameter(request, "confirmed_cost_amt", ""));
		setFrmAcctCd(JSPUtil.getParameter(request, "frm_acct_cd", ""));
		setFrmVvdNo(JSPUtil.getParameter(request, "frm_vvd_no", ""));
		setActCostAmt(JSPUtil.getParameter(request, "act_cost_amt", ""));
		setCostDiffPer(JSPUtil.getParameter(request, "cost_diff_per", ""));
		setCostDiffAmt(JSPUtil.getParameter(request, "cost_diff_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultBookingListVO[]
	 */
	public SearchAccrualBatchResultBookingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultBookingListVO[]
	 */
	public SearchAccrualBatchResultBookingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultBookingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] revVvdNo = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_no", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] frmCostDiffAmt = (JSPUtil.getParameter(request, prefix	+ "frm_cost_diff_amt", length));
			String[] frmCostDiffPer = (JSPUtil.getParameter(request, prefix	+ "frm_cost_diff_per", length));
			String[] frmExeYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_exe_yrmon", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] frmDiffDiv = (JSPUtil.getParameter(request, prefix	+ "frm_diff_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frmBkgNo = (JSPUtil.getParameter(request, prefix	+ "frm_bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] frmRevYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon", length));
			String[] confirmedCostAmt = (JSPUtil.getParameter(request, prefix	+ "confirmed_cost_amt", length));
			String[] frmAcctCd = (JSPUtil.getParameter(request, prefix	+ "frm_acct_cd", length));
			String[] frmVvdNo = (JSPUtil.getParameter(request, prefix	+ "frm_vvd_no", length));
			String[] actCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt", length));
			String[] costDiffPer = (JSPUtil.getParameter(request, prefix	+ "cost_diff_per", length));
			String[] costDiffAmt = (JSPUtil.getParameter(request, prefix	+ "cost_diff_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultBookingListVO();
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (revVvdNo[i] != null)
					model.setRevVvdNo(revVvdNo[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (frmCostDiffAmt[i] != null)
					model.setFrmCostDiffAmt(frmCostDiffAmt[i]);
				if (frmCostDiffPer[i] != null)
					model.setFrmCostDiffPer(frmCostDiffPer[i]);
				if (frmExeYrmon[i] != null)
					model.setFrmExeYrmon(frmExeYrmon[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (frmDiffDiv[i] != null)
					model.setFrmDiffDiv(frmDiffDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frmBkgNo[i] != null)
					model.setFrmBkgNo(frmBkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (frmRevYrmon[i] != null)
					model.setFrmRevYrmon(frmRevYrmon[i]);
				if (confirmedCostAmt[i] != null)
					model.setConfirmedCostAmt(confirmedCostAmt[i]);
				if (frmAcctCd[i] != null)
					model.setFrmAcctCd(frmAcctCd[i]);
				if (frmVvdNo[i] != null)
					model.setFrmVvdNo(frmVvdNo[i]);
				if (actCostAmt[i] != null)
					model.setActCostAmt(actCostAmt[i]);
				if (costDiffPer[i] != null)
					model.setCostDiffPer(costDiffPer[i]);
				if (costDiffAmt[i] != null)
					model.setCostDiffAmt(costDiffAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultBookingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultBookingListVO[]
	 */
	public SearchAccrualBatchResultBookingListVO[] getSearchAccrualBatchResultBookingListVOs(){
		SearchAccrualBatchResultBookingListVO[] vos = (SearchAccrualBatchResultBookingListVO[])models.toArray(new SearchAccrualBatchResultBookingListVO[models.size()]);
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
		this.revVvdNo = this.revVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCostDiffAmt = this.frmCostDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCostDiffPer = this.frmCostDiffPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmExeYrmon = this.frmExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDiffDiv = this.frmDiffDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmBkgNo = this.frmBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmon = this.frmRevYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmedCostAmt = this.confirmedCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmAcctCd = this.frmAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVvdNo = this.frmVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmt = this.actCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDiffPer = this.costDiffPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDiffAmt = this.costDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
