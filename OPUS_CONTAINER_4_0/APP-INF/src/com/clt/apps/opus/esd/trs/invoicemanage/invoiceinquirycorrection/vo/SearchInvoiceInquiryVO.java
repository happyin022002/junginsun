/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInvoiceInquiryVO.java
*@FileTitle : SearchInvoiceInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.09.08 손은주(TRS) 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.vo;

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

public class SearchInvoiceInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoiceInquiryVO> models = new ArrayList<SearchInvoiceInquiryVO>();
	
	/* Column Info */
	private String formInvVndrSeq = null;
	/* Column Info */
	private String dateCd = null;
	/* Column Info */
	private String holdCd = null;
	/* Column Info */
	private String spTp = null;
	/* Column Info */
	private String comboSvcProvider = null;
	/* Column Info */
	private String noTp = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String ivcCreUsrId = null;
	/* Column Info */
	private String ipage = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String invCreOfc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String recievedCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String formUsrOfcCd = null;
	/* Column Info */
	private String formInvNo = null;
	/* Column Info */
	private String amountVerifyCd = null;
	/* Column Info */
	private String fmdate = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String noCd = null;
	/* Column Info */
	private String invCreOfcCd = null;
	/* Column Info */
	private String formCreUsrId = null;
	/* Column Info */
	private String invTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInvoiceInquiryVO() {}

	public SearchInvoiceInquiryVO(String ibflag, String pagerows, String fCmd, String ipage, String formCreUsrId, String formUsrOfcCd, String invCreOfcCd, String formInvNo, String formInvVndrSeq, String fmdate, String todate, String dateCd, String statusCd, String holdCd, String recievedCd, String amountVerifyCd, String spTp, String comboSvcProvider, String noTp, String noCd, String invCreOfc, String ivcCreUsrId, String invTpCd) {
		this.formInvVndrSeq = formInvVndrSeq;
		this.dateCd = dateCd;
		this.holdCd = holdCd;
		this.spTp = spTp;
		this.comboSvcProvider = comboSvcProvider;
		this.noTp = noTp;
		this.fCmd = fCmd;
		this.ivcCreUsrId = ivcCreUsrId;
		this.ipage = ipage;
		this.todate = todate;
		this.invCreOfc = invCreOfc;
		this.pagerows = pagerows;
		this.recievedCd = recievedCd;
		this.ibflag = ibflag;
		this.formUsrOfcCd = formUsrOfcCd;
		this.formInvNo = formInvNo;
		this.amountVerifyCd = amountVerifyCd;
		this.fmdate = fmdate;
		this.statusCd = statusCd;
		this.noCd = noCd;
		this.invCreOfcCd = invCreOfcCd;
		this.formCreUsrId = formCreUsrId;
		this.invTpCd = invTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("FORM_INV_VNDR_SEQ", getFormInvVndrSeq());
		this.hashColumns.put("date_cd", getDateCd());
		this.hashColumns.put("hold_cd", getHoldCd());
		this.hashColumns.put("sp_tp", getSpTp());
		this.hashColumns.put("combo_svc_provider", getComboSvcProvider());
		this.hashColumns.put("no_tp", getNoTp());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("ivc_cre_usr_id", getIvcCreUsrId());
		this.hashColumns.put("ipage", getIpage());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("inv_cre_ofc", getInvCreOfc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("recieved_cd", getRecievedCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("FORM_USR_OFC_CD", getFormUsrOfcCd());
		this.hashColumns.put("FORM_INV_NO", getFormInvNo());
		this.hashColumns.put("amount_verify_cd", getAmountVerifyCd());
		this.hashColumns.put("fmdate", getFmdate());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("no_cd", getNoCd());
		this.hashColumns.put("INV_CRE_OFC_CD", getInvCreOfcCd());
		this.hashColumns.put("FORM_CRE_USR_ID", getFormCreUsrId());
		this.hashColumns.put("inv_tp_cd", getInvTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("FORM_INV_VNDR_SEQ", "formInvVndrSeq");
		this.hashFields.put("date_cd", "dateCd");
		this.hashFields.put("hold_cd", "holdCd");
		this.hashFields.put("sp_tp", "spTp");
		this.hashFields.put("combo_svc_provider", "comboSvcProvider");
		this.hashFields.put("no_tp", "noTp");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("ivc_cre_usr_id", "ivcCreUsrId");
		this.hashFields.put("ipage", "ipage");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("inv_cre_ofc", "invCreOfc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("recieved_cd", "recievedCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("FORM_USR_OFC_CD", "formUsrOfcCd");
		this.hashFields.put("FORM_INV_NO", "formInvNo");
		this.hashFields.put("amount_verify_cd", "amountVerifyCd");
		this.hashFields.put("fmdate", "fmdate");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("no_cd", "noCd");
		this.hashFields.put("INV_CRE_OFC_CD", "invCreOfcCd");
		this.hashFields.put("FORM_CRE_USR_ID", "formCreUsrId");
		this.hashFields.put("inv_tp_cd", "invTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return formInvVndrSeq
	 */
	public String getFormInvVndrSeq() {
		return this.formInvVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return dateCd
	 */
	public String getDateCd() {
		return this.dateCd;
	}
	
	/**
	 * Column Info
	 * @return holdCd
	 */
	public String getHoldCd() {
		return this.holdCd;
	}
	
	/**
	 * Column Info
	 * @return spTp
	 */
	public String getSpTp() {
		return this.spTp;
	}
	
	/**
	 * Column Info
	 * @return comboSvcProvider
	 */
	public String getComboSvcProvider() {
		return this.comboSvcProvider;
	}
	
	/**
	 * Column Info
	 * @return noTp
	 */
	public String getNoTp() {
		return this.noTp;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return ivcCreUsrId
	 */
	public String getIvcCreUsrId() {
		return this.ivcCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return ipage
	 */
	public String getIpage() {
		return this.ipage;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return invCreOfc
	 */
	public String getInvCreOfc() {
		return this.invCreOfc;
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
	 * @return recievedCd
	 */
	public String getRecievedCd() {
		return this.recievedCd;
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
	 * @return formUsrOfcCd
	 */
	public String getFormUsrOfcCd() {
		return this.formUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return formInvNo
	 */
	public String getFormInvNo() {
		return this.formInvNo;
	}
	
	/**
	 * Column Info
	 * @return amountVerifyCd
	 */
	public String getAmountVerifyCd() {
		return this.amountVerifyCd;
	}
	
	/**
	 * Column Info
	 * @return fmdate
	 */
	public String getFmdate() {
		return this.fmdate;
	}
	
	/**
	 * Column Info
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * Column Info
	 * @return noCd
	 */
	public String getNoCd() {
		return this.noCd;
	}
	
	/**
	 * Column Info
	 * @return invCreOfcCd
	 */
	public String getInvCreOfcCd() {
		return this.invCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return formCreUsrId
	 */
	public String getFormCreUsrId() {
		return this.formCreUsrId;
	}
	

	/**
	 * Column Info
	 * @param formInvVndrSeq
	 */
	public void setFormInvVndrSeq(String formInvVndrSeq) {
		this.formInvVndrSeq = formInvVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param dateCd
	 */
	public void setDateCd(String dateCd) {
		this.dateCd = dateCd;
	}
	
	/**
	 * Column Info
	 * @param holdCd
	 */
	public void setHoldCd(String holdCd) {
		this.holdCd = holdCd;
	}
	
	/**
	 * Column Info
	 * @param spTp
	 */
	public void setSpTp(String spTp) {
		this.spTp = spTp;
	}
	
	/**
	 * Column Info
	 * @param comboSvcProvider
	 */
	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}
	
	/**
	 * Column Info
	 * @param noTp
	 */
	public void setNoTp(String noTp) {
		this.noTp = noTp;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param ivcCreUsrId
	 */
	public void setIvcCreUsrId(String ivcCreUsrId) {
		this.ivcCreUsrId = ivcCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param ipage
	 */
	public void setIpage(String ipage) {
		this.ipage = ipage;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param invCreOfc
	 */
	public void setInvCreOfc(String invCreOfc) {
		this.invCreOfc = invCreOfc;
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
	 * @param recievedCd
	 */
	public void setRecievedCd(String recievedCd) {
		this.recievedCd = recievedCd;
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
	 * @param formUsrOfcCd
	 */
	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param formInvNo
	 */
	public void setFormInvNo(String formInvNo) {
		this.formInvNo = formInvNo;
	}
	
	/**
	 * Column Info
	 * @param amountVerifyCd
	 */
	public void setAmountVerifyCd(String amountVerifyCd) {
		this.amountVerifyCd = amountVerifyCd;
	}
	
	/**
	 * Column Info
	 * @param fmdate
	 */
	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
	}
	
	/**
	 * Column Info
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	/**
	 * Column Info
	 * @param noCd
	 */
	public void setNoCd(String noCd) {
		this.noCd = noCd;
	}
	
	/**
	 * Column Info
	 * @param invCreOfcCd
	 */
	public void setInvCreOfcCd(String invCreOfcCd) {
		this.invCreOfcCd = invCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param formCreUsrId
	 */
	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getInvTpCd() {
		return invTpCd;
	}

	public void setInvTpCd(String invTpCd) {
		this.invTpCd = invTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFormInvVndrSeq(JSPUtil.getParameter(request, "FORM_INV_VNDR_SEQ", ""));
		setDateCd(JSPUtil.getParameter(request, "date_cd", ""));
		setHoldCd(JSPUtil.getParameter(request, "hold_cd", ""));
		setSpTp(JSPUtil.getParameter(request, "sp_tp", ""));
		setComboSvcProvider(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		setNoTp(JSPUtil.getParameter(request, "no_tp", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setIvcCreUsrId(JSPUtil.getParameter(request, "ivc_cre_usr_id", ""));
		setIpage(JSPUtil.getParameter(request, "ipage", ""));
		setTodate(JSPUtil.getParameter(request, "todate", ""));
		setInvCreOfc(JSPUtil.getParameter(request, "inv_cre_ofc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRecievedCd(JSPUtil.getParameter(request, "recieved_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFormUsrOfcCd(JSPUtil.getParameter(request, "FORM_USR_OFC_CD", ""));
		setFormInvNo(JSPUtil.getParameter(request, "FORM_INV_NO", ""));
		setAmountVerifyCd(JSPUtil.getParameter(request, "amount_verify_cd", ""));
		setFmdate(JSPUtil.getParameter(request, "fmdate", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setNoCd(JSPUtil.getParameter(request, "no_cd", ""));
		setInvCreOfcCd(JSPUtil.getParameter(request, "INV_CRE_OFC_CD", ""));
		setFormCreUsrId(JSPUtil.getParameter(request, "FORM_CRE_USR_ID", ""));
		setInvTpCd(JSPUtil.getParameter(request, "inv_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceInquiryVO[]
	 */
	public SearchInvoiceInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceInquiryVO[]
	 */
	public SearchInvoiceInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoiceInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] formInvVndrSeq = (JSPUtil.getParameter(request, prefix	+ "FORM_INV_VNDR_SEQ", length));
			String[] dateCd = (JSPUtil.getParameter(request, prefix	+ "date_cd", length));
			String[] holdCd = (JSPUtil.getParameter(request, prefix	+ "hold_cd", length));
			String[] spTp = (JSPUtil.getParameter(request, prefix	+ "sp_tp", length));
			String[] comboSvcProvider = (JSPUtil.getParameter(request, prefix	+ "combo_svc_provider", length));
			String[] noTp = (JSPUtil.getParameter(request, prefix	+ "no_tp", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] ivcCreUsrId = (JSPUtil.getParameter(request, prefix	+ "ivc_cre_usr_id", length));
			String[] ipage = (JSPUtil.getParameter(request, prefix	+ "ipage", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] invCreOfc = (JSPUtil.getParameter(request, prefix	+ "inv_cre_ofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] recievedCd = (JSPUtil.getParameter(request, prefix	+ "recieved_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] formUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "FORM_USR_OFC_CD", length));
			String[] formInvNo = (JSPUtil.getParameter(request, prefix	+ "FORM_INV_NO", length));
			String[] amountVerifyCd = (JSPUtil.getParameter(request, prefix	+ "amount_verify_cd", length));
			String[] fmdate = (JSPUtil.getParameter(request, prefix	+ "fmdate", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] noCd = (JSPUtil.getParameter(request, prefix	+ "no_cd", length));
			String[] invCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "INV_CRE_OFC_CD", length));
			String[] formCreUsrId = (JSPUtil.getParameter(request, prefix	+ "FORM_CRE_USR_ID", length));
			String[] invTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoiceInquiryVO();
				if (formInvVndrSeq[i] != null)
					model.setFormInvVndrSeq(formInvVndrSeq[i]);
				if (dateCd[i] != null)
					model.setDateCd(dateCd[i]);
				if (holdCd[i] != null)
					model.setHoldCd(holdCd[i]);
				if (spTp[i] != null)
					model.setSpTp(spTp[i]);
				if (comboSvcProvider[i] != null)
					model.setComboSvcProvider(comboSvcProvider[i]);
				if (noTp[i] != null)
					model.setNoTp(noTp[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (ivcCreUsrId[i] != null)
					model.setIvcCreUsrId(ivcCreUsrId[i]);
				if (ipage[i] != null)
					model.setIpage(ipage[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (invCreOfc[i] != null)
					model.setInvCreOfc(invCreOfc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (recievedCd[i] != null)
					model.setRecievedCd(recievedCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (formUsrOfcCd[i] != null)
					model.setFormUsrOfcCd(formUsrOfcCd[i]);
				if (formInvNo[i] != null)
					model.setFormInvNo(formInvNo[i]);
				if (amountVerifyCd[i] != null)
					model.setAmountVerifyCd(amountVerifyCd[i]);
				if (fmdate[i] != null)
					model.setFmdate(fmdate[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (noCd[i] != null)
					model.setNoCd(noCd[i]);
				if (invCreOfcCd[i] != null)
					model.setInvCreOfcCd(invCreOfcCd[i]);
				if (formCreUsrId[i] != null)
					model.setFormCreUsrId(formCreUsrId[i]);
				if (invTpCd[i] != null)
					model.setInvTpCd(invTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoiceInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoiceInquiryVO[]
	 */
	public SearchInvoiceInquiryVO[] getSearchInvoiceInquiryVOs(){
		SearchInvoiceInquiryVO[] vos = (SearchInvoiceInquiryVO[])models.toArray(new SearchInvoiceInquiryVO[models.size()]);
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
		this.formInvVndrSeq = this.formInvVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateCd = this.dateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holdCd = this.holdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spTp = this.spTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProvider = this.comboSvcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noTp = this.noTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivcCreUsrId = this.ivcCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipage = this.ipage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreOfc = this.invCreOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recievedCd = this.recievedCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formUsrOfcCd = this.formUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formInvNo = this.formInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountVerifyCd = this.amountVerifyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmdate = this.fmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noCd = this.noCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreOfcCd = this.invCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formCreUsrId = this.formCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpCd = this.invTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
