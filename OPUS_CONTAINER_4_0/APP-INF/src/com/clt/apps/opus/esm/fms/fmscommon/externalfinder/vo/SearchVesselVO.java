/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselVO.java
*@FileTitle : SearchVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.06
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.02.06 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

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
 * @author 정윤태
 * @since J2EE 1.5
 * @see  FMSCommonHTMLAction
 */


public class SearchVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselVO> models = new ArrayList<SearchVesselVO>();
	
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String crrCd = null; 
	/* 而щ읆 �ㅻ챸 */
	private String vslEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String fdrDivCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchVesselVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String vslCd, String vslEngNm, String crrCd, String fdrDivCd
	 * @return 
	 */
	public SearchVesselVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String crrCd, String fdrDivCd) {
		this.ibflag = ibflag;
		this.vslCd = vslCd;
		this.crrCd = crrCd;
		this.vslEngNm = vslEngNm;
		this.fdrDivCd = fdrDivCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("fdr_div_cd", getFdrDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("fdr_div_cd", "fdrDivCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getCrrCd() {
		return this.crrCd;
	}
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	public String getFdrDivCd() {
		return this.fdrDivCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
		//this.crrCd=true;
	}
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
		//this.vslEngNm=true;
	}
	public void setFdrDivCd(String fdrDivCd) {
		this.fdrDivCd = fdrDivCd;
		//this.fdrDivCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setFdrDivCd(JSPUtil.getParameter(request, "fdr_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] fdrDivCd = (JSPUtil.getParameter(request, prefix	+ "fdr_div_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (fdrDivCd[i] != null)
					model.setFdrDivCd(fdrDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchVesselVOs();
	}

	public SearchVesselVO[] getSearchVesselVOs(){
		SearchVesselVO[] vos = (SearchVesselVO[])models.toArray(new SearchVesselVO[models.size()]);
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

}
