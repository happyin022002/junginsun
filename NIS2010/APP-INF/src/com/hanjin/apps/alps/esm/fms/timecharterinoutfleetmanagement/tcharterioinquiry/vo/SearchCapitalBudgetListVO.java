/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCapitalBudgetListVO.java
*@FileTitle : SearchCapitalBudgetListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.07.03 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCapitalBudgetListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCapitalBudgetListVO> models = new ArrayList<SearchCapitalBudgetListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tiCurrCd = null;
	/* Column Info */
	private String tiInvAmt = null;
	/* Column Info */
	private String toInvAmt2 = null;
	/* Column Info */
	private String toCurrCd = null;
	/* Column Info */
	private String toCurrCd2 = null;
	/* Column Info */
	private String tiCurrCd2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String tiInvAmt2 = null;
	/* Column Info */
	private String toInvAmt = null;
	/* Column Info */
	private String vslEngNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCapitalBudgetListVO() {}

	public SearchCapitalBudgetListVO(String ibflag, String pagerows, String effDt, String vslCd, String vslEngNm, String tiCurrCd, String tiInvAmt, String tiCurrCd2, String tiInvAmt2, String toCurrCd, String toInvAmt, String toCurrCd2, String toInvAmt2) {
		this.vslCd = vslCd;
		this.tiCurrCd = tiCurrCd;
		this.tiInvAmt = tiInvAmt;
		this.toInvAmt2 = toInvAmt2;
		this.toCurrCd = toCurrCd;
		this.toCurrCd2 = toCurrCd2;
		this.tiCurrCd2 = tiCurrCd2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.tiInvAmt2 = tiInvAmt2;
		this.toInvAmt = toInvAmt;
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ti_curr_cd", getTiCurrCd());
		this.hashColumns.put("ti_inv_amt", getTiInvAmt());
		this.hashColumns.put("to_inv_amt2", getToInvAmt2());
		this.hashColumns.put("to_curr_cd", getToCurrCd());
		this.hashColumns.put("to_curr_cd2", getToCurrCd2());
		this.hashColumns.put("ti_curr_cd2", getTiCurrCd2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ti_inv_amt2", getTiInvAmt2());
		this.hashColumns.put("to_inv_amt", getToInvAmt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ti_curr_cd", "tiCurrCd");
		this.hashFields.put("ti_inv_amt", "tiInvAmt");
		this.hashFields.put("to_inv_amt2", "toInvAmt2");
		this.hashFields.put("to_curr_cd", "toCurrCd");
		this.hashFields.put("to_curr_cd2", "toCurrCd2");
		this.hashFields.put("ti_curr_cd2", "tiCurrCd2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ti_inv_amt2", "tiInvAmt2");
		this.hashFields.put("to_inv_amt", "toInvAmt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return tiCurrCd
	 */
	public String getTiCurrCd() {
		return this.tiCurrCd;
	}
	
	/**
	 * Column Info
	 * @return tiInvAmt
	 */
	public String getTiInvAmt() {
		return this.tiInvAmt;
	}
	
	/**
	 * Column Info
	 * @return toInvAmt2
	 */
	public String getToInvAmt2() {
		return this.toInvAmt2;
	}
	
	/**
	 * Column Info
	 * @return toCurrCd
	 */
	public String getToCurrCd() {
		return this.toCurrCd;
	}
	
	/**
	 * Column Info
	 * @return toCurrCd2
	 */
	public String getToCurrCd2() {
		return this.toCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return tiCurrCd2
	 */
	public String getTiCurrCd2() {
		return this.tiCurrCd2;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return tiInvAmt2
	 */
	public String getTiInvAmt2() {
		return this.tiInvAmt2;
	}
	
	/**
	 * Column Info
	 * @return toInvAmt
	 */
	public String getToInvAmt() {
		return this.toInvAmt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param tiCurrCd
	 */
	public void setTiCurrCd(String tiCurrCd) {
		this.tiCurrCd = tiCurrCd;
	}
	
	/**
	 * Column Info
	 * @param tiInvAmt
	 */
	public void setTiInvAmt(String tiInvAmt) {
		this.tiInvAmt = tiInvAmt;
	}
	
	/**
	 * Column Info
	 * @param toInvAmt2
	 */
	public void setToInvAmt2(String toInvAmt2) {
		this.toInvAmt2 = toInvAmt2;
	}
	
	/**
	 * Column Info
	 * @param toCurrCd
	 */
	public void setToCurrCd(String toCurrCd) {
		this.toCurrCd = toCurrCd;
	}
	
	/**
	 * Column Info
	 * @param toCurrCd2
	 */
	public void setToCurrCd2(String toCurrCd2) {
		this.toCurrCd2 = toCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param tiCurrCd2
	 */
	public void setTiCurrCd2(String tiCurrCd2) {
		this.tiCurrCd2 = tiCurrCd2;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param tiInvAmt2
	 */
	public void setTiInvAmt2(String tiInvAmt2) {
		this.tiInvAmt2 = tiInvAmt2;
	}
	
	/**
	 * Column Info
	 * @param toInvAmt
	 */
	public void setToInvAmt(String toInvAmt) {
		this.toInvAmt = toInvAmt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTiCurrCd(JSPUtil.getParameter(request, "ti_curr_cd", ""));
		setTiInvAmt(JSPUtil.getParameter(request, "ti_inv_amt", ""));
		setToInvAmt2(JSPUtil.getParameter(request, "to_inv_amt2", ""));
		setToCurrCd(JSPUtil.getParameter(request, "to_curr_cd", ""));
		setToCurrCd2(JSPUtil.getParameter(request, "to_curr_cd2", ""));
		setTiCurrCd2(JSPUtil.getParameter(request, "ti_curr_cd2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setTiInvAmt2(JSPUtil.getParameter(request, "ti_inv_amt2", ""));
		setToInvAmt(JSPUtil.getParameter(request, "to_inv_amt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCapitalBudgetListVO[]
	 */
	public SearchCapitalBudgetListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCapitalBudgetListVO[]
	 */
	public SearchCapitalBudgetListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCapitalBudgetListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tiCurrCd = (JSPUtil.getParameter(request, prefix	+ "ti_curr_cd", length));
			String[] tiInvAmt = (JSPUtil.getParameter(request, prefix	+ "ti_inv_amt", length));
			String[] toInvAmt2 = (JSPUtil.getParameter(request, prefix	+ "to_inv_amt2", length));
			String[] toCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_curr_cd", length));
			String[] toCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "to_curr_cd2", length));
			String[] tiCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "ti_curr_cd2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] tiInvAmt2 = (JSPUtil.getParameter(request, prefix	+ "ti_inv_amt2", length));
			String[] toInvAmt = (JSPUtil.getParameter(request, prefix	+ "to_inv_amt", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCapitalBudgetListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tiCurrCd[i] != null)
					model.setTiCurrCd(tiCurrCd[i]);
				if (tiInvAmt[i] != null)
					model.setTiInvAmt(tiInvAmt[i]);
				if (toInvAmt2[i] != null)
					model.setToInvAmt2(toInvAmt2[i]);
				if (toCurrCd[i] != null)
					model.setToCurrCd(toCurrCd[i]);
				if (toCurrCd2[i] != null)
					model.setToCurrCd2(toCurrCd2[i]);
				if (tiCurrCd2[i] != null)
					model.setTiCurrCd2(tiCurrCd2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (tiInvAmt2[i] != null)
					model.setTiInvAmt2(tiInvAmt2[i]);
				if (toInvAmt[i] != null)
					model.setToInvAmt(toInvAmt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCapitalBudgetListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCapitalBudgetListVO[]
	 */
	public SearchCapitalBudgetListVO[] getSearchCapitalBudgetListVOs(){
		SearchCapitalBudgetListVO[] vos = (SearchCapitalBudgetListVO[])models.toArray(new SearchCapitalBudgetListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tiCurrCd = this.tiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tiInvAmt = this.tiInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvAmt2 = this.toInvAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrCd = this.toCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrCd2 = this.toCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tiCurrCd2 = this.tiCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tiInvAmt2 = this.tiInvAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvAmt = this.toInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
