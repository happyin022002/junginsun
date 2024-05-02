/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualInvoiceSummaryVO.java
*@FileTitle : ManualInvoiceSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.11.25 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualInvoiceSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualInvoiceSummaryVO> models = new ArrayList<ManualInvoiceSummaryVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String dticinv = null;
	/* Column Info */
	private String dtocinv = null;
	/* Column Info */
	private String dmofinv = null;
	/* Column Info */
	private String reason = null;
	/* Column Info */
	private String ttlinvqty = null;
	/* Column Info */
	private String reasonn = null;
	/* Column Info */
	private String ctocamt = null;
	/* Column Info */
	private String dticamt = null;
	/* Column Info */
	private String ctocinv = null;
	/* Column Info */
	private String cticinv = null;
	/* Column Info */
	private String ttlbllamt = null;
	/* Column Info */
	private String cticamt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmofamt = null;
	/* Column Info */
	private String dtocamt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String dmifamt = null;
	/* Column Info */
	private String dmifinv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManualInvoiceSummaryVO() {}

	public ManualInvoiceSummaryVO(String ibflag, String pagerows, String office, String reason, String ttlinvqty, String cur, String ttlbllamt, String dmifinv, String dmifamt, String dticinv, String dticamt, String dmofinv, String dmofamt, String dtocinv, String dtocamt, String cticinv, String cticamt, String ctocinv, String ctocamt, String reasonn) {
		this.office = office;
		this.dticinv = dticinv;
		this.dtocinv = dtocinv;
		this.dmofinv = dmofinv;
		this.reason = reason;
		this.ttlinvqty = ttlinvqty;
		this.reasonn = reasonn;
		this.ctocamt = ctocamt;
		this.dticamt = dticamt;
		this.ctocinv = ctocinv;
		this.cticinv = cticinv;
		this.ttlbllamt = ttlbllamt;
		this.cticamt = cticamt;
		this.pagerows = pagerows;
		this.dmofamt = dmofamt;
		this.dtocamt = dtocamt;
		this.ibflag = ibflag;
		this.cur = cur;
		this.dmifamt = dmifamt;
		this.dmifinv = dmifinv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("dticinv", getDticinv());
		this.hashColumns.put("dtocinv", getDtocinv());
		this.hashColumns.put("dmofinv", getDmofinv());
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("ttlinvqty", getTtlinvqty());
		this.hashColumns.put("reasonn", getReasonn());
		this.hashColumns.put("ctocamt", getCtocamt());
		this.hashColumns.put("dticamt", getDticamt());
		this.hashColumns.put("ctocinv", getCtocinv());
		this.hashColumns.put("cticinv", getCticinv());
		this.hashColumns.put("ttlbllamt", getTtlbllamt());
		this.hashColumns.put("cticamt", getCticamt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmofamt", getDmofamt());
		this.hashColumns.put("dtocamt", getDtocamt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("dmifamt", getDmifamt());
		this.hashColumns.put("dmifinv", getDmifinv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("dticinv", "dticinv");
		this.hashFields.put("dtocinv", "dtocinv");
		this.hashFields.put("dmofinv", "dmofinv");
		this.hashFields.put("reason", "reason");
		this.hashFields.put("ttlinvqty", "ttlinvqty");
		this.hashFields.put("reasonn", "reasonn");
		this.hashFields.put("ctocamt", "ctocamt");
		this.hashFields.put("dticamt", "dticamt");
		this.hashFields.put("ctocinv", "ctocinv");
		this.hashFields.put("cticinv", "cticinv");
		this.hashFields.put("ttlbllamt", "ttlbllamt");
		this.hashFields.put("cticamt", "cticamt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmofamt", "dmofamt");
		this.hashFields.put("dtocamt", "dtocamt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("dmifamt", "dmifamt");
		this.hashFields.put("dmifinv", "dmifinv");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return dticinv
	 */
	public String getDticinv() {
		return this.dticinv;
	}
	
	/**
	 * Column Info
	 * @return dtocinv
	 */
	public String getDtocinv() {
		return this.dtocinv;
	}
	
	/**
	 * Column Info
	 * @return dmofinv
	 */
	public String getDmofinv() {
		return this.dmofinv;
	}
	
	/**
	 * Column Info
	 * @return reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 * Column Info
	 * @return ttlinvqty
	 */
	public String getTtlinvqty() {
		return this.ttlinvqty;
	}
	
	/**
	 * Column Info
	 * @return reasonn
	 */
	public String getReasonn() {
		return this.reasonn;
	}
	
	/**
	 * Column Info
	 * @return ctocamt
	 */
	public String getCtocamt() {
		return this.ctocamt;
	}
	
	/**
	 * Column Info
	 * @return dticamt
	 */
	public String getDticamt() {
		return this.dticamt;
	}
	
	/**
	 * Column Info
	 * @return ctocinv
	 */
	public String getCtocinv() {
		return this.ctocinv;
	}
	
	/**
	 * Column Info
	 * @return cticinv
	 */
	public String getCticinv() {
		return this.cticinv;
	}
	
	/**
	 * Column Info
	 * @return ttlbllamt
	 */
	public String getTtlbllamt() {
		return this.ttlbllamt;
	}
	
	/**
	 * Column Info
	 * @return cticamt
	 */
	public String getCticamt() {
		return this.cticamt;
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
	 * @return dmofamt
	 */
	public String getDmofamt() {
		return this.dmofamt;
	}
	
	/**
	 * Column Info
	 * @return dtocamt
	 */
	public String getDtocamt() {
		return this.dtocamt;
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
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return dmifamt
	 */
	public String getDmifamt() {
		return this.dmifamt;
	}
	
	/**
	 * Column Info
	 * @return dmifinv
	 */
	public String getDmifinv() {
		return this.dmifinv;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param dticinv
	 */
	public void setDticinv(String dticinv) {
		this.dticinv = dticinv;
	}
	
	/**
	 * Column Info
	 * @param dtocinv
	 */
	public void setDtocinv(String dtocinv) {
		this.dtocinv = dtocinv;
	}
	
	/**
	 * Column Info
	 * @param dmofinv
	 */
	public void setDmofinv(String dmofinv) {
		this.dmofinv = dmofinv;
	}
	
	/**
	 * Column Info
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Column Info
	 * @param ttlinvqty
	 */
	public void setTtlinvqty(String ttlinvqty) {
		this.ttlinvqty = ttlinvqty;
	}
	
	/**
	 * Column Info
	 * @param reasonn
	 */
	public void setReasonn(String reasonn) {
		this.reasonn = reasonn;
	}
	
	/**
	 * Column Info
	 * @param ctocamt
	 */
	public void setCtocamt(String ctocamt) {
		this.ctocamt = ctocamt;
	}
	
	/**
	 * Column Info
	 * @param dticamt
	 */
	public void setDticamt(String dticamt) {
		this.dticamt = dticamt;
	}
	
	/**
	 * Column Info
	 * @param ctocinv
	 */
	public void setCtocinv(String ctocinv) {
		this.ctocinv = ctocinv;
	}
	
	/**
	 * Column Info
	 * @param cticinv
	 */
	public void setCticinv(String cticinv) {
		this.cticinv = cticinv;
	}
	
	/**
	 * Column Info
	 * @param ttlbllamt
	 */
	public void setTtlbllamt(String ttlbllamt) {
		this.ttlbllamt = ttlbllamt;
	}
	
	/**
	 * Column Info
	 * @param cticamt
	 */
	public void setCticamt(String cticamt) {
		this.cticamt = cticamt;
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
	 * @param dmofamt
	 */
	public void setDmofamt(String dmofamt) {
		this.dmofamt = dmofamt;
	}
	
	/**
	 * Column Info
	 * @param dtocamt
	 */
	public void setDtocamt(String dtocamt) {
		this.dtocamt = dtocamt;
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
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param dmifamt
	 */
	public void setDmifamt(String dmifamt) {
		this.dmifamt = dmifamt;
	}
	
	/**
	 * Column Info
	 * @param dmifinv
	 */
	public void setDmifinv(String dmifinv) {
		this.dmifinv = dmifinv;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setDticinv(JSPUtil.getParameter(request, "dticinv", ""));
		setDtocinv(JSPUtil.getParameter(request, "dtocinv", ""));
		setDmofinv(JSPUtil.getParameter(request, "dmofinv", ""));
		setReason(JSPUtil.getParameter(request, "reason", ""));
		setTtlinvqty(JSPUtil.getParameter(request, "ttlinvqty", ""));
		setReasonn(JSPUtil.getParameter(request, "reasonn", ""));
		setCtocamt(JSPUtil.getParameter(request, "ctocamt", ""));
		setDticamt(JSPUtil.getParameter(request, "dticamt", ""));
		setCtocinv(JSPUtil.getParameter(request, "ctocinv", ""));
		setCticinv(JSPUtil.getParameter(request, "cticinv", ""));
		setTtlbllamt(JSPUtil.getParameter(request, "ttlbllamt", ""));
		setCticamt(JSPUtil.getParameter(request, "cticamt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmofamt(JSPUtil.getParameter(request, "dmofamt", ""));
		setDtocamt(JSPUtil.getParameter(request, "dtocamt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCur(JSPUtil.getParameter(request, "cur", ""));
		setDmifamt(JSPUtil.getParameter(request, "dmifamt", ""));
		setDmifinv(JSPUtil.getParameter(request, "dmifinv", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualInvoiceSummaryVO[]
	 */
	public ManualInvoiceSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualInvoiceSummaryVO[]
	 */
	public ManualInvoiceSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualInvoiceSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] dticinv = (JSPUtil.getParameter(request, prefix	+ "dticinv", length));
			String[] dtocinv = (JSPUtil.getParameter(request, prefix	+ "dtocinv", length));
			String[] dmofinv = (JSPUtil.getParameter(request, prefix	+ "dmofinv", length));
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] ttlinvqty = (JSPUtil.getParameter(request, prefix	+ "ttlinvqty", length));
			String[] reasonn = (JSPUtil.getParameter(request, prefix	+ "reasonn", length));
			String[] ctocamt = (JSPUtil.getParameter(request, prefix	+ "ctocamt", length));
			String[] dticamt = (JSPUtil.getParameter(request, prefix	+ "dticamt", length));
			String[] ctocinv = (JSPUtil.getParameter(request, prefix	+ "ctocinv", length));
			String[] cticinv = (JSPUtil.getParameter(request, prefix	+ "cticinv", length));
			String[] ttlbllamt = (JSPUtil.getParameter(request, prefix	+ "ttlbllamt", length));
			String[] cticamt = (JSPUtil.getParameter(request, prefix	+ "cticamt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmofamt = (JSPUtil.getParameter(request, prefix	+ "dmofamt", length));
			String[] dtocamt = (JSPUtil.getParameter(request, prefix	+ "dtocamt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] dmifamt = (JSPUtil.getParameter(request, prefix	+ "dmifamt", length));
			String[] dmifinv = (JSPUtil.getParameter(request, prefix	+ "dmifinv", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualInvoiceSummaryVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (dticinv[i] != null)
					model.setDticinv(dticinv[i]);
				if (dtocinv[i] != null)
					model.setDtocinv(dtocinv[i]);
				if (dmofinv[i] != null)
					model.setDmofinv(dmofinv[i]);
				if (reason[i] != null)
					model.setReason(reason[i]);
				if (ttlinvqty[i] != null)
					model.setTtlinvqty(ttlinvqty[i]);
				if (reasonn[i] != null)
					model.setReasonn(reasonn[i]);
				if (ctocamt[i] != null)
					model.setCtocamt(ctocamt[i]);
				if (dticamt[i] != null)
					model.setDticamt(dticamt[i]);
				if (ctocinv[i] != null)
					model.setCtocinv(ctocinv[i]);
				if (cticinv[i] != null)
					model.setCticinv(cticinv[i]);
				if (ttlbllamt[i] != null)
					model.setTtlbllamt(ttlbllamt[i]);
				if (cticamt[i] != null)
					model.setCticamt(cticamt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmofamt[i] != null)
					model.setDmofamt(dmofamt[i]);
				if (dtocamt[i] != null)
					model.setDtocamt(dtocamt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (dmifamt[i] != null)
					model.setDmifamt(dmifamt[i]);
				if (dmifinv[i] != null)
					model.setDmifinv(dmifinv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualInvoiceSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualInvoiceSummaryVO[]
	 */
	public ManualInvoiceSummaryVO[] getManualInvoiceSummaryVOs(){
		ManualInvoiceSummaryVO[] vos = (ManualInvoiceSummaryVO[])models.toArray(new ManualInvoiceSummaryVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticinv = this.dticinv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtocinv = this.dtocinv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmofinv = this.dmofinv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlinvqty = this.ttlinvqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reasonn = this.reasonn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctocamt = this.ctocamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticamt = this.dticamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctocinv = this.ctocinv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cticinv = this.cticinv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlbllamt = this.ttlbllamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cticamt = this.cticamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmofamt = this.dmofamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtocamt = this.dtocamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifamt = this.dmifamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifinv = this.dmifinv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
