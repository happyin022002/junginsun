/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriRgGrpCmdtExcelVO.java
*@FileTitle : PriRgGrpCmdtExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.30 공백진 
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
 */

public class PriRgGrpCmdtExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRgGrpCmdtExcelVO> models = new ArrayList<PriRgGrpCmdtExcelVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String prcGrpCmdtDesc = null;
	/* Column Info */
	private String prcGrpCmdtCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriRgGrpCmdtExcelVO() {}

	public PriRgGrpCmdtExcelVO(String ibflag, String pagerows, String prcGrpCmdtCd, String prcGrpCmdtDesc, String prcCmdtDefCd, String cmdtNm) {
		this.ibflag = ibflag;
		this.cmdtNm = cmdtNm;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.prcGrpCmdtDesc = prcGrpCmdtDesc;
		this.prcGrpCmdtCd = prcGrpCmdtCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("prc_grp_cmdt_desc", getPrcGrpCmdtDesc());
		this.hashColumns.put("prc_grp_cmdt_cd", getPrcGrpCmdtCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("prc_grp_cmdt_desc", "prcGrpCmdtDesc");
		this.hashFields.put("prc_grp_cmdt_cd", "prcGrpCmdtCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	public String getPrcGrpCmdtDesc() {
		return this.prcGrpCmdtDesc;
	}
	public String getPrcGrpCmdtCd() {
		return this.prcGrpCmdtCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
		//this.cmdtNm=true;
	}
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
		//this.prcCmdtDefCd=true;
	}
	public void setPrcGrpCmdtDesc(String prcGrpCmdtDesc) {
		this.prcGrpCmdtDesc = prcGrpCmdtDesc;
		//this.prcGrpCmdtDesc=true;
	}
	public void setPrcGrpCmdtCd(String prcGrpCmdtCd) {
		this.prcGrpCmdtCd = prcGrpCmdtCd;
		//this.prcGrpCmdtCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setPrcGrpCmdtDesc(JSPUtil.getParameter(request, "prc_grp_cmdt_desc", ""));
		setPrcGrpCmdtCd(JSPUtil.getParameter(request, "prc_grp_cmdt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public PriRgGrpCmdtExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public PriRgGrpCmdtExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRgGrpCmdtExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm".trim(), length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd".trim(), length));
			String[] prcGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "prc_grp_cmdt_desc".trim(), length));
			String[] prcGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prc_grp_cmdt_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRgGrpCmdtExcelVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (prcGrpCmdtDesc[i] != null)
					model.setPrcGrpCmdtDesc(prcGrpCmdtDesc[i]);
				if (prcGrpCmdtCd[i] != null)
					model.setPrcGrpCmdtCd(prcGrpCmdtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getPriRgGrpCmdtExcelVOs();
	}

	public PriRgGrpCmdtExcelVO[] getPriRgGrpCmdtExcelVOs(){
		PriRgGrpCmdtExcelVO[] vos = (PriRgGrpCmdtExcelVO[])models.toArray(new PriRgGrpCmdtExcelVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpCmdtDesc = this.prcGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpCmdtCd = this.prcGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
