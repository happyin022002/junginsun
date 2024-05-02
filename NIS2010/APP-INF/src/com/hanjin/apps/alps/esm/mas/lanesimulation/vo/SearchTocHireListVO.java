/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTocHireListVO.java
*@FileTitle : SearchTocHireListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.26 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.lanesimulation.vo;

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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTocHireListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTocHireListVO> models = new ArrayList<SearchTocHireListVO>();
	
	/* Column Info */
	private String vslTeuUcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toHirSeq = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String vslDlyUcAmt = null;
	/* Column Info */
	private String minSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTocHireListVO() {}

	public SearchTocHireListVO(String ibflag, String pagerows, String toHirSeq, String vslClssCapa, String vslTeuUcAmt, String vslDlyUcAmt, String minSeq) {
		this.vslTeuUcAmt = vslTeuUcAmt;
		this.ibflag = ibflag;
		this.toHirSeq = toHirSeq;
		this.vslClssCapa = vslClssCapa;
		this.vslDlyUcAmt = vslDlyUcAmt;
		this.minSeq = minSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_teu_uc_amt", getVslTeuUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_hir_seq", getToHirSeq());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("vsl_dly_uc_amt", getVslDlyUcAmt());
		this.hashColumns.put("min_seq", getMinSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_teu_uc_amt", "vslTeuUcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_hir_seq", "toHirSeq");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("vsl_dly_uc_amt", "vslDlyUcAmt");
		this.hashFields.put("min_seq", "minSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslTeuUcAmt
	 */
	public String getVslTeuUcAmt() {
		return this.vslTeuUcAmt;
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
	 * @return toHirSeq
	 */
	public String getToHirSeq() {
		return this.toHirSeq;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslDlyUcAmt
	 */
	public String getVslDlyUcAmt() {
		return this.vslDlyUcAmt;
	}
	
	/**
	 * Column Info
	 * @return minSeq
	 */
	public String getMinSeq() {
		return this.minSeq;
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
	 * @param vslTeuUcAmt
	 */
	public void setVslTeuUcAmt(String vslTeuUcAmt) {
		this.vslTeuUcAmt = vslTeuUcAmt;
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
	 * @param toHirSeq
	 */
	public void setToHirSeq(String toHirSeq) {
		this.toHirSeq = toHirSeq;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslDlyUcAmt
	 */
	public void setVslDlyUcAmt(String vslDlyUcAmt) {
		this.vslDlyUcAmt = vslDlyUcAmt;
	}
	
	/**
	 * Column Info
	 * @param minSeq
	 */
	public void setMinSeq(String minSeq) {
		this.minSeq = minSeq;
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
		setVslTeuUcAmt(JSPUtil.getParameter(request, "vsl_teu_uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToHirSeq(JSPUtil.getParameter(request, "to_hir_seq", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setVslDlyUcAmt(JSPUtil.getParameter(request, "vsl_dly_uc_amt", ""));
		setMinSeq(JSPUtil.getParameter(request, "min_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTocHireListVO[]
	 */
	public SearchTocHireListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTocHireListVO[]
	 */
	public SearchTocHireListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTocHireListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslTeuUcAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_teu_uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toHirSeq = (JSPUtil.getParameter(request, prefix	+ "to_hir_seq", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] vslDlyUcAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_dly_uc_amt", length));
			String[] minSeq = (JSPUtil.getParameter(request, prefix	+ "min_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTocHireListVO();
				if (vslTeuUcAmt[i] != null)
					model.setVslTeuUcAmt(vslTeuUcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toHirSeq[i] != null)
					model.setToHirSeq(toHirSeq[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (vslDlyUcAmt[i] != null)
					model.setVslDlyUcAmt(vslDlyUcAmt[i]);
				if (minSeq[i] != null)
					model.setMinSeq(minSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTocHireListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTocHireListVO[]
	 */
	public SearchTocHireListVO[] getSearchTocHireListVOs(){
		SearchTocHireListVO[] vos = (SearchTocHireListVO[])models.toArray(new SearchTocHireListVO[models.size()]);
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
		this.vslTeuUcAmt = this.vslTeuUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toHirSeq = this.toHirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlyUcAmt = this.vslDlyUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minSeq = this.minSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
