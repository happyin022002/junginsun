/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CHSSCNOReportMGTVO.java
*@FileTitle : CHSSCNOReportMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSSCNOReportMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSSCNOReportMGTVO> models = new ArrayList<CHSSCNOReportMGTVO>();
	
	/* Column Info */
	private String yearmonth = null;
	/* Column Info */
	private String exempt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custKind = null;
	/* Column Info */
	private String amtAvg = null;
	/* Column Info */
	private String amtRent = null;
	/* Column Info */
	private String billDay = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTerm = null;
	/* Column Info */
	private String boundCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String billDayAvg = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String amtBox = null;
	/* Column Info */
	private String custActCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custActNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSSCNOReportMGTVO() {}

	public CHSSCNOReportMGTVO(String ibflag, String pagerows, String scNo, String custCd, String custNm, String custKind, String custActCd, String custActNm, String yearmonth, String sccCd, String ydCd, String boundCd, String blTerm, String exempt, String billDay, String billDayAvg, String amtRent, String amtBox, String amtAvg) {
		this.yearmonth = yearmonth;
		this.exempt = exempt;
		this.custNm = custNm;
		this.custKind = custKind;
		this.amtAvg = amtAvg;
		this.amtRent = amtRent;
		this.billDay = billDay;
		this.pagerows = pagerows;
		this.blTerm = blTerm;
		this.boundCd = boundCd;
		this.ibflag = ibflag;
		this.billDayAvg = billDayAvg;
		this.sccCd = sccCd;
		this.amtBox = amtBox;
		this.custActCd = custActCd;
		this.ydCd = ydCd;
		this.scNo = scNo;
		this.custCd = custCd;
		this.custActNm = custActNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yearmonth", getYearmonth());
		this.hashColumns.put("exempt", getExempt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_kind", getCustKind());
		this.hashColumns.put("amt_avg", getAmtAvg());
		this.hashColumns.put("amt_rent", getAmtRent());
		this.hashColumns.put("bill_day", getBillDay());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_term", getBlTerm());
		this.hashColumns.put("bound_cd", getBoundCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bill_day_avg", getBillDayAvg());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("amt_box", getAmtBox());
		this.hashColumns.put("cust_act_cd", getCustActCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_act_nm", getCustActNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yearmonth", "yearmonth");
		this.hashFields.put("exempt", "exempt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_kind", "custKind");
		this.hashFields.put("amt_avg", "amtAvg");
		this.hashFields.put("amt_rent", "amtRent");
		this.hashFields.put("bill_day", "billDay");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_term", "blTerm");
		this.hashFields.put("bound_cd", "boundCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bill_day_avg", "billDayAvg");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("amt_box", "amtBox");
		this.hashFields.put("cust_act_cd", "custActCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_act_nm", "custActNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yearmonth
	 */
	public String getYearmonth() {
		return this.yearmonth;
	}
	
	/**
	 * Column Info
	 * @return exempt
	 */
	public String getExempt() {
		return this.exempt;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return custKind
	 */
	public String getCustKind() {
		return this.custKind;
	}
	
	/**
	 * Column Info
	 * @return amtAvg
	 */
	public String getAmtAvg() {
		return this.amtAvg;
	}
	
	/**
	 * Column Info
	 * @return amtRent
	 */
	public String getAmtRent() {
		return this.amtRent;
	}
	
	/**
	 * Column Info
	 * @return billDay
	 */
	public String getBillDay() {
		return this.billDay;
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
	 * @return blTerm
	 */
	public String getBlTerm() {
		return this.blTerm;
	}
	
	/**
	 * Column Info
	 * @return boundCd
	 */
	public String getBoundCd() {
		return this.boundCd;
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
	 * @return billDayAvg
	 */
	public String getBillDayAvg() {
		return this.billDayAvg;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return amtBox
	 */
	public String getAmtBox() {
		return this.amtBox;
	}
	
	/**
	 * Column Info
	 * @return custActCd
	 */
	public String getCustActCd() {
		return this.custActCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return custActNm
	 */
	public String getCustActNm() {
		return this.custActNm;
	}
	

	/**
	 * Column Info
	 * @param yearmonth
	 */
	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}
	
	/**
	 * Column Info
	 * @param exempt
	 */
	public void setExempt(String exempt) {
		this.exempt = exempt;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param custKind
	 */
	public void setCustKind(String custKind) {
		this.custKind = custKind;
	}
	
	/**
	 * Column Info
	 * @param amtAvg
	 */
	public void setAmtAvg(String amtAvg) {
		this.amtAvg = amtAvg;
	}
	
	/**
	 * Column Info
	 * @param amtRent
	 */
	public void setAmtRent(String amtRent) {
		this.amtRent = amtRent;
	}
	
	/**
	 * Column Info
	 * @param billDay
	 */
	public void setBillDay(String billDay) {
		this.billDay = billDay;
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
	 * @param blTerm
	 */
	public void setBlTerm(String blTerm) {
		this.blTerm = blTerm;
	}
	
	/**
	 * Column Info
	 * @param boundCd
	 */
	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
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
	 * @param billDayAvg
	 */
	public void setBillDayAvg(String billDayAvg) {
		this.billDayAvg = billDayAvg;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param amtBox
	 */
	public void setAmtBox(String amtBox) {
		this.amtBox = amtBox;
	}
	
	/**
	 * Column Info
	 * @param custActCd
	 */
	public void setCustActCd(String custActCd) {
		this.custActCd = custActCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param custActNm
	 */
	public void setCustActNm(String custActNm) {
		this.custActNm = custActNm;
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
		setYearmonth(JSPUtil.getParameter(request, prefix + "yearmonth", ""));
		setExempt(JSPUtil.getParameter(request, prefix + "exempt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustKind(JSPUtil.getParameter(request, prefix + "cust_kind", ""));
		setAmtAvg(JSPUtil.getParameter(request, prefix + "amt_avg", ""));
		setAmtRent(JSPUtil.getParameter(request, prefix + "amt_rent", ""));
		setBillDay(JSPUtil.getParameter(request, prefix + "bill_day", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlTerm(JSPUtil.getParameter(request, prefix + "bl_term", ""));
		setBoundCd(JSPUtil.getParameter(request, prefix + "bound_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBillDayAvg(JSPUtil.getParameter(request, prefix + "bill_day_avg", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setAmtBox(JSPUtil.getParameter(request, prefix + "amt_box", ""));
		setCustActCd(JSPUtil.getParameter(request, prefix + "cust_act_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustActNm(JSPUtil.getParameter(request, prefix + "cust_act_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSSCNOReportMGTVO[]
	 */
	public CHSSCNOReportMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSSCNOReportMGTVO[]
	 */
	public CHSSCNOReportMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSSCNOReportMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yearmonth = (JSPUtil.getParameter(request, prefix	+ "yearmonth", length));
			String[] exempt = (JSPUtil.getParameter(request, prefix	+ "exempt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custKind = (JSPUtil.getParameter(request, prefix	+ "cust_kind", length));
			String[] amtAvg = (JSPUtil.getParameter(request, prefix	+ "amt_avg", length));
			String[] amtRent = (JSPUtil.getParameter(request, prefix	+ "amt_rent", length));
			String[] billDay = (JSPUtil.getParameter(request, prefix	+ "bill_day", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTerm = (JSPUtil.getParameter(request, prefix	+ "bl_term", length));
			String[] boundCd = (JSPUtil.getParameter(request, prefix	+ "bound_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] billDayAvg = (JSPUtil.getParameter(request, prefix	+ "bill_day_avg", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] amtBox = (JSPUtil.getParameter(request, prefix	+ "amt_box", length));
			String[] custActCd = (JSPUtil.getParameter(request, prefix	+ "cust_act_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custActNm = (JSPUtil.getParameter(request, prefix	+ "cust_act_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSSCNOReportMGTVO();
				if (yearmonth[i] != null)
					model.setYearmonth(yearmonth[i]);
				if (exempt[i] != null)
					model.setExempt(exempt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custKind[i] != null)
					model.setCustKind(custKind[i]);
				if (amtAvg[i] != null)
					model.setAmtAvg(amtAvg[i]);
				if (amtRent[i] != null)
					model.setAmtRent(amtRent[i]);
				if (billDay[i] != null)
					model.setBillDay(billDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTerm[i] != null)
					model.setBlTerm(blTerm[i]);
				if (boundCd[i] != null)
					model.setBoundCd(boundCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (billDayAvg[i] != null)
					model.setBillDayAvg(billDayAvg[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (amtBox[i] != null)
					model.setAmtBox(amtBox[i]);
				if (custActCd[i] != null)
					model.setCustActCd(custActCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custActNm[i] != null)
					model.setCustActNm(custActNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSSCNOReportMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSSCNOReportMGTVO[]
	 */
	public CHSSCNOReportMGTVO[] getCHSSCNOReportMGTVOs(){
		CHSSCNOReportMGTVO[] vos = (CHSSCNOReportMGTVO[])models.toArray(new CHSSCNOReportMGTVO[models.size()]);
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
		this.yearmonth = this.yearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exempt = this.exempt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custKind = this.custKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtAvg = this.amtAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtRent = this.amtRent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billDay = this.billDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTerm = this.blTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundCd = this.boundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billDayAvg = this.billDayAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtBox = this.amtBox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custActCd = this.custActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custActNm = this.custActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
