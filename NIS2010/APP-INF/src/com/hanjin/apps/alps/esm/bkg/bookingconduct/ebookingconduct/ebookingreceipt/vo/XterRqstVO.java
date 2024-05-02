/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XterRqstVO.java
*@FileTitle : XterRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.04 전용진
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<XterRqstVO> models = new ArrayList<XterRqstVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String columnType = null;
	/* Column Info */
	private String columnNm = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String inputValue = null;
	/* Column Info */
	private String tableNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public XterRqstVO() {}

	public XterRqstVO(String ibflag, String pagerows, String columnNm, String inputValue, String seq, String tableNm, String columnType) {
		this.ibflag = ibflag;
		this.columnType = columnType;
		this.columnNm = columnNm;
		this.seq = seq;
		this.inputValue = inputValue;
		this.tableNm = tableNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("column_type", getColumnType());
		this.hashColumns.put("column_nm", getColumnNm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("input_value", getInputValue());
		this.hashColumns.put("table_nm", getTableNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("column_type", "columnType");
		this.hashFields.put("column_nm", "columnNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("input_value", "inputValue");
		this.hashFields.put("table_nm", "tableNm");
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
	 * @return columnType
	 */
	public String getColumnType() {
		return this.columnType;
	}

	/**
	 * Column Info
	 * @return columnNm
	 */
	public String getColumnNm() {
		return this.columnNm;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}

	/**
	 * Column Info
	 * @return inputValue
	 */
	public String getInputValue() {
		return this.inputValue;
	}

	/**
	 * Column Info
	 * @return tableNm
	 */
	public String getTableNm() {
		return this.tableNm;
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
	 * @param columnType
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**
	 * Column Info
	 * @param columnNm
	 */
	public void setColumnNm(String columnNm) {
		this.columnNm = columnNm;
	}

	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * Column Info
	 * @param inputValue
	 */
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	/**
	 * Column Info
	 * @param tableNm
	 */
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
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
		setColumnType(JSPUtil.getParameter(request, "column_type", ""));
		setColumnNm(JSPUtil.getParameter(request, "column_nm", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setInputValue(JSPUtil.getParameter(request, "input_value", ""));
		setTableNm(JSPUtil.getParameter(request, "table_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterRqstVO[]
	 */
	public XterRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return XterRqstVO[]
	 */
	public XterRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterRqstVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] columnType = (JSPUtil.getParameter(request, prefix	+ "column_type".trim(), length));
			String[] columnNm = (JSPUtil.getParameter(request, prefix	+ "column_nm".trim(), length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq".trim(), length));
			String[] inputValue = (JSPUtil.getParameter(request, prefix	+ "input_value".trim(), length));
			String[] tableNm = (JSPUtil.getParameter(request, prefix	+ "table_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new XterRqstVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (columnType[i] != null)
					model.setColumnType(columnType[i]);
				if (columnNm[i] != null)
					model.setColumnNm(columnNm[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (inputValue[i] != null)
					model.setInputValue(inputValue[i]);
				if (tableNm[i] != null)
					model.setTableNm(tableNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterRqstVO[]
	 */
	public XterRqstVO[] getXterRqstVOs(){
		XterRqstVO[] vos = (XterRqstVO[])models.toArray(new XterRqstVO[models.size()]);
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
		this.columnType = this.columnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.columnNm = this.columnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputValue = this.inputValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableNm = this.tableNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
