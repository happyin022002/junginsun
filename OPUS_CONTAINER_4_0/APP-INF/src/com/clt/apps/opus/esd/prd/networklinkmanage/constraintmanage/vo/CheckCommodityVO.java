/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CheckCommodityVO.java
*@FileTitle : CheckCommodityVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.20 김귀진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CheckCommodityVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CheckCommodityVO> models = new ArrayList<CheckCommodityVO>();
	
	/* Column Info */
	private String col = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CheckCommodityVO() {}

	public CheckCommodityVO(String ibflag, String pagerows, String cmdtCd, String cmdtNm, String row, String col) {
		this.col = col;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.row = row;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col", getCol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col", "col");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("row", "row");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return col
	 */
	public String getCol() {
		return this.col;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
		setCol(JSPUtil.getParameter(request, "col", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CheckCommodityVO[]
	 */
	public CheckCommodityVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CheckCommodityVO[]
	 */
	public CheckCommodityVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CheckCommodityVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CheckCommodityVO();
				if (col[i] != null)
					model.setCol(col[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCheckCommodityVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CheckCommodityVO[]
	 */
	public CheckCommodityVO[] getCheckCommodityVOs(){
		CheckCommodityVO[] vos = (CheckCommodityVO[])models.toArray(new CheckCommodityVO[models.size()]);
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
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
