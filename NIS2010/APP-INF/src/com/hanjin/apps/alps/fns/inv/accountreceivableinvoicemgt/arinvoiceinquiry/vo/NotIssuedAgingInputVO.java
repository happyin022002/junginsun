/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NotIssuedAgingInputVO.java
*@FileTitle : NotIssuedAgingInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.27 박정진 
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

public class NotIssuedAgingInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NotIssuedAgingInputVO> models = new ArrayList<NotIssuedAgingInputVO>();
	
	/* Column Info */
	private String amtOption = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String asOfDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String day3 = null;
	/* Column Info */
	private String day2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String day1 = null;
	/* Column Info */
	private String day0 = null;
	/* Column Info */
	private String currFlag = null;
	/* Column Info */
	private String exRateFlag = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String day5 = null;
	/* Column Info */
	private String day4 = null;
	/* Column Info */
	private String userOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NotIssuedAgingInputVO() {}

	public NotIssuedAgingInputVO(String ibflag, String pagerows, String day0, String day1, String day2, String day3, String day4, String day5, String asOfDt, String actCustCntCd, String actCustSeq, String arOfcCd, String svcScpCd, String currCd, String exRateFlag, String currFlag, String amtOption, String userOfcCd) {
		this.amtOption = amtOption;
		this.currCd = currCd;
		this.svcScpCd = svcScpCd;
		this.actCustSeq = actCustSeq;
		this.asOfDt = asOfDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.day3 = day3;
		this.day2 = day2;
		this.ibflag = ibflag;
		this.day1 = day1;
		this.day0 = day0;
		this.currFlag = currFlag;
		this.exRateFlag = exRateFlag;
		this.actCustCntCd = actCustCntCd;
		this.day5 = day5;
		this.day4 = day4;
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amt_option", getAmtOption());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("as_of_dt", getAsOfDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("day3", getDay3());
		this.hashColumns.put("day2", getDay2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("day1", getDay1());
		this.hashColumns.put("day0", getDay0());
		this.hashColumns.put("curr_flag", getCurrFlag());
		this.hashColumns.put("ex_rate_flag", getExRateFlag());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("day5", getDay5());
		this.hashColumns.put("day4", getDay4());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amt_option", "amtOption");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("as_of_dt", "asOfDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("day3", "day3");
		this.hashFields.put("day2", "day2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("day1", "day1");
		this.hashFields.put("day0", "day0");
		this.hashFields.put("curr_flag", "currFlag");
		this.hashFields.put("ex_rate_flag", "exRateFlag");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("day5", "day5");
		this.hashFields.put("day4", "day4");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amtOption
	 */
	public String getAmtOption() {
		return this.amtOption;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return asOfDt
	 */
	public String getAsOfDt() {
		return this.asOfDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return day3
	 */
	public String getDay3() {
		return this.day3;
	}
	
	/**
	 * Column Info
	 * @return day2
	 */
	public String getDay2() {
		return this.day2;
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
	 * @return day1
	 */
	public String getDay1() {
		return this.day1;
	}
	
	/**
	 * Column Info
	 * @return day0
	 */
	public String getDay0() {
		return this.day0;
	}
	
	/**
	 * Column Info
	 * @return currFlag
	 */
	public String getCurrFlag() {
		return this.currFlag;
	}
	
	/**
	 * Column Info
	 * @return exRateFlag
	 */
	public String getExRateFlag() {
		return this.exRateFlag;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return day5
	 */
	public String getDay5() {
		return this.day5;
	}
	
	/**
	 * Column Info
	 * @return day4
	 */
	public String getDay4() {
		return this.day4;
	}
	

	/**
	 * Column Info
	 * @param amtOption
	 */
	public void setAmtOption(String amtOption) {
		this.amtOption = amtOption;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param asOfDt
	 */
	public void setAsOfDt(String asOfDt) {
		this.asOfDt = asOfDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param day3
	 */
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	
	/**
	 * Column Info
	 * @param day2
	 */
	public void setDay2(String day2) {
		this.day2 = day2;
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
	 * @param day1
	 */
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	
	/**
	 * Column Info
	 * @param day0
	 */
	public void setDay0(String day0) {
		this.day0 = day0;
	}
	
	/**
	 * Column Info
	 * @param currFlag
	 */
	public void setCurrFlag(String currFlag) {
		this.currFlag = currFlag;
	}
	
	/**
	 * Column Info
	 * @param exRateFlag
	 */
	public void setExRateFlag(String exRateFlag) {
		this.exRateFlag = exRateFlag;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param day5
	 */
	public void setDay5(String day5) {
		this.day5 = day5;
	}
	
	/**
	 * Column Info
	 * @param day4
	 */
	public void setDay4(String day4) {
		this.day4 = day4;
	}
	
	public String getUserOfcCd() {
		return userOfcCd;
	}

	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAmtOption(JSPUtil.getParameter(request, "amt_option", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setAsOfDt(JSPUtil.getParameter(request, "as_of_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDay3(JSPUtil.getParameter(request, "day3", ""));
		setDay2(JSPUtil.getParameter(request, "day2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDay1(JSPUtil.getParameter(request, "day1", ""));
		setDay0(JSPUtil.getParameter(request, "day0", ""));
		setCurrFlag(JSPUtil.getParameter(request, "curr_flag", ""));
		setExRateFlag(JSPUtil.getParameter(request, "ex_rate_flag", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setDay5(JSPUtil.getParameter(request, "day5", ""));
		setDay4(JSPUtil.getParameter(request, "day4", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NotIssuedAgingInputVO[]
	 */
	public NotIssuedAgingInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NotIssuedAgingInputVO[]
	 */
	public NotIssuedAgingInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NotIssuedAgingInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amtOption = (JSPUtil.getParameter(request, prefix	+ "amt_option", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] asOfDt = (JSPUtil.getParameter(request, prefix	+ "as_of_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] day3 = (JSPUtil.getParameter(request, prefix	+ "day3", length));
			String[] day2 = (JSPUtil.getParameter(request, prefix	+ "day2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] day1 = (JSPUtil.getParameter(request, prefix	+ "day1", length));
			String[] day0 = (JSPUtil.getParameter(request, prefix	+ "day0", length));
			String[] currFlag = (JSPUtil.getParameter(request, prefix	+ "curr_flag", length));
			String[] exRateFlag = (JSPUtil.getParameter(request, prefix	+ "ex_rate_flag", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] day5 = (JSPUtil.getParameter(request, prefix	+ "day5", length));
			String[] day4 = (JSPUtil.getParameter(request, prefix	+ "day4", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NotIssuedAgingInputVO();
				if (amtOption[i] != null)
					model.setAmtOption(amtOption[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (asOfDt[i] != null)
					model.setAsOfDt(asOfDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (day3[i] != null)
					model.setDay3(day3[i]);
				if (day2[i] != null)
					model.setDay2(day2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (day1[i] != null)
					model.setDay1(day1[i]);
				if (day0[i] != null)
					model.setDay0(day0[i]);
				if (currFlag[i] != null)
					model.setCurrFlag(currFlag[i]);
				if (exRateFlag[i] != null)
					model.setExRateFlag(exRateFlag[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (day5[i] != null)
					model.setDay5(day5[i]);
				if (day4[i] != null)
					model.setDay4(day4[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNotIssuedAgingInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NotIssuedAgingInputVO[]
	 */
	public NotIssuedAgingInputVO[] getNotIssuedAgingInputVOs(){
		NotIssuedAgingInputVO[] vos = (NotIssuedAgingInputVO[])models.toArray(new NotIssuedAgingInputVO[models.size()]);
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
		this.amtOption = this.amtOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asOfDt = this.asOfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day3 = this.day3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day2 = this.day2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day1 = this.day1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day0 = this.day0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlag = this.currFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateFlag = this.exRateFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day5 = this.day5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day4 = this.day4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
