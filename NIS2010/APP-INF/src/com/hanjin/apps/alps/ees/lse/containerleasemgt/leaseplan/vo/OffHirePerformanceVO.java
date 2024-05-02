/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffHirePerformanceVO.java
*@FileTitle : OffHirePerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.17 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OffHirePerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffHirePerformanceVO> models = new ArrayList<OffHirePerformanceVO>();
	
	/* Column Info */
	private String offhLocCd = null;
	/* Column Info */
	private String typeNm = null;
	/* Column Info */
	private String offhRgnLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mnth7 = null;
	/* Column Info */
	private String mnth3 = null;
	/* Column Info */
	private String mnth8 = null;
	/* Column Info */
	private String mnth4 = null;
	/* Column Info */
	private String mnth1 = null;
	/* Column Info */
	private String mnth5 = null;
	/* Column Info */
	private String mnth2 = null;
	/* Column Info */
	private String mnth6 = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mnth12 = null;
	/* Column Info */
	private String mnth11 = null;
	/* Column Info */
	private String mnth9 = null;
	/* Column Info */
	private String mnth10 = null;
	/* Column Info */
	private String ttlQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OffHirePerformanceVO() {}

	public OffHirePerformanceVO(String ibflag, String pagerows, String offhRgnLocCd, String offhLocCd, String lstmCd, String cntrTpszCd, String typeNm, 
			                    String mnth1, String mnth2, String mnth3, String mnth4, String mnth5, String mnth6, String mnth7, String mnth8, String mnth9, 
			                    String mnth10, String mnth11, String mnth12, String ttlQty) {
		this.offhLocCd = offhLocCd;
		this.typeNm = typeNm;
		this.offhRgnLocCd = offhRgnLocCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.mnth7 = mnth7;
		this.mnth3 = mnth3;
		this.mnth8 = mnth8;
		this.mnth4 = mnth4;
		this.mnth1 = mnth1;
		this.mnth5 = mnth5;
		this.mnth2 = mnth2;
		this.mnth6 = mnth6;
		this.lstmCd = lstmCd;
		this.mnth12 = mnth12;
		this.mnth11 = mnth11;
		this.mnth9 = mnth9;
		this.mnth10 = mnth10;
		this.ttlQty = ttlQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_loc_cd", getOffhLocCd());
		this.hashColumns.put("type_nm", getTypeNm());
		this.hashColumns.put("offh_rgn_loc_cd", getOffhRgnLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mnth_7", getMnth7());
		this.hashColumns.put("mnth_3", getMnth3());
		this.hashColumns.put("mnth_8", getMnth8());
		this.hashColumns.put("mnth_4", getMnth4());
		this.hashColumns.put("mnth_1", getMnth1());
		this.hashColumns.put("mnth_5", getMnth5());
		this.hashColumns.put("mnth_2", getMnth2());
		this.hashColumns.put("mnth_6", getMnth6());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mnth_12", getMnth12());
		this.hashColumns.put("mnth_11", getMnth11());
		this.hashColumns.put("mnth_9", getMnth9());
		this.hashColumns.put("mnth_10", getMnth10());
		this.hashColumns.put("ttl_qty", getTtlQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("type_nm", "typeNm");
		this.hashFields.put("offh_rgn_loc_cd", "offhRgnLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mnth_7", "mnth7");
		this.hashFields.put("mnth_3", "mnth3");
		this.hashFields.put("mnth_8", "mnth8");
		this.hashFields.put("mnth_4", "mnth4");
		this.hashFields.put("mnth_1", "mnth1");
		this.hashFields.put("mnth_5", "mnth5");
		this.hashFields.put("mnth_2", "mnth2");
		this.hashFields.put("mnth_6", "mnth6");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mnth_12", "mnth12");
		this.hashFields.put("mnth_11", "mnth11");
		this.hashFields.put("mnth_9", "mnth9");
		this.hashFields.put("mnth_10", "mnth10");
		this.hashFields.put("ttl_qty", "ttlQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return offhLocCd
	 */
	public String getOffhLocCd() {
		return this.offhLocCd;
	}
	
	/**
	 * Column Info
	 * @return typeNm
	 */
	public String getTypeNm() {
		return this.typeNm;
	}
	
	/**
	 * Column Info
	 * @return offhRgnLocCd
	 */
	public String getOffhRgnLocCd() {
		return this.offhRgnLocCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mnth7
	 */
	public String getMnth7() {
		return this.mnth7;
	}
	
	/**
	 * Column Info
	 * @return mnth3
	 */
	public String getMnth3() {
		return this.mnth3;
	}
	
	/**
	 * Column Info
	 * @return mnth8
	 */
	public String getMnth8() {
		return this.mnth8;
	}
	
	/**
	 * Column Info
	 * @return mnth4
	 */
	public String getMnth4() {
		return this.mnth4;
	}
	
	/**
	 * Column Info
	 * @return mnth1
	 */
	public String getMnth1() {
		return this.mnth1;
	}
	
	/**
	 * Column Info
	 * @return mnth5
	 */
	public String getMnth5() {
		return this.mnth5;
	}
	
	/**
	 * Column Info
	 * @return mnth2
	 */
	public String getMnth2() {
		return this.mnth2;
	}
	
	/**
	 * Column Info
	 * @return mnth6
	 */
	public String getMnth6() {
		return this.mnth6;
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
	 * @return mnth12
	 */
	public String getMnth12() {
		return this.mnth12;
	}
	
	/**
	 * Column Info
	 * @return mnth11
	 */
	public String getMnth11() {
		return this.mnth11;
	}
	
	/**
	 * Column Info
	 * @return mnth9
	 */
	public String getMnth9() {
		return this.mnth9;
	}
	
	/**
	 * Column Info
	 * @return mnth10
	 */
	public String getMnth10() {
		return this.mnth10;
	}
	

	/**
	 * Column Info
	 * @param offhLocCd
	 */
	public void setOffhLocCd(String offhLocCd) {
		this.offhLocCd = offhLocCd;
	}
	
	/**
	 * Column Info
	 * @param typeNm
	 */
	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}
	
	/**
	 * Column Info
	 * @param offhRgnLocCd
	 */
	public void setOffhRgnLocCd(String offhRgnLocCd) {
		this.offhRgnLocCd = offhRgnLocCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mnth7
	 */
	public void setMnth7(String mnth7) {
		this.mnth7 = mnth7;
	}
	
	/**
	 * Column Info
	 * @param mnth3
	 */
	public void setMnth3(String mnth3) {
		this.mnth3 = mnth3;
	}
	
	/**
	 * Column Info
	 * @param mnth8
	 */
	public void setMnth8(String mnth8) {
		this.mnth8 = mnth8;
	}
	
	/**
	 * Column Info
	 * @param mnth4
	 */
	public void setMnth4(String mnth4) {
		this.mnth4 = mnth4;
	}
	
	/**
	 * Column Info
	 * @param mnth1
	 */
	public void setMnth1(String mnth1) {
		this.mnth1 = mnth1;
	}
	
	/**
	 * Column Info
	 * @param mnth5
	 */
	public void setMnth5(String mnth5) {
		this.mnth5 = mnth5;
	}
	
	/**
	 * Column Info
	 * @param mnth2
	 */
	public void setMnth2(String mnth2) {
		this.mnth2 = mnth2;
	}
	
	/**
	 * Column Info
	 * @param mnth6
	 */
	public void setMnth6(String mnth6) {
		this.mnth6 = mnth6;
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
	 * @param mnth12
	 */
	public void setMnth12(String mnth12) {
		this.mnth12 = mnth12;
	}
	
	/**
	 * Column Info
	 * @param mnth11
	 */
	public void setMnth11(String mnth11) {
		this.mnth11 = mnth11;
	}
	
	/**
	 * Column Info
	 * @param mnth9
	 */
	public void setMnth9(String mnth9) {
		this.mnth9 = mnth9;
	}
	
	/**
	 * Column Info
	 * @param mnth10
	 */
	public void setMnth10(String mnth10) {
		this.mnth10 = mnth10;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffhLocCd(JSPUtil.getParameter(request, "offh_loc_cd", ""));
		setTypeNm(JSPUtil.getParameter(request, "type_nm", ""));
		setOffhRgnLocCd(JSPUtil.getParameter(request, "offh_rgn_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setMnth7(JSPUtil.getParameter(request, "mnth_7", ""));
		setMnth3(JSPUtil.getParameter(request, "mnth_3", ""));
		setMnth8(JSPUtil.getParameter(request, "mnth_8", ""));
		setMnth4(JSPUtil.getParameter(request, "mnth_4", ""));
		setMnth1(JSPUtil.getParameter(request, "mnth_1", ""));
		setMnth5(JSPUtil.getParameter(request, "mnth_5", ""));
		setMnth2(JSPUtil.getParameter(request, "mnth_2", ""));
		setMnth6(JSPUtil.getParameter(request, "mnth_6", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setMnth12(JSPUtil.getParameter(request, "mnth_12", ""));
		setMnth11(JSPUtil.getParameter(request, "mnth_11", ""));
		setMnth9(JSPUtil.getParameter(request, "mnth_9", ""));
		setMnth10(JSPUtil.getParameter(request, "mnth_10", ""));
		setTtlQty(JSPUtil.getParameter(request, "ttl_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OffHirePerformanceVO[]
	 */
	public OffHirePerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OffHirePerformanceVO[]
	 */
	public OffHirePerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffHirePerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] offhLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_cd", length));
			String[] typeNm = (JSPUtil.getParameter(request, prefix	+ "type_nm", length));
			String[] offhRgnLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_rgn_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mnth7 = (JSPUtil.getParameter(request, prefix	+ "mnth_7", length));
			String[] mnth3 = (JSPUtil.getParameter(request, prefix	+ "mnth_3", length));
			String[] mnth8 = (JSPUtil.getParameter(request, prefix	+ "mnth_8", length));
			String[] mnth4 = (JSPUtil.getParameter(request, prefix	+ "mnth_4", length));
			String[] mnth1 = (JSPUtil.getParameter(request, prefix	+ "mnth_1", length));
			String[] mnth5 = (JSPUtil.getParameter(request, prefix	+ "mnth_5", length));
			String[] mnth2 = (JSPUtil.getParameter(request, prefix	+ "mnth_2", length));
			String[] mnth6 = (JSPUtil.getParameter(request, prefix	+ "mnth_6", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mnth12 = (JSPUtil.getParameter(request, prefix	+ "mnth_12", length));
			String[] mnth11 = (JSPUtil.getParameter(request, prefix	+ "mnth_11", length));
			String[] mnth9 = (JSPUtil.getParameter(request, prefix	+ "mnth_9", length));
			String[] mnth10 = (JSPUtil.getParameter(request, prefix	+ "mnth_10", length));
			String[] ttlQty = (JSPUtil.getParameter(request, prefix	+ "ttl_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new OffHirePerformanceVO();
				if (offhLocCd[i] != null)
					model.setOffhLocCd(offhLocCd[i]);
				if (typeNm[i] != null)
					model.setTypeNm(typeNm[i]);
				if (offhRgnLocCd[i] != null)
					model.setOffhRgnLocCd(offhRgnLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mnth7[i] != null)
					model.setMnth7(mnth7[i]);
				if (mnth3[i] != null)
					model.setMnth3(mnth3[i]);
				if (mnth8[i] != null)
					model.setMnth8(mnth8[i]);
				if (mnth4[i] != null)
					model.setMnth4(mnth4[i]);
				if (mnth1[i] != null)
					model.setMnth1(mnth1[i]);
				if (mnth5[i] != null)
					model.setMnth5(mnth5[i]);
				if (mnth2[i] != null)
					model.setMnth2(mnth2[i]);
				if (mnth6[i] != null)
					model.setMnth6(mnth6[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mnth12[i] != null)
					model.setMnth12(mnth12[i]);
				if (mnth11[i] != null)
					model.setMnth11(mnth11[i]);
				if (mnth9[i] != null)
					model.setMnth9(mnth9[i]);
				if (mnth10[i] != null)
					model.setMnth10(mnth10[i]);
				if (ttlQty[i] != null)
					model.setTtlQty(ttlQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOffHirePerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OffHirePerformanceVO[]
	 */
	public OffHirePerformanceVO[] getOffHirePerformanceVOs(){
		OffHirePerformanceVO[] vos = (OffHirePerformanceVO[])models.toArray(new OffHirePerformanceVO[models.size()]);
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
		this.offhLocCd = this.offhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeNm = this.typeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRgnLocCd = this.offhRgnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth7 = this.mnth7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth3 = this.mnth3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth8 = this.mnth8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth4 = this.mnth4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth1 = this.mnth1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth5 = this.mnth5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth2 = this.mnth2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth6 = this.mnth6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth12 = this.mnth12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth11 = this.mnth11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth9 = this.mnth9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth10 = this.mnth10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlQty = this.ttlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setTtlQty(String ttlQty) {
		this.ttlQty = ttlQty;
	}

	public String getTtlQty() {
		return ttlQty;
	}
}
