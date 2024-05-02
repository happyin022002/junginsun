/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */

public class SearchParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo");
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String expnMonCd = null;		
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTermNm = null;	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public SearchParamVO() {}

	/**
	 * Constructor
	 */
	public SearchParamVO(String ibflag, String pagerows, String plnYr, String verSeq, String expnMonCd, String eqKndCd, String eqTermNm) {
		this.ibflag = ibflag;
		this.plnYr = plnYr;
		this.verSeq = verSeq;
		this.expnMonCd = expnMonCd;
		this.eqKndCd = eqKndCd;
		this.eqTermNm = eqTermNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("expn_mon_cd", getExpnMonCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_term_nm", getEqTermNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("expn_mon_cd", "expnMonCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_term_nm", "eqTermNm");		
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPlnYr() {
		return this.plnYr;
	}
	public String getVerSeq() {
		return this.verSeq;
	}
	public String getExpnMonCd() {
		return this.expnMonCd;
	}
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	public String getEqTermNm() {
		return this.eqTermNm;
	}
	
	public String getPagerows() {
		return this.pagerows;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	public void setExpnMonCd(String expnMonCd) {
		this.expnMonCd = expnMonCd;
	}
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	public void setEqTermNm(String eqTermNm) {
		this.eqTermNm = eqTermNm;
	}	
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}
	public int getIPage() {
		return iPage;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setVerSeq(JSPUtil.getParameter(request, "ver_seq", ""));
		setExpnMonCd(JSPUtil.getParameter(request, "expn_mon_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqTermNm(JSPUtil.getParameter(request, "eq_term_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
				
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq".trim(), length));
			String[] expnMonCd = (JSPUtil.getParameter(request, prefix	+ "expn_mon_cd".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] eqTermNm = (JSPUtil.getParameter(request, prefix	+ "eq_term_nm".trim(), length));			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (expnMonCd[i] != null)
					model.setExpnMonCd(expnMonCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTermNm[i] != null)
					model.setEqTermNm(eqTermNm[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchParamVOs();
	}

	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
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
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
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
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){		
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnMonCd = this.expnMonCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTermNm = this.eqTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}