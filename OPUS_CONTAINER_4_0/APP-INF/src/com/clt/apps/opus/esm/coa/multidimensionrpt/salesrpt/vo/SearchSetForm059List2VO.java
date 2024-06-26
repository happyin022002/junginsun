/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSetForm059List2VO.java
*@FileTitle : SearchSetForm059List2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.14 김기대 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSetForm059List2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSetForm059List2VO> models = new ArrayList<SearchSetForm059List2VO>();
	
	/* Column Info */
	private String slctItmFomDesc = null;
	/* Column Info */
	private String slctItmFomSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rptItmColNm = null;
	/* Column Info */
	private String rptItmCd = null;
	/* Column Info */
	private String rptItmDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSetForm059List2VO() {}

	public SearchSetForm059List2VO(String ibflag, String pagerows, String slctItmFomSeq, String slctItmFomDesc, String rptItmCd, String rptItmColNm, String rptItmDesc) {
		this.slctItmFomDesc = slctItmFomDesc;
		this.slctItmFomSeq = slctItmFomSeq;
		this.ibflag = ibflag;
		this.rptItmColNm = rptItmColNm;
		this.rptItmCd = rptItmCd;
		this.rptItmDesc = rptItmDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slct_itm_fom_desc", getSlctItmFomDesc());
		this.hashColumns.put("slct_itm_fom_seq", getSlctItmFomSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpt_itm_col_nm", getRptItmColNm());
		this.hashColumns.put("rpt_itm_cd", getRptItmCd());
		this.hashColumns.put("rpt_itm_desc", getRptItmDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slct_itm_fom_desc", "slctItmFomDesc");
		this.hashFields.put("slct_itm_fom_seq", "slctItmFomSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpt_itm_col_nm", "rptItmColNm");
		this.hashFields.put("rpt_itm_cd", "rptItmCd");
		this.hashFields.put("rpt_itm_desc", "rptItmDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slctItmFomDesc
	 */
	public String getSlctItmFomDesc() {
		return this.slctItmFomDesc;
	}
	
	/**
	 * Column Info
	 * @return slctItmFomSeq
	 */
	public String getSlctItmFomSeq() {
		return this.slctItmFomSeq;
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
	 * @return rptItmColNm
	 */
	public String getRptItmColNm() {
		return this.rptItmColNm;
	}
	
	/**
	 * Column Info
	 * @return rptItmCd
	 */
	public String getRptItmCd() {
		return this.rptItmCd;
	}
	
	/**
	 * Column Info
	 * @return rptItmDesc
	 */
	public String getRptItmDesc() {
		return this.rptItmDesc;
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
	 * @param slctItmFomDesc
	 */
	public void setSlctItmFomDesc(String slctItmFomDesc) {
		this.slctItmFomDesc = slctItmFomDesc;
	}
	
	/**
	 * Column Info
	 * @param slctItmFomSeq
	 */
	public void setSlctItmFomSeq(String slctItmFomSeq) {
		this.slctItmFomSeq = slctItmFomSeq;
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
	 * @param rptItmColNm
	 */
	public void setRptItmColNm(String rptItmColNm) {
		this.rptItmColNm = rptItmColNm;
	}
	
	/**
	 * Column Info
	 * @param rptItmCd
	 */
	public void setRptItmCd(String rptItmCd) {
		this.rptItmCd = rptItmCd;
	}
	
	/**
	 * Column Info
	 * @param rptItmDesc
	 */
	public void setRptItmDesc(String rptItmDesc) {
		this.rptItmDesc = rptItmDesc;
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
		setSlctItmFomDesc(JSPUtil.getParameter(request, "slct_itm_fom_desc", ""));
		setSlctItmFomSeq(JSPUtil.getParameter(request, "slct_itm_fom_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRptItmColNm(JSPUtil.getParameter(request, "rpt_itm_col_nm", ""));
		setRptItmCd(JSPUtil.getParameter(request, "rpt_itm_cd", ""));
		setRptItmDesc(JSPUtil.getParameter(request, "rpt_itm_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSetForm059List2VO[]
	 */
	public SearchSetForm059List2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSetForm059List2VO[]
	 */
	public SearchSetForm059List2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSetForm059List2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slctItmFomDesc = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_desc", length));
			String[] slctItmFomSeq = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rptItmColNm = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_col_nm", length));
			String[] rptItmCd = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_cd", length));
			String[] rptItmDesc = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSetForm059List2VO();
				if (slctItmFomDesc[i] != null)
					model.setSlctItmFomDesc(slctItmFomDesc[i]);
				if (slctItmFomSeq[i] != null)
					model.setSlctItmFomSeq(slctItmFomSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rptItmColNm[i] != null)
					model.setRptItmColNm(rptItmColNm[i]);
				if (rptItmCd[i] != null)
					model.setRptItmCd(rptItmCd[i]);
				if (rptItmDesc[i] != null)
					model.setRptItmDesc(rptItmDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSetForm059List2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSetForm059List2VO[]
	 */
	public SearchSetForm059List2VO[] getSearchSetForm059List2VOs(){
		SearchSetForm059List2VO[] vos = (SearchSetForm059List2VO[])models.toArray(new SearchSetForm059List2VO[models.size()]);
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
		this.slctItmFomDesc = this.slctItmFomDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctItmFomSeq = this.slctItmFomSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmColNm = this.rptItmColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmCd = this.rptItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmDesc = this.rptItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
