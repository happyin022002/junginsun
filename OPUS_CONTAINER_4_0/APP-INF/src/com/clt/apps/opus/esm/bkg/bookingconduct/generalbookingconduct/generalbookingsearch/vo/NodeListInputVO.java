/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NodeListInputVO.java
*@FileTitle : NodeListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.20 KimByungKyu
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author KimByungKyu
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class NodeListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<NodeListInputVO> models = new ArrayList<NodeListInputVO>();

	/* Column Info */
	private String marineTerminal = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String yzFlag = null;
	/* Column Info */
	private String countryCd = null;
	/* Column Info */
	private String postalCd = null;
	/* Column Info */
	private String locCd2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public NodeListInputVO() {}

	public NodeListInputVO(String ibflag, String pagerows, String countryCd, String postalCd, String locCd, String locCd2, String eqCtrlOfcCd, String yzFlag, String marineTerminal) {
		this.marineTerminal = marineTerminal;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.yzFlag = yzFlag;
		this.countryCd = countryCd;
		this.postalCd = postalCd;
		this.locCd2 = locCd2;
		this.pagerows = pagerows;
	}

	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("marine_terminal", getMarineTerminal());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("yz_flag", getYzFlag());
		this.hashColumns.put("country_cd", getCountryCd());
		this.hashColumns.put("postal_cd", getPostalCd());
		this.hashColumns.put("loc_cd2", getLocCd2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("marine_terminal", "marineTerminal");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("yz_flag", "yzFlag");
		this.hashFields.put("country_cd", "countryCd");
		this.hashFields.put("postal_cd", "postalCd");
		this.hashFields.put("loc_cd2", "locCd2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return marineTerminal
	 */
	public String getMarineTerminal() {
		return this.marineTerminal;
	}

	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @return yzFlag
	 */
	public String getYzFlag() {
		return this.yzFlag;
	}

	/**
	 * Column Info
	 * @return countryCd
	 */
	public String getCountryCd() {
		return this.countryCd;
	}

	/**
	 * Column Info
	 * @return postalCd
	 */
	public String getPostalCd() {
		return this.postalCd;
	}

	/**
	 * Column Info
	 * @return locCd2
	 */
	public String getLocCd2() {
		return this.locCd2;
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
	 * @param marineTerminal
	 */
	public void setMarineTerminal(String marineTerminal) {
		this.marineTerminal = marineTerminal;
	}

	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @param yzFlag
	 */
	public void setYzFlag(String yzFlag) {
		this.yzFlag = yzFlag;
	}

	/**
	 * Column Info
	 * @param countryCd
	 */
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	/**
	 * Column Info
	 * @param postalCd
	 */
	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}

	/**
	 * Column Info
	 * @param locCd2
	 */
	public void setLocCd2(String locCd2) {
		this.locCd2 = locCd2;
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
		setMarineTerminal(JSPUtil.getParameter(request, "marine_terminal", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setYzFlag(JSPUtil.getParameter(request, "yz_flag", ""));
		setCountryCd(JSPUtil.getParameter(request, "country_cd", ""));
		setPostalCd(JSPUtil.getParameter(request, "postal_cd", ""));
		setLocCd2(JSPUtil.getParameter(request, "loc_cd2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return NodeListInputVO[]
	 */
	public NodeListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return NodeListInputVO[]
	 */
	public NodeListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NodeListInputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] marineTerminal = (JSPUtil.getParameter(request, prefix	+ "marine_terminal".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd".trim(), length));
			String[] yzFlag = (JSPUtil.getParameter(request, prefix	+ "yz_flag".trim(), length));
			String[] countryCd = (JSPUtil.getParameter(request, prefix	+ "country_cd".trim(), length));
			String[] postalCd = (JSPUtil.getParameter(request, prefix	+ "postal_cd".trim(), length));
			String[] locCd2 = (JSPUtil.getParameter(request, prefix	+ "loc_cd2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new NodeListInputVO();
				if (marineTerminal[i] != null)
					model.setMarineTerminal(marineTerminal[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (yzFlag[i] != null)
					model.setYzFlag(yzFlag[i]);
				if (countryCd[i] != null)
					model.setCountryCd(countryCd[i]);
				if (postalCd[i] != null)
					model.setPostalCd(postalCd[i]);
				if (locCd2[i] != null)
					model.setLocCd2(locCd2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNodeListInputVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다
	 * @return NodeListInputVO[]
	 */
	public NodeListInputVO[] getNodeListInputVOs(){
		NodeListInputVO[] vos = (NodeListInputVO[])models.toArray(new NodeListInputVO[models.size()]);
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
		this.marineTerminal = this.marineTerminal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yzFlag = this.yzFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCd = this.countryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postalCd = this.postalCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd2 = this.locCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
