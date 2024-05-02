/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseInqVO.java
*@FileTitle : ExpenseInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.05.07 최정미 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최정미
 * @since J2EE 1.5
 */

public class ExpenseInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExpenseInqVO> models = new ArrayList<ExpenseInqVO>();
	
	/* Column Info */
	private String schSlsDiv = null;
	/* Column Info */
	private String schExpenseTo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String schSlayFlg = null;
	/* Column Info */
	private String schLang = null;
	/* Column Info */
	private String schTicCd = null;
	/* Column Info */
	private String schExpenseGbn = null;
	/* Column Info */
	private String schExpenseGroup = null;
	/* Column Info */
	private String schExpenseDiv = null;
	/* Column Info */
	private String schExpenseFrom = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExpenseInqVO() {}

	public ExpenseInqVO(String ibflag, String pagerows, String schExpenseGbn, String schExpenseFrom, String schExpenseTo, String schExpenseDiv, String schLang, String schExpenseGroup, String schTicCd, String schSlayFlg, String schSlsDiv) {
		this.schSlsDiv = schSlsDiv;
		this.schExpenseTo = schExpenseTo;
		this.ibflag = ibflag;
		this.schSlayFlg = schSlayFlg;
		this.schLang = schLang;
		this.schTicCd = schTicCd;
		this.schExpenseGbn = schExpenseGbn;
		this.schExpenseGroup = schExpenseGroup;
		this.schExpenseDiv = schExpenseDiv;
		this.schExpenseFrom = schExpenseFrom;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sch_sls_div", getSchSlsDiv());
		this.hashColumns.put("sch_expense_to", getSchExpenseTo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_slay_flg", getSchSlayFlg());
		this.hashColumns.put("sch_lang", getSchLang());
		this.hashColumns.put("sch_tic_cd", getSchTicCd());
		this.hashColumns.put("sch_expense_gbn", getSchExpenseGbn());
		this.hashColumns.put("sch_expense_group", getSchExpenseGroup());
		this.hashColumns.put("sch_expense_div", getSchExpenseDiv());
		this.hashColumns.put("sch_expense_from", getSchExpenseFrom());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sch_sls_div", "schSlsDiv");
		this.hashFields.put("sch_expense_to", "schExpenseTo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_slay_flg", "schSlayFlg");
		this.hashFields.put("sch_lang", "schLang");
		this.hashFields.put("sch_tic_cd", "schTicCd");
		this.hashFields.put("sch_expense_gbn", "schExpenseGbn");
		this.hashFields.put("sch_expense_group", "schExpenseGroup");
		this.hashFields.put("sch_expense_div", "schExpenseDiv");
		this.hashFields.put("sch_expense_from", "schExpenseFrom");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getSchSlsDiv() {
		return this.schSlsDiv;
	}
	public String getSchExpenseTo() {
		return this.schExpenseTo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getSchSlayFlg() {
		return this.schSlayFlg;
	}
	public String getSchLang() {
		return this.schLang;
	}
	public String getSchTicCd() {
		return this.schTicCd;
	}
	public String getSchExpenseGbn() {
		return this.schExpenseGbn;
	}
	public String getSchExpenseGroup() {
		return this.schExpenseGroup;
	}
	public String getSchExpenseDiv() {
		return this.schExpenseDiv;
	}
	public String getSchExpenseFrom() {
		return this.schExpenseFrom;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setSchSlsDiv(String schSlsDiv) {
		this.schSlsDiv = schSlsDiv;
		//this.schSlsDiv=true;
	}
	public void setSchExpenseTo(String schExpenseTo) {
		this.schExpenseTo = schExpenseTo;
		//this.schExpenseTo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setSchSlayFlg(String schSlayFlg) {
		this.schSlayFlg = schSlayFlg;
		//this.schSlayFlg=true;
	}
	public void setSchLang(String schLang) {
		this.schLang = schLang;
		//this.schLang=true;
	}
	public void setSchTicCd(String schTicCd) {
		this.schTicCd = schTicCd;
		//this.schTicCd=true;
	}
	public void setSchExpenseGbn(String schExpenseGbn) {
		this.schExpenseGbn = schExpenseGbn;
		//this.schExpenseGbn=true;
	}
	public void setSchExpenseGroup(String schExpenseGroup) {
		this.schExpenseGroup = schExpenseGroup;
		//this.schExpenseGroup=true;
	}
	public void setSchExpenseDiv(String schExpenseDiv) {
		this.schExpenseDiv = schExpenseDiv;
		//this.schExpenseDiv=true;
	}
	public void setSchExpenseFrom(String schExpenseFrom) {
		this.schExpenseFrom = schExpenseFrom;
		//this.schExpenseFrom=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setSchSlsDiv(JSPUtil.getParameter(request, "sch_sls_div", ""));
		setSchExpenseTo(JSPUtil.getParameter(request, "sch_expense_to", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSchSlayFlg(JSPUtil.getParameter(request, "sch_slay_flg", ""));
		setSchLang(JSPUtil.getParameter(request, "sch_lang", ""));
		setSchTicCd(JSPUtil.getParameter(request, "sch_tic_cd", ""));
		setSchExpenseGbn(JSPUtil.getParameter(request, "sch_expense_gbn", ""));
		setSchExpenseGroup(JSPUtil.getParameter(request, "sch_expense_group", ""));
		setSchExpenseDiv(JSPUtil.getParameter(request, "sch_expense_div", ""));
		setSchExpenseFrom(JSPUtil.getParameter(request, "sch_expense_from", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public ExpenseInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ExpenseInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpenseInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] schSlsDiv = (JSPUtil.getParameter(request, prefix	+ "sch_sls_div".trim(), length));
			String[] schExpenseTo = (JSPUtil.getParameter(request, prefix	+ "sch_expense_to".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] schSlayFlg = (JSPUtil.getParameter(request, prefix	+ "sch_slay_flg".trim(), length));
			String[] schLang = (JSPUtil.getParameter(request, prefix	+ "sch_lang".trim(), length));
			String[] schTicCd = (JSPUtil.getParameter(request, prefix	+ "sch_tic_cd".trim(), length));
			String[] schExpenseGbn = (JSPUtil.getParameter(request, prefix	+ "sch_expense_gbn".trim(), length));
			String[] schExpenseGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expense_group".trim(), length));
			String[] schExpenseDiv = (JSPUtil.getParameter(request, prefix	+ "sch_expense_div".trim(), length));
			String[] schExpenseFrom = (JSPUtil.getParameter(request, prefix	+ "sch_expense_from".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpenseInqVO();
				if (schSlsDiv[i] != null)
					model.setSchSlsDiv(schSlsDiv[i]);
				if (schExpenseTo[i] != null)
					model.setSchExpenseTo(schExpenseTo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (schSlayFlg[i] != null)
					model.setSchSlayFlg(schSlayFlg[i]);
				if (schLang[i] != null)
					model.setSchLang(schLang[i]);
				if (schTicCd[i] != null)
					model.setSchTicCd(schTicCd[i]);
				if (schExpenseGbn[i] != null)
					model.setSchExpenseGbn(schExpenseGbn[i]);
				if (schExpenseGroup[i] != null)
					model.setSchExpenseGroup(schExpenseGroup[i]);
				if (schExpenseDiv[i] != null)
					model.setSchExpenseDiv(schExpenseDiv[i]);
				if (schExpenseFrom[i] != null)
					model.setSchExpenseFrom(schExpenseFrom[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getExpenseInqVOs();
	}

	public ExpenseInqVO[] getExpenseInqVOs(){
		ExpenseInqVO[] vos = (ExpenseInqVO[])models.toArray(new ExpenseInqVO[models.size()]);
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
		this.schSlsDiv = this.schSlsDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseTo = this.schExpenseTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSlayFlg = this.schSlayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLang = this.schLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTicCd = this.schTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseGbn = this.schExpenseGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseGroup = this.schExpenseGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseDiv = this.schExpenseDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseFrom = this.schExpenseFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
