/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVvdListByCharterVO.java
*@FileTitle : SearchVvdListByCharterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.15 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @see ESM_FMS_0016HTMLAction
 */

public class SearchVvdListByCharterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVvdListByCharterVO> models = new ArrayList<SearchVvdListByCharterVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String vvd = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String revYrmon = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
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
	public SearchVvdListByCharterVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String vvd, String fletCtrtNo, String revYrmon
	 * @return 
	 */
	public SearchVvdListByCharterVO(String ibflag, String pagerows, String vvd, String fletCtrtNo, String revYrmon) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.revYrmon = revYrmon;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getVvd() {
		return this.vvd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getRevYrmon() {
		return this.revYrmon;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
		//this.vvd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
		//this.revYrmon=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchVvdListByCharterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchVvdListByCharterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVvdListByCharterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVvdListByCharterVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchVvdListByCharterVOs();
	}

	public SearchVvdListByCharterVO[] getSearchVvdListByCharterVOs(){
		SearchVvdListByCharterVO[] vos = (SearchVvdListByCharterVO[])models.toArray(new SearchVvdListByCharterVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
