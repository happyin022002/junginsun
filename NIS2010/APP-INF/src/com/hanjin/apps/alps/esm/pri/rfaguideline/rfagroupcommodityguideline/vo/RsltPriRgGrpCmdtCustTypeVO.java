/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRgGrpCmdtCustTypeVO.java
*@FileTitle : RsltPriRgGrpCmdtCustTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo;

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
 * @author 공백진
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class RsltPriRgGrpCmdtCustTypeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRgGrpCmdtCustTypeVO> models = new ArrayList<RsltPriRgGrpCmdtCustTypeVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String rcnt = null;
	/* Column Info */
	private String cd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nm = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRgGrpCmdtCustTypeVO() {}

	public RsltPriRgGrpCmdtCustTypeVO(String ibflag, String pagerows, String cd, String nm, String rcnt) {
		this.ibflag = ibflag;
		this.rcnt = rcnt;
		this.cd = cd;
		this.pagerows = pagerows;
		this.nm = nm;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcnt", getRcnt());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nm", getNm());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcnt", "rcnt");
		this.hashFields.put("cd", "cd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nm", "nm");
		return this.hashFields;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rcnt
	 */
	public String getRcnt() {
		return this.rcnt;
	}
	
	/**
	 * Column Info
	 * @return cd
	 */
	public String getCd() {
		return this.cd;
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
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	

	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param rcnt
	 */
	public void setRcnt(String rcnt) {
		this.rcnt = rcnt;
	}
	
	/**
	 * Column Info
	 * @param cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
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
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcnt(JSPUtil.getParameter(request, "rcnt", ""));
		setCd(JSPUtil.getParameter(request, "cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNm(JSPUtil.getParameter(request, "nm", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return RsltPriRgGrpCmdtCustTypeVO[]
	 */
	public RsltPriRgGrpCmdtCustTypeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRgGrpCmdtCustTypeVO[]
	 */
	public RsltPriRgGrpCmdtCustTypeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRgGrpCmdtCustTypeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rcnt = (JSPUtil.getParameter(request, prefix	+ "rcnt".trim(), length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRgGrpCmdtCustTypeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcnt[i] != null)
					model.setRcnt(rcnt[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRgGrpCmdtCustTypeVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return RsltPriRgGrpCmdtCustTypeVO[]
	 */
	public RsltPriRgGrpCmdtCustTypeVO[] getRsltPriRgGrpCmdtCustTypeVOs(){
		RsltPriRgGrpCmdtCustTypeVO[] vos = (RsltPriRgGrpCmdtCustTypeVO[])models.toArray(new RsltPriRgGrpCmdtCustTypeVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcnt = this.rcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
