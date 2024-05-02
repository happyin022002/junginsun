/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEqOrgYardListVO.java
*@FileTitle : SearchEqOrgYardListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.28 김석준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;
import org.apache.log4j.Logger;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김석준
 * @since J2EE 1.5
 * @see
 */

public class EqOrgYardVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger("org.apache.log4j.Logger");
	
	private Collection<EqOrgYardVO> models = new ArrayList<EqOrgYardVO>();
	
	/* Column Info */
	private String sccCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqOrgYardVO() {}

	/**
	 * SearchEqOrgYardListVO
	 * @param ibflag
	 * @param pagerows
	 * @param ydCd
	 * @param sccCd
	 */
	public EqOrgYardVO(String ibflag, String pagerows, String ydCd, String sccCd) {
		this.sccCd = sccCd;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getSccCd() {
		return this.sccCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getYdCd() {
		return this.ydCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
		//this.sccCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
		//this.ydCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * fromRequest
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * fromRequestGrid
	 * @param request
	 * @return
	 */
	public EqOrgYardVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * fromRequestGrid
	 * @param request
	 * @param prefix
	 * @return
	 */
	public EqOrgYardVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqOrgYardVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new EqOrgYardVO();
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception ex) {log.error("err " + ex.toString(), ex);}
		return getSearchEqOrgYardListVOs();
	}

	/**
	 * getSearchEqOrgYardListVOs
	 * @return
	 */
	public EqOrgYardVO[] getSearchEqOrgYardListVOs(){
		EqOrgYardVO[] vos = (EqOrgYardVO[])models.toArray(new EqOrgYardVO[models.size()]);
		return vos;
	}
	
	/**
	 * toString
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
		} catch (Exception ex) {log.error("err " + ex.toString(), ex);}
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
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
