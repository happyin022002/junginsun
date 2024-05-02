/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XchRtInqVO.java
*@FileTitle : XchRtInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.08 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XchRtInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XchRtInqVO> models = new ArrayList<XchRtInqVO>();
	
	/* Column Info */
	private String colDec = null;
	/* Column Info */
	private String colMar = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String colJan = null;
	/* Column Info */
	private String colSep = null;
	/* Column Info */
	private String sortNm = null;
	/* Column Info */
	private String colOct = null;
	/* Column Info */
	private String colFeb = null;
	/* Column Info */
	private String rowCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String colNov = null;
	/* Column Info */
	private String colAug = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sort1 = null;
	/* Column Info */
	private String colJul = null;
	/* Column Info */
	private String colApr = null;
	/* Column Info */
	private String colJun = null;
	/* Column Info */
	private String colMay = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XchRtInqVO() {}

	public XchRtInqVO(String ibflag, String pagerows, String sort1, String sortNm, String currCd, String colJan, String colFeb, String colMar, String colApr, String colMay, String colJun, String colJul, String colAug, String colSep, String colOct, String colNov, String colDec, String rowCnt) {
		this.colDec = colDec;
		this.colMar = colMar;
		this.currCd = currCd;
		this.colJan = colJan;
		this.colSep = colSep;
		this.sortNm = sortNm;
		this.colOct = colOct;
		this.colFeb = colFeb;
		this.rowCnt = rowCnt;
		this.pagerows = pagerows;
		this.colNov = colNov;
		this.colAug = colAug;
		this.ibflag = ibflag;
		this.sort1 = sort1;
		this.colJul = colJul;
		this.colApr = colApr;
		this.colJun = colJun;
		this.colMay = colMay;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col_dec", getColDec());
		this.hashColumns.put("col_mar", getColMar());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("col_jan", getColJan());
		this.hashColumns.put("col_sep", getColSep());
		this.hashColumns.put("sort_nm", getSortNm());
		this.hashColumns.put("col_oct", getColOct());
		this.hashColumns.put("col_feb", getColFeb());
		this.hashColumns.put("row_cnt", getRowCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("col_nov", getColNov());
		this.hashColumns.put("col_aug", getColAug());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sort1", getSort1());
		this.hashColumns.put("col_jul", getColJul());
		this.hashColumns.put("col_apr", getColApr());
		this.hashColumns.put("col_jun", getColJun());
		this.hashColumns.put("col_may", getColMay());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col_dec", "colDec");
		this.hashFields.put("col_mar", "colMar");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("col_jan", "colJan");
		this.hashFields.put("col_sep", "colSep");
		this.hashFields.put("sort_nm", "sortNm");
		this.hashFields.put("col_oct", "colOct");
		this.hashFields.put("col_feb", "colFeb");
		this.hashFields.put("row_cnt", "rowCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("col_nov", "colNov");
		this.hashFields.put("col_aug", "colAug");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sort1", "sort1");
		this.hashFields.put("col_jul", "colJul");
		this.hashFields.put("col_apr", "colApr");
		this.hashFields.put("col_jun", "colJun");
		this.hashFields.put("col_may", "colMay");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return colDec
	 */
	public String getColDec() {
		return this.colDec;
	}
	
	/**
	 * Column Info
	 * @return colMar
	 */
	public String getColMar() {
		return this.colMar;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return colJan
	 */
	public String getColJan() {
		return this.colJan;
	}
	
	/**
	 * Column Info
	 * @return colSep
	 */
	public String getColSep() {
		return this.colSep;
	}
	
	/**
	 * Column Info
	 * @return sortNm
	 */
	public String getSortNm() {
		return this.sortNm;
	}
	
	/**
	 * Column Info
	 * @return colOct
	 */
	public String getColOct() {
		return this.colOct;
	}
	
	/**
	 * Column Info
	 * @return colFeb
	 */
	public String getColFeb() {
		return this.colFeb;
	}
	
	/**
	 * Column Info
	 * @return rowCnt
	 */
	public String getRowCnt() {
		return this.rowCnt;
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
	 * @return colNov
	 */
	public String getColNov() {
		return this.colNov;
	}
	
	/**
	 * Column Info
	 * @return colAug
	 */
	public String getColAug() {
		return this.colAug;
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
	 * @return sort1
	 */
	public String getSort1() {
		return this.sort1;
	}
	
	/**
	 * Column Info
	 * @return colJul
	 */
	public String getColJul() {
		return this.colJul;
	}
	
	/**
	 * Column Info
	 * @return colApr
	 */
	public String getColApr() {
		return this.colApr;
	}
	
	/**
	 * Column Info
	 * @return colJun
	 */
	public String getColJun() {
		return this.colJun;
	}
	
	/**
	 * Column Info
	 * @return colMay
	 */
	public String getColMay() {
		return this.colMay;
	}
	

	/**
	 * Column Info
	 * @param colDec
	 */
	public void setColDec(String colDec) {
		this.colDec = colDec;
	}
	
	/**
	 * Column Info
	 * @param colMar
	 */
	public void setColMar(String colMar) {
		this.colMar = colMar;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param colJan
	 */
	public void setColJan(String colJan) {
		this.colJan = colJan;
	}
	
	/**
	 * Column Info
	 * @param colSep
	 */
	public void setColSep(String colSep) {
		this.colSep = colSep;
	}
	
	/**
	 * Column Info
	 * @param sortNm
	 */
	public void setSortNm(String sortNm) {
		this.sortNm = sortNm;
	}
	
	/**
	 * Column Info
	 * @param colOct
	 */
	public void setColOct(String colOct) {
		this.colOct = colOct;
	}
	
	/**
	 * Column Info
	 * @param colFeb
	 */
	public void setColFeb(String colFeb) {
		this.colFeb = colFeb;
	}
	
	/**
	 * Column Info
	 * @param rowCnt
	 */
	public void setRowCnt(String rowCnt) {
		this.rowCnt = rowCnt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param colNov
	 */
	public void setColNov(String colNov) {
		this.colNov = colNov;
	}
	
	/**
	 * Column Info
	 * @param colAug
	 */
	public void setColAug(String colAug) {
		this.colAug = colAug;
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
	 * @param sort1
	 */
	public void setSort1(String sort1) {
		this.sort1 = sort1;
	}
	
	/**
	 * Column Info
	 * @param colJul
	 */
	public void setColJul(String colJul) {
		this.colJul = colJul;
	}
	
	/**
	 * Column Info
	 * @param colApr
	 */
	public void setColApr(String colApr) {
		this.colApr = colApr;
	}
	
	/**
	 * Column Info
	 * @param colJun
	 */
	public void setColJun(String colJun) {
		this.colJun = colJun;
	}
	
	/**
	 * Column Info
	 * @param colMay
	 */
	public void setColMay(String colMay) {
		this.colMay = colMay;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setColDec(JSPUtil.getParameter(request, "col_dec", ""));
		setColMar(JSPUtil.getParameter(request, "col_mar", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setColJan(JSPUtil.getParameter(request, "col_jan", ""));
		setColSep(JSPUtil.getParameter(request, "col_sep", ""));
		setSortNm(JSPUtil.getParameter(request, "sort_nm", ""));
		setColOct(JSPUtil.getParameter(request, "col_oct", ""));
		setColFeb(JSPUtil.getParameter(request, "col_feb", ""));
		setRowCnt(JSPUtil.getParameter(request, "row_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setColNov(JSPUtil.getParameter(request, "col_nov", ""));
		setColAug(JSPUtil.getParameter(request, "col_aug", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSort1(JSPUtil.getParameter(request, "sort1", ""));
		setColJul(JSPUtil.getParameter(request, "col_jul", ""));
		setColApr(JSPUtil.getParameter(request, "col_apr", ""));
		setColJun(JSPUtil.getParameter(request, "col_jun", ""));
		setColMay(JSPUtil.getParameter(request, "col_may", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XchRtInqVO[]
	 */
	public XchRtInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XchRtInqVO[]
	 */
	public XchRtInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XchRtInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] colDec = (JSPUtil.getParameter(request, prefix	+ "col_dec".trim(), length));
			String[] colMar = (JSPUtil.getParameter(request, prefix	+ "col_mar".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] colJan = (JSPUtil.getParameter(request, prefix	+ "col_jan".trim(), length));
			String[] colSep = (JSPUtil.getParameter(request, prefix	+ "col_sep".trim(), length));
			String[] sortNm = (JSPUtil.getParameter(request, prefix	+ "sort_nm".trim(), length));
			String[] colOct = (JSPUtil.getParameter(request, prefix	+ "col_oct".trim(), length));
			String[] colFeb = (JSPUtil.getParameter(request, prefix	+ "col_feb".trim(), length));
			String[] rowCnt = (JSPUtil.getParameter(request, prefix	+ "row_cnt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] colNov = (JSPUtil.getParameter(request, prefix	+ "col_nov".trim(), length));
			String[] colAug = (JSPUtil.getParameter(request, prefix	+ "col_aug".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] sort1 = (JSPUtil.getParameter(request, prefix	+ "sort1".trim(), length));
			String[] colJul = (JSPUtil.getParameter(request, prefix	+ "col_jul".trim(), length));
			String[] colApr = (JSPUtil.getParameter(request, prefix	+ "col_apr".trim(), length));
			String[] colJun = (JSPUtil.getParameter(request, prefix	+ "col_jun".trim(), length));
			String[] colMay = (JSPUtil.getParameter(request, prefix	+ "col_may".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new XchRtInqVO();
				if (colDec[i] != null)
					model.setColDec(colDec[i]);
				if (colMar[i] != null)
					model.setColMar(colMar[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (colJan[i] != null)
					model.setColJan(colJan[i]);
				if (colSep[i] != null)
					model.setColSep(colSep[i]);
				if (sortNm[i] != null)
					model.setSortNm(sortNm[i]);
				if (colOct[i] != null)
					model.setColOct(colOct[i]);
				if (colFeb[i] != null)
					model.setColFeb(colFeb[i]);
				if (rowCnt[i] != null)
					model.setRowCnt(rowCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (colNov[i] != null)
					model.setColNov(colNov[i]);
				if (colAug[i] != null)
					model.setColAug(colAug[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sort1[i] != null)
					model.setSort1(sort1[i]);
				if (colJul[i] != null)
					model.setColJul(colJul[i]);
				if (colApr[i] != null)
					model.setColApr(colApr[i]);
				if (colJun[i] != null)
					model.setColJun(colJun[i]);
				if (colMay[i] != null)
					model.setColMay(colMay[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXchRtInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XchRtInqVO[]
	 */
	public XchRtInqVO[] getXchRtInqVOs(){
		XchRtInqVO[] vos = (XchRtInqVO[])models.toArray(new XchRtInqVO[models.size()]);
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
		this.colDec = this.colDec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colMar = this.colMar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colJan = this.colJan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colSep = this.colSep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortNm = this.sortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colOct = this.colOct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colFeb = this.colFeb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCnt = this.rowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNov = this.colNov .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colAug = this.colAug .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sort1 = this.sort1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colJul = this.colJul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colApr = this.colApr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colJun = this.colJun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colMay = this.colMay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
