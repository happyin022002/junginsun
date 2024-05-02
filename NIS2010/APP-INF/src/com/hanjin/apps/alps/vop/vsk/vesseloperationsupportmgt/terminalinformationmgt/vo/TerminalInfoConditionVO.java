/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInfoConditionVO.java
*@FileTitle : TerminalInfoConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.29 장석현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo;

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
 * @author 장석현
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class TerminalInfoConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TerminalInfoConditionVO> models = new ArrayList<TerminalInfoConditionVO>();
	
	/* Column Info */
	private String locCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String porRhq = null;
	/* Column Info */
	private String tmpLocCd = null;
	/* Column Info */
	private String tableFlag = null;
	/* Column Info */
	private String fltType = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TerminalInfoConditionVO() {}

	public TerminalInfoConditionVO(String ibflag, String pagerows, String locCd, String porRhq, String tmpLocCd, String fltType, String tableFlag) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.porRhq = porRhq;
		this.tmpLocCd = tmpLocCd;
		this.tableFlag = tableFlag;
		this.fltType = fltType;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("por_rhq", getPorRhq());
		this.hashColumns.put("tmp_loc_cd", getTmpLocCd());
		this.hashColumns.put("table_flag", getTableFlag());
		this.hashColumns.put("flt_type", getFltType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("por_rhq", "porRhq");
		this.hashFields.put("tmp_loc_cd", "tmpLocCd");
		this.hashFields.put("table_flag", "tableFlag");
		this.hashFields.put("flt_type", "fltType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return porRhq
	 */
	public String getPorRhq() {
		return this.porRhq;
	}
	
	/**
	 * Column Info
	 * @return tmpLocCd
	 */
	public String getTmpLocCd() {
		return this.tmpLocCd;
	}
	
	/**
	 * Column Info
	 * @return tableFlag
	 */
	public String getTableFlag() {
		return this.tableFlag;
	}
	
	/**
	 * Column Info
	 * @return fltType
	 */
	public String getFltType() {
		return this.fltType;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param porRhq
	 */
	public void setPorRhq(String porRhq) {
		this.porRhq = porRhq;
	}
	
	/**
	 * Column Info
	 * @param tmpLocCd
	 */
	public void setTmpLocCd(String tmpLocCd) {
		this.tmpLocCd = tmpLocCd;
	}
	
	/**
	 * Column Info
	 * @param tableFlag
	 */
	public void setTableFlag(String tableFlag) {
		this.tableFlag = tableFlag;
	}
	
	/**
	 * Column Info
	 * @param fltType
	 */
	public void setFltType(String fltType) {
		this.fltType = fltType;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPorRhq(JSPUtil.getParameter(request, "por_rhq", ""));
		setTmpLocCd(JSPUtil.getParameter(request, "tmp_loc_cd", ""));
		setTableFlag(JSPUtil.getParameter(request, "table_flag", ""));
		setFltType(JSPUtil.getParameter(request, "flt_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return TerminalInfoConditionVO[]
	 */
	public TerminalInfoConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TerminalInfoConditionVO[]
	 */
	public TerminalInfoConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TerminalInfoConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] porRhq = (JSPUtil.getParameter(request, prefix	+ "por_rhq".trim(), length));
			String[] tmpLocCd = (JSPUtil.getParameter(request, prefix	+ "tmp_loc_cd".trim(), length));
			String[] tableFlag = (JSPUtil.getParameter(request, prefix	+ "table_flag".trim(), length));
			String[] fltType = (JSPUtil.getParameter(request, prefix	+ "flt_type".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TerminalInfoConditionVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porRhq[i] != null)
					model.setPorRhq(porRhq[i]);
				if (tmpLocCd[i] != null)
					model.setTmpLocCd(tmpLocCd[i]);
				if (tableFlag[i] != null)
					model.setTableFlag(tableFlag[i]);
				if (fltType[i] != null)
					model.setFltType(fltType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTerminalInfoConditionVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return TerminalInfoConditionVO[]
	 */
	public TerminalInfoConditionVO[] getTerminalInfoConditionVOs(){
		TerminalInfoConditionVO[] vos = (TerminalInfoConditionVO[])models.toArray(new TerminalInfoConditionVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRhq = this.porRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpLocCd = this.tmpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableFlag = this.tableFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltType = this.fltType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
