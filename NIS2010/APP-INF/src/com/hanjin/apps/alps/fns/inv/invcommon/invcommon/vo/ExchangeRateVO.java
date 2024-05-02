/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateVO.java
*@FileTitle : ExchangeRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.27 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExchangeRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExchangeRateVO> models = new ArrayList<ExchangeRateVO>();
	
	/* Column Info */
	private String thirdExrateType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String exRateDate = null;
	/* Column Info */
	private String usdExrateType = null;
	/* Column Info */
	private String cngIndivCd = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExchangeRateVO() {}

	public ExchangeRateVO(String ibflag, String pagerows, String curr, String exRate, String usdExrateType, String cngIndivCd, String thirdExrateType, String exRateDate) {
		this.thirdExrateType = thirdExrateType;
		this.ibflag = ibflag;
		this.exRate = exRate;
		this.curr = curr;
		this.exRateDate = exRateDate;
		this.usdExrateType = usdExrateType;
		this.cngIndivCd = cngIndivCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("third_exrate_type", getThirdExrateType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("ex_rate_date", getExRateDate());
		this.hashColumns.put("usd_exrate_type", getUsdExrateType());
		this.hashColumns.put("cng_indiv_cd", getCngIndivCd());		
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("third_exrate_type", "thirdExrateType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("ex_rate_date", "exRateDate");
		this.hashFields.put("usd_exrate_type", "usdExrateType");
		this.hashFields.put("cng_indiv_cd", "cngIndivCd");		
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return thirdExrateType
	 */
	public String getThirdExrateType() {
		return this.thirdExrateType;
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
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return exRateDate
	 */
	public String getExRateDate() {
		return this.exRateDate;
	}
	
	/**
	 * Column Info
	 * @return usdExrateType
	 */
	public String getUsdExrateType() {
		return this.usdExrateType;
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
	 * @param thirdExrateType
	 */
	public void setThirdExrateType(String thirdExrateType) {
		this.thirdExrateType = thirdExrateType;
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
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param exRateDate
	 */
	public void setExRateDate(String exRateDate) {
		this.exRateDate = exRateDate;
	}
	
	/**
	 * Column Info
	 * @param usdExrateType
	 */
	public void setUsdExrateType(String usdExrateType) {
		this.usdExrateType = usdExrateType;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getCngIndivCd() {
		return cngIndivCd;
	}

	public void setCngIndivCd(String cngIndivCd) {
		this.cngIndivCd = cngIndivCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setThirdExrateType(JSPUtil.getParameter(request, "third_exrate_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExRate(JSPUtil.getParameter(request, "ex_rate", ""));
		setCurr(JSPUtil.getParameter(request, "curr", ""));
		setExRateDate(JSPUtil.getParameter(request, "ex_rate_date", ""));
		setUsdExrateType(JSPUtil.getParameter(request, "usd_exrate_type", ""));
		setCngIndivCd(JSPUtil.getParameter(request, "cng_indiv_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExchangeRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] thirdExrateType = (JSPUtil.getParameter(request, prefix	+ "third_exrate_type".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate".trim(), length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr".trim(), length));
			String[] exRateDate = (JSPUtil.getParameter(request, prefix	+ "ex_rate_date".trim(), length));
			String[] usdExrateType = (JSPUtil.getParameter(request, prefix	+ "usd_exrate_type".trim(), length));
			String[] cngIndivCd = (JSPUtil.getParameter(request, prefix	+ "cng_indiv_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExchangeRateVO();
				if (thirdExrateType[i] != null)
					model.setThirdExrateType(thirdExrateType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (exRateDate[i] != null)
					model.setExRateDate(exRateDate[i]);
				if (usdExrateType[i] != null)
					model.setUsdExrateType(usdExrateType[i]);
				if (cngIndivCd[i] != null)
					model.setCngIndivCd(cngIndivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExchangeRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[] getExchangeRateVOs(){
		ExchangeRateVO[] vos = (ExchangeRateVO[])models.toArray(new ExchangeRateVO[models.size()]);
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
		this.thirdExrateType = this.thirdExrateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateDate = this.exRateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdExrateType = this.usdExrateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngIndivCd = this.cngIndivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
