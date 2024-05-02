/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingCustomerBasicVO.java
*@FileTitle : BookingCustomerBasicVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.08 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BookingCustomerBasicVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BookingCustomerBasicVO> models = new ArrayList<BookingCustomerBasicVO>();
	
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String ioBnd = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String exist = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String toMvmtYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BookingCustomerBasicVO() {}

	public BookingCustomerBasicVO(String ibflag, String pagerows, String exist, String tpCd, String dmdtTrfCd, String cntrCycNo, String dmdtChgLocDivCd, String fmMvmtStsCd, String fmMvmtDt, String fmMvmtYdCd, String toMvmtStsCd, String toMvmtYdCd, String ioBnd, String custCntCd, String custSeq, String actCntCd, String actCustSeq, String bzcTrfCurrCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.cntrCycNo = cntrCycNo;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.actCustSeq = actCustSeq;
		this.ioBnd = ioBnd;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.actCntCd = actCntCd;
		this.tpCd = tpCd;
		this.fmMvmtDt = fmMvmtDt;
		this.exist = exist;
		this.custCntCd = custCntCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("io_bnd", getIoBnd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("exist", getExist());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("io_bnd", "ioBnd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("exist", "exist");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
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
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
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
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public String getIoBnd() {
		return this.ioBnd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return exist
	 */
	public String getExist() {
		return this.exist;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
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
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
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
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ioBnd
	 */
	public void setIoBnd(String ioBnd) {
		this.ioBnd = ioBnd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param exist
	 */
	public void setExist(String exist) {
		this.exist = exist;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
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
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setIoBnd(JSPUtil.getParameter(request, prefix + "io_bnd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setExist(JSPUtil.getParameter(request, prefix + "exist", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BookingCustomerBasicVO[]
	 */
	public BookingCustomerBasicVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BookingCustomerBasicVO[]
	 */
	public BookingCustomerBasicVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BookingCustomerBasicVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] ioBnd = (JSPUtil.getParameter(request, prefix	+ "io_bnd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] exist = (JSPUtil.getParameter(request, prefix	+ "exist", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BookingCustomerBasicVO();
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (ioBnd[i] != null)
					model.setIoBnd(ioBnd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (exist[i] != null)
					model.setExist(exist[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBookingCustomerBasicVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BookingCustomerBasicVO[]
	 */
	public BookingCustomerBasicVO[] getBookingCustomerBasicVOs(){
		BookingCustomerBasicVO[] vos = (BookingCustomerBasicVO[])models.toArray(new BookingCustomerBasicVO[models.size()]);
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
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBnd = this.ioBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exist = this.exist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
