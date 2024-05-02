/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseInquiryVO.java
*@FileTitle : ExpenseInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.05.07 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최정미
 * @since J2EE 1.5
 */

public class ExpenseInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExpenseInquiryVO> models = new ArrayList<ExpenseInquiryVO>();
	
	/* Column Info */
	private String lvl1Name = null;
	/* Column Info */
	private String lvl2Code = null;
	/* Column Info */
	private String acctCode = null;
	/* Column Info */
	private String salyFlg = null;
	/* Column Info */
	private String lvl1Code = null;
	/* Column Info */
	private String lvl2Name = null;
	/* Column Info */
	private String lvl3Name = null;
	/* Column Info */
	private String lvl4Tic = null;
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String lvl4Code = null;
	/* Column Info */
	private String lvl4Name = null;
	/* Column Info */
	private String slsDiv = null;
	/* Column Info */
	private String acctDesc = null;
	/* Column Info */
	private String acctName = null;
	/* Column Info */
	private String lvl3Code = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExpenseInquiryVO() {}

	public ExpenseInquiryVO(String ibflag, String pagerows, String lvl1Code, String lvl1Name, String lvl2Code, String lvl2Name, String lvl3Code, String lvl3Name, String lvl4Code, String lvl4Name, String lvl4Tic, String acctCode, String acctName, String acctDesc, String salyFlg, String slsDiv) {
		this.lvl1Name = lvl1Name;
		this.lvl2Code = lvl2Code;
		this.acctCode = acctCode;
		this.salyFlg = salyFlg;
		this.lvl1Code = lvl1Code;
		this.lvl2Name = lvl2Name;
		this.lvl3Name = lvl3Name;
		this.lvl4Tic = lvl4Tic;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lvl4Code = lvl4Code;
		this.lvl4Name = lvl4Name;
		this.slsDiv = slsDiv;
		this.acctDesc = acctDesc;
		this.acctName = acctName;
		this.lvl3Code = lvl3Code;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lvl1_name", getLvl1Name());
		this.hashColumns.put("lvl2_code", getLvl2Code());
		this.hashColumns.put("acct_code", getAcctCode());
		this.hashColumns.put("saly_flg", getSalyFlg());
		this.hashColumns.put("lvl1_code", getLvl1Code());
		this.hashColumns.put("lvl2_name", getLvl2Name());
		this.hashColumns.put("lvl3_name", getLvl3Name());
		this.hashColumns.put("lvl4_tic", getLvl4Tic());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lvl4_code", getLvl4Code());
		this.hashColumns.put("lvl4_name", getLvl4Name());
		this.hashColumns.put("sls_div", getSlsDiv());
		this.hashColumns.put("acct_desc", getAcctDesc());
		this.hashColumns.put("acct_name", getAcctName());
		this.hashColumns.put("lvl3_code", getLvl3Code());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lvl1_name", "lvl1Name");
		this.hashFields.put("lvl2_code", "lvl2Code");
		this.hashFields.put("acct_code", "acctCode");
		this.hashFields.put("saly_flg", "salyFlg");
		this.hashFields.put("lvl1_code", "lvl1Code");
		this.hashFields.put("lvl2_name", "lvl2Name");
		this.hashFields.put("lvl3_name", "lvl3Name");
		this.hashFields.put("lvl4_tic", "lvl4Tic");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lvl4_code", "lvl4Code");
		this.hashFields.put("lvl4_name", "lvl4Name");
		this.hashFields.put("sls_div", "slsDiv");
		this.hashFields.put("acct_desc", "acctDesc");
		this.hashFields.put("acct_name", "acctName");
		this.hashFields.put("lvl3_code", "lvl3Code");
		return this.hashFields;
	}
	
	public String getLvl1Name() {
		return this.lvl1Name;
	}
	public String getLvl2Code() {
		return this.lvl2Code;
	}
	public String getAcctCode() {
		return this.acctCode;
	}
	public String getSalyFlg() {
		return this.salyFlg;
	}
	public String getLvl1Code() {
		return this.lvl1Code;
	}
	public String getLvl2Name() {
		return this.lvl2Name;
	}
	public String getLvl3Name() {
		return this.lvl3Name;
	}
	public String getLvl4Tic() {
		return this.lvl4Tic;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getLvl4Code() {
		return this.lvl4Code;
	}
	public String getLvl4Name() {
		return this.lvl4Name;
	}
	public String getSlsDiv() {
		return this.slsDiv;
	}
	public String getAcctDesc() {
		return this.acctDesc;
	}
	public String getAcctName() {
		return this.acctName;
	}
	public String getLvl3Code() {
		return this.lvl3Code;
	}

	public void setLvl1Name(String lvl1Name) {
		this.lvl1Name = lvl1Name;
		//this.lvl1Name=true;
	}
	public void setLvl2Code(String lvl2Code) {
		this.lvl2Code = lvl2Code;
		//this.lvl2Code=true;
	}
	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
		//this.acctCode=true;
	}
	public void setSalyFlg(String salyFlg) {
		this.salyFlg = salyFlg;
		//this.salyFlg=true;
	}
	public void setLvl1Code(String lvl1Code) {
		this.lvl1Code = lvl1Code;
		//this.lvl1Code=true;
	}
	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
		//this.lvl2Name=true;
	}
	public void setLvl3Name(String lvl3Name) {
		this.lvl3Name = lvl3Name;
		//this.lvl3Name=true;
	}
	public void setLvl4Tic(String lvl4Tic) {
		this.lvl4Tic = lvl4Tic;
		//this.lvl4Tic=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setLvl4Code(String lvl4Code) {
		this.lvl4Code = lvl4Code;
		//this.lvl4Code=true;
	}
	public void setLvl4Name(String lvl4Name) {
		this.lvl4Name = lvl4Name;
		//this.lvl4Name=true;
	}
	public void setSlsDiv(String slsDiv) {
		this.slsDiv = slsDiv;
		//this.slsDiv=true;
	}
	public void setAcctDesc(String acctDesc) {
		this.acctDesc = acctDesc;
		//this.acctDesc=true;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
		//this.acctName=true;
	}
	public void setLvl3Code(String lvl3Code) {
		this.lvl3Code = lvl3Code;
		//this.lvl3Code=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setLvl1Name(JSPUtil.getParameter(request, "lvl1_name", ""));
		setLvl2Code(JSPUtil.getParameter(request, "lvl2_code", ""));
		setAcctCode(JSPUtil.getParameter(request, "acct_code", ""));
		setSalyFlg(JSPUtil.getParameter(request, "saly_flg", ""));
		setLvl1Code(JSPUtil.getParameter(request, "lvl1_code", ""));
		setLvl2Name(JSPUtil.getParameter(request, "lvl2_name", ""));
		setLvl3Name(JSPUtil.getParameter(request, "lvl3_name", ""));
		setLvl4Tic(JSPUtil.getParameter(request, "lvl4_tic", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLvl4Code(JSPUtil.getParameter(request, "lvl4_code", ""));
		setLvl4Name(JSPUtil.getParameter(request, "lvl4_name", ""));
		setSlsDiv(JSPUtil.getParameter(request, "sls_div", ""));
		setAcctDesc(JSPUtil.getParameter(request, "acct_desc", ""));
		setAcctName(JSPUtil.getParameter(request, "acct_name", ""));
		setLvl3Code(JSPUtil.getParameter(request, "lvl3_code", ""));
	}

	public ExpenseInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ExpenseInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpenseInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lvl1Name = (JSPUtil.getParameter(request, prefix	+ "lvl1_name".trim(), length));
			String[] lvl2Code = (JSPUtil.getParameter(request, prefix	+ "lvl2_code".trim(), length));
			String[] acctCode = (JSPUtil.getParameter(request, prefix	+ "acct_code".trim(), length));
			String[] salyFlg = (JSPUtil.getParameter(request, prefix	+ "saly_flg".trim(), length));
			String[] lvl1Code = (JSPUtil.getParameter(request, prefix	+ "lvl1_code".trim(), length));
			String[] lvl2Name = (JSPUtil.getParameter(request, prefix	+ "lvl2_name".trim(), length));
			String[] lvl3Name = (JSPUtil.getParameter(request, prefix	+ "lvl3_name".trim(), length));
			String[] lvl4Tic = (JSPUtil.getParameter(request, prefix	+ "lvl4_tic".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] lvl4Code = (JSPUtil.getParameter(request, prefix	+ "lvl4_code".trim(), length));
			String[] lvl4Name = (JSPUtil.getParameter(request, prefix	+ "lvl4_name".trim(), length));
			String[] slsDiv = (JSPUtil.getParameter(request, prefix	+ "sls_div".trim(), length));
			String[] acctDesc = (JSPUtil.getParameter(request, prefix	+ "acct_desc".trim(), length));
			String[] acctName = (JSPUtil.getParameter(request, prefix	+ "acct_name".trim(), length));
			String[] lvl3Code = (JSPUtil.getParameter(request, prefix	+ "lvl3_code".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpenseInquiryVO();
				if (lvl1Name[i] != null)
					model.setLvl1Name(lvl1Name[i]);
				if (lvl2Code[i] != null)
					model.setLvl2Code(lvl2Code[i]);
				if (acctCode[i] != null)
					model.setAcctCode(acctCode[i]);
				if (salyFlg[i] != null)
					model.setSalyFlg(salyFlg[i]);
				if (lvl1Code[i] != null)
					model.setLvl1Code(lvl1Code[i]);
				if (lvl2Name[i] != null)
					model.setLvl2Name(lvl2Name[i]);
				if (lvl3Name[i] != null)
					model.setLvl3Name(lvl3Name[i]);
				if (lvl4Tic[i] != null)
					model.setLvl4Tic(lvl4Tic[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lvl4Code[i] != null)
					model.setLvl4Code(lvl4Code[i]);
				if (lvl4Name[i] != null)
					model.setLvl4Name(lvl4Name[i]);
				if (slsDiv[i] != null)
					model.setSlsDiv(slsDiv[i]);
				if (acctDesc[i] != null)
					model.setAcctDesc(acctDesc[i]);
				if (acctName[i] != null)
					model.setAcctName(acctName[i]);
				if (lvl3Code[i] != null)
					model.setLvl3Code(lvl3Code[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getExpenseInquiryVOs();
	}

	public ExpenseInquiryVO[] getExpenseInquiryVOs(){
		ExpenseInquiryVO[] vos = (ExpenseInquiryVO[])models.toArray(new ExpenseInquiryVO[models.size()]);
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
		this.lvl1Name = this.lvl1Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl2Code = this.lvl2Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCode = this.acctCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salyFlg = this.salyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl1Code = this.lvl1Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl2Name = this.lvl2Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl3Name = this.lvl3Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4Tic = this.lvl4Tic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4Code = this.lvl4Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl4Name = this.lvl4Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsDiv = this.slsDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDesc = this.acctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctName = this.acctName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl3Code = this.lvl3Code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
