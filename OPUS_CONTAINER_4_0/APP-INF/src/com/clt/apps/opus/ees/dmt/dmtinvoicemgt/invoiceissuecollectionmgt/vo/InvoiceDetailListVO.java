/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceDetailListVO.java
*@FileTitle : InvoiceDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.24 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceDetailListVO> models = new ArrayList<InvoiceDetailListVO>();
	
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String bilAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String dmdtTrfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceDetailListVO() {}

	public InvoiceDetailListVO(String ibflag, String pagerows, String svrId, String cntrNo, String invDtlSeq, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String orgChgAmt, String scRfaExptAmt, String aftExptDcAmt, String bilAmt, String invCurrCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.cntrCycNo = cntrCycNo;
		this.scRfaExptAmt = scRfaExptAmt;
		this.aftExptDcAmt = aftExptDcAmt;
		this.chgSeq = chgSeq;
		this.invCurrCd = invCurrCd;
		this.bilAmt = bilAmt;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.invDtlSeq = invDtlSeq;
		this.orgChgAmt = orgChgAmt;
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @return aftExptDcAmt
	 */
	public String getAftExptDcAmt() {
		return this.aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	

	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @param aftExptDcAmt
	 */
	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, "sc_rfa_expt_amt", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, "aft_expt_dc_amt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setBilAmt(JSPUtil.getParameter(request, "bil_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, "org_chg_amt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceDetailListVO[]
	 */
	public InvoiceDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceDetailListVO[]
	 */
	public InvoiceDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceDetailListVO();
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceDetailListVO[]
	 */
	public InvoiceDetailListVO[] getInvoiceDetailListVOs(){
		InvoiceDetailListVO[] vos = (InvoiceDetailListVO[])models.toArray(new InvoiceDetailListVO[models.size()]);
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
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
