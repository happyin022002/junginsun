/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDailyForcastManageByWeekListVO.java
*@FileTitle : SearchDailyForcastManageByWeekListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.23 한상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDailyForcastManageByWeekListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForcastManageByWeekListVO> models = new ArrayList<SearchDailyForcastManageByWeekListVO>();
	
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd1 = null;
	/* Column Info */
	private String polCd2 = null;
	/* Column Info */
	private String polCd3 = null;
	/* Column Info */
	private String polCd4 = null;
	/* Column Info */
	private String polCd5 = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String polCd6 = null;
	/* Column Info */
	private String polCd7 = null;
	/* Column Info */
	private String polCd8 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String polCd9 = null;
	/* Column Info */
	private String polCd10 = null;
	/* Column Info */
	private String repSubTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDailyForcastManageByWeekListVO() {}

	public SearchDailyForcastManageByWeekListVO(String ibflag, String pagerows, String repTrdCd, String repSubTrdCd, String rlaneCd, String dirCd, String iocTsCd, String bseYr, String bseWk, String slsAqCd, String slsOfcCd, String polCd1, String polCd2, String polCd3, String polCd4, String polCd5, String polCd6, String polCd7, String polCd8, String polCd9, String polCd10) {
		this.iocTsCd = iocTsCd;
		this.slsAqCd = slsAqCd;
		this.rlaneCd = rlaneCd;
		this.bseYr = bseYr;
		this.repTrdCd = repTrdCd;
		this.bseWk = bseWk;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd1 = polCd1;
		this.polCd2 = polCd2;
		this.polCd3 = polCd3;
		this.polCd4 = polCd4;
		this.polCd5 = polCd5;
		this.slsOfcCd = slsOfcCd;
		this.polCd6 = polCd6;
		this.polCd7 = polCd7;
		this.polCd8 = polCd8;
		this.dirCd = dirCd;
		this.polCd9 = polCd9;
		this.polCd10 = polCd10;
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd1", getPolCd1());
		this.hashColumns.put("pol_cd2", getPolCd2());
		this.hashColumns.put("pol_cd3", getPolCd3());
		this.hashColumns.put("pol_cd4", getPolCd4());
		this.hashColumns.put("pol_cd5", getPolCd5());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("pol_cd6", getPolCd6());
		this.hashColumns.put("pol_cd7", getPolCd7());
		this.hashColumns.put("pol_cd8", getPolCd8());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pol_cd9", getPolCd9());
		this.hashColumns.put("pol_cd10", getPolCd10());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd1", "polCd1");
		this.hashFields.put("pol_cd2", "polCd2");
		this.hashFields.put("pol_cd3", "polCd3");
		this.hashFields.put("pol_cd4", "polCd4");
		this.hashFields.put("pol_cd5", "polCd5");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("pol_cd6", "polCd6");
		this.hashFields.put("pol_cd7", "polCd7");
		this.hashFields.put("pol_cd8", "polCd8");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pol_cd9", "polCd9");
		this.hashFields.put("pol_cd10", "polCd10");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
	}
	
	/**
	 * Column Info
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
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
	 * @return polCd1
	 */
	public String getPolCd1() {
		return this.polCd1;
	}
	
	/**
	 * Column Info
	 * @return polCd2
	 */
	public String getPolCd2() {
		return this.polCd2;
	}
	
	/**
	 * Column Info
	 * @return polCd3
	 */
	public String getPolCd3() {
		return this.polCd3;
	}
	
	/**
	 * Column Info
	 * @return polCd4
	 */
	public String getPolCd4() {
		return this.polCd4;
	}
	
	/**
	 * Column Info
	 * @return polCd5
	 */
	public String getPolCd5() {
		return this.polCd5;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return polCd6
	 */
	public String getPolCd6() {
		return this.polCd6;
	}
	
	/**
	 * Column Info
	 * @return polCd7
	 */
	public String getPolCd7() {
		return this.polCd7;
	}
	
	/**
	 * Column Info
	 * @return polCd8
	 */
	public String getPolCd8() {
		return this.polCd8;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return polCd9
	 */
	public String getPolCd9() {
		return this.polCd9;
	}
	
	/**
	 * Column Info
	 * @return polCd10
	 */
	public String getPolCd10() {
		return this.polCd10;
	}
	
	/**
	 * Column Info
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
	}
	

	/**
	 * Column Info
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
	}
	
	/**
	 * Column Info
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
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
	 * @param polCd1
	 */
	public void setPolCd1(String polCd1) {
		this.polCd1 = polCd1;
	}
	
	/**
	 * Column Info
	 * @param polCd2
	 */
	public void setPolCd2(String polCd2) {
		this.polCd2 = polCd2;
	}
	
	/**
	 * Column Info
	 * @param polCd3
	 */
	public void setPolCd3(String polCd3) {
		this.polCd3 = polCd3;
	}
	
	/**
	 * Column Info
	 * @param polCd4
	 */
	public void setPolCd4(String polCd4) {
		this.polCd4 = polCd4;
	}
	
	/**
	 * Column Info
	 * @param polCd5
	 */
	public void setPolCd5(String polCd5) {
		this.polCd5 = polCd5;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param polCd6
	 */
	public void setPolCd6(String polCd6) {
		this.polCd6 = polCd6;
	}
	
	/**
	 * Column Info
	 * @param polCd7
	 */
	public void setPolCd7(String polCd7) {
		this.polCd7 = polCd7;
	}
	
	/**
	 * Column Info
	 * @param polCd8
	 */
	public void setPolCd8(String polCd8) {
		this.polCd8 = polCd8;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param polCd9
	 */
	public void setPolCd9(String polCd9) {
		this.polCd9 = polCd9;
	}
	
	/**
	 * Column Info
	 * @param polCd10
	 */
	public void setPolCd10(String polCd10) {
		this.polCd10 = polCd10;
	}
	
	/**
	 * Column Info
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIocTsCd(JSPUtil.getParameter(request, "ioc_ts_cd", ""));
		setSlsAqCd(JSPUtil.getParameter(request, "sls_aq_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRepTrdCd(JSPUtil.getParameter(request, "rep_trd_cd", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd1(JSPUtil.getParameter(request, "pol_cd1", ""));
		setPolCd2(JSPUtil.getParameter(request, "pol_cd2", ""));
		setPolCd3(JSPUtil.getParameter(request, "pol_cd3", ""));
		setPolCd4(JSPUtil.getParameter(request, "pol_cd4", ""));
		setPolCd5(JSPUtil.getParameter(request, "pol_cd5", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setPolCd6(JSPUtil.getParameter(request, "pol_cd6", ""));
		setPolCd7(JSPUtil.getParameter(request, "pol_cd7", ""));
		setPolCd8(JSPUtil.getParameter(request, "pol_cd8", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setPolCd9(JSPUtil.getParameter(request, "pol_cd9", ""));
		setPolCd10(JSPUtil.getParameter(request, "pol_cd10", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, "rep_sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForcastManageByWeekListVO[]
	 */
	public SearchDailyForcastManageByWeekListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForcastManageByWeekListVO[]
	 */
	public SearchDailyForcastManageByWeekListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForcastManageByWeekListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd1 = (JSPUtil.getParameter(request, prefix	+ "pol_cd1", length));
			String[] polCd2 = (JSPUtil.getParameter(request, prefix	+ "pol_cd2", length));
			String[] polCd3 = (JSPUtil.getParameter(request, prefix	+ "pol_cd3", length));
			String[] polCd4 = (JSPUtil.getParameter(request, prefix	+ "pol_cd4", length));
			String[] polCd5 = (JSPUtil.getParameter(request, prefix	+ "pol_cd5", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] polCd6 = (JSPUtil.getParameter(request, prefix	+ "pol_cd6", length));
			String[] polCd7 = (JSPUtil.getParameter(request, prefix	+ "pol_cd7", length));
			String[] polCd8 = (JSPUtil.getParameter(request, prefix	+ "pol_cd8", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] polCd9 = (JSPUtil.getParameter(request, prefix	+ "pol_cd9", length));
			String[] polCd10 = (JSPUtil.getParameter(request, prefix	+ "pol_cd10", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForcastManageByWeekListVO();
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd1[i] != null)
					model.setPolCd1(polCd1[i]);
				if (polCd2[i] != null)
					model.setPolCd2(polCd2[i]);
				if (polCd3[i] != null)
					model.setPolCd3(polCd3[i]);
				if (polCd4[i] != null)
					model.setPolCd4(polCd4[i]);
				if (polCd5[i] != null)
					model.setPolCd5(polCd5[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (polCd6[i] != null)
					model.setPolCd6(polCd6[i]);
				if (polCd7[i] != null)
					model.setPolCd7(polCd7[i]);
				if (polCd8[i] != null)
					model.setPolCd8(polCd8[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (polCd9[i] != null)
					model.setPolCd9(polCd9[i]);
				if (polCd10[i] != null)
					model.setPolCd10(polCd10[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForcastManageByWeekListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForcastManageByWeekListVO[]
	 */
	public SearchDailyForcastManageByWeekListVO[] getSearchDailyForcastManageByWeekListVOs(){
		SearchDailyForcastManageByWeekListVO[] vos = (SearchDailyForcastManageByWeekListVO[])models.toArray(new SearchDailyForcastManageByWeekListVO[models.size()]);
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
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd1 = this.polCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd2 = this.polCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd3 = this.polCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd4 = this.polCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd5 = this.polCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd6 = this.polCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd7 = this.polCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd8 = this.polCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd9 = this.polCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd10 = this.polCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
