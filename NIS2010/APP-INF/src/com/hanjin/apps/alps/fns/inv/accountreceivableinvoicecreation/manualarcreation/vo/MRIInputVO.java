/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MRIInputVO.java
*@FileTitle : MRIInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.21 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class MRIInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MRIInputVO> models = new ArrayList<MRIInputVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String blno = null;
	/* Column Info */
	private String ofccd = null;
	/* Column Info */
	private String svrid = null;
	/* Column Info */
	private String bnd = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MRIInputVO() {}

	public MRIInputVO(String ibflag, String pagerows, String svrid, String blno, String bkgno, String ofccd, String bnd) {
		this.ibflag = ibflag;
		this.bkgno = bkgno;
		this.blno = blno;
		this.ofccd = ofccd;
		this.svrid = svrid;
		this.bnd = bnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("blno", getBlno());
		this.hashColumns.put("ofccd", getOfccd());
		this.hashColumns.put("svrid", getSvrid());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("blno", "blno");
		this.hashFields.put("ofccd", "ofccd");
		this.hashFields.put("svrid", "svrid");
		this.hashFields.put("bnd", "bnd");
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
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return blno
	 */
	public String getBlno() {
		return this.blno;
	}
	
	/**
	 * Column Info
	 * @return ofccd
	 */
	public String getOfccd() {
		return this.ofccd;
	}
	
	/**
	 * Column Info
	 * @return svrid
	 */
	public String getSvrid() {
		return this.svrid;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
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
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param blno
	 */
	public void setBlno(String blno) {
		this.blno = blno;
	}
	
	/**
	 * Column Info
	 * @param ofccd
	 */
	public void setOfccd(String ofccd) {
		this.ofccd = ofccd;
	}
	
	/**
	 * Column Info
	 * @param svrid
	 */
	public void setSvrid(String svrid) {
		this.svrid = svrid;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
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
		setBkgno(JSPUtil.getParameter(request, "bkg_no", "")+JSPUtil.getParameter(request, "bkg_no_split", ""));
		setBlno(JSPUtil.getParameter(request, "bl_no", ""));
		setOfccd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSvrid(JSPUtil.getParameter(request, "svr_id", ""));
		setBnd(JSPUtil.getParameter(request, "bnd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return MRIInputVO[]
	 */
	public MRIInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MRIInputVO[]
	 */
	public MRIInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MRIInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno".trim(), length));
			String[] blno = (JSPUtil.getParameter(request, prefix	+ "blno".trim(), length));
			String[] ofccd = (JSPUtil.getParameter(request, prefix	+ "ofccd".trim(), length));
			String[] svrid = (JSPUtil.getParameter(request, prefix	+ "svrid".trim(), length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MRIInputVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (blno[i] != null)
					model.setBlno(blno[i]);
				if (ofccd[i] != null)
					model.setOfccd(ofccd[i]);
				if (svrid[i] != null)
					model.setSvrid(svrid[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMRIInputVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return MRIInputVO[]
	 */
	public MRIInputVO[] getMRIInputVOs(){
		MRIInputVO[] vos = (MRIInputVO[])models.toArray(new MRIInputVO[models.size()]);
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
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blno = this.blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofccd = this.ofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrid = this.svrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
