/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchReportConditionVO.java
*@FileTitle : SearchReportConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.28 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchReportConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReportConditionVO> models = new ArrayList<SearchReportConditionVO>();
	
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fSimDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fVoyView = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fSimRptNo = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String fSearchitem2 = null;
	/* Column Info */
	private String fSimNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchReportConditionVO() {}

	public SearchReportConditionVO(String ibflag, String pagerows, String fSimNo, String fSimDt, String fSimRptNo, String fTrdCd, String fVslCd, String fSearchitem2, String fVoyView, String header) {
		this.fTrdCd = fTrdCd;
		this.fSimDt = fSimDt;
		this.ibflag = ibflag;
		this.fVoyView = fVoyView;
		this.fVslCd = fVslCd;
		this.fSimRptNo = fSimRptNo;
		this.header = header;
		this.fSearchitem2 = fSearchitem2;
		this.fSimNo = fSimNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_sim_dt", getFSimDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_voy_view", getFVoyView());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_sim_rpt_no", getFSimRptNo());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("f_searchitem2", getFSearchitem2());
		this.hashColumns.put("f_sim_no", getFSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_sim_dt", "fSimDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_voy_view", "fVoyView");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_sim_rpt_no", "fSimRptNo");
		this.hashFields.put("header", "header");
		this.hashFields.put("f_searchitem2", "fSearchitem2");
		this.hashFields.put("f_sim_no", "fSimNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fSimDt
	 */
	public String getFSimDt() {
		return this.fSimDt;
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
	 * @return fVoyView
	 */
	public String getFVoyView() {
		return this.fVoyView;
	}
	
	/**
	 * Column Info
	 * @return fVslCd
	 */
	public String getFVslCd() {
		return this.fVslCd;
	}
	
	/**
	 * Column Info
	 * @return fSimRptNo
	 */
	public String getFSimRptNo() {
		return this.fSimRptNo;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Column Info
	 * @return fSearchitem2
	 */
	public String getFSearchitem2() {
		return this.fSearchitem2;
	}
	
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFSimNo() {
		return this.fSimNo;
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
	 * @param fTrdCd
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fSimDt
	 */
	public void setFSimDt(String fSimDt) {
		this.fSimDt = fSimDt;
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
	 * @param fVoyView
	 */
	public void setFVoyView(String fVoyView) {
		this.fVoyView = fVoyView;
	}
	
	/**
	 * Column Info
	 * @param fVslCd
	 */
	public void setFVslCd(String fVslCd) {
		this.fVslCd = fVslCd;
	}
	
	/**
	 * Column Info
	 * @param fSimRptNo
	 */
	public void setFSimRptNo(String fSimRptNo) {
		this.fSimRptNo = fSimRptNo;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @param fSearchitem2
	 */
	public void setFSearchitem2(String fSearchitem2) {
		this.fSearchitem2 = fSearchitem2;
	}
	
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFSimNo(String fSimNo) {
		this.fSimNo = fSimNo;
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
		setFTrdCd(JSPUtil.getParameter(request, "f_trd_cd", ""));
		setFSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFVoyView(JSPUtil.getParameter(request, "f_voy_view", ""));
		setFVslCd(JSPUtil.getParameter(request, "f_vsl_cd", ""));
		setFSimRptNo(JSPUtil.getParameter(request, "f_sim_rpt_no", ""));
		setHeader(JSPUtil.getParameter(request, "header", ""));
		setFSearchitem2(JSPUtil.getParameter(request, "f_searchItem2", ""));
		setFSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReportConditionVO[]
	 */
	public SearchReportConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReportConditionVO[]
	 */
	public SearchReportConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReportConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fSimDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fVoyView = (JSPUtil.getParameter(request, prefix	+ "f_voy_view", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fSimRptNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_rpt_no", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] fSearchitem2 = (JSPUtil.getParameter(request, prefix	+ "f_searchItem2", length));
			String[] fSimNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReportConditionVO();
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fSimDt[i] != null)
					model.setFSimDt(fSimDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fVoyView[i] != null)
					model.setFVoyView(fVoyView[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fSimRptNo[i] != null)
					model.setFSimRptNo(fSimRptNo[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (fSearchitem2[i] != null)
					model.setFSearchitem2(fSearchitem2[i]);
				if (fSimNo[i] != null)
					model.setFSimNo(fSimNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReportConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReportConditionVO[]
	 */
	public SearchReportConditionVO[] getSearchReportConditionVOs(){
		SearchReportConditionVO[] vos = (SearchReportConditionVO[])models.toArray(new SearchReportConditionVO[models.size()]);
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
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimDt = this.fSimDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVoyView = this.fVoyView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimRptNo = this.fSimRptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSearchitem2 = this.fSearchitem2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimNo = this.fSimNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	//추가
	private DBRowSet dbRowSet = null;

	public DBRowSet getDbRowSet() {
		return dbRowSet;
	}

	public void setDbRowSet(DBRowSet dbRowSet) {
		this.dbRowSet = dbRowSet;
	}
}
