/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRailInvoiceInquiryCorrectionListConditionVO.java
*@FileTitle : SearchRailInvoiceInquiryCorrectionListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.08.24 최진오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRailInvoiceInquiryCorrectionListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRailInvoiceInquiryCorrectionListConditionVO> models = new ArrayList<SearchRailInvoiceInquiryCorrectionListConditionVO>();
	
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
	private String ivcCreUsrId = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String invCreOfc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String amountVerifyCd = null;
	/* Column Info */
	private String fmdate = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String noCd = null;
	/* Column Info */
	private String invAudStsCd = null;
	/* Column Info */
	private String svcProvider = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRailInvoiceInquiryCorrectionListConditionVO() {}

	public SearchRailInvoiceInquiryCorrectionListConditionVO(String ibflag, String pagerows, String invAudStsCd, String usrId, String usrOfcCd, String dateCd, String fmdate, String todate, String statusCd, String holdCd, String amountVerifyCd, String spTp, String comboSvcProvider, String svcProvider, String noTp, String noCd, String invCreOfc, String ivcCreUsrId) {
		this.dateCd = dateCd;
		this.holdCd = holdCd;
		this.spTp = spTp;
		this.comboSvcProvider = comboSvcProvider;
		this.noTp = noTp;
		this.ivcCreUsrId = ivcCreUsrId;
		this.todate = todate;
		this.invCreOfc = invCreOfc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.usrOfcCd = usrOfcCd;
		this.amountVerifyCd = amountVerifyCd;
		this.fmdate = fmdate;
		this.usrId = usrId;
		this.statusCd = statusCd;
		this.noCd = noCd;
		this.invAudStsCd = invAudStsCd;
		this.svcProvider = svcProvider;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_cd", getDateCd());
		this.hashColumns.put("hold_cd", getHoldCd());
		this.hashColumns.put("sp_tp", getSpTp());
		this.hashColumns.put("combo_svc_provider", getComboSvcProvider());
		this.hashColumns.put("no_tp", getNoTp());
		this.hashColumns.put("ivc_cre_usr_id", getIvcCreUsrId());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("inv_cre_ofc", getInvCreOfc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("amount_verify_cd", getAmountVerifyCd());
		this.hashColumns.put("fmdate", getFmdate());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("no_cd", getNoCd());
		this.hashColumns.put("inv_aud_sts_cd", getInvAudStsCd());
		this.hashColumns.put("svc_provider", getSvcProvider());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_cd", "dateCd");
		this.hashFields.put("hold_cd", "holdCd");
		this.hashFields.put("sp_tp", "spTp");
		this.hashFields.put("combo_svc_provider", "comboSvcProvider");
		this.hashFields.put("no_tp", "noTp");
		this.hashFields.put("ivc_cre_usr_id", "ivcCreUsrId");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("inv_cre_ofc", "invCreOfc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("amount_verify_cd", "amountVerifyCd");
		this.hashFields.put("fmdate", "fmdate");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("no_cd", "noCd");
		this.hashFields.put("inv_aud_sts_cd", "invAudStsCd");
		this.hashFields.put("svc_provider", "svcProvider");
		return this.hashFields;
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
	 * @return ivcCreUsrId
	 */
	public String getIvcCreUsrId() {
		return this.ivcCreUsrId;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return invAudStsCd
	 */
	public String getInvAudStsCd() {
		return this.invAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return svcProvider
	 */
	public String getSvcProvider() {
		return this.svcProvider;
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
	 * @param ivcCreUsrId
	 */
	public void setIvcCreUsrId(String ivcCreUsrId) {
		this.ivcCreUsrId = ivcCreUsrId;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param invAudStsCd
	 */
	public void setInvAudStsCd(String invAudStsCd) {
		this.invAudStsCd = invAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param svcProvider
	 */
	public void setSvcProvider(String svcProvider) {
		this.svcProvider = svcProvider;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDateCd(JSPUtil.getParameter(request, "date_cd", ""));
		setHoldCd(JSPUtil.getParameter(request, "hold_cd", ""));
		setSpTp(JSPUtil.getParameter(request, "sp_tp", ""));
		setComboSvcProvider(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		setNoTp(JSPUtil.getParameter(request, "no_tp", ""));
		setIvcCreUsrId(JSPUtil.getParameter(request, "ivc_cre_usr_id", ""));
		setTodate(JSPUtil.getParameter(request, "todate", ""));
		setInvCreOfc(JSPUtil.getParameter(request, "inv_cre_ofc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, "usr_ofc_cd", ""));
		setAmountVerifyCd(JSPUtil.getParameter(request, "amount_verify_cd", ""));
		setFmdate(JSPUtil.getParameter(request, "fmdate", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setNoCd(JSPUtil.getParameter(request, "no_cd", ""));
		setInvAudStsCd(JSPUtil.getParameter(request, "inv_aud_sts_cd", ""));
		setSvcProvider(JSPUtil.getParameter(request, "svc_provider", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRailInvoiceInquiryCorrectionListConditionVO[]
	 */
	public SearchRailInvoiceInquiryCorrectionListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRailInvoiceInquiryCorrectionListConditionVO[]
	 */
	public SearchRailInvoiceInquiryCorrectionListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRailInvoiceInquiryCorrectionListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateCd = (JSPUtil.getParameter(request, prefix	+ "date_cd", length));
			String[] holdCd = (JSPUtil.getParameter(request, prefix	+ "hold_cd", length));
			String[] spTp = (JSPUtil.getParameter(request, prefix	+ "sp_tp", length));
			String[] comboSvcProvider = (JSPUtil.getParameter(request, prefix	+ "combo_svc_provider", length));
			String[] noTp = (JSPUtil.getParameter(request, prefix	+ "no_tp", length));
			String[] ivcCreUsrId = (JSPUtil.getParameter(request, prefix	+ "ivc_cre_usr_id", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] invCreOfc = (JSPUtil.getParameter(request, prefix	+ "inv_cre_ofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] amountVerifyCd = (JSPUtil.getParameter(request, prefix	+ "amount_verify_cd", length));
			String[] fmdate = (JSPUtil.getParameter(request, prefix	+ "fmdate", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] noCd = (JSPUtil.getParameter(request, prefix	+ "no_cd", length));
			String[] invAudStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_aud_sts_cd", length));
			String[] svcProvider = (JSPUtil.getParameter(request, prefix	+ "svc_provider", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRailInvoiceInquiryCorrectionListConditionVO();
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
				if (ivcCreUsrId[i] != null)
					model.setIvcCreUsrId(ivcCreUsrId[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (invCreOfc[i] != null)
					model.setInvCreOfc(invCreOfc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (amountVerifyCd[i] != null)
					model.setAmountVerifyCd(amountVerifyCd[i]);
				if (fmdate[i] != null)
					model.setFmdate(fmdate[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (noCd[i] != null)
					model.setNoCd(noCd[i]);
				if (invAudStsCd[i] != null)
					model.setInvAudStsCd(invAudStsCd[i]);
				if (svcProvider[i] != null)
					model.setSvcProvider(svcProvider[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRailInvoiceInquiryCorrectionListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRailInvoiceInquiryCorrectionListConditionVO[]
	 */
	public SearchRailInvoiceInquiryCorrectionListConditionVO[] getSearchRailInvoiceInquiryCorrectionListConditionVOs(){
		SearchRailInvoiceInquiryCorrectionListConditionVO[] vos = (SearchRailInvoiceInquiryCorrectionListConditionVO[])models.toArray(new SearchRailInvoiceInquiryCorrectionListConditionVO[models.size()]);
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
		this.dateCd = this.dateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holdCd = this.holdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spTp = this.spTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProvider = this.comboSvcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noTp = this.noTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivcCreUsrId = this.ivcCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreOfc = this.invCreOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountVerifyCd = this.amountVerifyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmdate = this.fmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noCd = this.noCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudStsCd = this.invAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvider = this.svcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
