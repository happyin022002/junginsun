/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0114ConditionVO.java
*@FileTitle : EesEqr0114ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0114ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0114ConditionVO> models = new ArrayList<EesEqr0114ConditionVO>();
	
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String endYrwk = null;
	/* Column Info */
	private String endplnyr = null;
	/* Column Info */
	private String stholwk = null;
	/* Column Info */
	private String stholyr = null;
	/* Column Info */
	private String holidays = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String country = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String endplnwk = null;
	/* Column Info */
	private String startYrwk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stplnyr = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String endholyr = null;
	/* Column Info */
	private String endholwk = null;
	/* Column Info */
	private String stplnwk = null;
	/* Column Info */
	private String stdt = null;
	/* Column Info */
	private String cntcd = null;
	/* Column Info */
	private String rccDivFlg = null;
	
	public String getStdt() {
		return stdt;
	}

	public void setStdt(String stdt) {
		this.stdt = stdt;
	}

	private String[] wkInfo = null;
	private String newHolidayTitle = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0114ConditionVO() {}

	public EesEqr0114ConditionVO(String ibflag, String pagerows, String scnrId, String startYrwk, String endYrwk, String yyyyww, String seq, String country, String stplnyr, String stplnwk, String endplnyr, String endplnwk, String holidays, String stholwk, String endholwk, String stholyr, String endholyr, String stdt, String cntcd, String rccDivFlg) {
		this.scnrId = scnrId;
		this.endYrwk = endYrwk;
		this.endplnyr = endplnyr;
		this.stholwk = stholwk;
		this.stholyr = stholyr;
		this.holidays = holidays;
		this.pagerows = pagerows;
		this.country = country;
		this.yyyyww = yyyyww;
		this.endplnwk = endplnwk;
		this.startYrwk = startYrwk;
		this.ibflag = ibflag;
		this.stplnyr = stplnyr;
		this.seq = seq;
		this.endholyr = endholyr;
		this.endholwk = endholwk;
		this.stplnwk = stplnwk;
		this.stdt = stdt;
		this.cntcd = cntcd;
		this.rccDivFlg = rccDivFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("end_yrwk", getEndYrwk());
		this.hashColumns.put("endplnyr", getEndplnyr());
		this.hashColumns.put("stholwk", getStholwk());
		this.hashColumns.put("stholyr", getStholyr());
		this.hashColumns.put("holidays", getHolidays());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("country", getCountry());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("endplnwk", getEndplnwk());
		this.hashColumns.put("start_yrwk", getStartYrwk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stplnyr", getStplnyr());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("endholyr", getEndholyr());
		this.hashColumns.put("endholwk", getEndholwk());
		this.hashColumns.put("stplnwk", getStplnwk());
		this.hashColumns.put("stdt", getStdt());
		this.hashColumns.put("cntcd", getCntcd());
		this.hashColumns.put("rccDivFlg", getRccDivFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("end_yrwk", "endYrwk");
		this.hashFields.put("endplnyr", "endplnyr");
		this.hashFields.put("stholwk", "stholwk");
		this.hashFields.put("stholyr", "stholyr");
		this.hashFields.put("holidays", "holidays");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("country", "country");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("endplnwk", "endplnwk");
		this.hashFields.put("start_yrwk", "startYrwk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stplnyr", "stplnyr");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("endholyr", "endholyr");
		this.hashFields.put("endholwk", "endholwk");
		this.hashFields.put("stplnwk", "stplnwk");
		this.hashFields.put("stdt", "stdt");
		this.hashFields.put("cntcd", "cntcd");
		this.hashFields.put("rccDivFlg", "rccDivFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return endYrwk
	 */
	public String getEndYrwk() {
		return this.endYrwk;
	}
	
	/**
	 * Column Info
	 * @return endplnyr
	 */
	public String getEndplnyr() {
		return this.endplnyr;
	}
	
	/**
	 * Column Info
	 * @return stholwk
	 */
	public String getStholwk() {
		return this.stholwk;
	}
	
	/**
	 * Column Info
	 * @return stholyr
	 */
	public String getStholyr() {
		return this.stholyr;
	}
	
	/**
	 * Column Info
	 * @return holidays
	 */
	public String getHolidays() {
		return this.holidays;
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
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return endplnwk
	 */
	public String getEndplnwk() {
		return this.endplnwk;
	}
	
	/**
	 * Column Info
	 * @return startYrwk
	 */
	public String getStartYrwk() {
		return this.startYrwk;
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
	 * @return stplnyr
	 */
	public String getStplnyr() {
		return this.stplnyr;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return endholyr
	 */
	public String getEndholyr() {
		return this.endholyr;
	}
	
	/**
	 * Column Info
	 * @return endholwk
	 */
	public String getEndholwk() {
		return this.endholwk;
	}
	
	/**
	 * Column Info
	 * @return stplnwk
	 */
	public String getStplnwk() {
		return this.stplnwk;
	}
	
	public String[] getWkInfo() {
		return wkInfo;
	}

	
	public String getNewHolidayTitle() {
		return newHolidayTitle;
	}	

	public String getCntcd() {
		return cntcd;
	}

	public String getRccDivFlg() {
		return rccDivFlg;
	}

	public void setRccDivFlg(String rccDivFlg) {
		this.rccDivFlg = rccDivFlg;
	}
	
	public void setWkInfo(String[] wkInfo) {
		this.wkInfo = wkInfo;
	}
	
	public void setNewHolidayTitle(String newHolidayTitle) {
		this.newHolidayTitle = newHolidayTitle;
	}

	public void setCntcd(String cntcd) {
		this.cntcd = cntcd;
	}

	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param endYrwk
	 */
	public void setEndYrwk(String endYrwk) {
		this.endYrwk = endYrwk;
	}
	
	/**
	 * Column Info
	 * @param endplnyr
	 */
	public void setEndplnyr(String endplnyr) {
		this.endplnyr = endplnyr;
	}
	
	/**
	 * Column Info
	 * @param stholwk
	 */
	public void setStholwk(String stholwk) {
		this.stholwk = stholwk;
	}
	
	/**
	 * Column Info
	 * @param stholyr
	 */
	public void setStholyr(String stholyr) {
		this.stholyr = stholyr;
	}
	
	/**
	 * Column Info
	 * @param holidays
	 */
	public void setHolidays(String holidays) {
		this.holidays = holidays;
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
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param endplnwk
	 */
	public void setEndplnwk(String endplnwk) {
		this.endplnwk = endplnwk;
	}
	
	/**
	 * Column Info
	 * @param startYrwk
	 */
	public void setStartYrwk(String startYrwk) {
		this.startYrwk = startYrwk;
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
	 * @param stplnyr
	 */
	public void setStplnyr(String stplnyr) {
		this.stplnyr = stplnyr;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param endholyr
	 */
	public void setEndholyr(String endholyr) {
		this.endholyr = endholyr;
	}
	
	/**
	 * Column Info
	 * @param endholwk
	 */
	public void setEndholwk(String endholwk) {
		this.endholwk = endholwk;
	}
	
	/**
	 * Column Info
	 * @param stplnwk
	 */
	public void setStplnwk(String stplnwk) {
		this.stplnwk = stplnwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStplnyr(JSPUtil.getParameter(request, "stPlnYr", ""));
		setStplnwk(JSPUtil.getParameter(request, "stPlnWk", ""));
		setStholwk(JSPUtil.getParameter(request, "stHolWk", ""));
		setStholyr(JSPUtil.getParameter(request, "stHolYr", ""));
		setEndplnyr(JSPUtil.getParameter(request, "endPlnYr", ""));
		setEndplnwk(JSPUtil.getParameter(request, "endPlnWk", ""));
		setHolidays(JSPUtil.getParameter(request, "holidays", ""));
		setCountry(JSPUtil.getParameter(request, "country", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setEndholyr(JSPUtil.getParameter(request, "endHolYr", ""));
		setEndholwk(JSPUtil.getParameter(request, "endHolWk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStartYrwk(JSPUtil.getParameter(request, "start_yrwk", ""));
		setEndYrwk(JSPUtil.getParameter(request, "end_yrwk", ""));
		setStdt(JSPUtil.getParameter(request, "stDt", ""));
		setCntcd(JSPUtil.getParameter(request, "cntCd", ""));
		setRccDivFlg(JSPUtil.getParameter(request, "rcc_div_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0114ConditionVO[]
	 */
	public EesEqr0114ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0114ConditionVO[]
	 */
	public EesEqr0114ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0114ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] endYrwk = (JSPUtil.getParameter(request, prefix	+ "end_yrwk", length));
			String[] endplnyr = (JSPUtil.getParameter(request, prefix	+ "endplnyr", length));
			String[] stholwk = (JSPUtil.getParameter(request, prefix	+ "stholwk", length));
			String[] stholyr = (JSPUtil.getParameter(request, prefix	+ "stholyr", length));
			String[] holidays = (JSPUtil.getParameter(request, prefix	+ "holidays", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] country = (JSPUtil.getParameter(request, prefix	+ "country", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] endplnwk = (JSPUtil.getParameter(request, prefix	+ "endplnwk", length));
			String[] startYrwk = (JSPUtil.getParameter(request, prefix	+ "start_yrwk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stplnyr = (JSPUtil.getParameter(request, prefix	+ "stplnyr", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] endholyr = (JSPUtil.getParameter(request, prefix	+ "endholyr", length));
			String[] endholwk = (JSPUtil.getParameter(request, prefix	+ "endholwk", length));
			String[] stplnwk = (JSPUtil.getParameter(request, prefix	+ "stplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0114ConditionVO();
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (endYrwk[i] != null)
					model.setEndYrwk(endYrwk[i]);
				if (endplnyr[i] != null)
					model.setEndplnyr(endplnyr[i]);
				if (stholwk[i] != null)
					model.setStholwk(stholwk[i]);
				if (stholyr[i] != null)
					model.setStholyr(stholyr[i]);
				if (holidays[i] != null)
					model.setHolidays(holidays[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (country[i] != null)
					model.setCountry(country[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (endplnwk[i] != null)
					model.setEndplnwk(endplnwk[i]);
				if (startYrwk[i] != null)
					model.setStartYrwk(startYrwk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stplnyr[i] != null)
					model.setStplnyr(stplnyr[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (endholyr[i] != null)
					model.setEndholyr(endholyr[i]);
				if (endholwk[i] != null)
					model.setEndholwk(endholwk[i]);
				if (stplnwk[i] != null)
					model.setStplnwk(stplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0114ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0114ConditionVO[]
	 */
	public EesEqr0114ConditionVO[] getEesEqr0114ConditionVOs(){
		EesEqr0114ConditionVO[] vos = (EesEqr0114ConditionVO[])models.toArray(new EesEqr0114ConditionVO[models.size()]);
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
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endYrwk = this.endYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endplnyr = this.endplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stholwk = this.stholwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stholyr = this.stholyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holidays = this.holidays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.country = this.country .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endplnwk = this.endplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startYrwk = this.startYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stplnyr = this.stplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endholyr = this.endholyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endholwk = this.endholwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stplnwk = this.stplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
