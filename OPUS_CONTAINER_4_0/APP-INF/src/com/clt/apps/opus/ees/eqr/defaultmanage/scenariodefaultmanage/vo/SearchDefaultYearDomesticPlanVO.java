/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDefaultYearDomesticPlanVO.java
*@FileTitle : SearchDefaultYearDomesticPlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.24 채창호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDefaultYearDomesticPlanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDefaultYearDomesticPlanVO> models = new ArrayList<SearchDefaultYearDomesticPlanVO>();
	
	/* Column Info */
	private String s19CntrVolQty = null;
	/* Column Info */
	private String s15CntrVolQty = null;
	/* Column Info */
	private String s110CntrVolQty = null;
	/* Column Info */
	private String s17CntrVolQty = null;
	/* Column Info */
	private String s12CntrVolQty = null;
	/* Column Info */
	private String s111CntrVolQty = null;
	/* Column Info */
	private String s13CntrVolQty = null;
	/* Column Info */
	private String s14CntrVolQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s18CntrVolQty = null;
	/* Column Info */
	private String s16CntrVolQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String s11CntrVolQty = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String s112CntrVolQty = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String qty2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDefaultYearDomesticPlanVO() {}

	public SearchDefaultYearDomesticPlanVO(String ibflag, String pagerows, String s11CntrVolQty, String s12CntrVolQty, String s13CntrVolQty, String qty1, String s14CntrVolQty, String s15CntrVolQty, String s16CntrVolQty, String qty2, String s17CntrVolQty, String s18CntrVolQty, String s19CntrVolQty, String qty3, String s110CntrVolQty, String s111CntrVolQty, String s112CntrVolQty, String flag) {
		this.s19CntrVolQty = s19CntrVolQty;
		this.s15CntrVolQty = s15CntrVolQty;
		this.s110CntrVolQty = s110CntrVolQty;
		this.s17CntrVolQty = s17CntrVolQty;
		this.s12CntrVolQty = s12CntrVolQty;
		this.s111CntrVolQty = s111CntrVolQty;
		this.s13CntrVolQty = s13CntrVolQty;
		this.s14CntrVolQty = s14CntrVolQty;
		this.pagerows = pagerows;
		this.s18CntrVolQty = s18CntrVolQty;
		this.s16CntrVolQty = s16CntrVolQty;
		this.ibflag = ibflag;
		this.flag = flag;
		this.s11CntrVolQty = s11CntrVolQty;
		this.qty1 = qty1;
		this.s112CntrVolQty = s112CntrVolQty;
		this.qty3 = qty3;
		this.qty2 = qty2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s1_9_cntr_vol_qty", getS19CntrVolQty());
		this.hashColumns.put("s1_5_cntr_vol_qty", getS15CntrVolQty());
		this.hashColumns.put("s1_10_cntr_vol_qty", getS110CntrVolQty());
		this.hashColumns.put("s1_7_cntr_vol_qty", getS17CntrVolQty());
		this.hashColumns.put("s1_2_cntr_vol_qty", getS12CntrVolQty());
		this.hashColumns.put("s1_11_cntr_vol_qty", getS111CntrVolQty());
		this.hashColumns.put("s1_3_cntr_vol_qty", getS13CntrVolQty());
		this.hashColumns.put("s1_4_cntr_vol_qty", getS14CntrVolQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s1_8_cntr_vol_qty", getS18CntrVolQty());
		this.hashColumns.put("s1_6_cntr_vol_qty", getS16CntrVolQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("s1_1_cntr_vol_qty", getS11CntrVolQty());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("s1_12_cntr_vol_qty", getS112CntrVolQty());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("qty2", getQty2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s1_9_cntr_vol_qty", "s19CntrVolQty");
		this.hashFields.put("s1_5_cntr_vol_qty", "s15CntrVolQty");
		this.hashFields.put("s1_10_cntr_vol_qty", "s110CntrVolQty");
		this.hashFields.put("s1_7_cntr_vol_qty", "s17CntrVolQty");
		this.hashFields.put("s1_2_cntr_vol_qty", "s12CntrVolQty");
		this.hashFields.put("s1_11_cntr_vol_qty", "s111CntrVolQty");
		this.hashFields.put("s1_3_cntr_vol_qty", "s13CntrVolQty");
		this.hashFields.put("s1_4_cntr_vol_qty", "s14CntrVolQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s1_8_cntr_vol_qty", "s18CntrVolQty");
		this.hashFields.put("s1_6_cntr_vol_qty", "s16CntrVolQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("s1_1_cntr_vol_qty", "s11CntrVolQty");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("s1_12_cntr_vol_qty", "s112CntrVolQty");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("qty2", "qty2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return s19CntrVolQty
	 */
	public String getS19CntrVolQty() {
		return this.s19CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s15CntrVolQty
	 */
	public String getS15CntrVolQty() {
		return this.s15CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s110CntrVolQty
	 */
	public String getS110CntrVolQty() {
		return this.s110CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s17CntrVolQty
	 */
	public String getS17CntrVolQty() {
		return this.s17CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s12CntrVolQty
	 */
	public String getS12CntrVolQty() {
		return this.s12CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s111CntrVolQty
	 */
	public String getS111CntrVolQty() {
		return this.s111CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s13CntrVolQty
	 */
	public String getS13CntrVolQty() {
		return this.s13CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s14CntrVolQty
	 */
	public String getS14CntrVolQty() {
		return this.s14CntrVolQty;
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
	 * @return s18CntrVolQty
	 */
	public String getS18CntrVolQty() {
		return this.s18CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s16CntrVolQty
	 */
	public String getS16CntrVolQty() {
		return this.s16CntrVolQty;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return s11CntrVolQty
	 */
	public String getS11CntrVolQty() {
		return this.s11CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}
	
	/**
	 * Column Info
	 * @return s112CntrVolQty
	 */
	public String getS112CntrVolQty() {
		return this.s112CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return qty2
	 */
	public String getQty2() {
		return this.qty2;
	}
	

	/**
	 * Column Info
	 * @param s19CntrVolQty
	 */
	public void setS19CntrVolQty(String s19CntrVolQty) {
		this.s19CntrVolQty = s19CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s15CntrVolQty
	 */
	public void setS15CntrVolQty(String s15CntrVolQty) {
		this.s15CntrVolQty = s15CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s110CntrVolQty
	 */
	public void setS110CntrVolQty(String s110CntrVolQty) {
		this.s110CntrVolQty = s110CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s17CntrVolQty
	 */
	public void setS17CntrVolQty(String s17CntrVolQty) {
		this.s17CntrVolQty = s17CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s12CntrVolQty
	 */
	public void setS12CntrVolQty(String s12CntrVolQty) {
		this.s12CntrVolQty = s12CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s111CntrVolQty
	 */
	public void setS111CntrVolQty(String s111CntrVolQty) {
		this.s111CntrVolQty = s111CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s13CntrVolQty
	 */
	public void setS13CntrVolQty(String s13CntrVolQty) {
		this.s13CntrVolQty = s13CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s14CntrVolQty
	 */
	public void setS14CntrVolQty(String s14CntrVolQty) {
		this.s14CntrVolQty = s14CntrVolQty;
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
	 * @param s18CntrVolQty
	 */
	public void setS18CntrVolQty(String s18CntrVolQty) {
		this.s18CntrVolQty = s18CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s16CntrVolQty
	 */
	public void setS16CntrVolQty(String s16CntrVolQty) {
		this.s16CntrVolQty = s16CntrVolQty;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param s11CntrVolQty
	 */
	public void setS11CntrVolQty(String s11CntrVolQty) {
		this.s11CntrVolQty = s11CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	
	/**
	 * Column Info
	 * @param s112CntrVolQty
	 */
	public void setS112CntrVolQty(String s112CntrVolQty) {
		this.s112CntrVolQty = s112CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setS19CntrVolQty(JSPUtil.getParameter(request, "s1_9_cntr_vol_qty", ""));
		setS15CntrVolQty(JSPUtil.getParameter(request, "s1_5_cntr_vol_qty", ""));
		setS110CntrVolQty(JSPUtil.getParameter(request, "s1_10_cntr_vol_qty", ""));
		setS17CntrVolQty(JSPUtil.getParameter(request, "s1_7_cntr_vol_qty", ""));
		setS12CntrVolQty(JSPUtil.getParameter(request, "s1_2_cntr_vol_qty", ""));
		setS111CntrVolQty(JSPUtil.getParameter(request, "s1_11_cntr_vol_qty", ""));
		setS13CntrVolQty(JSPUtil.getParameter(request, "s1_3_cntr_vol_qty", ""));
		setS14CntrVolQty(JSPUtil.getParameter(request, "s1_4_cntr_vol_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setS18CntrVolQty(JSPUtil.getParameter(request, "s1_8_cntr_vol_qty", ""));
		setS16CntrVolQty(JSPUtil.getParameter(request, "s1_6_cntr_vol_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setS11CntrVolQty(JSPUtil.getParameter(request, "s1_1_cntr_vol_qty", ""));
		setQty1(JSPUtil.getParameter(request, "qty1", ""));
		setS112CntrVolQty(JSPUtil.getParameter(request, "s1_12_cntr_vol_qty", ""));
		setQty3(JSPUtil.getParameter(request, "qty3", ""));
		setQty2(JSPUtil.getParameter(request, "qty2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDefaultYearDomesticPlanVO[]
	 */
	public SearchDefaultYearDomesticPlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDefaultYearDomesticPlanVO[]
	 */
	public SearchDefaultYearDomesticPlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDefaultYearDomesticPlanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s19CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_9_cntr_vol_qty", length));
			String[] s15CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_5_cntr_vol_qty", length));
			String[] s110CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_10_cntr_vol_qty", length));
			String[] s17CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_7_cntr_vol_qty", length));
			String[] s12CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_2_cntr_vol_qty", length));
			String[] s111CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_11_cntr_vol_qty", length));
			String[] s13CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_3_cntr_vol_qty", length));
			String[] s14CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_4_cntr_vol_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s18CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_8_cntr_vol_qty", length));
			String[] s16CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_6_cntr_vol_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] s11CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_1_cntr_vol_qty", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] s112CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_12_cntr_vol_qty", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDefaultYearDomesticPlanVO();
				if (s19CntrVolQty[i] != null)
					model.setS19CntrVolQty(s19CntrVolQty[i]);
				if (s15CntrVolQty[i] != null)
					model.setS15CntrVolQty(s15CntrVolQty[i]);
				if (s110CntrVolQty[i] != null)
					model.setS110CntrVolQty(s110CntrVolQty[i]);
				if (s17CntrVolQty[i] != null)
					model.setS17CntrVolQty(s17CntrVolQty[i]);
				if (s12CntrVolQty[i] != null)
					model.setS12CntrVolQty(s12CntrVolQty[i]);
				if (s111CntrVolQty[i] != null)
					model.setS111CntrVolQty(s111CntrVolQty[i]);
				if (s13CntrVolQty[i] != null)
					model.setS13CntrVolQty(s13CntrVolQty[i]);
				if (s14CntrVolQty[i] != null)
					model.setS14CntrVolQty(s14CntrVolQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s18CntrVolQty[i] != null)
					model.setS18CntrVolQty(s18CntrVolQty[i]);
				if (s16CntrVolQty[i] != null)
					model.setS16CntrVolQty(s16CntrVolQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (s11CntrVolQty[i] != null)
					model.setS11CntrVolQty(s11CntrVolQty[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (s112CntrVolQty[i] != null)
					model.setS112CntrVolQty(s112CntrVolQty[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDefaultYearDomesticPlanVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDefaultYearDomesticPlanVO[]
	 */
	public SearchDefaultYearDomesticPlanVO[] getSearchDefaultYearDomesticPlanVOs(){
		SearchDefaultYearDomesticPlanVO[] vos = (SearchDefaultYearDomesticPlanVO[])models.toArray(new SearchDefaultYearDomesticPlanVO[models.size()]);
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
		this.s19CntrVolQty = this.s19CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s15CntrVolQty = this.s15CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s110CntrVolQty = this.s110CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s17CntrVolQty = this.s17CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s12CntrVolQty = this.s12CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s111CntrVolQty = this.s111CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s13CntrVolQty = this.s13CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s14CntrVolQty = this.s14CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s18CntrVolQty = this.s18CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s16CntrVolQty = this.s16CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s11CntrVolQty = this.s11CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s112CntrVolQty = this.s112CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
