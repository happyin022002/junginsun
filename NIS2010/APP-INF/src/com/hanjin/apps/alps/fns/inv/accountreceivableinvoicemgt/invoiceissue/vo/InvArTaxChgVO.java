/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArTaxChgVO.java
*@FileTitle : InvArTaxChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.09.22 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArTaxChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArTaxChgVO> models = new ArrayList<InvArTaxChgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loclCurrAmt = null;
	/* Column Info */
	private String taxInvNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String taxInvCxlRmk = null;
	/* Column Info */
	private String chgSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxChgRmk = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String taxInvSeq = null;
	/* Column Info */
	private String taxChgCd = null;
	/* Column Info */
	private String taxChgLoclNm = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String taxChgNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArTaxChgVO() {}

	public InvArTaxChgVO(String ibflag, String pagerows, String taxChgNo, String taxChgLoclNm, String ratAsCntrQty, String trfRtAmt, String chgAmt, String taxChgRmk, String taxInvCxlRmk, String taxChgCd, String taxInvNo, String taxInvSeq, String chgSeq, String chgCurrCd, String loclCurrAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.loclCurrAmt = loclCurrAmt;
		this.taxInvNo = taxInvNo;
		this.creDt = creDt;
		this.trfRtAmt = trfRtAmt;
		this.taxInvCxlRmk = taxInvCxlRmk;
		this.chgSeq = chgSeq;
		this.pagerows = pagerows;
		this.chgCurrCd = chgCurrCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.taxChgRmk = taxChgRmk;
		this.chgAmt = chgAmt;
		this.taxInvSeq = taxInvSeq;
		this.taxChgCd = taxChgCd;
		this.taxChgLoclNm = taxChgLoclNm;
		this.ratAsCntrQty = ratAsCntrQty;
		this.updUsrId = updUsrId;
		this.taxChgNo = taxChgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("locl_curr_amt", getLoclCurrAmt());
		this.hashColumns.put("tax_inv_no", getTaxInvNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("tax_inv_cxl_rmk", getTaxInvCxlRmk());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_chg_rmk", getTaxChgRmk());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("tax_inv_seq", getTaxInvSeq());
		this.hashColumns.put("tax_chg_cd", getTaxChgCd());
		this.hashColumns.put("tax_chg_locl_nm", getTaxChgLoclNm());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tax_chg_no", getTaxChgNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("locl_curr_amt", "loclCurrAmt");
		this.hashFields.put("tax_inv_no", "taxInvNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("tax_inv_cxl_rmk", "taxInvCxlRmk");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_chg_rmk", "taxChgRmk");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("tax_inv_seq", "taxInvSeq");
		this.hashFields.put("tax_chg_cd", "taxChgCd");
		this.hashFields.put("tax_chg_locl_nm", "taxChgLoclNm");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tax_chg_no", "taxChgNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrAmt
	 */
	public String getLoclCurrAmt() {
		return this.loclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return taxInvNo
	 */
	public String getTaxInvNo() {
		return this.taxInvNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return taxInvCxlRmk
	 */
	public String getTaxInvCxlRmk() {
		return this.taxInvCxlRmk;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
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
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
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
	 * @return taxChgRmk
	 */
	public String getTaxChgRmk() {
		return this.taxChgRmk;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return taxInvSeq
	 */
	public String getTaxInvSeq() {
		return this.taxInvSeq;
	}
	
	/**
	 * Column Info
	 * @return taxChgCd
	 */
	public String getTaxChgCd() {
		return this.taxChgCd;
	}
	
	/**
	 * Column Info
	 * @return taxChgLoclNm
	 */
	public String getTaxChgLoclNm() {
		return this.taxChgLoclNm;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
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
	 * @return taxChgNo
	 */
	public String getTaxChgNo() {
		return this.taxChgNo;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrAmt
	 */
	public void setLoclCurrAmt(String loclCurrAmt) {
		this.loclCurrAmt = loclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param taxInvNo
	 */
	public void setTaxInvNo(String taxInvNo) {
		this.taxInvNo = taxInvNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param taxInvCxlRmk
	 */
	public void setTaxInvCxlRmk(String taxInvCxlRmk) {
		this.taxInvCxlRmk = taxInvCxlRmk;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
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
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
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
	 * @param taxChgRmk
	 */
	public void setTaxChgRmk(String taxChgRmk) {
		this.taxChgRmk = taxChgRmk;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param taxInvSeq
	 */
	public void setTaxInvSeq(String taxInvSeq) {
		this.taxInvSeq = taxInvSeq;
	}
	
	/**
	 * Column Info
	 * @param taxChgCd
	 */
	public void setTaxChgCd(String taxChgCd) {
		this.taxChgCd = taxChgCd;
	}
	
	/**
	 * Column Info
	 * @param taxChgLoclNm
	 */
	public void setTaxChgLoclNm(String taxChgLoclNm) {
		this.taxChgLoclNm = taxChgLoclNm;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
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
	 * @param taxChgNo
	 */
	public void setTaxChgNo(String taxChgNo) {
		this.taxChgNo = taxChgNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLoclCurrAmt(JSPUtil.getParameter(request, "locl_curr_amt", ""));
		setTaxInvNo(JSPUtil.getParameter(request, "tax_inv_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setTaxInvCxlRmk(JSPUtil.getParameter(request, "tax_inv_cxl_rmk", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChgCurrCd(JSPUtil.getParameter(request, "chg_curr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxChgRmk(JSPUtil.getParameter(request, "tax_chg_rmk", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setTaxInvSeq(JSPUtil.getParameter(request, "tax_inv_seq", ""));
		setTaxChgCd(JSPUtil.getParameter(request, "tax_chg_cd", ""));
		setTaxChgLoclNm(JSPUtil.getParameter(request, "tax_chg_locl_nm", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTaxChgNo(JSPUtil.getParameter(request, "tax_chg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArTaxChgVO[]
	 */
	public InvArTaxChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArTaxChgVO[]
	 */
	public InvArTaxChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArTaxChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loclCurrAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_amt", length));
			String[] taxInvNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] taxInvCxlRmk = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_rmk", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxChgRmk = (JSPUtil.getParameter(request, prefix	+ "tax_chg_rmk", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] taxInvSeq = (JSPUtil.getParameter(request, prefix	+ "tax_inv_seq", length));
			String[] taxChgCd = (JSPUtil.getParameter(request, prefix	+ "tax_chg_cd", length));
			String[] taxChgLoclNm = (JSPUtil.getParameter(request, prefix	+ "tax_chg_locl_nm", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] taxChgNo = (JSPUtil.getParameter(request, prefix	+ "tax_chg_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArTaxChgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loclCurrAmt[i] != null)
					model.setLoclCurrAmt(loclCurrAmt[i]);
				if (taxInvNo[i] != null)
					model.setTaxInvNo(taxInvNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (taxInvCxlRmk[i] != null)
					model.setTaxInvCxlRmk(taxInvCxlRmk[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxChgRmk[i] != null)
					model.setTaxChgRmk(taxChgRmk[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (taxInvSeq[i] != null)
					model.setTaxInvSeq(taxInvSeq[i]);
				if (taxChgCd[i] != null)
					model.setTaxChgCd(taxChgCd[i]);
				if (taxChgLoclNm[i] != null)
					model.setTaxChgLoclNm(taxChgLoclNm[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (taxChgNo[i] != null)
					model.setTaxChgNo(taxChgNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArTaxChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArTaxChgVO[]
	 */
	public InvArTaxChgVO[] getInvArTaxChgVOs(){
		InvArTaxChgVO[] vos = (InvArTaxChgVO[])models.toArray(new InvArTaxChgVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrAmt = this.loclCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvNo = this.taxInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlRmk = this.taxInvCxlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxChgRmk = this.taxChgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvSeq = this.taxInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxChgCd = this.taxChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxChgLoclNm = this.taxChgLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxChgNo = this.taxChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
