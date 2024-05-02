/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCLMListOptionsVO.java
*@FileTitle : SearchCLMListOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.07 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCLMListOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCLMListOptionsVO> models = new ArrayList<SearchCLMListOptionsVO>();
	
	/* Column Info */
	private String arrDt2 = null;
	/* Column Info */
	private String arrDt1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String rowSize = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCLMListOptionsVO() {}

	public SearchCLMListOptionsVO(String ibflag, String pagerows, String cntrNo, String arrDt1, String arrDt2, String rowSize, String iPage) {
		this.arrDt2 = arrDt2;
		this.arrDt1 = arrDt1;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.iPage = iPage;
		this.rowSize = rowSize;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("arr_dt2", getArrDt2());
		this.hashColumns.put("arr_dt1", getArrDt1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("row_size", getRowSize());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("arr_dt2", "arrDt2");
		this.hashFields.put("arr_dt1", "arrDt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("row_size", "rowSize");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return arrDt2
	 */
	public String getArrDt2() {
		return this.arrDt2;
	}
	
	/**
	 * Column Info
	 * @return arrDt1
	 */
	public String getArrDt1() {
		return this.arrDt1;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return rowSize
	 */
	public String getRowSize() {
		return this.rowSize;
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
	 * @param arrDt2
	 */
	public void setArrDt2(String arrDt2) {
		this.arrDt2 = arrDt2;
	}
	
	/**
	 * Column Info
	 * @param arrDt1
	 */
	public void setArrDt1(String arrDt1) {
		this.arrDt1 = arrDt1;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param rowSize
	 */
	public void setRowSize(String rowSize) {
		this.rowSize = rowSize;
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
		setArrDt2(JSPUtil.getParameter(request, "arr_dt2", ""));
		setArrDt1(JSPUtil.getParameter(request, "arr_dt1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setIPage(JSPUtil.getParameter(request, "i_page", ""));
		setRowSize(JSPUtil.getParameter(request, "row_size", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCLMListOptionsVO[]
	 */
	public SearchCLMListOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCLMListOptionsVO[]
	 */
	public SearchCLMListOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCLMListOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] arrDt2 = (JSPUtil.getParameter(request, prefix	+ "arr_dt2", length));
			String[] arrDt1 = (JSPUtil.getParameter(request, prefix	+ "arr_dt1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] rowSize = (JSPUtil.getParameter(request, prefix	+ "row_size", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCLMListOptionsVO();
				if (arrDt2[i] != null)
					model.setArrDt2(arrDt2[i]);
				if (arrDt1[i] != null)
					model.setArrDt1(arrDt1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (rowSize[i] != null)
					model.setRowSize(rowSize[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCLMListOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCLMListOptionsVO[]
	 */
	public SearchCLMListOptionsVO[] getSearchCLMListOptionsVOs(){
		SearchCLMListOptionsVO[] vos = (SearchCLMListOptionsVO[])models.toArray(new SearchCLMListOptionsVO[models.size()]);
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
		this.arrDt2 = this.arrDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt1 = this.arrDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSize = this.rowSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
