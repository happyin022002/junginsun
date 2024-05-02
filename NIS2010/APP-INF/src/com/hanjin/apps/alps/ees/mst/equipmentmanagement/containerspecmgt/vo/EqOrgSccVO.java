/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmEqOrzChtVO.java
*@FileTitle : MdmEqOrzChtVO
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

public class EqOrgSccVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger("org.apache.log4j.Logger");
	
	private Collection<EqOrgSccVO> models = new ArrayList<EqOrgSccVO>();
	
	/* Column Info */
	private String sccNm = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqOrgSccVO() {}

	/**
	 * MdmEqOrzChtVO
	 * @param ibflag
	 * @param pagerows
	 * @param rccCd
	 * @param lccCd
	 * @param eccCd
	 * @param sccCd
	 * @param sccNm
	 */
	public EqOrgSccVO(String ibflag, String pagerows, String rccCd, String lccCd, String eccCd, String sccCd, String sccNm) {
		this.sccNm = sccNm;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
		this.ibflag = ibflag;
		this.eccCd = eccCd;
		this.rccCd = rccCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scc_nm", getSccNm());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scc_nm", "sccNm");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getSccNm() {
		return this.sccNm;
	}
	public String getLccCd() {
		return this.lccCd;
	}
	public String getSccCd() {
		return this.sccCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEccCd() {
		return this.eccCd;
	}
	public String getRccCd() {
		return this.rccCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setSccNm(String sccNm) {
		this.sccNm = sccNm;
		//this.sccNm=true;
	}
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
		//this.lccCd=true;
	}
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
		//this.sccCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
		//this.eccCd=true;
	}
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
		//this.rccCd=true;
	}
	
	/**
	 * setPagerows
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * fromRequest
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSccNm(JSPUtil.getParameter(request, "scc_nm", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * fromRequestGrid
	 * @param request
	 * @return
	 */
	public EqOrgSccVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * fromRequestGrid
	 * @param request
	 * @param prefix
	 * @return
	 */
	public EqOrgSccVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqOrgSccVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sccNm = (JSPUtil.getParameter(request, prefix	+ "scc_nm".trim(), length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd".trim(), length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd".trim(), length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new EqOrgSccVO();
				if (sccNm[i] != null)
					model.setSccNm(sccNm[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception ex) {log.error("err " + ex.toString(), ex);}
		return getMdmEqOrzChtVOs();
	}

	/**
	 * getMdmEqOrzChtVOs
	 * @return
	 */
	public EqOrgSccVO[] getMdmEqOrzChtVOs(){
		EqOrgSccVO[] vos = (EqOrgSccVO[])models.toArray(new EqOrgSccVO[models.size()]);
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
		this.sccNm = this.sccNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
