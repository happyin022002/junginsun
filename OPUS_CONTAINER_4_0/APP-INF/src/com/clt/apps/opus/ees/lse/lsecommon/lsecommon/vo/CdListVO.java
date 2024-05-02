/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CdListVO.java
*@FileTitle : CdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 이상민
*@LastVersion : 1.0
* 2011.03.08 이상민
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

public class CdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CdListVO> models = new ArrayList<CdListVO>();
	
	/* Code Info */
	private String edmCd = null;
	
	/* Column Info */
	private String cd = null;
	
	/* Column Info */
	private String nm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CdListVO() {}

	public CdListVO(String edmCd, String cd, String nm) {
		this.edmCd = edmCd;
		this.cd = cd;
		this.nm = nm;
	}
	
	public String getEdmCd() {
		return this.edmCd;
	}
	
	public void setEdmCd(String edmCd) {
		this.edmCd = edmCd;
	}

	public String getCd() {
		return this.cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getNm() {
		return this.nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}
	


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edm_cd", getEdmCd());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("nm", getNm());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_coNm", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edm_cd", "edmCd");
		this.hashFields.put("cd", "cd");
		this.hashFields.put("nm", "nm");
		return this.hashFields;
	}
	

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEdmCd(JSPUtil.getParameter(request, "edm_cd", ""));
		setCd(JSPUtil.getParameter(request, "cd", ""));
		setNm(JSPUtil.getParameter(request, "nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InventoryDetailVO[]
	 */
	public CdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InventoryDetailVO[]
	 */
	public CdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CdListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] edmCd = (JSPUtil.getParameter(request, prefix	+ "edm_cd", length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));

			for (int i = 0; i < length; i++) {
				model = new CdListVO();
				if (edmCd[i] != null)
					model.setEdmCd(edmCd[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return getCdListVO[]
	 */
	public CdListVO[] getCdListVOs(){
		CdListVO[] vos = (CdListVO[])models.toArray(new CdListVO[models.size()]);
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.edmCd = this.edmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
}
