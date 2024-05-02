/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceSummaryListVO.java
*@FileTitle : InvoiceSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.30 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceSummaryListVO> models = new ArrayList<InvoiceSummaryListVO>();
	
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String usdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String count = null;
	/* Column Info */
	private String usdEqvAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String etcCurEqvAmt = null;
	/* Column Info */
	private String lclAmt = null;
	/* Column Info */
	private String dateValue = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String ttlLclAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceSummaryListVO() {}

	public InvoiceSummaryListVO(String ibflag, String pagerows, String dateValue, String ioBndCd, String count, String usdAmt, String usdEqvAmt, String lclAmt, String etcCurEqvAmt, String dpPrcsKnt, String arOfcCd, String ttlLclAmt) {
		this.dpPrcsKnt = dpPrcsKnt;
		this.usdAmt = usdAmt;
		this.ibflag = ibflag;
		this.count = count;
		this.usdEqvAmt = usdEqvAmt;
		this.ioBndCd = ioBndCd;
		this.etcCurEqvAmt = etcCurEqvAmt;
		this.lclAmt = lclAmt;
		this.dateValue = dateValue;
		this.pagerows = pagerows;
		this.arOfcCd = arOfcCd;
		this.ttlLclAmt = ttlLclAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("count", getCount());
		this.hashColumns.put("usd_eqv_amt", getUsdEqvAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("etc_cur_eqv_amt", getEtcCurEqvAmt());
		this.hashColumns.put("lcl_amt", getLclAmt());
		this.hashColumns.put("date_value", getDateValue());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("ttl_lcl_amt", getTtlLclAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("count", "count");
		this.hashFields.put("usd_eqv_amt", "usdEqvAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("etc_cur_eqv_amt", "etcCurEqvAmt");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("date_value", "dateValue");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("ttl_lcl_amt", "ttlLclAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return count
	 */
	public String getCount() {
		return this.count;
	}
	
	/**
	 * Column Info
	 * @return usdEqvAmt
	 */
	public String getUsdEqvAmt() {
		return this.usdEqvAmt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return etcCurEqvAmt
	 */
	public String getEtcCurEqvAmt() {
		return this.etcCurEqvAmt;
	}
	
	/**
	 * Column Info
	 * @return lclAmt
	 */
	public String getLclAmt() {
		return this.lclAmt;
	}
	
	/**
	 * Column Info
	 * @return dateValue
	 */
	public String getDateValue() {
		return this.dateValue;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param count
	 */
	public void setCount(String count) {
		this.count = count;
	}
	
	/**
	 * Column Info
	 * @param usdEqvAmt
	 */
	public void setUsdEqvAmt(String usdEqvAmt) {
		this.usdEqvAmt = usdEqvAmt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param etcCurEqvAmt
	 */
	public void setEtcCurEqvAmt(String etcCurEqvAmt) {
		this.etcCurEqvAmt = etcCurEqvAmt;
	}
	
	/**
	 * Column Info
	 * @param lclAmt
	 */
	public void setLclAmt(String lclAmt) {
		this.lclAmt = lclAmt;
	}
	
	/**
	 * Column Info
	 * @param dateValue
	 */
	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getTtlLclAmt() {
		return ttlLclAmt;
	}

	public void setTtlLclAmt(String ttlLclAmt) {
		this.ttlLclAmt = ttlLclAmt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setUsdAmt(JSPUtil.getParameter(request, "usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCount(JSPUtil.getParameter(request, "count", ""));
		setUsdEqvAmt(JSPUtil.getParameter(request, "usd_eqv_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setEtcCurEqvAmt(JSPUtil.getParameter(request, "etc_cur_eqv_amt", ""));
		setLclAmt(JSPUtil.getParameter(request, "lcl_amt", ""));
		setDateValue(JSPUtil.getParameter(request, "date_value", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setTtlLclAmt(JSPUtil.getParameter(request, "ttl_lcl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceSummaryListVO[]
	 */
	public InvoiceSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceSummaryListVO[]
	 */
	public InvoiceSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] count = (JSPUtil.getParameter(request, prefix	+ "count", length));
			String[] usdEqvAmt = (JSPUtil.getParameter(request, prefix	+ "usd_eqv_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] etcCurEqvAmt = (JSPUtil.getParameter(request, prefix	+ "etc_cur_eqv_amt", length));
			String[] lclAmt = (JSPUtil.getParameter(request, prefix	+ "lcl_amt", length));
			String[] dateValue = (JSPUtil.getParameter(request, prefix	+ "date_value", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] ttlLclAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_lcl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceSummaryListVO();
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (count[i] != null)
					model.setCount(count[i]);
				if (usdEqvAmt[i] != null)
					model.setUsdEqvAmt(usdEqvAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (etcCurEqvAmt[i] != null)
					model.setEtcCurEqvAmt(etcCurEqvAmt[i]);
				if (lclAmt[i] != null)
					model.setLclAmt(lclAmt[i]);
				if (dateValue[i] != null)
					model.setDateValue(dateValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (ttlLclAmt[i] != null)
					model.setTtlLclAmt(ttlLclAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceSummaryListVO[]
	 */
	public InvoiceSummaryListVO[] getInvoiceSummaryListVOs(){
		InvoiceSummaryListVO[] vos = (InvoiceSummaryListVO[])models.toArray(new InvoiceSummaryListVO[models.size()]);
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
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count = this.count .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdEqvAmt = this.usdEqvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcCurEqvAmt = this.etcCurEqvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt = this.lclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateValue = this.dateValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLclAmt = this.ttlLclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
