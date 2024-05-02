/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchOfficeVendorVO.java
*@FileTitle : searchOfficeVendorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.29 김진일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 김진일
 * @since J2EE 1.5
 */

public class SearchOfficeVendorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeVendorVO> models = new ArrayList<SearchOfficeVendorVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tcnt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOfficeVendorVO() {}

	public SearchOfficeVendorVO(String ibflag, String pagerows, String tcnt, String vndrSeq, String vndrLglEngNm) {
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.tcnt = tcnt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tcnt", getTcnt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tcnt", "tcnt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	public String getTcnt() {
		return this.tcnt;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
		//this.vndrSeq=true;
	}
	public void setTcnt(String tcnt) {
		this.tcnt = tcnt;
		//this.tcnt=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setTcnt(JSPUtil.getParameter(request, "tcnt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchOfficeVendorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOfficeVendorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeVendorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] tcnt = (JSPUtil.getParameter(request, prefix	+ "tcnt".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeVendorVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tcnt[i] != null)
					model.setTcnt(tcnt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) { return null; }
		return getsearchOfficeVendorVOs();
	}

	public SearchOfficeVendorVO[] getsearchOfficeVendorVOs(){
		SearchOfficeVendorVO[] vos = (SearchOfficeVendorVO[])models.toArray(new SearchOfficeVendorVO[models.size()]);
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
		} catch (Exception ex) { return null; }
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
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcnt = this.tcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
