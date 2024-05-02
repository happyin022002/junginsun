/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaRelease0052List01VO.java
*@FileTitle : SearchMonthlyQuotaRelease0052List01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.28 주선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.vo;

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
 * @author 주선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaRelease0052List01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaRelease0052List01VO> models = new ArrayList<SearchMonthlyQuotaRelease0052List01VO>();
	
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String mqtaRlseVerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlseGdt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String qtaRlseStsCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaRelease0052List01VO() {}

	public SearchMonthlyQuotaRelease0052List01VO(String ibflag, String pagerows, String mqtaRlseVerNo, String status, String bseYr, String bseQtrCd, String rlseGdt, String qtaRlseStsCd) {
		this.bseQtrCd = bseQtrCd;
		this.mqtaRlseVerNo = mqtaRlseVerNo;
		this.ibflag = ibflag;
		this.rlseGdt = rlseGdt;
		this.status = status;
		this.qtaRlseStsCd = qtaRlseStsCd;
		this.bseYr = bseYr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("mqta_rlse_ver_no", getMqtaRlseVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlse_gdt", getRlseGdt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("qta_rlse_sts_cd", getQtaRlseStsCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("mqta_rlse_ver_no", "mqtaRlseVerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlse_gdt", "rlseGdt");
		this.hashFields.put("status", "status");
		this.hashFields.put("qta_rlse_sts_cd", "qtaRlseStsCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return mqtaRlseVerNo
	 */
	public String getMqtaRlseVerNo() {
		return this.mqtaRlseVerNo;
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
	 * @return rlseGdt
	 */
	public String getRlseGdt() {
		return this.rlseGdt;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return qtaRlseStsCd
	 */
	public String getQtaRlseStsCd() {
		return this.qtaRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param mqtaRlseVerNo
	 */
	public void setMqtaRlseVerNo(String mqtaRlseVerNo) {
		this.mqtaRlseVerNo = mqtaRlseVerNo;
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
	 * @param rlseGdt
	 */
	public void setRlseGdt(String rlseGdt) {
		this.rlseGdt = rlseGdt;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param qtaRlseStsCd
	 */
	public void setQtaRlseStsCd(String qtaRlseStsCd) {
		this.qtaRlseStsCd = qtaRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setMqtaRlseVerNo(JSPUtil.getParameter(request, "mqta_rlse_ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRlseGdt(JSPUtil.getParameter(request, "rlse_gdt", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setQtaRlseStsCd(JSPUtil.getParameter(request, "qta_rlse_sts_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaRelease0052List01VO[]
	 */
	public SearchMonthlyQuotaRelease0052List01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaRelease0052List01VO[]
	 */
	public SearchMonthlyQuotaRelease0052List01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaRelease0052List01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] mqtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_rlse_ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlseGdt = (JSPUtil.getParameter(request, prefix	+ "rlse_gdt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] qtaRlseStsCd = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_sts_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaRelease0052List01VO();
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (mqtaRlseVerNo[i] != null)
					model.setMqtaRlseVerNo(mqtaRlseVerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlseGdt[i] != null)
					model.setRlseGdt(rlseGdt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (qtaRlseStsCd[i] != null)
					model.setQtaRlseStsCd(qtaRlseStsCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaRelease0052List01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaRelease0052List01VO[]
	 */
	public SearchMonthlyQuotaRelease0052List01VO[] getSearchMonthlyQuotaRelease0052List01VOs(){
		SearchMonthlyQuotaRelease0052List01VO[] vos = (SearchMonthlyQuotaRelease0052List01VO[])models.toArray(new SearchMonthlyQuotaRelease0052List01VO[models.size()]);
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
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaRlseVerNo = this.mqtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseGdt = this.rlseGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseStsCd = this.qtaRlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
