/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtTariffTypeVO.java
*@FileTitle : DmtTariffTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo;

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
 * @author 황효근
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class DmtTrfTpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtTrfTpVO> models = new ArrayList<DmtTrfTpVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String dmdtCalcTpCd = null;
	/* Column Info */
	private String dmdtTrfDivCd = null;
	/* Column Info */
	private String dmdtTrfNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtTrfTpVO() {}

	public DmtTrfTpVO(String ibflag, String pagerows, String dmdtTrfCd, String dmdtTrfNm, String ioBndCd, String dmdtCalcTpCd, String dmdtTrfDivCd) {
		this.ibflag = ibflag;
		this.dmdtCalcTpCd = dmdtCalcTpCd;
		this.dmdtTrfDivCd = dmdtTrfDivCd;
		this.dmdtTrfNm = dmdtTrfNm;
		this.ioBndCd = ioBndCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_calc_tp_cd", getDmdtCalcTpCd());
		this.hashColumns.put("dmdt_trf_div_cd", getDmdtTrfDivCd());
		this.hashColumns.put("dmdt_trf_nm", getDmdtTrfNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_calc_tp_cd", "dmdtCalcTpCd");
		this.hashFields.put("dmdt_trf_div_cd", "dmdtTrfDivCd");
		this.hashFields.put("dmdt_trf_nm", "dmdtTrfNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return dmdtCalcTpCd
	 */
	public String getDmdtCalcTpCd() {
		return this.dmdtCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfDivCd
	 */
	public String getDmdtTrfDivCd() {
		return this.dmdtTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfNm
	 */
	public String getDmdtTrfNm() {
		return this.dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param dmdtCalcTpCd
	 */
	public void setDmdtCalcTpCd(String dmdtCalcTpCd) {
		this.dmdtCalcTpCd = dmdtCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfDivCd
	 */
	public void setDmdtTrfDivCd(String dmdtTrfDivCd) {
		this.dmdtTrfDivCd = dmdtTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfNm
	 */
	public void setDmdtTrfNm(String dmdtTrfNm) {
		this.dmdtTrfNm = dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtCalcTpCd(JSPUtil.getParameter(request, "dmdt_calc_tp_cd", ""));
		setDmdtTrfDivCd(JSPUtil.getParameter(request, "dmdt_trf_div_cd", ""));
		setDmdtTrfNm(JSPUtil.getParameter(request, "dmdt_trf_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return DmtTariffTypeVO[]
	 */
	public DmtTrfTpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtTariffTypeVO[]
	 */
	public DmtTrfTpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtTrfTpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] dmdtCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_calc_tp_cd".trim(), length));
			String[] dmdtTrfDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_div_cd".trim(), length));
			String[] dmdtTrfNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_nm".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtTrfTpVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtCalcTpCd[i] != null)
					model.setDmdtCalcTpCd(dmdtCalcTpCd[i]);
				if (dmdtTrfDivCd[i] != null)
					model.setDmdtTrfDivCd(dmdtTrfDivCd[i]);
				if (dmdtTrfNm[i] != null)
					model.setDmdtTrfNm(dmdtTrfNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtTariffTypeVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return DmtTariffTypeVO[]
	 */
	public DmtTrfTpVO[] getDmtTariffTypeVOs(){
		DmtTrfTpVO[] vos = (DmtTrfTpVO[])models.toArray(new DmtTrfTpVO[models.size()]);
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
		this.dmdtCalcTpCd = this.dmdtCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfDivCd = this.dmdtTrfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfNm = this.dmdtTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
