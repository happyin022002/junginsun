/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaModelLogListVO.java
*@FileTitle : SearchMonthlyQuotaModelLogListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2009.08.25 김종호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaModelLogListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaModelLogListVO> models = new ArrayList<SearchMonthlyQuotaModelLogListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sysDate = null;
	/* Column Info */
	private String execDt = null;
	/* Column Info */
	private String modName = null;
	/* Column Info */
	private String logDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaModelLogListVO() {}

	public SearchMonthlyQuotaModelLogListVO(String ibflag, String pagerows, String sysDate, String execDt, String modName, String logDesc) {
		this.ibflag = ibflag;
		this.sysDate = sysDate;
		this.execDt = execDt;
		this.modName = modName;
		this.logDesc = logDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sys_date", getSysDate());
		this.hashColumns.put("exec_dt", getExecDt());
		this.hashColumns.put("mod_name", getModName());
		this.hashColumns.put("log_desc", getLogDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sys_date", "sysDate");
		this.hashFields.put("exec_dt", "execDt");
		this.hashFields.put("mod_name", "modName");
		this.hashFields.put("log_desc", "logDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return sysDate
	 */
	public String getSysDate() {
		return this.sysDate;
	}
	
	/**
	 * Column Info
	 * @return execDt
	 */
	public String getExecDt() {
		return this.execDt;
	}
	
	/**
	 * Column Info
	 * @return modName
	 */
	public String getModName() {
		return this.modName;
	}
	
	/**
	 * Column Info
	 * @return logDesc
	 */
	public String getLogDesc() {
		return this.logDesc;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sysDate
	 */
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}
	
	/**
	 * Column Info
	 * @param execDt
	 */
	public void setExecDt(String execDt) {
		this.execDt = execDt;
	}
	
	/**
	 * Column Info
	 * @param modName
	 */
	public void setModName(String modName) {
		this.modName = modName;
	}
	
	/**
	 * Column Info
	 * @param logDesc
	 */
	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSysDate(JSPUtil.getParameter(request, "sys_date", ""));
		setExecDt(JSPUtil.getParameter(request, "exec_dt", ""));
		setModName(JSPUtil.getParameter(request, "mod_name", ""));
		setLogDesc(JSPUtil.getParameter(request, "log_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaModelLogListVO[]
	 */
	public SearchMonthlyQuotaModelLogListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaModelLogListVO[]
	 */
	public SearchMonthlyQuotaModelLogListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaModelLogListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sysDate = (JSPUtil.getParameter(request, prefix	+ "sys_date", length));
			String[] execDt = (JSPUtil.getParameter(request, prefix	+ "exec_dt", length));
			String[] modName = (JSPUtil.getParameter(request, prefix	+ "mod_name", length));
			String[] logDesc = (JSPUtil.getParameter(request, prefix	+ "log_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaModelLogListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sysDate[i] != null)
					model.setSysDate(sysDate[i]);
				if (execDt[i] != null)
					model.setExecDt(execDt[i]);
				if (modName[i] != null)
					model.setModName(modName[i]);
				if (logDesc[i] != null)
					model.setLogDesc(logDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaModelLogListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaModelLogListVO[]
	 */
	public SearchMonthlyQuotaModelLogListVO[] getSearchMonthlyQuotaModelLogListVOs(){
		SearchMonthlyQuotaModelLogListVO[] vos = (SearchMonthlyQuotaModelLogListVO[])models.toArray(new SearchMonthlyQuotaModelLogListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDate = this.sysDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.execDt = this.execDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modName = this.modName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDesc = this.logDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
