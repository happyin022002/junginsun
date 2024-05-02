/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocQueueVvdListVO.java
*@FileTitle : DocQueueVvdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.18 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueVvdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueVvdListVO> models = new ArrayList<DocQueueVvdListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etdFromDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String etdToDt = null;
	/* Column Info */
	private String searchGubun = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueVvdListVO() {}

	public DocQueueVvdListVO(String ibflag, String pagerows, String vvdCd, String etdFromDt, String etdToDt, String searchGubun) {
		this.ibflag = ibflag;
		this.etdFromDt = etdFromDt;
		this.vvdCd = vvdCd;
		this.etdToDt = etdToDt;
		this.searchGubun = searchGubun;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etd_from_dt", getEtdFromDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("etd_to_dt", getEtdToDt());
		this.hashColumns.put("search_gubun", getSearchGubun());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etd_from_dt", "etdFromDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("etd_to_dt", "etdToDt");
		this.hashFields.put("search_gubun", "searchGubun");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return etdFromDt
	 */
	public String getEtdFromDt() {
		return this.etdFromDt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return etdToDt
	 */
	public String getEtdToDt() {
		return this.etdToDt;
	}
	
	/**
	 * Column Info
	 * @return searchGubun
	 */
	public String getSearchGubun() {
		return this.searchGubun;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param etdFromDt
	 */
	public void setEtdFromDt(String etdFromDt) {
		this.etdFromDt = etdFromDt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param etdToDt
	 */
	public void setEtdToDt(String etdToDt) {
		this.etdToDt = etdToDt;
	}
	
	/**
	 * Column Info
	 * @param searchGubun
	 */
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtdFromDt(JSPUtil.getParameter(request, "etd_from_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setEtdToDt(JSPUtil.getParameter(request, "etd_to_dt", ""));
		setSearchGubun(JSPUtil.getParameter(request, "search_gubun", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueVvdListVO[]
	 */
	public DocQueueVvdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueVvdListVO[]
	 */
	public DocQueueVvdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueVvdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etdFromDt = (JSPUtil.getParameter(request, prefix	+ "etd_from_dt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] etdToDt = (JSPUtil.getParameter(request, prefix	+ "etd_to_dt", length));
			String[] searchGubun = (JSPUtil.getParameter(request, prefix	+ "search_gubun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueVvdListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etdFromDt[i] != null)
					model.setEtdFromDt(etdFromDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (etdToDt[i] != null)
					model.setEtdToDt(etdToDt[i]);
				if (searchGubun[i] != null)
					model.setSearchGubun(searchGubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueVvdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueVvdListVO[]
	 */
	public DocQueueVvdListVO[] getDocQueueVvdListVOs(){
		DocQueueVvdListVO[] vos = (DocQueueVvdListVO[])models.toArray(new DocQueueVvdListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdFromDt = this.etdFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdToDt = this.etdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchGubun = this.searchGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
