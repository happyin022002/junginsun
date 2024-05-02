/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceDetailVO.java
*@FileTitle : DODInvoiceDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.09.26 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DODInvoiceDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DODInvoiceDetailVO> models = new ArrayList<DODInvoiceDetailVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String dodLocCd = null;
	/* Column Info */
	private String dodInvNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String selChk = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String bilCurrCd = null;
	/* Column Info */
	private String addAmt = null;
	/* Column Info */
	private String drpOffChgTrfEffDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DODInvoiceDetailVO() {}

	public DODInvoiceDetailVO(String ibflag, String pagerows, String bilAmt, String bilCurrCd, String creUsrId, String dodInvNo, String dodLocCd, String taxAmt, String cntrNo, String cntrTpszCd, String invAmt, String selChk, String creOfcCd, String addAmt, String drpOffChgTrfEffDt) {
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.dodLocCd = dodLocCd;
		this.dodInvNo = dodInvNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.invAmt = invAmt;
		this.selChk = selChk;
		this.bilAmt = bilAmt;
		this.bilCurrCd = bilCurrCd;
		this.addAmt = addAmt;
		this.drpOffChgTrfEffDt = drpOffChgTrfEffDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("dod_loc_cd", getDodLocCd());
		this.hashColumns.put("dod_inv_no", getDodInvNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("sel_chk", getSelChk());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("bil_curr_cd", getBilCurrCd());
		this.hashColumns.put("add_amt", getAddAmt());
		this.hashColumns.put("drp_off_chg_trf_eff_dt", getDrpOffChgTrfEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("dod_loc_cd", "dodLocCd");
		this.hashFields.put("dod_inv_no", "dodInvNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("sel_chk", "selChk");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("bil_curr_cd", "bilCurrCd");
		this.hashFields.put("add_amt", "addAmt");
		this.hashFields.put("drp_off_chg_trf_eff_dt", "drpOffChgTrfEffDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return addAmt
	 */
	public String getAddAmt() {
		return this.addAmt;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfEffDt
	 */
	public String getDrpOffChgTrfEffDt() {
		return this.drpOffChgTrfEffDt;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return dodLocCd
	 */
	public String getDodLocCd() {
		return this.dodLocCd;
	}
	
	/**
	 * Column Info
	 * @return dodInvNo
	 */
	public String getDodInvNo() {
		return this.dodInvNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return selChk
	 */
	public String getSelChk() {
		return this.selChk;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return bilCurrCd
	 */
	public String getBilCurrCd() {
		return this.bilCurrCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	

	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param dodLocCd
	 */
	public void setDodLocCd(String dodLocCd) {
		this.dodLocCd = dodLocCd;
	}
	
	/**
	 * Column Info
	 * @param dodInvNo
	 */
	public void setDodInvNo(String dodInvNo) {
		this.dodInvNo = dodInvNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param selChk
	 */
	public void setSelChk(String selChk) {
		this.selChk = selChk;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param bilCurrCd
	 */
	public void setBilCurrCd(String bilCurrCd) {
		this.bilCurrCd = bilCurrCd;
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
	 * @param addAmt
	 */
	public void setAddAmt(String addAmt) {
		this.addAmt = addAmt;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfEffDt
	 */
	public void setDrpOffChgTrfEffDt(String drpOffChgTrfEffDt) {
		this.drpOffChgTrfEffDt = drpOffChgTrfEffDt;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setDodLocCd(JSPUtil.getParameter(request, prefix + "dod_loc_cd", ""));
		setDodInvNo(JSPUtil.getParameter(request, prefix + "dod_inv_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setSelChk(JSPUtil.getParameter(request, prefix + "sel_chk", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
		setAddAmt(JSPUtil.getParameter(request, prefix + "add_amt", ""));
		setDrpOffChgTrfEffDt(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DODInvoiceDetailVO[]
	 */
	public DODInvoiceDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DODInvoiceDetailVO[]
	 */
	public DODInvoiceDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DODInvoiceDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] dodLocCd = (JSPUtil.getParameter(request, prefix	+ "dod_loc_cd", length));
			String[] dodInvNo = (JSPUtil.getParameter(request, prefix	+ "dod_inv_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] selChk = (JSPUtil.getParameter(request, prefix	+ "sel_chk", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] bilCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_curr_cd", length));
			String[] addAmt = (JSPUtil.getParameter(request, prefix	+ "add_amt", length));
			String[] drpOffChgTrfEffDt = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DODInvoiceDetailVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (dodLocCd[i] != null)
					model.setDodLocCd(dodLocCd[i]);
				if (dodInvNo[i] != null)
					model.setDodInvNo(dodInvNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (selChk[i] != null)
					model.setSelChk(selChk[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (bilCurrCd[i] != null)
					model.setBilCurrCd(bilCurrCd[i]);
				if (addAmt[i] != null)
					model.setAddAmt(addAmt[i]);
				if (drpOffChgTrfEffDt[i] != null)
					model.setDrpOffChgTrfEffDt(drpOffChgTrfEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDODInvoiceDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DODInvoiceDetailVO[]
	 */
	public DODInvoiceDetailVO[] getDODInvoiceDetailVOs(){
		DODInvoiceDetailVO[] vos = (DODInvoiceDetailVO[])models.toArray(new DODInvoiceDetailVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodLocCd = this.dodLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodInvNo = this.dodInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selChk = this.selChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCurrCd = this.bilCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addAmt = this.addAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfEffDt = this.drpOffChgTrfEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
