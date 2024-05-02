/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSInventoryByOnhireYearMGTVO.java
*@FileTitle : CHSInventoryByOnhireYearMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.30 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSInventoryByOnhireYearMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSInventoryByOnhireYearMGTVO> models = new ArrayList<CHSInventoryByOnhireYearMGTVO>();
	
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String includeNp = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String year6 = null;
	/* Column Info */
	private String year5 = null;
	/* Column Info */
	private String year8 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String year7 = null;
	/* Column Info */
	private String yearTotal = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String year2 = null;
	/* Column Info */
	private String group1 = null;
	/* Column Info */
	private String year1 = null;
	/* Column Info */
	private String year4 = null;
	/* Column Info */
	private String year3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSInventoryByOnhireYearMGTVO() {}

	public CHSInventoryByOnhireYearMGTVO(String ibflag, String pagerows, String eqKndCd, String location, String crntLocCd, String crntYdCd, String aciacDivCd, String includeNp, String onhDt, String group1, String eqTpszCd, String agmtLstmCd, String vndrSeq, String chssMvmtStsCd, String yearTotal, String year8, String year7, String year6, String year5, String year4, String year3, String year2, String year1) {
		this.location = location;
		this.includeNp = includeNp;
		this.crntYdCd = crntYdCd;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.aciacDivCd = aciacDivCd;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.year6 = year6;
		this.year5 = year5;
		this.year8 = year8;
		this.ibflag = ibflag;
		this.year7 = year7;
		this.yearTotal = yearTotal;
		this.vndrSeq = vndrSeq;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.crntLocCd = crntLocCd;
		this.year2 = year2;
		this.group1 = group1;
		this.year1 = year1;
		this.year4 = year4;
		this.year3 = year3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("include_np", getIncludeNp());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("year_6", getYear6());
		this.hashColumns.put("year_5", getYear5());
		this.hashColumns.put("year_8", getYear8());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("year_7", getYear7());
		this.hashColumns.put("year_total", getYearTotal());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("year_2", getYear2());
		this.hashColumns.put("group1", getGroup1());
		this.hashColumns.put("year_1", getYear1());
		this.hashColumns.put("year_4", getYear4());
		this.hashColumns.put("year_3", getYear3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("location", "location");
		this.hashFields.put("include_np", "includeNp");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("year_6", "year6");
		this.hashFields.put("year_5", "year5");
		this.hashFields.put("year_8", "year8");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("year_7", "year7");
		this.hashFields.put("year_total", "yearTotal");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("year_2", "year2");
		this.hashFields.put("group1", "group1");
		this.hashFields.put("year_1", "year1");
		this.hashFields.put("year_4", "year4");
		this.hashFields.put("year_3", "year3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return includeNp
	 */
	public String getIncludeNp() {
		return this.includeNp;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return year6
	 */
	public String getYear6() {
		return this.year6;
	}
	
	/**
	 * Column Info
	 * @return year5
	 */
	public String getYear5() {
		return this.year5;
	}
	
	/**
	 * Column Info
	 * @return year8
	 */
	public String getYear8() {
		return this.year8;
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
	 * @return year7
	 */
	public String getYear7() {
		return this.year7;
	}
	
	/**
	 * Column Info
	 * @return yearTotal
	 */
	public String getYearTotal() {
		return this.yearTotal;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	
	/**
	 * Column Info
	 * @return year2
	 */
	public String getYear2() {
		return this.year2;
	}
	
	/**
	 * Column Info
	 * @return group1
	 */
	public String getGroup1() {
		return this.group1;
	}
	
	/**
	 * Column Info
	 * @return year1
	 */
	public String getYear1() {
		return this.year1;
	}
	
	/**
	 * Column Info
	 * @return year4
	 */
	public String getYear4() {
		return this.year4;
	}
	
	/**
	 * Column Info
	 * @return year3
	 */
	public String getYear3() {
		return this.year3;
	}
	

	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param includeNp
	 */
	public void setIncludeNp(String includeNp) {
		this.includeNp = includeNp;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param year6
	 */
	public void setYear6(String year6) {
		this.year6 = year6;
	}
	
	/**
	 * Column Info
	 * @param year5
	 */
	public void setYear5(String year5) {
		this.year5 = year5;
	}
	
	/**
	 * Column Info
	 * @param year8
	 */
	public void setYear8(String year8) {
		this.year8 = year8;
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
	 * @param year7
	 */
	public void setYear7(String year7) {
		this.year7 = year7;
	}
	
	/**
	 * Column Info
	 * @param yearTotal
	 */
	public void setYearTotal(String yearTotal) {
		this.yearTotal = yearTotal;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Column Info
	 * @param year2
	 */
	public void setYear2(String year2) {
		this.year2 = year2;
	}
	
	/**
	 * Column Info
	 * @param group1
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
	}
	
	/**
	 * Column Info
	 * @param year1
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	
	/**
	 * Column Info
	 * @param year4
	 */
	public void setYear4(String year4) {
		this.year4 = year4;
	}
	
	/**
	 * Column Info
	 * @param year3
	 */
	public void setYear3(String year3) {
		this.year3 = year3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setIncludeNp(JSPUtil.getParameter(request, "include_np", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setYear6(JSPUtil.getParameter(request, "year_6", ""));
		setYear5(JSPUtil.getParameter(request, "year_5", ""));
		setYear8(JSPUtil.getParameter(request, "year_8", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYear7(JSPUtil.getParameter(request, "year_7", ""));
		setYearTotal(JSPUtil.getParameter(request, "year_total", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
		setYear2(JSPUtil.getParameter(request, "year_2", ""));
		setGroup1(JSPUtil.getParameter(request, "group1", ""));
		setYear1(JSPUtil.getParameter(request, "year_1", ""));
		setYear4(JSPUtil.getParameter(request, "year_4", ""));
		setYear3(JSPUtil.getParameter(request, "year_3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSInventoryByOnhireYearMGTVO[]
	 */
	public CHSInventoryByOnhireYearMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSInventoryByOnhireYearMGTVO[]
	 */
	public CHSInventoryByOnhireYearMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSInventoryByOnhireYearMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] includeNp = (JSPUtil.getParameter(request, prefix	+ "include_np", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] year6 = (JSPUtil.getParameter(request, prefix	+ "year_6", length));
			String[] year5 = (JSPUtil.getParameter(request, prefix	+ "year_5", length));
			String[] year8 = (JSPUtil.getParameter(request, prefix	+ "year_8", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] year7 = (JSPUtil.getParameter(request, prefix	+ "year_7", length));
			String[] yearTotal = (JSPUtil.getParameter(request, prefix	+ "year_total", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] year2 = (JSPUtil.getParameter(request, prefix	+ "year_2", length));
			String[] group1 = (JSPUtil.getParameter(request, prefix	+ "group1", length));
			String[] year1 = (JSPUtil.getParameter(request, prefix	+ "year_1", length));
			String[] year4 = (JSPUtil.getParameter(request, prefix	+ "year_4", length));
			String[] year3 = (JSPUtil.getParameter(request, prefix	+ "year_3", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSInventoryByOnhireYearMGTVO();
				if (location[i] != null)
					model.setLocation(location[i]);
				if (includeNp[i] != null)
					model.setIncludeNp(includeNp[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (year6[i] != null)
					model.setYear6(year6[i]);
				if (year5[i] != null)
					model.setYear5(year5[i]);
				if (year8[i] != null)
					model.setYear8(year8[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (year7[i] != null)
					model.setYear7(year7[i]);
				if (yearTotal[i] != null)
					model.setYearTotal(yearTotal[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (year2[i] != null)
					model.setYear2(year2[i]);
				if (group1[i] != null)
					model.setGroup1(group1[i]);
				if (year1[i] != null)
					model.setYear1(year1[i]);
				if (year4[i] != null)
					model.setYear4(year4[i]);
				if (year3[i] != null)
					model.setYear3(year3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSInventoryByOnhireYearMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSInventoryByOnhireYearMGTVO[]
	 */
	public CHSInventoryByOnhireYearMGTVO[] getCHSInventoryByOnhireYearMGTVOs(){
		CHSInventoryByOnhireYearMGTVO[] vos = (CHSInventoryByOnhireYearMGTVO[])models.toArray(new CHSInventoryByOnhireYearMGTVO[models.size()]);
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
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeNp = this.includeNp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year6 = this.year6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year5 = this.year5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year8 = this.year8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year7 = this.year7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearTotal = this.yearTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year2 = this.year2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group1 = this.group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year1 = this.year1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year4 = this.year4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year3 = this.year3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
