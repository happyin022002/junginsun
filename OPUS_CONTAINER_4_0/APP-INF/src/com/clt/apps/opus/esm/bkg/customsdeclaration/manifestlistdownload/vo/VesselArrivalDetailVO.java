/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselArrivalDetailVO.java
*@FileTitle : VesselArrivalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.06 경종윤
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 경종윤
 * @since J2EE 1.5
 */

public class VesselArrivalDetailVO extends AbstractValueObject   {

	private static final long serialVersionUID = 1L;

	private Collection<VesselArrivalDetailVO> models = new ArrayList<VesselArrivalDetailVO>();

	/* Status */
	private String ibflag = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public VesselArrivalDetailVO() {}

	public VesselArrivalDetailVO(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}

	public String getIbflag() {
		return this.ibflag;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
	}

	public VesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public VesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselArrivalDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new VesselArrivalDetailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getInVesselCondVOVOs();
	}

	public VesselArrivalDetailVO[] getInVesselCondVOVOs(){
		VesselArrivalDetailVO[] vos = (VesselArrivalDetailVO[])models.toArray(new VesselArrivalDetailVO[models.size()]);
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
	}
}
