/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSoCodeCoditionVO.java
*@FileTitle : SearchSoCodeCoditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박상희
*@LastVersion : 1.0
* 2009.08.11 박상희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSoCodeCoditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSoCodeCoditionVO> models = new ArrayList<SearchSoCodeCoditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fStndCostCd = null;
	/* Column Info */
	private String fSgrpCostCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSoCodeCoditionVO() {}

	public SearchSoCodeCoditionVO(String ibflag, String pagerows, String fSgrpCostCd, String fStndCostCd) {
		this.ibflag = ibflag;
		this.fStndCostCd = fStndCostCd;
		this.fSgrpCostCd = fSgrpCostCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_stnd_cost_cd", getFStndCostCd());
		this.hashColumns.put("f_sgrp_cost_cd", getFSgrpCostCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_stnd_cost_cd", "fStndCostCd");
		this.hashFields.put("f_sgrp_cost_cd", "fSgrpCostCd");
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
	 * @return fStndCostCd
	 */
	public String getFStndCostCd() {
		return this.fStndCostCd;
	}
	
	/**
	 * Column Info
	 * @return fSgrpCostCd
	 */
	public String getFSgrpCostCd() {
		return this.fSgrpCostCd;
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
	 * @param fStndCostCd
	 */
	public void setFStndCostCd(String fStndCostCd) {
		this.fStndCostCd = fStndCostCd;
	}
	
	/**
	 * Column Info
	 * @param fSgrpCostCd
	 */
	public void setFSgrpCostCd(String fSgrpCostCd) {
		this.fSgrpCostCd = fSgrpCostCd;
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
		setFStndCostCd(JSPUtil.getParameter(request, "f_stnd_cost_cd", ""));
		setFSgrpCostCd(JSPUtil.getParameter(request, "f_sgrp_cost_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSoCodeCoditionVO[]
	 */
	public SearchSoCodeCoditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSoCodeCoditionVO[]
	 */
	public SearchSoCodeCoditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSoCodeCoditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fStndCostCd = (JSPUtil.getParameter(request, prefix	+ "f_stnd_cost_cd", length));
			String[] fSgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "f_sgrp_cost_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSoCodeCoditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fStndCostCd[i] != null)
					model.setFStndCostCd(fStndCostCd[i]);
				if (fSgrpCostCd[i] != null)
					model.setFSgrpCostCd(fSgrpCostCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSoCodeCoditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSoCodeCoditionVO[]
	 */
	public SearchSoCodeCoditionVO[] getSearchSoCodeCoditionVOs(){
		SearchSoCodeCoditionVO[] vos = (SearchSoCodeCoditionVO[])models.toArray(new SearchSoCodeCoditionVO[models.size()]);
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
		this.fStndCostCd = this.fStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSgrpCostCd = this.fSgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
