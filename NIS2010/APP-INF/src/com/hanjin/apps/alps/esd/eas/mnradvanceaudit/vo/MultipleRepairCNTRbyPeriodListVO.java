/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultipleRepairCNTRbyPeriodListVO.java
*@FileTitle : MultipleRepairCNTRbyPeriodListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.05.21 박정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo; 

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MultipleRepairCNTRbyPeriodListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultipleRepairCNTRbyPeriodListVO> models = new ArrayList<MultipleRepairCNTRbyPeriodListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String totalAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usingDays = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String noOfCase = null;
	/* Column Info */
	private String ownrCoCd = null;
	/* Column Info */
	private String dvValue = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String entryDay = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MultipleRepairCNTRbyPeriodListVO() {}

	public MultipleRepairCNTRbyPeriodListVO(String ibflag, String pagerows, String eqNo, String eqTpszCd, String lstmCd, String ownrCoCd, String entryDay, String usingDays, String dvValue, String noOfCase, String totalAmt) {
		this.pagerows = pagerows;
		this.eqNo = eqNo;
		this.totalAmt = totalAmt;
		this.ibflag = ibflag;
		this.usingDays = usingDays;
		this.lstmCd = lstmCd;
		this.noOfCase = noOfCase;
		this.ownrCoCd = ownrCoCd;
		this.dvValue = dvValue;
		this.eqTpszCd = eqTpszCd;
		this.entryDay = entryDay;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("using_days", getUsingDays());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("no_of_case", getNoOfCase());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("dv_value", getDvValue());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("entry_day", getEntryDay());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("using_days", "usingDays");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("no_of_case", "noOfCase");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("entry_day", "entryDay");
		return this.hashFields;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
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
	 * @return usingDays
	 */
	public String getUsingDays() {
		return this.usingDays;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return noOfCase
	 */
	public String getNoOfCase() {
		return this.noOfCase;
	}
	
	/**
	 * Column Info
	 * @return ownrCoCd
	 */
	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @return dvValue
	 */
	public String getDvValue() {
		return this.dvValue;
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
	 * @return entryDay
	 */
	public String getEntryDay() {
		return this.entryDay;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @param usingDays
	 */
	public void setUsingDays(String usingDays) {
		this.usingDays = usingDays;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param noOfCase
	 */
	public void setNoOfCase(String noOfCase) {
		this.noOfCase = noOfCase;
	}
	
	/**
	 * Column Info
	 * @param ownrCoCd
	 */
	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @param dvValue
	 */
	public void setDvValue(String dvValue) {
		this.dvValue = dvValue;
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
	 * @param entryDay
	 */
	public void setEntryDay(String entryDay) {
		this.entryDay = entryDay;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsingDays(JSPUtil.getParameter(request, prefix + "using_days", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setNoOfCase(JSPUtil.getParameter(request, prefix + "no_of_case", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, prefix + "ownr_co_cd", ""));
		setDvValue(JSPUtil.getParameter(request, prefix + "dv_value", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setEntryDay(JSPUtil.getParameter(request, prefix + "entry_day", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MultipleRepairCNTRbyPeriodListVO[]
	 */
	public MultipleRepairCNTRbyPeriodListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MultipleRepairCNTRbyPeriodListVO[]
	 */
	public MultipleRepairCNTRbyPeriodListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultipleRepairCNTRbyPeriodListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usingDays = (JSPUtil.getParameter(request, prefix	+ "using_days", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] noOfCase = (JSPUtil.getParameter(request, prefix	+ "no_of_case", length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix	+ "ownr_co_cd", length));
			String[] dvValue = (JSPUtil.getParameter(request, prefix	+ "dv_value", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] entryDay = (JSPUtil.getParameter(request, prefix	+ "entry_day", length));
			
			for (int i = 0; i < length; i++) {
				model = new MultipleRepairCNTRbyPeriodListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usingDays[i] != null)
					model.setUsingDays(usingDays[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (noOfCase[i] != null)
					model.setNoOfCase(noOfCase[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (dvValue[i] != null)
					model.setDvValue(dvValue[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (entryDay[i] != null)
					model.setEntryDay(entryDay[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultipleRepairCNTRbyPeriodListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultipleRepairCNTRbyPeriodListVO[]
	 */
	public MultipleRepairCNTRbyPeriodListVO[] getMultipleRepairCNTRbyPeriodListVOs(){
		MultipleRepairCNTRbyPeriodListVO[] vos = (MultipleRepairCNTRbyPeriodListVO[])models.toArray(new MultipleRepairCNTRbyPeriodListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usingDays = this.usingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfCase = this.noOfCase .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue = this.dvValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entryDay = this.entryDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
