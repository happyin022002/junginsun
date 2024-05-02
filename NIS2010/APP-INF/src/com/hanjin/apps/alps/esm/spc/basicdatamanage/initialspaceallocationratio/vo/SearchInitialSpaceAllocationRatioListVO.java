/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInitialSpaceAllocationRatioListVO.java
*@FileTitle : SearchInitialSpaceAllocationRatioListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.28 이현주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo;

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
 * @author 이현주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInitialSpaceAllocationRatioListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInitialSpaceAllocationRatioListVO> models = new ArrayList<SearchInitialSpaceAllocationRatioListVO>();
	
	/* Column Info */
	private String mon10 = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String mon11 = null;
	/* Column Info */
	private String mon02 = null;
	/* Column Info */
	private String mon12 = null;
	/* Column Info */
	private String mon03 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mon01 = null;
	/* Column Info */
	private String mon07 = null;
	/* Column Info */
	private String mon06 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mon05 = null;
	/* Column Info */
	private String mon04 = null;
	/* Column Info */
	private String mon09 = null;
	/* Column Info */
	private String mon08 = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInitialSpaceAllocationRatioListVO() {}

	public SearchInitialSpaceAllocationRatioListVO(String ibflag, String pagerows, String repTrdCd, String dirCd, String mon01, String mon02, String mon03, String mon04, String mon05, String mon06, String mon07, String mon08, String mon09, String mon10, String mon11, String mon12) {
		this.mon10 = mon10;
		this.repTrdCd = repTrdCd;
		this.mon11 = mon11;
		this.mon02 = mon02;
		this.mon12 = mon12;
		this.mon03 = mon03;
		this.pagerows = pagerows;
		this.mon01 = mon01;
		this.mon07 = mon07;
		this.mon06 = mon06;
		this.ibflag = ibflag;
		this.mon05 = mon05;
		this.mon04 = mon04;
		this.mon09 = mon09;
		this.mon08 = mon08;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mon_10", getMon10());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("mon_11", getMon11());
		this.hashColumns.put("mon_02", getMon02());
		this.hashColumns.put("mon_12", getMon12());
		this.hashColumns.put("mon_03", getMon03());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mon_01", getMon01());
		this.hashColumns.put("mon_07", getMon07());
		this.hashColumns.put("mon_06", getMon06());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mon_05", getMon05());
		this.hashColumns.put("mon_04", getMon04());
		this.hashColumns.put("mon_09", getMon09());
		this.hashColumns.put("mon_08", getMon08());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mon_10", "mon10");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("mon_11", "mon11");
		this.hashFields.put("mon_02", "mon02");
		this.hashFields.put("mon_12", "mon12");
		this.hashFields.put("mon_03", "mon03");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mon_01", "mon01");
		this.hashFields.put("mon_07", "mon07");
		this.hashFields.put("mon_06", "mon06");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mon_05", "mon05");
		this.hashFields.put("mon_04", "mon04");
		this.hashFields.put("mon_09", "mon09");
		this.hashFields.put("mon_08", "mon08");
		this.hashFields.put("dir_cd", "dirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mon10
	 */
	public String getMon10() {
		return this.mon10;
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
	 * @return mon11
	 */
	public String getMon11() {
		return this.mon11;
	}
	
	/**
	 * Column Info
	 * @return mon02
	 */
	public String getMon02() {
		return this.mon02;
	}
	
	/**
	 * Column Info
	 * @return mon12
	 */
	public String getMon12() {
		return this.mon12;
	}
	
	/**
	 * Column Info
	 * @return mon03
	 */
	public String getMon03() {
		return this.mon03;
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
	 * @return mon01
	 */
	public String getMon01() {
		return this.mon01;
	}
	
	/**
	 * Column Info
	 * @return mon07
	 */
	public String getMon07() {
		return this.mon07;
	}
	
	/**
	 * Column Info
	 * @return mon06
	 */
	public String getMon06() {
		return this.mon06;
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
	 * @return mon05
	 */
	public String getMon05() {
		return this.mon05;
	}
	
	/**
	 * Column Info
	 * @return mon04
	 */
	public String getMon04() {
		return this.mon04;
	}
	
	/**
	 * Column Info
	 * @return mon09
	 */
	public String getMon09() {
		return this.mon09;
	}
	
	/**
	 * Column Info
	 * @return mon08
	 */
	public String getMon08() {
		return this.mon08;
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
	 * @param mon10
	 */
	public void setMon10(String mon10) {
		this.mon10 = mon10;
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
	 * @param mon11
	 */
	public void setMon11(String mon11) {
		this.mon11 = mon11;
	}
	
	/**
	 * Column Info
	 * @param mon02
	 */
	public void setMon02(String mon02) {
		this.mon02 = mon02;
	}
	
	/**
	 * Column Info
	 * @param mon12
	 */
	public void setMon12(String mon12) {
		this.mon12 = mon12;
	}
	
	/**
	 * Column Info
	 * @param mon03
	 */
	public void setMon03(String mon03) {
		this.mon03 = mon03;
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
	 * @param mon01
	 */
	public void setMon01(String mon01) {
		this.mon01 = mon01;
	}
	
	/**
	 * Column Info
	 * @param mon07
	 */
	public void setMon07(String mon07) {
		this.mon07 = mon07;
	}
	
	/**
	 * Column Info
	 * @param mon06
	 */
	public void setMon06(String mon06) {
		this.mon06 = mon06;
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
	 * @param mon05
	 */
	public void setMon05(String mon05) {
		this.mon05 = mon05;
	}
	
	/**
	 * Column Info
	 * @param mon04
	 */
	public void setMon04(String mon04) {
		this.mon04 = mon04;
	}
	
	/**
	 * Column Info
	 * @param mon09
	 */
	public void setMon09(String mon09) {
		this.mon09 = mon09;
	}
	
	/**
	 * Column Info
	 * @param mon08
	 */
	public void setMon08(String mon08) {
		this.mon08 = mon08;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMon10(JSPUtil.getParameter(request, "mon_10", ""));
		setRepTrdCd(JSPUtil.getParameter(request, "rep_trd_cd", ""));
		setMon11(JSPUtil.getParameter(request, "mon_11", ""));
		setMon02(JSPUtil.getParameter(request, "mon_02", ""));
		setMon12(JSPUtil.getParameter(request, "mon_12", ""));
		setMon03(JSPUtil.getParameter(request, "mon_03", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMon01(JSPUtil.getParameter(request, "mon_01", ""));
		setMon07(JSPUtil.getParameter(request, "mon_07", ""));
		setMon06(JSPUtil.getParameter(request, "mon_06", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMon05(JSPUtil.getParameter(request, "mon_05", ""));
		setMon04(JSPUtil.getParameter(request, "mon_04", ""));
		setMon09(JSPUtil.getParameter(request, "mon_09", ""));
		setMon08(JSPUtil.getParameter(request, "mon_08", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInitialSpaceAllocationRatioListVO[]
	 */
	public SearchInitialSpaceAllocationRatioListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInitialSpaceAllocationRatioListVO[]
	 */
	public SearchInitialSpaceAllocationRatioListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInitialSpaceAllocationRatioListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mon10 = (JSPUtil.getParameter(request, prefix	+ "mon_10", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] mon11 = (JSPUtil.getParameter(request, prefix	+ "mon_11", length));
			String[] mon02 = (JSPUtil.getParameter(request, prefix	+ "mon_02", length));
			String[] mon12 = (JSPUtil.getParameter(request, prefix	+ "mon_12", length));
			String[] mon03 = (JSPUtil.getParameter(request, prefix	+ "mon_03", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mon01 = (JSPUtil.getParameter(request, prefix	+ "mon_01", length));
			String[] mon07 = (JSPUtil.getParameter(request, prefix	+ "mon_07", length));
			String[] mon06 = (JSPUtil.getParameter(request, prefix	+ "mon_06", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mon05 = (JSPUtil.getParameter(request, prefix	+ "mon_05", length));
			String[] mon04 = (JSPUtil.getParameter(request, prefix	+ "mon_04", length));
			String[] mon09 = (JSPUtil.getParameter(request, prefix	+ "mon_09", length));
			String[] mon08 = (JSPUtil.getParameter(request, prefix	+ "mon_08", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInitialSpaceAllocationRatioListVO();
				if (mon10[i] != null)
					model.setMon10(mon10[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (mon11[i] != null)
					model.setMon11(mon11[i]);
				if (mon02[i] != null)
					model.setMon02(mon02[i]);
				if (mon12[i] != null)
					model.setMon12(mon12[i]);
				if (mon03[i] != null)
					model.setMon03(mon03[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mon01[i] != null)
					model.setMon01(mon01[i]);
				if (mon07[i] != null)
					model.setMon07(mon07[i]);
				if (mon06[i] != null)
					model.setMon06(mon06[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mon05[i] != null)
					model.setMon05(mon05[i]);
				if (mon04[i] != null)
					model.setMon04(mon04[i]);
				if (mon09[i] != null)
					model.setMon09(mon09[i]);
				if (mon08[i] != null)
					model.setMon08(mon08[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInitialSpaceAllocationRatioListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInitialSpaceAllocationRatioListVO[]
	 */
	public SearchInitialSpaceAllocationRatioListVO[] getSearchInitialSpaceAllocationRatioListVOs(){
		SearchInitialSpaceAllocationRatioListVO[] vos = (SearchInitialSpaceAllocationRatioListVO[])models.toArray(new SearchInitialSpaceAllocationRatioListVO[models.size()]);
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
		this.mon10 = this.mon10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon11 = this.mon11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon02 = this.mon02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon12 = this.mon12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon03 = this.mon03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon01 = this.mon01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon07 = this.mon07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon06 = this.mon06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon05 = this.mon05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon04 = this.mon04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon09 = this.mon09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon08 = this.mon08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
