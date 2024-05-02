/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeMgtVO.java
*@FileTitle : OfficeMgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.11 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeMgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeMgtVO> models = new ArrayList<OfficeMgtVO>();
	
	/* Column Info */
	private String schLvl1 = null;
	/* Column Info */
	private String schSumupOffice = null;
	/* Column Info */
	private String schComDiv = null;
	/* Column Info */
	private String schOfficeGbn = null;
	/* Column Info */
	private String schHohqGbn = null;
	/* Column Info */
	private String schOfficeCode = null;
	/* Column Info */
	private String strAppDivSql = null;
	/* Column Info */
	private String hdnOfcCd = null;
	/* Column Info */
	private String schLvl3 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String schLvl2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String schOfficeLvl = null;
	/* Column Info */
	private String schDeltFlg = null;
	/* Column Info */
	private String schLang = null;
	/* Column Info */
	private String schAppDivGbn = null;
	/* Column Info */
	private String schGenExpnCd = null;
	/* Column Info */
	private String hdnSlsOfcFlg = null;
	/* Column Info */
	private String schExpnGroup = null;
	/* Column Info */
	private String hdnGenExpnCd = null;
	/* Column Info */
	private String schSumupGbn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeMgtVO() {}

	public OfficeMgtVO(String ibflag, String pagerows, String schHohqGbn, String schLvl1, String schLvl2, String schLvl3, String schOfficeGbn, String schOfficeCode, String schOfficeLvl, String schComDiv, String schAppDivGbn, String schSumupGbn, String schSumupOffice, String schDeltFlg, String strAppDivSql, String schExpnGroup, String schGenExpnCd, String schLang, String hdnOfcCd, String hdnGenExpnCd, String hdnSlsOfcFlg) {
		this.schLvl1 = schLvl1;
		this.schSumupOffice = schSumupOffice;
		this.schComDiv = schComDiv;
		this.schOfficeGbn = schOfficeGbn;
		this.schHohqGbn = schHohqGbn;
		this.schOfficeCode = schOfficeCode;
		this.strAppDivSql = strAppDivSql;
		this.hdnOfcCd = hdnOfcCd;
		this.schLvl3 = schLvl3;
		this.pagerows = pagerows;
		this.schLvl2 = schLvl2;
		this.ibflag = ibflag;
		this.schOfficeLvl = schOfficeLvl;
		this.schDeltFlg = schDeltFlg;
		this.schLang = schLang;
		this.schAppDivGbn = schAppDivGbn;
		this.schGenExpnCd = schGenExpnCd;
		this.hdnSlsOfcFlg = hdnSlsOfcFlg;
		this.schExpnGroup = schExpnGroup;
		this.hdnGenExpnCd = hdnGenExpnCd;
		this.schSumupGbn = schSumupGbn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sch_lvl1", getSchLvl1());
		this.hashColumns.put("sch_sumup_office", getSchSumupOffice());
		this.hashColumns.put("sch_com_div", getSchComDiv());
		this.hashColumns.put("sch_office_gbn", getSchOfficeGbn());
		this.hashColumns.put("sch_hohq_gbn", getSchHohqGbn());
		this.hashColumns.put("sch_office_code", getSchOfficeCode());
		this.hashColumns.put("str_app_div_sql", getStrAppDivSql());
		this.hashColumns.put("hdn_ofc_cd", getHdnOfcCd());
		this.hashColumns.put("sch_lvl3", getSchLvl3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sch_lvl2", getSchLvl2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_office_lvl", getSchOfficeLvl());
		this.hashColumns.put("sch_delt_flg", getSchDeltFlg());
		this.hashColumns.put("sch_lang", getSchLang());
		this.hashColumns.put("sch_app_div_gbn", getSchAppDivGbn());
		this.hashColumns.put("sch_gen_expn_cd", getSchGenExpnCd());
		this.hashColumns.put("hdn_sls_ofc_flg", getHdnSlsOfcFlg());
		this.hashColumns.put("sch_expn_group", getSchExpnGroup());
		this.hashColumns.put("hdn_gen_expn_cd", getHdnGenExpnCd());
		this.hashColumns.put("sch_sumup_gbn", getSchSumupGbn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sch_lvl1", "schLvl1");
		this.hashFields.put("sch_sumup_office", "schSumupOffice");
		this.hashFields.put("sch_com_div", "schComDiv");
		this.hashFields.put("sch_office_gbn", "schOfficeGbn");
		this.hashFields.put("sch_hohq_gbn", "schHohqGbn");
		this.hashFields.put("sch_office_code", "schOfficeCode");
		this.hashFields.put("str_app_div_sql", "strAppDivSql");
		this.hashFields.put("hdn_ofc_cd", "hdnOfcCd");
		this.hashFields.put("sch_lvl3", "schLvl3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sch_lvl2", "schLvl2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_office_lvl", "schOfficeLvl");
		this.hashFields.put("sch_delt_flg", "schDeltFlg");
		this.hashFields.put("sch_lang", "schLang");
		this.hashFields.put("sch_app_div_gbn", "schAppDivGbn");
		this.hashFields.put("sch_gen_expn_cd", "schGenExpnCd");
		this.hashFields.put("hdn_sls_ofc_flg", "hdnSlsOfcFlg");
		this.hashFields.put("sch_expn_group", "schExpnGroup");
		this.hashFields.put("hdn_gen_expn_cd", "hdnGenExpnCd");
		this.hashFields.put("sch_sumup_gbn", "schSumupGbn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return schLvl1
	 */
	public String getSchLvl1() {
		return this.schLvl1;
	}
	
	/**
	 * Column Info
	 * @return schSumupOffice
	 */
	public String getSchSumupOffice() {
		return this.schSumupOffice;
	}
	
	/**
	 * Column Info
	 * @return schComDiv
	 */
	public String getSchComDiv() {
		return this.schComDiv;
	}
	
	/**
	 * Column Info
	 * @return schOfficeGbn
	 */
	public String getSchOfficeGbn() {
		return this.schOfficeGbn;
	}
	
	/**
	 * Column Info
	 * @return schHohqGbn
	 */
	public String getSchHohqGbn() {
		return this.schHohqGbn;
	}
	
	/**
	 * Column Info
	 * @return schOfficeCode
	 */
	public String getSchOfficeCode() {
		return this.schOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return strAppDivSql
	 */
	public String getStrAppDivSql() {
		return this.strAppDivSql;
	}
	
	/**
	 * Column Info
	 * @return hdnOfcCd
	 */
	public String getHdnOfcCd() {
		return this.hdnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return schLvl3
	 */
	public String getSchLvl3() {
		return this.schLvl3;
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
	 * @return schLvl2
	 */
	public String getSchLvl2() {
		return this.schLvl2;
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
	 * @return schOfficeLvl
	 */
	public String getSchOfficeLvl() {
		return this.schOfficeLvl;
	}
	
	/**
	 * Column Info
	 * @return schDeltFlg
	 */
	public String getSchDeltFlg() {
		return this.schDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return schLang
	 */
	public String getSchLang() {
		return this.schLang;
	}
	
	/**
	 * Column Info
	 * @return schAppDivGbn
	 */
	public String getSchAppDivGbn() {
		return this.schAppDivGbn;
	}
	
	/**
	 * Column Info
	 * @return schGenExpnCd
	 */
	public String getSchGenExpnCd() {
		return this.schGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return hdnSlsOfcFlg
	 */
	public String getHdnSlsOfcFlg() {
		return this.hdnSlsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return schExpnGroup
	 */
	public String getSchExpnGroup() {
		return this.schExpnGroup;
	}
	
	/**
	 * Column Info
	 * @return hdnGenExpnCd
	 */
	public String getHdnGenExpnCd() {
		return this.hdnGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return schSumupGbn
	 */
	public String getSchSumupGbn() {
		return this.schSumupGbn;
	}
	

	/**
	 * Column Info
	 * @param schLvl1
	 */
	public void setSchLvl1(String schLvl1) {
		this.schLvl1 = schLvl1;
	}
	
	/**
	 * Column Info
	 * @param schSumupOffice
	 */
	public void setSchSumupOffice(String schSumupOffice) {
		this.schSumupOffice = schSumupOffice;
	}
	
	/**
	 * Column Info
	 * @param schComDiv
	 */
	public void setSchComDiv(String schComDiv) {
		this.schComDiv = schComDiv;
	}
	
	/**
	 * Column Info
	 * @param schOfficeGbn
	 */
	public void setSchOfficeGbn(String schOfficeGbn) {
		this.schOfficeGbn = schOfficeGbn;
	}
	
	/**
	 * Column Info
	 * @param schHohqGbn
	 */
	public void setSchHohqGbn(String schHohqGbn) {
		this.schHohqGbn = schHohqGbn;
	}
	
	/**
	 * Column Info
	 * @param schOfficeCode
	 */
	public void setSchOfficeCode(String schOfficeCode) {
		this.schOfficeCode = schOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param strAppDivSql
	 */
	public void setStrAppDivSql(String strAppDivSql) {
		this.strAppDivSql = strAppDivSql;
	}
	
	/**
	 * Column Info
	 * @param hdnOfcCd
	 */
	public void setHdnOfcCd(String hdnOfcCd) {
		this.hdnOfcCd = hdnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param schLvl3
	 */
	public void setSchLvl3(String schLvl3) {
		this.schLvl3 = schLvl3;
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
	 * @param schLvl2
	 */
	public void setSchLvl2(String schLvl2) {
		this.schLvl2 = schLvl2;
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
	 * @param schOfficeLvl
	 */
	public void setSchOfficeLvl(String schOfficeLvl) {
		this.schOfficeLvl = schOfficeLvl;
	}
	
	/**
	 * Column Info
	 * @param schDeltFlg
	 */
	public void setSchDeltFlg(String schDeltFlg) {
		this.schDeltFlg = schDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param schLang
	 */
	public void setSchLang(String schLang) {
		this.schLang = schLang;
	}
	
	/**
	 * Column Info
	 * @param schAppDivGbn
	 */
	public void setSchAppDivGbn(String schAppDivGbn) {
		this.schAppDivGbn = schAppDivGbn;
	}
	
	/**
	 * Column Info
	 * @param schGenExpnCd
	 */
	public void setSchGenExpnCd(String schGenExpnCd) {
		this.schGenExpnCd = schGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param hdnSlsOfcFlg
	 */
	public void setHdnSlsOfcFlg(String hdnSlsOfcFlg) {
		this.hdnSlsOfcFlg = hdnSlsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param schExpnGroup
	 */
	public void setSchExpnGroup(String schExpnGroup) {
		this.schExpnGroup = schExpnGroup;
	}
	
	/**
	 * Column Info
	 * @param hdnGenExpnCd
	 */
	public void setHdnGenExpnCd(String hdnGenExpnCd) {
		this.hdnGenExpnCd = hdnGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param schSumupGbn
	 */
	public void setSchSumupGbn(String schSumupGbn) {
		this.schSumupGbn = schSumupGbn;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSchLvl1(JSPUtil.getParameter(request, "sch_lvl1", ""));
		setSchSumupOffice(JSPUtil.getParameter(request, "sch_sumup_office", ""));
		setSchComDiv(JSPUtil.getParameter(request, "sch_com_div", ""));
		setSchOfficeGbn(JSPUtil.getParameter(request, "sch_office_gbn", ""));
		setSchHohqGbn(JSPUtil.getParameter(request, "sch_hohq_gbn", ""));
		setSchOfficeCode(JSPUtil.getParameter(request, "sch_office_code", ""));
		setStrAppDivSql(JSPUtil.getParameter(request, "str_app_div_sql", ""));
		setHdnOfcCd(JSPUtil.getParameter(request, "hdn_ofc_cd", ""));
		setSchLvl3(JSPUtil.getParameter(request, "sch_lvl3", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSchLvl2(JSPUtil.getParameter(request, "sch_lvl2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSchOfficeLvl(JSPUtil.getParameter(request, "sch_office_lvl", ""));
		setSchDeltFlg(JSPUtil.getParameter(request, "sch_delt_flg", ""));
		setSchLang(JSPUtil.getParameter(request, "sch_lang", ""));
		setSchAppDivGbn(JSPUtil.getParameter(request, "sch_app_div_gbn", ""));
		setSchGenExpnCd(JSPUtil.getParameter(request, "sch_gen_expn_cd", ""));
		setHdnSlsOfcFlg(JSPUtil.getParameter(request, "hdn_sls_ofc_flg", ""));
		setSchExpnGroup(JSPUtil.getParameter(request, "sch_expn_group", ""));
		setHdnGenExpnCd(JSPUtil.getParameter(request, "hdn_gen_expn_cd", ""));
		setSchSumupGbn(JSPUtil.getParameter(request, "sch_sumup_gbn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeMgtVO[]
	 */
	public OfficeMgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeMgtVO[]
	 */
	public OfficeMgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeMgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] schLvl1 = (JSPUtil.getParameter(request, prefix	+ "sch_lvl1", length));
			String[] schSumupOffice = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_office", length));
			String[] schComDiv = (JSPUtil.getParameter(request, prefix	+ "sch_com_div", length));
			String[] schOfficeGbn = (JSPUtil.getParameter(request, prefix	+ "sch_office_gbn", length));
			String[] schHohqGbn = (JSPUtil.getParameter(request, prefix	+ "sch_hohq_gbn", length));
			String[] schOfficeCode = (JSPUtil.getParameter(request, prefix	+ "sch_office_code", length));
			String[] strAppDivSql = (JSPUtil.getParameter(request, prefix	+ "str_app_div_sql", length));
			String[] hdnOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdn_ofc_cd", length));
			String[] schLvl3 = (JSPUtil.getParameter(request, prefix	+ "sch_lvl3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] schLvl2 = (JSPUtil.getParameter(request, prefix	+ "sch_lvl2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] schOfficeLvl = (JSPUtil.getParameter(request, prefix	+ "sch_office_lvl", length));
			String[] schDeltFlg = (JSPUtil.getParameter(request, prefix	+ "sch_delt_flg", length));
			String[] schLang = (JSPUtil.getParameter(request, prefix	+ "sch_lang", length));
			String[] schAppDivGbn = (JSPUtil.getParameter(request, prefix	+ "sch_app_div_gbn", length));
			String[] schGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "sch_gen_expn_cd", length));
			String[] hdnSlsOfcFlg = (JSPUtil.getParameter(request, prefix	+ "hdn_sls_ofc_flg", length));
			String[] schExpnGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expn_group", length));
			String[] hdnGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "hdn_gen_expn_cd", length));
			String[] schSumupGbn = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_gbn", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeMgtVO();
				if (schLvl1[i] != null)
					model.setSchLvl1(schLvl1[i]);
				if (schSumupOffice[i] != null)
					model.setSchSumupOffice(schSumupOffice[i]);
				if (schComDiv[i] != null)
					model.setSchComDiv(schComDiv[i]);
				if (schOfficeGbn[i] != null)
					model.setSchOfficeGbn(schOfficeGbn[i]);
				if (schHohqGbn[i] != null)
					model.setSchHohqGbn(schHohqGbn[i]);
				if (schOfficeCode[i] != null)
					model.setSchOfficeCode(schOfficeCode[i]);
				if (strAppDivSql[i] != null)
					model.setStrAppDivSql(strAppDivSql[i]);
				if (hdnOfcCd[i] != null)
					model.setHdnOfcCd(hdnOfcCd[i]);
				if (schLvl3[i] != null)
					model.setSchLvl3(schLvl3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (schLvl2[i] != null)
					model.setSchLvl2(schLvl2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (schOfficeLvl[i] != null)
					model.setSchOfficeLvl(schOfficeLvl[i]);
				if (schDeltFlg[i] != null)
					model.setSchDeltFlg(schDeltFlg[i]);
				if (schLang[i] != null)
					model.setSchLang(schLang[i]);
				if (schAppDivGbn[i] != null)
					model.setSchAppDivGbn(schAppDivGbn[i]);
				if (schGenExpnCd[i] != null)
					model.setSchGenExpnCd(schGenExpnCd[i]);
				if (hdnSlsOfcFlg[i] != null)
					model.setHdnSlsOfcFlg(hdnSlsOfcFlg[i]);
				if (schExpnGroup[i] != null)
					model.setSchExpnGroup(schExpnGroup[i]);
				if (hdnGenExpnCd[i] != null)
					model.setHdnGenExpnCd(hdnGenExpnCd[i]);
				if (schSumupGbn[i] != null)
					model.setSchSumupGbn(schSumupGbn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeMgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeMgtVO[]
	 */
	public OfficeMgtVO[] getOfficeMgtVOs(){
		OfficeMgtVO[] vos = (OfficeMgtVO[])models.toArray(new OfficeMgtVO[models.size()]);
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
		this.schLvl1 = this.schLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupOffice = this.schSumupOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schComDiv = this.schComDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeGbn = this.schOfficeGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schHohqGbn = this.schHohqGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeCode = this.schOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strAppDivSql = this.strAppDivSql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnOfcCd = this.hdnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLvl3 = this.schLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLvl2 = this.schLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeLvl = this.schOfficeLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDeltFlg = this.schDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLang = this.schLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schAppDivGbn = this.schAppDivGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schGenExpnCd = this.schGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnSlsOfcFlg = this.hdnSlsOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpnGroup = this.schExpnGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnGenExpnCd = this.hdnGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupGbn = this.schSumupGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
