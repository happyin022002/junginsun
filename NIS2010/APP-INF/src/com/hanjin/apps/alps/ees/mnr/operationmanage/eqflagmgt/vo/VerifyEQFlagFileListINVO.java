/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtINVO.java
*@FileTitle : EQFlagMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.20 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.5
 * @see AbstractValueObject
 */ 

public class VerifyEQFlagFileListINVO extends AbstractValueObject {
    
	private static final long serialVersionUID = 1L;
	 
	private Collection<VerifyEQFlagFileListINVO> models = new ArrayList<VerifyEQFlagFileListINVO>();
	  
	/* Column Info */
	private String dmgFlag = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VerifyEQFlagFileListINVO() {}

	/**
	 * EQFlagMgtINVO 객체를 생성   
	 */
	public VerifyEQFlagFileListINVO(String ibflag, String pagerows, String tmpSeq, String eqType, String dmgFlag) {
		this.dmgFlag = dmgFlag;
		this.ibflag = ibflag;
		this.tmpSeq = tmpSeq;
		this.eqType = eqType;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmg_flag", getDmgFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmgFlag
	 */
	public String getDmgFlag() {
		return this.dmgFlag;
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
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @param dmgFlag
	 */
	public void setDmgFlag(String dmgFlag) {
		this.dmgFlag = dmgFlag;
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
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
		setDmgFlag(JSPUtil.getParameter(request, "dmg_flag", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return EQFlagMgtINVO[]
	 */
	public VerifyEQFlagFileListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EQFlagMgtINVO[]
	 */
	public VerifyEQFlagFileListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VerifyEQFlagFileListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmgFlag = (JSPUtil.getParameter(request, prefix	+ "dmg_flag".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq".trim(), length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VerifyEQFlagFileListINVO();
				if (dmgFlag[i] != null)
					model.setDmgFlag(dmgFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEQFlagMgtINVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return EQFlagMgtINVO[]
	 */
	public VerifyEQFlagFileListINVO[] getEQFlagMgtINVOs(){
		VerifyEQFlagFileListINVO[] vos = (VerifyEQFlagFileListINVO[])models.toArray(new VerifyEQFlagFileListINVO[models.size()]);
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
		this.dmgFlag = this.dmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
