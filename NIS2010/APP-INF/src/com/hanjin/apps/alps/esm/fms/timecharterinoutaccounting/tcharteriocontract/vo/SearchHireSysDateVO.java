/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchHIreSysDateVO.java
*@FileTitle : SearchHIreSysDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.23 정윤태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0001HTMLAction
 */
 
public class SearchHireSysDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHireSysDateVO> models = new ArrayList<SearchHireSysDateVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String hirCurrN1stCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String effDt = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String hirCurrN2ndCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String effDtTime = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDtTime = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String hirRtN2ndAmt = null;
	/* 而щ읆 �ㅻ챸 */
	private String hirRtN1stAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchHireSysDateVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String effDt, String effDtTime, String expDt, String expDtTime, String hirCurrN1stCd, String hirRtN1stAmt, String hirCurrN2ndCd, String hirRtN2ndAmt
	 * @return 
	 */
	public SearchHireSysDateVO(String ibflag, String pagerows, String effDt, String effDtTime, String expDt, String expDtTime, String hirCurrN1stCd, String hirRtN1stAmt, String hirCurrN2ndCd, String hirRtN2ndAmt) {
		this.hirCurrN1stCd = hirCurrN1stCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.hirCurrN2ndCd = hirCurrN2ndCd;
		this.effDtTime = effDtTime;
		this.expDtTime = expDtTime;
		this.expDt = expDt;
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		this.hirRtN1stAmt = hirRtN1stAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hir_curr_n1st_cd", getHirCurrN1stCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hir_curr_n2nd_cd", getHirCurrN2ndCd());
		this.hashColumns.put("eff_dt_time", getEffDtTime());
		this.hashColumns.put("exp_dt_time", getExpDtTime());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("hir_rt_n2nd_amt", getHirRtN2ndAmt());
		this.hashColumns.put("hir_rt_n1st_amt", getHirRtN1stAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hir_curr_n1st_cd", "hirCurrN1stCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hir_curr_n2nd_cd", "hirCurrN2ndCd");
		this.hashFields.put("eff_dt_time", "effDtTime");
		this.hashFields.put("exp_dt_time", "expDtTime");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("hir_rt_n2nd_amt", "hirRtN2ndAmt");
		this.hashFields.put("hir_rt_n1st_amt", "hirRtN1stAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getHirCurrN1stCd() {
		return this.hirCurrN1stCd;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getHirCurrN2ndCd() {
		return this.hirCurrN2ndCd;
	}
	public String getEffDtTime() {
		return this.effDtTime;
	}
	public String getExpDtTime() {
		return this.expDtTime;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getHirRtN2ndAmt() {
		return this.hirRtN2ndAmt;
	}
	public String getHirRtN1stAmt() {
		return this.hirRtN1stAmt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setHirCurrN1stCd(String hirCurrN1stCd) {
		this.hirCurrN1stCd = hirCurrN1stCd;
		//this.hirCurrN1stCd=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setHirCurrN2ndCd(String hirCurrN2ndCd) {
		this.hirCurrN2ndCd = hirCurrN2ndCd;
		//this.hirCurrN2ndCd=true;
	}
	public void setEffDtTime(String effDtTime) {
		this.effDtTime = effDtTime;
		//this.effDtTime=true;
	}
	public void setExpDtTime(String expDtTime) {
		this.expDtTime = expDtTime;
		//this.expDtTime=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setHirRtN2ndAmt(String hirRtN2ndAmt) {
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		//this.hirRtN2ndAmt=true;
	}
	public void setHirRtN1stAmt(String hirRtN1stAmt) {
		this.hirRtN1stAmt = hirRtN1stAmt;
		//this.hirRtN1stAmt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setHirCurrN1stCd(JSPUtil.getParameter(request, "hir_curr_n1st_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHirCurrN2ndCd(JSPUtil.getParameter(request, "hir_curr_n2nd_cd", ""));
		setEffDtTime(JSPUtil.getParameter(request, "eff_dt_time", ""));
		setExpDtTime(JSPUtil.getParameter(request, "exp_dt_time", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setHirRtN2ndAmt(JSPUtil.getParameter(request, "hir_rt_n2nd_amt", ""));
		setHirRtN1stAmt(JSPUtil.getParameter(request, "hir_rt_n1st_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchHireSysDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchHireSysDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHireSysDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hirCurrN1stCd = (JSPUtil.getParameter(request, prefix	+ "hir_curr_n1st_cd".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] hirCurrN2ndCd = (JSPUtil.getParameter(request, prefix	+ "hir_curr_n2nd_cd".trim(), length));
			String[] effDtTime = (JSPUtil.getParameter(request, prefix	+ "eff_dt_time".trim(), length));
			String[] expDtTime = (JSPUtil.getParameter(request, prefix	+ "exp_dt_time".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] hirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n2nd_amt".trim(), length));
			String[] hirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n1st_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHireSysDateVO();
				if (hirCurrN1stCd[i] != null)
					model.setHirCurrN1stCd(hirCurrN1stCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hirCurrN2ndCd[i] != null)
					model.setHirCurrN2ndCd(hirCurrN2ndCd[i]);
				if (effDtTime[i] != null)
					model.setEffDtTime(effDtTime[i]);
				if (expDtTime[i] != null)
					model.setExpDtTime(expDtTime[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (hirRtN2ndAmt[i] != null)
					model.setHirRtN2ndAmt(hirRtN2ndAmt[i]);
				if (hirRtN1stAmt[i] != null)
					model.setHirRtN1stAmt(hirRtN1stAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchHIreSysDateVOs();
	}

	public SearchHireSysDateVO[] getSearchHIreSysDateVOs(){
		SearchHireSysDateVO[] vos = (SearchHireSysDateVO[])models.toArray(new SearchHireSysDateVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.hirCurrN1stCd = this.hirCurrN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirCurrN2ndCd = this.hirCurrN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtTime = this.effDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDtTime = this.expDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN2ndAmt = this.hirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN1stAmt = this.hirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
