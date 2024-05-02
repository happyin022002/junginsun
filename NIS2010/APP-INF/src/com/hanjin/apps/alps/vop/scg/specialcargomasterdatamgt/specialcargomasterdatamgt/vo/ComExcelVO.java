/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComExcelVO.java
*@FileTitle : ComExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.19 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComExcelVO> models = new ArrayList<ComExcelVO>();
	
	/* Column Info */
	private String columnwidth = null;
	/* Column Info */
	private String orientation = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String cols = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String align = null;
	/* Column Info */
	private String datarowheight = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComExcelVO() {}

	public ComExcelVO(String ibflag, String pagerows, String cols, String align, String title, String orientation, String columnwidth, String datarowheight) {
		this.columnwidth = columnwidth;
		this.orientation = orientation;
		this.title = title;
		this.cols = cols;
		this.ibflag = ibflag;
		this.align = align;
		this.datarowheight = datarowheight;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("columnwidth", getColumnwidth());
		this.hashColumns.put("orientation", getOrientation());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("cols", getCols());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("align", getAlign());
		this.hashColumns.put("datarowheight", getDatarowheight());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("columnwidth", "columnwidth");
		this.hashFields.put("orientation", "orientation");
		this.hashFields.put("title", "title");
		this.hashFields.put("cols", "cols");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("align", "align");
		this.hashFields.put("datarowheight", "datarowheight");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return columnwidth
	 */
	public String getColumnwidth() {
		return this.columnwidth;
	}
	
	/**
	 * Column Info
	 * @return orientation
	 */
	public String getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return cols
	 */
	public String getCols() {
		return this.cols;
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
	 * @return align
	 */
	public String getAlign() {
		return this.align;
	}
	
	/**
	 * Column Info
	 * @return datarowheight
	 */
	public String getDatarowheight() {
		return this.datarowheight;
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
	 * @param columnwidth
	 */
	public void setColumnwidth(String columnwidth) {
		this.columnwidth = columnwidth;
	}
	
	/**
	 * Column Info
	 * @param orientation
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param cols
	 */
	public void setCols(String cols) {
		this.cols = cols;
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
	 * @param align
	 */
	public void setAlign(String align) {
		this.align = align;
	}
	
	/**
	 * Column Info
	 * @param datarowheight
	 */
	public void setDatarowheight(String datarowheight) {
		this.datarowheight = datarowheight;
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
		setColumnwidth(JSPUtil.getParameter(request, "columnwidth", ""));
		setOrientation(JSPUtil.getParameter(request, "orientation", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setCols(JSPUtil.getParameter(request, "cols", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAlign(JSPUtil.getParameter(request, "align", ""));
		setDatarowheight(JSPUtil.getParameter(request, "datarowheight", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComExcelVO[]
	 */
	public ComExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComExcelVO[]
	 */
	public ComExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] columnwidth = (JSPUtil.getParameter(request, prefix	+ "columnwidth", length));
			String[] orientation = (JSPUtil.getParameter(request, prefix	+ "orientation", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] cols = (JSPUtil.getParameter(request, prefix	+ "cols", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] align = (JSPUtil.getParameter(request, prefix	+ "align", length));
			String[] datarowheight = (JSPUtil.getParameter(request, prefix	+ "datarowheight", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComExcelVO();
				if (columnwidth[i] != null)
					model.setColumnwidth(columnwidth[i]);
				if (orientation[i] != null)
					model.setOrientation(orientation[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (cols[i] != null)
					model.setCols(cols[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (align[i] != null)
					model.setAlign(align[i]);
				if (datarowheight[i] != null)
					model.setDatarowheight(datarowheight[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComExcelVO[]
	 */
	public ComExcelVO[] getComExcelVOs(){
		ComExcelVO[] vos = (ComExcelVO[])models.toArray(new ComExcelVO[models.size()]);
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
		this.columnwidth = this.columnwidth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orientation = this.orientation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cols = this.cols .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.align = this.align .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datarowheight = this.datarowheight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
