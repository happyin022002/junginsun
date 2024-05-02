/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSoCode0160ListVO.java
*@FileTitle : SearchSoCode0160ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.30 장영석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSoCode0160ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSoCode0160ListVO> models = new ArrayList<SearchSoCode0160ListVO>();
	
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String locGrpTpCd = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String locDeltFlg = null;
	/* Column Info */
	private String allFlg = null;
	/* Column Info */
	private String n3rdNodCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSoCode0160ListVO() {}

	public SearchSoCode0160ListVO(String ibflag, String pagerows, String locDeltFlg, 	String locGrpTpCd, String n1stNodCd, String n2ndNodCd, String n3rdNodCd, String n4thNodCd, String allFlg) {
		this.ibflag = ibflag;
		this.n4thNodCd = n4thNodCd;
		this.locGrpTpCd = locGrpTpCd;
		this.n1stNodCd = n1stNodCd;
		this.n2ndNodCd = n2ndNodCd;
		this.locDeltFlg = locDeltFlg;
		this.allFlg = allFlg;
		this.n3rdNodCd = n3rdNodCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("loc_grp_tp_cd", getLocGrpTpCd());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("loc_delt_flg", getLocDeltFlg());
		this.hashColumns.put("all_flg", getAllFlg());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("loc_grp_tp_cd", "locGrpTpCd");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("loc_delt_flg", "locDeltFlg");
		this.hashFields.put("all_flg", "allFlg");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return n4thNodCd
	 */
	public String getN4thNodCd() {
		return this.n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @return locGrpTpCd
	 */
	public String getLocGrpTpCd() {
		return this.locGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return locDeltFlg
	 */
	public String getLocDeltFlg() {
		return this.locDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return allFlg
	 */
	public String getAllFlg() {
		return this.allFlg;
	}
	
	/**
	 * Column Info
	 * @return n3rdNodCd
	 */
	public String getN3rdNodCd() {
		return this.n3rdNodCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param n4thNodCd
	 */
	public void setN4thNodCd(String n4thNodCd) {
		this.n4thNodCd = n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @param locGrpTpCd
	 */
	public void setLocGrpTpCd(String locGrpTpCd) {
		this.locGrpTpCd = locGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param locDeltFlg
	 */
	public void setLocDeltFlg(String locDeltFlg) {
		this.locDeltFlg = locDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param allFlg
	 */
	public void setAllFlg(String allFlg) {
		this.allFlg = allFlg;
	}
	
	/**
	 * Column Info
	 * @param n3rdNodCd
	 */
	public void setN3rdNodCd(String n3rdNodCd) {
		this.n3rdNodCd = n3rdNodCd;
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
		setN4thNodCd(JSPUtil.getParameter(request, "n4th_nod_cd", ""));
		setLocGrpTpCd(JSPUtil.getParameter(request, "loc_grp_tp_cd", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setLocDeltFlg(JSPUtil.getParameter(request, "loc_delt_flg", ""));
		setAllFlg(JSPUtil.getParameter(request, "all_flg", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, "n3rd_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSoCode0160ListVO[]
	 */
	public SearchSoCode0160ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSoCode0160ListVO[]
	 */
	public SearchSoCode0160ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSoCode0160ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] locGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_tp_cd", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] locDeltFlg = (JSPUtil.getParameter(request, prefix	+ "loc_delt_flg", length));
			String[] allFlg = (JSPUtil.getParameter(request, prefix	+ "all_flg", length));
			String[] n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSoCode0160ListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n4thNodCd[i] != null)
					model.setN4thNodCd(n4thNodCd[i]);
				if (locGrpTpCd[i] != null)
					model.setLocGrpTpCd(locGrpTpCd[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (locDeltFlg[i] != null)
					model.setLocDeltFlg(locDeltFlg[i]);
				if (allFlg[i] != null)
					model.setAllFlg(allFlg[i]);
				if (n3rdNodCd[i] != null)
					model.setN3rdNodCd(n3rdNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSoCode0160ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSoCode0160ListVO[]
	 */
	public SearchSoCode0160ListVO[] getSearchSoCode0160ListVOs(){
		SearchSoCode0160ListVO[] vos = (SearchSoCode0160ListVO[])models.toArray(new SearchSoCode0160ListVO[models.size()]);
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
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpTpCd = this.locGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDeltFlg = this.locDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allFlg = this.allFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
    //추가#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################	
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSetArray = null;	
	
	
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSet Array Getter */
	public DBRowSet[] getRowSetArray() {
		return rowSetArray;
	}
	/** DBRowSet Array Setter */
	public void setRowSetArray(DBRowSet[] rowSetArray) {
		this.rowSetArray = rowSetArray;
	}		
    //추가#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################   	
}
