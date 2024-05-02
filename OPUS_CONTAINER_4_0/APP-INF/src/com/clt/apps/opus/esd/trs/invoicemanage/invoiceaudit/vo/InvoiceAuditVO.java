/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditVO.java
*@FileTitle : InvoiceAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.17 손은주(TRS) 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.vo;

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
 * @author 손은주(TRS)
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceAuditVO> models = new ArrayList<InvoiceAuditVO>();
	
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String pageRows = null;
	/* Column Info */
	private String surchargeKey = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String invEtcAddAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String trspInvActStsCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String invBzcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceAuditVO() {}

	public InvoiceAuditVO(String ibflag, String pagerows, String pageRows, String trspSoOfcCtyCd, String trspSoSeq, String eqNo, String surchargeKey, String trspInvActStsCd, String trspWoOfcCtyCd, String trspWoSeq, String eqTpszCd, String eqKndCd, String invBzcAmt, String invEtcAddAmt) {
		this.trspWoSeq = trspWoSeq;
		this.pageRows = pageRows;
		this.surchargeKey = surchargeKey;
		this.trspSoSeq = trspSoSeq;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.invEtcAddAmt = invEtcAddAmt;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.eqTpszCd = eqTpszCd;
		this.trspInvActStsCd = trspInvActStsCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.eqKndCd = eqKndCd;
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("page_rows", getPageRows());
		this.hashColumns.put("surcharge_key", getSurchargeKey());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("inv_etc_add_amt", getInvEtcAddAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("trsp_inv_act_sts_cd", getTrspInvActStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("inv_bzc_amt", getInvBzcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("page_rows", "pageRows");
		this.hashFields.put("surcharge_key", "surchargeKey");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("inv_etc_add_amt", "invEtcAddAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("trsp_inv_act_sts_cd", "trspInvActStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("inv_bzc_amt", "invBzcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return pageRows
	 */
	public String getPageRows() {
		return this.pageRows;
	}
	
	/**
	 * Column Info
	 * @return surchargeKey
	 */
	public String getSurchargeKey() {
		return this.surchargeKey;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return invEtcAddAmt
	 */
	public String getInvEtcAddAmt() {
		return this.invEtcAddAmt;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return trspInvActStsCd
	 */
	public String getTrspInvActStsCd() {
		return this.trspInvActStsCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return invBzcAmt
	 */
	public String getInvBzcAmt() {
		return this.invBzcAmt;
	}
	

	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param pageRows
	 */
	public void setPageRows(String pageRows) {
		this.pageRows = pageRows;
	}
	
	/**
	 * Column Info
	 * @param surchargeKey
	 */
	public void setSurchargeKey(String surchargeKey) {
		this.surchargeKey = surchargeKey;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param invEtcAddAmt
	 */
	public void setInvEtcAddAmt(String invEtcAddAmt) {
		this.invEtcAddAmt = invEtcAddAmt;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param trspInvActStsCd
	 */
	public void setTrspInvActStsCd(String trspInvActStsCd) {
		this.trspInvActStsCd = trspInvActStsCd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param invBzcAmt
	 */
	public void setInvBzcAmt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setPageRows(JSPUtil.getParameter(request, "page_rows", ""));
		setSurchargeKey(JSPUtil.getParameter(request, "surcharge_key", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setInvEtcAddAmt(JSPUtil.getParameter(request, "inv_etc_add_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setTrspInvActStsCd(JSPUtil.getParameter(request, "trsp_inv_act_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setInvBzcAmt(JSPUtil.getParameter(request, "inv_bzc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceAuditVO[]
	 */
	public InvoiceAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceAuditVO[]
	 */
	public InvoiceAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] pageRows = (JSPUtil.getParameter(request, prefix	+ "page_rows", length));
			String[] surchargeKey = (JSPUtil.getParameter(request, prefix	+ "surcharge_key", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] invEtcAddAmt = (JSPUtil.getParameter(request, prefix	+ "inv_etc_add_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] trspInvActStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_act_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] invBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bzc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceAuditVO();
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (pageRows[i] != null)
					model.setPageRows(pageRows[i]);
				if (surchargeKey[i] != null)
					model.setSurchargeKey(surchargeKey[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (invEtcAddAmt[i] != null)
					model.setInvEtcAddAmt(invEtcAddAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (trspInvActStsCd[i] != null)
					model.setTrspInvActStsCd(trspInvActStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (invBzcAmt[i] != null)
					model.setInvBzcAmt(invBzcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceAuditVO[]
	 */
	public InvoiceAuditVO[] getInvoiceAuditVOs(){
		InvoiceAuditVO[] vos = (InvoiceAuditVO[])models.toArray(new InvoiceAuditVO[models.size()]);
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
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageRows = this.pageRows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeKey = this.surchargeKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEtcAddAmt = this.invEtcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvActStsCd = this.trspInvActStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBzcAmt = this.invBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
