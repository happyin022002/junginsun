/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : checkYardVO.java
*@FileTitle : checkYardVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.19 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김상수
 * @since J2EE 1.5
 * @see AbstractValueObject
 */
public class CheckYardVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CheckYardVO> models = new ArrayList<CheckYardVO>();

	/* Column Info */
	private String ydM = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String ydS = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	public CheckYardVO() {}

	/*	테이블 컬럼에 멤버변수 대입 */
	public CheckYardVO(String ibflag, String pagerows, String ydS, String ydM, String ydNm, String pYard1) {
		this.ydM = ydM;
		this.ibflag = ibflag;
		this.ydNm = ydNm;
		this.pYard1 = pYard1;
		this.ydS = ydS;
		this.pagerows = pagerows;
	}

	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yd_m", getYdM());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("yd_s", getYdS());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yd_m", "ydM");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("yd_s", "ydS");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ydM
	 */
	public String getYdM() {
		return this.ydM;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}

	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}

	/**
	 * Column Info
	 * @return ydS
	 */
	public String getYdS() {
		return this.ydS;
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
	 * @param ydM
	 */
	public void setYdM(String ydM) {
		this.ydM = ydM;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}

	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}

	/**
	 * Column Info
	 * @param ydS
	 */
	public void setYdS(String ydS) {
		this.ydS = ydS;
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
		setYdM(JSPUtil.getParameter(request, "yd_m", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
		setYdS(JSPUtil.getParameter(request, "yd_s", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return checkYardVO[]
	 */
	public CheckYardVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return checkYardVO[]
	 */
	public CheckYardVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CheckYardVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ydM = (JSPUtil.getParameter(request, prefix	+ "yd_m".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm".trim(), length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1".trim(), length));
			String[] ydS = (JSPUtil.getParameter(request, prefix	+ "yd_s".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new CheckYardVO();
				if (ydM[i] != null)
					model.setYdM(ydM[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (ydS[i] != null)
					model.setYdS(ydS[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getcheckYardVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다
	 * @return checkYardVO[]
	 */
	public CheckYardVO[] getcheckYardVOs(){
		CheckYardVO[] vos = (CheckYardVO[])models.toArray(new CheckYardVO[models.size()]);
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
		this.ydM = this.ydM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydS = this.ydS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
